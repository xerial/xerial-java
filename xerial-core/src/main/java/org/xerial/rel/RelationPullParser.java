/*--------------------------------------------------------------------------
 *  Copyright 2008 utgenome.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// utgb-core Project
//
// ObjectStreamReader.java
// Since: Jan 5, 2009
//
// $URL: http://svn.utgenome.org/utgb/trunk/utgb/utgb-core/src/main/java/org/utgenome/format/ObjectStreamReader.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.rel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.StringUtil;
import org.xerial.util.bean.TreeNode;
import org.xerial.util.bean.TreeVisitor;

/**
 * Pull-style REL format text reader
 * 
 * @author leo
 * 
 */
public class RelationPullParser
{

    private final static char SCHEMA_SYMBOL = '>';
    private final static char ATTRIBUTE_SYMBOL = '-';
    private final static char COMMENT_SYMBOL = '#';
    private final static char HEADER_SYMBOL = '%';

    public enum Event {
        EMPTY_LINE, END_OBJECT, END_ATTRIBUTE, BEGIN_OBJECT, BEGIN_ATTRIBUTE, HEADER, COMMENT, DATA_BLOCK_BEGIN, DATA_FRAGMENT, OBJECT_LINE, DATA_BLOCK_END, END_OF_FILE
    }

    private enum ParseState {
        Default, InDataBlock,
    }

    private final BufferedReader input;
    private Deque<EventHolder> eventQueue = new ArrayDeque<EventHolder>();
    private Deque<SchemaElement> schemaStack = new ArrayDeque<SchemaElement>();
    private int lineCount = 0;
    private String currentLine;
    private ParseState state = ParseState.Default;
    private EventHolder currentEvent = null;

    private class EventHolder
    {
        Event event;
        int lineNumber;
        int level;
        String line;
        SchemaElement schema;

        public EventHolder(Event event)
        {
            this.event = event;
            this.lineNumber = lineCount;
            this.level = schemaStack.size();
            this.line = RelationPullParser.this.currentLine;
            this.schema = schemaStack.isEmpty() ? null : schemaStack.getLast();
        }
    }

    public RelationPullParser(Reader input)
    {
        this.input = new BufferedReader(input);
        //schemaStack.add(new ObjectSchema("rel"));
    }

    public Event getCurrentEvent()
    {
        return getCurrentEventHolder().event;
    }

    protected void pushEvent(Event eventType)
    {
        eventQueue.add(new EventHolder(eventType));
    }

    public Event next() throws XerialException
    {
        if (!eventQueue.isEmpty())
        {
            currentEvent = eventQueue.getFirst();
            if (currentEvent.event != Event.END_OF_FILE)
                eventQueue.removeFirst();

            return currentEvent.event;
        }

        try
        {
            currentLine = input.readLine();
            if (currentLine == null)
            {
                adjustLevel(0);
                pushEvent(Event.END_OF_FILE);
                return next();
            }

            lineCount++;
            if (currentLine.length() > 0)
            {
                if (currentLine.startsWith("---"))
                {
                    adjustLevel(schemaStack.size());
                    //pushEvent(Event.END_OBJECT);
                    return next();
                }

                try
                {
                    switch (currentLine.charAt(0))
                    {
                    case SCHEMA_SYMBOL:
                    {
                        ObjectSchema schema = ObjectSchema.parseSchemaLine(currentLine);
                        adjustLevel(schema.getLevel());
                        schemaStack.add(schema);
                        pushEvent(Event.BEGIN_OBJECT);
                        if (schema.isFollowedByStreamData())
                        {
                            pushEvent(Event.DATA_BLOCK_BEGIN);
                            state = ParseState.InDataBlock;
                        }
                        return next();
                    }
                    case ATTRIBUTE_SYMBOL:
                    {
                        ObjectAttribute attribute = ObjectAttribute.parseAttributeLine(currentLine);
                        popAttribute();
                        schemaStack.add(attribute);
                        pushEvent(Event.BEGIN_ATTRIBUTE);
                        if (attribute.isFollowedByStreamData())
                        {
                            pushEvent(Event.DATA_BLOCK_BEGIN);
                            state = ParseState.InDataBlock;
                        }
                        return next();
                    }
                    case COMMENT_SYMBOL:
                        pushEvent(Event.COMMENT);
                        return next();
                    case HEADER_SYMBOL:
                        if (lineCount != 1)
                        {
                            throw new XerialException(XerialErrorCode.SYNTAX_ERROR,
                                    "% rel header must be the first line");
                        }
                        pushEvent(Event.HEADER);
                        return next();
                    default:
                    {
                        Event nextEvent = Event.OBJECT_LINE;
                        if (state == ParseState.InDataBlock)
                        {
                            nextEvent = Event.DATA_FRAGMENT;
                        }
                        else
                        {
                            if (StringUtil.isWhiteSpace(currentLine))
                                nextEvent = Event.EMPTY_LINE;
                            else
                                popAttribute();
                        }

                        pushEvent(nextEvent);
                        return next();
                    }
                    }
                }
                catch (XerialException e)
                {
                    throw new XerialException(XerialErrorCode.SYNTAX_ERROR, String.format("line=%d, %s", lineCount, e
                            .getMessage()));
                }

            }
            pushEvent(Event.EMPTY_LINE);
            return next();
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.READ_ERROR, e);
        }
    }

    private void popAttribute()
    {
        if (state == ParseState.InDataBlock)
        {
            pushEvent(Event.DATA_BLOCK_END);
            state = ParseState.Default;
        }

        // pop attribute element
        SchemaElement currentSchema = getCurrentSchema();
        if (currentSchema != null && getCurrentSchema().isAttribute())
        {
            pushEvent(Event.END_ATTRIBUTE);
            schemaStack.removeLast();
        }
    }

    private void adjustLevel(int newLevel)
    {
        if (newLevel < 0)
            return;

        popAttribute();

        // adjust to the target level
        while (schemaStack.size() > 0 && schemaStack.size() >= newLevel)
        {
            pushEvent(Event.END_OBJECT);
            schemaStack.removeLast();
        }
    }

    public SchemaElement getCurrentSchema()
    {
        return getCurrentEventHolder().schema;
    }

    private EventHolder getCurrentEventHolder()
    {
        if (currentEvent == null)
            throw new XerialError(XerialErrorCode.NOT_READY,
                    "next() method must be invoked at least once before retrieving the current event");
        return currentEvent;
    }

    public int getLineCount()
    {
        return getCurrentEventHolder().lineNumber;
    }

    /**
     * Get the current input data line
     * 
     * @return
     */
    public String getLine()
    {
        return getCurrentEventHolder().line;
    }

    public static void walkObjectLine(SchemaElement schema, String line, TreeVisitor visitor)
    {

    }

    public int getCurrentLevel()
    {
        return getCurrentEventHolder().level;
    }

    public TreeNode getSubTree()
    {
        return new SubtreeBuilder().parse();
    }

    private class RelTreeNode implements TreeNode
    {

        public List<TreeNode> getChildren()
        {
            // TODO Auto-generated method stub
            return null;
        }

        public String getNodeName()
        {
            // TODO Auto-generated method stub
            return null;
        }

        public String getNodeValue()
        {
            // TODO Auto-generated method stub
            return null;
        }

        public void addChild(RelTreeNode child)
        {
        // TODO impl
        }

    }

    private class SubtreeBuilder
    {
        public TreeNode parse()
        {
            RelTreeNode subtreeRoot = new RelTreeNode();
            return parse(subtreeRoot);
        }

        public TreeNode parse(RelTreeNode parent)
        {
            Event event;
            while ((event = getCurrentEvent()) != Event.END_OF_FILE)
            {
                switch (event)
                {
                case BEGIN_OBJECT:
                case BEGIN_ATTRIBUTE:
                case END_OBJECT:
                case END_ATTRIBUTE:
                    break;

                case DATA_BLOCK_BEGIN:
                    break;
                case DATA_FRAGMENT:
                    break;
                case DATA_BLOCK_END:
                    break;

                case OBJECT_LINE:
                    parent.addChild(parseObject(getCurrentSchema()));
                    break;
                case COMMENT:
                case HEADER:
                case EMPTY_LINE:
                    break;
                }

            }
            return null;
        }

        public RelTreeNode parseObject(SchemaElement schema)
        {

            return null;
        }

    }

}

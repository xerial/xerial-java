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
import java.util.ArrayList;
import java.util.LinkedList;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.StringUtil;

/**
 * Pull-style REL format text reader
 * 
 * @author leo
 * 
 */
public class RelationStreamReader
{

    private final static char SCHEMA_SYMBOL = '>';
    private final static char ATTRIBUTE_SYMBOL = '-';
    private final static char COMMENT_SYMBOL = '#';
    private final static char HEADER_SYMBOL = '%';

    public enum Event {
        EMPTY_LINE, END_SCOPE, OBJECT_SCHEMA, ATTRIBUTE, HEADER, COMMENT, DATA_BLOCK_BEGIN, DATA_FRAGMENT, DATA_LINE, DATA_BLOCK_END, END_OF_FILE
    }

    private enum ParseState {
        Default, InDataBlock,
    }

    private final BufferedReader input;
    private LinkedList<EventHolder> eventQueue = new LinkedList<EventHolder>();
    private ArrayList<SchemaElement> schemaStack = new ArrayList<SchemaElement>();
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

        public EventHolder(Event event)
        {
            this.event = event;
            this.lineNumber = lineCount;
            this.level = schemaStack.size();
            this.line = RelationStreamReader.this.currentLine;
        }
    }

    public RelationStreamReader(Reader input)
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
                    adjustLevel(schemaStack.size() - 1);
                    pushEvent(Event.END_SCOPE);
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
                        pushEvent(Event.OBJECT_SCHEMA);
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
                        pushEvent(Event.ATTRIBUTE);
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
                        Event nextEvent = (state == ParseState.InDataBlock) ? Event.DATA_FRAGMENT : Event.DATA_LINE;
                        if (StringUtil.isWhiteSpace(currentLine))
                            return Event.EMPTY_LINE;
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

    public void popAttribute()
    {
        if (state == ParseState.InDataBlock)
        {
            pushEvent(Event.DATA_BLOCK_END);
            state = ParseState.Default;
        }

        // pop attribute element
        SchemaElement currentSchema = getCurrentSchema();
        if (currentSchema != null && getCurrentSchema().isAttribute())
            schemaStack.remove(schemaStack.size() - 1);
    }

    private void adjustLevel(int newLevel)
    {
        if (newLevel < 0)
            return;

        popAttribute();

        // adjust to the target level
        while (schemaStack.size() > newLevel)
        {
            pushEvent(Event.END_SCOPE);
            schemaStack.remove(schemaStack.size() - 1);
        }
    }

    public SchemaElement getCurrentSchema()
    {
        if (schemaStack.isEmpty())
            return null;
        else
            return schemaStack.get(schemaStack.size() - 1);
    }

    protected EventHolder getCurrentEventHolder()
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

    public int getCurrentLevel()
    {
        return getCurrentEventHolder().level;
    }

}

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

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * 
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
        NOT_READY, EMPTY_LINE, SCOPE_DELIMITER, OBJECT_SCHEMA, ATTRIBUTE, HEADER, COMMENT, DATA_BLOCK_BEGIN, DATA, DATA_BLOCK_END, END_OF_FILE
    }

    private enum ParseState {
        Root, InDataBlock,
    }

    private final BufferedReader input;
    private LinkedList<Event> eventQueue = new LinkedList<Event>();
    private ArrayList<SchemaElement> schemaStack = new ArrayList<SchemaElement>();
    int lineCount = 0;

    public RelationStreamReader(Reader input)
    {
        this.input = new BufferedReader(input);
        schemaStack.add(new ObjectSchema("rel"));
    }

    public Event getCurrentEvent()
    {
        if (eventQueue.isEmpty())
            return Event.NOT_READY;
        else
            return eventQueue.getLast();
    }

    public int getCurrentLevel()
    {
        return schemaStack.size();
    }

    public Event next() throws XerialException
    {
        try
        {
            String line = input.readLine();
            if (line == null)
                return Event.END_OF_FILE;

            lineCount++;
            if (line.length() > 0)
            {
                if (line.startsWith("---"))
                {
                    adjustLevel(schemaStack.size() - 1);
                    return Event.SCOPE_DELIMITER;
                }

                try
                {
                    switch (line.charAt(0))
                    {
                    case SCHEMA_SYMBOL:
                    {
                        ObjectSchema schema = ObjectSchema.parseSchemaLine(line);
                        adjustLevel(schema.getLevel());
                        schemaStack.add(schema);
                        return Event.OBJECT_SCHEMA;
                    }
                    case ATTRIBUTE_SYMBOL:
                    {
                        ObjectAttribute attribute = ObjectAttribute.parseAttributeLine(line);
                        popAttribute();
                        schemaStack.add(attribute);
                        return Event.ATTRIBUTE;
                    }
                    case COMMENT_SYMBOL:
                        return Event.COMMENT;
                    case HEADER_SYMBOL:
                        return Event.HEADER;
                    default:
                        return Event.DATA;
                    }
                }
                catch (XerialException e)
                {
                    throw new XerialException(XerialErrorCode.SYNTAX_ERROR, String.format("line=%d, %s", lineCount, e
                            .getMessage()));
                }

            }
            return Event.EMPTY_LINE;
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.READ_ERROR, e);
        }
    }

    public void popAttribute()
    {
        // pop attribute element
        if (currentSchema().isAttribute())
            schemaStack.remove(schemaStack.size() - 1);
    }

    private void adjustLevel(int newLevel)
    {
        if (newLevel == 0)
            return;

        popAttribute();

        // adjust to the target level
        while (schemaStack.size() >= newLevel)
            schemaStack.remove(schemaStack.size() - 1);
    }

    public SchemaElement currentSchema()
    {
        return schemaStack.get(schemaStack.size() - 1);
    }

    public int getLineCount()
    {
        return lineCount;
    }

}

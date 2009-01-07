/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// XerialJ
//
// RelationWalker.java
// Since: Jan 7, 2009 4:08:43 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.rel;

import java.io.Reader;
import java.util.HashSet;
import java.util.LinkedList;

import org.xerial.core.XerialException;
import org.xerial.rel.RelationPullParser.Event;
import org.xerial.util.bean.TreeNode;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.TreeWalker;

/**
 * {@link TreeWalker} for the REL file format
 * 
 * @author leo
 * 
 */
public class RelationWalker implements TreeWalker
{
    private RelationPullParser parser;

    public RelationWalker(Reader input)
    {
        this.parser = new RelationPullParser(input);
    }

    private LinkedList<SchemaElement> schemaStack = new LinkedList<SchemaElement>();
    private boolean skipDescendants = false;
    private int skipLevel = Integer.MAX_VALUE;

    private HashSet<SchemaElement> processedObjectSchemaSet = new HashSet<SchemaElement>();

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);

        Event event;
        while ((event = parser.next()) != Event.END_OF_FILE)
        {
            switch (event)
            {
            case BEGIN_OBJECT:
            case BEGIN_ATTRIBUTE:
            {
                if (skipDescendants)
                    break;

                SchemaElement schema = parser.getCurrentSchema();
                schemaStack.add(schema);
            }
                break;
            case END_OBJECT:
            case END_ATTRIBUTE:
            {
                if (skipDescendants)
                {
                    if (skipLevel == parser.getCurrentLevel())
                        skipDescendants = false;
                    else
                        break;
                }

                SchemaElement schema = schemaStack.pop();
                if (!processedObjectSchemaSet.contains(schema))
                    walkSchemaLine(schema, visitor);
                else
                    processedObjectSchemaSet.remove(schema);
            }
                break;
            case DATA_BLOCK_BEGIN:
                break;
            case DATA_BLOCK_END:
                break;
            case OBJECT_LINE:
            {
                if (skipDescendants)
                    break;

                walkObjectLine(visitor);
                break;
            }
            case DATA_FRAGMENT:
            {
                if (skipDescendants)
                    break;

                break;
            }
            case COMMENT:
            case HEADER:
            case EMPTY_LINE:
            default:
                break;
            }

        }

        visitor.finish(this);
    }

    public void walkSchemaLine(SchemaElement schema, TreeVisitor visitor) throws XerialException
    {

        if (schema.isObject())
        {
            visitor.visitNode(schema.getName(), this);
            ObjectSchema objectSchema = ObjectSchema.class.cast(schema);

            int attributeIndex = 0;
            while (attributeIndex < objectSchema.size())
            {
                SchemaElement attributeSchema = objectSchema.get(attributeIndex++);
                if (attributeSchema.hasValue())
                {
                    visitor.visitNode(attributeSchema.getName(), this);
                    visitor.leaveNode(attributeSchema.getName(), attributeSchema.getValue(), this);
                }
            }
            visitor.leaveNode(schema.getName(), null, this);
        }
        else
        {
            // attribute
            visitor.visitNode(schema.getName(), this);
            visitor.leaveNode(schema.getName(), schema.getValue(), this);
        }

    }

    public void walkObjectLine(TreeVisitor visitor) throws XerialException
    {
        String line = parser.getLine();
        SchemaElement schema = parser.getCurrentSchema();

        if (schema.isObject())
        {
            ObjectSchema objectSchema = ObjectSchema.class.cast(schema);
            processedObjectSchemaSet.add(objectSchema);

            visitor.visitNode(objectSchema.getName(), this);

            // TODO coping with csv, gzipped data etc.
            String[] columns = line.split("\t");

            int attributeIndex = 0;
            for (String eachColumn : columns)
            {

                while (attributeIndex < objectSchema.size())
                {
                    SchemaElement attributeSchema = objectSchema.get(attributeIndex++);
                    if (attributeSchema.hasValue())
                    {
                        visitor.visitNode(attributeSchema.getName(), this);
                        // TODO parse nested structure
                        visitor.leaveNode(attributeSchema.getName(), attributeSchema.getValue(), this);
                    }
                    else
                    {
                        visitor.visitNode(attributeSchema.getName(), this);
                        // TODO parse nested structure
                        visitor.leaveNode(attributeSchema.getName(), eachColumn, this);
                        break;
                    }
                }

            }

            visitor.leaveNode(objectSchema.getName(), null, this);
        }

    }

    public TreeNode getSubTree() throws XerialException
    {
        skipDescendants();

        return null;
    }

    public void skipDescendants()
    {
        skipDescendants = true;
    }

    //    private class RelTreeNodeImpl implements TreeNode
    //    {
    //        
    //    }

}

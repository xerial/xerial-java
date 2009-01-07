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
import java.util.LinkedList;

import org.xerial.core.XerialException;
import org.xerial.rel.RelationPullParser.Event;
import org.xerial.util.bean.TreeNode;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.TreeWalker;
import org.xerial.util.log.Logger;

/**
 * {@link TreeWalker} for the REL file format
 * 
 * @author leo
 * 
 */
public class RelationWalker implements TreeWalker
{
    private static Logger _logger = Logger.getLogger(RelationWalker.class);

    private RelationPullParser parser;

    public RelationWalker(Reader input)
    {
        this.parser = new RelationPullParser(input);
    }

    private LinkedList<Integer> objectLineCount = new LinkedList<Integer>();
    private boolean skipDescendants = false;
    private int skipLevel = Integer.MAX_VALUE;

    public void walk(TreeVisitor visitor) throws XerialException
    {
        visitor.init(this);

        Event event;
        while ((event = parser.next()) != Event.END_OF_FILE)
        {
            _logger.debug(event);
            switch (event)
            {
            case BEGIN_OBJECT:
            {
                if (skipDescendants)
                    break;

                objectLineCount.add(0);
                SchemaElement schema = parser.getCurrentSchema();
                walkObject(schema, visitor);
                break;
            }
            case BEGIN_ATTRIBUTE:
            {
                if (skipDescendants)
                    break;

                SchemaElement schema = parser.getCurrentSchema();
                walkAttribute(schema, visitor);
                break;
            }
            case END_OBJECT:
            {
                if (skipDescendants)
                {
                    if (skipLevel == parser.getCurrentLevel())
                        skipDescendants = false;
                    else
                        break;
                }

                if (!objectLineCount.isEmpty())
                    objectLineCount.removeLast();
                break;
            }
            case END_ATTRIBUTE:
            {
                if (skipDescendants)
                {
                    if (skipLevel == parser.getCurrentLevel())
                        skipDescendants = false;
                    else
                        break;
                }
                return;
            }
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

    void walkObject(SchemaElement schema, TreeVisitor visitor) throws XerialException
    {
        ObjectSchema objectSchema = ObjectSchema.class.cast(schema);
        beginObject(objectSchema, visitor);

        walk(visitor);

        visitor.leaveNode(schema.getName(), null, this);
    }

    void beginObject(ObjectSchema objectSchema, TreeVisitor visitor) throws XerialException
    {
        visitor.visitNode(objectSchema.getName(), this);

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
    }

    void walkAttribute(SchemaElement schema, TreeVisitor visitor) throws XerialException
    {
        // attribute
        visitor.visitNode(schema.getName(), this);
        walk(visitor);
        visitor.leaveNode(schema.getName(), schema.getValue(), this);
    }

    void walkObjectLine(TreeVisitor visitor) throws XerialException
    {
        String line = parser.getLine();
        SchemaElement schema = parser.getCurrentSchema();

        ObjectSchema objectSchema = ObjectSchema.class.cast(schema);
        int numGeneratedObject = objectLineCount.removeLast();

        if (numGeneratedObject > 0)
        {
            visitor.leaveNode(objectSchema.getName(), null, this);
            beginObject(objectSchema, visitor);
        }

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

        //visitor.leaveNode(objectSchema.getName(), null, this);

        objectLineCount.add(numGeneratedObject + 1);

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

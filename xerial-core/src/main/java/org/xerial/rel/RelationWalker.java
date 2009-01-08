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

import org.xerial.core.XerialException;
import org.xerial.rel.RelationPullParser.Event;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
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

    private enum Scope {
        InObject, InAttribute
    }

    private Deque<Context> contextStack = new ArrayDeque<Context>();
    private boolean skipDescendants = false;
    private int skipLevel = Integer.MAX_VALUE;

    private class Context
    {
        SchemaElement schema;
        boolean isOpen = false;
        Scope scope;

        public Context(Scope scope)
        {
            schema = parser.getCurrentSchema();
            this.scope = scope;
        }

        public boolean isOpen()
        {
            return isOpen;
        }

        @Override
        public String toString()
        {
            return String.format("%s (%s)", schema, isOpen);
        }

    }

    private void pushContext(Scope scope)
    {
        contextStack.addLast(new Context(scope));
    }

    private Context peekLastContext()
    {
        return contextStack.peekLast();
    }

    private void popContext()
    {
        if (!contextStack.isEmpty())
            contextStack.removeLast();
    }

    public void walk(TreeVisitor visitor) throws XerialException
    {

        visitor.init(this);

        Event event;
        while ((event = parser.next()) != Event.END_OF_FILE)
        {
            if (_logger.isDebugEnabled())
                _logger.debug(event);

            switch (event)
            {
            case BEGIN_OBJECT:
            {
                if (skipDescendants)
                    break;

                preprocess(visitor);
                pushContext(Scope.InObject);
                break;
            }
            case BEGIN_ATTRIBUTE:
            {
                if (skipDescendants)
                    break;

                preprocess(visitor);
                pushContext(Scope.InAttribute);
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

                preprocess(visitor);
                Context currentContext = peekLastContext();
                if (currentContext.isOpen)
                {
                    visitor.leaveNode(currentContext.schema.getName(), null, this);
                }
                popContext();
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

                preprocess(visitor);
                popContext();
                break;
            }
            case DATA_BLOCK_BEGIN:
                break;
            case DATA_BLOCK_END:
                break;
            case OBJECT_LINE:
            {
                if (skipDescendants)
                    break;

                reportObjectLine(visitor);
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

    protected void preprocess(TreeVisitor visitor) throws XerialException
    {
        if (!contextStack.isEmpty())
        {
            Context prevContext = peekLastContext();
            if (!peekLastContext().isOpen)
            {
                openContext(prevContext, visitor);
            }
        }
    }

    protected void openContext(Context context, TreeVisitor visitor) throws XerialException
    {
        SchemaElement schema = context.schema;
        visitor.visitNode(schema.getName(), this);
        context.isOpen = true;

        if (schema.isObject())
        {
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
        }
        else
        {
            ObjectAttribute attribute = ObjectAttribute.class.cast(schema);
            visitor.leaveNode(attribute.getName(), attribute.getValue(), this);
        }

    }

    void reportObjectLine(TreeVisitor visitor) throws XerialException
    {
        String line = parser.getLine();
        Context currentContext = peekLastContext();
        ObjectSchema objectSchema = ObjectSchema.class.cast(currentContext.schema);

        // case: begin_object - (openContext) - attribute - (*) - object_line      [ report_attributes  ]
        // case: begin_object - (openContext) (*) - object_line - object_line    [ report_attributes  ]
        // case: begin_object - (openContext) - object_line - (*) - object_line    [ leave, openContext, report_attributes ] 
        // case: begin_object - (openContext) - object_line - attribute - (*) - object_line    [ leave, openContext, report_attributes ]  

        /*
         * case 1:
         * 
         * begin_object
         * -(openContext)
         * -  attribute        
         * -  object_line  
         * -(closeContext)
         * 
         * -(openContext)
         * - object_line  
         * -(closeContext)
         * end_object
         */

        /*
         * case 2:
         * 
         * begin_object
         * -(openContext)
         * -  object_line
         * -  attribute  
         * -(closeContext)
         * 
         * -(openContext)
         * - object_line  
         * -(closeContext)
         * end_object
         */

        /* 
         * case 3
         * 
         * begin_object
         * (openContext)    -- preprocess()
         * (closeContext)
         * end_object
         * 
         * 
         */

        if (currentContext.isOpen)
        {
            // close the context
            visitor.leaveNode(objectSchema.getName(), null, this);
            openContext(currentContext, visitor);
        }
        else
        {
            openContext(currentContext, visitor);
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
        currentContext.isOpen = true;

    }

    public TreeNode getSubTree() throws XerialException
    {
        skipDescendants();

        // TODO retrieve the subtree
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

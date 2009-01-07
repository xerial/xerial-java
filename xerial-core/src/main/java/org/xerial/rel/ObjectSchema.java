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
// utgb-core Project
//
// ObjectSchema.java
// Since: Jan 5, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.rel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.rel.impl.ObjectSchemaLexer;
import org.xerial.rel.impl.ObjectSchemaParser;
import org.xerial.util.StringUtil;
import org.xerial.util.TernaryBoolean;
import org.xerial.util.antlr.ANTLRUtil;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.log.Logger;

/**
 * ObjectSchema represents the schema definition of succeeding text data.
 * 
 * @author leo
 * 
 */
public class ObjectSchema extends SchemaElement
{

    private static Logger _logger = Logger.getLogger(ObjectSchema.class);

    private int level = 0;
    private ArrayList<SchemaElement> schemaElements = new ArrayList<SchemaElement>();
    private TernaryBoolean isFollowedByStreamData = TernaryBoolean.UNKNOWN;

    public ObjectSchema()
    {}

    public ObjectSchema(String name)
    {
        this.setName(name);
    }

    public boolean isObject()
    {
        return !isAttribute();
    }

    public boolean isAttribute()
    {
        return getName() == NULL_STR;
    }

    @Override
    public boolean isFollowedByStreamData()
    {
        if (isFollowedByStreamData == TernaryBoolean.UNKNOWN)
        {
            isFollowedByStreamData = TernaryBoolean.FALSE;
            for (SchemaElement each : schemaElements)
            {
                if (each.getOccurrence().isFollowedByStreamData())
                {
                    isFollowedByStreamData = TernaryBoolean.TRUE;
                    break;
                }
            }
        }

        return isFollowedByStreamData.getBoolean();
    }

    public void addLevel(String level)
    {
        this.level++;
    }

    public int getLevel()
    {
        return level;
    }

    public void addObjectAttribute(ObjectAttribute attribute)
    {
        this.schemaElements.add(attribute);
    }

    public void addObjectSchema(ObjectSchema schema)
    {
        this.schemaElements.add(schema);
    }

    public List<SchemaElement> getSchemaElementList()
    {
        return schemaElements;
    }

    @Override
    public String toString()
    {
        return String.format("%s(%s)", getName(), StringUtil.join(schemaElements, ", "));
    }

    @SuppressWarnings("unchecked")
    public static List<String> prettyPrintTokenList(List tokenList)
    {
        ArrayList<String> result = new ArrayList<String>();
        for (Iterator it = tokenList.iterator(); it.hasNext();)
        {
            Token t = (Token) it.next();
            result.add(prettyPrint(t));
        }
        return result;
    }

    public static String prettyPrint(Token t)
    {
        int charStart = t.getCharPositionInLine();
        int charEnd = charStart + t.getText().length();
        return String.format("line %3d (%2d-%2d): %s: %s", t.getLine(), charStart, charEnd, t.getType(), ANTLRUtil
                .toVisibleString(t.getText()));
    }

    public static ObjectSchema parseSchemaLine(String line) throws XerialException
    {
        ObjectSchemaLexer lexer = new ObjectSchemaLexer(new ANTLRStringStream(line));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        //_logger.debug("\n" + StringUtil.join(prettyPrintTokenList(tokenStream.getTokens()), ",\n"));
        ObjectSchemaParser parser = new ObjectSchemaParser(tokenStream);
        try
        {
            ObjectSchemaParser.objectSchema_return ret = parser.objectSchema();
            CommonTree parseTree = (CommonTree) ret.getTree();
            //_logger.debug("\n" + ANTLRUtil.parseTree(parseTree, ObjectSchemaParser.tokenNames));
            ObjectSchema schema = BeanUtilImpl.createBeanFromParseTree(ObjectSchema.class, parseTree,
                    ObjectSchemaParser.tokenNames);
            return schema;
        }
        catch (RecognitionException e)
        {
            throw new XerialException(XerialErrorCode.SYNTAX_ERROR, e.getMessage());
        }
        catch (XerialException e)
        {
            throw new XerialException(XerialErrorCode.INVALID_INPUT, e.getMessage());
        }
    }
}

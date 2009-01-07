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
// ObjectAttribute.java
// Since: Jan 5, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.rel;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.rel.impl.ObjectSchemaLexer;
import org.xerial.rel.impl.ObjectSchemaParser;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.log.Logger;

/**
 * The attribute definition in an {@link ObjectSchema}
 * 
 * @author leo
 * 
 */
public class ObjectAttribute extends SchemaElement
{
    private static Logger _logger = Logger.getLogger(ObjectAttribute.class);
    private final static String DEFAULT_TYPE = "default";

    private String value = null;
    private String dataType = DEFAULT_TYPE;

    public ObjectAttribute()
    {}

    @Override
    public boolean isFollowedByStreamData()
    {
        return getOccurrence().isFollowedByStreamData();
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public boolean isAttribute()
    {
        return true;
    }

    @Override
    public boolean isObject()
    {
        return !isAttribute();
    }

    @Override
    public String toString()
    {
        String attributeName = String.format("%s[%s]", getName(), getDataType());

        if (value == null)
            return attributeName;
        else
            return String.format("%s:%s", attributeName, value);
    }

    public void setDataType(String type)
    {
        this.dataType = type;
    }

    public String getDataType()
    {
        return dataType;
    }

    public static ObjectAttribute parseAttributeLine(String line) throws XerialException
    {
        ObjectSchemaLexer lexer = new ObjectSchemaLexer(new ANTLRStringStream(line));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        //_logger.debug("\n" + StringUtil.join(prettyPrintTokenList(tokenStream.getTokens()), ",\n"));
        ObjectSchemaParser parser = new ObjectSchemaParser(tokenStream);
        try
        {
            ObjectSchemaParser.attributeSchema_return ret = parser.attributeSchema();
            CommonTree parseTree = (CommonTree) ret.getTree();
            //_logger.debug("\n" + ANTLRUtil.parseTree(parseTree, ObjectSchemaParser.tokenNames));
            ObjectAttribute attribute = BeanUtilImpl.createBeanFromParseTree(ObjectAttribute.class, parseTree,
                    ObjectSchemaParser.tokenNames);
            return attribute;
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

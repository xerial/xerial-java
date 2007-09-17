/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// ParseStatus.java
// Since: 2005/07/24 2:22:02
//
// $URL$
// $Author$
//--------------------------------------
/**
 * 
 */
package org.xerial.util.xml.pullparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * XmlPullParser のうち、parsingの状態を変えるメソッド呼び出しを禁じたクラス。
 * next()等を呼び出すと、ForbiddenOperationExceptionを発生させる。
 * 
 * @author leo
 *
 */
public class ParseContext implements XmlPullParser
{
    private XmlPullParser _parser;
    
    /**
     * 
     */
    public ParseContext(XmlPullParser pullParser)
    {
        _parser = pullParser;
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#setFeature(java.lang.String, boolean)
     */
    public void setFeature(String arg0, boolean arg1) throws XmlPullParserException
    {
        _parser.setFeature(arg0, arg1);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getFeature(java.lang.String)
     */
    public boolean getFeature(String arg0)
    {
        return _parser.getFeature(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#setProperty(java.lang.String, java.lang.Object)
     */
    public void setProperty(String arg0, Object arg1) throws XmlPullParserException
    {
        throw new ForbiddenOperationException("setProperty");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getProperty(java.lang.String)
     */
    public Object getProperty(String arg0)
    {
        return _parser.getProperty(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#setInput(java.io.Reader)
     */
    public void setInput(Reader arg0) throws XmlPullParserException
    {
        throw new ForbiddenOperationException("setInput");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#setInput(java.io.InputStream, java.lang.String)
     */
    public void setInput(InputStream arg0, String arg1) throws XmlPullParserException
    {
        throw new ForbiddenOperationException("setInput");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getInputEncoding()
     */
    public String getInputEncoding()
    {
        return _parser.getInputEncoding();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#defineEntityReplacementText(java.lang.String, java.lang.String)
     */
    public void defineEntityReplacementText(String arg0, String arg1) throws XmlPullParserException
    {
        throw new ForbiddenOperationException("defineEntityReplacementText");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getNamespaceCount(int)
     */
    public int getNamespaceCount(int arg0) throws XmlPullParserException
    {
        return _parser.getNamespaceCount(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getNamespacePrefix(int)
     */
    public String getNamespacePrefix(int arg0) throws XmlPullParserException
    {
        return _parser.getNamespacePrefix(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getNamespaceUri(int)
     */
    public String getNamespaceUri(int arg0) throws XmlPullParserException
    {
        return _parser.getNamespaceUri(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getNamespace(java.lang.String)
     */
    public String getNamespace(String arg0)
    {
        return _parser.getNamespace(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getDepth()
     */
    public int getDepth()
    {
        return _parser.getDepth();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getPositionDescription()
     */
    public String getPositionDescription()
    {
        return _parser.getPositionDescription();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getLineNumber()
     */
    public int getLineNumber()
    {
        return _parser.getLineNumber();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getColumnNumber()
     */
    public int getColumnNumber()
    {
        return _parser.getColumnNumber();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#isWhitespace()
     */
    public boolean isWhitespace() throws XmlPullParserException
    {
        return _parser.isWhitespace();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getText()
     */
    public String getText()
    {
        return _parser.getText();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getTextCharacters(int[])
     */
    public char[] getTextCharacters(int[] arg0)
    {
        return _parser.getTextCharacters(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getNamespace()
     */
    public String getNamespace()
    {
        return _parser.getNamespace();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getName()
     */
    public String getName()
    {
        return _parser.getName();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getPrefix()
     */
    public String getPrefix()
    {
        return _parser.getPrefix();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#isEmptyElementTag()
     */
    public boolean isEmptyElementTag() throws XmlPullParserException
    {
        return _parser.isEmptyElementTag();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeCount()
     */
    public int getAttributeCount()
    {
        return _parser.getAttributeCount();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeNamespace(int)
     */
    public String getAttributeNamespace(int arg0)
    {
        return _parser.getAttributeNamespace(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeName(int)
     */
    public String getAttributeName(int arg0)
    {
        return _parser.getAttributeName(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributePrefix(int)
     */
    public String getAttributePrefix(int arg0)
    {
        return _parser.getAttributePrefix(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeType(int)
     */
    public String getAttributeType(int arg0)
    {
        return _parser.getAttributeType(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#isAttributeDefault(int)
     */
    public boolean isAttributeDefault(int arg0)
    {
        return _parser.isAttributeDefault(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeValue(int)
     */
    public String getAttributeValue(int arg0)
    {
        return _parser.getAttributeName(arg0);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getAttributeValue(java.lang.String, java.lang.String)
     */
    public String getAttributeValue(String arg0, String arg1)
    {
        return _parser.getAttributeValue(arg0, arg1);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#getEventType()
     */
    public int getEventType() throws XmlPullParserException
    {
        return _parser.getEventType();
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#next()
     */
    public int next() throws XmlPullParserException, IOException
    {
        throw new ForbiddenOperationException("next");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#nextToken()
     */
    public int nextToken() throws XmlPullParserException, IOException
    {
        throw new ForbiddenOperationException("nextToken");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#require(int, java.lang.String, java.lang.String)
     */
    public void require(int arg0, String arg1, String arg2) throws XmlPullParserException, IOException
    {
        _parser.require(arg0, arg1, arg2);
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#nextText()
     */
    public String nextText() throws XmlPullParserException, IOException
    {
        throw new ForbiddenOperationException("nextText");
    }

    /* (non-Javadoc)
     * @see org.xmlpull.v1.XmlPullParser#nextTag()
     */
    public int nextTag() throws XmlPullParserException, IOException
    {
        throw new ForbiddenOperationException("nextTag");
    }

}

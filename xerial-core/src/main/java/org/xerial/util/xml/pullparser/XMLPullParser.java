/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XMLPullParser.java
// Since: Aug 7, 2007 8:49:03 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.pullparser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

import org.xerial.util.xml.SinglePath;
import org.xerial.util.xml.XMLElement;
import org.xerial.util.xml.XMLException;
import org.xmlpull.v1.XmlPullParser;

/**
 * XMLPullParser that supports XMLSiblingIterator
 * @author leo
 *
 */
public class XMLPullParser {
	
	private XmlPullParser _pullParser;
	private SinglePath _currentPath;
	
	public XMLPullParser(InputStream xmlInputStream) throws XMLException 
	{
		setupParser(new InputStreamReader(xmlInputStream));
	}
	
	public XMLPullParser(Reader xmlReader) throws XMLException
	{
		setupParser(xmlReader);
	}
	
	private void setupParser(Reader xmlReader) throws XMLException
	{
		_pullParser = PullParserUtil.newParser(xmlReader);
	}

	public Iterable<XMLElement> query(String pathExpr)
	{
	    // TODO impl
	    return null;
	}
	
	public Iterator<XMLElement> iterator(String pathExpr)
	{
	    //SinglePath  path = new SinglePath(pathExpr);
	    // TODO impl
		return null;
	}
	/*	
	private class XMLQueryResultImpl implements Iterable<XMLElement>
	{

        @Override
        public Iterator<XMLElement> iterator()
        {
            // TODO Auto-generated method stub
            return null;
        }
	    
	}
	
	

	private class XMLIteratorImpl implements Iterator<XMLElement>
	{

        @Override
        public boolean hasNext()
        {
            return false;
        }

        @Override
        public XMLElement next()
        {
            return null;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("remove");
        }

	}
	*/

}




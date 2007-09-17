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
// DOMUtil.java
// Since: 2004/12/24
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import static org.w3c.dom.Node.*;
import org.xerial.util.StringUtil;
import org.xerial.util.xml.XMLException;
import org.xml.sax.SAXException;


/**
 * DOMを操作する際に役立つユーティリティ
 * @author leo
 *
 */
public class DOMUtil
{
    private DOMUtil() {}
    
    /** TagのElementから、特定の子ノードのtext contentを返す
     * @param parentElement
     * @param tagName
     * @return tagNameの子ノードのtext content
     */
    static public String getTextContent(Element parentElement, String tagName)
    {
        NodeList tagList = parentElement.getElementsByTagName(tagName);
        
        // TODO impl
        return null;
    }
    
    /**
     * Gets the text data enclosed by the specified element. 
     * If xml data has several separated text data, the returned text will be 
     * their concatination. For example, in the following XML data, {@link #getText(Element)} for the 
     * wiki element gives "  Hello World!  Nice to meet you.".
     * <pre>
     * <wiki> 
     *   Hello World!
     *   <author>leo</author>
     *   Nice to meet you.
     * <wiki>
     * </pre>
     * 
     * The result removes ignorable white spaces between tags. 
     * 
     * @param element the target element
     * @return the text content of the element, or null if no text content is found under the element
     */
    static public String getText(Element element)
    {
        NodeList nodeList = element.getChildNodes();
        StringBuilder buf = new StringBuilder();
        int numTextNodes = 0;
        for(int i=0; i<nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.TEXT_NODE)
            {
                if(!((Text) node).isElementContentWhitespace())
                {
                    numTextNodes++;
                    buf.append(node.getNodeValue());
                }
            }
        }
        return numTextNodes > 0 ? buf.toString() : null;
    }
    
    
    static public HashMap<String, String> getTextContentMap(InputStream xmlStream)
    	throws XMLException, IOException
    {
    	try
    	{
    		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    		Document doc = docBuilder.parse(xmlStream);
    		Element rootElem = doc.getDocumentElement();
    		return getTextContentMap(rootElem);
    	}
    	catch(ParserConfigurationException e)
    	{
    		throw new XMLException(e);
    	}
    	catch(SAXException e)
    	{
    		throw new XMLException(e);
    	}
    }
    
    
    /** 
     * @param element 探索を開始するElementノード 
     * @return Relative Path Expression -> Text Content の構造のHashMap
     */
    static public HashMap<String, String> getTextContentMap(Element element)
    {
        String currentPath = ""; 
        DOMReadProcess readProcess = new DOMReadProcess();
        readProcess.traceSubTree(element);
        return readProcess.getContentMap();
    }
    
    static class DOMReadProcess 
    {
    	LinkedList<String> _relativePath = new LinkedList<String>();
    	HashMap<String, String> _path2contentMap = new HashMap<String, String>();
        public DOMReadProcess() 
        {}
        
        public void traceSubTree(Element subtreeRoot)
        {
        	String tagName = subtreeRoot.getTagName();
        	_relativePath.add(tagName);
        	
        	
        	if(subtreeRoot.hasAttributes())
        	{
        		String currentPath = getCurrentPath();
        		NamedNodeMap attribMap = subtreeRoot.getAttributes();
        		
        		for(int i=0; i<attribMap.getLength(); i++)
        		{
        			Attr attrib = (Attr) attribMap.item(i);
        			String attribPath = currentPath + "/@" + attrib.getName();
        			_path2contentMap.put(attribPath, attrib.getValue());
        		}
        	}
        	
            StringBuilder contentBuffer = new StringBuilder();
            IterableNodeList childNodes = new IterableNodeList(subtreeRoot.getChildNodes());
            for(Node node : childNodes)
            {
            	switch(node.getNodeType()) 
            	{
            	case ELEMENT_NODE:
            		traceSubTree((Element) node);
            		break;
            	case TEXT_NODE:
            		Text text = (Text) node;
            		contentBuffer.append(text.getData());
            		break;
            	case CDATA_SECTION_NODE:
            		CDATASection cdata = (CDATASection) node;
            		contentBuffer.append(cdata.getData());
             		break;
            	}
            }            
            String textContent = contentBuffer.toString();
            if(!StringUtil.isWhiteSpace(textContent))
            	_path2contentMap.put(getCurrentPath(), contentBuffer.toString());
            _relativePath.removeLast();
        }
        
        public HashMap<String, String> getContentMap()
        {
        	return _path2contentMap;
        }
        
        String getCurrentPath()
        {
        	StringBuilder pathExprBuilder = new StringBuilder();
        	for(String tag : _relativePath)
        	{
        		pathExprBuilder.append("/");
        		pathExprBuilder.append(tag);
        	}
        	return pathExprBuilder.substring(1);  // relative path
        }
        
    }
}





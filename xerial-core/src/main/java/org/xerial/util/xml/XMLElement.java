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
// XMLElement.java
// Since: 2004/12/24
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

/**
 * An XMLElement represents a tag (element) of XML data with XML attributes
 * @author leo
 *
 */
public class XMLElement
{
	private String tagName;
	private XMLAttribute attribute = new XMLAttribute();
	
	
    public XMLElement(String tagName, XMLAttribute attribute) {
		super();
		this.tagName = tagName;
		this.attribute = attribute;
	}

	/**
     * Gets the tag name of the element
     * @return
     */
    public String getTagName()
    {
    	return tagName;
    }
    
    /**
     * Gets the {@link XMLAttribute} of the element
     * @return
     */
    public XMLAttribute getAttribute()
    {
    	return attribute;
    }
}


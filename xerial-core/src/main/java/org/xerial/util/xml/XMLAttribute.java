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
// XerialJ Project
// 
// XMLAttribute.java 
// Since:  2004/05/04
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * XML Attribute
 * 
 * @author leo
 * 
 */
public class XMLAttribute
{
    public XMLAttribute(String attributeName, String attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, int attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, double attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, long attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, float attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, boolean attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute(String attributeName, Object attributeValue)
    {
        add(attributeName, attributeValue);
    }

    public XMLAttribute()
    {}

    public XMLAttribute add(String attributeName, String attributeValue)
    {
        _attributeNameList.add(attributeName);
        _attributeValue.put(attributeName, attributeValue);
        return this;
    }

    public XMLAttribute add(String attributeName, int attributeValue)
    {
        return this.add(attributeName, Integer.toString(attributeValue));
    }

    public XMLAttribute add(String attributeName, double attributeValue)
    {
        return this.add(attributeName, Double.toString(attributeValue));
    }

    public XMLAttribute add(String attributeName, long attributeValue)
    {
        return this.add(attributeName, Long.toString(attributeValue));
    }

    public XMLAttribute add(String attributeName, float attributeValue)
    {
        return this.add(attributeName, Float.toString(attributeValue));
    }

    public XMLAttribute add(String attributeName, boolean attributeValue)
    {
        return this.add(attributeName, Boolean.toString(attributeValue));
    }

    public XMLAttribute add(String attributeName, Object attributeValue)
    {
        return this.add(attributeName, attributeValue.toString());
    }

    public XMLAttribute(Properties properties)
    {
        Set keySet = properties.keySet();
        for (Object attributeObj : keySet)
        {
            String attribute = attributeObj.toString();
            String value = properties.getProperty(attribute);
            this.add(attribute, value);
        }
    }

    public XMLAttribute(Map properties)
    {
        Set keySet = properties.keySet();
        for (Object attributeObj : keySet)
        {
            String attribute = attributeObj.toString();
            String value = properties.get(attribute).toString();
            this.add(attribute, value);
        }
    }

    /**
     * @param attributeName
     * @return attributeNameに対応するstring
     */
    public String getValue(String attributeName)
    {
        return (String) _attributeValue.get(attributeName);
    }

    /**
     * @return このインスタンスに含まれるattribute名のリストのView
     */
    public List<String> getAttributeNames()
    {
        return _attributeNameList;
    }

    /**
     * @return Attributeの個数を返す
     */
    public int length()
    {
        return _attributeNameList.size();
    }

    /**
     * @return XMLのattributeのフォーマットの文字列
     */
    public String toXMLString()
    {
        String returnString = "";
        for (String attributeName : _attributeNameList)
        {
            String attributeValue = _attributeValue.get(attributeName);
            returnString += attributeName + "=\"" + attributeValue + "\" ";
        }
        if (!returnString.equals(""))
        {
            // remove the unnecessary white space
            return returnString.substring(0, returnString.length() - 1);
        }
        else
            return returnString;
    }

    protected LinkedList<String> _attributeNameList = new LinkedList<String>();
    protected HashMap<String, String> _attributeValue = new HashMap<String, String>();
}

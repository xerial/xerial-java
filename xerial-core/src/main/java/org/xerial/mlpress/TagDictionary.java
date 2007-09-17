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
// TagDictionary.java
// Since: 2005/07/21 14:32:36
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TagDictionary holds mappings from each tagName (or tagName/@attributeName) to its ID.
 * 
 * @author leo
 *
 */
public class TagDictionary
{
    private TreeMap<String, Integer> _tagMap = new TreeMap<String, Integer>();
    private TreeSet<Integer> _attributeIDSet = new TreeSet<Integer>();  // It remembers attribute name IDs
    private int _tagCount = 0; 
    
  
  
    public TagDictionary()
    {
        _tagCount = 0;
        for(Keyword key : Keyword.values())
        {
            _tagMap.put(key.name(), _tagCount++);
        }
    }
        

    public int getTagID(String tagName)
    {
        Integer tagID = _tagMap.get(tagName);
        if(tagID == null)
        {
            tagID = _tagMap.put(tagName, _tagCount++);
        }
        return tagID;
    }
    
    public int getAttributeID(String tagName, String attributeName)
    {
        String attributeKey = tagName + "/@" + attributeName;
        Integer attributeID = _tagMap.get(attributeKey);
        if(attributeID == null)
        {
            attributeID = _tagMap.put(attributeKey, _tagCount++);
            _attributeIDSet.add(attributeID);
        }
        return attributeID;
    }
    
}


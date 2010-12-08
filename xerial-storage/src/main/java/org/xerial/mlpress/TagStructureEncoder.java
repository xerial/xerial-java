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
// TagStructureEncoder.java
// Since: 2005/07/21 14:54:46
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import org.xerial.db.VariableLengthInteger;

/**
 * The TagStructureEncoder repraces tag structures in XML documents to shorter representations by using 
 * tagIDs.
 * 
 * For example, consider the following XML document:
 * <pre>
 * <dir>
 * <file>
 *   <name>helloworld.txt</name>
 *   <date>2005/07/24</date>
 *   <data>
 *      <encoding>UTF-8</encoding>
 *      <text> ... </text>
 *   </data>
 * </file>
 * <file type="PNG">
 *   <name>world.png</name>
 *   <binary>.....</binary>
 * </file>
 * </dir>
 * </pre>
 * 
 * It will be encoded as follows:
 * <pre>
 * 1 2 3 C3 / 4 C4 / 5 6 C6 / 7 C7 / / / 2 8 C8 3 C3 / 9 C9 / 10 C10 / / / $ 
 * </pre>
 * where the above integers denote IDs of the start tag names. '/' is end tag,
 *  C? (? is an integer) is text container ID, and  '$' is the end-of-file.
 * 
 * To distinguish IDs of tag names and attribute names is the role of TagDictionary,
 * Thus the TagStructureEncoder simply encodes attribute elements, 
 * 
 * @author leo
 *
 */
public class TagStructureEncoder
{
    private TagDictionary _tagDict = null;
    private boolean _ignoreWhiteSpacecBetweenStartTags = true;

    
    public TagStructureEncoder(TagDictionary tagDict)
    {
        _tagDict = tagDict;
    }    
         
    public VariableLengthInteger encodeTag(String tagName)
    {
        return new VariableLengthInteger(_tagDict.getTagID(tagName));
    }
    
    public VariableLengthInteger encodeWhiteSpace()
    {
        return _ignoreWhiteSpacecBetweenStartTags ? null : new VariableLengthInteger(Keyword.WHITE_SPACE.ordinal());
    }
    
    public VariableLengthInteger closeTag()
    {
        return new VariableLengthInteger(Keyword.CLOSE_TAG.ordinal());
    }
    
    public VariableLengthInteger encodeAttribute(String tagName, String attributeName)
    {
        return new VariableLengthInteger(_tagDict.getAttributeID(tagName, attributeName));        
    }
    
}




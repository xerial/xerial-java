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
// TreeStructuredData.java
// Since: Dec 18, 2007 10:42:02 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.util.List;

/**
 * A common interface to access XML, JSON and ANTLR Parse tree structures.
 * @author leo
 *
 */
public interface TreeNode
{
    /**
     * @return true if this node has child nodes, otherwise false. 
     */
    public boolean hasChildNodes();

    /**
     * @return 
     */
    public boolean hasNodeName();
    
    /**
     * Retrieves the child nodes of this tree node
     * @return the list of the child nodes
     */
    public List<TreeNode> getChildren();
    
    /**
     * Gets the text value assigned to this tree node
     * @return  the text value. If no text value is present, returns null
     */
    public String getTextValue();
    
    /**
     * Gets the node name of this tree node
     * @return the node name if it has, otherwise null 
     */
    public String getNodeName();
    
}

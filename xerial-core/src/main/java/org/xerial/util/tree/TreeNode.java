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
// XerialJ Project
//
// TreeNode.java
// Since: May 22, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/util/tree/TreeNode.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.tree;

import java.util.List;

/**
 * TreeNode
 * 
 * @author leo
 * 
 */
public interface TreeNode
{
    public List<TreeNode> getChildren();

    public String getNodeName();

    public String getNodeValue();

}

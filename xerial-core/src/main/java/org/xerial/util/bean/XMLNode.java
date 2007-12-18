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
// XMLNode.java
// Since: Dec 18, 2007 10:51:55 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.util.log.Logger;

/**
 * XML Node interface for {@link BeanUtil}
 * @author leo
 *
 */
public class XMLNode implements TreeNode
{
    private static Logger _logger = Logger.getLogger(XMLNode.class);
    
    Node node;
    
    public XMLNode(Node node) 
    {
        if(node == null)
            throw new NullPointerException();
        this.node = node;
    }

    
    public List<TreeNode> getChildren()
    {
        ArrayList<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        
        NamedNodeMap attributeMap = node.getAttributes();
        for(int i=0; i<attributeMap.getLength(); i++)
        {
            Node attributeNode =  attributeMap.item(i);
            treeNodeList.add(new XMLNode(attributeNode));
        }

        NodeList nodeList = node.getChildNodes();
        for(int i=0; i<nodeList.getLength(); i++)
        {
            Node childNode = nodeList.item(i);
            if(childNode.getNodeType() == Node.ELEMENT_NODE)
            {
                treeNodeList.add(new XMLNode(childNode));
            }
        }
                     
        return treeNodeList;
    }

    public String getNodeName()
    {
        return node.getNodeName();
    }

    public String getTextValue()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean hasChildNodes()
    {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean hasNodeName()
    {
        // TODO Auto-generated method stub
        return false;
    }

}

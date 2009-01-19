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
// XMLTreeNode.java
// Since: Dec 26, 2007 4:08:47 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xerial.util.tree.TreeNode;
import org.xerial.util.xml.dom.DOMUtil;

/**
 * {@link TreeNode} implementation for XML data
 * 
 * @author leo
 * 
 */
public class XMLTreeNode implements TreeNode
{
    private String nodeName;
    private String nodeValue;
    private ArrayList<TreeNode> childList = new ArrayList<TreeNode>();

    public XMLTreeNode()
    {}

    public XMLTreeNode(String nodeName, String nodeValue)
    {
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    public XMLTreeNode(Element element)
    {
        parse(this, element);
    }

    /**
     * Parses the input DOM element, and constructs XMLTreeNode
     * 
     * @param currentNode
     *            the current node matching the element
     * @param element
     *            the parsing target element
     * @return the currentNode with its descendant XMLTreeNodes
     */
    public static XMLTreeNode parse(XMLTreeNode currentNode, Element element)
    {
        String tagName = element.getNodeName();
        currentNode.setNodeName(tagName);

        NamedNodeMap attributeMap = element.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++)
        {
            Node attributeNode = attributeMap.item(i);
            String attributeName = attributeNode.getNodeName();
            String attributeValue = attributeNode.getNodeValue();
            currentNode.addChild(new XMLTreeNode(attributeName, attributeValue));
        }

        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE)
                currentNode.addChild(parse(new XMLTreeNode(), (Element) childNode));
        }

        // set the current node value from the DOM texts
        String text = DOMUtil.getText(element);
        currentNode.setNodeValue(text);

        return currentNode;
    }

    public void setNodeValue(String nodeValue)
    {
        this.nodeValue = nodeValue;

    }

    public List<TreeNode> getChildren()
    {
        return childList;
    }

    public String getNodeName()
    {
        return nodeName;
    }

    public String getNodeValue()
    {
        return nodeValue;
    }

    public void setNodeName(String nodeName)
    {
        this.nodeName = nodeName;
    }

    public void addChild(XMLTreeNode childNode)
    {
        childList.add(childNode);
    }

}

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
// org.xerial.util.xml.dom Project
// 
// NodeList.java 
// Since: 2004/12/30
//
// $URL$ 
// $Author$
//--------------------------------------

package org.xerial.util.xml.dom;

import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author leo
 *
 */
public class IterableNodeList implements Iterable<Node>, NodeList
{

	
	NodeList _nodeList;
	/**
	 * 
	 */
	public IterableNodeList(NodeList nodeList)
	{
		assert nodeList != null;
		_nodeList = nodeList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Node> iterator() {
		return new NodeListIterator(_nodeList);
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.NodeList#item(int)
	 */
	public Node item(int index) {
		_nodeList.item(index);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.NodeList#getLength()
	 */
	public int getLength() {
		return _nodeList.getLength();
	}


}

class NodeListIterator implements Iterator<Node>
{
	NodeList _nodeList;
	int _index = 0;
	int _length = 0;
	public NodeListIterator(org.w3c.dom.NodeList nodeList)
	{
		_nodeList = nodeList;
		_index = 0;
		_length = _nodeList.getLength();
	}
	public boolean hasNext() {
		return _index < _length;
	}
	public void remove() {
		throw new UnsupportedOperationException("remove method for NodeList is not supported");
	}
	public Node next()  {
		return _nodeList.item(_index++);
	}
}



//--------------------------------------
// $Log$
//--------------------------------------
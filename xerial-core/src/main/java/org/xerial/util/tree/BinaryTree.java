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
// BinaryTree.java
// Since: May 22, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/util/tree/BinaryTree.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.tree;

import java.util.ArrayList;

public class BinaryTree<Entry>
{
	private TreeNodeImpl<Entry> _rootNode = null;
	
	public TreeNode<Entry> getRootNode()
	{
		return _rootNode;
	}
	
	public TreeNode<Entry> find(Entry entry)
	{
		DFSSearch searchProcess = new DFSSearch(entry);
		return searchProcess.getSearchResult();
	}

	public Path<Entry> findPath(Entry entry)
	{
		DFSSearch searchProcess = new DFSSearch(entry);
		return searchProcess.getSearchPath();
	}

	class DFSSearch
	{
		PathImpl<Entry> _path = new PathImpl<Entry>();
		TreeNode<Entry> _searchResult = null;
		Entry _searchTarget;
		
		public DFSSearch(Entry searchTarget)
		{
			this._searchTarget = searchTarget;
			_searchResult = search(_rootNode);		
		}
		
		public TreeNode<Entry> getSearchResult()
		{
			return _searchResult;
		}
		
		public Path<Entry> getSearchPath()
		{
			return _path;
		}
		
		private TreeNode<Entry> search(TreeNode<Entry> currentNode)
		{
			if(currentNode == null)
				return null;
			
			_path.push(currentNode);			
			
			if(currentNode.getEntry().equals(_searchTarget))
				return currentNode;
			
			TreeNode<Entry> childSearchResult = search(currentNode.getFirstChild());
			if(childSearchResult != null)
				return childSearchResult;
			
			_path.pop();
			return search(currentNode.getNextSiblig());
		}
		
	}
	
	private TreeNode<Entry> search(TreeNode<Entry> currentNode, Entry searchTarget)
	{
		if(currentNode == null)
			return null;
		
		if(currentNode.getEntry().equals(searchTarget))
			return currentNode;
		
		TreeNode<Entry> childSearchResult = search(currentNode.getFirstChild(), searchTarget);
		if(childSearchResult != null)
			return childSearchResult;
		
		return search(currentNode.getNextSiblig(), searchTarget);
	}
	
}




/**
 * @author leo
 *
 */
class TreeNodeImpl<Entry> implements TreeNode<Entry>
{
	private TreeNode<Entry> _firstChild = null;
	private TreeNode<Entry> _nextSibling = null;
	private Entry _entry = null;
	
	public TreeNodeImpl()
	{}

	public TreeNodeImpl(Entry entry)
	{
		this._entry = entry;
	}
	

	public TreeNodeImpl(TreeNode<Entry> firstChild, TreeNode<Entry> nextSibling)
	{
		this._nextSibling = nextSibling;
		this._firstChild = firstChild;
	}

	// @see org.xerial.util.tree.TreeNode#getEntry()
	public Entry getEntry(){
		return _entry;
	}
	
	
	// @see org.xerial.util.tree.TreeNode#getFirstChild()
	public TreeNode<Entry> getFirstChild()
	{
		return _firstChild;
	}
	// @see org.xerial.util.tree.TreeNode#getNextSiblig()
	public TreeNode<Entry> getNextSiblig()
	{
		return _nextSibling;
	}
	
	// @see org.xerial.util.tree.TreeNode#hasChild()
	public boolean hasChild()
	{
		return _firstChild != null;
	}
	
	// @see org.xerial.util.tree.TreeNode#hasSibling()
	public boolean hasSibling()
	{
		return _nextSibling != null;
	}
	
	
	// @see org.xerial.util.tree.TreeNode#appendChild(org.xerial.util.tree.TreeNode)
	public TreeNode<Entry> appendChild(TreeNode<Entry> newChild)
	{
		if(_firstChild == null)
		{
			_firstChild = newChild;
			return _firstChild;
		}
		
		return _firstChild.appendSibling(newChild);
	}
	
	// @see org.xerial.util.tree.TreeNode#appendSibling(org.xerial.util.tree.TreeNode)
	public TreeNode<Entry> appendSibling(TreeNode<Entry> newSibling)
	{
		if(_nextSibling == null)
		{
			_nextSibling = newSibling;
			return _nextSibling;
		}
		return _nextSibling.appendSibling(newSibling);
	}
	
	
	// @see org.xerial.util.tree.TreeNode#getNthChild(int)
	public TreeNode<Entry> getNthChild(int n)
	{
		int count = 1;
		TreeNode<Entry> cursor = _firstChild;
		while(cursor != null)
		{
			if(count++ == n)
				return cursor;
			cursor = cursor.getNextSiblig();
		}
		return null;
	}
	
	
}


class PathImpl<Entry> implements Path<Entry>
{
	private ArrayList<TreeNode<Entry>> _path = new ArrayList<TreeNode<Entry>>();
	
	public TreeNode<Entry> get(int index) {
		return _path.get(index);
	}

	public int size() {
		return _path.size();
	}
	
	public void push(TreeNode<Entry> node)
	{
		_path.add(node);
	}
	public void pop()
	{
		_path.remove(_path.size() - 1);
	}
	
}


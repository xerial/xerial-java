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

interface TreeNode<Entry> {

	public abstract Entry getEntry();

	public abstract TreeNode<Entry> getFirstChild();

	public abstract TreeNode<Entry> getNextSiblig();

	public abstract boolean hasChild();

	public abstract boolean hasSibling();

	/**
	 * append a new child node
	 * @param newChild
	 * @return the added child node
	 */
	public abstract TreeNode<Entry> appendChild(TreeNode<Entry> newChild);

	/**
	 * apppend a new sibling node
	 * @param newSibling
	 * @return the added sibling node
	 */
	public abstract TreeNode<Entry> appendSibling(TreeNode<Entry> newSibling);

	/**
	 * return the n-th child node.
	 * @param n
	 * @return n-th child node, or null if not found
	 */
	public abstract TreeNode<Entry> getNthChild(int n);

}

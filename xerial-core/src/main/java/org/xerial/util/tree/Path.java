//--------------------------------------
// XerialJ Project
//
// Path.java
// Since: May 22, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/util/tree/Path.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.tree;

public interface Path<Entry> {

	public abstract TreeNode<Entry> get(int index);
	public abstract int size();
}





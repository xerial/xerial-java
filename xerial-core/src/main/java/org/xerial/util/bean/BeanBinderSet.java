//--------------------------------------
// XerialJ Project
//
// BeanBinderSet.java
// Since: Apr 18, 2007
//
// $Date: 2007-04-18 15:49:19 +0900 (Wed, 18 Apr 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/util/bean/BeanBinderSet.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.bean;

import java.util.Vector;

public interface BeanBinderSet {

	public abstract void addRule(BeanBinder binder);

	public abstract Vector<BeanBinder> getBindRules();

	public abstract BeanBinder findRule(String name);

}

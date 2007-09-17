//--------------------------------------
// XerialJ Project
//
// BinaryFunctor.java
// Since: May 8, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

public interface BinaryFunctor<K, V> {
	public Object apply(K key, V value);
}





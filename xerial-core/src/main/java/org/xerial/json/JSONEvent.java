//--------------------------------------
// XerialJ Project
//
// JSONEvent.java
// Since: May 8, 2007
//
// $Date: 2007-05-08 11:51:00 +0900 (Tue, 08 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/json/JSONEvent.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.json;

public enum JSONEvent {
	
	StartJSON,
	EndJSON,
	StartObject,
	EndObject,
	StartArray,
	EndArray,
	Key,
	Value,
}





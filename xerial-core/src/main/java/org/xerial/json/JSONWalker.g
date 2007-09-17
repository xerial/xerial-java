//--------------------------------------
// Xerial Project
//
// JSONWalker.g
// Since: Apr 26, 2007
//
//--------------------------------------
/**
 * JSONWalker generates JSONObject and JSONArray instances
 * from a given input JSON parse tree.
 */
tree grammar JSONWalker;
options
{
  tokenVocab=JSON;
  ASTLabelType=CommonTree;
  k=4;
}

scope ObjectLayer {
 	ArrayList<JSONElement> elems;
}
scope ArrayLayer {
	ArrayList<JSONValue> elems;
}

@header
{
//--------------------------------------
// Xerial Project
//
// JSONWalker.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.json;
import org.xerial.util.StringUtil;
}


@members {
	public String unquote(String s) { return StringUtil.unquote(s); }
}


jsonObject returns [JSONObject r]
	: o=object  { $r = o; }
	;
jsonArray returns [JSONArray r]
	: a=array  { $r = a; }
	;	


object returns [JSONObject v]
scope ObjectLayer;
@init {
	$ObjectLayer::elems = new ArrayList<JSONElement>();
}
	: ^(OBJECT objectElement*)  
	{ $v = new JSONObject($ObjectLayer::elems); }
	;

objectElement 
	: ^(ELEMENT s=String v=value) 
	{ $ObjectLayer::elems.add(new JSONElement(unquote($s.text), v)); }
	;	  
	
array returns [JSONArray v]
scope ArrayLayer;
@init {
	$ArrayLayer::elems = new ArrayList<JSONValue>();
}
	: ^(ARRAY arrayElement*)
	{ $v = new JSONArray($ArrayLayer::elems); }
    ;

arrayElement
	: v = value 
	{ $ArrayLayer::elems.add(v); }
	;

value returns [JSONValue v]
	: ^(STRING s=String) { $v = new JSONString(unquote($s.text)); }
	| ^(INTEGER n=Integer) { $v = new JSONInteger($n.text); }
	| ^(DOUBLE n=Double) { $v = new JSONDouble($n.text); }
	| o=object { $v = o; }
	| a=array	 { $v = a; } 
	| TRUE	{ $v = new JSONBoolean(true); }
	| FALSE { $v = new JSONBoolean(false); }
	| NULL	{ $v = new JSONNull(); }
	;
	

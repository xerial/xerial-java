//--------------------------------------
// XerialJ Project
//
// JSON.g
// Since: Apr 26, 2007
//
//--------------------------------------

grammar JSON;
options
{
	language=Java;
	output=AST;
//	charVocabulary='\u0000'..'\uFFFE';
}

tokens
{
	OBJECT;
	ELEMENT;
	ARRAY;
	STRING;
	INTEGER;
	DOUBLE;
}

@lexer::header
{
//--------------------------------------
// XerialJ Project
//
// JSONLexer.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.json.impl;
}

@header
{
//--------------------------------------
// Xerial Project
//
// JSONParser.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.json.impl;
}

@rulecatch {

}

// lexer rules
Colon: ':';
Comma: ',';
LBrace: '{';
RBrace: '}';
LBracket: '[';
RBracket: ']';
fragment Dot: '.';
TRUE:  'true';
FALSE: 'false';
NULL: 'null';

fragment Digit: '0' .. '9';
fragment HexDigit: ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f');
fragment UnicodeChar: ~('"'| '\\');
fragment StringChar :  UnicodeChar | EscapeSequence;

fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	;

fragment Int: '-'? ('0' | '1'..'9' Digit*);
fragment Frac: Dot Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;

WhiteSpace: (' ' | '\r' | '\t' | '\u000C' | '\n') { $channel=HIDDEN; };

String: '"' StringChar* '"';
Integer: Int;
Double:  Int (Frac Exp? | Exp);

// parser rules
jsonObject
	: object
	;
	
jsonArray
	: array
	;	


object
	: LBrace (objectElement (Comma objectElement)*)? RBrace
	  -> ^(OBJECT objectElement*)
	;
	
objectElement
	: String Colon value
	  -> ^(ELEMENT String value)
	;	
	
array
	: LBracket value (Comma value)* RBracket
	  -> ^(ARRAY value+)
	;

	
value
	: String -> ^(STRING String)
	| Integer -> ^(INTEGER Integer)
	| Double -> ^(DOUBLE Double)
	| object  
	| array  
	| TRUE   
	| FALSE
	| NULL
	;


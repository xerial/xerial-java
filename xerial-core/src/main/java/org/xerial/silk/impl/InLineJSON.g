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
// InLineJSON.g
// Since: 2009/01/30
//
//--------------------------------------
 
grammar InLineJSON;
options
{
	language=Java;
//	output=AST;
}
  
 
@lexer::header
{
//--------------------------------------
// XerialJ Project
//
// InLineJSONLexer.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.silk.impl;
}

@lexer::members {
  public int nesting = 1;	// json fragment begins with nesting
}

@header
{
//--------------------------------------
// XerialJ Project
//
// InLineJSONParser.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.silk.impl;
}


WhiteSpace: (' ' | '\r' | '\t' | '\u000C' | '\n') { $channel=HIDDEN; };

fragment Digit: '0' .. '9';
fragment Letter: 'A' .. 'F' | 'a' .. 'f';
fragment HexDigit: Digit | Letter;
fragment UnicodeChar: ~('"'| '\\');
fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	; 

fragment StringChar :  UnicodeChar | EscapeSequence;

fragment StringChar_s: StringChar*;
String: '"' s=StringChar_s '"' { setText($s.text); };


Colon: ':';
Comma: ',';
Integer: '-'? ('0' | '1'..'9' Digit*);
fragment Frac: '.' Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;
Double: Integer (Frac Exp? | Exp);

LBrace: '{' { nesting++; } ;
RBrace: '}' { nesting--; if (nesting<=0) { emit(Token.EOF_TOKEN); } };
LBracket: '[' { nesting++; } ;
RBracket: ']' { nesting--; if (nesting<=0) { emit(Token.EOF_TOKEN); } };

/*
fragment NameChar: Letter | Digit | '_' | '-' | '@' | '.';
QName: (Letter | '_') NameChar*;
*/

// parser

jsonObjectFragment: jsonElement (Comma jsonElement)*;
jsonArrayFragment: jsonValue (Comma jsonValue)*;

jsonObject: LBrace jsonElement (',' jsonElement)* RBrace;
jsonElement: String Colon jsonValue; 
jsonArray: LBracket jsonValue (',' jsonValue)* RBracket;

jsonValue
	: jsonObject
	| jsonArray
	| String
	| Integer
	| Double
	| 'true'
	| 'false'
	| 'null'
	;




	
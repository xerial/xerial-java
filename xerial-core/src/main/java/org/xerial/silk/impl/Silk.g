/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// XerialJ
//
// Silk.g
// Since: Jan 28, 2009 1:00:02 PM
//
//--------------------------------------
 
grammar Silk;
options 
{
	language=Java;
	output=AST;
	// some lexer & parser options
	// number of look-ahead characters 
	//k=3;	
	backtrack=true;
}
tokens {
Silk;
SilkNode;
SilkAttribute;
Name;
Value;
Occurrence;
DataType;
Function;
Argument;
KeyValuePair;
Key;
//JSONObject;
//JSONArray;
//JSONElement;
}


@lexer::header
{
/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// XerialJ
//
// SilkLexer.java
// Since: Jan 28, 2009 1:00:02 PM
//
//--------------------------------------

package org.xerial.silk.impl;
}


@header
{
/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// XerialJ
//
// SilkParser.java
// Since: Jan 28, 2009 1:00:02 PM
//
//--------------------------------------
package org.xerial.silk.impl;

}

@lexer::members {
  private boolean hasColon = false;

}


// lexer rules

// Character Set


// skip comment 
LineComment: '#' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }; 
Preamble: '%' ~('\n'|'\r')* '\r'? '\n'; 

NewLine: '\r'? '\n' { hasColon = false; $channel=HIDDEN; };


// node indicator
NodeStart: {getCharPositionInLine()==0}? (' ')* '-';
BlankLine: {getCharPositionInLine()==0}? ( ' ' | '\t' | '\u000C')* NewLine { $channel=HIDDEN; };


fragment SpecialSymbol: '%' | '#' | ' ' | '\n' | '\r';   
DataLine: { getCharPositionInLine()==0 }? ~SpecialSymbol ~('\n'|'\r')* NewLine;

WhiteSpaces: ( ' ' | '\t' | '\u000C')+ { $channel=HIDDEN; }; 




fragment Digit: '0' .. '9';
fragment HexDigit: ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f');
fragment UnicodeChar: ~('"'| '\\' | '\r' | '\n');
fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	; 
	
fragment StringChar :  UnicodeChar | EscapeSequence;

fragment Int: '-'? ('0' | '1'..'9' Digit*);
fragment Frac: Dot Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;


String: '"' StringChar* '"'
{ 
  // remove the quotations
  String tmp = getText(); setText(tmp.substring(1, tmp.length()-1));
  hasColon=false;   
};

Number: Int (Frac Exp? | Exp)?;

fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment NameChar: Letter | Digit | '_' | '-' | Dot;
QName: (Letter | '_') NameChar* 
	; 





Colon: ':' { hasColon = true; } ;


InLineJSON: {hasColon}? => (JSONObject | JSONArray) { hasColon = false; }
	;  


fragment
JSONObject
	: LBrace JSONElement (Comma JSONElement)* RBrace
	;
	
fragment
JSONArray
	: LBracket (JSONValue (Comma JSONValue)*)? RBracket
	;	

fragment
JSONElement: (String | QName) Colon JSONValue
	;

fragment
JSONValue
	: JSONObject
	| JSONArray
	| String
	| Number
	;

fragment
InLineStringChar: ('\n'|'\r'|'#'|Comma|LParen|RParen|LBracket|RBracket|LBrace|RBrace|'"');

NodeValue: 
	{ hasColon }? 
		=> (String | ~(' '|'\t' | InLineStringChar) (options {greedy=false;} : ~(InLineStringChar)*))
	{ hasColon = false; }
	;

SequenceIndicator: '>';
LParen: '(';
RParen: ')';
LBracket: '[';
RBracket: ']';
LBrace: '{';
RBrace: '}';
Comma: ',';
Dot: '.';
Star: '*';
Question: '?';
Plus: '+';
At: '@';
Slash: '/';



// parser rules	

schema: node;

silkFile: silkLine* -> ^(Silk silkLine*)
	;

silkLine
	: Preamble
	| DataLine
	| node
	;


nodeName: QName | String;
nodeValue
	: NodeValue -> Value[$nodeValue.text]
	;


node: NodeStart (coreNode | function);

coreNode: nodeItem
	-> ^(SilkNode nodeItem)
	;

nodeItem: nodeName (Colon nodeValue)? (LParen attributeList RParen)? dataType? plural?
	-> Name[$nodeName.text] nodeValue? dataType? plural? attributeList? 
	;

dataType: LBracket! dataTypeName RBracket!
	;
	
dataTypeName: QName (Slash QName)*
	-> DataType[$dataTypeName.text]
	; 	
	
attributeList: attributeItem (Comma! attributeItem)* ;	
attributeItem: nodeItem -> ^(SilkAttribute nodeItem);

/*	
nestedNodeList: nestedNodeItem (nestedNodeItem)
	-> ^(Silk
	;

nestedNodeItem: nodeItem -> ^(SilkNode nodeItem)
	;
	*/

plural
	: Star -> Occurrence["ZERO_OR_MORE"]
	| Plus -> Occurrence["ONE_OR_MORE"]
	| Question -> Occurrence["ZERO_OR_ONE"]
	| SequenceIndicator -> Occurrence["SEQUENCE"]
	;

function: At QName LParen (functionArg (Comma functionArg)*)? RParen
	-> ^(Function[$QName.text] functionArg*)
	;

functionArg
	: (String | QName) -> Argument[$functionArg.text]
	| QName Colon NodeValue -> ^(KeyValuePair Key[$QName.text] Value[$NodeValue.text])
	;






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
	// some lexer & parser options
	k=2;	// number of look-ahead characters 
	output=AST;	
}
tokens {
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



// lexer rules

// skip comment 
LineComment: '#' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }; 
Preamble: '%' ~('\n'|'\r')* '\r'? '\n'; 
NewLine: '\r'? '\n' { $channel=HIDDEN; };

// node indicator
NodeIndicator: {getCharPositionInLine()==0}? => (' ')* '-';

DataLine: { getCharPositionInLine()==0 }? =>  ~(' ' | '\r' | '\n' | '-' | '%' | '#') ~('\n'|'\r')*  NewLine; 

WhiteSpaces: ( ' ' | '\t' | '\u000C')+ { $channel=HIDDEN; };

BlankLine: { getCharPositionInLine()==0 }? => WhiteSpaces? (NewLine | EOF);

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
};
Integer: Int;
Double:  Int (Frac Exp? | Exp);

//fragment
//InLineStringChar: ~('\n'|'\r'|'#'|Comma|LParen|'"');

Colon: ':';
//NodeValue: Colon (~(Comma | RParen | '\n'))+
//NodeValue: Colon (String | InLineStringChar+ ) { setText(getText().substring(1).trim()); } ;

fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment NameChar: Letter | Digit | '_' | '-' | Dot;
QName: (Letter | '_') NameChar*
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

silkFile:
	silkLine*
	;

silkLine
	: Preamble
	| BlankLine
	| DataLine
	| node
	;


nodeName: QName | String;
nodeValue
	: inLineJSON
	 -> Value[$nodeValue.text]
	;

inLineJSON
	: jsonObject
	| jsonArray
	| jsonAtom
	;

jsonObject
	: LBrace (jsonElement (Comma jsonElement)*)? RBrace
	;
	
jsonArray
	: LBracket (jsonValue (Comma jsonValue)*)? RBracket
	;	

jsonElement: nodeName Colon jsonValue
	;

jsonValue
	: jsonAtom
	| jsonObject
	| jsonArray 
	;

jsonAtom
	: String
	| Integer
	| Double
	| QName
	;

node: NodeIndicator (coreNode | function);

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
	: jsonAtom -> Argument[$jsonAtom.text]
	| QName Colon jsonAtom -> ^(KeyValuePair Key[$QName.text] Value[$jsonAtom.text])
	;



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
	k=4;	// number of look-ahead characters 
	output=AST;	
}
tokens {
ObjectSchema;
ObjectAttribute;
Name;
Value;
Occurrence;
Type;
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


// skip newlines and white spaces
NewLine: '\r'? '\n' { $channel=HIDDEN; }
	;

LineComment: '#' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }
    ;

// node indicator
fragment LeadingWhiteSpaces:  (' ')*;  
RelativeNodeIndicator: {getCharPositionInLine()==0}? => LeadingWhiteSpaces '->';
NodeIndicator: {getCharPositionInLine()==0}? => LeadingWhiteSpaces '-';

WhiteSpaces: ( ' ' | '\t' | '\n' | '\r' | '\u000C')+ { $channel=HIDDEN; };

Comma: ',';
Dot: '.';

fragment Digit: '0' .. '9';
fragment HexDigit: ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f');
fragment UnicodeChar: ~('"'| '\\');
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

SequenceIndicator: '>';
LParen: '(';
RParen: ')';
fragment LBracket: '[';
fragment RBracket: ']';


Star: '*';
Question: '?';
Plus: '+';

Colon: ':'
	;


QName: StringChar*;


DataType
	: LBracket (~RBracket)+ RBracket 
	{ String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); }
	;


schema: node;

node:
	  NodeIndicator nodeItem nodeList 
	;

nodeItem: nodeName (Colon nodeValue)? ;

nodeList: nodeItem+; 

nodeName: QName | String; 

nodeValue: QName | String;


/*
attributeOption
	: attributePlural
	| StringLiteral	-> Value[$StringLiteral.text]
	| Literal -> Value[$Literal.text]
	;

attributePlural
	: Star -> Occurrence["ZERO_OR_MORE"]
	| Plus -> Occurrence["ONE_OR_MORE"]
	| Question -> Occurrence["ZERO_OR_ONE"]
	| SequenceIndicator -> Occurrence["SEQUENCE"]
	;

	*/
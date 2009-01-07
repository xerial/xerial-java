/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// xerial-core project
// 
// ObjectSchema.g
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
 
grammar ObjectSchema;
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
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// xerial-core project
// 
// ObjectSchemaLexer.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------

package org.xerial.rel.impl;
}


@header
{
/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// xerial-core project
// 
// ObjectSchemaParser.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
package org.xerial.rel.impl;

}

NEWLINE
	: '\r'? '\n' { $channel=HIDDEN; }
	;

Level: '>';
AttributeIndicator: '-';
Comma: ',';

Dot: '.';
LParen: '(';
RParen: ')';
fragment LBracket: '[';
fragment RBracket: ']';

TabbedValueIndicator: '|';
Star: '*';
Question: '?';
Plus: '+';


fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment Digit: '0' .. '9';
Digits: (Digit)+;

fragment NameChar: Letter | Digit | '_' | '-' | Dot;

WhiteSpaceChar: ( ' ' | '\t' | '\n' | '\r' | '\u000C')+ { $channel=HIDDEN; };

QName: (Letter | '_') NameChar*;

fragment Colon: ':';
StringLiteral
: '"' (~'"')* '"' { String tmp = getText(); setText(tmp.substring(1, tmp.length()-1)); }
;

Literal: Colon (~(Comma | RParen | '\n'))+ { setText(getText().substring(1).trim()); } ;

DataType
	: LBracket (~RBracket)+ RBracket 
	{ String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); }
	;

// locus(name, start, end, locus(start, end)+)

schema: objectSchema | attributeSchema;

objectSchema: Level+ QName (LParen attributeList RParen)?
	-> ^(ObjectSchema Level+ Name[$QName.text] attributeList?)
	;

attributeSchema: AttributeIndicator attributeList -> attributeList     
	;

attributeList: attribute (Comma! attribute)*
	;

attribute
	: QName DataType? attributeOption? 
	-> ^(ObjectAttribute Name[$QName.text] DataType? attributeOption?)
	| QName LParen attributeList RParen attributeOption? 
	-> ^(ObjectSchema Name[$QName.text] attributeList attributeOption?) 
	;


attributeOption
	: attributePlural
	| StringLiteral	-> Value[$StringLiteral.text]
	| Literal -> Value[$Literal.text]
	;

attributePlural
	: Star -> Occurrence["ZERO_OR_MORE"]
	| Plus -> Occurrence["ONE_OR_MORE"]
	| Question -> Occurrence["ZERO_OR_ONE"]
	| Level -> Occurrence["SEQUENCE"]
	| TabbedValueIndicator -> Occurrence["TABBED_SEQUENCE"]
	;



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
// Xerial RAQUEL - Relational-Style Amoeba Query Language
// 
// RelationSchema.g
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
  
grammar RelationSchema;
options 
{
	language=Java;
	// some lexer & parser options
	k=4;	// number of look-ahead characters 
	output=AST;	
}
tokens {
RelationSchema;
Relation;
Name;
Node;
Context;
Value;
FD;
Tree;
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
// Xerial RAQUEL - Relational-Style Amoeba Query Language
// 
// RelationSchemaLexer.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------

package org.xerial.lens.relation.schema.impl;
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
// Xerial RAQUEL - Relational-Style Amoeba Query Language
// 
// RelationSchemaParser.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
package org.xerial.lens.relation.schema.impl;

}

ML_COMMENT
	:   '/*' (options {greedy=false;} : .)* '*/' { $channel=HIDDEN; }
 	;

LINE_COMMENT
    : {getCharPositionInLine()==0}? => '//' ~('\n'|'\r')* NEWLINE { $channel=HIDDEN; }
    ;

NEWLINE
	: '\r'? '\n' { $channel=HIDDEN; }
	;


LParen: '(';
RParen: ')'; 
LBracket: '[';
RBracket: ']';
Comma: ',';
Equal: '=';
Plus: '+';
Star: '*';
Question: '?';

fragment At: '@';
 
fragment Quot: '"';
fragment Apos: '\'';
fragment Colon: ':';

fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment Digit: '0' .. '9';
Digits: (Digit)+;

fragment NameChar: Letter | Digit | '_' | '-';
WhiteSpaceChar: ( ' ' | '\t' | '\n' | '\r' | '\u000C')+ { $channel=HIDDEN; };

StringLiteral
: Quot (~'"')* Quot { String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); }
| Apos (~'\'')* Apos { String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); }
;

fragment NameFragment: (Letter | '_') NameChar*;

RelationDef: 'relation';

TreeDef:	'tree';

QName 
	: NameFragment Colon NameFragment
	| NameFragment
	| At NameFragment
	;

// locus(name, start, end, locus(start, end)+)

schema: schemaItem*
	-> ^(RelationSchema schemaItem*)
;

schemaItem
	: relationDef
	| treeDef
	;

relationDef: RelationDef QName LParen attributeList RParen 
	-> ^(Relation Name[$QName.text] attributeList)
	;
	
treeDef: TreeDef QName
	-> ^(Tree Name[$QName.text])
	;
		

attributeList: attribute (Comma! attribute)*
	;


attribute
	: QName attributePlural? 
	-> ^(Node Name[$QName.text] attributePlural?)
	;


attributePlural
	: Star -> FD["ZERO_OR_MORE"]
	| Plus -> FD["ONE_OR_MORE"]
	| Question -> FD["ZERO_OR_ONE"]
	;

/*
contextList
	: context (Comma! context)*
	; 

context 
	: QName Equal contextValue-> ^(Context Name[$QName.text] contextValue)
	;

	
contextValue
	: StringLiteral -> Value[$StringLiteral.text] 
	| Digits -> Value[$Digits.text]
	;	
	
*/	

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
//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// AmoebaQuery.g
// Since  2005/10/27 23:17:42
// 
//--------------------------------------------------

grammar AmoebaQuery;
options 
{
	language=Java;
	// some lexer & parser options
	k=4;	// number of look-ahead characters 
	output=AST;	
}
tokens {
NUMBER;
STRING;

SELECTION;
CONDITION;
PROJECTION;
PROJECT_ALL;
TARGET;
FUNCTION;
AND;
OR;
INPUT;
OUTPUT;
ASSIGN_LABEL;
COMPARE;
ATTRIBUTE;
REF;
VALUE;
CONTAINED_IN;
RELATION;
INSERT;
TARGET;
VALUE_SET;
NEW_VALUE;
NEW_RELATION;
UPDATE;
}


@lexer::header
{
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
//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// AmoebaQueryLexer.java
// Since  2005/10/27 23:17:42
// 
//--------------------------------------------------

package org.xerial.amoeba.query;
}


@header
{
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
//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// AmoebaQueryParser.java
// Since  2005/10/27 23:17:42
// 
//--------------------------------------------------
package org.xerial.amoeba.query;
}


/*
@rulecatch { 
catch(RecognitionException e){
	throw e;
}
} 
*/


ML_COMMENT
    :   '/*' (options {greedy=false;} : .)* '*/' {channel=HIDDEN;}
    ;
    
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

Dot: '.';
Colon: ';';
Comma: ',';
RParen: ')';
LParen: '(';
fragment Quot: '"';
fragment Apos: '\'';
At: '@';
Wildcard : '*';
EQUAL : '=';
NOT_EQUAL : '!=';
LESS : '<';
LEQ  : '<=';
GREATER : '>';
GEQ : '>=';


Select: 'select' | 'SELECT';
From: 'from' | 'FROM';
Where: 'where' | 'WHERE';
In: 'in' | 'IN';
Insert: 'insert' | 'INSERT';
Into: 'into' | 'INTO';



fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment Digit: '0' .. '9';
Digits: (Digit)+;

fragment NameChar: Letter | Digit | '_' | '-' | At;

WhiteSpaceChar: ( ' ' | '\t' | '\n' | '\r' | '\u000C')+ { $channel=HIDDEN; };

StringLiteral
: Quot! (~'"')* Quot!
| Apos! (~'\'')* Apos!;

//DoubleLiteral: (Digits (Dot (Digit)*)?) (('e'|'E') ('+'|'-')? Digits);

fragment Name: (Letter | '_') NameChar*;

QName 
	: Name Colon Name
	| Name
	;



integerLiteral: Digits;
decimalLiteral: Dot Digits| Digits Dot Digits;

literal:	
	| numericLiteral -> ^(NUMBER numericLiteral)
	| StringLiteral -> ^(STRING StringLiteral)
	;

numericLiteral 
	: integerLiteral 
	| decimalLiteral 
//	| DoubleLiteral
	;



amoebaQuery
	: selectExpr
	| updateExpr
	; 

updateExpr
	: Insert newRelation (Into targetRelation)? 
	  -> ^(INSERT ^(NEW_RELATION newRelation) ^(TARGET targetRelation)?)
	| 'update' 'set' newRelation whereClause?
	  -> ^(UPDATE ^(NEW_RELATION newRelation) ^(CONDITION whereClause)?) 
	;
	
newRelation
	: LParen tupleElement (Comma tupleElement)* RParen
		-> tupleElement+
	;
	
tupleElement
	: (attributeName -> attributeName) (EQUAL e=elementValue -> ^(NEW_VALUE $tupleElement elementValue) )?
	;
	
elementValue
	: literal
	  -> ^(VALUE literal)
	| '{' elementValue (Comma elementValue)? '}' 
	  -> ^(VALUE_SET elementValue+)
	;


exprSingle
	: selectExpr
	| subQuery
	;
	
subQuery
	: LParen selectExpr RParen -> selectExpr 
	; 
		
	
selectExpr
	: Select selectTarget fromClause? whereClause?
	 -> ^(SELECTION selectTarget ^(INPUT fromClause)? ^(CONDITION whereClause)?)
	;


selectTarget
	: labelExpr (Comma labelExpr)* -> ^(PROJECTION labelExpr+)
	| Wildcard -> PROJECT_ALL
	;

fromClause
	: From fromTarget (Comma fromTarget)* -> fromTarget+
	;

fromTarget
	: (targetRelation -> targetRelation) ('as' QName -> ^(ASSIGN_LABEL QName $fromTarget) )? 
	;

targetRelation
	: QName -> ^(RELATION QName)
	| subQuery
	;

whereClause
	: Where! orExpr	
	;
	
orExpr
	: (andExpr -> andExpr) ('or' a=andExpr -> ^(OR $orExpr $a))* 
	;
	
andExpr
	: (conditionExpr -> conditionExpr) ('and' c=conditionExpr -> ^(AND $andExpr $c))*
	;

	
conditionExpr options { backtrack=true; }
	: labelExpr c=comparisonOp labelExpr
	  -> ^(COMPARE comparisonOp labelExpr+) 
	| labelExpr In subQuery
	  -> ^(CONTAINED_IN labelExpr subQuery)
	;

comparisonOp: (EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like');
	
labelExpr
	: function	
	| attributeName 
	| value -> ^(VALUE value)
	; 
	
value
	: literal
	;

attributeName
	: QName -> ^(ATTRIBUTE QName)
	| relation=QName Dot attribute=QName -> ^(REF $relation $attribute)
	; 

	
function
	: QName LParen labelExpr (Comma labelExpr)* RParen
	-> ^(FUNCTION QName labelExpr+)
	;	




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
SilkLine;
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
import org.xerial.silk.impl.SilkLexerState;
import org.xerial.silk.impl.SilkLexerState.State;
import org.xerial.silk.impl.SilkLexerState.Symbol;
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

private SilkLexerState lexerContext = new SilkLexerState();

private State currentState() { return lexerContext.getCurrentState(); } 
private void transit(Symbol token) { lexerContext.transit(token); } 
private void resetContext() { lexerContext.reset(); }

}


// lexer rules

/*
fragment
ChPrintable
	: '\t' | LineBreakChar | '\u0020' .. '\u007E'          
	| '\u0085' | '\u00A0' .. '\uD7FF' | '\uE000' .. '\uFFFE' 
	;

fragment
PlainChar
	: '\t' | '\u0020' .. '\u007E'          
	| '\u0085' | '\u00A0' .. '\uD7FF' | '\uE000' .. '\uFFFE' 
	;

fragment NonSpaceChar	
	: '\u0021' .. '\u007E'          
	| '\u0085' | '\u00A0' .. '\uD7FF' | '\uE000' .. '\uFFFE' 
	;
*/	

// comment 
LineComment: '#' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }; 
Preamble: '%' ~('\n'|'\r')* '\r'? '\n'; 

// r: <CR> n : <LF>
fragment LineBreakChar: '\n' | '\r';

LineBreak
	: ('\r' '\n' | '\r' | '\n' ) 
	{ $channel=HIDDEN; resetContext(); }
	;		

		
fragment Digit: '0' .. '9';
fragment Letter: 'A' .. 'F' | 'a' .. 'f';
fragment HexDigit: Digit | Letter;
fragment UnicodeChar: ~('"'| '\\' | LineBreakChar);
fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	; 


fragment StringChar :  UnicodeChar | EscapeSequence;
fragment NonSpaceChar: ~('"'| '\\' | LineBreakChar | WhiteSpace ) | EscapeSequence;

fragment StringChar_s: StringChar*;
String: '"' s=StringChar_s '"' { setText($s.text); };

	
NodeStart: {getCharPositionInLine()==0}? (' ')* '-' { transit(Symbol.NodeStart); } ;
BlankLine: {getCharPositionInLine()==0}? WhiteSpace* LineBreak;

DataLine: {getCharPositionInLine()==0}? => WhiteSpace* ~('-' | '%' | '#' | WhiteSpace | LineBreakChar) ~('\n'|'\r')* LineBreak;

LParen: '(' { transit(Symbol.EnterParen); };  
RParen:	')';
Comma: 	',';
Colon:	':' { transit(Symbol.Colon); } ;
Seq: 	'>';
Star: 	'*';
At:		'@';
Plus:	'+';
LBracket:	'[' { transit(Symbol.EnterParen); };
RBracket:	']';
Question:	'?';
 
fragment PlainFirst
	: ~('"'| '\\' | LineBreakChar | WhiteSpace | Indicator ) 
	| EscapeSequence 
	| { currentState() == State.OUT }? => (':' | '?') NonSpaceChar
	;

fragment Indicator: '-' | ':' | '{' | '}' | '[' | ']' | '(' | ')' | ',' | '#' | '>' | '\'' | '"' | '@' | '%' | '\\';	
fragment FlowIndicator: ',' | '[' | ']' | '{' | '}';

fragment ScopeIndicator: '(' | ')';

fragment PlainSafeKey: ~('"'| '\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | ':' | FlowIndicator) | EscapeSequence; 
fragment PlainSafeIn: ~('"'| '\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | FlowIndicator) | EscapeSequence;	
fragment PlainSafeOut: ~('"'| '\\' | LineBreakChar | WhiteSpace | '#'| ScopeIndicator) | EscapeSequence;

fragment PlainSafe
	: { currentState() == State.KEY }? => PlainSafeKey
	| { currentState() == State.IN }? => PlainSafeIn 
	| { currentState() == State.OUT }? => PlainSafeOut
	;

fragment PlainChar: PlainSafe '#'?;

/*
fragment URIPrefix
	: ('http' | 'ftp' | 'https' | 'sftp' | 'rsync' ) '://'
	;

fragment URIChar
	: Letter | Digit | '%' HexDigit HexDigit
	| ';' | '/' | '?' | ':' | '@' | '&' | '=' | '+' | '$' | ','
	| '_' | '.' | '!' | '~' | '*' | '\'' | '(' | ')' | '[' | ']'
	;
*/
 
PlainOneLine
	: PlainFirst (WhiteSpace* PlainChar)* { transit(Symbol.LeaveValue); }
	;

Separation: { currentState() != State.INIT }? WhiteSpace+ { $channel=HIDDEN; };

WhiteSpace
	:	(' ' | '\t') 
	;		





// parser rules	

schema: node;

silkFile: silkLine* -> ^(Silk silkLine*)
	;

silkLine: silkLine_i -> ^(SilkLine silkLine_i)
	;

silkLine_i
	: Preamble
	| DataLine
	| BlankLine
	| node
	;


nodeName: PlainOneLine | String;
nodeValue: (PlainOneLine | String) -> Value[$nodeValue.text];

node: NodeStart (coreNode | function);

coreNode: nodeItem
	-> ^(SilkNode nodeItem)
	;

nodeItem: nodeName (Colon nodeValue)? (LParen attributeList RParen)? dataType? plural?
	-> Name[$nodeName.text] nodeValue? dataType? plural? attributeList? 
	;

dataType: LBracket! dataTypeName RBracket!
	;
	
dataTypeName: PlainOneLine
	-> DataType[$dataTypeName.text]
	; 	
	
attributeList: attributeItem (Comma! attributeItem)* ;	
attributeItem: nodeItem -> ^(SilkAttribute nodeItem);


plural
	: Star -> Occurrence["ZERO_OR_MORE"]
	| Plus -> Occurrence["ONE_OR_MORE"]
	| Question -> Occurrence["ZERO_OR_ONE"]
	| Seq -> Occurrence["SEQUENCE"]
	;

function: At PlainOneLine LParen (functionArg (Comma functionArg)*)? RParen
	-> ^(Function[$PlainOneLine.text] functionArg*)
	;

functionArg
	: nodeValue -> Argument[$functionArg.text]
	| nodeName Colon nodeValue -> ^(KeyValuePair Key[$nodeName.text] nodeValue)
	;






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
	//backtrack=true;
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
import org.xerial.util.log.Logger;
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

private static Logger _logger = Logger.getLogger(SilkLexer.class);
public static final int JSON_CHANNEL = 1; 

private SilkLexerState lexerContext = new SilkLexerState();

private State currentState() { return lexerContext.getCurrentState(); } 
private void transit(Symbol token) { lexerContext.transit(token); } 
private void resetContext() { lexerContext.reset(); }
private boolean isKey() { return currentState() == State.IN_KEY || currentState() == State.OUT_KEY; }
private boolean isValue() { return currentState() == State.IN_VALUE || currentState() == State.OUT_VALUE || currentState() == State.JSON; }
private boolean isInValue() { return currentState() == State.IN_VALUE; }
private boolean isOutValue() { return currentState() == State.OUT_VALUE; }
private boolean isJSON() { return currentState() == State.JSON; }
private boolean isHead() { return getCharPositionInLine() == 0; }
}


// lexer rules

// comment 
LineComment: '#' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; }; 
Preamble: '%' ~('\n'|'\r')* '\r'? '\n'; 

// r: <CR> n : <LF>
fragment LineBreakChar: '\n' | '\r';

LineBreak
	: ('\r' '\n' | '\r' | '\n' ) 
	{ $channel=HIDDEN; resetContext(); }
	;		

	
NodeStart: { isHead() }? (' ')* '-' { transit(Symbol.NodeStart); } ;
BlankLine: { isHead() }? WhiteSpace* LineBreak;

DataLine: { isHead() }? => WhiteSpace* ~('-' | '%' | '#' | WhiteSpace | LineBreakChar) ~('\n'|'\r')* LineBreak;

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

fragment Digit: '0' .. '9';
fragment Letter: 'A' .. 'F' | 'a' .. 'f';
fragment HexDigit: Digit | Letter;
fragment UnicodeChar: ~('"'| '\\' | LineBreakChar);
fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	; 


fragment StringChar :  UnicodeChar | EscapeSequence;
fragment NonSpaceChar: ~('"'| '\\' | LineBreakChar | WhiteSpace );

fragment StringChar_s: StringChar*;
String: '"' s=StringChar_s '"' { setText($s.text); };

 
fragment PlainFirst
	: ~('"'| '\\' | LineBreakChar | WhiteSpace | Indicator ) 
	| { isValue() }? => (':' | '?') NonSpaceChar
	;

fragment ScopeIndicator: '(' | ')';
fragment FlowIndicator:  '[' | ']' | '{' | '}';
fragment Indicator:  FlowIndicator | ScopeIndicator | ',' | '-' | ':' | '#' | '>' | '\'' | '"' | '@' | '%' | '\\';	


fragment PlainUnsafeChar: '"'| '\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator;

fragment PlainSafeKey: ~(PlainUnsafeChar | FlowIndicator | ',' | ':' | '>'); 
fragment PlainSafeIn: ~(PlainUnsafeChar | ',');
fragment PlainSafeOut: ~(PlainUnsafeChar);


fragment PlainSafe
	: { isKey() }? => PlainSafeKey
	| { isInValue() }? => PlainSafeIn 
	| { isOutValue() }? => PlainSafeOut
	;

 
PlainOneLine: PlainFirst (WhiteSpace* PlainSafe)* { transit(Symbol.LeaveValue); }
		;
	

/*	
fragment JSONSafe_i
	: ('[' | '{') { transit(Symbol.EnterJSONFragment); }
	| (']' | '}') { transit(Symbol.LeaveJSONFragment); }
	| ~(PlainUnsafeChar | '[' | ']' | '{' | '}')
	| String
	;  

	
fragment JSONSafe : { isJSON() }? => (WhiteSpace* JSONSafe_i)+;
	
fragment JSONFirst: { isValue() }? => ('{' | '[') { transit(Symbol.EnterJSONFragment); } 
	;	


fragment Int: '-'? ('0' | '1'..'9' Digit*);
fragment Frac: '.' Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;
fragment Double: Int (Frac Exp? | Exp);

fragment JSONObject: '{' JSONElement (',' JSONElement)* '}';
fragment JSONElement: String ':' JSONValue; 
fragment JSONArray: '[' JSONValue (',' JSONValue)* ']';

fragment JSONValue
	: String
	| Int
	| Double
	| 'true'
	| 'false'
	| 'null'
	;

fragment JSON_i
	: JSONObject
	| JSONArray 
	;

*/

JSON
	: { isValue() }? => '{'
	{
		//_logger.info("enter JSON object");
		InLineJSONLexer l = new InLineJSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(l);
		InLineJSONParser p = new InLineJSONParser(tokens);
		p.jsonObjectFragment();
		
		$channel = JSON_CHANNEL;
		emit(new CommonToken(JSON, getText())); 
	}
	| { isValue() }? => '['
	{
		//_logger.info("enter JSON array");
		InLineJSONLexer l = new InLineJSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(l);
		InLineJSONParser p = new InLineJSONParser(tokens);
		p.jsonArrayFragment();
		
		$channel = JSON_CHANNEL;
		emit(new CommonToken(JSON, getText())); 
	}  
	;
	 
Separation: { currentState() != State.INIT }? WhiteSpace+ { $channel=HIDDEN; };

WhiteSpace
	:	(' ' | '\t') 
	;		


// parser rules	

schema: node;

silkFile: silkLine* -> ^(Silk silkLine*)
	;

silkLine
	: node -> ^(SilkLine node)
	| Preamble
	| DataLine
	| BlankLine
	;



nodeName: PlainOneLine | String;
nodeValue
	: (PlainOneLine | String) -> Value[$nodeValue.text]
	| JSON 
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






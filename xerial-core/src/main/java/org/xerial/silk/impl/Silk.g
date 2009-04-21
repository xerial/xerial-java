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
	k=3;	
	//backtrack=true;
}
tokens {
Silk;
SilkNode;
//SilkAttribute;
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

private SilkLexerState lexerContext = new SilkLexerState();

private State currentState() { return lexerContext.getCurrentState(); } 
private void transit(Symbol token) { lexerContext.transit(token); } 
private void resetContext() { lexerContext.reset(); }
private boolean isKey() { return currentState() == State.IN_KEY || currentState() == State.OUT_KEY; }
private boolean isValue() { return currentState() == State.IN_VALUE || currentState() == State.OUT_VALUE; }
private boolean isInValue() { return currentState() == State.IN_VALUE; }
private boolean isOutValue() { return currentState() == State.OUT_VALUE; }
private boolean isHead() { return getCharPositionInLine() == 0; }
}


// lexer rules

// comment 
LineComment: '#' ~('\n'|'\r')* LineBreak { $channel=HIDDEN; }; 
Preamble: '%' ~('\n'|'\r')* LineBreak; 

// r: <CR> n : <LF>
fragment LineBreakChar: '\n' | '\r';

LineBreak
	: ('\r' '\n' | '\r' | '\n' ) 
	{ $channel=HIDDEN; resetContext(); }
	;		

MultiLineSeparator: { isHead() }? => '--' WhiteSpace* LineBreak;
MultiLineEntrySeparator: { isHead() }? => '>>' WhiteSpace* LineBreak;
 	
NodeIndent: { isHead() }? (' ')* '-' { transit(Symbol.NodeStart); } ;
FunctionIndent: { isHead() }? => (' ')* '@' { transit(Symbol.NodeStart); } ;
BlankLine: { isHead() }? => WhiteSpace* LineBreak;

fragment DataLineBody: ~('-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar) ~('#' | '\n'|'\r')*;
DataLine: { isHead() }? 
	=> WhiteSpace* DataLineBody (LineBreak|LineComment) { setText($DataLineBody.text); };

LParen: '(' { transit(Symbol.EnterParen); };  
RParen:	')' { transit(Symbol.LeaveParen); };
Comma: 	','; 
Colon:	':' { transit(Symbol.Colon); } ;


Seq: 	'>';
TabSeq:	'|';
Star: 	'*';
At:		'@' { transit(Symbol.At); };
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

 

fragment ScopeIndicator: '(' | ')';
fragment FlowIndicator:  '[' | ']' | '{' | '}';
fragment Indicator:  FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\'' | '"' | '@' | '%' | '\\';	


fragment PlainUnsafeChar: '"'| '\\' | LineBreakChar | '#' ;

fragment PlainSafeKey: ~(PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|'); 
fragment PlainSafeIn: ~(PlainUnsafeChar | ScopeIndicator | ',');
fragment PlainSafeOut: ~(PlainUnsafeChar);

fragment PlainFirst
	: { isInValue()? } => ~('"'| '\\' | LineBreakChar | WhiteSpace | Indicator ) 
	| ~('"'| '\\' | '-' | LineBreakChar | WhiteSpace | Indicator ) 
	| { isValue() }? => (':' | '?') NonSpaceChar
	;

fragment PlainSafe
	: { isKey() }? => PlainSafeKey
	| { isInValue() }? => PlainSafeIn 
	| { isOutValue() }? => PlainSafeOut
	;
 
PlainOneLine: PlainFirst (WhiteSpace* PlainSafe)* { transit(Symbol.LeaveValue); }  
		;

JSON
	: { isValue() }? => '{'
	{
		//_logger.info("enter JSON object");
		InLineJSONLexer l = new InLineJSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(l);
		InLineJSONParser p = new InLineJSONParser(tokens);
		p.jsonObjectFragment();
		
		//$channel = JSON_CHANNEL;
		emit(new CommonToken(JSON, getText())); 
	}
	| { isValue() }? => '['
	{
		//_logger.info("enter JSON array");
		InLineJSONLexer l = new InLineJSONLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(l);
		InLineJSONParser p = new InLineJSONParser(tokens);
		p.jsonArrayFragment();
		
		//$channel = JSON_CHANNEL;
		emit(new CommonToken(JSON, getText())); 
	}  
	;
	 
Separation: { !isHead() }? WhiteSpace+ { $channel=HIDDEN; };

WhiteSpace
	:	(' ' | '\t') 
	;		


// parser rules	


silkFile: silkLine* -> ^(Silk silkLine*)
	;

silkLine
	: NodeIndent nodeItem -> ^(SilkNode NodeIndent nodeItem)
	| noNameNode 
	| function
	| Preamble
	| DataLine
	| BlankLine
	| MultiLineSeparator
	| MultiLineEntrySeparator
	| WhiteSpace -> BlankLine
	;

fragment
nodeName: PlainOneLine | String;

fragment
nodeValue
	: function_i -> ^(Function function_i)
	| (PlainOneLine | String) -> Value[$nodeValue.text]
	| JSON 
	; 


fragment
noNameNode: NodeIndent (LParen attributeList RParen)? plural? (Colon nodeValue)?
	-> ^(SilkNode NodeIndent attributeList? plural? nodeValue?)  
	;

fragment
nodeItem: nodeName dataType?  (LParen attributeList RParen)? plural? (Colon nodeValue)?
	-> Name[$nodeName.text.trim()] dataType? attributeList? plural? nodeValue?  
	;

fragment
dataType: LBracket! dataTypeName RBracket!
	;

fragment	
dataTypeName: PlainOneLine
	-> DataType[$dataTypeName.text]
	; 	
	
fragment
attributeList: attributeItem (Comma! attributeItem)* ;	

fragment
attributeItem: nodeItem -> ^(SilkNode nodeItem);

fragment
seqseq: Seq Seq;

fragment
plural
	: Star -> Occurrence["ZERO_OR_MORE"]
	| Plus -> Occurrence["ONE_OR_MORE"]
	| Question -> Occurrence["ZERO_OR_ONE"]
	| seqseq -> Occurrence["MULTILINE_SEQUENCE"]
	| Seq -> Occurrence["SEQUENCE"]
	| TabSeq -> Occurrence["TABBED_SEQUENCE"]
	;

function
	: NodeIndent function_i
	-> ^(Function NodeIndent function_i)
	| FunctionIndent PlainOneLine LParen (functionArg (Comma functionArg)*)? RParen
	-> ^(Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] functionArg*)
	;

fragment
function_i: At PlainOneLine LParen (functionArg (Comma functionArg)*)? RParen
	-> Name[$PlainOneLine.text.trim()] functionArg*
	;

fragment
functionArg
	: nodeValue -> Argument[$functionArg.text]
	| nodeName Colon nodeValue -> ^(KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()])
	;






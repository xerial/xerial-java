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
// LensQuery.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
 
grammar LensQuery;
options 
{
  language=Java;
  output=AST;
}
tokens {
  QUERY;
  RELATION;
  COMPARE;
  OPERATOR;
  OPERAND;
  PATTERNMATCH;
  NODE;
  ALIAS;
  NODEVALUE;
  NAME;
  VALUE;
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
// LensQueryLexer.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------

package org.xerial.lens.relation.query.impl;

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
// LensQueryParser.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
package org.xerial.lens.relation.query.impl;

}

@lexer::members {

}

@members {
} 

// lexer rules

// Line Comment
fragment LineBreakChar: '\n' | '\r'; // r: <CR> n : <LF>
LineComment: '#' ~(LineBreakChar)* { $channel = HIDDEN; };


LineBreak: ('\r' '\n' | '\r' | '\n' ) { $channel = HIDDEN; }; 


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


Integer: '-'? ('0' | '1'..'9' Digit*);
fragment Frac: '.' Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;
Double: Integer (Frac Exp? | Exp);

True: 'true';
False: 'false';
Null: 'null';


// comparison operator
Lt: '<';
Gt: '>';
Leq: '<=';
Geq: '>=';
Eq: '=';
Neq: '!=';
Match: '~=';
Regex: '/'  (options{greedy=false;}: .)* '/' ('a' .. 'z' | 'A' .. 'Z')* ;


Dot: '.';
Comma: ',';
Colon: ':';

As: 'as';

LParen: '(';  
RParen: ')';

Star: '*';

fragment
UnsafeUnicodeChar: '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\'' | '"' | '@' | '%' | '\\' | '.' | '-'; 

fragment SafeFirstLetter: 'A' .. 'Z' | 'a' .. 'z';
fragment SafeLetter: SafeFirstLetter | '0' .. '9' | '-' | '_';


fragment QNameChar: ~(LineBreakChar | UnsafeUnicodeChar | WhiteSpace);
QName: QNameChar+ (Dot QNameChar+)*;


fragment 
WhiteSpace: ' ' | '\t';
 
WhiteSpaces: WhiteSpace+ { $channel = HIDDEN; }; 

 
// parser rules 
 
expr:
  relation 
  ; 
 
relation 
   : relation_i -> ^(RELATION relation_i)
;

relation_i: nodeName alias? LParen! nodeItem (Comma! nodeItem)* RParen!;


fragment
nodeName
  : QName -> NAME[$QName.text]
  | String -> NAME[$String.text]
  ;

fragment
alias: As QName -> ALIAS[$QName.text];
  

fragment
nodeItem
  : nodeName alias? nodeValue? 
    -> ^(NODE nodeName alias? nodeValue?)
  | relation 
  ;

fragment
value
  : String | Integer | Double | QName
  ;  
  
fragment  
nodeValue
  : Colon value -> NODEVALUE[$value.text]
  | nodeCmp 
  ;  

fragment  
nodeCmp
  : cmpOp value -> ^(COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text])
  | Match Regex -> ^(PATTERNMATCH OPERAND[$Regex.text])
  ;
  
fragment  
cmpOp: (Lt | Gt | Eq | Leq | Geq | Neq) 
  ;
  
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
// XPath.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
 
grammar XPath;
options 
{
  language=Java;
  output=AST;
}
tokens {
  XPATH;
  NAME;
  VALUE;
  STEP;
  AXIS;
  PREDICATE;
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
// XPathLexer.g
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
// XPathParser.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
package org.xerial.lens.relation.query.impl;


}

@lexer::members {

}

@members {

} 

//-------------------------
// lexer rules
//-------------------------

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

// comparison operator

Comma: ',';
Colon: ':';



fragment
UnsafeUnicodeChar: '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\'' | '"' | '@' | '%' | '\\' | '.' | '-'; 

fragment SafeFirstLetter: 'A' .. 'Z' | 'a' .. 'z';
fragment SafeLetter: SafeFirstLetter | '0' .. '9' | '-' | '_';

fragment QNameChar: ~(LineBreakChar | UnsafeUnicodeChar | WhiteSpace | '/' | '//');
QName: QNameChar+ ('.' QNameChar+)*;


fragment 
WhiteSpace: ' ' | '\t';
 
WhiteSpaces: WhiteSpace+ { $channel = HIDDEN; }; 



//---------------------------
// parser rules
//---------------------------

xpath
  : locationExpr
  -> ^(XPATH locationExpr)
  ; 

fragment
locationExpr
  : relativePath
  | absolutePath
  ;
  
fragment
relativePath
  : step 
  -> ^(STEP step)
  | (step '/') => step '/' relativePath
  -> ^(STEP AXIS["PC"] step relativePath)  
  | (step '//') => step '//' relativePath 
  -> ^(STEP AXIS["AD"] step relativePath)
  ;

fragment
absolutePath
  : '/' relativePath 
  -> ^(STEP AXIS["PC"] NAME["_root"] relativePath)
  ;
  
fragment
step
  : nodeTest predicate* -> NAME[$nodeTest.text] predicate* 
  ;

  
fragment
nodeTest
  : '@'? (QName ':')? QName 
  ;  

fragment
predicate
  : '[' expr ']'
  -> ^(PREDICATE expr)
  ;

expr
  : comparisonExpr
  ;

fragment
comparisonExpr
  : pathExpr
  | (pathExpr '=') => pathExpr '=' pathExpr
  | (pathExpr '!=') => pathExpr '!=' pathExpr
  | (pathExpr '>') => pathExpr '>' pathExpr
  | (pathExpr '>=') => pathExpr '>=' pathExpr
  | (pathExpr '<') => pathExpr '<' pathExpr
  | (pathExpr '<=') => pathExpr '<=' pathExpr
  | (pathExpr '~=') => pathExpr '~=' pathExpr
  ;


fragment
pathExpr
  : locationExpr
  | primaryExpr 
  ;
   
fragment
primaryExpr
  : String
  | Integer
  | Double
  | functionCall  
  ;
  

fragment
functionCall
  : QName '(' (expr (',' expr)*)? ')'
  ;  
  
  
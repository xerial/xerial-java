/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// XerialJ Project
//
// CSV.g
// Since: 2010/01/20
//
//--------------------------------------
 
grammar CSV;
options
{
  language=Java;
}
  
 
@lexer::header
{
//--------------------------------------
// XerialJ Project
//
// CSVLexer.java
// Since: 2010/01/20
//
//--------------------------------------
package org.xerial.util.impl;
}

@lexer::members {
  
}

@header
{
//--------------------------------------
// XerialJ Project
//
// CSVParser.java
// Since: 2010/01/20
//
//--------------------------------------
package org.xerial.util.impl;
}


WhiteSpace: (' ' | '\r' | '\t' | '\u000C' | '\n') { $channel=HIDDEN; };

fragment Digit: '0' .. '9';
fragment Letter: 'A' .. 'F' | 'a' .. 'f';
fragment HexDigit: Digit | Letter;
fragment UnicodeChar: ~('"'| '\\');
fragment EscapeSequence
  : '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
  ; 

fragment StringChar :  UnicodeChar | EscapeSequence;
fragment StringChar_s: StringChar*;
String
  : '"' s=StringChar_s '"' { setText($s.text); }
  | (~('"' | ','))* 
  ;

Comma: ',';

csvLine: csvElement (Comma csvElement)*;

csvElement: String;


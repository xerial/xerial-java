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
// SilkSchema.g
// Since: Jun 23, 2009 1:00:02 PM
//
//--------------------------------------
 
grammar SilkSchema;
options 
{
  language=Java;
  output=AST;
}
tokens {
  Schema;
  Module;
  ClassDef;
  Name;
  Parent;
  Mixin;
  Attribute;
  IsArray;
  TypeName;
  DefaultValue;
  AllIncluded;
  TargetClass;
  Function;
  Argument;
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
// SilkSchemaLexer.java
// Since: Jun 28, 2009 1:00:02 PM
//
//--------------------------------------

package org.xerial.silk.schema.impl;

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
// SilkSchemaParser.java
// Since: Jun 23, 2009 1:00:02 PM
//
//--------------------------------------
package org.xerial.silk.schema.impl;
}

@lexer::members {
  
}
 

// lexer rules

// preamble
Preamble: { getCharPositionInLine() == 0 }? => '%' ~(LineBreakChar)*; 

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

LBrace: '{' ;
RBrace: '}' ;
LBracket: '[' ;
RBracket: ']' ;

Lt: '<';
Dot: '.';
Comma: ',';

LParen: '(';  
RParen: ')';

Star: '*';

fragment
UnsafeUnicodeChar: '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\'' | '"' | '@' | '%' | '\\' | '.' | '-';	

fragment
NonWhiteSpaceChar: ~(UnsafeUnicodeChar | '\r' | '\n' | ' ' | '\t' | '\u000C');

fragment SymbolChars: NonWhiteSpaceChar+;
Symbol: (':' NonWhiteSpaceChar) =>  ':' s=SymbolChars { setText($s.text); };

Class: 'class';
Includes: 'includes';
End: 'end';
Relation: 'relation';
Index: 'index';
BelongsTo: 'belongs_to';
Default: 'default';
Projection: 'projection';
OrderBy: 'order_by';

fragment SafeFirstLetter: 'A' .. 'Z' | 'a' .. 'z';
fragment SafeLetter: SafeFirstLetter | '0' .. '9' | '-' | '_';

fragment ModuleName: SafeFirstLetter SafeLetter* ('.' SafeFirstLetter SafeLetter*)*; 
ModuleDef: 'module' WhiteSpaces s=ModuleName { setText($s.text); }; 

fragment QNameChar: ~(LineBreakChar | UnsafeUnicodeChar | WhiteSpace);
QName: QNameChar+ (Dot QNameChar+)*;

fragment 
WhiteSpace: ' ' | '\t';
 
WhiteSpaces: WhiteSpace+ { $channel = HIDDEN; }; 

 
// parser rules 
 
schema:  Preamble? schemaElement*  -> ^(Schema Preamble? schemaElement*) ;
  

schemaElement
  : classDefinition 
  | projectionDef
  | moduleDefinition
  ;


moduleDefinition:
	ModuleDef schemaElement* End 
	-> ^(Module Name[$ModuleDef.text] schemaElement*)  
	;  
  
classDefinition
  : Class QName inheritance? classBody? End -> ^(ClassDef Name[$QName.text] inheritance? classBody?)
    | Relation QName inheritance? classBody? End -> ^(Relation Name[$QName.text] inheritance? classBody?)
  ; 
  
classBody: (belongsToStatement | includeStatement | attributes | indexStatement)+;


projectionDef: Projection c=QName 'on' t=QName (projectColumn (Comma? projectColumn)*) orderByColumns? End 
 -> ^(Projection Name[$c.text] TargetClass[$t.text] projectColumn+ orderByColumns?);

fragment
projectColumn
  : QName  -> Attribute[$QName.text]
  | Star -> AllIncluded["true"] 
  | Symbol -> Attribute[$Symbol.text]
;

fragment
orderByColumns
  : OrderBy orderByItem (Comma orderByItem)* -> orderByItem+
;

fragment
orderByItem
  : QName -> OrderBy[$QName.text] 
  | Symbol -> OrderBy[$Symbol.text]
//  | QName LParen (functionArg (Comma functionArg)*)? RParen -> ^(Function Name[$QName.text] functionArg*) 
;

fragment
functionArg: Symbol -> Argument[$Symbol.text]
;

fragment 
belongsToStatement: BelongsTo QName -> BelongsTo[$QName.text]; 
  
fragment 
inheritance: Lt QName -> Parent[$QName.text];
  
fragment 
includeStatement: Includes includeItem (Comma includeItem)* -> includeItem+;

fragment 
includeItem: QName -> Mixin[$QName.text];

fragment 
indexStatement: Index QName indexTarget (Comma indexTarget)*
  -> ^(Index TypeName[$QName.text] indexTarget+)
; 

fragment 
indexTarget: Symbol -> Attribute[$Symbol.text]  
; 


fragment 
attributes: attribute (Comma attribute)* 
  -> attribute+
  ; 
	
fragment 
attribute:
  Symbol attributeType? (Default attributeValue)?  
  -> ^(Attribute Name[$Symbol.text] attributeType? attributeValue?)  
  ; 

attributeValue
  : (String | Double | Integer) -> DefaultValue[$attributeValue.text]; 
  
fragment attributeType
  : QName -> TypeName[$QName.text] 
  | QName Star -> TypeName[$QName.text] IsArray["true"]
  ;

  
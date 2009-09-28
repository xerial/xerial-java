//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTD.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

//----------
// This grammar is written based on the XML specification:  
// http://www.w3.org/TR/2008/REC-xml-20081126/#sec-prolog-dtd
//----------
grammar DTD;
options 
{
	language=Java;
	output=AST;
	// some lexer & parser options
	// number of look-ahead characters 
	// 	k=4;	
	
} 

tokens {
DTD;
STRINGTYPE;
TOKENIZEDTYPE;
ENUMTYPE;
NAME;
ATTRIBUTE;
ATTLIST;
DECL;
TYPE;
ELEMENT;
COMPONENT;
OCCURRENCE;
CONTENTSPEC;
}

 
@lexer::header
{
//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDLexer.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

package org.xerial.util.xml.dtd.impl;
import org.xerial.util.log.Logger;

}

@lexer::rulecatch {
catch(RecognitionException e){
	Logger.getLogger(this.getClass()).warn(e);
}
}


@header
{
//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDParser.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------
package org.xerial.util.xml.dtd.impl;
//import org.xerial.util.log.Logger;
}

/*
@rulecatch { 
catch(RecognitionException e){
	Logger.getLogger(this.getClass()).warn(e);
}
} 
*/

ML_COMMENT
    :   '<!--' (options {greedy=false;} : .)* '-->' {$channel=HIDDEN;}
    ;

At: '@';
Colon: ':';
Comma: ',';
Apos: '\'';
Quot: '"';
Dot: '.';
SemiColon: ';';

LParen: '(';
RParen: ')';

fragment Letter: 'a' .. 'z' | 'A' .. 'Z';
fragment Digit: '0' .. '9';
Digits: (Digit)+;

fragment NameChar: Letter | Digit | '_' | '-' | At;

WhiteSpaceChar: ( ' ' | '\t' | '\n' | '\r' | '\u000C')+ { $channel=HIDDEN; };

StringLiteral
: Quot (~'"')* Quot
| Apos (~'\'')* Apos;

Name: (Letter | '_') NameChar*;


fragment AttValue: 
    Quot (~('<' | '&' | Quot) | Reference)* Quot 
    | Apos (~('<' | '&' | Apos) | Reference)* Apos 
	; 
	
Reference: EntityRef | CharRef;
fragment EntityRef: '&' Name SemiColon;
fragment CharRef: '&#' ('0'..'9')+ SemiColon | '&#x' ('0'..'9' | 'a'..'f' | 'A'..'F')+ SemiColon
	;
	
DefaultDecl: '#REQUIRED' | '#IMPLIED' | ('#FIXED'? AttValue); 

Element: '<!ELEMENT';


/*
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
	*/

dtd: markupdecl*
  -> ^(DTD markupdecl*)
;

fragment
markupdecl: elementDecl | attlistDecl;

elementDecl: Element Name contentSpec '>'
  -> ^(ELEMENT NAME[$Name.text] contentSpec)
	;
	
fragment
contentSpec
  : 'EMPTY' -> CONTENTSPEC["EMPTY"]
  | 'ANY'   -> CONTENTSPEC["ANY"]
  | mixed 
  | children  
	;	
	
fragment
children 
: (choice) => choice  plural? -> ^(COMPONENT  TYPE["choice"] choice plural?)
| (seq) => seq plural? -> ^(COMPONENT TYPE["seq"] seq plural?)
;
	
fragment
cp 
: (Name) => Name  plural? -> ^(COMPONENT NAME[$Name.text] plural?)
|  (choice) => choice  plural? -> ^(COMPONENT TYPE["choice"] choice plural?)
|  (seq) => seq  plural? -> ^(COMPONENT TYPE["seq"] seq plural?)
;

fragment
plural
  : '?' -> OCCURRENCE["ZERO_OR_ONE"]
  | '*' -> OCCURRENCE["ZERO_OR_MORE"]
  | '+' -> OCCURRENCE["ONE_OR_MORE"]
  ;
  

fragment
choice: LParen cp ('|' cp)* RParen
  -> cp+
	;
	
fragment
seq: (LParen cp Comma) => LParen cp (Comma cp)+ RParen
  -> cp+
	;
	
fragment
mixed
  : LParen '#PCDATA' ('|' mixed_i)* RParen '*'
    -> ^(COMPONENT TYPE["mixed"] mixed_i*)
	|  LParen '#PCDATA' RParen 
    -> ^(COMPONENT TYPE["pcdata"])
	;
	 	
mixed_i
  : Name -> NAME[$Name.text]
  ;	 	
	 	
attlistDecl: '<!ATTLIST' Name attDef* '>'
  -> ^(ATTLIST NAME[$Name.text] attDef*)
	;
	
fragment
attDef: Name attType DefaultDecl
  -> ^(ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text.substring(1])
	;
		
fragment
attType
  : stringType -> STRINGTYPE[$stringType.text] 
  | tokenizedType -> TOKENIZEDTYPE[$tokenizedType.text] 
  | enumeratedType -> ENUMTYPE[$enumeratedType.text]
  ;

fragment
enumeration: LParen Name ('|' Name)* RParen;
fragment
enumeratedType: notationType | enumeration;
fragment
notationType: 'NOTATION' LParen Name ('|' Name)* RParen;

fragment
stringType: 'CDATA'
	;

fragment
tokenizedType
  : 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS'
	;

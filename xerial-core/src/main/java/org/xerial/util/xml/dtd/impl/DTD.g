//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTD.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

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
NUMBER;
STRING;
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

dtd: markupdecl*;

markupdecl: elementDecl | attlistDecl;


elementDecl: Element Name contentSpec '>'
	;
	
contentSpec: 'EMPTY' | 'ANY' | mixed | children
	;	
	
children 
: (choice) => choice  ('?' | '*' | '+')?
| (seq) => seq ('?' | '*' | '+')?
;
	
cp 
: (Name) => Name  ('?' | '*' | '+')?
|  (choice) => choice  ('?' | '*' | '+')?
|  (seq) => seq  ('?' | '*' | '+')?
;

choice: LParen cp ('|' cp)* RParen
	;
	
seq: (LParen cp Comma) => LParen cp (Comma cp)+ RParen
	;
	
mixed: LParen '#PCDATA' ('|' Name)* RParen '*'	
	|  LParen '#PCDATA' RParen
	;
	 	
attlistDecl: '<!ATTLIST' Name attDef* '>'
	;
	
attDef: Name attType DefaultDecl
	;
		
attType: stringType | tokenizedType | enumeratedType;

enumeration: LParen Name ('|' Name)* RParen;
enumeratedType: notationType | enumeration;
notationType: 'NOTATION' LParen Name ('|' Name)* RParen;

stringType: 'CDATA'
	;

tokenizedType: 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS'
	;

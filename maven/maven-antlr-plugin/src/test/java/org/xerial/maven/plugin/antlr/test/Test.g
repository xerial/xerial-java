grammar Test;
options
{
	language=Java;
	output=AST;	
}

tokens {
Sample;
}

@lexer::header
{
package org.xerial.maven.plugin.antlr.test;
}
@header
{
package org.xerial.maven.plugin.antlr.test;
}

ML_COMMENT
	:   '/*' (options {greedy=false;} : .)* '*/' { $channel=HIDDEN; }
 	;

At: '@';


test: At;



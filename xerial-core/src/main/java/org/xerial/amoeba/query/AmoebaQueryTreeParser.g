//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// AmoebaQueryTreeParser.g
// Since  2007/04/25 11:07:10
// 
//--------------------------------------------------

tree grammar AmoebaQueryTreeParser;
options {
	tokenVocab=AmoebaQuery;
	ASTLabelType=CommonTree;
}

@header
{
package org.xerial.amoeba.query;
}


query
	: selectClause
	;

	
selectClause
	: ^(Select expr)
	;
	
	
expr: QName 
	;
	
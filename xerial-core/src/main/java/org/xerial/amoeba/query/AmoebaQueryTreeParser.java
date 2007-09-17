// $ANTLR 3.0.1 D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g 2007-09-17 19:26:58

package org.xerial.amoeba.query;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AmoebaQueryTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "SELECTION", "CONDITION", "PROJECTION", "PROJECT_ALL", "TARGET", "FUNCTION", "AND", "OR", "INPUT", "OUTPUT", "ASSIGN_LABEL", "COMPARE", "ATTRIBUTE", "REF", "VALUE", "CONTAINED_IN", "RELATION", "INSERT", "VALUE_SET", "NEW_VALUE", "NEW_RELATION", "UPDATE", "ML_COMMENT", "LINE_COMMENT", "Dot", "Colon", "Comma", "RParen", "LParen", "Quot", "Apos", "At", "Wildcard", "EQUAL", "NOT_EQUAL", "LESS", "LEQ", "GREATER", "GEQ", "Select", "From", "Where", "In", "Insert", "Into", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "Name", "QName", "'update'", "'set'", "'{'", "'}'", "'as'", "'or'", "'and'", "'like'"
    };
    public static final int FUNCTION=11;
    public static final int Insert=49;
    public static final int Apos=36;
    public static final int Wildcard=38;
    public static final int ATTRIBUTE=18;
    public static final int INPUT=14;
    public static final int Where=47;
    public static final int UPDATE=27;
    public static final int CONDITION=7;
    public static final int Into=50;
    public static final int AND=12;
    public static final int EOF=-1;
    public static final int SELECTION=6;
    public static final int ML_COMMENT=28;
    public static final int GREATER=43;
    public static final int ASSIGN_LABEL=16;
    public static final int INSERT=23;
    public static final int Digits=53;
    public static final int CONTAINED_IN=21;
    public static final int NOT_EQUAL=40;
    public static final int WhiteSpaceChar=55;
    public static final int NEW_VALUE=25;
    public static final int EQUAL=39;
    public static final int LESS=41;
    public static final int COMPARE=17;
    public static final int Select=45;
    public static final int GEQ=44;
    public static final int VALUE_SET=24;
    public static final int NEW_RELATION=26;
    public static final int Quot=35;
    public static final int PROJECT_ALL=9;
    public static final int RParen=33;
    public static final int In=48;
    public static final int QName=58;
    public static final int At=37;
    public static final int LParen=34;
    public static final int LINE_COMMENT=29;
    public static final int NUMBER=4;
    public static final int NameChar=54;
    public static final int RELATION=22;
    public static final int Colon=31;
    public static final int TARGET=10;
    public static final int VALUE=20;
    public static final int Digit=52;
    public static final int REF=19;
    public static final int From=46;
    public static final int StringLiteral=56;
    public static final int OR=13;
    public static final int Dot=30;
    public static final int Name=57;
    public static final int PROJECTION=8;
    public static final int Comma=32;
    public static final int OUTPUT=15;
    public static final int Letter=51;
    public static final int STRING=5;
    public static final int LEQ=42;

        public AmoebaQueryTreeParser(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g"; }



    // $ANTLR start query
    // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:21:1: query : selectClause ;
    public final void query() throws RecognitionException {
        try {
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:22:2: ( selectClause )
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:22:4: selectClause
            {
            pushFollow(FOLLOW_selectClause_in_query44);
            selectClause();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end query


    // $ANTLR start selectClause
    // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:26:1: selectClause : ^( Select expr ) ;
    public final void selectClause() throws RecognitionException {
        try {
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:27:2: ( ^( Select expr ) )
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:27:4: ^( Select expr )
            {
            match(input,Select,FOLLOW_Select_in_selectClause58); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_selectClause60);
            expr();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end selectClause


    // $ANTLR start expr
    // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:31:1: expr : QName ;
    public final void expr() throws RecognitionException {
        try {
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:31:5: ( QName )
            // D:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\XerialJ\\xerial-core\\src\\main\\java\\org\\xerial\\amoeba\\query\\AmoebaQueryTreeParser.g:31:7: QName
            {
            match(input,QName,FOLLOW_QName_in_expr73); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expr


 

    public static final BitSet FOLLOW_selectClause_in_query44 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Select_in_selectClause58 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_selectClause60 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QName_in_expr73 = new BitSet(new long[]{0x0000000000000002L});

}
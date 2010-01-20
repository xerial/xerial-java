// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 CSV.g 2010-01-20 16:29:42

//--------------------------------------
// XerialJ Project
//
// CSVParser.java
// Since: 2010/01/20
//
//--------------------------------------
package org.xerial.util.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CSVParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WhiteSpace", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Comma"
    };
    public static final int String=12;
    public static final int Letter=6;
    public static final int Comma=13;
    public static final int Digit=5;
    public static final int EscapeSequence=9;
    public static final int HexDigit=7;
    public static final int EOF=-1;
    public static final int StringChar_s=11;
    public static final int UnicodeChar=8;
    public static final int WhiteSpace=4;
    public static final int StringChar=10;

    // delegates
    // delegators


        public CSVParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CSVParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CSVParser.tokenNames; }
    public String getGrammarFileName() { return "CSV.g"; }



    // $ANTLR start "csvLine"
    // CSV.g:79:1: csvLine : csvElement ( Comma csvElement )* ;
    public final void csvLine() throws RecognitionException {
        try {
            // CSV.g:79:8: ( csvElement ( Comma csvElement )* )
            // CSV.g:79:10: csvElement ( Comma csvElement )*
            {
            pushFollow(FOLLOW_csvElement_in_csvLine273);
            csvElement();

            state._fsp--;

            // CSV.g:79:21: ( Comma csvElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Comma) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // CSV.g:79:22: Comma csvElement
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_csvLine276); 
            	    pushFollow(FOLLOW_csvElement_in_csvLine278);
            	    csvElement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "csvLine"


    // $ANTLR start "csvElement"
    // CSV.g:81:1: csvElement : String ;
    public final void csvElement() throws RecognitionException {
        try {
            // CSV.g:81:11: ( String )
            // CSV.g:81:13: String
            {
            match(input,String,FOLLOW_String_in_csvElement287); 

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
    // $ANTLR end "csvElement"

    // Delegated rules


 

    public static final BitSet FOLLOW_csvElement_in_csvLine273 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_Comma_in_csvLine276 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_csvElement_in_csvLine278 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_String_in_csvElement287 = new BitSet(new long[]{0x0000000000000002L});

}
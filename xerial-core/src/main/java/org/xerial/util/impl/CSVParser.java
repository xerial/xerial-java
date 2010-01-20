// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 CSV.g 2010-01-20 23:52:21

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "StringChar_s", "Comma", "String"
    };
    public static final int String=6;
    public static final int StringChar_s=4;
    public static final int Comma=5;
    public static final int EOF=-1;

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
    // CSV.g:69:1: csvLine : csvElement ( Comma csvElement )* ;
    public final void csvLine() throws RecognitionException {
        try {
            // CSV.g:69:8: ( csvElement ( Comma csvElement )* )
            // CSV.g:69:10: csvElement ( Comma csvElement )*
            {
            pushFollow(FOLLOW_csvElement_in_csvLine118);
            csvElement();

            state._fsp--;

            // CSV.g:69:21: ( Comma csvElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Comma) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // CSV.g:69:22: Comma csvElement
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_csvLine121); 
            	    pushFollow(FOLLOW_csvElement_in_csvLine123);
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
    // CSV.g:71:1: csvElement : String ;
    public final void csvElement() throws RecognitionException {
        try {
            // CSV.g:71:11: ( String )
            // CSV.g:71:13: String
            {
            match(input,String,FOLLOW_String_in_csvElement132); 

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


 

    public static final BitSet FOLLOW_csvElement_in_csvLine118 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Comma_in_csvLine121 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_csvElement_in_csvLine123 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_String_in_csvElement132 = new BitSet(new long[]{0x0000000000000002L});

}
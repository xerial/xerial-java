// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g 2009-01-30 21:13:12

//--------------------------------------
// XerialJ Project
//
// InLineJSONParser.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.silk.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InLineJSONParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WhiteSpace", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Colon", "Comma", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "'true'", "'false'", "'null'"
    };
    public static final int RBrace=20;
    public static final int LBracket=21;
    public static final int T__23=23;
    public static final int Digit=5;
    public static final int Frac=16;
    public static final int HexDigit=7;
    public static final int Exp=17;
    public static final int UnicodeChar=8;
    public static final int StringChar=10;
    public static final int String=12;
    public static final int Letter=6;
    public static final int Comma=14;
    public static final int EscapeSequence=9;
    public static final int EOF=-1;
    public static final int T__24=24;
    public static final int StringChar_s=11;
    public static final int Integer=15;
    public static final int LBrace=19;
    public static final int Double=18;
    public static final int RBracket=22;
    public static final int T__25=25;
    public static final int WhiteSpace=4;
    public static final int Colon=13;

    // delegates
    // delegators


        public InLineJSONParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InLineJSONParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InLineJSONParser.tokenNames; }
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g"; }



    // $ANTLR start "jsonObjectFragment"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:96:1: jsonObjectFragment : jsonElement ( Comma jsonElement )* ;
    public final void jsonObjectFragment() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:96:19: ( jsonElement ( Comma jsonElement )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:96:21: jsonElement ( Comma jsonElement )*
            {
            pushFollow(FOLLOW_jsonElement_in_jsonObjectFragment369);
            jsonElement();

            state._fsp--;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:96:33: ( Comma jsonElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Comma) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:96:34: Comma jsonElement
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_jsonObjectFragment372); 
            	    pushFollow(FOLLOW_jsonElement_in_jsonObjectFragment374);
            	    jsonElement();

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
    // $ANTLR end "jsonObjectFragment"


    // $ANTLR start "jsonArrayFragment"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:97:1: jsonArrayFragment : jsonValue ( Comma jsonValue )* ;
    public final void jsonArrayFragment() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:97:18: ( jsonValue ( Comma jsonValue )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:97:20: jsonValue ( Comma jsonValue )*
            {
            pushFollow(FOLLOW_jsonValue_in_jsonArrayFragment382);
            jsonValue();

            state._fsp--;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:97:30: ( Comma jsonValue )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:97:31: Comma jsonValue
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_jsonArrayFragment385); 
            	    pushFollow(FOLLOW_jsonValue_in_jsonArrayFragment387);
            	    jsonValue();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "jsonArrayFragment"


    // $ANTLR start "jsonObject"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:99:1: jsonObject : LBrace jsonElement ( ',' jsonElement )* RBrace ;
    public final void jsonObject() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:99:11: ( LBrace jsonElement ( ',' jsonElement )* RBrace )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:99:13: LBrace jsonElement ( ',' jsonElement )* RBrace
            {
            match(input,LBrace,FOLLOW_LBrace_in_jsonObject396); 
            pushFollow(FOLLOW_jsonElement_in_jsonObject398);
            jsonElement();

            state._fsp--;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:99:32: ( ',' jsonElement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comma) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:99:33: ',' jsonElement
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_jsonObject401); 
            	    pushFollow(FOLLOW_jsonElement_in_jsonObject403);
            	    jsonElement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,RBrace,FOLLOW_RBrace_in_jsonObject407); 

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
    // $ANTLR end "jsonObject"


    // $ANTLR start "jsonElement"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:100:1: jsonElement : String Colon jsonValue ;
    public final void jsonElement() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:100:12: ( String Colon jsonValue )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:100:14: String Colon jsonValue
            {
            match(input,String,FOLLOW_String_in_jsonElement413); 
            match(input,Colon,FOLLOW_Colon_in_jsonElement415); 
            pushFollow(FOLLOW_jsonValue_in_jsonElement417);
            jsonValue();

            state._fsp--;


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
    // $ANTLR end "jsonElement"


    // $ANTLR start "jsonArray"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:101:1: jsonArray : LBracket jsonValue ( ',' jsonValue )* RBracket ;
    public final void jsonArray() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:101:10: ( LBracket jsonValue ( ',' jsonValue )* RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:101:12: LBracket jsonValue ( ',' jsonValue )* RBracket
            {
            match(input,LBracket,FOLLOW_LBracket_in_jsonArray424); 
            pushFollow(FOLLOW_jsonValue_in_jsonArray426);
            jsonValue();

            state._fsp--;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:101:31: ( ',' jsonValue )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Comma) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:101:32: ',' jsonValue
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_jsonArray429); 
            	    pushFollow(FOLLOW_jsonValue_in_jsonArray431);
            	    jsonValue();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,RBracket,FOLLOW_RBracket_in_jsonArray435); 

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
    // $ANTLR end "jsonArray"


    // $ANTLR start "jsonValue"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:103:1: jsonValue : ( jsonObject | jsonArray | String | Integer | Double | 'true' | 'false' | 'null' );
    public final void jsonValue() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:104:2: ( jsonObject | jsonArray | String | Integer | Double | 'true' | 'false' | 'null' )
            int alt5=8;
            switch ( input.LA(1) ) {
            case LBrace:
                {
                alt5=1;
                }
                break;
            case LBracket:
                {
                alt5=2;
                }
                break;
            case String:
                {
                alt5=3;
                }
                break;
            case Integer:
                {
                alt5=4;
                }
                break;
            case Double:
                {
                alt5=5;
                }
                break;
            case 23:
                {
                alt5=6;
                }
                break;
            case 24:
                {
                alt5=7;
                }
                break;
            case 25:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:104:4: jsonObject
                    {
                    pushFollow(FOLLOW_jsonObject_in_jsonValue444);
                    jsonObject();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:105:4: jsonArray
                    {
                    pushFollow(FOLLOW_jsonArray_in_jsonValue449);
                    jsonArray();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:106:4: String
                    {
                    match(input,String,FOLLOW_String_in_jsonValue454); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:107:4: Integer
                    {
                    match(input,Integer,FOLLOW_Integer_in_jsonValue459); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:108:4: Double
                    {
                    match(input,Double,FOLLOW_Double_in_jsonValue464); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:109:4: 'true'
                    {
                    match(input,23,FOLLOW_23_in_jsonValue469); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:110:4: 'false'
                    {
                    match(input,24,FOLLOW_24_in_jsonValue474); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\InLineJSON.g:111:4: 'null'
                    {
                    match(input,25,FOLLOW_25_in_jsonValue479); 

                    }
                    break;

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
    // $ANTLR end "jsonValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_jsonElement_in_jsonObjectFragment369 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_Comma_in_jsonObjectFragment372 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_jsonElement_in_jsonObjectFragment374 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArrayFragment382 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_Comma_in_jsonArrayFragment385 = new BitSet(new long[]{0x0000000003AC9000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArrayFragment387 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_LBrace_in_jsonObject396 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_jsonElement_in_jsonObject398 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_Comma_in_jsonObject401 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_jsonElement_in_jsonObject403 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_RBrace_in_jsonObject407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_jsonElement413 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Colon_in_jsonElement415 = new BitSet(new long[]{0x0000000003AC9000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonElement417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_jsonArray424 = new BitSet(new long[]{0x0000000003AC9000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArray426 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_Comma_in_jsonArray429 = new BitSet(new long[]{0x0000000003AC9000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArray431 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_RBracket_in_jsonArray435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonObject_in_jsonValue444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonArray_in_jsonValue449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_jsonValue454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_jsonValue459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_jsonValue464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_jsonValue469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_jsonValue474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_jsonValue479 = new BitSet(new long[]{0x0000000000000002L});

}
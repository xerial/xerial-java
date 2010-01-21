// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g 2010-01-21 13:02:59

//--------------------------------------
// XerialJ Project
//
// CSVLexer.java
// Since: 2010/01/20
//
//--------------------------------------
package org.xerial.util.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CSVLexer extends Lexer {
    public static final int String=6;
    public static final int EOF=-1;
    public static final int Comma=5;
    public static final int StringChar_s=4;

      


    // delegates
    // delegators

    public CSVLexer() {;} 
    public CSVLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CSVLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g"; }

    // $ANTLR start "StringChar_s"
    public final void mStringChar_s() throws RecognitionException {
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:61:22: (~ ( '\"' ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:61:24: ~ ( '\"' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "StringChar_s"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token s=null;

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:63:3: ( '\"' s= StringChar_s '\"' | (~ ( '\"' | Comma ) )* )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\"') ) {
                alt2=1;
            }
            else {
                alt2=2;}
            switch (alt2) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:63:5: '\"' s= StringChar_s '\"'
                    {
                    match('\"'); 
                    int sStart54 = getCharIndex();
                    mStringChar_s(); 
                    s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart54, getCharIndex()-1);
                    match('\"'); 
                     setText((s!=null?s.getText():null)); 

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:64:5: (~ ( '\"' | Comma ) )*
                    {
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:64:5: (~ ( '\"' | Comma ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='+')||(LA1_0>='-' && LA1_0<='\uFFFF')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:64:6: ~ ( '\"' | Comma )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:67:6: ( ',' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:67:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    public void mTokens() throws RecognitionException {
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:1:8: ( String | Comma )
        int alt3=2;
        int LA3_0 = input.LA(1);

        if ( (LA3_0==',') ) {
            alt3=2;
        }
        else {
            alt3=1;}
        switch (alt3) {
            case 1 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:1:10: String
                {
                mString(); 

                }
                break;
            case 2 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\util\\impl\\CSV.g:1:17: Comma
                {
                mComma(); 

                }
                break;

        }

    }


 

}
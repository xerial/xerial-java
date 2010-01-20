// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 CSV.g 2010-01-20 16:29:43

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
    public static final int String=12;
    public static final int Letter=6;
    public static final int Comma=13;
    public static final int Digit=5;
    public static final int HexDigit=7;
    public static final int EscapeSequence=9;
    public static final int EOF=-1;
    public static final int StringChar_s=11;
    public static final int UnicodeChar=8;
    public static final int WhiteSpace=4;
    public static final int StringChar=10;

      


    // delegates
    // delegators

    public CSVLexer() {;} 
    public CSVLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CSVLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "CSV.g"; }

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CSV.g:60:11: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // CSV.g:60:13: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpace"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // CSV.g:62:15: ( '0' .. '9' )
            // CSV.g:62:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // CSV.g:63:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // CSV.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "Letter"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // CSV.g:64:18: ( Digit | Letter )
            // CSV.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "HexDigit"

    // $ANTLR start "UnicodeChar"
    public final void mUnicodeChar() throws RecognitionException {
        try {
            // CSV.g:65:21: (~ ( '\"' | '\\\\' ) )
            // CSV.g:65:23: ~ ( '\"' | '\\\\' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "UnicodeChar"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // CSV.g:67:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // CSV.g:67:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // CSV.g:67:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt1=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt1=1;
                }
                break;
            case '\\':
                {
                alt1=2;
                }
                break;
            case '/':
                {
                alt1=3;
                }
                break;
            case 'b':
                {
                alt1=4;
                }
                break;
            case 'f':
                {
                alt1=5;
                }
                break;
            case 'n':
                {
                alt1=6;
                }
                break;
            case 'r':
                {
                alt1=7;
                }
                break;
            case 't':
                {
                alt1=8;
                }
                break;
            case 'u':
                {
                alt1=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // CSV.g:67:11: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // CSV.g:67:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // CSV.g:67:25: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // CSV.g:67:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // CSV.g:67:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // CSV.g:67:43: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // CSV.g:67:49: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // CSV.g:67:55: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // CSV.g:67:61: 'u' HexDigit HexDigit HexDigit HexDigit
                    {
                    match('u'); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "StringChar"
    public final void mStringChar() throws RecognitionException {
        try {
            // CSV.g:70:21: ( UnicodeChar | EscapeSequence )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                alt2=1;
            }
            else if ( (LA2_0=='\\') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // CSV.g:70:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // CSV.g:70:38: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "StringChar"

    // $ANTLR start "StringChar_s"
    public final void mStringChar_s() throws RecognitionException {
        try {
            // CSV.g:71:22: ( ( StringChar )* )
            // CSV.g:71:24: ( StringChar )*
            {
            // CSV.g:71:24: ( StringChar )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // CSV.g:71:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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

            // CSV.g:73:3: ( '\"' s= StringChar_s '\"' | (~ ( '\"' | ',' ) )* )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else {
                alt5=2;}
            switch (alt5) {
                case 1 :
                    // CSV.g:73:5: '\"' s= StringChar_s '\"'
                    {
                    match('\"'); 
                    int sStart218 = getCharIndex();
                    mStringChar_s(); 
                    s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart218, getCharIndex()-1);
                    match('\"'); 
                     setText((s!=null?s.getText():null)); 

                    }
                    break;
                case 2 :
                    // CSV.g:74:5: (~ ( '\"' | ',' ) )*
                    {
                    // CSV.g:74:5: (~ ( '\"' | ',' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='+')||(LA4_0>='-' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // CSV.g:74:6: ~ ( '\"' | ',' )
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
                    	    break loop4;
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
            // CSV.g:77:6: ( ',' )
            // CSV.g:77:8: ','
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
        // CSV.g:1:8: ( WhiteSpace | String | Comma )
        int alt6=3;
        switch ( input.LA(1) ) {
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            int LA6_1 = input.LA(2);

            if ( ((LA6_1>='\u0000' && LA6_1<='!')||(LA6_1>='#' && LA6_1<='+')||(LA6_1>='-' && LA6_1<='\uFFFF')) ) {
                alt6=2;
            }
            else {
                alt6=1;}
            }
            break;
        case ',':
            {
            alt6=3;
            }
            break;
        default:
            alt6=2;}

        switch (alt6) {
            case 1 :
                // CSV.g:1:10: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;
            case 2 :
                // CSV.g:1:21: String
                {
                mString(); 

                }
                break;
            case 3 :
                // CSV.g:1:28: Comma
                {
                mComma(); 

                }
                break;

        }

    }


 

}
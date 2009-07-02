// $ANTLR 3.1.1 d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g 2009-07-01 18:57:06

/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// XerialJ
//
// SilkSchemaLexer.java
// Since: Jun 28, 2009 1:00:02 PM
//
//--------------------------------------

package org.xerial.silk.schema.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SilkSchemaLexer extends Lexer {
    public static final int RBrace=21;
    public static final int LBracket=22;
    public static final int Class=26;
    public static final int Digit=6;
    public static final int Frac=17;
    public static final int HexDigit=8;
    public static final int Exp=18;
    public static final int RParen=25;
    public static final int UnicodeChar=9;
    public static final int StringChar=11;
    public static final int LParen=24;
    public static final int String=13;
    public static final int Letter=7;
    public static final int Comma=15;
    public static final int Schema=4;
    public static final int EscapeSequence=10;
    public static final int EOF=-1;
    public static final int StringChar_s=12;
    public static final int Integer=16;
    public static final int Double=19;
    public static final int LBrace=20;
    public static final int RBracket=23;
    public static final int WhiteSpace=5;
    public static final int Colon=14;


      


    // delegates
    // delegators

    public SilkSchemaLexer() {;} 
    public SilkSchemaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkSchemaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g"; }

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:100:11: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:100:13: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:102:15: ( '0' .. '9' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:102:17: '0' .. '9'
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:103:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:104:18: ( Digit | Letter )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:105:21: (~ ( '\"' | '\\\\' ) )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:105:23: ~ ( '\"' | '\\\\' )
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:11: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:25: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:43: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:49: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:55: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:107:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:110:21: ( UnicodeChar | EscapeSequence )
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
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:110:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:110:38: EscapeSequence
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
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:111:22: ( ( StringChar )* )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:111:24: ( StringChar )*
            {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:111:24: ( StringChar )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:111:24: StringChar
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

            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:7: ( '\"' s= StringChar_s '\"' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart216 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart216, getCharIndex()-1);
            match('\"'); 
             setText((s!=null?s.getText():null)); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:116:6: ( ':' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:116:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:6: ( ',' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:8: ','
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

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:10: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:15: ( '0' | '1' .. '9' ( Digit )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='0') ) {
                alt6=1;
            }
            else if ( ((LA6_0>='1' && LA6_0<='9')) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:31: ( Digit )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:118:31: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Frac"
    public final void mFrac() throws RecognitionException {
        try {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:119:14: ( '.' ( Digit )+ )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:119:16: '.' ( Digit )+
            {
            match('.'); 
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:119:20: ( Digit )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:119:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Frac"

    // $ANTLR start "Exp"
    public final void mExp() throws RecognitionException {
        try {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:27: ( '+' | '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='+'||LA8_0=='-') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:40: ( Digit )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exp"

    // $ANTLR start "Double"
    public final void mDouble() throws RecognitionException {
        try {
            int _type = Double;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); 
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:17: ( Frac ( Exp )? | Exp )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='.') ) {
                alt11=1;
            }
            else if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:18: Frac ( Exp )?
                    {
                    mFrac(); 
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:23: ( Exp )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:23: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:121:30: Exp
                    {
                    mExp(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Double"

    // $ANTLR start "LBrace"
    public final void mLBrace() throws RecognitionException {
        try {
            int _type = LBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:123:7: ( '{' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:123:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBrace"

    // $ANTLR start "RBrace"
    public final void mRBrace() throws RecognitionException {
        try {
            int _type = RBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:124:7: ( '}' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:124:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBrace"

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:125:9: ( '[' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:125:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBracket"

    // $ANTLR start "RBracket"
    public final void mRBracket() throws RecognitionException {
        try {
            int _type = RBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:126:9: ( ']' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:126:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBracket"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:7: ( '(' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LParen"

    // $ANTLR start "RParen"
    public final void mRParen() throws RecognitionException {
        try {
            int _type = RParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:129:7: ( ')' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:129:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RParen"

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:131:6: ( 'class' )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:131:8: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Class"

    public void mTokens() throws RecognitionException {
        // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:8: ( WhiteSpace | String | Colon | Comma | Integer | Double | LBrace | RBrace | LBracket | RBracket | LParen | RParen | Class )
        int alt12=13;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:10: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;
            case 2 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:21: String
                {
                mString(); 

                }
                break;
            case 3 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:28: Colon
                {
                mColon(); 

                }
                break;
            case 4 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:34: Comma
                {
                mComma(); 

                }
                break;
            case 5 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:40: Integer
                {
                mInteger(); 

                }
                break;
            case 6 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:48: Double
                {
                mDouble(); 

                }
                break;
            case 7 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:55: LBrace
                {
                mLBrace(); 

                }
                break;
            case 8 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:62: RBrace
                {
                mRBrace(); 

                }
                break;
            case 9 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:69: LBracket
                {
                mLBracket(); 

                }
                break;
            case 10 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:78: RBracket
                {
                mRBracket(); 

                }
                break;
            case 11 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:87: LParen
                {
                mLParen(); 

                }
                break;
            case 12 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:94: RParen
                {
                mRParen(); 

                }
                break;
            case 13 :
                // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:101: Class
                {
                mClass(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\6\uffff\2\17\11\uffff\1\17";
    static final String DFA12_eofS =
        "\22\uffff";
    static final String DFA12_minS =
        "\1\11\4\uffff\1\60\2\56\11\uffff\1\56";
    static final String DFA12_maxS =
        "\1\175\4\uffff\1\71\2\145\11\uffff\1\145";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\5\1\6\1\uffff";
    static final String DFA12_specialS =
        "\22\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\1\1\uffff\2\1\22\uffff\1\1\1\uffff\1\2\5\uffff\1\14\1\15"+
            "\2\uffff\1\4\1\5\2\uffff\1\6\11\7\1\3\40\uffff\1\12\1\uffff"+
            "\1\13\5\uffff\1\16\27\uffff\1\10\1\uffff\1\11",
            "",
            "",
            "",
            "",
            "\1\6\11\7",
            "\1\20\26\uffff\1\20\37\uffff\1\20",
            "\1\20\1\uffff\12\21\13\uffff\1\20\37\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\uffff\12\21\13\uffff\1\20\37\uffff\1\20"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( WhiteSpace | String | Colon | Comma | Integer | Double | LBrace | RBrace | LBracket | RBracket | LParen | RParen | Class );";
        }
    }
 

}
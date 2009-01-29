// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-29 23:15:36

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
// SilkLexer.java
// Since: Jan 28, 2009 1:00:02 PM
//
//--------------------------------------

package org.xerial.silk.impl;
import org.xerial.silk.impl.SilkLexerState;
import org.xerial.silk.impl.SilkLexerState.State;
import org.xerial.silk.impl.SilkLexerState.Symbol;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SilkLexer extends Lexer {
    public static final int Key=15;
    public static final int PlainSafeKey=48;
    public static final int DataType=11;
    public static final int SilkNode=5;
    public static final int SilkLine=7;
    public static final int LBracket=41;
    public static final int NodeStart=30;
    public static final int Digit=20;
    public static final int HexDigit=22;
    public static final int PlainOneLine=53;
    public static final int Plus=40;
    public static final int Occurrence=10;
    public static final int Argument=13;
    public static final int FlowIndicator=46;
    public static final int Separation=54;
    public static final int Letter=21;
    public static final int PlainSafeIn=49;
    public static final int Comma=35;
    public static final int EscapeSequence=24;
    public static final int NonSpaceChar=27;
    public static final int DataLine=32;
    public static final int PlainFirst=45;
    public static final int WhiteSpace=26;
    public static final int PlainSafeOut=50;
    public static final int Question=43;
    public static final int LineComment=16;
    public static final int Colon=36;
    public static final int At=39;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=14;
    public static final int PlainChar=52;
    public static final int Star=38;
    public static final int Preamble=17;
    public static final int Seq=37;
    public static final int Indicator=44;
    public static final int RParen=34;
    public static final int UnicodeChar=23;
    public static final int Silk=4;
    public static final int StringChar=25;
    public static final int BlankLine=31;
    public static final int LineBreak=19;
    public static final int Name=8;
    public static final int Function=12;
    public static final int LParen=33;
    public static final int String=29;
    public static final int LineBreakChar=18;
    public static final int ScopeIndicator=47;
    public static final int EOF=-1;
    public static final int StringChar_s=28;
    public static final int Value=9;
    public static final int RBracket=42;
    public static final int PlainSafe=51;


    private SilkLexerState lexerContext = new SilkLexerState();

    private State currentState() { return lexerContext.getCurrentState(); } 
    private void transit(Symbol token) { lexerContext.transit(token); } 
    private void resetContext() { lexerContext.reset(); }



    // delegates
    // delegators

    public SilkLexer() {;} 
    public SilkLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:18: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:32: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LineComment"

    // $ANTLR start "Preamble"
    public final void mPreamble() throws RecognitionException {
        try {
            int _type = Preamble;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:15: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:29: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Preamble"

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:23: ( '\\n' | '\\r' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
    // $ANTLR end "LineBreakChar"

    // $ANTLR start "LineBreak"
    public final void mLineBreak() throws RecognitionException {
        try {
            int _type = LineBreak;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\n') ) {
                    alt5=1;
                }
                else {
                    alt5=2;}
            }
            else if ( (LA5_0=='\n') ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:24: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel=HIDDEN; resetContext(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LineBreak"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:18: ( Digit | Letter )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:23: ~ ( '\"' | '\\\\' | LineBreakChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt6=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt6=1;
                }
                break;
            case '\\':
                {
                alt6=2;
                }
                break;
            case '/':
                {
                alt6=3;
                }
                break;
            case 'b':
                {
                alt6=4;
                }
                break;
            case 'f':
                {
                alt6=5;
                }
                break;
            case 'n':
                {
                alt6=6;
                }
                break;
            case 'r':
                {
                alt6=7;
                }
                break;
            case 't':
                {
                alt6=8;
                }
                break;
            case 'u':
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:21: ( UnicodeChar | EscapeSequence )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='\\') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:38: EscapeSequence
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

    // $ANTLR start "NonSpaceChar"
    public final void mNonSpaceChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) | EscapeSequence )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\u0000' && LA8_0<='\b')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\u001F')||LA8_0=='!'||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='\\') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:69: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NonSpaceChar"

    // $ANTLR start "StringChar_s"
    public final void mStringChar_s() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:22: ( ( StringChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:24: ( StringChar )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:24: ( StringChar )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:7: ( '\"' s= StringChar_s '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart313 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart313, getCharIndex()-1);
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

    // $ANTLR start "NodeStart"
    public final void mNodeStart() throws RecognitionException {
        try {
            int _type = NodeStart;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:10: ({...}? ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:12: {...}? ( ' ' )* '-'
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "NodeStart", "getCharPositionInLine()==0");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:42: ( ' ' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:43: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match('-'); 
             transit(Symbol.NodeStart); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NodeStart"

    // $ANTLR start "BlankLine"
    public final void mBlankLine() throws RecognitionException {
        try {
            int _type = BlankLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:10: ({...}? ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:12: {...}? ( WhiteSpace )* LineBreak
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "BlankLine", "getCharPositionInLine()==0");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:42: ( WhiteSpace )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:42: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            mLineBreak(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BlankLine"

    // $ANTLR start "DataLine"
    public final void mDataLine() throws RecognitionException {
        try {
            int _type = DataLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:9: ({...}? => ( WhiteSpace )* ~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:11: {...}? => ( WhiteSpace )* ~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "DataLine", "getCharPositionInLine()==0");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:44: ( WhiteSpace )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:44: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:104: (~ ( '\\n' | '\\r' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:104: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            mLineBreak(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DataLine"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:9: '('
            {
            match('('); 
             transit(Symbol.EnterParen); 

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:9: ')'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:9: ','
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:8: ':'
            {
            match(':'); 
             transit(Symbol.Colon); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Seq"
    public final void mSeq() throws RecognitionException {
        try {
            int _type = Seq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:4: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:7: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Seq"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Star"

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:6: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "At"

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Plus"

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:11: '['
            {
            match('['); 
             transit(Symbol.EnterParen); 

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:11: ']'
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

    // $ANTLR start "Question"
    public final void mQuestion() throws RecognitionException {
        try {
            int _type = Question;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:11: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Question"

    // $ANTLR start "PlainFirst"
    public final void mPlainFirst() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | EscapeSequence | {...}? => ( ':' | '?' ) NonSpaceChar )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='?') ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>='\u0000' && LA14_1<='\b')||(LA14_1>='\u000B' && LA14_1<='\f')||(LA14_1>='\u000E' && LA14_1<='\u001F')||LA14_1=='!'||(LA14_1>='#' && LA14_1<='\uFFFF')) && (( currentState() == State.OUT ))) {
                    alt14=3;
                }
                else {
                    alt14=1;}
            }
            else if ( (LA14_0=='\\') ) {
                alt14=2;
            }
            else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||LA14_0=='$'||LA14_0=='&'||(LA14_0>='*' && LA14_0<='+')||(LA14_0>='.' && LA14_0<='9')||(LA14_0>=';' && LA14_0<='=')||(LA14_0>='A' && LA14_0<='Z')||(LA14_0>='^' && LA14_0<='z')||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {
                alt14=1;
            }
            else if ( (LA14_0==':') && (( currentState() == State.OUT ))) {
                alt14=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:4: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:4: {...}? => ( ':' | '?' ) NonSpaceChar
                    {
                    if ( !(( currentState() == State.OUT )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " currentState() == State.OUT ");
                    }
                    if ( input.LA(1)==':'||input.LA(1)=='?' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mNonSpaceChar(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PlainFirst"

    // $ANTLR start "Indicator"
    public final void mIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:19: ( '-' | ':' | '{' | '}' | '[' | ']' | '(' | ')' | ',' | '#' | '>' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<=')')||(input.LA(1)>=',' && input.LA(1)<='-')||input.LA(1)==':'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||input.LA(1)=='{'||input.LA(1)=='}' ) {
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
    // $ANTLR end "Indicator"

    // $ANTLR start "FlowIndicator"
    public final void mFlowIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:197:23: ( ',' | '[' | ']' | '{' | '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( input.LA(1)==','||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
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
    // $ANTLR end "FlowIndicator"

    // $ANTLR start "ScopeIndicator"
    public final void mScopeIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:24: ( '(' | ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='(' && input.LA(1)<=')') ) {
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
    // $ANTLR end "ScopeIndicator"

    // $ANTLR start "PlainSafeKey"
    public final void mPlainSafeKey() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | ':' | FlowIndicator ) | EscapeSequence )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='$' && LA15_0<='\'')||(LA15_0>='*' && LA15_0<='+')||(LA15_0>='-' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0=='\\') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | ':' | FlowIndicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:113: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PlainSafeKey"

    // $ANTLR start "PlainSafeIn"
    public final void mPlainSafeIn() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:21: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | FlowIndicator ) | EscapeSequence )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='$' && LA16_0<='\'')||(LA16_0>='*' && LA16_0<='+')||(LA16_0>='-' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                alt16=1;
            }
            else if ( (LA16_0=='\\') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:23: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | FlowIndicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:106: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PlainSafeIn"

    // $ANTLR start "PlainSafeOut"
    public final void mPlainSafeOut() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator ) | EscapeSequence )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||(LA17_0>='$' && LA17_0<='\'')||(LA17_0>='*' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                alt17=1;
            }
            else if ( (LA17_0=='\\') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:90: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PlainSafeOut"

    // $ANTLR start "PlainSafe"
    public final void mPlainSafe() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:4: {...}? => PlainSafeKey
                    {
                    if ( !(( currentState() == State.KEY )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " currentState() == State.KEY ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:4: {...}? => PlainSafeIn
                    {
                    if ( !(( currentState() == State.IN )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " currentState() == State.IN ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:4: {...}? => PlainSafeOut
                    {
                    if ( !(( currentState() == State.OUT )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " currentState() == State.OUT ");
                    }
                    mPlainSafeOut(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PlainSafe"

    // $ANTLR start "PlainChar"
    public final void mPlainChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:19: ( PlainSafe ( '#' )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:21: PlainSafe ( '#' )?
            {
            mPlainSafe(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:31: ( '#' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='#') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:31: '#'
                    {
                    match('#'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "PlainChar"

    // $ANTLR start "PlainOneLine"
    public final void mPlainOneLine() throws RecognitionException {
        try {
            int _type = PlainOneLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:2: ( PlainFirst ( ( WhiteSpace )* PlainChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:4: PlainFirst ( ( WhiteSpace )* PlainChar )*
            {
            mPlainFirst(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:15: ( ( WhiteSpace )* PlainChar )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0==' ') ) {
                    alt21=1;
                }
                else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||(LA21_0>='$' && LA21_0<='\'')||(LA21_0>='*' && LA21_0<='+')||(LA21_0>='-' && LA21_0<='9')||(LA21_0>=';' && LA21_0<='Z')||(LA21_0>='^' && LA21_0<='z')||LA21_0=='|'||(LA21_0>='~' && LA21_0<='\uFFFF')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {
                    alt21=1;
                }
                else if ( (LA21_0=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {
                    alt21=1;
                }
                else if ( (LA21_0==':') && ((( currentState() == State.OUT )||( currentState() == State.IN )))) {
                    alt21=1;
                }
                else if ( (LA21_0==','||LA21_0=='['||LA21_0==']'||LA21_0=='{'||LA21_0=='}') && (( currentState() == State.OUT ))) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:16: ( WhiteSpace )* PlainChar
            	    {
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:16: ( WhiteSpace )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0=='\t'||LA20_0==' ') ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:16: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);

            	    mPlainChar(); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             transit(Symbol.LeaveValue); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlainOneLine"

    // $ANTLR start "Separation"
    public final void mSeparation() throws RecognitionException {
        try {
            int _type = Separation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:11: ({...}? ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:13: {...}? ( WhiteSpace )+
            {
            if ( !(( currentState() != State.INIT )) ) {
                throw new FailedPredicateException(input, "Separation", " currentState() != State.INIT ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:47: ( WhiteSpace )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\t'||LA22_0==' ') ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:47: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Separation"

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpace"

    public void mTokens() throws RecognitionException {
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | String | NodeStart | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | PlainOneLine | Separation | WhiteSpace )
        int alt23=21;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:10: LineComment
                {
                mLineComment(); 

                }
                break;
            case 2 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:22: Preamble
                {
                mPreamble(); 

                }
                break;
            case 3 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:31: LineBreak
                {
                mLineBreak(); 

                }
                break;
            case 4 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:41: String
                {
                mString(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:48: NodeStart
                {
                mNodeStart(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:58: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:68: DataLine
                {
                mDataLine(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:77: LParen
                {
                mLParen(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:84: RParen
                {
                mRParen(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:91: Comma
                {
                mComma(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:97: Colon
                {
                mColon(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:103: Seq
                {
                mSeq(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:107: Star
                {
                mStar(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:112: At
                {
                mAt(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:115: Plus
                {
                mPlus(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:120: LBracket
                {
                mLBracket(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:129: RBracket
                {
                mRBracket(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:138: Question
                {
                mQuestion(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:147: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:160: Separation
                {
                mSeparation(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:171: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA18_eotS =
        "\24\uffff";
    static final String DFA18_eofS =
        "\24\uffff";
    static final String DFA18_minS =
        "\2\0\1\42\1\0\3\uffff\10\0\4\60\1\0";
    static final String DFA18_maxS =
        "\1\uffff\1\0\1\165\1\0\3\uffff\10\0\4\146\1\0";
    static final String DFA18_acceptS =
        "\4\uffff\1\3\1\1\1\2\15\uffff";
    static final String DFA18_specialS =
        "\1\14\1\7\1\20\1\6\3\uffff\1\3\1\11\1\4\1\10\1\17\1\5\1\2\1\12"+
        "\1\13\1\16\1\0\1\1\1\15}>";
    static final String[] DFA18_transitionS = {
            "\11\1\2\uffff\2\1\1\uffff\22\1\1\uffff\1\1\2\uffff\4\1\2\uffff"+
            "\2\1\1\4\15\1\1\3\40\1\1\4\1\2\1\4\35\1\1\4\1\1\1\4\uff82\1",
            "\1\uffff",
            "\1\7\14\uffff\1\11\54\uffff\1\10\5\uffff\1\12\3\uffff\1\13"+
            "\7\uffff\1\14\3\uffff\1\15\1\uffff\1\16\1\17",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\20\7\uffff\6\20\32\uffff\6\20",
            "\12\21\7\uffff\6\21\32\uffff\6\21",
            "\12\22\7\uffff\6\22\32\uffff\6\22",
            "\12\23\7\uffff\6\23\32\uffff\6\23",
            "\1\uffff"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "205:10: fragment PlainSafe : ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_17 = input.LA(1);

                         
                        int index18_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_17>='0' && LA18_17<='9')||(LA18_17>='A' && LA18_17<='F')||(LA18_17>='a' && LA18_17<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 18;}

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_18 = input.LA(1);

                         
                        int index18_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_18>='0' && LA18_18<='9')||(LA18_18>='A' && LA18_18<='F')||(LA18_18>='a' && LA18_18<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 19;}

                         
                        input.seek(index18_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_7 = input.LA(1);

                         
                        int index18_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_15>='0' && LA18_15<='9')||(LA18_15>='A' && LA18_15<='F')||(LA18_15>='a' && LA18_15<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 16;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_0 = input.LA(1);

                         
                        int index18_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='$' && LA18_0<='\'')||(LA18_0>='*' && LA18_0<='+')||(LA18_0>='-' && LA18_0<='9')||(LA18_0>=';' && LA18_0<='Z')||(LA18_0>='^' && LA18_0<='z')||LA18_0=='|'||(LA18_0>='~' && LA18_0<='\uFFFF')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 1;}

                        else if ( (LA18_0=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 2;}

                        else if ( (LA18_0==':') && ((( currentState() == State.OUT )||( currentState() == State.IN )))) {s = 3;}

                        else if ( (LA18_0==','||LA18_0=='['||LA18_0==']'||LA18_0=='{'||LA18_0=='}') && (( currentState() == State.OUT ))) {s = 4;}

                         
                        input.seek(index18_0);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_19 = input.LA(1);

                         
                        int index18_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_19);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_16 = input.LA(1);

                         
                        int index18_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_16>='0' && LA18_16<='9')||(LA18_16>='A' && LA18_16<='F')||(LA18_16>='a' && LA18_16<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 17;}

                         
                        input.seek(index18_16);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 5;}

                        else if ( (( currentState() == State.IN )) ) {s = 6;}

                        else if ( (( currentState() == State.OUT )) ) {s = 4;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_2 = input.LA(1);

                         
                        int index18_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_2=='\"') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 7;}

                        else if ( (LA18_2=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 8;}

                        else if ( (LA18_2=='/') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 9;}

                        else if ( (LA18_2=='b') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 10;}

                        else if ( (LA18_2=='f') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 11;}

                        else if ( (LA18_2=='n') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 12;}

                        else if ( (LA18_2=='r') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 13;}

                        else if ( (LA18_2=='t') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 14;}

                        else if ( (LA18_2=='u') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 15;}

                         
                        input.seek(index18_2);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\3\uffff\1\30\1\31\1\uffff\1\35\1\uffff\1\35\1\41\1\42\1\43\1\44"+
        "\1\47\1\50\1\56\1\57\1\60\1\61\1\64\1\67\2\uffff\1\101\4\uffff\1"+
        "\114\1\uffff\2\115\5\uffff\1\120\4\uffff\1\67\1\uffff\2\67\4\uffff"+
        "\1\150\2\uffff\2\150\1\uffff\10\67\21\uffff\1\120\1\uffff\12\120"+
        "\1\uffff\11\67\3\uffff\1\150\1\uffff\12\150\3\uffff\11\120\3\uffff"+
        "\11\150\20\uffff\1\67\2\uffff\1\120\1\67\1\uffff\1\150\1\120\1\150";
    static final String DFA23_eofS =
        "\u00a7\uffff";
    static final String DFA23_minS =
        "\1\0\2\uffff\1\12\3\0\1\uffff\16\0\1\uffff\11\0\5\uffff\2\0\2\uffff"+
        "\5\0\4\uffff\2\0\1\uffff\2\0\1\uffff\12\0\1\uffff\11\0\3\uffff\1"+
        "\0\1\uffff\27\0\1\uffff\76\0";
    static final String DFA23_maxS =
        "\1\uffff\2\uffff\1\12\1\0\2\uffff\1\uffff\16\uffff\1\uffff\3\0"+
        "\3\uffff\1\0\2\uffff\5\uffff\2\uffff\2\uffff\5\uffff\4\uffff\2\uffff"+
        "\1\uffff\2\uffff\1\uffff\11\uffff\1\0\1\uffff\11\uffff\3\uffff\1"+
        "\uffff\1\uffff\27\uffff\1\uffff\76\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\5\16\uffff\1\7\11\uffff\1\6\1\10\1\11"+
        "\1\12\1\13\2\uffff\1\14\1\15\5\uffff\1\16\1\17\1\20\1\21\2\uffff"+
        "\1\22\2\uffff\1\23\12\uffff\1\3\11\uffff\1\4\1\24\1\25\1\uffff\1"+
        "\23\27\uffff\1\23\76\uffff";
    static final String DFA23_specialS =
        "\1\31\4\uffff\1\70\1\13\1\uffff\1\4\1\57\1\21\1\126\1\155\1\120"+
        "\1\165\1\16\1\51\1\113\1\160\1\114\1\60\1\20\2\uffff\1\175\1\174"+
        "\1\u0089\1\72\1\106\1\43\1\u0082\1\144\5\uffff\1\12\1\u0088\2\uffff"+
        "\1\134\1\37\1\1\1\52\1\142\4\uffff\1\34\1\17\1\uffff\1\u0085\1\22"+
        "\1\uffff\1\26\1\173\1\170\1\44\1\62\1\71\1\151\1\u0086\1\75\1\176"+
        "\1\uffff\1\112\1\56\1\177\1\127\1\115\1\124\1\154\1\172\1\147\3"+
        "\uffff\1\135\1\uffff\1\40\1\2\1\53\1\143\1\140\1\123\1\122\1\141"+
        "\1\153\1\111\1\46\1\171\1\76\1\64\1\167\1\6\1\74\1\67\1\42\1\162"+
        "\1\102\1\36\1\u008c\1\uffff\1\25\1\61\1\7\1\125\1\145\1\117\1\u0087"+
        "\1\24\1\11\1\164\1\137\1\105\1\30\1\27\1\133\1\150\1\63\1\166\1"+
        "\5\1\73\1\66\1\41\1\161\1\101\1\35\1\u008b\1\132\1\104\1\131\1\3"+
        "\1\146\1\65\1\55\1\136\1\110\1\107\1\163\1\54\1\152\1\50\1\u0084"+
        "\1\103\1\47\1\15\1\100\1\121\1\33\1\0\1\14\1\32\1\157\1\10\1\45"+
        "\1\77\1\23\1\156\1\u0083\1\u0081\1\130\1\u008a\1\u0080\1\116}>";
    static final String[] DFA23_transitionS = {
            "\11\24\1\10\1\4\2\24\1\3\22\24\1\6\1\24\1\5\1\1\1\24\1\2\1"+
            "\24\1\26\1\11\1\12\1\16\1\20\1\13\1\7\14\24\1\14\3\24\1\15\1"+
            "\23\1\17\32\24\1\21\1\25\1\22\35\24\1\26\1\24\1\26\uff82\24",
            "",
            "",
            "\1\27",
            "\1\uffff",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\11\26\1\37\1\40\2\26\1\40\22\26\1\36\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\7\uffd2\26",
            "",
            "\11\26\1\37\1\40\2\26\1\40\22\26\1\37\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\uffff\uffd2\26",
            "\0\26",
            "\0\26",
            "\0\26",
            "\11\45\2\26\2\45\1\26\22\45\1\26\1\45\1\26\71\45\1\46\uffa3"+
            "\45",
            "\0\26",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\0\26",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\0\26",
            "\0\26",
            "\11\62\1\51\1\26\2\62\1\26\22\62\1\51\1\62\1\26\1\45\4\62"+
            "\2\45\2\62\1\66\15\62\1\65\40\62\1\66\1\63\1\66\35\62\1\66\1"+
            "\62\1\66\uff82\62",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\42\26\1\70\14\26\1\72\54\26\1\71\5\26\1\73\3\26\1\74\7\26"+
            "\1\75\3\26\1\76\1\26\1\77\1\100\uff8a\26",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\42\26\1\103\14\26\1\105\54\26\1\104\5\26\1\106\3\26\1\107"+
            "\7\26\1\110\3\26\1\111\1\26\1\112\1\113\uff8a\26",
            "\0\26",
            "\1\uffff",
            "\11\26\1\37\1\40\2\26\1\40\22\26\1\36\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\7\uffd2\26",
            "\11\26\1\37\1\40\2\26\1\40\22\26\1\37\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\uffff\uffd2\26",
            "",
            "",
            "",
            "",
            "",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\42\26\1\125\14\26\1\127\54\26\1\126\5\26\1\130\3\26\1\131"+
            "\7\26\1\132\3\26\1\133\1\26\1\134\1\135\uff8a\26",
            "",
            "",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\42\26\1\137\14\26\1\141\54\26\1\140\5\26\1\142\3\26\1\143"+
            "\7\26\1\144\3\26\1\145\1\26\1\146\1\147\uff8a\26",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "",
            "",
            "",
            "",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\42\26\1\156\14\26\1\160\54\26\1\157\5\26\1\161\3\26\1\162"+
            "\7\26\1\163\3\26\1\164\1\26\1\165\1\166\uff8a\26",
            "",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\60\26\12\167\7\26\6\167\32\26\6\167\uff99\26",
            "\1\uffff",
            "",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\60\26\12\170\7\26\6\170\32\26\6\170\uff99\26",
            "",
            "",
            "",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\42\26\1\172\14\26\1\174\54\26\1\173\5\26\1\175\3\26\1\176"+
            "\7\26\1\177\3\26\1\u0080\1\26\1\u0081\1\u0082\uff8a\26",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\60\26\12\u0083\7\26\6\u0083\32\26\6\u0083\uff99\26",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\60\26\12\u0084\7\26\6\u0084\32\26\6\u0084\uff99\26",
            "",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\2\26\4\152"+
            "\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155\35\152"+
            "\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\42\26\1\u0086\14\26\1\u0088\54\26\1\u0087\5\26\1\u0089\3"+
            "\26\1\u008a\7\26\1\u008b\3\26\1\u008c\1\26\1\u008d\1\u008e\uff8a"+
            "\26",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\60\26\12\u008f\7\26\6\u008f\32\26\6\u008f\uff99\26",
            "\60\26\12\u0090\7\26\6\u0090\32\26\6\u0090\uff99\26",
            "\60\26\12\u0091\7\26\6\u0091\32\26\6\u0091\uff99\26",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\60\26\12\u0092\7\26\6\u0092\32\26\6\u0092\uff99\26",
            "\60\26\12\u0093\7\26\6\u0093\32\26\6\u0093\uff99\26",
            "\60\26\12\u0094\7\26\6\u0094\32\26\6\u0094\uff99\26",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\2\26\4\152"+
            "\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155\35\152"+
            "\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\60\26\12\u0095\7\26\6\u0095\32\26\6\u0095\uff99\26",
            "\60\26\12\u0096\7\26\6\u0096\32\26\6\u0096\uff99\26",
            "\60\26\12\u0097\7\26\6\u0097\32\26\6\u0097\uff99\26",
            "\60\26\12\u0098\7\26\6\u0098\32\26\6\u0098\uff99\26",
            "\60\26\12\u0099\7\26\6\u0099\32\26\6\u0099\uff99\26",
            "\60\26\12\u009a\7\26\6\u009a\32\26\6\u009a\uff99\26",
            "\60\26\12\u009b\7\26\6\u009b\32\26\6\u009b\uff99\26",
            "\60\26\12\u009c\7\26\6\u009c\32\26\6\u009c\uff99\26",
            "\60\26\12\u009d\7\26\6\u009d\32\26\6\u009d\uff99\26",
            "\60\26\12\u009e\7\26\6\u009e\32\26\6\u009e\uff99\26",
            "\60\26\12\u009f\7\26\6\u009f\32\26\6\u009f\uff99\26",
            "\60\26\12\u00a0\7\26\6\u00a0\32\26\6\u00a0\uff99\26",
            "\60\26\12\u00a1\7\26\6\u00a1\32\26\6\u00a1\uff99\26",
            "\60\26\12\u00a2\7\26\6\u00a2\32\26\6\u00a2\uff99\26",
            "\60\26\12\u00a3\7\26\6\u00a3\32\26\6\u00a3\uff99\26",
            "\60\26\12\u00a4\7\26\6\u00a4\32\26\6\u00a4\uff99\26",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\2\26\4\52\2\26"+
            "\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1\52\1"+
            "\55\uff82\52",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\60\26\12\u00a5\7\26\6\u00a5\32\26\6\u00a5\uff99\26",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\2\26\4\121"+
            "\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124\35\121"+
            "\1\124\1\121\1\124\uff82\121",
            "\11\52\1\51\1\26\2\52\1\26\22\52\1\51\1\52\1\26\1\136\4\52"+
            "\2\26\2\52\1\55\15\52\1\54\40\52\1\55\1\53\1\55\35\52\1\55\1"+
            "\52\1\55\uff82\52",
            "\60\26\12\u00a6\7\26\6\u00a6\32\26\6\u00a6\uff99\26",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\136"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152",
            "\11\121\1\117\1\26\2\121\1\26\22\121\1\117\1\121\1\26\1\171"+
            "\4\121\2\26\2\121\1\124\15\121\1\123\40\121\1\124\1\122\1\124"+
            "\35\121\1\124\1\121\1\124\uff82\121",
            "\11\152\1\151\1\26\2\152\1\26\22\152\1\151\1\152\1\26\1\u0085"+
            "\4\152\2\26\2\152\1\155\15\152\1\154\40\152\1\155\1\153\1\155"+
            "\35\152\1\155\1\152\1\155\uff82\152"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | String | NodeStart | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | PlainOneLine | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_152 = input.LA(1);

                         
                        int index23_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_152>='\u0000' && LA23_152<='/')||(LA23_152>=':' && LA23_152<='@')||(LA23_152>='G' && LA23_152<='`')||(LA23_152>='g' && LA23_152<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_152>='0' && LA23_152<='9')||(LA23_152>='A' && LA23_152<='F')||(LA23_152>='a' && LA23_152<='f')) ) {s = 159;}

                         
                        input.seek(index23_152);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_43 = input.LA(1);

                         
                        int index23_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_43>='\u0000' && LA23_43<='!')||(LA23_43>='#' && LA23_43<='.')||(LA23_43>='0' && LA23_43<='[')||(LA23_43>=']' && LA23_43<='a')||(LA23_43>='c' && LA23_43<='e')||(LA23_43>='g' && LA23_43<='m')||(LA23_43>='o' && LA23_43<='q')||LA23_43=='s'||(LA23_43>='v' && LA23_43<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_43=='\"') ) {s = 95;}

                        else if ( (LA23_43=='\\') ) {s = 96;}

                        else if ( (LA23_43=='/') ) {s = 97;}

                        else if ( (LA23_43=='b') ) {s = 98;}

                        else if ( (LA23_43=='f') ) {s = 99;}

                        else if ( (LA23_43=='n') ) {s = 100;}

                        else if ( (LA23_43=='r') ) {s = 101;}

                        else if ( (LA23_43=='t') ) {s = 102;}

                        else if ( (LA23_43=='u') ) {s = 103;}

                         
                        input.seek(index23_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_82 = input.LA(1);

                         
                        int index23_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_82>='\u0000' && LA23_82<='!')||(LA23_82>='#' && LA23_82<='.')||(LA23_82>='0' && LA23_82<='[')||(LA23_82>=']' && LA23_82<='a')||(LA23_82>='c' && LA23_82<='e')||(LA23_82>='g' && LA23_82<='m')||(LA23_82>='o' && LA23_82<='q')||LA23_82=='s'||(LA23_82>='v' && LA23_82<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_82=='\"') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 122;}

                        else if ( (LA23_82=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 123;}

                        else if ( (LA23_82=='/') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 124;}

                        else if ( (LA23_82=='b') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 125;}

                        else if ( (LA23_82=='f') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 126;}

                        else if ( (LA23_82=='n') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 127;}

                        else if ( (LA23_82=='r') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 128;}

                        else if ( (LA23_82=='t') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 129;}

                        else if ( (LA23_82=='u') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 130;}

                         
                        input.seek(index23_82);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_134 = input.LA(1);

                         
                        int index23_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_134=='\n'||LA23_134=='\r'||LA23_134=='\"'||(LA23_134>='(' && LA23_134<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_134=='#') ) {s = 133;}

                        else if ( (LA23_134=='\t'||LA23_134==' ') ) {s = 105;}

                        else if ( ((LA23_134>='\u0000' && LA23_134<='\b')||(LA23_134>='\u000B' && LA23_134<='\f')||(LA23_134>='\u000E' && LA23_134<='\u001F')||LA23_134=='!'||(LA23_134>='$' && LA23_134<='\'')||(LA23_134>='*' && LA23_134<='+')||(LA23_134>='-' && LA23_134<='9')||(LA23_134>=';' && LA23_134<='Z')||(LA23_134>='^' && LA23_134<='z')||LA23_134=='|'||(LA23_134>='~' && LA23_134<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_134=='\\') ) {s = 107;}

                        else if ( (LA23_134==':') ) {s = 108;}

                        else if ( (LA23_134==','||LA23_134=='['||LA23_134==']'||LA23_134=='{'||LA23_134=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_134);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_8=='\t'||LA23_8==' ') ) {s = 31;}

                        else if ( ((LA23_8>='\u0000' && LA23_8<='\b')||(LA23_8>='\u000B' && LA23_8<='\f')||(LA23_8>='\u000E' && LA23_8<='\u001F')||(LA23_8>='!' && LA23_8<='\"')||LA23_8=='$'||(LA23_8>='&' && LA23_8<=',')||(LA23_8>='.' && LA23_8<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_8=='\n'||LA23_8=='\r') ) {s = 32;}

                        else s = 29;

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_123 = input.LA(1);

                         
                        int index23_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_123=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_123=='\t'||LA23_123==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_123>='\u0000' && LA23_123<='\b')||(LA23_123>='\u000B' && LA23_123<='\f')||(LA23_123>='\u000E' && LA23_123<='\u001F')||LA23_123=='!'||(LA23_123>='$' && LA23_123<='\'')||(LA23_123>='*' && LA23_123<='+')||(LA23_123>='-' && LA23_123<='9')||(LA23_123>=';' && LA23_123<='Z')||(LA23_123>='^' && LA23_123<='z')||LA23_123=='|'||(LA23_123>='~' && LA23_123<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_123=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_123==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_123==','||LA23_123=='['||LA23_123==']'||LA23_123=='{'||LA23_123=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else if ( (LA23_123=='\n'||LA23_123=='\r'||LA23_123=='\"'||(LA23_123>='(' && LA23_123<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 80;

                         
                        input.seek(index23_123);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_96 = input.LA(1);

                         
                        int index23_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_96=='#') ) {s = 94;}

                        else if ( (LA23_96=='\t'||LA23_96==' ') ) {s = 41;}

                        else if ( ((LA23_96>='\u0000' && LA23_96<='\b')||(LA23_96>='\u000B' && LA23_96<='\f')||(LA23_96>='\u000E' && LA23_96<='\u001F')||LA23_96=='!'||(LA23_96>='$' && LA23_96<='\'')||(LA23_96>='*' && LA23_96<='+')||(LA23_96>='-' && LA23_96<='9')||(LA23_96>=';' && LA23_96<='Z')||(LA23_96>='^' && LA23_96<='z')||LA23_96=='|'||(LA23_96>='~' && LA23_96<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_96=='\\') ) {s = 43;}

                        else if ( (LA23_96==':') ) {s = 44;}

                        else if ( (LA23_96==','||LA23_96=='['||LA23_96==']'||LA23_96=='{'||LA23_96=='}') ) {s = 45;}

                        else if ( (LA23_96=='\n'||LA23_96=='\r'||LA23_96=='\"'||(LA23_96>='(' && LA23_96<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index23_96);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_107 = input.LA(1);

                         
                        int index23_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_107>='\u0000' && LA23_107<='!')||(LA23_107>='#' && LA23_107<='.')||(LA23_107>='0' && LA23_107<='[')||(LA23_107>=']' && LA23_107<='a')||(LA23_107>='c' && LA23_107<='e')||(LA23_107>='g' && LA23_107<='m')||(LA23_107>='o' && LA23_107<='q')||LA23_107=='s'||(LA23_107>='v' && LA23_107<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_107=='\"') ) {s = 134;}

                        else if ( (LA23_107=='\\') ) {s = 135;}

                        else if ( (LA23_107=='/') ) {s = 136;}

                        else if ( (LA23_107=='b') ) {s = 137;}

                        else if ( (LA23_107=='f') ) {s = 138;}

                        else if ( (LA23_107=='n') ) {s = 139;}

                        else if ( (LA23_107=='r') ) {s = 140;}

                        else if ( (LA23_107=='t') ) {s = 141;}

                        else if ( (LA23_107=='u') ) {s = 142;}

                         
                        input.seek(index23_107);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_156 = input.LA(1);

                         
                        int index23_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_156>='\u0000' && LA23_156<='/')||(LA23_156>=':' && LA23_156<='@')||(LA23_156>='G' && LA23_156<='`')||(LA23_156>='g' && LA23_156<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_156>='0' && LA23_156<='9')||(LA23_156>='A' && LA23_156<='F')||(LA23_156>='a' && LA23_156<='f')) ) {s = 163;}

                         
                        input.seek(index23_156);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_113 = input.LA(1);

                         
                        int index23_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_113=='#') ) {s = 94;}

                        else if ( (LA23_113=='\t'||LA23_113==' ') ) {s = 105;}

                        else if ( ((LA23_113>='\u0000' && LA23_113<='\b')||(LA23_113>='\u000B' && LA23_113<='\f')||(LA23_113>='\u000E' && LA23_113<='\u001F')||LA23_113=='!'||(LA23_113>='$' && LA23_113<='\'')||(LA23_113>='*' && LA23_113<='+')||(LA23_113>='-' && LA23_113<='9')||(LA23_113>=';' && LA23_113<='Z')||(LA23_113>='^' && LA23_113<='z')||LA23_113=='|'||(LA23_113>='~' && LA23_113<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_113=='\\') ) {s = 107;}

                        else if ( (LA23_113==':') ) {s = 108;}

                        else if ( (LA23_113==','||LA23_113=='['||LA23_113==']'||LA23_113=='{'||LA23_113=='}') ) {s = 109;}

                        else if ( (LA23_113=='\n'||LA23_113=='\r'||LA23_113=='\"'||(LA23_113>='(' && LA23_113<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_113);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_37 = input.LA(1);

                         
                        int index23_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_37=='\n'||LA23_37=='\r'||(LA23_37>='\"' && LA23_37<='#')||(LA23_37>='(' && LA23_37<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_37=='\t'||LA23_37==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_37>='\u0000' && LA23_37<='\b')||(LA23_37>='\u000B' && LA23_37<='\f')||(LA23_37>='\u000E' && LA23_37<='\u001F')||LA23_37=='!'||(LA23_37>='$' && LA23_37<='\'')||(LA23_37>='*' && LA23_37<='+')||(LA23_37>='-' && LA23_37<='9')||(LA23_37>=';' && LA23_37<='Z')||(LA23_37>='^' && LA23_37<='z')||LA23_37=='|'||(LA23_37>='~' && LA23_37<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_37=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_37==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_37==','||LA23_37=='['||LA23_37==']'||LA23_37=='{'||LA23_37=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_37);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_6==' ') ) {s = 30;}

                        else if ( (LA23_6=='-') ) {s = 7;}

                        else if ( (LA23_6=='\t') ) {s = 31;}

                        else if ( ((LA23_6>='\u0000' && LA23_6<='\b')||(LA23_6>='\u000B' && LA23_6<='\f')||(LA23_6>='\u000E' && LA23_6<='\u001F')||(LA23_6>='!' && LA23_6<='\"')||LA23_6=='$'||(LA23_6>='&' && LA23_6<=',')||(LA23_6>='.' && LA23_6<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_6=='\n'||LA23_6=='\r') ) {s = 32;}

                        else s = 29;

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_153 = input.LA(1);

                         
                        int index23_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_153>='\u0000' && LA23_153<='/')||(LA23_153>=':' && LA23_153<='@')||(LA23_153>='G' && LA23_153<='`')||(LA23_153>='g' && LA23_153<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_153>='0' && LA23_153<='9')||(LA23_153>='A' && LA23_153<='F')||(LA23_153>='a' && LA23_153<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 160;}

                         
                        input.seek(index23_153);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_148 = input.LA(1);

                         
                        int index23_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_148>='\u0000' && LA23_148<='/')||(LA23_148>=':' && LA23_148<='@')||(LA23_148>='G' && LA23_148<='`')||(LA23_148>='g' && LA23_148<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_148>='0' && LA23_148<='9')||(LA23_148>='A' && LA23_148<='F')||(LA23_148>='a' && LA23_148<='f')) ) {s = 155;}

                         
                        input.seek(index23_148);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_15 = input.LA(1);

                         
                        int index23_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_15>='\u0000' && LA23_15<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 46;

                         
                        input.seek(index23_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_51 = input.LA(1);

                         
                        int index23_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_51>='\u0000' && LA23_51<='!')||(LA23_51>='#' && LA23_51<='.')||(LA23_51>='0' && LA23_51<='[')||(LA23_51>=']' && LA23_51<='a')||(LA23_51>='c' && LA23_51<='e')||(LA23_51>='g' && LA23_51<='m')||(LA23_51>='o' && LA23_51<='q')||LA23_51=='s'||(LA23_51>='v' && LA23_51<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_51=='\"') ) {s = 110;}

                        else if ( (LA23_51=='\\') ) {s = 111;}

                        else if ( (LA23_51=='/') ) {s = 112;}

                        else if ( (LA23_51=='b') ) {s = 113;}

                        else if ( (LA23_51=='f') ) {s = 114;}

                        else if ( (LA23_51=='n') ) {s = 115;}

                        else if ( (LA23_51=='r') ) {s = 116;}

                        else if ( (LA23_51=='t') ) {s = 117;}

                        else if ( (LA23_51=='u') ) {s = 118;}

                         
                        input.seek(index23_51);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_21 = input.LA(1);

                         
                        int index23_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_21=='\"') ) {s = 56;}

                        else if ( (LA23_21=='\\') ) {s = 57;}

                        else if ( (LA23_21=='/') ) {s = 58;}

                        else if ( (LA23_21=='b') ) {s = 59;}

                        else if ( (LA23_21=='f') ) {s = 60;}

                        else if ( (LA23_21=='n') ) {s = 61;}

                        else if ( (LA23_21=='r') ) {s = 62;}

                        else if ( (LA23_21=='t') ) {s = 63;}

                        else if ( (LA23_21=='u') ) {s = 64;}

                        else if ( ((LA23_21>='\u0000' && LA23_21<='!')||(LA23_21>='#' && LA23_21<='.')||(LA23_21>='0' && LA23_21<='[')||(LA23_21>=']' && LA23_21<='a')||(LA23_21>='c' && LA23_21<='e')||(LA23_21>='g' && LA23_21<='m')||(LA23_21>='o' && LA23_21<='q')||LA23_21=='s'||(LA23_21>='v' && LA23_21<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_21);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA23_10 = input.LA(1);

                         
                        int index23_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_10>='\u0000' && LA23_10<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 34;

                         
                        input.seek(index23_10);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA23_54 = input.LA(1);

                         
                        int index23_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_54=='\n'||LA23_54=='\r'||LA23_54=='\"'||(LA23_54>='(' && LA23_54<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_54=='\t'||LA23_54==' ') ) {s = 105;}

                        else if ( ((LA23_54>='\u0000' && LA23_54<='\b')||(LA23_54>='\u000B' && LA23_54<='\f')||(LA23_54>='\u000E' && LA23_54<='\u001F')||LA23_54=='!'||(LA23_54>='$' && LA23_54<='\'')||(LA23_54>='*' && LA23_54<='+')||(LA23_54>='-' && LA23_54<='9')||(LA23_54>=';' && LA23_54<='Z')||(LA23_54>='^' && LA23_54<='z')||LA23_54=='|'||(LA23_54>='~' && LA23_54<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_54=='\\') ) {s = 107;}

                        else if ( (LA23_54==':') ) {s = 108;}

                        else if ( (LA23_54==','||LA23_54=='['||LA23_54==']'||LA23_54=='{'||LA23_54=='}') ) {s = 109;}

                        else if ( (LA23_54=='#') ) {s = 94;}

                        else s = 104;

                         
                        input.seek(index23_54);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA23_159 = input.LA(1);

                         
                        int index23_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_159=='\n'||LA23_159=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_159=='\"') ) {s = 28;}

                        else if ( ((LA23_159>='\u0000' && LA23_159<='\t')||(LA23_159>='\u000B' && LA23_159<='\f')||(LA23_159>='\u000E' && LA23_159<='!')||(LA23_159>='#' && LA23_159<='[')||(LA23_159>=']' && LA23_159<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_159=='\\') ) {s = 27;}

                         
                        input.seek(index23_159);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA23_112 = input.LA(1);

                         
                        int index23_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_112=='\n'||LA23_112=='\r'||LA23_112=='\"'||(LA23_112>='(' && LA23_112<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_112=='#') ) {s = 94;}

                        else if ( (LA23_112=='\t'||LA23_112==' ') ) {s = 105;}

                        else if ( ((LA23_112>='\u0000' && LA23_112<='\b')||(LA23_112>='\u000B' && LA23_112<='\f')||(LA23_112>='\u000E' && LA23_112<='\u001F')||LA23_112=='!'||(LA23_112>='$' && LA23_112<='\'')||(LA23_112>='*' && LA23_112<='+')||(LA23_112>='-' && LA23_112<='9')||(LA23_112>=';' && LA23_112<='Z')||(LA23_112>='^' && LA23_112<='z')||LA23_112=='|'||(LA23_112>='~' && LA23_112<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_112=='\\') ) {s = 107;}

                        else if ( (LA23_112==':') ) {s = 108;}

                        else if ( (LA23_112==','||LA23_112=='['||LA23_112==']'||LA23_112=='{'||LA23_112=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_112);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA23_105 = input.LA(1);

                         
                        int index23_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_105=='\n'||LA23_105=='\r'||(LA23_105>='\"' && LA23_105<='#')||(LA23_105>='(' && LA23_105<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_105>='\u0000' && LA23_105<='\b')||(LA23_105>='\u000B' && LA23_105<='\f')||(LA23_105>='\u000E' && LA23_105<='\u001F')||LA23_105=='!'||(LA23_105>='$' && LA23_105<='\'')||(LA23_105>='*' && LA23_105<='+')||(LA23_105>='-' && LA23_105<='9')||(LA23_105>=';' && LA23_105<='Z')||(LA23_105>='^' && LA23_105<='z')||LA23_105=='|'||(LA23_105>='~' && LA23_105<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_105=='\\') ) {s = 107;}

                        else if ( (LA23_105==':') ) {s = 108;}

                        else if ( (LA23_105==','||LA23_105=='['||LA23_105==']'||LA23_105=='{'||LA23_105=='}') ) {s = 109;}

                        else if ( (LA23_105=='\t'||LA23_105==' ') ) {s = 105;}

                         
                        input.seek(index23_105);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA23_56 = input.LA(1);

                         
                        int index23_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_56=='\n'||LA23_56=='\r'||(LA23_56>='\"' && LA23_56<='#')||(LA23_56>='(' && LA23_56<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_56=='\t'||LA23_56==' ') ) {s = 41;}

                        else if ( ((LA23_56>='\u0000' && LA23_56<='\b')||(LA23_56>='\u000B' && LA23_56<='\f')||(LA23_56>='\u000E' && LA23_56<='\u001F')||LA23_56=='!'||(LA23_56>='$' && LA23_56<='\'')||(LA23_56>='*' && LA23_56<='+')||(LA23_56>='-' && LA23_56<='9')||(LA23_56>=';' && LA23_56<='Z')||(LA23_56>='^' && LA23_56<='z')||LA23_56=='|'||(LA23_56>='~' && LA23_56<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_56=='\\') ) {s = 43;}

                        else if ( (LA23_56==':') ) {s = 44;}

                        else if ( (LA23_56==','||LA23_56=='['||LA23_56==']'||LA23_56=='{'||LA23_56=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_56);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA23_118 = input.LA(1);

                         
                        int index23_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_118>='\u0000' && LA23_118<='/')||(LA23_118>=':' && LA23_118<='@')||(LA23_118>='G' && LA23_118<='`')||(LA23_118>='g' && LA23_118<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_118>='0' && LA23_118<='9')||(LA23_118>='A' && LA23_118<='F')||(LA23_118>='a' && LA23_118<='f')) ) {s = 143;}

                         
                        input.seek(index23_118);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA23_117 = input.LA(1);

                         
                        int index23_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_117=='\n'||LA23_117=='\r'||LA23_117=='\"'||(LA23_117>='(' && LA23_117<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_117=='#') ) {s = 94;}

                        else if ( (LA23_117=='\t'||LA23_117==' ') ) {s = 105;}

                        else if ( ((LA23_117>='\u0000' && LA23_117<='\b')||(LA23_117>='\u000B' && LA23_117<='\f')||(LA23_117>='\u000E' && LA23_117<='\u001F')||LA23_117=='!'||(LA23_117>='$' && LA23_117<='\'')||(LA23_117>='*' && LA23_117<='+')||(LA23_117>='-' && LA23_117<='9')||(LA23_117>=';' && LA23_117<='Z')||(LA23_117>='^' && LA23_117<='z')||LA23_117=='|'||(LA23_117>='~' && LA23_117<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_117=='\\') ) {s = 107;}

                        else if ( (LA23_117==':') ) {s = 108;}

                        else if ( (LA23_117==','||LA23_117=='['||LA23_117==']'||LA23_117=='{'||LA23_117=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_117);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0=='#') ) {s = 1;}

                        else if ( (LA23_0=='%') ) {s = 2;}

                        else if ( (LA23_0=='\r') ) {s = 3;}

                        else if ( (LA23_0=='\n') ) {s = 4;}

                        else if ( (LA23_0=='\"') ) {s = 5;}

                        else if ( (LA23_0==' ') ) {s = 6;}

                        else if ( (LA23_0=='-') ) {s = 7;}

                        else if ( (LA23_0=='\t') ) {s = 8;}

                        else if ( (LA23_0=='(') ) {s = 9;}

                        else if ( (LA23_0==')') ) {s = 10;}

                        else if ( (LA23_0==',') ) {s = 11;}

                        else if ( (LA23_0==':') ) {s = 12;}

                        else if ( (LA23_0=='>') ) {s = 13;}

                        else if ( (LA23_0=='*') ) {s = 14;}

                        else if ( (LA23_0=='@') ) {s = 15;}

                        else if ( (LA23_0=='+') ) {s = 16;}

                        else if ( (LA23_0=='[') ) {s = 17;}

                        else if ( (LA23_0==']') ) {s = 18;}

                        else if ( (LA23_0=='?') ) {s = 19;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||LA23_0=='&'||(LA23_0>='.' && LA23_0<='9')||(LA23_0>=';' && LA23_0<='=')||(LA23_0>='A' && LA23_0<='Z')||(LA23_0>='^' && LA23_0<='z')||LA23_0=='|'||(LA23_0>='~' && LA23_0<='\uFFFF')) ) {s = 20;}

                        else if ( (LA23_0=='\\') ) {s = 21;}

                        else if ( (LA23_0=='\''||LA23_0=='{'||LA23_0=='}') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA23_154 = input.LA(1);

                         
                        int index23_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_154>='\u0000' && LA23_154<='/')||(LA23_154>=':' && LA23_154<='@')||(LA23_154>='G' && LA23_154<='`')||(LA23_154>='g' && LA23_154<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_154>='0' && LA23_154<='9')||(LA23_154>='A' && LA23_154<='F')||(LA23_154>='a' && LA23_154<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 161;}

                         
                        input.seek(index23_154);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA23_151 = input.LA(1);

                         
                        int index23_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_151>='\u0000' && LA23_151<='/')||(LA23_151>=':' && LA23_151<='@')||(LA23_151>='G' && LA23_151<='`')||(LA23_151>='g' && LA23_151<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_151>='0' && LA23_151<='9')||(LA23_151>='A' && LA23_151<='F')||(LA23_151>='a' && LA23_151<='f')) ) {s = 158;}

                         
                        input.seek(index23_151);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA23_50 = input.LA(1);

                         
                        int index23_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_50=='\n'||LA23_50=='\r'||LA23_50=='\"'||(LA23_50>='(' && LA23_50<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_50=='#') ) {s = 94;}

                        else if ( (LA23_50=='\t'||LA23_50==' ') ) {s = 105;}

                        else if ( ((LA23_50>='\u0000' && LA23_50<='\b')||(LA23_50>='\u000B' && LA23_50<='\f')||(LA23_50>='\u000E' && LA23_50<='\u001F')||LA23_50=='!'||(LA23_50>='$' && LA23_50<='\'')||(LA23_50>='*' && LA23_50<='+')||(LA23_50>='-' && LA23_50<='9')||(LA23_50>=';' && LA23_50<='Z')||(LA23_50>='^' && LA23_50<='z')||LA23_50=='|'||(LA23_50>='~' && LA23_50<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_50=='\\') ) {s = 107;}

                        else if ( (LA23_50==':') ) {s = 108;}

                        else if ( (LA23_50==','||LA23_50=='['||LA23_50==']'||LA23_50=='{'||LA23_50=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_50);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA23_129 = input.LA(1);

                         
                        int index23_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_129=='\n'||LA23_129=='\r'||LA23_129=='\"'||(LA23_129>='(' && LA23_129<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_129=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_129=='\t'||LA23_129==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_129>='\u0000' && LA23_129<='\b')||(LA23_129>='\u000B' && LA23_129<='\f')||(LA23_129>='\u000E' && LA23_129<='\u001F')||LA23_129=='!'||(LA23_129>='$' && LA23_129<='\'')||(LA23_129>='*' && LA23_129<='+')||(LA23_129>='-' && LA23_129<='9')||(LA23_129>=';' && LA23_129<='Z')||(LA23_129>='^' && LA23_129<='z')||LA23_129=='|'||(LA23_129>='~' && LA23_129<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_129=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_129==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_129==','||LA23_129=='['||LA23_129==']'||LA23_129=='{'||LA23_129=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_129);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA23_102 = input.LA(1);

                         
                        int index23_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_102=='\n'||LA23_102=='\r'||LA23_102=='\"'||(LA23_102>='(' && LA23_102<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_102=='#') ) {s = 94;}

                        else if ( (LA23_102=='\t'||LA23_102==' ') ) {s = 41;}

                        else if ( ((LA23_102>='\u0000' && LA23_102<='\b')||(LA23_102>='\u000B' && LA23_102<='\f')||(LA23_102>='\u000E' && LA23_102<='\u001F')||LA23_102=='!'||(LA23_102>='$' && LA23_102<='\'')||(LA23_102>='*' && LA23_102<='+')||(LA23_102>='-' && LA23_102<='9')||(LA23_102>=';' && LA23_102<='Z')||(LA23_102>='^' && LA23_102<='z')||LA23_102=='|'||(LA23_102>='~' && LA23_102<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_102=='\\') ) {s = 43;}

                        else if ( (LA23_102==':') ) {s = 44;}

                        else if ( (LA23_102==','||LA23_102=='['||LA23_102==']'||LA23_102=='{'||LA23_102=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_102);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA23_42 = input.LA(1);

                         
                        int index23_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_42=='\n'||LA23_42=='\r'||LA23_42=='\"'||(LA23_42>='(' && LA23_42<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_42=='#') ) {s = 94;}

                        else if ( (LA23_42=='\t'||LA23_42==' ') ) {s = 41;}

                        else if ( ((LA23_42>='\u0000' && LA23_42<='\b')||(LA23_42>='\u000B' && LA23_42<='\f')||(LA23_42>='\u000E' && LA23_42<='\u001F')||LA23_42=='!'||(LA23_42>='$' && LA23_42<='\'')||(LA23_42>='*' && LA23_42<='+')||(LA23_42>='-' && LA23_42<='9')||(LA23_42>=';' && LA23_42<='Z')||(LA23_42>='^' && LA23_42<='z')||LA23_42=='|'||(LA23_42>='~' && LA23_42<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_42=='\\') ) {s = 43;}

                        else if ( (LA23_42==':') ) {s = 44;}

                        else if ( (LA23_42==','||LA23_42=='['||LA23_42==']'||LA23_42=='{'||LA23_42=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_42);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA23_81 = input.LA(1);

                         
                        int index23_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_81=='\n'||LA23_81=='\r'||LA23_81=='\"'||(LA23_81>='(' && LA23_81<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_81=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_81=='\t'||LA23_81==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_81>='\u0000' && LA23_81<='\b')||(LA23_81>='\u000B' && LA23_81<='\f')||(LA23_81>='\u000E' && LA23_81<='\u001F')||LA23_81=='!'||(LA23_81>='$' && LA23_81<='\'')||(LA23_81>='*' && LA23_81<='+')||(LA23_81>='-' && LA23_81<='9')||(LA23_81>=';' && LA23_81<='Z')||(LA23_81>='^' && LA23_81<='z')||LA23_81=='|'||(LA23_81>='~' && LA23_81<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_81=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_81==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_81==','||LA23_81=='['||LA23_81==']'||LA23_81=='{'||LA23_81=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_81);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA23_126 = input.LA(1);

                         
                        int index23_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_126=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_126=='\t'||LA23_126==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_126>='\u0000' && LA23_126<='\b')||(LA23_126>='\u000B' && LA23_126<='\f')||(LA23_126>='\u000E' && LA23_126<='\u001F')||LA23_126=='!'||(LA23_126>='$' && LA23_126<='\'')||(LA23_126>='*' && LA23_126<='+')||(LA23_126>='-' && LA23_126<='9')||(LA23_126>=';' && LA23_126<='Z')||(LA23_126>='^' && LA23_126<='z')||LA23_126=='|'||(LA23_126>='~' && LA23_126<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_126=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_126==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_126==','||LA23_126=='['||LA23_126==']'||LA23_126=='{'||LA23_126=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else if ( (LA23_126=='\n'||LA23_126=='\r'||LA23_126=='\"'||(LA23_126>='(' && LA23_126<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 80;

                         
                        input.seek(index23_126);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA23_99 = input.LA(1);

                         
                        int index23_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_99=='#') ) {s = 94;}

                        else if ( (LA23_99=='\t'||LA23_99==' ') ) {s = 41;}

                        else if ( ((LA23_99>='\u0000' && LA23_99<='\b')||(LA23_99>='\u000B' && LA23_99<='\f')||(LA23_99>='\u000E' && LA23_99<='\u001F')||LA23_99=='!'||(LA23_99>='$' && LA23_99<='\'')||(LA23_99>='*' && LA23_99<='+')||(LA23_99>='-' && LA23_99<='9')||(LA23_99>=';' && LA23_99<='Z')||(LA23_99>='^' && LA23_99<='z')||LA23_99=='|'||(LA23_99>='~' && LA23_99<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_99=='\\') ) {s = 43;}

                        else if ( (LA23_99==':') ) {s = 44;}

                        else if ( (LA23_99==','||LA23_99=='['||LA23_99==']'||LA23_99=='{'||LA23_99=='}') ) {s = 45;}

                        else if ( (LA23_99=='\n'||LA23_99=='\r'||LA23_99=='\"'||(LA23_99>='(' && LA23_99<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index23_99);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA23_29 = input.LA(1);

                         
                        int index23_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() != State.INIT )) ) {s = 77;}

                        else if ( (true) ) {s = 78;}

                         
                        input.seek(index23_29);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA23_59 = input.LA(1);

                         
                        int index23_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_59=='\n'||LA23_59=='\r'||(LA23_59>='\"' && LA23_59<='#')||(LA23_59>='(' && LA23_59<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_59=='\t'||LA23_59==' ') ) {s = 41;}

                        else if ( ((LA23_59>='\u0000' && LA23_59<='\b')||(LA23_59>='\u000B' && LA23_59<='\f')||(LA23_59>='\u000E' && LA23_59<='\u001F')||LA23_59=='!'||(LA23_59>='$' && LA23_59<='\'')||(LA23_59>='*' && LA23_59<='+')||(LA23_59>='-' && LA23_59<='9')||(LA23_59>=';' && LA23_59<='Z')||(LA23_59>='^' && LA23_59<='z')||LA23_59=='|'||(LA23_59>='~' && LA23_59<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_59=='\\') ) {s = 43;}

                        else if ( (LA23_59==':') ) {s = 44;}

                        else if ( (LA23_59==','||LA23_59=='['||LA23_59==']'||LA23_59=='{'||LA23_59=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_59);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA23_157 = input.LA(1);

                         
                        int index23_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_157>='\u0000' && LA23_157<='/')||(LA23_157>=':' && LA23_157<='@')||(LA23_157>='G' && LA23_157<='`')||(LA23_157>='g' && LA23_157<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_157>='0' && LA23_157<='9')||(LA23_157>='A' && LA23_157<='F')||(LA23_157>='a' && LA23_157<='f')) ) {s = 164;}

                         
                        input.seek(index23_157);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA23_91 = input.LA(1);

                         
                        int index23_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_91=='\n'||LA23_91=='\r'||(LA23_91>='\"' && LA23_91<='#')||(LA23_91>='(' && LA23_91<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_91=='\t'||LA23_91==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_91>='\u0000' && LA23_91<='\b')||(LA23_91>='\u000B' && LA23_91<='\f')||(LA23_91>='\u000E' && LA23_91<='\u001F')||LA23_91=='!'||(LA23_91>='$' && LA23_91<='\'')||(LA23_91>='*' && LA23_91<='+')||(LA23_91>='-' && LA23_91<='9')||(LA23_91>=';' && LA23_91<='Z')||(LA23_91>='^' && LA23_91<='z')||LA23_91=='|'||(LA23_91>='~' && LA23_91<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_91=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_91==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_91==','||LA23_91=='['||LA23_91==']'||LA23_91=='{'||LA23_91=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_91);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA23_147 = input.LA(1);

                         
                        int index23_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_147>='\u0000' && LA23_147<='/')||(LA23_147>=':' && LA23_147<='@')||(LA23_147>='G' && LA23_147<='`')||(LA23_147>='g' && LA23_147<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_147>='0' && LA23_147<='9')||(LA23_147>='A' && LA23_147<='F')||(LA23_147>='a' && LA23_147<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 154;}

                         
                        input.seek(index23_147);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA23_144 = input.LA(1);

                         
                        int index23_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_144>='\u0000' && LA23_144<='/')||(LA23_144>=':' && LA23_144<='@')||(LA23_144>='G' && LA23_144<='`')||(LA23_144>='g' && LA23_144<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_144>='0' && LA23_144<='9')||(LA23_144>='A' && LA23_144<='F')||(LA23_144>='a' && LA23_144<='f')) ) {s = 151;}

                         
                        input.seek(index23_144);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_16=='\t'||LA23_16==' ') ) {s = 41;}

                        else if ( ((LA23_16>='\u0000' && LA23_16<='\b')||(LA23_16>='\u000B' && LA23_16<='\f')||(LA23_16>='\u000E' && LA23_16<='\u001F')||LA23_16=='!'||(LA23_16>='$' && LA23_16<='\'')||(LA23_16>='*' && LA23_16<='+')||(LA23_16>='-' && LA23_16<='9')||(LA23_16>=';' && LA23_16<='Z')||(LA23_16>='^' && LA23_16<='z')||LA23_16=='|'||(LA23_16>='~' && LA23_16<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_16=='\\') ) {s = 43;}

                        else if ( (LA23_16==':') ) {s = 44;}

                        else if ( (LA23_16==','||LA23_16=='['||LA23_16==']'||LA23_16=='{'||LA23_16=='}') ) {s = 45;}

                        else if ( (LA23_16=='\n'||LA23_16=='\r'||(LA23_16>='\"' && LA23_16<='#')||(LA23_16>='(' && LA23_16<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 47;

                         
                        input.seek(index23_16);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA23_44 = input.LA(1);

                         
                        int index23_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_44=='\n'||LA23_44=='\r'||LA23_44=='\"'||(LA23_44>='(' && LA23_44<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_44=='#') ) {s = 94;}

                        else if ( (LA23_44=='\t'||LA23_44==' ') ) {s = 41;}

                        else if ( ((LA23_44>='\u0000' && LA23_44<='\b')||(LA23_44>='\u000B' && LA23_44<='\f')||(LA23_44>='\u000E' && LA23_44<='\u001F')||LA23_44=='!'||(LA23_44>='$' && LA23_44<='\'')||(LA23_44>='*' && LA23_44<='+')||(LA23_44>='-' && LA23_44<='9')||(LA23_44>=';' && LA23_44<='Z')||(LA23_44>='^' && LA23_44<='z')||LA23_44=='|'||(LA23_44>='~' && LA23_44<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_44=='\\') ) {s = 43;}

                        else if ( (LA23_44==':') ) {s = 44;}

                        else if ( (LA23_44==','||LA23_44=='['||LA23_44==']'||LA23_44=='{'||LA23_44=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_44);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA23_83 = input.LA(1);

                         
                        int index23_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_83=='\n'||LA23_83=='\r'||LA23_83=='\"'||(LA23_83>='(' && LA23_83<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_83=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_83=='\t'||LA23_83==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_83>='\u0000' && LA23_83<='\b')||(LA23_83>='\u000B' && LA23_83<='\f')||(LA23_83>='\u000E' && LA23_83<='\u001F')||LA23_83=='!'||(LA23_83>='$' && LA23_83<='\'')||(LA23_83>='*' && LA23_83<='+')||(LA23_83>='-' && LA23_83<='9')||(LA23_83>=';' && LA23_83<='Z')||(LA23_83>='^' && LA23_83<='z')||LA23_83=='|'||(LA23_83>='~' && LA23_83<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_83=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_83==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_83==','||LA23_83=='['||LA23_83==']'||LA23_83=='{'||LA23_83=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_83);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA23_142 = input.LA(1);

                         
                        int index23_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_142>='\u0000' && LA23_142<='/')||(LA23_142>=':' && LA23_142<='@')||(LA23_142>='G' && LA23_142<='`')||(LA23_142>='g' && LA23_142<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_142>='0' && LA23_142<='9')||(LA23_142>='A' && LA23_142<='F')||(LA23_142>='a' && LA23_142<='f')) ) {s = 149;}

                         
                        input.seek(index23_142);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA23_137 = input.LA(1);

                         
                        int index23_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_137=='#') ) {s = 133;}

                        else if ( (LA23_137=='\t'||LA23_137==' ') ) {s = 105;}

                        else if ( ((LA23_137>='\u0000' && LA23_137<='\b')||(LA23_137>='\u000B' && LA23_137<='\f')||(LA23_137>='\u000E' && LA23_137<='\u001F')||LA23_137=='!'||(LA23_137>='$' && LA23_137<='\'')||(LA23_137>='*' && LA23_137<='+')||(LA23_137>='-' && LA23_137<='9')||(LA23_137>=';' && LA23_137<='Z')||(LA23_137>='^' && LA23_137<='z')||LA23_137=='|'||(LA23_137>='~' && LA23_137<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_137=='\\') ) {s = 107;}

                        else if ( (LA23_137==':') ) {s = 108;}

                        else if ( (LA23_137==','||LA23_137=='['||LA23_137==']'||LA23_137=='{'||LA23_137=='}') ) {s = 109;}

                        else if ( (LA23_137=='\n'||LA23_137=='\r'||LA23_137=='\"'||(LA23_137>='(' && LA23_137<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_137);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA23_68 = input.LA(1);

                         
                        int index23_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_68=='\n'||LA23_68=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_68=='\"') ) {s = 28;}

                        else if ( ((LA23_68>='\u0000' && LA23_68<='\t')||(LA23_68>='\u000B' && LA23_68<='\f')||(LA23_68>='\u000E' && LA23_68<='!')||(LA23_68>='#' && LA23_68<='[')||(LA23_68>=']' && LA23_68<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_68=='\\') ) {s = 27;}

                         
                        input.seek(index23_68);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_9>='\u0000' && LA23_9<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 33;

                         
                        input.seek(index23_9);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA23_20 = input.LA(1);

                         
                        int index23_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_20=='\t'||LA23_20==' ') ) {s = 41;}

                        else if ( ((LA23_20>='\u0000' && LA23_20<='\b')||(LA23_20>='\u000B' && LA23_20<='\f')||(LA23_20>='\u000E' && LA23_20<='\u001F')||LA23_20=='!'||(LA23_20>='$' && LA23_20<='\'')||(LA23_20>='*' && LA23_20<='+')||(LA23_20>='-' && LA23_20<='9')||(LA23_20>=';' && LA23_20<='Z')||(LA23_20>='^' && LA23_20<='z')||LA23_20=='|'||(LA23_20>='~' && LA23_20<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_20=='\\') ) {s = 43;}

                        else if ( (LA23_20==':') ) {s = 44;}

                        else if ( (LA23_20==','||LA23_20=='['||LA23_20==']'||LA23_20=='{'||LA23_20=='}') ) {s = 45;}

                        else if ( (LA23_20=='\n'||LA23_20=='\r'||(LA23_20>='\"' && LA23_20<='#')||(LA23_20>='(' && LA23_20<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index23_20);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA23_106 = input.LA(1);

                         
                        int index23_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_106=='\n'||LA23_106=='\r'||LA23_106=='\"'||(LA23_106>='(' && LA23_106<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_106=='#') ) {s = 133;}

                        else if ( (LA23_106=='\t'||LA23_106==' ') ) {s = 105;}

                        else if ( ((LA23_106>='\u0000' && LA23_106<='\b')||(LA23_106>='\u000B' && LA23_106<='\f')||(LA23_106>='\u000E' && LA23_106<='\u001F')||LA23_106=='!'||(LA23_106>='$' && LA23_106<='\'')||(LA23_106>='*' && LA23_106<='+')||(LA23_106>='-' && LA23_106<='9')||(LA23_106>=';' && LA23_106<='Z')||(LA23_106>='^' && LA23_106<='z')||LA23_106=='|'||(LA23_106>='~' && LA23_106<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_106=='\\') ) {s = 107;}

                        else if ( (LA23_106==':') ) {s = 108;}

                        else if ( (LA23_106==','||LA23_106=='['||LA23_106==']'||LA23_106=='{'||LA23_106=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_106);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA23_60 = input.LA(1);

                         
                        int index23_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_60=='\n'||LA23_60=='\r'||(LA23_60>='\"' && LA23_60<='#')||(LA23_60>='(' && LA23_60<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_60=='\t'||LA23_60==' ') ) {s = 41;}

                        else if ( ((LA23_60>='\u0000' && LA23_60<='\b')||(LA23_60>='\u000B' && LA23_60<='\f')||(LA23_60>='\u000E' && LA23_60<='\u001F')||LA23_60=='!'||(LA23_60>='$' && LA23_60<='\'')||(LA23_60>='*' && LA23_60<='+')||(LA23_60>='-' && LA23_60<='9')||(LA23_60>=';' && LA23_60<='Z')||(LA23_60>='^' && LA23_60<='z')||LA23_60=='|'||(LA23_60>='~' && LA23_60<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_60=='\\') ) {s = 43;}

                        else if ( (LA23_60==':') ) {s = 44;}

                        else if ( (LA23_60==','||LA23_60=='['||LA23_60==']'||LA23_60=='{'||LA23_60=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_60);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA23_121 = input.LA(1);

                         
                        int index23_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_121=='\n'||LA23_121=='\r'||(LA23_121>='\"' && LA23_121<='#')||(LA23_121>='(' && LA23_121<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_121=='\t'||LA23_121==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_121>='\u0000' && LA23_121<='\b')||(LA23_121>='\u000B' && LA23_121<='\f')||(LA23_121>='\u000E' && LA23_121<='\u001F')||LA23_121=='!'||(LA23_121>='$' && LA23_121<='\'')||(LA23_121>='*' && LA23_121<='+')||(LA23_121>='-' && LA23_121<='9')||(LA23_121>=';' && LA23_121<='Z')||(LA23_121>='^' && LA23_121<='z')||LA23_121=='|'||(LA23_121>='~' && LA23_121<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_121=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_121==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_121==','||LA23_121=='['||LA23_121==']'||LA23_121=='{'||LA23_121=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_121);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA23_94 = input.LA(1);

                         
                        int index23_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_94=='\n'||LA23_94=='\r'||(LA23_94>='\"' && LA23_94<='#')||(LA23_94>='(' && LA23_94<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_94=='\t'||LA23_94==' ') ) {s = 41;}

                        else if ( ((LA23_94>='\u0000' && LA23_94<='\b')||(LA23_94>='\u000B' && LA23_94<='\f')||(LA23_94>='\u000E' && LA23_94<='\u001F')||LA23_94=='!'||(LA23_94>='$' && LA23_94<='\'')||(LA23_94>='*' && LA23_94<='+')||(LA23_94>='-' && LA23_94<='9')||(LA23_94>=';' && LA23_94<='Z')||(LA23_94>='^' && LA23_94<='z')||LA23_94=='|'||(LA23_94>='~' && LA23_94<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_94=='\\') ) {s = 43;}

                        else if ( (LA23_94==':') ) {s = 44;}

                        else if ( (LA23_94==','||LA23_94=='['||LA23_94==']'||LA23_94=='{'||LA23_94=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_94);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA23_136 = input.LA(1);

                         
                        int index23_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_136=='\n'||LA23_136=='\r'||LA23_136=='\"'||(LA23_136>='(' && LA23_136<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_136=='#') ) {s = 133;}

                        else if ( (LA23_136=='\t'||LA23_136==' ') ) {s = 105;}

                        else if ( ((LA23_136>='\u0000' && LA23_136<='\b')||(LA23_136>='\u000B' && LA23_136<='\f')||(LA23_136>='\u000E' && LA23_136<='\u001F')||LA23_136=='!'||(LA23_136>='$' && LA23_136<='\'')||(LA23_136>='*' && LA23_136<='+')||(LA23_136>='-' && LA23_136<='9')||(LA23_136>=';' && LA23_136<='Z')||(LA23_136>='^' && LA23_136<='z')||LA23_136=='|'||(LA23_136>='~' && LA23_136<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_136=='\\') ) {s = 107;}

                        else if ( (LA23_136==':') ) {s = 108;}

                        else if ( (LA23_136==','||LA23_136=='['||LA23_136==']'||LA23_136=='{'||LA23_136=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_136);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA23_125 = input.LA(1);

                         
                        int index23_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_125=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_125=='\t'||LA23_125==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_125>='\u0000' && LA23_125<='\b')||(LA23_125>='\u000B' && LA23_125<='\f')||(LA23_125>='\u000E' && LA23_125<='\u001F')||LA23_125=='!'||(LA23_125>='$' && LA23_125<='\'')||(LA23_125>='*' && LA23_125<='+')||(LA23_125>='-' && LA23_125<='9')||(LA23_125>=';' && LA23_125<='Z')||(LA23_125>='^' && LA23_125<='z')||LA23_125=='|'||(LA23_125>='~' && LA23_125<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_125=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_125==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_125==','||LA23_125=='['||LA23_125==']'||LA23_125=='{'||LA23_125=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else if ( (LA23_125=='\n'||LA23_125=='\r'||LA23_125=='\"'||(LA23_125>='(' && LA23_125<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 80;

                         
                        input.seek(index23_125);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA23_98 = input.LA(1);

                         
                        int index23_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_98=='#') ) {s = 94;}

                        else if ( (LA23_98=='\t'||LA23_98==' ') ) {s = 41;}

                        else if ( ((LA23_98>='\u0000' && LA23_98<='\b')||(LA23_98>='\u000B' && LA23_98<='\f')||(LA23_98>='\u000E' && LA23_98<='\u001F')||LA23_98=='!'||(LA23_98>='$' && LA23_98<='\'')||(LA23_98>='*' && LA23_98<='+')||(LA23_98>='-' && LA23_98<='9')||(LA23_98>=';' && LA23_98<='Z')||(LA23_98>='^' && LA23_98<='z')||LA23_98=='|'||(LA23_98>='~' && LA23_98<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_98=='\\') ) {s = 43;}

                        else if ( (LA23_98==':') ) {s = 44;}

                        else if ( (LA23_98==','||LA23_98=='['||LA23_98==']'||LA23_98=='{'||LA23_98=='}') ) {s = 45;}

                        else if ( (LA23_98=='\n'||LA23_98=='\r'||LA23_98=='\"'||(LA23_98>='(' && LA23_98<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index23_98);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_5>='\u0000' && LA23_5<='\t')||(LA23_5>='\u000B' && LA23_5<='\f')||(LA23_5>='\u000E' && LA23_5<='!')||(LA23_5>='#' && LA23_5<='[')||(LA23_5>=']' && LA23_5<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_5=='\\') ) {s = 27;}

                        else if ( (LA23_5=='\"') ) {s = 28;}

                        else if ( (LA23_5=='\n'||LA23_5=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA23_61 = input.LA(1);

                         
                        int index23_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_61=='\n'||LA23_61=='\r'||(LA23_61>='\"' && LA23_61<='#')||(LA23_61>='(' && LA23_61<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_61=='\t'||LA23_61==' ') ) {s = 41;}

                        else if ( ((LA23_61>='\u0000' && LA23_61<='\b')||(LA23_61>='\u000B' && LA23_61<='\f')||(LA23_61>='\u000E' && LA23_61<='\u001F')||LA23_61=='!'||(LA23_61>='$' && LA23_61<='\'')||(LA23_61>='*' && LA23_61<='+')||(LA23_61>='-' && LA23_61<='9')||(LA23_61>=';' && LA23_61<='Z')||(LA23_61>='^' && LA23_61<='z')||LA23_61=='|'||(LA23_61>='~' && LA23_61<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_61=='\\') ) {s = 43;}

                        else if ( (LA23_61==':') ) {s = 44;}

                        else if ( (LA23_61==','||LA23_61=='['||LA23_61==']'||LA23_61=='{'||LA23_61=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_61);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA23_27 = input.LA(1);

                         
                        int index23_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_27>='\u0000' && LA23_27<='!')||(LA23_27>='#' && LA23_27<='.')||(LA23_27>='0' && LA23_27<='[')||(LA23_27>=']' && LA23_27<='a')||(LA23_27>='c' && LA23_27<='e')||(LA23_27>='g' && LA23_27<='m')||(LA23_27>='o' && LA23_27<='q')||LA23_27=='s'||(LA23_27>='v' && LA23_27<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_27=='\"') ) {s = 67;}

                        else if ( (LA23_27=='\\') ) {s = 68;}

                        else if ( (LA23_27=='/') ) {s = 69;}

                        else if ( (LA23_27=='b') ) {s = 70;}

                        else if ( (LA23_27=='f') ) {s = 71;}

                        else if ( (LA23_27=='n') ) {s = 72;}

                        else if ( (LA23_27=='r') ) {s = 73;}

                        else if ( (LA23_27=='t') ) {s = 74;}

                        else if ( (LA23_27=='u') ) {s = 75;}

                         
                        input.seek(index23_27);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA23_124 = input.LA(1);

                         
                        int index23_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_124=='\n'||LA23_124=='\r'||LA23_124=='\"'||(LA23_124>='(' && LA23_124<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_124=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_124=='\t'||LA23_124==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_124>='\u0000' && LA23_124<='\b')||(LA23_124>='\u000B' && LA23_124<='\f')||(LA23_124>='\u000E' && LA23_124<='\u001F')||LA23_124=='!'||(LA23_124>='$' && LA23_124<='\'')||(LA23_124>='*' && LA23_124<='+')||(LA23_124>='-' && LA23_124<='9')||(LA23_124>=';' && LA23_124<='Z')||(LA23_124>='^' && LA23_124<='z')||LA23_124=='|'||(LA23_124>='~' && LA23_124<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_124=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_124==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_124==','||LA23_124=='['||LA23_124==']'||LA23_124=='{'||LA23_124=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_124);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA23_97 = input.LA(1);

                         
                        int index23_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_97=='\n'||LA23_97=='\r'||LA23_97=='\"'||(LA23_97>='(' && LA23_97<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_97=='#') ) {s = 94;}

                        else if ( (LA23_97=='\t'||LA23_97==' ') ) {s = 41;}

                        else if ( ((LA23_97>='\u0000' && LA23_97<='\b')||(LA23_97>='\u000B' && LA23_97<='\f')||(LA23_97>='\u000E' && LA23_97<='\u001F')||LA23_97=='!'||(LA23_97>='$' && LA23_97<='\'')||(LA23_97>='*' && LA23_97<='+')||(LA23_97>='-' && LA23_97<='9')||(LA23_97>=';' && LA23_97<='Z')||(LA23_97>='^' && LA23_97<='z')||LA23_97=='|'||(LA23_97>='~' && LA23_97<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_97=='\\') ) {s = 43;}

                        else if ( (LA23_97==':') ) {s = 44;}

                        else if ( (LA23_97==','||LA23_97=='['||LA23_97==']'||LA23_97=='{'||LA23_97=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_97);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA23_64 = input.LA(1);

                         
                        int index23_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_64>='\u0000' && LA23_64<='/')||(LA23_64>=':' && LA23_64<='@')||(LA23_64>='G' && LA23_64<='`')||(LA23_64>='g' && LA23_64<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_64>='0' && LA23_64<='9')||(LA23_64>='A' && LA23_64<='F')||(LA23_64>='a' && LA23_64<='f')) ) {s = 119;}

                         
                        input.seek(index23_64);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA23_93 = input.LA(1);

                         
                        int index23_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_93>='\u0000' && LA23_93<='/')||(LA23_93>=':' && LA23_93<='@')||(LA23_93>='G' && LA23_93<='`')||(LA23_93>='g' && LA23_93<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_93>='0' && LA23_93<='9')||(LA23_93>='A' && LA23_93<='F')||(LA23_93>='a' && LA23_93<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 131;}

                         
                        input.seek(index23_93);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA23_158 = input.LA(1);

                         
                        int index23_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_158=='\t'||LA23_158==' ') ) {s = 41;}

                        else if ( ((LA23_158>='\u0000' && LA23_158<='\b')||(LA23_158>='\u000B' && LA23_158<='\f')||(LA23_158>='\u000E' && LA23_158<='\u001F')||LA23_158=='!'||(LA23_158>='$' && LA23_158<='\'')||(LA23_158>='*' && LA23_158<='+')||(LA23_158>='-' && LA23_158<='9')||(LA23_158>=';' && LA23_158<='Z')||(LA23_158>='^' && LA23_158<='z')||LA23_158=='|'||(LA23_158>='~' && LA23_158<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_158=='\\') ) {s = 43;}

                        else if ( (LA23_158==':') ) {s = 44;}

                        else if ( (LA23_158==','||LA23_158=='['||LA23_158==']'||LA23_158=='{'||LA23_158=='}') ) {s = 45;}

                        else if ( (LA23_158=='\n'||LA23_158=='\r'||(LA23_158>='\"' && LA23_158<='#')||(LA23_158>='(' && LA23_158<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index23_158);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA23_149 = input.LA(1);

                         
                        int index23_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_149>='0' && LA23_149<='9')||(LA23_149>='A' && LA23_149<='F')||(LA23_149>='a' && LA23_149<='f')) ) {s = 156;}

                        else if ( ((LA23_149>='\u0000' && LA23_149<='/')||(LA23_149>=':' && LA23_149<='@')||(LA23_149>='G' && LA23_149<='`')||(LA23_149>='g' && LA23_149<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_149);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA23_128 = input.LA(1);

                         
                        int index23_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_128=='\n'||LA23_128=='\r'||LA23_128=='\"'||(LA23_128>='(' && LA23_128<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_128=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_128=='\t'||LA23_128==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_128>='\u0000' && LA23_128<='\b')||(LA23_128>='\u000B' && LA23_128<='\f')||(LA23_128>='\u000E' && LA23_128<='\u001F')||LA23_128=='!'||(LA23_128>='$' && LA23_128<='\'')||(LA23_128>='*' && LA23_128<='+')||(LA23_128>='-' && LA23_128<='9')||(LA23_128>=';' && LA23_128<='Z')||(LA23_128>='^' && LA23_128<='z')||LA23_128=='|'||(LA23_128>='~' && LA23_128<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_128=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_128==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_128==','||LA23_128=='['||LA23_128==']'||LA23_128=='{'||LA23_128=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_128);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA23_101 = input.LA(1);

                         
                        int index23_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_101=='\n'||LA23_101=='\r'||LA23_101=='\"'||(LA23_101>='(' && LA23_101<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_101=='#') ) {s = 94;}

                        else if ( (LA23_101=='\t'||LA23_101==' ') ) {s = 41;}

                        else if ( ((LA23_101>='\u0000' && LA23_101<='\b')||(LA23_101>='\u000B' && LA23_101<='\f')||(LA23_101>='\u000E' && LA23_101<='\u001F')||LA23_101=='!'||(LA23_101>='$' && LA23_101<='\'')||(LA23_101>='*' && LA23_101<='+')||(LA23_101>='-' && LA23_101<='9')||(LA23_101>=';' && LA23_101<='Z')||(LA23_101>='^' && LA23_101<='z')||LA23_101=='|'||(LA23_101>='~' && LA23_101<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_101=='\\') ) {s = 43;}

                        else if ( (LA23_101==':') ) {s = 44;}

                        else if ( (LA23_101==','||LA23_101=='['||LA23_101==']'||LA23_101=='{'||LA23_101=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_101);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA23_146 = input.LA(1);

                         
                        int index23_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_146>='0' && LA23_146<='9')||(LA23_146>='A' && LA23_146<='F')||(LA23_146>='a' && LA23_146<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 153;}

                        else if ( ((LA23_146>='\u0000' && LA23_146<='/')||(LA23_146>=':' && LA23_146<='@')||(LA23_146>='G' && LA23_146<='`')||(LA23_146>='g' && LA23_146<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_146);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA23_132 = input.LA(1);

                         
                        int index23_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_132>='0' && LA23_132<='9')||(LA23_132>='A' && LA23_132<='F')||(LA23_132>='a' && LA23_132<='f')) ) {s = 148;}

                        else if ( ((LA23_132>='\u0000' && LA23_132<='/')||(LA23_132>=':' && LA23_132<='@')||(LA23_132>='G' && LA23_132<='`')||(LA23_132>='g' && LA23_132<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_132);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA23_116 = input.LA(1);

                         
                        int index23_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_116=='\n'||LA23_116=='\r'||LA23_116=='\"'||(LA23_116>='(' && LA23_116<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_116=='#') ) {s = 94;}

                        else if ( (LA23_116=='\t'||LA23_116==' ') ) {s = 105;}

                        else if ( ((LA23_116>='\u0000' && LA23_116<='\b')||(LA23_116>='\u000B' && LA23_116<='\f')||(LA23_116>='\u000E' && LA23_116<='\u001F')||LA23_116=='!'||(LA23_116>='$' && LA23_116<='\'')||(LA23_116>='*' && LA23_116<='+')||(LA23_116>='-' && LA23_116<='9')||(LA23_116>=';' && LA23_116<='Z')||(LA23_116>='^' && LA23_116<='z')||LA23_116=='|'||(LA23_116>='~' && LA23_116<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_116=='\\') ) {s = 107;}

                        else if ( (LA23_116==':') ) {s = 108;}

                        else if ( (LA23_116==','||LA23_116=='['||LA23_116==']'||LA23_116=='{'||LA23_116=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_116);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA23_28 = input.LA(1);

                         
                        int index23_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_28>='\u0000' && LA23_28<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 76;

                         
                        input.seek(index23_28);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA23_140 = input.LA(1);

                         
                        int index23_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_140=='\n'||LA23_140=='\r'||LA23_140=='\"'||(LA23_140>='(' && LA23_140<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_140=='#') ) {s = 133;}

                        else if ( (LA23_140=='\t'||LA23_140==' ') ) {s = 105;}

                        else if ( ((LA23_140>='\u0000' && LA23_140<='\b')||(LA23_140>='\u000B' && LA23_140<='\f')||(LA23_140>='\u000E' && LA23_140<='\u001F')||LA23_140=='!'||(LA23_140>='$' && LA23_140<='\'')||(LA23_140>='*' && LA23_140<='+')||(LA23_140>='-' && LA23_140<='9')||(LA23_140>=';' && LA23_140<='Z')||(LA23_140>='^' && LA23_140<='z')||LA23_140=='|'||(LA23_140>='~' && LA23_140<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_140=='\\') ) {s = 107;}

                        else if ( (LA23_140==':') ) {s = 108;}

                        else if ( (LA23_140==','||LA23_140=='['||LA23_140==']'||LA23_140=='{'||LA23_140=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_140);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA23_139 = input.LA(1);

                         
                        int index23_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_139=='\n'||LA23_139=='\r'||LA23_139=='\"'||(LA23_139>='(' && LA23_139<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_139=='#') ) {s = 133;}

                        else if ( (LA23_139=='\t'||LA23_139==' ') ) {s = 105;}

                        else if ( ((LA23_139>='\u0000' && LA23_139<='\b')||(LA23_139>='\u000B' && LA23_139<='\f')||(LA23_139>='\u000E' && LA23_139<='\u001F')||LA23_139=='!'||(LA23_139>='$' && LA23_139<='\'')||(LA23_139>='*' && LA23_139<='+')||(LA23_139>='-' && LA23_139<='9')||(LA23_139>=';' && LA23_139<='Z')||(LA23_139>='^' && LA23_139<='z')||LA23_139=='|'||(LA23_139>='~' && LA23_139<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_139=='\\') ) {s = 107;}

                        else if ( (LA23_139==':') ) {s = 108;}

                        else if ( (LA23_139==','||LA23_139=='['||LA23_139==']'||LA23_139=='{'||LA23_139=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_139);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA23_90 = input.LA(1);

                         
                        int index23_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_90=='\n'||LA23_90=='\r'||(LA23_90>='\"' && LA23_90<='#')||(LA23_90>='(' && LA23_90<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_90=='\t'||LA23_90==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_90>='\u0000' && LA23_90<='\b')||(LA23_90>='\u000B' && LA23_90<='\f')||(LA23_90>='\u000E' && LA23_90<='\u001F')||LA23_90=='!'||(LA23_90>='$' && LA23_90<='\'')||(LA23_90>='*' && LA23_90<='+')||(LA23_90>='-' && LA23_90<='9')||(LA23_90>=';' && LA23_90<='Z')||(LA23_90>='^' && LA23_90<='z')||LA23_90=='|'||(LA23_90>='~' && LA23_90<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_90=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_90==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_90==','||LA23_90=='['||LA23_90==']'||LA23_90=='{'||LA23_90=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_90);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA23_67 = input.LA(1);

                         
                        int index23_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_67=='\n'||LA23_67=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_67=='\"') ) {s = 28;}

                        else if ( ((LA23_67>='\u0000' && LA23_67<='\t')||(LA23_67>='\u000B' && LA23_67<='\f')||(LA23_67>='\u000E' && LA23_67<='!')||(LA23_67>='#' && LA23_67<='[')||(LA23_67>=']' && LA23_67<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_67=='\\') ) {s = 27;}

                         
                        input.seek(index23_67);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA23_17 = input.LA(1);

                         
                        int index23_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_17>='\u0000' && LA23_17<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 48;

                         
                        input.seek(index23_17);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA23_19 = input.LA(1);

                         
                        int index23_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_19>='\u0000' && LA23_19<='\b')||(LA23_19>='\u000B' && LA23_19<='\f')||(LA23_19>='\u000E' && LA23_19<='\u001F')||LA23_19=='!'||(LA23_19>='$' && LA23_19<='\'')||(LA23_19>='*' && LA23_19<='+')||(LA23_19>='-' && LA23_19<='9')||(LA23_19>=';' && LA23_19<='Z')||(LA23_19>='^' && LA23_19<='z')||LA23_19=='|'||(LA23_19>='~' && LA23_19<='\uFFFF')) ) {s = 50;}

                        else if ( (LA23_19=='\\') ) {s = 51;}

                        else if ( (LA23_19=='\t'||LA23_19==' ') ) {s = 41;}

                        else if ( (LA23_19==':') ) {s = 53;}

                        else if ( (LA23_19==','||LA23_19=='['||LA23_19==']'||LA23_19=='{'||LA23_19=='}') ) {s = 54;}

                        else if ( (LA23_19=='#'||(LA23_19>='(' && LA23_19<=')')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 37;}

                        else if ( (LA23_19=='\n'||LA23_19=='\r'||LA23_19=='\"') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 52;

                         
                        input.seek(index23_19);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA23_71 = input.LA(1);

                         
                        int index23_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_71=='\n'||LA23_71=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_71=='\"') ) {s = 28;}

                        else if ( ((LA23_71>='\u0000' && LA23_71<='\t')||(LA23_71>='\u000B' && LA23_71<='\f')||(LA23_71>='\u000E' && LA23_71<='!')||(LA23_71>='#' && LA23_71<='[')||(LA23_71>=']' && LA23_71<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_71=='\\') ) {s = 27;}

                         
                        input.seek(index23_71);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA23_166 = input.LA(1);

                         
                        int index23_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_166=='\n'||LA23_166=='\r'||LA23_166=='\"'||(LA23_166>='(' && LA23_166<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_166=='#') ) {s = 133;}

                        else if ( (LA23_166=='\t'||LA23_166==' ') ) {s = 105;}

                        else if ( ((LA23_166>='\u0000' && LA23_166<='\b')||(LA23_166>='\u000B' && LA23_166<='\f')||(LA23_166>='\u000E' && LA23_166<='\u001F')||LA23_166=='!'||(LA23_166>='$' && LA23_166<='\'')||(LA23_166>='*' && LA23_166<='+')||(LA23_166>='-' && LA23_166<='9')||(LA23_166>=';' && LA23_166<='Z')||(LA23_166>='^' && LA23_166<='z')||LA23_166=='|'||(LA23_166>='~' && LA23_166<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_166=='\\') ) {s = 107;}

                        else if ( (LA23_166==':') ) {s = 108;}

                        else if ( (LA23_166==','||LA23_166=='['||LA23_166==']'||LA23_166=='{'||LA23_166=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_166);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA23_110 = input.LA(1);

                         
                        int index23_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_110=='\n'||LA23_110=='\r'||LA23_110=='\"'||(LA23_110>='(' && LA23_110<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_110=='#') ) {s = 94;}

                        else if ( (LA23_110=='\t'||LA23_110==' ') ) {s = 105;}

                        else if ( ((LA23_110>='\u0000' && LA23_110<='\b')||(LA23_110>='\u000B' && LA23_110<='\f')||(LA23_110>='\u000E' && LA23_110<='\u001F')||LA23_110=='!'||(LA23_110>='$' && LA23_110<='\'')||(LA23_110>='*' && LA23_110<='+')||(LA23_110>='-' && LA23_110<='9')||(LA23_110>=';' && LA23_110<='Z')||(LA23_110>='^' && LA23_110<='z')||LA23_110=='|'||(LA23_110>='~' && LA23_110<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_110=='\\') ) {s = 107;}

                        else if ( (LA23_110==':') ) {s = 108;}

                        else if ( (LA23_110==','||LA23_110=='['||LA23_110==']'||LA23_110=='{'||LA23_110=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_110);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA23_13 = input.LA(1);

                         
                        int index23_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_13>='\u0000' && LA23_13<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 39;

                         
                        input.seek(index23_13);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA23_150 = input.LA(1);

                         
                        int index23_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_150>='\u0000' && LA23_150<='/')||(LA23_150>=':' && LA23_150<='@')||(LA23_150>='G' && LA23_150<='`')||(LA23_150>='g' && LA23_150<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_150>='0' && LA23_150<='9')||(LA23_150>='A' && LA23_150<='F')||(LA23_150>='a' && LA23_150<='f')) ) {s = 157;}

                         
                        input.seek(index23_150);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA23_87 = input.LA(1);

                         
                        int index23_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_87=='\n'||LA23_87=='\r'||(LA23_87>='\"' && LA23_87<='#')||(LA23_87>='(' && LA23_87<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_87=='\t'||LA23_87==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_87>='\u0000' && LA23_87<='\b')||(LA23_87>='\u000B' && LA23_87<='\f')||(LA23_87>='\u000E' && LA23_87<='\u001F')||LA23_87=='!'||(LA23_87>='$' && LA23_87<='\'')||(LA23_87>='*' && LA23_87<='+')||(LA23_87>='-' && LA23_87<='9')||(LA23_87>=';' && LA23_87<='Z')||(LA23_87>='^' && LA23_87<='z')||LA23_87=='|'||(LA23_87>='~' && LA23_87<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_87=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_87==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_87==','||LA23_87=='['||LA23_87==']'||LA23_87=='{'||LA23_87=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_87);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA23_86 = input.LA(1);

                         
                        int index23_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_86=='\n'||LA23_86=='\r'||(LA23_86>='\"' && LA23_86<='#')||(LA23_86>='(' && LA23_86<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_86=='\t'||LA23_86==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_86>='\u0000' && LA23_86<='\b')||(LA23_86>='\u000B' && LA23_86<='\f')||(LA23_86>='\u000E' && LA23_86<='\u001F')||LA23_86=='!'||(LA23_86>='$' && LA23_86<='\'')||(LA23_86>='*' && LA23_86<='+')||(LA23_86>='-' && LA23_86<='9')||(LA23_86>=';' && LA23_86<='Z')||(LA23_86>='^' && LA23_86<='z')||LA23_86=='|'||(LA23_86>='~' && LA23_86<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_86=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_86==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_86==','||LA23_86=='['||LA23_86==']'||LA23_86=='{'||LA23_86=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_86);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA23_72 = input.LA(1);

                         
                        int index23_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_72=='\n'||LA23_72=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_72=='\"') ) {s = 28;}

                        else if ( ((LA23_72>='\u0000' && LA23_72<='\t')||(LA23_72>='\u000B' && LA23_72<='\f')||(LA23_72>='\u000E' && LA23_72<='!')||(LA23_72>='#' && LA23_72<='[')||(LA23_72>=']' && LA23_72<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_72=='\\') ) {s = 27;}

                         
                        input.seek(index23_72);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA23_108 = input.LA(1);

                         
                        int index23_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_108=='\n'||LA23_108=='\r'||LA23_108=='\"'||(LA23_108>='(' && LA23_108<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_108=='#') ) {s = 133;}

                        else if ( (LA23_108=='\t'||LA23_108==' ') ) {s = 105;}

                        else if ( ((LA23_108>='\u0000' && LA23_108<='\b')||(LA23_108>='\u000B' && LA23_108<='\f')||(LA23_108>='\u000E' && LA23_108<='\u001F')||LA23_108=='!'||(LA23_108>='$' && LA23_108<='\'')||(LA23_108>='*' && LA23_108<='+')||(LA23_108>='-' && LA23_108<='9')||(LA23_108>=';' && LA23_108<='Z')||(LA23_108>='^' && LA23_108<='z')||LA23_108=='|'||(LA23_108>='~' && LA23_108<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_108=='\\') ) {s = 107;}

                        else if ( (LA23_108==':') ) {s = 108;}

                        else if ( (LA23_108==','||LA23_108=='['||LA23_108==']'||LA23_108=='{'||LA23_108=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_108);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA23_11 = input.LA(1);

                         
                        int index23_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_11>='\u0000' && LA23_11<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 35;

                         
                        input.seek(index23_11);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA23_70 = input.LA(1);

                         
                        int index23_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_70=='\n'||LA23_70=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_70=='\"') ) {s = 28;}

                        else if ( ((LA23_70>='\u0000' && LA23_70<='\t')||(LA23_70>='\u000B' && LA23_70<='\f')||(LA23_70>='\u000E' && LA23_70<='!')||(LA23_70>='#' && LA23_70<='[')||(LA23_70>=']' && LA23_70<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_70=='\\') ) {s = 27;}

                         
                        input.seek(index23_70);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA23_163 = input.LA(1);

                         
                        int index23_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_163>='\u0000' && LA23_163<='/')||(LA23_163>=':' && LA23_163<='@')||(LA23_163>='G' && LA23_163<='`')||(LA23_163>='g' && LA23_163<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_163>='0' && LA23_163<='9')||(LA23_163>='A' && LA23_163<='F')||(LA23_163>='a' && LA23_163<='f')) ) {s = 166;}

                         
                        input.seek(index23_163);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA23_133 = input.LA(1);

                         
                        int index23_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_133=='\n'||LA23_133=='\r'||(LA23_133>='\"' && LA23_133<='#')||(LA23_133>='(' && LA23_133<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_133=='\t'||LA23_133==' ') ) {s = 105;}

                        else if ( ((LA23_133>='\u0000' && LA23_133<='\b')||(LA23_133>='\u000B' && LA23_133<='\f')||(LA23_133>='\u000E' && LA23_133<='\u001F')||LA23_133=='!'||(LA23_133>='$' && LA23_133<='\'')||(LA23_133>='*' && LA23_133<='+')||(LA23_133>='-' && LA23_133<='9')||(LA23_133>=';' && LA23_133<='Z')||(LA23_133>='^' && LA23_133<='z')||LA23_133=='|'||(LA23_133>='~' && LA23_133<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_133=='\\') ) {s = 107;}

                        else if ( (LA23_133==':') ) {s = 108;}

                        else if ( (LA23_133==','||LA23_133=='['||LA23_133==']'||LA23_133=='{'||LA23_133=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_133);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA23_131 = input.LA(1);

                         
                        int index23_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_131>='\u0000' && LA23_131<='/')||(LA23_131>=':' && LA23_131<='@')||(LA23_131>='G' && LA23_131<='`')||(LA23_131>='g' && LA23_131<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_131>='0' && LA23_131<='9')||(LA23_131>='A' && LA23_131<='F')||(LA23_131>='a' && LA23_131<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 147;}

                         
                        input.seek(index23_131);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA23_119 = input.LA(1);

                         
                        int index23_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_119>='\u0000' && LA23_119<='/')||(LA23_119>=':' && LA23_119<='@')||(LA23_119>='G' && LA23_119<='`')||(LA23_119>='g' && LA23_119<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_119>='0' && LA23_119<='9')||(LA23_119>='A' && LA23_119<='F')||(LA23_119>='a' && LA23_119<='f')) ) {s = 144;}

                         
                        input.seek(index23_119);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA23_41 = input.LA(1);

                         
                        int index23_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_41=='\n'||LA23_41=='\r'||(LA23_41>='\"' && LA23_41<='#')||(LA23_41>='(' && LA23_41<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_41>='\u0000' && LA23_41<='\b')||(LA23_41>='\u000B' && LA23_41<='\f')||(LA23_41>='\u000E' && LA23_41<='\u001F')||LA23_41=='!'||(LA23_41>='$' && LA23_41<='\'')||(LA23_41>='*' && LA23_41<='+')||(LA23_41>='-' && LA23_41<='9')||(LA23_41>=';' && LA23_41<='Z')||(LA23_41>='^' && LA23_41<='z')||LA23_41=='|'||(LA23_41>='~' && LA23_41<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_41=='\\') ) {s = 43;}

                        else if ( (LA23_41==':') ) {s = 44;}

                        else if ( (LA23_41==','||LA23_41=='['||LA23_41==']'||LA23_41=='{'||LA23_41=='}') ) {s = 45;}

                        else if ( (LA23_41=='\t'||LA23_41==' ') ) {s = 41;}

                         
                        input.seek(index23_41);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA23_79 = input.LA(1);

                         
                        int index23_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_79=='\n'||LA23_79=='\r'||(LA23_79>='\"' && LA23_79<='#')||(LA23_79>='(' && LA23_79<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_79>='\u0000' && LA23_79<='\b')||(LA23_79>='\u000B' && LA23_79<='\f')||(LA23_79>='\u000E' && LA23_79<='\u001F')||LA23_79=='!'||(LA23_79>='$' && LA23_79<='\'')||(LA23_79>='*' && LA23_79<='+')||(LA23_79>='-' && LA23_79<='9')||(LA23_79>=';' && LA23_79<='Z')||(LA23_79>='^' && LA23_79<='z')||LA23_79=='|'||(LA23_79>='~' && LA23_79<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_79=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_79==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_79==','||LA23_79=='['||LA23_79==']'||LA23_79=='{'||LA23_79=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else if ( (LA23_79=='\t'||LA23_79==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                         
                        input.seek(index23_79);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA23_138 = input.LA(1);

                         
                        int index23_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_138=='#') ) {s = 133;}

                        else if ( (LA23_138=='\t'||LA23_138==' ') ) {s = 105;}

                        else if ( ((LA23_138>='\u0000' && LA23_138<='\b')||(LA23_138>='\u000B' && LA23_138<='\f')||(LA23_138>='\u000E' && LA23_138<='\u001F')||LA23_138=='!'||(LA23_138>='$' && LA23_138<='\'')||(LA23_138>='*' && LA23_138<='+')||(LA23_138>='-' && LA23_138<='9')||(LA23_138>=';' && LA23_138<='Z')||(LA23_138>='^' && LA23_138<='z')||LA23_138=='|'||(LA23_138>='~' && LA23_138<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_138=='\\') ) {s = 107;}

                        else if ( (LA23_138==':') ) {s = 108;}

                        else if ( (LA23_138==','||LA23_138=='['||LA23_138==']'||LA23_138=='{'||LA23_138=='}') ) {s = 109;}

                        else if ( (LA23_138=='\n'||LA23_138=='\r'||LA23_138=='\"'||(LA23_138>='(' && LA23_138<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_138);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA23_115 = input.LA(1);

                         
                        int index23_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_115=='\n'||LA23_115=='\r'||LA23_115=='\"'||(LA23_115>='(' && LA23_115<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_115=='#') ) {s = 94;}

                        else if ( (LA23_115=='\t'||LA23_115==' ') ) {s = 105;}

                        else if ( ((LA23_115>='\u0000' && LA23_115<='\b')||(LA23_115>='\u000B' && LA23_115<='\f')||(LA23_115>='\u000E' && LA23_115<='\u001F')||LA23_115=='!'||(LA23_115>='$' && LA23_115<='\'')||(LA23_115>='*' && LA23_115<='+')||(LA23_115>='-' && LA23_115<='9')||(LA23_115>=';' && LA23_115<='Z')||(LA23_115>='^' && LA23_115<='z')||LA23_115=='|'||(LA23_115>='~' && LA23_115<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_115=='\\') ) {s = 107;}

                        else if ( (LA23_115==':') ) {s = 108;}

                        else if ( (LA23_115==','||LA23_115=='['||LA23_115==']'||LA23_115=='{'||LA23_115=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_115);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA23_85 = input.LA(1);

                         
                        int index23_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_85=='\n'||LA23_85=='\r'||(LA23_85>='\"' && LA23_85<='#')||(LA23_85>='(' && LA23_85<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_85=='\t'||LA23_85==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_85>='\u0000' && LA23_85<='\b')||(LA23_85>='\u000B' && LA23_85<='\f')||(LA23_85>='\u000E' && LA23_85<='\u001F')||LA23_85=='!'||(LA23_85>='$' && LA23_85<='\'')||(LA23_85>='*' && LA23_85<='+')||(LA23_85>='-' && LA23_85<='9')||(LA23_85>=';' && LA23_85<='Z')||(LA23_85>='^' && LA23_85<='z')||LA23_85=='|'||(LA23_85>='~' && LA23_85<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_85=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_85==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_85==','||LA23_85=='['||LA23_85==']'||LA23_85=='{'||LA23_85=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_85);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA23_88 = input.LA(1);

                         
                        int index23_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_88=='\n'||LA23_88=='\r'||(LA23_88>='\"' && LA23_88<='#')||(LA23_88>='(' && LA23_88<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_88=='\t'||LA23_88==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_88>='\u0000' && LA23_88<='\b')||(LA23_88>='\u000B' && LA23_88<='\f')||(LA23_88>='\u000E' && LA23_88<='\u001F')||LA23_88=='!'||(LA23_88>='$' && LA23_88<='\'')||(LA23_88>='*' && LA23_88<='+')||(LA23_88>='-' && LA23_88<='9')||(LA23_88>=';' && LA23_88<='Z')||(LA23_88>='^' && LA23_88<='z')||LA23_88=='|'||(LA23_88>='~' && LA23_88<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_88=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_88==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_88==','||LA23_88=='['||LA23_88==']'||LA23_88=='{'||LA23_88=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_88);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA23_45 = input.LA(1);

                         
                        int index23_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_45=='\n'||LA23_45=='\r'||LA23_45=='\"'||(LA23_45>='(' && LA23_45<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_45=='#') ) {s = 94;}

                        else if ( (LA23_45=='\t'||LA23_45==' ') ) {s = 41;}

                        else if ( ((LA23_45>='\u0000' && LA23_45<='\b')||(LA23_45>='\u000B' && LA23_45<='\f')||(LA23_45>='\u000E' && LA23_45<='\u001F')||LA23_45=='!'||(LA23_45>='$' && LA23_45<='\'')||(LA23_45>='*' && LA23_45<='+')||(LA23_45>='-' && LA23_45<='9')||(LA23_45>=';' && LA23_45<='Z')||(LA23_45>='^' && LA23_45<='z')||LA23_45=='|'||(LA23_45>='~' && LA23_45<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_45=='\\') ) {s = 43;}

                        else if ( (LA23_45==':') ) {s = 44;}

                        else if ( (LA23_45==','||LA23_45=='['||LA23_45==']'||LA23_45=='{'||LA23_45=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_45);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA23_84 = input.LA(1);

                         
                        int index23_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_84=='\n'||LA23_84=='\r'||LA23_84=='\"'||(LA23_84>='(' && LA23_84<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_84=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_84=='\t'||LA23_84==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_84>='\u0000' && LA23_84<='\b')||(LA23_84>='\u000B' && LA23_84<='\f')||(LA23_84>='\u000E' && LA23_84<='\u001F')||LA23_84=='!'||(LA23_84>='$' && LA23_84<='\'')||(LA23_84>='*' && LA23_84<='+')||(LA23_84>='-' && LA23_84<='9')||(LA23_84>=';' && LA23_84<='Z')||(LA23_84>='^' && LA23_84<='z')||LA23_84=='|'||(LA23_84>='~' && LA23_84<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_84=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_84==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_84==','||LA23_84=='['||LA23_84==']'||LA23_84=='{'||LA23_84=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_84);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA23_31 = input.LA(1);

                         
                        int index23_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_31=='\t'||LA23_31==' ') ) {s = 31;}

                        else if ( ((LA23_31>='\u0000' && LA23_31<='\b')||(LA23_31>='\u000B' && LA23_31<='\f')||(LA23_31>='\u000E' && LA23_31<='\u001F')||(LA23_31>='!' && LA23_31<='\"')||LA23_31=='$'||(LA23_31>='&' && LA23_31<=',')||(LA23_31>='.' && LA23_31<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_31=='\n'||LA23_31=='\r') ) {s = 32;}

                        else s = 77;

                         
                        input.seek(index23_31);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA23_109 = input.LA(1);

                         
                        int index23_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_109=='\n'||LA23_109=='\r'||LA23_109=='\"'||(LA23_109>='(' && LA23_109<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_109=='#') ) {s = 133;}

                        else if ( (LA23_109=='\t'||LA23_109==' ') ) {s = 105;}

                        else if ( ((LA23_109>='\u0000' && LA23_109<='\b')||(LA23_109>='\u000B' && LA23_109<='\f')||(LA23_109>='\u000E' && LA23_109<='\u001F')||LA23_109=='!'||(LA23_109>='$' && LA23_109<='\'')||(LA23_109>='*' && LA23_109<='+')||(LA23_109>='-' && LA23_109<='9')||(LA23_109>=';' && LA23_109<='Z')||(LA23_109>='^' && LA23_109<='z')||LA23_109=='|'||(LA23_109>='~' && LA23_109<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_109=='\\') ) {s = 107;}

                        else if ( (LA23_109==':') ) {s = 108;}

                        else if ( (LA23_109==','||LA23_109=='['||LA23_109==']'||LA23_109=='{'||LA23_109=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_109);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA23_135 = input.LA(1);

                         
                        int index23_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_135=='#') ) {s = 133;}

                        else if ( (LA23_135=='\t'||LA23_135==' ') ) {s = 105;}

                        else if ( ((LA23_135>='\u0000' && LA23_135<='\b')||(LA23_135>='\u000B' && LA23_135<='\f')||(LA23_135>='\u000E' && LA23_135<='\u001F')||LA23_135=='!'||(LA23_135>='$' && LA23_135<='\'')||(LA23_135>='*' && LA23_135<='+')||(LA23_135>='-' && LA23_135<='9')||(LA23_135>=';' && LA23_135<='Z')||(LA23_135>='^' && LA23_135<='z')||LA23_135=='|'||(LA23_135>='~' && LA23_135<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_135=='\\') ) {s = 107;}

                        else if ( (LA23_135==':') ) {s = 108;}

                        else if ( (LA23_135==','||LA23_135=='['||LA23_135==']'||LA23_135=='{'||LA23_135=='}') ) {s = 109;}

                        else if ( (LA23_135=='\n'||LA23_135=='\r'||LA23_135=='\"'||(LA23_135>='(' && LA23_135<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_135);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA23_75 = input.LA(1);

                         
                        int index23_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_75>='\u0000' && LA23_75<='/')||(LA23_75>=':' && LA23_75<='@')||(LA23_75>='G' && LA23_75<='`')||(LA23_75>='g' && LA23_75<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_75>='0' && LA23_75<='9')||(LA23_75>='A' && LA23_75<='F')||(LA23_75>='a' && LA23_75<='f')) ) {s = 120;}

                         
                        input.seek(index23_75);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA23_120 = input.LA(1);

                         
                        int index23_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_120>='\u0000' && LA23_120<='/')||(LA23_120>=':' && LA23_120<='@')||(LA23_120>='G' && LA23_120<='`')||(LA23_120>='g' && LA23_120<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_120>='0' && LA23_120<='9')||(LA23_120>='A' && LA23_120<='F')||(LA23_120>='a' && LA23_120<='f')) ) {s = 145;}

                         
                        input.seek(index23_120);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA23_62 = input.LA(1);

                         
                        int index23_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_62=='\n'||LA23_62=='\r'||(LA23_62>='\"' && LA23_62<='#')||(LA23_62>='(' && LA23_62<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_62=='\t'||LA23_62==' ') ) {s = 41;}

                        else if ( ((LA23_62>='\u0000' && LA23_62<='\b')||(LA23_62>='\u000B' && LA23_62<='\f')||(LA23_62>='\u000E' && LA23_62<='\u001F')||LA23_62=='!'||(LA23_62>='$' && LA23_62<='\'')||(LA23_62>='*' && LA23_62<='+')||(LA23_62>='-' && LA23_62<='9')||(LA23_62>=';' && LA23_62<='Z')||(LA23_62>='^' && LA23_62<='z')||LA23_62=='|'||(LA23_62>='~' && LA23_62<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_62=='\\') ) {s = 43;}

                        else if ( (LA23_62==':') ) {s = 44;}

                        else if ( (LA23_62==','||LA23_62=='['||LA23_62==']'||LA23_62=='{'||LA23_62=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_62);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA23_143 = input.LA(1);

                         
                        int index23_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_143>='0' && LA23_143<='9')||(LA23_143>='A' && LA23_143<='F')||(LA23_143>='a' && LA23_143<='f')) ) {s = 150;}

                        else if ( ((LA23_143>='\u0000' && LA23_143<='/')||(LA23_143>=':' && LA23_143<='@')||(LA23_143>='G' && LA23_143<='`')||(LA23_143>='g' && LA23_143<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index23_143);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA23_89 = input.LA(1);

                         
                        int index23_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_89=='\n'||LA23_89=='\r'||(LA23_89>='\"' && LA23_89<='#')||(LA23_89>='(' && LA23_89<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_89=='\t'||LA23_89==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_89>='\u0000' && LA23_89<='\b')||(LA23_89>='\u000B' && LA23_89<='\f')||(LA23_89>='\u000E' && LA23_89<='\u001F')||LA23_89=='!'||(LA23_89>='$' && LA23_89<='\'')||(LA23_89>='*' && LA23_89<='+')||(LA23_89>='-' && LA23_89<='9')||(LA23_89>=';' && LA23_89<='Z')||(LA23_89>='^' && LA23_89<='z')||LA23_89=='|'||(LA23_89>='~' && LA23_89<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_89=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_89==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_89==','||LA23_89=='['||LA23_89==']'||LA23_89=='{'||LA23_89=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_89);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA23_73 = input.LA(1);

                         
                        int index23_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_73=='\n'||LA23_73=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_73=='\"') ) {s = 28;}

                        else if ( ((LA23_73>='\u0000' && LA23_73<='\t')||(LA23_73>='\u000B' && LA23_73<='\f')||(LA23_73>='\u000E' && LA23_73<='!')||(LA23_73>='#' && LA23_73<='[')||(LA23_73>=']' && LA23_73<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_73=='\\') ) {s = 27;}

                         
                        input.seek(index23_73);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA23_12 = input.LA(1);

                         
                        int index23_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_12>='\u0000' && LA23_12<='\b')||(LA23_12>='\u000B' && LA23_12<='\f')||(LA23_12>='\u000E' && LA23_12<='\u001F')||LA23_12=='!'||(LA23_12>='#' && LA23_12<='[')||(LA23_12>=']' && LA23_12<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 37;}

                        else if ( (LA23_12=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 38;}

                        else if ( ((LA23_12>='\t' && LA23_12<='\n')||LA23_12=='\r'||LA23_12==' '||LA23_12=='\"') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 36;

                         
                        input.seek(index23_12);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA23_160 = input.LA(1);

                         
                        int index23_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_160>='\u0000' && LA23_160<='/')||(LA23_160>=':' && LA23_160<='@')||(LA23_160>='G' && LA23_160<='`')||(LA23_160>='g' && LA23_160<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_160>='0' && LA23_160<='9')||(LA23_160>='A' && LA23_160<='F')||(LA23_160>='a' && LA23_160<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 165;}

                         
                        input.seek(index23_160);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA23_155 = input.LA(1);

                         
                        int index23_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_155>='\u0000' && LA23_155<='/')||(LA23_155>=':' && LA23_155<='@')||(LA23_155>='G' && LA23_155<='`')||(LA23_155>='g' && LA23_155<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_155>='0' && LA23_155<='9')||(LA23_155>='A' && LA23_155<='F')||(LA23_155>='a' && LA23_155<='f')) ) {s = 162;}

                         
                        input.seek(index23_155);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA23_18 = input.LA(1);

                         
                        int index23_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_18>='\u0000' && LA23_18<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 49;

                         
                        input.seek(index23_18);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA23_127 = input.LA(1);

                         
                        int index23_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_127=='\n'||LA23_127=='\r'||LA23_127=='\"'||(LA23_127>='(' && LA23_127<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_127=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_127=='\t'||LA23_127==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_127>='\u0000' && LA23_127<='\b')||(LA23_127>='\u000B' && LA23_127<='\f')||(LA23_127>='\u000E' && LA23_127<='\u001F')||LA23_127=='!'||(LA23_127>='$' && LA23_127<='\'')||(LA23_127>='*' && LA23_127<='+')||(LA23_127>='-' && LA23_127<='9')||(LA23_127>=';' && LA23_127<='Z')||(LA23_127>='^' && LA23_127<='z')||LA23_127=='|'||(LA23_127>='~' && LA23_127<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_127=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_127==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_127==','||LA23_127=='['||LA23_127==']'||LA23_127=='{'||LA23_127=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_127);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA23_100 = input.LA(1);

                         
                        int index23_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_100=='\n'||LA23_100=='\r'||LA23_100=='\"'||(LA23_100>='(' && LA23_100<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_100=='#') ) {s = 94;}

                        else if ( (LA23_100=='\t'||LA23_100==' ') ) {s = 41;}

                        else if ( ((LA23_100>='\u0000' && LA23_100<='\b')||(LA23_100>='\u000B' && LA23_100<='\f')||(LA23_100>='\u000E' && LA23_100<='\u001F')||LA23_100=='!'||(LA23_100>='$' && LA23_100<='\'')||(LA23_100>='*' && LA23_100<='+')||(LA23_100>='-' && LA23_100<='9')||(LA23_100>=';' && LA23_100<='Z')||(LA23_100>='^' && LA23_100<='z')||LA23_100=='|'||(LA23_100>='~' && LA23_100<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_100=='\\') ) {s = 43;}

                        else if ( (LA23_100==':') ) {s = 44;}

                        else if ( (LA23_100==','||LA23_100=='['||LA23_100==']'||LA23_100=='{'||LA23_100=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_100);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA23_141 = input.LA(1);

                         
                        int index23_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_141=='\n'||LA23_141=='\r'||LA23_141=='\"'||(LA23_141>='(' && LA23_141<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_141=='#') ) {s = 133;}

                        else if ( (LA23_141=='\t'||LA23_141==' ') ) {s = 105;}

                        else if ( ((LA23_141>='\u0000' && LA23_141<='\b')||(LA23_141>='\u000B' && LA23_141<='\f')||(LA23_141>='\u000E' && LA23_141<='\u001F')||LA23_141=='!'||(LA23_141>='$' && LA23_141<='\'')||(LA23_141>='*' && LA23_141<='+')||(LA23_141>='-' && LA23_141<='9')||(LA23_141>=';' && LA23_141<='Z')||(LA23_141>='^' && LA23_141<='z')||LA23_141=='|'||(LA23_141>='~' && LA23_141<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_141=='\\') ) {s = 107;}

                        else if ( (LA23_141==':') ) {s = 108;}

                        else if ( (LA23_141==','||LA23_141=='['||LA23_141==']'||LA23_141=='{'||LA23_141=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index23_141);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA23_114 = input.LA(1);

                         
                        int index23_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_114=='#') ) {s = 94;}

                        else if ( (LA23_114=='\t'||LA23_114==' ') ) {s = 105;}

                        else if ( ((LA23_114>='\u0000' && LA23_114<='\b')||(LA23_114>='\u000B' && LA23_114<='\f')||(LA23_114>='\u000E' && LA23_114<='\u001F')||LA23_114=='!'||(LA23_114>='$' && LA23_114<='\'')||(LA23_114>='*' && LA23_114<='+')||(LA23_114>='-' && LA23_114<='9')||(LA23_114>=';' && LA23_114<='Z')||(LA23_114>='^' && LA23_114<='z')||LA23_114=='|'||(LA23_114>='~' && LA23_114<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_114=='\\') ) {s = 107;}

                        else if ( (LA23_114==':') ) {s = 108;}

                        else if ( (LA23_114==','||LA23_114=='['||LA23_114==']'||LA23_114=='{'||LA23_114=='}') ) {s = 109;}

                        else if ( (LA23_114=='\n'||LA23_114=='\r'||LA23_114=='\"'||(LA23_114>='(' && LA23_114<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_114);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_14=='\t'||LA23_14==' ') ) {s = 41;}

                        else if ( ((LA23_14>='\u0000' && LA23_14<='\b')||(LA23_14>='\u000B' && LA23_14<='\f')||(LA23_14>='\u000E' && LA23_14<='\u001F')||LA23_14=='!'||(LA23_14>='$' && LA23_14<='\'')||(LA23_14>='*' && LA23_14<='+')||(LA23_14>='-' && LA23_14<='9')||(LA23_14>=';' && LA23_14<='Z')||(LA23_14>='^' && LA23_14<='z')||LA23_14=='|'||(LA23_14>='~' && LA23_14<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_14=='\\') ) {s = 43;}

                        else if ( (LA23_14==':') ) {s = 44;}

                        else if ( (LA23_14==','||LA23_14=='['||LA23_14==']'||LA23_14=='{'||LA23_14=='}') ) {s = 45;}

                        else if ( (LA23_14=='\n'||LA23_14=='\r'||(LA23_14>='\"' && LA23_14<='#')||(LA23_14>='(' && LA23_14<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 40;

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA23_122 = input.LA(1);

                         
                        int index23_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_122=='\n'||LA23_122=='\r'||LA23_122=='\"'||(LA23_122>='(' && LA23_122<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_122=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_122=='\t'||LA23_122==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_122>='\u0000' && LA23_122<='\b')||(LA23_122>='\u000B' && LA23_122<='\f')||(LA23_122>='\u000E' && LA23_122<='\u001F')||LA23_122=='!'||(LA23_122>='$' && LA23_122<='\'')||(LA23_122>='*' && LA23_122<='+')||(LA23_122>='-' && LA23_122<='9')||(LA23_122>=';' && LA23_122<='Z')||(LA23_122>='^' && LA23_122<='z')||LA23_122=='|'||(LA23_122>='~' && LA23_122<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_122=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_122==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_122==','||LA23_122=='['||LA23_122==']'||LA23_122=='{'||LA23_122=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_122);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA23_95 = input.LA(1);

                         
                        int index23_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_95=='\n'||LA23_95=='\r'||LA23_95=='\"'||(LA23_95>='(' && LA23_95<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_95=='#') ) {s = 94;}

                        else if ( (LA23_95=='\t'||LA23_95==' ') ) {s = 41;}

                        else if ( ((LA23_95>='\u0000' && LA23_95<='\b')||(LA23_95>='\u000B' && LA23_95<='\f')||(LA23_95>='\u000E' && LA23_95<='\u001F')||LA23_95=='!'||(LA23_95>='$' && LA23_95<='\'')||(LA23_95>='*' && LA23_95<='+')||(LA23_95>='-' && LA23_95<='9')||(LA23_95>=';' && LA23_95<='Z')||(LA23_95>='^' && LA23_95<='z')||LA23_95=='|'||(LA23_95>='~' && LA23_95<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_95=='\\') ) {s = 43;}

                        else if ( (LA23_95==':') ) {s = 44;}

                        else if ( (LA23_95==','||LA23_95=='['||LA23_95==']'||LA23_95=='{'||LA23_95=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_95);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA23_58 = input.LA(1);

                         
                        int index23_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_58=='\n'||LA23_58=='\r'||(LA23_58>='\"' && LA23_58<='#')||(LA23_58>='(' && LA23_58<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_58=='\t'||LA23_58==' ') ) {s = 41;}

                        else if ( ((LA23_58>='\u0000' && LA23_58<='\b')||(LA23_58>='\u000B' && LA23_58<='\f')||(LA23_58>='\u000E' && LA23_58<='\u001F')||LA23_58=='!'||(LA23_58>='$' && LA23_58<='\'')||(LA23_58>='*' && LA23_58<='+')||(LA23_58>='-' && LA23_58<='9')||(LA23_58>=';' && LA23_58<='Z')||(LA23_58>='^' && LA23_58<='z')||LA23_58=='|'||(LA23_58>='~' && LA23_58<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_58=='\\') ) {s = 43;}

                        else if ( (LA23_58==':') ) {s = 44;}

                        else if ( (LA23_58==','||LA23_58=='['||LA23_58==']'||LA23_58=='{'||LA23_58=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_58);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA23_92 = input.LA(1);

                         
                        int index23_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_92=='\n'||LA23_92=='\r'||(LA23_92>='\"' && LA23_92<='#')||(LA23_92>='(' && LA23_92<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_92=='\t'||LA23_92==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_92>='\u0000' && LA23_92<='\b')||(LA23_92>='\u000B' && LA23_92<='\f')||(LA23_92>='\u000E' && LA23_92<='\u001F')||LA23_92=='!'||(LA23_92>='$' && LA23_92<='\'')||(LA23_92>='*' && LA23_92<='+')||(LA23_92>='-' && LA23_92<='9')||(LA23_92>=';' && LA23_92<='Z')||(LA23_92>='^' && LA23_92<='z')||LA23_92=='|'||(LA23_92>='~' && LA23_92<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_92=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_92==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_92==','||LA23_92=='['||LA23_92==']'||LA23_92=='{'||LA23_92=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_92);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA23_74 = input.LA(1);

                         
                        int index23_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_74=='\n'||LA23_74=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_74=='\"') ) {s = 28;}

                        else if ( ((LA23_74>='\u0000' && LA23_74<='\t')||(LA23_74>='\u000B' && LA23_74<='\f')||(LA23_74>='\u000E' && LA23_74<='!')||(LA23_74>='#' && LA23_74<='[')||(LA23_74>=']' && LA23_74<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_74=='\\') ) {s = 27;}

                         
                        input.seek(index23_74);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA23_57 = input.LA(1);

                         
                        int index23_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_57=='\n'||LA23_57=='\r'||(LA23_57>='\"' && LA23_57<='#')||(LA23_57>='(' && LA23_57<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_57=='\t'||LA23_57==' ') ) {s = 41;}

                        else if ( ((LA23_57>='\u0000' && LA23_57<='\b')||(LA23_57>='\u000B' && LA23_57<='\f')||(LA23_57>='\u000E' && LA23_57<='\u001F')||LA23_57=='!'||(LA23_57>='$' && LA23_57<='\'')||(LA23_57>='*' && LA23_57<='+')||(LA23_57>='-' && LA23_57<='9')||(LA23_57>=';' && LA23_57<='Z')||(LA23_57>='^' && LA23_57<='z')||LA23_57=='|'||(LA23_57>='~' && LA23_57<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_57=='\\') ) {s = 43;}

                        else if ( (LA23_57==':') ) {s = 44;}

                        else if ( (LA23_57==','||LA23_57=='['||LA23_57==']'||LA23_57=='{'||LA23_57=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_57);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA23_25 = input.LA(1);

                         
                        int index23_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 66;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index23_25);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA23_24 = input.LA(1);

                         
                        int index23_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 66;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index23_24);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA23_65 = input.LA(1);

                         
                        int index23_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 66;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index23_65);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA23_69 = input.LA(1);

                         
                        int index23_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_69=='\n'||LA23_69=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_69=='\"') ) {s = 28;}

                        else if ( ((LA23_69>='\u0000' && LA23_69<='\t')||(LA23_69>='\u000B' && LA23_69<='\f')||(LA23_69>='\u000E' && LA23_69<='!')||(LA23_69>='#' && LA23_69<='[')||(LA23_69>=']' && LA23_69<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_69=='\\') ) {s = 27;}

                         
                        input.seek(index23_69);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA23_165 = input.LA(1);

                         
                        int index23_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_165=='\n'||LA23_165=='\r'||LA23_165=='\"'||(LA23_165>='(' && LA23_165<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_165=='#') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 121;}

                        else if ( (LA23_165=='\t'||LA23_165==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_165>='\u0000' && LA23_165<='\b')||(LA23_165>='\u000B' && LA23_165<='\f')||(LA23_165>='\u000E' && LA23_165<='\u001F')||LA23_165=='!'||(LA23_165>='$' && LA23_165<='\'')||(LA23_165>='*' && LA23_165<='+')||(LA23_165>='-' && LA23_165<='9')||(LA23_165>=';' && LA23_165<='Z')||(LA23_165>='^' && LA23_165<='z')||LA23_165=='|'||(LA23_165>='~' && LA23_165<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_165=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_165==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_165==','||LA23_165=='['||LA23_165==']'||LA23_165=='{'||LA23_165=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_165);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA23_162 = input.LA(1);

                         
                        int index23_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_162=='\n'||LA23_162=='\r'||LA23_162=='\"'||(LA23_162>='(' && LA23_162<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_162=='#') ) {s = 94;}

                        else if ( (LA23_162=='\t'||LA23_162==' ') ) {s = 41;}

                        else if ( ((LA23_162>='\u0000' && LA23_162<='\b')||(LA23_162>='\u000B' && LA23_162<='\f')||(LA23_162>='\u000E' && LA23_162<='\u001F')||LA23_162=='!'||(LA23_162>='$' && LA23_162<='\'')||(LA23_162>='*' && LA23_162<='+')||(LA23_162>='-' && LA23_162<='9')||(LA23_162>=';' && LA23_162<='Z')||(LA23_162>='^' && LA23_162<='z')||LA23_162=='|'||(LA23_162>='~' && LA23_162<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_162=='\\') ) {s = 43;}

                        else if ( (LA23_162==':') ) {s = 44;}

                        else if ( (LA23_162==','||LA23_162=='['||LA23_162==']'||LA23_162=='{'||LA23_162=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_162);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA23_30 = input.LA(1);

                         
                        int index23_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_30==' ') ) {s = 30;}

                        else if ( (LA23_30=='-') ) {s = 7;}

                        else if ( (LA23_30=='\t') ) {s = 31;}

                        else if ( ((LA23_30>='\u0000' && LA23_30<='\b')||(LA23_30>='\u000B' && LA23_30<='\f')||(LA23_30>='\u000E' && LA23_30<='\u001F')||(LA23_30>='!' && LA23_30<='\"')||LA23_30=='$'||(LA23_30>='&' && LA23_30<=',')||(LA23_30>='.' && LA23_30<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_30=='\n'||LA23_30=='\r') ) {s = 32;}

                        else s = 77;

                         
                        input.seek(index23_30);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA23_161 = input.LA(1);

                         
                        int index23_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_161=='\n'||LA23_161=='\r'||(LA23_161>='\"' && LA23_161<='#')||(LA23_161>='(' && LA23_161<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_161=='\t'||LA23_161==' ') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 79;}

                        else if ( ((LA23_161>='\u0000' && LA23_161<='\b')||(LA23_161>='\u000B' && LA23_161<='\f')||(LA23_161>='\u000E' && LA23_161<='\u001F')||LA23_161=='!'||(LA23_161>='$' && LA23_161<='\'')||(LA23_161>='*' && LA23_161<='+')||(LA23_161>='-' && LA23_161<='9')||(LA23_161>=';' && LA23_161<='Z')||(LA23_161>='^' && LA23_161<='z')||LA23_161=='|'||(LA23_161>='~' && LA23_161<='\uFFFF')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 81;}

                        else if ( (LA23_161=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 82;}

                        else if ( (LA23_161==':') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 83;}

                        else if ( (LA23_161==','||LA23_161=='['||LA23_161==']'||LA23_161=='{'||LA23_161=='}') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 84;}

                        else s = 80;

                         
                        input.seek(index23_161);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA23_145 = input.LA(1);

                         
                        int index23_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_145>='\u0000' && LA23_145<='/')||(LA23_145>=':' && LA23_145<='@')||(LA23_145>='G' && LA23_145<='`')||(LA23_145>='g' && LA23_145<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_145>='0' && LA23_145<='9')||(LA23_145>='A' && LA23_145<='F')||(LA23_145>='a' && LA23_145<='f')) ) {s = 152;}

                         
                        input.seek(index23_145);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA23_53 = input.LA(1);

                         
                        int index23_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_53=='\n'||LA23_53=='\r'||LA23_53=='\"'||(LA23_53>='(' && LA23_53<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_53=='\t'||LA23_53==' ') ) {s = 105;}

                        else if ( ((LA23_53>='\u0000' && LA23_53<='\b')||(LA23_53>='\u000B' && LA23_53<='\f')||(LA23_53>='\u000E' && LA23_53<='\u001F')||LA23_53=='!'||(LA23_53>='$' && LA23_53<='\'')||(LA23_53>='*' && LA23_53<='+')||(LA23_53>='-' && LA23_53<='9')||(LA23_53>=';' && LA23_53<='Z')||(LA23_53>='^' && LA23_53<='z')||LA23_53=='|'||(LA23_53>='~' && LA23_53<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_53=='\\') ) {s = 107;}

                        else if ( (LA23_53==':') ) {s = 108;}

                        else if ( (LA23_53==','||LA23_53=='['||LA23_53==']'||LA23_53=='{'||LA23_53=='}') ) {s = 109;}

                        else if ( (LA23_53=='#') ) {s = 94;}

                        else s = 104;

                         
                        input.seek(index23_53);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA23_63 = input.LA(1);

                         
                        int index23_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_63=='\n'||LA23_63=='\r'||(LA23_63>='\"' && LA23_63<='#')||(LA23_63>='(' && LA23_63<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_63=='\t'||LA23_63==' ') ) {s = 41;}

                        else if ( ((LA23_63>='\u0000' && LA23_63<='\b')||(LA23_63>='\u000B' && LA23_63<='\f')||(LA23_63>='\u000E' && LA23_63<='\u001F')||LA23_63=='!'||(LA23_63>='$' && LA23_63<='\'')||(LA23_63>='*' && LA23_63<='+')||(LA23_63>='-' && LA23_63<='9')||(LA23_63>=';' && LA23_63<='Z')||(LA23_63>='^' && LA23_63<='z')||LA23_63=='|'||(LA23_63>='~' && LA23_63<='\uFFFF')) ) {s = 42;}

                        else if ( (LA23_63=='\\') ) {s = 43;}

                        else if ( (LA23_63==':') ) {s = 44;}

                        else if ( (LA23_63==','||LA23_63=='['||LA23_63==']'||LA23_63=='{'||LA23_63=='}') ) {s = 45;}

                        else s = 55;

                         
                        input.seek(index23_63);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA23_111 = input.LA(1);

                         
                        int index23_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_111=='#') ) {s = 94;}

                        else if ( (LA23_111=='\t'||LA23_111==' ') ) {s = 105;}

                        else if ( ((LA23_111>='\u0000' && LA23_111<='\b')||(LA23_111>='\u000B' && LA23_111<='\f')||(LA23_111>='\u000E' && LA23_111<='\u001F')||LA23_111=='!'||(LA23_111>='$' && LA23_111<='\'')||(LA23_111>='*' && LA23_111<='+')||(LA23_111>='-' && LA23_111<='9')||(LA23_111>=';' && LA23_111<='Z')||(LA23_111>='^' && LA23_111<='z')||LA23_111=='|'||(LA23_111>='~' && LA23_111<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_111=='\\') ) {s = 107;}

                        else if ( (LA23_111==':') ) {s = 108;}

                        else if ( (LA23_111==','||LA23_111=='['||LA23_111==']'||LA23_111=='{'||LA23_111=='}') ) {s = 109;}

                        else if ( (LA23_111=='\n'||LA23_111=='\r'||LA23_111=='\"'||(LA23_111>='(' && LA23_111<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 104;

                         
                        input.seek(index23_111);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA23_38 = input.LA(1);

                         
                        int index23_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_38>='\u0000' && LA23_38<='!')||(LA23_38>='#' && LA23_38<='.')||(LA23_38>='0' && LA23_38<='[')||(LA23_38>=']' && LA23_38<='a')||(LA23_38>='c' && LA23_38<='e')||(LA23_38>='g' && LA23_38<='m')||(LA23_38>='o' && LA23_38<='q')||LA23_38=='s'||(LA23_38>='v' && LA23_38<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_38=='\"') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 85;}

                        else if ( (LA23_38=='\\') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 86;}

                        else if ( (LA23_38=='/') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 87;}

                        else if ( (LA23_38=='b') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 88;}

                        else if ( (LA23_38=='f') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 89;}

                        else if ( (LA23_38=='n') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 90;}

                        else if ( (LA23_38=='r') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 91;}

                        else if ( (LA23_38=='t') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 92;}

                        else if ( (LA23_38=='u') && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 93;}

                         
                        input.seek(index23_38);
                        if ( s>=0 ) return s;
                        break;
                    case 137 : 
                        int LA23_26 = input.LA(1);

                         
                        int index23_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_26=='\n'||LA23_26=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_26=='\"') ) {s = 28;}

                        else if ( ((LA23_26>='\u0000' && LA23_26<='\t')||(LA23_26>='\u000B' && LA23_26<='\f')||(LA23_26>='\u000E' && LA23_26<='!')||(LA23_26>='#' && LA23_26<='[')||(LA23_26>=']' && LA23_26<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_26=='\\') ) {s = 27;}

                         
                        input.seek(index23_26);
                        if ( s>=0 ) return s;
                        break;
                    case 138 : 
                        int LA23_164 = input.LA(1);

                         
                        int index23_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_164=='\n'||LA23_164=='\r'||LA23_164=='\"'||(LA23_164>='(' && LA23_164<=')')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA23_164=='\t'||LA23_164==' ') ) {s = 105;}

                        else if ( ((LA23_164>='\u0000' && LA23_164<='\b')||(LA23_164>='\u000B' && LA23_164<='\f')||(LA23_164>='\u000E' && LA23_164<='\u001F')||LA23_164=='!'||(LA23_164>='$' && LA23_164<='\'')||(LA23_164>='*' && LA23_164<='+')||(LA23_164>='-' && LA23_164<='9')||(LA23_164>=';' && LA23_164<='Z')||(LA23_164>='^' && LA23_164<='z')||LA23_164=='|'||(LA23_164>='~' && LA23_164<='\uFFFF')) ) {s = 106;}

                        else if ( (LA23_164=='\\') ) {s = 107;}

                        else if ( (LA23_164==':') ) {s = 108;}

                        else if ( (LA23_164==','||LA23_164=='['||LA23_164==']'||LA23_164=='{'||LA23_164=='}') ) {s = 109;}

                        else if ( (LA23_164=='#') ) {s = 94;}

                        else s = 104;

                         
                        input.seek(index23_164);
                        if ( s>=0 ) return s;
                        break;
                    case 139 : 
                        int LA23_130 = input.LA(1);

                         
                        int index23_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_130>='\u0000' && LA23_130<='/')||(LA23_130>=':' && LA23_130<='@')||(LA23_130>='G' && LA23_130<='`')||(LA23_130>='g' && LA23_130<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_130>='0' && LA23_130<='9')||(LA23_130>='A' && LA23_130<='F')||(LA23_130>='a' && LA23_130<='f')) && ((( currentState() == State.OUT )||(getCharPositionInLine()==0)))) {s = 146;}

                         
                        input.seek(index23_130);
                        if ( s>=0 ) return s;
                        break;
                    case 140 : 
                        int LA23_103 = input.LA(1);

                         
                        int index23_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_103>='\u0000' && LA23_103<='/')||(LA23_103>=':' && LA23_103<='@')||(LA23_103>='G' && LA23_103<='`')||(LA23_103>='g' && LA23_103<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA23_103>='0' && LA23_103<='9')||(LA23_103>='A' && LA23_103<='F')||(LA23_103>='a' && LA23_103<='f')) ) {s = 132;}

                         
                        input.seek(index23_103);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
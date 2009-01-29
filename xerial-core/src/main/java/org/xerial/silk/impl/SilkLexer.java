// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-30 00:24:59

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
    public static final int PlainSafeKey=49;
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
    public static final int PlainSafeIn=50;
    public static final int Comma=35;
    public static final int EscapeSequence=24;
    public static final int NonSpaceChar=27;
    public static final int DataLine=32;
    public static final int PlainFirst=45;
    public static final int WhiteSpace=26;
    public static final int PlainSafeOut=51;
    public static final int Question=43;
    public static final int LineComment=16;
    public static final int Colon=36;
    public static final int At=39;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=14;
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
    public static final int PlainSafeChar=48;
    public static final int ScopeIndicator=47;
    public static final int EOF=-1;
    public static final int StringChar_s=28;
    public static final int Value=9;
    public static final int RBracket=42;
    public static final int PlainSafe=52;


    private SilkLexerState lexerContext = new SilkLexerState();

    private State currentState() { return lexerContext.getCurrentState(); } 
    private void transit(Symbol token) { lexerContext.transit(token); } 
    private void resetContext() { lexerContext.reset(); }
    private boolean isKey() { return currentState() == State.IN_KEY || currentState() == State.OUT_KEY; }
    private boolean isInValue() { return currentState() == State.IN_VALUE; }
    private boolean isOutValue() { return currentState() == State.OUT_VALUE; }
    private boolean isHead() { return getCharPositionInLine() == 0; }


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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:18: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:32: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:15: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:29: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:23: ( '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:4: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:24: '\\n'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:18: ( Digit | Letter )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:21: ( UnicodeChar | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:69: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:22: ( ( StringChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:24: ( StringChar )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:24: ( StringChar )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:24: StringChar
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:7: ( '\"' s= StringChar_s '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:9: '\"' s= StringChar_s '\"'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:10: ({...}? ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:12: {...}? ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeStart", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:26: ( ' ' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:27: ' '
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:10: ({...}? ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:12: {...}? ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:26: ( WhiteSpace )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:26: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:9: ({...}? => ( WhiteSpace )* ~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:11: {...}? => ( WhiteSpace )* ~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:28: ( WhiteSpace )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:28: WhiteSpace
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:88: (~ ( '\\n' | '\\r' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:88: ~ ( '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:9: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:8: ':'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:4: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:7: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:8: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:6: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:11: '?'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | EscapeSequence | {...}? => ( ':' | '?' | '{' | '[' ) NonSpaceChar )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='?') ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>='\u0000' && LA14_1<='\b')||(LA14_1>='\u000B' && LA14_1<='\f')||(LA14_1>='\u000E' && LA14_1<='\u001F')||LA14_1=='!'||(LA14_1>='#' && LA14_1<='\uFFFF')) && (( isOutValue() ))) {
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
            else if ( (LA14_0==':'||LA14_0=='['||LA14_0=='{') && (( isOutValue() ))) {
                alt14=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:4: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:4: {...}? => ( ':' | '?' | '{' | '[' ) NonSpaceChar
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isOutValue() ");
                    }
                    if ( input.LA(1)==':'||input.LA(1)=='?'||input.LA(1)=='['||input.LA(1)=='{' ) {
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:19: ( '-' | ':' | '{' | '}' | '[' | ']' | '(' | ')' | ',' | '#' | '>' | '\\'' | '\"' | '@' | '%' | '\\\\' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:23: ( ',' | '[' | ']' | '{' | '}' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:24: ( '(' | ')' )
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

    // $ANTLR start "PlainSafeChar"
    public final void mPlainSafeChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:23: ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' '||(input.LA(1)>='\"' && input.LA(1)<='#')||(input.LA(1)>='(' && input.LA(1)<=')')||input.LA(1)=='\\' ) {
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
    // $ANTLR end "PlainSafeChar"

    // $ANTLR start "PlainSafeKey"
    public final void mPlainSafeKey() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:22: (~ ( PlainSafeChar | FlowIndicator | ':' | '>' ) | EscapeSequence )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='$' && LA15_0<='\'')||(LA15_0>='*' && LA15_0<='+')||(LA15_0>='-' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='=')||(LA15_0>='?' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:24: ~ ( PlainSafeChar | FlowIndicator | ':' | '>' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:71: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:21: (~ ( PlainSafeChar | FlowIndicator ) | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:23: ~ ( PlainSafeChar | FlowIndicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:58: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:22: (~ ( PlainSafeChar ) | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:24: ~ ( PlainSafeChar )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:43: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:212:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:213:4: {...}? => PlainSafeOut
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isOutValue() ");
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

    // $ANTLR start "PlainOneLine"
    public final void mPlainOneLine() throws RecognitionException {
        try {
            int _type = PlainOneLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:2: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:4: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:15: ( ( WhiteSpace )* PlainSafe )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\t'||LA20_0==' ') ) {
                    alt20=1;
                }
                else if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='!'||(LA20_0>='$' && LA20_0<='\'')||(LA20_0>='*' && LA20_0<='+')||(LA20_0>='-' && LA20_0<='9')||(LA20_0>=';' && LA20_0<='=')||(LA20_0>='?' && LA20_0<='Z')||(LA20_0>='^' && LA20_0<='z')||LA20_0=='|'||(LA20_0>='~' && LA20_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt20=1;
                }
                else if ( (LA20_0=='\\') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt20=1;
                }
                else if ( (LA20_0==':'||LA20_0=='>') && ((( isInValue() )||( isOutValue() )))) {
                    alt20=1;
                }
                else if ( (LA20_0==','||LA20_0=='['||LA20_0==']'||LA20_0=='{'||LA20_0=='}') && (( isOutValue() ))) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: ( WhiteSpace )* PlainSafe
            	    {
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: ( WhiteSpace )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0=='\t'||LA19_0==' ') ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop19;
            	        }
            	    } while (true);

            	    mPlainSafe(); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:11: ({...}? ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:13: {...}? ( WhiteSpace )+
            {
            if ( !(( currentState() != State.INIT )) ) {
                throw new FailedPredicateException(input, "Separation", " currentState() != State.INIT ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:47: ( WhiteSpace )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:47: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:4: ( ' ' | '\\t' )
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
        int alt22=21;
        alt22 = dfa22.predict(input);
        switch (alt22) {
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
    protected DFA22 dfa22 = new DFA22(this);
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
        "\1\10\1\11\1\17\1\15\3\uffff\1\6\1\14\1\20\1\5\1\2\1\7\1\3\1\4"+
        "\1\13\1\16\1\0\1\1\1\12}>";
    static final String[] DFA18_transitionS = {
            "\11\1\2\uffff\2\1\1\uffff\22\1\1\uffff\1\1\2\uffff\4\1\2\uffff"+
            "\2\1\1\4\15\1\1\3\3\1\1\3\34\1\1\4\1\2\1\4\35\1\1\4\1\1\1\4"+
            "\uff82\1",
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
            return "210:10: fragment PlainSafe : ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut );";
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
                        if ( ((LA18_17>='0' && LA18_17<='9')||(LA18_17>='A' && LA18_17<='F')||(LA18_17>='a' && LA18_17<='f')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 18;}

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_18 = input.LA(1);

                         
                        int index18_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_18>='0' && LA18_18<='9')||(LA18_18>='A' && LA18_18<='F')||(LA18_18>='a' && LA18_18<='f')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 19;}

                         
                        input.seek(index18_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_7 = input.LA(1);

                         
                        int index18_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_0 = input.LA(1);

                         
                        int index18_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='$' && LA18_0<='\'')||(LA18_0>='*' && LA18_0<='+')||(LA18_0>='-' && LA18_0<='9')||(LA18_0>=';' && LA18_0<='=')||(LA18_0>='?' && LA18_0<='Z')||(LA18_0>='^' && LA18_0<='z')||LA18_0=='|'||(LA18_0>='~' && LA18_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 1;}

                        else if ( (LA18_0=='\\') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 2;}

                        else if ( (LA18_0==':'||LA18_0=='>') && ((( isInValue() )||( isOutValue() )))) {s = 3;}

                        else if ( (LA18_0==','||LA18_0=='['||LA18_0==']'||LA18_0=='{'||LA18_0=='}') && (( isOutValue() ))) {s = 4;}

                         
                        input.seek(index18_0);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_19 = input.LA(1);

                         
                        int index18_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_19);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_15>='0' && LA18_15<='9')||(LA18_15>='A' && LA18_15<='F')||(LA18_15>='a' && LA18_15<='f')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 16;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_16 = input.LA(1);

                         
                        int index18_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_16>='0' && LA18_16<='9')||(LA18_16>='A' && LA18_16<='F')||(LA18_16>='a' && LA18_16<='f')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 17;}

                         
                        input.seek(index18_16);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_2 = input.LA(1);

                         
                        int index18_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_2=='\"') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 7;}

                        else if ( (LA18_2=='\\') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 8;}

                        else if ( (LA18_2=='/') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 9;}

                        else if ( (LA18_2=='b') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 10;}

                        else if ( (LA18_2=='f') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 11;}

                        else if ( (LA18_2=='n') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 12;}

                        else if ( (LA18_2=='r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 13;}

                        else if ( (LA18_2=='t') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 14;}

                        else if ( (LA18_2=='u') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 15;}

                         
                        input.seek(index18_2);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 5;}

                        else if ( (( isInValue() )) ) {s = 6;}

                        else if ( (( isOutValue() )) ) {s = 4;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\3\uffff\1\31\1\32\1\uffff\1\36\1\uffff\1\36\1\42\1\43\1\44\1\47"+
        "\1\50\1\51\1\57\1\60\1\61\1\62\1\63\1\70\3\uffff\1\102\4\uffff\1"+
        "\115\2\uffff\2\116\3\uffff\1\120\5\uffff\1\70\1\uffff\2\70\5\uffff"+
        "\1\150\1\uffff\2\150\1\uffff\10\70\21\uffff\1\120\1\uffff\12\120"+
        "\1\uffff\10\70\3\uffff\1\150\1\uffff\12\150\3\uffff\10\120\3\uffff"+
        "\10\150\20\uffff\1\70\2\uffff\1\120\1\70\1\uffff\1\150\1\120\1\150";
    static final String DFA22_eofS =
        "\u00a5\uffff";
    static final String DFA22_minS =
        "\1\0\2\uffff\1\12\3\0\1\uffff\17\0\1\uffff\7\0\1\uffff\2\0\3\uffff"+
        "\2\0\3\uffff\5\0\5\uffff\4\0\1\uffff\12\0\1\uffff\11\0\4\uffff\27"+
        "\0\1\uffff\74\0";
    static final String DFA22_maxS =
        "\1\uffff\2\uffff\1\12\1\0\2\uffff\1\uffff\17\uffff\1\uffff\3\0"+
        "\3\uffff\1\0\1\uffff\2\uffff\3\uffff\2\uffff\3\uffff\5\uffff\5\uffff"+
        "\4\uffff\1\uffff\11\uffff\1\0\1\uffff\11\uffff\4\uffff\27\uffff"+
        "\1\uffff\74\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\5\17\uffff\1\7\7\uffff\1\6\2\uffff\1"+
        "\10\1\11\1\12\2\uffff\1\13\1\14\1\15\5\uffff\1\16\1\17\1\20\1\21"+
        "\1\22\4\uffff\1\23\12\uffff\1\3\11\uffff\1\4\1\24\1\25\1\23\27\uffff"+
        "\1\23\74\uffff";
    static final String DFA22_specialS =
        "\1\151\4\uffff\1\56\1\105\1\uffff\1\176\1\146\1\u0086\1\110\1\141"+
        "\1\16\1\140\1\12\1\161\1\132\1\26\1\163\1\156\1\30\1\23\2\uffff"+
        "\1\60\1\57\1\u0087\1\64\1\171\1\55\1\uffff\1\173\1\41\3\uffff\1"+
        "\135\1\u0085\3\uffff\1\144\1\153\1\4\1\53\1\63\5\uffff\1\147\1\24"+
        "\1\72\1\u008a\1\uffff\1\66\1\77\1\104\1\10\1\162\1\117\1\143\1\3"+
        "\1\67\1\61\1\uffff\1\106\1\51\1\166\1\116\1\107\1\114\1\134\1\164"+
        "\1\125\4\uffff\1\145\1\154\1\5\1\54\1\65\1\u0082\1\111\1\172\1\17"+
        "\1\150\1\133\1\62\1\76\1\70\1\52\1\33\1\160\1\15\1\1\1\u0084\1\103"+
        "\1\7\1\u0089\1\uffff\1\27\1\124\1\11\1\126\1\71\1\25\1\174\1\127"+
        "\1\100\1\35\1\170\1\165\1\152\1\36\1\122\1\130\1\50\1\32\1\157\1"+
        "\14\1\0\1\u0083\1\102\1\6\1\u0088\1\121\1\75\1\47\1\115\1\155\1"+
        "\20\1\167\1\31\1\142\1\u0081\1\46\1\131\1\45\1\175\1\74\1\44\1\22"+
        "\1\73\1\112\1\40\1\2\1\21\1\37\1\137\1\13\1\43\1\123\1\34\1\136"+
        "\1\113\1\u0080\1\120\1\101\1\177\1\42}>";
    static final String[] DFA22_transitionS = {
            "\11\24\1\10\1\4\2\24\1\3\22\24\1\6\1\24\1\5\1\1\1\24\1\2\1"+
            "\24\1\27\1\11\1\12\1\16\1\20\1\13\1\7\14\24\1\14\3\24\1\15\1"+
            "\23\1\17\32\24\1\21\1\25\1\22\35\24\1\26\1\24\1\27\uff82\24",
            "",
            "",
            "\1\30",
            "\1\uffff",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\11\27\1\41\1\37\2\27\1\37\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\7\uffd2\27",
            "",
            "\11\27\1\41\1\37\2\27\1\37\22\27\1\41\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\uffd2\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\45\2\27\2\45\1\27\22\45\1\27\1\45\1\27\71\45\1\46\uffa3"+
            "\45",
            "\0\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\0\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\45\2\27\2\45\1\27\22\45\1\27\1\45\1\27\71\45\1\46\uffa3"+
            "\45",
            "\0\27",
            "\11\64\1\52\1\27\2\64\1\27\22\64\1\52\1\64\1\27\1\45\4\64"+
            "\2\45\2\64\1\67\15\64\1\66\3\64\1\66\34\64\1\67\1\65\1\67\35"+
            "\64\1\67\1\64\1\67\uff82\64",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\42\27\1\71\14\27\1\73\54\27\1\72\5\27\1\74\3\27\1\75\7\27"+
            "\1\76\3\27\1\77\1\27\1\100\1\101\uff8a\27",
            "\11\45\2\27\2\45\1\27\22\45\1\27\1\45\1\27\71\45\1\46\uffa3"+
            "\45",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\42\27\1\104\14\27\1\106\54\27\1\105\5\27\1\107\3\27\1\110"+
            "\7\27\1\111\3\27\1\112\1\27\1\113\1\114\uff8a\27",
            "\0\27",
            "\1\uffff",
            "",
            "\11\27\1\41\1\37\2\27\1\37\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\7\uffd2\27",
            "\11\27\1\41\1\37\2\27\1\37\22\27\1\41\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\uffd2\27",
            "",
            "",
            "",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\42\27\1\126\14\27\1\130\54\27\1\127\5\27\1\131\3\27\1\132"+
            "\7\27\1\133\3\27\1\134\1\27\1\135\1\136\uff8a\27",
            "",
            "",
            "",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\42\27\1\137\14\27\1\141\54\27\1\140\5\27\1\142\3\27\1\143"+
            "\7\27\1\144\3\27\1\145\1\27\1\146\1\147\uff8a\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "",
            "",
            "",
            "",
            "",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\42\27\1\156\14\27\1\160\54\27\1\157\5\27\1\161\3\27\1\162"+
            "\7\27\1\163\3\27\1\164\1\27\1\165\1\166\uff8a\27",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\60\27\12\167\7\27\6\167\32\27\6\167\uff99\27",
            "\1\uffff",
            "",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\60\27\12\170\7\27\6\170\32\27\6\170\uff99\27",
            "",
            "",
            "",
            "",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\42\27\1\171\14\27\1\173\54\27\1\172\5\27\1\174\3\27\1\175"+
            "\7\27\1\176\3\27\1\177\1\27\1\u0080\1\u0081\uff8a\27",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\60\27\12\u0082\7\27\6\u0082\32\27\6\u0082\uff99\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\60\27\12\u0083\7\27\6\u0083\32\27\6\u0083\uff99\27",
            "",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\42\27\1\u0084\14\27\1\u0086\54\27\1\u0085\5\27\1\u0087\3"+
            "\27\1\u0088\7\27\1\u0089\3\27\1\u008a\1\27\1\u008b\1\u008c\uff8a"+
            "\27",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\60\27\12\u008d\7\27\6\u008d\32\27\6\u008d\uff99\27",
            "\60\27\12\u008e\7\27\6\u008e\32\27\6\u008e\uff99\27",
            "\60\27\12\u008f\7\27\6\u008f\32\27\6\u008f\uff99\27",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\60\27\12\u0090\7\27\6\u0090\32\27\6\u0090\uff99\27",
            "\60\27\12\u0091\7\27\6\u0091\32\27\6\u0091\uff99\27",
            "\60\27\12\u0092\7\27\6\u0092\32\27\6\u0092\uff99\27",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\60\27\12\u0093\7\27\6\u0093\32\27\6\u0093\uff99\27",
            "\60\27\12\u0094\7\27\6\u0094\32\27\6\u0094\uff99\27",
            "\60\27\12\u0095\7\27\6\u0095\32\27\6\u0095\uff99\27",
            "\60\27\12\u0096\7\27\6\u0096\32\27\6\u0096\uff99\27",
            "\60\27\12\u0097\7\27\6\u0097\32\27\6\u0097\uff99\27",
            "\60\27\12\u0098\7\27\6\u0098\32\27\6\u0098\uff99\27",
            "\60\27\12\u0099\7\27\6\u0099\32\27\6\u0099\uff99\27",
            "\60\27\12\u009a\7\27\6\u009a\32\27\6\u009a\uff99\27",
            "\60\27\12\u009b\7\27\6\u009b\32\27\6\u009b\uff99\27",
            "\60\27\12\u009c\7\27\6\u009c\32\27\6\u009c\uff99\27",
            "\60\27\12\u009d\7\27\6\u009d\32\27\6\u009d\uff99\27",
            "\60\27\12\u009e\7\27\6\u009e\32\27\6\u009e\uff99\27",
            "\60\27\12\u009f\7\27\6\u009f\32\27\6\u009f\uff99\27",
            "\60\27\12\u00a0\7\27\6\u00a0\32\27\6\u00a0\uff99\27",
            "\60\27\12\u00a1\7\27\6\u00a1\32\27\6\u00a1\uff99\27",
            "\60\27\12\u00a2\7\27\6\u00a2\32\27\6\u00a2\uff99\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\12\33\1\27\2\33\1\27\24\33\1\35\71\33\1\34\uffa3\33",
            "\60\27\12\u00a3\7\27\6\u00a3\32\27\6\u00a3\uff99\27",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\2\53\1\56\15\53\1\55\3\53\1\55\34\53\1\56\1\54\1\56\35\53\1"+
            "\56\1\53\1\56\uff82\53",
            "\60\27\12\u00a4\7\27\6\u00a4\32\27\6\u00a4\uff99\27",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\27\2\122\1\125\15\122\1\124\3\122\1\124\34\122\1\125\1\123"+
            "\1\125\35\122\1\125\1\122\1\125\uff82\122",
            "\11\152\1\151\1\27\2\152\1\27\22\152\1\151\1\152\2\27\4\152"+
            "\2\27\2\152\1\155\15\152\1\154\3\152\1\154\34\152\1\155\1\153"+
            "\1\155\35\152\1\155\1\152\1\155\uff82\152"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | String | NodeStart | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | PlainOneLine | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_125 = input.LA(1);

                         
                        int index22_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_125=='\t'||LA22_125==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_125>='\u0000' && LA22_125<='\b')||(LA22_125>='\u000B' && LA22_125<='\f')||(LA22_125>='\u000E' && LA22_125<='\u001F')||LA22_125=='!'||(LA22_125>='$' && LA22_125<='\'')||(LA22_125>='*' && LA22_125<='+')||(LA22_125>='-' && LA22_125<='9')||(LA22_125>=';' && LA22_125<='=')||(LA22_125>='?' && LA22_125<='Z')||(LA22_125>='^' && LA22_125<='z')||LA22_125=='|'||(LA22_125>='~' && LA22_125<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_125=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_125==':'||LA22_125=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_125==','||LA22_125=='['||LA22_125==']'||LA22_125=='{'||LA22_125=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_125=='\n'||LA22_125=='\r'||(LA22_125>='\"' && LA22_125<='#')||(LA22_125>='(' && LA22_125<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_125);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_99 = input.LA(1);

                         
                        int index22_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_99=='\t'||LA22_99==' ') ) {s = 42;}

                        else if ( ((LA22_99>='\u0000' && LA22_99<='\b')||(LA22_99>='\u000B' && LA22_99<='\f')||(LA22_99>='\u000E' && LA22_99<='\u001F')||LA22_99=='!'||(LA22_99>='$' && LA22_99<='\'')||(LA22_99>='*' && LA22_99<='+')||(LA22_99>='-' && LA22_99<='9')||(LA22_99>=';' && LA22_99<='=')||(LA22_99>='?' && LA22_99<='Z')||(LA22_99>='^' && LA22_99<='z')||LA22_99=='|'||(LA22_99>='~' && LA22_99<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_99=='\\') ) {s = 44;}

                        else if ( (LA22_99==':'||LA22_99=='>') ) {s = 45;}

                        else if ( (LA22_99==','||LA22_99=='['||LA22_99==']'||LA22_99=='{'||LA22_99=='}') ) {s = 46;}

                        else if ( (LA22_99=='\n'||LA22_99=='\r'||(LA22_99>='\"' && LA22_99<='#')||(LA22_99>='(' && LA22_99<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_99);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_150 = input.LA(1);

                         
                        int index22_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_150>='0' && LA22_150<='9')||(LA22_150>='A' && LA22_150<='F')||(LA22_150>='a' && LA22_150<='f')) ) {s = 157;}

                        else if ( ((LA22_150>='\u0000' && LA22_150<='/')||(LA22_150>=':' && LA22_150<='@')||(LA22_150>='G' && LA22_150<='`')||(LA22_150>='g' && LA22_150<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_150);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_64 = input.LA(1);

                         
                        int index22_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_64=='\t'||LA22_64==' ') ) {s = 42;}

                        else if ( ((LA22_64>='\u0000' && LA22_64<='\b')||(LA22_64>='\u000B' && LA22_64<='\f')||(LA22_64>='\u000E' && LA22_64<='\u001F')||LA22_64=='!'||(LA22_64>='$' && LA22_64<='\'')||(LA22_64>='*' && LA22_64<='+')||(LA22_64>='-' && LA22_64<='9')||(LA22_64>=';' && LA22_64<='=')||(LA22_64>='?' && LA22_64<='Z')||(LA22_64>='^' && LA22_64<='z')||LA22_64=='|'||(LA22_64>='~' && LA22_64<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_64=='\\') ) {s = 44;}

                        else if ( (LA22_64==':'||LA22_64=='>') ) {s = 45;}

                        else if ( (LA22_64==','||LA22_64=='['||LA22_64==']'||LA22_64=='{'||LA22_64=='}') ) {s = 46;}

                        else if ( (LA22_64=='\n'||LA22_64=='\r'||(LA22_64>='\"' && LA22_64<='#')||(LA22_64>='(' && LA22_64<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_64);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_44 = input.LA(1);

                         
                        int index22_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_44=='\"') ) {s = 95;}

                        else if ( (LA22_44=='\\') ) {s = 96;}

                        else if ( (LA22_44=='/') ) {s = 97;}

                        else if ( (LA22_44=='b') ) {s = 98;}

                        else if ( (LA22_44=='f') ) {s = 99;}

                        else if ( (LA22_44=='n') ) {s = 100;}

                        else if ( (LA22_44=='r') ) {s = 101;}

                        else if ( (LA22_44=='t') ) {s = 102;}

                        else if ( (LA22_44=='u') ) {s = 103;}

                        else if ( ((LA22_44>='\u0000' && LA22_44<='!')||(LA22_44>='#' && LA22_44<='.')||(LA22_44>='0' && LA22_44<='[')||(LA22_44>=']' && LA22_44<='a')||(LA22_44>='c' && LA22_44<='e')||(LA22_44>='g' && LA22_44<='m')||(LA22_44>='o' && LA22_44<='q')||LA22_44=='s'||(LA22_44>='v' && LA22_44<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_44);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_83 = input.LA(1);

                         
                        int index22_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_83=='\"') && ((( isOutValue() )||( isHead() )))) {s = 121;}

                        else if ( (LA22_83=='\\') && ((( isOutValue() )||( isHead() )))) {s = 122;}

                        else if ( (LA22_83=='/') && ((( isOutValue() )||( isHead() )))) {s = 123;}

                        else if ( (LA22_83=='b') && ((( isOutValue() )||( isHead() )))) {s = 124;}

                        else if ( (LA22_83=='f') && ((( isOutValue() )||( isHead() )))) {s = 125;}

                        else if ( (LA22_83=='n') && ((( isOutValue() )||( isHead() )))) {s = 126;}

                        else if ( (LA22_83=='r') && ((( isOutValue() )||( isHead() )))) {s = 127;}

                        else if ( (LA22_83=='t') && ((( isOutValue() )||( isHead() )))) {s = 128;}

                        else if ( (LA22_83=='u') && ((( isOutValue() )||( isHead() )))) {s = 129;}

                        else if ( ((LA22_83>='\u0000' && LA22_83<='!')||(LA22_83>='#' && LA22_83<='.')||(LA22_83>='0' && LA22_83<='[')||(LA22_83>=']' && LA22_83<='a')||(LA22_83>='c' && LA22_83<='e')||(LA22_83>='g' && LA22_83<='m')||(LA22_83>='o' && LA22_83<='q')||LA22_83=='s'||(LA22_83>='v' && LA22_83<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_83);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_128 = input.LA(1);

                         
                        int index22_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_128=='\t'||LA22_128==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_128>='\u0000' && LA22_128<='\b')||(LA22_128>='\u000B' && LA22_128<='\f')||(LA22_128>='\u000E' && LA22_128<='\u001F')||LA22_128=='!'||(LA22_128>='$' && LA22_128<='\'')||(LA22_128>='*' && LA22_128<='+')||(LA22_128>='-' && LA22_128<='9')||(LA22_128>=';' && LA22_128<='=')||(LA22_128>='?' && LA22_128<='Z')||(LA22_128>='^' && LA22_128<='z')||LA22_128=='|'||(LA22_128>='~' && LA22_128<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_128=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_128==':'||LA22_128=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_128==','||LA22_128=='['||LA22_128==']'||LA22_128=='{'||LA22_128=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_128=='\n'||LA22_128=='\r'||(LA22_128>='\"' && LA22_128<='#')||(LA22_128>='(' && LA22_128<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_128);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_102 = input.LA(1);

                         
                        int index22_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_102=='\t'||LA22_102==' ') ) {s = 42;}

                        else if ( ((LA22_102>='\u0000' && LA22_102<='\b')||(LA22_102>='\u000B' && LA22_102<='\f')||(LA22_102>='\u000E' && LA22_102<='\u001F')||LA22_102=='!'||(LA22_102>='$' && LA22_102<='\'')||(LA22_102>='*' && LA22_102<='+')||(LA22_102>='-' && LA22_102<='9')||(LA22_102>=';' && LA22_102<='=')||(LA22_102>='?' && LA22_102<='Z')||(LA22_102>='^' && LA22_102<='z')||LA22_102=='|'||(LA22_102>='~' && LA22_102<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_102=='\\') ) {s = 44;}

                        else if ( (LA22_102==':'||LA22_102=='>') ) {s = 45;}

                        else if ( (LA22_102==','||LA22_102=='['||LA22_102==']'||LA22_102=='{'||LA22_102=='}') ) {s = 46;}

                        else if ( (LA22_102=='\n'||LA22_102=='\r'||(LA22_102>='\"' && LA22_102<='#')||(LA22_102>='(' && LA22_102<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_102);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_60 = input.LA(1);

                         
                        int index22_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_60=='\t'||LA22_60==' ') ) {s = 42;}

                        else if ( ((LA22_60>='\u0000' && LA22_60<='\b')||(LA22_60>='\u000B' && LA22_60<='\f')||(LA22_60>='\u000E' && LA22_60<='\u001F')||LA22_60=='!'||(LA22_60>='$' && LA22_60<='\'')||(LA22_60>='*' && LA22_60<='+')||(LA22_60>='-' && LA22_60<='9')||(LA22_60>=';' && LA22_60<='=')||(LA22_60>='?' && LA22_60<='Z')||(LA22_60>='^' && LA22_60<='z')||LA22_60=='|'||(LA22_60>='~' && LA22_60<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_60=='\\') ) {s = 44;}

                        else if ( (LA22_60==':'||LA22_60=='>') ) {s = 45;}

                        else if ( (LA22_60==','||LA22_60=='['||LA22_60==']'||LA22_60=='{'||LA22_60=='}') ) {s = 46;}

                        else if ( (LA22_60=='\n'||LA22_60=='\r'||(LA22_60>='\"' && LA22_60<='#')||(LA22_60>='(' && LA22_60<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_60);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_107 = input.LA(1);

                         
                        int index22_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_107=='\"') ) {s = 132;}

                        else if ( (LA22_107=='\\') ) {s = 133;}

                        else if ( (LA22_107=='/') ) {s = 134;}

                        else if ( (LA22_107=='b') ) {s = 135;}

                        else if ( (LA22_107=='f') ) {s = 136;}

                        else if ( (LA22_107=='n') ) {s = 137;}

                        else if ( (LA22_107=='r') ) {s = 138;}

                        else if ( (LA22_107=='t') ) {s = 139;}

                        else if ( (LA22_107=='u') ) {s = 140;}

                        else if ( ((LA22_107>='\u0000' && LA22_107<='!')||(LA22_107>='#' && LA22_107<='.')||(LA22_107>='0' && LA22_107<='[')||(LA22_107>=']' && LA22_107<='a')||(LA22_107>='c' && LA22_107<='e')||(LA22_107>='g' && LA22_107<='m')||(LA22_107>='o' && LA22_107<='q')||LA22_107=='s'||(LA22_107>='v' && LA22_107<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_107);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 47;

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_154 = input.LA(1);

                         
                        int index22_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_154>='\u0000' && LA22_154<='/')||(LA22_154>=':' && LA22_154<='@')||(LA22_154>='G' && LA22_154<='`')||(LA22_154>='g' && LA22_154<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_154>='0' && LA22_154<='9')||(LA22_154>='A' && LA22_154<='F')||(LA22_154>='a' && LA22_154<='f')) ) {s = 161;}

                         
                        input.seek(index22_154);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_124 = input.LA(1);

                         
                        int index22_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_124=='\t'||LA22_124==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_124>='\u0000' && LA22_124<='\b')||(LA22_124>='\u000B' && LA22_124<='\f')||(LA22_124>='\u000E' && LA22_124<='\u001F')||LA22_124=='!'||(LA22_124>='$' && LA22_124<='\'')||(LA22_124>='*' && LA22_124<='+')||(LA22_124>='-' && LA22_124<='9')||(LA22_124>=';' && LA22_124<='=')||(LA22_124>='?' && LA22_124<='Z')||(LA22_124>='^' && LA22_124<='z')||LA22_124=='|'||(LA22_124>='~' && LA22_124<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_124=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_124==':'||LA22_124=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_124==','||LA22_124=='['||LA22_124==']'||LA22_124=='{'||LA22_124=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_124=='\n'||LA22_124=='\r'||(LA22_124>='\"' && LA22_124<='#')||(LA22_124>='(' && LA22_124<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_124);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_98 = input.LA(1);

                         
                        int index22_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_98=='\t'||LA22_98==' ') ) {s = 42;}

                        else if ( ((LA22_98>='\u0000' && LA22_98<='\b')||(LA22_98>='\u000B' && LA22_98<='\f')||(LA22_98>='\u000E' && LA22_98<='\u001F')||LA22_98=='!'||(LA22_98>='$' && LA22_98<='\'')||(LA22_98>='*' && LA22_98<='+')||(LA22_98>='-' && LA22_98<='9')||(LA22_98>=';' && LA22_98<='=')||(LA22_98>='?' && LA22_98<='Z')||(LA22_98>='^' && LA22_98<='z')||LA22_98=='|'||(LA22_98>='~' && LA22_98<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_98=='\\') ) {s = 44;}

                        else if ( (LA22_98==':'||LA22_98=='>') ) {s = 45;}

                        else if ( (LA22_98==','||LA22_98=='['||LA22_98==']'||LA22_98=='{'||LA22_98=='}') ) {s = 46;}

                        else if ( (LA22_98=='\n'||LA22_98=='\r'||(LA22_98>='\"' && LA22_98<='#')||(LA22_98>='(' && LA22_98<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_98);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_13>='\u0000' && LA22_13<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 40;

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_89=='\t'||LA22_89==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_89>='\u0000' && LA22_89<='\b')||(LA22_89>='\u000B' && LA22_89<='\f')||(LA22_89>='\u000E' && LA22_89<='\u001F')||LA22_89=='!'||(LA22_89>='$' && LA22_89<='\'')||(LA22_89>='*' && LA22_89<='+')||(LA22_89>='-' && LA22_89<='9')||(LA22_89>=';' && LA22_89<='=')||(LA22_89>='?' && LA22_89<='Z')||(LA22_89>='^' && LA22_89<='z')||LA22_89=='|'||(LA22_89>='~' && LA22_89<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_89=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_89==':'||LA22_89=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_89==','||LA22_89=='['||LA22_89==']'||LA22_89=='{'||LA22_89=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_89=='\n'||LA22_89=='\r'||(LA22_89>='\"' && LA22_89<='#')||(LA22_89>='(' && LA22_89<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_135 = input.LA(1);

                         
                        int index22_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_135=='\t'||LA22_135==' ') ) {s = 105;}

                        else if ( ((LA22_135>='\u0000' && LA22_135<='\b')||(LA22_135>='\u000B' && LA22_135<='\f')||(LA22_135>='\u000E' && LA22_135<='\u001F')||LA22_135=='!'||(LA22_135>='$' && LA22_135<='\'')||(LA22_135>='*' && LA22_135<='+')||(LA22_135>='-' && LA22_135<='9')||(LA22_135>=';' && LA22_135<='=')||(LA22_135>='?' && LA22_135<='Z')||(LA22_135>='^' && LA22_135<='z')||LA22_135=='|'||(LA22_135>='~' && LA22_135<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_135=='\\') ) {s = 107;}

                        else if ( (LA22_135==':'||LA22_135=='>') ) {s = 108;}

                        else if ( (LA22_135==','||LA22_135=='['||LA22_135==']'||LA22_135=='{'||LA22_135=='}') ) {s = 109;}

                        else if ( (LA22_135=='\n'||LA22_135=='\r'||(LA22_135>='\"' && LA22_135<='#')||(LA22_135>='(' && LA22_135<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_135);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_151 = input.LA(1);

                         
                        int index22_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_151>='\u0000' && LA22_151<='/')||(LA22_151>=':' && LA22_151<='@')||(LA22_151>='G' && LA22_151<='`')||(LA22_151>='g' && LA22_151<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_151>='0' && LA22_151<='9')||(LA22_151>='A' && LA22_151<='F')||(LA22_151>='a' && LA22_151<='f')) && ((( isOutValue() )||( isHead() )))) {s = 158;}

                         
                        input.seek(index22_151);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_146 = input.LA(1);

                         
                        int index22_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_146>='\u0000' && LA22_146<='/')||(LA22_146>=':' && LA22_146<='@')||(LA22_146>='G' && LA22_146<='`')||(LA22_146>='g' && LA22_146<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_146>='0' && LA22_146<='9')||(LA22_146>='A' && LA22_146<='F')||(LA22_146>='a' && LA22_146<='f')) ) {s = 153;}

                         
                        input.seek(index22_146);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_22 = input.LA(1);

                         
                        int index22_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_22>='\u0000' && LA22_22<='\b')||(LA22_22>='\u000B' && LA22_22<='\f')||(LA22_22>='\u000E' && LA22_22<='\u001F')||LA22_22=='!'||(LA22_22>='#' && LA22_22<='[')||(LA22_22>=']' && LA22_22<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 37;}

                        else if ( ((LA22_22>='\t' && LA22_22<='\n')||LA22_22=='\r'||LA22_22==' '||LA22_22=='\"') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_22=='\\') && ((( isOutValue() )||( isHead() )))) {s = 38;}

                         
                        input.seek(index22_22);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_53 = input.LA(1);

                         
                        int index22_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_53=='\"') ) {s = 110;}

                        else if ( (LA22_53=='\\') ) {s = 111;}

                        else if ( (LA22_53=='/') ) {s = 112;}

                        else if ( (LA22_53=='b') ) {s = 113;}

                        else if ( (LA22_53=='f') ) {s = 114;}

                        else if ( (LA22_53=='n') ) {s = 115;}

                        else if ( (LA22_53=='r') ) {s = 116;}

                        else if ( (LA22_53=='t') ) {s = 117;}

                        else if ( (LA22_53=='u') ) {s = 118;}

                        else if ( ((LA22_53>='\u0000' && LA22_53<='!')||(LA22_53>='#' && LA22_53<='.')||(LA22_53>='0' && LA22_53<='[')||(LA22_53>=']' && LA22_53<='a')||(LA22_53>='c' && LA22_53<='e')||(LA22_53>='g' && LA22_53<='m')||(LA22_53>='o' && LA22_53<='q')||LA22_53=='s'||(LA22_53>='v' && LA22_53<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_53);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_110 = input.LA(1);

                         
                        int index22_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_110=='\t'||LA22_110==' ') ) {s = 105;}

                        else if ( ((LA22_110>='\u0000' && LA22_110<='\b')||(LA22_110>='\u000B' && LA22_110<='\f')||(LA22_110>='\u000E' && LA22_110<='\u001F')||LA22_110=='!'||(LA22_110>='$' && LA22_110<='\'')||(LA22_110>='*' && LA22_110<='+')||(LA22_110>='-' && LA22_110<='9')||(LA22_110>=';' && LA22_110<='=')||(LA22_110>='?' && LA22_110<='Z')||(LA22_110>='^' && LA22_110<='z')||LA22_110=='|'||(LA22_110>='~' && LA22_110<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_110=='\\') ) {s = 107;}

                        else if ( (LA22_110==':'||LA22_110=='>') ) {s = 108;}

                        else if ( (LA22_110==','||LA22_110=='['||LA22_110==']'||LA22_110=='{'||LA22_110=='}') ) {s = 109;}

                        else if ( (LA22_110=='\n'||LA22_110=='\r'||(LA22_110>='\"' && LA22_110<='#')||(LA22_110>='(' && LA22_110<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_110);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_18 = input.LA(1);

                         
                        int index22_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_18>='\u0000' && LA22_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 50;

                         
                        input.seek(index22_18);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_105 = input.LA(1);

                         
                        int index22_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_105>='\u0000' && LA22_105<='\b')||(LA22_105>='\u000B' && LA22_105<='\f')||(LA22_105>='\u000E' && LA22_105<='\u001F')||LA22_105=='!'||(LA22_105>='$' && LA22_105<='\'')||(LA22_105>='*' && LA22_105<='+')||(LA22_105>='-' && LA22_105<='9')||(LA22_105>=';' && LA22_105<='=')||(LA22_105>='?' && LA22_105<='Z')||(LA22_105>='^' && LA22_105<='z')||LA22_105=='|'||(LA22_105>='~' && LA22_105<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_105=='\\') ) {s = 107;}

                        else if ( (LA22_105==':'||LA22_105=='>') ) {s = 108;}

                        else if ( (LA22_105==','||LA22_105=='['||LA22_105==']'||LA22_105=='{'||LA22_105=='}') ) {s = 109;}

                        else if ( (LA22_105=='\t'||LA22_105==' ') ) {s = 105;}

                        else if ( (LA22_105=='\n'||LA22_105=='\r'||(LA22_105>='\"' && LA22_105<='#')||(LA22_105>='(' && LA22_105<=')')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_105);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_21=='\"') ) {s = 57;}

                        else if ( ((LA22_21>='\u0000' && LA22_21<='!')||(LA22_21>='#' && LA22_21<='.')||(LA22_21>='0' && LA22_21<='[')||(LA22_21>=']' && LA22_21<='a')||(LA22_21>='c' && LA22_21<='e')||(LA22_21>='g' && LA22_21<='m')||(LA22_21>='o' && LA22_21<='q')||LA22_21=='s'||(LA22_21>='v' && LA22_21<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_21=='\\') ) {s = 58;}

                        else if ( (LA22_21=='/') ) {s = 59;}

                        else if ( (LA22_21=='b') ) {s = 60;}

                        else if ( (LA22_21=='f') ) {s = 61;}

                        else if ( (LA22_21=='n') ) {s = 62;}

                        else if ( (LA22_21=='r') ) {s = 63;}

                        else if ( (LA22_21=='t') ) {s = 64;}

                        else if ( (LA22_21=='u') ) {s = 65;}

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_137 = input.LA(1);

                         
                        int index22_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_137=='\n'||LA22_137=='\r'||(LA22_137>='\"' && LA22_137<='#')||(LA22_137>='(' && LA22_137<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_137=='\t'||LA22_137==' ') ) {s = 105;}

                        else if ( ((LA22_137>='\u0000' && LA22_137<='\b')||(LA22_137>='\u000B' && LA22_137<='\f')||(LA22_137>='\u000E' && LA22_137<='\u001F')||LA22_137=='!'||(LA22_137>='$' && LA22_137<='\'')||(LA22_137>='*' && LA22_137<='+')||(LA22_137>='-' && LA22_137<='9')||(LA22_137>=';' && LA22_137<='=')||(LA22_137>='?' && LA22_137<='Z')||(LA22_137>='^' && LA22_137<='z')||LA22_137=='|'||(LA22_137>='~' && LA22_137<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_137=='\\') ) {s = 107;}

                        else if ( (LA22_137==':'||LA22_137=='>') ) {s = 108;}

                        else if ( (LA22_137==','||LA22_137=='['||LA22_137==']'||LA22_137=='{'||LA22_137=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index22_137);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_122 = input.LA(1);

                         
                        int index22_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_122=='\t'||LA22_122==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_122>='\u0000' && LA22_122<='\b')||(LA22_122>='\u000B' && LA22_122<='\f')||(LA22_122>='\u000E' && LA22_122<='\u001F')||LA22_122=='!'||(LA22_122>='$' && LA22_122<='\'')||(LA22_122>='*' && LA22_122<='+')||(LA22_122>='-' && LA22_122<='9')||(LA22_122>=';' && LA22_122<='=')||(LA22_122>='?' && LA22_122<='Z')||(LA22_122>='^' && LA22_122<='z')||LA22_122=='|'||(LA22_122>='~' && LA22_122<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_122=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_122==':'||LA22_122=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_122==','||LA22_122=='['||LA22_122==']'||LA22_122=='{'||LA22_122=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_122=='\n'||LA22_122=='\r'||(LA22_122>='\"' && LA22_122<='#')||(LA22_122>='(' && LA22_122<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_122);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_96 = input.LA(1);

                         
                        int index22_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_96=='\t'||LA22_96==' ') ) {s = 42;}

                        else if ( ((LA22_96>='\u0000' && LA22_96<='\b')||(LA22_96>='\u000B' && LA22_96<='\f')||(LA22_96>='\u000E' && LA22_96<='\u001F')||LA22_96=='!'||(LA22_96>='$' && LA22_96<='\'')||(LA22_96>='*' && LA22_96<='+')||(LA22_96>='-' && LA22_96<='9')||(LA22_96>=';' && LA22_96<='=')||(LA22_96>='?' && LA22_96<='Z')||(LA22_96>='^' && LA22_96<='z')||LA22_96=='|'||(LA22_96>='~' && LA22_96<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_96=='\\') ) {s = 44;}

                        else if ( (LA22_96==':'||LA22_96=='>') ) {s = 45;}

                        else if ( (LA22_96==','||LA22_96=='['||LA22_96==']'||LA22_96=='{'||LA22_96=='}') ) {s = 46;}

                        else if ( (LA22_96=='\n'||LA22_96=='\r'||(LA22_96>='\"' && LA22_96<='#')||(LA22_96>='(' && LA22_96<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_96);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_157 = input.LA(1);

                         
                        int index22_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_157=='\"') ) {s = 29;}

                        else if ( ((LA22_157>='\u0000' && LA22_157<='\t')||(LA22_157>='\u000B' && LA22_157<='\f')||(LA22_157>='\u000E' && LA22_157<='!')||(LA22_157>='#' && LA22_157<='[')||(LA22_157>=']' && LA22_157<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_157=='\\') ) {s = 28;}

                        else if ( (LA22_157=='\n'||LA22_157=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_157);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_114=='\t'||LA22_114==' ') ) {s = 105;}

                        else if ( ((LA22_114>='\u0000' && LA22_114<='\b')||(LA22_114>='\u000B' && LA22_114<='\f')||(LA22_114>='\u000E' && LA22_114<='\u001F')||LA22_114=='!'||(LA22_114>='$' && LA22_114<='\'')||(LA22_114>='*' && LA22_114<='+')||(LA22_114>='-' && LA22_114<='9')||(LA22_114>=';' && LA22_114<='=')||(LA22_114>='?' && LA22_114<='Z')||(LA22_114>='^' && LA22_114<='z')||LA22_114=='|'||(LA22_114>='~' && LA22_114<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_114=='\\') ) {s = 107;}

                        else if ( (LA22_114==':'||LA22_114=='>') ) {s = 108;}

                        else if ( (LA22_114==','||LA22_114=='['||LA22_114==']'||LA22_114=='{'||LA22_114=='}') ) {s = 109;}

                        else if ( (LA22_114=='\n'||LA22_114=='\r'||(LA22_114>='\"' && LA22_114<='#')||(LA22_114>='(' && LA22_114<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_118 = input.LA(1);

                         
                        int index22_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_118>='\u0000' && LA22_118<='/')||(LA22_118>=':' && LA22_118<='@')||(LA22_118>='G' && LA22_118<='`')||(LA22_118>='g' && LA22_118<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_118>='0' && LA22_118<='9')||(LA22_118>='A' && LA22_118<='F')||(LA22_118>='a' && LA22_118<='f')) ) {s = 141;}

                         
                        input.seek(index22_118);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_152 = input.LA(1);

                         
                        int index22_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_152>='\u0000' && LA22_152<='/')||(LA22_152>=':' && LA22_152<='@')||(LA22_152>='G' && LA22_152<='`')||(LA22_152>='g' && LA22_152<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_152>='0' && LA22_152<='9')||(LA22_152>='A' && LA22_152<='F')||(LA22_152>='a' && LA22_152<='f')) && ((( isOutValue() )||( isHead() )))) {s = 159;}

                         
                        input.seek(index22_152);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_149 = input.LA(1);

                         
                        int index22_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_149>='0' && LA22_149<='9')||(LA22_149>='A' && LA22_149<='F')||(LA22_149>='a' && LA22_149<='f')) ) {s = 156;}

                        else if ( ((LA22_149>='\u0000' && LA22_149<='/')||(LA22_149>=':' && LA22_149<='@')||(LA22_149>='G' && LA22_149<='`')||(LA22_149>='g' && LA22_149<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_149);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_33 = input.LA(1);

                         
                        int index22_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_33=='\n'||LA22_33=='\r') ) {s = 31;}

                        else if ( (LA22_33=='\t'||LA22_33==' ') ) {s = 33;}

                        else if ( ((LA22_33>='\u0000' && LA22_33<='\b')||(LA22_33>='\u000B' && LA22_33<='\f')||(LA22_33>='\u000E' && LA22_33<='\u001F')||(LA22_33>='!' && LA22_33<='\"')||LA22_33=='$'||(LA22_33>='&' && LA22_33<=',')||(LA22_33>='.' && LA22_33<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 78;

                         
                        input.seek(index22_33);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_164 = input.LA(1);

                         
                        int index22_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_164=='\t'||LA22_164==' ') ) {s = 105;}

                        else if ( ((LA22_164>='\u0000' && LA22_164<='\b')||(LA22_164>='\u000B' && LA22_164<='\f')||(LA22_164>='\u000E' && LA22_164<='\u001F')||LA22_164=='!'||(LA22_164>='$' && LA22_164<='\'')||(LA22_164>='*' && LA22_164<='+')||(LA22_164>='-' && LA22_164<='9')||(LA22_164>=';' && LA22_164<='=')||(LA22_164>='?' && LA22_164<='Z')||(LA22_164>='^' && LA22_164<='z')||LA22_164=='|'||(LA22_164>='~' && LA22_164<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_164=='\\') ) {s = 107;}

                        else if ( (LA22_164==':'||LA22_164=='>') ) {s = 108;}

                        else if ( (LA22_164==','||LA22_164=='['||LA22_164==']'||LA22_164=='{'||LA22_164=='}') ) {s = 109;}

                        else if ( (LA22_164=='\n'||LA22_164=='\r'||(LA22_164>='\"' && LA22_164<='#')||(LA22_164>='(' && LA22_164<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_164);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_155 = input.LA(1);

                         
                        int index22_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_155>='0' && LA22_155<='9')||(LA22_155>='A' && LA22_155<='F')||(LA22_155>='a' && LA22_155<='f')) ) {s = 162;}

                        else if ( ((LA22_155>='\u0000' && LA22_155<='/')||(LA22_155>=':' && LA22_155<='@')||(LA22_155>='G' && LA22_155<='`')||(LA22_155>='g' && LA22_155<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_155);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_145 = input.LA(1);

                         
                        int index22_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_145>='\u0000' && LA22_145<='/')||(LA22_145>=':' && LA22_145<='@')||(LA22_145>='G' && LA22_145<='`')||(LA22_145>='g' && LA22_145<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_145>='0' && LA22_145<='9')||(LA22_145>='A' && LA22_145<='F')||(LA22_145>='a' && LA22_145<='f')) && ((( isOutValue() )||( isHead() )))) {s = 152;}

                         
                        input.seek(index22_145);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_142 = input.LA(1);

                         
                        int index22_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_142>='0' && LA22_142<='9')||(LA22_142>='A' && LA22_142<='F')||(LA22_142>='a' && LA22_142<='f')) ) {s = 149;}

                        else if ( ((LA22_142>='\u0000' && LA22_142<='/')||(LA22_142>=':' && LA22_142<='@')||(LA22_142>='G' && LA22_142<='`')||(LA22_142>='g' && LA22_142<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_142);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_140 = input.LA(1);

                         
                        int index22_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_140>='\u0000' && LA22_140<='/')||(LA22_140>=':' && LA22_140<='@')||(LA22_140>='G' && LA22_140<='`')||(LA22_140>='g' && LA22_140<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_140>='0' && LA22_140<='9')||(LA22_140>='A' && LA22_140<='F')||(LA22_140>='a' && LA22_140<='f')) ) {s = 147;}

                         
                        input.seek(index22_140);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_132 = input.LA(1);

                         
                        int index22_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_132=='\t'||LA22_132==' ') ) {s = 105;}

                        else if ( ((LA22_132>='\u0000' && LA22_132<='\b')||(LA22_132>='\u000B' && LA22_132<='\f')||(LA22_132>='\u000E' && LA22_132<='\u001F')||LA22_132=='!'||(LA22_132>='$' && LA22_132<='\'')||(LA22_132>='*' && LA22_132<='+')||(LA22_132>='-' && LA22_132<='9')||(LA22_132>=';' && LA22_132<='=')||(LA22_132>='?' && LA22_132<='Z')||(LA22_132>='^' && LA22_132<='z')||LA22_132=='|'||(LA22_132>='~' && LA22_132<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_132=='\\') ) {s = 107;}

                        else if ( (LA22_132==':'||LA22_132=='>') ) {s = 108;}

                        else if ( (LA22_132==','||LA22_132=='['||LA22_132==']'||LA22_132=='{'||LA22_132=='}') ) {s = 109;}

                        else if ( (LA22_132=='\n'||LA22_132=='\r'||(LA22_132>='\"' && LA22_132<='#')||(LA22_132>='(' && LA22_132<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_132);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_121 = input.LA(1);

                         
                        int index22_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_121=='\t'||LA22_121==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_121>='\u0000' && LA22_121<='\b')||(LA22_121>='\u000B' && LA22_121<='\f')||(LA22_121>='\u000E' && LA22_121<='\u001F')||LA22_121=='!'||(LA22_121>='$' && LA22_121<='\'')||(LA22_121>='*' && LA22_121<='+')||(LA22_121>='-' && LA22_121<='9')||(LA22_121>=';' && LA22_121<='=')||(LA22_121>='?' && LA22_121<='Z')||(LA22_121>='^' && LA22_121<='z')||LA22_121=='|'||(LA22_121>='~' && LA22_121<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_121=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_121==':'||LA22_121=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_121==','||LA22_121=='['||LA22_121==']'||LA22_121=='{'||LA22_121=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_121=='\n'||LA22_121=='\r'||(LA22_121>='\"' && LA22_121<='#')||(LA22_121>='(' && LA22_121<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_121);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_69 = input.LA(1);

                         
                        int index22_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_69=='\n'||LA22_69=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_69=='\"') ) {s = 29;}

                        else if ( ((LA22_69>='\u0000' && LA22_69<='\t')||(LA22_69>='\u000B' && LA22_69<='\f')||(LA22_69>='\u000E' && LA22_69<='!')||(LA22_69>='#' && LA22_69<='[')||(LA22_69>=']' && LA22_69<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_69=='\\') ) {s = 28;}

                         
                        input.seek(index22_69);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_95 = input.LA(1);

                         
                        int index22_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_95=='\t'||LA22_95==' ') ) {s = 42;}

                        else if ( ((LA22_95>='\u0000' && LA22_95<='\b')||(LA22_95>='\u000B' && LA22_95<='\f')||(LA22_95>='\u000E' && LA22_95<='\u001F')||LA22_95=='!'||(LA22_95>='$' && LA22_95<='\'')||(LA22_95>='*' && LA22_95<='+')||(LA22_95>='-' && LA22_95<='9')||(LA22_95>=';' && LA22_95<='=')||(LA22_95>='?' && LA22_95<='Z')||(LA22_95>='^' && LA22_95<='z')||LA22_95=='|'||(LA22_95>='~' && LA22_95<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_95=='\\') ) {s = 44;}

                        else if ( (LA22_95==':'||LA22_95=='>') ) {s = 45;}

                        else if ( (LA22_95==','||LA22_95=='['||LA22_95==']'||LA22_95=='{'||LA22_95=='}') ) {s = 46;}

                        else if ( (LA22_95=='\n'||LA22_95=='\r'||(LA22_95>='\"' && LA22_95<='#')||(LA22_95>='(' && LA22_95<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_95);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_45 = input.LA(1);

                         
                        int index22_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_45=='\t'||LA22_45==' ') ) {s = 42;}

                        else if ( ((LA22_45>='\u0000' && LA22_45<='\b')||(LA22_45>='\u000B' && LA22_45<='\f')||(LA22_45>='\u000E' && LA22_45<='\u001F')||LA22_45=='!'||(LA22_45>='$' && LA22_45<='\'')||(LA22_45>='*' && LA22_45<='+')||(LA22_45>='-' && LA22_45<='9')||(LA22_45>=';' && LA22_45<='=')||(LA22_45>='?' && LA22_45<='Z')||(LA22_45>='^' && LA22_45<='z')||LA22_45=='|'||(LA22_45>='~' && LA22_45<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_45=='\\') ) {s = 44;}

                        else if ( (LA22_45==':'||LA22_45=='>') ) {s = 45;}

                        else if ( (LA22_45==','||LA22_45=='['||LA22_45==']'||LA22_45=='{'||LA22_45=='}') ) {s = 46;}

                        else if ( (LA22_45=='\n'||LA22_45=='\r'||(LA22_45>='\"' && LA22_45<='#')||(LA22_45>='(' && LA22_45<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_45);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA22_84 = input.LA(1);

                         
                        int index22_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_84=='\t'||LA22_84==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_84>='\u0000' && LA22_84<='\b')||(LA22_84>='\u000B' && LA22_84<='\f')||(LA22_84>='\u000E' && LA22_84<='\u001F')||LA22_84=='!'||(LA22_84>='$' && LA22_84<='\'')||(LA22_84>='*' && LA22_84<='+')||(LA22_84>='-' && LA22_84<='9')||(LA22_84>=';' && LA22_84<='=')||(LA22_84>='?' && LA22_84<='Z')||(LA22_84>='^' && LA22_84<='z')||LA22_84=='|'||(LA22_84>='~' && LA22_84<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_84=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_84==':'||LA22_84=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_84==','||LA22_84=='['||LA22_84==']'||LA22_84=='{'||LA22_84=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_84=='\n'||LA22_84=='\r'||(LA22_84>='\"' && LA22_84<='#')||(LA22_84>='(' && LA22_84<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_84);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_30 = input.LA(1);

                         
                        int index22_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() != State.INIT )) ) {s = 78;}

                        else if ( (true) ) {s = 79;}

                         
                        input.seek(index22_30);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_5>='\u0000' && LA22_5<='\t')||(LA22_5>='\u000B' && LA22_5<='\f')||(LA22_5>='\u000E' && LA22_5<='!')||(LA22_5>='#' && LA22_5<='[')||(LA22_5>=']' && LA22_5<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_5=='\n'||LA22_5=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_5=='\\') ) {s = 28;}

                        else if ( (LA22_5=='\"') ) {s = 29;}

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 67;}

                        else if ( (( isHead() )) ) {s = 31;}

                         
                        input.seek(index22_26);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_25 = input.LA(1);

                         
                        int index22_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 67;}

                        else if ( (( isHead() )) ) {s = 31;}

                         
                        input.seek(index22_25);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_66 = input.LA(1);

                         
                        int index22_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 67;}

                        else if ( (( isHead() )) ) {s = 31;}

                         
                        input.seek(index22_66);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_92 = input.LA(1);

                         
                        int index22_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_92=='\t'||LA22_92==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_92>='\u0000' && LA22_92<='\b')||(LA22_92>='\u000B' && LA22_92<='\f')||(LA22_92>='\u000E' && LA22_92<='\u001F')||LA22_92=='!'||(LA22_92>='$' && LA22_92<='\'')||(LA22_92>='*' && LA22_92<='+')||(LA22_92>='-' && LA22_92<='9')||(LA22_92>=';' && LA22_92<='=')||(LA22_92>='?' && LA22_92<='Z')||(LA22_92>='^' && LA22_92<='z')||LA22_92=='|'||(LA22_92>='~' && LA22_92<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_92=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_92==':'||LA22_92=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_92==','||LA22_92=='['||LA22_92==']'||LA22_92=='{'||LA22_92=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_92=='\n'||LA22_92=='\r'||(LA22_92>='\"' && LA22_92<='#')||(LA22_92>='(' && LA22_92<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_92);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_46 = input.LA(1);

                         
                        int index22_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_46=='\t'||LA22_46==' ') ) {s = 42;}

                        else if ( ((LA22_46>='\u0000' && LA22_46<='\b')||(LA22_46>='\u000B' && LA22_46<='\f')||(LA22_46>='\u000E' && LA22_46<='\u001F')||LA22_46=='!'||(LA22_46>='$' && LA22_46<='\'')||(LA22_46>='*' && LA22_46<='+')||(LA22_46>='-' && LA22_46<='9')||(LA22_46>=';' && LA22_46<='=')||(LA22_46>='?' && LA22_46<='Z')||(LA22_46>='^' && LA22_46<='z')||LA22_46=='|'||(LA22_46>='~' && LA22_46<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_46=='\\') ) {s = 44;}

                        else if ( (LA22_46==':'||LA22_46=='>') ) {s = 45;}

                        else if ( (LA22_46==','||LA22_46=='['||LA22_46==']'||LA22_46=='{'||LA22_46=='}') ) {s = 46;}

                        else if ( (LA22_46=='\n'||LA22_46=='\r'||(LA22_46>='\"' && LA22_46<='#')||(LA22_46>='(' && LA22_46<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_46);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_28 = input.LA(1);

                         
                        int index22_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_28>='\u0000' && LA22_28<='!')||(LA22_28>='#' && LA22_28<='.')||(LA22_28>='0' && LA22_28<='[')||(LA22_28>=']' && LA22_28<='a')||(LA22_28>='c' && LA22_28<='e')||(LA22_28>='g' && LA22_28<='m')||(LA22_28>='o' && LA22_28<='q')||LA22_28=='s'||(LA22_28>='v' && LA22_28<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_28=='\"') ) {s = 68;}

                        else if ( (LA22_28=='\\') ) {s = 69;}

                        else if ( (LA22_28=='/') ) {s = 70;}

                        else if ( (LA22_28=='b') ) {s = 71;}

                        else if ( (LA22_28=='f') ) {s = 72;}

                        else if ( (LA22_28=='n') ) {s = 73;}

                        else if ( (LA22_28=='r') ) {s = 74;}

                        else if ( (LA22_28=='t') ) {s = 75;}

                        else if ( (LA22_28=='u') ) {s = 76;}

                         
                        input.seek(index22_28);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_85 = input.LA(1);

                         
                        int index22_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_85=='\t'||LA22_85==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_85>='\u0000' && LA22_85<='\b')||(LA22_85>='\u000B' && LA22_85<='\f')||(LA22_85>='\u000E' && LA22_85<='\u001F')||LA22_85=='!'||(LA22_85>='$' && LA22_85<='\'')||(LA22_85>='*' && LA22_85<='+')||(LA22_85>='-' && LA22_85<='9')||(LA22_85>=';' && LA22_85<='=')||(LA22_85>='?' && LA22_85<='Z')||(LA22_85>='^' && LA22_85<='z')||LA22_85=='|'||(LA22_85>='~' && LA22_85<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_85=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_85==':'||LA22_85=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_85==','||LA22_85=='['||LA22_85==']'||LA22_85=='{'||LA22_85=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_85=='\n'||LA22_85=='\r'||(LA22_85>='\"' && LA22_85<='#')||(LA22_85>='(' && LA22_85<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_85);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_57 = input.LA(1);

                         
                        int index22_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_57=='\n'||LA22_57=='\r'||(LA22_57>='\"' && LA22_57<='#')||(LA22_57>='(' && LA22_57<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_57=='\t'||LA22_57==' ') ) {s = 42;}

                        else if ( ((LA22_57>='\u0000' && LA22_57<='\b')||(LA22_57>='\u000B' && LA22_57<='\f')||(LA22_57>='\u000E' && LA22_57<='\u001F')||LA22_57=='!'||(LA22_57>='$' && LA22_57<='\'')||(LA22_57>='*' && LA22_57<='+')||(LA22_57>='-' && LA22_57<='9')||(LA22_57>=';' && LA22_57<='=')||(LA22_57>='?' && LA22_57<='Z')||(LA22_57>='^' && LA22_57<='z')||LA22_57=='|'||(LA22_57>='~' && LA22_57<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_57=='\\') ) {s = 44;}

                        else if ( (LA22_57==':'||LA22_57=='>') ) {s = 45;}

                        else if ( (LA22_57==','||LA22_57=='['||LA22_57==']'||LA22_57=='{'||LA22_57=='}') ) {s = 46;}

                        else s = 56;

                         
                        input.seek(index22_57);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_65 = input.LA(1);

                         
                        int index22_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_65>='0' && LA22_65<='9')||(LA22_65>='A' && LA22_65<='F')||(LA22_65>='a' && LA22_65<='f')) ) {s = 119;}

                        else if ( ((LA22_65>='\u0000' && LA22_65<='/')||(LA22_65>=':' && LA22_65<='@')||(LA22_65>='G' && LA22_65<='`')||(LA22_65>='g' && LA22_65<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_65);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_94 = input.LA(1);

                         
                        int index22_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_94>='\u0000' && LA22_94<='/')||(LA22_94>=':' && LA22_94<='@')||(LA22_94>='G' && LA22_94<='`')||(LA22_94>='g' && LA22_94<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_94>='0' && LA22_94<='9')||(LA22_94>='A' && LA22_94<='F')||(LA22_94>='a' && LA22_94<='f')) && ((( isOutValue() )||( isHead() )))) {s = 130;}

                         
                        input.seek(index22_94);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_109 = input.LA(1);

                         
                        int index22_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_109=='\t'||LA22_109==' ') ) {s = 105;}

                        else if ( ((LA22_109>='\u0000' && LA22_109<='\b')||(LA22_109>='\u000B' && LA22_109<='\f')||(LA22_109>='\u000E' && LA22_109<='\u001F')||LA22_109=='!'||(LA22_109>='$' && LA22_109<='\'')||(LA22_109>='*' && LA22_109<='+')||(LA22_109>='-' && LA22_109<='9')||(LA22_109>=';' && LA22_109<='=')||(LA22_109>='?' && LA22_109<='Z')||(LA22_109>='^' && LA22_109<='z')||LA22_109=='|'||(LA22_109>='~' && LA22_109<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_109=='\\') ) {s = 107;}

                        else if ( (LA22_109==':'||LA22_109=='>') ) {s = 108;}

                        else if ( (LA22_109==','||LA22_109=='['||LA22_109==']'||LA22_109=='{'||LA22_109=='}') ) {s = 109;}

                        else if ( (LA22_109=='\n'||LA22_109=='\r'||(LA22_109>='\"' && LA22_109<='#')||(LA22_109>='(' && LA22_109<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_109);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_54 = input.LA(1);

                         
                        int index22_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_54=='\t'||LA22_54==' ') ) {s = 105;}

                        else if ( ((LA22_54>='\u0000' && LA22_54<='\b')||(LA22_54>='\u000B' && LA22_54<='\f')||(LA22_54>='\u000E' && LA22_54<='\u001F')||LA22_54=='!'||(LA22_54>='$' && LA22_54<='\'')||(LA22_54>='*' && LA22_54<='+')||(LA22_54>='-' && LA22_54<='9')||(LA22_54>=';' && LA22_54<='=')||(LA22_54>='?' && LA22_54<='Z')||(LA22_54>='^' && LA22_54<='z')||LA22_54=='|'||(LA22_54>='~' && LA22_54<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_54=='\\') ) {s = 107;}

                        else if ( (LA22_54==':'||LA22_54=='>') ) {s = 108;}

                        else if ( (LA22_54==','||LA22_54=='['||LA22_54==']'||LA22_54=='{'||LA22_54=='}') ) {s = 109;}

                        else if ( (LA22_54=='\n'||LA22_54=='\r'||(LA22_54>='\"' && LA22_54<='#')||(LA22_54>='(' && LA22_54<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_54);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_147 = input.LA(1);

                         
                        int index22_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_147>='0' && LA22_147<='9')||(LA22_147>='A' && LA22_147<='F')||(LA22_147>='a' && LA22_147<='f')) ) {s = 154;}

                        else if ( ((LA22_147>='\u0000' && LA22_147<='/')||(LA22_147>=':' && LA22_147<='@')||(LA22_147>='G' && LA22_147<='`')||(LA22_147>='g' && LA22_147<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_147);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_144 = input.LA(1);

                         
                        int index22_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_144>='0' && LA22_144<='9')||(LA22_144>='A' && LA22_144<='F')||(LA22_144>='a' && LA22_144<='f')) && ((( isOutValue() )||( isHead() )))) {s = 151;}

                        else if ( ((LA22_144>='\u0000' && LA22_144<='/')||(LA22_144>=':' && LA22_144<='@')||(LA22_144>='G' && LA22_144<='`')||(LA22_144>='g' && LA22_144<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_144);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_131 = input.LA(1);

                         
                        int index22_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_131>='0' && LA22_131<='9')||(LA22_131>='A' && LA22_131<='F')||(LA22_131>='a' && LA22_131<='f')) ) {s = 146;}

                        else if ( ((LA22_131>='\u0000' && LA22_131<='/')||(LA22_131>=':' && LA22_131<='@')||(LA22_131>='G' && LA22_131<='`')||(LA22_131>='g' && LA22_131<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_131);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_93 = input.LA(1);

                         
                        int index22_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_93=='\t'||LA22_93==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_93>='\u0000' && LA22_93<='\b')||(LA22_93>='\u000B' && LA22_93<='\f')||(LA22_93>='\u000E' && LA22_93<='\u001F')||LA22_93=='!'||(LA22_93>='$' && LA22_93<='\'')||(LA22_93>='*' && LA22_93<='+')||(LA22_93>='-' && LA22_93<='9')||(LA22_93>=';' && LA22_93<='=')||(LA22_93>='?' && LA22_93<='Z')||(LA22_93>='^' && LA22_93<='z')||LA22_93=='|'||(LA22_93>='~' && LA22_93<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_93=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_93==':'||LA22_93=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_93==','||LA22_93=='['||LA22_93==']'||LA22_93=='{'||LA22_93=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_93=='\n'||LA22_93=='\r'||(LA22_93>='\"' && LA22_93<='#')||(LA22_93>='(' && LA22_93<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_93);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_58=='\t'||LA22_58==' ') ) {s = 42;}

                        else if ( ((LA22_58>='\u0000' && LA22_58<='\b')||(LA22_58>='\u000B' && LA22_58<='\f')||(LA22_58>='\u000E' && LA22_58<='\u001F')||LA22_58=='!'||(LA22_58>='$' && LA22_58<='\'')||(LA22_58>='*' && LA22_58<='+')||(LA22_58>='-' && LA22_58<='9')||(LA22_58>=';' && LA22_58<='=')||(LA22_58>='?' && LA22_58<='Z')||(LA22_58>='^' && LA22_58<='z')||LA22_58=='|'||(LA22_58>='~' && LA22_58<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_58=='\\') ) {s = 44;}

                        else if ( (LA22_58==':'||LA22_58=='>') ) {s = 45;}

                        else if ( (LA22_58==','||LA22_58=='['||LA22_58==']'||LA22_58=='{'||LA22_58=='}') ) {s = 46;}

                        else if ( (LA22_58=='\n'||LA22_58=='\r'||(LA22_58>='\"' && LA22_58<='#')||(LA22_58>='(' && LA22_58<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_58);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_113=='\t'||LA22_113==' ') ) {s = 105;}

                        else if ( ((LA22_113>='\u0000' && LA22_113<='\b')||(LA22_113>='\u000B' && LA22_113<='\f')||(LA22_113>='\u000E' && LA22_113<='\u001F')||LA22_113=='!'||(LA22_113>='$' && LA22_113<='\'')||(LA22_113>='*' && LA22_113<='+')||(LA22_113>='-' && LA22_113<='9')||(LA22_113>=';' && LA22_113<='=')||(LA22_113>='?' && LA22_113<='Z')||(LA22_113>='^' && LA22_113<='z')||LA22_113=='|'||(LA22_113>='~' && LA22_113<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_113=='\\') ) {s = 107;}

                        else if ( (LA22_113==':'||LA22_113=='>') ) {s = 108;}

                        else if ( (LA22_113==','||LA22_113=='['||LA22_113==']'||LA22_113=='{'||LA22_113=='}') ) {s = 109;}

                        else if ( (LA22_113=='\n'||LA22_113=='\r'||(LA22_113>='\"' && LA22_113<='#')||(LA22_113>='(' && LA22_113<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA22_162 = input.LA(1);

                         
                        int index22_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_162=='\t'||LA22_162==' ') ) {s = 105;}

                        else if ( ((LA22_162>='\u0000' && LA22_162<='\b')||(LA22_162>='\u000B' && LA22_162<='\f')||(LA22_162>='\u000E' && LA22_162<='\u001F')||LA22_162=='!'||(LA22_162>='$' && LA22_162<='\'')||(LA22_162>='*' && LA22_162<='+')||(LA22_162>='-' && LA22_162<='9')||(LA22_162>=';' && LA22_162<='=')||(LA22_162>='?' && LA22_162<='Z')||(LA22_162>='^' && LA22_162<='z')||LA22_162=='|'||(LA22_162>='~' && LA22_162<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_162=='\\') ) {s = 107;}

                        else if ( (LA22_162==':'||LA22_162=='>') ) {s = 108;}

                        else if ( (LA22_162==','||LA22_162=='['||LA22_162==']'||LA22_162=='{'||LA22_162=='}') ) {s = 109;}

                        else if ( (LA22_162=='\n'||LA22_162=='\r'||(LA22_162>='\"' && LA22_162<='#')||(LA22_162>='(' && LA22_162<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_162);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA22_127 = input.LA(1);

                         
                        int index22_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_127=='\t'||LA22_127==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_127>='\u0000' && LA22_127<='\b')||(LA22_127>='\u000B' && LA22_127<='\f')||(LA22_127>='\u000E' && LA22_127<='\u001F')||LA22_127=='!'||(LA22_127>='$' && LA22_127<='\'')||(LA22_127>='*' && LA22_127<='+')||(LA22_127>='-' && LA22_127<='9')||(LA22_127>=';' && LA22_127<='=')||(LA22_127>='?' && LA22_127<='Z')||(LA22_127>='^' && LA22_127<='z')||LA22_127=='|'||(LA22_127>='~' && LA22_127<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_127=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_127==':'||LA22_127=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_127==','||LA22_127=='['||LA22_127==']'||LA22_127=='{'||LA22_127=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_127=='\n'||LA22_127=='\r'||(LA22_127>='\"' && LA22_127<='#')||(LA22_127>='(' && LA22_127<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_127);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA22_101 = input.LA(1);

                         
                        int index22_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_101=='\t'||LA22_101==' ') ) {s = 42;}

                        else if ( ((LA22_101>='\u0000' && LA22_101<='\b')||(LA22_101>='\u000B' && LA22_101<='\f')||(LA22_101>='\u000E' && LA22_101<='\u001F')||LA22_101=='!'||(LA22_101>='$' && LA22_101<='\'')||(LA22_101>='*' && LA22_101<='+')||(LA22_101>='-' && LA22_101<='9')||(LA22_101>=';' && LA22_101<='=')||(LA22_101>='?' && LA22_101<='Z')||(LA22_101>='^' && LA22_101<='z')||LA22_101=='|'||(LA22_101>='~' && LA22_101<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_101=='\\') ) {s = 44;}

                        else if ( (LA22_101==':'||LA22_101=='>') ) {s = 45;}

                        else if ( (LA22_101==','||LA22_101=='['||LA22_101==']'||LA22_101=='{'||LA22_101=='}') ) {s = 46;}

                        else if ( (LA22_101=='\n'||LA22_101=='\r'||(LA22_101>='\"' && LA22_101<='#')||(LA22_101>='(' && LA22_101<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_101);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_59=='\t'||LA22_59==' ') ) {s = 42;}

                        else if ( ((LA22_59>='\u0000' && LA22_59<='\b')||(LA22_59>='\u000B' && LA22_59<='\f')||(LA22_59>='\u000E' && LA22_59<='\u001F')||LA22_59=='!'||(LA22_59>='$' && LA22_59<='\'')||(LA22_59>='*' && LA22_59<='+')||(LA22_59>='-' && LA22_59<='9')||(LA22_59>=';' && LA22_59<='=')||(LA22_59>='?' && LA22_59<='Z')||(LA22_59>='^' && LA22_59<='z')||LA22_59=='|'||(LA22_59>='~' && LA22_59<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_59=='\\') ) {s = 44;}

                        else if ( (LA22_59==':'||LA22_59=='>') ) {s = 45;}

                        else if ( (LA22_59==','||LA22_59=='['||LA22_59==']'||LA22_59=='{'||LA22_59=='}') ) {s = 46;}

                        else if ( (LA22_59=='\n'||LA22_59=='\r'||(LA22_59>='\"' && LA22_59<='#')||(LA22_59>='(' && LA22_59<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_6=='\n'||LA22_6=='\r') ) {s = 31;}

                        else if ( (LA22_6==' ') ) {s = 32;}

                        else if ( (LA22_6=='-') ) {s = 7;}

                        else if ( (LA22_6=='\t') ) {s = 33;}

                        else if ( ((LA22_6>='\u0000' && LA22_6<='\b')||(LA22_6>='\u000B' && LA22_6<='\f')||(LA22_6>='\u000E' && LA22_6<='\u001F')||(LA22_6>='!' && LA22_6<='\"')||LA22_6=='$'||(LA22_6>='&' && LA22_6<=',')||(LA22_6>='.' && LA22_6<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 30;

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA22_68 = input.LA(1);

                         
                        int index22_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_68=='\n'||LA22_68=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_68=='\"') ) {s = 29;}

                        else if ( ((LA22_68>='\u0000' && LA22_68<='\t')||(LA22_68>='\u000B' && LA22_68<='\f')||(LA22_68>='\u000E' && LA22_68<='!')||(LA22_68>='#' && LA22_68<='[')||(LA22_68>=']' && LA22_68<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_68=='\\') ) {s = 28;}

                         
                        input.seek(index22_68);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA22_72 = input.LA(1);

                         
                        int index22_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_72=='\"') ) {s = 29;}

                        else if ( ((LA22_72>='\u0000' && LA22_72<='\t')||(LA22_72>='\u000B' && LA22_72<='\f')||(LA22_72>='\u000E' && LA22_72<='!')||(LA22_72>='#' && LA22_72<='[')||(LA22_72>=']' && LA22_72<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_72=='\\') ) {s = 28;}

                        else if ( (LA22_72=='\n'||LA22_72=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_72);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 36;

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA22_87 = input.LA(1);

                         
                        int index22_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_87=='\t'||LA22_87==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_87>='\u0000' && LA22_87<='\b')||(LA22_87>='\u000B' && LA22_87<='\f')||(LA22_87>='\u000E' && LA22_87<='\u001F')||LA22_87=='!'||(LA22_87>='$' && LA22_87<='\'')||(LA22_87>='*' && LA22_87<='+')||(LA22_87>='-' && LA22_87<='9')||(LA22_87>=';' && LA22_87<='=')||(LA22_87>='?' && LA22_87<='Z')||(LA22_87>='^' && LA22_87<='z')||LA22_87=='|'||(LA22_87>='~' && LA22_87<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_87=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_87==':'||LA22_87=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_87==','||LA22_87=='['||LA22_87==']'||LA22_87=='{'||LA22_87=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_87=='\n'||LA22_87=='\r'||(LA22_87>='\"' && LA22_87<='#')||(LA22_87>='(' && LA22_87<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_87);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA22_148 = input.LA(1);

                         
                        int index22_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_148>='\u0000' && LA22_148<='/')||(LA22_148>=':' && LA22_148<='@')||(LA22_148>='G' && LA22_148<='`')||(LA22_148>='g' && LA22_148<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_148>='0' && LA22_148<='9')||(LA22_148>='A' && LA22_148<='F')||(LA22_148>='a' && LA22_148<='f')) ) {s = 155;}

                         
                        input.seek(index22_148);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA22_159 = input.LA(1);

                         
                        int index22_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_159=='\t'||LA22_159==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_159>='\u0000' && LA22_159<='\b')||(LA22_159>='\u000B' && LA22_159<='\f')||(LA22_159>='\u000E' && LA22_159<='\u001F')||LA22_159=='!'||(LA22_159>='$' && LA22_159<='\'')||(LA22_159>='*' && LA22_159<='+')||(LA22_159>='-' && LA22_159<='9')||(LA22_159>=';' && LA22_159<='=')||(LA22_159>='?' && LA22_159<='Z')||(LA22_159>='^' && LA22_159<='z')||LA22_159=='|'||(LA22_159>='~' && LA22_159<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_159=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_159==':'||LA22_159=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_159==','||LA22_159=='['||LA22_159==']'||LA22_159=='{'||LA22_159=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_159=='\n'||LA22_159=='\r'||(LA22_159>='\"' && LA22_159<='#')||(LA22_159>='(' && LA22_159<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_159);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA22_73 = input.LA(1);

                         
                        int index22_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_73=='\n'||LA22_73=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_73=='\"') ) {s = 29;}

                        else if ( ((LA22_73>='\u0000' && LA22_73<='\t')||(LA22_73>='\u000B' && LA22_73<='\f')||(LA22_73>='\u000E' && LA22_73<='!')||(LA22_73>='#' && LA22_73<='[')||(LA22_73>=']' && LA22_73<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_73=='\\') ) {s = 28;}

                         
                        input.seek(index22_73);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA22_133 = input.LA(1);

                         
                        int index22_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_133=='\t'||LA22_133==' ') ) {s = 105;}

                        else if ( ((LA22_133>='\u0000' && LA22_133<='\b')||(LA22_133>='\u000B' && LA22_133<='\f')||(LA22_133>='\u000E' && LA22_133<='\u001F')||LA22_133=='!'||(LA22_133>='$' && LA22_133<='\'')||(LA22_133>='*' && LA22_133<='+')||(LA22_133>='-' && LA22_133<='9')||(LA22_133>=';' && LA22_133<='=')||(LA22_133>='?' && LA22_133<='Z')||(LA22_133>='^' && LA22_133<='z')||LA22_133=='|'||(LA22_133>='~' && LA22_133<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_133=='\\') ) {s = 107;}

                        else if ( (LA22_133==':'||LA22_133=='>') ) {s = 108;}

                        else if ( (LA22_133==','||LA22_133=='['||LA22_133==']'||LA22_133=='{'||LA22_133=='}') ) {s = 109;}

                        else if ( (LA22_133=='\n'||LA22_133=='\r'||(LA22_133>='\"' && LA22_133<='#')||(LA22_133>='(' && LA22_133<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_133);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA22_71 = input.LA(1);

                         
                        int index22_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_71=='\"') ) {s = 29;}

                        else if ( ((LA22_71>='\u0000' && LA22_71<='\t')||(LA22_71>='\u000B' && LA22_71<='\f')||(LA22_71>='\u000E' && LA22_71<='!')||(LA22_71>='#' && LA22_71<='[')||(LA22_71>=']' && LA22_71<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_71=='\\') ) {s = 28;}

                        else if ( (LA22_71=='\n'||LA22_71=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_71);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA22_62 = input.LA(1);

                         
                        int index22_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_62=='\n'||LA22_62=='\r'||(LA22_62>='\"' && LA22_62<='#')||(LA22_62>='(' && LA22_62<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_62=='\t'||LA22_62==' ') ) {s = 42;}

                        else if ( ((LA22_62>='\u0000' && LA22_62<='\b')||(LA22_62>='\u000B' && LA22_62<='\f')||(LA22_62>='\u000E' && LA22_62<='\u001F')||LA22_62=='!'||(LA22_62>='$' && LA22_62<='\'')||(LA22_62>='*' && LA22_62<='+')||(LA22_62>='-' && LA22_62<='9')||(LA22_62>=';' && LA22_62<='=')||(LA22_62>='?' && LA22_62<='Z')||(LA22_62>='^' && LA22_62<='z')||LA22_62=='|'||(LA22_62>='~' && LA22_62<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_62=='\\') ) {s = 44;}

                        else if ( (LA22_62==':'||LA22_62=='>') ) {s = 45;}

                        else if ( (LA22_62==','||LA22_62=='['||LA22_62==']'||LA22_62=='{'||LA22_62=='}') ) {s = 46;}

                        else s = 56;

                         
                        input.seek(index22_62);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA22_161 = input.LA(1);

                         
                        int index22_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_161>='0' && LA22_161<='9')||(LA22_161>='A' && LA22_161<='F')||(LA22_161>='a' && LA22_161<='f')) ) {s = 164;}

                        else if ( ((LA22_161>='\u0000' && LA22_161<='/')||(LA22_161>=':' && LA22_161<='@')||(LA22_161>='G' && LA22_161<='`')||(LA22_161>='g' && LA22_161<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_161);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA22_130 = input.LA(1);

                         
                        int index22_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_130>='\u0000' && LA22_130<='/')||(LA22_130>=':' && LA22_130<='@')||(LA22_130>='G' && LA22_130<='`')||(LA22_130>='g' && LA22_130<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_130>='0' && LA22_130<='9')||(LA22_130>='A' && LA22_130<='F')||(LA22_130>='a' && LA22_130<='f')) && ((( isOutValue() )||( isHead() )))) {s = 145;}

                         
                        input.seek(index22_130);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA22_119 = input.LA(1);

                         
                        int index22_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_119>='0' && LA22_119<='9')||(LA22_119>='A' && LA22_119<='F')||(LA22_119>='a' && LA22_119<='f')) ) {s = 142;}

                        else if ( ((LA22_119>='\u0000' && LA22_119<='/')||(LA22_119>=':' && LA22_119<='@')||(LA22_119>='G' && LA22_119<='`')||(LA22_119>='g' && LA22_119<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_119);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA22_156 = input.LA(1);

                         
                        int index22_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_156=='\t'||LA22_156==' ') ) {s = 42;}

                        else if ( ((LA22_156>='\u0000' && LA22_156<='\b')||(LA22_156>='\u000B' && LA22_156<='\f')||(LA22_156>='\u000E' && LA22_156<='\u001F')||LA22_156=='!'||(LA22_156>='$' && LA22_156<='\'')||(LA22_156>='*' && LA22_156<='+')||(LA22_156>='-' && LA22_156<='9')||(LA22_156>=';' && LA22_156<='=')||(LA22_156>='?' && LA22_156<='Z')||(LA22_156>='^' && LA22_156<='z')||LA22_156=='|'||(LA22_156>='~' && LA22_156<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_156=='\\') ) {s = 44;}

                        else if ( (LA22_156==':'||LA22_156=='>') ) {s = 45;}

                        else if ( (LA22_156==','||LA22_156=='['||LA22_156==']'||LA22_156=='{'||LA22_156=='}') ) {s = 46;}

                        else if ( (LA22_156=='\n'||LA22_156=='\r'||(LA22_156>='\"' && LA22_156<='#')||(LA22_156>='(' && LA22_156<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_156);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA22_106 = input.LA(1);

                         
                        int index22_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_106=='\t'||LA22_106==' ') ) {s = 105;}

                        else if ( ((LA22_106>='\u0000' && LA22_106<='\b')||(LA22_106>='\u000B' && LA22_106<='\f')||(LA22_106>='\u000E' && LA22_106<='\u001F')||LA22_106=='!'||(LA22_106>='$' && LA22_106<='\'')||(LA22_106>='*' && LA22_106<='+')||(LA22_106>='-' && LA22_106<='9')||(LA22_106>=';' && LA22_106<='=')||(LA22_106>='?' && LA22_106<='Z')||(LA22_106>='^' && LA22_106<='z')||LA22_106=='|'||(LA22_106>='~' && LA22_106<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_106=='\\') ) {s = 107;}

                        else if ( (LA22_106==':'||LA22_106=='>') ) {s = 108;}

                        else if ( (LA22_106==','||LA22_106=='['||LA22_106==']'||LA22_106=='{'||LA22_106=='}') ) {s = 109;}

                        else if ( (LA22_106=='\n'||LA22_106=='\r'||(LA22_106>='\"' && LA22_106<='#')||(LA22_106>='(' && LA22_106<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_106);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA22_76 = input.LA(1);

                         
                        int index22_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_76>='0' && LA22_76<='9')||(LA22_76>='A' && LA22_76<='F')||(LA22_76>='a' && LA22_76<='f')) ) {s = 120;}

                        else if ( ((LA22_76>='\u0000' && LA22_76<='/')||(LA22_76>=':' && LA22_76<='@')||(LA22_76>='G' && LA22_76<='`')||(LA22_76>='g' && LA22_76<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_76);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA22_108 = input.LA(1);

                         
                        int index22_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_108=='\t'||LA22_108==' ') ) {s = 105;}

                        else if ( ((LA22_108>='\u0000' && LA22_108<='\b')||(LA22_108>='\u000B' && LA22_108<='\f')||(LA22_108>='\u000E' && LA22_108<='\u001F')||LA22_108=='!'||(LA22_108>='$' && LA22_108<='\'')||(LA22_108>='*' && LA22_108<='+')||(LA22_108>='-' && LA22_108<='9')||(LA22_108>=';' && LA22_108<='=')||(LA22_108>='?' && LA22_108<='Z')||(LA22_108>='^' && LA22_108<='z')||LA22_108=='|'||(LA22_108>='~' && LA22_108<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_108=='\\') ) {s = 107;}

                        else if ( (LA22_108==':'||LA22_108=='>') ) {s = 108;}

                        else if ( (LA22_108==','||LA22_108=='['||LA22_108==']'||LA22_108=='{'||LA22_108=='}') ) {s = 109;}

                        else if ( (LA22_108=='\n'||LA22_108=='\r'||(LA22_108>='\"' && LA22_108<='#')||(LA22_108>='(' && LA22_108<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_108);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA22_112 = input.LA(1);

                         
                        int index22_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_112=='\t'||LA22_112==' ') ) {s = 105;}

                        else if ( ((LA22_112>='\u0000' && LA22_112<='\b')||(LA22_112>='\u000B' && LA22_112<='\f')||(LA22_112>='\u000E' && LA22_112<='\u001F')||LA22_112=='!'||(LA22_112>='$' && LA22_112<='\'')||(LA22_112>='*' && LA22_112<='+')||(LA22_112>='-' && LA22_112<='9')||(LA22_112>=';' && LA22_112<='=')||(LA22_112>='?' && LA22_112<='Z')||(LA22_112>='^' && LA22_112<='z')||LA22_112=='|'||(LA22_112>='~' && LA22_112<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_112=='\\') ) {s = 107;}

                        else if ( (LA22_112==':'||LA22_112=='>') ) {s = 108;}

                        else if ( (LA22_112==','||LA22_112=='['||LA22_112==']'||LA22_112=='{'||LA22_112=='}') ) {s = 109;}

                        else if ( (LA22_112=='\n'||LA22_112=='\r'||(LA22_112>='\"' && LA22_112<='#')||(LA22_112>='(' && LA22_112<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_112);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA22_120 = input.LA(1);

                         
                        int index22_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_120>='0' && LA22_120<='9')||(LA22_120>='A' && LA22_120<='F')||(LA22_120>='a' && LA22_120<='f')) ) {s = 143;}

                        else if ( ((LA22_120>='\u0000' && LA22_120<='/')||(LA22_120>=':' && LA22_120<='@')||(LA22_120>='G' && LA22_120<='`')||(LA22_120>='g' && LA22_120<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_120);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA22_141 = input.LA(1);

                         
                        int index22_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_141>='0' && LA22_141<='9')||(LA22_141>='A' && LA22_141<='F')||(LA22_141>='a' && LA22_141<='f')) ) {s = 148;}

                        else if ( ((LA22_141>='\u0000' && LA22_141<='/')||(LA22_141>=':' && LA22_141<='@')||(LA22_141>='G' && LA22_141<='`')||(LA22_141>='g' && LA22_141<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_141);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA22_17 = input.LA(1);

                         
                        int index22_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_17>='\u0000' && LA22_17<='\b')||(LA22_17>='\u000B' && LA22_17<='\f')||(LA22_17>='\u000E' && LA22_17<='\u001F')||LA22_17=='!'||(LA22_17>='#' && LA22_17<='[')||(LA22_17>=']' && LA22_17<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 37;}

                        else if ( ((LA22_17>='\t' && LA22_17<='\n')||LA22_17=='\r'||LA22_17==' '||LA22_17=='\"') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_17=='\\') && ((( isOutValue() )||( isHead() )))) {s = 38;}

                        else s = 49;

                         
                        input.seek(index22_17);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA22_91 = input.LA(1);

                         
                        int index22_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_91=='\n'||LA22_91=='\r'||(LA22_91>='\"' && LA22_91<='#')||(LA22_91>='(' && LA22_91<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_91=='\t'||LA22_91==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_91>='\u0000' && LA22_91<='\b')||(LA22_91>='\u000B' && LA22_91<='\f')||(LA22_91>='\u000E' && LA22_91<='\u001F')||LA22_91=='!'||(LA22_91>='$' && LA22_91<='\'')||(LA22_91>='*' && LA22_91<='+')||(LA22_91>='-' && LA22_91<='9')||(LA22_91>=';' && LA22_91<='=')||(LA22_91>='?' && LA22_91<='Z')||(LA22_91>='^' && LA22_91<='z')||LA22_91=='|'||(LA22_91>='~' && LA22_91<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_91=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_91==':'||LA22_91=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_91==','||LA22_91=='['||LA22_91==']'||LA22_91=='{'||LA22_91=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else s = 80;

                         
                        input.seek(index22_91);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA22_74 = input.LA(1);

                         
                        int index22_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_74=='\"') ) {s = 29;}

                        else if ( ((LA22_74>='\u0000' && LA22_74<='\t')||(LA22_74>='\u000B' && LA22_74<='\f')||(LA22_74>='\u000E' && LA22_74<='!')||(LA22_74>='#' && LA22_74<='[')||(LA22_74>=']' && LA22_74<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_74=='\\') ) {s = 28;}

                        else if ( (LA22_74=='\n'||LA22_74=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_74);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA22_37 = input.LA(1);

                         
                        int index22_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_37=='\t'||LA22_37==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_37>='\u0000' && LA22_37<='\b')||(LA22_37>='\u000B' && LA22_37<='\f')||(LA22_37>='\u000E' && LA22_37<='\u001F')||LA22_37=='!'||(LA22_37>='$' && LA22_37<='\'')||(LA22_37>='*' && LA22_37<='+')||(LA22_37>='-' && LA22_37<='9')||(LA22_37>=';' && LA22_37<='=')||(LA22_37>='?' && LA22_37<='Z')||(LA22_37>='^' && LA22_37<='z')||LA22_37=='|'||(LA22_37>='~' && LA22_37<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_37=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_37==':'||LA22_37=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_37==','||LA22_37=='['||LA22_37==']'||LA22_37=='{'||LA22_37=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_37=='\n'||LA22_37=='\r'||(LA22_37>='\"' && LA22_37<='#')||(LA22_37>='(' && LA22_37<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_37);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA22_158 = input.LA(1);

                         
                        int index22_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_158>='0' && LA22_158<='9')||(LA22_158>='A' && LA22_158<='F')||(LA22_158>='a' && LA22_158<='f')) && ((( isOutValue() )||( isHead() )))) {s = 163;}

                        else if ( ((LA22_158>='\u0000' && LA22_158<='/')||(LA22_158>=':' && LA22_158<='@')||(LA22_158>='G' && LA22_158<='`')||(LA22_158>='g' && LA22_158<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_158);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA22_153 = input.LA(1);

                         
                        int index22_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_153>='0' && LA22_153<='9')||(LA22_153>='A' && LA22_153<='F')||(LA22_153>='a' && LA22_153<='f')) ) {s = 160;}

                        else if ( ((LA22_153>='\u0000' && LA22_153<='/')||(LA22_153>=':' && LA22_153<='@')||(LA22_153>='G' && LA22_153<='`')||(LA22_153>='g' && LA22_153<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_153);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_14=='\t'||LA22_14==' ') ) {s = 42;}

                        else if ( ((LA22_14>='\u0000' && LA22_14<='\b')||(LA22_14>='\u000B' && LA22_14<='\f')||(LA22_14>='\u000E' && LA22_14<='\u001F')||LA22_14=='!'||(LA22_14>='$' && LA22_14<='\'')||(LA22_14>='*' && LA22_14<='+')||(LA22_14>='-' && LA22_14<='9')||(LA22_14>=';' && LA22_14<='=')||(LA22_14>='?' && LA22_14<='Z')||(LA22_14>='^' && LA22_14<='z')||LA22_14=='|'||(LA22_14>='~' && LA22_14<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_14=='\\') ) {s = 44;}

                        else if ( (LA22_14==':'||LA22_14=='>') ) {s = 45;}

                        else if ( (LA22_14==','||LA22_14=='['||LA22_14==']'||LA22_14=='{'||LA22_14=='}') ) {s = 46;}

                        else if ( (LA22_14=='\n'||LA22_14=='\r'||(LA22_14>='\"' && LA22_14<='#')||(LA22_14>='(' && LA22_14<=')')) && (( isHead() ))) {s = 23;}

                        else s = 41;

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_12>='\u0000' && LA22_12<='\b')||(LA22_12>='\u000B' && LA22_12<='\f')||(LA22_12>='\u000E' && LA22_12<='\u001F')||LA22_12=='!'||(LA22_12>='#' && LA22_12<='[')||(LA22_12>=']' && LA22_12<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 37;}

                        else if ( ((LA22_12>='\t' && LA22_12<='\n')||LA22_12=='\r'||LA22_12==' '||LA22_12=='\"') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_12=='\\') && ((( isOutValue() )||( isHead() )))) {s = 38;}

                        else s = 39;

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA22_138 = input.LA(1);

                         
                        int index22_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_138=='\t'||LA22_138==' ') ) {s = 105;}

                        else if ( ((LA22_138>='\u0000' && LA22_138<='\b')||(LA22_138>='\u000B' && LA22_138<='\f')||(LA22_138>='\u000E' && LA22_138<='\u001F')||LA22_138=='!'||(LA22_138>='$' && LA22_138<='\'')||(LA22_138>='*' && LA22_138<='+')||(LA22_138>='-' && LA22_138<='9')||(LA22_138>=';' && LA22_138<='=')||(LA22_138>='?' && LA22_138<='Z')||(LA22_138>='^' && LA22_138<='z')||LA22_138=='|'||(LA22_138>='~' && LA22_138<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_138=='\\') ) {s = 107;}

                        else if ( (LA22_138==':'||LA22_138=='>') ) {s = 108;}

                        else if ( (LA22_138==','||LA22_138=='['||LA22_138==']'||LA22_138=='{'||LA22_138=='}') ) {s = 109;}

                        else if ( (LA22_138=='\n'||LA22_138=='\r'||(LA22_138>='\"' && LA22_138<='#')||(LA22_138>='(' && LA22_138<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_138);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA22_63 = input.LA(1);

                         
                        int index22_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_63=='\t'||LA22_63==' ') ) {s = 42;}

                        else if ( ((LA22_63>='\u0000' && LA22_63<='\b')||(LA22_63>='\u000B' && LA22_63<='\f')||(LA22_63>='\u000E' && LA22_63<='\u001F')||LA22_63=='!'||(LA22_63>='$' && LA22_63<='\'')||(LA22_63>='*' && LA22_63<='+')||(LA22_63>='-' && LA22_63<='9')||(LA22_63>=';' && LA22_63<='=')||(LA22_63>='?' && LA22_63<='Z')||(LA22_63>='^' && LA22_63<='z')||LA22_63=='|'||(LA22_63>='~' && LA22_63<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_63=='\\') ) {s = 44;}

                        else if ( (LA22_63==':'||LA22_63=='>') ) {s = 45;}

                        else if ( (LA22_63==','||LA22_63=='['||LA22_63==']'||LA22_63=='{'||LA22_63=='}') ) {s = 46;}

                        else if ( (LA22_63=='\n'||LA22_63=='\r'||(LA22_63>='\"' && LA22_63<='#')||(LA22_63>='(' && LA22_63<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_63);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_42>='\u0000' && LA22_42<='\b')||(LA22_42>='\u000B' && LA22_42<='\f')||(LA22_42>='\u000E' && LA22_42<='\u001F')||LA22_42=='!'||(LA22_42>='$' && LA22_42<='\'')||(LA22_42>='*' && LA22_42<='+')||(LA22_42>='-' && LA22_42<='9')||(LA22_42>=';' && LA22_42<='=')||(LA22_42>='?' && LA22_42<='Z')||(LA22_42>='^' && LA22_42<='z')||LA22_42=='|'||(LA22_42>='~' && LA22_42<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_42=='\\') ) {s = 44;}

                        else if ( (LA22_42==':'||LA22_42=='>') ) {s = 45;}

                        else if ( (LA22_42==','||LA22_42=='['||LA22_42==']'||LA22_42=='{'||LA22_42=='}') ) {s = 46;}

                        else if ( (LA22_42=='\t'||LA22_42==' ') ) {s = 42;}

                        else if ( (LA22_42=='\n'||LA22_42=='\r'||(LA22_42>='\"' && LA22_42<='#')||(LA22_42>='(' && LA22_42<=')')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_81>='\u0000' && LA22_81<='\b')||(LA22_81>='\u000B' && LA22_81<='\f')||(LA22_81>='\u000E' && LA22_81<='\u001F')||LA22_81=='!'||(LA22_81>='$' && LA22_81<='\'')||(LA22_81>='*' && LA22_81<='+')||(LA22_81>='-' && LA22_81<='9')||(LA22_81>=';' && LA22_81<='=')||(LA22_81>='?' && LA22_81<='Z')||(LA22_81>='^' && LA22_81<='z')||LA22_81=='|'||(LA22_81>='~' && LA22_81<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_81=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_81==':'||LA22_81=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_81==','||LA22_81=='['||LA22_81==']'||LA22_81=='{'||LA22_81=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_81=='\t'||LA22_81==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA22_81=='\n'||LA22_81=='\r'||(LA22_81>='\"' && LA22_81<='#')||(LA22_81>='(' && LA22_81<=')')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_9>='\u0000' && LA22_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 34;

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA22_52 = input.LA(1);

                         
                        int index22_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_52=='\t'||LA22_52==' ') ) {s = 105;}

                        else if ( ((LA22_52>='\u0000' && LA22_52<='\b')||(LA22_52>='\u000B' && LA22_52<='\f')||(LA22_52>='\u000E' && LA22_52<='\u001F')||LA22_52=='!'||(LA22_52>='$' && LA22_52<='\'')||(LA22_52>='*' && LA22_52<='+')||(LA22_52>='-' && LA22_52<='9')||(LA22_52>=';' && LA22_52<='=')||(LA22_52>='?' && LA22_52<='Z')||(LA22_52>='^' && LA22_52<='z')||LA22_52=='|'||(LA22_52>='~' && LA22_52<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_52=='\\') ) {s = 107;}

                        else if ( (LA22_52==':'||LA22_52=='>') ) {s = 108;}

                        else if ( (LA22_52==','||LA22_52=='['||LA22_52==']'||LA22_52=='{'||LA22_52=='}') ) {s = 109;}

                        else if ( (LA22_52=='\n'||LA22_52=='\r'||(LA22_52>='\"' && LA22_52<='#')||(LA22_52>='(' && LA22_52<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_52);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_90=='\n'||LA22_90=='\r'||(LA22_90>='\"' && LA22_90<='#')||(LA22_90>='(' && LA22_90<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_90=='\t'||LA22_90==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_90>='\u0000' && LA22_90<='\b')||(LA22_90>='\u000B' && LA22_90<='\f')||(LA22_90>='\u000E' && LA22_90<='\u001F')||LA22_90=='!'||(LA22_90>='$' && LA22_90<='\'')||(LA22_90>='*' && LA22_90<='+')||(LA22_90>='-' && LA22_90<='9')||(LA22_90>=';' && LA22_90<='=')||(LA22_90>='?' && LA22_90<='Z')||(LA22_90>='^' && LA22_90<='z')||LA22_90=='|'||(LA22_90>='~' && LA22_90<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_90=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_90==':'||LA22_90=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_90==','||LA22_90=='['||LA22_90==']'||LA22_90=='{'||LA22_90=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else s = 80;

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0=='#') ) {s = 1;}

                        else if ( (LA22_0=='%') ) {s = 2;}

                        else if ( (LA22_0=='\r') ) {s = 3;}

                        else if ( (LA22_0=='\n') ) {s = 4;}

                        else if ( (LA22_0=='\"') ) {s = 5;}

                        else if ( (LA22_0==' ') ) {s = 6;}

                        else if ( (LA22_0=='-') ) {s = 7;}

                        else if ( (LA22_0=='\t') ) {s = 8;}

                        else if ( (LA22_0=='(') ) {s = 9;}

                        else if ( (LA22_0==')') ) {s = 10;}

                        else if ( (LA22_0==',') ) {s = 11;}

                        else if ( (LA22_0==':') ) {s = 12;}

                        else if ( (LA22_0=='>') ) {s = 13;}

                        else if ( (LA22_0=='*') ) {s = 14;}

                        else if ( (LA22_0=='@') ) {s = 15;}

                        else if ( (LA22_0=='+') ) {s = 16;}

                        else if ( (LA22_0=='[') ) {s = 17;}

                        else if ( (LA22_0==']') ) {s = 18;}

                        else if ( (LA22_0=='?') ) {s = 19;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||LA22_0=='$'||LA22_0=='&'||(LA22_0>='.' && LA22_0<='9')||(LA22_0>=';' && LA22_0<='=')||(LA22_0>='A' && LA22_0<='Z')||(LA22_0>='^' && LA22_0<='z')||LA22_0=='|'||(LA22_0>='~' && LA22_0<='\uFFFF')) ) {s = 20;}

                        else if ( (LA22_0=='\\') ) {s = 21;}

                        else if ( (LA22_0=='{') && ((( isOutValue() )||( isHead() )))) {s = 22;}

                        else if ( (LA22_0=='\''||LA22_0=='}') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA22_117 = input.LA(1);

                         
                        int index22_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_117=='\t'||LA22_117==' ') ) {s = 105;}

                        else if ( ((LA22_117>='\u0000' && LA22_117<='\b')||(LA22_117>='\u000B' && LA22_117<='\f')||(LA22_117>='\u000E' && LA22_117<='\u001F')||LA22_117=='!'||(LA22_117>='$' && LA22_117<='\'')||(LA22_117>='*' && LA22_117<='+')||(LA22_117>='-' && LA22_117<='9')||(LA22_117>=';' && LA22_117<='=')||(LA22_117>='?' && LA22_117<='Z')||(LA22_117>='^' && LA22_117<='z')||LA22_117=='|'||(LA22_117>='~' && LA22_117<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_117=='\\') ) {s = 107;}

                        else if ( (LA22_117==':'||LA22_117=='>') ) {s = 108;}

                        else if ( (LA22_117==','||LA22_117=='['||LA22_117==']'||LA22_117=='{'||LA22_117=='}') ) {s = 109;}

                        else if ( (LA22_117=='\n'||LA22_117=='\r'||(LA22_117>='\"' && LA22_117<='#')||(LA22_117>='(' && LA22_117<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_117);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA22_43 = input.LA(1);

                         
                        int index22_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_43=='\t'||LA22_43==' ') ) {s = 42;}

                        else if ( ((LA22_43>='\u0000' && LA22_43<='\b')||(LA22_43>='\u000B' && LA22_43<='\f')||(LA22_43>='\u000E' && LA22_43<='\u001F')||LA22_43=='!'||(LA22_43>='$' && LA22_43<='\'')||(LA22_43>='*' && LA22_43<='+')||(LA22_43>='-' && LA22_43<='9')||(LA22_43>=';' && LA22_43<='=')||(LA22_43>='?' && LA22_43<='Z')||(LA22_43>='^' && LA22_43<='z')||LA22_43=='|'||(LA22_43>='~' && LA22_43<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_43=='\\') ) {s = 44;}

                        else if ( (LA22_43==':'||LA22_43=='>') ) {s = 45;}

                        else if ( (LA22_43==','||LA22_43=='['||LA22_43==']'||LA22_43=='{'||LA22_43=='}') ) {s = 46;}

                        else if ( (LA22_43=='\n'||LA22_43=='\r'||(LA22_43>='\"' && LA22_43<='#')||(LA22_43>='(' && LA22_43<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_43);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA22_82 = input.LA(1);

                         
                        int index22_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_82=='\t'||LA22_82==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_82>='\u0000' && LA22_82<='\b')||(LA22_82>='\u000B' && LA22_82<='\f')||(LA22_82>='\u000E' && LA22_82<='\u001F')||LA22_82=='!'||(LA22_82>='$' && LA22_82<='\'')||(LA22_82>='*' && LA22_82<='+')||(LA22_82>='-' && LA22_82<='9')||(LA22_82>=';' && LA22_82<='=')||(LA22_82>='?' && LA22_82<='Z')||(LA22_82>='^' && LA22_82<='z')||LA22_82=='|'||(LA22_82>='~' && LA22_82<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_82=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_82==':'||LA22_82=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_82==','||LA22_82=='['||LA22_82==']'||LA22_82=='{'||LA22_82=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_82=='\n'||LA22_82=='\r'||(LA22_82>='\"' && LA22_82<='#')||(LA22_82>='(' && LA22_82<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_82);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA22_134 = input.LA(1);

                         
                        int index22_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_134=='\t'||LA22_134==' ') ) {s = 105;}

                        else if ( ((LA22_134>='\u0000' && LA22_134<='\b')||(LA22_134>='\u000B' && LA22_134<='\f')||(LA22_134>='\u000E' && LA22_134<='\u001F')||LA22_134=='!'||(LA22_134>='$' && LA22_134<='\'')||(LA22_134>='*' && LA22_134<='+')||(LA22_134>='-' && LA22_134<='9')||(LA22_134>=';' && LA22_134<='=')||(LA22_134>='?' && LA22_134<='Z')||(LA22_134>='^' && LA22_134<='z')||LA22_134=='|'||(LA22_134>='~' && LA22_134<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_134=='\\') ) {s = 107;}

                        else if ( (LA22_134==':'||LA22_134=='>') ) {s = 108;}

                        else if ( (LA22_134==','||LA22_134=='['||LA22_134==']'||LA22_134=='{'||LA22_134=='}') ) {s = 109;}

                        else if ( (LA22_134=='\n'||LA22_134=='\r'||(LA22_134>='\"' && LA22_134<='#')||(LA22_134>='(' && LA22_134<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_134);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA22_20 = input.LA(1);

                         
                        int index22_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_20=='\t'||LA22_20==' ') ) {s = 42;}

                        else if ( ((LA22_20>='\u0000' && LA22_20<='\b')||(LA22_20>='\u000B' && LA22_20<='\f')||(LA22_20>='\u000E' && LA22_20<='\u001F')||LA22_20=='!'||(LA22_20>='$' && LA22_20<='\'')||(LA22_20>='*' && LA22_20<='+')||(LA22_20>='-' && LA22_20<='9')||(LA22_20>=';' && LA22_20<='=')||(LA22_20>='?' && LA22_20<='Z')||(LA22_20>='^' && LA22_20<='z')||LA22_20=='|'||(LA22_20>='~' && LA22_20<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_20=='\\') ) {s = 44;}

                        else if ( (LA22_20==':'||LA22_20=='>') ) {s = 45;}

                        else if ( (LA22_20==','||LA22_20=='['||LA22_20==']'||LA22_20=='{'||LA22_20=='}') ) {s = 46;}

                        else if ( (LA22_20=='\n'||LA22_20=='\r'||(LA22_20>='\"' && LA22_20<='#')||(LA22_20>='(' && LA22_20<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_20);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA22_123 = input.LA(1);

                         
                        int index22_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_123=='\t'||LA22_123==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_123>='\u0000' && LA22_123<='\b')||(LA22_123>='\u000B' && LA22_123<='\f')||(LA22_123>='\u000E' && LA22_123<='\u001F')||LA22_123=='!'||(LA22_123>='$' && LA22_123<='\'')||(LA22_123>='*' && LA22_123<='+')||(LA22_123>='-' && LA22_123<='9')||(LA22_123>=';' && LA22_123<='=')||(LA22_123>='?' && LA22_123<='Z')||(LA22_123>='^' && LA22_123<='z')||LA22_123=='|'||(LA22_123>='~' && LA22_123<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_123=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_123==':'||LA22_123=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_123==','||LA22_123=='['||LA22_123==']'||LA22_123=='{'||LA22_123=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_123=='\n'||LA22_123=='\r'||(LA22_123>='\"' && LA22_123<='#')||(LA22_123>='(' && LA22_123<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_123);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA22_97 = input.LA(1);

                         
                        int index22_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_97=='\t'||LA22_97==' ') ) {s = 42;}

                        else if ( ((LA22_97>='\u0000' && LA22_97<='\b')||(LA22_97>='\u000B' && LA22_97<='\f')||(LA22_97>='\u000E' && LA22_97<='\u001F')||LA22_97=='!'||(LA22_97>='$' && LA22_97<='\'')||(LA22_97>='*' && LA22_97<='+')||(LA22_97>='-' && LA22_97<='9')||(LA22_97>=';' && LA22_97<='=')||(LA22_97>='?' && LA22_97<='Z')||(LA22_97>='^' && LA22_97<='z')||LA22_97=='|'||(LA22_97>='~' && LA22_97<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_97=='\\') ) {s = 44;}

                        else if ( (LA22_97==':'||LA22_97=='>') ) {s = 45;}

                        else if ( (LA22_97==','||LA22_97=='['||LA22_97==']'||LA22_97=='{'||LA22_97=='}') ) {s = 46;}

                        else if ( (LA22_97=='\n'||LA22_97=='\r'||(LA22_97>='\"' && LA22_97<='#')||(LA22_97>='(' && LA22_97<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_97);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA22_16 = input.LA(1);

                         
                        int index22_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_16=='\t'||LA22_16==' ') ) {s = 42;}

                        else if ( ((LA22_16>='\u0000' && LA22_16<='\b')||(LA22_16>='\u000B' && LA22_16<='\f')||(LA22_16>='\u000E' && LA22_16<='\u001F')||LA22_16=='!'||(LA22_16>='$' && LA22_16<='\'')||(LA22_16>='*' && LA22_16<='+')||(LA22_16>='-' && LA22_16<='9')||(LA22_16>=';' && LA22_16<='=')||(LA22_16>='?' && LA22_16<='Z')||(LA22_16>='^' && LA22_16<='z')||LA22_16=='|'||(LA22_16>='~' && LA22_16<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_16=='\\') ) {s = 44;}

                        else if ( (LA22_16==':'||LA22_16=='>') ) {s = 45;}

                        else if ( (LA22_16==','||LA22_16=='['||LA22_16==']'||LA22_16=='{'||LA22_16=='}') ) {s = 46;}

                        else if ( (LA22_16=='\n'||LA22_16=='\r'||(LA22_16>='\"' && LA22_16<='#')||(LA22_16>='(' && LA22_16<=')')) && (( isHead() ))) {s = 23;}

                        else s = 48;

                         
                        input.seek(index22_16);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA22_61 = input.LA(1);

                         
                        int index22_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_61=='\n'||LA22_61=='\r'||(LA22_61>='\"' && LA22_61<='#')||(LA22_61>='(' && LA22_61<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_61=='\t'||LA22_61==' ') ) {s = 42;}

                        else if ( ((LA22_61>='\u0000' && LA22_61<='\b')||(LA22_61>='\u000B' && LA22_61<='\f')||(LA22_61>='\u000E' && LA22_61<='\u001F')||LA22_61=='!'||(LA22_61>='$' && LA22_61<='\'')||(LA22_61>='*' && LA22_61<='+')||(LA22_61>='-' && LA22_61<='9')||(LA22_61>=';' && LA22_61<='=')||(LA22_61>='?' && LA22_61<='Z')||(LA22_61>='^' && LA22_61<='z')||LA22_61=='|'||(LA22_61>='~' && LA22_61<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_61=='\\') ) {s = 44;}

                        else if ( (LA22_61==':'||LA22_61=='>') ) {s = 45;}

                        else if ( (LA22_61==','||LA22_61=='['||LA22_61==']'||LA22_61=='{'||LA22_61=='}') ) {s = 46;}

                        else s = 56;

                         
                        input.seek(index22_61);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA22_19 = input.LA(1);

                         
                        int index22_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_19=='\t'||LA22_19==' ') ) {s = 42;}

                        else if ( ((LA22_19>='\u0000' && LA22_19<='\b')||(LA22_19>='\u000B' && LA22_19<='\f')||(LA22_19>='\u000E' && LA22_19<='\u001F')||LA22_19=='!'||(LA22_19>='$' && LA22_19<='\'')||(LA22_19>='*' && LA22_19<='+')||(LA22_19>='-' && LA22_19<='9')||(LA22_19>=';' && LA22_19<='=')||(LA22_19>='?' && LA22_19<='Z')||(LA22_19>='^' && LA22_19<='z')||LA22_19=='|'||(LA22_19>='~' && LA22_19<='\uFFFF')) ) {s = 52;}

                        else if ( (LA22_19=='\\') ) {s = 53;}

                        else if ( (LA22_19==':'||LA22_19=='>') ) {s = 54;}

                        else if ( (LA22_19==','||LA22_19=='['||LA22_19==']'||LA22_19=='{'||LA22_19=='}') ) {s = 55;}

                        else if ( (LA22_19=='#'||(LA22_19>='(' && LA22_19<=')')) && ((( isOutValue() )||( isHead() )))) {s = 37;}

                        else if ( (LA22_19=='\n'||LA22_19=='\r'||LA22_19=='\"') && (( isHead() ))) {s = 23;}

                        else s = 51;

                         
                        input.seek(index22_19);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_75=='\"') ) {s = 29;}

                        else if ( ((LA22_75>='\u0000' && LA22_75<='\t')||(LA22_75>='\u000B' && LA22_75<='\f')||(LA22_75>='\u000E' && LA22_75<='!')||(LA22_75>='#' && LA22_75<='[')||(LA22_75>=']' && LA22_75<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_75=='\\') ) {s = 28;}

                        else if ( (LA22_75=='\n'||LA22_75=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_75);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_116=='\t'||LA22_116==' ') ) {s = 105;}

                        else if ( ((LA22_116>='\u0000' && LA22_116<='\b')||(LA22_116>='\u000B' && LA22_116<='\f')||(LA22_116>='\u000E' && LA22_116<='\u001F')||LA22_116=='!'||(LA22_116>='$' && LA22_116<='\'')||(LA22_116>='*' && LA22_116<='+')||(LA22_116>='-' && LA22_116<='9')||(LA22_116>=';' && LA22_116<='=')||(LA22_116>='?' && LA22_116<='Z')||(LA22_116>='^' && LA22_116<='z')||LA22_116=='|'||(LA22_116>='~' && LA22_116<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_116=='\\') ) {s = 107;}

                        else if ( (LA22_116==':'||LA22_116=='>') ) {s = 108;}

                        else if ( (LA22_116==','||LA22_116=='['||LA22_116==']'||LA22_116=='{'||LA22_116=='}') ) {s = 109;}

                        else if ( (LA22_116=='\n'||LA22_116=='\r'||(LA22_116>='\"' && LA22_116<='#')||(LA22_116>='(' && LA22_116<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA22_70 = input.LA(1);

                         
                        int index22_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_70=='\"') ) {s = 29;}

                        else if ( ((LA22_70>='\u0000' && LA22_70<='\t')||(LA22_70>='\u000B' && LA22_70<='\f')||(LA22_70>='\u000E' && LA22_70<='!')||(LA22_70>='#' && LA22_70<='[')||(LA22_70>=']' && LA22_70<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_70=='\\') ) {s = 28;}

                        else if ( (LA22_70=='\n'||LA22_70=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_70);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA22_136 = input.LA(1);

                         
                        int index22_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_136=='\t'||LA22_136==' ') ) {s = 105;}

                        else if ( ((LA22_136>='\u0000' && LA22_136<='\b')||(LA22_136>='\u000B' && LA22_136<='\f')||(LA22_136>='\u000E' && LA22_136<='\u001F')||LA22_136=='!'||(LA22_136>='$' && LA22_136<='\'')||(LA22_136>='*' && LA22_136<='+')||(LA22_136>='-' && LA22_136<='9')||(LA22_136>=';' && LA22_136<='=')||(LA22_136>='?' && LA22_136<='Z')||(LA22_136>='^' && LA22_136<='z')||LA22_136=='|'||(LA22_136>='~' && LA22_136<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_136=='\\') ) {s = 107;}

                        else if ( (LA22_136==':'||LA22_136=='>') ) {s = 108;}

                        else if ( (LA22_136==','||LA22_136=='['||LA22_136==']'||LA22_136=='{'||LA22_136=='}') ) {s = 109;}

                        else if ( (LA22_136=='\n'||LA22_136=='\r'||(LA22_136>='\"' && LA22_136<='#')||(LA22_136>='(' && LA22_136<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_136);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA22_115 = input.LA(1);

                         
                        int index22_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_115=='\n'||LA22_115=='\r'||(LA22_115>='\"' && LA22_115<='#')||(LA22_115>='(' && LA22_115<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_115=='\t'||LA22_115==' ') ) {s = 105;}

                        else if ( ((LA22_115>='\u0000' && LA22_115<='\b')||(LA22_115>='\u000B' && LA22_115<='\f')||(LA22_115>='\u000E' && LA22_115<='\u001F')||LA22_115=='!'||(LA22_115>='$' && LA22_115<='\'')||(LA22_115>='*' && LA22_115<='+')||(LA22_115>='-' && LA22_115<='9')||(LA22_115>=';' && LA22_115<='=')||(LA22_115>='?' && LA22_115<='Z')||(LA22_115>='^' && LA22_115<='z')||LA22_115=='|'||(LA22_115>='~' && LA22_115<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_115=='\\') ) {s = 107;}

                        else if ( (LA22_115==':'||LA22_115=='>') ) {s = 108;}

                        else if ( (LA22_115==','||LA22_115=='['||LA22_115==']'||LA22_115=='{'||LA22_115=='}') ) {s = 109;}

                        else s = 104;

                         
                        input.seek(index22_115);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA22_29 = input.LA(1);

                         
                        int index22_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_29>='\u0000' && LA22_29<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 77;

                         
                        input.seek(index22_29);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA22_88 = input.LA(1);

                         
                        int index22_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_88=='\t'||LA22_88==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_88>='\u0000' && LA22_88<='\b')||(LA22_88>='\u000B' && LA22_88<='\f')||(LA22_88>='\u000E' && LA22_88<='\u001F')||LA22_88=='!'||(LA22_88>='$' && LA22_88<='\'')||(LA22_88>='*' && LA22_88<='+')||(LA22_88>='-' && LA22_88<='9')||(LA22_88>=';' && LA22_88<='=')||(LA22_88>='?' && LA22_88<='Z')||(LA22_88>='^' && LA22_88<='z')||LA22_88=='|'||(LA22_88>='~' && LA22_88<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_88=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_88==':'||LA22_88=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_88==','||LA22_88=='['||LA22_88==']'||LA22_88=='{'||LA22_88=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_88=='\n'||LA22_88=='\r'||(LA22_88>='\"' && LA22_88<='#')||(LA22_88>='(' && LA22_88<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_88);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA22_32 = input.LA(1);

                         
                        int index22_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_32=='\n'||LA22_32=='\r') ) {s = 31;}

                        else if ( (LA22_32==' ') ) {s = 32;}

                        else if ( (LA22_32=='-') ) {s = 7;}

                        else if ( (LA22_32=='\t') ) {s = 33;}

                        else if ( ((LA22_32>='\u0000' && LA22_32<='\b')||(LA22_32>='\u000B' && LA22_32<='\f')||(LA22_32>='\u000E' && LA22_32<='\u001F')||(LA22_32>='!' && LA22_32<='\"')||LA22_32=='$'||(LA22_32>='&' && LA22_32<=',')||(LA22_32>='.' && LA22_32<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 78;

                         
                        input.seek(index22_32);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_111=='\t'||LA22_111==' ') ) {s = 105;}

                        else if ( ((LA22_111>='\u0000' && LA22_111<='\b')||(LA22_111>='\u000B' && LA22_111<='\f')||(LA22_111>='\u000E' && LA22_111<='\u001F')||LA22_111=='!'||(LA22_111>='$' && LA22_111<='\'')||(LA22_111>='*' && LA22_111<='+')||(LA22_111>='-' && LA22_111<='9')||(LA22_111>=';' && LA22_111<='=')||(LA22_111>='?' && LA22_111<='Z')||(LA22_111>='^' && LA22_111<='z')||LA22_111=='|'||(LA22_111>='~' && LA22_111<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_111=='\\') ) {s = 107;}

                        else if ( (LA22_111==':'||LA22_111=='>') ) {s = 108;}

                        else if ( (LA22_111==','||LA22_111=='['||LA22_111==']'||LA22_111=='{'||LA22_111=='}') ) {s = 109;}

                        else if ( (LA22_111=='\n'||LA22_111=='\r'||(LA22_111>='\"' && LA22_111<='#')||(LA22_111>='(' && LA22_111<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA22_143 = input.LA(1);

                         
                        int index22_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_143>='\u0000' && LA22_143<='/')||(LA22_143>=':' && LA22_143<='@')||(LA22_143>='G' && LA22_143<='`')||(LA22_143>='g' && LA22_143<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_143>='0' && LA22_143<='9')||(LA22_143>='A' && LA22_143<='F')||(LA22_143>='a' && LA22_143<='f')) ) {s = 150;}

                         
                        input.seek(index22_143);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_8=='\n'||LA22_8=='\r') ) {s = 31;}

                        else if ( (LA22_8=='\t'||LA22_8==' ') ) {s = 33;}

                        else if ( ((LA22_8>='\u0000' && LA22_8<='\b')||(LA22_8>='\u000B' && LA22_8<='\f')||(LA22_8>='\u000E' && LA22_8<='\u001F')||(LA22_8>='!' && LA22_8<='\"')||LA22_8=='$'||(LA22_8>='&' && LA22_8<=',')||(LA22_8>='.' && LA22_8<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 30;

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA22_163 = input.LA(1);

                         
                        int index22_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_163=='\t'||LA22_163==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_163>='\u0000' && LA22_163<='\b')||(LA22_163>='\u000B' && LA22_163<='\f')||(LA22_163>='\u000E' && LA22_163<='\u001F')||LA22_163=='!'||(LA22_163>='$' && LA22_163<='\'')||(LA22_163>='*' && LA22_163<='+')||(LA22_163>='-' && LA22_163<='9')||(LA22_163>=';' && LA22_163<='=')||(LA22_163>='?' && LA22_163<='Z')||(LA22_163>='^' && LA22_163<='z')||LA22_163=='|'||(LA22_163>='~' && LA22_163<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_163=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_163==':'||LA22_163=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_163==','||LA22_163=='['||LA22_163==']'||LA22_163=='{'||LA22_163=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_163=='\n'||LA22_163=='\r'||(LA22_163>='\"' && LA22_163<='#')||(LA22_163>='(' && LA22_163<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_163);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA22_160 = input.LA(1);

                         
                        int index22_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_160=='\t'||LA22_160==' ') ) {s = 42;}

                        else if ( ((LA22_160>='\u0000' && LA22_160<='\b')||(LA22_160>='\u000B' && LA22_160<='\f')||(LA22_160>='\u000E' && LA22_160<='\u001F')||LA22_160=='!'||(LA22_160>='$' && LA22_160<='\'')||(LA22_160>='*' && LA22_160<='+')||(LA22_160>='-' && LA22_160<='9')||(LA22_160>=';' && LA22_160<='=')||(LA22_160>='?' && LA22_160<='Z')||(LA22_160>='^' && LA22_160<='z')||LA22_160=='|'||(LA22_160>='~' && LA22_160<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_160=='\\') ) {s = 44;}

                        else if ( (LA22_160==':'||LA22_160=='>') ) {s = 45;}

                        else if ( (LA22_160==','||LA22_160=='['||LA22_160==']'||LA22_160=='{'||LA22_160=='}') ) {s = 46;}

                        else if ( (LA22_160=='\n'||LA22_160=='\r'||(LA22_160>='\"' && LA22_160<='#')||(LA22_160>='(' && LA22_160<=')')) && (( isHead() ))) {s = 23;}

                        else s = 56;

                         
                        input.seek(index22_160);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA22_139 = input.LA(1);

                         
                        int index22_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_139=='\t'||LA22_139==' ') ) {s = 105;}

                        else if ( ((LA22_139>='\u0000' && LA22_139<='\b')||(LA22_139>='\u000B' && LA22_139<='\f')||(LA22_139>='\u000E' && LA22_139<='\u001F')||LA22_139=='!'||(LA22_139>='$' && LA22_139<='\'')||(LA22_139>='*' && LA22_139<='+')||(LA22_139>='-' && LA22_139<='9')||(LA22_139>=';' && LA22_139<='=')||(LA22_139>='?' && LA22_139<='Z')||(LA22_139>='^' && LA22_139<='z')||LA22_139=='|'||(LA22_139>='~' && LA22_139<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_139=='\\') ) {s = 107;}

                        else if ( (LA22_139==':'||LA22_139=='>') ) {s = 108;}

                        else if ( (LA22_139==','||LA22_139=='['||LA22_139==']'||LA22_139=='{'||LA22_139=='}') ) {s = 109;}

                        else if ( (LA22_139=='\n'||LA22_139=='\r'||(LA22_139>='\"' && LA22_139<='#')||(LA22_139>='(' && LA22_139<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_139);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA22_86 = input.LA(1);

                         
                        int index22_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_86=='\t'||LA22_86==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_86>='\u0000' && LA22_86<='\b')||(LA22_86>='\u000B' && LA22_86<='\f')||(LA22_86>='\u000E' && LA22_86<='\u001F')||LA22_86=='!'||(LA22_86>='$' && LA22_86<='\'')||(LA22_86>='*' && LA22_86<='+')||(LA22_86>='-' && LA22_86<='9')||(LA22_86>=';' && LA22_86<='=')||(LA22_86>='?' && LA22_86<='Z')||(LA22_86>='^' && LA22_86<='z')||LA22_86=='|'||(LA22_86>='~' && LA22_86<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_86=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_86==':'||LA22_86=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_86==','||LA22_86=='['||LA22_86==']'||LA22_86=='{'||LA22_86=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else if ( (LA22_86=='\n'||LA22_86=='\r'||(LA22_86>='\"' && LA22_86<='#')||(LA22_86>='(' && LA22_86<=')')) && (( isHead() ))) {s = 23;}

                        else s = 80;

                         
                        input.seek(index22_86);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA22_126 = input.LA(1);

                         
                        int index22_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_126=='\n'||LA22_126=='\r'||(LA22_126>='\"' && LA22_126<='#')||(LA22_126>='(' && LA22_126<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_126=='\t'||LA22_126==' ') && ((( isOutValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_126>='\u0000' && LA22_126<='\b')||(LA22_126>='\u000B' && LA22_126<='\f')||(LA22_126>='\u000E' && LA22_126<='\u001F')||LA22_126=='!'||(LA22_126>='$' && LA22_126<='\'')||(LA22_126>='*' && LA22_126<='+')||(LA22_126>='-' && LA22_126<='9')||(LA22_126>=';' && LA22_126<='=')||(LA22_126>='?' && LA22_126<='Z')||(LA22_126>='^' && LA22_126<='z')||LA22_126=='|'||(LA22_126>='~' && LA22_126<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 82;}

                        else if ( (LA22_126=='\\') && ((( isOutValue() )||( isHead() )))) {s = 83;}

                        else if ( (LA22_126==':'||LA22_126=='>') && ((( isOutValue() )||( isHead() )))) {s = 84;}

                        else if ( (LA22_126==','||LA22_126=='['||LA22_126==']'||LA22_126=='{'||LA22_126=='}') && ((( isOutValue() )||( isHead() )))) {s = 85;}

                        else s = 80;

                         
                        input.seek(index22_126);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA22_100 = input.LA(1);

                         
                        int index22_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_100=='\n'||LA22_100=='\r'||(LA22_100>='\"' && LA22_100<='#')||(LA22_100>='(' && LA22_100<=')')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_100=='\t'||LA22_100==' ') ) {s = 42;}

                        else if ( ((LA22_100>='\u0000' && LA22_100<='\b')||(LA22_100>='\u000B' && LA22_100<='\f')||(LA22_100>='\u000E' && LA22_100<='\u001F')||LA22_100=='!'||(LA22_100>='$' && LA22_100<='\'')||(LA22_100>='*' && LA22_100<='+')||(LA22_100>='-' && LA22_100<='9')||(LA22_100>=';' && LA22_100<='=')||(LA22_100>='?' && LA22_100<='Z')||(LA22_100>='^' && LA22_100<='z')||LA22_100=='|'||(LA22_100>='~' && LA22_100<='\uFFFF')) ) {s = 43;}

                        else if ( (LA22_100=='\\') ) {s = 44;}

                        else if ( (LA22_100==':'||LA22_100=='>') ) {s = 45;}

                        else if ( (LA22_100==','||LA22_100=='['||LA22_100==']'||LA22_100=='{'||LA22_100=='}') ) {s = 46;}

                        else s = 56;

                         
                        input.seek(index22_100);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA22_38 = input.LA(1);

                         
                        int index22_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_38>='\u0000' && LA22_38<='!')||(LA22_38>='#' && LA22_38<='.')||(LA22_38>='0' && LA22_38<='[')||(LA22_38>=']' && LA22_38<='a')||(LA22_38>='c' && LA22_38<='e')||(LA22_38>='g' && LA22_38<='m')||(LA22_38>='o' && LA22_38<='q')||LA22_38=='s'||(LA22_38>='v' && LA22_38<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_38=='\"') && ((( isOutValue() )||( isHead() )))) {s = 86;}

                        else if ( (LA22_38=='\\') && ((( isOutValue() )||( isHead() )))) {s = 87;}

                        else if ( (LA22_38=='/') && ((( isOutValue() )||( isHead() )))) {s = 88;}

                        else if ( (LA22_38=='b') && ((( isOutValue() )||( isHead() )))) {s = 89;}

                        else if ( (LA22_38=='f') && ((( isOutValue() )||( isHead() )))) {s = 90;}

                        else if ( (LA22_38=='n') && ((( isOutValue() )||( isHead() )))) {s = 91;}

                        else if ( (LA22_38=='r') && ((( isOutValue() )||( isHead() )))) {s = 92;}

                        else if ( (LA22_38=='t') && ((( isOutValue() )||( isHead() )))) {s = 93;}

                        else if ( (LA22_38=='u') && ((( isOutValue() )||( isHead() )))) {s = 94;}

                         
                        input.seek(index22_38);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA22_10 = input.LA(1);

                         
                        int index22_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_10>='\u0000' && LA22_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 35;

                         
                        input.seek(index22_10);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA22_27 = input.LA(1);

                         
                        int index22_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_27=='\n'||LA22_27=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_27=='\"') ) {s = 29;}

                        else if ( ((LA22_27>='\u0000' && LA22_27<='\t')||(LA22_27>='\u000B' && LA22_27<='\f')||(LA22_27>='\u000E' && LA22_27<='!')||(LA22_27>='#' && LA22_27<='[')||(LA22_27>=']' && LA22_27<='\uFFFF')) ) {s = 27;}

                        else if ( (LA22_27=='\\') ) {s = 28;}

                         
                        input.seek(index22_27);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA22_129 = input.LA(1);

                         
                        int index22_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_129>='\u0000' && LA22_129<='/')||(LA22_129>=':' && LA22_129<='@')||(LA22_129>='G' && LA22_129<='`')||(LA22_129>='g' && LA22_129<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_129>='0' && LA22_129<='9')||(LA22_129>='A' && LA22_129<='F')||(LA22_129>='a' && LA22_129<='f')) && ((( isOutValue() )||( isHead() )))) {s = 144;}

                         
                        input.seek(index22_129);
                        if ( s>=0 ) return s;
                        break;
                    case 137 : 
                        int LA22_103 = input.LA(1);

                         
                        int index22_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_103>='\u0000' && LA22_103<='/')||(LA22_103>=':' && LA22_103<='@')||(LA22_103>='G' && LA22_103<='`')||(LA22_103>='g' && LA22_103<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_103>='0' && LA22_103<='9')||(LA22_103>='A' && LA22_103<='F')||(LA22_103>='a' && LA22_103<='f')) ) {s = 131;}

                         
                        input.seek(index22_103);
                        if ( s>=0 ) return s;
                        break;
                    case 138 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_55=='\t'||LA22_55==' ') ) {s = 105;}

                        else if ( ((LA22_55>='\u0000' && LA22_55<='\b')||(LA22_55>='\u000B' && LA22_55<='\f')||(LA22_55>='\u000E' && LA22_55<='\u001F')||LA22_55=='!'||(LA22_55>='$' && LA22_55<='\'')||(LA22_55>='*' && LA22_55<='+')||(LA22_55>='-' && LA22_55<='9')||(LA22_55>=';' && LA22_55<='=')||(LA22_55>='?' && LA22_55<='Z')||(LA22_55>='^' && LA22_55<='z')||LA22_55=='|'||(LA22_55>='~' && LA22_55<='\uFFFF')) ) {s = 106;}

                        else if ( (LA22_55=='\\') ) {s = 107;}

                        else if ( (LA22_55==':'||LA22_55=='>') ) {s = 108;}

                        else if ( (LA22_55==','||LA22_55=='['||LA22_55==']'||LA22_55=='{'||LA22_55=='}') ) {s = 109;}

                        else if ( (LA22_55=='\n'||LA22_55=='\r'||(LA22_55>='\"' && LA22_55<='#')||(LA22_55>='(' && LA22_55<=')')) && (( isHead() ))) {s = 23;}

                        else s = 104;

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
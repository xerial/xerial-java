// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-29 22:45:07

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
    public static final int DataType=11;
    public static final int SilkNode=5;
    public static final int SilkLine=7;
    public static final int LBracket=41;
    public static final int NodeStart=30;
    public static final int Digit=20;
    public static final int HexDigit=22;
    public static final int PlainOneLine=52;
    public static final int Plus=40;
    public static final int Occurrence=10;
    public static final int Argument=13;
    public static final int FlowIndicator=46;
    public static final int Separation=53;
    public static final int Letter=21;
    public static final int PlainSafeIn=48;
    public static final int Comma=35;
    public static final int EscapeSequence=24;
    public static final int NonSpaceChar=27;
    public static final int DataLine=32;
    public static final int PlainFirst=45;
    public static final int WhiteSpace=26;
    public static final int PlainSafeOut=49;
    public static final int Question=43;
    public static final int LineComment=16;
    public static final int Colon=36;
    public static final int At=39;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=14;
    public static final int PlainChar=51;
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
    public static final int PlainSafe=50;


    private SilkLexerState lexerContext = new SilkLexerState();

    private State currentState() { return lexerContext.getCurrentState(); } 
    private void transit(Symbol token) { System.out.println(lexerContext.transit(token)); } 
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:9: ({...}? =>~ ( '-' | '%' | '#' | ' ' | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:11: {...}? =>~ ( '-' | '%' | '#' | ' ' | LineBreakChar ) (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "DataLine", "getCharPositionInLine()==0");
            }
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:85: (~ ( '\\n' | '\\r' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:85: ~ ( '\\n' | '\\r' )
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
            	    break loop12;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | EscapeSequence )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||LA13_0=='$'||LA13_0=='&'||(LA13_0>='*' && LA13_0<='+')||(LA13_0>='.' && LA13_0<='9')||(LA13_0>=';' && LA13_0<='=')||LA13_0=='?'||(LA13_0>='A' && LA13_0<='Z')||(LA13_0>='^' && LA13_0<='z')||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {
                alt13=1;
            }
            else if ( (LA13_0=='\\') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:24: ( '(' | ')' | ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='(' && input.LA(1)<=')')||input.LA(1)==':' ) {
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

    // $ANTLR start "PlainSafeIn"
    public final void mPlainSafeIn() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:21: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | FlowIndicator ) | EscapeSequence )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='$' && LA14_0<='\'')||(LA14_0>='*' && LA14_0<='+')||(LA14_0>='-' && LA14_0<='9')||(LA14_0>=';' && LA14_0<='Z')||(LA14_0>='^' && LA14_0<='z')||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {
                alt14=1;
            }
            else if ( (LA14_0=='\\') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:23: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator | FlowIndicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:106: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator ) | EscapeSequence )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='$' && LA15_0<='\'')||(LA15_0>='*' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:90: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:2: ({...}? => PlainSafeIn | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt16=3;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:4: {...}? => PlainSafeIn
                    {
                    if ( !(( currentState() == State.KEY )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " currentState() == State.KEY ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:4: {...}? => PlainSafeIn
                    {
                    if ( !(( currentState() == State.IN )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " currentState() == State.IN ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:4: {...}? => PlainSafeOut
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:19: ( PlainSafe ( '#' )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:21: PlainSafe ( '#' )?
            {
            mPlainSafe(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:31: ( '#' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='#') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:31: '#'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:2: ( PlainFirst ( ( WhiteSpace )* PlainChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:4: PlainFirst ( ( WhiteSpace )* PlainChar )*
            {
            mPlainFirst(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:15: ( ( WhiteSpace )* PlainChar )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='$' && LA19_0<='\'')||(LA19_0>='*' && LA19_0<='+')||(LA19_0>='-' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||LA19_0=='|'||(LA19_0>='~' && LA19_0<='\uFFFF')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {
                    alt19=1;
                }
                else if ( (LA19_0=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {
                    alt19=1;
                }
                else if ( (LA19_0==','||LA19_0=='['||LA19_0==']'||LA19_0=='{'||LA19_0=='}') && (( currentState() == State.OUT ))) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:16: ( WhiteSpace )* PlainChar
            	    {
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:16: ( WhiteSpace )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0=='\t'||LA18_0==' ') ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:16: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    mPlainChar(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:11: ({...}? ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:13: {...}? ( WhiteSpace )+
            {
            if ( !(( currentState() != State.INIT )) ) {
                throw new FailedPredicateException(input, "Separation", " currentState() != State.INIT ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:47: ( WhiteSpace )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\t'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:47: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:4: ( ' ' | '\\t' )
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
        int alt21=21;
        alt21 = dfa21.predict(input);
        switch (alt21) {
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


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA16_eotS =
        "\23\uffff";
    static final String DFA16_eofS =
        "\23\uffff";
    static final String DFA16_minS =
        "\2\0\1\42\3\uffff\10\0\4\60\1\0";
    static final String DFA16_maxS =
        "\1\uffff\1\0\1\165\3\uffff\10\0\4\146\1\0";
    static final String DFA16_acceptS =
        "\3\uffff\1\3\1\1\1\2\15\uffff";
    static final String DFA16_specialS =
        "\1\5\1\11\1\12\3\uffff\1\0\1\3\1\10\1\14\1\6\1\7\1\15\1\2\1\13"+
        "\1\16\1\1\1\17\1\4}>";
    static final String[] DFA16_transitionS = {
            "\11\1\2\uffff\2\1\1\uffff\22\1\1\uffff\1\1\2\uffff\4\1\2\uffff"+
            "\2\1\1\3\15\1\1\uffff\40\1\1\3\1\2\1\3\35\1\1\3\1\1\1\3\uff82"+
            "\1",
            "\1\uffff",
            "\1\6\14\uffff\1\10\54\uffff\1\7\5\uffff\1\11\3\uffff\1\12"+
            "\7\uffff\1\13\3\uffff\1\14\1\uffff\1\15\1\16",
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
            "\12\17\7\uffff\6\17\32\uffff\6\17",
            "\12\20\7\uffff\6\20\32\uffff\6\20",
            "\12\21\7\uffff\6\21\32\uffff\6\21",
            "\12\22\7\uffff\6\22\32\uffff\6\22",
            "\1\uffff"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "204:10: fragment PlainSafe : ({...}? => PlainSafeIn | {...}? => PlainSafeIn | {...}? => PlainSafeOut );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_6 = input.LA(1);

                         
                        int index16_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_16 = input.LA(1);

                         
                        int index16_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_16>='0' && LA16_16<='9')||(LA16_16>='A' && LA16_16<='F')||(LA16_16>='a' && LA16_16<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 17;}

                         
                        input.seek(index16_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_13 = input.LA(1);

                         
                        int index16_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_7 = input.LA(1);

                         
                        int index16_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_18 = input.LA(1);

                         
                        int index16_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_18);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='$' && LA16_0<='\'')||(LA16_0>='*' && LA16_0<='+')||(LA16_0>='-' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 1;}

                        else if ( (LA16_0=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 2;}

                        else if ( (LA16_0==','||LA16_0=='['||LA16_0==']'||LA16_0=='{'||LA16_0=='}') && (( currentState() == State.OUT ))) {s = 3;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_10 = input.LA(1);

                         
                        int index16_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA16_11 = input.LA(1);

                         
                        int index16_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA16_8 = input.LA(1);

                         
                        int index16_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_2=='\"') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 6;}

                        else if ( (LA16_2=='\\') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 7;}

                        else if ( (LA16_2=='/') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 8;}

                        else if ( (LA16_2=='b') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 9;}

                        else if ( (LA16_2=='f') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 10;}

                        else if ( (LA16_2=='n') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 11;}

                        else if ( (LA16_2=='r') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 12;}

                        else if ( (LA16_2=='t') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 13;}

                        else if ( (LA16_2=='u') && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 14;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA16_14 = input.LA(1);

                         
                        int index16_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_14>='0' && LA16_14<='9')||(LA16_14>='A' && LA16_14<='F')||(LA16_14>='a' && LA16_14<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 15;}

                         
                        input.seek(index16_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA16_9 = input.LA(1);

                         
                        int index16_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_9);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA16_12 = input.LA(1);

                         
                        int index16_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() == State.KEY )) ) {s = 4;}

                        else if ( (( currentState() == State.IN )) ) {s = 5;}

                        else if ( (( currentState() == State.OUT )) ) {s = 3;}

                         
                        input.seek(index16_12);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA16_15 = input.LA(1);

                         
                        int index16_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_15>='0' && LA16_15<='9')||(LA16_15>='A' && LA16_15<='F')||(LA16_15>='a' && LA16_15<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 16;}

                         
                        input.seek(index16_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA16_17 = input.LA(1);

                         
                        int index16_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_17>='0' && LA16_17<='9')||(LA16_17>='A' && LA16_17<='F')||(LA16_17>='a' && LA16_17<='f')) && ((( currentState() == State.OUT )||( currentState() == State.KEY )||( currentState() == State.IN )))) {s = 18;}

                         
                        input.seek(index16_17);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\3\uffff\1\30\1\31\1\uffff\1\36\1\uffff\1\36\1\44\1\45\1\46\1\47"+
        "\1\50\1\52\1\56\1\57\1\60\1\61\1\62\1\63\2\uffff\1\75\4\uffff\1"+
        "\110\1\111\1\uffff\1\111\1\uffff\1\111\2\114\7\uffff\1\63\1\uffff"+
        "\1\63\6\uffff\10\63\17\uffff\1\114\1\uffff\11\63\12\uffff\1\63\1"+
        "\uffff\1\63";
    static final String DFA21_eofS =
        "\143\uffff";
    static final String DFA21_minS =
        "\1\0\2\uffff\1\12\2\0\1\11\1\uffff\16\0\1\uffff\6\0\1\11\1\0\1"+
        "\11\1\uffff\1\0\1\12\1\0\5\uffff\1\0\1\uffff\3\0\6\uffff\12\0\1"+
        "\uffff\11\0\3\uffff\30\0";
    static final String DFA21_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\uffff\1\55\1\uffff\16\uffff\1\uffff"+
        "\3\0\3\uffff\1\55\1\0\1\40\1\uffff\1\uffff\1\12\1\0\5\uffff\1\uffff"+
        "\1\uffff\3\uffff\6\uffff\11\uffff\1\0\1\uffff\11\uffff\3\uffff\2"+
        "\0\26\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\5\16\uffff\1\7\11\uffff\1\6\3\uffff"+
        "\1\10\1\11\1\12\1\13\1\14\1\uffff\1\15\3\uffff\1\16\1\17\1\20\1"+
        "\21\1\22\1\23\12\uffff\1\3\11\uffff\1\4\1\24\1\25\30\uffff";
    static final String DFA21_specialS =
        "\1\71\4\uffff\1\45\2\uffff\1\76\1\5\1\53\1\22\1\7\1\35\1\11\1\12"+
        "\1\61\1\0\1\6\1\50\1\77\1\75\2\uffff\1\31\1\30\1\13\1\62\1\27\1"+
        "\uffff\1\47\2\uffff\1\67\7\uffff\1\20\1\uffff\1\25\1\102\1\55\6"+
        "\uffff\1\42\1\66\1\63\1\26\1\44\1\46\1\101\1\64\1\56\1\32\1\uffff"+
        "\1\40\1\16\1\52\1\60\1\15\1\1\1\103\1\54\1\73\4\uffff\1\23\1\21"+
        "\1\70\1\24\1\100\1\14\1\104\1\74\1\2\1\37\1\33\1\17\1\36\1\3\1\65"+
        "\1\41\1\4\1\34\1\72\1\57\1\51\1\43\1\10}>";
    static final String[] DFA21_transitionS = {
            "\11\24\1\10\1\4\2\24\1\3\22\24\1\6\1\24\1\5\1\1\1\24\1\2\1"+
            "\24\1\26\1\11\1\12\1\16\1\20\1\13\1\7\14\24\1\14\3\24\1\15\1"+
            "\23\1\17\32\24\1\21\1\25\1\22\35\24\1\26\1\24\1\26\uff82\24",
            "",
            "",
            "\1\27",
            "\1\uffff",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\1\37\1\40\2\uffff\1\40\22\uffff\1\35\14\uffff\1\7",
            "",
            "\11\26\1\41\1\43\2\26\1\42\22\26\1\41\uffdf\26",
            "\0\26",
            "\0\26",
            "\0\26",
            "\0\26",
            "\0\26",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\0\26",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\0\26",
            "\0\26",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\42\26\1\64\14\26\1\66\54\26\1\65\5\26\1\67\3\26\1\70\7\26"+
            "\1\71\3\26\1\72\1\26\1\73\1\74\uff8a\26",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\42\26\1\77\14\26\1\101\54\26\1\100\5\26\1\102\3\26\1\103"+
            "\7\26\1\104\3\26\1\105\1\26\1\106\1\107\uff8a\26",
            "\0\26",
            "\1\37\1\40\2\uffff\1\40\22\uffff\1\35\14\uffff\1\7",
            "\1\uffff",
            "\1\37\1\40\2\uffff\1\40\22\uffff\1\37",
            "",
            "\11\26\1\41\1\43\2\26\1\42\22\26\1\41\uffdf\26",
            "\1\113",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\42\26\1\116\14\26\1\120\54\26\1\117\5\26\1\121\3\26\1\122"+
            "\7\26\1\123\3\26\1\124\1\26\1\125\1\126\uff8a\26",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\60\26\12\127\7\26\6\127\32\26\6\127\uff99\26",
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
            "\60\26\12\130\7\26\6\130\32\26\6\130\uff99\26",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53",
            "\60\26\12\131\7\26\6\131\32\26\6\131\uff99\26",
            "\60\26\12\132\7\26\6\132\32\26\6\132\uff99\26",
            "\60\26\12\133\7\26\6\133\32\26\6\133\uff99\26",
            "\60\26\12\134\7\26\6\134\32\26\6\134\uff99\26",
            "\60\26\12\135\7\26\6\135\32\26\6\135\uff99\26",
            "\60\26\12\136\7\26\6\136\32\26\6\136\uff99\26",
            "\60\26\12\137\7\26\6\137\32\26\6\137\uff99\26",
            "\60\26\12\140\7\26\6\140\32\26\6\140\uff99\26",
            "\60\26\12\141\7\26\6\141\32\26\6\141\uff99\26",
            "\60\26\12\142\7\26\6\142\32\26\6\142\uff99\26",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\2\26\4\53\2\26"+
            "\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1\53\1"+
            "\55\uff82\53",
            "\12\32\1\26\2\32\1\26\24\32\1\34\71\32\1\33\uffa3\32",
            "\11\53\1\51\1\26\2\53\1\26\22\53\1\51\1\53\1\26\1\115\4\53"+
            "\2\26\2\53\1\55\15\53\1\26\40\53\1\55\1\54\1\55\35\53\1\55\1"+
            "\53\1\55\uff82\53"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | String | NodeStart | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | PlainOneLine | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_17 = input.LA(1);

                         
                        int index21_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_17>='\u0000' && LA21_17<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 48;

                         
                        input.seek(index21_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_68 = input.LA(1);

                         
                        int index21_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_68=='\n'||LA21_68=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA21_68=='\"') ) {s = 28;}

                        else if ( ((LA21_68>='\u0000' && LA21_68<='\t')||(LA21_68>='\u000B' && LA21_68<='\f')||(LA21_68>='\u000E' && LA21_68<='!')||(LA21_68>='#' && LA21_68<='[')||(LA21_68>=']' && LA21_68<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_68=='\\') ) {s = 27;}

                         
                        input.seek(index21_68);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_84 = input.LA(1);

                         
                        int index21_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_84=='#') ) {s = 77;}

                        else if ( (LA21_84=='\t'||LA21_84==' ') ) {s = 41;}

                        else if ( ((LA21_84>='\u0000' && LA21_84<='\b')||(LA21_84>='\u000B' && LA21_84<='\f')||(LA21_84>='\u000E' && LA21_84<='\u001F')||LA21_84=='!'||(LA21_84>='$' && LA21_84<='\'')||(LA21_84>='*' && LA21_84<='+')||(LA21_84>='-' && LA21_84<='9')||(LA21_84>=';' && LA21_84<='Z')||(LA21_84>='^' && LA21_84<='z')||LA21_84=='|'||(LA21_84>='~' && LA21_84<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_84=='\\') ) {s = 44;}

                        else if ( (LA21_84==','||LA21_84=='['||LA21_84==']'||LA21_84=='{'||LA21_84=='}') ) {s = 45;}

                        else if ( (LA21_84=='\n'||LA21_84=='\r'||LA21_84=='\"'||(LA21_84>='(' && LA21_84<=')')||LA21_84==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_84);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_89 = input.LA(1);

                         
                        int index21_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_89>='0' && LA21_89<='9')||(LA21_89>='A' && LA21_89<='F')||(LA21_89>='a' && LA21_89<='f')) ) {s = 92;}

                        else if ( ((LA21_89>='\u0000' && LA21_89<='/')||(LA21_89>=':' && LA21_89<='@')||(LA21_89>='G' && LA21_89<='`')||(LA21_89>='g' && LA21_89<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_89);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_92 = input.LA(1);

                         
                        int index21_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_92>='0' && LA21_92<='9')||(LA21_92>='A' && LA21_92<='F')||(LA21_92>='a' && LA21_92<='f')) ) {s = 95;}

                        else if ( ((LA21_92>='\u0000' && LA21_92<='/')||(LA21_92>=':' && LA21_92<='@')||(LA21_92>='G' && LA21_92<='`')||(LA21_92>='g' && LA21_92<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_92);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_9>='\u0000' && LA21_9<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 36;

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_18 = input.LA(1);

                         
                        int index21_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_18>='\u0000' && LA21_18<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 49;

                         
                        input.seek(index21_18);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_12 = input.LA(1);

                         
                        int index21_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_12>='\u0000' && LA21_12<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 39;

                         
                        input.seek(index21_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA21_98 = input.LA(1);

                         
                        int index21_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_98=='#') ) {s = 77;}

                        else if ( (LA21_98=='\t'||LA21_98==' ') ) {s = 41;}

                        else if ( ((LA21_98>='\u0000' && LA21_98<='\b')||(LA21_98>='\u000B' && LA21_98<='\f')||(LA21_98>='\u000E' && LA21_98<='\u001F')||LA21_98=='!'||(LA21_98>='$' && LA21_98<='\'')||(LA21_98>='*' && LA21_98<='+')||(LA21_98>='-' && LA21_98<='9')||(LA21_98>=';' && LA21_98<='Z')||(LA21_98>='^' && LA21_98<='z')||LA21_98=='|'||(LA21_98>='~' && LA21_98<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_98=='\\') ) {s = 44;}

                        else if ( (LA21_98==','||LA21_98=='['||LA21_98==']'||LA21_98=='{'||LA21_98=='}') ) {s = 45;}

                        else if ( (LA21_98=='\n'||LA21_98=='\r'||LA21_98=='\"'||(LA21_98>='(' && LA21_98<=')')||LA21_98==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_98);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA21_14 = input.LA(1);

                         
                        int index21_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_14=='\t'||LA21_14==' ') ) {s = 41;}

                        else if ( (LA21_14=='\n'||LA21_14=='\r'||(LA21_14>='\"' && LA21_14<='#')||(LA21_14>='(' && LA21_14<=')')||LA21_14==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_14>='\u0000' && LA21_14<='\b')||(LA21_14>='\u000B' && LA21_14<='\f')||(LA21_14>='\u000E' && LA21_14<='\u001F')||LA21_14=='!'||(LA21_14>='$' && LA21_14<='\'')||(LA21_14>='*' && LA21_14<='+')||(LA21_14>='-' && LA21_14<='9')||(LA21_14>=';' && LA21_14<='Z')||(LA21_14>='^' && LA21_14<='z')||LA21_14=='|'||(LA21_14>='~' && LA21_14<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_14=='\\') ) {s = 44;}

                        else if ( (LA21_14==','||LA21_14=='['||LA21_14==']'||LA21_14=='{'||LA21_14=='}') ) {s = 45;}

                        else s = 42;

                         
                        input.seek(index21_14);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA21_15 = input.LA(1);

                         
                        int index21_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_15>='\u0000' && LA21_15<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 46;

                         
                        input.seek(index21_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA21_26 = input.LA(1);

                         
                        int index21_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_26=='\"') ) {s = 28;}

                        else if ( ((LA21_26>='\u0000' && LA21_26<='\t')||(LA21_26>='\u000B' && LA21_26<='\f')||(LA21_26>='\u000E' && LA21_26<='!')||(LA21_26>='#' && LA21_26<='[')||(LA21_26>=']' && LA21_26<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_26=='\\') ) {s = 27;}

                        else if ( (LA21_26=='\n'||LA21_26=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_26);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA21_81 = input.LA(1);

                         
                        int index21_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_81=='#') ) {s = 77;}

                        else if ( (LA21_81=='\t'||LA21_81==' ') ) {s = 41;}

                        else if ( ((LA21_81>='\u0000' && LA21_81<='\b')||(LA21_81>='\u000B' && LA21_81<='\f')||(LA21_81>='\u000E' && LA21_81<='\u001F')||LA21_81=='!'||(LA21_81>='$' && LA21_81<='\'')||(LA21_81>='*' && LA21_81<='+')||(LA21_81>='-' && LA21_81<='9')||(LA21_81>=';' && LA21_81<='Z')||(LA21_81>='^' && LA21_81<='z')||LA21_81=='|'||(LA21_81>='~' && LA21_81<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_81=='\\') ) {s = 44;}

                        else if ( (LA21_81==','||LA21_81=='['||LA21_81==']'||LA21_81=='{'||LA21_81=='}') ) {s = 45;}

                        else if ( (LA21_81=='\n'||LA21_81=='\r'||LA21_81=='\"'||(LA21_81>='(' && LA21_81<=')')||LA21_81==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_81);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA21_67 = input.LA(1);

                         
                        int index21_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_67=='\"') ) {s = 28;}

                        else if ( ((LA21_67>='\u0000' && LA21_67<='\t')||(LA21_67>='\u000B' && LA21_67<='\f')||(LA21_67>='\u000E' && LA21_67<='!')||(LA21_67>='#' && LA21_67<='[')||(LA21_67>=']' && LA21_67<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_67=='\\') ) {s = 27;}

                        else if ( (LA21_67=='\n'||LA21_67=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_67);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA21_64 = input.LA(1);

                         
                        int index21_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_64=='\"') ) {s = 28;}

                        else if ( ((LA21_64>='\u0000' && LA21_64<='\t')||(LA21_64>='\u000B' && LA21_64<='\f')||(LA21_64>='\u000E' && LA21_64<='!')||(LA21_64>='#' && LA21_64<='[')||(LA21_64>=']' && LA21_64<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_64=='\\') ) {s = 27;}

                        else if ( (LA21_64=='\n'||LA21_64=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_64);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA21_87 = input.LA(1);

                         
                        int index21_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_87>='0' && LA21_87<='9')||(LA21_87>='A' && LA21_87<='F')||(LA21_87>='a' && LA21_87<='f')) ) {s = 90;}

                        else if ( ((LA21_87>='\u0000' && LA21_87<='/')||(LA21_87>=':' && LA21_87<='@')||(LA21_87>='G' && LA21_87<='`')||(LA21_87>='g' && LA21_87<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_87);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA21_41 = input.LA(1);

                         
                        int index21_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_41>='\u0000' && LA21_41<='\b')||(LA21_41>='\u000B' && LA21_41<='\f')||(LA21_41>='\u000E' && LA21_41<='\u001F')||LA21_41=='!'||(LA21_41>='$' && LA21_41<='\'')||(LA21_41>='*' && LA21_41<='+')||(LA21_41>='-' && LA21_41<='9')||(LA21_41>=';' && LA21_41<='Z')||(LA21_41>='^' && LA21_41<='z')||LA21_41=='|'||(LA21_41>='~' && LA21_41<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_41=='\\') ) {s = 44;}

                        else if ( (LA21_41==','||LA21_41=='['||LA21_41==']'||LA21_41=='{'||LA21_41=='}') ) {s = 45;}

                        else if ( (LA21_41=='\t'||LA21_41==' ') ) {s = 41;}

                        else if ( (LA21_41=='\n'||LA21_41=='\r'||(LA21_41>='\"' && LA21_41<='#')||(LA21_41>='(' && LA21_41<=')')||LA21_41==':') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_41);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA21_77 = input.LA(1);

                         
                        int index21_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_77=='\t'||LA21_77==' ') ) {s = 41;}

                        else if ( ((LA21_77>='\u0000' && LA21_77<='\b')||(LA21_77>='\u000B' && LA21_77<='\f')||(LA21_77>='\u000E' && LA21_77<='\u001F')||LA21_77=='!'||(LA21_77>='$' && LA21_77<='\'')||(LA21_77>='*' && LA21_77<='+')||(LA21_77>='-' && LA21_77<='9')||(LA21_77>=';' && LA21_77<='Z')||(LA21_77>='^' && LA21_77<='z')||LA21_77=='|'||(LA21_77>='~' && LA21_77<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_77=='\\') ) {s = 44;}

                        else if ( (LA21_77==','||LA21_77=='['||LA21_77==']'||LA21_77=='{'||LA21_77=='}') ) {s = 45;}

                        else if ( (LA21_77=='\n'||LA21_77=='\r'||(LA21_77>='\"' && LA21_77<='#')||(LA21_77>='(' && LA21_77<=')')||LA21_77==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_77);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA21_11 = input.LA(1);

                         
                        int index21_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_11>='\u0000' && LA21_11<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 38;

                         
                        input.seek(index21_11);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA21_76 = input.LA(1);

                         
                        int index21_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 22;}

                         
                        input.seek(index21_76);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA21_79 = input.LA(1);

                         
                        int index21_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_79=='#') ) {s = 77;}

                        else if ( (LA21_79=='\t'||LA21_79==' ') ) {s = 41;}

                        else if ( ((LA21_79>='\u0000' && LA21_79<='\b')||(LA21_79>='\u000B' && LA21_79<='\f')||(LA21_79>='\u000E' && LA21_79<='\u001F')||LA21_79=='!'||(LA21_79>='$' && LA21_79<='\'')||(LA21_79>='*' && LA21_79<='+')||(LA21_79>='-' && LA21_79<='9')||(LA21_79>=';' && LA21_79<='Z')||(LA21_79>='^' && LA21_79<='z')||LA21_79=='|'||(LA21_79>='~' && LA21_79<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_79=='\\') ) {s = 44;}

                        else if ( (LA21_79==','||LA21_79=='['||LA21_79==']'||LA21_79=='{'||LA21_79=='}') ) {s = 45;}

                        else if ( (LA21_79=='\n'||LA21_79=='\r'||LA21_79=='\"'||(LA21_79>='(' && LA21_79<=')')||LA21_79==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_79);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA21_43 = input.LA(1);

                         
                        int index21_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_43=='#') ) {s = 77;}

                        else if ( (LA21_43=='\t'||LA21_43==' ') ) {s = 41;}

                        else if ( ((LA21_43>='\u0000' && LA21_43<='\b')||(LA21_43>='\u000B' && LA21_43<='\f')||(LA21_43>='\u000E' && LA21_43<='\u001F')||LA21_43=='!'||(LA21_43>='$' && LA21_43<='\'')||(LA21_43>='*' && LA21_43<='+')||(LA21_43>='-' && LA21_43<='9')||(LA21_43>=';' && LA21_43<='Z')||(LA21_43>='^' && LA21_43<='z')||LA21_43=='|'||(LA21_43>='~' && LA21_43<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_43=='\\') ) {s = 44;}

                        else if ( (LA21_43==','||LA21_43=='['||LA21_43==']'||LA21_43=='{'||LA21_43=='}') ) {s = 45;}

                        else if ( (LA21_43=='\n'||LA21_43=='\r'||LA21_43=='\"'||(LA21_43>='(' && LA21_43<=')')||LA21_43==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_43);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA21_55 = input.LA(1);

                         
                        int index21_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_55=='\t'||LA21_55==' ') ) {s = 41;}

                        else if ( ((LA21_55>='\u0000' && LA21_55<='\b')||(LA21_55>='\u000B' && LA21_55<='\f')||(LA21_55>='\u000E' && LA21_55<='\u001F')||LA21_55=='!'||(LA21_55>='$' && LA21_55<='\'')||(LA21_55>='*' && LA21_55<='+')||(LA21_55>='-' && LA21_55<='9')||(LA21_55>=';' && LA21_55<='Z')||(LA21_55>='^' && LA21_55<='z')||LA21_55=='|'||(LA21_55>='~' && LA21_55<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_55=='\\') ) {s = 44;}

                        else if ( (LA21_55==','||LA21_55=='['||LA21_55==']'||LA21_55=='{'||LA21_55=='}') ) {s = 45;}

                        else if ( (LA21_55=='\n'||LA21_55=='\r'||(LA21_55>='\"' && LA21_55<='#')||(LA21_55>='(' && LA21_55<=')')||LA21_55==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_55);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA21_28 = input.LA(1);

                         
                        int index21_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_28>='\u0000' && LA21_28<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 72;

                         
                        input.seek(index21_28);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA21_25 = input.LA(1);

                         
                        int index21_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 62;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index21_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA21_24 = input.LA(1);

                         
                        int index21_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 62;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index21_24);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA21_61 = input.LA(1);

                         
                        int index21_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((getCharPositionInLine()==0)))) ) {s = 62;}

                        else if ( ((getCharPositionInLine()==0)) ) {s = 32;}

                         
                        input.seek(index21_61);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA21_86 = input.LA(1);

                         
                        int index21_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_86>='0' && LA21_86<='9')||(LA21_86>='A' && LA21_86<='F')||(LA21_86>='a' && LA21_86<='f')) ) {s = 89;}

                        else if ( ((LA21_86>='\u0000' && LA21_86<='/')||(LA21_86>=':' && LA21_86<='@')||(LA21_86>='G' && LA21_86<='`')||(LA21_86>='g' && LA21_86<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_86);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA21_93 = input.LA(1);

                         
                        int index21_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_93>='0' && LA21_93<='9')||(LA21_93>='A' && LA21_93<='F')||(LA21_93>='a' && LA21_93<='f')) ) {s = 96;}

                        else if ( ((LA21_93>='\u0000' && LA21_93<='/')||(LA21_93>=':' && LA21_93<='@')||(LA21_93>='G' && LA21_93<='`')||(LA21_93>='g' && LA21_93<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_93);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA21_13 = input.LA(1);

                         
                        int index21_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_13>='\u0000' && LA21_13<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 40;

                         
                        input.seek(index21_13);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA21_88 = input.LA(1);

                         
                        int index21_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_88>='0' && LA21_88<='9')||(LA21_88>='A' && LA21_88<='F')||(LA21_88>='a' && LA21_88<='f')) ) {s = 91;}

                        else if ( ((LA21_88>='\u0000' && LA21_88<='/')||(LA21_88>=':' && LA21_88<='@')||(LA21_88>='G' && LA21_88<='`')||(LA21_88>='g' && LA21_88<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_88);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA21_85 = input.LA(1);

                         
                        int index21_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_85=='#') ) {s = 77;}

                        else if ( (LA21_85=='\t'||LA21_85==' ') ) {s = 41;}

                        else if ( ((LA21_85>='\u0000' && LA21_85<='\b')||(LA21_85>='\u000B' && LA21_85<='\f')||(LA21_85>='\u000E' && LA21_85<='\u001F')||LA21_85=='!'||(LA21_85>='$' && LA21_85<='\'')||(LA21_85>='*' && LA21_85<='+')||(LA21_85>='-' && LA21_85<='9')||(LA21_85>=';' && LA21_85<='Z')||(LA21_85>='^' && LA21_85<='z')||LA21_85=='|'||(LA21_85>='~' && LA21_85<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_85=='\\') ) {s = 44;}

                        else if ( (LA21_85==','||LA21_85=='['||LA21_85==']'||LA21_85=='{'||LA21_85=='}') ) {s = 45;}

                        else if ( (LA21_85=='\n'||LA21_85=='\r'||LA21_85=='\"'||(LA21_85>='(' && LA21_85<=')')||LA21_85==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_85);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA21_63 = input.LA(1);

                         
                        int index21_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_63=='\"') ) {s = 28;}

                        else if ( ((LA21_63>='\u0000' && LA21_63<='\t')||(LA21_63>='\u000B' && LA21_63<='\f')||(LA21_63>='\u000E' && LA21_63<='!')||(LA21_63>='#' && LA21_63<='[')||(LA21_63>=']' && LA21_63<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_63=='\\') ) {s = 27;}

                        else if ( (LA21_63=='\n'||LA21_63=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_63);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA21_91 = input.LA(1);

                         
                        int index21_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_91>='\u0000' && LA21_91<='/')||(LA21_91>=':' && LA21_91<='@')||(LA21_91>='G' && LA21_91<='`')||(LA21_91>='g' && LA21_91<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_91>='0' && LA21_91<='9')||(LA21_91>='A' && LA21_91<='F')||(LA21_91>='a' && LA21_91<='f')) ) {s = 94;}

                         
                        input.seek(index21_91);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA21_52 = input.LA(1);

                         
                        int index21_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_52=='\n'||LA21_52=='\r'||(LA21_52>='\"' && LA21_52<='#')||(LA21_52>='(' && LA21_52<=')')||LA21_52==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA21_52=='\t'||LA21_52==' ') ) {s = 41;}

                        else if ( ((LA21_52>='\u0000' && LA21_52<='\b')||(LA21_52>='\u000B' && LA21_52<='\f')||(LA21_52>='\u000E' && LA21_52<='\u001F')||LA21_52=='!'||(LA21_52>='$' && LA21_52<='\'')||(LA21_52>='*' && LA21_52<='+')||(LA21_52>='-' && LA21_52<='9')||(LA21_52>=';' && LA21_52<='Z')||(LA21_52>='^' && LA21_52<='z')||LA21_52=='|'||(LA21_52>='~' && LA21_52<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_52=='\\') ) {s = 44;}

                        else if ( (LA21_52==','||LA21_52=='['||LA21_52==']'||LA21_52=='{'||LA21_52=='}') ) {s = 45;}

                        else s = 51;

                         
                        input.seek(index21_52);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA21_97 = input.LA(1);

                         
                        int index21_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_97=='\"') ) {s = 28;}

                        else if ( ((LA21_97>='\u0000' && LA21_97<='\t')||(LA21_97>='\u000B' && LA21_97<='\f')||(LA21_97>='\u000E' && LA21_97<='!')||(LA21_97>='#' && LA21_97<='[')||(LA21_97>=']' && LA21_97<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_97=='\\') ) {s = 27;}

                        else if ( (LA21_97=='\n'||LA21_97=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_97);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA21_56 = input.LA(1);

                         
                        int index21_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_56=='\t'||LA21_56==' ') ) {s = 41;}

                        else if ( ((LA21_56>='\u0000' && LA21_56<='\b')||(LA21_56>='\u000B' && LA21_56<='\f')||(LA21_56>='\u000E' && LA21_56<='\u001F')||LA21_56=='!'||(LA21_56>='$' && LA21_56<='\'')||(LA21_56>='*' && LA21_56<='+')||(LA21_56>='-' && LA21_56<='9')||(LA21_56>=';' && LA21_56<='Z')||(LA21_56>='^' && LA21_56<='z')||LA21_56=='|'||(LA21_56>='~' && LA21_56<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_56=='\\') ) {s = 44;}

                        else if ( (LA21_56==','||LA21_56=='['||LA21_56==']'||LA21_56=='{'||LA21_56=='}') ) {s = 45;}

                        else if ( (LA21_56=='\n'||LA21_56=='\r'||(LA21_56>='\"' && LA21_56<='#')||(LA21_56>='(' && LA21_56<=')')||LA21_56==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_56);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_5>='\u0000' && LA21_5<='\t')||(LA21_5>='\u000B' && LA21_5<='\f')||(LA21_5>='\u000E' && LA21_5<='!')||(LA21_5>='#' && LA21_5<='[')||(LA21_5>=']' && LA21_5<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_5=='\\') ) {s = 27;}

                        else if ( (LA21_5=='\"') ) {s = 28;}

                        else if ( (LA21_5=='\n'||LA21_5=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA21_57 = input.LA(1);

                         
                        int index21_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_57=='\t'||LA21_57==' ') ) {s = 41;}

                        else if ( ((LA21_57>='\u0000' && LA21_57<='\b')||(LA21_57>='\u000B' && LA21_57<='\f')||(LA21_57>='\u000E' && LA21_57<='\u001F')||LA21_57=='!'||(LA21_57>='$' && LA21_57<='\'')||(LA21_57>='*' && LA21_57<='+')||(LA21_57>='-' && LA21_57<='9')||(LA21_57>=';' && LA21_57<='Z')||(LA21_57>='^' && LA21_57<='z')||LA21_57=='|'||(LA21_57>='~' && LA21_57<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_57=='\\') ) {s = 44;}

                        else if ( (LA21_57==','||LA21_57=='['||LA21_57==']'||LA21_57=='{'||LA21_57=='}') ) {s = 45;}

                        else if ( (LA21_57=='\n'||LA21_57=='\r'||(LA21_57>='\"' && LA21_57<='#')||(LA21_57>='(' && LA21_57<=')')||LA21_57==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_57);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA21_30 = input.LA(1);

                         
                        int index21_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() != State.INIT )) ) {s = 73;}

                        else if ( (true) ) {s = 74;}

                         
                        input.seek(index21_30);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA21_19 = input.LA(1);

                         
                        int index21_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_19=='\t'||LA21_19==' ') ) {s = 41;}

                        else if ( (LA21_19=='\n'||LA21_19=='\r'||(LA21_19>='\"' && LA21_19<='#')||(LA21_19>='(' && LA21_19<=')')||LA21_19==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_19>='\u0000' && LA21_19<='\b')||(LA21_19>='\u000B' && LA21_19<='\f')||(LA21_19>='\u000E' && LA21_19<='\u001F')||LA21_19=='!'||(LA21_19>='$' && LA21_19<='\'')||(LA21_19>='*' && LA21_19<='+')||(LA21_19>='-' && LA21_19<='9')||(LA21_19>=';' && LA21_19<='Z')||(LA21_19>='^' && LA21_19<='z')||LA21_19=='|'||(LA21_19>='~' && LA21_19<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_19=='\\') ) {s = 44;}

                        else if ( (LA21_19==','||LA21_19=='['||LA21_19==']'||LA21_19=='{'||LA21_19=='}') ) {s = 45;}

                        else s = 50;

                         
                        input.seek(index21_19);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA21_96 = input.LA(1);

                         
                        int index21_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_96=='\t'||LA21_96==' ') ) {s = 41;}

                        else if ( ((LA21_96>='\u0000' && LA21_96<='\b')||(LA21_96>='\u000B' && LA21_96<='\f')||(LA21_96>='\u000E' && LA21_96<='\u001F')||LA21_96=='!'||(LA21_96>='$' && LA21_96<='\'')||(LA21_96>='*' && LA21_96<='+')||(LA21_96>='-' && LA21_96<='9')||(LA21_96>=';' && LA21_96<='Z')||(LA21_96>='^' && LA21_96<='z')||LA21_96=='|'||(LA21_96>='~' && LA21_96<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_96=='\\') ) {s = 44;}

                        else if ( (LA21_96==','||LA21_96=='['||LA21_96==']'||LA21_96=='{'||LA21_96=='}') ) {s = 45;}

                        else if ( (LA21_96=='\n'||LA21_96=='\r'||(LA21_96>='\"' && LA21_96<='#')||(LA21_96>='(' && LA21_96<=')')||LA21_96==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_96);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA21_65 = input.LA(1);

                         
                        int index21_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_65=='\"') ) {s = 28;}

                        else if ( ((LA21_65>='\u0000' && LA21_65<='\t')||(LA21_65>='\u000B' && LA21_65<='\f')||(LA21_65>='\u000E' && LA21_65<='!')||(LA21_65>='#' && LA21_65<='[')||(LA21_65>=']' && LA21_65<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_65=='\\') ) {s = 27;}

                        else if ( (LA21_65=='\n'||LA21_65=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_65);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA21_10 = input.LA(1);

                         
                        int index21_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_10>='\u0000' && LA21_10<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 37;

                         
                        input.seek(index21_10);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA21_70 = input.LA(1);

                         
                        int index21_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_70=='\n'||LA21_70=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA21_70=='\"') ) {s = 28;}

                        else if ( ((LA21_70>='\u0000' && LA21_70<='\t')||(LA21_70>='\u000B' && LA21_70<='\f')||(LA21_70>='\u000E' && LA21_70<='!')||(LA21_70>='#' && LA21_70<='[')||(LA21_70>=']' && LA21_70<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_70=='\\') ) {s = 27;}

                         
                        input.seek(index21_70);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA21_45 = input.LA(1);

                         
                        int index21_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_45=='\n'||LA21_45=='\r'||LA21_45=='\"'||(LA21_45>='(' && LA21_45<=')')||LA21_45==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA21_45=='#') ) {s = 77;}

                        else if ( (LA21_45=='\t'||LA21_45==' ') ) {s = 41;}

                        else if ( ((LA21_45>='\u0000' && LA21_45<='\b')||(LA21_45>='\u000B' && LA21_45<='\f')||(LA21_45>='\u000E' && LA21_45<='\u001F')||LA21_45=='!'||(LA21_45>='$' && LA21_45<='\'')||(LA21_45>='*' && LA21_45<='+')||(LA21_45>='-' && LA21_45<='9')||(LA21_45>=';' && LA21_45<='Z')||(LA21_45>='^' && LA21_45<='z')||LA21_45=='|'||(LA21_45>='~' && LA21_45<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_45=='\\') ) {s = 44;}

                        else if ( (LA21_45==','||LA21_45=='['||LA21_45==']'||LA21_45=='{'||LA21_45=='}') ) {s = 45;}

                        else s = 51;

                         
                        input.seek(index21_45);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA21_60 = input.LA(1);

                         
                        int index21_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_60>='0' && LA21_60<='9')||(LA21_60>='A' && LA21_60<='F')||(LA21_60>='a' && LA21_60<='f')) ) {s = 87;}

                        else if ( ((LA21_60>='\u0000' && LA21_60<='/')||(LA21_60>=':' && LA21_60<='@')||(LA21_60>='G' && LA21_60<='`')||(LA21_60>='g' && LA21_60<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_60);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA21_95 = input.LA(1);

                         
                        int index21_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_95>='0' && LA21_95<='9')||(LA21_95>='A' && LA21_95<='F')||(LA21_95>='a' && LA21_95<='f')) ) {s = 98;}

                        else if ( ((LA21_95>='\u0000' && LA21_95<='/')||(LA21_95>=':' && LA21_95<='@')||(LA21_95>='G' && LA21_95<='`')||(LA21_95>='g' && LA21_95<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_95);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA21_66 = input.LA(1);

                         
                        int index21_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_66=='\"') ) {s = 28;}

                        else if ( ((LA21_66>='\u0000' && LA21_66<='\t')||(LA21_66>='\u000B' && LA21_66<='\f')||(LA21_66>='\u000E' && LA21_66<='!')||(LA21_66>='#' && LA21_66<='[')||(LA21_66>=']' && LA21_66<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_66=='\\') ) {s = 27;}

                        else if ( (LA21_66=='\n'||LA21_66=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_66);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA21_16 = input.LA(1);

                         
                        int index21_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_16=='\t'||LA21_16==' ') ) {s = 41;}

                        else if ( (LA21_16=='\n'||LA21_16=='\r'||(LA21_16>='\"' && LA21_16<='#')||(LA21_16>='(' && LA21_16<=')')||LA21_16==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_16>='\u0000' && LA21_16<='\b')||(LA21_16>='\u000B' && LA21_16<='\f')||(LA21_16>='\u000E' && LA21_16<='\u001F')||LA21_16=='!'||(LA21_16>='$' && LA21_16<='\'')||(LA21_16>='*' && LA21_16<='+')||(LA21_16>='-' && LA21_16<='9')||(LA21_16>=';' && LA21_16<='Z')||(LA21_16>='^' && LA21_16<='z')||LA21_16=='|'||(LA21_16>='~' && LA21_16<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_16=='\\') ) {s = 44;}

                        else if ( (LA21_16==','||LA21_16=='['||LA21_16==']'||LA21_16=='{'||LA21_16=='}') ) {s = 45;}

                        else s = 47;

                         
                        input.seek(index21_16);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA21_27 = input.LA(1);

                         
                        int index21_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_27=='\"') ) {s = 63;}

                        else if ( (LA21_27=='\\') ) {s = 64;}

                        else if ( (LA21_27=='/') ) {s = 65;}

                        else if ( (LA21_27=='b') ) {s = 66;}

                        else if ( (LA21_27=='f') ) {s = 67;}

                        else if ( (LA21_27=='n') ) {s = 68;}

                        else if ( (LA21_27=='r') ) {s = 69;}

                        else if ( (LA21_27=='t') ) {s = 70;}

                        else if ( (LA21_27=='u') ) {s = 71;}

                        else if ( ((LA21_27>='\u0000' && LA21_27<='!')||(LA21_27>='#' && LA21_27<='.')||(LA21_27>='0' && LA21_27<='[')||(LA21_27>=']' && LA21_27<='a')||(LA21_27>='c' && LA21_27<='e')||(LA21_27>='g' && LA21_27<='m')||(LA21_27>='o' && LA21_27<='q')||LA21_27=='s'||(LA21_27>='v' && LA21_27<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_27);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA21_54 = input.LA(1);

                         
                        int index21_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_54=='\t'||LA21_54==' ') ) {s = 41;}

                        else if ( ((LA21_54>='\u0000' && LA21_54<='\b')||(LA21_54>='\u000B' && LA21_54<='\f')||(LA21_54>='\u000E' && LA21_54<='\u001F')||LA21_54=='!'||(LA21_54>='$' && LA21_54<='\'')||(LA21_54>='*' && LA21_54<='+')||(LA21_54>='-' && LA21_54<='9')||(LA21_54>=';' && LA21_54<='Z')||(LA21_54>='^' && LA21_54<='z')||LA21_54=='|'||(LA21_54>='~' && LA21_54<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_54=='\\') ) {s = 44;}

                        else if ( (LA21_54==','||LA21_54=='['||LA21_54==']'||LA21_54=='{'||LA21_54=='}') ) {s = 45;}

                        else if ( (LA21_54=='\n'||LA21_54=='\r'||(LA21_54>='\"' && LA21_54<='#')||(LA21_54>='(' && LA21_54<=')')||LA21_54==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_54);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA21_59 = input.LA(1);

                         
                        int index21_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_59=='\t'||LA21_59==' ') ) {s = 41;}

                        else if ( ((LA21_59>='\u0000' && LA21_59<='\b')||(LA21_59>='\u000B' && LA21_59<='\f')||(LA21_59>='\u000E' && LA21_59<='\u001F')||LA21_59=='!'||(LA21_59>='$' && LA21_59<='\'')||(LA21_59>='*' && LA21_59<='+')||(LA21_59>='-' && LA21_59<='9')||(LA21_59>=';' && LA21_59<='Z')||(LA21_59>='^' && LA21_59<='z')||LA21_59=='|'||(LA21_59>='~' && LA21_59<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_59=='\\') ) {s = 44;}

                        else if ( (LA21_59==','||LA21_59=='['||LA21_59==']'||LA21_59=='{'||LA21_59=='}') ) {s = 45;}

                        else if ( (LA21_59=='\n'||LA21_59=='\r'||(LA21_59>='\"' && LA21_59<='#')||(LA21_59>='(' && LA21_59<=')')||LA21_59==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_59);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA21_90 = input.LA(1);

                         
                        int index21_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_90>='0' && LA21_90<='9')||(LA21_90>='A' && LA21_90<='F')||(LA21_90>='a' && LA21_90<='f')) ) {s = 93;}

                        else if ( ((LA21_90>='\u0000' && LA21_90<='/')||(LA21_90>=':' && LA21_90<='@')||(LA21_90>='G' && LA21_90<='`')||(LA21_90>='g' && LA21_90<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_90);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA21_53 = input.LA(1);

                         
                        int index21_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_53=='\t'||LA21_53==' ') ) {s = 41;}

                        else if ( ((LA21_53>='\u0000' && LA21_53<='\b')||(LA21_53>='\u000B' && LA21_53<='\f')||(LA21_53>='\u000E' && LA21_53<='\u001F')||LA21_53=='!'||(LA21_53>='$' && LA21_53<='\'')||(LA21_53>='*' && LA21_53<='+')||(LA21_53>='-' && LA21_53<='9')||(LA21_53>=';' && LA21_53<='Z')||(LA21_53>='^' && LA21_53<='z')||LA21_53=='|'||(LA21_53>='~' && LA21_53<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_53=='\\') ) {s = 44;}

                        else if ( (LA21_53==','||LA21_53=='['||LA21_53==']'||LA21_53=='{'||LA21_53=='}') ) {s = 45;}

                        else if ( (LA21_53=='\n'||LA21_53=='\r'||(LA21_53>='\"' && LA21_53<='#')||(LA21_53>='(' && LA21_53<=')')||LA21_53==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_53);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA21_33 = input.LA(1);

                         
                        int index21_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_33=='\r') ) {s = 34;}

                        else if ( (LA21_33=='\n') ) {s = 35;}

                        else if ( (LA21_33=='\t'||LA21_33==' ') ) {s = 33;}

                        else if ( ((LA21_33>='\u0000' && LA21_33<='\b')||(LA21_33>='\u000B' && LA21_33<='\f')||(LA21_33>='\u000E' && LA21_33<='\u001F')||(LA21_33>='!' && LA21_33<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 73;

                         
                        input.seek(index21_33);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA21_78 = input.LA(1);

                         
                        int index21_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_78=='#') ) {s = 77;}

                        else if ( (LA21_78=='\t'||LA21_78==' ') ) {s = 41;}

                        else if ( ((LA21_78>='\u0000' && LA21_78<='\b')||(LA21_78>='\u000B' && LA21_78<='\f')||(LA21_78>='\u000E' && LA21_78<='\u001F')||LA21_78=='!'||(LA21_78>='$' && LA21_78<='\'')||(LA21_78>='*' && LA21_78<='+')||(LA21_78>='-' && LA21_78<='9')||(LA21_78>=';' && LA21_78<='Z')||(LA21_78>='^' && LA21_78<='z')||LA21_78=='|'||(LA21_78>='~' && LA21_78<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_78=='\\') ) {s = 44;}

                        else if ( (LA21_78==','||LA21_78=='['||LA21_78==']'||LA21_78=='{'||LA21_78=='}') ) {s = 45;}

                        else if ( (LA21_78=='\n'||LA21_78=='\r'||LA21_78=='\"'||(LA21_78>='(' && LA21_78<=')')||LA21_78==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_78);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_0=='#') ) {s = 1;}

                        else if ( (LA21_0=='%') ) {s = 2;}

                        else if ( (LA21_0=='\r') ) {s = 3;}

                        else if ( (LA21_0=='\n') ) {s = 4;}

                        else if ( (LA21_0=='\"') ) {s = 5;}

                        else if ( (LA21_0==' ') ) {s = 6;}

                        else if ( (LA21_0=='-') ) {s = 7;}

                        else if ( (LA21_0=='\t') ) {s = 8;}

                        else if ( (LA21_0=='(') ) {s = 9;}

                        else if ( (LA21_0==')') ) {s = 10;}

                        else if ( (LA21_0==',') ) {s = 11;}

                        else if ( (LA21_0==':') ) {s = 12;}

                        else if ( (LA21_0=='>') ) {s = 13;}

                        else if ( (LA21_0=='*') ) {s = 14;}

                        else if ( (LA21_0=='@') ) {s = 15;}

                        else if ( (LA21_0=='+') ) {s = 16;}

                        else if ( (LA21_0=='[') ) {s = 17;}

                        else if ( (LA21_0==']') ) {s = 18;}

                        else if ( (LA21_0=='?') ) {s = 19;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||LA21_0=='$'||LA21_0=='&'||(LA21_0>='.' && LA21_0<='9')||(LA21_0>=';' && LA21_0<='=')||(LA21_0>='A' && LA21_0<='Z')||(LA21_0>='^' && LA21_0<='z')||LA21_0=='|'||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 20;}

                        else if ( (LA21_0=='\\') ) {s = 21;}

                        else if ( (LA21_0=='\''||LA21_0=='{'||LA21_0=='}') && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_0);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA21_94 = input.LA(1);

                         
                        int index21_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_94>='0' && LA21_94<='9')||(LA21_94>='A' && LA21_94<='F')||(LA21_94>='a' && LA21_94<='f')) ) {s = 97;}

                        else if ( ((LA21_94>='\u0000' && LA21_94<='/')||(LA21_94>=':' && LA21_94<='@')||(LA21_94>='G' && LA21_94<='`')||(LA21_94>='g' && LA21_94<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_94);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA21_71 = input.LA(1);

                         
                        int index21_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_71>='\u0000' && LA21_71<='/')||(LA21_71>=':' && LA21_71<='@')||(LA21_71>='G' && LA21_71<='`')||(LA21_71>='g' && LA21_71<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_71>='0' && LA21_71<='9')||(LA21_71>='A' && LA21_71<='F')||(LA21_71>='a' && LA21_71<='f')) ) {s = 88;}

                         
                        input.seek(index21_71);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA21_83 = input.LA(1);

                         
                        int index21_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_83=='#') ) {s = 77;}

                        else if ( (LA21_83=='\t'||LA21_83==' ') ) {s = 41;}

                        else if ( ((LA21_83>='\u0000' && LA21_83<='\b')||(LA21_83>='\u000B' && LA21_83<='\f')||(LA21_83>='\u000E' && LA21_83<='\u001F')||LA21_83=='!'||(LA21_83>='$' && LA21_83<='\'')||(LA21_83>='*' && LA21_83<='+')||(LA21_83>='-' && LA21_83<='9')||(LA21_83>=';' && LA21_83<='Z')||(LA21_83>='^' && LA21_83<='z')||LA21_83=='|'||(LA21_83>='~' && LA21_83<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_83=='\\') ) {s = 44;}

                        else if ( (LA21_83==','||LA21_83=='['||LA21_83==']'||LA21_83=='{'||LA21_83=='}') ) {s = 45;}

                        else if ( (LA21_83=='\n'||LA21_83=='\r'||LA21_83=='\"'||(LA21_83>='(' && LA21_83<=')')||LA21_83==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_83);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA21_21 = input.LA(1);

                         
                        int index21_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_21=='\"') ) {s = 52;}

                        else if ( (LA21_21=='\\') ) {s = 53;}

                        else if ( (LA21_21=='/') ) {s = 54;}

                        else if ( (LA21_21=='b') ) {s = 55;}

                        else if ( (LA21_21=='f') ) {s = 56;}

                        else if ( (LA21_21=='n') ) {s = 57;}

                        else if ( (LA21_21=='r') ) {s = 58;}

                        else if ( (LA21_21=='t') ) {s = 59;}

                        else if ( (LA21_21=='u') ) {s = 60;}

                        else if ( ((LA21_21>='\u0000' && LA21_21<='!')||(LA21_21>='#' && LA21_21<='.')||(LA21_21>='0' && LA21_21<='[')||(LA21_21>=']' && LA21_21<='a')||(LA21_21>='c' && LA21_21<='e')||(LA21_21>='g' && LA21_21<='m')||(LA21_21>='o' && LA21_21<='q')||LA21_21=='s'||(LA21_21>='v' && LA21_21<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_21);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA21_8 = input.LA(1);

                         
                        int index21_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_8=='\t'||LA21_8==' ') ) {s = 33;}

                        else if ( (LA21_8=='\r') ) {s = 34;}

                        else if ( (LA21_8=='\n') ) {s = 35;}

                        else if ( ((LA21_8>='\u0000' && LA21_8<='\b')||(LA21_8>='\u000B' && LA21_8<='\f')||(LA21_8>='\u000E' && LA21_8<='\u001F')||(LA21_8>='!' && LA21_8<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 30;

                         
                        input.seek(index21_8);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA21_20 = input.LA(1);

                         
                        int index21_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_20=='\t'||LA21_20==' ') ) {s = 41;}

                        else if ( (LA21_20=='\n'||LA21_20=='\r'||(LA21_20>='\"' && LA21_20<='#')||(LA21_20>='(' && LA21_20<=')')||LA21_20==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( ((LA21_20>='\u0000' && LA21_20<='\b')||(LA21_20>='\u000B' && LA21_20<='\f')||(LA21_20>='\u000E' && LA21_20<='\u001F')||LA21_20=='!'||(LA21_20>='$' && LA21_20<='\'')||(LA21_20>='*' && LA21_20<='+')||(LA21_20>='-' && LA21_20<='9')||(LA21_20>=';' && LA21_20<='Z')||(LA21_20>='^' && LA21_20<='z')||LA21_20=='|'||(LA21_20>='~' && LA21_20<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_20=='\\') ) {s = 44;}

                        else if ( (LA21_20==','||LA21_20=='['||LA21_20==']'||LA21_20=='{'||LA21_20=='}') ) {s = 45;}

                        else s = 51;

                         
                        input.seek(index21_20);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA21_80 = input.LA(1);

                         
                        int index21_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_80=='#') ) {s = 77;}

                        else if ( (LA21_80=='\t'||LA21_80==' ') ) {s = 41;}

                        else if ( ((LA21_80>='\u0000' && LA21_80<='\b')||(LA21_80>='\u000B' && LA21_80<='\f')||(LA21_80>='\u000E' && LA21_80<='\u001F')||LA21_80=='!'||(LA21_80>='$' && LA21_80<='\'')||(LA21_80>='*' && LA21_80<='+')||(LA21_80>='-' && LA21_80<='9')||(LA21_80>=';' && LA21_80<='Z')||(LA21_80>='^' && LA21_80<='z')||LA21_80=='|'||(LA21_80>='~' && LA21_80<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_80=='\\') ) {s = 44;}

                        else if ( (LA21_80==','||LA21_80=='['||LA21_80==']'||LA21_80=='{'||LA21_80=='}') ) {s = 45;}

                        else if ( (LA21_80=='\n'||LA21_80=='\r'||LA21_80=='\"'||(LA21_80>='(' && LA21_80<=')')||LA21_80==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_80);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA21_58 = input.LA(1);

                         
                        int index21_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_58=='\t'||LA21_58==' ') ) {s = 41;}

                        else if ( ((LA21_58>='\u0000' && LA21_58<='\b')||(LA21_58>='\u000B' && LA21_58<='\f')||(LA21_58>='\u000E' && LA21_58<='\u001F')||LA21_58=='!'||(LA21_58>='$' && LA21_58<='\'')||(LA21_58>='*' && LA21_58<='+')||(LA21_58>='-' && LA21_58<='9')||(LA21_58>=';' && LA21_58<='Z')||(LA21_58>='^' && LA21_58<='z')||LA21_58=='|'||(LA21_58>='~' && LA21_58<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_58=='\\') ) {s = 44;}

                        else if ( (LA21_58==','||LA21_58=='['||LA21_58==']'||LA21_58=='{'||LA21_58=='}') ) {s = 45;}

                        else if ( (LA21_58=='\n'||LA21_58=='\r'||(LA21_58>='\"' && LA21_58<='#')||(LA21_58>='(' && LA21_58<=')')||LA21_58==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_58);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA21_44 = input.LA(1);

                         
                        int index21_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_44=='\"') ) {s = 78;}

                        else if ( (LA21_44=='\\') ) {s = 79;}

                        else if ( (LA21_44=='/') ) {s = 80;}

                        else if ( (LA21_44=='b') ) {s = 81;}

                        else if ( (LA21_44=='f') ) {s = 82;}

                        else if ( (LA21_44=='n') ) {s = 83;}

                        else if ( (LA21_44=='r') ) {s = 84;}

                        else if ( (LA21_44=='t') ) {s = 85;}

                        else if ( (LA21_44=='u') ) {s = 86;}

                        else if ( ((LA21_44>='\u0000' && LA21_44<='!')||(LA21_44>='#' && LA21_44<='.')||(LA21_44>='0' && LA21_44<='[')||(LA21_44>=']' && LA21_44<='a')||(LA21_44>='c' && LA21_44<='e')||(LA21_44>='g' && LA21_44<='m')||(LA21_44>='o' && LA21_44<='q')||LA21_44=='s'||(LA21_44>='v' && LA21_44<='\uFFFF')) && ((getCharPositionInLine()==0))) {s = 22;}

                         
                        input.seek(index21_44);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA21_69 = input.LA(1);

                         
                        int index21_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_69=='\n'||LA21_69=='\r') && ((getCharPositionInLine()==0))) {s = 22;}

                        else if ( (LA21_69=='\"') ) {s = 28;}

                        else if ( ((LA21_69>='\u0000' && LA21_69<='\t')||(LA21_69>='\u000B' && LA21_69<='\f')||(LA21_69>='\u000E' && LA21_69<='!')||(LA21_69>='#' && LA21_69<='[')||(LA21_69>=']' && LA21_69<='\uFFFF')) ) {s = 26;}

                        else if ( (LA21_69=='\\') ) {s = 27;}

                         
                        input.seek(index21_69);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA21_82 = input.LA(1);

                         
                        int index21_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_82=='#') ) {s = 77;}

                        else if ( (LA21_82=='\t'||LA21_82==' ') ) {s = 41;}

                        else if ( ((LA21_82>='\u0000' && LA21_82<='\b')||(LA21_82>='\u000B' && LA21_82<='\f')||(LA21_82>='\u000E' && LA21_82<='\u001F')||LA21_82=='!'||(LA21_82>='$' && LA21_82<='\'')||(LA21_82>='*' && LA21_82<='+')||(LA21_82>='-' && LA21_82<='9')||(LA21_82>=';' && LA21_82<='Z')||(LA21_82>='^' && LA21_82<='z')||LA21_82=='|'||(LA21_82>='~' && LA21_82<='\uFFFF')) ) {s = 43;}

                        else if ( (LA21_82=='\\') ) {s = 44;}

                        else if ( (LA21_82==','||LA21_82=='['||LA21_82==']'||LA21_82=='{'||LA21_82=='}') ) {s = 45;}

                        else if ( (LA21_82=='\n'||LA21_82=='\r'||LA21_82=='\"'||(LA21_82>='(' && LA21_82<=')')||LA21_82==':') && ((getCharPositionInLine()==0))) {s = 22;}

                        else s = 51;

                         
                        input.seek(index21_82);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
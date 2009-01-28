// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-28 23:49:05

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SilkLexer extends Lexer {
    public static final int Key=13;
    public static final int DataType=9;
    public static final int NodeIndicator=17;
    public static final int SilkNode=4;
    public static final int RBrace=44;
    public static final int LBracket=41;
    public static final int Digit=22;
    public static final int Frac=29;
    public static final int HexDigit=23;
    public static final int Plus=48;
    public static final int Occurrence=8;
    public static final int Argument=11;
    public static final int Letter=35;
    public static final int Comma=45;
    public static final int SpecialSymbol=18;
    public static final int Dot=28;
    public static final int EscapeSequence=25;
    public static final int Slash=50;
    public static final int DataLine=19;
    public static final int Integer=32;
    public static final int Question=47;
    public static final int LineComment=14;
    public static final int Colon=34;
    public static final int SequenceIndicator=38;
    public static final int At=49;
    public static final int NameChar=36;
    public static final int SilkAttribute=5;
    public static final int KeyValuePair=12;
    public static final int Star=46;
    public static final int Preamble=15;
    public static final int Exp=30;
    public static final int Int=27;
    public static final int RParen=40;
    public static final int UnicodeChar=24;
    public static final int BlankLine=21;
    public static final int StringChar=26;
    public static final int Function=10;
    public static final int Name=6;
    public static final int LParen=39;
    public static final int String=31;
    public static final int QName=37;
    public static final int EOF=-1;
    public static final int Value=7;
    public static final int LBrace=43;
    public static final int Double=33;
    public static final int RBracket=42;
    public static final int NewLine=16;
    public static final int WhiteSpaces=20;

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:18: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:32: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:15: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:29: '\\r'
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

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            int _type = NewLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:8: ( ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:10: ( '\\r' )? '\\n'
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:10: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:10: '\\r'
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
    // $ANTLR end "NewLine"

    // $ANTLR start "NodeIndicator"
    public final void mNodeIndicator() throws RecognitionException {
        try {
            int _type = NodeIndicator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:14: ({...}? => ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:16: {...}? => ( ' ' )* '-'
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "NodeIndicator", "getCharPositionInLine()==0");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:49: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:50: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NodeIndicator"

    // $ANTLR start "SpecialSymbol"
    public final void mSpecialSymbol() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:23: ( '-' | '%' | '#' | ' ' | '\\n' | '\\r' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)==' '||input.LA(1)=='#'||input.LA(1)=='%'||input.LA(1)=='-' ) {
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
    // $ANTLR end "SpecialSymbol"

    // $ANTLR start "DataLine"
    public final void mDataLine() throws RecognitionException {
        try {
            int _type = DataLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:9: ({...}? => ( ' ' )* ~ SpecialSymbol (~ ( '\\n' | '\\r' ) )* NewLine )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:11: {...}? => ( ' ' )* ~ SpecialSymbol (~ ( '\\n' | '\\r' ) )* NewLine
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "DataLine", " getCharPositionInLine()==0 ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:47: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:48: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0011')||(input.LA(1)>='\u0013' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:69: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:69: ~ ( '\\n' | '\\r' )
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
            	    break loop8;
                }
            } while (true);

            mNewLine(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DataLine"

    // $ANTLR start "WhiteSpaces"
    public final void mWhiteSpaces() throws RecognitionException {
        try {
            int _type = WhiteSpaces;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:12: ( ( ' ' | '\\t' | '\\u000C' )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:14: ( ' ' | '\\t' | '\\u000C' )+
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:14: ( ' ' | '\\t' | '\\u000C' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0=='\f'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpaces"

    // $ANTLR start "BlankLine"
    public final void mBlankLine() throws RecognitionException {
        try {
            int _type = BlankLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:10: ({...}? => ( WhiteSpaces )? ( NewLine | EOF ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:12: {...}? => ( WhiteSpaces )? ( NewLine | EOF )
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "BlankLine", " getCharPositionInLine()==0 ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:47: ( WhiteSpaces )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\t'||LA10_0=='\f'||LA10_0==' ') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:47: WhiteSpaces
                    {
                    mWhiteSpaces(); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:60: ( NewLine | EOF )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            else {
                alt11=2;}
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:61: NewLine
                    {
                    mNewLine(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:71: EOF
                    {
                    match(EOF); 

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
    // $ANTLR end "BlankLine"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:21: (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:23: ~ ( '\"' | '\\\\' | '\\r' | '\\n' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt12=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt12=1;
                }
                break;
            case '\\':
                {
                alt12=2;
                }
                break;
            case '/':
                {
                alt12=3;
                }
                break;
            case 'b':
                {
                alt12=4;
                }
                break;
            case 'f':
                {
                alt12=5;
                }
                break;
            case 'n':
                {
                alt12=6;
                }
                break;
            case 'r':
                {
                alt12=7;
                }
                break;
            case 't':
                {
                alt12=8;
                }
                break;
            case 'u':
                {
                alt12=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:21: ( UnicodeChar | EscapeSequence )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:38: EscapeSequence
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

    // $ANTLR start "Int"
    public final void mInt() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: ( '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='-') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:20: ( '0' | '1' .. '9' ( Digit )* )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='0') ) {
                alt16=1;
            }
            else if ( ((LA16_0>='1' && LA16_0<='9')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:21: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:27: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:36: ( Digit )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:36: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "Int"

    // $ANTLR start "Frac"
    public final void mFrac() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:14: ( Dot ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:16: Dot ( Digit )+
            {
            mDot(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:20: ( Digit )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:27: ( '+' | '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:40: ( Digit )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exp"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:139:7: ( '\"' ( StringChar )* '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:139:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:139:13: ( StringChar )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='!')||(LA20_0>='#' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:139:13: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match('\"'); 
             
              // remove the quotations
              String tmp = getText(); setText(tmp.substring(1, tmp.length()-1)); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:8: ( Int )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:10: Int
            {
            mInt(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Double"
    public final void mDouble() throws RecognitionException {
        try {
            int _type = Double;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:7: ( Int ( Frac ( Exp )? | Exp ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:10: Int ( Frac ( Exp )? | Exp )
            {
            mInt(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:14: ( Frac ( Exp )? | Exp )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='.') ) {
                alt22=1;
            }
            else if ( (LA22_0=='E'||LA22_0=='e') ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:15: Frac ( Exp )?
                    {
                    mFrac(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:20: ( Exp )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='E'||LA21_0=='e') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:20: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:27: Exp
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:8: ':'
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

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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

    // $ANTLR start "NameChar"
    public final void mNameChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:18: ( Letter | Digit | '_' | '-' | Dot )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "NameChar"

    // $ANTLR start "QName"
    public final void mQName() throws RecognitionException {
        try {
            int _type = QName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:6: ( ( Letter | '_' ) ( NameChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:8: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:23: ( NameChar )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='-' && LA23_0<='.')||(LA23_0>='0' && LA23_0<='9')||(LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:23: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QName"

    // $ANTLR start "SequenceIndicator"
    public final void mSequenceIndicator() throws RecognitionException {
        try {
            int _type = SequenceIndicator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:18: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:20: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SequenceIndicator"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: ')'
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

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:11: ']'
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

    // $ANTLR start "LBrace"
    public final void mLBrace() throws RecognitionException {
        try {
            int _type = LBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:7: ( '{' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:9: '{'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:7: ( '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:9: '}'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:8: ','
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

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:4: ( '.' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dot"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:7: '*'
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

    // $ANTLR start "Question"
    public final void mQuestion() throws RecognitionException {
        try {
            int _type = Question;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:11: '?'
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

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:7: '+'
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

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:5: '@'
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

    // $ANTLR start "Slash"
    public final void mSlash() throws RecognitionException {
        try {
            int _type = Slash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:6: ( '/' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:8: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Slash"

    public void mTokens() throws RecognitionException {
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | Colon | QName | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At | Slash )
        int alt24=26;
        alt24 = dfa24.predict(input);
        switch (alt24) {
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:31: NewLine
                {
                mNewLine(); 

                }
                break;
            case 4 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:39: NodeIndicator
                {
                mNodeIndicator(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:53: DataLine
                {
                mDataLine(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:62: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:74: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:84: String
                {
                mString(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:91: Integer
                {
                mInteger(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:99: Double
                {
                mDouble(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:106: Colon
                {
                mColon(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:112: QName
                {
                mQName(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:118: SequenceIndicator
                {
                mSequenceIndicator(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:136: LParen
                {
                mLParen(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:143: RParen
                {
                mRParen(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:150: LBracket
                {
                mLBracket(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:159: RBracket
                {
                mRBracket(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:168: LBrace
                {
                mLBrace(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:175: RBrace
                {
                mRBrace(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:182: Comma
                {
                mComma(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:188: Dot
                {
                mDot(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:192: Star
                {
                mStar(); 

                }
                break;
            case 23 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:197: Question
                {
                mQuestion(); 

                }
                break;
            case 24 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:206: Plus
                {
                mPlus(); 

                }
                break;
            case 25 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:211: At
                {
                mAt(); 

                }
                break;
            case 26 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:214: Slash
                {
                mSlash(); 

                }
                break;

        }

    }


    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA24_eotS =
        "\1\11\3\uffff\1\35\1\36\1\37\1\42\2\uffff\2\51\1\55\1\57\1\60\1"+
        "\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75"+
        "\4\uffff\2\51\2\uffff\1\102\1\103\2\uffff\1\115\3\uffff\1\51\1\uffff"+
        "\1\57\22\uffff\1\51\14\uffff\1\100\1\uffff\1\100\4\uffff\1\100\2"+
        "\uffff";
    static final String DFA24_eofS =
        "\130\uffff";
    static final String DFA24_minS =
        "\1\0\2\uffff\1\12\2\0\1\60\2\0\1\uffff\22\0\1\uffff\2\0\1\uffff"+
        "\2\56\1\0\1\12\5\0\1\uffff\3\0\1\uffff\1\0\22\uffff\1\56\13\0\1"+
        "\uffff\12\0";
    static final String DFA24_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\uffff\1\71\2\uffff\1\uffff\22\uffff"+
        "\1\uffff\2\0\1\uffff\2\145\1\0\1\12\1\0\4\uffff\1\uffff\3\uffff"+
        "\1\uffff\1\uffff\22\uffff\1\145\2\0\11\uffff\1\uffff\12\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\6\uffff\1\7\22\uffff\1\5\2\uffff\1\4\11\uffff"+
        "\1\11\3\uffff\1\13\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1"+
        "\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\3\1\6\1\12\14\uffff\1\10"+
        "\12\uffff";
    static final String DFA24_specialS =
        "\1\65\4\uffff\1\45\1\24\1\52\1\20\1\uffff\1\37\1\14\1\43\1\50\1"+
        "\4\1\67\1\41\1\7\1\55\1\17\1\44\1\34\1\1\1\51\1\42\1\30\1\13\1\15"+
        "\1\uffff\1\0\1\10\3\uffff\1\11\1\60\1\70\1\35\1\36\1\66\1\23\1\uffff"+
        "\1\5\1\27\1\53\1\uffff\1\31\23\uffff\1\64\1\6\1\2\1\12\1\61\1\26"+
        "\1\33\1\40\1\47\1\46\1\62\1\uffff\1\16\1\22\1\56\1\57\1\25\1\32"+
        "\1\21\1\54\1\3\1\63}>";
    static final String[] DFA24_transitionS = {
            "\11\34\1\7\1\4\1\34\1\7\1\3\22\34\1\5\1\34\1\10\1\1\1\34\1"+
            "\2\2\34\1\17\1\20\1\27\1\31\1\25\1\6\1\26\1\33\1\12\11\13\1"+
            "\14\3\34\1\16\1\30\1\32\32\15\1\21\1\34\1\22\1\34\1\15\1\34"+
            "\32\15\1\23\1\34\1\24\uff82\34",
            "",
            "",
            "\1\4",
            "\1\uffff",
            "\11\34\1\7\1\11\1\34\1\7\1\11\22\34\1\5\2\34\1\uffff\1\34"+
            "\1\uffff\7\34\1\37\uffd2\34",
            "\1\40\11\41",
            "\11\34\1\45\1\44\1\34\1\45\1\43\22\34\1\45\uffdf\34",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "",
            "\56\34\1\52\26\34\1\53\37\34\1\53\uff9a\34",
            "\56\34\1\52\1\34\12\54\13\34\1\53\37\34\1\53\uff9a\34",
            "\0\34",
            "\55\34\2\56\1\34\12\56\7\34\32\56\4\34\1\56\1\34\32\56\uff85"+
            "\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "\0\34",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\100\26\uffff\1\100\37\uffff\1\100",
            "\1\100\1\uffff\12\101\13\uffff\1\100\37\uffff\1\100",
            "\1\uffff",
            "\1\44",
            "\1\uffff",
            "\11\34\1\45\1\44\1\34\1\45\1\43\22\34\1\45\uffdf\34",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\42\34\1\104\14\34\1\106\54\34\1\105\5\34\1\107\3\34\1\110"+
            "\7\34\1\111\3\34\1\112\1\34\1\113\1\114\uff8a\34",
            "\0\34",
            "",
            "\60\34\12\116\uffc6\34",
            "\53\34\1\117\1\34\1\117\2\34\12\120\uffc6\34",
            "\56\34\1\52\1\34\12\54\13\34\1\53\37\34\1\53\uff9a\34",
            "",
            "\55\34\2\56\1\34\12\56\7\34\32\56\4\34\1\56\1\34\32\56\uff85"+
            "\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100\1\uffff\12\101\13\uffff\1\100\37\uffff\1\100",
            "\1\uffff",
            "\1\uffff",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46",
            "\60\34\12\121\7\34\6\121\32\34\6\121\uff99\34",
            "",
            "\60\34\12\116\13\34\1\122\37\34\1\122\uff9a\34",
            "\60\34\12\120\uffc6\34",
            "\60\34\12\120\uffc6\34",
            "\60\34\12\123\7\34\6\123\32\34\6\123\uff99\34",
            "\53\34\1\124\1\34\1\124\2\34\12\125\uffc6\34",
            "\60\34\12\126\7\34\6\126\32\34\6\126\uff99\34",
            "\60\34\12\125\uffc6\34",
            "\60\34\12\125\uffc6\34",
            "\60\34\12\127\7\34\6\127\32\34\6\127\uff99\34",
            "\12\46\1\34\2\46\1\34\24\46\1\50\71\46\1\47\uffa3\46"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | Colon | QName | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At | Slash );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_29 = input.LA(1);

                         
                        int index24_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 62;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_29);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_22 = input.LA(1);

                         
                        int index24_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_22>='\u0000' && LA24_22<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 56;

                         
                        input.seek(index24_22);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_68 = input.LA(1);

                         
                        int index24_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_68=='\"') ) {s = 40;}

                        else if ( ((LA24_68>='\u0000' && LA24_68<='\t')||(LA24_68>='\u000B' && LA24_68<='\f')||(LA24_68>='\u000E' && LA24_68<='!')||(LA24_68>='#' && LA24_68<='[')||(LA24_68>=']' && LA24_68<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_68=='\\') ) {s = 39;}

                        else if ( (LA24_68=='\n'||LA24_68=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index24_68);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_86 = input.LA(1);

                         
                        int index24_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_86>='0' && LA24_86<='9')||(LA24_86>='A' && LA24_86<='F')||(LA24_86>='a' && LA24_86<='f')) ) {s = 87;}

                        else if ( ((LA24_86>='\u0000' && LA24_86<='/')||(LA24_86>=':' && LA24_86<='@')||(LA24_86>='G' && LA24_86<='`')||(LA24_86>='g' && LA24_86<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index24_86);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_14>='\u0000' && LA24_14<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 48;

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_42 = input.LA(1);

                         
                        int index24_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_42>='\u0000' && LA24_42<='/')||(LA24_42>=':' && LA24_42<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_42>='0' && LA24_42<='9')) ) {s = 78;}

                         
                        input.seek(index24_42);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_67 = input.LA(1);

                         
                        int index24_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 63;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_67);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_17 = input.LA(1);

                         
                        int index24_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_17>='\u0000' && LA24_17<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 51;

                         
                        input.seek(index24_17);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_30 = input.LA(1);

                         
                        int index24_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 63;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_30);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_34 = input.LA(1);

                         
                        int index24_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 63;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_34);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_69 = input.LA(1);

                         
                        int index24_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_69=='\n'||LA24_69=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_69=='\"') ) {s = 40;}

                        else if ( ((LA24_69>='\u0000' && LA24_69<='\t')||(LA24_69>='\u000B' && LA24_69<='\f')||(LA24_69>='\u000E' && LA24_69<='!')||(LA24_69>='#' && LA24_69<='[')||(LA24_69>=']' && LA24_69<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_69=='\\') ) {s = 39;}

                         
                        input.seek(index24_69);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_26 = input.LA(1);

                         
                        int index24_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_26>='\u0000' && LA24_26<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 60;

                         
                        input.seek(index24_26);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_11>='0' && LA24_11<='9')) ) {s = 44;}

                        else if ( (LA24_11=='.') ) {s = 42;}

                        else if ( (LA24_11=='E'||LA24_11=='e') ) {s = 43;}

                        else if ( ((LA24_11>='\u0000' && LA24_11<='-')||LA24_11=='/'||(LA24_11>=':' && LA24_11<='D')||(LA24_11>='F' && LA24_11<='d')||(LA24_11>='f' && LA24_11<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 41;

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_27 = input.LA(1);

                         
                        int index24_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_27>='\u0000' && LA24_27<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 61;

                         
                        input.seek(index24_27);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_78 = input.LA(1);

                         
                        int index24_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_78=='E'||LA24_78=='e') ) {s = 82;}

                        else if ( ((LA24_78>='0' && LA24_78<='9')) ) {s = 78;}

                        else if ( ((LA24_78>='\u0000' && LA24_78<='/')||(LA24_78>=':' && LA24_78<='D')||(LA24_78>='F' && LA24_78<='d')||(LA24_78>='f' && LA24_78<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 64;

                         
                        input.seek(index24_78);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_19 = input.LA(1);

                         
                        int index24_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_19>='\u0000' && LA24_19<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 53;

                         
                        input.seek(index24_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_8 = input.LA(1);

                         
                        int index24_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_8>='\u0000' && LA24_8<='\t')||(LA24_8>='\u000B' && LA24_8<='\f')||(LA24_8>='\u000E' && LA24_8<='!')||(LA24_8>='#' && LA24_8<='[')||(LA24_8>=']' && LA24_8<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_8=='\n'||LA24_8=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_8=='\\') ) {s = 39;}

                        else if ( (LA24_8=='\"') ) {s = 40;}

                         
                        input.seek(index24_8);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_84 = input.LA(1);

                         
                        int index24_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_84>='\u0000' && LA24_84<='/')||(LA24_84>=':' && LA24_84<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_84>='0' && LA24_84<='9')) ) {s = 85;}

                         
                        input.seek(index24_84);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_79 = input.LA(1);

                         
                        int index24_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_79>='\u0000' && LA24_79<='/')||(LA24_79>=':' && LA24_79<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_79>='0' && LA24_79<='9')) ) {s = 80;}

                         
                        input.seek(index24_79);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA24_40 = input.LA(1);

                         
                        int index24_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_40>='\u0000' && LA24_40<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 77;

                         
                        input.seek(index24_40);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_6=='0') ) {s = 32;}

                        else if ( ((LA24_6>='1' && LA24_6<='9')) ) {s = 33;}

                        else s = 31;

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA24_82 = input.LA(1);

                         
                        int index24_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_82>='\u0000' && LA24_82<='*')||LA24_82==','||(LA24_82>='.' && LA24_82<='/')||(LA24_82>=':' && LA24_82<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_82=='+'||LA24_82=='-') ) {s = 84;}

                        else if ( ((LA24_82>='0' && LA24_82<='9')) ) {s = 85;}

                         
                        input.seek(index24_82);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA24_71 = input.LA(1);

                         
                        int index24_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_71=='\n'||LA24_71=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_71=='\"') ) {s = 40;}

                        else if ( ((LA24_71>='\u0000' && LA24_71<='\t')||(LA24_71>='\u000B' && LA24_71<='\f')||(LA24_71>='\u000E' && LA24_71<='!')||(LA24_71>='#' && LA24_71<='[')||(LA24_71>=']' && LA24_71<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_71=='\\') ) {s = 39;}

                         
                        input.seek(index24_71);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA24_43 = input.LA(1);

                         
                        int index24_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_43>='\u0000' && LA24_43<='*')||LA24_43==','||(LA24_43>='.' && LA24_43<='/')||(LA24_43>=':' && LA24_43<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_43=='+'||LA24_43=='-') ) {s = 79;}

                        else if ( ((LA24_43>='0' && LA24_43<='9')) ) {s = 80;}

                         
                        input.seek(index24_43);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA24_25 = input.LA(1);

                         
                        int index24_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_25>='\u0000' && LA24_25<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 59;

                         
                        input.seek(index24_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA24_46 = input.LA(1);

                         
                        int index24_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_46>='-' && LA24_46<='.')||(LA24_46>='0' && LA24_46<='9')||(LA24_46>='A' && LA24_46<='Z')||LA24_46=='_'||(LA24_46>='a' && LA24_46<='z')) ) {s = 46;}

                        else if ( ((LA24_46>='\u0000' && LA24_46<=',')||LA24_46=='/'||(LA24_46>=':' && LA24_46<='@')||(LA24_46>='[' && LA24_46<='^')||LA24_46=='`'||(LA24_46>='{' && LA24_46<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 47;

                         
                        input.seek(index24_46);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA24_83 = input.LA(1);

                         
                        int index24_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_83>='\u0000' && LA24_83<='/')||(LA24_83>=':' && LA24_83<='@')||(LA24_83>='G' && LA24_83<='`')||(LA24_83>='g' && LA24_83<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_83>='0' && LA24_83<='9')||(LA24_83>='A' && LA24_83<='F')||(LA24_83>='a' && LA24_83<='f')) ) {s = 86;}

                         
                        input.seek(index24_83);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA24_72 = input.LA(1);

                         
                        int index24_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_72=='\"') ) {s = 40;}

                        else if ( ((LA24_72>='\u0000' && LA24_72<='\t')||(LA24_72>='\u000B' && LA24_72<='\f')||(LA24_72>='\u000E' && LA24_72<='!')||(LA24_72>='#' && LA24_72<='[')||(LA24_72>=']' && LA24_72<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_72=='\\') ) {s = 39;}

                        else if ( (LA24_72=='\n'||LA24_72=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index24_72);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA24_21 = input.LA(1);

                         
                        int index24_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_21>='\u0000' && LA24_21<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 55;

                         
                        input.seek(index24_21);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA24_37 = input.LA(1);

                         
                        int index24_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_37=='\r') && (( getCharPositionInLine()==0 ))) {s = 35;}

                        else if ( (LA24_37=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA24_37=='\t'||LA24_37=='\f'||LA24_37==' ') ) {s = 37;}

                        else if ( ((LA24_37>='\u0000' && LA24_37<='\b')||LA24_37=='\u000B'||(LA24_37>='\u000E' && LA24_37<='\u001F')||(LA24_37>='!' && LA24_37<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 67;

                         
                        input.seek(index24_37);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA24_38 = input.LA(1);

                         
                        int index24_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_38=='\"') ) {s = 40;}

                        else if ( ((LA24_38>='\u0000' && LA24_38<='\t')||(LA24_38>='\u000B' && LA24_38<='\f')||(LA24_38>='\u000E' && LA24_38<='!')||(LA24_38>='#' && LA24_38<='[')||(LA24_38>=']' && LA24_38<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_38=='\\') ) {s = 39;}

                        else if ( (LA24_38=='\n'||LA24_38=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index24_38);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_10=='.') ) {s = 42;}

                        else if ( (LA24_10=='E'||LA24_10=='e') ) {s = 43;}

                        else if ( ((LA24_10>='\u0000' && LA24_10<='-')||(LA24_10>='/' && LA24_10<='D')||(LA24_10>='F' && LA24_10<='d')||(LA24_10>='f' && LA24_10<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 41;

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA24_73 = input.LA(1);

                         
                        int index24_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_73=='\n'||LA24_73=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_73=='\"') ) {s = 40;}

                        else if ( ((LA24_73>='\u0000' && LA24_73<='\t')||(LA24_73>='\u000B' && LA24_73<='\f')||(LA24_73>='\u000E' && LA24_73<='!')||(LA24_73>='#' && LA24_73<='[')||(LA24_73>=']' && LA24_73<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_73=='\\') ) {s = 39;}

                         
                        input.seek(index24_73);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_16>='\u0000' && LA24_16<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 50;

                         
                        input.seek(index24_16);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA24_24 = input.LA(1);

                         
                        int index24_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_24>='\u0000' && LA24_24<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 58;

                         
                        input.seek(index24_24);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_12>='\u0000' && LA24_12<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 45;

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA24_20 = input.LA(1);

                         
                        int index24_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_20>='\u0000' && LA24_20<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 54;

                         
                        input.seek(index24_20);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_5=='\n'||LA24_5=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else if ( (LA24_5=='\t'||LA24_5=='\f') ) {s = 7;}

                        else if ( (LA24_5==' ') ) {s = 5;}

                        else if ( ((LA24_5>='\u0000' && LA24_5<='\b')||LA24_5=='\u000B'||(LA24_5>='\u000E' && LA24_5<='\u001F')||(LA24_5>='!' && LA24_5<='\"')||LA24_5=='$'||(LA24_5>='&' && LA24_5<=',')||(LA24_5>='.' && LA24_5<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_5=='-') && ((getCharPositionInLine()==0))) {s = 31;}

                        else s = 30;

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA24_75 = input.LA(1);

                         
                        int index24_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_75=='\n'||LA24_75=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_75=='\"') ) {s = 40;}

                        else if ( ((LA24_75>='\u0000' && LA24_75<='\t')||(LA24_75>='\u000B' && LA24_75<='\f')||(LA24_75>='\u000E' && LA24_75<='!')||(LA24_75>='#' && LA24_75<='[')||(LA24_75>=']' && LA24_75<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_75=='\\') ) {s = 39;}

                         
                        input.seek(index24_75);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA24_74 = input.LA(1);

                         
                        int index24_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_74=='\n'||LA24_74=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_74=='\"') ) {s = 40;}

                        else if ( ((LA24_74>='\u0000' && LA24_74<='\t')||(LA24_74>='\u000B' && LA24_74<='\f')||(LA24_74>='\u000E' && LA24_74<='!')||(LA24_74>='#' && LA24_74<='[')||(LA24_74>=']' && LA24_74<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_74=='\\') ) {s = 39;}

                         
                        input.seek(index24_74);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_13>='-' && LA24_13<='.')||(LA24_13>='0' && LA24_13<='9')||(LA24_13>='A' && LA24_13<='Z')||LA24_13=='_'||(LA24_13>='a' && LA24_13<='z')) ) {s = 46;}

                        else if ( ((LA24_13>='\u0000' && LA24_13<=',')||LA24_13=='/'||(LA24_13>=':' && LA24_13<='@')||(LA24_13>='[' && LA24_13<='^')||LA24_13=='`'||(LA24_13>='{' && LA24_13<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 47;

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA24_23 = input.LA(1);

                         
                        int index24_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_23>='\u0000' && LA24_23<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 57;

                         
                        input.seek(index24_23);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_7=='\r') && (( getCharPositionInLine()==0 ))) {s = 35;}

                        else if ( (LA24_7=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA24_7=='\t'||LA24_7=='\f'||LA24_7==' ') ) {s = 37;}

                        else if ( ((LA24_7>='\u0000' && LA24_7<='\b')||LA24_7=='\u000B'||(LA24_7>='\u000E' && LA24_7<='\u001F')||(LA24_7>='!' && LA24_7<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 34;

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA24_44 = input.LA(1);

                         
                        int index24_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_44>='0' && LA24_44<='9')) ) {s = 44;}

                        else if ( ((LA24_44>='\u0000' && LA24_44<='-')||LA24_44=='/'||(LA24_44>=':' && LA24_44<='D')||(LA24_44>='F' && LA24_44<='d')||(LA24_44>='f' && LA24_44<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_44=='.') ) {s = 42;}

                        else if ( (LA24_44=='E'||LA24_44=='e') ) {s = 43;}

                        else s = 41;

                         
                        input.seek(index24_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA24_85 = input.LA(1);

                         
                        int index24_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_85>='0' && LA24_85<='9')) ) {s = 85;}

                        else if ( ((LA24_85>='\u0000' && LA24_85<='/')||(LA24_85>=':' && LA24_85<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 64;

                         
                        input.seek(index24_85);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA24_18 = input.LA(1);

                         
                        int index24_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_18>='\u0000' && LA24_18<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 52;

                         
                        input.seek(index24_18);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA24_80 = input.LA(1);

                         
                        int index24_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_80>='\u0000' && LA24_80<='/')||(LA24_80>=':' && LA24_80<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_80>='0' && LA24_80<='9')) ) {s = 80;}

                        else s = 64;

                         
                        input.seek(index24_80);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA24_81 = input.LA(1);

                         
                        int index24_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_81>='\u0000' && LA24_81<='/')||(LA24_81>=':' && LA24_81<='@')||(LA24_81>='G' && LA24_81<='`')||(LA24_81>='g' && LA24_81<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_81>='0' && LA24_81<='9')||(LA24_81>='A' && LA24_81<='F')||(LA24_81>='a' && LA24_81<='f')) ) {s = 83;}

                         
                        input.seek(index24_81);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA24_35 = input.LA(1);

                         
                        int index24_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_35=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                         
                        input.seek(index24_35);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA24_70 = input.LA(1);

                         
                        int index24_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_70=='\n'||LA24_70=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_70=='\"') ) {s = 40;}

                        else if ( ((LA24_70>='\u0000' && LA24_70<='\t')||(LA24_70>='\u000B' && LA24_70<='\f')||(LA24_70>='\u000E' && LA24_70<='!')||(LA24_70>='#' && LA24_70<='[')||(LA24_70>=']' && LA24_70<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_70=='\\') ) {s = 39;}

                         
                        input.seek(index24_70);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA24_76 = input.LA(1);

                         
                        int index24_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_76>='\u0000' && LA24_76<='/')||(LA24_76>=':' && LA24_76<='@')||(LA24_76>='G' && LA24_76<='`')||(LA24_76>='g' && LA24_76<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA24_76>='0' && LA24_76<='9')||(LA24_76>='A' && LA24_76<='F')||(LA24_76>='a' && LA24_76<='f')) ) {s = 81;}

                         
                        input.seek(index24_76);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA24_87 = input.LA(1);

                         
                        int index24_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_87=='\n'||LA24_87=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA24_87=='\"') ) {s = 40;}

                        else if ( ((LA24_87>='\u0000' && LA24_87<='\t')||(LA24_87>='\u000B' && LA24_87<='\f')||(LA24_87>='\u000E' && LA24_87<='!')||(LA24_87>='#' && LA24_87<='[')||(LA24_87>=']' && LA24_87<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_87=='\\') ) {s = 39;}

                         
                        input.seek(index24_87);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA24_66 = input.LA(1);

                         
                        int index24_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine()==0 )) ) {s = 28;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_66);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA24_0 = input.LA(1);

                         
                        int index24_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_0=='#') ) {s = 1;}

                        else if ( (LA24_0=='%') ) {s = 2;}

                        else if ( (LA24_0=='\r') ) {s = 3;}

                        else if ( (LA24_0=='\n') ) {s = 4;}

                        else if ( (LA24_0==' ') ) {s = 5;}

                        else if ( (LA24_0=='-') ) {s = 6;}

                        else if ( (LA24_0=='\t'||LA24_0=='\f') ) {s = 7;}

                        else if ( (LA24_0=='\"') ) {s = 8;}

                        else if ( (LA24_0=='0') ) {s = 10;}

                        else if ( ((LA24_0>='1' && LA24_0<='9')) ) {s = 11;}

                        else if ( (LA24_0==':') ) {s = 12;}

                        else if ( ((LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='z')) ) {s = 13;}

                        else if ( (LA24_0=='>') ) {s = 14;}

                        else if ( (LA24_0=='(') ) {s = 15;}

                        else if ( (LA24_0==')') ) {s = 16;}

                        else if ( (LA24_0=='[') ) {s = 17;}

                        else if ( (LA24_0==']') ) {s = 18;}

                        else if ( (LA24_0=='{') ) {s = 19;}

                        else if ( (LA24_0=='}') ) {s = 20;}

                        else if ( (LA24_0==',') ) {s = 21;}

                        else if ( (LA24_0=='.') ) {s = 22;}

                        else if ( (LA24_0=='*') ) {s = 23;}

                        else if ( (LA24_0=='?') ) {s = 24;}

                        else if ( (LA24_0=='+') ) {s = 25;}

                        else if ( (LA24_0=='@') ) {s = 26;}

                        else if ( (LA24_0=='/') ) {s = 27;}

                        else if ( ((LA24_0>='\u0000' && LA24_0<='\b')||LA24_0=='\u000B'||(LA24_0>='\u000E' && LA24_0<='\u001F')||LA24_0=='!'||LA24_0=='$'||(LA24_0>='&' && LA24_0<='\'')||(LA24_0>=';' && LA24_0<='=')||LA24_0=='\\'||LA24_0=='^'||LA24_0=='`'||LA24_0=='|'||(LA24_0>='~' && LA24_0<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 9;

                         
                        input.seek(index24_0);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA24_39 = input.LA(1);

                         
                        int index24_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_39=='\"') ) {s = 68;}

                        else if ( (LA24_39=='\\') ) {s = 69;}

                        else if ( (LA24_39=='/') ) {s = 70;}

                        else if ( (LA24_39=='b') ) {s = 71;}

                        else if ( (LA24_39=='f') ) {s = 72;}

                        else if ( (LA24_39=='n') ) {s = 73;}

                        else if ( (LA24_39=='r') ) {s = 74;}

                        else if ( (LA24_39=='t') ) {s = 75;}

                        else if ( (LA24_39=='u') ) {s = 76;}

                        else if ( ((LA24_39>='\u0000' && LA24_39<='!')||(LA24_39>='#' && LA24_39<='.')||(LA24_39>='0' && LA24_39<='[')||(LA24_39>=']' && LA24_39<='a')||(LA24_39>='c' && LA24_39<='e')||(LA24_39>='g' && LA24_39<='m')||(LA24_39>='o' && LA24_39<='q')||LA24_39=='s'||(LA24_39>='v' && LA24_39<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index24_39);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_15>='\u0000' && LA24_15<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 49;

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA24_36 = input.LA(1);

                         
                        int index24_36 = input.index();
                        input.rewind();
                        s = -1;
                        s = 66;

                         
                        input.seek(index24_36);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
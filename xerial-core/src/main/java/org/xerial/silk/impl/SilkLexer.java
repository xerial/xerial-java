// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-28 18:31:22

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
    public static final int DataType=34;
    public static final int NodeIndicator=13;
    public static final int SilkNode=4;
    public static final int RBrace=39;
    public static final int LBracket=32;
    public static final int Digit=17;
    public static final int Frac=24;
    public static final int HexDigit=18;
    public static final int Plus=43;
    public static final int Occurrence=8;
    public static final int Letter=29;
    public static final int Comma=40;
    public static final int Dot=23;
    public static final int EscapeSequence=20;
    public static final int DataLine=14;
    public static final int Integer=27;
    public static final int Question=42;
    public static final int Colon=44;
    public static final int LineComment=10;
    public static final int SequenceIndicator=35;
    public static final int At=45;
    public static final int Type=9;
    public static final int NameChar=30;
    public static final int SilkAttribute=5;
    public static final int Star=41;
    public static final int Preamble=11;
    public static final int Exp=25;
    public static final int Int=22;
    public static final int RParen=37;
    public static final int UnicodeChar=19;
    public static final int BlankLine=16;
    public static final int StringChar=21;
    public static final int Name=6;
    public static final int LParen=36;
    public static final int String=26;
    public static final int QName=31;
    public static final int EOF=-1;
    public static final int Value=7;
    public static final int Double=28;
    public static final int LBrace=38;
    public static final int RBracket=33;
    public static final int NewLine=12;
    public static final int WhiteSpaces=15;

    // delegates
    // delegators

    public SilkLexer() {;} 
    public SilkLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:18: ~ ( '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:32: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:15: ~ ( '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:29: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:106:8: ( ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:106:10: ( '\\r' )? '\\n'
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:106:10: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:106:10: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:109:14: ({...}? => ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:109:16: {...}? => ( ' ' )* '-'
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "NodeIndicator", "getCharPositionInLine()==0");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:109:49: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:109:50: ' '
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

    // $ANTLR start "DataLine"
    public final void mDataLine() throws RecognitionException {
        try {
            int _type = DataLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:9: ({...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:11: {...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "DataLine", " getCharPositionInLine()==0 ");
            }
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:86: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:111:86: ~ ( '\\n' | '\\r' )
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
            	    break loop7;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:12: ( ( ' ' | '\\t' | '\\u000C' )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:14: ( ' ' | '\\t' | '\\u000C' )+
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:113:14: ( ' ' | '\\t' | '\\u000C' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0=='\f'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:10: ({...}? => ( WhiteSpaces )? ( NewLine | EOF ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:12: {...}? => ( WhiteSpaces )? ( NewLine | EOF )
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "BlankLine", " getCharPositionInLine()==0 ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:47: ( WhiteSpaces )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\t'||LA9_0=='\f'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:47: WhiteSpaces
                    {
                    mWhiteSpaces(); 

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:60: ( NewLine | EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            else {
                alt10=2;}
            switch (alt10) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:61: NewLine
                    {
                    mNewLine(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:115:71: EOF
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:117:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:117:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:21: (~ ( '\"' | '\\\\' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:119:23: ~ ( '\"' | '\\\\' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt11=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt11=1;
                }
                break;
            case '\\':
                {
                alt11=2;
                }
                break;
            case '/':
                {
                alt11=3;
                }
                break;
            case 'b':
                {
                alt11=4;
                }
                break;
            case 'f':
                {
                alt11=5;
                }
                break;
            case 'n':
                {
                alt11=6;
                }
                break;
            case 'r':
                {
                alt11=7;
                }
                break;
            case 't':
                {
                alt11=8;
                }
                break;
            case 'u':
                {
                alt11=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:21: ( UnicodeChar | EscapeSequence )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                alt12=1;
            }
            else if ( (LA12_0=='\\') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:123:38: EscapeSequence
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:15: ( '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:20: ( '0' | '1' .. '9' ( Digit )* )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='0') ) {
                alt15=1;
            }
            else if ( ((LA15_0>='1' && LA15_0<='9')) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:21: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:27: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:36: ( Digit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:36: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:14: ( Dot ( Digit )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:16: Dot ( Digit )+
            {
            mDot(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:20: ( Digit )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:27: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:40: ( Digit )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:7: ( '\"' ( StringChar )* '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:13: ( StringChar )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:13: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:8: ( Int )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:10: Int
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:7: ( Int ( Frac ( Exp )? | Exp ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:10: Int ( Frac ( Exp )? | Exp )
            {
            mInt(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:14: ( Frac ( Exp )? | Exp )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='.') ) {
                alt21=1;
            }
            else if ( (LA21_0=='E'||LA21_0=='e') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:15: Frac ( Exp )?
                    {
                    mFrac(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:20: ( Exp )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:20: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:27: Exp
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

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:141:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:142:18: ( Letter | Digit | '_' | '-' | Dot )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:6: ( ( Letter | '_' ) ( NameChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:8: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:23: ( NameChar )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='-' && LA22_0<='.')||(LA22_0>='0' && LA22_0<='9')||(LA22_0>='A' && LA22_0<='Z')||LA22_0=='_'||(LA22_0>='a' && LA22_0<='z')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:23: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop22;
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

    // $ANTLR start "DataType"
    public final void mDataType() throws RecognitionException {
        try {
            int _type = DataType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:2: ( LBracket (~ RBracket )+ RBracket )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:4: LBracket (~ RBracket )+ RBracket
            {
            mLBracket(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:13: (~ RBracket )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\u0000' && LA23_0<='\\')||(LA23_0>='^' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:14: ~ RBracket
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=' ')||(input.LA(1)>='\"' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);

            mRBracket(); 
             String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DataType"

    // $ANTLR start "SequenceIndicator"
    public final void mSequenceIndicator() throws RecognitionException {
        try {
            int _type = SequenceIndicator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:18: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:20: '>'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:7: ( '{' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:9: '{'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:7: ( '}' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:9: '}'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:8: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:4: ( '.' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:6: '.'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:7: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:7: '+'
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:8: ':'
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

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:5: '@'
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

    public void mTokens() throws RecognitionException {
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | DataType | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | Colon | At )
        int alt24=26;
        alt24 = dfa24.predict(input);
        switch (alt24) {
            case 1 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:10: LineComment
                {
                mLineComment(); 

                }
                break;
            case 2 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:22: Preamble
                {
                mPreamble(); 

                }
                break;
            case 3 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:31: NewLine
                {
                mNewLine(); 

                }
                break;
            case 4 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:39: NodeIndicator
                {
                mNodeIndicator(); 

                }
                break;
            case 5 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:53: DataLine
                {
                mDataLine(); 

                }
                break;
            case 6 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:62: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;
            case 7 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:74: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 8 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:84: String
                {
                mString(); 

                }
                break;
            case 9 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:91: Integer
                {
                mInteger(); 

                }
                break;
            case 10 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:99: Double
                {
                mDouble(); 

                }
                break;
            case 11 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:106: QName
                {
                mQName(); 

                }
                break;
            case 12 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:112: DataType
                {
                mDataType(); 

                }
                break;
            case 13 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:121: SequenceIndicator
                {
                mSequenceIndicator(); 

                }
                break;
            case 14 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:139: LParen
                {
                mLParen(); 

                }
                break;
            case 15 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:146: RParen
                {
                mRParen(); 

                }
                break;
            case 16 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:153: LBracket
                {
                mLBracket(); 

                }
                break;
            case 17 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:162: RBracket
                {
                mRBracket(); 

                }
                break;
            case 18 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:171: LBrace
                {
                mLBrace(); 

                }
                break;
            case 19 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:178: RBrace
                {
                mRBrace(); 

                }
                break;
            case 20 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:185: Comma
                {
                mComma(); 

                }
                break;
            case 21 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:191: Dot
                {
                mDot(); 

                }
                break;
            case 22 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:195: Star
                {
                mStar(); 

                }
                break;
            case 23 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:200: Question
                {
                mQuestion(); 

                }
                break;
            case 24 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:209: Plus
                {
                mPlus(); 

                }
                break;
            case 25 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:214: Colon
                {
                mColon(); 

                }
                break;
            case 26 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:220: At
                {
                mAt(); 

                }
                break;

        }

    }


    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA24_eotS =
        "\1\11\3\uffff\1\34\1\35\1\36\1\42\2\uffff\2\53\1\60\1\61\1\65\1"+
        "\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\4\uffff"+
        "\1\104\2\53\1\uffff\1\107\1\uffff\1\110\2\uffff\1\122\1\uffff\1"+
        "\33\3\uffff\1\53\1\60\4\uffff\1\33\21\uffff\1\53\14\uffff\1\105"+
        "\1\uffff\1\105\1\127\5\uffff\1\105\2\uffff";
    static final String DFA24_eofS =
        "\137\uffff";
    static final String DFA24_minS =
        "\1\0\2\uffff\1\12\1\0\1\11\1\60\2\0\1\uffff\21\0\1\uffff\2\0\1"+
        "\uffff\1\11\2\56\2\0\1\12\6\0\1\uffff\4\0\2\uffff\3\0\17\uffff\1"+
        "\0\1\uffff\1\56\13\0\1\uffff\4\0\1\uffff\7\0";
    static final String DFA24_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\55\1\71\2\uffff\1\uffff\21\uffff\1"+
        "\uffff\2\0\1\uffff\1\40\2\145\1\0\1\uffff\1\12\1\0\5\uffff\1\uffff"+
        "\4\uffff\2\uffff\3\uffff\17\uffff\1\0\1\uffff\1\145\2\0\11\uffff"+
        "\1\uffff\4\uffff\1\uffff\7\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\6\uffff\1\7\21\uffff\1\5\2\uffff\1\4\14\uffff"+
        "\1\11\4\uffff\1\13\1\20\3\uffff\1\15\1\16\1\17\1\21\1\22\1\23\1"+
        "\24\1\25\1\26\1\27\1\30\1\31\1\32\1\3\1\6\1\uffff\1\12\14\uffff"+
        "\1\10\4\uffff\1\14\7\uffff";
    static final String DFA24_specialS =
        "\1\66\4\uffff\1\12\1\73\1\64\1\3\1\uffff\1\71\1\37\1\54\1\72\1"+
        "\20\1\51\1\30\1\57\1\41\1\24\1\63\1\17\1\23\1\36\1\1\1\31\1\45\1"+
        "\uffff\1\52\1\46\1\uffff\1\56\2\uffff\1\47\1\16\1\21\1\67\1\15\1"+
        "\2\1\55\1\32\1\77\1\uffff\1\13\1\26\1\60\1\40\2\uffff\1\53\1\33"+
        "\1\34\17\uffff\1\44\2\uffff\1\43\1\0\1\22\1\27\1\6\1\35\1\75\1\62"+
        "\1\65\1\7\1\42\1\uffff\1\14\1\5\1\10\1\76\1\uffff\1\61\1\25\1\74"+
        "\1\4\1\70\1\50\1\11}>";
    static final String[] DFA24_transitionS = {
            "\11\33\1\7\1\4\1\33\1\7\1\3\22\33\1\5\1\33\1\10\1\1\1\33\1"+
            "\2\2\33\1\17\1\20\1\26\1\30\1\24\1\6\1\25\1\33\1\12\11\13\1"+
            "\31\3\33\1\16\1\27\1\32\32\14\1\15\1\33\1\21\1\33\1\14\1\33"+
            "\32\14\1\22\1\33\1\23\uff82\33",
            "",
            "",
            "\1\4",
            "\1\uffff",
            "\1\37\1\11\1\uffff\1\37\1\11\22\uffff\1\5\14\uffff\1\36",
            "\1\40\11\41",
            "\11\33\1\43\1\45\1\33\1\43\1\44\22\33\1\43\uffdf\33",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "",
            "\56\33\1\54\26\33\1\55\37\33\1\55\uff9a\33",
            "\56\33\1\54\1\33\12\56\13\33\1\55\37\33\1\55\uff9a\33",
            "\55\33\2\57\1\33\12\57\7\33\32\57\4\33\1\57\1\33\32\57\uff85"+
            "\33",
            "\12\62\1\64\2\62\1\63\117\62\1\33\uffa2\62",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\37\1\11\1\uffff\1\37\1\11\22\uffff\1\37",
            "\1\105\26\uffff\1\105\37\uffff\1\105",
            "\1\105\1\uffff\12\106\13\uffff\1\105\37\uffff\1\105",
            "\1\uffff",
            "\11\33\1\43\1\45\1\33\1\43\1\44\22\33\1\43\uffdf\33",
            "\1\45",
            "\1\uffff",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\42\33\1\111\14\33\1\113\54\33\1\112\5\33\1\114\3\33\1\115"+
            "\7\33\1\116\3\33\1\117\1\33\1\120\1\121\uff8a\33",
            "\0\33",
            "\12\122\1\52\ufff5\122",
            "\0\122",
            "",
            "\60\33\12\123\uffc6\33",
            "\53\33\1\124\1\33\1\124\2\33\12\125\uffc6\33",
            "\56\33\1\54\1\33\12\56\13\33\1\55\37\33\1\55\uff9a\33",
            "\55\33\2\57\1\33\12\57\7\33\32\57\4\33\1\57\1\33\32\57\uff85"+
            "\33",
            "",
            "",
            "\12\62\1\64\2\62\1\63\117\62\1\126\uffa2\62",
            "\12\127\1\64\ufff5\127",
            "\0\127",
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
            "\1\uffff",
            "",
            "\1\105\1\uffff\12\106\13\uffff\1\105\37\uffff\1\105",
            "\1\uffff",
            "\1\uffff",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\60\33\12\130\7\33\6\130\32\33\6\130\uff99\33",
            "",
            "\60\33\12\123\13\33\1\131\37\33\1\131\uff9a\33",
            "\60\33\12\125\uffc6\33",
            "\60\33\12\125\uffc6\33",
            "\0\33",
            "",
            "\60\33\12\132\7\33\6\132\32\33\6\132\uff99\33",
            "\53\33\1\133\1\33\1\133\2\33\12\134\uffc6\33",
            "\60\33\12\135\7\33\6\135\32\33\6\135\uff99\33",
            "\60\33\12\134\uffc6\33",
            "\60\33\12\134\uffc6\33",
            "\60\33\12\136\7\33\6\136\32\33\6\136\uff99\33",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46"
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
            return "1:1: Tokens : ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | DataType | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | Colon | At );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_72 = input.LA(1);

                         
                        int index24_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine()==0 )) ) {s = 27;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_72);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_24 = input.LA(1);

                         
                        int index24_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_24>='\u0000' && LA24_24<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 63;

                         
                        input.seek(index24_24);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_39 = input.LA(1);

                         
                        int index24_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_39=='\"') ) {s = 73;}

                        else if ( (LA24_39=='\\') ) {s = 74;}

                        else if ( (LA24_39=='/') ) {s = 75;}

                        else if ( (LA24_39=='b') ) {s = 76;}

                        else if ( (LA24_39=='f') ) {s = 77;}

                        else if ( (LA24_39=='n') ) {s = 78;}

                        else if ( (LA24_39=='r') ) {s = 79;}

                        else if ( (LA24_39=='t') ) {s = 80;}

                        else if ( (LA24_39=='u') ) {s = 81;}

                        else if ( ((LA24_39>='\u0000' && LA24_39<='!')||(LA24_39>='#' && LA24_39<='.')||(LA24_39>='0' && LA24_39<='[')||(LA24_39>=']' && LA24_39<='a')||(LA24_39>='c' && LA24_39<='e')||(LA24_39>='g' && LA24_39<='m')||(LA24_39>='o' && LA24_39<='q')||LA24_39=='s'||(LA24_39>='v' && LA24_39<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_39);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_8 = input.LA(1);

                        s = -1;
                        if ( ((LA24_8>='\u0000' && LA24_8<='\t')||(LA24_8>='\u000B' && LA24_8<='\f')||(LA24_8>='\u000E' && LA24_8<='!')||(LA24_8>='#' && LA24_8<='[')||(LA24_8>=']' && LA24_8<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_8=='\\') ) {s = 39;}

                        else if ( (LA24_8=='\"') ) {s = 40;}

                        else if ( (LA24_8=='\r') ) {s = 41;}

                        else if ( (LA24_8=='\n') ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_91 = input.LA(1);

                         
                        int index24_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_91>='0' && LA24_91<='9')) ) {s = 92;}

                        else if ( ((LA24_91>='\u0000' && LA24_91<='/')||(LA24_91>=':' && LA24_91<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_91);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_84 = input.LA(1);

                         
                        int index24_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_84>='0' && LA24_84<='9')) ) {s = 85;}

                        else if ( ((LA24_84>='\u0000' && LA24_84<='/')||(LA24_84>=':' && LA24_84<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_84);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_75 = input.LA(1);

                        s = -1;
                        if ( (LA24_75=='\r') ) {s = 41;}

                        else if ( (LA24_75=='\n') ) {s = 42;}

                        else if ( (LA24_75=='\"') ) {s = 40;}

                        else if ( ((LA24_75>='\u0000' && LA24_75<='\t')||(LA24_75>='\u000B' && LA24_75<='\f')||(LA24_75>='\u000E' && LA24_75<='!')||(LA24_75>='#' && LA24_75<='[')||(LA24_75>=']' && LA24_75<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_75=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_80 = input.LA(1);

                        s = -1;
                        if ( (LA24_80=='\r') ) {s = 41;}

                        else if ( (LA24_80=='\n') ) {s = 42;}

                        else if ( (LA24_80=='\"') ) {s = 40;}

                        else if ( ((LA24_80>='\u0000' && LA24_80<='\t')||(LA24_80>='\u000B' && LA24_80<='\f')||(LA24_80>='\u000E' && LA24_80<='!')||(LA24_80>='#' && LA24_80<='[')||(LA24_80>=']' && LA24_80<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_80=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_85 = input.LA(1);

                         
                        int index24_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_85>='0' && LA24_85<='9')) ) {s = 85;}

                        else if ( ((LA24_85>='\u0000' && LA24_85<='/')||(LA24_85>=':' && LA24_85<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 69;

                         
                        input.seek(index24_85);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_94 = input.LA(1);

                        s = -1;
                        if ( (LA24_94=='\r') ) {s = 41;}

                        else if ( (LA24_94=='\n') ) {s = 42;}

                        else if ( (LA24_94=='\"') ) {s = 40;}

                        else if ( ((LA24_94>='\u0000' && LA24_94<='\t')||(LA24_94>='\u000B' && LA24_94<='\f')||(LA24_94>='\u000E' && LA24_94<='!')||(LA24_94>='#' && LA24_94<='[')||(LA24_94>=']' && LA24_94<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_94=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_5==' ') ) {s = 5;}

                        else if ( (LA24_5=='-') && ((getCharPositionInLine()==0))) {s = 30;}

                        else if ( (LA24_5=='\t'||LA24_5=='\f') ) {s = 31;}

                        else if ( (LA24_5=='\n'||LA24_5=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else s = 29;

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA24_44 = input.LA(1);

                         
                        int index24_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_44>='0' && LA24_44<='9')) ) {s = 83;}

                        else if ( ((LA24_44>='\u0000' && LA24_44<='/')||(LA24_44>=':' && LA24_44<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_44);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA24_83 = input.LA(1);

                         
                        int index24_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_83=='E'||LA24_83=='e') ) {s = 89;}

                        else if ( ((LA24_83>='0' && LA24_83<='9')) ) {s = 83;}

                        else if ( ((LA24_83>='\u0000' && LA24_83<='/')||(LA24_83>=':' && LA24_83<='D')||(LA24_83>='F' && LA24_83<='d')||(LA24_83>='f' && LA24_83<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 69;

                         
                        input.seek(index24_83);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA24_38 = input.LA(1);

                        s = -1;
                        if ( (LA24_38=='\"') ) {s = 40;}

                        else if ( (LA24_38=='\r') ) {s = 41;}

                        else if ( (LA24_38=='\\') ) {s = 39;}

                        else if ( (LA24_38=='\n') ) {s = 42;}

                        else if ( ((LA24_38>='\u0000' && LA24_38<='\t')||(LA24_38>='\u000B' && LA24_38<='\f')||(LA24_38>='\u000E' && LA24_38<='!')||(LA24_38>='#' && LA24_38<='[')||(LA24_38>=']' && LA24_38<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA24_35 = input.LA(1);

                         
                        int index24_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_35=='\t'||LA24_35=='\f'||LA24_35==' ') ) {s = 35;}

                        else if ( (LA24_35=='\r') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA24_35=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                        else if ( ((LA24_35>='\u0000' && LA24_35<='\b')||LA24_35=='\u000B'||(LA24_35>='\u000E' && LA24_35<='\u001F')||(LA24_35>='!' && LA24_35<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 71;

                         
                        input.seek(index24_35);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA24_21 = input.LA(1);

                         
                        int index24_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_21>='\u0000' && LA24_21<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 60;

                         
                        input.seek(index24_21);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA24_14 = input.LA(1);

                         
                        int index24_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_14>='\u0000' && LA24_14<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 53;

                         
                        input.seek(index24_14);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA24_36 = input.LA(1);

                         
                        int index24_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_36=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                         
                        input.seek(index24_36);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA24_73 = input.LA(1);

                        s = -1;
                        if ( (LA24_73=='\r') ) {s = 41;}

                        else if ( (LA24_73=='\n') ) {s = 42;}

                        else if ( (LA24_73=='\"') ) {s = 40;}

                        else if ( ((LA24_73>='\u0000' && LA24_73<='\t')||(LA24_73>='\u000B' && LA24_73<='\f')||(LA24_73>='\u000E' && LA24_73<='!')||(LA24_73>='#' && LA24_73<='[')||(LA24_73>=']' && LA24_73<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_73=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA24_22 = input.LA(1);

                         
                        int index24_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_22>='\u0000' && LA24_22<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 61;

                         
                        input.seek(index24_22);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA24_19 = input.LA(1);

                         
                        int index24_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_19>='\u0000' && LA24_19<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 58;

                         
                        input.seek(index24_19);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA24_89 = input.LA(1);

                         
                        int index24_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_89=='+'||LA24_89=='-') ) {s = 91;}

                        else if ( ((LA24_89>='0' && LA24_89<='9')) ) {s = 92;}

                        else if ( ((LA24_89>='\u0000' && LA24_89<='*')||LA24_89==','||(LA24_89>='.' && LA24_89<='/')||(LA24_89>=':' && LA24_89<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_89);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA24_45 = input.LA(1);

                         
                        int index24_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_45=='+'||LA24_45=='-') ) {s = 84;}

                        else if ( ((LA24_45>='0' && LA24_45<='9')) ) {s = 85;}

                        else if ( ((LA24_45>='\u0000' && LA24_45<='*')||LA24_45==','||(LA24_45>='.' && LA24_45<='/')||(LA24_45>=':' && LA24_45<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_45);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA24_74 = input.LA(1);

                        s = -1;
                        if ( (LA24_74=='\r') ) {s = 41;}

                        else if ( (LA24_74=='\n') ) {s = 42;}

                        else if ( (LA24_74=='\"') ) {s = 40;}

                        else if ( ((LA24_74>='\u0000' && LA24_74<='\t')||(LA24_74>='\u000B' && LA24_74<='\f')||(LA24_74>='\u000E' && LA24_74<='!')||(LA24_74>='#' && LA24_74<='[')||(LA24_74>=']' && LA24_74<='\uFFFF')) ) {s = 38;}

                        else if ( (LA24_74=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA24_16 = input.LA(1);

                         
                        int index24_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_16>='\u0000' && LA24_16<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 55;

                         
                        input.seek(index24_16);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA24_25 = input.LA(1);

                         
                        int index24_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_25>='\u0000' && LA24_25<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 64;

                         
                        input.seek(index24_25);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA24_41 = input.LA(1);

                        s = -1;
                        if ( ((LA24_41>='\u0000' && LA24_41<='\t')||(LA24_41>='\u000B' && LA24_41<='\uFFFF')) ) {s = 82;}

                        else if ( (LA24_41=='\n') ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA24_51 = input.LA(1);

                        s = -1;
                        if ( ((LA24_51>='\u0000' && LA24_51<='\t')||(LA24_51>='\u000B' && LA24_51<='\uFFFF')) ) {s = 87;}

                        else if ( (LA24_51=='\n') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA24_52 = input.LA(1);

                         
                        int index24_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_52>='\u0000' && LA24_52<='\uFFFF')) ) {s = 87;}

                        else s = 27;

                         
                        input.seek(index24_52);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA24_76 = input.LA(1);

                        s = -1;
                        if ( (LA24_76=='\"') ) {s = 40;}

                        else if ( (LA24_76=='\r') ) {s = 41;}

                        else if ( (LA24_76=='\\') ) {s = 39;}

                        else if ( (LA24_76=='\n') ) {s = 42;}

                        else if ( ((LA24_76>='\u0000' && LA24_76<='\t')||(LA24_76>='\u000B' && LA24_76<='\f')||(LA24_76>='\u000E' && LA24_76<='!')||(LA24_76>='#' && LA24_76<='[')||(LA24_76>=']' && LA24_76<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA24_23 = input.LA(1);

                         
                        int index24_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_23>='\u0000' && LA24_23<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 62;

                         
                        input.seek(index24_23);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_11>='0' && LA24_11<='9')) ) {s = 46;}

                        else if ( (LA24_11=='.') ) {s = 44;}

                        else if ( (LA24_11=='E'||LA24_11=='e') ) {s = 45;}

                        else if ( ((LA24_11>='\u0000' && LA24_11<='-')||LA24_11=='/'||(LA24_11>=':' && LA24_11<='D')||(LA24_11>='F' && LA24_11<='d')||(LA24_11>='f' && LA24_11<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 43;

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA24_47 = input.LA(1);

                         
                        int index24_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_47>='\u0000' && LA24_47<=',')||LA24_47=='/'||(LA24_47>=':' && LA24_47<='@')||(LA24_47>='[' && LA24_47<='^')||LA24_47=='`'||(LA24_47>='{' && LA24_47<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA24_47>='-' && LA24_47<='.')||(LA24_47>='0' && LA24_47<='9')||(LA24_47>='A' && LA24_47<='Z')||LA24_47=='_'||(LA24_47>='a' && LA24_47<='z')) ) {s = 47;}

                        else s = 48;

                         
                        input.seek(index24_47);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA24_18 = input.LA(1);

                         
                        int index24_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_18>='\u0000' && LA24_18<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 57;

                         
                        input.seek(index24_18);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA24_81 = input.LA(1);

                         
                        int index24_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_81>='\u0000' && LA24_81<='/')||(LA24_81>=':' && LA24_81<='@')||(LA24_81>='G' && LA24_81<='`')||(LA24_81>='g' && LA24_81<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA24_81>='0' && LA24_81<='9')||(LA24_81>='A' && LA24_81<='F')||(LA24_81>='a' && LA24_81<='f')) ) {s = 88;}

                         
                        input.seek(index24_81);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA24_71 = input.LA(1);

                         
                        int index24_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 67;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_71);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA24_68 = input.LA(1);

                         
                        int index24_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 67;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_68);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA24_26 = input.LA(1);

                         
                        int index24_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_26>='\u0000' && LA24_26<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 65;

                         
                        input.seek(index24_26);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA24_29 = input.LA(1);

                         
                        int index24_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 67;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_29);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA24_34 = input.LA(1);

                         
                        int index24_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 67;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_34);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA24_93 = input.LA(1);

                         
                        int index24_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_93>='0' && LA24_93<='9')||(LA24_93>='A' && LA24_93<='F')||(LA24_93>='a' && LA24_93<='f')) ) {s = 94;}

                        else if ( ((LA24_93>='\u0000' && LA24_93<='/')||(LA24_93>=':' && LA24_93<='@')||(LA24_93>='G' && LA24_93<='`')||(LA24_93>='g' && LA24_93<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index24_93);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA24_15 = input.LA(1);

                         
                        int index24_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_15>='\u0000' && LA24_15<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 54;

                         
                        input.seek(index24_15);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA24_28 = input.LA(1);

                         
                        int index24_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 66;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index24_28);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA24_50 = input.LA(1);

                        s = -1;
                        if ( (LA24_50==']') ) {s = 86;}

                        else if ( (LA24_50=='\r') ) {s = 51;}

                        else if ( (LA24_50=='\n') ) {s = 52;}

                        else if ( ((LA24_50>='\u0000' && LA24_50<='\t')||(LA24_50>='\u000B' && LA24_50<='\f')||(LA24_50>='\u000E' && LA24_50<='\\')||(LA24_50>='^' && LA24_50<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_12>='-' && LA24_12<='.')||(LA24_12>='0' && LA24_12<='9')||(LA24_12>='A' && LA24_12<='Z')||LA24_12=='_'||(LA24_12>='a' && LA24_12<='z')) ) {s = 47;}

                        else if ( ((LA24_12>='\u0000' && LA24_12<=',')||LA24_12=='/'||(LA24_12>=':' && LA24_12<='@')||(LA24_12>='[' && LA24_12<='^')||LA24_12=='`'||(LA24_12>='{' && LA24_12<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 48;

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA24_40 = input.LA(1);

                         
                        int index24_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_40>='\u0000' && LA24_40<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 82;

                         
                        input.seek(index24_40);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA24_31 = input.LA(1);

                         
                        int index24_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_31=='\t'||LA24_31=='\f'||LA24_31==' ') ) {s = 31;}

                        else if ( (LA24_31=='\n'||LA24_31=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else s = 68;

                         
                        input.seek(index24_31);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA24_17 = input.LA(1);

                         
                        int index24_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_17>='\u0000' && LA24_17<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 56;

                         
                        input.seek(index24_17);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA24_46 = input.LA(1);

                         
                        int index24_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_46=='.') ) {s = 44;}

                        else if ( (LA24_46=='E'||LA24_46=='e') ) {s = 45;}

                        else if ( ((LA24_46>='0' && LA24_46<='9')) ) {s = 46;}

                        else if ( ((LA24_46>='\u0000' && LA24_46<='-')||LA24_46=='/'||(LA24_46>=':' && LA24_46<='D')||(LA24_46>='F' && LA24_46<='d')||(LA24_46>='f' && LA24_46<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 43;

                         
                        input.seek(index24_46);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA24_88 = input.LA(1);

                         
                        int index24_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_88>='\u0000' && LA24_88<='/')||(LA24_88>=':' && LA24_88<='@')||(LA24_88>='G' && LA24_88<='`')||(LA24_88>='g' && LA24_88<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA24_88>='0' && LA24_88<='9')||(LA24_88>='A' && LA24_88<='F')||(LA24_88>='a' && LA24_88<='f')) ) {s = 90;}

                         
                        input.seek(index24_88);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA24_78 = input.LA(1);

                        s = -1;
                        if ( (LA24_78=='\"') ) {s = 40;}

                        else if ( (LA24_78=='\r') ) {s = 41;}

                        else if ( (LA24_78=='\\') ) {s = 39;}

                        else if ( (LA24_78=='\n') ) {s = 42;}

                        else if ( ((LA24_78>='\u0000' && LA24_78<='\t')||(LA24_78>='\u000B' && LA24_78<='\f')||(LA24_78>='\u000E' && LA24_78<='!')||(LA24_78>='#' && LA24_78<='[')||(LA24_78>=']' && LA24_78<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA24_20 = input.LA(1);

                         
                        int index24_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_20>='\u0000' && LA24_20<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 59;

                         
                        input.seek(index24_20);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_7=='\t'||LA24_7=='\f'||LA24_7==' ') ) {s = 35;}

                        else if ( ((LA24_7>='\u0000' && LA24_7<='\b')||LA24_7=='\u000B'||(LA24_7>='\u000E' && LA24_7<='\u001F')||(LA24_7>='!' && LA24_7<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( (LA24_7=='\r') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA24_7=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                        else s = 34;

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA24_79 = input.LA(1);

                        s = -1;
                        if ( (LA24_79=='\"') ) {s = 40;}

                        else if ( (LA24_79=='\r') ) {s = 41;}

                        else if ( (LA24_79=='\\') ) {s = 39;}

                        else if ( (LA24_79=='\n') ) {s = 42;}

                        else if ( ((LA24_79>='\u0000' && LA24_79<='\t')||(LA24_79>='\u000B' && LA24_79<='\f')||(LA24_79>='\u000E' && LA24_79<='!')||(LA24_79>='#' && LA24_79<='[')||(LA24_79>=']' && LA24_79<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
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

                        else if ( ((LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='z')) ) {s = 12;}

                        else if ( (LA24_0=='[') ) {s = 13;}

                        else if ( (LA24_0=='>') ) {s = 14;}

                        else if ( (LA24_0=='(') ) {s = 15;}

                        else if ( (LA24_0==')') ) {s = 16;}

                        else if ( (LA24_0==']') ) {s = 17;}

                        else if ( (LA24_0=='{') ) {s = 18;}

                        else if ( (LA24_0=='}') ) {s = 19;}

                        else if ( (LA24_0==',') ) {s = 20;}

                        else if ( (LA24_0=='.') ) {s = 21;}

                        else if ( (LA24_0=='*') ) {s = 22;}

                        else if ( (LA24_0=='?') ) {s = 23;}

                        else if ( (LA24_0=='+') ) {s = 24;}

                        else if ( (LA24_0==':') ) {s = 25;}

                        else if ( (LA24_0=='@') ) {s = 26;}

                        else if ( ((LA24_0>='\u0000' && LA24_0<='\b')||LA24_0=='\u000B'||(LA24_0>='\u000E' && LA24_0<='\u001F')||LA24_0=='!'||LA24_0=='$'||(LA24_0>='&' && LA24_0<='\'')||LA24_0=='/'||(LA24_0>=';' && LA24_0<='=')||LA24_0=='\\'||LA24_0=='^'||LA24_0=='`'||LA24_0=='|'||(LA24_0>='~' && LA24_0<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 9;

                         
                        input.seek(index24_0);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA24_37 = input.LA(1);

                         
                        int index24_37 = input.index();
                        input.rewind();
                        s = -1;
                        s = 72;

                         
                        input.seek(index24_37);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA24_92 = input.LA(1);

                         
                        int index24_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_92>='0' && LA24_92<='9')) ) {s = 92;}

                        else if ( ((LA24_92>='\u0000' && LA24_92<='/')||(LA24_92>=':' && LA24_92<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 69;

                         
                        input.seek(index24_92);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_10=='.') ) {s = 44;}

                        else if ( (LA24_10=='E'||LA24_10=='e') ) {s = 45;}

                        else if ( ((LA24_10>='\u0000' && LA24_10<='-')||(LA24_10>='/' && LA24_10<='D')||(LA24_10>='F' && LA24_10<='d')||(LA24_10>='f' && LA24_10<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 43;

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA24_13 = input.LA(1);

                         
                        int index24_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_13>='\u0000' && LA24_13<='\t')||(LA24_13>='\u000B' && LA24_13<='\f')||(LA24_13>='\u000E' && LA24_13<='\\')||(LA24_13>='^' && LA24_13<='\uFFFF')) ) {s = 50;}

                        else if ( (LA24_13=='\r') ) {s = 51;}

                        else if ( (LA24_13=='\n') ) {s = 52;}

                        else if ( (LA24_13==']') && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 49;

                         
                        input.seek(index24_13);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_6=='0') ) {s = 32;}

                        else if ( ((LA24_6>='1' && LA24_6<='9')) ) {s = 33;}

                        else s = 30;

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA24_90 = input.LA(1);

                         
                        int index24_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_90>='\u0000' && LA24_90<='/')||(LA24_90>=':' && LA24_90<='@')||(LA24_90>='G' && LA24_90<='`')||(LA24_90>='g' && LA24_90<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA24_90>='0' && LA24_90<='9')||(LA24_90>='A' && LA24_90<='F')||(LA24_90>='a' && LA24_90<='f')) ) {s = 93;}

                         
                        input.seek(index24_90);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA24_77 = input.LA(1);

                        s = -1;
                        if ( (LA24_77=='\"') ) {s = 40;}

                        else if ( (LA24_77=='\r') ) {s = 41;}

                        else if ( (LA24_77=='\\') ) {s = 39;}

                        else if ( (LA24_77=='\n') ) {s = 42;}

                        else if ( ((LA24_77>='\u0000' && LA24_77<='\t')||(LA24_77>='\u000B' && LA24_77<='\f')||(LA24_77>='\u000E' && LA24_77<='!')||(LA24_77>='#' && LA24_77<='[')||(LA24_77>=']' && LA24_77<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA24_86 = input.LA(1);

                         
                        int index24_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_86>='\u0000' && LA24_86<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 87;

                         
                        input.seek(index24_86);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA24_42 = input.LA(1);

                         
                        int index24_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA24_42>='\u0000' && LA24_42<='\uFFFF')) ) {s = 82;}

                        else s = 27;

                         
                        input.seek(index24_42);
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
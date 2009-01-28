// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-28 18:59:48

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
    public static final int DataType=33;
    public static final int NodeIndicator=12;
    public static final int SilkNode=4;
    public static final int RBrace=41;
    public static final int LBracket=31;
    public static final int Digit=16;
    public static final int Frac=23;
    public static final int HexDigit=17;
    public static final int Plus=44;
    public static final int Occurrence=7;
    public static final int Letter=28;
    public static final int Comma=35;
    public static final int Dot=22;
    public static final int EscapeSequence=19;
    public static final int DataLine=13;
    public static final int Integer=26;
    public static final int Question=43;
    public static final int LineComment=9;
    public static final int Colon=34;
    public static final int SequenceIndicator=38;
    public static final int At=45;
    public static final int Type=8;
    public static final int NameChar=29;
    public static final int SilkAttribute=5;
    public static final int Star=42;
    public static final int Preamble=10;
    public static final int Exp=24;
    public static final int Int=21;
    public static final int RParen=36;
    public static final int UnicodeChar=18;
    public static final int BlankLine=15;
    public static final int StringChar=20;
    public static final int Name=6;
    public static final int LParen=39;
    public static final int String=25;
    public static final int QName=30;
    public static final int EOF=-1;
    public static final int Value=37;
    public static final int Double=27;
    public static final int LBrace=40;
    public static final int RBracket=32;
    public static final int NewLine=11;
    public static final int WhiteSpaces=14;

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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:18: ~ ( '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:103:32: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:15: ~ ( '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:104:29: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:8: ( ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:10: ( '\\r' )? '\\n'
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:10: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:105:10: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:108:14: ({...}? => ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:108:16: {...}? => ( ' ' )* '-'
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "NodeIndicator", "getCharPositionInLine()==0");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:108:49: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:108:50: ' '
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:110:9: ({...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:110:11: {...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:110:86: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:110:86: ~ ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:12: ( ( ' ' | '\\t' | '\\u000C' )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:14: ( ' ' | '\\t' | '\\u000C' )+
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:112:14: ( ' ' | '\\t' | '\\u000C' )+
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:10: ({...}? => ( WhiteSpaces )? ( NewLine | EOF ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:12: {...}? => ( WhiteSpaces )? ( NewLine | EOF )
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "BlankLine", " getCharPositionInLine()==0 ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:47: ( WhiteSpaces )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\t'||LA9_0=='\f'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:47: WhiteSpaces
                    {
                    mWhiteSpaces(); 

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:60: ( NewLine | EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            else {
                alt10=2;}
            switch (alt10) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:61: NewLine
                    {
                    mNewLine(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:114:71: EOF
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:116:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:117:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:117:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:21: (~ ( '\"' | '\\\\' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:23: ~ ( '\"' | '\\\\' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:21: ( UnicodeChar | EscapeSequence )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:38: EscapeSequence
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:15: ( '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:20: ( '0' | '1' .. '9' ( Digit )* )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:21: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:27: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:36: ( Digit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:36: Digit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:14: ( Dot ( Digit )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:16: Dot ( Digit )+
            {
            mDot(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:20: ( Digit )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:20: Digit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:27: ( '+' | '-' )?
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:40: ( Digit )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:40: Digit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:7: ( '\"' ( StringChar )* '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:13: ( StringChar )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:129:13: StringChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:8: ( Int )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:10: Int
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:7: ( Int ( Frac ( Exp )? | Exp ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:10: Int ( Frac ( Exp )? | Exp )
            {
            mInt(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:14: ( Frac ( Exp )? | Exp )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:15: Frac ( Exp )?
                    {
                    mFrac(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:20: ( Exp )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:20: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:27: Exp
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:16: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:141:18: ( Letter | Digit | '_' | '-' | Dot )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:142:6: ( ( Letter | '_' ) ( NameChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:142:8: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:142:23: ( NameChar )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='-' && LA22_0<='.')||(LA22_0>='0' && LA22_0<='9')||(LA22_0>='A' && LA22_0<='Z')||LA22_0=='_'||(LA22_0>='a' && LA22_0<='z')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:142:23: NameChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:2: ( LBracket (~ RBracket )+ RBracket )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:4: LBracket (~ RBracket )+ RBracket
            {
            mLBracket(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:13: (~ RBracket )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:14: ~ RBracket
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\uFFFF') ) {
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:15: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:17: ':'
            {
            match(':'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:6: ( Colon (~ ( Comma | RParen | '\\n' ) )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:8: Colon (~ ( Comma | RParen | '\\n' ) )+
            {
            mColon(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:14: (~ ( Comma | RParen | '\\n' ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\u0000' && LA24_0<='\t')||(LA24_0>='\u000B' && LA24_0<='(')||(LA24_0>='*' && LA24_0<='+')||(LA24_0>='-' && LA24_0<='\uFFFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:15: ~ ( Comma | RParen | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='(')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

             setText(getText().substring(1).trim()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "SequenceIndicator"
    public final void mSequenceIndicator() throws RecognitionException {
        try {
            int _type = SequenceIndicator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:18: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:20: '>'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:7: ( '{' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:9: '{'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:7: ( '}' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:9: '}'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:8: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:4: ( '.' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:6: '.'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:7: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:7: '+'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:5: '@'
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
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | DataType | Value | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At )
        int alt25=26;
        alt25 = dfa25.predict(input);
        switch (alt25) {
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
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:121: Value
                {
                mValue(); 

                }
                break;
            case 14 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:127: SequenceIndicator
                {
                mSequenceIndicator(); 

                }
                break;
            case 15 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:145: LParen
                {
                mLParen(); 

                }
                break;
            case 16 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:152: RParen
                {
                mRParen(); 

                }
                break;
            case 17 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:159: LBracket
                {
                mLBracket(); 

                }
                break;
            case 18 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:168: RBracket
                {
                mRBracket(); 

                }
                break;
            case 19 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:177: LBrace
                {
                mLBrace(); 

                }
                break;
            case 20 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:184: RBrace
                {
                mRBrace(); 

                }
                break;
            case 21 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:191: Comma
                {
                mComma(); 

                }
                break;
            case 22 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:197: Dot
                {
                mDot(); 

                }
                break;
            case 23 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:201: Star
                {
                mStar(); 

                }
                break;
            case 24 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:206: Question
                {
                mQuestion(); 

                }
                break;
            case 25 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:215: Plus
                {
                mPlus(); 

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


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\11\3\uffff\1\34\1\35\1\36\1\42\2\uffff\2\53\1\60\1\64\1\uffff"+
        "\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102"+
        "\4\uffff\1\105\2\53\2\uffff\1\110\1\111\2\uffff\1\123\1\uffff\1"+
        "\33\3\uffff\1\53\1\60\3\uffff\1\33\1\uffff\2\131\20\uffff\1\53\14"+
        "\uffff\1\106\1\uffff\1\106\1\130\6\uffff\1\106\2\uffff";
    static final String DFA25_eofS =
        "\141\uffff";
    static final String DFA25_minS =
        "\1\0\2\uffff\1\12\1\0\1\11\1\60\2\0\1\uffff\21\0\1\uffff\2\0\1"+
        "\uffff\1\11\2\56\1\0\1\12\7\0\1\uffff\4\0\1\uffff\3\0\1\uffff\1"+
        "\0\1\12\16\uffff\1\0\1\uffff\1\56\13\0\1\uffff\4\0\2\uffff\7\0";
    static final String DFA25_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\55\1\71\2\uffff\1\uffff\21\uffff\1"+
        "\uffff\2\0\1\uffff\1\40\2\145\1\0\1\12\1\0\6\uffff\1\uffff\4\uffff"+
        "\1\uffff\3\uffff\1\uffff\1\uffff\1\12\16\uffff\1\0\1\uffff\1\145"+
        "\2\0\11\uffff\1\uffff\4\uffff\2\uffff\7\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\2\6\uffff\1\7\21\uffff\1\5\2\uffff\1\4\14\uffff"+
        "\1\11\4\uffff\1\13\3\uffff\1\21\2\uffff\1\16\1\17\1\20\1\22\1\23"+
        "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\3\1\6\1\uffff\1\12\14\uffff"+
        "\1\10\4\uffff\1\14\1\15\7\uffff";
    static final String DFA25_specialS =
        "\1\35\4\uffff\1\100\1\54\1\37\1\44\1\uffff\1\65\1\2\1\4\1\46\1"+
        "\27\1\47\1\66\1\56\1\62\1\72\1\30\1\3\1\74\1\70\1\16\1\10\1\11\1"+
        "\uffff\1\63\1\24\1\uffff\1\51\2\uffff\1\23\1\43\1\64\1\13\1\53\1"+
        "\22\1\42\1\12\1\50\1\uffff\1\14\1\57\1\32\1\15\1\uffff\1\61\1\67"+
        "\1\77\1\uffff\1\45\1\31\16\uffff\1\25\2\uffff\1\17\1\26\1\5\1\0"+
        "\1\33\1\36\1\20\1\1\1\7\1\34\1\55\1\uffff\1\76\1\40\1\6\1\71\2\uffff"+
        "\1\21\1\60\1\73\1\41\1\52\1\101\1\75}>";
    static final String[] DFA25_transitionS = {
            "\11\33\1\7\1\4\1\33\1\7\1\3\22\33\1\5\1\33\1\10\1\1\1\33\1"+
            "\2\2\33\1\20\1\21\1\27\1\31\1\25\1\6\1\26\1\33\1\12\11\13\1"+
            "\16\3\33\1\17\1\30\1\32\32\14\1\15\1\33\1\22\1\33\1\14\1\33"+
            "\32\14\1\23\1\33\1\24\uff82\33",
            "",
            "",
            "\1\4",
            "\1\uffff",
            "\1\37\1\11\1\uffff\1\37\1\11\22\uffff\1\5\14\uffff\1\36",
            "\1\40\11\41",
            "\11\33\1\45\1\44\1\33\1\45\1\43\22\33\1\45\uffdf\33",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "",
            "\56\33\1\54\26\33\1\55\37\33\1\55\uff9a\33",
            "\56\33\1\54\1\33\12\56\13\33\1\55\37\33\1\55\uff9a\33",
            "\55\33\2\57\1\33\12\57\7\33\32\57\4\33\1\57\1\33\32\57\uff85"+
            "\33",
            "\12\61\1\63\2\61\1\62\117\61\1\33\uffa2\61",
            "\12\65\1\33\2\65\1\66\33\65\1\33\2\65\1\33\uffd3\65",
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
            "\1\106\26\uffff\1\106\37\uffff\1\106",
            "\1\106\1\uffff\12\107\13\uffff\1\106\37\uffff\1\106",
            "\1\uffff",
            "\1\44",
            "\1\uffff",
            "\11\33\1\45\1\44\1\33\1\45\1\43\22\33\1\45\uffdf\33",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46",
            "\42\33\1\112\14\33\1\114\54\33\1\113\5\33\1\115\3\33\1\116"+
            "\7\33\1\117\3\33\1\120\1\33\1\121\1\122\uff8a\33",
            "\0\33",
            "\12\123\1\52\ufff5\123",
            "\0\123",
            "",
            "\60\33\12\124\uffc6\33",
            "\53\33\1\125\1\33\1\125\2\33\12\126\uffc6\33",
            "\56\33\1\54\1\33\12\56\13\33\1\55\37\33\1\55\uff9a\33",
            "\55\33\2\57\1\33\12\57\7\33\32\57\4\33\1\57\1\33\32\57\uff85"+
            "\33",
            "",
            "\12\61\1\63\2\61\1\62\117\61\1\127\uffa2\61",
            "\12\130\1\63\ufff5\130",
            "\0\130",
            "",
            "\12\65\1\33\2\65\1\66\33\65\1\33\2\65\1\33\uffd3\65",
            "\1\33",
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
            "\1\106\1\uffff\12\107\13\uffff\1\106\37\uffff\1\106",
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
            "\60\33\12\132\7\33\6\132\32\33\6\132\uff99\33",
            "",
            "\60\33\12\124\13\33\1\133\37\33\1\133\uff9a\33",
            "\60\33\12\126\uffc6\33",
            "\60\33\12\126\uffc6\33",
            "\0\33",
            "",
            "",
            "\60\33\12\134\7\33\6\134\32\33\6\134\uff99\33",
            "\53\33\1\135\1\33\1\135\2\33\12\136\uffc6\33",
            "\60\33\12\137\7\33\6\137\32\33\6\137\uff99\33",
            "\60\33\12\136\uffc6\33",
            "\60\33\12\136\uffc6\33",
            "\60\33\12\140\7\33\6\140\32\33\6\140\uff99\33",
            "\12\46\1\52\2\46\1\51\24\46\1\50\71\46\1\47\uffa3\46"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | DataType | Value | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_75 = input.LA(1);

                        s = -1;
                        if ( (LA25_75=='\r') ) {s = 41;}

                        else if ( (LA25_75=='\n') ) {s = 42;}

                        else if ( (LA25_75=='\"') ) {s = 40;}

                        else if ( ((LA25_75>='\u0000' && LA25_75<='\t')||(LA25_75>='\u000B' && LA25_75<='\f')||(LA25_75>='\u000E' && LA25_75<='!')||(LA25_75>='#' && LA25_75<='[')||(LA25_75>=']' && LA25_75<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_75=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_79 = input.LA(1);

                        s = -1;
                        if ( (LA25_79=='\r') ) {s = 41;}

                        else if ( (LA25_79=='\n') ) {s = 42;}

                        else if ( (LA25_79=='\"') ) {s = 40;}

                        else if ( ((LA25_79>='\u0000' && LA25_79<='\t')||(LA25_79>='\u000B' && LA25_79<='\f')||(LA25_79>='\u000E' && LA25_79<='!')||(LA25_79>='#' && LA25_79<='[')||(LA25_79>=']' && LA25_79<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_79=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_11 = input.LA(1);

                         
                        int index25_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_11>='0' && LA25_11<='9')) ) {s = 46;}

                        else if ( (LA25_11=='.') ) {s = 44;}

                        else if ( (LA25_11=='E'||LA25_11=='e') ) {s = 45;}

                        else if ( ((LA25_11>='\u0000' && LA25_11<='-')||LA25_11=='/'||(LA25_11>=':' && LA25_11<='D')||(LA25_11>='F' && LA25_11<='d')||(LA25_11>='f' && LA25_11<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 43;

                         
                        input.seek(index25_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_21 = input.LA(1);

                         
                        int index25_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_21>='\u0000' && LA25_21<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 61;

                         
                        input.seek(index25_21);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_12 = input.LA(1);

                         
                        int index25_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_12>='-' && LA25_12<='.')||(LA25_12>='0' && LA25_12<='9')||(LA25_12>='A' && LA25_12<='Z')||LA25_12=='_'||(LA25_12>='a' && LA25_12<='z')) ) {s = 47;}

                        else if ( ((LA25_12>='\u0000' && LA25_12<=',')||LA25_12=='/'||(LA25_12>=':' && LA25_12<='@')||(LA25_12>='[' && LA25_12<='^')||LA25_12=='`'||(LA25_12>='{' && LA25_12<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 48;

                         
                        input.seek(index25_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_74 = input.LA(1);

                        s = -1;
                        if ( (LA25_74=='\r') ) {s = 41;}

                        else if ( (LA25_74=='\n') ) {s = 42;}

                        else if ( (LA25_74=='\"') ) {s = 40;}

                        else if ( ((LA25_74>='\u0000' && LA25_74<='\t')||(LA25_74>='\u000B' && LA25_74<='\f')||(LA25_74>='\u000E' && LA25_74<='!')||(LA25_74>='#' && LA25_74<='[')||(LA25_74>=']' && LA25_74<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_74=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_86 = input.LA(1);

                         
                        int index25_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_86>='\u0000' && LA25_86<='/')||(LA25_86>=':' && LA25_86<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_86>='0' && LA25_86<='9')) ) {s = 86;}

                        else s = 70;

                         
                        input.seek(index25_86);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_80 = input.LA(1);

                        s = -1;
                        if ( (LA25_80=='\r') ) {s = 41;}

                        else if ( (LA25_80=='\n') ) {s = 42;}

                        else if ( (LA25_80=='\"') ) {s = 40;}

                        else if ( ((LA25_80>='\u0000' && LA25_80<='\t')||(LA25_80>='\u000B' && LA25_80<='\f')||(LA25_80>='\u000E' && LA25_80<='!')||(LA25_80>='#' && LA25_80<='[')||(LA25_80>=']' && LA25_80<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_80=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_25 = input.LA(1);

                         
                        int index25_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_25>='\u0000' && LA25_25<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 65;

                         
                        input.seek(index25_25);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_26 = input.LA(1);

                         
                        int index25_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_26>='\u0000' && LA25_26<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 66;

                         
                        input.seek(index25_26);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_41 = input.LA(1);

                        s = -1;
                        if ( ((LA25_41>='\u0000' && LA25_41<='\t')||(LA25_41>='\u000B' && LA25_41<='\uFFFF')) ) {s = 83;}

                        else if ( (LA25_41=='\n') ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_37 = input.LA(1);

                         
                        int index25_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_37=='\r') && (( getCharPositionInLine()==0 ))) {s = 35;}

                        else if ( (LA25_37=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA25_37=='\t'||LA25_37=='\f'||LA25_37==' ') ) {s = 37;}

                        else if ( ((LA25_37>='\u0000' && LA25_37<='\b')||LA25_37=='\u000B'||(LA25_37>='\u000E' && LA25_37<='\u001F')||(LA25_37>='!' && LA25_37<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 73;

                         
                        input.seek(index25_37);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_44 = input.LA(1);

                         
                        int index25_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_44>='\u0000' && LA25_44<='/')||(LA25_44>=':' && LA25_44<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_44>='0' && LA25_44<='9')) ) {s = 84;}

                         
                        input.seek(index25_44);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_47 = input.LA(1);

                         
                        int index25_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_47>='\u0000' && LA25_47<=',')||LA25_47=='/'||(LA25_47>=':' && LA25_47<='@')||(LA25_47>='[' && LA25_47<='^')||LA25_47=='`'||(LA25_47>='{' && LA25_47<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_47>='-' && LA25_47<='.')||(LA25_47>='0' && LA25_47<='9')||(LA25_47>='A' && LA25_47<='Z')||LA25_47=='_'||(LA25_47>='a' && LA25_47<='z')) ) {s = 47;}

                        else s = 48;

                         
                        input.seek(index25_47);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_24 = input.LA(1);

                         
                        int index25_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_24>='\u0000' && LA25_24<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 64;

                         
                        input.seek(index25_24);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_72 = input.LA(1);

                         
                        int index25_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine()==0 )) ) {s = 27;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_72);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_78 = input.LA(1);

                        s = -1;
                        if ( (LA25_78=='\r') ) {s = 41;}

                        else if ( (LA25_78=='\n') ) {s = 42;}

                        else if ( (LA25_78=='\"') ) {s = 40;}

                        else if ( ((LA25_78>='\u0000' && LA25_78<='\t')||(LA25_78>='\u000B' && LA25_78<='\f')||(LA25_78>='\u000E' && LA25_78<='!')||(LA25_78>='#' && LA25_78<='[')||(LA25_78>=']' && LA25_78<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_78=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_90 = input.LA(1);

                         
                        int index25_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_90>='\u0000' && LA25_90<='/')||(LA25_90>=':' && LA25_90<='@')||(LA25_90>='G' && LA25_90<='`')||(LA25_90>='g' && LA25_90<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_90>='0' && LA25_90<='9')||(LA25_90>='A' && LA25_90<='F')||(LA25_90>='a' && LA25_90<='f')) ) {s = 92;}

                         
                        input.seek(index25_90);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_39 = input.LA(1);

                         
                        int index25_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_39>='\u0000' && LA25_39<='!')||(LA25_39>='#' && LA25_39<='.')||(LA25_39>='0' && LA25_39<='[')||(LA25_39>=']' && LA25_39<='a')||(LA25_39>='c' && LA25_39<='e')||(LA25_39>='g' && LA25_39<='m')||(LA25_39>='o' && LA25_39<='q')||LA25_39=='s'||(LA25_39>='v' && LA25_39<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( (LA25_39=='\"') ) {s = 74;}

                        else if ( (LA25_39=='\\') ) {s = 75;}

                        else if ( (LA25_39=='/') ) {s = 76;}

                        else if ( (LA25_39=='b') ) {s = 77;}

                        else if ( (LA25_39=='f') ) {s = 78;}

                        else if ( (LA25_39=='n') ) {s = 79;}

                        else if ( (LA25_39=='r') ) {s = 80;}

                        else if ( (LA25_39=='t') ) {s = 81;}

                        else if ( (LA25_39=='u') ) {s = 82;}

                         
                        input.seek(index25_39);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_34 = input.LA(1);

                         
                        int index25_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 68;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_34);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_29 = input.LA(1);

                         
                        int index25_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 68;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_29);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_69 = input.LA(1);

                         
                        int index25_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 68;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_69);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_73 = input.LA(1);

                         
                        int index25_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 68;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_73);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA25_14 = input.LA(1);

                         
                        int index25_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_14>='\u0000' && LA25_14<='\t')||(LA25_14>='\u000B' && LA25_14<='\f')||(LA25_14>='\u000E' && LA25_14<='(')||(LA25_14>='*' && LA25_14<='+')||(LA25_14>='-' && LA25_14<='\uFFFF')) ) {s = 53;}

                        else if ( (LA25_14=='\r') ) {s = 54;}

                        else if ( (LA25_14=='\n'||LA25_14==')'||LA25_14==',') && (( getCharPositionInLine()==0 ))) {s = 27;}

                         
                        input.seek(index25_14);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA25_20 = input.LA(1);

                         
                        int index25_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_20>='\u0000' && LA25_20<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 60;

                         
                        input.seek(index25_20);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA25_54 = input.LA(1);

                         
                        int index25_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_54=='\n') && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 89;

                         
                        input.seek(index25_54);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA25_46 = input.LA(1);

                         
                        int index25_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_46>='\u0000' && LA25_46<='-')||LA25_46=='/'||(LA25_46>=':' && LA25_46<='D')||(LA25_46>='F' && LA25_46<='d')||(LA25_46>='f' && LA25_46<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_46>='0' && LA25_46<='9')) ) {s = 46;}

                        else if ( (LA25_46=='.') ) {s = 44;}

                        else if ( (LA25_46=='E'||LA25_46=='e') ) {s = 45;}

                        else s = 43;

                         
                        input.seek(index25_46);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA25_76 = input.LA(1);

                        s = -1;
                        if ( (LA25_76=='\r') ) {s = 41;}

                        else if ( (LA25_76=='\n') ) {s = 42;}

                        else if ( (LA25_76=='\"') ) {s = 40;}

                        else if ( ((LA25_76>='\u0000' && LA25_76<='\t')||(LA25_76>='\u000B' && LA25_76<='\f')||(LA25_76>='\u000E' && LA25_76<='!')||(LA25_76>='#' && LA25_76<='[')||(LA25_76>=']' && LA25_76<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_76=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA25_81 = input.LA(1);

                        s = -1;
                        if ( (LA25_81=='\r') ) {s = 41;}

                        else if ( (LA25_81=='\n') ) {s = 42;}

                        else if ( (LA25_81=='\"') ) {s = 40;}

                        else if ( ((LA25_81>='\u0000' && LA25_81<='\t')||(LA25_81>='\u000B' && LA25_81<='\f')||(LA25_81>='\u000E' && LA25_81<='!')||(LA25_81>='#' && LA25_81<='[')||(LA25_81>=']' && LA25_81<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_81=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_0=='#') ) {s = 1;}

                        else if ( (LA25_0=='%') ) {s = 2;}

                        else if ( (LA25_0=='\r') ) {s = 3;}

                        else if ( (LA25_0=='\n') ) {s = 4;}

                        else if ( (LA25_0==' ') ) {s = 5;}

                        else if ( (LA25_0=='-') ) {s = 6;}

                        else if ( (LA25_0=='\t'||LA25_0=='\f') ) {s = 7;}

                        else if ( (LA25_0=='\"') ) {s = 8;}

                        else if ( (LA25_0=='0') ) {s = 10;}

                        else if ( ((LA25_0>='1' && LA25_0<='9')) ) {s = 11;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {s = 12;}

                        else if ( (LA25_0=='[') ) {s = 13;}

                        else if ( (LA25_0==':') ) {s = 14;}

                        else if ( (LA25_0=='>') ) {s = 15;}

                        else if ( (LA25_0=='(') ) {s = 16;}

                        else if ( (LA25_0==')') ) {s = 17;}

                        else if ( (LA25_0==']') ) {s = 18;}

                        else if ( (LA25_0=='{') ) {s = 19;}

                        else if ( (LA25_0=='}') ) {s = 20;}

                        else if ( (LA25_0==',') ) {s = 21;}

                        else if ( (LA25_0=='.') ) {s = 22;}

                        else if ( (LA25_0=='*') ) {s = 23;}

                        else if ( (LA25_0=='?') ) {s = 24;}

                        else if ( (LA25_0=='+') ) {s = 25;}

                        else if ( (LA25_0=='@') ) {s = 26;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||LA25_0=='\u000B'||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='!'||LA25_0=='$'||(LA25_0>='&' && LA25_0<='\'')||LA25_0=='/'||(LA25_0>=';' && LA25_0<='=')||LA25_0=='\\'||LA25_0=='^'||LA25_0=='`'||LA25_0=='|'||(LA25_0>='~' && LA25_0<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 9;

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA25_77 = input.LA(1);

                        s = -1;
                        if ( (LA25_77=='\r') ) {s = 41;}

                        else if ( (LA25_77=='\n') ) {s = 42;}

                        else if ( (LA25_77=='\"') ) {s = 40;}

                        else if ( ((LA25_77>='\u0000' && LA25_77<='\t')||(LA25_77>='\u000B' && LA25_77<='\f')||(LA25_77>='\u000E' && LA25_77<='!')||(LA25_77>='#' && LA25_77<='[')||(LA25_77>=']' && LA25_77<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_77=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_7=='\r') && (( getCharPositionInLine()==0 ))) {s = 35;}

                        else if ( (LA25_7=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA25_7=='\t'||LA25_7=='\f'||LA25_7==' ') ) {s = 37;}

                        else if ( ((LA25_7>='\u0000' && LA25_7<='\b')||LA25_7=='\u000B'||(LA25_7>='\u000E' && LA25_7<='\u001F')||(LA25_7>='!' && LA25_7<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 34;

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA25_85 = input.LA(1);

                         
                        int index25_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_85>='\u0000' && LA25_85<='/')||(LA25_85>=':' && LA25_85<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_85>='0' && LA25_85<='9')) ) {s = 86;}

                         
                        input.seek(index25_85);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA25_93 = input.LA(1);

                         
                        int index25_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_93>='\u0000' && LA25_93<='/')||(LA25_93>=':' && LA25_93<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_93>='0' && LA25_93<='9')) ) {s = 94;}

                         
                        input.seek(index25_93);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA25_40 = input.LA(1);

                         
                        int index25_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_40>='\u0000' && LA25_40<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 83;

                         
                        input.seek(index25_40);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA25_35 = input.LA(1);

                         
                        int index25_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_35=='\n') && (( getCharPositionInLine()==0 ))) {s = 36;}

                         
                        input.seek(index25_35);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA25_8 = input.LA(1);

                        s = -1;
                        if ( ((LA25_8>='\u0000' && LA25_8<='\t')||(LA25_8>='\u000B' && LA25_8<='\f')||(LA25_8>='\u000E' && LA25_8<='!')||(LA25_8>='#' && LA25_8<='[')||(LA25_8>=']' && LA25_8<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_8=='\\') ) {s = 39;}

                        else if ( (LA25_8=='\"') ) {s = 40;}

                        else if ( (LA25_8=='\r') ) {s = 41;}

                        else if ( (LA25_8=='\n') ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA25_53 = input.LA(1);

                         
                        int index25_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_53=='\r') ) {s = 54;}

                        else if ( (LA25_53=='\n'||LA25_53==')'||LA25_53==',') && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_53>='\u0000' && LA25_53<='\t')||(LA25_53>='\u000B' && LA25_53<='\f')||(LA25_53>='\u000E' && LA25_53<='(')||(LA25_53>='*' && LA25_53<='+')||(LA25_53>='-' && LA25_53<='\uFFFF')) ) {s = 53;}

                        else s = 89;

                         
                        input.seek(index25_53);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_13>='\u0000' && LA25_13<='\t')||(LA25_13>='\u000B' && LA25_13<='\f')||(LA25_13>='\u000E' && LA25_13<='\\')||(LA25_13>='^' && LA25_13<='\uFFFF')) ) {s = 49;}

                        else if ( (LA25_13=='\r') ) {s = 50;}

                        else if ( (LA25_13=='\n') ) {s = 51;}

                        else if ( (LA25_13==']') && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 52;

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA25_15 = input.LA(1);

                         
                        int index25_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_15>='\u0000' && LA25_15<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 55;

                         
                        input.seek(index25_15);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA25_42 = input.LA(1);

                         
                        int index25_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_42>='\u0000' && LA25_42<='\uFFFF')) ) {s = 83;}

                        else s = 27;

                         
                        input.seek(index25_42);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA25_31 = input.LA(1);

                         
                        int index25_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_31=='\n'||LA25_31=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else if ( (LA25_31=='\t'||LA25_31=='\f'||LA25_31==' ') ) {s = 31;}

                        else s = 69;

                         
                        input.seek(index25_31);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA25_94 = input.LA(1);

                         
                        int index25_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_94>='0' && LA25_94<='9')) ) {s = 94;}

                        else if ( ((LA25_94>='\u0000' && LA25_94<='/')||(LA25_94>=':' && LA25_94<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 70;

                         
                        input.seek(index25_94);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA25_38 = input.LA(1);

                        s = -1;
                        if ( (LA25_38=='\r') ) {s = 41;}

                        else if ( (LA25_38=='\n') ) {s = 42;}

                        else if ( (LA25_38=='\"') ) {s = 40;}

                        else if ( ((LA25_38>='\u0000' && LA25_38<='\t')||(LA25_38>='\u000B' && LA25_38<='\f')||(LA25_38>='\u000E' && LA25_38<='!')||(LA25_38>='#' && LA25_38<='[')||(LA25_38>=']' && LA25_38<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_38=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_6=='0') ) {s = 32;}

                        else if ( ((LA25_6>='1' && LA25_6<='9')) ) {s = 33;}

                        else s = 30;

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA25_82 = input.LA(1);

                         
                        int index25_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_82>='\u0000' && LA25_82<='/')||(LA25_82>=':' && LA25_82<='@')||(LA25_82>='G' && LA25_82<='`')||(LA25_82>='g' && LA25_82<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_82>='0' && LA25_82<='9')||(LA25_82>='A' && LA25_82<='F')||(LA25_82>='a' && LA25_82<='f')) ) {s = 90;}

                         
                        input.seek(index25_82);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA25_17 = input.LA(1);

                         
                        int index25_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_17>='\u0000' && LA25_17<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 57;

                         
                        input.seek(index25_17);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA25_45 = input.LA(1);

                         
                        int index25_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_45>='\u0000' && LA25_45<='*')||LA25_45==','||(LA25_45>='.' && LA25_45<='/')||(LA25_45>=':' && LA25_45<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( (LA25_45=='+'||LA25_45=='-') ) {s = 85;}

                        else if ( ((LA25_45>='0' && LA25_45<='9')) ) {s = 86;}

                         
                        input.seek(index25_45);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA25_91 = input.LA(1);

                         
                        int index25_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_91>='\u0000' && LA25_91<='*')||LA25_91==','||(LA25_91>='.' && LA25_91<='/')||(LA25_91>=':' && LA25_91<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( (LA25_91=='+'||LA25_91=='-') ) {s = 93;}

                        else if ( ((LA25_91>='0' && LA25_91<='9')) ) {s = 94;}

                         
                        input.seek(index25_91);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA25_49 = input.LA(1);

                        s = -1;
                        if ( (LA25_49=='\r') ) {s = 50;}

                        else if ( (LA25_49=='\n') ) {s = 51;}

                        else if ( (LA25_49==']') ) {s = 87;}

                        else if ( ((LA25_49>='\u0000' && LA25_49<='\t')||(LA25_49>='\u000B' && LA25_49<='\f')||(LA25_49>='\u000E' && LA25_49<='\\')||(LA25_49>='^' && LA25_49<='\uFFFF')) ) {s = 49;}

                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA25_18 = input.LA(1);

                         
                        int index25_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_18>='\u0000' && LA25_18<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 58;

                         
                        input.seek(index25_18);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA25_28 = input.LA(1);

                         
                        int index25_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 67;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index25_28);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA25_36 = input.LA(1);

                         
                        int index25_36 = input.index();
                        input.rewind();
                        s = -1;
                        s = 72;

                         
                        input.seek(index25_36);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA25_10 = input.LA(1);

                         
                        int index25_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_10=='.') ) {s = 44;}

                        else if ( (LA25_10=='E'||LA25_10=='e') ) {s = 45;}

                        else if ( ((LA25_10>='\u0000' && LA25_10<='-')||(LA25_10>='/' && LA25_10<='D')||(LA25_10>='F' && LA25_10<='d')||(LA25_10>='f' && LA25_10<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 43;

                         
                        input.seek(index25_10);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA25_16 = input.LA(1);

                         
                        int index25_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_16>='\u0000' && LA25_16<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 56;

                         
                        input.seek(index25_16);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA25_50 = input.LA(1);

                        s = -1;
                        if ( (LA25_50=='\n') ) {s = 51;}

                        else if ( ((LA25_50>='\u0000' && LA25_50<='\t')||(LA25_50>='\u000B' && LA25_50<='\uFFFF')) ) {s = 88;}

                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA25_23 = input.LA(1);

                         
                        int index25_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_23>='\u0000' && LA25_23<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 63;

                         
                        input.seek(index25_23);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA25_87 = input.LA(1);

                         
                        int index25_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_87>='\u0000' && LA25_87<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 88;

                         
                        input.seek(index25_87);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA25_19 = input.LA(1);

                         
                        int index25_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_19>='\u0000' && LA25_19<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 59;

                         
                        input.seek(index25_19);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA25_92 = input.LA(1);

                         
                        int index25_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_92>='\u0000' && LA25_92<='/')||(LA25_92>=':' && LA25_92<='@')||(LA25_92>='G' && LA25_92<='`')||(LA25_92>='g' && LA25_92<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_92>='0' && LA25_92<='9')||(LA25_92>='A' && LA25_92<='F')||(LA25_92>='a' && LA25_92<='f')) ) {s = 95;}

                         
                        input.seek(index25_92);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA25_22 = input.LA(1);

                         
                        int index25_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_22>='\u0000' && LA25_22<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else s = 62;

                         
                        input.seek(index25_22);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA25_96 = input.LA(1);

                        s = -1;
                        if ( (LA25_96=='\r') ) {s = 41;}

                        else if ( (LA25_96=='\n') ) {s = 42;}

                        else if ( (LA25_96=='\"') ) {s = 40;}

                        else if ( ((LA25_96>='\u0000' && LA25_96<='\t')||(LA25_96>='\u000B' && LA25_96<='\f')||(LA25_96>='\u000E' && LA25_96<='!')||(LA25_96>='#' && LA25_96<='[')||(LA25_96>=']' && LA25_96<='\uFFFF')) ) {s = 38;}

                        else if ( (LA25_96=='\\') ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA25_84 = input.LA(1);

                         
                        int index25_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_84>='\u0000' && LA25_84<='/')||(LA25_84>=':' && LA25_84<='D')||(LA25_84>='F' && LA25_84<='d')||(LA25_84>='f' && LA25_84<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( (LA25_84=='E'||LA25_84=='e') ) {s = 91;}

                        else if ( ((LA25_84>='0' && LA25_84<='9')) ) {s = 84;}

                        else s = 70;

                         
                        input.seek(index25_84);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA25_51 = input.LA(1);

                         
                        int index25_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_51>='\u0000' && LA25_51<='\uFFFF')) ) {s = 88;}

                        else s = 27;

                         
                        input.seek(index25_51);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_5=='\n'||LA25_5=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else if ( (LA25_5==' ') ) {s = 5;}

                        else if ( (LA25_5=='-') && ((getCharPositionInLine()==0))) {s = 30;}

                        else if ( (LA25_5=='\t'||LA25_5=='\f') ) {s = 31;}

                        else s = 29;

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA25_95 = input.LA(1);

                         
                        int index25_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_95>='\u0000' && LA25_95<='/')||(LA25_95>=':' && LA25_95<='@')||(LA25_95>='G' && LA25_95<='`')||(LA25_95>='g' && LA25_95<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 27;}

                        else if ( ((LA25_95>='0' && LA25_95<='9')||(LA25_95>='A' && LA25_95<='F')||(LA25_95>='a' && LA25_95<='f')) ) {s = 96;}

                         
                        input.seek(index25_95);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
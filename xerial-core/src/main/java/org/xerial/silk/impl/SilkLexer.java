// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-28 23:18:45

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
    public static final int RBrace=43;
    public static final int SilkNode=4;
    public static final int LBracket=40;
    public static final int Digit=21;
    public static final int Frac=28;
    public static final int HexDigit=22;
    public static final int Plus=47;
    public static final int Occurrence=8;
    public static final int Argument=11;
    public static final int Letter=34;
    public static final int Comma=44;
    public static final int Dot=27;
    public static final int EscapeSequence=24;
    public static final int Slash=49;
    public static final int DataLine=18;
    public static final int Integer=31;
    public static final int Question=46;
    public static final int LineComment=14;
    public static final int Colon=33;
    public static final int SequenceIndicator=37;
    public static final int At=48;
    public static final int NameChar=35;
    public static final int SilkAttribute=5;
    public static final int KeyValuePair=12;
    public static final int Star=45;
    public static final int Preamble=15;
    public static final int Exp=29;
    public static final int Int=26;
    public static final int RParen=39;
    public static final int UnicodeChar=23;
    public static final int BlankLine=20;
    public static final int StringChar=25;
    public static final int Function=10;
    public static final int Name=6;
    public static final int LParen=38;
    public static final int String=30;
    public static final int QName=36;
    public static final int EOF=-1;
    public static final int Value=7;
    public static final int LBrace=42;
    public static final int Double=32;
    public static final int RBracket=41;
    public static final int NewLine=16;
    public static final int WhiteSpaces=19;

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

    // $ANTLR start "DataLine"
    public final void mDataLine() throws RecognitionException {
        try {
            int _type = DataLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:9: ({...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:11: {...}? =>~ ( ' ' | '\\r' | '\\n' | '-' | '%' | '#' ) (~ ( '\\n' | '\\r' ) )* NewLine
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:86: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:118:86: ~ ( '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:12: ( ( ' ' | '\\t' | '\\u000C' )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:14: ( ' ' | '\\t' | '\\u000C' )+
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:14: ( ' ' | '\\t' | '\\u000C' )+
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:10: ({...}? => ( WhiteSpaces )? ( NewLine | EOF ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:12: {...}? => ( WhiteSpaces )? ( NewLine | EOF )
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "BlankLine", " getCharPositionInLine()==0 ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:47: ( WhiteSpaces )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\t'||LA9_0=='\f'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:47: WhiteSpaces
                    {
                    mWhiteSpaces(); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:60: ( NewLine | EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            else {
                alt10=2;}
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:61: NewLine
                    {
                    mNewLine(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:71: EOF
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:124:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:21: (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:126:23: ~ ( '\"' | '\\\\' | '\\r' | '\\n' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:131:21: ( UnicodeChar | EscapeSequence )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:131:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:131:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:15: ( '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:20: ( '0' | '1' .. '9' ( Digit )* )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:21: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:27: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:36: ( Digit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:36: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:14: ( Dot ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:16: Dot ( Digit )+
            {
            mDot(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:20: ( Digit )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:20: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:27: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:40: ( Digit )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:40: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:7: ( '\"' ( StringChar )* '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:13: ( StringChar )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:13: StringChar
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:8: ( Int )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:10: Int
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:7: ( Int ( Frac ( Exp )? | Exp ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:10: Int ( Frac ( Exp )? | Exp )
            {
            mInt(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:14: ( Frac ( Exp )? | Exp )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:15: Frac ( Exp )?
                    {
                    mFrac(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:20: ( Exp )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='E'||LA20_0=='e') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:20: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:27: Exp
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:8: ':'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:16: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:18: ( Letter | Digit | '_' | '-' | Dot )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:6: ( ( Letter | '_' ) ( NameChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:8: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:23: ( NameChar )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='-' && LA22_0<='.')||(LA22_0>='0' && LA22_0<='9')||(LA22_0>='A' && LA22_0<='Z')||LA22_0=='_'||(LA22_0>='a' && LA22_0<='z')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:23: NameChar
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

    // $ANTLR start "SequenceIndicator"
    public final void mSequenceIndicator() throws RecognitionException {
        try {
            int _type = SequenceIndicator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:18: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:20: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:7: ( '{' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:9: '{'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:7: ( '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:9: '}'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:8: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:4: ( '.' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:6: '.'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:7: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:11: '?'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:5: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:6: ( '/' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:8: '/'
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
        int alt23=26;
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


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\1\11\3\uffff\1\35\1\37\1\36\1\43\2\uffff\2\52\1\56\1\60\1\61\1"+
        "\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76"+
        "\4\uffff\1\101\2\52\2\uffff\1\104\1\105\2\uffff\1\117\3\uffff\1"+
        "\52\1\uffff\1\60\23\uffff\1\52\14\uffff\1\102\1\uffff\1\102\4\uffff"+
        "\1\102\2\uffff";
    static final String DFA23_eofS =
        "\132\uffff";
    static final String DFA23_minS =
        "\1\0\2\uffff\1\12\1\0\1\11\1\60\2\0\1\uffff\22\0\1\uffff\1\0\1"+
        "\uffff\1\0\1\11\2\56\1\0\1\12\5\0\1\uffff\3\0\1\uffff\1\0\21\uffff"+
        "\1\0\1\uffff\1\56\13\0\1\uffff\12\0";
    static final String DFA23_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\55\1\71\2\uffff\1\uffff\22\uffff\1"+
        "\uffff\1\0\1\uffff\1\0\1\40\2\145\1\0\1\12\1\0\4\uffff\1\uffff\3"+
        "\uffff\1\uffff\1\uffff\21\uffff\1\0\1\uffff\1\145\2\0\11\uffff\1"+
        "\uffff\12\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\6\uffff\1\7\22\uffff\1\5\1\uffff\1\4\13\uffff"+
        "\1\11\3\uffff\1\13\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1"+
        "\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\3\1\6\1\uffff\1\12\14\uffff"+
        "\1\10\12\uffff";
    static final String DFA23_specialS =
        "\1\71\4\uffff\1\52\1\51\1\24\1\4\1\uffff\1\2\1\30\1\65\1\55\1\70"+
        "\1\50\1\72\1\22\1\60\1\15\1\33\1\56\1\37\1\12\1\40\1\20\1\11\1\17"+
        "\1\uffff\1\41\1\uffff\1\63\1\26\2\uffff\1\64\1\23\1\1\1\25\1\21"+
        "\1\3\1\35\1\uffff\1\14\1\34\1\27\1\uffff\1\7\21\uffff\1\62\2\uffff"+
        "\1\47\1\61\1\31\1\36\1\10\1\43\1\67\1\54\1\57\1\13\1\45\1\uffff"+
        "\1\42\1\6\1\0\1\53\1\32\1\66\1\5\1\44\1\46\1\16}>";
    static final String[] DFA23_transitionS = {
            "\11\34\1\7\1\4\1\34\1\7\1\3\22\34\1\5\1\34\1\10\1\1\1\34\1"+
            "\2\2\34\1\17\1\20\1\27\1\31\1\25\1\6\1\26\1\33\1\12\11\13\1"+
            "\14\3\34\1\16\1\30\1\32\32\15\1\21\1\34\1\22\1\34\1\15\1\34"+
            "\32\15\1\23\1\34\1\24\uff82\34",
            "",
            "",
            "\1\4",
            "\1\uffff",
            "\1\40\1\11\1\uffff\1\40\1\11\22\uffff\1\5\14\uffff\1\36",
            "\1\41\11\42",
            "\11\34\1\46\1\45\1\34\1\46\1\44\22\34\1\46\uffdf\34",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "",
            "\56\34\1\53\26\34\1\54\37\34\1\54\uff9a\34",
            "\56\34\1\53\1\34\12\55\13\34\1\54\37\34\1\54\uff9a\34",
            "\0\34",
            "\55\34\2\57\1\34\12\57\7\34\32\57\4\34\1\57\1\34\32\57\uff85"+
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
            "",
            "\1\uffff",
            "\1\40\1\11\1\uffff\1\40\1\11\22\uffff\1\40",
            "\1\102\26\uffff\1\102\37\uffff\1\102",
            "\1\102\1\uffff\12\103\13\uffff\1\102\37\uffff\1\102",
            "\1\uffff",
            "\1\45",
            "\1\uffff",
            "\11\34\1\46\1\45\1\34\1\46\1\44\22\34\1\46\uffdf\34",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\42\34\1\106\14\34\1\110\54\34\1\107\5\34\1\111\3\34\1\112"+
            "\7\34\1\113\3\34\1\114\1\34\1\115\1\116\uff8a\34",
            "\0\34",
            "",
            "\60\34\12\120\uffc6\34",
            "\53\34\1\121\1\34\1\121\2\34\12\122\uffc6\34",
            "\56\34\1\53\1\34\12\55\13\34\1\54\37\34\1\54\uff9a\34",
            "",
            "\55\34\2\57\1\34\12\57\7\34\32\57\4\34\1\57\1\34\32\57\uff85"+
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
            "\1\uffff",
            "",
            "\1\102\1\uffff\12\103\13\uffff\1\102\37\uffff\1\102",
            "\1\uffff",
            "\1\uffff",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47",
            "\60\34\12\123\7\34\6\123\32\34\6\123\uff99\34",
            "",
            "\60\34\12\120\13\34\1\124\37\34\1\124\uff9a\34",
            "\60\34\12\122\uffc6\34",
            "\60\34\12\122\uffc6\34",
            "\60\34\12\125\7\34\6\125\32\34\6\125\uff99\34",
            "\53\34\1\126\1\34\1\126\2\34\12\127\uffc6\34",
            "\60\34\12\130\7\34\6\130\32\34\6\130\uff99\34",
            "\60\34\12\127\uffc6\34",
            "\60\34\12\127\uffc6\34",
            "\60\34\12\131\7\34\6\131\32\34\6\131\uff99\34",
            "\12\47\1\34\2\47\1\34\24\47\1\51\71\47\1\50\uffa3\47"
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
            return "1:1: Tokens : ( LineComment | Preamble | NewLine | NodeIndicator | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | Colon | QName | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At | Slash );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_82 = input.LA(1);

                         
                        int index23_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_82>='\u0000' && LA23_82<='/')||(LA23_82>=':' && LA23_82<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_82>='0' && LA23_82<='9')) ) {s = 82;}

                        else s = 66;

                         
                        input.seek(index23_82);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_37 = input.LA(1);

                         
                        int index23_37 = input.index();
                        input.rewind();
                        s = -1;
                        s = 68;

                         
                        input.seek(index23_37);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_10 = input.LA(1);

                         
                        int index23_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_10=='.') ) {s = 43;}

                        else if ( (LA23_10=='E'||LA23_10=='e') ) {s = 44;}

                        else if ( ((LA23_10>='\u0000' && LA23_10<='-')||(LA23_10>='/' && LA23_10<='D')||(LA23_10>='F' && LA23_10<='d')||(LA23_10>='f' && LA23_10<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 42;

                         
                        input.seek(index23_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_40 = input.LA(1);

                         
                        int index23_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_40=='\"') ) {s = 70;}

                        else if ( (LA23_40=='\\') ) {s = 71;}

                        else if ( (LA23_40=='/') ) {s = 72;}

                        else if ( (LA23_40=='b') ) {s = 73;}

                        else if ( (LA23_40=='f') ) {s = 74;}

                        else if ( (LA23_40=='n') ) {s = 75;}

                        else if ( (LA23_40=='r') ) {s = 76;}

                        else if ( (LA23_40=='t') ) {s = 77;}

                        else if ( (LA23_40=='u') ) {s = 78;}

                        else if ( ((LA23_40>='\u0000' && LA23_40<='!')||(LA23_40>='#' && LA23_40<='.')||(LA23_40>='0' && LA23_40<='[')||(LA23_40>=']' && LA23_40<='a')||(LA23_40>='c' && LA23_40<='e')||(LA23_40>='g' && LA23_40<='m')||(LA23_40>='o' && LA23_40<='q')||LA23_40=='s'||(LA23_40>='v' && LA23_40<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_40);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_8>='\u0000' && LA23_8<='\t')||(LA23_8>='\u000B' && LA23_8<='\f')||(LA23_8>='\u000E' && LA23_8<='!')||(LA23_8>='#' && LA23_8<='[')||(LA23_8>=']' && LA23_8<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_8=='\\') ) {s = 40;}

                        else if ( (LA23_8=='\"') ) {s = 41;}

                        else if ( (LA23_8=='\n'||LA23_8=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_86 = input.LA(1);

                         
                        int index23_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_86>='\u0000' && LA23_86<='/')||(LA23_86>=':' && LA23_86<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_86>='0' && LA23_86<='9')) ) {s = 87;}

                         
                        input.seek(index23_86);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_81 = input.LA(1);

                         
                        int index23_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_81>='\u0000' && LA23_81<='/')||(LA23_81>=':' && LA23_81<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_81>='0' && LA23_81<='9')) ) {s = 82;}

                         
                        input.seek(index23_81);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_47 = input.LA(1);

                         
                        int index23_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_47>='\u0000' && LA23_47<=',')||LA23_47=='/'||(LA23_47>=':' && LA23_47<='@')||(LA23_47>='[' && LA23_47<='^')||LA23_47=='`'||(LA23_47>='{' && LA23_47<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_47>='-' && LA23_47<='.')||(LA23_47>='0' && LA23_47<='9')||(LA23_47>='A' && LA23_47<='Z')||LA23_47=='_'||(LA23_47>='a' && LA23_47<='z')) ) {s = 47;}

                        else s = 48;

                         
                        input.seek(index23_47);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_72 = input.LA(1);

                         
                        int index23_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_72=='\"') ) {s = 41;}

                        else if ( ((LA23_72>='\u0000' && LA23_72<='\t')||(LA23_72>='\u000B' && LA23_72<='\f')||(LA23_72>='\u000E' && LA23_72<='!')||(LA23_72>='#' && LA23_72<='[')||(LA23_72>=']' && LA23_72<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_72=='\\') ) {s = 40;}

                        else if ( (LA23_72=='\n'||LA23_72=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_72);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_26 = input.LA(1);

                         
                        int index23_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_26>='\u0000' && LA23_26<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 61;

                         
                        input.seek(index23_26);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_23 = input.LA(1);

                         
                        int index23_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_23>='\u0000' && LA23_23<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 58;

                         
                        input.seek(index23_23);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_77 = input.LA(1);

                         
                        int index23_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_77=='\n'||LA23_77=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA23_77=='\"') ) {s = 41;}

                        else if ( ((LA23_77>='\u0000' && LA23_77<='\t')||(LA23_77>='\u000B' && LA23_77<='\f')||(LA23_77>='\u000E' && LA23_77<='!')||(LA23_77>='#' && LA23_77<='[')||(LA23_77>=']' && LA23_77<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_77=='\\') ) {s = 40;}

                         
                        input.seek(index23_77);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_43 = input.LA(1);

                         
                        int index23_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_43>='0' && LA23_43<='9')) ) {s = 80;}

                        else if ( ((LA23_43>='\u0000' && LA23_43<='/')||(LA23_43>=':' && LA23_43<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_43);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_19 = input.LA(1);

                         
                        int index23_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_19>='\u0000' && LA23_19<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 54;

                         
                        input.seek(index23_19);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_89 = input.LA(1);

                         
                        int index23_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_89=='\"') ) {s = 41;}

                        else if ( ((LA23_89>='\u0000' && LA23_89<='\t')||(LA23_89>='\u000B' && LA23_89<='\f')||(LA23_89>='\u000E' && LA23_89<='!')||(LA23_89>='#' && LA23_89<='[')||(LA23_89>=']' && LA23_89<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_89=='\\') ) {s = 40;}

                        else if ( (LA23_89=='\n'||LA23_89=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_89);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_27 = input.LA(1);

                         
                        int index23_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_27>='\u0000' && LA23_27<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 62;

                         
                        input.seek(index23_27);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_25 = input.LA(1);

                         
                        int index23_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_25>='\u0000' && LA23_25<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 60;

                         
                        input.seek(index23_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA23_39 = input.LA(1);

                         
                        int index23_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_39=='\"') ) {s = 41;}

                        else if ( ((LA23_39>='\u0000' && LA23_39<='\t')||(LA23_39>='\u000B' && LA23_39<='\f')||(LA23_39>='\u000E' && LA23_39<='!')||(LA23_39>='#' && LA23_39<='[')||(LA23_39>=']' && LA23_39<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_39=='\\') ) {s = 40;}

                        else if ( (LA23_39=='\n'||LA23_39=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_39);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA23_17 = input.LA(1);

                         
                        int index23_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_17>='\u0000' && LA23_17<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 52;

                         
                        input.seek(index23_17);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA23_36 = input.LA(1);

                         
                        int index23_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_36=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                         
                        input.seek(index23_36);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_7=='\r') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA23_7=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                        else if ( (LA23_7=='\t'||LA23_7=='\f'||LA23_7==' ') ) {s = 38;}

                        else if ( ((LA23_7>='\u0000' && LA23_7<='\b')||LA23_7=='\u000B'||(LA23_7>='\u000E' && LA23_7<='\u001F')||(LA23_7>='!' && LA23_7<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 35;

                         
                        input.seek(index23_7);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA23_38 = input.LA(1);

                         
                        int index23_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_38=='\t'||LA23_38=='\f'||LA23_38==' ') ) {s = 38;}

                        else if ( (LA23_38=='\r') && (( getCharPositionInLine()==0 ))) {s = 36;}

                        else if ( (LA23_38=='\n') && (( getCharPositionInLine()==0 ))) {s = 37;}

                        else if ( ((LA23_38>='\u0000' && LA23_38<='\b')||LA23_38=='\u000B'||(LA23_38>='\u000E' && LA23_38<='\u001F')||(LA23_38>='!' && LA23_38<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 69;

                         
                        input.seek(index23_38);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA23_32 = input.LA(1);

                         
                        int index23_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_32=='\t'||LA23_32=='\f'||LA23_32==' ') ) {s = 32;}

                        else if ( (LA23_32=='\n'||LA23_32=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else s = 65;

                         
                        input.seek(index23_32);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA23_45 = input.LA(1);

                         
                        int index23_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_45=='.') ) {s = 43;}

                        else if ( (LA23_45=='E'||LA23_45=='e') ) {s = 44;}

                        else if ( ((LA23_45>='0' && LA23_45<='9')) ) {s = 45;}

                        else if ( ((LA23_45>='\u0000' && LA23_45<='-')||LA23_45=='/'||(LA23_45>=':' && LA23_45<='D')||(LA23_45>='F' && LA23_45<='d')||(LA23_45>='f' && LA23_45<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 42;

                         
                        input.seek(index23_45);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA23_11 = input.LA(1);

                         
                        int index23_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_11>='0' && LA23_11<='9')) ) {s = 45;}

                        else if ( ((LA23_11>='\u0000' && LA23_11<='-')||LA23_11=='/'||(LA23_11>=':' && LA23_11<='D')||(LA23_11>='F' && LA23_11<='d')||(LA23_11>='f' && LA23_11<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA23_11=='.') ) {s = 43;}

                        else if ( (LA23_11=='E'||LA23_11=='e') ) {s = 44;}

                        else s = 42;

                         
                        input.seek(index23_11);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA23_70 = input.LA(1);

                         
                        int index23_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_70=='\"') ) {s = 41;}

                        else if ( ((LA23_70>='\u0000' && LA23_70<='\t')||(LA23_70>='\u000B' && LA23_70<='\f')||(LA23_70>='\u000E' && LA23_70<='!')||(LA23_70>='#' && LA23_70<='[')||(LA23_70>=']' && LA23_70<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_70=='\\') ) {s = 40;}

                        else if ( (LA23_70=='\n'||LA23_70=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_70);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA23_84 = input.LA(1);

                         
                        int index23_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_84=='+'||LA23_84=='-') ) {s = 86;}

                        else if ( ((LA23_84>='0' && LA23_84<='9')) ) {s = 87;}

                        else if ( ((LA23_84>='\u0000' && LA23_84<='*')||LA23_84==','||(LA23_84>='.' && LA23_84<='/')||(LA23_84>=':' && LA23_84<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_84);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA23_20 = input.LA(1);

                         
                        int index23_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_20>='\u0000' && LA23_20<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 55;

                         
                        input.seek(index23_20);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA23_44 = input.LA(1);

                         
                        int index23_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_44=='+'||LA23_44=='-') ) {s = 81;}

                        else if ( ((LA23_44>='0' && LA23_44<='9')) ) {s = 82;}

                        else if ( ((LA23_44>='\u0000' && LA23_44<='*')||LA23_44==','||(LA23_44>='.' && LA23_44<='/')||(LA23_44>=':' && LA23_44<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_44);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA23_41 = input.LA(1);

                         
                        int index23_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_41>='\u0000' && LA23_41<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 79;

                         
                        input.seek(index23_41);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA23_71 = input.LA(1);

                         
                        int index23_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_71=='\"') ) {s = 41;}

                        else if ( ((LA23_71>='\u0000' && LA23_71<='\t')||(LA23_71>='\u000B' && LA23_71<='\f')||(LA23_71>='\u000E' && LA23_71<='!')||(LA23_71>='#' && LA23_71<='[')||(LA23_71>=']' && LA23_71<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_71=='\\') ) {s = 40;}

                        else if ( (LA23_71=='\n'||LA23_71=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_71);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA23_22 = input.LA(1);

                         
                        int index23_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_22>='\u0000' && LA23_22<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 57;

                         
                        input.seek(index23_22);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA23_24 = input.LA(1);

                         
                        int index23_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_24>='\u0000' && LA23_24<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 59;

                         
                        input.seek(index23_24);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA23_29 = input.LA(1);

                         
                        int index23_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 63;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_29);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA23_80 = input.LA(1);

                         
                        int index23_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_80>='\u0000' && LA23_80<='/')||(LA23_80>=':' && LA23_80<='D')||(LA23_80>='F' && LA23_80<='d')||(LA23_80>='f' && LA23_80<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA23_80=='E'||LA23_80=='e') ) {s = 84;}

                        else if ( ((LA23_80>='0' && LA23_80<='9')) ) {s = 80;}

                        else s = 66;

                         
                        input.seek(index23_80);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA23_73 = input.LA(1);

                         
                        int index23_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_73=='\n'||LA23_73=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( (LA23_73=='\"') ) {s = 41;}

                        else if ( ((LA23_73>='\u0000' && LA23_73<='\t')||(LA23_73>='\u000B' && LA23_73<='\f')||(LA23_73>='\u000E' && LA23_73<='!')||(LA23_73>='#' && LA23_73<='[')||(LA23_73>=']' && LA23_73<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_73=='\\') ) {s = 40;}

                         
                        input.seek(index23_73);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA23_87 = input.LA(1);

                         
                        int index23_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_87>='\u0000' && LA23_87<='/')||(LA23_87>=':' && LA23_87<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_87>='0' && LA23_87<='9')) ) {s = 87;}

                        else s = 66;

                         
                        input.seek(index23_87);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA23_78 = input.LA(1);

                         
                        int index23_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_78>='\u0000' && LA23_78<='/')||(LA23_78>=':' && LA23_78<='@')||(LA23_78>='G' && LA23_78<='`')||(LA23_78>='g' && LA23_78<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_78>='0' && LA23_78<='9')||(LA23_78>='A' && LA23_78<='F')||(LA23_78>='a' && LA23_78<='f')) ) {s = 83;}

                         
                        input.seek(index23_78);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA23_88 = input.LA(1);

                         
                        int index23_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_88>='\u0000' && LA23_88<='/')||(LA23_88>=':' && LA23_88<='@')||(LA23_88>='G' && LA23_88<='`')||(LA23_88>='g' && LA23_88<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_88>='0' && LA23_88<='9')||(LA23_88>='A' && LA23_88<='F')||(LA23_88>='a' && LA23_88<='f')) ) {s = 89;}

                         
                        input.seek(index23_88);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA23_68 = input.LA(1);

                         
                        int index23_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine()==0 )) ) {s = 28;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_68);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA23_15 = input.LA(1);

                         
                        int index23_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_15>='\u0000' && LA23_15<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 50;

                         
                        input.seek(index23_15);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_6=='0') ) {s = 33;}

                        else if ( ((LA23_6>='1' && LA23_6<='9')) ) {s = 34;}

                        else s = 30;

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_5=='-') && ((getCharPositionInLine()==0))) {s = 30;}

                        else if ( (LA23_5==' ') ) {s = 5;}

                        else if ( (LA23_5=='\n'||LA23_5=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else if ( (LA23_5=='\t'||LA23_5=='\f') ) {s = 32;}

                        else s = 31;

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA23_83 = input.LA(1);

                         
                        int index23_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_83>='\u0000' && LA23_83<='/')||(LA23_83>=':' && LA23_83<='@')||(LA23_83>='G' && LA23_83<='`')||(LA23_83>='g' && LA23_83<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else if ( ((LA23_83>='0' && LA23_83<='9')||(LA23_83>='A' && LA23_83<='F')||(LA23_83>='a' && LA23_83<='f')) ) {s = 85;}

                         
                        input.seek(index23_83);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA23_75 = input.LA(1);

                         
                        int index23_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_75=='\"') ) {s = 41;}

                        else if ( ((LA23_75>='\u0000' && LA23_75<='\t')||(LA23_75>='\u000B' && LA23_75<='\f')||(LA23_75>='\u000E' && LA23_75<='!')||(LA23_75>='#' && LA23_75<='[')||(LA23_75>=']' && LA23_75<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_75=='\\') ) {s = 40;}

                        else if ( (LA23_75=='\n'||LA23_75=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_75);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA23_13 = input.LA(1);

                         
                        int index23_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_13>='-' && LA23_13<='.')||(LA23_13>='0' && LA23_13<='9')||(LA23_13>='A' && LA23_13<='Z')||LA23_13=='_'||(LA23_13>='a' && LA23_13<='z')) ) {s = 47;}

                        else if ( ((LA23_13>='\u0000' && LA23_13<=',')||LA23_13=='/'||(LA23_13>=':' && LA23_13<='@')||(LA23_13>='[' && LA23_13<='^')||LA23_13=='`'||(LA23_13>='{' && LA23_13<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 48;

                         
                        input.seek(index23_13);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA23_21 = input.LA(1);

                         
                        int index23_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_21>='\u0000' && LA23_21<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 56;

                         
                        input.seek(index23_21);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA23_76 = input.LA(1);

                         
                        int index23_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_76=='\"') ) {s = 41;}

                        else if ( ((LA23_76>='\u0000' && LA23_76<='\t')||(LA23_76>='\u000B' && LA23_76<='\f')||(LA23_76>='\u000E' && LA23_76<='!')||(LA23_76>='#' && LA23_76<='[')||(LA23_76>=']' && LA23_76<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_76=='\\') ) {s = 40;}

                        else if ( (LA23_76=='\n'||LA23_76=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_76);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA23_18 = input.LA(1);

                         
                        int index23_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_18>='\u0000' && LA23_18<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 53;

                         
                        input.seek(index23_18);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA23_69 = input.LA(1);

                         
                        int index23_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 64;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_69);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA23_65 = input.LA(1);

                         
                        int index23_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 64;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_65);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA23_31 = input.LA(1);

                         
                        int index23_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 64;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_31);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA23_35 = input.LA(1);

                         
                        int index23_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 64;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index23_35);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA23_12 = input.LA(1);

                         
                        int index23_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_12>='\u0000' && LA23_12<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 46;

                         
                        input.seek(index23_12);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA23_85 = input.LA(1);

                         
                        int index23_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_85>='0' && LA23_85<='9')||(LA23_85>='A' && LA23_85<='F')||(LA23_85>='a' && LA23_85<='f')) ) {s = 88;}

                        else if ( ((LA23_85>='\u0000' && LA23_85<='/')||(LA23_85>=':' && LA23_85<='@')||(LA23_85>='G' && LA23_85<='`')||(LA23_85>='g' && LA23_85<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_85);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA23_74 = input.LA(1);

                         
                        int index23_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_74=='\"') ) {s = 41;}

                        else if ( ((LA23_74>='\u0000' && LA23_74<='\t')||(LA23_74>='\u000B' && LA23_74<='\f')||(LA23_74>='\u000E' && LA23_74<='!')||(LA23_74>='#' && LA23_74<='[')||(LA23_74>=']' && LA23_74<='\uFFFF')) ) {s = 39;}

                        else if ( (LA23_74=='\\') ) {s = 40;}

                        else if ( (LA23_74=='\n'||LA23_74=='\r') && (( getCharPositionInLine()==0 ))) {s = 28;}

                         
                        input.seek(index23_74);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_14>='\u0000' && LA23_14<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 49;

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0=='#') ) {s = 1;}

                        else if ( (LA23_0=='%') ) {s = 2;}

                        else if ( (LA23_0=='\r') ) {s = 3;}

                        else if ( (LA23_0=='\n') ) {s = 4;}

                        else if ( (LA23_0==' ') ) {s = 5;}

                        else if ( (LA23_0=='-') ) {s = 6;}

                        else if ( (LA23_0=='\t'||LA23_0=='\f') ) {s = 7;}

                        else if ( (LA23_0=='\"') ) {s = 8;}

                        else if ( (LA23_0=='0') ) {s = 10;}

                        else if ( ((LA23_0>='1' && LA23_0<='9')) ) {s = 11;}

                        else if ( (LA23_0==':') ) {s = 12;}

                        else if ( ((LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {s = 13;}

                        else if ( (LA23_0=='>') ) {s = 14;}

                        else if ( (LA23_0=='(') ) {s = 15;}

                        else if ( (LA23_0==')') ) {s = 16;}

                        else if ( (LA23_0=='[') ) {s = 17;}

                        else if ( (LA23_0==']') ) {s = 18;}

                        else if ( (LA23_0=='{') ) {s = 19;}

                        else if ( (LA23_0=='}') ) {s = 20;}

                        else if ( (LA23_0==',') ) {s = 21;}

                        else if ( (LA23_0=='.') ) {s = 22;}

                        else if ( (LA23_0=='*') ) {s = 23;}

                        else if ( (LA23_0=='?') ) {s = 24;}

                        else if ( (LA23_0=='+') ) {s = 25;}

                        else if ( (LA23_0=='@') ) {s = 26;}

                        else if ( (LA23_0=='/') ) {s = 27;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||LA23_0=='\u000B'||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||(LA23_0>='&' && LA23_0<='\'')||(LA23_0>=';' && LA23_0<='=')||LA23_0=='\\'||LA23_0=='^'||LA23_0=='`'||LA23_0=='|'||(LA23_0>='~' && LA23_0<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 9;

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA23_16>='\u0000' && LA23_16<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 28;}

                        else s = 51;

                         
                        input.seek(index23_16);
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
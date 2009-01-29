// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-29 09:04:33

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
    public static final int Key=14;
    public static final int DataType=10;
    public static final int RBrace=44;
    public static final int SilkNode=5;
    public static final int LBracket=41;
    public static final int NodeStart=18;
    public static final int Digit=23;
    public static final int Frac=30;
    public static final int HexDigit=24;
    public static final int Plus=48;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Letter=35;
    public static final int Comma=45;
    public static final int SpecialSymbol=19;
    public static final int NodeValue=53;
    public static final int Dot=29;
    public static final int EscapeSequence=26;
    public static final int Slash=50;
    public static final int DataLine=20;
    public static final int Integer=33;
    public static final int Question=47;
    public static final int Colon=52;
    public static final int LineComment=15;
    public static final int SequenceIndicator=38;
    public static final int At=49;
    public static final int NameChar=36;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=13;
    public static final int Star=46;
    public static final int Preamble=16;
    public static final int Exp=31;
    public static final int Int=28;
    public static final int RParen=40;
    public static final int UnicodeChar=25;
    public static final int Silk=4;
    public static final int BlankLine=22;
    public static final int StringChar=27;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=39;
    public static final int String=32;
    public static final int InLineStringChar=51;
    public static final int QName=37;
    public static final int EOF=-1;
    public static final int Value=8;
    public static final int LBrace=43;
    public static final int Double=34;
    public static final int RBracket=42;
    public static final int NewLine=17;
    public static final int WhiteSpaces=21;

      private boolean hasColon = false;
      private boolean testHasColon() { 
         boolean tmp = hasColon;
         hasColon = false;
         return tmp;
      }
      


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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:12: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:14: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:18: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:32: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:120:32: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:15: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:15: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:29: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:121:29: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:8: ( ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:10: ( '\\r' )? '\\n'
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:10: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:122:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             _channel=HIDDEN; hasColon = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NewLine"

    // $ANTLR start "NodeStart"
    public final void mNodeStart() throws RecognitionException {
        try {
            int _type = NodeStart;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:10: ({...}? => ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:12: {...}? => ( ' ' )* '-'
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "NodeStart", "getCharPositionInLine()==0");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:45: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:125:46: ' '
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
    // $ANTLR end "NodeStart"

    // $ANTLR start "SpecialSymbol"
    public final void mSpecialSymbol() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:127:23: ( '-' | '%' | '#' | ' ' | '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:9: ({...}? => ( ' ' )* ~ SpecialSymbol (~ ( '\\n' | '\\r' ) )* NewLine )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:11: {...}? => ( ' ' )* ~ SpecialSymbol (~ ( '\\n' | '\\r' ) )* NewLine
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "DataLine", " getCharPositionInLine()==0 ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:47: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:48: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0012')||(input.LA(1)>='\u0014' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:69: (~ ( '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:128:69: ~ ( '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:12: ( ( ' ' | '\\t' | '\\u000C' )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:14: ( ' ' | '\\t' | '\\u000C' )+
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:130:14: ( ' ' | '\\t' | '\\u000C' )+
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:10: ({...}? => ( WhiteSpaces )? ( NewLine | EOF ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:12: {...}? => ( WhiteSpaces )? ( NewLine | EOF )
            {
            if ( !(( getCharPositionInLine()==0 )) ) {
                throw new FailedPredicateException(input, "BlankLine", " getCharPositionInLine()==0 ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:47: ( WhiteSpaces )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\t'||LA10_0=='\f'||LA10_0==' ') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:47: WhiteSpaces
                    {
                    mWhiteSpaces(); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:60: ( NewLine | EOF )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            else {
                alt11=2;}
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:61: NewLine
                    {
                    mNewLine(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:132:71: EOF
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:135:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:21: (~ ( '\"' | '\\\\' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:136:23: ~ ( '\"' | '\\\\' | '\\r' | '\\n' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:138:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:141:21: ( UnicodeChar | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:141:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:141:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:15: ( '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='-') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:20: ( '0' | '1' .. '9' ( Digit )* )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:21: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:27: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:36: ( Digit )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:143:36: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:14: ( Dot ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:16: Dot ( Digit )+
            {
            mDot(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:20: ( Digit )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:20: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:27: ( '+' | '-' )?
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:40: ( Digit )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:40: Digit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:7: ( '\"' ( StringChar )* '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:13: ( StringChar )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='!')||(LA20_0>='#' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:13: StringChar
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
              hasColon=false;   


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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:8: ( Int )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:10: Int
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:7: ( Int ( Frac ( Exp )? | Exp ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:10: Int ( Frac ( Exp )? | Exp )
            {
            mInt(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:14: ( Frac ( Exp )? | Exp )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:15: Frac ( Exp )?
                    {
                    mFrac(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:20: ( Exp )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='E'||LA21_0=='e') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:20: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:27: Exp
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:16: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:18: ( Letter | Digit | '_' | '-' | Dot )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:6: ( ( Letter | '_' ) ( NameChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:8: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:23: ( NameChar )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='-' && LA23_0<='.')||(LA23_0>='0' && LA23_0<='9')||(LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:23: NameChar
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:18: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:20: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:7: ( '{' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:9: '{'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:7: ( '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:9: '}'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:8: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:4: ( '.' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:6: '.'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:7: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:11: '?'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:5: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:6: ( '/' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:8: '/'
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

    // $ANTLR start "InLineStringChar"
    public final void mInLineStringChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:17: ( ( '\\n' | '\\r' | '#' | Comma | LParen | RParen | LBracket | RBracket | LBrace | RBrace | '\"' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:19: ( '\\n' | '\\r' | '#' | Comma | LParen | RParen | LBracket | RBracket | LBrace | RBrace | '\"' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||(input.LA(1)>='\"' && input.LA(1)<='#')||(input.LA(1)>='(' && input.LA(1)<=')')||input.LA(1)==','||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
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
    // $ANTLR end "InLineStringChar"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:8: ':'
            {
            match(':'); 
             hasColon = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "NodeValue"
    public final void mNodeValue() throws RecognitionException {
        try {
            int _type = NodeValue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:10: ({...}? => ( String | ~ ( ' ' | '\\t' | InLineStringChar ) ( options {greedy=false; } : (~ InLineStringChar )+ ) ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:2: {...}? => ( String | ~ ( ' ' | '\\t' | InLineStringChar ) ( options {greedy=false; } : (~ InLineStringChar )+ ) )
            {
            if ( !(( hasColon )) ) {
                throw new FailedPredicateException(input, "NodeValue", " hasColon ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:2: ( String | ~ ( ' ' | '\\t' | InLineStringChar ) ( options {greedy=false; } : (~ InLineStringChar )+ ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\"') ) {
                alt25=1;
            }
            else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='!'||(LA25_0>='$' && LA25_0<='\'')||(LA25_0>='*' && LA25_0<='+')||(LA25_0>='-' && LA25_0<='Z')||LA25_0=='\\'||(LA25_0>='^' && LA25_0<='z')||LA25_0=='|'||(LA25_0>='~' && LA25_0<='\uFFFF')) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:3: String
                    {
                    mString(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:12: ~ ( ' ' | '\\t' | InLineStringChar ) ( options {greedy=false; } : (~ InLineStringChar )+ )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:43: ( options {greedy=false; } : (~ InLineStringChar )+ )
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:70: (~ InLineStringChar )+
                    {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:70: (~ InLineStringChar )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>='\u0000' && LA24_0<='\t')||(LA24_0>='\u000B' && LA24_0<='\f')||(LA24_0>='\u000E' && LA24_0<='!')||(LA24_0>='$' && LA24_0<='\'')||(LA24_0>='*' && LA24_0<='+')||(LA24_0>='-' && LA24_0<='Z')||LA24_0=='\\'||(LA24_0>='^' && LA24_0<='z')||LA24_0=='|'||(LA24_0>='~' && LA24_0<='\uFFFF')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:70: ~ InLineStringChar
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='2')||(input.LA(1)>='4' && input.LA(1)<='\uFFFF') ) {
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


                    }


                    }
                    break;

            }

             hasColon = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NodeValue"

    public void mTokens() throws RecognitionException {
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | NewLine | NodeStart | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At | Slash | Colon | NodeValue )
        int alt26=27;
        alt26 = dfa26.predict(input);
        switch (alt26) {
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:39: NodeStart
                {
                mNodeStart(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:49: DataLine
                {
                mDataLine(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:58: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:70: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:80: String
                {
                mString(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:87: Integer
                {
                mInteger(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:95: Double
                {
                mDouble(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:102: QName
                {
                mQName(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:108: SequenceIndicator
                {
                mSequenceIndicator(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:126: LParen
                {
                mLParen(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:133: RParen
                {
                mRParen(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:140: LBracket
                {
                mLBracket(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:149: RBracket
                {
                mRBracket(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:158: LBrace
                {
                mLBrace(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:165: RBrace
                {
                mRBrace(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:172: Comma
                {
                mComma(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:178: Dot
                {
                mDot(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:182: Star
                {
                mStar(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:187: Question
                {
                mQuestion(); 

                }
                break;
            case 23 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:196: Plus
                {
                mPlus(); 

                }
                break;
            case 24 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:201: At
                {
                mAt(); 

                }
                break;
            case 25 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:204: Slash
                {
                mSlash(); 

                }
                break;
            case 26 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:210: Colon
                {
                mColon(); 

                }
                break;
            case 27 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:216: NodeValue
                {
                mNodeValue(); 

                }
                break;

        }

    }


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\1\11\3\uffff\1\40\1\41\1\43\1\47\2\uffff\2\60\1\64\1\65\1\66\1"+
        "\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
        "\103\1\uffff\1\104\1\46\5\uffff\1\110\1\113\2\uffff\1\115\1\uffff"+
        "\1\116\1\46\2\uffff\1\130\1\46\1\uffff\1\46\1\134\1\135\21\uffff"+
        "\1\136\3\uffff\2\46\1\uffff\1\142\14\uffff\1\145\1\46\1\147\3\uffff"+
        "\1\150\1\46\1\152\4\uffff\1\46\2\uffff\1\46\3\uffff\1\46\1\162\1"+
        "\46\1\163\4\uffff";
    static final String DFA26_eofS =
        "\165\uffff";
    static final String DFA26_minS =
        "\1\0\1\uffff\1\0\1\12\5\0\1\uffff\25\0\1\uffff\2\0\2\uffff\2\0"+
        "\1\uffff\2\0\1\12\6\0\1\uffff\3\0\20\uffff\2\0\2\uffff\1\0\1\60"+
        "\1\53\25\0\1\60\3\0\1\uffff\4\0\1\53\2\0\1\uffff\2\0\1\60\5\0";
    static final String DFA26_maxS =
        "\1\uffff\1\uffff\1\uffff\1\12\1\0\4\uffff\1\uffff\25\uffff\1\uffff"+
        "\2\0\2\uffff\2\uffff\1\uffff\1\0\1\uffff\1\12\1\0\5\uffff\1\uffff"+
        "\3\uffff\20\uffff\1\0\1\uffff\2\uffff\1\0\2\71\1\0\1\uffff\2\0\11"+
        "\uffff\1\0\3\uffff\3\0\1\uffff\1\71\1\uffff\1\0\1\uffff\1\uffff"+
        "\1\0\1\uffff\2\0\1\71\1\0\1\uffff\1\uffff\2\uffff\1\71\2\uffff\2"+
        "\0\1\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\7\uffff\1\7\25\uffff\1\2\2\uffff\1\5\1\4\2\uffff\1"+
        "\33\11\uffff\1\11\3\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\2\uffff\1\3\1\6\34\uffff"+
        "\1\10\7\uffff\1\12\10\uffff";
    static final String DFA26_specialS =
        "\1\33\1\uffff\1\71\2\uffff\1\60\1\40\1\120\1\54\1\uffff\1\57\1"+
        "\17\1\73\1\25\1\112\1\35\1\22\1\23\1\101\1\106\1\42\1\55\1\123\1"+
        "\105\1\41\1\51\1\110\1\65\1\70\1\11\1\52\1\uffff\1\31\1\46\2\uffff"+
        "\1\117\1\15\1\uffff\1\45\1\61\1\72\1\21\1\103\1\64\1\127\1\53\1"+
        "\111\1\uffff\1\16\1\124\1\102\20\uffff\1\47\1\122\2\uffff\1\26\1"+
        "\116\1\37\1\27\1\20\1\62\1\13\1\74\1\0\1\115\1\104\1\107\1\121\1"+
        "\66\1\32\1\126\1\43\1\2\1\114\1\67\1\30\1\12\1\50\1\1\1\100\1\63"+
        "\1\24\1\75\1\uffff\1\10\1\14\1\7\1\6\1\36\1\5\1\44\1\uffff\1\113"+
        "\1\34\1\77\1\76\1\125\1\4\1\3\1\56}>";
    static final String[] DFA26_transitionS = {
            "\11\34\1\35\1\4\1\34\1\7\1\3\22\34\1\5\1\34\1\10\1\1\1\34\1"+
            "\2\2\34\1\16\1\17\1\26\1\30\1\24\1\6\1\25\1\32\1\12\11\13\1"+
            "\33\3\34\1\15\1\27\1\31\32\14\1\20\1\34\1\21\1\34\1\14\1\34"+
            "\32\14\1\22\1\34\1\23\uff82\34",
            "",
            "\12\36\1\37\2\36\1\37\24\36\2\37\4\36\2\37\2\36\1\37\56\36"+
            "\1\37\1\36\1\37\35\36\1\37\1\36\1\37\uff82\36",
            "\1\4",
            "\1\uffff",
            "\11\42\1\35\1\11\1\42\1\35\1\11\22\42\1\5\2\42\1\uffff\1\42"+
            "\1\uffff\7\42\1\43\uffd2\42",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\3\46\1\44\11\45\41\46\1\uffff\1\46\1\uffff\35\46\1"+
            "\uffff\1\46\1\uffff\uff82\46",
            "\11\53\1\50\1\52\1\53\1\50\1\51\22\53\1\50\1\53\2\42\4\53"+
            "\2\42\2\53\1\42\56\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82"+
            "\53",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\1\53"+
            "\1\57\26\53\1\61\25\53\1\42\1\53\1\42\7\53\1\61\25\53\1\42\1"+
            "\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\1\53"+
            "\1\57\1\53\12\62\13\53\1\61\25\53\1\42\1\53\1\42\7\53\1\61\25"+
            "\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\2\63"+
            "\1\53\12\63\7\53\32\63\1\42\1\53\1\42\1\53\1\63\1\53\32\63\1"+
            "\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\0\42",
            "\0\42",
            "\0\42",
            "\0\42",
            "\0\42",
            "\0\42",
            "\0\42",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\11\42\1\105\1\52\1\42\1\105\1\51\22\42\1\105\uffdf\42",
            "\12\36\1\37\2\36\1\37\24\36\2\37\4\36\2\37\2\36\1\37\56\36"+
            "\1\37\1\36\1\37\35\36\1\37\1\36\1\37\uff82\36",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\1\46\1\111\26\46\1\112\25\46\1\uffff\1\46\1\uffff\7"+
            "\46\1\112\25\46\1\uffff\1\46\1\uffff\uff82\46",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\1\46\1\111\1\46\12\114\13\46\1\112\25\46\1\uffff\1"+
            "\46\1\uffff\7\46\1\112\25\46\1\uffff\1\46\1\uffff\uff82\46",
            "",
            "\1\uffff",
            "\11\53\1\50\1\52\1\53\1\50\1\51\22\53\1\50\1\53\2\42\4\53"+
            "\2\42\2\53\1\42\56\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82"+
            "\53",
            "\1\52",
            "\1\uffff",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\56\53"+
            "\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\42\42\1\117\14\42\1\121\54\42\1\120\5\42\1\122\3\42\1\123"+
            "\7\42\1\124\3\42\1\125\1\42\1\126\1\127\uff8a\42",
            "\0\42",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\131\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\1\53\1\132\1\42"+
            "\1\132\2\53\12\133\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42"+
            "\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\1\53"+
            "\1\57\1\53\12\62\13\53\1\61\25\53\1\42\1\53\1\42\7\53\1\61\25"+
            "\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\2\63"+
            "\1\53\12\63\7\53\32\63\1\42\1\53\1\42\1\53\1\63\1\53\32\63\1"+
            "\42\1\53\1\42\uff82\53",
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
            "\11\42\1\105\1\52\1\42\1\105\1\51\22\42\1\105\uffdf\42",
            "",
            "",
            "\1\uffff",
            "\12\137",
            "\1\140\1\uffff\1\140\2\uffff\12\141",
            "\1\uffff",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\1\46\1\111\1\46\12\114\13\46\1\112\25\46\1\uffff\1"+
            "\46\1\uffff\7\46\1\112\25\46\1\uffff\1\46\1\uffff\uff82\46",
            "\1\uffff",
            "\1\uffff",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54",
            "\60\42\12\143\7\42\6\143\32\42\6\143\uff99\42",
            "\1\uffff",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\131\13\53\1\146\25\53\1\42\1\53\1\42\7\53\1\146\25\53\1"+
            "\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\133\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\133\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\3\46\12\137\13\46\1\151\25\46\1\uffff\1\46\1\uffff"+
            "\7\46\1\151\25\46\1\uffff\1\46\1\uffff\uff82\46",
            "\12\141",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\3\46\12\141\41\46\1\uffff\1\46\1\uffff\35\46\1\uffff"+
            "\1\46\1\uffff\uff82\46",
            "\1\uffff",
            "\60\42\12\153\7\42\6\153\32\42\6\153\uff99\42",
            "",
            "\1\uffff",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\1\53\1\155\1\42"+
            "\1\155\2\53\12\156\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42"+
            "\uff82\53",
            "\1\uffff",
            "\1\uffff",
            "\1\157\1\uffff\1\157\2\uffff\12\160",
            "\1\uffff",
            "\60\42\12\161\7\42\6\161\32\42\6\161\uff99\42",
            "",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\156\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\53\1\42\2\53\1\42\24\53\2\42\4\53\2\42\2\53\1\42\3\53"+
            "\12\156\41\53\1\42\1\53\1\42\35\53\1\42\1\53\1\42\uff82\53",
            "\12\160",
            "\12\46\1\uffff\2\46\1\uffff\24\46\2\uffff\4\46\2\uffff\2\46"+
            "\1\uffff\3\46\12\160\41\46\1\uffff\1\46\1\uffff\35\46\1\uffff"+
            "\1\46\1\uffff\uff82\46",
            "\60\42\12\164\7\42\6\164\32\42\6\164\uff99\42",
            "\1\uffff",
            "\1\uffff",
            "\12\54\1\42\2\54\1\42\24\54\1\56\71\54\1\55\uffa3\54"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | NewLine | NodeStart | DataLine | WhiteSpaces | BlankLine | String | Integer | Double | QName | SequenceIndicator | LParen | RParen | LBracket | RBracket | LBrace | RBrace | Comma | Dot | Star | Question | Plus | At | Slash | Colon | NodeValue );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_80 = input.LA(1);

                         
                        int index26_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_80=='\"') ) {s = 46;}

                        else if ( ((LA26_80>='\u0000' && LA26_80<='\t')||(LA26_80>='\u000B' && LA26_80<='\f')||(LA26_80>='\u000E' && LA26_80<='!')||(LA26_80>='#' && LA26_80<='[')||(LA26_80>=']' && LA26_80<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_80=='\\') ) {s = 45;}

                        else if ( (LA26_80=='\n'||LA26_80=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_80);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_95 = input.LA(1);

                         
                        int index26_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_95=='E'||LA26_95=='e') ) {s = 105;}

                        else if ( ((LA26_95>='0' && LA26_95<='9')) ) {s = 95;}

                        else if ( ((LA26_95>='\u0000' && LA26_95<='\t')||(LA26_95>='\u000B' && LA26_95<='\f')||(LA26_95>='\u000E' && LA26_95<='!')||(LA26_95>='$' && LA26_95<='\'')||(LA26_95>='*' && LA26_95<='+')||(LA26_95>='-' && LA26_95<='/')||(LA26_95>=':' && LA26_95<='D')||(LA26_95>='F' && LA26_95<='Z')||LA26_95=='\\'||(LA26_95>='^' && LA26_95<='d')||(LA26_95>='f' && LA26_95<='z')||LA26_95=='|'||(LA26_95>='~' && LA26_95<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 104;

                         
                        input.seek(index26_95);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_89 = input.LA(1);

                         
                        int index26_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_89=='E'||LA26_89=='e') ) {s = 102;}

                        else if ( (LA26_89=='\n'||LA26_89=='\r'||(LA26_89>='\"' && LA26_89<='#')||(LA26_89>='(' && LA26_89<=')')||LA26_89==','||LA26_89=='['||LA26_89==']'||LA26_89=='{'||LA26_89=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_89>='0' && LA26_89<='9')) ) {s = 89;}

                        else if ( ((LA26_89>='\u0000' && LA26_89<='\t')||(LA26_89>='\u000B' && LA26_89<='\f')||(LA26_89>='\u000E' && LA26_89<='!')||(LA26_89>='$' && LA26_89<='\'')||(LA26_89>='*' && LA26_89<='+')||(LA26_89>='-' && LA26_89<='/')||(LA26_89>=':' && LA26_89<='D')||(LA26_89>='F' && LA26_89<='Z')||LA26_89=='\\'||(LA26_89>='^' && LA26_89<='d')||(LA26_89>='f' && LA26_89<='z')||LA26_89=='|'||(LA26_89>='~' && LA26_89<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 101;

                         
                        input.seek(index26_89);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_115 = input.LA(1);

                         
                        int index26_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_115);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_114 = input.LA(1);

                         
                        int index26_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_114);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_106 = input.LA(1);

                         
                        int index26_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_106);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA26_104 = input.LA(1);

                         
                        int index26_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_104);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA26_103 = input.LA(1);

                         
                        int index26_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_103);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA26_101 = input.LA(1);

                         
                        int index26_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 108;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_101);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA26_29 = input.LA(1);

                         
                        int index26_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_29=='\t'||LA26_29=='\f'||LA26_29==' ') ) {s = 69;}

                        else if ( (LA26_29=='\r') && (( getCharPositionInLine()==0 ))) {s = 41;}

                        else if ( (LA26_29=='\n') && (( getCharPositionInLine()==0 ))) {s = 42;}

                        else if ( ((LA26_29>='\u0000' && LA26_29<='\b')||LA26_29=='\u000B'||(LA26_29>='\u000E' && LA26_29<='\u001F')||(LA26_29>='!' && LA26_29<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 68;

                         
                        input.seek(index26_29);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA26_93 = input.LA(1);

                         
                        int index26_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 52;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_93);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA26_78 = input.LA(1);

                         
                        int index26_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine()==0 )) ) {s = 34;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_78);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA26_102 = input.LA(1);

                         
                        int index26_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_102=='+'||LA26_102=='-') ) {s = 109;}

                        else if ( (LA26_102=='\n'||LA26_102=='\r'||(LA26_102>='\"' && LA26_102<='#')||(LA26_102>='(' && LA26_102<=')')||LA26_102==','||LA26_102=='['||LA26_102==']'||LA26_102=='{'||LA26_102=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_102>='0' && LA26_102<='9')) ) {s = 110;}

                        else if ( ((LA26_102>='\u0000' && LA26_102<='\t')||(LA26_102>='\u000B' && LA26_102<='\f')||(LA26_102>='\u000E' && LA26_102<='!')||(LA26_102>='$' && LA26_102<='\'')||LA26_102=='*'||(LA26_102>='.' && LA26_102<='/')||(LA26_102>=':' && LA26_102<='Z')||LA26_102=='\\'||(LA26_102>='^' && LA26_102<='z')||LA26_102=='|'||(LA26_102>='~' && LA26_102<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 38;

                         
                        input.seek(index26_102);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA26_37 = input.LA(1);

                         
                        int index26_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_37>='0' && LA26_37<='9')) ) {s = 76;}

                        else if ( (LA26_37=='.') ) {s = 73;}

                        else if ( (LA26_37=='E'||LA26_37=='e') ) {s = 74;}

                        else if ( ((LA26_37>='\u0000' && LA26_37<='\t')||(LA26_37>='\u000B' && LA26_37<='\f')||(LA26_37>='\u000E' && LA26_37<='!')||(LA26_37>='$' && LA26_37<='\'')||(LA26_37>='*' && LA26_37<='+')||LA26_37=='-'||LA26_37=='/'||(LA26_37>=':' && LA26_37<='D')||(LA26_37>='F' && LA26_37<='Z')||LA26_37=='\\'||(LA26_37>='^' && LA26_37<='d')||(LA26_37>='f' && LA26_37<='z')||LA26_37=='|'||(LA26_37>='~' && LA26_37<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 75;

                         
                        input.seek(index26_37);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA26_49 = input.LA(1);

                         
                        int index26_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_49=='+'||LA26_49=='-') ) {s = 90;}

                        else if ( ((LA26_49>='0' && LA26_49<='9')) ) {s = 91;}

                        else if ( ((LA26_49>='\u0000' && LA26_49<='\t')||(LA26_49>='\u000B' && LA26_49<='\f')||(LA26_49>='\u000E' && LA26_49<='!')||(LA26_49>='$' && LA26_49<='\'')||LA26_49=='*'||(LA26_49>='.' && LA26_49<='/')||(LA26_49>=':' && LA26_49<='Z')||LA26_49=='\\'||(LA26_49>='^' && LA26_49<='z')||LA26_49=='|'||(LA26_49>='~' && LA26_49<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_49=='\n'||LA26_49=='\r'||(LA26_49>='\"' && LA26_49<='#')||(LA26_49>='(' && LA26_49<=')')||LA26_49==','||LA26_49=='['||LA26_49==']'||LA26_49=='{'||LA26_49=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 38;

                         
                        input.seek(index26_49);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA26_11 = input.LA(1);

                         
                        int index26_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_11>='0' && LA26_11<='9')) ) {s = 50;}

                        else if ( (LA26_11=='.') ) {s = 47;}

                        else if ( (LA26_11=='E'||LA26_11=='e') ) {s = 49;}

                        else if ( ((LA26_11>='\u0000' && LA26_11<='\t')||(LA26_11>='\u000B' && LA26_11<='\f')||(LA26_11>='\u000E' && LA26_11<='!')||(LA26_11>='$' && LA26_11<='\'')||(LA26_11>='*' && LA26_11<='+')||LA26_11=='-'||LA26_11=='/'||(LA26_11>=':' && LA26_11<='D')||(LA26_11>='F' && LA26_11<='Z')||LA26_11=='\\'||(LA26_11>='^' && LA26_11<='d')||(LA26_11>='f' && LA26_11<='z')||LA26_11=='|'||(LA26_11>='~' && LA26_11<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_11=='\n'||LA26_11=='\r'||(LA26_11>='\"' && LA26_11<='#')||(LA26_11>='(' && LA26_11<=')')||LA26_11==','||LA26_11=='['||LA26_11==']'||LA26_11=='{'||LA26_11=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 48;

                         
                        input.seek(index26_11);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA26_76 = input.LA(1);

                         
                        int index26_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_76>='0' && LA26_76<='9')) ) {s = 76;}

                        else if ( (LA26_76=='.') ) {s = 73;}

                        else if ( (LA26_76=='E'||LA26_76=='e') ) {s = 74;}

                        else if ( ((LA26_76>='\u0000' && LA26_76<='\t')||(LA26_76>='\u000B' && LA26_76<='\f')||(LA26_76>='\u000E' && LA26_76<='!')||(LA26_76>='$' && LA26_76<='\'')||(LA26_76>='*' && LA26_76<='+')||LA26_76=='-'||LA26_76=='/'||(LA26_76>=':' && LA26_76<='D')||(LA26_76>='F' && LA26_76<='Z')||LA26_76=='\\'||(LA26_76>='^' && LA26_76<='d')||(LA26_76>='f' && LA26_76<='z')||LA26_76=='|'||(LA26_76>='~' && LA26_76<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 98;

                         
                        input.seek(index26_76);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA26_42 = input.LA(1);

                         
                        int index26_42 = input.index();
                        input.rewind();
                        s = -1;
                        s = 78;

                         
                        input.seek(index26_42);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA26_16 = input.LA(1);

                         
                        int index26_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_16>='\u0000' && LA26_16<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 56;

                         
                        input.seek(index26_16);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA26_17 = input.LA(1);

                         
                        int index26_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_17>='\u0000' && LA26_17<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 57;

                         
                        input.seek(index26_17);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA26_98 = input.LA(1);

                         
                        int index26_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 48;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_98);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA26_13 = input.LA(1);

                         
                        int index26_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_13>='\u0000' && LA26_13<='\t')||(LA26_13>='\u000B' && LA26_13<='\f')||(LA26_13>='\u000E' && LA26_13<='!')||(LA26_13>='$' && LA26_13<='\'')||(LA26_13>='*' && LA26_13<='+')||(LA26_13>='-' && LA26_13<='Z')||LA26_13=='\\'||(LA26_13>='^' && LA26_13<='z')||LA26_13=='|'||(LA26_13>='~' && LA26_13<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_13=='\n'||LA26_13=='\r'||(LA26_13>='\"' && LA26_13<='#')||(LA26_13>='(' && LA26_13<=')')||LA26_13==','||LA26_13=='['||LA26_13==']'||LA26_13=='{'||LA26_13=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 53;

                         
                        input.seek(index26_13);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA26_72 = input.LA(1);

                         
                        int index26_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 48;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_72);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA26_75 = input.LA(1);

                         
                        int index26_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 48;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_75);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA26_92 = input.LA(1);

                         
                        int index26_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 48;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_92);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA26_32 = input.LA(1);

                         
                        int index26_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 70;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_32);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA26_86 = input.LA(1);

                         
                        int index26_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_86=='\n'||LA26_86=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_86=='\"') ) {s = 46;}

                        else if ( ((LA26_86>='\u0000' && LA26_86<='\t')||(LA26_86>='\u000B' && LA26_86<='\f')||(LA26_86>='\u000E' && LA26_86<='!')||(LA26_86>='#' && LA26_86<='[')||(LA26_86>=']' && LA26_86<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_86=='\\') ) {s = 45;}

                         
                        input.seek(index26_86);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_0=='#') ) {s = 1;}

                        else if ( (LA26_0=='%') ) {s = 2;}

                        else if ( (LA26_0=='\r') ) {s = 3;}

                        else if ( (LA26_0=='\n') ) {s = 4;}

                        else if ( (LA26_0==' ') ) {s = 5;}

                        else if ( (LA26_0=='-') ) {s = 6;}

                        else if ( (LA26_0=='\f') ) {s = 7;}

                        else if ( (LA26_0=='\"') ) {s = 8;}

                        else if ( (LA26_0=='0') ) {s = 10;}

                        else if ( ((LA26_0>='1' && LA26_0<='9')) ) {s = 11;}

                        else if ( ((LA26_0>='A' && LA26_0<='Z')||LA26_0=='_'||(LA26_0>='a' && LA26_0<='z')) ) {s = 12;}

                        else if ( (LA26_0=='>') ) {s = 13;}

                        else if ( (LA26_0=='(') ) {s = 14;}

                        else if ( (LA26_0==')') ) {s = 15;}

                        else if ( (LA26_0=='[') ) {s = 16;}

                        else if ( (LA26_0==']') ) {s = 17;}

                        else if ( (LA26_0=='{') ) {s = 18;}

                        else if ( (LA26_0=='}') ) {s = 19;}

                        else if ( (LA26_0==',') ) {s = 20;}

                        else if ( (LA26_0=='.') ) {s = 21;}

                        else if ( (LA26_0=='*') ) {s = 22;}

                        else if ( (LA26_0=='?') ) {s = 23;}

                        else if ( (LA26_0=='+') ) {s = 24;}

                        else if ( (LA26_0=='@') ) {s = 25;}

                        else if ( (LA26_0=='/') ) {s = 26;}

                        else if ( (LA26_0==':') ) {s = 27;}

                        else if ( ((LA26_0>='\u0000' && LA26_0<='\b')||LA26_0=='\u000B'||(LA26_0>='\u000E' && LA26_0<='\u001F')||LA26_0=='!'||LA26_0=='$'||(LA26_0>='&' && LA26_0<='\'')||(LA26_0>=';' && LA26_0<='=')||LA26_0=='\\'||LA26_0=='^'||LA26_0=='`'||LA26_0=='|'||(LA26_0>='~' && LA26_0<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 28;}

                        else if ( (LA26_0=='\t') ) {s = 29;}

                        else s = 9;

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA26_110 = input.LA(1);

                         
                        int index26_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_110>='0' && LA26_110<='9')) ) {s = 110;}

                        else if ( (LA26_110=='\n'||LA26_110=='\r'||(LA26_110>='\"' && LA26_110<='#')||(LA26_110>='(' && LA26_110<=')')||LA26_110==','||LA26_110=='['||LA26_110==']'||LA26_110=='{'||LA26_110=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_110>='\u0000' && LA26_110<='\t')||(LA26_110>='\u000B' && LA26_110<='\f')||(LA26_110>='\u000E' && LA26_110<='!')||(LA26_110>='$' && LA26_110<='\'')||(LA26_110>='*' && LA26_110<='+')||(LA26_110>='-' && LA26_110<='/')||(LA26_110>=':' && LA26_110<='Z')||LA26_110=='\\'||(LA26_110>='^' && LA26_110<='z')||LA26_110=='|'||(LA26_110>='~' && LA26_110<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 114;

                         
                        input.seek(index26_110);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA26_15 = input.LA(1);

                         
                        int index26_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_15>='\u0000' && LA26_15<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 55;

                         
                        input.seek(index26_15);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA26_105 = input.LA(1);

                         
                        int index26_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_105=='+'||LA26_105=='-') ) {s = 111;}

                        else if ( ((LA26_105>='0' && LA26_105<='9')) ) {s = 112;}

                        else s = 38;

                         
                        input.seek(index26_105);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA26_74 = input.LA(1);

                         
                        int index26_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_74=='+'||LA26_74=='-') ) {s = 96;}

                        else if ( ((LA26_74>='0' && LA26_74<='9')) ) {s = 97;}

                        else s = 38;

                         
                        input.seek(index26_74);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA26_6 = input.LA(1);

                         
                        int index26_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_6=='0') ) {s = 36;}

                        else if ( ((LA26_6>='1' && LA26_6<='9')) ) {s = 37;}

                        else if ( ((LA26_6>='\u0000' && LA26_6<='\t')||(LA26_6>='\u000B' && LA26_6<='\f')||(LA26_6>='\u000E' && LA26_6<='!')||(LA26_6>='$' && LA26_6<='\'')||(LA26_6>='*' && LA26_6<='+')||(LA26_6>='-' && LA26_6<='/')||(LA26_6>=':' && LA26_6<='Z')||LA26_6=='\\'||(LA26_6>='^' && LA26_6<='z')||LA26_6=='|'||(LA26_6>='~' && LA26_6<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 35;

                         
                        input.seek(index26_6);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA26_24 = input.LA(1);

                         
                        int index26_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_24>='\u0000' && LA26_24<='\t')||(LA26_24>='\u000B' && LA26_24<='\f')||(LA26_24>='\u000E' && LA26_24<='!')||(LA26_24>='$' && LA26_24<='\'')||(LA26_24>='*' && LA26_24<='+')||(LA26_24>='-' && LA26_24<='Z')||LA26_24=='\\'||(LA26_24>='^' && LA26_24<='z')||LA26_24=='|'||(LA26_24>='~' && LA26_24<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_24=='\n'||LA26_24=='\r'||(LA26_24>='\"' && LA26_24<='#')||(LA26_24>='(' && LA26_24<=')')||LA26_24==','||LA26_24=='['||LA26_24==']'||LA26_24=='{'||LA26_24=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 64;

                         
                        input.seek(index26_24);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA26_20 = input.LA(1);

                         
                        int index26_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_20>='\u0000' && LA26_20<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 60;

                         
                        input.seek(index26_20);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA26_88 = input.LA(1);

                         
                        int index26_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( hasColon )))) ) {s = 100;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_88);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA26_107 = input.LA(1);

                         
                        int index26_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_107>='0' && LA26_107<='9')||(LA26_107>='A' && LA26_107<='F')||(LA26_107>='a' && LA26_107<='f')) ) {s = 113;}

                        else if ( ((LA26_107>='\u0000' && LA26_107<='/')||(LA26_107>=':' && LA26_107<='@')||(LA26_107>='G' && LA26_107<='`')||(LA26_107>='g' && LA26_107<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_107);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA26_39 = input.LA(1);

                         
                        int index26_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 71;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_39);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA26_33 = input.LA(1);

                         
                        int index26_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 71;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_33);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA26_68 = input.LA(1);

                         
                        int index26_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 71;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_68);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA26_94 = input.LA(1);

                         
                        int index26_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine()==0 )))) ) {s = 71;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                         
                        input.seek(index26_94);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA26_25 = input.LA(1);

                         
                        int index26_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_25>='\u0000' && LA26_25<='\t')||(LA26_25>='\u000B' && LA26_25<='\f')||(LA26_25>='\u000E' && LA26_25<='!')||(LA26_25>='$' && LA26_25<='\'')||(LA26_25>='*' && LA26_25<='+')||(LA26_25>='-' && LA26_25<='Z')||LA26_25=='\\'||(LA26_25>='^' && LA26_25<='z')||LA26_25=='|'||(LA26_25>='~' && LA26_25<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_25=='\n'||LA26_25=='\r'||(LA26_25>='\"' && LA26_25<='#')||(LA26_25>='(' && LA26_25<=')')||LA26_25==','||LA26_25=='['||LA26_25==']'||LA26_25=='{'||LA26_25=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 65;

                         
                        input.seek(index26_25);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA26_30 = input.LA(1);

                         
                        int index26_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_30>='\u0000' && LA26_30<='\t')||(LA26_30>='\u000B' && LA26_30<='\f')||(LA26_30>='\u000E' && LA26_30<='!')||(LA26_30>='$' && LA26_30<='\'')||(LA26_30>='*' && LA26_30<='+')||(LA26_30>='-' && LA26_30<='Z')||LA26_30=='\\'||(LA26_30>='^' && LA26_30<='z')||LA26_30=='|'||(LA26_30>='~' && LA26_30<='\uFFFF')) ) {s = 30;}

                        else if ( (LA26_30=='\n'||LA26_30=='\r'||(LA26_30>='\"' && LA26_30<='#')||(LA26_30>='(' && LA26_30<=')')||LA26_30==','||LA26_30=='['||LA26_30==']'||LA26_30=='{'||LA26_30=='}') ) {s = 31;}

                        else s = 38;

                         
                        input.seek(index26_30);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA26_46 = input.LA(1);

                         
                        int index26_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_46>='\u0000' && LA26_46<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 88;

                         
                        input.seek(index26_46);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA26_8 = input.LA(1);

                         
                        int index26_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_8>='\u0000' && LA26_8<='\t')||(LA26_8>='\u000B' && LA26_8<='\f')||(LA26_8>='\u000E' && LA26_8<='!')||(LA26_8>='#' && LA26_8<='[')||(LA26_8>=']' && LA26_8<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_8=='\\') ) {s = 45;}

                        else if ( (LA26_8=='\"') ) {s = 46;}

                        else if ( (LA26_8=='\n'||LA26_8=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_8);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA26_21 = input.LA(1);

                         
                        int index26_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_21>='\u0000' && LA26_21<='\t')||(LA26_21>='\u000B' && LA26_21<='\f')||(LA26_21>='\u000E' && LA26_21<='!')||(LA26_21>='$' && LA26_21<='\'')||(LA26_21>='*' && LA26_21<='+')||(LA26_21>='-' && LA26_21<='Z')||LA26_21=='\\'||(LA26_21>='^' && LA26_21<='z')||LA26_21=='|'||(LA26_21>='~' && LA26_21<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_21=='\n'||LA26_21=='\r'||(LA26_21>='\"' && LA26_21<='#')||(LA26_21>='(' && LA26_21<=')')||LA26_21==','||LA26_21=='['||LA26_21==']'||LA26_21=='{'||LA26_21=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 61;

                         
                        input.seek(index26_21);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA26_116 = input.LA(1);

                         
                        int index26_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_116=='\"') ) {s = 46;}

                        else if ( ((LA26_116>='\u0000' && LA26_116<='\t')||(LA26_116>='\u000B' && LA26_116<='\f')||(LA26_116>='\u000E' && LA26_116<='!')||(LA26_116>='#' && LA26_116<='[')||(LA26_116>=']' && LA26_116<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_116=='\\') ) {s = 45;}

                        else if ( (LA26_116=='\n'||LA26_116=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_116);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA26_10 = input.LA(1);

                         
                        int index26_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_10=='.') ) {s = 47;}

                        else if ( (LA26_10=='E'||LA26_10=='e') ) {s = 49;}

                        else if ( ((LA26_10>='\u0000' && LA26_10<='\t')||(LA26_10>='\u000B' && LA26_10<='\f')||(LA26_10>='\u000E' && LA26_10<='!')||(LA26_10>='$' && LA26_10<='\'')||(LA26_10>='*' && LA26_10<='+')||LA26_10=='-'||(LA26_10>='/' && LA26_10<='D')||(LA26_10>='F' && LA26_10<='Z')||LA26_10=='\\'||(LA26_10>='^' && LA26_10<='d')||(LA26_10>='f' && LA26_10<='z')||LA26_10=='|'||(LA26_10>='~' && LA26_10<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_10=='\n'||LA26_10=='\r'||(LA26_10>='\"' && LA26_10<='#')||(LA26_10>='(' && LA26_10<=')')||LA26_10==','||LA26_10=='['||LA26_10==']'||LA26_10=='{'||LA26_10=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 48;

                         
                        input.seek(index26_10);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA26_5 = input.LA(1);

                         
                        int index26_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_5=='\t'||LA26_5=='\f') ) {s = 29;}

                        else if ( (LA26_5=='\n'||LA26_5=='\r') && (( getCharPositionInLine()==0 ))) {s = 9;}

                        else if ( (LA26_5==' ') ) {s = 5;}

                        else if ( ((LA26_5>='\u0000' && LA26_5<='\b')||LA26_5=='\u000B'||(LA26_5>='\u000E' && LA26_5<='\u001F')||(LA26_5>='!' && LA26_5<='\"')||LA26_5=='$'||(LA26_5>='&' && LA26_5<=',')||(LA26_5>='.' && LA26_5<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_5=='-') && ((getCharPositionInLine()==0))) {s = 35;}

                        else s = 33;

                         
                        input.seek(index26_5);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA26_40 = input.LA(1);

                         
                        int index26_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_40=='\t'||LA26_40=='\f'||LA26_40==' ') ) {s = 40;}

                        else if ( ((LA26_40>='\u0000' && LA26_40<='\b')||LA26_40=='\u000B'||(LA26_40>='\u000E' && LA26_40<='\u001F')||LA26_40=='!'||(LA26_40>='$' && LA26_40<='\'')||(LA26_40>='*' && LA26_40<='+')||(LA26_40>='-' && LA26_40<='Z')||LA26_40=='\\'||(LA26_40>='^' && LA26_40<='z')||LA26_40=='|'||(LA26_40>='~' && LA26_40<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_40=='\r') && (( getCharPositionInLine()==0 ))) {s = 41;}

                        else if ( (LA26_40=='\n') && (( getCharPositionInLine()==0 ))) {s = 42;}

                        else if ( ((LA26_40>='\"' && LA26_40<='#')||(LA26_40>='(' && LA26_40<=')')||LA26_40==','||LA26_40=='['||LA26_40==']'||LA26_40=='{'||LA26_40=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 77;

                         
                        input.seek(index26_40);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA26_77 = input.LA(1);

                         
                        int index26_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( getCharPositionInLine()==0 )||( hasColon ))))) ) {s = 71;}

                        else if ( (( getCharPositionInLine()==0 )) ) {s = 9;}

                        else if ( (( hasColon )) ) {s = 38;}

                         
                        input.seek(index26_77);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA26_97 = input.LA(1);

                         
                        int index26_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_97>='0' && LA26_97<='9')) ) {s = 97;}

                        else if ( ((LA26_97>='\u0000' && LA26_97<='\t')||(LA26_97>='\u000B' && LA26_97<='\f')||(LA26_97>='\u000E' && LA26_97<='!')||(LA26_97>='$' && LA26_97<='\'')||(LA26_97>='*' && LA26_97<='+')||(LA26_97>='-' && LA26_97<='/')||(LA26_97>=':' && LA26_97<='Z')||LA26_97=='\\'||(LA26_97>='^' && LA26_97<='z')||LA26_97=='|'||(LA26_97>='~' && LA26_97<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 106;

                         
                        input.seek(index26_97);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA26_44 = input.LA(1);

                         
                        int index26_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_44=='\n'||LA26_44=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_44=='\"') ) {s = 46;}

                        else if ( ((LA26_44>='\u0000' && LA26_44<='\t')||(LA26_44>='\u000B' && LA26_44<='\f')||(LA26_44>='\u000E' && LA26_44<='!')||(LA26_44>='#' && LA26_44<='[')||(LA26_44>=']' && LA26_44<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_44=='\\') ) {s = 45;}

                         
                        input.seek(index26_44);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA26_27 = input.LA(1);

                         
                        int index26_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_27>='\u0000' && LA26_27<='\t')||(LA26_27>='\u000B' && LA26_27<='\f')||(LA26_27>='\u000E' && LA26_27<='!')||(LA26_27>='$' && LA26_27<='\'')||(LA26_27>='*' && LA26_27<='+')||(LA26_27>='-' && LA26_27<='Z')||LA26_27=='\\'||(LA26_27>='^' && LA26_27<='z')||LA26_27=='|'||(LA26_27>='~' && LA26_27<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_27=='\n'||LA26_27=='\r'||(LA26_27>='\"' && LA26_27<='#')||(LA26_27>='(' && LA26_27<=')')||LA26_27==','||LA26_27=='['||LA26_27==']'||LA26_27=='{'||LA26_27=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 67;

                         
                        input.seek(index26_27);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA26_85 = input.LA(1);

                         
                        int index26_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_85=='\"') ) {s = 46;}

                        else if ( ((LA26_85>='\u0000' && LA26_85<='\t')||(LA26_85>='\u000B' && LA26_85<='\f')||(LA26_85>='\u000E' && LA26_85<='!')||(LA26_85>='#' && LA26_85<='[')||(LA26_85>=']' && LA26_85<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_85=='\\') ) {s = 45;}

                        else if ( (LA26_85=='\n'||LA26_85=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_85);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA26_91 = input.LA(1);

                         
                        int index26_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_91>='0' && LA26_91<='9')) ) {s = 91;}

                        else if ( (LA26_91=='\n'||LA26_91=='\r'||(LA26_91>='\"' && LA26_91<='#')||(LA26_91>='(' && LA26_91<=')')||LA26_91==','||LA26_91=='['||LA26_91==']'||LA26_91=='{'||LA26_91=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_91>='\u0000' && LA26_91<='\t')||(LA26_91>='\u000B' && LA26_91<='\f')||(LA26_91>='\u000E' && LA26_91<='!')||(LA26_91>='$' && LA26_91<='\'')||(LA26_91>='*' && LA26_91<='+')||(LA26_91>='-' && LA26_91<='/')||(LA26_91>=':' && LA26_91<='Z')||LA26_91=='\\'||(LA26_91>='^' && LA26_91<='z')||LA26_91=='|'||(LA26_91>='~' && LA26_91<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 103;

                         
                        input.seek(index26_91);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA26_28 = input.LA(1);

                         
                        int index26_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_28>='\u0000' && LA26_28<='\t')||(LA26_28>='\u000B' && LA26_28<='\f')||(LA26_28>='\u000E' && LA26_28<='!')||(LA26_28>='$' && LA26_28<='\'')||(LA26_28>='*' && LA26_28<='+')||(LA26_28>='-' && LA26_28<='Z')||LA26_28=='\\'||(LA26_28>='^' && LA26_28<='z')||LA26_28=='|'||(LA26_28>='~' && LA26_28<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_28=='\n'||LA26_28=='\r'||(LA26_28>='\"' && LA26_28<='#')||(LA26_28>='(' && LA26_28<=')')||LA26_28==','||LA26_28=='['||LA26_28==']'||LA26_28=='{'||LA26_28=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_28);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA26_2 = input.LA(1);

                        s = -1;
                        if ( ((LA26_2>='\u0000' && LA26_2<='\t')||(LA26_2>='\u000B' && LA26_2<='\f')||(LA26_2>='\u000E' && LA26_2<='!')||(LA26_2>='$' && LA26_2<='\'')||(LA26_2>='*' && LA26_2<='+')||(LA26_2>='-' && LA26_2<='Z')||LA26_2=='\\'||(LA26_2>='^' && LA26_2<='z')||LA26_2=='|'||(LA26_2>='~' && LA26_2<='\uFFFF')) ) {s = 30;}

                        else if ( (LA26_2=='\n'||LA26_2=='\r'||(LA26_2>='\"' && LA26_2<='#')||(LA26_2>='(' && LA26_2<=')')||LA26_2==','||LA26_2=='['||LA26_2==']'||LA26_2=='{'||LA26_2=='}') ) {s = 31;}

                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA26_41 = input.LA(1);

                         
                        int index26_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_41=='\n') && (( getCharPositionInLine()==0 ))) {s = 42;}

                         
                        input.seek(index26_41);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA26_12 = input.LA(1);

                         
                        int index26_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_12>='-' && LA26_12<='.')||(LA26_12>='0' && LA26_12<='9')||(LA26_12>='A' && LA26_12<='Z')||LA26_12=='_'||(LA26_12>='a' && LA26_12<='z')) ) {s = 51;}

                        else if ( ((LA26_12>='\u0000' && LA26_12<='\t')||(LA26_12>='\u000B' && LA26_12<='\f')||(LA26_12>='\u000E' && LA26_12<='!')||(LA26_12>='$' && LA26_12<='\'')||(LA26_12>='*' && LA26_12<='+')||LA26_12=='/'||(LA26_12>=':' && LA26_12<='@')||LA26_12=='\\'||LA26_12=='^'||LA26_12=='`'||LA26_12=='|'||(LA26_12>='~' && LA26_12<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_12=='\n'||LA26_12=='\r'||(LA26_12>='\"' && LA26_12<='#')||(LA26_12>='(' && LA26_12<=')')||LA26_12==','||LA26_12=='['||LA26_12==']'||LA26_12=='{'||LA26_12=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 52;

                         
                        input.seek(index26_12);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA26_79 = input.LA(1);

                         
                        int index26_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_79=='\"') ) {s = 46;}

                        else if ( ((LA26_79>='\u0000' && LA26_79<='\t')||(LA26_79>='\u000B' && LA26_79<='\f')||(LA26_79>='\u000E' && LA26_79<='!')||(LA26_79>='#' && LA26_79<='[')||(LA26_79>=']' && LA26_79<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_79=='\\') ) {s = 45;}

                        else if ( (LA26_79=='\n'||LA26_79=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_79);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA26_99 = input.LA(1);

                         
                        int index26_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_99>='\u0000' && LA26_99<='/')||(LA26_99>=':' && LA26_99<='@')||(LA26_99>='G' && LA26_99<='`')||(LA26_99>='g' && LA26_99<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_99>='0' && LA26_99<='9')||(LA26_99>='A' && LA26_99<='F')||(LA26_99>='a' && LA26_99<='f')) ) {s = 107;}

                         
                        input.seek(index26_99);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA26_112 = input.LA(1);

                         
                        int index26_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_112>='0' && LA26_112<='9')) ) {s = 112;}

                        else if ( ((LA26_112>='\u0000' && LA26_112<='\t')||(LA26_112>='\u000B' && LA26_112<='\f')||(LA26_112>='\u000E' && LA26_112<='!')||(LA26_112>='$' && LA26_112<='\'')||(LA26_112>='*' && LA26_112<='+')||(LA26_112>='-' && LA26_112<='/')||(LA26_112>=':' && LA26_112<='Z')||LA26_112=='\\'||(LA26_112>='^' && LA26_112<='z')||LA26_112=='|'||(LA26_112>='~' && LA26_112<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 115;

                         
                        input.seek(index26_112);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA26_111 = input.LA(1);

                         
                        int index26_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_111>='0' && LA26_111<='9')) ) {s = 112;}

                        else s = 38;

                         
                        input.seek(index26_111);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA26_96 = input.LA(1);

                         
                        int index26_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_96>='0' && LA26_96<='9')) ) {s = 97;}

                        else s = 38;

                         
                        input.seek(index26_96);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA26_18 = input.LA(1);

                         
                        int index26_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_18>='\u0000' && LA26_18<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 58;

                         
                        input.seek(index26_18);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA26_51 = input.LA(1);

                         
                        int index26_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_51>='-' && LA26_51<='.')||(LA26_51>='0' && LA26_51<='9')||(LA26_51>='A' && LA26_51<='Z')||LA26_51=='_'||(LA26_51>='a' && LA26_51<='z')) ) {s = 51;}

                        else if ( (LA26_51=='\n'||LA26_51=='\r'||(LA26_51>='\"' && LA26_51<='#')||(LA26_51>='(' && LA26_51<=')')||LA26_51==','||LA26_51=='['||LA26_51==']'||LA26_51=='{'||LA26_51=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_51>='\u0000' && LA26_51<='\t')||(LA26_51>='\u000B' && LA26_51<='\f')||(LA26_51>='\u000E' && LA26_51<='!')||(LA26_51>='$' && LA26_51<='\'')||(LA26_51>='*' && LA26_51<='+')||LA26_51=='/'||(LA26_51>=':' && LA26_51<='@')||LA26_51=='\\'||LA26_51=='^'||LA26_51=='`'||LA26_51=='|'||(LA26_51>='~' && LA26_51<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 93;

                         
                        input.seek(index26_51);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA26_43 = input.LA(1);

                         
                        int index26_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_43>='\u0000' && LA26_43<='\t')||(LA26_43>='\u000B' && LA26_43<='\f')||(LA26_43>='\u000E' && LA26_43<='!')||(LA26_43>='$' && LA26_43<='\'')||(LA26_43>='*' && LA26_43<='+')||(LA26_43>='-' && LA26_43<='Z')||LA26_43=='\\'||(LA26_43>='^' && LA26_43<='z')||LA26_43=='|'||(LA26_43>='~' && LA26_43<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_43=='\n'||LA26_43=='\r'||(LA26_43>='\"' && LA26_43<='#')||(LA26_43>='(' && LA26_43<=')')||LA26_43==','||LA26_43=='['||LA26_43==']'||LA26_43=='{'||LA26_43=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 38;

                         
                        input.seek(index26_43);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA26_82 = input.LA(1);

                         
                        int index26_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_82=='\"') ) {s = 46;}

                        else if ( ((LA26_82>='\u0000' && LA26_82<='\t')||(LA26_82>='\u000B' && LA26_82<='\f')||(LA26_82>='\u000E' && LA26_82<='!')||(LA26_82>='#' && LA26_82<='[')||(LA26_82>=']' && LA26_82<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_82=='\\') ) {s = 45;}

                        else if ( (LA26_82=='\n'||LA26_82=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_82);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA26_23 = input.LA(1);

                         
                        int index26_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_23>='\u0000' && LA26_23<='\t')||(LA26_23>='\u000B' && LA26_23<='\f')||(LA26_23>='\u000E' && LA26_23<='!')||(LA26_23>='$' && LA26_23<='\'')||(LA26_23>='*' && LA26_23<='+')||(LA26_23>='-' && LA26_23<='Z')||LA26_23=='\\'||(LA26_23>='^' && LA26_23<='z')||LA26_23=='|'||(LA26_23>='~' && LA26_23<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_23=='\n'||LA26_23=='\r'||(LA26_23>='\"' && LA26_23<='#')||(LA26_23>='(' && LA26_23<=')')||LA26_23==','||LA26_23=='['||LA26_23==']'||LA26_23=='{'||LA26_23=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 63;

                         
                        input.seek(index26_23);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA26_19 = input.LA(1);

                         
                        int index26_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_19>='\u0000' && LA26_19<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 59;

                         
                        input.seek(index26_19);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA26_83 = input.LA(1);

                         
                        int index26_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_83=='\n'||LA26_83=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_83=='\"') ) {s = 46;}

                        else if ( ((LA26_83>='\u0000' && LA26_83<='\t')||(LA26_83>='\u000B' && LA26_83<='\f')||(LA26_83>='\u000E' && LA26_83<='!')||(LA26_83>='#' && LA26_83<='[')||(LA26_83>=']' && LA26_83<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_83=='\\') ) {s = 45;}

                         
                        input.seek(index26_83);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA26_26 = input.LA(1);

                         
                        int index26_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_26>='\u0000' && LA26_26<='\t')||(LA26_26>='\u000B' && LA26_26<='\f')||(LA26_26>='\u000E' && LA26_26<='!')||(LA26_26>='$' && LA26_26<='\'')||(LA26_26>='*' && LA26_26<='+')||(LA26_26>='-' && LA26_26<='Z')||LA26_26=='\\'||(LA26_26>='^' && LA26_26<='z')||LA26_26=='|'||(LA26_26>='~' && LA26_26<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_26=='\n'||LA26_26=='\r'||(LA26_26>='\"' && LA26_26<='#')||(LA26_26>='(' && LA26_26<=')')||LA26_26==','||LA26_26=='['||LA26_26==']'||LA26_26=='{'||LA26_26=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 66;

                         
                        input.seek(index26_26);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA26_47 = input.LA(1);

                         
                        int index26_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_47>='0' && LA26_47<='9')) ) {s = 89;}

                        else if ( ((LA26_47>='\u0000' && LA26_47<='\t')||(LA26_47>='\u000B' && LA26_47<='\f')||(LA26_47>='\u000E' && LA26_47<='!')||(LA26_47>='$' && LA26_47<='\'')||(LA26_47>='*' && LA26_47<='+')||(LA26_47>='-' && LA26_47<='/')||(LA26_47>=':' && LA26_47<='Z')||LA26_47=='\\'||(LA26_47>='^' && LA26_47<='z')||LA26_47=='|'||(LA26_47>='~' && LA26_47<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_47=='\n'||LA26_47=='\r'||(LA26_47>='\"' && LA26_47<='#')||(LA26_47>='(' && LA26_47<=')')||LA26_47==','||LA26_47=='['||LA26_47==']'||LA26_47=='{'||LA26_47=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 38;

                         
                        input.seek(index26_47);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA26_14 = input.LA(1);

                         
                        int index26_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_14>='\u0000' && LA26_14<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 54;

                         
                        input.seek(index26_14);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA26_109 = input.LA(1);

                         
                        int index26_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_109>='0' && LA26_109<='9')) ) {s = 110;}

                        else if ( (LA26_109=='\n'||LA26_109=='\r'||(LA26_109>='\"' && LA26_109<='#')||(LA26_109>='(' && LA26_109<=')')||LA26_109==','||LA26_109=='['||LA26_109==']'||LA26_109=='{'||LA26_109=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( ((LA26_109>='\u0000' && LA26_109<='\t')||(LA26_109>='\u000B' && LA26_109<='\f')||(LA26_109>='\u000E' && LA26_109<='!')||(LA26_109>='$' && LA26_109<='\'')||(LA26_109>='*' && LA26_109<='+')||(LA26_109>='-' && LA26_109<='/')||(LA26_109>=':' && LA26_109<='Z')||LA26_109=='\\'||(LA26_109>='^' && LA26_109<='z')||LA26_109=='|'||(LA26_109>='~' && LA26_109<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 38;

                         
                        input.seek(index26_109);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA26_90 = input.LA(1);

                         
                        int index26_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_90>='0' && LA26_90<='9')) ) {s = 91;}

                        else if ( ((LA26_90>='\u0000' && LA26_90<='\t')||(LA26_90>='\u000B' && LA26_90<='\f')||(LA26_90>='\u000E' && LA26_90<='!')||(LA26_90>='$' && LA26_90<='\'')||(LA26_90>='*' && LA26_90<='+')||(LA26_90>='-' && LA26_90<='/')||(LA26_90>=':' && LA26_90<='Z')||LA26_90=='\\'||(LA26_90>='^' && LA26_90<='z')||LA26_90=='|'||(LA26_90>='~' && LA26_90<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_90=='\n'||LA26_90=='\r'||(LA26_90>='\"' && LA26_90<='#')||(LA26_90>='(' && LA26_90<=')')||LA26_90==','||LA26_90=='['||LA26_90==']'||LA26_90=='{'||LA26_90=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 38;

                         
                        input.seek(index26_90);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA26_81 = input.LA(1);

                         
                        int index26_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_81=='\"') ) {s = 46;}

                        else if ( ((LA26_81>='\u0000' && LA26_81<='\t')||(LA26_81>='\u000B' && LA26_81<='\f')||(LA26_81>='\u000E' && LA26_81<='!')||(LA26_81>='#' && LA26_81<='[')||(LA26_81>=']' && LA26_81<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_81=='\\') ) {s = 45;}

                        else if ( (LA26_81=='\n'||LA26_81=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_81);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA26_73 = input.LA(1);

                         
                        int index26_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_73>='0' && LA26_73<='9')) ) {s = 95;}

                        else s = 38;

                         
                        input.seek(index26_73);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA26_36 = input.LA(1);

                         
                        int index26_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_36=='.') ) {s = 73;}

                        else if ( (LA26_36=='E'||LA26_36=='e') ) {s = 74;}

                        else if ( ((LA26_36>='\u0000' && LA26_36<='\t')||(LA26_36>='\u000B' && LA26_36<='\f')||(LA26_36>='\u000E' && LA26_36<='!')||(LA26_36>='$' && LA26_36<='\'')||(LA26_36>='*' && LA26_36<='+')||LA26_36=='-'||(LA26_36>='/' && LA26_36<='D')||(LA26_36>='F' && LA26_36<='Z')||LA26_36=='\\'||(LA26_36>='^' && LA26_36<='d')||(LA26_36>='f' && LA26_36<='z')||LA26_36=='|'||(LA26_36>='~' && LA26_36<='\uFFFF')) && (( hasColon ))) {s = 38;}

                        else s = 72;

                         
                        input.seek(index26_36);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA26_7 = input.LA(1);

                         
                        int index26_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_7=='\t'||LA26_7=='\f'||LA26_7==' ') ) {s = 40;}

                        else if ( (LA26_7=='\r') && (( getCharPositionInLine()==0 ))) {s = 41;}

                        else if ( (LA26_7=='\n') && (( getCharPositionInLine()==0 ))) {s = 42;}

                        else if ( ((LA26_7>='\u0000' && LA26_7<='\b')||LA26_7=='\u000B'||(LA26_7>='\u000E' && LA26_7<='\u001F')||LA26_7=='!'||(LA26_7>='$' && LA26_7<='\'')||(LA26_7>='*' && LA26_7<='+')||(LA26_7>='-' && LA26_7<='Z')||LA26_7=='\\'||(LA26_7>='^' && LA26_7<='z')||LA26_7=='|'||(LA26_7>='~' && LA26_7<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( ((LA26_7>='\"' && LA26_7<='#')||(LA26_7>='(' && LA26_7<=')')||LA26_7==','||LA26_7=='['||LA26_7==']'||LA26_7=='{'||LA26_7=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 39;

                         
                        input.seek(index26_7);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA26_84 = input.LA(1);

                         
                        int index26_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_84=='\n'||LA26_84=='\r') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_84=='\"') ) {s = 46;}

                        else if ( ((LA26_84>='\u0000' && LA26_84<='\t')||(LA26_84>='\u000B' && LA26_84<='\f')||(LA26_84>='\u000E' && LA26_84<='!')||(LA26_84>='#' && LA26_84<='[')||(LA26_84>=']' && LA26_84<='\uFFFF')) ) {s = 44;}

                        else if ( (LA26_84=='\\') ) {s = 45;}

                         
                        input.seek(index26_84);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA26_69 = input.LA(1);

                         
                        int index26_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_69=='\t'||LA26_69=='\f'||LA26_69==' ') ) {s = 69;}

                        else if ( (LA26_69=='\r') && (( getCharPositionInLine()==0 ))) {s = 41;}

                        else if ( (LA26_69=='\n') && (( getCharPositionInLine()==0 ))) {s = 42;}

                        else if ( ((LA26_69>='\u0000' && LA26_69<='\b')||LA26_69=='\u000B'||(LA26_69>='\u000E' && LA26_69<='\u001F')||(LA26_69>='!' && LA26_69<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 94;

                         
                        input.seek(index26_69);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA26_22 = input.LA(1);

                         
                        int index26_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_22>='\u0000' && LA26_22<='\t')||(LA26_22>='\u000B' && LA26_22<='\f')||(LA26_22>='\u000E' && LA26_22<='!')||(LA26_22>='$' && LA26_22<='\'')||(LA26_22>='*' && LA26_22<='+')||(LA26_22>='-' && LA26_22<='Z')||LA26_22=='\\'||(LA26_22>='^' && LA26_22<='z')||LA26_22=='|'||(LA26_22>='~' && LA26_22<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else if ( (LA26_22=='\n'||LA26_22=='\r'||(LA26_22>='\"' && LA26_22<='#')||(LA26_22>='(' && LA26_22<=')')||LA26_22==','||LA26_22=='['||LA26_22==']'||LA26_22=='{'||LA26_22=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else s = 62;

                         
                        input.seek(index26_22);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA26_50 = input.LA(1);

                         
                        int index26_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_50>='0' && LA26_50<='9')) ) {s = 50;}

                        else if ( (LA26_50=='.') ) {s = 47;}

                        else if ( (LA26_50=='\n'||LA26_50=='\r'||(LA26_50>='\"' && LA26_50<='#')||(LA26_50>='(' && LA26_50<=')')||LA26_50==','||LA26_50=='['||LA26_50==']'||LA26_50=='{'||LA26_50=='}') && (( getCharPositionInLine()==0 ))) {s = 34;}

                        else if ( (LA26_50=='E'||LA26_50=='e') ) {s = 49;}

                        else if ( ((LA26_50>='\u0000' && LA26_50<='\t')||(LA26_50>='\u000B' && LA26_50<='\f')||(LA26_50>='\u000E' && LA26_50<='!')||(LA26_50>='$' && LA26_50<='\'')||(LA26_50>='*' && LA26_50<='+')||LA26_50=='-'||LA26_50=='/'||(LA26_50>=':' && LA26_50<='D')||(LA26_50>='F' && LA26_50<='Z')||LA26_50=='\\'||(LA26_50>='^' && LA26_50<='d')||(LA26_50>='f' && LA26_50<='z')||LA26_50=='|'||(LA26_50>='~' && LA26_50<='\uFFFF')) && ((( getCharPositionInLine()==0 )||( hasColon )))) {s = 43;}

                        else s = 92;

                         
                        input.seek(index26_50);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA26_113 = input.LA(1);

                         
                        int index26_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_113>='0' && LA26_113<='9')||(LA26_113>='A' && LA26_113<='F')||(LA26_113>='a' && LA26_113<='f')) ) {s = 116;}

                        else if ( ((LA26_113>='\u0000' && LA26_113<='/')||(LA26_113>=':' && LA26_113<='@')||(LA26_113>='G' && LA26_113<='`')||(LA26_113>='g' && LA26_113<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_113);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA26_87 = input.LA(1);

                         
                        int index26_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA26_87>='0' && LA26_87<='9')||(LA26_87>='A' && LA26_87<='F')||(LA26_87>='a' && LA26_87<='f')) ) {s = 99;}

                        else if ( ((LA26_87>='\u0000' && LA26_87<='/')||(LA26_87>=':' && LA26_87<='@')||(LA26_87>='G' && LA26_87<='`')||(LA26_87>='g' && LA26_87<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_87);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA26_45 = input.LA(1);

                         
                        int index26_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_45=='\"') ) {s = 79;}

                        else if ( (LA26_45=='\\') ) {s = 80;}

                        else if ( (LA26_45=='/') ) {s = 81;}

                        else if ( (LA26_45=='b') ) {s = 82;}

                        else if ( (LA26_45=='f') ) {s = 83;}

                        else if ( (LA26_45=='n') ) {s = 84;}

                        else if ( (LA26_45=='r') ) {s = 85;}

                        else if ( (LA26_45=='t') ) {s = 86;}

                        else if ( (LA26_45=='u') ) {s = 87;}

                        else if ( ((LA26_45>='\u0000' && LA26_45<='!')||(LA26_45>='#' && LA26_45<='.')||(LA26_45>='0' && LA26_45<='[')||(LA26_45>=']' && LA26_45<='a')||(LA26_45>='c' && LA26_45<='e')||(LA26_45>='g' && LA26_45<='m')||(LA26_45>='o' && LA26_45<='q')||LA26_45=='s'||(LA26_45>='v' && LA26_45<='\uFFFF')) && (( getCharPositionInLine()==0 ))) {s = 34;}

                         
                        input.seek(index26_45);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-02-02 00:39:14

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
import org.xerial.util.log.Logger;
import org.xerial.silk.impl.SilkLexerState;
import org.xerial.silk.impl.SilkLexerState.State;
import org.xerial.silk.impl.SilkLexerState.Symbol;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SilkLexer extends Lexer {
    public static final int Key=14;
    public static final int PlainUnsafeChar=48;
    public static final int PlainSafeKey=49;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=32;
    public static final int Digit=35;
    public static final int NodeIndent=19;
    public static final int HexDigit=37;
    public static final int PlainOneLine=53;
    public static final int Plus=31;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int FlowIndicator=47;
    public static final int Separation=55;
    public static final int Letter=36;
    public static final int PlainSafeIn=50;
    public static final int Comma=26;
    public static final int EscapeSequence=39;
    public static final int NonSpaceChar=41;
    public static final int DataLine=23;
    public static final int PlainFirst=45;
    public static final int WhiteSpace=20;
    public static final int PlainSafeOut=51;
    public static final int JSON=54;
    public static final int Question=34;
    public static final int LineComment=15;
    public static final int Colon=27;
    public static final int At=30;
    public static final int DataLineBody=22;
    public static final int KeyValuePair=13;
    public static final int Star=29;
    public static final int Preamble=16;
    public static final int Seq=28;
    public static final int Indicator=44;
    public static final int RParen=25;
    public static final int UnicodeChar=38;
    public static final int StringChar=40;
    public static final int Silk=4;
    public static final int BlankLine=21;
    public static final int LineBreak=18;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=24;
    public static final int String=43;
    public static final int LineBreakChar=17;
    public static final int ScopeIndicator=46;
    public static final int EOF=-1;
    public static final int StringChar_s=42;
    public static final int Value=8;
    public static final int RBracket=33;
    public static final int PlainSafe=52;


    private static Logger _logger = Logger.getLogger(SilkLexer.class);

    private SilkLexerState lexerContext = new SilkLexerState();

    private State currentState() { return lexerContext.getCurrentState(); } 
    private void transit(Symbol token) { lexerContext.transit(token); } 
    private void resetContext() { lexerContext.reset(); }
    private boolean isKey() { return currentState() == State.IN_KEY || currentState() == State.OUT_KEY; }
    private boolean isValue() { return currentState() == State.IN_VALUE || currentState() == State.OUT_VALUE; }
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:12: ( '#' (~ ( '\\n' | '\\r' ) )* '\\r' '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:14: '#' (~ ( '\\n' | '\\r' ) )* '\\r' '\\n'
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:18: ~ ( '\\n' | '\\r' )
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

            match('\r'); 
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: ~ ( '\\n' | '\\r' )
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
            	    break loop2;
                }
            } while (true);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:29: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:29: '\\r'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:137:23: ( '\\n' | '\\r' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\n') ) {
                    alt4=1;
                }
                else {
                    alt4=2;}
            }
            else if ( (LA4_0=='\n') ) {
                alt4=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:24: '\\n'
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

    // $ANTLR start "NodeIndent"
    public final void mNodeIndent() throws RecognitionException {
        try {
            int _type = NodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:11: ({...}? ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:13: {...}? ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:27: ( ' ' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:28: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "NodeIndent"

    // $ANTLR start "BlankLine"
    public final void mBlankLine() throws RecognitionException {
        try {
            int _type = BlankLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:10: ({...}? ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:12: {...}? ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:26: ( WhiteSpace )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:26: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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

    // $ANTLR start "DataLineBody"
    public final void mDataLineBody() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:22: (~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:24: ~ ( '-' | '%' | '#' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:72: (~ ( '#' | '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\"')||(LA7_0>='$' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:72: ~ ( '#' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='\uFFFF') ) {
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


            }

        }
        finally {
        }
    }
    // $ANTLR end "DataLineBody"

    // $ANTLR start "DataLine"
    public final void mDataLine() throws RecognitionException {
        try {
            int _type = DataLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token DataLineBody1=null;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:11: {...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment )
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:5: ( WhiteSpace )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            int DataLineBody1Start206 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start206, getCharIndex()-1);
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:30: ( LineBreak | LineComment )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            else if ( (LA9_0=='#') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:31: LineBreak
                    {
                    mLineBreak(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:41: LineComment
                    {
                    mLineComment(); 

                    }
                    break;

            }

             setText((DataLineBody1!=null?DataLineBody1.getText():null)); 

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:9: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:8: ':'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:4: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:7: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:8: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:6: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:11: '?'
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

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:18: ( Digit | Letter )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt10=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt10=1;
                }
                break;
            case '\\':
                {
                alt10=2;
                }
                break;
            case '/':
                {
                alt10=3;
                }
                break;
            case 'b':
                {
                alt10=4;
                }
                break;
            case 'f':
                {
                alt10=5;
                }
                break;
            case 'n':
                {
                alt10=6;
                }
                break;
            case 'r':
                {
                alt10=7;
                }
                break;
            case 't':
                {
                alt10=8;
                }
                break;
            case 'u':
                {
                alt10=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:21: ( UnicodeChar | EscapeSequence )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                alt11=1;
            }
            else if ( (LA11_0=='\\') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "NonSpaceChar"

    // $ANTLR start "StringChar_s"
    public final void mStringChar_s() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:22: ( ( StringChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:24: ( StringChar )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:24: ( StringChar )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop12;
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:7: ( '\"' s= StringChar_s '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart493 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart493, getCharIndex()-1);
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

    // $ANTLR start "PlainFirst"
    public final void mPlainFirst() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | {...}? => ( ':' | '?' ) NonSpaceChar )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='?') ) {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1>='\u0000' && LA13_1<='\b')||(LA13_1>='\u000B' && LA13_1<='\f')||(LA13_1>='\u000E' && LA13_1<='\u001F')||LA13_1=='!'||(LA13_1>='#' && LA13_1<='[')||(LA13_1>=']' && LA13_1<='\uFFFF')) && (( isValue() ))) {
                    alt13=2;
                }
                else {
                    alt13=1;}
            }
            else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||LA13_0=='$'||LA13_0=='&'||(LA13_0>='*' && LA13_0<='+')||(LA13_0>='.' && LA13_0<='9')||(LA13_0>=';' && LA13_0<='=')||(LA13_0>='A' && LA13_0<='Z')||(LA13_0>='^' && LA13_0<='z')||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {
                alt13=1;
            }
            else if ( (LA13_0==':') && (( isValue() ))) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:4: {...}? => ( ':' | '?' ) NonSpaceChar
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
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

    // $ANTLR start "ScopeIndicator"
    public final void mScopeIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:24: ( '(' | ')' )
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

    // $ANTLR start "FlowIndicator"
    public final void mFlowIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:23: ( '[' | ']' | '{' | '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
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

    // $ANTLR start "Indicator"
    public final void mIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:19: ( FlowIndicator | ScopeIndicator | ',' | '-' | ':' | '#' | '>' | '\\'' | '\"' | '@' | '%' | '\\\\' )
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

    // $ANTLR start "PlainUnsafeChar"
    public final void mPlainUnsafeChar() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:25: ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator )
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
    // $ANTLR end "PlainUnsafeChar"

    // $ANTLR start "PlainSafeKey"
    public final void mPlainSafeKey() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:22: (~ ( PlainUnsafeChar | FlowIndicator | ',' | ':' | '>' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:24: ~ ( PlainUnsafeChar | FlowIndicator | ',' | ':' | '>' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "PlainSafeKey"

    // $ANTLR start "PlainSafeIn"
    public final void mPlainSafeIn() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:21: (~ ( PlainUnsafeChar | ',' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:23: ~ ( PlainUnsafeChar | ',' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "PlainSafeIn"

    // $ANTLR start "PlainSafeOut"
    public final void mPlainSafeOut() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:22: (~ ( PlainUnsafeChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:24: ~ ( PlainUnsafeChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "PlainSafeOut"

    // $ANTLR start "PlainSafe"
    public final void mPlainSafe() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='$' && LA14_0<='\'')||(LA14_0>='*' && LA14_0<='+')||(LA14_0>='-' && LA14_0<='9')||(LA14_0>=';' && LA14_0<='=')||(LA14_0>='?' && LA14_0<='Z')||(LA14_0>='^' && LA14_0<='z')||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA14_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt14=1;
                }
                else if ( (( isInValue() )) ) {
                    alt14=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA14_0==':'||LA14_0=='>'||LA14_0=='['||LA14_0==']'||LA14_0=='{'||LA14_0=='}') && ((( isInValue() )||( isOutValue() )))) {
                int LA14_2 = input.LA(2);

                if ( (( isInValue() )) ) {
                    alt14=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA14_0==',') && (( isOutValue() ))) {
                alt14=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:4: {...}? => PlainSafeOut
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:13: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:15: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:26: ( ( WhiteSpace )* PlainSafe )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\t'||LA16_0==' ') ) {
                    alt16=1;
                }
                else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='$' && LA16_0<='\'')||(LA16_0>='*' && LA16_0<='+')||(LA16_0>='-' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='?' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt16=1;
                }
                else if ( (LA16_0==':'||LA16_0=='>'||LA16_0=='['||LA16_0==']'||LA16_0=='{'||LA16_0=='}') && ((( isInValue() )||( isOutValue() )))) {
                    alt16=1;
                }
                else if ( (LA16_0==',') && (( isOutValue() ))) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:27: ( WhiteSpace )* PlainSafe
            	    {
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:27: ( WhiteSpace )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0=='\t'||LA15_0==' ') ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:27: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);

            	    mPlainSafe(); 

            	    }
            	    break;

            	default :
            	    break loop16;
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

    // $ANTLR start "JSON"
    public final void mJSON() throws RecognitionException {
        try {
            int _type = JSON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:2: ({...}? => '{' | {...}? => '[' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='{') && (( isValue() ))) {
                alt17=1;
            }
            else if ( (LA17_0=='[') && (( isValue() ))) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:4: {...}? => '{'
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "JSON", " isValue() ");
                    }
                    match('{'); 

                    		//_logger.info("enter JSON object");
                    		InLineJSONLexer l = new InLineJSONLexer(input);
                    		CommonTokenStream tokens = new CommonTokenStream(l);
                    		InLineJSONParser p = new InLineJSONParser(tokens);
                    		p.jsonObjectFragment();
                    		
                    		//_channel = JSON_CHANNEL;
                    		emit(new CommonToken(JSON, getText())); 
                    	

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:219:4: {...}? => '['
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "JSON", " isValue() ");
                    }
                    match('['); 

                    		//_logger.info("enter JSON array");
                    		InLineJSONLexer l = new InLineJSONLexer(input);
                    		CommonTokenStream tokens = new CommonTokenStream(l);
                    		InLineJSONParser p = new InLineJSONParser(tokens);
                    		p.jsonArrayFragment();
                    		
                    		//_channel = JSON_CHANNEL;
                    		emit(new CommonToken(JSON, getText())); 
                    	

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JSON"

    // $ANTLR start "Separation"
    public final void mSeparation() throws RecognitionException {
        try {
            int _type = Separation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:11: ({...}? ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:13: {...}? ( WhiteSpace )+
            {
            if ( !(( currentState() != State.INIT )) ) {
                throw new FailedPredicateException(input, "Separation", " currentState() != State.INIT ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:47: ( WhiteSpace )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\t'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:232:47: WhiteSpace
            	    {
            	    mWhiteSpace(); 

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:235:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:235:4: ( ' ' | '\\t' )
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
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | NodeIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace )
        int alt19=22;
        alt19 = dfa19.predict(input);
        switch (alt19) {
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:41: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:52: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:62: DataLine
                {
                mDataLine(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:71: LParen
                {
                mLParen(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:78: RParen
                {
                mRParen(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:85: Comma
                {
                mComma(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:91: Colon
                {
                mColon(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:97: Seq
                {
                mSeq(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:101: Star
                {
                mStar(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:106: At
                {
                mAt(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:109: Plus
                {
                mPlus(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:114: LBracket
                {
                mLBracket(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:123: RBracket
                {
                mRBracket(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:132: Question
                {
                mQuestion(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:141: String
                {
                mString(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:148: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:161: JSON
                {
                mJSON(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:166: Separation
                {
                mSeparation(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:177: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\3\uffff\1\30\1\31\1\32\1\uffff\1\32\1\36\1\37\1\40\1\42\1\44\1"+
        "\46\1\52\1\53\1\54\1\55\1\57\1\uffff\1\66\1\67\1\uffff\1\70\3\uffff"+
        "\1\72\1\uffff\1\72\3\uffff\1\74\1\uffff\1\74\3\uffff\3\66\4\uffff"+
        "\1\106\1\uffff\2\106\3\uffff\1\127\10\uffff\3\74\1\uffff\3\74\3"+
        "\uffff\3\106\1\127\35\uffff";
    static final String DFA19_eofS =
        "\151\uffff";
    static final String DFA19_minS =
        "\1\0\2\uffff\1\12\2\0\1\uffff\17\0\1\uffff\5\0\1\uffff\1\0\3\uffff"+
        "\1\0\1\uffff\1\0\1\uffff\1\0\1\uffff\3\0\2\uffff\1\0\1\uffff\1\0"+
        "\1\uffff\6\0\2\uffff\1\0\4\uffff\10\0\2\uffff\20\0\1\uffff\21\0";
    static final String DFA19_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\uffff\1\uffff\17\uffff\1\uffff\4\0"+
        "\1\uffff\1\uffff\1\uffff\3\uffff\1\uffff\1\uffff\1\uffff\1\uffff"+
        "\1\uffff\1\uffff\3\uffff\2\uffff\1\0\1\uffff\1\uffff\1\uffff\6\uffff"+
        "\2\uffff\1\0\4\uffff\10\uffff\2\uffff\20\uffff\1\uffff\21\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\4\17\uffff\1\6\5\uffff\1\5\1\uffff\1"+
        "\7\1\10\1\11\1\uffff\1\12\1\uffff\1\13\1\uffff\1\14\3\uffff\1\15"+
        "\1\16\1\uffff\1\20\1\uffff\1\21\6\uffff\1\23\1\24\1\uffff\1\3\1"+
        "\25\1\26\1\23\10\uffff\1\17\1\23\20\uffff\1\22\21\uffff";
    static final String DFA19_specialS =
        "\1\54\4\uffff\1\33\1\uffff\1\46\1\24\1\17\1\61\1\57\1\76\1\41\1"+
        "\105\1\30\1\62\1\111\1\60\1\23\1\70\1\74\2\uffff\1\51\1\50\1\45"+
        "\1\110\1\uffff\1\115\3\uffff\1\37\1\uffff\1\26\1\uffff\1\103\1\uffff"+
        "\1\42\1\1\1\64\2\uffff\1\40\1\uffff\1\55\1\uffff\1\77\1\4\1\102"+
        "\1\71\1\25\1\113\2\uffff\1\52\4\uffff\1\104\1\43\1\2\1\65\1\47\1"+
        "\107\1\72\1\73\2\uffff\1\3\1\75\1\63\1\7\1\20\1\32\1\13\1\100\1"+
        "\15\1\36\1\56\1\53\1\44\1\11\1\31\1\66\1\uffff\1\6\1\0\1\10\1\14"+
        "\1\112\1\21\1\34\1\27\1\16\1\101\1\35\1\22\1\67\1\12\1\114\1\5\1"+
        "\106}>";
    static final String[] DFA19_transitionS = {
            "\11\24\1\7\1\4\2\24\1\3\22\24\1\5\1\24\1\23\1\1\1\24\1\2\1"+
            "\24\1\26\1\10\1\11\1\15\1\17\1\12\1\6\14\24\1\13\3\24\1\14\1"+
            "\22\1\16\32\24\1\20\1\26\1\21\35\24\1\25\1\24\1\26\uff82\24",
            "",
            "",
            "\1\27",
            "\1\uffff",
            "\11\26\1\35\1\34\2\26\1\34\22\26\1\33\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\6\uffd2\26",
            "",
            "\11\26\1\35\1\34\2\26\1\34\22\26\1\35\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\uffff\uffd2\26",
            "\0\26",
            "\0\26",
            "\0\26",
            "\11\41\2\26\2\41\1\26\22\41\1\26\1\41\1\26\1\43\70\41\1\26"+
            "\uffa3\41",
            "\0\26",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "\0\26",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "\0\26",
            "\0\26",
            "\11\56\1\45\1\26\2\56\1\26\22\56\1\45\1\56\1\26\1\43\4\56"+
            "\2\41\2\56\1\61\15\56\1\60\3\56\1\60\34\56\1\60\1\26\1\60\35"+
            "\56\1\60\1\56\1\60\uff82\56",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "\0\26",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\11\26\1\35\1\34\2\26\1\34\22\26\1\33\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\6\uffd2\26",
            "",
            "\11\26\1\35\1\34\2\26\1\34\22\26\1\35\2\26\1\uffff\1\26\1"+
            "\uffff\7\26\1\uffff\uffd2\26",
            "",
            "",
            "",
            "\11\76\1\75\1\26\2\76\1\26\22\76\1\75\1\76\2\26\4\76\2\26"+
            "\2\76\1\100\15\76\1\77\3\76\1\77\34\76\1\77\1\26\1\77\35\76"+
            "\1\77\1\76\1\77\uff82\76",
            "",
            "\11\102\1\101\1\uffff\2\102\1\26\22\102\1\101\1\102\2\26\4"+
            "\102\2\26\2\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\26\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "\11\47\1\45\1\26\2\47\1\26\22\47\1\45\1\47\2\26\4\47\2\26"+
            "\2\47\1\51\15\47\1\50\3\47\1\50\34\47\1\50\1\26\1\50\35\47\1"+
            "\50\1\47\1\50\uff82\47",
            "",
            "",
            "\1\uffff",
            "",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\42\26\1\116\14\26\1\120\54\26\1\117\5\26\1\121\3\26\1\122"+
            "\7\26\1\123\3\26\1\124\1\26\1\125\1\126\uff8a\26",
            "\0\26",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\11\76\1\75\1\26\2\76\1\26\22\76\1\75\1\76\2\26\4\76\2\26"+
            "\2\76\1\100\15\76\1\77\3\76\1\77\34\76\1\77\1\26\1\77\35\76"+
            "\1\77\1\76\1\77\uff82\76",
            "\11\76\1\75\1\26\2\76\1\26\22\76\1\75\1\76\2\26\4\76\2\26"+
            "\2\76\1\100\15\76\1\77\3\76\1\77\34\76\1\77\1\26\1\77\35\76"+
            "\1\77\1\76\1\77\uff82\76",
            "\11\76\1\75\1\26\2\76\1\26\22\76\1\75\1\76\2\26\4\76\2\26"+
            "\2\76\1\100\15\76\1\77\3\76\1\77\34\76\1\77\1\26\1\77\35\76"+
            "\1\77\1\76\1\77\uff82\76",
            "\11\76\1\75\1\26\2\76\1\26\22\76\1\75\1\76\2\26\4\76\2\26"+
            "\2\76\1\100\15\76\1\77\3\76\1\77\34\76\1\77\1\26\1\77\35\76"+
            "\1\77\1\76\1\77\uff82\76",
            "\11\102\1\101\1\uffff\2\102\1\26\22\102\1\101\1\102\2\26\4"+
            "\102\2\26\2\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\26\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\uffff\2\102\1\26\22\102\1\101\1\102\2\26\4"+
            "\102\2\26\2\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\26\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\uffff\2\102\1\26\22\102\1\101\1\102\2\26\4"+
            "\102\2\26\2\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\26\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\uffff\2\102\1\26\22\102\1\101\1\102\2\26\4"+
            "\102\2\26\2\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\26\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "",
            "",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\11\110\1\107\1\26\2\110\1\26\22\110\1\107\1\110\2\26\4\110"+
            "\2\26\2\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111\1\26"+
            "\1\111\35\110\1\111\1\110\1\111\uff82\110",
            "\12\26\1\uffff\ufff5\26",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\26\1\uffff\27\26\1\130\14\26\1\132\54\26\1\131\5\26\1"+
            "\133\3\26\1\134\7\26\1\135\3\26\1\136\1\26\1\137\1\140\uff8a"+
            "\26",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\60\26\12\141\7\26\6\141\32\26\6\141\uff99\26",
            "",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114",
            "\12\26\1\uffff\45\26\12\142\7\26\6\142\32\26\6\142\uff99\26",
            "\60\26\12\143\7\26\6\143\32\26\6\143\uff99\26",
            "\12\26\1\uffff\45\26\12\144\7\26\6\144\32\26\6\144\uff99\26",
            "\60\26\12\145\7\26\6\145\32\26\6\145\uff99\26",
            "\12\26\1\uffff\45\26\12\146\7\26\6\146\32\26\6\146\uff99\26",
            "\60\26\12\147\7\26\6\147\32\26\6\147\uff99\26",
            "\12\26\1\uffff\45\26\12\150\7\26\6\150\32\26\6\150\uff99\26",
            "\12\62\1\26\2\62\1\26\24\62\1\65\1\63\70\62\1\64\uffa3\62",
            "\12\114\1\uffff\2\114\1\26\24\114\1\113\71\114\1\115\uffa3"+
            "\114"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | NodeIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_89 = input.LA(1);

                         
                        int index19_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_89=='\"') ) {s = 75;}

                        else if ( ((LA19_89>='\u0000' && LA19_89<='\t')||(LA19_89>='\u000B' && LA19_89<='\f')||(LA19_89>='\u000E' && LA19_89<='!')||(LA19_89>='#' && LA19_89<='[')||(LA19_89>=']' && LA19_89<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_89=='\\') ) {s = 77;}

                        else if ( (LA19_89=='\r') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_89);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_40 = input.LA(1);

                         
                        int index19_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_40=='\t'||LA19_40==' ') ) {s = 37;}

                        else if ( ((LA19_40>='\u0000' && LA19_40<='\b')||(LA19_40>='\u000B' && LA19_40<='\f')||(LA19_40>='\u000E' && LA19_40<='\u001F')||LA19_40=='!'||(LA19_40>='$' && LA19_40<='\'')||(LA19_40>='*' && LA19_40<='+')||(LA19_40>='-' && LA19_40<='9')||(LA19_40>=';' && LA19_40<='=')||(LA19_40>='?' && LA19_40<='Z')||(LA19_40>='^' && LA19_40<='z')||LA19_40=='|'||(LA19_40>='~' && LA19_40<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_40==':'||LA19_40=='>'||LA19_40=='['||LA19_40==']'||LA19_40=='{'||LA19_40=='}') ) {s = 40;}

                        else if ( (LA19_40==',') ) {s = 41;}

                        else if ( (LA19_40=='\n'||LA19_40=='\r'||(LA19_40>='\"' && LA19_40<='#')||(LA19_40>='(' && LA19_40<=')')||LA19_40=='\\') && (( isHead() ))) {s = 22;}

                        else s = 54;

                         
                        input.seek(index19_40);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_63 = input.LA(1);

                         
                        int index19_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_63=='\t'||LA19_63==' ') && ((( isValue() )||( isHead() )))) {s = 61;}

                        else if ( ((LA19_63>='\u0000' && LA19_63<='\b')||(LA19_63>='\u000B' && LA19_63<='\f')||(LA19_63>='\u000E' && LA19_63<='\u001F')||LA19_63=='!'||(LA19_63>='$' && LA19_63<='\'')||(LA19_63>='*' && LA19_63<='+')||(LA19_63>='-' && LA19_63<='9')||(LA19_63>=';' && LA19_63<='=')||(LA19_63>='?' && LA19_63<='Z')||(LA19_63>='^' && LA19_63<='z')||LA19_63=='|'||(LA19_63>='~' && LA19_63<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 62;}

                        else if ( (LA19_63==':'||LA19_63=='>'||LA19_63=='['||LA19_63==']'||LA19_63=='{'||LA19_63=='}') && ((( isValue() )||( isHead() )))) {s = 63;}

                        else if ( (LA19_63==',') && ((( isValue() )||( isHead() )))) {s = 64;}

                        else if ( (LA19_63=='\n'||LA19_63=='\r'||(LA19_63>='\"' && LA19_63<='#')||(LA19_63>='(' && LA19_63<=')')||LA19_63=='\\') && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index19_63);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_71 = input.LA(1);

                         
                        int index19_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_71>='\u0000' && LA19_71<='\b')||(LA19_71>='\u000B' && LA19_71<='\f')||(LA19_71>='\u000E' && LA19_71<='\u001F')||LA19_71=='!'||(LA19_71>='$' && LA19_71<='\'')||(LA19_71>='*' && LA19_71<='+')||(LA19_71>='-' && LA19_71<='9')||(LA19_71>=';' && LA19_71<='=')||(LA19_71>='?' && LA19_71<='Z')||(LA19_71>='^' && LA19_71<='z')||LA19_71=='|'||(LA19_71>='~' && LA19_71<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_71==':'||LA19_71=='>'||LA19_71=='['||LA19_71==']'||LA19_71=='{'||LA19_71=='}') ) {s = 73;}

                        else if ( (LA19_71==',') ) {s = 74;}

                        else if ( (LA19_71=='\t'||LA19_71==' ') ) {s = 71;}

                        else if ( (LA19_71=='\n'||LA19_71=='\r'||(LA19_71>='\"' && LA19_71<='#')||(LA19_71>='(' && LA19_71<=')')||LA19_71=='\\') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_71);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_49 = input.LA(1);

                         
                        int index19_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_49=='\t'||LA19_49==' ') ) {s = 71;}

                        else if ( ((LA19_49>='\u0000' && LA19_49<='\b')||(LA19_49>='\u000B' && LA19_49<='\f')||(LA19_49>='\u000E' && LA19_49<='\u001F')||LA19_49=='!'||(LA19_49>='$' && LA19_49<='\'')||(LA19_49>='*' && LA19_49<='+')||(LA19_49>='-' && LA19_49<='9')||(LA19_49>=';' && LA19_49<='=')||(LA19_49>='?' && LA19_49<='Z')||(LA19_49>='^' && LA19_49<='z')||LA19_49=='|'||(LA19_49>='~' && LA19_49<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_49==':'||LA19_49=='>'||LA19_49=='['||LA19_49==']'||LA19_49=='{'||LA19_49=='}') ) {s = 73;}

                        else if ( (LA19_49==',') ) {s = 74;}

                        else if ( (LA19_49=='\n'||LA19_49=='\r'||(LA19_49>='\"' && LA19_49<='#')||(LA19_49>='(' && LA19_49<=')')||LA19_49=='\\') && (( isHead() ))) {s = 22;}

                        else s = 70;

                         
                        input.seek(index19_49);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_103 = input.LA(1);

                         
                        int index19_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_103=='\n'||LA19_103=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_103=='#') ) {s = 51;}

                        else if ( (LA19_103=='\"') ) {s = 53;}

                        else if ( ((LA19_103>='\u0000' && LA19_103<='\t')||(LA19_103>='\u000B' && LA19_103<='\f')||(LA19_103>='\u000E' && LA19_103<='!')||(LA19_103>='$' && LA19_103<='[')||(LA19_103>=']' && LA19_103<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_103=='\\') ) {s = 52;}

                         
                        input.seek(index19_103);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_88 = input.LA(1);

                         
                        int index19_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_88=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_88=='\"') ) {s = 75;}

                        else if ( ((LA19_88>='\u0000' && LA19_88<='\t')||(LA19_88>='\u000B' && LA19_88<='\f')||(LA19_88>='\u000E' && LA19_88<='!')||(LA19_88>='#' && LA19_88<='[')||(LA19_88>=']' && LA19_88<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_88=='\\') ) {s = 77;}

                         
                        input.seek(index19_88);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_74 = input.LA(1);

                         
                        int index19_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_74=='\n'||LA19_74=='\r'||(LA19_74>='\"' && LA19_74<='#')||(LA19_74>='(' && LA19_74<=')')||LA19_74=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_74=='\t'||LA19_74==' ') ) {s = 71;}

                        else if ( ((LA19_74>='\u0000' && LA19_74<='\b')||(LA19_74>='\u000B' && LA19_74<='\f')||(LA19_74>='\u000E' && LA19_74<='\u001F')||LA19_74=='!'||(LA19_74>='$' && LA19_74<='\'')||(LA19_74>='*' && LA19_74<='+')||(LA19_74>='-' && LA19_74<='9')||(LA19_74>=';' && LA19_74<='=')||(LA19_74>='?' && LA19_74<='Z')||(LA19_74>='^' && LA19_74<='z')||LA19_74=='|'||(LA19_74>='~' && LA19_74<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_74==':'||LA19_74=='>'||LA19_74=='['||LA19_74==']'||LA19_74=='{'||LA19_74=='}') ) {s = 73;}

                        else if ( (LA19_74==',') ) {s = 74;}

                        else s = 70;

                         
                        input.seek(index19_74);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_90 = input.LA(1);

                         
                        int index19_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_90=='\"') ) {s = 75;}

                        else if ( ((LA19_90>='\u0000' && LA19_90<='\t')||(LA19_90>='\u000B' && LA19_90<='\f')||(LA19_90>='\u000E' && LA19_90<='!')||(LA19_90>='#' && LA19_90<='[')||(LA19_90>=']' && LA19_90<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_90=='\\') ) {s = 77;}

                        else if ( (LA19_90=='\r') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_90);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_84 = input.LA(1);

                         
                        int index19_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_84=='\n'||LA19_84=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_84=='#') ) {s = 51;}

                        else if ( (LA19_84=='\"') ) {s = 53;}

                        else if ( ((LA19_84>='\u0000' && LA19_84<='\t')||(LA19_84>='\u000B' && LA19_84<='\f')||(LA19_84>='\u000E' && LA19_84<='!')||(LA19_84>='$' && LA19_84<='[')||(LA19_84>=']' && LA19_84<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_84=='\\') ) {s = 52;}

                         
                        input.seek(index19_84);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_101 = input.LA(1);

                         
                        int index19_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_101>='\u0000' && LA19_101<='/')||(LA19_101>=':' && LA19_101<='@')||(LA19_101>='G' && LA19_101<='`')||(LA19_101>='g' && LA19_101<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_101>='0' && LA19_101<='9')||(LA19_101>='A' && LA19_101<='F')||(LA19_101>='a' && LA19_101<='f')) ) {s = 103;}

                         
                        input.seek(index19_101);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_77 = input.LA(1);

                         
                        int index19_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_77>='\u0000' && LA19_77<='\t')||(LA19_77>='\u000B' && LA19_77<='!')||(LA19_77>='#' && LA19_77<='.')||(LA19_77>='0' && LA19_77<='[')||(LA19_77>=']' && LA19_77<='a')||(LA19_77>='c' && LA19_77<='e')||(LA19_77>='g' && LA19_77<='m')||(LA19_77>='o' && LA19_77<='q')||LA19_77=='s'||(LA19_77>='v' && LA19_77<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_77=='\"') ) {s = 88;}

                        else if ( (LA19_77=='\\') ) {s = 89;}

                        else if ( (LA19_77=='/') ) {s = 90;}

                        else if ( (LA19_77=='b') ) {s = 91;}

                        else if ( (LA19_77=='f') ) {s = 92;}

                        else if ( (LA19_77=='n') ) {s = 93;}

                        else if ( (LA19_77=='r') ) {s = 94;}

                        else if ( (LA19_77=='t') ) {s = 95;}

                        else if ( (LA19_77=='u') ) {s = 96;}

                         
                        input.seek(index19_77);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_91 = input.LA(1);

                         
                        int index19_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_91=='\"') ) {s = 75;}

                        else if ( ((LA19_91>='\u0000' && LA19_91<='\t')||(LA19_91>='\u000B' && LA19_91<='\f')||(LA19_91>='\u000E' && LA19_91<='!')||(LA19_91>='#' && LA19_91<='[')||(LA19_91>=']' && LA19_91<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_91=='\\') ) {s = 77;}

                        else if ( (LA19_91=='\r') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_91);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_79 = input.LA(1);

                         
                        int index19_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_79=='\n'||LA19_79=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_79=='#') ) {s = 51;}

                        else if ( (LA19_79=='\"') ) {s = 53;}

                        else if ( ((LA19_79>='\u0000' && LA19_79<='\t')||(LA19_79>='\u000B' && LA19_79<='\f')||(LA19_79>='\u000E' && LA19_79<='!')||(LA19_79>='$' && LA19_79<='[')||(LA19_79>=']' && LA19_79<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_79=='\\') ) {s = 52;}

                         
                        input.seek(index19_79);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_96 = input.LA(1);

                         
                        int index19_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_96>='0' && LA19_96<='9')||(LA19_96>='A' && LA19_96<='F')||(LA19_96>='a' && LA19_96<='f')) ) {s = 98;}

                        else if ( ((LA19_96>='\u0000' && LA19_96<='\t')||(LA19_96>='\u000B' && LA19_96<='/')||(LA19_96>=':' && LA19_96<='@')||(LA19_96>='G' && LA19_96<='`')||(LA19_96>='g' && LA19_96<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_96);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_9 = input.LA(1);

                         
                        int index19_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_9>='\u0000' && LA19_9<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 31;

                         
                        input.seek(index19_9);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA19_75 = input.LA(1);

                         
                        int index19_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_75>='\u0000' && LA19_75<='\t')||(LA19_75>='\u000B' && LA19_75<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 87;

                         
                        input.seek(index19_75);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA19_93 = input.LA(1);

                         
                        int index19_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_93=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_93=='\"') ) {s = 75;}

                        else if ( ((LA19_93>='\u0000' && LA19_93<='\t')||(LA19_93>='\u000B' && LA19_93<='\f')||(LA19_93>='\u000E' && LA19_93<='!')||(LA19_93>='#' && LA19_93<='[')||(LA19_93>=']' && LA19_93<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_93=='\\') ) {s = 77;}

                         
                        input.seek(index19_93);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA19_99 = input.LA(1);

                         
                        int index19_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_99>='0' && LA19_99<='9')||(LA19_99>='A' && LA19_99<='F')||(LA19_99>='a' && LA19_99<='f')) ) {s = 101;}

                        else if ( ((LA19_99>='\u0000' && LA19_99<='/')||(LA19_99>=':' && LA19_99<='@')||(LA19_99>='G' && LA19_99<='`')||(LA19_99>='g' && LA19_99<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_99);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA19_19 = input.LA(1);

                         
                        int index19_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_19>='\u0000' && LA19_19<='\t')||(LA19_19>='\u000B' && LA19_19<='\f')||(LA19_19>='\u000E' && LA19_19<='!')||(LA19_19>='$' && LA19_19<='[')||(LA19_19>=']' && LA19_19<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_19=='\n'||LA19_19=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_19=='#') ) {s = 51;}

                        else if ( (LA19_19=='\\') ) {s = 52;}

                        else if ( (LA19_19=='\"') ) {s = 53;}

                         
                        input.seek(index19_19);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA19_8 = input.LA(1);

                         
                        int index19_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_8>='\u0000' && LA19_8<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 30;

                         
                        input.seek(index19_8);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA19_52 = input.LA(1);

                         
                        int index19_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_52>='\u0000' && LA19_52<='!')||(LA19_52>='#' && LA19_52<='.')||(LA19_52>='0' && LA19_52<='[')||(LA19_52>=']' && LA19_52<='a')||(LA19_52>='c' && LA19_52<='e')||(LA19_52>='g' && LA19_52<='m')||(LA19_52>='o' && LA19_52<='q')||LA19_52=='s'||(LA19_52>='v' && LA19_52<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_52=='\"') ) {s = 78;}

                        else if ( (LA19_52=='\\') ) {s = 79;}

                        else if ( (LA19_52=='/') ) {s = 80;}

                        else if ( (LA19_52=='b') ) {s = 81;}

                        else if ( (LA19_52=='f') ) {s = 82;}

                        else if ( (LA19_52=='n') ) {s = 83;}

                        else if ( (LA19_52=='r') ) {s = 84;}

                        else if ( (LA19_52=='t') ) {s = 85;}

                        else if ( (LA19_52=='u') ) {s = 86;}

                         
                        input.seek(index19_52);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA19_35 = input.LA(1);

                         
                        int index19_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_35=='\t'||LA19_35==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( (LA19_35=='\r'||(LA19_35>='\"' && LA19_35<='#')||(LA19_35>='(' && LA19_35<=')')||LA19_35=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_35>='\u0000' && LA19_35<='\b')||(LA19_35>='\u000B' && LA19_35<='\f')||(LA19_35>='\u000E' && LA19_35<='\u001F')||LA19_35=='!'||(LA19_35>='$' && LA19_35<='\'')||(LA19_35>='*' && LA19_35<='+')||(LA19_35>='-' && LA19_35<='9')||(LA19_35>=';' && LA19_35<='=')||(LA19_35>='?' && LA19_35<='Z')||(LA19_35>='^' && LA19_35<='z')||LA19_35=='|'||(LA19_35>='~' && LA19_35<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( (LA19_35==':'||LA19_35=='>'||LA19_35=='['||LA19_35==']'||LA19_35=='{'||LA19_35=='}') && ((( isHead() )||( isValue() )))) {s = 67;}

                        else if ( (LA19_35==',') && ((( isValue() )||( isHead() )))) {s = 68;}

                        else s = 60;

                         
                        input.seek(index19_35);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA19_95 = input.LA(1);

                         
                        int index19_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_95=='\"') ) {s = 75;}

                        else if ( ((LA19_95>='\u0000' && LA19_95<='\t')||(LA19_95>='\u000B' && LA19_95<='\f')||(LA19_95>='\u000E' && LA19_95<='!')||(LA19_95>='#' && LA19_95<='[')||(LA19_95>=']' && LA19_95<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_95=='\\') ) {s = 77;}

                        else if ( (LA19_95=='\r') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_95);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA19_15 = input.LA(1);

                         
                        int index19_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_15=='\t'||LA19_15==' ') ) {s = 37;}

                        else if ( (LA19_15=='\n'||LA19_15=='\r'||(LA19_15>='\"' && LA19_15<='#')||(LA19_15>='(' && LA19_15<=')')||LA19_15=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_15>='\u0000' && LA19_15<='\b')||(LA19_15>='\u000B' && LA19_15<='\f')||(LA19_15>='\u000E' && LA19_15<='\u001F')||LA19_15=='!'||(LA19_15>='$' && LA19_15<='\'')||(LA19_15>='*' && LA19_15<='+')||(LA19_15>='-' && LA19_15<='9')||(LA19_15>=';' && LA19_15<='=')||(LA19_15>='?' && LA19_15<='Z')||(LA19_15>='^' && LA19_15<='z')||LA19_15=='|'||(LA19_15>='~' && LA19_15<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_15==':'||LA19_15=='>'||LA19_15=='['||LA19_15==']'||LA19_15=='{'||LA19_15=='}') ) {s = 40;}

                        else if ( (LA19_15==',') ) {s = 41;}

                        else s = 43;

                         
                        input.seek(index19_15);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA19_85 = input.LA(1);

                         
                        int index19_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_85=='\"') ) {s = 53;}

                        else if ( (LA19_85=='#') ) {s = 51;}

                        else if ( (LA19_85=='\\') ) {s = 52;}

                        else if ( (LA19_85=='\n'||LA19_85=='\r') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_85>='\u0000' && LA19_85<='\t')||(LA19_85>='\u000B' && LA19_85<='\f')||(LA19_85>='\u000E' && LA19_85<='!')||(LA19_85>='$' && LA19_85<='[')||(LA19_85>=']' && LA19_85<='\uFFFF')) ) {s = 50;}

                         
                        input.seek(index19_85);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA19_76 = input.LA(1);

                         
                        int index19_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_76=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_76=='\"') ) {s = 75;}

                        else if ( ((LA19_76>='\u0000' && LA19_76<='\t')||(LA19_76>='\u000B' && LA19_76<='\f')||(LA19_76>='\u000E' && LA19_76<='!')||(LA19_76>='#' && LA19_76<='[')||(LA19_76>=']' && LA19_76<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_76=='\\') ) {s = 77;}

                         
                        input.seek(index19_76);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA19_5 = input.LA(1);

                         
                        int index19_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_5==' ') ) {s = 27;}

                        else if ( ((LA19_5>='\u0000' && LA19_5<='\b')||(LA19_5>='\u000B' && LA19_5<='\f')||(LA19_5>='\u000E' && LA19_5<='\u001F')||(LA19_5>='!' && LA19_5<='\"')||LA19_5=='$'||(LA19_5>='&' && LA19_5<=',')||(LA19_5>='.' && LA19_5<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_5=='\n'||LA19_5=='\r') ) {s = 28;}

                        else if ( (LA19_5=='-') ) {s = 6;}

                        else if ( (LA19_5=='\t') ) {s = 29;}

                        else s = 26;

                         
                        input.seek(index19_5);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA19_94 = input.LA(1);

                         
                        int index19_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_94=='\"') ) {s = 75;}

                        else if ( ((LA19_94>='\u0000' && LA19_94<='\t')||(LA19_94>='\u000B' && LA19_94<='\f')||(LA19_94>='\u000E' && LA19_94<='!')||(LA19_94>='#' && LA19_94<='[')||(LA19_94>=']' && LA19_94<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_94=='\\') ) {s = 77;}

                        else if ( (LA19_94=='\r') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_94);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA19_98 = input.LA(1);

                         
                        int index19_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_98>='0' && LA19_98<='9')||(LA19_98>='A' && LA19_98<='F')||(LA19_98>='a' && LA19_98<='f')) ) {s = 100;}

                        else if ( ((LA19_98>='\u0000' && LA19_98<='\t')||(LA19_98>='\u000B' && LA19_98<='/')||(LA19_98>=':' && LA19_98<='@')||(LA19_98>='G' && LA19_98<='`')||(LA19_98>='g' && LA19_98<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_98);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA19_80 = input.LA(1);

                         
                        int index19_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_80=='\"') ) {s = 53;}

                        else if ( (LA19_80=='#') ) {s = 51;}

                        else if ( (LA19_80=='\\') ) {s = 52;}

                        else if ( (LA19_80=='\n'||LA19_80=='\r') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_80>='\u0000' && LA19_80<='\t')||(LA19_80>='\u000B' && LA19_80<='\f')||(LA19_80>='\u000E' && LA19_80<='!')||(LA19_80>='$' && LA19_80<='[')||(LA19_80>=']' && LA19_80<='\uFFFF')) ) {s = 50;}

                         
                        input.seek(index19_80);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA19_33 = input.LA(1);

                         
                        int index19_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_33=='\t'||LA19_33==' ') && ((( isValue() )||( isHead() )))) {s = 61;}

                        else if ( ((LA19_33>='\u0000' && LA19_33<='\b')||(LA19_33>='\u000B' && LA19_33<='\f')||(LA19_33>='\u000E' && LA19_33<='\u001F')||LA19_33=='!'||(LA19_33>='$' && LA19_33<='\'')||(LA19_33>='*' && LA19_33<='+')||(LA19_33>='-' && LA19_33<='9')||(LA19_33>=';' && LA19_33<='=')||(LA19_33>='?' && LA19_33<='Z')||(LA19_33>='^' && LA19_33<='z')||LA19_33=='|'||(LA19_33>='~' && LA19_33<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 62;}

                        else if ( (LA19_33==':'||LA19_33=='>'||LA19_33=='['||LA19_33==']'||LA19_33=='{'||LA19_33=='}') && ((( isValue() )||( isHead() )))) {s = 63;}

                        else if ( (LA19_33==',') && ((( isValue() )||( isHead() )))) {s = 64;}

                        else if ( (LA19_33=='\n'||LA19_33=='\r'||(LA19_33>='\"' && LA19_33<='#')||(LA19_33>='(' && LA19_33<=')')||LA19_33=='\\') && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index19_33);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA19_44 = input.LA(1);

                         
                        int index19_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 69;}

                        else if ( (( isValue() )) ) {s = 55;}

                         
                        input.seek(index19_44);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA19_13 = input.LA(1);

                         
                        int index19_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_13=='\t'||LA19_13==' ') ) {s = 37;}

                        else if ( (LA19_13=='\n'||LA19_13=='\r'||(LA19_13>='\"' && LA19_13<='#')||(LA19_13>='(' && LA19_13<=')')||LA19_13=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_13>='\u0000' && LA19_13<='\b')||(LA19_13>='\u000B' && LA19_13<='\f')||(LA19_13>='\u000E' && LA19_13<='\u001F')||LA19_13=='!'||(LA19_13>='$' && LA19_13<='\'')||(LA19_13>='*' && LA19_13<='+')||(LA19_13>='-' && LA19_13<='9')||(LA19_13>=';' && LA19_13<='=')||(LA19_13>='?' && LA19_13<='Z')||(LA19_13>='^' && LA19_13<='z')||LA19_13=='|'||(LA19_13>='~' && LA19_13<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_13==':'||LA19_13=='>'||LA19_13=='['||LA19_13==']'||LA19_13=='{'||LA19_13=='}') ) {s = 40;}

                        else if ( (LA19_13==',') ) {s = 41;}

                        else s = 38;

                         
                        input.seek(index19_13);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA19_39 = input.LA(1);

                         
                        int index19_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_39=='\t'||LA19_39==' ') ) {s = 37;}

                        else if ( ((LA19_39>='\u0000' && LA19_39<='\b')||(LA19_39>='\u000B' && LA19_39<='\f')||(LA19_39>='\u000E' && LA19_39<='\u001F')||LA19_39=='!'||(LA19_39>='$' && LA19_39<='\'')||(LA19_39>='*' && LA19_39<='+')||(LA19_39>='-' && LA19_39<='9')||(LA19_39>=';' && LA19_39<='=')||(LA19_39>='?' && LA19_39<='Z')||(LA19_39>='^' && LA19_39<='z')||LA19_39=='|'||(LA19_39>='~' && LA19_39<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_39==':'||LA19_39=='>'||LA19_39=='['||LA19_39==']'||LA19_39=='{'||LA19_39=='}') ) {s = 40;}

                        else if ( (LA19_39==',') ) {s = 41;}

                        else if ( (LA19_39=='\n'||LA19_39=='\r'||(LA19_39>='\"' && LA19_39<='#')||(LA19_39>='(' && LA19_39<=')')||LA19_39=='\\') && (( isHead() ))) {s = 22;}

                        else s = 54;

                         
                        input.seek(index19_39);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA19_62 = input.LA(1);

                         
                        int index19_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_62=='\t'||LA19_62==' ') && ((( isValue() )||( isHead() )))) {s = 61;}

                        else if ( ((LA19_62>='\u0000' && LA19_62<='\b')||(LA19_62>='\u000B' && LA19_62<='\f')||(LA19_62>='\u000E' && LA19_62<='\u001F')||LA19_62=='!'||(LA19_62>='$' && LA19_62<='\'')||(LA19_62>='*' && LA19_62<='+')||(LA19_62>='-' && LA19_62<='9')||(LA19_62>=';' && LA19_62<='=')||(LA19_62>='?' && LA19_62<='Z')||(LA19_62>='^' && LA19_62<='z')||LA19_62=='|'||(LA19_62>='~' && LA19_62<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 62;}

                        else if ( (LA19_62==':'||LA19_62=='>'||LA19_62=='['||LA19_62==']'||LA19_62=='{'||LA19_62=='}') && ((( isValue() )||( isHead() )))) {s = 63;}

                        else if ( (LA19_62==',') && ((( isValue() )||( isHead() )))) {s = 64;}

                        else if ( (LA19_62=='\n'||LA19_62=='\r'||(LA19_62>='\"' && LA19_62<='#')||(LA19_62>='(' && LA19_62<=')')||LA19_62=='\\') && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index19_62);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA19_83 = input.LA(1);

                         
                        int index19_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_83=='\n'||LA19_83=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_83=='#') ) {s = 51;}

                        else if ( (LA19_83=='\"') ) {s = 53;}

                        else if ( ((LA19_83>='\u0000' && LA19_83<='\t')||(LA19_83>='\u000B' && LA19_83<='\f')||(LA19_83>='\u000E' && LA19_83<='!')||(LA19_83>='$' && LA19_83<='[')||(LA19_83>=']' && LA19_83<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_83=='\\') ) {s = 52;}

                         
                        input.seek(index19_83);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA19_26 = input.LA(1);

                         
                        int index19_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() != State.INIT )) ) {s = 58;}

                        else if ( (true) ) {s = 59;}

                         
                        input.seek(index19_26);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA19_7 = input.LA(1);

                         
                        int index19_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_7=='\t'||LA19_7==' ') ) {s = 29;}

                        else if ( ((LA19_7>='\u0000' && LA19_7<='\b')||(LA19_7>='\u000B' && LA19_7<='\f')||(LA19_7>='\u000E' && LA19_7<='\u001F')||(LA19_7>='!' && LA19_7<='\"')||LA19_7=='$'||(LA19_7>='&' && LA19_7<=',')||(LA19_7>='.' && LA19_7<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_7=='\n'||LA19_7=='\r') ) {s = 28;}

                        else s = 26;

                         
                        input.seek(index19_7);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA19_65 = input.LA(1);

                         
                        int index19_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_65>='\u0000' && LA19_65<='\b')||(LA19_65>='\u000B' && LA19_65<='\f')||(LA19_65>='\u000E' && LA19_65<='\u001F')||LA19_65=='!'||(LA19_65>='$' && LA19_65<='\'')||(LA19_65>='*' && LA19_65<='+')||(LA19_65>='-' && LA19_65<='9')||(LA19_65>=';' && LA19_65<='=')||(LA19_65>='?' && LA19_65<='Z')||(LA19_65>='^' && LA19_65<='z')||LA19_65=='|'||(LA19_65>='~' && LA19_65<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( (LA19_65==':'||LA19_65=='>'||LA19_65=='['||LA19_65==']'||LA19_65=='{'||LA19_65=='}') && ((( isHead() )||( isValue() )))) {s = 67;}

                        else if ( (LA19_65==',') && ((( isValue() )||( isHead() )))) {s = 68;}

                        else if ( (LA19_65=='\t'||LA19_65==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( (LA19_65=='\r'||(LA19_65>='\"' && LA19_65<='#')||(LA19_65>='(' && LA19_65<=')')||LA19_65=='\\') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_65);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA19_25 = input.LA(1);

                         
                        int index19_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 57;}

                        else if ( (( isHead() )) ) {s = 28;}

                         
                        input.seek(index19_25);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA19_24 = input.LA(1);

                         
                        int index19_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 57;}

                        else if ( (( isHead() )) ) {s = 28;}

                         
                        input.seek(index19_24);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA19_56 = input.LA(1);

                         
                        int index19_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 57;}

                        else if ( (( isHead() )) ) {s = 28;}

                         
                        input.seek(index19_56);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA19_82 = input.LA(1);

                         
                        int index19_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_82=='\n'||LA19_82=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_82=='#') ) {s = 51;}

                        else if ( (LA19_82=='\"') ) {s = 53;}

                        else if ( ((LA19_82>='\u0000' && LA19_82<='\t')||(LA19_82>='\u000B' && LA19_82<='\f')||(LA19_82>='\u000E' && LA19_82<='!')||(LA19_82>='$' && LA19_82<='[')||(LA19_82>=']' && LA19_82<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_82=='\\') ) {s = 52;}

                         
                        input.seek(index19_82);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0=='#') ) {s = 1;}

                        else if ( (LA19_0=='%') ) {s = 2;}

                        else if ( (LA19_0=='\r') ) {s = 3;}

                        else if ( (LA19_0=='\n') ) {s = 4;}

                        else if ( (LA19_0==' ') ) {s = 5;}

                        else if ( (LA19_0=='-') ) {s = 6;}

                        else if ( (LA19_0=='\t') ) {s = 7;}

                        else if ( (LA19_0=='(') ) {s = 8;}

                        else if ( (LA19_0==')') ) {s = 9;}

                        else if ( (LA19_0==',') ) {s = 10;}

                        else if ( (LA19_0==':') ) {s = 11;}

                        else if ( (LA19_0=='>') ) {s = 12;}

                        else if ( (LA19_0=='*') ) {s = 13;}

                        else if ( (LA19_0=='@') ) {s = 14;}

                        else if ( (LA19_0=='+') ) {s = 15;}

                        else if ( (LA19_0=='[') ) {s = 16;}

                        else if ( (LA19_0==']') ) {s = 17;}

                        else if ( (LA19_0=='?') ) {s = 18;}

                        else if ( (LA19_0=='\"') ) {s = 19;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||LA19_0=='$'||LA19_0=='&'||(LA19_0>='.' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='=')||(LA19_0>='A' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||LA19_0=='|'||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {s = 20;}

                        else if ( (LA19_0=='{') && ((( isValue() )||( isHead() )))) {s = 21;}

                        else if ( (LA19_0=='\''||LA19_0=='\\'||LA19_0=='}') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA19_46 = input.LA(1);

                         
                        int index19_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_46=='\t'||LA19_46==' ') ) {s = 71;}

                        else if ( ((LA19_46>='\u0000' && LA19_46<='\b')||(LA19_46>='\u000B' && LA19_46<='\f')||(LA19_46>='\u000E' && LA19_46<='\u001F')||LA19_46=='!'||(LA19_46>='$' && LA19_46<='\'')||(LA19_46>='*' && LA19_46<='+')||(LA19_46>='-' && LA19_46<='9')||(LA19_46>=';' && LA19_46<='=')||(LA19_46>='?' && LA19_46<='Z')||(LA19_46>='^' && LA19_46<='z')||LA19_46=='|'||(LA19_46>='~' && LA19_46<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_46==':'||LA19_46=='>'||LA19_46=='['||LA19_46==']'||LA19_46=='{'||LA19_46=='}') ) {s = 73;}

                        else if ( (LA19_46==',') ) {s = 74;}

                        else if ( (LA19_46=='\n'||LA19_46=='\r'||(LA19_46>='\"' && LA19_46<='#')||(LA19_46>='(' && LA19_46<=')')||LA19_46=='\\') && (( isHead() ))) {s = 22;}

                        else s = 70;

                         
                        input.seek(index19_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA19_81 = input.LA(1);

                         
                        int index19_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_81=='\n'||LA19_81=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_81=='#') ) {s = 51;}

                        else if ( (LA19_81=='\"') ) {s = 53;}

                        else if ( ((LA19_81>='\u0000' && LA19_81<='\t')||(LA19_81>='\u000B' && LA19_81<='\f')||(LA19_81>='\u000E' && LA19_81<='!')||(LA19_81>='$' && LA19_81<='[')||(LA19_81>=']' && LA19_81<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_81=='\\') ) {s = 52;}

                         
                        input.seek(index19_81);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA19_11 = input.LA(1);

                         
                        int index19_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_11>='\u0000' && LA19_11<='\b')||(LA19_11>='\u000B' && LA19_11<='\f')||(LA19_11>='\u000E' && LA19_11<='\u001F')||LA19_11=='!'||(LA19_11>='$' && LA19_11<='[')||(LA19_11>=']' && LA19_11<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 33;}

                        else if ( ((LA19_11>='\t' && LA19_11<='\n')||LA19_11=='\r'||LA19_11==' '||LA19_11=='\"'||LA19_11=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_11=='#') && ((( isValue() )||( isHead() )))) {s = 35;}

                        else s = 34;

                         
                        input.seek(index19_11);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA19_18 = input.LA(1);

                         
                        int index19_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_18>='\u0000' && LA19_18<='\b')||(LA19_18>='\u000B' && LA19_18<='\f')||(LA19_18>='\u000E' && LA19_18<='\u001F')||LA19_18=='!'||(LA19_18>='$' && LA19_18<='\'')||(LA19_18>='*' && LA19_18<='+')||(LA19_18>='-' && LA19_18<='9')||(LA19_18>=';' && LA19_18<='=')||(LA19_18>='?' && LA19_18<='Z')||(LA19_18>='^' && LA19_18<='z')||LA19_18=='|'||(LA19_18>='~' && LA19_18<='\uFFFF')) ) {s = 46;}

                        else if ( (LA19_18=='\n'||LA19_18=='\r'||LA19_18=='\"'||LA19_18=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_18=='#') && ((( isValue() )||( isHead() )))) {s = 35;}

                        else if ( (LA19_18=='\t'||LA19_18==' ') ) {s = 37;}

                        else if ( (LA19_18==':'||LA19_18=='>'||LA19_18=='['||LA19_18==']'||LA19_18=='{'||LA19_18=='}') ) {s = 48;}

                        else if ( (LA19_18==',') ) {s = 49;}

                        else if ( ((LA19_18>='(' && LA19_18<=')')) && ((( isHead() )||( isValue() )))) {s = 33;}

                        else s = 47;

                         
                        input.seek(index19_18);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA19_10 = input.LA(1);

                         
                        int index19_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_10>='\u0000' && LA19_10<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 32;

                         
                        input.seek(index19_10);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA19_16 = input.LA(1);

                         
                        int index19_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_16>='\u0000' && LA19_16<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 44;

                         
                        input.seek(index19_16);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA19_73 = input.LA(1);

                         
                        int index19_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_73=='\t'||LA19_73==' ') ) {s = 71;}

                        else if ( ((LA19_73>='\u0000' && LA19_73<='\b')||(LA19_73>='\u000B' && LA19_73<='\f')||(LA19_73>='\u000E' && LA19_73<='\u001F')||LA19_73=='!'||(LA19_73>='$' && LA19_73<='\'')||(LA19_73>='*' && LA19_73<='+')||(LA19_73>='-' && LA19_73<='9')||(LA19_73>=';' && LA19_73<='=')||(LA19_73>='?' && LA19_73<='Z')||(LA19_73>='^' && LA19_73<='z')||LA19_73=='|'||(LA19_73>='~' && LA19_73<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_73==':'||LA19_73=='>'||LA19_73=='['||LA19_73==']'||LA19_73=='{'||LA19_73=='}') ) {s = 73;}

                        else if ( (LA19_73==',') ) {s = 74;}

                        else if ( (LA19_73=='\n'||LA19_73=='\r'||(LA19_73>='\"' && LA19_73<='#')||(LA19_73>='(' && LA19_73<=')')||LA19_73=='\\') && (( isHead() ))) {s = 22;}

                        else s = 70;

                         
                        input.seek(index19_73);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA19_41 = input.LA(1);

                         
                        int index19_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_41=='\n'||LA19_41=='\r'||(LA19_41>='\"' && LA19_41<='#')||(LA19_41>='(' && LA19_41<=')')||LA19_41=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_41=='\t'||LA19_41==' ') ) {s = 37;}

                        else if ( ((LA19_41>='\u0000' && LA19_41<='\b')||(LA19_41>='\u000B' && LA19_41<='\f')||(LA19_41>='\u000E' && LA19_41<='\u001F')||LA19_41=='!'||(LA19_41>='$' && LA19_41<='\'')||(LA19_41>='*' && LA19_41<='+')||(LA19_41>='-' && LA19_41<='9')||(LA19_41>=';' && LA19_41<='=')||(LA19_41>='?' && LA19_41<='Z')||(LA19_41>='^' && LA19_41<='z')||LA19_41=='|'||(LA19_41>='~' && LA19_41<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_41==':'||LA19_41=='>'||LA19_41=='['||LA19_41==']'||LA19_41=='{'||LA19_41=='}') ) {s = 40;}

                        else if ( (LA19_41==',') ) {s = 41;}

                        else s = 54;

                         
                        input.seek(index19_41);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA19_64 = input.LA(1);

                         
                        int index19_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_64=='\n'||LA19_64=='\r'||(LA19_64>='\"' && LA19_64<='#')||(LA19_64>='(' && LA19_64<=')')||LA19_64=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_64=='\t'||LA19_64==' ') && ((( isValue() )||( isHead() )))) {s = 61;}

                        else if ( ((LA19_64>='\u0000' && LA19_64<='\b')||(LA19_64>='\u000B' && LA19_64<='\f')||(LA19_64>='\u000E' && LA19_64<='\u001F')||LA19_64=='!'||(LA19_64>='$' && LA19_64<='\'')||(LA19_64>='*' && LA19_64<='+')||(LA19_64>='-' && LA19_64<='9')||(LA19_64>=';' && LA19_64<='=')||(LA19_64>='?' && LA19_64<='Z')||(LA19_64>='^' && LA19_64<='z')||LA19_64=='|'||(LA19_64>='~' && LA19_64<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 62;}

                        else if ( (LA19_64==':'||LA19_64=='>'||LA19_64=='['||LA19_64==']'||LA19_64=='{'||LA19_64=='}') && ((( isValue() )||( isHead() )))) {s = 63;}

                        else if ( (LA19_64==',') && ((( isValue() )||( isHead() )))) {s = 64;}

                        else s = 60;

                         
                        input.seek(index19_64);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA19_86 = input.LA(1);

                         
                        int index19_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_86>='0' && LA19_86<='9')||(LA19_86>='A' && LA19_86<='F')||(LA19_86>='a' && LA19_86<='f')) ) {s = 97;}

                        else if ( ((LA19_86>='\u0000' && LA19_86<='/')||(LA19_86>=':' && LA19_86<='@')||(LA19_86>='G' && LA19_86<='`')||(LA19_86>='g' && LA19_86<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_86);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA19_100 = input.LA(1);

                         
                        int index19_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_100>='0' && LA19_100<='9')||(LA19_100>='A' && LA19_100<='F')||(LA19_100>='a' && LA19_100<='f')) ) {s = 102;}

                        else if ( ((LA19_100>='\u0000' && LA19_100<='\t')||(LA19_100>='\u000B' && LA19_100<='/')||(LA19_100>=':' && LA19_100<='@')||(LA19_100>='G' && LA19_100<='`')||(LA19_100>='g' && LA19_100<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_100);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA19_20 = input.LA(1);

                         
                        int index19_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_20=='\t'||LA19_20==' ') ) {s = 37;}

                        else if ( (LA19_20=='\n'||LA19_20=='\r'||(LA19_20>='\"' && LA19_20<='#')||(LA19_20>='(' && LA19_20<=')')||LA19_20=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_20>='\u0000' && LA19_20<='\b')||(LA19_20>='\u000B' && LA19_20<='\f')||(LA19_20>='\u000E' && LA19_20<='\u001F')||LA19_20=='!'||(LA19_20>='$' && LA19_20<='\'')||(LA19_20>='*' && LA19_20<='+')||(LA19_20>='-' && LA19_20<='9')||(LA19_20>=';' && LA19_20<='=')||(LA19_20>='?' && LA19_20<='Z')||(LA19_20>='^' && LA19_20<='z')||LA19_20=='|'||(LA19_20>='~' && LA19_20<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_20==':'||LA19_20=='>'||LA19_20=='['||LA19_20==']'||LA19_20=='{'||LA19_20=='}') ) {s = 40;}

                        else if ( (LA19_20==',') ) {s = 41;}

                        else s = 54;

                         
                        input.seek(index19_20);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA19_51 = input.LA(1);

                         
                        int index19_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_51=='\"') ) {s = 75;}

                        else if ( (LA19_51=='\r') && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_51>='\u0000' && LA19_51<='\t')||(LA19_51>='\u000B' && LA19_51<='\f')||(LA19_51>='\u000E' && LA19_51<='!')||(LA19_51>='#' && LA19_51<='[')||(LA19_51>=']' && LA19_51<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_51=='\\') ) {s = 77;}

                         
                        input.seek(index19_51);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA19_67 = input.LA(1);

                         
                        int index19_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_67=='\t'||LA19_67==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( ((LA19_67>='\u0000' && LA19_67<='\b')||(LA19_67>='\u000B' && LA19_67<='\f')||(LA19_67>='\u000E' && LA19_67<='\u001F')||LA19_67=='!'||(LA19_67>='$' && LA19_67<='\'')||(LA19_67>='*' && LA19_67<='+')||(LA19_67>='-' && LA19_67<='9')||(LA19_67>=';' && LA19_67<='=')||(LA19_67>='?' && LA19_67<='Z')||(LA19_67>='^' && LA19_67<='z')||LA19_67=='|'||(LA19_67>='~' && LA19_67<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( (LA19_67==':'||LA19_67=='>'||LA19_67=='['||LA19_67==']'||LA19_67=='{'||LA19_67=='}') && ((( isHead() )||( isValue() )))) {s = 67;}

                        else if ( (LA19_67==',') && ((( isValue() )||( isHead() )))) {s = 68;}

                        else if ( (LA19_67=='\r'||(LA19_67>='\"' && LA19_67<='#')||(LA19_67>='(' && LA19_67<=')')||LA19_67=='\\') && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index19_67);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA19_68 = input.LA(1);

                         
                        int index19_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_68=='\r'||(LA19_68>='\"' && LA19_68<='#')||(LA19_68>='(' && LA19_68<=')')||LA19_68=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_68=='\t'||LA19_68==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( ((LA19_68>='\u0000' && LA19_68<='\b')||(LA19_68>='\u000B' && LA19_68<='\f')||(LA19_68>='\u000E' && LA19_68<='\u001F')||LA19_68=='!'||(LA19_68>='$' && LA19_68<='\'')||(LA19_68>='*' && LA19_68<='+')||(LA19_68>='-' && LA19_68<='9')||(LA19_68>=';' && LA19_68<='=')||(LA19_68>='?' && LA19_68<='Z')||(LA19_68>='^' && LA19_68<='z')||LA19_68=='|'||(LA19_68>='~' && LA19_68<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( (LA19_68==':'||LA19_68=='>'||LA19_68=='['||LA19_68==']'||LA19_68=='{'||LA19_68=='}') && ((( isHead() )||( isValue() )))) {s = 67;}

                        else if ( (LA19_68==',') && ((( isValue() )||( isHead() )))) {s = 68;}

                        else s = 60;

                         
                        input.seek(index19_68);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA19_21 = input.LA(1);

                         
                        int index19_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_21>='\u0000' && LA19_21<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 55;

                         
                        input.seek(index19_21);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA19_72 = input.LA(1);

                         
                        int index19_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_72=='\t'||LA19_72==' ') ) {s = 71;}

                        else if ( ((LA19_72>='\u0000' && LA19_72<='\b')||(LA19_72>='\u000B' && LA19_72<='\f')||(LA19_72>='\u000E' && LA19_72<='\u001F')||LA19_72=='!'||(LA19_72>='$' && LA19_72<='\'')||(LA19_72>='*' && LA19_72<='+')||(LA19_72>='-' && LA19_72<='9')||(LA19_72>=';' && LA19_72<='=')||(LA19_72>='?' && LA19_72<='Z')||(LA19_72>='^' && LA19_72<='z')||LA19_72=='|'||(LA19_72>='~' && LA19_72<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_72==':'||LA19_72=='>'||LA19_72=='['||LA19_72==']'||LA19_72=='{'||LA19_72=='}') ) {s = 73;}

                        else if ( (LA19_72==',') ) {s = 74;}

                        else if ( (LA19_72=='\n'||LA19_72=='\r'||(LA19_72>='\"' && LA19_72<='#')||(LA19_72>='(' && LA19_72<=')')||LA19_72=='\\') && (( isHead() ))) {s = 22;}

                        else s = 70;

                         
                        input.seek(index19_72);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA19_12 = input.LA(1);

                         
                        int index19_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_12>='\u0000' && LA19_12<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 36;

                         
                        input.seek(index19_12);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA19_48 = input.LA(1);

                         
                        int index19_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_48=='\t'||LA19_48==' ') ) {s = 71;}

                        else if ( ((LA19_48>='\u0000' && LA19_48<='\b')||(LA19_48>='\u000B' && LA19_48<='\f')||(LA19_48>='\u000E' && LA19_48<='\u001F')||LA19_48=='!'||(LA19_48>='$' && LA19_48<='\'')||(LA19_48>='*' && LA19_48<='+')||(LA19_48>='-' && LA19_48<='9')||(LA19_48>=';' && LA19_48<='=')||(LA19_48>='?' && LA19_48<='Z')||(LA19_48>='^' && LA19_48<='z')||LA19_48=='|'||(LA19_48>='~' && LA19_48<='\uFFFF')) ) {s = 72;}

                        else if ( (LA19_48==':'||LA19_48=='>'||LA19_48=='['||LA19_48==']'||LA19_48=='{'||LA19_48=='}') ) {s = 73;}

                        else if ( (LA19_48==',') ) {s = 74;}

                        else if ( (LA19_48=='\n'||LA19_48=='\r'||(LA19_48>='\"' && LA19_48<='#')||(LA19_48>='(' && LA19_48<=')')||LA19_48=='\\') && (( isHead() ))) {s = 22;}

                        else s = 70;

                         
                        input.seek(index19_48);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA19_78 = input.LA(1);

                         
                        int index19_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_78=='\n'||LA19_78=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_78=='#') ) {s = 51;}

                        else if ( (LA19_78=='\"') ) {s = 53;}

                        else if ( ((LA19_78>='\u0000' && LA19_78<='\t')||(LA19_78>='\u000B' && LA19_78<='\f')||(LA19_78>='\u000E' && LA19_78<='!')||(LA19_78>='$' && LA19_78<='[')||(LA19_78>=']' && LA19_78<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_78=='\\') ) {s = 52;}

                         
                        input.seek(index19_78);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA19_97 = input.LA(1);

                         
                        int index19_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_97>='0' && LA19_97<='9')||(LA19_97>='A' && LA19_97<='F')||(LA19_97>='a' && LA19_97<='f')) ) {s = 99;}

                        else if ( ((LA19_97>='\u0000' && LA19_97<='/')||(LA19_97>=':' && LA19_97<='@')||(LA19_97>='G' && LA19_97<='`')||(LA19_97>='g' && LA19_97<='\uFFFF')) && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_97);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA19_50 = input.LA(1);

                         
                        int index19_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_50=='\n'||LA19_50=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_50=='#') ) {s = 51;}

                        else if ( (LA19_50=='\"') ) {s = 53;}

                        else if ( ((LA19_50>='\u0000' && LA19_50<='\t')||(LA19_50>='\u000B' && LA19_50<='\f')||(LA19_50>='\u000E' && LA19_50<='!')||(LA19_50>='$' && LA19_50<='[')||(LA19_50>=']' && LA19_50<='\uFFFF')) ) {s = 50;}

                        else if ( (LA19_50=='\\') ) {s = 52;}

                         
                        input.seek(index19_50);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA19_37 = input.LA(1);

                         
                        int index19_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_37>='\u0000' && LA19_37<='\b')||(LA19_37>='\u000B' && LA19_37<='\f')||(LA19_37>='\u000E' && LA19_37<='\u001F')||LA19_37=='!'||(LA19_37>='$' && LA19_37<='\'')||(LA19_37>='*' && LA19_37<='+')||(LA19_37>='-' && LA19_37<='9')||(LA19_37>=';' && LA19_37<='=')||(LA19_37>='?' && LA19_37<='Z')||(LA19_37>='^' && LA19_37<='z')||LA19_37=='|'||(LA19_37>='~' && LA19_37<='\uFFFF')) ) {s = 39;}

                        else if ( (LA19_37==':'||LA19_37=='>'||LA19_37=='['||LA19_37==']'||LA19_37=='{'||LA19_37=='}') ) {s = 40;}

                        else if ( (LA19_37==',') ) {s = 41;}

                        else if ( (LA19_37=='\t'||LA19_37==' ') ) {s = 37;}

                        else if ( (LA19_37=='\n'||LA19_37=='\r'||(LA19_37>='\"' && LA19_37<='#')||(LA19_37>='(' && LA19_37<=')')||LA19_37=='\\') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_37);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA19_61 = input.LA(1);

                         
                        int index19_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_61>='\u0000' && LA19_61<='\b')||(LA19_61>='\u000B' && LA19_61<='\f')||(LA19_61>='\u000E' && LA19_61<='\u001F')||LA19_61=='!'||(LA19_61>='$' && LA19_61<='\'')||(LA19_61>='*' && LA19_61<='+')||(LA19_61>='-' && LA19_61<='9')||(LA19_61>=';' && LA19_61<='=')||(LA19_61>='?' && LA19_61<='Z')||(LA19_61>='^' && LA19_61<='z')||LA19_61=='|'||(LA19_61>='~' && LA19_61<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 62;}

                        else if ( (LA19_61==':'||LA19_61=='>'||LA19_61=='['||LA19_61==']'||LA19_61=='{'||LA19_61=='}') && ((( isValue() )||( isHead() )))) {s = 63;}

                        else if ( (LA19_61==',') && ((( isValue() )||( isHead() )))) {s = 64;}

                        else if ( (LA19_61=='\t'||LA19_61==' ') && ((( isValue() )||( isHead() )))) {s = 61;}

                        else if ( (LA19_61=='\n'||LA19_61=='\r'||(LA19_61>='\"' && LA19_61<='#')||(LA19_61>='(' && LA19_61<=')')||LA19_61=='\\') && (( isHead() ))) {s = 22;}

                         
                        input.seek(index19_61);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA19_14 = input.LA(1);

                         
                        int index19_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_14>='\u0000' && LA19_14<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 42;

                         
                        input.seek(index19_14);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA19_104 = input.LA(1);

                         
                        int index19_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_104=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_104=='\"') ) {s = 75;}

                        else if ( ((LA19_104>='\u0000' && LA19_104<='\t')||(LA19_104>='\u000B' && LA19_104<='\f')||(LA19_104>='\u000E' && LA19_104<='!')||(LA19_104>='#' && LA19_104<='[')||(LA19_104>=']' && LA19_104<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_104=='\\') ) {s = 77;}

                         
                        input.seek(index19_104);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA19_66 = input.LA(1);

                         
                        int index19_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_66=='\t'||LA19_66==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( ((LA19_66>='\u0000' && LA19_66<='\b')||(LA19_66>='\u000B' && LA19_66<='\f')||(LA19_66>='\u000E' && LA19_66<='\u001F')||LA19_66=='!'||(LA19_66>='$' && LA19_66<='\'')||(LA19_66>='*' && LA19_66<='+')||(LA19_66>='-' && LA19_66<='9')||(LA19_66>=';' && LA19_66<='=')||(LA19_66>='?' && LA19_66<='Z')||(LA19_66>='^' && LA19_66<='z')||LA19_66=='|'||(LA19_66>='~' && LA19_66<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( (LA19_66==':'||LA19_66=='>'||LA19_66=='['||LA19_66==']'||LA19_66=='{'||LA19_66=='}') && ((( isHead() )||( isValue() )))) {s = 67;}

                        else if ( (LA19_66==',') && ((( isValue() )||( isHead() )))) {s = 68;}

                        else if ( (LA19_66=='\r'||(LA19_66>='\"' && LA19_66<='#')||(LA19_66>='(' && LA19_66<=')')||LA19_66=='\\') && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index19_66);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA19_27 = input.LA(1);

                         
                        int index19_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_27>='\u0000' && LA19_27<='\b')||(LA19_27>='\u000B' && LA19_27<='\f')||(LA19_27>='\u000E' && LA19_27<='\u001F')||(LA19_27>='!' && LA19_27<='\"')||LA19_27=='$'||(LA19_27>='&' && LA19_27<=',')||(LA19_27>='.' && LA19_27<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_27==' ') ) {s = 27;}

                        else if ( (LA19_27=='\n'||LA19_27=='\r') ) {s = 28;}

                        else if ( (LA19_27=='-') ) {s = 6;}

                        else if ( (LA19_27=='\t') ) {s = 29;}

                        else s = 58;

                         
                        input.seek(index19_27);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA19_17 = input.LA(1);

                         
                        int index19_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_17>='\u0000' && LA19_17<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 45;

                         
                        input.seek(index19_17);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA19_92 = input.LA(1);

                         
                        int index19_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_92=='\r') && (( isHead() ))) {s = 22;}

                        else if ( (LA19_92=='\"') ) {s = 75;}

                        else if ( ((LA19_92>='\u0000' && LA19_92<='\t')||(LA19_92>='\u000B' && LA19_92<='\f')||(LA19_92>='\u000E' && LA19_92<='!')||(LA19_92>='#' && LA19_92<='[')||(LA19_92>=']' && LA19_92<='\uFFFF')) ) {s = 76;}

                        else if ( (LA19_92=='\\') ) {s = 77;}

                         
                        input.seek(index19_92);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA19_53 = input.LA(1);

                         
                        int index19_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_53>='\u0000' && LA19_53<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 87;

                         
                        input.seek(index19_53);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA19_102 = input.LA(1);

                         
                        int index19_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_102>='\u0000' && LA19_102<='\t')||(LA19_102>='\u000B' && LA19_102<='/')||(LA19_102>=':' && LA19_102<='@')||(LA19_102>='G' && LA19_102<='`')||(LA19_102>='g' && LA19_102<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( ((LA19_102>='0' && LA19_102<='9')||(LA19_102>='A' && LA19_102<='F')||(LA19_102>='a' && LA19_102<='f')) ) {s = 104;}

                         
                        input.seek(index19_102);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA19_29 = input.LA(1);

                         
                        int index19_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_29>='\u0000' && LA19_29<='\b')||(LA19_29>='\u000B' && LA19_29<='\f')||(LA19_29>='\u000E' && LA19_29<='\u001F')||(LA19_29>='!' && LA19_29<='\"')||LA19_29=='$'||(LA19_29>='&' && LA19_29<=',')||(LA19_29>='.' && LA19_29<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA19_29=='\t'||LA19_29==' ') ) {s = 29;}

                        else if ( (LA19_29=='\n'||LA19_29=='\r') ) {s = 28;}

                        else s = 58;

                         
                        input.seek(index19_29);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-02-16 16:30:51

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
    public static final int PlainUnsafeChar=50;
    public static final int PlainSafeKey=51;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=34;
    public static final int Digit=37;
    public static final int NodeIndent=19;
    public static final int HexDigit=39;
    public static final int PlainOneLine=55;
    public static final int Plus=33;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int FlowIndicator=49;
    public static final int Separation=57;
    public static final int Letter=38;
    public static final int PlainSafeIn=52;
    public static final int Comma=27;
    public static final int TabSeq=30;
    public static final int EscapeSequence=41;
    public static final int NonSpaceChar=43;
    public static final int DataLine=24;
    public static final int PlainFirst=47;
    public static final int WhiteSpace=21;
    public static final int PlainSafeOut=53;
    public static final int JSON=56;
    public static final int Question=36;
    public static final int LineComment=15;
    public static final int Colon=28;
    public static final int At=32;
    public static final int DataLineBody=23;
    public static final int KeyValuePair=13;
    public static final int Star=31;
    public static final int Preamble=16;
    public static final int Seq=29;
    public static final int FunctionIndent=20;
    public static final int Indicator=46;
    public static final int RParen=26;
    public static final int UnicodeChar=40;
    public static final int StringChar=42;
    public static final int BlankLine=22;
    public static final int Silk=4;
    public static final int LineBreak=18;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=25;
    public static final int String=45;
    public static final int LineBreakChar=17;
    public static final int ScopeIndicator=48;
    public static final int EOF=-1;
    public static final int StringChar_s=44;
    public static final int Value=8;
    public static final int RBracket=35;
    public static final int PlainSafe=54;


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
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:12: ( '#' (~ ( '\\n' | '\\r' ) )* '\\r' '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:14: '#' (~ ( '\\n' | '\\r' ) )* '\\r' '\\n'
            {
            match('#'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:18: ~ ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:9: ( '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:11: '%' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('%'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:15: ~ ( '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:29: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:29: '\\r'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:137:23: ( '\\n' | '\\r' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:4: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:140:24: '\\n'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:11: ({...}? ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:13: {...}? ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:27: ( ' ' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:28: ' '
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

    // $ANTLR start "FunctionIndent"
    public final void mFunctionIndent() throws RecognitionException {
        try {
            int _type = FunctionIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:15: ({...}? => ( ' ' )* '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:34: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('@'); 
             transit(Symbol.NodeStart); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FunctionIndent"

    // $ANTLR start "BlankLine"
    public final void mBlankLine() throws RecognitionException {
        try {
            int _type = BlankLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:10: ({...}? ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:12: {...}? ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:26: ( WhiteSpace )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:26: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:78: (~ ( '#' | '\\n' | '\\r' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\"')||(LA8_0>='$' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:78: ~ ( '#' | '\\n' | '\\r' )
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
            	    break loop8;
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:150:11: {...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment )
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:5: ( WhiteSpace )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            int DataLineBody1Start229 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start229, getCharIndex()-1);
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:30: ( LineBreak | LineComment )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            else if ( (LA10_0=='#') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:31: LineBreak
                    {
                    mLineBreak(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:41: LineComment
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:9: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:8: ':'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:4: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:7: '>'
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

    // $ANTLR start "TabSeq"
    public final void mTabSeq() throws RecognitionException {
        try {
            int _type = TabSeq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:7: ( '|' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TabSeq"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:8: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:6: '@'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:7: '+'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:18: ( Digit | Letter )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:21: ( UnicodeChar | EscapeSequence )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:38: EscapeSequence
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:22: ( ( StringChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:24: ( StringChar )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:24: ( StringChar )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop13;
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:7: ( '\"' s= StringChar_s '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart523 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart523, getCharIndex()-1);
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | {...}? => ( ':' | '?' ) NonSpaceChar )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='?') ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>='\u0000' && LA14_1<='\b')||(LA14_1>='\u000B' && LA14_1<='\f')||(LA14_1>='\u000E' && LA14_1<='\u001F')||LA14_1=='!'||(LA14_1>='#' && LA14_1<='[')||(LA14_1>=']' && LA14_1<='\uFFFF')) && (( isValue() ))) {
                    alt14=2;
                }
                else {
                    alt14=1;}
            }
            else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||LA14_0=='$'||LA14_0=='&'||(LA14_0>='*' && LA14_0<='+')||(LA14_0>='.' && LA14_0<='9')||(LA14_0>=';' && LA14_0<='=')||(LA14_0>='A' && LA14_0<='Z')||(LA14_0>='^' && LA14_0<='z')||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {
                alt14=1;
            }
            else if ( (LA14_0==':') && (( isValue() ))) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:4: {...}? => ( ':' | '?' ) NonSpaceChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:24: ( '(' | ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:23: ( '[' | ']' | '{' | '}' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:19: ( FlowIndicator | ScopeIndicator | ',' | '-' | ':' | '#' | '>' | '|' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<=')')||(input.LA(1)>=',' && input.LA(1)<='-')||input.LA(1)==':'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:25: ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | '#' | ScopeIndicator )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:22: (~ ( PlainUnsafeChar | FlowIndicator | ',' | ':' | '>' | '*' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:24: ~ ( PlainUnsafeChar | FlowIndicator | ',' | ':' | '>' | '*' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='\'')||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:21: (~ ( PlainUnsafeChar | ',' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:23: ~ ( PlainUnsafeChar | ',' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:22: (~ ( PlainUnsafeChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:24: ~ ( PlainUnsafeChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='$' && LA15_0<='\'')||LA15_0=='+'||(LA15_0>='-' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='=')||(LA15_0>='?' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA15_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt15=1;
                }
                else if ( (( isInValue() )) ) {
                    alt15=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA15_0=='*'||LA15_0==':'||LA15_0=='>'||LA15_0=='['||LA15_0==']'||LA15_0=='{'||LA15_0=='}') && ((( isInValue() )||( isOutValue() )))) {
                int LA15_2 = input.LA(2);

                if ( (( isInValue() )) ) {
                    alt15=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA15_0==',') && (( isOutValue() ))) {
                alt15=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:4: {...}? => PlainSafeOut
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:13: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:15: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:26: ( ( WhiteSpace )* PlainSafe )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\t'||LA17_0==' ') ) {
                    alt17=1;
                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||(LA17_0>='$' && LA17_0<='\'')||LA17_0=='+'||(LA17_0>='-' && LA17_0<='9')||(LA17_0>=';' && LA17_0<='=')||(LA17_0>='?' && LA17_0<='Z')||(LA17_0>='^' && LA17_0<='z')||LA17_0=='|'||(LA17_0>='~' && LA17_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt17=1;
                }
                else if ( (LA17_0=='*'||LA17_0==':'||LA17_0=='>'||LA17_0=='['||LA17_0==']'||LA17_0=='{'||LA17_0=='}') && ((( isInValue() )||( isOutValue() )))) {
                    alt17=1;
                }
                else if ( (LA17_0==',') && (( isOutValue() ))) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:27: ( WhiteSpace )* PlainSafe
            	    {
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:27: ( WhiteSpace )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0=='\t'||LA16_0==' ') ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:27: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);

            	    mPlainSafe(); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:2: ({...}? => '{' | {...}? => '[' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='{') && (( isValue() ))) {
                alt18=1;
            }
            else if ( (LA18_0=='[') && (( isValue() ))) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:4: {...}? => '{'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:4: {...}? => '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:11: ({...}? ( WhiteSpace )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:13: {...}? ( WhiteSpace )+
            {
            if ( !(( currentState() != State.INIT )) ) {
                throw new FailedPredicateException(input, "Separation", " currentState() != State.INIT ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:47: ( WhiteSpace )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:47: WhiteSpace
            	    {
            	    mWhiteSpace(); 

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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:2: ( ( ' ' | '\\t' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:4: ( ' ' | '\\t' )
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
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace )
        int alt20=24;
        alt20 = dfa20.predict(input);
        switch (alt20) {
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
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:31: LineBreak
                {
                mLineBreak(); 

                }
                break;
            case 4 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:41: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 5 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:52: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 6 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:67: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 7 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:77: DataLine
                {
                mDataLine(); 

                }
                break;
            case 8 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:86: LParen
                {
                mLParen(); 

                }
                break;
            case 9 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:93: RParen
                {
                mRParen(); 

                }
                break;
            case 10 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:100: Comma
                {
                mComma(); 

                }
                break;
            case 11 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:106: Colon
                {
                mColon(); 

                }
                break;
            case 12 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:112: Seq
                {
                mSeq(); 

                }
                break;
            case 13 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:116: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 14 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:123: Star
                {
                mStar(); 

                }
                break;
            case 15 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:128: At
                {
                mAt(); 

                }
                break;
            case 16 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:131: Plus
                {
                mPlus(); 

                }
                break;
            case 17 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:136: LBracket
                {
                mLBracket(); 

                }
                break;
            case 18 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:145: RBracket
                {
                mRBracket(); 

                }
                break;
            case 19 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:154: Question
                {
                mQuestion(); 

                }
                break;
            case 20 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:163: String
                {
                mString(); 

                }
                break;
            case 21 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:170: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 22 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:183: JSON
                {
                mJSON(); 

                }
                break;
            case 23 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:188: Separation
                {
                mSeparation(); 

                }
                break;
            case 24 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:199: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\3\uffff\1\31\1\32\1\34\1\uffff\1\40\1\34\1\41\1\42\1\43\1\45\1"+
        "\47\1\50\1\51\1\56\1\57\1\60\1\62\1\uffff\1\71\1\72\1\uffff\1\73"+
        "\2\uffff\1\75\2\uffff\1\75\5\uffff\1\100\1\uffff\1\100\4\uffff\3"+
        "\71\3\uffff\1\112\1\uffff\2\112\2\uffff\1\130\12\uffff\3\100\1\uffff"+
        "\3\100\3\uffff\3\112\12\uffff\1\130\23\uffff";
    static final String DFA20_eofS =
        "\155\uffff";
    static final String DFA20_minS =
        "\1\0\2\uffff\1\12\2\0\1\uffff\20\0\1\uffff\5\0\1\uffff\1\0\1\uffff"+
        "\1\0\3\uffff\1\0\1\uffff\1\0\3\uffff\4\0\1\uffff\1\0\1\uffff\1\0"+
        "\1\uffff\6\0\2\uffff\1\0\5\uffff\10\0\2\uffff\15\0\1\uffff\24\0";
    static final String DFA20_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\uffff\1\uffff\1\0\17\uffff\1\uffff"+
        "\3\0\1\uffff\1\0\1\uffff\1\uffff\1\uffff\1\0\3\uffff\1\uffff\1\uffff"+
        "\1\uffff\3\uffff\4\uffff\1\uffff\1\0\1\uffff\1\uffff\1\uffff\6\uffff"+
        "\2\uffff\1\0\5\uffff\10\uffff\2\uffff\15\uffff\1\uffff\24\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\4\20\uffff\1\7\5\uffff\1\6\1\uffff\1"+
        "\5\1\uffff\1\10\1\11\1\12\1\uffff\1\13\1\uffff\1\14\1\15\1\16\4"+
        "\uffff\1\20\1\uffff\1\22\1\uffff\1\23\6\uffff\1\25\1\26\1\uffff"+
        "\1\3\1\27\1\30\1\17\1\25\10\uffff\1\21\1\25\15\uffff\1\24\24\uffff";
    static final String DFA20_specialS =
        "\1\111\4\uffff\1\61\2\uffff\1\100\1\16\1\107\1\25\1\43\1\112\1"+
        "\31\1\3\1\65\1\52\1\50\1\74\1\13\1\35\1\62\2\uffff\1\77\1\76\1\2"+
        "\1\47\1\uffff\1\71\1\uffff\1\27\3\uffff\1\103\1\uffff\1\30\3\uffff"+
        "\1\55\1\44\1\6\1\36\1\uffff\1\63\1\uffff\1\5\1\uffff\1\51\1\22\1"+
        "\70\1\40\1\23\1\46\2\uffff\1\101\5\uffff\1\56\1\45\1\7\1\37\1\54"+
        "\1\116\1\60\1\34\2\uffff\1\72\1\102\1\75\1\33\1\41\1\53\1\113\1"+
        "\24\1\0\1\10\1\21\1\115\1\4\1\uffff\1\17\1\57\1\106\1\32\1\66\1"+
        "\20\1\1\1\104\1\110\1\114\1\73\1\11\1\14\1\26\1\15\1\64\1\42\1\67"+
        "\1\105\1\12}>";
    static final String[] DFA20_transitionS = {
            "\11\25\1\10\1\4\2\25\1\3\22\25\1\5\1\25\1\24\1\1\1\25\1\2\1"+
            "\25\1\27\1\11\1\12\1\17\1\20\1\13\1\6\14\25\1\14\3\25\1\15\1"+
            "\23\1\7\32\25\1\21\1\27\1\22\35\25\1\26\1\16\1\27\uff82\25",
            "",
            "",
            "\1\30",
            "\1\uffff",
            "\11\27\1\36\1\35\2\27\1\35\22\27\1\33\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\6\22\27\1\37\uffbf\27",
            "",
            "\1\uffff",
            "\11\27\1\36\1\35\2\27\1\35\22\27\1\36\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\44\2\27\2\44\1\27\22\44\1\27\1\44\1\27\1\46\70\44\1\27"+
            "\uffa3\44",
            "\0\27",
            "\0\27",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\0\27",
            "\0\27",
            "\11\61\1\52\1\27\2\61\1\27\22\61\1\52\1\61\1\27\1\46\4\61"+
            "\2\44\1\63\1\61\1\64\15\61\1\63\3\61\1\63\34\61\1\63\1\27\1"+
            "\63\35\61\1\63\1\61\1\63\uff82\61",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\0\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\11\27\1\36\1\35\2\27\1\35\22\27\1\33\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\6\22\27\1\37\uffbf\27",
            "\1\uffff",
            "",
            "\11\27\1\36\1\35\2\27\1\35\22\27\1\36\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\11\102\1\101\1\27\2\102\1\27\22\102\1\101\1\102\2\27\4\102"+
            "\2\27\1\103\1\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\27\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "",
            "\11\106\1\105\1\uffff\2\106\1\27\22\106\1\105\1\106\2\27\4"+
            "\106\2\27\1\107\1\106\1\110\15\106\1\107\3\106\1\107\34\106"+
            "\1\107\1\27\1\107\35\106\1\107\1\106\1\107\uff82\106",
            "",
            "",
            "",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "\11\53\1\52\1\27\2\53\1\27\22\53\1\52\1\53\2\27\4\53\2\27"+
            "\1\54\1\53\1\55\15\53\1\54\3\53\1\54\34\53\1\54\1\27\1\54\35"+
            "\53\1\54\1\53\1\54\uff82\53",
            "",
            "\1\uffff",
            "",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\42\27\1\117\14\27\1\121\54\27\1\120\5\27\1\122\3\27\1\123"+
            "\7\27\1\124\3\27\1\125\1\27\1\126\1\127\uff8a\27",
            "\0\27",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\11\102\1\101\1\27\2\102\1\27\22\102\1\101\1\102\2\27\4\102"+
            "\2\27\1\103\1\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\27\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\27\2\102\1\27\22\102\1\101\1\102\2\27\4\102"+
            "\2\27\1\103\1\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\27\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\27\2\102\1\27\22\102\1\101\1\102\2\27\4\102"+
            "\2\27\1\103\1\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\27\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\102\1\101\1\27\2\102\1\27\22\102\1\101\1\102\2\27\4\102"+
            "\2\27\1\103\1\102\1\104\15\102\1\103\3\102\1\103\34\102\1\103"+
            "\1\27\1\103\35\102\1\103\1\102\1\103\uff82\102",
            "\11\106\1\105\1\uffff\2\106\1\27\22\106\1\105\1\106\2\27\4"+
            "\106\2\27\1\107\1\106\1\110\15\106\1\107\3\106\1\107\34\106"+
            "\1\107\1\27\1\107\35\106\1\107\1\106\1\107\uff82\106",
            "\11\106\1\105\1\uffff\2\106\1\27\22\106\1\105\1\106\2\27\4"+
            "\106\2\27\1\107\1\106\1\110\15\106\1\107\3\106\1\107\34\106"+
            "\1\107\1\27\1\107\35\106\1\107\1\106\1\107\uff82\106",
            "\11\106\1\105\1\uffff\2\106\1\27\22\106\1\105\1\106\2\27\4"+
            "\106\2\27\1\107\1\106\1\110\15\106\1\107\3\106\1\107\34\106"+
            "\1\107\1\27\1\107\35\106\1\107\1\106\1\107\uff82\106",
            "\11\106\1\105\1\uffff\2\106\1\27\22\106\1\105\1\106\2\27\4"+
            "\106\2\27\1\107\1\106\1\110\15\106\1\107\3\106\1\107\34\106"+
            "\1\107\1\27\1\107\35\106\1\107\1\106\1\107\uff82\106",
            "",
            "",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\27\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\1\115\1\114\1\115\uff82\114",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\60\27\12\134\7\27\6\134\32\27\6\134\uff99\27",
            "",
            "\12\27\1\uffff\ufff5\27",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\27\1\uffff\27\27\1\135\14\27\1\137\54\27\1\136\5\27\1"+
            "\140\3\27\1\141\7\27\1\142\3\27\1\143\1\27\1\144\1\145\uff8a"+
            "\27",
            "\60\27\12\146\7\27\6\146\32\27\6\146\uff99\27",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132",
            "\12\27\1\uffff\45\27\12\147\7\27\6\147\32\27\6\147\uff99\27",
            "\60\27\12\150\7\27\6\150\32\27\6\150\uff99\27",
            "\12\27\1\uffff\45\27\12\151\7\27\6\151\32\27\6\151\uff99\27",
            "\60\27\12\152\7\27\6\152\32\27\6\152\uff99\27",
            "\12\27\1\uffff\45\27\12\153\7\27\6\153\32\27\6\153\uff99\27",
            "\12\65\1\27\2\65\1\27\24\65\1\67\1\70\70\65\1\66\uffa3\65",
            "\12\27\1\uffff\45\27\12\154\7\27\6\154\32\27\6\154\uff99\27",
            "\12\132\1\uffff\2\132\1\27\24\132\1\131\71\132\1\133\uffa3"+
            "\132"
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_83 = input.LA(1);

                         
                        int index20_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_83=='\"') ) {s = 55;}

                        else if ( (LA20_83=='#') ) {s = 56;}

                        else if ( (LA20_83=='\\') ) {s = 54;}

                        else if ( (LA20_83=='\n'||LA20_83=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_83>='\u0000' && LA20_83<='\t')||(LA20_83>='\u000B' && LA20_83<='\f')||(LA20_83>='\u000E' && LA20_83<='!')||(LA20_83>='$' && LA20_83<='[')||(LA20_83>=']' && LA20_83<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_83);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_95 = input.LA(1);

                         
                        int index20_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_95=='\"') ) {s = 89;}

                        else if ( ((LA20_95>='\u0000' && LA20_95<='\t')||(LA20_95>='\u000B' && LA20_95<='\f')||(LA20_95>='\u000E' && LA20_95<='!')||(LA20_95>='#' && LA20_95<='[')||(LA20_95>=']' && LA20_95<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_95=='\\') ) {s = 91;}

                        else if ( (LA20_95=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_95);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_27 = input.LA(1);

                         
                        int index20_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_27=='-') ) {s = 6;}

                        else if ( (LA20_27==' ') ) {s = 27;}

                        else if ( (LA20_27=='\n'||LA20_27=='\r') ) {s = 29;}

                        else if ( (LA20_27=='\t') ) {s = 30;}

                        else if ( (LA20_27=='@') && (( isHead() ))) {s = 31;}

                        else if ( ((LA20_27>='\u0000' && LA20_27<='\b')||(LA20_27>='\u000B' && LA20_27<='\f')||(LA20_27>='\u000E' && LA20_27<='\u001F')||(LA20_27>='!' && LA20_27<='\"')||LA20_27=='$'||(LA20_27>='&' && LA20_27<=',')||(LA20_27>='.' && LA20_27<='?')||(LA20_27>='A' && LA20_27<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index20_27);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_15 = input.LA(1);

                         
                        int index20_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_15=='\t'||LA20_15==' ') ) {s = 42;}

                        else if ( ((LA20_15>='\u0000' && LA20_15<='\b')||(LA20_15>='\u000B' && LA20_15<='\f')||(LA20_15>='\u000E' && LA20_15<='\u001F')||LA20_15=='!'||(LA20_15>='$' && LA20_15<='\'')||LA20_15=='+'||(LA20_15>='-' && LA20_15<='9')||(LA20_15>=';' && LA20_15<='=')||(LA20_15>='?' && LA20_15<='Z')||(LA20_15>='^' && LA20_15<='z')||LA20_15=='|'||(LA20_15>='~' && LA20_15<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_15=='*'||LA20_15==':'||LA20_15=='>'||LA20_15=='['||LA20_15==']'||LA20_15=='{'||LA20_15=='}') ) {s = 44;}

                        else if ( (LA20_15==',') ) {s = 45;}

                        else if ( (LA20_15=='\n'||LA20_15=='\r'||(LA20_15>='\"' && LA20_15<='#')||(LA20_15>='(' && LA20_15<=')')||LA20_15=='\\') && (( isHead() ))) {s = 23;}

                        else s = 41;

                         
                        input.seek(index20_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_87 = input.LA(1);

                         
                        int index20_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_87>='0' && LA20_87<='9')||(LA20_87>='A' && LA20_87<='F')||(LA20_87>='a' && LA20_87<='f')) ) {s = 92;}

                        else if ( ((LA20_87>='\u0000' && LA20_87<='/')||(LA20_87>=':' && LA20_87<='@')||(LA20_87>='G' && LA20_87<='`')||(LA20_87>='g' && LA20_87<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_87);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_49 = input.LA(1);

                         
                        int index20_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_49=='\t'||LA20_49==' ') ) {s = 75;}

                        else if ( ((LA20_49>='\u0000' && LA20_49<='\b')||(LA20_49>='\u000B' && LA20_49<='\f')||(LA20_49>='\u000E' && LA20_49<='\u001F')||LA20_49=='!'||(LA20_49>='$' && LA20_49<='\'')||LA20_49=='+'||(LA20_49>='-' && LA20_49<='9')||(LA20_49>=';' && LA20_49<='=')||(LA20_49>='?' && LA20_49<='Z')||(LA20_49>='^' && LA20_49<='z')||LA20_49=='|'||(LA20_49>='~' && LA20_49<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_49=='*'||LA20_49==':'||LA20_49=='>'||LA20_49=='['||LA20_49==']'||LA20_49=='{'||LA20_49=='}') ) {s = 77;}

                        else if ( (LA20_49==',') ) {s = 78;}

                        else if ( (LA20_49=='\n'||LA20_49=='\r'||(LA20_49>='\"' && LA20_49<='#')||(LA20_49>='(' && LA20_49<=')')||LA20_49=='\\') && (( isHead() ))) {s = 23;}

                        else s = 74;

                         
                        input.seek(index20_49);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_44 = input.LA(1);

                         
                        int index20_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_44=='\t'||LA20_44==' ') ) {s = 42;}

                        else if ( ((LA20_44>='\u0000' && LA20_44<='\b')||(LA20_44>='\u000B' && LA20_44<='\f')||(LA20_44>='\u000E' && LA20_44<='\u001F')||LA20_44=='!'||(LA20_44>='$' && LA20_44<='\'')||LA20_44=='+'||(LA20_44>='-' && LA20_44<='9')||(LA20_44>=';' && LA20_44<='=')||(LA20_44>='?' && LA20_44<='Z')||(LA20_44>='^' && LA20_44<='z')||LA20_44=='|'||(LA20_44>='~' && LA20_44<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_44=='*'||LA20_44==':'||LA20_44=='>'||LA20_44=='['||LA20_44==']'||LA20_44=='{'||LA20_44=='}') ) {s = 44;}

                        else if ( (LA20_44==',') ) {s = 45;}

                        else if ( (LA20_44=='\n'||LA20_44=='\r'||(LA20_44>='\"' && LA20_44<='#')||(LA20_44>='(' && LA20_44<=')')||LA20_44=='\\') && (( isHead() ))) {s = 23;}

                        else s = 57;

                         
                        input.seek(index20_44);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_67 = input.LA(1);

                         
                        int index20_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_67=='\t'||LA20_67==' ') && ((( isHead() )||( isValue() )))) {s = 65;}

                        else if ( ((LA20_67>='\u0000' && LA20_67<='\b')||(LA20_67>='\u000B' && LA20_67<='\f')||(LA20_67>='\u000E' && LA20_67<='\u001F')||LA20_67=='!'||(LA20_67>='$' && LA20_67<='\'')||LA20_67=='+'||(LA20_67>='-' && LA20_67<='9')||(LA20_67>=';' && LA20_67<='=')||(LA20_67>='?' && LA20_67<='Z')||(LA20_67>='^' && LA20_67<='z')||LA20_67=='|'||(LA20_67>='~' && LA20_67<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 66;}

                        else if ( (LA20_67=='*'||LA20_67==':'||LA20_67=='>'||LA20_67=='['||LA20_67==']'||LA20_67=='{'||LA20_67=='}') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA20_67==',') && ((( isHead() )||( isValue() )))) {s = 68;}

                        else if ( (LA20_67=='\n'||LA20_67=='\r'||(LA20_67>='\"' && LA20_67<='#')||(LA20_67>='(' && LA20_67<=')')||LA20_67=='\\') && (( isHead() ))) {s = 23;}

                        else s = 64;

                         
                        input.seek(index20_67);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_84 = input.LA(1);

                         
                        int index20_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_84=='\"') ) {s = 55;}

                        else if ( (LA20_84=='#') ) {s = 56;}

                        else if ( (LA20_84=='\\') ) {s = 54;}

                        else if ( (LA20_84=='\n'||LA20_84=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_84>='\u0000' && LA20_84<='\t')||(LA20_84>='\u000B' && LA20_84<='\f')||(LA20_84>='\u000E' && LA20_84<='!')||(LA20_84>='$' && LA20_84<='[')||(LA20_84>=']' && LA20_84<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_84);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_100 = input.LA(1);

                         
                        int index20_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_100=='\"') ) {s = 89;}

                        else if ( ((LA20_100>='\u0000' && LA20_100<='\t')||(LA20_100>='\u000B' && LA20_100<='\f')||(LA20_100>='\u000E' && LA20_100<='!')||(LA20_100>='#' && LA20_100<='[')||(LA20_100>=']' && LA20_100<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_100=='\\') ) {s = 91;}

                        else if ( (LA20_100=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_100);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_108 = input.LA(1);

                         
                        int index20_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_108=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_108=='\"') ) {s = 89;}

                        else if ( ((LA20_108>='\u0000' && LA20_108<='\t')||(LA20_108>='\u000B' && LA20_108<='\f')||(LA20_108>='\u000E' && LA20_108<='!')||(LA20_108>='#' && LA20_108<='[')||(LA20_108>=']' && LA20_108<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_108=='\\') ) {s = 91;}

                         
                        input.seek(index20_108);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_20 = input.LA(1);

                         
                        int index20_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_20>='\u0000' && LA20_20<='\t')||(LA20_20>='\u000B' && LA20_20<='\f')||(LA20_20>='\u000E' && LA20_20<='!')||(LA20_20>='$' && LA20_20<='[')||(LA20_20>=']' && LA20_20<='\uFFFF')) ) {s = 53;}

                        else if ( (LA20_20=='\\') ) {s = 54;}

                        else if ( (LA20_20=='\"') ) {s = 55;}

                        else if ( (LA20_20=='#') ) {s = 56;}

                        else if ( (LA20_20=='\n'||LA20_20=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_20);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_101 = input.LA(1);

                         
                        int index20_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_101>='0' && LA20_101<='9')||(LA20_101>='A' && LA20_101<='F')||(LA20_101>='a' && LA20_101<='f')) ) {s = 103;}

                        else if ( ((LA20_101>='\u0000' && LA20_101<='\t')||(LA20_101>='\u000B' && LA20_101<='/')||(LA20_101>=':' && LA20_101<='@')||(LA20_101>='G' && LA20_101<='`')||(LA20_101>='g' && LA20_101<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_101);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_103 = input.LA(1);

                         
                        int index20_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_103>='0' && LA20_103<='9')||(LA20_103>='A' && LA20_103<='F')||(LA20_103>='a' && LA20_103<='f')) ) {s = 105;}

                        else if ( ((LA20_103>='\u0000' && LA20_103<='\t')||(LA20_103>='\u000B' && LA20_103<='/')||(LA20_103>=':' && LA20_103<='@')||(LA20_103>='G' && LA20_103<='`')||(LA20_103>='g' && LA20_103<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_103);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_9 = input.LA(1);

                         
                        int index20_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_9>='\u0000' && LA20_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 33;

                         
                        input.seek(index20_9);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_89 = input.LA(1);

                         
                        int index20_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_89>='\u0000' && LA20_89<='\t')||(LA20_89>='\u000B' && LA20_89<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 88;

                         
                        input.seek(index20_89);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_94 = input.LA(1);

                         
                        int index20_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_94=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_94=='\"') ) {s = 89;}

                        else if ( ((LA20_94>='\u0000' && LA20_94<='\t')||(LA20_94>='\u000B' && LA20_94<='\f')||(LA20_94>='\u000E' && LA20_94<='!')||(LA20_94>='#' && LA20_94<='[')||(LA20_94>=']' && LA20_94<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_94=='\\') ) {s = 91;}

                         
                        input.seek(index20_94);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA20_85 = input.LA(1);

                         
                        int index20_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_85=='\n'||LA20_85=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_85=='#') ) {s = 56;}

                        else if ( (LA20_85=='\"') ) {s = 55;}

                        else if ( ((LA20_85>='\u0000' && LA20_85<='\t')||(LA20_85>='\u000B' && LA20_85<='\f')||(LA20_85>='\u000E' && LA20_85<='!')||(LA20_85>='$' && LA20_85<='[')||(LA20_85>=']' && LA20_85<='\uFFFF')) ) {s = 53;}

                        else if ( (LA20_85=='\\') ) {s = 54;}

                         
                        input.seek(index20_85);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA20_52 = input.LA(1);

                         
                        int index20_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_52=='\n'||LA20_52=='\r'||(LA20_52>='\"' && LA20_52<='#')||(LA20_52>='(' && LA20_52<=')')||LA20_52=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_52=='\t'||LA20_52==' ') ) {s = 75;}

                        else if ( ((LA20_52>='\u0000' && LA20_52<='\b')||(LA20_52>='\u000B' && LA20_52<='\f')||(LA20_52>='\u000E' && LA20_52<='\u001F')||LA20_52=='!'||(LA20_52>='$' && LA20_52<='\'')||LA20_52=='+'||(LA20_52>='-' && LA20_52<='9')||(LA20_52>=';' && LA20_52<='=')||(LA20_52>='?' && LA20_52<='Z')||(LA20_52>='^' && LA20_52<='z')||LA20_52=='|'||(LA20_52>='~' && LA20_52<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_52=='*'||LA20_52==':'||LA20_52=='>'||LA20_52=='['||LA20_52==']'||LA20_52=='{'||LA20_52=='}') ) {s = 77;}

                        else if ( (LA20_52==',') ) {s = 78;}

                        else s = 74;

                         
                        input.seek(index20_52);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA20_55 = input.LA(1);

                         
                        int index20_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_55>='\u0000' && LA20_55<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 88;

                         
                        input.seek(index20_55);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA20_82 = input.LA(1);

                         
                        int index20_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_82=='\"') ) {s = 55;}

                        else if ( (LA20_82=='#') ) {s = 56;}

                        else if ( (LA20_82=='\\') ) {s = 54;}

                        else if ( (LA20_82=='\n'||LA20_82=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_82>='\u0000' && LA20_82<='\t')||(LA20_82>='\u000B' && LA20_82<='\f')||(LA20_82>='\u000E' && LA20_82<='!')||(LA20_82>='$' && LA20_82<='[')||(LA20_82>=']' && LA20_82<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_82);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA20_11 = input.LA(1);

                         
                        int index20_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_11>='\u0000' && LA20_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 35;

                         
                        input.seek(index20_11);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA20_102 = input.LA(1);

                         
                        int index20_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_102>='0' && LA20_102<='9')||(LA20_102>='A' && LA20_102<='F')||(LA20_102>='a' && LA20_102<='f')) ) {s = 104;}

                        else if ( ((LA20_102>='\u0000' && LA20_102<='/')||(LA20_102>=':' && LA20_102<='@')||(LA20_102>='G' && LA20_102<='`')||(LA20_102>='g' && LA20_102<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_102);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA20_32 = input.LA(1);

                         
                        int index20_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 31;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index20_32);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA20_38 = input.LA(1);

                         
                        int index20_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_38=='\t'||LA20_38==' ') && ((( isHead() )||( isValue() )))) {s = 69;}

                        else if ( ((LA20_38>='\u0000' && LA20_38<='\b')||(LA20_38>='\u000B' && LA20_38<='\f')||(LA20_38>='\u000E' && LA20_38<='\u001F')||LA20_38=='!'||(LA20_38>='$' && LA20_38<='\'')||LA20_38=='+'||(LA20_38>='-' && LA20_38<='9')||(LA20_38>=';' && LA20_38<='=')||(LA20_38>='?' && LA20_38<='Z')||(LA20_38>='^' && LA20_38<='z')||LA20_38=='|'||(LA20_38>='~' && LA20_38<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 70;}

                        else if ( (LA20_38=='*'||LA20_38==':'||LA20_38=='>'||LA20_38=='['||LA20_38==']'||LA20_38=='{'||LA20_38=='}') && ((( isHead() )||( isValue() )))) {s = 71;}

                        else if ( (LA20_38==',') && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA20_38=='\r'||(LA20_38>='\"' && LA20_38<='#')||(LA20_38>='(' && LA20_38<=')')||LA20_38=='\\') && (( isHead() ))) {s = 23;}

                        else s = 64;

                         
                        input.seek(index20_38);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA20_14 = input.LA(1);

                         
                        int index20_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_14>='\u0000' && LA20_14<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 40;

                         
                        input.seek(index20_14);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA20_92 = input.LA(1);

                         
                        int index20_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_92>='0' && LA20_92<='9')||(LA20_92>='A' && LA20_92<='F')||(LA20_92>='a' && LA20_92<='f')) ) {s = 102;}

                        else if ( ((LA20_92>='\u0000' && LA20_92<='/')||(LA20_92>=':' && LA20_92<='@')||(LA20_92>='G' && LA20_92<='`')||(LA20_92>='g' && LA20_92<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_92);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA20_78 = input.LA(1);

                         
                        int index20_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_78=='\n'||LA20_78=='\r'||(LA20_78>='\"' && LA20_78<='#')||(LA20_78>='(' && LA20_78<=')')||LA20_78=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_78=='\t'||LA20_78==' ') ) {s = 75;}

                        else if ( ((LA20_78>='\u0000' && LA20_78<='\b')||(LA20_78>='\u000B' && LA20_78<='\f')||(LA20_78>='\u000E' && LA20_78<='\u001F')||LA20_78=='!'||(LA20_78>='$' && LA20_78<='\'')||LA20_78=='+'||(LA20_78>='-' && LA20_78<='9')||(LA20_78>=';' && LA20_78<='=')||(LA20_78>='?' && LA20_78<='Z')||(LA20_78>='^' && LA20_78<='z')||LA20_78=='|'||(LA20_78>='~' && LA20_78<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_78=='*'||LA20_78==':'||LA20_78=='>'||LA20_78=='['||LA20_78==']'||LA20_78=='{'||LA20_78=='}') ) {s = 77;}

                        else if ( (LA20_78==',') ) {s = 78;}

                        else s = 74;

                         
                        input.seek(index20_78);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA20_72 = input.LA(1);

                         
                        int index20_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_72=='\r'||(LA20_72>='\"' && LA20_72<='#')||(LA20_72>='(' && LA20_72<=')')||LA20_72=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_72=='\t'||LA20_72==' ') && ((( isHead() )||( isValue() )))) {s = 69;}

                        else if ( ((LA20_72>='\u0000' && LA20_72<='\b')||(LA20_72>='\u000B' && LA20_72<='\f')||(LA20_72>='\u000E' && LA20_72<='\u001F')||LA20_72=='!'||(LA20_72>='$' && LA20_72<='\'')||LA20_72=='+'||(LA20_72>='-' && LA20_72<='9')||(LA20_72>=';' && LA20_72<='=')||(LA20_72>='?' && LA20_72<='Z')||(LA20_72>='^' && LA20_72<='z')||LA20_72=='|'||(LA20_72>='~' && LA20_72<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 70;}

                        else if ( (LA20_72=='*'||LA20_72==':'||LA20_72=='>'||LA20_72=='['||LA20_72==']'||LA20_72=='{'||LA20_72=='}') && ((( isHead() )||( isValue() )))) {s = 71;}

                        else if ( (LA20_72==',') && ((( isHead() )||( isValue() )))) {s = 72;}

                        else s = 64;

                         
                        input.seek(index20_72);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA20_21 = input.LA(1);

                         
                        int index20_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_21=='\t'||LA20_21==' ') ) {s = 42;}

                        else if ( ((LA20_21>='\u0000' && LA20_21<='\b')||(LA20_21>='\u000B' && LA20_21<='\f')||(LA20_21>='\u000E' && LA20_21<='\u001F')||LA20_21=='!'||(LA20_21>='$' && LA20_21<='\'')||LA20_21=='+'||(LA20_21>='-' && LA20_21<='9')||(LA20_21>=';' && LA20_21<='=')||(LA20_21>='?' && LA20_21<='Z')||(LA20_21>='^' && LA20_21<='z')||LA20_21=='|'||(LA20_21>='~' && LA20_21<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_21=='*'||LA20_21==':'||LA20_21=='>'||LA20_21=='['||LA20_21==']'||LA20_21=='{'||LA20_21=='}') ) {s = 44;}

                        else if ( (LA20_21==',') ) {s = 45;}

                        else if ( (LA20_21=='\n'||LA20_21=='\r'||(LA20_21>='\"' && LA20_21<='#')||(LA20_21>='(' && LA20_21<=')')||LA20_21=='\\') && (( isHead() ))) {s = 23;}

                        else s = 57;

                         
                        input.seek(index20_21);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA20_45 = input.LA(1);

                         
                        int index20_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_45=='\n'||LA20_45=='\r'||(LA20_45>='\"' && LA20_45<='#')||(LA20_45>='(' && LA20_45<=')')||LA20_45=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_45=='\t'||LA20_45==' ') ) {s = 42;}

                        else if ( ((LA20_45>='\u0000' && LA20_45<='\b')||(LA20_45>='\u000B' && LA20_45<='\f')||(LA20_45>='\u000E' && LA20_45<='\u001F')||LA20_45=='!'||(LA20_45>='$' && LA20_45<='\'')||LA20_45=='+'||(LA20_45>='-' && LA20_45<='9')||(LA20_45>=';' && LA20_45<='=')||(LA20_45>='?' && LA20_45<='Z')||(LA20_45>='^' && LA20_45<='z')||LA20_45=='|'||(LA20_45>='~' && LA20_45<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_45=='*'||LA20_45==':'||LA20_45=='>'||LA20_45=='['||LA20_45==']'||LA20_45=='{'||LA20_45=='}') ) {s = 44;}

                        else if ( (LA20_45==',') ) {s = 45;}

                        else s = 57;

                         
                        input.seek(index20_45);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA20_68 = input.LA(1);

                         
                        int index20_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_68=='\n'||LA20_68=='\r'||(LA20_68>='\"' && LA20_68<='#')||(LA20_68>='(' && LA20_68<=')')||LA20_68=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_68=='\t'||LA20_68==' ') && ((( isHead() )||( isValue() )))) {s = 65;}

                        else if ( ((LA20_68>='\u0000' && LA20_68<='\b')||(LA20_68>='\u000B' && LA20_68<='\f')||(LA20_68>='\u000E' && LA20_68<='\u001F')||LA20_68=='!'||(LA20_68>='$' && LA20_68<='\'')||LA20_68=='+'||(LA20_68>='-' && LA20_68<='9')||(LA20_68>=';' && LA20_68<='=')||(LA20_68>='?' && LA20_68<='Z')||(LA20_68>='^' && LA20_68<='z')||LA20_68=='|'||(LA20_68>='~' && LA20_68<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 66;}

                        else if ( (LA20_68=='*'||LA20_68==':'||LA20_68=='>'||LA20_68=='['||LA20_68==']'||LA20_68=='{'||LA20_68=='}') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA20_68==',') && ((( isHead() )||( isValue() )))) {s = 68;}

                        else s = 64;

                         
                        input.seek(index20_68);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA20_54 = input.LA(1);

                         
                        int index20_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_54=='\"') ) {s = 79;}

                        else if ( (LA20_54=='\\') ) {s = 80;}

                        else if ( (LA20_54=='/') ) {s = 81;}

                        else if ( (LA20_54=='b') ) {s = 82;}

                        else if ( (LA20_54=='f') ) {s = 83;}

                        else if ( (LA20_54=='n') ) {s = 84;}

                        else if ( (LA20_54=='r') ) {s = 85;}

                        else if ( (LA20_54=='t') ) {s = 86;}

                        else if ( (LA20_54=='u') ) {s = 87;}

                        else if ( ((LA20_54>='\u0000' && LA20_54<='!')||(LA20_54>='#' && LA20_54<='.')||(LA20_54>='0' && LA20_54<='[')||(LA20_54>=']' && LA20_54<='a')||(LA20_54>='c' && LA20_54<='e')||(LA20_54>='g' && LA20_54<='m')||(LA20_54>='o' && LA20_54<='q')||LA20_54=='s'||(LA20_54>='v' && LA20_54<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_54);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA20_79 = input.LA(1);

                         
                        int index20_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_79=='\n'||LA20_79=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_79=='#') ) {s = 56;}

                        else if ( (LA20_79=='\"') ) {s = 55;}

                        else if ( ((LA20_79>='\u0000' && LA20_79<='\t')||(LA20_79>='\u000B' && LA20_79<='\f')||(LA20_79>='\u000E' && LA20_79<='!')||(LA20_79>='$' && LA20_79<='[')||(LA20_79>=']' && LA20_79<='\uFFFF')) ) {s = 53;}

                        else if ( (LA20_79=='\\') ) {s = 54;}

                         
                        input.seek(index20_79);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA20_105 = input.LA(1);

                         
                        int index20_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_105>='0' && LA20_105<='9')||(LA20_105>='A' && LA20_105<='F')||(LA20_105>='a' && LA20_105<='f')) ) {s = 107;}

                        else if ( ((LA20_105>='\u0000' && LA20_105<='\t')||(LA20_105>='\u000B' && LA20_105<='/')||(LA20_105>=':' && LA20_105<='@')||(LA20_105>='G' && LA20_105<='`')||(LA20_105>='g' && LA20_105<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_105);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA20_12 = input.LA(1);

                         
                        int index20_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_12>='\u0000' && LA20_12<='\b')||(LA20_12>='\u000B' && LA20_12<='\f')||(LA20_12>='\u000E' && LA20_12<='\u001F')||LA20_12=='!'||(LA20_12>='$' && LA20_12<='[')||(LA20_12>=']' && LA20_12<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 36;}

                        else if ( (LA20_12=='#') && ((( isHead() )||( isValue() )))) {s = 38;}

                        else if ( ((LA20_12>='\t' && LA20_12<='\n')||LA20_12=='\r'||LA20_12==' '||LA20_12=='\"'||LA20_12=='\\') && (( isHead() ))) {s = 23;}

                        else s = 37;

                         
                        input.seek(index20_12);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA20_43 = input.LA(1);

                         
                        int index20_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_43=='\t'||LA20_43==' ') ) {s = 42;}

                        else if ( ((LA20_43>='\u0000' && LA20_43<='\b')||(LA20_43>='\u000B' && LA20_43<='\f')||(LA20_43>='\u000E' && LA20_43<='\u001F')||LA20_43=='!'||(LA20_43>='$' && LA20_43<='\'')||LA20_43=='+'||(LA20_43>='-' && LA20_43<='9')||(LA20_43>=';' && LA20_43<='=')||(LA20_43>='?' && LA20_43<='Z')||(LA20_43>='^' && LA20_43<='z')||LA20_43=='|'||(LA20_43>='~' && LA20_43<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_43=='*'||LA20_43==':'||LA20_43=='>'||LA20_43=='['||LA20_43==']'||LA20_43=='{'||LA20_43=='}') ) {s = 44;}

                        else if ( (LA20_43==',') ) {s = 45;}

                        else if ( (LA20_43=='\n'||LA20_43=='\r'||(LA20_43>='\"' && LA20_43<='#')||(LA20_43>='(' && LA20_43<=')')||LA20_43=='\\') && (( isHead() ))) {s = 23;}

                        else s = 57;

                         
                        input.seek(index20_43);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA20_66 = input.LA(1);

                         
                        int index20_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_66=='\t'||LA20_66==' ') && ((( isHead() )||( isValue() )))) {s = 65;}

                        else if ( ((LA20_66>='\u0000' && LA20_66<='\b')||(LA20_66>='\u000B' && LA20_66<='\f')||(LA20_66>='\u000E' && LA20_66<='\u001F')||LA20_66=='!'||(LA20_66>='$' && LA20_66<='\'')||LA20_66=='+'||(LA20_66>='-' && LA20_66<='9')||(LA20_66>=';' && LA20_66<='=')||(LA20_66>='?' && LA20_66<='Z')||(LA20_66>='^' && LA20_66<='z')||LA20_66=='|'||(LA20_66>='~' && LA20_66<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 66;}

                        else if ( (LA20_66=='*'||LA20_66==':'||LA20_66=='>'||LA20_66=='['||LA20_66==']'||LA20_66=='{'||LA20_66=='}') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA20_66==',') && ((( isHead() )||( isValue() )))) {s = 68;}

                        else if ( (LA20_66=='\n'||LA20_66=='\r'||(LA20_66>='\"' && LA20_66<='#')||(LA20_66>='(' && LA20_66<=')')||LA20_66=='\\') && (( isHead() ))) {s = 23;}

                        else s = 64;

                         
                        input.seek(index20_66);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA20_56 = input.LA(1);

                         
                        int index20_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_56=='\"') ) {s = 89;}

                        else if ( ((LA20_56>='\u0000' && LA20_56<='\t')||(LA20_56>='\u000B' && LA20_56<='\f')||(LA20_56>='\u000E' && LA20_56<='!')||(LA20_56>='#' && LA20_56<='[')||(LA20_56>=']' && LA20_56<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_56=='\\') ) {s = 91;}

                        else if ( (LA20_56=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_56);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA20_28 = input.LA(1);

                         
                        int index20_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( currentState() != State.INIT )) ) {s = 61;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index20_28);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA20_18 = input.LA(1);

                         
                        int index20_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_18>='\u0000' && LA20_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 48;

                         
                        input.seek(index20_18);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA20_51 = input.LA(1);

                         
                        int index20_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_51=='\t'||LA20_51==' ') ) {s = 75;}

                        else if ( ((LA20_51>='\u0000' && LA20_51<='\b')||(LA20_51>='\u000B' && LA20_51<='\f')||(LA20_51>='\u000E' && LA20_51<='\u001F')||LA20_51=='!'||(LA20_51>='$' && LA20_51<='\'')||LA20_51=='+'||(LA20_51>='-' && LA20_51<='9')||(LA20_51>=';' && LA20_51<='=')||(LA20_51>='?' && LA20_51<='Z')||(LA20_51>='^' && LA20_51<='z')||LA20_51=='|'||(LA20_51>='~' && LA20_51<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_51=='*'||LA20_51==':'||LA20_51=='>'||LA20_51=='['||LA20_51==']'||LA20_51=='{'||LA20_51=='}') ) {s = 77;}

                        else if ( (LA20_51==',') ) {s = 78;}

                        else if ( (LA20_51=='\n'||LA20_51=='\r'||(LA20_51>='\"' && LA20_51<='#')||(LA20_51>='(' && LA20_51<=')')||LA20_51=='\\') && (( isHead() ))) {s = 23;}

                        else s = 74;

                         
                        input.seek(index20_51);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA20_17 = input.LA(1);

                         
                        int index20_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_17>='\u0000' && LA20_17<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 47;

                         
                        input.seek(index20_17);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA20_80 = input.LA(1);

                         
                        int index20_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_80=='\n'||LA20_80=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_80=='#') ) {s = 56;}

                        else if ( (LA20_80=='\"') ) {s = 55;}

                        else if ( ((LA20_80>='\u0000' && LA20_80<='\t')||(LA20_80>='\u000B' && LA20_80<='\f')||(LA20_80>='\u000E' && LA20_80<='!')||(LA20_80>='$' && LA20_80<='[')||(LA20_80>=']' && LA20_80<='\uFFFF')) ) {s = 53;}

                        else if ( (LA20_80=='\\') ) {s = 54;}

                         
                        input.seek(index20_80);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA20_69 = input.LA(1);

                         
                        int index20_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_69>='\u0000' && LA20_69<='\b')||(LA20_69>='\u000B' && LA20_69<='\f')||(LA20_69>='\u000E' && LA20_69<='\u001F')||LA20_69=='!'||(LA20_69>='$' && LA20_69<='\'')||LA20_69=='+'||(LA20_69>='-' && LA20_69<='9')||(LA20_69>=';' && LA20_69<='=')||(LA20_69>='?' && LA20_69<='Z')||(LA20_69>='^' && LA20_69<='z')||LA20_69=='|'||(LA20_69>='~' && LA20_69<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 70;}

                        else if ( (LA20_69=='*'||LA20_69==':'||LA20_69=='>'||LA20_69=='['||LA20_69==']'||LA20_69=='{'||LA20_69=='}') && ((( isHead() )||( isValue() )))) {s = 71;}

                        else if ( (LA20_69==',') && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA20_69=='\t'||LA20_69==' ') && ((( isHead() )||( isValue() )))) {s = 69;}

                        else if ( (LA20_69=='\r'||(LA20_69>='\"' && LA20_69<='#')||(LA20_69>='(' && LA20_69<=')')||LA20_69=='\\') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_69);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA20_42 = input.LA(1);

                         
                        int index20_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_42>='\u0000' && LA20_42<='\b')||(LA20_42>='\u000B' && LA20_42<='\f')||(LA20_42>='\u000E' && LA20_42<='\u001F')||LA20_42=='!'||(LA20_42>='$' && LA20_42<='\'')||LA20_42=='+'||(LA20_42>='-' && LA20_42<='9')||(LA20_42>=';' && LA20_42<='=')||(LA20_42>='?' && LA20_42<='Z')||(LA20_42>='^' && LA20_42<='z')||LA20_42=='|'||(LA20_42>='~' && LA20_42<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_42=='*'||LA20_42==':'||LA20_42=='>'||LA20_42=='['||LA20_42==']'||LA20_42=='{'||LA20_42=='}') ) {s = 44;}

                        else if ( (LA20_42==',') ) {s = 45;}

                        else if ( (LA20_42=='\t'||LA20_42==' ') ) {s = 42;}

                        else if ( (LA20_42=='\n'||LA20_42=='\r'||(LA20_42>='\"' && LA20_42<='#')||(LA20_42>='(' && LA20_42<=')')||LA20_42=='\\') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_42);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA20_65 = input.LA(1);

                         
                        int index20_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_65>='\u0000' && LA20_65<='\b')||(LA20_65>='\u000B' && LA20_65<='\f')||(LA20_65>='\u000E' && LA20_65<='\u001F')||LA20_65=='!'||(LA20_65>='$' && LA20_65<='\'')||LA20_65=='+'||(LA20_65>='-' && LA20_65<='9')||(LA20_65>=';' && LA20_65<='=')||(LA20_65>='?' && LA20_65<='Z')||(LA20_65>='^' && LA20_65<='z')||LA20_65=='|'||(LA20_65>='~' && LA20_65<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 66;}

                        else if ( (LA20_65=='*'||LA20_65==':'||LA20_65=='>'||LA20_65=='['||LA20_65==']'||LA20_65=='{'||LA20_65=='}') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA20_65==',') && ((( isHead() )||( isValue() )))) {s = 68;}

                        else if ( (LA20_65=='\t'||LA20_65==' ') && ((( isHead() )||( isValue() )))) {s = 65;}

                        else if ( (LA20_65=='\n'||LA20_65=='\r'||(LA20_65>='\"' && LA20_65<='#')||(LA20_65>='(' && LA20_65<=')')||LA20_65=='\\') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_65);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA20_90 = input.LA(1);

                         
                        int index20_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_90=='\"') ) {s = 89;}

                        else if ( ((LA20_90>='\u0000' && LA20_90<='\t')||(LA20_90>='\u000B' && LA20_90<='\f')||(LA20_90>='\u000E' && LA20_90<='!')||(LA20_90>='#' && LA20_90<='[')||(LA20_90>=']' && LA20_90<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_90=='\\') ) {s = 91;}

                        else if ( (LA20_90=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_90);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA20_71 = input.LA(1);

                         
                        int index20_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_71=='\t'||LA20_71==' ') && ((( isHead() )||( isValue() )))) {s = 69;}

                        else if ( ((LA20_71>='\u0000' && LA20_71<='\b')||(LA20_71>='\u000B' && LA20_71<='\f')||(LA20_71>='\u000E' && LA20_71<='\u001F')||LA20_71=='!'||(LA20_71>='$' && LA20_71<='\'')||LA20_71=='+'||(LA20_71>='-' && LA20_71<='9')||(LA20_71>=';' && LA20_71<='=')||(LA20_71>='?' && LA20_71<='Z')||(LA20_71>='^' && LA20_71<='z')||LA20_71=='|'||(LA20_71>='~' && LA20_71<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 70;}

                        else if ( (LA20_71=='*'||LA20_71==':'||LA20_71=='>'||LA20_71=='['||LA20_71==']'||LA20_71=='{'||LA20_71=='}') && ((( isHead() )||( isValue() )))) {s = 71;}

                        else if ( (LA20_71==',') && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA20_71=='\r'||(LA20_71>='\"' && LA20_71<='#')||(LA20_71>='(' && LA20_71<=')')||LA20_71=='\\') && (( isHead() ))) {s = 23;}

                        else s = 64;

                         
                        input.seek(index20_71);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_5=='-') ) {s = 6;}

                        else if ( (LA20_5==' ') ) {s = 27;}

                        else if ( (LA20_5=='\n'||LA20_5=='\r') ) {s = 29;}

                        else if ( (LA20_5=='\t') ) {s = 30;}

                        else if ( (LA20_5=='@') && (( isHead() ))) {s = 31;}

                        else if ( ((LA20_5>='\u0000' && LA20_5<='\b')||(LA20_5>='\u000B' && LA20_5<='\f')||(LA20_5>='\u000E' && LA20_5<='\u001F')||(LA20_5>='!' && LA20_5<='\"')||LA20_5=='$'||(LA20_5>='&' && LA20_5<=',')||(LA20_5>='.' && LA20_5<='?')||(LA20_5>='A' && LA20_5<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 28;

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA20_22 = input.LA(1);

                         
                        int index20_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_22>='\u0000' && LA20_22<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 58;

                         
                        input.seek(index20_22);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA20_47 = input.LA(1);

                         
                        int index20_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 73;}

                        else if ( (( isValue() )) ) {s = 58;}

                         
                        input.seek(index20_47);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA20_104 = input.LA(1);

                         
                        int index20_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_104>='0' && LA20_104<='9')||(LA20_104>='A' && LA20_104<='F')||(LA20_104>='a' && LA20_104<='f')) ) {s = 106;}

                        else if ( ((LA20_104>='\u0000' && LA20_104<='/')||(LA20_104>=':' && LA20_104<='@')||(LA20_104>='G' && LA20_104<='`')||(LA20_104>='g' && LA20_104<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_104);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA20_16 = input.LA(1);

                         
                        int index20_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_16=='\t'||LA20_16==' ') ) {s = 42;}

                        else if ( ((LA20_16>='\u0000' && LA20_16<='\b')||(LA20_16>='\u000B' && LA20_16<='\f')||(LA20_16>='\u000E' && LA20_16<='\u001F')||LA20_16=='!'||(LA20_16>='$' && LA20_16<='\'')||LA20_16=='+'||(LA20_16>='-' && LA20_16<='9')||(LA20_16>=';' && LA20_16<='=')||(LA20_16>='?' && LA20_16<='Z')||(LA20_16>='^' && LA20_16<='z')||LA20_16=='|'||(LA20_16>='~' && LA20_16<='\uFFFF')) ) {s = 43;}

                        else if ( (LA20_16=='*'||LA20_16==':'||LA20_16=='>'||LA20_16=='['||LA20_16==']'||LA20_16=='{'||LA20_16=='}') ) {s = 44;}

                        else if ( (LA20_16==',') ) {s = 45;}

                        else if ( (LA20_16=='\n'||LA20_16=='\r'||(LA20_16>='\"' && LA20_16<='#')||(LA20_16>='(' && LA20_16<=')')||LA20_16=='\\') && (( isHead() ))) {s = 23;}

                        else s = 46;

                         
                        input.seek(index20_16);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA20_93 = input.LA(1);

                         
                        int index20_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_93=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_93=='\"') ) {s = 89;}

                        else if ( ((LA20_93>='\u0000' && LA20_93<='\t')||(LA20_93>='\u000B' && LA20_93<='\f')||(LA20_93>='\u000E' && LA20_93<='!')||(LA20_93>='#' && LA20_93<='[')||(LA20_93>=']' && LA20_93<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_93=='\\') ) {s = 91;}

                         
                        input.seek(index20_93);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA20_106 = input.LA(1);

                         
                        int index20_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_106=='\n'||LA20_106=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_106=='#') ) {s = 56;}

                        else if ( (LA20_106=='\"') ) {s = 55;}

                        else if ( ((LA20_106>='\u0000' && LA20_106<='\t')||(LA20_106>='\u000B' && LA20_106<='\f')||(LA20_106>='\u000E' && LA20_106<='!')||(LA20_106>='$' && LA20_106<='[')||(LA20_106>=']' && LA20_106<='\uFFFF')) ) {s = 53;}

                        else if ( (LA20_106=='\\') ) {s = 54;}

                         
                        input.seek(index20_106);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA20_53 = input.LA(1);

                         
                        int index20_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_53=='\"') ) {s = 55;}

                        else if ( (LA20_53=='#') ) {s = 56;}

                        else if ( (LA20_53=='\\') ) {s = 54;}

                        else if ( (LA20_53=='\n'||LA20_53=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_53>='\u0000' && LA20_53<='\t')||(LA20_53>='\u000B' && LA20_53<='\f')||(LA20_53>='\u000E' && LA20_53<='!')||(LA20_53>='$' && LA20_53<='[')||(LA20_53>=']' && LA20_53<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_53);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA20_30 = input.LA(1);

                         
                        int index20_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_30=='\n'||LA20_30=='\r') ) {s = 29;}

                        else if ( (LA20_30=='\t'||LA20_30==' ') ) {s = 30;}

                        else if ( ((LA20_30>='\u0000' && LA20_30<='\b')||(LA20_30>='\u000B' && LA20_30<='\f')||(LA20_30>='\u000E' && LA20_30<='\u001F')||(LA20_30>='!' && LA20_30<='\"')||LA20_30=='$'||(LA20_30>='&' && LA20_30<=',')||(LA20_30>='.' && LA20_30<='?')||(LA20_30>='A' && LA20_30<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index20_30);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA20_75 = input.LA(1);

                         
                        int index20_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_75>='\u0000' && LA20_75<='\b')||(LA20_75>='\u000B' && LA20_75<='\f')||(LA20_75>='\u000E' && LA20_75<='\u001F')||LA20_75=='!'||(LA20_75>='$' && LA20_75<='\'')||LA20_75=='+'||(LA20_75>='-' && LA20_75<='9')||(LA20_75>=';' && LA20_75<='=')||(LA20_75>='?' && LA20_75<='Z')||(LA20_75>='^' && LA20_75<='z')||LA20_75=='|'||(LA20_75>='~' && LA20_75<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_75=='*'||LA20_75==':'||LA20_75=='>'||LA20_75=='['||LA20_75==']'||LA20_75=='{'||LA20_75=='}') ) {s = 77;}

                        else if ( (LA20_75==',') ) {s = 78;}

                        else if ( (LA20_75=='\t'||LA20_75==' ') ) {s = 75;}

                        else if ( (LA20_75=='\n'||LA20_75=='\r'||(LA20_75>='\"' && LA20_75<='#')||(LA20_75>='(' && LA20_75<=')')||LA20_75=='\\') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_75);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA20_99 = input.LA(1);

                         
                        int index20_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_99=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_99=='\"') ) {s = 89;}

                        else if ( ((LA20_99>='\u0000' && LA20_99<='\t')||(LA20_99>='\u000B' && LA20_99<='\f')||(LA20_99>='\u000E' && LA20_99<='!')||(LA20_99>='#' && LA20_99<='[')||(LA20_99>=']' && LA20_99<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_99=='\\') ) {s = 91;}

                         
                        input.seek(index20_99);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA20_19 = input.LA(1);

                         
                        int index20_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_19>='\u0000' && LA20_19<='\b')||(LA20_19>='\u000B' && LA20_19<='\f')||(LA20_19>='\u000E' && LA20_19<='\u001F')||LA20_19=='!'||(LA20_19>='$' && LA20_19<='\'')||LA20_19=='+'||(LA20_19>='-' && LA20_19<='9')||(LA20_19>=';' && LA20_19<='=')||(LA20_19>='?' && LA20_19<='Z')||(LA20_19>='^' && LA20_19<='z')||LA20_19=='|'||(LA20_19>='~' && LA20_19<='\uFFFF')) ) {s = 49;}

                        else if ( (LA20_19=='\t'||LA20_19==' ') ) {s = 42;}

                        else if ( (LA20_19=='*'||LA20_19==':'||LA20_19=='>'||LA20_19=='['||LA20_19==']'||LA20_19=='{'||LA20_19=='}') ) {s = 51;}

                        else if ( (LA20_19==',') ) {s = 52;}

                        else if ( ((LA20_19>='(' && LA20_19<=')')) && ((( isValue() )||( isHead() )))) {s = 36;}

                        else if ( (LA20_19=='#') && ((( isHead() )||( isValue() )))) {s = 38;}

                        else if ( (LA20_19=='\n'||LA20_19=='\r'||LA20_19=='\"'||LA20_19=='\\') && (( isHead() ))) {s = 23;}

                        else s = 50;

                         
                        input.seek(index20_19);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA20_77 = input.LA(1);

                         
                        int index20_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_77=='\t'||LA20_77==' ') ) {s = 75;}

                        else if ( ((LA20_77>='\u0000' && LA20_77<='\b')||(LA20_77>='\u000B' && LA20_77<='\f')||(LA20_77>='\u000E' && LA20_77<='\u001F')||LA20_77=='!'||(LA20_77>='$' && LA20_77<='\'')||LA20_77=='+'||(LA20_77>='-' && LA20_77<='9')||(LA20_77>=';' && LA20_77<='=')||(LA20_77>='?' && LA20_77<='Z')||(LA20_77>='^' && LA20_77<='z')||LA20_77=='|'||(LA20_77>='~' && LA20_77<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_77=='*'||LA20_77==':'||LA20_77=='>'||LA20_77=='['||LA20_77==']'||LA20_77=='{'||LA20_77=='}') ) {s = 77;}

                        else if ( (LA20_77==',') ) {s = 78;}

                        else if ( (LA20_77=='\n'||LA20_77=='\r'||(LA20_77>='\"' && LA20_77<='#')||(LA20_77>='(' && LA20_77<=')')||LA20_77=='\\') && (( isHead() ))) {s = 23;}

                        else s = 74;

                         
                        input.seek(index20_77);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA20_26 = input.LA(1);

                         
                        int index20_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 60;}

                        else if ( (( isHead() )) ) {s = 29;}

                         
                        input.seek(index20_26);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA20_25 = input.LA(1);

                         
                        int index20_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 60;}

                        else if ( (( isHead() )) ) {s = 29;}

                         
                        input.seek(index20_25);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_8=='\n'||LA20_8=='\r') ) {s = 29;}

                        else if ( (LA20_8=='\t'||LA20_8==' ') ) {s = 30;}

                        else if ( ((LA20_8>='\u0000' && LA20_8<='\b')||(LA20_8>='\u000B' && LA20_8<='\f')||(LA20_8>='\u000E' && LA20_8<='\u001F')||(LA20_8>='!' && LA20_8<='\"')||LA20_8=='$'||(LA20_8>='&' && LA20_8<=',')||(LA20_8>='.' && LA20_8<='?')||(LA20_8>='A' && LA20_8<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 28;

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA20_59 = input.LA(1);

                         
                        int index20_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 60;}

                        else if ( (( isHead() )) ) {s = 29;}

                         
                        input.seek(index20_59);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA20_76 = input.LA(1);

                         
                        int index20_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_76=='\t'||LA20_76==' ') ) {s = 75;}

                        else if ( ((LA20_76>='\u0000' && LA20_76<='\b')||(LA20_76>='\u000B' && LA20_76<='\f')||(LA20_76>='\u000E' && LA20_76<='\u001F')||LA20_76=='!'||(LA20_76>='$' && LA20_76<='\'')||LA20_76=='+'||(LA20_76>='-' && LA20_76<='9')||(LA20_76>=';' && LA20_76<='=')||(LA20_76>='?' && LA20_76<='Z')||(LA20_76>='^' && LA20_76<='z')||LA20_76=='|'||(LA20_76>='~' && LA20_76<='\uFFFF')) ) {s = 76;}

                        else if ( (LA20_76=='*'||LA20_76==':'||LA20_76=='>'||LA20_76=='['||LA20_76==']'||LA20_76=='{'||LA20_76=='}') ) {s = 77;}

                        else if ( (LA20_76==',') ) {s = 78;}

                        else if ( (LA20_76=='\n'||LA20_76=='\r'||(LA20_76>='\"' && LA20_76<='#')||(LA20_76>='(' && LA20_76<=')')||LA20_76=='\\') && (( isHead() ))) {s = 23;}

                        else s = 74;

                         
                        input.seek(index20_76);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA20_36 = input.LA(1);

                         
                        int index20_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_36=='\n'||LA20_36=='\r'||(LA20_36>='\"' && LA20_36<='#')||(LA20_36>='(' && LA20_36<=')')||LA20_36=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA20_36=='\t'||LA20_36==' ') && ((( isHead() )||( isValue() )))) {s = 65;}

                        else if ( ((LA20_36>='\u0000' && LA20_36<='\b')||(LA20_36>='\u000B' && LA20_36<='\f')||(LA20_36>='\u000E' && LA20_36<='\u001F')||LA20_36=='!'||(LA20_36>='$' && LA20_36<='\'')||LA20_36=='+'||(LA20_36>='-' && LA20_36<='9')||(LA20_36>=';' && LA20_36<='=')||(LA20_36>='?' && LA20_36<='Z')||(LA20_36>='^' && LA20_36<='z')||LA20_36=='|'||(LA20_36>='~' && LA20_36<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 66;}

                        else if ( (LA20_36=='*'||LA20_36==':'||LA20_36=='>'||LA20_36=='['||LA20_36==']'||LA20_36=='{'||LA20_36=='}') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA20_36==',') && ((( isHead() )||( isValue() )))) {s = 68;}

                        else s = 64;

                         
                        input.seek(index20_36);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA20_96 = input.LA(1);

                         
                        int index20_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_96=='\"') ) {s = 89;}

                        else if ( ((LA20_96>='\u0000' && LA20_96<='\t')||(LA20_96>='\u000B' && LA20_96<='\f')||(LA20_96>='\u000E' && LA20_96<='!')||(LA20_96>='#' && LA20_96<='[')||(LA20_96>=']' && LA20_96<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_96=='\\') ) {s = 91;}

                        else if ( (LA20_96=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_96);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA20_107 = input.LA(1);

                         
                        int index20_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_107>='0' && LA20_107<='9')||(LA20_107>='A' && LA20_107<='F')||(LA20_107>='a' && LA20_107<='f')) ) {s = 108;}

                        else if ( ((LA20_107>='\u0000' && LA20_107<='\t')||(LA20_107>='\u000B' && LA20_107<='/')||(LA20_107>=':' && LA20_107<='@')||(LA20_107>='G' && LA20_107<='`')||(LA20_107>='g' && LA20_107<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_107);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA20_91 = input.LA(1);

                         
                        int index20_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_91=='\"') ) {s = 93;}

                        else if ( (LA20_91=='\\') ) {s = 94;}

                        else if ( (LA20_91=='/') ) {s = 95;}

                        else if ( (LA20_91=='b') ) {s = 96;}

                        else if ( (LA20_91=='f') ) {s = 97;}

                        else if ( (LA20_91=='n') ) {s = 98;}

                        else if ( (LA20_91=='r') ) {s = 99;}

                        else if ( (LA20_91=='t') ) {s = 100;}

                        else if ( (LA20_91=='u') ) {s = 101;}

                        else if ( ((LA20_91>='\u0000' && LA20_91<='\t')||(LA20_91>='\u000B' && LA20_91<='!')||(LA20_91>='#' && LA20_91<='.')||(LA20_91>='0' && LA20_91<='[')||(LA20_91>=']' && LA20_91<='a')||(LA20_91>='c' && LA20_91<='e')||(LA20_91>='g' && LA20_91<='m')||(LA20_91>='o' && LA20_91<='q')||LA20_91=='s'||(LA20_91>='v' && LA20_91<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_91);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_10>='\u0000' && LA20_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 34;

                         
                        input.seek(index20_10);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA20_97 = input.LA(1);

                         
                        int index20_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_97=='\"') ) {s = 89;}

                        else if ( ((LA20_97>='\u0000' && LA20_97<='\t')||(LA20_97>='\u000B' && LA20_97<='\f')||(LA20_97>='\u000E' && LA20_97<='!')||(LA20_97>='#' && LA20_97<='[')||(LA20_97>=']' && LA20_97<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_97=='\\') ) {s = 91;}

                        else if ( (LA20_97=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_97);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA20_0 = input.LA(1);

                         
                        int index20_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_0=='#') ) {s = 1;}

                        else if ( (LA20_0=='%') ) {s = 2;}

                        else if ( (LA20_0=='\r') ) {s = 3;}

                        else if ( (LA20_0=='\n') ) {s = 4;}

                        else if ( (LA20_0==' ') ) {s = 5;}

                        else if ( (LA20_0=='-') ) {s = 6;}

                        else if ( (LA20_0=='@') ) {s = 7;}

                        else if ( (LA20_0=='\t') ) {s = 8;}

                        else if ( (LA20_0=='(') ) {s = 9;}

                        else if ( (LA20_0==')') ) {s = 10;}

                        else if ( (LA20_0==',') ) {s = 11;}

                        else if ( (LA20_0==':') ) {s = 12;}

                        else if ( (LA20_0=='>') ) {s = 13;}

                        else if ( (LA20_0=='|') ) {s = 14;}

                        else if ( (LA20_0=='*') ) {s = 15;}

                        else if ( (LA20_0=='+') ) {s = 16;}

                        else if ( (LA20_0=='[') ) {s = 17;}

                        else if ( (LA20_0==']') ) {s = 18;}

                        else if ( (LA20_0=='?') ) {s = 19;}

                        else if ( (LA20_0=='\"') ) {s = 20;}

                        else if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='!'||LA20_0=='$'||LA20_0=='&'||(LA20_0>='.' && LA20_0<='9')||(LA20_0>=';' && LA20_0<='=')||(LA20_0>='A' && LA20_0<='Z')||(LA20_0>='^' && LA20_0<='z')||(LA20_0>='~' && LA20_0<='\uFFFF')) ) {s = 21;}

                        else if ( (LA20_0=='{') && ((( isValue() )||( isHead() )))) {s = 22;}

                        else if ( (LA20_0=='\''||LA20_0=='\\'||LA20_0=='}') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_0);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA20_13 = input.LA(1);

                         
                        int index20_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_13>='\u0000' && LA20_13<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 39;

                         
                        input.seek(index20_13);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA20_81 = input.LA(1);

                         
                        int index20_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_81=='\"') ) {s = 55;}

                        else if ( (LA20_81=='#') ) {s = 56;}

                        else if ( (LA20_81=='\\') ) {s = 54;}

                        else if ( (LA20_81=='\n'||LA20_81=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_81>='\u0000' && LA20_81<='\t')||(LA20_81>='\u000B' && LA20_81<='\f')||(LA20_81>='\u000E' && LA20_81<='!')||(LA20_81>='$' && LA20_81<='[')||(LA20_81>=']' && LA20_81<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_81);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA20_98 = input.LA(1);

                         
                        int index20_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_98=='\"') ) {s = 89;}

                        else if ( ((LA20_98>='\u0000' && LA20_98<='\t')||(LA20_98>='\u000B' && LA20_98<='\f')||(LA20_98>='\u000E' && LA20_98<='!')||(LA20_98>='#' && LA20_98<='[')||(LA20_98>=']' && LA20_98<='\uFFFF')) ) {s = 90;}

                        else if ( (LA20_98=='\\') ) {s = 91;}

                        else if ( (LA20_98=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index20_98);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA20_86 = input.LA(1);

                         
                        int index20_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_86=='\"') ) {s = 55;}

                        else if ( (LA20_86=='#') ) {s = 56;}

                        else if ( (LA20_86=='\\') ) {s = 54;}

                        else if ( (LA20_86=='\n'||LA20_86=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA20_86>='\u0000' && LA20_86<='\t')||(LA20_86>='\u000B' && LA20_86<='\f')||(LA20_86>='\u000E' && LA20_86<='!')||(LA20_86>='$' && LA20_86<='[')||(LA20_86>=']' && LA20_86<='\uFFFF')) ) {s = 53;}

                         
                        input.seek(index20_86);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA20_70 = input.LA(1);

                         
                        int index20_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_70=='\t'||LA20_70==' ') && ((( isHead() )||( isValue() )))) {s = 69;}

                        else if ( ((LA20_70>='\u0000' && LA20_70<='\b')||(LA20_70>='\u000B' && LA20_70<='\f')||(LA20_70>='\u000E' && LA20_70<='\u001F')||LA20_70=='!'||(LA20_70>='$' && LA20_70<='\'')||LA20_70=='+'||(LA20_70>='-' && LA20_70<='9')||(LA20_70>=';' && LA20_70<='=')||(LA20_70>='?' && LA20_70<='Z')||(LA20_70>='^' && LA20_70<='z')||LA20_70=='|'||(LA20_70>='~' && LA20_70<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 70;}

                        else if ( (LA20_70=='*'||LA20_70==':'||LA20_70=='>'||LA20_70=='['||LA20_70==']'||LA20_70=='{'||LA20_70=='}') && ((( isHead() )||( isValue() )))) {s = 71;}

                        else if ( (LA20_70==',') && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA20_70=='\r'||(LA20_70>='\"' && LA20_70<='#')||(LA20_70>='(' && LA20_70<=')')||LA20_70=='\\') && (( isHead() ))) {s = 23;}

                        else s = 64;

                         
                        input.seek(index20_70);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
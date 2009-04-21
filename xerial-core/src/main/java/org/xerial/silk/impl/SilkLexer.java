// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-21 16:35:50

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
    public static final int PlainUnsafeChar=52;
    public static final int PlainSafeKey=53;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=36;
    public static final int Digit=39;
    public static final int NodeIndent=22;
    public static final int HexDigit=41;
    public static final int PlainOneLine=57;
    public static final int Plus=35;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int FlowIndicator=51;
    public static final int Separation=59;
    public static final int Letter=40;
    public static final int PlainSafeIn=54;
    public static final int Comma=29;
    public static final int TabSeq=32;
    public static final int NonSpaceChar=45;
    public static final int EscapeSequence=43;
    public static final int DataLine=26;
    public static final int PlainFirst=49;
    public static final int WhiteSpace=19;
    public static final int MultiLineEntrySeparator=21;
    public static final int PlainSafeOut=55;
    public static final int JSON=58;
    public static final int Question=38;
    public static final int LineComment=16;
    public static final int Colon=30;
    public static final int At=34;
    public static final int DataLineBody=25;
    public static final int KeyValuePair=13;
    public static final int Star=33;
    public static final int Preamble=17;
    public static final int Seq=31;
    public static final int FunctionIndent=23;
    public static final int Indicator=48;
    public static final int RParen=28;
    public static final int UnicodeChar=42;
    public static final int BlankLine=24;
    public static final int MultiLineSeparator=20;
    public static final int Silk=4;
    public static final int StringChar=44;
    public static final int LineBreak=15;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=27;
    public static final int String=47;
    public static final int LineBreakChar=18;
    public static final int ScopeIndicator=50;
    public static final int EOF=-1;
    public static final int StringChar_s=46;
    public static final int Value=8;
    public static final int RBracket=37;
    public static final int PlainSafe=56;


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:12: ( '#' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:133:14: '#' (~ ( '\\n' | '\\r' ) )* LineBreak
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

            mLineBreak(); 
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:9: ( '%' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:134:11: '%' (~ ( '\\n' | '\\r' ) )* LineBreak
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

            mLineBreak(); 

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
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;}
            }
            else if ( (LA3_0=='\n') ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
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

    // $ANTLR start "MultiLineSeparator"
    public final void mMultiLineSeparator() throws RecognitionException {
        try {
            int _type = MultiLineSeparator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:19: ({...}? => '--' ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:21: {...}? => '--' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineSeparator", " isHead() ");
            }
            match("--"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:43: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:43: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "MultiLineSeparator"

    // $ANTLR start "MultiLineEntrySeparator"
    public final void mMultiLineEntrySeparator() throws RecognitionException {
        try {
            int _type = MultiLineEntrySeparator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:24: ({...}? => '>>' ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:26: {...}? => '>>' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineEntrySeparator", " isHead() ");
            }
            match(">>"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:48: ( WhiteSpace )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:48: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "MultiLineEntrySeparator"

    // $ANTLR start "NodeIndent"
    public final void mNodeIndent() throws RecognitionException {
        try {
            int _type = NodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:11: ({...}? ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:13: {...}? ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:27: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:28: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:15: ({...}? => ( ' ' )* '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:34: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:10: ({...}? => ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:12: {...}? => ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:29: ( WhiteSpace )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:29: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:78: (~ ( '#' | '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\"')||(LA9_0>='$' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:151:78: ~ ( '#' | '\\n' | '\\r' )
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
            	    break loop9;
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:152:11: {...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment )
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:5: ( WhiteSpace )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            int DataLineBody1Start259 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start259, getCharIndex()-1);
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:30: ( LineBreak | LineComment )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            else if ( (LA11_0=='#') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:31: LineBreak
                    {
                    mLineBreak(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:41: LineComment
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:9: ')'
            {
            match(')'); 
             transit(Symbol.LeaveParen); 

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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:9: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:8: ':'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:4: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:7: '>'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:7: ( '|' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:162:9: '|'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:8: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:6: '@'
            {
            match('@'); 
             transit(Symbol.At); 

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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:7: '+'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:18: ( Digit | Letter )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:21: ( UnicodeChar | EscapeSequence )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:38: EscapeSequence
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:22: ( ( StringChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:24: ( StringChar )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:24: ( StringChar )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop14;
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:7: ( '\"' s= StringChar_s '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart560 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart560, getCharIndex()-1);
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:2: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator ) | {...}? => ( ':' | '?' ) NonSpaceChar )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='?') ) {
                int LA15_1 = input.LA(2);

                if ( ((LA15_1>='\u0000' && LA15_1<='\b')||(LA15_1>='\u000B' && LA15_1<='\f')||(LA15_1>='\u000E' && LA15_1<='\u001F')||LA15_1=='!'||(LA15_1>='#' && LA15_1<='[')||(LA15_1>=']' && LA15_1<='\uFFFF')) && (( isValue() ))) {
                    alt15=2;
                }
                else {
                    alt15=1;}
            }
            else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||LA15_0=='$'||LA15_0=='&'||LA15_0=='+'||(LA15_0>='-' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='=')||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0==':') && (( isValue() ))) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:4: {...}? => ( ':' | '?' ) NonSpaceChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:24: ( '(' | ')' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:23: ( '[' | ']' | '{' | '}' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='*')||input.LA(1)==','||input.LA(1)==':'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:25: ( '\"' | '\\\\' | LineBreakChar | '#' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r'||(input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='\\' ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='\'')||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:22: (~ ( PlainUnsafeChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:24: ~ ( PlainUnsafeChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='!')||(LA16_0>='$' && LA16_0<='\'')||LA16_0=='+'||(LA16_0>='-' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='?' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA16_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt16=1;
                }
                else if ( (( isInValue() )) ) {
                    alt16=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt16=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0=='*'||LA16_0==':'||LA16_0=='>'||LA16_0=='['||LA16_0==']'||(LA16_0>='{' && LA16_0<='}')) && ((( isInValue() )||( isOutValue() )))) {
                int LA16_2 = input.LA(2);

                if ( (( isInValue() )) ) {
                    alt16=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt16=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
            }
            else if ( ((LA16_0>='(' && LA16_0<=')')||LA16_0==',') && (( isOutValue() ))) {
                alt16=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:4: {...}? => PlainSafeOut
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:13: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:15: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:26: ( ( WhiteSpace )* PlainSafe )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\t'||LA18_0==' ') ) {
                    alt18=1;
                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='$' && LA18_0<='\'')||LA18_0=='+'||(LA18_0>='-' && LA18_0<='9')||(LA18_0>=';' && LA18_0<='=')||(LA18_0>='?' && LA18_0<='Z')||(LA18_0>='^' && LA18_0<='z')||(LA18_0>='~' && LA18_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt18=1;
                }
                else if ( (LA18_0=='*'||LA18_0==':'||LA18_0=='>'||LA18_0=='['||LA18_0==']'||(LA18_0>='{' && LA18_0<='}')) && ((( isInValue() )||( isOutValue() )))) {
                    alt18=1;
                }
                else if ( ((LA18_0>='(' && LA18_0<=')')||LA18_0==',') && (( isOutValue() ))) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: ( WhiteSpace )* PlainSafe
            	    {
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: ( WhiteSpace )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='\t'||LA17_0==' ') && ((!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isOutValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isInValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isKey() )))) {
            	            int LA17_1 = input.LA(2);

            	            if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);

            	    mPlainSafe(); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:213:2: ({...}? => '{' | {...}? => '[' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='{') && (( isValue() ))) {
                alt19=1;
            }
            else if ( (LA19_0=='[') && (( isValue() ))) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:213:4: {...}? => '{'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:4: {...}? => '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:11: ({...}? ( WhiteSpace )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:13: {...}? ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:28: ( WhiteSpace )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:28: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:240:2: ( ( ' ' | '\\t' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:240:4: ( ' ' | '\\t' )
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
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace )
        int alt21=26;
        alt21 = dfa21.predict(input);
        switch (alt21) {
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
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:41: MultiLineSeparator
                {
                mMultiLineSeparator(); 

                }
                break;
            case 5 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:60: MultiLineEntrySeparator
                {
                mMultiLineEntrySeparator(); 

                }
                break;
            case 6 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:84: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 7 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:95: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 8 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:110: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 9 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:120: DataLine
                {
                mDataLine(); 

                }
                break;
            case 10 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:129: LParen
                {
                mLParen(); 

                }
                break;
            case 11 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:136: RParen
                {
                mRParen(); 

                }
                break;
            case 12 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:143: Comma
                {
                mComma(); 

                }
                break;
            case 13 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:149: Colon
                {
                mColon(); 

                }
                break;
            case 14 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:155: Seq
                {
                mSeq(); 

                }
                break;
            case 15 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:159: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 16 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:166: Star
                {
                mStar(); 

                }
                break;
            case 17 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:171: At
                {
                mAt(); 

                }
                break;
            case 18 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:174: Plus
                {
                mPlus(); 

                }
                break;
            case 19 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:179: LBracket
                {
                mLBracket(); 

                }
                break;
            case 20 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:188: RBracket
                {
                mRBracket(); 

                }
                break;
            case 21 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:197: Question
                {
                mQuestion(); 

                }
                break;
            case 22 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:206: String
                {
                mString(); 

                }
                break;
            case 23 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:213: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 24 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:226: JSON
                {
                mJSON(); 

                }
                break;
            case 25 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:231: Separation
                {
                mSeparation(); 

                }
                break;
            case 26 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:242: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\3\uffff\1\31\1\32\1\34\1\37\1\40\1\46\1\40\1\47\1\50\1\51\1\53"+
        "\1\55\1\56\1\60\1\64\1\65\1\67\1\uffff\1\35\1\76\1\uffff\1\77\2"+
        "\uffff\1\35\6\uffff\2\106\6\uffff\1\111\1\uffff\1\111\2\uffff\1"+
        "\122\1\uffff\3\122\2\uffff\1\122\1\uffff\2\122\3\uffff\1\144\3\uffff"+
        "\1\122\2\uffff\2\146\4\uffff\10\111\2\uffff\4\122\1\144\14\uffff"+
        "\1\146\23\uffff";
    static final String DFA21_eofS =
        "\171\uffff";
    static final String DFA21_minS =
        "\1\0\2\uffff\1\12\23\0\1\uffff\3\0\1\11\1\0\1\uffff\1\0\1\uffff"+
        "\1\0\1\uffff\2\0\2\uffff\1\0\3\uffff\1\0\1\uffff\1\0\2\uffff\1\0"+
        "\1\uffff\4\0\1\uffff\1\0\1\uffff\6\0\1\uffff\1\0\1\uffff\1\11\1"+
        "\uffff\1\0\1\12\1\0\4\uffff\10\0\2\uffff\20\0\1\uffff\14\0\1\uffff"+
        "\7\0";
    static final String DFA21_maxS =
        "\1\uffff\2\uffff\1\12\1\0\3\uffff\1\0\16\uffff\1\uffff\3\0\1\40"+
        "\1\0\1\uffff\1\uffff\1\uffff\1\0\1\uffff\2\uffff\2\uffff\1\0\3\uffff"+
        "\1\uffff\1\uffff\1\uffff\2\uffff\1\uffff\1\uffff\3\uffff\1\0\1\uffff"+
        "\1\uffff\1\uffff\6\uffff\1\uffff\1\0\1\uffff\1\40\1\uffff\1\uffff"+
        "\1\12\1\0\4\uffff\10\uffff\2\uffff\20\uffff\1\uffff\2\0\12\uffff"+
        "\1\uffff\7\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\24\uffff\1\11\5\uffff\1\27\1\uffff\1\16\1\uffff"+
        "\1\7\2\uffff\1\6\1\10\1\uffff\1\12\1\13\1\14\1\uffff\1\15\1\uffff"+
        "\1\17\1\20\1\uffff\1\22\4\uffff\1\24\1\uffff\1\25\6\uffff\1\30\1"+
        "\uffff\1\3\1\uffff\1\4\3\uffff\1\31\1\32\1\21\1\27\10\uffff\1\27"+
        "\1\23\20\uffff\1\26\14\uffff\1\5\7\uffff";
    static final String DFA21_specialS =
        "\1\122\4\uffff\1\0\1\106\1\15\1\uffff\1\70\1\17\1\53\1\5\1\34\1"+
        "\61\1\11\1\102\1\37\1\40\1\107\1\42\1\103\1\2\2\uffff\1\124\1\123"+
        "\1\14\1\10\1\uffff\1\13\1\uffff\1\6\1\uffff\1\7\1\113\2\uffff\1"+
        "\73\3\uffff\1\16\1\uffff\1\110\2\uffff\1\56\1\uffff\1\64\1\27\1"+
        "\23\1\76\1\uffff\1\43\1\uffff\1\30\1\104\1\41\1\46\1\31\1\77\1\uffff"+
        "\1\125\1\uffff\1\112\1\uffff\1\60\1\111\1\67\4\uffff\1\57\1\65\1"+
        "\32\1\24\1\54\1\120\1\44\1\114\2\uffff\1\72\1\26\1\117\1\35\1\126"+
        "\1\130\1\115\1\20\1\71\1\51\1\121\1\105\1\66\1\75\1\100\1\101\1"+
        "\uffff\1\50\1\21\1\22\1\1\1\45\1\63\1\55\1\47\1\4\1\25\1\33\1\12"+
        "\1\uffff\1\116\1\62\1\74\1\127\1\52\1\3\1\36}>";
    static final String[] DFA21_transitionS = {
            "\11\25\1\11\1\4\2\25\1\3\22\25\1\7\1\25\1\24\1\1\1\25\1\2\1"+
            "\25\1\27\1\12\1\13\1\17\1\20\1\14\1\5\14\25\1\15\3\25\1\6\1"+
            "\23\1\10\32\25\1\21\1\27\1\22\35\25\1\26\1\16\1\27\uff82\25",
            "",
            "",
            "\1\30",
            "\1\uffff",
            "\12\35\1\uffff\2\35\1\uffff\24\35\2\uffff\11\35\1\33\56\35"+
            "\1\uffff\uffa3\35",
            "\76\27\1\36\uffc1\27",
            "\11\27\1\43\1\45\2\27\1\45\22\27\1\42\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\44\22\27\1\41\uffbf\27",
            "\1\uffff",
            "\11\27\1\43\1\45\2\27\1\45\22\27\1\43\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\52\2\27\2\52\1\27\22\52\1\27\1\52\1\27\1\54\70\52\1\27"+
            "\uffa3\52",
            "\0\27",
            "\0\27",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\0\27",
            "\0\27",
            "\11\66\1\57\1\27\2\66\1\27\22\66\1\57\1\66\1\27\1\54\4\66"+
            "\2\71\1\70\1\66\1\71\15\66\1\70\3\66\1\70\34\66\1\70\1\27\1"+
            "\70\35\66\3\70\uff82\66",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\0\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\101\1\102\2\uffff\1\102\22\uffff\1\101",
            "\1\uffff",
            "",
            "\11\27\1\103\1\105\2\27\1\104\22\27\1\103\uffdf\27",
            "",
            "\1\uffff",
            "",
            "\11\27\1\43\1\45\2\27\1\45\22\27\1\42\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\44\22\27\1\41\uffbf\27",
            "\11\27\1\43\1\45\2\27\1\45\22\27\1\43\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "",
            "",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\11\61\1\57\1\27\2\61\1\27\22\61\1\57\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\1\uffff",
            "",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\42\27\1\133\14\27\1\135\54\27\1\134\5\27\1\136\3\27\1\137"+
            "\7\27\1\140\3\27\1\141\1\27\1\142\1\143\uff8a\27",
            "\0\27",
            "",
            "\1\uffff",
            "",
            "\1\101\1\102\2\uffff\1\102\22\uffff\1\101",
            "",
            "\11\27\1\103\1\105\2\27\1\104\22\27\1\103\uffdf\27",
            "\1\145",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "",
            "",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\11\125\1\124\1\27\2\125\1\27\22\125\1\124\1\125\2\27\4\125"+
            "\2\127\1\126\1\125\1\127\15\125\1\126\3\125\1\126\34\125\1\126"+
            "\1\27\1\126\35\125\3\126\uff82\125",
            "\0\27",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\42\27\1\147\14\27\1\151\54\27\1\150\5\27\1\152\3\27\1\153"+
            "\7\27\1\154\3\27\1\155\1\27\1\156\1\157\uff8a\27",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\60\27\12\160\7\27\6\160\32\27\6\160\uff99\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131",
            "\60\27\12\162\7\27\6\162\32\27\6\162\uff99\27",
            "\60\27\12\163\7\27\6\163\32\27\6\163\uff99\27",
            "",
            "\60\27\12\164\7\27\6\164\32\27\6\164\uff99\27",
            "\60\27\12\165\7\27\6\165\32\27\6\165\uff99\27",
            "\60\27\12\166\7\27\6\166\32\27\6\166\uff99\27",
            "\60\27\12\167\7\27\6\167\32\27\6\167\uff99\27",
            "\60\27\12\170\7\27\6\170\32\27\6\170\uff99\27",
            "\12\72\1\27\2\72\1\27\24\72\1\75\1\73\70\72\1\74\uffa3\72",
            "\12\131\1\27\2\131\1\27\24\131\1\130\71\131\1\132\uffa3\131"
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
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_5 = input.LA(1);

                        s = -1;
                        if ( (LA21_5=='-') ) {s = 27;}

                        else if ( ((LA21_5>='\u0000' && LA21_5<='\t')||(LA21_5>='\u000B' && LA21_5<='\f')||(LA21_5>='\u000E' && LA21_5<='!')||(LA21_5>='$' && LA21_5<=',')||(LA21_5>='.' && LA21_5<='[')||(LA21_5>=']' && LA21_5<='\uFFFF')) ) {s = 29;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_104 = input.LA(1);

                         
                        int index21_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_104=='\n'||LA21_104=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_104=='\"') ) {s = 88;}

                        else if ( ((LA21_104>='\u0000' && LA21_104<='\t')||(LA21_104>='\u000B' && LA21_104<='\f')||(LA21_104>='\u000E' && LA21_104<='!')||(LA21_104>='#' && LA21_104<='[')||(LA21_104>=']' && LA21_104<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_104=='\\') ) {s = 90;}

                         
                        input.seek(index21_104);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_22 = input.LA(1);

                         
                        int index21_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_22>='\u0000' && LA21_22<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index21_22);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_119 = input.LA(1);

                         
                        int index21_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_119=='\n'||LA21_119=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_119=='#') ) {s = 59;}

                        else if ( (LA21_119=='\"') ) {s = 61;}

                        else if ( ((LA21_119>='\u0000' && LA21_119<='\t')||(LA21_119>='\u000B' && LA21_119<='\f')||(LA21_119>='\u000E' && LA21_119<='!')||(LA21_119>='$' && LA21_119<='[')||(LA21_119>=']' && LA21_119<='\uFFFF')) ) {s = 58;}

                        else if ( (LA21_119=='\\') ) {s = 60;}

                         
                        input.seek(index21_119);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_109 = input.LA(1);

                         
                        int index21_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_109=='\n'||LA21_109=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_109=='\"') ) {s = 88;}

                        else if ( ((LA21_109>='\u0000' && LA21_109<='\t')||(LA21_109>='\u000B' && LA21_109<='\f')||(LA21_109>='\u000E' && LA21_109<='!')||(LA21_109>='#' && LA21_109<='[')||(LA21_109>=']' && LA21_109<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_109=='\\') ) {s = 90;}

                         
                        input.seek(index21_109);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_12 = input.LA(1);

                         
                        int index21_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_12>='\u0000' && LA21_12<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 41;

                         
                        input.seek(index21_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_32 = input.LA(1);

                         
                        int index21_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( !isHead() )) ) {s = 70;}

                        else if ( (true) ) {s = 71;}

                         
                        input.seek(index21_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_34 = input.LA(1);

                         
                        int index21_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_34=='@') && (( isHead() ))) {s = 33;}

                        else if ( (LA21_34==' ') ) {s = 34;}

                        else if ( (LA21_34=='\t') ) {s = 35;}

                        else if ( ((LA21_34>='\u0000' && LA21_34<='\b')||(LA21_34>='\u000B' && LA21_34<='\f')||(LA21_34>='\u000E' && LA21_34<='\u001F')||(LA21_34>='!' && LA21_34<='\"')||LA21_34=='$'||(LA21_34>='&' && LA21_34<=',')||(LA21_34>='.' && LA21_34<='?')||(LA21_34>='A' && LA21_34<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_34=='-') ) {s = 36;}

                        else if ( (LA21_34=='\n'||LA21_34=='\r') && (( isHead() ))) {s = 37;}

                        else s = 70;

                         
                        input.seek(index21_34);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA21_28 = input.LA(1);

                         
                        int index21_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 36;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index21_28);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA21_15 = input.LA(1);

                         
                        int index21_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_15>='\u0000' && LA21_15<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 46;

                         
                        input.seek(index21_15);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA21_112 = input.LA(1);

                         
                        int index21_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_112>='0' && LA21_112<='9')||(LA21_112>='A' && LA21_112<='F')||(LA21_112>='a' && LA21_112<='f')) ) {s = 115;}

                        else if ( ((LA21_112>='\u0000' && LA21_112<='/')||(LA21_112>=':' && LA21_112<='@')||(LA21_112>='G' && LA21_112<='`')||(LA21_112>='g' && LA21_112<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_112);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA21_30 = input.LA(1);

                         
                        int index21_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_30=='\t'||LA21_30==' ') && (( isHead() ))) {s = 67;}

                        else if ( (LA21_30=='\r') && (( isHead() ))) {s = 68;}

                        else if ( (LA21_30=='\n') && (( isHead() ))) {s = 69;}

                        else if ( ((LA21_30>='\u0000' && LA21_30<='\b')||(LA21_30>='\u000B' && LA21_30<='\f')||(LA21_30>='\u000E' && LA21_30<='\u001F')||(LA21_30>='!' && LA21_30<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA21_27 = input.LA(1);

                         
                        int index21_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_27=='\t'||LA21_27==' ') ) {s = 65;}

                        else if ( (LA21_27=='\n'||LA21_27=='\r') && (( isHead() ))) {s = 66;}

                        else s = 29;

                         
                        input.seek(index21_27);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_7=='@') && (( isHead() ))) {s = 33;}

                        else if ( (LA21_7==' ') ) {s = 34;}

                        else if ( (LA21_7=='\t') ) {s = 35;}

                        else if ( ((LA21_7>='\u0000' && LA21_7<='\b')||(LA21_7>='\u000B' && LA21_7<='\f')||(LA21_7>='\u000E' && LA21_7<='\u001F')||(LA21_7>='!' && LA21_7<='\"')||LA21_7=='$'||(LA21_7>='&' && LA21_7<=',')||(LA21_7>='.' && LA21_7<='?')||(LA21_7>='A' && LA21_7<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_7=='-') ) {s = 36;}

                        else if ( (LA21_7=='\n'||LA21_7=='\r') && (( isHead() ))) {s = 37;}

                        else s = 32;

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA21_42 = input.LA(1);

                         
                        int index21_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_42=='\t'||LA21_42==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_42>='\u0000' && LA21_42<='\b')||(LA21_42>='\u000B' && LA21_42<='\f')||(LA21_42>='\u000E' && LA21_42<='\u001F')||LA21_42=='!'||(LA21_42>='$' && LA21_42<='\'')||LA21_42=='+'||(LA21_42>='-' && LA21_42<='9')||(LA21_42>=';' && LA21_42<='=')||(LA21_42>='?' && LA21_42<='Z')||(LA21_42>='^' && LA21_42<='z')||(LA21_42>='~' && LA21_42<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA21_42=='*'||LA21_42==':'||LA21_42=='>'||LA21_42=='['||LA21_42==']'||(LA21_42>='{' && LA21_42<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_42>='(' && LA21_42<=')')||LA21_42==',') && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( (LA21_42=='\n'||LA21_42=='\r'||(LA21_42>='\"' && LA21_42<='#')||LA21_42=='\\') && (( isHead() ))) {s = 23;}

                        else s = 73;

                         
                        input.seek(index21_42);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA21_10 = input.LA(1);

                         
                        int index21_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_10>='\u0000' && LA21_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 39;

                         
                        input.seek(index21_10);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA21_91 = input.LA(1);

                         
                        int index21_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_91=='\n'||LA21_91=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_91=='#') ) {s = 59;}

                        else if ( (LA21_91=='\"') ) {s = 61;}

                        else if ( ((LA21_91>='\u0000' && LA21_91<='\t')||(LA21_91>='\u000B' && LA21_91<='\f')||(LA21_91>='\u000E' && LA21_91<='!')||(LA21_91>='$' && LA21_91<='[')||(LA21_91>=']' && LA21_91<='\uFFFF')) ) {s = 58;}

                        else if ( (LA21_91=='\\') ) {s = 60;}

                         
                        input.seek(index21_91);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA21_102 = input.LA(1);

                         
                        int index21_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 113;}

                        else if ( (( isHead() )) ) {s = 23;}

                         
                        input.seek(index21_102);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA21_103 = input.LA(1);

                         
                        int index21_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_103=='\n'||LA21_103=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_103=='\"') ) {s = 88;}

                        else if ( ((LA21_103>='\u0000' && LA21_103<='\t')||(LA21_103>='\u000B' && LA21_103<='\f')||(LA21_103>='\u000E' && LA21_103<='!')||(LA21_103>='#' && LA21_103<='[')||(LA21_103>=']' && LA21_103<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_103=='\\') ) {s = 90;}

                         
                        input.seek(index21_103);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA21_51 = input.LA(1);

                         
                        int index21_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_51=='\t'||LA21_51==' ') ) {s = 47;}

                        else if ( ((LA21_51>='\u0000' && LA21_51<='\b')||(LA21_51>='\u000B' && LA21_51<='\f')||(LA21_51>='\u000E' && LA21_51<='\u001F')||LA21_51=='!'||(LA21_51>='$' && LA21_51<='\'')||LA21_51=='+'||(LA21_51>='-' && LA21_51<='9')||(LA21_51>=';' && LA21_51<='=')||(LA21_51>='?' && LA21_51<='Z')||(LA21_51>='^' && LA21_51<='z')||(LA21_51>='~' && LA21_51<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_51=='*'||LA21_51==':'||LA21_51=='>'||LA21_51=='['||LA21_51==']'||(LA21_51>='{' && LA21_51<='}')) ) {s = 50;}

                        else if ( ((LA21_51>='(' && LA21_51<=')')||LA21_51==',') ) {s = 51;}

                        else if ( (LA21_51=='\n'||LA21_51=='\r'||(LA21_51>='\"' && LA21_51<='#')||LA21_51=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_51);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA21_77 = input.LA(1);

                         
                        int index21_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_77=='\t'||LA21_77==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_77>='\u0000' && LA21_77<='\b')||(LA21_77>='\u000B' && LA21_77<='\f')||(LA21_77>='\u000E' && LA21_77<='\u001F')||LA21_77=='!'||(LA21_77>='$' && LA21_77<='\'')||LA21_77=='+'||(LA21_77>='-' && LA21_77<='9')||(LA21_77>=';' && LA21_77<='=')||(LA21_77>='?' && LA21_77<='Z')||(LA21_77>='^' && LA21_77<='z')||(LA21_77>='~' && LA21_77<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA21_77=='*'||LA21_77==':'||LA21_77=='>'||LA21_77=='['||LA21_77==']'||(LA21_77>='{' && LA21_77<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_77>='(' && LA21_77<=')')||LA21_77==',') && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( (LA21_77=='\n'||LA21_77=='\r'||(LA21_77>='\"' && LA21_77<='#')||LA21_77=='\\') && (( isHead() ))) {s = 23;}

                        else s = 73;

                         
                        input.seek(index21_77);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA21_110 = input.LA(1);

                         
                        int index21_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_110=='\n'||LA21_110=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_110=='\"') ) {s = 88;}

                        else if ( ((LA21_110>='\u0000' && LA21_110<='\t')||(LA21_110>='\u000B' && LA21_110<='\f')||(LA21_110>='\u000E' && LA21_110<='!')||(LA21_110>='#' && LA21_110<='[')||(LA21_110>=']' && LA21_110<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_110=='\\') ) {s = 90;}

                         
                        input.seek(index21_110);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA21_85 = input.LA(1);

                         
                        int index21_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_85=='\t'||LA21_85==' ') ) {s = 84;}

                        else if ( ((LA21_85>='\u0000' && LA21_85<='\b')||(LA21_85>='\u000B' && LA21_85<='\f')||(LA21_85>='\u000E' && LA21_85<='\u001F')||LA21_85=='!'||(LA21_85>='$' && LA21_85<='\'')||LA21_85=='+'||(LA21_85>='-' && LA21_85<='9')||(LA21_85>=';' && LA21_85<='=')||(LA21_85>='?' && LA21_85<='Z')||(LA21_85>='^' && LA21_85<='z')||(LA21_85>='~' && LA21_85<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_85=='*'||LA21_85==':'||LA21_85=='>'||LA21_85=='['||LA21_85==']'||(LA21_85>='{' && LA21_85<='}')) ) {s = 86;}

                        else if ( ((LA21_85>='(' && LA21_85<=')')||LA21_85==',') ) {s = 87;}

                        else if ( (LA21_85=='\n'||LA21_85=='\r'||(LA21_85>='\"' && LA21_85<='#')||LA21_85=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_85);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA21_50 = input.LA(1);

                         
                        int index21_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_50=='\t'||LA21_50==' ') ) {s = 47;}

                        else if ( ((LA21_50>='\u0000' && LA21_50<='\b')||(LA21_50>='\u000B' && LA21_50<='\f')||(LA21_50>='\u000E' && LA21_50<='\u001F')||LA21_50=='!'||(LA21_50>='$' && LA21_50<='\'')||LA21_50=='+'||(LA21_50>='-' && LA21_50<='9')||(LA21_50>=';' && LA21_50<='=')||(LA21_50>='?' && LA21_50<='Z')||(LA21_50>='^' && LA21_50<='z')||(LA21_50>='~' && LA21_50<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_50=='*'||LA21_50==':'||LA21_50=='>'||LA21_50=='['||LA21_50==']'||(LA21_50>='{' && LA21_50<='}')) ) {s = 50;}

                        else if ( ((LA21_50>='(' && LA21_50<=')')||LA21_50==',') ) {s = 51;}

                        else if ( (LA21_50=='\n'||LA21_50=='\r'||(LA21_50>='\"' && LA21_50<='#')||LA21_50=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_50);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA21_56 = input.LA(1);

                         
                        int index21_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_56=='\t'||LA21_56==' ') ) {s = 84;}

                        else if ( ((LA21_56>='\u0000' && LA21_56<='\b')||(LA21_56>='\u000B' && LA21_56<='\f')||(LA21_56>='\u000E' && LA21_56<='\u001F')||LA21_56=='!'||(LA21_56>='$' && LA21_56<='\'')||LA21_56=='+'||(LA21_56>='-' && LA21_56<='9')||(LA21_56>=';' && LA21_56<='=')||(LA21_56>='?' && LA21_56<='Z')||(LA21_56>='^' && LA21_56<='z')||(LA21_56>='~' && LA21_56<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_56=='*'||LA21_56==':'||LA21_56=='>'||LA21_56=='['||LA21_56==']'||(LA21_56>='{' && LA21_56<='}')) ) {s = 86;}

                        else if ( ((LA21_56>='(' && LA21_56<=')')||LA21_56==',') ) {s = 87;}

                        else if ( (LA21_56=='\n'||LA21_56=='\r'||(LA21_56>='\"' && LA21_56<='#')||LA21_56=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_56);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA21_60 = input.LA(1);

                         
                        int index21_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_60>='\u0000' && LA21_60<='!')||(LA21_60>='#' && LA21_60<='.')||(LA21_60>='0' && LA21_60<='[')||(LA21_60>=']' && LA21_60<='a')||(LA21_60>='c' && LA21_60<='e')||(LA21_60>='g' && LA21_60<='m')||(LA21_60>='o' && LA21_60<='q')||LA21_60=='s'||(LA21_60>='v' && LA21_60<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_60=='\"') ) {s = 91;}

                        else if ( (LA21_60=='\\') ) {s = 92;}

                        else if ( (LA21_60=='/') ) {s = 93;}

                        else if ( (LA21_60=='b') ) {s = 94;}

                        else if ( (LA21_60=='f') ) {s = 95;}

                        else if ( (LA21_60=='n') ) {s = 96;}

                        else if ( (LA21_60=='r') ) {s = 97;}

                        else if ( (LA21_60=='t') ) {s = 98;}

                        else if ( (LA21_60=='u') ) {s = 99;}

                         
                        input.seek(index21_60);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA21_76 = input.LA(1);

                         
                        int index21_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_76=='\t'||LA21_76==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_76>='\u0000' && LA21_76<='\b')||(LA21_76>='\u000B' && LA21_76<='\f')||(LA21_76>='\u000E' && LA21_76<='\u001F')||LA21_76=='!'||(LA21_76>='$' && LA21_76<='\'')||LA21_76=='+'||(LA21_76>='-' && LA21_76<='9')||(LA21_76>=';' && LA21_76<='=')||(LA21_76>='?' && LA21_76<='Z')||(LA21_76>='^' && LA21_76<='z')||(LA21_76>='~' && LA21_76<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA21_76=='*'||LA21_76==':'||LA21_76=='>'||LA21_76=='['||LA21_76==']'||(LA21_76>='{' && LA21_76<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_76>='(' && LA21_76<=')')||LA21_76==',') && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( (LA21_76=='\n'||LA21_76=='\r'||(LA21_76>='\"' && LA21_76<='#')||LA21_76=='\\') && (( isHead() ))) {s = 23;}

                        else s = 73;

                         
                        input.seek(index21_76);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA21_111 = input.LA(1);

                         
                        int index21_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_111>='\u0000' && LA21_111<='/')||(LA21_111>=':' && LA21_111<='@')||(LA21_111>='G' && LA21_111<='`')||(LA21_111>='g' && LA21_111<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_111>='0' && LA21_111<='9')||(LA21_111>='A' && LA21_111<='F')||(LA21_111>='a' && LA21_111<='f')) ) {s = 114;}

                         
                        input.seek(index21_111);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA21_13 = input.LA(1);

                         
                        int index21_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_13>='\u0000' && LA21_13<='\b')||(LA21_13>='\u000B' && LA21_13<='\f')||(LA21_13>='\u000E' && LA21_13<='\u001F')||LA21_13=='!'||(LA21_13>='$' && LA21_13<='[')||(LA21_13>=']' && LA21_13<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 42;}

                        else if ( ((LA21_13>='\t' && LA21_13<='\n')||LA21_13=='\r'||LA21_13==' '||LA21_13=='\"'||LA21_13=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_13=='#') && ((( isValue() )||( isHead() )))) {s = 44;}

                        else s = 43;

                         
                        input.seek(index21_13);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA21_87 = input.LA(1);

                         
                        int index21_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_87=='\t'||LA21_87==' ') ) {s = 84;}

                        else if ( ((LA21_87>='\u0000' && LA21_87<='\b')||(LA21_87>='\u000B' && LA21_87<='\f')||(LA21_87>='\u000E' && LA21_87<='\u001F')||LA21_87=='!'||(LA21_87>='$' && LA21_87<='\'')||LA21_87=='+'||(LA21_87>='-' && LA21_87<='9')||(LA21_87>=';' && LA21_87<='=')||(LA21_87>='?' && LA21_87<='Z')||(LA21_87>='^' && LA21_87<='z')||(LA21_87>='~' && LA21_87<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_87=='*'||LA21_87==':'||LA21_87=='>'||LA21_87=='['||LA21_87==']'||(LA21_87>='{' && LA21_87<='}')) ) {s = 86;}

                        else if ( ((LA21_87>='(' && LA21_87<=')')||LA21_87==',') ) {s = 87;}

                        else if ( (LA21_87=='\n'||LA21_87=='\r'||(LA21_87>='\"' && LA21_87<='#')||LA21_87=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_87);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA21_120 = input.LA(1);

                         
                        int index21_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_120=='\n'||LA21_120=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_120=='\"') ) {s = 88;}

                        else if ( ((LA21_120>='\u0000' && LA21_120<='\t')||(LA21_120>='\u000B' && LA21_120<='\f')||(LA21_120>='\u000E' && LA21_120<='!')||(LA21_120>='#' && LA21_120<='[')||(LA21_120>=']' && LA21_120<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_120=='\\') ) {s = 90;}

                         
                        input.seek(index21_120);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA21_17 = input.LA(1);

                         
                        int index21_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_17>='\u0000' && LA21_17<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 52;

                         
                        input.seek(index21_17);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA21_18 = input.LA(1);

                         
                        int index21_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_18>='\u0000' && LA21_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 53;

                         
                        input.seek(index21_18);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA21_58 = input.LA(1);

                         
                        int index21_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_58=='\"') ) {s = 61;}

                        else if ( (LA21_58=='#') ) {s = 59;}

                        else if ( (LA21_58=='\\') ) {s = 60;}

                        else if ( (LA21_58=='\n'||LA21_58=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_58>='\u0000' && LA21_58<='\t')||(LA21_58>='\u000B' && LA21_58<='\f')||(LA21_58>='\u000E' && LA21_58<='!')||(LA21_58>='$' && LA21_58<='[')||(LA21_58>=']' && LA21_58<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_58);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA21_20 = input.LA(1);

                         
                        int index21_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_20>='\u0000' && LA21_20<='\t')||(LA21_20>='\u000B' && LA21_20<='\f')||(LA21_20>='\u000E' && LA21_20<='!')||(LA21_20>='$' && LA21_20<='[')||(LA21_20>=']' && LA21_20<='\uFFFF')) ) {s = 58;}

                        else if ( (LA21_20=='\n'||LA21_20=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_20=='#') ) {s = 59;}

                        else if ( (LA21_20=='\\') ) {s = 60;}

                        else if ( (LA21_20=='\"') ) {s = 61;}

                         
                        input.seek(index21_20);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA21_54 = input.LA(1);

                         
                        int index21_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_54=='\t'||LA21_54==' ') ) {s = 84;}

                        else if ( ((LA21_54>='\u0000' && LA21_54<='\b')||(LA21_54>='\u000B' && LA21_54<='\f')||(LA21_54>='\u000E' && LA21_54<='\u001F')||LA21_54=='!'||(LA21_54>='$' && LA21_54<='\'')||LA21_54=='+'||(LA21_54>='-' && LA21_54<='9')||(LA21_54>=';' && LA21_54<='=')||(LA21_54>='?' && LA21_54<='Z')||(LA21_54>='^' && LA21_54<='z')||(LA21_54>='~' && LA21_54<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_54=='*'||LA21_54==':'||LA21_54=='>'||LA21_54=='['||LA21_54==']'||(LA21_54>='{' && LA21_54<='}')) ) {s = 86;}

                        else if ( ((LA21_54>='(' && LA21_54<=')')||LA21_54==',') ) {s = 87;}

                        else if ( (LA21_54=='\n'||LA21_54=='\r'||(LA21_54>='\"' && LA21_54<='#')||LA21_54=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_54);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA21_80 = input.LA(1);

                         
                        int index21_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_80=='\n'||LA21_80=='\r'||(LA21_80>='\"' && LA21_80<='#')||LA21_80=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_80=='\t'||LA21_80==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_80>='\u0000' && LA21_80<='\b')||(LA21_80>='\u000B' && LA21_80<='\f')||(LA21_80>='\u000E' && LA21_80<='\u001F')||LA21_80=='!'||(LA21_80>='$' && LA21_80<='\'')||LA21_80=='+'||(LA21_80>='-' && LA21_80<='9')||(LA21_80>=';' && LA21_80<='=')||(LA21_80>='?' && LA21_80<='Z')||(LA21_80>='^' && LA21_80<='z')||(LA21_80>='~' && LA21_80<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_80=='*'||LA21_80==':'||LA21_80=='>'||LA21_80=='['||LA21_80==']'||(LA21_80>='{' && LA21_80<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_80>='(' && LA21_80<=')')||LA21_80==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 73;

                         
                        input.seek(index21_80);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA21_105 = input.LA(1);

                         
                        int index21_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_105=='\n'||LA21_105=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_105=='\"') ) {s = 88;}

                        else if ( ((LA21_105>='\u0000' && LA21_105<='\t')||(LA21_105>='\u000B' && LA21_105<='\f')||(LA21_105>='\u000E' && LA21_105<='!')||(LA21_105>='#' && LA21_105<='[')||(LA21_105>=']' && LA21_105<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_105=='\\') ) {s = 90;}

                         
                        input.seek(index21_105);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA21_59 = input.LA(1);

                         
                        int index21_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_59=='\"') ) {s = 88;}

                        else if ( (LA21_59=='\n'||LA21_59=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_59>='\u0000' && LA21_59<='\t')||(LA21_59>='\u000B' && LA21_59<='\f')||(LA21_59>='\u000E' && LA21_59<='!')||(LA21_59>='#' && LA21_59<='[')||(LA21_59>=']' && LA21_59<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_59=='\\') ) {s = 90;}

                         
                        input.seek(index21_59);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA21_108 = input.LA(1);

                         
                        int index21_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_108=='\n'||LA21_108=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_108=='\"') ) {s = 88;}

                        else if ( ((LA21_108>='\u0000' && LA21_108<='\t')||(LA21_108>='\u000B' && LA21_108<='\f')||(LA21_108>='\u000E' && LA21_108<='!')||(LA21_108>='#' && LA21_108<='[')||(LA21_108>=']' && LA21_108<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_108=='\\') ) {s = 90;}

                         
                        input.seek(index21_108);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA21_101 = input.LA(1);

                         
                        int index21_101 = input.index();
                        input.rewind();
                        s = -1;
                        s = 102;

                         
                        input.seek(index21_101);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA21_93 = input.LA(1);

                         
                        int index21_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_93=='\"') ) {s = 61;}

                        else if ( (LA21_93=='#') ) {s = 59;}

                        else if ( (LA21_93=='\\') ) {s = 60;}

                        else if ( (LA21_93=='\n'||LA21_93=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_93>='\u0000' && LA21_93<='\t')||(LA21_93>='\u000B' && LA21_93<='\f')||(LA21_93>='\u000E' && LA21_93<='!')||(LA21_93>='$' && LA21_93<='[')||(LA21_93>=']' && LA21_93<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_93);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA21_118 = input.LA(1);

                         
                        int index21_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_118>='\u0000' && LA21_118<='/')||(LA21_118>=':' && LA21_118<='@')||(LA21_118>='G' && LA21_118<='`')||(LA21_118>='g' && LA21_118<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_118>='0' && LA21_118<='9')||(LA21_118>='A' && LA21_118<='F')||(LA21_118>='a' && LA21_118<='f')) ) {s = 120;}

                         
                        input.seek(index21_118);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA21_11 = input.LA(1);

                         
                        int index21_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_11>='\u0000' && LA21_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 40;

                         
                        input.seek(index21_11);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA21_78 = input.LA(1);

                         
                        int index21_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_78=='\n'||LA21_78=='\r'||(LA21_78>='\"' && LA21_78<='#')||LA21_78=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_78=='\t'||LA21_78==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_78>='\u0000' && LA21_78<='\b')||(LA21_78>='\u000B' && LA21_78<='\f')||(LA21_78>='\u000E' && LA21_78<='\u001F')||LA21_78=='!'||(LA21_78>='$' && LA21_78<='\'')||LA21_78=='+'||(LA21_78>='-' && LA21_78<='9')||(LA21_78>=';' && LA21_78<='=')||(LA21_78>='?' && LA21_78<='Z')||(LA21_78>='^' && LA21_78<='z')||(LA21_78>='~' && LA21_78<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_78=='*'||LA21_78==':'||LA21_78=='>'||LA21_78=='['||LA21_78==']'||(LA21_78>='{' && LA21_78<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_78>='(' && LA21_78<=')')||LA21_78==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 73;

                         
                        input.seek(index21_78);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA21_107 = input.LA(1);

                         
                        int index21_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_107=='\n'||LA21_107=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_107=='\"') ) {s = 88;}

                        else if ( ((LA21_107>='\u0000' && LA21_107<='\t')||(LA21_107>='\u000B' && LA21_107<='\f')||(LA21_107>='\u000E' && LA21_107<='!')||(LA21_107>='#' && LA21_107<='[')||(LA21_107>=']' && LA21_107<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_107=='\\') ) {s = 90;}

                         
                        input.seek(index21_107);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA21_47 = input.LA(1);

                         
                        int index21_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_47=='\t'||LA21_47==' ') ) {s = 47;}

                        else if ( ((LA21_47>='\u0000' && LA21_47<='\b')||(LA21_47>='\u000B' && LA21_47<='\f')||(LA21_47>='\u000E' && LA21_47<='\u001F')||LA21_47=='!'||(LA21_47>='$' && LA21_47<='\'')||LA21_47=='+'||(LA21_47>='-' && LA21_47<='9')||(LA21_47>=';' && LA21_47<='=')||(LA21_47>='?' && LA21_47<='Z')||(LA21_47>='^' && LA21_47<='z')||(LA21_47>='~' && LA21_47<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_47=='*'||LA21_47==':'||LA21_47=='>'||LA21_47=='['||LA21_47==']'||(LA21_47>='{' && LA21_47<='}')) ) {s = 50;}

                        else if ( ((LA21_47>='(' && LA21_47<=')')||LA21_47==',') ) {s = 51;}

                        else if ( (LA21_47=='\n'||LA21_47=='\r'||(LA21_47>='\"' && LA21_47<='#')||LA21_47=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA21_74 = input.LA(1);

                         
                        int index21_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_74=='\t'||LA21_74==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_74>='\u0000' && LA21_74<='\b')||(LA21_74>='\u000B' && LA21_74<='\f')||(LA21_74>='\u000E' && LA21_74<='\u001F')||LA21_74=='!'||(LA21_74>='$' && LA21_74<='\'')||LA21_74=='+'||(LA21_74>='-' && LA21_74<='9')||(LA21_74>=';' && LA21_74<='=')||(LA21_74>='?' && LA21_74<='Z')||(LA21_74>='^' && LA21_74<='z')||(LA21_74>='~' && LA21_74<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA21_74=='*'||LA21_74==':'||LA21_74=='>'||LA21_74=='['||LA21_74==']'||(LA21_74>='{' && LA21_74<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_74>='(' && LA21_74<=')')||LA21_74==',') && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( (LA21_74=='\n'||LA21_74=='\r'||(LA21_74>='\"' && LA21_74<='#')||LA21_74=='\\') && (( isHead() ))) {s = 23;}

                        else s = 73;

                         
                        input.seek(index21_74);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA21_67 = input.LA(1);

                         
                        int index21_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_67=='\r') && (( isHead() ))) {s = 68;}

                        else if ( (LA21_67=='\n') && (( isHead() ))) {s = 69;}

                        else if ( (LA21_67=='\t'||LA21_67==' ') && (( isHead() ))) {s = 67;}

                        else if ( ((LA21_67>='\u0000' && LA21_67<='\b')||(LA21_67>='\u000B' && LA21_67<='\f')||(LA21_67>='\u000E' && LA21_67<='\u001F')||(LA21_67>='!' && LA21_67<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_67);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA21_14 = input.LA(1);

                         
                        int index21_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_14>='\u0000' && LA21_14<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 45;

                         
                        input.seek(index21_14);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA21_115 = input.LA(1);

                         
                        int index21_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_115>='\u0000' && LA21_115<='/')||(LA21_115>=':' && LA21_115<='@')||(LA21_115>='G' && LA21_115<='`')||(LA21_115>='g' && LA21_115<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_115>='0' && LA21_115<='9')||(LA21_115>='A' && LA21_115<='F')||(LA21_115>='a' && LA21_115<='f')) ) {s = 117;}

                         
                        input.seek(index21_115);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA21_106 = input.LA(1);

                         
                        int index21_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_106=='\n'||LA21_106=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_106=='\"') ) {s = 88;}

                        else if ( ((LA21_106>='\u0000' && LA21_106<='\t')||(LA21_106>='\u000B' && LA21_106<='\f')||(LA21_106>='\u000E' && LA21_106<='!')||(LA21_106>='#' && LA21_106<='[')||(LA21_106>=']' && LA21_106<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_106=='\\') ) {s = 90;}

                         
                        input.seek(index21_106);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA21_49 = input.LA(1);

                         
                        int index21_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_49=='\t'||LA21_49==' ') ) {s = 47;}

                        else if ( ((LA21_49>='\u0000' && LA21_49<='\b')||(LA21_49>='\u000B' && LA21_49<='\f')||(LA21_49>='\u000E' && LA21_49<='\u001F')||LA21_49=='!'||(LA21_49>='$' && LA21_49<='\'')||LA21_49=='+'||(LA21_49>='-' && LA21_49<='9')||(LA21_49>=';' && LA21_49<='=')||(LA21_49>='?' && LA21_49<='Z')||(LA21_49>='^' && LA21_49<='z')||(LA21_49>='~' && LA21_49<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_49=='*'||LA21_49==':'||LA21_49=='>'||LA21_49=='['||LA21_49==']'||(LA21_49>='{' && LA21_49<='}')) ) {s = 50;}

                        else if ( ((LA21_49>='(' && LA21_49<=')')||LA21_49==',') ) {s = 51;}

                        else if ( (LA21_49=='\n'||LA21_49=='\r'||(LA21_49>='\"' && LA21_49<='#')||LA21_49=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_49);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA21_75 = input.LA(1);

                         
                        int index21_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_75=='\t'||LA21_75==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_75>='\u0000' && LA21_75<='\b')||(LA21_75>='\u000B' && LA21_75<='\f')||(LA21_75>='\u000E' && LA21_75<='\u001F')||LA21_75=='!'||(LA21_75>='$' && LA21_75<='\'')||LA21_75=='+'||(LA21_75>='-' && LA21_75<='9')||(LA21_75>=';' && LA21_75<='=')||(LA21_75>='?' && LA21_75<='Z')||(LA21_75>='^' && LA21_75<='z')||(LA21_75>='~' && LA21_75<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA21_75=='*'||LA21_75==':'||LA21_75=='>'||LA21_75=='['||LA21_75==']'||(LA21_75>='{' && LA21_75<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_75>='(' && LA21_75<=')')||LA21_75==',') && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( (LA21_75=='\n'||LA21_75=='\r'||(LA21_75>='\"' && LA21_75<='#')||LA21_75=='\\') && (( isHead() ))) {s = 23;}

                        else s = 73;

                         
                        input.seek(index21_75);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA21_96 = input.LA(1);

                         
                        int index21_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_96=='\n'||LA21_96=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_96=='#') ) {s = 59;}

                        else if ( (LA21_96=='\"') ) {s = 61;}

                        else if ( ((LA21_96>='\u0000' && LA21_96<='\t')||(LA21_96>='\u000B' && LA21_96<='\f')||(LA21_96>='\u000E' && LA21_96<='!')||(LA21_96>='$' && LA21_96<='[')||(LA21_96>=']' && LA21_96<='\uFFFF')) ) {s = 58;}

                        else if ( (LA21_96=='\\') ) {s = 60;}

                         
                        input.seek(index21_96);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA21_69 = input.LA(1);

                         
                        int index21_69 = input.index();
                        input.rewind();
                        s = -1;
                        s = 102;

                         
                        input.seek(index21_69);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_9=='\t'||LA21_9==' ') ) {s = 35;}

                        else if ( ((LA21_9>='\u0000' && LA21_9<='\b')||(LA21_9>='\u000B' && LA21_9<='\f')||(LA21_9>='\u000E' && LA21_9<='\u001F')||(LA21_9>='!' && LA21_9<='\"')||LA21_9=='$'||(LA21_9>='&' && LA21_9<=',')||(LA21_9>='.' && LA21_9<='?')||(LA21_9>='A' && LA21_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_9=='\n'||LA21_9=='\r') && (( isHead() ))) {s = 37;}

                        else s = 32;

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA21_92 = input.LA(1);

                         
                        int index21_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_92=='\"') ) {s = 61;}

                        else if ( (LA21_92=='#') ) {s = 59;}

                        else if ( (LA21_92=='\\') ) {s = 60;}

                        else if ( (LA21_92=='\n'||LA21_92=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_92>='\u0000' && LA21_92<='\t')||(LA21_92>='\u000B' && LA21_92<='\f')||(LA21_92>='\u000E' && LA21_92<='!')||(LA21_92>='$' && LA21_92<='[')||(LA21_92>=']' && LA21_92<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_92);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA21_84 = input.LA(1);

                         
                        int index21_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_84=='\t'||LA21_84==' ') ) {s = 84;}

                        else if ( ((LA21_84>='\u0000' && LA21_84<='\b')||(LA21_84>='\u000B' && LA21_84<='\f')||(LA21_84>='\u000E' && LA21_84<='\u001F')||LA21_84=='!'||(LA21_84>='$' && LA21_84<='\'')||LA21_84=='+'||(LA21_84>='-' && LA21_84<='9')||(LA21_84>=';' && LA21_84<='=')||(LA21_84>='?' && LA21_84<='Z')||(LA21_84>='^' && LA21_84<='z')||(LA21_84>='~' && LA21_84<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_84=='*'||LA21_84==':'||LA21_84=='>'||LA21_84=='['||LA21_84==']'||(LA21_84>='{' && LA21_84<='}')) ) {s = 86;}

                        else if ( ((LA21_84>='(' && LA21_84<=')')||LA21_84==',') ) {s = 87;}

                        else if ( (LA21_84=='\n'||LA21_84=='\r'||(LA21_84>='\"' && LA21_84<='#')||LA21_84=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_84);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA21_38 = input.LA(1);

                         
                        int index21_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 33;}

                        else if ( (true) ) {s = 72;}

                         
                        input.seek(index21_38);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA21_116 = input.LA(1);

                         
                        int index21_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_116>='\u0000' && LA21_116<='/')||(LA21_116>=':' && LA21_116<='@')||(LA21_116>='G' && LA21_116<='`')||(LA21_116>='g' && LA21_116<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_116>='0' && LA21_116<='9')||(LA21_116>='A' && LA21_116<='F')||(LA21_116>='a' && LA21_116<='f')) ) {s = 118;}

                         
                        input.seek(index21_116);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA21_97 = input.LA(1);

                         
                        int index21_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_97=='\"') ) {s = 61;}

                        else if ( (LA21_97=='#') ) {s = 59;}

                        else if ( (LA21_97=='\\') ) {s = 60;}

                        else if ( (LA21_97=='\n'||LA21_97=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_97>='\u0000' && LA21_97<='\t')||(LA21_97>='\u000B' && LA21_97<='\f')||(LA21_97>='\u000E' && LA21_97<='!')||(LA21_97>='$' && LA21_97<='[')||(LA21_97>=']' && LA21_97<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_97);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA21_52 = input.LA(1);

                         
                        int index21_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 83;}

                        else if ( (( isValue() )) ) {s = 62;}

                         
                        input.seek(index21_52);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA21_61 = input.LA(1);

                         
                        int index21_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_61>='\u0000' && LA21_61<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 100;

                         
                        input.seek(index21_61);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA21_98 = input.LA(1);

                         
                        int index21_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_98=='\"') ) {s = 61;}

                        else if ( (LA21_98=='#') ) {s = 59;}

                        else if ( (LA21_98=='\\') ) {s = 60;}

                        else if ( (LA21_98=='\n'||LA21_98=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_98>='\u0000' && LA21_98<='\t')||(LA21_98>='\u000B' && LA21_98<='\f')||(LA21_98>='\u000E' && LA21_98<='!')||(LA21_98>='$' && LA21_98<='[')||(LA21_98>=']' && LA21_98<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_98);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA21_99 = input.LA(1);

                         
                        int index21_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_99>='0' && LA21_99<='9')||(LA21_99>='A' && LA21_99<='F')||(LA21_99>='a' && LA21_99<='f')) ) {s = 112;}

                        else if ( ((LA21_99>='\u0000' && LA21_99<='/')||(LA21_99>=':' && LA21_99<='@')||(LA21_99>='G' && LA21_99<='`')||(LA21_99>='g' && LA21_99<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_99);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA21_16 = input.LA(1);

                         
                        int index21_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_16=='\t'||LA21_16==' ') ) {s = 47;}

                        else if ( (LA21_16=='\n'||LA21_16=='\r'||(LA21_16>='\"' && LA21_16<='#')||LA21_16=='\\') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_16>='\u0000' && LA21_16<='\b')||(LA21_16>='\u000B' && LA21_16<='\f')||(LA21_16>='\u000E' && LA21_16<='\u001F')||LA21_16=='!'||(LA21_16>='$' && LA21_16<='\'')||LA21_16=='+'||(LA21_16>='-' && LA21_16<='9')||(LA21_16>=';' && LA21_16<='=')||(LA21_16>='?' && LA21_16<='Z')||(LA21_16>='^' && LA21_16<='z')||(LA21_16>='~' && LA21_16<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_16=='*'||LA21_16==':'||LA21_16=='>'||LA21_16=='['||LA21_16==']'||(LA21_16>='{' && LA21_16<='}')) ) {s = 50;}

                        else if ( ((LA21_16>='(' && LA21_16<=')')||LA21_16==',') ) {s = 51;}

                        else s = 48;

                         
                        input.seek(index21_16);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA21_21 = input.LA(1);

                         
                        int index21_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_21=='\t'||LA21_21==' ') ) {s = 47;}

                        else if ( (LA21_21=='\n'||LA21_21=='\r'||(LA21_21>='\"' && LA21_21<='#')||LA21_21=='\\') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_21>='\u0000' && LA21_21<='\b')||(LA21_21>='\u000B' && LA21_21<='\f')||(LA21_21>='\u000E' && LA21_21<='\u001F')||LA21_21=='!'||(LA21_21>='$' && LA21_21<='\'')||LA21_21=='+'||(LA21_21>='-' && LA21_21<='9')||(LA21_21>=';' && LA21_21<='=')||(LA21_21>='?' && LA21_21<='Z')||(LA21_21>='^' && LA21_21<='z')||(LA21_21>='~' && LA21_21<='\uFFFF')) ) {s = 49;}

                        else if ( (LA21_21=='*'||LA21_21==':'||LA21_21=='>'||LA21_21=='['||LA21_21==']'||(LA21_21>='{' && LA21_21<='}')) ) {s = 50;}

                        else if ( ((LA21_21>='(' && LA21_21<=')')||LA21_21==',') ) {s = 51;}

                        else s = 29;

                         
                        input.seek(index21_21);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA21_57 = input.LA(1);

                         
                        int index21_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_57=='\t'||LA21_57==' ') ) {s = 84;}

                        else if ( ((LA21_57>='\u0000' && LA21_57<='\b')||(LA21_57>='\u000B' && LA21_57<='\f')||(LA21_57>='\u000E' && LA21_57<='\u001F')||LA21_57=='!'||(LA21_57>='$' && LA21_57<='\'')||LA21_57=='+'||(LA21_57>='-' && LA21_57<='9')||(LA21_57>=';' && LA21_57<='=')||(LA21_57>='?' && LA21_57<='Z')||(LA21_57>='^' && LA21_57<='z')||(LA21_57>='~' && LA21_57<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_57=='*'||LA21_57==':'||LA21_57=='>'||LA21_57=='['||LA21_57==']'||(LA21_57>='{' && LA21_57<='}')) ) {s = 86;}

                        else if ( ((LA21_57>='(' && LA21_57<=')')||LA21_57==',') ) {s = 87;}

                        else if ( (LA21_57=='\n'||LA21_57=='\r'||(LA21_57>='\"' && LA21_57<='#')||LA21_57=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_57);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA21_95 = input.LA(1);

                         
                        int index21_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_95=='\"') ) {s = 61;}

                        else if ( (LA21_95=='#') ) {s = 59;}

                        else if ( (LA21_95=='\\') ) {s = 60;}

                        else if ( (LA21_95=='\n'||LA21_95=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_95>='\u0000' && LA21_95<='\t')||(LA21_95>='\u000B' && LA21_95<='\f')||(LA21_95>='\u000E' && LA21_95<='!')||(LA21_95>='$' && LA21_95<='[')||(LA21_95>=']' && LA21_95<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_95);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_6=='>') && (( isHead() ))) {s = 30;}

                        else if ( ((LA21_6>='\u0000' && LA21_6<='=')||(LA21_6>='?' && LA21_6<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 31;

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA21_19 = input.LA(1);

                         
                        int index21_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_19>='\u0000' && LA21_19<='\b')||(LA21_19>='\u000B' && LA21_19<='\f')||(LA21_19>='\u000E' && LA21_19<='\u001F')||LA21_19=='!'||(LA21_19>='$' && LA21_19<='\'')||LA21_19=='+'||(LA21_19>='-' && LA21_19<='9')||(LA21_19>=';' && LA21_19<='=')||(LA21_19>='?' && LA21_19<='Z')||(LA21_19>='^' && LA21_19<='z')||(LA21_19>='~' && LA21_19<='\uFFFF')) ) {s = 54;}

                        else if ( (LA21_19=='\n'||LA21_19=='\r'||LA21_19=='\"'||LA21_19=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_19=='#') && ((( isValue() )||( isHead() )))) {s = 44;}

                        else if ( (LA21_19=='\t'||LA21_19==' ') ) {s = 47;}

                        else if ( (LA21_19=='*'||LA21_19==':'||LA21_19=='>'||LA21_19=='['||LA21_19==']'||(LA21_19>='{' && LA21_19<='}')) ) {s = 56;}

                        else if ( ((LA21_19>='(' && LA21_19<=')')||LA21_19==',') ) {s = 57;}

                        else s = 55;

                         
                        input.seek(index21_19);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA21_44 = input.LA(1);

                         
                        int index21_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_44=='\t'||LA21_44==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA21_44=='\n'||LA21_44=='\r'||(LA21_44>='\"' && LA21_44<='#')||LA21_44=='\\') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_44>='\u0000' && LA21_44<='\b')||(LA21_44>='\u000B' && LA21_44<='\f')||(LA21_44>='\u000E' && LA21_44<='\u001F')||LA21_44=='!'||(LA21_44>='$' && LA21_44<='\'')||LA21_44=='+'||(LA21_44>='-' && LA21_44<='9')||(LA21_44>=';' && LA21_44<='=')||(LA21_44>='?' && LA21_44<='Z')||(LA21_44>='^' && LA21_44<='z')||(LA21_44>='~' && LA21_44<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_44=='*'||LA21_44==':'||LA21_44=='>'||LA21_44=='['||LA21_44==']'||(LA21_44>='{' && LA21_44<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_44>='(' && LA21_44<=')')||LA21_44==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 73;

                         
                        input.seek(index21_44);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA21_68 = input.LA(1);

                         
                        int index21_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_68=='\n') && (( isHead() ))) {s = 101;}

                        else s = 102;

                         
                        input.seek(index21_68);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA21_65 = input.LA(1);

                         
                        int index21_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_65=='\t'||LA21_65==' ') ) {s = 65;}

                        else if ( (LA21_65=='\n'||LA21_65=='\r') && (( isHead() ))) {s = 66;}

                        else s = 82;

                         
                        input.seek(index21_65);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA21_35 = input.LA(1);

                         
                        int index21_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_35=='\t'||LA21_35==' ') ) {s = 35;}

                        else if ( ((LA21_35>='\u0000' && LA21_35<='\b')||(LA21_35>='\u000B' && LA21_35<='\f')||(LA21_35>='\u000E' && LA21_35<='\u001F')||(LA21_35>='!' && LA21_35<='\"')||LA21_35=='$'||(LA21_35>='&' && LA21_35<=',')||(LA21_35>='.' && LA21_35<='?')||(LA21_35>='A' && LA21_35<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_35=='\n'||LA21_35=='\r') && (( isHead() ))) {s = 37;}

                        else s = 70;

                         
                        input.seek(index21_35);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA21_81 = input.LA(1);

                         
                        int index21_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_81=='\n'||LA21_81=='\r'||(LA21_81>='\"' && LA21_81<='#')||LA21_81=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_81=='\t'||LA21_81==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_81>='\u0000' && LA21_81<='\b')||(LA21_81>='\u000B' && LA21_81<='\f')||(LA21_81>='\u000E' && LA21_81<='\u001F')||LA21_81=='!'||(LA21_81>='$' && LA21_81<='\'')||LA21_81=='+'||(LA21_81>='-' && LA21_81<='9')||(LA21_81>=';' && LA21_81<='=')||(LA21_81>='?' && LA21_81<='Z')||(LA21_81>='^' && LA21_81<='z')||(LA21_81>='~' && LA21_81<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_81=='*'||LA21_81==':'||LA21_81=='>'||LA21_81=='['||LA21_81==']'||(LA21_81>='{' && LA21_81<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_81>='(' && LA21_81<=')')||LA21_81==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 73;

                         
                        input.seek(index21_81);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA21_90 = input.LA(1);

                         
                        int index21_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_90>='\u0000' && LA21_90<='!')||(LA21_90>='#' && LA21_90<='.')||(LA21_90>='0' && LA21_90<='[')||(LA21_90>=']' && LA21_90<='a')||(LA21_90>='c' && LA21_90<='e')||(LA21_90>='g' && LA21_90<='m')||(LA21_90>='o' && LA21_90<='q')||LA21_90=='s'||(LA21_90>='v' && LA21_90<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_90=='\"') ) {s = 103;}

                        else if ( (LA21_90=='\\') ) {s = 104;}

                        else if ( (LA21_90=='/') ) {s = 105;}

                        else if ( (LA21_90=='b') ) {s = 106;}

                        else if ( (LA21_90=='f') ) {s = 107;}

                        else if ( (LA21_90=='n') ) {s = 108;}

                        else if ( (LA21_90=='r') ) {s = 109;}

                        else if ( (LA21_90=='t') ) {s = 110;}

                        else if ( (LA21_90=='u') ) {s = 111;}

                         
                        input.seek(index21_90);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA21_114 = input.LA(1);

                         
                        int index21_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_114>='0' && LA21_114<='9')||(LA21_114>='A' && LA21_114<='F')||(LA21_114>='a' && LA21_114<='f')) ) {s = 116;}

                        else if ( ((LA21_114>='\u0000' && LA21_114<='/')||(LA21_114>=':' && LA21_114<='@')||(LA21_114>='G' && LA21_114<='`')||(LA21_114>='g' && LA21_114<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_114);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA21_86 = input.LA(1);

                         
                        int index21_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_86=='\t'||LA21_86==' ') ) {s = 84;}

                        else if ( ((LA21_86>='\u0000' && LA21_86<='\b')||(LA21_86>='\u000B' && LA21_86<='\f')||(LA21_86>='\u000E' && LA21_86<='\u001F')||LA21_86=='!'||(LA21_86>='$' && LA21_86<='\'')||LA21_86=='+'||(LA21_86>='-' && LA21_86<='9')||(LA21_86>=';' && LA21_86<='=')||(LA21_86>='?' && LA21_86<='Z')||(LA21_86>='^' && LA21_86<='z')||(LA21_86>='~' && LA21_86<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_86=='*'||LA21_86==':'||LA21_86=='>'||LA21_86=='['||LA21_86==']'||(LA21_86>='{' && LA21_86<='}')) ) {s = 86;}

                        else if ( ((LA21_86>='(' && LA21_86<=')')||LA21_86==',') ) {s = 87;}

                        else if ( (LA21_86=='\n'||LA21_86=='\r'||(LA21_86>='\"' && LA21_86<='#')||LA21_86=='\\') && (( isHead() ))) {s = 23;}

                        else s = 82;

                         
                        input.seek(index21_86);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA21_79 = input.LA(1);

                         
                        int index21_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_79=='\n'||LA21_79=='\r'||(LA21_79>='\"' && LA21_79<='#')||LA21_79=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_79=='\t'||LA21_79==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_79>='\u0000' && LA21_79<='\b')||(LA21_79>='\u000B' && LA21_79<='\f')||(LA21_79>='\u000E' && LA21_79<='\u001F')||LA21_79=='!'||(LA21_79>='$' && LA21_79<='\'')||LA21_79=='+'||(LA21_79>='-' && LA21_79<='9')||(LA21_79>=';' && LA21_79<='=')||(LA21_79>='?' && LA21_79<='Z')||(LA21_79>='^' && LA21_79<='z')||(LA21_79>='~' && LA21_79<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_79=='*'||LA21_79==':'||LA21_79=='>'||LA21_79=='['||LA21_79==']'||(LA21_79>='{' && LA21_79<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_79>='(' && LA21_79<=')')||LA21_79==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 73;

                         
                        input.seek(index21_79);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA21_94 = input.LA(1);

                         
                        int index21_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_94=='\"') ) {s = 61;}

                        else if ( (LA21_94=='#') ) {s = 59;}

                        else if ( (LA21_94=='\\') ) {s = 60;}

                        else if ( (LA21_94=='\n'||LA21_94=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_94>='\u0000' && LA21_94<='\t')||(LA21_94>='\u000B' && LA21_94<='\f')||(LA21_94>='\u000E' && LA21_94<='!')||(LA21_94>='$' && LA21_94<='[')||(LA21_94>=']' && LA21_94<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index21_94);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_0=='#') ) {s = 1;}

                        else if ( (LA21_0=='%') ) {s = 2;}

                        else if ( (LA21_0=='\r') ) {s = 3;}

                        else if ( (LA21_0=='\n') ) {s = 4;}

                        else if ( (LA21_0=='-') ) {s = 5;}

                        else if ( (LA21_0=='>') ) {s = 6;}

                        else if ( (LA21_0==' ') ) {s = 7;}

                        else if ( (LA21_0=='@') ) {s = 8;}

                        else if ( (LA21_0=='\t') ) {s = 9;}

                        else if ( (LA21_0=='(') ) {s = 10;}

                        else if ( (LA21_0==')') ) {s = 11;}

                        else if ( (LA21_0==',') ) {s = 12;}

                        else if ( (LA21_0==':') ) {s = 13;}

                        else if ( (LA21_0=='|') ) {s = 14;}

                        else if ( (LA21_0=='*') ) {s = 15;}

                        else if ( (LA21_0=='+') ) {s = 16;}

                        else if ( (LA21_0=='[') ) {s = 17;}

                        else if ( (LA21_0==']') ) {s = 18;}

                        else if ( (LA21_0=='?') ) {s = 19;}

                        else if ( (LA21_0=='\"') ) {s = 20;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||LA21_0=='$'||LA21_0=='&'||(LA21_0>='.' && LA21_0<='9')||(LA21_0>=';' && LA21_0<='=')||(LA21_0>='A' && LA21_0<='Z')||(LA21_0>='^' && LA21_0<='z')||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 21;}

                        else if ( (LA21_0=='{') && ((( isValue() )||( isHead() )))) {s = 22;}

                        else if ( (LA21_0=='\''||LA21_0=='\\'||LA21_0=='}') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_0);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA21_26 = input.LA(1);

                         
                        int index21_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 37;}

                         
                        input.seek(index21_26);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA21_25 = input.LA(1);

                         
                        int index21_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 37;}

                         
                        input.seek(index21_25);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA21_63 = input.LA(1);

                         
                        int index21_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 37;}

                         
                        input.seek(index21_63);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA21_88 = input.LA(1);

                         
                        int index21_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_88>='\u0000' && LA21_88<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 100;

                         
                        input.seek(index21_88);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA21_117 = input.LA(1);

                         
                        int index21_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_117>='\u0000' && LA21_117<='/')||(LA21_117>=':' && LA21_117<='@')||(LA21_117>='G' && LA21_117<='`')||(LA21_117>='g' && LA21_117<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_117>='0' && LA21_117<='9')||(LA21_117>='A' && LA21_117<='F')||(LA21_117>='a' && LA21_117<='f')) ) {s = 119;}

                         
                        input.seek(index21_117);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA21_89 = input.LA(1);

                         
                        int index21_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_89=='\n'||LA21_89=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_89=='\"') ) {s = 88;}

                        else if ( ((LA21_89>='\u0000' && LA21_89<='\t')||(LA21_89>='\u000B' && LA21_89<='\f')||(LA21_89>='\u000E' && LA21_89<='!')||(LA21_89>='#' && LA21_89<='[')||(LA21_89>=']' && LA21_89<='\uFFFF')) ) {s = 89;}

                        else if ( (LA21_89=='\\') ) {s = 90;}

                         
                        input.seek(index21_89);
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
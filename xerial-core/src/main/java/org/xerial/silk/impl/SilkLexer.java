// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-15 18:53:41

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
    public static final int LineComment=15;
    public static final int Colon=30;
    public static final int At=34;
    public static final int DataLineBody=25;
    public static final int KeyValuePair=13;
    public static final int Star=33;
    public static final int Preamble=16;
    public static final int Seq=31;
    public static final int FunctionIndent=23;
    public static final int Indicator=48;
    public static final int RParen=28;
    public static final int UnicodeChar=42;
    public static final int BlankLine=24;
    public static final int MultiLineSeparator=20;
    public static final int Silk=4;
    public static final int StringChar=44;
    public static final int LineBreak=18;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=27;
    public static final int String=47;
    public static final int LineBreakChar=17;
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
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:144:43: WhiteSpace
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
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:48: WhiteSpace
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
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:147:28: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:148:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:149:29: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\"')||(LA10_0>='$' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    break loop10;
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
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            int DataLineBody1Start264 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start264, getCharIndex()-1);
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:153:30: ( LineBreak | LineComment )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            else if ( (LA12_0=='#') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
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
            int alt13=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt13=1;
                }
                break;
            case '\\':
                {
                alt13=2;
                }
                break;
            case '/':
                {
                alt13=3;
                }
                break;
            case 'b':
                {
                alt13=4;
                }
                break;
            case 'f':
                {
                alt13=5;
                }
                break;
            case 'n':
                {
                alt13=6;
                }
                break;
            case 'r':
                {
                alt13=7;
                }
                break;
            case 't':
                {
                alt13=8;
                }
                break;
            case 'u':
                {
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
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
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
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
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop15;
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
            int sStart565 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart565, getCharIndex()-1);
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
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='?') ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1>='\u0000' && LA16_1<='\b')||(LA16_1>='\u000B' && LA16_1<='\f')||(LA16_1>='\u000E' && LA16_1<='\u001F')||LA16_1=='!'||(LA16_1>='#' && LA16_1<='[')||(LA16_1>=']' && LA16_1<='\uFFFF')) && (( isValue() ))) {
                    alt16=2;
                }
                else {
                    alt16=1;}
            }
            else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||LA16_0=='+'||(LA16_0>='.' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                alt16=1;
            }
            else if ( (LA16_0==':') && (( isValue() ))) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:4: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:19: ( FlowIndicator | ScopeIndicator | ',' | '-' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='*')||(input.LA(1)>=',' && input.LA(1)<='-')||input.LA(1)==':'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='!')||(LA17_0>='$' && LA17_0<='\'')||LA17_0=='+'||(LA17_0>='-' && LA17_0<='9')||(LA17_0>=';' && LA17_0<='=')||(LA17_0>='?' && LA17_0<='Z')||(LA17_0>='^' && LA17_0<='z')||(LA17_0>='~' && LA17_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA17_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt17=1;
                }
                else if ( (( isInValue() )) ) {
                    alt17=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt17=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA17_0=='*'||LA17_0==':'||LA17_0=='>'||LA17_0=='['||LA17_0==']'||(LA17_0>='{' && LA17_0<='}')) && ((( isInValue() )||( isOutValue() )))) {
                int LA17_2 = input.LA(2);

                if ( (( isInValue() )) ) {
                    alt17=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt17=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
            }
            else if ( ((LA17_0>='(' && LA17_0<=')')||LA17_0==',') && (( isOutValue() ))) {
                alt17=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
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
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='$' && LA19_0<='\'')||LA19_0=='+'||(LA19_0>='-' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='=')||(LA19_0>='?' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||(LA19_0>='~' && LA19_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                    alt19=1;
                }
                else if ( (LA19_0=='*'||LA19_0==':'||LA19_0=='>'||LA19_0=='['||LA19_0==']'||(LA19_0>='{' && LA19_0<='}')) && ((( isInValue() )||( isOutValue() )))) {
                    alt19=1;
                }
                else if ( ((LA19_0>='(' && LA19_0<=')')||LA19_0==',') && (( isOutValue() ))) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: ( WhiteSpace )* PlainSafe
            	    {
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: ( WhiteSpace )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0=='\t'||LA18_0==' ') && ((!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isOutValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isInValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isKey() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))))) {
            	            int LA18_1 = input.LA(2);

            	            if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {
            	                alt18=1;
            	            }


            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:27: WhiteSpace
            	    	    {
            	    	    mWhiteSpace(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    mPlainSafe(); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='{') && (( isValue() ))) {
                alt20=1;
            }
            else if ( (LA20_0=='[') && (( isValue() ))) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:237:28: WhiteSpace
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
        int alt22=26;
        alt22 = dfa22.predict(input);
        switch (alt22) {
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


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\3\uffff\1\31\1\32\1\34\1\36\1\37\1\44\1\37\1\45\1\46\1\47\1\50"+
        "\1\53\1\54\1\55\1\62\1\63\1\64\1\uffff\1\74\1\75\1\uffff\1\76\7"+
        "\uffff\2\103\7\uffff\2\106\3\uffff\4\74\3\uffff\3\120\2\uffff\1"+
        "\136\5\uffff\2\143\5\uffff\10\106\2\uffff\4\120\12\uffff\1\136\2"+
        "\uffff\1\143\23\uffff";
    static final String DFA22_eofS =
        "\166\uffff";
    static final String DFA22_minS =
        "\1\0\2\uffff\1\12\1\0\1\55\21\0\1\uffff\3\0\2\uffff\1\0\1\uffff"+
        "\3\0\2\uffff\1\0\4\uffff\2\0\3\uffff\5\0\2\uffff\7\0\2\uffff\1\0"+
        "\1\uffff\1\12\2\0\4\uffff\10\0\2\uffff\15\0\1\uffff\17\0\1\uffff"+
        "\7\0";
    static final String DFA22_maxS =
        "\1\uffff\2\uffff\1\12\1\0\1\55\2\uffff\1\0\16\uffff\1\uffff\3\0"+
        "\2\uffff\1\uffff\1\uffff\1\0\2\uffff\2\uffff\1\0\4\uffff\2\uffff"+
        "\3\uffff\4\uffff\1\0\2\uffff\7\uffff\2\uffff\1\0\1\uffff\1\12\1"+
        "\0\1\uffff\4\uffff\10\uffff\2\uffff\15\uffff\1\uffff\3\uffff\2\0"+
        "\12\uffff\1\uffff\7\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\24\uffff\1\11\3\uffff\1\4\1\6\1\uffff\1\16\3\uffff"+
        "\1\7\1\10\1\uffff\1\12\1\13\1\14\1\15\2\uffff\1\17\1\20\1\22\5\uffff"+
        "\1\24\1\25\7\uffff\1\27\1\30\1\uffff\1\3\3\uffff\1\31\1\32\1\21"+
        "\1\27\10\uffff\1\23\1\27\15\uffff\1\26\17\uffff\1\5\7\uffff";
    static final String DFA22_specialS =
        "\1\67\4\uffff\1\26\1\62\1\25\1\uffff\1\105\1\72\1\50\1\44\1\32"+
        "\1\116\1\5\1\6\1\42\1\22\1\77\1\114\1\4\1\107\2\uffff\1\2\1\1\2"+
        "\uffff\1\66\1\uffff\1\53\1\113\1\21\2\uffff\1\41\4\uffff\1\112\1"+
        "\111\3\uffff\1\10\1\35\1\101\1\70\1\117\2\uffff\1\40\1\46\1\45\1"+
        "\27\1\75\1\115\1\124\2\uffff\1\3\1\uffff\1\74\1\7\1\63\4\uffff\1"+
        "\11\1\36\1\102\1\71\1\52\1\55\1\64\1\43\2\uffff\1\54\1\61\1\23\1"+
        "\106\1\34\1\60\1\20\1\73\1\16\1\104\1\51\1\47\1\121\1\uffff\1\123"+
        "\1\57\1\33\1\37\1\0\1\12\1\31\1\103\1\76\1\120\1\14\1\56\1\125\1"+
        "\24\1\15\1\uffff\1\17\1\100\1\122\1\13\1\30\1\65\1\110}>";
    static final String[] DFA22_transitionS = {
            "\11\25\1\11\1\4\2\25\1\3\22\25\1\7\1\25\1\24\1\1\1\25\1\2\1"+
            "\25\1\27\1\12\1\13\1\17\1\20\1\14\1\5\14\25\1\15\3\25\1\6\1"+
            "\23\1\10\32\25\1\21\1\27\1\22\35\25\1\26\1\16\1\27\uff82\25",
            "",
            "",
            "\1\30",
            "\1\uffff",
            "\1\33",
            "\76\27\1\35\uffc1\27",
            "\11\27\1\41\1\43\2\27\1\43\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\34\22\27\1\42\uffbf\27",
            "\1\uffff",
            "\11\27\1\41\1\43\2\27\1\43\22\27\1\41\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\51\2\27\2\51\1\27\22\51\1\27\1\51\1\27\1\52\70\51\1\27"+
            "\uffa3\51",
            "\0\27",
            "\0\27",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\0\27",
            "\0\27",
            "\11\65\1\56\1\27\2\65\1\27\22\65\1\56\1\65\1\27\1\52\4\65"+
            "\2\67\1\66\1\65\1\67\15\65\1\66\3\65\1\66\34\65\1\66\1\27\1"+
            "\66\35\65\3\66\uff82\65",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\0\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\11\27\1\102\1\101\2\27\1\100\22\27\1\102\uffdf\27",
            "",
            "\1\uffff",
            "\11\27\1\41\1\43\2\27\1\43\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\34\22\27\1\42\uffbf\27",
            "\11\27\1\41\1\43\2\27\1\43\22\27\1\41\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\11\110\1\107\1\27\2\110\1\27\22\110\1\107\1\110\2\27\4\110"+
            "\2\112\1\111\1\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111"+
            "\1\27\1\111\35\110\3\111\uff82\110",
            "\11\114\1\113\1\uffff\2\114\1\27\22\114\1\113\1\114\2\27\4"+
            "\114\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114"+
            "\1\115\1\27\1\115\35\114\3\115\uff82\114",
            "",
            "",
            "",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\11\57\1\56\1\27\2\57\1\27\22\57\1\56\1\57\2\27\4\57\2\61"+
            "\1\60\1\57\1\61\15\57\1\60\3\57\1\60\34\57\1\60\1\27\1\60\35"+
            "\57\3\60\uff82\57",
            "\1\uffff",
            "",
            "",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\42\27\1\125\14\27\1\127\54\27\1\126\5\27\1\130\3\27\1\131"+
            "\7\27\1\132\3\27\1\133\1\27\1\134\1\135\uff8a\27",
            "\0\27",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "",
            "",
            "\1\uffff",
            "",
            "\1\142",
            "\1\uffff",
            "\11\27\1\102\1\101\2\27\1\100\22\27\1\102\uffdf\27",
            "",
            "",
            "",
            "",
            "\11\110\1\107\1\27\2\110\1\27\22\110\1\107\1\110\2\27\4\110"+
            "\2\112\1\111\1\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111"+
            "\1\27\1\111\35\110\3\111\uff82\110",
            "\11\110\1\107\1\27\2\110\1\27\22\110\1\107\1\110\2\27\4\110"+
            "\2\112\1\111\1\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111"+
            "\1\27\1\111\35\110\3\111\uff82\110",
            "\11\110\1\107\1\27\2\110\1\27\22\110\1\107\1\110\2\27\4\110"+
            "\2\112\1\111\1\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111"+
            "\1\27\1\111\35\110\3\111\uff82\110",
            "\11\110\1\107\1\27\2\110\1\27\22\110\1\107\1\110\2\27\4\110"+
            "\2\112\1\111\1\110\1\112\15\110\1\111\3\110\1\111\34\110\1\111"+
            "\1\27\1\111\35\110\3\111\uff82\110",
            "\11\114\1\113\1\uffff\2\114\1\27\22\114\1\113\1\114\2\27\4"+
            "\114\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114"+
            "\1\115\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\uffff\2\114\1\27\22\114\1\113\1\114\2\27\4"+
            "\114\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114"+
            "\1\115\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\uffff\2\114\1\27\22\114\1\113\1\114\2\27\4"+
            "\114\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114"+
            "\1\115\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\uffff\2\114\1\27\22\114\1\113\1\114\2\27\4"+
            "\114\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114"+
            "\1\115\1\27\1\115\35\114\3\115\uff82\114",
            "",
            "",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\11\122\1\121\1\27\2\122\1\27\22\122\1\121\1\122\2\27\4\122"+
            "\2\124\1\123\1\122\1\124\15\122\1\123\3\122\1\123\34\122\1\123"+
            "\1\27\1\123\35\122\3\123\uff82\122",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\60\27\12\144\7\27\6\144\32\27\6\144\uff99\27",
            "",
            "\12\27\1\uffff\ufff5\27",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\27\1\uffff\27\27\1\145\14\27\1\147\54\27\1\146\5\27\1"+
            "\150\3\27\1\151\7\27\1\152\3\27\1\153\1\27\1\154\1\155\uff8a"+
            "\27",
            "\1\uffff",
            "\1\uffff",
            "\60\27\12\157\7\27\6\157\32\27\6\157\uff99\27",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140",
            "\12\27\1\uffff\45\27\12\160\7\27\6\160\32\27\6\160\uff99\27",
            "",
            "\60\27\12\161\7\27\6\161\32\27\6\161\uff99\27",
            "\12\27\1\uffff\45\27\12\162\7\27\6\162\32\27\6\162\uff99\27",
            "\60\27\12\163\7\27\6\163\32\27\6\163\uff99\27",
            "\12\27\1\uffff\45\27\12\164\7\27\6\164\32\27\6\164\uff99\27",
            "\12\70\1\27\2\70\1\27\24\70\1\72\1\73\70\70\1\71\uffa3\70",
            "\12\27\1\uffff\45\27\12\165\7\27\6\165\32\27\6\165\uff99\27",
            "\12\140\1\uffff\2\140\1\27\24\140\1\137\71\140\1\141\uffa3"+
            "\140"
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
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_99 = input.LA(1);

                         
                        int index22_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 110;}

                        else if ( (( isHead() )) ) {s = 23;}

                         
                        input.seek(index22_99);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 63;}

                        else if ( (( isHead() )) ) {s = 35;}

                         
                        input.seek(index22_26);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_25 = input.LA(1);

                         
                        int index22_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 63;}

                        else if ( (( isHead() )) ) {s = 35;}

                         
                        input.seek(index22_25);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_62 = input.LA(1);

                         
                        int index22_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 63;}

                        else if ( (( isHead() )) ) {s = 35;}

                         
                        input.seek(index22_62);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_21=='\t'||LA22_21==' ') ) {s = 46;}

                        else if ( ((LA22_21>='\u0000' && LA22_21<='\b')||(LA22_21>='\u000B' && LA22_21<='\f')||(LA22_21>='\u000E' && LA22_21<='\u001F')||LA22_21=='!'||(LA22_21>='$' && LA22_21<='\'')||LA22_21=='+'||(LA22_21>='-' && LA22_21<='9')||(LA22_21>=';' && LA22_21<='=')||(LA22_21>='?' && LA22_21<='Z')||(LA22_21>='^' && LA22_21<='z')||(LA22_21>='~' && LA22_21<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_21=='*'||LA22_21==':'||LA22_21=='>'||LA22_21=='['||LA22_21==']'||(LA22_21>='{' && LA22_21<='}')) ) {s = 48;}

                        else if ( ((LA22_21>='(' && LA22_21<=')')||LA22_21==',') ) {s = 49;}

                        else if ( (LA22_21=='\n'||LA22_21=='\r'||(LA22_21>='\"' && LA22_21<='#')||LA22_21=='\\') && (( isHead() ))) {s = 23;}

                        else s = 60;

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 44;

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_16 = input.LA(1);

                         
                        int index22_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_16=='\t'||LA22_16==' ') ) {s = 46;}

                        else if ( ((LA22_16>='\u0000' && LA22_16<='\b')||(LA22_16>='\u000B' && LA22_16<='\f')||(LA22_16>='\u000E' && LA22_16<='\u001F')||LA22_16=='!'||(LA22_16>='$' && LA22_16<='\'')||LA22_16=='+'||(LA22_16>='-' && LA22_16<='9')||(LA22_16>=';' && LA22_16<='=')||(LA22_16>='?' && LA22_16<='Z')||(LA22_16>='^' && LA22_16<='z')||(LA22_16>='~' && LA22_16<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_16=='*'||LA22_16==':'||LA22_16=='>'||LA22_16=='['||LA22_16==']'||(LA22_16>='{' && LA22_16<='}')) ) {s = 48;}

                        else if ( ((LA22_16>='(' && LA22_16<=')')||LA22_16==',') ) {s = 49;}

                        else if ( (LA22_16=='\n'||LA22_16=='\r'||(LA22_16>='\"' && LA22_16<='#')||LA22_16=='\\') && (( isHead() ))) {s = 23;}

                        else s = 45;

                         
                        input.seek(index22_16);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_65 = input.LA(1);

                         
                        int index22_65 = input.index();
                        input.rewind();
                        s = -1;
                        s = 99;

                         
                        input.seek(index22_65);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_46 = input.LA(1);

                         
                        int index22_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_46=='\n'||LA22_46=='\r'||(LA22_46>='\"' && LA22_46<='#')||LA22_46=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_46=='\t'||LA22_46==' ') ) {s = 46;}

                        else if ( ((LA22_46>='\u0000' && LA22_46<='\b')||(LA22_46>='\u000B' && LA22_46<='\f')||(LA22_46>='\u000E' && LA22_46<='\u001F')||LA22_46=='!'||(LA22_46>='$' && LA22_46<='\'')||LA22_46=='+'||(LA22_46>='-' && LA22_46<='9')||(LA22_46>=';' && LA22_46<='=')||(LA22_46>='?' && LA22_46<='Z')||(LA22_46>='^' && LA22_46<='z')||(LA22_46>='~' && LA22_46<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_46=='*'||LA22_46==':'||LA22_46=='>'||LA22_46=='['||LA22_46==']'||(LA22_46>='{' && LA22_46<='}')) ) {s = 48;}

                        else if ( ((LA22_46>='(' && LA22_46<=')')||LA22_46==',') ) {s = 49;}

                        else s = 60;

                         
                        input.seek(index22_46);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_71 = input.LA(1);

                         
                        int index22_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_71=='\n'||LA22_71=='\r'||(LA22_71>='\"' && LA22_71<='#')||LA22_71=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_71=='\t'||LA22_71==' ') && ((( isValue() )||( isHead() )))) {s = 71;}

                        else if ( ((LA22_71>='\u0000' && LA22_71<='\b')||(LA22_71>='\u000B' && LA22_71<='\f')||(LA22_71>='\u000E' && LA22_71<='\u001F')||LA22_71=='!'||(LA22_71>='$' && LA22_71<='\'')||LA22_71=='+'||(LA22_71>='-' && LA22_71<='9')||(LA22_71>=';' && LA22_71<='=')||(LA22_71>='?' && LA22_71<='Z')||(LA22_71>='^' && LA22_71<='z')||(LA22_71>='~' && LA22_71<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA22_71=='*'||LA22_71==':'||LA22_71=='>'||LA22_71=='['||LA22_71==']'||(LA22_71>='{' && LA22_71<='}')) && ((( isValue() )||( isHead() )))) {s = 73;}

                        else if ( ((LA22_71>='(' && LA22_71<=')')||LA22_71==',') && ((( isHead() )||( isValue() )))) {s = 74;}

                        else s = 70;

                         
                        input.seek(index22_71);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_100 = input.LA(1);

                         
                        int index22_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_100>='\u0000' && LA22_100<='/')||(LA22_100>=':' && LA22_100<='@')||(LA22_100>='G' && LA22_100<='`')||(LA22_100>='g' && LA22_100<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_100>='0' && LA22_100<='9')||(LA22_100>='A' && LA22_100<='F')||(LA22_100>='a' && LA22_100<='f')) ) {s = 111;}

                         
                        input.seek(index22_100);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_114>='0' && LA22_114<='9')||(LA22_114>='A' && LA22_114<='F')||(LA22_114>='a' && LA22_114<='f')) ) {s = 116;}

                        else if ( ((LA22_114>='\u0000' && LA22_114<='\t')||(LA22_114>='\u000B' && LA22_114<='/')||(LA22_114>=':' && LA22_114<='@')||(LA22_114>='G' && LA22_114<='`')||(LA22_114>='g' && LA22_114<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_105 = input.LA(1);

                         
                        int index22_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_105=='\"') ) {s = 95;}

                        else if ( ((LA22_105>='\u0000' && LA22_105<='\t')||(LA22_105>='\u000B' && LA22_105<='\f')||(LA22_105>='\u000E' && LA22_105<='!')||(LA22_105>='#' && LA22_105<='[')||(LA22_105>=']' && LA22_105<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_105=='\\') ) {s = 97;}

                        else if ( (LA22_105=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_105);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_109 = input.LA(1);

                         
                        int index22_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_109>='\u0000' && LA22_109<='\t')||(LA22_109>='\u000B' && LA22_109<='/')||(LA22_109>=':' && LA22_109<='@')||(LA22_109>='G' && LA22_109<='`')||(LA22_109>='g' && LA22_109<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_109>='0' && LA22_109<='9')||(LA22_109>='A' && LA22_109<='F')||(LA22_109>='a' && LA22_109<='f')) ) {s = 112;}

                         
                        input.seek(index22_109);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_89=='\"') ) {s = 58;}

                        else if ( (LA22_89=='#') ) {s = 59;}

                        else if ( (LA22_89=='\\') ) {s = 57;}

                        else if ( (LA22_89=='\n'||LA22_89=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_89>='\u0000' && LA22_89<='\t')||(LA22_89>='\u000B' && LA22_89<='\f')||(LA22_89>='\u000E' && LA22_89<='!')||(LA22_89>='$' && LA22_89<='[')||(LA22_89>=']' && LA22_89<='\uFFFF')) ) {s = 56;}

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_111>='0' && LA22_111<='9')||(LA22_111>='A' && LA22_111<='F')||(LA22_111>='a' && LA22_111<='f')) ) {s = 113;}

                        else if ( ((LA22_111>='\u0000' && LA22_111<='/')||(LA22_111>=':' && LA22_111<='@')||(LA22_111>='G' && LA22_111<='`')||(LA22_111>='g' && LA22_111<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_87 = input.LA(1);

                         
                        int index22_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_87=='\n'||LA22_87=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_87=='#') ) {s = 59;}

                        else if ( (LA22_87=='\"') ) {s = 58;}

                        else if ( ((LA22_87>='\u0000' && LA22_87<='\t')||(LA22_87>='\u000B' && LA22_87<='\f')||(LA22_87>='\u000E' && LA22_87<='!')||(LA22_87>='$' && LA22_87<='[')||(LA22_87>=']' && LA22_87<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_87=='\\') ) {s = 57;}

                         
                        input.seek(index22_87);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_33 = input.LA(1);

                         
                        int index22_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_33>='\u0000' && LA22_33<='\b')||(LA22_33>='\u000B' && LA22_33<='\f')||(LA22_33>='\u000E' && LA22_33<='\u001F')||(LA22_33>='!' && LA22_33<='\"')||LA22_33=='$'||(LA22_33>='&' && LA22_33<=',')||(LA22_33>='.' && LA22_33<='?')||(LA22_33>='A' && LA22_33<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_33=='\t'||LA22_33==' ') ) {s = 33;}

                        else if ( (LA22_33=='\n'||LA22_33=='\r') && (( isHead() ))) {s = 35;}

                        else s = 67;

                         
                        input.seek(index22_33);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_18 = input.LA(1);

                         
                        int index22_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_18>='\u0000' && LA22_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 51;

                         
                        input.seek(index22_18);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_83 = input.LA(1);

                         
                        int index22_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_83=='\n'||LA22_83=='\r'||(LA22_83>='\"' && LA22_83<='#')||LA22_83=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_83=='\t'||LA22_83==' ') ) {s = 81;}

                        else if ( ((LA22_83>='\u0000' && LA22_83<='\b')||(LA22_83>='\u000B' && LA22_83<='\f')||(LA22_83>='\u000E' && LA22_83<='\u001F')||LA22_83=='!'||(LA22_83>='$' && LA22_83<='\'')||LA22_83=='+'||(LA22_83>='-' && LA22_83<='9')||(LA22_83>=';' && LA22_83<='=')||(LA22_83>='?' && LA22_83<='Z')||(LA22_83>='^' && LA22_83<='z')||(LA22_83>='~' && LA22_83<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_83=='*'||LA22_83==':'||LA22_83=='>'||LA22_83=='['||LA22_83==']'||(LA22_83>='{' && LA22_83<='}')) ) {s = 83;}

                        else if ( ((LA22_83>='(' && LA22_83<=')')||LA22_83==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_83);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_108 = input.LA(1);

                         
                        int index22_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_108=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_108=='\"') ) {s = 95;}

                        else if ( ((LA22_108>='\u0000' && LA22_108<='\t')||(LA22_108>='\u000B' && LA22_108<='\f')||(LA22_108>='\u000E' && LA22_108<='!')||(LA22_108>='#' && LA22_108<='[')||(LA22_108>=']' && LA22_108<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_108=='\\') ) {s = 97;}

                         
                        input.seek(index22_108);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_7>='\u0000' && LA22_7<='\b')||(LA22_7>='\u000B' && LA22_7<='\f')||(LA22_7>='\u000E' && LA22_7<='\u001F')||(LA22_7>='!' && LA22_7<='\"')||LA22_7=='$'||(LA22_7>='&' && LA22_7<=',')||(LA22_7>='.' && LA22_7<='?')||(LA22_7>='A' && LA22_7<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_7==' ') ) {s = 32;}

                        else if ( (LA22_7=='-') ) {s = 28;}

                        else if ( (LA22_7=='\t') ) {s = 33;}

                        else if ( (LA22_7=='@') && (( isHead() ))) {s = 34;}

                        else if ( (LA22_7=='\n'||LA22_7=='\r') && (( isHead() ))) {s = 35;}

                        else s = 31;

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_5=='-') && (( isHead() ))) {s = 27;}

                        else s = 28;

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_56 = input.LA(1);

                         
                        int index22_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_56=='\"') ) {s = 58;}

                        else if ( (LA22_56=='#') ) {s = 59;}

                        else if ( (LA22_56=='\\') ) {s = 57;}

                        else if ( (LA22_56=='\n'||LA22_56=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_56>='\u0000' && LA22_56<='\t')||(LA22_56>='\u000B' && LA22_56<='\f')||(LA22_56>='\u000E' && LA22_56<='!')||(LA22_56>='$' && LA22_56<='[')||(LA22_56>=']' && LA22_56<='\uFFFF')) ) {s = 56;}

                         
                        input.seek(index22_56);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_115 = input.LA(1);

                         
                        int index22_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_115=='\n'||LA22_115=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_115=='#') ) {s = 59;}

                        else if ( (LA22_115=='\"') ) {s = 58;}

                        else if ( ((LA22_115>='\u0000' && LA22_115<='\t')||(LA22_115>='\u000B' && LA22_115<='\f')||(LA22_115>='\u000E' && LA22_115<='!')||(LA22_115>='$' && LA22_115<='[')||(LA22_115>=']' && LA22_115<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_115=='\\') ) {s = 57;}

                         
                        input.seek(index22_115);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_101 = input.LA(1);

                         
                        int index22_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_101=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_101=='\"') ) {s = 95;}

                        else if ( ((LA22_101>='\u0000' && LA22_101<='\t')||(LA22_101>='\u000B' && LA22_101<='\f')||(LA22_101>='\u000E' && LA22_101<='!')||(LA22_101>='#' && LA22_101<='[')||(LA22_101>=']' && LA22_101<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_101=='\\') ) {s = 97;}

                         
                        input.seek(index22_101);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_13>='\u0000' && LA22_13<='\b')||(LA22_13>='\u000B' && LA22_13<='\f')||(LA22_13>='\u000E' && LA22_13<='\u001F')||LA22_13=='!'||(LA22_13>='$' && LA22_13<='[')||(LA22_13>=']' && LA22_13<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 41;}

                        else if ( ((LA22_13>='\t' && LA22_13<='\n')||LA22_13=='\r'||LA22_13==' '||LA22_13=='\"'||LA22_13=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_13=='#') && ((( isValue() )||( isHead() )))) {s = 42;}

                        else s = 40;

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_97 = input.LA(1);

                         
                        int index22_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_97=='\"') ) {s = 101;}

                        else if ( (LA22_97=='\\') ) {s = 102;}

                        else if ( (LA22_97=='/') ) {s = 103;}

                        else if ( (LA22_97=='b') ) {s = 104;}

                        else if ( (LA22_97=='f') ) {s = 105;}

                        else if ( (LA22_97=='n') ) {s = 106;}

                        else if ( (LA22_97=='r') ) {s = 107;}

                        else if ( (LA22_97=='t') ) {s = 108;}

                        else if ( (LA22_97=='u') ) {s = 109;}

                        else if ( ((LA22_97>='\u0000' && LA22_97<='\t')||(LA22_97>='\u000B' && LA22_97<='!')||(LA22_97>='#' && LA22_97<='.')||(LA22_97>='0' && LA22_97<='[')||(LA22_97>=']' && LA22_97<='a')||(LA22_97>='c' && LA22_97<='e')||(LA22_97>='g' && LA22_97<='m')||(LA22_97>='o' && LA22_97<='q')||LA22_97=='s'||(LA22_97>='v' && LA22_97<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_97);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_85 = input.LA(1);

                         
                        int index22_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_85=='\n'||LA22_85=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_85=='#') ) {s = 59;}

                        else if ( (LA22_85=='\"') ) {s = 58;}

                        else if ( ((LA22_85>='\u0000' && LA22_85<='\t')||(LA22_85>='\u000B' && LA22_85<='\f')||(LA22_85>='\u000E' && LA22_85<='!')||(LA22_85>='$' && LA22_85<='[')||(LA22_85>=']' && LA22_85<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_85=='\\') ) {s = 57;}

                         
                        input.seek(index22_85);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_47 = input.LA(1);

                         
                        int index22_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_47=='\n'||LA22_47=='\r'||(LA22_47>='\"' && LA22_47<='#')||LA22_47=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_47=='\t'||LA22_47==' ') ) {s = 46;}

                        else if ( ((LA22_47>='\u0000' && LA22_47<='\b')||(LA22_47>='\u000B' && LA22_47<='\f')||(LA22_47>='\u000E' && LA22_47<='\u001F')||LA22_47=='!'||(LA22_47>='$' && LA22_47<='\'')||LA22_47=='+'||(LA22_47>='-' && LA22_47<='9')||(LA22_47>=';' && LA22_47<='=')||(LA22_47>='?' && LA22_47<='Z')||(LA22_47>='^' && LA22_47<='z')||(LA22_47>='~' && LA22_47<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_47=='*'||LA22_47==':'||LA22_47=='>'||LA22_47=='['||LA22_47==']'||(LA22_47>='{' && LA22_47<='}')) ) {s = 48;}

                        else if ( ((LA22_47>='(' && LA22_47<=')')||LA22_47==',') ) {s = 49;}

                        else s = 60;

                         
                        input.seek(index22_47);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_72 = input.LA(1);

                         
                        int index22_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_72=='\n'||LA22_72=='\r'||(LA22_72>='\"' && LA22_72<='#')||LA22_72=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_72=='\t'||LA22_72==' ') && ((( isValue() )||( isHead() )))) {s = 71;}

                        else if ( ((LA22_72>='\u0000' && LA22_72<='\b')||(LA22_72>='\u000B' && LA22_72<='\f')||(LA22_72>='\u000E' && LA22_72<='\u001F')||LA22_72=='!'||(LA22_72>='$' && LA22_72<='\'')||LA22_72=='+'||(LA22_72>='-' && LA22_72<='9')||(LA22_72>=';' && LA22_72<='=')||(LA22_72>='?' && LA22_72<='Z')||(LA22_72>='^' && LA22_72<='z')||(LA22_72>='~' && LA22_72<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA22_72=='*'||LA22_72==':'||LA22_72=='>'||LA22_72=='['||LA22_72==']'||(LA22_72>='{' && LA22_72<='}')) && ((( isValue() )||( isHead() )))) {s = 73;}

                        else if ( ((LA22_72>='(' && LA22_72<=')')||LA22_72==',') && ((( isHead() )||( isValue() )))) {s = 74;}

                        else s = 70;

                         
                        input.seek(index22_72);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_98 = input.LA(1);

                         
                        int index22_98 = input.index();
                        input.rewind();
                        s = -1;
                        s = 99;

                         
                        input.seek(index22_98);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_53 = input.LA(1);

                         
                        int index22_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_53=='\n'||LA22_53=='\r'||(LA22_53>='\"' && LA22_53<='#')||LA22_53=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_53=='\t'||LA22_53==' ') ) {s = 81;}

                        else if ( ((LA22_53>='\u0000' && LA22_53<='\b')||(LA22_53>='\u000B' && LA22_53<='\f')||(LA22_53>='\u000E' && LA22_53<='\u001F')||LA22_53=='!'||(LA22_53>='$' && LA22_53<='\'')||LA22_53=='+'||(LA22_53>='-' && LA22_53<='9')||(LA22_53>=';' && LA22_53<='=')||(LA22_53>='?' && LA22_53<='Z')||(LA22_53>='^' && LA22_53<='z')||(LA22_53>='~' && LA22_53<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_53=='*'||LA22_53==':'||LA22_53=='>'||LA22_53=='['||LA22_53==']'||(LA22_53>='{' && LA22_53<='}')) ) {s = 83;}

                        else if ( ((LA22_53>='(' && LA22_53<=')')||LA22_53==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_53);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_36 = input.LA(1);

                         
                        int index22_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 34;}

                        else if ( (true) ) {s = 69;}

                         
                        input.seek(index22_36);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_17 = input.LA(1);

                         
                        int index22_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_17>='\u0000' && LA22_17<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 50;

                         
                        input.seek(index22_17);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_78 = input.LA(1);

                         
                        int index22_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_78=='\t'||LA22_78==' ') && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( ((LA22_78>='\u0000' && LA22_78<='\b')||(LA22_78>='\u000B' && LA22_78<='\f')||(LA22_78>='\u000E' && LA22_78<='\u001F')||LA22_78=='!'||(LA22_78>='$' && LA22_78<='\'')||LA22_78=='+'||(LA22_78>='-' && LA22_78<='9')||(LA22_78>=';' && LA22_78<='=')||(LA22_78>='?' && LA22_78<='Z')||(LA22_78>='^' && LA22_78<='z')||(LA22_78>='~' && LA22_78<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 76;}

                        else if ( (LA22_78=='*'||LA22_78==':'||LA22_78=='>'||LA22_78=='['||LA22_78==']'||(LA22_78>='{' && LA22_78<='}')) && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( ((LA22_78>='(' && LA22_78<=')')||LA22_78==',') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA22_78=='\r'||(LA22_78>='\"' && LA22_78<='#')||LA22_78=='\\') && (( isHead() ))) {s = 23;}

                        else s = 70;

                         
                        input.seek(index22_78);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_12>='\u0000' && LA22_12<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 39;

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_55=='\n'||LA22_55=='\r'||(LA22_55>='\"' && LA22_55<='#')||LA22_55=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_55=='\t'||LA22_55==' ') ) {s = 81;}

                        else if ( ((LA22_55>='\u0000' && LA22_55<='\b')||(LA22_55>='\u000B' && LA22_55<='\f')||(LA22_55>='\u000E' && LA22_55<='\u001F')||LA22_55=='!'||(LA22_55>='$' && LA22_55<='\'')||LA22_55=='+'||(LA22_55>='-' && LA22_55<='9')||(LA22_55>=';' && LA22_55<='=')||(LA22_55>='?' && LA22_55<='Z')||(LA22_55>='^' && LA22_55<='z')||(LA22_55>='~' && LA22_55<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_55=='*'||LA22_55==':'||LA22_55=='>'||LA22_55=='['||LA22_55==']'||(LA22_55>='{' && LA22_55<='}')) ) {s = 83;}

                        else if ( ((LA22_55>='(' && LA22_55<=')')||LA22_55==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_54 = input.LA(1);

                         
                        int index22_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_54=='\n'||LA22_54=='\r'||(LA22_54>='\"' && LA22_54<='#')||LA22_54=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_54=='\t'||LA22_54==' ') ) {s = 81;}

                        else if ( ((LA22_54>='\u0000' && LA22_54<='\b')||(LA22_54>='\u000B' && LA22_54<='\f')||(LA22_54>='\u000E' && LA22_54<='\u001F')||LA22_54=='!'||(LA22_54>='$' && LA22_54<='\'')||LA22_54=='+'||(LA22_54>='-' && LA22_54<='9')||(LA22_54>=';' && LA22_54<='=')||(LA22_54>='?' && LA22_54<='Z')||(LA22_54>='^' && LA22_54<='z')||(LA22_54>='~' && LA22_54<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_54=='*'||LA22_54==':'||LA22_54=='>'||LA22_54=='['||LA22_54==']'||(LA22_54>='{' && LA22_54<='}')) ) {s = 83;}

                        else if ( ((LA22_54>='(' && LA22_54<=')')||LA22_54==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_54);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_92 = input.LA(1);

                         
                        int index22_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_92=='\n'||LA22_92=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_92=='#') ) {s = 59;}

                        else if ( (LA22_92=='\"') ) {s = 58;}

                        else if ( ((LA22_92>='\u0000' && LA22_92<='\t')||(LA22_92>='\u000B' && LA22_92<='\f')||(LA22_92>='\u000E' && LA22_92<='!')||(LA22_92>='$' && LA22_92<='[')||(LA22_92>=']' && LA22_92<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_92=='\\') ) {s = 57;}

                         
                        input.seek(index22_92);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 38;

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_91 = input.LA(1);

                         
                        int index22_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_91=='\n'||LA22_91=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_91=='#') ) {s = 59;}

                        else if ( (LA22_91=='\"') ) {s = 58;}

                        else if ( ((LA22_91>='\u0000' && LA22_91<='\t')||(LA22_91>='\u000B' && LA22_91<='\f')||(LA22_91>='\u000E' && LA22_91<='!')||(LA22_91>='$' && LA22_91<='[')||(LA22_91>=']' && LA22_91<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_91=='\\') ) {s = 57;}

                         
                        input.seek(index22_91);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_75=='\t'||LA22_75==' ') && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( ((LA22_75>='\u0000' && LA22_75<='\b')||(LA22_75>='\u000B' && LA22_75<='\f')||(LA22_75>='\u000E' && LA22_75<='\u001F')||LA22_75=='!'||(LA22_75>='$' && LA22_75<='\'')||LA22_75=='+'||(LA22_75>='-' && LA22_75<='9')||(LA22_75>=';' && LA22_75<='=')||(LA22_75>='?' && LA22_75<='Z')||(LA22_75>='^' && LA22_75<='z')||(LA22_75>='~' && LA22_75<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 76;}

                        else if ( (LA22_75=='*'||LA22_75==':'||LA22_75=='>'||LA22_75=='['||LA22_75==']'||(LA22_75>='{' && LA22_75<='}')) && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( ((LA22_75>='(' && LA22_75<=')')||LA22_75==',') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA22_75=='\r'||(LA22_75>='\"' && LA22_75<='#')||LA22_75=='\\') && (( isHead() ))) {s = 23;}

                        else s = 70;

                         
                        input.seek(index22_75);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_31 = input.LA(1);

                         
                        int index22_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( !isHead() )) ) {s = 67;}

                        else if ( (true) ) {s = 68;}

                         
                        input.seek(index22_31);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_81=='\n'||LA22_81=='\r'||(LA22_81>='\"' && LA22_81<='#')||LA22_81=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_81=='\t'||LA22_81==' ') ) {s = 81;}

                        else if ( ((LA22_81>='\u0000' && LA22_81<='\b')||(LA22_81>='\u000B' && LA22_81<='\f')||(LA22_81>='\u000E' && LA22_81<='\u001F')||LA22_81=='!'||(LA22_81>='$' && LA22_81<='\'')||LA22_81=='+'||(LA22_81>='-' && LA22_81<='9')||(LA22_81>=';' && LA22_81<='=')||(LA22_81>='?' && LA22_81<='Z')||(LA22_81>='^' && LA22_81<='z')||(LA22_81>='~' && LA22_81<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_81=='*'||LA22_81==':'||LA22_81=='>'||LA22_81=='['||LA22_81==']'||(LA22_81>='{' && LA22_81<='}')) ) {s = 83;}

                        else if ( ((LA22_81>='(' && LA22_81<=')')||LA22_81==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_76 = input.LA(1);

                         
                        int index22_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_76=='\t'||LA22_76==' ') && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( ((LA22_76>='\u0000' && LA22_76<='\b')||(LA22_76>='\u000B' && LA22_76<='\f')||(LA22_76>='\u000E' && LA22_76<='\u001F')||LA22_76=='!'||(LA22_76>='$' && LA22_76<='\'')||LA22_76=='+'||(LA22_76>='-' && LA22_76<='9')||(LA22_76>=';' && LA22_76<='=')||(LA22_76>='?' && LA22_76<='Z')||(LA22_76>='^' && LA22_76<='z')||(LA22_76>='~' && LA22_76<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 76;}

                        else if ( (LA22_76=='*'||LA22_76==':'||LA22_76=='>'||LA22_76=='['||LA22_76==']'||(LA22_76>='{' && LA22_76<='}')) && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( ((LA22_76>='(' && LA22_76<=')')||LA22_76==',') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA22_76=='\r'||(LA22_76>='\"' && LA22_76<='#')||LA22_76=='\\') && (( isHead() ))) {s = 23;}

                        else s = 70;

                         
                        input.seek(index22_76);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_106 = input.LA(1);

                         
                        int index22_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_106=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_106=='\"') ) {s = 95;}

                        else if ( ((LA22_106>='\u0000' && LA22_106<='\t')||(LA22_106>='\u000B' && LA22_106<='\f')||(LA22_106>='\u000E' && LA22_106<='!')||(LA22_106>='#' && LA22_106<='[')||(LA22_106>=']' && LA22_106<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_106=='\\') ) {s = 97;}

                         
                        input.seek(index22_106);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_96 = input.LA(1);

                         
                        int index22_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_96=='\"') ) {s = 95;}

                        else if ( ((LA22_96>='\u0000' && LA22_96<='\t')||(LA22_96>='\u000B' && LA22_96<='\f')||(LA22_96>='\u000E' && LA22_96<='!')||(LA22_96>='#' && LA22_96<='[')||(LA22_96>=']' && LA22_96<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_96=='\\') ) {s = 97;}

                        else if ( (LA22_96=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_96);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_86 = input.LA(1);

                         
                        int index22_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_86=='\n'||LA22_86=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_86=='#') ) {s = 59;}

                        else if ( (LA22_86=='\"') ) {s = 58;}

                        else if ( ((LA22_86>='\u0000' && LA22_86<='\t')||(LA22_86>='\u000B' && LA22_86<='\f')||(LA22_86>='\u000E' && LA22_86<='!')||(LA22_86>='$' && LA22_86<='[')||(LA22_86>=']' && LA22_86<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_86=='\\') ) {s = 57;}

                         
                        input.seek(index22_86);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_82 = input.LA(1);

                         
                        int index22_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_82=='\n'||LA22_82=='\r'||(LA22_82>='\"' && LA22_82<='#')||LA22_82=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_82=='\t'||LA22_82==' ') ) {s = 81;}

                        else if ( ((LA22_82>='\u0000' && LA22_82<='\b')||(LA22_82>='\u000B' && LA22_82<='\f')||(LA22_82>='\u000E' && LA22_82<='\u001F')||LA22_82=='!'||(LA22_82>='$' && LA22_82<='\'')||LA22_82=='+'||(LA22_82>='-' && LA22_82<='9')||(LA22_82>=';' && LA22_82<='=')||(LA22_82>='?' && LA22_82<='Z')||(LA22_82>='^' && LA22_82<='z')||(LA22_82>='~' && LA22_82<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_82=='*'||LA22_82==':'||LA22_82=='>'||LA22_82=='['||LA22_82==']'||(LA22_82>='{' && LA22_82<='}')) ) {s = 83;}

                        else if ( ((LA22_82>='(' && LA22_82<=')')||LA22_82==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_82);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_6=='>') && (( isHead() ))) {s = 29;}

                        else if ( ((LA22_6>='\u0000' && LA22_6<='=')||(LA22_6>='?' && LA22_6<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 30;

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_66 = input.LA(1);

                         
                        int index22_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_66=='\r') && (( isHead() ))) {s = 64;}

                        else if ( (LA22_66=='\n') && (( isHead() ))) {s = 65;}

                        else if ( (LA22_66=='\t'||LA22_66==' ') && (( isHead() ))) {s = 66;}

                        else if ( ((LA22_66>='\u0000' && LA22_66<='\b')||(LA22_66>='\u000B' && LA22_66<='\f')||(LA22_66>='\u000E' && LA22_66<='\u001F')||(LA22_66>='!' && LA22_66<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_66);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_77 = input.LA(1);

                         
                        int index22_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_77=='\t'||LA22_77==' ') && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( ((LA22_77>='\u0000' && LA22_77<='\b')||(LA22_77>='\u000B' && LA22_77<='\f')||(LA22_77>='\u000E' && LA22_77<='\u001F')||LA22_77=='!'||(LA22_77>='$' && LA22_77<='\'')||LA22_77=='+'||(LA22_77>='-' && LA22_77<='9')||(LA22_77>=';' && LA22_77<='=')||(LA22_77>='?' && LA22_77<='Z')||(LA22_77>='^' && LA22_77<='z')||(LA22_77>='~' && LA22_77<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 76;}

                        else if ( (LA22_77=='*'||LA22_77==':'||LA22_77=='>'||LA22_77=='['||LA22_77==']'||(LA22_77>='{' && LA22_77<='}')) && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( ((LA22_77>='(' && LA22_77<=')')||LA22_77==',') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA22_77=='\r'||(LA22_77>='\"' && LA22_77<='#')||LA22_77=='\\') && (( isHead() ))) {s = 23;}

                        else s = 70;

                         
                        input.seek(index22_77);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_116>='0' && LA22_116<='9')||(LA22_116>='A' && LA22_116<='F')||(LA22_116>='a' && LA22_116<='f')) ) {s = 117;}

                        else if ( ((LA22_116>='\u0000' && LA22_116<='\t')||(LA22_116>='\u000B' && LA22_116<='/')||(LA22_116>=':' && LA22_116<='@')||(LA22_116>='G' && LA22_116<='`')||(LA22_116>='g' && LA22_116<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_29 = input.LA(1);

                         
                        int index22_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_29=='\r') && (( isHead() ))) {s = 64;}

                        else if ( (LA22_29=='\n') && (( isHead() ))) {s = 65;}

                        else if ( ((LA22_29>='\u0000' && LA22_29<='\b')||(LA22_29>='\u000B' && LA22_29<='\f')||(LA22_29>='\u000E' && LA22_29<='\u001F')||(LA22_29>='!' && LA22_29<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_29=='\t'||LA22_29==' ') && (( isHead() ))) {s = 66;}

                         
                        input.seek(index22_29);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0=='#') ) {s = 1;}

                        else if ( (LA22_0=='%') ) {s = 2;}

                        else if ( (LA22_0=='\r') ) {s = 3;}

                        else if ( (LA22_0=='\n') ) {s = 4;}

                        else if ( (LA22_0=='-') ) {s = 5;}

                        else if ( (LA22_0=='>') ) {s = 6;}

                        else if ( (LA22_0==' ') ) {s = 7;}

                        else if ( (LA22_0=='@') ) {s = 8;}

                        else if ( (LA22_0=='\t') ) {s = 9;}

                        else if ( (LA22_0=='(') ) {s = 10;}

                        else if ( (LA22_0==')') ) {s = 11;}

                        else if ( (LA22_0==',') ) {s = 12;}

                        else if ( (LA22_0==':') ) {s = 13;}

                        else if ( (LA22_0=='|') ) {s = 14;}

                        else if ( (LA22_0=='*') ) {s = 15;}

                        else if ( (LA22_0=='+') ) {s = 16;}

                        else if ( (LA22_0=='[') ) {s = 17;}

                        else if ( (LA22_0==']') ) {s = 18;}

                        else if ( (LA22_0=='?') ) {s = 19;}

                        else if ( (LA22_0=='\"') ) {s = 20;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||LA22_0=='$'||LA22_0=='&'||(LA22_0>='.' && LA22_0<='9')||(LA22_0>=';' && LA22_0<='=')||(LA22_0>='A' && LA22_0<='Z')||(LA22_0>='^' && LA22_0<='z')||(LA22_0>='~' && LA22_0<='\uFFFF')) ) {s = 21;}

                        else if ( (LA22_0=='{') && ((( isValue() )||( isHead() )))) {s = 22;}

                        else if ( (LA22_0=='\''||LA22_0=='\\'||LA22_0=='}') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_49 = input.LA(1);

                         
                        int index22_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_49=='\n'||LA22_49=='\r'||(LA22_49>='\"' && LA22_49<='#')||LA22_49=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_49=='\t'||LA22_49==' ') ) {s = 46;}

                        else if ( ((LA22_49>='\u0000' && LA22_49<='\b')||(LA22_49>='\u000B' && LA22_49<='\f')||(LA22_49>='\u000E' && LA22_49<='\u001F')||LA22_49=='!'||(LA22_49>='$' && LA22_49<='\'')||LA22_49=='+'||(LA22_49>='-' && LA22_49<='9')||(LA22_49>=';' && LA22_49<='=')||(LA22_49>='?' && LA22_49<='Z')||(LA22_49>='^' && LA22_49<='z')||(LA22_49>='~' && LA22_49<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_49=='*'||LA22_49==':'||LA22_49=='>'||LA22_49=='['||LA22_49==']'||(LA22_49>='{' && LA22_49<='}')) ) {s = 48;}

                        else if ( ((LA22_49>='(' && LA22_49<=')')||LA22_49==',') ) {s = 49;}

                        else s = 60;

                         
                        input.seek(index22_49);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_74 = input.LA(1);

                         
                        int index22_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_74=='\n'||LA22_74=='\r'||(LA22_74>='\"' && LA22_74<='#')||LA22_74=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_74=='\t'||LA22_74==' ') && ((( isValue() )||( isHead() )))) {s = 71;}

                        else if ( ((LA22_74>='\u0000' && LA22_74<='\b')||(LA22_74>='\u000B' && LA22_74<='\f')||(LA22_74>='\u000E' && LA22_74<='\u001F')||LA22_74=='!'||(LA22_74>='$' && LA22_74<='\'')||LA22_74=='+'||(LA22_74>='-' && LA22_74<='9')||(LA22_74>=';' && LA22_74<='=')||(LA22_74>='?' && LA22_74<='Z')||(LA22_74>='^' && LA22_74<='z')||(LA22_74>='~' && LA22_74<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA22_74=='*'||LA22_74==':'||LA22_74=='>'||LA22_74=='['||LA22_74==']'||(LA22_74>='{' && LA22_74<='}')) && ((( isValue() )||( isHead() )))) {s = 73;}

                        else if ( ((LA22_74>='(' && LA22_74<=')')||LA22_74==',') && ((( isHead() )||( isValue() )))) {s = 74;}

                        else s = 70;

                         
                        input.seek(index22_74);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_10 = input.LA(1);

                         
                        int index22_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_10>='\u0000' && LA22_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 37;

                         
                        input.seek(index22_10);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_88 = input.LA(1);

                         
                        int index22_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_88=='\n'||LA22_88=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_88=='#') ) {s = 59;}

                        else if ( (LA22_88=='\"') ) {s = 58;}

                        else if ( ((LA22_88>='\u0000' && LA22_88<='\t')||(LA22_88>='\u000B' && LA22_88<='\f')||(LA22_88>='\u000E' && LA22_88<='!')||(LA22_88>='$' && LA22_88<='[')||(LA22_88>=']' && LA22_88<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_88=='\\') ) {s = 57;}

                         
                        input.seek(index22_88);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_64 = input.LA(1);

                         
                        int index22_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_64=='\n') && (( isHead() ))) {s = 98;}

                        else s = 99;

                         
                        input.seek(index22_64);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_57 = input.LA(1);

                         
                        int index22_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_57=='\"') ) {s = 85;}

                        else if ( (LA22_57=='\\') ) {s = 86;}

                        else if ( (LA22_57=='/') ) {s = 87;}

                        else if ( (LA22_57=='b') ) {s = 88;}

                        else if ( (LA22_57=='f') ) {s = 89;}

                        else if ( (LA22_57=='n') ) {s = 90;}

                        else if ( (LA22_57=='r') ) {s = 91;}

                        else if ( (LA22_57=='t') ) {s = 92;}

                        else if ( (LA22_57=='u') ) {s = 93;}

                        else if ( ((LA22_57>='\u0000' && LA22_57<='!')||(LA22_57>='#' && LA22_57<='.')||(LA22_57>='0' && LA22_57<='[')||(LA22_57>=']' && LA22_57<='a')||(LA22_57>='c' && LA22_57<='e')||(LA22_57>='g' && LA22_57<='m')||(LA22_57>='o' && LA22_57<='q')||LA22_57=='s'||(LA22_57>='v' && LA22_57<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_57);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_103 = input.LA(1);

                         
                        int index22_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_103=='\"') ) {s = 95;}

                        else if ( ((LA22_103>='\u0000' && LA22_103<='\t')||(LA22_103>='\u000B' && LA22_103<='\f')||(LA22_103>='\u000E' && LA22_103<='!')||(LA22_103>='#' && LA22_103<='[')||(LA22_103>=']' && LA22_103<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_103=='\\') ) {s = 97;}

                        else if ( (LA22_103=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_103);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_19 = input.LA(1);

                         
                        int index22_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_19=='\t'||LA22_19==' ') ) {s = 46;}

                        else if ( ((LA22_19>='\u0000' && LA22_19<='\b')||(LA22_19>='\u000B' && LA22_19<='\f')||(LA22_19>='\u000E' && LA22_19<='\u001F')||LA22_19=='!'||(LA22_19>='$' && LA22_19<='\'')||LA22_19=='+'||(LA22_19>='-' && LA22_19<='9')||(LA22_19>=';' && LA22_19<='=')||(LA22_19>='?' && LA22_19<='Z')||(LA22_19>='^' && LA22_19<='z')||(LA22_19>='~' && LA22_19<='\uFFFF')) ) {s = 53;}

                        else if ( (LA22_19=='*'||LA22_19==':'||LA22_19=='>'||LA22_19=='['||LA22_19==']'||(LA22_19>='{' && LA22_19<='}')) ) {s = 54;}

                        else if ( ((LA22_19>='(' && LA22_19<=')')||LA22_19==',') ) {s = 55;}

                        else if ( (LA22_19=='\n'||LA22_19=='\r'||LA22_19=='\"'||LA22_19=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_19=='#') && ((( isValue() )||( isHead() )))) {s = 42;}

                        else s = 52;

                         
                        input.seek(index22_19);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_112 = input.LA(1);

                         
                        int index22_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_112>='0' && LA22_112<='9')||(LA22_112>='A' && LA22_112<='F')||(LA22_112>='a' && LA22_112<='f')) ) {s = 114;}

                        else if ( ((LA22_112>='\u0000' && LA22_112<='\t')||(LA22_112>='\u000B' && LA22_112<='/')||(LA22_112>=':' && LA22_112<='@')||(LA22_112>='G' && LA22_112<='`')||(LA22_112>='g' && LA22_112<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_112);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA22_48 = input.LA(1);

                         
                        int index22_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_48=='\n'||LA22_48=='\r'||(LA22_48>='\"' && LA22_48<='#')||LA22_48=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_48=='\t'||LA22_48==' ') ) {s = 46;}

                        else if ( ((LA22_48>='\u0000' && LA22_48<='\b')||(LA22_48>='\u000B' && LA22_48<='\f')||(LA22_48>='\u000E' && LA22_48<='\u001F')||LA22_48=='!'||(LA22_48>='$' && LA22_48<='\'')||LA22_48=='+'||(LA22_48>='-' && LA22_48<='9')||(LA22_48>=';' && LA22_48<='=')||(LA22_48>='?' && LA22_48<='Z')||(LA22_48>='^' && LA22_48<='z')||(LA22_48>='~' && LA22_48<='\uFFFF')) ) {s = 47;}

                        else if ( (LA22_48=='*'||LA22_48==':'||LA22_48=='>'||LA22_48=='['||LA22_48==']'||(LA22_48>='{' && LA22_48<='}')) ) {s = 48;}

                        else if ( ((LA22_48>='(' && LA22_48<=')')||LA22_48==',') ) {s = 49;}

                        else s = 60;

                         
                        input.seek(index22_48);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA22_73 = input.LA(1);

                         
                        int index22_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_73=='\n'||LA22_73=='\r'||(LA22_73>='\"' && LA22_73<='#')||LA22_73=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_73=='\t'||LA22_73==' ') && ((( isValue() )||( isHead() )))) {s = 71;}

                        else if ( ((LA22_73>='\u0000' && LA22_73<='\b')||(LA22_73>='\u000B' && LA22_73<='\f')||(LA22_73>='\u000E' && LA22_73<='\u001F')||LA22_73=='!'||(LA22_73>='$' && LA22_73<='\'')||LA22_73=='+'||(LA22_73>='-' && LA22_73<='9')||(LA22_73>=';' && LA22_73<='=')||(LA22_73>='?' && LA22_73<='Z')||(LA22_73>='^' && LA22_73<='z')||(LA22_73>='~' && LA22_73<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA22_73=='*'||LA22_73==':'||LA22_73=='>'||LA22_73=='['||LA22_73==']'||(LA22_73>='{' && LA22_73<='}')) && ((( isValue() )||( isHead() )))) {s = 73;}

                        else if ( ((LA22_73>='(' && LA22_73<=')')||LA22_73==',') && ((( isHead() )||( isValue() )))) {s = 74;}

                        else s = 70;

                         
                        input.seek(index22_73);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA22_102 = input.LA(1);

                         
                        int index22_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_102=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_102=='\"') ) {s = 95;}

                        else if ( ((LA22_102>='\u0000' && LA22_102<='\t')||(LA22_102>='\u000B' && LA22_102<='\f')||(LA22_102>='\u000E' && LA22_102<='!')||(LA22_102>='#' && LA22_102<='[')||(LA22_102>=']' && LA22_102<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_102=='\\') ) {s = 97;}

                         
                        input.seek(index22_102);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_90=='\n'||LA22_90=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_90=='#') ) {s = 59;}

                        else if ( (LA22_90=='\"') ) {s = 58;}

                        else if ( ((LA22_90>='\u0000' && LA22_90<='\t')||(LA22_90>='\u000B' && LA22_90<='\f')||(LA22_90>='\u000E' && LA22_90<='!')||(LA22_90>='$' && LA22_90<='[')||(LA22_90>=']' && LA22_90<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_90=='\\') ) {s = 57;}

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_9>='\u0000' && LA22_9<='\b')||(LA22_9>='\u000B' && LA22_9<='\f')||(LA22_9>='\u000E' && LA22_9<='\u001F')||(LA22_9>='!' && LA22_9<='\"')||LA22_9=='$'||(LA22_9>='&' && LA22_9<=',')||(LA22_9>='.' && LA22_9<='?')||(LA22_9>='A' && LA22_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_9=='\t'||LA22_9==' ') ) {s = 33;}

                        else if ( (LA22_9=='\n'||LA22_9=='\r') && (( isHead() ))) {s = 35;}

                        else s = 31;

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA22_84 = input.LA(1);

                         
                        int index22_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_84=='\n'||LA22_84=='\r'||(LA22_84>='\"' && LA22_84<='#')||LA22_84=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_84=='\t'||LA22_84==' ') ) {s = 81;}

                        else if ( ((LA22_84>='\u0000' && LA22_84<='\b')||(LA22_84>='\u000B' && LA22_84<='\f')||(LA22_84>='\u000E' && LA22_84<='\u001F')||LA22_84=='!'||(LA22_84>='$' && LA22_84<='\'')||LA22_84=='+'||(LA22_84>='-' && LA22_84<='9')||(LA22_84>=';' && LA22_84<='=')||(LA22_84>='?' && LA22_84<='Z')||(LA22_84>='^' && LA22_84<='z')||(LA22_84>='~' && LA22_84<='\uFFFF')) ) {s = 82;}

                        else if ( (LA22_84=='*'||LA22_84==':'||LA22_84=='>'||LA22_84=='['||LA22_84==']'||(LA22_84>='{' && LA22_84<='}')) ) {s = 83;}

                        else if ( ((LA22_84>='(' && LA22_84<=')')||LA22_84==',') ) {s = 84;}

                        else s = 80;

                         
                        input.seek(index22_84);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA22_22 = input.LA(1);

                         
                        int index22_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_22>='\u0000' && LA22_22<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index22_22);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA22_117 = input.LA(1);

                         
                        int index22_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_117=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_117=='\"') ) {s = 95;}

                        else if ( ((LA22_117>='\u0000' && LA22_117<='\t')||(LA22_117>='\u000B' && LA22_117<='\f')||(LA22_117>='\u000E' && LA22_117<='!')||(LA22_117>='#' && LA22_117<='[')||(LA22_117>=']' && LA22_117<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_117=='\\') ) {s = 97;}

                         
                        input.seek(index22_117);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_42=='\t'||LA22_42==' ') && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( ((LA22_42>='\u0000' && LA22_42<='\b')||(LA22_42>='\u000B' && LA22_42<='\f')||(LA22_42>='\u000E' && LA22_42<='\u001F')||LA22_42=='!'||(LA22_42>='$' && LA22_42<='\'')||LA22_42=='+'||(LA22_42>='-' && LA22_42<='9')||(LA22_42>=';' && LA22_42<='=')||(LA22_42>='?' && LA22_42<='Z')||(LA22_42>='^' && LA22_42<='z')||(LA22_42>='~' && LA22_42<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 76;}

                        else if ( (LA22_42=='*'||LA22_42==':'||LA22_42=='>'||LA22_42=='['||LA22_42==']'||(LA22_42>='{' && LA22_42<='}')) && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( ((LA22_42>='(' && LA22_42<=')')||LA22_42==',') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA22_42=='\r'||(LA22_42>='\"' && LA22_42<='#')||LA22_42=='\\') && (( isHead() ))) {s = 23;}

                        else s = 70;

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA22_41 = input.LA(1);

                         
                        int index22_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_41=='\n'||LA22_41=='\r'||(LA22_41>='\"' && LA22_41<='#')||LA22_41=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_41=='\t'||LA22_41==' ') && ((( isValue() )||( isHead() )))) {s = 71;}

                        else if ( ((LA22_41>='\u0000' && LA22_41<='\b')||(LA22_41>='\u000B' && LA22_41<='\f')||(LA22_41>='\u000E' && LA22_41<='\u001F')||LA22_41=='!'||(LA22_41>='$' && LA22_41<='\'')||LA22_41=='+'||(LA22_41>='-' && LA22_41<='9')||(LA22_41>=';' && LA22_41<='=')||(LA22_41>='?' && LA22_41<='Z')||(LA22_41>='^' && LA22_41<='z')||(LA22_41>='~' && LA22_41<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 72;}

                        else if ( (LA22_41=='*'||LA22_41==':'||LA22_41=='>'||LA22_41=='['||LA22_41==']'||(LA22_41>='{' && LA22_41<='}')) && ((( isValue() )||( isHead() )))) {s = 73;}

                        else if ( ((LA22_41>='(' && LA22_41<=')')||LA22_41==',') && ((( isHead() )||( isValue() )))) {s = 74;}

                        else s = 70;

                         
                        input.seek(index22_41);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA22_32 = input.LA(1);

                         
                        int index22_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_32>='\u0000' && LA22_32<='\b')||(LA22_32>='\u000B' && LA22_32<='\f')||(LA22_32>='\u000E' && LA22_32<='\u001F')||(LA22_32>='!' && LA22_32<='\"')||LA22_32=='$'||(LA22_32>='&' && LA22_32<=',')||(LA22_32>='.' && LA22_32<='?')||(LA22_32>='A' && LA22_32<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_32==' ') ) {s = 32;}

                        else if ( (LA22_32=='-') ) {s = 28;}

                        else if ( (LA22_32=='\t') ) {s = 33;}

                        else if ( (LA22_32=='@') && (( isHead() ))) {s = 34;}

                        else if ( (LA22_32=='\n'||LA22_32=='\r') && (( isHead() ))) {s = 35;}

                        else s = 67;

                         
                        input.seek(index22_32);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA22_20 = input.LA(1);

                         
                        int index22_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_20>='\u0000' && LA22_20<='\t')||(LA22_20>='\u000B' && LA22_20<='\f')||(LA22_20>='\u000E' && LA22_20<='!')||(LA22_20>='$' && LA22_20<='[')||(LA22_20>=']' && LA22_20<='\uFFFF')) ) {s = 56;}

                        else if ( (LA22_20=='\\') ) {s = 57;}

                        else if ( (LA22_20=='\"') ) {s = 58;}

                        else if ( (LA22_20=='#') ) {s = 59;}

                        else if ( (LA22_20=='\n'||LA22_20=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_20);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_58>='\u0000' && LA22_58<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 94;

                         
                        input.seek(index22_58);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_14>='\u0000' && LA22_14<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 43;

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA22_50 = input.LA(1);

                         
                        int index22_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 79;}

                        else if ( (( isValue() )) ) {s = 61;}

                         
                        input.seek(index22_50);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA22_104 = input.LA(1);

                         
                        int index22_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_104=='\"') ) {s = 95;}

                        else if ( ((LA22_104>='\u0000' && LA22_104<='\t')||(LA22_104>='\u000B' && LA22_104<='\f')||(LA22_104>='\u000E' && LA22_104<='!')||(LA22_104>='#' && LA22_104<='[')||(LA22_104>=']' && LA22_104<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_104=='\\') ) {s = 97;}

                        else if ( (LA22_104=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_104);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA22_93 = input.LA(1);

                         
                        int index22_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_93>='\u0000' && LA22_93<='/')||(LA22_93>=':' && LA22_93<='@')||(LA22_93>='G' && LA22_93<='`')||(LA22_93>='g' && LA22_93<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_93>='0' && LA22_93<='9')||(LA22_93>='A' && LA22_93<='F')||(LA22_93>='a' && LA22_93<='f')) ) {s = 100;}

                         
                        input.seek(index22_93);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_113>='\u0000' && LA22_113<='/')||(LA22_113>=':' && LA22_113<='@')||(LA22_113>='G' && LA22_113<='`')||(LA22_113>='g' && LA22_113<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_113>='0' && LA22_113<='9')||(LA22_113>='A' && LA22_113<='F')||(LA22_113>='a' && LA22_113<='f')) ) {s = 115;}

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA22_95 = input.LA(1);

                         
                        int index22_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_95>='\u0000' && LA22_95<='\t')||(LA22_95>='\u000B' && LA22_95<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 94;

                         
                        input.seek(index22_95);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_59=='\"') ) {s = 95;}

                        else if ( ((LA22_59>='\u0000' && LA22_59<='\t')||(LA22_59>='\u000B' && LA22_59<='\f')||(LA22_59>='\u000E' && LA22_59<='!')||(LA22_59>='#' && LA22_59<='[')||(LA22_59>=']' && LA22_59<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_59=='\\') ) {s = 97;}

                        else if ( (LA22_59=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA22_107 = input.LA(1);

                         
                        int index22_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_107=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_107=='\"') ) {s = 95;}

                        else if ( ((LA22_107>='\u0000' && LA22_107<='\t')||(LA22_107>='\u000B' && LA22_107<='\f')||(LA22_107>='\u000E' && LA22_107<='!')||(LA22_107>='#' && LA22_107<='[')||(LA22_107>=']' && LA22_107<='\uFFFF')) ) {s = 96;}

                        else if ( (LA22_107=='\\') ) {s = 97;}

                         
                        input.seek(index22_107);
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
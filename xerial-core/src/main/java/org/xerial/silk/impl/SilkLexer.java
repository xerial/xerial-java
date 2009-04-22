// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-22 10:07:57

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
import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
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
    public static final int PlainUnsafeChar=51;
    public static final int PlainSafeKey=52;
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
    public static final int FlowIndicator=49;
    public static final int Separation=59;
    public static final int Letter=40;
    public static final int PlainSafeIn=53;
    public static final int Comma=29;
    public static final int TabSeq=32;
    public static final int NonSpaceChar=45;
    public static final int EscapeSequence=43;
    public static final int DataLine=26;
    public static final int PlainFirst=55;
    public static final int WhiteSpace=19;
    public static final int MultiLineEntrySeparator=21;
    public static final int PlainSafeOut=54;
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
    public static final int Indicator=50;
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
    public static final int ScopeIndicator=48;
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


      @Override
      public void reportError(RecognitionException e) {
            String message = "line=" + getLine() + "(" + getCharPositionInLine() + "): " + e.toString();;
            throw new XerialError(XerialErrorCode.INVALID_TOKEN, message);
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:12: ( '#' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:145:14: '#' (~ ( '\\n' | '\\r' ) )* LineBreak
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:9: ({...}? => '%' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:11: {...}? => '%' (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "Preamble", " isHead() ");
            }
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:32: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:146:32: ~ ( '\\n' | '\\r' )
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

    // $ANTLR start "MultiLineSeparator"
    public final void mMultiLineSeparator() throws RecognitionException {
        try {
            int _type = MultiLineSeparator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:19: ({...}? => '--' ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:21: {...}? => '--' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineSeparator", " isHead() ");
            }
            match("--"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:43: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:43: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:24: ({...}? => '>>' ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:26: {...}? => '>>' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineEntrySeparator", " isHead() ");
            }
            match(">>"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:48: ( WhiteSpace )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:157:48: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:11: ({...}? => ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:30: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:31: ' '
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:15: ({...}? => ( ' ' )* '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:34: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:35: ' '
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:10: ({...}? => ( WhiteSpace )* LineBreak )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:12: {...}? => ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:29: ( WhiteSpace )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:29: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:78: (~ ( '#' | '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\"')||(LA9_0>='$' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:78: ~ ( '#' | '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:11: {...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment )
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:5: ( WhiteSpace )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            int DataLineBody1Start265 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start265, getCharIndex()-1);
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:30: ( LineBreak | LineComment )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:31: LineBreak
                    {
                    mLineBreak(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:41: LineComment
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:9: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:8: ':'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:4: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:7: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:7: ( '|' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:9: '|'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:8: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:6: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:11: '?'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:18: ( Digit | Letter )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:21: ( UnicodeChar | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:22: ( ( StringChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:24: ( StringChar )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:24: ( StringChar )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:24: StringChar
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:7: ( '\"' s= StringChar_s '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart566 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart566, getCharIndex()-1);
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

    // $ANTLR start "ScopeIndicator"
    public final void mScopeIndicator() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:24: ( '(' | ')' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:23: ( '[' | ']' | '{' | '}' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:25: ( '\"' | '\\\\' | LineBreakChar | '#' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:22: (~ ( PlainUnsafeChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:24: ~ ( PlainUnsafeChar )
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

    // $ANTLR start "PlainFirst"
    public final void mPlainFirst() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:2: (~ ( '-' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | ':' | '?' ) NonSpaceChar )
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
            else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||LA15_0=='$'||LA15_0=='&'||LA15_0=='+'||(LA15_0>='.' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='=')||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0=='-'||LA15_0==':') && (( isValue() ))) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:5: ~ ( '-' | PlainUnsafeChar | WhiteSpace | Indicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:212:4: {...}? => ( '-' | ':' | '?' ) NonSpaceChar
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    if ( input.LA(1)=='-'||input.LA(1)==':'||input.LA(1)=='?' ) {
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

    // $ANTLR start "PlainSafe"
    public final void mPlainSafe() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:218:4: {...}? => PlainSafeOut
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:2: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:4: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:15: ( ( WhiteSpace )* PlainSafe )*
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:16: ( WhiteSpace )* PlainSafe
            	    {
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:16: ( WhiteSpace )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='\t'||LA17_0==' ') && ((!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isOutValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isInValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isKey() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))))) {
            	            int LA17_1 = input.LA(2);

            	            if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:16: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:2: ({...}? => '{' | {...}? => '[' )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:4: {...}? => '{'
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:238:4: {...}? => '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:11: ({...}? => ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:31: ( WhiteSpace )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:31: WhiteSpace
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:254:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:254:4: ( ' ' | '\\t' )
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
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation | WhiteSpace )
        int alt21=26;
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:41: MultiLineSeparator
                {
                mMultiLineSeparator(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:60: MultiLineEntrySeparator
                {
                mMultiLineEntrySeparator(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:84: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:95: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:110: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:120: DataLine
                {
                mDataLine(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:129: LParen
                {
                mLParen(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:136: RParen
                {
                mRParen(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:143: Comma
                {
                mComma(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:149: Colon
                {
                mColon(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:155: Seq
                {
                mSeq(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:159: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:166: Star
                {
                mStar(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:171: At
                {
                mAt(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:174: Plus
                {
                mPlus(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:179: LBracket
                {
                mLBracket(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:188: RBracket
                {
                mRBracket(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:197: Question
                {
                mQuestion(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:206: String
                {
                mString(); 

                }
                break;
            case 23 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:213: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 24 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:226: JSON
                {
                mJSON(); 

                }
                break;
            case 25 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:231: Separation
                {
                mSeparation(); 

                }
                break;
            case 26 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:242: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\3\uffff\1\31\1\32\1\34\1\37\1\41\1\45\1\41\1\46\1\47\1\50\1\51"+
        "\1\54\1\55\1\56\1\63\1\64\1\65\1\uffff\1\75\1\76\1\uffff\1\77\2"+
        "\uffff\1\103\4\uffff\1\107\2\uffff\1\107\6\uffff\2\103\3\uffff\4"+
        "\75\3\uffff\3\123\2\uffff\1\141\5\uffff\1\103\2\uffff\2\147\4\uffff"+
        "\10\103\2\uffff\4\123\12\uffff\1\141\3\uffff\1\147\23\uffff";
    static final String DFA21_eofS =
        "\172\uffff";
    static final String DFA21_minS =
        "\1\0\2\uffff\1\12\23\0\1\uffff\3\0\1\11\2\uffff\1\0\1\uffff\2\0"+
        "\1\uffff\1\0\1\uffff\1\0\4\uffff\2\0\3\uffff\5\0\2\uffff\7\0\2\uffff"+
        "\1\0\1\uffff\1\0\2\uffff\1\12\2\0\3\uffff\10\0\2\uffff\15\0\1\uffff"+
        "\3\0\1\uffff\14\0\1\uffff\7\0";
    static final String DFA21_maxS =
        "\1\uffff\2\uffff\1\12\1\0\3\uffff\1\0\16\uffff\1\uffff\3\0\1\40"+
        "\2\uffff\1\uffff\1\uffff\1\uffff\1\0\1\uffff\1\uffff\1\uffff\1\0"+
        "\4\uffff\2\uffff\3\uffff\4\uffff\1\0\2\uffff\7\uffff\2\uffff\1\0"+
        "\1\uffff\1\uffff\2\uffff\1\12\1\0\1\uffff\3\uffff\10\uffff\2\uffff"+
        "\15\uffff\1\uffff\3\uffff\1\uffff\2\0\12\uffff\1\uffff\7\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\24\uffff\1\11\4\uffff\1\6\1\27\1\uffff\1\16\2"+
        "\uffff\1\10\1\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\2\uffff\1\17"+
        "\1\20\1\22\5\uffff\1\24\1\25\7\uffff\1\27\1\30\1\uffff\1\3\1\uffff"+
        "\1\4\1\27\3\uffff\1\31\1\32\1\21\10\uffff\1\23\1\27\15\uffff\1\26"+
        "\3\uffff\1\27\14\uffff\1\5\7\uffff";
    static final String DFA21_specialS =
        "\1\26\4\uffff\1\22\1\75\1\7\1\uffff\1\47\1\27\1\35\1\113\1\112"+
        "\1\17\1\114\1\12\1\63\1\44\1\45\1\102\1\105\1\121\2\uffff\1\77\1"+
        "\76\1\111\2\uffff\1\36\1\uffff\1\15\1\127\1\uffff\1\4\1\uffff\1"+
        "\1\4\uffff\1\110\1\10\3\uffff\1\24\1\101\1\70\1\42\1\56\2\uffff"+
        "\1\0\1\126\1\51\1\66\1\64\1\13\1\14\2\uffff\1\100\1\uffff\1\67\2"+
        "\uffff\1\6\1\20\1\115\3\uffff\1\25\1\103\1\71\1\43\1\53\1\60\1\124"+
        "\1\2\2\uffff\1\21\1\122\1\50\1\61\1\54\1\55\1\123\1\72\1\107\1\116"+
        "\1\65\1\52\1\37\1\uffff\1\41\1\30\1\3\1\uffff\1\33\1\31\1\120\1"+
        "\57\1\46\1\23\1\106\1\125\1\74\1\32\1\34\1\117\1\uffff\1\62\1\5"+
        "\1\73\1\11\1\16\1\40\1\104}>";
    static final String[] DFA21_transitionS = {
            "\11\25\1\11\1\4\2\25\1\3\22\25\1\7\1\25\1\24\1\1\1\25\1\2\1"+
            "\25\1\27\1\12\1\13\1\17\1\20\1\14\1\5\14\25\1\15\3\25\1\6\1"+
            "\23\1\10\32\25\1\21\1\27\1\22\35\25\1\26\1\16\1\27\uff82\25",
            "",
            "",
            "\1\30",
            "\1\uffff",
            "\11\35\2\uffff\2\35\1\uffff\22\35\1\uffff\1\35\1\uffff\12"+
            "\35\1\33\56\35\1\uffff\uffa3\35",
            "\76\27\1\36\uffc1\27",
            "\11\27\1\43\1\42\2\27\1\42\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\34\22\27\1\44\uffbf\27",
            "\1\uffff",
            "\11\27\1\43\1\42\2\27\1\42\22\27\1\43\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\52\2\27\2\52\1\27\22\52\1\27\1\52\1\27\1\53\70\52\1\27"+
            "\uffa3\52",
            "\0\27",
            "\0\27",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\0\27",
            "\0\27",
            "\11\66\1\57\1\27\2\66\1\27\22\66\1\57\1\66\1\27\1\53\4\66"+
            "\2\70\1\67\1\66\1\70\15\66\1\67\3\66\1\67\34\66\1\67\1\27\1"+
            "\67\35\66\3\67\uff82\66",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\0\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\101\1\102\2\uffff\1\102\22\uffff\1\101",
            "",
            "",
            "\11\27\1\106\1\105\2\27\1\104\22\27\1\106\uffdf\27",
            "",
            "\11\27\1\43\1\42\2\27\1\42\22\27\1\40\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\34\22\27\1\44\uffbf\27",
            "\1\uffff",
            "",
            "\11\27\1\43\1\42\2\27\1\42\22\27\1\43\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\11\113\1\112\1\27\2\113\1\27\22\113\1\112\1\113\2\27\4\113"+
            "\2\115\1\114\1\113\1\115\15\113\1\114\3\113\1\114\34\113\1\114"+
            "\1\27\1\114\35\113\3\114\uff82\113",
            "\11\117\1\116\1\27\2\117\1\27\22\117\1\116\1\117\2\27\4\117"+
            "\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117\1\120"+
            "\1\27\1\120\35\117\3\120\uff82\117",
            "",
            "",
            "",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\11\60\1\57\1\27\2\60\1\27\22\60\1\57\1\60\2\27\4\60\2\62"+
            "\1\61\1\60\1\62\15\60\1\61\3\60\1\61\34\60\1\61\1\27\1\61\35"+
            "\60\3\61\uff82\60",
            "\1\uffff",
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
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\42\27\1\130\14\27\1\132\54\27\1\131\5\27\1\133\3\27\1\134"+
            "\7\27\1\135\3\27\1\136\1\27\1\137\1\140\uff8a\27",
            "\0\27",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "",
            "",
            "\1\uffff",
            "",
            "\11\145\1\101\1\102\2\145\1\102\22\145\1\101\1\145\2\uffff"+
            "\70\145\1\uffff\uffa3\145",
            "",
            "",
            "\1\146",
            "\1\uffff",
            "\11\27\1\106\1\105\2\27\1\104\22\27\1\106\uffdf\27",
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
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\60\27\12\150\7\27\6\150\32\27\6\150\uff99\27",
            "",
            "\0\27",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\42\27\1\151\14\27\1\153\54\27\1\152\5\27\1\154\3\27\1\155"+
            "\7\27\1\156\3\27\1\157\1\27\1\160\1\161\uff8a\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\60\27\12\163\7\27\6\163\32\27\6\163\uff99\27",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143",
            "\60\27\12\164\7\27\6\164\32\27\6\164\uff99\27",
            "",
            "\60\27\12\165\7\27\6\165\32\27\6\165\uff99\27",
            "\60\27\12\166\7\27\6\166\32\27\6\166\uff99\27",
            "\60\27\12\167\7\27\6\167\32\27\6\167\uff99\27",
            "\60\27\12\170\7\27\6\170\32\27\6\170\uff99\27",
            "\12\71\1\27\2\71\1\27\24\71\1\73\1\74\70\71\1\72\uffa3\71",
            "\60\27\12\171\7\27\6\171\32\27\6\171\uff99\27",
            "\12\143\1\27\2\143\1\27\24\143\1\142\71\143\1\144\uffa3\143"
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
                        int LA21_54 = input.LA(1);

                         
                        int index21_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_54=='\t'||LA21_54==' ') ) {s = 84;}

                        else if ( ((LA21_54>='\u0000' && LA21_54<='\b')||(LA21_54>='\u000B' && LA21_54<='\f')||(LA21_54>='\u000E' && LA21_54<='\u001F')||LA21_54=='!'||(LA21_54>='$' && LA21_54<='\'')||LA21_54=='+'||(LA21_54>='-' && LA21_54<='9')||(LA21_54>=';' && LA21_54<='=')||(LA21_54>='?' && LA21_54<='Z')||(LA21_54>='^' && LA21_54<='z')||(LA21_54>='~' && LA21_54<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_54=='*'||LA21_54==':'||LA21_54=='>'||LA21_54=='['||LA21_54==']'||(LA21_54>='{' && LA21_54<='}')) ) {s = 86;}

                        else if ( ((LA21_54>='(' && LA21_54<=')')||LA21_54==',') ) {s = 87;}

                        else if ( (LA21_54=='\n'||LA21_54=='\r'||(LA21_54>='\"' && LA21_54<='#')||LA21_54=='\\') && (( isHead() ))) {s = 23;}

                        else s = 83;

                         
                        input.seek(index21_54);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_37 = input.LA(1);

                         
                        int index21_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 36;}

                        else if ( (true) ) {s = 73;}

                         
                        input.seek(index21_37);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_81 = input.LA(1);

                         
                        int index21_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_81=='\t'||LA21_81==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_81>='\u0000' && LA21_81<='\b')||(LA21_81>='\u000B' && LA21_81<='\f')||(LA21_81>='\u000E' && LA21_81<='\u001F')||LA21_81=='!'||(LA21_81>='$' && LA21_81<='\'')||LA21_81=='+'||(LA21_81>='-' && LA21_81<='9')||(LA21_81>=';' && LA21_81<='=')||(LA21_81>='?' && LA21_81<='Z')||(LA21_81>='^' && LA21_81<='z')||(LA21_81>='~' && LA21_81<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_81=='*'||LA21_81==':'||LA21_81=='>'||LA21_81=='['||LA21_81==']'||(LA21_81>='{' && LA21_81<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_81>='(' && LA21_81<=')')||LA21_81==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA21_81=='\n'||LA21_81=='\r'||(LA21_81>='\"' && LA21_81<='#')||LA21_81=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_81);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_100 = input.LA(1);

                         
                        int index21_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_100=='\"') ) {s = 105;}

                        else if ( (LA21_100=='\\') ) {s = 106;}

                        else if ( (LA21_100=='/') ) {s = 107;}

                        else if ( (LA21_100=='b') ) {s = 108;}

                        else if ( (LA21_100=='f') ) {s = 109;}

                        else if ( (LA21_100=='n') ) {s = 110;}

                        else if ( (LA21_100=='r') ) {s = 111;}

                        else if ( (LA21_100=='t') ) {s = 112;}

                        else if ( (LA21_100=='u') ) {s = 113;}

                        else if ( ((LA21_100>='\u0000' && LA21_100<='!')||(LA21_100>='#' && LA21_100<='.')||(LA21_100>='0' && LA21_100<='[')||(LA21_100>=']' && LA21_100<='a')||(LA21_100>='c' && LA21_100<='e')||(LA21_100>='g' && LA21_100<='m')||(LA21_100>='o' && LA21_100<='q')||LA21_100=='s'||(LA21_100>='v' && LA21_100<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_100);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_35 = input.LA(1);

                         
                        int index21_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_35=='\n'||LA21_35=='\r') && (( isHead() ))) {s = 34;}

                        else if ( (LA21_35=='\t'||LA21_35==' ') && ((( !isHead() )||( isHead() )))) {s = 35;}

                        else if ( ((LA21_35>='\u0000' && LA21_35<='\b')||(LA21_35>='\u000B' && LA21_35<='\f')||(LA21_35>='\u000E' && LA21_35<='\u001F')||(LA21_35>='!' && LA21_35<='\"')||LA21_35=='$'||(LA21_35>='&' && LA21_35<=',')||(LA21_35>='.' && LA21_35<='?')||(LA21_35>='A' && LA21_35<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 71;

                         
                        input.seek(index21_35);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_116 = input.LA(1);

                         
                        int index21_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_116>='0' && LA21_116<='9')||(LA21_116>='A' && LA21_116<='F')||(LA21_116>='a' && LA21_116<='f')) ) {s = 118;}

                        else if ( ((LA21_116>='\u0000' && LA21_116<='/')||(LA21_116>=':' && LA21_116<='@')||(LA21_116>='G' && LA21_116<='`')||(LA21_116>='g' && LA21_116<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_116);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_68 = input.LA(1);

                         
                        int index21_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_68=='\n') && (( isHead() ))) {s = 102;}

                        else s = 103;

                         
                        input.seek(index21_68);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_7=='-') && (( isHead() ))) {s = 28;}

                        else if ( (LA21_7==' ') && ((( !isHead() )||( isHead() )))) {s = 32;}

                        else if ( (LA21_7=='\n'||LA21_7=='\r') && (( isHead() ))) {s = 34;}

                        else if ( (LA21_7=='\t') && ((( !isHead() )||( isHead() )))) {s = 35;}

                        else if ( ((LA21_7>='\u0000' && LA21_7<='\b')||(LA21_7>='\u000B' && LA21_7<='\f')||(LA21_7>='\u000E' && LA21_7<='\u001F')||(LA21_7>='!' && LA21_7<='\"')||LA21_7=='$'||(LA21_7>='&' && LA21_7<=',')||(LA21_7>='.' && LA21_7<='?')||(LA21_7>='A' && LA21_7<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_7=='@') && (( isHead() ))) {s = 36;}

                        else s = 33;

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA21_43 = input.LA(1);

                         
                        int index21_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_43=='\t'||LA21_43==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( (LA21_43=='\n'||LA21_43=='\r'||(LA21_43>='\"' && LA21_43<='#')||LA21_43=='\\') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_43>='\u0000' && LA21_43<='\b')||(LA21_43>='\u000B' && LA21_43<='\f')||(LA21_43>='\u000E' && LA21_43<='\u001F')||LA21_43=='!'||(LA21_43>='$' && LA21_43<='\'')||LA21_43=='+'||(LA21_43>='-' && LA21_43<='9')||(LA21_43>=';' && LA21_43<='=')||(LA21_43>='?' && LA21_43<='Z')||(LA21_43>='^' && LA21_43<='z')||(LA21_43>='~' && LA21_43<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_43=='*'||LA21_43==':'||LA21_43=='>'||LA21_43=='['||LA21_43==']'||(LA21_43>='{' && LA21_43<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_43>='(' && LA21_43<=')')||LA21_43==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else s = 67;

                         
                        input.seek(index21_43);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA21_118 = input.LA(1);

                         
                        int index21_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_118>='0' && LA21_118<='9')||(LA21_118>='A' && LA21_118<='F')||(LA21_118>='a' && LA21_118<='f')) ) {s = 120;}

                        else if ( ((LA21_118>='\u0000' && LA21_118<='/')||(LA21_118>=':' && LA21_118<='@')||(LA21_118>='G' && LA21_118<='`')||(LA21_118>='g' && LA21_118<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_118);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA21_16 = input.LA(1);

                         
                        int index21_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_16=='\t'||LA21_16==' ') ) {s = 47;}

                        else if ( ((LA21_16>='\u0000' && LA21_16<='\b')||(LA21_16>='\u000B' && LA21_16<='\f')||(LA21_16>='\u000E' && LA21_16<='\u001F')||LA21_16=='!'||(LA21_16>='$' && LA21_16<='\'')||LA21_16=='+'||(LA21_16>='-' && LA21_16<='9')||(LA21_16>=';' && LA21_16<='=')||(LA21_16>='?' && LA21_16<='Z')||(LA21_16>='^' && LA21_16<='z')||(LA21_16>='~' && LA21_16<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_16=='*'||LA21_16==':'||LA21_16=='>'||LA21_16=='['||LA21_16==']'||(LA21_16>='{' && LA21_16<='}')) ) {s = 49;}

                        else if ( ((LA21_16>='(' && LA21_16<=')')||LA21_16==',') ) {s = 50;}

                        else if ( (LA21_16=='\n'||LA21_16=='\r'||(LA21_16>='\"' && LA21_16<='#')||LA21_16=='\\') && (( isHead() ))) {s = 23;}

                        else s = 46;

                         
                        input.seek(index21_16);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA21_59 = input.LA(1);

                         
                        int index21_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_59>='\u0000' && LA21_59<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 97;

                         
                        input.seek(index21_59);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA21_60 = input.LA(1);

                         
                        int index21_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_60=='\"') ) {s = 98;}

                        else if ( (LA21_60=='\n'||LA21_60=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_60>='\u0000' && LA21_60<='\t')||(LA21_60>='\u000B' && LA21_60<='\f')||(LA21_60>='\u000E' && LA21_60<='!')||(LA21_60>='#' && LA21_60<='[')||(LA21_60>=']' && LA21_60<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_60=='\\') ) {s = 100;}

                         
                        input.seek(index21_60);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA21_32 = input.LA(1);

                         
                        int index21_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_32=='-') && (( isHead() ))) {s = 28;}

                        else if ( (LA21_32==' ') && ((( !isHead() )||( isHead() )))) {s = 32;}

                        else if ( (LA21_32=='\n'||LA21_32=='\r') && (( isHead() ))) {s = 34;}

                        else if ( (LA21_32=='\t') && ((( !isHead() )||( isHead() )))) {s = 35;}

                        else if ( ((LA21_32>='\u0000' && LA21_32<='\b')||(LA21_32>='\u000B' && LA21_32<='\f')||(LA21_32>='\u000E' && LA21_32<='\u001F')||(LA21_32>='!' && LA21_32<='\"')||LA21_32=='$'||(LA21_32>='&' && LA21_32<=',')||(LA21_32>='.' && LA21_32<='?')||(LA21_32>='A' && LA21_32<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_32=='@') && (( isHead() ))) {s = 36;}

                        else s = 71;

                         
                        input.seek(index21_32);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA21_119 = input.LA(1);

                         
                        int index21_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_119=='\n'||LA21_119=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_119=='#') ) {s = 60;}

                        else if ( (LA21_119=='\"') ) {s = 59;}

                        else if ( ((LA21_119>='\u0000' && LA21_119<='\t')||(LA21_119>='\u000B' && LA21_119<='\f')||(LA21_119>='\u000E' && LA21_119<='!')||(LA21_119>='$' && LA21_119<='[')||(LA21_119>=']' && LA21_119<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_119=='\\') ) {s = 58;}

                         
                        input.seek(index21_119);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA21_14 = input.LA(1);

                         
                        int index21_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_14>='\u0000' && LA21_14<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 44;

                         
                        input.seek(index21_14);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA21_69 = input.LA(1);

                         
                        int index21_69 = input.index();
                        input.rewind();
                        s = -1;
                        s = 103;

                         
                        input.seek(index21_69);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA21_84 = input.LA(1);

                         
                        int index21_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_84=='\t'||LA21_84==' ') ) {s = 84;}

                        else if ( ((LA21_84>='\u0000' && LA21_84<='\b')||(LA21_84>='\u000B' && LA21_84<='\f')||(LA21_84>='\u000E' && LA21_84<='\u001F')||LA21_84=='!'||(LA21_84>='$' && LA21_84<='\'')||LA21_84=='+'||(LA21_84>='-' && LA21_84<='9')||(LA21_84>=';' && LA21_84<='=')||(LA21_84>='?' && LA21_84<='Z')||(LA21_84>='^' && LA21_84<='z')||(LA21_84>='~' && LA21_84<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_84=='*'||LA21_84==':'||LA21_84=='>'||LA21_84=='['||LA21_84==']'||(LA21_84>='{' && LA21_84<='}')) ) {s = 86;}

                        else if ( ((LA21_84>='(' && LA21_84<=')')||LA21_84==',') ) {s = 87;}

                        else if ( (LA21_84=='\n'||LA21_84=='\r'||(LA21_84>='\"' && LA21_84<='#')||LA21_84=='\\') && (( isHead() ))) {s = 23;}

                        else s = 83;

                         
                        input.seek(index21_84);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_5=='-') && ((( isHead() )||( isValue() )))) {s = 27;}

                        else if ( ((LA21_5>='\u0000' && LA21_5<='\b')||(LA21_5>='\u000B' && LA21_5<='\f')||(LA21_5>='\u000E' && LA21_5<='\u001F')||LA21_5=='!'||(LA21_5>='#' && LA21_5<=',')||(LA21_5>='.' && LA21_5<='[')||(LA21_5>=']' && LA21_5<='\uFFFF')) && (( isValue() ))) {s = 29;}

                        else s = 28;

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA21_107 = input.LA(1);

                         
                        int index21_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_107=='\"') ) {s = 98;}

                        else if ( ((LA21_107>='\u0000' && LA21_107<='\t')||(LA21_107>='\u000B' && LA21_107<='\f')||(LA21_107>='\u000E' && LA21_107<='!')||(LA21_107>='#' && LA21_107<='[')||(LA21_107>=']' && LA21_107<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_107=='\\') ) {s = 100;}

                        else if ( (LA21_107=='\n'||LA21_107=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_107);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA21_47 = input.LA(1);

                         
                        int index21_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_47=='\t'||LA21_47==' ') ) {s = 47;}

                        else if ( ((LA21_47>='\u0000' && LA21_47<='\b')||(LA21_47>='\u000B' && LA21_47<='\f')||(LA21_47>='\u000E' && LA21_47<='\u001F')||LA21_47=='!'||(LA21_47>='$' && LA21_47<='\'')||LA21_47=='+'||(LA21_47>='-' && LA21_47<='9')||(LA21_47>=';' && LA21_47<='=')||(LA21_47>='?' && LA21_47<='Z')||(LA21_47>='^' && LA21_47<='z')||(LA21_47>='~' && LA21_47<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_47=='*'||LA21_47==':'||LA21_47=='>'||LA21_47=='['||LA21_47==']'||(LA21_47>='{' && LA21_47<='}')) ) {s = 49;}

                        else if ( ((LA21_47>='(' && LA21_47<=')')||LA21_47==',') ) {s = 50;}

                        else if ( (LA21_47=='\n'||LA21_47=='\r'||(LA21_47>='\"' && LA21_47<='#')||LA21_47=='\\') && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index21_47);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA21_74 = input.LA(1);

                         
                        int index21_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_74=='\t'||LA21_74==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_74>='\u0000' && LA21_74<='\b')||(LA21_74>='\u000B' && LA21_74<='\f')||(LA21_74>='\u000E' && LA21_74<='\u001F')||LA21_74=='!'||(LA21_74>='$' && LA21_74<='\'')||LA21_74=='+'||(LA21_74>='-' && LA21_74<='9')||(LA21_74>=';' && LA21_74<='=')||(LA21_74>='?' && LA21_74<='Z')||(LA21_74>='^' && LA21_74<='z')||(LA21_74>='~' && LA21_74<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( (LA21_74=='*'||LA21_74==':'||LA21_74=='>'||LA21_74=='['||LA21_74==']'||(LA21_74>='{' && LA21_74<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_74>='(' && LA21_74<=')')||LA21_74==',') && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( (LA21_74=='\n'||LA21_74=='\r'||(LA21_74>='\"' && LA21_74<='#')||LA21_74=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_74);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_0=='#') ) {s = 1;}

                        else if ( (LA21_0=='%') && (( isHead() ))) {s = 2;}

                        else if ( (LA21_0=='\r') ) {s = 3;}

                        else if ( (LA21_0=='\n') ) {s = 4;}

                        else if ( (LA21_0=='-') && ((( isValue() )||( isHead() )))) {s = 5;}

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
                    case 23 : 
                        int LA21_10 = input.LA(1);

                         
                        int index21_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_10>='\u0000' && LA21_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 38;

                         
                        input.seek(index21_10);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA21_99 = input.LA(1);

                         
                        int index21_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_99=='\"') ) {s = 98;}

                        else if ( ((LA21_99>='\u0000' && LA21_99<='\t')||(LA21_99>='\u000B' && LA21_99<='\f')||(LA21_99>='\u000E' && LA21_99<='!')||(LA21_99>='#' && LA21_99<='[')||(LA21_99>=']' && LA21_99<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_99=='\\') ) {s = 100;}

                        else if ( (LA21_99=='\n'||LA21_99=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_99);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA21_103 = input.LA(1);

                         
                        int index21_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 114;}

                        else if ( (( isHead() )) ) {s = 23;}

                         
                        input.seek(index21_103);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA21_111 = input.LA(1);

                         
                        int index21_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_111=='\"') ) {s = 98;}

                        else if ( ((LA21_111>='\u0000' && LA21_111<='\t')||(LA21_111>='\u000B' && LA21_111<='\f')||(LA21_111>='\u000E' && LA21_111<='!')||(LA21_111>='#' && LA21_111<='[')||(LA21_111>=']' && LA21_111<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_111=='\\') ) {s = 100;}

                        else if ( (LA21_111=='\n'||LA21_111=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_111);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA21_102 = input.LA(1);

                         
                        int index21_102 = input.index();
                        input.rewind();
                        s = -1;
                        s = 103;

                         
                        input.seek(index21_102);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA21_112 = input.LA(1);

                         
                        int index21_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_112=='\"') ) {s = 98;}

                        else if ( ((LA21_112>='\u0000' && LA21_112<='\t')||(LA21_112>='\u000B' && LA21_112<='\f')||(LA21_112>='\u000E' && LA21_112<='!')||(LA21_112>='#' && LA21_112<='[')||(LA21_112>=']' && LA21_112<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_112=='\\') ) {s = 100;}

                        else if ( (LA21_112=='\n'||LA21_112=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_112);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA21_11 = input.LA(1);

                         
                        int index21_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_11>='\u0000' && LA21_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 39;

                         
                        input.seek(index21_11);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA21_30 = input.LA(1);

                         
                        int index21_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_30=='\r') && (( isHead() ))) {s = 68;}

                        else if ( (LA21_30=='\n') && (( isHead() ))) {s = 69;}

                        else if ( ((LA21_30>='\u0000' && LA21_30<='\b')||(LA21_30>='\u000B' && LA21_30<='\f')||(LA21_30>='\u000E' && LA21_30<='\u001F')||(LA21_30>='!' && LA21_30<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_30=='\t'||LA21_30==' ') && (( isHead() ))) {s = 70;}

                         
                        input.seek(index21_30);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA21_96 = input.LA(1);

                         
                        int index21_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_96>='\u0000' && LA21_96<='/')||(LA21_96>=':' && LA21_96<='@')||(LA21_96>='G' && LA21_96<='`')||(LA21_96>='g' && LA21_96<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_96>='0' && LA21_96<='9')||(LA21_96>='A' && LA21_96<='F')||(LA21_96>='a' && LA21_96<='f')) ) {s = 104;}

                         
                        input.seek(index21_96);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA21_120 = input.LA(1);

                         
                        int index21_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_120>='0' && LA21_120<='9')||(LA21_120>='A' && LA21_120<='F')||(LA21_120>='a' && LA21_120<='f')) ) {s = 121;}

                        else if ( ((LA21_120>='\u0000' && LA21_120<='/')||(LA21_120>=':' && LA21_120<='@')||(LA21_120>='G' && LA21_120<='`')||(LA21_120>='g' && LA21_120<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_120);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA21_98 = input.LA(1);

                         
                        int index21_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_98>='\u0000' && LA21_98<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 97;

                         
                        input.seek(index21_98);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA21_50 = input.LA(1);

                         
                        int index21_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_50=='\n'||LA21_50=='\r'||(LA21_50>='\"' && LA21_50<='#')||LA21_50=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_50=='\t'||LA21_50==' ') ) {s = 47;}

                        else if ( ((LA21_50>='\u0000' && LA21_50<='\b')||(LA21_50>='\u000B' && LA21_50<='\f')||(LA21_50>='\u000E' && LA21_50<='\u001F')||LA21_50=='!'||(LA21_50>='$' && LA21_50<='\'')||LA21_50=='+'||(LA21_50>='-' && LA21_50<='9')||(LA21_50>=';' && LA21_50<='=')||(LA21_50>='?' && LA21_50<='Z')||(LA21_50>='^' && LA21_50<='z')||(LA21_50>='~' && LA21_50<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_50=='*'||LA21_50==':'||LA21_50=='>'||LA21_50=='['||LA21_50==']'||(LA21_50>='{' && LA21_50<='}')) ) {s = 49;}

                        else if ( ((LA21_50>='(' && LA21_50<=')')||LA21_50==',') ) {s = 50;}

                        else s = 61;

                         
                        input.seek(index21_50);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA21_77 = input.LA(1);

                         
                        int index21_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_77=='\n'||LA21_77=='\r'||(LA21_77>='\"' && LA21_77<='#')||LA21_77=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_77=='\t'||LA21_77==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_77>='\u0000' && LA21_77<='\b')||(LA21_77>='\u000B' && LA21_77<='\f')||(LA21_77>='\u000E' && LA21_77<='\u001F')||LA21_77=='!'||(LA21_77>='$' && LA21_77<='\'')||LA21_77=='+'||(LA21_77>='-' && LA21_77<='9')||(LA21_77>=';' && LA21_77<='=')||(LA21_77>='?' && LA21_77<='Z')||(LA21_77>='^' && LA21_77<='z')||(LA21_77>='~' && LA21_77<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( (LA21_77=='*'||LA21_77==':'||LA21_77=='>'||LA21_77=='['||LA21_77==']'||(LA21_77>='{' && LA21_77<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_77>='(' && LA21_77<=')')||LA21_77==',') && ((( isHead() )||( isValue() )))) {s = 77;}

                        else s = 67;

                         
                        input.seek(index21_77);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA21_18 = input.LA(1);

                         
                        int index21_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_18>='\u0000' && LA21_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 52;

                         
                        input.seek(index21_18);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA21_19 = input.LA(1);

                         
                        int index21_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_19=='\t'||LA21_19==' ') ) {s = 47;}

                        else if ( ((LA21_19>='\u0000' && LA21_19<='\b')||(LA21_19>='\u000B' && LA21_19<='\f')||(LA21_19>='\u000E' && LA21_19<='\u001F')||LA21_19=='!'||(LA21_19>='$' && LA21_19<='\'')||LA21_19=='+'||(LA21_19>='-' && LA21_19<='9')||(LA21_19>=';' && LA21_19<='=')||(LA21_19>='?' && LA21_19<='Z')||(LA21_19>='^' && LA21_19<='z')||(LA21_19>='~' && LA21_19<='\uFFFF')) ) {s = 54;}

                        else if ( (LA21_19=='*'||LA21_19==':'||LA21_19=='>'||LA21_19=='['||LA21_19==']'||(LA21_19>='{' && LA21_19<='}')) ) {s = 55;}

                        else if ( ((LA21_19>='(' && LA21_19<=')')||LA21_19==',') ) {s = 56;}

                        else if ( (LA21_19=='\n'||LA21_19=='\r'||LA21_19=='\"'||LA21_19=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_19=='#') && ((( isValue() )||( isHead() )))) {s = 43;}

                        else s = 53;

                         
                        input.seek(index21_19);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA21_106 = input.LA(1);

                         
                        int index21_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_106=='\"') ) {s = 98;}

                        else if ( ((LA21_106>='\u0000' && LA21_106<='\t')||(LA21_106>='\u000B' && LA21_106<='\f')||(LA21_106>='\u000E' && LA21_106<='!')||(LA21_106>='#' && LA21_106<='[')||(LA21_106>=']' && LA21_106<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_106=='\\') ) {s = 100;}

                        else if ( (LA21_106=='\n'||LA21_106=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_106);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_9=='\n'||LA21_9=='\r') && (( isHead() ))) {s = 34;}

                        else if ( (LA21_9=='\t'||LA21_9==' ') && ((( !isHead() )||( isHead() )))) {s = 35;}

                        else if ( ((LA21_9>='\u0000' && LA21_9<='\b')||(LA21_9>='\u000B' && LA21_9<='\f')||(LA21_9>='\u000E' && LA21_9<='\u001F')||(LA21_9>='!' && LA21_9<='\"')||LA21_9=='$'||(LA21_9>='&' && LA21_9<=',')||(LA21_9>='.' && LA21_9<='?')||(LA21_9>='A' && LA21_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 33;

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA21_86 = input.LA(1);

                         
                        int index21_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_86=='\n'||LA21_86=='\r'||(LA21_86>='\"' && LA21_86<='#')||LA21_86=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_86=='\t'||LA21_86==' ') ) {s = 84;}

                        else if ( ((LA21_86>='\u0000' && LA21_86<='\b')||(LA21_86>='\u000B' && LA21_86<='\f')||(LA21_86>='\u000E' && LA21_86<='\u001F')||LA21_86=='!'||(LA21_86>='$' && LA21_86<='\'')||LA21_86=='+'||(LA21_86>='-' && LA21_86<='9')||(LA21_86>=';' && LA21_86<='=')||(LA21_86>='?' && LA21_86<='Z')||(LA21_86>='^' && LA21_86<='z')||(LA21_86>='~' && LA21_86<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_86=='*'||LA21_86==':'||LA21_86=='>'||LA21_86=='['||LA21_86==']'||(LA21_86>='{' && LA21_86<='}')) ) {s = 86;}

                        else if ( ((LA21_86>='(' && LA21_86<=')')||LA21_86==',') ) {s = 87;}

                        else s = 83;

                         
                        input.seek(index21_86);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA21_56 = input.LA(1);

                         
                        int index21_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_56=='\n'||LA21_56=='\r'||(LA21_56>='\"' && LA21_56<='#')||LA21_56=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_56=='\t'||LA21_56==' ') ) {s = 84;}

                        else if ( ((LA21_56>='\u0000' && LA21_56<='\b')||(LA21_56>='\u000B' && LA21_56<='\f')||(LA21_56>='\u000E' && LA21_56<='\u001F')||LA21_56=='!'||(LA21_56>='$' && LA21_56<='\'')||LA21_56=='+'||(LA21_56>='-' && LA21_56<='9')||(LA21_56>=';' && LA21_56<='=')||(LA21_56>='?' && LA21_56<='Z')||(LA21_56>='^' && LA21_56<='z')||(LA21_56>='~' && LA21_56<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_56=='*'||LA21_56==':'||LA21_56=='>'||LA21_56=='['||LA21_56==']'||(LA21_56>='{' && LA21_56<='}')) ) {s = 86;}

                        else if ( ((LA21_56>='(' && LA21_56<=')')||LA21_56==',') ) {s = 87;}

                        else s = 83;

                         
                        input.seek(index21_56);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA21_95 = input.LA(1);

                         
                        int index21_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_95=='\n'||LA21_95=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_95=='#') ) {s = 60;}

                        else if ( (LA21_95=='\"') ) {s = 59;}

                        else if ( ((LA21_95>='\u0000' && LA21_95<='\t')||(LA21_95>='\u000B' && LA21_95<='\f')||(LA21_95>='\u000E' && LA21_95<='!')||(LA21_95>='$' && LA21_95<='[')||(LA21_95>=']' && LA21_95<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_95=='\\') ) {s = 58;}

                         
                        input.seek(index21_95);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA21_78 = input.LA(1);

                         
                        int index21_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_78=='\t'||LA21_78==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_78>='\u0000' && LA21_78<='\b')||(LA21_78>='\u000B' && LA21_78<='\f')||(LA21_78>='\u000E' && LA21_78<='\u001F')||LA21_78=='!'||(LA21_78>='$' && LA21_78<='\'')||LA21_78=='+'||(LA21_78>='-' && LA21_78<='9')||(LA21_78>=';' && LA21_78<='=')||(LA21_78>='?' && LA21_78<='Z')||(LA21_78>='^' && LA21_78<='z')||(LA21_78>='~' && LA21_78<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_78=='*'||LA21_78==':'||LA21_78=='>'||LA21_78=='['||LA21_78==']'||(LA21_78>='{' && LA21_78<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_78>='(' && LA21_78<=')')||LA21_78==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA21_78=='\n'||LA21_78=='\r'||(LA21_78>='\"' && LA21_78<='#')||LA21_78=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_78);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA21_88 = input.LA(1);

                         
                        int index21_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_88=='\n'||LA21_88=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_88=='#') ) {s = 60;}

                        else if ( (LA21_88=='\"') ) {s = 59;}

                        else if ( ((LA21_88>='\u0000' && LA21_88<='\t')||(LA21_88>='\u000B' && LA21_88<='\f')||(LA21_88>='\u000E' && LA21_88<='!')||(LA21_88>='$' && LA21_88<='[')||(LA21_88>=']' && LA21_88<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_88=='\\') ) {s = 58;}

                         
                        input.seek(index21_88);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA21_89 = input.LA(1);

                         
                        int index21_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_89=='\n'||LA21_89=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_89=='#') ) {s = 60;}

                        else if ( (LA21_89=='\"') ) {s = 59;}

                        else if ( ((LA21_89>='\u0000' && LA21_89<='\t')||(LA21_89>='\u000B' && LA21_89<='\f')||(LA21_89>='\u000E' && LA21_89<='!')||(LA21_89>='$' && LA21_89<='[')||(LA21_89>=']' && LA21_89<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_89=='\\') ) {s = 58;}

                         
                        input.seek(index21_89);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA21_51 = input.LA(1);

                         
                        int index21_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 82;}

                        else if ( (( isValue() )) ) {s = 62;}

                         
                        input.seek(index21_51);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA21_105 = input.LA(1);

                         
                        int index21_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_105=='\"') ) {s = 98;}

                        else if ( ((LA21_105>='\u0000' && LA21_105<='\t')||(LA21_105>='\u000B' && LA21_105<='\f')||(LA21_105>='\u000E' && LA21_105<='!')||(LA21_105>='#' && LA21_105<='[')||(LA21_105>=']' && LA21_105<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_105=='\\') ) {s = 100;}

                        else if ( (LA21_105=='\n'||LA21_105=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_105);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA21_79 = input.LA(1);

                         
                        int index21_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_79=='\t'||LA21_79==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_79>='\u0000' && LA21_79<='\b')||(LA21_79>='\u000B' && LA21_79<='\f')||(LA21_79>='\u000E' && LA21_79<='\u001F')||LA21_79=='!'||(LA21_79>='$' && LA21_79<='\'')||LA21_79=='+'||(LA21_79>='-' && LA21_79<='9')||(LA21_79>=';' && LA21_79<='=')||(LA21_79>='?' && LA21_79<='Z')||(LA21_79>='^' && LA21_79<='z')||(LA21_79>='~' && LA21_79<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_79=='*'||LA21_79==':'||LA21_79=='>'||LA21_79=='['||LA21_79==']'||(LA21_79>='{' && LA21_79<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_79>='(' && LA21_79<=')')||LA21_79==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA21_79=='\n'||LA21_79=='\r'||(LA21_79>='\"' && LA21_79<='#')||LA21_79=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_79);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA21_87 = input.LA(1);

                         
                        int index21_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_87=='\n'||LA21_87=='\r'||(LA21_87>='\"' && LA21_87<='#')||LA21_87=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_87=='\t'||LA21_87==' ') ) {s = 84;}

                        else if ( ((LA21_87>='\u0000' && LA21_87<='\b')||(LA21_87>='\u000B' && LA21_87<='\f')||(LA21_87>='\u000E' && LA21_87<='\u001F')||LA21_87=='!'||(LA21_87>='$' && LA21_87<='\'')||LA21_87=='+'||(LA21_87>='-' && LA21_87<='9')||(LA21_87>=';' && LA21_87<='=')||(LA21_87>='?' && LA21_87<='Z')||(LA21_87>='^' && LA21_87<='z')||(LA21_87>='~' && LA21_87<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_87=='*'||LA21_87==':'||LA21_87=='>'||LA21_87=='['||LA21_87==']'||(LA21_87>='{' && LA21_87<='}')) ) {s = 86;}

                        else if ( ((LA21_87>='(' && LA21_87<=')')||LA21_87==',') ) {s = 87;}

                        else s = 83;

                         
                        input.seek(index21_87);
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
                        int LA21_17 = input.LA(1);

                         
                        int index21_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_17>='\u0000' && LA21_17<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 51;

                         
                        input.seek(index21_17);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA21_58 = input.LA(1);

                         
                        int index21_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_58>='\u0000' && LA21_58<='!')||(LA21_58>='#' && LA21_58<='.')||(LA21_58>='0' && LA21_58<='[')||(LA21_58>=']' && LA21_58<='a')||(LA21_58>='c' && LA21_58<='e')||(LA21_58>='g' && LA21_58<='m')||(LA21_58>='o' && LA21_58<='q')||LA21_58=='s'||(LA21_58>='v' && LA21_58<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_58=='\"') ) {s = 88;}

                        else if ( (LA21_58=='\\') ) {s = 89;}

                        else if ( (LA21_58=='/') ) {s = 90;}

                        else if ( (LA21_58=='b') ) {s = 91;}

                        else if ( (LA21_58=='f') ) {s = 92;}

                        else if ( (LA21_58=='n') ) {s = 93;}

                        else if ( (LA21_58=='r') ) {s = 94;}

                        else if ( (LA21_58=='t') ) {s = 95;}

                        else if ( (LA21_58=='u') ) {s = 96;}

                         
                        input.seek(index21_58);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA21_94 = input.LA(1);

                         
                        int index21_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_94=='\"') ) {s = 59;}

                        else if ( (LA21_94=='#') ) {s = 60;}

                        else if ( (LA21_94=='\\') ) {s = 58;}

                        else if ( (LA21_94=='\n'||LA21_94=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_94>='\u0000' && LA21_94<='\t')||(LA21_94>='\u000B' && LA21_94<='\f')||(LA21_94>='\u000E' && LA21_94<='!')||(LA21_94>='$' && LA21_94<='[')||(LA21_94>=']' && LA21_94<='\uFFFF')) ) {s = 57;}

                         
                        input.seek(index21_94);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA21_57 = input.LA(1);

                         
                        int index21_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_57=='\n'||LA21_57=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_57=='#') ) {s = 60;}

                        else if ( (LA21_57=='\"') ) {s = 59;}

                        else if ( ((LA21_57>='\u0000' && LA21_57<='\t')||(LA21_57>='\u000B' && LA21_57<='\f')||(LA21_57>='\u000E' && LA21_57<='!')||(LA21_57>='$' && LA21_57<='[')||(LA21_57>=']' && LA21_57<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_57=='\\') ) {s = 58;}

                         
                        input.seek(index21_57);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA21_65 = input.LA(1);

                         
                        int index21_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_65=='\t'||LA21_65==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( ((LA21_65>='\u0000' && LA21_65<='\b')||(LA21_65>='\u000B' && LA21_65<='\f')||(LA21_65>='\u000E' && LA21_65<='\u001F')||LA21_65=='!'||(LA21_65>='$' && LA21_65<='[')||(LA21_65>=']' && LA21_65<='\uFFFF')) && (( isValue() ))) {s = 101;}

                        else if ( (LA21_65=='\n'||LA21_65=='\r') && (( isHead() ))) {s = 66;}

                        else s = 67;

                         
                        input.seek(index21_65);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA21_49 = input.LA(1);

                         
                        int index21_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_49=='\n'||LA21_49=='\r'||(LA21_49>='\"' && LA21_49<='#')||LA21_49=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_49=='\t'||LA21_49==' ') ) {s = 47;}

                        else if ( ((LA21_49>='\u0000' && LA21_49<='\b')||(LA21_49>='\u000B' && LA21_49<='\f')||(LA21_49>='\u000E' && LA21_49<='\u001F')||LA21_49=='!'||(LA21_49>='$' && LA21_49<='\'')||LA21_49=='+'||(LA21_49>='-' && LA21_49<='9')||(LA21_49>=';' && LA21_49<='=')||(LA21_49>='?' && LA21_49<='Z')||(LA21_49>='^' && LA21_49<='z')||(LA21_49>='~' && LA21_49<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_49=='*'||LA21_49==':'||LA21_49=='>'||LA21_49=='['||LA21_49==']'||(LA21_49>='{' && LA21_49<='}')) ) {s = 49;}

                        else if ( ((LA21_49>='(' && LA21_49<=')')||LA21_49==',') ) {s = 50;}

                        else s = 61;

                         
                        input.seek(index21_49);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA21_76 = input.LA(1);

                         
                        int index21_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_76=='\n'||LA21_76=='\r'||(LA21_76>='\"' && LA21_76<='#')||LA21_76=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_76=='\t'||LA21_76==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_76>='\u0000' && LA21_76<='\b')||(LA21_76>='\u000B' && LA21_76<='\f')||(LA21_76>='\u000E' && LA21_76<='\u001F')||LA21_76=='!'||(LA21_76>='$' && LA21_76<='\'')||LA21_76=='+'||(LA21_76>='-' && LA21_76<='9')||(LA21_76>=';' && LA21_76<='=')||(LA21_76>='?' && LA21_76<='Z')||(LA21_76>='^' && LA21_76<='z')||(LA21_76>='~' && LA21_76<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( (LA21_76=='*'||LA21_76==':'||LA21_76=='>'||LA21_76=='['||LA21_76==']'||(LA21_76>='{' && LA21_76<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_76>='(' && LA21_76<=')')||LA21_76==',') && ((( isHead() )||( isValue() )))) {s = 77;}

                        else s = 67;

                         
                        input.seek(index21_76);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA21_91 = input.LA(1);

                         
                        int index21_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_91=='\n'||LA21_91=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_91=='#') ) {s = 60;}

                        else if ( (LA21_91=='\"') ) {s = 59;}

                        else if ( ((LA21_91>='\u0000' && LA21_91<='\t')||(LA21_91>='\u000B' && LA21_91<='\f')||(LA21_91>='\u000E' && LA21_91<='!')||(LA21_91>='$' && LA21_91<='[')||(LA21_91>=']' && LA21_91<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_91=='\\') ) {s = 58;}

                         
                        input.seek(index21_91);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA21_117 = input.LA(1);

                         
                        int index21_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_117>='\u0000' && LA21_117<='/')||(LA21_117>=':' && LA21_117<='@')||(LA21_117>='G' && LA21_117<='`')||(LA21_117>='g' && LA21_117<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_117>='0' && LA21_117<='9')||(LA21_117>='A' && LA21_117<='F')||(LA21_117>='a' && LA21_117<='f')) ) {s = 119;}

                         
                        input.seek(index21_117);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA21_110 = input.LA(1);

                         
                        int index21_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_110=='\"') ) {s = 98;}

                        else if ( ((LA21_110>='\u0000' && LA21_110<='\t')||(LA21_110>='\u000B' && LA21_110<='\f')||(LA21_110>='\u000E' && LA21_110<='!')||(LA21_110>='#' && LA21_110<='[')||(LA21_110>=']' && LA21_110<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_110=='\\') ) {s = 100;}

                        else if ( (LA21_110=='\n'||LA21_110=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_110);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
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
                    case 62 : 
                        int LA21_26 = input.LA(1);

                         
                        int index21_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 34;}

                         
                        input.seek(index21_26);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA21_25 = input.LA(1);

                         
                        int index21_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 34;}

                         
                        input.seek(index21_25);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA21_63 = input.LA(1);

                         
                        int index21_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 64;}

                        else if ( (( isHead() )) ) {s = 34;}

                         
                        input.seek(index21_63);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA21_48 = input.LA(1);

                         
                        int index21_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_48=='\t'||LA21_48==' ') ) {s = 47;}

                        else if ( ((LA21_48>='\u0000' && LA21_48<='\b')||(LA21_48>='\u000B' && LA21_48<='\f')||(LA21_48>='\u000E' && LA21_48<='\u001F')||LA21_48=='!'||(LA21_48>='$' && LA21_48<='\'')||LA21_48=='+'||(LA21_48>='-' && LA21_48<='9')||(LA21_48>=';' && LA21_48<='=')||(LA21_48>='?' && LA21_48<='Z')||(LA21_48>='^' && LA21_48<='z')||(LA21_48>='~' && LA21_48<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_48=='*'||LA21_48==':'||LA21_48=='>'||LA21_48=='['||LA21_48==']'||(LA21_48>='{' && LA21_48<='}')) ) {s = 49;}

                        else if ( ((LA21_48>='(' && LA21_48<=')')||LA21_48==',') ) {s = 50;}

                        else if ( (LA21_48=='\n'||LA21_48=='\r'||(LA21_48>='\"' && LA21_48<='#')||LA21_48=='\\') && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index21_48);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA21_20 = input.LA(1);

                         
                        int index21_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_20>='\u0000' && LA21_20<='\t')||(LA21_20>='\u000B' && LA21_20<='\f')||(LA21_20>='\u000E' && LA21_20<='!')||(LA21_20>='$' && LA21_20<='[')||(LA21_20>=']' && LA21_20<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_20=='\\') ) {s = 58;}

                        else if ( (LA21_20=='\"') ) {s = 59;}

                        else if ( (LA21_20=='#') ) {s = 60;}

                        else if ( (LA21_20=='\n'||LA21_20=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_20);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA21_75 = input.LA(1);

                         
                        int index21_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_75=='\t'||LA21_75==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_75>='\u0000' && LA21_75<='\b')||(LA21_75>='\u000B' && LA21_75<='\f')||(LA21_75>='\u000E' && LA21_75<='\u001F')||LA21_75=='!'||(LA21_75>='$' && LA21_75<='\'')||LA21_75=='+'||(LA21_75>='-' && LA21_75<='9')||(LA21_75>=';' && LA21_75<='=')||(LA21_75>='?' && LA21_75<='Z')||(LA21_75>='^' && LA21_75<='z')||(LA21_75>='~' && LA21_75<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( (LA21_75=='*'||LA21_75==':'||LA21_75=='>'||LA21_75=='['||LA21_75==']'||(LA21_75>='{' && LA21_75<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_75>='(' && LA21_75<=')')||LA21_75==',') && ((( isHead() )||( isValue() )))) {s = 77;}

                        else if ( (LA21_75=='\n'||LA21_75=='\r'||(LA21_75>='\"' && LA21_75<='#')||LA21_75=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_75);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA21_121 = input.LA(1);

                         
                        int index21_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_121=='\"') ) {s = 98;}

                        else if ( ((LA21_121>='\u0000' && LA21_121<='\t')||(LA21_121>='\u000B' && LA21_121<='\f')||(LA21_121>='\u000E' && LA21_121<='!')||(LA21_121>='#' && LA21_121<='[')||(LA21_121>=']' && LA21_121<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_121=='\\') ) {s = 100;}

                        else if ( (LA21_121=='\n'||LA21_121=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_121);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA21_21 = input.LA(1);

                         
                        int index21_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_21=='\t'||LA21_21==' ') ) {s = 47;}

                        else if ( ((LA21_21>='\u0000' && LA21_21<='\b')||(LA21_21>='\u000B' && LA21_21<='\f')||(LA21_21>='\u000E' && LA21_21<='\u001F')||LA21_21=='!'||(LA21_21>='$' && LA21_21<='\'')||LA21_21=='+'||(LA21_21>='-' && LA21_21<='9')||(LA21_21>=';' && LA21_21<='=')||(LA21_21>='?' && LA21_21<='Z')||(LA21_21>='^' && LA21_21<='z')||(LA21_21>='~' && LA21_21<='\uFFFF')) ) {s = 48;}

                        else if ( (LA21_21=='*'||LA21_21==':'||LA21_21=='>'||LA21_21=='['||LA21_21==']'||(LA21_21>='{' && LA21_21<='}')) ) {s = 49;}

                        else if ( ((LA21_21>='(' && LA21_21<=')')||LA21_21==',') ) {s = 50;}

                        else if ( (LA21_21=='\n'||LA21_21=='\r'||(LA21_21>='\"' && LA21_21<='#')||LA21_21=='\\') && (( isHead() ))) {s = 23;}

                        else s = 61;

                         
                        input.seek(index21_21);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA21_108 = input.LA(1);

                         
                        int index21_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_108=='\"') ) {s = 98;}

                        else if ( ((LA21_108>='\u0000' && LA21_108<='\t')||(LA21_108>='\u000B' && LA21_108<='\f')||(LA21_108>='\u000E' && LA21_108<='!')||(LA21_108>='#' && LA21_108<='[')||(LA21_108>=']' && LA21_108<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_108=='\\') ) {s = 100;}

                        else if ( (LA21_108=='\n'||LA21_108=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_108);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA21_92 = input.LA(1);

                         
                        int index21_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_92=='\"') ) {s = 59;}

                        else if ( (LA21_92=='#') ) {s = 60;}

                        else if ( (LA21_92=='\\') ) {s = 58;}

                        else if ( (LA21_92=='\n'||LA21_92=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA21_92>='\u0000' && LA21_92<='\t')||(LA21_92>='\u000B' && LA21_92<='\f')||(LA21_92>='\u000E' && LA21_92<='!')||(LA21_92>='$' && LA21_92<='[')||(LA21_92>=']' && LA21_92<='\uFFFF')) ) {s = 57;}

                         
                        input.seek(index21_92);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA21_42 = input.LA(1);

                         
                        int index21_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_42=='\n'||LA21_42=='\r'||(LA21_42>='\"' && LA21_42<='#')||LA21_42=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_42=='\t'||LA21_42==' ') && ((( isValue() )||( isHead() )))) {s = 74;}

                        else if ( ((LA21_42>='\u0000' && LA21_42<='\b')||(LA21_42>='\u000B' && LA21_42<='\f')||(LA21_42>='\u000E' && LA21_42<='\u001F')||LA21_42=='!'||(LA21_42>='$' && LA21_42<='\'')||LA21_42=='+'||(LA21_42>='-' && LA21_42<='9')||(LA21_42>=';' && LA21_42<='=')||(LA21_42>='?' && LA21_42<='Z')||(LA21_42>='^' && LA21_42<='z')||(LA21_42>='~' && LA21_42<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 75;}

                        else if ( (LA21_42=='*'||LA21_42==':'||LA21_42=='>'||LA21_42=='['||LA21_42==']'||(LA21_42>='{' && LA21_42<='}')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( ((LA21_42>='(' && LA21_42<=')')||LA21_42==',') && ((( isHead() )||( isValue() )))) {s = 77;}

                        else s = 67;

                         
                        input.seek(index21_42);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA21_27 = input.LA(1);

                         
                        int index21_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_27=='\t'||LA21_27==' ') && ((( isValue() )||( isHead() )))) {s = 65;}

                        else if ( (LA21_27=='\n'||LA21_27=='\r') && (( isHead() ))) {s = 66;}

                        else s = 67;

                         
                        input.seek(index21_27);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA21_13 = input.LA(1);

                         
                        int index21_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_13>='\u0000' && LA21_13<='\b')||(LA21_13>='\u000B' && LA21_13<='\f')||(LA21_13>='\u000E' && LA21_13<='\u001F')||LA21_13=='!'||(LA21_13>='$' && LA21_13<='[')||(LA21_13>=']' && LA21_13<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 42;}

                        else if ( ((LA21_13>='\t' && LA21_13<='\n')||LA21_13=='\r'||LA21_13==' '||LA21_13=='\"'||LA21_13=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_13=='#') && ((( isValue() )||( isHead() )))) {s = 43;}

                        else s = 41;

                         
                        input.seek(index21_13);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA21_12 = input.LA(1);

                         
                        int index21_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_12>='\u0000' && LA21_12<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 40;

                         
                        input.seek(index21_12);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA21_15 = input.LA(1);

                         
                        int index21_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_15>='\u0000' && LA21_15<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 45;

                         
                        input.seek(index21_15);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA21_70 = input.LA(1);

                         
                        int index21_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_70=='\r') && (( isHead() ))) {s = 68;}

                        else if ( (LA21_70=='\n') && (( isHead() ))) {s = 69;}

                        else if ( ((LA21_70>='\u0000' && LA21_70<='\b')||(LA21_70>='\u000B' && LA21_70<='\f')||(LA21_70>='\u000E' && LA21_70<='\u001F')||(LA21_70>='!' && LA21_70<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA21_70=='\t'||LA21_70==' ') && (( isHead() ))) {s = 70;}

                         
                        input.seek(index21_70);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA21_93 = input.LA(1);

                         
                        int index21_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_93=='\n'||LA21_93=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_93=='#') ) {s = 60;}

                        else if ( (LA21_93=='\"') ) {s = 59;}

                        else if ( ((LA21_93>='\u0000' && LA21_93<='\t')||(LA21_93>='\u000B' && LA21_93<='\f')||(LA21_93>='\u000E' && LA21_93<='!')||(LA21_93>='$' && LA21_93<='[')||(LA21_93>=']' && LA21_93<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_93=='\\') ) {s = 58;}

                         
                        input.seek(index21_93);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA21_113 = input.LA(1);

                         
                        int index21_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_113>='0' && LA21_113<='9')||(LA21_113>='A' && LA21_113<='F')||(LA21_113>='a' && LA21_113<='f')) ) {s = 116;}

                        else if ( ((LA21_113>='\u0000' && LA21_113<='/')||(LA21_113>=':' && LA21_113<='@')||(LA21_113>='G' && LA21_113<='`')||(LA21_113>='g' && LA21_113<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_113);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA21_104 = input.LA(1);

                         
                        int index21_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_104>='0' && LA21_104<='9')||(LA21_104>='A' && LA21_104<='F')||(LA21_104>='a' && LA21_104<='f')) ) {s = 115;}

                        else if ( ((LA21_104>='\u0000' && LA21_104<='/')||(LA21_104>=':' && LA21_104<='@')||(LA21_104>='G' && LA21_104<='`')||(LA21_104>='g' && LA21_104<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_104);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA21_22 = input.LA(1);

                         
                        int index21_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_22>='\u0000' && LA21_22<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index21_22);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA21_85 = input.LA(1);

                         
                        int index21_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_85=='\t'||LA21_85==' ') ) {s = 84;}

                        else if ( ((LA21_85>='\u0000' && LA21_85<='\b')||(LA21_85>='\u000B' && LA21_85<='\f')||(LA21_85>='\u000E' && LA21_85<='\u001F')||LA21_85=='!'||(LA21_85>='$' && LA21_85<='\'')||LA21_85=='+'||(LA21_85>='-' && LA21_85<='9')||(LA21_85>=';' && LA21_85<='=')||(LA21_85>='?' && LA21_85<='Z')||(LA21_85>='^' && LA21_85<='z')||(LA21_85>='~' && LA21_85<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_85=='*'||LA21_85==':'||LA21_85=='>'||LA21_85=='['||LA21_85==']'||(LA21_85>='{' && LA21_85<='}')) ) {s = 86;}

                        else if ( ((LA21_85>='(' && LA21_85<=')')||LA21_85==',') ) {s = 87;}

                        else if ( (LA21_85=='\n'||LA21_85=='\r'||(LA21_85>='\"' && LA21_85<='#')||LA21_85=='\\') && (( isHead() ))) {s = 23;}

                        else s = 83;

                         
                        input.seek(index21_85);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA21_90 = input.LA(1);

                         
                        int index21_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_90=='\n'||LA21_90=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_90=='#') ) {s = 60;}

                        else if ( (LA21_90=='\"') ) {s = 59;}

                        else if ( ((LA21_90>='\u0000' && LA21_90<='\t')||(LA21_90>='\u000B' && LA21_90<='\f')||(LA21_90>='\u000E' && LA21_90<='!')||(LA21_90>='$' && LA21_90<='[')||(LA21_90>=']' && LA21_90<='\uFFFF')) ) {s = 57;}

                        else if ( (LA21_90=='\\') ) {s = 58;}

                         
                        input.seek(index21_90);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA21_80 = input.LA(1);

                         
                        int index21_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_80=='\t'||LA21_80==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA21_80>='\u0000' && LA21_80<='\b')||(LA21_80>='\u000B' && LA21_80<='\f')||(LA21_80>='\u000E' && LA21_80<='\u001F')||LA21_80=='!'||(LA21_80>='$' && LA21_80<='\'')||LA21_80=='+'||(LA21_80>='-' && LA21_80<='9')||(LA21_80>=';' && LA21_80<='=')||(LA21_80>='?' && LA21_80<='Z')||(LA21_80>='^' && LA21_80<='z')||(LA21_80>='~' && LA21_80<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA21_80=='*'||LA21_80==':'||LA21_80=='>'||LA21_80=='['||LA21_80==']'||(LA21_80>='{' && LA21_80<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA21_80>='(' && LA21_80<=')')||LA21_80==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA21_80=='\n'||LA21_80=='\r'||(LA21_80>='\"' && LA21_80<='#')||LA21_80=='\\') && (( isHead() ))) {s = 23;}

                        else s = 67;

                         
                        input.seek(index21_80);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA21_109 = input.LA(1);

                         
                        int index21_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_109=='\"') ) {s = 98;}

                        else if ( ((LA21_109>='\u0000' && LA21_109<='\t')||(LA21_109>='\u000B' && LA21_109<='\f')||(LA21_109>='\u000E' && LA21_109<='!')||(LA21_109>='#' && LA21_109<='[')||(LA21_109>=']' && LA21_109<='\uFFFF')) ) {s = 99;}

                        else if ( (LA21_109=='\\') ) {s = 100;}

                        else if ( (LA21_109=='\n'||LA21_109=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index21_109);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA21_55 = input.LA(1);

                         
                        int index21_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_55=='\n'||LA21_55=='\r'||(LA21_55>='\"' && LA21_55<='#')||LA21_55=='\\') && (( isHead() ))) {s = 23;}

                        else if ( (LA21_55=='\t'||LA21_55==' ') ) {s = 84;}

                        else if ( ((LA21_55>='\u0000' && LA21_55<='\b')||(LA21_55>='\u000B' && LA21_55<='\f')||(LA21_55>='\u000E' && LA21_55<='\u001F')||LA21_55=='!'||(LA21_55>='$' && LA21_55<='\'')||LA21_55=='+'||(LA21_55>='-' && LA21_55<='9')||(LA21_55>=';' && LA21_55<='=')||(LA21_55>='?' && LA21_55<='Z')||(LA21_55>='^' && LA21_55<='z')||(LA21_55>='~' && LA21_55<='\uFFFF')) ) {s = 85;}

                        else if ( (LA21_55=='*'||LA21_55==':'||LA21_55=='>'||LA21_55=='['||LA21_55==']'||(LA21_55>='{' && LA21_55<='}')) ) {s = 86;}

                        else if ( ((LA21_55>='(' && LA21_55<=')')||LA21_55==',') ) {s = 87;}

                        else s = 83;

                         
                        input.seek(index21_55);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA21_33 = input.LA(1);

                         
                        int index21_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( !isHead() )) ) {s = 71;}

                        else if ( (true) ) {s = 72;}

                         
                        input.seek(index21_33);
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
// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-22 13:14:35

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
      
      public static String sanitizeDataLine(String line)
      {
          line = line.trim();
          if (line.startsWith("\\"))
              return line.substring(1);
          else
              return line;
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
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:12: ( '#' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:14: '#' (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            match('#'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:18: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:154:18: ~ ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:9: ({...}? => '%' (~ ( '\\n' | '\\r' ) )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:11: {...}? => '%' (~ ( '\\n' | '\\r' ) )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "Preamble", " isHead() ");
            }
            match('%'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:32: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:32: ~ ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:158:23: ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:4: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:24: '\\n'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:19: ({...}? => '--' ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:21: {...}? => '--' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineSeparator", " isHead() ");
            }
            match("--"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:43: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:165:43: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:24: ({...}? => '>>' ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:26: {...}? => '>>' ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineEntrySeparator", " isHead() ");
            }
            match(">>"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:48: ( WhiteSpace )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:166:48: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:11: ({...}? => ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:30: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:168:31: ' '
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:15: ({...}? => ( ' ' )* '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:34: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:169:35: ' '
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:10: ({...}? => ( WhiteSpace )* LineBreak )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:12: {...}? => ( WhiteSpace )* LineBreak
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:29: ( WhiteSpace )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:29: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace | LineBreakChar ) (~ ( '#' | '\\n' | '\\r' ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:78: (~ ( '#' | '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\"')||(LA9_0>='$' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:78: ~ ( '#' | '\\n' | '\\r' )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:11: {...}? => ( WhiteSpace )* DataLineBody ( LineBreak | LineComment )
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:5: ( WhiteSpace )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:5: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:30: ( LineBreak | LineComment )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:31: LineBreak
                    {
                    mLineBreak(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:41: LineComment
                    {
                    mLineComment(); 

                    }
                    break;

            }

             setText(sanitizeDataLine((DataLineBody1!=null?DataLineBody1.getText():null))); 

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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:9: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:8: ':'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:4: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:7: '>'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:7: ( '|' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:9: '|'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:8: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:6: '@'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:7: '+'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:187:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:18: ( Digit | Letter )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:21: (~ ( '\"' | '\\\\' | LineBreakChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:23: ~ ( '\"' | '\\\\' | LineBreakChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:21: ( UnicodeChar | EscapeSequence )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:38: EscapeSequence
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:22: (~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:24: ~ ( '\"' | '\\\\' | LineBreakChar | WhiteSpace )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:22: ( ( StringChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:24: ( StringChar )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:24: ( StringChar )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:24: StringChar
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:7: ( '\"' s= StringChar_s '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:9: '\"' s= StringChar_s '\"'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:208:24: ( '(' | ')' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:23: ( '[' | ']' | '{' | '}' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:213:25: ( '\"' | '\\\\' | LineBreakChar | '#' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:215:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:215:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:22: (~ ( PlainUnsafeChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:24: ~ ( PlainUnsafeChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:220:2: (~ ( '-' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | ( ':' | '?' ) NonSpaceChar ) )
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
            else if ( (LA16_0=='-'||LA16_0==':') && (( isValue() ))) {
                alt16=2;
            }
            else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||LA16_0=='+'||(LA16_0>='.' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                alt16=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:220:5: ~ ( '-' | PlainUnsafeChar | WhiteSpace | Indicator )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:4: {...}? => ( '-' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:22: ( '-' | ( ':' | '?' ) NonSpaceChar )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='-') ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==':'||LA15_0=='?') ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:23: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:29: ( ':' | '?' ) NonSpaceChar
                            {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:225:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:226:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:4: {...}? => PlainSafeOut
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:2: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:4: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:15: ( ( WhiteSpace )* PlainSafe )*
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: ( WhiteSpace )* PlainSafe
            	    {
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: ( WhiteSpace )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0=='\t'||LA18_0==' ') && ((!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isOutValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isInValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isKey() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))))) {
            	            int LA18_1 = input.LA(2);

            	            if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {
            	                alt18=1;
            	            }


            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:231:16: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:236:2: ({...}? => '{' | {...}? => '[' )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:236:4: {...}? => '{'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:247:4: {...}? => '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:11: ({...}? => ( WhiteSpace )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:31: ( WhiteSpace )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:31: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:2: ( ( ' ' | '\\t' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:4: ( ' ' | '\\t' )
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
        "\3\uffff\1\31\1\32\1\34\1\37\1\40\1\46\1\40\1\47\1\50\1\51\1\54"+
        "\1\55\1\56\1\57\1\64\1\65\1\66\1\uffff\1\76\1\77\1\uffff\1\100\2"+
        "\uffff\1\102\6\uffff\1\110\1\uffff\1\110\5\uffff\2\102\4\uffff\4"+
        "\76\3\uffff\3\124\2\uffff\1\142\6\uffff\1\102\2\uffff\2\150\3\uffff"+
        "\10\102\2\uffff\4\124\12\uffff\1\142\3\uffff\1\150\23\uffff";
    static final String DFA22_eofS =
        "\173\uffff";
    static final String DFA22_minS =
        "\1\0\2\uffff\1\12\23\0\1\uffff\3\0\1\11\1\0\1\uffff\1\0\1\uffff"+
        "\1\0\1\uffff\1\0\1\uffff\1\0\1\uffff\1\0\3\uffff\2\0\4\uffff\5\0"+
        "\2\uffff\7\0\2\uffff\1\0\2\uffff\1\0\1\uffff\1\0\1\12\1\0\3\uffff"+
        "\10\0\2\uffff\15\0\1\uffff\3\0\1\uffff\14\0\1\uffff\7\0";
    static final String DFA22_maxS =
        "\1\uffff\2\uffff\1\12\1\0\3\uffff\1\0\16\uffff\1\uffff\3\0\1\40"+
        "\1\0\1\uffff\1\uffff\1\uffff\1\0\1\uffff\1\uffff\1\uffff\1\uffff"+
        "\1\uffff\1\0\3\uffff\2\uffff\4\uffff\4\uffff\1\0\2\uffff\7\uffff"+
        "\2\uffff\1\0\2\uffff\1\uffff\1\uffff\1\uffff\1\12\1\0\3\uffff\10"+
        "\uffff\2\uffff\15\uffff\1\uffff\3\uffff\1\uffff\2\0\12\uffff\1\uffff"+
        "\7\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\24\uffff\1\11\5\uffff\1\27\1\uffff\1\16\1\uffff"+
        "\1\10\1\uffff\1\6\1\uffff\1\7\1\uffff\1\12\1\13\1\14\2\uffff\1\15"+
        "\1\17\1\20\1\22\5\uffff\1\24\1\25\7\uffff\1\27\1\30\1\uffff\1\3"+
        "\1\27\1\uffff\1\4\3\uffff\1\31\1\32\1\21\10\uffff\1\23\1\27\15\uffff"+
        "\1\26\3\uffff\1\27\14\uffff\1\5\7\uffff";
    static final String DFA22_specialS =
        "\1\53\4\uffff\1\77\1\51\1\27\1\uffff\1\55\1\115\1\106\1\15\1\14"+
        "\1\24\1\26\1\116\1\110\1\64\1\13\1\104\1\46\1\61\2\uffff\1\4\1\3"+
        "\1\54\1\63\1\uffff\1\23\1\uffff\1\45\1\uffff\1\72\1\uffff\1\10\1"+
        "\uffff\1\30\3\uffff\1\75\1\111\4\uffff\1\44\1\125\1\0\1\65\1\120"+
        "\2\uffff\1\73\1\35\1\52\1\76\1\70\1\43\1\17\2\uffff\1\5\2\uffff"+
        "\1\71\1\uffff\1\40\1\32\1\20\3\uffff\1\47\1\126\1\1\1\66\1\12\1"+
        "\42\1\11\1\113\2\uffff\1\60\1\21\1\130\1\103\1\56\1\57\1\124\1\100"+
        "\1\114\1\121\1\74\1\50\1\36\1\uffff\1\117\1\31\1\6\1\uffff\1\105"+
        "\1\2\1\123\1\62\1\41\1\25\1\112\1\127\1\102\1\33\1\34\1\122\1\uffff"+
        "\1\67\1\7\1\101\1\16\1\22\1\37\1\107}>";
    static final String[] DFA22_transitionS = {
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
            "\11\27\1\44\1\41\2\27\1\41\22\27\1\42\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\43\22\27\1\45\uffbf\27",
            "\1\uffff",
            "\11\27\1\44\1\41\2\27\1\41\22\27\1\44\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "\0\27",
            "\0\27",
            "\0\27",
            "\11\52\2\27\2\52\1\27\22\52\1\27\1\52\1\27\1\53\70\52\1\27"+
            "\uffa3\52",
            "\0\27",
            "\0\27",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\0\27",
            "\0\27",
            "\11\67\1\60\1\27\2\67\1\27\22\67\1\60\1\67\1\27\1\53\4\67"+
            "\2\71\1\70\1\67\1\71\15\67\1\70\3\67\1\70\34\67\1\70\1\27\1"+
            "\70\35\67\3\70\uff82\67",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\0\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\103\1\104\2\uffff\1\104\22\uffff\1\103",
            "\1\uffff",
            "",
            "\11\27\1\105\1\107\2\27\1\106\22\27\1\105\uffdf\27",
            "",
            "\1\uffff",
            "",
            "\11\27\1\44\1\41\2\27\1\41\22\27\1\42\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\43\22\27\1\45\uffbf\27",
            "",
            "\11\27\1\44\1\41\2\27\1\41\22\27\1\44\2\27\1\uffff\1\27\1"+
            "\uffff\7\27\1\uffff\22\27\1\uffff\uffbf\27",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\3\115\uff82\114",
            "\11\120\1\117\1\27\2\120\1\27\22\120\1\117\1\120\2\27\4\120"+
            "\2\122\1\121\1\120\1\122\15\120\1\121\3\120\1\121\34\120\1\121"+
            "\1\27\1\121\35\120\3\121\uff82\120",
            "",
            "",
            "",
            "",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\11\61\1\60\1\27\2\61\1\27\22\61\1\60\1\61\2\27\4\61\2\63"+
            "\1\62\1\61\1\63\15\61\1\62\3\61\1\62\34\61\1\62\1\27\1\62\35"+
            "\61\3\62\uff82\61",
            "\1\uffff",
            "",
            "",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\42\27\1\131\14\27\1\133\54\27\1\132\5\27\1\134\3\27\1\135"+
            "\7\27\1\136\3\27\1\137\1\27\1\140\1\141\uff8a\27",
            "\0\27",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\11\146\1\103\1\104\2\146\1\104\22\146\1\103\1\146\2\uffff"+
            "\70\146\1\uffff\uffa3\146",
            "",
            "\11\27\1\105\1\107\2\27\1\106\22\27\1\105\uffdf\27",
            "\1\147",
            "\1\uffff",
            "",
            "",
            "",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\3\115\uff82\114",
            "\11\114\1\113\1\27\2\114\1\27\22\114\1\113\1\114\2\27\4\114"+
            "\2\116\1\115\1\114\1\116\15\114\1\115\3\114\1\115\34\114\1\115"+
            "\1\27\1\115\35\114\3\115\uff82\114",
            "\11\120\1\117\1\27\2\120\1\27\22\120\1\117\1\120\2\27\4\120"+
            "\2\122\1\121\1\120\1\122\15\120\1\121\3\120\1\121\34\120\1\121"+
            "\1\27\1\121\35\120\3\121\uff82\120",
            "\11\120\1\117\1\27\2\120\1\27\22\120\1\117\1\120\2\27\4\120"+
            "\2\122\1\121\1\120\1\122\15\120\1\121\3\120\1\121\34\120\1\121"+
            "\1\27\1\121\35\120\3\121\uff82\120",
            "\11\120\1\117\1\27\2\120\1\27\22\120\1\117\1\120\2\27\4\120"+
            "\2\122\1\121\1\120\1\122\15\120\1\121\3\120\1\121\34\120\1\121"+
            "\1\27\1\121\35\120\3\121\uff82\120",
            "\11\120\1\117\1\27\2\120\1\27\22\120\1\117\1\120\2\27\4\120"+
            "\2\122\1\121\1\120\1\122\15\120\1\121\3\120\1\121\34\120\1\121"+
            "\1\27\1\121\35\120\3\121\uff82\120",
            "",
            "",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\11\126\1\125\1\27\2\126\1\27\22\126\1\125\1\126\2\27\4\126"+
            "\2\130\1\127\1\126\1\130\15\126\1\127\3\126\1\127\34\126\1\127"+
            "\1\27\1\127\35\126\3\127\uff82\126",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\60\27\12\151\7\27\6\151\32\27\6\151\uff99\27",
            "",
            "\0\27",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\42\27\1\152\14\27\1\154\54\27\1\153\5\27\1\155\3\27\1\156"+
            "\7\27\1\157\3\27\1\160\1\27\1\161\1\162\uff8a\27",
            "",
            "\1\uffff",
            "\1\uffff",
            "\60\27\12\164\7\27\6\164\32\27\6\164\uff99\27",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144",
            "\60\27\12\165\7\27\6\165\32\27\6\165\uff99\27",
            "",
            "\60\27\12\166\7\27\6\166\32\27\6\166\uff99\27",
            "\60\27\12\167\7\27\6\167\32\27\6\167\uff99\27",
            "\60\27\12\170\7\27\6\170\32\27\6\170\uff99\27",
            "\60\27\12\171\7\27\6\171\32\27\6\171\uff99\27",
            "\12\72\1\27\2\72\1\27\24\72\1\74\1\75\70\72\1\73\uffa3\72",
            "\60\27\12\172\7\27\6\172\32\27\6\172\uff99\27",
            "\12\144\1\27\2\144\1\27\24\144\1\143\71\144\1\145\uffa3\144"
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
                        int LA22_50 = input.LA(1);

                         
                        int index22_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_50=='\t'||LA22_50==' ') ) {s = 48;}

                        else if ( ((LA22_50>='\u0000' && LA22_50<='\b')||(LA22_50>='\u000B' && LA22_50<='\f')||(LA22_50>='\u000E' && LA22_50<='\u001F')||LA22_50=='!'||(LA22_50>='$' && LA22_50<='\'')||LA22_50=='+'||(LA22_50>='-' && LA22_50<='9')||(LA22_50>=';' && LA22_50<='=')||(LA22_50>='?' && LA22_50<='Z')||(LA22_50>='^' && LA22_50<='z')||(LA22_50>='~' && LA22_50<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_50=='*'||LA22_50==':'||LA22_50=='>'||LA22_50=='['||LA22_50==']'||(LA22_50>='{' && LA22_50<='}')) ) {s = 50;}

                        else if ( ((LA22_50>='(' && LA22_50<=')')||LA22_50==',') ) {s = 51;}

                        else if ( (LA22_50=='\n'||LA22_50=='\r'||(LA22_50>='\"' && LA22_50<='#')||LA22_50=='\\') && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index22_50);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_77 = input.LA(1);

                         
                        int index22_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_77=='\t'||LA22_77==' ') && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( ((LA22_77>='\u0000' && LA22_77<='\b')||(LA22_77>='\u000B' && LA22_77<='\f')||(LA22_77>='\u000E' && LA22_77<='\u001F')||LA22_77=='!'||(LA22_77>='$' && LA22_77<='\'')||LA22_77=='+'||(LA22_77>='-' && LA22_77<='9')||(LA22_77>=';' && LA22_77<='=')||(LA22_77>='?' && LA22_77<='Z')||(LA22_77>='^' && LA22_77<='z')||(LA22_77>='~' && LA22_77<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( (LA22_77=='*'||LA22_77==':'||LA22_77=='>'||LA22_77=='['||LA22_77==']'||(LA22_77>='{' && LA22_77<='}')) && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( ((LA22_77>='(' && LA22_77<=')')||LA22_77==',') && ((( isValue() )||( isHead() )))) {s = 78;}

                        else if ( (LA22_77=='\n'||LA22_77=='\r'||(LA22_77>='\"' && LA22_77<='#')||LA22_77=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_77);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_104 = input.LA(1);

                         
                        int index22_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 115;}

                        else if ( (( isHead() )) ) {s = 23;}

                         
                        input.seek(index22_104);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 65;}

                        else if ( (( isHead() )) ) {s = 33;}

                         
                        input.seek(index22_26);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_25 = input.LA(1);

                         
                        int index22_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 65;}

                        else if ( (( isHead() )) ) {s = 33;}

                         
                        input.seek(index22_25);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_64 = input.LA(1);

                         
                        int index22_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isHead() )))) ) {s = 65;}

                        else if ( (( isHead() )) ) {s = 33;}

                         
                        input.seek(index22_64);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_101 = input.LA(1);

                         
                        int index22_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_101>='\u0000' && LA22_101<='!')||(LA22_101>='#' && LA22_101<='.')||(LA22_101>='0' && LA22_101<='[')||(LA22_101>=']' && LA22_101<='a')||(LA22_101>='c' && LA22_101<='e')||(LA22_101>='g' && LA22_101<='m')||(LA22_101>='o' && LA22_101<='q')||LA22_101=='s'||(LA22_101>='v' && LA22_101<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_101=='\"') ) {s = 106;}

                        else if ( (LA22_101=='\\') ) {s = 107;}

                        else if ( (LA22_101=='/') ) {s = 108;}

                        else if ( (LA22_101=='b') ) {s = 109;}

                        else if ( (LA22_101=='f') ) {s = 110;}

                        else if ( (LA22_101=='n') ) {s = 111;}

                        else if ( (LA22_101=='r') ) {s = 112;}

                        else if ( (LA22_101=='t') ) {s = 113;}

                        else if ( (LA22_101=='u') ) {s = 114;}

                         
                        input.seek(index22_101);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_117 = input.LA(1);

                         
                        int index22_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_117>='0' && LA22_117<='9')||(LA22_117>='A' && LA22_117<='F')||(LA22_117>='a' && LA22_117<='f')) ) {s = 119;}

                        else if ( ((LA22_117>='\u0000' && LA22_117<='/')||(LA22_117>=':' && LA22_117<='@')||(LA22_117>='G' && LA22_117<='`')||(LA22_117>='g' && LA22_117<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_117);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_36 = input.LA(1);

                         
                        int index22_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_36=='\n'||LA22_36=='\r') && (( isHead() ))) {s = 33;}

                        else if ( (LA22_36=='\t'||LA22_36==' ') && ((( !isHead() )||( isHead() )))) {s = 36;}

                        else if ( ((LA22_36>='\u0000' && LA22_36<='\b')||(LA22_36>='\u000B' && LA22_36<='\f')||(LA22_36>='\u000E' && LA22_36<='\u001F')||(LA22_36>='!' && LA22_36<='\"')||LA22_36=='$'||(LA22_36>='&' && LA22_36<=',')||(LA22_36>='.' && LA22_36<='?')||(LA22_36>='A' && LA22_36<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 72;

                         
                        input.seek(index22_36);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_81=='\t'||LA22_81==' ') && ((( isHead() )||( isValue() )))) {s = 79;}

                        else if ( ((LA22_81>='\u0000' && LA22_81<='\b')||(LA22_81>='\u000B' && LA22_81<='\f')||(LA22_81>='\u000E' && LA22_81<='\u001F')||LA22_81=='!'||(LA22_81>='$' && LA22_81<='\'')||LA22_81=='+'||(LA22_81>='-' && LA22_81<='9')||(LA22_81>=';' && LA22_81<='=')||(LA22_81>='?' && LA22_81<='Z')||(LA22_81>='^' && LA22_81<='z')||(LA22_81>='~' && LA22_81<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_81=='*'||LA22_81==':'||LA22_81=='>'||LA22_81=='['||LA22_81==']'||(LA22_81>='{' && LA22_81<='}')) && ((( isHead() )||( isValue() )))) {s = 81;}

                        else if ( ((LA22_81>='(' && LA22_81<=')')||LA22_81==',') && ((( isHead() )||( isValue() )))) {s = 82;}

                        else if ( (LA22_81=='\n'||LA22_81=='\r'||(LA22_81>='\"' && LA22_81<='#')||LA22_81=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_79 = input.LA(1);

                         
                        int index22_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_79=='\t'||LA22_79==' ') && ((( isHead() )||( isValue() )))) {s = 79;}

                        else if ( (LA22_79=='*'||LA22_79==':'||LA22_79=='>'||LA22_79=='['||LA22_79==']'||(LA22_79>='{' && LA22_79<='}')) && ((( isHead() )||( isValue() )))) {s = 81;}

                        else if ( ((LA22_79>='(' && LA22_79<=')')||LA22_79==',') && ((( isHead() )||( isValue() )))) {s = 82;}

                        else if ( ((LA22_79>='\u0000' && LA22_79<='\b')||(LA22_79>='\u000B' && LA22_79<='\f')||(LA22_79>='\u000E' && LA22_79<='\u001F')||LA22_79=='!'||(LA22_79>='$' && LA22_79<='\'')||LA22_79=='+'||(LA22_79>='-' && LA22_79<='9')||(LA22_79>=';' && LA22_79<='=')||(LA22_79>='?' && LA22_79<='Z')||(LA22_79>='^' && LA22_79<='z')||(LA22_79>='~' && LA22_79<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_79=='\n'||LA22_79=='\r'||(LA22_79>='\"' && LA22_79<='#')||LA22_79=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_79);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_19 = input.LA(1);

                         
                        int index22_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_19=='\t'||LA22_19==' ') ) {s = 48;}

                        else if ( ((LA22_19>='\u0000' && LA22_19<='\b')||(LA22_19>='\u000B' && LA22_19<='\f')||(LA22_19>='\u000E' && LA22_19<='\u001F')||LA22_19=='!'||(LA22_19>='$' && LA22_19<='\'')||LA22_19=='+'||(LA22_19>='-' && LA22_19<='9')||(LA22_19>=';' && LA22_19<='=')||(LA22_19>='?' && LA22_19<='Z')||(LA22_19>='^' && LA22_19<='z')||(LA22_19>='~' && LA22_19<='\uFFFF')) ) {s = 55;}

                        else if ( (LA22_19=='*'||LA22_19==':'||LA22_19=='>'||LA22_19=='['||LA22_19==']'||(LA22_19>='{' && LA22_19<='}')) ) {s = 56;}

                        else if ( ((LA22_19>='(' && LA22_19<=')')||LA22_19==',') ) {s = 57;}

                        else if ( (LA22_19=='#') && ((( isValue() )||( isHead() )))) {s = 43;}

                        else if ( (LA22_19=='\n'||LA22_19=='\r'||LA22_19=='\"'||LA22_19=='\\') && (( isHead() ))) {s = 23;}

                        else s = 54;

                         
                        input.seek(index22_19);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_13>='\u0000' && LA22_13<='\b')||(LA22_13>='\u000B' && LA22_13<='\f')||(LA22_13>='\u000E' && LA22_13<='\u001F')||LA22_13=='!'||(LA22_13>='$' && LA22_13<='[')||(LA22_13>=']' && LA22_13<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 42;}

                        else if ( (LA22_13=='#') && ((( isValue() )||( isHead() )))) {s = 43;}

                        else if ( ((LA22_13>='\t' && LA22_13<='\n')||LA22_13=='\r'||LA22_13==' '||LA22_13=='\"'||LA22_13=='\\') && (( isHead() ))) {s = 23;}

                        else s = 44;

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_12>='\u0000' && LA22_12<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 41;

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_119 = input.LA(1);

                         
                        int index22_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_119>='\u0000' && LA22_119<='/')||(LA22_119>=':' && LA22_119<='@')||(LA22_119>='G' && LA22_119<='`')||(LA22_119>='g' && LA22_119<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_119>='0' && LA22_119<='9')||(LA22_119>='A' && LA22_119<='F')||(LA22_119>='a' && LA22_119<='f')) ) {s = 121;}

                         
                        input.seek(index22_119);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_61 = input.LA(1);

                         
                        int index22_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_61=='\"') ) {s = 99;}

                        else if ( ((LA22_61>='\u0000' && LA22_61<='\t')||(LA22_61>='\u000B' && LA22_61<='\f')||(LA22_61>='\u000E' && LA22_61<='!')||(LA22_61>='#' && LA22_61<='[')||(LA22_61>=']' && LA22_61<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_61=='\\') ) {s = 101;}

                        else if ( (LA22_61=='\n'||LA22_61=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_71 = input.LA(1);

                         
                        int index22_71 = input.index();
                        input.rewind();
                        s = -1;
                        s = 104;

                         
                        input.seek(index22_71);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_86 = input.LA(1);

                         
                        int index22_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_86=='\t'||LA22_86==' ') ) {s = 85;}

                        else if ( ((LA22_86>='\u0000' && LA22_86<='\b')||(LA22_86>='\u000B' && LA22_86<='\f')||(LA22_86>='\u000E' && LA22_86<='\u001F')||LA22_86=='!'||(LA22_86>='$' && LA22_86<='\'')||LA22_86=='+'||(LA22_86>='-' && LA22_86<='9')||(LA22_86>=';' && LA22_86<='=')||(LA22_86>='?' && LA22_86<='Z')||(LA22_86>='^' && LA22_86<='z')||(LA22_86>='~' && LA22_86<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_86=='*'||LA22_86==':'||LA22_86=='>'||LA22_86=='['||LA22_86==']'||(LA22_86>='{' && LA22_86<='}')) ) {s = 87;}

                        else if ( ((LA22_86>='(' && LA22_86<=')')||LA22_86==',') ) {s = 88;}

                        else if ( (LA22_86=='\n'||LA22_86=='\r'||(LA22_86>='\"' && LA22_86<='#')||LA22_86=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_86);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_120 = input.LA(1);

                         
                        int index22_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_120=='\n'||LA22_120=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_120=='#') ) {s = 61;}

                        else if ( (LA22_120=='\"') ) {s = 60;}

                        else if ( ((LA22_120>='\u0000' && LA22_120<='\t')||(LA22_120>='\u000B' && LA22_120<='\f')||(LA22_120>='\u000E' && LA22_120<='!')||(LA22_120>='$' && LA22_120<='[')||(LA22_120>=']' && LA22_120<='\uFFFF')) ) {s = 58;}

                        else if ( (LA22_120=='\\') ) {s = 59;}

                         
                        input.seek(index22_120);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_30 = input.LA(1);

                         
                        int index22_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_30=='\t'||LA22_30==' ') && (( isHead() ))) {s = 69;}

                        else if ( (LA22_30=='\r') && (( isHead() ))) {s = 70;}

                        else if ( (LA22_30=='\n') && (( isHead() ))) {s = 71;}

                        else if ( ((LA22_30>='\u0000' && LA22_30<='\b')||(LA22_30>='\u000B' && LA22_30<='\f')||(LA22_30>='\u000E' && LA22_30<='\u001F')||(LA22_30>='!' && LA22_30<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_30);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_14>='\u0000' && LA22_14<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 45;

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_108 = input.LA(1);

                         
                        int index22_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_108=='\"') ) {s = 99;}

                        else if ( ((LA22_108>='\u0000' && LA22_108<='\t')||(LA22_108>='\u000B' && LA22_108<='\f')||(LA22_108>='\u000E' && LA22_108<='!')||(LA22_108>='#' && LA22_108<='[')||(LA22_108>=']' && LA22_108<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_108=='\\') ) {s = 101;}

                        else if ( (LA22_108=='\n'||LA22_108=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_108);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 46;

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_7=='\n'||LA22_7=='\r') && (( isHead() ))) {s = 33;}

                        else if ( (LA22_7==' ') && ((( !isHead() )||( isHead() )))) {s = 34;}

                        else if ( (LA22_7=='-') && (( isHead() ))) {s = 35;}

                        else if ( (LA22_7=='\t') && ((( !isHead() )||( isHead() )))) {s = 36;}

                        else if ( ((LA22_7>='\u0000' && LA22_7<='\b')||(LA22_7>='\u000B' && LA22_7<='\f')||(LA22_7>='\u000E' && LA22_7<='\u001F')||(LA22_7>='!' && LA22_7<='\"')||LA22_7=='$'||(LA22_7>='&' && LA22_7<=',')||(LA22_7>='.' && LA22_7<='?')||(LA22_7>='A' && LA22_7<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_7=='@') && (( isHead() ))) {s = 37;}

                        else s = 32;

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_38 = input.LA(1);

                         
                        int index22_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 37;}

                        else if ( (true) ) {s = 74;}

                         
                        input.seek(index22_38);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_100 = input.LA(1);

                         
                        int index22_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_100=='\"') ) {s = 99;}

                        else if ( ((LA22_100>='\u0000' && LA22_100<='\t')||(LA22_100>='\u000B' && LA22_100<='\f')||(LA22_100>='\u000E' && LA22_100<='!')||(LA22_100>='#' && LA22_100<='[')||(LA22_100>=']' && LA22_100<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_100=='\\') ) {s = 101;}

                        else if ( (LA22_100=='\n'||LA22_100=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_100);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_70 = input.LA(1);

                         
                        int index22_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_70=='\n') && (( isHead() ))) {s = 103;}

                        else s = 104;

                         
                        input.seek(index22_70);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_112 = input.LA(1);

                         
                        int index22_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_112=='\"') ) {s = 99;}

                        else if ( ((LA22_112>='\u0000' && LA22_112<='\t')||(LA22_112>='\u000B' && LA22_112<='\f')||(LA22_112>='\u000E' && LA22_112<='!')||(LA22_112>='#' && LA22_112<='[')||(LA22_112>=']' && LA22_112<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_112=='\\') ) {s = 101;}

                        else if ( (LA22_112=='\n'||LA22_112=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_112);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_113=='\"') ) {s = 99;}

                        else if ( ((LA22_113>='\u0000' && LA22_113<='\t')||(LA22_113>='\u000B' && LA22_113<='\f')||(LA22_113>='\u000E' && LA22_113<='!')||(LA22_113>='#' && LA22_113<='[')||(LA22_113>=']' && LA22_113<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_113=='\\') ) {s = 101;}

                        else if ( (LA22_113=='\n'||LA22_113=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_56 = input.LA(1);

                         
                        int index22_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_56=='\t'||LA22_56==' ') ) {s = 85;}

                        else if ( ((LA22_56>='\u0000' && LA22_56<='\b')||(LA22_56>='\u000B' && LA22_56<='\f')||(LA22_56>='\u000E' && LA22_56<='\u001F')||LA22_56=='!'||(LA22_56>='$' && LA22_56<='\'')||LA22_56=='+'||(LA22_56>='-' && LA22_56<='9')||(LA22_56>=';' && LA22_56<='=')||(LA22_56>='?' && LA22_56<='Z')||(LA22_56>='^' && LA22_56<='z')||(LA22_56>='~' && LA22_56<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_56=='*'||LA22_56==':'||LA22_56=='>'||LA22_56=='['||LA22_56==']'||(LA22_56>='{' && LA22_56<='}')) ) {s = 87;}

                        else if ( ((LA22_56>='(' && LA22_56<=')')||LA22_56==',') ) {s = 88;}

                        else if ( (LA22_56=='\n'||LA22_56=='\r'||(LA22_56>='\"' && LA22_56<='#')||LA22_56=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_56);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_97 = input.LA(1);

                         
                        int index22_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_97>='0' && LA22_97<='9')||(LA22_97>='A' && LA22_97<='F')||(LA22_97>='a' && LA22_97<='f')) ) {s = 105;}

                        else if ( ((LA22_97>='\u0000' && LA22_97<='/')||(LA22_97>=':' && LA22_97<='@')||(LA22_97>='G' && LA22_97<='`')||(LA22_97>='g' && LA22_97<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_97);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_121 = input.LA(1);

                         
                        int index22_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_121>='0' && LA22_121<='9')||(LA22_121>='A' && LA22_121<='F')||(LA22_121>='a' && LA22_121<='f')) ) {s = 122;}

                        else if ( ((LA22_121>='\u0000' && LA22_121<='/')||(LA22_121>=':' && LA22_121<='@')||(LA22_121>='G' && LA22_121<='`')||(LA22_121>='g' && LA22_121<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_121);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_69 = input.LA(1);

                         
                        int index22_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_69=='\r') && (( isHead() ))) {s = 70;}

                        else if ( (LA22_69=='\n') && (( isHead() ))) {s = 71;}

                        else if ( ((LA22_69>='\u0000' && LA22_69<='\b')||(LA22_69>='\u000B' && LA22_69<='\f')||(LA22_69>='\u000E' && LA22_69<='\u001F')||(LA22_69>='!' && LA22_69<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_69=='\t'||LA22_69==' ') && (( isHead() ))) {s = 69;}

                         
                        input.seek(index22_69);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_107 = input.LA(1);

                         
                        int index22_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_107=='\"') ) {s = 99;}

                        else if ( ((LA22_107>='\u0000' && LA22_107<='\t')||(LA22_107>='\u000B' && LA22_107<='\f')||(LA22_107>='\u000E' && LA22_107<='!')||(LA22_107>='#' && LA22_107<='[')||(LA22_107>=']' && LA22_107<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_107=='\\') ) {s = 101;}

                        else if ( (LA22_107=='\n'||LA22_107=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_107);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_80 = input.LA(1);

                         
                        int index22_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_80=='\t'||LA22_80==' ') && ((( isHead() )||( isValue() )))) {s = 79;}

                        else if ( ((LA22_80>='\u0000' && LA22_80<='\b')||(LA22_80>='\u000B' && LA22_80<='\f')||(LA22_80>='\u000E' && LA22_80<='\u001F')||LA22_80=='!'||(LA22_80>='$' && LA22_80<='\'')||LA22_80=='+'||(LA22_80>='-' && LA22_80<='9')||(LA22_80>=';' && LA22_80<='=')||(LA22_80>='?' && LA22_80<='Z')||(LA22_80>='^' && LA22_80<='z')||(LA22_80>='~' && LA22_80<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_80=='*'||LA22_80==':'||LA22_80=='>'||LA22_80=='['||LA22_80==']'||(LA22_80>='{' && LA22_80<='}')) && ((( isHead() )||( isValue() )))) {s = 81;}

                        else if ( ((LA22_80>='(' && LA22_80<=')')||LA22_80==',') && ((( isHead() )||( isValue() )))) {s = 82;}

                        else if ( (LA22_80=='\n'||LA22_80=='\r'||(LA22_80>='\"' && LA22_80<='#')||LA22_80=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_80);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_60 = input.LA(1);

                         
                        int index22_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_60>='\u0000' && LA22_60<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 98;

                         
                        input.seek(index22_60);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_48 = input.LA(1);

                         
                        int index22_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_48=='\t'||LA22_48==' ') ) {s = 48;}

                        else if ( (LA22_48=='*'||LA22_48==':'||LA22_48=='>'||LA22_48=='['||LA22_48==']'||(LA22_48>='{' && LA22_48<='}')) ) {s = 50;}

                        else if ( ((LA22_48>='(' && LA22_48<=')')||LA22_48==',') ) {s = 51;}

                        else if ( ((LA22_48>='\u0000' && LA22_48<='\b')||(LA22_48>='\u000B' && LA22_48<='\f')||(LA22_48>='\u000E' && LA22_48<='\u001F')||LA22_48=='!'||(LA22_48>='$' && LA22_48<='\'')||LA22_48=='+'||(LA22_48>='-' && LA22_48<='9')||(LA22_48>=';' && LA22_48<='=')||(LA22_48>='?' && LA22_48<='Z')||(LA22_48>='^' && LA22_48<='z')||(LA22_48>='~' && LA22_48<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_48=='\n'||LA22_48=='\r'||(LA22_48>='\"' && LA22_48<='#')||LA22_48=='\\') && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index22_48);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_32 = input.LA(1);

                         
                        int index22_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( !isHead() )) ) {s = 72;}

                        else if ( (true) ) {s = 73;}

                         
                        input.seek(index22_32);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_21=='\t'||LA22_21==' ') ) {s = 48;}

                        else if ( ((LA22_21>='\u0000' && LA22_21<='\b')||(LA22_21>='\u000B' && LA22_21<='\f')||(LA22_21>='\u000E' && LA22_21<='\u001F')||LA22_21=='!'||(LA22_21>='$' && LA22_21<='\'')||LA22_21=='+'||(LA22_21>='-' && LA22_21<='9')||(LA22_21>=';' && LA22_21<='=')||(LA22_21>='?' && LA22_21<='Z')||(LA22_21>='^' && LA22_21<='z')||(LA22_21>='~' && LA22_21<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_21=='*'||LA22_21==':'||LA22_21=='>'||LA22_21=='['||LA22_21==']'||(LA22_21>='{' && LA22_21<='}')) ) {s = 50;}

                        else if ( ((LA22_21>='(' && LA22_21<=')')||LA22_21==',') ) {s = 51;}

                        else if ( (LA22_21=='\n'||LA22_21=='\r'||(LA22_21>='\"' && LA22_21<='#')||LA22_21=='\\') && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_75=='\t'||LA22_75==' ') && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( (LA22_75=='*'||LA22_75==':'||LA22_75=='>'||LA22_75=='['||LA22_75==']'||(LA22_75>='{' && LA22_75<='}')) && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( ((LA22_75>='(' && LA22_75<=')')||LA22_75==',') && ((( isValue() )||( isHead() )))) {s = 78;}

                        else if ( ((LA22_75>='\u0000' && LA22_75<='\b')||(LA22_75>='\u000B' && LA22_75<='\f')||(LA22_75>='\u000E' && LA22_75<='\u001F')||LA22_75=='!'||(LA22_75>='$' && LA22_75<='\'')||LA22_75=='+'||(LA22_75>='-' && LA22_75<='9')||(LA22_75>=';' && LA22_75<='=')||(LA22_75>='?' && LA22_75<='Z')||(LA22_75>='^' && LA22_75<='z')||(LA22_75>='~' && LA22_75<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( (LA22_75=='\n'||LA22_75=='\r'||(LA22_75>='\"' && LA22_75<='#')||LA22_75=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_75);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_96 = input.LA(1);

                         
                        int index22_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_96=='\"') ) {s = 60;}

                        else if ( (LA22_96=='#') ) {s = 61;}

                        else if ( (LA22_96=='\\') ) {s = 59;}

                        else if ( (LA22_96=='\n'||LA22_96=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_96>='\u0000' && LA22_96<='\t')||(LA22_96>='\u000B' && LA22_96<='\f')||(LA22_96>='\u000E' && LA22_96<='!')||(LA22_96>='$' && LA22_96<='[')||(LA22_96>=']' && LA22_96<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_96);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_6=='>') && (( isHead() ))) {s = 30;}

                        else if ( ((LA22_6>='\u0000' && LA22_6<='=')||(LA22_6>='?' && LA22_6<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 31;

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_57 = input.LA(1);

                         
                        int index22_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_57=='\t'||LA22_57==' ') ) {s = 85;}

                        else if ( ((LA22_57>='\u0000' && LA22_57<='\b')||(LA22_57>='\u000B' && LA22_57<='\f')||(LA22_57>='\u000E' && LA22_57<='\u001F')||LA22_57=='!'||(LA22_57>='$' && LA22_57<='\'')||LA22_57=='+'||(LA22_57>='-' && LA22_57<='9')||(LA22_57>=';' && LA22_57<='=')||(LA22_57>='?' && LA22_57<='Z')||(LA22_57>='^' && LA22_57<='z')||(LA22_57>='~' && LA22_57<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_57=='*'||LA22_57==':'||LA22_57=='>'||LA22_57=='['||LA22_57==']'||(LA22_57>='{' && LA22_57<='}')) ) {s = 87;}

                        else if ( ((LA22_57>='(' && LA22_57<=')')||LA22_57==',') ) {s = 88;}

                        else if ( (LA22_57=='\n'||LA22_57=='\r'||(LA22_57>='\"' && LA22_57<='#')||LA22_57=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_57);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0=='#') ) {s = 1;}

                        else if ( (LA22_0=='%') && (( isHead() ))) {s = 2;}

                        else if ( (LA22_0=='\r') ) {s = 3;}

                        else if ( (LA22_0=='\n') ) {s = 4;}

                        else if ( (LA22_0=='-') && ((( isHead() )||( isValue() )))) {s = 5;}

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
                    case 44 : 
                        int LA22_27 = input.LA(1);

                         
                        int index22_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_27=='\t'||LA22_27==' ') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( (LA22_27=='\n'||LA22_27=='\r') && (( isHead() ))) {s = 68;}

                        else s = 66;

                         
                        input.seek(index22_27);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_9=='\n'||LA22_9=='\r') && (( isHead() ))) {s = 33;}

                        else if ( (LA22_9=='\t'||LA22_9==' ') && ((( !isHead() )||( isHead() )))) {s = 36;}

                        else if ( ((LA22_9>='\u0000' && LA22_9<='\b')||(LA22_9>='\u000B' && LA22_9<='\f')||(LA22_9>='\u000E' && LA22_9<='\u001F')||(LA22_9>='!' && LA22_9<='\"')||LA22_9=='$'||(LA22_9>='&' && LA22_9<=',')||(LA22_9>='.' && LA22_9<='?')||(LA22_9>='A' && LA22_9<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 32;

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_89=='\n'||LA22_89=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_89=='#') ) {s = 61;}

                        else if ( (LA22_89=='\"') ) {s = 60;}

                        else if ( ((LA22_89>='\u0000' && LA22_89<='\t')||(LA22_89>='\u000B' && LA22_89<='\f')||(LA22_89>='\u000E' && LA22_89<='!')||(LA22_89>='$' && LA22_89<='[')||(LA22_89>=']' && LA22_89<='\uFFFF')) ) {s = 58;}

                        else if ( (LA22_89=='\\') ) {s = 59;}

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_90=='\"') ) {s = 60;}

                        else if ( (LA22_90=='#') ) {s = 61;}

                        else if ( (LA22_90=='\\') ) {s = 59;}

                        else if ( (LA22_90=='\n'||LA22_90=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_90>='\u0000' && LA22_90<='\t')||(LA22_90>='\u000B' && LA22_90<='\f')||(LA22_90>='\u000E' && LA22_90<='!')||(LA22_90>='$' && LA22_90<='[')||(LA22_90>=']' && LA22_90<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_85 = input.LA(1);

                         
                        int index22_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_85=='\t'||LA22_85==' ') ) {s = 85;}

                        else if ( (LA22_85=='*'||LA22_85==':'||LA22_85=='>'||LA22_85=='['||LA22_85==']'||(LA22_85>='{' && LA22_85<='}')) ) {s = 87;}

                        else if ( ((LA22_85>='(' && LA22_85<=')')||LA22_85==',') ) {s = 88;}

                        else if ( ((LA22_85>='\u0000' && LA22_85<='\b')||(LA22_85>='\u000B' && LA22_85<='\f')||(LA22_85>='\u000E' && LA22_85<='\u001F')||LA22_85=='!'||(LA22_85>='$' && LA22_85<='\'')||LA22_85=='+'||(LA22_85>='-' && LA22_85<='9')||(LA22_85>=';' && LA22_85<='=')||(LA22_85>='?' && LA22_85<='Z')||(LA22_85>='^' && LA22_85<='z')||(LA22_85>='~' && LA22_85<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_85=='\n'||LA22_85=='\r'||(LA22_85>='\"' && LA22_85<='#')||LA22_85=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_85);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_22 = input.LA(1);

                         
                        int index22_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_22>='\u0000' && LA22_22<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 63;

                         
                        input.seek(index22_22);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_106 = input.LA(1);

                         
                        int index22_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_106=='\n'||LA22_106=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_106=='\"') ) {s = 99;}

                        else if ( ((LA22_106>='\u0000' && LA22_106<='\t')||(LA22_106>='\u000B' && LA22_106<='\f')||(LA22_106>='\u000E' && LA22_106<='!')||(LA22_106>='#' && LA22_106<='[')||(LA22_106>=']' && LA22_106<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_106=='\\') ) {s = 101;}

                         
                        input.seek(index22_106);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_28 = input.LA(1);

                         
                        int index22_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 35;}

                        else if ( (( isValue() )) ) {s = 66;}

                         
                        input.seek(index22_28);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_18 = input.LA(1);

                         
                        int index22_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_18>='\u0000' && LA22_18<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 53;

                         
                        input.seek(index22_18);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_51 = input.LA(1);

                         
                        int index22_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_51=='\t'||LA22_51==' ') ) {s = 48;}

                        else if ( ((LA22_51>='\u0000' && LA22_51<='\b')||(LA22_51>='\u000B' && LA22_51<='\f')||(LA22_51>='\u000E' && LA22_51<='\u001F')||LA22_51=='!'||(LA22_51>='$' && LA22_51<='\'')||LA22_51=='+'||(LA22_51>='-' && LA22_51<='9')||(LA22_51>=';' && LA22_51<='=')||(LA22_51>='?' && LA22_51<='Z')||(LA22_51>='^' && LA22_51<='z')||(LA22_51>='~' && LA22_51<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_51=='*'||LA22_51==':'||LA22_51=='>'||LA22_51=='['||LA22_51==']'||(LA22_51>='{' && LA22_51<='}')) ) {s = 50;}

                        else if ( ((LA22_51>='(' && LA22_51<=')')||LA22_51==',') ) {s = 51;}

                        else if ( (LA22_51=='\n'||LA22_51=='\r'||(LA22_51>='\"' && LA22_51<='#')||LA22_51=='\\') && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index22_51);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_78 = input.LA(1);

                         
                        int index22_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_78=='\t'||LA22_78==' ') && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( ((LA22_78>='\u0000' && LA22_78<='\b')||(LA22_78>='\u000B' && LA22_78<='\f')||(LA22_78>='\u000E' && LA22_78<='\u001F')||LA22_78=='!'||(LA22_78>='$' && LA22_78<='\'')||LA22_78=='+'||(LA22_78>='-' && LA22_78<='9')||(LA22_78>=';' && LA22_78<='=')||(LA22_78>='?' && LA22_78<='Z')||(LA22_78>='^' && LA22_78<='z')||(LA22_78>='~' && LA22_78<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( (LA22_78=='*'||LA22_78==':'||LA22_78=='>'||LA22_78=='['||LA22_78==']'||(LA22_78>='{' && LA22_78<='}')) && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( ((LA22_78>='(' && LA22_78<=')')||LA22_78==',') && ((( isValue() )||( isHead() )))) {s = 78;}

                        else if ( (LA22_78=='\n'||LA22_78=='\r'||(LA22_78>='\"' && LA22_78<='#')||LA22_78=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_78);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_116>='\u0000' && LA22_116<='/')||(LA22_116>=':' && LA22_116<='@')||(LA22_116>='G' && LA22_116<='`')||(LA22_116>='g' && LA22_116<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_116>='0' && LA22_116<='9')||(LA22_116>='A' && LA22_116<='F')||(LA22_116>='a' && LA22_116<='f')) ) {s = 118;}

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_59>='\u0000' && LA22_59<='!')||(LA22_59>='#' && LA22_59<='.')||(LA22_59>='0' && LA22_59<='[')||(LA22_59>=']' && LA22_59<='a')||(LA22_59>='c' && LA22_59<='e')||(LA22_59>='g' && LA22_59<='m')||(LA22_59>='o' && LA22_59<='q')||LA22_59=='s'||(LA22_59>='v' && LA22_59<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_59=='\"') ) {s = 89;}

                        else if ( (LA22_59=='\\') ) {s = 90;}

                        else if ( (LA22_59=='/') ) {s = 91;}

                        else if ( (LA22_59=='b') ) {s = 92;}

                        else if ( (LA22_59=='f') ) {s = 93;}

                        else if ( (LA22_59=='n') ) {s = 94;}

                        else if ( (LA22_59=='r') ) {s = 95;}

                        else if ( (LA22_59=='t') ) {s = 96;}

                        else if ( (LA22_59=='u') ) {s = 97;}

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_67 = input.LA(1);

                         
                        int index22_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_67=='\t'||LA22_67==' ') && ((( isValue() )||( isHead() )))) {s = 67;}

                        else if ( ((LA22_67>='\u0000' && LA22_67<='\b')||(LA22_67>='\u000B' && LA22_67<='\f')||(LA22_67>='\u000E' && LA22_67<='\u001F')||LA22_67=='!'||(LA22_67>='$' && LA22_67<='[')||(LA22_67>=']' && LA22_67<='\uFFFF')) && (( isValue() ))) {s = 102;}

                        else if ( (LA22_67=='\n'||LA22_67=='\r') && (( isHead() ))) {s = 68;}

                        else s = 66;

                         
                        input.seek(index22_67);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_34 = input.LA(1);

                         
                        int index22_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_34=='\n'||LA22_34=='\r') && (( isHead() ))) {s = 33;}

                        else if ( (LA22_34==' ') && ((( !isHead() )||( isHead() )))) {s = 34;}

                        else if ( (LA22_34=='-') && (( isHead() ))) {s = 35;}

                        else if ( (LA22_34=='\t') && ((( !isHead() )||( isHead() )))) {s = 36;}

                        else if ( ((LA22_34>='\u0000' && LA22_34<='\b')||(LA22_34>='\u000B' && LA22_34<='\f')||(LA22_34>='\u000E' && LA22_34<='\u001F')||(LA22_34>='!' && LA22_34<='\"')||LA22_34=='$'||(LA22_34>='&' && LA22_34<=',')||(LA22_34>='.' && LA22_34<='?')||(LA22_34>='A' && LA22_34<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else if ( (LA22_34=='@') && (( isHead() ))) {s = 37;}

                        else s = 72;

                         
                        input.seek(index22_34);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_55=='\t'||LA22_55==' ') ) {s = 85;}

                        else if ( ((LA22_55>='\u0000' && LA22_55<='\b')||(LA22_55>='\u000B' && LA22_55<='\f')||(LA22_55>='\u000E' && LA22_55<='\u001F')||LA22_55=='!'||(LA22_55>='$' && LA22_55<='\'')||LA22_55=='+'||(LA22_55>='-' && LA22_55<='9')||(LA22_55>=';' && LA22_55<='=')||(LA22_55>='?' && LA22_55<='Z')||(LA22_55>='^' && LA22_55<='z')||(LA22_55>='~' && LA22_55<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_55=='*'||LA22_55==':'||LA22_55=='>'||LA22_55=='['||LA22_55==']'||(LA22_55>='{' && LA22_55<='}')) ) {s = 87;}

                        else if ( ((LA22_55>='(' && LA22_55<=')')||LA22_55==',') ) {s = 88;}

                        else if ( (LA22_55=='\n'||LA22_55=='\r'||(LA22_55>='\"' && LA22_55<='#')||LA22_55=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_95 = input.LA(1);

                         
                        int index22_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_95=='\"') ) {s = 60;}

                        else if ( (LA22_95=='#') ) {s = 61;}

                        else if ( (LA22_95=='\\') ) {s = 59;}

                        else if ( (LA22_95=='\n'||LA22_95=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_95>='\u0000' && LA22_95<='\t')||(LA22_95>='\u000B' && LA22_95<='\f')||(LA22_95>='\u000E' && LA22_95<='!')||(LA22_95>='$' && LA22_95<='[')||(LA22_95>=']' && LA22_95<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_95);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_42=='\t'||LA22_42==' ') && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( ((LA22_42>='\u0000' && LA22_42<='\b')||(LA22_42>='\u000B' && LA22_42<='\f')||(LA22_42>='\u000E' && LA22_42<='\u001F')||LA22_42=='!'||(LA22_42>='$' && LA22_42<='\'')||LA22_42=='+'||(LA22_42>='-' && LA22_42<='9')||(LA22_42>=';' && LA22_42<='=')||(LA22_42>='?' && LA22_42<='Z')||(LA22_42>='^' && LA22_42<='z')||(LA22_42>='~' && LA22_42<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( (LA22_42=='*'||LA22_42==':'||LA22_42=='>'||LA22_42=='['||LA22_42==']'||(LA22_42>='{' && LA22_42<='}')) && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( ((LA22_42>='(' && LA22_42<=')')||LA22_42==',') && ((( isValue() )||( isHead() )))) {s = 78;}

                        else if ( (LA22_42=='\n'||LA22_42=='\r'||(LA22_42>='\"' && LA22_42<='#')||LA22_42=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_58=='\"') ) {s = 60;}

                        else if ( (LA22_58=='#') ) {s = 61;}

                        else if ( (LA22_58=='\\') ) {s = 59;}

                        else if ( (LA22_58=='\n'||LA22_58=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_58>='\u0000' && LA22_58<='\t')||(LA22_58>='\u000B' && LA22_58<='\f')||(LA22_58>='\u000E' && LA22_58<='!')||(LA22_58>='$' && LA22_58<='[')||(LA22_58>=']' && LA22_58<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_58);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_5=='-') && ((( isHead() )||( isValue() )))) {s = 27;}

                        else if ( ((LA22_5>='\u0000' && LA22_5<='\t')||(LA22_5>='\u000B' && LA22_5<='\f')||(LA22_5>='\u000E' && LA22_5<='!')||(LA22_5>='$' && LA22_5<=',')||(LA22_5>='.' && LA22_5<='[')||(LA22_5>=']' && LA22_5<='\uFFFF')) && (( isValue() ))) {s = 29;}

                        else s = 28;

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_92 = input.LA(1);

                         
                        int index22_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_92=='\"') ) {s = 60;}

                        else if ( (LA22_92=='#') ) {s = 61;}

                        else if ( (LA22_92=='\\') ) {s = 59;}

                        else if ( (LA22_92=='\n'||LA22_92=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_92>='\u0000' && LA22_92<='\t')||(LA22_92>='\u000B' && LA22_92<='\f')||(LA22_92>='\u000E' && LA22_92<='!')||(LA22_92>='$' && LA22_92<='[')||(LA22_92>=']' && LA22_92<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_92);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA22_118 = input.LA(1);

                         
                        int index22_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_118>='0' && LA22_118<='9')||(LA22_118>='A' && LA22_118<='F')||(LA22_118>='a' && LA22_118<='f')) ) {s = 120;}

                        else if ( ((LA22_118>='\u0000' && LA22_118<='/')||(LA22_118>=':' && LA22_118<='@')||(LA22_118>='G' && LA22_118<='`')||(LA22_118>='g' && LA22_118<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_118);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_111=='\"') ) {s = 99;}

                        else if ( ((LA22_111>='\u0000' && LA22_111<='\t')||(LA22_111>='\u000B' && LA22_111<='\f')||(LA22_111>='\u000E' && LA22_111<='!')||(LA22_111>='#' && LA22_111<='[')||(LA22_111>=']' && LA22_111<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_111=='\\') ) {s = 101;}

                        else if ( (LA22_111=='\n'||LA22_111=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA22_88 = input.LA(1);

                         
                        int index22_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_88=='\t'||LA22_88==' ') ) {s = 85;}

                        else if ( ((LA22_88>='\u0000' && LA22_88<='\b')||(LA22_88>='\u000B' && LA22_88<='\f')||(LA22_88>='\u000E' && LA22_88<='\u001F')||LA22_88=='!'||(LA22_88>='$' && LA22_88<='\'')||LA22_88=='+'||(LA22_88>='-' && LA22_88<='9')||(LA22_88>=';' && LA22_88<='=')||(LA22_88>='?' && LA22_88<='Z')||(LA22_88>='^' && LA22_88<='z')||(LA22_88>='~' && LA22_88<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_88=='*'||LA22_88==':'||LA22_88=='>'||LA22_88=='['||LA22_88==']'||(LA22_88>='{' && LA22_88<='}')) ) {s = 87;}

                        else if ( ((LA22_88>='(' && LA22_88<=')')||LA22_88==',') ) {s = 88;}

                        else if ( (LA22_88=='\n'||LA22_88=='\r'||(LA22_88>='\"' && LA22_88<='#')||LA22_88=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_88);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA22_20 = input.LA(1);

                         
                        int index22_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_20>='\u0000' && LA22_20<='\t')||(LA22_20>='\u000B' && LA22_20<='\f')||(LA22_20>='\u000E' && LA22_20<='!')||(LA22_20>='$' && LA22_20<='[')||(LA22_20>=']' && LA22_20<='\uFFFF')) ) {s = 58;}

                        else if ( (LA22_20=='\\') ) {s = 59;}

                        else if ( (LA22_20=='\"') ) {s = 60;}

                        else if ( (LA22_20=='#') ) {s = 61;}

                        else if ( (LA22_20=='\n'||LA22_20=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_20);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA22_103 = input.LA(1);

                         
                        int index22_103 = input.index();
                        input.rewind();
                        s = -1;
                        s = 104;

                         
                        input.seek(index22_103);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 40;

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA22_122 = input.LA(1);

                         
                        int index22_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_122=='\n'||LA22_122=='\r') && (( isHead() ))) {s = 23;}

                        else if ( (LA22_122=='\"') ) {s = 99;}

                        else if ( ((LA22_122>='\u0000' && LA22_122<='\t')||(LA22_122>='\u000B' && LA22_122<='\f')||(LA22_122>='\u000E' && LA22_122<='!')||(LA22_122>='#' && LA22_122<='[')||(LA22_122>=']' && LA22_122<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_122=='\\') ) {s = 101;}

                         
                        input.seek(index22_122);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA22_17 = input.LA(1);

                         
                        int index22_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_17>='\u0000' && LA22_17<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 52;

                         
                        input.seek(index22_17);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA22_43 = input.LA(1);

                         
                        int index22_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_43=='\t'||LA22_43==' ') && ((( isHead() )||( isValue() )))) {s = 79;}

                        else if ( ((LA22_43>='\u0000' && LA22_43<='\b')||(LA22_43>='\u000B' && LA22_43<='\f')||(LA22_43>='\u000E' && LA22_43<='\u001F')||LA22_43=='!'||(LA22_43>='$' && LA22_43<='\'')||LA22_43=='+'||(LA22_43>='-' && LA22_43<='9')||(LA22_43>=';' && LA22_43<='=')||(LA22_43>='?' && LA22_43<='Z')||(LA22_43>='^' && LA22_43<='z')||(LA22_43>='~' && LA22_43<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_43=='*'||LA22_43==':'||LA22_43=='>'||LA22_43=='['||LA22_43==']'||(LA22_43>='{' && LA22_43<='}')) && ((( isHead() )||( isValue() )))) {s = 81;}

                        else if ( ((LA22_43>='(' && LA22_43<=')')||LA22_43==',') && ((( isHead() )||( isValue() )))) {s = 82;}

                        else if ( (LA22_43=='\n'||LA22_43=='\r'||(LA22_43>='\"' && LA22_43<='#')||LA22_43=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_43);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA22_109 = input.LA(1);

                         
                        int index22_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_109=='\"') ) {s = 99;}

                        else if ( ((LA22_109>='\u0000' && LA22_109<='\t')||(LA22_109>='\u000B' && LA22_109<='\f')||(LA22_109>='\u000E' && LA22_109<='!')||(LA22_109>='#' && LA22_109<='[')||(LA22_109>=']' && LA22_109<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_109=='\\') ) {s = 101;}

                        else if ( (LA22_109=='\n'||LA22_109=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_109);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA22_82 = input.LA(1);

                         
                        int index22_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_82=='\t'||LA22_82==' ') && ((( isHead() )||( isValue() )))) {s = 79;}

                        else if ( ((LA22_82>='\u0000' && LA22_82<='\b')||(LA22_82>='\u000B' && LA22_82<='\f')||(LA22_82>='\u000E' && LA22_82<='\u001F')||LA22_82=='!'||(LA22_82>='$' && LA22_82<='\'')||LA22_82=='+'||(LA22_82>='-' && LA22_82<='9')||(LA22_82>=';' && LA22_82<='=')||(LA22_82>='?' && LA22_82<='Z')||(LA22_82>='^' && LA22_82<='z')||(LA22_82>='~' && LA22_82<='\uFFFF')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_82=='*'||LA22_82==':'||LA22_82=='>'||LA22_82=='['||LA22_82==']'||(LA22_82>='{' && LA22_82<='}')) && ((( isHead() )||( isValue() )))) {s = 81;}

                        else if ( ((LA22_82>='(' && LA22_82<=')')||LA22_82==',') && ((( isHead() )||( isValue() )))) {s = 82;}

                        else if ( (LA22_82=='\n'||LA22_82=='\r'||(LA22_82>='\"' && LA22_82<='#')||LA22_82=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_82);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA22_93 = input.LA(1);

                         
                        int index22_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_93=='\"') ) {s = 60;}

                        else if ( (LA22_93=='#') ) {s = 61;}

                        else if ( (LA22_93=='\\') ) {s = 59;}

                        else if ( (LA22_93=='\n'||LA22_93=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_93>='\u0000' && LA22_93<='\t')||(LA22_93>='\u000B' && LA22_93<='\f')||(LA22_93>='\u000E' && LA22_93<='!')||(LA22_93>='$' && LA22_93<='[')||(LA22_93>=']' && LA22_93<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_93);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA22_10 = input.LA(1);

                         
                        int index22_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_10>='\u0000' && LA22_10<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 39;

                         
                        input.seek(index22_10);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA22_16 = input.LA(1);

                         
                        int index22_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_16=='\t'||LA22_16==' ') ) {s = 48;}

                        else if ( ((LA22_16>='\u0000' && LA22_16<='\b')||(LA22_16>='\u000B' && LA22_16<='\f')||(LA22_16>='\u000E' && LA22_16<='\u001F')||LA22_16=='!'||(LA22_16>='$' && LA22_16<='\'')||LA22_16=='+'||(LA22_16>='-' && LA22_16<='9')||(LA22_16>=';' && LA22_16<='=')||(LA22_16>='?' && LA22_16<='Z')||(LA22_16>='^' && LA22_16<='z')||(LA22_16>='~' && LA22_16<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_16=='*'||LA22_16==':'||LA22_16=='>'||LA22_16=='['||LA22_16==']'||(LA22_16>='{' && LA22_16<='}')) ) {s = 50;}

                        else if ( ((LA22_16>='(' && LA22_16<=')')||LA22_16==',') ) {s = 51;}

                        else if ( (LA22_16=='\n'||LA22_16=='\r'||(LA22_16>='\"' && LA22_16<='#')||LA22_16=='\\') && (( isHead() ))) {s = 23;}

                        else s = 47;

                         
                        input.seek(index22_16);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA22_99 = input.LA(1);

                         
                        int index22_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_99>='\u0000' && LA22_99<='\uFFFF')) && (( isHead() ))) {s = 23;}

                        else s = 98;

                         
                        input.seek(index22_99);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA22_52 = input.LA(1);

                         
                        int index22_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 83;}

                        else if ( (( isValue() )) ) {s = 63;}

                         
                        input.seek(index22_52);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA22_94 = input.LA(1);

                         
                        int index22_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_94=='\"') ) {s = 60;}

                        else if ( (LA22_94=='#') ) {s = 61;}

                        else if ( (LA22_94=='\\') ) {s = 59;}

                        else if ( (LA22_94=='\n'||LA22_94=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_94>='\u0000' && LA22_94<='\t')||(LA22_94>='\u000B' && LA22_94<='\f')||(LA22_94>='\u000E' && LA22_94<='!')||(LA22_94>='$' && LA22_94<='[')||(LA22_94>=']' && LA22_94<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_94);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_114>='0' && LA22_114<='9')||(LA22_114>='A' && LA22_114<='F')||(LA22_114>='a' && LA22_114<='f')) ) {s = 117;}

                        else if ( ((LA22_114>='\u0000' && LA22_114<='/')||(LA22_114>=':' && LA22_114<='@')||(LA22_114>='G' && LA22_114<='`')||(LA22_114>='g' && LA22_114<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA22_105 = input.LA(1);

                         
                        int index22_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_105>='0' && LA22_105<='9')||(LA22_105>='A' && LA22_105<='F')||(LA22_105>='a' && LA22_105<='f')) ) {s = 116;}

                        else if ( ((LA22_105>='\u0000' && LA22_105<='/')||(LA22_105>=':' && LA22_105<='@')||(LA22_105>='G' && LA22_105<='`')||(LA22_105>='g' && LA22_105<='\uFFFF')) && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_105);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA22_91 = input.LA(1);

                         
                        int index22_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_91=='\"') ) {s = 60;}

                        else if ( (LA22_91=='#') ) {s = 61;}

                        else if ( (LA22_91=='\\') ) {s = 59;}

                        else if ( (LA22_91=='\n'||LA22_91=='\r') && (( isHead() ))) {s = 23;}

                        else if ( ((LA22_91>='\u0000' && LA22_91<='\t')||(LA22_91>='\u000B' && LA22_91<='\f')||(LA22_91>='\u000E' && LA22_91<='!')||(LA22_91>='$' && LA22_91<='[')||(LA22_91>=']' && LA22_91<='\uFFFF')) ) {s = 58;}

                         
                        input.seek(index22_91);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA22_49 = input.LA(1);

                         
                        int index22_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_49=='\t'||LA22_49==' ') ) {s = 48;}

                        else if ( ((LA22_49>='\u0000' && LA22_49<='\b')||(LA22_49>='\u000B' && LA22_49<='\f')||(LA22_49>='\u000E' && LA22_49<='\u001F')||LA22_49=='!'||(LA22_49>='$' && LA22_49<='\'')||LA22_49=='+'||(LA22_49>='-' && LA22_49<='9')||(LA22_49>=';' && LA22_49<='=')||(LA22_49>='?' && LA22_49<='Z')||(LA22_49>='^' && LA22_49<='z')||(LA22_49>='~' && LA22_49<='\uFFFF')) ) {s = 49;}

                        else if ( (LA22_49=='*'||LA22_49==':'||LA22_49=='>'||LA22_49=='['||LA22_49==']'||(LA22_49>='{' && LA22_49<='}')) ) {s = 50;}

                        else if ( ((LA22_49>='(' && LA22_49<=')')||LA22_49==',') ) {s = 51;}

                        else if ( (LA22_49=='\n'||LA22_49=='\r'||(LA22_49>='\"' && LA22_49<='#')||LA22_49=='\\') && (( isHead() ))) {s = 23;}

                        else s = 62;

                         
                        input.seek(index22_49);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA22_76 = input.LA(1);

                         
                        int index22_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_76=='\t'||LA22_76==' ') && ((( isValue() )||( isHead() )))) {s = 75;}

                        else if ( ((LA22_76>='\u0000' && LA22_76<='\b')||(LA22_76>='\u000B' && LA22_76<='\f')||(LA22_76>='\u000E' && LA22_76<='\u001F')||LA22_76=='!'||(LA22_76>='$' && LA22_76<='\'')||LA22_76=='+'||(LA22_76>='-' && LA22_76<='9')||(LA22_76>=';' && LA22_76<='=')||(LA22_76>='?' && LA22_76<='Z')||(LA22_76>='^' && LA22_76<='z')||(LA22_76>='~' && LA22_76<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 76;}

                        else if ( (LA22_76=='*'||LA22_76==':'||LA22_76=='>'||LA22_76=='['||LA22_76==']'||(LA22_76>='{' && LA22_76<='}')) && ((( isValue() )||( isHead() )))) {s = 77;}

                        else if ( ((LA22_76>='(' && LA22_76<=')')||LA22_76==',') && ((( isValue() )||( isHead() )))) {s = 78;}

                        else if ( (LA22_76=='\n'||LA22_76=='\r'||(LA22_76>='\"' && LA22_76<='#')||LA22_76=='\\') && (( isHead() ))) {s = 23;}

                        else s = 66;

                         
                        input.seek(index22_76);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA22_110 = input.LA(1);

                         
                        int index22_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_110=='\"') ) {s = 99;}

                        else if ( ((LA22_110>='\u0000' && LA22_110<='\t')||(LA22_110>='\u000B' && LA22_110<='\f')||(LA22_110>='\u000E' && LA22_110<='!')||(LA22_110>='#' && LA22_110<='[')||(LA22_110>=']' && LA22_110<='\uFFFF')) ) {s = 100;}

                        else if ( (LA22_110=='\\') ) {s = 101;}

                        else if ( (LA22_110=='\n'||LA22_110=='\r') && (( isHead() ))) {s = 23;}

                         
                        input.seek(index22_110);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA22_87 = input.LA(1);

                         
                        int index22_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_87=='\t'||LA22_87==' ') ) {s = 85;}

                        else if ( ((LA22_87>='\u0000' && LA22_87<='\b')||(LA22_87>='\u000B' && LA22_87<='\f')||(LA22_87>='\u000E' && LA22_87<='\u001F')||LA22_87=='!'||(LA22_87>='$' && LA22_87<='\'')||LA22_87=='+'||(LA22_87>='-' && LA22_87<='9')||(LA22_87>=';' && LA22_87<='=')||(LA22_87>='?' && LA22_87<='Z')||(LA22_87>='^' && LA22_87<='z')||(LA22_87>='~' && LA22_87<='\uFFFF')) ) {s = 86;}

                        else if ( (LA22_87=='*'||LA22_87==':'||LA22_87=='>'||LA22_87=='['||LA22_87==']'||(LA22_87>='{' && LA22_87<='}')) ) {s = 87;}

                        else if ( ((LA22_87>='(' && LA22_87<=')')||LA22_87==',') ) {s = 88;}

                        else if ( (LA22_87=='\n'||LA22_87=='\r'||(LA22_87>='\"' && LA22_87<='#')||LA22_87=='\\') && (( isHead() ))) {s = 23;}

                        else s = 84;

                         
                        input.seek(index22_87);
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
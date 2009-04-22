// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-22 16:57:26

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
    public static final int PlainUnsafeChar=50;
    public static final int PlainSafeKey=51;
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
    public static final int FlowIndicator=48;
    public static final int Separation=59;
    public static final int Letter=40;
    public static final int PlainSafeIn=52;
    public static final int Comma=29;
    public static final int TabSeq=32;
    public static final int NonSpaceChar=54;
    public static final int EscapeSequence=43;
    public static final int DataLine=26;
    public static final int PlainFirst=55;
    public static final int WhiteSpace=15;
    public static final int MultiLineEntrySeparator=21;
    public static final int PlainSafeOut=53;
    public static final int JSON=58;
    public static final int Question=38;
    public static final int LineComment=17;
    public static final int Colon=30;
    public static final int At=34;
    public static final int DataLineBody=25;
    public static final int KeyValuePair=13;
    public static final int Star=33;
    public static final int Preamble=18;
    public static final int Seq=31;
    public static final int FunctionIndent=23;
    public static final int Indicator=49;
    public static final int RParen=28;
    public static final int UnicodeChar=42;
    public static final int BlankLine=24;
    public static final int MultiLineSeparator=20;
    public static final int Silk=4;
    public static final int StringChar=44;
    public static final int LineBreak=19;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=27;
    public static final int String=46;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=47;
    public static final int EOF=-1;
    public static final int StringChar_s=45;
    public static final int Value=8;
    public static final int RBracket=37;
    public static final int PlainSafe=56;


    private static Logger _logger = Logger.getLogger(SilkLexer.class);

    private SilkLexerState lexerContext = new SilkLexerState();

    private State currentState() { return lexerContext.getCurrentState(); } 
    private void transit(Symbol token) { lexerContext.transit(token); } 
    private boolean isKey() { return currentState() == State.IN_KEY || currentState() == State.OUT_KEY; }
    private boolean isValue() { return currentState() == State.IN_VALUE || currentState() == State.OUT_VALUE; }
    private boolean isInValue() { return currentState() == State.IN_VALUE; }
    private boolean isOutValue() { return currentState() == State.OUT_VALUE; }
    private boolean isHead() { return getCharPositionInLine() == 0; }

      public void resetContext() { lexerContext.reset(); }

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

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:2: ( ( ' ' | '\\t' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:156:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
    // $ANTLR end "WhiteSpace"

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:12: ( '#' (~ ( LineBreakChar ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:18: ~ ( LineBreakChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:9: ({...}? => '%' (~ ( LineBreakChar ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:11: {...}? => '%' (~ ( LineBreakChar ) )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "Preamble", " isHead() ");
            }
            match('%'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:32: (~ ( LineBreakChar ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:161:32: ~ ( LineBreakChar )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:164:23: ( '\\n' | '\\r' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:2: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:4: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:4: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:5: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:167:24: '\\n'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:19: ({...}? => '--' ( WhiteSpace )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:21: {...}? => '--' ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineSeparator", " isHead() ");
            }
            match("--"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:43: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:171:43: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:24: ({...}? => '>>' ( WhiteSpace )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:26: {...}? => '>>' ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineEntrySeparator", " isHead() ");
            }
            match(">>"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:48: ( WhiteSpace )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:48: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:11: ({...}? => ( ' ' )* '-' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:30: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:174:31: ' '
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:15: ({...}? => ( ' ' )* '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:34: ( ' ' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:35: ' '
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:10: ({...}? => ( WhiteSpace )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:12: {...}? => ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:29: ( WhiteSpace )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:29: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace ) (~ ( '#' | LineBreakChar ) )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace ) (~ ( '#' | LineBreakChar ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:62: (~ ( '#' | LineBreakChar ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\"')||(LA9_0>='$' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:62: ~ ( '#' | LineBreakChar )
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineComment )? )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:11: {...}? => ( WhiteSpace )* DataLineBody ( LineComment )?
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:5: ( WhiteSpace )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            int DataLineBody1Start267 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start267, getCharIndex()-1);
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:30: ( LineComment )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='#') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:30: LineComment
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:182:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:9: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:8: ':'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:4: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:7: '>'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:7: ( '|' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:9: '|'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:5: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:8: '*'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:6: '@'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:5: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:7: '+'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:9: ( '[' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:11: '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:9: ( ']' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:11: ']'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:9: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:11: '?'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:197:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:197:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:18: ( Digit | Letter )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:21: (~ ( '\"' | '\\\\' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:23: ~ ( '\"' | '\\\\' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:21: ( UnicodeChar | EscapeSequence )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:38: EscapeSequence
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

    // $ANTLR start "StringChar_s"
    public final void mStringChar_s() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:22: ( ( StringChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:24: ( StringChar )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:24: ( StringChar )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:24: StringChar
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

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:7: ( '\"' s= StringChar_s '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart534 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart534, getCharIndex()-1);
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:209:24: ( '(' | ')' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:23: ( '[' | ']' | '{' | '}' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:214:25: ( '\"' | '\\\\' | '#' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='\\' ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='\'')||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:218:22: (~ ( PlainUnsafeChar ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:218:24: ~ ( PlainUnsafeChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='$' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

    // $ANTLR start "NonSpaceChar"
    public final void mNonSpaceChar() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:220:22: (~ ( '\"' | '\\\\' | WhiteSpace ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:220:24: ~ ( '\"' | '\\\\' | WhiteSpace )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

    // $ANTLR start "PlainFirst"
    public final void mPlainFirst() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:2: (~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\n' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||(LA16_0>='.' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                alt16=1;
            }
            else if ( (LA16_0=='+'||LA16_0=='-'||LA16_0==':'||LA16_0=='?') && (( isValue() ))) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:222:5: ~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||(input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='=')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:4: {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:22: ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    int alt15=3;
                    switch ( input.LA(1) ) {
                    case '-':
                        {
                        alt15=1;
                        }
                        break;
                    case '+':
                        {
                        alt15=2;
                        }
                        break;
                    case ':':
                    case '?':
                        {
                        alt15=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }

                    switch (alt15) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:23: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:29: '+'
                            {
                            match('+'); 

                            }
                            break;
                        case 3 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:35: ( ':' | '?' ) NonSpaceChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:2: ({...}? => PlainSafeKey | {...}? => PlainSafeIn | {...}? => PlainSafeOut )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='$' && LA17_0<='\'')||LA17_0=='+'||(LA17_0>='-' && LA17_0<='9')||(LA17_0>=';' && LA17_0<='=')||(LA17_0>='?' && LA17_0<='Z')||(LA17_0>='^' && LA17_0<='z')||(LA17_0>='~' && LA17_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:4: {...}? => PlainSafeKey
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isKey() ");
                    }
                    mPlainSafeKey(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:4: {...}? => PlainSafeIn
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainSafe", " isInValue() ");
                    }
                    mPlainSafeIn(); 

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:4: {...}? => PlainSafeOut
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:2: ( PlainFirst ( ( WhiteSpace )* PlainSafe )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:4: PlainFirst ( ( WhiteSpace )* PlainSafe )*
            {
            mPlainFirst(); 
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:15: ( ( WhiteSpace )* PlainSafe )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\n' && LA19_0<='\u001F')||LA19_0=='!'||(LA19_0>='$' && LA19_0<='\'')||LA19_0=='+'||(LA19_0>='-' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='=')||(LA19_0>='?' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||(LA19_0>='~' && LA19_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:16: ( WhiteSpace )* PlainSafe
            	    {
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:16: ( WhiteSpace )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0=='\t'||LA18_0==' ') && ((!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isOutValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isInValue() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))||( isKey() )||!(((( isInValue() )||( isOutValue() )||( isKey() ))))))) {
            	            int LA18_1 = input.LA(2);

            	            if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {
            	                alt18=1;
            	            }


            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:16: WhiteSpace
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:238:2: ({...}? => '{' | {...}? => '[' )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:238:4: {...}? => '{'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:4: {...}? => '['
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:11: ({...}? => ( WhiteSpace )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:31: ( WhiteSpace )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:31: WhiteSpace
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

    public void mTokens() throws RecognitionException {
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation )
        int alt22=25;
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

        }

    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\1\12\2\uffff\2\33\1\41\1\44\1\47\1\50\1\47\1\uffff\1\51\1\52\1"+
        "\53\1\55\1\57\1\60\1\62\1\66\1\67\1\70\1\30\1\76\1\77\1\uffff\1"+
        "\33\1\76\1\uffff\2\76\1\uffff\1\76\1\101\2\uffff\1\104\10\uffff"+
        "\1\114\1\uffff\1\114\2\uffff\1\114\1\uffff\3\114\3\uffff\3\30\1"+
        "\uffff\1\145\4\uffff\1\101\2\uffff\1\104\10\uffff\4\114\7\uffff"+
        "\1\145\13\30\3\uffff\21\30";
    static final String DFA22_eofS =
        "\171\uffff";
    static final String DFA22_minS =
        "\1\0\2\uffff\7\0\1\uffff\15\0\1\uffff\2\0\1\uffff\2\0\1\uffff\3"+
        "\0\1\uffff\2\0\2\uffff\24\0\1\42\1\uffff\3\0\1\uffff\2\0\1\uffff"+
        "\2\0\6\uffff\1\0\1\uffff\4\0\7\uffff\2\0\1\42\10\0\1\60\1\0\2\uffff"+
        "\10\0\7\60\2\0";
    static final String DFA22_maxS =
        "\1\uffff\2\uffff\5\uffff\1\0\1\uffff\1\uffff\15\uffff\1\uffff\2"+
        "\uffff\1\uffff\2\uffff\1\uffff\2\uffff\1\0\1\uffff\1\uffff\1\0\2"+
        "\uffff\5\0\1\uffff\1\0\1\uffff\2\0\1\uffff\1\0\3\uffff\3\0\2\uffff"+
        "\1\165\1\uffff\1\uffff\2\0\1\uffff\1\0\1\uffff\1\uffff\1\0\1\uffff"+
        "\6\uffff\1\0\1\uffff\4\uffff\7\uffff\2\uffff\1\165\10\uffff\1\146"+
        "\1\0\2\uffff\10\uffff\7\146\2\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\7\uffff\1\10\15\uffff\1\11\2\uffff\1\3\2\uffff"+
        "\1\27\3\uffff\1\27\2\uffff\1\7\1\6\25\uffff\1\26\3\uffff\1\27\2"+
        "\uffff\1\27\2\uffff\1\16\1\31\1\21\1\12\1\13\1\14\1\uffff\1\15\4"+
        "\uffff\1\17\1\20\1\22\1\23\1\30\1\24\1\25\15\uffff\1\4\1\5\21\uffff";
    static final String DFA22_specialS =
        "\1\101\2\uffff\1\41\1\6\1\40\1\114\1\26\1\uffff\1\31\1\uffff\1"+
        "\76\1\65\1\35\1\70\1\111\1\23\1\45\1\44\1\32\1\27\1\47\1\16\1\64"+
        "\1\uffff\1\50\1\125\1\uffff\1\17\1\120\1\uffff\1\33\1\54\1\74\1"+
        "\uffff\1\52\1\42\2\uffff\1\100\1\60\1\113\1\77\1\2\1\14\1\106\1"+
        "\122\1\57\1\130\1\126\1\105\1\20\1\121\1\34\1\116\1\75\1\107\1\12"+
        "\1\133\1\110\1\uffff\1\15\1\24\1\102\1\uffff\1\13\1\124\1\uffff"+
        "\1\55\1\22\6\uffff\1\25\1\uffff\1\112\1\10\1\103\1\37\7\uffff\1"+
        "\21\1\71\1\61\1\4\1\11\1\63\1\43\1\73\1\132\1\36\1\67\1\0\1\30\2"+
        "\uffff\1\1\1\7\1\117\1\66\1\123\1\51\1\3\1\5\1\104\1\115\1\46\1"+
        "\56\1\72\1\131\1\62\1\53\1\127}>";
    static final String[] DFA22_transitionS = {
            "\11\26\1\11\1\4\2\26\1\3\22\26\1\7\1\26\1\25\1\1\1\26\1\2\1"+
            "\26\1\30\1\13\1\14\1\20\1\21\1\15\1\5\14\26\1\16\3\26\1\6\1"+
            "\24\1\10\32\26\1\22\1\30\1\23\35\26\1\27\1\17\1\30\uff82\26",
            "",
            "",
            "\11\34\1\32\1\31\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "\42\42\2\uffff\11\42\1\40\56\42\1\uffff\uffa3\42",
            "\12\30\1\uffff\2\30\1\uffff\60\30\1\43\uffc1\30",
            "\11\30\1\11\26\30\1\7\2\30\1\uffff\1\30\1\uffff\7\30\1\46"+
            "\22\30\1\45\uffbf\30",
            "\1\uffff",
            "\11\30\1\11\26\30\1\11\2\30\1\uffff\1\30\1\uffff\7\30\1\uffff"+
            "\22\30\1\uffff\uffbf\30",
            "",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\11\54\1\30\1\42\2\54\1\42\22\54\1\30\1\54\1\30\1\56\70\54"+
            "\1\30\uffa3\54",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\11\63\1\61\1\42\2\63\1\42\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\11\54\1\30\1\42\2\54\1\42\22\54\1\30\1\54\1\30\1\56\70\54"+
            "\1\30\uffa3\54",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "",
            "\11\36\1\100\26\36\1\100\1\36\2\uffff\4\36\3\100\1\36\1\100"+
            "\15\36\1\100\3\36\1\100\34\36\1\100\1\uffff\1\100\35\36\3\100"+
            "\uff82\36",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "",
            "\11\34\1\32\1\36\2\34\1\36\22\34\1\32\1\34\2\30\4\34\2\37"+
            "\1\35\1\34\1\37\15\34\1\35\3\34\1\35\34\34\1\35\1\30\1\35\35"+
            "\34\3\35\uff82\34",
            "\11\103\1\102\26\103\1\102\1\103\2\uffff\70\103\1\uffff\uffa3"+
            "\103",
            "\1\uffff",
            "",
            "\11\30\1\105\1\uffff\2\30\1\uffff\22\30\1\105\uffdf\30",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\11\63\1\61\1\103\2\63\1\103\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\1\uffff",
            "\11\117\1\116\1\103\2\117\1\103\22\117\1\116\1\117\2\30\4"+
            "\117\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117"+
            "\1\120\1\30\1\120\35\117\3\120\uff82\117",
            "\1\uffff",
            "\1\uffff",
            "\11\63\1\61\1\103\2\63\1\103\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\1\uffff",
            "\11\63\1\61\1\103\2\63\1\103\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\11\63\1\61\1\103\2\63\1\103\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\11\63\1\61\1\103\2\63\1\103\22\63\1\61\1\63\2\30\4\63\2\65"+
            "\1\64\1\63\1\65\15\63\1\64\3\63\1\64\34\63\1\64\1\30\1\64\35"+
            "\63\3\64\uff82\63",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\1\134\14\uffff\1\136\54\uffff\1\135\5\uffff\1\137\3\uffff"+
            "\1\140\7\uffff\1\141\3\uffff\1\142\1\uffff\1\143\1\144",
            "",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\11\103\1\102\26\103\1\102\1\103\2\uffff\70\103\1\uffff\uffa3"+
            "\103",
            "",
            "\1\uffff",
            "\11\30\1\105\1\uffff\2\30\1\uffff\22\30\1\105\uffdf\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "\11\117\1\116\1\103\2\117\1\103\22\117\1\116\1\117\2\30\4"+
            "\117\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117"+
            "\1\120\1\30\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\103\2\117\1\103\22\117\1\116\1\117\2\30\4"+
            "\117\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117"+
            "\1\120\1\30\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\103\2\117\1\103\22\117\1\116\1\117\2\30\4"+
            "\117\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117"+
            "\1\120\1\30\1\120\35\117\3\120\uff82\117",
            "\11\117\1\116\1\103\2\117\1\103\22\117\1\116\1\117\2\30\4"+
            "\117\2\121\1\120\1\117\1\121\15\117\1\120\3\117\1\120\34\117"+
            "\1\120\1\30\1\120\35\117\3\120\uff82\117",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\30\1\uffff\2\30\1\uffff\ufff2\30",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\1\150\14\uffff\1\152\54\uffff\1\151\5\uffff\1\153\3\uffff"+
            "\1\154\7\uffff\1\155\3\uffff\1\156\1\uffff\1\157\1\160",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\161\7\uffff\6\161\32\uffff\6\161",
            "\1\uffff",
            "",
            "",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132",
            "\12\162\7\uffff\6\162\32\uffff\6\162",
            "\12\163\7\uffff\6\163\32\uffff\6\163",
            "\12\164\7\uffff\6\164\32\uffff\6\164",
            "\12\165\7\uffff\6\165\32\uffff\6\165",
            "\12\166\7\uffff\6\166\32\uffff\6\166",
            "\12\167\7\uffff\6\167\32\uffff\6\167",
            "\12\170\7\uffff\6\170\32\uffff\6\170",
            "\12\71\1\74\2\71\1\74\24\71\1\75\1\72\70\71\1\73\uffa3\71",
            "\12\132\1\74\2\132\1\74\24\132\1\131\71\132\1\133\uffa3\132"
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
            return "1:1: Tokens : ( LineComment | Preamble | LineBreak | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_100 = input.LA(1);

                         
                        int index22_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_100>='0' && LA22_100<='9')||(LA22_100>='A' && LA22_100<='F')||(LA22_100>='a' && LA22_100<='f')) ) {s = 113;}

                        else s = 24;

                         
                        input.seek(index22_100);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_104 = input.LA(1);

                         
                        int index22_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_104=='\"') ) {s = 89;}

                        else if ( ((LA22_104>='\u0000' && LA22_104<='\t')||(LA22_104>='\u000B' && LA22_104<='\f')||(LA22_104>='\u000E' && LA22_104<='!')||(LA22_104>='#' && LA22_104<='[')||(LA22_104>=']' && LA22_104<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_104=='\\') ) {s = 91;}

                        else if ( (LA22_104=='\n'||LA22_104=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_104);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_43 = input.LA(1);

                         
                        int index22_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 75;}

                         
                        input.seek(index22_43);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_110 = input.LA(1);

                         
                        int index22_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_110=='\"') ) {s = 89;}

                        else if ( ((LA22_110>='\u0000' && LA22_110<='\t')||(LA22_110>='\u000B' && LA22_110<='\f')||(LA22_110>='\u000E' && LA22_110<='!')||(LA22_110>='#' && LA22_110<='[')||(LA22_110>=']' && LA22_110<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_110=='\\') ) {s = 91;}

                        else if ( (LA22_110=='\n'||LA22_110=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_110);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_92 = input.LA(1);

                         
                        int index22_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_92=='#') ) {s = 58;}

                        else if ( (LA22_92=='\"') ) {s = 61;}

                        else if ( ((LA22_92>='\u0000' && LA22_92<='\t')||(LA22_92>='\u000B' && LA22_92<='\f')||(LA22_92>='\u000E' && LA22_92<='!')||(LA22_92>='$' && LA22_92<='[')||(LA22_92>=']' && LA22_92<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_92=='\\') ) {s = 59;}

                        else if ( (LA22_92=='\n'||LA22_92=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_92);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_111=='\"') ) {s = 89;}

                        else if ( ((LA22_111>='\u0000' && LA22_111<='\t')||(LA22_111>='\u000B' && LA22_111<='\f')||(LA22_111>='\u000E' && LA22_111<='!')||(LA22_111>='#' && LA22_111<='[')||(LA22_111>=']' && LA22_111<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_111=='\\') ) {s = 91;}

                        else if ( (LA22_111=='\n'||LA22_111=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_4 = input.LA(1);

                         
                        int index22_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_4=='\t'||LA22_4==' ') ) {s = 26;}

                        else if ( ((LA22_4>='\"' && LA22_4<='#')||LA22_4=='\\') && (( isHead() ))) {s = 24;}

                        else if ( ((LA22_4>='\u0000' && LA22_4<='\b')||(LA22_4>='\u000B' && LA22_4<='\f')||(LA22_4>='\u000E' && LA22_4<='\u001F')||LA22_4=='!'||(LA22_4>='$' && LA22_4<='\'')||LA22_4=='+'||(LA22_4>='-' && LA22_4<='9')||(LA22_4>=';' && LA22_4<='=')||(LA22_4>='?' && LA22_4<='Z')||(LA22_4>='^' && LA22_4<='z')||(LA22_4>='~' && LA22_4<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_4=='*'||LA22_4==':'||LA22_4=='>'||LA22_4=='['||LA22_4==']'||(LA22_4>='{' && LA22_4<='}')) ) {s = 29;}

                        else if ( (LA22_4=='\n'||LA22_4=='\r') ) {s = 30;}

                        else if ( ((LA22_4>='(' && LA22_4<=')')||LA22_4==',') ) {s = 31;}

                        else s = 27;

                         
                        input.seek(index22_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_105 = input.LA(1);

                         
                        int index22_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_105=='\"') ) {s = 89;}

                        else if ( ((LA22_105>='\u0000' && LA22_105<='\t')||(LA22_105>='\u000B' && LA22_105<='\f')||(LA22_105>='\u000E' && LA22_105<='!')||(LA22_105>='#' && LA22_105<='[')||(LA22_105>=']' && LA22_105<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_105=='\\') ) {s = 91;}

                        else if ( (LA22_105=='\n'||LA22_105=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_105);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_79 = input.LA(1);

                         
                        int index22_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_79=='\t'||LA22_79==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA22_79>='\u0000' && LA22_79<='\b')||(LA22_79>='\u000B' && LA22_79<='\f')||(LA22_79>='\u000E' && LA22_79<='\u001F')||LA22_79=='!'||(LA22_79>='$' && LA22_79<='\'')||LA22_79=='+'||(LA22_79>='-' && LA22_79<='9')||(LA22_79>=';' && LA22_79<='=')||(LA22_79>='?' && LA22_79<='Z')||(LA22_79>='^' && LA22_79<='z')||(LA22_79>='~' && LA22_79<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA22_79=='*'||LA22_79==':'||LA22_79=='>'||LA22_79=='['||LA22_79==']'||(LA22_79>='{' && LA22_79<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA22_79>='(' && LA22_79<=')')||LA22_79==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA22_79=='\n'||LA22_79=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_79>='\"' && LA22_79<='#')||LA22_79=='\\') && (( isHead() ))) {s = 24;}

                        else s = 76;

                         
                        input.seek(index22_79);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_93 = input.LA(1);

                         
                        int index22_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_93=='#') ) {s = 58;}

                        else if ( (LA22_93=='\"') ) {s = 61;}

                        else if ( ((LA22_93>='\u0000' && LA22_93<='\t')||(LA22_93>='\u000B' && LA22_93<='\f')||(LA22_93>='\u000E' && LA22_93<='!')||(LA22_93>='$' && LA22_93<='[')||(LA22_93>=']' && LA22_93<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_93=='\\') ) {s = 59;}

                        else if ( (LA22_93=='\n'||LA22_93=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_93);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_57 = input.LA(1);

                         
                        int index22_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_57=='#') ) {s = 58;}

                        else if ( (LA22_57=='\"') ) {s = 61;}

                        else if ( ((LA22_57>='\u0000' && LA22_57<='\t')||(LA22_57>='\u000B' && LA22_57<='\f')||(LA22_57>='\u000E' && LA22_57<='!')||(LA22_57>='$' && LA22_57<='[')||(LA22_57>=']' && LA22_57<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_57=='\\') ) {s = 59;}

                        else if ( (LA22_57=='\n'||LA22_57=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_57);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_65 = input.LA(1);

                         
                        int index22_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 102;}

                        else if ( (( isValue() )) ) {s = 67;}

                         
                        input.seek(index22_65);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_44 = input.LA(1);

                         
                        int index22_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_44>='\"' && LA22_44<='#')||LA22_44=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_44=='\t'||LA22_44==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_44>='\u0000' && LA22_44<='\b')||(LA22_44>='\u000B' && LA22_44<='\f')||(LA22_44>='\u000E' && LA22_44<='\u001F')||LA22_44=='!'||(LA22_44>='$' && LA22_44<='\'')||LA22_44=='+'||(LA22_44>='-' && LA22_44<='9')||(LA22_44>=';' && LA22_44<='=')||(LA22_44>='?' && LA22_44<='Z')||(LA22_44>='^' && LA22_44<='z')||(LA22_44>='~' && LA22_44<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_44=='*'||LA22_44==':'||LA22_44=='>'||LA22_44=='['||LA22_44==']'||(LA22_44>='{' && LA22_44<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( (LA22_44=='\n'||LA22_44=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_44>='(' && LA22_44<=')')||LA22_44==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else s = 76;

                         
                        input.seek(index22_44);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_61 = input.LA(1);

                         
                        int index22_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_61>='\u0000' && LA22_61<='\t')||(LA22_61>='\u000B' && LA22_61<='\f')||(LA22_61>='\u000E' && LA22_61<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 101;

                         
                        input.seek(index22_61);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_22 = input.LA(1);

                         
                        int index22_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_22=='\t'||LA22_22==' ') ) {s = 26;}

                        else if ( ((LA22_22>='\"' && LA22_22<='#')||LA22_22=='\\') && (( isHead() ))) {s = 24;}

                        else if ( ((LA22_22>='\u0000' && LA22_22<='\b')||(LA22_22>='\u000B' && LA22_22<='\f')||(LA22_22>='\u000E' && LA22_22<='\u001F')||LA22_22=='!'||(LA22_22>='$' && LA22_22<='\'')||LA22_22=='+'||(LA22_22>='-' && LA22_22<='9')||(LA22_22>=';' && LA22_22<='=')||(LA22_22>='?' && LA22_22<='Z')||(LA22_22>='^' && LA22_22<='z')||(LA22_22>='~' && LA22_22<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_22=='*'||LA22_22==':'||LA22_22=='>'||LA22_22=='['||LA22_22==']'||(LA22_22>='{' && LA22_22<='}')) ) {s = 29;}

                        else if ( (LA22_22=='\n'||LA22_22=='\r') ) {s = 30;}

                        else if ( ((LA22_22>='(' && LA22_22<=')')||LA22_22==',') ) {s = 31;}

                        else s = 62;

                         
                        input.seek(index22_22);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_28 = input.LA(1);

                         
                        int index22_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_28=='\t'||LA22_28==' ') ) {s = 26;}

                        else if ( ((LA22_28>='\u0000' && LA22_28<='\b')||(LA22_28>='\u000B' && LA22_28<='\f')||(LA22_28>='\u000E' && LA22_28<='\u001F')||LA22_28=='!'||(LA22_28>='$' && LA22_28<='\'')||LA22_28=='+'||(LA22_28>='-' && LA22_28<='9')||(LA22_28>=';' && LA22_28<='=')||(LA22_28>='?' && LA22_28<='Z')||(LA22_28>='^' && LA22_28<='z')||(LA22_28>='~' && LA22_28<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_28=='*'||LA22_28==':'||LA22_28=='>'||LA22_28=='['||LA22_28==']'||(LA22_28>='{' && LA22_28<='}')) ) {s = 29;}

                        else if ( ((LA22_28>='(' && LA22_28<=')')||LA22_28==',') ) {s = 31;}

                        else if ( ((LA22_28>='\"' && LA22_28<='#')||LA22_28=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_28=='\n'||LA22_28=='\r') ) {s = 30;}

                        else s = 62;

                         
                        input.seek(index22_28);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_51 = input.LA(1);

                         
                        int index22_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_51=='\t'||LA22_51==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_51>='\u0000' && LA22_51<='\b')||(LA22_51>='\u000B' && LA22_51<='\f')||(LA22_51>='\u000E' && LA22_51<='\u001F')||LA22_51=='!'||(LA22_51>='$' && LA22_51<='\'')||LA22_51=='+'||(LA22_51>='-' && LA22_51<='9')||(LA22_51>=';' && LA22_51<='=')||(LA22_51>='?' && LA22_51<='Z')||(LA22_51>='^' && LA22_51<='z')||(LA22_51>='~' && LA22_51<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_51=='*'||LA22_51==':'||LA22_51=='>'||LA22_51=='['||LA22_51==']'||(LA22_51>='{' && LA22_51<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( ((LA22_51>='(' && LA22_51<=')')||LA22_51==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else if ( ((LA22_51>='\"' && LA22_51<='#')||LA22_51=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_51=='\n'||LA22_51=='\r') && (( isValue() ))) {s = 67;}

                        else s = 76;

                         
                        input.seek(index22_51);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_89>='\u0000' && LA22_89<='\t')||(LA22_89>='\u000B' && LA22_89<='\f')||(LA22_89>='\u000E' && LA22_89<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 101;

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_69 = input.LA(1);

                         
                        int index22_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_69>='\u0000' && LA22_69<='\b')||(LA22_69>='\u000B' && LA22_69<='\f')||(LA22_69>='\u000E' && LA22_69<='\u001F')||(LA22_69>='!' && LA22_69<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else if ( (LA22_69=='\t'||LA22_69==' ') && (( isHead() ))) {s = 69;}

                        else s = 68;

                         
                        input.seek(index22_69);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_16 = input.LA(1);

                         
                        int index22_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_16>='\u0000' && LA22_16<='\t')||(LA22_16>='\u000B' && LA22_16<='\f')||(LA22_16>='\u000E' && LA22_16<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 48;

                         
                        input.seek(index22_16);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_62 = input.LA(1);

                         
                        int index22_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 67;}

                         
                        input.seek(index22_62);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_76 = input.LA(1);

                         
                        int index22_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (( isValue() )) ) {s = 67;}

                         
                        input.seek(index22_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_7=='@') && (( isHead() ))) {s = 37;}

                        else if ( (LA22_7==' ') && ((( !isHead() )||( isHead() )))) {s = 7;}

                        else if ( (LA22_7=='-') && (( isHead() ))) {s = 38;}

                        else if ( (LA22_7=='\t') && ((( !isHead() )||( isHead() )))) {s = 9;}

                        else if ( ((LA22_7>='\u0000' && LA22_7<='\b')||(LA22_7>='\n' && LA22_7<='\u001F')||(LA22_7>='!' && LA22_7<='\"')||LA22_7=='$'||(LA22_7>='&' && LA22_7<=',')||(LA22_7>='.' && LA22_7<='?')||(LA22_7>='A' && LA22_7<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 39;

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_20 = input.LA(1);

                         
                        int index22_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_20>='\u0000' && LA22_20<='\b')||(LA22_20>='\u000B' && LA22_20<='\f')||(LA22_20>='\u000E' && LA22_20<='\u001F')||LA22_20=='!'||(LA22_20>='$' && LA22_20<='[')||(LA22_20>=']' && LA22_20<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 44;}

                        else if ( (LA22_20=='#') && ((( isValue() )||( isHead() )))) {s = 46;}

                        else if ( (LA22_20=='\t'||LA22_20==' '||LA22_20=='\"'||LA22_20=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_20=='\n'||LA22_20=='\r') && (( isValue() ))) {s = 34;}

                        else s = 56;

                         
                        input.seek(index22_20);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_101 = input.LA(1);

                         
                        int index22_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 60;}

                         
                        input.seek(index22_101);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_9=='\t'||LA22_9==' ') && ((( !isHead() )||( isHead() )))) {s = 9;}

                        else if ( ((LA22_9>='\u0000' && LA22_9<='\b')||(LA22_9>='\n' && LA22_9<='\u001F')||(LA22_9>='!' && LA22_9<='\"')||LA22_9=='$'||(LA22_9>='&' && LA22_9<=',')||(LA22_9>='.' && LA22_9<='?')||(LA22_9>='A' && LA22_9<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 39;

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_19 = input.LA(1);

                         
                        int index22_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_19>='\u0000' && LA22_19<='\t')||(LA22_19>='\u000B' && LA22_19<='\f')||(LA22_19>='\u000E' && LA22_19<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 55;

                         
                        input.seek(index22_19);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_31 = input.LA(1);

                         
                        int index22_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_31=='\t'||LA22_31==' ') ) {s = 26;}

                        else if ( ((LA22_31>='\u0000' && LA22_31<='\b')||(LA22_31>='\u000B' && LA22_31<='\f')||(LA22_31>='\u000E' && LA22_31<='\u001F')||LA22_31=='!'||(LA22_31>='$' && LA22_31<='\'')||LA22_31=='+'||(LA22_31>='-' && LA22_31<='9')||(LA22_31>=';' && LA22_31<='=')||(LA22_31>='?' && LA22_31<='Z')||(LA22_31>='^' && LA22_31<='z')||(LA22_31>='~' && LA22_31<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_31=='*'||LA22_31==':'||LA22_31=='>'||LA22_31=='['||LA22_31==']'||(LA22_31>='{' && LA22_31<='}')) ) {s = 29;}

                        else if ( ((LA22_31>='(' && LA22_31<=')')||LA22_31==',') ) {s = 31;}

                        else if ( ((LA22_31>='\"' && LA22_31<='#')||LA22_31=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_31=='\n'||LA22_31=='\r') ) {s = 30;}

                        else s = 62;

                         
                        input.seek(index22_31);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_53 = input.LA(1);

                         
                        int index22_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_53=='\t'||LA22_53==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_53>='\u0000' && LA22_53<='\b')||(LA22_53>='\u000B' && LA22_53<='\f')||(LA22_53>='\u000E' && LA22_53<='\u001F')||LA22_53=='!'||(LA22_53>='$' && LA22_53<='\'')||LA22_53=='+'||(LA22_53>='-' && LA22_53<='9')||(LA22_53>=';' && LA22_53<='=')||(LA22_53>='?' && LA22_53<='Z')||(LA22_53>='^' && LA22_53<='z')||(LA22_53>='~' && LA22_53<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_53=='*'||LA22_53==':'||LA22_53=='>'||LA22_53=='['||LA22_53==']'||(LA22_53>='{' && LA22_53<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( ((LA22_53>='(' && LA22_53<=')')||LA22_53==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else if ( ((LA22_53>='\"' && LA22_53<='#')||LA22_53=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_53=='\n'||LA22_53=='\r') && (( isValue() ))) {s = 67;}

                        else s = 76;

                         
                        input.seek(index22_53);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_13>='\u0000' && LA22_13<='\t')||(LA22_13>='\u000B' && LA22_13<='\f')||(LA22_13>='\u000E' && LA22_13<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 43;

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_98 = input.LA(1);

                         
                        int index22_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_98=='\"') ) {s = 61;}

                        else if ( (LA22_98=='#') ) {s = 58;}

                        else if ( (LA22_98=='\\') ) {s = 59;}

                        else if ( ((LA22_98>='\u0000' && LA22_98<='\t')||(LA22_98>='\u000B' && LA22_98<='\f')||(LA22_98>='\u000E' && LA22_98<='!')||(LA22_98>='$' && LA22_98<='[')||(LA22_98>=']' && LA22_98<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_98=='\n'||LA22_98=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_98);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_81=='\t'||LA22_81==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA22_81>='\u0000' && LA22_81<='\b')||(LA22_81>='\u000B' && LA22_81<='\f')||(LA22_81>='\u000E' && LA22_81<='\u001F')||LA22_81=='!'||(LA22_81>='$' && LA22_81<='\'')||LA22_81=='+'||(LA22_81>='-' && LA22_81<='9')||(LA22_81>=';' && LA22_81<='=')||(LA22_81>='?' && LA22_81<='Z')||(LA22_81>='^' && LA22_81<='z')||(LA22_81>='~' && LA22_81<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA22_81=='*'||LA22_81==':'||LA22_81=='>'||LA22_81=='['||LA22_81==']'||(LA22_81>='{' && LA22_81<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA22_81>='(' && LA22_81<=')')||LA22_81==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA22_81=='\n'||LA22_81=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_81>='\"' && LA22_81<='#')||LA22_81=='\\') && (( isHead() ))) {s = 24;}

                        else s = 76;

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_5=='-') && ((( isHead() )||( isValue() )))) {s = 32;}

                        else if ( ((LA22_5>='\u0000' && LA22_5<='!')||(LA22_5>='$' && LA22_5<=',')||(LA22_5>='.' && LA22_5<='[')||(LA22_5>=']' && LA22_5<='\uFFFF')) && (( isValue() ))) {s = 34;}

                        else s = 33;

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_3 = input.LA(1);

                         
                        int index22_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_3=='\n') ) {s = 25;}

                        else if ( (LA22_3=='\t'||LA22_3==' ') ) {s = 26;}

                        else if ( ((LA22_3>='\"' && LA22_3<='#')||LA22_3=='\\') && (( isHead() ))) {s = 24;}

                        else if ( ((LA22_3>='\u0000' && LA22_3<='\b')||(LA22_3>='\u000B' && LA22_3<='\f')||(LA22_3>='\u000E' && LA22_3<='\u001F')||LA22_3=='!'||(LA22_3>='$' && LA22_3<='\'')||LA22_3=='+'||(LA22_3>='-' && LA22_3<='9')||(LA22_3>=';' && LA22_3<='=')||(LA22_3>='?' && LA22_3<='Z')||(LA22_3>='^' && LA22_3<='z')||(LA22_3>='~' && LA22_3<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_3=='*'||LA22_3==':'||LA22_3=='>'||LA22_3=='['||LA22_3==']'||(LA22_3>='{' && LA22_3<='}')) ) {s = 29;}

                        else if ( (LA22_3=='\r') ) {s = 30;}

                        else if ( ((LA22_3>='(' && LA22_3<=')')||LA22_3==',') ) {s = 31;}

                        else s = 27;

                         
                        input.seek(index22_3);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_36 = input.LA(1);

                         
                        int index22_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 70;}

                         
                        input.seek(index22_36);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_95 = input.LA(1);

                         
                        int index22_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_95=='#') ) {s = 58;}

                        else if ( (LA22_95=='\"') ) {s = 61;}

                        else if ( ((LA22_95>='\u0000' && LA22_95<='\t')||(LA22_95>='\u000B' && LA22_95<='\f')||(LA22_95>='\u000E' && LA22_95<='!')||(LA22_95>='$' && LA22_95<='[')||(LA22_95>=']' && LA22_95<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_95=='\\') ) {s = 59;}

                        else if ( (LA22_95=='\n'||LA22_95=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_95);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_18 = input.LA(1);

                         
                        int index22_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_18>='\u0000' && LA22_18<='\t')||(LA22_18>='\u000B' && LA22_18<='\f')||(LA22_18>='\u000E' && LA22_18<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 54;

                         
                        input.seek(index22_18);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_17 = input.LA(1);

                         
                        int index22_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_17=='\t'||LA22_17==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_17>='\"' && LA22_17<='#')||LA22_17=='\\') && (( isHead() ))) {s = 24;}

                        else if ( ((LA22_17>='\u0000' && LA22_17<='\b')||(LA22_17>='\u000B' && LA22_17<='\f')||(LA22_17>='\u000E' && LA22_17<='\u001F')||LA22_17=='!'||(LA22_17>='$' && LA22_17<='\'')||LA22_17=='+'||(LA22_17>='-' && LA22_17<='9')||(LA22_17>=';' && LA22_17<='=')||(LA22_17>='?' && LA22_17<='Z')||(LA22_17>='^' && LA22_17<='z')||(LA22_17>='~' && LA22_17<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_17=='*'||LA22_17==':'||LA22_17=='>'||LA22_17=='['||LA22_17==']'||(LA22_17>='{' && LA22_17<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( (LA22_17=='\n'||LA22_17=='\r') && (( isValue() ))) {s = 34;}

                        else if ( ((LA22_17>='(' && LA22_17<=')')||LA22_17==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else s = 50;

                         
                        input.seek(index22_17);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_114>='0' && LA22_114<='9')||(LA22_114>='A' && LA22_114<='F')||(LA22_114>='a' && LA22_114<='f')) ) {s = 116;}

                        else s = 24;

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_21>='\u0000' && LA22_21<='\t')||(LA22_21>='\u000B' && LA22_21<='\f')||(LA22_21>='\u000E' && LA22_21<='!')||(LA22_21>='$' && LA22_21<='[')||(LA22_21>=']' && LA22_21<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_21=='#') ) {s = 58;}

                        else if ( (LA22_21=='\\') ) {s = 59;}

                        else if ( (LA22_21=='\n'||LA22_21=='\r') ) {s = 60;}

                        else if ( (LA22_21=='\"') ) {s = 61;}

                        else s = 24;

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_25 = input.LA(1);

                        s = -1;
                        if ( (LA22_25=='\t'||LA22_25==' '||(LA22_25>='(' && LA22_25<='*')||LA22_25==','||LA22_25==':'||LA22_25=='>'||LA22_25=='['||LA22_25==']'||(LA22_25>='{' && LA22_25<='}')) ) {s = 64;}

                        else if ( ((LA22_25>='\u0000' && LA22_25<='\b')||(LA22_25>='\n' && LA22_25<='\u001F')||LA22_25=='!'||(LA22_25>='$' && LA22_25<='\'')||LA22_25=='+'||(LA22_25>='-' && LA22_25<='9')||(LA22_25>=';' && LA22_25<='=')||(LA22_25>='?' && LA22_25<='Z')||(LA22_25>='^' && LA22_25<='z')||(LA22_25>='~' && LA22_25<='\uFFFF')) ) {s = 30;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_109 = input.LA(1);

                         
                        int index22_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_109=='\"') ) {s = 89;}

                        else if ( ((LA22_109>='\u0000' && LA22_109<='\t')||(LA22_109>='\u000B' && LA22_109<='\f')||(LA22_109>='\u000E' && LA22_109<='!')||(LA22_109>='#' && LA22_109<='[')||(LA22_109>=']' && LA22_109<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_109=='\\') ) {s = 91;}

                        else if ( (LA22_109=='\n'||LA22_109=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_109);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_35 = input.LA(1);

                         
                        int index22_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_35>='\u0000' && LA22_35<='\b')||(LA22_35>='\u000B' && LA22_35<='\f')||(LA22_35>='\u000E' && LA22_35<='\u001F')||(LA22_35>='!' && LA22_35<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else if ( (LA22_35=='\t'||LA22_35==' ') && (( isHead() ))) {s = 69;}

                        else s = 68;

                         
                        input.seek(index22_35);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_119 = input.LA(1);

                         
                        int index22_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_119=='#') ) {s = 58;}

                        else if ( (LA22_119=='\"') ) {s = 61;}

                        else if ( ((LA22_119>='\u0000' && LA22_119<='\t')||(LA22_119>='\u000B' && LA22_119<='\f')||(LA22_119>='\u000E' && LA22_119<='!')||(LA22_119>='$' && LA22_119<='[')||(LA22_119>=']' && LA22_119<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_119=='\\') ) {s = 59;}

                        else if ( (LA22_119=='\n'||LA22_119=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_119);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA22_32 = input.LA(1);

                         
                        int index22_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_32=='\t'||LA22_32==' ') && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( ((LA22_32>='\u0000' && LA22_32<='\b')||(LA22_32>='\n' && LA22_32<='\u001F')||LA22_32=='!'||(LA22_32>='$' && LA22_32<='[')||(LA22_32>=']' && LA22_32<='\uFFFF')) && (( isValue() ))) {s = 67;}

                        else s = 65;

                         
                        input.seek(index22_32);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_68 = input.LA(1);

                         
                        int index22_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 103;}

                        else if ( (( isHead() )) ) {s = 24;}

                         
                        input.seek(index22_68);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_115 = input.LA(1);

                         
                        int index22_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_115>='0' && LA22_115<='9')||(LA22_115>='A' && LA22_115<='F')||(LA22_115>='a' && LA22_115<='f')) ) {s = 117;}

                        else s = 24;

                         
                        input.seek(index22_115);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_47 = input.LA(1);

                         
                        int index22_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 82;}

                         
                        input.seek(index22_47);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_40 = input.LA(1);

                         
                        int index22_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 37;}

                        else if ( (true) ) {s = 72;}

                         
                        input.seek(index22_40);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_91 = input.LA(1);

                         
                        int index22_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_91=='\"') ) {s = 104;}

                        else if ( (LA22_91=='\\') ) {s = 105;}

                        else if ( (LA22_91=='/') ) {s = 106;}

                        else if ( (LA22_91=='b') ) {s = 107;}

                        else if ( (LA22_91=='f') ) {s = 108;}

                        else if ( (LA22_91=='n') ) {s = 109;}

                        else if ( (LA22_91=='r') ) {s = 110;}

                        else if ( (LA22_91=='t') ) {s = 111;}

                        else if ( (LA22_91=='u') ) {s = 112;}

                        else s = 24;

                         
                        input.seek(index22_91);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_118 = input.LA(1);

                         
                        int index22_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_118>='0' && LA22_118<='9')||(LA22_118>='A' && LA22_118<='F')||(LA22_118>='a' && LA22_118<='f')) ) {s = 120;}

                        else s = 24;

                         
                        input.seek(index22_118);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_94 = input.LA(1);

                         
                        int index22_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_94=='#') ) {s = 58;}

                        else if ( (LA22_94=='\"') ) {s = 61;}

                        else if ( ((LA22_94>='\u0000' && LA22_94<='\t')||(LA22_94>='\u000B' && LA22_94<='\f')||(LA22_94>='\u000E' && LA22_94<='!')||(LA22_94>='$' && LA22_94<='[')||(LA22_94>=']' && LA22_94<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_94=='\\') ) {s = 59;}

                        else if ( (LA22_94=='\n'||LA22_94=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_94);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_23 = input.LA(1);

                         
                        int index22_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_23>='\u0000' && LA22_23<='\t')||(LA22_23>='\u000B' && LA22_23<='\f')||(LA22_23>='\u000E' && LA22_23<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 63;

                         
                        input.seek(index22_23);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_12>='\u0000' && LA22_12<='\t')||(LA22_12>='\u000B' && LA22_12<='\f')||(LA22_12>='\u000E' && LA22_12<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 42;

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_107 = input.LA(1);

                         
                        int index22_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_107=='\"') ) {s = 89;}

                        else if ( ((LA22_107>='\u0000' && LA22_107<='\t')||(LA22_107>='\u000B' && LA22_107<='\f')||(LA22_107>='\u000E' && LA22_107<='!')||(LA22_107>='#' && LA22_107<='[')||(LA22_107>=']' && LA22_107<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_107=='\\') ) {s = 91;}

                        else if ( (LA22_107=='\n'||LA22_107=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_107);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_99 = input.LA(1);

                         
                        int index22_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_99=='#') ) {s = 58;}

                        else if ( (LA22_99=='\"') ) {s = 61;}

                        else if ( ((LA22_99>='\u0000' && LA22_99<='\t')||(LA22_99>='\u000B' && LA22_99<='\f')||(LA22_99>='\u000E' && LA22_99<='!')||(LA22_99>='$' && LA22_99<='[')||(LA22_99>=']' && LA22_99<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_99=='\\') ) {s = 59;}

                        else if ( (LA22_99=='\n'||LA22_99=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_99);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_14>='\u0000' && LA22_14<='\b')||(LA22_14>='\u000B' && LA22_14<='\f')||(LA22_14>='\u000E' && LA22_14<='\u001F')||LA22_14=='!'||(LA22_14>='$' && LA22_14<='[')||(LA22_14>=']' && LA22_14<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 44;}

                        else if ( (LA22_14=='#') && ((( isValue() )||( isHead() )))) {s = 46;}

                        else if ( (LA22_14=='\t'||LA22_14==' '||LA22_14=='\"'||LA22_14=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_14=='\n'||LA22_14=='\r') && (( isValue() ))) {s = 34;}

                        else s = 45;

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_90=='\"') ) {s = 89;}

                        else if ( ((LA22_90>='\u0000' && LA22_90<='\t')||(LA22_90>='\u000B' && LA22_90<='\f')||(LA22_90>='\u000E' && LA22_90<='!')||(LA22_90>='#' && LA22_90<='[')||(LA22_90>=']' && LA22_90<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_90=='\\') ) {s = 91;}

                        else if ( (LA22_90=='\n'||LA22_90=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_116>='0' && LA22_116<='9')||(LA22_116>='A' && LA22_116<='F')||(LA22_116>='a' && LA22_116<='f')) ) {s = 118;}

                        else s = 24;

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_96 = input.LA(1);

                         
                        int index22_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_96=='#') ) {s = 58;}

                        else if ( (LA22_96=='\"') ) {s = 61;}

                        else if ( ((LA22_96>='\u0000' && LA22_96<='\t')||(LA22_96>='\u000B' && LA22_96<='\f')||(LA22_96>='\u000E' && LA22_96<='!')||(LA22_96>='$' && LA22_96<='[')||(LA22_96>=']' && LA22_96<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_96=='\\') ) {s = 59;}

                        else if ( (LA22_96=='\n'||LA22_96=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_96);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_33 = input.LA(1);

                         
                        int index22_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 38;}

                        else if ( (( isValue() )) ) {s = 67;}

                         
                        input.seek(index22_33);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\t')||(LA22_11>='\u000B' && LA22_11<='\f')||(LA22_11>='\u000E' && LA22_11<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 41;

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 74;}

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_39 = input.LA(1);

                         
                        int index22_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 10;}

                        else if ( (( !isHead() )) ) {s = 71;}

                         
                        input.seek(index22_39);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
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

                        else if ( (LA22_0==' ') && ((( !isHead() )||( isHead() )))) {s = 7;}

                        else if ( (LA22_0=='@') ) {s = 8;}

                        else if ( (LA22_0=='\t') && ((( !isHead() )||( isHead() )))) {s = 9;}

                        else if ( (LA22_0=='(') ) {s = 11;}

                        else if ( (LA22_0==')') ) {s = 12;}

                        else if ( (LA22_0==',') ) {s = 13;}

                        else if ( (LA22_0==':') ) {s = 14;}

                        else if ( (LA22_0=='|') ) {s = 15;}

                        else if ( (LA22_0=='*') ) {s = 16;}

                        else if ( (LA22_0=='+') ) {s = 17;}

                        else if ( (LA22_0=='[') ) {s = 18;}

                        else if ( (LA22_0==']') ) {s = 19;}

                        else if ( (LA22_0=='?') ) {s = 20;}

                        else if ( (LA22_0=='\"') ) {s = 21;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\u001F')||LA22_0=='!'||LA22_0=='$'||LA22_0=='&'||(LA22_0>='.' && LA22_0<='9')||(LA22_0>=';' && LA22_0<='=')||(LA22_0>='A' && LA22_0<='Z')||(LA22_0>='^' && LA22_0<='z')||(LA22_0>='~' && LA22_0<='\uFFFF')) ) {s = 22;}

                        else if ( (LA22_0=='{') && ((( isHead() )||( isValue() )))) {s = 23;}

                        else if ( (LA22_0=='\''||LA22_0=='\\'||LA22_0=='}') && (( isHead() ))) {s = 24;}

                        else s = 10;

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA22_63 = input.LA(1);

                         
                        int index22_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (( isValue() )) ) {s = 86;}

                         
                        input.seek(index22_63);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA22_80 = input.LA(1);

                         
                        int index22_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_80=='\t'||LA22_80==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA22_80>='\u0000' && LA22_80<='\b')||(LA22_80>='\u000B' && LA22_80<='\f')||(LA22_80>='\u000E' && LA22_80<='\u001F')||LA22_80=='!'||(LA22_80>='$' && LA22_80<='\'')||LA22_80=='+'||(LA22_80>='-' && LA22_80<='9')||(LA22_80>=';' && LA22_80<='=')||(LA22_80>='?' && LA22_80<='Z')||(LA22_80>='^' && LA22_80<='z')||(LA22_80>='~' && LA22_80<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA22_80=='*'||LA22_80==':'||LA22_80=='>'||LA22_80=='['||LA22_80==']'||(LA22_80>='{' && LA22_80<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA22_80>='(' && LA22_80<=')')||LA22_80==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA22_80=='\n'||LA22_80=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_80>='\"' && LA22_80<='#')||LA22_80=='\\') && (( isHead() ))) {s = 24;}

                        else s = 76;

                         
                        input.seek(index22_80);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA22_112 = input.LA(1);

                         
                        int index22_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_112>='0' && LA22_112<='9')||(LA22_112>='A' && LA22_112<='F')||(LA22_112>='a' && LA22_112<='f')) ) {s = 114;}

                        else s = 24;

                         
                        input.seek(index22_112);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA22_50 = input.LA(1);

                         
                        int index22_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (!(((( isValue() )||( isHead() ))))) ) {s = 84;}

                        else if ( (( isValue() )) ) {s = 67;}

                         
                        input.seek(index22_50);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA22_45 = input.LA(1);

                         
                        int index22_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 77;}

                         
                        input.seek(index22_45);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA22_56 = input.LA(1);

                         
                        int index22_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index22_56);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_59=='\"') ) {s = 92;}

                        else if ( (LA22_59=='\\') ) {s = 93;}

                        else if ( (LA22_59=='/') ) {s = 94;}

                        else if ( (LA22_59=='b') ) {s = 95;}

                        else if ( (LA22_59=='f') ) {s = 96;}

                        else if ( (LA22_59=='n') ) {s = 97;}

                        else if ( (LA22_59=='r') ) {s = 98;}

                        else if ( (LA22_59=='t') ) {s = 99;}

                        else if ( (LA22_59=='u') ) {s = 100;}

                        else s = 24;

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\t')||(LA22_15>='\u000B' && LA22_15<='\f')||(LA22_15>='\u000E' && LA22_15<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 47;

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA22_78 = input.LA(1);

                         
                        int index22_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_78=='\t'||LA22_78==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA22_78>='\u0000' && LA22_78<='\b')||(LA22_78>='\u000B' && LA22_78<='\f')||(LA22_78>='\u000E' && LA22_78<='\u001F')||LA22_78=='!'||(LA22_78>='$' && LA22_78<='\'')||LA22_78=='+'||(LA22_78>='-' && LA22_78<='9')||(LA22_78>=';' && LA22_78<='=')||(LA22_78>='?' && LA22_78<='Z')||(LA22_78>='^' && LA22_78<='z')||(LA22_78>='~' && LA22_78<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA22_78=='*'||LA22_78==':'||LA22_78=='>'||LA22_78=='['||LA22_78==']'||(LA22_78>='{' && LA22_78<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( ((LA22_78>='(' && LA22_78<=')')||LA22_78==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( (LA22_78=='\n'||LA22_78=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_78>='\"' && LA22_78<='#')||LA22_78=='\\') && (( isHead() ))) {s = 24;}

                        else s = 76;

                         
                        input.seek(index22_78);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA22_41 = input.LA(1);

                         
                        int index22_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 73;}

                         
                        input.seek(index22_41);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_6=='>') && (( isHead() ))) {s = 35;}

                        else if ( ((LA22_6>='\u0000' && LA22_6<='\t')||(LA22_6>='\u000B' && LA22_6<='\f')||(LA22_6>='\u000E' && LA22_6<='=')||(LA22_6>='?' && LA22_6<='\uFFFF')) && (( isHead() ))) {s = 24;}

                        else s = 36;

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_113>='0' && LA22_113<='9')||(LA22_113>='A' && LA22_113<='F')||(LA22_113>='a' && LA22_113<='f')) ) {s = 115;}

                        else s = 24;

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA22_54 = input.LA(1);

                         
                        int index22_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (!(((( isValue() )||( isHead() ))))) ) {s = 85;}

                        else if ( (( isValue() )) ) {s = 86;}

                         
                        input.seek(index22_54);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA22_106 = input.LA(1);

                         
                        int index22_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_106=='\"') ) {s = 89;}

                        else if ( ((LA22_106>='\u0000' && LA22_106<='\t')||(LA22_106>='\u000B' && LA22_106<='\f')||(LA22_106>='\u000E' && LA22_106<='!')||(LA22_106>='#' && LA22_106<='[')||(LA22_106>=']' && LA22_106<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_106=='\\') ) {s = 91;}

                        else if ( (LA22_106=='\n'||LA22_106=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_106);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA22_29 = input.LA(1);

                         
                        int index22_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_29=='\t'||LA22_29==' ') ) {s = 26;}

                        else if ( ((LA22_29>='\u0000' && LA22_29<='\b')||(LA22_29>='\u000B' && LA22_29<='\f')||(LA22_29>='\u000E' && LA22_29<='\u001F')||LA22_29=='!'||(LA22_29>='$' && LA22_29<='\'')||LA22_29=='+'||(LA22_29>='-' && LA22_29<='9')||(LA22_29>=';' && LA22_29<='=')||(LA22_29>='?' && LA22_29<='Z')||(LA22_29>='^' && LA22_29<='z')||(LA22_29>='~' && LA22_29<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_29=='*'||LA22_29==':'||LA22_29=='>'||LA22_29=='['||LA22_29==']'||(LA22_29>='{' && LA22_29<='}')) ) {s = 29;}

                        else if ( ((LA22_29>='(' && LA22_29<=')')||LA22_29==',') ) {s = 31;}

                        else if ( ((LA22_29>='\"' && LA22_29<='#')||LA22_29=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_29=='\n'||LA22_29=='\r') ) {s = 30;}

                        else s = 62;

                         
                        input.seek(index22_29);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA22_52 = input.LA(1);

                         
                        int index22_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_52=='\t'||LA22_52==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_52>='\u0000' && LA22_52<='\b')||(LA22_52>='\u000B' && LA22_52<='\f')||(LA22_52>='\u000E' && LA22_52<='\u001F')||LA22_52=='!'||(LA22_52>='$' && LA22_52<='\'')||LA22_52=='+'||(LA22_52>='-' && LA22_52<='9')||(LA22_52>=';' && LA22_52<='=')||(LA22_52>='?' && LA22_52<='Z')||(LA22_52>='^' && LA22_52<='z')||(LA22_52>='~' && LA22_52<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_52=='*'||LA22_52==':'||LA22_52=='>'||LA22_52=='['||LA22_52==']'||(LA22_52>='{' && LA22_52<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( ((LA22_52>='(' && LA22_52<=')')||LA22_52==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else if ( ((LA22_52>='\"' && LA22_52<='#')||LA22_52=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_52=='\n'||LA22_52=='\r') && (( isValue() ))) {s = 67;}

                        else s = 76;

                         
                        input.seek(index22_52);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA22_46 = input.LA(1);

                         
                        int index22_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_46=='\t'||LA22_46==' ') && ((( isHead() )||( isValue() )))) {s = 78;}

                        else if ( ((LA22_46>='\u0000' && LA22_46<='\b')||(LA22_46>='\u000B' && LA22_46<='\f')||(LA22_46>='\u000E' && LA22_46<='\u001F')||LA22_46=='!'||(LA22_46>='$' && LA22_46<='\'')||LA22_46=='+'||(LA22_46>='-' && LA22_46<='9')||(LA22_46>=';' && LA22_46<='=')||(LA22_46>='?' && LA22_46<='Z')||(LA22_46>='^' && LA22_46<='z')||(LA22_46>='~' && LA22_46<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 79;}

                        else if ( (LA22_46=='*'||LA22_46==':'||LA22_46=='>'||LA22_46=='['||LA22_46==']'||(LA22_46>='{' && LA22_46<='}')) && ((( isHead() )||( isValue() )))) {s = 80;}

                        else if ( (LA22_46=='\n'||LA22_46=='\r') && (( isValue() ))) {s = 67;}

                        else if ( ((LA22_46>='(' && LA22_46<=')')||LA22_46==',') && ((( isValue() )||( isHead() )))) {s = 81;}

                        else if ( ((LA22_46>='\"' && LA22_46<='#')||LA22_46=='\\') && (( isHead() ))) {s = 24;}

                        else s = 76;

                         
                        input.seek(index22_46);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA22_108 = input.LA(1);

                         
                        int index22_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_108=='\"') ) {s = 89;}

                        else if ( ((LA22_108>='\u0000' && LA22_108<='\t')||(LA22_108>='\u000B' && LA22_108<='\f')||(LA22_108>='\u000E' && LA22_108<='!')||(LA22_108>='#' && LA22_108<='[')||(LA22_108>=']' && LA22_108<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_108=='\\') ) {s = 91;}

                        else if ( (LA22_108=='\n'||LA22_108=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_108);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA22_66 = input.LA(1);

                         
                        int index22_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_66=='\t'||LA22_66==' ') && ((( isValue() )||( isHead() )))) {s = 66;}

                        else if ( ((LA22_66>='\u0000' && LA22_66<='\b')||(LA22_66>='\n' && LA22_66<='\u001F')||LA22_66=='!'||(LA22_66>='$' && LA22_66<='[')||(LA22_66>=']' && LA22_66<='\uFFFF')) && (( isValue() ))) {s = 67;}

                        else s = 65;

                         
                        input.seek(index22_66);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_26=='\t'||LA22_26==' ') ) {s = 26;}

                        else if ( ((LA22_26>='\u0000' && LA22_26<='\b')||(LA22_26>='\u000B' && LA22_26<='\f')||(LA22_26>='\u000E' && LA22_26<='\u001F')||LA22_26=='!'||(LA22_26>='$' && LA22_26<='\'')||LA22_26=='+'||(LA22_26>='-' && LA22_26<='9')||(LA22_26>=';' && LA22_26<='=')||(LA22_26>='?' && LA22_26<='Z')||(LA22_26>='^' && LA22_26<='z')||(LA22_26>='~' && LA22_26<='\uFFFF')) ) {s = 28;}

                        else if ( (LA22_26=='*'||LA22_26==':'||LA22_26=='>'||LA22_26=='['||LA22_26==']'||(LA22_26>='{' && LA22_26<='}')) ) {s = 29;}

                        else if ( ((LA22_26>='(' && LA22_26<=')')||LA22_26==',') ) {s = 31;}

                        else if ( ((LA22_26>='\"' && LA22_26<='#')||LA22_26=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_26=='\n'||LA22_26=='\r') ) {s = 30;}

                        else s = 62;

                         
                        input.seek(index22_26);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA22_49 = input.LA(1);

                         
                        int index22_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_49=='\t'||LA22_49==' ') && ((( isHead() )||( isValue() )))) {s = 49;}

                        else if ( ((LA22_49>='\u0000' && LA22_49<='\b')||(LA22_49>='\u000B' && LA22_49<='\f')||(LA22_49>='\u000E' && LA22_49<='\u001F')||LA22_49=='!'||(LA22_49>='$' && LA22_49<='\'')||LA22_49=='+'||(LA22_49>='-' && LA22_49<='9')||(LA22_49>=';' && LA22_49<='=')||(LA22_49>='?' && LA22_49<='Z')||(LA22_49>='^' && LA22_49<='z')||(LA22_49>='~' && LA22_49<='\uFFFF')) && ((( isValue() )||( isHead() )))) {s = 51;}

                        else if ( (LA22_49=='*'||LA22_49==':'||LA22_49=='>'||LA22_49=='['||LA22_49==']'||(LA22_49>='{' && LA22_49<='}')) && ((( isHead() )||( isValue() )))) {s = 52;}

                        else if ( ((LA22_49>='(' && LA22_49<=')')||LA22_49==',') && ((( isValue() )||( isHead() )))) {s = 53;}

                        else if ( ((LA22_49>='\"' && LA22_49<='#')||LA22_49=='\\') && (( isHead() ))) {s = 24;}

                        else if ( (LA22_49=='\n'||LA22_49=='\r') && (( isValue() ))) {s = 67;}

                        else s = 76;

                         
                        input.seek(index22_49);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA22_120 = input.LA(1);

                         
                        int index22_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_120=='\"') ) {s = 89;}

                        else if ( ((LA22_120>='\u0000' && LA22_120<='\t')||(LA22_120>='\u000B' && LA22_120<='\f')||(LA22_120>='\u000E' && LA22_120<='!')||(LA22_120>='#' && LA22_120<='[')||(LA22_120>=']' && LA22_120<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_120=='\\') ) {s = 91;}

                        else if ( (LA22_120=='\n'||LA22_120=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_120);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA22_48 = input.LA(1);

                         
                        int index22_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 24;}

                        else if ( (true) ) {s = 83;}

                         
                        input.seek(index22_48);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA22_117 = input.LA(1);

                         
                        int index22_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_117>='0' && LA22_117<='9')||(LA22_117>='A' && LA22_117<='F')||(LA22_117>='a' && LA22_117<='f')) ) {s = 119;}

                        else s = 24;

                         
                        input.seek(index22_117);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA22_97 = input.LA(1);

                         
                        int index22_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_97=='#') ) {s = 58;}

                        else if ( (LA22_97=='\"') ) {s = 61;}

                        else if ( ((LA22_97>='\u0000' && LA22_97<='\t')||(LA22_97>='\u000B' && LA22_97<='\f')||(LA22_97>='\u000E' && LA22_97<='!')||(LA22_97>='$' && LA22_97<='[')||(LA22_97>=']' && LA22_97<='\uFFFF')) ) {s = 57;}

                        else if ( (LA22_97=='\\') ) {s = 59;}

                        else if ( (LA22_97=='\n'||LA22_97=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_97);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_58=='\"') ) {s = 89;}

                        else if ( ((LA22_58>='\u0000' && LA22_58<='\t')||(LA22_58>='\u000B' && LA22_58<='\f')||(LA22_58>='\u000E' && LA22_58<='!')||(LA22_58>='#' && LA22_58<='[')||(LA22_58>=']' && LA22_58<='\uFFFF')) ) {s = 90;}

                        else if ( (LA22_58=='\\') ) {s = 91;}

                        else if ( (LA22_58=='\n'||LA22_58=='\r') ) {s = 60;}

                        else s = 24;

                         
                        input.seek(index22_58);
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
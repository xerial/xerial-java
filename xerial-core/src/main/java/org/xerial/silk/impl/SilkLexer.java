// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-22 20:18:51

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
    public static final int PlainUnsafeChar=49;
    public static final int PlainSafeKey=50;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=35;
    public static final int Digit=38;
    public static final int NodeIndent=21;
    public static final int HexDigit=40;
    public static final int PlainOneLine=55;
    public static final int Plus=34;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int FlowIndicator=47;
    public static final int Separation=57;
    public static final int Letter=39;
    public static final int PlainSafeIn=51;
    public static final int Comma=28;
    public static final int TabSeq=31;
    public static final int NonSpaceChar=53;
    public static final int EscapeSequence=42;
    public static final int DataLine=25;
    public static final int PlainFirst=54;
    public static final int WhiteSpace=15;
    public static final int MultiLineEntrySeparator=20;
    public static final int PlainSafeOut=52;
    public static final int JSON=56;
    public static final int Question=37;
    public static final int LineComment=17;
    public static final int Colon=29;
    public static final int At=33;
    public static final int DataLineBody=24;
    public static final int KeyValuePair=13;
    public static final int Star=32;
    public static final int Preamble=18;
    public static final int Seq=30;
    public static final int FunctionIndent=22;
    public static final int Indicator=48;
    public static final int RParen=27;
    public static final int UnicodeChar=41;
    public static final int StringChar=43;
    public static final int BlankLine=23;
    public static final int Silk=4;
    public static final int MultiLineSeparator=19;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=26;
    public static final int String=45;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=46;
    public static final int EOF=-1;
    public static final int StringChar_s=44;
    public static final int Value=8;
    public static final int RBracket=36;


    private static Logger _logger = Logger.getLogger(SilkLexer.class);

    private SilkLexerState lexerContext = new SilkLexerState();

    private void transit(Symbol token) { lexerContext.transit(token); } 
    private boolean isKey() { return lexerContext.isInKey(); }
    private boolean isValue() { return lexerContext.isValue(); }
    private boolean isInValue() { return lexerContext.isInValue(); }
    private boolean isOutValue() { return lexerContext.isOutValue(); }
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
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:2: ( ( ' ' | '\\t' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:155:4: ( ' ' | '\\t' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:12: ( '#' (~ ( LineBreakChar ) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:159:18: ~ ( LineBreakChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:9: ({...}? => '%' (~ ( LineBreakChar ) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:11: {...}? => '%' (~ ( LineBreakChar ) )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "Preamble", " isHead() ");
            }
            match('%'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:32: (~ ( LineBreakChar ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:160:32: ~ ( LineBreakChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:163:23: ( '\\n' | '\\r' )
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

    // $ANTLR start "MultiLineSeparator"
    public final void mMultiLineSeparator() throws RecognitionException {
        try {
            int _type = MultiLineSeparator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:19: ({...}? => '--' ( WhiteSpace )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:21: {...}? => '--' ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineSeparator", " isHead() ");
            }
            match("--"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:43: ( WhiteSpace )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:43: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:24: ({...}? => '>>' ( WhiteSpace )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:26: {...}? => '>>' ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "MultiLineEntrySeparator", " isHead() ");
            }
            match(">>"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:48: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:48: WhiteSpace
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
    // $ANTLR end "MultiLineEntrySeparator"

    // $ANTLR start "NodeIndent"
    public final void mNodeIndent() throws RecognitionException {
        try {
            int _type = NodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:11: ({...}? => ( ' ' )* '-' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:30: ( ' ' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:175:31: ' '
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:15: ({...}? => ( ' ' )* '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:34: ( ' ' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:35: ' '
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:10: ({...}? => ( WhiteSpace )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:12: {...}? => ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:29: ( WhiteSpace )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:29: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:22: (~ ( '-' | '%' | '#' | '@' | WhiteSpace ) (~ ( '#' | LineBreakChar ) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:24: ~ ( '-' | '%' | '#' | '@' | WhiteSpace ) (~ ( '#' | LineBreakChar ) )*
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='\"')||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||(input.LA(1)>='.' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:62: (~ ( '#' | LineBreakChar ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\"')||(LA8_0>='$' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:62: ~ ( '#' | LineBreakChar )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:9: ({...}? => ( WhiteSpace )* DataLineBody ( LineComment )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:11: {...}? => ( WhiteSpace )* DataLineBody ( LineComment )?
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "DataLine", " isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:5: ( WhiteSpace )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:5: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            int DataLineBody1Start241 = getCharIndex();
            mDataLineBody(); 
            DataLineBody1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, DataLineBody1Start241, getCharIndex()-1);
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:30: ( LineComment )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='#') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:181:30: LineComment
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:183:9: '('
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:9: ')'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:185:9: ','
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:6: ( ':' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:8: ':'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:4: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:7: '>'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:7: ( '|' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:190:9: '|'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:5: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:8: '*'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:192:6: '@'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:5: ( '+' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:7: '+'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:9: ( '[' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:11: '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:9: ( ']' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:195:11: ']'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:9: ( '?' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:11: '?'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:18: ( Digit | Letter )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:21: (~ ( '\"' | '\\\\' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:201:23: ~ ( '\"' | '\\\\' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:21: ( UnicodeChar | EscapeSequence )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:38: EscapeSequence
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:22: ( ( StringChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:24: ( StringChar )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:24: ( StringChar )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:24: StringChar
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:7: ( '\"' s= StringChar_s '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:207:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart508 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart508, getCharIndex()-1);
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:24: ( '(' | ')' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:23: ( '[' | ']' | '{' | '}' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:212:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:215:25: ( '\"' | '\\\\' | '#' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:218:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:218:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:219:22: (~ ( PlainUnsafeChar ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:219:24: ~ ( PlainUnsafeChar )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:22: (~ ( '\"' | '\\\\' | WhiteSpace ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:24: ~ ( '\"' | '\\\\' | WhiteSpace )
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:2: (~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\n' && LA15_0<='\u001F')||LA15_0=='!'||LA15_0=='$'||LA15_0=='&'||(LA15_0>='.' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='=')||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0=='+'||LA15_0=='-'||LA15_0==':'||LA15_0=='?') && (( isValue() ))) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:223:5: ~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:4: {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:22: ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    int alt14=3;
                    switch ( input.LA(1) ) {
                    case '-':
                        {
                        alt14=1;
                        }
                        break;
                    case '+':
                        {
                        alt14=2;
                        }
                        break;
                    case ':':
                    case '?':
                        {
                        alt14=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }

                    switch (alt14) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:23: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:29: '+'
                            {
                            match('+'); 

                            }
                            break;
                        case 3 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:35: ( ':' | '?' ) NonSpaceChar
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

    // $ANTLR start "PlainOneLine"
    public final void mPlainOneLine() throws RecognitionException {
        try {
            int _type = PlainOneLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:2: ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => PlainFirst ( PlainSafeOut )* )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\n' && LA19_0<='\u001F')||LA19_0=='!'||LA19_0=='$'||LA19_0=='&'||(LA19_0>='.' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='=')||(LA19_0>='A' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||(LA19_0>='~' && LA19_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA19_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt19=1;
                }
                else if ( (( isInValue() )) ) {
                    alt19=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt19=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0=='-') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {
                int LA19_2 = input.LA(2);

                if ( ((( isKey() )&&( isValue() ))) ) {
                    alt19=1;
                }
                else if ( ((( isInValue() )&&( isValue() ))) ) {
                    alt19=2;
                }
                else if ( ((( isOutValue() )&&( isValue() ))) ) {
                    alt19=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0=='+') && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                int LA19_3 = input.LA(2);

                if ( ((( isKey() )&&( isValue() ))) ) {
                    alt19=1;
                }
                else if ( ((( isInValue() )&&( isValue() ))) ) {
                    alt19=2;
                }
                else if ( ((( isOutValue() )&&( isValue() ))) ) {
                    alt19=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0==':'||LA19_0=='?') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                int LA19_4 = input.LA(2);

                if ( ((LA19_4>='\u0000' && LA19_4<='\b')||(LA19_4>='\n' && LA19_4<='\u001F')||LA19_4=='!'||(LA19_4>='#' && LA19_4<='[')||(LA19_4>=']' && LA19_4<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {
                    int LA19_8 = input.LA(3);

                    if ( ((( isKey() )&&( isValue() ))) ) {
                        alt19=1;
                    }
                    else if ( ((( isInValue() )&&( isValue() ))) ) {
                        alt19=2;
                    }
                    else if ( ((( isOutValue() )&&( isValue() ))) ) {
                        alt19=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 8, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 4, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:4: {...}? => PlainFirst ( PlainSafeKey )*
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isKey() ");
                    }
                    mPlainFirst(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:32: ( PlainSafeKey )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='\u0000' && LA16_0<='!')||(LA16_0>='$' && LA16_0<='\'')||LA16_0=='+'||(LA16_0>='-' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='?' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:32: PlainSafeKey
                    	    {
                    	    mPlainSafeKey(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:5: {...}? => PlainFirst ( PlainSafeIn )*
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isInValue() ");
                    }
                    mPlainFirst(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:37: ( PlainSafeIn )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='$' && LA17_0<='\'')||(LA17_0>='*' && LA17_0<='+')||(LA17_0>='-' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:37: PlainSafeIn
                    	    {
                    	    mPlainSafeIn(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:230:5: {...}? => PlainFirst ( PlainSafeOut )*
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isOutValue() ");
                    }
                    mPlainFirst(); 
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:230:38: ( PlainSafeOut )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='\u0000' && LA18_0<='!')||(LA18_0>='$' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:230:38: PlainSafeOut
                    	    {
                    	    mPlainSafeOut(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;

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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:235:2: ({...}? => '{' | {...}? => '[' )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:235:4: {...}? => '{'
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:246:4: {...}? => '['
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:11: ({...}? => ( WhiteSpace )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:31: ( WhiteSpace )+
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:31: WhiteSpace
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
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:8: ( LineComment | Preamble | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation )
        int alt22=24;
        alt22 = dfa22.predict(input);
        switch (alt22) {
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:31: MultiLineSeparator
                {
                mMultiLineSeparator(); 

                }
                break;
            case 4 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:50: MultiLineEntrySeparator
                {
                mMultiLineEntrySeparator(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:74: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:85: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:100: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:110: DataLine
                {
                mDataLine(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:119: LParen
                {
                mLParen(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:126: RParen
                {
                mRParen(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:133: Comma
                {
                mComma(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:139: Colon
                {
                mColon(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:145: Seq
                {
                mSeq(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:149: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:156: Star
                {
                mStar(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:161: At
                {
                mAt(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:164: Plus
                {
                mPlus(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:169: LBracket
                {
                mLBracket(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:178: RBracket
                {
                mRBracket(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:187: Question
                {
                mQuestion(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:196: String
                {
                mString(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:203: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 23 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:216: JSON
                {
                mJSON(); 

                }
                break;
            case 24 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:1:221: Separation
                {
                mSeparation(); 

                }
                break;

        }

    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\1\10\2\uffff\1\30\1\35\1\36\1\41\1\36\1\uffff\1\42\1\43\1\44\1"+
        "\47\1\51\1\52\1\53\1\57\1\60\1\61\1\26\1\67\1\74\1\uffff\1\75\4"+
        "\uffff\1\100\10\uffff\1\107\1\110\5\uffff\1\120\1\121\1\122\3\uffff"+
        "\2\26\1\140\1\26\2\uffff\1\144\1\uffff\1\145\1\147\2\uffff\1\152"+
        "\1\100\11\uffff\1\154\1\155\1\121\13\uffff\11\26\1\uffff\1\140\2"+
        "\26\12\uffff\21\26";
    static final String DFA22_eofS =
        "\177\uffff";
    static final String DFA22_minS =
        "\1\0\2\uffff\5\0\1\uffff\15\0\1\uffff\2\0\3\uffff\3\0\2\uffff\7"+
        "\0\1\uffff\12\0\1\42\2\0\1\uffff\2\0\1\uffff\7\0\6\uffff\5\0\4\uffff"+
        "\3\0\4\uffff\10\0\1\60\3\0\1\42\2\0\1\uffff\1\0\2\uffff\1\0\1\uffff"+
        "\2\0\1\60\10\0\5\60\1\0\1\60\1\0";
    static final String DFA22_maxS =
        "\1\uffff\2\uffff\3\uffff\1\0\1\uffff\1\uffff\15\uffff\1\uffff\1"+
        "\uffff\1\0\3\uffff\1\uffff\2\0\2\uffff\4\0\2\uffff\1\0\1\uffff\3"+
        "\0\3\uffff\3\0\1\uffff\1\165\2\uffff\1\uffff\1\0\1\uffff\1\uffff"+
        "\2\uffff\2\0\2\uffff\1\0\6\uffff\2\0\3\uffff\4\uffff\3\0\4\uffff"+
        "\10\uffff\1\146\1\0\2\uffff\1\165\2\0\1\uffff\1\0\2\uffff\1\0\1"+
        "\uffff\2\0\1\146\10\uffff\5\146\1\uffff\1\146\1\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\5\uffff\1\7\15\uffff\1\10\2\uffff\3\26\3\uffff"+
        "\1\5\1\6\7\uffff\1\26\15\uffff\1\25\2\uffff\1\26\7\uffff\1\15\1"+
        "\30\1\20\1\11\1\12\1\13\5\uffff\1\14\1\16\1\17\1\21\3\uffff\1\22"+
        "\1\27\1\23\1\24\17\uffff\1\26\1\uffff\1\26\1\3\1\uffff\1\4\23\uffff";
    static final String DFA22_specialS =
        "\1\36\2\uffff\1\24\1\62\1\113\1\uffff\1\100\1\uffff\1\61\1\105"+
        "\1\56\1\65\1\52\1\13\1\51\1\103\1\26\1\114\1\137\1\135\1\72\1\uffff"+
        "\1\45\1\0\3\uffff\1\30\1\2\1\133\2\uffff\1\15\1\132\1\73\1\106\1"+
        "\131\1\25\1\71\1\uffff\1\14\1\23\1\121\1\117\1\66\1\41\1\31\1\136"+
        "\1\130\1\63\1\16\1\76\1\126\1\uffff\1\6\1\120\1\uffff\1\67\1\42"+
        "\1\134\1\20\1\37\1\77\1\1\6\uffff\1\7\1\10\1\102\1\112\1\54\4\uffff"+
        "\1\11\1\124\1\35\4\uffff\1\50\1\74\1\57\1\3\1\21\1\101\1\44\1\125"+
        "\1\122\1\107\1\116\1\70\1\32\1\5\1\123\1\uffff\1\34\2\uffff\1\17"+
        "\1\uffff\1\4\1\33\1\104\1\115\1\40\1\27\1\53\1\55\1\43\1\22\1\47"+
        "\1\111\1\64\1\12\1\46\1\60\1\110\1\75\1\127}>";
    static final String[] DFA22_transitionS = {
            "\11\24\1\7\26\24\1\5\1\24\1\23\1\1\1\24\1\2\1\24\1\26\1\11"+
            "\1\12\1\16\1\17\1\13\1\3\14\24\1\14\3\24\1\4\1\22\1\6\32\24"+
            "\1\20\1\26\1\21\35\24\1\25\1\15\1\26\uff82\24",
            "",
            "",
            "\42\31\2\uffff\4\31\2\33\1\32\1\31\1\33\1\27\14\31\1\32\3"+
            "\31\1\32\34\31\1\32\1\uffff\1\32\35\31\3\32\uff82\31",
            "\12\26\1\uffff\2\26\1\uffff\60\26\1\34\uffc1\26",
            "\11\26\1\7\26\26\1\5\2\26\1\uffff\1\26\1\uffff\7\26\1\37\22"+
            "\26\1\40\uffbf\26",
            "\1\uffff",
            "\11\26\1\7\26\26\1\7\2\26\1\uffff\1\26\1\uffff\7\26\1\uffff"+
            "\22\26\1\uffff\uffbf\26",
            "",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\11\45\1\26\1\50\2\45\1\50\22\45\1\26\1\45\1\26\1\46\70\45"+
            "\1\26\uffa3\45",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\54\1\31\2\54\1\31\24\54\2\26\4\54\2\55\1\56\1\54\1\55"+
            "\15\54\1\56\3\54\1\56\34\54\1\56\1\26\1\56\35\54\3\56\uff82"+
            "\54",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\11\45\1\26\1\50\2\45\1\50\22\45\1\26\1\45\1\26\1\46\70\45"+
            "\1\26\uffa3\45",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\70\1\71\2\70\1\71\24\70\2\26\4\70\2\72\1\73\1\70\1\72"+
            "\15\70\1\73\3\70\1\73\34\70\1\73\1\26\1\73\35\70\3\73\uff82"+
            "\70",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "",
            "\11\31\1\76\26\31\1\76\1\31\2\uffff\4\31\2\33\1\32\1\31\1"+
            "\33\15\31\1\32\3\31\1\32\34\31\1\32\1\uffff\1\32\35\31\3\32"+
            "\uff82\31",
            "\1\uffff",
            "",
            "",
            "",
            "\11\26\1\77\1\uffff\2\26\1\uffff\22\26\1\77\uffdf\26",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\54\1\31\2\54\1\31\24\54\2\26\4\54\2\55\1\56\1\54\1\55"+
            "\15\54\1\56\3\54\1\56\34\54\1\56\1\26\1\56\35\54\3\56\uff82"+
            "\54",
            "\12\111\1\31\2\111\1\31\24\111\2\26\4\111\2\113\1\112\1\111"+
            "\1\113\15\111\1\112\3\111\1\112\34\111\1\112\1\26\1\112\35\111"+
            "\3\112\uff82\111",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\54\1\31\2\54\1\31\24\54\2\26\4\54\2\55\1\56\1\54\1\55"+
            "\15\54\1\56\3\54\1\56\34\54\1\56\1\26\1\56\35\54\3\56\uff82"+
            "\54",
            "\12\55\1\33\2\55\1\33\24\55\2\26\70\55\1\26\uffa3\55",
            "\12\56\1\32\2\56\1\32\24\56\2\26\4\56\2\55\2\56\1\55\57\56"+
            "\1\26\uffa3\56",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\1\127\14\uffff\1\131\54\uffff\1\130\5\uffff\1\132\3\uffff"+
            "\1\133\7\uffff\1\134\3\uffff\1\135\1\uffff\1\136\1\137",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "",
            "\1\uffff",
            "\12\70\1\71\2\70\1\71\24\70\2\26\4\70\2\72\1\73\1\70\1\72"+
            "\15\70\1\73\3\70\1\73\34\70\1\73\1\26\1\73\35\70\3\73\uff82"+
            "\70",
            "",
            "\12\72\1\146\2\72\1\146\24\72\2\26\70\72\1\26\uffa3\72",
            "\12\73\1\150\2\73\1\150\24\73\2\26\4\73\2\72\2\73\1\72\57"+
            "\73\1\26\uffa3\73",
            "\1\uffff",
            "\1\uffff",
            "\11\31\1\76\26\31\1\76\1\31\2\uffff\4\31\2\33\1\32\1\31\1"+
            "\33\15\31\1\32\3\31\1\32\34\31\1\32\1\uffff\1\32\35\31\3\32"+
            "\uff82\31",
            "\11\26\1\77\1\uffff\2\26\1\uffff\22\26\1\77\uffdf\26",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\12\111\1\31\2\111\1\31\24\111\2\26\4\111\2\113\1\112\1\111"+
            "\1\113\15\111\1\112\3\111\1\112\34\111\1\112\1\26\1\112\35\111"+
            "\3\112\uff82\111",
            "\12\112\1\32\2\112\1\32\24\112\2\26\4\112\2\113\2\112\1\113"+
            "\57\112\1\26\uffa3\112",
            "\12\113\1\33\2\113\1\33\24\113\2\26\70\113\1\26\uffa3\113",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\156\7\uffff\6\156\32\uffff\6\156",
            "\1\uffff",
            "\12\26\1\uffff\2\26\1\uffff\ufff2\26",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\1\157\14\uffff\1\161\54\uffff\1\160\5\uffff\1\162\3\uffff"+
            "\1\163\7\uffff\1\164\3\uffff\1\165\1\uffff\1\166\1\167",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\12\170\7\uffff\6\170\32\uffff\6\170",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142",
            "\12\171\7\uffff\6\171\32\uffff\6\171",
            "\12\172\7\uffff\6\172\32\uffff\6\172",
            "\12\173\7\uffff\6\173\32\uffff\6\173",
            "\12\174\7\uffff\6\174\32\uffff\6\174",
            "\12\175\7\uffff\6\175\32\uffff\6\175",
            "\12\62\1\66\2\62\1\66\24\62\1\64\1\65\70\62\1\63\uffa3\62",
            "\12\176\7\uffff\6\176\32\uffff\6\176",
            "\12\142\1\66\2\142\1\66\24\142\1\141\71\142\1\143\uffa3\142"
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
            return "1:1: Tokens : ( LineComment | Preamble | MultiLineSeparator | MultiLineEntrySeparator | NodeIndent | FunctionIndent | BlankLine | DataLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_24 = input.LA(1);

                         
                        int index22_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 31;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index22_24);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_64 = input.LA(1);

                         
                        int index22_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 107;}

                        else if ( (( isHead() )) ) {s = 22;}

                         
                        input.seek(index22_64);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_29 = input.LA(1);

                         
                        int index22_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 65;}

                         
                        input.seek(index22_29);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_90 = input.LA(1);

                         
                        int index22_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_90=='\"') ) {s = 52;}

                        else if ( (LA22_90=='#') ) {s = 53;}

                        else if ( (LA22_90=='\\') ) {s = 51;}

                        else if ( ((LA22_90>='\u0000' && LA22_90<='\t')||(LA22_90>='\u000B' && LA22_90<='\f')||(LA22_90>='\u000E' && LA22_90<='!')||(LA22_90>='$' && LA22_90<='[')||(LA22_90>=']' && LA22_90<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_90=='\n'||LA22_90=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_90);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_108 = input.LA(1);

                         
                        int index22_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_108);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_100 = input.LA(1);

                         
                        int index22_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 104;}

                         
                        input.seek(index22_100);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_55 = input.LA(1);

                         
                        int index22_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 57;}

                         
                        input.seek(index22_55);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_71 = input.LA(1);

                         
                        int index22_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_71);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_72 = input.LA(1);

                         
                        int index22_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_72);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA22_80 = input.LA(1);

                         
                        int index22_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_80);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA22_121 = input.LA(1);

                         
                        int index22_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_121>='0' && LA22_121<='9')||(LA22_121>='A' && LA22_121<='F')||(LA22_121>='a' && LA22_121<='f')) ) {s = 123;}

                        else s = 22;

                         
                        input.seek(index22_121);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA22_14 = input.LA(1);

                         
                        int index22_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_14>='\u0000' && LA22_14<='\t')||(LA22_14>='\u000B' && LA22_14<='\f')||(LA22_14>='\u000E' && LA22_14<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 42;

                         
                        input.seek(index22_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA22_41 = input.LA(1);

                         
                        int index22_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 77;}

                         
                        input.seek(index22_41);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA22_33 = input.LA(1);

                         
                        int index22_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 32;}

                        else if ( (true) ) {s = 67;}

                         
                        input.seek(index22_33);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA22_51 = input.LA(1);

                         
                        int index22_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_51=='\"') ) {s = 87;}

                        else if ( (LA22_51=='\\') ) {s = 88;}

                        else if ( (LA22_51=='/') ) {s = 89;}

                        else if ( (LA22_51=='b') ) {s = 90;}

                        else if ( (LA22_51=='f') ) {s = 91;}

                        else if ( (LA22_51=='n') ) {s = 92;}

                        else if ( (LA22_51=='r') ) {s = 93;}

                        else if ( (LA22_51=='t') ) {s = 94;}

                        else if ( (LA22_51=='u') ) {s = 95;}

                        else s = 22;

                         
                        input.seek(index22_51);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA22_106 = input.LA(1);

                         
                        int index22_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 105;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_106);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA22_61 = input.LA(1);

                         
                        int index22_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 105;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_61);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA22_91 = input.LA(1);

                         
                        int index22_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_91=='\"') ) {s = 52;}

                        else if ( (LA22_91=='#') ) {s = 53;}

                        else if ( (LA22_91=='\\') ) {s = 51;}

                        else if ( ((LA22_91>='\u0000' && LA22_91<='\t')||(LA22_91>='\u000B' && LA22_91<='\f')||(LA22_91>='\u000E' && LA22_91<='!')||(LA22_91>='$' && LA22_91<='[')||(LA22_91>=']' && LA22_91<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_91=='\n'||LA22_91=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_91);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA22_117 = input.LA(1);

                         
                        int index22_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_117=='\"') ) {s = 97;}

                        else if ( ((LA22_117>='\u0000' && LA22_117<='\t')||(LA22_117>='\u000B' && LA22_117<='\f')||(LA22_117>='\u000E' && LA22_117<='!')||(LA22_117>='#' && LA22_117<='[')||(LA22_117>=']' && LA22_117<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_117=='\\') ) {s = 99;}

                        else if ( (LA22_117=='\n'||LA22_117=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_117);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA22_42 = input.LA(1);

                         
                        int index22_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 78;}

                         
                        input.seek(index22_42);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA22_3 = input.LA(1);

                         
                        int index22_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_3=='-') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 23;}

                        else if ( ((LA22_3>='\u0000' && LA22_3<='!')||(LA22_3>='$' && LA22_3<='\'')||LA22_3=='+'||(LA22_3>='.' && LA22_3<='9')||(LA22_3>=';' && LA22_3<='=')||(LA22_3>='?' && LA22_3<='Z')||(LA22_3>='^' && LA22_3<='z')||(LA22_3>='~' && LA22_3<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 25;}

                        else if ( (LA22_3=='*'||LA22_3==':'||LA22_3=='>'||LA22_3=='['||LA22_3==']'||(LA22_3>='{' && LA22_3<='}')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 26;}

                        else if ( ((LA22_3>='(' && LA22_3<=')')||LA22_3==',') && ((( isOutValue() )&&( isValue() )))) {s = 27;}

                        else s = 24;

                         
                        input.seek(index22_3);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA22_38 = input.LA(1);

                         
                        int index22_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_38>='\u0000' && LA22_38<='\t')||(LA22_38>='\u000B' && LA22_38<='\f')||(LA22_38>='\u000E' && LA22_38<='!')||(LA22_38>='$' && LA22_38<='\'')||LA22_38=='+'||(LA22_38>='-' && LA22_38<='9')||(LA22_38>=';' && LA22_38<='=')||(LA22_38>='?' && LA22_38<='Z')||(LA22_38>='^' && LA22_38<='z')||(LA22_38>='~' && LA22_38<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 73;}

                        else if ( (LA22_38=='*'||LA22_38==':'||LA22_38=='>'||LA22_38=='['||LA22_38==']'||(LA22_38>='{' && LA22_38<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 74;}

                        else if ( (LA22_38=='\n'||LA22_38=='\r') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA22_38>='(' && LA22_38<=')')||LA22_38==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 75;}

                        else if ( ((LA22_38>='\"' && LA22_38<='#')||LA22_38=='\\') && (( isHead() ))) {s = 22;}

                        else s = 72;

                         
                        input.seek(index22_38);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA22_17 = input.LA(1);

                         
                        int index22_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_17>='\u0000' && LA22_17<='\t')||(LA22_17>='\u000B' && LA22_17<='\f')||(LA22_17>='\u000E' && LA22_17<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 48;

                         
                        input.seek(index22_17);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA22_113 = input.LA(1);

                         
                        int index22_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_113=='\"') ) {s = 97;}

                        else if ( ((LA22_113>='\u0000' && LA22_113<='\t')||(LA22_113>='\u000B' && LA22_113<='\f')||(LA22_113>='\u000E' && LA22_113<='!')||(LA22_113>='#' && LA22_113<='[')||(LA22_113>=']' && LA22_113<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_113=='\\') ) {s = 99;}

                        else if ( (LA22_113=='\n'||LA22_113=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_113);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA22_28 = input.LA(1);

                         
                        int index22_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_28=='\t'||LA22_28==' ') && (( isHead() ))) {s = 63;}

                        else if ( ((LA22_28>='\u0000' && LA22_28<='\b')||(LA22_28>='\u000B' && LA22_28<='\f')||(LA22_28>='\u000E' && LA22_28<='\u001F')||(LA22_28>='!' && LA22_28<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 64;

                         
                        input.seek(index22_28);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA22_47 = input.LA(1);

                         
                        int index22_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (!(((( isValue() )||( isHead() ))))) ) {s = 83;}

                        else if ( (( isValue() )) ) {s = 84;}

                         
                        input.seek(index22_47);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA22_99 = input.LA(1);

                         
                        int index22_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_99=='\"') ) {s = 111;}

                        else if ( (LA22_99=='\\') ) {s = 112;}

                        else if ( (LA22_99=='/') ) {s = 113;}

                        else if ( (LA22_99=='b') ) {s = 114;}

                        else if ( (LA22_99=='f') ) {s = 115;}

                        else if ( (LA22_99=='n') ) {s = 116;}

                        else if ( (LA22_99=='r') ) {s = 117;}

                        else if ( (LA22_99=='t') ) {s = 118;}

                        else if ( (LA22_99=='u') ) {s = 119;}

                        else s = 22;

                         
                        input.seek(index22_99);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA22_109 = input.LA(1);

                         
                        int index22_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_109);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA22_103 = input.LA(1);

                         
                        int index22_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( ((( isInValue() )||( isOutValue() ))) ) {s = 104;}

                         
                        input.seek(index22_103);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA22_82 = input.LA(1);

                         
                        int index22_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 104;}

                         
                        input.seek(index22_82);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0=='#') ) {s = 1;}

                        else if ( (LA22_0=='%') && (( isHead() ))) {s = 2;}

                        else if ( (LA22_0=='-') && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA22_0=='>') ) {s = 4;}

                        else if ( (LA22_0==' ') && ((( !isHead() )||( isHead() )))) {s = 5;}

                        else if ( (LA22_0=='@') ) {s = 6;}

                        else if ( (LA22_0=='\t') && ((( !isHead() )||( isHead() )))) {s = 7;}

                        else if ( (LA22_0=='(') ) {s = 9;}

                        else if ( (LA22_0==')') ) {s = 10;}

                        else if ( (LA22_0==',') ) {s = 11;}

                        else if ( (LA22_0==':') ) {s = 12;}

                        else if ( (LA22_0=='|') ) {s = 13;}

                        else if ( (LA22_0=='*') ) {s = 14;}

                        else if ( (LA22_0=='+') ) {s = 15;}

                        else if ( (LA22_0=='[') ) {s = 16;}

                        else if ( (LA22_0==']') ) {s = 17;}

                        else if ( (LA22_0=='?') ) {s = 18;}

                        else if ( (LA22_0=='\"') ) {s = 19;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<='\b')||(LA22_0>='\n' && LA22_0<='\u001F')||LA22_0=='!'||LA22_0=='$'||LA22_0=='&'||(LA22_0>='.' && LA22_0<='9')||(LA22_0>=';' && LA22_0<='=')||(LA22_0>='A' && LA22_0<='Z')||(LA22_0>='^' && LA22_0<='z')||(LA22_0>='~' && LA22_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isHead() )||( isKey() )))) {s = 20;}

                        else if ( (LA22_0=='{') && ((( isHead() )||( isValue() )))) {s = 21;}

                        else if ( (LA22_0=='\''||LA22_0=='\\'||LA22_0=='}') && (( isHead() ))) {s = 22;}

                        else s = 8;

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA22_62 = input.LA(1);

                         
                        int index22_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_62=='\t'||LA22_62==' ') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 62;}

                        else if ( ((LA22_62>='\u0000' && LA22_62<='\b')||(LA22_62>='\n' && LA22_62<='\u001F')||LA22_62=='!'||(LA22_62>='$' && LA22_62<='\'')||LA22_62=='+'||(LA22_62>='-' && LA22_62<='9')||(LA22_62>=';' && LA22_62<='=')||(LA22_62>='?' && LA22_62<='Z')||(LA22_62>='^' && LA22_62<='z')||(LA22_62>='~' && LA22_62<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA22_62>='(' && LA22_62<=')')||LA22_62==',') && ((( isOutValue() )&&( isValue() )))) {s = 27;}

                        else if ( (LA22_62=='*'||LA22_62==':'||LA22_62=='>'||LA22_62=='['||LA22_62==']'||(LA22_62>='{' && LA22_62<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 26;}

                        else s = 106;

                         
                        input.seek(index22_62);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA22_112 = input.LA(1);

                         
                        int index22_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_112=='\"') ) {s = 97;}

                        else if ( ((LA22_112>='\u0000' && LA22_112<='\t')||(LA22_112>='\u000B' && LA22_112<='\f')||(LA22_112>='\u000E' && LA22_112<='!')||(LA22_112>='#' && LA22_112<='[')||(LA22_112>=']' && LA22_112<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_112=='\\') ) {s = 99;}

                        else if ( (LA22_112=='\n'||LA22_112=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_112);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA22_46 = input.LA(1);

                         
                        int index22_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_46>='\u0000' && LA22_46<='\t')||(LA22_46>='\u000B' && LA22_46<='\f')||(LA22_46>='\u000E' && LA22_46<='!')||(LA22_46>='$' && LA22_46<='\'')||(LA22_46>='*' && LA22_46<='+')||(LA22_46>='-' && LA22_46<='[')||(LA22_46>=']' && LA22_46<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 46;}

                        else if ( ((LA22_46>='(' && LA22_46<=')')||LA22_46==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 45;}

                        else if ( ((LA22_46>='\"' && LA22_46<='#')||LA22_46=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_46=='\n'||LA22_46=='\r') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 26;}

                        else s = 82;

                         
                        input.seek(index22_46);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA22_59 = input.LA(1);

                         
                        int index22_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_59>='\u0000' && LA22_59<='\t')||(LA22_59>='\u000B' && LA22_59<='\f')||(LA22_59>='\u000E' && LA22_59<='!')||(LA22_59>='$' && LA22_59<='\'')||(LA22_59>='*' && LA22_59<='+')||(LA22_59>='-' && LA22_59<='[')||(LA22_59>=']' && LA22_59<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isHead() )))) {s = 59;}

                        else if ( ((LA22_59>='(' && LA22_59<=')')||LA22_59==',') && ((( isOutValue() )||( isHead() )))) {s = 58;}

                        else if ( ((LA22_59>='\"' && LA22_59<='#')||LA22_59=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_59=='\n'||LA22_59=='\r') && ((( isInValue() )||( isOutValue() )))) {s = 104;}

                        else s = 103;

                         
                        input.seek(index22_59);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA22_116 = input.LA(1);

                         
                        int index22_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_116=='\"') ) {s = 97;}

                        else if ( ((LA22_116>='\u0000' && LA22_116<='\t')||(LA22_116>='\u000B' && LA22_116<='\f')||(LA22_116>='\u000E' && LA22_116<='!')||(LA22_116>='#' && LA22_116<='[')||(LA22_116>=']' && LA22_116<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_116=='\\') ) {s = 99;}

                        else if ( (LA22_116=='\n'||LA22_116=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_116);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA22_93 = input.LA(1);

                         
                        int index22_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_93=='\"') ) {s = 52;}

                        else if ( (LA22_93=='#') ) {s = 53;}

                        else if ( (LA22_93=='\\') ) {s = 51;}

                        else if ( ((LA22_93>='\u0000' && LA22_93<='\t')||(LA22_93>='\u000B' && LA22_93<='\f')||(LA22_93>='\u000E' && LA22_93<='!')||(LA22_93>='$' && LA22_93<='[')||(LA22_93>=']' && LA22_93<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_93=='\n'||LA22_93=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_93);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA22_23 = input.LA(1);

                         
                        int index22_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_23=='\t'||LA22_23==' ') && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 62;}

                        else if ( ((LA22_23>='\u0000' && LA22_23<='\b')||(LA22_23>='\n' && LA22_23<='\u001F')||LA22_23=='!'||(LA22_23>='$' && LA22_23<='\'')||LA22_23=='+'||(LA22_23>='-' && LA22_23<='9')||(LA22_23>=';' && LA22_23<='=')||(LA22_23>='?' && LA22_23<='Z')||(LA22_23>='^' && LA22_23<='z')||(LA22_23>='~' && LA22_23<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA22_23>='(' && LA22_23<=')')||LA22_23==',') && ((( isOutValue() )&&( isValue() )))) {s = 27;}

                        else if ( (LA22_23=='*'||LA22_23==':'||LA22_23=='>'||LA22_23=='['||LA22_23==']'||(LA22_23>='{' && LA22_23<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 26;}

                        else s = 61;

                         
                        input.seek(index22_23);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA22_122 = input.LA(1);

                         
                        int index22_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_122>='0' && LA22_122<='9')||(LA22_122>='A' && LA22_122<='F')||(LA22_122>='a' && LA22_122<='f')) ) {s = 124;}

                        else s = 22;

                         
                        input.seek(index22_122);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA22_118 = input.LA(1);

                         
                        int index22_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_118=='\"') ) {s = 97;}

                        else if ( ((LA22_118>='\u0000' && LA22_118<='\t')||(LA22_118>='\u000B' && LA22_118<='\f')||(LA22_118>='\u000E' && LA22_118<='!')||(LA22_118>='#' && LA22_118<='[')||(LA22_118>=']' && LA22_118<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_118=='\\') ) {s = 99;}

                        else if ( (LA22_118=='\n'||LA22_118=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_118);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA22_87 = input.LA(1);

                         
                        int index22_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_87=='\"') ) {s = 52;}

                        else if ( (LA22_87=='#') ) {s = 53;}

                        else if ( (LA22_87=='\\') ) {s = 51;}

                        else if ( ((LA22_87>='\u0000' && LA22_87<='\t')||(LA22_87>='\u000B' && LA22_87<='\f')||(LA22_87>='\u000E' && LA22_87<='!')||(LA22_87>='$' && LA22_87<='[')||(LA22_87>=']' && LA22_87<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_87=='\n'||LA22_87=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_87);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_15>='\u0000' && LA22_15<='\t')||(LA22_15>='\u000B' && LA22_15<='\f')||(LA22_15>='\u000E' && LA22_15<='!')||(LA22_15>='$' && LA22_15<='\'')||LA22_15=='+'||(LA22_15>='-' && LA22_15<='9')||(LA22_15>=';' && LA22_15<='=')||(LA22_15>='?' && LA22_15<='Z')||(LA22_15>='^' && LA22_15<='z')||(LA22_15>='~' && LA22_15<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 44;}

                        else if ( ((LA22_15>='(' && LA22_15<=')')||LA22_15==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 45;}

                        else if ( (LA22_15=='\n'||LA22_15=='\r') && (((( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA22_15>='\"' && LA22_15<='#')||LA22_15=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_15=='*'||LA22_15==':'||LA22_15=='>'||LA22_15=='['||LA22_15==']'||(LA22_15>='{' && LA22_15<='}')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 46;}

                        else s = 43;

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA22_13 = input.LA(1);

                         
                        int index22_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_13>='\u0000' && LA22_13<='\t')||(LA22_13>='\u000B' && LA22_13<='\f')||(LA22_13>='\u000E' && LA22_13<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 41;

                         
                        input.seek(index22_13);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA22_114 = input.LA(1);

                         
                        int index22_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_114=='\"') ) {s = 97;}

                        else if ( ((LA22_114>='\u0000' && LA22_114<='\t')||(LA22_114>='\u000B' && LA22_114<='\f')||(LA22_114>='\u000E' && LA22_114<='!')||(LA22_114>='#' && LA22_114<='[')||(LA22_114>=']' && LA22_114<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_114=='\\') ) {s = 99;}

                        else if ( (LA22_114=='\n'||LA22_114=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_114);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_75>='\u0000' && LA22_75<='\t')||(LA22_75>='\u000B' && LA22_75<='\f')||(LA22_75>='\u000E' && LA22_75<='!')||(LA22_75>='$' && LA22_75<='[')||(LA22_75>=']' && LA22_75<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 75;}

                        else if ( (LA22_75=='\n'||LA22_75=='\r') && ((( isOutValue() )&&( isValue() )))) {s = 27;}

                        else if ( ((LA22_75>='\"' && LA22_75<='#')||LA22_75=='\\') && (( isHead() ))) {s = 22;}

                        else s = 81;

                         
                        input.seek(index22_75);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA22_115 = input.LA(1);

                         
                        int index22_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_115=='\"') ) {s = 97;}

                        else if ( ((LA22_115>='\u0000' && LA22_115<='\t')||(LA22_115>='\u000B' && LA22_115<='\f')||(LA22_115>='\u000E' && LA22_115<='!')||(LA22_115>='#' && LA22_115<='[')||(LA22_115>=']' && LA22_115<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_115=='\\') ) {s = 99;}

                        else if ( (LA22_115=='\n'||LA22_115=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_115);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_11>='\u0000' && LA22_11<='\t')||(LA22_11>='\u000B' && LA22_11<='\f')||(LA22_11>='\u000E' && LA22_11<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 36;

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA22_89 = input.LA(1);

                         
                        int index22_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_89=='\"') ) {s = 52;}

                        else if ( (LA22_89=='#') ) {s = 53;}

                        else if ( (LA22_89=='\\') ) {s = 51;}

                        else if ( ((LA22_89>='\u0000' && LA22_89<='\t')||(LA22_89>='\u000B' && LA22_89<='\f')||(LA22_89>='\u000E' && LA22_89<='!')||(LA22_89>='$' && LA22_89<='[')||(LA22_89>=']' && LA22_89<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_89=='\n'||LA22_89=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_89);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA22_123 = input.LA(1);

                         
                        int index22_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_123>='0' && LA22_123<='9')||(LA22_123>='A' && LA22_123<='F')||(LA22_123>='a' && LA22_123<='f')) ) {s = 125;}

                        else s = 22;

                         
                        input.seek(index22_123);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_9>='\u0000' && LA22_9<='\t')||(LA22_9>='\u000B' && LA22_9<='\f')||(LA22_9>='\u000E' && LA22_9<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 34;

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA22_4 = input.LA(1);

                         
                        int index22_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_4=='>') && (( isHead() ))) {s = 28;}

                        else if ( ((LA22_4>='\u0000' && LA22_4<='\t')||(LA22_4>='\u000B' && LA22_4<='\f')||(LA22_4>='\u000E' && LA22_4<='=')||(LA22_4>='?' && LA22_4<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 29;

                         
                        input.seek(index22_4);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA22_50 = input.LA(1);

                         
                        int index22_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_50=='\"') ) {s = 52;}

                        else if ( (LA22_50=='#') ) {s = 53;}

                        else if ( (LA22_50=='\\') ) {s = 51;}

                        else if ( ((LA22_50>='\u0000' && LA22_50<='\t')||(LA22_50>='\u000B' && LA22_50<='\f')||(LA22_50>='\u000E' && LA22_50<='!')||(LA22_50>='$' && LA22_50<='[')||(LA22_50>=']' && LA22_50<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_50=='\n'||LA22_50=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_50);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA22_120 = input.LA(1);

                         
                        int index22_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_120>='0' && LA22_120<='9')||(LA22_120>='A' && LA22_120<='F')||(LA22_120>='a' && LA22_120<='f')) ) {s = 122;}

                        else s = 22;

                         
                        input.seek(index22_120);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_12>='\u0000' && LA22_12<='\b')||(LA22_12>='\u000B' && LA22_12<='\f')||(LA22_12>='\u000E' && LA22_12<='\u001F')||LA22_12=='!'||(LA22_12>='$' && LA22_12<='[')||(LA22_12>=']' && LA22_12<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 37;}

                        else if ( (LA22_12=='#') && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 38;}

                        else if ( (LA22_12=='\t'||LA22_12==' '||LA22_12=='\"'||LA22_12=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_12=='\n'||LA22_12=='\r') && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 40;}

                        else s = 39;

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA22_45 = input.LA(1);

                         
                        int index22_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_45>='\u0000' && LA22_45<='\t')||(LA22_45>='\u000B' && LA22_45<='\f')||(LA22_45>='\u000E' && LA22_45<='!')||(LA22_45>='$' && LA22_45<='[')||(LA22_45>=']' && LA22_45<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 45;}

                        else if ( ((LA22_45>='\"' && LA22_45<='#')||LA22_45=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_45=='\n'||LA22_45=='\r') && ((( isOutValue() )&&( isValue() )))) {s = 27;}

                        else s = 81;

                         
                        input.seek(index22_45);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA22_58 = input.LA(1);

                         
                        int index22_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_58>='\u0000' && LA22_58<='\t')||(LA22_58>='\u000B' && LA22_58<='\f')||(LA22_58>='\u000E' && LA22_58<='!')||(LA22_58>='$' && LA22_58<='[')||(LA22_58>=']' && LA22_58<='\uFFFF')) && ((( isOutValue() )||( isHead() )))) {s = 58;}

                        else if ( ((LA22_58>='\"' && LA22_58<='#')||LA22_58=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_58=='\n'||LA22_58=='\r') && (( isOutValue() ))) {s = 102;}

                        else s = 101;

                         
                        input.seek(index22_58);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA22_98 = input.LA(1);

                         
                        int index22_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_98=='\"') ) {s = 97;}

                        else if ( ((LA22_98>='\u0000' && LA22_98<='\t')||(LA22_98>='\u000B' && LA22_98<='\f')||(LA22_98>='\u000E' && LA22_98<='!')||(LA22_98>='#' && LA22_98<='[')||(LA22_98>=']' && LA22_98<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_98=='\\') ) {s = 99;}

                        else if ( (LA22_98=='\n'||LA22_98=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_98);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA22_39 = input.LA(1);

                         
                        int index22_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index22_39);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_21>='\u0000' && LA22_21<='\t')||(LA22_21>='\u000B' && LA22_21<='\f')||(LA22_21>='\u000E' && LA22_21<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 60;

                         
                        input.seek(index22_21);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA22_35 = input.LA(1);

                         
                        int index22_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 69;}

                         
                        input.seek(index22_35);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA22_88 = input.LA(1);

                         
                        int index22_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_88=='\"') ) {s = 52;}

                        else if ( (LA22_88=='#') ) {s = 53;}

                        else if ( (LA22_88=='\\') ) {s = 51;}

                        else if ( ((LA22_88>='\u0000' && LA22_88<='\t')||(LA22_88>='\u000B' && LA22_88<='\f')||(LA22_88>='\u000E' && LA22_88<='!')||(LA22_88>='$' && LA22_88<='[')||(LA22_88>=']' && LA22_88<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_88=='\n'||LA22_88=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_88);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA22_125 = input.LA(1);

                         
                        int index22_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_125>='0' && LA22_125<='9')||(LA22_125>='A' && LA22_125<='F')||(LA22_125>='a' && LA22_125<='f')) ) {s = 126;}

                        else s = 22;

                         
                        input.seek(index22_125);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA22_52 = input.LA(1);

                         
                        int index22_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_52>='\u0000' && LA22_52<='\t')||(LA22_52>='\u000B' && LA22_52<='\f')||(LA22_52>='\u000E' && LA22_52<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 96;

                         
                        input.seek(index22_52);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA22_63 = input.LA(1);

                         
                        int index22_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_63=='\t'||LA22_63==' ') && (( isHead() ))) {s = 63;}

                        else if ( ((LA22_63>='\u0000' && LA22_63<='\b')||(LA22_63>='\u000B' && LA22_63<='\f')||(LA22_63>='\u000E' && LA22_63<='\u001F')||(LA22_63>='!' && LA22_63<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 64;

                         
                        input.seek(index22_63);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_7>='\u0000' && LA22_7<='\b')||(LA22_7>='\n' && LA22_7<='\u001F')||(LA22_7>='!' && LA22_7<='\"')||LA22_7=='$'||(LA22_7>='&' && LA22_7<=',')||(LA22_7>='.' && LA22_7<='?')||(LA22_7>='A' && LA22_7<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA22_7=='\t'||LA22_7==' ') && ((( !isHead() )||( isHead() )))) {s = 7;}

                        else s = 30;

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA22_92 = input.LA(1);

                         
                        int index22_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_92=='\"') ) {s = 52;}

                        else if ( (LA22_92=='#') ) {s = 53;}

                        else if ( (LA22_92=='\\') ) {s = 51;}

                        else if ( ((LA22_92>='\u0000' && LA22_92<='\t')||(LA22_92>='\u000B' && LA22_92<='\f')||(LA22_92>='\u000E' && LA22_92<='!')||(LA22_92>='$' && LA22_92<='[')||(LA22_92>=']' && LA22_92<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_92=='\n'||LA22_92=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_92);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA22_73 = input.LA(1);

                         
                        int index22_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_73>='\u0000' && LA22_73<='\t')||(LA22_73>='\u000B' && LA22_73<='\f')||(LA22_73>='\u000E' && LA22_73<='!')||(LA22_73>='$' && LA22_73<='\'')||LA22_73=='+'||(LA22_73>='-' && LA22_73<='9')||(LA22_73>=';' && LA22_73<='=')||(LA22_73>='?' && LA22_73<='Z')||(LA22_73>='^' && LA22_73<='z')||(LA22_73>='~' && LA22_73<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 73;}

                        else if ( (LA22_73=='\n'||LA22_73=='\r') && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA22_73>='\"' && LA22_73<='#')||LA22_73=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA22_73>='(' && LA22_73<=')')||LA22_73==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 75;}

                        else if ( (LA22_73=='*'||LA22_73==':'||LA22_73=='>'||LA22_73=='['||LA22_73==']'||(LA22_73>='{' && LA22_73<='}')) && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 74;}

                        else s = 108;

                         
                        input.seek(index22_73);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA22_16 = input.LA(1);

                         
                        int index22_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_16>='\u0000' && LA22_16<='\t')||(LA22_16>='\u000B' && LA22_16<='\f')||(LA22_16>='\u000E' && LA22_16<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 47;

                         
                        input.seek(index22_16);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA22_110 = input.LA(1);

                         
                        int index22_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_110>='0' && LA22_110<='9')||(LA22_110>='A' && LA22_110<='F')||(LA22_110>='a' && LA22_110<='f')) ) {s = 120;}

                        else s = 22;

                         
                        input.seek(index22_110);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA22_10 = input.LA(1);

                         
                        int index22_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_10>='\u0000' && LA22_10<='\t')||(LA22_10>='\u000B' && LA22_10<='\f')||(LA22_10>='\u000E' && LA22_10<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 35;

                         
                        input.seek(index22_10);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA22_36 = input.LA(1);

                         
                        int index22_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 70;}

                         
                        input.seek(index22_36);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA22_96 = input.LA(1);

                         
                        int index22_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 54;}

                         
                        input.seek(index22_96);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA22_124 = input.LA(1);

                         
                        int index22_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_124=='\"') ) {s = 52;}

                        else if ( (LA22_124=='#') ) {s = 53;}

                        else if ( (LA22_124=='\\') ) {s = 51;}

                        else if ( ((LA22_124>='\u0000' && LA22_124<='\t')||(LA22_124>='\u000B' && LA22_124<='\f')||(LA22_124>='\u000E' && LA22_124<='!')||(LA22_124>='$' && LA22_124<='[')||(LA22_124>=']' && LA22_124<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_124=='\n'||LA22_124=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_124);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA22_119 = input.LA(1);

                         
                        int index22_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_119>='0' && LA22_119<='9')||(LA22_119>='A' && LA22_119<='F')||(LA22_119>='a' && LA22_119<='f')) ) {s = 121;}

                        else s = 22;

                         
                        input.seek(index22_119);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA22_74 = input.LA(1);

                         
                        int index22_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_74>='\u0000' && LA22_74<='\t')||(LA22_74>='\u000B' && LA22_74<='\f')||(LA22_74>='\u000E' && LA22_74<='!')||(LA22_74>='$' && LA22_74<='\'')||(LA22_74>='*' && LA22_74<='+')||(LA22_74>='-' && LA22_74<='[')||(LA22_74>=']' && LA22_74<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 74;}

                        else if ( (LA22_74=='\n'||LA22_74=='\r') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 26;}

                        else if ( ((LA22_74>='\"' && LA22_74<='#')||LA22_74=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA22_74>='(' && LA22_74<=')')||LA22_74==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 75;}

                        else s = 109;

                         
                        input.seek(index22_74);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_5>='\u0000' && LA22_5<='\b')||(LA22_5>='\n' && LA22_5<='\u001F')||(LA22_5>='!' && LA22_5<='\"')||LA22_5=='$'||(LA22_5>='&' && LA22_5<=',')||(LA22_5>='.' && LA22_5<='?')||(LA22_5>='A' && LA22_5<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else if ( (LA22_5==' ') && ((( !isHead() )||( isHead() )))) {s = 5;}

                        else if ( (LA22_5=='-') && (( isHead() ))) {s = 31;}

                        else if ( (LA22_5=='\t') && ((( !isHead() )||( isHead() )))) {s = 7;}

                        else if ( (LA22_5=='@') && (( isHead() ))) {s = 32;}

                        else s = 30;

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA22_18 = input.LA(1);

                         
                        int index22_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_18>='\u0000' && LA22_18<='\b')||(LA22_18>='\u000B' && LA22_18<='\f')||(LA22_18>='\u000E' && LA22_18<='\u001F')||LA22_18=='!'||(LA22_18>='$' && LA22_18<='[')||(LA22_18>=']' && LA22_18<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 37;}

                        else if ( (LA22_18=='#') && (((( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 38;}

                        else if ( (LA22_18=='\t'||LA22_18==' '||LA22_18=='\"'||LA22_18=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_18=='\n'||LA22_18=='\r') && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 40;}

                        else s = 49;

                         
                        input.seek(index22_18);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA22_111 = input.LA(1);

                         
                        int index22_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_111=='\"') ) {s = 97;}

                        else if ( ((LA22_111>='\u0000' && LA22_111<='\t')||(LA22_111>='\u000B' && LA22_111<='\f')||(LA22_111>='\u000E' && LA22_111<='!')||(LA22_111>='#' && LA22_111<='[')||(LA22_111>=']' && LA22_111<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_111=='\\') ) {s = 99;}

                        else if ( (LA22_111=='\n'||LA22_111=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_111);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA22_97 = input.LA(1);

                         
                        int index22_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_97>='\u0000' && LA22_97<='\t')||(LA22_97>='\u000B' && LA22_97<='\f')||(LA22_97>='\u000E' && LA22_97<='\uFFFF')) && (( isHead() ))) {s = 22;}

                        else s = 96;

                         
                        input.seek(index22_97);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA22_44 = input.LA(1);

                         
                        int index22_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_44>='\u0000' && LA22_44<='\t')||(LA22_44>='\u000B' && LA22_44<='\f')||(LA22_44>='\u000E' && LA22_44<='!')||(LA22_44>='$' && LA22_44<='\'')||LA22_44=='+'||(LA22_44>='-' && LA22_44<='9')||(LA22_44>=';' && LA22_44<='=')||(LA22_44>='?' && LA22_44<='Z')||(LA22_44>='^' && LA22_44<='z')||(LA22_44>='~' && LA22_44<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 44;}

                        else if ( ((LA22_44>='(' && LA22_44<=')')||LA22_44==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 45;}

                        else if ( (LA22_44=='*'||LA22_44==':'||LA22_44=='>'||LA22_44=='['||LA22_44==']'||(LA22_44>='{' && LA22_44<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 46;}

                        else if ( ((LA22_44>='\"' && LA22_44<='#')||LA22_44=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_44=='\n'||LA22_44=='\r') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 25;}

                        else s = 80;

                         
                        input.seek(index22_44);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA22_56 = input.LA(1);

                         
                        int index22_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_56>='\u0000' && LA22_56<='\t')||(LA22_56>='\u000B' && LA22_56<='\f')||(LA22_56>='\u000E' && LA22_56<='!')||(LA22_56>='$' && LA22_56<='\'')||LA22_56=='+'||(LA22_56>='-' && LA22_56<='9')||(LA22_56>=';' && LA22_56<='=')||(LA22_56>='?' && LA22_56<='Z')||(LA22_56>='^' && LA22_56<='z')||(LA22_56>='~' && LA22_56<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isHead() )||( isKey() )))) {s = 56;}

                        else if ( ((LA22_56>='(' && LA22_56<=')')||LA22_56==',') && ((( isOutValue() )||( isHead() )))) {s = 58;}

                        else if ( (LA22_56=='*'||LA22_56==':'||LA22_56=='>'||LA22_56=='['||LA22_56==']'||(LA22_56>='{' && LA22_56<='}')) && ((( isInValue() )||( isOutValue() )||( isHead() )))) {s = 59;}

                        else if ( ((LA22_56>='\"' && LA22_56<='#')||LA22_56=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_56=='\n'||LA22_56=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 57;}

                        else s = 100;

                         
                        input.seek(index22_56);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA22_43 = input.LA(1);

                         
                        int index22_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (!((((( isOutValue() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))))) ) {s = 79;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index22_43);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA22_95 = input.LA(1);

                         
                        int index22_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_95>='0' && LA22_95<='9')||(LA22_95>='A' && LA22_95<='F')||(LA22_95>='a' && LA22_95<='f')) ) {s = 110;}

                        else s = 22;

                         
                        input.seek(index22_95);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA22_101 = input.LA(1);

                         
                        int index22_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (( isOutValue() )) ) {s = 104;}

                         
                        input.seek(index22_101);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA22_81 = input.LA(1);

                         
                        int index22_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( ((( isOutValue() )&&( isValue() ))) ) {s = 104;}

                         
                        input.seek(index22_81);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA22_94 = input.LA(1);

                         
                        int index22_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_94=='\"') ) {s = 52;}

                        else if ( (LA22_94=='#') ) {s = 53;}

                        else if ( (LA22_94=='\\') ) {s = 51;}

                        else if ( ((LA22_94>='\u0000' && LA22_94<='\t')||(LA22_94>='\u000B' && LA22_94<='\f')||(LA22_94>='\u000E' && LA22_94<='!')||(LA22_94>='$' && LA22_94<='[')||(LA22_94>=']' && LA22_94<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_94=='\n'||LA22_94=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_94);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA22_53 = input.LA(1);

                         
                        int index22_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_53=='\"') ) {s = 97;}

                        else if ( ((LA22_53>='\u0000' && LA22_53<='\t')||(LA22_53>='\u000B' && LA22_53<='\f')||(LA22_53>='\u000E' && LA22_53<='!')||(LA22_53>='#' && LA22_53<='[')||(LA22_53>=']' && LA22_53<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_53=='\\') ) {s = 99;}

                        else if ( (LA22_53=='\n'||LA22_53=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_53);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA22_126 = input.LA(1);

                         
                        int index22_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_126=='\"') ) {s = 97;}

                        else if ( ((LA22_126>='\u0000' && LA22_126<='\t')||(LA22_126>='\u000B' && LA22_126<='\f')||(LA22_126>='\u000E' && LA22_126<='!')||(LA22_126>='#' && LA22_126<='[')||(LA22_126>=']' && LA22_126<='\uFFFF')) ) {s = 98;}

                        else if ( (LA22_126=='\\') ) {s = 99;}

                        else if ( (LA22_126=='\n'||LA22_126=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_126);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA22_49 = input.LA(1);

                         
                        int index22_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 86;}

                         
                        input.seek(index22_49);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA22_37 = input.LA(1);

                         
                        int index22_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_37>='\u0000' && LA22_37<='\t')||(LA22_37>='\u000B' && LA22_37<='\f')||(LA22_37>='\u000E' && LA22_37<='!')||(LA22_37>='$' && LA22_37<='\'')||LA22_37=='+'||(LA22_37>='-' && LA22_37<='9')||(LA22_37>=';' && LA22_37<='=')||(LA22_37>='?' && LA22_37<='Z')||(LA22_37>='^' && LA22_37<='z')||(LA22_37>='~' && LA22_37<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 44;}

                        else if ( (LA22_37=='*'||LA22_37==':'||LA22_37=='>'||LA22_37=='['||LA22_37==']'||(LA22_37>='{' && LA22_37<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 46;}

                        else if ( ((LA22_37>='(' && LA22_37<=')')||LA22_37==',') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 45;}

                        else if ( ((LA22_37>='\"' && LA22_37<='#')||LA22_37=='\\') && (( isHead() ))) {s = 22;}

                        else if ( (LA22_37=='\n'||LA22_37=='\r') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 25;}

                        else s = 71;

                         
                        input.seek(index22_37);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA22_34 = input.LA(1);

                         
                        int index22_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 68;}

                         
                        input.seek(index22_34);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA22_30 = input.LA(1);

                         
                        int index22_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 8;}

                        else if ( (( !isHead() )) ) {s = 66;}

                         
                        input.seek(index22_30);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA22_60 = input.LA(1);

                         
                        int index22_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (( isValue() )) ) {s = 84;}

                         
                        input.seek(index22_60);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA22_20 = input.LA(1);

                         
                        int index22_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_20>='\u0000' && LA22_20<='\t')||(LA22_20>='\u000B' && LA22_20<='\f')||(LA22_20>='\u000E' && LA22_20<='!')||(LA22_20>='$' && LA22_20<='\'')||LA22_20=='+'||(LA22_20>='-' && LA22_20<='9')||(LA22_20>=';' && LA22_20<='=')||(LA22_20>='?' && LA22_20<='Z')||(LA22_20>='^' && LA22_20<='z')||(LA22_20>='~' && LA22_20<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isHead() )||( isKey() )))) {s = 56;}

                        else if ( (LA22_20=='\n'||LA22_20=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 57;}

                        else if ( ((LA22_20>='\"' && LA22_20<='#')||LA22_20=='\\') && (( isHead() ))) {s = 22;}

                        else if ( ((LA22_20>='(' && LA22_20<=')')||LA22_20==',') && ((( isOutValue() )||( isHead() )))) {s = 58;}

                        else if ( (LA22_20=='*'||LA22_20==':'||LA22_20=='>'||LA22_20=='['||LA22_20==']'||(LA22_20>='{' && LA22_20<='}')) && ((( isInValue() )||( isOutValue() )||( isHead() )))) {s = 59;}

                        else s = 55;

                         
                        input.seek(index22_20);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA22_48 = input.LA(1);

                         
                        int index22_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (true) ) {s = 85;}

                         
                        input.seek(index22_48);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA22_19 = input.LA(1);

                         
                        int index22_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA22_19>='\u0000' && LA22_19<='\t')||(LA22_19>='\u000B' && LA22_19<='\f')||(LA22_19>='\u000E' && LA22_19<='!')||(LA22_19>='$' && LA22_19<='[')||(LA22_19>=']' && LA22_19<='\uFFFF')) ) {s = 50;}

                        else if ( (LA22_19=='\\') ) {s = 51;}

                        else if ( (LA22_19=='\"') ) {s = 52;}

                        else if ( (LA22_19=='#') ) {s = 53;}

                        else if ( (LA22_19=='\n'||LA22_19=='\r') ) {s = 54;}

                        else s = 22;

                         
                        input.seek(index22_19);
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
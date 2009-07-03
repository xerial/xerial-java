// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkLine.g 2009-07-03 13:56:29

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

public class SilkLineLexer extends Lexer {
    public static final int Key=14;
    public static final int PlainUnsafeChar=44;
    public static final int PlainSafeKey=45;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=30;
    public static final int Digit=33;
    public static final int NodeIndent=18;
    public static final int HexDigit=35;
    public static final int PlainOneLine=50;
    public static final int Plus=29;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int FlowIndicator=42;
    public static final int Separation=52;
    public static final int Letter=34;
    public static final int PlainSafeIn=46;
    public static final int Comma=23;
    public static final int TabSeq=26;
    public static final int NonSpaceChar=48;
    public static final int EscapeSequence=37;
    public static final int PlainFirst=49;
    public static final int WhiteSpace=15;
    public static final int PlainSafeOut=47;
    public static final int JSON=51;
    public static final int Question=32;
    public static final int LineComment=17;
    public static final int Colon=24;
    public static final int At=28;
    public static final int KeyValuePair=13;
    public static final int Star=27;
    public static final int Seq=25;
    public static final int FunctionIndent=19;
    public static final int RParen=22;
    public static final int Indicator=43;
    public static final int UnicodeChar=36;
    public static final int Silk=4;
    public static final int BlankLine=20;
    public static final int StringChar=38;
    public static final int Name=7;
    public static final int Function=11;
    public static final int LParen=21;
    public static final int String=40;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=41;
    public static final int EOF=-1;
    public static final int StringChar_s=39;
    public static final int Value=8;
    public static final int RBracket=31;


    private static Logger _logger = Logger.getLogger(SilkLineLexer.class);

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

    public SilkLineLexer() {;} 
    public SilkLineLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkLineLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "SilkLine.g"; }

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            // SilkLine.g:155:2: ( ( ' ' | '\\t' ) )
            // SilkLine.g:155:4: ( ' ' | '\\t' )
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
            // SilkLine.g:159:12: ( '#' (~ ( LineBreakChar ) )* )
            // SilkLine.g:159:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // SilkLine.g:159:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkLine.g:159:18: ~ ( LineBreakChar )
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

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // SilkLine.g:163:23: ( '\\n' | '\\r' )
            // SilkLine.g:
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

    // $ANTLR start "NodeIndent"
    public final void mNodeIndent() throws RecognitionException {
        try {
            int _type = NodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:175:11: ({...}? => ( ' ' )* '-' )
            // SilkLine.g:175:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // SilkLine.g:175:30: ( ' ' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkLine.g:175:31: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop2;
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
            // SilkLine.g:176:15: ({...}? => ( ' ' )* '@' )
            // SilkLine.g:176:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // SilkLine.g:176:34: ( ' ' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SilkLine.g:176:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop3;
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
            // SilkLine.g:177:10: ({...}? => ( WhiteSpace )* )
            // SilkLine.g:177:12: {...}? => ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // SilkLine.g:177:29: ( WhiteSpace )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SilkLine.g:177:29: WhiteSpace
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
    // $ANTLR end "BlankLine"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:183:7: ( '(' )
            // SilkLine.g:183:9: '('
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
            // SilkLine.g:184:7: ( ')' )
            // SilkLine.g:184:9: ')'
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
            // SilkLine.g:185:6: ( ',' )
            // SilkLine.g:185:9: ','
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
            // SilkLine.g:186:6: ( ':' )
            // SilkLine.g:186:8: ':'
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
            // SilkLine.g:189:4: ( '>' )
            // SilkLine.g:189:7: '>'
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
            // SilkLine.g:190:7: ( '|' )
            // SilkLine.g:190:9: '|'
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
            // SilkLine.g:191:5: ( '*' )
            // SilkLine.g:191:8: '*'
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
            // SilkLine.g:192:3: ( '@' )
            // SilkLine.g:192:6: '@'
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
            // SilkLine.g:193:5: ( '+' )
            // SilkLine.g:193:7: '+'
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
            // SilkLine.g:194:9: ( '[' )
            // SilkLine.g:194:11: '['
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
            // SilkLine.g:195:9: ( ']' )
            // SilkLine.g:195:11: ']'
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
            // SilkLine.g:196:9: ( '?' )
            // SilkLine.g:196:11: '?'
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
            // SilkLine.g:198:15: ( '0' .. '9' )
            // SilkLine.g:198:17: '0' .. '9'
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
            // SilkLine.g:199:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // SilkLine.g:
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
            // SilkLine.g:200:18: ( Digit | Letter )
            // SilkLine.g:
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
            // SilkLine.g:201:21: (~ ( '\"' | '\\\\' ) )
            // SilkLine.g:201:23: ~ ( '\"' | '\\\\' )
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
            // SilkLine.g:203:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // SilkLine.g:203:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // SilkLine.g:203:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt5=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt5=1;
                }
                break;
            case '\\':
                {
                alt5=2;
                }
                break;
            case '/':
                {
                alt5=3;
                }
                break;
            case 'b':
                {
                alt5=4;
                }
                break;
            case 'f':
                {
                alt5=5;
                }
                break;
            case 'n':
                {
                alt5=6;
                }
                break;
            case 'r':
                {
                alt5=7;
                }
                break;
            case 't':
                {
                alt5=8;
                }
                break;
            case 'u':
                {
                alt5=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // SilkLine.g:203:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:203:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // SilkLine.g:203:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // SilkLine.g:203:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // SilkLine.g:203:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // SilkLine.g:203:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // SilkLine.g:203:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // SilkLine.g:203:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // SilkLine.g:203:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // SilkLine.g:205:21: ( UnicodeChar | EscapeSequence )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\\') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // SilkLine.g:205:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:205:38: EscapeSequence
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
            // SilkLine.g:206:22: ( ( StringChar )* )
            // SilkLine.g:206:24: ( StringChar )*
            {
            // SilkLine.g:206:24: ( StringChar )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // SilkLine.g:206:24: StringChar
            	    {
            	    mStringChar(); 

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
    // $ANTLR end "StringChar_s"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token s=null;

            // SilkLine.g:207:7: ( '\"' s= StringChar_s '\"' )
            // SilkLine.g:207:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart408 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart408, getCharIndex()-1);
            match('\"'); 
             setText((s!=null?s.getText():null));  transit(Symbol.LeaveValue); 

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
            // SilkLine.g:210:24: ( '(' | ')' )
            // SilkLine.g:
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
            // SilkLine.g:211:23: ( '[' | ']' | '{' | '}' )
            // SilkLine.g:
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
            // SilkLine.g:212:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '#' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' )
            // SilkLine.g:
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
            // SilkLine.g:215:25: ( '\"' | '\\\\' | '#' )
            // SilkLine.g:
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
            // SilkLine.g:217:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' ) )
            // SilkLine.g:217:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' )
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
            // SilkLine.g:218:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // SilkLine.g:218:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
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
            // SilkLine.g:219:22: (~ ( PlainUnsafeChar ) )
            // SilkLine.g:219:24: ~ ( PlainUnsafeChar )
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
            // SilkLine.g:221:22: (~ ( '\"' | '\\\\' | WhiteSpace ) )
            // SilkLine.g:221:24: ~ ( '\"' | '\\\\' | WhiteSpace )
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
            // SilkLine.g:223:2: (~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\n' && LA9_0<='\u001F')||LA9_0=='!'||LA9_0=='$'||LA9_0=='&'||(LA9_0>='.' && LA9_0<='9')||(LA9_0>=';' && LA9_0<='=')||(LA9_0>='A' && LA9_0<='Z')||(LA9_0>='^' && LA9_0<='z')||(LA9_0>='~' && LA9_0<='\uFFFF')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='+'||LA9_0=='-'||LA9_0==':'||LA9_0=='?') && (( isValue() ))) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // SilkLine.g:223:5: ~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator )
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
                    // SilkLine.g:224:4: {...}? => ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // SilkLine.g:224:22: ( '-' | '+' | ( ':' | '?' ) NonSpaceChar )
                    int alt8=3;
                    switch ( input.LA(1) ) {
                    case '-':
                        {
                        alt8=1;
                        }
                        break;
                    case '+':
                        {
                        alt8=2;
                        }
                        break;
                    case ':':
                    case '?':
                        {
                        alt8=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }

                    switch (alt8) {
                        case 1 :
                            // SilkLine.g:224:23: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // SilkLine.g:224:29: '+'
                            {
                            match('+'); 

                            }
                            break;
                        case 3 :
                            // SilkLine.g:224:35: ( ':' | '?' ) NonSpaceChar
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
            // SilkLine.g:228:2: ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => PlainFirst ( PlainSafeOut )* )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\n' && LA13_0<='\u001F')||LA13_0=='!'||LA13_0=='$'||LA13_0=='&'||(LA13_0>='.' && LA13_0<='9')||(LA13_0>=';' && LA13_0<='=')||(LA13_0>='A' && LA13_0<='Z')||(LA13_0>='^' && LA13_0<='z')||(LA13_0>='~' && LA13_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {
                int LA13_1 = input.LA(2);

                if ( (( isKey() )) ) {
                    alt13=1;
                }
                else if ( (( isInValue() )) ) {
                    alt13=2;
                }
                else if ( (( isOutValue() )) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0=='-') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                int LA13_2 = input.LA(2);

                if ( ((( isKey() )&&( isValue() ))) ) {
                    alt13=1;
                }
                else if ( ((( isInValue() )&&( isValue() ))) ) {
                    alt13=2;
                }
                else if ( ((( isOutValue() )&&( isValue() ))) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0=='+') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                int LA13_3 = input.LA(2);

                if ( ((( isKey() )&&( isValue() ))) ) {
                    alt13=1;
                }
                else if ( ((( isInValue() )&&( isValue() ))) ) {
                    alt13=2;
                }
                else if ( ((( isOutValue() )&&( isValue() ))) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==':'||LA13_0=='?') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                int LA13_4 = input.LA(2);

                if ( ((LA13_4>='\u0000' && LA13_4<='\b')||(LA13_4>='\n' && LA13_4<='\u001F')||LA13_4=='!'||(LA13_4>='#' && LA13_4<='[')||(LA13_4>=']' && LA13_4<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {
                    int LA13_8 = input.LA(3);

                    if ( ((( isKey() )&&( isValue() ))) ) {
                        alt13=1;
                    }
                    else if ( ((( isInValue() )&&( isValue() ))) ) {
                        alt13=2;
                    }
                    else if ( ((( isOutValue() )&&( isValue() ))) ) {
                        alt13=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 8, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 4, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // SilkLine.g:228:4: {...}? => PlainFirst ( PlainSafeKey )*
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isKey() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:228:32: ( PlainSafeKey )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='\u0000' && LA10_0<='!')||(LA10_0>='$' && LA10_0<='\'')||LA10_0=='+'||(LA10_0>='-' && LA10_0<='9')||(LA10_0>=';' && LA10_0<='=')||(LA10_0>='?' && LA10_0<='Z')||(LA10_0>='^' && LA10_0<='z')||(LA10_0>='~' && LA10_0<='\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // SilkLine.g:228:32: PlainSafeKey
                    	    {
                    	    mPlainSafeKey(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:229:5: {...}? => PlainFirst ( PlainSafeIn )*
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isInValue() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:229:37: ( PlainSafeIn )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='$' && LA11_0<='\'')||(LA11_0>='*' && LA11_0<='+')||(LA11_0>='-' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // SilkLine.g:229:37: PlainSafeIn
                    	    {
                    	    mPlainSafeIn(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 3 :
                    // SilkLine.g:230:5: {...}? => PlainFirst ( PlainSafeOut )*
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isOutValue() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:230:38: ( PlainSafeOut )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='$' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // SilkLine.g:230:38: PlainSafeOut
                    	    {
                    	    mPlainSafeOut(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
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
            // SilkLine.g:235:2: ({...}? => '{' | {...}? => '[' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='{') && (( isValue() ))) {
                alt14=1;
            }
            else if ( (LA14_0=='[') && (( isValue() ))) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // SilkLine.g:235:4: {...}? => '{'
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
                    // SilkLine.g:246:4: {...}? => '['
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
            // SilkLine.g:259:11: ({...}? => ( WhiteSpace )+ )
            // SilkLine.g:259:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // SilkLine.g:259:31: ( WhiteSpace )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\t'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // SilkLine.g:259:31: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
        // SilkLine.g:1:8: ( LineComment | NodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation )
        int alt16=20;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // SilkLine.g:1:10: LineComment
                {
                mLineComment(); 

                }
                break;
            case 2 :
                // SilkLine.g:1:22: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 3 :
                // SilkLine.g:1:33: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 4 :
                // SilkLine.g:1:48: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 5 :
                // SilkLine.g:1:58: LParen
                {
                mLParen(); 

                }
                break;
            case 6 :
                // SilkLine.g:1:65: RParen
                {
                mRParen(); 

                }
                break;
            case 7 :
                // SilkLine.g:1:72: Comma
                {
                mComma(); 

                }
                break;
            case 8 :
                // SilkLine.g:1:78: Colon
                {
                mColon(); 

                }
                break;
            case 9 :
                // SilkLine.g:1:84: Seq
                {
                mSeq(); 

                }
                break;
            case 10 :
                // SilkLine.g:1:88: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 11 :
                // SilkLine.g:1:95: Star
                {
                mStar(); 

                }
                break;
            case 12 :
                // SilkLine.g:1:100: At
                {
                mAt(); 

                }
                break;
            case 13 :
                // SilkLine.g:1:103: Plus
                {
                mPlus(); 

                }
                break;
            case 14 :
                // SilkLine.g:1:108: LBracket
                {
                mLBracket(); 

                }
                break;
            case 15 :
                // SilkLine.g:1:117: RBracket
                {
                mRBracket(); 

                }
                break;
            case 16 :
                // SilkLine.g:1:126: Question
                {
                mQuestion(); 

                }
                break;
            case 17 :
                // SilkLine.g:1:135: String
                {
                mString(); 

                }
                break;
            case 18 :
                // SilkLine.g:1:142: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 19 :
                // SilkLine.g:1:155: JSON
                {
                mJSON(); 

                }
                break;
            case 20 :
                // SilkLine.g:1:160: Separation
                {
                mSeparation(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\6\1\uffff\1\25\1\30\1\34\1\25\4\uffff\1\36\3\uffff\1\37\1\40"+
        "\1\uffff\1\41\24\uffff";
    static final String DFA16_eofS =
        "\46\uffff";
    static final String DFA16_minS =
        "\1\0\1\uffff\1\11\2\0\1\11\4\uffff\1\0\3\uffff\2\0\1\uffff\1\0"+
        "\3\uffff\1\0\2\uffff\1\0\3\uffff\1\0\2\uffff\2\0\5\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\uffff\1\100\1\uffff\1\0\1\40\4\uffff\1\uffff\3\uffff"+
        "\1\uffff\1\0\1\uffff\1\uffff\3\uffff\1\0\2\uffff\1\0\3\uffff\1\0"+
        "\2\uffff\2\0\5\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\4\uffff\1\4\1\5\1\6\1\7\1\uffff\1\11\1\12\1\13\2\uffff"+
        "\1\17\1\uffff\1\21\1\22\1\23\1\uffff\1\2\1\3\1\uffff\3\22\1\uffff"+
        "\1\22\1\10\2\uffff\1\20\1\24\1\14\1\15\1\16";
    static final String DFA16_specialS =
        "\1\12\1\uffff\1\1\1\0\1\uffff\1\13\4\uffff\1\11\3\uffff\1\2\2\uffff"+
        "\1\4\3\uffff\1\10\2\uffff\1\5\3\uffff\1\3\2\uffff\1\7\1\6\5\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\23\1\5\26\23\1\2\1\23\1\22\1\1\1\23\1\uffff\1\23\1\uffff"+
            "\1\7\1\10\1\15\1\16\1\11\1\3\14\23\1\12\3\23\1\13\1\21\1\4\32"+
            "\23\1\17\1\uffff\1\20\35\23\1\24\1\14\1\uffff\uff82\23",
            "",
            "\1\5\26\uffff\1\2\14\uffff\1\26\22\uffff\1\27",
            "\42\31\2\uffff\4\31\2\32\1\33\1\31\1\32\15\31\1\33\3\31\1"+
            "\33\34\31\1\33\1\uffff\1\33\35\31\3\33\uff82\31",
            "\1\uffff",
            "\1\5\26\uffff\1\5",
            "",
            "",
            "",
            "",
            "\11\35\1\uffff\26\35\1\uffff\1\35\1\uffff\71\35\1\uffff\uffa3"+
            "\35",
            "",
            "",
            "",
            "\42\31\2\uffff\4\31\2\32\1\33\1\31\1\32\15\31\1\33\3\31\1"+
            "\33\34\31\1\33\1\uffff\1\33\35\31\3\33\uff82\31",
            "\1\uffff",
            "",
            "\11\35\1\uffff\26\35\1\uffff\1\35\1\uffff\71\35\1\uffff\uffa3"+
            "\35",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | NodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_3>='\u0000' && LA16_3<='!')||(LA16_3>='$' && LA16_3<='\'')||LA16_3=='+'||(LA16_3>='-' && LA16_3<='9')||(LA16_3>=';' && LA16_3<='=')||(LA16_3>='?' && LA16_3<='Z')||(LA16_3>='^' && LA16_3<='z')||(LA16_3>='~' && LA16_3<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 25;}

                        else if ( ((LA16_3>='(' && LA16_3<=')')||LA16_3==',') && ((( isOutValue() )&&( isValue() )))) {s = 26;}

                        else if ( (LA16_3=='*'||LA16_3==':'||LA16_3=='>'||LA16_3=='['||LA16_3==']'||(LA16_3>='{' && LA16_3<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 27;}

                        else s = 24;

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_2==' ') && ((( !isHead() )||( isHead() )))) {s = 2;}

                        else if ( (LA16_2=='-') && (( isHead() ))) {s = 22;}

                        else if ( (LA16_2=='\t') && ((( !isHead() )||( isHead() )))) {s = 5;}

                        else if ( (LA16_2=='@') && (( isHead() ))) {s = 23;}

                        else s = 21;

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_14 = input.LA(1);

                         
                        int index16_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_14>='\u0000' && LA16_14<='!')||(LA16_14>='$' && LA16_14<='\'')||LA16_14=='+'||(LA16_14>='-' && LA16_14<='9')||(LA16_14>=';' && LA16_14<='=')||(LA16_14>='?' && LA16_14<='Z')||(LA16_14>='^' && LA16_14<='z')||(LA16_14>='~' && LA16_14<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 25;}

                        else if ( (LA16_14=='*'||LA16_14==':'||LA16_14=='>'||LA16_14=='['||LA16_14==']'||(LA16_14>='{' && LA16_14<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 27;}

                        else if ( ((LA16_14>='(' && LA16_14<=')')||LA16_14==',') && ((( isOutValue() )&&( isValue() )))) {s = 26;}

                        else s = 31;

                         
                        input.seek(index16_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_28 = input.LA(1);

                         
                        int index16_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 23;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index16_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_17 = input.LA(1);

                         
                        int index16_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_17>='\u0000' && LA16_17<='\b')||(LA16_17>='\n' && LA16_17<='\u001F')||LA16_17=='!'||(LA16_17>='#' && LA16_17<='[')||(LA16_17>=']' && LA16_17<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 29;}

                        else s = 33;

                         
                        input.seek(index16_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_24 = input.LA(1);

                         
                        int index16_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 22;}

                        else if ( (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 29;}

                         
                        input.seek(index16_24);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_32 = input.LA(1);

                         
                        int index16_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 37;}

                        else if ( (( isValue() )) ) {s = 20;}

                         
                        input.seek(index16_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA16_31 = input.LA(1);

                         
                        int index16_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))))) ) {s = 36;}

                        else if ( (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() )))) ) {s = 29;}

                         
                        input.seek(index16_31);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA16_21 = input.LA(1);

                         
                        int index16_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 6;}

                        else if ( (( !isHead() )) ) {s = 34;}

                         
                        input.seek(index16_21);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA16_10 = input.LA(1);

                         
                        int index16_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_10>='\u0000' && LA16_10<='\b')||(LA16_10>='\n' && LA16_10<='\u001F')||LA16_10=='!'||(LA16_10>='#' && LA16_10<='[')||(LA16_10>=']' && LA16_10<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 29;}

                        else s = 30;

                         
                        input.seek(index16_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0=='#') ) {s = 1;}

                        else if ( (LA16_0==' ') && ((( !isHead() )||( isHead() )))) {s = 2;}

                        else if ( (LA16_0=='-') && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA16_0=='@') ) {s = 4;}

                        else if ( (LA16_0=='\t') && ((( !isHead() )||( isHead() )))) {s = 5;}

                        else if ( (LA16_0=='(') ) {s = 7;}

                        else if ( (LA16_0==')') ) {s = 8;}

                        else if ( (LA16_0==',') ) {s = 9;}

                        else if ( (LA16_0==':') ) {s = 10;}

                        else if ( (LA16_0=='>') ) {s = 11;}

                        else if ( (LA16_0=='|') ) {s = 12;}

                        else if ( (LA16_0=='*') ) {s = 13;}

                        else if ( (LA16_0=='+') ) {s = 14;}

                        else if ( (LA16_0=='[') ) {s = 15;}

                        else if ( (LA16_0==']') ) {s = 16;}

                        else if ( (LA16_0=='?') ) {s = 17;}

                        else if ( (LA16_0=='\"') ) {s = 18;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\n' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||(LA16_0>='.' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='=')||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 19;}

                        else if ( (LA16_0=='{') && (( isValue() ))) {s = 20;}

                        else s = 6;

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_5=='\t'||LA16_5==' ') && ((( !isHead() )||( isHead() )))) {s = 5;}

                        else s = 21;

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
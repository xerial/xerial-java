// $ANTLR 3.2 Sep 23, 2009 14:05:07 SilkLine.g 2011-03-25 16:16:13

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
    public static final int DataType=10;
    public static final int LineComment=17;
    public static final int RBracket=33;
    public static final int NodeIndent=19;
    public static final int EOF=-1;
    public static final int HexDigit=37;
    public static final int PlainSafeIn=48;
    public static final int Occurrence=9;
    public static final int PullUpNodeIndent=20;
    public static final int Silk=4;
    public static final int Value=8;
    public static final int Indicator=45;
    public static final int PlainOneLine=53;
    public static final int NonSpaceChar=50;
    public static final int Spaces=54;
    public static final int KeyValuePair=13;
    public static final int Argument=12;
    public static final int WhiteSpace=15;
    public static final int String=42;
    public static final int BlockIndent=18;
    public static final int LBracket=32;
    public static final int RParen=24;
    public static final int PlainSafeOut=49;
    public static final int At=30;
    public static final int LParen=23;
    public static final int PlainSafeKey=47;
    public static final int PlainUnsafeChar=46;
    public static final int TabSeq=28;
    public static final int BlankLine=22;
    public static final int StringChar_s=41;
    public static final int Colon=26;
    public static final int UnicodeChar=38;
    public static final int Question=34;
    public static final int Digit=35;
    public static final int FunctionIndent=21;
    public static final int PlainFirst=51;
    public static final int Seq=27;
    public static final int Plus=31;
    public static final int JSON=52;
    public static final int Function=11;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=43;
    public static final int Name=7;
    public static final int StringChar=40;
    public static final int FlowIndicator=44;
    public static final int Star=29;
    public static final int SilkLine=6;
    public static final int Comma=25;
    public static final int EscapeSequence=39;
    public static final int Letter=36;
    public static final int SilkNode=5;


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
            // SilkLine.g:135:2: ( ( ' ' | '\\t' ) )
            // SilkLine.g:135:4: ( ' ' | '\\t' )
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
            // SilkLine.g:139:12: ( '#' (~ ( LineBreakChar ) )* )
            // SilkLine.g:139:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // SilkLine.g:139:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkLine.g:139:18: ~ ( LineBreakChar )
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
            // SilkLine.g:142:23: ( '\\n' | '\\r' )
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

    // $ANTLR start "BlockIndent"
    public final void mBlockIndent() throws RecognitionException {
        try {
            int _type = BlockIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:144:12: ({...}? => ( ' ' )* '--' )
            // SilkLine.g:144:14: {...}? => ( ' ' )* '--'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlockIndent", " isHead() ");
            }
            // SilkLine.g:144:31: ( ' ' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkLine.g:144:32: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("--"); 

             transit(Symbol.NodeStart); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BlockIndent"

    // $ANTLR start "NodeIndent"
    public final void mNodeIndent() throws RecognitionException {
        try {
            int _type = NodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:145:11: ({...}? => ( ' ' )* '-' )
            // SilkLine.g:145:13: {...}? => ( ' ' )* '-'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "NodeIndent", " isHead() ");
            }
            // SilkLine.g:145:30: ( ' ' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SilkLine.g:145:31: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop3;
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

    // $ANTLR start "PullUpNodeIndent"
    public final void mPullUpNodeIndent() throws RecognitionException {
        try {
            int _type = PullUpNodeIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:146:17: ({...}? => ( ' ' )* '->' )
            // SilkLine.g:146:19: {...}? => ( ' ' )* '->'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "PullUpNodeIndent", " isHead() ");
            }
            // SilkLine.g:146:36: ( ' ' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SilkLine.g:146:37: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("->"); 

             transit(Symbol.NodeStart); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PullUpNodeIndent"

    // $ANTLR start "FunctionIndent"
    public final void mFunctionIndent() throws RecognitionException {
        try {
            int _type = FunctionIndent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:147:15: ({...}? => ( ' ' )* '@' )
            // SilkLine.g:147:17: {...}? => ( ' ' )* '@'
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "FunctionIndent", " isHead() ");
            }
            // SilkLine.g:147:34: ( ' ' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // SilkLine.g:147:35: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop5;
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
            // SilkLine.g:148:10: ({...}? => ( WhiteSpace )* )
            // SilkLine.g:148:12: {...}? => ( WhiteSpace )*
            {
            if ( !(( isHead() )) ) {
                throw new FailedPredicateException(input, "BlankLine", " isHead() ");
            }
            // SilkLine.g:148:29: ( WhiteSpace )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SilkLine.g:148:29: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // SilkLine.g:150:7: ( '(' )
            // SilkLine.g:150:9: '('
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
            // SilkLine.g:151:7: ( ')' )
            // SilkLine.g:151:9: ')'
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
            // SilkLine.g:152:6: ( ',' )
            // SilkLine.g:152:9: ','
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
            // SilkLine.g:153:6: ( ':' )
            // SilkLine.g:153:8: ':'
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
            // SilkLine.g:155:4: ( '>' )
            // SilkLine.g:155:7: '>'
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
            // SilkLine.g:156:7: ( '|' )
            // SilkLine.g:156:9: '|'
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
            // SilkLine.g:157:5: ( '*' )
            // SilkLine.g:157:8: '*'
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
            // SilkLine.g:158:3: ( '@' )
            // SilkLine.g:158:6: '@'
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
            // SilkLine.g:159:5: ( '+' )
            // SilkLine.g:159:7: '+'
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
            // SilkLine.g:160:9: ( '[' )
            // SilkLine.g:160:11: '['
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
            // SilkLine.g:161:9: ( ']' )
            // SilkLine.g:161:11: ']'
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
            // SilkLine.g:162:9: ( '?' )
            // SilkLine.g:162:11: '?'
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
            // SilkLine.g:164:15: ( '0' .. '9' )
            // SilkLine.g:164:17: '0' .. '9'
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
            // SilkLine.g:165:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // SilkLine.g:166:18: ( Digit | Letter )
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
            // SilkLine.g:167:21: (~ ( '\"' | '\\\\' ) )
            // SilkLine.g:167:23: ~ ( '\"' | '\\\\' )
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
            // SilkLine.g:169:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // SilkLine.g:169:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // SilkLine.g:169:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt7=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt7=1;
                }
                break;
            case '\\':
                {
                alt7=2;
                }
                break;
            case '/':
                {
                alt7=3;
                }
                break;
            case 'b':
                {
                alt7=4;
                }
                break;
            case 'f':
                {
                alt7=5;
                }
                break;
            case 'n':
                {
                alt7=6;
                }
                break;
            case 'r':
                {
                alt7=7;
                }
                break;
            case 't':
                {
                alt7=8;
                }
                break;
            case 'u':
                {
                alt7=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // SilkLine.g:169:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:169:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // SilkLine.g:169:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // SilkLine.g:169:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // SilkLine.g:169:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // SilkLine.g:169:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // SilkLine.g:169:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // SilkLine.g:169:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // SilkLine.g:169:60: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // SilkLine.g:171:21: ( UnicodeChar | EscapeSequence )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='\\') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // SilkLine.g:171:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:171:38: EscapeSequence
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
            // SilkLine.g:172:22: ( ( StringChar )* )
            // SilkLine.g:172:24: ( StringChar )*
            {
            // SilkLine.g:172:24: ( StringChar )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // SilkLine.g:172:24: StringChar
            	    {
            	    mStringChar(); 

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
    // $ANTLR end "StringChar_s"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken s=null;

            // SilkLine.g:173:7: ( '\"' s= StringChar_s '\"' )
            // SilkLine.g:173:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart429 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart429, getCharIndex()-1);
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
            // SilkLine.g:176:24: ( '(' | ')' )
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
            // SilkLine.g:177:23: ( '[' | ']' | '{' | '}' )
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
            // SilkLine.g:178:19: ( FlowIndicator | ScopeIndicator | ',' | ':' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '=' )
            // SilkLine.g:
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='*')||input.LA(1)==','||input.LA(1)==':'||(input.LA(1)>='=' && input.LA(1)<='>')||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
            // SilkLine.g:181:25: ( '\"' )
            // SilkLine.g:181:27: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "PlainUnsafeChar"

    // $ANTLR start "PlainSafeKey"
    public final void mPlainSafeKey() throws RecognitionException {
        try {
            // SilkLine.g:183:22: (~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' | '=' ) )
            // SilkLine.g:183:24: ~ ( PlainUnsafeChar | ScopeIndicator | FlowIndicator | ',' | ':' | '>' | '*' | '|' | '=' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\'')||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='<')||(input.LA(1)>='?' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // SilkLine.g:184:21: (~ ( PlainUnsafeChar | ScopeIndicator | ',' ) )
            // SilkLine.g:184:23: ~ ( PlainUnsafeChar | ScopeIndicator | ',' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='\uFFFF') ) {
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
            // SilkLine.g:185:22: (~ ( PlainUnsafeChar ) )
            // SilkLine.g:185:24: ~ ( PlainUnsafeChar )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
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
            // SilkLine.g:187:22: (~ ( '\"' | '\\\\' | WhiteSpace ) )
            // SilkLine.g:187:24: ~ ( '\"' | '\\\\' | WhiteSpace )
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
            // SilkLine.g:189:2: (~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | '=' | '+' | '*' | ( ':' | '?' ) NonSpaceChar ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\n' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='$')||LA11_0=='&'||(LA11_0>='.' && LA11_0<='9')||(LA11_0>=';' && LA11_0<='<')||(LA11_0>='A' && LA11_0<='Z')||(LA11_0>='^' && LA11_0<='z')||(LA11_0>='~' && LA11_0<='\uFFFF')) ) {
                alt11=1;
            }
            else if ( ((LA11_0>='*' && LA11_0<='+')||LA11_0=='-'||LA11_0==':'||LA11_0=='='||LA11_0=='?') && (( isValue() ))) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // SilkLine.g:189:5: ~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='$')||input.LA(1)=='&'||(input.LA(1)>='.' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='<')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // SilkLine.g:190:4: {...}? => ( '-' | '=' | '+' | '*' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // SilkLine.g:190:22: ( '-' | '=' | '+' | '*' | ( ':' | '?' ) NonSpaceChar )
                    int alt10=5;
                    switch ( input.LA(1) ) {
                    case '-':
                        {
                        alt10=1;
                        }
                        break;
                    case '=':
                        {
                        alt10=2;
                        }
                        break;
                    case '+':
                        {
                        alt10=3;
                        }
                        break;
                    case '*':
                        {
                        alt10=4;
                        }
                        break;
                    case ':':
                    case '?':
                        {
                        alt10=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }

                    switch (alt10) {
                        case 1 :
                            // SilkLine.g:190:23: '-'
                            {
                            match('-'); 

                            }
                            break;
                        case 2 :
                            // SilkLine.g:190:29: '='
                            {
                            match('='); 

                            }
                            break;
                        case 3 :
                            // SilkLine.g:190:35: '+'
                            {
                            match('+'); 

                            }
                            break;
                        case 4 :
                            // SilkLine.g:190:41: '*'
                            {
                            match('*'); 

                            }
                            break;
                        case 5 :
                            // SilkLine.g:190:47: ( ':' | '?' ) NonSpaceChar
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
            // SilkLine.g:194:2: ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => ( String | ~ ( '\"' | '@' | WhiteSpace ) ( PlainSafeOut )* | JSON ) )
            int alt16=3;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // SilkLine.g:194:4: {...}? => PlainFirst ( PlainSafeKey )*
                    {
                    if ( !(( isKey() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isKey() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:194:32: ( PlainSafeKey )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='\'')||LA12_0=='+'||(LA12_0>='-' && LA12_0<='9')||(LA12_0>=';' && LA12_0<='<')||(LA12_0>='?' && LA12_0<='Z')||LA12_0=='\\'||(LA12_0>='^' && LA12_0<='z')||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // SilkLine.g:194:32: PlainSafeKey
                    	    {
                    	    mPlainSafeKey(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 2 :
                    // SilkLine.g:195:5: {...}? => PlainFirst ( PlainSafeIn )*
                    {
                    if ( !(( isInValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isInValue() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:195:37: ( PlainSafeIn )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='\'')||(LA13_0>='*' && LA13_0<='+')||(LA13_0>='-' && LA13_0<='\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // SilkLine.g:195:37: PlainSafeIn
                    	    {
                    	    mPlainSafeIn(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                     transit(Symbol.LeaveValue); 

                    }
                    break;
                case 3 :
                    // SilkLine.g:196:5: {...}? => ( String | ~ ( '\"' | '@' | WhiteSpace ) ( PlainSafeOut )* | JSON )
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isOutValue() ");
                    }
                    // SilkLine.g:196:26: ( String | ~ ( '\"' | '@' | WhiteSpace ) ( PlainSafeOut )* | JSON )
                    int alt15=3;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='\"') ) {
                        alt15=1;
                    }
                    else if ( (LA15_0=='{') ) {
                        int LA15_2 = input.LA(2);

                        if ( (!((( isValue() )))) ) {
                            alt15=2;
                        }
                        else if ( (( isValue() )) ) {
                            alt15=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 2, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA15_0=='[') ) {
                        int LA15_3 = input.LA(2);

                        if ( (!((( isValue() )))) ) {
                            alt15=2;
                        }
                        else if ( (( isValue() )) ) {
                            alt15=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\n' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='?')||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='\\' && LA15_0<='z')||(LA15_0>='|' && LA15_0<='\uFFFF')) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // SilkLine.g:196:27: String
                            {
                            mString(); 

                            }
                            break;
                        case 2 :
                            // SilkLine.g:196:36: ~ ( '\"' | '@' | WhiteSpace ) ( PlainSafeOut )*
                            {
                            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\n' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // SilkLine.g:196:62: ( PlainSafeOut )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // SilkLine.g:196:62: PlainSafeOut
                            	    {
                            	    mPlainSafeOut(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;
                        case 3 :
                            // SilkLine.g:196:78: JSON
                            {
                            mJSON(); 

                            }
                            break;

                    }

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
            // SilkLine.g:201:2: ({...}? => '{' | {...}? => '[' )
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
                    // SilkLine.g:201:4: {...}? => '{'
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
                    // SilkLine.g:212:4: {...}? => '['
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

    // $ANTLR start "Spaces"
    public final void mSpaces() throws RecognitionException {
        try {
            int _type = Spaces;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:225:7: ({...}? => ( WhiteSpace )+ )
            // SilkLine.g:225:9: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Spaces", " !isHead() ");
            }
            // SilkLine.g:225:27: ( WhiteSpace )+
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
            	    // SilkLine.g:225:27: WhiteSpace
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
    // $ANTLR end "Spaces"

    public void mTokens() throws RecognitionException {
        // SilkLine.g:1:8: ( LineComment | BlockIndent | NodeIndent | PullUpNodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Spaces )
        int alt19=22;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // SilkLine.g:1:10: LineComment
                {
                mLineComment(); 

                }
                break;
            case 2 :
                // SilkLine.g:1:22: BlockIndent
                {
                mBlockIndent(); 

                }
                break;
            case 3 :
                // SilkLine.g:1:34: NodeIndent
                {
                mNodeIndent(); 

                }
                break;
            case 4 :
                // SilkLine.g:1:45: PullUpNodeIndent
                {
                mPullUpNodeIndent(); 

                }
                break;
            case 5 :
                // SilkLine.g:1:62: FunctionIndent
                {
                mFunctionIndent(); 

                }
                break;
            case 6 :
                // SilkLine.g:1:77: BlankLine
                {
                mBlankLine(); 

                }
                break;
            case 7 :
                // SilkLine.g:1:87: LParen
                {
                mLParen(); 

                }
                break;
            case 8 :
                // SilkLine.g:1:94: RParen
                {
                mRParen(); 

                }
                break;
            case 9 :
                // SilkLine.g:1:101: Comma
                {
                mComma(); 

                }
                break;
            case 10 :
                // SilkLine.g:1:107: Colon
                {
                mColon(); 

                }
                break;
            case 11 :
                // SilkLine.g:1:113: Seq
                {
                mSeq(); 

                }
                break;
            case 12 :
                // SilkLine.g:1:117: TabSeq
                {
                mTabSeq(); 

                }
                break;
            case 13 :
                // SilkLine.g:1:124: Star
                {
                mStar(); 

                }
                break;
            case 14 :
                // SilkLine.g:1:129: At
                {
                mAt(); 

                }
                break;
            case 15 :
                // SilkLine.g:1:132: Plus
                {
                mPlus(); 

                }
                break;
            case 16 :
                // SilkLine.g:1:137: LBracket
                {
                mLBracket(); 

                }
                break;
            case 17 :
                // SilkLine.g:1:146: RBracket
                {
                mRBracket(); 

                }
                break;
            case 18 :
                // SilkLine.g:1:155: Question
                {
                mQuestion(); 

                }
                break;
            case 19 :
                // SilkLine.g:1:164: String
                {
                mString(); 

                }
                break;
            case 20 :
                // SilkLine.g:1:171: PlainOneLine
                {
                mPlainOneLine(); 

                }
                break;
            case 21 :
                // SilkLine.g:1:184: JSON
                {
                mJSON(); 

                }
                break;
            case 22 :
                // SilkLine.g:1:189: Spaces
                {
                mSpaces(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA16_eotS =
        "\6\uffff\1\12\7\uffff";
    static final String DFA16_eofS =
        "\16\uffff";
    static final String DFA16_minS =
        "\7\0\6\uffff\1\0";
    static final String DFA16_maxS =
        "\1\uffff\5\0\1\uffff\6\uffff\1\0";
    static final String DFA16_acceptS =
        "\7\uffff\4\3\1\1\1\2\1\uffff";
    static final String DFA16_specialS =
        "\1\1\1\4\1\7\1\6\1\2\1\0\1\3\6\uffff\1\5}>";
    static final String[] DFA16_transitionS = {
            "\11\1\1\uffff\26\1\1\uffff\1\1\1\7\2\1\1\12\1\1\3\12\1\5\1"+
            "\4\1\12\1\2\14\1\1\6\2\1\1\3\1\12\1\6\1\uffff\32\1\1\11\2\12"+
            "\35\1\1\10\2\12\uff82\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\11\15\1\uffff\26\15\1\uffff\1\15\1\uffff\71\15\1\uffff\uffa3"+
            "\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff"
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
            return "193:1: PlainOneLine : ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => ( String | ~ ( '\"' | '@' | WhiteSpace ) ( PlainSafeOut )* | JSON ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 11;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\n' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='#' && LA16_0<='$')||LA16_0=='&'||(LA16_0>='.' && LA16_0<='9')||(LA16_0>=';' && LA16_0<='<')||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 1;}

                        else if ( (LA16_0=='-') && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isOutValue() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 2;}

                        else if ( (LA16_0=='=') && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA16_0=='+') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 4;}

                        else if ( (LA16_0=='*') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 5;}

                        else if ( (LA16_0==':'||LA16_0=='?') && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 6;}

                        else if ( (LA16_0=='\"') && (( isOutValue() ))) {s = 7;}

                        else if ( (LA16_0=='{') && (((( isOutValue() )&&( isValue() ))||( isOutValue() )))) {s = 8;}

                        else if ( (LA16_0=='[') && (((( isOutValue() )&&( isValue() ))||( isOutValue() )))) {s = 9;}

                        else if ( (LA16_0=='%'||(LA16_0>='\'' && LA16_0<=')')||LA16_0==','||LA16_0=='>'||(LA16_0>='\\' && LA16_0<=']')||(LA16_0>='|' && LA16_0<='}')) && (( isOutValue() ))) {s = 10;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 11;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_6 = input.LA(1);

                         
                        int index16_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_6>='\u0000' && LA16_6<='\b')||(LA16_6>='\n' && LA16_6<='\u001F')||LA16_6=='!'||(LA16_6>='#' && LA16_6<='[')||(LA16_6>=']' && LA16_6<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 13;}

                        else s = 10;

                         
                        input.seek(index16_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 11;}

                        else if ( (( isInValue() )) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_13 = input.LA(1);

                         
                        int index16_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 11;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 11;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 11;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 12;}

                        else if ( (( isOutValue() )) ) {s = 10;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\1\6\1\27\1\35\1\42\1\46\1\35\1\uffff\1\47\1\50\1\51\1\52\1\54"+
        "\1\55\1\56\1\57\1\60\1\61\1\62\3\uffff\1\66\2\uffff\1\67\1\uffff"+
        "\1\70\1\72\3\uffff\1\76\1\77\1\100\23\uffff\1\127\47\uffff";
    static final String DFA19_eofS =
        "\135\uffff";
    static final String DFA19_minS =
        "\2\0\1\11\2\0\1\11\1\uffff\14\0\2\uffff\1\0\1\uffff\2\0\1\uffff"+
        "\2\0\1\uffff\1\0\1\uffff\1\55\3\0\3\uffff\5\0\1\uffff\10\0\1\42"+
        "\4\0\1\uffff\1\0\4\uffff\2\0\15\uffff\10\0\1\60\1\0\1\60\1\uffff"+
        "\2\60\1\0";
    static final String DFA19_maxS =
        "\2\uffff\1\100\1\uffff\1\0\1\40\1\uffff\14\uffff\2\uffff\1\uffff"+
        "\1\uffff\1\0\1\uffff\1\uffff\2\uffff\1\uffff\1\0\1\uffff\1\76\2"+
        "\uffff\1\0\3\uffff\5\0\1\uffff\7\0\1\uffff\1\165\4\0\1\uffff\1\0"+
        "\4\uffff\2\0\15\uffff\10\uffff\1\146\1\0\1\146\1\uffff\2\146\1\uffff";
    static final String DFA19_acceptS =
        "\6\uffff\1\6\14\uffff\2\24\1\uffff\1\24\2\uffff\1\24\2\uffff\1"+
        "\1\1\uffff\1\5\4\uffff\3\24\5\uffff\1\24\15\uffff\1\24\1\uffff\1"+
        "\26\1\4\1\2\1\3\2\uffff\1\16\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\17\1\20\1\25\1\21\1\22\13\uffff\1\23\3\uffff";
    static final String DFA19_specialS =
        "\1\4\1\51\1\56\1\42\1\uffff\1\15\1\uffff\1\34\1\46\1\32\1\35\1"+
        "\47\1\41\1\10\1\64\1\67\1\57\1\50\1\45\2\uffff\1\27\1\uffff\1\26"+
        "\1\44\1\uffff\1\52\1\40\1\uffff\1\20\1\uffff\1\12\1\37\1\33\1\30"+
        "\3\uffff\1\62\1\16\1\21\1\23\1\7\1\uffff\1\11\1\13\1\17\1\24\1\3"+
        "\1\5\1\1\1\0\2\uffff\1\36\1\25\1\6\1\uffff\1\61\4\uffff\1\31\1\22"+
        "\15\uffff\1\14\1\60\1\63\1\65\1\66\1\53\1\54\1\55\1\uffff\1\2\4"+
        "\uffff\1\43}>";
    static final String[] DFA19_transitionS = {
            "\11\23\1\5\26\23\1\2\1\23\1\22\1\1\1\23\1\26\1\23\1\26\1\7"+
            "\1\10\1\15\1\16\1\11\1\3\14\23\1\12\2\23\1\24\1\13\1\21\1\4"+
            "\32\23\1\17\1\26\1\20\35\23\1\25\1\14\1\26\uff82\23",
            "\12\30\1\31\2\30\1\31\24\30\1\34\5\30\2\33\1\32\1\30\1\33"+
            "\15\30\1\32\2\30\2\32\34\30\1\32\1\30\1\32\35\30\3\32\uff82"+
            "\30",
            "\1\5\26\uffff\1\2\14\uffff\1\37\22\uffff\1\36",
            "\42\43\1\uffff\5\43\2\45\1\44\1\43\1\45\1\40\14\43\1\44\2"+
            "\43\1\44\1\41\34\43\1\44\1\43\1\44\35\43\3\44\uff82\43",
            "\1\uffff",
            "\1\5\26\uffff\1\5",
            "",
            "\42\45\1\uffff\uffdd\45",
            "\42\45\1\uffff\uffdd\45",
            "\42\45\1\uffff\uffdd\45",
            "\11\53\1\45\26\53\1\45\1\53\1\uffff\71\53\1\45\uffa3\53",
            "\42\45\1\uffff\uffdd\45",
            "\42\45\1\uffff\uffdd\45",
            "\42\43\1\uffff\5\43\2\45\1\44\1\43\1\45\15\43\1\44\2\43\2"+
            "\44\34\43\1\44\1\43\1\44\35\43\3\44\uff82\43",
            "\42\43\1\uffff\5\43\2\45\1\44\1\43\1\45\15\43\1\44\2\43\2"+
            "\44\34\43\1\44\1\43\1\44\35\43\3\44\uff82\43",
            "\42\45\1\uffff\uffdd\45",
            "\42\45\1\uffff\uffdd\45",
            "\11\53\1\45\26\53\1\45\1\53\1\uffff\71\53\1\45\uffa3\53",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "",
            "",
            "\42\45\1\uffff\uffdd\45",
            "",
            "\1\uffff",
            "\12\30\1\31\2\30\1\31\24\30\1\34\5\30\2\33\1\32\1\30\1\33"+
            "\15\30\1\32\2\30\2\32\34\30\1\32\1\30\1\32\35\30\3\32\uff82"+
            "\30",
            "",
            "\12\32\1\71\2\32\1\71\24\32\1\34\5\32\2\33\2\32\1\33\uffd3"+
            "\32",
            "\12\33\1\45\2\33\1\45\24\33\1\34\uffdd\33",
            "",
            "\1\uffff",
            "",
            "\1\75\20\uffff\1\74",
            "\42\43\1\uffff\5\43\2\45\1\44\1\43\1\45\15\43\1\44\2\43\2"+
            "\44\34\43\1\44\1\43\1\44\35\43\3\44\uff82\43",
            "\42\44\1\uffff\5\44\2\45\2\44\1\45\uffd3\44",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\1\116\14\uffff\1\120\54\uffff\1\117\5\uffff\1\121\3\uffff"+
            "\1\122\7\uffff\1\123\3\uffff\1\124\1\uffff\1\125\1\126",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\42\63\1\65\71\63\1\64\uffa3\63",
            "\12\130\7\uffff\6\130\32\uffff\6\130",
            "\1\uffff",
            "\12\132\7\uffff\6\132\32\uffff\6\132",
            "",
            "\12\133\7\uffff\6\133\32\uffff\6\133",
            "\12\134\7\uffff\6\134\32\uffff\6\134",
            "\42\63\1\65\71\63\1\64\uffa3\63"
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
            return "1:1: Tokens : ( LineComment | BlockIndent | NodeIndent | PullUpNodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Spaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_51 = input.LA(1);

                        s = -1;
                        if ( (LA19_51=='\"') ) {s = 53;}

                        else if ( ((LA19_51>='\u0000' && LA19_51<='!')||(LA19_51>='#' && LA19_51<='[')||(LA19_51>=']' && LA19_51<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_51=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_50 = input.LA(1);

                         
                        int index19_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 77;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_50);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_87 = input.LA(1);

                         
                        int index19_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 89;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_87);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_48 = input.LA(1);

                         
                        int index19_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isValue() )||( isOutValue() )||(( isOutValue() )&&( isValue() )))))) ) {s = 74;}

                        else if ( ((( isOutValue() )||(( isOutValue() )&&( isValue() )))) ) {s = 57;}

                        else if ( (( isValue() )) ) {s = 75;}

                         
                        input.seek(index19_48);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0=='#') ) {s = 1;}

                        else if ( (LA19_0==' ') && ((( isHead() )||( !isHead() )))) {s = 2;}

                        else if ( (LA19_0=='-') && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA19_0=='@') ) {s = 4;}

                        else if ( (LA19_0=='\t') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else if ( (LA19_0=='(') ) {s = 7;}

                        else if ( (LA19_0==')') ) {s = 8;}

                        else if ( (LA19_0==',') ) {s = 9;}

                        else if ( (LA19_0==':') ) {s = 10;}

                        else if ( (LA19_0=='>') ) {s = 11;}

                        else if ( (LA19_0=='|') ) {s = 12;}

                        else if ( (LA19_0=='*') ) {s = 13;}

                        else if ( (LA19_0=='+') ) {s = 14;}

                        else if ( (LA19_0=='[') ) {s = 15;}

                        else if ( (LA19_0==']') ) {s = 16;}

                        else if ( (LA19_0=='?') ) {s = 17;}

                        else if ( (LA19_0=='\"') ) {s = 18;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\n' && LA19_0<='\u001F')||LA19_0=='!'||LA19_0=='$'||LA19_0=='&'||(LA19_0>='.' && LA19_0<='9')||(LA19_0>=';' && LA19_0<='<')||(LA19_0>='A' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||(LA19_0>='~' && LA19_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 19;}

                        else if ( (LA19_0=='=') && (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 20;}

                        else if ( (LA19_0=='{') && ((( isValue() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isOutValue() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 21;}

                        else if ( (LA19_0=='%'||LA19_0=='\''||LA19_0=='\\'||LA19_0=='}') && (( isOutValue() ))) {s = 22;}

                        else s = 6;

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_49 = input.LA(1);

                         
                        int index19_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 76;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_49);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_56 = input.LA(1);

                         
                        int index19_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() ))))) ) {s = 28;}

                        else if ( ((( isInValue() )||( isOutValue() ))) ) {s = 57;}

                         
                        input.seek(index19_56);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_42 = input.LA(1);

                         
                        int index19_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 69;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_42);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_13 = input.LA(1);

                         
                        int index19_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_13>='\u0000' && LA19_13<='!')||(LA19_13>='#' && LA19_13<='\'')||LA19_13=='+'||(LA19_13>='-' && LA19_13<='9')||(LA19_13>=';' && LA19_13<='<')||(LA19_13>='?' && LA19_13<='Z')||LA19_13=='\\'||(LA19_13>='^' && LA19_13<='z')||(LA19_13>='~' && LA19_13<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isOutValue() )))) {s = 35;}

                        else if ( (LA19_13=='*'||LA19_13==':'||(LA19_13>='=' && LA19_13<='>')||LA19_13=='['||LA19_13==']'||(LA19_13>='{' && LA19_13<='}')) && (((( isInValue() )&&( isValue() ))||( isOutValue() )))) {s = 36;}

                        else if ( ((LA19_13>='(' && LA19_13<=')')||LA19_13==',') && (( isOutValue() ))) {s = 37;}

                        else s = 46;

                         
                        input.seek(index19_13);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_44 = input.LA(1);

                         
                        int index19_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 70;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_44);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_31 = input.LA(1);

                         
                        int index19_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_31=='>') && (( isHead() ))) {s = 60;}

                        else if ( (LA19_31=='-') && (( isHead() ))) {s = 61;}

                        else s = 62;

                         
                        input.seek(index19_31);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_45 = input.LA(1);

                         
                        int index19_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 71;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_45);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_78 = input.LA(1);

                        s = -1;
                        if ( (LA19_78=='\"') ) {s = 53;}

                        else if ( ((LA19_78>='\u0000' && LA19_78<='!')||(LA19_78>='#' && LA19_78<='[')||(LA19_78>=']' && LA19_78<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_78=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_5 = input.LA(1);

                         
                        int index19_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_5=='\t'||LA19_5==' ') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else s = 29;

                         
                        input.seek(index19_5);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_39 = input.LA(1);

                         
                        int index19_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 66;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_39);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_46 = input.LA(1);

                         
                        int index19_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))))) ) {s = 72;}

                        else if ( (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index19_46);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA19_29 = input.LA(1);

                         
                        int index19_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 6;}

                        else if ( (( !isHead() )) ) {s = 59;}

                         
                        input.seek(index19_29);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA19_40 = input.LA(1);

                         
                        int index19_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 67;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_40);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA19_64 = input.LA(1);

                         
                        int index19_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 60;}

                        else if ( ((( isOutValue() )||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index19_64);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA19_41 = input.LA(1);

                         
                        int index19_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 68;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_41);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA19_47 = input.LA(1);

                         
                        int index19_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))))) ) {s = 73;}

                        else if ( (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index19_47);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA19_55 = input.LA(1);

                         
                        int index19_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {s = 28;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 57;}

                         
                        input.seek(index19_55);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA19_23 = input.LA(1);

                         
                        int index19_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {s = 28;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 43;}

                         
                        input.seek(index19_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA19_21 = input.LA(1);

                         
                        int index19_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_21>='\u0000' && LA19_21<='!')||(LA19_21>='#' && LA19_21<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 54;

                         
                        input.seek(index19_21);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA19_34 = input.LA(1);

                         
                        int index19_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 62;}

                        else if ( (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index19_34);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA19_63 = input.LA(1);

                         
                        int index19_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 61;}

                        else if ( (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() )))) ) {s = 57;}

                         
                        input.seek(index19_63);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA19_9 = input.LA(1);

                         
                        int index19_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_9>='\u0000' && LA19_9<='!')||(LA19_9>='#' && LA19_9<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 41;

                         
                        input.seek(index19_9);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA19_33 = input.LA(1);

                         
                        int index19_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_33>='\u0000' && LA19_33<='!')||(LA19_33>='#' && LA19_33<='\'')||(LA19_33>='*' && LA19_33<='+')||(LA19_33>='-' && LA19_33<='\uFFFF')) && ((( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 36;}

                        else if ( ((LA19_33>='(' && LA19_33<=')')||LA19_33==',') && (( isOutValue() ))) {s = 37;}

                        else s = 64;

                         
                        input.seek(index19_33);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA19_7 = input.LA(1);

                         
                        int index19_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_7>='\u0000' && LA19_7<='!')||(LA19_7>='#' && LA19_7<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index19_7);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA19_10 = input.LA(1);

                         
                        int index19_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_10>='\u0000' && LA19_10<='\b')||(LA19_10>='\n' && LA19_10<='\u001F')||LA19_10=='!'||(LA19_10>='#' && LA19_10<='[')||(LA19_10>=']' && LA19_10<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||( isOutValue() )||(( isKey() )&&( isValue() ))))) {s = 43;}

                        else if ( (LA19_10=='\t'||LA19_10==' '||LA19_10=='\\') && (( isOutValue() ))) {s = 37;}

                        else s = 42;

                         
                        input.seek(index19_10);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA19_54 = input.LA(1);

                         
                        int index19_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isOutValue() )||(( isOutValue() )&&( isValue() )))) ) {s = 57;}

                        else if ( (( isValue() )) ) {s = 75;}

                         
                        input.seek(index19_54);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA19_32 = input.LA(1);

                         
                        int index19_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_32>='\u0000' && LA19_32<='!')||(LA19_32>='#' && LA19_32<='\'')||LA19_32=='+'||(LA19_32>='-' && LA19_32<='9')||(LA19_32>=';' && LA19_32<='<')||(LA19_32>='?' && LA19_32<='Z')||LA19_32=='\\'||(LA19_32>='^' && LA19_32<='z')||(LA19_32>='~' && LA19_32<='\uFFFF')) && (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 35;}

                        else if ( (LA19_32=='*'||LA19_32==':'||(LA19_32>='=' && LA19_32<='>')||LA19_32=='['||LA19_32==']'||(LA19_32>='{' && LA19_32<='}')) && ((( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 36;}

                        else if ( ((LA19_32>='(' && LA19_32<=')')||LA19_32==',') && (( isOutValue() ))) {s = 37;}

                        else s = 63;

                         
                        input.seek(index19_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA19_27 = input.LA(1);

                         
                        int index19_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_27>='\u0000' && LA19_27<='\t')||(LA19_27>='\u000B' && LA19_27<='\f')||(LA19_27>='\u000E' && LA19_27<='!')||(LA19_27>='#' && LA19_27<='\uFFFF')) ) {s = 27;}

                        else if ( (LA19_27=='\n'||LA19_27=='\r') && (( isOutValue() ))) {s = 37;}

                        else if ( (LA19_27=='\"') ) {s = 28;}

                        else s = 58;

                         
                        input.seek(index19_27);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA19_12 = input.LA(1);

                         
                        int index19_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_12>='\u0000' && LA19_12<='!')||(LA19_12>='#' && LA19_12<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 45;

                         
                        input.seek(index19_12);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_3=='-') && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 32;}

                        else if ( (LA19_3=='>') && (((( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 33;}

                        else if ( ((LA19_3>='\u0000' && LA19_3<='!')||(LA19_3>='#' && LA19_3<='\'')||LA19_3=='+'||(LA19_3>='.' && LA19_3<='9')||(LA19_3>=';' && LA19_3<='<')||(LA19_3>='?' && LA19_3<='Z')||LA19_3=='\\'||(LA19_3>='^' && LA19_3<='z')||(LA19_3>='~' && LA19_3<='\uFFFF')) && ((( isOutValue() )||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 35;}

                        else if ( (LA19_3=='*'||LA19_3==':'||LA19_3=='='||LA19_3=='['||LA19_3==']'||(LA19_3>='{' && LA19_3<='}')) && (((( isInValue() )&&( isValue() ))||( isOutValue() )))) {s = 36;}

                        else if ( ((LA19_3>='(' && LA19_3<=')')||LA19_3==',') && (( isOutValue() ))) {s = 37;}

                        else s = 34;

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA19_92 = input.LA(1);

                        s = -1;
                        if ( (LA19_92=='\"') ) {s = 53;}

                        else if ( ((LA19_92>='\u0000' && LA19_92<='!')||(LA19_92>='#' && LA19_92<='[')||(LA19_92>=']' && LA19_92<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_92=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA19_24 = input.LA(1);

                         
                        int index19_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_24>='\u0000' && LA19_24<='\t')||(LA19_24>='\u000B' && LA19_24<='\f')||(LA19_24>='\u000E' && LA19_24<='!')||(LA19_24>='#' && LA19_24<='\'')||LA19_24=='+'||(LA19_24>='-' && LA19_24<='9')||(LA19_24>=';' && LA19_24<='<')||(LA19_24>='?' && LA19_24<='Z')||LA19_24=='\\'||(LA19_24>='^' && LA19_24<='z')||(LA19_24>='~' && LA19_24<='\uFFFF')) ) {s = 24;}

                        else if ( (LA19_24=='*'||LA19_24==':'||(LA19_24>='=' && LA19_24<='>')||LA19_24=='['||LA19_24==']'||(LA19_24>='{' && LA19_24<='}')) ) {s = 26;}

                        else if ( ((LA19_24>='(' && LA19_24<=')')||LA19_24==',') ) {s = 27;}

                        else if ( (LA19_24=='\n'||LA19_24=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 25;}

                        else if ( (LA19_24=='\"') ) {s = 28;}

                        else s = 55;

                         
                        input.seek(index19_24);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA19_18 = input.LA(1);

                        s = -1;
                        if ( ((LA19_18>='\u0000' && LA19_18<='!')||(LA19_18>='#' && LA19_18<='[')||(LA19_18>=']' && LA19_18<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_18=='\\') ) {s = 52;}

                        else if ( (LA19_18=='\"') ) {s = 53;}

                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA19_8 = input.LA(1);

                         
                        int index19_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_8>='\u0000' && LA19_8<='!')||(LA19_8>='#' && LA19_8<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 40;

                         
                        input.seek(index19_8);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA19_11 = input.LA(1);

                         
                        int index19_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_11>='\u0000' && LA19_11<='!')||(LA19_11>='#' && LA19_11<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 44;

                         
                        input.seek(index19_11);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA19_17 = input.LA(1);

                         
                        int index19_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_17>='\u0000' && LA19_17<='\b')||(LA19_17>='\n' && LA19_17<='\u001F')||LA19_17=='!'||(LA19_17>='#' && LA19_17<='[')||(LA19_17>=']' && LA19_17<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||( isOutValue() )||(( isKey() )&&( isValue() ))))) {s = 43;}

                        else if ( (LA19_17=='\t'||LA19_17==' '||LA19_17=='\\') && (( isOutValue() ))) {s = 37;}

                        else s = 50;

                         
                        input.seek(index19_17);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_1>='\u0000' && LA19_1<='\t')||(LA19_1>='\u000B' && LA19_1<='\f')||(LA19_1>='\u000E' && LA19_1<='!')||(LA19_1>='#' && LA19_1<='\'')||LA19_1=='+'||(LA19_1>='-' && LA19_1<='9')||(LA19_1>=';' && LA19_1<='<')||(LA19_1>='?' && LA19_1<='Z')||LA19_1=='\\'||(LA19_1>='^' && LA19_1<='z')||(LA19_1>='~' && LA19_1<='\uFFFF')) ) {s = 24;}

                        else if ( (LA19_1=='\n'||LA19_1=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 25;}

                        else if ( (LA19_1=='*'||LA19_1==':'||(LA19_1>='=' && LA19_1<='>')||LA19_1=='['||LA19_1==']'||(LA19_1>='{' && LA19_1<='}')) ) {s = 26;}

                        else if ( ((LA19_1>='(' && LA19_1<=')')||LA19_1==',') ) {s = 27;}

                        else if ( (LA19_1=='\"') ) {s = 28;}

                        else s = 23;

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA19_26 = input.LA(1);

                         
                        int index19_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_26>='\u0000' && LA19_26<='\t')||(LA19_26>='\u000B' && LA19_26<='\f')||(LA19_26>='\u000E' && LA19_26<='!')||(LA19_26>='#' && LA19_26<='\'')||(LA19_26>='*' && LA19_26<='+')||(LA19_26>='-' && LA19_26<='\uFFFF')) ) {s = 26;}

                        else if ( ((LA19_26>='(' && LA19_26<=')')||LA19_26==',') ) {s = 27;}

                        else if ( (LA19_26=='\n'||LA19_26=='\r') && ((( isInValue() )||( isOutValue() )))) {s = 57;}

                        else if ( (LA19_26=='\"') ) {s = 28;}

                        else s = 56;

                         
                        input.seek(index19_26);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA19_83 = input.LA(1);

                        s = -1;
                        if ( (LA19_83=='\"') ) {s = 53;}

                        else if ( ((LA19_83>='\u0000' && LA19_83<='!')||(LA19_83>='#' && LA19_83<='[')||(LA19_83>=']' && LA19_83<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_83=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA19_84 = input.LA(1);

                        s = -1;
                        if ( (LA19_84=='\"') ) {s = 53;}

                        else if ( ((LA19_84>='\u0000' && LA19_84<='!')||(LA19_84>='#' && LA19_84<='[')||(LA19_84>=']' && LA19_84<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_84=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA19_85 = input.LA(1);

                        s = -1;
                        if ( (LA19_85=='\"') ) {s = 53;}

                        else if ( ((LA19_85>='\u0000' && LA19_85<='!')||(LA19_85>='#' && LA19_85<='[')||(LA19_85>=']' && LA19_85<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_85=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_2==' ') && ((( isHead() )||( !isHead() )))) {s = 2;}

                        else if ( (LA19_2=='@') && (( isHead() ))) {s = 30;}

                        else if ( (LA19_2=='\t') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else if ( (LA19_2=='-') && (( isHead() ))) {s = 31;}

                        else s = 29;

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA19_16 = input.LA(1);

                         
                        int index19_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_16>='\u0000' && LA19_16<='!')||(LA19_16>='#' && LA19_16<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 49;

                         
                        input.seek(index19_16);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA19_79 = input.LA(1);

                        s = -1;
                        if ( (LA19_79=='\"') ) {s = 53;}

                        else if ( ((LA19_79>='\u0000' && LA19_79<='!')||(LA19_79>='#' && LA19_79<='[')||(LA19_79>=']' && LA19_79<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_79=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA19_58 = input.LA(1);

                         
                        int index19_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 28;}

                        else if ( (( isOutValue() )) ) {s = 57;}

                         
                        input.seek(index19_58);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA19_38 = input.LA(1);

                         
                        int index19_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 30;}

                        else if ( (true) ) {s = 65;}

                         
                        input.seek(index19_38);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA19_80 = input.LA(1);

                        s = -1;
                        if ( (LA19_80=='\"') ) {s = 53;}

                        else if ( ((LA19_80>='\u0000' && LA19_80<='!')||(LA19_80>='#' && LA19_80<='[')||(LA19_80>=']' && LA19_80<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_80=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA19_14 = input.LA(1);

                         
                        int index19_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_14>='\u0000' && LA19_14<='!')||(LA19_14>='#' && LA19_14<='\'')||LA19_14=='+'||(LA19_14>='-' && LA19_14<='9')||(LA19_14>=';' && LA19_14<='<')||(LA19_14>='?' && LA19_14<='Z')||LA19_14=='\\'||(LA19_14>='^' && LA19_14<='z')||(LA19_14>='~' && LA19_14<='\uFFFF')) && (((( isKey() )&&( isValue() ))||( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 35;}

                        else if ( (LA19_14=='*'||LA19_14==':'||(LA19_14>='=' && LA19_14<='>')||LA19_14=='['||LA19_14==']'||(LA19_14>='{' && LA19_14<='}')) && ((( isOutValue() )||(( isInValue() )&&( isValue() ))))) {s = 36;}

                        else if ( ((LA19_14>='(' && LA19_14<=')')||LA19_14==',') && (( isOutValue() ))) {s = 37;}

                        else s = 47;

                         
                        input.seek(index19_14);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA19_81 = input.LA(1);

                        s = -1;
                        if ( (LA19_81=='\"') ) {s = 53;}

                        else if ( ((LA19_81>='\u0000' && LA19_81<='!')||(LA19_81>='#' && LA19_81<='[')||(LA19_81>=']' && LA19_81<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_81=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA19_82 = input.LA(1);

                        s = -1;
                        if ( (LA19_82=='\"') ) {s = 53;}

                        else if ( ((LA19_82>='\u0000' && LA19_82<='!')||(LA19_82>='#' && LA19_82<='[')||(LA19_82>=']' && LA19_82<='\uFFFF')) ) {s = 51;}

                        else if ( (LA19_82=='\\') ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA19_15 = input.LA(1);

                         
                        int index19_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA19_15>='\u0000' && LA19_15<='!')||(LA19_15>='#' && LA19_15<='\uFFFF')) && (( isOutValue() ))) {s = 37;}

                        else s = 48;

                         
                        input.seek(index19_15);
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
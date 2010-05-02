// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkLine.g 2010-05-02 21:04:33

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
    public static final int PlainOneLine=52;
    public static final int NonSpaceChar=50;
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
    public static final int Separation=54;
    public static final int Seq=27;
    public static final int Plus=31;
    public static final int JSON=53;
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
            Token s=null;

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
            // SilkLine.g:189:2: (~ ( '-' | '+' | '?' | PlainUnsafeChar | WhiteSpace | Indicator ) | {...}? => ( '-' | '+' | '*' | ( ':' | '?' ) NonSpaceChar ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\n' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='$')||LA11_0=='&'||(LA11_0>='.' && LA11_0<='9')||(LA11_0>=';' && LA11_0<='<')||(LA11_0>='A' && LA11_0<='Z')||(LA11_0>='^' && LA11_0<='z')||(LA11_0>='~' && LA11_0<='\uFFFF')) ) {
                alt11=1;
            }
            else if ( ((LA11_0>='*' && LA11_0<='+')||LA11_0=='-'||LA11_0==':'||LA11_0=='?') && (( isValue() ))) {
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
                    // SilkLine.g:190:4: {...}? => ( '-' | '+' | '*' | ( ':' | '?' ) NonSpaceChar )
                    {
                    if ( !(( isValue() )) ) {
                        throw new FailedPredicateException(input, "PlainFirst", " isValue() ");
                    }
                    // SilkLine.g:190:22: ( '-' | '+' | '*' | ( ':' | '?' ) NonSpaceChar )
                    int alt10=4;
                    switch ( input.LA(1) ) {
                    case '-':
                        {
                        alt10=1;
                        }
                        break;
                    case '+':
                        {
                        alt10=2;
                        }
                        break;
                    case '*':
                        {
                        alt10=3;
                        }
                        break;
                    case ':':
                    case '?':
                        {
                        alt10=4;
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
                            // SilkLine.g:190:29: '+'
                            {
                            match('+'); 

                            }
                            break;
                        case 3 :
                            // SilkLine.g:190:35: '*'
                            {
                            match('*'); 

                            }
                            break;
                        case 4 :
                            // SilkLine.g:190:41: ( ':' | '?' ) NonSpaceChar
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
            // SilkLine.g:194:2: ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => PlainFirst ( PlainSafeOut )* )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
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
                    // SilkLine.g:196:5: {...}? => PlainFirst ( PlainSafeOut )*
                    {
                    if ( !(( isOutValue() )) ) {
                        throw new FailedPredicateException(input, "PlainOneLine", " isOutValue() ");
                    }
                    mPlainFirst(); 
                    // SilkLine.g:196:38: ( PlainSafeOut )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // SilkLine.g:196:38: PlainSafeOut
                    	    {
                    	    mPlainSafeOut(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
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
            // SilkLine.g:201:2: ({...}? => '{' | {...}? => '[' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='{') && (( isValue() ))) {
                alt16=1;
            }
            else if ( (LA16_0=='[') && (( isValue() ))) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
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

    // $ANTLR start "Separation"
    public final void mSeparation() throws RecognitionException {
        try {
            int _type = Separation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkLine.g:225:11: ({...}? => ( WhiteSpace )+ )
            // SilkLine.g:225:13: {...}? => ( WhiteSpace )+
            {
            if ( !(( !isHead() )) ) {
                throw new FailedPredicateException(input, "Separation", " !isHead() ");
            }
            // SilkLine.g:225:31: ( WhiteSpace )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\t'||LA17_0==' ') ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // SilkLine.g:225:31: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
        // SilkLine.g:1:8: ( LineComment | BlockIndent | NodeIndent | PullUpNodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation )
        int alt18=22;
        alt18 = dfa18.predict(input);
        switch (alt18) {
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
                // SilkLine.g:1:189: Separation
                {
                mSeparation(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA15_eotS =
        "\12\uffff";
    static final String DFA15_eofS =
        "\12\uffff";
    static final String DFA15_minS =
        "\6\0\3\uffff\1\0";
    static final String DFA15_maxS =
        "\1\uffff\4\0\1\uffff\3\uffff\1\0";
    static final String DFA15_acceptS =
        "\6\uffff\1\1\1\2\1\3\1\uffff";
    static final String DFA15_specialS =
        "\1\4\1\2\1\6\1\1\1\3\1\0\3\uffff\1\5}>";
    static final String[] DFA15_transitionS = {
            "\11\1\1\uffff\26\1\1\uffff\1\1\1\uffff\2\1\1\uffff\1\1\3\uffff"+
            "\1\4\1\3\1\uffff\1\2\14\1\1\5\2\1\2\uffff\1\5\1\uffff\32\1\3"+
            "\uffff\35\1\3\uffff\uff82\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\11\11\1\uffff\26\11\1\uffff\1\11\1\uffff\71\11\1\uffff\uffa3"+
            "\11",
            "",
            "",
            "",
            "\1\uffff"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "193:1: PlainOneLine : ({...}? => PlainFirst ( PlainSafeKey )* | {...}? => PlainFirst ( PlainSafeIn )* | {...}? => PlainFirst ( PlainSafeOut )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA15_5>='\u0000' && LA15_5<='\b')||(LA15_5>='\n' && LA15_5<='\u001F')||LA15_5=='!'||(LA15_5>='#' && LA15_5<='[')||(LA15_5>=']' && LA15_5<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 9;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 6;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 7;}

                        else if ( ((( isOutValue() )&&( isValue() ))) ) {s = 8;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_1 = input.LA(1);

                         
                        int index15_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isKey() )) ) {s = 6;}

                        else if ( (( isInValue() )) ) {s = 7;}

                        else if ( (( isOutValue() )) ) {s = 8;}

                         
                        input.seek(index15_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 6;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 7;}

                        else if ( ((( isOutValue() )&&( isValue() ))) ) {s = 8;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_0 = input.LA(1);

                         
                        int index15_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\n' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='$')||LA15_0=='&'||(LA15_0>='.' && LA15_0<='9')||(LA15_0>=';' && LA15_0<='<')||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 1;}

                        else if ( (LA15_0=='-') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 2;}

                        else if ( (LA15_0=='+') && (((( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA15_0=='*') && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 4;}

                        else if ( (LA15_0==':'||LA15_0=='?') && (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 5;}

                         
                        input.seek(index15_0);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_9 = input.LA(1);

                         
                        int index15_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 6;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 7;}

                        else if ( ((( isOutValue() )&&( isValue() ))) ) {s = 8;}

                         
                        input.seek(index15_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((( isKey() )&&( isValue() ))) ) {s = 6;}

                        else if ( ((( isInValue() )&&( isValue() ))) ) {s = 7;}

                        else if ( ((( isOutValue() )&&( isValue() ))) ) {s = 8;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA18_eotS =
        "\1\6\1\25\1\33\1\40\1\44\1\33\4\uffff\1\46\2\uffff\1\47\1\50\1"+
        "\51\1\uffff\1\52\4\uffff\1\53\1\54\1\56\3\uffff\1\63\1\uffff\1\64"+
        "\1\65\32\uffff";
    static final String DFA18_eofS =
        "\72\uffff";
    static final String DFA18_minS =
        "\2\0\1\11\2\0\1\11\4\uffff\1\0\2\uffff\3\0\1\uffff\1\0\3\uffff"+
        "\4\0\2\uffff\1\0\1\55\1\uffff\3\0\3\uffff\1\0\2\uffff\3\0\1\uffff"+
        "\2\0\1\uffff\1\0\5\uffff\2\0\4\uffff";
    static final String DFA18_maxS =
        "\2\uffff\1\100\1\uffff\1\0\1\40\4\uffff\1\uffff\2\uffff\2\uffff"+
        "\1\0\1\uffff\1\uffff\3\uffff\1\0\3\uffff\2\uffff\1\0\1\76\1\uffff"+
        "\2\uffff\1\0\3\uffff\1\0\2\uffff\3\0\1\uffff\2\0\1\uffff\1\0\5\uffff"+
        "\2\0\4\uffff";
    static final String DFA18_acceptS =
        "\6\uffff\1\6\1\7\1\10\1\11\1\uffff\1\13\1\14\3\uffff\1\21\1\uffff"+
        "\1\23\1\24\1\25\4\uffff\1\24\1\1\2\uffff\1\5\3\uffff\3\24\1\uffff"+
        "\1\24\1\12\3\uffff\1\22\2\uffff\1\24\1\uffff\1\24\1\26\1\4\1\2\1"+
        "\3\2\uffff\1\16\1\15\1\17\1\20";
    static final String DFA18_specialS =
        "\1\14\1\5\1\11\1\1\1\uffff\1\13\4\uffff\1\0\2\uffff\1\16\1\6\2"+
        "\uffff\1\4\3\uffff\1\21\1\7\1\2\1\3\2\uffff\1\31\1\32\1\uffff\1"+
        "\26\1\27\1\25\3\uffff\1\15\2\uffff\1\10\1\12\1\30\1\uffff\1\22\1"+
        "\24\1\uffff\1\17\5\uffff\1\23\1\20\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\23\1\5\26\23\1\2\1\23\1\22\1\1\1\23\1\uffff\1\23\1\uffff"+
            "\1\7\1\10\1\15\1\16\1\11\1\3\14\23\1\12\2\23\1\uffff\1\13\1"+
            "\21\1\4\32\23\1\17\1\uffff\1\20\35\23\1\24\1\14\1\uffff\uff82"+
            "\23",
            "\12\26\1\31\2\26\1\31\24\26\1\32\5\26\2\30\1\27\1\26\1\30"+
            "\15\26\1\27\2\26\2\27\34\26\1\27\1\26\1\27\35\26\3\27\uff82"+
            "\26",
            "\1\5\26\uffff\1\2\14\uffff\1\34\22\uffff\1\35",
            "\42\41\1\uffff\5\41\2\42\1\43\1\41\1\42\1\36\14\41\1\43\2"+
            "\41\1\43\1\37\34\41\1\43\1\41\1\43\35\41\3\43\uff82\41",
            "\1\uffff",
            "\1\5\26\uffff\1\5",
            "",
            "",
            "",
            "",
            "\11\45\1\uffff\26\45\1\uffff\1\45\1\uffff\71\45\1\uffff\uffa3"+
            "\45",
            "",
            "",
            "\42\41\1\uffff\5\41\2\42\1\43\1\41\1\42\15\41\1\43\2\41\2"+
            "\43\34\41\1\43\1\41\1\43\35\41\3\43\uff82\41",
            "\42\41\1\uffff\5\41\2\42\1\43\1\41\1\42\15\41\1\43\2\41\2"+
            "\43\34\41\1\43\1\41\1\43\35\41\3\43\uff82\41",
            "\1\uffff",
            "",
            "\11\45\1\uffff\26\45\1\uffff\1\45\1\uffff\71\45\1\uffff\uffa3"+
            "\45",
            "",
            "",
            "",
            "\1\uffff",
            "\12\26\1\31\2\26\1\31\24\26\1\32\5\26\2\30\1\27\1\26\1\30"+
            "\15\26\1\27\2\26\2\27\34\26\1\27\1\26\1\27\35\26\3\27\uff82"+
            "\26",
            "\12\27\1\55\2\27\1\55\24\27\1\32\5\27\2\30\2\27\1\30\uffd3"+
            "\27",
            "\12\30\1\57\2\30\1\57\24\30\1\32\uffdd\30",
            "",
            "",
            "\1\uffff",
            "\1\62\20\uffff\1\61",
            "",
            "\42\41\1\uffff\5\41\2\42\1\43\1\41\1\42\15\41\1\43\2\41\2"+
            "\43\34\41\1\43\1\41\1\43\35\41\3\43\uff82\41",
            "\42\43\1\uffff\5\43\2\42\2\43\1\42\uffd3\43",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | BlockIndent | NodeIndent | PullUpNodeIndent | FunctionIndent | BlankLine | LParen | RParen | Comma | Colon | Seq | TabSeq | Star | At | Plus | LBracket | RBracket | Question | String | PlainOneLine | JSON | Separation );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_10>='\u0000' && LA18_10<='\b')||(LA18_10>='\n' && LA18_10<='\u001F')||LA18_10=='!'||(LA18_10>='#' && LA18_10<='[')||(LA18_10>=']' && LA18_10<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 37;}

                        else s = 38;

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_3=='-') && (((( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 30;}

                        else if ( (LA18_3=='>') && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||( isHead() )||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 31;}

                        else if ( ((LA18_3>='\u0000' && LA18_3<='!')||(LA18_3>='#' && LA18_3<='\'')||LA18_3=='+'||(LA18_3>='.' && LA18_3<='9')||(LA18_3>=';' && LA18_3<='<')||(LA18_3>='?' && LA18_3<='Z')||LA18_3=='\\'||(LA18_3>='^' && LA18_3<='z')||(LA18_3>='~' && LA18_3<='\uFFFF')) && (((( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 33;}

                        else if ( ((LA18_3>='(' && LA18_3<=')')||LA18_3==',') && ((( isOutValue() )&&( isValue() )))) {s = 34;}

                        else if ( (LA18_3=='*'||LA18_3==':'||LA18_3=='='||LA18_3=='['||LA18_3==']'||(LA18_3>='{' && LA18_3<='}')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 35;}

                        else s = 32;

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_23 = input.LA(1);

                         
                        int index18_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_23>='\u0000' && LA18_23<='\t')||(LA18_23>='\u000B' && LA18_23<='\f')||(LA18_23>='\u000E' && LA18_23<='!')||(LA18_23>='#' && LA18_23<='\'')||(LA18_23>='*' && LA18_23<='+')||(LA18_23>='-' && LA18_23<='\uFFFF')) ) {s = 23;}

                        else if ( ((LA18_23>='(' && LA18_23<=')')||LA18_23==',') ) {s = 24;}

                        else if ( (LA18_23=='\n'||LA18_23=='\r') && ((( isInValue() )||( isOutValue() )))) {s = 45;}

                        else if ( (LA18_23=='\"') ) {s = 26;}

                        else s = 44;

                         
                        input.seek(index18_23);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_24 = input.LA(1);

                         
                        int index18_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_24>='\u0000' && LA18_24<='\t')||(LA18_24>='\u000B' && LA18_24<='\f')||(LA18_24>='\u000E' && LA18_24<='!')||(LA18_24>='#' && LA18_24<='\uFFFF')) ) {s = 24;}

                        else if ( (LA18_24=='\n'||LA18_24=='\r') && (( isOutValue() ))) {s = 47;}

                        else if ( (LA18_24=='\"') ) {s = 26;}

                        else s = 46;

                         
                        input.seek(index18_24);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_17 = input.LA(1);

                         
                        int index18_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_17>='\u0000' && LA18_17<='\b')||(LA18_17>='\n' && LA18_17<='\u001F')||LA18_17=='!'||(LA18_17>='#' && LA18_17<='[')||(LA18_17>=']' && LA18_17<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 37;}

                        else s = 42;

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_1>='\u0000' && LA18_1<='\t')||(LA18_1>='\u000B' && LA18_1<='\f')||(LA18_1>='\u000E' && LA18_1<='!')||(LA18_1>='#' && LA18_1<='\'')||LA18_1=='+'||(LA18_1>='-' && LA18_1<='9')||(LA18_1>=';' && LA18_1<='<')||(LA18_1>='?' && LA18_1<='Z')||LA18_1=='\\'||(LA18_1>='^' && LA18_1<='z')||(LA18_1>='~' && LA18_1<='\uFFFF')) ) {s = 22;}

                        else if ( (LA18_1=='*'||LA18_1==':'||(LA18_1>='=' && LA18_1<='>')||LA18_1=='['||LA18_1==']'||(LA18_1>='{' && LA18_1<='}')) ) {s = 23;}

                        else if ( ((LA18_1>='(' && LA18_1<=')')||LA18_1==',') ) {s = 24;}

                        else if ( (LA18_1=='\n'||LA18_1=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 25;}

                        else if ( (LA18_1=='\"') ) {s = 26;}

                        else s = 21;

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_14>='\u0000' && LA18_14<='!')||(LA18_14>='#' && LA18_14<='\'')||LA18_14=='+'||(LA18_14>='-' && LA18_14<='9')||(LA18_14>=';' && LA18_14<='<')||(LA18_14>='?' && LA18_14<='Z')||LA18_14=='\\'||(LA18_14>='^' && LA18_14<='z')||(LA18_14>='~' && LA18_14<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 33;}

                        else if ( (LA18_14=='*'||LA18_14==':'||(LA18_14>='=' && LA18_14<='>')||LA18_14=='['||LA18_14==']'||(LA18_14>='{' && LA18_14<='}')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 35;}

                        else if ( ((LA18_14>='(' && LA18_14<=')')||LA18_14==',') && ((( isOutValue() )&&( isValue() )))) {s = 34;}

                        else s = 40;

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_22 = input.LA(1);

                         
                        int index18_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_22>='\u0000' && LA18_22<='\t')||(LA18_22>='\u000B' && LA18_22<='\f')||(LA18_22>='\u000E' && LA18_22<='!')||(LA18_22>='#' && LA18_22<='\'')||LA18_22=='+'||(LA18_22>='-' && LA18_22<='9')||(LA18_22>=';' && LA18_22<='<')||(LA18_22>='?' && LA18_22<='Z')||LA18_22=='\\'||(LA18_22>='^' && LA18_22<='z')||(LA18_22>='~' && LA18_22<='\uFFFF')) ) {s = 22;}

                        else if ( ((LA18_22>='(' && LA18_22<=')')||LA18_22==',') ) {s = 24;}

                        else if ( (LA18_22=='*'||LA18_22==':'||(LA18_22>='=' && LA18_22<='>')||LA18_22=='['||LA18_22==']'||(LA18_22>='{' && LA18_22<='}')) ) {s = 23;}

                        else if ( (LA18_22=='\n'||LA18_22=='\r') && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 25;}

                        else if ( (LA18_22=='\"') ) {s = 26;}

                        else s = 43;

                         
                        input.seek(index18_22);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_39 = input.LA(1);

                         
                        int index18_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))))) ) {s = 55;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 47;}

                         
                        input.seek(index18_39);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_2 = input.LA(1);

                         
                        int index18_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_2==' ') && ((( isHead() )||( !isHead() )))) {s = 2;}

                        else if ( (LA18_2=='-') && (( isHead() ))) {s = 28;}

                        else if ( (LA18_2=='\t') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else if ( (LA18_2=='@') && (( isHead() ))) {s = 29;}

                        else s = 27;

                         
                        input.seek(index18_2);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_40 = input.LA(1);

                         
                        int index18_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))))) ) {s = 56;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 47;}

                         
                        input.seek(index18_40);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_5=='\t'||LA18_5==' ') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else s = 27;

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_0 = input.LA(1);

                         
                        int index18_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_0=='#') ) {s = 1;}

                        else if ( (LA18_0==' ') && ((( isHead() )||( !isHead() )))) {s = 2;}

                        else if ( (LA18_0=='-') && (((( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||( isHead() )||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 3;}

                        else if ( (LA18_0=='@') ) {s = 4;}

                        else if ( (LA18_0=='\t') && ((( isHead() )||( !isHead() )))) {s = 5;}

                        else if ( (LA18_0=='(') ) {s = 7;}

                        else if ( (LA18_0==')') ) {s = 8;}

                        else if ( (LA18_0==',') ) {s = 9;}

                        else if ( (LA18_0==':') ) {s = 10;}

                        else if ( (LA18_0=='>') ) {s = 11;}

                        else if ( (LA18_0=='|') ) {s = 12;}

                        else if ( (LA18_0=='*') ) {s = 13;}

                        else if ( (LA18_0=='+') ) {s = 14;}

                        else if ( (LA18_0=='[') ) {s = 15;}

                        else if ( (LA18_0==']') ) {s = 16;}

                        else if ( (LA18_0=='?') ) {s = 17;}

                        else if ( (LA18_0=='\"') ) {s = 18;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\n' && LA18_0<='\u001F')||LA18_0=='!'||LA18_0=='$'||LA18_0=='&'||(LA18_0>='.' && LA18_0<='9')||(LA18_0>=';' && LA18_0<='<')||(LA18_0>='A' && LA18_0<='Z')||(LA18_0>='^' && LA18_0<='z')||(LA18_0>='~' && LA18_0<='\uFFFF')) && ((( isInValue() )||( isOutValue() )||( isKey() )))) {s = 19;}

                        else if ( (LA18_0=='{') && (( isValue() ))) {s = 20;}

                        else s = 6;

                         
                        input.seek(index18_0);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_36 = input.LA(1);

                         
                        int index18_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 29;}

                        else if ( (true) ) {s = 54;}

                         
                        input.seek(index18_36);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_13>='\u0000' && LA18_13<='!')||(LA18_13>='#' && LA18_13<='\'')||LA18_13=='+'||(LA18_13>='-' && LA18_13<='9')||(LA18_13>=';' && LA18_13<='<')||(LA18_13>='?' && LA18_13<='Z')||LA18_13=='\\'||(LA18_13>='^' && LA18_13<='z')||(LA18_13>='~' && LA18_13<='\uFFFF')) && (((( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 33;}

                        else if ( (LA18_13=='*'||LA18_13==':'||(LA18_13>='=' && LA18_13<='>')||LA18_13=='['||LA18_13==']'||(LA18_13>='{' && LA18_13<='}')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 35;}

                        else if ( ((LA18_13>='(' && LA18_13<=')')||LA18_13==',') && ((( isOutValue() )&&( isValue() )))) {s = 34;}

                        else s = 39;

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_46 = input.LA(1);

                         
                        int index18_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isOutValue() )))) ) {s = 26;}

                        else if ( (( isOutValue() )) ) {s = 47;}

                         
                        input.seek(index18_46);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_53 = input.LA(1);

                         
                        int index18_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 49;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 47;}

                         
                        input.seek(index18_53);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA18_21 = input.LA(1);

                         
                        int index18_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {s = 26;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 37;}

                         
                        input.seek(index18_21);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA18_43 = input.LA(1);

                         
                        int index18_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() )||( isKey() ))))) ) {s = 26;}

                        else if ( ((( isInValue() )||( isOutValue() )||( isKey() ))) ) {s = 47;}

                         
                        input.seek(index18_43);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA18_52 = input.LA(1);

                         
                        int index18_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 50;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 47;}

                         
                        input.seek(index18_52);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA18_44 = input.LA(1);

                         
                        int index18_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( isInValue() )||( isOutValue() ))))) ) {s = 26;}

                        else if ( ((( isInValue() )||( isOutValue() ))) ) {s = 47;}

                         
                        input.seek(index18_44);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA18_32 = input.LA(1);

                         
                        int index18_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 51;}

                        else if ( (((( isOutValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))||(( isInValue() )&&( isValue() )))) ) {s = 47;}

                         
                        input.seek(index18_32);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA18_30 = input.LA(1);

                         
                        int index18_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_30>='\u0000' && LA18_30<='!')||(LA18_30>='#' && LA18_30<='\'')||LA18_30=='+'||(LA18_30>='-' && LA18_30<='9')||(LA18_30>=';' && LA18_30<='<')||(LA18_30>='?' && LA18_30<='Z')||LA18_30=='\\'||(LA18_30>='^' && LA18_30<='z')||(LA18_30>='~' && LA18_30<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))||(( isKey() )&&( isValue() ))))) {s = 33;}

                        else if ( ((LA18_30>='(' && LA18_30<=')')||LA18_30==',') && ((( isOutValue() )&&( isValue() )))) {s = 34;}

                        else if ( (LA18_30=='*'||LA18_30==':'||(LA18_30>='=' && LA18_30<='>')||LA18_30=='['||LA18_30==']'||(LA18_30>='{' && LA18_30<='}')) && (((( isInValue() )&&( isValue() ))||(( isOutValue() )&&( isValue() ))))) {s = 35;}

                        else s = 52;

                         
                        input.seek(index18_30);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA18_31 = input.LA(1);

                         
                        int index18_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA18_31>='\u0000' && LA18_31<='!')||(LA18_31>='#' && LA18_31<='\'')||(LA18_31>='*' && LA18_31<='+')||(LA18_31>='-' && LA18_31<='\uFFFF')) && (((( isOutValue() )&&( isValue() ))||(( isInValue() )&&( isValue() ))))) {s = 35;}

                        else if ( ((LA18_31>='(' && LA18_31<=')')||LA18_31==',') && ((( isOutValue() )&&( isValue() )))) {s = 34;}

                        else s = 53;

                         
                        input.seek(index18_31);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA18_41 = input.LA(1);

                         
                        int index18_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( isValue() )))) ) {s = 57;}

                        else if ( (( isValue() )) ) {s = 20;}

                         
                        input.seek(index18_41);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA18_27 = input.LA(1);

                         
                        int index18_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isHead() )) ) {s = 6;}

                        else if ( (( !isHead() )) ) {s = 48;}

                         
                        input.seek(index18_27);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA18_28 = input.LA(1);

                         
                        int index18_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_28=='>') && (( isHead() ))) {s = 49;}

                        else if ( (LA18_28=='-') && (( isHead() ))) {s = 50;}

                        else s = 51;

                         
                        input.seek(index18_28);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
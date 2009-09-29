// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 XPath.g 2009-09-29 14:52:04

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
// XPathLexer.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------

package org.xerial.lens.relation.query.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class XPathLexer extends Lexer {
    public static final int T__42=42;
    public static final int Digit=13;
    public static final int Frac=22;
    public static final int HexDigit=15;
    public static final int T__47=47;
    public static final int STEP=7;
    public static final int VALUE=6;
    public static final int T__39=39;
    public static final int Letter=14;
    public static final int PREDICATE=9;
    public static final int Comma=25;
    public static final int T__46=46;
    public static final int EscapeSequence=17;
    public static final int XPATH=4;
    public static final int Integer=21;
    public static final int WhiteSpace=30;
    public static final int T__34=34;
    public static final int AXIS=8;
    public static final int LineComment=11;
    public static final int Colon=26;
    public static final int T__35=35;
    public static final int SafeFirstLetter=28;
    public static final int T__36=36;
    public static final int Exp=23;
    public static final int QNameChar=31;
    public static final int T__44=44;
    public static final int UnicodeChar=16;
    public static final int StringChar=18;
    public static final int LineBreak=12;
    public static final int T__45=45;
    public static final int String=20;
    public static final int SafeLetter=29;
    public static final int LineBreakChar=10;
    public static final int T__43=43;
    public static final int QName=32;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int StringChar_s=19;
    public static final int UnsafeUnicodeChar=27;
    public static final int Double=24;
    public static final int NAME=5;
    public static final int T__41=41;
    public static final int WhiteSpaces=33;




    // delegates
    // delegators

    public XPathLexer() {;} 
    public XPathLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XPathLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "XPath.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:38:7: ( '/' )
            // XPath.g:38:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:39:7: ( '//' )
            // XPath.g:39:9: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:40:7: ( '@' )
            // XPath.g:40:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:41:7: ( '[' )
            // XPath.g:41:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:42:7: ( ']' )
            // XPath.g:42:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:43:7: ( '=' )
            // XPath.g:43:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:44:7: ( '!=' )
            // XPath.g:44:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:45:7: ( '>' )
            // XPath.g:45:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:46:7: ( '>=' )
            // XPath.g:46:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:47:7: ( '<' )
            // XPath.g:47:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:48:7: ( '<=' )
            // XPath.g:48:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:49:7: ( '~=' )
            // XPath.g:49:9: '~='
            {
            match("~="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:50:7: ( '(' )
            // XPath.g:50:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:51:7: ( ')' )
            // XPath.g:51:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // XPath.g:111:23: ( '\\n' | '\\r' )
            // XPath.g:
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

    // $ANTLR start "LineComment"
    public final void mLineComment() throws RecognitionException {
        try {
            int _type = LineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:112:12: ( '#' (~ ( LineBreakChar ) )* )
            // XPath.g:112:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // XPath.g:112:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // XPath.g:112:18: ~ ( LineBreakChar )
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

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LineComment"

    // $ANTLR start "LineBreak"
    public final void mLineBreak() throws RecognitionException {
        try {
            int _type = LineBreak;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:114:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // XPath.g:114:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // XPath.g:114:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // XPath.g:114:13: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // XPath.g:114:25: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // XPath.g:114:32: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LineBreak"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // XPath.g:116:15: ( '0' .. '9' )
            // XPath.g:116:17: '0' .. '9'
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
            // XPath.g:117:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // XPath.g:
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
            // XPath.g:118:18: ( Digit | Letter )
            // XPath.g:
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
            // XPath.g:119:21: (~ ( '\"' | '\\\\' ) )
            // XPath.g:119:23: ~ ( '\"' | '\\\\' )
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
            // XPath.g:121:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // XPath.g:121:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // XPath.g:121:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt3=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt3=1;
                }
                break;
            case '\\':
                {
                alt3=2;
                }
                break;
            case '/':
                {
                alt3=3;
                }
                break;
            case 'b':
                {
                alt3=4;
                }
                break;
            case 'f':
                {
                alt3=5;
                }
                break;
            case 'n':
                {
                alt3=6;
                }
                break;
            case 'r':
                {
                alt3=7;
                }
                break;
            case 't':
                {
                alt3=8;
                }
                break;
            case 'u':
                {
                alt3=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // XPath.g:121:11: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // XPath.g:121:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // XPath.g:121:25: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // XPath.g:121:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // XPath.g:121:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // XPath.g:121:43: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // XPath.g:121:49: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // XPath.g:121:55: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // XPath.g:121:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // XPath.g:124:21: ( UnicodeChar | EscapeSequence )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\\') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // XPath.g:124:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // XPath.g:124:38: EscapeSequence
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
            // XPath.g:125:22: ( ( StringChar )* )
            // XPath.g:125:24: ( StringChar )*
            {
            // XPath.g:125:24: ( StringChar )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // XPath.g:125:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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

            // XPath.g:127:7: ( '\"' s= StringChar_s '\"' )
            // XPath.g:127:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart355 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart355, getCharIndex()-1);
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

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:129:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // XPath.g:129:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // XPath.g:129:10: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // XPath.g:129:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // XPath.g:129:15: ( '0' | '1' .. '9' ( Digit )* )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='0') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='1' && LA8_0<='9')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // XPath.g:129:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // XPath.g:129:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // XPath.g:129:31: ( Digit )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // XPath.g:129:31: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Frac"
    public final void mFrac() throws RecognitionException {
        try {
            // XPath.g:130:14: ( '.' ( Digit )+ )
            // XPath.g:130:16: '.' ( Digit )+
            {
            match('.'); 
            // XPath.g:130:20: ( Digit )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // XPath.g:130:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Frac"

    // $ANTLR start "Exp"
    public final void mExp() throws RecognitionException {
        try {
            // XPath.g:131:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // XPath.g:131:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // XPath.g:131:27: ( '+' | '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='+'||LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // XPath.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // XPath.g:131:40: ( Digit )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // XPath.g:131:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exp"

    // $ANTLR start "Double"
    public final void mDouble() throws RecognitionException {
        try {
            int _type = Double;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:132:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // XPath.g:132:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); 
            // XPath.g:132:17: ( Frac ( Exp )? | Exp )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='.') ) {
                alt13=1;
            }
            else if ( (LA13_0=='E'||LA13_0=='e') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // XPath.g:132:18: Frac ( Exp )?
                    {
                    mFrac(); 
                    // XPath.g:132:23: ( Exp )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // XPath.g:132:23: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // XPath.g:132:30: Exp
                    {
                    mExp(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Double"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:136:6: ( ',' )
            // XPath.g:136:8: ','
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
            // XPath.g:137:6: ( ':' )
            // XPath.g:137:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "UnsafeUnicodeChar"
    public final void mUnsafeUnicodeChar() throws RecognitionException {
        try {
            // XPath.g:142:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
            // XPath.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='*')||(input.LA(1)>=',' && input.LA(1)<='.')||input.LA(1)==':'||input.LA(1)=='<'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
    // $ANTLR end "UnsafeUnicodeChar"

    // $ANTLR start "SafeFirstLetter"
    public final void mSafeFirstLetter() throws RecognitionException {
        try {
            // XPath.g:144:25: ( 'A' .. 'Z' | 'a' .. 'z' )
            // XPath.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "SafeFirstLetter"

    // $ANTLR start "SafeLetter"
    public final void mSafeLetter() throws RecognitionException {
        try {
            // XPath.g:145:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
            // XPath.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "SafeLetter"

    // $ANTLR start "QNameChar"
    public final void mQNameChar() throws RecognitionException {
        try {
            // XPath.g:147:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace | '/' | '//' ) )
            // XPath.g:147:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace | '/' | '//' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)==';'||input.LA(1)=='='||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "QNameChar"

    // $ANTLR start "QName"
    public final void mQName() throws RecognitionException {
        try {
            int _type = QName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:148:6: ( ( QNameChar )+ ( '.' ( QNameChar )+ )* )
            // XPath.g:148:8: ( QNameChar )+ ( '.' ( QNameChar )+ )*
            {
            // XPath.g:148:8: ( QNameChar )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||LA14_0=='$'||LA14_0=='&'||LA14_0=='+'||(LA14_0>='0' && LA14_0<='9')||LA14_0==';'||LA14_0=='='||LA14_0=='?'||(LA14_0>='A' && LA14_0<='Z')||(LA14_0>='^' && LA14_0<='z')||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // XPath.g:148:8: QNameChar
            	    {
            	    mQNameChar(); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // XPath.g:148:19: ( '.' ( QNameChar )+ )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='.') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // XPath.g:148:20: '.' ( QNameChar )+
            	    {
            	    match('.'); 
            	    // XPath.g:148:24: ( QNameChar )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||LA15_0=='$'||LA15_0=='&'||LA15_0=='+'||(LA15_0>='0' && LA15_0<='9')||LA15_0==';'||LA15_0=='='||LA15_0=='?'||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // XPath.g:148:24: QNameChar
            	    	    {
            	    	    mQNameChar(); 

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


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QName"

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            // XPath.g:152:11: ( ' ' | '\\t' )
            // XPath.g:
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

    // $ANTLR start "WhiteSpaces"
    public final void mWhiteSpaces() throws RecognitionException {
        try {
            int _type = WhiteSpaces;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // XPath.g:154:12: ( ( WhiteSpace )+ )
            // XPath.g:154:14: ( WhiteSpace )+
            {
            // XPath.g:154:14: ( WhiteSpace )+
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
            	    // XPath.g:154:14: WhiteSpace
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

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpaces"

    public void mTokens() throws RecognitionException {
        // XPath.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | LineComment | LineBreak | String | Integer | Double | Comma | Colon | QName | WhiteSpaces )
        int alt18=23;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // XPath.g:1:10: T__34
                {
                mT__34(); 

                }
                break;
            case 2 :
                // XPath.g:1:16: T__35
                {
                mT__35(); 

                }
                break;
            case 3 :
                // XPath.g:1:22: T__36
                {
                mT__36(); 

                }
                break;
            case 4 :
                // XPath.g:1:28: T__37
                {
                mT__37(); 

                }
                break;
            case 5 :
                // XPath.g:1:34: T__38
                {
                mT__38(); 

                }
                break;
            case 6 :
                // XPath.g:1:40: T__39
                {
                mT__39(); 

                }
                break;
            case 7 :
                // XPath.g:1:46: T__40
                {
                mT__40(); 

                }
                break;
            case 8 :
                // XPath.g:1:52: T__41
                {
                mT__41(); 

                }
                break;
            case 9 :
                // XPath.g:1:58: T__42
                {
                mT__42(); 

                }
                break;
            case 10 :
                // XPath.g:1:64: T__43
                {
                mT__43(); 

                }
                break;
            case 11 :
                // XPath.g:1:70: T__44
                {
                mT__44(); 

                }
                break;
            case 12 :
                // XPath.g:1:76: T__45
                {
                mT__45(); 

                }
                break;
            case 13 :
                // XPath.g:1:82: T__46
                {
                mT__46(); 

                }
                break;
            case 14 :
                // XPath.g:1:88: T__47
                {
                mT__47(); 

                }
                break;
            case 15 :
                // XPath.g:1:94: LineComment
                {
                mLineComment(); 

                }
                break;
            case 16 :
                // XPath.g:1:106: LineBreak
                {
                mLineBreak(); 

                }
                break;
            case 17 :
                // XPath.g:1:116: String
                {
                mString(); 

                }
                break;
            case 18 :
                // XPath.g:1:123: Integer
                {
                mInteger(); 

                }
                break;
            case 19 :
                // XPath.g:1:131: Double
                {
                mDouble(); 

                }
                break;
            case 20 :
                // XPath.g:1:138: Comma
                {
                mComma(); 

                }
                break;
            case 21 :
                // XPath.g:1:144: Colon
                {
                mColon(); 

                }
                break;
            case 22 :
                // XPath.g:1:150: QName
                {
                mQName(); 

                }
                break;
            case 23 :
                // XPath.g:1:156: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\1\27\3\uffff\1\30\1\24\1\33\1\35\1\24\6\uffff\2\41\7\uffff"+
        "\1\45\4\uffff\1\46\2\41\2\uffff\1\24\1\41\3\uffff\1\41\1\47\1\24"+
        "\1\47\2\24\1\47";
    static final String DFA18_eofS =
        "\57\uffff";
    static final String DFA18_minS =
        "\1\0\1\57\3\uffff\1\0\4\75\5\uffff\1\60\2\0\7\uffff\1\0\4\uffff"+
        "\1\0\2\56\1\uffff\1\0\1\53\1\0\3\uffff\1\56\1\0\1\60\1\0\1\53\1"+
        "\60\1\0";
    static final String DFA18_maxS =
        "\1\uffff\1\57\3\uffff\1\uffff\4\75\5\uffff\1\71\2\uffff\7\uffff"+
        "\1\uffff\4\uffff\1\uffff\2\145\1\uffff\1\uffff\1\71\1\uffff\3\uffff"+
        "\1\145\1\uffff\1\71\1\uffff\2\71\1\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\3\1\4\1\5\5\uffff\1\15\1\16\1\17\1\20\1\21\3\uffff\1"+
        "\24\1\25\1\26\1\27\1\2\1\1\1\6\1\uffff\1\11\1\10\1\13\1\12\3\uffff"+
        "\1\22\3\uffff\1\7\1\14\1\23\7\uffff";
    static final String DFA18_specialS =
        "\1\3\4\uffff\1\10\12\uffff\1\7\1\2\7\uffff\1\0\4\uffff\1\12\3\uffff"+
        "\1\5\1\uffff\1\1\4\uffff\1\11\1\uffff\1\4\2\uffff\1\6}>";
    static final String[] DFA18_transitionS = {
            "\11\24\1\25\1\15\2\24\1\15\22\24\1\25\1\6\1\16\1\14\1\24\1"+
            "\uffff\1\24\1\uffff\1\12\1\13\1\uffff\1\24\1\22\1\17\1\uffff"+
            "\1\1\1\20\11\21\1\23\1\24\1\10\1\5\1\7\1\24\1\2\32\24\1\3\1"+
            "\uffff\1\4\35\24\3\uffff\1\11\uff81\24",
            "\1\26",
            "",
            "",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\24\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24"+
            "\3\uffff\uff82\24",
            "\1\31",
            "\1\32",
            "\1\34",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "\1\37\11\40",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\42\1\uffff\12\24\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\4\24\1\43\25\24\3\uffff"+
            "\7\24\1\43\25\24\3\uffff\uff82\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\42\1\uffff\12\44\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\4\24\1\43\25\24\3\uffff"+
            "\7\24\1\43\25\24\3\uffff\uff82\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\24\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24"+
            "\3\uffff\uff82\24",
            "",
            "",
            "",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\24\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24"+
            "\3\uffff\uff82\24",
            "\1\47\26\uffff\1\47\37\uffff\1\47",
            "\1\47\1\uffff\12\50\13\uffff\1\47\37\uffff\1\47",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\4\uffff\12\51\1\uffff\1\24\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24\3\uffff\uff82"+
            "\24",
            "\1\52\1\uffff\1\47\2\uffff\12\53",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\42\1\uffff\12\44\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\4\24\1\43\25\24\3\uffff"+
            "\7\24\1\43\25\24\3\uffff\uff82\24",
            "",
            "",
            "",
            "\1\47\1\uffff\12\50\13\uffff\1\47\37\uffff\1\47",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\51\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\4\24\1\54\25\24\3\uffff"+
            "\7\24\1\54\25\24\3\uffff\uff82\24",
            "\12\53",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\53\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24"+
            "\3\uffff\uff82\24",
            "\1\55\1\uffff\1\47\2\uffff\12\56",
            "\12\56",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\1\24\2\uffff\1\24"+
            "\1\uffff\1\24\4\uffff\1\24\2\uffff\1\24\1\uffff\12\56\1\uffff"+
            "\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\32\24\3\uffff\35\24"+
            "\3\uffff\uff82\24"
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
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | LineComment | LineBreak | String | Integer | Double | Comma | Colon | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_25 = input.LA(1);

                        s = -1;
                        if ( ((LA18_25>='\u0000' && LA18_25<='\b')||(LA18_25>='\u000B' && LA18_25<='\f')||(LA18_25>='\u000E' && LA18_25<='\u001F')||LA18_25=='!'||LA18_25=='$'||LA18_25=='&'||LA18_25=='+'||LA18_25=='.'||(LA18_25>='0' && LA18_25<='9')||LA18_25==';'||LA18_25=='='||LA18_25=='?'||(LA18_25>='A' && LA18_25<='Z')||(LA18_25>='^' && LA18_25<='z')||(LA18_25>='~' && LA18_25<='\uFFFF')) ) {s = 20;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_36 = input.LA(1);

                        s = -1;
                        if ( ((LA18_36>='0' && LA18_36<='9')) ) {s = 36;}

                        else if ( (LA18_36=='.') ) {s = 34;}

                        else if ( (LA18_36=='E'||LA18_36=='e') ) {s = 35;}

                        else if ( ((LA18_36>='\u0000' && LA18_36<='\b')||(LA18_36>='\u000B' && LA18_36<='\f')||(LA18_36>='\u000E' && LA18_36<='\u001F')||LA18_36=='!'||LA18_36=='$'||LA18_36=='&'||LA18_36=='+'||LA18_36==';'||LA18_36=='='||LA18_36=='?'||(LA18_36>='A' && LA18_36<='D')||(LA18_36>='F' && LA18_36<='Z')||(LA18_36>='^' && LA18_36<='d')||(LA18_36>='f' && LA18_36<='z')||(LA18_36>='~' && LA18_36<='\uFFFF')) ) {s = 20;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_17 = input.LA(1);

                        s = -1;
                        if ( (LA18_17=='.') ) {s = 34;}

                        else if ( ((LA18_17>='0' && LA18_17<='9')) ) {s = 36;}

                        else if ( (LA18_17=='E'||LA18_17=='e') ) {s = 35;}

                        else if ( ((LA18_17>='\u0000' && LA18_17<='\b')||(LA18_17>='\u000B' && LA18_17<='\f')||(LA18_17>='\u000E' && LA18_17<='\u001F')||LA18_17=='!'||LA18_17=='$'||LA18_17=='&'||LA18_17=='+'||LA18_17==';'||LA18_17=='='||LA18_17=='?'||(LA18_17>='A' && LA18_17<='D')||(LA18_17>='F' && LA18_17<='Z')||(LA18_17>='^' && LA18_17<='d')||(LA18_17>='f' && LA18_17<='z')||(LA18_17>='~' && LA18_17<='\uFFFF')) ) {s = 20;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='/') ) {s = 1;}

                        else if ( (LA18_0=='@') ) {s = 2;}

                        else if ( (LA18_0=='[') ) {s = 3;}

                        else if ( (LA18_0==']') ) {s = 4;}

                        else if ( (LA18_0=='=') ) {s = 5;}

                        else if ( (LA18_0=='!') ) {s = 6;}

                        else if ( (LA18_0=='>') ) {s = 7;}

                        else if ( (LA18_0=='<') ) {s = 8;}

                        else if ( (LA18_0=='~') ) {s = 9;}

                        else if ( (LA18_0=='(') ) {s = 10;}

                        else if ( (LA18_0==')') ) {s = 11;}

                        else if ( (LA18_0=='#') ) {s = 12;}

                        else if ( (LA18_0=='\n'||LA18_0=='\r') ) {s = 13;}

                        else if ( (LA18_0=='\"') ) {s = 14;}

                        else if ( (LA18_0=='-') ) {s = 15;}

                        else if ( (LA18_0=='0') ) {s = 16;}

                        else if ( ((LA18_0>='1' && LA18_0<='9')) ) {s = 17;}

                        else if ( (LA18_0==',') ) {s = 18;}

                        else if ( (LA18_0==':') ) {s = 19;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='$'||LA18_0=='&'||LA18_0=='+'||LA18_0==';'||LA18_0=='?'||(LA18_0>='A' && LA18_0<='Z')||(LA18_0>='^' && LA18_0<='z')||(LA18_0>='\u007F' && LA18_0<='\uFFFF')) ) {s = 20;}

                        else if ( (LA18_0=='\t'||LA18_0==' ') ) {s = 21;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_43 = input.LA(1);

                        s = -1;
                        if ( ((LA18_43>='\u0000' && LA18_43<='\b')||(LA18_43>='\u000B' && LA18_43<='\f')||(LA18_43>='\u000E' && LA18_43<='\u001F')||LA18_43=='!'||LA18_43=='$'||LA18_43=='&'||LA18_43=='+'||LA18_43=='.'||LA18_43==';'||LA18_43=='='||LA18_43=='?'||(LA18_43>='A' && LA18_43<='Z')||(LA18_43>='^' && LA18_43<='z')||(LA18_43>='~' && LA18_43<='\uFFFF')) ) {s = 20;}

                        else if ( ((LA18_43>='0' && LA18_43<='9')) ) {s = 43;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_34 = input.LA(1);

                        s = -1;
                        if ( ((LA18_34>='0' && LA18_34<='9')) ) {s = 41;}

                        else if ( ((LA18_34>='\u0000' && LA18_34<='\b')||(LA18_34>='\u000B' && LA18_34<='\f')||(LA18_34>='\u000E' && LA18_34<='\u001F')||LA18_34=='!'||LA18_34=='$'||LA18_34=='&'||LA18_34=='+'||LA18_34==';'||LA18_34=='='||LA18_34=='?'||(LA18_34>='A' && LA18_34<='Z')||(LA18_34>='^' && LA18_34<='z')||(LA18_34>='~' && LA18_34<='\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_46 = input.LA(1);

                        s = -1;
                        if ( ((LA18_46>='\u0000' && LA18_46<='\b')||(LA18_46>='\u000B' && LA18_46<='\f')||(LA18_46>='\u000E' && LA18_46<='\u001F')||LA18_46=='!'||LA18_46=='$'||LA18_46=='&'||LA18_46=='+'||LA18_46=='.'||LA18_46==';'||LA18_46=='='||LA18_46=='?'||(LA18_46>='A' && LA18_46<='Z')||(LA18_46>='^' && LA18_46<='z')||(LA18_46>='~' && LA18_46<='\uFFFF')) ) {s = 20;}

                        else if ( ((LA18_46>='0' && LA18_46<='9')) ) {s = 46;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_16 = input.LA(1);

                        s = -1;
                        if ( (LA18_16=='.') ) {s = 34;}

                        else if ( (LA18_16=='E'||LA18_16=='e') ) {s = 35;}

                        else if ( ((LA18_16>='\u0000' && LA18_16<='\b')||(LA18_16>='\u000B' && LA18_16<='\f')||(LA18_16>='\u000E' && LA18_16<='\u001F')||LA18_16=='!'||LA18_16=='$'||LA18_16=='&'||LA18_16=='+'||(LA18_16>='0' && LA18_16<='9')||LA18_16==';'||LA18_16=='='||LA18_16=='?'||(LA18_16>='A' && LA18_16<='D')||(LA18_16>='F' && LA18_16<='Z')||(LA18_16>='^' && LA18_16<='d')||(LA18_16>='f' && LA18_16<='z')||(LA18_16>='~' && LA18_16<='\uFFFF')) ) {s = 20;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_5 = input.LA(1);

                        s = -1;
                        if ( ((LA18_5>='\u0000' && LA18_5<='\b')||(LA18_5>='\u000B' && LA18_5<='\f')||(LA18_5>='\u000E' && LA18_5<='\u001F')||LA18_5=='!'||LA18_5=='$'||LA18_5=='&'||LA18_5=='+'||LA18_5=='.'||(LA18_5>='0' && LA18_5<='9')||LA18_5==';'||LA18_5=='='||LA18_5=='?'||(LA18_5>='A' && LA18_5<='Z')||(LA18_5>='^' && LA18_5<='z')||(LA18_5>='~' && LA18_5<='\uFFFF')) ) {s = 20;}

                        else s = 24;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_41 = input.LA(1);

                        s = -1;
                        if ( ((LA18_41>='\u0000' && LA18_41<='\b')||(LA18_41>='\u000B' && LA18_41<='\f')||(LA18_41>='\u000E' && LA18_41<='\u001F')||LA18_41=='!'||LA18_41=='$'||LA18_41=='&'||LA18_41=='+'||LA18_41=='.'||LA18_41==';'||LA18_41=='='||LA18_41=='?'||(LA18_41>='A' && LA18_41<='D')||(LA18_41>='F' && LA18_41<='Z')||(LA18_41>='^' && LA18_41<='d')||(LA18_41>='f' && LA18_41<='z')||(LA18_41>='~' && LA18_41<='\uFFFF')) ) {s = 20;}

                        else if ( (LA18_41=='E'||LA18_41=='e') ) {s = 44;}

                        else if ( ((LA18_41>='0' && LA18_41<='9')) ) {s = 41;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_30 = input.LA(1);

                        s = -1;
                        if ( ((LA18_30>='\u0000' && LA18_30<='\b')||(LA18_30>='\u000B' && LA18_30<='\f')||(LA18_30>='\u000E' && LA18_30<='\u001F')||LA18_30=='!'||LA18_30=='$'||LA18_30=='&'||LA18_30=='+'||LA18_30=='.'||(LA18_30>='0' && LA18_30<='9')||LA18_30==';'||LA18_30=='='||LA18_30=='?'||(LA18_30>='A' && LA18_30<='Z')||(LA18_30>='^' && LA18_30<='z')||(LA18_30>='~' && LA18_30<='\uFFFF')) ) {s = 20;}

                        else s = 38;

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
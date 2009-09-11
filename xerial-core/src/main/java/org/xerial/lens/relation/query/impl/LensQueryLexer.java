// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 LensQuery.g 2009-09-10 16:56:16

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
// LensQueryLexer.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------

package org.xerial.lens.relation.query.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LensQueryLexer extends Lexer {
    public static final int INDEX=15;
    public static final int PATTERNMATCH=9;
    public static final int Match=44;
    public static final int RBrace=35;
    public static final int LBracket=36;
    public static final int Regex=45;
    public static final int Digit=19;
    public static final int Frac=28;
    public static final int HexDigit=21;
    public static final int QUERY=4;
    public static final int ALIAS=11;
    public static final int VALUE=14;
    public static final int Letter=20;
    public static final int Comma=47;
    public static final int Dot=46;
    public static final int EscapeSequence=23;
    public static final int Integer=27;
    public static final int WhiteSpace=56;
    public static final int OPERATOR=7;
    public static final int False=32;
    public static final int Colon=48;
    public static final int LineComment=17;
    public static final int NODEVALUE=12;
    public static final int As=49;
    public static final int SafeFirstLetter=54;
    public static final int Null=33;
    public static final int Star=52;
    public static final int Eq=42;
    public static final int Exp=29;
    public static final int QNameChar=57;
    public static final int RELATION=5;
    public static final int Gt=39;
    public static final int RParen=51;
    public static final int UnicodeChar=22;
    public static final int StringChar=24;
    public static final int True=31;
    public static final int OPERAND=8;
    public static final int LineBreak=18;
    public static final int LParen=50;
    public static final int String=26;
    public static final int SafeLetter=55;
    public static final int LineBreakChar=16;
    public static final int COMPARE=6;
    public static final int QName=58;
    public static final int Geq=41;
    public static final int EOF=-1;
    public static final int NODE=10;
    public static final int Neq=43;
    public static final int StringChar_s=25;
    public static final int UnsafeUnicodeChar=53;
    public static final int LBrace=34;
    public static final int Double=30;
    public static final int Lt=38;
    public static final int RBracket=37;
    public static final int NAME=13;
    public static final int Leq=40;
    public static final int WhiteSpaces=59;




    // delegates
    // delegators

    public LensQueryLexer() {;} 
    public LensQueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LensQueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "LensQuery.g"; }

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // LensQuery.g:116:23: ( '\\n' | '\\r' )
            // LensQuery.g:
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
            // LensQuery.g:117:12: ( '#' (~ ( LineBreakChar ) )* )
            // LensQuery.g:117:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // LensQuery.g:117:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // LensQuery.g:117:18: ~ ( LineBreakChar )
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
            // LensQuery.g:120:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // LensQuery.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // LensQuery.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // LensQuery.g:120:13: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:120:25: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // LensQuery.g:120:32: '\\n'
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
            // LensQuery.g:123:15: ( '0' .. '9' )
            // LensQuery.g:123:17: '0' .. '9'
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
            // LensQuery.g:124:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // LensQuery.g:
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
            // LensQuery.g:125:18: ( Digit | Letter )
            // LensQuery.g:
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
            // LensQuery.g:126:21: (~ ( '\"' | '\\\\' ) )
            // LensQuery.g:126:23: ~ ( '\"' | '\\\\' )
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
            // LensQuery.g:128:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // LensQuery.g:128:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // LensQuery.g:128:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // LensQuery.g:128:11: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:128:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // LensQuery.g:128:25: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // LensQuery.g:128:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // LensQuery.g:128:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // LensQuery.g:128:43: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // LensQuery.g:128:49: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // LensQuery.g:128:55: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // LensQuery.g:128:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // LensQuery.g:131:21: ( UnicodeChar | EscapeSequence )
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
                    // LensQuery.g:131:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:131:38: EscapeSequence
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
            // LensQuery.g:132:22: ( ( StringChar )* )
            // LensQuery.g:132:24: ( StringChar )*
            {
            // LensQuery.g:132:24: ( StringChar )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // LensQuery.g:132:24: StringChar
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

            // LensQuery.g:134:7: ( '\"' s= StringChar_s '\"' )
            // LensQuery.g:134:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart244 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart244, getCharIndex()-1);
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
            // LensQuery.g:137:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // LensQuery.g:137:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // LensQuery.g:137:10: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // LensQuery.g:137:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // LensQuery.g:137:15: ( '0' | '1' .. '9' ( Digit )* )
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
                    // LensQuery.g:137:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:137:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // LensQuery.g:137:31: ( Digit )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // LensQuery.g:137:31: Digit
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
            // LensQuery.g:138:14: ( '.' ( Digit )+ )
            // LensQuery.g:138:16: '.' ( Digit )+
            {
            match('.'); 
            // LensQuery.g:138:20: ( Digit )+
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
            	    // LensQuery.g:138:20: Digit
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
            // LensQuery.g:139:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // LensQuery.g:139:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // LensQuery.g:139:27: ( '+' | '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='+'||LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // LensQuery.g:
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

            // LensQuery.g:139:40: ( Digit )+
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
            	    // LensQuery.g:139:40: Digit
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
            // LensQuery.g:140:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // LensQuery.g:140:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); 
            // LensQuery.g:140:17: ( Frac ( Exp )? | Exp )
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
                    // LensQuery.g:140:18: Frac ( Exp )?
                    {
                    mFrac(); 
                    // LensQuery.g:140:23: ( Exp )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // LensQuery.g:140:23: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // LensQuery.g:140:30: Exp
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

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:142:5: ( 'true' )
            // LensQuery.g:142:7: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:143:6: ( 'false' )
            // LensQuery.g:143:8: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:144:5: ( 'null' )
            // LensQuery.g:144:7: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Null"

    // $ANTLR start "LBrace"
    public final void mLBrace() throws RecognitionException {
        try {
            int _type = LBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:146:7: ( '{' )
            // LensQuery.g:146:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBrace"

    // $ANTLR start "RBrace"
    public final void mRBrace() throws RecognitionException {
        try {
            int _type = RBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:147:7: ( '}' )
            // LensQuery.g:147:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBrace"

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:148:9: ( '[' )
            // LensQuery.g:148:11: '['
            {
            match('['); 

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
            // LensQuery.g:149:9: ( ']' )
            // LensQuery.g:149:11: ']'
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

    // $ANTLR start "Lt"
    public final void mLt() throws RecognitionException {
        try {
            int _type = Lt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:152:3: ( '<' )
            // LensQuery.g:152:5: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lt"

    // $ANTLR start "Gt"
    public final void mGt() throws RecognitionException {
        try {
            int _type = Gt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:153:3: ( '>' )
            // LensQuery.g:153:5: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Gt"

    // $ANTLR start "Leq"
    public final void mLeq() throws RecognitionException {
        try {
            int _type = Leq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:154:4: ( '<=' )
            // LensQuery.g:154:6: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Leq"

    // $ANTLR start "Geq"
    public final void mGeq() throws RecognitionException {
        try {
            int _type = Geq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:155:4: ( '>=' )
            // LensQuery.g:155:6: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Geq"

    // $ANTLR start "Eq"
    public final void mEq() throws RecognitionException {
        try {
            int _type = Eq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:156:3: ( '=' )
            // LensQuery.g:156:5: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Eq"

    // $ANTLR start "Neq"
    public final void mNeq() throws RecognitionException {
        try {
            int _type = Neq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:157:4: ( '!=' )
            // LensQuery.g:157:6: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Neq"

    // $ANTLR start "Match"
    public final void mMatch() throws RecognitionException {
        try {
            int _type = Match;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:158:6: ( '~=' )
            // LensQuery.g:158:8: '~='
            {
            match("~="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Match"

    // $ANTLR start "Regex"
    public final void mRegex() throws RecognitionException {
        try {
            int _type = Regex;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:159:6: ( '/' ( options {greedy=false; } : . )* '/' ( 'a' .. 'z' | 'A' .. 'Z' )* )
            // LensQuery.g:159:8: '/' ( options {greedy=false; } : . )* '/' ( 'a' .. 'z' | 'A' .. 'Z' )*
            {
            match('/'); 
            // LensQuery.g:159:13: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='/') ) {
                    alt14=2;
                }
                else if ( ((LA14_0>='\u0000' && LA14_0<='.')||(LA14_0>='0' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // LensQuery.g:159:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match('/'); 
            // LensQuery.g:159:46: ( 'a' .. 'z' | 'A' .. 'Z' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='A' && LA15_0<='Z')||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // LensQuery.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Regex"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:161:4: ( '.' )
            // LensQuery.g:161:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dot"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:162:6: ( ',' )
            // LensQuery.g:162:8: ','
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
            // LensQuery.g:163:6: ( ':' )
            // LensQuery.g:163:8: ':'
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

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:165:3: ( 'as' )
            // LensQuery.g:165:5: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:167:7: ( '(' )
            // LensQuery.g:167:9: '('
            {
            match('('); 

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
            // LensQuery.g:168:7: ( ')' )
            // LensQuery.g:168:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RParen"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:170:5: ( '*' )
            // LensQuery.g:170:7: '*'
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

    // $ANTLR start "UnsafeUnicodeChar"
    public final void mUnsafeUnicodeChar() throws RecognitionException {
        try {
            // LensQuery.g:173:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
            // LensQuery.g:
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
            // LensQuery.g:175:25: ( 'A' .. 'Z' | 'a' .. 'z' )
            // LensQuery.g:
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
            // LensQuery.g:176:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
            // LensQuery.g:
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
            // LensQuery.g:179:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // LensQuery.g:179:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)==';'||input.LA(1)=='='||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // LensQuery.g:180:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // LensQuery.g:180:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // LensQuery.g:180:8: ( QNameChar )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||LA16_0=='+'||(LA16_0>='/' && LA16_0<='9')||LA16_0==';'||LA16_0=='='||LA16_0=='?'||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // LensQuery.g:180:8: QNameChar
            	    {
            	    mQNameChar(); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // LensQuery.g:180:19: ( Dot ( QNameChar )+ )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // LensQuery.g:180:20: Dot ( QNameChar )+
            	    {
            	    mDot(); 
            	    // LensQuery.g:180:24: ( QNameChar )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||LA17_0=='$'||LA17_0=='&'||LA17_0=='+'||(LA17_0>='/' && LA17_0<='9')||LA17_0==';'||LA17_0=='='||LA17_0=='?'||(LA17_0>='A' && LA17_0<='Z')||(LA17_0>='^' && LA17_0<='z')||(LA17_0>='~' && LA17_0<='\uFFFF')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // LensQuery.g:180:24: QNameChar
            	    	    {
            	    	    mQNameChar(); 

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


            	    }
            	    break;

            	default :
            	    break loop18;
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
            // LensQuery.g:184:11: ( ' ' | '\\t' )
            // LensQuery.g:
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
            // LensQuery.g:186:12: ( ( WhiteSpace )+ )
            // LensQuery.g:186:14: ( WhiteSpace )+
            {
            // LensQuery.g:186:14: ( WhiteSpace )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // LensQuery.g:186:14: WhiteSpace
            	    {
            	    mWhiteSpace(); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
        // LensQuery.g:1:8: ( LineComment | LineBreak | String | Integer | Double | True | False | Null | LBrace | RBrace | LBracket | RBracket | Lt | Gt | Leq | Geq | Eq | Neq | Match | Regex | Dot | Comma | Colon | As | LParen | RParen | Star | QName | WhiteSpaces )
        int alt20=29;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // LensQuery.g:1:10: LineComment
                {
                mLineComment(); 

                }
                break;
            case 2 :
                // LensQuery.g:1:22: LineBreak
                {
                mLineBreak(); 

                }
                break;
            case 3 :
                // LensQuery.g:1:32: String
                {
                mString(); 

                }
                break;
            case 4 :
                // LensQuery.g:1:39: Integer
                {
                mInteger(); 

                }
                break;
            case 5 :
                // LensQuery.g:1:47: Double
                {
                mDouble(); 

                }
                break;
            case 6 :
                // LensQuery.g:1:54: True
                {
                mTrue(); 

                }
                break;
            case 7 :
                // LensQuery.g:1:59: False
                {
                mFalse(); 

                }
                break;
            case 8 :
                // LensQuery.g:1:65: Null
                {
                mNull(); 

                }
                break;
            case 9 :
                // LensQuery.g:1:70: LBrace
                {
                mLBrace(); 

                }
                break;
            case 10 :
                // LensQuery.g:1:77: RBrace
                {
                mRBrace(); 

                }
                break;
            case 11 :
                // LensQuery.g:1:84: LBracket
                {
                mLBracket(); 

                }
                break;
            case 12 :
                // LensQuery.g:1:93: RBracket
                {
                mRBracket(); 

                }
                break;
            case 13 :
                // LensQuery.g:1:102: Lt
                {
                mLt(); 

                }
                break;
            case 14 :
                // LensQuery.g:1:105: Gt
                {
                mGt(); 

                }
                break;
            case 15 :
                // LensQuery.g:1:108: Leq
                {
                mLeq(); 

                }
                break;
            case 16 :
                // LensQuery.g:1:112: Geq
                {
                mGeq(); 

                }
                break;
            case 17 :
                // LensQuery.g:1:116: Eq
                {
                mEq(); 

                }
                break;
            case 18 :
                // LensQuery.g:1:119: Neq
                {
                mNeq(); 

                }
                break;
            case 19 :
                // LensQuery.g:1:123: Match
                {
                mMatch(); 

                }
                break;
            case 20 :
                // LensQuery.g:1:129: Regex
                {
                mRegex(); 

                }
                break;
            case 21 :
                // LensQuery.g:1:135: Dot
                {
                mDot(); 

                }
                break;
            case 22 :
                // LensQuery.g:1:139: Comma
                {
                mComma(); 

                }
                break;
            case 23 :
                // LensQuery.g:1:145: Colon
                {
                mColon(); 

                }
                break;
            case 24 :
                // LensQuery.g:1:151: As
                {
                mAs(); 

                }
                break;
            case 25 :
                // LensQuery.g:1:154: LParen
                {
                mLParen(); 

                }
                break;
            case 26 :
                // LensQuery.g:1:161: RParen
                {
                mRParen(); 

                }
                break;
            case 27 :
                // LensQuery.g:1:168: Star
                {
                mStar(); 

                }
                break;
            case 28 :
                // LensQuery.g:1:173: QName
                {
                mQName(); 

                }
                break;
            case 29 :
                // LensQuery.g:1:179: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\5\uffff\2\37\3\33\4\uffff\1\47\1\51\1\52\3\33\3\uffff\1\33\5\uffff"+
        "\2\37\2\uffff\1\33\1\37\3\33\5\uffff\1\72\1\73\1\uffff\1\57\1\uffff"+
        "\1\33\1\77\1\uffff\1\37\1\62\1\33\1\62\3\33\2\uffff\1\57\1\33\1"+
        "\57\1\uffff\1\33\1\107\1\33\1\111\1\57\1\33\1\62\1\uffff\1\112\2"+
        "\uffff";
    static final String DFA20_eofS =
        "\113\uffff";
    static final String DFA20_minS =
        "\1\0\3\uffff\1\60\2\0\1\162\1\141\1\165\4\uffff\2\75\1\0\2\75\1"+
        "\0\3\uffff\1\163\5\uffff\2\56\1\uffff\1\0\1\53\1\0\1\165\2\154\5"+
        "\uffff\4\0\1\uffff\2\0\1\uffff\1\56\1\0\1\60\1\0\1\145\1\163\1\154"+
        "\2\uffff\3\0\1\uffff\1\53\1\0\1\145\2\0\1\60\1\0\1\uffff\1\0\2\uffff";
    static final String DFA20_maxS =
        "\1\uffff\3\uffff\1\71\2\uffff\1\162\1\141\1\165\4\uffff\2\75\1"+
        "\uffff\2\75\1\uffff\3\uffff\1\163\5\uffff\2\145\1\uffff\1\uffff"+
        "\1\71\1\uffff\1\165\2\154\5\uffff\4\uffff\1\uffff\2\uffff\1\uffff"+
        "\1\145\1\uffff\1\71\1\uffff\1\145\1\163\1\154\2\uffff\3\uffff\1"+
        "\uffff\1\71\1\uffff\1\145\2\uffff\1\71\1\uffff\1\uffff\1\uffff\2"+
        "\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\6\uffff\1\11\1\12\1\13\1\14\6\uffff\1\25\1"+
        "\26\1\27\1\uffff\1\31\1\32\1\33\1\34\1\35\2\uffff\1\4\6\uffff\1"+
        "\17\1\15\1\20\1\16\1\21\4\uffff\1\24\2\uffff\1\5\7\uffff\1\22\1"+
        "\23\3\uffff\1\30\7\uffff\1\6\1\uffff\1\10\1\7";
    static final String DFA20_specialS =
        "\1\0\4\uffff\1\20\1\1\11\uffff\1\21\2\uffff\1\22\14\uffff\1\6\1"+
        "\uffff\1\25\10\uffff\1\2\1\17\1\12\1\24\1\uffff\1\14\1\16\2\uffff"+
        "\1\11\1\uffff\1\10\5\uffff\1\5\1\26\1\23\2\uffff\1\3\1\uffff\1\4"+
        "\1\13\1\uffff\1\15\1\uffff\1\7\2\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\33\1\34\1\2\2\33\1\2\22\33\1\34\1\21\1\3\1\1\1\33\1\uffff"+
            "\1\33\1\uffff\1\30\1\31\1\32\1\33\1\25\1\4\1\24\1\23\1\5\11"+
            "\6\1\26\1\33\1\16\1\20\1\17\1\33\1\uffff\32\33\1\14\1\uffff"+
            "\1\15\3\33\1\27\4\33\1\10\7\33\1\11\5\33\1\7\6\33\1\12\1\uffff"+
            "\1\13\1\22\uff81\33",
            "",
            "",
            "",
            "\1\35\11\36",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\1\40\13\33\1\uffff\1\33\1"+
            "\uffff\1\33\1\uffff\1\33\1\uffff\4\33\1\41\25\33\3\uffff\7\33"+
            "\1\41\25\33\3\uffff\uff82\33",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\1\40\1\33\12\42\1\uffff\1"+
            "\33\1\uffff\1\33\1\uffff\1\33\1\uffff\4\33\1\41\25\33\3\uffff"+
            "\7\33\1\41\25\33\3\uffff\uff82\33",
            "\1\43",
            "\1\44",
            "\1\45",
            "",
            "",
            "",
            "",
            "\1\46",
            "\1\50",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "\1\53",
            "\1\54",
            "\11\60\2\57\2\60\1\57\22\60\1\57\1\60\2\57\1\60\1\57\1\60"+
            "\4\57\1\60\2\57\1\55\1\56\12\60\1\57\1\60\1\57\1\60\1\57\1\60"+
            "\1\57\32\60\3\57\35\60\3\57\uff82\60",
            "",
            "",
            "",
            "\1\61",
            "",
            "",
            "",
            "",
            "",
            "\1\62\26\uffff\1\62\37\uffff\1\62",
            "\1\62\1\uffff\12\63\13\uffff\1\62\37\uffff\1\62",
            "",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\3\uffff\1\33\12\64\1\uffff\1\33\1"+
            "\uffff\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff"+
            "\uff82\33",
            "\1\65\1\uffff\1\62\2\uffff\12\66",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\1\40\1\33\12\42\1\uffff\1"+
            "\33\1\uffff\1\33\1\uffff\1\33\1\uffff\4\33\1\41\25\33\3\uffff"+
            "\7\33\1\41\25\33\3\uffff\uff82\33",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "",
            "",
            "",
            "",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "\11\75\2\57\2\75\1\57\22\75\1\57\1\75\2\57\1\75\1\57\1\75"+
            "\4\57\1\75\3\57\1\74\12\75\1\57\1\75\1\57\1\75\1\57\1\75\1\57"+
            "\32\75\3\57\35\75\3\57\uff82\75",
            "\11\60\2\uffff\2\60\1\uffff\22\60\1\uffff\1\60\2\uffff\1\60"+
            "\1\uffff\1\60\4\uffff\1\60\2\uffff\1\55\1\56\12\60\1\uffff\1"+
            "\60\1\uffff\1\60\1\uffff\1\60\1\uffff\32\76\3\uffff\3\60\32"+
            "\76\3\uffff\uff82\60",
            "",
            "\11\60\2\57\2\60\1\57\22\60\1\57\1\60\2\57\1\60\1\57\1\60"+
            "\4\57\1\60\2\57\1\55\1\56\12\60\1\57\1\60\1\57\1\60\1\57\1\60"+
            "\1\57\32\60\3\57\35\60\3\57\uff82\60",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "",
            "\1\62\1\uffff\12\63\13\uffff\1\62\37\uffff\1\62",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\2\33\12\64\1\uffff\1\33\1"+
            "\uffff\1\33\1\uffff\1\33\1\uffff\4\33\1\100\25\33\3\uffff\7"+
            "\33\1\100\25\33\3\uffff\uff82\33",
            "\12\66",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\2\33\12\66\1\uffff\1\33\1"+
            "\uffff\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff"+
            "\uff82\33",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "",
            "\11\75\2\uffff\2\75\1\uffff\22\75\1\uffff\1\75\2\uffff\1\75"+
            "\1\uffff\1\75\4\uffff\1\75\2\uffff\1\55\1\74\12\75\1\uffff\1"+
            "\75\1\uffff\1\75\1\uffff\1\75\1\uffff\32\104\3\uffff\3\75\32"+
            "\104\3\uffff\uff82\75",
            "\11\75\2\57\2\75\1\57\22\75\1\57\1\75\2\57\1\75\1\57\1\75"+
            "\4\57\1\75\2\57\1\55\1\74\12\75\1\57\1\75\1\57\1\75\1\57\1\75"+
            "\1\57\32\75\3\57\35\75\3\57\uff82\75",
            "\11\60\2\uffff\2\60\1\uffff\22\60\1\uffff\1\60\2\uffff\1\60"+
            "\1\uffff\1\60\4\uffff\1\60\2\uffff\1\55\1\56\12\60\1\uffff\1"+
            "\60\1\uffff\1\60\1\uffff\1\60\1\uffff\32\76\3\uffff\3\60\32"+
            "\76\3\uffff\uff82\60",
            "",
            "\1\105\1\uffff\1\62\2\uffff\12\106",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "\1\110",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "\11\75\2\uffff\2\75\1\uffff\22\75\1\uffff\1\75\2\uffff\1\75"+
            "\1\uffff\1\75\4\uffff\1\75\2\uffff\1\55\1\74\12\75\1\uffff\1"+
            "\75\1\uffff\1\75\1\uffff\1\75\1\uffff\32\104\3\uffff\3\75\32"+
            "\104\3\uffff\uff82\75",
            "\12\106",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\2\33\12\106\1\uffff\1\33"+
            "\1\uffff\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff"+
            "\uff82\33",
            "",
            "\11\33\2\uffff\2\33\1\uffff\22\33\1\uffff\1\33\2\uffff\1\33"+
            "\1\uffff\1\33\4\uffff\1\33\2\uffff\14\33\1\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\32\33\3\uffff\35\33\3\uffff\uff82"+
            "\33",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LineComment | LineBreak | String | Integer | Double | True | False | Null | LBrace | RBrace | LBracket | RBracket | Lt | Gt | Leq | Geq | Eq | Neq | Match | Regex | Dot | Comma | Colon | As | LParen | RParen | Star | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_0 = input.LA(1);

                        s = -1;
                        if ( (LA20_0=='#') ) {s = 1;}

                        else if ( (LA20_0=='\n'||LA20_0=='\r') ) {s = 2;}

                        else if ( (LA20_0=='\"') ) {s = 3;}

                        else if ( (LA20_0=='-') ) {s = 4;}

                        else if ( (LA20_0=='0') ) {s = 5;}

                        else if ( ((LA20_0>='1' && LA20_0<='9')) ) {s = 6;}

                        else if ( (LA20_0=='t') ) {s = 7;}

                        else if ( (LA20_0=='f') ) {s = 8;}

                        else if ( (LA20_0=='n') ) {s = 9;}

                        else if ( (LA20_0=='{') ) {s = 10;}

                        else if ( (LA20_0=='}') ) {s = 11;}

                        else if ( (LA20_0=='[') ) {s = 12;}

                        else if ( (LA20_0==']') ) {s = 13;}

                        else if ( (LA20_0=='<') ) {s = 14;}

                        else if ( (LA20_0=='>') ) {s = 15;}

                        else if ( (LA20_0=='=') ) {s = 16;}

                        else if ( (LA20_0=='!') ) {s = 17;}

                        else if ( (LA20_0=='~') ) {s = 18;}

                        else if ( (LA20_0=='/') ) {s = 19;}

                        else if ( (LA20_0=='.') ) {s = 20;}

                        else if ( (LA20_0==',') ) {s = 21;}

                        else if ( (LA20_0==':') ) {s = 22;}

                        else if ( (LA20_0=='a') ) {s = 23;}

                        else if ( (LA20_0=='(') ) {s = 24;}

                        else if ( (LA20_0==')') ) {s = 25;}

                        else if ( (LA20_0=='*') ) {s = 26;}

                        else if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='$'||LA20_0=='&'||LA20_0=='+'||LA20_0==';'||LA20_0=='?'||(LA20_0>='A' && LA20_0<='Z')||(LA20_0>='^' && LA20_0<='`')||(LA20_0>='b' && LA20_0<='e')||(LA20_0>='g' && LA20_0<='m')||(LA20_0>='o' && LA20_0<='s')||(LA20_0>='u' && LA20_0<='z')||(LA20_0>='\u007F' && LA20_0<='\uFFFF')) ) {s = 27;}

                        else if ( (LA20_0=='\t'||LA20_0==' ') ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_6 = input.LA(1);

                        s = -1;
                        if ( (LA20_6=='.') ) {s = 32;}

                        else if ( ((LA20_6>='0' && LA20_6<='9')) ) {s = 34;}

                        else if ( (LA20_6=='E'||LA20_6=='e') ) {s = 33;}

                        else if ( ((LA20_6>='\u0000' && LA20_6<='\b')||(LA20_6>='\u000B' && LA20_6<='\f')||(LA20_6>='\u000E' && LA20_6<='\u001F')||LA20_6=='!'||LA20_6=='$'||LA20_6=='&'||LA20_6=='+'||LA20_6=='/'||LA20_6==';'||LA20_6=='='||LA20_6=='?'||(LA20_6>='A' && LA20_6<='D')||(LA20_6>='F' && LA20_6<='Z')||(LA20_6>='^' && LA20_6<='d')||(LA20_6>='f' && LA20_6<='z')||(LA20_6>='~' && LA20_6<='\uFFFF')) ) {s = 27;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_43 = input.LA(1);

                        s = -1;
                        if ( ((LA20_43>='\u0000' && LA20_43<='\b')||(LA20_43>='\u000B' && LA20_43<='\f')||(LA20_43>='\u000E' && LA20_43<='\u001F')||LA20_43=='!'||LA20_43=='$'||LA20_43=='&'||LA20_43=='+'||(LA20_43>='.' && LA20_43<='9')||LA20_43==';'||LA20_43=='='||LA20_43=='?'||(LA20_43>='A' && LA20_43<='Z')||(LA20_43>='^' && LA20_43<='z')||(LA20_43>='~' && LA20_43<='\uFFFF')) ) {s = 27;}

                        else s = 58;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_65 = input.LA(1);

                        s = -1;
                        if ( ((LA20_65>='\u0000' && LA20_65<='\b')||(LA20_65>='\u000B' && LA20_65<='\f')||(LA20_65>='\u000E' && LA20_65<='\u001F')||LA20_65=='!'||LA20_65=='$'||LA20_65=='&'||LA20_65=='+'||(LA20_65>='.' && LA20_65<='9')||LA20_65==';'||LA20_65=='='||LA20_65=='?'||(LA20_65>='A' && LA20_65<='Z')||(LA20_65>='^' && LA20_65<='z')||(LA20_65>='~' && LA20_65<='\uFFFF')) ) {s = 27;}

                        else s = 71;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_67 = input.LA(1);

                        s = -1;
                        if ( ((LA20_67>='\u0000' && LA20_67<='\b')||(LA20_67>='\u000B' && LA20_67<='\f')||(LA20_67>='\u000E' && LA20_67<='\u001F')||LA20_67=='!'||LA20_67=='$'||LA20_67=='&'||LA20_67=='+'||(LA20_67>='.' && LA20_67<='9')||LA20_67==';'||LA20_67=='='||LA20_67=='?'||(LA20_67>='A' && LA20_67<='Z')||(LA20_67>='^' && LA20_67<='z')||(LA20_67>='~' && LA20_67<='\uFFFF')) ) {s = 27;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_60 = input.LA(1);

                        s = -1;
                        if ( ((LA20_60>='A' && LA20_60<='Z')||(LA20_60>='a' && LA20_60<='z')) ) {s = 68;}

                        else if ( (LA20_60=='/') ) {s = 60;}

                        else if ( (LA20_60=='.') ) {s = 45;}

                        else if ( ((LA20_60>='\u0000' && LA20_60<='\b')||(LA20_60>='\u000B' && LA20_60<='\f')||(LA20_60>='\u000E' && LA20_60<='\u001F')||LA20_60=='!'||LA20_60=='$'||LA20_60=='&'||LA20_60=='+'||(LA20_60>='0' && LA20_60<='9')||LA20_60==';'||LA20_60=='='||LA20_60=='?'||(LA20_60>='^' && LA20_60<='`')||(LA20_60>='~' && LA20_60<='\uFFFF')) ) {s = 61;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_32 = input.LA(1);

                        s = -1;
                        if ( ((LA20_32>='0' && LA20_32<='9')) ) {s = 52;}

                        else if ( ((LA20_32>='\u0000' && LA20_32<='\b')||(LA20_32>='\u000B' && LA20_32<='\f')||(LA20_32>='\u000E' && LA20_32<='\u001F')||LA20_32=='!'||LA20_32=='$'||LA20_32=='&'||LA20_32=='+'||LA20_32=='/'||LA20_32==';'||LA20_32=='='||LA20_32=='?'||(LA20_32>='A' && LA20_32<='Z')||(LA20_32>='^' && LA20_32<='z')||(LA20_32>='~' && LA20_32<='\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_72 = input.LA(1);

                        s = -1;
                        if ( ((LA20_72>='\u0000' && LA20_72<='\b')||(LA20_72>='\u000B' && LA20_72<='\f')||(LA20_72>='\u000E' && LA20_72<='\u001F')||LA20_72=='!'||LA20_72=='$'||LA20_72=='&'||LA20_72=='+'||(LA20_72>='.' && LA20_72<='9')||LA20_72==';'||LA20_72=='='||LA20_72=='?'||(LA20_72>='A' && LA20_72<='Z')||(LA20_72>='^' && LA20_72<='z')||(LA20_72>='~' && LA20_72<='\uFFFF')) ) {s = 27;}

                        else s = 74;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_54 = input.LA(1);

                        s = -1;
                        if ( ((LA20_54>='0' && LA20_54<='9')) ) {s = 54;}

                        else if ( ((LA20_54>='\u0000' && LA20_54<='\b')||(LA20_54>='\u000B' && LA20_54<='\f')||(LA20_54>='\u000E' && LA20_54<='\u001F')||LA20_54=='!'||LA20_54=='$'||LA20_54=='&'||LA20_54=='+'||(LA20_54>='.' && LA20_54<='/')||LA20_54==';'||LA20_54=='='||LA20_54=='?'||(LA20_54>='A' && LA20_54<='Z')||(LA20_54>='^' && LA20_54<='z')||(LA20_54>='~' && LA20_54<='\uFFFF')) ) {s = 27;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_52 = input.LA(1);

                        s = -1;
                        if ( (LA20_52=='E'||LA20_52=='e') ) {s = 64;}

                        else if ( ((LA20_52>='0' && LA20_52<='9')) ) {s = 52;}

                        else if ( ((LA20_52>='\u0000' && LA20_52<='\b')||(LA20_52>='\u000B' && LA20_52<='\f')||(LA20_52>='\u000E' && LA20_52<='\u001F')||LA20_52=='!'||LA20_52=='$'||LA20_52=='&'||LA20_52=='+'||(LA20_52>='.' && LA20_52<='/')||LA20_52==';'||LA20_52=='='||LA20_52=='?'||(LA20_52>='A' && LA20_52<='D')||(LA20_52>='F' && LA20_52<='Z')||(LA20_52>='^' && LA20_52<='d')||(LA20_52>='f' && LA20_52<='z')||(LA20_52>='~' && LA20_52<='\uFFFF')) ) {s = 27;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_45 = input.LA(1);

                        s = -1;
                        if ( (LA20_45=='/') ) {s = 60;}

                        else if ( ((LA20_45>='\u0000' && LA20_45<='\b')||(LA20_45>='\u000B' && LA20_45<='\f')||(LA20_45>='\u000E' && LA20_45<='\u001F')||LA20_45=='!'||LA20_45=='$'||LA20_45=='&'||LA20_45=='+'||(LA20_45>='0' && LA20_45<='9')||LA20_45==';'||LA20_45=='='||LA20_45=='?'||(LA20_45>='A' && LA20_45<='Z')||(LA20_45>='^' && LA20_45<='z')||(LA20_45>='~' && LA20_45<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA20_45>='\t' && LA20_45<='\n')||LA20_45=='\r'||LA20_45==' '||(LA20_45>='\"' && LA20_45<='#')||LA20_45=='%'||(LA20_45>='\'' && LA20_45<='*')||(LA20_45>=',' && LA20_45<='.')||LA20_45==':'||LA20_45=='<'||LA20_45=='>'||LA20_45=='@'||(LA20_45>='[' && LA20_45<=']')||(LA20_45>='{' && LA20_45<='}')) ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_68 = input.LA(1);

                        s = -1;
                        if ( ((LA20_68>='A' && LA20_68<='Z')||(LA20_68>='a' && LA20_68<='z')) ) {s = 68;}

                        else if ( (LA20_68=='/') ) {s = 60;}

                        else if ( (LA20_68=='.') ) {s = 45;}

                        else if ( ((LA20_68>='\u0000' && LA20_68<='\b')||(LA20_68>='\u000B' && LA20_68<='\f')||(LA20_68>='\u000E' && LA20_68<='\u001F')||LA20_68=='!'||LA20_68=='$'||LA20_68=='&'||LA20_68=='+'||(LA20_68>='0' && LA20_68<='9')||LA20_68==';'||LA20_68=='='||LA20_68=='?'||(LA20_68>='^' && LA20_68<='`')||(LA20_68>='~' && LA20_68<='\uFFFF')) ) {s = 61;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_48 = input.LA(1);

                        s = -1;
                        if ( (LA20_48=='.') ) {s = 45;}

                        else if ( (LA20_48=='/') ) {s = 46;}

                        else if ( ((LA20_48>='\u0000' && LA20_48<='\b')||(LA20_48>='\u000B' && LA20_48<='\f')||(LA20_48>='\u000E' && LA20_48<='\u001F')||LA20_48=='!'||LA20_48=='$'||LA20_48=='&'||LA20_48=='+'||(LA20_48>='0' && LA20_48<='9')||LA20_48==';'||LA20_48=='='||LA20_48=='?'||(LA20_48>='A' && LA20_48<='Z')||(LA20_48>='^' && LA20_48<='z')||(LA20_48>='~' && LA20_48<='\uFFFF')) ) {s = 48;}

                        else if ( ((LA20_48>='\t' && LA20_48<='\n')||LA20_48=='\r'||LA20_48==' '||(LA20_48>='\"' && LA20_48<='#')||LA20_48=='%'||(LA20_48>='\'' && LA20_48<='*')||(LA20_48>=',' && LA20_48<='-')||LA20_48==':'||LA20_48=='<'||LA20_48=='>'||LA20_48=='@'||(LA20_48>='[' && LA20_48<=']')||(LA20_48>='{' && LA20_48<='}')) ) {s = 47;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_70 = input.LA(1);

                        s = -1;
                        if ( ((LA20_70>='0' && LA20_70<='9')) ) {s = 70;}

                        else if ( ((LA20_70>='\u0000' && LA20_70<='\b')||(LA20_70>='\u000B' && LA20_70<='\f')||(LA20_70>='\u000E' && LA20_70<='\u001F')||LA20_70=='!'||LA20_70=='$'||LA20_70=='&'||LA20_70=='+'||(LA20_70>='.' && LA20_70<='/')||LA20_70==';'||LA20_70=='='||LA20_70=='?'||(LA20_70>='A' && LA20_70<='Z')||(LA20_70>='^' && LA20_70<='z')||(LA20_70>='~' && LA20_70<='\uFFFF')) ) {s = 27;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_49 = input.LA(1);

                        s = -1;
                        if ( ((LA20_49>='\u0000' && LA20_49<='\b')||(LA20_49>='\u000B' && LA20_49<='\f')||(LA20_49>='\u000E' && LA20_49<='\u001F')||LA20_49=='!'||LA20_49=='$'||LA20_49=='&'||LA20_49=='+'||(LA20_49>='.' && LA20_49<='9')||LA20_49==';'||LA20_49=='='||LA20_49=='?'||(LA20_49>='A' && LA20_49<='Z')||(LA20_49>='^' && LA20_49<='z')||(LA20_49>='~' && LA20_49<='\uFFFF')) ) {s = 27;}

                        else s = 63;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_44 = input.LA(1);

                        s = -1;
                        if ( ((LA20_44>='\u0000' && LA20_44<='\b')||(LA20_44>='\u000B' && LA20_44<='\f')||(LA20_44>='\u000E' && LA20_44<='\u001F')||LA20_44=='!'||LA20_44=='$'||LA20_44=='&'||LA20_44=='+'||(LA20_44>='.' && LA20_44<='9')||LA20_44==';'||LA20_44=='='||LA20_44=='?'||(LA20_44>='A' && LA20_44<='Z')||(LA20_44>='^' && LA20_44<='z')||(LA20_44>='~' && LA20_44<='\uFFFF')) ) {s = 27;}

                        else s = 59;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_5 = input.LA(1);

                        s = -1;
                        if ( (LA20_5=='.') ) {s = 32;}

                        else if ( (LA20_5=='E'||LA20_5=='e') ) {s = 33;}

                        else if ( ((LA20_5>='\u0000' && LA20_5<='\b')||(LA20_5>='\u000B' && LA20_5<='\f')||(LA20_5>='\u000E' && LA20_5<='\u001F')||LA20_5=='!'||LA20_5=='$'||LA20_5=='&'||LA20_5=='+'||(LA20_5>='/' && LA20_5<='9')||LA20_5==';'||LA20_5=='='||LA20_5=='?'||(LA20_5>='A' && LA20_5<='D')||(LA20_5>='F' && LA20_5<='Z')||(LA20_5>='^' && LA20_5<='d')||(LA20_5>='f' && LA20_5<='z')||(LA20_5>='~' && LA20_5<='\uFFFF')) ) {s = 27;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA20_16 = input.LA(1);

                        s = -1;
                        if ( ((LA20_16>='\u0000' && LA20_16<='\b')||(LA20_16>='\u000B' && LA20_16<='\f')||(LA20_16>='\u000E' && LA20_16<='\u001F')||LA20_16=='!'||LA20_16=='$'||LA20_16=='&'||LA20_16=='+'||(LA20_16>='.' && LA20_16<='9')||LA20_16==';'||LA20_16=='='||LA20_16=='?'||(LA20_16>='A' && LA20_16<='Z')||(LA20_16>='^' && LA20_16<='z')||(LA20_16>='~' && LA20_16<='\uFFFF')) ) {s = 27;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA20_19 = input.LA(1);

                        s = -1;
                        if ( (LA20_19=='.') ) {s = 45;}

                        else if ( (LA20_19=='/') ) {s = 46;}

                        else if ( ((LA20_19>='\t' && LA20_19<='\n')||LA20_19=='\r'||LA20_19==' '||(LA20_19>='\"' && LA20_19<='#')||LA20_19=='%'||(LA20_19>='\'' && LA20_19<='*')||(LA20_19>=',' && LA20_19<='-')||LA20_19==':'||LA20_19=='<'||LA20_19=='>'||LA20_19=='@'||(LA20_19>='[' && LA20_19<=']')||(LA20_19>='{' && LA20_19<='}')) ) {s = 47;}

                        else if ( ((LA20_19>='\u0000' && LA20_19<='\b')||(LA20_19>='\u000B' && LA20_19<='\f')||(LA20_19>='\u000E' && LA20_19<='\u001F')||LA20_19=='!'||LA20_19=='$'||LA20_19=='&'||LA20_19=='+'||(LA20_19>='0' && LA20_19<='9')||LA20_19==';'||LA20_19=='='||LA20_19=='?'||(LA20_19>='A' && LA20_19<='Z')||(LA20_19>='^' && LA20_19<='z')||(LA20_19>='~' && LA20_19<='\uFFFF')) ) {s = 48;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA20_62 = input.LA(1);

                        s = -1;
                        if ( (LA20_62=='.') ) {s = 45;}

                        else if ( ((LA20_62>='A' && LA20_62<='Z')||(LA20_62>='a' && LA20_62<='z')) ) {s = 62;}

                        else if ( (LA20_62=='/') ) {s = 46;}

                        else if ( ((LA20_62>='\u0000' && LA20_62<='\b')||(LA20_62>='\u000B' && LA20_62<='\f')||(LA20_62>='\u000E' && LA20_62<='\u001F')||LA20_62=='!'||LA20_62=='$'||LA20_62=='&'||LA20_62=='+'||(LA20_62>='0' && LA20_62<='9')||LA20_62==';'||LA20_62=='='||LA20_62=='?'||(LA20_62>='^' && LA20_62<='`')||(LA20_62>='~' && LA20_62<='\uFFFF')) ) {s = 48;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA20_46 = input.LA(1);

                        s = -1;
                        if ( ((LA20_46>='A' && LA20_46<='Z')||(LA20_46>='a' && LA20_46<='z')) ) {s = 62;}

                        else if ( (LA20_46=='.') ) {s = 45;}

                        else if ( (LA20_46=='/') ) {s = 46;}

                        else if ( ((LA20_46>='\u0000' && LA20_46<='\b')||(LA20_46>='\u000B' && LA20_46<='\f')||(LA20_46>='\u000E' && LA20_46<='\u001F')||LA20_46=='!'||LA20_46=='$'||LA20_46=='&'||LA20_46=='+'||(LA20_46>='0' && LA20_46<='9')||LA20_46==';'||LA20_46=='='||LA20_46=='?'||(LA20_46>='^' && LA20_46<='`')||(LA20_46>='~' && LA20_46<='\uFFFF')) ) {s = 48;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA20_34 = input.LA(1);

                        s = -1;
                        if ( ((LA20_34>='0' && LA20_34<='9')) ) {s = 34;}

                        else if ( (LA20_34=='.') ) {s = 32;}

                        else if ( (LA20_34=='E'||LA20_34=='e') ) {s = 33;}

                        else if ( ((LA20_34>='\u0000' && LA20_34<='\b')||(LA20_34>='\u000B' && LA20_34<='\f')||(LA20_34>='\u000E' && LA20_34<='\u001F')||LA20_34=='!'||LA20_34=='$'||LA20_34=='&'||LA20_34=='+'||LA20_34=='/'||LA20_34==';'||LA20_34=='='||LA20_34=='?'||(LA20_34>='A' && LA20_34<='D')||(LA20_34>='F' && LA20_34<='Z')||(LA20_34>='^' && LA20_34<='d')||(LA20_34>='f' && LA20_34<='z')||(LA20_34>='~' && LA20_34<='\uFFFF')) ) {s = 27;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA20_61 = input.LA(1);

                        s = -1;
                        if ( (LA20_61=='/') ) {s = 60;}

                        else if ( (LA20_61=='.') ) {s = 45;}

                        else if ( ((LA20_61>='\u0000' && LA20_61<='\b')||(LA20_61>='\u000B' && LA20_61<='\f')||(LA20_61>='\u000E' && LA20_61<='\u001F')||LA20_61=='!'||LA20_61=='$'||LA20_61=='&'||LA20_61=='+'||(LA20_61>='0' && LA20_61<='9')||LA20_61==';'||LA20_61=='='||LA20_61=='?'||(LA20_61>='A' && LA20_61<='Z')||(LA20_61>='^' && LA20_61<='z')||(LA20_61>='~' && LA20_61<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA20_61>='\t' && LA20_61<='\n')||LA20_61=='\r'||LA20_61==' '||(LA20_61>='\"' && LA20_61<='#')||LA20_61=='%'||(LA20_61>='\'' && LA20_61<='*')||(LA20_61>=',' && LA20_61<='-')||LA20_61==':'||LA20_61=='<'||LA20_61=='>'||LA20_61=='@'||(LA20_61>='[' && LA20_61<=']')||(LA20_61>='{' && LA20_61<='}')) ) {s = 47;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
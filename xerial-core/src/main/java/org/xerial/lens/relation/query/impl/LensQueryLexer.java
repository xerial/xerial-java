// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 LensQuery.g 2010-03-02 22:16:18

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
    public static final int PATTERNMATCH=9;
    public static final int Match=40;
    public static final int Regex=41;
    public static final int Digit=19;
    public static final int T__57=57;
    public static final int Frac=28;
    public static final int HexDigit=21;
    public static final int QUERY=4;
    public static final int ALIAS=11;
    public static final int VALUE=14;
    public static final int FD=15;
    public static final int Letter=20;
    public static final int Comma=43;
    public static final int Dot=42;
    public static final int EscapeSequence=23;
    public static final int Integer=27;
    public static final int WhiteSpace=51;
    public static final int OPERATOR=7;
    public static final int False=32;
    public static final int Colon=44;
    public static final int LineComment=17;
    public static final int NODEVALUE=12;
    public static final int T__56=56;
    public static final int As=45;
    public static final int SafeFirstLetter=49;
    public static final int Null=33;
    public static final int Eq=38;
    public static final int Exp=29;
    public static final int QNameChar=52;
    public static final int RELATION=5;
    public static final int Gt=35;
    public static final int RParen=47;
    public static final int UnicodeChar=22;
    public static final int StringChar=24;
    public static final int True=31;
    public static final int OPERAND=8;
    public static final int LineBreak=18;
    public static final int T__55=55;
    public static final int LParen=46;
    public static final int String=26;
    public static final int SafeLetter=50;
    public static final int LineBreakChar=16;
    public static final int COMPARE=6;
    public static final int QName=53;
    public static final int Geq=37;
    public static final int EOF=-1;
    public static final int NODE=10;
    public static final int Neq=39;
    public static final int StringChar_s=25;
    public static final int UnsafeUnicodeChar=48;
    public static final int Double=30;
    public static final int Lt=34;
    public static final int NAME=13;
    public static final int Leq=36;
    public static final int WhiteSpaces=54;




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

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:38:7: ( '*' )
            // LensQuery.g:38:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:39:7: ( '?' )
            // LensQuery.g:39:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:40:7: ( '+' )
            // LensQuery.g:40:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // LensQuery.g:114:23: ( '\\n' | '\\r' )
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
            // LensQuery.g:115:12: ( '#' (~ ( LineBreakChar ) )* )
            // LensQuery.g:115:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); 
            // LensQuery.g:115:18: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // LensQuery.g:115:18: ~ ( LineBreakChar )
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
            // LensQuery.g:118:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // LensQuery.g:118:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // LensQuery.g:118:12: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // LensQuery.g:118:13: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:118:25: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // LensQuery.g:118:32: '\\n'
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
            // LensQuery.g:121:15: ( '0' .. '9' )
            // LensQuery.g:121:17: '0' .. '9'
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
            // LensQuery.g:122:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // LensQuery.g:123:18: ( Digit | Letter )
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
            // LensQuery.g:124:21: (~ ( '\"' | '\\\\' ) )
            // LensQuery.g:124:23: ~ ( '\"' | '\\\\' )
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
            // LensQuery.g:126:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // LensQuery.g:126:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // LensQuery.g:126:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // LensQuery.g:126:11: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:126:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // LensQuery.g:126:25: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // LensQuery.g:126:31: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // LensQuery.g:126:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // LensQuery.g:126:43: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // LensQuery.g:126:49: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // LensQuery.g:126:55: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // LensQuery.g:126:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // LensQuery.g:129:21: ( UnicodeChar | EscapeSequence )
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
                    // LensQuery.g:129:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:129:38: EscapeSequence
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
            // LensQuery.g:130:22: ( ( StringChar )* )
            // LensQuery.g:130:24: ( StringChar )*
            {
            // LensQuery.g:130:24: ( StringChar )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // LensQuery.g:130:24: StringChar
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

            // LensQuery.g:132:7: ( '\"' s= StringChar_s '\"' )
            // LensQuery.g:132:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart269 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart269, getCharIndex()-1);
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
            // LensQuery.g:135:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // LensQuery.g:135:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // LensQuery.g:135:10: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // LensQuery.g:135:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // LensQuery.g:135:15: ( '0' | '1' .. '9' ( Digit )* )
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
                    // LensQuery.g:135:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // LensQuery.g:135:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // LensQuery.g:135:31: ( Digit )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // LensQuery.g:135:31: Digit
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
            // LensQuery.g:136:14: ( '.' ( Digit )+ )
            // LensQuery.g:136:16: '.' ( Digit )+
            {
            match('.'); 
            // LensQuery.g:136:20: ( Digit )+
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
            	    // LensQuery.g:136:20: Digit
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
            // LensQuery.g:137:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // LensQuery.g:137:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // LensQuery.g:137:27: ( '+' | '-' )?
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

            // LensQuery.g:137:40: ( Digit )+
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
            	    // LensQuery.g:137:40: Digit
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
            // LensQuery.g:138:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // LensQuery.g:138:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); 
            // LensQuery.g:138:17: ( Frac ( Exp )? | Exp )
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
                    // LensQuery.g:138:18: Frac ( Exp )?
                    {
                    mFrac(); 
                    // LensQuery.g:138:23: ( Exp )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // LensQuery.g:138:23: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // LensQuery.g:138:30: Exp
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
            // LensQuery.g:140:5: ( 'true' )
            // LensQuery.g:140:7: 'true'
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
            // LensQuery.g:141:6: ( 'false' )
            // LensQuery.g:141:8: 'false'
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
            // LensQuery.g:142:5: ( 'null' )
            // LensQuery.g:142:7: 'null'
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

    // $ANTLR start "Lt"
    public final void mLt() throws RecognitionException {
        try {
            int _type = Lt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LensQuery.g:146:3: ( '<' )
            // LensQuery.g:146:5: '<'
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
            // LensQuery.g:147:3: ( '>' )
            // LensQuery.g:147:5: '>'
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
            // LensQuery.g:148:4: ( '<=' )
            // LensQuery.g:148:6: '<='
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
            // LensQuery.g:149:4: ( '>=' )
            // LensQuery.g:149:6: '>='
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
            // LensQuery.g:150:3: ( '=' )
            // LensQuery.g:150:5: '='
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
            // LensQuery.g:151:4: ( '!=' )
            // LensQuery.g:151:6: '!='
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
            // LensQuery.g:152:6: ( '~=' )
            // LensQuery.g:152:8: '~='
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
            // LensQuery.g:153:6: ( '/' ( options {greedy=false; } : . )* '/' ( 'a' .. 'z' | 'A' .. 'Z' )* )
            // LensQuery.g:153:8: '/' ( options {greedy=false; } : . )* '/' ( 'a' .. 'z' | 'A' .. 'Z' )*
            {
            match('/'); 
            // LensQuery.g:153:13: ( options {greedy=false; } : . )*
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
            	    // LensQuery.g:153:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match('/'); 
            // LensQuery.g:153:46: ( 'a' .. 'z' | 'A' .. 'Z' )*
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
            // LensQuery.g:156:4: ( '.' )
            // LensQuery.g:156:6: '.'
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
            // LensQuery.g:157:6: ( ',' )
            // LensQuery.g:157:8: ','
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
            // LensQuery.g:158:6: ( ':' )
            // LensQuery.g:158:8: ':'
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
            // LensQuery.g:160:3: ( 'as' )
            // LensQuery.g:160:5: 'as'
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
            // LensQuery.g:162:7: ( '(' )
            // LensQuery.g:162:9: '('
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
            // LensQuery.g:163:7: ( ')' )
            // LensQuery.g:163:9: ')'
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

    // $ANTLR start "UnsafeUnicodeChar"
    public final void mUnsafeUnicodeChar() throws RecognitionException {
        try {
            // LensQuery.g:167:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' | '+' | '?' )
            // LensQuery.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='.')||input.LA(1)==':'||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
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
            // LensQuery.g:169:25: ( 'A' .. 'Z' | 'a' .. 'z' )
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
            // LensQuery.g:170:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
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
            // LensQuery.g:173:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // LensQuery.g:173:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)==';'||input.LA(1)=='='||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            // LensQuery.g:174:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // LensQuery.g:174:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // LensQuery.g:174:8: ( QNameChar )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||LA16_0=='$'||LA16_0=='&'||(LA16_0>='/' && LA16_0<='9')||LA16_0==';'||LA16_0=='='||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='^' && LA16_0<='z')||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // LensQuery.g:174:8: QNameChar
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

            // LensQuery.g:174:19: ( Dot ( QNameChar )+ )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // LensQuery.g:174:20: Dot ( QNameChar )+
            	    {
            	    mDot(); 
            	    // LensQuery.g:174:24: ( QNameChar )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||LA17_0=='$'||LA17_0=='&'||(LA17_0>='/' && LA17_0<='9')||LA17_0==';'||LA17_0=='='||(LA17_0>='A' && LA17_0<='Z')||(LA17_0>='^' && LA17_0<='z')||(LA17_0>='~' && LA17_0<='\uFFFF')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // LensQuery.g:174:24: QNameChar
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
            // LensQuery.g:178:11: ( ' ' | '\\t' )
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
            // LensQuery.g:180:12: ( ( WhiteSpace )+ )
            // LensQuery.g:180:14: ( WhiteSpace )+
            {
            // LensQuery.g:180:14: ( WhiteSpace )+
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
            	    // LensQuery.g:180:14: WhiteSpace
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
        // LensQuery.g:1:8: ( T__55 | T__56 | T__57 | LineComment | LineBreak | String | Integer | Double | True | False | Null | Lt | Gt | Leq | Geq | Eq | Neq | Match | Regex | Dot | Comma | Colon | As | LParen | RParen | QName | WhiteSpaces )
        int alt20=27;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // LensQuery.g:1:10: T__55
                {
                mT__55(); 

                }
                break;
            case 2 :
                // LensQuery.g:1:16: T__56
                {
                mT__56(); 

                }
                break;
            case 3 :
                // LensQuery.g:1:22: T__57
                {
                mT__57(); 

                }
                break;
            case 4 :
                // LensQuery.g:1:28: LineComment
                {
                mLineComment(); 

                }
                break;
            case 5 :
                // LensQuery.g:1:40: LineBreak
                {
                mLineBreak(); 

                }
                break;
            case 6 :
                // LensQuery.g:1:50: String
                {
                mString(); 

                }
                break;
            case 7 :
                // LensQuery.g:1:57: Integer
                {
                mInteger(); 

                }
                break;
            case 8 :
                // LensQuery.g:1:65: Double
                {
                mDouble(); 

                }
                break;
            case 9 :
                // LensQuery.g:1:72: True
                {
                mTrue(); 

                }
                break;
            case 10 :
                // LensQuery.g:1:77: False
                {
                mFalse(); 

                }
                break;
            case 11 :
                // LensQuery.g:1:83: Null
                {
                mNull(); 

                }
                break;
            case 12 :
                // LensQuery.g:1:88: Lt
                {
                mLt(); 

                }
                break;
            case 13 :
                // LensQuery.g:1:91: Gt
                {
                mGt(); 

                }
                break;
            case 14 :
                // LensQuery.g:1:94: Leq
                {
                mLeq(); 

                }
                break;
            case 15 :
                // LensQuery.g:1:98: Geq
                {
                mGeq(); 

                }
                break;
            case 16 :
                // LensQuery.g:1:102: Eq
                {
                mEq(); 

                }
                break;
            case 17 :
                // LensQuery.g:1:105: Neq
                {
                mNeq(); 

                }
                break;
            case 18 :
                // LensQuery.g:1:109: Match
                {
                mMatch(); 

                }
                break;
            case 19 :
                // LensQuery.g:1:115: Regex
                {
                mRegex(); 

                }
                break;
            case 20 :
                // LensQuery.g:1:121: Dot
                {
                mDot(); 

                }
                break;
            case 21 :
                // LensQuery.g:1:125: Comma
                {
                mComma(); 

                }
                break;
            case 22 :
                // LensQuery.g:1:131: Colon
                {
                mColon(); 

                }
                break;
            case 23 :
                // LensQuery.g:1:137: As
                {
                mAs(); 

                }
                break;
            case 24 :
                // LensQuery.g:1:140: LParen
                {
                mLParen(); 

                }
                break;
            case 25 :
                // LensQuery.g:1:147: RParen
                {
                mRParen(); 

                }
                break;
            case 26 :
                // LensQuery.g:1:154: QName
                {
                mQName(); 

                }
                break;
            case 27 :
                // LensQuery.g:1:160: WhiteSpaces
                {
                mWhiteSpaces(); 

                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\10\uffff\2\35\3\31\1\45\1\47\1\50\3\31\3\uffff\1\31\4\uffff\2"+
        "\35\2\uffff\1\31\1\35\3\31\5\uffff\1\67\1\70\1\uffff\1\55\1\uffff"+
        "\1\31\1\74\1\uffff\1\35\2\60\3\31\2\uffff\1\55\1\31\1\55\1\uffff"+
        "\1\31\1\103\1\31\1\105\1\55\1\60\1\uffff\1\106\2\uffff";
    static final String DFA20_eofS =
        "\107\uffff";
    static final String DFA20_minS =
        "\1\0\6\uffff\1\60\2\0\1\162\1\141\1\165\2\75\1\0\2\75\1\0\3\uffff"+
        "\1\163\4\uffff\2\56\1\uffff\1\0\1\53\1\0\1\165\2\154\5\uffff\4\0"+
        "\1\uffff\2\0\1\uffff\1\56\2\0\1\145\1\163\1\154\2\uffff\3\0\1\uffff"+
        "\1\53\1\0\1\145\3\0\1\uffff\1\0\2\uffff";
    static final String DFA20_maxS =
        "\1\uffff\6\uffff\1\71\2\uffff\1\162\1\141\1\165\2\75\1\uffff\2"+
        "\75\1\uffff\3\uffff\1\163\4\uffff\2\145\1\uffff\1\uffff\1\71\1\uffff"+
        "\1\165\2\154\5\uffff\4\uffff\1\uffff\2\uffff\1\uffff\1\145\2\uffff"+
        "\1\145\1\163\1\154\2\uffff\3\uffff\1\uffff\1\71\1\uffff\1\145\3"+
        "\uffff\1\uffff\1\uffff\2\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\14\uffff\1\24\1\25\1\26\1\uffff"+
        "\1\30\1\31\1\32\1\33\2\uffff\1\7\6\uffff\1\16\1\14\1\17\1\15\1\20"+
        "\4\uffff\1\23\2\uffff\1\10\6\uffff\1\21\1\22\3\uffff\1\27\6\uffff"+
        "\1\11\1\uffff\1\13\1\12";
    static final String DFA20_specialS =
        "\1\23\7\uffff\1\20\1\16\5\uffff\1\15\2\uffff\1\21\13\uffff\1\2"+
        "\1\uffff\1\13\10\uffff\1\5\1\10\1\22\1\1\1\uffff\1\17\1\14\2\uffff"+
        "\1\3\1\12\5\uffff\1\26\1\7\1\4\2\uffff\1\0\1\uffff\1\24\1\11\1\25"+
        "\1\uffff\1\6\2\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\31\1\32\1\5\2\31\1\5\22\31\1\32\1\20\1\6\1\4\1\31\1\uffff"+
            "\1\31\1\uffff\1\27\1\30\1\1\1\3\1\24\1\7\1\23\1\22\1\10\11\11"+
            "\1\25\1\31\1\15\1\17\1\16\1\2\1\uffff\32\31\3\uffff\3\31\1\26"+
            "\4\31\1\13\7\31\1\14\5\31\1\12\6\31\3\uffff\1\21\uff81\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33\11\34",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\1\36\13\31\1\uffff\1\31\1\uffff\1\31\3"+
            "\uffff\4\31\1\37\25\31\3\uffff\7\31\1\37\25\31\3\uffff\uff82"+
            "\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\1\36\1\31\12\40\1\uffff\1\31\1\uffff\1"+
            "\31\3\uffff\4\31\1\37\25\31\3\uffff\7\31\1\37\25\31\3\uffff"+
            "\uff82\31",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\46",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\1\51",
            "\1\52",
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\56\2\55\1\56\1\55\1\56"+
            "\7\55\1\53\1\54\12\56\1\55\1\56\1\55\1\56\3\55\32\56\3\55\35"+
            "\56\3\55\uff82\56",
            "",
            "",
            "",
            "\1\57",
            "",
            "",
            "",
            "",
            "\1\60\26\uffff\1\60\37\uffff\1\60",
            "\1\60\1\uffff\12\61\13\uffff\1\60\37\uffff\1\60",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\10\uffff\1\31\12\62\1\uffff\1\31\1\uffff\1\31"+
            "\3\uffff\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\1\60\1\uffff\1\60\2\uffff\12\63",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\1\36\1\31\12\40\1\uffff\1\31\1\uffff\1"+
            "\31\3\uffff\4\31\1\37\25\31\3\uffff\7\31\1\37\25\31\3\uffff"+
            "\uff82\31",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\11\72\2\55\2\72\1\55\22\72\1\55\1\72\2\55\1\72\1\55\1\72"+
            "\10\55\1\71\12\72\1\55\1\72\1\55\1\72\3\55\32\72\3\55\35\72"+
            "\3\55\uff82\72",
            "\11\56\2\uffff\2\56\1\uffff\22\56\1\uffff\1\56\2\uffff\1\56"+
            "\1\uffff\1\56\7\uffff\1\53\1\54\12\56\1\uffff\1\56\1\uffff\1"+
            "\56\3\uffff\32\73\3\uffff\3\56\32\73\3\uffff\uff82\56",
            "",
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\56\2\55\1\56\1\55\1\56"+
            "\7\55\1\53\1\54\12\56\1\55\1\56\1\55\1\56\3\55\32\56\3\55\35"+
            "\56\3\55\uff82\56",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "",
            "\1\60\1\uffff\12\61\13\uffff\1\60\37\uffff\1\60",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\2\31\12\62\1\uffff\1\31\1\uffff\1\31\3"+
            "\uffff\4\31\1\75\25\31\3\uffff\7\31\1\75\25\31\3\uffff\uff82"+
            "\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\2\31\12\63\1\uffff\1\31\1\uffff\1\31\3"+
            "\uffff\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "\11\72\2\uffff\2\72\1\uffff\22\72\1\uffff\1\72\2\uffff\1\72"+
            "\1\uffff\1\72\7\uffff\1\53\1\71\12\72\1\uffff\1\72\1\uffff\1"+
            "\72\3\uffff\32\101\3\uffff\3\72\32\101\3\uffff\uff82\72",
            "\11\72\2\55\2\72\1\55\22\72\1\55\1\72\2\55\1\72\1\55\1\72"+
            "\7\55\1\53\1\71\12\72\1\55\1\72\1\55\1\72\3\55\32\72\3\55\35"+
            "\72\3\55\uff82\72",
            "\11\56\2\uffff\2\56\1\uffff\22\56\1\uffff\1\56\2\uffff\1\56"+
            "\1\uffff\1\56\7\uffff\1\53\1\54\12\56\1\uffff\1\56\1\uffff\1"+
            "\56\3\uffff\32\73\3\uffff\3\56\32\73\3\uffff\uff82\56",
            "",
            "\1\60\1\uffff\1\60\2\uffff\12\102",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\1\104",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "\11\72\2\uffff\2\72\1\uffff\22\72\1\uffff\1\72\2\uffff\1\72"+
            "\1\uffff\1\72\7\uffff\1\53\1\71\12\72\1\uffff\1\72\1\uffff\1"+
            "\72\3\uffff\32\101\3\uffff\3\72\32\101\3\uffff\uff82\72",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\2\31\12\102\1\uffff\1\31\1\uffff\1\31"+
            "\3\uffff\32\31\3\uffff\35\31\3\uffff\uff82\31",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\7\uffff\14\31\1\uffff\1\31\1\uffff\1\31\3\uffff"+
            "\32\31\3\uffff\35\31\3\uffff\uff82\31",
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
            return "1:1: Tokens : ( T__55 | T__56 | T__57 | LineComment | LineBreak | String | Integer | Double | True | False | Null | Lt | Gt | Leq | Geq | Eq | Neq | Match | Regex | Dot | Comma | Colon | As | LParen | RParen | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_62 = input.LA(1);

                        s = -1;
                        if ( ((LA20_62>='\u0000' && LA20_62<='\b')||(LA20_62>='\u000B' && LA20_62<='\f')||(LA20_62>='\u000E' && LA20_62<='\u001F')||LA20_62=='!'||LA20_62=='$'||LA20_62=='&'||(LA20_62>='.' && LA20_62<='9')||LA20_62==';'||LA20_62=='='||(LA20_62>='A' && LA20_62<='Z')||(LA20_62>='^' && LA20_62<='z')||(LA20_62>='~' && LA20_62<='\uFFFF')) ) {s = 25;}

                        else s = 67;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_44 = input.LA(1);

                        s = -1;
                        if ( ((LA20_44>='A' && LA20_44<='Z')||(LA20_44>='a' && LA20_44<='z')) ) {s = 59;}

                        else if ( (LA20_44=='/') ) {s = 44;}

                        else if ( (LA20_44=='.') ) {s = 43;}

                        else if ( ((LA20_44>='\u0000' && LA20_44<='\b')||(LA20_44>='\u000B' && LA20_44<='\f')||(LA20_44>='\u000E' && LA20_44<='\u001F')||LA20_44=='!'||LA20_44=='$'||LA20_44=='&'||(LA20_44>='0' && LA20_44<='9')||LA20_44==';'||LA20_44=='='||(LA20_44>='^' && LA20_44<='`')||(LA20_44>='~' && LA20_44<='\uFFFF')) ) {s = 46;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_30 = input.LA(1);

                        s = -1;
                        if ( ((LA20_30>='0' && LA20_30<='9')) ) {s = 50;}

                        else if ( ((LA20_30>='\u0000' && LA20_30<='\b')||(LA20_30>='\u000B' && LA20_30<='\f')||(LA20_30>='\u000E' && LA20_30<='\u001F')||LA20_30=='!'||LA20_30=='$'||LA20_30=='&'||LA20_30=='/'||LA20_30==';'||LA20_30=='='||(LA20_30>='A' && LA20_30<='Z')||(LA20_30>='^' && LA20_30<='z')||(LA20_30>='~' && LA20_30<='\uFFFF')) ) {s = 25;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_50 = input.LA(1);

                        s = -1;
                        if ( ((LA20_50>='\u0000' && LA20_50<='\b')||(LA20_50>='\u000B' && LA20_50<='\f')||(LA20_50>='\u000E' && LA20_50<='\u001F')||LA20_50=='!'||LA20_50=='$'||LA20_50=='&'||(LA20_50>='.' && LA20_50<='/')||LA20_50==';'||LA20_50=='='||(LA20_50>='A' && LA20_50<='D')||(LA20_50>='F' && LA20_50<='Z')||(LA20_50>='^' && LA20_50<='d')||(LA20_50>='f' && LA20_50<='z')||(LA20_50>='~' && LA20_50<='\uFFFF')) ) {s = 25;}

                        else if ( (LA20_50=='E'||LA20_50=='e') ) {s = 61;}

                        else if ( ((LA20_50>='0' && LA20_50<='9')) ) {s = 50;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_59 = input.LA(1);

                        s = -1;
                        if ( (LA20_59=='.') ) {s = 43;}

                        else if ( (LA20_59=='/') ) {s = 44;}

                        else if ( ((LA20_59>='A' && LA20_59<='Z')||(LA20_59>='a' && LA20_59<='z')) ) {s = 59;}

                        else if ( ((LA20_59>='\u0000' && LA20_59<='\b')||(LA20_59>='\u000B' && LA20_59<='\f')||(LA20_59>='\u000E' && LA20_59<='\u001F')||LA20_59=='!'||LA20_59=='$'||LA20_59=='&'||(LA20_59>='0' && LA20_59<='9')||LA20_59==';'||LA20_59=='='||(LA20_59>='^' && LA20_59<='`')||(LA20_59>='~' && LA20_59<='\uFFFF')) ) {s = 46;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_41 = input.LA(1);

                        s = -1;
                        if ( ((LA20_41>='\u0000' && LA20_41<='\b')||(LA20_41>='\u000B' && LA20_41<='\f')||(LA20_41>='\u000E' && LA20_41<='\u001F')||LA20_41=='!'||LA20_41=='$'||LA20_41=='&'||(LA20_41>='.' && LA20_41<='9')||LA20_41==';'||LA20_41=='='||(LA20_41>='A' && LA20_41<='Z')||(LA20_41>='^' && LA20_41<='z')||(LA20_41>='~' && LA20_41<='\uFFFF')) ) {s = 25;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_68 = input.LA(1);

                        s = -1;
                        if ( ((LA20_68>='\u0000' && LA20_68<='\b')||(LA20_68>='\u000B' && LA20_68<='\f')||(LA20_68>='\u000E' && LA20_68<='\u001F')||LA20_68=='!'||LA20_68=='$'||LA20_68=='&'||(LA20_68>='.' && LA20_68<='9')||LA20_68==';'||LA20_68=='='||(LA20_68>='A' && LA20_68<='Z')||(LA20_68>='^' && LA20_68<='z')||(LA20_68>='~' && LA20_68<='\uFFFF')) ) {s = 25;}

                        else s = 70;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_58 = input.LA(1);

                        s = -1;
                        if ( (LA20_58=='.') ) {s = 43;}

                        else if ( (LA20_58=='/') ) {s = 57;}

                        else if ( ((LA20_58>='\u0000' && LA20_58<='\b')||(LA20_58>='\u000B' && LA20_58<='\f')||(LA20_58>='\u000E' && LA20_58<='\u001F')||LA20_58=='!'||LA20_58=='$'||LA20_58=='&'||(LA20_58>='0' && LA20_58<='9')||LA20_58==';'||LA20_58=='='||(LA20_58>='A' && LA20_58<='Z')||(LA20_58>='^' && LA20_58<='z')||(LA20_58>='~' && LA20_58<='\uFFFF')) ) {s = 58;}

                        else if ( ((LA20_58>='\t' && LA20_58<='\n')||LA20_58=='\r'||LA20_58==' '||(LA20_58>='\"' && LA20_58<='#')||LA20_58=='%'||(LA20_58>='\'' && LA20_58<='-')||LA20_58==':'||LA20_58=='<'||(LA20_58>='>' && LA20_58<='@')||(LA20_58>='[' && LA20_58<=']')||(LA20_58>='{' && LA20_58<='}')) ) {s = 45;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_42 = input.LA(1);

                        s = -1;
                        if ( ((LA20_42>='\u0000' && LA20_42<='\b')||(LA20_42>='\u000B' && LA20_42<='\f')||(LA20_42>='\u000E' && LA20_42<='\u001F')||LA20_42=='!'||LA20_42=='$'||LA20_42=='&'||(LA20_42>='.' && LA20_42<='9')||LA20_42==';'||LA20_42=='='||(LA20_42>='A' && LA20_42<='Z')||(LA20_42>='^' && LA20_42<='z')||(LA20_42>='~' && LA20_42<='\uFFFF')) ) {s = 25;}

                        else s = 56;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_65 = input.LA(1);

                        s = -1;
                        if ( (LA20_65=='.') ) {s = 43;}

                        else if ( (LA20_65=='/') ) {s = 57;}

                        else if ( ((LA20_65>='A' && LA20_65<='Z')||(LA20_65>='a' && LA20_65<='z')) ) {s = 65;}

                        else if ( ((LA20_65>='\u0000' && LA20_65<='\b')||(LA20_65>='\u000B' && LA20_65<='\f')||(LA20_65>='\u000E' && LA20_65<='\u001F')||LA20_65=='!'||LA20_65=='$'||LA20_65=='&'||(LA20_65>='0' && LA20_65<='9')||LA20_65==';'||LA20_65=='='||(LA20_65>='^' && LA20_65<='`')||(LA20_65>='~' && LA20_65<='\uFFFF')) ) {s = 58;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_51 = input.LA(1);

                        s = -1;
                        if ( ((LA20_51>='0' && LA20_51<='9')) ) {s = 51;}

                        else if ( ((LA20_51>='\u0000' && LA20_51<='\b')||(LA20_51>='\u000B' && LA20_51<='\f')||(LA20_51>='\u000E' && LA20_51<='\u001F')||LA20_51=='!'||LA20_51=='$'||LA20_51=='&'||(LA20_51>='.' && LA20_51<='/')||LA20_51==';'||LA20_51=='='||(LA20_51>='A' && LA20_51<='Z')||(LA20_51>='^' && LA20_51<='z')||(LA20_51>='~' && LA20_51<='\uFFFF')) ) {s = 25;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_32 = input.LA(1);

                        s = -1;
                        if ( (LA20_32=='.') ) {s = 30;}

                        else if ( (LA20_32=='E'||LA20_32=='e') ) {s = 31;}

                        else if ( ((LA20_32>='0' && LA20_32<='9')) ) {s = 32;}

                        else if ( ((LA20_32>='\u0000' && LA20_32<='\b')||(LA20_32>='\u000B' && LA20_32<='\f')||(LA20_32>='\u000E' && LA20_32<='\u001F')||LA20_32=='!'||LA20_32=='$'||LA20_32=='&'||LA20_32=='/'||LA20_32==';'||LA20_32=='='||(LA20_32>='A' && LA20_32<='D')||(LA20_32>='F' && LA20_32<='Z')||(LA20_32>='^' && LA20_32<='d')||(LA20_32>='f' && LA20_32<='z')||(LA20_32>='~' && LA20_32<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_47 = input.LA(1);

                        s = -1;
                        if ( ((LA20_47>='\u0000' && LA20_47<='\b')||(LA20_47>='\u000B' && LA20_47<='\f')||(LA20_47>='\u000E' && LA20_47<='\u001F')||LA20_47=='!'||LA20_47=='$'||LA20_47=='&'||(LA20_47>='.' && LA20_47<='9')||LA20_47==';'||LA20_47=='='||(LA20_47>='A' && LA20_47<='Z')||(LA20_47>='^' && LA20_47<='z')||(LA20_47>='~' && LA20_47<='\uFFFF')) ) {s = 25;}

                        else s = 60;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_15 = input.LA(1);

                        s = -1;
                        if ( ((LA20_15>='\u0000' && LA20_15<='\b')||(LA20_15>='\u000B' && LA20_15<='\f')||(LA20_15>='\u000E' && LA20_15<='\u001F')||LA20_15=='!'||LA20_15=='$'||LA20_15=='&'||(LA20_15>='.' && LA20_15<='9')||LA20_15==';'||LA20_15=='='||(LA20_15>='A' && LA20_15<='Z')||(LA20_15>='^' && LA20_15<='z')||(LA20_15>='~' && LA20_15<='\uFFFF')) ) {s = 25;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_9 = input.LA(1);

                        s = -1;
                        if ( ((LA20_9>='0' && LA20_9<='9')) ) {s = 32;}

                        else if ( (LA20_9=='.') ) {s = 30;}

                        else if ( (LA20_9=='E'||LA20_9=='e') ) {s = 31;}

                        else if ( ((LA20_9>='\u0000' && LA20_9<='\b')||(LA20_9>='\u000B' && LA20_9<='\f')||(LA20_9>='\u000E' && LA20_9<='\u001F')||LA20_9=='!'||LA20_9=='$'||LA20_9=='&'||LA20_9=='/'||LA20_9==';'||LA20_9=='='||(LA20_9>='A' && LA20_9<='D')||(LA20_9>='F' && LA20_9<='Z')||(LA20_9>='^' && LA20_9<='d')||(LA20_9>='f' && LA20_9<='z')||(LA20_9>='~' && LA20_9<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_46 = input.LA(1);

                        s = -1;
                        if ( (LA20_46=='/') ) {s = 44;}

                        else if ( (LA20_46=='.') ) {s = 43;}

                        else if ( ((LA20_46>='\u0000' && LA20_46<='\b')||(LA20_46>='\u000B' && LA20_46<='\f')||(LA20_46>='\u000E' && LA20_46<='\u001F')||LA20_46=='!'||LA20_46=='$'||LA20_46=='&'||(LA20_46>='0' && LA20_46<='9')||LA20_46==';'||LA20_46=='='||(LA20_46>='A' && LA20_46<='Z')||(LA20_46>='^' && LA20_46<='z')||(LA20_46>='~' && LA20_46<='\uFFFF')) ) {s = 46;}

                        else if ( ((LA20_46>='\t' && LA20_46<='\n')||LA20_46=='\r'||LA20_46==' '||(LA20_46>='\"' && LA20_46<='#')||LA20_46=='%'||(LA20_46>='\'' && LA20_46<='-')||LA20_46==':'||LA20_46=='<'||(LA20_46>='>' && LA20_46<='@')||(LA20_46>='[' && LA20_46<=']')||(LA20_46>='{' && LA20_46<='}')) ) {s = 45;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_8 = input.LA(1);

                        s = -1;
                        if ( (LA20_8=='.') ) {s = 30;}

                        else if ( (LA20_8=='E'||LA20_8=='e') ) {s = 31;}

                        else if ( ((LA20_8>='\u0000' && LA20_8<='\b')||(LA20_8>='\u000B' && LA20_8<='\f')||(LA20_8>='\u000E' && LA20_8<='\u001F')||LA20_8=='!'||LA20_8=='$'||LA20_8=='&'||(LA20_8>='/' && LA20_8<='9')||LA20_8==';'||LA20_8=='='||(LA20_8>='A' && LA20_8<='D')||(LA20_8>='F' && LA20_8<='Z')||(LA20_8>='^' && LA20_8<='d')||(LA20_8>='f' && LA20_8<='z')||(LA20_8>='~' && LA20_8<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA20_18 = input.LA(1);

                        s = -1;
                        if ( (LA20_18=='.') ) {s = 43;}

                        else if ( (LA20_18=='/') ) {s = 44;}

                        else if ( ((LA20_18>='\t' && LA20_18<='\n')||LA20_18=='\r'||LA20_18==' '||(LA20_18>='\"' && LA20_18<='#')||LA20_18=='%'||(LA20_18>='\'' && LA20_18<='-')||LA20_18==':'||LA20_18=='<'||(LA20_18>='>' && LA20_18<='@')||(LA20_18>='[' && LA20_18<=']')||(LA20_18>='{' && LA20_18<='}')) ) {s = 45;}

                        else if ( ((LA20_18>='\u0000' && LA20_18<='\b')||(LA20_18>='\u000B' && LA20_18<='\f')||(LA20_18>='\u000E' && LA20_18<='\u001F')||LA20_18=='!'||LA20_18=='$'||LA20_18=='&'||(LA20_18>='0' && LA20_18<='9')||LA20_18==';'||LA20_18=='='||(LA20_18>='A' && LA20_18<='Z')||(LA20_18>='^' && LA20_18<='z')||(LA20_18>='~' && LA20_18<='\uFFFF')) ) {s = 46;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA20_43 = input.LA(1);

                        s = -1;
                        if ( (LA20_43=='/') ) {s = 57;}

                        else if ( ((LA20_43>='\u0000' && LA20_43<='\b')||(LA20_43>='\u000B' && LA20_43<='\f')||(LA20_43>='\u000E' && LA20_43<='\u001F')||LA20_43=='!'||LA20_43=='$'||LA20_43=='&'||(LA20_43>='0' && LA20_43<='9')||LA20_43==';'||LA20_43=='='||(LA20_43>='A' && LA20_43<='Z')||(LA20_43>='^' && LA20_43<='z')||(LA20_43>='~' && LA20_43<='\uFFFF')) ) {s = 58;}

                        else if ( ((LA20_43>='\t' && LA20_43<='\n')||LA20_43=='\r'||LA20_43==' '||(LA20_43>='\"' && LA20_43<='#')||LA20_43=='%'||(LA20_43>='\'' && LA20_43<='.')||LA20_43==':'||LA20_43=='<'||(LA20_43>='>' && LA20_43<='@')||(LA20_43>='[' && LA20_43<=']')||(LA20_43>='{' && LA20_43<='}')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA20_0 = input.LA(1);

                        s = -1;
                        if ( (LA20_0=='*') ) {s = 1;}

                        else if ( (LA20_0=='?') ) {s = 2;}

                        else if ( (LA20_0=='+') ) {s = 3;}

                        else if ( (LA20_0=='#') ) {s = 4;}

                        else if ( (LA20_0=='\n'||LA20_0=='\r') ) {s = 5;}

                        else if ( (LA20_0=='\"') ) {s = 6;}

                        else if ( (LA20_0=='-') ) {s = 7;}

                        else if ( (LA20_0=='0') ) {s = 8;}

                        else if ( ((LA20_0>='1' && LA20_0<='9')) ) {s = 9;}

                        else if ( (LA20_0=='t') ) {s = 10;}

                        else if ( (LA20_0=='f') ) {s = 11;}

                        else if ( (LA20_0=='n') ) {s = 12;}

                        else if ( (LA20_0=='<') ) {s = 13;}

                        else if ( (LA20_0=='>') ) {s = 14;}

                        else if ( (LA20_0=='=') ) {s = 15;}

                        else if ( (LA20_0=='!') ) {s = 16;}

                        else if ( (LA20_0=='~') ) {s = 17;}

                        else if ( (LA20_0=='/') ) {s = 18;}

                        else if ( (LA20_0=='.') ) {s = 19;}

                        else if ( (LA20_0==',') ) {s = 20;}

                        else if ( (LA20_0==':') ) {s = 21;}

                        else if ( (LA20_0=='a') ) {s = 22;}

                        else if ( (LA20_0=='(') ) {s = 23;}

                        else if ( (LA20_0==')') ) {s = 24;}

                        else if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='$'||LA20_0=='&'||LA20_0==';'||(LA20_0>='A' && LA20_0<='Z')||(LA20_0>='^' && LA20_0<='`')||(LA20_0>='b' && LA20_0<='e')||(LA20_0>='g' && LA20_0<='m')||(LA20_0>='o' && LA20_0<='s')||(LA20_0>='u' && LA20_0<='z')||(LA20_0>='\u007F' && LA20_0<='\uFFFF')) ) {s = 25;}

                        else if ( (LA20_0=='\t'||LA20_0==' ') ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA20_64 = input.LA(1);

                        s = -1;
                        if ( ((LA20_64>='\u0000' && LA20_64<='\b')||(LA20_64>='\u000B' && LA20_64<='\f')||(LA20_64>='\u000E' && LA20_64<='\u001F')||LA20_64=='!'||LA20_64=='$'||LA20_64=='&'||(LA20_64>='.' && LA20_64<='9')||LA20_64==';'||LA20_64=='='||(LA20_64>='A' && LA20_64<='Z')||(LA20_64>='^' && LA20_64<='z')||(LA20_64>='~' && LA20_64<='\uFFFF')) ) {s = 25;}

                        else s = 69;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA20_66 = input.LA(1);

                        s = -1;
                        if ( ((LA20_66>='\u0000' && LA20_66<='\b')||(LA20_66>='\u000B' && LA20_66<='\f')||(LA20_66>='\u000E' && LA20_66<='\u001F')||LA20_66=='!'||LA20_66=='$'||LA20_66=='&'||(LA20_66>='.' && LA20_66<='/')||LA20_66==';'||LA20_66=='='||(LA20_66>='A' && LA20_66<='Z')||(LA20_66>='^' && LA20_66<='z')||(LA20_66>='~' && LA20_66<='\uFFFF')) ) {s = 25;}

                        else if ( ((LA20_66>='0' && LA20_66<='9')) ) {s = 66;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA20_57 = input.LA(1);

                        s = -1;
                        if ( ((LA20_57>='A' && LA20_57<='Z')||(LA20_57>='a' && LA20_57<='z')) ) {s = 65;}

                        else if ( (LA20_57=='.') ) {s = 43;}

                        else if ( (LA20_57=='/') ) {s = 57;}

                        else if ( ((LA20_57>='\u0000' && LA20_57<='\b')||(LA20_57>='\u000B' && LA20_57<='\f')||(LA20_57>='\u000E' && LA20_57<='\u001F')||LA20_57=='!'||LA20_57=='$'||LA20_57=='&'||(LA20_57>='0' && LA20_57<='9')||LA20_57==';'||LA20_57=='='||(LA20_57>='^' && LA20_57<='`')||(LA20_57>='~' && LA20_57<='\uFFFF')) ) {s = 58;}

                        else s = 45;

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
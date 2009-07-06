// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-03 16:06:13

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
// SilkSchemaLexer.java
// Since: Jun 28, 2009 1:00:02 PM
//
//--------------------------------------

package org.xerial.silk.schema.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SilkSchemaLexer extends Lexer {
    public static final int Includes=45;
    public static final int RBrace=31;
    public static final int NonWhiteSpaceChar=42;
    public static final int LBracket=32;
    public static final int Class=44;
    public static final int Digit=18;
    public static final int Frac=27;
    public static final int HexDigit=20;
    public static final int Symbol=43;
    public static final int Module=5;
    public static final int Letter=19;
    public static final int Comma=37;
    public static final int Attribute=10;
    public static final int Schema=4;
    public static final int Dot=36;
    public static final int End=46;
    public static final int EscapeSequence=22;
    public static final int Integer=26;
    public static final int Relation=47;
    public static final int Mixin=9;
    public static final int WhiteSpace=53;
    public static final int ClassDef=6;
    public static final int LineComment=16;
    public static final int ModuleName=50;
    public static final int SafeFirstLetter=48;
    public static final int Star=40;
    public static final int Eq=35;
    public static final int Preamble=15;
    public static final int Exp=28;
    public static final int QNameChar=54;
    public static final int RParen=39;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=17;
    public static final int Name=7;
    public static final int ModuleDef=52;
    public static final int LParen=38;
    public static final int String=25;
    public static final int SafeLetter=49;
    public static final int LineBreakChar=14;
    public static final int IsArray=11;
    public static final int QName=55;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int UnsafeUnicodeChar=41;
    public static final int Value=13;
    public static final int LBrace=30;
    public static final int Double=29;
    public static final int Lt=34;
    public static final int RBracket=33;
    public static final int Parent=8;
    public static final int TypeName=12;
    public static final int WhiteSpaces=51;

      


    // delegates
    // delegators

    public SilkSchemaLexer() {;} 
    public SilkSchemaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkSchemaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "SilkSchema.g"; }

    // $ANTLR start "Preamble"
    public final void mPreamble() throws RecognitionException {
        try {
            int _type = Preamble;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:109:9: ({...}? => '%' (~ ( LineBreakChar ) )* )
            // SilkSchema.g:109:11: {...}? => '%' (~ ( LineBreakChar ) )*
            {
            if ( !(( getCharPositionInLine() == 0 )) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "Preamble", " getCharPositionInLine() == 0 ");
            }
            match('%'); if (state.failed) return ;
            // SilkSchema.g:109:52: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkSchema.g:109:52: ~ ( LineBreakChar )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
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
    // $ANTLR end "Preamble"

    // $ANTLR start "LineBreakChar"
    public final void mLineBreakChar() throws RecognitionException {
        try {
            // SilkSchema.g:112:23: ( '\\n' | '\\r' )
            // SilkSchema.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:113:12: ( '#' (~ ( LineBreakChar ) )* )
            // SilkSchema.g:113:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); if (state.failed) return ;
            // SilkSchema.g:113:18: (~ ( LineBreakChar ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:113:18: ~ ( LineBreakChar )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

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
            // SilkSchema.g:116:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // SilkSchema.g:116:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // SilkSchema.g:116:12: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // SilkSchema.g:116:13: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:116:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SilkSchema.g:116:32: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

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
            // SilkSchema.g:119:15: ( '0' .. '9' )
            // SilkSchema.g:119:17: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // SilkSchema.g:120:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // SilkSchema.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:121:18: ( Digit | Letter )
            // SilkSchema.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:122:21: (~ ( '\"' | '\\\\' ) )
            // SilkSchema.g:122:23: ~ ( '\"' | '\\\\' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:124:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // SilkSchema.g:124:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); if (state.failed) return ;
            // SilkSchema.g:124:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt4=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt4=1;
                }
                break;
            case '\\':
                {
                alt4=2;
                }
                break;
            case '/':
                {
                alt4=3;
                }
                break;
            case 'b':
                {
                alt4=4;
                }
                break;
            case 'f':
                {
                alt4=5;
                }
                break;
            case 'n':
                {
                alt4=6;
                }
                break;
            case 'r':
                {
                alt4=7;
                }
                break;
            case 't':
                {
                alt4=8;
                }
                break;
            case 'u':
                {
                alt4=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // SilkSchema.g:124:11: '\\\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:124:18: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SilkSchema.g:124:25: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SilkSchema.g:124:31: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SilkSchema.g:124:37: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SilkSchema.g:124:43: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SilkSchema.g:124:49: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // SilkSchema.g:124:55: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // SilkSchema.g:124:61: 'u' HexDigit HexDigit HexDigit HexDigit
                    {
                    match('u'); if (state.failed) return ;
                    mHexDigit(); if (state.failed) return ;
                    mHexDigit(); if (state.failed) return ;
                    mHexDigit(); if (state.failed) return ;
                    mHexDigit(); if (state.failed) return ;

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
            // SilkSchema.g:127:21: ( UnicodeChar | EscapeSequence )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='\\') ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // SilkSchema.g:127:24: UnicodeChar
                    {
                    mUnicodeChar(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:127:38: EscapeSequence
                    {
                    mEscapeSequence(); if (state.failed) return ;

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
            // SilkSchema.g:128:22: ( ( StringChar )* )
            // SilkSchema.g:128:24: ( StringChar )*
            {
            // SilkSchema.g:128:24: ( StringChar )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SilkSchema.g:128:24: StringChar
            	    {
            	    mStringChar(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
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

            // SilkSchema.g:130:7: ( '\"' s= StringChar_s '\"' )
            // SilkSchema.g:130:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); if (state.failed) return ;
            int sStart264 = getCharIndex();
            mStringChar_s(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart264, getCharIndex()-1);
            match('\"'); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               setText((s!=null?s.getText():null)); 
            }

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
            // SilkSchema.g:133:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // SilkSchema.g:133:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // SilkSchema.g:133:10: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // SilkSchema.g:133:10: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;

            }

            // SilkSchema.g:133:15: ( '0' | '1' .. '9' ( Digit )* )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='0') ) {
                alt9=1;
            }
            else if ( ((LA9_0>='1' && LA9_0<='9')) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // SilkSchema.g:133:16: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:133:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); if (state.failed) return ;
                    // SilkSchema.g:133:31: ( Digit )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // SilkSchema.g:133:31: Digit
                    	    {
                    	    mDigit(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
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
            // SilkSchema.g:134:14: ( '.' ( Digit )+ )
            // SilkSchema.g:134:16: '.' ( Digit )+
            {
            match('.'); if (state.failed) return ;
            // SilkSchema.g:134:20: ( Digit )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // SilkSchema.g:134:20: Digit
            	    {
            	    mDigit(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // SilkSchema.g:135:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // SilkSchema.g:135:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // SilkSchema.g:135:27: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // SilkSchema.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // SilkSchema.g:135:40: ( Digit )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // SilkSchema.g:135:40: Digit
            	    {
            	    mDigit(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            // SilkSchema.g:136:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // SilkSchema.g:136:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); if (state.failed) return ;
            // SilkSchema.g:136:17: ( Frac ( Exp )? | Exp )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='.') ) {
                alt14=1;
            }
            else if ( (LA14_0=='E'||LA14_0=='e') ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // SilkSchema.g:136:18: Frac ( Exp )?
                    {
                    mFrac(); if (state.failed) return ;
                    // SilkSchema.g:136:23: ( Exp )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // SilkSchema.g:136:23: Exp
                            {
                            mExp(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // SilkSchema.g:136:30: Exp
                    {
                    mExp(); if (state.failed) return ;

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

    // $ANTLR start "LBrace"
    public final void mLBrace() throws RecognitionException {
        try {
            int _type = LBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:138:7: ( '{' )
            // SilkSchema.g:138:9: '{'
            {
            match('{'); if (state.failed) return ;

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
            // SilkSchema.g:139:7: ( '}' )
            // SilkSchema.g:139:9: '}'
            {
            match('}'); if (state.failed) return ;

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
            // SilkSchema.g:140:9: ( '[' )
            // SilkSchema.g:140:11: '['
            {
            match('['); if (state.failed) return ;

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
            // SilkSchema.g:141:9: ( ']' )
            // SilkSchema.g:141:11: ']'
            {
            match(']'); if (state.failed) return ;

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
            // SilkSchema.g:143:3: ( '<' )
            // SilkSchema.g:143:5: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lt"

    // $ANTLR start "Eq"
    public final void mEq() throws RecognitionException {
        try {
            int _type = Eq;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:144:3: ( '=' )
            // SilkSchema.g:144:5: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Eq"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:145:4: ( '.' )
            // SilkSchema.g:145:6: '.'
            {
            match('.'); if (state.failed) return ;

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
            // SilkSchema.g:146:6: ( ',' )
            // SilkSchema.g:146:8: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:148:7: ( '(' )
            // SilkSchema.g:148:9: '('
            {
            match('('); if (state.failed) return ;

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
            // SilkSchema.g:149:7: ( ')' )
            // SilkSchema.g:149:9: ')'
            {
            match(')'); if (state.failed) return ;

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
            // SilkSchema.g:151:5: ( '*' )
            // SilkSchema.g:151:7: '*'
            {
            match('*'); if (state.failed) return ;

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
            // SilkSchema.g:154:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
            // SilkSchema.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='#')||input.LA(1)=='%'||(input.LA(1)>='\'' && input.LA(1)<='*')||(input.LA(1)>=',' && input.LA(1)<='.')||input.LA(1)==':'||input.LA(1)=='<'||input.LA(1)=='>'||input.LA(1)=='@'||(input.LA(1)>='[' && input.LA(1)<=']')||(input.LA(1)>='{' && input.LA(1)<='}') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UnsafeUnicodeChar"

    // $ANTLR start "NonWhiteSpaceChar"
    public final void mNonWhiteSpaceChar() throws RecognitionException {
        try {
            // SilkSchema.g:157:18: (~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' ) )
            // SilkSchema.g:157:20: ~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||input.LA(1)=='\u000B'||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)==';'||input.LA(1)=='='||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonWhiteSpaceChar"

    // $ANTLR start "Symbol"
    public final void mSymbol() throws RecognitionException {
        try {
            int _type = Symbol;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:160:7: ( ( ':' NonWhiteSpaceChar )=> ':' ( NonWhiteSpaceChar )+ )
            // SilkSchema.g:160:9: ( ':' NonWhiteSpaceChar )=> ':' ( NonWhiteSpaceChar )+
            {
            match(':'); if (state.failed) return ;
            // SilkSchema.g:160:41: ( NonWhiteSpaceChar )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\b')||LA15_0=='\u000B'||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||LA15_0=='$'||LA15_0=='&'||LA15_0=='+'||(LA15_0>='/' && LA15_0<='9')||LA15_0==';'||LA15_0=='='||LA15_0=='?'||(LA15_0>='A' && LA15_0<='Z')||(LA15_0>='^' && LA15_0<='z')||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // SilkSchema.g:160:41: NonWhiteSpaceChar
            	    {
            	    mNonWhiteSpaceChar(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Symbol"

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:162:6: ( 'class' )
            // SilkSchema.g:162:8: 'class'
            {
            match("class"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Class"

    // $ANTLR start "Includes"
    public final void mIncludes() throws RecognitionException {
        try {
            int _type = Includes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:163:9: ( 'includes' )
            // SilkSchema.g:163:11: 'includes'
            {
            match("includes"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Includes"

    // $ANTLR start "End"
    public final void mEnd() throws RecognitionException {
        try {
            int _type = End;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:164:4: ( 'end' )
            // SilkSchema.g:164:6: 'end'
            {
            match("end"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "End"

    // $ANTLR start "Relation"
    public final void mRelation() throws RecognitionException {
        try {
            int _type = Relation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:165:9: ( 'relation' )
            // SilkSchema.g:165:11: 'relation'
            {
            match("relation"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Relation"

    // $ANTLR start "SafeFirstLetter"
    public final void mSafeFirstLetter() throws RecognitionException {
        try {
            // SilkSchema.g:167:25: ( 'A' .. 'Z' | 'a' .. 'z' )
            // SilkSchema.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:168:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
            // SilkSchema.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SafeLetter"

    // $ANTLR start "ModuleName"
    public final void mModuleName() throws RecognitionException {
        try {
            // SilkSchema.g:170:20: ( SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )* )
            // SilkSchema.g:170:22: SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )*
            {
            mSafeFirstLetter(); if (state.failed) return ;
            // SilkSchema.g:170:38: ( SafeLetter )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='-'||(LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // SilkSchema.g:170:38: SafeLetter
            	    {
            	    mSafeLetter(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // SilkSchema.g:170:50: ( '.' SafeFirstLetter ( SafeLetter )* )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // SilkSchema.g:170:51: '.' SafeFirstLetter ( SafeLetter )*
            	    {
            	    match('.'); if (state.failed) return ;
            	    mSafeFirstLetter(); if (state.failed) return ;
            	    // SilkSchema.g:170:71: ( SafeLetter )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='-'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // SilkSchema.g:170:71: SafeLetter
            	    	    {
            	    	    mSafeLetter(); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "ModuleName"

    // $ANTLR start "ModuleDef"
    public final void mModuleDef() throws RecognitionException {
        try {
            int _type = ModuleDef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token s=null;

            // SilkSchema.g:171:10: ( 'module' WhiteSpaces s= ModuleName )
            // SilkSchema.g:171:12: 'module' WhiteSpaces s= ModuleName
            {
            match("module"); if (state.failed) return ;

            mWhiteSpaces(); if (state.failed) return ;
            int sStart689 = getCharIndex();
            mModuleName(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart689, getCharIndex()-1);
            if ( state.backtracking==0 ) {
               setText((s!=null?s.getText():null)); 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ModuleDef"

    // $ANTLR start "QNameChar"
    public final void mQNameChar() throws RecognitionException {
        try {
            // SilkSchema.g:173:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // SilkSchema.g:173:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||input.LA(1)=='$'||input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)==';'||input.LA(1)=='='||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='z')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:174:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // SilkSchema.g:174:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // SilkSchema.g:174:8: ( QNameChar )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||LA19_0=='!'||LA19_0=='$'||LA19_0=='&'||LA19_0=='+'||(LA19_0>='/' && LA19_0<='9')||LA19_0==';'||LA19_0=='='||LA19_0=='?'||(LA19_0>='A' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='z')||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // SilkSchema.g:174:8: QNameChar
            	    {
            	    mQNameChar(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // SilkSchema.g:174:19: ( Dot ( QNameChar )+ )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='.') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // SilkSchema.g:174:20: Dot ( QNameChar )+
            	    {
            	    mDot(); if (state.failed) return ;
            	    // SilkSchema.g:174:24: ( QNameChar )+
            	    int cnt20=0;
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='!'||LA20_0=='$'||LA20_0=='&'||LA20_0=='+'||(LA20_0>='/' && LA20_0<='9')||LA20_0==';'||LA20_0=='='||LA20_0=='?'||(LA20_0>='A' && LA20_0<='Z')||(LA20_0>='^' && LA20_0<='z')||(LA20_0>='~' && LA20_0<='\uFFFF')) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // SilkSchema.g:174:24: QNameChar
            	    	    {
            	    	    mQNameChar(); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt20 >= 1 ) break loop20;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(20, input);
            	                throw eee;
            	        }
            	        cnt20++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop21;
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
            // SilkSchema.g:177:11: ( ' ' | '\\t' )
            // SilkSchema.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            // SilkSchema.g:179:12: ( ( WhiteSpace )+ )
            // SilkSchema.g:179:14: ( WhiteSpace )+
            {
            // SilkSchema.g:179:14: ( WhiteSpace )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\t'||LA22_0==' ') ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // SilkSchema.g:179:14: WhiteSpace
            	    {
            	    mWhiteSpace(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpaces"

    public void mTokens() throws RecognitionException {
        // SilkSchema.g:1:8: ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Eq | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | ModuleDef | QName | WhiteSpaces )
        int alt23=25;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // SilkSchema.g:1:10: Preamble
                {
                mPreamble(); if (state.failed) return ;

                }
                break;
            case 2 :
                // SilkSchema.g:1:19: LineComment
                {
                mLineComment(); if (state.failed) return ;

                }
                break;
            case 3 :
                // SilkSchema.g:1:31: LineBreak
                {
                mLineBreak(); if (state.failed) return ;

                }
                break;
            case 4 :
                // SilkSchema.g:1:41: String
                {
                mString(); if (state.failed) return ;

                }
                break;
            case 5 :
                // SilkSchema.g:1:48: Integer
                {
                mInteger(); if (state.failed) return ;

                }
                break;
            case 6 :
                // SilkSchema.g:1:56: Double
                {
                mDouble(); if (state.failed) return ;

                }
                break;
            case 7 :
                // SilkSchema.g:1:63: LBrace
                {
                mLBrace(); if (state.failed) return ;

                }
                break;
            case 8 :
                // SilkSchema.g:1:70: RBrace
                {
                mRBrace(); if (state.failed) return ;

                }
                break;
            case 9 :
                // SilkSchema.g:1:77: LBracket
                {
                mLBracket(); if (state.failed) return ;

                }
                break;
            case 10 :
                // SilkSchema.g:1:86: RBracket
                {
                mRBracket(); if (state.failed) return ;

                }
                break;
            case 11 :
                // SilkSchema.g:1:95: Lt
                {
                mLt(); if (state.failed) return ;

                }
                break;
            case 12 :
                // SilkSchema.g:1:98: Eq
                {
                mEq(); if (state.failed) return ;

                }
                break;
            case 13 :
                // SilkSchema.g:1:101: Dot
                {
                mDot(); if (state.failed) return ;

                }
                break;
            case 14 :
                // SilkSchema.g:1:105: Comma
                {
                mComma(); if (state.failed) return ;

                }
                break;
            case 15 :
                // SilkSchema.g:1:111: LParen
                {
                mLParen(); if (state.failed) return ;

                }
                break;
            case 16 :
                // SilkSchema.g:1:118: RParen
                {
                mRParen(); if (state.failed) return ;

                }
                break;
            case 17 :
                // SilkSchema.g:1:125: Star
                {
                mStar(); if (state.failed) return ;

                }
                break;
            case 18 :
                // SilkSchema.g:1:130: Symbol
                {
                mSymbol(); if (state.failed) return ;

                }
                break;
            case 19 :
                // SilkSchema.g:1:137: Class
                {
                mClass(); if (state.failed) return ;

                }
                break;
            case 20 :
                // SilkSchema.g:1:143: Includes
                {
                mIncludes(); if (state.failed) return ;

                }
                break;
            case 21 :
                // SilkSchema.g:1:152: End
                {
                mEnd(); if (state.failed) return ;

                }
                break;
            case 22 :
                // SilkSchema.g:1:156: Relation
                {
                mRelation(); if (state.failed) return ;

                }
                break;
            case 23 :
                // SilkSchema.g:1:165: ModuleDef
                {
                mModuleDef(); if (state.failed) return ;

                }
                break;
            case 24 :
                // SilkSchema.g:1:175: QName
                {
                mQName(); if (state.failed) return ;

                }
                break;
            case 25 :
                // SilkSchema.g:1:181: WhiteSpaces
                {
                mWhiteSpaces(); if (state.failed) return ;

                }
                break;

        }

    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\6\uffff\2\35\5\uffff\1\41\6\uffff\5\31\2\uffff\2\35\2\uffff\1"+
        "\31\1\35\1\uffff\5\31\1\uffff\1\35\1\47\1\31\1\47\2\31\1\64\5\31"+
        "\1\uffff\3\31\1\47\1\75\3\31\1\uffff\5\31\1\uffff\1\106\1\107\2"+
        "\uffff";
    static final String DFA23_eofS =
        "\110\uffff";
    static final String DFA23_minS =
        "\1\0\4\uffff\1\60\2\0\5\uffff\1\0\6\uffff\1\154\2\156\1\145\1\157"+
        "\2\uffff\2\56\1\uffff\1\0\1\53\1\0\1\uffff\1\141\1\143\1\144\1\154"+
        "\1\144\1\uffff\1\56\1\0\1\60\1\0\1\163\1\154\1\0\1\141\1\165\1\53"+
        "\1\163\1\165\1\uffff\1\164\1\154\1\60\2\0\1\144\1\151\1\145\1\uffff"+
        "\1\145\1\157\1\11\1\163\1\156\1\uffff\2\0\2\uffff";
    static final String DFA23_maxS =
        "\1\uffff\4\uffff\1\71\2\uffff\5\uffff\1\uffff\6\uffff\1\154\2\156"+
        "\1\145\1\157\2\uffff\2\145\1\uffff\1\uffff\1\71\1\uffff\1\uffff"+
        "\1\141\1\143\1\144\1\154\1\144\1\uffff\1\145\1\uffff\1\71\1\uffff"+
        "\1\163\1\154\1\uffff\1\141\1\165\1\71\1\163\1\165\1\uffff\1\164"+
        "\1\154\1\71\2\uffff\1\144\1\151\1\145\1\uffff\1\145\1\157\1\40\1"+
        "\163\1\156\1\uffff\2\uffff\2\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\7\1\10\1\11\1\12\1\13\1\uffff"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\5\uffff\1\30\1\31\2\uffff\1\5\3\uffff"+
        "\1\14\5\uffff\1\6\14\uffff\1\25\10\uffff\1\23\5\uffff\1\27\2\uffff"+
        "\1\24\1\26";
    static final String DFA23_specialS =
        "\1\4\5\uffff\1\3\1\10\5\uffff\1\2\20\uffff\1\0\1\uffff\1\11\10"+
        "\uffff\1\1\1\uffff\1\7\2\uffff\1\5\11\uffff\1\13\1\6\12\uffff\1"+
        "\14\1\12\2\uffff}>";
    static final String[] DFA23_transitionS = {
            "\11\31\1\32\1\3\2\31\1\3\22\31\1\32\1\31\1\4\1\2\1\31\1\1\1"+
            "\31\1\uffff\1\20\1\21\1\22\1\31\1\17\1\5\1\16\1\31\1\6\11\7"+
            "\1\23\1\31\1\14\1\15\1\uffff\1\31\1\uffff\32\31\1\12\1\uffff"+
            "\1\13\5\31\1\24\1\31\1\26\3\31\1\25\3\31\1\30\4\31\1\27\10\31"+
            "\1\10\1\uffff\1\11\uff82\31",
            "",
            "",
            "",
            "",
            "\1\33\11\34",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\1\36\13\31\1\uffff\1\31\1"+
            "\uffff\1\31\1\uffff\1\31\1\uffff\4\31\1\37\25\31\3\uffff\7\31"+
            "\1\37\25\31\3\uffff\uff82\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\1\36\1\31\12\40\1\uffff\1"+
            "\31\1\uffff\1\31\1\uffff\1\31\1\uffff\4\31\1\37\25\31\3\uffff"+
            "\7\31\1\37\25\31\3\uffff\uff82\31",
            "",
            "",
            "",
            "",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\14\31\1\uffff\1\31\1\uffff"+
            "\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff\uff82"+
            "\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "",
            "\1\47\26\uffff\1\47\37\uffff\1\47",
            "\1\47\1\uffff\12\50\13\uffff\1\47\37\uffff\1\47",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\3\uffff\1\31\12\51\1\uffff\1\31\1"+
            "\uffff\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff"+
            "\uff82\31",
            "\1\52\1\uffff\1\47\2\uffff\12\53",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\1\36\1\31\12\40\1\uffff\1"+
            "\31\1\uffff\1\31\1\uffff\1\31\1\uffff\4\31\1\37\25\31\3\uffff"+
            "\7\31\1\37\25\31\3\uffff\uff82\31",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "\1\47\1\uffff\12\50\13\uffff\1\47\37\uffff\1\47",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\2\31\12\51\1\uffff\1\31\1"+
            "\uffff\1\31\1\uffff\1\31\1\uffff\4\31\1\61\25\31\3\uffff\7\31"+
            "\1\61\25\31\3\uffff\uff82\31",
            "\12\53",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\2\31\12\53\1\uffff\1\31\1"+
            "\uffff\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff"+
            "\uff82\31",
            "\1\62",
            "\1\63",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\14\31\1\uffff\1\31\1\uffff"+
            "\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff\uff82"+
            "\31",
            "\1\65",
            "\1\66",
            "\1\67\1\uffff\1\47\2\uffff\12\70",
            "\1\71",
            "\1\72",
            "",
            "\1\73",
            "\1\74",
            "\12\70",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\2\31\12\70\1\uffff\1\31\1"+
            "\uffff\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff"+
            "\uff82\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\14\31\1\uffff\1\31\1\uffff"+
            "\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff\uff82"+
            "\31",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103\26\uffff\1\103",
            "\1\104",
            "\1\105",
            "",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\14\31\1\uffff\1\31\1\uffff"+
            "\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff\uff82"+
            "\31",
            "\11\31\2\uffff\2\31\1\uffff\22\31\1\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\31\4\uffff\1\31\2\uffff\14\31\1\uffff\1\31\1\uffff"+
            "\1\31\1\uffff\1\31\1\uffff\32\31\3\uffff\35\31\3\uffff\uff82"+
            "\31",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Eq | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | ModuleDef | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_30 = input.LA(1);

                        s = -1;
                        if ( ((LA23_30>='0' && LA23_30<='9')) ) {s = 41;}

                        else if ( ((LA23_30>='\u0000' && LA23_30<='\b')||(LA23_30>='\u000B' && LA23_30<='\f')||(LA23_30>='\u000E' && LA23_30<='\u001F')||LA23_30=='!'||LA23_30=='$'||LA23_30=='&'||LA23_30=='+'||LA23_30=='/'||LA23_30==';'||LA23_30=='='||LA23_30=='?'||(LA23_30>='A' && LA23_30<='Z')||(LA23_30>='^' && LA23_30<='z')||(LA23_30>='~' && LA23_30<='\uFFFF')) ) {s = 25;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_41 = input.LA(1);

                        s = -1;
                        if ( ((LA23_41>='\u0000' && LA23_41<='\b')||(LA23_41>='\u000B' && LA23_41<='\f')||(LA23_41>='\u000E' && LA23_41<='\u001F')||LA23_41=='!'||LA23_41=='$'||LA23_41=='&'||LA23_41=='+'||(LA23_41>='.' && LA23_41<='/')||LA23_41==';'||LA23_41=='='||LA23_41=='?'||(LA23_41>='A' && LA23_41<='D')||(LA23_41>='F' && LA23_41<='Z')||(LA23_41>='^' && LA23_41<='d')||(LA23_41>='f' && LA23_41<='z')||(LA23_41>='~' && LA23_41<='\uFFFF')) ) {s = 25;}

                        else if ( (LA23_41=='E'||LA23_41=='e') ) {s = 49;}

                        else if ( ((LA23_41>='0' && LA23_41<='9')) ) {s = 41;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_13 = input.LA(1);

                        s = -1;
                        if ( ((LA23_13>='\u0000' && LA23_13<='\b')||(LA23_13>='\u000B' && LA23_13<='\f')||(LA23_13>='\u000E' && LA23_13<='\u001F')||LA23_13=='!'||LA23_13=='$'||LA23_13=='&'||LA23_13=='+'||(LA23_13>='.' && LA23_13<='9')||LA23_13==';'||LA23_13=='='||LA23_13=='?'||(LA23_13>='A' && LA23_13<='Z')||(LA23_13>='^' && LA23_13<='z')||(LA23_13>='~' && LA23_13<='\uFFFF')) ) {s = 25;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_6 = input.LA(1);

                        s = -1;
                        if ( (LA23_6=='.') ) {s = 30;}

                        else if ( (LA23_6=='E'||LA23_6=='e') ) {s = 31;}

                        else if ( ((LA23_6>='\u0000' && LA23_6<='\b')||(LA23_6>='\u000B' && LA23_6<='\f')||(LA23_6>='\u000E' && LA23_6<='\u001F')||LA23_6=='!'||LA23_6=='$'||LA23_6=='&'||LA23_6=='+'||(LA23_6>='/' && LA23_6<='9')||LA23_6==';'||LA23_6=='='||LA23_6=='?'||(LA23_6>='A' && LA23_6<='D')||(LA23_6>='F' && LA23_6<='Z')||(LA23_6>='^' && LA23_6<='d')||(LA23_6>='f' && LA23_6<='z')||(LA23_6>='~' && LA23_6<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0=='%') && (( getCharPositionInLine() == 0 ))) {s = 1;}

                        else if ( (LA23_0=='#') ) {s = 2;}

                        else if ( (LA23_0=='\n'||LA23_0=='\r') ) {s = 3;}

                        else if ( (LA23_0=='\"') ) {s = 4;}

                        else if ( (LA23_0=='-') ) {s = 5;}

                        else if ( (LA23_0=='0') ) {s = 6;}

                        else if ( ((LA23_0>='1' && LA23_0<='9')) ) {s = 7;}

                        else if ( (LA23_0=='{') ) {s = 8;}

                        else if ( (LA23_0=='}') ) {s = 9;}

                        else if ( (LA23_0=='[') ) {s = 10;}

                        else if ( (LA23_0==']') ) {s = 11;}

                        else if ( (LA23_0=='<') ) {s = 12;}

                        else if ( (LA23_0=='=') ) {s = 13;}

                        else if ( (LA23_0=='.') ) {s = 14;}

                        else if ( (LA23_0==',') ) {s = 15;}

                        else if ( (LA23_0=='(') ) {s = 16;}

                        else if ( (LA23_0==')') ) {s = 17;}

                        else if ( (LA23_0=='*') ) {s = 18;}

                        else if ( (LA23_0==':') ) {s = 19;}

                        else if ( (LA23_0=='c') ) {s = 20;}

                        else if ( (LA23_0=='i') ) {s = 21;}

                        else if ( (LA23_0=='e') ) {s = 22;}

                        else if ( (LA23_0=='r') ) {s = 23;}

                        else if ( (LA23_0=='m') ) {s = 24;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||LA23_0=='&'||LA23_0=='+'||LA23_0=='/'||LA23_0==';'||LA23_0=='?'||(LA23_0>='A' && LA23_0<='Z')||(LA23_0>='^' && LA23_0<='b')||LA23_0=='d'||(LA23_0>='f' && LA23_0<='h')||(LA23_0>='j' && LA23_0<='l')||(LA23_0>='n' && LA23_0<='q')||(LA23_0>='s' && LA23_0<='z')||(LA23_0>='~' && LA23_0<='\uFFFF')) ) {s = 25;}

                        else if ( (LA23_0=='\t'||LA23_0==' ') ) {s = 26;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_46 = input.LA(1);

                        s = -1;
                        if ( ((LA23_46>='\u0000' && LA23_46<='\b')||(LA23_46>='\u000B' && LA23_46<='\f')||(LA23_46>='\u000E' && LA23_46<='\u001F')||LA23_46=='!'||LA23_46=='$'||LA23_46=='&'||LA23_46=='+'||(LA23_46>='.' && LA23_46<='9')||LA23_46==';'||LA23_46=='='||LA23_46=='?'||(LA23_46>='A' && LA23_46<='Z')||(LA23_46>='^' && LA23_46<='z')||(LA23_46>='~' && LA23_46<='\uFFFF')) ) {s = 25;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_57 = input.LA(1);

                        s = -1;
                        if ( ((LA23_57>='\u0000' && LA23_57<='\b')||(LA23_57>='\u000B' && LA23_57<='\f')||(LA23_57>='\u000E' && LA23_57<='\u001F')||LA23_57=='!'||LA23_57=='$'||LA23_57=='&'||LA23_57=='+'||(LA23_57>='.' && LA23_57<='9')||LA23_57==';'||LA23_57=='='||LA23_57=='?'||(LA23_57>='A' && LA23_57<='Z')||(LA23_57>='^' && LA23_57<='z')||(LA23_57>='~' && LA23_57<='\uFFFF')) ) {s = 25;}

                        else s = 61;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_43 = input.LA(1);

                        s = -1;
                        if ( ((LA23_43>='0' && LA23_43<='9')) ) {s = 43;}

                        else if ( ((LA23_43>='\u0000' && LA23_43<='\b')||(LA23_43>='\u000B' && LA23_43<='\f')||(LA23_43>='\u000E' && LA23_43<='\u001F')||LA23_43=='!'||LA23_43=='$'||LA23_43=='&'||LA23_43=='+'||(LA23_43>='.' && LA23_43<='/')||LA23_43==';'||LA23_43=='='||LA23_43=='?'||(LA23_43>='A' && LA23_43<='Z')||(LA23_43>='^' && LA23_43<='z')||(LA23_43>='~' && LA23_43<='\uFFFF')) ) {s = 25;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_7 = input.LA(1);

                        s = -1;
                        if ( ((LA23_7>='0' && LA23_7<='9')) ) {s = 32;}

                        else if ( (LA23_7=='.') ) {s = 30;}

                        else if ( (LA23_7=='E'||LA23_7=='e') ) {s = 31;}

                        else if ( ((LA23_7>='\u0000' && LA23_7<='\b')||(LA23_7>='\u000B' && LA23_7<='\f')||(LA23_7>='\u000E' && LA23_7<='\u001F')||LA23_7=='!'||LA23_7=='$'||LA23_7=='&'||LA23_7=='+'||LA23_7=='/'||LA23_7==';'||LA23_7=='='||LA23_7=='?'||(LA23_7>='A' && LA23_7<='D')||(LA23_7>='F' && LA23_7<='Z')||(LA23_7>='^' && LA23_7<='d')||(LA23_7>='f' && LA23_7<='z')||(LA23_7>='~' && LA23_7<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_32 = input.LA(1);

                        s = -1;
                        if ( (LA23_32=='.') ) {s = 30;}

                        else if ( (LA23_32=='E'||LA23_32=='e') ) {s = 31;}

                        else if ( ((LA23_32>='0' && LA23_32<='9')) ) {s = 32;}

                        else if ( ((LA23_32>='\u0000' && LA23_32<='\b')||(LA23_32>='\u000B' && LA23_32<='\f')||(LA23_32>='\u000E' && LA23_32<='\u001F')||LA23_32=='!'||LA23_32=='$'||LA23_32=='&'||LA23_32=='+'||LA23_32=='/'||LA23_32==';'||LA23_32=='='||LA23_32=='?'||(LA23_32>='A' && LA23_32<='D')||(LA23_32>='F' && LA23_32<='Z')||(LA23_32>='^' && LA23_32<='d')||(LA23_32>='f' && LA23_32<='z')||(LA23_32>='~' && LA23_32<='\uFFFF')) ) {s = 25;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_69 = input.LA(1);

                        s = -1;
                        if ( ((LA23_69>='\u0000' && LA23_69<='\b')||(LA23_69>='\u000B' && LA23_69<='\f')||(LA23_69>='\u000E' && LA23_69<='\u001F')||LA23_69=='!'||LA23_69=='$'||LA23_69=='&'||LA23_69=='+'||(LA23_69>='.' && LA23_69<='9')||LA23_69==';'||LA23_69=='='||LA23_69=='?'||(LA23_69>='A' && LA23_69<='Z')||(LA23_69>='^' && LA23_69<='z')||(LA23_69>='~' && LA23_69<='\uFFFF')) ) {s = 25;}

                        else s = 71;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_56 = input.LA(1);

                        s = -1;
                        if ( ((LA23_56>='\u0000' && LA23_56<='\b')||(LA23_56>='\u000B' && LA23_56<='\f')||(LA23_56>='\u000E' && LA23_56<='\u001F')||LA23_56=='!'||LA23_56=='$'||LA23_56=='&'||LA23_56=='+'||(LA23_56>='.' && LA23_56<='/')||LA23_56==';'||LA23_56=='='||LA23_56=='?'||(LA23_56>='A' && LA23_56<='Z')||(LA23_56>='^' && LA23_56<='z')||(LA23_56>='~' && LA23_56<='\uFFFF')) ) {s = 25;}

                        else if ( ((LA23_56>='0' && LA23_56<='9')) ) {s = 56;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_68 = input.LA(1);

                        s = -1;
                        if ( ((LA23_68>='\u0000' && LA23_68<='\b')||(LA23_68>='\u000B' && LA23_68<='\f')||(LA23_68>='\u000E' && LA23_68<='\u001F')||LA23_68=='!'||LA23_68=='$'||LA23_68=='&'||LA23_68=='+'||(LA23_68>='.' && LA23_68<='9')||LA23_68==';'||LA23_68=='='||LA23_68=='?'||(LA23_68>='A' && LA23_68<='Z')||(LA23_68>='^' && LA23_68<='z')||(LA23_68>='~' && LA23_68<='\uFFFF')) ) {s = 25;}

                        else s = 70;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
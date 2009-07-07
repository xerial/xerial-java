// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-07 14:42:05

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
    public static final int NonWhiteSpaceChar=41;
    public static final int LBracket=32;
    public static final int Class=44;
    public static final int SymbolChars=42;
    public static final int Digit=18;
    public static final int Frac=27;
    public static final int HexDigit=20;
    public static final int Symbol=43;
    public static final int Default=50;
    public static final int Index=48;
    public static final int Module=5;
    public static final int Letter=19;
    public static final int Comma=36;
    public static final int Attribute=10;
    public static final int Schema=4;
    public static final int Dot=35;
    public static final int End=46;
    public static final int EscapeSequence=22;
    public static final int DefaultValue=13;
    public static final int Integer=26;
    public static final int Relation=47;
    public static final int Mixin=9;
    public static final int WhiteSpace=56;
    public static final int ClassDef=6;
    public static final int LineComment=16;
    public static final int ModuleName=53;
    public static final int BelongsTo=49;
    public static final int SafeFirstLetter=51;
    public static final int Star=39;
    public static final int Preamble=15;
    public static final int Exp=28;
    public static final int QNameChar=57;
    public static final int RParen=38;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=17;
    public static final int Name=7;
    public static final int LParen=37;
    public static final int ModuleDef=55;
    public static final int String=25;
    public static final int SafeLetter=52;
    public static final int LineBreakChar=14;
    public static final int IsArray=11;
    public static final int QName=58;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int UnsafeUnicodeChar=40;
    public static final int LBrace=30;
    public static final int Double=29;
    public static final int Lt=34;
    public static final int RBracket=33;
    public static final int Parent=8;
    public static final int TypeName=12;
    public static final int WhiteSpaces=54;

      


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

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:144:4: ( '.' )
            // SilkSchema.g:144:6: '.'
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
            // SilkSchema.g:145:6: ( ',' )
            // SilkSchema.g:145:8: ','
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
            // SilkSchema.g:147:7: ( '(' )
            // SilkSchema.g:147:9: '('
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
            // SilkSchema.g:148:7: ( ')' )
            // SilkSchema.g:148:9: ')'
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
            // SilkSchema.g:150:5: ( '*' )
            // SilkSchema.g:150:7: '*'
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
            // SilkSchema.g:153:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
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
            // SilkSchema.g:156:18: (~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' ) )
            // SilkSchema.g:156:20: ~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' )
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

    // $ANTLR start "SymbolChars"
    public final void mSymbolChars() throws RecognitionException {
        try {
            // SilkSchema.g:158:21: ( ( NonWhiteSpaceChar )+ )
            // SilkSchema.g:158:23: ( NonWhiteSpaceChar )+
            {
            // SilkSchema.g:158:23: ( NonWhiteSpaceChar )+
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
            	    // SilkSchema.g:158:23: NonWhiteSpaceChar
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

        }
        finally {
        }
    }
    // $ANTLR end "SymbolChars"

    // $ANTLR start "Symbol"
    public final void mSymbol() throws RecognitionException {
        try {
            int _type = Symbol;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token s=null;

            // SilkSchema.g:159:7: ( ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars )
            // SilkSchema.g:159:9: ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars
            {
            match(':'); if (state.failed) return ;
            int sStart579 = getCharIndex();
            mSymbolChars(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart579, getCharIndex()-1);
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
    // $ANTLR end "Symbol"

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:161:6: ( 'class' )
            // SilkSchema.g:161:8: 'class'
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
            // SilkSchema.g:162:9: ( 'includes' )
            // SilkSchema.g:162:11: 'includes'
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
            // SilkSchema.g:163:4: ( 'end' )
            // SilkSchema.g:163:6: 'end'
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
            // SilkSchema.g:164:9: ( 'relation' )
            // SilkSchema.g:164:11: 'relation'
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

    // $ANTLR start "Index"
    public final void mIndex() throws RecognitionException {
        try {
            int _type = Index;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:165:6: ( 'index' )
            // SilkSchema.g:165:8: 'index'
            {
            match("index"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Index"

    // $ANTLR start "BelongsTo"
    public final void mBelongsTo() throws RecognitionException {
        try {
            int _type = BelongsTo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:166:10: ( 'belongs_to' )
            // SilkSchema.g:166:12: 'belongs_to'
            {
            match("belongs_to"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BelongsTo"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:167:8: ( 'default' )
            // SilkSchema.g:167:10: 'default'
            {
            match("default"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "SafeFirstLetter"
    public final void mSafeFirstLetter() throws RecognitionException {
        try {
            // SilkSchema.g:169:25: ( 'A' .. 'Z' | 'a' .. 'z' )
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
            // SilkSchema.g:170:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
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
            // SilkSchema.g:172:20: ( SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )* )
            // SilkSchema.g:172:22: SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )*
            {
            mSafeFirstLetter(); if (state.failed) return ;
            // SilkSchema.g:172:38: ( SafeLetter )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='-'||(LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // SilkSchema.g:172:38: SafeLetter
            	    {
            	    mSafeLetter(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // SilkSchema.g:172:50: ( '.' SafeFirstLetter ( SafeLetter )* )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // SilkSchema.g:172:51: '.' SafeFirstLetter ( SafeLetter )*
            	    {
            	    match('.'); if (state.failed) return ;
            	    mSafeFirstLetter(); if (state.failed) return ;
            	    // SilkSchema.g:172:71: ( SafeLetter )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='-'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // SilkSchema.g:172:71: SafeLetter
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

            // SilkSchema.g:173:10: ( 'module' WhiteSpaces s= ModuleName )
            // SilkSchema.g:173:12: 'module' WhiteSpaces s= ModuleName
            {
            match("module"); if (state.failed) return ;

            mWhiteSpaces(); if (state.failed) return ;
            int sStart715 = getCharIndex();
            mModuleName(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart715, getCharIndex()-1);
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
            // SilkSchema.g:175:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // SilkSchema.g:175:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
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
            // SilkSchema.g:176:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // SilkSchema.g:176:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // SilkSchema.g:176:8: ( QNameChar )+
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
            	    // SilkSchema.g:176:8: QNameChar
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

            // SilkSchema.g:176:19: ( Dot ( QNameChar )+ )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='.') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // SilkSchema.g:176:20: Dot ( QNameChar )+
            	    {
            	    mDot(); if (state.failed) return ;
            	    // SilkSchema.g:176:24: ( QNameChar )+
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
            	    	    // SilkSchema.g:176:24: QNameChar
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
            // SilkSchema.g:179:11: ( ' ' | '\\t' )
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
            // SilkSchema.g:181:12: ( ( WhiteSpace )+ )
            // SilkSchema.g:181:14: ( WhiteSpace )+
            {
            // SilkSchema.g:181:14: ( WhiteSpace )+
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
            	    // SilkSchema.g:181:14: WhiteSpace
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
        // SilkSchema.g:1:8: ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | ModuleDef | QName | WhiteSpaces )
        int alt23=27;
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
                // SilkSchema.g:1:98: Dot
                {
                mDot(); if (state.failed) return ;

                }
                break;
            case 13 :
                // SilkSchema.g:1:102: Comma
                {
                mComma(); if (state.failed) return ;

                }
                break;
            case 14 :
                // SilkSchema.g:1:108: LParen
                {
                mLParen(); if (state.failed) return ;

                }
                break;
            case 15 :
                // SilkSchema.g:1:115: RParen
                {
                mRParen(); if (state.failed) return ;

                }
                break;
            case 16 :
                // SilkSchema.g:1:122: Star
                {
                mStar(); if (state.failed) return ;

                }
                break;
            case 17 :
                // SilkSchema.g:1:127: Symbol
                {
                mSymbol(); if (state.failed) return ;

                }
                break;
            case 18 :
                // SilkSchema.g:1:134: Class
                {
                mClass(); if (state.failed) return ;

                }
                break;
            case 19 :
                // SilkSchema.g:1:140: Includes
                {
                mIncludes(); if (state.failed) return ;

                }
                break;
            case 20 :
                // SilkSchema.g:1:149: End
                {
                mEnd(); if (state.failed) return ;

                }
                break;
            case 21 :
                // SilkSchema.g:1:153: Relation
                {
                mRelation(); if (state.failed) return ;

                }
                break;
            case 22 :
                // SilkSchema.g:1:162: Index
                {
                mIndex(); if (state.failed) return ;

                }
                break;
            case 23 :
                // SilkSchema.g:1:168: BelongsTo
                {
                mBelongsTo(); if (state.failed) return ;

                }
                break;
            case 24 :
                // SilkSchema.g:1:178: Default
                {
                mDefault(); if (state.failed) return ;

                }
                break;
            case 25 :
                // SilkSchema.g:1:186: ModuleDef
                {
                mModuleDef(); if (state.failed) return ;

                }
                break;
            case 26 :
                // SilkSchema.g:1:196: QName
                {
                mQName(); if (state.failed) return ;

                }
                break;
            case 27 :
                // SilkSchema.g:1:202: WhiteSpaces
                {
                mWhiteSpaces(); if (state.failed) return ;

                }
                break;

        }

    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\6\uffff\2\36\13\uffff\7\32\2\uffff\2\36\2\uffff\1\32\1\36\7\32"+
        "\1\uffff\1\36\1\51\1\32\1\51\3\32\1\72\10\32\1\uffff\5\32\1\51\1"+
        "\110\1\32\1\112\4\32\1\uffff\1\32\1\uffff\7\32\1\127\1\uffff\1\130"+
        "\1\131\1\32\3\uffff\1\32\1\134\1\uffff";
    static final String DFA23_eofS =
        "\135\uffff";
    static final String DFA23_minS =
        "\1\0\4\uffff\1\60\2\0\13\uffff\1\154\2\156\3\145\1\157\2\uffff"+
        "\2\56\1\uffff\1\0\1\53\1\0\1\141\1\143\1\144\2\154\1\146\1\144\1"+
        "\uffff\1\56\1\0\1\60\1\0\1\163\1\154\1\145\1\0\1\141\1\157\1\141"+
        "\1\165\1\53\1\163\1\165\1\170\1\uffff\1\164\1\156\1\165\1\154\1"+
        "\60\2\0\1\144\1\0\1\151\1\147\1\154\1\145\1\uffff\1\145\1\uffff"+
        "\1\157\1\163\1\164\1\11\1\163\1\156\1\137\1\0\1\uffff\2\0\1\164"+
        "\3\uffff\1\157\1\0\1\uffff";
    static final String DFA23_maxS =
        "\1\uffff\4\uffff\1\71\2\uffff\13\uffff\1\154\2\156\3\145\1\157"+
        "\2\uffff\2\145\1\uffff\1\uffff\1\71\1\uffff\1\141\2\144\2\154\1"+
        "\146\1\144\1\uffff\1\145\1\uffff\1\71\1\uffff\1\163\1\154\1\145"+
        "\1\uffff\1\141\1\157\1\141\1\165\1\71\1\163\1\165\1\170\1\uffff"+
        "\1\164\1\156\1\165\1\154\1\71\2\uffff\1\144\1\uffff\1\151\1\147"+
        "\1\154\1\145\1\uffff\1\145\1\uffff\1\157\1\163\1\164\1\40\1\163"+
        "\1\156\1\137\1\uffff\1\uffff\2\uffff\1\164\3\uffff\1\157\1\uffff"+
        "\1\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\7\uffff\1\32\1\33\2\uffff\1\5\12\uffff\1"+
        "\6\20\uffff\1\24\15\uffff\1\22\1\uffff\1\26\10\uffff\1\31\3\uffff"+
        "\1\30\1\23\1\25\2\uffff\1\27";
    static final String DFA23_specialS =
        "\1\15\5\uffff\1\6\1\5\27\uffff\1\14\1\uffff\1\1\11\uffff\1\12\1"+
        "\uffff\1\16\3\uffff\1\0\16\uffff\1\11\1\3\1\uffff\1\10\16\uffff"+
        "\1\7\1\uffff\1\2\1\13\5\uffff\1\4\1\uffff}>";
    static final String[] DFA23_transitionS = {
            "\11\32\1\33\1\3\2\32\1\3\22\32\1\33\1\32\1\4\1\2\1\32\1\1\1"+
            "\32\1\uffff\1\17\1\20\1\21\1\32\1\16\1\5\1\15\1\32\1\6\11\7"+
            "\1\22\1\32\1\14\1\32\1\uffff\1\32\1\uffff\32\32\1\12\1\uffff"+
            "\1\13\4\32\1\27\1\23\1\30\1\25\3\32\1\24\3\32\1\31\4\32\1\26"+
            "\10\32\1\10\1\uffff\1\11\uff82\32",
            "",
            "",
            "",
            "",
            "\1\34\11\35",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\1\37\13\32\1\uffff\1\32\1"+
            "\uffff\1\32\1\uffff\1\32\1\uffff\4\32\1\40\25\32\3\uffff\7\32"+
            "\1\40\25\32\3\uffff\uff82\32",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\1\37\1\32\12\41\1\uffff\1"+
            "\32\1\uffff\1\32\1\uffff\1\32\1\uffff\4\32\1\40\25\32\3\uffff"+
            "\7\32\1\40\25\32\3\uffff\uff82\32",
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
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "",
            "",
            "\1\51\26\uffff\1\51\37\uffff\1\51",
            "\1\51\1\uffff\12\52\13\uffff\1\51\37\uffff\1\51",
            "",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\3\uffff\1\32\12\53\1\uffff\1\32\1"+
            "\uffff\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff"+
            "\uff82\32",
            "\1\54\1\uffff\1\51\2\uffff\12\55",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\1\37\1\32\12\41\1\uffff\1"+
            "\32\1\uffff\1\32\1\uffff\1\32\1\uffff\4\32\1\40\25\32\3\uffff"+
            "\7\32\1\40\25\32\3\uffff\uff82\32",
            "\1\56",
            "\1\57\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "",
            "\1\51\1\uffff\12\52\13\uffff\1\51\37\uffff\1\51",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\2\32\12\53\1\uffff\1\32\1"+
            "\uffff\1\32\1\uffff\1\32\1\uffff\4\32\1\66\25\32\3\uffff\7\32"+
            "\1\66\25\32\3\uffff\uff82\32",
            "\12\55",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\2\32\12\55\1\uffff\1\32\1"+
            "\uffff\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff"+
            "\uff82\32",
            "\1\67",
            "\1\70",
            "\1\71",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77\1\uffff\1\51\2\uffff\12\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\12\100",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\2\32\12\100\1\uffff\1\32"+
            "\1\uffff\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff"+
            "\uff82\32",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "\1\111",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123\26\uffff\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
            "\1\132",
            "",
            "",
            "",
            "\1\133",
            "\11\32\2\uffff\2\32\1\uffff\22\32\1\uffff\1\32\2\uffff\1\32"+
            "\1\uffff\1\32\4\uffff\1\32\2\uffff\14\32\1\uffff\1\32\1\uffff"+
            "\1\32\1\uffff\1\32\1\uffff\32\32\3\uffff\35\32\3\uffff\uff82"+
            "\32",
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
            return "1:1: Tokens : ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | ModuleDef | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_49 = input.LA(1);

                        s = -1;
                        if ( ((LA23_49>='\u0000' && LA23_49<='\b')||(LA23_49>='\u000B' && LA23_49<='\f')||(LA23_49>='\u000E' && LA23_49<='\u001F')||LA23_49=='!'||LA23_49=='$'||LA23_49=='&'||LA23_49=='+'||(LA23_49>='.' && LA23_49<='9')||LA23_49==';'||LA23_49=='='||LA23_49=='?'||(LA23_49>='A' && LA23_49<='Z')||(LA23_49>='^' && LA23_49<='z')||(LA23_49>='~' && LA23_49<='\uFFFF')) ) {s = 26;}

                        else s = 58;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_33 = input.LA(1);

                        s = -1;
                        if ( ((LA23_33>='0' && LA23_33<='9')) ) {s = 33;}

                        else if ( (LA23_33=='.') ) {s = 31;}

                        else if ( (LA23_33=='E'||LA23_33=='e') ) {s = 32;}

                        else if ( ((LA23_33>='\u0000' && LA23_33<='\b')||(LA23_33>='\u000B' && LA23_33<='\f')||(LA23_33>='\u000E' && LA23_33<='\u001F')||LA23_33=='!'||LA23_33=='$'||LA23_33=='&'||LA23_33=='+'||LA23_33=='/'||LA23_33==';'||LA23_33=='='||LA23_33=='?'||(LA23_33>='A' && LA23_33<='D')||(LA23_33>='F' && LA23_33<='Z')||(LA23_33>='^' && LA23_33<='d')||(LA23_33>='f' && LA23_33<='z')||(LA23_33>='~' && LA23_33<='\uFFFF')) ) {s = 26;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_84 = input.LA(1);

                        s = -1;
                        if ( ((LA23_84>='\u0000' && LA23_84<='\b')||(LA23_84>='\u000B' && LA23_84<='\f')||(LA23_84>='\u000E' && LA23_84<='\u001F')||LA23_84=='!'||LA23_84=='$'||LA23_84=='&'||LA23_84=='+'||(LA23_84>='.' && LA23_84<='9')||LA23_84==';'||LA23_84=='='||LA23_84=='?'||(LA23_84>='A' && LA23_84<='Z')||(LA23_84>='^' && LA23_84<='z')||(LA23_84>='~' && LA23_84<='\uFFFF')) ) {s = 26;}

                        else s = 88;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_65 = input.LA(1);

                        s = -1;
                        if ( ((LA23_65>='\u0000' && LA23_65<='\b')||(LA23_65>='\u000B' && LA23_65<='\f')||(LA23_65>='\u000E' && LA23_65<='\u001F')||LA23_65=='!'||LA23_65=='$'||LA23_65=='&'||LA23_65=='+'||(LA23_65>='.' && LA23_65<='9')||LA23_65==';'||LA23_65=='='||LA23_65=='?'||(LA23_65>='A' && LA23_65<='Z')||(LA23_65>='^' && LA23_65<='z')||(LA23_65>='~' && LA23_65<='\uFFFF')) ) {s = 26;}

                        else s = 72;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_91 = input.LA(1);

                        s = -1;
                        if ( ((LA23_91>='\u0000' && LA23_91<='\b')||(LA23_91>='\u000B' && LA23_91<='\f')||(LA23_91>='\u000E' && LA23_91<='\u001F')||LA23_91=='!'||LA23_91=='$'||LA23_91=='&'||LA23_91=='+'||(LA23_91>='.' && LA23_91<='9')||LA23_91==';'||LA23_91=='='||LA23_91=='?'||(LA23_91>='A' && LA23_91<='Z')||(LA23_91>='^' && LA23_91<='z')||(LA23_91>='~' && LA23_91<='\uFFFF')) ) {s = 26;}

                        else s = 92;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_7 = input.LA(1);

                        s = -1;
                        if ( ((LA23_7>='0' && LA23_7<='9')) ) {s = 33;}

                        else if ( (LA23_7=='.') ) {s = 31;}

                        else if ( (LA23_7=='E'||LA23_7=='e') ) {s = 32;}

                        else if ( ((LA23_7>='\u0000' && LA23_7<='\b')||(LA23_7>='\u000B' && LA23_7<='\f')||(LA23_7>='\u000E' && LA23_7<='\u001F')||LA23_7=='!'||LA23_7=='$'||LA23_7=='&'||LA23_7=='+'||LA23_7=='/'||LA23_7==';'||LA23_7=='='||LA23_7=='?'||(LA23_7>='A' && LA23_7<='D')||(LA23_7>='F' && LA23_7<='Z')||(LA23_7>='^' && LA23_7<='d')||(LA23_7>='f' && LA23_7<='z')||(LA23_7>='~' && LA23_7<='\uFFFF')) ) {s = 26;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_6 = input.LA(1);

                        s = -1;
                        if ( (LA23_6=='.') ) {s = 31;}

                        else if ( (LA23_6=='E'||LA23_6=='e') ) {s = 32;}

                        else if ( ((LA23_6>='\u0000' && LA23_6<='\b')||(LA23_6>='\u000B' && LA23_6<='\f')||(LA23_6>='\u000E' && LA23_6<='\u001F')||LA23_6=='!'||LA23_6=='$'||LA23_6=='&'||LA23_6=='+'||(LA23_6>='/' && LA23_6<='9')||LA23_6==';'||LA23_6=='='||LA23_6=='?'||(LA23_6>='A' && LA23_6<='D')||(LA23_6>='F' && LA23_6<='Z')||(LA23_6>='^' && LA23_6<='d')||(LA23_6>='f' && LA23_6<='z')||(LA23_6>='~' && LA23_6<='\uFFFF')) ) {s = 26;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_82 = input.LA(1);

                        s = -1;
                        if ( ((LA23_82>='\u0000' && LA23_82<='\b')||(LA23_82>='\u000B' && LA23_82<='\f')||(LA23_82>='\u000E' && LA23_82<='\u001F')||LA23_82=='!'||LA23_82=='$'||LA23_82=='&'||LA23_82=='+'||(LA23_82>='.' && LA23_82<='9')||LA23_82==';'||LA23_82=='='||LA23_82=='?'||(LA23_82>='A' && LA23_82<='Z')||(LA23_82>='^' && LA23_82<='z')||(LA23_82>='~' && LA23_82<='\uFFFF')) ) {s = 26;}

                        else s = 87;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_67 = input.LA(1);

                        s = -1;
                        if ( ((LA23_67>='\u0000' && LA23_67<='\b')||(LA23_67>='\u000B' && LA23_67<='\f')||(LA23_67>='\u000E' && LA23_67<='\u001F')||LA23_67=='!'||LA23_67=='$'||LA23_67=='&'||LA23_67=='+'||(LA23_67>='.' && LA23_67<='9')||LA23_67==';'||LA23_67=='='||LA23_67=='?'||(LA23_67>='A' && LA23_67<='Z')||(LA23_67>='^' && LA23_67<='z')||(LA23_67>='~' && LA23_67<='\uFFFF')) ) {s = 26;}

                        else s = 74;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_64 = input.LA(1);

                        s = -1;
                        if ( ((LA23_64>='0' && LA23_64<='9')) ) {s = 64;}

                        else if ( ((LA23_64>='\u0000' && LA23_64<='\b')||(LA23_64>='\u000B' && LA23_64<='\f')||(LA23_64>='\u000E' && LA23_64<='\u001F')||LA23_64=='!'||LA23_64=='$'||LA23_64=='&'||LA23_64=='+'||(LA23_64>='.' && LA23_64<='/')||LA23_64==';'||LA23_64=='='||LA23_64=='?'||(LA23_64>='A' && LA23_64<='Z')||(LA23_64>='^' && LA23_64<='z')||(LA23_64>='~' && LA23_64<='\uFFFF')) ) {s = 26;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_43 = input.LA(1);

                        s = -1;
                        if ( (LA23_43=='E'||LA23_43=='e') ) {s = 54;}

                        else if ( ((LA23_43>='0' && LA23_43<='9')) ) {s = 43;}

                        else if ( ((LA23_43>='\u0000' && LA23_43<='\b')||(LA23_43>='\u000B' && LA23_43<='\f')||(LA23_43>='\u000E' && LA23_43<='\u001F')||LA23_43=='!'||LA23_43=='$'||LA23_43=='&'||LA23_43=='+'||(LA23_43>='.' && LA23_43<='/')||LA23_43==';'||LA23_43=='='||LA23_43=='?'||(LA23_43>='A' && LA23_43<='D')||(LA23_43>='F' && LA23_43<='Z')||(LA23_43>='^' && LA23_43<='d')||(LA23_43>='f' && LA23_43<='z')||(LA23_43>='~' && LA23_43<='\uFFFF')) ) {s = 26;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_85 = input.LA(1);

                        s = -1;
                        if ( ((LA23_85>='\u0000' && LA23_85<='\b')||(LA23_85>='\u000B' && LA23_85<='\f')||(LA23_85>='\u000E' && LA23_85<='\u001F')||LA23_85=='!'||LA23_85=='$'||LA23_85=='&'||LA23_85=='+'||(LA23_85>='.' && LA23_85<='9')||LA23_85==';'||LA23_85=='='||LA23_85=='?'||(LA23_85>='A' && LA23_85<='Z')||(LA23_85>='^' && LA23_85<='z')||(LA23_85>='~' && LA23_85<='\uFFFF')) ) {s = 26;}

                        else s = 89;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_31 = input.LA(1);

                        s = -1;
                        if ( ((LA23_31>='0' && LA23_31<='9')) ) {s = 43;}

                        else if ( ((LA23_31>='\u0000' && LA23_31<='\b')||(LA23_31>='\u000B' && LA23_31<='\f')||(LA23_31>='\u000E' && LA23_31<='\u001F')||LA23_31=='!'||LA23_31=='$'||LA23_31=='&'||LA23_31=='+'||LA23_31=='/'||LA23_31==';'||LA23_31=='='||LA23_31=='?'||(LA23_31>='A' && LA23_31<='Z')||(LA23_31>='^' && LA23_31<='z')||(LA23_31>='~' && LA23_31<='\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
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

                        else if ( (LA23_0=='.') ) {s = 13;}

                        else if ( (LA23_0==',') ) {s = 14;}

                        else if ( (LA23_0=='(') ) {s = 15;}

                        else if ( (LA23_0==')') ) {s = 16;}

                        else if ( (LA23_0=='*') ) {s = 17;}

                        else if ( (LA23_0==':') ) {s = 18;}

                        else if ( (LA23_0=='c') ) {s = 19;}

                        else if ( (LA23_0=='i') ) {s = 20;}

                        else if ( (LA23_0=='e') ) {s = 21;}

                        else if ( (LA23_0=='r') ) {s = 22;}

                        else if ( (LA23_0=='b') ) {s = 23;}

                        else if ( (LA23_0=='d') ) {s = 24;}

                        else if ( (LA23_0=='m') ) {s = 25;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||LA23_0=='&'||LA23_0=='+'||LA23_0=='/'||LA23_0==';'||LA23_0=='='||LA23_0=='?'||(LA23_0>='A' && LA23_0<='Z')||(LA23_0>='^' && LA23_0<='a')||(LA23_0>='f' && LA23_0<='h')||(LA23_0>='j' && LA23_0<='l')||(LA23_0>='n' && LA23_0<='q')||(LA23_0>='s' && LA23_0<='z')||(LA23_0>='~' && LA23_0<='\uFFFF')) ) {s = 26;}

                        else if ( (LA23_0=='\t'||LA23_0==' ') ) {s = 27;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_45 = input.LA(1);

                        s = -1;
                        if ( ((LA23_45>='0' && LA23_45<='9')) ) {s = 45;}

                        else if ( ((LA23_45>='\u0000' && LA23_45<='\b')||(LA23_45>='\u000B' && LA23_45<='\f')||(LA23_45>='\u000E' && LA23_45<='\u001F')||LA23_45=='!'||LA23_45=='$'||LA23_45=='&'||LA23_45=='+'||(LA23_45>='.' && LA23_45<='/')||LA23_45==';'||LA23_45=='='||LA23_45=='?'||(LA23_45>='A' && LA23_45<='Z')||(LA23_45>='^' && LA23_45<='z')||(LA23_45>='~' && LA23_45<='\uFFFF')) ) {s = 26;}

                        else s = 41;

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
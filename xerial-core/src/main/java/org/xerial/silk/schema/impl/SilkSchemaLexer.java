// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-08 15:38:42

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
    public static final int TargetClass=15;
    public static final int Includes=49;
    public static final int NonWhiteSpaceChar=45;
    public static final int RBrace=35;
    public static final int LBracket=36;
    public static final int Class=48;
    public static final int Digit=22;
    public static final int AllIncluded=14;
    public static final int SymbolChars=46;
    public static final int Frac=31;
    public static final int HexDigit=24;
    public static final int Symbol=47;
    public static final int T__65=65;
    public static final int OrderBy=56;
    public static final int Default=54;
    public static final int Argument=17;
    public static final int Index=52;
    public static final int Module=5;
    public static final int Letter=23;
    public static final int Attribute=10;
    public static final int Comma=40;
    public static final int Schema=4;
    public static final int Dot=39;
    public static final int End=50;
    public static final int EscapeSequence=26;
    public static final int DefaultValue=13;
    public static final int Integer=30;
    public static final int Relation=51;
    public static final int Mixin=9;
    public static final int WhiteSpace=62;
    public static final int ClassDef=6;
    public static final int LineComment=20;
    public static final int ModuleName=59;
    public static final int Projection=55;
    public static final int BelongsTo=53;
    public static final int SafeFirstLetter=57;
    public static final int Star=43;
    public static final int Preamble=19;
    public static final int Exp=32;
    public static final int QNameChar=63;
    public static final int RParen=42;
    public static final int UnicodeChar=25;
    public static final int StringChar=27;
    public static final int LineBreak=21;
    public static final int Name=7;
    public static final int Function=16;
    public static final int LParen=41;
    public static final int ModuleDef=61;
    public static final int String=29;
    public static final int SafeLetter=58;
    public static final int LineBreakChar=18;
    public static final int IsArray=11;
    public static final int QName=64;
    public static final int EOF=-1;
    public static final int StringChar_s=28;
    public static final int UnsafeUnicodeChar=44;
    public static final int LBrace=34;
    public static final int Double=33;
    public static final int Lt=38;
    public static final int RBracket=37;
    public static final int Parent=8;
    public static final int TypeName=12;
    public static final int WhiteSpaces=60;

      


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

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:38:7: ( 'on' )
            // SilkSchema.g:38:9: 'on'
            {
            match("on"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "Preamble"
    public final void mPreamble() throws RecognitionException {
        try {
            int _type = Preamble;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:113:9: ({...}? => '%' (~ ( LineBreakChar ) )* )
            // SilkSchema.g:113:11: {...}? => '%' (~ ( LineBreakChar ) )*
            {
            if ( !(( getCharPositionInLine() == 0 )) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "Preamble", " getCharPositionInLine() == 0 ");
            }
            match('%'); if (state.failed) return ;
            // SilkSchema.g:113:52: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkSchema.g:113:52: ~ ( LineBreakChar )
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
            // SilkSchema.g:116:23: ( '\\n' | '\\r' )
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
            // SilkSchema.g:117:12: ( '#' (~ ( LineBreakChar ) )* )
            // SilkSchema.g:117:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); if (state.failed) return ;
            // SilkSchema.g:117:18: (~ ( LineBreakChar ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:117:18: ~ ( LineBreakChar )
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
            // SilkSchema.g:120:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // SilkSchema.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // SilkSchema.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // SilkSchema.g:120:13: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:120:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SilkSchema.g:120:32: '\\n'
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
            // SilkSchema.g:123:15: ( '0' .. '9' )
            // SilkSchema.g:123:17: '0' .. '9'
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
            // SilkSchema.g:124:16: ( 'A' .. 'F' | 'a' .. 'f' )
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
            // SilkSchema.g:125:18: ( Digit | Letter )
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
            // SilkSchema.g:126:21: (~ ( '\"' | '\\\\' ) )
            // SilkSchema.g:126:23: ~ ( '\"' | '\\\\' )
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
            // SilkSchema.g:128:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // SilkSchema.g:128:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); if (state.failed) return ;
            // SilkSchema.g:128:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // SilkSchema.g:128:11: '\\\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:128:18: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SilkSchema.g:128:25: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SilkSchema.g:128:31: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SilkSchema.g:128:37: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SilkSchema.g:128:43: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SilkSchema.g:128:49: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // SilkSchema.g:128:55: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // SilkSchema.g:128:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // SilkSchema.g:131:21: ( UnicodeChar | EscapeSequence )
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
                    // SilkSchema.g:131:24: UnicodeChar
                    {
                    mUnicodeChar(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:131:38: EscapeSequence
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
            // SilkSchema.g:132:22: ( ( StringChar )* )
            // SilkSchema.g:132:24: ( StringChar )*
            {
            // SilkSchema.g:132:24: ( StringChar )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SilkSchema.g:132:24: StringChar
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

            // SilkSchema.g:134:7: ( '\"' s= StringChar_s '\"' )
            // SilkSchema.g:134:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); if (state.failed) return ;
            int sStart273 = getCharIndex();
            mStringChar_s(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart273, getCharIndex()-1);
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
            // SilkSchema.g:137:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // SilkSchema.g:137:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // SilkSchema.g:137:10: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // SilkSchema.g:137:10: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;

            }

            // SilkSchema.g:137:15: ( '0' | '1' .. '9' ( Digit )* )
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
                    // SilkSchema.g:137:16: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SilkSchema.g:137:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); if (state.failed) return ;
                    // SilkSchema.g:137:31: ( Digit )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // SilkSchema.g:137:31: Digit
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
            // SilkSchema.g:138:14: ( '.' ( Digit )+ )
            // SilkSchema.g:138:16: '.' ( Digit )+
            {
            match('.'); if (state.failed) return ;
            // SilkSchema.g:138:20: ( Digit )+
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
            	    // SilkSchema.g:138:20: Digit
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
            // SilkSchema.g:139:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // SilkSchema.g:139:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
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

            // SilkSchema.g:139:27: ( '+' | '-' )?
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

            // SilkSchema.g:139:40: ( Digit )+
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
            	    // SilkSchema.g:139:40: Digit
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
            // SilkSchema.g:140:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // SilkSchema.g:140:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); if (state.failed) return ;
            // SilkSchema.g:140:17: ( Frac ( Exp )? | Exp )
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
                    // SilkSchema.g:140:18: Frac ( Exp )?
                    {
                    mFrac(); if (state.failed) return ;
                    // SilkSchema.g:140:23: ( Exp )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // SilkSchema.g:140:23: Exp
                            {
                            mExp(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // SilkSchema.g:140:30: Exp
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
            // SilkSchema.g:142:7: ( '{' )
            // SilkSchema.g:142:9: '{'
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
            // SilkSchema.g:143:7: ( '}' )
            // SilkSchema.g:143:9: '}'
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
            // SilkSchema.g:144:9: ( '[' )
            // SilkSchema.g:144:11: '['
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
            // SilkSchema.g:145:9: ( ']' )
            // SilkSchema.g:145:11: ']'
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
            // SilkSchema.g:147:3: ( '<' )
            // SilkSchema.g:147:5: '<'
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
            // SilkSchema.g:148:4: ( '.' )
            // SilkSchema.g:148:6: '.'
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
            // SilkSchema.g:149:6: ( ',' )
            // SilkSchema.g:149:8: ','
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
            // SilkSchema.g:151:7: ( '(' )
            // SilkSchema.g:151:9: '('
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
            // SilkSchema.g:152:7: ( ')' )
            // SilkSchema.g:152:9: ')'
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
            // SilkSchema.g:154:5: ( '*' )
            // SilkSchema.g:154:7: '*'
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
            // SilkSchema.g:157:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
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
            // SilkSchema.g:160:18: (~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' ) )
            // SilkSchema.g:160:20: ~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' )
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
            // SilkSchema.g:162:21: ( ( NonWhiteSpaceChar )+ )
            // SilkSchema.g:162:23: ( NonWhiteSpaceChar )+
            {
            // SilkSchema.g:162:23: ( NonWhiteSpaceChar )+
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
            	    // SilkSchema.g:162:23: NonWhiteSpaceChar
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

            // SilkSchema.g:163:7: ( ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars )
            // SilkSchema.g:163:9: ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars
            {
            match(':'); if (state.failed) return ;
            int sStart588 = getCharIndex();
            mSymbolChars(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart588, getCharIndex()-1);
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
            // SilkSchema.g:165:6: ( 'class' )
            // SilkSchema.g:165:8: 'class'
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
            // SilkSchema.g:166:9: ( 'includes' )
            // SilkSchema.g:166:11: 'includes'
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
            // SilkSchema.g:167:4: ( 'end' )
            // SilkSchema.g:167:6: 'end'
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
            // SilkSchema.g:168:9: ( 'relation' )
            // SilkSchema.g:168:11: 'relation'
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
            // SilkSchema.g:169:6: ( 'index' )
            // SilkSchema.g:169:8: 'index'
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
            // SilkSchema.g:170:10: ( 'belongs_to' )
            // SilkSchema.g:170:12: 'belongs_to'
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
            // SilkSchema.g:171:8: ( 'default' )
            // SilkSchema.g:171:10: 'default'
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

    // $ANTLR start "Projection"
    public final void mProjection() throws RecognitionException {
        try {
            int _type = Projection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:172:11: ( 'projection' )
            // SilkSchema.g:172:13: 'projection'
            {
            match("projection"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Projection"

    // $ANTLR start "OrderBy"
    public final void mOrderBy() throws RecognitionException {
        try {
            int _type = OrderBy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SilkSchema.g:173:8: ( 'order_by' )
            // SilkSchema.g:173:10: 'order_by'
            {
            match("order_by"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OrderBy"

    // $ANTLR start "SafeFirstLetter"
    public final void mSafeFirstLetter() throws RecognitionException {
        try {
            // SilkSchema.g:175:25: ( 'A' .. 'Z' | 'a' .. 'z' )
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
            // SilkSchema.g:176:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
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
            // SilkSchema.g:178:20: ( SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )* )
            // SilkSchema.g:178:22: SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )*
            {
            mSafeFirstLetter(); if (state.failed) return ;
            // SilkSchema.g:178:38: ( SafeLetter )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='-'||(LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // SilkSchema.g:178:38: SafeLetter
            	    {
            	    mSafeLetter(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // SilkSchema.g:178:50: ( '.' SafeFirstLetter ( SafeLetter )* )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // SilkSchema.g:178:51: '.' SafeFirstLetter ( SafeLetter )*
            	    {
            	    match('.'); if (state.failed) return ;
            	    mSafeFirstLetter(); if (state.failed) return ;
            	    // SilkSchema.g:178:71: ( SafeLetter )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='-'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // SilkSchema.g:178:71: SafeLetter
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

            // SilkSchema.g:179:10: ( 'module' WhiteSpaces s= ModuleName )
            // SilkSchema.g:179:12: 'module' WhiteSpaces s= ModuleName
            {
            match("module"); if (state.failed) return ;

            mWhiteSpaces(); if (state.failed) return ;
            int sStart738 = getCharIndex();
            mModuleName(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart738, getCharIndex()-1);
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
            // SilkSchema.g:181:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // SilkSchema.g:181:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
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
            // SilkSchema.g:182:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // SilkSchema.g:182:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // SilkSchema.g:182:8: ( QNameChar )+
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
            	    // SilkSchema.g:182:8: QNameChar
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

            // SilkSchema.g:182:19: ( Dot ( QNameChar )+ )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='.') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // SilkSchema.g:182:20: Dot ( QNameChar )+
            	    {
            	    mDot(); if (state.failed) return ;
            	    // SilkSchema.g:182:24: ( QNameChar )+
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
            	    	    // SilkSchema.g:182:24: QNameChar
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
            // SilkSchema.g:185:11: ( ' ' | '\\t' )
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
            // SilkSchema.g:187:12: ( ( WhiteSpace )+ )
            // SilkSchema.g:187:14: ( WhiteSpace )+
            {
            // SilkSchema.g:187:14: ( WhiteSpace )+
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
            	    // SilkSchema.g:187:14: WhiteSpace
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
        // SilkSchema.g:1:8: ( T__65 | Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | Projection | OrderBy | ModuleDef | QName | WhiteSpaces )
        int alt23=30;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // SilkSchema.g:1:10: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 2 :
                // SilkSchema.g:1:16: Preamble
                {
                mPreamble(); if (state.failed) return ;

                }
                break;
            case 3 :
                // SilkSchema.g:1:25: LineComment
                {
                mLineComment(); if (state.failed) return ;

                }
                break;
            case 4 :
                // SilkSchema.g:1:37: LineBreak
                {
                mLineBreak(); if (state.failed) return ;

                }
                break;
            case 5 :
                // SilkSchema.g:1:47: String
                {
                mString(); if (state.failed) return ;

                }
                break;
            case 6 :
                // SilkSchema.g:1:54: Integer
                {
                mInteger(); if (state.failed) return ;

                }
                break;
            case 7 :
                // SilkSchema.g:1:62: Double
                {
                mDouble(); if (state.failed) return ;

                }
                break;
            case 8 :
                // SilkSchema.g:1:69: LBrace
                {
                mLBrace(); if (state.failed) return ;

                }
                break;
            case 9 :
                // SilkSchema.g:1:76: RBrace
                {
                mRBrace(); if (state.failed) return ;

                }
                break;
            case 10 :
                // SilkSchema.g:1:83: LBracket
                {
                mLBracket(); if (state.failed) return ;

                }
                break;
            case 11 :
                // SilkSchema.g:1:92: RBracket
                {
                mRBracket(); if (state.failed) return ;

                }
                break;
            case 12 :
                // SilkSchema.g:1:101: Lt
                {
                mLt(); if (state.failed) return ;

                }
                break;
            case 13 :
                // SilkSchema.g:1:104: Dot
                {
                mDot(); if (state.failed) return ;

                }
                break;
            case 14 :
                // SilkSchema.g:1:108: Comma
                {
                mComma(); if (state.failed) return ;

                }
                break;
            case 15 :
                // SilkSchema.g:1:114: LParen
                {
                mLParen(); if (state.failed) return ;

                }
                break;
            case 16 :
                // SilkSchema.g:1:121: RParen
                {
                mRParen(); if (state.failed) return ;

                }
                break;
            case 17 :
                // SilkSchema.g:1:128: Star
                {
                mStar(); if (state.failed) return ;

                }
                break;
            case 18 :
                // SilkSchema.g:1:133: Symbol
                {
                mSymbol(); if (state.failed) return ;

                }
                break;
            case 19 :
                // SilkSchema.g:1:140: Class
                {
                mClass(); if (state.failed) return ;

                }
                break;
            case 20 :
                // SilkSchema.g:1:146: Includes
                {
                mIncludes(); if (state.failed) return ;

                }
                break;
            case 21 :
                // SilkSchema.g:1:155: End
                {
                mEnd(); if (state.failed) return ;

                }
                break;
            case 22 :
                // SilkSchema.g:1:159: Relation
                {
                mRelation(); if (state.failed) return ;

                }
                break;
            case 23 :
                // SilkSchema.g:1:168: Index
                {
                mIndex(); if (state.failed) return ;

                }
                break;
            case 24 :
                // SilkSchema.g:1:174: BelongsTo
                {
                mBelongsTo(); if (state.failed) return ;

                }
                break;
            case 25 :
                // SilkSchema.g:1:184: Default
                {
                mDefault(); if (state.failed) return ;

                }
                break;
            case 26 :
                // SilkSchema.g:1:192: Projection
                {
                mProjection(); if (state.failed) return ;

                }
                break;
            case 27 :
                // SilkSchema.g:1:203: OrderBy
                {
                mOrderBy(); if (state.failed) return ;

                }
                break;
            case 28 :
                // SilkSchema.g:1:211: ModuleDef
                {
                mModuleDef(); if (state.failed) return ;

                }
                break;
            case 29 :
                // SilkSchema.g:1:221: QName
                {
                mQName(); if (state.failed) return ;

                }
                break;
            case 30 :
                // SilkSchema.g:1:227: WhiteSpaces
                {
                mWhiteSpaces(); if (state.failed) return ;

                }
                break;

        }

    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\1\uffff\1\34\5\uffff\2\42\13\uffff\10\34\2\uffff\1\56\1\34\2\42"+
        "\2\uffff\1\34\1\42\10\34\1\uffff\1\34\1\uffff\1\42\1\60\1\34\1\60"+
        "\3\34\1\103\12\34\1\uffff\7\34\1\60\1\125\1\34\1\127\6\34\1\uffff"+
        "\1\34\1\uffff\11\34\1\150\1\34\1\uffff\1\152\1\153\1\154\1\34\1"+
        "\uffff\1\34\3\uffff\2\34\1\161\1\162\2\uffff";
    static final String DFA23_eofS =
        "\163\uffff";
    static final String DFA23_minS =
        "\1\0\1\156\4\uffff\1\60\2\0\13\uffff\1\154\2\156\3\145\1\162\1"+
        "\157\2\uffff\1\0\1\144\2\56\1\uffff\1\0\1\53\1\0\1\141\1\143\1\144"+
        "\2\154\1\146\1\157\1\144\1\uffff\1\145\1\uffff\1\56\1\0\1\60\1\0"+
        "\1\163\1\154\1\145\1\0\1\141\1\157\1\141\1\152\1\165\1\162\1\53"+
        "\1\163\1\165\1\170\1\uffff\1\164\1\156\1\165\1\145\1\154\1\137\1"+
        "\60\2\0\1\144\1\0\1\151\1\147\1\154\1\143\1\145\1\142\1\uffff\1"+
        "\145\1\uffff\1\157\1\163\2\164\1\11\1\171\1\163\1\156\1\137\1\0"+
        "\1\151\1\uffff\3\0\1\164\1\uffff\1\157\3\uffff\1\157\1\156\2\0\2"+
        "\uffff";
    static final String DFA23_maxS =
        "\1\uffff\1\162\4\uffff\1\71\2\uffff\13\uffff\1\154\2\156\3\145"+
        "\1\162\1\157\2\uffff\1\uffff\1\144\2\145\1\uffff\1\uffff\1\71\1"+
        "\uffff\1\141\2\144\2\154\1\146\1\157\1\144\1\uffff\1\145\1\uffff"+
        "\1\145\1\uffff\1\71\1\uffff\1\163\1\154\1\145\1\uffff\1\141\1\157"+
        "\1\141\1\152\1\165\1\162\1\71\1\163\1\165\1\170\1\uffff\1\164\1"+
        "\156\1\165\1\145\1\154\1\137\1\71\2\uffff\1\144\1\uffff\1\151\1"+
        "\147\1\154\1\143\1\145\1\142\1\uffff\1\145\1\uffff\1\157\1\163\2"+
        "\164\1\40\1\171\1\163\1\156\1\137\1\uffff\1\151\1\uffff\3\uffff"+
        "\1\164\1\uffff\1\157\3\uffff\1\157\1\156\2\uffff\2\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\3\uffff\1\10\1\11\1\12\1\13\1\14\1\15"+
        "\1\16\1\17\1\20\1\21\1\22\10\uffff\1\35\1\36\4\uffff\1\6\13\uffff"+
        "\1\1\1\uffff\1\7\22\uffff\1\25\21\uffff\1\23\1\uffff\1\27\13\uffff"+
        "\1\34\4\uffff\1\31\1\uffff\1\33\1\24\1\26\4\uffff\1\30\1\32";
    static final String DFA23_specialS =
        "\1\20\6\uffff\1\12\1\2\25\uffff\1\3\4\uffff\1\13\1\uffff\1\14\14"+
        "\uffff\1\11\1\uffff\1\1\3\uffff\1\21\22\uffff\1\16\1\17\1\uffff"+
        "\1\10\22\uffff\1\6\2\uffff\1\4\1\5\1\0\10\uffff\1\7\1\15\2\uffff}>";
    static final String[] DFA23_transitionS = {
            "\11\34\1\35\1\4\2\34\1\4\22\34\1\35\1\34\1\5\1\3\1\34\1\2\1"+
            "\34\1\uffff\1\20\1\21\1\22\1\34\1\17\1\6\1\16\1\34\1\7\11\10"+
            "\1\23\1\34\1\15\1\34\1\uffff\1\34\1\uffff\32\34\1\13\1\uffff"+
            "\1\14\4\34\1\30\1\24\1\31\1\26\3\34\1\25\3\34\1\33\1\34\1\1"+
            "\1\32\1\34\1\27\10\34\1\11\1\uffff\1\12\uff82\34",
            "\1\36\3\uffff\1\37",
            "",
            "",
            "",
            "",
            "\1\40\11\41",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\43\13\34\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\44\25\34\3\uffff\7\34"+
            "\1\44\25\34\3\uffff\uff82\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\43\1\34\12\45\1\uffff\1"+
            "\34\1\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\44\25\34\3\uffff"+
            "\7\34\1\44\25\34\3\uffff\uff82\34",
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
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\57",
            "\1\60\26\uffff\1\60\37\uffff\1\60",
            "\1\60\1\uffff\12\61\13\uffff\1\60\37\uffff\1\60",
            "",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\3\uffff\1\34\12\62\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\1\63\1\uffff\1\60\2\uffff\12\64",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\43\1\34\12\45\1\uffff\1"+
            "\34\1\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\44\25\34\3\uffff"+
            "\7\34\1\44\25\34\3\uffff\uff82\34",
            "\1\65",
            "\1\66\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "\1\76",
            "",
            "\1\60\1\uffff\12\61\13\uffff\1\60\37\uffff\1\60",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\62\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\77\25\34\3\uffff\7\34"+
            "\1\77\25\34\3\uffff\uff82\34",
            "\12\64",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\64\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\1\100",
            "\1\101",
            "\1\102",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112\1\uffff\1\60\2\uffff\12\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\113",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\113\1\uffff\1\34"+
            "\1\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\126",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "\1\136",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143\26\uffff\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\151",
            "",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\155",
            "",
            "\1\156",
            "",
            "",
            "",
            "\1\157",
            "\1\160",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
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
            return "1:1: Tokens : ( T__65 | Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | Projection | OrderBy | ModuleDef | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_102 = input.LA(1);

                        s = -1;
                        if ( ((LA23_102>='\u0000' && LA23_102<='\b')||(LA23_102>='\u000B' && LA23_102<='\f')||(LA23_102>='\u000E' && LA23_102<='\u001F')||LA23_102=='!'||LA23_102=='$'||LA23_102=='&'||LA23_102=='+'||(LA23_102>='.' && LA23_102<='9')||LA23_102==';'||LA23_102=='='||LA23_102=='?'||(LA23_102>='A' && LA23_102<='Z')||(LA23_102>='^' && LA23_102<='z')||(LA23_102>='~' && LA23_102<='\uFFFF')) ) {s = 28;}

                        else s = 108;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_52 = input.LA(1);

                        s = -1;
                        if ( ((LA23_52>='0' && LA23_52<='9')) ) {s = 52;}

                        else if ( ((LA23_52>='\u0000' && LA23_52<='\b')||(LA23_52>='\u000B' && LA23_52<='\f')||(LA23_52>='\u000E' && LA23_52<='\u001F')||LA23_52=='!'||LA23_52=='$'||LA23_52=='&'||LA23_52=='+'||(LA23_52>='.' && LA23_52<='/')||LA23_52==';'||LA23_52=='='||LA23_52=='?'||(LA23_52>='A' && LA23_52<='Z')||(LA23_52>='^' && LA23_52<='z')||(LA23_52>='~' && LA23_52<='\uFFFF')) ) {s = 28;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_8 = input.LA(1);

                        s = -1;
                        if ( ((LA23_8>='0' && LA23_8<='9')) ) {s = 37;}

                        else if ( (LA23_8=='.') ) {s = 35;}

                        else if ( (LA23_8=='E'||LA23_8=='e') ) {s = 36;}

                        else if ( ((LA23_8>='\u0000' && LA23_8<='\b')||(LA23_8>='\u000B' && LA23_8<='\f')||(LA23_8>='\u000E' && LA23_8<='\u001F')||LA23_8=='!'||LA23_8=='$'||LA23_8=='&'||LA23_8=='+'||LA23_8=='/'||LA23_8==';'||LA23_8=='='||LA23_8=='?'||(LA23_8>='A' && LA23_8<='D')||(LA23_8>='F' && LA23_8<='Z')||(LA23_8>='^' && LA23_8<='d')||(LA23_8>='f' && LA23_8<='z')||(LA23_8>='~' && LA23_8<='\uFFFF')) ) {s = 28;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_30 = input.LA(1);

                        s = -1;
                        if ( ((LA23_30>='\u0000' && LA23_30<='\b')||(LA23_30>='\u000B' && LA23_30<='\f')||(LA23_30>='\u000E' && LA23_30<='\u001F')||LA23_30=='!'||LA23_30=='$'||LA23_30=='&'||LA23_30=='+'||(LA23_30>='.' && LA23_30<='9')||LA23_30==';'||LA23_30=='='||LA23_30=='?'||(LA23_30>='A' && LA23_30<='Z')||(LA23_30>='^' && LA23_30<='z')||(LA23_30>='~' && LA23_30<='\uFFFF')) ) {s = 28;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_100 = input.LA(1);

                        s = -1;
                        if ( ((LA23_100>='\u0000' && LA23_100<='\b')||(LA23_100>='\u000B' && LA23_100<='\f')||(LA23_100>='\u000E' && LA23_100<='\u001F')||LA23_100=='!'||LA23_100=='$'||LA23_100=='&'||LA23_100=='+'||(LA23_100>='.' && LA23_100<='9')||LA23_100==';'||LA23_100=='='||LA23_100=='?'||(LA23_100>='A' && LA23_100<='Z')||(LA23_100>='^' && LA23_100<='z')||(LA23_100>='~' && LA23_100<='\uFFFF')) ) {s = 28;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_101 = input.LA(1);

                        s = -1;
                        if ( ((LA23_101>='\u0000' && LA23_101<='\b')||(LA23_101>='\u000B' && LA23_101<='\f')||(LA23_101>='\u000E' && LA23_101<='\u001F')||LA23_101=='!'||LA23_101=='$'||LA23_101=='&'||LA23_101=='+'||(LA23_101>='.' && LA23_101<='9')||LA23_101==';'||LA23_101=='='||LA23_101=='?'||(LA23_101>='A' && LA23_101<='Z')||(LA23_101>='^' && LA23_101<='z')||(LA23_101>='~' && LA23_101<='\uFFFF')) ) {s = 28;}

                        else s = 107;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_97 = input.LA(1);

                        s = -1;
                        if ( ((LA23_97>='\u0000' && LA23_97<='\b')||(LA23_97>='\u000B' && LA23_97<='\f')||(LA23_97>='\u000E' && LA23_97<='\u001F')||LA23_97=='!'||LA23_97=='$'||LA23_97=='&'||LA23_97=='+'||(LA23_97>='.' && LA23_97<='9')||LA23_97==';'||LA23_97=='='||LA23_97=='?'||(LA23_97>='A' && LA23_97<='Z')||(LA23_97>='^' && LA23_97<='z')||(LA23_97>='~' && LA23_97<='\uFFFF')) ) {s = 28;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_111 = input.LA(1);

                        s = -1;
                        if ( ((LA23_111>='\u0000' && LA23_111<='\b')||(LA23_111>='\u000B' && LA23_111<='\f')||(LA23_111>='\u000E' && LA23_111<='\u001F')||LA23_111=='!'||LA23_111=='$'||LA23_111=='&'||LA23_111=='+'||(LA23_111>='.' && LA23_111<='9')||LA23_111==';'||LA23_111=='='||LA23_111=='?'||(LA23_111>='A' && LA23_111<='Z')||(LA23_111>='^' && LA23_111<='z')||(LA23_111>='~' && LA23_111<='\uFFFF')) ) {s = 28;}

                        else s = 113;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_78 = input.LA(1);

                        s = -1;
                        if ( ((LA23_78>='\u0000' && LA23_78<='\b')||(LA23_78>='\u000B' && LA23_78<='\f')||(LA23_78>='\u000E' && LA23_78<='\u001F')||LA23_78=='!'||LA23_78=='$'||LA23_78=='&'||LA23_78=='+'||(LA23_78>='.' && LA23_78<='9')||LA23_78==';'||LA23_78=='='||LA23_78=='?'||(LA23_78>='A' && LA23_78<='Z')||(LA23_78>='^' && LA23_78<='z')||(LA23_78>='~' && LA23_78<='\uFFFF')) ) {s = 28;}

                        else s = 87;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_50 = input.LA(1);

                        s = -1;
                        if ( ((LA23_50>='\u0000' && LA23_50<='\b')||(LA23_50>='\u000B' && LA23_50<='\f')||(LA23_50>='\u000E' && LA23_50<='\u001F')||LA23_50=='!'||LA23_50=='$'||LA23_50=='&'||LA23_50=='+'||(LA23_50>='.' && LA23_50<='/')||LA23_50==';'||LA23_50=='='||LA23_50=='?'||(LA23_50>='A' && LA23_50<='D')||(LA23_50>='F' && LA23_50<='Z')||(LA23_50>='^' && LA23_50<='d')||(LA23_50>='f' && LA23_50<='z')||(LA23_50>='~' && LA23_50<='\uFFFF')) ) {s = 28;}

                        else if ( (LA23_50=='E'||LA23_50=='e') ) {s = 63;}

                        else if ( ((LA23_50>='0' && LA23_50<='9')) ) {s = 50;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_7 = input.LA(1);

                        s = -1;
                        if ( (LA23_7=='.') ) {s = 35;}

                        else if ( (LA23_7=='E'||LA23_7=='e') ) {s = 36;}

                        else if ( ((LA23_7>='\u0000' && LA23_7<='\b')||(LA23_7>='\u000B' && LA23_7<='\f')||(LA23_7>='\u000E' && LA23_7<='\u001F')||LA23_7=='!'||LA23_7=='$'||LA23_7=='&'||LA23_7=='+'||(LA23_7>='/' && LA23_7<='9')||LA23_7==';'||LA23_7=='='||LA23_7=='?'||(LA23_7>='A' && LA23_7<='D')||(LA23_7>='F' && LA23_7<='Z')||(LA23_7>='^' && LA23_7<='d')||(LA23_7>='f' && LA23_7<='z')||(LA23_7>='~' && LA23_7<='\uFFFF')) ) {s = 28;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_35 = input.LA(1);

                        s = -1;
                        if ( ((LA23_35>='0' && LA23_35<='9')) ) {s = 50;}

                        else if ( ((LA23_35>='\u0000' && LA23_35<='\b')||(LA23_35>='\u000B' && LA23_35<='\f')||(LA23_35>='\u000E' && LA23_35<='\u001F')||LA23_35=='!'||LA23_35=='$'||LA23_35=='&'||LA23_35=='+'||LA23_35=='/'||LA23_35==';'||LA23_35=='='||LA23_35=='?'||(LA23_35>='A' && LA23_35<='Z')||(LA23_35>='^' && LA23_35<='z')||(LA23_35>='~' && LA23_35<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_37 = input.LA(1);

                        s = -1;
                        if ( (LA23_37=='.') ) {s = 35;}

                        else if ( (LA23_37=='E'||LA23_37=='e') ) {s = 36;}

                        else if ( ((LA23_37>='0' && LA23_37<='9')) ) {s = 37;}

                        else if ( ((LA23_37>='\u0000' && LA23_37<='\b')||(LA23_37>='\u000B' && LA23_37<='\f')||(LA23_37>='\u000E' && LA23_37<='\u001F')||LA23_37=='!'||LA23_37=='$'||LA23_37=='&'||LA23_37=='+'||LA23_37=='/'||LA23_37==';'||LA23_37=='='||LA23_37=='?'||(LA23_37>='A' && LA23_37<='D')||(LA23_37>='F' && LA23_37<='Z')||(LA23_37>='^' && LA23_37<='d')||(LA23_37>='f' && LA23_37<='z')||(LA23_37>='~' && LA23_37<='\uFFFF')) ) {s = 28;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_112 = input.LA(1);

                        s = -1;
                        if ( ((LA23_112>='\u0000' && LA23_112<='\b')||(LA23_112>='\u000B' && LA23_112<='\f')||(LA23_112>='\u000E' && LA23_112<='\u001F')||LA23_112=='!'||LA23_112=='$'||LA23_112=='&'||LA23_112=='+'||(LA23_112>='.' && LA23_112<='9')||LA23_112==';'||LA23_112=='='||LA23_112=='?'||(LA23_112>='A' && LA23_112<='Z')||(LA23_112>='^' && LA23_112<='z')||(LA23_112>='~' && LA23_112<='\uFFFF')) ) {s = 28;}

                        else s = 114;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_75 = input.LA(1);

                        s = -1;
                        if ( ((LA23_75>='\u0000' && LA23_75<='\b')||(LA23_75>='\u000B' && LA23_75<='\f')||(LA23_75>='\u000E' && LA23_75<='\u001F')||LA23_75=='!'||LA23_75=='$'||LA23_75=='&'||LA23_75=='+'||(LA23_75>='.' && LA23_75<='/')||LA23_75==';'||LA23_75=='='||LA23_75=='?'||(LA23_75>='A' && LA23_75<='Z')||(LA23_75>='^' && LA23_75<='z')||(LA23_75>='~' && LA23_75<='\uFFFF')) ) {s = 28;}

                        else if ( ((LA23_75>='0' && LA23_75<='9')) ) {s = 75;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_76 = input.LA(1);

                        s = -1;
                        if ( ((LA23_76>='\u0000' && LA23_76<='\b')||(LA23_76>='\u000B' && LA23_76<='\f')||(LA23_76>='\u000E' && LA23_76<='\u001F')||LA23_76=='!'||LA23_76=='$'||LA23_76=='&'||LA23_76=='+'||(LA23_76>='.' && LA23_76<='9')||LA23_76==';'||LA23_76=='='||LA23_76=='?'||(LA23_76>='A' && LA23_76<='Z')||(LA23_76>='^' && LA23_76<='z')||(LA23_76>='~' && LA23_76<='\uFFFF')) ) {s = 28;}

                        else s = 85;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0=='o') ) {s = 1;}

                        else if ( (LA23_0=='%') && (( getCharPositionInLine() == 0 ))) {s = 2;}

                        else if ( (LA23_0=='#') ) {s = 3;}

                        else if ( (LA23_0=='\n'||LA23_0=='\r') ) {s = 4;}

                        else if ( (LA23_0=='\"') ) {s = 5;}

                        else if ( (LA23_0=='-') ) {s = 6;}

                        else if ( (LA23_0=='0') ) {s = 7;}

                        else if ( ((LA23_0>='1' && LA23_0<='9')) ) {s = 8;}

                        else if ( (LA23_0=='{') ) {s = 9;}

                        else if ( (LA23_0=='}') ) {s = 10;}

                        else if ( (LA23_0=='[') ) {s = 11;}

                        else if ( (LA23_0==']') ) {s = 12;}

                        else if ( (LA23_0=='<') ) {s = 13;}

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

                        else if ( (LA23_0=='b') ) {s = 24;}

                        else if ( (LA23_0=='d') ) {s = 25;}

                        else if ( (LA23_0=='p') ) {s = 26;}

                        else if ( (LA23_0=='m') ) {s = 27;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||LA23_0=='&'||LA23_0=='+'||LA23_0=='/'||LA23_0==';'||LA23_0=='='||LA23_0=='?'||(LA23_0>='A' && LA23_0<='Z')||(LA23_0>='^' && LA23_0<='a')||(LA23_0>='f' && LA23_0<='h')||(LA23_0>='j' && LA23_0<='l')||LA23_0=='n'||LA23_0=='q'||(LA23_0>='s' && LA23_0<='z')||(LA23_0>='~' && LA23_0<='\uFFFF')) ) {s = 28;}

                        else if ( (LA23_0=='\t'||LA23_0==' ') ) {s = 29;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA23_56 = input.LA(1);

                        s = -1;
                        if ( ((LA23_56>='\u0000' && LA23_56<='\b')||(LA23_56>='\u000B' && LA23_56<='\f')||(LA23_56>='\u000E' && LA23_56<='\u001F')||LA23_56=='!'||LA23_56=='$'||LA23_56=='&'||LA23_56=='+'||(LA23_56>='.' && LA23_56<='9')||LA23_56==';'||LA23_56=='='||LA23_56=='?'||(LA23_56>='A' && LA23_56<='Z')||(LA23_56>='^' && LA23_56<='z')||(LA23_56>='~' && LA23_56<='\uFFFF')) ) {s = 28;}

                        else s = 67;

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
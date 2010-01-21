// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g 2010-01-21 11:04:02

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
    public static final int End=50;
    public static final int LBrace=34;
    public static final int Frac=31;
    public static final int NonWhiteSpaceChar=45;
    public static final int DefaultValue=13;
    public static final int Module=5;
    public static final int Preamble=19;
    public static final int LineComment=20;
    public static final int RBracket=37;
    public static final int Attribute=10;
    public static final int EOF=-1;
    public static final int HexDigit=24;
    public static final int Default=54;
    public static final int Lt=38;
    public static final int Parent=8;
    public static final int LineBreak=21;
    public static final int OrderBy=56;
    public static final int BelongsTo=53;
    public static final int Index=52;
    public static final int Argument=17;
    public static final int WhiteSpace=63;
    public static final int Symbol=47;
    public static final int String=29;
    public static final int Class=48;
    public static final int LBracket=36;
    public static final int RBrace=35;
    public static final int Double=33;
    public static final int RParen=42;
    public static final int QName=65;
    public static final int QNameChar=64;
    public static final int LParen=41;
    public static final int TypeName=12;
    public static final int WhiteSpaces=61;
    public static final int StringChar_s=28;
    public static final int Includes=49;
    public static final int Exp=32;
    public static final int UnicodeChar=25;
    public static final int ModuleDef=62;
    public static final int AllIncluded=14;
    public static final int Mixin=9;
    public static final int Digit=22;
    public static final int SymbolChars=46;
    public static final int TargetClass=15;
    public static final int UnsafeUnicodeChar=44;
    public static final int Relation=51;
    public static final int Schema=4;
    public static final int Function=16;
    public static final int LineBreakChar=18;
    public static final int ClassDef=6;
    public static final int IsArray=11;
    public static final int ModuleName=60;
    public static final int Dot=39;
    public static final int Name=7;
    public static final int StringChar=27;
    public static final int Projection=55;
    public static final int On=57;
    public static final int Star=43;
    public static final int SafeLetter=59;
    public static final int SafeFirstLetter=58;
    public static final int Comma=40;
    public static final int EscapeSequence=26;
    public static final int Letter=23;
    public static final int Integer=30;

      


    // delegates
    // delegators

    public SilkSchemaLexer() {;} 
    public SilkSchemaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SilkSchemaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g"; }

    // $ANTLR start "Preamble"
    public final void mPreamble() throws RecognitionException {
        try {
            int _type = Preamble;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:9: ({...}? => '%' (~ ( LineBreakChar ) )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:11: {...}? => '%' (~ ( LineBreakChar ) )*
            {
            if ( !(( getCharPositionInLine() == 0 )) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "Preamble", " getCharPositionInLine() == 0 ");
            }
            match('%'); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:52: (~ ( LineBreakChar ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:113:52: ~ ( LineBreakChar )
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:116:23: ( '\\n' | '\\r' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:12: ( '#' (~ ( LineBreakChar ) )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:14: '#' (~ ( LineBreakChar ) )*
            {
            match('#'); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:18: (~ ( LineBreakChar ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:117:18: ~ ( LineBreakChar )
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:10: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:12: ( '\\r' '\\n' | '\\r' | '\\n' )
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:13: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:120:32: '\\n'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:123:15: ( '0' .. '9' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:123:17: '0' .. '9'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:124:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:125:18: ( Digit | Letter )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:126:21: (~ ( '\"' | '\\\\' ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:126:23: ~ ( '\"' | '\\\\' )
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:3: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:5: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:10: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:11: '\\\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:18: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:25: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:31: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:37: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:43: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:49: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:55: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:128:61: 'u' HexDigit HexDigit HexDigit HexDigit
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:131:21: ( UnicodeChar | EscapeSequence )
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:131:24: UnicodeChar
                    {
                    mUnicodeChar(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:131:38: EscapeSequence
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:132:22: ( ( StringChar )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:132:24: ( StringChar )*
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:132:24: ( StringChar )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:132:24: StringChar
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:134:7: ( '\"' s= StringChar_s '\"' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:134:9: '\"' s= StringChar_s '\"'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:10: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:10: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;

            }

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:15: ( '0' | '1' .. '9' ( Digit )* )
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:16: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); if (state.failed) return ;
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:31: ( Digit )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:137:31: Digit
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:138:14: ( '.' ( Digit )+ )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:138:16: '.' ( Digit )+
            {
            match('.'); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:138:20: ( Digit )+
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
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:138:20: Digit
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:27: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:40: ( Digit )+
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
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:40: Digit
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:17: ( Frac ( Exp )? | Exp )
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:18: Frac ( Exp )?
                    {
                    mFrac(); if (state.failed) return ;
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:23: ( Exp )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:23: Exp
                            {
                            mExp(); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:30: Exp
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:142:7: ( '{' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:142:9: '{'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:143:7: ( '}' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:143:9: '}'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:144:9: ( '[' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:144:11: '['
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:145:9: ( ']' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:145:11: ']'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:147:3: ( '<' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:147:5: '<'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:148:4: ( '.' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:148:6: '.'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:149:6: ( ',' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:149:8: ','
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:151:7: ( '(' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:151:9: '('
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:152:7: ( ')' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:152:9: ')'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:154:5: ( '*' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:154:7: '*'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:157:18: ( '(' | ')' | '[' | ']' | '{' | '}' | ',' | ':' | '#' | '<' | '>' | '|' | '*' | '\\'' | '\"' | '@' | '%' | '\\\\' | '.' | '-' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:160:18: (~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:160:20: ~ ( UnsafeUnicodeChar | '\\r' | '\\n' | ' ' | '\\t' | '\\u000C' )
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:162:21: ( ( NonWhiteSpaceChar )+ )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:162:23: ( NonWhiteSpaceChar )+
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:162:23: ( NonWhiteSpaceChar )+
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
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:162:23: NonWhiteSpaceChar
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:163:7: ( ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:163:9: ( ':' NonWhiteSpaceChar )=> ':' s= SymbolChars
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:165:6: ( 'class' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:165:8: 'class'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:166:9: ( 'includes' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:166:11: 'includes'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:167:4: ( 'end' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:167:6: 'end'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:168:9: ( 'relation' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:168:11: 'relation'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:169:6: ( 'index' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:169:8: 'index'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:170:10: ( 'belongs_to' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:170:12: 'belongs_to'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:171:8: ( 'default' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:171:10: 'default'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:172:11: ( 'projection' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:172:13: 'projection'
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:173:8: ( 'order_by' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:173:10: 'order_by'
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

    // $ANTLR start "On"
    public final void mOn() throws RecognitionException {
        try {
            int _type = On;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:174:3: ( 'on' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:174:5: 'on'
            {
            match("on"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "On"

    // $ANTLR start "SafeFirstLetter"
    public final void mSafeFirstLetter() throws RecognitionException {
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:176:25: ( 'A' .. 'Z' | 'a' .. 'z' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:177:20: ( SafeFirstLetter | '0' .. '9' | '-' | '_' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:20: ( SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:22: SafeFirstLetter ( SafeLetter )* ( '.' SafeFirstLetter ( SafeLetter )* )*
            {
            mSafeFirstLetter(); if (state.failed) return ;
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:38: ( SafeLetter )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='-'||(LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:38: SafeLetter
            	    {
            	    mSafeLetter(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:50: ( '.' SafeFirstLetter ( SafeLetter )* )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='.') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:51: '.' SafeFirstLetter ( SafeLetter )*
            	    {
            	    match('.'); if (state.failed) return ;
            	    mSafeFirstLetter(); if (state.failed) return ;
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:71: ( SafeLetter )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0=='-'||(LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:179:71: SafeLetter
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:180:10: ( 'module' WhiteSpaces s= ModuleName )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:180:12: 'module' WhiteSpaces s= ModuleName
            {
            match("module"); if (state.failed) return ;

            mWhiteSpaces(); if (state.failed) return ;
            int sStart736 = getCharIndex();
            mModuleName(); if (state.failed) return ;
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart736, getCharIndex()-1);
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:182:19: (~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:182:21: ~ ( LineBreakChar | UnsafeUnicodeChar | WhiteSpace )
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:6: ( ( QNameChar )+ ( Dot ( QNameChar )+ )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:8: ( QNameChar )+ ( Dot ( QNameChar )+ )*
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:8: ( QNameChar )+
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
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:8: QNameChar
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

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:19: ( Dot ( QNameChar )+ )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='.') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:20: Dot ( QNameChar )+
            	    {
            	    mDot(); if (state.failed) return ;
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:24: ( QNameChar )+
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
            	    	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:183:24: QNameChar
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:186:11: ( ' ' | '\\t' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:
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
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:188:12: ( ( WhiteSpace )+ )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:188:14: ( WhiteSpace )+
            {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:188:14: ( WhiteSpace )+
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
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:188:14: WhiteSpace
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
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:8: ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | Projection | OrderBy | On | ModuleDef | QName | WhiteSpaces )
        int alt23=30;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:10: Preamble
                {
                mPreamble(); if (state.failed) return ;

                }
                break;
            case 2 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:19: LineComment
                {
                mLineComment(); if (state.failed) return ;

                }
                break;
            case 3 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:31: LineBreak
                {
                mLineBreak(); if (state.failed) return ;

                }
                break;
            case 4 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:41: String
                {
                mString(); if (state.failed) return ;

                }
                break;
            case 5 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:48: Integer
                {
                mInteger(); if (state.failed) return ;

                }
                break;
            case 6 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:56: Double
                {
                mDouble(); if (state.failed) return ;

                }
                break;
            case 7 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:63: LBrace
                {
                mLBrace(); if (state.failed) return ;

                }
                break;
            case 8 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:70: RBrace
                {
                mRBrace(); if (state.failed) return ;

                }
                break;
            case 9 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:77: LBracket
                {
                mLBracket(); if (state.failed) return ;

                }
                break;
            case 10 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:86: RBracket
                {
                mRBracket(); if (state.failed) return ;

                }
                break;
            case 11 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:95: Lt
                {
                mLt(); if (state.failed) return ;

                }
                break;
            case 12 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:98: Dot
                {
                mDot(); if (state.failed) return ;

                }
                break;
            case 13 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:102: Comma
                {
                mComma(); if (state.failed) return ;

                }
                break;
            case 14 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:108: LParen
                {
                mLParen(); if (state.failed) return ;

                }
                break;
            case 15 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:115: RParen
                {
                mRParen(); if (state.failed) return ;

                }
                break;
            case 16 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:122: Star
                {
                mStar(); if (state.failed) return ;

                }
                break;
            case 17 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:127: Symbol
                {
                mSymbol(); if (state.failed) return ;

                }
                break;
            case 18 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:134: Class
                {
                mClass(); if (state.failed) return ;

                }
                break;
            case 19 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:140: Includes
                {
                mIncludes(); if (state.failed) return ;

                }
                break;
            case 20 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:149: End
                {
                mEnd(); if (state.failed) return ;

                }
                break;
            case 21 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:153: Relation
                {
                mRelation(); if (state.failed) return ;

                }
                break;
            case 22 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:162: Index
                {
                mIndex(); if (state.failed) return ;

                }
                break;
            case 23 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:168: BelongsTo
                {
                mBelongsTo(); if (state.failed) return ;

                }
                break;
            case 24 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:178: Default
                {
                mDefault(); if (state.failed) return ;

                }
                break;
            case 25 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:186: Projection
                {
                mProjection(); if (state.failed) return ;

                }
                break;
            case 26 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:197: OrderBy
                {
                mOrderBy(); if (state.failed) return ;

                }
                break;
            case 27 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:205: On
                {
                mOn(); if (state.failed) return ;

                }
                break;
            case 28 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:208: ModuleDef
                {
                mModuleDef(); if (state.failed) return ;

                }
                break;
            case 29 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:218: QName
                {
                mQName(); if (state.failed) return ;

                }
                break;
            case 30 :
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:1:224: WhiteSpaces
                {
                mWhiteSpaces(); if (state.failed) return ;

                }
                break;

        }

    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\6\uffff\2\40\13\uffff\11\34\2\uffff\2\40\2\uffff\1\34\1\40\10"+
        "\34\1\74\1\34\1\uffff\1\40\1\56\1\34\1\56\3\34\1\102\5\34\1\uffff"+
        "\5\34\1\uffff\7\34\1\56\1\124\1\34\1\126\6\34\1\uffff\1\34\1\uffff"+
        "\11\34\1\147\2\34\1\uffff\1\152\1\153\1\34\1\uffff\1\34\1\156\2"+
        "\uffff\2\34\1\uffff\1\161\1\162\2\uffff";
    static final String DFA23_eofS =
        "\163\uffff";
    static final String DFA23_minS =
        "\1\0\4\uffff\1\60\2\0\13\uffff\1\154\2\156\3\145\1\162\1\156\1"+
        "\157\2\uffff\2\56\1\uffff\1\0\1\53\1\0\1\141\1\143\1\144\2\154\1"+
        "\146\1\157\1\144\1\0\1\144\1\uffff\1\56\1\0\1\60\1\0\1\163\1\154"+
        "\1\145\1\0\1\141\1\157\1\141\1\152\1\145\1\uffff\1\165\1\53\1\163"+
        "\1\165\1\170\1\uffff\1\164\1\156\1\165\1\145\1\162\1\154\1\60\2"+
        "\0\1\144\1\0\1\151\1\147\1\154\1\143\1\137\1\145\1\uffff\1\145\1"+
        "\uffff\1\157\1\163\2\164\1\142\1\11\1\163\1\156\1\137\1\0\1\151"+
        "\1\171\1\uffff\2\0\1\164\1\uffff\1\157\1\0\2\uffff\1\157\1\156\1"+
        "\uffff\2\0\2\uffff";
    static final String DFA23_maxS =
        "\1\uffff\4\uffff\1\71\2\uffff\13\uffff\1\154\2\156\3\145\2\162"+
        "\1\157\2\uffff\2\145\1\uffff\1\uffff\1\71\1\uffff\1\141\2\144\2"+
        "\154\1\146\1\157\1\144\1\uffff\1\144\1\uffff\1\145\1\uffff\1\71"+
        "\1\uffff\1\163\1\154\1\145\1\uffff\1\141\1\157\1\141\1\152\1\145"+
        "\1\uffff\1\165\1\71\1\163\1\165\1\170\1\uffff\1\164\1\156\1\165"+
        "\1\145\1\162\1\154\1\71\2\uffff\1\144\1\uffff\1\151\1\147\1\154"+
        "\1\143\1\137\1\145\1\uffff\1\145\1\uffff\1\157\1\163\2\164\1\142"+
        "\1\40\1\163\1\156\1\137\1\uffff\1\151\1\171\1\uffff\2\uffff\1\164"+
        "\1\uffff\1\157\1\uffff\2\uffff\1\157\1\156\1\uffff\2\uffff\2\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\1\21\11\uffff\1\35\1\36\2\uffff\1\5\15\uffff"+
        "\1\6\15\uffff\1\33\5\uffff\1\24\21\uffff\1\22\1\uffff\1\26\14\uffff"+
        "\1\34\3\uffff\1\30\2\uffff\1\23\1\25\2\uffff\1\32\2\uffff\1\27\1"+
        "\31";
    static final String DFA23_specialS =
        "\1\12\5\uffff\1\16\1\20\31\uffff\1\4\1\uffff\1\1\10\uffff\1\13"+
        "\3\uffff\1\14\1\uffff\1\21\3\uffff\1\3\23\uffff\1\6\1\17\1\uffff"+
        "\1\0\22\uffff\1\10\3\uffff\1\5\1\2\3\uffff\1\15\5\uffff\1\11\1\7"+
        "\2\uffff}>";
    static final String[] DFA23_transitionS = {
            "\11\34\1\35\1\3\2\34\1\3\22\34\1\35\1\34\1\4\1\2\1\34\1\1\1"+
            "\34\1\uffff\1\17\1\20\1\21\1\34\1\16\1\5\1\15\1\34\1\6\11\7"+
            "\1\22\1\34\1\14\1\34\1\uffff\1\34\1\uffff\32\34\1\12\1\uffff"+
            "\1\13\4\34\1\27\1\23\1\30\1\25\3\34\1\24\3\34\1\33\1\34\1\32"+
            "\1\31\1\34\1\26\10\34\1\10\1\uffff\1\11\uff82\34",
            "",
            "",
            "",
            "",
            "\1\36\11\37",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\41\13\34\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\42\25\34\3\uffff\7\34"+
            "\1\42\25\34\3\uffff\uff82\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\41\1\34\12\43\1\uffff\1"+
            "\34\1\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\42\25\34\3\uffff"+
            "\7\34\1\42\25\34\3\uffff\uff82\34",
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
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\54\3\uffff\1\53",
            "\1\55",
            "",
            "",
            "\1\56\26\uffff\1\56\37\uffff\1\56",
            "\1\56\1\uffff\12\57\13\uffff\1\56\37\uffff\1\56",
            "",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\3\uffff\1\34\12\60\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\1\61\1\uffff\1\56\2\uffff\12\62",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\1\41\1\34\12\43\1\uffff\1"+
            "\34\1\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\42\25\34\3\uffff"+
            "\7\34\1\42\25\34\3\uffff\uff82\34",
            "\1\63",
            "\1\64\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\75",
            "",
            "\1\56\1\uffff\12\57\13\uffff\1\56\37\uffff\1\56",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\60\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\4\34\1\76\25\34\3\uffff\7\34"+
            "\1\76\25\34\3\uffff\uff82\34",
            "\12\62",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\62\1\uffff\1\34\1"+
            "\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\1\77",
            "\1\100",
            "\1\101",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "\1\110",
            "\1\111\1\uffff\1\56\2\uffff\12\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\112",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\2\34\12\112\1\uffff\1\34"+
            "\1\uffff\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff"+
            "\uff82\34",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\125",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143\26\uffff\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "\1\150",
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
            "\1\154",
            "",
            "\1\155",
            "\11\34\2\uffff\2\34\1\uffff\22\34\1\uffff\1\34\2\uffff\1\34"+
            "\1\uffff\1\34\4\uffff\1\34\2\uffff\14\34\1\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\1\uffff\32\34\3\uffff\35\34\3\uffff\uff82"+
            "\34",
            "",
            "",
            "\1\157",
            "\1\160",
            "",
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
            return "1:1: Tokens : ( Preamble | LineComment | LineBreak | String | Integer | Double | LBrace | RBrace | LBracket | RBracket | Lt | Dot | Comma | LParen | RParen | Star | Symbol | Class | Includes | End | Relation | Index | BelongsTo | Default | Projection | OrderBy | On | ModuleDef | QName | WhiteSpaces );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_77 = input.LA(1);

                        s = -1;
                        if ( ((LA23_77>='\u0000' && LA23_77<='\b')||(LA23_77>='\u000B' && LA23_77<='\f')||(LA23_77>='\u000E' && LA23_77<='\u001F')||LA23_77=='!'||LA23_77=='$'||LA23_77=='&'||LA23_77=='+'||(LA23_77>='.' && LA23_77<='9')||LA23_77==';'||LA23_77=='='||LA23_77=='?'||(LA23_77>='A' && LA23_77<='Z')||(LA23_77>='^' && LA23_77<='z')||(LA23_77>='~' && LA23_77<='\uFFFF')) ) {s = 28;}

                        else s = 86;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_35 = input.LA(1);

                        s = -1;
                        if ( (LA23_35=='.') ) {s = 33;}

                        else if ( (LA23_35=='E'||LA23_35=='e') ) {s = 34;}

                        else if ( ((LA23_35>='0' && LA23_35<='9')) ) {s = 35;}

                        else if ( ((LA23_35>='\u0000' && LA23_35<='\b')||(LA23_35>='\u000B' && LA23_35<='\f')||(LA23_35>='\u000E' && LA23_35<='\u001F')||LA23_35=='!'||LA23_35=='$'||LA23_35=='&'||LA23_35=='+'||LA23_35=='/'||LA23_35==';'||LA23_35=='='||LA23_35=='?'||(LA23_35>='A' && LA23_35<='D')||(LA23_35>='F' && LA23_35<='Z')||(LA23_35>='^' && LA23_35<='d')||(LA23_35>='f' && LA23_35<='z')||(LA23_35>='~' && LA23_35<='\uFFFF')) ) {s = 28;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_101 = input.LA(1);

                        s = -1;
                        if ( ((LA23_101>='\u0000' && LA23_101<='\b')||(LA23_101>='\u000B' && LA23_101<='\f')||(LA23_101>='\u000E' && LA23_101<='\u001F')||LA23_101=='!'||LA23_101=='$'||LA23_101=='&'||LA23_101=='+'||(LA23_101>='.' && LA23_101<='9')||LA23_101==';'||LA23_101=='='||LA23_101=='?'||(LA23_101>='A' && LA23_101<='Z')||(LA23_101>='^' && LA23_101<='z')||(LA23_101>='~' && LA23_101<='\uFFFF')) ) {s = 28;}

                        else s = 107;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_54 = input.LA(1);

                        s = -1;
                        if ( ((LA23_54>='\u0000' && LA23_54<='\b')||(LA23_54>='\u000B' && LA23_54<='\f')||(LA23_54>='\u000E' && LA23_54<='\u001F')||LA23_54=='!'||LA23_54=='$'||LA23_54=='&'||LA23_54=='+'||(LA23_54>='.' && LA23_54<='9')||LA23_54==';'||LA23_54=='='||LA23_54=='?'||(LA23_54>='A' && LA23_54<='Z')||(LA23_54>='^' && LA23_54<='z')||(LA23_54>='~' && LA23_54<='\uFFFF')) ) {s = 28;}

                        else s = 66;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_33 = input.LA(1);

                        s = -1;
                        if ( ((LA23_33>='0' && LA23_33<='9')) ) {s = 48;}

                        else if ( ((LA23_33>='\u0000' && LA23_33<='\b')||(LA23_33>='\u000B' && LA23_33<='\f')||(LA23_33>='\u000E' && LA23_33<='\u001F')||LA23_33=='!'||LA23_33=='$'||LA23_33=='&'||LA23_33=='+'||LA23_33=='/'||LA23_33==';'||LA23_33=='='||LA23_33=='?'||(LA23_33>='A' && LA23_33<='Z')||(LA23_33>='^' && LA23_33<='z')||(LA23_33>='~' && LA23_33<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_100 = input.LA(1);

                        s = -1;
                        if ( ((LA23_100>='\u0000' && LA23_100<='\b')||(LA23_100>='\u000B' && LA23_100<='\f')||(LA23_100>='\u000E' && LA23_100<='\u001F')||LA23_100=='!'||LA23_100=='$'||LA23_100=='&'||LA23_100=='+'||(LA23_100>='.' && LA23_100<='9')||LA23_100==';'||LA23_100=='='||LA23_100=='?'||(LA23_100>='A' && LA23_100<='Z')||(LA23_100>='^' && LA23_100<='z')||(LA23_100>='~' && LA23_100<='\uFFFF')) ) {s = 28;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_74 = input.LA(1);

                        s = -1;
                        if ( ((LA23_74>='\u0000' && LA23_74<='\b')||(LA23_74>='\u000B' && LA23_74<='\f')||(LA23_74>='\u000E' && LA23_74<='\u001F')||LA23_74=='!'||LA23_74=='$'||LA23_74=='&'||LA23_74=='+'||(LA23_74>='.' && LA23_74<='/')||LA23_74==';'||LA23_74=='='||LA23_74=='?'||(LA23_74>='A' && LA23_74<='Z')||(LA23_74>='^' && LA23_74<='z')||(LA23_74>='~' && LA23_74<='\uFFFF')) ) {s = 28;}

                        else if ( ((LA23_74>='0' && LA23_74<='9')) ) {s = 74;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_112 = input.LA(1);

                        s = -1;
                        if ( ((LA23_112>='\u0000' && LA23_112<='\b')||(LA23_112>='\u000B' && LA23_112<='\f')||(LA23_112>='\u000E' && LA23_112<='\u001F')||LA23_112=='!'||LA23_112=='$'||LA23_112=='&'||LA23_112=='+'||(LA23_112>='.' && LA23_112<='9')||LA23_112==';'||LA23_112=='='||LA23_112=='?'||(LA23_112>='A' && LA23_112<='Z')||(LA23_112>='^' && LA23_112<='z')||(LA23_112>='~' && LA23_112<='\uFFFF')) ) {s = 28;}

                        else s = 114;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_96 = input.LA(1);

                        s = -1;
                        if ( ((LA23_96>='\u0000' && LA23_96<='\b')||(LA23_96>='\u000B' && LA23_96<='\f')||(LA23_96>='\u000E' && LA23_96<='\u001F')||LA23_96=='!'||LA23_96=='$'||LA23_96=='&'||LA23_96=='+'||(LA23_96>='.' && LA23_96<='9')||LA23_96==';'||LA23_96=='='||LA23_96=='?'||(LA23_96>='A' && LA23_96<='Z')||(LA23_96>='^' && LA23_96<='z')||(LA23_96>='~' && LA23_96<='\uFFFF')) ) {s = 28;}

                        else s = 103;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_111 = input.LA(1);

                        s = -1;
                        if ( ((LA23_111>='\u0000' && LA23_111<='\b')||(LA23_111>='\u000B' && LA23_111<='\f')||(LA23_111>='\u000E' && LA23_111<='\u001F')||LA23_111=='!'||LA23_111=='$'||LA23_111=='&'||LA23_111=='+'||(LA23_111>='.' && LA23_111<='9')||LA23_111==';'||LA23_111=='='||LA23_111=='?'||(LA23_111>='A' && LA23_111<='Z')||(LA23_111>='^' && LA23_111<='z')||(LA23_111>='~' && LA23_111<='\uFFFF')) ) {s = 28;}

                        else s = 113;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
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

                        else if ( (LA23_0=='p') ) {s = 25;}

                        else if ( (LA23_0=='o') ) {s = 26;}

                        else if ( (LA23_0=='m') ) {s = 27;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||LA23_0=='$'||LA23_0=='&'||LA23_0=='+'||LA23_0=='/'||LA23_0==';'||LA23_0=='='||LA23_0=='?'||(LA23_0>='A' && LA23_0<='Z')||(LA23_0>='^' && LA23_0<='a')||(LA23_0>='f' && LA23_0<='h')||(LA23_0>='j' && LA23_0<='l')||LA23_0=='n'||LA23_0=='q'||(LA23_0>='s' && LA23_0<='z')||(LA23_0>='~' && LA23_0<='\uFFFF')) ) {s = 28;}

                        else if ( (LA23_0=='\t'||LA23_0==' ') ) {s = 29;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_44 = input.LA(1);

                        s = -1;
                        if ( ((LA23_44>='\u0000' && LA23_44<='\b')||(LA23_44>='\u000B' && LA23_44<='\f')||(LA23_44>='\u000E' && LA23_44<='\u001F')||LA23_44=='!'||LA23_44=='$'||LA23_44=='&'||LA23_44=='+'||(LA23_44>='.' && LA23_44<='9')||LA23_44==';'||LA23_44=='='||LA23_44=='?'||(LA23_44>='A' && LA23_44<='Z')||(LA23_44>='^' && LA23_44<='z')||(LA23_44>='~' && LA23_44<='\uFFFF')) ) {s = 28;}

                        else s = 60;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_48 = input.LA(1);

                        s = -1;
                        if ( ((LA23_48>='\u0000' && LA23_48<='\b')||(LA23_48>='\u000B' && LA23_48<='\f')||(LA23_48>='\u000E' && LA23_48<='\u001F')||LA23_48=='!'||LA23_48=='$'||LA23_48=='&'||LA23_48=='+'||(LA23_48>='.' && LA23_48<='/')||LA23_48==';'||LA23_48=='='||LA23_48=='?'||(LA23_48>='A' && LA23_48<='D')||(LA23_48>='F' && LA23_48<='Z')||(LA23_48>='^' && LA23_48<='d')||(LA23_48>='f' && LA23_48<='z')||(LA23_48>='~' && LA23_48<='\uFFFF')) ) {s = 28;}

                        else if ( (LA23_48=='E'||LA23_48=='e') ) {s = 62;}

                        else if ( ((LA23_48>='0' && LA23_48<='9')) ) {s = 48;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_105 = input.LA(1);

                        s = -1;
                        if ( ((LA23_105>='\u0000' && LA23_105<='\b')||(LA23_105>='\u000B' && LA23_105<='\f')||(LA23_105>='\u000E' && LA23_105<='\u001F')||LA23_105=='!'||LA23_105=='$'||LA23_105=='&'||LA23_105=='+'||(LA23_105>='.' && LA23_105<='9')||LA23_105==';'||LA23_105=='='||LA23_105=='?'||(LA23_105>='A' && LA23_105<='Z')||(LA23_105>='^' && LA23_105<='z')||(LA23_105>='~' && LA23_105<='\uFFFF')) ) {s = 28;}

                        else s = 110;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_6 = input.LA(1);

                        s = -1;
                        if ( (LA23_6=='.') ) {s = 33;}

                        else if ( (LA23_6=='E'||LA23_6=='e') ) {s = 34;}

                        else if ( ((LA23_6>='\u0000' && LA23_6<='\b')||(LA23_6>='\u000B' && LA23_6<='\f')||(LA23_6>='\u000E' && LA23_6<='\u001F')||LA23_6=='!'||LA23_6=='$'||LA23_6=='&'||LA23_6=='+'||(LA23_6>='/' && LA23_6<='9')||LA23_6==';'||LA23_6=='='||LA23_6=='?'||(LA23_6>='A' && LA23_6<='D')||(LA23_6>='F' && LA23_6<='Z')||(LA23_6>='^' && LA23_6<='d')||(LA23_6>='f' && LA23_6<='z')||(LA23_6>='~' && LA23_6<='\uFFFF')) ) {s = 28;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_75 = input.LA(1);

                        s = -1;
                        if ( ((LA23_75>='\u0000' && LA23_75<='\b')||(LA23_75>='\u000B' && LA23_75<='\f')||(LA23_75>='\u000E' && LA23_75<='\u001F')||LA23_75=='!'||LA23_75=='$'||LA23_75=='&'||LA23_75=='+'||(LA23_75>='.' && LA23_75<='9')||LA23_75==';'||LA23_75=='='||LA23_75=='?'||(LA23_75>='A' && LA23_75<='Z')||(LA23_75>='^' && LA23_75<='z')||(LA23_75>='~' && LA23_75<='\uFFFF')) ) {s = 28;}

                        else s = 84;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_7 = input.LA(1);

                        s = -1;
                        if ( ((LA23_7>='0' && LA23_7<='9')) ) {s = 35;}

                        else if ( (LA23_7=='.') ) {s = 33;}

                        else if ( (LA23_7=='E'||LA23_7=='e') ) {s = 34;}

                        else if ( ((LA23_7>='\u0000' && LA23_7<='\b')||(LA23_7>='\u000B' && LA23_7<='\f')||(LA23_7>='\u000E' && LA23_7<='\u001F')||LA23_7=='!'||LA23_7=='$'||LA23_7=='&'||LA23_7=='+'||LA23_7=='/'||LA23_7==';'||LA23_7=='='||LA23_7=='?'||(LA23_7>='A' && LA23_7<='D')||(LA23_7>='F' && LA23_7<='Z')||(LA23_7>='^' && LA23_7<='d')||(LA23_7>='f' && LA23_7<='z')||(LA23_7>='~' && LA23_7<='\uFFFF')) ) {s = 28;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA23_50 = input.LA(1);

                        s = -1;
                        if ( ((LA23_50>='0' && LA23_50<='9')) ) {s = 50;}

                        else if ( ((LA23_50>='\u0000' && LA23_50<='\b')||(LA23_50>='\u000B' && LA23_50<='\f')||(LA23_50>='\u000E' && LA23_50<='\u001F')||LA23_50=='!'||LA23_50=='$'||LA23_50=='&'||LA23_50=='+'||(LA23_50>='.' && LA23_50<='/')||LA23_50==';'||LA23_50=='='||LA23_50=='?'||(LA23_50>='A' && LA23_50<='Z')||(LA23_50>='^' && LA23_50<='z')||(LA23_50>='~' && LA23_50<='\uFFFF')) ) {s = 28;}

                        else s = 46;

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
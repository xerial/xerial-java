// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 RelationSchema.g 2010-03-01 14:53:39

/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// Xerial RAQUEL - Relational-Style Amoeba Query Language
// 
// RelationSchemaLexer.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------

package org.xerial.lens.relation.schema.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RelationSchemaLexer extends Lexer {
    public static final int RelationDef=35;
    public static final int RParen=16;
    public static final int Apos=26;
    public static final int QName=37;
    public static final int At=24;
    public static final int TreeDef=36;
    public static final int LParen=15;
    public static final int LINE_COMMENT=14;
    public static final int NameChar=31;
    public static final int RBracket=18;
    public static final int Colon=27;
    public static final int Context=8;
    public static final int Tree=11;
    public static final int RelationSchema=4;
    public static final int Question=23;
    public static final int Digit=29;
    public static final int Equal=20;
    public static final int EOF=-1;
    public static final int Occurrence=10;
    public static final int StringLiteral=33;
    public static final int ML_COMMENT=12;
    public static final int Relation=5;
    public static final int Value=9;
    public static final int Plus=21;
    public static final int NameFragment=34;
    public static final int NEWLINE=13;
    public static final int Digits=30;
    public static final int WhiteSpaceChar=32;
    public static final int RelationAttribute=7;
    public static final int Name=6;
    public static final int LBracket=17;
    public static final int Star=22;
    public static final int Comma=19;
    public static final int Letter=28;
    public static final int Quot=25;

    // delegates
    // delegators

    public RelationSchemaLexer() {;} 
    public RelationSchemaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RelationSchemaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "RelationSchema.g"; }

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:102:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // RelationSchema.g:102:6: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // RelationSchema.g:102:11: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // RelationSchema.g:102:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("*/"); 

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:106:5: ({...}? => '//' (~ ( '\\n' | '\\r' ) )* NEWLINE )
            // RelationSchema.g:106:7: {...}? => '//' (~ ( '\\n' | '\\r' ) )* NEWLINE
            {
            if ( !((getCharPositionInLine()==0)) ) {
                throw new FailedPredicateException(input, "LINE_COMMENT", "getCharPositionInLine()==0");
            }
            match("//"); 

            // RelationSchema.g:106:45: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // RelationSchema.g:106:45: ~ ( '\\n' | '\\r' )
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
            	    break loop2;
                }
            } while (true);

            mNEWLINE(); 
             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:110:2: ( ( '\\r' )? '\\n' )
            // RelationSchema.g:110:4: ( '\\r' )? '\\n'
            {
            // RelationSchema.g:110:4: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // RelationSchema.g:110:4: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:114:7: ( '(' )
            // RelationSchema.g:114:9: '('
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
            // RelationSchema.g:115:7: ( ')' )
            // RelationSchema.g:115:9: ')'
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

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:116:9: ( '[' )
            // RelationSchema.g:116:11: '['
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
            // RelationSchema.g:117:9: ( ']' )
            // RelationSchema.g:117:11: ']'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:118:6: ( ',' )
            // RelationSchema.g:118:8: ','
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

    // $ANTLR start "Equal"
    public final void mEqual() throws RecognitionException {
        try {
            int _type = Equal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:119:6: ( '=' )
            // RelationSchema.g:119:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Equal"

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:120:5: ( '+' )
            // RelationSchema.g:120:7: '+'
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

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            int _type = Star;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:121:5: ( '*' )
            // RelationSchema.g:121:7: '*'
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

    // $ANTLR start "Question"
    public final void mQuestion() throws RecognitionException {
        try {
            int _type = Question;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:122:9: ( '?' )
            // RelationSchema.g:122:11: '?'
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

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            // RelationSchema.g:124:12: ( '@' )
            // RelationSchema.g:124:14: '@'
            {
            match('@'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "At"

    // $ANTLR start "Quot"
    public final void mQuot() throws RecognitionException {
        try {
            // RelationSchema.g:126:14: ( '\"' )
            // RelationSchema.g:126:16: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Quot"

    // $ANTLR start "Apos"
    public final void mApos() throws RecognitionException {
        try {
            // RelationSchema.g:127:14: ( '\\'' )
            // RelationSchema.g:127:16: '\\''
            {
            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Apos"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            // RelationSchema.g:128:15: ( ':' )
            // RelationSchema.g:128:17: ':'
            {
            match(':'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // RelationSchema.g:130:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // RelationSchema.g:
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
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // RelationSchema.g:131:15: ( '0' .. '9' )
            // RelationSchema.g:131:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Digits"
    public final void mDigits() throws RecognitionException {
        try {
            int _type = Digits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:132:7: ( ( Digit )+ )
            // RelationSchema.g:132:9: ( Digit )+
            {
            // RelationSchema.g:132:9: ( Digit )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // RelationSchema.g:132:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Digits"

    // $ANTLR start "NameChar"
    public final void mNameChar() throws RecognitionException {
        try {
            // RelationSchema.g:134:18: ( Letter | Digit | '_' | '-' )
            // RelationSchema.g:
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
    // $ANTLR end "NameChar"

    // $ANTLR start "WhiteSpaceChar"
    public final void mWhiteSpaceChar() throws RecognitionException {
        try {
            int _type = WhiteSpaceChar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:135:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // RelationSchema.g:135:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // RelationSchema.g:135:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||(LA5_0>='\f' && LA5_0<='\r')||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // RelationSchema.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpaceChar"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:138:1: ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // RelationSchema.g:138:3: Quot (~ '\"' )* Quot
                    {
                    mQuot(); 
                    // RelationSchema.g:138:8: (~ '\"' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // RelationSchema.g:138:9: ~ '\"'
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    mQuot(); 
                     String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); 

                    }
                    break;
                case 2 :
                    // RelationSchema.g:139:3: Apos (~ '\\'' )* Apos
                    {
                    mApos(); 
                    // RelationSchema.g:139:8: (~ '\\'' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // RelationSchema.g:139:9: ~ '\\''
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    mApos(); 
                     String tmp = getText(); setText(tmp.substring(1, tmp.length()-1).trim()); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "NameFragment"
    public final void mNameFragment() throws RecognitionException {
        try {
            // RelationSchema.g:142:22: ( ( Letter | '_' ) ( NameChar )* )
            // RelationSchema.g:142:24: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // RelationSchema.g:142:39: ( NameChar )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // RelationSchema.g:142:39: NameChar
            	    {
            	    mNameChar(); 

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
    // $ANTLR end "NameFragment"

    // $ANTLR start "RelationDef"
    public final void mRelationDef() throws RecognitionException {
        try {
            int _type = RelationDef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:144:12: ( 'relation' )
            // RelationSchema.g:144:14: 'relation'
            {
            match("relation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RelationDef"

    // $ANTLR start "TreeDef"
    public final void mTreeDef() throws RecognitionException {
        try {
            int _type = TreeDef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:146:8: ( 'tree' )
            // RelationSchema.g:146:10: 'tree'
            {
            match("tree"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TreeDef"

    // $ANTLR start "QName"
    public final void mQName() throws RecognitionException {
        try {
            int _type = QName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RelationSchema.g:149:2: ( NameFragment Colon NameFragment | NameFragment | At NameFragment )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // RelationSchema.g:149:4: NameFragment Colon NameFragment
                    {
                    mNameFragment(); 
                    mColon(); 
                    mNameFragment(); 

                    }
                    break;
                case 2 :
                    // RelationSchema.g:150:4: NameFragment
                    {
                    mNameFragment(); 

                    }
                    break;
                case 3 :
                    // RelationSchema.g:151:4: At NameFragment
                    {
                    mAt(); 
                    mNameFragment(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QName"

    public void mTokens() throws RecognitionException {
        // RelationSchema.g:1:8: ( ML_COMMENT | LINE_COMMENT | NEWLINE | LParen | RParen | LBracket | RBracket | Comma | Equal | Plus | Star | Question | Digits | WhiteSpaceChar | StringLiteral | RelationDef | TreeDef | QName )
        int alt11=18;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // RelationSchema.g:1:10: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 2 :
                // RelationSchema.g:1:21: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 3 :
                // RelationSchema.g:1:34: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 4 :
                // RelationSchema.g:1:42: LParen
                {
                mLParen(); 

                }
                break;
            case 5 :
                // RelationSchema.g:1:49: RParen
                {
                mRParen(); 

                }
                break;
            case 6 :
                // RelationSchema.g:1:56: LBracket
                {
                mLBracket(); 

                }
                break;
            case 7 :
                // RelationSchema.g:1:65: RBracket
                {
                mRBracket(); 

                }
                break;
            case 8 :
                // RelationSchema.g:1:74: Comma
                {
                mComma(); 

                }
                break;
            case 9 :
                // RelationSchema.g:1:80: Equal
                {
                mEqual(); 

                }
                break;
            case 10 :
                // RelationSchema.g:1:86: Plus
                {
                mPlus(); 

                }
                break;
            case 11 :
                // RelationSchema.g:1:91: Star
                {
                mStar(); 

                }
                break;
            case 12 :
                // RelationSchema.g:1:96: Question
                {
                mQuestion(); 

                }
                break;
            case 13 :
                // RelationSchema.g:1:105: Digits
                {
                mDigits(); 

                }
                break;
            case 14 :
                // RelationSchema.g:1:112: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 15 :
                // RelationSchema.g:1:127: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 16 :
                // RelationSchema.g:1:141: RelationDef
                {
                mRelationDef(); 

                }
                break;
            case 17 :
                // RelationSchema.g:1:153: TreeDef
                {
                mTreeDef(); 

                }
                break;
            case 18 :
                // RelationSchema.g:1:161: QName
                {
                mQName(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA10_eotS =
        "\1\uffff\1\4\1\uffff\1\4\2\uffff";
    static final String DFA10_eofS =
        "\6\uffff";
    static final String DFA10_minS =
        "\1\100\1\55\1\uffff\1\55\2\uffff";
    static final String DFA10_maxS =
        "\2\172\1\uffff\1\172\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA10_specialS =
        "\6\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\32\1\4\uffff\1\1\1\uffff\32\1",
            "\1\3\2\uffff\12\3\1\5\6\uffff\32\3\4\uffff\1\3\1\uffff\32"+
            "\3",
            "",
            "\1\3\2\uffff\12\3\1\5\6\uffff\32\3\4\uffff\1\3\1\uffff\32"+
            "\3",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "148:1: QName : ( NameFragment Colon NameFragment | NameFragment | At NameFragment );";
        }
    }
    static final String DFA11_eotS =
        "\2\uffff\1\16\1\25\14\uffff\2\22\4\uffff\5\22\1\35\1\22\1\uffff"+
        "\2\22\1\41\1\uffff";
    static final String DFA11_eofS =
        "\42\uffff";
    static final String DFA11_minS =
        "\1\11\1\52\1\12\1\11\14\uffff\1\145\1\162\4\uffff\1\154\1\145\1"+
        "\141\1\145\1\164\1\55\1\151\1\uffff\1\157\1\156\1\55\1\uffff";
    static final String DFA11_maxS =
        "\1\172\1\57\1\12\1\40\14\uffff\1\145\1\162\4\uffff\1\154\1\145"+
        "\1\141\1\145\1\164\1\172\1\151\1\uffff\1\157\1\156\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
        "\2\uffff\1\22\1\1\1\2\1\3\7\uffff\1\21\3\uffff\1\20";
    static final String DFA11_specialS =
        "\1\uffff\1\0\40\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\16\1\3\1\uffff\1\16\1\2\22\uffff\1\16\1\uffff\1\17\4\uffff"+
            "\1\17\1\4\1\5\1\13\1\12\1\10\2\uffff\1\1\12\15\3\uffff\1\11"+
            "\1\uffff\1\14\33\22\1\6\1\uffff\1\7\1\uffff\1\22\1\uffff\21"+
            "\22\1\20\1\22\1\21\6\22",
            "\1\23\4\uffff\1\24",
            "\1\3",
            "\2\16\1\uffff\2\16\22\uffff\1\16",
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
            "\1\26",
            "\1\27",
            "",
            "",
            "",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\22\2\uffff\13\22\6\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\36",
            "",
            "\1\37",
            "\1\40",
            "\1\22\2\uffff\13\22\6\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ML_COMMENT | LINE_COMMENT | NEWLINE | LParen | RParen | LBracket | RBracket | Comma | Equal | Plus | Star | Question | Digits | WhiteSpaceChar | StringLiteral | RelationDef | TreeDef | QName );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_1=='*') ) {s = 19;}

                        else if ( (LA11_1=='/') && ((getCharPositionInLine()==0))) {s = 20;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
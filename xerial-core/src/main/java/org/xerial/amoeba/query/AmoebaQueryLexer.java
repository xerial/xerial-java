// $ANTLR 3.0.1 AmoebaQuery.g 2007-09-13 13:36:49

/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// Xerial -- Transactional XML Database System      
// 
// AmoebaQueryLexer.java
// Since  2005/10/27 23:17:42
// 
//--------------------------------------------------

package org.xerial.amoeba.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AmoebaQueryLexer extends Lexer {
    public static final int FUNCTION=11;
    public static final int Insert=49;
    public static final int Apos=36;
    public static final int Wildcard=38;
    public static final int ATTRIBUTE=18;
    public static final int INPUT=14;
    public static final int Where=47;
    public static final int UPDATE=27;
    public static final int CONDITION=7;
    public static final int Into=50;
    public static final int AND=12;
    public static final int EOF=-1;
    public static final int SELECTION=6;
    public static final int T62=62;
    public static final int T63=63;
    public static final int ML_COMMENT=28;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int GREATER=43;
    public static final int ASSIGN_LABEL=16;
    public static final int INSERT=23;
    public static final int Digits=53;
    public static final int CONTAINED_IN=21;
    public static final int NOT_EQUAL=40;
    public static final int WhiteSpaceChar=55;
    public static final int NEW_VALUE=25;
    public static final int EQUAL=39;
    public static final int LESS=41;
    public static final int COMPARE=17;
    public static final int Select=45;
    public static final int GEQ=44;
    public static final int VALUE_SET=24;
    public static final int NEW_RELATION=26;
    public static final int Quot=35;
    public static final int T61=61;
    public static final int T60=60;
    public static final int PROJECT_ALL=9;
    public static final int RParen=33;
    public static final int In=48;
    public static final int QName=58;
    public static final int At=37;
    public static final int LParen=34;
    public static final int LINE_COMMENT=29;
    public static final int NUMBER=4;
    public static final int NameChar=54;
    public static final int RELATION=22;
    public static final int Colon=31;
    public static final int TARGET=10;
    public static final int VALUE=20;
    public static final int Digit=52;
    public static final int Tokens=67;
    public static final int REF=19;
    public static final int From=46;
    public static final int StringLiteral=56;
    public static final int OR=13;
    public static final int Dot=30;
    public static final int Name=57;
    public static final int T59=59;
    public static final int PROJECTION=8;
    public static final int Comma=32;
    public static final int OUTPUT=15;
    public static final int Letter=51;
    public static final int STRING=5;
    public static final int LEQ=42;
    public AmoebaQueryLexer() {;} 
    public AmoebaQueryLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "AmoebaQuery.g"; }

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // AmoebaQuery.g:33:5: ( 'update' )
            // AmoebaQuery.g:33:7: 'update'
            {
            match("update"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // AmoebaQuery.g:34:5: ( 'set' )
            // AmoebaQuery.g:34:7: 'set'
            {
            match("set"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // AmoebaQuery.g:35:5: ( '{' )
            // AmoebaQuery.g:35:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // AmoebaQuery.g:36:5: ( '}' )
            // AmoebaQuery.g:36:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // AmoebaQuery.g:37:5: ( 'as' )
            // AmoebaQuery.g:37:7: 'as'
            {
            match("as"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // AmoebaQuery.g:38:5: ( 'or' )
            // AmoebaQuery.g:38:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // AmoebaQuery.g:39:5: ( 'and' )
            // AmoebaQuery.g:39:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // AmoebaQuery.g:40:5: ( 'like' )
            // AmoebaQuery.g:40:7: 'like'
            {
            match("like"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // AmoebaQuery.g:129:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // AmoebaQuery.g:129:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // AmoebaQuery.g:129:14: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFE')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // AmoebaQuery.g:129:41: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            // AmoebaQuery.g:133:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // AmoebaQuery.g:133:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // AmoebaQuery.g:133:12: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // AmoebaQuery.g:133:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // AmoebaQuery.g:133:26: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // AmoebaQuery.g:133:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    // $ANTLR start Dot
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            // AmoebaQuery.g:136:4: ( '.' )
            // AmoebaQuery.g:136:6: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Dot

    // $ANTLR start Colon
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            // AmoebaQuery.g:137:6: ( ';' )
            // AmoebaQuery.g:137:8: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Colon

    // $ANTLR start Comma
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            // AmoebaQuery.g:138:6: ( ',' )
            // AmoebaQuery.g:138:8: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Comma

    // $ANTLR start RParen
    public final void mRParen() throws RecognitionException {
        try {
            int _type = RParen;
            // AmoebaQuery.g:139:7: ( ')' )
            // AmoebaQuery.g:139:9: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RParen

    // $ANTLR start LParen
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            // AmoebaQuery.g:140:7: ( '(' )
            // AmoebaQuery.g:140:9: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LParen

    // $ANTLR start Quot
    public final void mQuot() throws RecognitionException {
        try {
            // AmoebaQuery.g:141:14: ( '\"' )
            // AmoebaQuery.g:141:16: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Quot

    // $ANTLR start Apos
    public final void mApos() throws RecognitionException {
        try {
            // AmoebaQuery.g:142:14: ( '\\'' )
            // AmoebaQuery.g:142:16: '\\''
            {
            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Apos

    // $ANTLR start At
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            // AmoebaQuery.g:143:3: ( '@' )
            // AmoebaQuery.g:143:5: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end At

    // $ANTLR start Wildcard
    public final void mWildcard() throws RecognitionException {
        try {
            int _type = Wildcard;
            // AmoebaQuery.g:144:10: ( '*' )
            // AmoebaQuery.g:144:12: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Wildcard

    // $ANTLR start EQUAL
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            // AmoebaQuery.g:145:7: ( '=' )
            // AmoebaQuery.g:145:9: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUAL

    // $ANTLR start NOT_EQUAL
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            // AmoebaQuery.g:146:11: ( '!=' )
            // AmoebaQuery.g:146:13: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT_EQUAL

    // $ANTLR start LESS
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            // AmoebaQuery.g:147:6: ( '<' )
            // AmoebaQuery.g:147:8: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESS

    // $ANTLR start LEQ
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            // AmoebaQuery.g:148:6: ( '<=' )
            // AmoebaQuery.g:148:8: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEQ

    // $ANTLR start GREATER
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            // AmoebaQuery.g:149:9: ( '>' )
            // AmoebaQuery.g:149:11: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATER

    // $ANTLR start GEQ
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            // AmoebaQuery.g:150:5: ( '>=' )
            // AmoebaQuery.g:150:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GEQ

    // $ANTLR start Select
    public final void mSelect() throws RecognitionException {
        try {
            int _type = Select;
            // AmoebaQuery.g:153:7: ( 'select' | 'SELECT' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='s') ) {
                alt4=1;
            }
            else if ( (LA4_0=='S') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("153:1: Select : ( 'select' | 'SELECT' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // AmoebaQuery.g:153:9: 'select'
                    {
                    match("select"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:153:20: 'SELECT'
                    {
                    match("SELECT"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Select

    // $ANTLR start From
    public final void mFrom() throws RecognitionException {
        try {
            int _type = From;
            // AmoebaQuery.g:154:5: ( 'from' | 'FROM' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='f') ) {
                alt5=1;
            }
            else if ( (LA5_0=='F') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("154:1: From : ( 'from' | 'FROM' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // AmoebaQuery.g:154:7: 'from'
                    {
                    match("from"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:154:16: 'FROM'
                    {
                    match("FROM"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end From

    // $ANTLR start Where
    public final void mWhere() throws RecognitionException {
        try {
            int _type = Where;
            // AmoebaQuery.g:155:6: ( 'where' | 'WHERE' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='w') ) {
                alt6=1;
            }
            else if ( (LA6_0=='W') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("155:1: Where : ( 'where' | 'WHERE' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // AmoebaQuery.g:155:8: 'where'
                    {
                    match("where"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:155:18: 'WHERE'
                    {
                    match("WHERE"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Where

    // $ANTLR start In
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            // AmoebaQuery.g:156:3: ( 'in' | 'IN' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='i') ) {
                alt7=1;
            }
            else if ( (LA7_0=='I') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("156:1: In : ( 'in' | 'IN' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // AmoebaQuery.g:156:5: 'in'
                    {
                    match("in"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:156:12: 'IN'
                    {
                    match("IN"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end In

    // $ANTLR start Insert
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            // AmoebaQuery.g:157:7: ( 'insert' | 'INSERT' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='i') ) {
                alt8=1;
            }
            else if ( (LA8_0=='I') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("157:1: Insert : ( 'insert' | 'INSERT' );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // AmoebaQuery.g:157:9: 'insert'
                    {
                    match("insert"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:157:20: 'INSERT'
                    {
                    match("INSERT"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Insert

    // $ANTLR start Into
    public final void mInto() throws RecognitionException {
        try {
            int _type = Into;
            // AmoebaQuery.g:158:5: ( 'into' | 'INTO' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='i') ) {
                alt9=1;
            }
            else if ( (LA9_0=='I') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("158:1: Into : ( 'into' | 'INTO' );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // AmoebaQuery.g:158:7: 'into'
                    {
                    match("into"); 


                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:158:16: 'INTO'
                    {
                    match("INTO"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Into

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // AmoebaQuery.g:162:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // AmoebaQuery.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start Digit
    public final void mDigit() throws RecognitionException {
        try {
            // AmoebaQuery.g:163:15: ( '0' .. '9' )
            // AmoebaQuery.g:163:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Digit

    // $ANTLR start Digits
    public final void mDigits() throws RecognitionException {
        try {
            int _type = Digits;
            // AmoebaQuery.g:164:7: ( ( Digit )+ )
            // AmoebaQuery.g:164:9: ( Digit )+
            {
            // AmoebaQuery.g:164:9: ( Digit )+
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
            	    // AmoebaQuery.g:164:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Digits

    // $ANTLR start NameChar
    public final void mNameChar() throws RecognitionException {
        try {
            // AmoebaQuery.g:166:18: ( Letter | Digit | '_' | '-' | At )
            // AmoebaQuery.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end NameChar

    // $ANTLR start WhiteSpaceChar
    public final void mWhiteSpaceChar() throws RecognitionException {
        try {
            int _type = WhiteSpaceChar;
            // AmoebaQuery.g:168:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // AmoebaQuery.g:168:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // AmoebaQuery.g:168:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||(LA11_0>='\f' && LA11_0<='\r')||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // AmoebaQuery.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WhiteSpaceChar

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // AmoebaQuery.g:171:1: ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("170:1: StringLiteral : ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // AmoebaQuery.g:171:3: Quot (~ '\"' )* Quot
                    {
                    mQuot(); 
                    // AmoebaQuery.g:171:9: (~ '\"' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='\uFFFE')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // AmoebaQuery.g:171:10: ~ '\"'
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    mQuot(); 

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:172:3: Apos (~ '\\'' )* Apos
                    {
                    mApos(); 
                    // AmoebaQuery.g:172:9: (~ '\\'' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='\uFFFE')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // AmoebaQuery.g:172:10: ~ '\\''
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    mApos(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start Name
    public final void mName() throws RecognitionException {
        try {
            // AmoebaQuery.g:176:14: ( ( Letter | '_' ) ( NameChar )* )
            // AmoebaQuery.g:176:16: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // AmoebaQuery.g:176:31: ( NameChar )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='-'||(LA15_0>='0' && LA15_0<='9')||(LA15_0>='@' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // AmoebaQuery.g:176:31: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end Name

    // $ANTLR start QName
    public final void mQName() throws RecognitionException {
        try {
            int _type = QName;
            // AmoebaQuery.g:179:2: ( Name Colon Name | Name )
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // AmoebaQuery.g:179:4: Name Colon Name
                    {
                    mName(); 
                    mColon(); 
                    mName(); 

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:180:4: Name
                    {
                    mName(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QName

    public void mTokens() throws RecognitionException {
        // AmoebaQuery.g:1:8: ( T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | ML_COMMENT | LINE_COMMENT | Dot | Colon | Comma | RParen | LParen | At | Wildcard | EQUAL | NOT_EQUAL | LESS | LEQ | GREATER | GEQ | Select | From | Where | In | Insert | Into | Digits | WhiteSpaceChar | StringLiteral | QName )
        int alt17=33;
        switch ( input.LA(1) ) {
        case 'u':
            {
            int LA17_1 = input.LA(2);

            if ( (LA17_1=='p') ) {
                int LA17_31 = input.LA(3);

                if ( (LA17_31=='d') ) {
                    int LA17_50 = input.LA(4);

                    if ( (LA17_50=='a') ) {
                        int LA17_67 = input.LA(5);

                        if ( (LA17_67=='t') ) {
                            int LA17_81 = input.LA(6);

                            if ( (LA17_81=='e') ) {
                                int LA17_91 = input.LA(7);

                                if ( (LA17_91=='-'||(LA17_91>='0' && LA17_91<='9')||LA17_91==';'||(LA17_91>='@' && LA17_91<='Z')||LA17_91=='_'||(LA17_91>='a' && LA17_91<='z')) ) {
                                    alt17=33;
                                }
                                else {
                                    alt17=1;}
                            }
                            else {
                                alt17=33;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 's':
            {
            int LA17_2 = input.LA(2);

            if ( (LA17_2=='e') ) {
                switch ( input.LA(3) ) {
                case 'l':
                    {
                    int LA17_51 = input.LA(4);

                    if ( (LA17_51=='e') ) {
                        int LA17_68 = input.LA(5);

                        if ( (LA17_68=='c') ) {
                            int LA17_82 = input.LA(6);

                            if ( (LA17_82=='t') ) {
                                int LA17_92 = input.LA(7);

                                if ( (LA17_92=='-'||(LA17_92>='0' && LA17_92<='9')||LA17_92==';'||(LA17_92>='@' && LA17_92<='Z')||LA17_92=='_'||(LA17_92>='a' && LA17_92<='z')) ) {
                                    alt17=33;
                                }
                                else {
                                    alt17=24;}
                            }
                            else {
                                alt17=33;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                    }
                    break;
                case 't':
                    {
                    int LA17_52 = input.LA(4);

                    if ( (LA17_52=='-'||(LA17_52>='0' && LA17_52<='9')||LA17_52==';'||(LA17_52>='@' && LA17_52<='Z')||LA17_52=='_'||(LA17_52>='a' && LA17_52<='z')) ) {
                        alt17=33;
                    }
                    else {
                        alt17=2;}
                    }
                    break;
                default:
                    alt17=33;}

            }
            else {
                alt17=33;}
            }
            break;
        case '{':
            {
            alt17=3;
            }
            break;
        case '}':
            {
            alt17=4;
            }
            break;
        case 'a':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA17_33 = input.LA(3);

                if ( (LA17_33=='d') ) {
                    int LA17_53 = input.LA(4);

                    if ( (LA17_53=='-'||(LA17_53>='0' && LA17_53<='9')||LA17_53==';'||(LA17_53>='@' && LA17_53<='Z')||LA17_53=='_'||(LA17_53>='a' && LA17_53<='z')) ) {
                        alt17=33;
                    }
                    else {
                        alt17=7;}
                }
                else {
                    alt17=33;}
                }
                break;
            case 's':
                {
                int LA17_34 = input.LA(3);

                if ( (LA17_34=='-'||(LA17_34>='0' && LA17_34<='9')||LA17_34==';'||(LA17_34>='@' && LA17_34<='Z')||LA17_34=='_'||(LA17_34>='a' && LA17_34<='z')) ) {
                    alt17=33;
                }
                else {
                    alt17=5;}
                }
                break;
            default:
                alt17=33;}

            }
            break;
        case 'o':
            {
            int LA17_6 = input.LA(2);

            if ( (LA17_6=='r') ) {
                int LA17_35 = input.LA(3);

                if ( (LA17_35=='-'||(LA17_35>='0' && LA17_35<='9')||LA17_35==';'||(LA17_35>='@' && LA17_35<='Z')||LA17_35=='_'||(LA17_35>='a' && LA17_35<='z')) ) {
                    alt17=33;
                }
                else {
                    alt17=6;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'l':
            {
            int LA17_7 = input.LA(2);

            if ( (LA17_7=='i') ) {
                int LA17_36 = input.LA(3);

                if ( (LA17_36=='k') ) {
                    int LA17_56 = input.LA(4);

                    if ( (LA17_56=='e') ) {
                        int LA17_71 = input.LA(5);

                        if ( (LA17_71=='-'||(LA17_71>='0' && LA17_71<='9')||LA17_71==';'||(LA17_71>='@' && LA17_71<='Z')||LA17_71=='_'||(LA17_71>='a' && LA17_71<='z')) ) {
                            alt17=33;
                        }
                        else {
                            alt17=8;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case '/':
            {
            int LA17_8 = input.LA(2);

            if ( (LA17_8=='/') ) {
                alt17=10;
            }
            else if ( (LA17_8=='*') ) {
                alt17=9;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | ML_COMMENT | LINE_COMMENT | Dot | Colon | Comma | RParen | LParen | At | Wildcard | EQUAL | NOT_EQUAL | LESS | LEQ | GREATER | GEQ | Select | From | Where | In | Insert | Into | Digits | WhiteSpaceChar | StringLiteral | QName );", 17, 8, input);

                throw nvae;
            }
            }
            break;
        case '.':
            {
            alt17=11;
            }
            break;
        case ';':
            {
            alt17=12;
            }
            break;
        case ',':
            {
            alt17=13;
            }
            break;
        case ')':
            {
            alt17=14;
            }
            break;
        case '(':
            {
            alt17=15;
            }
            break;
        case '@':
            {
            alt17=16;
            }
            break;
        case '*':
            {
            alt17=17;
            }
            break;
        case '=':
            {
            alt17=18;
            }
            break;
        case '!':
            {
            alt17=19;
            }
            break;
        case '<':
            {
            int LA17_18 = input.LA(2);

            if ( (LA17_18=='=') ) {
                alt17=21;
            }
            else {
                alt17=20;}
            }
            break;
        case '>':
            {
            int LA17_19 = input.LA(2);

            if ( (LA17_19=='=') ) {
                alt17=23;
            }
            else {
                alt17=22;}
            }
            break;
        case 'S':
            {
            int LA17_20 = input.LA(2);

            if ( (LA17_20=='E') ) {
                int LA17_43 = input.LA(3);

                if ( (LA17_43=='L') ) {
                    int LA17_57 = input.LA(4);

                    if ( (LA17_57=='E') ) {
                        int LA17_72 = input.LA(5);

                        if ( (LA17_72=='C') ) {
                            int LA17_84 = input.LA(6);

                            if ( (LA17_84=='T') ) {
                                int LA17_93 = input.LA(7);

                                if ( (LA17_93=='-'||(LA17_93>='0' && LA17_93<='9')||LA17_93==';'||(LA17_93>='@' && LA17_93<='Z')||LA17_93=='_'||(LA17_93>='a' && LA17_93<='z')) ) {
                                    alt17=33;
                                }
                                else {
                                    alt17=24;}
                            }
                            else {
                                alt17=33;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'f':
            {
            int LA17_21 = input.LA(2);

            if ( (LA17_21=='r') ) {
                int LA17_44 = input.LA(3);

                if ( (LA17_44=='o') ) {
                    int LA17_58 = input.LA(4);

                    if ( (LA17_58=='m') ) {
                        int LA17_73 = input.LA(5);

                        if ( (LA17_73=='-'||(LA17_73>='0' && LA17_73<='9')||LA17_73==';'||(LA17_73>='@' && LA17_73<='Z')||LA17_73=='_'||(LA17_73>='a' && LA17_73<='z')) ) {
                            alt17=33;
                        }
                        else {
                            alt17=25;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'F':
            {
            int LA17_22 = input.LA(2);

            if ( (LA17_22=='R') ) {
                int LA17_45 = input.LA(3);

                if ( (LA17_45=='O') ) {
                    int LA17_59 = input.LA(4);

                    if ( (LA17_59=='M') ) {
                        int LA17_74 = input.LA(5);

                        if ( (LA17_74=='-'||(LA17_74>='0' && LA17_74<='9')||LA17_74==';'||(LA17_74>='@' && LA17_74<='Z')||LA17_74=='_'||(LA17_74>='a' && LA17_74<='z')) ) {
                            alt17=33;
                        }
                        else {
                            alt17=25;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'w':
            {
            int LA17_23 = input.LA(2);

            if ( (LA17_23=='h') ) {
                int LA17_46 = input.LA(3);

                if ( (LA17_46=='e') ) {
                    int LA17_60 = input.LA(4);

                    if ( (LA17_60=='r') ) {
                        int LA17_75 = input.LA(5);

                        if ( (LA17_75=='e') ) {
                            int LA17_86 = input.LA(6);

                            if ( (LA17_86=='-'||(LA17_86>='0' && LA17_86<='9')||LA17_86==';'||(LA17_86>='@' && LA17_86<='Z')||LA17_86=='_'||(LA17_86>='a' && LA17_86<='z')) ) {
                                alt17=33;
                            }
                            else {
                                alt17=26;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'W':
            {
            int LA17_24 = input.LA(2);

            if ( (LA17_24=='H') ) {
                int LA17_47 = input.LA(3);

                if ( (LA17_47=='E') ) {
                    int LA17_61 = input.LA(4);

                    if ( (LA17_61=='R') ) {
                        int LA17_76 = input.LA(5);

                        if ( (LA17_76=='E') ) {
                            int LA17_87 = input.LA(6);

                            if ( (LA17_87=='-'||(LA17_87>='0' && LA17_87<='9')||LA17_87==';'||(LA17_87>='@' && LA17_87<='Z')||LA17_87=='_'||(LA17_87>='a' && LA17_87<='z')) ) {
                                alt17=33;
                            }
                            else {
                                alt17=26;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                }
                else {
                    alt17=33;}
            }
            else {
                alt17=33;}
            }
            break;
        case 'i':
            {
            int LA17_25 = input.LA(2);

            if ( (LA17_25=='n') ) {
                switch ( input.LA(3) ) {
                case 's':
                    {
                    int LA17_62 = input.LA(4);

                    if ( (LA17_62=='e') ) {
                        int LA17_77 = input.LA(5);

                        if ( (LA17_77=='r') ) {
                            int LA17_88 = input.LA(6);

                            if ( (LA17_88=='t') ) {
                                int LA17_95 = input.LA(7);

                                if ( (LA17_95=='-'||(LA17_95>='0' && LA17_95<='9')||LA17_95==';'||(LA17_95>='@' && LA17_95<='Z')||LA17_95=='_'||(LA17_95>='a' && LA17_95<='z')) ) {
                                    alt17=33;
                                }
                                else {
                                    alt17=28;}
                            }
                            else {
                                alt17=33;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                    }
                    break;
                case 't':
                    {
                    int LA17_63 = input.LA(4);

                    if ( (LA17_63=='o') ) {
                        int LA17_78 = input.LA(5);

                        if ( (LA17_78=='-'||(LA17_78>='0' && LA17_78<='9')||LA17_78==';'||(LA17_78>='@' && LA17_78<='Z')||LA17_78=='_'||(LA17_78>='a' && LA17_78<='z')) ) {
                            alt17=33;
                        }
                        else {
                            alt17=29;}
                    }
                    else {
                        alt17=33;}
                    }
                    break;
                case '-':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case ';':
                case '@':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt17=33;
                    }
                    break;
                default:
                    alt17=27;}

            }
            else {
                alt17=33;}
            }
            break;
        case 'I':
            {
            int LA17_26 = input.LA(2);

            if ( (LA17_26=='N') ) {
                switch ( input.LA(3) ) {
                case 'S':
                    {
                    int LA17_65 = input.LA(4);

                    if ( (LA17_65=='E') ) {
                        int LA17_79 = input.LA(5);

                        if ( (LA17_79=='R') ) {
                            int LA17_90 = input.LA(6);

                            if ( (LA17_90=='T') ) {
                                int LA17_96 = input.LA(7);

                                if ( (LA17_96=='-'||(LA17_96>='0' && LA17_96<='9')||LA17_96==';'||(LA17_96>='@' && LA17_96<='Z')||LA17_96=='_'||(LA17_96>='a' && LA17_96<='z')) ) {
                                    alt17=33;
                                }
                                else {
                                    alt17=28;}
                            }
                            else {
                                alt17=33;}
                        }
                        else {
                            alt17=33;}
                    }
                    else {
                        alt17=33;}
                    }
                    break;
                case 'T':
                    {
                    int LA17_66 = input.LA(4);

                    if ( (LA17_66=='O') ) {
                        int LA17_80 = input.LA(5);

                        if ( (LA17_80=='-'||(LA17_80>='0' && LA17_80<='9')||LA17_80==';'||(LA17_80>='@' && LA17_80<='Z')||LA17_80=='_'||(LA17_80>='a' && LA17_80<='z')) ) {
                            alt17=33;
                        }
                        else {
                            alt17=29;}
                    }
                    else {
                        alt17=33;}
                    }
                    break;
                case '-':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case ';':
                case '@':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt17=33;
                    }
                    break;
                default:
                    alt17=27;}

            }
            else {
                alt17=33;}
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt17=30;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt17=31;
            }
            break;
        case '\"':
        case '\'':
            {
            alt17=32;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'G':
        case 'H':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'm':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 't':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt17=33;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | ML_COMMENT | LINE_COMMENT | Dot | Colon | Comma | RParen | LParen | At | Wildcard | EQUAL | NOT_EQUAL | LESS | LEQ | GREATER | GEQ | Select | From | Where | In | Insert | Into | Digits | WhiteSpaceChar | StringLiteral | QName );", 17, 0, input);

            throw nvae;
        }

        switch (alt17) {
            case 1 :
                // AmoebaQuery.g:1:10: T59
                {
                mT59(); 

                }
                break;
            case 2 :
                // AmoebaQuery.g:1:14: T60
                {
                mT60(); 

                }
                break;
            case 3 :
                // AmoebaQuery.g:1:18: T61
                {
                mT61(); 

                }
                break;
            case 4 :
                // AmoebaQuery.g:1:22: T62
                {
                mT62(); 

                }
                break;
            case 5 :
                // AmoebaQuery.g:1:26: T63
                {
                mT63(); 

                }
                break;
            case 6 :
                // AmoebaQuery.g:1:30: T64
                {
                mT64(); 

                }
                break;
            case 7 :
                // AmoebaQuery.g:1:34: T65
                {
                mT65(); 

                }
                break;
            case 8 :
                // AmoebaQuery.g:1:38: T66
                {
                mT66(); 

                }
                break;
            case 9 :
                // AmoebaQuery.g:1:42: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 10 :
                // AmoebaQuery.g:1:53: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 11 :
                // AmoebaQuery.g:1:66: Dot
                {
                mDot(); 

                }
                break;
            case 12 :
                // AmoebaQuery.g:1:70: Colon
                {
                mColon(); 

                }
                break;
            case 13 :
                // AmoebaQuery.g:1:76: Comma
                {
                mComma(); 

                }
                break;
            case 14 :
                // AmoebaQuery.g:1:82: RParen
                {
                mRParen(); 

                }
                break;
            case 15 :
                // AmoebaQuery.g:1:89: LParen
                {
                mLParen(); 

                }
                break;
            case 16 :
                // AmoebaQuery.g:1:96: At
                {
                mAt(); 

                }
                break;
            case 17 :
                // AmoebaQuery.g:1:99: Wildcard
                {
                mWildcard(); 

                }
                break;
            case 18 :
                // AmoebaQuery.g:1:108: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 19 :
                // AmoebaQuery.g:1:114: NOT_EQUAL
                {
                mNOT_EQUAL(); 

                }
                break;
            case 20 :
                // AmoebaQuery.g:1:124: LESS
                {
                mLESS(); 

                }
                break;
            case 21 :
                // AmoebaQuery.g:1:129: LEQ
                {
                mLEQ(); 

                }
                break;
            case 22 :
                // AmoebaQuery.g:1:133: GREATER
                {
                mGREATER(); 

                }
                break;
            case 23 :
                // AmoebaQuery.g:1:141: GEQ
                {
                mGEQ(); 

                }
                break;
            case 24 :
                // AmoebaQuery.g:1:145: Select
                {
                mSelect(); 

                }
                break;
            case 25 :
                // AmoebaQuery.g:1:152: From
                {
                mFrom(); 

                }
                break;
            case 26 :
                // AmoebaQuery.g:1:157: Where
                {
                mWhere(); 

                }
                break;
            case 27 :
                // AmoebaQuery.g:1:163: In
                {
                mIn(); 

                }
                break;
            case 28 :
                // AmoebaQuery.g:1:166: Insert
                {
                mInsert(); 

                }
                break;
            case 29 :
                // AmoebaQuery.g:1:173: Into
                {
                mInto(); 

                }
                break;
            case 30 :
                // AmoebaQuery.g:1:178: Digits
                {
                mDigits(); 

                }
                break;
            case 31 :
                // AmoebaQuery.g:1:185: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 32 :
                // AmoebaQuery.g:1:200: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 33 :
                // AmoebaQuery.g:1:214: QName
                {
                mQName(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\2\3\2\uffff";
    static final String DFA16_eofS =
        "\5\uffff";
    static final String DFA16_minS =
        "\1\101\2\55\2\uffff";
    static final String DFA16_maxS =
        "\3\172\2\uffff";
    static final String DFA16_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA16_specialS =
        "\5\uffff}>";
    static final String[] DFA16_transitionS = {
            "\32\1\4\uffff\1\1\1\uffff\32\1",
            "\1\2\2\uffff\12\2\1\uffff\1\4\4\uffff\33\2\4\uffff\1\2\1\uffff"+
            "\32\2",
            "\1\2\2\uffff\12\2\1\uffff\1\4\4\uffff\33\2\4\uffff\1\2\1\uffff"+
            "\32\2",
            "",
            ""
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
            return "178:1: QName : ( Name Colon Name | Name );";
        }
    }
 

}
// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g 2009-02-22 13:02:54

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

package org.xerial.amoeba.query.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AmoebaQueryLexer extends Lexer {
    public static final int DataType=68;
    public static final int OUTPUT=17;
    public static final int T__86=86;
    public static final int INPUT=16;
    public static final int LANG=36;
    public static final int Quot_s=74;
    public static final int Apos=45;
    public static final int Digit=70;
    public static final int Relationship=62;
    public static final int T__80=80;
    public static final int TARGET=12;
    public static final int NUMBER=4;
    public static final int LEQ=51;
    public static final int VALUE_SET=26;
    public static final int REF=21;
    public static final int PROJECT_ALL=9;
    public static final int GEQ=53;
    public static final int VALUE=22;
    public static final int OR=15;
    public static final int T__87=87;
    public static final int Letter=69;
    public static final int DIVIDE=65;
    public static final int AND=14;
    public static final int Insert=59;
    public static final int LESS=50;
    public static final int Comma=41;
    public static final int FUNCTION=13;
    public static final int Dot=39;
    public static final int Into=60;
    public static final int Object=61;
    public static final int CONDITION=7;
    public static final int ATTRIBUTE_DEF=30;
    public static final int ONE_TO_ONE=33;
    public static final int OBJECT_DEF=34;
    public static final int GREATER=52;
    public static final int HasMany=63;
    public static final int ML_COMMENT=37;
    public static final int Colon=40;
    public static final int NEW_VALUE=27;
    public static final int At=46;
    public static final int NOT_EQUAL=49;
    public static final int OBJECT=35;
    public static final int DISTINCT=66;
    public static final int RANGE=67;
    public static final int NameChar=72;
    public static final int CONTAINED_IN=23;
    public static final int T__89=89;
    public static final int SPLIT=54;
    public static final int ORDER_BY=10;
    public static final int Wildcard=47;
    public static final int T__79=79;
    public static final int STRING=5;
    public static final int NEW_RELATION=28;
    public static final int Where=57;
    public static final int RELATION=24;
    public static final int UPDATE=29;
    public static final int RParen=42;
    public static final int Apos_s=75;
    public static final int StringLiteral=76;
    public static final int T__88=88;
    public static final int LINE_COMMENT=38;
    public static final int In=58;
    public static final int Name=77;
    public static final int LParen=43;
    public static final int T__84=84;
    public static final int T__90=90;
    public static final int From=56;
    public static final int HasOne=64;
    public static final int Select=55;
    public static final int EQUAL=48;
    public static final int COMPARE=19;
    public static final int REF_ALL=11;
    public static final int ONE_TO_MANY=32;
    public static final int QName=78;
    public static final int SELECTION=6;
    public static final int WhiteSpaceChar=73;
    public static final int EOF=-1;
    public static final int T__85=85;
    public static final int T__82=82;
    public static final int T__81=81;
    public static final int PROJECTION=8;
    public static final int ATTRIBUTE=20;
    public static final int Quot=44;
    public static final int T__83=83;
    public static final int SORT_TARGET=31;
    public static final int INSERT=25;
    public static final int Digits=71;
    public static final int ASSIGN_LABEL=18;

    // delegates
    // delegators

    public AmoebaQueryLexer() {;} 
    public AmoebaQueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AmoebaQueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g"; }

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:34:7: ( 'by' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:34:9: 'by'
            {
            match("by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:35:7: ( 'auto' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:35:9: 'auto'
            {
            match("auto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:36:7: ( 'AUTO' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:36:9: 'AUTO'
            {
            match("AUTO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:37:7: ( 'update' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:37:9: 'update'
            {
            match("update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:38:7: ( 'set' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:38:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:39:7: ( '{' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:39:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:40:7: ( '}' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:40:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:41:7: ( 'as' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:41:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:42:7: ( 'order' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:42:9: 'order'
            {
            match("order"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:43:7: ( 'or' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:43:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:44:7: ( 'and' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:44:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:45:7: ( 'like' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:45:9: 'like'
            {
            match("like"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:149:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:149:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:149:14: ( options {greedy=false; } : . )*
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
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:149:41: .
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:12: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:12: ~ ( '\\n' | '\\r' )
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

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:26: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:153:26: '\\r'
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
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:157:4: ( '.' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:157:6: '.'
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:158:6: ( ';' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:158:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:159:6: ( ',' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:159:8: ','
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

    // $ANTLR start "RParen"
    public final void mRParen() throws RecognitionException {
        try {
            int _type = RParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:160:7: ( ')' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:160:9: ')'
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

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:161:7: ( '(' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:161:9: '('
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

    // $ANTLR start "Quot"
    public final void mQuot() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:162:14: ( '\"' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:162:16: '\"'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:163:14: ( '\\'' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:163:16: '\\''
            {
            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Apos"

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:164:3: ( '@' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:164:5: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "At"

    // $ANTLR start "Wildcard"
    public final void mWildcard() throws RecognitionException {
        try {
            int _type = Wildcard;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:165:10: ( '*' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:165:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Wildcard"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:166:7: ( '=' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:166:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:167:11: ( '!=' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:167:13: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:168:6: ( '<' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:168:8: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:169:6: ( '<=' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:169:8: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:170:9: ( '>' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:170:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "GEQ"
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:171:5: ( '>=' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:171:7: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GEQ"

    // $ANTLR start "SPLIT"
    public final void mSPLIT() throws RecognitionException {
        try {
            int _type = SPLIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:172:7: ( '|' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:172:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SPLIT"

    // $ANTLR start "Select"
    public final void mSelect() throws RecognitionException {
        try {
            int _type = Select;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:174:7: ( 'select' | 'SELECT' )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:174:9: 'select'
                    {
                    match("select"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:174:20: 'SELECT'
                    {
                    match("SELECT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Select"

    // $ANTLR start "From"
    public final void mFrom() throws RecognitionException {
        try {
            int _type = From;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:175:5: ( 'from' | 'FROM' )
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
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:175:7: 'from'
                    {
                    match("from"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:175:16: 'FROM'
                    {
                    match("FROM"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "From"

    // $ANTLR start "Where"
    public final void mWhere() throws RecognitionException {
        try {
            int _type = Where;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:176:6: ( 'where' | 'WHERE' )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:176:8: 'where'
                    {
                    match("where"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:176:18: 'WHERE'
                    {
                    match("WHERE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Where"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:177:3: ( 'in' | 'IN' )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:177:5: 'in'
                    {
                    match("in"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:177:12: 'IN'
                    {
                    match("IN"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:178:7: ( 'insert' | 'INSERT' )
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
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:178:9: 'insert'
                    {
                    match("insert"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:178:20: 'INSERT'
                    {
                    match("INSERT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Insert"

    // $ANTLR start "Into"
    public final void mInto() throws RecognitionException {
        try {
            int _type = Into;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:179:5: ( 'into' | 'INTO' )
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
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:179:7: 'into'
                    {
                    match("into"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:179:16: 'INTO'
                    {
                    match("INTO"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Into"

    // $ANTLR start "Object"
    public final void mObject() throws RecognitionException {
        try {
            int _type = Object;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:180:7: ( 'object' | 'OBJECT' | 'Object' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='o') ) {
                alt10=1;
            }
            else if ( (LA10_0=='O') ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2=='B') ) {
                    alt10=2;
                }
                else if ( (LA10_2=='b') ) {
                    alt10=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:180:9: 'object'
                    {
                    match("object"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:180:20: 'OBJECT'
                    {
                    match("OBJECT"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:180:31: 'Object'
                    {
                    match("Object"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Object"

    // $ANTLR start "Relationship"
    public final void mRelationship() throws RecognitionException {
        try {
            int _type = Relationship;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:181:13: ( 'relationship' | 'RELATIONSHIP' | 'Relationship' )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='r') ) {
                alt11=1;
            }
            else if ( (LA11_0=='R') ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2=='E') ) {
                    alt11=2;
                }
                else if ( (LA11_2=='e') ) {
                    alt11=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:181:15: 'relationship'
                    {
                    match("relationship"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:181:32: 'RELATIONSHIP'
                    {
                    match("RELATIONSHIP"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:181:49: 'Relationship'
                    {
                    match("Relationship"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Relationship"

    // $ANTLR start "HasMany"
    public final void mHasMany() throws RecognitionException {
        try {
            int _type = HasMany;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:182:9: ( 'hasmany' | 'HASMANY' | 'HasMany' )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='h') ) {
                alt12=1;
            }
            else if ( (LA12_0=='H') ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2=='A') ) {
                    alt12=2;
                }
                else if ( (LA12_2=='a') ) {
                    alt12=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:182:11: 'hasmany'
                    {
                    match("hasmany"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:182:23: 'HASMANY'
                    {
                    match("HASMANY"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:182:35: 'HasMany'
                    {
                    match("HasMany"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HasMany"

    // $ANTLR start "HasOne"
    public final void mHasOne() throws RecognitionException {
        try {
            int _type = HasOne;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:183:8: ( 'hasone' | 'HASONE' | 'HasOne' )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='h') ) {
                alt13=1;
            }
            else if ( (LA13_0=='H') ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2=='A') ) {
                    alt13=2;
                }
                else if ( (LA13_2=='a') ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:183:10: 'hasone'
                    {
                    match("hasone"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:183:21: 'HASONE'
                    {
                    match("HASONE"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:183:32: 'HasOne'
                    {
                    match("HasOne"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HasOne"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:184:7: ( 'divide' | 'DIVIDE' | 'Divide' )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='d') ) {
                alt14=1;
            }
            else if ( (LA14_0=='D') ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2=='I') ) {
                    alt14=2;
                }
                else if ( (LA14_2=='i') ) {
                    alt14=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:184:9: 'divide'
                    {
                    match("divide"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:184:20: 'DIVIDE'
                    {
                    match("DIVIDE"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:184:31: 'Divide'
                    {
                    match("Divide"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:185:9: ( 'distinct' | 'DISTINCT' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='d') ) {
                alt15=1;
            }
            else if ( (LA15_0=='D') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:185:11: 'distinct'
                    {
                    match("distinct"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:185:24: 'DISTINCT'
                    {
                    match("DISTINCT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:186:6: ( 'range' | 'RANGE' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='r') ) {
                alt16=1;
            }
            else if ( (LA16_0=='R') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:186:8: 'range'
                    {
                    match("range"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:186:18: 'RANGE'
                    {
                    match("RANGE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "DataType"
    public final void mDataType() throws RecognitionException {
        try {
            int _type = DataType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:9: ( 'string' | 'integer' | 'boolean' | 'float' | 'double' | 'text' )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt17=1;
                }
                break;
            case 'i':
                {
                alt17=2;
                }
                break;
            case 'b':
                {
                alt17=3;
                }
                break;
            case 'f':
                {
                alt17=4;
                }
                break;
            case 'd':
                {
                alt17=5;
                }
                break;
            case 't':
                {
                alt17=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:11: 'string'
                    {
                    match("string"); 


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:22: 'integer'
                    {
                    match("integer"); 


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:34: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:46: 'float'
                    {
                    match("float"); 


                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:56: 'double'
                    {
                    match("double"); 


                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:189:67: 'text'
                    {
                    match("text"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DataType"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:192:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:193:15: ( '0' .. '9' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:193:17: '0' .. '9'
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:194:7: ( ( Digit )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:194:9: ( Digit )+
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:194:9: ( Digit )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:194:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:196:18: ( Letter | Digit | '_' | '-' | At )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:198:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:198:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:198:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\t' && LA19_0<='\n')||(LA19_0>='\f' && LA19_0<='\r')||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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

    // $ANTLR start "Quot_s"
    public final void mQuot_s() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:200:16: ( (~ '\"' )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:200:18: (~ '\"' )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:200:18: (~ '\"' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='!')||(LA20_0>='#' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:200:19: ~ '\"'
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
            	    break loop20;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Quot_s"

    // $ANTLR start "Apos_s"
    public final void mApos_s() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:201:16: ( (~ '\\'' )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:201:18: (~ '\\'' )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:201:18: (~ '\\'' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:201:19: ~ '\\''
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
            	    break loop21;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Apos_s"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            Token q=null;
            Token a=null;

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:204:1: ( Quot q= Quot_s Quot | Apos a= Apos_s Apos )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\"') ) {
                alt22=1;
            }
            else if ( (LA22_0=='\'') ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:204:3: Quot q= Quot_s Quot
                    {
                    mQuot(); 
                    int qStart663 = getCharIndex();
                    mQuot_s(); 
                    q = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, qStart663, getCharIndex()-1);
                    mQuot(); 
                     setText((q!=null?q.getText():null)); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:205:3: Apos a= Apos_s Apos
                    {
                    mApos(); 
                    int aStart675 = getCharIndex();
                    mApos_s(); 
                    a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart675, getCharIndex()-1);
                    mApos(); 
                     setText((a!=null?a.getText():null)); 

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

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:210:14: ( ( Letter | '_' ) ( NameChar )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:210:16: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:210:31: ( NameChar )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='-'||(LA23_0>='0' && LA23_0<='9')||(LA23_0>='@' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:210:31: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Name"

    // $ANTLR start "QName"
    public final void mQName() throws RecognitionException {
        try {
            int _type = QName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:213:2: ( Name Colon Name | Name )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:213:4: Name Colon Name
                    {
                    mName(); 
                    mColon(); 
                    mName(); 

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:214:4: Name
                    {
                    mName(); 

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
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:8: ( T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | ML_COMMENT | LINE_COMMENT | Dot | Colon | Comma | RParen | LParen | At | Wildcard | EQUAL | NOT_EQUAL | LESS | LEQ | GREATER | GEQ | SPLIT | Select | From | Where | In | Insert | Into | Object | Relationship | HasMany | HasOne | DIVIDE | DISTINCT | RANGE | DataType | Digits | WhiteSpaceChar | StringLiteral | QName )
        int alt25=46;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:10: T__79
                {
                mT__79(); 

                }
                break;
            case 2 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:16: T__80
                {
                mT__80(); 

                }
                break;
            case 3 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:22: T__81
                {
                mT__81(); 

                }
                break;
            case 4 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:28: T__82
                {
                mT__82(); 

                }
                break;
            case 5 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:34: T__83
                {
                mT__83(); 

                }
                break;
            case 6 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:40: T__84
                {
                mT__84(); 

                }
                break;
            case 7 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:46: T__85
                {
                mT__85(); 

                }
                break;
            case 8 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:52: T__86
                {
                mT__86(); 

                }
                break;
            case 9 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:58: T__87
                {
                mT__87(); 

                }
                break;
            case 10 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:64: T__88
                {
                mT__88(); 

                }
                break;
            case 11 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:70: T__89
                {
                mT__89(); 

                }
                break;
            case 12 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:76: T__90
                {
                mT__90(); 

                }
                break;
            case 13 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:82: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 14 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:93: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 15 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:106: Dot
                {
                mDot(); 

                }
                break;
            case 16 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:110: Colon
                {
                mColon(); 

                }
                break;
            case 17 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:116: Comma
                {
                mComma(); 

                }
                break;
            case 18 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:122: RParen
                {
                mRParen(); 

                }
                break;
            case 19 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:129: LParen
                {
                mLParen(); 

                }
                break;
            case 20 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:136: At
                {
                mAt(); 

                }
                break;
            case 21 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:139: Wildcard
                {
                mWildcard(); 

                }
                break;
            case 22 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:148: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 23 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:154: NOT_EQUAL
                {
                mNOT_EQUAL(); 

                }
                break;
            case 24 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:164: LESS
                {
                mLESS(); 

                }
                break;
            case 25 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:169: LEQ
                {
                mLEQ(); 

                }
                break;
            case 26 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:173: GREATER
                {
                mGREATER(); 

                }
                break;
            case 27 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:181: GEQ
                {
                mGEQ(); 

                }
                break;
            case 28 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:185: SPLIT
                {
                mSPLIT(); 

                }
                break;
            case 29 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:191: Select
                {
                mSelect(); 

                }
                break;
            case 30 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:198: From
                {
                mFrom(); 

                }
                break;
            case 31 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:203: Where
                {
                mWhere(); 

                }
                break;
            case 32 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:209: In
                {
                mIn(); 

                }
                break;
            case 33 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:212: Insert
                {
                mInsert(); 

                }
                break;
            case 34 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:219: Into
                {
                mInto(); 

                }
                break;
            case 35 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:224: Object
                {
                mObject(); 

                }
                break;
            case 36 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:231: Relationship
                {
                mRelationship(); 

                }
                break;
            case 37 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:244: HasMany
                {
                mHasMany(); 

                }
                break;
            case 38 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:252: HasOne
                {
                mHasOne(); 

                }
                break;
            case 39 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:259: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 40 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:266: DISTINCT
                {
                mDISTINCT(); 

                }
                break;
            case 41 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:275: RANGE
                {
                mRANGE(); 

                }
                break;
            case 42 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:281: DataType
                {
                mDataType(); 

                }
                break;
            case 43 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:290: Digits
                {
                mDigits(); 

                }
                break;
            case 44 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:297: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 45 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:312: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 46 :
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:1:326: QName
                {
                mQName(); 

                }
                break;

        }

    }


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA24_eotS =
        "\1\uffff\2\3\2\uffff";
    static final String DFA24_eofS =
        "\5\uffff";
    static final String DFA24_minS =
        "\1\101\2\55\2\uffff";
    static final String DFA24_maxS =
        "\3\172\2\uffff";
    static final String DFA24_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA24_specialS =
        "\5\uffff}>";
    static final String[] DFA24_transitionS = {
            "\32\1\4\uffff\1\1\1\uffff\32\1",
            "\1\2\2\uffff\12\2\1\uffff\1\4\4\uffff\33\2\4\uffff\1\2\1\uffff"+
            "\32\2",
            "\1\2\2\uffff\12\2\1\uffff\1\4\4\uffff\33\2\4\uffff\1\2\1\uffff"+
            "\32\2",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "212:1: QName : ( Name Colon Name | Name );";
        }
    }
    static final String DFA25_eotS =
        "\1\uffff\5\51\2\uffff\2\51\12\uffff\1\71\1\73\1\uffff\17\51\4\uffff"+
        "\1\123\2\51\1\126\5\51\1\136\2\51\6\uffff\6\51\2\151\17\51\1\uffff"+
        "\2\51\1\uffff\1\177\2\51\1\u0082\3\51\1\uffff\12\51\1\uffff\24\51"+
        "\1\u00a8\1\uffff\1\u00a9\1\51\1\uffff\4\51\1\u00af\1\51\1\u00b1"+
        "\1\51\1\u00b1\3\51\1\u00b6\2\51\1\u00b6\23\51\1\u00cc\1\51\2\uffff"+
        "\3\51\1\u00d1\1\51\1\uffff\1\51\1\uffff\1\u00cc\2\u00d4\1\51\1\uffff"+
        "\5\51\1\u00db\2\51\1\u00db\14\51\1\uffff\1\51\1\u00eb\1\u00ec\1"+
        "\u00cc\1\uffff\1\u00ed\1\u00ec\1\uffff\1\u00ee\1\51\1\u00ee\2\u00ed"+
        "\1\51\1\uffff\3\51\1\u00f4\1\51\1\u00f4\1\51\1\u00f4\1\u00f7\1\51"+
        "\1\u00cc\1\u00f7\1\51\1\u00f7\1\u00cc\4\uffff\1\u00cc\3\51\1\u00fd"+
        "\1\uffff\2\u00fd\1\uffff\5\51\1\uffff\2\u0103\3\51\1\uffff\6\51"+
        "\3\u010d\1\uffff";
    static final String DFA25_eofS =
        "\u010e\uffff";
    static final String DFA25_minS =
        "\1\11\1\157\1\156\1\125\1\160\1\145\2\uffff\1\142\1\151\1\52\11"+
        "\uffff\2\75\1\uffff\1\105\1\154\1\122\1\150\1\110\1\156\1\116\1"+
        "\102\1\141\1\101\1\141\1\101\1\151\1\111\1\145\4\uffff\1\55\1\157"+
        "\1\164\1\55\1\144\1\124\1\144\1\154\1\162\1\55\1\152\1\153\6\uffff"+
        "\1\114\2\157\1\117\1\145\1\105\2\55\1\112\1\152\1\154\1\156\1\114"+
        "\1\154\1\116\1\163\1\123\2\163\1\165\1\123\1\166\1\170\1\uffff\1"+
        "\154\1\157\1\uffff\1\55\1\117\1\141\1\55\1\145\1\151\1\145\1\uffff"+
        "\2\145\1\105\1\155\1\141\1\115\1\162\1\122\2\145\1\uffff\1\105\1"+
        "\117\1\105\1\145\1\141\1\147\1\101\1\141\1\107\1\155\2\115\1\151"+
        "\1\164\1\142\1\111\1\124\1\151\1\164\1\145\1\55\1\uffff\1\55\1\164"+
        "\1\uffff\1\143\1\156\1\162\1\143\1\55\1\103\1\55\1\164\1\55\1\145"+
        "\1\105\1\162\1\55\1\147\1\122\1\55\1\103\1\143\1\164\1\145\1\124"+
        "\1\164\1\105\1\141\1\156\1\101\1\116\1\141\1\156\1\144\1\151\1\154"+
        "\1\104\1\111\1\144\1\55\1\141\2\uffff\1\145\1\164\1\147\1\55\1\164"+
        "\1\uffff\1\124\1\uffff\3\55\1\164\1\uffff\1\145\2\124\1\164\1\151"+
        "\1\55\1\111\1\151\1\55\1\156\1\145\1\116\1\105\1\156\2\145\1\156"+
        "\1\145\1\105\1\116\1\145\1\uffff\1\156\3\55\1\uffff\2\55\1\uffff"+
        "\1\55\1\162\3\55\1\157\1\uffff\1\117\1\157\1\171\1\55\1\131\1\55"+
        "\1\171\2\55\1\143\2\55\1\103\2\55\4\uffff\1\55\1\156\1\116\1\156"+
        "\1\55\1\uffff\2\55\1\uffff\1\164\1\124\1\163\1\123\1\163\1\uffff"+
        "\2\55\1\150\1\110\1\150\1\uffff\1\151\1\111\1\151\1\160\1\120\1"+
        "\160\3\55\1\uffff";
    static final String DFA25_maxS =
        "\1\175\1\171\1\165\1\125\1\160\1\164\2\uffff\1\162\1\151\1\57\11"+
        "\uffff\2\75\1\uffff\1\105\1\162\1\122\1\150\1\110\1\156\1\116\1"+
        "\142\2\145\2\141\1\157\1\151\1\145\4\uffff\1\172\1\157\1\164\1\172"+
        "\1\144\1\124\1\144\1\164\1\162\1\172\1\152\1\153\6\uffff\1\114\2"+
        "\157\1\117\1\145\1\105\2\172\1\112\1\152\1\154\1\156\1\114\1\154"+
        "\1\116\1\163\1\123\1\163\1\166\1\165\1\126\1\166\1\170\1\uffff\1"+
        "\154\1\157\1\uffff\1\172\1\117\1\141\1\172\1\145\1\151\1\145\1\uffff"+
        "\2\145\1\105\1\155\1\141\1\115\1\162\1\122\1\145\1\157\1\uffff\1"+
        "\105\1\117\1\105\1\145\1\141\1\147\1\101\1\141\1\107\1\157\2\117"+
        "\1\151\1\164\1\142\1\111\1\124\1\151\1\164\1\145\1\172\1\uffff\1"+
        "\172\1\164\1\uffff\1\143\1\156\1\162\1\143\1\172\1\103\1\172\1\164"+
        "\1\172\1\145\1\105\1\162\1\172\1\147\1\122\1\172\1\103\1\143\1\164"+
        "\1\145\1\124\1\164\1\105\1\141\1\156\1\101\1\116\1\141\1\156\1\144"+
        "\1\151\1\154\1\104\1\111\1\144\1\172\1\141\2\uffff\1\145\1\164\1"+
        "\147\1\172\1\164\1\uffff\1\124\1\uffff\3\172\1\164\1\uffff\1\145"+
        "\2\124\1\164\1\151\1\172\1\111\1\151\1\172\1\156\1\145\1\116\1\105"+
        "\1\156\2\145\1\156\1\145\1\105\1\116\1\145\1\uffff\1\156\3\172\1"+
        "\uffff\2\172\1\uffff\1\172\1\162\3\172\1\157\1\uffff\1\117\1\157"+
        "\1\171\1\172\1\131\1\172\1\171\2\172\1\143\2\172\1\103\2\172\4\uffff"+
        "\1\172\1\156\1\116\1\156\1\172\1\uffff\2\172\1\uffff\1\164\1\124"+
        "\1\163\1\123\1\163\1\uffff\2\172\1\150\1\110\1\150\1\uffff\1\151"+
        "\1\111\1\151\1\160\1\120\1\160\3\172\1\uffff";
    static final String DFA25_acceptS =
        "\6\uffff\1\6\1\7\3\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
        "\1\27\2\uffff\1\34\17\uffff\1\53\1\54\1\55\1\56\14\uffff\1\15\1"+
        "\16\1\31\1\30\1\33\1\32\27\uffff\1\1\2\uffff\1\10\7\uffff\1\12\12"+
        "\uffff\1\40\25\uffff\1\13\2\uffff\1\5\45\uffff\1\2\1\3\5\uffff\1"+
        "\14\1\uffff\1\36\4\uffff\1\42\25\uffff\1\52\4\uffff\1\11\2\uffff"+
        "\1\37\6\uffff\1\51\17\uffff\1\4\1\35\1\43\1\41\5\uffff\1\46\2\uffff"+
        "\1\47\5\uffff\1\45\5\uffff\1\50\11\uffff\1\44";
    static final String DFA25_specialS =
        "\u010e\uffff}>";
    static final String[] DFA25_transitionS = {
            "\2\47\1\uffff\2\47\22\uffff\1\47\1\23\1\50\4\uffff\1\50\1\17"+
            "\1\16\1\21\1\uffff\1\15\1\uffff\1\13\1\12\12\46\1\uffff\1\14"+
            "\1\24\1\22\1\25\1\uffff\1\20\1\3\2\51\1\44\1\51\1\31\1\51\1"+
            "\42\1\35\5\51\1\36\2\51\1\40\1\27\3\51\1\33\3\51\4\uffff\1\51"+
            "\1\uffff\1\2\1\1\1\51\1\43\1\51\1\30\1\51\1\41\1\34\2\51\1\11"+
            "\2\51\1\10\2\51\1\37\1\5\1\45\1\4\1\51\1\32\3\51\1\6\1\26\1"+
            "\7",
            "\1\53\11\uffff\1\52",
            "\1\56\4\uffff\1\55\1\uffff\1\54",
            "\1\57",
            "\1\60",
            "\1\61\16\uffff\1\62",
            "",
            "",
            "\1\64\17\uffff\1\63",
            "\1\65",
            "\1\66\4\uffff\1\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\70",
            "\1\72",
            "",
            "\1\74",
            "\1\76\5\uffff\1\75",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104\37\uffff\1\105",
            "\1\107\3\uffff\1\106",
            "\1\112\3\uffff\1\110\37\uffff\1\111",
            "\1\113",
            "\1\114\37\uffff\1\115",
            "\1\116\5\uffff\1\117",
            "\1\120\37\uffff\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\124",
            "\1\125",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\133\7\uffff\1\132",
            "\1\134",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\3\51\1\135\26\51",
            "\1\137",
            "\1\140",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\22\51\1\147\1\150\6\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\23\51\1\152\1\153"+
            "\6\51\4\uffff\1\51\1\uffff\32\51",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\167\2\uffff\1\166",
            "\1\170",
            "\1\172\2\uffff\1\171",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\1\176",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u0080",
            "\1\u0081",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u0090\11\uffff\1\u008f",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a\1\uffff\1\u009b",
            "\1\u009c\1\uffff\1\u009d",
            "\1\u009e\1\uffff\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00b0",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00b2",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00b7",
            "\1\u00b8",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00cd",
            "",
            "",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00d2",
            "",
            "\1\u00d3",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00dc",
            "\1\u00dd",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "\1\u00ea",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00ef",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00f0",
            "",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00f5",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00f6",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00f8",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00f9",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "",
            "",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            "\1\51\2\uffff\12\51\1\uffff\1\51\4\uffff\33\51\4\uffff\1\51"+
            "\1\uffff\32\51",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | ML_COMMENT | LINE_COMMENT | Dot | Colon | Comma | RParen | LParen | At | Wildcard | EQUAL | NOT_EQUAL | LESS | LEQ | GREATER | GEQ | SPLIT | Select | From | Where | In | Insert | Into | Object | Relationship | HasMany | HasOne | DIVIDE | DISTINCT | RANGE | DataType | Digits | WhiteSpaceChar | StringLiteral | QName );";
        }
    }
 

}
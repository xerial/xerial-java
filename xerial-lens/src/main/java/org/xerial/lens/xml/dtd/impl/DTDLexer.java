// $ANTLR 3.2 Sep 23, 2009 14:05:07 DTD.g 2010-11-19 10:24:15

//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDLexer.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

package org.xerial.lens.xml.dtd.impl;
import org.xerial.util.log.Logger;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DTDLexer extends Lexer {
    public static final int CharRef=40;
    public static final int DefaultDecl=41;
    public static final int Apos=24;
    public static final int T__62=62;
    public static final int ATTLIST=10;
    public static final int ATTRIBUTE=9;
    public static final int ENUMTYPE=7;
    public static final int ENTITY_REF=18;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int CONTENTSPEC=16;
    public static final int AttValue=38;
    public static final int TYPE=12;
    public static final int ENTITY=17;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int ML_COMMENT=20;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int NAME=8;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int Digits=32;
    public static final int WhiteSpaceChar=34;
    public static final int T__59=59;
    public static final int DTD=4;
    public static final int ELEMENT=13;
    public static final int String=35;
    public static final int Reference=37;
    public static final int T__50=50;
    public static final int COMPONENT=14;
    public static final int Quot=25;
    public static final int SemiColon=27;
    public static final int T__43=43;
    public static final int RParen=29;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int At=21;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int LParen=28;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int NameChar=33;
    public static final int Colon=22;
    public static final int VALUE=19;
    public static final int OCCURRENCE=15;
    public static final int Digit=31;
    public static final int TOKENIZEDTYPE=6;
    public static final int EntityRef=39;
    public static final int DECL=11;
    public static final int STRINGTYPE=5;
    public static final int Dot=26;
    public static final int Name=36;
    public static final int Comma=23;
    public static final int Letter=30;
    public static final int Element=42;

    // delegates
    // delegators

    public DTDLexer() {;} 
    public DTDLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DTDLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "DTD.g"; }

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:26:7: ( '>' )
            // DTD.g:26:9: '>'
            {
            match('>'); 

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
            // DTD.g:27:7: ( 'EMPTY' )
            // DTD.g:27:9: 'EMPTY'
            {
            match("EMPTY"); 


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
            // DTD.g:28:7: ( 'ANY' )
            // DTD.g:28:9: 'ANY'
            {
            match("ANY"); 


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
            // DTD.g:29:7: ( '?' )
            // DTD.g:29:9: '?'
            {
            match('?'); 

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
            // DTD.g:30:7: ( '*' )
            // DTD.g:30:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:31:7: ( '+' )
            // DTD.g:31:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:32:7: ( '|' )
            // DTD.g:32:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:33:7: ( '#PCDATA' )
            // DTD.g:33:9: '#PCDATA'
            {
            match("#PCDATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:34:7: ( '<!ATTLIST' )
            // DTD.g:34:9: '<!ATTLIST'
            {
            match("<!ATTLIST"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:35:7: ( 'NOTATION' )
            // DTD.g:35:9: 'NOTATION'
            {
            match("NOTATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:36:7: ( 'CDATA' )
            // DTD.g:36:9: 'CDATA'
            {
            match("CDATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:37:7: ( 'ID' )
            // DTD.g:37:9: 'ID'
            {
            match("ID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:38:7: ( 'IDREF' )
            // DTD.g:38:9: 'IDREF'
            {
            match("IDREF"); 


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
            // DTD.g:39:7: ( 'IDREFS' )
            // DTD.g:39:9: 'IDREFS'
            {
            match("IDREFS"); 


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
            // DTD.g:40:7: ( 'ENTITY' )
            // DTD.g:40:9: 'ENTITY'
            {
            match("ENTITY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:41:7: ( 'ENTITIES' )
            // DTD.g:41:9: 'ENTITIES'
            {
            match("ENTITIES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:42:7: ( 'NMTOKEN' )
            // DTD.g:42:9: 'NMTOKEN'
            {
            match("NMTOKEN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:43:7: ( 'NMTOKENS' )
            // DTD.g:43:9: 'NMTOKENS'
            {
            match("NMTOKENS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:44:7: ( '<!ENTITY' )
            // DTD.g:44:9: '<!ENTITY'
            {
            match("<!ENTITY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:45:7: ( '%' )
            // DTD.g:45:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:87:5: ( '<!--' ( options {greedy=false; } : . )* '-->' )
            // DTD.g:87:9: '<!--' ( options {greedy=false; } : . )* '-->'
            {
            match("<!--"); 

            // DTD.g:87:16: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='-') ) {
                        int LA1_3 = input.LA(3);

                        if ( (LA1_3=='>') ) {
                            alt1=2;
                        }
                        else if ( ((LA1_3>='\u0000' && LA1_3<='=')||(LA1_3>='?' && LA1_3<='\uFFFF')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<=',')||(LA1_1>='.' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=',')||(LA1_0>='.' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // DTD.g:87:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("-->"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:90:3: ( '@' )
            // DTD.g:90:5: '@'
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:91:6: ( ':' )
            // DTD.g:91:8: ':'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:92:6: ( ',' )
            // DTD.g:92:8: ','
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

    // $ANTLR start "Apos"
    public final void mApos() throws RecognitionException {
        try {
            int _type = Apos;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:93:5: ( '\\'' )
            // DTD.g:93:7: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Apos"

    // $ANTLR start "Quot"
    public final void mQuot() throws RecognitionException {
        try {
            int _type = Quot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:94:5: ( '\"' )
            // DTD.g:94:7: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Quot"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:95:4: ( '.' )
            // DTD.g:95:6: '.'
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

    // $ANTLR start "SemiColon"
    public final void mSemiColon() throws RecognitionException {
        try {
            int _type = SemiColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:96:10: ( ';' )
            // DTD.g:96:12: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SemiColon"

    // $ANTLR start "LParen"
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:98:7: ( '(' )
            // DTD.g:98:9: '('
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
            // DTD.g:99:7: ( ')' )
            // DTD.g:99:9: ')'
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

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // DTD.g:101:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // DTD.g:
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
            // DTD.g:102:15: ( '0' .. '9' )
            // DTD.g:102:17: '0' .. '9'
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
            // DTD.g:103:7: ( ( Digit )+ )
            // DTD.g:103:9: ( Digit )+
            {
            // DTD.g:103:9: ( Digit )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // DTD.g:103:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
            // DTD.g:105:18: ( Letter | Digit | '_' | '-' | At )
            // DTD.g:
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
            // DTD.g:107:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // DTD.g:107:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // DTD.g:107:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||(LA3_0>='\f' && LA3_0<='\r')||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // DTD.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:110:1: ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // DTD.g:110:3: Quot (~ '\"' )* Quot
                    {
                    mQuot(); 
                    // DTD.g:110:8: (~ '\"' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // DTD.g:110:9: ~ '\"'
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
                    	    break loop4;
                        }
                    } while (true);

                    mQuot(); 

                    }
                    break;
                case 2 :
                    // DTD.g:111:3: Apos (~ '\\'' )* Apos
                    {
                    mApos(); 
                    // DTD.g:111:8: (~ '\\'' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // DTD.g:111:9: ~ '\\''
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
                    	    break loop5;
                        }
                    } while (true);

                    mApos(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            int _type = Name;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:113:5: ( ( Letter | '_' ) ( NameChar )* )
            // DTD.g:113:7: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // DTD.g:113:22: ( NameChar )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')||(LA7_0>='@' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // DTD.g:113:22: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Name"

    // $ANTLR start "AttValue"
    public final void mAttValue() throws RecognitionException {
        try {
            // DTD.g:116:18: ( Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot | Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // DTD.g:117:5: Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot
                    {
                    mQuot(); 
                    // DTD.g:117:10: (~ ( '<' | '&' | Quot ) | Reference )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='%')||(LA8_0>='\'' && LA8_0<=';')||(LA8_0>='=' && LA8_0<='\uFFFF')) ) {
                            alt8=1;
                        }
                        else if ( (LA8_0=='&') ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // DTD.g:117:11: ~ ( '<' | '&' | Quot )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='\'' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // DTD.g:117:33: Reference
                    	    {
                    	    mReference(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    mQuot(); 

                    }
                    break;
                case 2 :
                    // DTD.g:118:7: Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos
                    {
                    mApos(); 
                    // DTD.g:118:12: (~ ( '<' | '&' | Apos ) | Reference )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='\u0000' && LA9_0<='%')||(LA9_0>='(' && LA9_0<=';')||(LA9_0>='=' && LA9_0<='\uFFFF')) ) {
                            alt9=1;
                        }
                        else if ( (LA9_0=='&') ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // DTD.g:118:13: ~ ( '<' | '&' | Apos )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='%')||(input.LA(1)>='(' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // DTD.g:118:35: Reference
                    	    {
                    	    mReference(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    mApos(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "AttValue"

    // $ANTLR start "Reference"
    public final void mReference() throws RecognitionException {
        try {
            int _type = Reference;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:121:10: ( EntityRef | CharRef )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='&') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='#') ) {
                    alt11=2;
                }
                else if ( ((LA11_1>='A' && LA11_1<='Z')||LA11_1=='_'||(LA11_1>='a' && LA11_1<='z')) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

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
                    // DTD.g:121:12: EntityRef
                    {
                    mEntityRef(); 

                    }
                    break;
                case 2 :
                    // DTD.g:121:24: CharRef
                    {
                    mCharRef(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Reference"

    // $ANTLR start "EntityRef"
    public final void mEntityRef() throws RecognitionException {
        try {
            // DTD.g:122:19: ( '&' Name SemiColon )
            // DTD.g:122:21: '&' Name SemiColon
            {
            match('&'); 
            mName(); 
            mSemiColon(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "EntityRef"

    // $ANTLR start "CharRef"
    public final void mCharRef() throws RecognitionException {
        try {
            // DTD.g:123:17: ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='&') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='#') ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2=='x') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_2>='0' && LA14_2<='9')) ) {
                        alt14=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

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
                    // DTD.g:123:19: '&#' ( '0' .. '9' )+ SemiColon
                    {
                    match("&#"); 

                    // DTD.g:123:24: ( '0' .. '9' )+
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
                    	    // DTD.g:123:25: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    mSemiColon(); 

                    }
                    break;
                case 2 :
                    // DTD.g:123:48: '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon
                    {
                    match("&#x"); 

                    // DTD.g:123:54: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='F')||(LA13_0>='a' && LA13_0<='f')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // DTD.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    mSemiColon(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CharRef"

    // $ANTLR start "DefaultDecl"
    public final void mDefaultDecl() throws RecognitionException {
        try {
            int _type = DefaultDecl;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:127:3: ( '#REQUIRED' | '#IMPLIED' | ( ( '#FIXED' )? AttValue ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='#') ) {
                switch ( input.LA(2) ) {
                case 'R':
                    {
                    alt16=1;
                    }
                    break;
                case 'I':
                    {
                    alt16=2;
                    }
                    break;
                case 'F':
                    {
                    alt16=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA16_0=='\"'||LA16_0=='\'') ) {
                alt16=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // DTD.g:127:5: '#REQUIRED'
                    {
                    match("#REQUIRED"); 

                     setText("REQUIRED"); 

                    }
                    break;
                case 2 :
                    // DTD.g:128:5: '#IMPLIED'
                    {
                    match("#IMPLIED"); 

                     setText("IMPLIED"); 

                    }
                    break;
                case 3 :
                    // DTD.g:129:5: ( ( '#FIXED' )? AttValue )
                    {
                    // DTD.g:129:5: ( ( '#FIXED' )? AttValue )
                    // DTD.g:129:6: ( '#FIXED' )? AttValue
                    {
                    // DTD.g:129:6: ( '#FIXED' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='#') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // DTD.g:129:6: '#FIXED'
                            {
                            match("#FIXED"); 


                            }
                            break;

                    }

                    mAttValue(); 

                    }

                     setText("FIXED"); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DefaultDecl"

    // $ANTLR start "Element"
    public final void mElement() throws RecognitionException {
        try {
            int _type = Element;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DTD.g:132:8: ( '<!ELEMENT' )
            // DTD.g:132:10: '<!ELEMENT'
            {
            match("<!ELEMENT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Element"

    public void mTokens() throws RecognitionException {
        // DTD.g:1:8: ( T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | String | Name | Reference | DefaultDecl | Element )
        int alt17=37;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // DTD.g:1:10: T__43
                {
                mT__43(); 

                }
                break;
            case 2 :
                // DTD.g:1:16: T__44
                {
                mT__44(); 

                }
                break;
            case 3 :
                // DTD.g:1:22: T__45
                {
                mT__45(); 

                }
                break;
            case 4 :
                // DTD.g:1:28: T__46
                {
                mT__46(); 

                }
                break;
            case 5 :
                // DTD.g:1:34: T__47
                {
                mT__47(); 

                }
                break;
            case 6 :
                // DTD.g:1:40: T__48
                {
                mT__48(); 

                }
                break;
            case 7 :
                // DTD.g:1:46: T__49
                {
                mT__49(); 

                }
                break;
            case 8 :
                // DTD.g:1:52: T__50
                {
                mT__50(); 

                }
                break;
            case 9 :
                // DTD.g:1:58: T__51
                {
                mT__51(); 

                }
                break;
            case 10 :
                // DTD.g:1:64: T__52
                {
                mT__52(); 

                }
                break;
            case 11 :
                // DTD.g:1:70: T__53
                {
                mT__53(); 

                }
                break;
            case 12 :
                // DTD.g:1:76: T__54
                {
                mT__54(); 

                }
                break;
            case 13 :
                // DTD.g:1:82: T__55
                {
                mT__55(); 

                }
                break;
            case 14 :
                // DTD.g:1:88: T__56
                {
                mT__56(); 

                }
                break;
            case 15 :
                // DTD.g:1:94: T__57
                {
                mT__57(); 

                }
                break;
            case 16 :
                // DTD.g:1:100: T__58
                {
                mT__58(); 

                }
                break;
            case 17 :
                // DTD.g:1:106: T__59
                {
                mT__59(); 

                }
                break;
            case 18 :
                // DTD.g:1:112: T__60
                {
                mT__60(); 

                }
                break;
            case 19 :
                // DTD.g:1:118: T__61
                {
                mT__61(); 

                }
                break;
            case 20 :
                // DTD.g:1:124: T__62
                {
                mT__62(); 

                }
                break;
            case 21 :
                // DTD.g:1:130: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 22 :
                // DTD.g:1:141: At
                {
                mAt(); 

                }
                break;
            case 23 :
                // DTD.g:1:144: Colon
                {
                mColon(); 

                }
                break;
            case 24 :
                // DTD.g:1:150: Comma
                {
                mComma(); 

                }
                break;
            case 25 :
                // DTD.g:1:156: Apos
                {
                mApos(); 

                }
                break;
            case 26 :
                // DTD.g:1:161: Quot
                {
                mQuot(); 

                }
                break;
            case 27 :
                // DTD.g:1:166: Dot
                {
                mDot(); 

                }
                break;
            case 28 :
                // DTD.g:1:170: SemiColon
                {
                mSemiColon(); 

                }
                break;
            case 29 :
                // DTD.g:1:180: LParen
                {
                mLParen(); 

                }
                break;
            case 30 :
                // DTD.g:1:187: RParen
                {
                mRParen(); 

                }
                break;
            case 31 :
                // DTD.g:1:194: Digits
                {
                mDigits(); 

                }
                break;
            case 32 :
                // DTD.g:1:201: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 33 :
                // DTD.g:1:216: String
                {
                mString(); 

                }
                break;
            case 34 :
                // DTD.g:1:223: Name
                {
                mName(); 

                }
                break;
            case 35 :
                // DTD.g:1:228: Reference
                {
                mReference(); 

                }
                break;
            case 36 :
                // DTD.g:1:238: DefaultDecl
                {
                mDefaultDecl(); 

                }
                break;
            case 37 :
                // DTD.g:1:250: Element
                {
                mElement(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\2\uffff\2\31\6\uffff\3\31\4\uffff\1\45\1\52\10\uffff\3\31\3\uffff"+
        "\3\31\1\70\11\uffff\2\31\1\77\3\uffff\4\31\5\uffff\2\31\3\uffff"+
        "\4\31\10\uffff\1\130\3\31\1\135\1\137\5\uffff\1\142\3\31\1\uffff"+
        "\1\146\4\uffff\2\31\1\152\1\uffff\1\153\1\154\1\155\4\uffff";
    static final String DFA17_eofS =
        "\156\uffff";
    static final String DFA17_minS =
        "\1\11\1\uffff\1\115\1\116\4\uffff\1\106\1\41\1\115\2\104\4\uffff"+
        "\2\0\10\uffff\1\120\1\124\1\131\2\uffff\1\55\2\124\1\101\1\55\1"+
        "\uffff\2\0\3\uffff\1\0\1\uffff\1\0\1\124\1\111\1\55\1\uffff\1\114"+
        "\1\uffff\1\101\1\117\1\124\1\105\1\uffff\4\0\1\131\1\124\3\uffff"+
        "\1\124\1\113\1\101\1\106\10\0\1\55\2\111\1\105\2\55\4\0\1\uffff"+
        "\1\55\1\105\1\117\1\116\1\uffff\1\55\1\uffff\2\0\1\uffff\1\123\1"+
        "\116\1\55\1\uffff\3\55\4\uffff";
    static final String DFA17_maxS =
        "\1\174\1\uffff\2\116\4\uffff\1\122\1\41\1\117\2\104\4\uffff\2\uffff"+
        "\10\uffff\1\120\1\124\1\131\2\uffff\1\105\2\124\1\101\1\172\1\uffff"+
        "\2\uffff\3\uffff\1\uffff\1\uffff\1\uffff\1\124\1\111\1\172\1\uffff"+
        "\1\116\1\uffff\1\101\1\117\1\124\1\105\1\uffff\4\uffff\1\131\1\124"+
        "\3\uffff\1\124\1\113\1\101\1\106\10\uffff\1\172\1\131\1\111\1\105"+
        "\2\172\4\uffff\1\uffff\1\172\1\105\1\117\1\116\1\uffff\1\172\1\uffff"+
        "\2\uffff\1\uffff\1\123\1\116\1\172\1\uffff\3\172\4\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\5\uffff\1\24\1\26\1\27\1\30"+
        "\2\uffff\1\33\1\34\1\35\1\36\1\37\1\40\1\42\1\43\3\uffff\1\10\1"+
        "\44\5\uffff\1\31\2\uffff\2\41\1\32\1\uffff\1\41\4\uffff\1\11\1\uffff"+
        "\1\25\4\uffff\1\14\6\uffff\1\3\1\23\1\45\26\uffff\1\2\4\uffff\1"+
        "\13\1\uffff\1\15\2\uffff\1\17\3\uffff\1\16\3\uffff\1\21\1\20\1\12"+
        "\1\22";
    static final String DFA17_specialS =
        "\21\uffff\1\17\1\2\23\uffff\1\23\1\7\3\uffff\1\11\1\uffff\1\13"+
        "\13\uffff\1\20\1\22\1\25\1\5\11\uffff\1\10\1\27\1\3\1\15\1\6\1\16"+
        "\1\0\1\24\6\uffff\1\4\1\1\1\21\1\14\10\uffff\1\12\1\26\14\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\30\1\uffff\2\30\22\uffff\1\30\1\uffff\1\22\1\10\1\uffff"+
            "\1\15\1\32\1\21\1\25\1\26\1\5\1\6\1\20\1\uffff\1\23\1\uffff"+
            "\12\27\1\17\1\24\1\11\1\uffff\1\1\1\4\1\16\1\3\1\31\1\13\1\31"+
            "\1\2\3\31\1\14\4\31\1\12\14\31\4\uffff\1\31\1\uffff\32\31\1"+
            "\uffff\1\7",
            "",
            "\1\33\1\34",
            "\1\35",
            "",
            "",
            "",
            "",
            "\1\37\2\uffff\1\37\6\uffff\1\36\1\uffff\1\37",
            "\1\40",
            "\1\42\1\uffff\1\41",
            "\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "\46\46\1\47\1\50\24\46\1\51\uffc3\46",
            "\42\53\1\54\3\53\1\55\25\53\1\51\uffc3\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "\1\63\23\uffff\1\61\3\uffff\1\62",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\31\2\uffff\12\31\6\uffff\22\31\1\67\10\31\4\uffff\1\31"+
            "\1\uffff\32\31",
            "",
            "\46\46\1\47\1\50\24\46\1\51\uffc3\46",
            "\43\51\1\71\35\51\32\72\4\51\1\72\1\51\32\72\uff85\51",
            "",
            "",
            "",
            "\42\53\1\54\3\53\1\55\25\53\1\51\uffc3\53",
            "",
            "\43\51\1\73\35\51\32\74\4\51\1\74\1\51\32\74\uff85\51",
            "\1\75",
            "\1\76",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "\1\101\1\uffff\1\100",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "\60\51\12\107\76\51\1\106\uff87\51",
            "\55\51\1\110\2\51\12\110\1\51\1\111\4\51\33\110\4\51\1\110"+
            "\1\51\32\110\uff85\51",
            "\60\51\12\113\76\51\1\112\uff87\51",
            "\55\51\1\114\2\51\12\114\1\51\1\115\4\51\33\114\4\51\1\114"+
            "\1\51\32\114\uff85\51",
            "\1\116",
            "\1\117",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\60\51\12\124\7\51\6\124\32\51\6\124\uff99\51",
            "\60\51\12\107\1\51\1\125\uffc4\51",
            "\55\51\1\110\2\51\12\110\1\51\1\111\4\51\33\110\4\51\1\110"+
            "\1\51\32\110\uff85\51",
            "\46\46\1\47\1\50\24\46\1\51\uffc3\46",
            "\60\51\12\126\7\51\6\126\32\51\6\126\uff99\51",
            "\60\51\12\113\1\51\1\127\uffc4\51",
            "\55\51\1\114\2\51\12\114\1\51\1\115\4\51\33\114\4\51\1\114"+
            "\1\51\32\114\uff85\51",
            "\42\53\1\54\3\53\1\55\25\53\1\51\uffc3\53",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\132\17\uffff\1\131",
            "\1\133",
            "\1\134",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\6\uffff\23\31\1\136\7\31\4\uffff\1\31"+
            "\1\uffff\32\31",
            "\60\51\12\124\1\51\1\140\5\51\6\124\32\51\6\124\uff99\51",
            "\46\46\1\47\1\50\24\46\1\51\uffc3\46",
            "\60\51\12\126\1\51\1\141\5\51\6\126\32\51\6\126\uff99\51",
            "\42\53\1\54\3\53\1\55\25\53\1\51\uffc3\53",
            "",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "\46\46\1\47\1\50\24\46\1\51\uffc3\46",
            "\42\53\1\54\3\53\1\55\25\53\1\51\uffc3\53",
            "",
            "\1\147",
            "\1\150",
            "\1\31\2\uffff\12\31\6\uffff\23\31\1\151\7\31\4\uffff\1\31"+
            "\1\uffff\32\31",
            "",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\31\2\uffff\12\31\6\uffff\33\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | String | Name | Reference | DefaultDecl | Element );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_76 = input.LA(1);

                        s = -1;
                        if ( ((LA17_76>='\u0000' && LA17_76<=',')||(LA17_76>='.' && LA17_76<='/')||LA17_76==':'||(LA17_76>='<' && LA17_76<='?')||(LA17_76>='[' && LA17_76<='^')||LA17_76=='`'||(LA17_76>='{' && LA17_76<='\uFFFF')) ) {s = 41;}

                        else if ( (LA17_76==';') ) {s = 77;}

                        else if ( (LA17_76=='-'||(LA17_76>='0' && LA17_76<='9')||(LA17_76>='@' && LA17_76<='Z')||LA17_76=='_'||(LA17_76>='a' && LA17_76<='z')) ) {s = 76;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_85 = input.LA(1);

                        s = -1;
                        if ( (LA17_85=='\'') ) {s = 40;}

                        else if ( ((LA17_85>='\u0000' && LA17_85<='%')||(LA17_85>='(' && LA17_85<=';')||(LA17_85>='=' && LA17_85<='\uFFFF')) ) {s = 38;}

                        else if ( (LA17_85=='&') ) {s = 39;}

                        else if ( (LA17_85=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_18 = input.LA(1);

                        s = -1;
                        if ( ((LA17_18>='\u0000' && LA17_18<='!')||(LA17_18>='#' && LA17_18<='%')||(LA17_18>='\'' && LA17_18<=';')||(LA17_18>='=' && LA17_18<='\uFFFF')) ) {s = 43;}

                        else if ( (LA17_18=='\"') ) {s = 44;}

                        else if ( (LA17_18=='&') ) {s = 45;}

                        else if ( (LA17_18=='<') ) {s = 41;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_72 = input.LA(1);

                        s = -1;
                        if ( (LA17_72==';') ) {s = 73;}

                        else if ( (LA17_72=='-'||(LA17_72>='0' && LA17_72<='9')||(LA17_72>='@' && LA17_72<='Z')||LA17_72=='_'||(LA17_72>='a' && LA17_72<='z')) ) {s = 72;}

                        else if ( ((LA17_72>='\u0000' && LA17_72<=',')||(LA17_72>='.' && LA17_72<='/')||LA17_72==':'||(LA17_72>='<' && LA17_72<='?')||(LA17_72>='[' && LA17_72<='^')||LA17_72=='`'||(LA17_72>='{' && LA17_72<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_84 = input.LA(1);

                        s = -1;
                        if ( (LA17_84==';') ) {s = 96;}

                        else if ( ((LA17_84>='0' && LA17_84<='9')||(LA17_84>='A' && LA17_84<='F')||(LA17_84>='a' && LA17_84<='f')) ) {s = 84;}

                        else if ( ((LA17_84>='\u0000' && LA17_84<='/')||LA17_84==':'||(LA17_84>='<' && LA17_84<='@')||(LA17_84>='G' && LA17_84<='`')||(LA17_84>='g' && LA17_84<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_60 = input.LA(1);

                        s = -1;
                        if ( (LA17_60=='-'||(LA17_60>='0' && LA17_60<='9')||(LA17_60>='@' && LA17_60<='Z')||LA17_60=='_'||(LA17_60>='a' && LA17_60<='z')) ) {s = 76;}

                        else if ( (LA17_60==';') ) {s = 77;}

                        else if ( ((LA17_60>='\u0000' && LA17_60<=',')||(LA17_60>='.' && LA17_60<='/')||LA17_60==':'||(LA17_60>='<' && LA17_60<='?')||(LA17_60>='[' && LA17_60<='^')||LA17_60=='`'||(LA17_60>='{' && LA17_60<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_74 = input.LA(1);

                        s = -1;
                        if ( ((LA17_74>='\u0000' && LA17_74<='/')||(LA17_74>=':' && LA17_74<='@')||(LA17_74>='G' && LA17_74<='`')||(LA17_74>='g' && LA17_74<='\uFFFF')) ) {s = 41;}

                        else if ( ((LA17_74>='0' && LA17_74<='9')||(LA17_74>='A' && LA17_74<='F')||(LA17_74>='a' && LA17_74<='f')) ) {s = 86;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_39 = input.LA(1);

                        s = -1;
                        if ( (LA17_39=='#') ) {s = 57;}

                        else if ( ((LA17_39>='A' && LA17_39<='Z')||LA17_39=='_'||(LA17_39>='a' && LA17_39<='z')) ) {s = 58;}

                        else if ( ((LA17_39>='\u0000' && LA17_39<='\"')||(LA17_39>='$' && LA17_39<='@')||(LA17_39>='[' && LA17_39<='^')||LA17_39=='`'||(LA17_39>='{' && LA17_39<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_70 = input.LA(1);

                        s = -1;
                        if ( ((LA17_70>='\u0000' && LA17_70<='/')||(LA17_70>=':' && LA17_70<='@')||(LA17_70>='G' && LA17_70<='`')||(LA17_70>='g' && LA17_70<='\uFFFF')) ) {s = 41;}

                        else if ( ((LA17_70>='0' && LA17_70<='9')||(LA17_70>='A' && LA17_70<='F')||(LA17_70>='a' && LA17_70<='f')) ) {s = 84;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_43 = input.LA(1);

                        s = -1;
                        if ( (LA17_43=='\"') ) {s = 44;}

                        else if ( ((LA17_43>='\u0000' && LA17_43<='!')||(LA17_43>='#' && LA17_43<='%')||(LA17_43>='\'' && LA17_43<=';')||(LA17_43>='=' && LA17_43<='\uFFFF')) ) {s = 43;}

                        else if ( (LA17_43=='&') ) {s = 45;}

                        else if ( (LA17_43=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_96 = input.LA(1);

                        s = -1;
                        if ( (LA17_96=='\'') ) {s = 40;}

                        else if ( ((LA17_96>='\u0000' && LA17_96<='%')||(LA17_96>='(' && LA17_96<=';')||(LA17_96>='=' && LA17_96<='\uFFFF')) ) {s = 38;}

                        else if ( (LA17_96=='&') ) {s = 39;}

                        else if ( (LA17_96=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_45 = input.LA(1);

                        s = -1;
                        if ( (LA17_45=='#') ) {s = 59;}

                        else if ( ((LA17_45>='\u0000' && LA17_45<='\"')||(LA17_45>='$' && LA17_45<='@')||(LA17_45>='[' && LA17_45<='^')||LA17_45=='`'||(LA17_45>='{' && LA17_45<='\uFFFF')) ) {s = 41;}

                        else if ( ((LA17_45>='A' && LA17_45<='Z')||LA17_45=='_'||(LA17_45>='a' && LA17_45<='z')) ) {s = 60;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_87 = input.LA(1);

                        s = -1;
                        if ( (LA17_87=='\"') ) {s = 44;}

                        else if ( ((LA17_87>='\u0000' && LA17_87<='!')||(LA17_87>='#' && LA17_87<='%')||(LA17_87>='\'' && LA17_87<=';')||(LA17_87>='=' && LA17_87<='\uFFFF')) ) {s = 43;}

                        else if ( (LA17_87=='&') ) {s = 45;}

                        else if ( (LA17_87=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_73 = input.LA(1);

                        s = -1;
                        if ( (LA17_73=='\'') ) {s = 40;}

                        else if ( ((LA17_73>='\u0000' && LA17_73<='%')||(LA17_73>='(' && LA17_73<=';')||(LA17_73>='=' && LA17_73<='\uFFFF')) ) {s = 38;}

                        else if ( (LA17_73=='&') ) {s = 39;}

                        else if ( (LA17_73=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_75 = input.LA(1);

                        s = -1;
                        if ( ((LA17_75>='\u0000' && LA17_75<='/')||LA17_75==':'||(LA17_75>='<' && LA17_75<='\uFFFF')) ) {s = 41;}

                        else if ( (LA17_75==';') ) {s = 87;}

                        else if ( ((LA17_75>='0' && LA17_75<='9')) ) {s = 75;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_17 = input.LA(1);

                        s = -1;
                        if ( ((LA17_17>='\u0000' && LA17_17<='%')||(LA17_17>='(' && LA17_17<=';')||(LA17_17>='=' && LA17_17<='\uFFFF')) ) {s = 38;}

                        else if ( (LA17_17=='&') ) {s = 39;}

                        else if ( (LA17_17=='\'') ) {s = 40;}

                        else if ( (LA17_17=='<') ) {s = 41;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_57 = input.LA(1);

                        s = -1;
                        if ( (LA17_57=='x') ) {s = 70;}

                        else if ( ((LA17_57>='0' && LA17_57<='9')) ) {s = 71;}

                        else if ( ((LA17_57>='\u0000' && LA17_57<='/')||(LA17_57>=':' && LA17_57<='w')||(LA17_57>='y' && LA17_57<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_86 = input.LA(1);

                        s = -1;
                        if ( (LA17_86==';') ) {s = 97;}

                        else if ( ((LA17_86>='0' && LA17_86<='9')||(LA17_86>='A' && LA17_86<='F')||(LA17_86>='a' && LA17_86<='f')) ) {s = 86;}

                        else if ( ((LA17_86>='\u0000' && LA17_86<='/')||LA17_86==':'||(LA17_86>='<' && LA17_86<='@')||(LA17_86>='G' && LA17_86<='`')||(LA17_86>='g' && LA17_86<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_58 = input.LA(1);

                        s = -1;
                        if ( (LA17_58=='-'||(LA17_58>='0' && LA17_58<='9')||(LA17_58>='@' && LA17_58<='Z')||LA17_58=='_'||(LA17_58>='a' && LA17_58<='z')) ) {s = 72;}

                        else if ( (LA17_58==';') ) {s = 73;}

                        else if ( ((LA17_58>='\u0000' && LA17_58<=',')||(LA17_58>='.' && LA17_58<='/')||LA17_58==':'||(LA17_58>='<' && LA17_58<='?')||(LA17_58>='[' && LA17_58<='^')||LA17_58=='`'||(LA17_58>='{' && LA17_58<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_38 = input.LA(1);

                        s = -1;
                        if ( (LA17_38=='\'') ) {s = 40;}

                        else if ( ((LA17_38>='\u0000' && LA17_38<='%')||(LA17_38>='(' && LA17_38<=';')||(LA17_38>='=' && LA17_38<='\uFFFF')) ) {s = 38;}

                        else if ( (LA17_38=='&') ) {s = 39;}

                        else if ( (LA17_38=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_77 = input.LA(1);

                        s = -1;
                        if ( (LA17_77=='\"') ) {s = 44;}

                        else if ( ((LA17_77>='\u0000' && LA17_77<='!')||(LA17_77>='#' && LA17_77<='%')||(LA17_77>='\'' && LA17_77<=';')||(LA17_77>='=' && LA17_77<='\uFFFF')) ) {s = 43;}

                        else if ( (LA17_77=='&') ) {s = 45;}

                        else if ( (LA17_77=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_59 = input.LA(1);

                        s = -1;
                        if ( (LA17_59=='x') ) {s = 74;}

                        else if ( ((LA17_59>='0' && LA17_59<='9')) ) {s = 75;}

                        else if ( ((LA17_59>='\u0000' && LA17_59<='/')||(LA17_59>=':' && LA17_59<='w')||(LA17_59>='y' && LA17_59<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_97 = input.LA(1);

                        s = -1;
                        if ( (LA17_97=='\"') ) {s = 44;}

                        else if ( ((LA17_97>='\u0000' && LA17_97<='!')||(LA17_97>='#' && LA17_97<='%')||(LA17_97>='\'' && LA17_97<=';')||(LA17_97>='=' && LA17_97<='\uFFFF')) ) {s = 43;}

                        else if ( (LA17_97=='&') ) {s = 45;}

                        else if ( (LA17_97=='<') ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_71 = input.LA(1);

                        s = -1;
                        if ( (LA17_71==';') ) {s = 85;}

                        else if ( ((LA17_71>='0' && LA17_71<='9')) ) {s = 71;}

                        else if ( ((LA17_71>='\u0000' && LA17_71<='/')||LA17_71==':'||(LA17_71>='<' && LA17_71<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
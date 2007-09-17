// $ANTLR 3.0.1 DTD.g 2007-09-13 13:36:52

//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDLexer.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

package org.xerial.util.xml.dtd;
import org.xerial.util.log.Logger;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DTDLexer extends Lexer {
    public static final int CharRef=26;
    public static final int Apos=10;
    public static final int DefaultDecl=27;
    public static final int T29=29;
    public static final int EOF=-1;
    public static final int AttValue=24;
    public static final int ML_COMMENT=6;
    public static final int Digits=18;
    public static final int WhiteSpaceChar=20;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int Reference=23;
    public static final int T36=36;
    public static final int T35=35;
    public static final int Quot=11;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int SemiColon=13;
    public static final int RParen=15;
    public static final int At=7;
    public static final int LParen=14;
    public static final int NUMBER=4;
    public static final int NameChar=19;
    public static final int Colon=8;
    public static final int Digit=17;
    public static final int T43=43;
    public static final int Tokens=47;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int EntityRef=25;
    public static final int T46=46;
    public static final int T45=45;
    public static final int T44=44;
    public static final int StringLiteral=21;
    public static final int Name=22;
    public static final int Dot=12;
    public static final int Comma=9;
    public static final int Letter=16;
    public static final int Element=28;
    public static final int STRING=5;
    public DTDLexer() {;} 
    public DTDLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "DTD.g"; }

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // DTD.g:25:5: ( '>' )
            // DTD.g:25:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // DTD.g:26:5: ( 'EMPTY' )
            // DTD.g:26:7: 'EMPTY'
            {
            match("EMPTY"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // DTD.g:27:5: ( 'ANY' )
            // DTD.g:27:7: 'ANY'
            {
            match("ANY"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // DTD.g:28:5: ( '?' )
            // DTD.g:28:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // DTD.g:29:5: ( '*' )
            // DTD.g:29:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // DTD.g:30:5: ( '+' )
            // DTD.g:30:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // DTD.g:31:5: ( '|' )
            // DTD.g:31:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // DTD.g:32:5: ( '#PCDATA' )
            // DTD.g:32:7: '#PCDATA'
            {
            match("#PCDATA"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // DTD.g:33:5: ( '<!ATTLIST' )
            // DTD.g:33:7: '<!ATTLIST'
            {
            match("<!ATTLIST"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // DTD.g:34:5: ( 'NOTATION' )
            // DTD.g:34:7: 'NOTATION'
            {
            match("NOTATION"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // DTD.g:35:5: ( 'CDATA' )
            // DTD.g:35:7: 'CDATA'
            {
            match("CDATA"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // DTD.g:36:5: ( 'ID' )
            // DTD.g:36:7: 'ID'
            {
            match("ID"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // DTD.g:37:5: ( 'IDREF' )
            // DTD.g:37:7: 'IDREF'
            {
            match("IDREF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // DTD.g:38:5: ( 'IDREFS' )
            // DTD.g:38:7: 'IDREFS'
            {
            match("IDREFS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // DTD.g:39:5: ( 'ENTITY' )
            // DTD.g:39:7: 'ENTITY'
            {
            match("ENTITY"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // DTD.g:40:5: ( 'ENTITIES' )
            // DTD.g:40:7: 'ENTITIES'
            {
            match("ENTITIES"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // DTD.g:41:5: ( 'NMTOKEN' )
            // DTD.g:41:7: 'NMTOKEN'
            {
            match("NMTOKEN"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // DTD.g:42:5: ( 'NMTOKENS' )
            // DTD.g:42:7: 'NMTOKENS'
            {
            match("NMTOKENS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // DTD.g:68:5: ( '<!--' ( options {greedy=false; } : . )* '-->' )
            // DTD.g:68:9: '<!--' ( options {greedy=false; } : . )* '-->'
            {
            match("<!--"); 

            // DTD.g:68:16: ( options {greedy=false; } : . )*
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
                        else if ( ((LA1_3>='\u0000' && LA1_3<='=')||(LA1_3>='?' && LA1_3<='\uFFFE')) ) {
                            alt1=1;
                        }


                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<=',')||(LA1_1>='.' && LA1_1<='\uFFFE')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=',')||(LA1_0>='.' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // DTD.g:68:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("-->"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start At
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            // DTD.g:71:3: ( '@' )
            // DTD.g:71:5: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end At

    // $ANTLR start Colon
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            // DTD.g:72:6: ( ':' )
            // DTD.g:72:8: ':'
            {
            match(':'); 

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
            // DTD.g:73:6: ( ',' )
            // DTD.g:73:8: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Comma

    // $ANTLR start Apos
    public final void mApos() throws RecognitionException {
        try {
            int _type = Apos;
            // DTD.g:74:5: ( '\\'' )
            // DTD.g:74:7: '\\''
            {
            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Apos

    // $ANTLR start Quot
    public final void mQuot() throws RecognitionException {
        try {
            int _type = Quot;
            // DTD.g:75:5: ( '\"' )
            // DTD.g:75:7: '\"'
            {
            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Quot

    // $ANTLR start Dot
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            // DTD.g:76:4: ( '.' )
            // DTD.g:76:6: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Dot

    // $ANTLR start SemiColon
    public final void mSemiColon() throws RecognitionException {
        try {
            int _type = SemiColon;
            // DTD.g:77:10: ( ';' )
            // DTD.g:77:12: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SemiColon

    // $ANTLR start LParen
    public final void mLParen() throws RecognitionException {
        try {
            int _type = LParen;
            // DTD.g:79:7: ( '(' )
            // DTD.g:79:9: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LParen

    // $ANTLR start RParen
    public final void mRParen() throws RecognitionException {
        try {
            int _type = RParen;
            // DTD.g:80:7: ( ')' )
            // DTD.g:80:9: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RParen

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // DTD.g:82:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // DTD.g:
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
            // DTD.g:83:15: ( '0' .. '9' )
            // DTD.g:83:17: '0' .. '9'
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
            // DTD.g:84:7: ( ( Digit )+ )
            // DTD.g:84:9: ( Digit )+
            {
            // DTD.g:84:9: ( Digit )+
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
            	    // DTD.g:84:10: Digit
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Digits

    // $ANTLR start NameChar
    public final void mNameChar() throws RecognitionException {
        try {
            // DTD.g:86:18: ( Letter | Digit | '_' | '-' | At )
            // DTD.g:
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
            // DTD.g:88:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // DTD.g:88:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // DTD.g:88:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
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
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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
            // DTD.g:91:1: ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos )
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
                    new NoViableAltException("90:1: StringLiteral : ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // DTD.g:91:3: Quot (~ '\"' )* Quot
                    {
                    mQuot(); 
                    // DTD.g:91:9: (~ '\"' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFE')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // DTD.g:91:10: ~ '\"'
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
                    	    break loop4;
                        }
                    } while (true);

                    mQuot(); 

                    }
                    break;
                case 2 :
                    // DTD.g:92:3: Apos (~ '\\'' )* Apos
                    {
                    mApos(); 
                    // DTD.g:92:9: (~ '\\'' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFE')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // DTD.g:92:10: ~ '\\''
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
                    	    break loop5;
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
            int _type = Name;
            // DTD.g:94:5: ( ( Letter | '_' ) ( NameChar )* )
            // DTD.g:94:7: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // DTD.g:94:22: ( NameChar )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')||(LA7_0>='@' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // DTD.g:94:22: NameChar
            	    {
            	    mNameChar(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Name

    // $ANTLR start AttValue
    public final void mAttValue() throws RecognitionException {
        try {
            // DTD.g:97:18: ( Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot | Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos )
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
                    new NoViableAltException("97:10: fragment AttValue : ( Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot | Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // DTD.g:98:5: Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot
                    {
                    mQuot(); 
                    // DTD.g:98:10: (~ ( '<' | '&' | Quot ) | Reference )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='%')||(LA8_0>='\'' && LA8_0<=';')||(LA8_0>='=' && LA8_0<='\uFFFE')) ) {
                            alt8=1;
                        }
                        else if ( (LA8_0=='&') ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // DTD.g:98:11: ~ ( '<' | '&' | Quot )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='\'' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // DTD.g:98:33: Reference
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
                    // DTD.g:99:7: Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos
                    {
                    mApos(); 
                    // DTD.g:99:12: (~ ( '<' | '&' | Apos ) | Reference )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='\u0000' && LA9_0<='%')||(LA9_0>='(' && LA9_0<=';')||(LA9_0>='=' && LA9_0<='\uFFFE')) ) {
                            alt9=1;
                        }
                        else if ( (LA9_0=='&') ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // DTD.g:99:13: ~ ( '<' | '&' | Apos )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='%')||(input.LA(1)>='(' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // DTD.g:99:35: Reference
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
    // $ANTLR end AttValue

    // $ANTLR start Reference
    public final void mReference() throws RecognitionException {
        try {
            int _type = Reference;
            // DTD.g:102:10: ( EntityRef | CharRef )
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
                        new NoViableAltException("102:1: Reference : ( EntityRef | CharRef );", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("102:1: Reference : ( EntityRef | CharRef );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // DTD.g:102:12: EntityRef
                    {
                    mEntityRef(); 

                    }
                    break;
                case 2 :
                    // DTD.g:102:24: CharRef
                    {
                    mCharRef(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Reference

    // $ANTLR start EntityRef
    public final void mEntityRef() throws RecognitionException {
        try {
            // DTD.g:103:19: ( '&' Name SemiColon )
            // DTD.g:103:21: '&' Name SemiColon
            {
            match('&'); 
            mName(); 
            mSemiColon(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end EntityRef

    // $ANTLR start CharRef
    public final void mCharRef() throws RecognitionException {
        try {
            // DTD.g:104:17: ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon )
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
                            new NoViableAltException("104:10: fragment CharRef : ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon );", 14, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("104:10: fragment CharRef : ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon );", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("104:10: fragment CharRef : ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // DTD.g:104:19: '&#' ( '0' .. '9' )+ SemiColon
                    {
                    match("&#"); 

                    // DTD.g:104:24: ( '0' .. '9' )+
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
                    	    // DTD.g:104:25: '0' .. '9'
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
                    // DTD.g:104:48: '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon
                    {
                    match("&#x"); 

                    // DTD.g:104:54: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


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
    // $ANTLR end CharRef

    // $ANTLR start DefaultDecl
    public final void mDefaultDecl() throws RecognitionException {
        try {
            int _type = DefaultDecl;
            // DTD.g:107:12: ( '#REQUIRED' | '#IMPLIED' | ( ( '#FIXED' )? AttValue ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='#') ) {
                switch ( input.LA(2) ) {
                case 'R':
                    {
                    alt16=1;
                    }
                    break;
                case 'F':
                    {
                    alt16=3;
                    }
                    break;
                case 'I':
                    {
                    alt16=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("107:1: DefaultDecl : ( '#REQUIRED' | '#IMPLIED' | ( ( '#FIXED' )? AttValue ) );", 16, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA16_0=='\"'||LA16_0=='\'') ) {
                alt16=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("107:1: DefaultDecl : ( '#REQUIRED' | '#IMPLIED' | ( ( '#FIXED' )? AttValue ) );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // DTD.g:107:14: '#REQUIRED'
                    {
                    match("#REQUIRED"); 


                    }
                    break;
                case 2 :
                    // DTD.g:107:28: '#IMPLIED'
                    {
                    match("#IMPLIED"); 


                    }
                    break;
                case 3 :
                    // DTD.g:107:41: ( ( '#FIXED' )? AttValue )
                    {
                    // DTD.g:107:41: ( ( '#FIXED' )? AttValue )
                    // DTD.g:107:42: ( '#FIXED' )? AttValue
                    {
                    // DTD.g:107:42: ( '#FIXED' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='#') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // DTD.g:107:42: '#FIXED'
                            {
                            match("#FIXED"); 


                            }
                            break;

                    }

                    mAttValue(); 

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DefaultDecl

    // $ANTLR start Element
    public final void mElement() throws RecognitionException {
        try {
            int _type = Element;
            // DTD.g:109:8: ( '<!ELEMENT' )
            // DTD.g:109:10: '<!ELEMENT'
            {
            match("<!ELEMENT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Element

    public void mTokens() throws RecognitionException {
        // DTD.g:1:8: ( T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | StringLiteral | Name | Reference | DefaultDecl | Element )
        int alt17=35;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // DTD.g:1:10: T29
                {
                mT29(); 

                }
                break;
            case 2 :
                // DTD.g:1:14: T30
                {
                mT30(); 

                }
                break;
            case 3 :
                // DTD.g:1:18: T31
                {
                mT31(); 

                }
                break;
            case 4 :
                // DTD.g:1:22: T32
                {
                mT32(); 

                }
                break;
            case 5 :
                // DTD.g:1:26: T33
                {
                mT33(); 

                }
                break;
            case 6 :
                // DTD.g:1:30: T34
                {
                mT34(); 

                }
                break;
            case 7 :
                // DTD.g:1:34: T35
                {
                mT35(); 

                }
                break;
            case 8 :
                // DTD.g:1:38: T36
                {
                mT36(); 

                }
                break;
            case 9 :
                // DTD.g:1:42: T37
                {
                mT37(); 

                }
                break;
            case 10 :
                // DTD.g:1:46: T38
                {
                mT38(); 

                }
                break;
            case 11 :
                // DTD.g:1:50: T39
                {
                mT39(); 

                }
                break;
            case 12 :
                // DTD.g:1:54: T40
                {
                mT40(); 

                }
                break;
            case 13 :
                // DTD.g:1:58: T41
                {
                mT41(); 

                }
                break;
            case 14 :
                // DTD.g:1:62: T42
                {
                mT42(); 

                }
                break;
            case 15 :
                // DTD.g:1:66: T43
                {
                mT43(); 

                }
                break;
            case 16 :
                // DTD.g:1:70: T44
                {
                mT44(); 

                }
                break;
            case 17 :
                // DTD.g:1:74: T45
                {
                mT45(); 

                }
                break;
            case 18 :
                // DTD.g:1:78: T46
                {
                mT46(); 

                }
                break;
            case 19 :
                // DTD.g:1:82: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 20 :
                // DTD.g:1:93: At
                {
                mAt(); 

                }
                break;
            case 21 :
                // DTD.g:1:96: Colon
                {
                mColon(); 

                }
                break;
            case 22 :
                // DTD.g:1:102: Comma
                {
                mComma(); 

                }
                break;
            case 23 :
                // DTD.g:1:108: Apos
                {
                mApos(); 

                }
                break;
            case 24 :
                // DTD.g:1:113: Quot
                {
                mQuot(); 

                }
                break;
            case 25 :
                // DTD.g:1:118: Dot
                {
                mDot(); 

                }
                break;
            case 26 :
                // DTD.g:1:122: SemiColon
                {
                mSemiColon(); 

                }
                break;
            case 27 :
                // DTD.g:1:132: LParen
                {
                mLParen(); 

                }
                break;
            case 28 :
                // DTD.g:1:139: RParen
                {
                mRParen(); 

                }
                break;
            case 29 :
                // DTD.g:1:146: Digits
                {
                mDigits(); 

                }
                break;
            case 30 :
                // DTD.g:1:153: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 31 :
                // DTD.g:1:168: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 32 :
                // DTD.g:1:182: Name
                {
                mName(); 

                }
                break;
            case 33 :
                // DTD.g:1:187: Reference
                {
                mReference(); 

                }
                break;
            case 34 :
                // DTD.g:1:197: DefaultDecl
                {
                mDefaultDecl(); 

                }
                break;
            case 35 :
                // DTD.g:1:209: Element
                {
                mElement(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\2\uffff\2\30\6\uffff\3\30\3\uffff\1\44\1\51\10\uffff\3\30\3\uffff"+
        "\3\30\1\67\11\uffff\2\30\1\76\3\uffff\4\30\5\uffff\2\30\1\uffff"+
        "\4\30\10\uffff\1\30\1\127\2\30\1\132\1\134\4\uffff\1\30\1\140\1"+
        "\uffff\2\30\1\uffff\1\143\3\uffff\1\30\1\uffff\1\30\1\147\1\uffff"+
        "\1\150\1\151\1\152\4\uffff";
    static final String DFA17_eofS =
        "\153\uffff";
    static final String DFA17_minS =
        "\1\11\1\uffff\1\115\1\116\4\uffff\1\106\1\41\1\115\2\104\3\uffff"+
        "\2\0\10\uffff\1\124\1\120\1\131\2\uffff\1\55\2\124\1\101\1\55\1"+
        "\uffff\1\0\1\uffff\1\0\2\uffff\1\0\1\uffff\1\0\1\111\1\124\1\55"+
        "\3\uffff\1\101\1\117\1\124\1\105\1\uffff\4\0\1\124\1\131\1\uffff"+
        "\1\124\1\113\1\101\1\106\10\0\1\111\1\55\1\111\1\105\2\55\4\0\1"+
        "\105\1\55\1\uffff\1\117\1\116\1\uffff\1\55\1\uffff\2\0\1\123\1\uffff"+
        "\1\116\1\55\1\uffff\3\55\4\uffff";
    static final String DFA17_maxS =
        "\1\174\1\uffff\2\116\4\uffff\1\122\1\41\1\117\2\104\3\uffff\2\ufffe"+
        "\10\uffff\1\124\1\120\1\131\2\uffff\1\105\2\124\1\101\1\172\1\uffff"+
        "\1\ufffe\1\uffff\1\ufffe\2\uffff\1\ufffe\1\uffff\1\ufffe\1\111\1"+
        "\124\1\172\3\uffff\1\101\1\117\1\124\1\105\1\uffff\4\ufffe\1\124"+
        "\1\131\1\uffff\1\124\1\113\1\101\1\106\10\ufffe\1\131\1\172\1\111"+
        "\1\105\2\172\4\ufffe\1\105\1\172\1\uffff\1\117\1\116\1\uffff\1\172"+
        "\1\uffff\2\ufffe\1\123\1\uffff\1\116\1\172\1\uffff\3\172\4\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\5\uffff\1\24\1\25\1\26\2\uffff"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\40\1\41\3\uffff\1\10\1\42\5\uffff"+
        "\1\27\1\uffff\1\37\1\uffff\1\37\1\30\1\uffff\1\37\4\uffff\1\11\1"+
        "\23\1\43\4\uffff\1\14\6\uffff\1\3\30\uffff\1\2\2\uffff\1\13\1\uffff"+
        "\1\15\3\uffff\1\17\2\uffff\1\16\3\uffff\1\21\1\20\1\12\1\22";
    static final String DFA17_specialS =
        "\153\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\27\1\uffff\2\27\22\uffff\1\27\1\uffff\1\21\1\10\2\uffff\1"+
            "\31\1\20\1\24\1\25\1\5\1\6\1\17\1\uffff\1\22\1\uffff\12\26\1"+
            "\16\1\23\1\11\1\uffff\1\1\1\4\1\15\1\3\1\30\1\13\1\30\1\2\3"+
            "\30\1\14\4\30\1\12\14\30\4\uffff\1\30\1\uffff\32\30\1\uffff"+
            "\1\7",
            "",
            "\1\33\1\32",
            "\1\34",
            "",
            "",
            "",
            "",
            "\1\36\2\uffff\1\36\6\uffff\1\35\1\uffff\1\36",
            "\1\37",
            "\1\41\1\uffff\1\40",
            "\1\42",
            "\1\43",
            "",
            "",
            "",
            "\46\45\1\47\1\46\24\45\1\50\uffc2\45",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc2\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "",
            "\1\61\23\uffff\1\60\3\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\30\2\uffff\12\30\6\uffff\22\30\1\66\10\30\4\uffff\1\30\1"+
            "\uffff\32\30",
            "",
            "\46\45\1\47\1\46\24\45\1\50\uffc2\45",
            "",
            "\43\50\1\70\35\50\32\71\4\50\1\71\1\50\32\71\uff84\50",
            "",
            "",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc2\52",
            "",
            "\43\50\1\72\35\50\32\73\4\50\1\73\1\50\32\73\uff84\50",
            "\1\74",
            "\1\75",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "",
            "\60\50\12\104\76\50\1\103\uff86\50",
            "\55\50\1\105\2\50\12\105\1\50\1\106\4\50\33\105\4\50\1\105\1"+
            "\50\32\105\uff84\50",
            "\60\50\12\110\76\50\1\107\uff86\50",
            "\55\50\1\111\2\50\12\111\1\50\1\112\4\50\33\111\4\50\1\111\1"+
            "\50\32\111\uff84\50",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\60\50\12\121\7\50\6\121\32\50\6\121\uff98\50",
            "\60\50\12\104\1\50\1\122\uffc3\50",
            "\55\50\1\105\2\50\12\105\1\50\1\106\4\50\33\105\4\50\1\105\1"+
            "\50\32\105\uff84\50",
            "\46\45\1\47\1\46\24\45\1\50\uffc2\45",
            "\60\50\12\123\7\50\6\123\32\50\6\123\uff98\50",
            "\60\50\12\110\1\50\1\124\uffc3\50",
            "\55\50\1\111\2\50\12\111\1\50\1\112\4\50\33\111\4\50\1\111\1"+
            "\50\32\111\uff84\50",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc2\52",
            "\1\125\17\uffff\1\126",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "\1\130",
            "\1\131",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "\1\30\2\uffff\12\30\6\uffff\23\30\1\133\7\30\4\uffff\1\30\1"+
            "\uffff\32\30",
            "\60\50\12\121\1\50\1\135\5\50\6\121\32\50\6\121\uff98\50",
            "\46\45\1\47\1\46\24\45\1\50\uffc2\45",
            "\60\50\12\123\1\50\1\136\5\50\6\123\32\50\6\123\uff98\50",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc2\52",
            "\1\137",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\141",
            "\1\142",
            "",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\46\45\1\47\1\46\24\45\1\50\uffc2\45",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc2\52",
            "\1\144",
            "",
            "\1\145",
            "\1\30\2\uffff\12\30\6\uffff\23\30\1\146\7\30\4\uffff\1\30\1"+
            "\uffff\32\30",
            "",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32\30",
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
            return "1:1: Tokens : ( T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | StringLiteral | Name | Reference | DefaultDecl | Element );";
        }
    }
 

}
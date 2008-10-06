// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g 2008-10-06 10:58:13

//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDLexer.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------

package org.xerial.util.xml.dtd.impl;
import org.xerial.util.log.Logger;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DTDLexer extends Lexer {
    public static final int CharRef=26;
    public static final int T__29=29;
    public static final int DefaultDecl=27;
    public static final int Apos=10;
    public static final int EOF=-1;
    public static final int AttValue=24;
    public static final int ML_COMMENT=6;
    public static final int Digits=18;
    public static final int WhiteSpaceChar=20;
    public static final int Reference=23;
    public static final int Quot=11;
    public static final int T__42=42;
    public static final int SemiColon=13;
    public static final int T__43=43;
    public static final int RParen=15;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__44=44;
    public static final int At=7;
    public static final int T__45=45;
    public static final int LParen=14;
    public static final int NUMBER=4;
    public static final int NameChar=19;
    public static final int Colon=8;
    public static final int Digit=17;
    public static final int EntityRef=25;
    public static final int StringLiteral=21;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int Dot=12;
    public static final int Name=22;
    public static final int Comma=9;
    public static final int Letter=16;
    public static final int STRING=5;
    public static final int Element=28;

    // delegates
    // delegators

    public DTDLexer() {;} 
    public DTDLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DTDLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g"; }

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:26:7: ( '>' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:26:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:27:7: ( 'EMPTY' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:27:9: 'EMPTY'
            {
            match("EMPTY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:28:7: ( 'ANY' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:28:9: 'ANY'
            {
            match("ANY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:29:7: ( '?' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:29:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:30:7: ( '*' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:30:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:31:7: ( '+' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:31:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:32:7: ( '|' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:32:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:33:7: ( '#PCDATA' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:33:9: '#PCDATA'
            {
            match("#PCDATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:34:7: ( '<!ATTLIST' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:34:9: '<!ATTLIST'
            {
            match("<!ATTLIST"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:35:7: ( 'NOTATION' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:35:9: 'NOTATION'
            {
            match("NOTATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:36:7: ( 'CDATA' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:36:9: 'CDATA'
            {
            match("CDATA"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:37:7: ( 'ID' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:37:9: 'ID'
            {
            match("ID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:38:7: ( 'IDREF' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:38:9: 'IDREF'
            {
            match("IDREF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:39:7: ( 'IDREFS' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:39:9: 'IDREFS'
            {
            match("IDREFS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:40:7: ( 'ENTITY' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:40:9: 'ENTITY'
            {
            match("ENTITY"); 


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:41:7: ( 'ENTITIES' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:41:9: 'ENTITIES'
            {
            match("ENTITIES"); 


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:42:7: ( 'NMTOKEN' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:42:9: 'NMTOKEN'
            {
            match("NMTOKEN"); 


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:43:7: ( 'NMTOKENS' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:43:9: 'NMTOKENS'
            {
            match("NMTOKENS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:70:5: ( '<!--' ( options {greedy=false; } : . )* '-->' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:70:9: '<!--' ( options {greedy=false; } : . )* '-->'
            {
            match("<!--"); 

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:70:16: ( options {greedy=false; } : . )*
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:70:43: .
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:73:3: ( '@' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:73:5: '@'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:74:6: ( ':' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:74:8: ':'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:75:6: ( ',' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:75:8: ','
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:76:5: ( '\\'' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:76:7: '\\''
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:77:5: ( '\"' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:77:7: '\"'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:78:4: ( '.' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:78:6: '.'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:79:10: ( ';' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:79:12: ';'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:81:7: ( '(' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:81:9: '('
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:82:7: ( ')' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:82:9: ')'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:84:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:85:15: ( '0' .. '9' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:85:17: '0' .. '9'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:86:7: ( ( Digit )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:86:9: ( Digit )+
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:86:9: ( Digit )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:86:10: Digit
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:88:18: ( Letter | Digit | '_' | '-' | At )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:90:15: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:90:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:90:17: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u000C' )+
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
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
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

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:93:1: ( Quot (~ '\"' )* Quot | Apos (~ '\\'' )* Apos )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:93:3: Quot (~ '\"' )* Quot
                    {
                    mQuot(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:93:9: (~ '\"' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:93:10: ~ '\"'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:94:3: Apos (~ '\\'' )* Apos
                    {
                    mApos(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:94:9: (~ '\\'' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:94:10: ~ '\\''
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
    // $ANTLR end "StringLiteral"

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            int _type = Name;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:96:5: ( ( Letter | '_' ) ( NameChar )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:96:7: ( Letter | '_' ) ( NameChar )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:96:22: ( NameChar )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')||(LA7_0>='@' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:96:22: NameChar
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:99:18: ( Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot | Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:100:5: Quot (~ ( '<' | '&' | Quot ) | Reference )* Quot
                    {
                    mQuot(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:100:10: (~ ( '<' | '&' | Quot ) | Reference )*
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:100:11: ~ ( '<' | '&' | Quot )
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:100:33: Reference
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:101:7: Apos (~ ( '<' | '&' | Apos ) | Reference )* Apos
                    {
                    mApos(); 
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:101:12: (~ ( '<' | '&' | Apos ) | Reference )*
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:101:13: ~ ( '<' | '&' | Apos )
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:101:35: Reference
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:104:10: ( EntityRef | CharRef )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:104:12: EntityRef
                    {
                    mEntityRef(); 

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:104:24: CharRef
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:105:19: ( '&' Name SemiColon )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:105:21: '&' Name SemiColon
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:17: ( '&#' ( '0' .. '9' )+ SemiColon | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:19: '&#' ( '0' .. '9' )+ SemiColon
                    {
                    match("&#"); 

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:24: ( '0' .. '9' )+
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:25: '0' .. '9'
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:48: '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ SemiColon
                    {
                    match("&#x"); 

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:106:54: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:12: ( '#REQUIRED' | '#IMPLIED' | ( ( '#FIXED' )? AttValue ) )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:14: '#REQUIRED'
                    {
                    match("#REQUIRED"); 


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:28: '#IMPLIED'
                    {
                    match("#IMPLIED"); 


                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:41: ( ( '#FIXED' )? AttValue )
                    {
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:41: ( ( '#FIXED' )? AttValue )
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:42: ( '#FIXED' )? AttValue
                    {
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:42: ( '#FIXED' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='#') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:109:42: '#FIXED'
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:111:8: ( '<!ELEMENT' )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:111:10: '<!ELEMENT'
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
        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:8: ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | StringLiteral | Name | Reference | DefaultDecl | Element )
        int alt17=35;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:10: T__29
                {
                mT__29(); 

                }
                break;
            case 2 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:16: T__30
                {
                mT__30(); 

                }
                break;
            case 3 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:22: T__31
                {
                mT__31(); 

                }
                break;
            case 4 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:28: T__32
                {
                mT__32(); 

                }
                break;
            case 5 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:34: T__33
                {
                mT__33(); 

                }
                break;
            case 6 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:40: T__34
                {
                mT__34(); 

                }
                break;
            case 7 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:46: T__35
                {
                mT__35(); 

                }
                break;
            case 8 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:52: T__36
                {
                mT__36(); 

                }
                break;
            case 9 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:58: T__37
                {
                mT__37(); 

                }
                break;
            case 10 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:64: T__38
                {
                mT__38(); 

                }
                break;
            case 11 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:70: T__39
                {
                mT__39(); 

                }
                break;
            case 12 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:76: T__40
                {
                mT__40(); 

                }
                break;
            case 13 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:82: T__41
                {
                mT__41(); 

                }
                break;
            case 14 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:88: T__42
                {
                mT__42(); 

                }
                break;
            case 15 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:94: T__43
                {
                mT__43(); 

                }
                break;
            case 16 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:100: T__44
                {
                mT__44(); 

                }
                break;
            case 17 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:106: T__45
                {
                mT__45(); 

                }
                break;
            case 18 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:112: T__46
                {
                mT__46(); 

                }
                break;
            case 19 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:118: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 20 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:129: At
                {
                mAt(); 

                }
                break;
            case 21 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:132: Colon
                {
                mColon(); 

                }
                break;
            case 22 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:138: Comma
                {
                mComma(); 

                }
                break;
            case 23 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:144: Apos
                {
                mApos(); 

                }
                break;
            case 24 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:149: Quot
                {
                mQuot(); 

                }
                break;
            case 25 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:154: Dot
                {
                mDot(); 

                }
                break;
            case 26 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:158: SemiColon
                {
                mSemiColon(); 

                }
                break;
            case 27 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:168: LParen
                {
                mLParen(); 

                }
                break;
            case 28 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:175: RParen
                {
                mRParen(); 

                }
                break;
            case 29 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:182: Digits
                {
                mDigits(); 

                }
                break;
            case 30 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:189: WhiteSpaceChar
                {
                mWhiteSpaceChar(); 

                }
                break;
            case 31 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:204: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 32 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:218: Name
                {
                mName(); 

                }
                break;
            case 33 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:223: Reference
                {
                mReference(); 

                }
                break;
            case 34 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:233: DefaultDecl
                {
                mDefaultDecl(); 

                }
                break;
            case 35 :
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:1:245: Element
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
        "\4\30\10\uffff\1\125\3\30\1\132\1\134\5\uffff\1\137\3\30\1\uffff"+
        "\1\143\4\uffff\2\30\1\147\1\uffff\1\150\1\151\1\152\4\uffff";
    static final String DFA17_eofS =
        "\153\uffff";
    static final String DFA17_minS =
        "\1\11\1\uffff\1\115\1\116\4\uffff\1\106\1\41\1\115\2\104\3\uffff"+
        "\2\0\10\uffff\1\120\1\124\1\131\2\uffff\1\55\2\124\1\101\1\55\1"+
        "\uffff\1\0\1\uffff\1\0\2\uffff\1\0\1\uffff\1\0\1\124\1\111\1\55"+
        "\3\uffff\1\101\1\117\1\124\1\105\1\uffff\4\0\1\131\1\124\1\uffff"+
        "\1\124\1\113\1\101\1\106\10\0\1\55\2\111\1\105\2\55\4\0\1\uffff"+
        "\1\55\1\105\1\117\1\116\1\uffff\1\55\1\uffff\2\0\1\uffff\1\123\1"+
        "\116\1\55\1\uffff\3\55\4\uffff";
    static final String DFA17_maxS =
        "\1\174\1\uffff\2\116\4\uffff\1\122\1\41\1\117\2\104\3\uffff\2\uffff"+
        "\10\uffff\1\120\1\124\1\131\2\uffff\1\105\2\124\1\101\1\172\1\uffff"+
        "\1\uffff\1\uffff\1\uffff\2\uffff\1\uffff\1\uffff\1\uffff\1\124\1"+
        "\111\1\172\3\uffff\1\101\1\117\1\124\1\105\1\uffff\4\uffff\1\131"+
        "\1\124\1\uffff\1\124\1\113\1\101\1\106\10\uffff\1\172\1\131\1\111"+
        "\1\105\2\172\4\uffff\1\uffff\1\172\1\105\1\117\1\116\1\uffff\1\172"+
        "\1\uffff\2\uffff\1\uffff\1\123\1\116\1\172\1\uffff\3\172\4\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\5\uffff\1\24\1\25\1\26\2\uffff"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\40\1\41\3\uffff\1\10\1\42\5\uffff"+
        "\1\27\1\uffff\1\37\1\uffff\1\37\1\30\1\uffff\1\37\4\uffff\1\11\1"+
        "\23\1\43\4\uffff\1\14\6\uffff\1\3\26\uffff\1\2\4\uffff\1\13\1\uffff"+
        "\1\15\2\uffff\1\17\3\uffff\1\16\3\uffff\1\21\1\20\1\12\1\22";
    static final String DFA17_specialS =
        "\20\uffff\1\14\1\6\23\uffff\1\20\1\uffff\1\5\2\uffff\1\0\1\uffff"+
        "\1\13\13\uffff\1\23\1\17\1\21\1\11\7\uffff\1\27\1\1\1\16\1\15\1"+
        "\12\1\4\1\22\1\26\6\uffff\1\7\1\25\1\2\1\3\10\uffff\1\24\1\10\14"+
        "\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\27\1\uffff\2\27\22\uffff\1\27\1\uffff\1\21\1\10\2\uffff"+
            "\1\31\1\20\1\24\1\25\1\5\1\6\1\17\1\uffff\1\22\1\uffff\12\26"+
            "\1\16\1\23\1\11\1\uffff\1\1\1\4\1\15\1\3\1\30\1\13\1\30\1\2"+
            "\3\30\1\14\4\30\1\12\14\30\4\uffff\1\30\1\uffff\32\30\1\uffff"+
            "\1\7",
            "",
            "\1\32\1\33",
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
            "\46\45\1\47\1\46\24\45\1\50\uffc3\45",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc3\52",
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
            "\1\30\2\uffff\12\30\6\uffff\22\30\1\66\10\30\4\uffff\1\30"+
            "\1\uffff\32\30",
            "",
            "\46\45\1\47\1\46\24\45\1\50\uffc3\45",
            "",
            "\43\50\1\70\35\50\32\71\4\50\1\71\1\50\32\71\uff85\50",
            "",
            "",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc3\52",
            "",
            "\43\50\1\72\35\50\32\73\4\50\1\73\1\50\32\73\uff85\50",
            "\1\74",
            "\1\75",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "",
            "\60\50\12\104\76\50\1\103\uff87\50",
            "\55\50\1\105\2\50\12\105\1\50\1\106\4\50\33\105\4\50\1\105"+
            "\1\50\32\105\uff85\50",
            "\60\50\12\110\76\50\1\107\uff87\50",
            "\55\50\1\111\2\50\12\111\1\50\1\112\4\50\33\111\4\50\1\111"+
            "\1\50\32\111\uff85\50",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\60\50\12\121\7\50\6\121\32\50\6\121\uff99\50",
            "\60\50\12\104\1\50\1\122\uffc4\50",
            "\55\50\1\105\2\50\12\105\1\50\1\106\4\50\33\105\4\50\1\105"+
            "\1\50\32\105\uff85\50",
            "\46\45\1\47\1\46\24\45\1\50\uffc3\45",
            "\60\50\12\123\7\50\6\123\32\50\6\123\uff99\50",
            "\60\50\12\110\1\50\1\124\uffc4\50",
            "\55\50\1\111\2\50\12\111\1\50\1\112\4\50\33\111\4\50\1\111"+
            "\1\50\32\111\uff85\50",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc3\52",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\127\17\uffff\1\126",
            "\1\130",
            "\1\131",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\30\2\uffff\12\30\6\uffff\23\30\1\133\7\30\4\uffff\1\30"+
            "\1\uffff\32\30",
            "\60\50\12\121\1\50\1\135\5\50\6\121\32\50\6\121\uff99\50",
            "\46\45\1\47\1\46\24\45\1\50\uffc3\45",
            "\60\50\12\123\1\50\1\136\5\50\6\123\32\50\6\123\uff99\50",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc3\52",
            "",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "",
            "\46\45\1\47\1\46\24\45\1\50\uffc3\45",
            "\42\52\1\53\3\52\1\54\25\52\1\50\uffc3\52",
            "",
            "\1\144",
            "\1\145",
            "\1\30\2\uffff\12\30\6\uffff\23\30\1\146\7\30\4\uffff\1\30"+
            "\1\uffff\32\30",
            "",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
            "\1\30\2\uffff\12\30\6\uffff\33\30\4\uffff\1\30\1\uffff\32"+
            "\30",
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
            return "1:1: Tokens : ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | ML_COMMENT | At | Colon | Comma | Apos | Quot | Dot | SemiColon | LParen | RParen | Digits | WhiteSpaceChar | StringLiteral | Name | Reference | DefaultDecl | Element );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_42 = input.LA(1);

                        s = -1;
                        if ( (LA17_42=='\"') ) {s = 43;}

                        else if ( ((LA17_42>='\u0000' && LA17_42<='!')||(LA17_42>='#' && LA17_42<='%')||(LA17_42>='\'' && LA17_42<=';')||(LA17_42>='=' && LA17_42<='\uFFFF')) ) {s = 42;}

                        else if ( (LA17_42=='&') ) {s = 44;}

                        else if ( (LA17_42=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_68 = input.LA(1);

                        s = -1;
                        if ( (LA17_68==';') ) {s = 82;}

                        else if ( ((LA17_68>='0' && LA17_68<='9')) ) {s = 68;}

                        else if ( ((LA17_68>='\u0000' && LA17_68<='/')||LA17_68==':'||(LA17_68>='<' && LA17_68<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_83 = input.LA(1);

                        s = -1;
                        if ( ((LA17_83>='\u0000' && LA17_83<='/')||LA17_83==':'||(LA17_83>='<' && LA17_83<='@')||(LA17_83>='G' && LA17_83<='`')||(LA17_83>='g' && LA17_83<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_83==';') ) {s = 94;}

                        else if ( ((LA17_83>='0' && LA17_83<='9')||(LA17_83>='A' && LA17_83<='F')||(LA17_83>='a' && LA17_83<='f')) ) {s = 83;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_84 = input.LA(1);

                        s = -1;
                        if ( (LA17_84=='\"') ) {s = 43;}

                        else if ( ((LA17_84>='\u0000' && LA17_84<='!')||(LA17_84>='#' && LA17_84<='%')||(LA17_84>='\'' && LA17_84<=';')||(LA17_84>='=' && LA17_84<='\uFFFF')) ) {s = 42;}

                        else if ( (LA17_84=='&') ) {s = 44;}

                        else if ( (LA17_84=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_72 = input.LA(1);

                        s = -1;
                        if ( ((LA17_72>='\u0000' && LA17_72<='/')||LA17_72==':'||(LA17_72>='<' && LA17_72<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_72==';') ) {s = 84;}

                        else if ( ((LA17_72>='0' && LA17_72<='9')) ) {s = 72;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_39 = input.LA(1);

                        s = -1;
                        if ( (LA17_39=='#') ) {s = 56;}

                        else if ( ((LA17_39>='A' && LA17_39<='Z')||LA17_39=='_'||(LA17_39>='a' && LA17_39<='z')) ) {s = 57;}

                        else if ( ((LA17_39>='\u0000' && LA17_39<='\"')||(LA17_39>='$' && LA17_39<='@')||(LA17_39>='[' && LA17_39<='^')||LA17_39=='`'||(LA17_39>='{' && LA17_39<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_17 = input.LA(1);

                        s = -1;
                        if ( ((LA17_17>='\u0000' && LA17_17<='!')||(LA17_17>='#' && LA17_17<='%')||(LA17_17>='\'' && LA17_17<=';')||(LA17_17>='=' && LA17_17<='\uFFFF')) ) {s = 42;}

                        else if ( (LA17_17=='\"') ) {s = 43;}

                        else if ( (LA17_17=='&') ) {s = 44;}

                        else if ( (LA17_17=='<') ) {s = 40;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_81 = input.LA(1);

                        s = -1;
                        if ( ((LA17_81>='\u0000' && LA17_81<='/')||LA17_81==':'||(LA17_81>='<' && LA17_81<='@')||(LA17_81>='G' && LA17_81<='`')||(LA17_81>='g' && LA17_81<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_81==';') ) {s = 93;}

                        else if ( ((LA17_81>='0' && LA17_81<='9')||(LA17_81>='A' && LA17_81<='F')||(LA17_81>='a' && LA17_81<='f')) ) {s = 81;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_94 = input.LA(1);

                        s = -1;
                        if ( (LA17_94=='\"') ) {s = 43;}

                        else if ( ((LA17_94>='\u0000' && LA17_94<='!')||(LA17_94>='#' && LA17_94<='%')||(LA17_94>='\'' && LA17_94<=';')||(LA17_94>='=' && LA17_94<='\uFFFF')) ) {s = 42;}

                        else if ( (LA17_94=='&') ) {s = 44;}

                        else if ( (LA17_94=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_59 = input.LA(1);

                        s = -1;
                        if ( ((LA17_59>='\u0000' && LA17_59<=',')||(LA17_59>='.' && LA17_59<='/')||LA17_59==':'||(LA17_59>='<' && LA17_59<='?')||(LA17_59>='[' && LA17_59<='^')||LA17_59=='`'||(LA17_59>='{' && LA17_59<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_59=='-'||(LA17_59>='0' && LA17_59<='9')||(LA17_59>='@' && LA17_59<='Z')||LA17_59=='_'||(LA17_59>='a' && LA17_59<='z')) ) {s = 73;}

                        else if ( (LA17_59==';') ) {s = 74;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_71 = input.LA(1);

                        s = -1;
                        if ( ((LA17_71>='\u0000' && LA17_71<='/')||(LA17_71>=':' && LA17_71<='@')||(LA17_71>='G' && LA17_71<='`')||(LA17_71>='g' && LA17_71<='\uFFFF')) ) {s = 40;}

                        else if ( ((LA17_71>='0' && LA17_71<='9')||(LA17_71>='A' && LA17_71<='F')||(LA17_71>='a' && LA17_71<='f')) ) {s = 83;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_44 = input.LA(1);

                        s = -1;
                        if ( (LA17_44=='#') ) {s = 58;}

                        else if ( ((LA17_44>='\u0000' && LA17_44<='\"')||(LA17_44>='$' && LA17_44<='@')||(LA17_44>='[' && LA17_44<='^')||LA17_44=='`'||(LA17_44>='{' && LA17_44<='\uFFFF')) ) {s = 40;}

                        else if ( ((LA17_44>='A' && LA17_44<='Z')||LA17_44=='_'||(LA17_44>='a' && LA17_44<='z')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_16 = input.LA(1);

                        s = -1;
                        if ( ((LA17_16>='\u0000' && LA17_16<='%')||(LA17_16>='(' && LA17_16<=';')||(LA17_16>='=' && LA17_16<='\uFFFF')) ) {s = 37;}

                        else if ( (LA17_16=='\'') ) {s = 38;}

                        else if ( (LA17_16=='&') ) {s = 39;}

                        else if ( (LA17_16=='<') ) {s = 40;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_70 = input.LA(1);

                        s = -1;
                        if ( (LA17_70=='\'') ) {s = 38;}

                        else if ( ((LA17_70>='\u0000' && LA17_70<='%')||(LA17_70>='(' && LA17_70<=';')||(LA17_70>='=' && LA17_70<='\uFFFF')) ) {s = 37;}

                        else if ( (LA17_70=='&') ) {s = 39;}

                        else if ( (LA17_70=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_69 = input.LA(1);

                        s = -1;
                        if ( ((LA17_69>='\u0000' && LA17_69<=',')||(LA17_69>='.' && LA17_69<='/')||LA17_69==':'||(LA17_69>='<' && LA17_69<='?')||(LA17_69>='[' && LA17_69<='^')||LA17_69=='`'||(LA17_69>='{' && LA17_69<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_69==';') ) {s = 70;}

                        else if ( (LA17_69=='-'||(LA17_69>='0' && LA17_69<='9')||(LA17_69>='@' && LA17_69<='Z')||LA17_69=='_'||(LA17_69>='a' && LA17_69<='z')) ) {s = 69;}

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_57 = input.LA(1);

                        s = -1;
                        if ( ((LA17_57>='\u0000' && LA17_57<=',')||(LA17_57>='.' && LA17_57<='/')||LA17_57==':'||(LA17_57>='<' && LA17_57<='?')||(LA17_57>='[' && LA17_57<='^')||LA17_57=='`'||(LA17_57>='{' && LA17_57<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_57=='-'||(LA17_57>='0' && LA17_57<='9')||(LA17_57>='@' && LA17_57<='Z')||LA17_57=='_'||(LA17_57>='a' && LA17_57<='z')) ) {s = 69;}

                        else if ( (LA17_57==';') ) {s = 70;}

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_37 = input.LA(1);

                        s = -1;
                        if ( (LA17_37=='\'') ) {s = 38;}

                        else if ( ((LA17_37>='\u0000' && LA17_37<='%')||(LA17_37>='(' && LA17_37<=';')||(LA17_37>='=' && LA17_37<='\uFFFF')) ) {s = 37;}

                        else if ( (LA17_37=='&') ) {s = 39;}

                        else if ( (LA17_37=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_58 = input.LA(1);

                        s = -1;
                        if ( (LA17_58=='x') ) {s = 71;}

                        else if ( ((LA17_58>='\u0000' && LA17_58<='/')||(LA17_58>=':' && LA17_58<='w')||(LA17_58>='y' && LA17_58<='\uFFFF')) ) {s = 40;}

                        else if ( ((LA17_58>='0' && LA17_58<='9')) ) {s = 72;}

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_73 = input.LA(1);

                        s = -1;
                        if ( ((LA17_73>='\u0000' && LA17_73<=',')||(LA17_73>='.' && LA17_73<='/')||LA17_73==':'||(LA17_73>='<' && LA17_73<='?')||(LA17_73>='[' && LA17_73<='^')||LA17_73=='`'||(LA17_73>='{' && LA17_73<='\uFFFF')) ) {s = 40;}

                        else if ( (LA17_73==';') ) {s = 74;}

                        else if ( (LA17_73=='-'||(LA17_73>='0' && LA17_73<='9')||(LA17_73>='@' && LA17_73<='Z')||LA17_73=='_'||(LA17_73>='a' && LA17_73<='z')) ) {s = 73;}

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_56 = input.LA(1);

                        s = -1;
                        if ( (LA17_56=='x') ) {s = 67;}

                        else if ( ((LA17_56>='\u0000' && LA17_56<='/')||(LA17_56>=':' && LA17_56<='w')||(LA17_56>='y' && LA17_56<='\uFFFF')) ) {s = 40;}

                        else if ( ((LA17_56>='0' && LA17_56<='9')) ) {s = 68;}

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_93 = input.LA(1);

                        s = -1;
                        if ( (LA17_93=='\'') ) {s = 38;}

                        else if ( ((LA17_93>='\u0000' && LA17_93<='%')||(LA17_93>='(' && LA17_93<=';')||(LA17_93>='=' && LA17_93<='\uFFFF')) ) {s = 37;}

                        else if ( (LA17_93=='&') ) {s = 39;}

                        else if ( (LA17_93=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_82 = input.LA(1);

                        s = -1;
                        if ( (LA17_82=='\'') ) {s = 38;}

                        else if ( ((LA17_82>='\u0000' && LA17_82<='%')||(LA17_82>='(' && LA17_82<=';')||(LA17_82>='=' && LA17_82<='\uFFFF')) ) {s = 37;}

                        else if ( (LA17_82=='&') ) {s = 39;}

                        else if ( (LA17_82=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_74 = input.LA(1);

                        s = -1;
                        if ( (LA17_74=='\"') ) {s = 43;}

                        else if ( ((LA17_74>='\u0000' && LA17_74<='!')||(LA17_74>='#' && LA17_74<='%')||(LA17_74>='\'' && LA17_74<=';')||(LA17_74>='=' && LA17_74<='\uFFFF')) ) {s = 42;}

                        else if ( (LA17_74=='&') ) {s = 44;}

                        else if ( (LA17_74=='<') ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_67 = input.LA(1);

                        s = -1;
                        if ( ((LA17_67>='\u0000' && LA17_67<='/')||(LA17_67>=':' && LA17_67<='@')||(LA17_67>='G' && LA17_67<='`')||(LA17_67>='g' && LA17_67<='\uFFFF')) ) {s = 40;}

                        else if ( ((LA17_67>='0' && LA17_67<='9')||(LA17_67>='A' && LA17_67<='F')||(LA17_67>='a' && LA17_67<='f')) ) {s = 81;}

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
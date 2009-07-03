// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 InLineJSON.g 2009-07-03 13:56:28

//--------------------------------------
// XerialJ Project
//
// InLineJSONLexer.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.silk.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InLineJSONLexer extends Lexer {
    public static final int RBrace=20;
    public static final int LBracket=21;
    public static final int Digit=5;
    public static final int T__23=23;
    public static final int Frac=16;
    public static final int HexDigit=7;
    public static final int Exp=17;
    public static final int UnicodeChar=8;
    public static final int StringChar=10;
    public static final int String=12;
    public static final int Letter=6;
    public static final int Comma=14;
    public static final int EscapeSequence=9;
    public static final int EOF=-1;
    public static final int T__24=24;
    public static final int StringChar_s=11;
    public static final int Integer=15;
    public static final int Double=18;
    public static final int LBrace=19;
    public static final int RBracket=22;
    public static final int T__25=25;
    public static final int WhiteSpace=4;
    public static final int Colon=13;

      public int nesting = 1;	// json fragment begins with nesting


    // delegates
    // delegators

    public InLineJSONLexer() {;} 
    public InLineJSONLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InLineJSONLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InLineJSON.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:21:7: ( 'true' )
            // InLineJSON.g:21:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:22:7: ( 'false' )
            // InLineJSON.g:22:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:23:7: ( 'null' )
            // InLineJSON.g:23:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:61:11: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // InLineJSON.g:61:13: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpace"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // InLineJSON.g:63:15: ( '0' .. '9' )
            // InLineJSON.g:63:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // InLineJSON.g:64:16: ( 'A' .. 'F' | 'a' .. 'f' )
            // InLineJSON.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // InLineJSON.g:65:18: ( Digit | Letter )
            // InLineJSON.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "HexDigit"

    // $ANTLR start "UnicodeChar"
    public final void mUnicodeChar() throws RecognitionException {
        try {
            // InLineJSON.g:66:21: (~ ( '\"' | '\\\\' ) )
            // InLineJSON.g:66:23: ~ ( '\"' | '\\\\' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end "UnicodeChar"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // InLineJSON.g:68:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // InLineJSON.g:68:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // InLineJSON.g:68:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt1=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt1=1;
                }
                break;
            case '\\':
                {
                alt1=2;
                }
                break;
            case '/':
                {
                alt1=3;
                }
                break;
            case 'b':
                {
                alt1=4;
                }
                break;
            case 'f':
                {
                alt1=5;
                }
                break;
            case 'n':
                {
                alt1=6;
                }
                break;
            case 'r':
                {
                alt1=7;
                }
                break;
            case 't':
                {
                alt1=8;
                }
                break;
            case 'u':
                {
                alt1=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InLineJSON.g:68:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InLineJSON.g:68:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // InLineJSON.g:68:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // InLineJSON.g:68:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // InLineJSON.g:68:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // InLineJSON.g:68:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // InLineJSON.g:68:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // InLineJSON.g:68:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // InLineJSON.g:68:60: 'u' HexDigit HexDigit HexDigit HexDigit
                    {
                    match('u'); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 

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
            // InLineJSON.g:71:21: ( UnicodeChar | EscapeSequence )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                alt2=1;
            }
            else if ( (LA2_0=='\\') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InLineJSON.g:71:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // InLineJSON.g:71:38: EscapeSequence
                    {
                    mEscapeSequence(); 

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
            // InLineJSON.g:73:22: ( ( StringChar )* )
            // InLineJSON.g:73:24: ( StringChar )*
            {
            // InLineJSON.g:73:24: ( StringChar )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InLineJSON.g:73:24: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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

            // InLineJSON.g:74:7: ( '\"' s= StringChar_s '\"' )
            // InLineJSON.g:74:9: '\"' s= StringChar_s '\"'
            {
            match('\"'); 
            int sStart239 = getCharIndex();
            mStringChar_s(); 
            s = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, sStart239, getCharIndex()-1);
            match('\"'); 
             setText((s!=null?s.getText():null)); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:77:6: ( ':' )
            // InLineJSON.g:77:8: ':'
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
            // InLineJSON.g:78:6: ( ',' )
            // InLineJSON.g:78:8: ','
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

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InLineJSON.g:79:8: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
            // InLineJSON.g:79:10: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
            {
            // InLineJSON.g:79:10: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InLineJSON.g:79:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InLineJSON.g:79:15: ( '0' | '1' .. '9' ( Digit )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='0') ) {
                alt6=1;
            }
            else if ( ((LA6_0>='1' && LA6_0<='9')) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InLineJSON.g:79:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InLineJSON.g:79:22: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // InLineJSON.g:79:31: ( Digit )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InLineJSON.g:79:31: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
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
            // InLineJSON.g:80:14: ( '.' ( Digit )+ )
            // InLineJSON.g:80:16: '.' ( Digit )+
            {
            match('.'); 
            // InLineJSON.g:80:20: ( Digit )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InLineJSON.g:80:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // InLineJSON.g:81:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // InLineJSON.g:81:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InLineJSON.g:81:27: ( '+' | '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='+'||LA8_0=='-') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InLineJSON.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InLineJSON.g:81:40: ( Digit )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InLineJSON.g:81:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // InLineJSON.g:82:7: ( Integer ( Frac ( Exp )? | Exp ) )
            // InLineJSON.g:82:9: Integer ( Frac ( Exp )? | Exp )
            {
            mInteger(); 
            // InLineJSON.g:82:17: ( Frac ( Exp )? | Exp )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='.') ) {
                alt11=1;
            }
            else if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InLineJSON.g:82:18: Frac ( Exp )?
                    {
                    mFrac(); 
                    // InLineJSON.g:82:23: ( Exp )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InLineJSON.g:82:23: Exp
                            {
                            mExp(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InLineJSON.g:82:30: Exp
                    {
                    mExp(); 

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
            // InLineJSON.g:84:7: ( '{' )
            // InLineJSON.g:84:9: '{'
            {
            match('{'); 
             nesting++; 

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
            // InLineJSON.g:85:7: ( '}' )
            // InLineJSON.g:85:9: '}'
            {
            match('}'); 
             nesting--; if (nesting<=0) { emit(Token.EOF_TOKEN); } 

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
            // InLineJSON.g:86:9: ( '[' )
            // InLineJSON.g:86:11: '['
            {
            match('['); 
             nesting++; 

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
            // InLineJSON.g:87:9: ( ']' )
            // InLineJSON.g:87:11: ']'
            {
            match(']'); 
             nesting--; if (nesting<=0) { emit(Token.EOF_TOKEN); } 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBracket"

    public void mTokens() throws RecognitionException {
        // InLineJSON.g:1:8: ( T__23 | T__24 | T__25 | WhiteSpace | String | Colon | Comma | Integer | Double | LBrace | RBrace | LBracket | RBracket )
        int alt12=13;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InLineJSON.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // InLineJSON.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // InLineJSON.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // InLineJSON.g:1:28: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;
            case 5 :
                // InLineJSON.g:1:39: String
                {
                mString(); 

                }
                break;
            case 6 :
                // InLineJSON.g:1:46: Colon
                {
                mColon(); 

                }
                break;
            case 7 :
                // InLineJSON.g:1:52: Comma
                {
                mComma(); 

                }
                break;
            case 8 :
                // InLineJSON.g:1:58: Integer
                {
                mInteger(); 

                }
                break;
            case 9 :
                // InLineJSON.g:1:66: Double
                {
                mDouble(); 

                }
                break;
            case 10 :
                // InLineJSON.g:1:73: LBrace
                {
                mLBrace(); 

                }
                break;
            case 11 :
                // InLineJSON.g:1:80: RBrace
                {
                mRBrace(); 

                }
                break;
            case 12 :
                // InLineJSON.g:1:87: LBracket
                {
                mLBracket(); 

                }
                break;
            case 13 :
                // InLineJSON.g:1:96: RBracket
                {
                mRBracket(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\11\uffff\2\17\6\uffff\1\17";
    static final String DFA12_eofS =
        "\22\uffff";
    static final String DFA12_minS =
        "\1\11\7\uffff\1\60\2\56\6\uffff\1\56";
    static final String DFA12_maxS =
        "\1\175\7\uffff\1\71\2\145\6\uffff\1\145";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff\1\12\1\13\1\14\1\15"+
        "\1\10\1\11\1\uffff";
    static final String DFA12_specialS =
        "\22\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\4\1\uffff\2\4\22\uffff\1\4\1\uffff\1\5\11\uffff\1\7\1\10"+
            "\2\uffff\1\11\11\12\1\6\40\uffff\1\15\1\uffff\1\16\10\uffff"+
            "\1\2\7\uffff\1\3\5\uffff\1\1\6\uffff\1\13\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\11\12",
            "\1\20\26\uffff\1\20\37\uffff\1\20",
            "\1\20\1\uffff\12\21\13\uffff\1\20\37\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\uffff\12\21\13\uffff\1\20\37\uffff\1\20"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | WhiteSpace | String | Colon | Comma | Integer | Double | LBrace | RBrace | LBracket | RBracket );";
        }
    }
 

}
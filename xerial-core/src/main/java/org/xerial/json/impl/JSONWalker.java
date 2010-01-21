// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g 2010-01-21 11:03:58

//--------------------------------------
// Xerial Project
//
// JSONWalker.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.json.impl;
import org.xerial.json.*;
import org.xerial.util.StringUtil; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * JSONWalker generates JSONObject and JSONArray instances
 * from a given input JSON parse tree.
 */
public class JSONWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OBJECT", "ELEMENT", "ARRAY", "STRING", "INTEGER", "DOUBLE", "Colon", "Comma", "LBrace", "RBrace", "LBracket", "RBracket", "Dot", "TRUE", "FALSE", "NULL", "Digit", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "Int", "Frac", "Exp", "WhiteSpace", "String", "Integer", "Double"
    };
    public static final int Double=31;
    public static final int INTEGER=8;
    public static final int LBrace=12;
    public static final int Frac=26;
    public static final int NULL=19;
    public static final int Exp=27;
    public static final int RBracket=15;
    public static final int Colon=10;
    public static final int UnicodeChar=22;
    public static final int Digit=20;
    public static final int EOF=-1;
    public static final int TRUE=17;
    public static final int HexDigit=21;
    public static final int Int=25;
    public static final int OBJECT=4;
    public static final int Dot=16;
    public static final int ELEMENT=5;
    public static final int DOUBLE=9;
    public static final int StringChar=24;
    public static final int WhiteSpace=28;
    public static final int String=29;
    public static final int LBracket=14;
    public static final int FALSE=18;
    public static final int Comma=11;
    public static final int EscapeSequence=23;
    public static final int Integer=30;
    public static final int ARRAY=6;
    public static final int RBrace=13;
    public static final int STRING=7;

    // delegates
    // delegators

    protected static class ObjectLayer_scope {
        ArrayList<JSONElement> elems;
    }
    protected Stack ObjectLayer_stack = new Stack();
    protected static class ArrayLayer_scope {
        ArrayList<JSONValue> elems;
    }
    protected Stack ArrayLayer_stack = new Stack();


        public JSONWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public JSONWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return JSONWalker.tokenNames; }
    public String getGrammarFileName() { return "D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g"; }


    	public String unquote(String s) { return StringUtil.unquote(s); }



    // $ANTLR start "jsonObject"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:47:1: jsonObject returns [JSONObject r] : o= object ;
    public final JSONObject jsonObject() throws RecognitionException {
        JSONObject r = null;

        JSONObject o = null;


        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:48:2: (o= object )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:48:4: o= object
            {
            pushFollow(FOLLOW_object_in_jsonObject82);
            o=object();

            state._fsp--;

             r = o; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "jsonObject"


    // $ANTLR start "jsonArray"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:50:1: jsonArray returns [JSONArray r] : a= array ;
    public final JSONArray jsonArray() throws RecognitionException {
        JSONArray r = null;

        JSONArray a = null;


        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:51:2: (a= array )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:51:4: a= array
            {
            pushFollow(FOLLOW_array_in_jsonArray101);
            a=array();

            state._fsp--;

             r = a; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "jsonArray"


    // $ANTLR start "object"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:55:1: object returns [JSONObject v] : ^( OBJECT ( objectElement )* ) ;
    public final JSONObject object() throws RecognitionException {
        ObjectLayer_stack.push(new ObjectLayer_scope());

        JSONObject v = null;


        	((ObjectLayer_scope)ObjectLayer_stack.peek()).elems = new ArrayList<JSONElement>();

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:60:2: ( ^( OBJECT ( objectElement )* ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:60:4: ^( OBJECT ( objectElement )* )
            {
            match(input,OBJECT,FOLLOW_OBJECT_in_object133); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:60:13: ( objectElement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ELEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:60:13: objectElement
                	    {
                	    pushFollow(FOLLOW_objectElement_in_object135);
                	    objectElement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
             v = new JSONObject(((ObjectLayer_scope)ObjectLayer_stack.peek()).elems); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            ObjectLayer_stack.pop();

        }
        return v;
    }
    // $ANTLR end "object"


    // $ANTLR start "objectElement"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:64:1: objectElement : ^( ELEMENT s= String v= value ) ;
    public final void objectElement() throws RecognitionException {
        CommonTree s=null;
        JSONValue v = null;


        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:65:2: ( ^( ELEMENT s= String v= value ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:65:4: ^( ELEMENT s= String v= value )
            {
            match(input,ELEMENT,FOLLOW_ELEMENT_in_objectElement155); 

            match(input, Token.DOWN, null); 
            s=(CommonTree)match(input,String,FOLLOW_String_in_objectElement159); 
            pushFollow(FOLLOW_value_in_objectElement163);
            v=value();

            state._fsp--;


            match(input, Token.UP, null); 
             ((ObjectLayer_scope)ObjectLayer_stack.peek()).elems.add(new JSONElement(unquote((s!=null?s.getText():null)), v)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "objectElement"


    // $ANTLR start "array"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:69:1: array returns [JSONArray v] : ^( ARRAY ( arrayElement )* ) ;
    public final JSONArray array() throws RecognitionException {
        ArrayLayer_stack.push(new ArrayLayer_scope());

        JSONArray v = null;


        	((ArrayLayer_scope)ArrayLayer_stack.peek()).elems = new ArrayList<JSONValue>();

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:74:2: ( ^( ARRAY ( arrayElement )* ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:74:4: ^( ARRAY ( arrayElement )* )
            {
            match(input,ARRAY,FOLLOW_ARRAY_in_array198); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:74:12: ( arrayElement )*
                loop2:
                do {
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                	case 1 :
                	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:74:12: arrayElement
                	    {
                	    pushFollow(FOLLOW_arrayElement_in_array200);
                	    arrayElement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop2;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
             v = new JSONArray(((ArrayLayer_scope)ArrayLayer_stack.peek()).elems); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            ArrayLayer_stack.pop();

        }
        return v;
    }
    // $ANTLR end "array"


    // $ANTLR start "arrayElement"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:78:1: arrayElement : v= value ;
    public final void arrayElement() throws RecognitionException {
        JSONValue v = null;


        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:79:2: (v= value )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:79:4: v= value
            {
            pushFollow(FOLLOW_value_in_arrayElement223);
            v=value();

            state._fsp--;

             ((ArrayLayer_scope)ArrayLayer_stack.peek()).elems.add(v); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arrayElement"


    // $ANTLR start "value"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:83:1: value returns [JSONValue v] : ( ^( STRING s= String ) | ^( INTEGER n= Integer ) | ^( DOUBLE n= Double ) | o= object | a= array | TRUE | FALSE | NULL );
    public final JSONValue value() throws RecognitionException {
        JSONValue v = null;

        CommonTree s=null;
        CommonTree n=null;
        JSONObject o = null;

        JSONArray a = null;


        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:84:2: ( ^( STRING s= String ) | ^( INTEGER n= Integer ) | ^( DOUBLE n= Double ) | o= object | a= array | TRUE | FALSE | NULL )
            int alt3=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt3=1;
                }
                break;
            case INTEGER:
                {
                alt3=2;
                }
                break;
            case DOUBLE:
                {
                alt3=3;
                }
                break;
            case OBJECT:
                {
                alt3=4;
                }
                break;
            case ARRAY:
                {
                alt3=5;
                }
                break;
            case TRUE:
                {
                alt3=6;
                }
                break;
            case FALSE:
                {
                alt3=7;
                }
                break;
            case NULL:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:84:4: ^( STRING s= String )
                    {
                    match(input,STRING,FOLLOW_STRING_in_value243); 

                    match(input, Token.DOWN, null); 
                    s=(CommonTree)match(input,String,FOLLOW_String_in_value247); 

                    match(input, Token.UP, null); 
                     v = new JSONString(unquote((s!=null?s.getText():null))); 

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:85:4: ^( INTEGER n= Integer )
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_value256); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)match(input,Integer,FOLLOW_Integer_in_value260); 

                    match(input, Token.UP, null); 
                     v = new JSONInteger((n!=null?n.getText():null)); 

                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:86:4: ^( DOUBLE n= Double )
                    {
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_value269); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)match(input,Double,FOLLOW_Double_in_value273); 

                    match(input, Token.UP, null); 
                     v = new JSONDouble((n!=null?n.getText():null)); 

                    }
                    break;
                case 4 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:87:4: o= object
                    {
                    pushFollow(FOLLOW_object_in_value283);
                    o=object();

                    state._fsp--;

                     v = o; 

                    }
                    break;
                case 5 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:88:4: a= array
                    {
                    pushFollow(FOLLOW_array_in_value292);
                    a=array();

                    state._fsp--;

                     v = a; 

                    }
                    break;
                case 6 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:89:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_value301); 
                     v = new JSONBoolean(true); 

                    }
                    break;
                case 7 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:90:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_value308); 
                     v = new JSONBoolean(false); 

                    }
                    break;
                case 8 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\json\\impl\\JSONWalker.g:91:4: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_value315); 
                     v = new JSONNull(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return v;
    }
    // $ANTLR end "value"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\3\11\uffff";
    static final String DFA2_maxS =
        "\1\23\11\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\2\1\1\7\uffff";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\2\1\uffff\4\2\7\uffff\3\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 74:12: ( arrayElement )*";
        }
    }
 

    public static final BitSet FOLLOW_object_in_jsonObject82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_jsonArray101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OBJECT_in_object133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_objectElement_in_object135 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_ELEMENT_in_objectElement155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_String_in_objectElement159 = new BitSet(new long[]{0x00000000000E03D0L});
    public static final BitSet FOLLOW_value_in_objectElement163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_in_array198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_arrayElement_in_array200 = new BitSet(new long[]{0x00000000000E03D8L});
    public static final BitSet FOLLOW_value_in_arrayElement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_String_in_value247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_value256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Integer_in_value260 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOUBLE_in_value269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Double_in_value273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_object_in_value283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_value292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_value301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_value308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_value315 = new BitSet(new long[]{0x0000000000000002L});

}
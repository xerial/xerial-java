// $ANTLR 3.0.1 JSON.g 2007-09-13 13:36:50

//--------------------------------------
// Xerial Project
//
// JSONParser.java
// Since: Apr 26, 2007
//
//--------------------------------------
package org.xerial.json;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class JSONParser extends Parser {
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
    public static final int HexDigit=21;
    public static final int TRUE=17;
    public static final int Int=25;
    public static final int OBJECT=4;
    public static final int ELEMENT=5;
    public static final int Dot=16;
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
    public static final int STRING=7;
    public static final int RBrace=13;

        public JSONParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "JSON.g"; }


    public static class jsonObject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start jsonObject
    // JSON.g:88:1: jsonObject : object ;
    public final jsonObject_return jsonObject() throws RecognitionException {
        jsonObject_return retval = new jsonObject_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        object_return object1 = null;



        try {
            // JSON.g:89:2: ( object )
            // JSON.g:89:4: object
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_object_in_jsonObject405);
            object1=object();
            _fsp--;

            adaptor.addChild(root_0, object1.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end jsonObject

    public static class jsonArray_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start jsonArray
    // JSON.g:92:1: jsonArray : array ;
    public final jsonArray_return jsonArray() throws RecognitionException {
        jsonArray_return retval = new jsonArray_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        array_return array2 = null;



        try {
            // JSON.g:93:2: ( array )
            // JSON.g:93:4: array
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_array_in_jsonArray417);
            array2=array();
            _fsp--;

            adaptor.addChild(root_0, array2.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end jsonArray

    public static class object_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start object
    // JSON.g:97:1: object : LBrace ( objectElement ( Comma objectElement )* )? RBrace -> ^( OBJECT ( objectElement )* ) ;
    public final object_return object() throws RecognitionException {
        object_return retval = new object_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBrace3=null;
        Token Comma5=null;
        Token RBrace7=null;
        objectElement_return objectElement4 = null;

        objectElement_return objectElement6 = null;


        Object LBrace3_tree=null;
        Object Comma5_tree=null;
        Object RBrace7_tree=null;
        RewriteRuleTokenStream stream_LBrace=new RewriteRuleTokenStream(adaptor,"token LBrace");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RBrace=new RewriteRuleTokenStream(adaptor,"token RBrace");
        RewriteRuleSubtreeStream stream_objectElement=new RewriteRuleSubtreeStream(adaptor,"rule objectElement");
        try {
            // JSON.g:98:2: ( LBrace ( objectElement ( Comma objectElement )* )? RBrace -> ^( OBJECT ( objectElement )* ) )
            // JSON.g:98:4: LBrace ( objectElement ( Comma objectElement )* )? RBrace
            {
            LBrace3=(Token)input.LT(1);
            match(input,LBrace,FOLLOW_LBrace_in_object430); 
            stream_LBrace.add(LBrace3);

            // JSON.g:98:11: ( objectElement ( Comma objectElement )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // JSON.g:98:12: objectElement ( Comma objectElement )*
                    {
                    pushFollow(FOLLOW_objectElement_in_object433);
                    objectElement4=objectElement();
                    _fsp--;

                    stream_objectElement.add(objectElement4.getTree());
                    // JSON.g:98:26: ( Comma objectElement )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==Comma) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // JSON.g:98:27: Comma objectElement
                    	    {
                    	    Comma5=(Token)input.LT(1);
                    	    match(input,Comma,FOLLOW_Comma_in_object436); 
                    	    stream_Comma.add(Comma5);

                    	    pushFollow(FOLLOW_objectElement_in_object438);
                    	    objectElement6=objectElement();
                    	    _fsp--;

                    	    stream_objectElement.add(objectElement6.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            RBrace7=(Token)input.LT(1);
            match(input,RBrace,FOLLOW_RBrace_in_object444); 
            stream_RBrace.add(RBrace7);


            // AST REWRITE
            // elements: objectElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 99:4: -> ^( OBJECT ( objectElement )* )
            {
                // JSON.g:99:7: ^( OBJECT ( objectElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(OBJECT, "OBJECT"), root_1);

                // JSON.g:99:16: ( objectElement )*
                while ( stream_objectElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_objectElement.next());

                }
                stream_objectElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end object

    public static class objectElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start objectElement
    // JSON.g:102:1: objectElement : String Colon value -> ^( ELEMENT String value ) ;
    public final objectElement_return objectElement() throws RecognitionException {
        objectElement_return retval = new objectElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String8=null;
        Token Colon9=null;
        value_return value10 = null;


        Object String8_tree=null;
        Object Colon9_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // JSON.g:103:2: ( String Colon value -> ^( ELEMENT String value ) )
            // JSON.g:103:4: String Colon value
            {
            String8=(Token)input.LT(1);
            match(input,String,FOLLOW_String_in_objectElement468); 
            stream_String.add(String8);

            Colon9=(Token)input.LT(1);
            match(input,Colon,FOLLOW_Colon_in_objectElement470); 
            stream_Colon.add(Colon9);

            pushFollow(FOLLOW_value_in_objectElement472);
            value10=value();
            _fsp--;

            stream_value.add(value10.getTree());

            // AST REWRITE
            // elements: value, String
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 104:4: -> ^( ELEMENT String value )
            {
                // JSON.g:104:7: ^( ELEMENT String value )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, stream_String.next());
                adaptor.addChild(root_1, stream_value.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end objectElement

    public static class array_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start array
    // JSON.g:107:1: array : LBracket value ( Comma value )* RBracket -> ^( ARRAY ( value )+ ) ;
    public final array_return array() throws RecognitionException {
        array_return retval = new array_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket11=null;
        Token Comma13=null;
        Token RBracket15=null;
        value_return value12 = null;

        value_return value14 = null;


        Object LBracket11_tree=null;
        Object Comma13_tree=null;
        Object RBracket15_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // JSON.g:108:2: ( LBracket value ( Comma value )* RBracket -> ^( ARRAY ( value )+ ) )
            // JSON.g:108:4: LBracket value ( Comma value )* RBracket
            {
            LBracket11=(Token)input.LT(1);
            match(input,LBracket,FOLLOW_LBracket_in_array498); 
            stream_LBracket.add(LBracket11);

            pushFollow(FOLLOW_value_in_array500);
            value12=value();
            _fsp--;

            stream_value.add(value12.getTree());
            // JSON.g:108:19: ( Comma value )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comma) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // JSON.g:108:20: Comma value
            	    {
            	    Comma13=(Token)input.LT(1);
            	    match(input,Comma,FOLLOW_Comma_in_array503); 
            	    stream_Comma.add(Comma13);

            	    pushFollow(FOLLOW_value_in_array505);
            	    value14=value();
            	    _fsp--;

            	    stream_value.add(value14.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RBracket15=(Token)input.LT(1);
            match(input,RBracket,FOLLOW_RBracket_in_array509); 
            stream_RBracket.add(RBracket15);


            // AST REWRITE
            // elements: value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 109:4: -> ^( ARRAY ( value )+ )
            {
                // JSON.g:109:7: ^( ARRAY ( value )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ARRAY, "ARRAY"), root_1);

                if ( !(stream_value.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_value.next());

                }
                stream_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end array

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start value
    // JSON.g:113:1: value : ( String -> ^( STRING String ) | Integer -> ^( INTEGER Integer ) | Double -> ^( DOUBLE Double ) | object | array | TRUE | FALSE | NULL );
    public final value_return value() throws RecognitionException {
        value_return retval = new value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String16=null;
        Token Integer17=null;
        Token Double18=null;
        Token TRUE21=null;
        Token FALSE22=null;
        Token NULL23=null;
        object_return object19 = null;

        array_return array20 = null;


        Object String16_tree=null;
        Object Integer17_tree=null;
        Object Double18_tree=null;
        Object TRUE21_tree=null;
        Object FALSE22_tree=null;
        Object NULL23_tree=null;
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");

        try {
            // JSON.g:114:2: ( String -> ^( STRING String ) | Integer -> ^( INTEGER Integer ) | Double -> ^( DOUBLE Double ) | object | array | TRUE | FALSE | NULL )
            int alt4=8;
            switch ( input.LA(1) ) {
            case String:
                {
                alt4=1;
                }
                break;
            case Integer:
                {
                alt4=2;
                }
                break;
            case Double:
                {
                alt4=3;
                }
                break;
            case LBrace:
                {
                alt4=4;
                }
                break;
            case LBracket:
                {
                alt4=5;
                }
                break;
            case TRUE:
                {
                alt4=6;
                }
                break;
            case FALSE:
                {
                alt4=7;
                }
                break;
            case NULL:
                {
                alt4=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("113:1: value : ( String -> ^( STRING String ) | Integer -> ^( INTEGER Integer ) | Double -> ^( DOUBLE Double ) | object | array | TRUE | FALSE | NULL );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // JSON.g:114:4: String
                    {
                    String16=(Token)input.LT(1);
                    match(input,String,FOLLOW_String_in_value534); 
                    stream_String.add(String16);


                    // AST REWRITE
                    // elements: String
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 114:11: -> ^( STRING String )
                    {
                        // JSON.g:114:14: ^( STRING String )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_String.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // JSON.g:115:4: Integer
                    {
                    Integer17=(Token)input.LT(1);
                    match(input,Integer,FOLLOW_Integer_in_value547); 
                    stream_Integer.add(Integer17);


                    // AST REWRITE
                    // elements: Integer
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 115:12: -> ^( INTEGER Integer )
                    {
                        // JSON.g:115:15: ^( INTEGER Integer )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(INTEGER, "INTEGER"), root_1);

                        adaptor.addChild(root_1, stream_Integer.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 3 :
                    // JSON.g:116:4: Double
                    {
                    Double18=(Token)input.LT(1);
                    match(input,Double,FOLLOW_Double_in_value560); 
                    stream_Double.add(Double18);


                    // AST REWRITE
                    // elements: Double
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 116:11: -> ^( DOUBLE Double )
                    {
                        // JSON.g:116:14: ^( DOUBLE Double )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(DOUBLE, "DOUBLE"), root_1);

                        adaptor.addChild(root_1, stream_Double.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 4 :
                    // JSON.g:117:4: object
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_object_in_value573);
                    object19=object();
                    _fsp--;

                    adaptor.addChild(root_0, object19.getTree());

                    }
                    break;
                case 5 :
                    // JSON.g:118:4: array
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_array_in_value580);
                    array20=array();
                    _fsp--;

                    adaptor.addChild(root_0, array20.getTree());

                    }
                    break;
                case 6 :
                    // JSON.g:119:4: TRUE
                    {
                    root_0 = (Object)adaptor.nil();

                    TRUE21=(Token)input.LT(1);
                    match(input,TRUE,FOLLOW_TRUE_in_value587); 
                    TRUE21_tree = (Object)adaptor.create(TRUE21);
                    adaptor.addChild(root_0, TRUE21_tree);


                    }
                    break;
                case 7 :
                    // JSON.g:120:4: FALSE
                    {
                    root_0 = (Object)adaptor.nil();

                    FALSE22=(Token)input.LT(1);
                    match(input,FALSE,FOLLOW_FALSE_in_value595); 
                    FALSE22_tree = (Object)adaptor.create(FALSE22);
                    adaptor.addChild(root_0, FALSE22_tree);


                    }
                    break;
                case 8 :
                    // JSON.g:121:4: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL23=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_value600); 
                    NULL23_tree = (Object)adaptor.create(NULL23);
                    adaptor.addChild(root_0, NULL23_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
        
        finally {
        }
        return retval;
    }
    // $ANTLR end value


 

    public static final BitSet FOLLOW_object_in_jsonObject405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_jsonArray417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBrace_in_object430 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_objectElement_in_object433 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_Comma_in_object436 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_objectElement_in_object438 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_RBrace_in_object444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_objectElement468 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_Colon_in_objectElement470 = new BitSet(new long[]{0x00000000E00E5000L});
    public static final BitSet FOLLOW_value_in_objectElement472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_array498 = new BitSet(new long[]{0x00000000E00E5000L});
    public static final BitSet FOLLOW_value_in_array500 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_Comma_in_array503 = new BitSet(new long[]{0x00000000E00E5000L});
    public static final BitSet FOLLOW_value_in_array505 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_RBracket_in_array509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_value534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_value547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_value560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_object_in_value573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_value580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_value587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_value595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_value600 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.1.1 d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g 2009-07-01 18:57:06

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
// SilkSchemaParser.java
// Since: Jun 23, 2009 1:00:02 PM
//
//--------------------------------------
package org.xerial.silk.schema.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SilkSchemaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Schema", "WhiteSpace", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Colon", "Comma", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "LParen", "RParen", "Class"
    };
    public static final int RBrace=21;
    public static final int Class=26;
    public static final int LBracket=22;
    public static final int Digit=6;
    public static final int Frac=17;
    public static final int HexDigit=8;
    public static final int Exp=18;
    public static final int RParen=25;
    public static final int UnicodeChar=9;
    public static final int StringChar=11;
    public static final int LParen=24;
    public static final int String=13;
    public static final int Letter=7;
    public static final int Comma=15;
    public static final int Schema=4;
    public static final int EscapeSequence=10;
    public static final int EOF=-1;
    public static final int StringChar_s=12;
    public static final int Integer=16;
    public static final int LBrace=20;
    public static final int Double=19;
    public static final int RBracket=23;
    public static final int WhiteSpace=5;
    public static final int Colon=14;

    // delegates
    // delegators


        public SilkSchemaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SilkSchemaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SilkSchemaParser.tokenNames; }
    public String getGrammarFileName() { return "d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g"; }


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:135:1: schema : ( classDefinition )* ;
    public final SilkSchemaParser.schema_return schema() throws RecognitionException {
        SilkSchemaParser.schema_return retval = new SilkSchemaParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.classDefinition_return classDefinition1 = null;



        try {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:136:3: ( ( classDefinition )* )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:136:5: ( classDefinition )*
            {
            root_0 = (Object)adaptor.nil();

            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:136:5: ( classDefinition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Class) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:136:6: classDefinition
            	    {
            	    pushFollow(FOLLOW_classDefinition_in_schema403);
            	    classDefinition1=classDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, classDefinition1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "schema"

    public static class classDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classDefinition"
    // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:139:1: classDefinition : Class LBrace RBrace ;
    public final SilkSchemaParser.classDefinition_return classDefinition() throws RecognitionException {
        SilkSchemaParser.classDefinition_return retval = new SilkSchemaParser.classDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Class2=null;
        Token LBrace3=null;
        Token RBrace4=null;

        Object Class2_tree=null;
        Object LBrace3_tree=null;
        Object RBrace4_tree=null;

        try {
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:3: ( Class LBrace RBrace )
            // d:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\schema\\impl\\SilkSchema.g:140:5: Class LBrace RBrace
            {
            root_0 = (Object)adaptor.nil();

            Class2=(Token)match(input,Class,FOLLOW_Class_in_classDefinition423); 
            Class2_tree = (Object)adaptor.create(Class2);
            adaptor.addChild(root_0, Class2_tree);

            LBrace3=(Token)match(input,LBrace,FOLLOW_LBrace_in_classDefinition425); 
            LBrace3_tree = (Object)adaptor.create(LBrace3);
            adaptor.addChild(root_0, LBrace3_tree);

            RBrace4=(Token)match(input,RBrace,FOLLOW_RBrace_in_classDefinition427); 
            RBrace4_tree = (Object)adaptor.create(RBrace4);
            adaptor.addChild(root_0, RBrace4_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "classDefinition"

    // Delegated rules


 

    public static final BitSet FOLLOW_classDefinition_in_schema403 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition423 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LBrace_in_classDefinition425 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RBrace_in_classDefinition427 = new BitSet(new long[]{0x0000000000000002L});

}
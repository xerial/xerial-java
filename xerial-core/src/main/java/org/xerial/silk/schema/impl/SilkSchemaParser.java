// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-03 15:24:41

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Module", "ClassDef", "Name", "Parent", "Mixin", "Attribute", "IsArray", "TypeName", "LineBreakChar", "Preamble", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "WhiteSpace", "NonWhiteSpaceUnicodeChar", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Eq", "Dot", "Comma", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "NonWhiteSpaceChar", "Symbol", "Class", "Includes", "End", "Relation", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "QNameChar", "QName"
    };
    public static final int Includes=45;
    public static final int RBrace=31;
    public static final int NonWhiteSpaceChar=42;
    public static final int Class=44;
    public static final int LBracket=32;
    public static final int Digit=16;
    public static final int Frac=27;
    public static final int HexDigit=18;
    public static final int Symbol=43;
    public static final int Module=4;
    public static final int Letter=17;
    public static final int Attribute=9;
    public static final int Comma=37;
    public static final int Dot=36;
    public static final int End=46;
    public static final int EscapeSequence=22;
    public static final int NonWhiteSpaceUnicodeChar=20;
    public static final int Integer=26;
    public static final int Relation=47;
    public static final int Mixin=8;
    public static final int WhiteSpace=19;
    public static final int ClassDef=5;
    public static final int LineComment=14;
    public static final int ModuleName=50;
    public static final int SafeFirstLetter=48;
    public static final int Star=40;
    public static final int Eq=35;
    public static final int Preamble=13;
    public static final int Exp=28;
    public static final int QNameChar=53;
    public static final int RParen=39;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=15;
    public static final int Name=6;
    public static final int ModuleDef=52;
    public static final int LParen=38;
    public static final int String=25;
    public static final int SafeLetter=49;
    public static final int LineBreakChar=12;
    public static final int IsArray=10;
    public static final int QName=54;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int UnsafeUnicodeChar=41;
    public static final int Double=29;
    public static final int LBrace=30;
    public static final int RBracket=33;
    public static final int Lt=34;
    public static final int Parent=7;
    public static final int TypeName=11;
    public static final int WhiteSpaces=51;

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
    public String getGrammarFileName() { return "SilkSchema.g"; }


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // SilkSchema.g:183:1: schema : ( classDefinition | moduleDefinition )* ;
    public final SilkSchemaParser.schema_return schema() throws RecognitionException {
        SilkSchemaParser.schema_return retval = new SilkSchemaParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.classDefinition_return classDefinition1 = null;

        SilkSchemaParser.moduleDefinition_return moduleDefinition2 = null;



        try {
            // SilkSchema.g:184:3: ( ( classDefinition | moduleDefinition )* )
            // SilkSchema.g:184:5: ( classDefinition | moduleDefinition )*
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:184:5: ( classDefinition | moduleDefinition )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Class||LA1_0==Relation) ) {
                    alt1=1;
                }
                else if ( (LA1_0==ModuleDef) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkSchema.g:184:6: classDefinition
            	    {
            	    pushFollow(FOLLOW_classDefinition_in_schema824);
            	    classDefinition1=classDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, classDefinition1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:184:24: moduleDefinition
            	    {
            	    pushFollow(FOLLOW_moduleDefinition_in_schema828);
            	    moduleDefinition2=moduleDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, moduleDefinition2.getTree());

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

    public static class moduleDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleDefinition"
    // SilkSchema.g:187:1: moduleDefinition : ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) ;
    public final SilkSchemaParser.moduleDefinition_return moduleDefinition() throws RecognitionException {
        SilkSchemaParser.moduleDefinition_return retval = new SilkSchemaParser.moduleDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ModuleDef3=null;
        Token End5=null;
        SilkSchemaParser.classDefinition_return classDefinition4 = null;


        Object ModuleDef3_tree=null;
        Object End5_tree=null;
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_ModuleDef=new RewriteRuleTokenStream(adaptor,"token ModuleDef");
        RewriteRuleSubtreeStream stream_classDefinition=new RewriteRuleSubtreeStream(adaptor,"rule classDefinition");
        try {
            // SilkSchema.g:187:17: ( ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) )
            // SilkSchema.g:188:2: ModuleDef ( classDefinition )* End
            {
            ModuleDef3=(Token)match(input,ModuleDef,FOLLOW_ModuleDef_in_moduleDefinition844);  
            stream_ModuleDef.add(ModuleDef3);

            // SilkSchema.g:188:12: ( classDefinition )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Class||LA2_0==Relation) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:188:12: classDefinition
            	    {
            	    pushFollow(FOLLOW_classDefinition_in_moduleDefinition846);
            	    classDefinition4=classDefinition();

            	    state._fsp--;

            	    stream_classDefinition.add(classDefinition4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            End5=(Token)match(input,End,FOLLOW_End_in_moduleDefinition849);  
            stream_End.add(End5);



            // AST REWRITE
            // elements: classDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 189:2: -> ^( Module Name[$ModuleDef.text] ( classDefinition )* )
            {
                // SilkSchema.g:189:5: ^( Module Name[$ModuleDef.text] ( classDefinition )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (ModuleDef3!=null?ModuleDef3.getText():null)));
                // SilkSchema.g:189:36: ( classDefinition )*
                while ( stream_classDefinition.hasNext() ) {
                    adaptor.addChild(root_1, stream_classDefinition.nextTree());

                }
                stream_classDefinition.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
    // $ANTLR end "moduleDefinition"

    public static class classDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classDefinition"
    // SilkSchema.g:192:1: classDefinition : ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) );
    public final SilkSchemaParser.classDefinition_return classDefinition() throws RecognitionException {
        SilkSchemaParser.classDefinition_return retval = new SilkSchemaParser.classDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Class6=null;
        Token QName7=null;
        Token End9=null;
        Token Relation10=null;
        Token QName11=null;
        Token End13=null;
        SilkSchemaParser.classBody_return classBody8 = null;

        SilkSchemaParser.classBody_return classBody12 = null;


        Object Class6_tree=null;
        Object QName7_tree=null;
        Object End9_tree=null;
        Object Relation10_tree=null;
        Object QName11_tree=null;
        Object End13_tree=null;
        RewriteRuleTokenStream stream_Relation=new RewriteRuleTokenStream(adaptor,"token Relation");
        RewriteRuleTokenStream stream_Class=new RewriteRuleTokenStream(adaptor,"token Class");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        try {
            // SilkSchema.g:193:3: ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Class) ) {
                alt3=1;
            }
            else if ( (LA3_0==Relation) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // SilkSchema.g:193:5: Class QName classBody End
                    {
                    Class6=(Token)match(input,Class,FOLLOW_Class_in_classDefinition879);  
                    stream_Class.add(Class6);

                    QName7=(Token)match(input,QName,FOLLOW_QName_in_classDefinition881);  
                    stream_QName.add(QName7);

                    pushFollow(FOLLOW_classBody_in_classDefinition883);
                    classBody8=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody8.getTree());
                    End9=(Token)match(input,End,FOLLOW_End_in_classDefinition885);  
                    stream_End.add(End9);



                    // AST REWRITE
                    // elements: classBody
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 193:31: -> ^( ClassDef Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:193:34: ^( ClassDef Name[$QName.text] classBody )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ClassDef, "ClassDef"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName7!=null?QName7.getText():null)));
                        adaptor.addChild(root_1, stream_classBody.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:194:5: Relation QName classBody End
                    {
                    Relation10=(Token)match(input,Relation,FOLLOW_Relation_in_classDefinition902);  
                    stream_Relation.add(Relation10);

                    QName11=(Token)match(input,QName,FOLLOW_QName_in_classDefinition904);  
                    stream_QName.add(QName11);

                    pushFollow(FOLLOW_classBody_in_classDefinition906);
                    classBody12=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody12.getTree());
                    End13=(Token)match(input,End,FOLLOW_End_in_classDefinition908);  
                    stream_End.add(End13);



                    // AST REWRITE
                    // elements: classBody, Relation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 194:34: -> ^( Relation Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:194:37: ^( Relation Name[$QName.text] classBody )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_Relation.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName11!=null?QName11.getText():null)));
                        adaptor.addChild(root_1, stream_classBody.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

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

    public static class classBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classBody"
    // SilkSchema.g:197:1: classBody : ( inheritance )? ( includeStatement | attributes )* ;
    public final SilkSchemaParser.classBody_return classBody() throws RecognitionException {
        SilkSchemaParser.classBody_return retval = new SilkSchemaParser.classBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.inheritance_return inheritance14 = null;

        SilkSchemaParser.includeStatement_return includeStatement15 = null;

        SilkSchemaParser.attributes_return attributes16 = null;



        try {
            // SilkSchema.g:197:10: ( ( inheritance )? ( includeStatement | attributes )* )
            // SilkSchema.g:197:12: ( inheritance )? ( includeStatement | attributes )*
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:197:12: ( inheritance )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Lt) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // SilkSchema.g:197:12: inheritance
                    {
                    pushFollow(FOLLOW_inheritance_in_classBody932);
                    inheritance14=inheritance();

                    state._fsp--;

                    adaptor.addChild(root_0, inheritance14.getTree());

                    }
                    break;

            }

            // SilkSchema.g:197:25: ( includeStatement | attributes )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Includes) ) {
                    alt5=1;
                }
                else if ( (LA5_0==Symbol||LA5_0==QName) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // SilkSchema.g:197:26: includeStatement
            	    {
            	    pushFollow(FOLLOW_includeStatement_in_classBody936);
            	    includeStatement15=includeStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeStatement15.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:197:45: attributes
            	    {
            	    pushFollow(FOLLOW_attributes_in_classBody940);
            	    attributes16=attributes();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributes16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "classBody"

    public static class inheritance_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inheritance"
    // SilkSchema.g:199:10: fragment inheritance : Lt QName -> Parent[$QName.text] ;
    public final SilkSchemaParser.inheritance_return inheritance() throws RecognitionException {
        SilkSchemaParser.inheritance_return retval = new SilkSchemaParser.inheritance_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Lt17=null;
        Token QName18=null;

        Object Lt17_tree=null;
        Object QName18_tree=null;
        RewriteRuleTokenStream stream_Lt=new RewriteRuleTokenStream(adaptor,"token Lt");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:199:21: ( Lt QName -> Parent[$QName.text] )
            // SilkSchema.g:199:23: Lt QName
            {
            Lt17=(Token)match(input,Lt,FOLLOW_Lt_in_inheritance953);  
            stream_Lt.add(Lt17);

            QName18=(Token)match(input,QName,FOLLOW_QName_in_inheritance955);  
            stream_QName.add(QName18);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 199:32: -> Parent[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Parent, (QName18!=null?QName18.getText():null)));

            }

            retval.tree = root_0;
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
    // $ANTLR end "inheritance"

    public static class includeStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "includeStatement"
    // SilkSchema.g:201:10: fragment includeStatement : Includes includeItem ( Comma includeItem )* -> ( includeItem )+ ;
    public final SilkSchemaParser.includeStatement_return includeStatement() throws RecognitionException {
        SilkSchemaParser.includeStatement_return retval = new SilkSchemaParser.includeStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Includes19=null;
        Token Comma21=null;
        SilkSchemaParser.includeItem_return includeItem20 = null;

        SilkSchemaParser.includeItem_return includeItem22 = null;


        Object Includes19_tree=null;
        Object Comma21_tree=null;
        RewriteRuleTokenStream stream_Includes=new RewriteRuleTokenStream(adaptor,"token Includes");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_includeItem=new RewriteRuleSubtreeStream(adaptor,"rule includeItem");
        try {
            // SilkSchema.g:201:26: ( Includes includeItem ( Comma includeItem )* -> ( includeItem )+ )
            // SilkSchema.g:201:28: Includes includeItem ( Comma includeItem )*
            {
            Includes19=(Token)match(input,Includes,FOLLOW_Includes_in_includeStatement971);  
            stream_Includes.add(Includes19);

            pushFollow(FOLLOW_includeItem_in_includeStatement973);
            includeItem20=includeItem();

            state._fsp--;

            stream_includeItem.add(includeItem20.getTree());
            // SilkSchema.g:201:49: ( Comma includeItem )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Comma) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SilkSchema.g:201:50: Comma includeItem
            	    {
            	    Comma21=(Token)match(input,Comma,FOLLOW_Comma_in_includeStatement976);  
            	    stream_Comma.add(Comma21);

            	    pushFollow(FOLLOW_includeItem_in_includeStatement978);
            	    includeItem22=includeItem();

            	    state._fsp--;

            	    stream_includeItem.add(includeItem22.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);



            // AST REWRITE
            // elements: includeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 201:70: -> ( includeItem )+
            {
                if ( !(stream_includeItem.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_includeItem.hasNext() ) {
                    adaptor.addChild(root_0, stream_includeItem.nextTree());

                }
                stream_includeItem.reset();

            }

            retval.tree = root_0;
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
    // $ANTLR end "includeStatement"

    public static class includeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "includeItem"
    // SilkSchema.g:203:10: fragment includeItem : QName -> Mixin[$QName.text] ;
    public final SilkSchemaParser.includeItem_return includeItem() throws RecognitionException {
        SilkSchemaParser.includeItem_return retval = new SilkSchemaParser.includeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName23=null;

        Object QName23_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:203:21: ( QName -> Mixin[$QName.text] )
            // SilkSchema.g:203:23: QName
            {
            QName23=(Token)match(input,QName,FOLLOW_QName_in_includeItem994);  
            stream_QName.add(QName23);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 203:29: -> Mixin[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Mixin, (QName23!=null?QName23.getText():null)));

            }

            retval.tree = root_0;
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
    // $ANTLR end "includeItem"

    public static class attributes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributes"
    // SilkSchema.g:206:10: fragment attributes : attribute ( Comma attribute )* -> ( attribute )+ ;
    public final SilkSchemaParser.attributes_return attributes() throws RecognitionException {
        SilkSchemaParser.attributes_return retval = new SilkSchemaParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma25=null;
        SilkSchemaParser.attribute_return attribute24 = null;

        SilkSchemaParser.attribute_return attribute26 = null;


        Object Comma25_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // SilkSchema.g:206:20: ( attribute ( Comma attribute )* -> ( attribute )+ )
            // SilkSchema.g:206:22: attribute ( Comma attribute )*
            {
            pushFollow(FOLLOW_attribute_in_attributes1009);
            attribute24=attribute();

            state._fsp--;

            stream_attribute.add(attribute24.getTree());
            // SilkSchema.g:206:32: ( Comma attribute )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // SilkSchema.g:206:33: Comma attribute
            	    {
            	    Comma25=(Token)match(input,Comma,FOLLOW_Comma_in_attributes1012);  
            	    stream_Comma.add(Comma25);

            	    pushFollow(FOLLOW_attribute_in_attributes1014);
            	    attribute26=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute26.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);



            // AST REWRITE
            // elements: attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 207:3: -> ( attribute )+
            {
                if ( !(stream_attribute.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_0, stream_attribute.nextTree());

                }
                stream_attribute.reset();

            }

            retval.tree = root_0;
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
    // $ANTLR end "attributes"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // SilkSchema.g:210:10: fragment attribute : ( attributeType )? Symbol -> ^( Attribute Name[$Symbol.text] ( attributeType )? ) ;
    public final SilkSchemaParser.attribute_return attribute() throws RecognitionException {
        SilkSchemaParser.attribute_return retval = new SilkSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol28=null;
        SilkSchemaParser.attributeType_return attributeType27 = null;


        Object Symbol28_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleSubtreeStream stream_attributeType=new RewriteRuleSubtreeStream(adaptor,"rule attributeType");
        try {
            // SilkSchema.g:210:19: ( ( attributeType )? Symbol -> ^( Attribute Name[$Symbol.text] ( attributeType )? ) )
            // SilkSchema.g:211:3: ( attributeType )? Symbol
            {
            // SilkSchema.g:211:3: ( attributeType )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==QName) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // SilkSchema.g:211:3: attributeType
                    {
                    pushFollow(FOLLOW_attributeType_in_attribute1040);
                    attributeType27=attributeType();

                    state._fsp--;

                    stream_attributeType.add(attributeType27.getTree());

                    }
                    break;

            }

            Symbol28=(Token)match(input,Symbol,FOLLOW_Symbol_in_attribute1043);  
            stream_Symbol.add(Symbol28);



            // AST REWRITE
            // elements: attributeType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 212:3: -> ^( Attribute Name[$Symbol.text] ( attributeType )? )
            {
                // SilkSchema.g:212:6: ^( Attribute Name[$Symbol.text] ( attributeType )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Attribute, "Attribute"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (Symbol28!=null?Symbol28.getText():null)));
                // SilkSchema.g:212:37: ( attributeType )?
                if ( stream_attributeType.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeType.nextTree());

                }
                stream_attributeType.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
    // $ANTLR end "attribute"

    public static class attributeType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeType"
    // SilkSchema.g:216:10: fragment attributeType : ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] );
    public final SilkSchemaParser.attributeType_return attributeType() throws RecognitionException {
        SilkSchemaParser.attributeType_return retval = new SilkSchemaParser.attributeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName29=null;
        Token QName30=null;
        Token Star31=null;

        Object QName29_tree=null;
        Object QName30_tree=null;
        Object Star31_tree=null;
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:217:3: ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==QName) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==Star) ) {
                    alt9=2;
                }
                else if ( (LA9_1==Symbol) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // SilkSchema.g:217:5: QName
                    {
                    QName29=(Token)match(input,QName,FOLLOW_QName_in_attributeType1079);  
                    stream_QName.add(QName29);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 217:11: -> TypeName[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName29!=null?QName29.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:218:5: QName Star
                    {
                    QName30=(Token)match(input,QName,FOLLOW_QName_in_attributeType1091);  
                    stream_QName.add(QName30);

                    Star31=(Token)match(input,Star,FOLLOW_Star_in_attributeType1093);  
                    stream_Star.add(Star31);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 218:16: -> TypeName[$QName.text] IsArray[\"true\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName30!=null?QName30.getText():null)));
                        adaptor.addChild(root_0, (Object)adaptor.create(IsArray, "true"));

                    }

                    retval.tree = root_0;
                    }
                    break;

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
    // $ANTLR end "attributeType"

    // Delegated rules


 

    public static final BitSet FOLLOW_classDefinition_in_schema824 = new BitSet(new long[]{0x0010900000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_schema828 = new BitSet(new long[]{0x0010900000000002L});
    public static final BitSet FOLLOW_ModuleDef_in_moduleDefinition844 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_classDefinition_in_moduleDefinition846 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_End_in_moduleDefinition849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition879 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition881 = new BitSet(new long[]{0x0040680400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition883 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relation_in_classDefinition902 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition904 = new BitSet(new long[]{0x0040680400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition906 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inheritance_in_classBody932 = new BitSet(new long[]{0x0040280000000002L});
    public static final BitSet FOLLOW_includeStatement_in_classBody936 = new BitSet(new long[]{0x0040280000000002L});
    public static final BitSet FOLLOW_attributes_in_classBody940 = new BitSet(new long[]{0x0040280000000002L});
    public static final BitSet FOLLOW_Lt_in_inheritance953 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_QName_in_inheritance955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Includes_in_includeStatement971 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement973 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_includeStatement976 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement978 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_QName_in_includeItem994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes1009 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_attributes1012 = new BitSet(new long[]{0x0040280000000000L});
    public static final BitSet FOLLOW_attribute_in_attributes1014 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeType_in_attribute1040 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Symbol_in_attribute1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1091 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Star_in_attributeType1093 = new BitSet(new long[]{0x0000000000000002L});

}
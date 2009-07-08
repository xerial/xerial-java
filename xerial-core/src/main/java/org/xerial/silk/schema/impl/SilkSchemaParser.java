// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-08 15:38:41

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Schema", "Module", "ClassDef", "Name", "Parent", "Mixin", "Attribute", "IsArray", "TypeName", "DefaultValue", "AllIncluded", "TargetClass", "Function", "Argument", "LineBreakChar", "Preamble", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Dot", "Comma", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "NonWhiteSpaceChar", "SymbolChars", "Symbol", "Class", "Includes", "End", "Relation", "Index", "BelongsTo", "Default", "Projection", "OrderBy", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "WhiteSpace", "QNameChar", "QName", "'on'"
    };
    public static final int TargetClass=15;
    public static final int Includes=49;
    public static final int NonWhiteSpaceChar=45;
    public static final int RBrace=35;
    public static final int Class=48;
    public static final int LBracket=36;
    public static final int SymbolChars=46;
    public static final int AllIncluded=14;
    public static final int Digit=22;
    public static final int Frac=31;
    public static final int HexDigit=24;
    public static final int Symbol=47;
    public static final int OrderBy=56;
    public static final int T__65=65;
    public static final int Default=54;
    public static final int Argument=17;
    public static final int Index=52;
    public static final int Module=5;
    public static final int Letter=23;
    public static final int Attribute=10;
    public static final int Comma=40;
    public static final int Schema=4;
    public static final int Dot=39;
    public static final int End=50;
    public static final int EscapeSequence=26;
    public static final int DefaultValue=13;
    public static final int Integer=30;
    public static final int Relation=51;
    public static final int Mixin=9;
    public static final int WhiteSpace=62;
    public static final int ClassDef=6;
    public static final int LineComment=20;
    public static final int ModuleName=59;
    public static final int Projection=55;
    public static final int BelongsTo=53;
    public static final int SafeFirstLetter=57;
    public static final int Star=43;
    public static final int Preamble=19;
    public static final int Exp=32;
    public static final int QNameChar=63;
    public static final int RParen=42;
    public static final int UnicodeChar=25;
    public static final int StringChar=27;
    public static final int LineBreak=21;
    public static final int Function=16;
    public static final int Name=7;
    public static final int ModuleDef=61;
    public static final int LParen=41;
    public static final int String=29;
    public static final int SafeLetter=58;
    public static final int LineBreakChar=18;
    public static final int IsArray=11;
    public static final int QName=64;
    public static final int EOF=-1;
    public static final int StringChar_s=28;
    public static final int UnsafeUnicodeChar=44;
    public static final int Double=33;
    public static final int LBrace=34;
    public static final int RBracket=37;
    public static final int Lt=38;
    public static final int Parent=8;
    public static final int TypeName=12;
    public static final int WhiteSpaces=60;

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
    // SilkSchema.g:192:1: schema : ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) ;
    public final SilkSchemaParser.schema_return schema() throws RecognitionException {
        SilkSchemaParser.schema_return retval = new SilkSchemaParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Preamble1=null;
        SilkSchemaParser.schemaElement_return schemaElement2 = null;


        Object Preamble1_tree=null;
        RewriteRuleTokenStream stream_Preamble=new RewriteRuleTokenStream(adaptor,"token Preamble");
        RewriteRuleSubtreeStream stream_schemaElement=new RewriteRuleSubtreeStream(adaptor,"rule schemaElement");
        try {
            // SilkSchema.g:192:7: ( ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) )
            // SilkSchema.g:192:10: ( Preamble )? ( schemaElement )*
            {
            // SilkSchema.g:192:10: ( Preamble )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Preamble) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // SilkSchema.g:192:10: Preamble
                    {
                    Preamble1=(Token)match(input,Preamble,FOLLOW_Preamble_in_schema873);  
                    stream_Preamble.add(Preamble1);


                    }
                    break;

            }

            // SilkSchema.g:192:20: ( schemaElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Class||LA2_0==Relation||LA2_0==Projection||LA2_0==ModuleDef) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:192:20: schemaElement
            	    {
            	    pushFollow(FOLLOW_schemaElement_in_schema876);
            	    schemaElement2=schemaElement();

            	    state._fsp--;

            	    stream_schemaElement.add(schemaElement2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: Preamble, schemaElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 192:36: -> ^( Schema ( Preamble )? ( schemaElement )* )
            {
                // SilkSchema.g:192:39: ^( Schema ( Preamble )? ( schemaElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Schema, "Schema"), root_1);

                // SilkSchema.g:192:48: ( Preamble )?
                if ( stream_Preamble.hasNext() ) {
                    adaptor.addChild(root_1, stream_Preamble.nextNode());

                }
                stream_Preamble.reset();
                // SilkSchema.g:192:58: ( schemaElement )*
                while ( stream_schemaElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_schemaElement.nextTree());

                }
                stream_schemaElement.reset();

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
    // $ANTLR end "schema"

    public static class schemaElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schemaElement"
    // SilkSchema.g:195:1: schemaElement : ( classDefinition | projectionDef | moduleDefinition );
    public final SilkSchemaParser.schemaElement_return schemaElement() throws RecognitionException {
        SilkSchemaParser.schemaElement_return retval = new SilkSchemaParser.schemaElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.classDefinition_return classDefinition3 = null;

        SilkSchemaParser.projectionDef_return projectionDef4 = null;

        SilkSchemaParser.moduleDefinition_return moduleDefinition5 = null;



        try {
            // SilkSchema.g:196:3: ( classDefinition | projectionDef | moduleDefinition )
            int alt3=3;
            switch ( input.LA(1) ) {
            case Class:
            case Relation:
                {
                alt3=1;
                }
                break;
            case Projection:
                {
                alt3=2;
                }
                break;
            case ModuleDef:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // SilkSchema.g:196:5: classDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classDefinition_in_schemaElement904);
                    classDefinition3=classDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, classDefinition3.getTree());

                    }
                    break;
                case 2 :
                    // SilkSchema.g:197:5: projectionDef
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_projectionDef_in_schemaElement911);
                    projectionDef4=projectionDef();

                    state._fsp--;

                    adaptor.addChild(root_0, projectionDef4.getTree());

                    }
                    break;
                case 3 :
                    // SilkSchema.g:198:5: moduleDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleDefinition_in_schemaElement917);
                    moduleDefinition5=moduleDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, moduleDefinition5.getTree());

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
    // $ANTLR end "schemaElement"

    public static class moduleDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleDefinition"
    // SilkSchema.g:202:1: moduleDefinition : ModuleDef ( schemaElement )* End -> ^( Module Name[$ModuleDef.text] ( schemaElement )* ) ;
    public final SilkSchemaParser.moduleDefinition_return moduleDefinition() throws RecognitionException {
        SilkSchemaParser.moduleDefinition_return retval = new SilkSchemaParser.moduleDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ModuleDef6=null;
        Token End8=null;
        SilkSchemaParser.schemaElement_return schemaElement7 = null;


        Object ModuleDef6_tree=null;
        Object End8_tree=null;
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_ModuleDef=new RewriteRuleTokenStream(adaptor,"token ModuleDef");
        RewriteRuleSubtreeStream stream_schemaElement=new RewriteRuleSubtreeStream(adaptor,"rule schemaElement");
        try {
            // SilkSchema.g:202:17: ( ModuleDef ( schemaElement )* End -> ^( Module Name[$ModuleDef.text] ( schemaElement )* ) )
            // SilkSchema.g:203:2: ModuleDef ( schemaElement )* End
            {
            ModuleDef6=(Token)match(input,ModuleDef,FOLLOW_ModuleDef_in_moduleDefinition929);  
            stream_ModuleDef.add(ModuleDef6);

            // SilkSchema.g:203:12: ( schemaElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Class||LA4_0==Relation||LA4_0==Projection||LA4_0==ModuleDef) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SilkSchema.g:203:12: schemaElement
            	    {
            	    pushFollow(FOLLOW_schemaElement_in_moduleDefinition931);
            	    schemaElement7=schemaElement();

            	    state._fsp--;

            	    stream_schemaElement.add(schemaElement7.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            End8=(Token)match(input,End,FOLLOW_End_in_moduleDefinition934);  
            stream_End.add(End8);



            // AST REWRITE
            // elements: schemaElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 204:2: -> ^( Module Name[$ModuleDef.text] ( schemaElement )* )
            {
                // SilkSchema.g:204:5: ^( Module Name[$ModuleDef.text] ( schemaElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (ModuleDef6!=null?ModuleDef6.getText():null)));
                // SilkSchema.g:204:36: ( schemaElement )*
                while ( stream_schemaElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_schemaElement.nextTree());

                }
                stream_schemaElement.reset();

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
    // SilkSchema.g:207:1: classDefinition : ( Class QName ( inheritance )? ( classBody )? End -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? ) | Relation QName ( inheritance )? ( classBody )? End -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? ) );
    public final SilkSchemaParser.classDefinition_return classDefinition() throws RecognitionException {
        SilkSchemaParser.classDefinition_return retval = new SilkSchemaParser.classDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Class9=null;
        Token QName10=null;
        Token End13=null;
        Token Relation14=null;
        Token QName15=null;
        Token End18=null;
        SilkSchemaParser.inheritance_return inheritance11 = null;

        SilkSchemaParser.classBody_return classBody12 = null;

        SilkSchemaParser.inheritance_return inheritance16 = null;

        SilkSchemaParser.classBody_return classBody17 = null;


        Object Class9_tree=null;
        Object QName10_tree=null;
        Object End13_tree=null;
        Object Relation14_tree=null;
        Object QName15_tree=null;
        Object End18_tree=null;
        RewriteRuleTokenStream stream_Relation=new RewriteRuleTokenStream(adaptor,"token Relation");
        RewriteRuleTokenStream stream_Class=new RewriteRuleTokenStream(adaptor,"token Class");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        RewriteRuleSubtreeStream stream_inheritance=new RewriteRuleSubtreeStream(adaptor,"rule inheritance");
        try {
            // SilkSchema.g:208:3: ( Class QName ( inheritance )? ( classBody )? End -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? ) | Relation QName ( inheritance )? ( classBody )? End -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Class) ) {
                alt9=1;
            }
            else if ( (LA9_0==Relation) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // SilkSchema.g:208:5: Class QName ( inheritance )? ( classBody )? End
                    {
                    Class9=(Token)match(input,Class,FOLLOW_Class_in_classDefinition966);  
                    stream_Class.add(Class9);

                    QName10=(Token)match(input,QName,FOLLOW_QName_in_classDefinition968);  
                    stream_QName.add(QName10);

                    // SilkSchema.g:208:17: ( inheritance )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==Lt) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // SilkSchema.g:208:17: inheritance
                            {
                            pushFollow(FOLLOW_inheritance_in_classDefinition970);
                            inheritance11=inheritance();

                            state._fsp--;

                            stream_inheritance.add(inheritance11.getTree());

                            }
                            break;

                    }

                    // SilkSchema.g:208:30: ( classBody )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Symbol||LA6_0==Includes||(LA6_0>=Index && LA6_0<=BelongsTo)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // SilkSchema.g:208:30: classBody
                            {
                            pushFollow(FOLLOW_classBody_in_classDefinition973);
                            classBody12=classBody();

                            state._fsp--;

                            stream_classBody.add(classBody12.getTree());

                            }
                            break;

                    }

                    End13=(Token)match(input,End,FOLLOW_End_in_classDefinition976);  
                    stream_End.add(End13);



                    // AST REWRITE
                    // elements: inheritance, classBody
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 208:45: -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? )
                    {
                        // SilkSchema.g:208:48: ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ClassDef, "ClassDef"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName10!=null?QName10.getText():null)));
                        // SilkSchema.g:208:77: ( inheritance )?
                        if ( stream_inheritance.hasNext() ) {
                            adaptor.addChild(root_1, stream_inheritance.nextTree());

                        }
                        stream_inheritance.reset();
                        // SilkSchema.g:208:90: ( classBody )?
                        if ( stream_classBody.hasNext() ) {
                            adaptor.addChild(root_1, stream_classBody.nextTree());

                        }
                        stream_classBody.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:209:7: Relation QName ( inheritance )? ( classBody )? End
                    {
                    Relation14=(Token)match(input,Relation,FOLLOW_Relation_in_classDefinition999);  
                    stream_Relation.add(Relation14);

                    QName15=(Token)match(input,QName,FOLLOW_QName_in_classDefinition1001);  
                    stream_QName.add(QName15);

                    // SilkSchema.g:209:22: ( inheritance )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==Lt) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // SilkSchema.g:209:22: inheritance
                            {
                            pushFollow(FOLLOW_inheritance_in_classDefinition1003);
                            inheritance16=inheritance();

                            state._fsp--;

                            stream_inheritance.add(inheritance16.getTree());

                            }
                            break;

                    }

                    // SilkSchema.g:209:35: ( classBody )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==Symbol||LA8_0==Includes||(LA8_0>=Index && LA8_0<=BelongsTo)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // SilkSchema.g:209:35: classBody
                            {
                            pushFollow(FOLLOW_classBody_in_classDefinition1006);
                            classBody17=classBody();

                            state._fsp--;

                            stream_classBody.add(classBody17.getTree());

                            }
                            break;

                    }

                    End18=(Token)match(input,End,FOLLOW_End_in_classDefinition1009);  
                    stream_End.add(End18);



                    // AST REWRITE
                    // elements: Relation, classBody, inheritance
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 209:50: -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? )
                    {
                        // SilkSchema.g:209:53: ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_Relation.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName15!=null?QName15.getText():null)));
                        // SilkSchema.g:209:82: ( inheritance )?
                        if ( stream_inheritance.hasNext() ) {
                            adaptor.addChild(root_1, stream_inheritance.nextTree());

                        }
                        stream_inheritance.reset();
                        // SilkSchema.g:209:95: ( classBody )?
                        if ( stream_classBody.hasNext() ) {
                            adaptor.addChild(root_1, stream_classBody.nextTree());

                        }
                        stream_classBody.reset();

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
    // SilkSchema.g:212:1: classBody : ( belongsToStatement | includeStatement | attributes | indexStatement )+ ;
    public final SilkSchemaParser.classBody_return classBody() throws RecognitionException {
        SilkSchemaParser.classBody_return retval = new SilkSchemaParser.classBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.belongsToStatement_return belongsToStatement19 = null;

        SilkSchemaParser.includeStatement_return includeStatement20 = null;

        SilkSchemaParser.attributes_return attributes21 = null;

        SilkSchemaParser.indexStatement_return indexStatement22 = null;



        try {
            // SilkSchema.g:212:10: ( ( belongsToStatement | includeStatement | attributes | indexStatement )+ )
            // SilkSchema.g:212:12: ( belongsToStatement | includeStatement | attributes | indexStatement )+
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:212:12: ( belongsToStatement | includeStatement | attributes | indexStatement )+
            int cnt10=0;
            loop10:
            do {
                int alt10=5;
                switch ( input.LA(1) ) {
                case BelongsTo:
                    {
                    alt10=1;
                    }
                    break;
                case Includes:
                    {
                    alt10=2;
                    }
                    break;
                case Symbol:
                    {
                    alt10=3;
                    }
                    break;
                case Index:
                    {
                    alt10=4;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // SilkSchema.g:212:13: belongsToStatement
            	    {
            	    pushFollow(FOLLOW_belongsToStatement_in_classBody1038);
            	    belongsToStatement19=belongsToStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, belongsToStatement19.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:212:34: includeStatement
            	    {
            	    pushFollow(FOLLOW_includeStatement_in_classBody1042);
            	    includeStatement20=includeStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeStatement20.getTree());

            	    }
            	    break;
            	case 3 :
            	    // SilkSchema.g:212:53: attributes
            	    {
            	    pushFollow(FOLLOW_attributes_in_classBody1046);
            	    attributes21=attributes();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributes21.getTree());

            	    }
            	    break;
            	case 4 :
            	    // SilkSchema.g:212:66: indexStatement
            	    {
            	    pushFollow(FOLLOW_indexStatement_in_classBody1050);
            	    indexStatement22=indexStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, indexStatement22.getTree());

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

    public static class projectionDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "projectionDef"
    // SilkSchema.g:215:1: projectionDef : Projection c= QName 'on' t= QName ( projectColumn ( ( Comma )? projectColumn )* ) ( orderByColumns )? End -> ^( Projection Name[$c.text] TargetClass[$t.text] ( projectColumn )+ ( orderByColumns )? ) ;
    public final SilkSchemaParser.projectionDef_return projectionDef() throws RecognitionException {
        SilkSchemaParser.projectionDef_return retval = new SilkSchemaParser.projectionDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token c=null;
        Token t=null;
        Token Projection23=null;
        Token string_literal24=null;
        Token Comma26=null;
        Token End29=null;
        SilkSchemaParser.projectColumn_return projectColumn25 = null;

        SilkSchemaParser.projectColumn_return projectColumn27 = null;

        SilkSchemaParser.orderByColumns_return orderByColumns28 = null;


        Object c_tree=null;
        Object t_tree=null;
        Object Projection23_tree=null;
        Object string_literal24_tree=null;
        Object Comma26_tree=null;
        Object End29_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_Projection=new RewriteRuleTokenStream(adaptor,"token Projection");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_projectColumn=new RewriteRuleSubtreeStream(adaptor,"rule projectColumn");
        RewriteRuleSubtreeStream stream_orderByColumns=new RewriteRuleSubtreeStream(adaptor,"rule orderByColumns");
        try {
            // SilkSchema.g:215:14: ( Projection c= QName 'on' t= QName ( projectColumn ( ( Comma )? projectColumn )* ) ( orderByColumns )? End -> ^( Projection Name[$c.text] TargetClass[$t.text] ( projectColumn )+ ( orderByColumns )? ) )
            // SilkSchema.g:215:16: Projection c= QName 'on' t= QName ( projectColumn ( ( Comma )? projectColumn )* ) ( orderByColumns )? End
            {
            Projection23=(Token)match(input,Projection,FOLLOW_Projection_in_projectionDef1060);  
            stream_Projection.add(Projection23);

            c=(Token)match(input,QName,FOLLOW_QName_in_projectionDef1064);  
            stream_QName.add(c);

            string_literal24=(Token)match(input,65,FOLLOW_65_in_projectionDef1066);  
            stream_65.add(string_literal24);

            t=(Token)match(input,QName,FOLLOW_QName_in_projectionDef1070);  
            stream_QName.add(t);

            // SilkSchema.g:215:48: ( projectColumn ( ( Comma )? projectColumn )* )
            // SilkSchema.g:215:49: projectColumn ( ( Comma )? projectColumn )*
            {
            pushFollow(FOLLOW_projectColumn_in_projectionDef1073);
            projectColumn25=projectColumn();

            state._fsp--;

            stream_projectColumn.add(projectColumn25.getTree());
            // SilkSchema.g:215:63: ( ( Comma )? projectColumn )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Comma||LA12_0==Star||LA12_0==Symbol||LA12_0==QName) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // SilkSchema.g:215:64: ( Comma )? projectColumn
            	    {
            	    // SilkSchema.g:215:64: ( Comma )?
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==Comma) ) {
            	        alt11=1;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // SilkSchema.g:215:64: Comma
            	            {
            	            Comma26=(Token)match(input,Comma,FOLLOW_Comma_in_projectionDef1076);  
            	            stream_Comma.add(Comma26);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_projectColumn_in_projectionDef1079);
            	    projectColumn27=projectColumn();

            	    state._fsp--;

            	    stream_projectColumn.add(projectColumn27.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            // SilkSchema.g:215:88: ( orderByColumns )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==OrderBy) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // SilkSchema.g:215:88: orderByColumns
                    {
                    pushFollow(FOLLOW_orderByColumns_in_projectionDef1084);
                    orderByColumns28=orderByColumns();

                    state._fsp--;

                    stream_orderByColumns.add(orderByColumns28.getTree());

                    }
                    break;

            }

            End29=(Token)match(input,End,FOLLOW_End_in_projectionDef1087);  
            stream_End.add(End29);



            // AST REWRITE
            // elements: Projection, orderByColumns, projectColumn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 216:2: -> ^( Projection Name[$c.text] TargetClass[$t.text] ( projectColumn )+ ( orderByColumns )? )
            {
                // SilkSchema.g:216:5: ^( Projection Name[$c.text] TargetClass[$t.text] ( projectColumn )+ ( orderByColumns )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_Projection.nextNode(), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (c!=null?c.getText():null)));
                adaptor.addChild(root_1, (Object)adaptor.create(TargetClass, (t!=null?t.getText():null)));
                if ( !(stream_projectColumn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_projectColumn.hasNext() ) {
                    adaptor.addChild(root_1, stream_projectColumn.nextTree());

                }
                stream_projectColumn.reset();
                // SilkSchema.g:216:68: ( orderByColumns )?
                if ( stream_orderByColumns.hasNext() ) {
                    adaptor.addChild(root_1, stream_orderByColumns.nextTree());

                }
                stream_orderByColumns.reset();

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
    // $ANTLR end "projectionDef"

    public static class projectColumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "projectColumn"
    // SilkSchema.g:218:1: fragment projectColumn : ( QName -> Attribute[$QName.text] | Star -> AllIncluded[\"true\"] | Symbol -> Attribute[$Symbol.text] );
    public final SilkSchemaParser.projectColumn_return projectColumn() throws RecognitionException {
        SilkSchemaParser.projectColumn_return retval = new SilkSchemaParser.projectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName30=null;
        Token Star31=null;
        Token Symbol32=null;

        Object QName30_tree=null;
        Object Star31_tree=null;
        Object Symbol32_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:220:3: ( QName -> Attribute[$QName.text] | Star -> AllIncluded[\"true\"] | Symbol -> Attribute[$Symbol.text] )
            int alt14=3;
            switch ( input.LA(1) ) {
            case QName:
                {
                alt14=1;
                }
                break;
            case Star:
                {
                alt14=2;
                }
                break;
            case Symbol:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // SilkSchema.g:220:5: QName
                    {
                    QName30=(Token)match(input,QName,FOLLOW_QName_in_projectColumn1119);  
                    stream_QName.add(QName30);



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
                    // 220:12: -> Attribute[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Attribute, (QName30!=null?QName30.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:221:5: Star
                    {
                    Star31=(Token)match(input,Star,FOLLOW_Star_in_projectColumn1131);  
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
                    // 221:10: -> AllIncluded[\"true\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(AllIncluded, "true"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // SilkSchema.g:222:5: Symbol
                    {
                    Symbol32=(Token)match(input,Symbol,FOLLOW_Symbol_in_projectColumn1143);  
                    stream_Symbol.add(Symbol32);



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
                    // 222:12: -> Attribute[$Symbol.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Attribute, (Symbol32!=null?Symbol32.getText():null)));

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
    // $ANTLR end "projectColumn"

    public static class orderByColumns_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderByColumns"
    // SilkSchema.g:225:1: fragment orderByColumns : OrderBy orderByItem ( Comma orderByItem )* -> ( orderByItem )+ ;
    public final SilkSchemaParser.orderByColumns_return orderByColumns() throws RecognitionException {
        SilkSchemaParser.orderByColumns_return retval = new SilkSchemaParser.orderByColumns_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OrderBy33=null;
        Token Comma35=null;
        SilkSchemaParser.orderByItem_return orderByItem34 = null;

        SilkSchemaParser.orderByItem_return orderByItem36 = null;


        Object OrderBy33_tree=null;
        Object Comma35_tree=null;
        RewriteRuleTokenStream stream_OrderBy=new RewriteRuleTokenStream(adaptor,"token OrderBy");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_orderByItem=new RewriteRuleSubtreeStream(adaptor,"rule orderByItem");
        try {
            // SilkSchema.g:227:3: ( OrderBy orderByItem ( Comma orderByItem )* -> ( orderByItem )+ )
            // SilkSchema.g:227:5: OrderBy orderByItem ( Comma orderByItem )*
            {
            OrderBy33=(Token)match(input,OrderBy,FOLLOW_OrderBy_in_orderByColumns1161);  
            stream_OrderBy.add(OrderBy33);

            pushFollow(FOLLOW_orderByItem_in_orderByColumns1163);
            orderByItem34=orderByItem();

            state._fsp--;

            stream_orderByItem.add(orderByItem34.getTree());
            // SilkSchema.g:227:25: ( Comma orderByItem )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Comma) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // SilkSchema.g:227:26: Comma orderByItem
            	    {
            	    Comma35=(Token)match(input,Comma,FOLLOW_Comma_in_orderByColumns1166);  
            	    stream_Comma.add(Comma35);

            	    pushFollow(FOLLOW_orderByItem_in_orderByColumns1168);
            	    orderByItem36=orderByItem();

            	    state._fsp--;

            	    stream_orderByItem.add(orderByItem36.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: orderByItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 227:46: -> ( orderByItem )+
            {
                if ( !(stream_orderByItem.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_orderByItem.hasNext() ) {
                    adaptor.addChild(root_0, stream_orderByItem.nextTree());

                }
                stream_orderByItem.reset();

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
    // $ANTLR end "orderByColumns"

    public static class orderByItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderByItem"
    // SilkSchema.g:230:1: fragment orderByItem : ( QName -> OrderBy[$QName.text] | Symbol -> OrderBy[$Symbol.text] );
    public final SilkSchemaParser.orderByItem_return orderByItem() throws RecognitionException {
        SilkSchemaParser.orderByItem_return retval = new SilkSchemaParser.orderByItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName37=null;
        Token Symbol38=null;

        Object QName37_tree=null;
        Object Symbol38_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:232:3: ( QName -> OrderBy[$QName.text] | Symbol -> OrderBy[$Symbol.text] )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==QName) ) {
                alt16=1;
            }
            else if ( (LA16_0==Symbol) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // SilkSchema.g:232:5: QName
                    {
                    QName37=(Token)match(input,QName,FOLLOW_QName_in_orderByItem1188);  
                    stream_QName.add(QName37);



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
                    // 232:11: -> OrderBy[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OrderBy, (QName37!=null?QName37.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:233:5: Symbol
                    {
                    Symbol38=(Token)match(input,Symbol,FOLLOW_Symbol_in_orderByItem1200);  
                    stream_Symbol.add(Symbol38);



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
                    // 233:12: -> OrderBy[$Symbol.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OrderBy, (Symbol38!=null?Symbol38.getText():null)));

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
    // $ANTLR end "orderByItem"

    public static class functionArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArg"
    // SilkSchema.g:237:1: fragment functionArg : Symbol -> Argument[$Symbol.text] ;
    public final SilkSchemaParser.functionArg_return functionArg() throws RecognitionException {
        SilkSchemaParser.functionArg_return retval = new SilkSchemaParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol39=null;

        Object Symbol39_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            // SilkSchema.g:238:12: ( Symbol -> Argument[$Symbol.text] )
            // SilkSchema.g:238:14: Symbol
            {
            Symbol39=(Token)match(input,Symbol,FOLLOW_Symbol_in_functionArg1216);  
            stream_Symbol.add(Symbol39);



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
            // 238:21: -> Argument[$Symbol.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Argument, (Symbol39!=null?Symbol39.getText():null)));

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
    // $ANTLR end "functionArg"

    public static class belongsToStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "belongsToStatement"
    // SilkSchema.g:241:1: fragment belongsToStatement : BelongsTo QName -> BelongsTo[$QName.text] ;
    public final SilkSchemaParser.belongsToStatement_return belongsToStatement() throws RecognitionException {
        SilkSchemaParser.belongsToStatement_return retval = new SilkSchemaParser.belongsToStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BelongsTo40=null;
        Token QName41=null;

        Object BelongsTo40_tree=null;
        Object QName41_tree=null;
        RewriteRuleTokenStream stream_BelongsTo=new RewriteRuleTokenStream(adaptor,"token BelongsTo");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:242:19: ( BelongsTo QName -> BelongsTo[$QName.text] )
            // SilkSchema.g:242:21: BelongsTo QName
            {
            BelongsTo40=(Token)match(input,BelongsTo,FOLLOW_BelongsTo_in_belongsToStatement1232);  
            stream_BelongsTo.add(BelongsTo40);

            QName41=(Token)match(input,QName,FOLLOW_QName_in_belongsToStatement1234);  
            stream_QName.add(QName41);



            // AST REWRITE
            // elements: BelongsTo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 242:37: -> BelongsTo[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(BelongsTo, (QName41!=null?QName41.getText():null)));

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
    // $ANTLR end "belongsToStatement"

    public static class inheritance_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inheritance"
    // SilkSchema.g:244:1: fragment inheritance : Lt QName -> Parent[$QName.text] ;
    public final SilkSchemaParser.inheritance_return inheritance() throws RecognitionException {
        SilkSchemaParser.inheritance_return retval = new SilkSchemaParser.inheritance_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Lt42=null;
        Token QName43=null;

        Object Lt42_tree=null;
        Object QName43_tree=null;
        RewriteRuleTokenStream stream_Lt=new RewriteRuleTokenStream(adaptor,"token Lt");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:245:12: ( Lt QName -> Parent[$QName.text] )
            // SilkSchema.g:245:14: Lt QName
            {
            Lt42=(Token)match(input,Lt,FOLLOW_Lt_in_inheritance1252);  
            stream_Lt.add(Lt42);

            QName43=(Token)match(input,QName,FOLLOW_QName_in_inheritance1254);  
            stream_QName.add(QName43);



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
            // 245:23: -> Parent[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Parent, (QName43!=null?QName43.getText():null)));

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
    // SilkSchema.g:247:1: fragment includeStatement : Includes includeItem ( Comma includeItem )* -> ( includeItem )+ ;
    public final SilkSchemaParser.includeStatement_return includeStatement() throws RecognitionException {
        SilkSchemaParser.includeStatement_return retval = new SilkSchemaParser.includeStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Includes44=null;
        Token Comma46=null;
        SilkSchemaParser.includeItem_return includeItem45 = null;

        SilkSchemaParser.includeItem_return includeItem47 = null;


        Object Includes44_tree=null;
        Object Comma46_tree=null;
        RewriteRuleTokenStream stream_Includes=new RewriteRuleTokenStream(adaptor,"token Includes");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_includeItem=new RewriteRuleSubtreeStream(adaptor,"rule includeItem");
        try {
            // SilkSchema.g:248:17: ( Includes includeItem ( Comma includeItem )* -> ( includeItem )+ )
            // SilkSchema.g:248:19: Includes includeItem ( Comma includeItem )*
            {
            Includes44=(Token)match(input,Includes,FOLLOW_Includes_in_includeStatement1271);  
            stream_Includes.add(Includes44);

            pushFollow(FOLLOW_includeItem_in_includeStatement1273);
            includeItem45=includeItem();

            state._fsp--;

            stream_includeItem.add(includeItem45.getTree());
            // SilkSchema.g:248:40: ( Comma includeItem )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Comma) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // SilkSchema.g:248:41: Comma includeItem
            	    {
            	    Comma46=(Token)match(input,Comma,FOLLOW_Comma_in_includeStatement1276);  
            	    stream_Comma.add(Comma46);

            	    pushFollow(FOLLOW_includeItem_in_includeStatement1278);
            	    includeItem47=includeItem();

            	    state._fsp--;

            	    stream_includeItem.add(includeItem47.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
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
            // 248:61: -> ( includeItem )+
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
    // SilkSchema.g:250:1: fragment includeItem : QName -> Mixin[$QName.text] ;
    public final SilkSchemaParser.includeItem_return includeItem() throws RecognitionException {
        SilkSchemaParser.includeItem_return retval = new SilkSchemaParser.includeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName48=null;

        Object QName48_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:251:12: ( QName -> Mixin[$QName.text] )
            // SilkSchema.g:251:14: QName
            {
            QName48=(Token)match(input,QName,FOLLOW_QName_in_includeItem1295);  
            stream_QName.add(QName48);



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
            // 251:20: -> Mixin[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Mixin, (QName48!=null?QName48.getText():null)));

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

    public static class indexStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexStatement"
    // SilkSchema.g:253:1: fragment indexStatement : Index QName indexTarget ( Comma indexTarget )* -> ^( Index TypeName[$QName.text] ( indexTarget )+ ) ;
    public final SilkSchemaParser.indexStatement_return indexStatement() throws RecognitionException {
        SilkSchemaParser.indexStatement_return retval = new SilkSchemaParser.indexStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Index49=null;
        Token QName50=null;
        Token Comma52=null;
        SilkSchemaParser.indexTarget_return indexTarget51 = null;

        SilkSchemaParser.indexTarget_return indexTarget53 = null;


        Object Index49_tree=null;
        Object QName50_tree=null;
        Object Comma52_tree=null;
        RewriteRuleTokenStream stream_Index=new RewriteRuleTokenStream(adaptor,"token Index");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_indexTarget=new RewriteRuleSubtreeStream(adaptor,"rule indexTarget");
        try {
            // SilkSchema.g:254:15: ( Index QName indexTarget ( Comma indexTarget )* -> ^( Index TypeName[$QName.text] ( indexTarget )+ ) )
            // SilkSchema.g:254:17: Index QName indexTarget ( Comma indexTarget )*
            {
            Index49=(Token)match(input,Index,FOLLOW_Index_in_indexStatement1310);  
            stream_Index.add(Index49);

            QName50=(Token)match(input,QName,FOLLOW_QName_in_indexStatement1312);  
            stream_QName.add(QName50);

            pushFollow(FOLLOW_indexTarget_in_indexStatement1314);
            indexTarget51=indexTarget();

            state._fsp--;

            stream_indexTarget.add(indexTarget51.getTree());
            // SilkSchema.g:254:41: ( Comma indexTarget )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Comma) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // SilkSchema.g:254:42: Comma indexTarget
            	    {
            	    Comma52=(Token)match(input,Comma,FOLLOW_Comma_in_indexStatement1317);  
            	    stream_Comma.add(Comma52);

            	    pushFollow(FOLLOW_indexTarget_in_indexStatement1319);
            	    indexTarget53=indexTarget();

            	    state._fsp--;

            	    stream_indexTarget.add(indexTarget53.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: Index, indexTarget
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 255:3: -> ^( Index TypeName[$QName.text] ( indexTarget )+ )
            {
                // SilkSchema.g:255:6: ^( Index TypeName[$QName.text] ( indexTarget )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_Index.nextNode(), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(TypeName, (QName50!=null?QName50.getText():null)));
                if ( !(stream_indexTarget.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_indexTarget.hasNext() ) {
                    adaptor.addChild(root_1, stream_indexTarget.nextTree());

                }
                stream_indexTarget.reset();

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
    // $ANTLR end "indexStatement"

    public static class indexTarget_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexTarget"
    // SilkSchema.g:258:1: fragment indexTarget : Symbol -> Attribute[$Symbol.text] ;
    public final SilkSchemaParser.indexTarget_return indexTarget() throws RecognitionException {
        SilkSchemaParser.indexTarget_return retval = new SilkSchemaParser.indexTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol54=null;

        Object Symbol54_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            // SilkSchema.g:259:12: ( Symbol -> Attribute[$Symbol.text] )
            // SilkSchema.g:259:14: Symbol
            {
            Symbol54=(Token)match(input,Symbol,FOLLOW_Symbol_in_indexTarget1347);  
            stream_Symbol.add(Symbol54);



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
            // 259:21: -> Attribute[$Symbol.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Attribute, (Symbol54!=null?Symbol54.getText():null)));

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
    // $ANTLR end "indexTarget"

    public static class attributes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributes"
    // SilkSchema.g:263:1: fragment attributes : attribute ( Comma attribute )* -> ( attribute )+ ;
    public final SilkSchemaParser.attributes_return attributes() throws RecognitionException {
        SilkSchemaParser.attributes_return retval = new SilkSchemaParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma56=null;
        SilkSchemaParser.attribute_return attribute55 = null;

        SilkSchemaParser.attribute_return attribute57 = null;


        Object Comma56_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // SilkSchema.g:264:11: ( attribute ( Comma attribute )* -> ( attribute )+ )
            // SilkSchema.g:264:13: attribute ( Comma attribute )*
            {
            pushFollow(FOLLOW_attribute_in_attributes1367);
            attribute55=attribute();

            state._fsp--;

            stream_attribute.add(attribute55.getTree());
            // SilkSchema.g:264:23: ( Comma attribute )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Comma) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // SilkSchema.g:264:24: Comma attribute
            	    {
            	    Comma56=(Token)match(input,Comma,FOLLOW_Comma_in_attributes1370);  
            	    stream_Comma.add(Comma56);

            	    pushFollow(FOLLOW_attribute_in_attributes1372);
            	    attribute57=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute57.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
            // 265:3: -> ( attribute )+
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
    // SilkSchema.g:268:1: fragment attribute : Symbol ( attributeType )? ( Default attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) ;
    public final SilkSchemaParser.attribute_return attribute() throws RecognitionException {
        SilkSchemaParser.attribute_return retval = new SilkSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol58=null;
        Token Default60=null;
        SilkSchemaParser.attributeType_return attributeType59 = null;

        SilkSchemaParser.attributeValue_return attributeValue61 = null;


        Object Symbol58_tree=null;
        Object Default60_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_Default=new RewriteRuleTokenStream(adaptor,"token Default");
        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_attributeType=new RewriteRuleSubtreeStream(adaptor,"rule attributeType");
        try {
            // SilkSchema.g:269:10: ( Symbol ( attributeType )? ( Default attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) )
            // SilkSchema.g:270:3: Symbol ( attributeType )? ( Default attributeValue )?
            {
            Symbol58=(Token)match(input,Symbol,FOLLOW_Symbol_in_attribute1399);  
            stream_Symbol.add(Symbol58);

            // SilkSchema.g:270:10: ( attributeType )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==QName) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // SilkSchema.g:270:10: attributeType
                    {
                    pushFollow(FOLLOW_attributeType_in_attribute1401);
                    attributeType59=attributeType();

                    state._fsp--;

                    stream_attributeType.add(attributeType59.getTree());

                    }
                    break;

            }

            // SilkSchema.g:270:25: ( Default attributeValue )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Default) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // SilkSchema.g:270:26: Default attributeValue
                    {
                    Default60=(Token)match(input,Default,FOLLOW_Default_in_attribute1405);  
                    stream_Default.add(Default60);

                    pushFollow(FOLLOW_attributeValue_in_attribute1407);
                    attributeValue61=attributeValue();

                    state._fsp--;

                    stream_attributeValue.add(attributeValue61.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeValue, attributeType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 271:3: -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
            {
                // SilkSchema.g:271:6: ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Attribute, "Attribute"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (Symbol58!=null?Symbol58.getText():null)));
                // SilkSchema.g:271:37: ( attributeType )?
                if ( stream_attributeType.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeType.nextTree());

                }
                stream_attributeType.reset();
                // SilkSchema.g:271:52: ( attributeValue )?
                if ( stream_attributeValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeValue.nextTree());

                }
                stream_attributeValue.reset();

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

    public static class attributeValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeValue"
    // SilkSchema.g:274:1: attributeValue : ( String | Double | Integer ) -> DefaultValue[$attributeValue.text] ;
    public final SilkSchemaParser.attributeValue_return attributeValue() throws RecognitionException {
        SilkSchemaParser.attributeValue_return retval = new SilkSchemaParser.attributeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String62=null;
        Token Double63=null;
        Token Integer64=null;

        Object String62_tree=null;
        Object Double63_tree=null;
        Object Integer64_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");

        try {
            // SilkSchema.g:275:3: ( ( String | Double | Integer ) -> DefaultValue[$attributeValue.text] )
            // SilkSchema.g:275:5: ( String | Double | Integer )
            {
            // SilkSchema.g:275:5: ( String | Double | Integer )
            int alt22=3;
            switch ( input.LA(1) ) {
            case String:
                {
                alt22=1;
                }
                break;
            case Double:
                {
                alt22=2;
                }
                break;
            case Integer:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // SilkSchema.g:275:6: String
                    {
                    String62=(Token)match(input,String,FOLLOW_String_in_attributeValue1445);  
                    stream_String.add(String62);


                    }
                    break;
                case 2 :
                    // SilkSchema.g:275:15: Double
                    {
                    Double63=(Token)match(input,Double,FOLLOW_Double_in_attributeValue1449);  
                    stream_Double.add(Double63);


                    }
                    break;
                case 3 :
                    // SilkSchema.g:275:24: Integer
                    {
                    Integer64=(Token)match(input,Integer,FOLLOW_Integer_in_attributeValue1453);  
                    stream_Integer.add(Integer64);


                    }
                    break;

            }



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
            // 275:33: -> DefaultValue[$attributeValue.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(DefaultValue, input.toString(retval.start,input.LT(-1))));

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
    // $ANTLR end "attributeValue"

    public static class attributeType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeType"
    // SilkSchema.g:277:10: fragment attributeType : ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] );
    public final SilkSchemaParser.attributeType_return attributeType() throws RecognitionException {
        SilkSchemaParser.attributeType_return retval = new SilkSchemaParser.attributeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName65=null;
        Token QName66=null;
        Token Star67=null;

        Object QName65_tree=null;
        Object QName66_tree=null;
        Object Star67_tree=null;
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:278:3: ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==QName) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==Star) ) {
                    alt23=2;
                }
                else if ( (LA23_1==Comma||LA23_1==Symbol||(LA23_1>=Includes && LA23_1<=End)||(LA23_1>=Index && LA23_1<=Default)) ) {
                    alt23=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // SilkSchema.g:278:5: QName
                    {
                    QName65=(Token)match(input,QName,FOLLOW_QName_in_attributeType1474);  
                    stream_QName.add(QName65);



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
                    // 278:11: -> TypeName[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName65!=null?QName65.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:279:5: QName Star
                    {
                    QName66=(Token)match(input,QName,FOLLOW_QName_in_attributeType1486);  
                    stream_QName.add(QName66);

                    Star67=(Token)match(input,Star,FOLLOW_Star_in_attributeType1488);  
                    stream_Star.add(Star67);



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
                    // 279:16: -> TypeName[$QName.text] IsArray[\"true\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName66!=null?QName66.getText():null)));
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


 

    public static final BitSet FOLLOW_Preamble_in_schema873 = new BitSet(new long[]{0x2089000000000002L});
    public static final BitSet FOLLOW_schemaElement_in_schema876 = new BitSet(new long[]{0x2089000000000002L});
    public static final BitSet FOLLOW_classDefinition_in_schemaElement904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_projectionDef_in_schemaElement911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_schemaElement917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ModuleDef_in_moduleDefinition929 = new BitSet(new long[]{0x208D000000000000L});
    public static final BitSet FOLLOW_schemaElement_in_moduleDefinition931 = new BitSet(new long[]{0x208D000000000000L});
    public static final BitSet FOLLOW_End_in_moduleDefinition934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_classDefinition968 = new BitSet(new long[]{0x0036804000000000L});
    public static final BitSet FOLLOW_inheritance_in_classDefinition970 = new BitSet(new long[]{0x0036800000000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition973 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relation_in_classDefinition999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_classDefinition1001 = new BitSet(new long[]{0x0036804000000000L});
    public static final BitSet FOLLOW_inheritance_in_classDefinition1003 = new BitSet(new long[]{0x0036800000000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition1006 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_belongsToStatement_in_classBody1038 = new BitSet(new long[]{0x0032800000000002L});
    public static final BitSet FOLLOW_includeStatement_in_classBody1042 = new BitSet(new long[]{0x0032800000000002L});
    public static final BitSet FOLLOW_attributes_in_classBody1046 = new BitSet(new long[]{0x0032800000000002L});
    public static final BitSet FOLLOW_indexStatement_in_classBody1050 = new BitSet(new long[]{0x0032800000000002L});
    public static final BitSet FOLLOW_Projection_in_projectionDef1060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_projectionDef1064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_projectionDef1066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_projectionDef1070 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_projectColumn_in_projectionDef1073 = new BitSet(new long[]{0x0104890000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_Comma_in_projectionDef1076 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_projectColumn_in_projectionDef1079 = new BitSet(new long[]{0x0104890000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderByColumns_in_projectionDef1084 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_End_in_projectionDef1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_projectColumn1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_projectColumn1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_projectColumn1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OrderBy_in_orderByColumns1161 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderByItem_in_orderByColumns1163 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Comma_in_orderByColumns1166 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderByItem_in_orderByColumns1168 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_QName_in_orderByItem1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_orderByItem1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_functionArg1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BelongsTo_in_belongsToStatement1232 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_belongsToStatement1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lt_in_inheritance1252 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_inheritance1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Includes_in_includeStatement1271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1273 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Comma_in_includeStatement1276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1278 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_QName_in_includeItem1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Index_in_indexStatement1310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_QName_in_indexStatement1312 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1314 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Comma_in_indexStatement1317 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1319 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Symbol_in_indexTarget1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes1367 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Comma_in_attributes1370 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_attribute_in_attributes1372 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Symbol_in_attribute1399 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_attributeType_in_attribute1401 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_Default_in_attribute1405 = new BitSet(new long[]{0x0000000260000000L});
    public static final BitSet FOLLOW_attributeValue_in_attribute1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_attributeValue1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_attributeValue1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_attributeValue1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1486 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Star_in_attributeType1488 = new BitSet(new long[]{0x0000000000000002L});

}
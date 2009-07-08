// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-07 19:14:42

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Schema", "Module", "ClassDef", "Name", "Parent", "Mixin", "Attribute", "IsArray", "TypeName", "DefaultValue", "LineBreakChar", "Preamble", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Dot", "Comma", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "NonWhiteSpaceChar", "SymbolChars", "Symbol", "Class", "Includes", "End", "Relation", "Index", "BelongsTo", "Default", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "WhiteSpace", "QNameChar", "QName"
    };
    public static final int Includes=45;
    public static final int RBrace=31;
    public static final int NonWhiteSpaceChar=41;
    public static final int Class=44;
    public static final int LBracket=32;
    public static final int Digit=18;
    public static final int SymbolChars=42;
    public static final int Frac=27;
    public static final int HexDigit=20;
    public static final int Symbol=43;
    public static final int Default=50;
    public static final int Index=48;
    public static final int Module=5;
    public static final int Letter=19;
    public static final int Attribute=10;
    public static final int Comma=36;
    public static final int Schema=4;
    public static final int Dot=35;
    public static final int End=46;
    public static final int EscapeSequence=22;
    public static final int DefaultValue=13;
    public static final int Integer=26;
    public static final int Relation=47;
    public static final int Mixin=9;
    public static final int WhiteSpace=56;
    public static final int ClassDef=6;
    public static final int LineComment=16;
    public static final int ModuleName=53;
    public static final int BelongsTo=49;
    public static final int SafeFirstLetter=51;
    public static final int Star=39;
    public static final int Preamble=15;
    public static final int Exp=28;
    public static final int QNameChar=57;
    public static final int RParen=38;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=17;
    public static final int Name=7;
    public static final int ModuleDef=55;
    public static final int LParen=37;
    public static final int String=25;
    public static final int SafeLetter=52;
    public static final int LineBreakChar=14;
    public static final int IsArray=11;
    public static final int QName=58;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int UnsafeUnicodeChar=40;
    public static final int Double=29;
    public static final int LBrace=30;
    public static final int RBracket=33;
    public static final int Lt=34;
    public static final int Parent=8;
    public static final int TypeName=12;
    public static final int WhiteSpaces=54;

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
    // SilkSchema.g:186:1: schema : ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) ;
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
            // SilkSchema.g:186:7: ( ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) )
            // SilkSchema.g:186:10: ( Preamble )? ( schemaElement )*
            {
            // SilkSchema.g:186:10: ( Preamble )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Preamble) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // SilkSchema.g:186:10: Preamble
                    {
                    Preamble1=(Token)match(input,Preamble,FOLLOW_Preamble_in_schema841);  
                    stream_Preamble.add(Preamble1);


                    }
                    break;

            }

            // SilkSchema.g:186:20: ( schemaElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Class||LA2_0==Relation||LA2_0==ModuleDef) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:186:20: schemaElement
            	    {
            	    pushFollow(FOLLOW_schemaElement_in_schema844);
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
            // 186:36: -> ^( Schema ( Preamble )? ( schemaElement )* )
            {
                // SilkSchema.g:186:39: ^( Schema ( Preamble )? ( schemaElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Schema, "Schema"), root_1);

                // SilkSchema.g:186:48: ( Preamble )?
                if ( stream_Preamble.hasNext() ) {
                    adaptor.addChild(root_1, stream_Preamble.nextNode());

                }
                stream_Preamble.reset();
                // SilkSchema.g:186:58: ( schemaElement )*
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
    // SilkSchema.g:189:1: schemaElement : ( classDefinition | moduleDefinition );
    public final SilkSchemaParser.schemaElement_return schemaElement() throws RecognitionException {
        SilkSchemaParser.schemaElement_return retval = new SilkSchemaParser.schemaElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.classDefinition_return classDefinition3 = null;

        SilkSchemaParser.moduleDefinition_return moduleDefinition4 = null;



        try {
            // SilkSchema.g:190:3: ( classDefinition | moduleDefinition )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Class||LA3_0==Relation) ) {
                alt3=1;
            }
            else if ( (LA3_0==ModuleDef) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // SilkSchema.g:190:5: classDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classDefinition_in_schemaElement872);
                    classDefinition3=classDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, classDefinition3.getTree());

                    }
                    break;
                case 2 :
                    // SilkSchema.g:191:5: moduleDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleDefinition_in_schemaElement879);
                    moduleDefinition4=moduleDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, moduleDefinition4.getTree());

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
    // SilkSchema.g:195:1: moduleDefinition : ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) ;
    public final SilkSchemaParser.moduleDefinition_return moduleDefinition() throws RecognitionException {
        SilkSchemaParser.moduleDefinition_return retval = new SilkSchemaParser.moduleDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ModuleDef5=null;
        Token End7=null;
        SilkSchemaParser.classDefinition_return classDefinition6 = null;


        Object ModuleDef5_tree=null;
        Object End7_tree=null;
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_ModuleDef=new RewriteRuleTokenStream(adaptor,"token ModuleDef");
        RewriteRuleSubtreeStream stream_classDefinition=new RewriteRuleSubtreeStream(adaptor,"rule classDefinition");
        try {
            // SilkSchema.g:195:17: ( ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) )
            // SilkSchema.g:196:2: ModuleDef ( classDefinition )* End
            {
            ModuleDef5=(Token)match(input,ModuleDef,FOLLOW_ModuleDef_in_moduleDefinition891);  
            stream_ModuleDef.add(ModuleDef5);

            // SilkSchema.g:196:12: ( classDefinition )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Class||LA4_0==Relation) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SilkSchema.g:196:12: classDefinition
            	    {
            	    pushFollow(FOLLOW_classDefinition_in_moduleDefinition893);
            	    classDefinition6=classDefinition();

            	    state._fsp--;

            	    stream_classDefinition.add(classDefinition6.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            End7=(Token)match(input,End,FOLLOW_End_in_moduleDefinition896);  
            stream_End.add(End7);



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
            // 197:2: -> ^( Module Name[$ModuleDef.text] ( classDefinition )* )
            {
                // SilkSchema.g:197:5: ^( Module Name[$ModuleDef.text] ( classDefinition )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (ModuleDef5!=null?ModuleDef5.getText():null)));
                // SilkSchema.g:197:36: ( classDefinition )*
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
    // SilkSchema.g:200:1: classDefinition : ( Class QName ( inheritance )? ( classBody )? End -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? ) | Relation QName ( inheritance )? ( classBody )? End -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? ) );
    public final SilkSchemaParser.classDefinition_return classDefinition() throws RecognitionException {
        SilkSchemaParser.classDefinition_return retval = new SilkSchemaParser.classDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Class8=null;
        Token QName9=null;
        Token End12=null;
        Token Relation13=null;
        Token QName14=null;
        Token End17=null;
        SilkSchemaParser.inheritance_return inheritance10 = null;

        SilkSchemaParser.classBody_return classBody11 = null;

        SilkSchemaParser.inheritance_return inheritance15 = null;

        SilkSchemaParser.classBody_return classBody16 = null;


        Object Class8_tree=null;
        Object QName9_tree=null;
        Object End12_tree=null;
        Object Relation13_tree=null;
        Object QName14_tree=null;
        Object End17_tree=null;
        RewriteRuleTokenStream stream_Relation=new RewriteRuleTokenStream(adaptor,"token Relation");
        RewriteRuleTokenStream stream_Class=new RewriteRuleTokenStream(adaptor,"token Class");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        RewriteRuleSubtreeStream stream_inheritance=new RewriteRuleSubtreeStream(adaptor,"rule inheritance");
        try {
            // SilkSchema.g:201:3: ( Class QName ( inheritance )? ( classBody )? End -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? ) | Relation QName ( inheritance )? ( classBody )? End -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? ) )
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
                    // SilkSchema.g:201:5: Class QName ( inheritance )? ( classBody )? End
                    {
                    Class8=(Token)match(input,Class,FOLLOW_Class_in_classDefinition926);  
                    stream_Class.add(Class8);

                    QName9=(Token)match(input,QName,FOLLOW_QName_in_classDefinition928);  
                    stream_QName.add(QName9);

                    // SilkSchema.g:201:17: ( inheritance )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==Lt) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // SilkSchema.g:201:17: inheritance
                            {
                            pushFollow(FOLLOW_inheritance_in_classDefinition930);
                            inheritance10=inheritance();

                            state._fsp--;

                            stream_inheritance.add(inheritance10.getTree());

                            }
                            break;

                    }

                    // SilkSchema.g:201:30: ( classBody )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Symbol||LA6_0==Includes||(LA6_0>=Index && LA6_0<=BelongsTo)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // SilkSchema.g:201:30: classBody
                            {
                            pushFollow(FOLLOW_classBody_in_classDefinition933);
                            classBody11=classBody();

                            state._fsp--;

                            stream_classBody.add(classBody11.getTree());

                            }
                            break;

                    }

                    End12=(Token)match(input,End,FOLLOW_End_in_classDefinition936);  
                    stream_End.add(End12);



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
                    // 201:45: -> ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? )
                    {
                        // SilkSchema.g:201:48: ^( ClassDef Name[$QName.text] ( inheritance )? ( classBody )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ClassDef, "ClassDef"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName9!=null?QName9.getText():null)));
                        // SilkSchema.g:201:77: ( inheritance )?
                        if ( stream_inheritance.hasNext() ) {
                            adaptor.addChild(root_1, stream_inheritance.nextTree());

                        }
                        stream_inheritance.reset();
                        // SilkSchema.g:201:90: ( classBody )?
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
                    // SilkSchema.g:202:7: Relation QName ( inheritance )? ( classBody )? End
                    {
                    Relation13=(Token)match(input,Relation,FOLLOW_Relation_in_classDefinition959);  
                    stream_Relation.add(Relation13);

                    QName14=(Token)match(input,QName,FOLLOW_QName_in_classDefinition961);  
                    stream_QName.add(QName14);

                    // SilkSchema.g:202:22: ( inheritance )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==Lt) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // SilkSchema.g:202:22: inheritance
                            {
                            pushFollow(FOLLOW_inheritance_in_classDefinition963);
                            inheritance15=inheritance();

                            state._fsp--;

                            stream_inheritance.add(inheritance15.getTree());

                            }
                            break;

                    }

                    // SilkSchema.g:202:35: ( classBody )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==Symbol||LA8_0==Includes||(LA8_0>=Index && LA8_0<=BelongsTo)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // SilkSchema.g:202:35: classBody
                            {
                            pushFollow(FOLLOW_classBody_in_classDefinition966);
                            classBody16=classBody();

                            state._fsp--;

                            stream_classBody.add(classBody16.getTree());

                            }
                            break;

                    }

                    End17=(Token)match(input,End,FOLLOW_End_in_classDefinition969);  
                    stream_End.add(End17);



                    // AST REWRITE
                    // elements: Relation, inheritance, classBody
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 202:50: -> ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? )
                    {
                        // SilkSchema.g:202:53: ^( Relation Name[$QName.text] ( inheritance )? ( classBody )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_Relation.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName14!=null?QName14.getText():null)));
                        // SilkSchema.g:202:82: ( inheritance )?
                        if ( stream_inheritance.hasNext() ) {
                            adaptor.addChild(root_1, stream_inheritance.nextTree());

                        }
                        stream_inheritance.reset();
                        // SilkSchema.g:202:95: ( classBody )?
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
    // SilkSchema.g:205:1: classBody : ( belongsToStatement | includeStatement | attributes | indexStatement )+ ;
    public final SilkSchemaParser.classBody_return classBody() throws RecognitionException {
        SilkSchemaParser.classBody_return retval = new SilkSchemaParser.classBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.belongsToStatement_return belongsToStatement18 = null;

        SilkSchemaParser.includeStatement_return includeStatement19 = null;

        SilkSchemaParser.attributes_return attributes20 = null;

        SilkSchemaParser.indexStatement_return indexStatement21 = null;



        try {
            // SilkSchema.g:205:10: ( ( belongsToStatement | includeStatement | attributes | indexStatement )+ )
            // SilkSchema.g:205:12: ( belongsToStatement | includeStatement | attributes | indexStatement )+
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:205:12: ( belongsToStatement | includeStatement | attributes | indexStatement )+
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
            	    // SilkSchema.g:205:13: belongsToStatement
            	    {
            	    pushFollow(FOLLOW_belongsToStatement_in_classBody998);
            	    belongsToStatement18=belongsToStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, belongsToStatement18.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:205:34: includeStatement
            	    {
            	    pushFollow(FOLLOW_includeStatement_in_classBody1002);
            	    includeStatement19=includeStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeStatement19.getTree());

            	    }
            	    break;
            	case 3 :
            	    // SilkSchema.g:205:53: attributes
            	    {
            	    pushFollow(FOLLOW_attributes_in_classBody1006);
            	    attributes20=attributes();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributes20.getTree());

            	    }
            	    break;
            	case 4 :
            	    // SilkSchema.g:205:66: indexStatement
            	    {
            	    pushFollow(FOLLOW_indexStatement_in_classBody1010);
            	    indexStatement21=indexStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, indexStatement21.getTree());

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

    public static class belongsToStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "belongsToStatement"
    // SilkSchema.g:207:10: fragment belongsToStatement : BelongsTo QName -> BelongsTo[$QName.text] ;
    public final SilkSchemaParser.belongsToStatement_return belongsToStatement() throws RecognitionException {
        SilkSchemaParser.belongsToStatement_return retval = new SilkSchemaParser.belongsToStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BelongsTo22=null;
        Token QName23=null;

        Object BelongsTo22_tree=null;
        Object QName23_tree=null;
        RewriteRuleTokenStream stream_BelongsTo=new RewriteRuleTokenStream(adaptor,"token BelongsTo");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:207:28: ( BelongsTo QName -> BelongsTo[$QName.text] )
            // SilkSchema.g:207:30: BelongsTo QName
            {
            BelongsTo22=(Token)match(input,BelongsTo,FOLLOW_BelongsTo_in_belongsToStatement1021);  
            stream_BelongsTo.add(BelongsTo22);

            QName23=(Token)match(input,QName,FOLLOW_QName_in_belongsToStatement1023);  
            stream_QName.add(QName23);



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
            // 207:46: -> BelongsTo[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(BelongsTo, (QName23!=null?QName23.getText():null)));

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
    // SilkSchema.g:209:10: fragment inheritance : Lt QName -> Parent[$QName.text] ;
    public final SilkSchemaParser.inheritance_return inheritance() throws RecognitionException {
        SilkSchemaParser.inheritance_return retval = new SilkSchemaParser.inheritance_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Lt24=null;
        Token QName25=null;

        Object Lt24_tree=null;
        Object QName25_tree=null;
        RewriteRuleTokenStream stream_Lt=new RewriteRuleTokenStream(adaptor,"token Lt");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:209:21: ( Lt QName -> Parent[$QName.text] )
            // SilkSchema.g:209:23: Lt QName
            {
            Lt24=(Token)match(input,Lt,FOLLOW_Lt_in_inheritance1040);  
            stream_Lt.add(Lt24);

            QName25=(Token)match(input,QName,FOLLOW_QName_in_inheritance1042);  
            stream_QName.add(QName25);



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
            // 209:32: -> Parent[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Parent, (QName25!=null?QName25.getText():null)));

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
    // SilkSchema.g:211:10: fragment includeStatement : Includes includeItem ( Comma includeItem )* -> ( includeItem )+ ;
    public final SilkSchemaParser.includeStatement_return includeStatement() throws RecognitionException {
        SilkSchemaParser.includeStatement_return retval = new SilkSchemaParser.includeStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Includes26=null;
        Token Comma28=null;
        SilkSchemaParser.includeItem_return includeItem27 = null;

        SilkSchemaParser.includeItem_return includeItem29 = null;


        Object Includes26_tree=null;
        Object Comma28_tree=null;
        RewriteRuleTokenStream stream_Includes=new RewriteRuleTokenStream(adaptor,"token Includes");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_includeItem=new RewriteRuleSubtreeStream(adaptor,"rule includeItem");
        try {
            // SilkSchema.g:211:26: ( Includes includeItem ( Comma includeItem )* -> ( includeItem )+ )
            // SilkSchema.g:211:28: Includes includeItem ( Comma includeItem )*
            {
            Includes26=(Token)match(input,Includes,FOLLOW_Includes_in_includeStatement1058);  
            stream_Includes.add(Includes26);

            pushFollow(FOLLOW_includeItem_in_includeStatement1060);
            includeItem27=includeItem();

            state._fsp--;

            stream_includeItem.add(includeItem27.getTree());
            // SilkSchema.g:211:49: ( Comma includeItem )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Comma) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // SilkSchema.g:211:50: Comma includeItem
            	    {
            	    Comma28=(Token)match(input,Comma,FOLLOW_Comma_in_includeStatement1063);  
            	    stream_Comma.add(Comma28);

            	    pushFollow(FOLLOW_includeItem_in_includeStatement1065);
            	    includeItem29=includeItem();

            	    state._fsp--;

            	    stream_includeItem.add(includeItem29.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // 211:70: -> ( includeItem )+
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
    // SilkSchema.g:213:10: fragment includeItem : QName -> Mixin[$QName.text] ;
    public final SilkSchemaParser.includeItem_return includeItem() throws RecognitionException {
        SilkSchemaParser.includeItem_return retval = new SilkSchemaParser.includeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName30=null;

        Object QName30_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:213:21: ( QName -> Mixin[$QName.text] )
            // SilkSchema.g:213:23: QName
            {
            QName30=(Token)match(input,QName,FOLLOW_QName_in_includeItem1081);  
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
            // 213:29: -> Mixin[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Mixin, (QName30!=null?QName30.getText():null)));

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
    // SilkSchema.g:215:10: fragment indexStatement : Index QName indexTarget ( Comma indexTarget )* -> ^( Index TypeName[$QName.text] ( indexTarget )+ ) ;
    public final SilkSchemaParser.indexStatement_return indexStatement() throws RecognitionException {
        SilkSchemaParser.indexStatement_return retval = new SilkSchemaParser.indexStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Index31=null;
        Token QName32=null;
        Token Comma34=null;
        SilkSchemaParser.indexTarget_return indexTarget33 = null;

        SilkSchemaParser.indexTarget_return indexTarget35 = null;


        Object Index31_tree=null;
        Object QName32_tree=null;
        Object Comma34_tree=null;
        RewriteRuleTokenStream stream_Index=new RewriteRuleTokenStream(adaptor,"token Index");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_indexTarget=new RewriteRuleSubtreeStream(adaptor,"rule indexTarget");
        try {
            // SilkSchema.g:215:24: ( Index QName indexTarget ( Comma indexTarget )* -> ^( Index TypeName[$QName.text] ( indexTarget )+ ) )
            // SilkSchema.g:215:26: Index QName indexTarget ( Comma indexTarget )*
            {
            Index31=(Token)match(input,Index,FOLLOW_Index_in_indexStatement1095);  
            stream_Index.add(Index31);

            QName32=(Token)match(input,QName,FOLLOW_QName_in_indexStatement1097);  
            stream_QName.add(QName32);

            pushFollow(FOLLOW_indexTarget_in_indexStatement1099);
            indexTarget33=indexTarget();

            state._fsp--;

            stream_indexTarget.add(indexTarget33.getTree());
            // SilkSchema.g:215:50: ( Comma indexTarget )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Comma) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // SilkSchema.g:215:51: Comma indexTarget
            	    {
            	    Comma34=(Token)match(input,Comma,FOLLOW_Comma_in_indexStatement1102);  
            	    stream_Comma.add(Comma34);

            	    pushFollow(FOLLOW_indexTarget_in_indexStatement1104);
            	    indexTarget35=indexTarget();

            	    state._fsp--;

            	    stream_indexTarget.add(indexTarget35.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // 216:3: -> ^( Index TypeName[$QName.text] ( indexTarget )+ )
            {
                // SilkSchema.g:216:6: ^( Index TypeName[$QName.text] ( indexTarget )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_Index.nextNode(), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(TypeName, (QName32!=null?QName32.getText():null)));
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
    // SilkSchema.g:219:10: fragment indexTarget : Symbol -> Attribute[$Symbol.text] ;
    public final SilkSchemaParser.indexTarget_return indexTarget() throws RecognitionException {
        SilkSchemaParser.indexTarget_return retval = new SilkSchemaParser.indexTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol36=null;

        Object Symbol36_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            // SilkSchema.g:219:21: ( Symbol -> Attribute[$Symbol.text] )
            // SilkSchema.g:219:23: Symbol
            {
            Symbol36=(Token)match(input,Symbol,FOLLOW_Symbol_in_indexTarget1131);  
            stream_Symbol.add(Symbol36);



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
            // 219:30: -> Attribute[$Symbol.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Attribute, (Symbol36!=null?Symbol36.getText():null)));

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
    // SilkSchema.g:223:10: fragment attributes : attribute ( Comma attribute )* -> ( attribute )+ ;
    public final SilkSchemaParser.attributes_return attributes() throws RecognitionException {
        SilkSchemaParser.attributes_return retval = new SilkSchemaParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma38=null;
        SilkSchemaParser.attribute_return attribute37 = null;

        SilkSchemaParser.attribute_return attribute39 = null;


        Object Comma38_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // SilkSchema.g:223:20: ( attribute ( Comma attribute )* -> ( attribute )+ )
            // SilkSchema.g:223:22: attribute ( Comma attribute )*
            {
            pushFollow(FOLLOW_attribute_in_attributes1150);
            attribute37=attribute();

            state._fsp--;

            stream_attribute.add(attribute37.getTree());
            // SilkSchema.g:223:32: ( Comma attribute )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // SilkSchema.g:223:33: Comma attribute
            	    {
            	    Comma38=(Token)match(input,Comma,FOLLOW_Comma_in_attributes1153);  
            	    stream_Comma.add(Comma38);

            	    pushFollow(FOLLOW_attribute_in_attributes1155);
            	    attribute39=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute39.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
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
            // 224:3: -> ( attribute )+
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
    // SilkSchema.g:227:10: fragment attribute : Symbol ( attributeType )? ( Default attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) ;
    public final SilkSchemaParser.attribute_return attribute() throws RecognitionException {
        SilkSchemaParser.attribute_return retval = new SilkSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol40=null;
        Token Default42=null;
        SilkSchemaParser.attributeType_return attributeType41 = null;

        SilkSchemaParser.attributeValue_return attributeValue43 = null;


        Object Symbol40_tree=null;
        Object Default42_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_Default=new RewriteRuleTokenStream(adaptor,"token Default");
        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_attributeType=new RewriteRuleSubtreeStream(adaptor,"rule attributeType");
        try {
            // SilkSchema.g:227:19: ( Symbol ( attributeType )? ( Default attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) )
            // SilkSchema.g:228:3: Symbol ( attributeType )? ( Default attributeValue )?
            {
            Symbol40=(Token)match(input,Symbol,FOLLOW_Symbol_in_attribute1181);  
            stream_Symbol.add(Symbol40);

            // SilkSchema.g:228:10: ( attributeType )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==QName) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // SilkSchema.g:228:10: attributeType
                    {
                    pushFollow(FOLLOW_attributeType_in_attribute1183);
                    attributeType41=attributeType();

                    state._fsp--;

                    stream_attributeType.add(attributeType41.getTree());

                    }
                    break;

            }

            // SilkSchema.g:228:25: ( Default attributeValue )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Default) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // SilkSchema.g:228:26: Default attributeValue
                    {
                    Default42=(Token)match(input,Default,FOLLOW_Default_in_attribute1187);  
                    stream_Default.add(Default42);

                    pushFollow(FOLLOW_attributeValue_in_attribute1189);
                    attributeValue43=attributeValue();

                    state._fsp--;

                    stream_attributeValue.add(attributeValue43.getTree());

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
            // 229:3: -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
            {
                // SilkSchema.g:229:6: ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Attribute, "Attribute"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (Symbol40!=null?Symbol40.getText():null)));
                // SilkSchema.g:229:37: ( attributeType )?
                if ( stream_attributeType.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeType.nextTree());

                }
                stream_attributeType.reset();
                // SilkSchema.g:229:52: ( attributeValue )?
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
    // SilkSchema.g:232:1: attributeValue : ( String | Double | Integer ) -> DefaultValue[$attributeValue.text] ;
    public final SilkSchemaParser.attributeValue_return attributeValue() throws RecognitionException {
        SilkSchemaParser.attributeValue_return retval = new SilkSchemaParser.attributeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String44=null;
        Token Double45=null;
        Token Integer46=null;

        Object String44_tree=null;
        Object Double45_tree=null;
        Object Integer46_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");

        try {
            // SilkSchema.g:233:3: ( ( String | Double | Integer ) -> DefaultValue[$attributeValue.text] )
            // SilkSchema.g:233:5: ( String | Double | Integer )
            {
            // SilkSchema.g:233:5: ( String | Double | Integer )
            int alt16=3;
            switch ( input.LA(1) ) {
            case String:
                {
                alt16=1;
                }
                break;
            case Double:
                {
                alt16=2;
                }
                break;
            case Integer:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // SilkSchema.g:233:6: String
                    {
                    String44=(Token)match(input,String,FOLLOW_String_in_attributeValue1227);  
                    stream_String.add(String44);


                    }
                    break;
                case 2 :
                    // SilkSchema.g:233:15: Double
                    {
                    Double45=(Token)match(input,Double,FOLLOW_Double_in_attributeValue1231);  
                    stream_Double.add(Double45);


                    }
                    break;
                case 3 :
                    // SilkSchema.g:233:24: Integer
                    {
                    Integer46=(Token)match(input,Integer,FOLLOW_Integer_in_attributeValue1235);  
                    stream_Integer.add(Integer46);


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
            // 233:33: -> DefaultValue[$attributeValue.text]
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
    // SilkSchema.g:235:10: fragment attributeType : ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] );
    public final SilkSchemaParser.attributeType_return attributeType() throws RecognitionException {
        SilkSchemaParser.attributeType_return retval = new SilkSchemaParser.attributeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName47=null;
        Token QName48=null;
        Token Star49=null;

        Object QName47_tree=null;
        Object QName48_tree=null;
        Object Star49_tree=null;
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:236:3: ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QName) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==Star) ) {
                    alt17=2;
                }
                else if ( (LA17_1==Comma||LA17_1==Symbol||(LA17_1>=Includes && LA17_1<=End)||(LA17_1>=Index && LA17_1<=Default)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // SilkSchema.g:236:5: QName
                    {
                    QName47=(Token)match(input,QName,FOLLOW_QName_in_attributeType1256);  
                    stream_QName.add(QName47);



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
                    // 236:11: -> TypeName[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName47!=null?QName47.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:237:5: QName Star
                    {
                    QName48=(Token)match(input,QName,FOLLOW_QName_in_attributeType1268);  
                    stream_QName.add(QName48);

                    Star49=(Token)match(input,Star,FOLLOW_Star_in_attributeType1270);  
                    stream_Star.add(Star49);



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
                    // 237:16: -> TypeName[$QName.text] IsArray[\"true\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName48!=null?QName48.getText():null)));
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


 

    public static final BitSet FOLLOW_Preamble_in_schema841 = new BitSet(new long[]{0x0080900000000002L});
    public static final BitSet FOLLOW_schemaElement_in_schema844 = new BitSet(new long[]{0x0080900000000002L});
    public static final BitSet FOLLOW_classDefinition_in_schemaElement872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_schemaElement879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ModuleDef_in_moduleDefinition891 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_classDefinition_in_moduleDefinition893 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_End_in_moduleDefinition896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition926 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition928 = new BitSet(new long[]{0x0003680400000000L});
    public static final BitSet FOLLOW_inheritance_in_classDefinition930 = new BitSet(new long[]{0x0003680000000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition933 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relation_in_classDefinition959 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition961 = new BitSet(new long[]{0x0003680400000000L});
    public static final BitSet FOLLOW_inheritance_in_classDefinition963 = new BitSet(new long[]{0x0003680000000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition966 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_belongsToStatement_in_classBody998 = new BitSet(new long[]{0x0003280000000002L});
    public static final BitSet FOLLOW_includeStatement_in_classBody1002 = new BitSet(new long[]{0x0003280000000002L});
    public static final BitSet FOLLOW_attributes_in_classBody1006 = new BitSet(new long[]{0x0003280000000002L});
    public static final BitSet FOLLOW_indexStatement_in_classBody1010 = new BitSet(new long[]{0x0003280000000002L});
    public static final BitSet FOLLOW_BelongsTo_in_belongsToStatement1021 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_belongsToStatement1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lt_in_inheritance1040 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_inheritance1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Includes_in_includeStatement1058 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1060 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Comma_in_includeStatement1063 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1065 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_QName_in_includeItem1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Index_in_indexStatement1095 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_indexStatement1097 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1099 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Comma_in_indexStatement1102 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1104 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Symbol_in_indexTarget1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes1150 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Comma_in_attributes1153 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_attribute_in_attributes1155 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Symbol_in_attribute1181 = new BitSet(new long[]{0x0404000000000002L});
    public static final BitSet FOLLOW_attributeType_in_attribute1183 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Default_in_attribute1187 = new BitSet(new long[]{0x0000000026000000L});
    public static final BitSet FOLLOW_attributeValue_in_attribute1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_attributeValue1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_attributeValue1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_attributeValue1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1268 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_Star_in_attributeType1270 = new BitSet(new long[]{0x0000000000000002L});

}
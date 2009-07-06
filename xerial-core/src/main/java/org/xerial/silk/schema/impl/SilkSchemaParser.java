// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-03 16:06:13

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Schema", "Module", "ClassDef", "Name", "Parent", "Mixin", "Attribute", "IsArray", "TypeName", "Value", "LineBreakChar", "Preamble", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Eq", "Dot", "Comma", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "NonWhiteSpaceChar", "Symbol", "Class", "Includes", "End", "Relation", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "WhiteSpace", "QNameChar", "QName"
    };
    public static final int Includes=45;
    public static final int RBrace=31;
    public static final int NonWhiteSpaceChar=42;
    public static final int Class=44;
    public static final int LBracket=32;
    public static final int Digit=18;
    public static final int Frac=27;
    public static final int HexDigit=20;
    public static final int Symbol=43;
    public static final int Module=5;
    public static final int Letter=19;
    public static final int Attribute=10;
    public static final int Comma=37;
    public static final int Schema=4;
    public static final int Dot=36;
    public static final int End=46;
    public static final int EscapeSequence=22;
    public static final int Integer=26;
    public static final int Relation=47;
    public static final int Mixin=9;
    public static final int WhiteSpace=53;
    public static final int ClassDef=6;
    public static final int LineComment=16;
    public static final int ModuleName=50;
    public static final int SafeFirstLetter=48;
    public static final int Star=40;
    public static final int Eq=35;
    public static final int Preamble=15;
    public static final int Exp=28;
    public static final int QNameChar=54;
    public static final int RParen=39;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=17;
    public static final int Name=7;
    public static final int ModuleDef=52;
    public static final int LParen=38;
    public static final int String=25;
    public static final int SafeLetter=49;
    public static final int LineBreakChar=14;
    public static final int IsArray=11;
    public static final int QName=55;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int Value=13;
    public static final int UnsafeUnicodeChar=41;
    public static final int Double=29;
    public static final int LBrace=30;
    public static final int RBracket=33;
    public static final int Lt=34;
    public static final int Parent=8;
    public static final int TypeName=12;
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
    // SilkSchema.g:184:1: schema : ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) ;
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
            // SilkSchema.g:184:7: ( ( Preamble )? ( schemaElement )* -> ^( Schema ( Preamble )? ( schemaElement )* ) )
            // SilkSchema.g:184:10: ( Preamble )? ( schemaElement )*
            {
            // SilkSchema.g:184:10: ( Preamble )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Preamble) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // SilkSchema.g:184:10: Preamble
                    {
                    Preamble1=(Token)match(input,Preamble,FOLLOW_Preamble_in_schema818);  
                    stream_Preamble.add(Preamble1);


                    }
                    break;

            }

            // SilkSchema.g:184:20: ( schemaElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Class||LA2_0==Relation||LA2_0==ModuleDef) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SilkSchema.g:184:20: schemaElement
            	    {
            	    pushFollow(FOLLOW_schemaElement_in_schema821);
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
            // 184:36: -> ^( Schema ( Preamble )? ( schemaElement )* )
            {
                // SilkSchema.g:184:39: ^( Schema ( Preamble )? ( schemaElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Schema, "Schema"), root_1);

                // SilkSchema.g:184:48: ( Preamble )?
                if ( stream_Preamble.hasNext() ) {
                    adaptor.addChild(root_1, stream_Preamble.nextNode());

                }
                stream_Preamble.reset();
                // SilkSchema.g:184:58: ( schemaElement )*
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
    // SilkSchema.g:187:1: schemaElement : ( classDefinition | moduleDefinition );
    public final SilkSchemaParser.schemaElement_return schemaElement() throws RecognitionException {
        SilkSchemaParser.schemaElement_return retval = new SilkSchemaParser.schemaElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.classDefinition_return classDefinition3 = null;

        SilkSchemaParser.moduleDefinition_return moduleDefinition4 = null;



        try {
            // SilkSchema.g:188:3: ( classDefinition | moduleDefinition )
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
                    // SilkSchema.g:188:5: classDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classDefinition_in_schemaElement849);
                    classDefinition3=classDefinition();

                    state._fsp--;

                    adaptor.addChild(root_0, classDefinition3.getTree());

                    }
                    break;
                case 2 :
                    // SilkSchema.g:189:5: moduleDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleDefinition_in_schemaElement856);
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
    // SilkSchema.g:193:1: moduleDefinition : ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) ;
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
            // SilkSchema.g:193:17: ( ModuleDef ( classDefinition )* End -> ^( Module Name[$ModuleDef.text] ( classDefinition )* ) )
            // SilkSchema.g:194:2: ModuleDef ( classDefinition )* End
            {
            ModuleDef5=(Token)match(input,ModuleDef,FOLLOW_ModuleDef_in_moduleDefinition868);  
            stream_ModuleDef.add(ModuleDef5);

            // SilkSchema.g:194:12: ( classDefinition )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Class||LA4_0==Relation) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SilkSchema.g:194:12: classDefinition
            	    {
            	    pushFollow(FOLLOW_classDefinition_in_moduleDefinition870);
            	    classDefinition6=classDefinition();

            	    state._fsp--;

            	    stream_classDefinition.add(classDefinition6.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            End7=(Token)match(input,End,FOLLOW_End_in_moduleDefinition873);  
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
            // 195:2: -> ^( Module Name[$ModuleDef.text] ( classDefinition )* )
            {
                // SilkSchema.g:195:5: ^( Module Name[$ModuleDef.text] ( classDefinition )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (ModuleDef5!=null?ModuleDef5.getText():null)));
                // SilkSchema.g:195:36: ( classDefinition )*
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
    // SilkSchema.g:198:1: classDefinition : ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) );
    public final SilkSchemaParser.classDefinition_return classDefinition() throws RecognitionException {
        SilkSchemaParser.classDefinition_return retval = new SilkSchemaParser.classDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Class8=null;
        Token QName9=null;
        Token End11=null;
        Token Relation12=null;
        Token QName13=null;
        Token End15=null;
        SilkSchemaParser.classBody_return classBody10 = null;

        SilkSchemaParser.classBody_return classBody14 = null;


        Object Class8_tree=null;
        Object QName9_tree=null;
        Object End11_tree=null;
        Object Relation12_tree=null;
        Object QName13_tree=null;
        Object End15_tree=null;
        RewriteRuleTokenStream stream_Relation=new RewriteRuleTokenStream(adaptor,"token Relation");
        RewriteRuleTokenStream stream_Class=new RewriteRuleTokenStream(adaptor,"token Class");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        try {
            // SilkSchema.g:199:3: ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Class) ) {
                alt5=1;
            }
            else if ( (LA5_0==Relation) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // SilkSchema.g:199:5: Class QName classBody End
                    {
                    Class8=(Token)match(input,Class,FOLLOW_Class_in_classDefinition903);  
                    stream_Class.add(Class8);

                    QName9=(Token)match(input,QName,FOLLOW_QName_in_classDefinition905);  
                    stream_QName.add(QName9);

                    pushFollow(FOLLOW_classBody_in_classDefinition907);
                    classBody10=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody10.getTree());
                    End11=(Token)match(input,End,FOLLOW_End_in_classDefinition909);  
                    stream_End.add(End11);



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
                    // 199:31: -> ^( ClassDef Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:199:34: ^( ClassDef Name[$QName.text] classBody )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ClassDef, "ClassDef"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName9!=null?QName9.getText():null)));
                        adaptor.addChild(root_1, stream_classBody.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:200:5: Relation QName classBody End
                    {
                    Relation12=(Token)match(input,Relation,FOLLOW_Relation_in_classDefinition926);  
                    stream_Relation.add(Relation12);

                    QName13=(Token)match(input,QName,FOLLOW_QName_in_classDefinition928);  
                    stream_QName.add(QName13);

                    pushFollow(FOLLOW_classBody_in_classDefinition930);
                    classBody14=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody14.getTree());
                    End15=(Token)match(input,End,FOLLOW_End_in_classDefinition932);  
                    stream_End.add(End15);



                    // AST REWRITE
                    // elements: Relation, classBody
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 200:34: -> ^( Relation Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:200:37: ^( Relation Name[$QName.text] classBody )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_Relation.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName13!=null?QName13.getText():null)));
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
    // SilkSchema.g:203:1: classBody : ( inheritance )? ( includeStatement | attributes )* ;
    public final SilkSchemaParser.classBody_return classBody() throws RecognitionException {
        SilkSchemaParser.classBody_return retval = new SilkSchemaParser.classBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.inheritance_return inheritance16 = null;

        SilkSchemaParser.includeStatement_return includeStatement17 = null;

        SilkSchemaParser.attributes_return attributes18 = null;



        try {
            // SilkSchema.g:203:10: ( ( inheritance )? ( includeStatement | attributes )* )
            // SilkSchema.g:203:12: ( inheritance )? ( includeStatement | attributes )*
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:203:12: ( inheritance )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Lt) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // SilkSchema.g:203:12: inheritance
                    {
                    pushFollow(FOLLOW_inheritance_in_classBody956);
                    inheritance16=inheritance();

                    state._fsp--;

                    adaptor.addChild(root_0, inheritance16.getTree());

                    }
                    break;

            }

            // SilkSchema.g:203:25: ( includeStatement | attributes )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Includes) ) {
                    alt7=1;
                }
                else if ( (LA7_0==Symbol||LA7_0==QName) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // SilkSchema.g:203:26: includeStatement
            	    {
            	    pushFollow(FOLLOW_includeStatement_in_classBody960);
            	    includeStatement17=includeStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeStatement17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:203:45: attributes
            	    {
            	    pushFollow(FOLLOW_attributes_in_classBody964);
            	    attributes18=attributes();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributes18.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // SilkSchema.g:205:10: fragment inheritance : Lt QName -> Parent[$QName.text] ;
    public final SilkSchemaParser.inheritance_return inheritance() throws RecognitionException {
        SilkSchemaParser.inheritance_return retval = new SilkSchemaParser.inheritance_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Lt19=null;
        Token QName20=null;

        Object Lt19_tree=null;
        Object QName20_tree=null;
        RewriteRuleTokenStream stream_Lt=new RewriteRuleTokenStream(adaptor,"token Lt");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:205:21: ( Lt QName -> Parent[$QName.text] )
            // SilkSchema.g:205:23: Lt QName
            {
            Lt19=(Token)match(input,Lt,FOLLOW_Lt_in_inheritance977);  
            stream_Lt.add(Lt19);

            QName20=(Token)match(input,QName,FOLLOW_QName_in_inheritance979);  
            stream_QName.add(QName20);



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
            // 205:32: -> Parent[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Parent, (QName20!=null?QName20.getText():null)));

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
    // SilkSchema.g:207:10: fragment includeStatement : Includes includeItem ( Comma includeItem )* -> ( includeItem )+ ;
    public final SilkSchemaParser.includeStatement_return includeStatement() throws RecognitionException {
        SilkSchemaParser.includeStatement_return retval = new SilkSchemaParser.includeStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Includes21=null;
        Token Comma23=null;
        SilkSchemaParser.includeItem_return includeItem22 = null;

        SilkSchemaParser.includeItem_return includeItem24 = null;


        Object Includes21_tree=null;
        Object Comma23_tree=null;
        RewriteRuleTokenStream stream_Includes=new RewriteRuleTokenStream(adaptor,"token Includes");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_includeItem=new RewriteRuleSubtreeStream(adaptor,"rule includeItem");
        try {
            // SilkSchema.g:207:26: ( Includes includeItem ( Comma includeItem )* -> ( includeItem )+ )
            // SilkSchema.g:207:28: Includes includeItem ( Comma includeItem )*
            {
            Includes21=(Token)match(input,Includes,FOLLOW_Includes_in_includeStatement995);  
            stream_Includes.add(Includes21);

            pushFollow(FOLLOW_includeItem_in_includeStatement997);
            includeItem22=includeItem();

            state._fsp--;

            stream_includeItem.add(includeItem22.getTree());
            // SilkSchema.g:207:49: ( Comma includeItem )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Comma) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // SilkSchema.g:207:50: Comma includeItem
            	    {
            	    Comma23=(Token)match(input,Comma,FOLLOW_Comma_in_includeStatement1000);  
            	    stream_Comma.add(Comma23);

            	    pushFollow(FOLLOW_includeItem_in_includeStatement1002);
            	    includeItem24=includeItem();

            	    state._fsp--;

            	    stream_includeItem.add(includeItem24.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // 207:70: -> ( includeItem )+
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
    // SilkSchema.g:209:10: fragment includeItem : QName -> Mixin[$QName.text] ;
    public final SilkSchemaParser.includeItem_return includeItem() throws RecognitionException {
        SilkSchemaParser.includeItem_return retval = new SilkSchemaParser.includeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName25=null;

        Object QName25_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:209:21: ( QName -> Mixin[$QName.text] )
            // SilkSchema.g:209:23: QName
            {
            QName25=(Token)match(input,QName,FOLLOW_QName_in_includeItem1018);  
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
            // 209:29: -> Mixin[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Mixin, (QName25!=null?QName25.getText():null)));

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
    // SilkSchema.g:212:10: fragment attributes : attribute ( Comma attribute )* -> ( attribute )+ ;
    public final SilkSchemaParser.attributes_return attributes() throws RecognitionException {
        SilkSchemaParser.attributes_return retval = new SilkSchemaParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma27=null;
        SilkSchemaParser.attribute_return attribute26 = null;

        SilkSchemaParser.attribute_return attribute28 = null;


        Object Comma27_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // SilkSchema.g:212:20: ( attribute ( Comma attribute )* -> ( attribute )+ )
            // SilkSchema.g:212:22: attribute ( Comma attribute )*
            {
            pushFollow(FOLLOW_attribute_in_attributes1033);
            attribute26=attribute();

            state._fsp--;

            stream_attribute.add(attribute26.getTree());
            // SilkSchema.g:212:32: ( Comma attribute )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // SilkSchema.g:212:33: Comma attribute
            	    {
            	    Comma27=(Token)match(input,Comma,FOLLOW_Comma_in_attributes1036);  
            	    stream_Comma.add(Comma27);

            	    pushFollow(FOLLOW_attribute_in_attributes1038);
            	    attribute28=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute28.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // 213:3: -> ( attribute )+
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
    // SilkSchema.g:216:10: fragment attribute : ( attributeType )? Symbol ( Eq attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) ;
    public final SilkSchemaParser.attribute_return attribute() throws RecognitionException {
        SilkSchemaParser.attribute_return retval = new SilkSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol30=null;
        Token Eq31=null;
        SilkSchemaParser.attributeType_return attributeType29 = null;

        SilkSchemaParser.attributeValue_return attributeValue32 = null;


        Object Symbol30_tree=null;
        Object Eq31_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_Eq=new RewriteRuleTokenStream(adaptor,"token Eq");
        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_attributeType=new RewriteRuleSubtreeStream(adaptor,"rule attributeType");
        try {
            // SilkSchema.g:216:19: ( ( attributeType )? Symbol ( Eq attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) )
            // SilkSchema.g:217:3: ( attributeType )? Symbol ( Eq attributeValue )?
            {
            // SilkSchema.g:217:3: ( attributeType )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==QName) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // SilkSchema.g:217:3: attributeType
                    {
                    pushFollow(FOLLOW_attributeType_in_attribute1064);
                    attributeType29=attributeType();

                    state._fsp--;

                    stream_attributeType.add(attributeType29.getTree());

                    }
                    break;

            }

            Symbol30=(Token)match(input,Symbol,FOLLOW_Symbol_in_attribute1067);  
            stream_Symbol.add(Symbol30);

            // SilkSchema.g:217:25: ( Eq attributeValue )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Eq) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // SilkSchema.g:217:26: Eq attributeValue
                    {
                    Eq31=(Token)match(input,Eq,FOLLOW_Eq_in_attribute1070);  
                    stream_Eq.add(Eq31);

                    pushFollow(FOLLOW_attributeValue_in_attribute1072);
                    attributeValue32=attributeValue();

                    state._fsp--;

                    stream_attributeValue.add(attributeValue32.getTree());

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
            // 218:3: -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
            {
                // SilkSchema.g:218:6: ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Attribute, "Attribute"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (Symbol30!=null?Symbol30.getText():null)));
                // SilkSchema.g:218:37: ( attributeType )?
                if ( stream_attributeType.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeType.nextTree());

                }
                stream_attributeType.reset();
                // SilkSchema.g:218:52: ( attributeValue )?
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
    // SilkSchema.g:221:1: attributeValue : ( String | Double | Integer ) -> Value[$attributeValue.text] ;
    public final SilkSchemaParser.attributeValue_return attributeValue() throws RecognitionException {
        SilkSchemaParser.attributeValue_return retval = new SilkSchemaParser.attributeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String33=null;
        Token Double34=null;
        Token Integer35=null;

        Object String33_tree=null;
        Object Double34_tree=null;
        Object Integer35_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");

        try {
            // SilkSchema.g:222:3: ( ( String | Double | Integer ) -> Value[$attributeValue.text] )
            // SilkSchema.g:222:5: ( String | Double | Integer )
            {
            // SilkSchema.g:222:5: ( String | Double | Integer )
            int alt12=3;
            switch ( input.LA(1) ) {
            case String:
                {
                alt12=1;
                }
                break;
            case Double:
                {
                alt12=2;
                }
                break;
            case Integer:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // SilkSchema.g:222:6: String
                    {
                    String33=(Token)match(input,String,FOLLOW_String_in_attributeValue1110);  
                    stream_String.add(String33);


                    }
                    break;
                case 2 :
                    // SilkSchema.g:222:15: Double
                    {
                    Double34=(Token)match(input,Double,FOLLOW_Double_in_attributeValue1114);  
                    stream_Double.add(Double34);


                    }
                    break;
                case 3 :
                    // SilkSchema.g:222:24: Integer
                    {
                    Integer35=(Token)match(input,Integer,FOLLOW_Integer_in_attributeValue1118);  
                    stream_Integer.add(Integer35);


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
            // 222:33: -> Value[$attributeValue.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

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
    // SilkSchema.g:224:10: fragment attributeType : ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] );
    public final SilkSchemaParser.attributeType_return attributeType() throws RecognitionException {
        SilkSchemaParser.attributeType_return retval = new SilkSchemaParser.attributeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName36=null;
        Token QName37=null;
        Token Star38=null;

        Object QName36_tree=null;
        Object QName37_tree=null;
        Object Star38_tree=null;
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:225:3: ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==QName) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==Star) ) {
                    alt13=2;
                }
                else if ( (LA13_1==Symbol) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // SilkSchema.g:225:5: QName
                    {
                    QName36=(Token)match(input,QName,FOLLOW_QName_in_attributeType1139);  
                    stream_QName.add(QName36);



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
                    // 225:11: -> TypeName[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName36!=null?QName36.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:226:5: QName Star
                    {
                    QName37=(Token)match(input,QName,FOLLOW_QName_in_attributeType1151);  
                    stream_QName.add(QName37);

                    Star38=(Token)match(input,Star,FOLLOW_Star_in_attributeType1153);  
                    stream_Star.add(Star38);



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
                    // 226:16: -> TypeName[$QName.text] IsArray[\"true\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName37!=null?QName37.getText():null)));
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


 

    public static final BitSet FOLLOW_Preamble_in_schema818 = new BitSet(new long[]{0x0010900000000002L});
    public static final BitSet FOLLOW_schemaElement_in_schema821 = new BitSet(new long[]{0x0010900000000002L});
    public static final BitSet FOLLOW_classDefinition_in_schemaElement849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_schemaElement856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ModuleDef_in_moduleDefinition868 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_classDefinition_in_moduleDefinition870 = new BitSet(new long[]{0x0000D00000000000L});
    public static final BitSet FOLLOW_End_in_moduleDefinition873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition903 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition905 = new BitSet(new long[]{0x0080680400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition907 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relation_in_classDefinition926 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition928 = new BitSet(new long[]{0x0080680400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition930 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inheritance_in_classBody956 = new BitSet(new long[]{0x0080280000000002L});
    public static final BitSet FOLLOW_includeStatement_in_classBody960 = new BitSet(new long[]{0x0080280000000002L});
    public static final BitSet FOLLOW_attributes_in_classBody964 = new BitSet(new long[]{0x0080280000000002L});
    public static final BitSet FOLLOW_Lt_in_inheritance977 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_QName_in_inheritance979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Includes_in_includeStatement995 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement997 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_includeStatement1000 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1002 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_QName_in_includeItem1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes1033 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_attributes1036 = new BitSet(new long[]{0x0080280000000000L});
    public static final BitSet FOLLOW_attribute_in_attributes1038 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeType_in_attribute1064 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Symbol_in_attribute1067 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Eq_in_attribute1070 = new BitSet(new long[]{0x0000000026000000L});
    public static final BitSet FOLLOW_attributeValue_in_attribute1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_attributeValue1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_attributeValue1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_attributeValue1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1151 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Star_in_attributeType1153 = new BitSet(new long[]{0x0000000000000002L});

}
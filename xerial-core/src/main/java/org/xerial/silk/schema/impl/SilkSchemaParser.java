// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkSchema.g 2009-07-07 12:10:45

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Schema", "Module", "ClassDef", "Name", "Parent", "Mixin", "Attribute", "IsArray", "TypeName", "DefaultValue", "LineBreakChar", "Preamble", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Eq", "Dot", "Comma", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "NonWhiteSpaceChar", "SymbolChars", "Symbol", "Class", "Includes", "End", "Relation", "Index", "BelongsTo", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "WhiteSpace", "QNameChar", "QName"
    };
    public static final int Includes=46;
    public static final int RBrace=31;
    public static final int NonWhiteSpaceChar=42;
    public static final int Class=45;
    public static final int LBracket=32;
    public static final int Digit=18;
    public static final int SymbolChars=43;
    public static final int Frac=27;
    public static final int HexDigit=20;
    public static final int Symbol=44;
    public static final int Index=49;
    public static final int Module=5;
    public static final int Letter=19;
    public static final int Attribute=10;
    public static final int Comma=37;
    public static final int Schema=4;
    public static final int Dot=36;
    public static final int End=47;
    public static final int EscapeSequence=22;
    public static final int DefaultValue=13;
    public static final int Integer=26;
    public static final int Relation=48;
    public static final int Mixin=9;
    public static final int WhiteSpace=56;
    public static final int ClassDef=6;
    public static final int LineComment=16;
    public static final int ModuleName=53;
    public static final int BelongsTo=50;
    public static final int SafeFirstLetter=51;
    public static final int Star=40;
    public static final int Eq=35;
    public static final int Preamble=15;
    public static final int Exp=28;
    public static final int QNameChar=57;
    public static final int RParen=39;
    public static final int UnicodeChar=21;
    public static final int StringChar=23;
    public static final int LineBreak=17;
    public static final int Name=7;
    public static final int ModuleDef=55;
    public static final int LParen=38;
    public static final int String=25;
    public static final int SafeLetter=52;
    public static final int LineBreakChar=14;
    public static final int IsArray=11;
    public static final int QName=58;
    public static final int EOF=-1;
    public static final int StringChar_s=24;
    public static final int UnsafeUnicodeChar=41;
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
            // elements: schemaElement, Preamble
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
    // SilkSchema.g:200:1: classDefinition : ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) );
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
            // SilkSchema.g:201:3: ( Class QName classBody End -> ^( ClassDef Name[$QName.text] classBody ) | Relation QName classBody End -> ^( Relation Name[$QName.text] classBody ) )
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
                    // SilkSchema.g:201:5: Class QName classBody End
                    {
                    Class8=(Token)match(input,Class,FOLLOW_Class_in_classDefinition926);  
                    stream_Class.add(Class8);

                    QName9=(Token)match(input,QName,FOLLOW_QName_in_classDefinition928);  
                    stream_QName.add(QName9);

                    pushFollow(FOLLOW_classBody_in_classDefinition930);
                    classBody10=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody10.getTree());
                    End11=(Token)match(input,End,FOLLOW_End_in_classDefinition932);  
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
                    // 201:31: -> ^( ClassDef Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:201:34: ^( ClassDef Name[$QName.text] classBody )
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
                    // SilkSchema.g:202:5: Relation QName classBody End
                    {
                    Relation12=(Token)match(input,Relation,FOLLOW_Relation_in_classDefinition949);  
                    stream_Relation.add(Relation12);

                    QName13=(Token)match(input,QName,FOLLOW_QName_in_classDefinition951);  
                    stream_QName.add(QName13);

                    pushFollow(FOLLOW_classBody_in_classDefinition953);
                    classBody14=classBody();

                    state._fsp--;

                    stream_classBody.add(classBody14.getTree());
                    End15=(Token)match(input,End,FOLLOW_End_in_classDefinition955);  
                    stream_End.add(End15);



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
                    // 202:34: -> ^( Relation Name[$QName.text] classBody )
                    {
                        // SilkSchema.g:202:37: ^( Relation Name[$QName.text] classBody )
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
    // SilkSchema.g:205:1: classBody : ( inheritance )? ( belongsToStatement | includeStatement | attributes | indexStatement )* ;
    public final SilkSchemaParser.classBody_return classBody() throws RecognitionException {
        SilkSchemaParser.classBody_return retval = new SilkSchemaParser.classBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkSchemaParser.inheritance_return inheritance16 = null;

        SilkSchemaParser.belongsToStatement_return belongsToStatement17 = null;

        SilkSchemaParser.includeStatement_return includeStatement18 = null;

        SilkSchemaParser.attributes_return attributes19 = null;

        SilkSchemaParser.indexStatement_return indexStatement20 = null;



        try {
            // SilkSchema.g:205:10: ( ( inheritance )? ( belongsToStatement | includeStatement | attributes | indexStatement )* )
            // SilkSchema.g:205:12: ( inheritance )? ( belongsToStatement | includeStatement | attributes | indexStatement )*
            {
            root_0 = (Object)adaptor.nil();

            // SilkSchema.g:205:12: ( inheritance )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Lt) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // SilkSchema.g:205:12: inheritance
                    {
                    pushFollow(FOLLOW_inheritance_in_classBody979);
                    inheritance16=inheritance();

                    state._fsp--;

                    adaptor.addChild(root_0, inheritance16.getTree());

                    }
                    break;

            }

            // SilkSchema.g:205:25: ( belongsToStatement | includeStatement | attributes | indexStatement )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case BelongsTo:
                    {
                    alt7=1;
                    }
                    break;
                case Includes:
                    {
                    alt7=2;
                    }
                    break;
                case Symbol:
                case QName:
                    {
                    alt7=3;
                    }
                    break;
                case Index:
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // SilkSchema.g:205:26: belongsToStatement
            	    {
            	    pushFollow(FOLLOW_belongsToStatement_in_classBody983);
            	    belongsToStatement17=belongsToStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, belongsToStatement17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // SilkSchema.g:205:47: includeStatement
            	    {
            	    pushFollow(FOLLOW_includeStatement_in_classBody987);
            	    includeStatement18=includeStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, includeStatement18.getTree());

            	    }
            	    break;
            	case 3 :
            	    // SilkSchema.g:205:66: attributes
            	    {
            	    pushFollow(FOLLOW_attributes_in_classBody991);
            	    attributes19=attributes();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributes19.getTree());

            	    }
            	    break;
            	case 4 :
            	    // SilkSchema.g:205:79: indexStatement
            	    {
            	    pushFollow(FOLLOW_indexStatement_in_classBody995);
            	    indexStatement20=indexStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, indexStatement20.getTree());

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

        Token BelongsTo21=null;
        Token QName22=null;

        Object BelongsTo21_tree=null;
        Object QName22_tree=null;
        RewriteRuleTokenStream stream_BelongsTo=new RewriteRuleTokenStream(adaptor,"token BelongsTo");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:207:28: ( BelongsTo QName -> BelongsTo[$QName.text] )
            // SilkSchema.g:207:30: BelongsTo QName
            {
            BelongsTo21=(Token)match(input,BelongsTo,FOLLOW_BelongsTo_in_belongsToStatement1006);  
            stream_BelongsTo.add(BelongsTo21);

            QName22=(Token)match(input,QName,FOLLOW_QName_in_belongsToStatement1008);  
            stream_QName.add(QName22);



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
                adaptor.addChild(root_0, (Object)adaptor.create(BelongsTo, (QName22!=null?QName22.getText():null)));

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

        Token Lt23=null;
        Token QName24=null;

        Object Lt23_tree=null;
        Object QName24_tree=null;
        RewriteRuleTokenStream stream_Lt=new RewriteRuleTokenStream(adaptor,"token Lt");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:209:21: ( Lt QName -> Parent[$QName.text] )
            // SilkSchema.g:209:23: Lt QName
            {
            Lt23=(Token)match(input,Lt,FOLLOW_Lt_in_inheritance1025);  
            stream_Lt.add(Lt23);

            QName24=(Token)match(input,QName,FOLLOW_QName_in_inheritance1027);  
            stream_QName.add(QName24);



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
                adaptor.addChild(root_0, (Object)adaptor.create(Parent, (QName24!=null?QName24.getText():null)));

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

        Token Includes25=null;
        Token Comma27=null;
        SilkSchemaParser.includeItem_return includeItem26 = null;

        SilkSchemaParser.includeItem_return includeItem28 = null;


        Object Includes25_tree=null;
        Object Comma27_tree=null;
        RewriteRuleTokenStream stream_Includes=new RewriteRuleTokenStream(adaptor,"token Includes");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_includeItem=new RewriteRuleSubtreeStream(adaptor,"rule includeItem");
        try {
            // SilkSchema.g:211:26: ( Includes includeItem ( Comma includeItem )* -> ( includeItem )+ )
            // SilkSchema.g:211:28: Includes includeItem ( Comma includeItem )*
            {
            Includes25=(Token)match(input,Includes,FOLLOW_Includes_in_includeStatement1043);  
            stream_Includes.add(Includes25);

            pushFollow(FOLLOW_includeItem_in_includeStatement1045);
            includeItem26=includeItem();

            state._fsp--;

            stream_includeItem.add(includeItem26.getTree());
            // SilkSchema.g:211:49: ( Comma includeItem )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Comma) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // SilkSchema.g:211:50: Comma includeItem
            	    {
            	    Comma27=(Token)match(input,Comma,FOLLOW_Comma_in_includeStatement1048);  
            	    stream_Comma.add(Comma27);

            	    pushFollow(FOLLOW_includeItem_in_includeStatement1050);
            	    includeItem28=includeItem();

            	    state._fsp--;

            	    stream_includeItem.add(includeItem28.getTree());

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

        Token QName29=null;

        Object QName29_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:213:21: ( QName -> Mixin[$QName.text] )
            // SilkSchema.g:213:23: QName
            {
            QName29=(Token)match(input,QName,FOLLOW_QName_in_includeItem1066);  
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
            // 213:29: -> Mixin[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Mixin, (QName29!=null?QName29.getText():null)));

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

        Token Index30=null;
        Token QName31=null;
        Token Comma33=null;
        SilkSchemaParser.indexTarget_return indexTarget32 = null;

        SilkSchemaParser.indexTarget_return indexTarget34 = null;


        Object Index30_tree=null;
        Object QName31_tree=null;
        Object Comma33_tree=null;
        RewriteRuleTokenStream stream_Index=new RewriteRuleTokenStream(adaptor,"token Index");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_indexTarget=new RewriteRuleSubtreeStream(adaptor,"rule indexTarget");
        try {
            // SilkSchema.g:215:24: ( Index QName indexTarget ( Comma indexTarget )* -> ^( Index TypeName[$QName.text] ( indexTarget )+ ) )
            // SilkSchema.g:215:26: Index QName indexTarget ( Comma indexTarget )*
            {
            Index30=(Token)match(input,Index,FOLLOW_Index_in_indexStatement1080);  
            stream_Index.add(Index30);

            QName31=(Token)match(input,QName,FOLLOW_QName_in_indexStatement1082);  
            stream_QName.add(QName31);

            pushFollow(FOLLOW_indexTarget_in_indexStatement1084);
            indexTarget32=indexTarget();

            state._fsp--;

            stream_indexTarget.add(indexTarget32.getTree());
            // SilkSchema.g:215:50: ( Comma indexTarget )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // SilkSchema.g:215:51: Comma indexTarget
            	    {
            	    Comma33=(Token)match(input,Comma,FOLLOW_Comma_in_indexStatement1087);  
            	    stream_Comma.add(Comma33);

            	    pushFollow(FOLLOW_indexTarget_in_indexStatement1089);
            	    indexTarget34=indexTarget();

            	    state._fsp--;

            	    stream_indexTarget.add(indexTarget34.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);



            // AST REWRITE
            // elements: indexTarget, Index
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

                adaptor.addChild(root_1, (Object)adaptor.create(TypeName, (QName31!=null?QName31.getText():null)));
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

        Token Symbol35=null;

        Object Symbol35_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            // SilkSchema.g:219:21: ( Symbol -> Attribute[$Symbol.text] )
            // SilkSchema.g:219:23: Symbol
            {
            Symbol35=(Token)match(input,Symbol,FOLLOW_Symbol_in_indexTarget1116);  
            stream_Symbol.add(Symbol35);



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
                adaptor.addChild(root_0, (Object)adaptor.create(Attribute, (Symbol35!=null?Symbol35.getText():null)));

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

        Token Comma37=null;
        SilkSchemaParser.attribute_return attribute36 = null;

        SilkSchemaParser.attribute_return attribute38 = null;


        Object Comma37_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // SilkSchema.g:223:20: ( attribute ( Comma attribute )* -> ( attribute )+ )
            // SilkSchema.g:223:22: attribute ( Comma attribute )*
            {
            pushFollow(FOLLOW_attribute_in_attributes1135);
            attribute36=attribute();

            state._fsp--;

            stream_attribute.add(attribute36.getTree());
            // SilkSchema.g:223:32: ( Comma attribute )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Comma) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // SilkSchema.g:223:33: Comma attribute
            	    {
            	    Comma37=(Token)match(input,Comma,FOLLOW_Comma_in_attributes1138);  
            	    stream_Comma.add(Comma37);

            	    pushFollow(FOLLOW_attribute_in_attributes1140);
            	    attribute38=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute38.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // SilkSchema.g:227:10: fragment attribute : ( attributeType )? Symbol ( Eq attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) ;
    public final SilkSchemaParser.attribute_return attribute() throws RecognitionException {
        SilkSchemaParser.attribute_return retval = new SilkSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol40=null;
        Token Eq41=null;
        SilkSchemaParser.attributeType_return attributeType39 = null;

        SilkSchemaParser.attributeValue_return attributeValue42 = null;


        Object Symbol40_tree=null;
        Object Eq41_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_Eq=new RewriteRuleTokenStream(adaptor,"token Eq");
        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_attributeType=new RewriteRuleSubtreeStream(adaptor,"rule attributeType");
        try {
            // SilkSchema.g:227:19: ( ( attributeType )? Symbol ( Eq attributeValue )? -> ^( Attribute Name[$Symbol.text] ( attributeType )? ( attributeValue )? ) )
            // SilkSchema.g:228:3: ( attributeType )? Symbol ( Eq attributeValue )?
            {
            // SilkSchema.g:228:3: ( attributeType )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==QName) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // SilkSchema.g:228:3: attributeType
                    {
                    pushFollow(FOLLOW_attributeType_in_attribute1166);
                    attributeType39=attributeType();

                    state._fsp--;

                    stream_attributeType.add(attributeType39.getTree());

                    }
                    break;

            }

            Symbol40=(Token)match(input,Symbol,FOLLOW_Symbol_in_attribute1169);  
            stream_Symbol.add(Symbol40);

            // SilkSchema.g:228:25: ( Eq attributeValue )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Eq) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // SilkSchema.g:228:26: Eq attributeValue
                    {
                    Eq41=(Token)match(input,Eq,FOLLOW_Eq_in_attribute1172);  
                    stream_Eq.add(Eq41);

                    pushFollow(FOLLOW_attributeValue_in_attribute1174);
                    attributeValue42=attributeValue();

                    state._fsp--;

                    stream_attributeValue.add(attributeValue42.getTree());

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

        Token String43=null;
        Token Double44=null;
        Token Integer45=null;

        Object String43_tree=null;
        Object Double44_tree=null;
        Object Integer45_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");

        try {
            // SilkSchema.g:233:3: ( ( String | Double | Integer ) -> DefaultValue[$attributeValue.text] )
            // SilkSchema.g:233:5: ( String | Double | Integer )
            {
            // SilkSchema.g:233:5: ( String | Double | Integer )
            int alt13=3;
            switch ( input.LA(1) ) {
            case String:
                {
                alt13=1;
                }
                break;
            case Double:
                {
                alt13=2;
                }
                break;
            case Integer:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // SilkSchema.g:233:6: String
                    {
                    String43=(Token)match(input,String,FOLLOW_String_in_attributeValue1212);  
                    stream_String.add(String43);


                    }
                    break;
                case 2 :
                    // SilkSchema.g:233:15: Double
                    {
                    Double44=(Token)match(input,Double,FOLLOW_Double_in_attributeValue1216);  
                    stream_Double.add(Double44);


                    }
                    break;
                case 3 :
                    // SilkSchema.g:233:24: Integer
                    {
                    Integer45=(Token)match(input,Integer,FOLLOW_Integer_in_attributeValue1220);  
                    stream_Integer.add(Integer45);


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

        Token QName46=null;
        Token QName47=null;
        Token Star48=null;

        Object QName46_tree=null;
        Object QName47_tree=null;
        Object Star48_tree=null;
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // SilkSchema.g:236:3: ( QName -> TypeName[$QName.text] | QName Star -> TypeName[$QName.text] IsArray[\"true\"] )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==QName) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==Star) ) {
                    alt14=2;
                }
                else if ( (LA14_1==Symbol) ) {
                    alt14=1;
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
                    // SilkSchema.g:236:5: QName
                    {
                    QName46=(Token)match(input,QName,FOLLOW_QName_in_attributeType1241);  
                    stream_QName.add(QName46);



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
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName46!=null?QName46.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkSchema.g:237:5: QName Star
                    {
                    QName47=(Token)match(input,QName,FOLLOW_QName_in_attributeType1253);  
                    stream_QName.add(QName47);

                    Star48=(Token)match(input,Star,FOLLOW_Star_in_attributeType1255);  
                    stream_Star.add(Star48);



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
                        adaptor.addChild(root_0, (Object)adaptor.create(TypeName, (QName47!=null?QName47.getText():null)));
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


 

    public static final BitSet FOLLOW_Preamble_in_schema841 = new BitSet(new long[]{0x0081200000000002L});
    public static final BitSet FOLLOW_schemaElement_in_schema844 = new BitSet(new long[]{0x0081200000000002L});
    public static final BitSet FOLLOW_classDefinition_in_schemaElement872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_schemaElement879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ModuleDef_in_moduleDefinition891 = new BitSet(new long[]{0x0001A00000000000L});
    public static final BitSet FOLLOW_classDefinition_in_moduleDefinition893 = new BitSet(new long[]{0x0001A00000000000L});
    public static final BitSet FOLLOW_End_in_moduleDefinition896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Class_in_classDefinition926 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition928 = new BitSet(new long[]{0x0406D00400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition930 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relation_in_classDefinition949 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_classDefinition951 = new BitSet(new long[]{0x0406D00400000000L});
    public static final BitSet FOLLOW_classBody_in_classDefinition953 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_End_in_classDefinition955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inheritance_in_classBody979 = new BitSet(new long[]{0x0406500000000002L});
    public static final BitSet FOLLOW_belongsToStatement_in_classBody983 = new BitSet(new long[]{0x0406500000000002L});
    public static final BitSet FOLLOW_includeStatement_in_classBody987 = new BitSet(new long[]{0x0406500000000002L});
    public static final BitSet FOLLOW_attributes_in_classBody991 = new BitSet(new long[]{0x0406500000000002L});
    public static final BitSet FOLLOW_indexStatement_in_classBody995 = new BitSet(new long[]{0x0406500000000002L});
    public static final BitSet FOLLOW_BelongsTo_in_belongsToStatement1006 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_belongsToStatement1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lt_in_inheritance1025 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_inheritance1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Includes_in_includeStatement1043 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1045 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_includeStatement1048 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_includeItem_in_includeStatement1050 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_QName_in_includeItem1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Index_in_indexStatement1080 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_indexStatement1082 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1084 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_indexStatement1087 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_indexTarget_in_indexStatement1089 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Symbol_in_indexTarget1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes1135 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_Comma_in_attributes1138 = new BitSet(new long[]{0x0400100000000000L});
    public static final BitSet FOLLOW_attribute_in_attributes1140 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeType_in_attribute1166 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_Symbol_in_attribute1169 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Eq_in_attribute1172 = new BitSet(new long[]{0x0000000026000000L});
    public static final BitSet FOLLOW_attributeValue_in_attribute1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_attributeValue1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_attributeValue1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_attributeValue1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeType1253 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Star_in_attributeType1255 = new BitSet(new long[]{0x0000000000000002L});

}
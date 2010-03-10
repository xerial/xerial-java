// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 RelationSchema.g 2010-03-10 09:52:00

/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// Xerial RAQUEL - Relational-Style Amoeba Query Language
// 
// RelationSchemaParser.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
package org.xerial.lens.relation.schema.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class RelationSchemaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelationSchema", "Relation", "Name", "Node", "Context", "Value", "FD", "Tree", "ML_COMMENT", "NEWLINE", "LINE_COMMENT", "LParen", "RParen", "LBracket", "RBracket", "Comma", "Equal", "Plus", "Star", "Question", "At", "Quot", "Apos", "Colon", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "NameFragment", "RelationDef", "TreeDef", "QName"
    };
    public static final int Equal=20;
    public static final int NameChar=31;
    public static final int RelationDef=35;
    public static final int LBracket=17;
    public static final int Digit=29;
    public static final int Apos=26;
    public static final int Star=22;
    public static final int Plus=21;
    public static final int RelationSchema=4;
    public static final int TreeDef=36;
    public static final int RParen=16;
    public static final int StringLiteral=33;
    public static final int Node=7;
    public static final int LINE_COMMENT=14;
    public static final int Name=6;
    public static final int NEWLINE=13;
    public static final int LParen=15;
    public static final int FD=10;
    public static final int Letter=28;
    public static final int Comma=19;
    public static final int QName=37;
    public static final int WhiteSpaceChar=32;
    public static final int EOF=-1;
    public static final int Context=8;
    public static final int Value=9;
    public static final int RBracket=18;
    public static final int Relation=5;
    public static final int Tree=11;
    public static final int ML_COMMENT=12;
    public static final int NameFragment=34;
    public static final int Quot=25;
    public static final int Question=23;
    public static final int Digits=30;
    public static final int Colon=27;
    public static final int At=24;

    // delegates
    // delegators


        public RelationSchemaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RelationSchemaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return RelationSchemaParser.tokenNames; }
    public String getGrammarFileName() { return "RelationSchema.g"; }


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // RelationSchema.g:156:1: schema : ( schemaItem )* -> ^( RelationSchema ( schemaItem )* ) ;
    public final RelationSchemaParser.schema_return schema() throws RecognitionException {
        RelationSchemaParser.schema_return retval = new RelationSchemaParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RelationSchemaParser.schemaItem_return schemaItem1 = null;


        RewriteRuleSubtreeStream stream_schemaItem=new RewriteRuleSubtreeStream(adaptor,"rule schemaItem");
        try {
            // RelationSchema.g:156:7: ( ( schemaItem )* -> ^( RelationSchema ( schemaItem )* ) )
            // RelationSchema.g:156:9: ( schemaItem )*
            {
            // RelationSchema.g:156:9: ( schemaItem )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RelationDef && LA1_0<=TreeDef)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // RelationSchema.g:156:9: schemaItem
            	    {
            	    pushFollow(FOLLOW_schemaItem_in_schema451);
            	    schemaItem1=schemaItem();

            	    state._fsp--;

            	    stream_schemaItem.add(schemaItem1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: schemaItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 157:2: -> ^( RelationSchema ( schemaItem )* )
            {
                // RelationSchema.g:157:5: ^( RelationSchema ( schemaItem )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RelationSchema, "RelationSchema"), root_1);

                // RelationSchema.g:157:22: ( schemaItem )*
                while ( stream_schemaItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_schemaItem.nextTree());

                }
                stream_schemaItem.reset();

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

    public static class schemaItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schemaItem"
    // RelationSchema.g:160:1: schemaItem : ( relationDef | treeDef );
    public final RelationSchemaParser.schemaItem_return schemaItem() throws RecognitionException {
        RelationSchemaParser.schemaItem_return retval = new RelationSchemaParser.schemaItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RelationSchemaParser.relationDef_return relationDef2 = null;

        RelationSchemaParser.treeDef_return treeDef3 = null;



        try {
            // RelationSchema.g:161:2: ( relationDef | treeDef )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RelationDef) ) {
                alt2=1;
            }
            else if ( (LA2_0==TreeDef) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // RelationSchema.g:161:4: relationDef
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relationDef_in_schemaItem472);
                    relationDef2=relationDef();

                    state._fsp--;

                    adaptor.addChild(root_0, relationDef2.getTree());

                    }
                    break;
                case 2 :
                    // RelationSchema.g:162:4: treeDef
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_treeDef_in_schemaItem477);
                    treeDef3=treeDef();

                    state._fsp--;

                    adaptor.addChild(root_0, treeDef3.getTree());

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
    // $ANTLR end "schemaItem"

    public static class relationDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationDef"
    // RelationSchema.g:165:1: relationDef : RelationDef QName LParen attributeList RParen -> ^( Relation Name[$QName.text] attributeList ) ;
    public final RelationSchemaParser.relationDef_return relationDef() throws RecognitionException {
        RelationSchemaParser.relationDef_return retval = new RelationSchemaParser.relationDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RelationDef4=null;
        Token QName5=null;
        Token LParen6=null;
        Token RParen8=null;
        RelationSchemaParser.attributeList_return attributeList7 = null;


        Object RelationDef4_tree=null;
        Object QName5_tree=null;
        Object LParen6_tree=null;
        Object RParen8_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_RelationDef=new RewriteRuleTokenStream(adaptor,"token RelationDef");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        try {
            // RelationSchema.g:165:12: ( RelationDef QName LParen attributeList RParen -> ^( Relation Name[$QName.text] attributeList ) )
            // RelationSchema.g:165:14: RelationDef QName LParen attributeList RParen
            {
            RelationDef4=(Token)match(input,RelationDef,FOLLOW_RelationDef_in_relationDef486);  
            stream_RelationDef.add(RelationDef4);

            QName5=(Token)match(input,QName,FOLLOW_QName_in_relationDef488);  
            stream_QName.add(QName5);

            LParen6=(Token)match(input,LParen,FOLLOW_LParen_in_relationDef490);  
            stream_LParen.add(LParen6);

            pushFollow(FOLLOW_attributeList_in_relationDef492);
            attributeList7=attributeList();

            state._fsp--;

            stream_attributeList.add(attributeList7.getTree());
            RParen8=(Token)match(input,RParen,FOLLOW_RParen_in_relationDef494);  
            stream_RParen.add(RParen8);



            // AST REWRITE
            // elements: attributeList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 166:2: -> ^( Relation Name[$QName.text] attributeList )
            {
                // RelationSchema.g:166:5: ^( Relation Name[$QName.text] attributeList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Relation, "Relation"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName5!=null?QName5.getText():null)));
                adaptor.addChild(root_1, stream_attributeList.nextTree());

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
    // $ANTLR end "relationDef"

    public static class treeDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "treeDef"
    // RelationSchema.g:169:1: treeDef : TreeDef QName -> ^( Tree Name[$QName.text] ) ;
    public final RelationSchemaParser.treeDef_return treeDef() throws RecognitionException {
        RelationSchemaParser.treeDef_return retval = new RelationSchemaParser.treeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TreeDef9=null;
        Token QName10=null;

        Object TreeDef9_tree=null;
        Object QName10_tree=null;
        RewriteRuleTokenStream stream_TreeDef=new RewriteRuleTokenStream(adaptor,"token TreeDef");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // RelationSchema.g:169:8: ( TreeDef QName -> ^( Tree Name[$QName.text] ) )
            // RelationSchema.g:169:10: TreeDef QName
            {
            TreeDef9=(Token)match(input,TreeDef,FOLLOW_TreeDef_in_treeDef517);  
            stream_TreeDef.add(TreeDef9);

            QName10=(Token)match(input,QName,FOLLOW_QName_in_treeDef519);  
            stream_QName.add(QName10);



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
            // 170:2: -> ^( Tree Name[$QName.text] )
            {
                // RelationSchema.g:170:5: ^( Tree Name[$QName.text] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Tree, "Tree"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName10!=null?QName10.getText():null)));

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
    // $ANTLR end "treeDef"

    public static class attributeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeList"
    // RelationSchema.g:174:1: attributeList : attribute ( Comma attribute )* ;
    public final RelationSchemaParser.attributeList_return attributeList() throws RecognitionException {
        RelationSchemaParser.attributeList_return retval = new RelationSchemaParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma12=null;
        RelationSchemaParser.attribute_return attribute11 = null;

        RelationSchemaParser.attribute_return attribute13 = null;


        Object Comma12_tree=null;

        try {
            // RelationSchema.g:174:14: ( attribute ( Comma attribute )* )
            // RelationSchema.g:174:16: attribute ( Comma attribute )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attribute_in_attributeList541);
            attribute11=attribute();

            state._fsp--;

            adaptor.addChild(root_0, attribute11.getTree());
            // RelationSchema.g:174:26: ( Comma attribute )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comma) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // RelationSchema.g:174:27: Comma attribute
            	    {
            	    Comma12=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList544); 
            	    pushFollow(FOLLOW_attribute_in_attributeList547);
            	    attribute13=attribute();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attribute13.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "attributeList"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // RelationSchema.g:178:1: attribute : QName ( attributePlural )? -> ^( Node Name[$QName.text] ( attributePlural )? ) ;
    public final RelationSchemaParser.attribute_return attribute() throws RecognitionException {
        RelationSchemaParser.attribute_return retval = new RelationSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName14=null;
        RelationSchemaParser.attributePlural_return attributePlural15 = null;


        Object QName14_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_attributePlural=new RewriteRuleSubtreeStream(adaptor,"rule attributePlural");
        try {
            // RelationSchema.g:179:2: ( QName ( attributePlural )? -> ^( Node Name[$QName.text] ( attributePlural )? ) )
            // RelationSchema.g:179:4: QName ( attributePlural )?
            {
            QName14=(Token)match(input,QName,FOLLOW_QName_in_attribute561);  
            stream_QName.add(QName14);

            // RelationSchema.g:179:10: ( attributePlural )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=Plus && LA4_0<=Question)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // RelationSchema.g:179:10: attributePlural
                    {
                    pushFollow(FOLLOW_attributePlural_in_attribute563);
                    attributePlural15=attributePlural();

                    state._fsp--;

                    stream_attributePlural.add(attributePlural15.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributePlural
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 180:2: -> ^( Node Name[$QName.text] ( attributePlural )? )
            {
                // RelationSchema.g:180:5: ^( Node Name[$QName.text] ( attributePlural )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Node, "Node"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName14!=null?QName14.getText():null)));
                // RelationSchema.g:180:30: ( attributePlural )?
                if ( stream_attributePlural.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributePlural.nextTree());

                }
                stream_attributePlural.reset();

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

    public static class attributePlural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributePlural"
    // RelationSchema.g:184:1: attributePlural : ( Star -> FD[\"ZERO_OR_MORE\"] | Plus -> FD[\"ONE_OR_MORE\"] | Question -> FD[\"ZERO_OR_ONE\"] );
    public final RelationSchemaParser.attributePlural_return attributePlural() throws RecognitionException {
        RelationSchemaParser.attributePlural_return retval = new RelationSchemaParser.attributePlural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star16=null;
        Token Plus17=null;
        Token Question18=null;

        Object Star16_tree=null;
        Object Plus17_tree=null;
        Object Question18_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");

        try {
            // RelationSchema.g:185:2: ( Star -> FD[\"ZERO_OR_MORE\"] | Plus -> FD[\"ONE_OR_MORE\"] | Question -> FD[\"ZERO_OR_ONE\"] )
            int alt5=3;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt5=1;
                }
                break;
            case Plus:
                {
                alt5=2;
                }
                break;
            case Question:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // RelationSchema.g:185:4: Star
                    {
                    Star16=(Token)match(input,Star,FOLLOW_Star_in_attributePlural590);  
                    stream_Star.add(Star16);



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
                    // 185:9: -> FD[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // RelationSchema.g:186:4: Plus
                    {
                    Plus17=(Token)match(input,Plus,FOLLOW_Plus_in_attributePlural600);  
                    stream_Plus.add(Plus17);



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
                    // 186:9: -> FD[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // RelationSchema.g:187:4: Question
                    {
                    Question18=(Token)match(input,Question,FOLLOW_Question_in_attributePlural610);  
                    stream_Question.add(Question18);



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
                    // 187:13: -> FD[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ZERO_OR_ONE"));

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
    // $ANTLR end "attributePlural"

    // Delegated rules


 

    public static final BitSet FOLLOW_schemaItem_in_schema451 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_relationDef_in_schemaItem472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_treeDef_in_schemaItem477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RelationDef_in_relationDef486 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_QName_in_relationDef488 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LParen_in_relationDef490 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_attributeList_in_relationDef492 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RParen_in_relationDef494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TreeDef_in_treeDef517 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_QName_in_treeDef519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributeList541 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_Comma_in_attributeList544 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_attribute_in_attributeList547 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_QName_in_attribute561 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_attributePlural_in_attribute563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_attributePlural590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_attributePlural600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_attributePlural610 = new BitSet(new long[]{0x0000000000000002L});

}
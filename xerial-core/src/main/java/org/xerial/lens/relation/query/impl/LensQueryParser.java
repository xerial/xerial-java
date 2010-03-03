// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 LensQuery.g 2010-03-02 22:16:17

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
// LensQueryParser.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
package org.xerial.lens.relation.query.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class LensQueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "RELATION", "COMPARE", "OPERATOR", "OPERAND", "PATTERNMATCH", "NODE", "ALIAS", "NODEVALUE", "NAME", "VALUE", "FD", "LineBreakChar", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "True", "False", "Null", "Lt", "Gt", "Leq", "Geq", "Eq", "Neq", "Match", "Regex", "Dot", "Comma", "Colon", "As", "LParen", "RParen", "UnsafeUnicodeChar", "SafeFirstLetter", "SafeLetter", "WhiteSpace", "QNameChar", "QName", "WhiteSpaces", "'*'", "'?'", "'+'"
    };
    public static final int PATTERNMATCH=9;
    public static final int Match=40;
    public static final int Regex=41;
    public static final int T__57=57;
    public static final int Digit=19;
    public static final int Frac=28;
    public static final int HexDigit=21;
    public static final int QUERY=4;
    public static final int ALIAS=11;
    public static final int VALUE=14;
    public static final int FD=15;
    public static final int Letter=20;
    public static final int Comma=43;
    public static final int Dot=42;
    public static final int EscapeSequence=23;
    public static final int Integer=27;
    public static final int WhiteSpace=51;
    public static final int OPERATOR=7;
    public static final int False=32;
    public static final int Colon=44;
    public static final int LineComment=17;
    public static final int NODEVALUE=12;
    public static final int T__56=56;
    public static final int As=45;
    public static final int SafeFirstLetter=49;
    public static final int Null=33;
    public static final int Eq=38;
    public static final int Exp=29;
    public static final int QNameChar=52;
    public static final int RELATION=5;
    public static final int Gt=35;
    public static final int RParen=47;
    public static final int UnicodeChar=22;
    public static final int StringChar=24;
    public static final int True=31;
    public static final int OPERAND=8;
    public static final int LineBreak=18;
    public static final int T__55=55;
    public static final int LParen=46;
    public static final int String=26;
    public static final int SafeLetter=50;
    public static final int LineBreakChar=16;
    public static final int COMPARE=6;
    public static final int QName=53;
    public static final int EOF=-1;
    public static final int Geq=37;
    public static final int NODE=10;
    public static final int StringChar_s=25;
    public static final int Neq=39;
    public static final int UnsafeUnicodeChar=48;
    public static final int Double=30;
    public static final int Lt=34;
    public static final int NAME=13;
    public static final int Leq=36;
    public static final int WhiteSpaces=54;

    // delegates
    // delegators


        public LensQueryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LensQueryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LensQueryParser.tokenNames; }
    public String getGrammarFileName() { return "LensQuery.g"; }




    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // LensQuery.g:185:1: expr : relation ;
    public final LensQueryParser.expr_return expr() throws RecognitionException {
        LensQueryParser.expr_return retval = new LensQueryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.relation_return relation1 = null;



        try {
            // LensQuery.g:185:5: ( relation )
            // LensQuery.g:186:3: relation
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relation_in_expr781);
            relation1=relation();

            state._fsp--;

            adaptor.addChild(root_0, relation1.getTree());

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
    // $ANTLR end "expr"

    public static class relation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // LensQuery.g:189:1: relation : relation_i -> ^( RELATION relation_i ) ;
    public final LensQueryParser.relation_return relation() throws RecognitionException {
        LensQueryParser.relation_return retval = new LensQueryParser.relation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.relation_i_return relation_i2 = null;


        RewriteRuleSubtreeStream stream_relation_i=new RewriteRuleSubtreeStream(adaptor,"rule relation_i");
        try {
            // LensQuery.g:190:4: ( relation_i -> ^( RELATION relation_i ) )
            // LensQuery.g:190:6: relation_i
            {
            pushFollow(FOLLOW_relation_i_in_relation799);
            relation_i2=relation_i();

            state._fsp--;

            stream_relation_i.add(relation_i2.getTree());


            // AST REWRITE
            // elements: relation_i
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 190:17: -> ^( RELATION relation_i )
            {
                // LensQuery.g:190:20: ^( RELATION relation_i )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RELATION, "RELATION"), root_1);

                adaptor.addChild(root_1, stream_relation_i.nextTree());

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
    // $ANTLR end "relation"

    public static class relation_i_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation_i"
    // LensQuery.g:193:1: relation_i : nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen ;
    public final LensQueryParser.relation_i_return relation_i() throws RecognitionException {
        LensQueryParser.relation_i_return retval = new LensQueryParser.relation_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen5=null;
        Token Comma7=null;
        Token RParen9=null;
        LensQueryParser.nodeName_return nodeName3 = null;

        LensQueryParser.alias_return alias4 = null;

        LensQueryParser.nodeItem_return nodeItem6 = null;

        LensQueryParser.nodeItem_return nodeItem8 = null;


        Object LParen5_tree=null;
        Object Comma7_tree=null;
        Object RParen9_tree=null;

        try {
            // LensQuery.g:193:11: ( nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen )
            // LensQuery.g:193:13: nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nodeName_in_relation_i815);
            nodeName3=nodeName();

            state._fsp--;

            adaptor.addChild(root_0, nodeName3.getTree());
            // LensQuery.g:193:22: ( alias )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==As) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // LensQuery.g:193:22: alias
                    {
                    pushFollow(FOLLOW_alias_in_relation_i817);
                    alias4=alias();

                    state._fsp--;

                    adaptor.addChild(root_0, alias4.getTree());

                    }
                    break;

            }

            LParen5=(Token)match(input,LParen,FOLLOW_LParen_in_relation_i820); 
            pushFollow(FOLLOW_nodeItem_in_relation_i823);
            nodeItem6=nodeItem();

            state._fsp--;

            adaptor.addChild(root_0, nodeItem6.getTree());
            // LensQuery.g:193:46: ( Comma nodeItem )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // LensQuery.g:193:47: Comma nodeItem
            	    {
            	    Comma7=(Token)match(input,Comma,FOLLOW_Comma_in_relation_i826); 
            	    pushFollow(FOLLOW_nodeItem_in_relation_i829);
            	    nodeItem8=nodeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, nodeItem8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RParen9=(Token)match(input,RParen,FOLLOW_RParen_in_relation_i833); 

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
    // $ANTLR end "relation_i"

    public static class nodeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeName"
    // LensQuery.g:196:1: fragment nodeName : ( QName -> NAME[$QName.text] | String -> NAME[$String.text] );
    public final LensQueryParser.nodeName_return nodeName() throws RecognitionException {
        LensQueryParser.nodeName_return retval = new LensQueryParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName10=null;
        Token String11=null;

        Object QName10_tree=null;
        Object String11_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // LensQuery.g:198:3: ( QName -> NAME[$QName.text] | String -> NAME[$String.text] )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QName) ) {
                alt3=1;
            }
            else if ( (LA3_0==String) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // LensQuery.g:198:5: QName
                    {
                    QName10=(Token)match(input,QName,FOLLOW_QName_in_nodeName847);  
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
                    // 198:11: -> NAME[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NAME, (QName10!=null?QName10.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:199:5: String
                    {
                    String11=(Token)match(input,String,FOLLOW_String_in_nodeName858);  
                    stream_String.add(String11);



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
                    // 199:12: -> NAME[$String.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NAME, (String11!=null?String11.getText():null)));

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
    // $ANTLR end "nodeName"

    public static class alias_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alias"
    // LensQuery.g:202:1: fragment alias : As QName -> ALIAS[$QName.text] ;
    public final LensQueryParser.alias_return alias() throws RecognitionException {
        LensQueryParser.alias_return retval = new LensQueryParser.alias_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token As12=null;
        Token QName13=null;

        Object As12_tree=null;
        Object QName13_tree=null;
        RewriteRuleTokenStream stream_As=new RewriteRuleTokenStream(adaptor,"token As");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // LensQuery.g:203:6: ( As QName -> ALIAS[$QName.text] )
            // LensQuery.g:203:8: As QName
            {
            As12=(Token)match(input,As,FOLLOW_As_in_alias875);  
            stream_As.add(As12);

            QName13=(Token)match(input,QName,FOLLOW_QName_in_alias877);  
            stream_QName.add(QName13);



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
            // 203:17: -> ALIAS[$QName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(ALIAS, (QName13!=null?QName13.getText():null)));

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
    // $ANTLR end "alias"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // LensQuery.g:206:1: fragment nodeItem : ( nodeName ( alias )? ( nodeValue )? ( fd )? -> ^( NODE nodeName ( alias )? ( nodeValue )? ( fd )? ) | relation );
    public final LensQueryParser.nodeItem_return nodeItem() throws RecognitionException {
        LensQueryParser.nodeItem_return retval = new LensQueryParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.nodeName_return nodeName14 = null;

        LensQueryParser.alias_return alias15 = null;

        LensQueryParser.nodeValue_return nodeValue16 = null;

        LensQueryParser.fd_return fd17 = null;

        LensQueryParser.relation_return relation18 = null;


        RewriteRuleSubtreeStream stream_fd=new RewriteRuleSubtreeStream(adaptor,"rule fd");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");
        try {
            // LensQuery.g:208:3: ( nodeName ( alias )? ( nodeValue )? ( fd )? -> ^( NODE nodeName ( alias )? ( nodeValue )? ( fd )? ) | relation )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QName) ) {
                switch ( input.LA(2) ) {
                case As:
                    {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==QName) ) {
                        int LA7_6 = input.LA(4);

                        if ( (LA7_6==LParen) ) {
                            alt7=2;
                        }
                        else if ( ((LA7_6>=Lt && LA7_6<=Match)||(LA7_6>=Comma && LA7_6<=Colon)||LA7_6==RParen||(LA7_6>=55 && LA7_6<=57)) ) {
                            alt7=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case Lt:
                case Gt:
                case Leq:
                case Geq:
                case Eq:
                case Neq:
                case Match:
                case Comma:
                case Colon:
                case RParen:
                case 55:
                case 56:
                case 57:
                    {
                    alt7=1;
                    }
                    break;
                case LParen:
                    {
                    alt7=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA7_0==String) ) {
                switch ( input.LA(2) ) {
                case As:
                    {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==QName) ) {
                        int LA7_6 = input.LA(4);

                        if ( (LA7_6==LParen) ) {
                            alt7=2;
                        }
                        else if ( ((LA7_6>=Lt && LA7_6<=Match)||(LA7_6>=Comma && LA7_6<=Colon)||LA7_6==RParen||(LA7_6>=55 && LA7_6<=57)) ) {
                            alt7=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case LParen:
                    {
                    alt7=2;
                    }
                    break;
                case Lt:
                case Gt:
                case Leq:
                case Geq:
                case Eq:
                case Neq:
                case Match:
                case Comma:
                case Colon:
                case RParen:
                case 55:
                case 56:
                case 57:
                    {
                    alt7=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // LensQuery.g:208:5: nodeName ( alias )? ( nodeValue )? ( fd )?
                    {
                    pushFollow(FOLLOW_nodeName_in_nodeItem897);
                    nodeName14=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName14.getTree());
                    // LensQuery.g:208:14: ( alias )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==As) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // LensQuery.g:208:14: alias
                            {
                            pushFollow(FOLLOW_alias_in_nodeItem899);
                            alias15=alias();

                            state._fsp--;

                            stream_alias.add(alias15.getTree());

                            }
                            break;

                    }

                    // LensQuery.g:208:21: ( nodeValue )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Lt && LA5_0<=Match)||LA5_0==Colon) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // LensQuery.g:208:21: nodeValue
                            {
                            pushFollow(FOLLOW_nodeValue_in_nodeItem902);
                            nodeValue16=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue16.getTree());

                            }
                            break;

                    }

                    // LensQuery.g:208:32: ( fd )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=55 && LA6_0<=57)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // LensQuery.g:208:32: fd
                            {
                            pushFollow(FOLLOW_fd_in_nodeItem905);
                            fd17=fd();

                            state._fsp--;

                            stream_fd.add(fd17.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: fd, nodeValue, nodeName, alias
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 209:5: -> ^( NODE nodeName ( alias )? ( nodeValue )? ( fd )? )
                    {
                        // LensQuery.g:209:8: ^( NODE nodeName ( alias )? ( nodeValue )? ( fd )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                        adaptor.addChild(root_1, stream_nodeName.nextTree());
                        // LensQuery.g:209:24: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();
                        // LensQuery.g:209:31: ( nodeValue )?
                        if ( stream_nodeValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_nodeValue.nextTree());

                        }
                        stream_nodeValue.reset();
                        // LensQuery.g:209:42: ( fd )?
                        if ( stream_fd.hasNext() ) {
                            adaptor.addChild(root_1, stream_fd.nextTree());

                        }
                        stream_fd.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:210:5: relation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relation_in_nodeItem933);
                    relation18=relation();

                    state._fsp--;

                    adaptor.addChild(root_0, relation18.getTree());

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
    // $ANTLR end "nodeItem"

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // LensQuery.g:213:1: fragment value : ( String | Integer | Double | QName );
    public final LensQueryParser.value_return value() throws RecognitionException {
        LensQueryParser.value_return retval = new LensQueryParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set19=null;

        Object set19_tree=null;

        try {
            // LensQuery.g:215:3: ( String | Integer | Double | QName )
            // LensQuery.g:
            {
            root_0 = (Object)adaptor.nil();

            set19=(Token)input.LT(1);
            if ( (input.LA(1)>=String && input.LA(1)<=Integer)||input.LA(1)==Double||input.LA(1)==QName ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set19));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "value"

    public static class nodeValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeValue"
    // LensQuery.g:218:1: fragment nodeValue : ( Colon value -> NODEVALUE[$value.text] | nodeCmp );
    public final LensQueryParser.nodeValue_return nodeValue() throws RecognitionException {
        LensQueryParser.nodeValue_return retval = new LensQueryParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon20=null;
        LensQueryParser.value_return value21 = null;

        LensQueryParser.nodeCmp_return nodeCmp22 = null;


        Object Colon20_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // LensQuery.g:220:3: ( Colon value -> NODEVALUE[$value.text] | nodeCmp )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=Lt && LA8_0<=Match)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // LensQuery.g:220:5: Colon value
                    {
                    Colon20=(Token)match(input,Colon,FOLLOW_Colon_in_nodeValue982);  
                    stream_Colon.add(Colon20);

                    pushFollow(FOLLOW_value_in_nodeValue984);
                    value21=value();

                    state._fsp--;

                    stream_value.add(value21.getTree());


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
                    // 220:17: -> NODEVALUE[$value.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NODEVALUE, (value21!=null?input.toString(value21.start,value21.stop):null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:221:5: nodeCmp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nodeCmp_in_nodeValue995);
                    nodeCmp22=nodeCmp();

                    state._fsp--;

                    adaptor.addChild(root_0, nodeCmp22.getTree());

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
    // $ANTLR end "nodeValue"

    public static class nodeCmp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeCmp"
    // LensQuery.g:224:1: fragment nodeCmp : ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) );
    public final LensQueryParser.nodeCmp_return nodeCmp() throws RecognitionException {
        LensQueryParser.nodeCmp_return retval = new LensQueryParser.nodeCmp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Match25=null;
        Token Regex26=null;
        LensQueryParser.cmpOp_return cmpOp23 = null;

        LensQueryParser.value_return value24 = null;


        Object Match25_tree=null;
        Object Regex26_tree=null;
        RewriteRuleTokenStream stream_Match=new RewriteRuleTokenStream(adaptor,"token Match");
        RewriteRuleTokenStream stream_Regex=new RewriteRuleTokenStream(adaptor,"token Regex");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_cmpOp=new RewriteRuleSubtreeStream(adaptor,"rule cmpOp");
        try {
            // LensQuery.g:226:3: ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=Lt && LA9_0<=Neq)) ) {
                alt9=1;
            }
            else if ( (LA9_0==Match) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // LensQuery.g:226:5: cmpOp value
                    {
                    pushFollow(FOLLOW_cmpOp_in_nodeCmp1015);
                    cmpOp23=cmpOp();

                    state._fsp--;

                    stream_cmpOp.add(cmpOp23.getTree());
                    pushFollow(FOLLOW_value_in_nodeCmp1017);
                    value24=value();

                    state._fsp--;

                    stream_value.add(value24.getTree());


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
                    // 226:17: -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                    {
                        // LensQuery.g:226:20: ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARE, "COMPARE"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERATOR, (cmpOp23!=null?input.toString(cmpOp23.start,cmpOp23.stop):null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (value24!=null?input.toString(value24.start,value24.stop):null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:227:5: Match Regex
                    {
                    Match25=(Token)match(input,Match,FOLLOW_Match_in_nodeCmp1035);  
                    stream_Match.add(Match25);

                    Regex26=(Token)match(input,Regex,FOLLOW_Regex_in_nodeCmp1037);  
                    stream_Regex.add(Regex26);



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
                    // 227:17: -> ^( PATTERNMATCH OPERAND[$Regex.text] )
                    {
                        // LensQuery.g:227:20: ^( PATTERNMATCH OPERAND[$Regex.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PATTERNMATCH, "PATTERNMATCH"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (Regex26!=null?Regex26.getText():null)));

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
    // $ANTLR end "nodeCmp"

    public static class cmpOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cmpOp"
    // LensQuery.g:230:1: fragment cmpOp : ( Lt | Gt | Eq | Leq | Geq | Neq ) ;
    public final LensQueryParser.cmpOp_return cmpOp() throws RecognitionException {
        LensQueryParser.cmpOp_return retval = new LensQueryParser.cmpOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set27=null;

        Object set27_tree=null;

        try {
            // LensQuery.g:231:6: ( ( Lt | Gt | Eq | Leq | Geq | Neq ) )
            // LensQuery.g:231:8: ( Lt | Gt | Eq | Leq | Geq | Neq )
            {
            root_0 = (Object)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=Lt && input.LA(1)<=Neq) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set27));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "cmpOp"

    public static class fd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fd"
    // LensQuery.g:234:1: fd : ( '*' -> FD[\"ZERO_OR_MORE\"] | '?' -> FD[\"ZERO_OR_ONE\"] | '+' -> FD[\"ONE_OR_MORE\"] );
    public final LensQueryParser.fd_return fd() throws RecognitionException {
        LensQueryParser.fd_return retval = new LensQueryParser.fd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;

        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");

        try {
            // LensQuery.g:235:3: ( '*' -> FD[\"ZERO_OR_MORE\"] | '?' -> FD[\"ZERO_OR_ONE\"] | '+' -> FD[\"ONE_OR_MORE\"] )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt10=1;
                }
                break;
            case 56:
                {
                alt10=2;
                }
                break;
            case 57:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // LensQuery.g:235:5: '*'
                    {
                    char_literal28=(Token)match(input,55,FOLLOW_55_in_fd1100);  
                    stream_55.add(char_literal28);



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
                    // 235:9: -> FD[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:236:5: '?'
                    {
                    char_literal29=(Token)match(input,56,FOLLOW_56_in_fd1113);  
                    stream_56.add(char_literal29);



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
                    // 236:9: -> FD[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // LensQuery.g:237:5: '+'
                    {
                    char_literal30=(Token)match(input,57,FOLLOW_57_in_fd1124);  
                    stream_57.add(char_literal30);



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
                    // 237:9: -> FD[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(FD, "ONE_OR_MORE"));

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
    // $ANTLR end "fd"

    // Delegated rules


 

    public static final BitSet FOLLOW_relation_in_expr781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_i_in_relation799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_relation_i815 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_alias_in_relation_i817 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_LParen_in_relation_i820 = new BitSet(new long[]{0x0020000004000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation_i823 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_Comma_in_relation_i826 = new BitSet(new long[]{0x0020000004000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation_i829 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_RParen_in_relation_i833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_nodeName847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeName858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_As_in_alias875 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_QName_in_alias877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem897 = new BitSet(new long[]{0x038031FC00000002L});
    public static final BitSet FOLLOW_alias_in_nodeItem899 = new BitSet(new long[]{0x038011FC00000002L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem902 = new BitSet(new long[]{0x0380000000000002L});
    public static final BitSet FOLLOW_fd_in_nodeItem905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_nodeItem933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_nodeValue982 = new BitSet(new long[]{0x002000004C000000L});
    public static final BitSet FOLLOW_value_in_nodeValue984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeCmp_in_nodeValue995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cmpOp_in_nodeCmp1015 = new BitSet(new long[]{0x002000004C000000L});
    public static final BitSet FOLLOW_value_in_nodeCmp1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Match_in_nodeCmp1035 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_Regex_in_nodeCmp1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_cmpOp1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_fd1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fd1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_fd1124 = new BitSet(new long[]{0x0000000000000002L});

}
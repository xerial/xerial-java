// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 LensQuery.g 2009-08-06 15:20:40

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

import org.xerial.lens.relation.TupleIndex;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class LensQueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "RELATION", "COMPARE", "OPERATOR", "OPERAND", "PATTERNMATCH", "NODE", "ALIAS", "NODEVALUE", "NAME", "VALUE", "INDEX", "LineBreakChar", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "True", "False", "Null", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Gt", "Leq", "Geq", "Eq", "Neq", "Match", "Regex", "Dot", "Comma", "Colon", "As", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "SafeFirstLetter", "SafeLetter", "WhiteSpace", "QNameChar", "QName", "WhiteSpaces"
    };
    public static final int INDEX=15;
    public static final int PATTERNMATCH=9;
    public static final int Match=44;
    public static final int RBrace=35;
    public static final int Regex=45;
    public static final int LBracket=36;
    public static final int Digit=19;
    public static final int Frac=28;
    public static final int HexDigit=21;
    public static final int QUERY=4;
    public static final int ALIAS=11;
    public static final int VALUE=14;
    public static final int Letter=20;
    public static final int Comma=47;
    public static final int Dot=46;
    public static final int EscapeSequence=23;
    public static final int Integer=27;
    public static final int WhiteSpace=56;
    public static final int OPERATOR=7;
    public static final int False=32;
    public static final int Colon=48;
    public static final int LineComment=17;
    public static final int NODEVALUE=12;
    public static final int As=49;
    public static final int SafeFirstLetter=54;
    public static final int Null=33;
    public static final int Star=52;
    public static final int Eq=42;
    public static final int Exp=29;
    public static final int QNameChar=57;
    public static final int RELATION=5;
    public static final int Gt=39;
    public static final int RParen=51;
    public static final int UnicodeChar=22;
    public static final int StringChar=24;
    public static final int True=31;
    public static final int OPERAND=8;
    public static final int LineBreak=18;
    public static final int LParen=50;
    public static final int String=26;
    public static final int SafeLetter=55;
    public static final int LineBreakChar=16;
    public static final int COMPARE=6;
    public static final int QName=58;
    public static final int EOF=-1;
    public static final int Geq=41;
    public static final int NODE=10;
    public static final int StringChar_s=25;
    public static final int Neq=43;
    public static final int UnsafeUnicodeChar=53;
    public static final int Double=30;
    public static final int LBrace=34;
    public static final int RBracket=37;
    public static final int Lt=38;
    public static final int NAME=13;
    public static final int Leq=40;
    public static final int WhiteSpaces=59;

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


       private TupleIndex currentIndex = null;


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // LensQuery.g:191:1: expr : relation ;
    public final LensQueryParser.expr_return expr() throws RecognitionException {
        LensQueryParser.expr_return retval = new LensQueryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.relation_return relation1 = null;



        try {
            // LensQuery.g:191:5: ( relation )
            // LensQuery.g:192:3: relation
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relation_in_expr806);
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

    protected static class relation_scope {
        int nodeItemIndex;
        TupleIndex relationIndex;
    }
    protected Stack relation_stack = new Stack();

    public static class relation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // LensQuery.g:195:1: relation : relation_i -> ^( RELATION relation_i INDEX[currentIndex.toString()] ) ;
    public final LensQueryParser.relation_return relation() throws RecognitionException {
        relation_stack.push(new relation_scope());
        LensQueryParser.relation_return retval = new LensQueryParser.relation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.relation_i_return relation_i2 = null;


        RewriteRuleSubtreeStream stream_relation_i=new RewriteRuleSubtreeStream(adaptor,"rule relation_i");

          ((relation_scope)relation_stack.peek()).nodeItemIndex = 1;
          if(currentIndex == null)
            currentIndex = new TupleIndex(1);
          else
            currentIndex = new TupleIndex(currentIndex, 1); 

        try {
            // LensQuery.g:213:4: ( relation_i -> ^( RELATION relation_i INDEX[currentIndex.toString()] ) )
            // LensQuery.g:213:6: relation_i
            {
            pushFollow(FOLLOW_relation_i_in_relation840);
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
            // 213:17: -> ^( RELATION relation_i INDEX[currentIndex.toString()] )
            {
                // LensQuery.g:213:20: ^( RELATION relation_i INDEX[currentIndex.toString()] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RELATION, "RELATION"), root_1);

                adaptor.addChild(root_1, stream_relation_i.nextTree());
                adaptor.addChild(root_1, (Object)adaptor.create(INDEX, currentIndex.toString()));

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


              currentIndex = currentIndex.parent();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            relation_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "relation"

    public static class relation_i_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation_i"
    // LensQuery.g:216:1: relation_i : nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen ;
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
            // LensQuery.g:216:11: ( nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen )
            // LensQuery.g:216:13: nodeName ( alias )? LParen nodeItem ( Comma nodeItem )* RParen
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nodeName_in_relation_i859);
            nodeName3=nodeName();

            state._fsp--;

            adaptor.addChild(root_0, nodeName3.getTree());
            // LensQuery.g:216:22: ( alias )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==As) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // LensQuery.g:216:22: alias
                    {
                    pushFollow(FOLLOW_alias_in_relation_i861);
                    alias4=alias();

                    state._fsp--;

                    adaptor.addChild(root_0, alias4.getTree());

                    }
                    break;

            }

            LParen5=(Token)match(input,LParen,FOLLOW_LParen_in_relation_i864); 
            pushFollow(FOLLOW_nodeItem_in_relation_i867);
            nodeItem6=nodeItem();

            state._fsp--;

            adaptor.addChild(root_0, nodeItem6.getTree());
            // LensQuery.g:216:46: ( Comma nodeItem )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // LensQuery.g:216:47: Comma nodeItem
            	    {
            	    Comma7=(Token)match(input,Comma,FOLLOW_Comma_in_relation_i870); 
            	    pushFollow(FOLLOW_nodeItem_in_relation_i873);
            	    nodeItem8=nodeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, nodeItem8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RParen9=(Token)match(input,RParen,FOLLOW_RParen_in_relation_i877); 

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
    // LensQuery.g:218:1: fragment nodeName : ( QName -> NAME[$QName.text] | String -> NAME[$String.text] );
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
            // LensQuery.g:220:3: ( QName -> NAME[$QName.text] | String -> NAME[$String.text] )
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
                    // LensQuery.g:220:5: QName
                    {
                    QName10=(Token)match(input,QName,FOLLOW_QName_in_nodeName890);  
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
                    // 220:11: -> NAME[$QName.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NAME, (QName10!=null?QName10.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:221:5: String
                    {
                    String11=(Token)match(input,String,FOLLOW_String_in_nodeName901);  
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
                    // 221:12: -> NAME[$String.text]
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
    // LensQuery.g:224:1: fragment alias : As QName -> ALIAS[$QName.text] ;
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
            // LensQuery.g:225:6: ( As QName -> ALIAS[$QName.text] )
            // LensQuery.g:225:8: As QName
            {
            As12=(Token)match(input,As,FOLLOW_As_in_alias918);  
            stream_As.add(As12);

            QName13=(Token)match(input,QName,FOLLOW_QName_in_alias920);  
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
            // 225:17: -> ALIAS[$QName.text]
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
    // LensQuery.g:228:1: fragment nodeItem : ( nodeName ( alias )? ( nodeValue )? -> ^( NODE nodeName ( alias )? ( nodeValue )? INDEX[new TupleIndex(currentIndex, index).toString()] ) | relation );
    public final LensQueryParser.nodeItem_return nodeItem() throws RecognitionException {
        LensQueryParser.nodeItem_return retval = new LensQueryParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.nodeName_return nodeName14 = null;

        LensQueryParser.alias_return alias15 = null;

        LensQueryParser.nodeValue_return nodeValue16 = null;

        LensQueryParser.relation_return relation17 = null;


        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");

          int index = ((relation_scope)relation_stack.peek()).nodeItemIndex++;

        try {
            // LensQuery.g:233:3: ( nodeName ( alias )? ( nodeValue )? -> ^( NODE nodeName ( alias )? ( nodeValue )? INDEX[new TupleIndex(currentIndex, index).toString()] ) | relation )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==QName) ) {
                switch ( input.LA(2) ) {
                case As:
                    {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==QName) ) {
                        int LA6_6 = input.LA(4);

                        if ( ((LA6_6>=Lt && LA6_6<=Match)||(LA6_6>=Comma && LA6_6<=Colon)||LA6_6==RParen) ) {
                            alt6=1;
                        }
                        else if ( (LA6_6==LParen) ) {
                            alt6=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

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
                    {
                    alt6=1;
                    }
                    break;
                case LParen:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA6_0==String) ) {
                switch ( input.LA(2) ) {
                case As:
                    {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==QName) ) {
                        int LA6_6 = input.LA(4);

                        if ( ((LA6_6>=Lt && LA6_6<=Match)||(LA6_6>=Comma && LA6_6<=Colon)||LA6_6==RParen) ) {
                            alt6=1;
                        }
                        else if ( (LA6_6==LParen) ) {
                            alt6=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case LParen:
                    {
                    alt6=2;
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
                    {
                    alt6=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // LensQuery.g:233:5: nodeName ( alias )? ( nodeValue )?
                    {
                    pushFollow(FOLLOW_nodeName_in_nodeItem945);
                    nodeName14=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName14.getTree());
                    // LensQuery.g:233:14: ( alias )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==As) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // LensQuery.g:233:14: alias
                            {
                            pushFollow(FOLLOW_alias_in_nodeItem947);
                            alias15=alias();

                            state._fsp--;

                            stream_alias.add(alias15.getTree());

                            }
                            break;

                    }

                    // LensQuery.g:233:21: ( nodeValue )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Lt && LA5_0<=Match)||LA5_0==Colon) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // LensQuery.g:233:21: nodeValue
                            {
                            pushFollow(FOLLOW_nodeValue_in_nodeItem950);
                            nodeValue16=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue16.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: alias, nodeValue, nodeName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 234:5: -> ^( NODE nodeName ( alias )? ( nodeValue )? INDEX[new TupleIndex(currentIndex, index).toString()] )
                    {
                        // LensQuery.g:234:8: ^( NODE nodeName ( alias )? ( nodeValue )? INDEX[new TupleIndex(currentIndex, index).toString()] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                        adaptor.addChild(root_1, stream_nodeName.nextTree());
                        // LensQuery.g:234:24: ( alias )?
                        if ( stream_alias.hasNext() ) {
                            adaptor.addChild(root_1, stream_alias.nextTree());

                        }
                        stream_alias.reset();
                        // LensQuery.g:234:31: ( nodeValue )?
                        if ( stream_nodeValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_nodeValue.nextTree());

                        }
                        stream_nodeValue.reset();
                        adaptor.addChild(root_1, (Object)adaptor.create(INDEX, new TupleIndex(currentIndex, index).toString()));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:235:5: relation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relation_in_nodeItem979);
                    relation17=relation();

                    state._fsp--;

                    adaptor.addChild(root_0, relation17.getTree());

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
    // LensQuery.g:238:1: fragment value : ( String | Integer | Double | QName );
    public final LensQueryParser.value_return value() throws RecognitionException {
        LensQueryParser.value_return retval = new LensQueryParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set18=null;

        Object set18_tree=null;

        try {
            // LensQuery.g:240:3: ( String | Integer | Double | QName )
            // LensQuery.g:
            {
            root_0 = (Object)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( (input.LA(1)>=String && input.LA(1)<=Integer)||input.LA(1)==Double||input.LA(1)==QName ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set18));
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
    // LensQuery.g:243:1: fragment nodeValue : ( Colon value -> NODEVALUE[$value.text] | nodeCmp );
    public final LensQueryParser.nodeValue_return nodeValue() throws RecognitionException {
        LensQueryParser.nodeValue_return retval = new LensQueryParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon19=null;
        LensQueryParser.value_return value20 = null;

        LensQueryParser.nodeCmp_return nodeCmp21 = null;


        Object Colon19_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // LensQuery.g:245:3: ( Colon value -> NODEVALUE[$value.text] | nodeCmp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=Lt && LA7_0<=Match)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // LensQuery.g:245:5: Colon value
                    {
                    Colon19=(Token)match(input,Colon,FOLLOW_Colon_in_nodeValue1028);  
                    stream_Colon.add(Colon19);

                    pushFollow(FOLLOW_value_in_nodeValue1030);
                    value20=value();

                    state._fsp--;

                    stream_value.add(value20.getTree());


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
                    // 245:17: -> NODEVALUE[$value.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NODEVALUE, (value20!=null?input.toString(value20.start,value20.stop):null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:246:5: nodeCmp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nodeCmp_in_nodeValue1041);
                    nodeCmp21=nodeCmp();

                    state._fsp--;

                    adaptor.addChild(root_0, nodeCmp21.getTree());

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
    // LensQuery.g:249:1: fragment nodeCmp : ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) );
    public final LensQueryParser.nodeCmp_return nodeCmp() throws RecognitionException {
        LensQueryParser.nodeCmp_return retval = new LensQueryParser.nodeCmp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Match24=null;
        Token Regex25=null;
        LensQueryParser.cmpOp_return cmpOp22 = null;

        LensQueryParser.value_return value23 = null;


        Object Match24_tree=null;
        Object Regex25_tree=null;
        RewriteRuleTokenStream stream_Match=new RewriteRuleTokenStream(adaptor,"token Match");
        RewriteRuleTokenStream stream_Regex=new RewriteRuleTokenStream(adaptor,"token Regex");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_cmpOp=new RewriteRuleSubtreeStream(adaptor,"rule cmpOp");
        try {
            // LensQuery.g:251:3: ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=Lt && LA8_0<=Neq)) ) {
                alt8=1;
            }
            else if ( (LA8_0==Match) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // LensQuery.g:251:5: cmpOp value
                    {
                    pushFollow(FOLLOW_cmpOp_in_nodeCmp1061);
                    cmpOp22=cmpOp();

                    state._fsp--;

                    stream_cmpOp.add(cmpOp22.getTree());
                    pushFollow(FOLLOW_value_in_nodeCmp1063);
                    value23=value();

                    state._fsp--;

                    stream_value.add(value23.getTree());


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
                    // 251:17: -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                    {
                        // LensQuery.g:251:20: ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARE, "COMPARE"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERATOR, (cmpOp22!=null?input.toString(cmpOp22.start,cmpOp22.stop):null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (value23!=null?input.toString(value23.start,value23.stop):null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:252:5: Match Regex
                    {
                    Match24=(Token)match(input,Match,FOLLOW_Match_in_nodeCmp1081);  
                    stream_Match.add(Match24);

                    Regex25=(Token)match(input,Regex,FOLLOW_Regex_in_nodeCmp1083);  
                    stream_Regex.add(Regex25);



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
                    // 252:17: -> ^( PATTERNMATCH OPERAND[$Regex.text] )
                    {
                        // LensQuery.g:252:20: ^( PATTERNMATCH OPERAND[$Regex.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PATTERNMATCH, "PATTERNMATCH"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (Regex25!=null?Regex25.getText():null)));

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
    // LensQuery.g:255:1: fragment cmpOp : ( Lt | Gt | Eq | Leq | Geq | Neq ) ;
    public final LensQueryParser.cmpOp_return cmpOp() throws RecognitionException {
        LensQueryParser.cmpOp_return retval = new LensQueryParser.cmpOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set26=null;

        Object set26_tree=null;

        try {
            // LensQuery.g:256:6: ( ( Lt | Gt | Eq | Leq | Geq | Neq ) )
            // LensQuery.g:256:8: ( Lt | Gt | Eq | Leq | Geq | Neq )
            {
            root_0 = (Object)adaptor.nil();

            set26=(Token)input.LT(1);
            if ( (input.LA(1)>=Lt && input.LA(1)<=Neq) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set26));
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

    // Delegated rules


 

    public static final BitSet FOLLOW_relation_in_expr806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_i_in_relation840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_relation_i859 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_alias_in_relation_i861 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LParen_in_relation_i864 = new BitSet(new long[]{0x0400000004000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation_i867 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_Comma_in_relation_i870 = new BitSet(new long[]{0x0400000004000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation_i873 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_RParen_in_relation_i877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_nodeName890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeName901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_As_in_alias918 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_alias920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem945 = new BitSet(new long[]{0x00031FC000000002L});
    public static final BitSet FOLLOW_alias_in_nodeItem947 = new BitSet(new long[]{0x00011FC000000002L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_nodeItem979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_nodeValue1028 = new BitSet(new long[]{0x040000004C000000L});
    public static final BitSet FOLLOW_value_in_nodeValue1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeCmp_in_nodeValue1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cmpOp_in_nodeCmp1061 = new BitSet(new long[]{0x040000004C000000L});
    public static final BitSet FOLLOW_value_in_nodeCmp1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Match_in_nodeCmp1081 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_Regex_in_nodeCmp1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_cmpOp1108 = new BitSet(new long[]{0x0000000000000002L});

}
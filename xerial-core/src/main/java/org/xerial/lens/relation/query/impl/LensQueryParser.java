// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 LensQuery.g 2009-08-06 11:41:05

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "RELATION", "COMPARE", "OPERATOR", "OPERAND", "PATTERNMATCH", "NODE", "NODEVALUE", "NAME", "VALUE", "LineBreakChar", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "True", "False", "Null", "LBrace", "RBrace", "LBracket", "RBracket", "Lt", "Gt", "Leq", "Geq", "Eq", "Neq", "Match", "Regex", "Dot", "Comma", "Colon", "LParen", "RParen", "Star", "UnsafeUnicodeChar", "SafeFirstLetter", "SafeLetter", "ModuleName", "WhiteSpaces", "ModuleDef", "WhiteSpace", "QNameChar", "QName"
    };
    public static final int PATTERNMATCH=9;
    public static final int RBrace=33;
    public static final int Match=42;
    public static final int LBracket=34;
    public static final int Regex=43;
    public static final int Digit=17;
    public static final int Frac=26;
    public static final int HexDigit=19;
    public static final int QUERY=4;
    public static final int VALUE=13;
    public static final int Letter=18;
    public static final int Comma=45;
    public static final int Dot=44;
    public static final int EscapeSequence=21;
    public static final int Integer=25;
    public static final int WhiteSpace=56;
    public static final int OPERATOR=7;
    public static final int False=30;
    public static final int Colon=46;
    public static final int LineComment=15;
    public static final int NODEVALUE=11;
    public static final int ModuleName=53;
    public static final int SafeFirstLetter=51;
    public static final int Null=31;
    public static final int Star=49;
    public static final int Eq=40;
    public static final int Exp=27;
    public static final int QNameChar=57;
    public static final int RELATION=5;
    public static final int Gt=37;
    public static final int RParen=48;
    public static final int UnicodeChar=20;
    public static final int StringChar=22;
    public static final int True=29;
    public static final int OPERAND=8;
    public static final int LineBreak=16;
    public static final int ModuleDef=55;
    public static final int LParen=47;
    public static final int String=24;
    public static final int SafeLetter=52;
    public static final int LineBreakChar=14;
    public static final int COMPARE=6;
    public static final int QName=58;
    public static final int EOF=-1;
    public static final int Geq=39;
    public static final int NODE=10;
    public static final int StringChar_s=23;
    public static final int Neq=41;
    public static final int UnsafeUnicodeChar=50;
    public static final int Double=28;
    public static final int LBrace=32;
    public static final int RBracket=35;
    public static final int Lt=36;
    public static final int NAME=12;
    public static final int Leq=38;
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
    // LensQuery.g:184:1: expr : relation ;
    public final LensQueryParser.expr_return expr() throws RecognitionException {
        LensQueryParser.expr_return retval = new LensQueryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        LensQueryParser.relation_return relation1 = null;



        try {
            // LensQuery.g:184:5: ( relation )
            // LensQuery.g:185:3: relation
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relation_in_expr821);
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
    // LensQuery.g:188:1: relation : QName LParen nodeItem ( Comma nodeItem )* RParen -> ^( RELATION NAME[$QName.text] ( nodeItem )+ ) ;
    public final LensQueryParser.relation_return relation() throws RecognitionException {
        LensQueryParser.relation_return retval = new LensQueryParser.relation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName2=null;
        Token LParen3=null;
        Token Comma5=null;
        Token RParen7=null;
        LensQueryParser.nodeItem_return nodeItem4 = null;

        LensQueryParser.nodeItem_return nodeItem6 = null;


        Object QName2_tree=null;
        Object LParen3_tree=null;
        Object Comma5_tree=null;
        Object RParen7_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // LensQuery.g:188:9: ( QName LParen nodeItem ( Comma nodeItem )* RParen -> ^( RELATION NAME[$QName.text] ( nodeItem )+ ) )
            // LensQuery.g:188:11: QName LParen nodeItem ( Comma nodeItem )* RParen
            {
            QName2=(Token)match(input,QName,FOLLOW_QName_in_relation834);  
            stream_QName.add(QName2);

            LParen3=(Token)match(input,LParen,FOLLOW_LParen_in_relation836);  
            stream_LParen.add(LParen3);

            pushFollow(FOLLOW_nodeItem_in_relation838);
            nodeItem4=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem4.getTree());
            // LensQuery.g:188:33: ( Comma nodeItem )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Comma) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // LensQuery.g:188:34: Comma nodeItem
            	    {
            	    Comma5=(Token)match(input,Comma,FOLLOW_Comma_in_relation841);  
            	    stream_Comma.add(Comma5);

            	    pushFollow(FOLLOW_nodeItem_in_relation843);
            	    nodeItem6=nodeItem();

            	    state._fsp--;

            	    stream_nodeItem.add(nodeItem6.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            RParen7=(Token)match(input,RParen,FOLLOW_RParen_in_relation847);  
            stream_RParen.add(RParen7);



            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 189:3: -> ^( RELATION NAME[$QName.text] ( nodeItem )+ )
            {
                // LensQuery.g:189:6: ^( RELATION NAME[$QName.text] ( nodeItem )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RELATION, "RELATION"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (QName2!=null?QName2.getText():null)));
                if ( !(stream_nodeItem.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_nodeItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_nodeItem.nextTree());

                }
                stream_nodeItem.reset();

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

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // LensQuery.g:192:1: fragment nodeItem : ( QName ( nodeValue )? -> ^( NODE NAME[$QName.text] ( nodeValue )? ) | relation );
    public final LensQueryParser.nodeItem_return nodeItem() throws RecognitionException {
        LensQueryParser.nodeItem_return retval = new LensQueryParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName8=null;
        LensQueryParser.nodeValue_return nodeValue9 = null;

        LensQueryParser.relation_return relation10 = null;


        Object QName8_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // LensQuery.g:194:3: ( QName ( nodeValue )? -> ^( NODE NAME[$QName.text] ( nodeValue )? ) | relation )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QName) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==LParen) ) {
                    alt3=2;
                }
                else if ( ((LA3_1>=Lt && LA3_1<=Match)||(LA3_1>=Comma && LA3_1<=Colon)||LA3_1==RParen) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // LensQuery.g:194:5: QName ( nodeValue )?
                    {
                    QName8=(Token)match(input,QName,FOLLOW_QName_in_nodeItem876);  
                    stream_QName.add(QName8);

                    // LensQuery.g:194:11: ( nodeValue )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=Lt && LA2_0<=Match)||LA2_0==Colon) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // LensQuery.g:194:11: nodeValue
                            {
                            pushFollow(FOLLOW_nodeValue_in_nodeItem878);
                            nodeValue9=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue9.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: nodeValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 195:5: -> ^( NODE NAME[$QName.text] ( nodeValue )? )
                    {
                        // LensQuery.g:195:8: ^( NODE NAME[$QName.text] ( nodeValue )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NAME, (QName8!=null?QName8.getText():null)));
                        // LensQuery.g:195:33: ( nodeValue )?
                        if ( stream_nodeValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_nodeValue.nextTree());

                        }
                        stream_nodeValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:196:5: relation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relation_in_nodeItem902);
                    relation10=relation();

                    state._fsp--;

                    adaptor.addChild(root_0, relation10.getTree());

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
    // LensQuery.g:199:1: fragment value : ( String | Integer | Double );
    public final LensQueryParser.value_return value() throws RecognitionException {
        LensQueryParser.value_return retval = new LensQueryParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set11=null;

        Object set11_tree=null;

        try {
            // LensQuery.g:200:6: ( String | Integer | Double )
            // LensQuery.g:
            {
            root_0 = (Object)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( (input.LA(1)>=String && input.LA(1)<=Integer)||input.LA(1)==Double ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set11));
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
    // LensQuery.g:202:1: fragment nodeValue : ( Colon value -> NODEVALUE[$value.text] | nodeCmp );
    public final LensQueryParser.nodeValue_return nodeValue() throws RecognitionException {
        LensQueryParser.nodeValue_return retval = new LensQueryParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon12=null;
        LensQueryParser.value_return value13 = null;

        LensQueryParser.nodeCmp_return nodeCmp14 = null;


        Object Colon12_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // LensQuery.g:204:3: ( Colon value -> NODEVALUE[$value.text] | nodeCmp )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Colon) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=Lt && LA4_0<=Match)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // LensQuery.g:204:5: Colon value
                    {
                    Colon12=(Token)match(input,Colon,FOLLOW_Colon_in_nodeValue940);  
                    stream_Colon.add(Colon12);

                    pushFollow(FOLLOW_value_in_nodeValue942);
                    value13=value();

                    state._fsp--;

                    stream_value.add(value13.getTree());


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
                    // 204:17: -> NODEVALUE[$value.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(NODEVALUE, (value13!=null?input.toString(value13.start,value13.stop):null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:205:5: nodeCmp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_nodeCmp_in_nodeValue953);
                    nodeCmp14=nodeCmp();

                    state._fsp--;

                    adaptor.addChild(root_0, nodeCmp14.getTree());

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
    // LensQuery.g:208:1: fragment nodeCmp : ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) );
    public final LensQueryParser.nodeCmp_return nodeCmp() throws RecognitionException {
        LensQueryParser.nodeCmp_return retval = new LensQueryParser.nodeCmp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Match17=null;
        Token Regex18=null;
        LensQueryParser.cmpOp_return cmpOp15 = null;

        LensQueryParser.value_return value16 = null;


        Object Match17_tree=null;
        Object Regex18_tree=null;
        RewriteRuleTokenStream stream_Match=new RewriteRuleTokenStream(adaptor,"token Match");
        RewriteRuleTokenStream stream_Regex=new RewriteRuleTokenStream(adaptor,"token Regex");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_cmpOp=new RewriteRuleSubtreeStream(adaptor,"rule cmpOp");
        try {
            // LensQuery.g:210:3: ( cmpOp value -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] ) | Match Regex -> ^( PATTERNMATCH OPERAND[$Regex.text] ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=Lt && LA5_0<=Neq)) ) {
                alt5=1;
            }
            else if ( (LA5_0==Match) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // LensQuery.g:210:5: cmpOp value
                    {
                    pushFollow(FOLLOW_cmpOp_in_nodeCmp973);
                    cmpOp15=cmpOp();

                    state._fsp--;

                    stream_cmpOp.add(cmpOp15.getTree());
                    pushFollow(FOLLOW_value_in_nodeCmp975);
                    value16=value();

                    state._fsp--;

                    stream_value.add(value16.getTree());


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
                    // 210:17: -> ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                    {
                        // LensQuery.g:210:20: ^( COMPARE OPERATOR[$cmpOp.text] OPERAND[$value.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARE, "COMPARE"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERATOR, (cmpOp15!=null?input.toString(cmpOp15.start,cmpOp15.stop):null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (value16!=null?input.toString(value16.start,value16.stop):null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // LensQuery.g:211:5: Match Regex
                    {
                    Match17=(Token)match(input,Match,FOLLOW_Match_in_nodeCmp993);  
                    stream_Match.add(Match17);

                    Regex18=(Token)match(input,Regex,FOLLOW_Regex_in_nodeCmp995);  
                    stream_Regex.add(Regex18);



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
                    // 211:17: -> ^( PATTERNMATCH OPERAND[$Regex.text] )
                    {
                        // LensQuery.g:211:20: ^( PATTERNMATCH OPERAND[$Regex.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PATTERNMATCH, "PATTERNMATCH"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(OPERAND, (Regex18!=null?Regex18.getText():null)));

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
    // LensQuery.g:214:1: fragment cmpOp : ( Lt | Gt | Eq | Leq | Geq | Neq ) ;
    public final LensQueryParser.cmpOp_return cmpOp() throws RecognitionException {
        LensQueryParser.cmpOp_return retval = new LensQueryParser.cmpOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set19=null;

        Object set19_tree=null;

        try {
            // LensQuery.g:215:6: ( ( Lt | Gt | Eq | Leq | Geq | Neq ) )
            // LensQuery.g:215:8: ( Lt | Gt | Eq | Leq | Geq | Neq )
            {
            root_0 = (Object)adaptor.nil();

            set19=(Token)input.LT(1);
            if ( (input.LA(1)>=Lt && input.LA(1)<=Neq) ) {
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
    // $ANTLR end "cmpOp"

    // Delegated rules


 

    public static final BitSet FOLLOW_relation_in_expr821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_relation834 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LParen_in_relation836 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation838 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Comma_in_relation841 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_nodeItem_in_relation843 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_RParen_in_relation847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_nodeItem876 = new BitSet(new long[]{0x000047F000000002L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_nodeItem902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_nodeValue940 = new BitSet(new long[]{0x0000000013000000L});
    public static final BitSet FOLLOW_value_in_nodeValue942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeCmp_in_nodeValue953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cmpOp_in_nodeCmp973 = new BitSet(new long[]{0x0000000013000000L});
    public static final BitSet FOLLOW_value_in_nodeCmp975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Match_in_nodeCmp993 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Regex_in_nodeCmp995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_cmpOp1020 = new BitSet(new long[]{0x0000000000000002L});

}
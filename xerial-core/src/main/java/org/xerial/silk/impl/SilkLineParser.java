// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkLine.g 2010-01-18 15:55:07

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
// SilkParser.java
// Since: Jan 28, 2009 1:00:02 PM
//
//--------------------------------------
package org.xerial.silk.impl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SilkLineParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "WhiteSpace", "LineBreakChar", "LineComment", "NodeIndent", "FunctionIndent", "BlankLine", "LParen", "RParen", "Comma", "Colon", "EqEq", "Seq", "TabSeq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "ScopeIndicator", "FlowIndicator", "Indicator", "PlainUnsafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "NonSpaceChar", "PlainFirst", "PlainOneLine", "Separation"
    };
    public static final int Key=14;
    public static final int PlainUnsafeChar=45;
    public static final int PlainSafeKey=46;
    public static final int DataType=10;
    public static final int EqEq=25;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=31;
    public static final int NodeIndent=18;
    public static final int Digit=34;
    public static final int HexDigit=36;
    public static final int PlainOneLine=51;
    public static final int Plus=30;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Separation=52;
    public static final int FlowIndicator=43;
    public static final int Letter=35;
    public static final int PlainSafeIn=47;
    public static final int Comma=23;
    public static final int TabSeq=27;
    public static final int NonSpaceChar=49;
    public static final int EscapeSequence=38;
    public static final int PlainFirst=50;
    public static final int WhiteSpace=15;
    public static final int PlainSafeOut=48;
    public static final int Question=33;
    public static final int LineComment=17;
    public static final int Colon=24;
    public static final int At=29;
    public static final int KeyValuePair=13;
    public static final int Star=28;
    public static final int Seq=26;
    public static final int FunctionIndent=19;
    public static final int Indicator=44;
    public static final int RParen=22;
    public static final int UnicodeChar=37;
    public static final int Silk=4;
    public static final int BlankLine=20;
    public static final int StringChar=39;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=21;
    public static final int String=41;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=42;
    public static final int EOF=-1;
    public static final int StringChar_s=40;
    public static final int Value=8;
    public static final int RBracket=32;

    // delegates
    // delegators


        public SilkLineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SilkLineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SilkLineParser.tokenNames; }
    public String getGrammarFileName() { return "SilkLine.g"; }


    public static class silkFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkFile"
    // SilkLine.g:266:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkLineParser.silkFile_return silkFile() throws RecognitionException {
        SilkLineParser.silkFile_return retval = new SilkLineParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkLineParser.silkLine_return silkLine1 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // SilkLine.g:266:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // SilkLine.g:266:11: ( silkLine )*
            {
            // SilkLine.g:266:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WhiteSpace||(LA1_0>=LineComment && LA1_0<=FunctionIndent)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkLine.g:266:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile863);
            	    silkLine1=silkLine();

            	    state._fsp--;

            	    stream_silkLine.add(silkLine1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: silkLine
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 266:21: -> ^( Silk ( silkLine )* )
            {
                // SilkLine.g:266:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // SilkLine.g:266:31: ( silkLine )*
                while ( stream_silkLine.hasNext() ) {
                    adaptor.addChild(root_1, stream_silkLine.nextTree());

                }
                stream_silkLine.reset();

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
    // $ANTLR end "silkFile"

    public static class silkLine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkLine"
    // SilkLine.g:269:1: silkLine : ( silkNode | LineComment | WhiteSpace -> BlankLine );
    public final SilkLineParser.silkLine_return silkLine() throws RecognitionException {
        SilkLineParser.silkLine_return retval = new SilkLineParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LineComment3=null;
        Token WhiteSpace4=null;
        SilkLineParser.silkNode_return silkNode2 = null;


        Object LineComment3_tree=null;
        Object WhiteSpace4_tree=null;
        RewriteRuleTokenStream stream_WhiteSpace=new RewriteRuleTokenStream(adaptor,"token WhiteSpace");

        try {
            // SilkLine.g:270:2: ( silkNode | LineComment | WhiteSpace -> BlankLine )
            int alt2=3;
            switch ( input.LA(1) ) {
            case NodeIndent:
            case FunctionIndent:
                {
                alt2=1;
                }
                break;
            case LineComment:
                {
                alt2=2;
                }
                break;
            case WhiteSpace:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // SilkLine.g:270:4: silkNode
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_silkNode_in_silkLine884);
                    silkNode2=silkNode();

                    state._fsp--;

                    adaptor.addChild(root_0, silkNode2.getTree());

                    }
                    break;
                case 2 :
                    // SilkLine.g:271:4: LineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    LineComment3=(Token)match(input,LineComment,FOLLOW_LineComment_in_silkLine890); 
                    LineComment3_tree = (Object)adaptor.create(LineComment3);
                    adaptor.addChild(root_0, LineComment3_tree);


                    }
                    break;
                case 3 :
                    // SilkLine.g:272:4: WhiteSpace
                    {
                    WhiteSpace4=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine895);  
                    stream_WhiteSpace.add(WhiteSpace4);



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
                    // 272:15: -> BlankLine
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(BlankLine, "BlankLine"));

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
    // $ANTLR end "silkLine"

    public static class nodeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeName"
    // SilkLine.g:275:1: fragment nodeName : ( PlainOneLine | String );
    public final SilkLineParser.nodeName_return nodeName() throws RecognitionException {
        SilkLineParser.nodeName_return retval = new SilkLineParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set5=null;

        Object set5_tree=null;

        try {
            // SilkLine.g:276:9: ( PlainOneLine | String )
            // SilkLine.g:
            {
            root_0 = (Object)adaptor.nil();

            set5=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set5));
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
    // $ANTLR end "nodeName"

    public static class nodeValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeValue"
    // SilkLine.g:278:1: fragment nodeValue : ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] );
    public final SilkLineParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkLineParser.nodeValue_return retval = new SilkLineParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine7=null;
        Token String8=null;
        SilkLineParser.function_i_return function_i6 = null;


        Object PlainOneLine7_tree=null;
        Object String8_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // SilkLine.g:280:2: ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==At) ) {
                alt4=1;
            }
            else if ( (LA4_0==String||LA4_0==PlainOneLine) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // SilkLine.g:280:4: function_i
                    {
                    pushFollow(FOLLOW_function_i_in_nodeValue925);
                    function_i6=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i6.getTree());


                    // AST REWRITE
                    // elements: function_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 280:15: -> ^( Function function_i )
                    {
                        // SilkLine.g:280:18: ^( Function function_i )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, stream_function_i.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:281:4: ( PlainOneLine | String )
                    {
                    // SilkLine.g:281:4: ( PlainOneLine | String )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==PlainOneLine) ) {
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
                            // SilkLine.g:281:5: PlainOneLine
                            {
                            PlainOneLine7=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue939);  
                            stream_PlainOneLine.add(PlainOneLine7);


                            }
                            break;
                        case 2 :
                            // SilkLine.g:281:20: String
                            {
                            String8=(Token)match(input,String,FOLLOW_String_in_nodeValue943);  
                            stream_String.add(String8);


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
                    // 281:28: -> Value[$nodeValue.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

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
    // $ANTLR end "nodeValue"

    public static class silkNode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkNode"
    // SilkLine.g:286:1: silkNode : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) | function );
    public final SilkLineParser.silkNode_return silkNode() throws RecognitionException {
        SilkLineParser.silkNode_return retval = new SilkLineParser.silkNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent9=null;
        Token NodeIndent11=null;
        Token LParen12=null;
        Token RParen14=null;
        Token Colon16=null;
        SilkLineParser.nodeItem_return nodeItem10 = null;

        SilkLineParser.attributeList_return attributeList13 = null;

        SilkLineParser.plural_return plural15 = null;

        SilkLineParser.nodeValue_return nodeValue17 = null;

        SilkLineParser.function_return function18 = null;


        Object NodeIndent9_tree=null;
        Object NodeIndent11_tree=null;
        Object LParen12_tree=null;
        Object RParen14_tree=null;
        Object Colon16_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // SilkLine.g:287:2: ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) | function )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NodeIndent) ) {
                switch ( input.LA(2) ) {
                case At:
                    {
                    alt8=3;
                    }
                    break;
                case String:
                case PlainOneLine:
                    {
                    alt8=1;
                    }
                    break;
                case EOF:
                case WhiteSpace:
                case LineComment:
                case NodeIndent:
                case FunctionIndent:
                case LParen:
                case Colon:
                case EqEq:
                case Seq:
                case TabSeq:
                case Star:
                case Plus:
                case Question:
                    {
                    alt8=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA8_0==FunctionIndent) ) {
                alt8=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // SilkLine.g:287:4: NodeIndent nodeItem
                    {
                    NodeIndent9=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkNode963);  
                    stream_NodeIndent.add(NodeIndent9);

                    pushFollow(FOLLOW_nodeItem_in_silkNode965);
                    nodeItem10=nodeItem();

                    state._fsp--;

                    stream_nodeItem.add(nodeItem10.getTree());


                    // AST REWRITE
                    // elements: NodeIndent, nodeItem
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 287:24: -> ^( SilkNode NodeIndent nodeItem )
                    {
                        // SilkLine.g:287:27: ^( SilkNode NodeIndent nodeItem )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                        adaptor.addChild(root_1, stream_NodeIndent.nextNode());
                        adaptor.addChild(root_1, stream_nodeItem.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:288:4: NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
                    {
                    NodeIndent11=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkNode980);  
                    stream_NodeIndent.add(NodeIndent11);

                    // SilkLine.g:288:15: ( LParen attributeList RParen )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==LParen) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // SilkLine.g:288:16: LParen attributeList RParen
                            {
                            LParen12=(Token)match(input,LParen,FOLLOW_LParen_in_silkNode983);  
                            stream_LParen.add(LParen12);

                            pushFollow(FOLLOW_attributeList_in_silkNode985);
                            attributeList13=attributeList();

                            state._fsp--;

                            stream_attributeList.add(attributeList13.getTree());
                            RParen14=(Token)match(input,RParen,FOLLOW_RParen_in_silkNode987);  
                            stream_RParen.add(RParen14);


                            }
                            break;

                    }

                    // SilkLine.g:288:46: ( plural )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=EqEq && LA6_0<=Star)||LA6_0==Plus||LA6_0==Question) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // SilkLine.g:288:46: plural
                            {
                            pushFollow(FOLLOW_plural_in_silkNode991);
                            plural15=plural();

                            state._fsp--;

                            stream_plural.add(plural15.getTree());

                            }
                            break;

                    }

                    // SilkLine.g:288:54: ( Colon nodeValue )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==Colon) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // SilkLine.g:288:55: Colon nodeValue
                            {
                            Colon16=(Token)match(input,Colon,FOLLOW_Colon_in_silkNode995);  
                            stream_Colon.add(Colon16);

                            pushFollow(FOLLOW_nodeValue_in_silkNode997);
                            nodeValue17=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue17.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: nodeValue, NodeIndent, plural, attributeList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 289:2: -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
                    {
                        // SilkLine.g:289:5: ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                        adaptor.addChild(root_1, stream_NodeIndent.nextNode());
                        // SilkLine.g:289:27: ( attributeList )?
                        if ( stream_attributeList.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeList.nextTree());

                        }
                        stream_attributeList.reset();
                        // SilkLine.g:289:42: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();
                        // SilkLine.g:289:50: ( nodeValue )?
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
                case 3 :
                    // SilkLine.g:290:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkNode1022);
                    function18=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function18.getTree());

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
    // $ANTLR end "silkNode"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // SilkLine.g:293:1: fragment nodeItem : nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? ;
    public final SilkLineParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkLineParser.nodeItem_return retval = new SilkLineParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen21=null;
        Token RParen23=null;
        Token Colon25=null;
        SilkLineParser.nodeName_return nodeName19 = null;

        SilkLineParser.dataType_return dataType20 = null;

        SilkLineParser.attributeList_return attributeList22 = null;

        SilkLineParser.plural_return plural24 = null;

        SilkLineParser.nodeValue_return nodeValue26 = null;


        Object LParen21_tree=null;
        Object RParen23_tree=null;
        Object Colon25_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // SilkLine.g:294:9: ( nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? )
            // SilkLine.g:294:11: nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1035);
            nodeName19=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName19.getTree());
            // SilkLine.g:294:20: ( dataType )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LBracket) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // SilkLine.g:294:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1037);
                    dataType20=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType20.getTree());

                    }
                    break;

            }

            // SilkLine.g:294:31: ( LParen attributeList RParen )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LParen) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // SilkLine.g:294:32: LParen attributeList RParen
                    {
                    LParen21=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1042);  
                    stream_LParen.add(LParen21);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1044);
                    attributeList22=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList22.getTree());
                    RParen23=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1046);  
                    stream_RParen.add(RParen23);


                    }
                    break;

            }

            // SilkLine.g:294:62: ( plural )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=EqEq && LA11_0<=Star)||LA11_0==Plus||LA11_0==Question) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // SilkLine.g:294:62: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1050);
                    plural24=plural();

                    state._fsp--;

                    stream_plural.add(plural24.getTree());

                    }
                    break;

            }

            // SilkLine.g:294:70: ( Colon nodeValue )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // SilkLine.g:294:71: Colon nodeValue
                    {
                    Colon25=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1054);  
                    stream_Colon.add(Colon25);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1056);
                    nodeValue26=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue26.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeList, plural, dataType, nodeValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 295:2: -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName19!=null?input.toString(nodeName19.start,nodeName19.stop):null).trim()));
                // SilkLine.g:295:33: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // SilkLine.g:295:43: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();
                // SilkLine.g:295:58: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // SilkLine.g:295:66: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_0, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();

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
    // $ANTLR end "nodeItem"

    public static class dataType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataType"
    // SilkLine.g:298:1: fragment dataType : LBracket dataTypeName RBracket ;
    public final SilkLineParser.dataType_return dataType() throws RecognitionException {
        SilkLineParser.dataType_return retval = new SilkLineParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket27=null;
        Token RBracket29=null;
        SilkLineParser.dataTypeName_return dataTypeName28 = null;


        Object LBracket27_tree=null;
        Object RBracket29_tree=null;

        try {
            // SilkLine.g:299:9: ( LBracket dataTypeName RBracket )
            // SilkLine.g:299:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket27=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1089); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1092);
            dataTypeName28=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName28.getTree());
            RBracket29=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1094); 

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
    // $ANTLR end "dataType"

    public static class dataTypeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dataTypeName"
    // SilkLine.g:302:1: fragment dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkLineParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkLineParser.dataTypeName_return retval = new SilkLineParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine30=null;

        Object PlainOneLine30_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // SilkLine.g:303:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // SilkLine.g:303:15: PlainOneLine
            {
            PlainOneLine30=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1107);  
            stream_PlainOneLine.add(PlainOneLine30);



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
            // 304:2: -> DataType[$dataTypeName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(DataType, input.toString(retval.start,input.LT(-1))));

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
    // $ANTLR end "dataTypeName"

    public static class attributeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeList"
    // SilkLine.g:307:1: fragment attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkLineParser.attributeList_return attributeList() throws RecognitionException {
        SilkLineParser.attributeList_return retval = new SilkLineParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma32=null;
        SilkLineParser.attributeItem_return attributeItem31 = null;

        SilkLineParser.attributeItem_return attributeItem33 = null;


        Object Comma32_tree=null;

        try {
            // SilkLine.g:308:14: ( attributeItem ( Comma attributeItem )* )
            // SilkLine.g:308:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1127);
            attributeItem31=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem31.getTree());
            // SilkLine.g:308:30: ( Comma attributeItem )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // SilkLine.g:308:31: Comma attributeItem
            	    {
            	    Comma32=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1130); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1133);
            	    attributeItem33=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem33.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
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

    public static class attributeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeItem"
    // SilkLine.g:310:1: fragment attributeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkLineParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkLineParser.attributeItem_return retval = new SilkLineParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkLineParser.nodeItem_return nodeItem34 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // SilkLine.g:311:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // SilkLine.g:311:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1146);
            nodeItem34=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem34.getTree());


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
            // 311:25: -> ^( SilkNode nodeItem )
            {
                // SilkLine.g:311:28: ^( SilkNode nodeItem )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                adaptor.addChild(root_1, stream_nodeItem.nextTree());

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
    // $ANTLR end "attributeItem"

    public static class plural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plural"
    // SilkLine.g:314:1: fragment plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | EqEq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] | Seq Seq -> Occurrence[\"SEQUENCE_WITH_NEWLINE\"] );
    public final SilkLineParser.plural_return plural() throws RecognitionException {
        SilkLineParser.plural_return retval = new SilkLineParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star35=null;
        Token Plus36=null;
        Token Question37=null;
        Token EqEq38=null;
        Token Seq39=null;
        Token TabSeq40=null;
        Token Seq41=null;
        Token Seq42=null;

        Object Star35_tree=null;
        Object Plus36_tree=null;
        Object Question37_tree=null;
        Object EqEq38_tree=null;
        Object Seq39_tree=null;
        Object TabSeq40_tree=null;
        Object Seq41_tree=null;
        Object Seq42_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_EqEq=new RewriteRuleTokenStream(adaptor,"token EqEq");
        RewriteRuleTokenStream stream_TabSeq=new RewriteRuleTokenStream(adaptor,"token TabSeq");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");

        try {
            // SilkLine.g:316:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | EqEq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] | Seq Seq -> Occurrence[\"SEQUENCE_WITH_NEWLINE\"] )
            int alt14=7;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt14=1;
                }
                break;
            case Plus:
                {
                alt14=2;
                }
                break;
            case Question:
                {
                alt14=3;
                }
                break;
            case EqEq:
                {
                alt14=4;
                }
                break;
            case Seq:
                {
                int LA14_5 = input.LA(2);

                if ( (LA14_5==Seq) ) {
                    alt14=7;
                }
                else if ( (LA14_5==EOF||LA14_5==WhiteSpace||(LA14_5>=LineComment && LA14_5<=FunctionIndent)||(LA14_5>=RParen && LA14_5<=Colon)) ) {
                    alt14=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;
                }
                }
                break;
            case TabSeq:
                {
                alt14=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // SilkLine.g:316:4: Star
                    {
                    Star35=(Token)match(input,Star,FOLLOW_Star_in_plural1166);  
                    stream_Star.add(Star35);



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
                    // 316:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:317:4: Plus
                    {
                    Plus36=(Token)match(input,Plus,FOLLOW_Plus_in_plural1176);  
                    stream_Plus.add(Plus36);



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
                    // 317:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // SilkLine.g:318:4: Question
                    {
                    Question37=(Token)match(input,Question,FOLLOW_Question_in_plural1186);  
                    stream_Question.add(Question37);



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
                    // 318:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // SilkLine.g:319:4: EqEq
                    {
                    EqEq38=(Token)match(input,EqEq,FOLLOW_EqEq_in_plural1196);  
                    stream_EqEq.add(EqEq38);



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
                    // 319:9: -> Occurrence[\"MULTILINE_SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "MULTILINE_SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // SilkLine.g:320:4: Seq
                    {
                    Seq39=(Token)match(input,Seq,FOLLOW_Seq_in_plural1206);  
                    stream_Seq.add(Seq39);



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
                    // 320:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // SilkLine.g:321:4: TabSeq
                    {
                    TabSeq40=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1216);  
                    stream_TabSeq.add(TabSeq40);



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
                    // 321:11: -> Occurrence[\"TABBED_SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "TABBED_SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // SilkLine.g:322:4: Seq Seq
                    {
                    Seq41=(Token)match(input,Seq,FOLLOW_Seq_in_plural1226);  
                    stream_Seq.add(Seq41);

                    Seq42=(Token)match(input,Seq,FOLLOW_Seq_in_plural1228);  
                    stream_Seq.add(Seq42);



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
                    // 322:12: -> Occurrence[\"SEQUENCE_WITH_NEWLINE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE_WITH_NEWLINE"));

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
    // $ANTLR end "plural"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // SilkLine.g:325:1: function : ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) );
    public final SilkLineParser.function_return function() throws RecognitionException {
        SilkLineParser.function_return retval = new SilkLineParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent43=null;
        Token FunctionIndent45=null;
        Token PlainOneLine46=null;
        Token LParen47=null;
        Token Comma49=null;
        Token RParen51=null;
        SilkLineParser.function_i_return function_i44 = null;

        SilkLineParser.functionArg_return functionArg48 = null;

        SilkLineParser.functionArg_return functionArg50 = null;


        Object NodeIndent43_tree=null;
        Object FunctionIndent45_tree=null;
        Object PlainOneLine46_tree=null;
        Object LParen47_tree=null;
        Object Comma49_tree=null;
        Object RParen51_tree=null;
        RewriteRuleTokenStream stream_FunctionIndent=new RewriteRuleTokenStream(adaptor,"token FunctionIndent");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // SilkLine.g:326:2: ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NodeIndent) ) {
                alt17=1;
            }
            else if ( (LA17_0==FunctionIndent) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // SilkLine.g:326:4: NodeIndent function_i
                    {
                    NodeIndent43=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1247);  
                    stream_NodeIndent.add(NodeIndent43);

                    pushFollow(FOLLOW_function_i_in_function1249);
                    function_i44=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i44.getTree());


                    // AST REWRITE
                    // elements: NodeIndent, function_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 327:2: -> ^( Function NodeIndent function_i )
                    {
                        // SilkLine.g:327:5: ^( Function NodeIndent function_i )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, stream_NodeIndent.nextNode());
                        adaptor.addChild(root_1, stream_function_i.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:328:4: FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
                    {
                    FunctionIndent45=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1265);  
                    stream_FunctionIndent.add(FunctionIndent45);

                    PlainOneLine46=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1267);  
                    stream_PlainOneLine.add(PlainOneLine46);

                    LParen47=(Token)match(input,LParen,FOLLOW_LParen_in_function1269);  
                    stream_LParen.add(LParen47);

                    // SilkLine.g:328:39: ( functionArg ( Comma functionArg )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==At||LA16_0==String||LA16_0==PlainOneLine) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // SilkLine.g:328:40: functionArg ( Comma functionArg )*
                            {
                            pushFollow(FOLLOW_functionArg_in_function1272);
                            functionArg48=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg48.getTree());
                            // SilkLine.g:328:52: ( Comma functionArg )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==Comma) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // SilkLine.g:328:53: Comma functionArg
                            	    {
                            	    Comma49=(Token)match(input,Comma,FOLLOW_Comma_in_function1275);  
                            	    stream_Comma.add(Comma49);

                            	    pushFollow(FOLLOW_functionArg_in_function1277);
                            	    functionArg50=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg50.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen51=(Token)match(input,RParen,FOLLOW_RParen_in_function1283);  
                    stream_RParen.add(RParen51);



                    // AST REWRITE
                    // elements: functionArg
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 329:2: -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                    {
                        // SilkLine.g:329:5: ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent45!=null?FunctionIndent45.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine46!=null?PlainOneLine46.getText():null).trim()));
                        // SilkLine.g:329:81: ( functionArg )*
                        while ( stream_functionArg.hasNext() ) {
                            adaptor.addChild(root_1, stream_functionArg.nextTree());

                        }
                        stream_functionArg.reset();

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
    // $ANTLR end "function"

    public static class function_i_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_i"
    // SilkLine.g:332:1: fragment function_i : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* ;
    public final SilkLineParser.function_i_return function_i() throws RecognitionException {
        SilkLineParser.function_i_return retval = new SilkLineParser.function_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At52=null;
        Token PlainOneLine53=null;
        Token LParen54=null;
        Token Comma56=null;
        Token RParen58=null;
        SilkLineParser.functionArg_return functionArg55 = null;

        SilkLineParser.functionArg_return functionArg57 = null;


        Object At52_tree=null;
        Object PlainOneLine53_tree=null;
        Object LParen54_tree=null;
        Object Comma56_tree=null;
        Object RParen58_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // SilkLine.g:333:11: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* )
            // SilkLine.g:333:13: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At52=(Token)match(input,At,FOLLOW_At_in_function_i1310);  
            stream_At.add(At52);

            PlainOneLine53=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1312);  
            stream_PlainOneLine.add(PlainOneLine53);

            LParen54=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1314);  
            stream_LParen.add(LParen54);

            // SilkLine.g:333:36: ( functionArg ( Comma functionArg )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==At||LA19_0==String||LA19_0==PlainOneLine) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // SilkLine.g:333:37: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function_i1317);
                    functionArg55=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg55.getTree());
                    // SilkLine.g:333:49: ( Comma functionArg )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Comma) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // SilkLine.g:333:50: Comma functionArg
                    	    {
                    	    Comma56=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1320);  
                    	    stream_Comma.add(Comma56);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1322);
                    	    functionArg57=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen58=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1328);  
            stream_RParen.add(RParen58);



            // AST REWRITE
            // elements: functionArg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 334:2: -> Name[$PlainOneLine.text.trim()] ( functionArg )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine53!=null?PlainOneLine53.getText():null).trim()));
                // SilkLine.g:334:37: ( functionArg )*
                while ( stream_functionArg.hasNext() ) {
                    adaptor.addChild(root_0, stream_functionArg.nextTree());

                }
                stream_functionArg.reset();

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
    // $ANTLR end "function_i"

    public static class functionArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArg"
    // SilkLine.g:337:1: fragment functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) );
    public final SilkLineParser.functionArg_return functionArg() throws RecognitionException {
        SilkLineParser.functionArg_return retval = new SilkLineParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon61=null;
        SilkLineParser.nodeValue_return nodeValue59 = null;

        SilkLineParser.nodeName_return nodeName60 = null;

        SilkLineParser.nodeValue_return nodeValue62 = null;


        Object Colon61_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // SilkLine.g:339:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) )
            int alt20=2;
            switch ( input.LA(1) ) {
            case At:
                {
                alt20=1;
                }
                break;
            case PlainOneLine:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==Colon) ) {
                    alt20=2;
                }
                else if ( ((LA20_2>=RParen && LA20_2<=Comma)) ) {
                    alt20=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case String:
                {
                int LA20_3 = input.LA(2);

                if ( ((LA20_3>=RParen && LA20_3<=Comma)) ) {
                    alt20=1;
                }
                else if ( (LA20_3==Colon) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // SilkLine.g:339:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1350);
                    nodeValue59=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue59.getTree());


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
                    // 339:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:340:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1360);
                    nodeName60=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName60.getTree());
                    Colon61=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1362);  
                    stream_Colon.add(Colon61);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1364);
                    nodeValue62=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue62.getTree());


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
                    // 340:29: -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                    {
                        // SilkLine.g:340:32: ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName60!=null?input.toString(nodeName60.start,nodeName60.stop):null).trim()));
                        adaptor.addChild(root_1, (Object)adaptor.create(Value, (nodeValue62!=null?input.toString(nodeValue62.start,nodeValue62.stop):null).trim()));

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
    // $ANTLR end "functionArg"

    // Delegated rules


 

    public static final BitSet FOLLOW_silkLine_in_silkFile863 = new BitSet(new long[]{0x00000000000E8002L});
    public static final BitSet FOLLOW_silkNode_in_silkLine884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineComment_in_silkLine890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkNode963 = new BitSet(new long[]{0x0008020000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkNode965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkNode980 = new BitSet(new long[]{0x000000025F200002L});
    public static final BitSet FOLLOW_LParen_in_silkNode983 = new BitSet(new long[]{0x0008020000000000L});
    public static final BitSet FOLLOW_attributeList_in_silkNode985 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_silkNode987 = new BitSet(new long[]{0x000000025F000002L});
    public static final BitSet FOLLOW_plural_in_silkNode991 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_silkNode995 = new BitSet(new long[]{0x0008020020000000L});
    public static final BitSet FOLLOW_nodeValue_in_silkNode997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkNode1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1035 = new BitSet(new long[]{0x00000002DF200002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1037 = new BitSet(new long[]{0x000000025F200002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1042 = new BitSet(new long[]{0x0008020000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1044 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1046 = new BitSet(new long[]{0x000000025F000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1050 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1054 = new BitSet(new long[]{0x0008020020000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1089 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1092 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1127 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1130 = new BitSet(new long[]{0x0008020000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1133 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqEq_in_plural1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1226 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Seq_in_plural1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1247 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_function_i_in_function1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1265 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1267 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function1269 = new BitSet(new long[]{0x0008020020400000L});
    public static final BitSet FOLLOW_functionArg_in_function1272 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function1275 = new BitSet(new long[]{0x0008020020000000L});
    public static final BitSet FOLLOW_functionArg_in_function1277 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1310 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1312 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function_i1314 = new BitSet(new long[]{0x0008020020400000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1317 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function_i1320 = new BitSet(new long[]{0x0008020020000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1322 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function_i1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1360 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1362 = new BitSet(new long[]{0x0008020020000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1364 = new BitSet(new long[]{0x0000000000000002L});

}
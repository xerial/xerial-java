// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 SilkLine.g 2010-07-08 14:56:52

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "WhiteSpace", "LineBreakChar", "LineComment", "BlockIndent", "NodeIndent", "PullUpNodeIndent", "FunctionIndent", "BlankLine", "LParen", "RParen", "Comma", "Colon", "Seq", "TabSeq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "ScopeIndicator", "FlowIndicator", "Indicator", "PlainUnsafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "NonSpaceChar", "PlainFirst", "PlainOneLine", "JSON", "Separation"
    };
    public static final int Key=14;
    public static final int DataType=10;
    public static final int LineComment=17;
    public static final int RBracket=33;
    public static final int NodeIndent=19;
    public static final int EOF=-1;
    public static final int PlainSafeIn=48;
    public static final int HexDigit=37;
    public static final int Occurrence=9;
    public static final int PullUpNodeIndent=20;
    public static final int Indicator=45;
    public static final int Value=8;
    public static final int Silk=4;
    public static final int PlainOneLine=52;
    public static final int NonSpaceChar=50;
    public static final int KeyValuePair=13;
    public static final int Argument=12;
    public static final int WhiteSpace=15;
    public static final int String=42;
    public static final int BlockIndent=18;
    public static final int LBracket=32;
    public static final int RParen=24;
    public static final int PlainSafeOut=49;
    public static final int At=30;
    public static final int LParen=23;
    public static final int PlainSafeKey=47;
    public static final int PlainUnsafeChar=46;
    public static final int TabSeq=28;
    public static final int BlankLine=22;
    public static final int StringChar_s=41;
    public static final int Colon=26;
    public static final int UnicodeChar=38;
    public static final int Question=34;
    public static final int Digit=35;
    public static final int FunctionIndent=21;
    public static final int PlainFirst=51;
    public static final int Separation=54;
    public static final int Seq=27;
    public static final int Plus=31;
    public static final int JSON=53;
    public static final int LineBreakChar=16;
    public static final int Function=11;
    public static final int ScopeIndicator=43;
    public static final int Name=7;
    public static final int StringChar=40;
    public static final int FlowIndicator=44;
    public static final int Star=29;
    public static final int SilkLine=6;
    public static final int Comma=25;
    public static final int Letter=36;
    public static final int EscapeSequence=39;
    public static final int SilkNode=5;

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
    // SilkLine.g:232:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkLineParser.silkFile_return silkFile() throws RecognitionException {
        SilkLineParser.silkFile_return retval = new SilkLineParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkLineParser.silkLine_return silkLine1 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // SilkLine.g:232:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // SilkLine.g:232:11: ( silkLine )*
            {
            // SilkLine.g:232:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WhiteSpace||(LA1_0>=LineComment && LA1_0<=FunctionIndent)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SilkLine.g:232:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile870);
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
            // 232:21: -> ^( Silk ( silkLine )* )
            {
                // SilkLine.g:232:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // SilkLine.g:232:31: ( silkLine )*
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
    // SilkLine.g:235:1: silkLine : ( silkNode | LineComment | WhiteSpace -> BlankLine );
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
            // SilkLine.g:236:2: ( silkNode | LineComment | WhiteSpace -> BlankLine )
            int alt2=3;
            switch ( input.LA(1) ) {
            case BlockIndent:
            case NodeIndent:
            case PullUpNodeIndent:
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
                    // SilkLine.g:236:4: silkNode
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_silkNode_in_silkLine891);
                    silkNode2=silkNode();

                    state._fsp--;

                    adaptor.addChild(root_0, silkNode2.getTree());

                    }
                    break;
                case 2 :
                    // SilkLine.g:237:4: LineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    LineComment3=(Token)match(input,LineComment,FOLLOW_LineComment_in_silkLine897); 
                    LineComment3_tree = (Object)adaptor.create(LineComment3);
                    adaptor.addChild(root_0, LineComment3_tree);


                    }
                    break;
                case 3 :
                    // SilkLine.g:238:4: WhiteSpace
                    {
                    WhiteSpace4=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine902);  
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
                    // 238:15: -> BlankLine
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
    // SilkLine.g:241:1: fragment nodeName : ( PlainOneLine | String );
    public final SilkLineParser.nodeName_return nodeName() throws RecognitionException {
        SilkLineParser.nodeName_return retval = new SilkLineParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set5=null;

        Object set5_tree=null;

        try {
            // SilkLine.g:242:9: ( PlainOneLine | String )
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
    // SilkLine.g:244:1: fragment nodeValue : ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON );
    public final SilkLineParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkLineParser.nodeValue_return retval = new SilkLineParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine7=null;
        Token String8=null;
        Token JSON9=null;
        SilkLineParser.function_i_return function_i6 = null;


        Object PlainOneLine7_tree=null;
        Object String8_tree=null;
        Object JSON9_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // SilkLine.g:246:2: ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON )
            int alt4=3;
            switch ( input.LA(1) ) {
            case At:
                {
                alt4=1;
                }
                break;
            case String:
            case PlainOneLine:
                {
                alt4=2;
                }
                break;
            case JSON:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // SilkLine.g:246:4: function_i
                    {
                    pushFollow(FOLLOW_function_i_in_nodeValue932);
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
                    // 246:15: -> ^( Function function_i )
                    {
                        // SilkLine.g:246:18: ^( Function function_i )
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
                    // SilkLine.g:247:4: ( PlainOneLine | String )
                    {
                    // SilkLine.g:247:4: ( PlainOneLine | String )
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
                            // SilkLine.g:247:5: PlainOneLine
                            {
                            PlainOneLine7=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue946);  
                            stream_PlainOneLine.add(PlainOneLine7);


                            }
                            break;
                        case 2 :
                            // SilkLine.g:247:20: String
                            {
                            String8=(Token)match(input,String,FOLLOW_String_in_nodeValue950);  
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
                    // 247:28: -> Value[$nodeValue.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // SilkLine.g:248:4: JSON
                    {
                    root_0 = (Object)adaptor.nil();

                    JSON9=(Token)match(input,JSON,FOLLOW_JSON_in_nodeValue961); 
                    JSON9_tree = (Object)adaptor.create(JSON9);
                    adaptor.addChild(root_0, JSON9_tree);


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
    // SilkLine.g:252:1: silkNode : ( indent nodeItem -> ^( SilkNode indent nodeItem ) | indent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode indent ( attributeList )? ( plural )? ( nodeValue )? ) | function );
    public final SilkLineParser.silkNode_return silkNode() throws RecognitionException {
        SilkLineParser.silkNode_return retval = new SilkLineParser.silkNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen13=null;
        Token RParen15=null;
        Token Colon17=null;
        SilkLineParser.indent_return indent10 = null;

        SilkLineParser.nodeItem_return nodeItem11 = null;

        SilkLineParser.indent_return indent12 = null;

        SilkLineParser.attributeList_return attributeList14 = null;

        SilkLineParser.plural_return plural16 = null;

        SilkLineParser.nodeValue_return nodeValue18 = null;

        SilkLineParser.function_return function19 = null;


        Object LParen13_tree=null;
        Object RParen15_tree=null;
        Object Colon17_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_indent=new RewriteRuleSubtreeStream(adaptor,"rule indent");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // SilkLine.g:253:2: ( indent nodeItem -> ^( SilkNode indent nodeItem ) | indent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode indent ( attributeList )? ( plural )? ( nodeValue )? ) | function )
            int alt8=3;
            switch ( input.LA(1) ) {
            case NodeIndent:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case WhiteSpace:
                case LineComment:
                case BlockIndent:
                case NodeIndent:
                case PullUpNodeIndent:
                case FunctionIndent:
                case LParen:
                case Colon:
                case Seq:
                case TabSeq:
                case Star:
                case Plus:
                case Question:
                    {
                    alt8=2;
                    }
                    break;
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
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

                }
                break;
            case BlockIndent:
            case PullUpNodeIndent:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==EOF||LA8_2==WhiteSpace||(LA8_2>=LineComment && LA8_2<=FunctionIndent)||LA8_2==LParen||(LA8_2>=Colon && LA8_2<=Star)||LA8_2==Plus||LA8_2==Question) ) {
                    alt8=2;
                }
                else if ( (LA8_2==String||LA8_2==PlainOneLine) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case FunctionIndent:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // SilkLine.g:253:4: indent nodeItem
                    {
                    pushFollow(FOLLOW_indent_in_silkNode975);
                    indent10=indent();

                    state._fsp--;

                    stream_indent.add(indent10.getTree());
                    pushFollow(FOLLOW_nodeItem_in_silkNode977);
                    nodeItem11=nodeItem();

                    state._fsp--;

                    stream_nodeItem.add(nodeItem11.getTree());


                    // AST REWRITE
                    // elements: indent, nodeItem
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 253:20: -> ^( SilkNode indent nodeItem )
                    {
                        // SilkLine.g:253:23: ^( SilkNode indent nodeItem )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                        adaptor.addChild(root_1, stream_indent.nextTree());
                        adaptor.addChild(root_1, stream_nodeItem.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:254:4: indent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
                    {
                    pushFollow(FOLLOW_indent_in_silkNode992);
                    indent12=indent();

                    state._fsp--;

                    stream_indent.add(indent12.getTree());
                    // SilkLine.g:254:11: ( LParen attributeList RParen )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==LParen) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // SilkLine.g:254:12: LParen attributeList RParen
                            {
                            LParen13=(Token)match(input,LParen,FOLLOW_LParen_in_silkNode995);  
                            stream_LParen.add(LParen13);

                            pushFollow(FOLLOW_attributeList_in_silkNode997);
                            attributeList14=attributeList();

                            state._fsp--;

                            stream_attributeList.add(attributeList14.getTree());
                            RParen15=(Token)match(input,RParen,FOLLOW_RParen_in_silkNode999);  
                            stream_RParen.add(RParen15);


                            }
                            break;

                    }

                    // SilkLine.g:254:42: ( plural )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=Seq && LA6_0<=Star)||LA6_0==Plus||LA6_0==Question) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // SilkLine.g:254:42: plural
                            {
                            pushFollow(FOLLOW_plural_in_silkNode1003);
                            plural16=plural();

                            state._fsp--;

                            stream_plural.add(plural16.getTree());

                            }
                            break;

                    }

                    // SilkLine.g:254:50: ( Colon nodeValue )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==Colon) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // SilkLine.g:254:51: Colon nodeValue
                            {
                            Colon17=(Token)match(input,Colon,FOLLOW_Colon_in_silkNode1007);  
                            stream_Colon.add(Colon17);

                            pushFollow(FOLLOW_nodeValue_in_silkNode1009);
                            nodeValue18=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue18.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: attributeList, nodeValue, plural, indent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 255:2: -> ^( SilkNode indent ( attributeList )? ( plural )? ( nodeValue )? )
                    {
                        // SilkLine.g:255:5: ^( SilkNode indent ( attributeList )? ( plural )? ( nodeValue )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                        adaptor.addChild(root_1, stream_indent.nextTree());
                        // SilkLine.g:255:23: ( attributeList )?
                        if ( stream_attributeList.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeList.nextTree());

                        }
                        stream_attributeList.reset();
                        // SilkLine.g:255:38: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();
                        // SilkLine.g:255:46: ( nodeValue )?
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
                    // SilkLine.g:256:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkNode1034);
                    function19=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function19.getTree());

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

    public static class indent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indent"
    // SilkLine.g:259:1: indent : ( NodeIndent | BlockIndent | PullUpNodeIndent );
    public final SilkLineParser.indent_return indent() throws RecognitionException {
        SilkLineParser.indent_return retval = new SilkLineParser.indent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set20=null;

        Object set20_tree=null;

        try {
            // SilkLine.g:260:3: ( NodeIndent | BlockIndent | PullUpNodeIndent )
            // SilkLine.g:
            {
            root_0 = (Object)adaptor.nil();

            set20=(Token)input.LT(1);
            if ( (input.LA(1)>=BlockIndent && input.LA(1)<=PullUpNodeIndent) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set20));
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
    // $ANTLR end "indent"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // SilkLine.g:265:1: fragment nodeItem : nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? ;
    public final SilkLineParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkLineParser.nodeItem_return retval = new SilkLineParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen23=null;
        Token RParen25=null;
        Token Colon27=null;
        SilkLineParser.nodeName_return nodeName21 = null;

        SilkLineParser.dataType_return dataType22 = null;

        SilkLineParser.attributeList_return attributeList24 = null;

        SilkLineParser.plural_return plural26 = null;

        SilkLineParser.nodeValue_return nodeValue28 = null;


        Object LParen23_tree=null;
        Object RParen25_tree=null;
        Object Colon27_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // SilkLine.g:266:9: ( nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? )
            // SilkLine.g:266:11: nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1073);
            nodeName21=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName21.getTree());
            // SilkLine.g:266:20: ( dataType )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LBracket) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // SilkLine.g:266:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1075);
                    dataType22=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType22.getTree());

                    }
                    break;

            }

            // SilkLine.g:266:31: ( LParen attributeList RParen )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LParen) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // SilkLine.g:266:32: LParen attributeList RParen
                    {
                    LParen23=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1080);  
                    stream_LParen.add(LParen23);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1082);
                    attributeList24=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList24.getTree());
                    RParen25=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1084);  
                    stream_RParen.add(RParen25);


                    }
                    break;

            }

            // SilkLine.g:266:62: ( plural )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=Seq && LA11_0<=Star)||LA11_0==Plus||LA11_0==Question) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // SilkLine.g:266:62: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1088);
                    plural26=plural();

                    state._fsp--;

                    stream_plural.add(plural26.getTree());

                    }
                    break;

            }

            // SilkLine.g:266:70: ( Colon nodeValue )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // SilkLine.g:266:71: Colon nodeValue
                    {
                    Colon27=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1092);  
                    stream_Colon.add(Colon27);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1094);
                    nodeValue28=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue28.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: nodeValue, plural, attributeList, dataType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 267:2: -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName21!=null?input.toString(nodeName21.start,nodeName21.stop):null).trim()));
                // SilkLine.g:267:33: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // SilkLine.g:267:43: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();
                // SilkLine.g:267:58: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // SilkLine.g:267:66: ( nodeValue )?
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
    // SilkLine.g:270:1: fragment dataType : LBracket dataTypeName RBracket ;
    public final SilkLineParser.dataType_return dataType() throws RecognitionException {
        SilkLineParser.dataType_return retval = new SilkLineParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket29=null;
        Token RBracket31=null;
        SilkLineParser.dataTypeName_return dataTypeName30 = null;


        Object LBracket29_tree=null;
        Object RBracket31_tree=null;

        try {
            // SilkLine.g:271:9: ( LBracket dataTypeName RBracket )
            // SilkLine.g:271:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket29=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1127); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1130);
            dataTypeName30=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName30.getTree());
            RBracket31=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1132); 

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
    // SilkLine.g:274:1: fragment dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkLineParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkLineParser.dataTypeName_return retval = new SilkLineParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine32=null;

        Object PlainOneLine32_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // SilkLine.g:275:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // SilkLine.g:275:15: PlainOneLine
            {
            PlainOneLine32=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1145);  
            stream_PlainOneLine.add(PlainOneLine32);



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
            // 276:2: -> DataType[$dataTypeName.text]
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
    // SilkLine.g:279:1: fragment attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkLineParser.attributeList_return attributeList() throws RecognitionException {
        SilkLineParser.attributeList_return retval = new SilkLineParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma34=null;
        SilkLineParser.attributeItem_return attributeItem33 = null;

        SilkLineParser.attributeItem_return attributeItem35 = null;


        Object Comma34_tree=null;

        try {
            // SilkLine.g:280:14: ( attributeItem ( Comma attributeItem )* )
            // SilkLine.g:280:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1165);
            attributeItem33=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem33.getTree());
            // SilkLine.g:280:30: ( Comma attributeItem )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // SilkLine.g:280:31: Comma attributeItem
            	    {
            	    Comma34=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1168); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1171);
            	    attributeItem35=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem35.getTree());

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
    // SilkLine.g:282:1: fragment attributeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkLineParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkLineParser.attributeItem_return retval = new SilkLineParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkLineParser.nodeItem_return nodeItem36 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // SilkLine.g:283:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // SilkLine.g:283:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1184);
            nodeItem36=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem36.getTree());


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
            // 283:25: -> ^( SilkNode nodeItem )
            {
                // SilkLine.g:283:28: ^( SilkNode nodeItem )
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
    // SilkLine.g:286:1: fragment plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] );
    public final SilkLineParser.plural_return plural() throws RecognitionException {
        SilkLineParser.plural_return retval = new SilkLineParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star37=null;
        Token Plus38=null;
        Token Question39=null;
        Token Seq40=null;
        Token TabSeq41=null;

        Object Star37_tree=null;
        Object Plus38_tree=null;
        Object Question39_tree=null;
        Object Seq40_tree=null;
        Object TabSeq41_tree=null;
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_TabSeq=new RewriteRuleTokenStream(adaptor,"token TabSeq");

        try {
            // SilkLine.g:288:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] )
            int alt14=5;
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
            case Seq:
                {
                alt14=4;
                }
                break;
            case TabSeq:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // SilkLine.g:288:4: Star
                    {
                    Star37=(Token)match(input,Star,FOLLOW_Star_in_plural1204);  
                    stream_Star.add(Star37);



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
                    // 288:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:289:4: Plus
                    {
                    Plus38=(Token)match(input,Plus,FOLLOW_Plus_in_plural1214);  
                    stream_Plus.add(Plus38);



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
                    // 289:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // SilkLine.g:290:4: Question
                    {
                    Question39=(Token)match(input,Question,FOLLOW_Question_in_plural1224);  
                    stream_Question.add(Question39);



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
                    // 290:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // SilkLine.g:291:4: Seq
                    {
                    Seq40=(Token)match(input,Seq,FOLLOW_Seq_in_plural1234);  
                    stream_Seq.add(Seq40);



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
                    // 291:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // SilkLine.g:292:4: TabSeq
                    {
                    TabSeq41=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1244);  
                    stream_TabSeq.add(TabSeq41);



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
                    // 292:11: -> Occurrence[\"TABBED_SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "TABBED_SEQUENCE"));

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
    // SilkLine.g:295:1: function : ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) );
    public final SilkLineParser.function_return function() throws RecognitionException {
        SilkLineParser.function_return retval = new SilkLineParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent42=null;
        Token FunctionIndent44=null;
        Token PlainOneLine45=null;
        Token LParen46=null;
        Token Comma48=null;
        Token RParen50=null;
        SilkLineParser.function_i_return function_i43 = null;

        SilkLineParser.functionArg_return functionArg47 = null;

        SilkLineParser.functionArg_return functionArg49 = null;


        Object NodeIndent42_tree=null;
        Object FunctionIndent44_tree=null;
        Object PlainOneLine45_tree=null;
        Object LParen46_tree=null;
        Object Comma48_tree=null;
        Object RParen50_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_FunctionIndent=new RewriteRuleTokenStream(adaptor,"token FunctionIndent");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // SilkLine.g:296:2: ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) )
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
                    // SilkLine.g:296:4: NodeIndent function_i
                    {
                    NodeIndent42=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1263);  
                    stream_NodeIndent.add(NodeIndent42);

                    pushFollow(FOLLOW_function_i_in_function1265);
                    function_i43=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i43.getTree());


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
                    // 297:2: -> ^( Function NodeIndent function_i )
                    {
                        // SilkLine.g:297:5: ^( Function NodeIndent function_i )
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
                    // SilkLine.g:298:4: FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
                    {
                    FunctionIndent44=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1281);  
                    stream_FunctionIndent.add(FunctionIndent44);

                    PlainOneLine45=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1283);  
                    stream_PlainOneLine.add(PlainOneLine45);

                    LParen46=(Token)match(input,LParen,FOLLOW_LParen_in_function1285);  
                    stream_LParen.add(LParen46);

                    // SilkLine.g:298:39: ( functionArg ( Comma functionArg )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==At||LA16_0==String||(LA16_0>=PlainOneLine && LA16_0<=JSON)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // SilkLine.g:298:40: functionArg ( Comma functionArg )*
                            {
                            pushFollow(FOLLOW_functionArg_in_function1288);
                            functionArg47=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg47.getTree());
                            // SilkLine.g:298:52: ( Comma functionArg )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==Comma) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // SilkLine.g:298:53: Comma functionArg
                            	    {
                            	    Comma48=(Token)match(input,Comma,FOLLOW_Comma_in_function1291);  
                            	    stream_Comma.add(Comma48);

                            	    pushFollow(FOLLOW_functionArg_in_function1293);
                            	    functionArg49=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg49.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen50=(Token)match(input,RParen,FOLLOW_RParen_in_function1299);  
                    stream_RParen.add(RParen50);



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
                    // 299:2: -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                    {
                        // SilkLine.g:299:5: ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent44!=null?FunctionIndent44.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine45!=null?PlainOneLine45.getText():null).trim()));
                        // SilkLine.g:299:81: ( functionArg )*
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
    // SilkLine.g:302:1: fragment function_i : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* ;
    public final SilkLineParser.function_i_return function_i() throws RecognitionException {
        SilkLineParser.function_i_return retval = new SilkLineParser.function_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At51=null;
        Token PlainOneLine52=null;
        Token LParen53=null;
        Token Comma55=null;
        Token RParen57=null;
        SilkLineParser.functionArg_return functionArg54 = null;

        SilkLineParser.functionArg_return functionArg56 = null;


        Object At51_tree=null;
        Object PlainOneLine52_tree=null;
        Object LParen53_tree=null;
        Object Comma55_tree=null;
        Object RParen57_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // SilkLine.g:303:11: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* )
            // SilkLine.g:303:13: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At51=(Token)match(input,At,FOLLOW_At_in_function_i1326);  
            stream_At.add(At51);

            PlainOneLine52=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1328);  
            stream_PlainOneLine.add(PlainOneLine52);

            LParen53=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1330);  
            stream_LParen.add(LParen53);

            // SilkLine.g:303:36: ( functionArg ( Comma functionArg )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==At||LA19_0==String||(LA19_0>=PlainOneLine && LA19_0<=JSON)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // SilkLine.g:303:37: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function_i1333);
                    functionArg54=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg54.getTree());
                    // SilkLine.g:303:49: ( Comma functionArg )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Comma) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // SilkLine.g:303:50: Comma functionArg
                    	    {
                    	    Comma55=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1336);  
                    	    stream_Comma.add(Comma55);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1338);
                    	    functionArg56=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg56.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen57=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1344);  
            stream_RParen.add(RParen57);



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
            // 304:2: -> Name[$PlainOneLine.text.trim()] ( functionArg )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine52!=null?PlainOneLine52.getText():null).trim()));
                // SilkLine.g:304:37: ( functionArg )*
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
    // SilkLine.g:307:1: fragment functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) );
    public final SilkLineParser.functionArg_return functionArg() throws RecognitionException {
        SilkLineParser.functionArg_return retval = new SilkLineParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon60=null;
        SilkLineParser.nodeValue_return nodeValue58 = null;

        SilkLineParser.nodeName_return nodeName59 = null;

        SilkLineParser.nodeValue_return nodeValue61 = null;


        Object Colon60_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // SilkLine.g:309:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) )
            int alt20=2;
            switch ( input.LA(1) ) {
            case At:
            case JSON:
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

                if ( (LA20_3==Colon) ) {
                    alt20=2;
                }
                else if ( ((LA20_3>=RParen && LA20_3<=Comma)) ) {
                    alt20=1;
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
                    // SilkLine.g:309:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1366);
                    nodeValue58=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue58.getTree());


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
                    // 309:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // SilkLine.g:310:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1376);
                    nodeName59=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName59.getTree());
                    Colon60=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1378);  
                    stream_Colon.add(Colon60);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1380);
                    nodeValue61=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue61.getTree());


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
                    // 310:29: -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                    {
                        // SilkLine.g:310:32: ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName59!=null?input.toString(nodeName59.start,nodeName59.stop):null).trim()));
                        adaptor.addChild(root_1, (Object)adaptor.create(Value, (nodeValue61!=null?input.toString(nodeValue61.start,nodeValue61.stop):null).trim()));

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


 

    public static final BitSet FOLLOW_silkLine_in_silkFile870 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_silkNode_in_silkLine891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineComment_in_silkLine897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_in_nodeValue961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indent_in_silkNode975 = new BitSet(new long[]{0x0010040000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkNode977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indent_in_silkNode992 = new BitSet(new long[]{0x00000004BC800002L});
    public static final BitSet FOLLOW_LParen_in_silkNode995 = new BitSet(new long[]{0x0010040000000000L});
    public static final BitSet FOLLOW_attributeList_in_silkNode997 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RParen_in_silkNode999 = new BitSet(new long[]{0x00000004BC000002L});
    public static final BitSet FOLLOW_plural_in_silkNode1003 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Colon_in_silkNode1007 = new BitSet(new long[]{0x0030040040000000L});
    public static final BitSet FOLLOW_nodeValue_in_silkNode1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkNode1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_indent0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1073 = new BitSet(new long[]{0x00000005BC800002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1075 = new BitSet(new long[]{0x00000004BC800002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1080 = new BitSet(new long[]{0x0010040000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1082 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1084 = new BitSet(new long[]{0x00000004BC000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1088 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1092 = new BitSet(new long[]{0x0030040040000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1127 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1130 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1165 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1168 = new BitSet(new long[]{0x0010040000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1171 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1263 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_function_i_in_function1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1281 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1283 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LParen_in_function1285 = new BitSet(new long[]{0x0030040041000000L});
    public static final BitSet FOLLOW_functionArg_in_function1288 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_Comma_in_function1291 = new BitSet(new long[]{0x0030040040000000L});
    public static final BitSet FOLLOW_functionArg_in_function1293 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RParen_in_function1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1326 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1328 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LParen_in_function_i1330 = new BitSet(new long[]{0x0030040041000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1333 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_Comma_in_function_i1336 = new BitSet(new long[]{0x0030040040000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1338 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RParen_in_function_i1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1376 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1378 = new BitSet(new long[]{0x0030040040000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1380 = new BitSet(new long[]{0x0000000000000002L});

}
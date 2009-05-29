// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-05-29 11:54:59

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

public class SilkParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "WhiteSpace", "LineBreakChar", "LineComment", "NodeIndent", "FunctionIndent", "BlankLine", "LParen", "RParen", "Comma", "Colon", "Seq", "TabSeq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "ScopeIndicator", "FlowIndicator", "Indicator", "PlainUnsafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "NonSpaceChar", "PlainFirst", "PlainOneLine", "JSON", "Separation"
    };
    public static final int Key=14;
    public static final int PlainUnsafeChar=44;
    public static final int PlainSafeKey=45;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=30;
    public static final int NodeIndent=18;
    public static final int Digit=33;
    public static final int HexDigit=35;
    public static final int PlainOneLine=50;
    public static final int Plus=29;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Separation=52;
    public static final int FlowIndicator=42;
    public static final int Letter=34;
    public static final int PlainSafeIn=46;
    public static final int Comma=23;
    public static final int TabSeq=26;
    public static final int NonSpaceChar=48;
    public static final int EscapeSequence=37;
    public static final int PlainFirst=49;
    public static final int WhiteSpace=15;
    public static final int PlainSafeOut=47;
    public static final int JSON=51;
    public static final int Question=32;
    public static final int LineComment=17;
    public static final int Colon=24;
    public static final int At=28;
    public static final int KeyValuePair=13;
    public static final int Star=27;
    public static final int Seq=25;
    public static final int FunctionIndent=19;
    public static final int RParen=22;
    public static final int Indicator=43;
    public static final int UnicodeChar=36;
    public static final int Silk=4;
    public static final int BlankLine=20;
    public static final int StringChar=38;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=21;
    public static final int String=40;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=41;
    public static final int EOF=-1;
    public static final int StringChar_s=39;
    public static final int Value=8;
    public static final int RBracket=31;

    // delegates
    // delegators


        public SilkParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SilkParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SilkParser.tokenNames; }
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }


    public static class silkFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkFile"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine1 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: ( silkLine )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WhiteSpace||(LA1_0>=LineComment && LA1_0<=FunctionIndent)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile856);
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
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 266:21: -> ^( Silk ( silkLine )* )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:31: ( silkLine )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:1: silkLine : ( silkNode | LineComment | WhiteSpace -> BlankLine );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LineComment3=null;
        Token WhiteSpace4=null;
        SilkParser.silkNode_return silkNode2 = null;


        Object LineComment3_tree=null;
        Object WhiteSpace4_tree=null;
        RewriteRuleTokenStream stream_WhiteSpace=new RewriteRuleTokenStream(adaptor,"token WhiteSpace");

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:2: ( silkNode | LineComment | WhiteSpace -> BlankLine )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:4: silkNode
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_silkNode_in_silkLine877);
                    silkNode2=silkNode();

                    state._fsp--;

                    adaptor.addChild(root_0, silkNode2.getTree());

                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:4: LineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    LineComment3=(Token)match(input,LineComment,FOLLOW_LineComment_in_silkLine883); 
                    LineComment3_tree = (Object)adaptor.create(LineComment3);
                    adaptor.addChild(root_0, LineComment3_tree);


                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:4: WhiteSpace
                    {
                    WhiteSpace4=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine888);  
                    stream_WhiteSpace.add(WhiteSpace4);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:1: fragment nodeName : ( PlainOneLine | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set5=null;

        Object set5_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:9: ( PlainOneLine | String )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:1: fragment nodeValue : ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON );
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine7=null;
        Token String8=null;
        Token JSON9=null;
        SilkParser.function_i_return function_i6 = null;


        Object PlainOneLine7_tree=null;
        Object String8_tree=null;
        Object JSON9_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:280:2: ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:280:4: function_i
                    {
                    pushFollow(FOLLOW_function_i_in_nodeValue918);
                    function_i6=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i6.getTree());


                    // AST REWRITE
                    // elements: function_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 280:15: -> ^( Function function_i )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:280:18: ^( Function function_i )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:4: ( PlainOneLine | String )
                    {
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:4: ( PlainOneLine | String )
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
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:5: PlainOneLine
                            {
                            PlainOneLine7=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue932);  
                            stream_PlainOneLine.add(PlainOneLine7);


                            }
                            break;
                        case 2 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:20: String
                            {
                            String8=(Token)match(input,String,FOLLOW_String_in_nodeValue936);  
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
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 281:28: -> Value[$nodeValue.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:4: JSON
                    {
                    root_0 = (Object)adaptor.nil();

                    JSON9=(Token)match(input,JSON,FOLLOW_JSON_in_nodeValue947); 
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:286:1: silkNode : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) | function );
    public final SilkParser.silkNode_return silkNode() throws RecognitionException {
        SilkParser.silkNode_return retval = new SilkParser.silkNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent10=null;
        Token NodeIndent12=null;
        Token LParen13=null;
        Token RParen15=null;
        Token Colon17=null;
        SilkParser.nodeItem_return nodeItem11 = null;

        SilkParser.attributeList_return attributeList14 = null;

        SilkParser.plural_return plural16 = null;

        SilkParser.nodeValue_return nodeValue18 = null;

        SilkParser.function_return function19 = null;


        Object NodeIndent10_tree=null;
        Object NodeIndent12_tree=null;
        Object LParen13_tree=null;
        Object RParen15_tree=null;
        Object Colon17_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:2: ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) | function )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NodeIndent) ) {
                switch ( input.LA(2) ) {
                case EOF:
                case WhiteSpace:
                case LineComment:
                case NodeIndent:
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
                case String:
                case PlainOneLine:
                    {
                    alt8=1;
                    }
                    break;
                case At:
                    {
                    alt8=3;
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:4: NodeIndent nodeItem
                    {
                    NodeIndent10=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkNode961);  
                    stream_NodeIndent.add(NodeIndent10);

                    pushFollow(FOLLOW_nodeItem_in_silkNode963);
                    nodeItem11=nodeItem();

                    state._fsp--;

                    stream_nodeItem.add(nodeItem11.getTree());


                    // AST REWRITE
                    // elements: nodeItem, NodeIndent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 287:24: -> ^( SilkNode NodeIndent nodeItem )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:27: ^( SilkNode NodeIndent nodeItem )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:4: NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
                    {
                    NodeIndent12=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkNode978);  
                    stream_NodeIndent.add(NodeIndent12);

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:15: ( LParen attributeList RParen )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==LParen) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:16: LParen attributeList RParen
                            {
                            LParen13=(Token)match(input,LParen,FOLLOW_LParen_in_silkNode981);  
                            stream_LParen.add(LParen13);

                            pushFollow(FOLLOW_attributeList_in_silkNode983);
                            attributeList14=attributeList();

                            state._fsp--;

                            stream_attributeList.add(attributeList14.getTree());
                            RParen15=(Token)match(input,RParen,FOLLOW_RParen_in_silkNode985);  
                            stream_RParen.add(RParen15);


                            }
                            break;

                    }

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:46: ( plural )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=Seq && LA6_0<=Star)||LA6_0==Plus||LA6_0==Question) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:46: plural
                            {
                            pushFollow(FOLLOW_plural_in_silkNode989);
                            plural16=plural();

                            state._fsp--;

                            stream_plural.add(plural16.getTree());

                            }
                            break;

                    }

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:54: ( Colon nodeValue )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==Colon) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:55: Colon nodeValue
                            {
                            Colon17=(Token)match(input,Colon,FOLLOW_Colon_in_silkNode993);  
                            stream_Colon.add(Colon17);

                            pushFollow(FOLLOW_nodeValue_in_silkNode995);
                            nodeValue18=nodeValue();

                            state._fsp--;

                            stream_nodeValue.add(nodeValue18.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: attributeList, plural, nodeValue, NodeIndent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 289:2: -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:5: ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                        adaptor.addChild(root_1, stream_NodeIndent.nextNode());
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:27: ( attributeList )?
                        if ( stream_attributeList.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeList.nextTree());

                        }
                        stream_attributeList.reset();
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:42: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:50: ( nodeValue )?
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:290:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkNode1020);
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

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:1: fragment nodeItem : nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen22=null;
        Token RParen24=null;
        Token Colon26=null;
        SilkParser.nodeName_return nodeName20 = null;

        SilkParser.dataType_return dataType21 = null;

        SilkParser.attributeList_return attributeList23 = null;

        SilkParser.plural_return plural25 = null;

        SilkParser.nodeValue_return nodeValue27 = null;


        Object LParen22_tree=null;
        Object RParen24_tree=null;
        Object Colon26_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:9: ( nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:11: nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1033);
            nodeName20=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName20.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:20: ( dataType )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LBracket) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1035);
                    dataType21=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType21.getTree());

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:31: ( LParen attributeList RParen )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LParen) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:32: LParen attributeList RParen
                    {
                    LParen22=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1040);  
                    stream_LParen.add(LParen22);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1042);
                    attributeList23=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList23.getTree());
                    RParen24=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1044);  
                    stream_RParen.add(RParen24);


                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:62: ( plural )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=Seq && LA11_0<=Star)||LA11_0==Plus||LA11_0==Question) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:62: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1048);
                    plural25=plural();

                    state._fsp--;

                    stream_plural.add(plural25.getTree());

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:70: ( Colon nodeValue )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:71: Colon nodeValue
                    {
                    Colon26=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1052);  
                    stream_Colon.add(Colon26);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1054);
                    nodeValue27=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue27.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: plural, dataType, nodeValue, attributeList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 295:2: -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName20!=null?input.toString(nodeName20.start,nodeName20.stop):null).trim()));
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:33: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:43: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:58: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:66: ( nodeValue )?
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:298:1: fragment dataType : LBracket dataTypeName RBracket ;
    public final SilkParser.dataType_return dataType() throws RecognitionException {
        SilkParser.dataType_return retval = new SilkParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket28=null;
        Token RBracket30=null;
        SilkParser.dataTypeName_return dataTypeName29 = null;


        Object LBracket28_tree=null;
        Object RBracket30_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:9: ( LBracket dataTypeName RBracket )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket28=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1087); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1090);
            dataTypeName29=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName29.getTree());
            RBracket30=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1092); 

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:302:1: fragment dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine31=null;

        Object PlainOneLine31_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:303:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:303:15: PlainOneLine
            {
            PlainOneLine31=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1105);  
            stream_PlainOneLine.add(PlainOneLine31);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:307:1: fragment attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma33=null;
        SilkParser.attributeItem_return attributeItem32 = null;

        SilkParser.attributeItem_return attributeItem34 = null;


        Object Comma33_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:14: ( attributeItem ( Comma attributeItem )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1125);
            attributeItem32=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem32.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:30: ( Comma attributeItem )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:31: Comma attributeItem
            	    {
            	    Comma33=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1128); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1131);
            	    attributeItem34=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem34.getTree());

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:310:1: fragment attributeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem35 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:311:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:311:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1144);
            nodeItem35=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem35.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 311:25: -> ^( SilkNode nodeItem )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:311:28: ^( SilkNode nodeItem )
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

    public static class seqseq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "seqseq"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:1: fragment seqseq : Seq Seq ;
    public final SilkParser.seqseq_return seqseq() throws RecognitionException {
        SilkParser.seqseq_return retval = new SilkParser.seqseq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Seq36=null;
        Token Seq37=null;

        Object Seq36_tree=null;
        Object Seq37_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:314:7: ( Seq Seq )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:314:9: Seq Seq
            {
            root_0 = (Object)adaptor.nil();

            Seq36=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1161); 
            Seq36_tree = (Object)adaptor.create(Seq36);
            adaptor.addChild(root_0, Seq36_tree);

            Seq37=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1163); 
            Seq37_tree = (Object)adaptor.create(Seq37);
            adaptor.addChild(root_0, Seq37_tree);


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
    // $ANTLR end "seqseq"

    public static class plural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plural"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:1: fragment plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | seqseq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star38=null;
        Token Plus39=null;
        Token Question40=null;
        Token Seq42=null;
        Token TabSeq43=null;
        SilkParser.seqseq_return seqseq41 = null;


        Object Star38_tree=null;
        Object Plus39_tree=null;
        Object Question40_tree=null;
        Object Seq42_tree=null;
        Object TabSeq43_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_TabSeq=new RewriteRuleTokenStream(adaptor,"token TabSeq");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");
        RewriteRuleSubtreeStream stream_seqseq=new RewriteRuleSubtreeStream(adaptor,"rule seqseq");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:318:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | seqseq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] )
            int alt14=6;
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
                int LA14_4 = input.LA(2);

                if ( (LA14_4==Seq) ) {
                    alt14=4;
                }
                else if ( (LA14_4==EOF||LA14_4==WhiteSpace||(LA14_4>=LineComment && LA14_4<=FunctionIndent)||(LA14_4>=RParen && LA14_4<=Colon)) ) {
                    alt14=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:318:4: Star
                    {
                    Star38=(Token)match(input,Star,FOLLOW_Star_in_plural1174);  
                    stream_Star.add(Star38);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 318:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:319:4: Plus
                    {
                    Plus39=(Token)match(input,Plus,FOLLOW_Plus_in_plural1184);  
                    stream_Plus.add(Plus39);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 319:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:320:4: Question
                    {
                    Question40=(Token)match(input,Question,FOLLOW_Question_in_plural1194);  
                    stream_Question.add(Question40);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 320:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:321:4: seqseq
                    {
                    pushFollow(FOLLOW_seqseq_in_plural1204);
                    seqseq41=seqseq();

                    state._fsp--;

                    stream_seqseq.add(seqseq41.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 321:11: -> Occurrence[\"MULTILINE_SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "MULTILINE_SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:322:4: Seq
                    {
                    Seq42=(Token)match(input,Seq,FOLLOW_Seq_in_plural1214);  
                    stream_Seq.add(Seq42);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 322:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:323:4: TabSeq
                    {
                    TabSeq43=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1224);  
                    stream_TabSeq.add(TabSeq43);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 323:11: -> Occurrence[\"TABBED_SEQUENCE\"]
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:326:1: function : ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) );
    public final SilkParser.function_return function() throws RecognitionException {
        SilkParser.function_return retval = new SilkParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent44=null;
        Token FunctionIndent46=null;
        Token PlainOneLine47=null;
        Token LParen48=null;
        Token Comma50=null;
        Token RParen52=null;
        SilkParser.function_i_return function_i45 = null;

        SilkParser.functionArg_return functionArg49 = null;

        SilkParser.functionArg_return functionArg51 = null;


        Object NodeIndent44_tree=null;
        Object FunctionIndent46_tree=null;
        Object PlainOneLine47_tree=null;
        Object LParen48_tree=null;
        Object Comma50_tree=null;
        Object RParen52_tree=null;
        RewriteRuleTokenStream stream_FunctionIndent=new RewriteRuleTokenStream(adaptor,"token FunctionIndent");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:327:2: ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:327:4: NodeIndent function_i
                    {
                    NodeIndent44=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1240);  
                    stream_NodeIndent.add(NodeIndent44);

                    pushFollow(FOLLOW_function_i_in_function1242);
                    function_i45=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i45.getTree());


                    // AST REWRITE
                    // elements: function_i, NodeIndent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 328:2: -> ^( Function NodeIndent function_i )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:328:5: ^( Function NodeIndent function_i )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:329:4: FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
                    {
                    FunctionIndent46=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1258);  
                    stream_FunctionIndent.add(FunctionIndent46);

                    PlainOneLine47=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1260);  
                    stream_PlainOneLine.add(PlainOneLine47);

                    LParen48=(Token)match(input,LParen,FOLLOW_LParen_in_function1262);  
                    stream_LParen.add(LParen48);

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:329:39: ( functionArg ( Comma functionArg )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==At||LA16_0==String||(LA16_0>=PlainOneLine && LA16_0<=JSON)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:329:40: functionArg ( Comma functionArg )*
                            {
                            pushFollow(FOLLOW_functionArg_in_function1265);
                            functionArg49=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg49.getTree());
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:329:52: ( Comma functionArg )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==Comma) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:329:53: Comma functionArg
                            	    {
                            	    Comma50=(Token)match(input,Comma,FOLLOW_Comma_in_function1268);  
                            	    stream_Comma.add(Comma50);

                            	    pushFollow(FOLLOW_functionArg_in_function1270);
                            	    functionArg51=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg51.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen52=(Token)match(input,RParen,FOLLOW_RParen_in_function1276);  
                    stream_RParen.add(RParen52);



                    // AST REWRITE
                    // elements: functionArg
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 330:2: -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:330:5: ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent46!=null?FunctionIndent46.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine47!=null?PlainOneLine47.getText():null).trim()));
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:330:81: ( functionArg )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:333:1: fragment function_i : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* ;
    public final SilkParser.function_i_return function_i() throws RecognitionException {
        SilkParser.function_i_return retval = new SilkParser.function_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At53=null;
        Token PlainOneLine54=null;
        Token LParen55=null;
        Token Comma57=null;
        Token RParen59=null;
        SilkParser.functionArg_return functionArg56 = null;

        SilkParser.functionArg_return functionArg58 = null;


        Object At53_tree=null;
        Object PlainOneLine54_tree=null;
        Object LParen55_tree=null;
        Object Comma57_tree=null;
        Object RParen59_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:11: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:13: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At53=(Token)match(input,At,FOLLOW_At_in_function_i1303);  
            stream_At.add(At53);

            PlainOneLine54=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1305);  
            stream_PlainOneLine.add(PlainOneLine54);

            LParen55=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1307);  
            stream_LParen.add(LParen55);

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:36: ( functionArg ( Comma functionArg )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==At||LA19_0==String||(LA19_0>=PlainOneLine && LA19_0<=JSON)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:37: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function_i1310);
                    functionArg56=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg56.getTree());
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:49: ( Comma functionArg )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Comma) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:50: Comma functionArg
                    	    {
                    	    Comma57=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1313);  
                    	    stream_Comma.add(Comma57);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1315);
                    	    functionArg58=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen59=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1321);  
            stream_RParen.add(RParen59);



            // AST REWRITE
            // elements: functionArg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 335:2: -> Name[$PlainOneLine.text.trim()] ( functionArg )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine54!=null?PlainOneLine54.getText():null).trim()));
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:335:37: ( functionArg )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:338:1: fragment functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) );
    public final SilkParser.functionArg_return functionArg() throws RecognitionException {
        SilkParser.functionArg_return retval = new SilkParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon62=null;
        SilkParser.nodeValue_return nodeValue60 = null;

        SilkParser.nodeName_return nodeName61 = null;

        SilkParser.nodeValue_return nodeValue63 = null;


        Object Colon62_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:340:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:340:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1343);
                    nodeValue60=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue60.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 340:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:341:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1353);
                    nodeName61=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName61.getTree());
                    Colon62=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1355);  
                    stream_Colon.add(Colon62);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1357);
                    nodeValue63=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue63.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 341:29: -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:341:32: ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName61!=null?input.toString(nodeName61.start,nodeName61.stop):null).trim()));
                        adaptor.addChild(root_1, (Object)adaptor.create(Value, (nodeValue63!=null?input.toString(nodeValue63.start,nodeValue63.stop):null).trim()));

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


 

    public static final BitSet FOLLOW_silkLine_in_silkFile856 = new BitSet(new long[]{0x00000000000E8002L});
    public static final BitSet FOLLOW_silkNode_in_silkLine877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineComment_in_silkLine883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_in_nodeValue947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkNode961 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkNode963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkNode978 = new BitSet(new long[]{0x000000012F200002L});
    public static final BitSet FOLLOW_LParen_in_silkNode981 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeList_in_silkNode983 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_silkNode985 = new BitSet(new long[]{0x000000012F000002L});
    public static final BitSet FOLLOW_plural_in_silkNode989 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_silkNode993 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_silkNode995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkNode1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1033 = new BitSet(new long[]{0x000000016F200002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1035 = new BitSet(new long[]{0x000000012F200002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1040 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1042 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1044 = new BitSet(new long[]{0x000000012F000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1048 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1052 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1087 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1090 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1125 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1128 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1131 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_seqseq1161 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Seq_in_seqseq1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seqseq_in_plural1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1240 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_function_i_in_function1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1258 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1260 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function1262 = new BitSet(new long[]{0x000C010010400000L});
    public static final BitSet FOLLOW_functionArg_in_function1265 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function1268 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_functionArg_in_function1270 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1303 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1305 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function_i1307 = new BitSet(new long[]{0x000C010010400000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1310 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function_i1313 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1315 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function_i1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1353 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1355 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1357 = new BitSet(new long[]{0x0000000000000002L});

}
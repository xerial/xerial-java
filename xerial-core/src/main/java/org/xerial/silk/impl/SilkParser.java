// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-23 01:32:21

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
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g"; }


    public static class silkFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkFile"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine1 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: ( silkLine )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WhiteSpace||(LA1_0>=LineComment && LA1_0<=FunctionIndent)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile861);
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
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:31: ( silkLine )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:1: silkLine : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | LineComment | WhiteSpace -> BlankLine );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent2=null;
        Token LineComment6=null;
        Token WhiteSpace7=null;
        SilkParser.nodeItem_return nodeItem3 = null;

        SilkParser.noNameNode_return noNameNode4 = null;

        SilkParser.function_return function5 = null;


        Object NodeIndent2_tree=null;
        Object LineComment6_tree=null;
        Object WhiteSpace7_tree=null;
        RewriteRuleTokenStream stream_WhiteSpace=new RewriteRuleTokenStream(adaptor,"token WhiteSpace");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:2: ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | LineComment | WhiteSpace -> BlankLine )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:4: NodeIndent nodeItem
                    {
                    NodeIndent2=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkLine882);  
                    stream_NodeIndent.add(NodeIndent2);

                    pushFollow(FOLLOW_nodeItem_in_silkLine884);
                    nodeItem3=nodeItem();

                    state._fsp--;

                    stream_nodeItem.add(nodeItem3.getTree());


                    // AST REWRITE
                    // elements: nodeItem, NodeIndent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 270:24: -> ^( SilkNode NodeIndent nodeItem )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:27: ^( SilkNode NodeIndent nodeItem )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:4: noNameNode
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_noNameNode_in_silkLine899);
                    noNameNode4=noNameNode();

                    state._fsp--;

                    adaptor.addChild(root_0, noNameNode4.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkLine905);
                    function5=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function5.getTree());

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:4: LineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    LineComment6=(Token)match(input,LineComment,FOLLOW_LineComment_in_silkLine913); 
                    LineComment6_tree = (Object)adaptor.create(LineComment6);
                    adaptor.addChild(root_0, LineComment6_tree);


                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:279:4: WhiteSpace
                    {
                    WhiteSpace7=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine920);  
                    stream_WhiteSpace.add(WhiteSpace7);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 279:15: -> BlankLine
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:1: fragment nodeName : ( PlainOneLine | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set8=null;

        Object set8_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:9: ( PlainOneLine | String )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set8=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set8));
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:285:1: fragment nodeValue : ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON );
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine10=null;
        Token String11=null;
        Token JSON12=null;
        SilkParser.function_i_return function_i9 = null;


        Object PlainOneLine10_tree=null;
        Object String11_tree=null;
        Object JSON12_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:2: ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:4: function_i
                    {
                    pushFollow(FOLLOW_function_i_in_nodeValue950);
                    function_i9=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i9.getTree());


                    // AST REWRITE
                    // elements: function_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 287:15: -> ^( Function function_i )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:18: ^( Function function_i )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:4: ( PlainOneLine | String )
                    {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:4: ( PlainOneLine | String )
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
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:5: PlainOneLine
                            {
                            PlainOneLine10=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue964);  
                            stream_PlainOneLine.add(PlainOneLine10);


                            }
                            break;
                        case 2 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:20: String
                            {
                            String11=(Token)match(input,String,FOLLOW_String_in_nodeValue968);  
                            stream_String.add(String11);


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
                    // 288:28: -> Value[$nodeValue.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:4: JSON
                    {
                    root_0 = (Object)adaptor.nil();

                    JSON12=(Token)match(input,JSON,FOLLOW_JSON_in_nodeValue979); 
                    JSON12_tree = (Object)adaptor.create(JSON12);
                    adaptor.addChild(root_0, JSON12_tree);


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

    public static class noNameNode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "noNameNode"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:1: fragment noNameNode : NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) ;
    public final SilkParser.noNameNode_return noNameNode() throws RecognitionException {
        SilkParser.noNameNode_return retval = new SilkParser.noNameNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent13=null;
        Token LParen14=null;
        Token RParen16=null;
        Token Colon18=null;
        SilkParser.attributeList_return attributeList15 = null;

        SilkParser.plural_return plural17 = null;

        SilkParser.nodeValue_return nodeValue19 = null;


        Object NodeIndent13_tree=null;
        Object LParen14_tree=null;
        Object RParen16_tree=null;
        Object Colon18_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:11: ( NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:13: NodeIndent ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
            {
            NodeIndent13=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_noNameNode993);  
            stream_NodeIndent.add(NodeIndent13);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:24: ( LParen attributeList RParen )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:25: LParen attributeList RParen
                    {
                    LParen14=(Token)match(input,LParen,FOLLOW_LParen_in_noNameNode996);  
                    stream_LParen.add(LParen14);

                    pushFollow(FOLLOW_attributeList_in_noNameNode998);
                    attributeList15=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList15.getTree());
                    RParen16=(Token)match(input,RParen,FOLLOW_RParen_in_noNameNode1000);  
                    stream_RParen.add(RParen16);


                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:55: ( plural )?
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:55: plural
                    {
                    pushFollow(FOLLOW_plural_in_noNameNode1004);
                    plural17=plural();

                    state._fsp--;

                    stream_plural.add(plural17.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:63: ( Colon nodeValue )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:64: Colon nodeValue
                    {
                    Colon18=(Token)match(input,Colon,FOLLOW_Colon_in_noNameNode1008);  
                    stream_Colon.add(Colon18);

                    pushFollow(FOLLOW_nodeValue_in_noNameNode1010);
                    nodeValue19=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue19.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeList, NodeIndent, nodeValue, plural
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 295:2: -> ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:5: ^( SilkNode NodeIndent ( attributeList )? ( plural )? ( nodeValue )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                adaptor.addChild(root_1, stream_NodeIndent.nextNode());
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:27: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:42: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_1, stream_plural.nextTree());

                }
                stream_plural.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:295:50: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();

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
    // $ANTLR end "noNameNode"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:298:1: fragment nodeItem : nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? ;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:9: ( nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )? -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:11: nodeName ( dataType )? ( LParen attributeList RParen )? ( plural )? ( Colon nodeValue )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1043);
            nodeName20=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName20.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:20: ( dataType )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1045);
                    dataType21=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType21.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:31: ( LParen attributeList RParen )?
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:32: LParen attributeList RParen
                    {
                    LParen22=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1050);  
                    stream_LParen.add(LParen22);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1052);
                    attributeList23=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList23.getTree());
                    RParen24=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1054);  
                    stream_RParen.add(RParen24);


                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:62: ( plural )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:62: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1058);
                    plural25=plural();

                    state._fsp--;

                    stream_plural.add(plural25.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:70: ( Colon nodeValue )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Colon) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:71: Colon nodeValue
                    {
                    Colon26=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1062);  
                    stream_Colon.add(Colon26);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1064);
                    nodeValue27=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue27.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: plural, attributeList, dataType, nodeValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 300:2: -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName20!=null?input.toString(nodeName20.start,nodeName20.stop):null).trim()));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:300:33: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:300:43: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:300:58: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:300:66: ( nodeValue )?
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:303:1: fragment dataType : LBracket dataTypeName RBracket ;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:304:9: ( LBracket dataTypeName RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:304:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket28=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1097); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1100);
            dataTypeName29=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName29.getTree());
            RBracket30=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1102); 

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:307:1: fragment dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine31=null;

        Object PlainOneLine31_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:15: PlainOneLine
            {
            PlainOneLine31=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1115);  
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
            // 309:2: -> DataType[$dataTypeName.text]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:312:1: fragment attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma33=null;
        SilkParser.attributeItem_return attributeItem32 = null;

        SilkParser.attributeItem_return attributeItem34 = null;


        Object Comma33_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:14: ( attributeItem ( Comma attributeItem )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1135);
            attributeItem32=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem32.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:30: ( Comma attributeItem )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Comma) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:31: Comma attributeItem
            	    {
            	    Comma33=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1138); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1141);
            	    attributeItem34=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem34.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:315:1: fragment attributeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem35 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1154);
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
            // 316:25: -> ^( SilkNode nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:28: ^( SilkNode nodeItem )
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:318:1: fragment seqseq : Seq Seq ;
    public final SilkParser.seqseq_return seqseq() throws RecognitionException {
        SilkParser.seqseq_return retval = new SilkParser.seqseq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Seq36=null;
        Token Seq37=null;

        Object Seq36_tree=null;
        Object Seq37_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:319:7: ( Seq Seq )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:319:9: Seq Seq
            {
            root_0 = (Object)adaptor.nil();

            Seq36=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1171); 
            Seq36_tree = (Object)adaptor.create(Seq36);
            adaptor.addChild(root_0, Seq36_tree);

            Seq37=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1173); 
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:321:1: fragment plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | seqseq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] );
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:323:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | seqseq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] )
            int alt13=6;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:323:4: Star
                    {
                    Star38=(Token)match(input,Star,FOLLOW_Star_in_plural1184);  
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
                    // 323:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:324:4: Plus
                    {
                    Plus39=(Token)match(input,Plus,FOLLOW_Plus_in_plural1194);  
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
                    // 324:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:325:4: Question
                    {
                    Question40=(Token)match(input,Question,FOLLOW_Question_in_plural1204);  
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
                    // 325:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:326:4: seqseq
                    {
                    pushFollow(FOLLOW_seqseq_in_plural1214);
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
                    // 326:11: -> Occurrence[\"MULTILINE_SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "MULTILINE_SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:327:4: Seq
                    {
                    Seq42=(Token)match(input,Seq,FOLLOW_Seq_in_plural1224);  
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
                    // 327:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:328:4: TabSeq
                    {
                    TabSeq43=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1234);  
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
                    // 328:11: -> Occurrence[\"TABBED_SEQUENCE\"]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:331:1: function : ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) );
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:332:2: ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NodeIndent) ) {
                alt16=1;
            }
            else if ( (LA16_0==FunctionIndent) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:332:4: NodeIndent function_i
                    {
                    NodeIndent44=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1250);  
                    stream_NodeIndent.add(NodeIndent44);

                    pushFollow(FOLLOW_function_i_in_function1252);
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
                    // 333:2: -> ^( Function NodeIndent function_i )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:333:5: ^( Function NodeIndent function_i )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:4: FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
                    {
                    FunctionIndent46=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1268);  
                    stream_FunctionIndent.add(FunctionIndent46);

                    PlainOneLine47=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1270);  
                    stream_PlainOneLine.add(PlainOneLine47);

                    LParen48=(Token)match(input,LParen,FOLLOW_LParen_in_function1272);  
                    stream_LParen.add(LParen48);

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:39: ( functionArg ( Comma functionArg )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==At||LA15_0==String||(LA15_0>=PlainOneLine && LA15_0<=JSON)) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:40: functionArg ( Comma functionArg )*
                            {
                            pushFollow(FOLLOW_functionArg_in_function1275);
                            functionArg49=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg49.getTree());
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:52: ( Comma functionArg )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==Comma) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:334:53: Comma functionArg
                            	    {
                            	    Comma50=(Token)match(input,Comma,FOLLOW_Comma_in_function1278);  
                            	    stream_Comma.add(Comma50);

                            	    pushFollow(FOLLOW_functionArg_in_function1280);
                            	    functionArg51=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg51.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen52=(Token)match(input,RParen,FOLLOW_RParen_in_function1286);  
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
                    // 335:2: -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:335:5: ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text.trim()] ( functionArg )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent46!=null?FunctionIndent46.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine47!=null?PlainOneLine47.getText():null).trim()));
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:335:81: ( functionArg )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:338:1: fragment function_i : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* ;
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:11: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text.trim()] ( functionArg )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:13: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At53=(Token)match(input,At,FOLLOW_At_in_function_i1313);  
            stream_At.add(At53);

            PlainOneLine54=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1315);  
            stream_PlainOneLine.add(PlainOneLine54);

            LParen55=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1317);  
            stream_LParen.add(LParen55);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:36: ( functionArg ( Comma functionArg )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==At||LA18_0==String||(LA18_0>=PlainOneLine && LA18_0<=JSON)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:37: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function_i1320);
                    functionArg56=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg56.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:49: ( Comma functionArg )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Comma) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:339:50: Comma functionArg
                    	    {
                    	    Comma57=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1323);  
                    	    stream_Comma.add(Comma57);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1325);
                    	    functionArg58=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen59=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1331);  
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
            // 340:2: -> Name[$PlainOneLine.text.trim()] ( functionArg )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine54!=null?PlainOneLine54.getText():null).trim()));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:340:37: ( functionArg )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:343:1: fragment functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) );
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:345:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:345:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1353);
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
                    // 345:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:346:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1363);
                    nodeName61=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName61.getTree());
                    Colon62=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1365);  
                    stream_Colon.add(Colon62);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1367);
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
                    // 346:29: -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:346:32: ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] )
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA2_eotS =
        "\23\uffff";
    static final String DFA2_eofS =
        "\1\uffff\1\5\21\uffff";
    static final String DFA2_minS =
        "\2\17\21\uffff";
    static final String DFA2_maxS =
        "\1\23\1\62\21\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\2\14\uffff\1\1";
    static final String DFA2_specialS =
        "\23\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\4\1\uffff\1\3\1\1\1\2",
            "\1\5\1\uffff\3\5\1\uffff\1\5\2\uffff\4\5\1\2\1\5\2\uffff\1"+
            "\5\7\uffff\1\22\11\uffff\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "269:1: silkLine : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | LineComment | WhiteSpace -> BlankLine );";
        }
    }
    static final String DFA5_eotS =
        "\15\uffff";
    static final String DFA5_eofS =
        "\1\2\14\uffff";
    static final String DFA5_minS =
        "\1\17\14\uffff";
    static final String DFA5_maxS =
        "\1\40\14\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA5_specialS =
        "\15\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\3\2\1\uffff\1\1\2\uffff\4\2\1\uffff\1\2\2\uffff"+
            "\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "294:24: ( LParen attributeList RParen )?";
        }
    }
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\1\6\13\uffff";
    static final String DFA6_minS =
        "\1\17\13\uffff";
    static final String DFA6_maxS =
        "\1\40\13\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\5\uffff";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\6\1\uffff\3\6\4\uffff\1\6\3\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "294:55: ( plural )?";
        }
    }
    static final String DFA8_eotS =
        "\20\uffff";
    static final String DFA8_eofS =
        "\1\2\17\uffff";
    static final String DFA8_minS =
        "\1\17\17\uffff";
    static final String DFA8_maxS =
        "\1\40\17\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA8_specialS =
        "\20\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\3\2\1\uffff\7\2\1\uffff\1\2\1\1\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "299:20: ( dataType )?";
        }
    }
    static final String DFA9_eotS =
        "\17\uffff";
    static final String DFA9_eofS =
        "\1\2\16\uffff";
    static final String DFA9_minS =
        "\1\17\16\uffff";
    static final String DFA9_maxS =
        "\1\40\16\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA9_specialS =
        "\17\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\3\2\1\uffff\1\1\6\2\1\uffff\1\2\2\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "299:31: ( LParen attributeList RParen )?";
        }
    }
    static final String DFA10_eotS =
        "\16\uffff";
    static final String DFA10_eofS =
        "\1\6\15\uffff";
    static final String DFA10_minS =
        "\1\17\15\uffff";
    static final String DFA10_maxS =
        "\1\40\15\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\7\uffff";
    static final String DFA10_specialS =
        "\16\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\6\1\uffff\3\6\2\uffff\3\6\3\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "299:62: ( plural )?";
        }
    }
    static final String DFA13_eotS =
        "\17\uffff";
    static final String DFA13_eofS =
        "\4\uffff\1\7\12\uffff";
    static final String DFA13_minS =
        "\1\31\3\uffff\1\17\12\uffff";
    static final String DFA13_maxS =
        "\1\40\3\uffff\1\31\12\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\4\1\5\7\uffff";
    static final String DFA13_specialS =
        "\17\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\4\1\5\1\1\1\uffff\1\2\2\uffff\1\3",
            "",
            "",
            "",
            "\1\7\1\uffff\3\7\2\uffff\3\7\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "321:1: fragment plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | seqseq -> Occurrence[\"MULTILINE_SEQUENCE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] );";
        }
    }
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\13\uffff";
    static final String DFA19_minS =
        "\1\34\1\uffff\2\26\7\uffff";
    static final String DFA19_maxS =
        "\1\63\1\uffff\2\30\7\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\5\uffff";
    static final String DFA19_specialS =
        "\13\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\13\uffff\1\3\11\uffff\1\2\1\1",
            "",
            "\2\1\1\5",
            "\2\1\1\5",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "343:1: fragment functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text.trim()] Value[$nodeValue.text.trim()] ) );";
        }
    }
 

    public static final BitSet FOLLOW_silkLine_in_silkFile861 = new BitSet(new long[]{0x00000000000E8002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkLine882 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkLine884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noNameNode_in_silkLine899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkLine905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineComment_in_silkLine913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_in_nodeValue979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_noNameNode993 = new BitSet(new long[]{0x000000012F200002L});
    public static final BitSet FOLLOW_LParen_in_noNameNode996 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeList_in_noNameNode998 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_noNameNode1000 = new BitSet(new long[]{0x000000012F000002L});
    public static final BitSet FOLLOW_plural_in_noNameNode1004 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_noNameNode1008 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_noNameNode1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1043 = new BitSet(new long[]{0x000000016F200002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1045 = new BitSet(new long[]{0x000000012F200002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1050 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1052 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1054 = new BitSet(new long[]{0x000000012F000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1058 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1062 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1097 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1100 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1135 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1138 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1141 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_seqseq1171 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Seq_in_seqseq1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seqseq_in_plural1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1250 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_function_i_in_function1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1268 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1270 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function1272 = new BitSet(new long[]{0x000C010010400000L});
    public static final BitSet FOLLOW_functionArg_in_function1275 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function1278 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_functionArg_in_function1280 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1313 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1315 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LParen_in_function_i1317 = new BitSet(new long[]{0x000C010010400000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1320 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_Comma_in_function_i1323 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1325 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RParen_in_function_i1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1363 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1365 = new BitSet(new long[]{0x000C010010000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1367 = new BitSet(new long[]{0x0000000000000002L});

}
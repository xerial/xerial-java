// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-30 09:30:41

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
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class SilkParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkAttribute", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "JSONValue", "LineComment", "Preamble", "LineBreakChar", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "WhiteSpace", "NonSpaceChar", "StringChar_s", "String", "NodeStart", "BlankLine", "DataLine", "LParen", "RParen", "Comma", "Colon", "Seq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Indicator", "PlainFirst", "FlowIndicator", "ScopeIndicator", "PlainSafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "PlainSafe", "PlainOneLine", "Separation"
    };
    public static final int Key=15;
    public static final int PlainSafeKey=50;
    public static final int DataType=11;
    public static final int SilkNode=5;
    public static final int SilkLine=7;
    public static final int NodeStart=31;
    public static final int LBracket=42;
    public static final int Digit=21;
    public static final int HexDigit=23;
    public static final int PlainOneLine=54;
    public static final int Plus=41;
    public static final int Occurrence=10;
    public static final int Argument=13;
    public static final int Separation=55;
    public static final int FlowIndicator=47;
    public static final int Letter=22;
    public static final int PlainSafeIn=51;
    public static final int Comma=36;
    public static final int EscapeSequence=25;
    public static final int NonSpaceChar=28;
    public static final int DataLine=33;
    public static final int PlainFirst=46;
    public static final int WhiteSpace=27;
    public static final int PlainSafeOut=52;
    public static final int Question=44;
    public static final int LineComment=17;
    public static final int Colon=37;
    public static final int JSONValue=16;
    public static final int At=40;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=14;
    public static final int Star=39;
    public static final int Preamble=18;
    public static final int Seq=38;
    public static final int Indicator=45;
    public static final int RParen=35;
    public static final int UnicodeChar=24;
    public static final int Silk=4;
    public static final int StringChar=26;
    public static final int BlankLine=32;
    public static final int LineBreak=20;
    public static final int Function=12;
    public static final int Name=8;
    public static final int LParen=34;
    public static final int String=30;
    public static final int LineBreakChar=19;
    public static final int PlainSafeChar=49;
    public static final int ScopeIndicator=48;
    public static final int EOF=-1;
    public static final int StringChar_s=29;
    public static final int Value=9;
    public static final int RBracket=43;
    public static final int PlainSafe=53;

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


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:1: schema : node ;
    public final SilkParser.schema_return schema() throws RecognitionException {
        SilkParser.schema_return retval = new SilkParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.node_return node1 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:7: ( node )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:9: node
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_node_in_schema923);
            node1=node();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, node1.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class silkFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkFile"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine2 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:11: ( silkLine )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Preamble||(LA1_0>=NodeStart && LA1_0<=DataLine)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:0:0: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile930);
            	    silkLine2=silkLine();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_silkLine.add(silkLine2.getTree());

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
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 250:21: -> ^( Silk ( silkLine )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:31: ( silkLine )*
                while ( stream_silkLine.hasNext() ) {
                    adaptor.addChild(root_1, stream_silkLine.nextTree());

                }
                stream_silkLine.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:253:1: silkLine : ( node -> ^( SilkLine node ) | Preamble | DataLine | BlankLine );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Preamble4=null;
        Token DataLine5=null;
        Token BlankLine6=null;
        SilkParser.node_return node3 = null;


        Object Preamble4_tree=null;
        Object DataLine5_tree=null;
        Object BlankLine6_tree=null;
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:254:2: ( node -> ^( SilkLine node ) | Preamble | DataLine | BlankLine )
            int alt2=4;
            switch ( input.LA(1) ) {
            case NodeStart:
                {
                alt2=1;
                }
                break;
            case Preamble:
                {
                alt2=2;
                }
                break;
            case DataLine:
                {
                alt2=3;
                }
                break;
            case BlankLine:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:254:4: node
                    {
                    pushFollow(FOLLOW_node_in_silkLine951);
                    node3=node();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_node.add(node3.getTree());


                    // AST REWRITE
                    // elements: node
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 254:9: -> ^( SilkLine node )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:254:12: ^( SilkLine node )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkLine, "SilkLine"), root_1);

                        adaptor.addChild(root_1, stream_node.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble4=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Preamble4_tree = (Object)adaptor.create(Preamble4);
                    adaptor.addChild(root_0, Preamble4_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:256:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine5=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DataLine5_tree = (Object)adaptor.create(DataLine5);
                    adaptor.addChild(root_0, DataLine5_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:257:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine6=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BlankLine6_tree = (Object)adaptor.create(BlankLine6);
                    adaptor.addChild(root_0, BlankLine6_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:1: nodeName : ( PlainOneLine | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set7=null;

        Object set7_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:9: ( PlainOneLine | String )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set7=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set7));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:1: nodeValue : ( PlainOneLine | String ) -> Value[$nodeValue.text] ;
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine8=null;
        Token String9=null;

        Object PlainOneLine8_tree=null;
        Object String9_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:10: ( ( PlainOneLine | String ) -> Value[$nodeValue.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:12: ( PlainOneLine | String )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:12: ( PlainOneLine | String )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PlainOneLine) ) {
                alt3=1;
            }
            else if ( (LA3_0==String) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:13: PlainOneLine
                    {
                    PlainOneLine8=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue996); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine8);


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:28: String
                    {
                    String9=(Token)match(input,String,FOLLOW_String_in_nodeValue1000); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_String.add(String9);


                    }
                    break;

            }



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 263:36: -> Value[$nodeValue.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class node_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "node"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:1: node : NodeStart ( coreNode | function ) ;
    public final SilkParser.node_return node() throws RecognitionException {
        SilkParser.node_return retval = new SilkParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeStart10=null;
        SilkParser.coreNode_return coreNode11 = null;

        SilkParser.function_return function12 = null;


        Object NodeStart10_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:5: ( NodeStart ( coreNode | function ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:7: NodeStart ( coreNode | function )
            {
            root_0 = (Object)adaptor.nil();

            NodeStart10=(Token)match(input,NodeStart,FOLLOW_NodeStart_in_node1013); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NodeStart10_tree = (Object)adaptor.create(NodeStart10);
            adaptor.addChild(root_0, NodeStart10_tree);
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:17: ( coreNode | function )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==String||LA4_0==PlainOneLine) ) {
                alt4=1;
            }
            else if ( (LA4_0==At) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:18: coreNode
                    {
                    pushFollow(FOLLOW_coreNode_in_node1016);
                    coreNode11=coreNode();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coreNode11.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:29: function
                    {
                    pushFollow(FOLLOW_function_in_node1020);
                    function12=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function12.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "node"

    public static class coreNode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coreNode"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:1: coreNode : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.coreNode_return coreNode() throws RecognitionException {
        SilkParser.coreNode_return retval = new SilkParser.coreNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem13 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:9: ( nodeItem -> ^( SilkNode nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:11: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_coreNode1028);
            nodeItem13=nodeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeItem.add(nodeItem13.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 268:2: -> ^( SilkNode nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:268:5: ^( SilkNode nodeItem )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkNode, "SilkNode"), root_1);

                adaptor.addChild(root_1, stream_nodeItem.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "coreNode"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:1: nodeItem : nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon15=null;
        Token LParen17=null;
        Token RParen19=null;
        SilkParser.nodeName_return nodeName14 = null;

        SilkParser.nodeValue_return nodeValue16 = null;

        SilkParser.attributeList_return attributeList18 = null;

        SilkParser.dataType_return dataType20 = null;

        SilkParser.plural_return plural21 = null;


        Object Colon15_tree=null;
        Object LParen17_tree=null;
        Object RParen19_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:9: ( nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:11: nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1046);
            nodeName14=nodeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeName.add(nodeName14.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:20: ( Colon nodeValue )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Colon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:21: Colon nodeValue
                    {
                    Colon15=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1049); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Colon.add(Colon15);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1051);
                    nodeValue16=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue16.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:39: ( LParen attributeList RParen )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LParen) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:40: LParen attributeList RParen
                    {
                    LParen17=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1056); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen17);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1058);
                    attributeList18=attributeList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeList.add(attributeList18.getTree());
                    RParen19=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1060); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen19);


                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:70: ( dataType )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBracket) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:0:0: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1064);
                    dataType20=dataType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_dataType.add(dataType20.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:80: ( plural )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=Seq && LA8_0<=Star)||LA8_0==Plus||LA8_0==Question) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:0:0: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1067);
                    plural21=plural();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_plural.add(plural21.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: dataType, plural, attributeList, nodeValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 272:2: -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName14!=null?input.toString(nodeName14.start,nodeName14.stop):null)));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:26: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_0, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:37: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:47: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:55: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:1: dataType : LBracket dataTypeName RBracket ;
    public final SilkParser.dataType_return dataType() throws RecognitionException {
        SilkParser.dataType_return retval = new SilkParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket22=null;
        Token RBracket24=null;
        SilkParser.dataTypeName_return dataTypeName23 = null;


        Object LBracket22_tree=null;
        Object RBracket24_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:9: ( LBracket dataTypeName RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket22=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1096); if (state.failed) return retval;
            pushFollow(FOLLOW_dataTypeName_in_dataType1099);
            dataTypeName23=dataTypeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dataTypeName23.getTree());
            RBracket24=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1101); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:1: dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine25=null;

        Object PlainOneLine25_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:15: PlainOneLine
            {
            PlainOneLine25=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1112); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine25);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 279:2: -> DataType[$dataTypeName.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(DataType, input.toString(retval.start,input.LT(-1))));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:1: attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma27=null;
        SilkParser.attributeItem_return attributeItem26 = null;

        SilkParser.attributeItem_return attributeItem28 = null;


        Object Comma27_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:14: ( attributeItem ( Comma attributeItem )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1130);
            attributeItem26=attributeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeItem26.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:30: ( Comma attributeItem )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:31: Comma attributeItem
            	    {
            	    Comma27=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1133); if (state.failed) return retval;
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1136);
            	    attributeItem28=attributeItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeItem28.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:1: attributeItem : nodeItem -> ^( SilkAttribute nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem29 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:14: ( nodeItem -> ^( SilkAttribute nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1146);
            nodeItem29=nodeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeItem.add(nodeItem29.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 283:25: -> ^( SilkAttribute nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:28: ^( SilkAttribute nodeItem )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkAttribute, "SilkAttribute"), root_1);

                adaptor.addChild(root_1, stream_nodeItem.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:286:1: plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star30=null;
        Token Plus31=null;
        Token Question32=null;
        Token Seq33=null;

        Object Star30_tree=null;
        Object Plus31_tree=null;
        Object Question32_tree=null;
        Object Seq33_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] )
            int alt10=4;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt10=1;
                }
                break;
            case Plus:
                {
                alt10=2;
                }
                break;
            case Question:
                {
                alt10=3;
                }
                break;
            case Seq:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:287:4: Star
                    {
                    Star30=(Token)match(input,Star,FOLLOW_Star_in_plural1164); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(Star30);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 287:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:4: Plus
                    {
                    Plus31=(Token)match(input,Plus,FOLLOW_Plus_in_plural1174); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(Plus31);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 288:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:4: Question
                    {
                    Question32=(Token)match(input,Question,FOLLOW_Question_in_plural1184); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Question.add(Question32);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 289:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:290:4: Seq
                    {
                    Seq33=(Token)match(input,Seq,FOLLOW_Seq_in_plural1194); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Seq.add(Seq33);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 290:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:1: function : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$PlainOneLine.text] ( functionArg )* ) ;
    public final SilkParser.function_return function() throws RecognitionException {
        SilkParser.function_return retval = new SilkParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At34=null;
        Token PlainOneLine35=null;
        Token LParen36=null;
        Token Comma38=null;
        Token RParen40=null;
        SilkParser.functionArg_return functionArg37 = null;

        SilkParser.functionArg_return functionArg39 = null;


        Object At34_tree=null;
        Object PlainOneLine35_tree=null;
        Object LParen36_tree=null;
        Object Comma38_tree=null;
        Object RParen40_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:9: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$PlainOneLine.text] ( functionArg )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:11: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At34=(Token)match(input,At,FOLLOW_At_in_function1208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_At.add(At34);

            PlainOneLine35=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1210); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine35);

            LParen36=(Token)match(input,LParen,FOLLOW_LParen_in_function1212); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen36);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:34: ( functionArg ( Comma functionArg )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==String||LA12_0==PlainOneLine) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:35: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function1215);
                    functionArg37=functionArg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionArg.add(functionArg37.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:47: ( Comma functionArg )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==Comma) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:48: Comma functionArg
                    	    {
                    	    Comma38=(Token)match(input,Comma,FOLLOW_Comma_in_function1218); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Comma.add(Comma38);

                    	    pushFollow(FOLLOW_functionArg_in_function1220);
                    	    functionArg39=functionArg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_functionArg.add(functionArg39.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen40=(Token)match(input,RParen,FOLLOW_RParen_in_function1226); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen40);



            // AST REWRITE
            // elements: functionArg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 294:2: -> ^( Function[$PlainOneLine.text] ( functionArg )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:5: ^( Function[$PlainOneLine.text] ( functionArg )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, (PlainOneLine35!=null?PlainOneLine35.getText():null)), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:36: ( functionArg )*
                while ( stream_functionArg.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionArg.nextTree());

                }
                stream_functionArg.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class functionArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArg"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:297:1: functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text] nodeValue ) );
    public final SilkParser.functionArg_return functionArg() throws RecognitionException {
        SilkParser.functionArg_return retval = new SilkParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon43=null;
        SilkParser.nodeValue_return nodeValue41 = null;

        SilkParser.nodeName_return nodeName42 = null;

        SilkParser.nodeValue_return nodeValue44 = null;


        Object Colon43_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:298:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text] nodeValue ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==PlainOneLine) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==Colon) ) {
                    alt13=2;
                }
                else if ( (LA13_1==EOF||(LA13_1>=RParen && LA13_1<=Comma)) ) {
                    alt13=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==String) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==Colon) ) {
                    alt13=2;
                }
                else if ( (LA13_2==EOF||(LA13_2>=RParen && LA13_2<=Comma)) ) {
                    alt13=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:298:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1248);
                    nodeValue41=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue41.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 298:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1258);
                    nodeName42=nodeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeName.add(nodeName42.getTree());
                    Colon43=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1260); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Colon.add(Colon43);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1262);
                    nodeValue44=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue44.getTree());


                    // AST REWRITE
                    // elements: nodeValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 299:29: -> ^( KeyValuePair Key[$nodeName.text] nodeValue )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:32: ^( KeyValuePair Key[$nodeName.text] nodeValue )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName42!=null?input.toString(nodeName42.start,nodeName42.stop):null)));
                        adaptor.addChild(root_1, stream_nodeValue.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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


 

    public static final BitSet FOLLOW_node_in_schema923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silkLine_in_silkFile930 = new BitSet(new long[]{0x0000000380040002L});
    public static final BitSet FOLLOW_node_in_silkLine951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Preamble_in_silkLine964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeStart_in_node1013 = new BitSet(new long[]{0x0040010040000000L});
    public static final BitSet FOLLOW_coreNode_in_node1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_node1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeItem_in_coreNode1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1046 = new BitSet(new long[]{0x000016E400000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1049 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1051 = new BitSet(new long[]{0x000016C400000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1056 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1058 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1060 = new BitSet(new long[]{0x000016C000000002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1064 = new BitSet(new long[]{0x000012C000000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1096 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1099 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1130 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1133 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1136 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function1208 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1210 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_LParen_in_function1212 = new BitSet(new long[]{0x0040000840000000L});
    public static final BitSet FOLLOW_functionArg_in_function1215 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_Comma_in_function1218 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_functionArg_in_function1220 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_RParen_in_function1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1258 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1260 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1262 = new BitSet(new long[]{0x0000000000000002L});

}
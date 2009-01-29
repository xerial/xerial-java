// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-29 23:15:34

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkAttribute", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "LineComment", "Preamble", "LineBreakChar", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "WhiteSpace", "NonSpaceChar", "StringChar_s", "String", "NodeStart", "BlankLine", "DataLine", "LParen", "RParen", "Comma", "Colon", "Seq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Indicator", "PlainFirst", "FlowIndicator", "ScopeIndicator", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "PlainSafe", "PlainChar", "PlainOneLine", "Separation"
    };
    public static final int Key=15;
    public static final int PlainSafeKey=48;
    public static final int DataType=11;
    public static final int SilkNode=5;
    public static final int SilkLine=7;
    public static final int NodeStart=30;
    public static final int LBracket=41;
    public static final int Digit=20;
    public static final int HexDigit=22;
    public static final int PlainOneLine=53;
    public static final int Plus=40;
    public static final int Occurrence=10;
    public static final int Argument=13;
    public static final int Separation=54;
    public static final int FlowIndicator=46;
    public static final int Letter=21;
    public static final int PlainSafeIn=49;
    public static final int Comma=35;
    public static final int EscapeSequence=24;
    public static final int NonSpaceChar=27;
    public static final int DataLine=32;
    public static final int PlainFirst=45;
    public static final int WhiteSpace=26;
    public static final int PlainSafeOut=50;
    public static final int Question=43;
    public static final int LineComment=16;
    public static final int Colon=36;
    public static final int At=39;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=14;
    public static final int PlainChar=52;
    public static final int Star=38;
    public static final int Preamble=17;
    public static final int Seq=37;
    public static final int Indicator=44;
    public static final int RParen=34;
    public static final int UnicodeChar=23;
    public static final int Silk=4;
    public static final int StringChar=25;
    public static final int BlankLine=31;
    public static final int LineBreak=19;
    public static final int Function=12;
    public static final int Name=8;
    public static final int LParen=33;
    public static final int String=29;
    public static final int LineBreakChar=18;
    public static final int ScopeIndicator=47;
    public static final int EOF=-1;
    public static final int StringChar_s=28;
    public static final int Value=9;
    public static final int RBracket=42;
    public static final int PlainSafe=51;

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:241:1: schema : node ;
    public final SilkParser.schema_return schema() throws RecognitionException {
        SilkParser.schema_return retval = new SilkParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.node_return node1 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:241:7: ( node )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:241:9: node
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_node_in_schema946);
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine2 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:11: ( silkLine )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:11: ( silkLine )*
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
            	    pushFollow(FOLLOW_silkLine_in_silkFile953);
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
            // 243:21: -> ^( Silk ( silkLine )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:243:31: ( silkLine )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:246:1: silkLine : silkLine_i -> ^( SilkLine silkLine_i ) ;
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_i_return silkLine_i3 = null;


        RewriteRuleSubtreeStream stream_silkLine_i=new RewriteRuleSubtreeStream(adaptor,"rule silkLine_i");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:246:9: ( silkLine_i -> ^( SilkLine silkLine_i ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:246:11: silkLine_i
            {
            pushFollow(FOLLOW_silkLine_i_in_silkLine972);
            silkLine_i3=silkLine_i();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_silkLine_i.add(silkLine_i3.getTree());


            // AST REWRITE
            // elements: silkLine_i
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 246:22: -> ^( SilkLine silkLine_i )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:246:25: ^( SilkLine silkLine_i )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkLine, "SilkLine"), root_1);

                adaptor.addChild(root_1, stream_silkLine_i.nextTree());

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
    // $ANTLR end "silkLine"

    public static class silkLine_i_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkLine_i"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:1: silkLine_i : ( Preamble | DataLine | BlankLine | node );
    public final SilkParser.silkLine_i_return silkLine_i() throws RecognitionException {
        SilkParser.silkLine_i_return retval = new SilkParser.silkLine_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Preamble4=null;
        Token DataLine5=null;
        Token BlankLine6=null;
        SilkParser.node_return node7 = null;


        Object Preamble4_tree=null;
        Object DataLine5_tree=null;
        Object BlankLine6_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:2: ( Preamble | DataLine | BlankLine | node )
            int alt2=4;
            switch ( input.LA(1) ) {
            case Preamble:
                {
                alt2=1;
                }
                break;
            case DataLine:
                {
                alt2=2;
                }
                break;
            case BlankLine:
                {
                alt2=3;
                }
                break;
            case NodeStart:
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble4=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine_i991); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Preamble4_tree = (Object)adaptor.create(Preamble4);
                    adaptor.addChild(root_0, Preamble4_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine5=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine_i996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DataLine5_tree = (Object)adaptor.create(DataLine5);
                    adaptor.addChild(root_0, DataLine5_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:252:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine6=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine_i1001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BlankLine6_tree = (Object)adaptor.create(BlankLine6);
                    adaptor.addChild(root_0, BlankLine6_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:253:4: node
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_node_in_silkLine_i1006);
                    node7=node();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, node7.getTree());

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
    // $ANTLR end "silkLine_i"

    public static class nodeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeName"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:257:1: nodeName : ( PlainOneLine | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set8=null;

        Object set8_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:257:9: ( PlainOneLine | String )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set8=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set8));
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:1: nodeValue : ( PlainOneLine | String ) -> Value[$nodeValue.text] ;
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine9=null;
        Token String10=null;

        Object PlainOneLine9_tree=null;
        Object String10_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:10: ( ( PlainOneLine | String ) -> Value[$nodeValue.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:12: ( PlainOneLine | String )
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:12: ( PlainOneLine | String )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:13: PlainOneLine
                    {
                    PlainOneLine9=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue1027); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine9);


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:28: String
                    {
                    String10=(Token)match(input,String,FOLLOW_String_in_nodeValue1031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_String.add(String10);


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
            // 258:36: -> Value[$nodeValue.text]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:1: node : NodeStart ( coreNode | function ) ;
    public final SilkParser.node_return node() throws RecognitionException {
        SilkParser.node_return retval = new SilkParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeStart11=null;
        SilkParser.coreNode_return coreNode12 = null;

        SilkParser.function_return function13 = null;


        Object NodeStart11_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:5: ( NodeStart ( coreNode | function ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:7: NodeStart ( coreNode | function )
            {
            root_0 = (Object)adaptor.nil();

            NodeStart11=(Token)match(input,NodeStart,FOLLOW_NodeStart_in_node1044); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NodeStart11_tree = (Object)adaptor.create(NodeStart11);
            adaptor.addChild(root_0, NodeStart11_tree);
            }
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:17: ( coreNode | function )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:18: coreNode
                    {
                    pushFollow(FOLLOW_coreNode_in_node1047);
                    coreNode12=coreNode();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coreNode12.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:29: function
                    {
                    pushFollow(FOLLOW_function_in_node1051);
                    function13=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function13.getTree());

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:1: coreNode : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.coreNode_return coreNode() throws RecognitionException {
        SilkParser.coreNode_return retval = new SilkParser.coreNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem14 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:9: ( nodeItem -> ^( SilkNode nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:262:11: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_coreNode1059);
            nodeItem14=nodeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeItem.add(nodeItem14.getTree());


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
            // 263:2: -> ^( SilkNode nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:263:5: ^( SilkNode nodeItem )
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:1: nodeItem : nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon16=null;
        Token LParen18=null;
        Token RParen20=null;
        SilkParser.nodeName_return nodeName15 = null;

        SilkParser.nodeValue_return nodeValue17 = null;

        SilkParser.attributeList_return attributeList19 = null;

        SilkParser.dataType_return dataType21 = null;

        SilkParser.plural_return plural22 = null;


        Object Colon16_tree=null;
        Object LParen18_tree=null;
        Object RParen20_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:9: ( nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1077);
            nodeName15=nodeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeName.add(nodeName15.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:20: ( Colon nodeValue )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Colon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:21: Colon nodeValue
                    {
                    Colon16=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1080); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Colon.add(Colon16);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1082);
                    nodeValue17=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue17.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:39: ( LParen attributeList RParen )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LParen) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:40: LParen attributeList RParen
                    {
                    LParen18=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1087); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen18);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1089);
                    attributeList19=attributeList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeList.add(attributeList19.getTree());
                    RParen20=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1091); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen20);


                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:70: ( dataType )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBracket) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:0:0: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1095);
                    dataType21=dataType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_dataType.add(dataType21.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:80: ( plural )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=Seq && LA8_0<=Star)||LA8_0==Plus||LA8_0==Question) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:0:0: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1098);
                    plural22=plural();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_plural.add(plural22.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: nodeValue, attributeList, dataType, plural
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 267:2: -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName15!=null?input.toString(nodeName15.start,nodeName15.stop):null)));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:26: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_0, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:37: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:47: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:267:55: ( attributeList )?
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:1: dataType : LBracket dataTypeName RBracket ;
    public final SilkParser.dataType_return dataType() throws RecognitionException {
        SilkParser.dataType_return retval = new SilkParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket23=null;
        Token RBracket25=null;
        SilkParser.dataTypeName_return dataTypeName24 = null;


        Object LBracket23_tree=null;
        Object RBracket25_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:9: ( LBracket dataTypeName RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket23=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1127); if (state.failed) return retval;
            pushFollow(FOLLOW_dataTypeName_in_dataType1130);
            dataTypeName24=dataTypeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dataTypeName24.getTree());
            RBracket25=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1132); if (state.failed) return retval;

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:273:1: dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine26=null;

        Object PlainOneLine26_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:273:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:273:15: PlainOneLine
            {
            PlainOneLine26=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1143); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine26);



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
            // 274:2: -> DataType[$dataTypeName.text]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:1: attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma28=null;
        SilkParser.attributeItem_return attributeItem27 = null;

        SilkParser.attributeItem_return attributeItem29 = null;


        Object Comma28_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:14: ( attributeItem ( Comma attributeItem )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1161);
            attributeItem27=attributeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeItem27.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:30: ( Comma attributeItem )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:31: Comma attributeItem
            	    {
            	    Comma28=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1164); if (state.failed) return retval;
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1167);
            	    attributeItem29=attributeItem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeItem29.getTree());

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:1: attributeItem : nodeItem -> ^( SilkAttribute nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem30 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:14: ( nodeItem -> ^( SilkAttribute nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1177);
            nodeItem30=nodeItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeItem.add(nodeItem30.getTree());


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
            // 278:25: -> ^( SilkAttribute nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:28: ^( SilkAttribute nodeItem )
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:1: plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star31=null;
        Token Plus32=null;
        Token Question33=null;
        Token Seq34=null;

        Object Star31_tree=null;
        Object Plus32_tree=null;
        Object Question33_tree=null;
        Object Seq34_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:4: Star
                    {
                    Star31=(Token)match(input,Star,FOLLOW_Star_in_plural1195); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Star.add(Star31);



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
                    // 282:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:4: Plus
                    {
                    Plus32=(Token)match(input,Plus,FOLLOW_Plus_in_plural1205); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Plus.add(Plus32);



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
                    // 283:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:284:4: Question
                    {
                    Question33=(Token)match(input,Question,FOLLOW_Question_in_plural1215); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Question.add(Question33);



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
                    // 284:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:285:4: Seq
                    {
                    Seq34=(Token)match(input,Seq,FOLLOW_Seq_in_plural1225); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Seq.add(Seq34);



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
                    // 285:8: -> Occurrence[\"SEQUENCE\"]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:1: function : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$PlainOneLine.text] ( functionArg )* ) ;
    public final SilkParser.function_return function() throws RecognitionException {
        SilkParser.function_return retval = new SilkParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At35=null;
        Token PlainOneLine36=null;
        Token LParen37=null;
        Token Comma39=null;
        Token RParen41=null;
        SilkParser.functionArg_return functionArg38 = null;

        SilkParser.functionArg_return functionArg40 = null;


        Object At35_tree=null;
        Object PlainOneLine36_tree=null;
        Object LParen37_tree=null;
        Object Comma39_tree=null;
        Object RParen41_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:9: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$PlainOneLine.text] ( functionArg )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:11: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At35=(Token)match(input,At,FOLLOW_At_in_function1239); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_At.add(At35);

            PlainOneLine36=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PlainOneLine.add(PlainOneLine36);

            LParen37=(Token)match(input,LParen,FOLLOW_LParen_in_function1243); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen37);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:34: ( functionArg ( Comma functionArg )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==String||LA12_0==PlainOneLine) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:35: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function1246);
                    functionArg38=functionArg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionArg.add(functionArg38.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:47: ( Comma functionArg )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==Comma) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:48: Comma functionArg
                    	    {
                    	    Comma39=(Token)match(input,Comma,FOLLOW_Comma_in_function1249); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Comma.add(Comma39);

                    	    pushFollow(FOLLOW_functionArg_in_function1251);
                    	    functionArg40=functionArg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_functionArg.add(functionArg40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen41=(Token)match(input,RParen,FOLLOW_RParen_in_function1257); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen41);



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
            // 289:2: -> ^( Function[$PlainOneLine.text] ( functionArg )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:5: ^( Function[$PlainOneLine.text] ( functionArg )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, (PlainOneLine36!=null?PlainOneLine36.getText():null)), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:36: ( functionArg )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:292:1: functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text] nodeValue ) );
    public final SilkParser.functionArg_return functionArg() throws RecognitionException {
        SilkParser.functionArg_return retval = new SilkParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon44=null;
        SilkParser.nodeValue_return nodeValue42 = null;

        SilkParser.nodeName_return nodeName43 = null;

        SilkParser.nodeValue_return nodeValue45 = null;


        Object Colon44_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Key[$nodeName.text] nodeValue ) )
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:293:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1279);
                    nodeValue42=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue42.getTree());


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
                    // 293:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1289);
                    nodeName43=nodeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeName.add(nodeName43.getTree());
                    Colon44=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1291); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Colon.add(Colon44);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1293);
                    nodeValue45=nodeValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nodeValue.add(nodeValue45.getTree());


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
                    // 294:29: -> ^( KeyValuePair Key[$nodeName.text] nodeValue )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:32: ^( KeyValuePair Key[$nodeName.text] nodeValue )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName43!=null?input.toString(nodeName43.start,nodeName43.stop):null)));
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


 

    public static final BitSet FOLLOW_node_in_schema946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silkLine_in_silkFile953 = new BitSet(new long[]{0x00000001C0020002L});
    public static final BitSet FOLLOW_silkLine_i_in_silkLine972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Preamble_in_silkLine_i991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine_i996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine_i1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_silkLine_i1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeStart_in_node1044 = new BitSet(new long[]{0x0020008020000000L});
    public static final BitSet FOLLOW_coreNode_in_node1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_node1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeItem_in_coreNode1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1077 = new BitSet(new long[]{0x00000B7200000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1080 = new BitSet(new long[]{0x0020000020000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1082 = new BitSet(new long[]{0x00000B6200000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1087 = new BitSet(new long[]{0x0020000020000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1089 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1091 = new BitSet(new long[]{0x00000B6000000002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1095 = new BitSet(new long[]{0x0000096000000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1127 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1130 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1161 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1164 = new BitSet(new long[]{0x0020000020000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1167 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function1239 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1241 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_LParen_in_function1243 = new BitSet(new long[]{0x0020000420000000L});
    public static final BitSet FOLLOW_functionArg_in_function1246 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_Comma_in_function1249 = new BitSet(new long[]{0x0020000020000000L});
    public static final BitSet FOLLOW_functionArg_in_function1251 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_RParen_in_function1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1289 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1291 = new BitSet(new long[]{0x0020000020000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1293 = new BitSet(new long[]{0x0000000000000002L});

}
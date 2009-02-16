// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-02-16 13:43:11

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "LineComment", "Preamble", "LineBreakChar", "LineBreak", "NodeIndent", "FunctionIndent", "WhiteSpace", "BlankLine", "DataLineBody", "DataLine", "LParen", "RParen", "Comma", "Colon", "Seq", "TabSeq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "NonSpaceChar", "StringChar_s", "String", "Indicator", "PlainFirst", "ScopeIndicator", "FlowIndicator", "PlainUnsafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "PlainSafe", "PlainOneLine", "JSON", "Separation"
    };
    public static final int Key=14;
    public static final int PlainUnsafeChar=50;
    public static final int PlainSafeKey=51;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=34;
    public static final int NodeIndent=19;
    public static final int Digit=37;
    public static final int HexDigit=39;
    public static final int PlainOneLine=55;
    public static final int Plus=33;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Separation=57;
    public static final int FlowIndicator=49;
    public static final int Letter=38;
    public static final int PlainSafeIn=52;
    public static final int Comma=27;
    public static final int TabSeq=30;
    public static final int EscapeSequence=41;
    public static final int NonSpaceChar=43;
    public static final int DataLine=24;
    public static final int PlainFirst=47;
    public static final int WhiteSpace=21;
    public static final int PlainSafeOut=53;
    public static final int JSON=56;
    public static final int Question=36;
    public static final int LineComment=15;
    public static final int Colon=28;
    public static final int At=32;
    public static final int DataLineBody=23;
    public static final int KeyValuePair=13;
    public static final int Star=31;
    public static final int Preamble=16;
    public static final int Seq=29;
    public static final int FunctionIndent=20;
    public static final int Indicator=46;
    public static final int RParen=26;
    public static final int UnicodeChar=40;
    public static final int Silk=4;
    public static final int BlankLine=22;
    public static final int StringChar=42;
    public static final int LineBreak=18;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=25;
    public static final int String=45;
    public static final int LineBreakChar=17;
    public static final int ScopeIndicator=48;
    public static final int EOF=-1;
    public static final int StringChar_s=44;
    public static final int Value=8;
    public static final int RBracket=35;
    public static final int PlainSafe=54;

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine1 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:11: ( silkLine )*
            {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Preamble||(LA1_0>=NodeIndent && LA1_0<=BlankLine)||LA1_0==DataLine) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile942);
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
            // 244:21: -> ^( Silk ( silkLine )* )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:31: ( silkLine )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:247:1: silkLine : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | function | Preamble | DataLine | BlankLine | WhiteSpace -> BlankLine );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent2=null;
        Token Preamble5=null;
        Token DataLine6=null;
        Token BlankLine7=null;
        Token WhiteSpace8=null;
        SilkParser.nodeItem_return nodeItem3 = null;

        SilkParser.function_return function4 = null;


        Object NodeIndent2_tree=null;
        Object Preamble5_tree=null;
        Object DataLine6_tree=null;
        Object BlankLine7_tree=null;
        Object WhiteSpace8_tree=null;
        RewriteRuleTokenStream stream_WhiteSpace=new RewriteRuleTokenStream(adaptor,"token WhiteSpace");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:2: ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | function | Preamble | DataLine | BlankLine | WhiteSpace -> BlankLine )
            int alt2=6;
            switch ( input.LA(1) ) {
            case NodeIndent:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==At) ) {
                    alt2=2;
                }
                else if ( (LA2_1==String||LA2_1==PlainOneLine) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case FunctionIndent:
                {
                alt2=2;
                }
                break;
            case Preamble:
                {
                alt2=3;
                }
                break;
            case DataLine:
                {
                alt2=4;
                }
                break;
            case BlankLine:
                {
                alt2=5;
                }
                break;
            case WhiteSpace:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:4: NodeIndent nodeItem
                    {
                    NodeIndent2=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkLine963);  
                    stream_NodeIndent.add(NodeIndent2);

                    pushFollow(FOLLOW_nodeItem_in_silkLine965);
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
                    // 248:24: -> ^( SilkNode NodeIndent nodeItem )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:27: ^( SilkNode NodeIndent nodeItem )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkLine981);
                    function4=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function4.getTree());

                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:250:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble5=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine986); 
                    Preamble5_tree = (Object)adaptor.create(Preamble5);
                    adaptor.addChild(root_0, Preamble5_tree);


                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:251:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine6=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine991); 
                    DataLine6_tree = (Object)adaptor.create(DataLine6);
                    adaptor.addChild(root_0, DataLine6_tree);


                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:252:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine7=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine996); 
                    BlankLine7_tree = (Object)adaptor.create(BlankLine7);
                    adaptor.addChild(root_0, BlankLine7_tree);


                    }
                    break;
                case 6 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:253:4: WhiteSpace
                    {
                    WhiteSpace8=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine1001);  
                    stream_WhiteSpace.add(WhiteSpace8);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 253:15: -> BlankLine
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:257:1: nodeName : ( PlainOneLine | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set9=null;

        Object set9_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:257:9: ( PlainOneLine | String )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set9=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set9));
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:258:1: nodeValue : ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON );
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine11=null;
        Token String12=null;
        Token JSON13=null;
        SilkParser.function_i_return function_i10 = null;


        Object PlainOneLine11_tree=null;
        Object String12_tree=null;
        Object JSON13_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:2: ( function_i -> ^( Function function_i ) | ( PlainOneLine | String ) -> Value[$nodeValue.text] | JSON )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:4: function_i
                    {
                    pushFollow(FOLLOW_function_i_in_nodeValue1027);
                    function_i10=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i10.getTree());


                    // AST REWRITE
                    // elements: function_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 259:15: -> ^( Function function_i )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:18: ^( Function function_i )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:4: ( PlainOneLine | String )
                    {
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:4: ( PlainOneLine | String )
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
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:5: PlainOneLine
                            {
                            PlainOneLine11=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue1041);  
                            stream_PlainOneLine.add(PlainOneLine11);


                            }
                            break;
                        case 2 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:20: String
                            {
                            String12=(Token)match(input,String,FOLLOW_String_in_nodeValue1045);  
                            stream_String.add(String12);


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
                    // 260:28: -> Value[$nodeValue.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:261:4: JSON
                    {
                    root_0 = (Object)adaptor.nil();

                    JSON13=(Token)match(input,JSON,FOLLOW_JSON_in_nodeValue1056); 
                    JSON13_tree = (Object)adaptor.create(JSON13);
                    adaptor.addChild(root_0, JSON13_tree);


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

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:1: nodeItem : nodeName ( dataType )? ( Colon nodeValue )? ( LParen attributeList RParen )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon16=null;
        Token LParen18=null;
        Token RParen20=null;
        SilkParser.nodeName_return nodeName14 = null;

        SilkParser.dataType_return dataType15 = null;

        SilkParser.nodeValue_return nodeValue17 = null;

        SilkParser.attributeList_return attributeList19 = null;

        SilkParser.plural_return plural21 = null;


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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:9: ( nodeName ( dataType )? ( Colon nodeValue )? ( LParen attributeList RParen )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:11: nodeName ( dataType )? ( Colon nodeValue )? ( LParen attributeList RParen )? ( plural )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1067);
            nodeName14=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName14.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:20: ( dataType )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1069);
                    dataType15=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType15.getTree());

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:30: ( Colon nodeValue )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Colon) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:31: Colon nodeValue
                    {
                    Colon16=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1073);  
                    stream_Colon.add(Colon16);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1075);
                    nodeValue17=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue17.getTree());

                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:49: ( LParen attributeList RParen )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LParen) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:50: LParen attributeList RParen
                    {
                    LParen18=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1080);  
                    stream_LParen.add(LParen18);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1082);
                    attributeList19=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList19.getTree());
                    RParen20=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1084);  
                    stream_RParen.add(RParen20);


                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:81: ( plural )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=Seq && LA8_0<=Star)||LA8_0==Plus||LA8_0==Question) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:264:81: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1089);
                    plural21=plural();

                    state._fsp--;

                    stream_plural.add(plural21.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeList, plural, nodeValue, dataType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 265:2: -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName14!=null?input.toString(nodeName14.start,nodeName14.stop):null)));
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:26: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_0, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:37: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:47: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:265:55: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:1: dataType : LBracket dataTypeName RBracket ;
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
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:9: ( LBracket dataTypeName RBracket )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket22=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1119); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1122);
            dataTypeName23=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName23.getTree());
            RBracket24=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1124); 

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:1: dataTypeName : PlainOneLine -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PlainOneLine25=null;

        Object PlainOneLine25_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:15: PlainOneLine
            {
            PlainOneLine25=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1135);  
            stream_PlainOneLine.add(PlainOneLine25);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 273:2: -> DataType[$dataTypeName.text]
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:1: attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma27=null;
        SilkParser.attributeItem_return attributeItem26 = null;

        SilkParser.attributeItem_return attributeItem28 = null;


        Object Comma27_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:14: ( attributeItem ( Comma attributeItem )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1153);
            attributeItem26=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem26.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:30: ( Comma attributeItem )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:31: Comma attributeItem
            	    {
            	    Comma27=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1156); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1159);
            	    attributeItem28=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem28.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:1: attributeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem29 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1169);
            nodeItem29=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem29.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 277:25: -> ^( SilkNode nodeItem )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:28: ^( SilkNode nodeItem )
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:280:1: plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star30=null;
        Token Plus31=null;
        Token Question32=null;
        Token Seq33=null;
        Token TabSeq34=null;

        Object Star30_tree=null;
        Object Plus31_tree=null;
        Object Question32_tree=null;
        Object Seq33_tree=null;
        Object TabSeq34_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_TabSeq=new RewriteRuleTokenStream(adaptor,"token TabSeq");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Seq=new RewriteRuleTokenStream(adaptor,"token Seq");

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Seq -> Occurrence[\"SEQUENCE\"] | TabSeq -> Occurrence[\"TABBED_SEQUENCE\"] )
            int alt10=5;
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
            case TabSeq:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:281:4: Star
                    {
                    Star30=(Token)match(input,Star,FOLLOW_Star_in_plural1187);  
                    stream_Star.add(Star30);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 281:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:4: Plus
                    {
                    Plus31=(Token)match(input,Plus,FOLLOW_Plus_in_plural1197);  
                    stream_Plus.add(Plus31);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 282:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:4: Question
                    {
                    Question32=(Token)match(input,Question,FOLLOW_Question_in_plural1207);  
                    stream_Question.add(Question32);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 283:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:284:4: Seq
                    {
                    Seq33=(Token)match(input,Seq,FOLLOW_Seq_in_plural1217);  
                    stream_Seq.add(Seq33);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 284:8: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:285:4: TabSeq
                    {
                    TabSeq34=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1227);  
                    stream_TabSeq.add(TabSeq34);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 285:11: -> Occurrence[\"TABBED_SEQUENCE\"]
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:1: function : ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text] ( functionArg )* ) );
    public final SilkParser.function_return function() throws RecognitionException {
        SilkParser.function_return retval = new SilkParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent35=null;
        Token FunctionIndent37=null;
        Token PlainOneLine38=null;
        Token LParen39=null;
        Token Comma41=null;
        Token RParen43=null;
        SilkParser.function_i_return function_i36 = null;

        SilkParser.functionArg_return functionArg40 = null;

        SilkParser.functionArg_return functionArg42 = null;


        Object NodeIndent35_tree=null;
        Object FunctionIndent37_tree=null;
        Object PlainOneLine38_tree=null;
        Object LParen39_tree=null;
        Object Comma41_tree=null;
        Object RParen43_tree=null;
        RewriteRuleTokenStream stream_FunctionIndent=new RewriteRuleTokenStream(adaptor,"token FunctionIndent");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_function_i=new RewriteRuleSubtreeStream(adaptor,"rule function_i");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:2: ( NodeIndent function_i -> ^( Function NodeIndent function_i ) | FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text] ( functionArg )* ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NodeIndent) ) {
                alt13=1;
            }
            else if ( (LA13_0==FunctionIndent) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:289:4: NodeIndent function_i
                    {
                    NodeIndent35=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1243);  
                    stream_NodeIndent.add(NodeIndent35);

                    pushFollow(FOLLOW_function_i_in_function1245);
                    function_i36=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i36.getTree());


                    // AST REWRITE
                    // elements: function_i, NodeIndent
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 290:2: -> ^( Function NodeIndent function_i )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:290:5: ^( Function NodeIndent function_i )
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
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:291:4: FunctionIndent PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
                    {
                    FunctionIndent37=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1261);  
                    stream_FunctionIndent.add(FunctionIndent37);

                    PlainOneLine38=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1263);  
                    stream_PlainOneLine.add(PlainOneLine38);

                    LParen39=(Token)match(input,LParen,FOLLOW_LParen_in_function1265);  
                    stream_LParen.add(LParen39);

                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:291:39: ( functionArg ( Comma functionArg )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==At||LA12_0==String||(LA12_0>=PlainOneLine && LA12_0<=JSON)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:291:40: functionArg ( Comma functionArg )*
                            {
                            pushFollow(FOLLOW_functionArg_in_function1268);
                            functionArg40=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg40.getTree());
                            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:291:52: ( Comma functionArg )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==Comma) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:291:53: Comma functionArg
                            	    {
                            	    Comma41=(Token)match(input,Comma,FOLLOW_Comma_in_function1271);  
                            	    stream_Comma.add(Comma41);

                            	    pushFollow(FOLLOW_functionArg_in_function1273);
                            	    functionArg42=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg42.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen43=(Token)match(input,RParen,FOLLOW_RParen_in_function1279);  
                    stream_RParen.add(RParen43);



                    // AST REWRITE
                    // elements: functionArg
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 292:2: -> ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text] ( functionArg )* )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:292:5: ^( Function NodeIndent[$FunctionIndent.text] Name[$PlainOneLine.text] ( functionArg )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, "Function"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent37!=null?FunctionIndent37.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine38!=null?PlainOneLine38.getText():null)));
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:292:74: ( functionArg )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:1: function_i : At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text] ( functionArg )* ;
    public final SilkParser.function_i_return function_i() throws RecognitionException {
        SilkParser.function_i_return retval = new SilkParser.function_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At44=null;
        Token PlainOneLine45=null;
        Token LParen46=null;
        Token Comma48=null;
        Token RParen50=null;
        SilkParser.functionArg_return functionArg47 = null;

        SilkParser.functionArg_return functionArg49 = null;


        Object At44_tree=null;
        Object PlainOneLine45_tree=null;
        Object LParen46_tree=null;
        Object Comma48_tree=null;
        Object RParen50_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:11: ( At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen -> Name[$PlainOneLine.text] ( functionArg )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:13: At PlainOneLine LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At44=(Token)match(input,At,FOLLOW_At_in_function_i1305);  
            stream_At.add(At44);

            PlainOneLine45=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1307);  
            stream_PlainOneLine.add(PlainOneLine45);

            LParen46=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1309);  
            stream_LParen.add(LParen46);

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:36: ( functionArg ( Comma functionArg )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==At||LA15_0==String||(LA15_0>=PlainOneLine && LA15_0<=JSON)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:37: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function_i1312);
                    functionArg47=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg47.getTree());
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:49: ( Comma functionArg )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==Comma) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:296:50: Comma functionArg
                    	    {
                    	    Comma48=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1315);  
                    	    stream_Comma.add(Comma48);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1317);
                    	    functionArg49=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg49.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen50=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1323);  
            stream_RParen.add(RParen50);



            // AST REWRITE
            // elements: functionArg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 297:2: -> Name[$PlainOneLine.text] ( functionArg )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine45!=null?PlainOneLine45.getText():null)));
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:297:30: ( functionArg )*
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:301:1: functionArg : ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Name[$nodeName.text] nodeValue ) );
    public final SilkParser.functionArg_return functionArg() throws RecognitionException {
        SilkParser.functionArg_return retval = new SilkParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon53=null;
        SilkParser.nodeValue_return nodeValue51 = null;

        SilkParser.nodeName_return nodeName52 = null;

        SilkParser.nodeValue_return nodeValue54 = null;


        Object Colon53_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:302:2: ( nodeValue -> Argument[$functionArg.text] | nodeName Colon nodeValue -> ^( KeyValuePair Name[$nodeName.text] nodeValue ) )
            int alt16=2;
            switch ( input.LA(1) ) {
            case At:
            case JSON:
                {
                alt16=1;
                }
                break;
            case PlainOneLine:
                {
                int LA16_2 = input.LA(2);

                if ( ((LA16_2>=RParen && LA16_2<=Comma)) ) {
                    alt16=1;
                }
                else if ( (LA16_2==Colon) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
                }
                break;
            case String:
                {
                int LA16_3 = input.LA(2);

                if ( ((LA16_3>=RParen && LA16_3<=Comma)) ) {
                    alt16=1;
                }
                else if ( (LA16_3==Colon) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:302:4: nodeValue
                    {
                    pushFollow(FOLLOW_nodeValue_in_functionArg1344);
                    nodeValue51=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue51.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 302:14: -> Argument[$functionArg.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, input.toString(retval.start,input.LT(-1))));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:303:4: nodeName Colon nodeValue
                    {
                    pushFollow(FOLLOW_nodeName_in_functionArg1354);
                    nodeName52=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName52.getTree());
                    Colon53=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1356);  
                    stream_Colon.add(Colon53);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1358);
                    nodeValue54=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue54.getTree());


                    // AST REWRITE
                    // elements: nodeValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 303:29: -> ^( KeyValuePair Name[$nodeName.text] nodeValue )
                    {
                        // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:303:32: ^( KeyValuePair Name[$nodeName.text] nodeValue )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (nodeName52!=null?input.toString(nodeName52.start,nodeName52.stop):null)));
                        adaptor.addChild(root_1, stream_nodeValue.nextTree());

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


 

    public static final BitSet FOLLOW_silkLine_in_silkFile942 = new BitSet(new long[]{0x0000000001790002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkLine963 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkLine965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkLine981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Preamble_in_silkLine986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_in_nodeValue1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1067 = new BitSet(new long[]{0x00000016F2000002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1069 = new BitSet(new long[]{0x00000012F2000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1073 = new BitSet(new long[]{0x0180200100000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1075 = new BitSet(new long[]{0x00000012E2000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1080 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1082 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1084 = new BitSet(new long[]{0x00000012E0000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1119 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1122 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1153 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1156 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1159 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1243 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_function_i_in_function1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1261 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1263 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LParen_in_function1265 = new BitSet(new long[]{0x0180200104000000L});
    public static final BitSet FOLLOW_functionArg_in_function1268 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_Comma_in_function1271 = new BitSet(new long[]{0x0180200100000000L});
    public static final BitSet FOLLOW_functionArg_in_function1273 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_RParen_in_function1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1305 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1307 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LParen_in_function_i1309 = new BitSet(new long[]{0x0180200104000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1312 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_Comma_in_function_i1315 = new BitSet(new long[]{0x0180200100000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1317 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_RParen_in_function_i1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1354 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1356 = new BitSet(new long[]{0x0180200100000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1358 = new BitSet(new long[]{0x0000000000000002L});

}
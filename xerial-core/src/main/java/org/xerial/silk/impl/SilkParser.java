// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-04-22 20:18:50

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkLine", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "WhiteSpace", "LineBreakChar", "LineComment", "Preamble", "MultiLineSeparator", "MultiLineEntrySeparator", "NodeIndent", "FunctionIndent", "BlankLine", "DataLineBody", "DataLine", "LParen", "RParen", "Comma", "Colon", "Seq", "TabSeq", "Star", "At", "Plus", "LBracket", "RBracket", "Question", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "ScopeIndicator", "FlowIndicator", "Indicator", "PlainUnsafeChar", "PlainSafeKey", "PlainSafeIn", "PlainSafeOut", "NonSpaceChar", "PlainFirst", "PlainOneLine", "JSON", "Separation"
    };
    public static final int Key=14;
    public static final int PlainUnsafeChar=49;
    public static final int PlainSafeKey=50;
    public static final int DataType=10;
    public static final int SilkNode=5;
    public static final int SilkLine=6;
    public static final int LBracket=35;
    public static final int NodeIndent=21;
    public static final int Digit=38;
    public static final int HexDigit=40;
    public static final int PlainOneLine=55;
    public static final int Plus=34;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Separation=57;
    public static final int FlowIndicator=47;
    public static final int Letter=39;
    public static final int PlainSafeIn=51;
    public static final int Comma=28;
    public static final int TabSeq=31;
    public static final int NonSpaceChar=53;
    public static final int EscapeSequence=42;
    public static final int DataLine=25;
    public static final int PlainFirst=54;
    public static final int WhiteSpace=15;
    public static final int MultiLineEntrySeparator=20;
    public static final int PlainSafeOut=52;
    public static final int JSON=56;
    public static final int Question=37;
    public static final int LineComment=17;
    public static final int Colon=29;
    public static final int At=33;
    public static final int DataLineBody=24;
    public static final int KeyValuePair=13;
    public static final int Star=32;
    public static final int Preamble=18;
    public static final int Seq=30;
    public static final int FunctionIndent=22;
    public static final int Indicator=48;
    public static final int RParen=27;
    public static final int UnicodeChar=41;
    public static final int MultiLineSeparator=19;
    public static final int Silk=4;
    public static final int BlankLine=23;
    public static final int StringChar=43;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=26;
    public static final int String=45;
    public static final int LineBreakChar=16;
    public static final int ScopeIndicator=46;
    public static final int EOF=-1;
    public static final int StringChar_s=44;
    public static final int Value=8;
    public static final int RBracket=36;

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
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:266:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile957);
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:269:1: silkLine : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | Preamble | DataLine | BlankLine | LineComment | MultiLineSeparator | MultiLineEntrySeparator | WhiteSpace -> BlankLine );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndent2=null;
        Token Preamble6=null;
        Token DataLine7=null;
        Token BlankLine8=null;
        Token LineComment9=null;
        Token MultiLineSeparator10=null;
        Token MultiLineEntrySeparator11=null;
        Token WhiteSpace12=null;
        SilkParser.nodeItem_return nodeItem3 = null;

        SilkParser.noNameNode_return noNameNode4 = null;

        SilkParser.function_return function5 = null;


        Object NodeIndent2_tree=null;
        Object Preamble6_tree=null;
        Object DataLine7_tree=null;
        Object BlankLine8_tree=null;
        Object LineComment9_tree=null;
        Object MultiLineSeparator10_tree=null;
        Object MultiLineEntrySeparator11_tree=null;
        Object WhiteSpace12_tree=null;
        RewriteRuleTokenStream stream_WhiteSpace=new RewriteRuleTokenStream(adaptor,"token WhiteSpace");
        RewriteRuleTokenStream stream_NodeIndent=new RewriteRuleTokenStream(adaptor,"token NodeIndent");
        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:2: ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | Preamble | DataLine | BlankLine | LineComment | MultiLineSeparator | MultiLineEntrySeparator | WhiteSpace -> BlankLine )
            int alt2=10;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:270:4: NodeIndent nodeItem
                    {
                    NodeIndent2=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_silkLine978);  
                    stream_NodeIndent.add(NodeIndent2);

                    pushFollow(FOLLOW_nodeItem_in_silkLine980);
                    nodeItem3=nodeItem();

                    state._fsp--;

                    stream_nodeItem.add(nodeItem3.getTree());


                    // AST REWRITE
                    // elements: NodeIndent, nodeItem
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

                    pushFollow(FOLLOW_noNameNode_in_silkLine995);
                    noNameNode4=noNameNode();

                    state._fsp--;

                    adaptor.addChild(root_0, noNameNode4.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_silkLine1001);
                    function5=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function5.getTree());

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:273:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble6=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine1006); 
                    Preamble6_tree = (Object)adaptor.create(Preamble6);
                    adaptor.addChild(root_0, Preamble6_tree);


                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:274:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine7=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine1011); 
                    DataLine7_tree = (Object)adaptor.create(DataLine7);
                    adaptor.addChild(root_0, DataLine7_tree);


                    }
                    break;
                case 6 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine8=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine1016); 
                    BlankLine8_tree = (Object)adaptor.create(BlankLine8);
                    adaptor.addChild(root_0, BlankLine8_tree);


                    }
                    break;
                case 7 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:276:4: LineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    LineComment9=(Token)match(input,LineComment,FOLLOW_LineComment_in_silkLine1021); 
                    LineComment9_tree = (Object)adaptor.create(LineComment9);
                    adaptor.addChild(root_0, LineComment9_tree);


                    }
                    break;
                case 8 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:277:4: MultiLineSeparator
                    {
                    root_0 = (Object)adaptor.nil();

                    MultiLineSeparator10=(Token)match(input,MultiLineSeparator,FOLLOW_MultiLineSeparator_in_silkLine1026); 
                    MultiLineSeparator10_tree = (Object)adaptor.create(MultiLineSeparator10);
                    adaptor.addChild(root_0, MultiLineSeparator10_tree);


                    }
                    break;
                case 9 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:4: MultiLineEntrySeparator
                    {
                    root_0 = (Object)adaptor.nil();

                    MultiLineEntrySeparator11=(Token)match(input,MultiLineEntrySeparator,FOLLOW_MultiLineEntrySeparator_in_silkLine1031); 
                    MultiLineEntrySeparator11_tree = (Object)adaptor.create(MultiLineEntrySeparator11);
                    adaptor.addChild(root_0, MultiLineEntrySeparator11_tree);


                    }
                    break;
                case 10 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:279:4: WhiteSpace
                    {
                    WhiteSpace12=(Token)match(input,WhiteSpace,FOLLOW_WhiteSpace_in_silkLine1036);  
                    stream_WhiteSpace.add(WhiteSpace12);



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

        Token set13=null;

        Object set13_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:9: ( PlainOneLine | String )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set13=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==PlainOneLine ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set13));
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

        Token PlainOneLine15=null;
        Token String16=null;
        Token JSON17=null;
        SilkParser.function_i_return function_i14 = null;


        Object PlainOneLine15_tree=null;
        Object String16_tree=null;
        Object JSON17_tree=null;
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
                    pushFollow(FOLLOW_function_i_in_nodeValue1066);
                    function_i14=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i14.getTree());


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
                            PlainOneLine15=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_nodeValue1080);  
                            stream_PlainOneLine.add(PlainOneLine15);


                            }
                            break;
                        case 2 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:288:20: String
                            {
                            String16=(Token)match(input,String,FOLLOW_String_in_nodeValue1084);  
                            stream_String.add(String16);


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

                    JSON17=(Token)match(input,JSON,FOLLOW_JSON_in_nodeValue1095); 
                    JSON17_tree = (Object)adaptor.create(JSON17);
                    adaptor.addChild(root_0, JSON17_tree);


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

        Token NodeIndent18=null;
        Token LParen19=null;
        Token RParen21=null;
        Token Colon23=null;
        SilkParser.attributeList_return attributeList20 = null;

        SilkParser.plural_return plural22 = null;

        SilkParser.nodeValue_return nodeValue24 = null;


        Object NodeIndent18_tree=null;
        Object LParen19_tree=null;
        Object RParen21_tree=null;
        Object Colon23_tree=null;
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
            NodeIndent18=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_noNameNode1109);  
            stream_NodeIndent.add(NodeIndent18);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:24: ( LParen attributeList RParen )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:25: LParen attributeList RParen
                    {
                    LParen19=(Token)match(input,LParen,FOLLOW_LParen_in_noNameNode1112);  
                    stream_LParen.add(LParen19);

                    pushFollow(FOLLOW_attributeList_in_noNameNode1114);
                    attributeList20=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList20.getTree());
                    RParen21=(Token)match(input,RParen,FOLLOW_RParen_in_noNameNode1116);  
                    stream_RParen.add(RParen21);


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
                    pushFollow(FOLLOW_plural_in_noNameNode1120);
                    plural22=plural();

                    state._fsp--;

                    stream_plural.add(plural22.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:63: ( Colon nodeValue )?
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:294:64: Colon nodeValue
                    {
                    Colon23=(Token)match(input,Colon,FOLLOW_Colon_in_noNameNode1124);  
                    stream_Colon.add(Colon23);

                    pushFollow(FOLLOW_nodeValue_in_noNameNode1126);
                    nodeValue24=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue24.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: nodeValue, NodeIndent, plural, attributeList
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

        Token LParen27=null;
        Token RParen29=null;
        Token Colon31=null;
        SilkParser.nodeName_return nodeName25 = null;

        SilkParser.dataType_return dataType26 = null;

        SilkParser.attributeList_return attributeList28 = null;

        SilkParser.plural_return plural30 = null;

        SilkParser.nodeValue_return nodeValue32 = null;


        Object LParen27_tree=null;
        Object RParen29_tree=null;
        Object Colon31_tree=null;
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
            pushFollow(FOLLOW_nodeName_in_nodeItem1159);
            nodeName25=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName25.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:20: ( dataType )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:20: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1161);
                    dataType26=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType26.getTree());

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
                    LParen27=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1166);  
                    stream_LParen.add(LParen27);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1168);
                    attributeList28=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList28.getTree());
                    RParen29=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1170);  
                    stream_RParen.add(RParen29);


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
                    pushFollow(FOLLOW_plural_in_nodeItem1174);
                    plural30=plural();

                    state._fsp--;

                    stream_plural.add(plural30.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:70: ( Colon nodeValue )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:299:71: Colon nodeValue
                    {
                    Colon31=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1178);  
                    stream_Colon.add(Colon31);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1180);
                    nodeValue32=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue32.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: nodeValue, attributeList, dataType, plural
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 300:2: -> Name[$nodeName.text.trim()] ( dataType )? ( attributeList )? ( plural )? ( nodeValue )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName25!=null?input.toString(nodeName25.start,nodeName25.stop):null).trim()));
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

        Token LBracket33=null;
        Token RBracket35=null;
        SilkParser.dataTypeName_return dataTypeName34 = null;


        Object LBracket33_tree=null;
        Object RBracket35_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:304:9: ( LBracket dataTypeName RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:304:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket33=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1213); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1216);
            dataTypeName34=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName34.getTree());
            RBracket35=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1218); 

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

        Token PlainOneLine36=null;

        Object PlainOneLine36_tree=null;
        RewriteRuleTokenStream stream_PlainOneLine=new RewriteRuleTokenStream(adaptor,"token PlainOneLine");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:13: ( PlainOneLine -> DataType[$dataTypeName.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:308:15: PlainOneLine
            {
            PlainOneLine36=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_dataTypeName1231);  
            stream_PlainOneLine.add(PlainOneLine36);



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

        Token Comma38=null;
        SilkParser.attributeItem_return attributeItem37 = null;

        SilkParser.attributeItem_return attributeItem39 = null;


        Object Comma38_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:14: ( attributeItem ( Comma attributeItem )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:313:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1251);
            attributeItem37=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem37.getTree());
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
            	    Comma38=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1254); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1257);
            	    attributeItem39=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem39.getTree());

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

        SilkParser.nodeItem_return nodeItem40 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:14: ( nodeItem -> ^( SilkNode nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:316:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1270);
            nodeItem40=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem40.getTree());


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

        Token Seq41=null;
        Token Seq42=null;

        Object Seq41_tree=null;
        Object Seq42_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:319:7: ( Seq Seq )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:319:9: Seq Seq
            {
            root_0 = (Object)adaptor.nil();

            Seq41=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1287); 
            Seq41_tree = (Object)adaptor.create(Seq41);
            adaptor.addChild(root_0, Seq41_tree);

            Seq42=(Token)match(input,Seq,FOLLOW_Seq_in_seqseq1289); 
            Seq42_tree = (Object)adaptor.create(Seq42);
            adaptor.addChild(root_0, Seq42_tree);


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

        Token Star43=null;
        Token Plus44=null;
        Token Question45=null;
        Token Seq47=null;
        Token TabSeq48=null;
        SilkParser.seqseq_return seqseq46 = null;


        Object Star43_tree=null;
        Object Plus44_tree=null;
        Object Question45_tree=null;
        Object Seq47_tree=null;
        Object TabSeq48_tree=null;
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
                    Star43=(Token)match(input,Star,FOLLOW_Star_in_plural1300);  
                    stream_Star.add(Star43);



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
                    Plus44=(Token)match(input,Plus,FOLLOW_Plus_in_plural1310);  
                    stream_Plus.add(Plus44);



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
                    Question45=(Token)match(input,Question,FOLLOW_Question_in_plural1320);  
                    stream_Question.add(Question45);



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
                    pushFollow(FOLLOW_seqseq_in_plural1330);
                    seqseq46=seqseq();

                    state._fsp--;

                    stream_seqseq.add(seqseq46.getTree());


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
                    Seq47=(Token)match(input,Seq,FOLLOW_Seq_in_plural1340);  
                    stream_Seq.add(Seq47);



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
                    TabSeq48=(Token)match(input,TabSeq,FOLLOW_TabSeq_in_plural1350);  
                    stream_TabSeq.add(TabSeq48);



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

        Token NodeIndent49=null;
        Token FunctionIndent51=null;
        Token PlainOneLine52=null;
        Token LParen53=null;
        Token Comma55=null;
        Token RParen57=null;
        SilkParser.function_i_return function_i50 = null;

        SilkParser.functionArg_return functionArg54 = null;

        SilkParser.functionArg_return functionArg56 = null;


        Object NodeIndent49_tree=null;
        Object FunctionIndent51_tree=null;
        Object PlainOneLine52_tree=null;
        Object LParen53_tree=null;
        Object Comma55_tree=null;
        Object RParen57_tree=null;
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
                    NodeIndent49=(Token)match(input,NodeIndent,FOLLOW_NodeIndent_in_function1366);  
                    stream_NodeIndent.add(NodeIndent49);

                    pushFollow(FOLLOW_function_i_in_function1368);
                    function_i50=function_i();

                    state._fsp--;

                    stream_function_i.add(function_i50.getTree());


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
                    FunctionIndent51=(Token)match(input,FunctionIndent,FOLLOW_FunctionIndent_in_function1384);  
                    stream_FunctionIndent.add(FunctionIndent51);

                    PlainOneLine52=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function1386);  
                    stream_PlainOneLine.add(PlainOneLine52);

                    LParen53=(Token)match(input,LParen,FOLLOW_LParen_in_function1388);  
                    stream_LParen.add(LParen53);

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
                            pushFollow(FOLLOW_functionArg_in_function1391);
                            functionArg54=functionArg();

                            state._fsp--;

                            stream_functionArg.add(functionArg54.getTree());
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
                            	    Comma55=(Token)match(input,Comma,FOLLOW_Comma_in_function1394);  
                            	    stream_Comma.add(Comma55);

                            	    pushFollow(FOLLOW_functionArg_in_function1396);
                            	    functionArg56=functionArg();

                            	    state._fsp--;

                            	    stream_functionArg.add(functionArg56.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RParen57=(Token)match(input,RParen,FOLLOW_RParen_in_function1402);  
                    stream_RParen.add(RParen57);



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

                        adaptor.addChild(root_1, (Object)adaptor.create(NodeIndent, (FunctionIndent51!=null?FunctionIndent51.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (PlainOneLine52!=null?PlainOneLine52.getText():null).trim()));
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

        Token At58=null;
        Token PlainOneLine59=null;
        Token LParen60=null;
        Token Comma62=null;
        Token RParen64=null;
        SilkParser.functionArg_return functionArg61 = null;

        SilkParser.functionArg_return functionArg63 = null;


        Object At58_tree=null;
        Object PlainOneLine59_tree=null;
        Object LParen60_tree=null;
        Object Comma62_tree=null;
        Object RParen64_tree=null;
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
            At58=(Token)match(input,At,FOLLOW_At_in_function_i1429);  
            stream_At.add(At58);

            PlainOneLine59=(Token)match(input,PlainOneLine,FOLLOW_PlainOneLine_in_function_i1431);  
            stream_PlainOneLine.add(PlainOneLine59);

            LParen60=(Token)match(input,LParen,FOLLOW_LParen_in_function_i1433);  
            stream_LParen.add(LParen60);

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
                    pushFollow(FOLLOW_functionArg_in_function_i1436);
                    functionArg61=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg61.getTree());
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
                    	    Comma62=(Token)match(input,Comma,FOLLOW_Comma_in_function_i1439);  
                    	    stream_Comma.add(Comma62);

                    	    pushFollow(FOLLOW_functionArg_in_function_i1441);
                    	    functionArg63=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg63.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen64=(Token)match(input,RParen,FOLLOW_RParen_in_function_i1447);  
            stream_RParen.add(RParen64);



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
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (PlainOneLine59!=null?PlainOneLine59.getText():null).trim()));
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

        Token Colon67=null;
        SilkParser.nodeValue_return nodeValue65 = null;

        SilkParser.nodeName_return nodeName66 = null;

        SilkParser.nodeValue_return nodeValue68 = null;


        Object Colon67_tree=null;
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
                    pushFollow(FOLLOW_nodeValue_in_functionArg1469);
                    nodeValue65=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue65.getTree());


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
                    pushFollow(FOLLOW_nodeName_in_functionArg1479);
                    nodeName66=nodeName();

                    state._fsp--;

                    stream_nodeName.add(nodeName66.getTree());
                    Colon67=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1481);  
                    stream_Colon.add(Colon67);

                    pushFollow(FOLLOW_nodeValue_in_functionArg1483);
                    nodeValue68=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue68.getTree());


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

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (nodeName66!=null?input.toString(nodeName66.start,nodeName66.stop):null).trim()));
                        adaptor.addChild(root_1, (Object)adaptor.create(Value, (nodeValue68!=null?input.toString(nodeValue68.start,nodeValue68.stop):null).trim()));

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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\1\1\12\uffff";
    static final String DFA1_minS =
        "\1\17\12\uffff";
    static final String DFA1_maxS =
        "\1\31\12\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\1\1\10\uffff";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\1\2",
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

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 266:11: ( silkLine )*";
        }
    }
    static final String DFA2_eotS =
        "\35\uffff";
    static final String DFA2_eofS =
        "\1\uffff\1\12\33\uffff";
    static final String DFA2_minS =
        "\2\17\33\uffff";
    static final String DFA2_maxS =
        "\1\31\1\67\33\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\2\21\uffff\1\1";
    static final String DFA2_specialS =
        "\35\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\11\1\uffff\1\6\1\3\1\7\1\10\1\1\1\2\1\5\1\uffff\1\4",
            "\1\12\1\uffff\7\12\1\uffff\2\12\2\uffff\4\12\1\2\1\12\2\uffff"+
            "\1\12\7\uffff\1\34\11\uffff\1\34",
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
            return "269:1: silkLine : ( NodeIndent nodeItem -> ^( SilkNode NodeIndent nodeItem ) | noNameNode | function | Preamble | DataLine | BlankLine | LineComment | MultiLineSeparator | MultiLineEntrySeparator | WhiteSpace -> BlankLine );";
        }
    }
    static final String DFA5_eotS =
        "\22\uffff";
    static final String DFA5_eofS =
        "\1\2\21\uffff";
    static final String DFA5_minS =
        "\1\17\21\uffff";
    static final String DFA5_maxS =
        "\1\45\21\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\17\uffff";
    static final String DFA5_specialS =
        "\22\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\1\2\uffff\4\2\1\uffff\1\2\2"+
            "\uffff\1\2",
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
        "\21\uffff";
    static final String DFA6_eofS =
        "\1\6\20\uffff";
    static final String DFA6_minS =
        "\1\17\20\uffff";
    static final String DFA6_maxS =
        "\1\45\20\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\12\uffff";
    static final String DFA6_specialS =
        "\21\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\6\1\uffff\7\6\1\uffff\1\6\3\uffff\1\6\3\1\1\uffff\1\1\2"+
            "\uffff\1\1",
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
    static final String DFA7_eotS =
        "\14\uffff";
    static final String DFA7_eofS =
        "\1\2\13\uffff";
    static final String DFA7_minS =
        "\1\17\13\uffff";
    static final String DFA7_maxS =
        "\1\35\13\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA7_specialS =
        "\14\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\1\2\3\uffff\1\1",
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

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "294:63: ( Colon nodeValue )?";
        }
    }
    static final String DFA8_eotS =
        "\25\uffff";
    static final String DFA8_eofS =
        "\1\2\24\uffff";
    static final String DFA8_minS =
        "\1\17\24\uffff";
    static final String DFA8_maxS =
        "\1\45\24\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\22\uffff";
    static final String DFA8_specialS =
        "\25\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\10\2\1\uffff\1\2\1\1\1\uffff\1\2",
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
        "\24\uffff";
    static final String DFA9_eofS =
        "\1\2\23\uffff";
    static final String DFA9_minS =
        "\1\17\23\uffff";
    static final String DFA9_maxS =
        "\1\45\23\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\21\uffff";
    static final String DFA9_specialS =
        "\24\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\1\6\2\1\uffff\1\2\2\uffff\1"+
            "\2",
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
        "\23\uffff";
    static final String DFA10_eofS =
        "\1\6\22\uffff";
    static final String DFA10_minS =
        "\1\17\22\uffff";
    static final String DFA10_maxS =
        "\1\45\22\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\14\uffff";
    static final String DFA10_specialS =
        "\23\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\6\1\uffff\7\6\1\uffff\1\6\1\uffff\3\6\3\1\1\uffff\1\1\2"+
            "\uffff\1\1",
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
    static final String DFA11_eotS =
        "\16\uffff";
    static final String DFA11_eofS =
        "\1\2\15\uffff";
    static final String DFA11_minS =
        "\1\17\15\uffff";
    static final String DFA11_maxS =
        "\1\35\15\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA11_specialS =
        "\16\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\2\2\1\1",
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "299:70: ( Colon nodeValue )?";
        }
    }
    static final String DFA13_eotS =
        "\24\uffff";
    static final String DFA13_eofS =
        "\4\uffff\1\7\17\uffff";
    static final String DFA13_minS =
        "\1\36\3\uffff\1\17\17\uffff";
    static final String DFA13_maxS =
        "\1\45\3\uffff\1\36\17\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\4\1\5\14\uffff";
    static final String DFA13_specialS =
        "\24\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\4\1\5\1\1\1\uffff\1\2\2\uffff\1\3",
            "",
            "",
            "",
            "\1\7\1\uffff\7\7\1\uffff\1\7\1\uffff\3\7\1\6",
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
        "\1\41\1\uffff\2\33\7\uffff";
    static final String DFA19_maxS =
        "\1\70\1\uffff\2\35\7\uffff";
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
 

    public static final BitSet FOLLOW_silkLine_in_silkFile957 = new BitSet(new long[]{0x0000000002FE8002L});
    public static final BitSet FOLLOW_NodeIndent_in_silkLine978 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_nodeItem_in_silkLine980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noNameNode_in_silkLine995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_silkLine1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Preamble_in_silkLine1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineComment_in_silkLine1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MultiLineSeparator_in_silkLine1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MultiLineEntrySeparator_in_silkLine1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WhiteSpace_in_silkLine1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_i_in_nodeValue1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_nodeValue1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_nodeValue1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_in_nodeValue1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_noNameNode1109 = new BitSet(new long[]{0x00000025E4000002L});
    public static final BitSet FOLLOW_LParen_in_noNameNode1112 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_attributeList_in_noNameNode1114 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RParen_in_noNameNode1116 = new BitSet(new long[]{0x00000025E0000002L});
    public static final BitSet FOLLOW_plural_in_noNameNode1120 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Colon_in_noNameNode1124 = new BitSet(new long[]{0x0180200200000000L});
    public static final BitSet FOLLOW_nodeValue_in_noNameNode1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1159 = new BitSet(new long[]{0x0000002DE4000002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1161 = new BitSet(new long[]{0x00000025E4000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1166 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1168 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1170 = new BitSet(new long[]{0x00000025E0000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1174 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1178 = new BitSet(new long[]{0x0180200200000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1213 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1216 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlainOneLine_in_dataTypeName1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1251 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1254 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1257 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_seqseq1287 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Seq_in_seqseq1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seqseq_in_plural1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Seq_in_plural1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabSeq_in_plural1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndent_in_function1366 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_function_i_in_function1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FunctionIndent_in_function1384 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function1386 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LParen_in_function1388 = new BitSet(new long[]{0x0180200208000000L});
    public static final BitSet FOLLOW_functionArg_in_function1391 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_Comma_in_function1394 = new BitSet(new long[]{0x0180200200000000L});
    public static final BitSet FOLLOW_functionArg_in_function1396 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_RParen_in_function1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function_i1429 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_PlainOneLine_in_function_i1431 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_LParen_in_function_i1433 = new BitSet(new long[]{0x0180200208000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1436 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_Comma_in_function_i1439 = new BitSet(new long[]{0x0180200200000000L});
    public static final BitSet FOLLOW_functionArg_in_function_i1441 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_RParen_in_function_i1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_functionArg1479 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1481 = new BitSet(new long[]{0x0180200200000000L});
    public static final BitSet FOLLOW_nodeValue_in_functionArg1483 = new BitSet(new long[]{0x0000000000000002L});

}
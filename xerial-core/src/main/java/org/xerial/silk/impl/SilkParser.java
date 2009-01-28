// $ANTLR 3.1.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-28 18:59:47

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SilkNode", "SilkAttribute", "Name", "Occurrence", "Type", "LineComment", "Preamble", "NewLine", "NodeIndicator", "DataLine", "WhiteSpaces", "BlankLine", "Digit", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "Int", "Dot", "Frac", "Exp", "String", "Integer", "Double", "Letter", "NameChar", "QName", "LBracket", "RBracket", "DataType", "Colon", "Comma", "RParen", "Value", "SequenceIndicator", "LParen", "LBrace", "RBrace", "Star", "Question", "Plus", "At"
    };
    public static final int DataType=33;
    public static final int NodeIndicator=12;
    public static final int SilkNode=4;
    public static final int RBrace=41;
    public static final int LBracket=31;
    public static final int Digit=16;
    public static final int Frac=23;
    public static final int HexDigit=17;
    public static final int Plus=44;
    public static final int Occurrence=7;
    public static final int Letter=28;
    public static final int Comma=35;
    public static final int Dot=22;
    public static final int EscapeSequence=19;
    public static final int DataLine=13;
    public static final int Integer=26;
    public static final int Question=43;
    public static final int LineComment=9;
    public static final int Colon=34;
    public static final int SequenceIndicator=38;
    public static final int At=45;
    public static final int Type=8;
    public static final int NameChar=29;
    public static final int SilkAttribute=5;
    public static final int Star=42;
    public static final int Preamble=10;
    public static final int Exp=24;
    public static final int Int=21;
    public static final int RParen=36;
    public static final int UnicodeChar=18;
    public static final int BlankLine=15;
    public static final int StringChar=20;
    public static final int Name=6;
    public static final int LParen=39;
    public static final int String=25;
    public static final int QName=30;
    public static final int EOF=-1;
    public static final int Value=37;
    public static final int Double=27;
    public static final int LBrace=40;
    public static final int RBracket=32;
    public static final int NewLine=11;
    public static final int WhiteSpaces=14;

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


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:1: schema : node ;
    public final SilkParser.schema_return schema() throws RecognitionException {
        SilkParser.schema_return retval = new SilkParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.node_return node1 = null;



        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:7: ( node )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:170:9: node
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_node_in_schema677);
            node1=node();

            state._fsp--;

            adaptor.addChild(root_0, node1.getTree());

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
    // $ANTLR end "schema"

    public static class silkFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkFile"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:1: silkFile : ( silkLine )* ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine2 = null;



        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:172:9: ( ( silkLine )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:2: ( silkLine )*
            {
            root_0 = (Object)adaptor.nil();

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:2: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Preamble||(LA1_0>=NodeIndicator && LA1_0<=DataLine)||LA1_0==BlankLine) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:173:2: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile685);
            	    silkLine2=silkLine();

            	    state._fsp--;

            	    adaptor.addChild(root_0, silkLine2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "silkFile"

    public static class silkLine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "silkLine"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:176:1: silkLine : ( Preamble | BlankLine | DataLine | node );
    public final SilkParser.silkLine_return silkLine() throws RecognitionException {
        SilkParser.silkLine_return retval = new SilkParser.silkLine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Preamble3=null;
        Token BlankLine4=null;
        Token DataLine5=null;
        SilkParser.node_return node6 = null;


        Object Preamble3_tree=null;
        Object BlankLine4_tree=null;
        Object DataLine5_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:2: ( Preamble | BlankLine | DataLine | node )
            int alt2=4;
            switch ( input.LA(1) ) {
            case Preamble:
                {
                alt2=1;
                }
                break;
            case BlankLine:
                {
                alt2=2;
                }
                break;
            case DataLine:
                {
                alt2=3;
                }
                break;
            case NodeIndicator:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:177:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble3=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine697); 
                    Preamble3_tree = (Object)adaptor.create(Preamble3);
                    adaptor.addChild(root_0, Preamble3_tree);


                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:178:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine4=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine702); 
                    BlankLine4_tree = (Object)adaptor.create(BlankLine4);
                    adaptor.addChild(root_0, BlankLine4_tree);


                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:179:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine5=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine707); 
                    DataLine5_tree = (Object)adaptor.create(DataLine5);
                    adaptor.addChild(root_0, DataLine5_tree);


                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:180:4: node
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_node_in_silkLine712);
                    node6=node();

                    state._fsp--;

                    adaptor.addChild(root_0, node6.getTree());

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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:1: nodeName : ( QName | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set7=null;

        Object set7_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:184:9: ( QName | String )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set7=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==QName ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set7));
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

    public static class node_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "node"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:1: node : NodeIndicator nestedNodeList ;
    public final SilkParser.node_return node() throws RecognitionException {
        SilkParser.node_return retval = new SilkParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeIndicator8=null;
        SilkParser.nestedNodeList_return nestedNodeList9 = null;


        Object NodeIndicator8_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:5: ( NodeIndicator nestedNodeList )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:186:7: NodeIndicator nestedNodeList
            {
            root_0 = (Object)adaptor.nil();

            NodeIndicator8=(Token)match(input,NodeIndicator,FOLLOW_NodeIndicator_in_node733); 
            NodeIndicator8_tree = (Object)adaptor.create(NodeIndicator8);
            adaptor.addChild(root_0, NodeIndicator8_tree);

            pushFollow(FOLLOW_nestedNodeList_in_node735);
            nestedNodeList9=nestedNodeList();

            state._fsp--;

            adaptor.addChild(root_0, nestedNodeList9.getTree());

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
    // $ANTLR end "node"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:1: nodeItem : nodeName ( Value )? ( LParen attributeList RParen )? ( DataType )? ( plural )? -> Name[$nodeName.text] ( Value )? ( DataType )? ( plural )? ( attributeList )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Value11=null;
        Token LParen12=null;
        Token RParen14=null;
        Token DataType15=null;
        SilkParser.nodeName_return nodeName10 = null;

        SilkParser.attributeList_return attributeList13 = null;

        SilkParser.plural_return plural16 = null;


        Object Value11_tree=null;
        Object LParen12_tree=null;
        Object RParen14_tree=null;
        Object DataType15_tree=null;
        RewriteRuleTokenStream stream_Value=new RewriteRuleTokenStream(adaptor,"token Value");
        RewriteRuleTokenStream stream_DataType=new RewriteRuleTokenStream(adaptor,"token DataType");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:9: ( nodeName ( Value )? ( LParen attributeList RParen )? ( DataType )? ( plural )? -> Name[$nodeName.text] ( Value )? ( DataType )? ( plural )? ( attributeList )? )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:11: nodeName ( Value )? ( LParen attributeList RParen )? ( DataType )? ( plural )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem742);
            nodeName10=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName10.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:20: ( Value )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:21: Value
                    {
                    Value11=(Token)match(input,Value,FOLLOW_Value_in_nodeItem745);  
                    stream_Value.add(Value11);


                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:29: ( LParen attributeList RParen )?
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:30: LParen attributeList RParen
                    {
                    LParen12=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem750);  
                    stream_LParen.add(LParen12);

                    pushFollow(FOLLOW_attributeList_in_nodeItem752);
                    attributeList13=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList13.getTree());
                    RParen14=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem754);  
                    stream_RParen.add(RParen14);


                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:60: ( DataType )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:60: DataType
                    {
                    DataType15=(Token)match(input,DataType,FOLLOW_DataType_in_nodeItem758);  
                    stream_DataType.add(DataType15);


                    }
                    break;

            }

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:70: ( plural )?
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:188:70: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem761);
                    plural16=plural();

                    state._fsp--;

                    stream_plural.add(plural16.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: DataType, attributeList, plural, Value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 189:2: -> Name[$nodeName.text] ( Value )? ( DataType )? ( plural )? ( attributeList )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName10!=null?input.toString(nodeName10.start,nodeName10.stop):null)));
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:26: ( Value )?
                if ( stream_Value.hasNext() ) {
                    adaptor.addChild(root_0, stream_Value.nextNode());

                }
                stream_Value.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:33: ( DataType )?
                if ( stream_DataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_DataType.nextNode());

                }
                stream_DataType.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:43: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:189:51: ( attributeList )?
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

    public static class attributeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeList"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:1: attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma18=null;
        SilkParser.attributeItem_return attributeItem17 = null;

        SilkParser.attributeItem_return attributeItem19 = null;


        Object Comma18_tree=null;

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:14: ( attributeItem ( Comma attributeItem )* )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList792);
            attributeItem17=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem17.getTree());
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:30: ( Comma attributeItem )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:31: Comma attributeItem
            	    {
            	    Comma18=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList795); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList798);
            	    attributeItem19=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem19.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:1: attributeItem : nodeItem -> ^( SilkAttribute nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem20 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:14: ( nodeItem -> ^( SilkAttribute nodeItem ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem808);
            nodeItem20=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem20.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 194:25: -> ^( SilkAttribute nodeItem )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:194:28: ^( SilkAttribute nodeItem )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SilkAttribute, "SilkAttribute"), root_1);

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

    public static class nestedNodeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nestedNodeList"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:1: nestedNodeList : ( nestedNodeItem )+ ;
    public final SilkParser.nestedNodeList_return nestedNodeList() throws RecognitionException {
        SilkParser.nestedNodeList_return retval = new SilkParser.nestedNodeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nestedNodeItem_return nestedNodeItem21 = null;



        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:15: ( ( nestedNodeItem )+ )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:17: ( nestedNodeItem )+
            {
            root_0 = (Object)adaptor.nil();

            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:17: ( nestedNodeItem )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==String||LA8_0==QName) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:17: nestedNodeItem
            	    {
            	    pushFollow(FOLLOW_nestedNodeItem_in_nestedNodeList824);
            	    nestedNodeItem21=nestedNodeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, nestedNodeItem21.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    // $ANTLR end "nestedNodeList"

    public static class nestedNodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nestedNodeItem"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:1: nestedNodeItem : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.nestedNodeItem_return nestedNodeItem() throws RecognitionException {
        SilkParser.nestedNodeItem_return retval = new SilkParser.nestedNodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem22 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:15: ( nodeItem -> ^( SilkNode nodeItem ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:17: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_nestedNodeItem834);
            nodeItem22=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem22.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 199:26: -> ^( SilkNode nodeItem )
            {
                // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:29: ^( SilkNode nodeItem )
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
    // $ANTLR end "nestedNodeItem"

    public static class plural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plural"
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:202:1: plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | SequenceIndicator -> Occurrence[\"SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star23=null;
        Token Plus24=null;
        Token Question25=null;
        Token SequenceIndicator26=null;

        Object Star23_tree=null;
        Object Plus24_tree=null;
        Object Question25_tree=null;
        Object SequenceIndicator26_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_SequenceIndicator=new RewriteRuleTokenStream(adaptor,"token SequenceIndicator");

        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | SequenceIndicator -> Occurrence[\"SEQUENCE\"] )
            int alt9=4;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt9=1;
                }
                break;
            case Plus:
                {
                alt9=2;
                }
                break;
            case Question:
                {
                alt9=3;
                }
                break;
            case SequenceIndicator:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:203:4: Star
                    {
                    Star23=(Token)match(input,Star,FOLLOW_Star_in_plural853);  
                    stream_Star.add(Star23);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 203:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:4: Plus
                    {
                    Plus24=(Token)match(input,Plus,FOLLOW_Plus_in_plural863);  
                    stream_Plus.add(Plus24);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 204:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:4: Question
                    {
                    Question25=(Token)match(input,Question,FOLLOW_Question_in_plural873);  
                    stream_Question.add(Question25);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 205:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:4: SequenceIndicator
                    {
                    SequenceIndicator26=(Token)match(input,SequenceIndicator,FOLLOW_SequenceIndicator_in_plural883);  
                    stream_SequenceIndicator.add(SequenceIndicator26);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 206:22: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

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

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA3_eotS =
        "\20\uffff";
    static final String DFA3_eofS =
        "\1\2\17\uffff";
    static final String DFA3_minS =
        "\1\12\17\uffff";
    static final String DFA3_maxS =
        "\1\54\17\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA3_specialS =
        "\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\1\uffff\2\2\1\uffff\1\2\11\uffff\1\2\4\uffff\1\2\2\uffff"+
            "\1\2\1\uffff\2\2\1\1\2\2\2\uffff\3\2",
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

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "188:20: ( Value )?";
        }
    }
    static final String DFA4_eotS =
        "\17\uffff";
    static final String DFA4_eofS =
        "\1\2\16\uffff";
    static final String DFA4_minS =
        "\1\12\16\uffff";
    static final String DFA4_maxS =
        "\1\54\16\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA4_specialS =
        "\17\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\uffff\2\2\1\uffff\1\2\11\uffff\1\2\4\uffff\1\2\2\uffff"+
            "\1\2\1\uffff\2\2\1\uffff\1\2\1\1\2\uffff\3\2",
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "188:29: ( LParen attributeList RParen )?";
        }
    }
    static final String DFA5_eotS =
        "\16\uffff";
    static final String DFA5_eofS =
        "\1\2\15\uffff";
    static final String DFA5_minS =
        "\1\12\15\uffff";
    static final String DFA5_maxS =
        "\1\54\15\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA5_specialS =
        "\16\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\2\2\1\uffff\1\2\11\uffff\1\2\4\uffff\1\2\2\uffff"+
            "\1\1\1\uffff\2\2\1\uffff\1\2\3\uffff\3\2",
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
            return "188:60: ( DataType )?";
        }
    }
    static final String DFA6_eotS =
        "\15\uffff";
    static final String DFA6_eofS =
        "\1\5\14\uffff";
    static final String DFA6_minS =
        "\1\12\14\uffff";
    static final String DFA6_maxS =
        "\1\54\14\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\7\uffff";
    static final String DFA6_specialS =
        "\15\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\5\1\uffff\2\5\1\uffff\1\5\11\uffff\1\5\4\uffff\1\5\4\uffff"+
            "\2\5\1\uffff\1\1\3\uffff\3\1",
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
            return "188:70: ( plural )?";
        }
    }
 

    public static final BitSet FOLLOW_node_in_schema677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silkLine_in_silkFile685 = new BitSet(new long[]{0x000000000000B402L});
    public static final BitSet FOLLOW_Preamble_in_silkLine697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_silkLine712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeIndicator_in_node733 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_nestedNodeList_in_node735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem742 = new BitSet(new long[]{0x00001CE200000002L});
    public static final BitSet FOLLOW_Value_in_nodeItem745 = new BitSet(new long[]{0x00001CC200000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem750 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem752 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem754 = new BitSet(new long[]{0x00001C4200000002L});
    public static final BitSet FOLLOW_DataType_in_nodeItem758 = new BitSet(new long[]{0x00001C4000000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList792 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList795 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList798 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nestedNodeItem_in_nestedNodeList824 = new BitSet(new long[]{0x0000000042000002L});
    public static final BitSet FOLLOW_nodeItem_in_nestedNodeItem834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SequenceIndicator_in_plural883 = new BitSet(new long[]{0x0000000000000002L});

}
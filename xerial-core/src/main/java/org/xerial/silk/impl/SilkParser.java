// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g 2009-01-29 03:33:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Silk", "SilkNode", "SilkAttribute", "Name", "Value", "Occurrence", "DataType", "Function", "Argument", "KeyValuePair", "Key", "LineComment", "Preamble", "NewLine", "NodeStart", "SpecialSymbol", "DataLine", "WhiteSpaces", "BlankLine", "Digit", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "Int", "Dot", "Frac", "Exp", "String", "Integer", "Double", "Letter", "NameChar", "QName", "SequenceIndicator", "LParen", "RParen", "LBracket", "RBracket", "LBrace", "RBrace", "Comma", "Star", "Question", "Plus", "At", "Slash", "InLineStringChar", "Colon", "NodeValue"
    };
    public static final int Key=14;
    public static final int DataType=10;
    public static final int RBrace=44;
    public static final int SilkNode=5;
    public static final int NodeStart=18;
    public static final int LBracket=41;
    public static final int Digit=23;
    public static final int Frac=30;
    public static final int HexDigit=24;
    public static final int Plus=48;
    public static final int Occurrence=9;
    public static final int Argument=12;
    public static final int Letter=35;
    public static final int Comma=45;
    public static final int SpecialSymbol=19;
    public static final int NodeValue=53;
    public static final int Dot=29;
    public static final int EscapeSequence=26;
    public static final int Slash=50;
    public static final int DataLine=20;
    public static final int Integer=33;
    public static final int Question=47;
    public static final int Colon=52;
    public static final int LineComment=15;
    public static final int SequenceIndicator=38;
    public static final int At=49;
    public static final int NameChar=36;
    public static final int SilkAttribute=6;
    public static final int KeyValuePair=13;
    public static final int Star=46;
    public static final int Preamble=16;
    public static final int Exp=31;
    public static final int Int=28;
    public static final int RParen=40;
    public static final int UnicodeChar=25;
    public static final int Silk=4;
    public static final int BlankLine=22;
    public static final int StringChar=27;
    public static final int Function=11;
    public static final int Name=7;
    public static final int LParen=39;
    public static final int String=32;
    public static final int InLineStringChar=51;
    public static final int QName=37;
    public static final int EOF=-1;
    public static final int Value=8;
    public static final int Double=34;
    public static final int LBrace=43;
    public static final int RBracket=42;
    public static final int NewLine=17;
    public static final int WhiteSpaces=21;

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:1: schema : node ;
    public final SilkParser.schema_return schema() throws RecognitionException {
        SilkParser.schema_return retval = new SilkParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.node_return node1 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:7: ( node )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:191:9: node
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_node_in_schema767);
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:1: silkFile : ( silkLine )* -> ^( Silk ( silkLine )* ) ;
    public final SilkParser.silkFile_return silkFile() throws RecognitionException {
        SilkParser.silkFile_return retval = new SilkParser.silkFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.silkLine_return silkLine2 = null;


        RewriteRuleSubtreeStream stream_silkLine=new RewriteRuleSubtreeStream(adaptor,"rule silkLine");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:9: ( ( silkLine )* -> ^( Silk ( silkLine )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:11: ( silkLine )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:11: ( silkLine )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Preamble||LA1_0==NodeStart||LA1_0==DataLine||LA1_0==BlankLine) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:11: silkLine
            	    {
            	    pushFollow(FOLLOW_silkLine_in_silkFile774);
            	    silkLine2=silkLine();

            	    state._fsp--;

            	    stream_silkLine.add(silkLine2.getTree());

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
            // 193:21: -> ^( Silk ( silkLine )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:24: ^( Silk ( silkLine )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Silk, "Silk"), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:193:31: ( silkLine )*
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:196:1: silkLine : ( Preamble | BlankLine | DataLine | node );
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
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:197:2: ( Preamble | BlankLine | DataLine | node )
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
            case NodeStart:
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:197:4: Preamble
                    {
                    root_0 = (Object)adaptor.nil();

                    Preamble3=(Token)match(input,Preamble,FOLLOW_Preamble_in_silkLine795); 
                    Preamble3_tree = (Object)adaptor.create(Preamble3);
                    adaptor.addChild(root_0, Preamble3_tree);


                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:198:4: BlankLine
                    {
                    root_0 = (Object)adaptor.nil();

                    BlankLine4=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_silkLine800); 
                    BlankLine4_tree = (Object)adaptor.create(BlankLine4);
                    adaptor.addChild(root_0, BlankLine4_tree);


                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:199:4: DataLine
                    {
                    root_0 = (Object)adaptor.nil();

                    DataLine5=(Token)match(input,DataLine,FOLLOW_DataLine_in_silkLine805); 
                    DataLine5_tree = (Object)adaptor.create(DataLine5);
                    adaptor.addChild(root_0, DataLine5_tree);


                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:200:4: node
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_node_in_silkLine810);
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:1: nodeName : ( QName | String );
    public final SilkParser.nodeName_return nodeName() throws RecognitionException {
        SilkParser.nodeName_return retval = new SilkParser.nodeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set7=null;

        Object set7_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:204:9: ( QName | String )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
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

    public static class nodeValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeValue"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:205:1: nodeValue : inLineJSON -> Value[$nodeValue.text] ;
    public final SilkParser.nodeValue_return nodeValue() throws RecognitionException {
        SilkParser.nodeValue_return retval = new SilkParser.nodeValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.inLineJSON_return inLineJSON8 = null;


        RewriteRuleSubtreeStream stream_inLineJSON=new RewriteRuleSubtreeStream(adaptor,"rule inLineJSON");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:2: ( inLineJSON -> Value[$nodeValue.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:206:4: inLineJSON
            {
            pushFollow(FOLLOW_inLineJSON_in_nodeValue832);
            inLineJSON8=inLineJSON();

            state._fsp--;

            stream_inLineJSON.add(inLineJSON8.getTree());


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 207:3: -> Value[$nodeValue.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Value, input.toString(retval.start,input.LT(-1))));

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
    // $ANTLR end "nodeValue"

    public static class inLineJSON_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inLineJSON"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:210:1: inLineJSON : ( jsonObject | jsonArray | jsonAtom );
    public final SilkParser.inLineJSON_return inLineJSON() throws RecognitionException {
        SilkParser.inLineJSON_return retval = new SilkParser.inLineJSON_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.jsonObject_return jsonObject9 = null;

        SilkParser.jsonArray_return jsonArray10 = null;

        SilkParser.jsonAtom_return jsonAtom11 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:2: ( jsonObject | jsonArray | jsonAtom )
            int alt3=3;
            switch ( input.LA(1) ) {
            case LBrace:
                {
                alt3=1;
                }
                break;
            case LBracket:
                {
                alt3=2;
                }
                break;
            case String:
            case Integer:
            case Double:
            case QName:
            case NodeValue:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:211:4: jsonObject
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonObject_in_inLineJSON850);
                    jsonObject9=jsonObject();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonObject9.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:212:4: jsonArray
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonArray_in_inLineJSON855);
                    jsonArray10=jsonArray();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonArray10.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:213:4: jsonAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonAtom_in_inLineJSON860);
                    jsonAtom11=jsonAtom();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonAtom11.getTree());

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
    // $ANTLR end "inLineJSON"

    public static class jsonObject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonObject"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:216:1: jsonObject : LBrace ( jsonElement ( Comma jsonElement )* )? RBrace ;
    public final SilkParser.jsonObject_return jsonObject() throws RecognitionException {
        SilkParser.jsonObject_return retval = new SilkParser.jsonObject_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBrace12=null;
        Token Comma14=null;
        Token RBrace16=null;
        SilkParser.jsonElement_return jsonElement13 = null;

        SilkParser.jsonElement_return jsonElement15 = null;


        Object LBrace12_tree=null;
        Object Comma14_tree=null;
        Object RBrace16_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:2: ( LBrace ( jsonElement ( Comma jsonElement )* )? RBrace )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:4: LBrace ( jsonElement ( Comma jsonElement )* )? RBrace
            {
            root_0 = (Object)adaptor.nil();

            LBrace12=(Token)match(input,LBrace,FOLLOW_LBrace_in_jsonObject871); 
            LBrace12_tree = (Object)adaptor.create(LBrace12);
            adaptor.addChild(root_0, LBrace12_tree);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:11: ( jsonElement ( Comma jsonElement )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==String||LA5_0==QName) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:12: jsonElement ( Comma jsonElement )*
                    {
                    pushFollow(FOLLOW_jsonElement_in_jsonObject874);
                    jsonElement13=jsonElement();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonElement13.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:24: ( Comma jsonElement )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==Comma) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:217:25: Comma jsonElement
                    	    {
                    	    Comma14=(Token)match(input,Comma,FOLLOW_Comma_in_jsonObject877); 
                    	    Comma14_tree = (Object)adaptor.create(Comma14);
                    	    adaptor.addChild(root_0, Comma14_tree);

                    	    pushFollow(FOLLOW_jsonElement_in_jsonObject879);
                    	    jsonElement15=jsonElement();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, jsonElement15.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            RBrace16=(Token)match(input,RBrace,FOLLOW_RBrace_in_jsonObject885); 
            RBrace16_tree = (Object)adaptor.create(RBrace16);
            adaptor.addChild(root_0, RBrace16_tree);


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
    // $ANTLR end "jsonObject"

    public static class jsonArray_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonArray"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:220:1: jsonArray : LBracket ( jsonValue ( Comma jsonValue )* )? RBracket ;
    public final SilkParser.jsonArray_return jsonArray() throws RecognitionException {
        SilkParser.jsonArray_return retval = new SilkParser.jsonArray_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket17=null;
        Token Comma19=null;
        Token RBracket21=null;
        SilkParser.jsonValue_return jsonValue18 = null;

        SilkParser.jsonValue_return jsonValue20 = null;


        Object LBracket17_tree=null;
        Object Comma19_tree=null;
        Object RBracket21_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:2: ( LBracket ( jsonValue ( Comma jsonValue )* )? RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:4: LBracket ( jsonValue ( Comma jsonValue )* )? RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket17=(Token)match(input,LBracket,FOLLOW_LBracket_in_jsonArray897); 
            LBracket17_tree = (Object)adaptor.create(LBracket17);
            adaptor.addChild(root_0, LBracket17_tree);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:13: ( jsonValue ( Comma jsonValue )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=String && LA7_0<=Double)||LA7_0==QName||LA7_0==LBracket||LA7_0==LBrace||LA7_0==NodeValue) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:14: jsonValue ( Comma jsonValue )*
                    {
                    pushFollow(FOLLOW_jsonValue_in_jsonArray900);
                    jsonValue18=jsonValue();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonValue18.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:24: ( Comma jsonValue )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==Comma) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:221:25: Comma jsonValue
                    	    {
                    	    Comma19=(Token)match(input,Comma,FOLLOW_Comma_in_jsonArray903); 
                    	    Comma19_tree = (Object)adaptor.create(Comma19);
                    	    adaptor.addChild(root_0, Comma19_tree);

                    	    pushFollow(FOLLOW_jsonValue_in_jsonArray905);
                    	    jsonValue20=jsonValue();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, jsonValue20.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            RBracket21=(Token)match(input,RBracket,FOLLOW_RBracket_in_jsonArray911); 
            RBracket21_tree = (Object)adaptor.create(RBracket21);
            adaptor.addChild(root_0, RBracket21_tree);


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
    // $ANTLR end "jsonArray"

    public static class jsonElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonElement"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:1: jsonElement : nodeName Colon jsonValue ;
    public final SilkParser.jsonElement_return jsonElement() throws RecognitionException {
        SilkParser.jsonElement_return retval = new SilkParser.jsonElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon23=null;
        SilkParser.nodeName_return nodeName22 = null;

        SilkParser.jsonValue_return jsonValue24 = null;


        Object Colon23_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:12: ( nodeName Colon jsonValue )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:224:14: nodeName Colon jsonValue
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nodeName_in_jsonElement921);
            nodeName22=nodeName();

            state._fsp--;

            adaptor.addChild(root_0, nodeName22.getTree());
            Colon23=(Token)match(input,Colon,FOLLOW_Colon_in_jsonElement923); 
            Colon23_tree = (Object)adaptor.create(Colon23);
            adaptor.addChild(root_0, Colon23_tree);

            pushFollow(FOLLOW_jsonValue_in_jsonElement925);
            jsonValue24=jsonValue();

            state._fsp--;

            adaptor.addChild(root_0, jsonValue24.getTree());

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
    // $ANTLR end "jsonElement"

    public static class jsonValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonValue"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:227:1: jsonValue : ( jsonAtom | jsonObject | jsonArray );
    public final SilkParser.jsonValue_return jsonValue() throws RecognitionException {
        SilkParser.jsonValue_return retval = new SilkParser.jsonValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.jsonAtom_return jsonAtom25 = null;

        SilkParser.jsonObject_return jsonObject26 = null;

        SilkParser.jsonArray_return jsonArray27 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:2: ( jsonAtom | jsonObject | jsonArray )
            int alt8=3;
            switch ( input.LA(1) ) {
            case String:
            case Integer:
            case Double:
            case QName:
            case NodeValue:
                {
                alt8=1;
                }
                break;
            case LBrace:
                {
                alt8=2;
                }
                break;
            case LBracket:
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:228:4: jsonAtom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonAtom_in_jsonValue936);
                    jsonAtom25=jsonAtom();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonAtom25.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:229:4: jsonObject
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonObject_in_jsonValue941);
                    jsonObject26=jsonObject();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonObject26.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:230:4: jsonArray
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jsonArray_in_jsonValue946);
                    jsonArray27=jsonArray();

                    state._fsp--;

                    adaptor.addChild(root_0, jsonArray27.getTree());

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
    // $ANTLR end "jsonValue"

    public static class jsonAtom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonAtom"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:233:1: jsonAtom : ( String | Integer | Double | QName | NodeValue );
    public final SilkParser.jsonAtom_return jsonAtom() throws RecognitionException {
        SilkParser.jsonAtom_return retval = new SilkParser.jsonAtom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set28=null;

        Object set28_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:234:2: ( String | Integer | Double | QName | NodeValue )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:
            {
            root_0 = (Object)adaptor.nil();

            set28=(Token)input.LT(1);
            if ( (input.LA(1)>=String && input.LA(1)<=Double)||input.LA(1)==QName||input.LA(1)==NodeValue ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set28));
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
    // $ANTLR end "jsonAtom"

    public static class node_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "node"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:1: node : NodeStart ( coreNode | function ) ;
    public final SilkParser.node_return node() throws RecognitionException {
        SilkParser.node_return retval = new SilkParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NodeStart29=null;
        SilkParser.coreNode_return coreNode30 = null;

        SilkParser.function_return function31 = null;


        Object NodeStart29_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:5: ( NodeStart ( coreNode | function ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:7: NodeStart ( coreNode | function )
            {
            root_0 = (Object)adaptor.nil();

            NodeStart29=(Token)match(input,NodeStart,FOLLOW_NodeStart_in_node991); 
            NodeStart29_tree = (Object)adaptor.create(NodeStart29);
            adaptor.addChild(root_0, NodeStart29_tree);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:17: ( coreNode | function )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==String||LA9_0==QName) ) {
                alt9=1;
            }
            else if ( (LA9_0==At) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:18: coreNode
                    {
                    pushFollow(FOLLOW_coreNode_in_node994);
                    coreNode30=coreNode();

                    state._fsp--;

                    adaptor.addChild(root_0, coreNode30.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:242:29: function
                    {
                    pushFollow(FOLLOW_function_in_node998);
                    function31=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function31.getTree());

                    }
                    break;

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
    // $ANTLR end "node"

    public static class coreNode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coreNode"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:1: coreNode : nodeItem -> ^( SilkNode nodeItem ) ;
    public final SilkParser.coreNode_return coreNode() throws RecognitionException {
        SilkParser.coreNode_return retval = new SilkParser.coreNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem32 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:9: ( nodeItem -> ^( SilkNode nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:244:11: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_coreNode1006);
            nodeItem32=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem32.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 245:2: -> ^( SilkNode nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:245:5: ^( SilkNode nodeItem )
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
    // $ANTLR end "coreNode"

    public static class nodeItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeItem"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:1: nodeItem : nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? ;
    public final SilkParser.nodeItem_return nodeItem() throws RecognitionException {
        SilkParser.nodeItem_return retval = new SilkParser.nodeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon34=null;
        Token LParen36=null;
        Token RParen38=null;
        SilkParser.nodeName_return nodeName33 = null;

        SilkParser.nodeValue_return nodeValue35 = null;

        SilkParser.attributeList_return attributeList37 = null;

        SilkParser.dataType_return dataType39 = null;

        SilkParser.plural_return plural40 = null;


        Object Colon34_tree=null;
        Object LParen36_tree=null;
        Object RParen38_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_nodeName=new RewriteRuleSubtreeStream(adaptor,"rule nodeName");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        RewriteRuleSubtreeStream stream_nodeValue=new RewriteRuleSubtreeStream(adaptor,"rule nodeValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:9: ( nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )? -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:11: nodeName ( Colon nodeValue )? ( LParen attributeList RParen )? ( dataType )? ( plural )?
            {
            pushFollow(FOLLOW_nodeName_in_nodeItem1024);
            nodeName33=nodeName();

            state._fsp--;

            stream_nodeName.add(nodeName33.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:20: ( Colon nodeValue )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:21: Colon nodeValue
                    {
                    Colon34=(Token)match(input,Colon,FOLLOW_Colon_in_nodeItem1027);  
                    stream_Colon.add(Colon34);

                    pushFollow(FOLLOW_nodeValue_in_nodeItem1029);
                    nodeValue35=nodeValue();

                    state._fsp--;

                    stream_nodeValue.add(nodeValue35.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:39: ( LParen attributeList RParen )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:40: LParen attributeList RParen
                    {
                    LParen36=(Token)match(input,LParen,FOLLOW_LParen_in_nodeItem1034);  
                    stream_LParen.add(LParen36);

                    pushFollow(FOLLOW_attributeList_in_nodeItem1036);
                    attributeList37=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList37.getTree());
                    RParen38=(Token)match(input,RParen,FOLLOW_RParen_in_nodeItem1038);  
                    stream_RParen.add(RParen38);


                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:70: ( dataType )?
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:70: dataType
                    {
                    pushFollow(FOLLOW_dataType_in_nodeItem1042);
                    dataType39=dataType();

                    state._fsp--;

                    stream_dataType.add(dataType39.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:80: ( plural )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:248:80: plural
                    {
                    pushFollow(FOLLOW_plural_in_nodeItem1045);
                    plural40=plural();

                    state._fsp--;

                    stream_plural.add(plural40.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeList, dataType, plural, nodeValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 249:2: -> Name[$nodeName.text] ( nodeValue )? ( dataType )? ( plural )? ( attributeList )?
            {
                adaptor.addChild(root_0, (Object)adaptor.create(Name, (nodeName33!=null?input.toString(nodeName33.start,nodeName33.stop):null)));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:26: ( nodeValue )?
                if ( stream_nodeValue.hasNext() ) {
                    adaptor.addChild(root_0, stream_nodeValue.nextTree());

                }
                stream_nodeValue.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:37: ( dataType )?
                if ( stream_dataType.hasNext() ) {
                    adaptor.addChild(root_0, stream_dataType.nextTree());

                }
                stream_dataType.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:47: ( plural )?
                if ( stream_plural.hasNext() ) {
                    adaptor.addChild(root_0, stream_plural.nextTree());

                }
                stream_plural.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:249:55: ( attributeList )?
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:252:1: dataType : LBracket dataTypeName RBracket ;
    public final SilkParser.dataType_return dataType() throws RecognitionException {
        SilkParser.dataType_return retval = new SilkParser.dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket41=null;
        Token RBracket43=null;
        SilkParser.dataTypeName_return dataTypeName42 = null;


        Object LBracket41_tree=null;
        Object RBracket43_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:252:9: ( LBracket dataTypeName RBracket )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:252:11: LBracket dataTypeName RBracket
            {
            root_0 = (Object)adaptor.nil();

            LBracket41=(Token)match(input,LBracket,FOLLOW_LBracket_in_dataType1074); 
            pushFollow(FOLLOW_dataTypeName_in_dataType1077);
            dataTypeName42=dataTypeName();

            state._fsp--;

            adaptor.addChild(root_0, dataTypeName42.getTree());
            RBracket43=(Token)match(input,RBracket,FOLLOW_RBracket_in_dataType1079); 

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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:1: dataTypeName : QName ( Slash QName )* -> DataType[$dataTypeName.text] ;
    public final SilkParser.dataTypeName_return dataTypeName() throws RecognitionException {
        SilkParser.dataTypeName_return retval = new SilkParser.dataTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName44=null;
        Token Slash45=null;
        Token QName46=null;

        Object QName44_tree=null;
        Object Slash45_tree=null;
        Object QName46_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_Slash=new RewriteRuleTokenStream(adaptor,"token Slash");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:13: ( QName ( Slash QName )* -> DataType[$dataTypeName.text] )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:15: QName ( Slash QName )*
            {
            QName44=(Token)match(input,QName,FOLLOW_QName_in_dataTypeName1090);  
            stream_QName.add(QName44);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:21: ( Slash QName )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==Slash) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:255:22: Slash QName
            	    {
            	    Slash45=(Token)match(input,Slash,FOLLOW_Slash_in_dataTypeName1093);  
            	    stream_Slash.add(Slash45);

            	    QName46=(Token)match(input,QName,FOLLOW_QName_in_dataTypeName1095);  
            	    stream_QName.add(QName46);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 256:2: -> DataType[$dataTypeName.text]
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:1: attributeList : attributeItem ( Comma attributeItem )* ;
    public final SilkParser.attributeList_return attributeList() throws RecognitionException {
        SilkParser.attributeList_return retval = new SilkParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma48=null;
        SilkParser.attributeItem_return attributeItem47 = null;

        SilkParser.attributeItem_return attributeItem49 = null;


        Object Comma48_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:14: ( attributeItem ( Comma attributeItem )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:16: attributeItem ( Comma attributeItem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attributeItem_in_attributeList1115);
            attributeItem47=attributeItem();

            state._fsp--;

            adaptor.addChild(root_0, attributeItem47.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:30: ( Comma attributeItem )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Comma) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:259:31: Comma attributeItem
            	    {
            	    Comma48=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1118); 
            	    pushFollow(FOLLOW_attributeItem_in_attributeList1121);
            	    attributeItem49=attributeItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeItem49.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:1: attributeItem : nodeItem -> ^( SilkAttribute nodeItem ) ;
    public final SilkParser.attributeItem_return attributeItem() throws RecognitionException {
        SilkParser.attributeItem_return retval = new SilkParser.attributeItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SilkParser.nodeItem_return nodeItem50 = null;


        RewriteRuleSubtreeStream stream_nodeItem=new RewriteRuleSubtreeStream(adaptor,"rule nodeItem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:14: ( nodeItem -> ^( SilkAttribute nodeItem ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:16: nodeItem
            {
            pushFollow(FOLLOW_nodeItem_in_attributeItem1131);
            nodeItem50=nodeItem();

            state._fsp--;

            stream_nodeItem.add(nodeItem50.getTree());


            // AST REWRITE
            // elements: nodeItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 260:25: -> ^( SilkAttribute nodeItem )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:260:28: ^( SilkAttribute nodeItem )
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

    public static class plural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plural"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:271:1: plural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | SequenceIndicator -> Occurrence[\"SEQUENCE\"] );
    public final SilkParser.plural_return plural() throws RecognitionException {
        SilkParser.plural_return retval = new SilkParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star51=null;
        Token Plus52=null;
        Token Question53=null;
        Token SequenceIndicator54=null;

        Object Star51_tree=null;
        Object Plus52_tree=null;
        Object Question53_tree=null;
        Object SequenceIndicator54_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_SequenceIndicator=new RewriteRuleTokenStream(adaptor,"token SequenceIndicator");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | SequenceIndicator -> Occurrence[\"SEQUENCE\"] )
            int alt16=4;
            switch ( input.LA(1) ) {
            case Star:
                {
                alt16=1;
                }
                break;
            case Plus:
                {
                alt16=2;
                }
                break;
            case Question:
                {
                alt16=3;
                }
                break;
            case SequenceIndicator:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:272:4: Star
                    {
                    Star51=(Token)match(input,Star,FOLLOW_Star_in_plural1151);  
                    stream_Star.add(Star51);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 272:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:273:4: Plus
                    {
                    Plus52=(Token)match(input,Plus,FOLLOW_Plus_in_plural1161);  
                    stream_Plus.add(Plus52);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 273:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:274:4: Question
                    {
                    Question53=(Token)match(input,Question,FOLLOW_Question_in_plural1171);  
                    stream_Question.add(Question53);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 274:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:275:4: SequenceIndicator
                    {
                    SequenceIndicator54=(Token)match(input,SequenceIndicator,FOLLOW_SequenceIndicator_in_plural1181);  
                    stream_SequenceIndicator.add(SequenceIndicator54);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 275:22: -> Occurrence[\"SEQUENCE\"]
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

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:1: function : At QName LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$QName.text] ( functionArg )* ) ;
    public final SilkParser.function_return function() throws RecognitionException {
        SilkParser.function_return retval = new SilkParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token At55=null;
        Token QName56=null;
        Token LParen57=null;
        Token Comma59=null;
        Token RParen61=null;
        SilkParser.functionArg_return functionArg58 = null;

        SilkParser.functionArg_return functionArg60 = null;


        Object At55_tree=null;
        Object QName56_tree=null;
        Object LParen57_tree=null;
        Object Comma59_tree=null;
        Object RParen61_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_At=new RewriteRuleTokenStream(adaptor,"token At");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_functionArg=new RewriteRuleSubtreeStream(adaptor,"rule functionArg");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:9: ( At QName LParen ( functionArg ( Comma functionArg )* )? RParen -> ^( Function[$QName.text] ( functionArg )* ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:11: At QName LParen ( functionArg ( Comma functionArg )* )? RParen
            {
            At55=(Token)match(input,At,FOLLOW_At_in_function1195);  
            stream_At.add(At55);

            QName56=(Token)match(input,QName,FOLLOW_QName_in_function1197);  
            stream_QName.add(QName56);

            LParen57=(Token)match(input,LParen,FOLLOW_LParen_in_function1199);  
            stream_LParen.add(LParen57);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:27: ( functionArg ( Comma functionArg )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=String && LA18_0<=Double)||LA18_0==QName||LA18_0==NodeValue) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:28: functionArg ( Comma functionArg )*
                    {
                    pushFollow(FOLLOW_functionArg_in_function1202);
                    functionArg58=functionArg();

                    state._fsp--;

                    stream_functionArg.add(functionArg58.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:40: ( Comma functionArg )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Comma) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:278:41: Comma functionArg
                    	    {
                    	    Comma59=(Token)match(input,Comma,FOLLOW_Comma_in_function1205);  
                    	    stream_Comma.add(Comma59);

                    	    pushFollow(FOLLOW_functionArg_in_function1207);
                    	    functionArg60=functionArg();

                    	    state._fsp--;

                    	    stream_functionArg.add(functionArg60.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            RParen61=(Token)match(input,RParen,FOLLOW_RParen_in_function1213);  
            stream_RParen.add(RParen61);



            // AST REWRITE
            // elements: functionArg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 279:2: -> ^( Function[$QName.text] ( functionArg )* )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:279:5: ^( Function[$QName.text] ( functionArg )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Function, (QName56!=null?QName56.getText():null)), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:279:29: ( functionArg )*
                while ( stream_functionArg.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionArg.nextTree());

                }
                stream_functionArg.reset();

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
    // $ANTLR end "function"

    public static class functionArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArg"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:282:1: functionArg : ( jsonAtom -> Argument[$jsonAtom.text] | QName Colon NodeValue -> ^( KeyValuePair Key[$QName.text] Value[$NodeValue.text] ) );
    public final SilkParser.functionArg_return functionArg() throws RecognitionException {
        SilkParser.functionArg_return retval = new SilkParser.functionArg_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName63=null;
        Token Colon64=null;
        Token NodeValue65=null;
        SilkParser.jsonAtom_return jsonAtom62 = null;


        Object QName63_tree=null;
        Object Colon64_tree=null;
        Object NodeValue65_tree=null;
        RewriteRuleTokenStream stream_NodeValue=new RewriteRuleTokenStream(adaptor,"token NodeValue");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_jsonAtom=new RewriteRuleSubtreeStream(adaptor,"rule jsonAtom");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:2: ( jsonAtom -> Argument[$jsonAtom.text] | QName Colon NodeValue -> ^( KeyValuePair Key[$QName.text] Value[$NodeValue.text] ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QName) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==Colon) ) {
                    alt19=2;
                }
                else if ( (LA19_1==RParen||LA19_1==Comma) ) {
                    alt19=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA19_0>=String && LA19_0<=Double)||LA19_0==NodeValue) ) {
                alt19=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:283:4: jsonAtom
                    {
                    pushFollow(FOLLOW_jsonAtom_in_functionArg1235);
                    jsonAtom62=jsonAtom();

                    state._fsp--;

                    stream_jsonAtom.add(jsonAtom62.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 283:13: -> Argument[$jsonAtom.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Argument, (jsonAtom62!=null?input.toString(jsonAtom62.start,jsonAtom62.stop):null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:284:4: QName Colon NodeValue
                    {
                    QName63=(Token)match(input,QName,FOLLOW_QName_in_functionArg1245);  
                    stream_QName.add(QName63);

                    Colon64=(Token)match(input,Colon,FOLLOW_Colon_in_functionArg1247);  
                    stream_Colon.add(Colon64);

                    NodeValue65=(Token)match(input,NodeValue,FOLLOW_NodeValue_in_functionArg1249);  
                    stream_NodeValue.add(NodeValue65);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 284:26: -> ^( KeyValuePair Key[$QName.text] Value[$NodeValue.text] )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\silk\\impl\\Silk.g:284:29: ^( KeyValuePair Key[$QName.text] Value[$NodeValue.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KeyValuePair, "KeyValuePair"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Key, (QName63!=null?QName63.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(Value, (NodeValue65!=null?NodeValue65.getText():null)));

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


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA10_eotS =
        "\17\uffff";
    static final String DFA10_eofS =
        "\1\2\16\uffff";
    static final String DFA10_minS =
        "\1\20\16\uffff";
    static final String DFA10_maxS =
        "\1\64\16\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA10_specialS =
        "\17\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\17\uffff\4\2\3\uffff"+
            "\4\2\3\uffff\1\1",
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
            return "248:20: ( Colon nodeValue )?";
        }
    }
    static final String DFA11_eotS =
        "\16\uffff";
    static final String DFA11_eofS =
        "\1\2\15\uffff";
    static final String DFA11_minS =
        "\1\20\15\uffff";
    static final String DFA11_maxS =
        "\1\60\15\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA11_specialS =
        "\16\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\17\uffff\1\2\1\1\2"+
            "\2\3\uffff\4\2",
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
            return "248:39: ( LParen attributeList RParen )?";
        }
    }
    static final String DFA12_eotS =
        "\15\uffff";
    static final String DFA12_eofS =
        "\1\2\14\uffff";
    static final String DFA12_minS =
        "\1\20\14\uffff";
    static final String DFA12_maxS =
        "\1\60\14\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA12_specialS =
        "\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\17\uffff\1\2\1\uffff"+
            "\1\2\1\1\3\uffff\4\2",
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

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "248:70: ( dataType )?";
        }
    }
    static final String DFA13_eotS =
        "\14\uffff";
    static final String DFA13_eofS =
        "\1\5\13\uffff";
    static final String DFA13_minS =
        "\1\20\13\uffff";
    static final String DFA13_maxS =
        "\1\60\13\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\6\uffff";
    static final String DFA13_specialS =
        "\14\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\17\uffff\1\1\1\uffff"+
            "\1\5\4\uffff\1\5\3\1",
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
            return "248:80: ( plural )?";
        }
    }
 

    public static final BitSet FOLLOW_node_in_schema767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silkLine_in_silkFile774 = new BitSet(new long[]{0x0000000000550002L});
    public static final BitSet FOLLOW_Preamble_in_silkLine795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BlankLine_in_silkLine800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DataLine_in_silkLine805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_silkLine810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nodeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inLineJSON_in_nodeValue832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonObject_in_inLineJSON850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonArray_in_inLineJSON855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonAtom_in_inLineJSON860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBrace_in_jsonObject871 = new BitSet(new long[]{0x0000102100000000L});
    public static final BitSet FOLLOW_jsonElement_in_jsonObject874 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_Comma_in_jsonObject877 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_jsonElement_in_jsonObject879 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_RBrace_in_jsonObject885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_jsonArray897 = new BitSet(new long[]{0x00200E2700000000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArray900 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_Comma_in_jsonArray903 = new BitSet(new long[]{0x00200A2700000000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonArray905 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_RBracket_in_jsonArray911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_jsonElement921 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Colon_in_jsonElement923 = new BitSet(new long[]{0x00200A2700000000L});
    public static final BitSet FOLLOW_jsonValue_in_jsonElement925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonAtom_in_jsonValue936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonObject_in_jsonValue941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonArray_in_jsonValue946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_jsonAtom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NodeStart_in_node991 = new BitSet(new long[]{0x0002002100000000L});
    public static final BitSet FOLLOW_coreNode_in_node994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_node998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeItem_in_coreNode1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeName_in_nodeItem1024 = new BitSet(new long[]{0x0011C2C000000002L});
    public static final BitSet FOLLOW_Colon_in_nodeItem1027 = new BitSet(new long[]{0x00200A2700000000L});
    public static final BitSet FOLLOW_nodeValue_in_nodeItem1029 = new BitSet(new long[]{0x0001C2C000000002L});
    public static final BitSet FOLLOW_LParen_in_nodeItem1034 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_attributeList_in_nodeItem1036 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RParen_in_nodeItem1038 = new BitSet(new long[]{0x0001C24000000002L});
    public static final BitSet FOLLOW_dataType_in_nodeItem1042 = new BitSet(new long[]{0x0001C04000000002L});
    public static final BitSet FOLLOW_plural_in_nodeItem1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_dataType1074 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_dataTypeName_in_dataType1077 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RBracket_in_dataType1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_dataTypeName1090 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Slash_in_dataTypeName1093 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_QName_in_dataTypeName1095 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1115 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1118 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_attributeItem_in_attributeList1121 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_nodeItem_in_attributeItem1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_plural1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_plural1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_plural1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SequenceIndicator_in_plural1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_At_in_function1195 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_QName_in_function1197 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LParen_in_function1199 = new BitSet(new long[]{0x0020012700000000L});
    public static final BitSet FOLLOW_functionArg_in_function1202 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_Comma_in_function1205 = new BitSet(new long[]{0x0020002700000000L});
    public static final BitSet FOLLOW_functionArg_in_function1207 = new BitSet(new long[]{0x0000210000000000L});
    public static final BitSet FOLLOW_RParen_in_function1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jsonAtom_in_functionArg1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_functionArg1245 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Colon_in_functionArg1247 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_NodeValue_in_functionArg1249 = new BitSet(new long[]{0x0000000000000002L});

}
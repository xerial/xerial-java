// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g 2009-01-07 19:36:02

/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
//--------------------------------------------------
// xerial-core project
// 
// ObjectSchemaParser.java
// Since  2008/10/06 15:45:00
// 
//--------------------------------------------------
package org.xerial.rel.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ObjectSchemaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ObjectSchema", "ObjectAttribute", "Name", "Value", "Occurrence", "Type", "NEWLINE", "Level", "AttributeIndicator", "Comma", "Dot", "LParen", "RParen", "LBracket", "RBracket", "TabbedValueIndicator", "Star", "Question", "Plus", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "QName", "Colon", "StringLiteral", "Literal", "DataType"
    };
    public static final int Type=9;
    public static final int DataType=32;
    public static final int NameChar=26;
    public static final int LBracket=17;
    public static final int Digit=24;
    public static final int ObjectAttribute=5;
    public static final int Star=20;
    public static final int Plus=22;
    public static final int RParen=16;
    public static final int Literal=31;
    public static final int StringLiteral=30;
    public static final int Occurrence=8;
    public static final int Name=6;
    public static final int NEWLINE=10;
    public static final int LParen=15;
    public static final int Letter=23;
    public static final int TabbedValueIndicator=19;
    public static final int Comma=13;
    public static final int Dot=14;
    public static final int QName=28;
    public static final int WhiteSpaceChar=27;
    public static final int EOF=-1;
    public static final int AttributeIndicator=12;
    public static final int Value=7;
    public static final int RBracket=18;
    public static final int ObjectSchema=4;
    public static final int Question=21;
    public static final int Digits=25;
    public static final int Colon=29;
    public static final int Level=11;

    // delegates
    // delegators


        public ObjectSchemaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ObjectSchemaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ObjectSchemaParser.tokenNames; }
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g"; }


    public static class schema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "schema"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:143:1: schema : ( objectSchema | attributeSchema );
    public final ObjectSchemaParser.schema_return schema() throws RecognitionException {
        ObjectSchemaParser.schema_return retval = new ObjectSchemaParser.schema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjectSchemaParser.objectSchema_return objectSchema1 = null;

        ObjectSchemaParser.attributeSchema_return attributeSchema2 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:143:7: ( objectSchema | attributeSchema )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Level) ) {
                alt1=1;
            }
            else if ( (LA1_0==AttributeIndicator) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:143:9: objectSchema
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objectSchema_in_schema371);
                    objectSchema1=objectSchema();

                    state._fsp--;

                    adaptor.addChild(root_0, objectSchema1.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:143:24: attributeSchema
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attributeSchema_in_schema375);
                    attributeSchema2=attributeSchema();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeSchema2.getTree());

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
    // $ANTLR end "schema"

    public static class objectSchema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectSchema"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:1: objectSchema : ( Level )+ QName ( LParen attributeList RParen )? -> ^( ObjectSchema ( Level )+ Name[$QName.text] ( attributeList )? ) ;
    public final ObjectSchemaParser.objectSchema_return objectSchema() throws RecognitionException {
        ObjectSchemaParser.objectSchema_return retval = new ObjectSchemaParser.objectSchema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Level3=null;
        Token QName4=null;
        Token LParen5=null;
        Token RParen7=null;
        ObjectSchemaParser.attributeList_return attributeList6 = null;


        Object Level3_tree=null;
        Object QName4_tree=null;
        Object LParen5_tree=null;
        Object RParen7_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_Level=new RewriteRuleTokenStream(adaptor,"token Level");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:13: ( ( Level )+ QName ( LParen attributeList RParen )? -> ^( ObjectSchema ( Level )+ Name[$QName.text] ( attributeList )? ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:15: ( Level )+ QName ( LParen attributeList RParen )?
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:15: ( Level )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Level) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:15: Level
            	    {
            	    Level3=(Token)match(input,Level,FOLLOW_Level_in_objectSchema382);  
            	    stream_Level.add(Level3);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            QName4=(Token)match(input,QName,FOLLOW_QName_in_objectSchema385);  
            stream_QName.add(QName4);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:28: ( LParen attributeList RParen )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LParen) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:145:29: LParen attributeList RParen
                    {
                    LParen5=(Token)match(input,LParen,FOLLOW_LParen_in_objectSchema388);  
                    stream_LParen.add(LParen5);

                    pushFollow(FOLLOW_attributeList_in_objectSchema390);
                    attributeList6=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList6.getTree());
                    RParen7=(Token)match(input,RParen,FOLLOW_RParen_in_objectSchema392);  
                    stream_RParen.add(RParen7);


                    }
                    break;

            }



            // AST REWRITE
            // elements: attributeList, Level
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 146:2: -> ^( ObjectSchema ( Level )+ Name[$QName.text] ( attributeList )? )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:146:5: ^( ObjectSchema ( Level )+ Name[$QName.text] ( attributeList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ObjectSchema, "ObjectSchema"), root_1);

                if ( !(stream_Level.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_Level.hasNext() ) {
                    adaptor.addChild(root_1, stream_Level.nextNode());

                }
                stream_Level.reset();
                adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName4!=null?QName4.getText():null)));
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:146:45: ( attributeList )?
                if ( stream_attributeList.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeList.nextTree());

                }
                stream_attributeList.reset();

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
    // $ANTLR end "objectSchema"

    public static class attributeSchema_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeSchema"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:149:1: attributeSchema : AttributeIndicator attributeList -> attributeList ;
    public final ObjectSchemaParser.attributeSchema_return attributeSchema() throws RecognitionException {
        ObjectSchemaParser.attributeSchema_return retval = new ObjectSchemaParser.attributeSchema_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AttributeIndicator8=null;
        ObjectSchemaParser.attributeList_return attributeList9 = null;


        Object AttributeIndicator8_tree=null;
        RewriteRuleTokenStream stream_AttributeIndicator=new RewriteRuleTokenStream(adaptor,"token AttributeIndicator");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:149:16: ( AttributeIndicator attributeList -> attributeList )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:149:18: AttributeIndicator attributeList
            {
            AttributeIndicator8=(Token)match(input,AttributeIndicator,FOLLOW_AttributeIndicator_in_attributeSchema419);  
            stream_AttributeIndicator.add(AttributeIndicator8);

            pushFollow(FOLLOW_attributeList_in_attributeSchema421);
            attributeList9=attributeList();

            state._fsp--;

            stream_attributeList.add(attributeList9.getTree());


            // AST REWRITE
            // elements: attributeList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 149:51: -> attributeList
            {
                adaptor.addChild(root_0, stream_attributeList.nextTree());

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
    // $ANTLR end "attributeSchema"

    public static class attributeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeList"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:152:1: attributeList : attribute ( Comma attribute )* ;
    public final ObjectSchemaParser.attributeList_return attributeList() throws RecognitionException {
        ObjectSchemaParser.attributeList_return retval = new ObjectSchemaParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma11=null;
        ObjectSchemaParser.attribute_return attribute10 = null;

        ObjectSchemaParser.attribute_return attribute12 = null;


        Object Comma11_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:152:14: ( attribute ( Comma attribute )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:152:16: attribute ( Comma attribute )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_attribute_in_attributeList439);
            attribute10=attribute();

            state._fsp--;

            adaptor.addChild(root_0, attribute10.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:152:26: ( Comma attribute )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Comma) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:152:27: Comma attribute
            	    {
            	    Comma11=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList442); 
            	    pushFollow(FOLLOW_attribute_in_attributeList445);
            	    attribute12=attribute();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attribute12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:155:1: attribute : ( QName ( DataType )? ( attributeOption )? -> ^( ObjectAttribute Name[$QName.text] ( DataType )? ( attributeOption )? ) | QName LParen attributeList RParen ( attributeOption )? -> ^( ObjectSchema Name[$QName.text] attributeList ( attributeOption )? ) );
    public final ObjectSchemaParser.attribute_return attribute() throws RecognitionException {
        ObjectSchemaParser.attribute_return retval = new ObjectSchemaParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName13=null;
        Token DataType14=null;
        Token QName16=null;
        Token LParen17=null;
        Token RParen19=null;
        ObjectSchemaParser.attributeOption_return attributeOption15 = null;

        ObjectSchemaParser.attributeList_return attributeList18 = null;

        ObjectSchemaParser.attributeOption_return attributeOption20 = null;


        Object QName13_tree=null;
        Object DataType14_tree=null;
        Object QName16_tree=null;
        Object LParen17_tree=null;
        Object RParen19_tree=null;
        RewriteRuleTokenStream stream_DataType=new RewriteRuleTokenStream(adaptor,"token DataType");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_attributeOption=new RewriteRuleSubtreeStream(adaptor,"rule attributeOption");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:2: ( QName ( DataType )? ( attributeOption )? -> ^( ObjectAttribute Name[$QName.text] ( DataType )? ( attributeOption )? ) | QName LParen attributeList RParen ( attributeOption )? -> ^( ObjectSchema Name[$QName.text] attributeList ( attributeOption )? ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:4: QName ( DataType )? ( attributeOption )?
                    {
                    QName13=(Token)match(input,QName,FOLLOW_QName_in_attribute458);  
                    stream_QName.add(QName13);

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:10: ( DataType )?
                    int alt5=2;
                    alt5 = dfa5.predict(input);
                    switch (alt5) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:10: DataType
                            {
                            DataType14=(Token)match(input,DataType,FOLLOW_DataType_in_attribute460);  
                            stream_DataType.add(DataType14);


                            }
                            break;

                    }

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:20: ( attributeOption )?
                    int alt6=2;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:156:20: attributeOption
                            {
                            pushFollow(FOLLOW_attributeOption_in_attribute463);
                            attributeOption15=attributeOption();

                            state._fsp--;

                            stream_attributeOption.add(attributeOption15.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: DataType, attributeOption
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 157:2: -> ^( ObjectAttribute Name[$QName.text] ( DataType )? ( attributeOption )? )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:157:5: ^( ObjectAttribute Name[$QName.text] ( DataType )? ( attributeOption )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ObjectAttribute, "ObjectAttribute"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName13!=null?QName13.getText():null)));
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:157:41: ( DataType )?
                        if ( stream_DataType.hasNext() ) {
                            adaptor.addChild(root_1, stream_DataType.nextNode());

                        }
                        stream_DataType.reset();
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:157:51: ( attributeOption )?
                        if ( stream_attributeOption.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeOption.nextTree());

                        }
                        stream_attributeOption.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:158:4: QName LParen attributeList RParen ( attributeOption )?
                    {
                    QName16=(Token)match(input,QName,FOLLOW_QName_in_attribute486);  
                    stream_QName.add(QName16);

                    LParen17=(Token)match(input,LParen,FOLLOW_LParen_in_attribute488);  
                    stream_LParen.add(LParen17);

                    pushFollow(FOLLOW_attributeList_in_attribute490);
                    attributeList18=attributeList();

                    state._fsp--;

                    stream_attributeList.add(attributeList18.getTree());
                    RParen19=(Token)match(input,RParen,FOLLOW_RParen_in_attribute492);  
                    stream_RParen.add(RParen19);

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:158:38: ( attributeOption )?
                    int alt7=2;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:158:38: attributeOption
                            {
                            pushFollow(FOLLOW_attributeOption_in_attribute494);
                            attributeOption20=attributeOption();

                            state._fsp--;

                            stream_attributeOption.add(attributeOption20.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: attributeOption, attributeList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 159:2: -> ^( ObjectSchema Name[$QName.text] attributeList ( attributeOption )? )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:159:5: ^( ObjectSchema Name[$QName.text] attributeList ( attributeOption )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ObjectSchema, "ObjectSchema"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(Name, (QName16!=null?QName16.getText():null)));
                        adaptor.addChild(root_1, stream_attributeList.nextTree());
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:159:52: ( attributeOption )?
                        if ( stream_attributeOption.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeOption.nextTree());

                        }
                        stream_attributeOption.reset();

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
    // $ANTLR end "attribute"

    public static class attributeOption_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeOption"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:163:1: attributeOption : ( attributePlural | StringLiteral -> Value[$StringLiteral.text] | Literal -> Value[$Literal.text] );
    public final ObjectSchemaParser.attributeOption_return attributeOption() throws RecognitionException {
        ObjectSchemaParser.attributeOption_return retval = new ObjectSchemaParser.attributeOption_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral22=null;
        Token Literal23=null;
        ObjectSchemaParser.attributePlural_return attributePlural21 = null;


        Object StringLiteral22_tree=null;
        Object Literal23_tree=null;
        RewriteRuleTokenStream stream_Literal=new RewriteRuleTokenStream(adaptor,"token Literal");
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:164:2: ( attributePlural | StringLiteral -> Value[$StringLiteral.text] | Literal -> Value[$Literal.text] )
            int alt9=3;
            switch ( input.LA(1) ) {
            case Level:
            case TabbedValueIndicator:
            case Star:
            case Question:
            case Plus:
                {
                alt9=1;
                }
                break;
            case StringLiteral:
                {
                alt9=2;
                }
                break;
            case Literal:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:164:4: attributePlural
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attributePlural_in_attributeOption524);
                    attributePlural21=attributePlural();

                    state._fsp--;

                    adaptor.addChild(root_0, attributePlural21.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:165:4: StringLiteral
                    {
                    StringLiteral22=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_attributeOption529);  
                    stream_StringLiteral.add(StringLiteral22);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 165:18: -> Value[$StringLiteral.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, (StringLiteral22!=null?StringLiteral22.getText():null)));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:166:4: Literal
                    {
                    Literal23=(Token)match(input,Literal,FOLLOW_Literal_in_attributeOption539);  
                    stream_Literal.add(Literal23);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 166:12: -> Value[$Literal.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Value, (Literal23!=null?Literal23.getText():null)));

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
    // $ANTLR end "attributeOption"

    public static class attributePlural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributePlural"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:169:1: attributePlural : ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Level -> Occurrence[\"SEQUENCE\"] | TabbedValueIndicator -> Occurrence[\"TABBED_SEQUENCE\"] );
    public final ObjectSchemaParser.attributePlural_return attributePlural() throws RecognitionException {
        ObjectSchemaParser.attributePlural_return retval = new ObjectSchemaParser.attributePlural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Star24=null;
        Token Plus25=null;
        Token Question26=null;
        Token Level27=null;
        Token TabbedValueIndicator28=null;

        Object Star24_tree=null;
        Object Plus25_tree=null;
        Object Question26_tree=null;
        Object Level27_tree=null;
        Object TabbedValueIndicator28_tree=null;
        RewriteRuleTokenStream stream_Plus=new RewriteRuleTokenStream(adaptor,"token Plus");
        RewriteRuleTokenStream stream_TabbedValueIndicator=new RewriteRuleTokenStream(adaptor,"token TabbedValueIndicator");
        RewriteRuleTokenStream stream_Question=new RewriteRuleTokenStream(adaptor,"token Question");
        RewriteRuleTokenStream stream_Star=new RewriteRuleTokenStream(adaptor,"token Star");
        RewriteRuleTokenStream stream_Level=new RewriteRuleTokenStream(adaptor,"token Level");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:170:2: ( Star -> Occurrence[\"ZERO_OR_MORE\"] | Plus -> Occurrence[\"ONE_OR_MORE\"] | Question -> Occurrence[\"ZERO_OR_ONE\"] | Level -> Occurrence[\"SEQUENCE\"] | TabbedValueIndicator -> Occurrence[\"TABBED_SEQUENCE\"] )
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
            case Level:
                {
                alt10=4;
                }
                break;
            case TabbedValueIndicator:
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
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:170:4: Star
                    {
                    Star24=(Token)match(input,Star,FOLLOW_Star_in_attributePlural555);  
                    stream_Star.add(Star24);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 170:9: -> Occurrence[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:171:4: Plus
                    {
                    Plus25=(Token)match(input,Plus,FOLLOW_Plus_in_attributePlural565);  
                    stream_Plus.add(Plus25);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 171:9: -> Occurrence[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ONE_OR_MORE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:172:4: Question
                    {
                    Question26=(Token)match(input,Question,FOLLOW_Question_in_attributePlural575);  
                    stream_Question.add(Question26);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 172:13: -> Occurrence[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:173:4: Level
                    {
                    Level27=(Token)match(input,Level,FOLLOW_Level_in_attributePlural585);  
                    stream_Level.add(Level27);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 173:10: -> Occurrence[\"SEQUENCE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(Occurrence, "SEQUENCE"));

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\rel\\impl\\ObjectSchema.g:174:4: TabbedValueIndicator
                    {
                    TabbedValueIndicator28=(Token)match(input,TabbedValueIndicator,FOLLOW_TabbedValueIndicator_in_attributePlural595);  
                    stream_TabbedValueIndicator.add(TabbedValueIndicator28);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 174:25: -> Occurrence[\"TABBED_SEQUENCE\"]
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
    // $ANTLR end "attributePlural"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA8_eotS =
        "\16\uffff";
    static final String DFA8_eofS =
        "\1\uffff\1\3\14\uffff";
    static final String DFA8_minS =
        "\1\34\1\13\14\uffff";
    static final String DFA8_maxS =
        "\1\34\1\40\14\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\1\12\uffff";
    static final String DFA8_specialS =
        "\16\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\1\3\1\uffff\1\3\1\uffff\1\2\1\3\2\uffff\4\3\7\uffff\3\3",
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
            return "155:1: attribute : ( QName ( DataType )? ( attributeOption )? -> ^( ObjectAttribute Name[$QName.text] ( DataType )? ( attributeOption )? ) | QName LParen attributeList RParen ( attributeOption )? -> ^( ObjectSchema Name[$QName.text] attributeList ( attributeOption )? ) );";
        }
    }
    static final String DFA5_eotS =
        "\14\uffff";
    static final String DFA5_eofS =
        "\1\2\13\uffff";
    static final String DFA5_minS =
        "\1\13\13\uffff";
    static final String DFA5_maxS =
        "\1\40\13\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA5_specialS =
        "\14\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\1\2\2\uffff\4\2\7\uffff\2\2\1\1",
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
            return "156:10: ( DataType )?";
        }
    }
    static final String DFA6_eotS =
        "\13\uffff";
    static final String DFA6_eofS =
        "\1\10\12\uffff";
    static final String DFA6_minS =
        "\1\13\12\uffff";
    static final String DFA6_maxS =
        "\1\37\12\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\2\uffff";
    static final String DFA6_specialS =
        "\13\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\1\uffff\1\10\2\uffff\1\10\2\uffff\4\1\7\uffff\2\1",
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
            return "156:20: ( attributeOption )?";
        }
    }
    static final String DFA7_eotS =
        "\13\uffff";
    static final String DFA7_eofS =
        "\1\10\12\uffff";
    static final String DFA7_minS =
        "\1\13\12\uffff";
    static final String DFA7_maxS =
        "\1\37\12\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\2\uffff";
    static final String DFA7_specialS =
        "\13\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\uffff\1\10\2\uffff\1\10\2\uffff\4\1\7\uffff\2\1",
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
            return "158:38: ( attributeOption )?";
        }
    }
 

    public static final BitSet FOLLOW_objectSchema_in_schema371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeSchema_in_schema375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Level_in_objectSchema382 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_QName_in_objectSchema385 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LParen_in_objectSchema388 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attributeList_in_objectSchema390 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RParen_in_objectSchema392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AttributeIndicator_in_attributeSchema419 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attributeList_in_attributeSchema421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributeList439 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_Comma_in_attributeList442 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attribute_in_attributeList445 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_QName_in_attribute458 = new BitSet(new long[]{0x00000001C0780802L});
    public static final BitSet FOLLOW_DataType_in_attribute460 = new BitSet(new long[]{0x00000000C0780802L});
    public static final BitSet FOLLOW_attributeOption_in_attribute463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attribute486 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LParen_in_attribute488 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attributeList_in_attribute490 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RParen_in_attribute492 = new BitSet(new long[]{0x00000000C0780802L});
    public static final BitSet FOLLOW_attributeOption_in_attribute494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributePlural_in_attributeOption524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_attributeOption529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Literal_in_attributeOption539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Star_in_attributePlural555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Plus_in_attributePlural565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Question_in_attributePlural575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Level_in_attributePlural585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TabbedValueIndicator_in_attributePlural595 = new BitSet(new long[]{0x0000000000000002L});

}
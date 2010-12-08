// $ANTLR 3.1.1 c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g 2009-02-22 13:02:53

/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// Xerial -- Transactional XML Database System      
// 
// AmoebaQueryParser.java
// Since  2005/10/27 23:17:42
// 
//--------------------------------------------------
package org.xerial.amoeba.query.impl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class AmoebaQueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "SELECTION", "CONDITION", "PROJECTION", "PROJECT_ALL", "ORDER_BY", "REF_ALL", "TARGET", "FUNCTION", "AND", "OR", "INPUT", "OUTPUT", "ASSIGN_LABEL", "COMPARE", "ATTRIBUTE", "REF", "VALUE", "CONTAINED_IN", "RELATION", "INSERT", "VALUE_SET", "NEW_VALUE", "NEW_RELATION", "UPDATE", "ATTRIBUTE_DEF", "SORT_TARGET", "ONE_TO_MANY", "ONE_TO_ONE", "OBJECT_DEF", "OBJECT", "LANG", "ML_COMMENT", "LINE_COMMENT", "Dot", "Colon", "Comma", "RParen", "LParen", "Quot", "Apos", "At", "Wildcard", "EQUAL", "NOT_EQUAL", "LESS", "LEQ", "GREATER", "GEQ", "SPLIT", "Select", "From", "Where", "In", "Insert", "Into", "Object", "Relationship", "HasMany", "HasOne", "DIVIDE", "DISTINCT", "RANGE", "DataType", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "Quot_s", "Apos_s", "StringLiteral", "Name", "QName", "'by'", "'auto'", "'AUTO'", "'update'", "'set'", "'{'", "'}'", "'as'", "'order'", "'or'", "'and'", "'like'"
    };
    public static final int DataType=68;
    public static final int OUTPUT=17;
    public static final int T__86=86;
    public static final int LANG=36;
    public static final int INPUT=16;
    public static final int Quot_s=74;
    public static final int Digit=70;
    public static final int Apos=45;
    public static final int Relationship=62;
    public static final int T__80=80;
    public static final int NUMBER=4;
    public static final int TARGET=12;
    public static final int LEQ=51;
    public static final int PROJECT_ALL=9;
    public static final int REF=21;
    public static final int VALUE_SET=26;
    public static final int GEQ=53;
    public static final int VALUE=22;
    public static final int OR=15;
    public static final int T__87=87;
    public static final int Letter=69;
    public static final int DIVIDE=65;
    public static final int AND=14;
    public static final int Insert=59;
    public static final int LESS=50;
    public static final int Comma=41;
    public static final int FUNCTION=13;
    public static final int Dot=39;
    public static final int Into=60;
    public static final int Object=61;
    public static final int CONDITION=7;
    public static final int ATTRIBUTE_DEF=30;
    public static final int ONE_TO_ONE=33;
    public static final int OBJECT_DEF=34;
    public static final int GREATER=52;
    public static final int HasMany=63;
    public static final int ML_COMMENT=37;
    public static final int Colon=40;
    public static final int NEW_VALUE=27;
    public static final int At=46;
    public static final int NOT_EQUAL=49;
    public static final int DISTINCT=66;
    public static final int OBJECT=35;
    public static final int NameChar=72;
    public static final int RANGE=67;
    public static final int SPLIT=54;
    public static final int T__89=89;
    public static final int CONTAINED_IN=23;
    public static final int Wildcard=47;
    public static final int ORDER_BY=10;
    public static final int STRING=5;
    public static final int T__79=79;
    public static final int NEW_RELATION=28;
    public static final int Where=57;
    public static final int RELATION=24;
    public static final int UPDATE=29;
    public static final int RParen=42;
    public static final int StringLiteral=76;
    public static final int Apos_s=75;
    public static final int T__88=88;
    public static final int LINE_COMMENT=38;
    public static final int In=58;
    public static final int Name=77;
    public static final int LParen=43;
    public static final int HasOne=64;
    public static final int From=56;
    public static final int T__90=90;
    public static final int T__84=84;
    public static final int Select=55;
    public static final int EQUAL=48;
    public static final int COMPARE=19;
    public static final int REF_ALL=11;
    public static final int QName=78;
    public static final int ONE_TO_MANY=32;
    public static final int WhiteSpaceChar=73;
    public static final int SELECTION=6;
    public static final int EOF=-1;
    public static final int T__85=85;
    public static final int T__82=82;
    public static final int T__81=81;
    public static final int PROJECTION=8;
    public static final int Quot=44;
    public static final int ATTRIBUTE=20;
    public static final int T__83=83;
    public static final int Digits=71;
    public static final int INSERT=25;
    public static final int SORT_TARGET=31;
    public static final int ASSIGN_LABEL=18;

    // delegates
    // delegators


        public AmoebaQueryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AmoebaQueryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return AmoebaQueryParser.tokenNames; }
    public String getGrammarFileName() { return "c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g"; }


    public static class integerLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integerLiteral"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:217:1: integerLiteral : Digits ;
    public final AmoebaQueryParser.integerLiteral_return integerLiteral() throws RecognitionException {
        AmoebaQueryParser.integerLiteral_return retval = new AmoebaQueryParser.integerLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Digits1=null;

        Object Digits1_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:217:15: ( Digits )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:217:17: Digits
            {
            root_0 = (Object)adaptor.nil();

            Digits1=(Token)match(input,Digits,FOLLOW_Digits_in_integerLiteral747); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Digits1_tree = (Object)adaptor.create(Digits1);
            adaptor.addChild(root_0, Digits1_tree);
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
    // $ANTLR end "integerLiteral"

    public static class decimalLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decimalLiteral"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:218:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );
    public final AmoebaQueryParser.decimalLiteral_return decimalLiteral() throws RecognitionException {
        AmoebaQueryParser.decimalLiteral_return retval = new AmoebaQueryParser.decimalLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Dot2=null;
        Token Digits3=null;
        Token Digits4=null;
        Token Dot5=null;
        Token Digits6=null;

        Object Dot2_tree=null;
        Object Digits3_tree=null;
        Object Digits4_tree=null;
        Object Dot5_tree=null;
        Object Digits6_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:218:15: ( Dot Digits | Digits Dot Digits )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Dot) ) {
                alt1=1;
            }
            else if ( (LA1_0==Digits) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:218:17: Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Dot2=(Token)match(input,Dot,FOLLOW_Dot_in_decimalLiteral753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Dot2_tree = (Object)adaptor.create(Dot2);
                    adaptor.addChild(root_0, Dot2_tree);
                    }
                    Digits3=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Digits3_tree = (Object)adaptor.create(Digits3);
                    adaptor.addChild(root_0, Digits3_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:218:29: Digits Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Digits4=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Digits4_tree = (Object)adaptor.create(Digits4);
                    adaptor.addChild(root_0, Digits4_tree);
                    }
                    Dot5=(Token)match(input,Dot,FOLLOW_Dot_in_decimalLiteral760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Dot5_tree = (Object)adaptor.create(Dot5);
                    adaptor.addChild(root_0, Dot5_tree);
                    }
                    Digits6=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral762); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Digits6_tree = (Object)adaptor.create(Digits6);
                    adaptor.addChild(root_0, Digits6_tree);
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
    // $ANTLR end "decimalLiteral"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:221:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );
    public final AmoebaQueryParser.literal_return literal() throws RecognitionException {
        AmoebaQueryParser.literal_return retval = new AmoebaQueryParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral8=null;
        AmoebaQueryParser.numericLiteral_return numericLiteral7 = null;


        Object StringLiteral8_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleSubtreeStream stream_numericLiteral=new RewriteRuleSubtreeStream(adaptor,"rule numericLiteral");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:221:8: ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:222:2: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:222:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal774);
                    numericLiteral7=numericLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_numericLiteral.add(numericLiteral7.getTree());


                    // AST REWRITE
                    // elements: numericLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 222:19: -> ^( NUMBER numericLiteral )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:222:22: ^( NUMBER numericLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NUMBER, "NUMBER"), root_1);

                        adaptor.addChild(root_1, stream_numericLiteral.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:223:4: StringLiteral
                    {
                    StringLiteral8=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal787); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral8);



                    // AST REWRITE
                    // elements: StringLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 223:18: -> ^( STRING StringLiteral )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:223:21: ^( STRING StringLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.nextNode());

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
    // $ANTLR end "literal"

    public static class numericLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numericLiteral"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:226:1: numericLiteral : ( integerLiteral | decimalLiteral );
    public final AmoebaQueryParser.numericLiteral_return numericLiteral() throws RecognitionException {
        AmoebaQueryParser.numericLiteral_return retval = new AmoebaQueryParser.numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.integerLiteral_return integerLiteral9 = null;

        AmoebaQueryParser.decimalLiteral_return decimalLiteral10 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:227:2: ( integerLiteral | decimalLiteral )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:227:4: integerLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integerLiteral_in_numericLiteral807);
                    integerLiteral9=integerLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, integerLiteral9.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:228:4: decimalLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decimalLiteral_in_numericLiteral813);
                    decimalLiteral10=decimalLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decimalLiteral10.getTree());

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
    // $ANTLR end "numericLiteral"

    public static class lang_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lang"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:233:1: lang : ( | ( expr )+ -> ^( LANG ( expr )+ ) );
    public final AmoebaQueryParser.lang_return lang() throws RecognitionException {
        AmoebaQueryParser.lang_return retval = new AmoebaQueryParser.lang_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.expr_return expr11 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:233:5: ( | ( expr )+ -> ^( LANG ( expr )+ ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==EOF) ) {
                alt5=1;
            }
            else if ( (LA5_0==Select||LA5_0==Insert||(LA5_0>=Object && LA5_0<=Relationship)||LA5_0==DIVIDE||LA5_0==82) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:234:2: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:234:4: ( expr )+
                    {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:234:4: ( expr )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==Select||LA4_0==Insert||(LA4_0>=Object && LA4_0<=Relationship)||LA4_0==DIVIDE||LA4_0==82) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:234:4: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_lang828);
                    	    expr11=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr11.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 234:10: -> ^( LANG ( expr )+ )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:234:13: ^( LANG ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LANG, "LANG"), root_1);

                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

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
    // $ANTLR end "lang"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:237:1: expr : ( objectDefExpr | amoebaQuery | relationshipExpr | divideExpr );
    public final AmoebaQueryParser.expr_return expr() throws RecognitionException {
        AmoebaQueryParser.expr_return retval = new AmoebaQueryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.objectDefExpr_return objectDefExpr12 = null;

        AmoebaQueryParser.amoebaQuery_return amoebaQuery13 = null;

        AmoebaQueryParser.relationshipExpr_return relationshipExpr14 = null;

        AmoebaQueryParser.divideExpr_return divideExpr15 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:238:2: ( objectDefExpr | amoebaQuery | relationshipExpr | divideExpr )
            int alt6=4;
            switch ( input.LA(1) ) {
            case Object:
                {
                alt6=1;
                }
                break;
            case Select:
            case Insert:
            case 82:
                {
                alt6=2;
                }
                break;
            case Relationship:
                {
                alt6=3;
                }
                break;
            case DIVIDE:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:238:4: objectDefExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objectDefExpr_in_expr849);
                    objectDefExpr12=objectDefExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objectDefExpr12.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:239:4: amoebaQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_amoebaQuery_in_expr854);
                    amoebaQuery13=amoebaQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, amoebaQuery13.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:240:4: relationshipExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relationshipExpr_in_expr859);
                    relationshipExpr14=relationshipExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationshipExpr14.getTree());

                    }
                    break;
                case 4 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:241:4: divideExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_divideExpr_in_expr864);
                    divideExpr15=divideExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, divideExpr15.getTree());

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
    // $ANTLR end "expr"

    public static class divideExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "divideExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:245:1: divideExpr : DIVIDE QName 'by' divideElem ( Comma divideElem )* -> ^( DIVIDE[$QName] ( divideElem )+ ) ;
    public final AmoebaQueryParser.divideExpr_return divideExpr() throws RecognitionException {
        AmoebaQueryParser.divideExpr_return retval = new AmoebaQueryParser.divideExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DIVIDE16=null;
        Token QName17=null;
        Token string_literal18=null;
        Token Comma20=null;
        AmoebaQueryParser.divideElem_return divideElem19 = null;

        AmoebaQueryParser.divideElem_return divideElem21 = null;


        Object DIVIDE16_tree=null;
        Object QName17_tree=null;
        Object string_literal18_tree=null;
        Object Comma20_tree=null;
        RewriteRuleTokenStream stream_DIVIDE=new RewriteRuleTokenStream(adaptor,"token DIVIDE");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_divideElem=new RewriteRuleSubtreeStream(adaptor,"rule divideElem");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:246:2: ( DIVIDE QName 'by' divideElem ( Comma divideElem )* -> ^( DIVIDE[$QName] ( divideElem )+ ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:246:4: DIVIDE QName 'by' divideElem ( Comma divideElem )*
            {
            DIVIDE16=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_divideExpr877); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DIVIDE.add(DIVIDE16);

            QName17=(Token)match(input,QName,FOLLOW_QName_in_divideExpr879); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName17);

            string_literal18=(Token)match(input,79,FOLLOW_79_in_divideExpr881); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal18);

            pushFollow(FOLLOW_divideElem_in_divideExpr883);
            divideElem19=divideElem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_divideElem.add(divideElem19.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:246:33: ( Comma divideElem )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:246:34: Comma divideElem
            	    {
            	    Comma20=(Token)match(input,Comma,FOLLOW_Comma_in_divideExpr886); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma20);

            	    pushFollow(FOLLOW_divideElem_in_divideExpr888);
            	    divideElem21=divideElem();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_divideElem.add(divideElem21.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);



            // AST REWRITE
            // elements: DIVIDE, divideElem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:4: -> ^( DIVIDE[$QName] ( divideElem )+ )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:247:7: ^( DIVIDE[$QName] ( divideElem )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIVIDE, QName17), root_1);

                if ( !(stream_divideElem.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_divideElem.hasNext() ) {
                    adaptor.addChild(root_1, stream_divideElem.nextTree());

                }
                stream_divideElem.reset();

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
    // $ANTLR end "divideExpr"

    public static class divideElem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "divideElem"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:250:1: divideElem : ( DISTINCT QName -> ^( DISTINCT[$QName] ) | RANGE QName ( rangeType )? -> ^( RANGE[$QName] ( rangeType )? ) );
    public final AmoebaQueryParser.divideElem_return divideElem() throws RecognitionException {
        AmoebaQueryParser.divideElem_return retval = new AmoebaQueryParser.divideElem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DISTINCT22=null;
        Token QName23=null;
        Token RANGE24=null;
        Token QName25=null;
        AmoebaQueryParser.rangeType_return rangeType26 = null;


        Object DISTINCT22_tree=null;
        Object QName23_tree=null;
        Object RANGE24_tree=null;
        Object QName25_tree=null;
        RewriteRuleTokenStream stream_DISTINCT=new RewriteRuleTokenStream(adaptor,"token DISTINCT");
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_rangeType=new RewriteRuleSubtreeStream(adaptor,"rule rangeType");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:251:2: ( DISTINCT QName -> ^( DISTINCT[$QName] ) | RANGE QName ( rangeType )? -> ^( RANGE[$QName] ( rangeType )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DISTINCT) ) {
                alt9=1;
            }
            else if ( (LA9_0==RANGE) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:251:4: DISTINCT QName
                    {
                    DISTINCT22=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_divideElem915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DISTINCT.add(DISTINCT22);

                    QName23=(Token)match(input,QName,FOLLOW_QName_in_divideElem917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(QName23);



                    // AST REWRITE
                    // elements: DISTINCT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 251:19: -> ^( DISTINCT[$QName] )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:251:22: ^( DISTINCT[$QName] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DISTINCT, QName23), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:252:4: RANGE QName ( rangeType )?
                    {
                    RANGE24=(Token)match(input,RANGE,FOLLOW_RANGE_in_divideElem929); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RANGE.add(RANGE24);

                    QName25=(Token)match(input,QName,FOLLOW_QName_in_divideElem931); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(QName25);

                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:252:16: ( rangeType )?
                    int alt8=2;
                    alt8 = dfa8.predict(input);
                    switch (alt8) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:252:16: rangeType
                            {
                            pushFollow(FOLLOW_rangeType_in_divideElem933);
                            rangeType26=rangeType();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_rangeType.add(rangeType26.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: rangeType, RANGE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 252:27: -> ^( RANGE[$QName] ( rangeType )? )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:252:30: ^( RANGE[$QName] ( rangeType )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RANGE, QName25), root_1);

                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:252:46: ( rangeType )?
                        if ( stream_rangeType.hasNext() ) {
                            adaptor.addChild(root_1, stream_rangeType.nextTree());

                        }
                        stream_rangeType.reset();

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
    // $ANTLR end "divideElem"

    public static class rangeType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rangeType"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:255:1: rangeType : ( 'auto' | 'AUTO' );
    public final AmoebaQueryParser.rangeType_return rangeType() throws RecognitionException {
        AmoebaQueryParser.rangeType_return retval = new AmoebaQueryParser.rangeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set27=null;

        Object set27_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:256:2: ( 'auto' | 'AUTO' )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:
            {
            root_0 = (Object)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=80 && input.LA(1)<=81) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set27));
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
    // $ANTLR end "rangeType"

    public static class relationshipExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationshipExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:259:1: relationshipExpr : ( Relationship obj= QName HasMany objectList -> ^( ONE_TO_MANY[$obj] objectList ) | Relationship obj2= QName HasOne objectList -> ^( ONE_TO_ONE[$obj2] objectList ) );
    public final AmoebaQueryParser.relationshipExpr_return relationshipExpr() throws RecognitionException {
        AmoebaQueryParser.relationshipExpr_return retval = new AmoebaQueryParser.relationshipExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token obj=null;
        Token obj2=null;
        Token Relationship28=null;
        Token HasMany29=null;
        Token Relationship31=null;
        Token HasOne32=null;
        AmoebaQueryParser.objectList_return objectList30 = null;

        AmoebaQueryParser.objectList_return objectList33 = null;


        Object obj_tree=null;
        Object obj2_tree=null;
        Object Relationship28_tree=null;
        Object HasMany29_tree=null;
        Object Relationship31_tree=null;
        Object HasOne32_tree=null;
        RewriteRuleTokenStream stream_HasOne=new RewriteRuleTokenStream(adaptor,"token HasOne");
        RewriteRuleTokenStream stream_HasMany=new RewriteRuleTokenStream(adaptor,"token HasMany");
        RewriteRuleTokenStream stream_Relationship=new RewriteRuleTokenStream(adaptor,"token Relationship");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_objectList=new RewriteRuleSubtreeStream(adaptor,"rule objectList");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:260:2: ( Relationship obj= QName HasMany objectList -> ^( ONE_TO_MANY[$obj] objectList ) | Relationship obj2= QName HasOne objectList -> ^( ONE_TO_ONE[$obj2] objectList ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Relationship) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==QName) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==HasMany) ) {
                        alt10=1;
                    }
                    else if ( (LA10_2==HasOne) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:260:4: Relationship obj= QName HasMany objectList
                    {
                    Relationship28=(Token)match(input,Relationship,FOLLOW_Relationship_in_relationshipExpr970); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Relationship.add(Relationship28);

                    obj=(Token)match(input,QName,FOLLOW_QName_in_relationshipExpr974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(obj);

                    HasMany29=(Token)match(input,HasMany,FOLLOW_HasMany_in_relationshipExpr976); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HasMany.add(HasMany29);

                    pushFollow(FOLLOW_objectList_in_relationshipExpr978);
                    objectList30=objectList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_objectList.add(objectList30.getTree());


                    // AST REWRITE
                    // elements: objectList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 261:3: -> ^( ONE_TO_MANY[$obj] objectList )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:261:6: ^( ONE_TO_MANY[$obj] objectList )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONE_TO_MANY, obj), root_1);

                        adaptor.addChild(root_1, stream_objectList.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:262:4: Relationship obj2= QName HasOne objectList
                    {
                    Relationship31=(Token)match(input,Relationship,FOLLOW_Relationship_in_relationshipExpr994); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Relationship.add(Relationship31);

                    obj2=(Token)match(input,QName,FOLLOW_QName_in_relationshipExpr998); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(obj2);

                    HasOne32=(Token)match(input,HasOne,FOLLOW_HasOne_in_relationshipExpr1000); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HasOne.add(HasOne32);

                    pushFollow(FOLLOW_objectList_in_relationshipExpr1002);
                    objectList33=objectList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_objectList.add(objectList33.getTree());


                    // AST REWRITE
                    // elements: objectList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 263:3: -> ^( ONE_TO_ONE[$obj2] objectList )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:263:6: ^( ONE_TO_ONE[$obj2] objectList )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONE_TO_ONE, obj2), root_1);

                        adaptor.addChild(root_1, stream_objectList.nextTree());

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
    // $ANTLR end "relationshipExpr"

    public static class qnameList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qnameList"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:266:1: qnameList : QName ( Comma QName )? -> ( QName )+ ;
    public final AmoebaQueryParser.qnameList_return qnameList() throws RecognitionException {
        AmoebaQueryParser.qnameList_return retval = new AmoebaQueryParser.qnameList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName34=null;
        Token Comma35=null;
        Token QName36=null;

        Object QName34_tree=null;
        Object Comma35_tree=null;
        Object QName36_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:267:2: ( QName ( Comma QName )? -> ( QName )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:267:4: QName ( Comma QName )?
            {
            QName34=(Token)match(input,QName,FOLLOW_QName_in_qnameList1024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName34);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:267:10: ( Comma QName )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Comma) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:267:11: Comma QName
                    {
                    Comma35=(Token)match(input,Comma,FOLLOW_Comma_in_qnameList1027); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Comma.add(Comma35);

                    QName36=(Token)match(input,QName,FOLLOW_QName_in_qnameList1029); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(QName36);


                    }
                    break;

            }



            // AST REWRITE
            // elements: QName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 267:25: -> ( QName )+
            {
                if ( !(stream_QName.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_QName.hasNext() ) {
                    adaptor.addChild(root_0, stream_QName.nextNode());

                }
                stream_QName.reset();

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
    // $ANTLR end "qnameList"

    public static class objectList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectList"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:270:1: objectList : object ( Comma object )? -> ( object )+ ;
    public final AmoebaQueryParser.objectList_return objectList() throws RecognitionException {
        AmoebaQueryParser.objectList_return retval = new AmoebaQueryParser.objectList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma38=null;
        AmoebaQueryParser.object_return object37 = null;

        AmoebaQueryParser.object_return object39 = null;


        Object Comma38_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_object=new RewriteRuleSubtreeStream(adaptor,"rule object");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:271:2: ( object ( Comma object )? -> ( object )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:271:4: object ( Comma object )?
            {
            pushFollow(FOLLOW_object_in_objectList1048);
            object37=object();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_object.add(object37.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:271:11: ( Comma object )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Comma) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:271:12: Comma object
                    {
                    Comma38=(Token)match(input,Comma,FOLLOW_Comma_in_objectList1051); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Comma.add(Comma38);

                    pushFollow(FOLLOW_object_in_objectList1053);
                    object39=object();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_object.add(object39.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: object
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 271:27: -> ( object )+
            {
                if ( !(stream_object.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_object.hasNext() ) {
                    adaptor.addChild(root_0, stream_object.nextTree());

                }
                stream_object.reset();

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
    // $ANTLR end "objectList"

    public static class object_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "object"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:274:1: object : QName -> ^( OBJECT[$QName] ) ;
    public final AmoebaQueryParser.object_return object() throws RecognitionException {
        AmoebaQueryParser.object_return retval = new AmoebaQueryParser.object_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName40=null;

        Object QName40_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:275:2: ( QName -> ^( OBJECT[$QName] ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:275:4: QName
            {
            QName40=(Token)match(input,QName,FOLLOW_QName_in_object1071); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName40);



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
            // 275:10: -> ^( OBJECT[$QName] )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:275:13: ^( OBJECT[$QName] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECT, QName40), root_1);

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
    // $ANTLR end "object"

    public static class objectDefExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectDefExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:278:1: objectDefExpr : Object objName= QName LParen ( attributeDefExpr )? ( SPLIT sortOrder= attributeList )? RParen -> ^( OBJECT_DEF[$objName] ( attributeDefExpr )? ( ^( SORT_TARGET $sortOrder) )? ) ;
    public final AmoebaQueryParser.objectDefExpr_return objectDefExpr() throws RecognitionException {
        AmoebaQueryParser.objectDefExpr_return retval = new AmoebaQueryParser.objectDefExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token objName=null;
        Token Object41=null;
        Token LParen42=null;
        Token SPLIT44=null;
        Token RParen45=null;
        AmoebaQueryParser.attributeList_return sortOrder = null;

        AmoebaQueryParser.attributeDefExpr_return attributeDefExpr43 = null;


        Object objName_tree=null;
        Object Object41_tree=null;
        Object LParen42_tree=null;
        Object SPLIT44_tree=null;
        Object RParen45_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_SPLIT=new RewriteRuleTokenStream(adaptor,"token SPLIT");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_Object=new RewriteRuleTokenStream(adaptor,"token Object");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_attributeDefExpr=new RewriteRuleSubtreeStream(adaptor,"rule attributeDefExpr");
        RewriteRuleSubtreeStream stream_attributeList=new RewriteRuleSubtreeStream(adaptor,"rule attributeList");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:2: ( Object objName= QName LParen ( attributeDefExpr )? ( SPLIT sortOrder= attributeList )? RParen -> ^( OBJECT_DEF[$objName] ( attributeDefExpr )? ( ^( SORT_TARGET $sortOrder) )? ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:4: Object objName= QName LParen ( attributeDefExpr )? ( SPLIT sortOrder= attributeList )? RParen
            {
            Object41=(Token)match(input,Object,FOLLOW_Object_in_objectDefExpr1089); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Object.add(Object41);

            objName=(Token)match(input,QName,FOLLOW_QName_in_objectDefExpr1093); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(objName);

            LParen42=(Token)match(input,LParen,FOLLOW_LParen_in_objectDefExpr1095); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen42);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:32: ( attributeDefExpr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==QName) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:32: attributeDefExpr
                    {
                    pushFollow(FOLLOW_attributeDefExpr_in_objectDefExpr1097);
                    attributeDefExpr43=attributeDefExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeDefExpr.add(attributeDefExpr43.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:50: ( SPLIT sortOrder= attributeList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==SPLIT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:279:51: SPLIT sortOrder= attributeList
                    {
                    SPLIT44=(Token)match(input,SPLIT,FOLLOW_SPLIT_in_objectDefExpr1101); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SPLIT.add(SPLIT44);

                    pushFollow(FOLLOW_attributeList_in_objectDefExpr1105);
                    sortOrder=attributeList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attributeList.add(sortOrder.getTree());

                    }
                    break;

            }

            RParen45=(Token)match(input,RParen,FOLLOW_RParen_in_objectDefExpr1109); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen45);



            // AST REWRITE
            // elements: attributeDefExpr, sortOrder
            // token labels: 
            // rule labels: sortOrder, retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_sortOrder=new RewriteRuleSubtreeStream(adaptor,"token sortOrder",sortOrder!=null?sortOrder.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 280:3: -> ^( OBJECT_DEF[$objName] ( attributeDefExpr )? ( ^( SORT_TARGET $sortOrder) )? )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:280:6: ^( OBJECT_DEF[$objName] ( attributeDefExpr )? ( ^( SORT_TARGET $sortOrder) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECT_DEF, objName), root_1);

                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:280:29: ( attributeDefExpr )?
                if ( stream_attributeDefExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeDefExpr.nextTree());

                }
                stream_attributeDefExpr.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:280:47: ( ^( SORT_TARGET $sortOrder) )?
                if ( stream_sortOrder.hasNext() ) {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:280:47: ^( SORT_TARGET $sortOrder)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(SORT_TARGET, "SORT_TARGET"), root_2);

                    adaptor.addChild(root_2, stream_sortOrder.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_sortOrder.reset();

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
    // $ANTLR end "objectDefExpr"

    public static class attributeDefExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeDefExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:284:1: attributeDefExpr : attributeDef ( Comma attributeDef )* -> ( attributeDef )+ ;
    public final AmoebaQueryParser.attributeDefExpr_return attributeDefExpr() throws RecognitionException {
        AmoebaQueryParser.attributeDefExpr_return retval = new AmoebaQueryParser.attributeDefExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma47=null;
        AmoebaQueryParser.attributeDef_return attributeDef46 = null;

        AmoebaQueryParser.attributeDef_return attributeDef48 = null;


        Object Comma47_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attributeDef=new RewriteRuleSubtreeStream(adaptor,"rule attributeDef");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:285:2: ( attributeDef ( Comma attributeDef )* -> ( attributeDef )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:285:4: attributeDef ( Comma attributeDef )*
            {
            pushFollow(FOLLOW_attributeDef_in_attributeDefExpr1143);
            attributeDef46=attributeDef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeDef.add(attributeDef46.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:285:17: ( Comma attributeDef )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Comma) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:285:18: Comma attributeDef
            	    {
            	    Comma47=(Token)match(input,Comma,FOLLOW_Comma_in_attributeDefExpr1146); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma47);

            	    pushFollow(FOLLOW_attributeDef_in_attributeDefExpr1148);
            	    attributeDef48=attributeDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeDef.add(attributeDef48.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: attributeDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 285:39: -> ( attributeDef )+
            {
                if ( !(stream_attributeDef.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeDef.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeDef.nextTree());

                }
                stream_attributeDef.reset();

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
    // $ANTLR end "attributeDefExpr"

    public static class attributeDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeDef"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:288:1: attributeDef : QName DataType -> ^( ATTRIBUTE_DEF[$QName] DataType ) ;
    public final AmoebaQueryParser.attributeDef_return attributeDef() throws RecognitionException {
        AmoebaQueryParser.attributeDef_return retval = new AmoebaQueryParser.attributeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName49=null;
        Token DataType50=null;

        Object QName49_tree=null;
        Object DataType50_tree=null;
        RewriteRuleTokenStream stream_DataType=new RewriteRuleTokenStream(adaptor,"token DataType");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:289:2: ( QName DataType -> ^( ATTRIBUTE_DEF[$QName] DataType ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:289:4: QName DataType
            {
            QName49=(Token)match(input,QName,FOLLOW_QName_in_attributeDef1166); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName49);

            DataType50=(Token)match(input,DataType,FOLLOW_DataType_in_attributeDef1168); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DataType.add(DataType50);



            // AST REWRITE
            // elements: DataType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 289:19: -> ^( ATTRIBUTE_DEF[$QName] DataType )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:289:22: ^( ATTRIBUTE_DEF[$QName] DataType )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE_DEF, QName49), root_1);

                adaptor.addChild(root_1, stream_DataType.nextNode());

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
    // $ANTLR end "attributeDef"

    public static class attributeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeList"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:292:1: attributeList : attribute ( Comma attributeName )* -> ( attribute )+ ;
    public final AmoebaQueryParser.attributeList_return attributeList() throws RecognitionException {
        AmoebaQueryParser.attributeList_return retval = new AmoebaQueryParser.attributeList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma52=null;
        AmoebaQueryParser.attribute_return attribute51 = null;

        AmoebaQueryParser.attributeName_return attributeName53 = null;


        Object Comma52_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:293:2: ( attribute ( Comma attributeName )* -> ( attribute )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:293:4: attribute ( Comma attributeName )*
            {
            pushFollow(FOLLOW_attribute_in_attributeList1190);
            attribute51=attribute();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attribute.add(attribute51.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:293:14: ( Comma attributeName )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Comma) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:293:15: Comma attributeName
            	    {
            	    Comma52=(Token)match(input,Comma,FOLLOW_Comma_in_attributeList1193); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma52);

            	    pushFollow(FOLLOW_attributeName_in_attributeList1195);
            	    attributeName53=attributeName();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeName.add(attributeName53.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);



            // AST REWRITE
            // elements: attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 293:37: -> ( attribute )+
            {
                if ( !(stream_attribute.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_0, stream_attribute.nextTree());

                }
                stream_attribute.reset();

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
    // $ANTLR end "attributeList"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:296:1: attribute : QName -> ^( ATTRIBUTE[$QName] ) ;
    public final AmoebaQueryParser.attribute_return attribute() throws RecognitionException {
        AmoebaQueryParser.attribute_return retval = new AmoebaQueryParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName54=null;

        Object QName54_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:297:2: ( QName -> ^( ATTRIBUTE[$QName] ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:297:4: QName
            {
            QName54=(Token)match(input,QName,FOLLOW_QName_in_attribute1213); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName54);



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
            // 297:10: -> ^( ATTRIBUTE[$QName] )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:297:13: ^( ATTRIBUTE[$QName] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE, QName54), root_1);

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
    // $ANTLR end "attribute"

    public static class amoebaQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "amoebaQuery"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:300:1: amoebaQuery : ( selectExpr | updateExpr );
    public final AmoebaQueryParser.amoebaQuery_return amoebaQuery() throws RecognitionException {
        AmoebaQueryParser.amoebaQuery_return retval = new AmoebaQueryParser.amoebaQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.selectExpr_return selectExpr55 = null;

        AmoebaQueryParser.updateExpr_return updateExpr56 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:301:2: ( selectExpr | updateExpr )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Select) ) {
                alt17=1;
            }
            else if ( (LA17_0==Insert||LA17_0==82) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:301:4: selectExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectExpr_in_amoebaQuery1231);
                    selectExpr55=selectExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selectExpr55.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:302:4: updateExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_updateExpr_in_amoebaQuery1236);
                    updateExpr56=updateExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateExpr56.getTree());

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
    // $ANTLR end "amoebaQuery"

    public static class updateExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:305:1: updateExpr : ( Insert newRelation ( Into targetRelation )? -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? ) | 'update' 'set' newRelation ( whereClause )? -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? ) );
    public final AmoebaQueryParser.updateExpr_return updateExpr() throws RecognitionException {
        AmoebaQueryParser.updateExpr_return retval = new AmoebaQueryParser.updateExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Insert57=null;
        Token Into59=null;
        Token string_literal61=null;
        Token string_literal62=null;
        AmoebaQueryParser.newRelation_return newRelation58 = null;

        AmoebaQueryParser.targetRelation_return targetRelation60 = null;

        AmoebaQueryParser.newRelation_return newRelation63 = null;

        AmoebaQueryParser.whereClause_return whereClause64 = null;


        Object Insert57_tree=null;
        Object Into59_tree=null;
        Object string_literal61_tree=null;
        Object string_literal62_tree=null;
        RewriteRuleTokenStream stream_Insert=new RewriteRuleTokenStream(adaptor,"token Insert");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_Into=new RewriteRuleTokenStream(adaptor,"token Into");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleSubtreeStream stream_whereClause=new RewriteRuleSubtreeStream(adaptor,"rule whereClause");
        RewriteRuleSubtreeStream stream_targetRelation=new RewriteRuleSubtreeStream(adaptor,"rule targetRelation");
        RewriteRuleSubtreeStream stream_newRelation=new RewriteRuleSubtreeStream(adaptor,"rule newRelation");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:306:2: ( Insert newRelation ( Into targetRelation )? -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? ) | 'update' 'set' newRelation ( whereClause )? -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Insert) ) {
                alt20=1;
            }
            else if ( (LA20_0==82) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:306:4: Insert newRelation ( Into targetRelation )?
                    {
                    Insert57=(Token)match(input,Insert,FOLLOW_Insert_in_updateExpr1248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Insert.add(Insert57);

                    pushFollow(FOLLOW_newRelation_in_updateExpr1250);
                    newRelation58=newRelation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newRelation.add(newRelation58.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:306:23: ( Into targetRelation )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==Into) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:306:24: Into targetRelation
                            {
                            Into59=(Token)match(input,Into,FOLLOW_Into_in_updateExpr1253); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_Into.add(Into59);

                            pushFollow(FOLLOW_targetRelation_in_updateExpr1255);
                            targetRelation60=targetRelation();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_targetRelation.add(targetRelation60.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: targetRelation, newRelation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 307:4: -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:307:7: ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSERT, "INSERT"), root_1);

                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:307:16: ^( NEW_RELATION newRelation )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEW_RELATION, "NEW_RELATION"), root_2);

                        adaptor.addChild(root_2, stream_newRelation.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:307:44: ( ^( TARGET targetRelation ) )?
                        if ( stream_targetRelation.hasNext() ) {
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:307:44: ^( TARGET targetRelation )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TARGET, "TARGET"), root_2);

                            adaptor.addChild(root_2, stream_targetRelation.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_targetRelation.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:308:4: 'update' 'set' newRelation ( whereClause )?
                    {
                    string_literal61=(Token)match(input,82,FOLLOW_82_in_updateExpr1285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_82.add(string_literal61);

                    string_literal62=(Token)match(input,83,FOLLOW_83_in_updateExpr1287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_83.add(string_literal62);

                    pushFollow(FOLLOW_newRelation_in_updateExpr1289);
                    newRelation63=newRelation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newRelation.add(newRelation63.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:308:31: ( whereClause )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==Where) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:308:31: whereClause
                            {
                            pushFollow(FOLLOW_whereClause_in_updateExpr1291);
                            whereClause64=whereClause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_whereClause.add(whereClause64.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: newRelation, whereClause
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 309:4: -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:309:7: ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UPDATE, "UPDATE"), root_1);

                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:309:16: ^( NEW_RELATION newRelation )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEW_RELATION, "NEW_RELATION"), root_2);

                        adaptor.addChild(root_2, stream_newRelation.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:309:44: ( ^( CONDITION whereClause ) )?
                        if ( stream_whereClause.hasNext() ) {
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:309:44: ^( CONDITION whereClause )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_2);

                            adaptor.addChild(root_2, stream_whereClause.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_whereClause.reset();

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
    // $ANTLR end "updateExpr"

    public static class newRelation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newRelation"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:312:1: newRelation : LParen tupleElement ( Comma tupleElement )* RParen -> ( tupleElement )+ ;
    public final AmoebaQueryParser.newRelation_return newRelation() throws RecognitionException {
        AmoebaQueryParser.newRelation_return retval = new AmoebaQueryParser.newRelation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen65=null;
        Token Comma67=null;
        Token RParen69=null;
        AmoebaQueryParser.tupleElement_return tupleElement66 = null;

        AmoebaQueryParser.tupleElement_return tupleElement68 = null;


        Object LParen65_tree=null;
        Object Comma67_tree=null;
        Object RParen69_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_tupleElement=new RewriteRuleSubtreeStream(adaptor,"rule tupleElement");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:313:2: ( LParen tupleElement ( Comma tupleElement )* RParen -> ( tupleElement )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:313:4: LParen tupleElement ( Comma tupleElement )* RParen
            {
            LParen65=(Token)match(input,LParen,FOLLOW_LParen_in_newRelation1327); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen65);

            pushFollow(FOLLOW_tupleElement_in_newRelation1329);
            tupleElement66=tupleElement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tupleElement.add(tupleElement66.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:313:24: ( Comma tupleElement )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:313:25: Comma tupleElement
            	    {
            	    Comma67=(Token)match(input,Comma,FOLLOW_Comma_in_newRelation1332); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma67);

            	    pushFollow(FOLLOW_tupleElement_in_newRelation1334);
            	    tupleElement68=tupleElement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_tupleElement.add(tupleElement68.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            RParen69=(Token)match(input,RParen,FOLLOW_RParen_in_newRelation1338); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen69);



            // AST REWRITE
            // elements: tupleElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 314:3: -> ( tupleElement )+
            {
                if ( !(stream_tupleElement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_tupleElement.hasNext() ) {
                    adaptor.addChild(root_0, stream_tupleElement.nextTree());

                }
                stream_tupleElement.reset();

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
    // $ANTLR end "newRelation"

    public static class tupleElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tupleElement"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:317:1: tupleElement : ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )? ;
    public final AmoebaQueryParser.tupleElement_return tupleElement() throws RecognitionException {
        AmoebaQueryParser.tupleElement_return retval = new AmoebaQueryParser.tupleElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL71=null;
        AmoebaQueryParser.elementValue_return e = null;

        AmoebaQueryParser.attributeName_return attributeName70 = null;


        Object EQUAL71_tree=null;
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_elementValue=new RewriteRuleSubtreeStream(adaptor,"rule elementValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:2: ( ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:4: ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )?
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:4: ( attributeName -> attributeName )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:5: attributeName
            {
            pushFollow(FOLLOW_attributeName_in_tupleElement1358);
            attributeName70=attributeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeName.add(attributeName70.getTree());


            // AST REWRITE
            // elements: attributeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 318:19: -> attributeName
            {
                adaptor.addChild(root_0, stream_attributeName.nextTree());

            }

            retval.tree = root_0;}
            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:37: ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==EQUAL) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:38: EQUAL e= elementValue
                    {
                    EQUAL71=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_tupleElement1366); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL71);

                    pushFollow(FOLLOW_elementValue_in_tupleElement1370);
                    e=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elementValue.add(e.getTree());


                    // AST REWRITE
                    // elements: elementValue, tupleElement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 318:59: -> ^( NEW_VALUE $tupleElement elementValue )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:318:62: ^( NEW_VALUE $tupleElement elementValue )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEW_VALUE, "NEW_VALUE"), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());
                        adaptor.addChild(root_1, stream_elementValue.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
    // $ANTLR end "tupleElement"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:321:1: elementValue : ( literal -> ^( VALUE literal ) | '{' elementValue ( Comma elementValue )? '}' -> ^( VALUE_SET ( elementValue )+ ) );
    public final AmoebaQueryParser.elementValue_return elementValue() throws RecognitionException {
        AmoebaQueryParser.elementValue_return retval = new AmoebaQueryParser.elementValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal73=null;
        Token Comma75=null;
        Token char_literal77=null;
        AmoebaQueryParser.literal_return literal72 = null;

        AmoebaQueryParser.elementValue_return elementValue74 = null;

        AmoebaQueryParser.elementValue_return elementValue76 = null;


        Object char_literal73_tree=null;
        Object Comma75_tree=null;
        Object char_literal77_tree=null;
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        RewriteRuleSubtreeStream stream_elementValue=new RewriteRuleSubtreeStream(adaptor,"rule elementValue");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:322:2: ( literal -> ^( VALUE literal ) | '{' elementValue ( Comma elementValue )? '}' -> ^( VALUE_SET ( elementValue )+ ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Dot||(LA24_0>=Comma && LA24_0<=RParen)||LA24_0==Digits||LA24_0==StringLiteral||LA24_0==85) ) {
                alt24=1;
            }
            else if ( (LA24_0==84) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:322:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_elementValue1396);
                    literal72=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_literal.add(literal72.getTree());


                    // AST REWRITE
                    // elements: literal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 323:4: -> ^( VALUE literal )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:323:7: ^( VALUE literal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE, "VALUE"), root_1);

                        adaptor.addChild(root_1, stream_literal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:324:4: '{' elementValue ( Comma elementValue )? '}'
                    {
                    char_literal73=(Token)match(input,84,FOLLOW_84_in_elementValue1412); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_84.add(char_literal73);

                    pushFollow(FOLLOW_elementValue_in_elementValue1414);
                    elementValue74=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elementValue.add(elementValue74.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:324:21: ( Comma elementValue )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==Comma) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:324:22: Comma elementValue
                            {
                            Comma75=(Token)match(input,Comma,FOLLOW_Comma_in_elementValue1417); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_Comma.add(Comma75);

                            pushFollow(FOLLOW_elementValue_in_elementValue1419);
                            elementValue76=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_elementValue.add(elementValue76.getTree());

                            }
                            break;

                    }

                    char_literal77=(Token)match(input,85,FOLLOW_85_in_elementValue1423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal77);



                    // AST REWRITE
                    // elements: elementValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 325:4: -> ^( VALUE_SET ( elementValue )+ )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:325:7: ^( VALUE_SET ( elementValue )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE_SET, "VALUE_SET"), root_1);

                        if ( !(stream_elementValue.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_elementValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementValue.nextTree());

                        }
                        stream_elementValue.reset();

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
    // $ANTLR end "elementValue"

    public static class exprSingle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprSingle"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:329:1: exprSingle : ( selectExpr | subQuery );
    public final AmoebaQueryParser.exprSingle_return exprSingle() throws RecognitionException {
        AmoebaQueryParser.exprSingle_return retval = new AmoebaQueryParser.exprSingle_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.selectExpr_return selectExpr78 = null;

        AmoebaQueryParser.subQuery_return subQuery79 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:330:2: ( selectExpr | subQuery )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Select) ) {
                alt25=1;
            }
            else if ( (LA25_0==LParen) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:330:4: selectExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectExpr_in_exprSingle1448);
                    selectExpr78=selectExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selectExpr78.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:331:4: subQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subQuery_in_exprSingle1453);
                    subQuery79=subQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuery79.getTree());

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
    // $ANTLR end "exprSingle"

    public static class subQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subQuery"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:334:1: subQuery : LParen selectExpr RParen -> selectExpr ;
    public final AmoebaQueryParser.subQuery_return subQuery() throws RecognitionException {
        AmoebaQueryParser.subQuery_return retval = new AmoebaQueryParser.subQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen80=null;
        Token RParen82=null;
        AmoebaQueryParser.selectExpr_return selectExpr81 = null;


        Object LParen80_tree=null;
        Object RParen82_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_selectExpr=new RewriteRuleSubtreeStream(adaptor,"rule selectExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:335:2: ( LParen selectExpr RParen -> selectExpr )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:335:4: LParen selectExpr RParen
            {
            LParen80=(Token)match(input,LParen,FOLLOW_LParen_in_subQuery1465); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen80);

            pushFollow(FOLLOW_selectExpr_in_subQuery1467);
            selectExpr81=selectExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectExpr.add(selectExpr81.getTree());
            RParen82=(Token)match(input,RParen,FOLLOW_RParen_in_subQuery1469); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen82);



            // AST REWRITE
            // elements: selectExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 335:29: -> selectExpr
            {
                adaptor.addChild(root_0, stream_selectExpr.nextTree());

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
    // $ANTLR end "subQuery"

    public static class selectExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:339:1: selectExpr : Select selectTarget ( fromClause )? ( whereClause )? ( orderByClause )? -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ( ^( ORDER_BY orderByClause ) )? ) ;
    public final AmoebaQueryParser.selectExpr_return selectExpr() throws RecognitionException {
        AmoebaQueryParser.selectExpr_return retval = new AmoebaQueryParser.selectExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Select83=null;
        AmoebaQueryParser.selectTarget_return selectTarget84 = null;

        AmoebaQueryParser.fromClause_return fromClause85 = null;

        AmoebaQueryParser.whereClause_return whereClause86 = null;

        AmoebaQueryParser.orderByClause_return orderByClause87 = null;


        Object Select83_tree=null;
        RewriteRuleTokenStream stream_Select=new RewriteRuleTokenStream(adaptor,"token Select");
        RewriteRuleSubtreeStream stream_fromClause=new RewriteRuleSubtreeStream(adaptor,"rule fromClause");
        RewriteRuleSubtreeStream stream_whereClause=new RewriteRuleSubtreeStream(adaptor,"rule whereClause");
        RewriteRuleSubtreeStream stream_selectTarget=new RewriteRuleSubtreeStream(adaptor,"rule selectTarget");
        RewriteRuleSubtreeStream stream_orderByClause=new RewriteRuleSubtreeStream(adaptor,"rule orderByClause");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:2: ( Select selectTarget ( fromClause )? ( whereClause )? ( orderByClause )? -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ( ^( ORDER_BY orderByClause ) )? ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:4: Select selectTarget ( fromClause )? ( whereClause )? ( orderByClause )?
            {
            Select83=(Token)match(input,Select,FOLLOW_Select_in_selectExpr1490); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Select.add(Select83);

            pushFollow(FOLLOW_selectTarget_in_selectExpr1492);
            selectTarget84=selectTarget();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectTarget.add(selectTarget84.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:24: ( fromClause )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:24: fromClause
                    {
                    pushFollow(FOLLOW_fromClause_in_selectExpr1494);
                    fromClause85=fromClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fromClause.add(fromClause85.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:36: ( whereClause )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:36: whereClause
                    {
                    pushFollow(FOLLOW_whereClause_in_selectExpr1497);
                    whereClause86=whereClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_whereClause.add(whereClause86.getTree());

                    }
                    break;

            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:49: ( orderByClause )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:340:49: orderByClause
                    {
                    pushFollow(FOLLOW_orderByClause_in_selectExpr1500);
                    orderByClause87=orderByClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderByClause.add(orderByClause87.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: whereClause, selectTarget, fromClause, orderByClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 341:3: -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ( ^( ORDER_BY orderByClause ) )? )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:6: ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ( ^( ORDER_BY orderByClause ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTION, "SELECTION"), root_1);

                adaptor.addChild(root_1, stream_selectTarget.nextTree());
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:31: ( ^( INPUT fromClause ) )?
                if ( stream_fromClause.hasNext() ) {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:31: ^( INPUT fromClause )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_2);

                    adaptor.addChild(root_2, stream_fromClause.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_fromClause.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:52: ( ^( CONDITION whereClause ) )?
                if ( stream_whereClause.hasNext() ) {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:52: ^( CONDITION whereClause )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_2);

                    adaptor.addChild(root_2, stream_whereClause.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_whereClause.reset();
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:78: ( ^( ORDER_BY orderByClause ) )?
                if ( stream_orderByClause.hasNext() ) {
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:341:78: ^( ORDER_BY orderByClause )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDER_BY, "ORDER_BY"), root_2);

                    adaptor.addChild(root_2, stream_orderByClause.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_orderByClause.reset();

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
    // $ANTLR end "selectExpr"

    public static class selectTarget_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectTarget"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:345:1: selectTarget : ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL );
    public final AmoebaQueryParser.selectTarget_return selectTarget() throws RecognitionException {
        AmoebaQueryParser.selectTarget_return retval = new AmoebaQueryParser.selectTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma89=null;
        Token Wildcard91=null;
        AmoebaQueryParser.labelExpr_return labelExpr88 = null;

        AmoebaQueryParser.labelExpr_return labelExpr90 = null;


        Object Comma89_tree=null;
        Object Wildcard91_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_Wildcard=new RewriteRuleTokenStream(adaptor,"token Wildcard");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:346:2: ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:346:4: labelExpr ( Comma labelExpr )*
                    {
                    pushFollow(FOLLOW_labelExpr_in_selectTarget1544);
                    labelExpr88=labelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr88.getTree());
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:346:14: ( Comma labelExpr )*
                    loop29:
                    do {
                        int alt29=2;
                        alt29 = dfa29.predict(input);
                        switch (alt29) {
                    	case 1 :
                    	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:346:15: Comma labelExpr
                    	    {
                    	    Comma89=(Token)match(input,Comma,FOLLOW_Comma_in_selectTarget1547); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Comma.add(Comma89);

                    	    pushFollow(FOLLOW_labelExpr_in_selectTarget1549);
                    	    labelExpr90=labelExpr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr90.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: labelExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 346:33: -> ^( PROJECTION ( labelExpr )+ )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:346:36: ^( PROJECTION ( labelExpr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROJECTION, "PROJECTION"), root_1);

                        if ( !(stream_labelExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_labelExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_labelExpr.nextTree());

                        }
                        stream_labelExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:347:4: Wildcard
                    {
                    Wildcard91=(Token)match(input,Wildcard,FOLLOW_Wildcard_in_selectTarget1565); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Wildcard.add(Wildcard91);



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
                    // 347:13: -> PROJECT_ALL
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(PROJECT_ALL, "PROJECT_ALL"));

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
    // $ANTLR end "selectTarget"

    public static class fromClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fromClause"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:350:1: fromClause : From fromTarget ( Comma fromTarget )* -> ( fromTarget )+ ;
    public final AmoebaQueryParser.fromClause_return fromClause() throws RecognitionException {
        AmoebaQueryParser.fromClause_return retval = new AmoebaQueryParser.fromClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token From92=null;
        Token Comma94=null;
        AmoebaQueryParser.fromTarget_return fromTarget93 = null;

        AmoebaQueryParser.fromTarget_return fromTarget95 = null;


        Object From92_tree=null;
        Object Comma94_tree=null;
        RewriteRuleTokenStream stream_From=new RewriteRuleTokenStream(adaptor,"token From");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_fromTarget=new RewriteRuleSubtreeStream(adaptor,"rule fromTarget");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:351:2: ( From fromTarget ( Comma fromTarget )* -> ( fromTarget )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:351:4: From fromTarget ( Comma fromTarget )*
            {
            From92=(Token)match(input,From,FOLLOW_From_in_fromClause1580); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_From.add(From92);

            pushFollow(FOLLOW_fromTarget_in_fromClause1582);
            fromTarget93=fromTarget();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_fromTarget.add(fromTarget93.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:351:20: ( Comma fromTarget )*
            loop31:
            do {
                int alt31=2;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:351:21: Comma fromTarget
            	    {
            	    Comma94=(Token)match(input,Comma,FOLLOW_Comma_in_fromClause1585); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma94);

            	    pushFollow(FOLLOW_fromTarget_in_fromClause1587);
            	    fromTarget95=fromTarget();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_fromTarget.add(fromTarget95.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);



            // AST REWRITE
            // elements: fromTarget
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 351:40: -> ( fromTarget )+
            {
                if ( !(stream_fromTarget.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_fromTarget.hasNext() ) {
                    adaptor.addChild(root_0, stream_fromTarget.nextTree());

                }
                stream_fromTarget.reset();

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
    // $ANTLR end "fromClause"

    public static class fromTarget_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fromTarget"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:354:1: fromTarget : ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )? ;
    public final AmoebaQueryParser.fromTarget_return fromTarget() throws RecognitionException {
        AmoebaQueryParser.fromTarget_return retval = new AmoebaQueryParser.fromTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal97=null;
        Token QName98=null;
        AmoebaQueryParser.targetRelation_return targetRelation96 = null;


        Object string_literal97_tree=null;
        Object QName98_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleSubtreeStream stream_targetRelation=new RewriteRuleSubtreeStream(adaptor,"rule targetRelation");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:2: ( ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )? )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:4: ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )?
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:4: ( targetRelation -> targetRelation )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:5: targetRelation
            {
            pushFollow(FOLLOW_targetRelation_in_fromTarget1606);
            targetRelation96=targetRelation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_targetRelation.add(targetRelation96.getTree());


            // AST REWRITE
            // elements: targetRelation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 355:20: -> targetRelation
            {
                adaptor.addChild(root_0, stream_targetRelation.nextTree());

            }

            retval.tree = root_0;}
            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:39: ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:40: 'as' QName
                    {
                    string_literal97=(Token)match(input,86,FOLLOW_86_in_fromTarget1614); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_86.add(string_literal97);

                    QName98=(Token)match(input,QName,FOLLOW_QName_in_fromTarget1616); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(QName98);



                    // AST REWRITE
                    // elements: fromTarget, QName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 355:51: -> ^( ASSIGN_LABEL QName $fromTarget)
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:355:54: ^( ASSIGN_LABEL QName $fromTarget)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_LABEL, "ASSIGN_LABEL"), root_1);

                        adaptor.addChild(root_1, stream_QName.nextNode());
                        adaptor.addChild(root_1, stream_retval.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
    // $ANTLR end "fromTarget"

    public static class targetRelation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "targetRelation"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:358:1: targetRelation : ( QName -> ^( RELATION QName ) | subQuery );
    public final AmoebaQueryParser.targetRelation_return targetRelation() throws RecognitionException {
        AmoebaQueryParser.targetRelation_return retval = new AmoebaQueryParser.targetRelation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName99=null;
        AmoebaQueryParser.subQuery_return subQuery100 = null;


        Object QName99_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:359:2: ( QName -> ^( RELATION QName ) | subQuery )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==QName) ) {
                alt33=1;
            }
            else if ( (LA33_0==LParen) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:359:4: QName
                    {
                    QName99=(Token)match(input,QName,FOLLOW_QName_in_targetRelation1642); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(QName99);



                    // AST REWRITE
                    // elements: QName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 359:10: -> ^( RELATION QName )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:359:13: ^( RELATION QName )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RELATION, "RELATION"), root_1);

                        adaptor.addChild(root_1, stream_QName.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:360:4: subQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subQuery_in_targetRelation1655);
                    subQuery100=subQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuery100.getTree());

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
    // $ANTLR end "targetRelation"

    public static class whereClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whereClause"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:363:1: whereClause : Where orExpr ;
    public final AmoebaQueryParser.whereClause_return whereClause() throws RecognitionException {
        AmoebaQueryParser.whereClause_return retval = new AmoebaQueryParser.whereClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Where101=null;
        AmoebaQueryParser.orExpr_return orExpr102 = null;


        Object Where101_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:364:2: ( Where orExpr )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:364:4: Where orExpr
            {
            root_0 = (Object)adaptor.nil();

            Where101=(Token)match(input,Where,FOLLOW_Where_in_whereClause1666); if (state.failed) return retval;
            pushFollow(FOLLOW_orExpr_in_whereClause1669);
            orExpr102=orExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpr102.getTree());

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
    // $ANTLR end "whereClause"

    public static class orderByClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderByClause"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:367:1: orderByClause : 'order' 'by' ( attributeName ( Comma attributeName )* ) -> ( attributeName )+ ;
    public final AmoebaQueryParser.orderByClause_return orderByClause() throws RecognitionException {
        AmoebaQueryParser.orderByClause_return retval = new AmoebaQueryParser.orderByClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal103=null;
        Token string_literal104=null;
        Token Comma106=null;
        AmoebaQueryParser.attributeName_return attributeName105 = null;

        AmoebaQueryParser.attributeName_return attributeName107 = null;


        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object Comma106_tree=null;
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:2: ( 'order' 'by' ( attributeName ( Comma attributeName )* ) -> ( attributeName )+ )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:4: 'order' 'by' ( attributeName ( Comma attributeName )* )
            {
            string_literal103=(Token)match(input,87,FOLLOW_87_in_orderByClause1681); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(string_literal103);

            string_literal104=(Token)match(input,79,FOLLOW_79_in_orderByClause1683); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal104);

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:17: ( attributeName ( Comma attributeName )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:18: attributeName ( Comma attributeName )*
            {
            pushFollow(FOLLOW_attributeName_in_orderByClause1686);
            attributeName105=attributeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributeName.add(attributeName105.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:32: ( Comma attributeName )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:368:33: Comma attributeName
            	    {
            	    Comma106=(Token)match(input,Comma,FOLLOW_Comma_in_orderByClause1689); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma106);

            	    pushFollow(FOLLOW_attributeName_in_orderByClause1691);
            	    attributeName107=attributeName();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attributeName.add(attributeName107.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }



            // AST REWRITE
            // elements: attributeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 368:56: -> ( attributeName )+
            {
                if ( !(stream_attributeName.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeName.hasNext() ) {
                    adaptor.addChild(root_0, stream_attributeName.nextTree());

                }
                stream_attributeName.reset();

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
    // $ANTLR end "orderByClause"

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:372:1: orExpr : ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )* ;
    public final AmoebaQueryParser.orExpr_return orExpr() throws RecognitionException {
        AmoebaQueryParser.orExpr_return retval = new AmoebaQueryParser.orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal109=null;
        AmoebaQueryParser.andExpr_return a = null;

        AmoebaQueryParser.andExpr_return andExpr108 = null;


        Object string_literal109_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_andExpr=new RewriteRuleSubtreeStream(adaptor,"rule andExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:2: ( ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:4: ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:4: ( andExpr -> andExpr )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:5: andExpr
            {
            pushFollow(FOLLOW_andExpr_in_orExpr1714);
            andExpr108=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_andExpr.add(andExpr108.getTree());


            // AST REWRITE
            // elements: andExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 373:13: -> andExpr
            {
                adaptor.addChild(root_0, stream_andExpr.nextTree());

            }

            retval.tree = root_0;}
            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:25: ( 'or' a= andExpr -> ^( OR $orExpr $a) )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:26: 'or' a= andExpr
            	    {
            	    string_literal109=(Token)match(input,88,FOLLOW_88_in_orExpr1722); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_88.add(string_literal109);

            	    pushFollow(FOLLOW_andExpr_in_orExpr1726);
            	    a=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_andExpr.add(a.getTree());


            	    // AST REWRITE
            	    // elements: a, orExpr
            	    // token labels: 
            	    // rule labels: a, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",a!=null?a.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 373:41: -> ^( OR $orExpr $a)
            	    {
            	        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:373:44: ^( OR $orExpr $a)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR, "OR"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_a.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:376:1: andExpr : ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )* ;
    public final AmoebaQueryParser.andExpr_return andExpr() throws RecognitionException {
        AmoebaQueryParser.andExpr_return retval = new AmoebaQueryParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal111=null;
        AmoebaQueryParser.conditionExpr_return c = null;

        AmoebaQueryParser.conditionExpr_return conditionExpr110 = null;


        Object string_literal111_tree=null;
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_conditionExpr=new RewriteRuleSubtreeStream(adaptor,"rule conditionExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:2: ( ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )* )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:4: ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )*
            {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:4: ( conditionExpr -> conditionExpr )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:5: conditionExpr
            {
            pushFollow(FOLLOW_conditionExpr_in_andExpr1754);
            conditionExpr110=conditionExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_conditionExpr.add(conditionExpr110.getTree());


            // AST REWRITE
            // elements: conditionExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 377:19: -> conditionExpr
            {
                adaptor.addChild(root_0, stream_conditionExpr.nextTree());

            }

            retval.tree = root_0;}
            }

            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:37: ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:38: 'and' c= conditionExpr
            	    {
            	    string_literal111=(Token)match(input,89,FOLLOW_89_in_andExpr1762); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_89.add(string_literal111);

            	    pushFollow(FOLLOW_conditionExpr_in_andExpr1766);
            	    c=conditionExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_conditionExpr.add(c.getTree());


            	    // AST REWRITE
            	    // elements: c, andExpr
            	    // token labels: 
            	    // rule labels: c, retval
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"token c",c!=null?c.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 377:60: -> ^( AND $andExpr $c)
            	    {
            	        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:377:63: ^( AND $andExpr $c)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND, "AND"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_c.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop36;
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
    // $ANTLR end "andExpr"

    public static class conditionExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:381:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );
    public final AmoebaQueryParser.conditionExpr_return conditionExpr() throws RecognitionException {
        AmoebaQueryParser.conditionExpr_return retval = new AmoebaQueryParser.conditionExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token In115=null;
        AmoebaQueryParser.comparisonOp_return c = null;

        AmoebaQueryParser.labelExpr_return labelExpr112 = null;

        AmoebaQueryParser.labelExpr_return labelExpr113 = null;

        AmoebaQueryParser.labelExpr_return labelExpr114 = null;

        AmoebaQueryParser.subQuery_return subQuery116 = null;


        Object In115_tree=null;
        RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
        RewriteRuleSubtreeStream stream_comparisonOp=new RewriteRuleSubtreeStream(adaptor,"rule comparisonOp");
        RewriteRuleSubtreeStream stream_subQuery=new RewriteRuleSubtreeStream(adaptor,"rule subQuery");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:382:2: ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) )
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:382:4: labelExpr c= comparisonOp labelExpr
                    {
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1802);
                    labelExpr112=labelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr112.getTree());
                    pushFollow(FOLLOW_comparisonOp_in_conditionExpr1806);
                    c=comparisonOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_comparisonOp.add(c.getTree());
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1808);
                    labelExpr113=labelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr113.getTree());


                    // AST REWRITE
                    // elements: labelExpr, comparisonOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 383:4: -> ^( COMPARE comparisonOp ( labelExpr )+ )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:383:7: ^( COMPARE comparisonOp ( labelExpr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARE, "COMPARE"), root_1);

                        adaptor.addChild(root_1, stream_comparisonOp.nextTree());
                        if ( !(stream_labelExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_labelExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_labelExpr.nextTree());

                        }
                        stream_labelExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:384:4: labelExpr In subQuery
                    {
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1828);
                    labelExpr114=labelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr114.getTree());
                    In115=(Token)match(input,In,FOLLOW_In_in_conditionExpr1830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_In.add(In115);

                    pushFollow(FOLLOW_subQuery_in_conditionExpr1832);
                    subQuery116=subQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_subQuery.add(subQuery116.getTree());


                    // AST REWRITE
                    // elements: subQuery, labelExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 385:4: -> ^( CONTAINED_IN labelExpr subQuery )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:385:7: ^( CONTAINED_IN labelExpr subQuery )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTAINED_IN, "CONTAINED_IN"), root_1);

                        adaptor.addChild(root_1, stream_labelExpr.nextTree());
                        adaptor.addChild(root_1, stream_subQuery.nextTree());

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
    // $ANTLR end "conditionExpr"

    public static class comparisonOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparisonOp"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:388:1: comparisonOp : ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' ) ;
    public final AmoebaQueryParser.comparisonOp_return comparisonOp() throws RecognitionException {
        AmoebaQueryParser.comparisonOp_return retval = new AmoebaQueryParser.comparisonOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set117=null;

        Object set117_tree=null;

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:388:13: ( ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:388:15: ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' )
            {
            root_0 = (Object)adaptor.nil();

            set117=(Token)input.LT(1);
            if ( (input.LA(1)>=EQUAL && input.LA(1)<=GEQ)||input.LA(1)==90 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set117));
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
    // $ANTLR end "comparisonOp"

    public static class labelExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "labelExpr"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:390:1: labelExpr : ( function | attributeName | value -> ^( VALUE value ) );
    public final AmoebaQueryParser.labelExpr_return labelExpr() throws RecognitionException {
        AmoebaQueryParser.labelExpr_return retval = new AmoebaQueryParser.labelExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.function_return function118 = null;

        AmoebaQueryParser.attributeName_return attributeName119 = null;

        AmoebaQueryParser.value_return value120 = null;


        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:391:2: ( function | attributeName | value -> ^( VALUE value ) )
            int alt38=3;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:391:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_labelExpr1890);
                    function118=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function118.getTree());

                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:392:4: attributeName
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attributeName_in_labelExpr1896);
                    attributeName119=attributeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attributeName119.getTree());

                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:393:4: value
                    {
                    pushFollow(FOLLOW_value_in_labelExpr1902);
                    value120=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_value.add(value120.getTree());


                    // AST REWRITE
                    // elements: value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 393:10: -> ^( VALUE value )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:393:13: ^( VALUE value )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE, "VALUE"), root_1);

                        adaptor.addChild(root_1, stream_value.nextTree());

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
    // $ANTLR end "labelExpr"

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:396:1: value : literal ;
    public final AmoebaQueryParser.value_return value() throws RecognitionException {
        AmoebaQueryParser.value_return retval = new AmoebaQueryParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        AmoebaQueryParser.literal_return literal121 = null;



        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:397:2: ( literal )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:397:4: literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_literal_in_value1923);
            literal121=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, literal121.getTree());

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
    // $ANTLR end "value"

    public static class attributeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeName"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:400:1: attributeName : (qn= QName -> ^( ATTRIBUTE[$qn] ) | relation= QName Dot at= QName -> ^( REF $relation $at) | relation= QName Dot Wildcard -> ^( REF_ALL $relation) );
    public final AmoebaQueryParser.attributeName_return attributeName() throws RecognitionException {
        AmoebaQueryParser.attributeName_return retval = new AmoebaQueryParser.attributeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token qn=null;
        Token relation=null;
        Token at=null;
        Token Dot122=null;
        Token Dot123=null;
        Token Wildcard124=null;

        Object qn_tree=null;
        Object relation_tree=null;
        Object at_tree=null;
        Object Dot122_tree=null;
        Object Dot123_tree=null;
        Object Wildcard124_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_Wildcard=new RewriteRuleTokenStream(adaptor,"token Wildcard");

        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:401:2: (qn= QName -> ^( ATTRIBUTE[$qn] ) | relation= QName Dot at= QName -> ^( REF $relation $at) | relation= QName Dot Wildcard -> ^( REF_ALL $relation) )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:401:4: qn= QName
                    {
                    qn=(Token)match(input,QName,FOLLOW_QName_in_attributeName1936); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(qn);



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
                    // 401:13: -> ^( ATTRIBUTE[$qn] )
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:401:16: ^( ATTRIBUTE[$qn] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE, qn), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:402:4: relation= QName Dot at= QName
                    {
                    relation=(Token)match(input,QName,FOLLOW_QName_in_attributeName1950); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(relation);

                    Dot122=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName1952); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dot.add(Dot122);

                    at=(Token)match(input,QName,FOLLOW_QName_in_attributeName1956); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(at);



                    // AST REWRITE
                    // elements: at, relation
                    // token labels: relation, at
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_relation=new RewriteRuleTokenStream(adaptor,"token relation",relation);
                    RewriteRuleTokenStream stream_at=new RewriteRuleTokenStream(adaptor,"token at",at);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 402:32: -> ^( REF $relation $at)
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:402:35: ^( REF $relation $at)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REF, "REF"), root_1);

                        adaptor.addChild(root_1, stream_relation.nextNode());
                        adaptor.addChild(root_1, stream_at.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:403:4: relation= QName Dot Wildcard
                    {
                    relation=(Token)match(input,QName,FOLLOW_QName_in_attributeName1975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QName.add(relation);

                    Dot123=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName1977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Dot.add(Dot123);

                    Wildcard124=(Token)match(input,Wildcard,FOLLOW_Wildcard_in_attributeName1979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Wildcard.add(Wildcard124);



                    // AST REWRITE
                    // elements: relation
                    // token labels: relation
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_relation=new RewriteRuleTokenStream(adaptor,"token relation",relation);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 403:32: -> ^( REF_ALL $relation)
                    {
                        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:403:35: ^( REF_ALL $relation)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REF_ALL, "REF_ALL"), root_1);

                        adaptor.addChild(root_1, stream_relation.nextNode());

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
    // $ANTLR end "attributeName"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:407:1: function : QName LParen labelExpr ( Comma labelExpr )* RParen -> ^( FUNCTION QName ( labelExpr )+ ) ;
    public final AmoebaQueryParser.function_return function() throws RecognitionException {
        AmoebaQueryParser.function_return retval = new AmoebaQueryParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName125=null;
        Token LParen126=null;
        Token Comma128=null;
        Token RParen130=null;
        AmoebaQueryParser.labelExpr_return labelExpr127 = null;

        AmoebaQueryParser.labelExpr_return labelExpr129 = null;


        Object QName125_tree=null;
        Object LParen126_tree=null;
        Object Comma128_tree=null;
        Object RParen130_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:408:2: ( QName LParen labelExpr ( Comma labelExpr )* RParen -> ^( FUNCTION QName ( labelExpr )+ ) )
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:408:4: QName LParen labelExpr ( Comma labelExpr )* RParen
            {
            QName125=(Token)match(input,QName,FOLLOW_QName_in_function2003); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QName.add(QName125);

            LParen126=(Token)match(input,LParen,FOLLOW_LParen_in_function2005); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen126);

            pushFollow(FOLLOW_labelExpr_in_function2007);
            labelExpr127=labelExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr127.getTree());
            // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:408:27: ( Comma labelExpr )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==Comma) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:408:28: Comma labelExpr
            	    {
            	    Comma128=(Token)match(input,Comma,FOLLOW_Comma_in_function2010); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma128);

            	    pushFollow(FOLLOW_labelExpr_in_function2012);
            	    labelExpr129=labelExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_labelExpr.add(labelExpr129.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            RParen130=(Token)match(input,RParen,FOLLOW_RParen_in_function2016); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen130);



            // AST REWRITE
            // elements: QName, labelExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 409:2: -> ^( FUNCTION QName ( labelExpr )+ )
            {
                // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:409:5: ^( FUNCTION QName ( labelExpr )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_QName.nextNode());
                if ( !(stream_labelExpr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_labelExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_labelExpr.nextTree());

                }
                stream_labelExpr.reset();

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

    // $ANTLR start synpred1_AmoebaQuery
    public final void synpred1_AmoebaQuery_fragment() throws RecognitionException {   
        AmoebaQueryParser.comparisonOp_return c = null;


        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:382:4: ( labelExpr c= comparisonOp labelExpr )
        // c:\\Users\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQuery.g:382:4: labelExpr c= comparisonOp labelExpr
        {
        pushFollow(FOLLOW_labelExpr_in_synpred1_AmoebaQuery1802);
        labelExpr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_comparisonOp_in_synpred1_AmoebaQuery1806);
        c=comparisonOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_labelExpr_in_synpred1_AmoebaQuery1808);
        labelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_AmoebaQuery

    // Delegated rules

    public final boolean synpred1_AmoebaQuery() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_AmoebaQuery_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    static final String DFA2_eotS =
        "\25\uffff";
    static final String DFA2_eofS =
        "\1\1\24\uffff";
    static final String DFA2_minS =
        "\1\47\24\uffff";
    static final String DFA2_maxS =
        "\1\132\24\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\20\uffff\1\2\1\uffff\1\3";
    static final String DFA2_specialS =
        "\25\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\22\1\uffff\2\1\5\uffff\6\1\1\uffff\5\1\1\uffff\2\1\2\uffff"+
            "\1\1\5\uffff\1\22\4\uffff\1\24\5\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\4\1",
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
            return "221:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );";
        }
    }
    static final String DFA3_eotS =
        "\25\uffff";
    static final String DFA3_eofS =
        "\1\uffff\1\4\23\uffff";
    static final String DFA3_minS =
        "\2\47\23\uffff";
    static final String DFA3_maxS =
        "\1\107\1\132\23\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\20\uffff";
    static final String DFA3_specialS =
        "\25\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\37\uffff\1\1",
            "\1\2\1\uffff\2\4\5\uffff\6\4\1\uffff\5\4\1\uffff\2\4\2\uffff"+
            "\1\4\20\uffff\1\4\2\uffff\1\4\1\uffff\4\4",
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
            return "226:1: numericLiteral : ( integerLiteral | decimalLiteral );";
        }
    }
    static final String DFA8_eotS =
        "\12\uffff";
    static final String DFA8_eofS =
        "\1\2\11\uffff";
    static final String DFA8_minS =
        "\1\51\11\uffff";
    static final String DFA8_maxS =
        "\1\122\11\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\7\uffff";
    static final String DFA8_specialS =
        "\12\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\15\uffff\1\2\3\uffff\1\2\1\uffff\2\2\2\uffff\1\2\16\uffff"+
            "\2\1\1\2",
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
            return "252:16: ( rangeType )?";
        }
    }
    static final String DFA26_eotS =
        "\14\uffff";
    static final String DFA26_eofS =
        "\1\2\13\uffff";
    static final String DFA26_minS =
        "\1\52\13\uffff";
    static final String DFA26_maxS =
        "\1\127\13\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA26_specialS =
        "\14\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\14\uffff\1\2\1\1\1\2\1\uffff\1\2\1\uffff\2\2\2\uffff\1"+
            "\2\20\uffff\1\2\4\uffff\1\2",
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

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "340:24: ( fromClause )?";
        }
    }
    static final String DFA27_eotS =
        "\13\uffff";
    static final String DFA27_eofS =
        "\1\2\12\uffff";
    static final String DFA27_minS =
        "\1\52\12\uffff";
    static final String DFA27_maxS =
        "\1\127\12\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA27_specialS =
        "\13\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\14\uffff\1\2\1\uffff\1\1\1\uffff\1\2\1\uffff\2\2\2\uffff"+
            "\1\2\20\uffff\1\2\4\uffff\1\2",
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "340:36: ( whereClause )?";
        }
    }
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\1\2\11\uffff";
    static final String DFA28_minS =
        "\1\52\11\uffff";
    static final String DFA28_maxS =
        "\1\127\11\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\7\uffff";
    static final String DFA28_specialS =
        "\12\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\14\uffff\1\2\3\uffff\1\2\1\uffff\2\2\2\uffff\1\2\20\uffff"+
            "\1\2\4\uffff\1\1",
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

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "340:49: ( orderByClause )?";
        }
    }
    static final String DFA30_eotS =
        "\22\uffff";
    static final String DFA30_eofS =
        "\1\1\21\uffff";
    static final String DFA30_minS =
        "\1\47\21\uffff";
    static final String DFA30_maxS =
        "\1\127\21\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\17\uffff\1\2";
    static final String DFA30_specialS =
        "\22\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\2\1\4\uffff\1\21\7\uffff\3\1\1\uffff\1\1\1\uffff"+
            "\2\1\2\uffff\1\1\5\uffff\1\1\4\uffff\1\1\1\uffff\1\1\3\uffff"+
            "\1\1\4\uffff\1\1",
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "345:1: selectTarget : ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL );";
        }
    }
    static final String DFA29_eotS =
        "\15\uffff";
    static final String DFA29_eofS =
        "\1\1\14\uffff";
    static final String DFA29_minS =
        "\1\51\14\uffff";
    static final String DFA29_maxS =
        "\1\127\14\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA29_specialS =
        "\15\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\14\1\1\14\uffff\3\1\1\uffff\1\1\1\uffff\2\1\2\uffff\1\1"+
            "\20\uffff\1\1\4\uffff\1\1",
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()* loopback of 346:14: ( Comma labelExpr )*";
        }
    }
    static final String DFA31_eotS =
        "\14\uffff";
    static final String DFA31_eofS =
        "\1\1\13\uffff";
    static final String DFA31_minS =
        "\1\51\13\uffff";
    static final String DFA31_maxS =
        "\1\127\13\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA31_specialS =
        "\14\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\13\1\1\14\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\20\uffff\1\1\4\uffff\1\1",
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

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "()* loopback of 351:20: ( Comma fromTarget )*";
        }
    }
    static final String DFA32_eotS =
        "\15\uffff";
    static final String DFA32_eofS =
        "\1\2\14\uffff";
    static final String DFA32_minS =
        "\1\51\14\uffff";
    static final String DFA32_maxS =
        "\1\127\14\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA32_specialS =
        "\15\uffff}>";
    static final String[] DFA32_transitionS = {
            "\2\2\14\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\2\2\2\uffff"+
            "\1\2\20\uffff\1\2\3\uffff\1\1\1\2",
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "355:39: ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )?";
        }
    }
    static final String DFA34_eotS =
        "\12\uffff";
    static final String DFA34_eofS =
        "\1\1\11\uffff";
    static final String DFA34_minS =
        "\1\51\11\uffff";
    static final String DFA34_maxS =
        "\1\122\11\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA34_specialS =
        "\12\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\11\1\1\14\uffff\1\1\3\uffff\1\1\1\uffff\2\1\2\uffff\1\1"+
            "\20\uffff\1\1",
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

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "()* loopback of 368:32: ( Comma attributeName )*";
        }
    }
    static final String DFA35_eotS =
        "\13\uffff";
    static final String DFA35_eofS =
        "\1\1\12\uffff";
    static final String DFA35_minS =
        "\1\52\12\uffff";
    static final String DFA35_maxS =
        "\1\130\12\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\2\10\uffff\1\1";
    static final String DFA35_specialS =
        "\13\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\14\uffff\1\1\3\uffff\1\1\1\uffff\2\1\2\uffff\1\1\20\uffff"+
            "\1\1\4\uffff\1\1\1\12",
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

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 373:25: ( 'or' a= andExpr -> ^( OR $orExpr $a) )*";
        }
    }
    static final String DFA36_eotS =
        "\14\uffff";
    static final String DFA36_eofS =
        "\1\1\13\uffff";
    static final String DFA36_minS =
        "\1\52\13\uffff";
    static final String DFA36_maxS =
        "\1\131\13\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA36_specialS =
        "\14\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\14\uffff\1\1\3\uffff\1\1\1\uffff\2\1\2\uffff\1\1\20\uffff"+
            "\1\1\4\uffff\2\1\1\13",
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

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 377:37: ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )*";
        }
    }
    static final String DFA37_eotS =
        "\34\uffff";
    static final String DFA37_eofS =
        "\34\uffff";
    static final String DFA37_minS =
        "\2\47\1\uffff\1\47\1\107\1\60\1\uffff\1\47\1\57\2\uffff\1\107\2"+
        "\uffff\1\60\2\uffff\11\0\2\uffff";
    static final String DFA37_maxS =
        "\2\132\1\uffff\1\132\1\107\1\132\1\uffff\2\116\2\uffff\1\107\2"+
        "\uffff\1\132\2\uffff\11\0\2\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\1\3\uffff\1\2\25\uffff";
    static final String DFA37_specialS =
        "\21\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\4\10\uffff\6\2\4\uffff\1\6\14\uffff\1\3\4\uffff\1\5\1\uffff"+
            "\1\1\13\uffff\1\2",
            "\1\10\3\uffff\1\7\4\uffff\6\2\4\uffff\1\6\37\uffff\1\2",
            "",
            "\1\13\10\uffff\6\2\4\uffff\1\6\37\uffff\1\2",
            "\1\16",
            "\6\2\4\uffff\1\6\37\uffff\1\2",
            "",
            "\1\25\1\uffff\1\22\1\23\34\uffff\1\24\4\uffff\1\26\1\uffff"+
            "\1\21",
            "\1\30\36\uffff\1\27",
            "",
            "",
            "\1\31",
            "",
            "",
            "\6\2\4\uffff\1\6\37\uffff\1\2",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "381:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_17 = input.LA(1);

                         
                        int index37_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_18 = input.LA(1);

                         
                        int index37_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_19 = input.LA(1);

                         
                        int index37_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_19);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_20 = input.LA(1);

                         
                        int index37_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_20);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_21 = input.LA(1);

                         
                        int index37_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_21);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_22 = input.LA(1);

                         
                        int index37_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_22);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_23 = input.LA(1);

                         
                        int index37_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_23);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_24 = input.LA(1);

                         
                        int index37_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_24);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA37_25 = input.LA(1);

                         
                        int index37_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_AmoebaQuery()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index37_25);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\47\uffff";
    static final String DFA38_eofS =
        "\1\2\1\26\45\uffff";
    static final String DFA38_minS =
        "\2\47\45\uffff";
    static final String DFA38_maxS =
        "\2\132\45\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\3\22\uffff\1\1\1\2\20\uffff";
    static final String DFA38_specialS =
        "\47\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\2\1\uffff\2\2\5\uffff\6\2\1\uffff\5\2\1\uffff\2\2\2\uffff"+
            "\1\2\5\uffff\1\2\4\uffff\1\2\1\uffff\1\1\3\uffff\1\2\4\uffff"+
            "\4\2",
            "\1\26\1\uffff\2\26\1\25\4\uffff\6\26\1\uffff\5\26\1\uffff"+
            "\2\26\2\uffff\1\26\20\uffff\1\26\4\uffff\4\26",
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

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "390:1: labelExpr : ( function | attributeName | value -> ^( VALUE value ) );";
        }
    }
    static final String DFA39_eotS =
        "\26\uffff";
    static final String DFA39_eofS =
        "\1\uffff\1\3\24\uffff";
    static final String DFA39_minS =
        "\1\116\1\47\1\57\23\uffff";
    static final String DFA39_maxS =
        "\1\116\1\132\1\116\23\uffff";
    static final String DFA39_acceptS =
        "\3\uffff\1\1\20\uffff\1\2\1\3";
    static final String DFA39_specialS =
        "\26\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1",
            "\1\2\1\uffff\2\3\5\uffff\6\3\1\uffff\5\3\1\uffff\2\3\2\uffff"+
            "\1\3\20\uffff\1\3\4\uffff\4\3",
            "\1\25\36\uffff\1\24",
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "400:1: attributeName : (qn= QName -> ^( ATTRIBUTE[$qn] ) | relation= QName Dot at= QName -> ^( REF $relation $at) | relation= QName Dot Wildcard -> ^( REF_ALL $relation) );";
        }
    }
 

    public static final BitSet FOLLOW_Digits_in_integerLiteral747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral753 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral758 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerLiteral_in_numericLiteral807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimalLiteral_in_numericLiteral813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_lang828 = new BitSet(new long[]{0x6880000000000002L,0x0000000000040002L});
    public static final BitSet FOLLOW_objectDefExpr_in_expr849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_amoebaQuery_in_expr854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationshipExpr_in_expr859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_divideExpr_in_expr864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIVIDE_in_divideExpr877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_divideExpr879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_divideExpr881 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_divideElem_in_divideExpr883 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_divideExpr886 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_divideElem_in_divideExpr888 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_divideElem915 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_divideElem917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_divideElem929 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_divideElem931 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_rangeType_in_divideElem933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_rangeType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relationship_in_relationshipExpr970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_relationshipExpr974 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_HasMany_in_relationshipExpr976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_objectList_in_relationshipExpr978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Relationship_in_relationshipExpr994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_relationshipExpr998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_HasOne_in_relationshipExpr1000 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_objectList_in_relationshipExpr1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_qnameList1024 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_qnameList1027 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_qnameList1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_object_in_objectList1048 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_objectList1051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_object_in_objectList1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_object1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Object_in_objectDefExpr1089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_objectDefExpr1093 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LParen_in_objectDefExpr1095 = new BitSet(new long[]{0x0040040000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeDefExpr_in_objectDefExpr1097 = new BitSet(new long[]{0x0040040000000000L});
    public static final BitSet FOLLOW_SPLIT_in_objectDefExpr1101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeList_in_objectDefExpr1105 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RParen_in_objectDefExpr1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeDef_in_attributeDefExpr1143 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_attributeDefExpr1146 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeDef_in_attributeDefExpr1148 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_QName_in_attributeDef1166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_DataType_in_attributeDef1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributeList1190 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_attributeList1193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeName_in_attributeList1195 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_QName_in_attribute1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectExpr_in_amoebaQuery1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateExpr_in_amoebaQuery1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Insert_in_updateExpr1248 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_newRelation_in_updateExpr1250 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_Into_in_updateExpr1253 = new BitSet(new long[]{0x0000080000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_targetRelation_in_updateExpr1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_updateExpr1285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_updateExpr1287 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_newRelation_in_updateExpr1289 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_whereClause_in_updateExpr1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_newRelation1327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_tupleElement_in_newRelation1329 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_Comma_in_newRelation1332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_tupleElement_in_newRelation1334 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_RParen_in_newRelation1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_tupleElement1358 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_tupleElement1366 = new BitSet(new long[]{0x0000008000000000L,0x0000000000101080L});
    public static final BitSet FOLLOW_elementValue_in_tupleElement1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_elementValue1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_elementValue1412 = new BitSet(new long[]{0x0000008000000000L,0x0000000000101080L});
    public static final BitSet FOLLOW_elementValue_in_elementValue1414 = new BitSet(new long[]{0x0000020000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_Comma_in_elementValue1417 = new BitSet(new long[]{0x0000008000000000L,0x0000000000101080L});
    public static final BitSet FOLLOW_elementValue_in_elementValue1419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_elementValue1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectExpr_in_exprSingle1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subQuery_in_exprSingle1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_subQuery1465 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_selectExpr_in_subQuery1467 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RParen_in_subQuery1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Select_in_selectExpr1490 = new BitSet(new long[]{0x0000808000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_selectTarget_in_selectExpr1492 = new BitSet(new long[]{0x0300000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_fromClause_in_selectExpr1494 = new BitSet(new long[]{0x0200000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_whereClause_in_selectExpr1497 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_orderByClause_in_selectExpr1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_selectTarget1544 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_selectTarget1547 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_labelExpr_in_selectTarget1549 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Wildcard_in_selectTarget1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_From_in_fromClause1580 = new BitSet(new long[]{0x0000080000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_fromTarget_in_fromClause1582 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_fromClause1585 = new BitSet(new long[]{0x0000080000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_fromTarget_in_fromClause1587 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_targetRelation_in_fromTarget1606 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_fromTarget1614 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_fromTarget1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_targetRelation1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subQuery_in_targetRelation1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Where_in_whereClause1666 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_orExpr_in_whereClause1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_orderByClause1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_orderByClause1683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeName_in_orderByClause1686 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_Comma_in_orderByClause1689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_attributeName_in_orderByClause1691 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1714 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_orExpr1722 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1726 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_conditionExpr_in_andExpr1754 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_andExpr1762 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_conditionExpr_in_andExpr1766 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1802 = new BitSet(new long[]{0x003F000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_comparisonOp_in_conditionExpr1806 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1828 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_In_in_conditionExpr1830 = new BitSet(new long[]{0x0000080000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_subQuery_in_conditionExpr1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparisonOp1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_labelExpr1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_labelExpr1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_labelExpr1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_value1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeName1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeName1950 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_Dot_in_attributeName1952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_QName_in_attributeName1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeName1975 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_Dot_in_attributeName1977 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_Wildcard_in_attributeName1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_function2003 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LParen_in_function2005 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_labelExpr_in_function2007 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_Comma_in_function2010 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_labelExpr_in_function2012 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_RParen_in_function2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_synpred1_AmoebaQuery1802 = new BitSet(new long[]{0x003F000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_comparisonOp_in_synpred1_AmoebaQuery1806 = new BitSet(new long[]{0x0000008000000000L,0x0000000000005080L});
    public static final BitSet FOLLOW_labelExpr_in_synpred1_AmoebaQuery1808 = new BitSet(new long[]{0x0000000000000002L});

}
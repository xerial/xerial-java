// $ANTLR 3.0.1 AmoebaQuery.g 2007-09-13 13:36:48

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
package org.xerial.amoeba.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class AmoebaQueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "SELECTION", "CONDITION", "PROJECTION", "PROJECT_ALL", "TARGET", "FUNCTION", "AND", "OR", "INPUT", "OUTPUT", "ASSIGN_LABEL", "COMPARE", "ATTRIBUTE", "REF", "VALUE", "CONTAINED_IN", "RELATION", "INSERT", "VALUE_SET", "NEW_VALUE", "NEW_RELATION", "UPDATE", "ML_COMMENT", "LINE_COMMENT", "Dot", "Colon", "Comma", "RParen", "LParen", "Quot", "Apos", "At", "Wildcard", "EQUAL", "NOT_EQUAL", "LESS", "LEQ", "GREATER", "GEQ", "Select", "From", "Where", "In", "Insert", "Into", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "Name", "QName", "'update'", "'set'", "'{'", "'}'", "'as'", "'or'", "'and'", "'like'"
    };
    public static final int FUNCTION=11;
    public static final int Insert=49;
    public static final int Apos=36;
    public static final int Wildcard=38;
    public static final int ATTRIBUTE=18;
    public static final int Where=47;
    public static final int INPUT=14;
    public static final int UPDATE=27;
    public static final int CONDITION=7;
    public static final int Into=50;
    public static final int AND=12;
    public static final int EOF=-1;
    public static final int SELECTION=6;
    public static final int ML_COMMENT=28;
    public static final int GREATER=43;
    public static final int ASSIGN_LABEL=16;
    public static final int INSERT=23;
    public static final int Digits=53;
    public static final int CONTAINED_IN=21;
    public static final int NOT_EQUAL=40;
    public static final int WhiteSpaceChar=55;
    public static final int NEW_VALUE=25;
    public static final int EQUAL=39;
    public static final int LESS=41;
    public static final int COMPARE=17;
    public static final int Select=45;
    public static final int GEQ=44;
    public static final int VALUE_SET=24;
    public static final int NEW_RELATION=26;
    public static final int Quot=35;
    public static final int PROJECT_ALL=9;
    public static final int RParen=33;
    public static final int In=48;
    public static final int QName=58;
    public static final int At=37;
    public static final int LParen=34;
    public static final int LINE_COMMENT=29;
    public static final int NUMBER=4;
    public static final int NameChar=54;
    public static final int RELATION=22;
    public static final int Colon=31;
    public static final int TARGET=10;
    public static final int VALUE=20;
    public static final int Digit=52;
    public static final int From=46;
    public static final int REF=19;
    public static final int StringLiteral=56;
    public static final int OR=13;
    public static final int Name=57;
    public static final int Dot=30;
    public static final int PROJECTION=8;
    public static final int Comma=32;
    public static final int Letter=51;
    public static final int OUTPUT=15;
    public static final int STRING=5;
    public static final int LEQ=42;

        public AmoebaQueryParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[26+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "AmoebaQuery.g"; }


    public static class integerLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start integerLiteral
    // AmoebaQuery.g:185:1: integerLiteral : Digits ;
    public final integerLiteral_return integerLiteral() throws RecognitionException {
        integerLiteral_return retval = new integerLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Digits1=null;

        Object Digits1_tree=null;

        try {
            // AmoebaQuery.g:185:15: ( Digits )
            // AmoebaQuery.g:185:17: Digits
            {
            root_0 = (Object)adaptor.nil();

            Digits1=(Token)input.LT(1);
            match(input,Digits,FOLLOW_Digits_in_integerLiteral558); if (failed) return retval;
            if ( backtracking==0 ) {
            Digits1_tree = (Object)adaptor.create(Digits1);
            adaptor.addChild(root_0, Digits1_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end integerLiteral

    public static class decimalLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start decimalLiteral
    // AmoebaQuery.g:186:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );
    public final decimalLiteral_return decimalLiteral() throws RecognitionException {
        decimalLiteral_return retval = new decimalLiteral_return();
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
            // AmoebaQuery.g:186:15: ( Dot Digits | Digits Dot Digits )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Dot) ) {
                alt1=1;
            }
            else if ( (LA1_0==Digits) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("186:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // AmoebaQuery.g:186:17: Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Dot2=(Token)input.LT(1);
                    match(input,Dot,FOLLOW_Dot_in_decimalLiteral564); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Dot2_tree = (Object)adaptor.create(Dot2);
                    adaptor.addChild(root_0, Dot2_tree);
                    }
                    Digits3=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral566); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Digits3_tree = (Object)adaptor.create(Digits3);
                    adaptor.addChild(root_0, Digits3_tree);
                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:186:29: Digits Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Digits4=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral569); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Digits4_tree = (Object)adaptor.create(Digits4);
                    adaptor.addChild(root_0, Digits4_tree);
                    }
                    Dot5=(Token)input.LT(1);
                    match(input,Dot,FOLLOW_Dot_in_decimalLiteral571); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Dot5_tree = (Object)adaptor.create(Dot5);
                    adaptor.addChild(root_0, Dot5_tree);
                    }
                    Digits6=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral573); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Digits6_tree = (Object)adaptor.create(Digits6);
                    adaptor.addChild(root_0, Digits6_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end decimalLiteral

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // AmoebaQuery.g:188:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );
    public final literal_return literal() throws RecognitionException {
        literal_return retval = new literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral8=null;
        numericLiteral_return numericLiteral7 = null;


        Object StringLiteral8_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleSubtreeStream stream_numericLiteral=new RewriteRuleSubtreeStream(adaptor,"rule numericLiteral");
        try {
            // AmoebaQuery.g:188:8: ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case EOF:
            case Comma:
            case RParen:
            case EQUAL:
            case NOT_EQUAL:
            case LESS:
            case LEQ:
            case GREATER:
            case GEQ:
            case From:
            case Where:
            case In:
            case 62:
            case 64:
            case 65:
            case 66:
                {
                alt2=1;
                }
                break;
            case Dot:
            case Digits:
                {
                alt2=2;
                }
                break;
            case StringLiteral:
                {
                alt2=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("188:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // AmoebaQuery.g:189:2: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:189:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal584);
                    numericLiteral7=numericLiteral();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_numericLiteral.add(numericLiteral7.getTree());

                    // AST REWRITE
                    // elements: numericLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 189:19: -> ^( NUMBER numericLiteral )
                    {
                        // AmoebaQuery.g:189:22: ^( NUMBER numericLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(NUMBER, "NUMBER"), root_1);

                        adaptor.addChild(root_1, stream_numericLiteral.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // AmoebaQuery.g:190:4: StringLiteral
                    {
                    StringLiteral8=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal597); if (failed) return retval;
                    if ( backtracking==0 ) stream_StringLiteral.add(StringLiteral8);


                    // AST REWRITE
                    // elements: StringLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 190:18: -> ^( STRING StringLiteral )
                    {
                        // AmoebaQuery.g:190:21: ^( STRING StringLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literal

    public static class numericLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start numericLiteral
    // AmoebaQuery.g:193:1: numericLiteral : ( integerLiteral | decimalLiteral );
    public final numericLiteral_return numericLiteral() throws RecognitionException {
        numericLiteral_return retval = new numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        integerLiteral_return integerLiteral9 = null;

        decimalLiteral_return decimalLiteral10 = null;



        try {
            // AmoebaQuery.g:194:2: ( integerLiteral | decimalLiteral )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Digits) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==Dot) ) {
                    alt3=2;
                }
                else if ( (LA3_1==EOF||(LA3_1>=Comma && LA3_1<=RParen)||(LA3_1>=EQUAL && LA3_1<=GEQ)||(LA3_1>=From && LA3_1<=In)||LA3_1==62||(LA3_1>=64 && LA3_1<=66)) ) {
                    alt3=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("193:1: numericLiteral : ( integerLiteral | decimalLiteral );", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==Dot) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("193:1: numericLiteral : ( integerLiteral | decimalLiteral );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // AmoebaQuery.g:194:4: integerLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integerLiteral_in_numericLiteral617);
                    integerLiteral9=integerLiteral();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, integerLiteral9.getTree());

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:195:4: decimalLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decimalLiteral_in_numericLiteral623);
                    decimalLiteral10=decimalLiteral();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, decimalLiteral10.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end numericLiteral

    public static class amoebaQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start amoebaQuery
    // AmoebaQuery.g:201:1: amoebaQuery : ( selectExpr | updateExpr );
    public final amoebaQuery_return amoebaQuery() throws RecognitionException {
        amoebaQuery_return retval = new amoebaQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        selectExpr_return selectExpr11 = null;

        updateExpr_return updateExpr12 = null;



        try {
            // AmoebaQuery.g:202:2: ( selectExpr | updateExpr )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Select) ) {
                alt4=1;
            }
            else if ( (LA4_0==Insert||LA4_0==59) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("201:1: amoebaQuery : ( selectExpr | updateExpr );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // AmoebaQuery.g:202:4: selectExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectExpr_in_amoebaQuery638);
                    selectExpr11=selectExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, selectExpr11.getTree());

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:203:4: updateExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_updateExpr_in_amoebaQuery643);
                    updateExpr12=updateExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, updateExpr12.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end amoebaQuery

    public static class updateExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start updateExpr
    // AmoebaQuery.g:206:1: updateExpr : ( Insert newRelation ( Into targetRelation )? -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? ) | 'update' 'set' newRelation ( whereClause )? -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? ) );
    public final updateExpr_return updateExpr() throws RecognitionException {
        updateExpr_return retval = new updateExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Insert13=null;
        Token Into15=null;
        Token string_literal17=null;
        Token string_literal18=null;
        newRelation_return newRelation14 = null;

        targetRelation_return targetRelation16 = null;

        newRelation_return newRelation19 = null;

        whereClause_return whereClause20 = null;


        Object Insert13_tree=null;
        Object Into15_tree=null;
        Object string_literal17_tree=null;
        Object string_literal18_tree=null;
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_Insert=new RewriteRuleTokenStream(adaptor,"token Insert");
        RewriteRuleTokenStream stream_Into=new RewriteRuleTokenStream(adaptor,"token Into");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleSubtreeStream stream_whereClause=new RewriteRuleSubtreeStream(adaptor,"rule whereClause");
        RewriteRuleSubtreeStream stream_newRelation=new RewriteRuleSubtreeStream(adaptor,"rule newRelation");
        RewriteRuleSubtreeStream stream_targetRelation=new RewriteRuleSubtreeStream(adaptor,"rule targetRelation");
        try {
            // AmoebaQuery.g:207:2: ( Insert newRelation ( Into targetRelation )? -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? ) | 'update' 'set' newRelation ( whereClause )? -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Insert) ) {
                alt7=1;
            }
            else if ( (LA7_0==59) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("206:1: updateExpr : ( Insert newRelation ( Into targetRelation )? -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? ) | 'update' 'set' newRelation ( whereClause )? -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // AmoebaQuery.g:207:4: Insert newRelation ( Into targetRelation )?
                    {
                    Insert13=(Token)input.LT(1);
                    match(input,Insert,FOLLOW_Insert_in_updateExpr655); if (failed) return retval;
                    if ( backtracking==0 ) stream_Insert.add(Insert13);

                    pushFollow(FOLLOW_newRelation_in_updateExpr657);
                    newRelation14=newRelation();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_newRelation.add(newRelation14.getTree());
                    // AmoebaQuery.g:207:23: ( Into targetRelation )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==Into) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // AmoebaQuery.g:207:24: Into targetRelation
                            {
                            Into15=(Token)input.LT(1);
                            match(input,Into,FOLLOW_Into_in_updateExpr660); if (failed) return retval;
                            if ( backtracking==0 ) stream_Into.add(Into15);

                            pushFollow(FOLLOW_targetRelation_in_updateExpr662);
                            targetRelation16=targetRelation();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_targetRelation.add(targetRelation16.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: newRelation, targetRelation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 208:4: -> ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? )
                    {
                        // AmoebaQuery.g:208:7: ^( INSERT ^( NEW_RELATION newRelation ) ( ^( TARGET targetRelation ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(INSERT, "INSERT"), root_1);

                        // AmoebaQuery.g:208:16: ^( NEW_RELATION newRelation )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(NEW_RELATION, "NEW_RELATION"), root_2);

                        adaptor.addChild(root_2, stream_newRelation.next());

                        adaptor.addChild(root_1, root_2);
                        }
                        // AmoebaQuery.g:208:44: ( ^( TARGET targetRelation ) )?
                        if ( stream_targetRelation.hasNext() ) {
                            // AmoebaQuery.g:208:44: ^( TARGET targetRelation )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(adaptor.create(TARGET, "TARGET"), root_2);

                            adaptor.addChild(root_2, stream_targetRelation.next());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_targetRelation.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:209:4: 'update' 'set' newRelation ( whereClause )?
                    {
                    string_literal17=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_updateExpr692); if (failed) return retval;
                    if ( backtracking==0 ) stream_59.add(string_literal17);

                    string_literal18=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_updateExpr694); if (failed) return retval;
                    if ( backtracking==0 ) stream_60.add(string_literal18);

                    pushFollow(FOLLOW_newRelation_in_updateExpr696);
                    newRelation19=newRelation();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_newRelation.add(newRelation19.getTree());
                    // AmoebaQuery.g:209:31: ( whereClause )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Where) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // AmoebaQuery.g:209:31: whereClause
                            {
                            pushFollow(FOLLOW_whereClause_in_updateExpr698);
                            whereClause20=whereClause();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_whereClause.add(whereClause20.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: newRelation, whereClause
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 210:4: -> ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? )
                    {
                        // AmoebaQuery.g:210:7: ^( UPDATE ^( NEW_RELATION newRelation ) ( ^( CONDITION whereClause ) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(UPDATE, "UPDATE"), root_1);

                        // AmoebaQuery.g:210:16: ^( NEW_RELATION newRelation )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(adaptor.create(NEW_RELATION, "NEW_RELATION"), root_2);

                        adaptor.addChild(root_2, stream_newRelation.next());

                        adaptor.addChild(root_1, root_2);
                        }
                        // AmoebaQuery.g:210:44: ( ^( CONDITION whereClause ) )?
                        if ( stream_whereClause.hasNext() ) {
                            // AmoebaQuery.g:210:44: ^( CONDITION whereClause )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(adaptor.create(CONDITION, "CONDITION"), root_2);

                            adaptor.addChild(root_2, stream_whereClause.next());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_whereClause.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end updateExpr

    public static class newRelation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start newRelation
    // AmoebaQuery.g:213:1: newRelation : LParen tupleElement ( Comma tupleElement )* RParen -> ( tupleElement )+ ;
    public final newRelation_return newRelation() throws RecognitionException {
        newRelation_return retval = new newRelation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen21=null;
        Token Comma23=null;
        Token RParen25=null;
        tupleElement_return tupleElement22 = null;

        tupleElement_return tupleElement24 = null;


        Object LParen21_tree=null;
        Object Comma23_tree=null;
        Object RParen25_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_tupleElement=new RewriteRuleSubtreeStream(adaptor,"rule tupleElement");
        try {
            // AmoebaQuery.g:214:2: ( LParen tupleElement ( Comma tupleElement )* RParen -> ( tupleElement )+ )
            // AmoebaQuery.g:214:4: LParen tupleElement ( Comma tupleElement )* RParen
            {
            LParen21=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_newRelation734); if (failed) return retval;
            if ( backtracking==0 ) stream_LParen.add(LParen21);

            pushFollow(FOLLOW_tupleElement_in_newRelation736);
            tupleElement22=tupleElement();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_tupleElement.add(tupleElement22.getTree());
            // AmoebaQuery.g:214:24: ( Comma tupleElement )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Comma) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // AmoebaQuery.g:214:25: Comma tupleElement
            	    {
            	    Comma23=(Token)input.LT(1);
            	    match(input,Comma,FOLLOW_Comma_in_newRelation739); if (failed) return retval;
            	    if ( backtracking==0 ) stream_Comma.add(Comma23);

            	    pushFollow(FOLLOW_tupleElement_in_newRelation741);
            	    tupleElement24=tupleElement();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_tupleElement.add(tupleElement24.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RParen25=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_newRelation745); if (failed) return retval;
            if ( backtracking==0 ) stream_RParen.add(RParen25);


            // AST REWRITE
            // elements: tupleElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 215:3: -> ( tupleElement )+
            {
                if ( !(stream_tupleElement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_tupleElement.hasNext() ) {
                    adaptor.addChild(root_0, stream_tupleElement.next());

                }
                stream_tupleElement.reset();

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end newRelation

    public static class tupleElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tupleElement
    // AmoebaQuery.g:218:1: tupleElement : ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )? ;
    public final tupleElement_return tupleElement() throws RecognitionException {
        tupleElement_return retval = new tupleElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL27=null;
        elementValue_return e = null;

        attributeName_return attributeName26 = null;


        Object EQUAL27_tree=null;
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_elementValue=new RewriteRuleSubtreeStream(adaptor,"rule elementValue");
        try {
            // AmoebaQuery.g:219:2: ( ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )? )
            // AmoebaQuery.g:219:4: ( attributeName -> attributeName ) ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )?
            {
            // AmoebaQuery.g:219:4: ( attributeName -> attributeName )
            // AmoebaQuery.g:219:5: attributeName
            {
            pushFollow(FOLLOW_attributeName_in_tupleElement765);
            attributeName26=attributeName();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_attributeName.add(attributeName26.getTree());

            // AST REWRITE
            // elements: attributeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 219:19: -> attributeName
            {
                adaptor.addChild(root_0, stream_attributeName.next());

            }

            }

            }

            // AmoebaQuery.g:219:37: ( EQUAL e= elementValue -> ^( NEW_VALUE $tupleElement elementValue ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EQUAL) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // AmoebaQuery.g:219:38: EQUAL e= elementValue
                    {
                    EQUAL27=(Token)input.LT(1);
                    match(input,EQUAL,FOLLOW_EQUAL_in_tupleElement773); if (failed) return retval;
                    if ( backtracking==0 ) stream_EQUAL.add(EQUAL27);

                    pushFollow(FOLLOW_elementValue_in_tupleElement777);
                    e=elementValue();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_elementValue.add(e.getTree());

                    // AST REWRITE
                    // elements: tupleElement, elementValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 219:59: -> ^( NEW_VALUE $tupleElement elementValue )
                    {
                        // AmoebaQuery.g:219:62: ^( NEW_VALUE $tupleElement elementValue )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(NEW_VALUE, "NEW_VALUE"), root_1);

                        adaptor.addChild(root_1, stream_retval.next());
                        adaptor.addChild(root_1, stream_elementValue.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end tupleElement

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elementValue
    // AmoebaQuery.g:222:1: elementValue : ( literal -> ^( VALUE literal ) | '{' elementValue ( Comma elementValue )? '}' -> ^( VALUE_SET ( elementValue )+ ) );
    public final elementValue_return elementValue() throws RecognitionException {
        elementValue_return retval = new elementValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal29=null;
        Token Comma31=null;
        Token char_literal33=null;
        literal_return literal28 = null;

        elementValue_return elementValue30 = null;

        elementValue_return elementValue32 = null;


        Object char_literal29_tree=null;
        Object Comma31_tree=null;
        Object char_literal33_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_elementValue=new RewriteRuleSubtreeStream(adaptor,"rule elementValue");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        try {
            // AmoebaQuery.g:223:2: ( literal -> ^( VALUE literal ) | '{' elementValue ( Comma elementValue )? '}' -> ^( VALUE_SET ( elementValue )+ ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Dot||(LA11_0>=Comma && LA11_0<=RParen)||LA11_0==Digits||LA11_0==StringLiteral||LA11_0==62) ) {
                alt11=1;
            }
            else if ( (LA11_0==61) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("222:1: elementValue : ( literal -> ^( VALUE literal ) | '{' elementValue ( Comma elementValue )? '}' -> ^( VALUE_SET ( elementValue )+ ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // AmoebaQuery.g:223:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_elementValue803);
                    literal28=literal();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_literal.add(literal28.getTree());

                    // AST REWRITE
                    // elements: literal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 224:4: -> ^( VALUE literal )
                    {
                        // AmoebaQuery.g:224:7: ^( VALUE literal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE, "VALUE"), root_1);

                        adaptor.addChild(root_1, stream_literal.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:225:4: '{' elementValue ( Comma elementValue )? '}'
                    {
                    char_literal29=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_elementValue819); if (failed) return retval;
                    if ( backtracking==0 ) stream_61.add(char_literal29);

                    pushFollow(FOLLOW_elementValue_in_elementValue821);
                    elementValue30=elementValue();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_elementValue.add(elementValue30.getTree());
                    // AmoebaQuery.g:225:21: ( Comma elementValue )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==Comma) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // AmoebaQuery.g:225:22: Comma elementValue
                            {
                            Comma31=(Token)input.LT(1);
                            match(input,Comma,FOLLOW_Comma_in_elementValue824); if (failed) return retval;
                            if ( backtracking==0 ) stream_Comma.add(Comma31);

                            pushFollow(FOLLOW_elementValue_in_elementValue826);
                            elementValue32=elementValue();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_elementValue.add(elementValue32.getTree());

                            }
                            break;

                    }

                    char_literal33=(Token)input.LT(1);
                    match(input,62,FOLLOW_62_in_elementValue830); if (failed) return retval;
                    if ( backtracking==0 ) stream_62.add(char_literal33);


                    // AST REWRITE
                    // elements: elementValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 226:4: -> ^( VALUE_SET ( elementValue )+ )
                    {
                        // AmoebaQuery.g:226:7: ^( VALUE_SET ( elementValue )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_SET, "VALUE_SET"), root_1);

                        if ( !(stream_elementValue.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_elementValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementValue.next());

                        }
                        stream_elementValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end elementValue

    public static class exprSingle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start exprSingle
    // AmoebaQuery.g:230:1: exprSingle : ( selectExpr | subQuery );
    public final exprSingle_return exprSingle() throws RecognitionException {
        exprSingle_return retval = new exprSingle_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        selectExpr_return selectExpr34 = null;

        subQuery_return subQuery35 = null;



        try {
            // AmoebaQuery.g:231:2: ( selectExpr | subQuery )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Select) ) {
                alt12=1;
            }
            else if ( (LA12_0==LParen) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("230:1: exprSingle : ( selectExpr | subQuery );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // AmoebaQuery.g:231:4: selectExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectExpr_in_exprSingle855);
                    selectExpr34=selectExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, selectExpr34.getTree());

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:232:4: subQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subQuery_in_exprSingle860);
                    subQuery35=subQuery();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subQuery35.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end exprSingle

    public static class subQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start subQuery
    // AmoebaQuery.g:235:1: subQuery : LParen selectExpr RParen -> selectExpr ;
    public final subQuery_return subQuery() throws RecognitionException {
        subQuery_return retval = new subQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen36=null;
        Token RParen38=null;
        selectExpr_return selectExpr37 = null;


        Object LParen36_tree=null;
        Object RParen38_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_selectExpr=new RewriteRuleSubtreeStream(adaptor,"rule selectExpr");
        try {
            // AmoebaQuery.g:236:2: ( LParen selectExpr RParen -> selectExpr )
            // AmoebaQuery.g:236:4: LParen selectExpr RParen
            {
            LParen36=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_subQuery872); if (failed) return retval;
            if ( backtracking==0 ) stream_LParen.add(LParen36);

            pushFollow(FOLLOW_selectExpr_in_subQuery874);
            selectExpr37=selectExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_selectExpr.add(selectExpr37.getTree());
            RParen38=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_subQuery876); if (failed) return retval;
            if ( backtracking==0 ) stream_RParen.add(RParen38);


            // AST REWRITE
            // elements: selectExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 236:29: -> selectExpr
            {
                adaptor.addChild(root_0, stream_selectExpr.next());

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end subQuery

    public static class selectExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start selectExpr
    // AmoebaQuery.g:240:1: selectExpr : Select selectTarget ( fromClause )? ( whereClause )? -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ) ;
    public final selectExpr_return selectExpr() throws RecognitionException {
        selectExpr_return retval = new selectExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Select39=null;
        selectTarget_return selectTarget40 = null;

        fromClause_return fromClause41 = null;

        whereClause_return whereClause42 = null;


        Object Select39_tree=null;
        RewriteRuleTokenStream stream_Select=new RewriteRuleTokenStream(adaptor,"token Select");
        RewriteRuleSubtreeStream stream_whereClause=new RewriteRuleSubtreeStream(adaptor,"rule whereClause");
        RewriteRuleSubtreeStream stream_selectTarget=new RewriteRuleSubtreeStream(adaptor,"rule selectTarget");
        RewriteRuleSubtreeStream stream_fromClause=new RewriteRuleSubtreeStream(adaptor,"rule fromClause");
        try {
            // AmoebaQuery.g:241:2: ( Select selectTarget ( fromClause )? ( whereClause )? -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? ) )
            // AmoebaQuery.g:241:4: Select selectTarget ( fromClause )? ( whereClause )?
            {
            Select39=(Token)input.LT(1);
            match(input,Select,FOLLOW_Select_in_selectExpr897); if (failed) return retval;
            if ( backtracking==0 ) stream_Select.add(Select39);

            pushFollow(FOLLOW_selectTarget_in_selectExpr899);
            selectTarget40=selectTarget();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_selectTarget.add(selectTarget40.getTree());
            // AmoebaQuery.g:241:24: ( fromClause )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==From) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // AmoebaQuery.g:241:24: fromClause
                    {
                    pushFollow(FOLLOW_fromClause_in_selectExpr901);
                    fromClause41=fromClause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_fromClause.add(fromClause41.getTree());

                    }
                    break;

            }

            // AmoebaQuery.g:241:36: ( whereClause )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Where) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // AmoebaQuery.g:241:36: whereClause
                    {
                    pushFollow(FOLLOW_whereClause_in_selectExpr904);
                    whereClause42=whereClause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_whereClause.add(whereClause42.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: selectTarget, whereClause, fromClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 242:3: -> ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? )
            {
                // AmoebaQuery.g:242:6: ^( SELECTION selectTarget ( ^( INPUT fromClause ) )? ( ^( CONDITION whereClause ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECTION, "SELECTION"), root_1);

                adaptor.addChild(root_1, stream_selectTarget.next());
                // AmoebaQuery.g:242:31: ( ^( INPUT fromClause ) )?
                if ( stream_fromClause.hasNext() ) {
                    // AmoebaQuery.g:242:31: ^( INPUT fromClause )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(adaptor.create(INPUT, "INPUT"), root_2);

                    adaptor.addChild(root_2, stream_fromClause.next());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_fromClause.reset();
                // AmoebaQuery.g:242:52: ( ^( CONDITION whereClause ) )?
                if ( stream_whereClause.hasNext() ) {
                    // AmoebaQuery.g:242:52: ^( CONDITION whereClause )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(adaptor.create(CONDITION, "CONDITION"), root_2);

                    adaptor.addChild(root_2, stream_whereClause.next());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_whereClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end selectExpr

    public static class selectTarget_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start selectTarget
    // AmoebaQuery.g:246:1: selectTarget : ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL );
    public final selectTarget_return selectTarget() throws RecognitionException {
        selectTarget_return retval = new selectTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Comma44=null;
        Token Wildcard46=null;
        labelExpr_return labelExpr43 = null;

        labelExpr_return labelExpr45 = null;


        Object Comma44_tree=null;
        Object Wildcard46_tree=null;
        RewriteRuleTokenStream stream_Wildcard=new RewriteRuleTokenStream(adaptor,"token Wildcard");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // AmoebaQuery.g:247:2: ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EOF||LA16_0==Dot||(LA16_0>=Comma && LA16_0<=RParen)||(LA16_0>=From && LA16_0<=Where)||LA16_0==Digits||LA16_0==StringLiteral||LA16_0==QName) ) {
                alt16=1;
            }
            else if ( (LA16_0==Wildcard) ) {
                alt16=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("246:1: selectTarget : ( labelExpr ( Comma labelExpr )* -> ^( PROJECTION ( labelExpr )+ ) | Wildcard -> PROJECT_ALL );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // AmoebaQuery.g:247:4: labelExpr ( Comma labelExpr )*
                    {
                    pushFollow(FOLLOW_labelExpr_in_selectTarget941);
                    labelExpr43=labelExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_labelExpr.add(labelExpr43.getTree());
                    // AmoebaQuery.g:247:14: ( Comma labelExpr )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==Comma) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // AmoebaQuery.g:247:15: Comma labelExpr
                    	    {
                    	    Comma44=(Token)input.LT(1);
                    	    match(input,Comma,FOLLOW_Comma_in_selectTarget944); if (failed) return retval;
                    	    if ( backtracking==0 ) stream_Comma.add(Comma44);

                    	    pushFollow(FOLLOW_labelExpr_in_selectTarget946);
                    	    labelExpr45=labelExpr();
                    	    _fsp--;
                    	    if (failed) return retval;
                    	    if ( backtracking==0 ) stream_labelExpr.add(labelExpr45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    // AST REWRITE
                    // elements: labelExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 247:33: -> ^( PROJECTION ( labelExpr )+ )
                    {
                        // AmoebaQuery.g:247:36: ^( PROJECTION ( labelExpr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(PROJECTION, "PROJECTION"), root_1);

                        if ( !(stream_labelExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_labelExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_labelExpr.next());

                        }
                        stream_labelExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:248:4: Wildcard
                    {
                    Wildcard46=(Token)input.LT(1);
                    match(input,Wildcard,FOLLOW_Wildcard_in_selectTarget962); if (failed) return retval;
                    if ( backtracking==0 ) stream_Wildcard.add(Wildcard46);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 248:13: -> PROJECT_ALL
                    {
                        adaptor.addChild(root_0, adaptor.create(PROJECT_ALL, "PROJECT_ALL"));

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end selectTarget

    public static class fromClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fromClause
    // AmoebaQuery.g:251:1: fromClause : From fromTarget ( Comma fromTarget )* -> ( fromTarget )+ ;
    public final fromClause_return fromClause() throws RecognitionException {
        fromClause_return retval = new fromClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token From47=null;
        Token Comma49=null;
        fromTarget_return fromTarget48 = null;

        fromTarget_return fromTarget50 = null;


        Object From47_tree=null;
        Object Comma49_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_From=new RewriteRuleTokenStream(adaptor,"token From");
        RewriteRuleSubtreeStream stream_fromTarget=new RewriteRuleSubtreeStream(adaptor,"rule fromTarget");
        try {
            // AmoebaQuery.g:252:2: ( From fromTarget ( Comma fromTarget )* -> ( fromTarget )+ )
            // AmoebaQuery.g:252:4: From fromTarget ( Comma fromTarget )*
            {
            From47=(Token)input.LT(1);
            match(input,From,FOLLOW_From_in_fromClause977); if (failed) return retval;
            if ( backtracking==0 ) stream_From.add(From47);

            pushFollow(FOLLOW_fromTarget_in_fromClause979);
            fromTarget48=fromTarget();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_fromTarget.add(fromTarget48.getTree());
            // AmoebaQuery.g:252:20: ( Comma fromTarget )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Comma) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // AmoebaQuery.g:252:21: Comma fromTarget
            	    {
            	    Comma49=(Token)input.LT(1);
            	    match(input,Comma,FOLLOW_Comma_in_fromClause982); if (failed) return retval;
            	    if ( backtracking==0 ) stream_Comma.add(Comma49);

            	    pushFollow(FOLLOW_fromTarget_in_fromClause984);
            	    fromTarget50=fromTarget();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_fromTarget.add(fromTarget50.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            // AST REWRITE
            // elements: fromTarget
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 252:40: -> ( fromTarget )+
            {
                if ( !(stream_fromTarget.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_fromTarget.hasNext() ) {
                    adaptor.addChild(root_0, stream_fromTarget.next());

                }
                stream_fromTarget.reset();

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end fromClause

    public static class fromTarget_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fromTarget
    // AmoebaQuery.g:255:1: fromTarget : ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )? ;
    public final fromTarget_return fromTarget() throws RecognitionException {
        fromTarget_return retval = new fromTarget_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal52=null;
        Token QName53=null;
        targetRelation_return targetRelation51 = null;


        Object string_literal52_tree=null;
        Object QName53_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_targetRelation=new RewriteRuleSubtreeStream(adaptor,"rule targetRelation");
        try {
            // AmoebaQuery.g:256:2: ( ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )? )
            // AmoebaQuery.g:256:4: ( targetRelation -> targetRelation ) ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )?
            {
            // AmoebaQuery.g:256:4: ( targetRelation -> targetRelation )
            // AmoebaQuery.g:256:5: targetRelation
            {
            pushFollow(FOLLOW_targetRelation_in_fromTarget1003);
            targetRelation51=targetRelation();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_targetRelation.add(targetRelation51.getTree());

            // AST REWRITE
            // elements: targetRelation
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 256:20: -> targetRelation
            {
                adaptor.addChild(root_0, stream_targetRelation.next());

            }

            }

            }

            // AmoebaQuery.g:256:39: ( 'as' QName -> ^( ASSIGN_LABEL QName $fromTarget) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==63) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // AmoebaQuery.g:256:40: 'as' QName
                    {
                    string_literal52=(Token)input.LT(1);
                    match(input,63,FOLLOW_63_in_fromTarget1011); if (failed) return retval;
                    if ( backtracking==0 ) stream_63.add(string_literal52);

                    QName53=(Token)input.LT(1);
                    match(input,QName,FOLLOW_QName_in_fromTarget1013); if (failed) return retval;
                    if ( backtracking==0 ) stream_QName.add(QName53);


                    // AST REWRITE
                    // elements: fromTarget, QName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 256:51: -> ^( ASSIGN_LABEL QName $fromTarget)
                    {
                        // AmoebaQuery.g:256:54: ^( ASSIGN_LABEL QName $fromTarget)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(ASSIGN_LABEL, "ASSIGN_LABEL"), root_1);

                        adaptor.addChild(root_1, stream_QName.next());
                        adaptor.addChild(root_1, stream_retval.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end fromTarget

    public static class targetRelation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start targetRelation
    // AmoebaQuery.g:259:1: targetRelation : ( QName -> ^( RELATION QName ) | subQuery );
    public final targetRelation_return targetRelation() throws RecognitionException {
        targetRelation_return retval = new targetRelation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName54=null;
        subQuery_return subQuery55 = null;


        Object QName54_tree=null;
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // AmoebaQuery.g:260:2: ( QName -> ^( RELATION QName ) | subQuery )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QName) ) {
                alt19=1;
            }
            else if ( (LA19_0==LParen) ) {
                alt19=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("259:1: targetRelation : ( QName -> ^( RELATION QName ) | subQuery );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // AmoebaQuery.g:260:4: QName
                    {
                    QName54=(Token)input.LT(1);
                    match(input,QName,FOLLOW_QName_in_targetRelation1039); if (failed) return retval;
                    if ( backtracking==0 ) stream_QName.add(QName54);


                    // AST REWRITE
                    // elements: QName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 260:10: -> ^( RELATION QName )
                    {
                        // AmoebaQuery.g:260:13: ^( RELATION QName )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(RELATION, "RELATION"), root_1);

                        adaptor.addChild(root_1, stream_QName.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:261:4: subQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subQuery_in_targetRelation1052);
                    subQuery55=subQuery();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subQuery55.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end targetRelation

    public static class whereClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whereClause
    // AmoebaQuery.g:264:1: whereClause : Where orExpr ;
    public final whereClause_return whereClause() throws RecognitionException {
        whereClause_return retval = new whereClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Where56=null;
        orExpr_return orExpr57 = null;


        Object Where56_tree=null;

        try {
            // AmoebaQuery.g:265:2: ( Where orExpr )
            // AmoebaQuery.g:265:4: Where orExpr
            {
            root_0 = (Object)adaptor.nil();

            Where56=(Token)input.LT(1);
            match(input,Where,FOLLOW_Where_in_whereClause1063); if (failed) return retval;
            pushFollow(FOLLOW_orExpr_in_whereClause1066);
            orExpr57=orExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, orExpr57.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end whereClause

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orExpr
    // AmoebaQuery.g:268:1: orExpr : ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )* ;
    public final orExpr_return orExpr() throws RecognitionException {
        orExpr_return retval = new orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal59=null;
        andExpr_return a = null;

        andExpr_return andExpr58 = null;


        Object string_literal59_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_andExpr=new RewriteRuleSubtreeStream(adaptor,"rule andExpr");
        try {
            // AmoebaQuery.g:269:2: ( ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )* )
            // AmoebaQuery.g:269:4: ( andExpr -> andExpr ) ( 'or' a= andExpr -> ^( OR $orExpr $a) )*
            {
            // AmoebaQuery.g:269:4: ( andExpr -> andExpr )
            // AmoebaQuery.g:269:5: andExpr
            {
            pushFollow(FOLLOW_andExpr_in_orExpr1080);
            andExpr58=andExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_andExpr.add(andExpr58.getTree());

            // AST REWRITE
            // elements: andExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 269:13: -> andExpr
            {
                adaptor.addChild(root_0, stream_andExpr.next());

            }

            }

            }

            // AmoebaQuery.g:269:25: ( 'or' a= andExpr -> ^( OR $orExpr $a) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==64) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // AmoebaQuery.g:269:26: 'or' a= andExpr
            	    {
            	    string_literal59=(Token)input.LT(1);
            	    match(input,64,FOLLOW_64_in_orExpr1088); if (failed) return retval;
            	    if ( backtracking==0 ) stream_64.add(string_literal59);

            	    pushFollow(FOLLOW_andExpr_in_orExpr1092);
            	    a=andExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_andExpr.add(a.getTree());

            	    // AST REWRITE
            	    // elements: a, orExpr
            	    // token labels: 
            	    // rule labels: retval, a
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",a!=null?a.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 269:41: -> ^( OR $orExpr $a)
            	    {
            	        // AmoebaQuery.g:269:44: ^( OR $orExpr $a)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(OR, "OR"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_a.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end orExpr

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start andExpr
    // AmoebaQuery.g:272:1: andExpr : ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )* ;
    public final andExpr_return andExpr() throws RecognitionException {
        andExpr_return retval = new andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal61=null;
        conditionExpr_return c = null;

        conditionExpr_return conditionExpr60 = null;


        Object string_literal61_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_conditionExpr=new RewriteRuleSubtreeStream(adaptor,"rule conditionExpr");
        try {
            // AmoebaQuery.g:273:2: ( ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )* )
            // AmoebaQuery.g:273:4: ( conditionExpr -> conditionExpr ) ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )*
            {
            // AmoebaQuery.g:273:4: ( conditionExpr -> conditionExpr )
            // AmoebaQuery.g:273:5: conditionExpr
            {
            pushFollow(FOLLOW_conditionExpr_in_andExpr1120);
            conditionExpr60=conditionExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_conditionExpr.add(conditionExpr60.getTree());

            // AST REWRITE
            // elements: conditionExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 273:19: -> conditionExpr
            {
                adaptor.addChild(root_0, stream_conditionExpr.next());

            }

            }

            }

            // AmoebaQuery.g:273:37: ( 'and' c= conditionExpr -> ^( AND $andExpr $c) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==65) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // AmoebaQuery.g:273:38: 'and' c= conditionExpr
            	    {
            	    string_literal61=(Token)input.LT(1);
            	    match(input,65,FOLLOW_65_in_andExpr1128); if (failed) return retval;
            	    if ( backtracking==0 ) stream_65.add(string_literal61);

            	    pushFollow(FOLLOW_conditionExpr_in_andExpr1132);
            	    c=conditionExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_conditionExpr.add(c.getTree());

            	    // AST REWRITE
            	    // elements: andExpr, c
            	    // token labels: 
            	    // rule labels: retval, c
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"token c",c!=null?c.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 273:60: -> ^( AND $andExpr $c)
            	    {
            	        // AmoebaQuery.g:273:63: ^( AND $andExpr $c)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(AND, "AND"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_c.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end andExpr

    public static class conditionExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start conditionExpr
    // AmoebaQuery.g:277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );
    public final conditionExpr_return conditionExpr() throws RecognitionException {
        conditionExpr_return retval = new conditionExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token In65=null;
        comparisonOp_return c = null;

        labelExpr_return labelExpr62 = null;

        labelExpr_return labelExpr63 = null;

        labelExpr_return labelExpr64 = null;

        subQuery_return subQuery66 = null;


        Object In65_tree=null;
        RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
        RewriteRuleSubtreeStream stream_subQuery=new RewriteRuleSubtreeStream(adaptor,"rule subQuery");
        RewriteRuleSubtreeStream stream_comparisonOp=new RewriteRuleSubtreeStream(adaptor,"rule comparisonOp");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // AmoebaQuery.g:278:2: ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) )
            int alt22=2;
            switch ( input.LA(1) ) {
            case QName:
                {
                switch ( input.LA(2) ) {
                case LParen:
                    {
                    switch ( input.LA(3) ) {
                    case QName:
                        {
                        switch ( input.LA(4) ) {
                        case Dot:
                            {
                            int LA22_27 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 27, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LParen:
                            {
                            int LA22_28 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 28, input);

                                throw nvae;
                            }
                            }
                            break;
                        case Comma:
                            {
                            int LA22_29 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 29, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RParen:
                            {
                            int LA22_30 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 30, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 17, input);

                            throw nvae;
                        }

                        }
                        break;
                    case Comma:
                        {
                        switch ( input.LA(4) ) {
                        case QName:
                            {
                            int LA22_31 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 31, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RParen:
                            {
                            int LA22_32 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 32, input);

                                throw nvae;
                            }
                            }
                            break;
                        case Comma:
                            {
                            int LA22_33 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 33, input);

                                throw nvae;
                            }
                            }
                            break;
                        case Digits:
                            {
                            int LA22_34 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 34, input);

                                throw nvae;
                            }
                            }
                            break;
                        case Dot:
                            {
                            int LA22_35 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 35, input);

                                throw nvae;
                            }
                            }
                            break;
                        case StringLiteral:
                            {
                            int LA22_36 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 36, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 18, input);

                            throw nvae;
                        }

                        }
                        break;
                    case RParen:
                        {
                        int LA22_19 = input.LA(4);

                        if ( ((LA22_19>=EQUAL && LA22_19<=GEQ)||LA22_19==66) ) {
                            alt22=1;
                        }
                        else if ( (LA22_19==In) ) {
                            alt22=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 19, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Digits:
                        {
                        switch ( input.LA(4) ) {
                        case Dot:
                            {
                            int LA22_39 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 39, input);

                                throw nvae;
                            }
                            }
                            break;
                        case Comma:
                            {
                            int LA22_40 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 40, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RParen:
                            {
                            int LA22_41 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 41, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 20, input);

                            throw nvae;
                        }

                        }
                        break;
                    case Dot:
                        {
                        int LA22_21 = input.LA(4);

                        if ( (LA22_21==Digits) ) {
                            int LA22_42 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 42, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 21, input);

                            throw nvae;
                        }
                        }
                        break;
                    case StringLiteral:
                        {
                        int LA22_22 = input.LA(4);

                        if ( (LA22_22==Comma) ) {
                            int LA22_43 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 43, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA22_22==RParen) ) {
                            int LA22_44 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt22=1;
                            }
                            else if ( (true) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 44, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 22, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 7, input);

                        throw nvae;
                    }

                    }
                    break;
                case Dot:
                    {
                    int LA22_8 = input.LA(3);

                    if ( (LA22_8==QName) ) {
                        int LA22_23 = input.LA(4);

                        if ( ((LA22_23>=EQUAL && LA22_23<=GEQ)||LA22_23==66) ) {
                            alt22=1;
                        }
                        else if ( (LA22_23==In) ) {
                            alt22=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 23, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case EQUAL:
                case NOT_EQUAL:
                case LESS:
                case LEQ:
                case GREATER:
                case GEQ:
                case 66:
                    {
                    alt22=1;
                    }
                    break;
                case In:
                    {
                    alt22=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 1, input);

                    throw nvae;
                }

                }
                break;
            case EQUAL:
            case NOT_EQUAL:
            case LESS:
            case LEQ:
            case GREATER:
            case GEQ:
            case 66:
                {
                alt22=1;
                }
                break;
            case Digits:
                {
                switch ( input.LA(2) ) {
                case Dot:
                    {
                    int LA22_11 = input.LA(3);

                    if ( (LA22_11==Digits) ) {
                        int LA22_24 = input.LA(4);

                        if ( ((LA22_24>=EQUAL && LA22_24<=GEQ)||LA22_24==66) ) {
                            alt22=1;
                        }
                        else if ( (LA22_24==In) ) {
                            alt22=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 24, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 11, input);

                        throw nvae;
                    }
                    }
                    break;
                case EQUAL:
                case NOT_EQUAL:
                case LESS:
                case LEQ:
                case GREATER:
                case GEQ:
                case 66:
                    {
                    alt22=1;
                    }
                    break;
                case In:
                    {
                    alt22=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 3, input);

                    throw nvae;
                }

                }
                break;
            case Dot:
                {
                int LA22_4 = input.LA(2);

                if ( (LA22_4==Digits) ) {
                    int LA22_14 = input.LA(3);

                    if ( (LA22_14==In) ) {
                        alt22=2;
                    }
                    else if ( ((LA22_14>=EQUAL && LA22_14<=GEQ)||LA22_14==66) ) {
                        alt22=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 14, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 4, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                int LA22_5 = input.LA(2);

                if ( ((LA22_5>=EQUAL && LA22_5<=GEQ)||LA22_5==66) ) {
                    alt22=1;
                }
                else if ( (LA22_5==In) ) {
                    alt22=2;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 5, input);

                    throw nvae;
                }
                }
                break;
            case In:
                {
                alt22=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("277:1: conditionExpr options {backtrack=true; } : ( labelExpr c= comparisonOp labelExpr -> ^( COMPARE comparisonOp ( labelExpr )+ ) | labelExpr In subQuery -> ^( CONTAINED_IN labelExpr subQuery ) );", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // AmoebaQuery.g:278:4: labelExpr c= comparisonOp labelExpr
                    {
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1168);
                    labelExpr62=labelExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_labelExpr.add(labelExpr62.getTree());
                    pushFollow(FOLLOW_comparisonOp_in_conditionExpr1172);
                    c=comparisonOp();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_comparisonOp.add(c.getTree());
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1174);
                    labelExpr63=labelExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_labelExpr.add(labelExpr63.getTree());

                    // AST REWRITE
                    // elements: labelExpr, comparisonOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 279:4: -> ^( COMPARE comparisonOp ( labelExpr )+ )
                    {
                        // AmoebaQuery.g:279:7: ^( COMPARE comparisonOp ( labelExpr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(COMPARE, "COMPARE"), root_1);

                        adaptor.addChild(root_1, stream_comparisonOp.next());
                        if ( !(stream_labelExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_labelExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_labelExpr.next());

                        }
                        stream_labelExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:280:4: labelExpr In subQuery
                    {
                    pushFollow(FOLLOW_labelExpr_in_conditionExpr1194);
                    labelExpr64=labelExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_labelExpr.add(labelExpr64.getTree());
                    In65=(Token)input.LT(1);
                    match(input,In,FOLLOW_In_in_conditionExpr1196); if (failed) return retval;
                    if ( backtracking==0 ) stream_In.add(In65);

                    pushFollow(FOLLOW_subQuery_in_conditionExpr1198);
                    subQuery66=subQuery();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_subQuery.add(subQuery66.getTree());

                    // AST REWRITE
                    // elements: subQuery, labelExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 281:4: -> ^( CONTAINED_IN labelExpr subQuery )
                    {
                        // AmoebaQuery.g:281:7: ^( CONTAINED_IN labelExpr subQuery )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CONTAINED_IN, "CONTAINED_IN"), root_1);

                        adaptor.addChild(root_1, stream_labelExpr.next());
                        adaptor.addChild(root_1, stream_subQuery.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end conditionExpr

    public static class comparisonOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start comparisonOp
    // AmoebaQuery.g:284:1: comparisonOp : ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' ) ;
    public final comparisonOp_return comparisonOp() throws RecognitionException {
        comparisonOp_return retval = new comparisonOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set67=null;

        Object set67_tree=null;

        try {
            // AmoebaQuery.g:284:13: ( ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' ) )
            // AmoebaQuery.g:284:15: ( EQUAL | LEQ | GEQ | LESS | GREATER | NOT_EQUAL | 'like' )
            {
            root_0 = (Object)adaptor.nil();

            set67=(Token)input.LT(1);
            if ( (input.LA(1)>=EQUAL && input.LA(1)<=GEQ)||input.LA(1)==66 ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set67));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_comparisonOp1220);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end comparisonOp

    public static class labelExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start labelExpr
    // AmoebaQuery.g:286:1: labelExpr : ( function | attributeName | value -> ^( VALUE value ) );
    public final labelExpr_return labelExpr() throws RecognitionException {
        labelExpr_return retval = new labelExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        function_return function68 = null;

        attributeName_return attributeName69 = null;

        value_return value70 = null;


        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // AmoebaQuery.g:287:2: ( function | attributeName | value -> ^( VALUE value ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==QName) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EOF||LA23_1==Dot||(LA23_1>=Comma && LA23_1<=RParen)||(LA23_1>=EQUAL && LA23_1<=GEQ)||(LA23_1>=From && LA23_1<=In)||(LA23_1>=64 && LA23_1<=66)) ) {
                    alt23=2;
                }
                else if ( (LA23_1==LParen) ) {
                    alt23=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("286:1: labelExpr : ( function | attributeName | value -> ^( VALUE value ) );", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==EOF||LA23_0==Dot||(LA23_0>=Comma && LA23_0<=RParen)||(LA23_0>=EQUAL && LA23_0<=GEQ)||(LA23_0>=From && LA23_0<=In)||LA23_0==Digits||LA23_0==StringLiteral||(LA23_0>=64 && LA23_0<=66)) ) {
                alt23=3;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("286:1: labelExpr : ( function | attributeName | value -> ^( VALUE value ) );", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // AmoebaQuery.g:287:4: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_labelExpr1256);
                    function68=function();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, function68.getTree());

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:288:4: attributeName
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attributeName_in_labelExpr1262);
                    attributeName69=attributeName();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, attributeName69.getTree());

                    }
                    break;
                case 3 :
                    // AmoebaQuery.g:289:4: value
                    {
                    pushFollow(FOLLOW_value_in_labelExpr1268);
                    value70=value();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_value.add(value70.getTree());

                    // AST REWRITE
                    // elements: value
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 289:10: -> ^( VALUE value )
                    {
                        // AmoebaQuery.g:289:13: ^( VALUE value )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE, "VALUE"), root_1);

                        adaptor.addChild(root_1, stream_value.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end labelExpr

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start value
    // AmoebaQuery.g:292:1: value : literal ;
    public final value_return value() throws RecognitionException {
        value_return retval = new value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        literal_return literal71 = null;



        try {
            // AmoebaQuery.g:293:2: ( literal )
            // AmoebaQuery.g:293:4: literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_literal_in_value1289);
            literal71=literal();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, literal71.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end value

    public static class attributeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attributeName
    // AmoebaQuery.g:296:1: attributeName : ( QName -> ^( ATTRIBUTE QName ) | relation= QName Dot attribute= QName -> ^( REF $relation $attribute) );
    public final attributeName_return attributeName() throws RecognitionException {
        attributeName_return retval = new attributeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token relation=null;
        Token attribute=null;
        Token QName72=null;
        Token Dot73=null;

        Object relation_tree=null;
        Object attribute_tree=null;
        Object QName72_tree=null;
        Object Dot73_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");

        try {
            // AmoebaQuery.g:297:2: ( QName -> ^( ATTRIBUTE QName ) | relation= QName Dot attribute= QName -> ^( REF $relation $attribute) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==QName) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==Dot) ) {
                    alt24=2;
                }
                else if ( (LA24_1==EOF||(LA24_1>=Comma && LA24_1<=RParen)||(LA24_1>=EQUAL && LA24_1<=GEQ)||(LA24_1>=From && LA24_1<=In)||(LA24_1>=64 && LA24_1<=66)) ) {
                    alt24=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("296:1: attributeName : ( QName -> ^( ATTRIBUTE QName ) | relation= QName Dot attribute= QName -> ^( REF $relation $attribute) );", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("296:1: attributeName : ( QName -> ^( ATTRIBUTE QName ) | relation= QName Dot attribute= QName -> ^( REF $relation $attribute) );", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // AmoebaQuery.g:297:4: QName
                    {
                    QName72=(Token)input.LT(1);
                    match(input,QName,FOLLOW_QName_in_attributeName1300); if (failed) return retval;
                    if ( backtracking==0 ) stream_QName.add(QName72);


                    // AST REWRITE
                    // elements: QName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 297:10: -> ^( ATTRIBUTE QName )
                    {
                        // AmoebaQuery.g:297:13: ^( ATTRIBUTE QName )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                        adaptor.addChild(root_1, stream_QName.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // AmoebaQuery.g:298:4: relation= QName Dot attribute= QName
                    {
                    relation=(Token)input.LT(1);
                    match(input,QName,FOLLOW_QName_in_attributeName1315); if (failed) return retval;
                    if ( backtracking==0 ) stream_QName.add(relation);

                    Dot73=(Token)input.LT(1);
                    match(input,Dot,FOLLOW_Dot_in_attributeName1317); if (failed) return retval;
                    if ( backtracking==0 ) stream_Dot.add(Dot73);

                    attribute=(Token)input.LT(1);
                    match(input,QName,FOLLOW_QName_in_attributeName1321); if (failed) return retval;
                    if ( backtracking==0 ) stream_QName.add(attribute);


                    // AST REWRITE
                    // elements: relation, attribute
                    // token labels: relation, attribute
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_relation=new RewriteRuleTokenStream(adaptor,"token relation",relation);
                    RewriteRuleTokenStream stream_attribute=new RewriteRuleTokenStream(adaptor,"token attribute",attribute);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 298:39: -> ^( REF $relation $attribute)
                    {
                        // AmoebaQuery.g:298:42: ^( REF $relation $attribute)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(REF, "REF"), root_1);

                        adaptor.addChild(root_1, stream_relation.next());
                        adaptor.addChild(root_1, stream_attribute.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end attributeName

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start function
    // AmoebaQuery.g:302:1: function : QName LParen labelExpr ( Comma labelExpr )* RParen -> ^( FUNCTION QName ( labelExpr )+ ) ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName74=null;
        Token LParen75=null;
        Token Comma77=null;
        Token RParen79=null;
        labelExpr_return labelExpr76 = null;

        labelExpr_return labelExpr78 = null;


        Object QName74_tree=null;
        Object LParen75_tree=null;
        Object Comma77_tree=null;
        Object RParen79_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_QName=new RewriteRuleTokenStream(adaptor,"token QName");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_labelExpr=new RewriteRuleSubtreeStream(adaptor,"rule labelExpr");
        try {
            // AmoebaQuery.g:303:2: ( QName LParen labelExpr ( Comma labelExpr )* RParen -> ^( FUNCTION QName ( labelExpr )+ ) )
            // AmoebaQuery.g:303:4: QName LParen labelExpr ( Comma labelExpr )* RParen
            {
            QName74=(Token)input.LT(1);
            match(input,QName,FOLLOW_QName_in_function1347); if (failed) return retval;
            if ( backtracking==0 ) stream_QName.add(QName74);

            LParen75=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_function1349); if (failed) return retval;
            if ( backtracking==0 ) stream_LParen.add(LParen75);

            pushFollow(FOLLOW_labelExpr_in_function1351);
            labelExpr76=labelExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_labelExpr.add(labelExpr76.getTree());
            // AmoebaQuery.g:303:27: ( Comma labelExpr )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Comma) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // AmoebaQuery.g:303:28: Comma labelExpr
            	    {
            	    Comma77=(Token)input.LT(1);
            	    match(input,Comma,FOLLOW_Comma_in_function1354); if (failed) return retval;
            	    if ( backtracking==0 ) stream_Comma.add(Comma77);

            	    pushFollow(FOLLOW_labelExpr_in_function1356);
            	    labelExpr78=labelExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_labelExpr.add(labelExpr78.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            RParen79=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_function1360); if (failed) return retval;
            if ( backtracking==0 ) stream_RParen.add(RParen79);


            // AST REWRITE
            // elements: labelExpr, QName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 304:2: -> ^( FUNCTION QName ( labelExpr )+ )
            {
                // AmoebaQuery.g:304:5: ^( FUNCTION QName ( labelExpr )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_QName.next());
                if ( !(stream_labelExpr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_labelExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_labelExpr.next());

                }
                stream_labelExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end function

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // AmoebaQuery.g:278:4: ( labelExpr comparisonOp labelExpr )
        // AmoebaQuery.g:278:4: labelExpr comparisonOp labelExpr
        {
        pushFollow(FOLLOW_labelExpr_in_synpred11168);
        labelExpr();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_comparisonOp_in_synpred11172);
        comparisonOp();
        _fsp--;
        if (failed) return ;
        pushFollow(FOLLOW_labelExpr_in_synpred11174);
        labelExpr();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_Digits_in_integerLiteral558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral564 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral569 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral571 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerLiteral_in_numericLiteral617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimalLiteral_in_numericLiteral623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectExpr_in_amoebaQuery638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateExpr_in_amoebaQuery643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Insert_in_updateExpr655 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_newRelation_in_updateExpr657 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Into_in_updateExpr660 = new BitSet(new long[]{0x0400000400000000L});
    public static final BitSet FOLLOW_targetRelation_in_updateExpr662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_updateExpr692 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_updateExpr694 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_newRelation_in_updateExpr696 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_whereClause_in_updateExpr698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_newRelation734 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_tupleElement_in_newRelation736 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_Comma_in_newRelation739 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_tupleElement_in_newRelation741 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_RParen_in_newRelation745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_tupleElement765 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_EQUAL_in_tupleElement773 = new BitSet(new long[]{0x2120000040000002L});
    public static final BitSet FOLLOW_elementValue_in_tupleElement777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_elementValue803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_elementValue819 = new BitSet(new long[]{0x6120000140000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValue821 = new BitSet(new long[]{0x4000000100000000L});
    public static final BitSet FOLLOW_Comma_in_elementValue824 = new BitSet(new long[]{0x6120000040000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValue826 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_elementValue830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectExpr_in_exprSingle855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subQuery_in_exprSingle860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_subQuery872 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_selectExpr_in_subQuery874 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RParen_in_subQuery876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Select_in_selectExpr897 = new BitSet(new long[]{0x0520C04140000002L});
    public static final BitSet FOLLOW_selectTarget_in_selectExpr899 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_fromClause_in_selectExpr901 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_whereClause_in_selectExpr904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_selectTarget941 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_Comma_in_selectTarget944 = new BitSet(new long[]{0x0520000140000002L});
    public static final BitSet FOLLOW_labelExpr_in_selectTarget946 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_Wildcard_in_selectTarget962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_From_in_fromClause977 = new BitSet(new long[]{0x0400000400000000L});
    public static final BitSet FOLLOW_fromTarget_in_fromClause979 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_Comma_in_fromClause982 = new BitSet(new long[]{0x0400000400000000L});
    public static final BitSet FOLLOW_fromTarget_in_fromClause984 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_targetRelation_in_fromTarget1003 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_fromTarget1011 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_fromTarget1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_targetRelation1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subQuery_in_targetRelation1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Where_in_whereClause1063 = new BitSet(new long[]{0x05201F8040000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_orExpr_in_whereClause1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1080 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_orExpr1088 = new BitSet(new long[]{0x05201F8040000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1092 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_conditionExpr_in_andExpr1120 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_andExpr1128 = new BitSet(new long[]{0x05201F8040000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_conditionExpr_in_andExpr1132 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1168 = new BitSet(new long[]{0x00001F8000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_comparisonOp_in_conditionExpr1172 = new BitSet(new long[]{0x0520000040000002L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_conditionExpr1194 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_In_in_conditionExpr1196 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_subQuery_in_conditionExpr1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparisonOp1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_labelExpr1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_labelExpr1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_labelExpr1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_value1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeName1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_attributeName1315 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Dot_in_attributeName1317 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_QName_in_attributeName1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_function1347 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_LParen_in_function1349 = new BitSet(new long[]{0x0520000340000000L});
    public static final BitSet FOLLOW_labelExpr_in_function1351 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_Comma_in_function1354 = new BitSet(new long[]{0x0520000340000000L});
    public static final BitSet FOLLOW_labelExpr_in_function1356 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_RParen_in_function1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelExpr_in_synpred11168 = new BitSet(new long[]{0x00001F8000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_comparisonOp_in_synpred11172 = new BitSet(new long[]{0x0520000040000002L});
    public static final BitSet FOLLOW_labelExpr_in_synpred11174 = new BitSet(new long[]{0x0000000000000002L});

}
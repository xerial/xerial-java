// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g 2010-01-21 13:02:47

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
// XPathParser.g
// Since: Aug 6, 2009 08:30:02 AM
//
//--------------------------------------
package org.xerial.lens.relation.query.impl;




import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class XPathParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "XPATH", "NAME", "VALUE", "STEP", "AXIS", "PREDICATE", "LineBreakChar", "LineComment", "LineBreak", "Digit", "Letter", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "StringChar_s", "String", "Integer", "Frac", "Exp", "Double", "Comma", "Colon", "UnsafeUnicodeChar", "SafeFirstLetter", "SafeLetter", "WhiteSpace", "QNameChar", "QName", "WhiteSpaces", "'/'", "'//'", "'@'", "'['", "']'", "'='", "'!='", "'>'", "'>='", "'<'", "'<='", "'~='", "'('", "')'"
    };
    public static final int Frac=22;
    public static final int STEP=7;
    public static final int LineComment=11;
    public static final int AXIS=8;
    public static final int EOF=-1;
    public static final int HexDigit=15;
    public static final int PREDICATE=9;
    public static final int LineBreak=12;
    public static final int NAME=5;
    public static final int WhiteSpace=30;
    public static final int String=20;
    public static final int T__42=42;
    public static final int Double=24;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int QName=32;
    public static final int T__44=44;
    public static final int QNameChar=31;
    public static final int T__45=45;
    public static final int WhiteSpaces=33;
    public static final int StringChar_s=19;
    public static final int Exp=23;
    public static final int Colon=26;
    public static final int UnicodeChar=16;
    public static final int VALUE=6;
    public static final int Digit=13;
    public static final int UnsafeUnicodeChar=27;
    public static final int XPATH=4;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int LineBreakChar=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int StringChar=18;
    public static final int SafeLetter=29;
    public static final int SafeFirstLetter=28;
    public static final int Comma=25;
    public static final int Letter=14;
    public static final int EscapeSequence=17;
    public static final int Integer=21;

    // delegates
    // delegators


        public XPathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XPathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return XPathParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g"; }





    public static class xpath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xpath"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:162:1: xpath : locationExpr -> ^( XPATH locationExpr ) ;
    public final XPathParser.xpath_return xpath() throws RecognitionException {
        XPathParser.xpath_return retval = new XPathParser.xpath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.locationExpr_return locationExpr1 = null;


        RewriteRuleSubtreeStream stream_locationExpr=new RewriteRuleSubtreeStream(adaptor,"rule locationExpr");
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:163:3: ( locationExpr -> ^( XPATH locationExpr ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:163:5: locationExpr
            {
            pushFollow(FOLLOW_locationExpr_in_xpath620);
            locationExpr1=locationExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_locationExpr.add(locationExpr1.getTree());


            // AST REWRITE
            // elements: locationExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 164:3: -> ^( XPATH locationExpr )
            {
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:164:6: ^( XPATH locationExpr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XPATH, "XPATH"), root_1);

                adaptor.addChild(root_1, stream_locationExpr.nextTree());

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
    // $ANTLR end "xpath"

    public static class locationExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locationExpr"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:167:1: fragment locationExpr : relativePath ;
    public final XPathParser.locationExpr_return locationExpr() throws RecognitionException {
        XPathParser.locationExpr_return retval = new XPathParser.locationExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.relativePath_return relativePath2 = null;



        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:169:3: ( relativePath )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:169:5: relativePath
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relativePath_in_locationExpr646);
            relativePath2=relativePath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relativePath2.getTree());

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
    // $ANTLR end "locationExpr"

    public static class relativePath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relativePath"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:172:1: fragment relativePath : ( step ( relativePath )? -> ^( STEP step ( relativePath )? ) | '/' step ( relativePath )? -> ^( STEP AXIS[\"PC\"] step ( relativePath )? ) | '//' step ( relativePath )? -> ^( STEP AXIS[\"AD\"] step ( relativePath )? ) );
    public final XPathParser.relativePath_return relativePath() throws RecognitionException {
        XPathParser.relativePath_return retval = new XPathParser.relativePath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal5=null;
        Token string_literal8=null;
        XPathParser.step_return step3 = null;

        XPathParser.relativePath_return relativePath4 = null;

        XPathParser.step_return step6 = null;

        XPathParser.relativePath_return relativePath7 = null;

        XPathParser.step_return step9 = null;

        XPathParser.relativePath_return relativePath10 = null;


        Object char_literal5_tree=null;
        Object string_literal8_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_relativePath=new RewriteRuleSubtreeStream(adaptor,"rule relativePath");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:174:3: ( step ( relativePath )? -> ^( STEP step ( relativePath )? ) | '/' step ( relativePath )? -> ^( STEP AXIS[\"PC\"] step ( relativePath )? ) | '//' step ( relativePath )? -> ^( STEP AXIS[\"AD\"] step ( relativePath )? ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case QName:
            case 36:
                {
                alt4=1;
                }
                break;
            case 34:
                {
                alt4=2;
                }
                break;
            case 35:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:174:5: step ( relativePath )?
                    {
                    pushFollow(FOLLOW_step_in_relativePath663);
                    step3=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step3.getTree());
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:174:10: ( relativePath )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==QName||(LA1_0>=34 && LA1_0<=36)) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:174:10: relativePath
                            {
                            pushFollow(FOLLOW_relativePath_in_relativePath665);
                            relativePath4=relativePath();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_relativePath.add(relativePath4.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: relativePath, step
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 175:4: -> ^( STEP step ( relativePath )? )
                    {
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:175:7: ^( STEP step ( relativePath )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, stream_step.nextTree());
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:175:19: ( relativePath )?
                        if ( stream_relativePath.hasNext() ) {
                            adaptor.addChild(root_1, stream_relativePath.nextTree());

                        }
                        stream_relativePath.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:176:5: '/' step ( relativePath )?
                    {
                    char_literal5=(Token)match(input,34,FOLLOW_34_in_relativePath686); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal5);

                    pushFollow(FOLLOW_step_in_relativePath688);
                    step6=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step6.getTree());
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:176:14: ( relativePath )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==QName||(LA2_0>=34 && LA2_0<=36)) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:176:14: relativePath
                            {
                            pushFollow(FOLLOW_relativePath_in_relativePath690);
                            relativePath7=relativePath();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_relativePath.add(relativePath7.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: relativePath, step
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 177:4: -> ^( STEP AXIS[\"PC\"] step ( relativePath )? )
                    {
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:177:7: ^( STEP AXIS[\"PC\"] step ( relativePath )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(AXIS, "PC"));
                        adaptor.addChild(root_1, stream_step.nextTree());
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:177:30: ( relativePath )?
                        if ( stream_relativePath.hasNext() ) {
                            adaptor.addChild(root_1, stream_relativePath.nextTree());

                        }
                        stream_relativePath.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:178:5: '//' step ( relativePath )?
                    {
                    string_literal8=(Token)match(input,35,FOLLOW_35_in_relativePath714); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_35.add(string_literal8);

                    pushFollow(FOLLOW_step_in_relativePath716);
                    step9=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step9.getTree());
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:178:15: ( relativePath )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==QName||(LA3_0>=34 && LA3_0<=36)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:178:15: relativePath
                            {
                            pushFollow(FOLLOW_relativePath_in_relativePath718);
                            relativePath10=relativePath();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_relativePath.add(relativePath10.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: step, relativePath
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 179:4: -> ^( STEP AXIS[\"AD\"] step ( relativePath )? )
                    {
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:179:7: ^( STEP AXIS[\"AD\"] step ( relativePath )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(AXIS, "AD"));
                        adaptor.addChild(root_1, stream_step.nextTree());
                        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:179:30: ( relativePath )?
                        if ( stream_relativePath.hasNext() ) {
                            adaptor.addChild(root_1, stream_relativePath.nextTree());

                        }
                        stream_relativePath.reset();

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
    // $ANTLR end "relativePath"

    public static class step_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "step"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:183:1: fragment step : nodeTest ( predicate )* -> NAME[$nodeTest.text] ( predicate )* ;
    public final XPathParser.step_return step() throws RecognitionException {
        XPathParser.step_return retval = new XPathParser.step_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.nodeTest_return nodeTest11 = null;

        XPathParser.predicate_return predicate12 = null;


        RewriteRuleSubtreeStream stream_nodeTest=new RewriteRuleSubtreeStream(adaptor,"rule nodeTest");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:185:3: ( nodeTest ( predicate )* -> NAME[$nodeTest.text] ( predicate )* )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:185:5: nodeTest ( predicate )*
            {
            pushFollow(FOLLOW_nodeTest_in_step755);
            nodeTest11=nodeTest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeTest.add(nodeTest11.getTree());
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:185:14: ( predicate )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==37) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:185:14: predicate
            	    {
            	    pushFollow(FOLLOW_predicate_in_step757);
            	    predicate12=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_predicate.add(predicate12.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: predicate
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 185:25: -> NAME[$nodeTest.text] ( predicate )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(NAME, (nodeTest11!=null?input.toString(nodeTest11.start,nodeTest11.stop):null)));
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:185:49: ( predicate )*
                while ( stream_predicate.hasNext() ) {
                    adaptor.addChild(root_0, stream_predicate.nextTree());

                }
                stream_predicate.reset();

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
    // $ANTLR end "step"

    public static class nodeTest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeTest"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:189:1: fragment nodeTest : ( '@' )? ( QName ':' )? QName ;
    public final XPathParser.nodeTest_return nodeTest() throws RecognitionException {
        XPathParser.nodeTest_return retval = new XPathParser.nodeTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        Token QName14=null;
        Token char_literal15=null;
        Token QName16=null;

        Object char_literal13_tree=null;
        Object QName14_tree=null;
        Object char_literal15_tree=null;
        Object QName16_tree=null;

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:3: ( ( '@' )? ( QName ':' )? QName )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:5: ( '@' )? ( QName ':' )? QName
            {
            root_0 = (Object)adaptor.nil();

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:5: ( '@' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:5: '@'
                    {
                    char_literal13=(Token)match(input,36,FOLLOW_36_in_nodeTest785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal13_tree = (Object)adaptor.create(char_literal13);
                    adaptor.addChild(root_0, char_literal13_tree);
                    }

                    }
                    break;

            }

            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:10: ( QName ':' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QName) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==Colon) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:191:11: QName ':'
                    {
                    QName14=(Token)match(input,QName,FOLLOW_QName_in_nodeTest789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QName14_tree = (Object)adaptor.create(QName14);
                    adaptor.addChild(root_0, QName14_tree);
                    }
                    char_literal15=(Token)match(input,Colon,FOLLOW_Colon_in_nodeTest791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }

                    }
                    break;

            }

            QName16=(Token)match(input,QName,FOLLOW_QName_in_nodeTest795); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QName16_tree = (Object)adaptor.create(QName16);
            adaptor.addChild(root_0, QName16_tree);
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
    // $ANTLR end "nodeTest"

    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:194:1: fragment predicate : '[' expr ']' -> ^( PREDICATE expr ) ;
    public final XPathParser.predicate_return predicate() throws RecognitionException {
        XPathParser.predicate_return retval = new XPathParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal17=null;
        Token char_literal19=null;
        XPathParser.expr_return expr18 = null;


        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:196:3: ( '[' expr ']' -> ^( PREDICATE expr ) )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:196:5: '[' expr ']'
            {
            char_literal17=(Token)match(input,37,FOLLOW_37_in_predicate813); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(char_literal17);

            pushFollow(FOLLOW_expr_in_predicate815);
            expr18=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr18.getTree());
            char_literal19=(Token)match(input,38,FOLLOW_38_in_predicate817); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal19);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 197:3: -> ^( PREDICATE expr )
            {
                // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:197:6: ^( PREDICATE expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PREDICATE, "PREDICATE"), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

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
    // $ANTLR end "predicate"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:200:1: expr : comparisonExpr ;
    public final XPathParser.expr_return expr() throws RecognitionException {
        XPathParser.expr_return retval = new XPathParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.comparisonExpr_return comparisonExpr20 = null;



        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:201:3: ( comparisonExpr )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:201:5: comparisonExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_comparisonExpr_in_expr840);
            comparisonExpr20=comparisonExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, comparisonExpr20.getTree());

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

    public static class comparisonExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparisonExpr"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:204:1: fragment comparisonExpr : ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr );
    public final XPathParser.comparisonExpr_return comparisonExpr() throws RecognitionException {
        XPathParser.comparisonExpr_return retval = new XPathParser.comparisonExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token string_literal26=null;
        Token char_literal29=null;
        Token string_literal32=null;
        Token char_literal35=null;
        Token string_literal38=null;
        Token string_literal41=null;
        XPathParser.pathExpr_return pathExpr21 = null;

        XPathParser.pathExpr_return pathExpr22 = null;

        XPathParser.pathExpr_return pathExpr24 = null;

        XPathParser.pathExpr_return pathExpr25 = null;

        XPathParser.pathExpr_return pathExpr27 = null;

        XPathParser.pathExpr_return pathExpr28 = null;

        XPathParser.pathExpr_return pathExpr30 = null;

        XPathParser.pathExpr_return pathExpr31 = null;

        XPathParser.pathExpr_return pathExpr33 = null;

        XPathParser.pathExpr_return pathExpr34 = null;

        XPathParser.pathExpr_return pathExpr36 = null;

        XPathParser.pathExpr_return pathExpr37 = null;

        XPathParser.pathExpr_return pathExpr39 = null;

        XPathParser.pathExpr_return pathExpr40 = null;

        XPathParser.pathExpr_return pathExpr42 = null;


        Object char_literal23_tree=null;
        Object string_literal26_tree=null;
        Object char_literal29_tree=null;
        Object string_literal32_tree=null;
        Object char_literal35_tree=null;
        Object string_literal38_tree=null;
        Object string_literal41_tree=null;

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:206:3: ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr )
            int alt8=8;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:206:5: pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr855);
                    pathExpr21=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr21.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:207:5: ( pathExpr '=' )=> pathExpr '=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr869);
                    pathExpr22=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr22.getTree());
                    char_literal23=(Token)match(input,39,FOLLOW_39_in_comparisonExpr871); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (Object)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr873);
                    pathExpr24=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr24.getTree());

                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:208:5: ( pathExpr '!=' )=> pathExpr '!=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr887);
                    pathExpr25=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr25.getTree());
                    string_literal26=(Token)match(input,40,FOLLOW_40_in_comparisonExpr889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal26_tree = (Object)adaptor.create(string_literal26);
                    adaptor.addChild(root_0, string_literal26_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr891);
                    pathExpr27=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr27.getTree());

                    }
                    break;
                case 4 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:209:5: ( pathExpr '>' )=> pathExpr '>' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr905);
                    pathExpr28=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr28.getTree());
                    char_literal29=(Token)match(input,41,FOLLOW_41_in_comparisonExpr907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr909);
                    pathExpr30=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr30.getTree());

                    }
                    break;
                case 5 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:210:5: ( pathExpr '>=' )=> pathExpr '>=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr923);
                    pathExpr31=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr31.getTree());
                    string_literal32=(Token)match(input,42,FOLLOW_42_in_comparisonExpr925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal32_tree = (Object)adaptor.create(string_literal32);
                    adaptor.addChild(root_0, string_literal32_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr927);
                    pathExpr33=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr33.getTree());

                    }
                    break;
                case 6 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:211:5: ( pathExpr '<' )=> pathExpr '<' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr941);
                    pathExpr34=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr34.getTree());
                    char_literal35=(Token)match(input,43,FOLLOW_43_in_comparisonExpr943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr945);
                    pathExpr36=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr36.getTree());

                    }
                    break;
                case 7 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:212:5: ( pathExpr '<=' )=> pathExpr '<=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr959);
                    pathExpr37=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr37.getTree());
                    string_literal38=(Token)match(input,44,FOLLOW_44_in_comparisonExpr961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal38_tree = (Object)adaptor.create(string_literal38);
                    adaptor.addChild(root_0, string_literal38_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr963);
                    pathExpr39=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr39.getTree());

                    }
                    break;
                case 8 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:213:5: ( pathExpr '~=' )=> pathExpr '~=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr977);
                    pathExpr40=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr40.getTree());
                    string_literal41=(Token)match(input,45,FOLLOW_45_in_comparisonExpr979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal41_tree = (Object)adaptor.create(string_literal41);
                    adaptor.addChild(root_0, string_literal41_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr981);
                    pathExpr42=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr42.getTree());

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
    // $ANTLR end "comparisonExpr"

    public static class pathExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pathExpr"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:217:1: fragment pathExpr : ( locationExpr | primaryExpr );
    public final XPathParser.pathExpr_return pathExpr() throws RecognitionException {
        XPathParser.pathExpr_return retval = new XPathParser.pathExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.locationExpr_return locationExpr43 = null;

        XPathParser.primaryExpr_return primaryExpr44 = null;



        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:219:3: ( locationExpr | primaryExpr )
            int alt9=2;
            switch ( input.LA(1) ) {
            case 34:
            case 35:
            case 36:
                {
                alt9=1;
                }
                break;
            case QName:
                {
                int LA9_2 = input.LA(2);

                if ( ((LA9_2>=Comma && LA9_2<=Colon)||LA9_2==QName||(LA9_2>=34 && LA9_2<=45)||LA9_2==47) ) {
                    alt9=1;
                }
                else if ( (LA9_2==46) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case String:
            case Integer:
            case Double:
                {
                alt9=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:219:5: locationExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locationExpr_in_pathExpr997);
                    locationExpr43=locationExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, locationExpr43.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:220:5: primaryExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpr_in_pathExpr1003);
                    primaryExpr44=primaryExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primaryExpr44.getTree());

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
    // $ANTLR end "pathExpr"

    public static class primaryExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpr"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:223:1: fragment primaryExpr : ( String | Integer | Double | functionCall );
    public final XPathParser.primaryExpr_return primaryExpr() throws RecognitionException {
        XPathParser.primaryExpr_return retval = new XPathParser.primaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String45=null;
        Token Integer46=null;
        Token Double47=null;
        XPathParser.functionCall_return functionCall48 = null;


        Object String45_tree=null;
        Object Integer46_tree=null;
        Object Double47_tree=null;

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:225:3: ( String | Integer | Double | functionCall )
            int alt10=4;
            switch ( input.LA(1) ) {
            case String:
                {
                alt10=1;
                }
                break;
            case Integer:
                {
                alt10=2;
                }
                break;
            case Double:
                {
                alt10=3;
                }
                break;
            case QName:
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
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:225:5: String
                    {
                    root_0 = (Object)adaptor.nil();

                    String45=(Token)match(input,String,FOLLOW_String_in_primaryExpr1022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    String45_tree = (Object)adaptor.create(String45);
                    adaptor.addChild(root_0, String45_tree);
                    }

                    }
                    break;
                case 2 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:226:5: Integer
                    {
                    root_0 = (Object)adaptor.nil();

                    Integer46=(Token)match(input,Integer,FOLLOW_Integer_in_primaryExpr1028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Integer46_tree = (Object)adaptor.create(Integer46);
                    adaptor.addChild(root_0, Integer46_tree);
                    }

                    }
                    break;
                case 3 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:227:5: Double
                    {
                    root_0 = (Object)adaptor.nil();

                    Double47=(Token)match(input,Double,FOLLOW_Double_in_primaryExpr1034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Double47_tree = (Object)adaptor.create(Double47);
                    adaptor.addChild(root_0, Double47_tree);
                    }

                    }
                    break;
                case 4 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:228:5: functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_primaryExpr1040);
                    functionCall48=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall48.getTree());

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
    // $ANTLR end "primaryExpr"

    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:232:1: fragment functionCall : QName '(' ( expr ( ',' expr )* )? ')' ;
    public final XPathParser.functionCall_return functionCall() throws RecognitionException {
        XPathParser.functionCall_return retval = new XPathParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName49=null;
        Token char_literal50=null;
        Token char_literal52=null;
        Token char_literal54=null;
        XPathParser.expr_return expr51 = null;

        XPathParser.expr_return expr53 = null;


        Object QName49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal52_tree=null;
        Object char_literal54_tree=null;

        try {
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:3: ( QName '(' ( expr ( ',' expr )* )? ')' )
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:5: QName '(' ( expr ( ',' expr )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            QName49=(Token)match(input,QName,FOLLOW_QName_in_functionCall1060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QName49_tree = (Object)adaptor.create(QName49);
            adaptor.addChild(root_0, QName49_tree);
            }
            char_literal50=(Token)match(input,46,FOLLOW_46_in_functionCall1062); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = (Object)adaptor.create(char_literal50);
            adaptor.addChild(root_0, char_literal50_tree);
            }
            // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:15: ( expr ( ',' expr )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=String && LA12_0<=Integer)||LA12_0==Double||LA12_0==QName||(LA12_0>=34 && LA12_0<=36)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:16: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_functionCall1065);
                    expr51=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr51.getTree());
                    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:21: ( ',' expr )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==Comma) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:234:22: ',' expr
                    	    {
                    	    char_literal52=(Token)match(input,Comma,FOLLOW_Comma_in_functionCall1068); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    	    adaptor.addChild(root_0, char_literal52_tree);
                    	    }
                    	    pushFollow(FOLLOW_expr_in_functionCall1070);
                    	    expr53=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal54=(Token)match(input,47,FOLLOW_47_in_functionCall1076); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
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
    // $ANTLR end "functionCall"

    // $ANTLR start synpred1_XPath
    public final void synpred1_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:207:5: ( pathExpr '=' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:207:6: pathExpr '='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred1_XPath862);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred1_XPath864); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_XPath

    // $ANTLR start synpred2_XPath
    public final void synpred2_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:208:5: ( pathExpr '!=' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:208:6: pathExpr '!='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred2_XPath880);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,40,FOLLOW_40_in_synpred2_XPath882); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_XPath

    // $ANTLR start synpred3_XPath
    public final void synpred3_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:209:5: ( pathExpr '>' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:209:6: pathExpr '>'
        {
        pushFollow(FOLLOW_pathExpr_in_synpred3_XPath898);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred3_XPath900); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_XPath

    // $ANTLR start synpred4_XPath
    public final void synpred4_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:210:5: ( pathExpr '>=' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:210:6: pathExpr '>='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred4_XPath916);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,42,FOLLOW_42_in_synpred4_XPath918); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_XPath

    // $ANTLR start synpred5_XPath
    public final void synpred5_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:211:5: ( pathExpr '<' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:211:6: pathExpr '<'
        {
        pushFollow(FOLLOW_pathExpr_in_synpred5_XPath934);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred5_XPath936); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_XPath

    // $ANTLR start synpred6_XPath
    public final void synpred6_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:212:5: ( pathExpr '<=' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:212:6: pathExpr '<='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred6_XPath952);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred6_XPath954); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_XPath

    // $ANTLR start synpred7_XPath
    public final void synpred7_XPath_fragment() throws RecognitionException {   
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:213:5: ( pathExpr '~=' )
        // D:\\work\\hg\\xerial-core\\src\\main\\java\\org\\xerial\\lens\\relation\\query\\impl\\XPath.g:213:6: pathExpr '~='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred7_XPath970);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,45,FOLLOW_45_in_synpred7_XPath972); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_XPath

    // Delegated rules

    public final boolean synpred3_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\20\uffff";
    static final String DFA8_eofS =
        "\20\uffff";
    static final String DFA8_minS =
        "\1\24\7\0\10\uffff";
    static final String DFA8_maxS =
        "\1\44\7\0\10\uffff";
    static final String DFA8_acceptS =
        "\10\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA8_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\10\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\5\1\6\2\uffff\1\7\7\uffff\1\2\1\uffff\1\3\1\4\1\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "204:1: fragment comparisonExpr : ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 8;}

                        else if ( (synpred1_XPath()) ) {s = 9;}

                        else if ( (synpred2_XPath()) ) {s = 10;}

                        else if ( (synpred3_XPath()) ) {s = 11;}

                        else if ( (synpred4_XPath()) ) {s = 12;}

                        else if ( (synpred5_XPath()) ) {s = 13;}

                        else if ( (synpred6_XPath()) ) {s = 14;}

                        else if ( (synpred7_XPath()) ) {s = 15;}

                         
                        input.seek(index8_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_locationExpr_in_xpath620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relativePath_in_locationExpr646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativePath663 = new BitSet(new long[]{0x0000001D00000002L});
    public static final BitSet FOLLOW_relativePath_in_relativePath665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_relativePath686 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_step_in_relativePath688 = new BitSet(new long[]{0x0000001D00000002L});
    public static final BitSet FOLLOW_relativePath_in_relativePath690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_relativePath714 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_step_in_relativePath716 = new BitSet(new long[]{0x0000001D00000002L});
    public static final BitSet FOLLOW_relativePath_in_relativePath718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeTest_in_step755 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_predicate_in_step757 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_36_in_nodeTest785 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_QName_in_nodeTest789 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Colon_in_nodeTest791 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_QName_in_nodeTest795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_predicate813 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_expr_in_predicate815 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_predicate817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparisonExpr_in_expr840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr869 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_comparisonExpr871 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr887 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_comparisonExpr889 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr905 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_comparisonExpr907 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr923 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_comparisonExpr925 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr941 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_comparisonExpr943 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr959 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_comparisonExpr961 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr977 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_comparisonExpr979 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locationExpr_in_pathExpr997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpr_in_pathExpr1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primaryExpr1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_primaryExpr1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_primaryExpr1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpr1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_functionCall1060 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_functionCall1062 = new BitSet(new long[]{0x0000801D01300000L});
    public static final BitSet FOLLOW_expr_in_functionCall1065 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_Comma_in_functionCall1068 = new BitSet(new long[]{0x0000001D01300000L});
    public static final BitSet FOLLOW_expr_in_functionCall1070 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_47_in_functionCall1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred1_XPath862 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred1_XPath864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred2_XPath880 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred2_XPath882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred3_XPath898 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred3_XPath900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred4_XPath916 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred4_XPath918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred5_XPath934 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred5_XPath936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred6_XPath952 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred6_XPath954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred7_XPath970 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_synpred7_XPath972 = new BitSet(new long[]{0x0000000000000002L});

}
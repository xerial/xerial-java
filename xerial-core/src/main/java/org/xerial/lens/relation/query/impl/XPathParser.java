// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 XPath.g 2009-09-29 14:52:03

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
    public static final int T__42=42;
    public static final int Digit=13;
    public static final int Frac=22;
    public static final int HexDigit=15;
    public static final int T__47=47;
    public static final int STEP=7;
    public static final int VALUE=6;
    public static final int T__39=39;
    public static final int PREDICATE=9;
    public static final int Letter=14;
    public static final int T__46=46;
    public static final int Comma=25;
    public static final int EscapeSequence=17;
    public static final int XPATH=4;
    public static final int Integer=21;
    public static final int WhiteSpace=30;
    public static final int T__34=34;
    public static final int AXIS=8;
    public static final int LineComment=11;
    public static final int Colon=26;
    public static final int T__35=35;
    public static final int SafeFirstLetter=28;
    public static final int T__36=36;
    public static final int Exp=23;
    public static final int QNameChar=31;
    public static final int T__44=44;
    public static final int UnicodeChar=16;
    public static final int StringChar=18;
    public static final int LineBreak=12;
    public static final int T__45=45;
    public static final int String=20;
    public static final int SafeLetter=29;
    public static final int LineBreakChar=10;
    public static final int T__43=43;
    public static final int QName=32;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int StringChar_s=19;
    public static final int UnsafeUnicodeChar=27;
    public static final int Double=24;
    public static final int NAME=5;
    public static final int T__41=41;
    public static final int WhiteSpaces=33;

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
    public String getGrammarFileName() { return "XPath.g"; }





    public static class xpath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xpath"
    // XPath.g:162:1: xpath : locationExpr -> ^( XPATH locationExpr ) ;
    public final XPathParser.xpath_return xpath() throws RecognitionException {
        XPathParser.xpath_return retval = new XPathParser.xpath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.locationExpr_return locationExpr1 = null;


        RewriteRuleSubtreeStream stream_locationExpr=new RewriteRuleSubtreeStream(adaptor,"rule locationExpr");
        try {
            // XPath.g:163:3: ( locationExpr -> ^( XPATH locationExpr ) )
            // XPath.g:163:5: locationExpr
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
                // XPath.g:164:6: ^( XPATH locationExpr )
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
    // XPath.g:167:1: fragment locationExpr : ( relativePath | absolutePath );
    public final XPathParser.locationExpr_return locationExpr() throws RecognitionException {
        XPathParser.locationExpr_return retval = new XPathParser.locationExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.relativePath_return relativePath2 = null;

        XPathParser.absolutePath_return absolutePath3 = null;



        try {
            // XPath.g:169:3: ( relativePath | absolutePath )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==QName||LA1_0==36) ) {
                alt1=1;
            }
            else if ( (LA1_0==34) ) {
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
                    // XPath.g:169:5: relativePath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relativePath_in_locationExpr646);
                    relativePath2=relativePath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, relativePath2.getTree());

                    }
                    break;
                case 2 :
                    // XPath.g:170:5: absolutePath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_absolutePath_in_locationExpr652);
                    absolutePath3=absolutePath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, absolutePath3.getTree());

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
    // $ANTLR end "locationExpr"

    public static class relativePath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relativePath"
    // XPath.g:173:1: fragment relativePath : ( step -> ^( STEP step ) | ( step '/' )=> step '/' relativePath -> ^( STEP AXIS[\"PC\"] step relativePath ) | ( step '//' )=> step '//' relativePath -> ^( STEP AXIS[\"AD\"] step relativePath ) );
    public final XPathParser.relativePath_return relativePath() throws RecognitionException {
        XPathParser.relativePath_return retval = new XPathParser.relativePath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal6=null;
        Token string_literal9=null;
        XPathParser.step_return step4 = null;

        XPathParser.step_return step5 = null;

        XPathParser.relativePath_return relativePath7 = null;

        XPathParser.step_return step8 = null;

        XPathParser.relativePath_return relativePath10 = null;


        Object char_literal6_tree=null;
        Object string_literal9_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_relativePath=new RewriteRuleSubtreeStream(adaptor,"rule relativePath");
        RewriteRuleSubtreeStream stream_step=new RewriteRuleSubtreeStream(adaptor,"rule step");
        try {
            // XPath.g:175:3: ( step -> ^( STEP step ) | ( step '/' )=> step '/' relativePath -> ^( STEP AXIS[\"PC\"] step relativePath ) | ( step '//' )=> step '//' relativePath -> ^( STEP AXIS[\"AD\"] step relativePath ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==36) ) {
                int LA2_1 = input.LA(2);

                if ( (true) ) {
                    alt2=1;
                }
                else if ( (synpred1_XPath()) ) {
                    alt2=2;
                }
                else if ( (synpred2_XPath()) ) {
                    alt2=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==QName) ) {
                int LA2_2 = input.LA(2);

                if ( (true) ) {
                    alt2=1;
                }
                else if ( (synpred1_XPath()) ) {
                    alt2=2;
                }
                else if ( (synpred2_XPath()) ) {
                    alt2=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // XPath.g:175:5: step
                    {
                    pushFollow(FOLLOW_step_in_relativePath669);
                    step4=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step4.getTree());


                    // AST REWRITE
                    // elements: step
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 176:3: -> ^( STEP step )
                    {
                        // XPath.g:176:6: ^( STEP step )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, stream_step.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // XPath.g:177:5: ( step '/' )=> step '/' relativePath
                    {
                    pushFollow(FOLLOW_step_in_relativePath694);
                    step5=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step5.getTree());
                    char_literal6=(Token)match(input,34,FOLLOW_34_in_relativePath696); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_34.add(char_literal6);

                    pushFollow(FOLLOW_relativePath_in_relativePath698);
                    relativePath7=relativePath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_relativePath.add(relativePath7.getTree());


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
                    // 178:3: -> ^( STEP AXIS[\"PC\"] step relativePath )
                    {
                        // XPath.g:178:6: ^( STEP AXIS[\"PC\"] step relativePath )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(AXIS, "PC"));
                        adaptor.addChild(root_1, stream_step.nextTree());
                        adaptor.addChild(root_1, stream_relativePath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // XPath.g:179:5: ( step '//' )=> step '//' relativePath
                    {
                    pushFollow(FOLLOW_step_in_relativePath729);
                    step8=step();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_step.add(step8.getTree());
                    string_literal9=(Token)match(input,35,FOLLOW_35_in_relativePath731); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_35.add(string_literal9);

                    pushFollow(FOLLOW_relativePath_in_relativePath733);
                    relativePath10=relativePath();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_relativePath.add(relativePath10.getTree());


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
                    // 180:3: -> ^( STEP AXIS[\"AD\"] step relativePath )
                    {
                        // XPath.g:180:6: ^( STEP AXIS[\"AD\"] step relativePath )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(AXIS, "AD"));
                        adaptor.addChild(root_1, stream_step.nextTree());
                        adaptor.addChild(root_1, stream_relativePath.nextTree());

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

    public static class absolutePath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "absolutePath"
    // XPath.g:183:1: fragment absolutePath : '/' relativePath -> ^( STEP AXIS[\"PC\"] NAME[\"_root\"] relativePath ) ;
    public final XPathParser.absolutePath_return absolutePath() throws RecognitionException {
        XPathParser.absolutePath_return retval = new XPathParser.absolutePath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal11=null;
        XPathParser.relativePath_return relativePath12 = null;


        Object char_literal11_tree=null;
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_relativePath=new RewriteRuleSubtreeStream(adaptor,"rule relativePath");
        try {
            // XPath.g:185:3: ( '/' relativePath -> ^( STEP AXIS[\"PC\"] NAME[\"_root\"] relativePath ) )
            // XPath.g:185:5: '/' relativePath
            {
            char_literal11=(Token)match(input,34,FOLLOW_34_in_absolutePath764); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_34.add(char_literal11);

            pushFollow(FOLLOW_relativePath_in_absolutePath766);
            relativePath12=relativePath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_relativePath.add(relativePath12.getTree());


            // AST REWRITE
            // elements: relativePath
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 186:3: -> ^( STEP AXIS[\"PC\"] NAME[\"_root\"] relativePath )
            {
                // XPath.g:186:6: ^( STEP AXIS[\"PC\"] NAME[\"_root\"] relativePath )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STEP, "STEP"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(AXIS, "PC"));
                adaptor.addChild(root_1, (Object)adaptor.create(NAME, "_root"));
                adaptor.addChild(root_1, stream_relativePath.nextTree());

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
    // $ANTLR end "absolutePath"

    public static class step_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "step"
    // XPath.g:189:1: fragment step : nodeTest ( predicate )* -> NAME[$nodeTest.text] ( predicate )* ;
    public final XPathParser.step_return step() throws RecognitionException {
        XPathParser.step_return retval = new XPathParser.step_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.nodeTest_return nodeTest13 = null;

        XPathParser.predicate_return predicate14 = null;


        RewriteRuleSubtreeStream stream_nodeTest=new RewriteRuleSubtreeStream(adaptor,"rule nodeTest");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        try {
            // XPath.g:191:3: ( nodeTest ( predicate )* -> NAME[$nodeTest.text] ( predicate )* )
            // XPath.g:191:5: nodeTest ( predicate )*
            {
            pushFollow(FOLLOW_nodeTest_in_step800);
            nodeTest13=nodeTest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nodeTest.add(nodeTest13.getTree());
            // XPath.g:191:14: ( predicate )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==37) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // XPath.g:191:14: predicate
            	    {
            	    pushFollow(FOLLOW_predicate_in_step802);
            	    predicate14=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_predicate.add(predicate14.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
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
            // 191:25: -> NAME[$nodeTest.text] ( predicate )*
            {
                adaptor.addChild(root_0, (Object)adaptor.create(NAME, (nodeTest13!=null?input.toString(nodeTest13.start,nodeTest13.stop):null)));
                // XPath.g:191:49: ( predicate )*
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
    // XPath.g:195:1: fragment nodeTest : ( '@' )? ( QName ':' )? QName ;
    public final XPathParser.nodeTest_return nodeTest() throws RecognitionException {
        XPathParser.nodeTest_return retval = new XPathParser.nodeTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal15=null;
        Token QName16=null;
        Token char_literal17=null;
        Token QName18=null;

        Object char_literal15_tree=null;
        Object QName16_tree=null;
        Object char_literal17_tree=null;
        Object QName18_tree=null;

        try {
            // XPath.g:197:3: ( ( '@' )? ( QName ':' )? QName )
            // XPath.g:197:5: ( '@' )? ( QName ':' )? QName
            {
            root_0 = (Object)adaptor.nil();

            // XPath.g:197:5: ( '@' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==36) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // XPath.g:197:5: '@'
                    {
                    char_literal15=(Token)match(input,36,FOLLOW_36_in_nodeTest830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }

                    }
                    break;

            }

            // XPath.g:197:10: ( QName ':' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==QName) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==Colon) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // XPath.g:197:11: QName ':'
                    {
                    QName16=(Token)match(input,QName,FOLLOW_QName_in_nodeTest834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QName16_tree = (Object)adaptor.create(QName16);
                    adaptor.addChild(root_0, QName16_tree);
                    }
                    char_literal17=(Token)match(input,Colon,FOLLOW_Colon_in_nodeTest836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal17_tree = (Object)adaptor.create(char_literal17);
                    adaptor.addChild(root_0, char_literal17_tree);
                    }

                    }
                    break;

            }

            QName18=(Token)match(input,QName,FOLLOW_QName_in_nodeTest840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QName18_tree = (Object)adaptor.create(QName18);
            adaptor.addChild(root_0, QName18_tree);
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
    // XPath.g:200:1: fragment predicate : '[' expr ']' -> ^( PREDICATE expr ) ;
    public final XPathParser.predicate_return predicate() throws RecognitionException {
        XPathParser.predicate_return retval = new XPathParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        XPathParser.expr_return expr20 = null;


        Object char_literal19_tree=null;
        Object char_literal21_tree=null;
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // XPath.g:202:3: ( '[' expr ']' -> ^( PREDICATE expr ) )
            // XPath.g:202:5: '[' expr ']'
            {
            char_literal19=(Token)match(input,37,FOLLOW_37_in_predicate858); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(char_literal19);

            pushFollow(FOLLOW_expr_in_predicate860);
            expr20=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr20.getTree());
            char_literal21=(Token)match(input,38,FOLLOW_38_in_predicate862); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal21);



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
            // 203:3: -> ^( PREDICATE expr )
            {
                // XPath.g:203:6: ^( PREDICATE expr )
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
    // XPath.g:206:1: expr : comparisonExpr ;
    public final XPathParser.expr_return expr() throws RecognitionException {
        XPathParser.expr_return retval = new XPathParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.comparisonExpr_return comparisonExpr22 = null;



        try {
            // XPath.g:207:3: ( comparisonExpr )
            // XPath.g:207:5: comparisonExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_comparisonExpr_in_expr885);
            comparisonExpr22=comparisonExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, comparisonExpr22.getTree());

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
    // XPath.g:210:1: fragment comparisonExpr : ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr );
    public final XPathParser.comparisonExpr_return comparisonExpr() throws RecognitionException {
        XPathParser.comparisonExpr_return retval = new XPathParser.comparisonExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal25=null;
        Token string_literal28=null;
        Token char_literal31=null;
        Token string_literal34=null;
        Token char_literal37=null;
        Token string_literal40=null;
        Token string_literal43=null;
        XPathParser.pathExpr_return pathExpr23 = null;

        XPathParser.pathExpr_return pathExpr24 = null;

        XPathParser.pathExpr_return pathExpr26 = null;

        XPathParser.pathExpr_return pathExpr27 = null;

        XPathParser.pathExpr_return pathExpr29 = null;

        XPathParser.pathExpr_return pathExpr30 = null;

        XPathParser.pathExpr_return pathExpr32 = null;

        XPathParser.pathExpr_return pathExpr33 = null;

        XPathParser.pathExpr_return pathExpr35 = null;

        XPathParser.pathExpr_return pathExpr36 = null;

        XPathParser.pathExpr_return pathExpr38 = null;

        XPathParser.pathExpr_return pathExpr39 = null;

        XPathParser.pathExpr_return pathExpr41 = null;

        XPathParser.pathExpr_return pathExpr42 = null;

        XPathParser.pathExpr_return pathExpr44 = null;


        Object char_literal25_tree=null;
        Object string_literal28_tree=null;
        Object char_literal31_tree=null;
        Object string_literal34_tree=null;
        Object char_literal37_tree=null;
        Object string_literal40_tree=null;
        Object string_literal43_tree=null;

        try {
            // XPath.g:212:3: ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr )
            int alt6=8;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // XPath.g:212:5: pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr900);
                    pathExpr23=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr23.getTree());

                    }
                    break;
                case 2 :
                    // XPath.g:213:5: ( pathExpr '=' )=> pathExpr '=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr914);
                    pathExpr24=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr24.getTree());
                    char_literal25=(Token)match(input,39,FOLLOW_39_in_comparisonExpr916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (Object)adaptor.create(char_literal25);
                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr918);
                    pathExpr26=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr26.getTree());

                    }
                    break;
                case 3 :
                    // XPath.g:214:5: ( pathExpr '!=' )=> pathExpr '!=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr932);
                    pathExpr27=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr27.getTree());
                    string_literal28=(Token)match(input,40,FOLLOW_40_in_comparisonExpr934); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal28_tree = (Object)adaptor.create(string_literal28);
                    adaptor.addChild(root_0, string_literal28_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr936);
                    pathExpr29=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr29.getTree());

                    }
                    break;
                case 4 :
                    // XPath.g:215:5: ( pathExpr '>' )=> pathExpr '>' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr950);
                    pathExpr30=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr30.getTree());
                    char_literal31=(Token)match(input,41,FOLLOW_41_in_comparisonExpr952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr954);
                    pathExpr32=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr32.getTree());

                    }
                    break;
                case 5 :
                    // XPath.g:216:5: ( pathExpr '>=' )=> pathExpr '>=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr968);
                    pathExpr33=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr33.getTree());
                    string_literal34=(Token)match(input,42,FOLLOW_42_in_comparisonExpr970); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    adaptor.addChild(root_0, string_literal34_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr972);
                    pathExpr35=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr35.getTree());

                    }
                    break;
                case 6 :
                    // XPath.g:217:5: ( pathExpr '<' )=> pathExpr '<' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr986);
                    pathExpr36=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr36.getTree());
                    char_literal37=(Token)match(input,43,FOLLOW_43_in_comparisonExpr988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr990);
                    pathExpr38=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr38.getTree());

                    }
                    break;
                case 7 :
                    // XPath.g:218:5: ( pathExpr '<=' )=> pathExpr '<=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr1004);
                    pathExpr39=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr39.getTree());
                    string_literal40=(Token)match(input,44,FOLLOW_44_in_comparisonExpr1006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal40_tree = (Object)adaptor.create(string_literal40);
                    adaptor.addChild(root_0, string_literal40_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr1008);
                    pathExpr41=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr41.getTree());

                    }
                    break;
                case 8 :
                    // XPath.g:219:5: ( pathExpr '~=' )=> pathExpr '~=' pathExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr1022);
                    pathExpr42=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr42.getTree());
                    string_literal43=(Token)match(input,45,FOLLOW_45_in_comparisonExpr1024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal43_tree = (Object)adaptor.create(string_literal43);
                    adaptor.addChild(root_0, string_literal43_tree);
                    }
                    pushFollow(FOLLOW_pathExpr_in_comparisonExpr1026);
                    pathExpr44=pathExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pathExpr44.getTree());

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
    // XPath.g:223:1: fragment pathExpr : ( locationExpr | primaryExpr );
    public final XPathParser.pathExpr_return pathExpr() throws RecognitionException {
        XPathParser.pathExpr_return retval = new XPathParser.pathExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XPathParser.locationExpr_return locationExpr45 = null;

        XPathParser.primaryExpr_return primaryExpr46 = null;



        try {
            // XPath.g:225:3: ( locationExpr | primaryExpr )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 34:
            case 36:
                {
                alt7=1;
                }
                break;
            case QName:
                {
                int LA7_2 = input.LA(2);

                if ( ((LA7_2>=Comma && LA7_2<=Colon)||(LA7_2>=34 && LA7_2<=35)||(LA7_2>=37 && LA7_2<=45)||LA7_2==47) ) {
                    alt7=1;
                }
                else if ( (LA7_2==46) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case String:
            case Integer:
            case Double:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // XPath.g:225:5: locationExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locationExpr_in_pathExpr1042);
                    locationExpr45=locationExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, locationExpr45.getTree());

                    }
                    break;
                case 2 :
                    // XPath.g:226:5: primaryExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpr_in_pathExpr1048);
                    primaryExpr46=primaryExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primaryExpr46.getTree());

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
    // XPath.g:229:1: fragment primaryExpr : ( String | Integer | Double | functionCall );
    public final XPathParser.primaryExpr_return primaryExpr() throws RecognitionException {
        XPathParser.primaryExpr_return retval = new XPathParser.primaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String47=null;
        Token Integer48=null;
        Token Double49=null;
        XPathParser.functionCall_return functionCall50 = null;


        Object String47_tree=null;
        Object Integer48_tree=null;
        Object Double49_tree=null;

        try {
            // XPath.g:231:3: ( String | Integer | Double | functionCall )
            int alt8=4;
            switch ( input.LA(1) ) {
            case String:
                {
                alt8=1;
                }
                break;
            case Integer:
                {
                alt8=2;
                }
                break;
            case Double:
                {
                alt8=3;
                }
                break;
            case QName:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // XPath.g:231:5: String
                    {
                    root_0 = (Object)adaptor.nil();

                    String47=(Token)match(input,String,FOLLOW_String_in_primaryExpr1067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    String47_tree = (Object)adaptor.create(String47);
                    adaptor.addChild(root_0, String47_tree);
                    }

                    }
                    break;
                case 2 :
                    // XPath.g:232:5: Integer
                    {
                    root_0 = (Object)adaptor.nil();

                    Integer48=(Token)match(input,Integer,FOLLOW_Integer_in_primaryExpr1073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Integer48_tree = (Object)adaptor.create(Integer48);
                    adaptor.addChild(root_0, Integer48_tree);
                    }

                    }
                    break;
                case 3 :
                    // XPath.g:233:5: Double
                    {
                    root_0 = (Object)adaptor.nil();

                    Double49=(Token)match(input,Double,FOLLOW_Double_in_primaryExpr1079); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Double49_tree = (Object)adaptor.create(Double49);
                    adaptor.addChild(root_0, Double49_tree);
                    }

                    }
                    break;
                case 4 :
                    // XPath.g:234:5: functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_primaryExpr1085);
                    functionCall50=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall50.getTree());

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
    // XPath.g:238:1: fragment functionCall : QName '(' ( expr ( ',' expr )* )? ')' ;
    public final XPathParser.functionCall_return functionCall() throws RecognitionException {
        XPathParser.functionCall_return retval = new XPathParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QName51=null;
        Token char_literal52=null;
        Token char_literal54=null;
        Token char_literal56=null;
        XPathParser.expr_return expr53 = null;

        XPathParser.expr_return expr55 = null;


        Object QName51_tree=null;
        Object char_literal52_tree=null;
        Object char_literal54_tree=null;
        Object char_literal56_tree=null;

        try {
            // XPath.g:240:3: ( QName '(' ( expr ( ',' expr )* )? ')' )
            // XPath.g:240:5: QName '(' ( expr ( ',' expr )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            QName51=(Token)match(input,QName,FOLLOW_QName_in_functionCall1105); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QName51_tree = (Object)adaptor.create(QName51);
            adaptor.addChild(root_0, QName51_tree);
            }
            char_literal52=(Token)match(input,46,FOLLOW_46_in_functionCall1107); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (Object)adaptor.create(char_literal52);
            adaptor.addChild(root_0, char_literal52_tree);
            }
            // XPath.g:240:15: ( expr ( ',' expr )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=String && LA10_0<=Integer)||LA10_0==Double||LA10_0==QName||LA10_0==34||LA10_0==36) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // XPath.g:240:16: expr ( ',' expr )*
                    {
                    pushFollow(FOLLOW_expr_in_functionCall1110);
                    expr53=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr53.getTree());
                    // XPath.g:240:21: ( ',' expr )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Comma) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // XPath.g:240:22: ',' expr
                    	    {
                    	    char_literal54=(Token)match(input,Comma,FOLLOW_Comma_in_functionCall1113); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    	    adaptor.addChild(root_0, char_literal54_tree);
                    	    }
                    	    pushFollow(FOLLOW_expr_in_functionCall1115);
                    	    expr55=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr55.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal56=(Token)match(input,47,FOLLOW_47_in_functionCall1121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
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
        // XPath.g:177:5: ( step '/' )
        // XPath.g:177:6: step '/'
        {
        pushFollow(FOLLOW_step_in_synpred1_XPath687);
        step();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred1_XPath689); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_XPath

    // $ANTLR start synpred2_XPath
    public final void synpred2_XPath_fragment() throws RecognitionException {   
        // XPath.g:179:5: ( step '//' )
        // XPath.g:179:6: step '//'
        {
        pushFollow(FOLLOW_step_in_synpred2_XPath722);
        step();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred2_XPath724); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_XPath

    // $ANTLR start synpred3_XPath
    public final void synpred3_XPath_fragment() throws RecognitionException {   
        // XPath.g:213:5: ( pathExpr '=' )
        // XPath.g:213:6: pathExpr '='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred3_XPath907);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred3_XPath909); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_XPath

    // $ANTLR start synpred4_XPath
    public final void synpred4_XPath_fragment() throws RecognitionException {   
        // XPath.g:214:5: ( pathExpr '!=' )
        // XPath.g:214:6: pathExpr '!='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred4_XPath925);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,40,FOLLOW_40_in_synpred4_XPath927); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_XPath

    // $ANTLR start synpred5_XPath
    public final void synpred5_XPath_fragment() throws RecognitionException {   
        // XPath.g:215:5: ( pathExpr '>' )
        // XPath.g:215:6: pathExpr '>'
        {
        pushFollow(FOLLOW_pathExpr_in_synpred5_XPath943);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred5_XPath945); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_XPath

    // $ANTLR start synpred6_XPath
    public final void synpred6_XPath_fragment() throws RecognitionException {   
        // XPath.g:216:5: ( pathExpr '>=' )
        // XPath.g:216:6: pathExpr '>='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred6_XPath961);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,42,FOLLOW_42_in_synpred6_XPath963); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_XPath

    // $ANTLR start synpred7_XPath
    public final void synpred7_XPath_fragment() throws RecognitionException {   
        // XPath.g:217:5: ( pathExpr '<' )
        // XPath.g:217:6: pathExpr '<'
        {
        pushFollow(FOLLOW_pathExpr_in_synpred7_XPath979);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred7_XPath981); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_XPath

    // $ANTLR start synpred8_XPath
    public final void synpred8_XPath_fragment() throws RecognitionException {   
        // XPath.g:218:5: ( pathExpr '<=' )
        // XPath.g:218:6: pathExpr '<='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred8_XPath997);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred8_XPath999); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_XPath

    // $ANTLR start synpred9_XPath
    public final void synpred9_XPath_fragment() throws RecognitionException {   
        // XPath.g:219:5: ( pathExpr '~=' )
        // XPath.g:219:6: pathExpr '~='
        {
        pushFollow(FOLLOW_pathExpr_in_synpred9_XPath1015);
        pathExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,45,FOLLOW_45_in_synpred9_XPath1017); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_XPath

    // Delegated rules

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
    public final boolean synpred8_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_XPath_fragment(); // can never throw exception
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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\17\uffff";
    static final String DFA6_eofS =
        "\17\uffff";
    static final String DFA6_minS =
        "\1\24\6\0\10\uffff";
    static final String DFA6_maxS =
        "\1\44\6\0\10\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\4\1\5\2\uffff\1\6\7\uffff\1\2\1\uffff\1\3\1\uffff\1\1",
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
            return "210:1: fragment comparisonExpr : ( pathExpr | ( pathExpr '=' )=> pathExpr '=' pathExpr | ( pathExpr '!=' )=> pathExpr '!=' pathExpr | ( pathExpr '>' )=> pathExpr '>' pathExpr | ( pathExpr '>=' )=> pathExpr '>=' pathExpr | ( pathExpr '<' )=> pathExpr '<' pathExpr | ( pathExpr '<=' )=> pathExpr '<=' pathExpr | ( pathExpr '~=' )=> pathExpr '~=' pathExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_1 = input.LA(1);

                         
                        int index6_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_2 = input.LA(1);

                         
                        int index6_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 7;}

                        else if ( (synpred3_XPath()) ) {s = 8;}

                        else if ( (synpred4_XPath()) ) {s = 9;}

                        else if ( (synpred5_XPath()) ) {s = 10;}

                        else if ( (synpred6_XPath()) ) {s = 11;}

                        else if ( (synpred7_XPath()) ) {s = 12;}

                        else if ( (synpred8_XPath()) ) {s = 13;}

                        else if ( (synpred9_XPath()) ) {s = 14;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_locationExpr_in_xpath620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relativePath_in_locationExpr646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_absolutePath_in_locationExpr652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativePath669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativePath694 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_relativePath696 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_relativePath_in_relativePath698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_relativePath729 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_relativePath731 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_relativePath_in_relativePath733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_absolutePath764 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_relativePath_in_absolutePath766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeTest_in_step800 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_predicate_in_step802 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_36_in_nodeTest830 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_QName_in_nodeTest834 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Colon_in_nodeTest836 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_QName_in_nodeTest840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_predicate858 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_expr_in_predicate860 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_predicate862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparisonExpr_in_expr885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr914 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_comparisonExpr916 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr932 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_comparisonExpr934 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr950 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_comparisonExpr952 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr968 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_comparisonExpr970 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr986 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_comparisonExpr988 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr1004 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_comparisonExpr1006 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr1022 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_comparisonExpr1024 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_pathExpr_in_comparisonExpr1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locationExpr_in_pathExpr1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpr_in_pathExpr1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primaryExpr1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_primaryExpr1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_primaryExpr1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpr1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QName_in_functionCall1105 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_functionCall1107 = new BitSet(new long[]{0x0000801501300000L});
    public static final BitSet FOLLOW_expr_in_functionCall1110 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_Comma_in_functionCall1113 = new BitSet(new long[]{0x0000001501300000L});
    public static final BitSet FOLLOW_expr_in_functionCall1115 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_47_in_functionCall1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_synpred1_XPath687 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred1_XPath689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_synpred2_XPath722 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred2_XPath724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred3_XPath907 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred3_XPath909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred4_XPath925 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred4_XPath927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred5_XPath943 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred5_XPath945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred6_XPath961 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred6_XPath963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred7_XPath979 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred7_XPath981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred8_XPath997 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred8_XPath999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_synpred9_XPath1015 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_synpred9_XPath1017 = new BitSet(new long[]{0x0000000000000002L});

}
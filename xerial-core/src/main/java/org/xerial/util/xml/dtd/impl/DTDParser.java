// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g 2009-07-03 13:39:51

//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDParser.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------
package org.xerial.util.xml.dtd.impl;
//import org.xerial.util.log.Logger;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class DTDParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "ML_COMMENT", "At", "Colon", "Comma", "Apos", "Quot", "Dot", "SemiColon", "LParen", "RParen", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "Name", "Reference", "AttValue", "EntityRef", "CharRef", "DefaultDecl", "Element", "'>'", "'EMPTY'", "'ANY'", "'?'", "'*'", "'+'", "'|'", "'#PCDATA'", "'<!ATTLIST'", "'NOTATION'", "'CDATA'", "'ID'", "'IDREF'", "'IDREFS'", "'ENTITY'", "'ENTITIES'", "'NMTOKEN'", "'NMTOKENS'"
    };
    public static final int T__42=42;
    public static final int DefaultDecl=27;
    public static final int Apos=10;
    public static final int Digit=17;
    public static final int SemiColon=13;
    public static final int NUMBER=4;
    public static final int AttValue=24;
    public static final int T__39=39;
    public static final int Letter=16;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int Comma=9;
    public static final int Dot=12;
    public static final int ML_COMMENT=6;
    public static final int T__34=34;
    public static final int Colon=8;
    public static final int EntityRef=25;
    public static final int At=7;
    public static final int T__35=35;
    public static final int NameChar=19;
    public static final int T__36=36;
    public static final int STRING=5;
    public static final int T__44=44;
    public static final int RParen=15;
    public static final int StringLiteral=21;
    public static final int T__33=33;
    public static final int Name=22;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int LParen=14;
    public static final int CharRef=26;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int WhiteSpaceChar=20;
    public static final int Reference=23;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int Quot=11;
    public static final int Digits=18;
    public static final int Element=28;
    public static final int T__41=41;

    // delegates
    // delegators


        public DTDParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public DTDParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return DTDParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g"; }


    public static class integerLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integerLiteral"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:115:1: integerLiteral : Digits ;
    public final DTDParser.integerLiteral_return integerLiteral() throws RecognitionException {
        DTDParser.integerLiteral_return retval = new DTDParser.integerLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Digits1=null;

        Object Digits1_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:115:15: ( Digits )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:115:17: Digits
            {
            root_0 = (Object)adaptor.nil();

            Digits1=(Token)match(input,Digits,FOLLOW_Digits_in_integerLiteral487); if (state.failed) return retval;
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
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:116:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );
    public final DTDParser.decimalLiteral_return decimalLiteral() throws RecognitionException {
        DTDParser.decimalLiteral_return retval = new DTDParser.decimalLiteral_return();
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
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:116:15: ( Dot Digits | Digits Dot Digits )
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:116:17: Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Dot2=(Token)match(input,Dot,FOLLOW_Dot_in_decimalLiteral493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Dot2_tree = (Object)adaptor.create(Dot2);
                    adaptor.addChild(root_0, Dot2_tree);
                    }
                    Digits3=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Digits3_tree = (Object)adaptor.create(Digits3);
                    adaptor.addChild(root_0, Digits3_tree);
                    }

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:116:29: Digits Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Digits4=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Digits4_tree = (Object)adaptor.create(Digits4);
                    adaptor.addChild(root_0, Digits4_tree);
                    }
                    Dot5=(Token)match(input,Dot,FOLLOW_Dot_in_decimalLiteral500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Dot5_tree = (Object)adaptor.create(Dot5);
                    adaptor.addChild(root_0, Dot5_tree);
                    }
                    Digits6=(Token)match(input,Digits,FOLLOW_Digits_in_decimalLiteral502); if (state.failed) return retval;
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
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:118:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );
    public final DTDParser.literal_return literal() throws RecognitionException {
        DTDParser.literal_return retval = new DTDParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral8=null;
        DTDParser.numericLiteral_return numericLiteral7 = null;


        Object StringLiteral8_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleSubtreeStream stream_numericLiteral=new RewriteRuleSubtreeStream(adaptor,"rule numericLiteral");
        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:118:8: ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case EOF:
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
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:119:2: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:119:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal513);
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
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 119:19: -> ^( NUMBER numericLiteral )
                    {
                        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:119:22: ^( NUMBER numericLiteral )
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:120:4: StringLiteral
                    {
                    StringLiteral8=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal526); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral8);



                    // AST REWRITE
                    // elements: StringLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:18: -> ^( STRING StringLiteral )
                    {
                        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:120:21: ^( STRING StringLiteral )
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
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:123:1: numericLiteral : ( integerLiteral | decimalLiteral );
    public final DTDParser.numericLiteral_return numericLiteral() throws RecognitionException {
        DTDParser.numericLiteral_return retval = new DTDParser.numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.integerLiteral_return integerLiteral9 = null;

        DTDParser.decimalLiteral_return decimalLiteral10 = null;



        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:124:2: ( integerLiteral | decimalLiteral )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Digits) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==Dot) ) {
                    alt3=2;
                }
                else if ( (LA3_1==EOF) ) {
                    alt3=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==Dot) ) {
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:124:4: integerLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integerLiteral_in_numericLiteral546);
                    integerLiteral9=integerLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, integerLiteral9.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:125:4: decimalLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decimalLiteral_in_numericLiteral552);
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

    public static class dtd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dtd"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:129:1: dtd : ( markupdecl )* ;
    public final DTDParser.dtd_return dtd() throws RecognitionException {
        DTDParser.dtd_return retval = new DTDParser.dtd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.markupdecl_return markupdecl11 = null;



        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:129:4: ( ( markupdecl )* )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:129:6: ( markupdecl )*
            {
            root_0 = (Object)adaptor.nil();

            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:129:6: ( markupdecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Element||LA4_0==37) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:129:6: markupdecl
            	    {
            	    pushFollow(FOLLOW_markupdecl_in_dtd563);
            	    markupdecl11=markupdecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupdecl11.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "dtd"

    public static class markupdecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupdecl"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:131:1: markupdecl : ( elementDecl | attlistDecl );
    public final DTDParser.markupdecl_return markupdecl() throws RecognitionException {
        DTDParser.markupdecl_return retval = new DTDParser.markupdecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.elementDecl_return elementDecl12 = null;

        DTDParser.attlistDecl_return attlistDecl13 = null;



        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:131:11: ( elementDecl | attlistDecl )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Element) ) {
                alt5=1;
            }
            else if ( (LA5_0==37) ) {
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:131:13: elementDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementDecl_in_markupdecl571);
                    elementDecl12=elementDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementDecl12.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:131:27: attlistDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attlistDecl_in_markupdecl575);
                    attlistDecl13=attlistDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attlistDecl13.getTree());

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
    // $ANTLR end "markupdecl"

    public static class elementDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementDecl"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:134:1: elementDecl : Element Name contentSpec '>' ;
    public final DTDParser.elementDecl_return elementDecl() throws RecognitionException {
        DTDParser.elementDecl_return retval = new DTDParser.elementDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Element14=null;
        Token Name15=null;
        Token char_literal17=null;
        DTDParser.contentSpec_return contentSpec16 = null;


        Object Element14_tree=null;
        Object Name15_tree=null;
        Object char_literal17_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:134:12: ( Element Name contentSpec '>' )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:134:14: Element Name contentSpec '>'
            {
            root_0 = (Object)adaptor.nil();

            Element14=(Token)match(input,Element,FOLLOW_Element_in_elementDecl583); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Element14_tree = (Object)adaptor.create(Element14);
            adaptor.addChild(root_0, Element14_tree);
            }
            Name15=(Token)match(input,Name,FOLLOW_Name_in_elementDecl585); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name15_tree = (Object)adaptor.create(Name15);
            adaptor.addChild(root_0, Name15_tree);
            }
            pushFollow(FOLLOW_contentSpec_in_elementDecl587);
            contentSpec16=contentSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, contentSpec16.getTree());
            char_literal17=(Token)match(input,29,FOLLOW_29_in_elementDecl589); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
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
    // $ANTLR end "elementDecl"

    public static class contentSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contentSpec"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:1: contentSpec : ( 'EMPTY' | 'ANY' | mixed | children );
    public final DTDParser.contentSpec_return contentSpec() throws RecognitionException {
        DTDParser.contentSpec_return retval = new DTDParser.contentSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal18=null;
        Token string_literal19=null;
        DTDParser.mixed_return mixed20 = null;

        DTDParser.children_return children21 = null;


        Object string_literal18_tree=null;
        Object string_literal19_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:12: ( 'EMPTY' | 'ANY' | mixed | children )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt6=1;
                }
                break;
            case 31:
                {
                alt6=2;
                }
                break;
            case LParen:
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3==36) ) {
                    alt6=3;
                }
                else if ( (LA6_3==LParen||LA6_3==Name) ) {
                    alt6=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:14: 'EMPTY'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal18=(Token)match(input,30,FOLLOW_30_in_contentSpec599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal18_tree = (Object)adaptor.create(string_literal18);
                    adaptor.addChild(root_0, string_literal18_tree);
                    }

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:24: 'ANY'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal19=(Token)match(input,31,FOLLOW_31_in_contentSpec603); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal19_tree = (Object)adaptor.create(string_literal19);
                    adaptor.addChild(root_0, string_literal19_tree);
                    }

                    }
                    break;
                case 3 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:32: mixed
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mixed_in_contentSpec607);
                    mixed20=mixed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mixed20.getTree());

                    }
                    break;
                case 4 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:137:40: children
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_children_in_contentSpec611);
                    children21=children();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, children21.getTree());

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
    // $ANTLR end "contentSpec"

    public static class children_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "children"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:140:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );
    public final DTDParser.children_return children() throws RecognitionException {
        DTDParser.children_return retval = new DTDParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set23=null;
        Token set25=null;
        DTDParser.choice_return choice22 = null;

        DTDParser.seq_return seq24 = null;


        Object set23_tree=null;
        Object set25_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:141:1: ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LParen) ) {
                int LA9_1 = input.LA(2);

                if ( (synpred1_DTD()) ) {
                    alt9=1;
                }
                else if ( (synpred2_DTD()) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:141:3: ( choice )=> choice ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_choice_in_children630);
                    choice22=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, choice22.getTree());
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:141:23: ( '?' | '*' | '+' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=32 && LA7_0<=34)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
                            {
                            set23=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set23));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:142:3: ( seq )=> seq ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_seq_in_children654);
                    seq24=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, seq24.getTree());
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:142:16: ( '?' | '*' | '+' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=32 && LA8_0<=34)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
                            {
                            set25=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set25));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

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
    // $ANTLR end "children"

    public static class cp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cp"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:145:1: cp : ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );
    public final DTDParser.cp_return cp() throws RecognitionException {
        DTDParser.cp_return retval = new DTDParser.cp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name26=null;
        Token set27=null;
        Token set29=null;
        Token set31=null;
        DTDParser.choice_return choice28 = null;

        DTDParser.seq_return seq30 = null;


        Object Name26_tree=null;
        Object set27_tree=null;
        Object set29_tree=null;
        Object set31_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:146:1: ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Name) && (synpred3_DTD())) {
                alt13=1;
            }
            else if ( (LA13_0==LParen) ) {
                int LA13_2 = input.LA(2);

                if ( (synpred4_DTD()) ) {
                    alt13=2;
                }
                else if ( (synpred5_DTD()) ) {
                    alt13=3;
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
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:146:3: ( Name )=> Name ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    Name26=(Token)match(input,Name,FOLLOW_Name_in_cp684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Name26_tree = (Object)adaptor.create(Name26);
                    adaptor.addChild(root_0, Name26_tree);
                    }
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:146:19: ( '?' | '*' | '+' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=32 && LA10_0<=34)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
                            {
                            set27=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
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
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:147:4: ( choice )=> choice ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_choice_in_cp709);
                    choice28=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, choice28.getTree());
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:147:24: ( '?' | '*' | '+' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=32 && LA11_0<=34)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
                            {
                            set29=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set29));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:148:4: ( seq )=> seq ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_seq_in_cp734);
                    seq30=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, seq30.getTree());
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:148:18: ( '?' | '*' | '+' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=32 && LA12_0<=34)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
                            {
                            set31=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set31));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

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
    // $ANTLR end "cp"

    public static class choice_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "choice"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:151:1: choice : LParen cp ( '|' cp )* RParen ;
    public final DTDParser.choice_return choice() throws RecognitionException {
        DTDParser.choice_return retval = new DTDParser.choice_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen32=null;
        Token char_literal34=null;
        Token RParen36=null;
        DTDParser.cp_return cp33 = null;

        DTDParser.cp_return cp35 = null;


        Object LParen32_tree=null;
        Object char_literal34_tree=null;
        Object RParen36_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:151:7: ( LParen cp ( '|' cp )* RParen )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:151:9: LParen cp ( '|' cp )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen32=(Token)match(input,LParen,FOLLOW_LParen_in_choice756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen32_tree = (Object)adaptor.create(LParen32);
            adaptor.addChild(root_0, LParen32_tree);
            }
            pushFollow(FOLLOW_cp_in_choice758);
            cp33=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cp33.getTree());
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:151:19: ( '|' cp )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==35) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:151:20: '|' cp
            	    {
            	    char_literal34=(Token)match(input,35,FOLLOW_35_in_choice761); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal34_tree = (Object)adaptor.create(char_literal34);
            	    adaptor.addChild(root_0, char_literal34_tree);
            	    }
            	    pushFollow(FOLLOW_cp_in_choice763);
            	    cp35=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cp35.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RParen36=(Token)match(input,RParen,FOLLOW_RParen_in_choice767); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen36_tree = (Object)adaptor.create(RParen36);
            adaptor.addChild(root_0, RParen36_tree);
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
    // $ANTLR end "choice"

    public static class seq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "seq"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:154:1: seq : ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen ;
    public final DTDParser.seq_return seq() throws RecognitionException {
        DTDParser.seq_return retval = new DTDParser.seq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen37=null;
        Token Comma39=null;
        Token RParen41=null;
        DTDParser.cp_return cp38 = null;

        DTDParser.cp_return cp40 = null;


        Object LParen37_tree=null;
        Object Comma39_tree=null;
        Object RParen41_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:154:4: ( ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:154:6: ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen37=(Token)match(input,LParen,FOLLOW_LParen_in_seq787); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen37_tree = (Object)adaptor.create(LParen37);
            adaptor.addChild(root_0, LParen37_tree);
            }
            pushFollow(FOLLOW_cp_in_seq789);
            cp38=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cp38.getTree());
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:154:37: ( Comma cp )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Comma) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:154:38: Comma cp
            	    {
            	    Comma39=(Token)match(input,Comma,FOLLOW_Comma_in_seq792); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Comma39_tree = (Object)adaptor.create(Comma39);
            	    adaptor.addChild(root_0, Comma39_tree);
            	    }
            	    pushFollow(FOLLOW_cp_in_seq794);
            	    cp40=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cp40.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            RParen41=(Token)match(input,RParen,FOLLOW_RParen_in_seq798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen41_tree = (Object)adaptor.create(RParen41);
            adaptor.addChild(root_0, RParen41_tree);
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
    // $ANTLR end "seq"

    public static class mixed_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mixed"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:157:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );
    public final DTDParser.mixed_return mixed() throws RecognitionException {
        DTDParser.mixed_return retval = new DTDParser.mixed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen42=null;
        Token string_literal43=null;
        Token char_literal44=null;
        Token Name45=null;
        Token RParen46=null;
        Token char_literal47=null;
        Token LParen48=null;
        Token string_literal49=null;
        Token RParen50=null;

        Object LParen42_tree=null;
        Object string_literal43_tree=null;
        Object char_literal44_tree=null;
        Object Name45_tree=null;
        Object RParen46_tree=null;
        Object char_literal47_tree=null;
        Object LParen48_tree=null;
        Object string_literal49_tree=null;
        Object RParen50_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:157:6: ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LParen) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==36) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==RParen) ) {
                        int LA17_3 = input.LA(4);

                        if ( (LA17_3==33) ) {
                            alt17=1;
                        }
                        else if ( (LA17_3==29) ) {
                            alt17=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA17_2==35) ) {
                        alt17=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:157:8: LParen '#PCDATA' ( '|' Name )* RParen '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    LParen42=(Token)match(input,LParen,FOLLOW_LParen_in_mixed808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LParen42_tree = (Object)adaptor.create(LParen42);
                    adaptor.addChild(root_0, LParen42_tree);
                    }
                    string_literal43=(Token)match(input,36,FOLLOW_36_in_mixed810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal43_tree = (Object)adaptor.create(string_literal43);
                    adaptor.addChild(root_0, string_literal43_tree);
                    }
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:157:25: ( '|' Name )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==35) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:157:26: '|' Name
                    	    {
                    	    char_literal44=(Token)match(input,35,FOLLOW_35_in_mixed813); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    	    adaptor.addChild(root_0, char_literal44_tree);
                    	    }
                    	    Name45=(Token)match(input,Name,FOLLOW_Name_in_mixed815); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    Name45_tree = (Object)adaptor.create(Name45);
                    	    adaptor.addChild(root_0, Name45_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    RParen46=(Token)match(input,RParen,FOLLOW_RParen_in_mixed819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RParen46_tree = (Object)adaptor.create(RParen46);
                    adaptor.addChild(root_0, RParen46_tree);
                    }
                    char_literal47=(Token)match(input,33,FOLLOW_33_in_mixed821); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:158:5: LParen '#PCDATA' RParen
                    {
                    root_0 = (Object)adaptor.nil();

                    LParen48=(Token)match(input,LParen,FOLLOW_LParen_in_mixed828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LParen48_tree = (Object)adaptor.create(LParen48);
                    adaptor.addChild(root_0, LParen48_tree);
                    }
                    string_literal49=(Token)match(input,36,FOLLOW_36_in_mixed830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal49_tree = (Object)adaptor.create(string_literal49);
                    adaptor.addChild(root_0, string_literal49_tree);
                    }
                    RParen50=(Token)match(input,RParen,FOLLOW_RParen_in_mixed832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RParen50_tree = (Object)adaptor.create(RParen50);
                    adaptor.addChild(root_0, RParen50_tree);
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
    // $ANTLR end "mixed"

    public static class attlistDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attlistDecl"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:161:1: attlistDecl : '<!ATTLIST' Name ( attDef )* '>' ;
    public final DTDParser.attlistDecl_return attlistDecl() throws RecognitionException {
        DTDParser.attlistDecl_return retval = new DTDParser.attlistDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal51=null;
        Token Name52=null;
        Token char_literal54=null;
        DTDParser.attDef_return attDef53 = null;


        Object string_literal51_tree=null;
        Object Name52_tree=null;
        Object char_literal54_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:161:12: ( '<!ATTLIST' Name ( attDef )* '>' )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:161:14: '<!ATTLIST' Name ( attDef )* '>'
            {
            root_0 = (Object)adaptor.nil();

            string_literal51=(Token)match(input,37,FOLLOW_37_in_attlistDecl844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal51_tree = (Object)adaptor.create(string_literal51);
            adaptor.addChild(root_0, string_literal51_tree);
            }
            Name52=(Token)match(input,Name,FOLLOW_Name_in_attlistDecl846); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name52_tree = (Object)adaptor.create(Name52);
            adaptor.addChild(root_0, Name52_tree);
            }
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:161:31: ( attDef )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Name) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:161:31: attDef
            	    {
            	    pushFollow(FOLLOW_attDef_in_attlistDecl848);
            	    attDef53=attDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attDef53.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            char_literal54=(Token)match(input,29,FOLLOW_29_in_attlistDecl851); if (state.failed) return retval;
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
    // $ANTLR end "attlistDecl"

    public static class attDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attDef"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:164:1: attDef : Name attType DefaultDecl ;
    public final DTDParser.attDef_return attDef() throws RecognitionException {
        DTDParser.attDef_return retval = new DTDParser.attDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name55=null;
        Token DefaultDecl57=null;
        DTDParser.attType_return attType56 = null;


        Object Name55_tree=null;
        Object DefaultDecl57_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:164:7: ( Name attType DefaultDecl )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:164:9: Name attType DefaultDecl
            {
            root_0 = (Object)adaptor.nil();

            Name55=(Token)match(input,Name,FOLLOW_Name_in_attDef861); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name55_tree = (Object)adaptor.create(Name55);
            adaptor.addChild(root_0, Name55_tree);
            }
            pushFollow(FOLLOW_attType_in_attDef863);
            attType56=attType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, attType56.getTree());
            DefaultDecl57=(Token)match(input,DefaultDecl,FOLLOW_DefaultDecl_in_attDef865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DefaultDecl57_tree = (Object)adaptor.create(DefaultDecl57);
            adaptor.addChild(root_0, DefaultDecl57_tree);
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
    // $ANTLR end "attDef"

    public static class attType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attType"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:167:1: attType : ( stringType | tokenizedType | enumeratedType );
    public final DTDParser.attType_return attType() throws RecognitionException {
        DTDParser.attType_return retval = new DTDParser.attType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.stringType_return stringType58 = null;

        DTDParser.tokenizedType_return tokenizedType59 = null;

        DTDParser.enumeratedType_return enumeratedType60 = null;



        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:167:8: ( stringType | tokenizedType | enumeratedType )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt19=1;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt19=2;
                }
                break;
            case LParen:
            case 38:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:167:10: stringType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_stringType_in_attType876);
                    stringType58=stringType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringType58.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:167:23: tokenizedType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tokenizedType_in_attType880);
                    tokenizedType59=tokenizedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tokenizedType59.getTree());

                    }
                    break;
                case 3 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:167:39: enumeratedType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeratedType_in_attType884);
                    enumeratedType60=enumeratedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumeratedType60.getTree());

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
    // $ANTLR end "attType"

    public static class enumeration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumeration"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:169:1: enumeration : LParen Name ( '|' Name )* RParen ;
    public final DTDParser.enumeration_return enumeration() throws RecognitionException {
        DTDParser.enumeration_return retval = new DTDParser.enumeration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen61=null;
        Token Name62=null;
        Token char_literal63=null;
        Token Name64=null;
        Token RParen65=null;

        Object LParen61_tree=null;
        Object Name62_tree=null;
        Object char_literal63_tree=null;
        Object Name64_tree=null;
        Object RParen65_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:169:12: ( LParen Name ( '|' Name )* RParen )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:169:14: LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen61=(Token)match(input,LParen,FOLLOW_LParen_in_enumeration891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen61_tree = (Object)adaptor.create(LParen61);
            adaptor.addChild(root_0, LParen61_tree);
            }
            Name62=(Token)match(input,Name,FOLLOW_Name_in_enumeration893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name62_tree = (Object)adaptor.create(Name62);
            adaptor.addChild(root_0, Name62_tree);
            }
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:169:26: ( '|' Name )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==35) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:169:27: '|' Name
            	    {
            	    char_literal63=(Token)match(input,35,FOLLOW_35_in_enumeration896); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal63_tree = (Object)adaptor.create(char_literal63);
            	    adaptor.addChild(root_0, char_literal63_tree);
            	    }
            	    Name64=(Token)match(input,Name,FOLLOW_Name_in_enumeration898); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name64_tree = (Object)adaptor.create(Name64);
            	    adaptor.addChild(root_0, Name64_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            RParen65=(Token)match(input,RParen,FOLLOW_RParen_in_enumeration902); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen65_tree = (Object)adaptor.create(RParen65);
            adaptor.addChild(root_0, RParen65_tree);
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
    // $ANTLR end "enumeration"

    public static class enumeratedType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumeratedType"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:170:1: enumeratedType : ( notationType | enumeration );
    public final DTDParser.enumeratedType_return enumeratedType() throws RecognitionException {
        DTDParser.enumeratedType_return retval = new DTDParser.enumeratedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.notationType_return notationType66 = null;

        DTDParser.enumeration_return enumeration67 = null;



        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:170:15: ( notationType | enumeration )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            else if ( (LA21_0==LParen) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:170:17: notationType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_notationType_in_enumeratedType908);
                    notationType66=notationType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notationType66.getTree());

                    }
                    break;
                case 2 :
                    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:170:32: enumeration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeration_in_enumeratedType912);
                    enumeration67=enumeration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumeration67.getTree());

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
    // $ANTLR end "enumeratedType"

    public static class notationType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notationType"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:171:1: notationType : 'NOTATION' LParen Name ( '|' Name )* RParen ;
    public final DTDParser.notationType_return notationType() throws RecognitionException {
        DTDParser.notationType_return retval = new DTDParser.notationType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal68=null;
        Token LParen69=null;
        Token Name70=null;
        Token char_literal71=null;
        Token Name72=null;
        Token RParen73=null;

        Object string_literal68_tree=null;
        Object LParen69_tree=null;
        Object Name70_tree=null;
        Object char_literal71_tree=null;
        Object Name72_tree=null;
        Object RParen73_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:171:13: ( 'NOTATION' LParen Name ( '|' Name )* RParen )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:171:15: 'NOTATION' LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            string_literal68=(Token)match(input,38,FOLLOW_38_in_notationType918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal68_tree = (Object)adaptor.create(string_literal68);
            adaptor.addChild(root_0, string_literal68_tree);
            }
            LParen69=(Token)match(input,LParen,FOLLOW_LParen_in_notationType920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen69_tree = (Object)adaptor.create(LParen69);
            adaptor.addChild(root_0, LParen69_tree);
            }
            Name70=(Token)match(input,Name,FOLLOW_Name_in_notationType922); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name70_tree = (Object)adaptor.create(Name70);
            adaptor.addChild(root_0, Name70_tree);
            }
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:171:38: ( '|' Name )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==35) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:171:39: '|' Name
            	    {
            	    char_literal71=(Token)match(input,35,FOLLOW_35_in_notationType925); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal71_tree = (Object)adaptor.create(char_literal71);
            	    adaptor.addChild(root_0, char_literal71_tree);
            	    }
            	    Name72=(Token)match(input,Name,FOLLOW_Name_in_notationType927); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name72_tree = (Object)adaptor.create(Name72);
            	    adaptor.addChild(root_0, Name72_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            RParen73=(Token)match(input,RParen,FOLLOW_RParen_in_notationType931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen73_tree = (Object)adaptor.create(RParen73);
            adaptor.addChild(root_0, RParen73_tree);
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
    // $ANTLR end "notationType"

    public static class stringType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringType"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:173:1: stringType : 'CDATA' ;
    public final DTDParser.stringType_return stringType() throws RecognitionException {
        DTDParser.stringType_return retval = new DTDParser.stringType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal74=null;

        Object string_literal74_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:173:11: ( 'CDATA' )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:173:13: 'CDATA'
            {
            root_0 = (Object)adaptor.nil();

            string_literal74=(Token)match(input,39,FOLLOW_39_in_stringType938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal74_tree = (Object)adaptor.create(string_literal74);
            adaptor.addChild(root_0, string_literal74_tree);
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
    // $ANTLR end "stringType"

    public static class tokenizedType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tokenizedType"
    // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:176:1: tokenizedType : ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' );
    public final DTDParser.tokenizedType_return tokenizedType() throws RecognitionException {
        DTDParser.tokenizedType_return retval = new DTDParser.tokenizedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set75=null;

        Object set75_tree=null;

        try {
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:176:14: ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' )
            // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:
            {
            root_0 = (Object)adaptor.nil();

            set75=(Token)input.LT(1);
            if ( (input.LA(1)>=40 && input.LA(1)<=46) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set75));
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
    // $ANTLR end "tokenizedType"

    // $ANTLR start synpred1_DTD
    public final void synpred1_DTD_fragment() throws RecognitionException {   
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:141:3: ( choice )
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:141:4: choice
        {
        pushFollow(FOLLOW_choice_in_synpred1_DTD625);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_DTD

    // $ANTLR start synpred2_DTD
    public final void synpred2_DTD_fragment() throws RecognitionException {   
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:142:3: ( seq )
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:142:4: seq
        {
        pushFollow(FOLLOW_seq_in_synpred2_DTD649);
        seq();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_DTD

    // $ANTLR start synpred3_DTD
    public final void synpred3_DTD_fragment() throws RecognitionException {   
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:146:3: ( Name )
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:146:4: Name
        {
        match(input,Name,FOLLOW_Name_in_synpred3_DTD679); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_DTD

    // $ANTLR start synpred4_DTD
    public final void synpred4_DTD_fragment() throws RecognitionException {   
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:147:4: ( choice )
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:147:5: choice
        {
        pushFollow(FOLLOW_choice_in_synpred4_DTD704);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_DTD

    // $ANTLR start synpred5_DTD
    public final void synpred5_DTD_fragment() throws RecognitionException {   
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:148:4: ( seq )
        // D:\\work\\eclipse\\xerial\\xerial-core\\src\\main\\java\\org\\xerial\\util\\xml\\dtd\\impl\\DTD.g:148:5: seq
        {
        pushFollow(FOLLOW_seq_in_synpred5_DTD729);
        seq();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_DTD

    // Delegated rules

    public final boolean synpred5_DTD() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_DTD_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_DTD() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_DTD_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_DTD() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_DTD_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_DTD() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_DTD_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_DTD() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_DTD_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_Digits_in_integerLiteral487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral493 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral498 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral500 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerLiteral_in_numericLiteral546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimalLiteral_in_numericLiteral552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupdecl_in_dtd563 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_elementDecl_in_markupdecl571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attlistDecl_in_markupdecl575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Element_in_elementDecl583 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_elementDecl585 = new BitSet(new long[]{0x00000000C0004000L});
    public static final BitSet FOLLOW_contentSpec_in_elementDecl587 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_elementDecl589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_contentSpec599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_contentSpec603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mixed_in_contentSpec607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_children_in_contentSpec611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_children630 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_children633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_children654 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_children656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_cp684 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_cp709 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_cp734 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_choice756 = new BitSet(new long[]{0x00000000C0404000L});
    public static final BitSet FOLLOW_cp_in_choice758 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_choice761 = new BitSet(new long[]{0x00000000C0404000L});
    public static final BitSet FOLLOW_cp_in_choice763 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_choice767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_seq787 = new BitSet(new long[]{0x00000000C0404000L});
    public static final BitSet FOLLOW_cp_in_seq789 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Comma_in_seq792 = new BitSet(new long[]{0x00000000C0404000L});
    public static final BitSet FOLLOW_cp_in_seq794 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RParen_in_seq798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed808 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mixed810 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_mixed813 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_mixed815 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_mixed819 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_mixed821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed828 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mixed830 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RParen_in_mixed832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attlistDecl844 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_attlistDecl846 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_attDef_in_attlistDecl848 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_attlistDecl851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_attDef861 = new BitSet(new long[]{0x00007FC000004000L});
    public static final BitSet FOLLOW_attType_in_attDef863 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DefaultDecl_in_attDef865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_attType876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenizedType_in_attType880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeratedType_in_attType884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_enumeration891 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_enumeration893 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_enumeration896 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_enumeration898 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_enumeration902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notationType_in_enumeratedType908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_enumeratedType912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_notationType918 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LParen_in_notationType920 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_notationType922 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_notationType925 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_notationType927 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_notationType931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_stringType938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tokenizedType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred1_DTD625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred2_DTD649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_synpred3_DTD679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred4_DTD704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred5_DTD729 = new BitSet(new long[]{0x0000000000000002L});

}
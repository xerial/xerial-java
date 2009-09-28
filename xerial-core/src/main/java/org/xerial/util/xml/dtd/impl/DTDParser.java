// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 DTD.g 2009-09-28 17:56:15

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DTD", "STRINGTYPE", "TOKENIZEDTYPE", "ENUMTYPE", "NAME", "ATTRIBUTE", "ATTLIST", "DECL", "TYPE", "ELEMENT", "COMPONENT", "OCCURRENCE", "CONTENTSPEC", "ML_COMMENT", "At", "Colon", "Comma", "Apos", "Quot", "Dot", "SemiColon", "LParen", "RParen", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "Name", "Reference", "AttValue", "EntityRef", "CharRef", "DefaultDecl", "Element", "'>'", "'EMPTY'", "'ANY'", "'?'", "'*'", "'+'", "'|'", "'#PCDATA'", "'<!ATTLIST'", "'NOTATION'", "'CDATA'", "'ID'", "'IDREF'", "'IDREFS'", "'ENTITY'", "'ENTITIES'", "'NMTOKEN'", "'NMTOKENS'"
    };
    public static final int TYPE=12;
    public static final int CONTENTSPEC=16;
    public static final int T__42=42;
    public static final int ELEMENT=13;
    public static final int DefaultDecl=38;
    public static final int Digit=28;
    public static final int T__57=57;
    public static final int Apos=21;
    public static final int SemiColon=24;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int ATTLIST=10;
    public static final int TOKENIZEDTYPE=6;
    public static final int AttValue=35;
    public static final int Letter=27;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int Comma=20;
    public static final int Dot=23;
    public static final int T__49=49;
    public static final int DECL=11;
    public static final int ML_COMMENT=17;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int EntityRef=36;
    public static final int Colon=19;
    public static final int T__56=56;
    public static final int At=18;
    public static final int STRINGTYPE=5;
    public static final int NameChar=30;
    public static final int DTD=4;
    public static final int T__44=44;
    public static final int RParen=26;
    public static final int StringLiteral=32;
    public static final int Name=33;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int LParen=25;
    public static final int CharRef=37;
    public static final int OCCURRENCE=15;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int WhiteSpaceChar=31;
    public static final int EOF=-1;
    public static final int Reference=34;
    public static final int T__53=53;
    public static final int COMPONENT=14;
    public static final int ATTRIBUTE=9;
    public static final int Quot=22;
    public static final int NAME=8;
    public static final int Digits=29;
    public static final int Element=39;
    public static final int T__41=41;
    public static final int ENUMTYPE=7;

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
    public String getGrammarFileName() { return "DTD.g"; }


    public static class dtd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dtd"
    // DTD.g:145:1: dtd : ( markupdecl )* -> ^( DTD ( markupdecl )* ) ;
    public final DTDParser.dtd_return dtd() throws RecognitionException {
        DTDParser.dtd_return retval = new DTDParser.dtd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.markupdecl_return markupdecl1 = null;


        RewriteRuleSubtreeStream stream_markupdecl=new RewriteRuleSubtreeStream(adaptor,"rule markupdecl");
        try {
            // DTD.g:145:4: ( ( markupdecl )* -> ^( DTD ( markupdecl )* ) )
            // DTD.g:145:6: ( markupdecl )*
            {
            // DTD.g:145:6: ( markupdecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Element||LA1_0==48) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // DTD.g:145:6: markupdecl
            	    {
            	    pushFollow(FOLLOW_markupdecl_in_dtd526);
            	    markupdecl1=markupdecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_markupdecl.add(markupdecl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: markupdecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 146:3: -> ^( DTD ( markupdecl )* )
            {
                // DTD.g:146:6: ^( DTD ( markupdecl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DTD, "DTD"), root_1);

                // DTD.g:146:12: ( markupdecl )*
                while ( stream_markupdecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_markupdecl.nextTree());

                }
                stream_markupdecl.reset();

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
    // $ANTLR end "dtd"

    public static class markupdecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupdecl"
    // DTD.g:149:1: fragment markupdecl : ( elementDecl | attlistDecl );
    public final DTDParser.markupdecl_return markupdecl() throws RecognitionException {
        DTDParser.markupdecl_return retval = new DTDParser.markupdecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.elementDecl_return elementDecl2 = null;

        DTDParser.attlistDecl_return attlistDecl3 = null;



        try {
            // DTD.g:150:11: ( elementDecl | attlistDecl )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Element) ) {
                alt2=1;
            }
            else if ( (LA2_0==48) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // DTD.g:150:13: elementDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementDecl_in_markupdecl548);
                    elementDecl2=elementDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementDecl2.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:150:27: attlistDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attlistDecl_in_markupdecl552);
                    attlistDecl3=attlistDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attlistDecl3.getTree());

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
    // DTD.g:152:1: elementDecl : Element Name contentSpec '>' -> ^( ELEMENT NAME[$Name.text] contentSpec ) ;
    public final DTDParser.elementDecl_return elementDecl() throws RecognitionException {
        DTDParser.elementDecl_return retval = new DTDParser.elementDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Element4=null;
        Token Name5=null;
        Token char_literal7=null;
        DTDParser.contentSpec_return contentSpec6 = null;


        Object Element4_tree=null;
        Object Name5_tree=null;
        Object char_literal7_tree=null;
        RewriteRuleTokenStream stream_Element=new RewriteRuleTokenStream(adaptor,"token Element");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_contentSpec=new RewriteRuleSubtreeStream(adaptor,"rule contentSpec");
        try {
            // DTD.g:152:12: ( Element Name contentSpec '>' -> ^( ELEMENT NAME[$Name.text] contentSpec ) )
            // DTD.g:152:14: Element Name contentSpec '>'
            {
            Element4=(Token)match(input,Element,FOLLOW_Element_in_elementDecl559); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Element.add(Element4);

            Name5=(Token)match(input,Name,FOLLOW_Name_in_elementDecl561); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name5);

            pushFollow(FOLLOW_contentSpec_in_elementDecl563);
            contentSpec6=contentSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_contentSpec.add(contentSpec6.getTree());
            char_literal7=(Token)match(input,40,FOLLOW_40_in_elementDecl565); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal7);



            // AST REWRITE
            // elements: contentSpec
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 153:3: -> ^( ELEMENT NAME[$Name.text] contentSpec )
            {
                // DTD.g:153:6: ^( ELEMENT NAME[$Name.text] contentSpec )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name5!=null?Name5.getText():null)));
                adaptor.addChild(root_1, stream_contentSpec.nextTree());

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
    // $ANTLR end "elementDecl"

    public static class contentSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contentSpec"
    // DTD.g:156:1: fragment contentSpec : ( 'EMPTY' -> CONTENTSPEC[\"EMPTY\"] | 'ANY' -> CONTENTSPEC[\"ANY\"] | mixed | children );
    public final DTDParser.contentSpec_return contentSpec() throws RecognitionException {
        DTDParser.contentSpec_return retval = new DTDParser.contentSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal8=null;
        Token string_literal9=null;
        DTDParser.mixed_return mixed10 = null;

        DTDParser.children_return children11 = null;


        Object string_literal8_tree=null;
        Object string_literal9_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

        try {
            // DTD.g:158:3: ( 'EMPTY' -> CONTENTSPEC[\"EMPTY\"] | 'ANY' -> CONTENTSPEC[\"ANY\"] | mixed | children )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt3=1;
                }
                break;
            case 42:
                {
                alt3=2;
                }
                break;
            case LParen:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==47) ) {
                    alt3=3;
                }
                else if ( (LA3_3==LParen||LA3_3==Name) ) {
                    alt3=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // DTD.g:158:5: 'EMPTY'
                    {
                    string_literal8=(Token)match(input,41,FOLLOW_41_in_contentSpec593); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(string_literal8);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 158:13: -> CONTENTSPEC[\"EMPTY\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(CONTENTSPEC, "EMPTY"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:159:5: 'ANY'
                    {
                    string_literal9=(Token)match(input,42,FOLLOW_42_in_contentSpec604); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(string_literal9);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 159:13: -> CONTENTSPEC[\"ANY\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(CONTENTSPEC, "ANY"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:160:5: mixed
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mixed_in_contentSpec617);
                    mixed10=mixed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mixed10.getTree());

                    }
                    break;
                case 4 :
                    // DTD.g:161:5: children
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_children_in_contentSpec624);
                    children11=children();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, children11.getTree());

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
    // DTD.g:164:1: fragment children : ( ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) );
    public final DTDParser.children_return children() throws RecognitionException {
        DTDParser.children_return retval = new DTDParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.choice_return choice12 = null;

        DTDParser.plural_return plural13 = null;

        DTDParser.seq_return seq14 = null;

        DTDParser.plural_return plural15 = null;


        RewriteRuleSubtreeStream stream_seq=new RewriteRuleSubtreeStream(adaptor,"rule seq");
        RewriteRuleSubtreeStream stream_choice=new RewriteRuleSubtreeStream(adaptor,"rule choice");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // DTD.g:166:1: ( ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LParen) ) {
                int LA6_1 = input.LA(2);

                if ( (synpred1_DTD()) ) {
                    alt6=1;
                }
                else if ( (synpred2_DTD()) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // DTD.g:166:3: ( choice )=> choice ( plural )?
                    {
                    pushFollow(FOLLOW_choice_in_children647);
                    choice12=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_choice.add(choice12.getTree());
                    // DTD.g:166:23: ( plural )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=43 && LA4_0<=45)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // DTD.g:166:23: plural
                            {
                            pushFollow(FOLLOW_plural_in_children650);
                            plural13=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural13.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: choice, plural
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 166:31: -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                    {
                        // DTD.g:166:34: ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "choice"));
                        adaptor.addChild(root_1, stream_choice.nextTree());
                        // DTD.g:166:69: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:167:3: ( seq )=> seq ( plural )?
                    {
                    pushFollow(FOLLOW_seq_in_children676);
                    seq14=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_seq.add(seq14.getTree());
                    // DTD.g:167:16: ( plural )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=43 && LA5_0<=45)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // DTD.g:167:16: plural
                            {
                            pushFollow(FOLLOW_plural_in_children678);
                            plural15=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural15.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: plural, seq
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 167:24: -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                    {
                        // DTD.g:167:27: ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "seq"));
                        adaptor.addChild(root_1, stream_seq.nextTree());
                        // DTD.g:167:55: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();

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
    // $ANTLR end "children"

    public static class cp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cp"
    // DTD.g:170:1: fragment cp : ( ( Name )=> Name ( plural )? -> ^( COMPONENT NAME[$Name.text] ( plural )? ) | ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) );
    public final DTDParser.cp_return cp() throws RecognitionException {
        DTDParser.cp_return retval = new DTDParser.cp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name16=null;
        DTDParser.plural_return plural17 = null;

        DTDParser.choice_return choice18 = null;

        DTDParser.plural_return plural19 = null;

        DTDParser.seq_return seq20 = null;

        DTDParser.plural_return plural21 = null;


        Object Name16_tree=null;
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_seq=new RewriteRuleSubtreeStream(adaptor,"rule seq");
        RewriteRuleSubtreeStream stream_choice=new RewriteRuleSubtreeStream(adaptor,"rule choice");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // DTD.g:172:1: ( ( Name )=> Name ( plural )? -> ^( COMPONENT NAME[$Name.text] ( plural )? ) | ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Name) && (synpred3_DTD())) {
                alt10=1;
            }
            else if ( (LA10_0==LParen) ) {
                int LA10_2 = input.LA(2);

                if ( (synpred4_DTD()) ) {
                    alt10=2;
                }
                else if ( (synpred5_DTD()) ) {
                    alt10=3;
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // DTD.g:172:3: ( Name )=> Name ( plural )?
                    {
                    Name16=(Token)match(input,Name,FOLLOW_Name_in_cp712); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Name.add(Name16);

                    // DTD.g:172:19: ( plural )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=43 && LA7_0<=45)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // DTD.g:172:19: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp715);
                            plural17=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural17.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: plural
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 172:27: -> ^( COMPONENT NAME[$Name.text] ( plural )? )
                    {
                        // DTD.g:172:30: ^( COMPONENT NAME[$Name.text] ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name16!=null?Name16.getText():null)));
                        // DTD.g:172:59: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:173:4: ( choice )=> choice ( plural )?
                    {
                    pushFollow(FOLLOW_choice_in_cp739);
                    choice18=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_choice.add(choice18.getTree());
                    // DTD.g:173:24: ( plural )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=43 && LA8_0<=45)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // DTD.g:173:24: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp742);
                            plural19=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural19.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: plural, choice
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 173:32: -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                    {
                        // DTD.g:173:35: ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "choice"));
                        adaptor.addChild(root_1, stream_choice.nextTree());
                        // DTD.g:173:69: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:174:4: ( seq )=> seq ( plural )?
                    {
                    pushFollow(FOLLOW_seq_in_cp768);
                    seq20=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_seq.add(seq20.getTree());
                    // DTD.g:174:18: ( plural )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=43 && LA9_0<=45)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // DTD.g:174:18: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp771);
                            plural21=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural21.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: seq, plural
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 174:26: -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                    {
                        // DTD.g:174:29: ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "seq"));
                        adaptor.addChild(root_1, stream_seq.nextTree());
                        // DTD.g:174:57: ( plural )?
                        if ( stream_plural.hasNext() ) {
                            adaptor.addChild(root_1, stream_plural.nextTree());

                        }
                        stream_plural.reset();

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
    // $ANTLR end "cp"

    public static class plural_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plural"
    // DTD.g:177:1: fragment plural : ( '?' -> OCCURRENCE[\"ZERO_OR_ONE\"] | '*' -> OCCURRENCE[\"ZERO_OR_MORE\"] | '+' -> OCCURRENCE[\"ONE_OR_MORE\"] );
    public final DTDParser.plural_return plural() throws RecognitionException {
        DTDParser.plural_return retval = new DTDParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;

        Object char_literal22_tree=null;
        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");

        try {
            // DTD.g:179:3: ( '?' -> OCCURRENCE[\"ZERO_OR_ONE\"] | '*' -> OCCURRENCE[\"ZERO_OR_MORE\"] | '+' -> OCCURRENCE[\"ONE_OR_MORE\"] )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt11=1;
                }
                break;
            case 44:
                {
                alt11=2;
                }
                break;
            case 45:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // DTD.g:179:5: '?'
                    {
                    char_literal22=(Token)match(input,43,FOLLOW_43_in_plural799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal22);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 179:9: -> OCCURRENCE[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OCCURRENCE, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:180:5: '*'
                    {
                    char_literal23=(Token)match(input,44,FOLLOW_44_in_plural810); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal23);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 180:9: -> OCCURRENCE[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OCCURRENCE, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:181:5: '+'
                    {
                    char_literal24=(Token)match(input,45,FOLLOW_45_in_plural821); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal24);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 181:9: -> OCCURRENCE[\"ONE_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OCCURRENCE, "ONE_OR_MORE"));

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
    // $ANTLR end "plural"

    public static class choice_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "choice"
    // DTD.g:185:1: fragment choice : LParen cp ( '|' cp )* RParen -> ( cp )+ ;
    public final DTDParser.choice_return choice() throws RecognitionException {
        DTDParser.choice_return retval = new DTDParser.choice_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen25=null;
        Token char_literal27=null;
        Token RParen29=null;
        DTDParser.cp_return cp26 = null;

        DTDParser.cp_return cp28 = null;


        Object LParen25_tree=null;
        Object char_literal27_tree=null;
        Object RParen29_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_cp=new RewriteRuleSubtreeStream(adaptor,"rule cp");
        try {
            // DTD.g:186:7: ( LParen cp ( '|' cp )* RParen -> ( cp )+ )
            // DTD.g:186:9: LParen cp ( '|' cp )* RParen
            {
            LParen25=(Token)match(input,LParen,FOLLOW_LParen_in_choice841); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen25);

            pushFollow(FOLLOW_cp_in_choice843);
            cp26=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cp.add(cp26.getTree());
            // DTD.g:186:19: ( '|' cp )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==46) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // DTD.g:186:20: '|' cp
            	    {
            	    char_literal27=(Token)match(input,46,FOLLOW_46_in_choice846); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_46.add(char_literal27);

            	    pushFollow(FOLLOW_cp_in_choice848);
            	    cp28=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cp.add(cp28.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RParen29=(Token)match(input,RParen,FOLLOW_RParen_in_choice852); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen29);



            // AST REWRITE
            // elements: cp
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 187:3: -> ( cp )+
            {
                if ( !(stream_cp.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cp.hasNext() ) {
                    adaptor.addChild(root_0, stream_cp.nextTree());

                }
                stream_cp.reset();

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
    // $ANTLR end "choice"

    public static class seq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "seq"
    // DTD.g:190:1: fragment seq : ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen -> ( cp )+ ;
    public final DTDParser.seq_return seq() throws RecognitionException {
        DTDParser.seq_return retval = new DTDParser.seq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen30=null;
        Token Comma32=null;
        Token RParen34=null;
        DTDParser.cp_return cp31 = null;

        DTDParser.cp_return cp33 = null;


        Object LParen30_tree=null;
        Object Comma32_tree=null;
        Object RParen34_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_cp=new RewriteRuleSubtreeStream(adaptor,"rule cp");
        try {
            // DTD.g:191:4: ( ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen -> ( cp )+ )
            // DTD.g:191:6: ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen
            {
            LParen30=(Token)match(input,LParen,FOLLOW_LParen_in_seq881); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen30);

            pushFollow(FOLLOW_cp_in_seq883);
            cp31=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cp.add(cp31.getTree());
            // DTD.g:191:37: ( Comma cp )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Comma) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // DTD.g:191:38: Comma cp
            	    {
            	    Comma32=(Token)match(input,Comma,FOLLOW_Comma_in_seq886); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma32);

            	    pushFollow(FOLLOW_cp_in_seq888);
            	    cp33=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cp.add(cp33.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            RParen34=(Token)match(input,RParen,FOLLOW_RParen_in_seq892); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen34);



            // AST REWRITE
            // elements: cp
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 192:3: -> ( cp )+
            {
                if ( !(stream_cp.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cp.hasNext() ) {
                    adaptor.addChild(root_0, stream_cp.nextTree());

                }
                stream_cp.reset();

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
    // $ANTLR end "seq"

    public static class mixed_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mixed"
    // DTD.g:195:1: fragment mixed : ( LParen '#PCDATA' ( '|' mixed_i )* RParen '*' -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* ) | LParen '#PCDATA' RParen -> ^( COMPONENT TYPE[\"pcdata\"] ) );
    public final DTDParser.mixed_return mixed() throws RecognitionException {
        DTDParser.mixed_return retval = new DTDParser.mixed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen35=null;
        Token string_literal36=null;
        Token char_literal37=null;
        Token RParen39=null;
        Token char_literal40=null;
        Token LParen41=null;
        Token string_literal42=null;
        Token RParen43=null;
        DTDParser.mixed_i_return mixed_i38 = null;


        Object LParen35_tree=null;
        Object string_literal36_tree=null;
        Object char_literal37_tree=null;
        Object RParen39_tree=null;
        Object char_literal40_tree=null;
        Object LParen41_tree=null;
        Object string_literal42_tree=null;
        Object RParen43_tree=null;
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_mixed_i=new RewriteRuleSubtreeStream(adaptor,"rule mixed_i");
        try {
            // DTD.g:197:3: ( LParen '#PCDATA' ( '|' mixed_i )* RParen '*' -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* ) | LParen '#PCDATA' RParen -> ^( COMPONENT TYPE[\"pcdata\"] ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LParen) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==47) ) {
                    int LA15_2 = input.LA(3);

                    if ( (LA15_2==RParen) ) {
                        int LA15_3 = input.LA(4);

                        if ( (LA15_3==44) ) {
                            alt15=1;
                        }
                        else if ( (LA15_3==40) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA15_2==46) ) {
                        alt15=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // DTD.g:197:5: LParen '#PCDATA' ( '|' mixed_i )* RParen '*'
                    {
                    LParen35=(Token)match(input,LParen,FOLLOW_LParen_in_mixed914); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen35);

                    string_literal36=(Token)match(input,47,FOLLOW_47_in_mixed916); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal36);

                    // DTD.g:197:22: ( '|' mixed_i )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==46) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // DTD.g:197:23: '|' mixed_i
                    	    {
                    	    char_literal37=(Token)match(input,46,FOLLOW_46_in_mixed919); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_46.add(char_literal37);

                    	    pushFollow(FOLLOW_mixed_i_in_mixed921);
                    	    mixed_i38=mixed_i();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_mixed_i.add(mixed_i38.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    RParen39=(Token)match(input,RParen,FOLLOW_RParen_in_mixed925); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen39);

                    char_literal40=(Token)match(input,44,FOLLOW_44_in_mixed927); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal40);



                    // AST REWRITE
                    // elements: mixed_i
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 198:5: -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* )
                    {
                        // DTD.g:198:8: ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "mixed"));
                        // DTD.g:198:34: ( mixed_i )*
                        while ( stream_mixed_i.hasNext() ) {
                            adaptor.addChild(root_1, stream_mixed_i.nextTree());

                        }
                        stream_mixed_i.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:199:5: LParen '#PCDATA' RParen
                    {
                    LParen41=(Token)match(input,LParen,FOLLOW_LParen_in_mixed949); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen41);

                    string_literal42=(Token)match(input,47,FOLLOW_47_in_mixed951); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal42);

                    RParen43=(Token)match(input,RParen,FOLLOW_RParen_in_mixed953); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen43);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 200:5: -> ^( COMPONENT TYPE[\"pcdata\"] )
                    {
                        // DTD.g:200:8: ^( COMPONENT TYPE[\"pcdata\"] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "pcdata"));

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
    // $ANTLR end "mixed"

    public static class mixed_i_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mixed_i"
    // DTD.g:203:1: mixed_i : Name -> NAME[$Name.text] ;
    public final DTDParser.mixed_i_return mixed_i() throws RecognitionException {
        DTDParser.mixed_i_return retval = new DTDParser.mixed_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name44=null;

        Object Name44_tree=null;
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

        try {
            // DTD.g:204:3: ( Name -> NAME[$Name.text] )
            // DTD.g:204:5: Name
            {
            Name44=(Token)match(input,Name,FOLLOW_Name_in_mixed_i982); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name44);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 204:10: -> NAME[$Name.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(NAME, (Name44!=null?Name44.getText():null)));

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
    // $ANTLR end "mixed_i"

    public static class attlistDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attlistDecl"
    // DTD.g:207:1: attlistDecl : '<!ATTLIST' Name ( attDef )* '>' -> ^( ATTLIST NAME[$Name.text] ( attDef )* ) ;
    public final DTDParser.attlistDecl_return attlistDecl() throws RecognitionException {
        DTDParser.attlistDecl_return retval = new DTDParser.attlistDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal45=null;
        Token Name46=null;
        Token char_literal48=null;
        DTDParser.attDef_return attDef47 = null;


        Object string_literal45_tree=null;
        Object Name46_tree=null;
        Object char_literal48_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_attDef=new RewriteRuleSubtreeStream(adaptor,"rule attDef");
        try {
            // DTD.g:207:12: ( '<!ATTLIST' Name ( attDef )* '>' -> ^( ATTLIST NAME[$Name.text] ( attDef )* ) )
            // DTD.g:207:14: '<!ATTLIST' Name ( attDef )* '>'
            {
            string_literal45=(Token)match(input,48,FOLLOW_48_in_attlistDecl1003); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_48.add(string_literal45);

            Name46=(Token)match(input,Name,FOLLOW_Name_in_attlistDecl1005); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name46);

            // DTD.g:207:31: ( attDef )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Name) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // DTD.g:207:31: attDef
            	    {
            	    pushFollow(FOLLOW_attDef_in_attlistDecl1007);
            	    attDef47=attDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attDef.add(attDef47.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            char_literal48=(Token)match(input,40,FOLLOW_40_in_attlistDecl1010); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal48);



            // AST REWRITE
            // elements: attDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 208:3: -> ^( ATTLIST NAME[$Name.text] ( attDef )* )
            {
                // DTD.g:208:6: ^( ATTLIST NAME[$Name.text] ( attDef )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTLIST, "ATTLIST"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name46!=null?Name46.getText():null)));
                // DTD.g:208:33: ( attDef )*
                while ( stream_attDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_attDef.nextTree());

                }
                stream_attDef.reset();

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
    // $ANTLR end "attlistDecl"

    public static class attDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attDef"
    // DTD.g:211:1: fragment attDef : Name attType DefaultDecl -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text.substring(1] ) ;
    public final DTDParser.attDef_return attDef() throws RecognitionException {
        DTDParser.attDef_return retval = new DTDParser.attDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name49=null;
        Token DefaultDecl51=null;
        DTDParser.attType_return attType50 = null;


        Object Name49_tree=null;
        Object DefaultDecl51_tree=null;
        RewriteRuleTokenStream stream_DefaultDecl=new RewriteRuleTokenStream(adaptor,"token DefaultDecl");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_attType=new RewriteRuleSubtreeStream(adaptor,"rule attType");
        try {
            // DTD.g:212:7: ( Name attType DefaultDecl -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text.substring(1] ) )
            // DTD.g:212:9: Name attType DefaultDecl
            {
            Name49=(Token)match(input,Name,FOLLOW_Name_in_attDef1036); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name49);

            pushFollow(FOLLOW_attType_in_attDef1038);
            attType50=attType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attType.add(attType50.getTree());
            DefaultDecl51=(Token)match(input,DefaultDecl,FOLLOW_DefaultDecl_in_attDef1040); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DefaultDecl.add(DefaultDecl51);



            // AST REWRITE
            // elements: attType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 213:3: -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text.substring(1] )
            {
                // DTD.g:213:6: ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text.substring(1] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name49!=null?Name49.getText():null)));
                adaptor.addChild(root_1, stream_attType.nextTree());
                adaptor.addChild(root_1, (Object)adaptor.create(DECL, "DECL"));

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
    // $ANTLR end "attDef"

    public static class attType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attType"
    // DTD.g:216:1: fragment attType : ( stringType -> STRINGTYPE[$stringType.text] | tokenizedType -> TOKENIZEDTYPE[$tokenizedType.text] | enumeratedType -> ENUMTYPE[$enumeratedType.text] );
    public final DTDParser.attType_return attType() throws RecognitionException {
        DTDParser.attType_return retval = new DTDParser.attType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.stringType_return stringType52 = null;

        DTDParser.tokenizedType_return tokenizedType53 = null;

        DTDParser.enumeratedType_return enumeratedType54 = null;


        RewriteRuleSubtreeStream stream_enumeratedType=new RewriteRuleSubtreeStream(adaptor,"rule enumeratedType");
        RewriteRuleSubtreeStream stream_tokenizedType=new RewriteRuleSubtreeStream(adaptor,"rule tokenizedType");
        RewriteRuleSubtreeStream stream_stringType=new RewriteRuleSubtreeStream(adaptor,"rule stringType");
        try {
            // DTD.g:218:3: ( stringType -> STRINGTYPE[$stringType.text] | tokenizedType -> TOKENIZEDTYPE[$tokenizedType.text] | enumeratedType -> ENUMTYPE[$enumeratedType.text] )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt17=1;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                {
                alt17=2;
                }
                break;
            case LParen:
            case 49:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // DTD.g:218:5: stringType
                    {
                    pushFollow(FOLLOW_stringType_in_attType1072);
                    stringType52=stringType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringType.add(stringType52.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 218:16: -> STRINGTYPE[$stringType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(STRINGTYPE, (stringType52!=null?input.toString(stringType52.start,stringType52.stop):null)));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:219:5: tokenizedType
                    {
                    pushFollow(FOLLOW_tokenizedType_in_attType1084);
                    tokenizedType53=tokenizedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tokenizedType.add(tokenizedType53.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 219:19: -> TOKENIZEDTYPE[$tokenizedType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TOKENIZEDTYPE, (tokenizedType53!=null?input.toString(tokenizedType53.start,tokenizedType53.stop):null)));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:220:5: enumeratedType
                    {
                    pushFollow(FOLLOW_enumeratedType_in_attType1096);
                    enumeratedType54=enumeratedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_enumeratedType.add(enumeratedType54.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 220:20: -> ENUMTYPE[$enumeratedType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(ENUMTYPE, (enumeratedType54!=null?input.toString(enumeratedType54.start,enumeratedType54.stop):null)));

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
    // $ANTLR end "attType"

    public static class enumeration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumeration"
    // DTD.g:223:1: fragment enumeration : LParen Name ( '|' Name )* RParen ;
    public final DTDParser.enumeration_return enumeration() throws RecognitionException {
        DTDParser.enumeration_return retval = new DTDParser.enumeration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen55=null;
        Token Name56=null;
        Token char_literal57=null;
        Token Name58=null;
        Token RParen59=null;

        Object LParen55_tree=null;
        Object Name56_tree=null;
        Object char_literal57_tree=null;
        Object Name58_tree=null;
        Object RParen59_tree=null;

        try {
            // DTD.g:224:12: ( LParen Name ( '|' Name )* RParen )
            // DTD.g:224:14: LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen55=(Token)match(input,LParen,FOLLOW_LParen_in_enumeration1113); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen55_tree = (Object)adaptor.create(LParen55);
            adaptor.addChild(root_0, LParen55_tree);
            }
            Name56=(Token)match(input,Name,FOLLOW_Name_in_enumeration1115); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name56_tree = (Object)adaptor.create(Name56);
            adaptor.addChild(root_0, Name56_tree);
            }
            // DTD.g:224:26: ( '|' Name )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==46) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // DTD.g:224:27: '|' Name
            	    {
            	    char_literal57=(Token)match(input,46,FOLLOW_46_in_enumeration1118); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal57_tree = (Object)adaptor.create(char_literal57);
            	    adaptor.addChild(root_0, char_literal57_tree);
            	    }
            	    Name58=(Token)match(input,Name,FOLLOW_Name_in_enumeration1120); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name58_tree = (Object)adaptor.create(Name58);
            	    adaptor.addChild(root_0, Name58_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            RParen59=(Token)match(input,RParen,FOLLOW_RParen_in_enumeration1124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen59_tree = (Object)adaptor.create(RParen59);
            adaptor.addChild(root_0, RParen59_tree);
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
    // DTD.g:225:1: fragment enumeratedType : ( notationType | enumeration );
    public final DTDParser.enumeratedType_return enumeratedType() throws RecognitionException {
        DTDParser.enumeratedType_return retval = new DTDParser.enumeratedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.notationType_return notationType60 = null;

        DTDParser.enumeration_return enumeration61 = null;



        try {
            // DTD.g:226:15: ( notationType | enumeration )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==49) ) {
                alt19=1;
            }
            else if ( (LA19_0==LParen) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // DTD.g:226:17: notationType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_notationType_in_enumeratedType1132);
                    notationType60=notationType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notationType60.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:226:32: enumeration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeration_in_enumeratedType1136);
                    enumeration61=enumeration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumeration61.getTree());

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
    // DTD.g:227:1: fragment notationType : 'NOTATION' LParen Name ( '|' Name )* RParen ;
    public final DTDParser.notationType_return notationType() throws RecognitionException {
        DTDParser.notationType_return retval = new DTDParser.notationType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal62=null;
        Token LParen63=null;
        Token Name64=null;
        Token char_literal65=null;
        Token Name66=null;
        Token RParen67=null;

        Object string_literal62_tree=null;
        Object LParen63_tree=null;
        Object Name64_tree=null;
        Object char_literal65_tree=null;
        Object Name66_tree=null;
        Object RParen67_tree=null;

        try {
            // DTD.g:228:13: ( 'NOTATION' LParen Name ( '|' Name )* RParen )
            // DTD.g:228:15: 'NOTATION' LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            string_literal62=(Token)match(input,49,FOLLOW_49_in_notationType1144); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal62_tree = (Object)adaptor.create(string_literal62);
            adaptor.addChild(root_0, string_literal62_tree);
            }
            LParen63=(Token)match(input,LParen,FOLLOW_LParen_in_notationType1146); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen63_tree = (Object)adaptor.create(LParen63);
            adaptor.addChild(root_0, LParen63_tree);
            }
            Name64=(Token)match(input,Name,FOLLOW_Name_in_notationType1148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name64_tree = (Object)adaptor.create(Name64);
            adaptor.addChild(root_0, Name64_tree);
            }
            // DTD.g:228:38: ( '|' Name )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==46) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // DTD.g:228:39: '|' Name
            	    {
            	    char_literal65=(Token)match(input,46,FOLLOW_46_in_notationType1151); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal65_tree = (Object)adaptor.create(char_literal65);
            	    adaptor.addChild(root_0, char_literal65_tree);
            	    }
            	    Name66=(Token)match(input,Name,FOLLOW_Name_in_notationType1153); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name66_tree = (Object)adaptor.create(Name66);
            	    adaptor.addChild(root_0, Name66_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            RParen67=(Token)match(input,RParen,FOLLOW_RParen_in_notationType1157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen67_tree = (Object)adaptor.create(RParen67);
            adaptor.addChild(root_0, RParen67_tree);
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
    // DTD.g:230:1: fragment stringType : 'CDATA' ;
    public final DTDParser.stringType_return stringType() throws RecognitionException {
        DTDParser.stringType_return retval = new DTDParser.stringType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal68=null;

        Object string_literal68_tree=null;

        try {
            // DTD.g:231:11: ( 'CDATA' )
            // DTD.g:231:13: 'CDATA'
            {
            root_0 = (Object)adaptor.nil();

            string_literal68=(Token)match(input,50,FOLLOW_50_in_stringType1166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal68_tree = (Object)adaptor.create(string_literal68);
            adaptor.addChild(root_0, string_literal68_tree);
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
    // DTD.g:234:1: fragment tokenizedType : ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' );
    public final DTDParser.tokenizedType_return tokenizedType() throws RecognitionException {
        DTDParser.tokenizedType_return retval = new DTDParser.tokenizedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set69=null;

        Object set69_tree=null;

        try {
            // DTD.g:236:3: ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' )
            // DTD.g:
            {
            root_0 = (Object)adaptor.nil();

            set69=(Token)input.LT(1);
            if ( (input.LA(1)>=51 && input.LA(1)<=57) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set69));
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
        // DTD.g:166:3: ( choice )
        // DTD.g:166:4: choice
        {
        pushFollow(FOLLOW_choice_in_synpred1_DTD642);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_DTD

    // $ANTLR start synpred2_DTD
    public final void synpred2_DTD_fragment() throws RecognitionException {   
        // DTD.g:167:3: ( seq )
        // DTD.g:167:4: seq
        {
        pushFollow(FOLLOW_seq_in_synpred2_DTD671);
        seq();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_DTD

    // $ANTLR start synpred3_DTD
    public final void synpred3_DTD_fragment() throws RecognitionException {   
        // DTD.g:172:3: ( Name )
        // DTD.g:172:4: Name
        {
        match(input,Name,FOLLOW_Name_in_synpred3_DTD707); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_DTD

    // $ANTLR start synpred4_DTD
    public final void synpred4_DTD_fragment() throws RecognitionException {   
        // DTD.g:173:4: ( choice )
        // DTD.g:173:5: choice
        {
        pushFollow(FOLLOW_choice_in_synpred4_DTD734);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_DTD

    // $ANTLR start synpred5_DTD
    public final void synpred5_DTD_fragment() throws RecognitionException {   
        // DTD.g:174:4: ( seq )
        // DTD.g:174:5: seq
        {
        pushFollow(FOLLOW_seq_in_synpred5_DTD763);
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


 

    public static final BitSet FOLLOW_markupdecl_in_dtd526 = new BitSet(new long[]{0x0001008000000002L});
    public static final BitSet FOLLOW_elementDecl_in_markupdecl548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attlistDecl_in_markupdecl552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Element_in_elementDecl559 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_elementDecl561 = new BitSet(new long[]{0x0000060002000000L});
    public static final BitSet FOLLOW_contentSpec_in_elementDecl563 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_elementDecl565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_contentSpec593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_contentSpec604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mixed_in_contentSpec617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_children_in_contentSpec624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_children647 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_plural_in_children650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_children676 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_plural_in_children678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_cp712 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_plural_in_cp715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_cp739 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_plural_in_cp742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_cp768 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_plural_in_cp771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_plural799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_plural810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_plural821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_choice841 = new BitSet(new long[]{0x0000060202000000L});
    public static final BitSet FOLLOW_cp_in_choice843 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_46_in_choice846 = new BitSet(new long[]{0x0000060202000000L});
    public static final BitSet FOLLOW_cp_in_choice848 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_RParen_in_choice852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_seq881 = new BitSet(new long[]{0x0000060202000000L});
    public static final BitSet FOLLOW_cp_in_seq883 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Comma_in_seq886 = new BitSet(new long[]{0x0000060202000000L});
    public static final BitSet FOLLOW_cp_in_seq888 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_RParen_in_seq892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed914 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_mixed916 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_46_in_mixed919 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_mixed_i_in_mixed921 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_RParen_in_mixed925 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_mixed927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed949 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_mixed951 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_RParen_in_mixed953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_mixed_i982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attlistDecl1003 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_attlistDecl1005 = new BitSet(new long[]{0x0000010200000000L});
    public static final BitSet FOLLOW_attDef_in_attlistDecl1007 = new BitSet(new long[]{0x0000010200000000L});
    public static final BitSet FOLLOW_40_in_attlistDecl1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_attDef1036 = new BitSet(new long[]{0x03FE000002000000L});
    public static final BitSet FOLLOW_attType_in_attDef1038 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_DefaultDecl_in_attDef1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_attType1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenizedType_in_attType1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeratedType_in_attType1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_enumeration1113 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_enumeration1115 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_46_in_enumeration1118 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_enumeration1120 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_RParen_in_enumeration1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notationType_in_enumeratedType1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_enumeratedType1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_notationType1144 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LParen_in_notationType1146 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_notationType1148 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_46_in_notationType1151 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Name_in_notationType1153 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_RParen_in_notationType1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_stringType1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tokenizedType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred1_DTD642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred2_DTD671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_synpred3_DTD707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred4_DTD734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred5_DTD763 = new BitSet(new long[]{0x0000000000000002L});

}
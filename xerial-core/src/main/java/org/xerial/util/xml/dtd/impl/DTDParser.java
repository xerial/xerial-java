// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 DTD.g 2009-09-28 19:12:54

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DTD", "STRINGTYPE", "TOKENIZEDTYPE", "ENUMTYPE", "NAME", "ATTRIBUTE", "ATTLIST", "DECL", "TYPE", "ELEMENT", "COMPONENT", "OCCURRENCE", "CONTENTSPEC", "ENTITY", "VALUE", "ML_COMMENT", "At", "Colon", "Comma", "Apos", "Quot", "Dot", "SemiColon", "LParen", "RParen", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "String", "Name", "Reference", "AttValue", "EntityRef", "CharRef", "DefaultDecl", "Element", "'>'", "'EMPTY'", "'ANY'", "'?'", "'*'", "'+'", "'|'", "'#PCDATA'", "'<!ATTLIST'", "'NOTATION'", "'CDATA'", "'ID'", "'IDREF'", "'IDREFS'", "'ENTITY'", "'ENTITIES'", "'NMTOKEN'", "'NMTOKENS'", "'<!ENTITY'", "'%'"
    };
    public static final int TYPE=12;
    public static final int CONTENTSPEC=16;
    public static final int T__42=42;
    public static final int ELEMENT=13;
    public static final int DefaultDecl=40;
    public static final int Digit=30;
    public static final int T__57=57;
    public static final int Apos=23;
    public static final int SemiColon=26;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int ENTITY=17;
    public static final int ATTLIST=10;
    public static final int TOKENIZEDTYPE=6;
    public static final int VALUE=18;
    public static final int AttValue=37;
    public static final int Letter=29;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int Comma=22;
    public static final int Dot=25;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int DECL=11;
    public static final int ML_COMMENT=19;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int EntityRef=38;
    public static final int Colon=21;
    public static final int T__56=56;
    public static final int At=20;
    public static final int STRINGTYPE=5;
    public static final int NameChar=32;
    public static final int DTD=4;
    public static final int T__58=58;
    public static final int T__44=44;
    public static final int RParen=28;
    public static final int Name=35;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int LParen=27;
    public static final int String=34;
    public static final int CharRef=39;
    public static final int OCCURRENCE=15;
    public static final int T__43=43;
    public static final int WhiteSpaceChar=33;
    public static final int EOF=-1;
    public static final int Reference=36;
    public static final int T__53=53;
    public static final int COMPONENT=14;
    public static final int Quot=24;
    public static final int ATTRIBUTE=9;
    public static final int T__60=60;
    public static final int NAME=8;
    public static final int Digits=31;
    public static final int Element=41;
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
    // DTD.g:151:1: dtd : ( markupdecl )* -> ^( DTD ( markupdecl )* ) ;
    public final DTDParser.dtd_return dtd() throws RecognitionException {
        DTDParser.dtd_return retval = new DTDParser.dtd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.markupdecl_return markupdecl1 = null;


        RewriteRuleSubtreeStream stream_markupdecl=new RewriteRuleSubtreeStream(adaptor,"rule markupdecl");
        try {
            // DTD.g:151:4: ( ( markupdecl )* -> ^( DTD ( markupdecl )* ) )
            // DTD.g:151:6: ( markupdecl )*
            {
            // DTD.g:151:6: ( markupdecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Element||LA1_0==50||LA1_0==60) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // DTD.g:151:6: markupdecl
            	    {
            	    pushFollow(FOLLOW_markupdecl_in_dtd549);
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
            // 152:3: -> ^( DTD ( markupdecl )* )
            {
                // DTD.g:152:6: ^( DTD ( markupdecl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DTD, "DTD"), root_1);

                // DTD.g:152:12: ( markupdecl )*
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
    // DTD.g:155:1: fragment markupdecl : ( elementDecl | attlistDecl | entityDecl );
    public final DTDParser.markupdecl_return markupdecl() throws RecognitionException {
        DTDParser.markupdecl_return retval = new DTDParser.markupdecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.elementDecl_return elementDecl2 = null;

        DTDParser.attlistDecl_return attlistDecl3 = null;

        DTDParser.entityDecl_return entityDecl4 = null;



        try {
            // DTD.g:156:11: ( elementDecl | attlistDecl | entityDecl )
            int alt2=3;
            switch ( input.LA(1) ) {
            case Element:
                {
                alt2=1;
                }
                break;
            case 50:
                {
                alt2=2;
                }
                break;
            case 60:
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
                    // DTD.g:156:13: elementDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementDecl_in_markupdecl571);
                    elementDecl2=elementDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementDecl2.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:156:27: attlistDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attlistDecl_in_markupdecl575);
                    attlistDecl3=attlistDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attlistDecl3.getTree());

                    }
                    break;
                case 3 :
                    // DTD.g:156:41: entityDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_entityDecl_in_markupdecl579);
                    entityDecl4=entityDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, entityDecl4.getTree());

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
    // DTD.g:158:1: elementDecl : Element Name contentSpec '>' -> ^( ELEMENT NAME[$Name.text] contentSpec ) ;
    public final DTDParser.elementDecl_return elementDecl() throws RecognitionException {
        DTDParser.elementDecl_return retval = new DTDParser.elementDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Element5=null;
        Token Name6=null;
        Token char_literal8=null;
        DTDParser.contentSpec_return contentSpec7 = null;


        Object Element5_tree=null;
        Object Name6_tree=null;
        Object char_literal8_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_Element=new RewriteRuleTokenStream(adaptor,"token Element");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_contentSpec=new RewriteRuleSubtreeStream(adaptor,"rule contentSpec");
        try {
            // DTD.g:158:12: ( Element Name contentSpec '>' -> ^( ELEMENT NAME[$Name.text] contentSpec ) )
            // DTD.g:158:14: Element Name contentSpec '>'
            {
            Element5=(Token)match(input,Element,FOLLOW_Element_in_elementDecl587); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Element.add(Element5);

            Name6=(Token)match(input,Name,FOLLOW_Name_in_elementDecl589); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name6);

            pushFollow(FOLLOW_contentSpec_in_elementDecl591);
            contentSpec7=contentSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_contentSpec.add(contentSpec7.getTree());
            char_literal8=(Token)match(input,42,FOLLOW_42_in_elementDecl593); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(char_literal8);



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
            // 159:3: -> ^( ELEMENT NAME[$Name.text] contentSpec )
            {
                // DTD.g:159:6: ^( ELEMENT NAME[$Name.text] contentSpec )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name6!=null?Name6.getText():null)));
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
    // DTD.g:162:1: fragment contentSpec : ( 'EMPTY' -> CONTENTSPEC[\"EMPTY\"] | 'ANY' -> CONTENTSPEC[\"ANY\"] | mixed | children );
    public final DTDParser.contentSpec_return contentSpec() throws RecognitionException {
        DTDParser.contentSpec_return retval = new DTDParser.contentSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal9=null;
        Token string_literal10=null;
        DTDParser.mixed_return mixed11 = null;

        DTDParser.children_return children12 = null;


        Object string_literal9_tree=null;
        Object string_literal10_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");

        try {
            // DTD.g:164:3: ( 'EMPTY' -> CONTENTSPEC[\"EMPTY\"] | 'ANY' -> CONTENTSPEC[\"ANY\"] | mixed | children )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt3=1;
                }
                break;
            case 44:
                {
                alt3=2;
                }
                break;
            case LParen:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==49) ) {
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
                    // DTD.g:164:5: 'EMPTY'
                    {
                    string_literal9=(Token)match(input,43,FOLLOW_43_in_contentSpec621); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(string_literal9);



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
                    // 164:13: -> CONTENTSPEC[\"EMPTY\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(CONTENTSPEC, "EMPTY"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:165:5: 'ANY'
                    {
                    string_literal10=(Token)match(input,44,FOLLOW_44_in_contentSpec632); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal10);



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
                    // 165:13: -> CONTENTSPEC[\"ANY\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(CONTENTSPEC, "ANY"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:166:5: mixed
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mixed_in_contentSpec645);
                    mixed11=mixed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mixed11.getTree());

                    }
                    break;
                case 4 :
                    // DTD.g:167:5: children
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_children_in_contentSpec652);
                    children12=children();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, children12.getTree());

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
    // DTD.g:170:1: fragment children : ( ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) );
    public final DTDParser.children_return children() throws RecognitionException {
        DTDParser.children_return retval = new DTDParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.choice_return choice13 = null;

        DTDParser.plural_return plural14 = null;

        DTDParser.seq_return seq15 = null;

        DTDParser.plural_return plural16 = null;


        RewriteRuleSubtreeStream stream_seq=new RewriteRuleSubtreeStream(adaptor,"rule seq");
        RewriteRuleSubtreeStream stream_choice=new RewriteRuleSubtreeStream(adaptor,"rule choice");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // DTD.g:172:1: ( ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) )
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
                    // DTD.g:172:3: ( choice )=> choice ( plural )?
                    {
                    pushFollow(FOLLOW_choice_in_children675);
                    choice13=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_choice.add(choice13.getTree());
                    // DTD.g:172:23: ( plural )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=45 && LA4_0<=47)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // DTD.g:172:23: plural
                            {
                            pushFollow(FOLLOW_plural_in_children678);
                            plural14=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural14.getTree());

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
                    // 172:31: -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                    {
                        // DTD.g:172:34: ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "choice"));
                        adaptor.addChild(root_1, stream_choice.nextTree());
                        // DTD.g:172:69: ( plural )?
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
                    // DTD.g:173:3: ( seq )=> seq ( plural )?
                    {
                    pushFollow(FOLLOW_seq_in_children704);
                    seq15=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_seq.add(seq15.getTree());
                    // DTD.g:173:16: ( plural )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=45 && LA5_0<=47)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // DTD.g:173:16: plural
                            {
                            pushFollow(FOLLOW_plural_in_children706);
                            plural16=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural16.getTree());

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
                    // 173:24: -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                    {
                        // DTD.g:173:27: ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "seq"));
                        adaptor.addChild(root_1, stream_seq.nextTree());
                        // DTD.g:173:55: ( plural )?
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
    // DTD.g:176:1: fragment cp : ( ( Name )=> Name ( plural )? -> ^( COMPONENT NAME[$Name.text] ( plural )? ) | ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) );
    public final DTDParser.cp_return cp() throws RecognitionException {
        DTDParser.cp_return retval = new DTDParser.cp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name17=null;
        DTDParser.plural_return plural18 = null;

        DTDParser.choice_return choice19 = null;

        DTDParser.plural_return plural20 = null;

        DTDParser.seq_return seq21 = null;

        DTDParser.plural_return plural22 = null;


        Object Name17_tree=null;
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_seq=new RewriteRuleSubtreeStream(adaptor,"rule seq");
        RewriteRuleSubtreeStream stream_choice=new RewriteRuleSubtreeStream(adaptor,"rule choice");
        RewriteRuleSubtreeStream stream_plural=new RewriteRuleSubtreeStream(adaptor,"rule plural");
        try {
            // DTD.g:178:1: ( ( Name )=> Name ( plural )? -> ^( COMPONENT NAME[$Name.text] ( plural )? ) | ( choice )=> choice ( plural )? -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? ) | ( seq )=> seq ( plural )? -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? ) )
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
                    // DTD.g:178:3: ( Name )=> Name ( plural )?
                    {
                    Name17=(Token)match(input,Name,FOLLOW_Name_in_cp740); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Name.add(Name17);

                    // DTD.g:178:19: ( plural )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=45 && LA7_0<=47)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // DTD.g:178:19: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp743);
                            plural18=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural18.getTree());

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
                    // 178:27: -> ^( COMPONENT NAME[$Name.text] ( plural )? )
                    {
                        // DTD.g:178:30: ^( COMPONENT NAME[$Name.text] ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name17!=null?Name17.getText():null)));
                        // DTD.g:178:59: ( plural )?
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
                    // DTD.g:179:4: ( choice )=> choice ( plural )?
                    {
                    pushFollow(FOLLOW_choice_in_cp767);
                    choice19=choice();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_choice.add(choice19.getTree());
                    // DTD.g:179:24: ( plural )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=45 && LA8_0<=47)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // DTD.g:179:24: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp770);
                            plural20=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural20.getTree());

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
                    // 179:32: -> ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                    {
                        // DTD.g:179:35: ^( COMPONENT TYPE[\"choice\"] choice ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "choice"));
                        adaptor.addChild(root_1, stream_choice.nextTree());
                        // DTD.g:179:69: ( plural )?
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
                    // DTD.g:180:4: ( seq )=> seq ( plural )?
                    {
                    pushFollow(FOLLOW_seq_in_cp796);
                    seq21=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_seq.add(seq21.getTree());
                    // DTD.g:180:18: ( plural )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=45 && LA9_0<=47)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // DTD.g:180:18: plural
                            {
                            pushFollow(FOLLOW_plural_in_cp799);
                            plural22=plural();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_plural.add(plural22.getTree());

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
                    // 180:26: -> ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                    {
                        // DTD.g:180:29: ^( COMPONENT TYPE[\"seq\"] seq ( plural )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "seq"));
                        adaptor.addChild(root_1, stream_seq.nextTree());
                        // DTD.g:180:57: ( plural )?
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
    // DTD.g:183:1: fragment plural : ( '?' -> OCCURRENCE[\"ZERO_OR_ONE\"] | '*' -> OCCURRENCE[\"ZERO_OR_MORE\"] | '+' -> OCCURRENCE[\"ONE_OR_MORE\"] );
    public final DTDParser.plural_return plural() throws RecognitionException {
        DTDParser.plural_return retval = new DTDParser.plural_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;

        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal25_tree=null;
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");

        try {
            // DTD.g:185:3: ( '?' -> OCCURRENCE[\"ZERO_OR_ONE\"] | '*' -> OCCURRENCE[\"ZERO_OR_MORE\"] | '+' -> OCCURRENCE[\"ONE_OR_MORE\"] )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt11=1;
                }
                break;
            case 46:
                {
                alt11=2;
                }
                break;
            case 47:
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
                    // DTD.g:185:5: '?'
                    {
                    char_literal23=(Token)match(input,45,FOLLOW_45_in_plural827); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal23);



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
                    // 185:9: -> OCCURRENCE[\"ZERO_OR_ONE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OCCURRENCE, "ZERO_OR_ONE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:186:5: '*'
                    {
                    char_literal24=(Token)match(input,46,FOLLOW_46_in_plural838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal24);



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
                    // 186:9: -> OCCURRENCE[\"ZERO_OR_MORE\"]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(OCCURRENCE, "ZERO_OR_MORE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:187:5: '+'
                    {
                    char_literal25=(Token)match(input,47,FOLLOW_47_in_plural849); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal25);



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
                    // 187:9: -> OCCURRENCE[\"ONE_OR_MORE\"]
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
    // DTD.g:191:1: fragment choice : LParen cp ( '|' cp )* RParen -> ( cp )+ ;
    public final DTDParser.choice_return choice() throws RecognitionException {
        DTDParser.choice_return retval = new DTDParser.choice_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen26=null;
        Token char_literal28=null;
        Token RParen30=null;
        DTDParser.cp_return cp27 = null;

        DTDParser.cp_return cp29 = null;


        Object LParen26_tree=null;
        Object char_literal28_tree=null;
        Object RParen30_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_cp=new RewriteRuleSubtreeStream(adaptor,"rule cp");
        try {
            // DTD.g:192:7: ( LParen cp ( '|' cp )* RParen -> ( cp )+ )
            // DTD.g:192:9: LParen cp ( '|' cp )* RParen
            {
            LParen26=(Token)match(input,LParen,FOLLOW_LParen_in_choice869); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen26);

            pushFollow(FOLLOW_cp_in_choice871);
            cp27=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cp.add(cp27.getTree());
            // DTD.g:192:19: ( '|' cp )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==48) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // DTD.g:192:20: '|' cp
            	    {
            	    char_literal28=(Token)match(input,48,FOLLOW_48_in_choice874); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal28);

            	    pushFollow(FOLLOW_cp_in_choice876);
            	    cp29=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cp.add(cp29.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RParen30=(Token)match(input,RParen,FOLLOW_RParen_in_choice880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen30);



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
            // 193:3: -> ( cp )+
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
    // DTD.g:196:1: fragment seq : ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen -> ( cp )+ ;
    public final DTDParser.seq_return seq() throws RecognitionException {
        DTDParser.seq_return retval = new DTDParser.seq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen31=null;
        Token Comma33=null;
        Token RParen35=null;
        DTDParser.cp_return cp32 = null;

        DTDParser.cp_return cp34 = null;


        Object LParen31_tree=null;
        Object Comma33_tree=null;
        Object RParen35_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_cp=new RewriteRuleSubtreeStream(adaptor,"rule cp");
        try {
            // DTD.g:197:4: ( ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen -> ( cp )+ )
            // DTD.g:197:6: ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen
            {
            LParen31=(Token)match(input,LParen,FOLLOW_LParen_in_seq909); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LParen.add(LParen31);

            pushFollow(FOLLOW_cp_in_seq911);
            cp32=cp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cp.add(cp32.getTree());
            // DTD.g:197:37: ( Comma cp )+
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
            	    // DTD.g:197:38: Comma cp
            	    {
            	    Comma33=(Token)match(input,Comma,FOLLOW_Comma_in_seq914); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Comma.add(Comma33);

            	    pushFollow(FOLLOW_cp_in_seq916);
            	    cp34=cp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cp.add(cp34.getTree());

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

            RParen35=(Token)match(input,RParen,FOLLOW_RParen_in_seq920); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RParen.add(RParen35);



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
            // 198:3: -> ( cp )+
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
    // DTD.g:201:1: fragment mixed : ( LParen '#PCDATA' ( '|' mixed_i )* RParen '*' -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* ) | LParen '#PCDATA' RParen -> ^( COMPONENT TYPE[\"pcdata\"] ) );
    public final DTDParser.mixed_return mixed() throws RecognitionException {
        DTDParser.mixed_return retval = new DTDParser.mixed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen36=null;
        Token string_literal37=null;
        Token char_literal38=null;
        Token RParen40=null;
        Token char_literal41=null;
        Token LParen42=null;
        Token string_literal43=null;
        Token RParen44=null;
        DTDParser.mixed_i_return mixed_i39 = null;


        Object LParen36_tree=null;
        Object string_literal37_tree=null;
        Object char_literal38_tree=null;
        Object RParen40_tree=null;
        Object char_literal41_tree=null;
        Object LParen42_tree=null;
        Object string_literal43_tree=null;
        Object RParen44_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_RParen=new RewriteRuleTokenStream(adaptor,"token RParen");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_LParen=new RewriteRuleTokenStream(adaptor,"token LParen");
        RewriteRuleSubtreeStream stream_mixed_i=new RewriteRuleSubtreeStream(adaptor,"rule mixed_i");
        try {
            // DTD.g:203:3: ( LParen '#PCDATA' ( '|' mixed_i )* RParen '*' -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* ) | LParen '#PCDATA' RParen -> ^( COMPONENT TYPE[\"pcdata\"] ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LParen) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==49) ) {
                    int LA15_2 = input.LA(3);

                    if ( (LA15_2==RParen) ) {
                        int LA15_3 = input.LA(4);

                        if ( (LA15_3==46) ) {
                            alt15=1;
                        }
                        else if ( (LA15_3==42) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA15_2==48) ) {
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
                    // DTD.g:203:5: LParen '#PCDATA' ( '|' mixed_i )* RParen '*'
                    {
                    LParen36=(Token)match(input,LParen,FOLLOW_LParen_in_mixed942); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen36);

                    string_literal37=(Token)match(input,49,FOLLOW_49_in_mixed944); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal37);

                    // DTD.g:203:22: ( '|' mixed_i )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==48) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // DTD.g:203:23: '|' mixed_i
                    	    {
                    	    char_literal38=(Token)match(input,48,FOLLOW_48_in_mixed947); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal38);

                    	    pushFollow(FOLLOW_mixed_i_in_mixed949);
                    	    mixed_i39=mixed_i();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_mixed_i.add(mixed_i39.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    RParen40=(Token)match(input,RParen,FOLLOW_RParen_in_mixed953); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen40);

                    char_literal41=(Token)match(input,46,FOLLOW_46_in_mixed955); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal41);



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
                    // 204:5: -> ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* )
                    {
                        // DTD.g:204:8: ^( COMPONENT TYPE[\"mixed\"] ( mixed_i )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPONENT, "COMPONENT"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(TYPE, "mixed"));
                        // DTD.g:204:34: ( mixed_i )*
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
                    // DTD.g:205:5: LParen '#PCDATA' RParen
                    {
                    LParen42=(Token)match(input,LParen,FOLLOW_LParen_in_mixed977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LParen.add(LParen42);

                    string_literal43=(Token)match(input,49,FOLLOW_49_in_mixed979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal43);

                    RParen44=(Token)match(input,RParen,FOLLOW_RParen_in_mixed981); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RParen.add(RParen44);



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
                    // 206:5: -> ^( COMPONENT TYPE[\"pcdata\"] )
                    {
                        // DTD.g:206:8: ^( COMPONENT TYPE[\"pcdata\"] )
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
    // DTD.g:209:1: mixed_i : Name -> NAME[$Name.text] ;
    public final DTDParser.mixed_i_return mixed_i() throws RecognitionException {
        DTDParser.mixed_i_return retval = new DTDParser.mixed_i_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name45=null;

        Object Name45_tree=null;
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");

        try {
            // DTD.g:210:3: ( Name -> NAME[$Name.text] )
            // DTD.g:210:5: Name
            {
            Name45=(Token)match(input,Name,FOLLOW_Name_in_mixed_i1010); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name45);



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
            // 210:10: -> NAME[$Name.text]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(NAME, (Name45!=null?Name45.getText():null)));

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
    // DTD.g:213:1: attlistDecl : '<!ATTLIST' Name ( attDef )* '>' -> ^( ATTLIST NAME[$Name.text] ( attDef )* ) ;
    public final DTDParser.attlistDecl_return attlistDecl() throws RecognitionException {
        DTDParser.attlistDecl_return retval = new DTDParser.attlistDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal46=null;
        Token Name47=null;
        Token char_literal49=null;
        DTDParser.attDef_return attDef48 = null;


        Object string_literal46_tree=null;
        Object Name47_tree=null;
        Object char_literal49_tree=null;
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_attDef=new RewriteRuleSubtreeStream(adaptor,"rule attDef");
        try {
            // DTD.g:213:12: ( '<!ATTLIST' Name ( attDef )* '>' -> ^( ATTLIST NAME[$Name.text] ( attDef )* ) )
            // DTD.g:213:14: '<!ATTLIST' Name ( attDef )* '>'
            {
            string_literal46=(Token)match(input,50,FOLLOW_50_in_attlistDecl1031); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(string_literal46);

            Name47=(Token)match(input,Name,FOLLOW_Name_in_attlistDecl1033); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name47);

            // DTD.g:213:31: ( attDef )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Name) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // DTD.g:213:31: attDef
            	    {
            	    pushFollow(FOLLOW_attDef_in_attlistDecl1035);
            	    attDef48=attDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attDef.add(attDef48.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            char_literal49=(Token)match(input,42,FOLLOW_42_in_attlistDecl1038); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(char_literal49);



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
            // 214:3: -> ^( ATTLIST NAME[$Name.text] ( attDef )* )
            {
                // DTD.g:214:6: ^( ATTLIST NAME[$Name.text] ( attDef )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTLIST, "ATTLIST"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name47!=null?Name47.getText():null)));
                // DTD.g:214:33: ( attDef )*
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
    // DTD.g:217:1: fragment attDef : Name attType DefaultDecl -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text] ) ;
    public final DTDParser.attDef_return attDef() throws RecognitionException {
        DTDParser.attDef_return retval = new DTDParser.attDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name50=null;
        Token DefaultDecl52=null;
        DTDParser.attType_return attType51 = null;


        Object Name50_tree=null;
        Object DefaultDecl52_tree=null;
        RewriteRuleTokenStream stream_DefaultDecl=new RewriteRuleTokenStream(adaptor,"token DefaultDecl");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleSubtreeStream stream_attType=new RewriteRuleSubtreeStream(adaptor,"rule attType");
        try {
            // DTD.g:218:7: ( Name attType DefaultDecl -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text] ) )
            // DTD.g:218:9: Name attType DefaultDecl
            {
            Name50=(Token)match(input,Name,FOLLOW_Name_in_attDef1064); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Name.add(Name50);

            pushFollow(FOLLOW_attType_in_attDef1066);
            attType51=attType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attType.add(attType51.getTree());
            DefaultDecl52=(Token)match(input,DefaultDecl,FOLLOW_DefaultDecl_in_attDef1068); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DefaultDecl.add(DefaultDecl52);



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
            // 219:3: -> ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text] )
            {
                // DTD.g:219:6: ^( ATTRIBUTE NAME[$Name.text] attType DECL[$DefaultDecl.text] )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name50!=null?Name50.getText():null)));
                adaptor.addChild(root_1, stream_attType.nextTree());
                adaptor.addChild(root_1, (Object)adaptor.create(DECL, (DefaultDecl52!=null?DefaultDecl52.getText():null)));

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
    // DTD.g:222:1: fragment attType : ( stringType -> STRINGTYPE[$stringType.text] | tokenizedType -> TOKENIZEDTYPE[$tokenizedType.text] | enumeratedType -> ENUMTYPE[$enumeratedType.text] );
    public final DTDParser.attType_return attType() throws RecognitionException {
        DTDParser.attType_return retval = new DTDParser.attType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.stringType_return stringType53 = null;

        DTDParser.tokenizedType_return tokenizedType54 = null;

        DTDParser.enumeratedType_return enumeratedType55 = null;


        RewriteRuleSubtreeStream stream_enumeratedType=new RewriteRuleSubtreeStream(adaptor,"rule enumeratedType");
        RewriteRuleSubtreeStream stream_tokenizedType=new RewriteRuleSubtreeStream(adaptor,"rule tokenizedType");
        RewriteRuleSubtreeStream stream_stringType=new RewriteRuleSubtreeStream(adaptor,"rule stringType");
        try {
            // DTD.g:224:3: ( stringType -> STRINGTYPE[$stringType.text] | tokenizedType -> TOKENIZEDTYPE[$tokenizedType.text] | enumeratedType -> ENUMTYPE[$enumeratedType.text] )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt17=1;
                }
                break;
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt17=2;
                }
                break;
            case LParen:
            case 51:
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
                    // DTD.g:224:5: stringType
                    {
                    pushFollow(FOLLOW_stringType_in_attType1100);
                    stringType53=stringType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_stringType.add(stringType53.getTree());


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
                    // 224:16: -> STRINGTYPE[$stringType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(STRINGTYPE, (stringType53!=null?input.toString(stringType53.start,stringType53.stop):null)));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:225:5: tokenizedType
                    {
                    pushFollow(FOLLOW_tokenizedType_in_attType1112);
                    tokenizedType54=tokenizedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tokenizedType.add(tokenizedType54.getTree());


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
                    // 225:19: -> TOKENIZEDTYPE[$tokenizedType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(TOKENIZEDTYPE, (tokenizedType54!=null?input.toString(tokenizedType54.start,tokenizedType54.stop):null)));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // DTD.g:226:5: enumeratedType
                    {
                    pushFollow(FOLLOW_enumeratedType_in_attType1124);
                    enumeratedType55=enumeratedType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_enumeratedType.add(enumeratedType55.getTree());


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
                    // 226:20: -> ENUMTYPE[$enumeratedType.text]
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(ENUMTYPE, (enumeratedType55!=null?input.toString(enumeratedType55.start,enumeratedType55.stop):null)));

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
    // DTD.g:229:1: fragment enumeration : LParen Name ( '|' Name )* RParen ;
    public final DTDParser.enumeration_return enumeration() throws RecognitionException {
        DTDParser.enumeration_return retval = new DTDParser.enumeration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen56=null;
        Token Name57=null;
        Token char_literal58=null;
        Token Name59=null;
        Token RParen60=null;

        Object LParen56_tree=null;
        Object Name57_tree=null;
        Object char_literal58_tree=null;
        Object Name59_tree=null;
        Object RParen60_tree=null;

        try {
            // DTD.g:230:12: ( LParen Name ( '|' Name )* RParen )
            // DTD.g:230:14: LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen56=(Token)match(input,LParen,FOLLOW_LParen_in_enumeration1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen56_tree = (Object)adaptor.create(LParen56);
            adaptor.addChild(root_0, LParen56_tree);
            }
            Name57=(Token)match(input,Name,FOLLOW_Name_in_enumeration1143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name57_tree = (Object)adaptor.create(Name57);
            adaptor.addChild(root_0, Name57_tree);
            }
            // DTD.g:230:26: ( '|' Name )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==48) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // DTD.g:230:27: '|' Name
            	    {
            	    char_literal58=(Token)match(input,48,FOLLOW_48_in_enumeration1146); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal58_tree = (Object)adaptor.create(char_literal58);
            	    adaptor.addChild(root_0, char_literal58_tree);
            	    }
            	    Name59=(Token)match(input,Name,FOLLOW_Name_in_enumeration1148); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name59_tree = (Object)adaptor.create(Name59);
            	    adaptor.addChild(root_0, Name59_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            RParen60=(Token)match(input,RParen,FOLLOW_RParen_in_enumeration1152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen60_tree = (Object)adaptor.create(RParen60);
            adaptor.addChild(root_0, RParen60_tree);
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
    // DTD.g:231:1: fragment enumeratedType : ( notationType | enumeration );
    public final DTDParser.enumeratedType_return enumeratedType() throws RecognitionException {
        DTDParser.enumeratedType_return retval = new DTDParser.enumeratedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DTDParser.notationType_return notationType61 = null;

        DTDParser.enumeration_return enumeration62 = null;



        try {
            // DTD.g:232:15: ( notationType | enumeration )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==51) ) {
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
                    // DTD.g:232:17: notationType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_notationType_in_enumeratedType1160);
                    notationType61=notationType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notationType61.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:232:32: enumeration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeration_in_enumeratedType1164);
                    enumeration62=enumeration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumeration62.getTree());

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
    // DTD.g:233:1: fragment notationType : 'NOTATION' LParen Name ( '|' Name )* RParen ;
    public final DTDParser.notationType_return notationType() throws RecognitionException {
        DTDParser.notationType_return retval = new DTDParser.notationType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal63=null;
        Token LParen64=null;
        Token Name65=null;
        Token char_literal66=null;
        Token Name67=null;
        Token RParen68=null;

        Object string_literal63_tree=null;
        Object LParen64_tree=null;
        Object Name65_tree=null;
        Object char_literal66_tree=null;
        Object Name67_tree=null;
        Object RParen68_tree=null;

        try {
            // DTD.g:234:13: ( 'NOTATION' LParen Name ( '|' Name )* RParen )
            // DTD.g:234:15: 'NOTATION' LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            string_literal63=(Token)match(input,51,FOLLOW_51_in_notationType1172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal63_tree = (Object)adaptor.create(string_literal63);
            adaptor.addChild(root_0, string_literal63_tree);
            }
            LParen64=(Token)match(input,LParen,FOLLOW_LParen_in_notationType1174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LParen64_tree = (Object)adaptor.create(LParen64);
            adaptor.addChild(root_0, LParen64_tree);
            }
            Name65=(Token)match(input,Name,FOLLOW_Name_in_notationType1176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Name65_tree = (Object)adaptor.create(Name65);
            adaptor.addChild(root_0, Name65_tree);
            }
            // DTD.g:234:38: ( '|' Name )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==48) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // DTD.g:234:39: '|' Name
            	    {
            	    char_literal66=(Token)match(input,48,FOLLOW_48_in_notationType1179); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal66_tree = (Object)adaptor.create(char_literal66);
            	    adaptor.addChild(root_0, char_literal66_tree);
            	    }
            	    Name67=(Token)match(input,Name,FOLLOW_Name_in_notationType1181); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Name67_tree = (Object)adaptor.create(Name67);
            	    adaptor.addChild(root_0, Name67_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            RParen68=(Token)match(input,RParen,FOLLOW_RParen_in_notationType1185); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RParen68_tree = (Object)adaptor.create(RParen68);
            adaptor.addChild(root_0, RParen68_tree);
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
    // DTD.g:236:1: fragment stringType : 'CDATA' ;
    public final DTDParser.stringType_return stringType() throws RecognitionException {
        DTDParser.stringType_return retval = new DTDParser.stringType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal69=null;

        Object string_literal69_tree=null;

        try {
            // DTD.g:237:11: ( 'CDATA' )
            // DTD.g:237:13: 'CDATA'
            {
            root_0 = (Object)adaptor.nil();

            string_literal69=(Token)match(input,52,FOLLOW_52_in_stringType1194); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal69_tree = (Object)adaptor.create(string_literal69);
            adaptor.addChild(root_0, string_literal69_tree);
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
    // DTD.g:240:1: fragment tokenizedType : ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' );
    public final DTDParser.tokenizedType_return tokenizedType() throws RecognitionException {
        DTDParser.tokenizedType_return retval = new DTDParser.tokenizedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set70=null;

        Object set70_tree=null;

        try {
            // DTD.g:242:3: ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' )
            // DTD.g:
            {
            root_0 = (Object)adaptor.nil();

            set70=(Token)input.LT(1);
            if ( (input.LA(1)>=53 && input.LA(1)<=59) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set70));
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

    public static class entityDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "entityDecl"
    // DTD.g:246:1: entityDecl : ( '<!ENTITY' Name String '>' -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] ) | '<!ENTITY' '%' Name String '>' -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] ) );
    public final DTDParser.entityDecl_return entityDecl() throws RecognitionException {
        DTDParser.entityDecl_return retval = new DTDParser.entityDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal71=null;
        Token Name72=null;
        Token String73=null;
        Token char_literal74=null;
        Token string_literal75=null;
        Token char_literal76=null;
        Token Name77=null;
        Token String78=null;
        Token char_literal79=null;

        Object string_literal71_tree=null;
        Object Name72_tree=null;
        Object String73_tree=null;
        Object char_literal74_tree=null;
        Object string_literal75_tree=null;
        Object char_literal76_tree=null;
        Object Name77_tree=null;
        Object String78_tree=null;
        Object char_literal79_tree=null;
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_Name=new RewriteRuleTokenStream(adaptor,"token Name");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");

        try {
            // DTD.g:247:3: ( '<!ENTITY' Name String '>' -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] ) | '<!ENTITY' '%' Name String '>' -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==60) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==Name) ) {
                    alt21=1;
                }
                else if ( (LA21_1==61) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // DTD.g:247:5: '<!ENTITY' Name String '>'
                    {
                    string_literal71=(Token)match(input,60,FOLLOW_60_in_entityDecl1246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(string_literal71);

                    Name72=(Token)match(input,Name,FOLLOW_Name_in_entityDecl1248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Name.add(Name72);

                    String73=(Token)match(input,String,FOLLOW_String_in_entityDecl1250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_String.add(String73);

                    char_literal74=(Token)match(input,42,FOLLOW_42_in_entityDecl1252); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal74);



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
                    // 247:32: -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] )
                    {
                        // DTD.g:247:35: ^( ENTITY NAME[$Name.text] VALUE[$String.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENTITY, "ENTITY"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name72!=null?Name72.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(VALUE, (String73!=null?String73.getText():null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // DTD.g:248:5: '<!ENTITY' '%' Name String '>'
                    {
                    string_literal75=(Token)match(input,60,FOLLOW_60_in_entityDecl1270); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(string_literal75);

                    char_literal76=(Token)match(input,61,FOLLOW_61_in_entityDecl1272); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal76);

                    Name77=(Token)match(input,Name,FOLLOW_Name_in_entityDecl1274); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Name.add(Name77);

                    String78=(Token)match(input,String,FOLLOW_String_in_entityDecl1276); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_String.add(String78);

                    char_literal79=(Token)match(input,42,FOLLOW_42_in_entityDecl1278); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal79);



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
                    // 248:36: -> ^( ENTITY NAME[$Name.text] VALUE[$String.text] )
                    {
                        // DTD.g:248:39: ^( ENTITY NAME[$Name.text] VALUE[$String.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENTITY, "ENTITY"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(NAME, (Name77!=null?Name77.getText():null)));
                        adaptor.addChild(root_1, (Object)adaptor.create(VALUE, (String78!=null?String78.getText():null)));

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
    // $ANTLR end "entityDecl"

    // $ANTLR start synpred1_DTD
    public final void synpred1_DTD_fragment() throws RecognitionException {   
        // DTD.g:172:3: ( choice )
        // DTD.g:172:4: choice
        {
        pushFollow(FOLLOW_choice_in_synpred1_DTD670);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_DTD

    // $ANTLR start synpred2_DTD
    public final void synpred2_DTD_fragment() throws RecognitionException {   
        // DTD.g:173:3: ( seq )
        // DTD.g:173:4: seq
        {
        pushFollow(FOLLOW_seq_in_synpred2_DTD699);
        seq();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_DTD

    // $ANTLR start synpred3_DTD
    public final void synpred3_DTD_fragment() throws RecognitionException {   
        // DTD.g:178:3: ( Name )
        // DTD.g:178:4: Name
        {
        match(input,Name,FOLLOW_Name_in_synpred3_DTD735); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_DTD

    // $ANTLR start synpred4_DTD
    public final void synpred4_DTD_fragment() throws RecognitionException {   
        // DTD.g:179:4: ( choice )
        // DTD.g:179:5: choice
        {
        pushFollow(FOLLOW_choice_in_synpred4_DTD762);
        choice();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_DTD

    // $ANTLR start synpred5_DTD
    public final void synpred5_DTD_fragment() throws RecognitionException {   
        // DTD.g:180:4: ( seq )
        // DTD.g:180:5: seq
        {
        pushFollow(FOLLOW_seq_in_synpred5_DTD791);
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


 

    public static final BitSet FOLLOW_markupdecl_in_dtd549 = new BitSet(new long[]{0x1004020000000002L});
    public static final BitSet FOLLOW_elementDecl_in_markupdecl571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attlistDecl_in_markupdecl575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityDecl_in_markupdecl579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Element_in_elementDecl587 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_elementDecl589 = new BitSet(new long[]{0x0000180008000000L});
    public static final BitSet FOLLOW_contentSpec_in_elementDecl591 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_elementDecl593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_contentSpec621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_contentSpec632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mixed_in_contentSpec645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_children_in_contentSpec652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_children675 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_plural_in_children678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_children704 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_plural_in_children706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_cp740 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_plural_in_cp743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_cp767 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_plural_in_cp770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_cp796 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_plural_in_cp799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_plural827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_plural838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_plural849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_choice869 = new BitSet(new long[]{0x0000180808000000L});
    public static final BitSet FOLLOW_cp_in_choice871 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_48_in_choice874 = new BitSet(new long[]{0x0000180808000000L});
    public static final BitSet FOLLOW_cp_in_choice876 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_RParen_in_choice880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_seq909 = new BitSet(new long[]{0x0000180808000000L});
    public static final BitSet FOLLOW_cp_in_seq911 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Comma_in_seq914 = new BitSet(new long[]{0x0000180808000000L});
    public static final BitSet FOLLOW_cp_in_seq916 = new BitSet(new long[]{0x0000000010400000L});
    public static final BitSet FOLLOW_RParen_in_seq920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed942 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_mixed944 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_48_in_mixed947 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_mixed_i_in_mixed949 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_RParen_in_mixed953 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_mixed955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed977 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_mixed979 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_RParen_in_mixed981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_mixed_i1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_attlistDecl1031 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_attlistDecl1033 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_attDef_in_attlistDecl1035 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_42_in_attlistDecl1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_attDef1064 = new BitSet(new long[]{0x0FF8000008000000L});
    public static final BitSet FOLLOW_attType_in_attDef1066 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_DefaultDecl_in_attDef1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_attType1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenizedType_in_attType1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeratedType_in_attType1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_enumeration1141 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_enumeration1143 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_48_in_enumeration1146 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_enumeration1148 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_RParen_in_enumeration1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notationType_in_enumeratedType1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_enumeratedType1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_notationType1172 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_LParen_in_notationType1174 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_notationType1176 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_48_in_notationType1179 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_notationType1181 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_RParen_in_notationType1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_stringType1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tokenizedType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_entityDecl1246 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_entityDecl1248 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_String_in_entityDecl1250 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_entityDecl1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_entityDecl1270 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_entityDecl1272 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Name_in_entityDecl1274 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_String_in_entityDecl1276 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_entityDecl1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred1_DTD670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred2_DTD699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_synpred3_DTD735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred4_DTD762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred5_DTD791 = new BitSet(new long[]{0x0000000000000002L});

}
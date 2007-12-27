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
// $ANTLR 3.0.1 DTD.g 2007-09-13 13:36:51

//--------------------------------------------------
// Xerial -- Transactional XML Database System      
// 
// DTDParser.g
// Since  2007/07/25 11:40:17
// 
//--------------------------------------------------
package org.xerial.util.xml.dtd;
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
    public static final int SemiColon=13;
    public static final int RParen=15;
    public static final int CharRef=26;
    public static final int DefaultDecl=27;
    public static final int At=7;
    public static final int Apos=10;
    public static final int LParen=14;
    public static final int NUMBER=4;
    public static final int NameChar=19;
    public static final int Colon=8;
    public static final int Digit=17;
    public static final int EOF=-1;
    public static final int AttValue=24;
    public static final int EntityRef=25;
    public static final int StringLiteral=21;
    public static final int ML_COMMENT=6;
    public static final int Digits=18;
    public static final int WhiteSpaceChar=20;
    public static final int Name=22;
    public static final int Dot=12;
    public static final int Reference=23;
    public static final int Comma=9;
    public static final int Letter=16;
    public static final int Quot=11;
    public static final int Element=28;
    public static final int STRING=5;

        public DTDParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[27+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "DTD.g"; }


    public static class integerLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start integerLiteral
    // DTD.g:113:1: integerLiteral : Digits ;
    public final integerLiteral_return integerLiteral() throws RecognitionException {
        integerLiteral_return retval = new integerLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Digits1=null;

        Object Digits1_tree=null;

        try {
            // DTD.g:113:15: ( Digits )
            // DTD.g:113:17: Digits
            {
            root_0 = (Object)adaptor.nil();

            Digits1=(Token)input.LT(1);
            match(input,Digits,FOLLOW_Digits_in_integerLiteral485); if (failed) return retval;
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
    // DTD.g:114:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );
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
            // DTD.g:114:15: ( Dot Digits | Digits Dot Digits )
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
                    new NoViableAltException("114:1: decimalLiteral : ( Dot Digits | Digits Dot Digits );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // DTD.g:114:17: Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Dot2=(Token)input.LT(1);
                    match(input,Dot,FOLLOW_Dot_in_decimalLiteral491); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Dot2_tree = (Object)adaptor.create(Dot2);
                    adaptor.addChild(root_0, Dot2_tree);
                    }
                    Digits3=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral493); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Digits3_tree = (Object)adaptor.create(Digits3);
                    adaptor.addChild(root_0, Digits3_tree);
                    }

                    }
                    break;
                case 2 :
                    // DTD.g:114:29: Digits Dot Digits
                    {
                    root_0 = (Object)adaptor.nil();

                    Digits4=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral496); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Digits4_tree = (Object)adaptor.create(Digits4);
                    adaptor.addChild(root_0, Digits4_tree);
                    }
                    Dot5=(Token)input.LT(1);
                    match(input,Dot,FOLLOW_Dot_in_decimalLiteral498); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Dot5_tree = (Object)adaptor.create(Dot5);
                    adaptor.addChild(root_0, Dot5_tree);
                    }
                    Digits6=(Token)input.LT(1);
                    match(input,Digits,FOLLOW_Digits_in_decimalLiteral500); if (failed) return retval;
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
    // DTD.g:116:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );
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
            // DTD.g:116:8: ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) )
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
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("116:1: literal : ( | numericLiteral -> ^( NUMBER numericLiteral ) | StringLiteral -> ^( STRING StringLiteral ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // DTD.g:117:2: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // DTD.g:117:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal511);
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
                    // 117:19: -> ^( NUMBER numericLiteral )
                    {
                        // DTD.g:117:22: ^( NUMBER numericLiteral )
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
                    // DTD.g:118:4: StringLiteral
                    {
                    StringLiteral8=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal524); if (failed) return retval;
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
                    // 118:18: -> ^( STRING StringLiteral )
                    {
                        // DTD.g:118:21: ^( STRING StringLiteral )
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
    // DTD.g:121:1: numericLiteral : ( integerLiteral | decimalLiteral );
    public final numericLiteral_return numericLiteral() throws RecognitionException {
        numericLiteral_return retval = new numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        integerLiteral_return integerLiteral9 = null;

        decimalLiteral_return decimalLiteral10 = null;



        try {
            // DTD.g:122:2: ( integerLiteral | decimalLiteral )
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
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("121:1: numericLiteral : ( integerLiteral | decimalLiteral );", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==Dot) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("121:1: numericLiteral : ( integerLiteral | decimalLiteral );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // DTD.g:122:4: integerLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_integerLiteral_in_numericLiteral544);
                    integerLiteral9=integerLiteral();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, integerLiteral9.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:123:4: decimalLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decimalLiteral_in_numericLiteral550);
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

    public static class dtd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start dtd
    // DTD.g:127:1: dtd : ( markupdecl )* ;
    public final dtd_return dtd() throws RecognitionException {
        dtd_return retval = new dtd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        markupdecl_return markupdecl11 = null;



        try {
            // DTD.g:127:4: ( ( markupdecl )* )
            // DTD.g:127:6: ( markupdecl )*
            {
            root_0 = (Object)adaptor.nil();

            // DTD.g:127:6: ( markupdecl )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Element||LA4_0==37) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // DTD.g:127:6: markupdecl
            	    {
            	    pushFollow(FOLLOW_markupdecl_in_dtd561);
            	    markupdecl11=markupdecl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, markupdecl11.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end dtd

    public static class markupdecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start markupdecl
    // DTD.g:129:1: markupdecl : ( elementDecl | attlistDecl );
    public final markupdecl_return markupdecl() throws RecognitionException {
        markupdecl_return retval = new markupdecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        elementDecl_return elementDecl12 = null;

        attlistDecl_return attlistDecl13 = null;



        try {
            // DTD.g:129:11: ( elementDecl | attlistDecl )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Element) ) {
                alt5=1;
            }
            else if ( (LA5_0==37) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("129:1: markupdecl : ( elementDecl | attlistDecl );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // DTD.g:129:13: elementDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementDecl_in_markupdecl569);
                    elementDecl12=elementDecl();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, elementDecl12.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:129:27: attlistDecl
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_attlistDecl_in_markupdecl573);
                    attlistDecl13=attlistDecl();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, attlistDecl13.getTree());

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
    // $ANTLR end markupdecl

    public static class elementDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start elementDecl
    // DTD.g:132:1: elementDecl : Element Name contentSpec '>' ;
    public final elementDecl_return elementDecl() throws RecognitionException {
        elementDecl_return retval = new elementDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Element14=null;
        Token Name15=null;
        Token char_literal17=null;
        contentSpec_return contentSpec16 = null;


        Object Element14_tree=null;
        Object Name15_tree=null;
        Object char_literal17_tree=null;

        try {
            // DTD.g:132:12: ( Element Name contentSpec '>' )
            // DTD.g:132:14: Element Name contentSpec '>'
            {
            root_0 = (Object)adaptor.nil();

            Element14=(Token)input.LT(1);
            match(input,Element,FOLLOW_Element_in_elementDecl581); if (failed) return retval;
            if ( backtracking==0 ) {
            Element14_tree = (Object)adaptor.create(Element14);
            adaptor.addChild(root_0, Element14_tree);
            }
            Name15=(Token)input.LT(1);
            match(input,Name,FOLLOW_Name_in_elementDecl583); if (failed) return retval;
            if ( backtracking==0 ) {
            Name15_tree = (Object)adaptor.create(Name15);
            adaptor.addChild(root_0, Name15_tree);
            }
            pushFollow(FOLLOW_contentSpec_in_elementDecl585);
            contentSpec16=contentSpec();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, contentSpec16.getTree());
            char_literal17=(Token)input.LT(1);
            match(input,29,FOLLOW_29_in_elementDecl587); if (failed) return retval;
            if ( backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
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
    // $ANTLR end elementDecl

    public static class contentSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start contentSpec
    // DTD.g:135:1: contentSpec : ( 'EMPTY' | 'ANY' | mixed | children );
    public final contentSpec_return contentSpec() throws RecognitionException {
        contentSpec_return retval = new contentSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal18=null;
        Token string_literal19=null;
        mixed_return mixed20 = null;

        children_return children21 = null;


        Object string_literal18_tree=null;
        Object string_literal19_tree=null;

        try {
            // DTD.g:135:12: ( 'EMPTY' | 'ANY' | mixed | children )
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
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("135:1: contentSpec : ( 'EMPTY' | 'ANY' | mixed | children );", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("135:1: contentSpec : ( 'EMPTY' | 'ANY' | mixed | children );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // DTD.g:135:14: 'EMPTY'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal18=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_contentSpec597); if (failed) return retval;
                    if ( backtracking==0 ) {
                    string_literal18_tree = (Object)adaptor.create(string_literal18);
                    adaptor.addChild(root_0, string_literal18_tree);
                    }

                    }
                    break;
                case 2 :
                    // DTD.g:135:24: 'ANY'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal19=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_contentSpec601); if (failed) return retval;
                    if ( backtracking==0 ) {
                    string_literal19_tree = (Object)adaptor.create(string_literal19);
                    adaptor.addChild(root_0, string_literal19_tree);
                    }

                    }
                    break;
                case 3 :
                    // DTD.g:135:32: mixed
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mixed_in_contentSpec605);
                    mixed20=mixed();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, mixed20.getTree());

                    }
                    break;
                case 4 :
                    // DTD.g:135:40: children
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_children_in_contentSpec609);
                    children21=children();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, children21.getTree());

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
    // $ANTLR end contentSpec

    public static class children_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start children
    // DTD.g:138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );
    public final children_return children() throws RecognitionException {
        children_return retval = new children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set23=null;
        Token set25=null;
        choice_return choice22 = null;

        seq_return seq24 = null;


        Object set23_tree=null;
        Object set25_tree=null;

        try {
            // DTD.g:139:1: ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LParen) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==Name) ) {
                    int LA9_2 = input.LA(3);

                    if ( ((LA9_2>=32 && LA9_2<=34)) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==35) && (synpred1())) {
                            alt9=1;
                        }
                        else if ( (LA9_4==RParen) && (synpred1())) {
                            alt9=1;
                        }
                        else if ( (LA9_4==Comma) && (synpred2())) {
                            alt9=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA9_2==Comma) && (synpred2())) {
                        alt9=2;
                    }
                    else if ( (LA9_2==35) && (synpred1())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==RParen) && (synpred1())) {
                        alt9=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 9, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA9_1==LParen) ) {
                    int LA9_3 = input.LA(3);

                    if ( (synpred1()) ) {
                        alt9=1;
                    }
                    else if ( (synpred2()) ) {
                        alt9=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("138:1: children : ( ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // DTD.g:139:3: ( choice )=> choice ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_choice_in_children628);
                    choice22=choice();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, choice22.getTree());
                    // DTD.g:139:23: ( '?' | '*' | '+' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=32 && LA7_0<=34)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // DTD.g:
                            {
                            set23=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set23));
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_children631);    throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // DTD.g:140:3: ( seq )=> seq ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_seq_in_children652);
                    seq24=seq();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, seq24.getTree());
                    // DTD.g:140:16: ( '?' | '*' | '+' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=32 && LA8_0<=34)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // DTD.g:
                            {
                            set25=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set25));
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_children654);    throw mse;
                            }


                            }
                            break;

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
    // $ANTLR end children

    public static class cp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cp
    // DTD.g:143:1: cp : ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );
    public final cp_return cp() throws RecognitionException {
        cp_return retval = new cp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name26=null;
        Token set27=null;
        Token set29=null;
        Token set31=null;
        choice_return choice28 = null;

        seq_return seq30 = null;


        Object Name26_tree=null;
        Object set27_tree=null;
        Object set29_tree=null;
        Object set31_tree=null;

        try {
            // DTD.g:144:1: ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Name) && (synpred3())) {
                alt13=1;
            }
            else if ( (LA13_0==LParen) ) {
                int LA13_2 = input.LA(2);

                if ( (synpred4()) ) {
                    alt13=2;
                }
                else if ( (synpred5()) ) {
                    alt13=3;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("143:1: cp : ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("143:1: cp : ( ( Name )=> Name ( '?' | '*' | '+' )? | ( choice )=> choice ( '?' | '*' | '+' )? | ( seq )=> seq ( '?' | '*' | '+' )? );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // DTD.g:144:3: ( Name )=> Name ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    Name26=(Token)input.LT(1);
                    match(input,Name,FOLLOW_Name_in_cp682); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Name26_tree = (Object)adaptor.create(Name26);
                    adaptor.addChild(root_0, Name26_tree);
                    }
                    // DTD.g:144:19: ( '?' | '*' | '+' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=32 && LA10_0<=34)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // DTD.g:
                            {
                            set27=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set27));
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_cp685);    throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // DTD.g:145:4: ( choice )=> choice ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_choice_in_cp707);
                    choice28=choice();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, choice28.getTree());
                    // DTD.g:145:24: ( '?' | '*' | '+' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=32 && LA11_0<=34)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // DTD.g:
                            {
                            set29=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set29));
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_cp710);    throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // DTD.g:146:4: ( seq )=> seq ( '?' | '*' | '+' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_seq_in_cp732);
                    seq30=seq();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, seq30.getTree());
                    // DTD.g:146:18: ( '?' | '*' | '+' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=32 && LA12_0<=34)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // DTD.g:
                            {
                            set31=(Token)input.LT(1);
                            if ( (input.LA(1)>=32 && input.LA(1)<=34) ) {
                                input.consume();
                                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set31));
                                errorRecovery=false;failed=false;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_cp735);    throw mse;
                            }


                            }
                            break;

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
    // $ANTLR end cp

    public static class choice_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start choice
    // DTD.g:149:1: choice : LParen cp ( '|' cp )* RParen ;
    public final choice_return choice() throws RecognitionException {
        choice_return retval = new choice_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen32=null;
        Token char_literal34=null;
        Token RParen36=null;
        cp_return cp33 = null;

        cp_return cp35 = null;


        Object LParen32_tree=null;
        Object char_literal34_tree=null;
        Object RParen36_tree=null;

        try {
            // DTD.g:149:7: ( LParen cp ( '|' cp )* RParen )
            // DTD.g:149:9: LParen cp ( '|' cp )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen32=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_choice754); if (failed) return retval;
            if ( backtracking==0 ) {
            LParen32_tree = (Object)adaptor.create(LParen32);
            adaptor.addChild(root_0, LParen32_tree);
            }
            pushFollow(FOLLOW_cp_in_choice756);
            cp33=cp();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, cp33.getTree());
            // DTD.g:149:19: ( '|' cp )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==35) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // DTD.g:149:20: '|' cp
            	    {
            	    char_literal34=(Token)input.LT(1);
            	    match(input,35,FOLLOW_35_in_choice759); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    char_literal34_tree = (Object)adaptor.create(char_literal34);
            	    adaptor.addChild(root_0, char_literal34_tree);
            	    }
            	    pushFollow(FOLLOW_cp_in_choice761);
            	    cp35=cp();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, cp35.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RParen36=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_choice765); if (failed) return retval;
            if ( backtracking==0 ) {
            RParen36_tree = (Object)adaptor.create(RParen36);
            adaptor.addChild(root_0, RParen36_tree);
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
    // $ANTLR end choice

    public static class seq_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start seq
    // DTD.g:152:1: seq : ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen ;
    public final seq_return seq() throws RecognitionException {
        seq_return retval = new seq_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LParen37=null;
        Token Comma39=null;
        Token RParen41=null;
        cp_return cp38 = null;

        cp_return cp40 = null;


        Object LParen37_tree=null;
        Object Comma39_tree=null;
        Object RParen41_tree=null;

        try {
            // DTD.g:152:4: ( ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen )
            // DTD.g:152:6: ( LParen cp Comma )=> LParen cp ( Comma cp )+ RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen37=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_seq785); if (failed) return retval;
            if ( backtracking==0 ) {
            LParen37_tree = (Object)adaptor.create(LParen37);
            adaptor.addChild(root_0, LParen37_tree);
            }
            pushFollow(FOLLOW_cp_in_seq787);
            cp38=cp();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, cp38.getTree());
            // DTD.g:152:37: ( Comma cp )+
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
            	    // DTD.g:152:38: Comma cp
            	    {
            	    Comma39=(Token)input.LT(1);
            	    match(input,Comma,FOLLOW_Comma_in_seq790); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    Comma39_tree = (Object)adaptor.create(Comma39);
            	    adaptor.addChild(root_0, Comma39_tree);
            	    }
            	    pushFollow(FOLLOW_cp_in_seq792);
            	    cp40=cp();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, cp40.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            RParen41=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_seq796); if (failed) return retval;
            if ( backtracking==0 ) {
            RParen41_tree = (Object)adaptor.create(RParen41);
            adaptor.addChild(root_0, RParen41_tree);
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
    // $ANTLR end seq

    public static class mixed_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start mixed
    // DTD.g:155:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );
    public final mixed_return mixed() throws RecognitionException {
        mixed_return retval = new mixed_return();
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
            // DTD.g:155:6: ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen )
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
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("155:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );", 17, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA17_2==35) ) {
                        alt17=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("155:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("155:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("155:1: mixed : ( LParen '#PCDATA' ( '|' Name )* RParen '*' | LParen '#PCDATA' RParen );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // DTD.g:155:8: LParen '#PCDATA' ( '|' Name )* RParen '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    LParen42=(Token)input.LT(1);
                    match(input,LParen,FOLLOW_LParen_in_mixed806); if (failed) return retval;
                    if ( backtracking==0 ) {
                    LParen42_tree = (Object)adaptor.create(LParen42);
                    adaptor.addChild(root_0, LParen42_tree);
                    }
                    string_literal43=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_mixed808); if (failed) return retval;
                    if ( backtracking==0 ) {
                    string_literal43_tree = (Object)adaptor.create(string_literal43);
                    adaptor.addChild(root_0, string_literal43_tree);
                    }
                    // DTD.g:155:25: ( '|' Name )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==35) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // DTD.g:155:26: '|' Name
                    	    {
                    	    char_literal44=(Token)input.LT(1);
                    	    match(input,35,FOLLOW_35_in_mixed811); if (failed) return retval;
                    	    if ( backtracking==0 ) {
                    	    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    	    adaptor.addChild(root_0, char_literal44_tree);
                    	    }
                    	    Name45=(Token)input.LT(1);
                    	    match(input,Name,FOLLOW_Name_in_mixed813); if (failed) return retval;
                    	    if ( backtracking==0 ) {
                    	    Name45_tree = (Object)adaptor.create(Name45);
                    	    adaptor.addChild(root_0, Name45_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    RParen46=(Token)input.LT(1);
                    match(input,RParen,FOLLOW_RParen_in_mixed817); if (failed) return retval;
                    if ( backtracking==0 ) {
                    RParen46_tree = (Object)adaptor.create(RParen46);
                    adaptor.addChild(root_0, RParen46_tree);
                    }
                    char_literal47=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_mixed819); if (failed) return retval;
                    if ( backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }

                    }
                    break;
                case 2 :
                    // DTD.g:156:5: LParen '#PCDATA' RParen
                    {
                    root_0 = (Object)adaptor.nil();

                    LParen48=(Token)input.LT(1);
                    match(input,LParen,FOLLOW_LParen_in_mixed826); if (failed) return retval;
                    if ( backtracking==0 ) {
                    LParen48_tree = (Object)adaptor.create(LParen48);
                    adaptor.addChild(root_0, LParen48_tree);
                    }
                    string_literal49=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_mixed828); if (failed) return retval;
                    if ( backtracking==0 ) {
                    string_literal49_tree = (Object)adaptor.create(string_literal49);
                    adaptor.addChild(root_0, string_literal49_tree);
                    }
                    RParen50=(Token)input.LT(1);
                    match(input,RParen,FOLLOW_RParen_in_mixed830); if (failed) return retval;
                    if ( backtracking==0 ) {
                    RParen50_tree = (Object)adaptor.create(RParen50);
                    adaptor.addChild(root_0, RParen50_tree);
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
    // $ANTLR end mixed

    public static class attlistDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attlistDecl
    // DTD.g:159:1: attlistDecl : '<!ATTLIST' Name ( attDef )* '>' ;
    public final attlistDecl_return attlistDecl() throws RecognitionException {
        attlistDecl_return retval = new attlistDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal51=null;
        Token Name52=null;
        Token char_literal54=null;
        attDef_return attDef53 = null;


        Object string_literal51_tree=null;
        Object Name52_tree=null;
        Object char_literal54_tree=null;

        try {
            // DTD.g:159:12: ( '<!ATTLIST' Name ( attDef )* '>' )
            // DTD.g:159:14: '<!ATTLIST' Name ( attDef )* '>'
            {
            root_0 = (Object)adaptor.nil();

            string_literal51=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_attlistDecl842); if (failed) return retval;
            if ( backtracking==0 ) {
            string_literal51_tree = (Object)adaptor.create(string_literal51);
            adaptor.addChild(root_0, string_literal51_tree);
            }
            Name52=(Token)input.LT(1);
            match(input,Name,FOLLOW_Name_in_attlistDecl844); if (failed) return retval;
            if ( backtracking==0 ) {
            Name52_tree = (Object)adaptor.create(Name52);
            adaptor.addChild(root_0, Name52_tree);
            }
            // DTD.g:159:31: ( attDef )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Name) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // DTD.g:159:31: attDef
            	    {
            	    pushFollow(FOLLOW_attDef_in_attlistDecl846);
            	    attDef53=attDef();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, attDef53.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            char_literal54=(Token)input.LT(1);
            match(input,29,FOLLOW_29_in_attlistDecl849); if (failed) return retval;
            if ( backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
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
    // $ANTLR end attlistDecl

    public static class attDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attDef
    // DTD.g:162:1: attDef : Name attType DefaultDecl ;
    public final attDef_return attDef() throws RecognitionException {
        attDef_return retval = new attDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Name55=null;
        Token DefaultDecl57=null;
        attType_return attType56 = null;


        Object Name55_tree=null;
        Object DefaultDecl57_tree=null;

        try {
            // DTD.g:162:7: ( Name attType DefaultDecl )
            // DTD.g:162:9: Name attType DefaultDecl
            {
            root_0 = (Object)adaptor.nil();

            Name55=(Token)input.LT(1);
            match(input,Name,FOLLOW_Name_in_attDef859); if (failed) return retval;
            if ( backtracking==0 ) {
            Name55_tree = (Object)adaptor.create(Name55);
            adaptor.addChild(root_0, Name55_tree);
            }
            pushFollow(FOLLOW_attType_in_attDef861);
            attType56=attType();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, attType56.getTree());
            DefaultDecl57=(Token)input.LT(1);
            match(input,DefaultDecl,FOLLOW_DefaultDecl_in_attDef863); if (failed) return retval;
            if ( backtracking==0 ) {
            DefaultDecl57_tree = (Object)adaptor.create(DefaultDecl57);
            adaptor.addChild(root_0, DefaultDecl57_tree);
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
    // $ANTLR end attDef

    public static class attType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start attType
    // DTD.g:165:1: attType : ( stringType | tokenizedType | enumeratedType );
    public final attType_return attType() throws RecognitionException {
        attType_return retval = new attType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        stringType_return stringType58 = null;

        tokenizedType_return tokenizedType59 = null;

        enumeratedType_return enumeratedType60 = null;



        try {
            // DTD.g:165:8: ( stringType | tokenizedType | enumeratedType )
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
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("165:1: attType : ( stringType | tokenizedType | enumeratedType );", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // DTD.g:165:10: stringType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_stringType_in_attType874);
                    stringType58=stringType();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, stringType58.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:165:23: tokenizedType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tokenizedType_in_attType878);
                    tokenizedType59=tokenizedType();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, tokenizedType59.getTree());

                    }
                    break;
                case 3 :
                    // DTD.g:165:39: enumeratedType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeratedType_in_attType882);
                    enumeratedType60=enumeratedType();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, enumeratedType60.getTree());

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
    // $ANTLR end attType

    public static class enumeration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start enumeration
    // DTD.g:167:1: enumeration : LParen Name ( '|' Name )* RParen ;
    public final enumeration_return enumeration() throws RecognitionException {
        enumeration_return retval = new enumeration_return();
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
            // DTD.g:167:12: ( LParen Name ( '|' Name )* RParen )
            // DTD.g:167:14: LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            LParen61=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_enumeration889); if (failed) return retval;
            if ( backtracking==0 ) {
            LParen61_tree = (Object)adaptor.create(LParen61);
            adaptor.addChild(root_0, LParen61_tree);
            }
            Name62=(Token)input.LT(1);
            match(input,Name,FOLLOW_Name_in_enumeration891); if (failed) return retval;
            if ( backtracking==0 ) {
            Name62_tree = (Object)adaptor.create(Name62);
            adaptor.addChild(root_0, Name62_tree);
            }
            // DTD.g:167:26: ( '|' Name )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==35) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // DTD.g:167:27: '|' Name
            	    {
            	    char_literal63=(Token)input.LT(1);
            	    match(input,35,FOLLOW_35_in_enumeration894); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    char_literal63_tree = (Object)adaptor.create(char_literal63);
            	    adaptor.addChild(root_0, char_literal63_tree);
            	    }
            	    Name64=(Token)input.LT(1);
            	    match(input,Name,FOLLOW_Name_in_enumeration896); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    Name64_tree = (Object)adaptor.create(Name64);
            	    adaptor.addChild(root_0, Name64_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            RParen65=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_enumeration900); if (failed) return retval;
            if ( backtracking==0 ) {
            RParen65_tree = (Object)adaptor.create(RParen65);
            adaptor.addChild(root_0, RParen65_tree);
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
    // $ANTLR end enumeration

    public static class enumeratedType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start enumeratedType
    // DTD.g:168:1: enumeratedType : ( notationType | enumeration );
    public final enumeratedType_return enumeratedType() throws RecognitionException {
        enumeratedType_return retval = new enumeratedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        notationType_return notationType66 = null;

        enumeration_return enumeration67 = null;



        try {
            // DTD.g:168:15: ( notationType | enumeration )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            else if ( (LA21_0==LParen) ) {
                alt21=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("168:1: enumeratedType : ( notationType | enumeration );", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // DTD.g:168:17: notationType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_notationType_in_enumeratedType906);
                    notationType66=notationType();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, notationType66.getTree());

                    }
                    break;
                case 2 :
                    // DTD.g:168:32: enumeration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeration_in_enumeratedType910);
                    enumeration67=enumeration();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, enumeration67.getTree());

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
    // $ANTLR end enumeratedType

    public static class notationType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start notationType
    // DTD.g:169:1: notationType : 'NOTATION' LParen Name ( '|' Name )* RParen ;
    public final notationType_return notationType() throws RecognitionException {
        notationType_return retval = new notationType_return();
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
            // DTD.g:169:13: ( 'NOTATION' LParen Name ( '|' Name )* RParen )
            // DTD.g:169:15: 'NOTATION' LParen Name ( '|' Name )* RParen
            {
            root_0 = (Object)adaptor.nil();

            string_literal68=(Token)input.LT(1);
            match(input,38,FOLLOW_38_in_notationType916); if (failed) return retval;
            if ( backtracking==0 ) {
            string_literal68_tree = (Object)adaptor.create(string_literal68);
            adaptor.addChild(root_0, string_literal68_tree);
            }
            LParen69=(Token)input.LT(1);
            match(input,LParen,FOLLOW_LParen_in_notationType918); if (failed) return retval;
            if ( backtracking==0 ) {
            LParen69_tree = (Object)adaptor.create(LParen69);
            adaptor.addChild(root_0, LParen69_tree);
            }
            Name70=(Token)input.LT(1);
            match(input,Name,FOLLOW_Name_in_notationType920); if (failed) return retval;
            if ( backtracking==0 ) {
            Name70_tree = (Object)adaptor.create(Name70);
            adaptor.addChild(root_0, Name70_tree);
            }
            // DTD.g:169:38: ( '|' Name )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==35) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // DTD.g:169:39: '|' Name
            	    {
            	    char_literal71=(Token)input.LT(1);
            	    match(input,35,FOLLOW_35_in_notationType923); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    char_literal71_tree = (Object)adaptor.create(char_literal71);
            	    adaptor.addChild(root_0, char_literal71_tree);
            	    }
            	    Name72=(Token)input.LT(1);
            	    match(input,Name,FOLLOW_Name_in_notationType925); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    Name72_tree = (Object)adaptor.create(Name72);
            	    adaptor.addChild(root_0, Name72_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            RParen73=(Token)input.LT(1);
            match(input,RParen,FOLLOW_RParen_in_notationType929); if (failed) return retval;
            if ( backtracking==0 ) {
            RParen73_tree = (Object)adaptor.create(RParen73);
            adaptor.addChild(root_0, RParen73_tree);
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
    // $ANTLR end notationType

    public static class stringType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start stringType
    // DTD.g:171:1: stringType : 'CDATA' ;
    public final stringType_return stringType() throws RecognitionException {
        stringType_return retval = new stringType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal74=null;

        Object string_literal74_tree=null;

        try {
            // DTD.g:171:11: ( 'CDATA' )
            // DTD.g:171:13: 'CDATA'
            {
            root_0 = (Object)adaptor.nil();

            string_literal74=(Token)input.LT(1);
            match(input,39,FOLLOW_39_in_stringType936); if (failed) return retval;
            if ( backtracking==0 ) {
            string_literal74_tree = (Object)adaptor.create(string_literal74);
            adaptor.addChild(root_0, string_literal74_tree);
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
    // $ANTLR end stringType

    public static class tokenizedType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tokenizedType
    // DTD.g:174:1: tokenizedType : ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' );
    public final tokenizedType_return tokenizedType() throws RecognitionException {
        tokenizedType_return retval = new tokenizedType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set75=null;

        Object set75_tree=null;

        try {
            // DTD.g:174:14: ( 'ID' | 'IDREF' | 'IDREFS' | 'ENTITY' | 'ENTITIES' | 'NMTOKEN' | 'NMTOKENS' )
            // DTD.g:
            {
            root_0 = (Object)adaptor.nil();

            set75=(Token)input.LT(1);
            if ( (input.LA(1)>=40 && input.LA(1)<=46) ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set75));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_tokenizedType0);    throw mse;
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
    // $ANTLR end tokenizedType

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // DTD.g:139:3: ( choice )
        // DTD.g:139:4: choice
        {
        pushFollow(FOLLOW_choice_in_synpred1623);
        choice();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // DTD.g:140:3: ( seq )
        // DTD.g:140:4: seq
        {
        pushFollow(FOLLOW_seq_in_synpred2647);
        seq();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // DTD.g:144:3: ( Name )
        // DTD.g:144:4: Name
        {
        match(input,Name,FOLLOW_Name_in_synpred3677); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // DTD.g:145:4: ( choice )
        // DTD.g:145:5: choice
        {
        pushFollow(FOLLOW_choice_in_synpred4702);
        choice();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // DTD.g:146:4: ( seq )
        // DTD.g:146:5: seq
        {
        pushFollow(FOLLOW_seq_in_synpred5727);
        seq();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
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
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_Digits_in_integerLiteral485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral491 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral496 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_Dot_in_decimalLiteral498 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Digits_in_decimalLiteral500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerLiteral_in_numericLiteral544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decimalLiteral_in_numericLiteral550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupdecl_in_dtd561 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_elementDecl_in_markupdecl569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attlistDecl_in_markupdecl573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Element_in_elementDecl581 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_elementDecl583 = new BitSet(new long[]{0x00000000C0004000L});
    public static final BitSet FOLLOW_contentSpec_in_elementDecl585 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_elementDecl587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_contentSpec597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_contentSpec601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mixed_in_contentSpec605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_children_in_contentSpec609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_children628 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_children631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_children652 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_children654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_cp682 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_cp707 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_cp732 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_set_in_cp735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_choice754 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_cp_in_choice756 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_choice759 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_cp_in_choice761 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_choice765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_seq785 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_cp_in_seq787 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Comma_in_seq790 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_cp_in_seq792 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RParen_in_seq796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed806 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mixed808 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_mixed811 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_mixed813 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_mixed817 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_mixed819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_mixed826 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mixed828 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RParen_in_mixed830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attlistDecl842 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_attlistDecl844 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_attDef_in_attlistDecl846 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_29_in_attlistDecl849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_attDef859 = new BitSet(new long[]{0x00007FC000004000L});
    public static final BitSet FOLLOW_attType_in_attDef861 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DefaultDecl_in_attDef863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_attType874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenizedType_in_attType878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeratedType_in_attType882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParen_in_enumeration889 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_enumeration891 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_enumeration894 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_enumeration896 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_enumeration900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notationType_in_enumeratedType906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_enumeratedType910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_notationType916 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LParen_in_notationType918 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_notationType920 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_notationType923 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Name_in_notationType925 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_RParen_in_notationType929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_stringType936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tokenizedType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_synpred3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_choice_in_synpred4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred5727 = new BitSet(new long[]{0x0000000000000002L});

}
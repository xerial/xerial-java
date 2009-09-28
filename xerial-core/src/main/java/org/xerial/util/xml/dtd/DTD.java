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
// DTD.java
// Since: Sep 28, 2009 10:55:34 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.dtd;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.util.log.Logger;
import org.xerial.util.xml.dtd.impl.DTDLexer;
import org.xerial.util.xml.dtd.impl.DTDParser;

/**
 * Object representation of the DTD format
 * 
 * @author leo
 * 
 */
public class DTD {

    private static Logger _logger = Logger.getLogger(DTD.class);

    public List<Element> element = new ArrayList<Element>();
    public List<Attlist> attlist = new ArrayList<Attlist>();

    public static enum ContentSpec {
        EMPTY, ANY
    }

    public static class Element {
        public String name;
        public ContentSpec contentSpec;
        public Component component;
    }

    public static enum Occurrence {
        ONE, ZERO_OR_ONE, ZERO_OR_MORE, ONE_OR_MORE
    }

    public static enum ContentType {
        CHOICE, SEQ, MIXED, PCDATA
    }

    public static class Component {
        public Occurrence occurrence = Occurrence.ONE;
        public ContentType type = ContentType.SEQ;
        public String name;
        public List<Component> component = new ArrayList<Component>();

        public Component get(int index) {
            return component.get(index);
        }
    }

    public static class Attlist {
        public String name;
        public List<Attribute> attribute = new ArrayList<Attribute>();
    }

    public static enum StringType {
        CDATA
    }

    public static enum TokenizedType {
        ID, IDREF, IDREFS, ENTITY, ENTITIES, NMTOKEN, NMTOKENS
    }

    public static enum AttributeDecl {
        REQUIRED, IMPLIED, FIXED
    }

    public static class Attribute {
        public String name;
        public StringType stringType;
        public TokenizedType tokenizedType;
        public String enumType;
        public AttributeDecl decl;
    }

    public static DTD parse(Reader dtdStream) throws XerialException, IOException {
        DTDLexer lexer = new DTDLexer(new ANTLRReaderStream(dtdStream));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DTDParser parser = new DTDParser(tokens);
        try {
            DTDParser.dtd_return t = parser.dtd();
            return Lens.loadANTLRParseTree(DTD.class, (Tree) t.getTree(), DTDParser.tokenNames);
        }
        catch (RecognitionException e) {
            throw new XerialException(XerialErrorCode.PARSE_ERROR, e);
        }

    }

}

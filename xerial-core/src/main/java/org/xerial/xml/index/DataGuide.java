/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
//-----------------------------------
// XerialJ Project
// 
// DataGuide.java 
// Since: 2005/05/31
//
// $Author$
//--------------------------------------
package org.xerial.xml.index;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Stack;

import org.xerial.core.XerialException;
import org.xerial.util.StringUtil;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Graph;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;
import org.xerial.xml.SinglePath;
import org.xerial.xml.XMLException;
import org.xerial.xml.pullparser.AbstractSAXEventHandler;
import org.xerial.xml.pullparser.PullParserUtil;
import org.xerial.xml.pullparser.SAXParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Generates DataGuides
 * 
 * @author leo
 * 
 */
public class DataGuide extends AbstractSAXEventHandler {
    /**
     * Adjacency list of String:tagID (node) and String:label (edge)
     */
    private Graph<String, String> _graph = new AdjacencyList<String, String>();
    //    private HashMap<String, Integer> _tag2idMap = new HashMap<String, Integer>();
    //    private HashMap<Integer, String> _id2tagMap = new HashMap<Integer, String>();
    private int _currentNodeID = 0;
    private Stack<Integer> _cursorHistory = new Stack<Integer>();
    private int _rootNodeID;

    public static final String ROOT_TAG = "_root";

    /**
     * 
     */
    public DataGuide() {
        _rootNodeID = getTagID_internal(ROOT_TAG);
        init();
    }

    private static XmlPullParser getParser(Reader xmlReader) throws XMLException {
        XmlPullParser parser = PullParserUtil.newParser(xmlReader);
        return parser;
    }

    /**
     * Get path ID
     * 
     * @param path
     * @return the found path ID, if not found returns -1
     */
    public int getPathID(SinglePath path) {
        return getTagID(path.getLeaf());
    }

    /**
     * Return tag id
     * 
     * @param tagName
     *            tag name or attribute name (tag@name)
     * 
     * @return node ID, or -1 (if not found)
     */
    public int getTagID(String tagName) {
        return _graph.getNodeID(tagName);
    }

    public int newTag(String tagName) throws XMLException {
        int tagID = this.getTagID_internal(tagName);
        this.moveCursor(tagID);
        return _currentNodeID;
    }

    public void newAttribute(String tagName, String attributeName) throws XMLException {
        int attributeID = this.getTagID_internal(String.format("%s@%s", tagName, attributeName));
        this.moveCursor(attributeID);
        this.traceBack();
    }

    public void closeTag() {
        this.traceBack();
    }

    public void init() {
        // some initialization
        _currentNodeID = _rootNodeID;

    }

    //------------------------------------------------------------------------------------------------
    // SAX handler methods
    // @see org.xerial.util.xml.pullparser.SAXEventHandler#startDocument(org.xmlpull.v1.XmlPullParser)
    @Override
    public void startDocument(XmlPullParser parser) throws XMLException {
        init();
    }

    @Override
    public void startTag(XmlPullParser parser) throws XMLException {
        newTag(parser.getName());
        for (int i = 0; i < parser.getAttributeCount(); i++) {
            newAttribute(parser.getName(), parser.getAttributeName(i));
        }
    }

    @Override
    public void endTag(XmlPullParser parser) throws XMLException {
        closeTag();
    }

    //--------------------------------------------------------------------------------------------------

    /**
     * generates the DataGuides of the given XML file
     * 
     * @param xmlFile
     * @throws FileNotFoundException
     * @throws XMLParserException
     * @throws XMLException
     * @throws IOException
     * @throws XerialException
     */
    public void generateFrom(String xmlFile) throws FileNotFoundException, Exception, IOException,
            XerialException {
        Reader reader = new BufferedReader(new FileReader(xmlFile));
        generateFrom(reader);
    }

    /**
     * Generates the DataGuide of the given XML stream
     * 
     * @param xmlReader
     * @throws FileNotFoundException
     * @throws XMLParserException
     */
    public void generateFrom(Reader xmlReader) throws Exception, IOException, XerialException {

        SAXParser saxParser = new SAXParser(this);
        saxParser.parse(xmlReader);
    }

    void moveCursor(int tagID) {
        _graph.addEdge(new Edge(_currentNodeID, tagID), "edge");

        _cursorHistory.push(_currentNodeID);
        _currentNodeID = tagID;
    }

    void traceBack() {
        assert !_cursorHistory.empty();
        _currentNodeID = _cursorHistory.pop();
    }

    int getTagID_internal(String tagName) {
        int tagID = _graph.getNodeID(tagName);
        if (tagID == -1) {
            tagID = _graph.addNode(tagName);
        }
        return tagID;
    }

    public void outputGraphviz(OutputStream out) {
        PrintWriter gout = new PrintWriter(out);
        gout.println("digraph G {");
        // output node labels
        for (int tagID : _graph.getNodeIDSet()) {
            gout.println(tagID + " [label=" + StringUtil.quote(_graph.getNodeLabel(tagID), "\"")
                    + "];");
        }
        for (int tagID : _graph.getNodeIDSet()) {
            for (int destNodeID : _graph.getDestNodeIDSetOf(tagID)) {
                gout.println(tagID + " -> " + destNodeID + ";");
            }
        }

        gout.println("}");
        gout.flush();
    }

    private static enum Opt {
        help
    }

    static class Config {
        @Option(symbol = "h", longName = "help", description = "display help messsage")
        boolean displayHelp = false;

        @Argument(index = 0, required = false)
        String xmlFile = null;
    }

    public static void main(String[] args) throws OptionParserException {
        Config config = new Config();
        OptionParser opt = new OptionParser(config);

        opt.parse(args);
        if (config.displayHelp || config.xmlFile == null) {
            printHelpMessage(opt);
            return;
        }

        DataGuide dg = new DataGuide();
        try {
            dg.generateFrom(config.xmlFile);
            dg.outputGraphviz(System.out);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printHelpMessage(OptionParser opt) {
        opt.printUsage();
    }
}

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
//--------------------------------------
// XerialJ Project
//
// InvertedPathTree.java
// Since: 2005/06/02
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import static org.xmlpull.v1.XmlPullParser.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Collection;

import org.xerial.core.XerialException;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Graph;
import org.xerial.util.graph.GraphvizHelper;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;
import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Inverted path tree is a set of inverted paths represented with a graph
 * 
 * @author leo
 * 
 */
public class InvertedPathTree {
    private Graph<InvertedPath, String> _pathTree = new AdjacencyList<InvertedPath, String>();
    //    TreeMap<InvertedPath, Integer> _path2idMap = new TreeMap<InvertedPath, Integer>();
    //    TreeMap<Integer, InvertedPath> _id2pathMap = new TreeMap<Integer, InvertedPath>();
    InvertedPath _currentInvertedPath = new InvertedPath();
    int _rootID;

    /**
     * 
     */
    public InvertedPathTree() {
        super();
        InvertedPath rootPath = new InvertedPath();
        _rootID = _pathTree.addNode(rootPath);
    }

    public void generateFrom(String xmlFile) throws XMLException, FileNotFoundException,
            IOException {
        generateFrom(new BufferedReader(new FileReader(xmlFile)));
    }

    public void generateFrom(Reader xmlReader) throws IOException, XMLException {
        XmlPullParser parser = PullParserUtil.newParser(xmlReader);

        try {
            int state;
            while ((state = parser.next()) != END_DOCUMENT) {
                switch (state) {
                case START_TAG:
                    _currentInvertedPath.addChild(parser.getName());
                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        _currentInvertedPath.addChild("@" + parser.getAttributeName(i));
                        updateInvertedPathTree();
                        _currentInvertedPath.removeFirstChild();
                    }
                    break;
                case END_TAG:
                    updateInvertedPathTree();
                    _currentInvertedPath.removeFirstChild();
                    break;
                }
            }

        }
        catch (XmlPullParserException e) {
            throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
        }
    }

    /**
     * add nodes and edges corresponding to the current path
     */
    private void updateInvertedPathTree() {
        int cursor = _rootID;
        InvertedPath cursorPath = new InvertedPath();
        for (String tag : _currentInvertedPath) {
            cursorPath.addParent(tag);
            Collection<Integer> destNodeID = _pathTree.getDestNodeIDSetOf(cursor);
            int pathID = getPathID(cursorPath);
            if (!destNodeID.contains(pathID)) {
                // create an edge from the cursor node to the pathID node
                _pathTree.addEdge(new Edge(cursor, pathID), "edge");
            }
            cursor = pathID;
        }
    }

    private int getPathID(InvertedPath path) {
        int pathID = _pathTree.getNodeID(path);
        if (pathID == -1) {
            InvertedPath clonePath = new InvertedPath(path);
            pathID = _pathTree.addNode(clonePath);
        }
        return pathID;
    }

    public void outputGraphviz(OutputStream os) {
        GraphvizHelper gout = new GraphvizHelper(os);
        gout.beginDigraph("G");

        // output node labels
        for (int pathID : _pathTree.getNodeIDSet()) {
            InvertedPath path = _pathTree.getNodeLabel(pathID);
            assert path != null;
            gout.node(pathID, path.getLastParent());
        }

        // output edges
        outputGraphvizEdges(gout, _rootID);

        gout.endDigraph();
        gout.endOutput();
    }

    private void outputGraphvizEdges(GraphvizHelper gout, int currentNodeID) {
        for (int dest : _pathTree.getDestNodeIDSetOf(currentNodeID)) {
            gout.edge(currentNodeID, dest);
            outputGraphvizEdges(gout, dest); // recursion
        }
    }

    @Option(symbol = "h", longName = "help", description = "display help messsage")
    private boolean displayHelp = false;

    @Argument(index = 0, required = false)
    private String xmlFile = null;

    public static void main(String[] args) throws OptionParserException {
        InvertedPathTree ipt = new InvertedPathTree();
        OptionParser opt = new OptionParser(ipt);

        opt.parse(args);
        if (ipt.displayHelp || ipt.xmlFile == null) {
            printHelpMessage(opt);
            return;
        }

        try {
            ipt.generateFrom(ipt.xmlFile);
            ipt.outputGraphviz(System.out);
        }
        catch (XerialException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printHelpMessage(OptionParser opt) {
        opt.printUsage();
    }
}

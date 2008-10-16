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

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_TAG;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Set;

import org.xerial.core.XerialException;
import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.GraphException;
import org.xerial.util.graph.GraphvizHelper;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Inverted pathの集合をグラフで表現したもの（Inverted Path Tree)
 * 
 * @author leo
 * 
 */
public class InvertedPathTree
{
    AdjacencyList<InvertedPath, String> _pathTree = new AdjacencyList<InvertedPath, String>();
    //    TreeMap<InvertedPath, Integer> _path2idMap = new TreeMap<InvertedPath, Integer>();
    //    TreeMap<Integer, InvertedPath> _id2pathMap = new TreeMap<Integer, InvertedPath>();
    InvertedPath _currentInvertedPath = new InvertedPath();
    int _rootID;

    /**
     * 
     */
    public InvertedPathTree()
    {
        super();
        InvertedPath rootPath = new InvertedPath();
        _rootID = _pathTree.addNode(rootPath);
    }

    public void generateFrom(String xmlFile) throws XMLException, GraphException, FileNotFoundException, IOException
    {
        generateFrom(new BufferedReader(new FileReader(xmlFile)));
    }

    public void generateFrom(Reader xmlReader) throws IOException, XMLException, GraphException
    {
        XmlPullParser parser = PullParserUtil.newParser(xmlReader);

        try
        {
            int state;
            while ((state = parser.next()) != END_DOCUMENT)
            {
                switch (state)
                {
                case START_TAG:
                    _currentInvertedPath.addChild(parser.getName());
                    for (int i = 0; i < parser.getAttributeCount(); i++)
                    {
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
        catch (XmlPullParserException e)
        {
            throw new XMLException(e);
        }
        catch (GraphException e)
        {
            throw e;
        }
    }

    /**
     * currentPathに対応するnodeとedgeをグラフに追加する
     */
    private void updateInvertedPathTree() throws GraphException
    {
        int cursor = _rootID;
        InvertedPath cursorPath = new InvertedPath();
        for (String tag : _currentInvertedPath)
        {
            cursorPath.addParent(tag);
            Set<Integer> destNodeID = _pathTree.destNodeIDSet(cursor);
            int pathID = getPathID(cursorPath);
            if (!destNodeID.contains(pathID))
            {
                // create an edge from the cursor node to the pathID node
                _pathTree.addEdge(cursor, pathID, "edge");
            }
            cursor = pathID;
        }
    }

    private int getPathID(InvertedPath path)
    {
        int pathID = _pathTree.getNodeID(path);
        if (pathID == -1)
        {
            InvertedPath clonePath = new InvertedPath(path);
            pathID = _pathTree.addNode(clonePath);
        }
        return pathID;
    }

    public void outputGraphviz(OutputStream os)
    {
        GraphvizHelper gout = new GraphvizHelper(os);
        gout.beginDigraph("G");

        // output node labels
        for (int pathID : _pathTree.nodeIDSet())
        {
            InvertedPath path = _pathTree.getNode(pathID);
            assert path != null;
            gout.label(pathID, path.getLastParent());
        }

        // output edges
        outputGraphvizEdges(gout, _rootID);

        gout.endDigraph();
        gout.endOutput();
    }

    private void outputGraphvizEdges(GraphvizHelper gout, int currentNodeID)
    {
        Set<Integer> destNodeIDSet = _pathTree.destNodeIDSet(currentNodeID);
        for (int dest : destNodeIDSet)
        {
            gout.edge(currentNodeID, dest);
            outputGraphvizEdges(gout, dest); // recursion
        }
    }

    enum Opt {
        help
    }

    public static void main(String[] args) throws OptionParserException
    {
        OptionParser<Opt> opt = new OptionParser<Opt>();
        opt.addOption(Opt.help, "h", "help", "display help messages");

        opt.parse(args);
        if (opt.isSet(Opt.help) || opt.getArgumentLength() < 1)
        {
            printHelpMessage(opt);
            return;
        }

        InvertedPathTree ipt = new InvertedPathTree();
        try
        {
            ipt.generateFrom(opt.getArgument(0));
            ipt.outputGraphviz(System.out);
        }
        catch (XerialException e)
        {
            System.err.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private static void printHelpMessage(OptionParser<Opt> opt)
    {
        System.out.println("usage: > java -jar DataGuide.jar [option] xml_file");
        System.out.println(opt.helpMessage());
    }
}

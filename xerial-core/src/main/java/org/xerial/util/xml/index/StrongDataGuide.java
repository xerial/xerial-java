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
// StrongDataGuide.java
// Since: 2005/06/02
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import static org.xmlpull.v1.XmlPullParser.END_DOCUMENT;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_TAG;
import static org.xmlpull.v1.XmlPullParser.TEXT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.Stack;

import org.xerial.core.XerialException;
import org.xerial.util.StringUtil;
import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Edge;
import org.xerial.util.graph.Graph;
import org.xerial.util.log.Logger;
import org.xerial.util.xml.SinglePath;
import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * StrongDataGuide, which aggregates XML nodes based on same paths
 * 
 * @author leo
 * 
 */
public class StrongDataGuide
{
    private Graph<SinglePath, String> _graph         = new AdjacencyList<SinglePath, String>();
    private int                       _currentPathID = 0;
    private Stack<Integer>            _cursorHistory = new Stack<Integer>();
    private SinglePath                _currentPath;
    private SinglePath                _rootPath;
    private int                       _rootPathID;
    private Logger                    _logger        = Logger.getLogger(StrongDataGuide.class);

    /**
     * 
     */
    public StrongDataGuide()
    {
        super();
        _rootPath = SinglePath.rootPath();
        _rootPathID = _graph.addNode(_rootPath);
    }

    /**
     * Generates the StrongDataGuide from the XML file
     * 
     * @param xmlFile
     * @throws FileNotFoundException
     * @throws XMLParserException
     * @throws XMLException
     * @throws IOException
     * @throws XerialException
     */
    public void generateFrom(String xmlFile) throws FileNotFoundException, XMLException, IOException, XerialException
    {
        Reader reader = new BufferedReader(new FileReader(xmlFile));
        generateFrom(reader);
    }

    /**
     * Generates the {@link StrongDataGuide} from the {@link Reader}
     * 
     * @param xmlReader
     * @throws FileNotFoundException
     * @throws XMLParserException
     */
    public void generateFrom(Reader xmlReader) throws XMLException, IOException, XerialException
    {
        // initialize
        _currentPathID = _rootPathID;
        _currentPath = _rootPath;

        XmlPullParser parser = PullParserUtil.newParser(xmlReader);
        try
        {
            int state;
            while ((state = parser.next()) != END_DOCUMENT)
            {
                switch (state)
                {
                case START_TAG:
                    String name = parser.getName();
                    _logger.trace("start tag: " + name);
                    int pathID = getPathID(name);
                    _logger.trace("path ID  : " + pathID);
                    moveCursor(pathID);
                    // process attributes
                    for (int i = 0; i < parser.getAttributeCount(); i++)
                    {
                        int attributeID = getPathID(String.format("%s@%s", name, parser.getAttributeName(i)));
                        moveCursor(attributeID);
                        traceBack();
                    }
                    break;
                case END_TAG:
                    traceBack();
                    break;
                case TEXT:
                    break;
                }
            }

        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(XMLErrorCode.PARSE_ERROR, e);
        }
    }

    private void moveCursor(int pathID)
    {
        Collection<Integer> destNodeID = _graph.getDestNodeIDSetOf(_currentPathID);
        if (!destNodeID.contains(pathID))
        {
            _graph.addEdge(new Edge(_currentPathID, pathID), "edge");
        }
        _cursorHistory.push(_currentPathID);
        _currentPathID = pathID;
        _currentPath = _graph.getNodeLabel(pathID);
    }

    private void traceBack()
    {
        assert !_cursorHistory.empty();
        _currentPathID = _cursorHistory.pop();
        _currentPath = _graph.getNodeLabel(_currentPathID);
    }

    private int getPathID(String tagName)
    {
        SinglePath path = new SinglePath(_currentPath, tagName);
        int pathID = _graph.getNodeID(path);
        if (pathID == -1)
        {
            pathID = _graph.addNode(path);
        }
        return pathID;
    }

    public void outputGraphviz(OutputStream out)
    {
        PrintWriter gout = new PrintWriter(out);
        gout.println("digraph G {");
        // output node labels
        for (int pathID : _graph.getNodeIDSet())
        {
            SinglePath path = _graph.getNodeLabel(pathID);
            gout.println(pathID + " [label=" + StringUtil.quote(path.getLeaf(), "\"") + "];");
        }
        for (int pathID : _graph.getNodeIDSet())
        {
            for (int destNodeID : _graph.getDestNodeIDSetOf(pathID))
            {
                gout.println(pathID + " -> " + destNodeID + ";");
            }
        }

        gout.println("}");
        gout.flush();
    }

    public static enum Opt {
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

        StrongDataGuide sdg = new StrongDataGuide();
        try
        {
            sdg.generateFrom(opt.getArgument(0));
            sdg.outputGraphviz(System.out);
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
        System.out.println("usage: > java -jar StrongDataGuide.jar [option] xml_file");
        System.out.println(opt.helpMessage());

    }

}

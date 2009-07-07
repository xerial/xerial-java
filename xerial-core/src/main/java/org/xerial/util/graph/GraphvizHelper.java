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
// GraphvizHelper.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Stack;
import java.util.Map.Entry;

import org.xerial.util.StringUtil;

/**
 * A helper class for generateing Graphviz's dot file
 * 
 * @author leo
 * 
 */
public class GraphvizHelper {
    private PrintWriter _out;
    private Stack<GraphvizComponent> _componentStack = new Stack<GraphvizComponent>();

    /**
     * 
     */
    public GraphvizHelper(OutputStream out) {
        _out = new PrintWriter(out);
    }

    public GraphvizHelper(Writer out) {
        _out = new PrintWriter(out);
    }

    /**
     * begin output of digraph. Finally, you have to call endDigraph to close
     * the dot description.
     * 
     * @param graphName
     */
    public void beginDigraph(String graphName) {
        pushComponent(new Digraph(graphName));
    }

    public void endDigraph() {
        assert !_componentStack.empty();
        GraphvizComponent lastComponent = popComponent();
        assert lastComponent instanceof Digraph;
        lastComponent.leave(_out);
        flush();
    }

    public void node(String nodeID, String label) {
        _out.println(String.format("%s [label=\"%s\"];", nodeID, label.toString()));
    }

    public void node(int nodeID, String label) {
        _out.println(String.format("%d [label=\"%s\"];", nodeID, label.toString()));
    }

    public void node(String nodeID, Properties options) {
        _out.println(String.format("%s [%s]", nodeID, format(options)));
    }

    private String format(Properties options) {
        ArrayList<String> buf = new ArrayList<String>(options.size());
        for (Entry<Object, Object> each : options.entrySet()) {
            buf.add(String.format("%s=%s", each.getKey(), each.getValue()));
        }

        return StringUtil.join(buf, ", ");
    }

    public void graphOption(String option) {
        _out.println(String.format("graph [%s];", option));
    }

    public void edge(String fromNodeID, String toNodeID) {
        _out.println(fromNodeID + " -> " + toNodeID + ";");
    }

    public void edge(String fromNodeID, String toNodeID, Properties prop) {
        _out.println(String.format("%s -> %s [%s];", fromNodeID, toNodeID, format(prop)));
    }

    public void edge(int fromNodeID, int toNodeID) {
        _out.println(fromNodeID + " -> " + toNodeID + ";");
    }

    public void edge(String fromNodeID, String toNodeID, String label) {
        _out.println(String.format("%s -> %s [label=\"%s\"];", fromNodeID, toNodeID, label));
    }

    public void edge(int fromNodeID, int toNodeID, String label) {
        _out.println(String.format("%d -> %d [label=\"%s\"];", fromNodeID, toNodeID, label));
    }

    public void endOutput() {
        while (!_componentStack.empty()) {
            GraphvizComponent lastComponent = popComponent();
            lastComponent.leave(_out);
        }
        _out.flush();
    }

    public void flush() {
        _out.flush();
    }

    private void pushComponent(GraphvizComponent component) {
        _componentStack.add(component);
        component.enter(_out);
    }

    private GraphvizComponent popComponent() {
        assert !_componentStack.empty();
        return _componentStack.pop();
    }

    class GraphvizComponent {
        /**
         * 
         */
        public void enter(PrintWriter out) {}

        /**
         * 
         */
        public void leave(PrintWriter out) {}
    }

    class Digraph extends GraphvizComponent {
        private String _graphName;

        public Digraph(String graphName) {
            _graphName = graphName;
        }

        @Override
        public void enter(PrintWriter out) {
            out.println("digraph " + _graphName + "{");
        }

        @Override
        public void leave(PrintWriter out) {
            out.println("}");
        }

    }

}

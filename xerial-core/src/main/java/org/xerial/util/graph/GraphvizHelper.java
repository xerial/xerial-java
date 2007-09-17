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
import java.util.Stack;

import org.xerial.util.StringUtil;


/**
 * Graphvizのdotファイルを出力するためのヘルパークラス
 * @author leo
 *
 */
public class GraphvizHelper
{
    private PrintWriter  _out;
    private Stack<GraphvizComponent> _componentStack = new Stack<GraphvizComponent>(); 
    
    /**
     * 
     */
    public GraphvizHelper(OutputStream out)
    {
        _out = new PrintWriter(out);
    }
    
    public GraphvizHelper(Writer out)
    {
        _out = new PrintWriter(out);
    }
    
    
    /**
     * digraphを開始する。edgeなどの出力が終了したら、最後にendDigraphを呼ばなくてはならない
     * @param graphName
     */
    public void beginDigraph(String graphName)
    {
        pushComponent(new Digraph(graphName));
    }
    
    public void endDigraph()
    {
        assert !_componentStack.empty();
        GraphvizComponent lastComponent = popComponent();
        assert lastComponent instanceof Digraph;
        lastComponent.leave(_out);
        flush();
    }
    
    
    public void label(Object nodeName, Object label)
    {
        _out.println(nodeName.toString() + " [label=" + StringUtil.quote(label.toString(), "\"") + "];");
    }
    public void edge(Object nodeFrom, Object nodeTo)
    {
        _out.println(nodeFrom.toString() + " -> " + nodeTo.toString() + ";");
    }
    
    
    public void endOutput()
    {
        while(!_componentStack.empty())
        {
            GraphvizComponent lastComponent = popComponent();
            lastComponent.leave(_out);
        }
        _out.flush();
    }
    
    public void flush()
    {
        _out.flush();
    }
    
    private void pushComponent(GraphvizComponent component)
    {
        _componentStack.add(component);
        component.enter(_out);
    }
    
    private GraphvizComponent popComponent()
    {
        assert !_componentStack.empty();
        return _componentStack.pop();
    }

    class GraphvizComponent
    {
        /**
         * このコンポーネント追加時の出力を定義
         */
        public void enter(PrintWriter out) 
        { }
        
        /**
         * このコンポーネントを抜けるときの出力を定義
         */
        public void leave(PrintWriter out)
        { }
    }
    
    class Digraph extends GraphvizComponent
    {
        private String _graphName;
        public Digraph(String graphName)
        {
            _graphName = graphName;
        }
        
        @Override
        public void enter(PrintWriter out)
        {
           out.println("digraph " + _graphName + "{");
        }

        @Override
        public void leave(PrintWriter out)
        {
            out.println("}");
        }
        
    }

}





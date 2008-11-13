/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// GraphHelper.java
// Since: Oct 24, 2008 11:03:03 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

/**
 * A helper class to implement graph related methods
 * 
 * package scope
 * 
 * @author leo
 * 
 */
class GraphHelper
{
    /**
     * Prohibit construction
     */
    private GraphHelper()
    {};

    public static <NodeLabel, EdgeLabel> NodeLabel getSourceNodeLabel(Graph<NodeLabel, EdgeLabel> graph, Edge edge)
    {
        return graph.getNodeLabel(edge.getSourceNodeID());
    }

    public static <NodeLabel, EdgeLabel> NodeLabel getDestNodeLabel(Graph<NodeLabel, EdgeLabel> graph, Edge edge)
    {
        return graph.getNodeLabel(edge.getDestNodeID());
    }

    public static <NodeLabel, EdgeLabel> String toString(Graph<NodeLabel, EdgeLabel> graph, Edge edge)
    {
        return String.format("(%s,%s)", graph.getNodeLabel(edge.getSourceNodeID()).toString(), graph.getNodeLabel(
                edge.getDestNodeID()).toString());
    }

    
    /**
     * compute the transitive closure of the input graph
     * 
     * @param <NodeLabel>
     * @param <EdgeLabel>
     * @param original
     * @return
     */
    public static <NodeLabel, EdgeLabel> Graph<NodeLabel, EdgeLabel> transitiveClosure(
            Graph<NodeLabel, EdgeLabel> input)
    {
        Graph<NodeLabel, EdgeLabel> graph = AdjacencyList.copy(input);

        for (int numChange = 1; numChange > 0; numChange = 0)
        {
            for (NodeLabel from : graph.getNodeLabelSet())
            {
                for (NodeLabel to : graph.getNodeLabelSet())
                {
                    if (graph.hasEdge(from, to))
                        continue;

                    int destNodeID = graph.getNodeID(to);
                    for (Edge startPoint : graph.getOutEdgeSet(from))
                    {
                        int intermediateNodeID = startPoint.getDestNodeID();

                        if (graph.hasEdge(new Edge(intermediateNodeID, destNodeID)))
                        {
                            graph.addEdge(from, to);
                            ++numChange;
                            break;
                        }
                    }
                }
            }
        }
        
        return graph;
    }
    
    
}

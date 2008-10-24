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

}

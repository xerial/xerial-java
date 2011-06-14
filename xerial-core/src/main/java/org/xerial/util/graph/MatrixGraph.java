/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// MatrixGraph.java
// Since: 2011/06/14 16:10:40
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MatrixGraph<Node> {

    private int[][] matrix;
    private HashMap<Node, Integer> nodeTable = new HashMap<Node, Integer>();
    private int nodeCount = 0;

    public MatrixGraph(int numNodes) {
        matrix = new int[numNodes][numNodes];
    }

    public void addNode(Node node) {
        int nodeID = nodeCount++;
        if (nodeID >= matrix.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.nodeTable.put(node, nodeID);
    }

    public void addEdge(Node src, Node dest) {
        matrix[getNodeID(src)][getNodeID(dest)] = 1;
    }

    public int getNodeID(Node node) {
        if (nodeTable.containsKey(node))
            return nodeTable.get(node);
        else
            throw new NoSuchElementException("node " + node + " is not found");
    }

    public List<Node> getDestNodes(Node node) {
        int nodeID = getNodeID(node);
        List<Node> destNodeSet = new ArrayList<Node>();
        for (int col = 0; col < matrix.length; ++col) {
            if (matrix[nodeID][col] == 1) {
                // destNodeSet.add(nodeTable. )
            }
        }
    }

    public boolean containsNode(String node) {
        return nodeTable.containsKey(node);
    }

    public boolean hasEdge(Node src, Node dest) {
        return matrix[getNodeID(src)][getNodeID(dest)] == 1;
    }
}

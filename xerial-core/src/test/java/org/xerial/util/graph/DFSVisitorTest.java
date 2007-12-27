/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// UTGB Common Project
//
// DFSVisitorTest.java
// Since: May 15, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/test/org/utgenome/util/graph/DFSVisitorTest.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.graph;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class DFSVisitorTest {

	AdjacencyList<String, String> graph;
	
	@Before
	public void setUp() throws Exception {
        graph = new AdjacencyList<String, String>();
        /*
         *  A->B -->C
         *  |  |^
         *  V  V|
         *  D<-E
         */
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "D");
        graph.addEdge("E", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "B");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void runDFS()
	{
		DFSVisitor<String, String> visitor = new DFSVisitor<String, String>(graph);
		visitor.depthFirstSearch("A");
	}

	class MyDFSVisitor extends DFSVisitor<String, String>
	{
		Logger _logger = Logger.getLogger(DFSVisitorTest.class);
		public MyDFSVisitor(AdjacencyList<String, String> graph) {
			super(graph);
		}

		@Override
		public void backEdge(Edge edge) {
			_logger.debug("back edge: " + toString(edge));
		}

		@Override
		public void discoverNode(String node) {
			_logger.debug("discover: " + node);
		}

		@Override
		public void examineEdge(Edge edge) {
			_logger.debug("examine edge: " + toString(edge));
		}

		@Override
		public void finishNode(String node) {
			_logger.debug("finish: " + node);

			
		}

		@Override
		public void forwardOrCrossEdge(Edge edge) {
			_logger.debug("forward or cross: " + toString(edge));

		}

		@Override
		public void initializeNode(String node) {
			_logger.debug("initialize: " + node);

		}

		@Override
		public void startNode(String node) {
			_logger.debug("start: " + node);

		}

		@Override
		public void treeEdge(Edge edge) {
			_logger.debug("tree edge: " + toString(edge));
		}
		

	}
	
	
	@Test
	public void customDFS()
	{
		MyDFSVisitor visitor = new MyDFSVisitor(graph);
		visitor.depthFirstSearch("A");
	}
	
}





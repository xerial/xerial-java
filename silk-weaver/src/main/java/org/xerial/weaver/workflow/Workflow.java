/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// Xerial Silk Weaver Project 
//
// Workflow.java
// Since: 2009/07/02 7:47:48
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.workflow;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.xerial.util.graph.AdjacencyList;
import org.xerial.util.graph.Graph;
import org.xerial.util.log.Logger;

/**
 * 
 * Workflow description
 * 
 * @author leo
 * 
 */
public class Workflow {

    private static Logger _logger = Logger.getLogger(Workflow.class);
    private Graph<Task, String> workflow = new AdjacencyList<Task, String>();

    /**
     * output the workflow in the Graphvis DOT file format
     * 
     * @return
     */
    public String toGraphvis() {
        StringWriter buf = new StringWriter();
        toGraphvis(buf);
        return buf.toString();
    }

    /**
     * Output the workflow in the Graphviz DOT file format
     * 
     * @param out
     */
    public void toGraphvis(Writer out) {
        try {
            out.append(workflow.toGraphViz());
        }
        catch (IOException e) {
            _logger.warn(e);
        }
    }
}

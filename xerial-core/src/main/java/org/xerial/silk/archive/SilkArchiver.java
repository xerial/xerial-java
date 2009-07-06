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
// XerialJ
//
// SilkArchiver.java
// Since: Jul 6, 2009 6:44:31 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.archive;

import org.xerial.relation.Node;
import org.xerial.relation.query.AmoebaJoinHandler;
import org.xerial.relation.query.QuerySet;
import org.xerial.relation.query.StreamAmoebaJoin;
import org.xerial.relation.schema.Schema;
import org.xerial.silk.schema.SilkSchema;
import org.xerial.util.tree.TreeParser;

/**
 * Create a queryable archive of Silk (Tree-format) data.
 * 
 * @author leo
 * 
 */
public class SilkArchiver {

    public static class SilkInput {
        TreeParser parser;
        SilkSchema schema;
    }

    public void createArchive(SilkInput input) throws Exception {

        QuerySet qs = new QuerySet.QuerySetBuilder().build();

        AmoebaJoinHandler handler = new RelationHandler();

        StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, handler);

        aj.sweep(input.parser);

    }

    private class RelationHandler implements AmoebaJoinHandler {

        public void finish() {
        // TODO Auto-generated method stub

        }

        public void init() {
        // TODO Auto-generated method stub

        }

        public void leaveNode(Schema schema, Node node) throws Exception {
        // TODO Auto-generated method stub

        }

        public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception {
        // TODO Auto-generated method stub

        }

        public void text(Schema schema, Node coreNode, Node textNode, String text) throws Exception {
        // TODO Auto-generated method stub

        }

    }

}

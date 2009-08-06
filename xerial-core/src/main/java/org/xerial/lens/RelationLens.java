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
// RelationLens.java
// Since: Aug 6, 2009 4:02:39 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.IOException;

import org.xerial.core.XerialException;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.query.AmoebaJoinHandler;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.lens.relation.query.lang.RelationExpr;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeParser;

/**
 * For extracting relation from tree-structured data
 * 
 * @author leo
 * 
 */
public class RelationLens {

    private static Logger _logger = Logger.getLogger(RelationLens.class);

    private final QuerySet qs;

    public RelationLens(String lensQuery) throws XerialException {
        RelationExpr re = RelationExpr.parse(lensQuery);
        qs = re.buildQuerySet();
    }

    public void map(TreeParser input) {

        AmoebaJoinHandler relationExtracter = new RelationExtracter();
        try {
            StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, relationExtracter);
        }
        catch (IOException e) {
            _logger.error(e);
        }

    }

    public static class RelationExtracter implements AmoebaJoinHandler {

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

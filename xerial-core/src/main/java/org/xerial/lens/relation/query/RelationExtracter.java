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
// RelationExtracter.java
// Since: 2009/08/06 17:14:17
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.io.IOException;
import java.util.HashMap;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.tree.TreeParser;

/**
 * Relation extracter
 * 
 * @author leo
 * 
 */
public class RelationExtracter {

    private final QuerySet qs;
    private final HashMap<Schema, RelationFragmentHolder> relationHolderTable = new HashMap<Schema, RelationFragmentHolder>();
    private final RelationHandler handler;

    private RelationExtracter(QuerySet qs, RelationHandler handler) {
        this.qs = qs;
        this.handler = handler;
        for (Schema each : qs.getTargetQuerySet()) {
            relationHolderTable.put(each, new RelationFragmentHolder(each, this.handler));
        }
    }

    private void run(TreeParser input) throws XerialException {
        AmoebaJoinHandler ajHandler = new AJHandler();
        try {
            StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, ajHandler);
            aj.sweep(input);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (XerialException e) {
            throw e;
        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.INHERITED, e);
        }

    }

    public static void run(QuerySet qs, TreeParser input, RelationHandler handler)
            throws XerialException {

        RelationExtracter re = new RelationExtracter(qs, handler);
        re.run(input);
    }

    class AJHandler extends AmoebaJoinHandlerBase {

        public void leaveNode(Schema schema, Node node) throws Exception {
            RelationFragmentHolder holder = relationHolderTable.get(schema);
            if (holder == null)
                return;

            holder.pop(node);
        }

        public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception {
            RelationFragmentHolder holder = relationHolderTable.get(schema);
            if (holder == null)
                return;

            holder.push(coreNode);
            holder.push(attributeNode);

        }

        public void text(Schema schema, Node coreNode, Node textNode, String text) throws Exception {
        // TODO Auto-generated method stub

        }

    }

}

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
// RelationStreamExtracter.java
// Since: Mar 1, 2010 4:15:49 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.ContainerManager;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.NodeValueCardinality;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleContainer;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.log.Logger;

/**
 * Extract and save the extracted relations into a storage
 * 
 * @author leo
 * 
 */
public class RelationStreamCollector implements AmoebaJoinHandler, RelationHandler {

    private static Logger _logger = Logger.getLogger(RelationStreamCollector.class);

    private final HashMap<Schema, RelationFragmentHolder> relationHolderTable = new HashMap<Schema, RelationFragmentHolder>();
    // statistics
    Map<Schema, List<NodeValueCardinality>> distinctNodeCountOfEachRelation = new HashMap<Schema, List<NodeValueCardinality>>();
    Map<Schema, TupleContainer> bufferTable = new HashMap<Schema, TupleContainer>();

    final QuerySet query;
    final ContainerManager storage;

    public RelationStreamCollector(QuerySet query, ContainerManager storage) {
        this.query = query;
        this.storage = storage;
    }

    public void finish() {

        _logger.debug("sweep finished");

        try {
            for (RelationFragmentHolder each : relationHolderTable.values()) {
                TupleContainer buffer = bufferTable.get(each.getRelation());

                if (_logger.isDebugEnabled())
                    _logger.debug(String.format("relation: %s\n%s", each.getRelation(), buffer));
                storage.store(buffer);
                buffer.clear();
            }
        }
        catch (XerialException e) {
            _logger.error(e);
        }

    }

    public void init() {
        // prepare relation fragment holder for each schema element
        for (Schema eachSchema : query.getTargetQuerySet()) {
            relationHolderTable.put(eachSchema, new RelationFragmentHolder(eachSchema, this));
            bufferTable.put(eachSchema, new TupleContainer(eachSchema));
        }
    }

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

    }

    public void relation(Schema s, Tuple<Node> relation) {

        TupleContainer buffer = bufferTable.get(s);
        if (buffer == null)
            return;

        if (!buffer.hasEnoughRoomFor(relation, storage.getPageSizeMax())) {
            // output buffer contents to the disk
            try {
                storage.store(buffer);
            }
            catch (XerialException e) {
                throw new XerialError(XerialErrorCode.DISK_IO_ERROR, e);
            }
            buffer.clear();
        }
        buffer.add(relation);
    }

}

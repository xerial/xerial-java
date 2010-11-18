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
// Xerial Raquel Project
//
// TableJoin.java
// Since: Dec 1, 2008 2:09:37 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/query/TableJoin.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.query;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.Tuple;
import org.xerial.lens.relation.TupleContainer;
import org.xerial.lens.relation.TupleCursor;
import org.xerial.lens.relation.TupleElement;
import org.xerial.lens.relation.TupleIndex;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.log.Logger;

/**
 * table join operation
 * 
 * @author leo
 * 
 */
public class TableJoin {
    private static Logger _logger = Logger.getLogger(TableJoin.class);

    public static Schema newJoinedSchema(Schema left, Schema right, String joinNode) {
        SchemaBuilder builder = new SchemaBuilder();
        builder.setFD(FD.ONE_TO_ONE);
        for (int i = 0; i < left.size(); ++i) {
            builder.add(left.get(i));
        }

        for (int i = 0; i < right.size(); ++i) {
            Schema e = right.get(i);
            if (e.getName().equals(joinNode))
                continue;

            builder.add(e);
        }

        return builder.build();
    }

    public static class OneToManyTupleCursor implements TupleCursor {
        TupleCursor cursor;
        long prevID = -1;
        Deque<Tuple<Node>> result = new ArrayDeque<Tuple<Node>>();

        long getID(Tuple<Node> tuple) {
            return tuple.getNode(0).nodeID;
        }

        public OneToManyTupleCursor(TupleCursor cursor) {
            this.cursor = cursor;
            if (!cursor.getSchema().isOneToMany())
                throw new XerialError(XerialErrorCode.INVALID_STATE, "not a 1:M latticeCursor");
        }

        public Schema getSchema() {
            return cursor.getSchema();
        }

        void fillQueue() {
            if (!result.isEmpty())
                return;

            Deque<Tuple<Node>> queueOfTheSameIDTuple = new ArrayDeque<Tuple<Node>>();
            while (cursor.hasNext()) {
                Tuple<Node> t = cursor.peekNext();
                long id = getID(t);
                if (prevID == -1 || id == prevID) {
                    prevID = id;
                    queueOfTheSameIDTuple.addLast(t);
                    cursor.next();
                }
                else
                    break;
            }

            if (queueOfTheSameIDTuple.isEmpty())
                return;

            Tuple<Node> tuple = new Tuple<Node>(cursor.getSchema().size());
            tuple.add(queueOfTheSameIDTuple.getFirst().get(0));
            if (queueOfTheSameIDTuple.size() > 1) {
                Tuple<Node> mNodes = new Tuple<Node>();
                for (TupleElement<Node> each : queueOfTheSameIDTuple) {
                    // collect m-nodes
                    mNodes.add(each.get(1));
                }
                tuple.add(mNodes);
            }
            else
                tuple.add(queueOfTheSameIDTuple.getFirst().get(1));

            result.addLast(tuple);

        }

        public Tuple<Node> peekNext() {
            fillQueue();
            return result.getFirst();
        }

        public boolean hasNext() {
            fillQueue();
            return !result.isEmpty();
        }

        public Tuple<Node> next() {
            fillQueue();
            Tuple<Node> ret = result.removeFirst();
            prevID = -1; // indicates to load the next tuple set
            return ret;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }

    public static TupleContainer outerJoin(TupleCursor left, String joinNode, TupleCursor right) {
        Schema resultSchema = newJoinedSchema(left.getSchema(), right.getSchema(), joinNode);

        _logger.debug(String.format("outer join: %s", resultSchema));

        TupleContainer result = new TupleContainer(resultSchema);

        final TupleIndex joinNodeIndexOnLeft = left.getSchema().getNodeIndex(joinNode);
        final TupleIndex joinNodeIndexOnRight = right.getSchema().getNodeIndex(joinNode);

        if (joinNodeIndexOnLeft == null || joinNodeIndexOnRight == null
                || joinNodeIndexOnRight.get(0) != 0)
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                    "invalid join %s join %s on %s", left.getSchema(), right.getSchema(), joinNode));

        // left and right relations must be sorted in the order of join node
        Schema leftSchema = left.getSchema();
        Schema rightSchema = right.getSchema();

        for (;;) {
            if (!left.hasNext()) {
                for (; right.hasNext();) {
                    // output all right tuple 
                    Tuple<Node> tuple = newEmptyTuple(resultSchema);

                    Tuple<Node> rightTuple = right.next();
                    for (int i = 0; i < rightTuple.size(); ++i)
                        tuple.set(resultSchema.getNodeIndex(rightSchema.get(i).getName()),
                                rightTuple.get(i));

                    result.add(tuple);
                }
                return result;
            }

            if (!right.hasNext()) {
                for (; left.hasNext();) {
                    // output all right tuple 
                    Tuple<Node> tuple = newEmptyTuple(resultSchema);

                    Tuple<Node> leftTuple = left.next();
                    for (int i = 0; i < leftTuple.size(); ++i)
                        tuple.set(resultSchema.getNodeIndex(leftSchema.get(i).getName()), leftTuple
                                .get(i));

                    result.add(tuple);
                }
                return result;
            }

            Tuple<Node> leftTuple = left.peekNext();
            Tuple<Node> rightTuple = right.peekNext();

            Node leftNode = leftTuple.getNode(joinNodeIndexOnLeft);
            Node rightNode = rightTuple.getNode(joinNodeIndexOnRight);

            if (leftNode.nodeID == rightNode.nodeID) {
                // output all right tuple 
                Tuple<Node> tuple = newEmptyTuple(resultSchema);

                for (int i = 0; i < leftTuple.size(); ++i)
                    tuple.set(resultSchema.getNodeIndex(leftSchema.get(i).getName()), leftTuple
                            .get(i));
                for (int i = 1; i < rightTuple.size(); ++i)
                    tuple.set(resultSchema.getNodeIndex(rightSchema.get(i).getName()), rightTuple
                            .get(i));

                result.add(tuple);

                // proceed for both
                left.next();
                right.next();
            }
            else if (rightNode.nodeID < leftNode.nodeID) {
                // output right only
                Tuple<Node> tuple = newEmptyTuple(resultSchema);

                for (int i = 0; i < rightTuple.size(); ++i)
                    tuple.set(resultSchema.getNodeIndex(rightSchema.get(i).getName()), rightTuple
                            .get(i));

                result.add(tuple);
                right.next();
            }
            else {
                // output left only
                Tuple<Node> tuple = newEmptyTuple(resultSchema);

                for (int i = 0; i < leftTuple.size(); ++i)
                    tuple.set(resultSchema.getNodeIndex(leftSchema.get(i).getName()), leftTuple
                            .get(i));

                result.add(tuple);
                left.next();
            }

        }

    }

    public static Tuple<Node> newEmptyTuple(Schema schema) {
        Tuple<Node> tuple = new Tuple<Node>(schema.size());
        for (int i = 0; i < schema.size(); ++i) {
            Schema sub = schema.get(i);
            if (sub.isAtom())
                tuple.add(null);
            else {
                tuple.add(newEmptyTuple(sub));
            }
        }
        return tuple;
    }

    public static TupleContainer projectOneNode(TupleContainer input, String projectNode) {
        TupleIndex projectNodeIndex = input.getSchema().getNodeIndex(projectNode);
        Schema resultSchema = new SchemaBuilder().add(projectNode).build();

        TupleContainer result = new TupleContainer(resultSchema);
        for (Tuple<Node> each : input) {
            Tuple<Node> t = new Tuple<Node>(1);
            t.add(each.get(projectNodeIndex));
            result.add(t);
        }
        return result;
    }

    public static TupleContainer leftSemiJoin(TupleCursor left, String joinNode, TupleCursor right) {
        TupleContainer result = new TupleContainer(right.getSchema());
        _logger.debug(String.format("join: %s and %s on %s", left.getSchema(), right.getSchema(),
                joinNode));

        //        Relation resultRelation = joinedRelation(left.getRelation(), right.getRelation(), joinNode);

        final TupleIndex joinNodeIndexOnLeft = left.getSchema().getNodeIndex(joinNode);
        final TupleIndex joinNodeIndexOnRight = right.getSchema().getNodeIndex(joinNode);

        if (joinNodeIndexOnLeft == null || joinNodeIndexOnRight == null
                || joinNodeIndexOnRight.get(0) != 0)
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format(
                    "invalid join %s join %s on %s", left.getSchema(), right.getSchema(), joinNode));

        // left and right relations must be sorted in the order of join node
        for (; left.hasNext();) {
            Tuple<Node> each = left.next();
            Node leftNode = each.getNode(joinNodeIndexOnLeft);

            for (; right.hasNext(); right.next()) {
                Tuple<Node> rightTuple = right.peekNext();
                Node rightNode = rightTuple.getNode(joinNodeIndexOnRight);
                if (rightNode.nodeID < leftNode.nodeID) {
                    continue;
                }
                else if (rightNode.nodeID == leftNode.nodeID) {
                    result.add(rightTuple);
                }
                else {
                    // exceed the left
                    break;
                }
            }

        }

        return result;
    }

    //    public static void leftJoin(RelationInputCursor left, String joinNode, RelationInputCursor right,
    //            RelationOutputCursor out)
    //    {
    //        _logger.debug(String.format("join: %s and %s on %s", left.getTupleSchema(), right.getTupleSchema(), joinNode));
    //
    //        //        Relation resultRelation = joinedRelation(left.getRelation(), right.getRelation(), joinNode);
    //
    //        final int joinNodeIndexOnLeft = left.getTupleSchema().getNodeIndex(joinNode);
    //        final int joinNodeIndexOnRight = right.getTupleSchema().getNodeIndex(joinNode);
    //
    //        if (joinNodeIndexOnLeft == -1 || joinNodeIndexOnRight != 0)
    //            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("invalid join %s join %s on %s", left
    //                    .getTupleSchema(), right.getTupleSchema(), joinNode));
    //
    //        final int relationSize = out.getTupleSchema().getTupleSize();
    //
    //        // left and right relations must be sorted in the order of join node
    //        int rightIndex = 0;
    //        for (; left.hasNext();)
    //        {
    //            NodeTuple each = left.next();
    //            XMLNode leftNode = each.get(joinNodeIndexOnLeft);
    //
    //            for (; right.hasNext(); right.next())
    //            {
    //                NodeTuple rightTuple = right.peekNext();
    //                XMLNode rightNode = rightTuple.get(joinNodeIndexOnRight);
    //                if (rightNode.nodeID < leftNode.nodeID)
    //                {
    //                    continue;
    //                }
    //                else if (rightNode.nodeID == leftNode.nodeID)
    //                {
    //                    // output the result
    //                    NodeTuple resultRow = new NodeTuple(relationSize);
    //                    for (int k = 0; k < each.size(); ++k)
    //                        resultRow.add(each.get(k));
    //
    //                    for (int k = 0; k < rightTuple.size(); ++k)
    //                    {
    //                        if (k == joinNodeIndexOnRight)
    //                            continue;
    //                        resultRow.add(rightTuple.get(k));
    //                    }
    //
    //                    out.add(resultRow);
    //                }
    //                else
    //                {
    //                    // exceed the left
    //                    break;
    //                }
    //            }
    //
    //        }
    //
    //    }
}

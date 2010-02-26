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
// Xerial Raquel Project
//
// SchemaMapping.java
// Since: Mar 16, 2009 12:08:24 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/schema/SchemaMapping.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Schema mapping
 * 
 * @author leo
 * 
 */
public class SchemaMapping {
    private Map<String, Integer> cardinalityTable;
    private XMLSkeltonNode skelton;

    public SchemaMapping(Map<String, Integer> cardinalityTable, XMLSkeltonNode skelton) {
        this.cardinalityTable = cardinalityTable;
        this.skelton = skelton;
    }

    public Schema alternativeXMLStructure(Schema schema) {
        Schema current = schema;
        int pullUpTargetIndex = -1;
        while ((pullUpTargetIndex = findPullUpTargetIndex(current)) != -1) {
            current = pullUp(current, pullUpTargetIndex);
        }

        List<Schema> altStructure = new ArrayList<Schema>(current.size());
        for (int i = 0; i < current.size(); ++i) {
            Schema sub = current.get(i);
            if (sub.isTuple()) {
                altStructure.add(alternativeXMLStructure(sub));
            }
            else
                altStructure.add(sub);
        }

        SchemaBuilder builder = new SchemaBuilder();
        builder.setFD(schema.getFD());
        for (Schema each : altStructure) {
            builder.add(each);
        }

        return builder.build();
    }

    private int findPullUpTargetIndex(Schema schema) {
        int targetIndex = -1;
        int minCard = Integer.MAX_VALUE;
        int numLargerOrEqualCardNodes = 0;

        for (int i = 0; i < schema.size(); ++i) {
            Schema e = schema.get(i);
            if (e.isAtom()) {
                String nodeName = e.getName();
                if (skelton.hasManyNode(nodeName))
                    continue;

                Integer card = cardinalityTable.get(e.getName());
                if (card == null)
                    continue;

                if (card == 0) {
                    numLargerOrEqualCardNodes++;
                    continue;
                }

                if (card == minCard) {
                    numLargerOrEqualCardNodes++;
                }
                else if (card < minCard) {
                    targetIndex = i;
                    minCard = card;
                    numLargerOrEqualCardNodes++;
                }
            }
        }

        if (targetIndex == 0)
            targetIndex = -1;

        return targetIndex;
    }

    private static Schema pullUp(Schema schema, int index) {
        SchemaBuilder builder = new SchemaBuilder();
        builder.setFD(schema.getFD());
        Schema newRoot = schema.get(index);
        builder.add(newRoot);
        SchemaBuilder subBuilder = new SchemaBuilder();
        for (int i = 0; i < schema.size(); ++i) {
            if (i == index)
                continue;

            subBuilder.add(schema.get(i));
        }
        builder.add(subBuilder.build());
        return builder.build();
    }

}

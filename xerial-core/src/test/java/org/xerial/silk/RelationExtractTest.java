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
// RelationExtractTest.java
// Since: Jul 2, 2009 2:38:03 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.json.JSONLens;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class RelationExtractTest {
    private static Logger _logger = Logger.getLogger(RelationExtractTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    public static class Coordinate {
        public String name;
        public String species;

    }

    public static class GeneList {
        private List<Gene> geneList = new ArrayList<Gene>();

        public void add(Coordinate coordinate, Gene gene) {
            _logger.info(String.format("corrdinate %s, gene %s", JSONLens.toJSON(coordinate),
                    JSONLens.toJSON(gene)));
        }

        public void add(Gene g) {
            geneList.add(g);
        }

        public List<Gene> getGeneList() {
            return geneList;
        }

    }

    public static class Gene {
        public String name;
        public long start;
        public String strand;
        public String sequence;

    }

    @Test
    public void test() throws Exception {
        GeneList geneList = SilkLens.loadSilk(GeneList.class,
                FileResource.open(RelationExtractTest.class, "sequence.silk"));

        _logger.info(JSONLens.toJSON(geneList));
    }

}

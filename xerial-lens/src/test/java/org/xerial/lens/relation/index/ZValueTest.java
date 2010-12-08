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
// ZValueTest.java
// Since: Jul 8, 2009 11:42:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.index;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xerial.lens.SilkLens;
import org.xerial.util.FileResource;
import org.xerial.util.Pair;

public class ZValueTest
{

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void interleave() throws Exception {
        long z1 = ZValue.interleave(10, 30);
        long z2 = ZValue.interleave(24, 50);

        Pair<Integer, Integer> xy = ZValue.getPoint(z1);
        assertEquals(xy.getFirst().intValue(), 10);
        assertEquals(xy.getSecond().intValue(), 30);

        xy = ZValue.getPoint(z2);
        assertEquals(xy.getFirst().intValue(), 24);
        assertEquals(xy.getSecond().intValue(), 50);

    }

    public static class Locus
    {
        public int start;
        public int end;
    }

    public static class LocusQuery
    {
        int count = 0;

        public void addRead(Locus locus) {
            out(locus);
        }

        private void out(Locus locus) {
            long zvalue = ZValue.interleave(locus.start, locus.end);
            int color = (count++ / 50) % 10;
            System.out.println(String.format("%d\t%d\t%d\t%s", zvalue, locus.start, locus.end, color));
        }
    }

    @Ignore
    @Test
    public void plot() throws Exception {

        System.out.println("zvalue\tstart\tend\tcolor");
        SilkLens.loadSilk(LocusQuery.class, FileResource.find(ZValueTest.class, "../../silk/scaffold5001.silk"));

    }

}

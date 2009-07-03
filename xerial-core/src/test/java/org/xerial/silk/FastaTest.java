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
// FastaTest.java
// Since: Jul 3, 2009 7:11:49 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.Lens;
import org.xerial.lens.ObjectLens;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE, ElementType.METHOD })
@interface EqJoin {

    public String[] left();

    public String[] right();

    public Class< ? > leftClass();

}

public class FastaTest
{
    private static Logger _logger = Logger.getLogger(FastaTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public static class FastaQuery
    {
        FastaItem prev = null;

        public void addGroup_Name(String group, FastaItem f)
        {
            _logger.info(String.format("group: %s, fasta: %s", group, ObjectLens.toJSON(f)));
        }

        public void addName(FastaItem f)
        {
            _logger.debug(ObjectLens.toJSON(f));

            if (prev != null && prev.getSequence().contains("TTAGGG"))
            {
                // output both records
            }

            if (f.getSequence().contains("TTAGGG"))
            {

            }

            prev = f;

        }

        public void flush()
        {

        }

    }

    public static class S1
    {
        public int id;
        public String name;

        public int getRid()
        {
            return id - 1;
        }

    }

    public static class S2
    {
        public int rid;
        public String info;
    }

    @EqJoin(left = "rid", leftClass = S1.class, right = "rid")
    public static class S3
    {
        public S1 s1;

        public List<S2> s2;

    }

    public static class FastaItem
    {
        public String value;
        public String link;

        private StringBuilder sequence = new StringBuilder();

        public void appendSequence(String s)
        {
            sequence.append(s);
        }

        public String getSequence()
        {
            return sequence.toString();
        }

    }

    @Test
    public void testname() throws Exception
    {
        FastaQuery result = Lens.loadSilk(FastaQuery.class, FileResource.open(FastaTest.class, "fasta.silk"));
        result.flush();

        //ObjectStream<S3> sin = Lens.joinSilk(S3.class, "input1", "input2");

        //ObjectStream<S4> out = Lens.joinSilk(S4.class, sin, "input3");

    }

}

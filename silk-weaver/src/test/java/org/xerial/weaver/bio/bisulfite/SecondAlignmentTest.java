/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// SecondAlignmentTest.java
// Since: 2010/03/16 21:56:25
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.bio.bisulfite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.utgenome.format.sam.SAM2SilkReader;
import org.utgenome.format.sam.SAMEntry;
import org.xerial.lens.Lens;
import org.xerial.lens.ObjectHandler;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class SecondAlignmentTest {

    private static Logger _logger = Logger.getLogger(SecondAlignmentTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void convert() throws Exception {
        SAM2SilkReader reader = new SAM2SilkReader(FileResource.open(SecondAlignmentTest.class,
                "bss-align.sam"));

        Lens.findFromSilk(reader, "record", SAMEntry.class, new ObjectHandler<SAMEntry>() {

            public void handle(SAMEntry input) throws Exception {
                _logger.info(Lens.toSilk(input));
            }
        });
    }

}

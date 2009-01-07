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
// RELStreamReaderTest.java
// Since: Jan 7, 2009 11:37:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.rel;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.rel.RelationStreamReader.Event;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class RelationStreamReaderTest
{
    private static Logger _logger = Logger.getLogger(RelationStreamReaderTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void read() throws IOException, XerialException
    {
        RelationStreamReader reader = new RelationStreamReader(FileResource.open(RelationStreamReaderTest.class,
                "sample.rel"));
        Event e;
        while ((e = reader.next()) != Event.END_OF_FILE)
        {
            _logger.debug(String.format("line=%3d, %15s(%d): %s", reader.getLineCount(), e.name(), reader
                    .getCurrentLevel(), reader.currentSchema()));
        }

    }
}

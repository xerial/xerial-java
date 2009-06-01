/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// XerialJ Project
//
// JSONArrayTest.java
// Since: May 8, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.json;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;

public class JSONArrayTest
{

    private static Logger _logger = Logger.getLogger(JSONArrayTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void constructor() throws JSONException
    {
        JSONArray array = new JSONArray("[1, 2, 3]");
        assertEquals(1, array.getJSONInteger(0).getIntValue());
        assertEquals(2, array.getJSONInteger(1).getIntValue());
        assertEquals(3, array.getJSONInteger(2).getIntValue());
    }

    @Test
    public void objectInAnArray() throws JSONException
    {
        JSONArray array = new JSONArray("[{\"id\":1, \"name\":\"leo\"}]");
        JSONObject p = array.getJSONObject(0);
        assertEquals(1, p.getInt("id"));
        assertEquals("leo", p.getString("name"));
    }

    @Test
    public void testParse() throws JSONException
    {
        // generate a sample JSON array
        StringBuilder sample = new StringBuilder();
        sample.append("[");
        int i = 0;
        for (; i < 1000; i++)
        {
            sample.append(i);
            sample.append(",");
        }
        sample.append(i);
        sample.append("]");

        String json = sample.toString();

        StopWatch timer = new StopWatch();
        for (int n = 0; n < 1000; n++)
        {
            JSONArray array = new JSONArray(json);
            assertEquals(1001, array.size());
        }
        _logger.info("time: " + timer.getElapsedTime());

        // i:1000, n:100   time=18.4 sec (2009.4.23 using ANTLR JSON.g)
        // i:1000, n:100   time=2.248 (2009. 4.23 using JSONTokener)

    }

}

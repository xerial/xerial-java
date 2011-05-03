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

public class JSONArrayTest {

    private static Logger _logger = Logger.getLogger(JSONArrayTest.class);

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void constructor() throws JSONException {
        JSONArray array = new JSONArray("[1, 2, 3]");
        assertEquals(1, array.getJSONInteger(0).getIntValue());
        assertEquals(2, array.getJSONInteger(1).getIntValue());
        assertEquals(3, array.getJSONInteger(2).getIntValue());
    }

    @Test
    public void objectInAnArray() throws JSONException {
        JSONArray array = new JSONArray("[{\"id\":1, \"name\":\"leo\"}]");
        JSONObject p = array.getJSONObject(0);
        assertEquals(1, p.getInt("id"));
        assertEquals("leo", p.getString("name"));
    }

    final int N = 5000;

    public String createSampleJSONArrayData() {
        // generate a sample JSON array
        StringBuilder sample = new StringBuilder();
        sample.append("[");
        int i = 0;

        for (; i < N - 1; i++) {
            sample.append(i);
            sample.append(",");
        }
        sample.append(i);
        sample.append("]");

        return sample.toString();
    }

    @Test
    public void testParse() throws JSONException {
        String json = createSampleJSONArrayData();
        StopWatch timer = new StopWatch();
        for (int n = 0; n < 500; n++) {
            JSONArray array = new JSONArray(json);
            assertEquals(N, array.size());
        }
        _logger.info("time: " + timer.getElapsedTime());

    }

    @Test
    public void populateFromPullParser() throws JSONException {
        String json = createSampleJSONArrayData();

        StopWatch timer = new StopWatch();
        for (int n = 0; n < 500; n++) {
            JSONArray array = new JSONArray(new JSONPullParser(json));
            assertEquals(N, array.size());
        }
        _logger.info("time: " + timer.getElapsedTime());

    }

}

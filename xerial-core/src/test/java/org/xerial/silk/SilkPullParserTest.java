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
// SilkPullParserTest.java
// Since: Jan 28, 2009 1:02:44 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;
import org.xerial.util.log.Logger;

public class SilkPullParserTest
{
    private static Logger _logger = Logger.getLogger(SilkPullParserTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public void pull(String silkFile) throws IOException, XerialException
    {
        SilkPullParser p = new SilkPullParser(FileResource.open(SilkPullParserTest.class, silkFile));

        while (p.hasNext())
        {
            SilkEvent e = p.next();
            _logger.debug(e);
        }
    }

    @Test
    public void testSmall() throws Exception
    {
        pull("small.silk");
    }

    @Test
    public void testFunc() throws Exception
    {
        pull("func.silk");
    }

    @Test
    public void testGeneSequence() throws Exception
    {
        pull("sequence.silk");
    }

    @Test
    public void testOutValue() throws Exception
    {
        pull("impl/outvalue.silk");
    }

    @Test
    public void testBarChart() throws Exception
    {
        pull("barchart.silk");
    }

    @Test
    public void testMicroFormat() throws Exception
    {
        pull("microformat.silk");
    }

    @Test
    public void testHeredoc() throws Exception
    {
        pull("heredoc.silk");
    }

    @Test
    public void testScaffold() throws Exception
    {
        pull("scaffold5001.silk");
    }

    @Test
    public void testSuzakuConfig() throws Exception
    {
        pull("suzaku-config.silk");
    }

    @Test
    public void testExample() throws Exception
    {
        pull("example.silk");
    }

    @Test
    public void testMicroformat() throws Exception
    {
        pull("microformat.silk");
    }

    @Test
    public void testTab() throws Exception
    {
        pull("tab.silk");
    }

    @Test
    public void testJSON() throws Exception
    {
        pull("json.silk");
    }

    @Test
    public void testType() throws Exception
    {
        pull("type.silk");
    }

    @Test
    public void testLoad() throws Exception
    {
        pull("plugin/load-binary.silk");
    }

    @Test
    public void testBED() throws Exception
    {
        pull("sample.bed.silk");
    }

}

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
// XerialJ
//
// TemplateTest.java
// Since: Jul 25, 2007 4:20:22 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.text;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void apply() {
        Template t = new Template("hello $name$!");
        Properties prop = new Properties();
        prop.put("name", "Leo");
        String result = t.apply(prop);
        assertEquals("hello Leo!", result);
    }

    @Test
    public void escape() throws Exception {

        Template t = new Template("hello $name$! \\$kept\\$");
        Properties prop = new Properties();
        prop.put("name", "Leo");
        prop.put("kept\\", "not preserved");
        String result = t.apply(prop);
        assertEquals("hello Leo! \\$kept\\$", result);

    }

    @Test
    public void multiline() throws Exception {
        Template t = new Template("Hello $name$!\n Hello $name$ $name$ \n Good Job!");
        Properties prop = new Properties();
        prop.put("name", "Leo");
        String result = t.apply(prop);
        assertEquals("Hello Leo!\n Hello Leo Leo \n Good Job!", result);

    }

}

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
// ANTLRMojoTest.java
// Since: Sep 15, 2007 9:13:19 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.maven.plugin.antlr.test;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.xerial.maven.plugin.antlr.ANTLRMojo;

public class ANTLRMojoTest extends AbstractMojoTestCase
{

    public void setUp() throws Exception
    {
        super.setUp();
    }

    public void tearDown() throws Exception
    {}

    public void testGenerate() throws Exception
    {
        //        String testFolderName = "target/antlr-test";
        //        File testFolder = new File(getBasedir(), testFolderName);
        //        testFolder.mkdirs();
        //
        //        String grammarFile = "Test.g";
        //        
        //        getResourceAsStream(grammarFile);

        File outputDir = new File(getBasedir(), "src/test/java/org/xerial/maven/plugin/antlr/test");
        try
        {
            File testPom = new File(getBasedir(), "src/test/resources/test-config.xml");
            ANTLRMojo mojo = (ANTLRMojo) lookupMojo("generate", testPom);
            assertNotNull(mojo);
            mojo.execute();

            assertTrue(new File(outputDir, "TestLexer.java").exists());
            assertTrue(new File(outputDir, "TestParser.java").exists());
            assertTrue(new File(outputDir, "Test.tokens").exists());

        }
        finally
        {
            new File(outputDir, "TestLexer.java").delete();
            new File(outputDir, "TestParser.java").delete();
            new File(outputDir, "Test.tokens").delete();
        }

    }
}

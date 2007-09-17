/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// StemmerTest.java
// Since: 2005/05/31
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.text;

import junit.framework.TestCase;

public class StemmerTest extends TestCase
{
    public void testStemmer()
    {
         Stemmer stemmer = new Stemmer();
         String c1 = stemmer.stem("connect");
         String c2 = stemmer.stem("connected");
         String c3 = stemmer.stem("connection");
         String c4 = stemmer.stem("connections");
         assertTrue(c1.equals(c2));
         assertTrue(c2.equals(c3));
         assertTrue(c3.equals(c4));         
         
         String a1 = stemmer.stem("abbreviated");
         String a2 = stemmer.stem("abbreviation");
         String a3 = stemmer.stem("abbreviate");
         
         assertTrue(a1.equals(a2));
         assertTrue(a2.equals(a3));

    }
}





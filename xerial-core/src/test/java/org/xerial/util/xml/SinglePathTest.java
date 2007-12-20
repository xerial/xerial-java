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
// XerialJ
//
// SinglePathTest.java
// Since: 2004/12/27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import junit.framework.TestCase;
import static org.xerial.util.xml.SinglePath.PathType.*;

/**
 * @author leo
 *
 */
public class SinglePathTest extends TestCase
{
    public void testConstructor()
    {
        new SinglePath(AbsolutePath);
        new SinglePath("/book/author");
    }
    
    public void testPathComparator()
    {
        SinglePath p1 = new SinglePath("/book/author");
        SinglePath p2 = new SinglePath(p1, "title");
        assertTrue(p1.compareTo(p2) < 0);
        p2.removeLastChild();
        assertTrue(p1.compareTo(p2) == 0);
        
    }
}





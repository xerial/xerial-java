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
// InvertedPathTest.java
// Since: 2005/06/02
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.xml.index;

import org.xerial.xml.index.InvertedPath;

import junit.framework.TestCase;

public class InvertedPathTest extends TestCase
{
    public void testInvertedPath()
    {
        InvertedPath p1 = new InvertedPath();
        p1.addParent("author");
        p1.addParent("book");
        p1.addParent("booklist");
        String[] tagList = {"author", "book", "booklist"};
        int index = 0;
        for(String s : p1)
            assertEquals(tagList[index++], s);
        
        InvertedPath p2 = new InvertedPath("author.book.booklist");
        assertTrue(p1.equals(p2));
        
                
    }
    public void testComparator()
    {
        InvertedPath p1 = new InvertedPath("author.book.booklist");
        InvertedPath p2 = new InvertedPath("author.book");
        assertTrue(p1.compareTo(p2) > 0);
        p2.addParent("booklist");
        assertTrue(p1.compareTo(p2) == 0);
    }
}





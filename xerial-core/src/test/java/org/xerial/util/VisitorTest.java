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
// VisitorTest.java
// Since: Apr 15, 2009 2:09:32 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.util.log.Logger;

public class VisitorTest
{
    private static Logger _logger = Logger.getLogger(VisitorTest.class);

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    public static interface FileObject extends AcceptVisitor<MyVisitor, FileObject>
    {

    }

    public static class File implements FileObject
    {
        String name;

        public File(String name)
        {
            this.name = name;
        }

        public void accept(MyVisitor visitor)
        {
            visitor.visit(this);
        }

        public String toString()
        {
            return name;
        }

    }

    public static class Directory implements FileObject
    {
        String name;
        List<FileObject> children = new ArrayList<FileObject>();

        public Directory(String name)
        {
            this.name = name;
        }

        public void accept(MyVisitor visitor)
        {
            visitor.visit(this);
        }

        public Directory add(Directory fileObj)
        {
            children.add(fileObj);
            return fileObj;
        }

        public File add(File fileObj)
        {
            children.add(fileObj);
            return fileObj;
        }

        public String toString()
        {
            return name;
        }

    }

    public static class MyVisitor implements Visitor<MyVisitor, FileObject>
    {
        public void visit(File file)
        {
            _logger.debug("visit file: " + file);
        }

        public void visit(Directory dir)
        {
            _logger.debug("visit dir: " + dir);
            for (FileObject each : dir.children)
                each.accept(this);
            _logger.debug("leave dir: " + dir);
        }
    }

    @Test
    public void testVisitor()
    {
        MyVisitor visitor = new MyVisitor();

        Directory d = new Directory("root");
        d.add(new Directory("child")).add(new File("sample"));
        d.add(new File("sample2"));

        d.accept(visitor);

    }

}

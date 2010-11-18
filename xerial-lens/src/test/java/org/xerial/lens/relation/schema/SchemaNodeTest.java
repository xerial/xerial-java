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
// SchemaNodeTest.java
// Since: May 14, 2009 11:51:53 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.lens.relation.DataType;

public class SchemaNodeTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void objectSerialization() throws Exception {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);

        SchemaNode s = new SchemaNode("id", DataType.INTEGER);
        out.writeObject(s);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SchemaNode s2 = (SchemaNode) in.readObject();

        assertEquals(s.name, s2.name);
        assertEquals(s.type, s2.type);
    }

    @Test
    public void overcomeFinal() throws Exception {
        SchemaNode s = new SchemaNode("id", DataType.INTEGER);
        Field f = s.getClass().getField("name");
        f.setAccessible(true);
        f.set(s, "hello");

        assertEquals("hello", s.name);

    }

}

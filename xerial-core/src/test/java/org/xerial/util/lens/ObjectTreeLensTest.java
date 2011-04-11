/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// ObjectTreeLensTest.java
// Since: 2011/03/28 13:51:04
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.lens;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.xerial.util.lens.ObjectTreeLens.TreeWriter;
import org.xerial.util.log.Logger;

public class ObjectTreeLensTest {

    private static Logger _logger = Logger.getLogger(ObjectTreeLensTest.class);

    public static class Person {
        public int id;
        public String name;
        public List<String> address = new ArrayList<String>();

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }

    @Test
    public void test() throws Exception {

        ObjectTreeLens lens = new ObjectTreeLens(new TreeWriter() {

            @Override
            public void objectSchema(Class< ? > schema) {
                _logger.info(schema);
            }

            @Override
            public void openScope(String nodeName) {
                _logger.info("open scope: " + nodeName);
            }

            @Override
            public void leaf(String nodeName, Object nodeValue) {
                _logger.info(String.format("leaf:%s, value=%s", nodeName, nodeValue));
            }

            @Override
            public void text(String text) {
                _logger.info(String.format("text: %s", text));
            }

            @Override
            public void closeScope(String nodeName) {
                _logger.info("close scope:" + nodeName);
            }
        });

        Person person = new Person(1, "leo");
        person.address.add("xxx xxxx");
        person.address.add("yyy yyyy");

        Person person2 = new Person(2, "yui");
        person2.address.add("zzzz zzzzzz");

        List<Person> plist = new ArrayList<Person>();
        plist.add(person);
        plist.add(person2);

        lens.toSilk(plist);

    }
}

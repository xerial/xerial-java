/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// TypeConverterTest.java
// Since: 2008/10/27 17:24:23
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.TypeConverter;
import org.xerial.util.log.Logger;

public class TypeConverterTest {
    private static Logger _logger = Logger.getLogger(TypeConverterTest.class);

    enum Animal {
        CAT, DOG, PIG
    }

    @Test
    public void enumConversion() {
        Animal cat = TypeConverter.convertToEnum(Animal.class, "CAT");
        assertEquals(Animal.CAT, cat);
        Animal dog = TypeConverter.convertToEnum(Animal.class, "DOG");
        assertEquals(Animal.DOG, dog);
        Animal pig = TypeConverter.convertToEnum(Animal.class, "PIG");
        assertEquals(Animal.PIG, pig);
    }

    @Test
    public void enumConversion2() throws XerialException {
        Animal cat = TypeConverter.convertType(Animal.class, "CAT");
        assertEquals(Animal.CAT, cat);
        Animal dog = TypeConverter.convertType(Animal.class, "DOG");
        assertEquals(Animal.DOG, dog);
        Animal pig = TypeConverter.convertType(Animal.class, "PIG");
        assertEquals(Animal.PIG, pig);
    }

    @Test
    public void invalidEnumConversion() {
        try {
            Animal cow = TypeConverter.convertToEnum(Animal.class, "COW");
            fail("cannot reach here");
        }
        catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void tryCapitalizeInputForEnumConversion() throws XerialException {
        Animal cat = TypeConverter.convertType(Animal.class, "cat");
        assertEquals(Animal.CAT, cat);
        Animal dog = TypeConverter.convertType(Animal.class, "doG");
        assertEquals(Animal.DOG, dog);
        Animal pig = TypeConverter.convertType(Animal.class, "Pig");
        assertEquals(Animal.PIG, pig);
    }

    @Test
    public void fileType() throws Exception {
        File f = TypeConverter.convertType(File.class, "folder/sample.txt");
        assertEquals(f.getPath(), new File("folder/sample.txt").getPath());
    }

    @Test
    public void date() throws Exception {
        Date now = new Date();
        DateFormat dt = DateFormat.getDateTimeInstance();
        String dtString = dt.format(now);
        Date d = TypeConverter.convertType(Date.class, dtString);

        assertTrue(now.compareTo(d) >= 0);

    }
}

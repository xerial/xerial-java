/*--------------------------------------------------------------------------
 *  Copyright 2008 utgenome.org
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
// utgb-core Project
//
// ObjectSchemaTest.java
// Since: Jan 5, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.rel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;

public class ObjectSchemaTest
{

    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void testParseSchemaLine() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine("> gene(name:NM_00051, start, end)");
        assertNotNull(schema);
        assertEquals(1, schema.getLevel());
        assertEquals("gene", schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(3, attributeList.size());
        assertEquals("name", attributeList.get(0).getName());
        assertEquals("NM_00051", attributeList.get(0).getValue());

        assertEquals("start", attributeList.get(1).getName());
        assertNull(attributeList.get(1).getValue());

        assertEquals("end", attributeList.get(2).getName());
        assertNull(attributeList.get(2).getValue());

    }

    @Test
    public void testParseSchemaLine2() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine(">> gene(name:  utgb.chromosome , start, end)");
        assertNotNull(schema);
        assertEquals(2, schema.getLevel());
        assertEquals("gene", schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(3, attributeList.size());
        assertEquals("name", attributeList.get(0).getName());
        assertEquals("utgb.chromosome", attributeList.get(0).getValue());

        assertEquals("start", attributeList.get(1).getName());
        assertNull(attributeList.get(1).getValue());

        assertEquals("end", attributeList.get(2).getName());
        assertNull(attributeList.get(2).getValue());

    }

    @Test
    public void testDataType() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine("> gene(fasta[string]>)");
        assertNotNull(schema);
        assertEquals(1, schema.getLevel());
        assertEquals("gene", schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(1, attributeList.size());
        assertEquals("fasta", attributeList.get(0).getName());
        assertEquals(Occurrence.SEQUENCE, attributeList.get(0).getOccurrence());
        assertEquals("string", attributeList.get(0).getDataType());

    }

    @Test
    public void testDataType2() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine("> gene(fasta[gzip/base64]>)");
        assertNotNull(schema);
        assertEquals(1, schema.getLevel());
        assertEquals("gene", schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(1, attributeList.size());
        assertEquals("fasta", attributeList.get(0).getName());
        assertEquals(Occurrence.SEQUENCE, attributeList.get(0).getOccurrence());
        assertEquals("gzip/base64", attributeList.get(0).getDataType());

    }

    @Test
    public void testAttribute() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine("- sequence[gzip/base64]>");
        assertNotNull(schema);
        assertEquals(0, schema.getLevel());
        assertEquals(true, schema.isAttribute());
        assertEquals(null, schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(1, attributeList.size());
        assertEquals("sequence", attributeList.get(0).getName());
        assertEquals(Occurrence.SEQUENCE, attributeList.get(0).getOccurrence());
        assertEquals("gzip/base64", attributeList.get(0).getDataType());

    }

    @Test
    public void testNestedObjects() throws XerialException
    {
        ObjectSchema schema = ObjectSchema.parseSchemaLine("> gene(name, cds(start,end), exon(start, end)*)");
        assertNotNull(schema);
        assertEquals(1, schema.getLevel());
        assertEquals("gene", schema.getName());
        List<SchemaElement> attributeList = schema.getSchemaElementList();
        assertEquals(3, attributeList.size());

        assertEquals("name", attributeList.get(0).getName());
        assertEquals(Occurrence.ONE, attributeList.get(0).getOccurrence());
        assertEquals(true, attributeList.get(0).isAttribute());
        assertEquals(false, attributeList.get(0).isObject());

        assertEquals("cds", attributeList.get(1).getName());
        assertEquals(Occurrence.ONE, attributeList.get(1).getOccurrence());
        assertEquals(false, attributeList.get(1).isAttribute());
        assertEquals(true, attributeList.get(1).isObject());
        ObjectSchema cdsSchema = ObjectSchema.class.cast(attributeList.get(1));
        assertEquals(2, cdsSchema.getSchemaElementList().size());
        ObjectAttribute a1 = ObjectAttribute.class.cast(cdsSchema.getSchemaElementList().get(0));
        assertEquals("start", a1.getName());
        ObjectAttribute a2 = ObjectAttribute.class.cast(cdsSchema.getSchemaElementList().get(1));
        assertEquals("end", a2.getName());

        assertEquals("exon", attributeList.get(2).getName());
        assertEquals(Occurrence.ZERO_OR_MORE, attributeList.get(2).getOccurrence());
        assertEquals(false, attributeList.get(2).isAttribute());
        assertEquals(true, attributeList.get(2).isObject());
        ObjectSchema exonSchema = ObjectSchema.class.cast(attributeList.get(2));
        assertEquals(2, exonSchema.getSchemaElementList().size());
        ObjectAttribute e1 = ObjectAttribute.class.cast(exonSchema.getSchemaElementList().get(0));
        assertEquals("start", e1.getName());
        ObjectAttribute e2 = ObjectAttribute.class.cast(exonSchema.getSchemaElementList().get(1));
        assertEquals("end", e2.getName());

    }
}

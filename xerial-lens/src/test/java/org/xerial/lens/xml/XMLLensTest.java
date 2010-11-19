/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// XMLLensTest.java
// Since: 2010/11/18 16:46:05
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.xml;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.lens.XMLLens;
import org.xerial.util.FileResource;
import org.xerial.util.bean.sample.Mate;
import org.xerial.util.bean.sample.Person;
import org.xerial.util.bean.sample.PersonVector;
import org.xerial.util.bean.sample.TrackInfo;
import org.xerial.util.log.Logger;

public class XMLLensTest
{

    private static Logger _logger = Logger.getLogger(XMLLensTest.class);

    public static class PropertyData
    {
        HashMap<String, String> map = new HashMap<String, String>();

        public void putProperty(String key, String value) {
            map.put(key, value);
        }
    }

    @Test
    public void putterTestForXML() throws Exception {
        PropertyData data = XMLLens.createXMLBean(PropertyData.class, FileResource.open(XMLLensTest.class, "prop.xml"));
        assertEquals("value1", data.map.get("key1"));
        assertEquals("hello", data.map.get("message"));

    }

    @Test
    public void beanToXML() throws XerialException {
        PersonVector pv = new PersonVector();
        pv.add(new Person(1, "leo"));
        pv.add(new Person(2, "taro"));
        String xml = XMLLens.toXML("person", pv);
        _logger.debug(xml);

        Person[] pair1 = { new Person(1, "leo"), new Person(2, "naoko") };
        Person[] pair2 = { new Person(3, "json"), new Person(4, "xml") };

        Mate m1 = new Mate();
        m1.putPair(pair1[0], pair1[1]);
        m1.putPair(pair2[0], pair2[1]);
        String xml2 = XMLLens.toXML("mate", m1);
        _logger.debug(xml);
        _logger.debug(xml2);

        assertTrue(true);
    }

    @Ignore
    @Test
    public void beanToXML2() throws XerialException {
        TrackInfo t = new TrackInfo("sample track", false);
        t.putProperty("species", "human");
        t.putProperty("revision", "hg18");

        String xml = XMLLens.toXML("track-info", t);
        _logger.debug(xml);

        TrackInfo t2 = new TrackInfo();
        XMLLens.populateBeanWithXML(t2, xml);
        _logger.debug(XMLLens.toXML("track-info", t2));

        assertEquals(t.getName(), t2.getName());
        assertEquals(t.getPack(), t2.getPack());
        assertEquals(t.getProperty().get("species"), t2.getProperty().get("species"));
        assertEquals(t.getProperty().get("revision"), t2.getProperty().get("revision"));
    }

    public static class DASFeature
    {
        public DASGFF  gff;
        public Segment segment;

    }

    public static class DASGFF
    {
        public String version;
        public String href;

    }

    public static class Segment
    {
        public String        id;
        public long          start;
        public long          stop;
        public List<Feature> feature;
    }

    public static class Feature
    {
        public String      id;
        public long        start;
        public long        end;

        public String      score;
        public String      orientation;

        public Method      method;
        public FeatureType type;
        public Group       group;
        public Target      target;

    }

    public static class Target
    {
        public String id;
        public long   start;
        public long   stop;
    }

    public static class FeatureType
    {
        public String id;
        public String category;
        public String value;

    }

    public static class Group
    {
        public String id;
        public String type;
        public String label;
        public Link   link;

    }

    public static class Link
    {
        public String href;
        public String value;
    }

    public static class Method
    {
        public String id;
        public String value;
    }

    /*
     * <pre>
    <SEGMENT id="13" start="1800000" stop="18100000"> 
    <FEATURE id="ENSE00001471274"> 
    <START>17957458</START> 
    <END>17957578</END> 
    <TYPE id="exon:coding:ensembl" category="transcription">exon:coding:ensembl</TYPE> 
    <METHOD id="ensembl">ensembl</METHOD> 
    <SCORE>-</SCORE> 
    <ORIENTATION>-</ORIENTATION> 
    <GROUP id="ENST00000342944" type="transcript:ensembl" label="ENST00000342944 (AL138715.11-201)"> 
      <LINK href="http://www.ensembl.org/Homo_sapiens/Transcript/Summary?t=ENST00000342944;db=core">TransView ENST00000342944</LINK> 
    </GROUP> 
    <TARGET id="ENST00000342944" start="1" stop="121" /> 
    </FEATURE> 
    </SEGMENT> 
    </pre>
     */
    @Test
    public void dasTest() throws Exception {
        DASFeature das = XMLLens.loadXML(DASFeature.class, FileResource.find(XMLLensTest.class, "das.xml"));
        assertEquals(1, das.segment.feature.size());
        Feature f = das.segment.feature.get(0);
        _logger.debug(das);
        assertEquals("ENSE00001471274", f.id);
        assertEquals(17957458L, f.start);
        assertEquals(17957578L, f.end);
        assertEquals("-", f.score);
        assertEquals("-", f.orientation);
        Target t = f.target;
        assertEquals("ENST00000342944", t.id);
        assertEquals(1L, t.start);
        assertEquals(121L, t.stop);

    }
}

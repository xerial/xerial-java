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
// Lens.java
// Since: Feb 23, 2009 5:50:49 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import org.antlr.runtime.tree.Tree;
import org.xerial.core.XerialException;
import org.xerial.json.JSONPushParser;
import org.xerial.silk.SilkParser;
import org.xerial.util.bean.ANTLRTreeParser;
import org.xerial.util.bean.MapParser;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.tree.TreeParser;
import org.xerial.util.xml.XMLTreeParser;

/**
 * Lens is an O-X mapping utility. O stands for Objects, and X for structured
 * data including XML, JSON, Silk, etc.
 * 
 * <p>
 * gene.silk
 * </p>
 * 
 * <pre>
 * -coordinate(group:utgb, species:human, revision:hg18, name:chr1)
 *  - gene
 *   -id: 1
 *   -name: gene1
 *   -start: 100
 *   -sequence: ACGGTTAGCGTATT
 * -coordinate(group:utgb, species:human, revision:hg18, name:chr2)
 *  - gene
 *   -id: 2
 *   -name: gene2
 *   -start: 250
 *   -exon(start, end)*: [[250, 255], [260, 265]]  
 *   -sequence: TAGCGTATTAAATT
 * </pre>
 * 
 * <p>
 * gene-alt.silk (Alternative data description)
 * </p>
 * 
 * <pre>
 * -(group:utgb, species:human, revision:hg18)
 *  - coordinate(name:chr1)
 *   - gene(id:1, name: gene1, start: 100, sequence: ACGGTTAGCGTATT)
 *  -coordinate(name:chr2)
 *   - gene(id:2, name: gene2, start: 250, exon(start, end): [[250, 255], [260, 265]], sequence: TAGCGTATTAAATT)
 * </pre>
 * 
 * <pre>
 * class Coordinate
 * {
 *     public String group;
 *     public String species;
 *     public String revision;
 *     public String name;
 * }
 * 
 * class Gene
 * {
 *     public int id;
 *     public String name;
 *     public long start;
 *     public String sequence;
 *     public List&lt;Exon&gt; exonList;
 * }
 * 
 * class Exon
 * {
 *     public start;
 *     public end;
 * }
 * 
 * </pre>
 * 
 * 
 * <p>
 * Query Class
 * </p>
 * 
 * <pre>
 * class GeneList
 * {
 *     // map of List value type corresponds to two-argument adder 
 *     public Map&lt;Coordinate, List&lt;Gene&gt;&gt; geneTable;
 * 
 *     // for adding unknown parameters 
 *     public Map&lt;String, String&gt; properties;
 * 
 * }
 * 
 * </pre>
 * 
 * <pre>
 * class GeneList
 * {
 * 
 *     // map of List value type corresponds to two-argument adder 
 *     public Map&lt;Coordinate, List&lt;Gene&gt;&gt; geneTable;
 * 
 *     // add gene to the geneList table (if you use public Map field, no need to write the following method)
 *     public void add(Coordinate coordinate, Gene gene)
 *     {
 *         List&lt;Gene&gt; geneList = geneTable.get(coordinate);
 *         if (geneList == null)
 *         {
 *             geneList = new ArrayList&lt;Gene&gt;();
 *             geneTable.put(coordinate, geneList);
 *         }
 * 
 *         geneList.add(gene);
 *     }
 * 
 *     // for adding unknown parameters 
 *     public Map&lt;String, String&gt; properties;
 * 
 *     public void put(String key, String value)
 *     {
 *         this.properties.put(key, value);
 *     }
 * 
 * }
 * 
 * </pre>
 * 
 * 
 * @author leo
 * 
 */
public class Lens
{

    /**
     * Translate the specified Silk file into an instance of the target object.
     * 
     * @param <Result>
     * @param silkFileResource
     *            resource path to the input Silk file
     * @param targetClass
     *            target class to which the input Silk format will be converted
     * 
     * @return translated object of the targetClass type
     * @throws IOException
     *             when failed to read resources
     * @throws XerialException
     *             when failed to parse the input Silk file
     */
    public static <Result> Result loadSilk(Class<Result> targetType, URL silkResource) throws IOException,
            XerialException
    {
        return loadSilk(TypeInfo.createInstance(targetType), silkResource);
    }

    public static <Result> Result loadSilk(Result result, URL silkResource) throws IOException, XerialException
    {
        if (silkResource == null)
            throw new NullPointerException("silk resouce is null");

        return load(result, new SilkParser(silkResource));
    }

    public static <Result> Result loadSilk(Result result, Reader silkReader) throws XerialException, IOException
    {
        return load(result, new SilkParser(silkReader));
    }

    public static <Result> Result loadSilk(Class<Result> resultType, Reader silkReader) throws XerialException,
            IOException
    {
        return loadSilk(TypeInfo.createInstance(resultType), silkReader);
    }

    public static <Result> Result loadXML(Result result, URL xmlResource) throws IOException, XerialException
    {
        if (xmlResource == null)
            throw new NullPointerException("XML resource is null");

        return load(result, new XMLTreeParser(new BufferedReader(new InputStreamReader(xmlResource.openStream()))));
    }

    public static <Result> Result loadXML(Class<Result> result, URL xmlResource) throws IOException, XerialException
    {
        return loadXML(TypeInfo.createInstance(result), xmlResource);
    }

    public static <Result> Result loadXML(Class<Result> result, Reader xmlReader) throws IOException, XerialException
    {
        return loadXML(TypeInfo.createInstance(result), xmlReader);
    }

    public static <Result> Result loadXML(Result result, Reader xmlReader) throws IOException, XerialException
    {
        return load(result, new XMLTreeParser(xmlReader));
    }

    public static <Result> Result loadJSON(Class<Result> targetType, Reader jsonReader) throws XerialException,
            IOException
    {
        return loadJSON(TypeInfo.createInstance(targetType), jsonReader);
    }

    public static <Result> Result loadJSON(Result result, Reader jsonReader) throws XerialException, IOException
    {
        return load(result, new JSONPushParser(jsonReader));
    }

    public static <Result> Result loadANTLRParseTree(Class<Result> resultType, Tree tree,
            final String[] parserTokenNames) throws XerialException
    {
        return loadANTLRParseTree(TypeInfo.createInstance(resultType), tree, parserTokenNames);
    }

    public static <Result> Result loadANTLRParseTree(Result result, Tree tree, final String[] parserTokenNames)
            throws XerialException
    {
        return load(result, new ANTLRTreeParser(parserTokenNames, tree));
    }

    public static <Result> Result loadMap(Class<Result> resultType, Map< ? , ? > map) throws XerialException
    {
        return loadMap(TypeInfo.createInstance(resultType), map);
    }

    public static <Result> Result loadMap(Result result, Map< ? , ? > map) throws XerialException
    {
        return load(result, new MapParser(map));
    }

    public static <Result> Result load(Class<Result> targetType, TreeParser parser) throws XerialException
    {
        return load(TypeInfo.createInstance(targetType), parser);
    }

    public static <Result> Result load(Result result, TreeParser parser) throws XerialException
    {
        ObjectMapper mapper = ObjectMapper.getMapper(result.getClass());
        return mapper.map(result, parser);
    }

}

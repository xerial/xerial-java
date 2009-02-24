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

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xerial.core.XerialException;
import org.xerial.silk.SilkWalker;
import org.xerial.util.bean.TypeInformation;

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
    public static <Result> Result translateSilk(URL silkFileResource, Class<Result> targetClass) throws IOException,
            XerialException
    {
        retrievesObjectAttributes(targetClass);

        if (silkFileResource == null)
            throw new NullPointerException("silkFileResource");

        SilkWalker walker = new SilkWalker(silkFileResource);

        return null;
    }

    private enum SetterType {
        ADDER, SETTER, GETTER, PUTTER, APPENDER
    };

    private static class FieldSetter
    {
        SetterType type;
        Field target;
        Method seetter;
        String parameterName;

        private FieldSetter(String parameterName, Method seetter, SetterType type)
        {
            this.parameterName = parameterName;
            this.seetter = seetter;
            this.target = null;
            this.type = type;
        }

        private FieldSetter(String parameterName, Field target, SetterType type)
        {
            this.parameterName = parameterName;
            this.seetter = null;
            this.target = target;
            this.type = type;
        }

        @Override
        public boolean equals(Object obj)
        {
            FieldSetter other = FieldSetter.class.cast(obj);
            return parameterName.equals(other.seetter);
        }

        @Override
        public int hashCode()
        {
            return parameterName.hashCode();
        }
    }

    private static Map<Class< ? >, Set<FieldSetter>> classSetterTable = new HashMap<Class< ? >, Set<FieldSetter>>();

    private static void retrievesObjectAttributes(Class< ? > type)
    {
        List<FieldSetter> setterContainer = new ArrayList<FieldSetter>();

        // look for all super classes
        for (Class< ? > eachClass = type; eachClass != null; eachClass = eachClass.getSuperclass())
        {
            // scan fields
            for (Field eachField : eachClass.getFields())
            {
                int fieldModifier = eachField.getModifiers();
                if (Modifier.isPublic(fieldModifier) || !Modifier.isTransient(fieldModifier))
                {
                    Class< ? > fieldType = eachField.getType();
                    String paramName = getCanonicalParameterName(eachField.getName());
                    SetterType setterType = SetterType.SETTER;

                    if (TypeInformation.isArray(fieldType))
                    {
                        // ignore the array field
                        continue;
                    }
                    else if (TypeInformation.isMap(fieldType))
                    {
                        setterType = SetterType.PUTTER;
                    }
                    if (TypeInformation.isCollection(fieldType))
                    {
                        setterType = SetterType.ADDER;
                    }

                    setterContainer.add(new FieldSetter(paramName, eachField, setterType));

                }

            }

            // scan methods
            for (Method eachMethod : eachClass.getMethods())
            {
                String methodName = eachMethod.getName();
                if (methodName.startsWith("add"))
                {
                    // adder
                    String paramName = getCanonicalParameterName(methodName.substring(3));
                    setterContainer.add(new FieldSetter(paramName, eachMethod, SetterType.ADDER));
                }
                else if (methodName.startsWith("set"))
                {
                    // setter

                }
                else if (methodName.startsWith("get"))
                {
                    // we cannot use the getter requring some arguments
                    Class< ? >[] parameterType = eachMethod.getParameterTypes();
                    if (parameterType.length != 0)
                        continue;

                }
                else if (methodName.startsWith("put"))
                {

                }
                else if (methodName.startsWith("append"))
                {
                    // appender 
                }

            }

        }

    }

    public static String getCanonicalParameterName(String paramName)
    {
        paramName = paramName.replaceAll("\\s", "_");
        return paramName.toLowerCase();
    }

}

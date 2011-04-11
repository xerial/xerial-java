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
// ObjectTreeLens.java
// Since: 2011/03/28 11:25:35
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.lens;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.xerial.util.TypeInfo;
import org.xerial.util.lens.impl.ParameterGetter;

/**
 * Lens for converting objects into trees
 * 
 * @author leo
 * 
 */
public class ObjectTreeLens {

    public static interface TreeWriter {
        public void objectSchema(Class< ? > schema);

        public void openScope(String nodeName);

        public void leaf(String nodeName, Object nodeValue);

        public void text(String text);

        public void closeScope(String nodeName);
    }

    private final TreeWriter writer;
    private final String contextNodeName;

    public ObjectTreeLens(TreeWriter writer) {
        this(writer, null);
    }

    public String getContextNodeName() {
        return contextNodeName;
    }

    public ObjectTreeLens(TreeWriter writer, String contextNodeName) {
        this.writer = writer;
        this.contextNodeName = contextNodeName;
    }

    public ObjectTreeLens newNode(String nodeName) {
        return new ObjectTreeLens(writer, nodeName);
    }

    public ObjectTreeLens toSilk(String nodeName, Object obj) {
        if (obj == null)
            return this;

        if (TypeInfo.isBasicType(obj.getClass())) {
            writer.leaf(nodeName, convertToString(obj));
        }
        else {
            writer.openScope(nodeName);
            toSilk(obj);
            writer.closeScope(nodeName);
        }

        return this;
    }

    /**
     * output the input object in Silk format
     * 
     * @param obj
     * @return
     */
    public ObjectTreeLens toSilk(Object obj) {

        if (obj == null)
            return this;

        Class< ? > c = obj.getClass();

        if (TypeInfo.isBasicType(c)) {
            writer.text(convertToString(obj));
            return this;
        }

        ObjectLens lens = ObjectLens.getObjectLens(c);
        writer.objectSchema(c);

        if (TypeInfo.isIterable(c)) {
            Iterable< ? > collection = (Iterable< ? >) obj;
            boolean hasAttributes = lens.hasAttributes();
            if (hasAttributes) {
                outputParemters(lens, obj);
            }

            if (collection != null) {
                for (Object elem : collection) {
                    toSilk(null, elem);
                }
            }
        }
        else if (TypeInfo.isMap(c)) {
            Map< ? , ? > map = (Map< ? , ? >) obj;
            boolean hasAttributes = lens.hasAttributes();

            if (hasAttributes) {
                outputParemters(lens, obj);
            }

            if (!map.isEmpty()) {

                String mapElemName = getContextNodeName();
                if (mapElemName == null)
                    mapElemName = "entry";

                for (Entry< ? , ? > each : map.entrySet()) {
                    Object key = each.getKey();
                    Object value = each.getValue();

                    if (TypeInfo.isBasicType(key.getClass())) {
                        leafObject(key.toString(), value);
                    }
                    else {
                        ObjectTreeLens w = newNode(mapElemName);
                        w.newNode("key").toSilk(key);
                        w.newNode("value").toSilk(value);
                    }
                }
            }
        }
        else {
            if (lens.hasAttributes())
                outputParemters(lens, obj);
            else
                writer.text(obj.toString());
        }

        return this;
    }

    private static String convertToString(Object value) {
        Class< ? > c = value.getClass();
        if (c == Date.class) {
            return DateFormat.getDateTimeInstance().format(Date.class.cast(value));
        }
        else
            return value.toString();
    }

    private ObjectTreeLens leafObject(String leafNodeName, Object v) {
        if (v == null)
            return this;

        Class< ? > cl = v.getClass();

        if (TypeInfo.isBasicType(cl)) {
            writer.leaf(leafNodeName, convertToString(v));
        }
        else {
            ObjectLens lens = ObjectLens.getObjectLens(cl);
            writer.objectSchema(cl);

            if (lens.hasAttributes()) {
                toSilk(leafNodeName, v);
            }
            else {
                writer.leaf(leafNodeName, convertToString(v));
            }
        }
        return this;

    }

    private void outputParemters(ObjectLens lens, Object obj) {

        List<ParameterGetter> getterContainer = lens.getGetterContainer();
        List<ParameterGetter> deferredParameters = new ArrayList<ParameterGetter>();

        // Output attribute-like parameters first. The remaining parameters are stored into deferredParameters list
        for (ParameterGetter getter : getterContainer) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isBasicType(c)) {
                leafObject(getter.getNaturalParamName(), getter.get(obj));
            }
            else {
                if (TypeInfo.isIterable(c) || TypeInfo.isMap(c)) {
                    deferredParameters.add(getter);
                }
                else {
                    ObjectLens paramLens = ObjectLens.getObjectLens(c);
                    if (paramLens.hasAttributes())
                        deferredParameters.add(getter);
                    else
                        leafObject(getter.getNaturalParamName(), getter.get(obj));
                }
            }

        }

        // Output the deferred parameter values
        for (ParameterGetter getter : deferredParameters) {

            Class< ? > c = getter.getReturnType();
            if (TypeInfo.isIterable(c)) {
                Iterable< ? > collection = (Iterable< ? >) getter.get(obj);

                if (collection != null) {
                    for (Object elem : collection)
                        toSilk(getter.getNaturalParamName(), elem);
                }
            }
            else if (TypeInfo.isMap(c)) {
                Map< ? , ? > map = (Map< ? , ? >) getter.get(obj);

                if (!map.isEmpty()) {
                    String mapElemName = getter.getNaturalParamName();
                    if (!mapElemName.equals("")) {
                        ObjectTreeLens w = newNode(mapElemName);
                        for (Entry< ? , ? > each : map.entrySet()) {
                            Object key = each.getKey();
                            Object value = each.getValue();
                            if (TypeInfo.isBasicType(key.getClass())) {
                                w.leafObject(key.toString(), value);
                            }
                            else {
                                w.newNode("key").toSilk(key);
                                w.newNode("value").toSilk(value);
                            }
                        }
                        writer.closeScope(mapElemName);
                    }
                    else {
                        for (Entry< ? , ? > each : map.entrySet()) {
                            Object key = each.getKey();
                            Object value = each.getValue();

                            if (TypeInfo.isBasicType(key.getClass())) {
                                leafObject(key.toString(), value);
                            }
                            else {
                                ObjectTreeLens w = newNode(mapElemName);
                                w.newNode("key").toSilk(key);
                                w.newNode("value").toSilk(value);
                            }
                        }
                    }

                }
            }
            else {
                leafObject(getter.getNaturalParamName(), getter.get(obj));
            }
        }
    }

}

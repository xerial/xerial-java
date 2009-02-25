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
// TreeToObjectLens.java
// Since: Feb 24, 2009 2:00:28 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xerial.core.XerialException;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.graph.Lattice;
import org.xerial.util.graph.LatticeCursor;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Stream amoeba join processor
 * 
 * @author leo
 * 
 */
public class TreeToObjectLens
{

    public TreeToObjectLens()
    {

    }

    public void process(TreeWalker walker) throws XerialException
    {
        TreeStreamProcessor processor = new TreeStreamProcessor();
        walker.walk(processor);
    }

    private class TreeStreamProcessor implements TreeVisitor
    {
        Lattice<String> contextNodeSet = new Lattice<String>();
        LatticeCursor<String> cursor;

        public void finish(TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void init(TreeWalker walker) throws XerialException
        {
            cursor = contextNodeSet.cursor();
        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
            int prevStateID = cursor.getNodeID();
            int nextStateID = cursor.back(nodeName).getID();

        }

        public void text(String textDataFragment, TreeWalker walker) throws XerialException
        {

        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            int prevStateID = cursor.getNodeID();
            int nextStateID = cursor.next(nodeName).getID();

        }

    }

    private class ActionTable
    {

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

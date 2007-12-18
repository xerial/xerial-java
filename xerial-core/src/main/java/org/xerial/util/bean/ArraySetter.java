/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// ArraySetter.java
// Since: Aug 9, 2007 9:42:59 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.json.JSONArray;

class ArraySetter extends BeanBinderBase {
    Class componentType;

    public ArraySetter(Method method, String parameterName, Class componentType) {
        super(method, parameterName);
        this.componentType = componentType;
    }

    @Override
    public void setJSONData(Object bean, Object json) throws BeanException {
        if (json == null || json.getClass() != JSONArray.class)
            return;
        JSONArray arrayContent = (JSONArray) json;

        Object[] tmpArray = (Object[]) Array.newInstance(componentType, arrayContent.size());
        for (int i = 0; i < arrayContent.size(); i++) {
            tmpArray[i] = BeanUtil.createBean(componentType, arrayContent.get(i));
        }
        invokeMethod(bean, new Object[] { tmpArray });
    }



}
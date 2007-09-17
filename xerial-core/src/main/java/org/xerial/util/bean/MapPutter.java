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
// MapPutter.java
// Since: Aug 9, 2007 9:43:22 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.w3c.dom.Element;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONException;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.dom.DOMUtil;

class MapPutter extends BeanBinderBase {
    Class keyType;

    Class valueType;

    public MapPutter(Method method, String parameterName, Class keyType, Class valueType) throws InvalidBeanException {
        super(method, parameterName);
        this.keyType = keyType;
        this.valueType = valueType;

        constractableTest(keyType);
        constractableTest(valueType);
    }

    @Override
    public void setJSONData(Object bean, Object json) throws NumberFormatException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, JSONException, InvalidBeanException, InstantiationException, InvalidJSONDataException {
        JSONArray mapContent = getJSONArray(json, "-m");
        if (mapContent == null)
            if (json.getClass() != JSONArray.class)
                return;
            else
                mapContent = (JSONArray) json;

        for (int i = 0; i < mapContent.size(); i++) {
            JSONArray entry = mapContent.getJSONArray(i);
            if (entry != null) {
                Object key = BeanUtil.createBean(keyType, entry.get(0));
                Object value = BeanUtil.createBean(valueType, entry.get(1));
                getMethod().invoke(bean, new Object[] { key, value });
            }
        }
    }

    @Override
    public void setXMLData(Object bean, Object xmlData) throws InvalidXMLException, InvalidBeanException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        if(!TypeInformation.isDOMElement(xmlData.getClass()))
            return;
        
        Element mapEntryElement = (Element) xmlData;
        // TODO support for complex putter argument such as putSomething(String key, Map value);
        String key = mapEntryElement.getAttribute("key");
        Object value = BeanUtil.createXMLBean(valueType, mapEntryElement);
        getMethod().invoke(bean, new Object[] { key, value } );
    }
    
    
}

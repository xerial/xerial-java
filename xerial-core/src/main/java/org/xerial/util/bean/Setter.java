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
// Setter.java
// Since: Aug 9, 2007 9:42:31 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONException;
import org.xerial.util.xml.InvalidXMLException;

class Setter extends BeanBinderBase {
    Class valueType;

    public Setter(Method method, String parameterName, Class valueType) {
        super(method, parameterName);
        this.valueType = valueType;
    }

    @Override
    public void setJSONData(Object bean, Object json) throws NumberFormatException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, JSONException, InvalidBeanException, InstantiationException, InvalidJSONDataException {
        // the object is a JSONValue
        if (json == null)
            return;

        Object tmpValue = BeanUtil.createBean(valueType, json);
        getMethod().invoke(bean, new Object[] { tmpValue });
    }

    @Override
    public void setXMLData(Object bean, Object xmlData) throws InvalidXMLException, InvalidBeanException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        if(xmlData == null)
            return;
        
        Object tmpValue = BeanUtil.createXMLBean(valueType, xmlData);
        getMethod().invoke(bean, new Object[] { tmpValue });
    }
    
    

}

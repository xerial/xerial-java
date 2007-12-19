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
// CollectionAdder.java
// Since: Aug 9, 2007 9:43:58 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.Method;

import org.xerial.json.JSONArray;



class CollectionAdder extends BeanBinderBase implements BeanUpdator {
    Class elementType;

    public CollectionAdder(Method method, String parameterName, Class elementType) throws BeanException {
        super(method, parameterName);
        this.elementType = elementType;

        constractableTest(elementType);
    }

    @Override
    public void setJSONData(Object bean, Object json) throws BeanException {
        JSONArray collectionContent = getJSONArray(json, "-c");
        if (collectionContent == null)
            if (json.getClass() != JSONArray.class)
                return;
            else
                collectionContent = (JSONArray) json;

        for (int i = 0; i < collectionContent.size(); i++) {
            Object value = BeanUtil.createBean(elementType, collectionContent.get(i));
            invokeMethod(bean, new Object[] { value });
        }
    }

    @Override
    public void setXMLData(Object bean, Object xmlData) throws BeanException  
    {
        Object value = BeanUtil.createXMLBean(elementType, xmlData);
        invokeMethod(bean, new Object[] { value });
    }

    public Class getElementType()
    {
        return elementType;
    }
    
    

}

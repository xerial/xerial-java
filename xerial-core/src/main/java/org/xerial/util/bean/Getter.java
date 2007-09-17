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
// Getter.java
// Since: Aug 9, 2007 9:41:56 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONException;

class Getter extends BeanBinderBase {
    public Getter(Method method, String parameterName) {
        super(method, parameterName);
    }

    @Override
    public void setJSONData(Object bean, Object json) throws NumberFormatException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, JSONException, InvalidBeanException, InstantiationException, InvalidJSONDataException {
        throw new InvalidBeanException("getter cannot be used to bind data");
    }
}

/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// OptionSetterViaMethod.java
// Since: 2008/10/27 23:33:35
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.xerial.core.XerialException;
import org.xerial.util.ReflectionUtil;
import org.xerial.util.TypeInfo;

/**
 * Option setter using a class method.
 * 
 * @author leo
 * 
 */
class OptionSetterViaMethod implements OptionSetter {
    private Method m;

    public OptionSetterViaMethod(Method m) {
        this.m = m;
    }

    public void setOption(Object bean, Object value) throws XerialException {
        ReflectionUtil.setValue(bean, m, value);
    }

    public Class< ? > getOptionDataType() {
        Type t = m.getParameterTypes()[0];
        if (ParameterizedType.class.isInstance(t)) {
            return (Class< ? >) ((ParameterizedType) t).getRawType();
        }
        else
            return (Class< ? >) t;
    }

    public boolean takesArgument() {
        return !TypeInfo.isBoolean(getOptionDataType());
    }

    public void initialize(Object bean) throws OptionParserException {
    // do nothing
    }

    public String getParameterName() {
        return m.getName();
    }

}

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
// ParameterSetter.java
// Since: Aug 9, 2007 9:42:31 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;

import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUpdatorType;
import org.xerial.util.bean.BeanUtil;

public class Setter extends BeanBinderBase implements BeanUpdator
{
    Class valueType;

    public Setter(Method method, String parameterName, Class valueType)
    {
        super(method, parameterName);
        this.valueType = valueType;
    }

    public Class getInputType()
    {
        return valueType;
    }

    public BeanUpdatorType getType()
    {
        return BeanUpdatorType.SETTER;
    }

}

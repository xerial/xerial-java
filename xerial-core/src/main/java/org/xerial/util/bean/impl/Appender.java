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
// Appender.java
// Since: Apr 27, 2009 2:35:52 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;

import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUpdatorType;

/**
 * 
 * {@link BeanUpdator} for append(...) methods
 * 
 * @author leo
 * 
 */
public class Appender extends BeanBinderBase implements BeanUpdator
{
    private final Class< ? > inputType;

    public Appender(Class< ? > inputType, Method appender, String parameterName)
    {
        super(appender, parameterName);
        this.inputType = inputType;
    }

    public Class getInputType()
    {
        return inputType;
    }

    public BeanUpdatorType getType()
    {
        return BeanUpdatorType.APPENDER;
    }

}

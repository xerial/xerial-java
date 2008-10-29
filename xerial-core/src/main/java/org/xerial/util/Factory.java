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
// Factory.java
// Since: 2008/10/29 22:55:22
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeInformation;

public abstract class Factory<T>
{
    @SuppressWarnings("unchecked")
    public T newInstance()
    {
        Type t = getClass().getGenericSuperclass();
        Type pt = ((ParameterizedType) t).getActualTypeArguments()[0];

        if (Class.class.isInstance(pt))
        {
            Class< ? > c = (Class< ? >) pt;
            try
            {
                return (T) TypeInformation.createInstance(c);
            }
            catch (BeanException e)
            {
                throw new XerialError(XerialErrorCode.INVALID_STATE);
            }
        }
        throw new XerialError(XerialErrorCode.INVALID_STATE);

    }
}



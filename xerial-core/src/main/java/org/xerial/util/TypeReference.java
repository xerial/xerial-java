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
// TypeReference.java
// Since: 2008/10/29 1:03:54
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * Reference to the generic type arguments. 
 * 
 * To extract the type parameter of ArrayList<String>, 
 * extend this {@link TypeReference} class, and call {@link #getRawType()}.
 *
 * @param <T> generic type 
 * 
 * @author leo
 */
public class TypeReference<T>
{

    private final Type type;

    protected TypeReference() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new XerialError(XerialErrorCode.MISSING_TYPE_PARAMETER);
        }
        else
            this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }
    
    /**
     * Gets the referenced type
     * @return
     */
    public Type getType()
    {
        return type;
    }

    /**
     * Gets the element type of the referenced type
     * 
     * @return
     */
    public Class<?> getRawType()
    {
        return type instanceof Class<?>
        ? (Class<?>) type
        : (Class<?>) ((ParameterizedType) type).getRawType();
    }
    
    public Type[] getElementType()
    {
        return ((ParameterizedType) type).getActualTypeArguments();
    }
    
}
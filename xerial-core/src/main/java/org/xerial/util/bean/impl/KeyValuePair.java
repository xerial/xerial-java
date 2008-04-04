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
// KeyValuePair.java
// Since: Mar 31, 2008 11:21:41 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;

/**
 * Key and value pair structure for preparing data object for {@link MapPutter}
 * 
 * @author leo
 * 
 */
public class KeyValuePair
{
    public final MapPutter mapPutter;

    private Object key = null;
    private Object value = null;

    private final Class keyClass;
    private final Class valueClass;

    private int setterCount = 0;

    public KeyValuePair(MapPutter mapPutter)
    {
        this.mapPutter = mapPutter;
        this.keyClass = mapPutter.getKeyType();
        this.valueClass = mapPutter.getValueType();
    }

    public KeyValuePair(MapPutter mapPutter, Class keyType, Class valueType)
    {
        this.mapPutter = mapPutter;
        this.keyClass = keyType;
        this.valueClass = valueType;
    }

    public Class keyType()
    {
        return keyClass;
    }

    public Class valueType()
    {
        return valueClass;
    }

    public Method putter()
    {
        return mapPutter.getMethod();
    }

    public Object getKey()
    {
        return key;
    }

    public void setKey(Object key)
    {
        this.key = key;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

}

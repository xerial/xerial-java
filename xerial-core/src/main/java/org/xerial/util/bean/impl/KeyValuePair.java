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

import org.xerial.util.bean.BeanErrorCode;
import org.xerial.util.bean.BeanException;

public class KeyValuePair
{
    private final Object parentBean;
    private final MapPutter mapPutter;
    private Object key = null;
    private Object value = null;

    private int setterCount = 0;

    public KeyValuePair(Object parentBean, MapPutter mapPutter)
    {
        this.parentBean = parentBean;
        this.mapPutter = mapPutter;
    }

    public void set(Object val) throws BeanException
    {
        switch (setterCount)
        {
        case 0:
            key = val;
            break;
        case 1:
            value = val;
            break;
        default:
            throw new BeanException(BeanErrorCode.InvalidKeyAndValuePair);
        }
        setterCount++;
    }

    public boolean hasKey()
    {
        return setterCount > 0;
    }

    public Object getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public void clearKeyValue()
    {
        setterCount = 0;
        key = null;
        value = null;
    }

    public Object getParentBean()
    {
        return parentBean;
    }

    /**
     * Tests key and value are already set.
     * 
     * @return
     */
    public boolean isFilled()
    {
        return setterCount > 1;
    }

}

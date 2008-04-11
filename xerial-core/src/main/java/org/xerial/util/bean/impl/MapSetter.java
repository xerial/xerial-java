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
// MapSetter.java
// Since: Aug 9, 2007 9:43:40 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;
import java.util.Map;

import org.xerial.json.JSONArray;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TypeInformation;


public class MapSetter extends BeanBinderBase {
    Class mapType;

    Class keyType;

    Class valueType;

    public MapSetter(Method method, String parameterName, Class mapType, Class keyType, Class valueType) throws BeanException {
        super(method, parameterName);
        this.mapType = mapType;
        this.keyType = keyType;
        this.valueType = valueType;

        constractableTest(mapType);
        constractableTest(keyType);
        constractableTest(valueType);
        assert (TypeInformation.isMap(mapType));
    }

}

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
// CollectionSetter.java
// Since: Aug 9, 2007 9:44:18 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;
import java.util.Collection;

import org.xerial.json.JSONArray;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TypeInfo;


public class CollectionSetter extends BeanBinderBase {
    Class collectionType;

    Class elementType;

    public CollectionSetter(Method method, String parameterName, Class collectionType, Class elementType) throws BeanException {
        super(method, parameterName);
        this.collectionType = collectionType;
        this.elementType = elementType;

        constractableTest(collectionType);
        constractableTest(elementType);

        assert (TypeInfo.isCollection(collectionType));
    }



}

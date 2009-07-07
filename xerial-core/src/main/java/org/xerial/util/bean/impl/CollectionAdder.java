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
// CollectionAdder.java
// Since: Aug 9, 2007 9:43:58 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;

import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUpdatorType;

public class CollectionAdder extends BeanBinderBase implements BeanUpdator {
    Class< ? > elementType;

    public CollectionAdder(Method method, String parameterName, Class< ? > elementType)
            throws BeanException {
        super(method, parameterName);
        this.elementType = elementType;

        constractableTest(elementType);
    }

    public Class< ? > getInputType() {
        return elementType;
    }

    public BeanUpdatorType getType() {
        return BeanUpdatorType.COLLECTION_ADDER;
    }

}

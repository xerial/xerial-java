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
// BindRuleGenerator.java
// Since: Jan 22, 2008 10:59:38 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanException;

/**
 * Bind Rule Generator interface
 * 
 * @author leo
 * 
 */
public interface BindRuleGenerator
{
    /**
     * Gets the binder set of the given bean class
     * 
     * @param <T>
     * @param beanClass
     * @return
     */
    public <T> BeanBinderSet getBeanBinderSet(Class<T> beanClass) throws BeanException;
}

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
// BindRuleGeneratorForBeanStream.java
// Since: Jan 22, 2008 11:06:06 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.Method;
import java.util.Vector;

import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUtil;

public class BindRuleGeneratorForBeanStream<E> implements BindRuleGenerator
{
    private final Class<E> targetBeanClass;
    private String className;
    private BeanBinderSet binderSetForTargetBean = new MyBeanBinderSet();

    public BindRuleGeneratorForBeanStream(Class<E> targetBeanClass)
    {
        this.targetBeanClass = targetBeanClass;
        className = targetBeanClass.getSimpleName().toLowerCase();
    }

    class MyBeanBinderSet implements BeanBinderSet
    {
        public void addRule(BeanBinder binder)
        {
            throw new UnsupportedOperationException("addRule");
        }

        public BeanBinder findRule(String name)
        {
            if (name.equals(className))
            {
                Method m;
                try
                {
                    m = BeanStreamReader.class.getMethod("add", targetBeanClass);
                    return new CollectionAdder(m, className, targetBeanClass);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        public Vector<BeanBinder> getBindRules()
        {
            throw new UnsupportedOperationException("getBindRules");
        }

    }

    public <T> BeanBinderSet getBeanBinderSet(Class<T> beanClass) throws BeanException
    {
        if (BeanStreamReader.class.isAssignableFrom(beanClass))
        {
            return binderSetForTargetBean;
        }
        else
            return BeanUtil.getBeanLoadRule(beanClass);
    }
}

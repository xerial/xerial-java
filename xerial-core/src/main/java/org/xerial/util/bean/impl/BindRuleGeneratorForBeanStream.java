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

import java.util.Vector;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanUtil;

public class BindRuleGeneratorForBeanStream<E> implements BindRuleGenerator
{
    private final Class<E>      targetBeanClass;
    private String              className;
    private final BeanBinderSet binderSetForTargetBean;

    public BindRuleGeneratorForBeanStream(Class<E> targetBeanClass) throws XerialException {
        this(targetBeanClass, targetBeanClass.getSimpleName());
    }

    public BindRuleGeneratorForBeanStream(Class<E> targetBeanClass, String targetNodeName) throws XerialException {
        this.targetBeanClass = targetBeanClass;
        className = targetNodeName.toLowerCase();
        try {
            binderSetForTargetBean = new MyBeanBinderSet();
        }
        catch (SecurityException e) {
            throw new XerialException(XerialErrorCode.InvalidBeanClass, e);
        }
        catch (NoSuchMethodException e) {
            throw new XerialException(XerialErrorCode.InvalidBeanClass, e);
        }
    }

    class MyBeanBinderSet implements BeanBinderSet
    {
        private CollectionAdder adder;

        public MyBeanBinderSet() throws XerialException, SecurityException, NoSuchMethodException {
            adder = new CollectionAdder(BeanStreamReader.class.getMethod("add", Object.class), className,
                    targetBeanClass);
        }

        public void addRule(BeanBinder binder) {
            throw new UnsupportedOperationException("addRule");
        }

        public BeanBinder findRule(String name) {
            if (name.equals(className)) {
                return adder;
            }
            else
                return null;
        }

        public Vector<BeanBinder> getBindRules() {
            throw new UnsupportedOperationException("getBindRules");
        }

        public MapPutter getStandardMapPutter() {
            throw new UnsupportedOperationException("getStandardMapPutter");
        }

    }

    public <T> BeanBinderSet getBeanBinderSet(Class<T> beanClass) throws XerialException {
        if (BeanStreamReader.class.isAssignableFrom(beanClass)) {
            return binderSetForTargetBean;
        }
        else
            return BeanUtil.getBeanLoadRule(beanClass);
    }
}

/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// XMLLens.java
// Since: 2010/11/18 16:41:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.w3c.dom.Element;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.bean.impl.BeanBindingProcess;
import org.xerial.util.bean.impl.BeanUtilImpl;
import org.xerial.util.reflect.ReflectionUtil;

public class XMLLens {

    private static class BeanToXMLProcess {
        private ByteArrayOutputStream _buffer = new ByteArrayOutputStream();

        private XMLGenerator _out = new XMLGenerator(_buffer);

        public BeanToXMLProcess() {

        }

        public String generateXML(String tagName, Object bean) throws XerialException {
            try {
                toXML(tagName, bean);
                _out.endDocument();
                _out.flush();
                return _buffer.toString();
            }
            catch (IllegalArgumentException e) {
                throw new XerialException(XerialErrorCode.IllegalArgument, e);
            }
        }

        private void toXML(String tagName, Object bean) throws XerialException {
            if (bean == null)
                return;

            Class< ? > beanClass = bean.getClass();

            if (beanClass.isArray()) {
                Object[] array = (Object[]) bean;
                int i = 0;
                for (; i < array.length - 1; i++) {
                    toXML(tagName, array[i]);
                    _out.text(",");
                }
                toXML(tagName, array[i]);
            }
            else if (TypeInfo.isBasicType(beanClass)) {
                _out.element(tagName, bean.toString());
            }
            else {
                if (TypeInfo.isCollection(beanClass)) {
                    Collection< ? > collection = (Collection< ? >) bean;
                    for (Object elem : collection) {
                        toXML(tagName, elem);
                    }
                }
                else if (TypeInfo.isMap(beanClass)) {
                    Map< ? , ? > map = (Map< ? , ? >) bean;

                    for (Object key : map.keySet()) {
                        _out.startTag(tagName);
                        _out.element("key", key.toString());
                        _out.element("value", map.get(key).toString());
                        _out.endTag();
                    }
                }
                else {
                    // return an XML elemenet
                    _out.startTag(tagName);
                    BeanBinderSet outputRuleSet = BeanUtil.getBeanOutputRule(beanClass);
                    for (BeanBinder rule : outputRuleSet.getBindRules()) {
                        Method getter = rule.getMethod();
                        String parameterName = rule.getParameterName();

                        Object parameterValue = ReflectionUtil.invokeGetter(bean, getter);
                        toXML(parameterName, parameterValue);
                    }
                    _out.endTag();
                }
            }

        }
    }

    public static String toXML(String tagName, Object bean) throws XerialException {
        BeanToXMLProcess bp = new BeanToXMLProcess();
        return bp.generateXML(tagName, bean);
    }

    public static <E> E createXMLBean(Class<E> valueType, Reader xmlReader) throws XerialException,
            IOException, XerialException {
        return createBeanFromXML(valueType, xmlReader);
    }

    public static Object createXMLBean(Class< ? > valueType, String xmlData) throws XerialException {
        Object bean;
        bean = BeanUtil.createInstance(valueType);
        populateBeanWithXML(bean, new StringReader(xmlData));
        return bean;
    }

    // XML Stream
    public static <E> E createBeanFromXML(Class<E> beanType, Reader xmlReader)
            throws XerialException {
        return BeanUtilImpl.createTypedBean(new XMLTreeWalker(xmlReader), beanType);
    }

    public static Object populateBeanWithXML(Object bean, String xml) throws XerialException {
        return BeanUtilImpl.createBean(new XMLTreeWalker(new StringReader(xml)), bean);
    }

    public static Object populateBeanWithXML(Object bean, Reader xmlReader) throws XerialException {
        return BeanUtilImpl.createBean(new XMLTreeWalker(xmlReader), bean);
    }

    // XML DOM
    public static <E> E createBeanFromXML(Class<E> beanType, Element xmlElement)
            throws XerialException {
        return BeanUtilImpl.createTypedBean(new XMLTreeWalker(xmlElement), beanType);
    }

    public static Object populateBeanWithXML(Object bean, Element xmlElement)
            throws XerialException {
        return BeanUtilImpl.createBean(new XMLTreeWalker(xmlElement), new BeanBindingProcess(bean));
    }

}

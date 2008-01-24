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
// BeanUtilImpl.java
// Since: Dec 19, 2007 4:38:26 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.antlr.runtime.Parser;
import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Element;
import org.xerial.core.XerialException;
import org.xerial.util.bean.ANTLRWalker;
import org.xerial.util.bean.JSONStreamWalker;
import org.xerial.util.bean.MapWalker;
import org.xerial.util.bean.XMLWalker;

/**
 * Implementations of BeanUtil
 * 
 * @author leo
 * 
 */
public class BeanUtilImpl
{
    // XML Stream
    public static <E> E createBeanFromXML(Class<E> beanType, Reader xmlReader) throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(beanType);
        XMLWalker walker = new XMLWalker(bindingProcess, xmlReader);
        walker.walk();
        return (E) bindingProcess.getResultBean();
    }

    public static Object populateBeanWithXML(Object bean, Reader xmlReader) throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(bean);
        XMLWalker walker = new XMLWalker(bindingProcess, xmlReader);
        walker.walk();
        return bean;
    }

    // XML DOM
    public static <E> E createBeanFromXML(Class<E> beanType, Element xmlElement) throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(beanType);
        XMLWalker walker = new XMLWalker(bindingProcess, xmlElement);
        walker.walk();
        return (E) bindingProcess.getResultBean();
    }

    public static Object populateBeanWithXML(Object bean, Element xmlElement) throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(bean);
        XMLWalker walker = new XMLWalker(bindingProcess, xmlElement);
        walker.walk();
        return bean;
    }

    // ANTLR ParseTree
    public static <E> E createBeanFromParseTree(Class<E> beanType, Tree parseTree, Parser parser)
            throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(beanType);
        ANTLRWalker walker = new ANTLRWalker(parser, bindingProcess, parseTree);
        walker.walk(parseTree);
        return (E) bindingProcess.getResultBean();
    }

    public static Object populateBeanWithParseTree(Object bean, Tree parseTree, Parser parser) throws XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(bean);
        ANTLRWalker walker = new ANTLRWalker(parser, bindingProcess, parseTree);
        walker.walk(parseTree);
        return bean;
    }

    public static <E> E createBeanFromJSON(Class<E> beanType, Reader jsonReader) throws IOException, XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(beanType);
        JSONStreamWalker walker = new JSONStreamWalker(bindingProcess, jsonReader);
        walker.walk();
        return (E) bindingProcess.getResultBean();
    }

    public static Object populateBeanWithJSON(Object bean, Reader jsonReader) throws IOException, XerialException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(bean);
        JSONStreamWalker walker = new JSONStreamWalker(bindingProcess, jsonReader);
        walker.walk();
        return bean;
    }

    public static <E> E createBeanFromMap(Class<E> beanType, Map map) throws XerialException
    {
        BeanBindingProcess bindingProces = new BeanBindingProcess(beanType);
        MapWalker walker = new MapWalker(bindingProces, map);
        walker.walk();
        return (E) bindingProces.getResultBean();
    }

    public static Object populateBeanWithMap(Object bean, Map map) throws XerialException
    {
        BeanBindingProcess bindingProces = new BeanBindingProcess(bean);
        MapWalker walker = new MapWalker(bindingProces, map);
        walker.walk();
        return bean;
    }

}

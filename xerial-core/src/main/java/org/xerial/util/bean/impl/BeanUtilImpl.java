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
import java.net.URL;
import java.util.Map;

import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Element;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkWalker;
import org.xerial.util.bean.ANTLRWalker;
import org.xerial.util.bean.JSONStreamWalker;
import org.xerial.util.bean.MapWalker;
import org.xerial.util.bean.XMLWalker;
import org.xerial.util.tree.TreeWalker;

/**
 * Implementations of BeanUtil
 * 
 * @author leo
 * 
 */
public class BeanUtilImpl
{
    /**
     * Create a bean of the specified type from the tree walker input
     * 
     * @param <E>
     * @param treeWalker
     * @param beanType
     * @return bean
     * @throws XerialException
     */

    /**
     * Create a bean object using a given tree walker
     * 
     * @param <E>
     * @param treeWalker
     * @param beanType
     * @return
     * @throws XerialException
     */
    protected static <E> E createTypedBean(TreeWalker treeWalker, Class<E> beanType) throws XerialException
    {
        return beanType.cast(createBean(treeWalker, new BeanBindingProcess(beanType)));
    }

    /**
     * Create a bean object using a given tree walker
     * 
     * @param treeWalker
     * @param bean
     * @return
     * @throws XerialException
     */
    protected static Object createBean(TreeWalker treeWalker, Object bean) throws XerialException
    {
        return createBean(treeWalker, new BeanBindingProcess(bean));
    }

    protected static Object createBean(TreeWalker treeWalker, BeanBindingProcess beanBindingVisitor)
            throws XerialException
    {
        treeWalker.walk(beanBindingVisitor);
        return beanBindingVisitor.getResultBean();
    }

    // Silk Stream
    public static <E> E createBeanFromSilk(Class<E> beanType, URL silkFileAddress) throws XerialException, IOException
    {
        return createTypedBean(new SilkWalker(silkFileAddress), beanType);
    }

    @SuppressWarnings("unchecked")
    public static <E> E populateBeanWithSilk(E bean, URL silkFileAddress) throws XerialException, IOException
    {
        return (E) createBean(new SilkWalker(silkFileAddress), bean);
    }

    // XML Stream
    public static <E> E createBeanFromXML(Class<E> beanType, Reader xmlReader) throws XerialException
    {
        return createTypedBean(new XMLWalker(xmlReader), beanType);
    }

    public static Object populateBeanWithXML(Object bean, Reader xmlReader) throws XerialException
    {
        return createBean(new XMLWalker(xmlReader), bean);
    }

    // XML DOM
    public static <E> E createBeanFromXML(Class<E> beanType, Element xmlElement) throws XerialException
    {
        return createTypedBean(new XMLWalker(xmlElement), beanType);
    }

    public static Object populateBeanWithXML(Object bean, Element xmlElement) throws XerialException
    {
        return createBean(new XMLWalker(xmlElement), new BeanBindingProcess(bean));
    }

    // ANTLR ParseTree
    public static <E> E createBeanFromParseTree(Class<E> beanType, Tree parseTree, final String[] parserTokenNames)
            throws XerialException
    {
        return createTypedBean(new ANTLRWalker(parserTokenNames, parseTree), beanType);
    }

    public static Object populateBeanWithParseTree(Object bean, Tree parseTree, final String[] parserTokenNames)
            throws XerialException
    {
        return createBean(new ANTLRWalker(parserTokenNames, parseTree), bean);
    }

    public static <E> E createBeanFromJSON(Class<E> beanType, Reader jsonReader) throws IOException, XerialException
    {
        return createTypedBean(new JSONStreamWalker(jsonReader), beanType);
    }

    public static Object populateBeanWithJSON(Object bean, Reader jsonReader) throws IOException, XerialException
    {
        return createBean(new JSONStreamWalker(jsonReader), bean);
    }

    public static <E> E createBeanFromMap(Class<E> beanType, Map< ? , ? > map) throws XerialException
    {
        return createTypedBean(new MapWalker(map), beanType);
    }

    public static Object populateBeanWithMap(Object bean, Map< ? , ? > map) throws XerialException
    {
        return createBean(new MapWalker(map), bean);
    }

}

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
// BeanBindingProcess.java
// Since: Dec 18, 2007 5:09:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.xerial.core.XerialException;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.NodeAttribute;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.TreeWalker;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.bean.XMLWalker;

/**
 * 
 * 
 * @author leo
 * 
 */
public class BeanBindingProcess implements TreeVisitor
{
    private final ArrayList<Object> beanStack = new ArrayList<Object>();
    private int currentLevel = 0;

    public BeanBindingProcess(Class beanClass) throws BeanException
    {
        this(BeanUtil.createInstance(beanClass));
    }

    public BeanBindingProcess(Object bean)
    {
        beanStack.add(bean);
    }

    public void populateBeanWithXML(Reader xmlReader) throws Exception, IOException
    {
        XMLWalker xmlVisitor = new XMLWalker(this);
        xmlVisitor.parse(xmlReader);
    }

    public Object getBean(int level)
    {
        return level < beanStack.size() ? beanStack.get(level) : null;
    }
    
    public void setBean(int level, Object bean)
    {
        while(beanStack.size() < level)
        {
            beanStack.add(null);
        }
        beanStack.set(level, bean);
    }

    public void finish(TreeWalker walker) throws XerialException
    {

    }

    public void init(TreeWalker walker) throws XerialException
    {
        currentLevel = 0;

    }

    public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
    {
        int nodeLevel = --currentLevel;
        Object parentBean = getBean(nodeLevel-1);
        if(parentBean == null)
            return;
        
        Class parentBeanClass = parentBean.getClass();    
        BeanBinderSet bindRuleSet = BeanUtil.getBeanLoadRule(parentBeanClass);
        BeanBinder binder = bindRuleSet.findRule(nodeName);
        if (binder != null)
        {
            Object valueBean = getBean(nodeLevel);
            
            if(valueBean == null)
            {
                if(nodeValue != null && nodeValue.length() > 0)
                    bindValue(parentBean, binder, nodeValue);
            }
            else
                bindValue(parentBean, binder, valueBean);
        }
        
    }

    public void visitNode(String nodeName, List<NodeAttribute> nodeAttributeList, TreeWalker walker)
            throws XerialException
    {
        int nodeLevel = currentLevel++;
        Object bean = getBean(nodeLevel);
        if(bean == null)
        {
            assert(currentLevel > 0);   // cannot be null when level is 0 
            Object parentBean = getBean(nodeLevel - 1);
            BeanBinderSet parentBeanBindRuleSet = BeanUtil.getBeanLoadRule(parentBean.getClass());
            BeanBinder binder = parentBeanBindRuleSet.findRule(nodeName);
            if(binder != null)
            {
                // We have to instantiate a bean class of the node name
                if(!BeanUpdator.class.isAssignableFrom(binder.getClass()))
                    throw new BeanException(BeanErrorCode.InvalidBeanClass, binder.getClass().getName() + " cannot be used to bind data");
                BeanUpdator updator = (BeanUpdator) binder;
                
                Class elementType = updator.getElementType();
                if(TypeInformation.isBasicType(elementType))
                {
                    // this bean can be converted from a element text, so there is no need to instantiate the object here.
                    return;
                }
                else
                {
                    Object newBean = BeanUtil.createInstance(updator.getElementType());
                    setBean(nodeLevel, newBean);
                    bean = newBean;
                }
            }
            else
            {
                // We can safely skip descendants of this node, since there is no descendant nodes to bind 
                walker.skipDescendants();
                return;
            }
        }
        
        Class beanClass = bean.getClass();
        BeanBinderSet bindRuleSet = BeanUtil.getBeanLoadRule(beanClass);
        // bind attribute data
        for(NodeAttribute attribute : nodeAttributeList)
        {
            BeanBinder attributeBinder = bindRuleSet.findRule(attribute.getName());
            if(attributeBinder != null)
                bindValue(bean, attributeBinder, attribute.getValue());
        }

    }
    
    
    protected void bindValue(Object bean, BeanBinder binder, Object value) throws BeanException
    {
        try
        {
            binder.getMethod().invoke(bean, value);
        }
        catch (IllegalArgumentException e)
        {
            throw new BeanException(BeanErrorCode.IllegalArgument, e);
        }
        catch (IllegalAccessException e)
        {
            throw new BeanException(BeanErrorCode.IllegalAccess, e);
        }
        catch (InvocationTargetException e)
        {
            throw new BeanException(BeanErrorCode.InvocationTargetException, e);
        }
    }
    
    

}

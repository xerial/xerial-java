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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.XMLVisitor;


/**
 * 
 * 
 * @author leo
 *
 */
public class BeanBindingProcess implements TreeVisitor {
    
    public ArrayList<StringBuilder> textStack = new ArrayList<StringBuilder>();  
    public ArrayList<Object> beanStack = new ArrayList<Object>();
    public int currentLevel;
    public int skipLevel; 
    
    public BeanBindingProcess(Class beanClass) throws BeanException
    {
        this(BeanUtil.createInstance(beanClass));
    }
    
    public BeanBindingProcess(Object bean)
    {
        textStack.add(new StringBuilder());
        beanStack.add(bean);
    }
    
    public void populateBeanWithXML(Reader xmlReader) throws Exception, IOException
    {
        XMLVisitor xmlVisitor = new XMLVisitor(this);
        xmlVisitor.parse(xmlReader);
    }
    
    public void finish() throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    public void foundText(String text) throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    public void init() throws Exception
    {
        currentLevel = 0;
        skipLevel = Integer.MAX_VALUE;
    }

    public void pushStack(boolean skipDescendants)
    {
        skipLevel = currentLevel;
        currentLevel++;
    }
    
    
    public Object getParent()
    {
        if(beanStack.size() >= 2)
            return beanStack.get(beanStack.size() - 2);
        else
            return null;
    }

    public void leaveNode(String nodeName) throws Exception
    {
        
        
        // invokde setter of the parent bean
        Object parentBean = getParent(); 
        Class parentBeanClass = parentBean.getClass();
        
        BeanBinderSet bindRuleSet = BeanUtil.getBeanLoadRule(parentBeanClass);
        BeanBinder binder = bindRuleSet.findRule(nodeName);
        if(binder != null)
        {
            String textValue = textStack.get(textStack.size()-1).toString();
            if(textValue.length() > 0)
            {
                binder.invokeXMLDataSetter(parentBean, textValue.trim());
            }
        }
    }

    public void visitNode(String nodeName) throws Exception
    {
        if(currentLevel > skipLevel)
            return;
        
        Object bean = beanStack.get(beanStack.size() -1);
        Class beanClass = bean.getClass();
        
        BeanBinderSet bindRuleSet = BeanUtil.getBeanLoadRule(beanClass);
        BeanBinder binder = bindRuleSet.findRule(nodeName);
        if(binder == null)
        {
            // skip the descendants
            skipLevel = currentLevel;
        }
        
    }
    
}

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

import org.xerial.core.XerialException;
import org.xerial.util.bean.XMLWalker;

public class BeanUtilImpl
{
    public static <E> E createBeanFromXML(Class<E> beanType, Reader xmlReader) throws XerialException, IOException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(beanType);
        XMLWalker walker = new XMLWalker(bindingProcess);
        walker.parse(xmlReader);
        return (E) bindingProcess.getResultBean();
    }
    
    public static Object populateBeanWithXML(Object bean, Reader xmlReader) throws XerialException, IOException
    {
        BeanBindingProcess bindingProcess = new BeanBindingProcess(bean);
        XMLWalker walker = new XMLWalker(bindingProcess);
        walker.parse(xmlReader);
        return bean; 
    }
}

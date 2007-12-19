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
// BeanBinderBase.java
// Since: Aug 9, 2007 9:38:46 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.xerial.json.JSONArray;
import org.xerial.json.JSONObject;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.TypeInformation;

/**
 * A Binder holds a getter/setter method and its parameter type.
 * 
 * @author leo
 * 
 */
abstract class BeanBinderBase implements BeanBinder {
    Method method;

    String parameterName;

    public BeanBinderBase(Method method, String parameterName) {
        this.method = method;
        this.parameterName = parameterName;
    }

    // @see org.utgenome.util.BeanBinder#getMethod()
    public Method getMethod() {
        return method;
    }

    // @see org.utgenome.util.BeanBinder#setMethod(java.lang.reflect.Method)
    public void setMethod(Method method) {
        this.method = method;
    }

    // @see org.utgenome.util.BeanBinder#toString()
    public String toString() {
        return "(" + method.toString() + ") ";
    }

    // @see org.utgenome.util.BeanBinder#getParameterName()
    public String getParameterName() {
        return parameterName;
    }

    // @see org.utgenome.util.BeanBinder#setParameterName(java.lang.String)
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    // @see org.utgenome.util.BeanBinder#invokeSetter(java.lang.Object,
    // java.lang.Object)
    public void invokeJSONDataSetter(Object bean, Object json) throws BeanException {
        try {
            setJSONData(bean, json);
        } catch (NumberFormatException e) {
            throw new BeanException(BeanErrorCode.InvalidNumberFormat, e);
        }
        catch (IllegalArgumentException e)
        {
            throw new BeanException(BeanErrorCode.IllegalArgument, e);
        }
    }

    // @see org.utgenome.util.BeanBinder#setJSONData(java.lang.Object,
    // java.lang.Object)
    public abstract void setJSONData(Object bean, Object json) throws BeanException; 

    public static JSONArray getJSONArray(Object json, String key) {
        if (json == null || json.getClass() != JSONObject.class)
            return null;
        return ((JSONObject) json).getJSONArray(key);
    }

    public static void constractableTest(Class c) throws BeanException {
        if (!TypeInformation.canInstantiate(c)) {
            throw new BeanException(BeanErrorCode.NoPublicConstructor, c + " has no public constructor");
        }
    }

    public void invokeXMLDataSetter(Object bean, Object xmlData) throws BeanException
    {
        setXMLData(bean, xmlData);
    }
    
    /**
     * Invoke a method of the bean object, then handle some exceptions if they occur 
     * @param bean
     * @param args
     * @throws BeanException
     */
    protected void invokeMethod(Object bean, Object[] args) throws BeanException
    {
        try
        {
            getMethod().invoke(bean, args);
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
    

    public void setXMLData(Object bean, Object xmlData) throws BeanException
    {
        throw new UnsupportedOperationException(this.getClass() + "does not support setXMLData()");
    }
    
    
    
    
}

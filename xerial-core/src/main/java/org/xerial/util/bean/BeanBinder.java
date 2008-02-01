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
// XerialJ Project
//
// BeanBinder.java
// Since: Apr 18, 2007
//
// $Date: 2007-05-01 08:19:31 +0900 (Tue, 01 May 2007) $
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/util/bean/BeanBinder.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.bean;

import java.lang.reflect.Method;

public interface BeanBinder
{

    public Method getMethod();

    public void setMethod(Method method);

    public String toString();

    public String getParameterName();

    public void setParameterName(String parameterName);

    public void invokeJSONDataSetter(Object bean, Object json) throws BeanException;

    public void setJSONData(Object bean, Object json) throws BeanException;

}

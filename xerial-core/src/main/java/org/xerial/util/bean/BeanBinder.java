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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONException;
import org.xerial.util.xml.InvalidXMLException;


public interface BeanBinder {

	public Method getMethod();

	public void setMethod(Method method);

	public String toString();

	public String getParameterName();

	public void setParameterName(String parameterName);

	public void invokeJSONDataSetter(Object bean, Object json) throws InvalidBeanException, InvalidJSONDataException;
	public void invokeXMLDataSetter(Object bean, Object xmlData) throws InvalidXMLException, InvalidBeanException;

	public void setJSONData(Object bean, Object json) throws NumberFormatException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, JSONException, InvalidBeanException, InstantiationException, InvalidJSONDataException;
	
	public void setXMLData(Object bean, Object xmlData) throws InvalidXMLException, InvalidBeanException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	

}

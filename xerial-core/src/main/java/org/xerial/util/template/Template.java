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
// Template.java
// Since: Jul 25, 2007 4:11:06 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.antlr.stringtemplate.StringTemplate;

/**
 * Searches a <pre>$propertyKey$</pre> in a template, replaces it with the corresponding property value. 
 * 
 * @author leo
 *
 */
public class Template
{
    private StringTemplate template;
    
    public Template(String templateString)
    {
        template = new StringTemplate(templateString);
    }
    public Template(InputStream templateStream) throws IOException
    {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(templateStream));
    	StringWriter buf = new StringWriter();
    	PrintWriter writer = new PrintWriter(buf);
    	
    	String line;
    	while((line = reader.readLine()) != null)
    	{
        	writer.println(line);
    	}
    	
    	template = new StringTemplate(buf.toString());
    }
    
    public String apply(Properties property)
    {
        for(Object keyObj : property.keySet()) {
            String key = keyObj.toString();
            template.setAttribute(key, property.get(keyObj));
        }
        return template.toString();
    }

}

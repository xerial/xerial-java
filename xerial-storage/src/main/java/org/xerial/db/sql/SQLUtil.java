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
// SQLUtil.java
// Since: May 8, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.util.Collection;
import java.util.Vector;

/**
 * Utilities to generate SQL expressions
 * @author leo
 *
 */
public class SQLUtil
{
    static public enum QuotationType { none, singleQuote, doubleQuote }     
    static private String[] quotation = {"", "'", "\""}; 
    
    
    static private String separate(Collection list, String separator, QuotationType quotationType)
    {
        StringBuilder buffer = new StringBuilder();
        int quoteType = quotationType.ordinal();
        for(Object o : list)
        {
            buffer.append(quotation[quoteType]);
            buffer.append(o.toString());
            buffer.append(quotation[quoteType]);
            buffer.append(separator);
        }
        if(buffer.length() >= separator.length())
            return buffer.substring(0, buffer.length() - separator.length());
        else
            return "";        
    }
    
    /** 
     * Generates the comma-separated string of the given data
     * 
     * @param list the elements to concatenate
     * @param quotationType the quotation type ( {@link QuotationType} )
     * @return the comma-separated string of the given data
     */
    static public String commaSeparatedList(Collection list, QuotationType quotationType) 
    {
        return separate(list, ", ", quotationType);
    }
    
    /** 
     * Generates the comma-separated string of the given data
     * 
     * @param list the elements to concatenate
     * @param quotationType the quotation type ( {@link QuotationType} )
     * @return the comma-separated string of the given data
     */
    static public <E> String commaSeparatedList(E[] list, QuotationType quotationType)
    {
        Vector<E> v = new Vector<E>(list.length);
        for(E e : list)
            v.add(e);
        
        return commaSeparatedList(v, quotationType);
    }
    
    /** 
     * Generates the concatenation of the given elements in the list 
     * @param list the elements to concatenate
     * @param separator the separator 
     * @param quotationType the quotation type ( {@link QuotationType} )
     * @return the concatenation of each element in the list separated via the given separator
     */
    static public String separatedList(Collection list, String separator, QuotationType quotationType)
    {
        return separate(list, separator, quotationType);
    }
    
    /**
     * Adds a double quotation to the input value
     * @param input
     * @return 
     */
    static public String doubleQuote(String input)
    {
        return "\"" + input + "\""; 
    }
    
    /**
     * Adds a single quotation to the input value
     * @param input
     * @return
     */
    static public String singleQuote(String input)
    {
        return "'" + input + "'";
    }
    /**
     * Non constractable
     */
    private SQLUtil()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
}




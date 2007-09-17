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
// PageType.java
// Since: Aug 31, 2007 9:21:01 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.lang.reflect.Field;
import java.util.HashSet;

import org.xerial.util.log.Logger;

/**
 * PageType information written to a {@link CommonPageHeader}. 
 * 
 * @author leo
 *
 */
public class PageType {

    public final static int Unknown = 0;
    
    public final static int DatabaseInformation = 100;
    
    public final static int BTreeRoot = 200;
    public final static int BTreeInternalNode = 201;
    public final static int BTreeLeaf = 202;
    public final static int BTreeData = 203;
    
    public final static int FreePageBitMap = 300;
    
    public final static int Heap = 400;
    public final static int HeapIndex = 401;
 
    private static final HashSet<Integer> pageTypeTable = new HashSet<Integer>();
    private static final Logger logger = Logger.getLogger(PageType.class);
    
    static
    {
        // gather the page IDs from the reflection of the PageType class
        PageType dummy = new PageType();
        Field[] pageTypeField = PageType.class.getFields();
        for(Field f : pageTypeField)
        {
            try
            {
                int pageTypeID = f.getInt(dummy);
                logger.trace("PageType: " + pageTypeID + " " + f.getName()); 
                pageTypeTable.add(pageTypeID);
            }
            catch (IllegalArgumentException e)
            {
                logger.error(e);
            }
            catch (IllegalAccessException e)
            {
                logger.error(e);
            }
        }
 
    }
    
    public static boolean isValidPageType(int pageType)
    {
        return pageTypeTable.contains(pageType);
    }
    
    private PageType()
    {}
    
    
}

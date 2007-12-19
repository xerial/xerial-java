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
// BeanUtilImplTest.java
// Since: Dec 19, 2007 4:43:11 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.core.XerialException;
import org.xerial.util.FileResource;



public class BeanUtilImplTest
{
    
    
    @Before
    public void setUp() throws Exception
    {}

    @After
    public void tearDown() throws Exception
    {}
    
    @Test
    public void createBeanFromXML() throws XerialException, IOException
    {
        Sample s = BeanUtilImpl.createBeanFromXML(Sample.class, FileResource.open(BeanUtilImplTest.class, "sample.xml"));
        assertEquals(100, s.getId());
        assertEquals("Leo", s.getName());
    }

}

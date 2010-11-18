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
// SampleList.java
// Since: Dec 19, 2007 5:25:46 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml.impl;

import java.util.ArrayList;

import org.xerial.util.log.Logger;

public class SampleList
{
    private static Logger _logger = Logger.getLogger(SampleList.class); 
    private ArrayList<Sample> sampleList = new ArrayList<Sample>(); 
    private String listName;
    
    public String getListName()
    {
        return listName;
    }

    public void setListName(String listName)
    {
        this.listName = listName;
    }

    public SampleList()
    {}
    
    public void addSample(Sample s)
    {
        _logger.trace("add: " + s);
        sampleList.add(s);
    }

    public ArrayList<Sample> getSampleList()
    {
        return sampleList;
    }

        
}

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
// TrackInfo.java
// Since: Dec 19, 2007 6:22:13 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.HashMap;

public class TrackInfo 
{
    String name;
    boolean pack = true;
    HashMap property = new HashMap();
    
    public TrackInfo()
    {}

    public TrackInfo(String name, boolean pack) {
        super();
        this.name = name;
        this.pack = pack;
    }
    
    public void putProperty(String key, String value)
    {
        property.put(key, value);
    }
    public HashMap getProperty()
    {
        return property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPack() {
        return pack;
    }

    public void setPack(boolean pack) {
        this.pack = pack;
    }

}

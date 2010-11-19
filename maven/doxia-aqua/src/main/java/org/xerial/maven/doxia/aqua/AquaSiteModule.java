/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// AquaSiteModule.java
// Since: Apr 21, 2008 11:25:30 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.maven.doxia.aqua;

import org.apache.maven.doxia.module.site.AbstractSiteModule;

/**
 * Doxia Aqua Site Module  
 * @author leo
 * @plexus.component role="org.apache.maven.doxia.module.site.SiteModule" role-hint="aqua"
 */
public class AquaSiteModule extends AbstractSiteModule
{

    public String getParserId()
    {
         return "aqua";
    }
    
    public String getSourceDirectory()
    {
        return "aqua";
    }
    
    public String getExtension()
    {
        return "aqua";
    }


}

/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// SilkSchema.java
// Since: Jul 3, 2009 2:39:31 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.schema;

import java.io.StringWriter;
import java.util.Properties;

import org.xerial.util.StringUtil;
import org.xerial.util.graph.GraphvizHelper;
import org.xerial.util.log.Logger;

public class SilkSchema
{
    private static Logger _logger      = Logger.getLogger(SilkSchema.class);

    public SilkModule     globalModule = new SilkModule();

    /**
     * Get the SilkClass information of the given class name
     * 
     * @param className
     * @return
     */
    public SilkClass getSilkClass(String className) {
        // search global module
        return getSilkClass(globalModule, className);
    }

    /**
     * Get the SilkClass information of the given class name contained in the
     * specified module
     * 
     * @param module
     * @param className
     * @return
     */
    SilkClass getSilkClass(SilkModule module, String className) {
        for (SilkClass each : module.classDef) {
            if (each.name != null && each.name.equals(className))
                return each;
        }

        for (SilkModule m : module.module) {
            SilkClass c = getSilkClass(m, className);
            if (c != null)
                return c;
        }

        return null;
    }

    public String toGraphviz() {
        StringWriter buf = new StringWriter();
        GraphvizHelper g = new GraphvizHelper(buf);
        g.beginDigraph("G");
        g.graphOption("font=Arial");

        int moduleCount = 1;
        for (SilkModule eachModule : globalModule.module) {
            String moduleID = String.format("m%d", moduleCount++);
            g.node(moduleID, eachModule.name);

            for (SilkClass eachClass : eachModule.classDef) {
                String classID = String.format("c_%s", eachClass.name);

                g.node(classID, eachClass.name);
                // parent
                if (eachClass.parent != null) {
                    String parentID = String.format("c_%s", eachClass.parent);

                    Properties prop = new Properties();
                    prop.put("arrowhead", StringUtil.doubleQuote("none"));
                    prop.put("arrowtail", StringUtil.doubleQuote("empty"));
                    prop.put("colro", "gray");
                    g.edge(parentID, classID, prop);
                }
                else {
                    // module to class
                    g.edge(moduleID, classID);
                }

                // attributes
                int attributeCount = 1;
                for (SilkAttribute eachAttribute : eachClass.attribute) {
                    String attribID = String.format("%s_a%d", classID, attributeCount++);
                    {
                        String label = eachAttribute.name;
                        if (eachAttribute.typeName != null)
                            label += String.format(" [%s]", eachAttribute.typeName);

                        Properties prop = new Properties();
                        prop.put("label", StringUtil.doubleQuote(label));
                        prop.put("shape", "box");
                        g.node(attribID, prop);
                    }

                    if (eachAttribute.isArray) {
                        Properties edgeProp = new Properties();
                        edgeProp.put("color", "red");
                        g.edge(classID, attribID, edgeProp);
                    }
                    else
                        g.edge(classID, attribID);

                }

            }
        }

        g.endDigraph();

        g.flush();

        return buf.toString();
    }

}

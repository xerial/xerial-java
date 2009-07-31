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
// SilkNodeBuilder.java
// Since: Jul 29, 2009 6:32:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.util.ArrayList;
import java.util.List;

import org.xerial.silk.impl.SilkNode;
import org.xerial.silk.impl.SilkNodeOccurrence;

/**
 * Silk node builder
 * 
 * <pre>
 * - book(isbn:xxx-xxx, title: XML Data Management)
 * 
 * @author leo
 * 
 */
public class SilkNodeBuilder {

    public final String nodeName;
    public final String nodeValue;

    public final List<SilkNode> attributeList = new ArrayList<SilkNode>();

    public SilkNodeBuilder(String nodeName, String nodeValue) {
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    public SilkNodeBuilder addNode(String nodeName, String value, SilkNodeOccurrence occurrence) {

        SilkNode n = new SilkNode();
        n.setName(nodeName);
        n.setValue(value);
        n.setOccurrence(occurrence);
        attributeList.add(n);
        return this;
    }

}

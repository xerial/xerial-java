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
// XMLTreeWalker.java
// Since: 2009/03/30 20:08:14
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.io.Reader;

import org.w3c.dom.Element;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.tree.TreeWalkerImpl;

/**
 * An {@link TreeWalker} implementation for XML data
 * 
 * @author leo
 * 
 */
public class XMLTreeWalker extends TreeWalkerImpl
{
    public XMLTreeWalker(Reader xmlReader)
    {
        super(new XMLStreamReader(xmlReader));
    }

    public XMLTreeWalker(Element domElement)
    {
        super(new DOMStreamReader(domElement));
    }

}

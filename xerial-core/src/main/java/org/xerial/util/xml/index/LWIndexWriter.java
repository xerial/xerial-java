/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// IndexWriter.java
// Since: 2005/09/09 13:29:07
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import java.io.OutputStream;
import java.io.PrintStream;

import org.xerial.util.StringUtil;

/**
 * XML index writer
 * 
 * @author leo
 * 
 */
public class LWIndexWriter
{
    PrintStream out = System.out;

    public LWIndexWriter()
    {

    }

    public LWIndexWriter(OutputStream out)
    {
        this.out = new PrintStream(out);
    }

    public void write(XMLNode node, String tagName, String textContent)
    {
        out.println(StringUtil.concatinateWithTab(node.outputAsTabDelimited(), tagName, textContent == null ? ""
                : textContent.trim()));
    }

}

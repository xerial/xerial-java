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
// XerialJ Project
//
// XMLInputSource.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Common interface for various XML input sources
 * 
 * @author leo
 * 
 */
public class XMLInputSource
{
    private Reader _reader = null;

    public XMLInputSource(InputStream byteStream)
    {
        _reader = new InputStreamReader(byteStream);
    }

    public XMLInputSource(Reader characterStream)
    {
        _reader = characterStream;
    }

    /**
     * @param fileName
     *            an URI of an XML resource
     * @throws FileNotFoundException
     */
    public XMLInputSource(String fileName) throws FileNotFoundException
    {
        _reader = new BufferedReader(new FileReader(fileName));
    }

    public Reader getReader()
    {
        return _reader;
    }

}

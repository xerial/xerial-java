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
// SilkWalker.java
// Since: Feb 2, 2009 11:29:02 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.xerial.util.tree.TreeWalker;
import org.xerial.util.tree.TreeWalkerImpl;

/**
 * {@link TreeWalker} implementation of the Silk format.
 * 
 * @author leo
 * 
 */
public class SilkWalker extends TreeWalkerImpl
{

    /**
     * Creates a new SilkWalker with the specified input stream
     * 
     * @param input
     *            `@throws IOException
     */
    protected SilkWalker(InputStream input) throws IOException
    {
        super(new SilkStreamReader(input));
    }

    /**
     * Creates a new SilkWalker with the specified reader
     * 
     * @param input
     * @throws IOException
     */
    protected SilkWalker(Reader input) throws IOException
    {
        super(new SilkStreamReader(input));
    }

    public SilkWalker(String resourceBasePath, String resourceName) throws IOException
    {
        super(new SilkStreamReader(resourceBasePath, resourceName));
    }

    public SilkWalker(URL resourcePath) throws IOException
    {
        super(new SilkStreamReader(resourcePath));
    }

    public SilkWalker(URL resource, SilkEnv env) throws IOException
    {
        super(new SilkStreamReader(resource, env));
    }

}

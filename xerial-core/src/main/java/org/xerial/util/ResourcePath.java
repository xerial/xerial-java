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
// ResourcePath.java
// Since: Oct 30, 2008 9:36:16 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * Path to a file resource
 * 
 * @author leo
 * 
 */
public class ResourcePath
{
    final Package packageName;
    final String  name;

    public ResourcePath(String resourcePath)
    {
        this.packageName = null;
        name = resourcePath;
    }

    public ResourcePath(Class< ? > baseClass, String name)
    {
        this.packageName = baseClass.getPackage();
        this.name = name;
    }

    public ResourcePath(Package packageName, String name)
    {
        this.packageName = packageName;
        this.name = name;
    }

    public URL getURL()
    {
        if (packageName != null)
            return FileResource.find(packageName, name);
        else
            return FileResource.find(name);
    }

    public InputStream openBinaryStream() throws XerialException, IOException
    {
        URL resource = getURL();
        if (resource == null)
            throw new XerialException(XerialErrorCode.RESOURCE_NOT_FOUND, this.toString());

        return resource.openStream();

    }

    public BufferedReader openCharacterStream() throws XerialException, IOException
    {
        return new BufferedReader(new InputStreamReader(openBinaryStream()));
    }

    public String getPath()
    {
        String packagePath = packageName != null ? packageName.getName().replaceAll("\\.", "/") + "/" : "";
        return String.format("%s%s", packagePath, name);
    }

    public String toString()
    {
        return getPath();
    }

}

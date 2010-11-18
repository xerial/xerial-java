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
// SinglePathBuilder.java
// Since: Oct 27, 2008 2:14:57 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.xerial.xml.SinglePath.PathType;

/**
 * A builder class for generating {@link SinglePath} instance
 * 
 * @author leo
 * 
 */
public class SinglePathBuilder implements Iterable<String>
{
    private ArrayList<String> _path = new ArrayList<String>();
    private PathType _pathType = PathType.AbsolutePath;

    public SinglePathBuilder()
    {}

    public static SinglePathBuilder relativePathBuilder()
    {
        SinglePathBuilder builder = new SinglePathBuilder();
        builder.setPathType(PathType.RelativePath);
        return builder;
    }

    public SinglePathBuilder setPathType(PathType pathType)
    {
        this._pathType = pathType;
        return this;
    }

    public SinglePathBuilder addChild(String tagName)
    {
        _path.add(tagName);
        return this;
    }

    public SinglePathBuilder removeLeaf()
    {
        if (_path.size() <= 0)
            throw new NoSuchElementException("no leaf to remove");
        _path.remove(_path.size() - 1);
        return this;
    }

    public int size()
    {
        return _path.size();
    }

    public SinglePath build()
    {
        return new SinglePath(_pathType, _path);
    }

    public Iterator<String> iterator()
    {
        return _path.iterator();
    }
}

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
// SinglePath.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.util.Iterator;
import java.util.Vector;

import org.xerial.util.Algorithm;

/**
 * A simple path structure that consists of parent-child axis only
 * 
 * @author leo
 * 
 */
public class SinglePath implements Comparable<SinglePath>, Iterable<String>
{
    static public enum PathType {
        AbsolutePath, RelativePath
    }

    Vector<String> _path = new Vector<String>();
    PathType _pathType = PathType.AbsolutePath;

    /**
     * create a relative path
     */
    public SinglePath()
    {
        _pathType = PathType.RelativePath;
    }

    /**
     * create a path
     * 
     * @param pathType
     *            PathType.AbsolutePath(ÉãÅ[ÉgÇ©ÇÁénÇ‹ÇÈê‚ëŒpath) or PathType.RelativePath
     *            (relative path)
     */
    public SinglePath(PathType pathType)
    {
        _pathType = pathType;
    }

    public SinglePath(String pathExpression)
    {
        if (!pathExpression.startsWith("/"))
            _pathType = PathType.RelativePath;

        String[] pathComponent = pathExpression.split("/");
        for (String tag : pathComponent)
            addChild(tag);
    }

    /**
     * copy constuctor
     * 
     * @param other
     */
    public SinglePath(SinglePath other)
    {
        this._pathType = other._pathType;
        this._path.addAll(other._path);
    }

    /**
     * creat a new path based on the given path and its child tag
     * 
     * @param path
     *            base path
     * 
     * @param childTag
     */
    public SinglePath(SinglePath path, String childTag)
    {
        this._pathType = path._pathType;
        for (String e : path._path)
        {
            this._path.add(e);
        }
        this.addChild(childTag);
    }

    public String getTag(int index)
    {
        return _path.get(index);
    }

    public String getLeaf()
    {
        if (_path.size() < 1)
            return "";
        else
            return _path.lastElement();
    }

    public void addChild(String tagName)
    {
        _path.add(tagName);
    }

    public void removeLastChild()
    {
        assert _path.size() > 0;
        _path.remove(_path.size() - 1);
    }

    public Integer size()
    {
        return _path.size();
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (String tag : _path)
        {
            builder.append("/");
            builder.append(tag);
        }
        if (!isAbsolutePath())
        {
            if (builder.length() > 0)
                return builder.substring(1); // truncate the first slash
        }
        return builder.toString();
    }

    // @see java.lang.Comparable#compareTo(java.lang.Object)
    public int compareTo(SinglePath other)
    {
        // comparison
        //MinMax<Integer> pathLengthMinMax = Algorithm.minmax(this.size(), other.size());
        // define the order so that absolute paths are less then the relative path
        int cmp = Algorithm.boolToInt(!this.isAbsolutePath()) - Algorithm.boolToInt(!other.isAbsolutePath());
        if (cmp != 0)
            return cmp;

        // lexicographical order
        cmp = Algorithm.lexicographicalCompare(this.getPath(), other.getPath());
        return cmp;
    }

    @Override
    public boolean equals(Object obj)
    {
        SinglePath other = (SinglePath) obj;
        if (obj == null)
            return false;

        return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode()
    {
        long hashValue = 31;
        for (String eachTag : _path)
        {
            hashValue += eachTag.hashCode() * 137;
        }
        hashValue += _pathType.hashCode();

        return (int) hashValue % 1987;
    }

    public boolean isAbsolutePath()
    {
        return _pathType == PathType.AbsolutePath;
    }

    private Vector<String> getPath()
    {
        return _path;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return new SinglePath(this);
    }

    public Iterator<String> iterator()
    {
        return _path.iterator();
    }

}

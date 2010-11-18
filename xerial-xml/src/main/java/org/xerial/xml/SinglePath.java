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
package org.xerial.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xerial.util.Algorithm;

/**
 * A simple path structure that consists of parent-child axis only.
 * 
 * SinglePath is an immutable object.
 * 
 * @author leo
 * 
 */
public class SinglePath implements Comparable<SinglePath>, Iterable<String>
{
    static public enum PathType {
        AbsolutePath, RelativePath
    }

    private static final String EMPTY_LEAF = "";
    private final List<String> _path;
    private final PathType _pathType;

    SinglePath(PathType absoluteOrRelative, List<String> tagListInThePath)
    {
        _pathType = absoluteOrRelative;
        // create a copy (don't share the array)
        _path = new ArrayList<String>(tagListInThePath.size());
        _path.addAll(tagListInThePath);
    }

    /**
     * Create a new path by appending a child tag to the base path
     * 
     * @param basePath
     * @param childTag
     */
    public SinglePath(SinglePath basePath, String childTag)
    {
        this._pathType = basePath._pathType;
        this._path = new ArrayList<String>(basePath.size() + 1);
        for (String e : basePath)
        {
            this._path.add(e);
        }
        this._path.add(childTag);
    }

    /**
     * create a path
     * 
     * @param pathType
     *            PathType.AbsolutePath (beginning from the root) or
     *            PathType.RelativePath (relative path)
     */
    private SinglePath(PathType pathType)
    {
        _pathType = pathType;
        _path = new ArrayList<String>(0);
    }

    public static SinglePath rootPath()
    {
        return new SinglePath(PathType.AbsolutePath);
    }

    public static SinglePath newPath(String pathExpression)
    {
        SinglePathBuilder builder = new SinglePathBuilder();

        String pathExprWithoutLeadingSlash = pathExpression;
        if (!pathExpression.startsWith("/"))
        {
            builder.setPathType(PathType.RelativePath);
        }
        else
            pathExprWithoutLeadingSlash = pathExpression.substring(1);

        String[] pathComponent = pathExprWithoutLeadingSlash.split("/");
        for (String tag : pathComponent)
            builder.addChild(tag);

        return builder.build();
    }

    /**
     * copy constructor
     * 
     * @param other
     */
    public SinglePath(SinglePath other)
    {
        this(other._pathType, other._path);
    }

    public String getTag(int index)
    {
        return _path.get(index);
    }

    public String getLeaf()
    {
        if (_path.size() < 1)
            return EMPTY_LEAF;
        else
            return _path.get(_path.size() - 1);
    }

    //    public void addChild(String tagName)
    //    {
    //        _path.add(tagName);
    //    }
    //
    //    public void removeLastChild()
    //    {
    //        assert _path.size() > 0;
    //        _path.remove(_path.size() - 1);
    //    }

    public int size()
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

    private List<String> getPath()
    {
        return _path;
    }

    public Iterator<String> iterator()
    {
        return _path.iterator();
    }

}

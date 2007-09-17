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


/** 親子関係(/)だけからなる単純なPath
 * @author leo
 *
 */
public class SinglePath implements Comparable<SinglePath>, Iterable<String>
{
    static public enum PathType { AbsolutePath, RelativePath }
    
    Vector<String> _path = new Vector<String>();
    PathType _pathType =  PathType.AbsolutePath;


    /**
     * 相対パスを作成 
     */
    public SinglePath()
    {
        _pathType = PathType.RelativePath;
    }
    
    /**
     * パスを作成
     * @param pathType PathType.AbsolutePath(ルートから始まる絶対path) or PathType.RelativePath (相対path)
     */
    public SinglePath(PathType pathType)
    {
        _pathType = pathType;
    }
    
    public SinglePath(String pathExpression)
    {
        if(!pathExpression.startsWith("/"))
            _pathType = PathType.RelativePath;
        
        String[] pathComponent = pathExpression.split("/");
        for(String tag : pathComponent)
            addChild(tag);
    }
    
    /**
     * pathにchildTagを足して、新しいPathを作成
     * @param path ベースとなるpath
     * @param childTag 
     */
    public SinglePath(SinglePath path, String childTag)
    {
        this._pathType = path._pathType;
        for(String e : path._path)
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
        if(_path.size()<1)
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
        _path.remove(_path.size()-1);
    }
    
    public Integer size()
    {
        return _path.size();
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        for(String tag : _path)
        {
            builder.append("/");
            builder.append(tag);
        }
        if(!isAbsolutePath())
        {
           if(builder.length() > 0)
               return builder.substring(1);  // truncate the first slash
        }
        return builder.toString();
    }

    // @see java.lang.Comparable#compareTo(java.lang.Object)
    public int compareTo(SinglePath other)
    {
        // comparison
        //MinMax<Integer> pathLengthMinMax = Algorithm.minmax(this.size(), other.size());
        // 絶対パスの方が順序が小さくなるようにする
        int cmp = Algorithm.boolToInt(!this.isAbsolutePath()) - Algorithm.boolToInt(!other.isAbsolutePath());
        if(cmp != 0)
            return cmp;
        
        // 辞書順比較
        cmp = Algorithm.lexicographicalCompare(this.getPath(), other.getPath());
        return cmp;
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        SinglePath other = (SinglePath) obj;
        if(obj == null)
            return false;
        
        return this.compareTo(other) == 0;
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
        SinglePath newPath = new SinglePath(_pathType);
        newPath._path = (Vector<String>) this._path.clone();
        return newPath;
    }

    public Iterator<String> iterator()
    {
        return _path.iterator();
    }
    
    
    
} 





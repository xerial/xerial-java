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
// InvertedPath.java
// Since: 2005/06/02
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.xerial.util.Algorithm;

/**
 * InvertedPath: 
 *  /booklist/book/authorÇ∆Ç¢Ç§XPathÇÃinverted pathÇÕÅAauthor.book.booklist
 *  
 * @author leo
 *
 */
public class InvertedPath implements Comparable<InvertedPath>, Iterable<String>
{
    private LinkedList<String> _path = new LinkedList<String>();
    
    /**
     * 
     */
    public InvertedPath()
    {
        super();
    }
    public InvertedPath(String stringRepresentationOfInvertedPath)
    {
        String[] pathComponent = stringRepresentationOfInvertedPath.split("\\.");
        for(String c : pathComponent)
        {
            addParent(c);
        }
    }
    
    /**
     * copy constructor
     * @param invertedPath
     */
    public InvertedPath(InvertedPath invertedPath)
    {
        for(String s : invertedPath)
            addParent(s);
    }
    
    public void addParent(String tagName)
    {
        _path.add(tagName);
    }
    public void addChild(String tagName)
    {
        _path.addFirst(tagName);
    }
    
    public String getLastParent()
    {
        if(_path.isEmpty())
            return "";
        else
            return _path.getLast();
    }
    
    /**
     * @throws NoSuchElementException if this inverted path contains no step
     */
    public void removeLastParent() throws NoSuchElementException
    {
        if(_path.isEmpty())
            throw new NoSuchElementException("empty path");
        _path.removeLast();
    }
    public void removeFirstChild() throws NoSuchElementException
    {
        if(_path.isEmpty())
            throw new NoSuchElementException("empty path");
        _path.removeFirst();
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
            builder.append(".");
            builder.append(tag);
        }
        if(builder.length() > 1)
            return builder.substring(1);
        else
            return "";
    }

    // @see java.lang.Comparable#compareTo(java.lang.Object)
    public int compareTo(InvertedPath other)
    {
        return Algorithm.lexicographicalCompare(this.getPath(), other.getPath());
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        InvertedPath other = (InvertedPath) obj;
        if(obj == null)
            return false;
        
        return this.compareTo(other) == 0;
    }


    private LinkedList<String> getPath()
    {
        return _path;
    }

    @Override
    protected InvertedPath clone() throws CloneNotSupportedException
    {
        InvertedPath newPath = new InvertedPath();
        newPath._path = (LinkedList<String>) this._path.clone();
        return newPath;
    }

    public Iterator<String> iterator()
    {
        return _path.iterator();
    }
    
    


}





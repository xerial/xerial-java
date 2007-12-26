/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// JSONStreamWalker.java
// Since: Dec 19, 2007 8:08:32 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.IOException;
import java.io.Reader;

import org.xerial.core.XerialException;
import org.xerial.json.JSONEvent;
import org.xerial.json.JSONPullParser;

public class JSONStreamWalker implements TreeWalker
{
    private final JSONPullParser jsonPullParser;
    private boolean skipDescendants = false;
    private int skipLevel = Integer.MAX_VALUE; 
    private TreeVisitor visitor;
    
    public JSONStreamWalker(TreeVisitor visitor, Reader jsonStream) throws IOException
    {
        this.visitor = visitor;
        jsonPullParser = new JSONPullParser(jsonStream);
    }
    
    
    public void walk() throws XerialException
    {
        JSONEvent event;
        while((event = jsonPullParser.next()) != JSONEvent.EndJSON)
        {
            
            switch(event)
            {
            case StartObject:
            {
                if(!skipDescendants)
                {
                    String key = jsonPullParser.getKeyName(); 
                    visitor.visitNode(key, null, this);
                }
                break;
            }
            case EndObject:
            {
                if(skipDescendants)
                {
                    if(skipLevel == jsonPullParser.getDepth())
                        skipDescendants = false;
                    else
                        break;
                }
                String key = jsonPullParser.getKeyName(); 
                visitor.leaveNode(key, null, this);
                break;
            }
            case String:
            case Integer:
            case Double:
            case Boolean:
            {
                if(skipDescendants)
                    break;
            
                String key = jsonPullParser.getKeyName(); 
                String value = jsonPullParser.getText();
                visitor.visitNode(key, null, this);
                visitor.leaveNode(key, value, this);
                break;
            }
            case Null:            
            {
                if(skipDescendants)
                    break;

                String key = jsonPullParser.getKeyName(); 
                visitor.visitNode(key, null, this);
                visitor.leaveNode(key, null, this);
                break;
            }
            }
        }
            
    }
    
    public void skipDescendants()
    {
        skipDescendants = true;
    }


    public TreeNode getSubTree()
    {
        throw new UnsupportedOperationException("not implemented");
    }
}

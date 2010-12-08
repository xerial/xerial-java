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
// TupleOnBuffer.java
// Since: Sep 22, 2007 11:31:56 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.heap;

import java.lang.ref.WeakReference;

import org.xerial.db.AbstractTuple;
import org.xerial.db.Relation;
import org.xerial.db.cache.Buffer;
import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;

/**
 * 
 * 
 * @author leo
 *
 */
public class TupleOnBuffer extends AbstractTuple 
{
    private final WeakReference<Buffer> bufferRef; 
    private int offset; 

    /**
     * Constrctor
     * @param relation the relation structure of the tuple
     * @param buffer the buffer to which the tuple is stored
     * @param offset the tuple location offset from the beginning of the buffer
     */
    public TupleOnBuffer(Relation relation, final Buffer buffer, int offset)
    {
        super(relation);
        this.bufferRef = new WeakReference<Buffer>(buffer);
        this.offset = offset;
    }

    @Override
    public Object getValue(int relationIndex)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setValue(int relationIndex, Object value)
    {
        // TODO Auto-generated method stub
        
    }

    public int getByteSize()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int load(BufferReader reader)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int save(BufferWriter writer)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}

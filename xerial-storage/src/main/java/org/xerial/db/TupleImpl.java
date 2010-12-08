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
// TupleImpl.java
// Since: Sep 20, 2007 2:06:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.TypeInformation;




/**
 * A simple implementation of the {@link Tuple} interface
 * 
 * @author leo
 *
 */
public class TupleImpl extends AbstractTuple
{
    private final String value[];
    
    public TupleImpl(Relation relation, final String[] value)
    {
        super(relation);
        this.value = value;
    }

    @Override
    public Object getValue(int relationIndex)
    {
        throw new UnsupportedOperationException("getValue");
    }

    @Override
    public void setValue(int relationIndex, Object value)
    {
        throw new UnsupportedOperationException("setValue");
    }

    public int getByteSize()
    {
        int byteSize = 0;
        Relation relation = getRelation();
        int relationIndex = 0;
        for(DataType dt : relation.getDataTypeList())
        {
            switch(dt.getType())
            {
            case INTEGER:
                byteSize += TypeInformation.INT_SIZE;
                break;
            case STRING:
                int strLen = value[relationIndex].length();
                byteSize += VariableLengthInteger.byteSize(strLen);
                byteSize += strLen;
                break;
            case BOOLEAN:
                byteSize += TypeInformation.BOOLEAN_SIZE;
                break;
            default:
                throw new UnsupportedOperationException("unsupported data type: " + dt.getName());
            }
            
            relationIndex++;
        }
        
        return byteSize;
    }

    public int load(BufferReader reader)
    {
        int relationIndex = 0;
        Relation relation = getRelation();
        for(DataType dt : relation.getDataTypeList())
        {
            switch(dt.getType())
            {
            case INTEGER:
            {
                int value = reader.readInt();
                break;
            }
            case BOOLEAN:
            {
                int strLen = value[relationIndex].length();
                break;
            }
            default:
                throw new UnsupportedOperationException("unsupported data type: " + dt.getName());
            }
            
            relationIndex++;
        }
        
        
        
        return 0;
    }

    public int save(BufferWriter writer)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}

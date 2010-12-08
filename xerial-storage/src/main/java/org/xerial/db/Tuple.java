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
// Tuple.java
// Since: Aug 31, 2007 1:23:30 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import org.xerial.db.cache.BufferReader;
import org.xerial.db.cache.BufferWriter;

/**
 * {@link Tuple} interface represents an instance of a {@link Relation}.
 * 
 * @author leo
 * 
 */
public interface Tuple
{
    /**
     * Gets the relational schema of this tuple
     * 
     * @return
     */
    //Relation getRelation();
    /**
     * Sets the tuple value of the specified column
     * 
     * @param columnIndex
     *            the column index to which the value is set (0-origin)
     * @param value
     *            the column value to set
     */
    void setValue(int columnIndex, Object value);

    /**
     * Gets the tuple value of the specified column name
     * 
     * @param columnName
     *            the column name to which the value is set
     * @param value
     *            the column value to set
     */
    //void setValue(String columnName, Object value);
    /**
     * Gets the column value
     * 
     * @param columnIndex
     *            the column index from which the value is read (0-origin)
     * @return the column value of the specfied column index
     */
    Object getValue(int columnIndex);

    /**
     * Gets the column value
     * 
     * @param columnName
     *            the column name from which the value is read
     * @return the column value of the specfied column name
     */
    //Object getValue(String columnName);
    /**
     * Gets the byte size of this tuple
     * 
     * @return the byte size of this tuple
     */
    int getByteSize();

    /**
     * Loads the tuple from the buffer
     * 
     * @param reader
     *            the {@link BufferReader}
     * @return the byte size read (tuple size)
     */
    int load(BufferReader reader);

    /**
     * Saves the tuple to the buffer
     * 
     * @param writer
     *            the {@link BufferWriter}
     * @return the byte size wrote (tuple size)
     */
    int save(BufferWriter writer);
}

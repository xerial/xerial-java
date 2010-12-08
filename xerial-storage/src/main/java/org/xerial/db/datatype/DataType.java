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
// XerialJ Project
//
// DataType.java
// Since: 2007/04/13
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;

/**
 * DataType interface is used to represtent various data types, e.g., integer,
 * DataTime, Color, etc.
 * 
 * DataTypes are sorted in the order of parameter name
 * 
 * @author leo
 * 
 */
public interface DataType extends Comparable<DataType>
{

    /**
     * Gets the parameter name (column name in a relation) of the type
     * 
     * @return the parameter name
     */
    public String getName();

    /**
     * Gets the type name of this data type
     * 
     * @return the type name
     */
    public TypeName getType();
    
    /**
     * Gets the type name of this data type, e.g., integer, boolean, etc.
     * 
     * @return the type name
     */
    public String getTypeName();

    /**
     * is primary key?
     * 
     * @return true if this data type is used as a primary key, otherwise false.
     */
    public boolean isPrimaryKey();

    /**
     * allowed to be null?
     * 
     * @return true if this data type value cannot be null, otherwise false.
     */
    public boolean isNullable();

    public void setPrimaryKey(boolean isPrimatyKey);

    public void setNullable(boolean isNullable);

}

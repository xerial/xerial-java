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
// DataTypeBase.java
// Since: 2007/04/13
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;

/**
 * @author leo
 * 
 */
public class DataTypeBase implements DataType
{
    private final String name;
    private final TypeName typeName;
    private boolean isPrimaryKey = false;
    private boolean isNullable = false;


    public DataTypeBase(String name, TypeName typeName)
    {
        this(name, typeName, false, false);
    }

    public DataTypeBase(String name, TypeName typeName, boolean isPrimaryKey)
    {
        this(name, typeName, isPrimaryKey, false);
    }

    public DataTypeBase(String name, TypeName typeName, boolean isPrimaryKey, boolean isNullable)
    {
        this.name = name;
        this.typeName = typeName;
        this.isPrimaryKey = isPrimaryKey;
        this.isNullable = isNullable;
    }

    public int compareTo(DataType o)
    {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof DataType))
            return false;
        return getName().equals(((DataType) obj).getName());
    }

    public String getName()
    {
        return name;
    }
    
    public TypeName getType()
    {
        return typeName;
    }
    
    public String getTypeName()
    {
        return typeName.getTypeName();
    }

    public void setPrimaryKey(boolean isPrimaryKey)
    {
        this.isPrimaryKey = isPrimaryKey;
    }

    public boolean isPrimaryKey()
    {
        return isPrimaryKey;
    }

    public void setNullable(boolean isNotNull)
    {
        this.isNullable = isNotNull;
    }

    public boolean isNullable()
    {
        return isNullable;
    }

    public String toString()
    {
        return String.format("%s (%s)", getName(), getTypeName() + (isPrimaryKey ? " pkey" : ""));
    }

}

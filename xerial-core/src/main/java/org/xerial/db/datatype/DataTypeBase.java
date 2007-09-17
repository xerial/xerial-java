//--------------------------------------
// XerialJ Project
//
// DataTypeBase.java
// Since: 2007/04/13
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;

public abstract class DataTypeBase implements DataType
{
	private String name;
	private boolean isPrimaryKey = false;
	private boolean isNotNull = false;
	
	public DataTypeBase(String name)
	{
		this.name = name;
	}
	
	public DataTypeBase(String name, boolean isPrimaryKey)
	{
		this.name = name;
		this.isPrimaryKey = isPrimaryKey;
	}

	// hide the default constructor
	private DataTypeBase() {}
	
	public DataTypeBase(String name, boolean isPrimaryKey, boolean isNotNull) {
		this.name = name;
		this.isPrimaryKey = isPrimaryKey;
		this.isNotNull = isNotNull;
	}


	public int compareTo(DataType o)
    {
        return this.getName().compareTo(o.getName());
    }

	
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof DataType))
            return false;
        return getName().equals(((DataType) obj).getName());
    }

    public String getName() {
		return name;
	}
	

	public void setAsPrimaryKey()
	{
		this.isPrimaryKey = true;
	}
	
	public boolean isPrimaryKey()
	{
		return isPrimaryKey;
	}
	
	public void setNotNull()
	{
		this.isNotNull = true;
	}
	public boolean isNotNull()
	{
		return isNotNull;
	}

}





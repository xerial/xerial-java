//--------------------------------------
// Xerial Project
//
// Relation.java
// Since: 2007/03/28
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/gwt/web/client/db/Relation.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xerial.db.datatype.BooleanType;
import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.DoubleType;
import org.xerial.db.datatype.IntegerType;
import org.xerial.db.datatype.PasswordType;
import org.xerial.db.datatype.StringType;
import org.xerial.db.datatype.TextType;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONObject;


/**
 * A Relation holds one or more DataTypes and denotes their relationships.
 * For example, in relational databases, a table has a structure, e.g. 
 * (pid:integer, name:string, address:string)
 * 
 * You can construct this structure as follows:
 * <code>
 * Relation r = new Relation();
 * r.add("pid", new IntegerType());
 * r.add("name", new StringType());
 * r.add("address", new StringType());
 * </code>
 * 
 * JSON format example. 
 * <code>
 * {"relation":[["id", "integer"], ["name", "string"], ...]}
 * </code>
 * 
 * 
 * @author leo
 *
 */
public class Relation 
{
    private ArrayList<DataType> dataTypeList = new ArrayList<DataType>();
    
    public Relation() {}
    public Relation(String jsonStr) throws InvalidJSONDataException 
    {
    	JSONObject json = new JSONObject(jsonStr);
    	parse(json);
    }
    
    public Relation(JSONObject jsonObj) throws InvalidJSONDataException 
    {
    	parse(jsonObj);
    }
    
    private void parse(JSONObject jsonObj) throws InvalidJSONDataException 
    {
    	if(jsonObj == null)
    		throw new InvalidJSONDataException("null json object");

    	if(!jsonObj.hasKey("relation"))
    		throw new InvalidJSONDataException("no relation key found");
    	JSONArray relationList = jsonObj.getJSONArray("relation");
    	if(relationList == null)
    		return;
    	for(int i=0; i<relationList.size(); i++)
    	{
    		JSONArray dataTypePair = relationList.getJSONArray(i);
    		if(dataTypePair == null || dataTypePair.size() != 2)
    			throw new InvalidJSONDataException("data type must be json array with two elements: " + relationList.toString());
    		
    		String parameterName = dataTypePair.getString(0);
    		String typeName = dataTypePair.getString(1);

    		add(getDataType(parameterName, typeName));
    	}
    }
    
    public static DataType getDataType(String parameterName, String typeName) throws InvalidJSONDataException 
    {
		if(typeName.equals("boolean"))
			return new BooleanType(parameterName);
		else if(typeName.equals("double"))
			return new DoubleType(parameterName);
		else if(typeName.equals("string"))
			return new StringType(parameterName);
		else if(typeName.equals("password"))
			return new PasswordType(parameterName);
		else if(typeName.equals("text"))
			return new TextType(parameterName);
		else if(typeName.equals("integer"))
			return new IntegerType(parameterName);
		else
			throw new InvalidJSONDataException("unknown data type: " + typeName);
    }
    
    
    public void add(DataType dataType)
    {
        dataTypeList.add(dataType);
    }
    
    public DataType getDataType(int index)
    {
    	return dataTypeList.get(index);
    }
    
    public int getDataTypeIndex(String parameterName)
    {
        int index = 0;
        for(DataType dt : dataTypeList)
        {
            if(dt.getName().equals(parameterName))
                return index;
            index++;
        }
        throw new IllegalArgumentException("unknown parameter: " + parameterName);
    }
    
    public List getDataTypeList()
    {
    	return dataTypeList;
    }
    
    public String toString()
    {
    	StringBuffer s = new StringBuffer();
    	s.append("(");
    	for(Iterator it = dataTypeList.iterator(); it.hasNext(); )
    	{
    		DataType dt = (DataType) it.next();
    		s.append(dt.toString());
    		s.append(" ");
    	}
    	s.append(")");
    	return s.toString();
    }
    
}





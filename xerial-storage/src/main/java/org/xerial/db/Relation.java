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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.xerial.db.datatype.DataType;
import org.xerial.db.datatype.DataTypeBase;
import org.xerial.db.datatype.TypeName;
import org.xerial.json.JSONArray;
import org.xerial.json.JSONErrorCode;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;

/**
 * A Relation holds one or more DataTypes and denotes their relationships. For
 * example, in relational databases, a table has a structure, e.g. (pid:integer,
 * name:string, address:string)
 * 
 * You can construct this structure as follows: <code>
 * Relation r = new Relation();
 * r.add("pid", new IntegerType());
 * r.add("name", new StringType());
 * r.add("address", new StringType());
 * </code>
 * 
 * JSON format example. <code>
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

    public Relation(String jsonStr) throws JSONException {
        JSONObject json = new JSONObject(jsonStr);
        parse(json);
    }

    public Relation(JSONObject jsonObj) throws JSONException {
        parse(jsonObj);
    }

    private void parse(JSONObject jsonObj) throws JSONException {
        if (jsonObj == null)
            throw new JSONException(JSONErrorCode.InvalidJSONData, "null json object");

        if (!jsonObj.hasKey("relation"))
            throw new JSONException(JSONErrorCode.InvalidJSONData, "no relation key found");
        JSONArray relationList = jsonObj.getJSONArray("relation");
        if (relationList == null)
            return;
        for (int i = 0; i < relationList.size(); i++) {
            JSONArray dataTypePair = relationList.getJSONArray(i);
            if (dataTypePair == null || dataTypePair.size() != 2)
                throw new JSONException(JSONErrorCode.InvalidJSONData,
                        "data type must be json array with two elements: " + relationList.toString());

            String parameterName = dataTypePair.getString(0);
            String typeName = dataTypePair.getString(1);

            add(getDataType(parameterName, typeName));
        }
    }

    public static DataType getDataType(String parameterName, String typeName) {
        if (typeName.equalsIgnoreCase("boolean"))
            return new DataTypeBase(parameterName, TypeName.BOOLEAN);
        else if (typeName.equalsIgnoreCase("int") || typeName.equalsIgnoreCase("integer") || typeName.equals("serial"))
            return new DataTypeBase(parameterName, TypeName.INTEGER);
        else if (typeName.equalsIgnoreCase("string"))
            return new DataTypeBase(parameterName, TypeName.STRING);
        else if (typeName.equalsIgnoreCase("double"))
            return new DataTypeBase(parameterName, TypeName.DOUBLE);
        else if (typeName.equalsIgnoreCase("long"))
            return new DataTypeBase(parameterName, TypeName.LONG);
        else if (typeName.equalsIgnoreCase("password"))
            return new DataTypeBase(parameterName, TypeName.PASSWORD);
        else if (typeName.equalsIgnoreCase("text"))
            return new DataTypeBase(parameterName, TypeName.TEXT);
        else if (typeName.equalsIgnoreCase("datetime"))
            return new DataTypeBase(parameterName, TypeName.DATETIME);
        else if (typeName.equalsIgnoreCase("blob"))
            return new DataTypeBase(parameterName, TypeName.BLOB);
        else
            return new DataTypeBase(parameterName, TypeName.STRING);
    }

    public static <T> DataType getDataType(String parameterName, Class<T> valueType) {
        if (valueType.isAssignableFrom(Integer.class) || valueType.isAssignableFrom(int.class))
            return new DataTypeBase(parameterName, TypeName.INTEGER);
        else if (valueType.isAssignableFrom(String.class))
            return new DataTypeBase(parameterName, TypeName.STRING);
        else if (valueType.isAssignableFrom(Double.class) || valueType.isAssignableFrom(double.class))
            return new DataTypeBase(parameterName, TypeName.DOUBLE);
        else if (valueType.isAssignableFrom(Boolean.class) || valueType.isAssignableFrom(boolean.class))
            return new DataTypeBase(parameterName, TypeName.BOOLEAN);
        else if (valueType.isAssignableFrom(Long.class) || valueType.isAssignableFrom(long.class))
            return new DataTypeBase(parameterName, TypeName.LONG);
        else if (valueType.isAssignableFrom(Date.class))
            return new DataTypeBase(parameterName, TypeName.DATETIME);
        else if (valueType.isAssignableFrom(byte[].class))
            return new DataTypeBase(parameterName, TypeName.BLOB);
        else
            return new DataTypeBase(parameterName, TypeName.STRING);
    }

    public void add(DataType dataType) {
        dataTypeList.add(dataType);
    }

    public DataType getDataType(int index) {
        return dataTypeList.get(index);
    }

    public int getDataTypeIndex(String parameterName) {
        int index = 0;
        for (DataType dt : dataTypeList) {
            if (dt.getName().equals(parameterName))
                return index;
            index++;
        }
        throw new IllegalArgumentException("unknown parameter: " + parameterName);
    }

    public List<DataType> getDataTypeList() {
        return dataTypeList;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("(");
        for (Iterator it = dataTypeList.iterator(); it.hasNext();) {
            DataType dt = (DataType) it.next();
            s.append(dt.toString());
            s.append(" ");
        }
        s.append(")");
        return s.toString();
    }

}

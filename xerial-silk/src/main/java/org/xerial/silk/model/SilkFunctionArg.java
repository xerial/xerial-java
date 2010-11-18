/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// KeyValuePair.java
// Since: Jan 30, 2009 7:47:01 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.model;


/**
 * Silk function argument
 * 
 * @author leo
 * 
 */
public class SilkFunctionArg {
    private String argName = null;
    private SilkValue value = null;

    public static SilkFunctionArg newArgValue(String value) {
        return new SilkFunctionArg(null, value);
    }

    public SilkFunctionArg() {}

    public SilkFunctionArg(String argName, String value) {
        this.argName = argName;
        setValue(value);
    }

    public String getName() {
        return argName;
    }

    public void setKey(String argName) {
        this.argName = argName;
    }

    public SilkValue getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = new SilkTextValue(value);
    }

    public void setJSON(String jsonValue) {
        this.value = new SilkJSONValue(jsonValue);
    }

    public boolean hasName() {
        return argName != null;
    }

    @Override
    public String toString() {
        if (hasName()) {
            if (value == null)
                return argName;
            else
                return String.format("%s:%s", argName, value);
        }
        else {
            if (value == null)
                return "";
            else
                return value.toString();
        }
    }
}

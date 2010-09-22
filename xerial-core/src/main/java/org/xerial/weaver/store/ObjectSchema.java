/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// ObjectSchema.java
// Since: Sep 21, 2010 3:35:00 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.store;

/**
 * Schema of an object
 * 
 * @author leo
 * 
 */
public class ObjectSchema {

    public static enum DataType {
        // primitive types
        INT, // (31-bit signed integer)
        FLOAT, // (32-bit floating point value)
        LONG, // (63-bit signed integer)
        DOUBLE, // (64-bit floating point value; double type)
        STRING, // (UTF-8 string)
        BOOLEAN, // (Boolean value: True or False)

    }

}

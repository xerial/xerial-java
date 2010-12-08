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
// ByteArray.java
// Since: 2008/07/03 19:37:23
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

/**
 * byte[] data wrapper for representing BLOB data
 * 
 * @author leo
 * 
 * @deprecated use public byte[] fields instead
 * 
 */
public class ByteArray
{
    byte[] data = null;

    public ByteArray() {

    }

    public ByteArray(byte[] byteArray) {
        this.data = byteArray;
    }

    public byte[] getBytes() {
        return data;
    }

    public void setBytes(byte[] byteArray) {
        this.data = byteArray;
    }

    public int size() {
        return data == null ? 0 : data.length;
    }

}

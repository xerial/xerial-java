/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// UTF8String.java
// Since: 2011/05/29 14:31:33
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.nio.charset.Charset;

/**
 * UTF8 String
 * 
 * @author leo
 * 
 */
public class UTF8String {
    public final static Charset UTF8 = Charset.forName("UTF-8");

    private final byte[] str;
    private String s;

    public UTF8String(byte[] str) {
        this(str, 0, str.length);
    }

    public UTF8String(byte[] input, int offset, int len) {
        this.str = new byte[len];
        System.arraycopy(input, offset, this.str, 0, len);
    }

    public UTF8String(char[] input, int offset, int len) {
        this.str = new String(input, offset, len).getBytes(UTF8);
    }

    public UTF8String(String s) {
        this.s = s;
        this.str = s.getBytes(UTF8);
    }

    public int get(int index) {
        return str[index];
    }

    public byte[] getBytes() {
        return str;
    }

    public int byteSize() {
        return str.length;
    }

    public int length() {
        return toString().length();
    }

    @Override
    public String toString() {
        if (s == null) {
            s = new String(str, UTF8);
        }
        return s;
    }

}

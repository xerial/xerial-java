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
// AlNum.java
// Since: 2011/06/14 10:47:01
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String with alphabet prefix and numbers. Useful for representing chromosome
 * numbers e.g., chr1, chr10, etc.
 * 
 * @author leo
 * 
 */
public class Alnum implements Comparable<Alnum> {

    public final String prefix;
    public final int number;
    private int hash = 0;
    private String orig;

    private final static Pattern alnum = Pattern.compile("([^0-9]+)([0-9]+)");

    public Alnum(String s) {
        Matcher m = alnum.matcher(s);
        if (!m.matches())
            throw new IllegalArgumentException("invalid input: " + s);

        this.prefix = m.group(1);
        this.number = Integer.parseInt(m.group(2));
        this.orig = s;
    }

    public Alnum(String prefix, int number) {
        this.prefix = prefix;
        this.number = number;
        this.orig = toString();
    }

    @Override
    public String toString() {
        return orig;
    }

    @Override
    public int compareTo(Alnum o) {
        int diff = prefix.compareTo(o.prefix);
        if (diff != 0)
            return diff;
        return number - o.number;
    }

    @Override
    public int hashCode() {
        if (hash == 0) {
            int h = prefix.hashCode();
            h += number * 31;
            hash = h;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alnum) {
            Alnum o = Alnum.class.cast(obj);
            return this.compareTo(o) == 0;
        }
        else
            return false;
    }

}

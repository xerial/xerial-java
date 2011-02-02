/*--------------------------------------------------------------------------
 *  Copyright 2009 utgenome.org
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
// Optional.java
// Since: May 27, 2010
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * variable holder that can distinguish defined/undefined states.
 * 
 * @author leo
 * 
 */
public class Optional<T> {

    private boolean isDefined = false;
    private T holder;

    public Optional() {}

    public boolean isDefined() {
        return isDefined;
    }

    public boolean isUndefined() {
        return !isDefined;
    }

    public T get() {
        return holder;
    }

    public void set(T value) {
        this.holder = value;
        this.isDefined = true;
    }

    public void reset() {
        this.holder = null;
        this.isDefined = false;
    }

}

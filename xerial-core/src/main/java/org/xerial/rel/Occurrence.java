/*--------------------------------------------------------------------------
 *  Copyright 2008 utgenome.org
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
// utgb-core Project
//
// Occurrence.java
// Since: Jan 5, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.rel;

/**
 * specifies multiple occurrences of data objects
 * 
 * @author leo
 * 
 */
public enum Occurrence {
    ONE, ZERO_OR_MORE, ONE_OR_MORE, ZERO_OR_ONE, SEQUENCE, TABBED_SEQUENCE
}

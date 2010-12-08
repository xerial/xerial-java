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
// TupleComparator.java
// Since: Sep 19, 2007 9:21:41 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.Comparator;

/**
 * Comparator defines sort total order of tuples: that is 
 * given two tuples t1, t2;
 * 
 * 1. when t1.equals(t2), compare(t1, t2) = 0, that is, compare(t1, t1) = 0  
 * 2. when t1.compare(t1, t2) < 0, t2.compare(t1) > 0. (reflexible)
 * 3. if compare(t1, t2) < 0 and compare(t2, t3) < 0, then compare(t1, t3) < 0 (transitivity)
 * 
 * @author leo
 *
 */
public interface TupleComparator extends Comparator<Tuple>
{
    public int compare(Tuple t1, Tuple t2);
}



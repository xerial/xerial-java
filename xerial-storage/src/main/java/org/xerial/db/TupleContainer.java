/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// TupleContainer.java
// Since: Sep 1, 2008 10:37:07 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

import java.util.Collection;

/**
 * A container for {@link Tuple} classes
 * 
 * @author leo
 * 
 */
public interface TupleContainer extends Collection<Tuple>
{

    /**
     * Test whether the container has enough capacity for storing the tuple
     * 
     * @param tuple
     * @return
     */
    public boolean hasCapacityFor(Tuple tuple);

}

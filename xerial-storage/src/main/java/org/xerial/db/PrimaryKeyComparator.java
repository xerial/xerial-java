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
// PrimaryKeyComparator.java
// Since: Sep 1, 2008 11:52:34 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

public class PrimaryKeyComparator implements TupleComparator
{
    int primaryKeyColumnIndex = 0;

    public PrimaryKeyComparator()
    {}

    public PrimaryKeyComparator(int primaryKeyColumnIndex)
    {
        this.primaryKeyColumnIndex = primaryKeyColumnIndex;
    }

    @SuppressWarnings("unchecked")
    public int compare(Tuple t1, Tuple t2)
    {
        Object v1 = t1.getValue(primaryKeyColumnIndex);
        Object v2 = t2.getValue(primaryKeyColumnIndex);

        if (t1 == null)
            return (t2 != null) ? -1 : 0;
        else if (t2 == null)
            return -1;

        Comparable c1 = Comparable.class.cast(v1);

        return c1.compareTo(v2);
    }

}

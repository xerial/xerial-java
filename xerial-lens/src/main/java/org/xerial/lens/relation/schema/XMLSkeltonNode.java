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
// Xerial Raquel Project
//
// XMLSkeltonNode.java
// Since: 2009/03/14 22:38:36
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.util.IndexedSet;
import org.xerial.util.StringUtil;

/**
 * 
 * @author leo
 * 
 */
public class XMLSkeltonNode implements Iterable<Schema>
{
    private final ArrayList<Schema> vector = new ArrayList<Schema>();
    private final IndexedSet<Schema> relationIndex = new IndexedSet<Schema>();
    private final HashSet<String> mNodeSet = new HashSet<String>();
    private final String coreNodeName;

    public XMLSkeltonNode(List<Schema> relationList)
    {
        if (relationList.isEmpty())
            throw new XerialError(XerialErrorCode.INVALID_STATE, "relationList is empty");

        for (Schema each : relationList)
        {
            vector.add(each);
            relationIndex.add(each);
        }
        coreNodeName = vector.get(0).getName();

        for (Schema each : vector)
        {
            if (each.isOneToMany())
            {
                for (int i = 0; i < each.size(); i++)
                {
                    String mNode = each.get(i).getName();
                    if (!mNode.equals(coreNodeName))
                        mNodeSet.add(mNode);
                }
            }
        }
    }

    public String getCoreNodeName()
    {
        return coreNodeName;
    }

    public boolean hasManyNode(String nodeName)
    {
        return mNodeSet.contains(nodeName);
    }

    public int size()
    {
        return vector.size();
    }

    public Iterator<Schema> iterator()
    {
        return vector.iterator();
    }

    public Schema get(int index)
    {
        return vector.get(index);
    }

    public int getID(Schema relation)
    {
        return relationIndex.getID(relation);
    }

    @Override
    public String toString()
    {
        return StringUtil.join(relationIndex, ",\\n");
    }

}

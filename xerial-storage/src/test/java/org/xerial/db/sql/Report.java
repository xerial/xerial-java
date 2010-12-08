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
// Report.java
// Since: Jun 27, 2008 12:51:53 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.util.Date;

public class Report implements Comparable<Report>
{
    int id = -1;
    int personId = -1;
    Date createdAt;
    Date modifiedAt;

    public Report()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPersonId()
    {
        return personId;
    }

    public void setPersonId(int personId)
    {
        this.personId = personId;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt()
    {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString()
    {
        return String.format("id=%d, person_id=%d, createdAt=%s, modifiedAt=%s", id, personId, createdAt, modifiedAt);
    }

    public int compareTo(Report other)
    {
        return this.getId() - other.getId();
    }

}

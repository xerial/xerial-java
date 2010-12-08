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
// SubmittedReport.java
// Since: Jul 7, 2008 8:36:03 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A relation that connects a person and a report
 * 
 * @author leo
 * 
 */
public class SubmittedReport
{
    int id = -1;
    Person person = null;
    ArrayList<Report> reportList = new ArrayList<Report>();
    Date createdAt;
    Date modifiedAt;

    public SubmittedReport()
    {}

    public SubmittedReport(Person person)
    {
        this.person = person;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public List<Report> getReport()
    {
        return reportList;
    }

    public void addReport(Report report)
    {
        reportList.add(report);
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

}

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
// SQLPerformanceTest.java
// Since: Oct 22, 2008 9:41:36 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.xerial.db.DBException;
import org.xerial.db.sql.h2.H2Access;
import org.xerial.db.sql.impl.ObjectStorageImpl;
import org.xerial.db.sql.sqlite.SQLiteAccess;
import org.xerial.util.StopWatch;
import org.xerial.util.log.Logger;

public class SQLPerformanceTest
{
    private static Logger _logger = Logger.getLogger(SQLPerformanceTest.class);
    static final int      N       = 100;

    public void insertPerson(DatabaseAccess dbAccess, ObjectStorage storage) throws DBException {
        storage.drop(Person.class);

        dbAccess.setAutoCommit(false);
        StopWatch timer = new StopWatch();
        // insert N people
        timer.reset();
        for (int i = 0; i < N; i++)
            storage.create(new Person("person" + Integer.toString(i)));

        dbAccess.update("commit");

        _logger.debug(String.format("%f sec.", timer.getElapsedTime()));
    }

    @Test
    public void SQLite() throws DBException {
        //DatabaseAccess sqlite = new SQLiteAccess("target/sample.sqlite");
        DatabaseAccess sqlite = new SQLiteAccess();
        sqlite.update("pragma synchronous=off");
        ObjectStorage storage = new ObjectStorageImpl(sqlite);
        insertPerson(sqlite, storage);
        assertEquals(N, storage.count(Person.class));
    }

    @Test
    public void H2() throws ClassNotFoundException, SQLException, DBException {
        //DatabaseAccess h2 = new H2Access("target/h2/sample");
        DatabaseAccess h2 = new H2Access();
        h2.update("SET LOCK_MODE 0");
        ObjectStorage storage = new ObjectStorageImpl(h2);
        //ObjectStorage storage = new ObjectStorageImpl(new H2Access());
        insertPerson(h2, storage);
        assertEquals(N, storage.count(Person.class));
    }

}

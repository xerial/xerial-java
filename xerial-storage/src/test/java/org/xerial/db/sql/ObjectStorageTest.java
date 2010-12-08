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
// ObjectStorageTest.java
// Since: Jun 26, 2008 3:30:06 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.db.sql.impl.ObjectStorageImpl;
import org.xerial.db.sql.sqlite.SQLiteAccess;
import org.xerial.util.Predicate;
import org.xerial.util.log.Logger;

public class ObjectStorageTest
{
    private static Logger     _logger = Logger.getLogger(ObjectStorageTest.class);
    private ObjectStorageImpl storage;

    @Before
    public void setUp() throws Exception {
        storage = new ObjectStorageImpl(new SQLiteAccess()); // use an on-memory database of SQLite
    }

    @After
    public void tearDown() throws Exception {
        storage.getDatabaseAccess().dispose();
    }

    @Test
    public void testRegister() throws DBException {
        storage.register(Person.class);
        List<String> tableNameList = storage.getDatabaseAccess().getTableNameList();

        assertTrue(tableNameList.contains("person"));

    }

    @Test
    public void testRegistWithTableName() throws DBException {
        storage.register("person_table", Person.class);
        Person p = storage.create(new Person("leo"));

        List<Person> personList = storage.getAll(Person.class);
        assertEquals(1, personList.size());
        Person p2 = personList.get(0);
        assertEquals(p.getId(), p2.getId());
        assertEquals(p.getName(), p2.getName());
    }

    @Test
    public void createAssocatedObject() throws DBException {
        Person p = storage.create(new Person("leo"));
        _logger.debug(p);
        Report r = storage.create(p, new Report());
        _logger.debug(r);

        assertTrue(p.getId() >= 1);
        assertEquals(p.getId(), r.getPersonId());
        assertTrue(r.getId() >= 1);
    }

    @Test
    public void timeStampTest() throws DBException {
        Person p = storage.create(new Person("leo"));
        _logger.debug(p);
        Report r = storage.create(p, new Report());
        _logger.debug(r);

        assertTrue(p.getId() >= 1);
        assertEquals(p.getId(), r.getPersonId());
        assertTrue(r.getId() >= 1);

        assertNotNull(r.getCreatedAt());
        assertNotNull(r.getModifiedAt());

        assertEquals(r.getCreatedAt(), r.getModifiedAt());

        Report r2 = storage.get(Report.class, r.getId());
        _logger.debug(r2);

        assertEquals(r.getId(), r2.getId());
        assertEquals(r.getPersonId(), r2.getPersonId());

        // date time values are round to hh:mm:ss  
        assertEquals(r.getCreatedAt(), r2.getCreatedAt());
        assertEquals(r.getModifiedAt(), r2.getModifiedAt());

        Date rCreatedAt = (Date) r.getCreatedAt().clone();

        try {
            Thread.sleep(1000 * 1);
        }
        catch (InterruptedException e) {
            fail(e.getMessage());
        }
        storage.save(r);
        Report r3 = storage.get(Report.class, r.getId());
        _logger.debug(r3);

        assertEquals(rCreatedAt, r3.getCreatedAt());
        _logger.debug(rCreatedAt.getTime());
        _logger.debug(r3.getModifiedAt().getTime());
        assertTrue(rCreatedAt.compareTo(r3.getModifiedAt()) <= 0);

    }

    @Test
    public void testOneToOne() throws DBException {
        storage.oneToOne(Person.class, Report.class);

        Person p = storage.create(new Person("leo"));
        Report r = storage.create(p, new Report());

        Report r2 = storage.getOne(p, Report.class);

        assertNotNull(r2);
        assertEquals(r.getId(), r2.getId());
        assertEquals(r.getPersonId(), r2.getPersonId());
        assertEquals(r.getCreatedAt(), r2.getCreatedAt());
        assertEquals(r.getModifiedAt(), r2.getModifiedAt());

        try {
            Report r3 = storage.create(p, new Report());
            fail("cannot not create two or more duplicate objects associated as one to one");
        }
        catch (DBException e) {
            assertEquals(DBErrorCode.AssociatedObjectAlreadyExist, e.getErrorCode());
        }

        Person p2 = storage.getParent(r, Person.class);
        assertNotNull(p2);
        assertEquals(p.getId(), p2.getId());
        assertEquals(p.getName(), p2.getName());

        Report r3 = storage.getOne(Person.class, p.getId(), Report.class);
        assertEquals(r.getId(), r3.getId());
        assertEquals(r.getPersonId(), r3.getPersonId());
        assertEquals(r.getCreatedAt(), r3.getCreatedAt());
        assertEquals(r.getModifiedAt(), r3.getModifiedAt());

        Report r4 = storage.getOne(p, Report.class, r3.getId());
        assertEquals(r3.getId(), r4.getId());
        assertEquals(r3.getPersonId(), r4.getPersonId());
        assertEquals(r3.getCreatedAt(), r4.getCreatedAt());
        assertEquals(r3.getModifiedAt(), r4.getModifiedAt());
    }

    @Test
    public void testOneToMany() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        List<Report> reportList = storage.getAllWithSorting(p, Report.class);
        assertEquals(2, reportList.size());
        Report a1 = reportList.get(0);
        Report a2 = reportList.get(1);

        assertEquals(r1.getId(), a1.getId());
        assertEquals(r1.getPersonId(), a1.getPersonId());
        assertEquals(r1.getCreatedAt(), a1.getCreatedAt());
        assertEquals(r1.getModifiedAt(), a1.getModifiedAt());

        assertEquals(r2.getId(), a2.getId());
        assertEquals(r2.getPersonId(), a2.getPersonId());
        assertEquals(r2.getCreatedAt(), a2.getCreatedAt());
        assertEquals(r2.getModifiedAt(), a2.getModifiedAt());

        // retrieve report list using the ID value of the parent
        List<Report> reportList2 = storage.getAll(Person.class, p.getId(), Report.class);
        Collections.sort(reportList2);
        assertEquals(2, reportList2.size());
        a1 = reportList2.get(0);
        a2 = reportList2.get(1);

        assertEquals(r1.getId(), a1.getId());
        assertEquals(r1.getPersonId(), a1.getPersonId());
        assertEquals(r1.getCreatedAt(), a1.getCreatedAt());
        assertEquals(r1.getModifiedAt(), a1.getModifiedAt());

        assertEquals(r2.getId(), a2.getId());
        assertEquals(r2.getPersonId(), a2.getPersonId());
        assertEquals(r2.getCreatedAt(), a2.getCreatedAt());
        assertEquals(r2.getModifiedAt(), a2.getModifiedAt());

        // get all with additional condition
        List<Report> reportList3 = storage.getAll(p, Report.class, new QueryParam().setWhereCondition("id > 1"));
        for (Report r : reportList3) {
            assertTrue(r.getId() > 1);
        }

    }

    public static void isEqualPerson(Person p, Person q) {
        assertEquals(p.getId(), q.getId());
        assertEquals(p.getName(), q.getName());
    }

    @Test
    public void testGetAllWithCondition() throws DBException {
        Person yui = storage.create(new Person("yui"));
        Person sam = storage.create(new Person("sam"));
        Person leo = storage.create(new Person("leo"));

        List<Person> personList = storage.getAll(Person.class, "select * from person where name = 'leo'");
        assertEquals(1, personList.size());

        Person r = personList.get(0);
        isEqualPerson(leo, r);

        List<Person> personList2 = storage.getAll(Person.class, new QueryParam().setWhereCondition("name = 'yui'"));
        assertEquals(1, personList2.size());
        Person r2 = personList2.get(0);
        isEqualPerson(yui, r2);

        Person r3 = storage.get(Person.class, new QueryParam().setWhereCondition("name = 'yui'"));
        assertNotNull(r3);
        isEqualPerson(yui, r3);

        List<Person> personList3 = storage.getAll(Person.class, new QueryParam().setOrderByColumns("name"));
        assertEquals(3, personList3.size());
        isEqualPerson(personList3.get(0), leo);
        isEqualPerson(personList3.get(1), sam);
        isEqualPerson(personList3.get(2), yui);

        assertEquals(3, storage.count(Person.class));

        for (int i = 0; i < 10; i++)
            storage.create(new Person());

        assertEquals(13, storage.count(Person.class));

        assertEquals(1, storage.count(Person.class, new QueryParam().setWhereCondition("name = 'leo'")));

    }

    @Test
    public void testGetAllClassOfTIntClassOfUString() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        List<Report> reportList = storage.getAll(Person.class, 1, Report.class);
        assertEquals(2, reportList.size());
    }

    @Test
    public void testGetParentClassOfUInt() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        Person rp = storage.getParent(Person.class, Report.class, r1.getId());
        assertEquals(p.getId(), rp.getId());
        assertEquals(p.getName(), rp.getName());

        Person rp2 = storage.getParent(Person.class, Report.class, r2.getId());
        assertEquals(p.getId(), rp2.getId());
        assertEquals(p.getName(), rp2.getName());
    }

    @Test
    public void testCreate() throws DBException {
        Person p = storage.create(new Person("leo"));
        _logger.debug(p.toString());
        assertTrue(p.getId() >= 0);
        assertEquals("leo", p.getName());

        Person p2 = storage.create(new Person("yui"));
        _logger.debug(p2.toString());
        assertTrue(p2.getId() >= p.getId());
        assertEquals("yui", p2.getName());

    }

    @Test
    public void testSave() throws DBException {
        Person p = storage.create(new Person("leo"));
        assertTrue(p.getId() >= 0);
        assertEquals("leo", p.getName());

        int id = p.getId();

        p.setName("Taro L. Saito");
        storage.save(p);
        assertEquals(id, p.getId());
        assertEquals("Taro L. Saito", p.getName());

    }

    @Test
    public void testSaveAll() throws DBException {
        Person p = storage.create(new Person("leo"));
        Person p2 = storage.create(new Person("yui", "xxx-xxxx"));
        assertTrue(p.getId() >= 0);
        assertEquals("leo", p.getName());

        int id = p.getId();
        int id2 = p2.getId();

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p2);

        p.setName("Taro L. Saito");
        p2.setName("Yui Yui");
        p2.setAddress("yyy-yyyy");
        storage.saveAll(Person.class, list);

        Person newP = storage.get(Person.class, id);
        Person newP2 = storage.get(Person.class, id2);
        assertNotNull(newP);
        assertNotNull(newP2);

        _logger.debug(newP);
        _logger.debug(newP2);

        assertEquals(id, newP.getId());
        assertEquals("Taro L. Saito", newP.getName());
        assertEquals("", newP.getAddress());

        assertEquals(id2, newP2.getId());
        assertEquals("Yui Yui", newP2.getName());
        assertEquals("yyy-yyyy", newP2.getAddress());

    }

    @Test
    public void testAbortInSaveAll() throws DBException {
        Person p = storage.create(new Person("leo"));
        Person p2 = storage.create(new Person("yui", "xxx-xxxx"));
        assertTrue(p.getId() >= 0);
        assertEquals("leo", p.getName());

        int id = p.getId();
        int id2 = p2.getId();

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(null);

        p.setName("Taro L. Saito");
        try {
            storage.saveAll(Person.class, list);
            fail("cannot reach here");
        }
        catch (DBException e) {
            _logger.debug("intended abort: " + e.getMessage());
        }

        Person newP = storage.get(Person.class, id);
        Person newP2 = storage.get(Person.class, id2);
        assertNotNull(newP);
        assertNotNull(newP2);

        _logger.debug(newP);
        _logger.debug(newP2);

        assertEquals(id, newP.getId());
        assertEquals("leo", newP.getName());
        assertEquals("", newP.getAddress());

        assertEquals(id2, newP2.getId());
        assertEquals("yui", newP2.getName());
        assertEquals("xxx-xxxx", newP2.getAddress());

    }

    @Test
    public void testGetClassOfTInt() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxx"));
        int id = p.getId();

        Person p2 = storage.get(Person.class, 1);

        assertEquals(id, p2.getId());
        assertEquals(p.getName(), p2.getName());
        assertEquals(p.getAddress(), p2.getAddress());
    }

    @Test
    public void testGetClassOfTString() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxx"));
        int id = p.getId();

        Person p2 = storage.get(Person.class, "select * from person where id = " + id);

        assertEquals(id, p2.getId());
        assertEquals(p.getName(), p2.getName());
        assertEquals(p.getAddress(), p2.getAddress());
    }

    @Test
    public void testGetAllClassOfT() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxxx"));
        Person p2 = storage.create(new Person("yui", "yyy-yyyy"));

        TreeSet<Person> personList = new TreeSet<Person>(storage.getAll(Person.class));
        assertEquals(2, personList.size());
        assertTrue(personList.contains(p));
        assertTrue(personList.contains(p2));

        Person pf = personList.first();
        assertEquals(p.getId(), pf.getId());
        assertEquals(p.getName(), pf.getName());
        assertEquals(p.getAddress(), pf.getAddress());
        pf = personList.last();
        assertEquals(p2.getId(), pf.getId());
        assertEquals(p2.getName(), pf.getName());
        assertEquals(p2.getAddress(), pf.getAddress());

    }

    @Test
    public void testGetAllClassOfTString() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxxx"));
        Person p2 = storage.create(new Person("yui", "yyy-yyyy"));

        TreeSet<Person> personList = new TreeSet<Person>(storage.getAll(Person.class, "select * from person"));
        assertEquals(2, personList.size());
        assertTrue(personList.contains(p));
        assertTrue(personList.contains(p2));

        Person pf = personList.first();
        assertEquals(p.getId(), pf.getId());
        assertEquals(p.getName(), pf.getName());
        assertEquals(p.getAddress(), pf.getAddress());
        pf = personList.last();
        assertEquals(p2.getId(), pf.getId());
        assertEquals(p2.getName(), pf.getName());
        assertEquals(p2.getAddress(), pf.getAddress());

    }

    @Test
    public void testGetAllWithPredicate() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxxx"));
        Person p2 = storage.create(new Person("yui", "yyy-yyyy"));

        TreeSet<Person> personList = new TreeSet<Person>(storage.getAll(Person.class, new Predicate<Person>() {
            public boolean apply(Person input) {
                return input.getName().contains("yui");
            }
        }));

        assertEquals(1, personList.size());
        Person pf = personList.first();
        assertEquals(p2.getId(), pf.getId());
        assertEquals(p2.getName(), pf.getName());
        assertEquals(p2.getAddress(), pf.getAddress());

    }

    @Test
    public void testBlob() throws DBException, SQLException {
        FileWithBlob f = storage.create(new FileWithBlob());
        f.setTitle("hello.txt");
        String blobMessage = "hello world";
        f.setSize(blobMessage.length());
        f.setFileData(blobMessage.getBytes());

        storage.save(f);

        FileWithBlob f2 = storage.get(FileWithBlob.class, f.getId());
        assertEquals(f.getId(), f2.getId());
        assertEquals(f.getTitle(), f2.getTitle());
        assertEquals(f.getSize(), f2.getSize());

        String blobMessage2 = new String(f2.getFileData());
        assertEquals(blobMessage, blobMessage2);

    }

    @Test
    public void testJoin() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxxx"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        Person pr = storage.get(Person.class, p.id);
        List<Report> reportList = storage.getAll(pr, Report.class);

        SubmittedReport sr = new SubmittedReport(pr);
        for (Report r : reportList)
            sr.addReport(r);

        assertEquals(2, reportList.size());

    }

    @Test
    public void testDelete() throws DBException {
        Person p1 = storage.create(new Person("leo", "xxx-xxxx"));
        Person p2 = storage.create(new Person("yui", "xxx-xxxx"));
        Person p3 = storage.create(new Person("nao", "xxx-xxxx"));

        assertEquals(3, storage.count(Person.class));
        storage.delete(p1);

        assertEquals(null, storage.get(Person.class, p1.getId()));
        assertEquals(2, storage.count(Person.class));

        storage.delete(Person.class, p2.getId());
        assertEquals(null, storage.get(Person.class, p2.getId()));
        assertEquals(1, storage.count(Person.class));
    }

    @Test
    public void testOmitCreatedAtAttributeWhenUpdate() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r = storage.create(p, new Report());
        r.setCreatedAt(null);

        storage.save(r);
    }

    @Test
    public void testGetAllAssociatedObjectsWithSorting() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        List<Report> reportList = storage.getAll(p, Report.class, new QueryParam().setOrderByColumns("id desc"));

        assertEquals(2, reportList.size());
        assertEquals(r2.getId(), reportList.get(0).getId());
        assertEquals(r1.getId(), reportList.get(1).getId());

    }

    public static void isEqual(PersonReport p1, PersonReport p2) {
        assertEquals(p1.getId(), p2.getId());
        assertEquals(p1.getReportId(), p2.getReportId());
        assertEquals(p1.getPersonId(), p2.getPersonId());
        assertEquals(p1.getTitle(), p2.getTitle());
    }

    @Test
    public void testManyMany() throws DBException {
        Person p = storage.create(new Person("leo"));
        Report r1 = storage.create(p, new Report());
        Report r2 = storage.create(p, new Report());

        PersonReport pr1 = storage.create(p, r1, new PersonReport("myreport"));
        assertEquals("myreport", pr1.getTitle());
        assertEquals(p.getId(), pr1.getPersonId());
        assertEquals(r1.getId(), pr1.getReportId());

        PersonReport pr2 = storage.create(p, r2, new PersonReport("second"));
        assertEquals("second", pr2.getTitle());
        assertEquals(p.getId(), pr2.getPersonId());
        assertEquals(r2.getId(), pr2.getReportId());

        PersonReport pr3 = storage.get(Person.class, p.getId(), Report.class, r1.getId(), PersonReport.class);
        assertEquals("myreport", pr3.getTitle());
        assertEquals(pr1.getId(), pr3.getId());
        assertEquals(p.getId(), pr3.getPersonId());
        assertEquals(r1.getId(), pr3.getReportId());

        PersonReport pr4 = storage.get(Person.class, p.getId(), Report.class, r2.getId(), PersonReport.class);
        assertEquals("second", pr4.getTitle());
        assertEquals(pr2.getId(), pr4.getId());
        assertEquals(p.getId(), pr4.getPersonId());
        assertEquals(r2.getId(), pr4.getReportId());

        List<PersonReport> prList = storage.getAll(Person.class, p.getId(), PersonReport.class);
        assertNotNull(prList);
        assertEquals(2, prList.size());
        isEqual(prList.get(0), pr3);
        isEqual(prList.get(1), pr4);

        // count
        assertEquals(2, storage.count(Person.class, p.getId(), PersonReport.class));
        assertEquals(1, storage.count(Person.class, p.getId(), Report.class, r1.getId(), PersonReport.class));
        assertEquals(0, storage.count(Person.class, p.getId(), Report.class, 10, PersonReport.class));

        assertEquals(1, storage.count(Person.class, p.getId(), Report.class, r2.getId(), PersonReport.class));

    }

    @Test
    public void testView() throws DBException {
        Person p = storage.create(new Person("leo", "xxx-xxxx"));
        List<PersonNameView> personNameView = storage.getAllFromView(PersonNameView.class, Person.class);
        assertEquals(1, personNameView.size());
        PersonNameView pv = personNameView.get(0);
        assertEquals(p.getId(), pv.getId());
        assertEquals(p.getName(), pv.getName());

        PersonNameView pv2 = storage.getFromView(PersonNameView.class, Person.class);
        assertEquals(p.getId(), pv2.getId());
        assertEquals(p.getName(), pv2.getName());

    }

}

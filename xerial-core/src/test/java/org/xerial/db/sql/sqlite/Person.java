//--------------------------------------
// XerialJ Project
//
// Person.java
// Since: May 10, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

public class Person
{
	int id;
	String name;
	
	public Person() {}
	
	public Person(int id)
	{
		this.id = id;
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}



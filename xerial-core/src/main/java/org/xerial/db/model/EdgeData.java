//--------------------------------------
// XerialJ Project
//
// EdgeData.java
// Since: May 15, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.model;

public class EdgeData implements Comparable<EdgeData>
{
	private int id;
	private int src;
	private int dest;
	private int relationship = -1;


	public EdgeData()
	{}
	
	/**
	 * @param id
	 * @param src
	 * @param dest
	 * @param relationship
	 */
	public EdgeData(int id, int src, int dest, Relationship relationship) {
		this.id = id;
		this.src = src;
		this.dest = dest;
		
		switch(relationship)
		{
		case OneToOne:
			this.relationship = 0;
			break;
		case OneToMany:
			this.relationship = 1;
			break;
		case ManyToMany:
			this.relationship = 2;
			break;
		default:
			this.relationship = 3;
		}
	}

	
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelationship() {
		return relationship;
	}
	
	public static Relationship translate(int relatinoship)
	{
		switch(relatinoship)
		{
		case 0:
			return Relationship.OneToOne;
		case 1:
			return Relationship.OneToMany;
		case 2:
			return Relationship.ManyToMany;
		default:
			return Relationship.Other;	
		}
	}
	
	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}

	public int compareTo(EdgeData o) {
		return id - o.id;
	}
	
	
	
}





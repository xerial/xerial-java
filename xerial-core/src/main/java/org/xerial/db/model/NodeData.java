//--------------------------------------
// XerialJ Project
//
// NodeData.java
// Since: May 15, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.model;


public class NodeData implements Comparable<NodeData>
{
	private int id;
	private String name;

	public NodeData()
	{}
	
	/**
	 * @param id
	 * @param name
	 */
	public NodeData(int id, String name) {
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

	public int compareTo(NodeData o) {
		return id - o.id;
	}
}



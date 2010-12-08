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





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
// XerialStorageContext.java
// Since: Jul 5, 2007 5:46:39 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import org.xerial.amoeba.AmoebaQuery;
import org.xerial.amoeba.AmoebaQueryResultSetHandler;
import org.xerial.amoeba.AmoebaTuple;
import org.xerial.db.DBException;

/**
 * 
 * 
 * <p>An example table data:
 * 
 * <pre>
 * Gene Table
 * ---------------------
 * |id   | start | end |
 * |-------------------| 
 * |1    | 10    | 100 |
 * |2    | 120   | 300 |
 * |-------------------|
 * </pre>
 * 
 * <p>possible annotations for this table:
 * <pre>
 *  species="human", chromosome="chr18", genome.revision="hg18", creater="leo", 
 *  created_at="2007/07/06" 
 * </pre>
 * 
 * <p>Some user may generate the following table, containing annotations: 
 * <pre>
 * Gene Table with annotation
 * --------------------------------------------
 * |id   | start | end | species | chromosome |
 * |-------------------------------------------
 * |1    | 10    | 100 | human   | chr18      |
 * |2    | 120   | 300 | human   | chr18      |
 * |-------------------------------------------
 * </pre>
 * 
 * <p>In both cases, we want to use the same syntax to query these tables. For example, to retrieve
 * gene data of human chromosome 18:
 * 
 * <pre>
 * select id, start, end from gene_table where species="human" and chromosome="chr18"
 * </pre>
 * 
 * <p>Corresponding AmoebaQuery representation:
 * <pre>
 * select gene.id, gene.start, gene.end from (species = "human", chromosome="chr18")
 * </pre>
 * 
 * 
 * Annotating table data can be deferred until you insert the gene object data:
 * 
 * <code>
 * <pre>
 *  XreialFS fs = (initialization of XerialfS)
 *  XerialStorageContext db = fs.open("/home/leo/genedata");
 *  db.append("gene(id=1, start=10, end=100)");	// insert a gene object 
 *  db.append("gene(id=2, start=120, end=300)");	
 *  
 *  // add annotations to all gene objects
 *  db.append("gene", "species=human, chromosome=chr18, created_at='2007/07/06'");
 *  
 *  // add additional annotations for a gene with id = 1
 *  db.append("gene(id=1)", "description='my gene', author='leo'");
 * </pre>
 * </code>
 * 
 * <p> Adding exon data to individual genes: 
 * <code>
 * <pre>
 *  db.append("gene:(id=1)", "exon:(start=10, end=15)");
 *  db.append("gene:(id=1)", "exon:(start=20, end=30, description='my exon')");
 *  db.append("gene:(id=2)", "exon:(start=125, end=130)");
 * </pre>
 * </code>
 * 
 * If you forget to add id for each gene, you can add such IDs later:
 * <code>
 * <pre>
 * int count = 1;
 * for(AmeobaQueryResultSetHandler handler = db.retrieve("gene"); handler.hasNext(); )
 * {
 *    handler.next().append("id=" + count++);
 * }
 * 
 * </pre>
 * </code>
 * 
 * 
 * @author leo
 *
 */
public interface XerialStorageContext {
	
	/**
	 * Retrieves database data 
	 * @param query the query
	 * @return ResultSetHandler for amoeba query
	 * @throws XerialFSException
	 */
	public AmoebaQueryResultSetHandler retrieve(AmoebaQuery query) throws DBException;

	/**
	 * Retreives database data within the specified context
	 * @param context the context
	 * @param query  the query
	 * @return ResultSetHandler for amoeba query
	 * @throws XerialFSException
	 */
	public AmoebaQueryResultSetHandler retrieve(AmoebaQuery context, AmoebaQuery query) throws DBException;
	
	/**
	 * Appends the data without specifying a particular context, i.e., the data will be inserted into the global context 
	 * @param tuple a data to insert
	 * @throws XerialFSException
	 */
	public void append(AmoebaTuple tuple) throws DBException;

	/**
	 * Appends the data into the given context
	 * @param context the update context
     * @param tuple a data to write
   	 * @throws XerialFSException
	 */
	public void append(AmoebaQuery contest, AmoebaTuple tuple) throws DBException;
	

	/**
	 * Overwrites the data in the global context of the database file
	 * @param tuple a data to write
	 * @throws XerialFSException
	 */
	public void write(AmoebaTuple tuple) throws DBException;
	
	/**
	 * Overwrites the data within the specified context 
     * @param conetxt the update context
     * @param tuple a data to write
	 * @throws XerialFSException 
	 */
	public void write(AmoebaQuery context, AmoebaTuple tuple) throws DBException;
	
	
	
}



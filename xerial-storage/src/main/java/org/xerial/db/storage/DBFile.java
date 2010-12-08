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
// DBFile.java
// Since: Aug 23, 2007 11:33:50 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import org.xerial.db.DBException;

/**
 * An interface to access disk files, or main memory buffers.
 * 
 * Accesses to the {@link DBFile} are not guaranteed to be thread-safe, that is, 
 * concurrent accesses to the {@link DBFile} may cause undesired effects; for example,  
 * contiguous write requests may overwrite the previous write results because 
 * the second write request can be performed before the file cursor is properly updated. 
 *
 * @author leo
 *
 */
public interface DBFile {

	/**
	 * Reads data from the file, and writes the read data to the specified buffer   
	 * @param buffer the buffer into which the data is read
	 * @param offset the start offset in the buffer at which the data is written
	 * @param byteSize the bytes to read
	 * @throws DBFileException when failed to read the data
	 */
	public void read(byte[] buffer, int offset, int byteSize) throws DBException;
	
	/**
	 * Writes the given data into the file
	 * @param buffer the data
	 * @param offset the start offset in the data
	 * @param byteSize the bytes to write
	 * @throws DBFileException when failed to write the data
	 */
	public void write(byte[] buffer, int offset, int byteSize) throws DBException; 
	
	/**
	 * Sets the file pointer offset, measured from the beginning of the file, at which the next read/write request 
	 * occurs. The fileBytePos can exceed the end of the file. Setting the fileBytePos higher than the end of the file does not 
	 * expand the file size. The size will change by writing after the offset has been set beyond the end of the file. 
	 * @param fileBytePos 
	 * @throws DBFileException
	 */
	public void seek(long fileBytePos) throws DBException;

	
	/**
	 * Closes the file.
	 * @throws DBFileException
	 */
	public void close() throws DBException;
}

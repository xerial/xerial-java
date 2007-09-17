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
// DiskFile.java
// Since: Aug 23, 2007 11:49:08 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The {@link DiskFile} wraps read/write accesses to files
 * 
 * @author leo
 *
 */
public class DiskFile implements DBFile {

	private RandomAccessFile file;
	
	public DiskFile(String filePath) throws FileNotFoundException
	{
		file = new RandomAccessFile(filePath, "rws");
	}
	
	public DiskFile(String filePath, String mode) throws FileNotFoundException
	{
		file = new RandomAccessFile(filePath, mode);
	}
	
	public void read(byte[] buffer, int offset, int byteSize) throws DBFileException {
		assert(buffer.length >= byteSize);
		
		try {
			file.readFully(buffer, offset, byteSize);
		} catch (IOException e) {
			throw new DBFileException(e);
		}
	}

	public void seek(long filePos) throws DBFileException {
		try {
			file.seek(filePos);
		} catch (IOException e) {
			throw new DBFileException(e);
		}
	}

	public void write(byte[] buffer, int offset, int byteSize) throws DBFileException {
		try {
			file.write(buffer, offset, byteSize);
		} catch (IOException e) {
			throw new DBFileException(e);
		}
	}

	public void close() throws DBFileException {
		try {
			file.close();
		} catch (IOException e) {
			throw new DBFileException(e);
		}
	}

}

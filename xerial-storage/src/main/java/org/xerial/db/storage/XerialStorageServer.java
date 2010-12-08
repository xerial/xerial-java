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
// StorageServer.java
// Since: Jul 5, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import java.io.File;
import java.util.List;

import org.xerial.db.DBException;
import org.xerial.db.DBErrorCode;
import org.xerial.db.RelationalQuery;
import org.xerial.json.JSONObject;

/**
 * 
 * @author leo
 * 
 */
public class XerialStorageServer {

	private String	storageFolderPath;
	private String	masterAddress;

	
	public XerialStorageServer(String storageFolderPath, String masterAddress) throws DBException
	{
		this.storageFolderPath = storageFolderPath;
		this.masterAddress = masterAddress;
		
		// start up the storage server
		prepareStorageFolder();
		scanFolder();
		connectToMaster();
	}
	

	private void prepareStorageFolder() throws DBException {
		File folder = new File(storageFolderPath);
		if (!folder.exists())
			folder.mkdir();

		if (!folder.isDirectory())
			throw new DBException(DBErrorCode.InvalidFile, storageFolderPath + " is not a directory");
	}
	
	/**
	 * Scans the storage folder contents
	 */
	private void scanFolder()
	{
		File folder = new File(storageFolderPath);
		File[] fileList = folder.listFiles();
		for(File file : fileList)
		{
			
		}

		
	}
	 	
	private void connectToMaster()
	{
		
	}
	
	
	public List<Long> getDatabaseIDList()
	{
	    // TODO
	    return null;
	}
	    
	public int getNumberOfDatabases()
	{
	    // TODO
	    return -1;
	}

	public JSONObject query(Long databaseID, RelationalQuery query)
	{
	    // TODO
	    return null;
	}
	

	
	
}

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
			throw new DBException(storageFolderPath + " is not a directory");
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

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
// DatabaseLocation.java
// Since: Jul 5, 2007 5:35:28 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import java.util.ArrayList;
import java.util.List;


public class DatabaseLocation {
	private String path;
	private long databaseID;
	private List<ServerAddress> storageServers = new ArrayList<ServerAddress>();

	public long getDatabaseID() {
		return databaseID;
	}
	public String getPath() {
		return path;
	}
	public List<ServerAddress> getStorageServers() {
		return storageServers;
	}
	
}

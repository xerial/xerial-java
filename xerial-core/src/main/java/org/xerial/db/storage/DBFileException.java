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
// DBFileException.java
// Since: Aug 23, 2007 11:54:12 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import org.xerial.db.DBException;

/**
 * This class is an exception for notifying DBFile I/O related problems 
 * @author leo
 *
 */
public class DBFileException extends DBException {

	public DBFileException() {
		super();
	}

	public DBFileException(String message, Throwable e) {
		super(message, e);
	}

	public DBFileException(String message) {
		super(message);
	}

	public DBFileException(Throwable e) {
		super(e);
	}
	
}

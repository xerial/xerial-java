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
// XerialFSException.java
// Since: Jul 5, 2007 5:55:33 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.storage;

import org.xerial.core.XerialException;

public class XerialFSException extends XerialException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XerialFSException() {
	}

	public XerialFSException(String message) {
		super(message);
	}

	public XerialFSException(Object... message) {
		super(message);
	}

	public XerialFSException(String message, Throwable cause) {
		super(message, cause);
	}

	public XerialFSException(Throwable cause) {
		super(cause);
	}

}

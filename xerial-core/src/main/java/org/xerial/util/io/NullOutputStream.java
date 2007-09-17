/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// NullOutputStream.java
// Since: 2005/07/19 0:19:11
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The usage of NullOutputStream is to switch on/off of 
 * message outputs without modifying or commenting out
 * println(...) methods.
 * 
 * For example, 
 * <pre>
 * 	
 * PrintStream log = new PrintStream(System.out);	// output messages to be displayed to std. out
 * // PrintStream log = new PrintStream(new NullOutputStream());  // no output will be generated
 * 
 * log.println("some messages");
 * 
 * </pre>
 * @author leo
 *
 */
public class NullOutputStream extends OutputStream
{

	@Override
	public void write(int c) throws IOException {
		// do nothing
	}

	@Override
	public void close() throws IOException 
	{
		// do nothing
	}

	@Override
	public void flush() throws IOException 
	{
		// do nothing
	}

	@Override
	public void write(byte[] arg0, int arg1, int arg2) throws IOException 
	{
		// do nothing
	}

	@Override
	public void write(byte[] arg0) throws IOException 
	{
		// do nothing
	}

}

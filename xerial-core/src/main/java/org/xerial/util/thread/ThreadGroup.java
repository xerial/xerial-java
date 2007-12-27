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
// Phenome Commons Project
//
// ThreadGroup.java
// Since: 2005/01/04
//
// $URL: http://phenome.gi.k.u-tokyo.ac.jp/devel/svn/phenome/trunk/Commons/src/lab/cb/common/thread/ThreadGroup.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.thread;

import java.util.LinkedList;

/**
 * Groups multiple threads as a unit
 * 
 * @author leo
 * 
 */
public class ThreadGroup<E extends Thread> {

	/**
	 * 
	 */
	public ThreadGroup() {
	}

	synchronized public void addThread(E thread) {
		_threadList.add(thread);
	}

	synchronized public void removeThread(E thread) {
		_threadList.remove(thread);
	}

	synchronized public int size() {
		return _threadList.size();
	}

	synchronized public void joinAll() throws InterruptedException {
		for (E thread : _threadList)
			thread.join();
	}

	synchronized public void interruptAll() {
		for (E thread : _threadList) {
			thread.interrupt();
		}
	}

	private LinkedList<E> _threadList = new LinkedList<E>();
}

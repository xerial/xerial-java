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
 * •¡”‚ÌThread‚ğˆêŠ‡‚µ‚ÄŠÇ—‚·‚éƒNƒ‰ƒX
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

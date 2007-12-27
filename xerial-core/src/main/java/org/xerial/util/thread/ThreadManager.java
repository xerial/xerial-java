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
// ThreadManager.java
// Since: 2005/01/04
//
// $URL: http://phenome.gi.k.u-tokyo.ac.jp/devel/svn/phenome/trunk/Commons/src/lab/cb/common/thread/ThreadManager.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.util.thread;

import java.util.LinkedList;

/**
 * ThreadManager supports handy multi-thread programming.
 * 
 * Usage example:
 * <code>
 * <pre>
 *  ThreadManager threadManager = new TreadManager();
 *  threadManager.addTask(new Runnable() {
 *      public void run()
 *      {
 *          // do something in thread
 *      }
 *  });
 *  
 *  // wait until all tasks are terminated 
 *  threadManager.joinAll();
 * 
 * </pre>
 * </code>
 * 
 * 
 * ThreadManager recieves any tasks that implement {@link Runnable} interface.
 * Generated threads will be reused after the tasks are terminated, so
 * multi-thread tasks run more efficiently than crating a new thread for each task. 
 *  
 * @author leo
 * 
 */
public class ThreadManager {

	/**
	 * The number of generated thread is 5 in default, and the task queue size is 100.
	 */
	public ThreadManager() {
		prepareWorkerThreads();
	}

	/**
	 * @param numMaximumThread the number of threads preliminary generated
	 * @param taskQueueSize  the task queue size. If you allocate larger size for the task queue, 
	 * chances of waiting another thread will be reduced when calling {@link #addTask(Runnable)} method. 
	 */
	public ThreadManager(int numMaximumThread, int taskQueueSize) {
		_numMaximumThread = numMaximumThread;
		_taskQueueMaxSize = taskQueueSize;
		prepareWorkerThreads();
	}

	synchronized private void prepareWorkerThreads() {
		for (int i = 0; i < _numMaximumThread; i++) {
			WorkerThread workerThread = new WorkerThread(this);
			_threadGroup.addThread(workerThread);
			workerThread.start();
		}
	}

	/**
	 * Add a task to the task queue。The added task will be assigned to the idle thread, then within the thread, 
	 * {@link Runnable#run()} method will be invoked.
	 * 
	 * If the task queue is full at the time of method invocation, the caller will be blocked until  
	 * the task queue has enough space for the task.
	 * 
	 * @param task a class instance that implements {@link Runnable} 
	 * @throws InterruptedException invoked when the ThreadManager gets interrupted outside of the ThreadManager
	 *             
	 */
	public void addTask(Runnable task) throws InterruptedException {
		if (task == null)
			throw new NullPointerException("task is null");

		synchronized (this) {
			while (_taskQueue.size() >= _taskQueueMaxSize) {
				wait();
			}
			_taskQueue.add(task);
			notify();
		}
	}

	/**
	 * Waits until the next work will be available
	 * 
	 * @return task {@link Runnable} class. When the task is null, it means there is no more task to process
	 * @throws InterruptedException thrown when the caller thread of this method is interrupted.
	 */
	synchronized Runnable nextWork() throws InterruptedException {
		while (_taskQueue.isEmpty() && !_isInTerminatePhase) {
			wait();
		}
		Runnable task = _taskQueue.poll();
		notifyAll();
		if (_isInTerminatePhase && _taskQueue.isEmpty()) {
			return null;
		}
		return task;
	}

	/**
	 * Waits until all tasks assigned to this ThreadManager.
	 * 
	 * @throws InterruptedException when the thread running the thread manager is interrupted
	 */
	public void joinAll() throws InterruptedException {
		synchronized (this) {
			while (!_taskQueue.isEmpty()) // queueにある全てのタスクの終了まで待つ
			{
				wait();
			}
			_isInTerminatePhase = true;
			notifyAll();
		}
		_threadGroup.joinAll();
	}

	/**
	 * Terminates all tasks assigned to the thread manager
	 */
	synchronized public void terminateAll() {
		_isInTerminatePhase = true;
		_threadGroup.interruptAll();
	}

	private LinkedList<Runnable> _taskQueue = new LinkedList<Runnable>();

	private ThreadGroup<WorkerThread> _threadGroup = new ThreadGroup<WorkerThread>();

	private int _numMaximumThread = 5;

	private int _taskQueueMaxSize = 100;

	private boolean _isInTerminatePhase = false;

}

/**
 * Worker thread receives a task, then perform the task
 * 
 * @author leo
 * 
 */
class WorkerThread extends Thread {
	WorkerThread(ThreadManager threadManager) {
		_threadManager = threadManager;
	}

	public void run() {
		try {
			while (true) {
				Runnable task = _threadManager.nextWork();
				if (task == null)
					return; // no more work
				task.run();
			}
		} catch (InterruptedException e) {
			// force terminated out side of this thread 
		}
	}

	private ThreadManager _threadManager;
}

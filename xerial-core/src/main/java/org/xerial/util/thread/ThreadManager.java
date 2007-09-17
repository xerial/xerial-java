//--------------------------------------
// Phenome Commons Project
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
 * interface java.lang.Runnable を実装したクラスを追加するだけで、multi threadで実行してくれるサーバー。
 * 作成したthreadは再利用されるので、逐次Threadを生成するより効率が良い
 * 
 * @author leo
 * 
 */
public class ThreadManager {

	/**
	 * デフォルトのスレッド数の上限は5 Task Queueのサイズは100
	 */
	public ThreadManager() {
		prepareWorkerThreads();
	}

	/**
	 * @param numMaximumThread
	 *            生成できるスレッド数の上限
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
	 * taskをキューに追加する。追加されたtaskは、空いているスレッドに割り当てられ、そこでrunメソッドが実行される。
	 * キューがいっぱいなら、キューが空くまで呼び出し側がwaitする。
	 * 
	 * @param task
	 *            java.lang.Runnable interfaceを実装したクラス
	 * @throws InterruptedException
	 *             threadManagerが外部から処理をinterruptされたときに発生する例外
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
	 * 次の仕事（java.lang.Runnable)が得られるまで待つ
	 * 
	 * @return task queueにあるjava.lang.Runnalbleのインスタンス.
	 *         Nullを返すときは、もうこれ以上仕事がないということ
	 * @throws InterruptedException
	 *             このメソッドを呼び出したthreadが外部からinterruptされた時に発生する
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
	 * ThreadManagerに与えられたtaskがすべて終了するのを待つ
	 * 
	 * @throws InterruptedException
	 *             ThreadServerを実行しているthreadが外部からinterruptされた場合
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
	 * taskの実行をすべて強制終了する
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
 * 仕事を受け取って、実行するThread
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
			// 強制終了された場合
		}
	}

	private ThreadManager _threadManager;
}

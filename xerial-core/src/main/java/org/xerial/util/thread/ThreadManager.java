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
 * interface java.lang.Runnable �����������N���X��ǉ����邾���ŁAmulti thread�Ŏ��s���Ă����T�[�o�[�B
 * �쐬����thread�͍ė��p�����̂ŁA����Thread�𐶐�������������ǂ�
 * 
 * @author leo
 * 
 */
public class ThreadManager {

	/**
	 * �f�t�H���g�̃X���b�h���̏����5 Task Queue�̃T�C�Y��100
	 */
	public ThreadManager() {
		prepareWorkerThreads();
	}

	/**
	 * @param numMaximumThread
	 *            �����ł���X���b�h���̏��
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
	 * task���L���[�ɒǉ�����B�ǉ����ꂽtask�́A�󂢂Ă���X���b�h�Ɋ��蓖�Ă��A������run���\�b�h�����s�����B
	 * �L���[�������ς��Ȃ�A�L���[���󂭂܂ŌĂяo������wait����B
	 * 
	 * @param task
	 *            java.lang.Runnable interface�����������N���X
	 * @throws InterruptedException
	 *             threadManager���O�����珈����interrupt���ꂽ�Ƃ��ɔ��������O
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
	 * ���̎d���ijava.lang.Runnable)��������܂ő҂�
	 * 
	 * @return task queue�ɂ���java.lang.Runnalble�̃C���X�^���X.
	 *         Null��Ԃ��Ƃ��́A��������ȏ�d�����Ȃ��Ƃ�������
	 * @throws InterruptedException
	 *             ���̃��\�b�h���Ăяo����thread���O������interrupt���ꂽ���ɔ�������
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
	 * ThreadManager�ɗ^����ꂽtask�����ׂďI������̂�҂�
	 * 
	 * @throws InterruptedException
	 *             ThreadServer�����s���Ă���thread���O������interrupt���ꂽ�ꍇ
	 */
	public void joinAll() throws InterruptedException {
		synchronized (this) {
			while (!_taskQueue.isEmpty()) // queue�ɂ���S�Ẵ^�X�N�̏I���܂ő҂�
			{
				wait();
			}
			_isInTerminatePhase = true;
			notifyAll();
		}
		_threadGroup.joinAll();
	}

	/**
	 * task�̎��s�����ׂċ����I������
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
 * �d�����󂯎���āA���s����Thread
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
			// �����I�����ꂽ�ꍇ
		}
	}

	private ThreadManager _threadManager;
}

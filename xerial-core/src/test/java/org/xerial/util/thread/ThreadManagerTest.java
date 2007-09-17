//--------------------------------------
// Phenome Commons Project
//
// ThreadManagerTest.java
// Since: 2005/01/04
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.thread;

import junit.framework.TestCase;

/**
 * @author leo
 *
 */
public class ThreadManagerTest extends TestCase
{
    ThreadManager _manager;
    Counter _counter;
    
    protected void setUp() throws Exception
    {
        _manager = new ThreadManager();
        _counter = new Counter();
    }
    
    class Counter
    {
        synchronized void increment()
        {
            count++;
        }
        int count = 0;
    }
    
    class SimpleTask implements Runnable
    { 
        SimpleTask(Counter c)
        {
            _c = c;
        }
        public void run()
        { 
            for(int i=0; i<1000; i++) {}
            _c.increment();
        } 
        Counter _c;
    }
    
    public void testWork() throws InterruptedException
    {
        _manager.addTask(new SimpleTask(_counter));
        _manager.joinAll();
        assertEquals(1, _counter.count);
    }
    
    public void testManyTasks() throws InterruptedException
    {
        for(int i=0; i<500; i++)
        {
            _manager.addTask(new SimpleTask(_counter));
        }
        _manager.joinAll();
        assertEquals(500, _counter.count);
    }
}





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





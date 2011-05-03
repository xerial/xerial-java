/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// ObjectStreamReader.java
// Since: 2010/12/08 17:58:03
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.xerial.util.ObjectHandlerBase;

public class ObjectStreamReader<T>
{
    private final ArrayBlockingQueue<T> prefetchedObjects = new ArrayBlockingQueue<T>(10000);

    private final Reader                input;
    private final Class<T>              targetClass;
    private final String                nodeName;

    private final ExecutorService       threadManger      = Executors.newFixedThreadPool(1);

    public ObjectStreamReader(Reader input, String nodeName, Class<T> targetClass) {
        if (input == null)
            throw new NullPointerException("null input");

        this.input = input;
        this.targetClass = targetClass;
        this.nodeName = nodeName;
    }

    public void close() throws IOException {
        input.close();

        threadManger.shutdown();
    }

    private class BackgroundObjectStreamHandler extends ObjectHandlerBase<T> implements Callable<Void>
    {

        @Override
        public Void call() throws Exception {
            SilkLens.findFromSilk(input, nodeName, targetClass, this);
            return null;
        }

        @Override
        public void handle(T input) throws Exception {
            prefetchedObjects.add(input);
        }

    }

    private class ObjectStreamIterator implements Iterator<T>
    {

        @Override
        public boolean hasNext() {

            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return prefetchedObjects.poll();
            }

            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }

}

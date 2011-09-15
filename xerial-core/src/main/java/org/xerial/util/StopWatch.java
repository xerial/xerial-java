/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// StopWatch.java
// Since: Jan 23, 2008 8:44:10 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

/**
 * 
 * StopWatch measures interval times.
 * 
 * @author leo
 * 
 */
public class StopWatch {
    enum State {
        RUNNING, STOPPED
    }

    private long lastSystemTime;
    private long accumulatedElapsedTime;
    private State state = State.RUNNING;

    private static final double NANO_UNIT = 1000000000L;

    public StopWatch() {
        reset();
    }

    /**
     * Gets the elapsed time since this instance is created in seconds.
     * 
     * @return the elapsed time in seconds.
     */
    public double getElapsedTime() {
        if (state == State.RUNNING) {
            long now = System.nanoTime();
            long diff = now - lastSystemTime;
            return (accumulatedElapsedTime + diff) / NANO_UNIT;
        }
        else {
            return accumulatedElapsedTime / NANO_UNIT;
        }
    }

    /**
     * Reset the stop watch. The subsequent calls to
     * {@link StopWatch#getEleapsedTime()} or
     * {@link StopWatch#getIntervalTime()} will measure the time intervals
     * beginning from this method call.
     */
    public void reset() {
        lastSystemTime = System.nanoTime();
        accumulatedElapsedTime = 0L;
    }

    public void stop() {
        if (state == State.STOPPED)
            return;

        // elapsed time 
        long now = System.nanoTime();
        accumulatedElapsedTime += now - lastSystemTime;
        lastSystemTime = now;

        state = State.STOPPED;
    }

    public void resume() {
        if (state == State.RUNNING)
            return;

        lastSystemTime = System.nanoTime();
        state = State.RUNNING;
    }

    public String reportElapsedTime() {
        return String.format("%.2f sec.", getElapsedTime());
    }

}

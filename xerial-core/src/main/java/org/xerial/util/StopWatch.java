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
public class StopWatch
{

    private long initialSystemTIme;
    private long lastSystemTime;
    
    private static final double NANO_UNIT = 1000000000L;

    public StopWatch()
    {
        reset();
    }

    /**
     * Gets the elapsed time since this instance is created in seconds.
     * 
     * @return the elapsed time in seconds.
     */
    public double getElapsedTime()
    {
        lastSystemTime = System.nanoTime();
        long diff = lastSystemTime - initialSystemTIme;
        return diff / NANO_UNIT;
    }

    /**
     * Gets the interval time since the last call of
     * {@link StopWatch#getEleapsedTime()} or
     * {@link StopWatch#getIntervalTime()}
     * 
     * @return the interval time in seconds
     */
    public double getIntervalTime()
    {
        long now = System.nanoTime();
        long diff = now - lastSystemTime;
        lastSystemTime = now;
        return diff / NANO_UNIT;
    }

    /**
     * Reset the stop watch. The subsequent calls to
     * {@link StopWatch#getEleapsedTime()} or
     * {@link StopWatch#getIntervalTime()} will measure the time intervals
     * beginning from this method call.
     */
    public void reset()
    {
        initialSystemTIme = System.nanoTime();
        lastSystemTime = initialSystemTIme;
    }

}

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
// ObjectStreamHandler.java
// Since: 2010/12/08 10:20:53
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

/**
 * Interface for object lens
 * 
 * @author leo
 * 
 */
public interface ObjectStreamHandler
{
    /**
     * Add a no-name object to the root context
     * 
     * @param <T>
     * @param obj
     * @throws Exception
     */
    public <T> void add(T obj) throws Exception;

    /**
     * Add an object with a given name to the root context
     * 
     * @param <T>
     * @param name
     * @param obj
     * @throws Exception
     */
    public <T> void add(String name, T obj) throws Exception;

    /**
     * Associate a named object value to the specified parent
     * 
     * @param <T>
     * @param <U>
     * @param parent
     * @param name
     * @param obj
     * @throws Exception
     */
    public <T, U> void connect(T parent, String name, U obj) throws Exception;

    /**
     * Append a named object to the specified parent
     * 
     * @param <T>
     * @param <U>
     * @param parent
     * @param name
     * @param obj
     * @throws Exception
     */
    public <T, U> void append(T parent, String name, U obj) throws Exception;

}

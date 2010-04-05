/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// XerialCommand.java
// Since: Apr 23, 2009 6:00:29 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core.cui;

/**
 * Common interface for Silk CUI commands
 * 
 * @author leo
 * 
 */
public interface XerialCommand {
    public static final int RETURN_WITH_SUCCESS = 0;
    public static final int RETURN_WITH_FAILURE = 1;

    /**
     * Execute the command. Command line arguments are processed before the
     * invocation of this method.
     * 
     * @throws Exception
     */
    public void execute() throws Exception;

    /**
     * command name
     * 
     * @return command name
     */
    public String getName();

    /**
     * one-line description of the command
     * 
     * @return one-line description of the command
     */
    public String getOneLineDescription();

}

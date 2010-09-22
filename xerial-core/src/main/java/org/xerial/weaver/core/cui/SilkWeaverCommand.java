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
// Xerial Silk Weaver Project 
//
// SilkWeaverCommand.java
// Since: 2009/07/22 11:14:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

/**
 * Common interface of the SilkWeaver commands. To add a new SilkWeaver command,
 * implements this interface, then put your code to
 * <i>org.xerial.weaver.core.cui</i> package.
 * 
 * @author leo
 * 
 */
public interface SilkWeaverCommand {
    /**
     * Command name
     * 
     * @return
     */
    public String getCommandName();

    /**
     * One-line description of the command, which is used for help messages
     * 
     * @return
     */
    public String getOneLineDescription();

    /**
     * Execute the command, and return the execution status
     * 
     * @param module
     *            the module to which this command belongs. This might be null
     *            when no parent exists.
     * @param unusedArgs
     *            command arguments
     * @return Return status code. See also {@link ReturnCode}.
     * @throws Exception
     */
    public int execute(SilkWeaverModule module, String[] args) throws Exception;

}

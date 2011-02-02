/*--------------------------------------------------------------------------
 *  Copyright 2011 Taro L. Saito
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
// Command.java
// Since: 2011/02/01 17:13:36
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

/**
 * An interface for defining a command in a module
 * 
 * @author leo
 * 
 */
public interface Command {

    /**
     * Command name. This name must be a single word without spaces.
     * 
     * @return
     */
    public String name();

    /**
     * One-line description of the command
     * 
     * @return
     */
    public String getOneLineDescription();

    /**
     * Return the option holder, in which command-line options are defined. If
     * you define command-line options as fields in this Command class using
     * {@link Option} and {@link Argument} annotations, return <i>this</i>
     * pointer. When no need exists to parse command-line arguments, simply
     * return null;
     * 
     * @return
     */
    public Object getOptionHolder();

    /**
     * Execute the command.
     * 
     * @param args
     *            command-line arguments. No need exists to parse this arguments
     *            by yourself, since options for this command is already bound
     *            to the fields in the option holder, if you annotate the fields
     *            with {@link Option} or {@link Argument}.
     * @throws Exception
     */
    public void execute(String[] args) throws Exception;

}

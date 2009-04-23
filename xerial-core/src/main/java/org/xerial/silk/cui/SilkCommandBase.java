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
// SilkCommandBase.java
// Since: Apr 23, 2009 6:22:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import org.xerial.util.log.LogLevel;
import org.xerial.util.opt.Option;

/**
 * Base implementation of {@link SilkCommand}
 * 
 * @author leo
 * 
 */
public abstract class SilkCommandBase implements SilkCommand
{
    @Option(symbol = "h", longName = "help", description = "display help messages")
    protected boolean displayHelp = false;

    @Option(longName = "loglevel", description = "set loglevel to one of TRACE, DEBUG, INFO, WARN, ERROR, FATAL or ALL")
    protected LogLevel logLevel = LogLevel.INFO;

    public boolean displayHelp()
    {
        return displayHelp;
    }

    public LogLevel getLogLevel()
    {
        return logLevel;
    }

}

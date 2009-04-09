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
// SilkMain.java
// Since: Apr 9, 2009 5:00:14 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;

/**
 * Command-line interface for managing Silk data format.
 * 
 * @author leo
 * 
 */
public class SilkMain
{
    public SilkMain(SilkOption option)
    {

    }

    public void run()
    {

    }

    public static void main(String[] args)
    {
        SilkOption option = new SilkOption();
        OptionParser parser = new OptionParser(option);
        try
        {
            parser.parse(args);
            new SilkMain(option).run();
        }
        catch (OptionParserException e)
        {
            System.err.println(e);
        }
    }

    public static class SilkOption
    {
        @Option(symbol = "h", longName = "help", description = "display help message")
        boolean displayHelp = false;

        @Argument(index = 0, name = "sub command", required = false)
        String subCommand = "help";
    }

}

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
// Convert.java
// Since: 2010/03/24 13:17:06
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import org.xerial.util.FileType;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;

public class Convert implements SilkCommand {

    @Argument(index = 0)
    private String input = "-";

    @Option(symbol = "i", varName = "TYPE", description = "input file type")
    private FileType inputType = FileType.UNKNOWN;

    @Argument(index = 1)
    private String output = "-";

    @Option(symbol = "o", varName = "TYPE", description = "output file type")
    private FileType outputType = FileType.UNKNOWN;

    public void execute() throws Exception {

        // validating the input file
        if (input.equals("-")) {
            if (inputType == FileType.UNKNOWN)
                throw new Exception("input file type must be specified when using STDIN");
        }
        else {
            // auto-detect the input file type
            inputType = FileType.getFileType(input);
            if (inputType == FileType.UNKNOWN)
                throw new Exception("unknown file type: " + input);
        }

        // validating the output file
        if (output.equals("-")) {
            if (outputType == FileType.UNKNOWN)
                throw new Exception("output file type must be specified when using STDOUT");
        }
        else {
            // auto-detect the input file type
            outputType = FileType.getFileType(output);
            if (outputType == FileType.UNKNOWN)
                throw new Exception("unknown file type: " + output);
        }

    }

    public String getName() {
        return "convert";
    }

    public String getOneLineDescription() {
        return "convert the data format";
    }

}

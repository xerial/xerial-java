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
// Filter.java
// Since: 2009/08/06 8:09:25
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.cui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.xerial.lens.RelationLens;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Usage;

@Usage(command = "filter")
public class Filter implements SilkCommand {

    private static Logger _logger = Logger.getLogger(Filter.class);

    @Argument(index = 0)
    public String inputResource = "-";

    @Argument(index = 1)
    public String query = null;

    public void execute() throws Exception {

        if (query == null) {
            _logger.error("no query is given");
            return;
        }

        // input 
        Reader in = null;
        if (inputResource.equals("-")) {
            in = new InputStreamReader(System.in);
            _logger.info("read data from STDIN");
        }
        else {
            if (startsWithProtocol(inputResource)) {
                URL inputURL = new URL(inputResource);
                _logger.info("read from resource: " + inputResource);
                in = new BufferedReader(new InputStreamReader(inputURL.openStream()));
            }
            else {
                _logger.info("read from file: " + inputResource);
                in = new BufferedReader(new FileReader(inputResource));
            }
        }

        RelationLens lens = new RelationLens(query);

    }

    public static boolean startsWithProtocol(String resourceName) {
        if (resourceName == null)
            return false;

        return resourceName.matches("^[A-za-z0-9+]+://.*");
    }

    public String getName() {
        return "filter";
    }

    public String getOneLineDescription() {
        return "extract relation from the data";
    }

}

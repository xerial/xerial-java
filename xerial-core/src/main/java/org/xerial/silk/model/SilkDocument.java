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
// SilkDocument.java
// Since: 2009/12/07 19:21:31
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xerial.silk.SilkEvent;
import org.xerial.silk.SilkEventHandler;
import org.xerial.silk.SilkLinePushParser;
import org.xerial.silk.impl.SilkElement;
import org.xerial.util.log.Logger;

/**
 * Document object-model for Silk format
 * 
 * @author leo
 * 
 */
public class SilkDocument {

    private static Logger _logger = Logger.getLogger(SilkDocument.class);

    public List<SilkElement> line = new ArrayList<SilkElement>();

    public static SilkDocument parse(URL silkResource) throws IOException {
        SilkLinePushParser parser = new SilkLinePushParser(silkResource);
        SilkDocumentGenerator g = new SilkDocumentGenerator();
        try {
            parser.parse(g);
        }
        catch (Exception e) {
            _logger.error(e);
        }
        return g.doc;
    }

    private static class SilkDocumentGenerator implements SilkEventHandler {
        SilkDocument doc = new SilkDocument();

        public void handle(SilkEvent event) throws Exception {
            doc.line.add(event.getElement());
        }
    }

}

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
import org.xerial.silk.SilkEventType;
import org.xerial.silk.SilkLinePushParser;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;

/**
 * Document object-model for Silk format
 * 
 * @author leo
 * 
 */
public class SilkDocument {

    private static Logger _logger = Logger.getLogger(SilkDocument.class);

    public List<SilkEvent> line = new ArrayList<SilkEvent>();

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
            doc.line.add(event);
        }
    }

    public String toSilk() {
        StringBuilder buf = new StringBuilder();
        int lineCount = 0;
        for (SilkEvent e : line) {
            if (e.getType() == SilkEventType.END_OF_FILE)
                break;

            if (lineCount++ > 0)
                buf.append(StringUtil.NEW_LINE);
            switch (e.getType()) {
            case BLANK_LINE:
                break;
            case COMMENT_LINE: {
                SilkCommentLine cl = SilkCommentLine.class.cast(e.getElement());
                buf.append(cl.line);
                break;
            }
            case DATA_LINE: {
                SilkDataLine dl = SilkDataLine.class.cast(e.getElement());
                buf.append(dl.getDataLine());
                break;
            }
            case FUNCTION: {
                SilkFunction sf = SilkFunction.class.cast(e.getElement());
                break;
            }
            case MULTILINE_ENTRY_SEPARATOR:
                buf.append("==");
                break;
            case MULTILINE_SEPARATOR:
                buf.append("--");
                break;
            case NODE: {
                SilkNode sn = SilkNode.class.cast(e.getElement());
                buf.append(sn.toSilk());
                break;
            }
            case PREAMBLE: {
                SilkPreamble sp = SilkPreamble.class.cast(e.getElement());
                buf.append(sp.preamble);
                break;
            }
            }

        }

        return buf.toString();
    }

}

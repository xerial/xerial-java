/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// Template.java
// Since: Jul 25, 2007 4:11:06 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Searches for a pattern
 * 
 * <pre>
 * $propertyKey$
 * </pre>
 * 
 * in a given template, then replaces it with the corresponding property value.
 * 
 * @author leo
 * 
 */
public class Template {
    private final String template;

    public Template(String templateString) {
        template = templateString;
    }

    public Template(InputStream templateStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(templateStream));
        StringWriter buf = new StringWriter();
        PrintWriter writer = new PrintWriter(buf);

        String line;
        while ((line = reader.readLine()) != null) {
            writer.println(line);
        }

        template = buf.toString();
    }

    public String apply(Properties property) {

        final Pattern variable = Pattern.compile("(^\\$|[^\\\\]\\$)[^\\$]+\\$");
        BufferedReader reader = new BufferedReader(new StringReader(template));
        StringWriter out = new StringWriter();
        int cursor = 0;
        try {
            int lineCount = 0;
            for (String line; (line = reader.readLine()) != null; ++lineCount, cursor = 0) {
                if (lineCount > 0)
                    out.append("\n");

                Matcher matcher = variable.matcher(line);
                while (matcher.find()) {
                    int prefixSize = matcher.group(1).length() - 1;
                    final int varStart = matcher.start() + prefixSize;
                    final int varEnd = matcher.end();
                    final String key = line.substring(varStart + 1, varEnd - 1);
                    if (cursor < varStart) {
                        out.append(line.substring(cursor, varStart));
                        cursor = varEnd;
                    }
                    if (property.containsKey(key)) {
                        Object value = property.get(key);
                        if (value != null)
                            out.append(value.toString());
                    }
                }

                if (cursor < line.length()) {
                    out.append(line.substring(cursor, line.length()));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String r = out.toString();
        return r.replaceAll(Matcher.quoteReplacement("\\$"), Matcher.quoteReplacement("$"));
    }
}

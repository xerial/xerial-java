/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// AquaParser.java
// Since: Apr 21, 2008 11:24:07 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.maven.doxia.aqua;

import java.io.IOException;
import java.io.Reader;

import org.apache.maven.doxia.parser.AbstractParser;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;
import org.xerial.wiki.Wiki;
import org.xerial.wiki.WikiException;
import org.xerial.wiki.WikiWalker;

/**
 * Doxia Aqua Parser
 * 
 * @author leo
 * 
 * @plexus.component role="org.apache.maven.doxia.parser.Parser"
 *                   role-hint="aqua"
 */
public class AquaParser extends AbstractParser
{

    public void parse(Reader reader, Sink sink) throws ParseException
    {
        try
        {

            Wiki wiki = Wiki.load(reader);
            AquaWikiWriter wikiWriter = new AquaWikiWriter(sink);
            WikiWalker wikiWalker = new WikiWalker(wikiWriter);
            wikiWalker.walk(wiki);
        }
        catch (WikiException e)
        {
            throw new ParseException(e);
        }
        catch (IOException e)
        {
            throw new ParseException(e);
        }
    }

}

/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XerialJ Project
//
// XMLNodeRelationAnalyzer.java
// Since: 2005/05/31
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.analyzer;

import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.xerial.core.XerialException;
import org.xerial.util.XMLParserException;
import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.xml.SinglePath;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import static org.xmlpull.v1.XmlPullParser.*;

/**
 * XMLÇÃÉmÅ[Éhä‘ÇÃêeéqÅAëcêÊ-éqë∑ä÷åWÇâêÕÇ∑ÇÈ
 * @author leo
 *
 */
public class XMLNodeRelationAnalyzer
{
    private enum Opt { help }
    private OptionParser<Opt> _opt = new OptionParser<Opt>();
    
    /**
     * @throws OptionParserException 
     * 
     */
    public XMLNodeRelationAnalyzer() throws OptionParserException
    {
        _opt.addOption(Opt.help, "h", "help", "display help message");
    }
    
    public static void main(String[] args) 
    {
        try
        {
            XMLNodeRelationAnalyzer instance = new XMLNodeRelationAnalyzer();
            instance.perform(args);
        }
        catch(XerialException e)
        {
            System.err.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage()); 
        }
    }
    
    public void perform(String[] args) throws OptionParserException, IOException, XerialException
    {
        _opt.parse(args);
        
        if(_opt.isSet(Opt.help) || _opt.getArgumentLength() < 1) 
        {
            printHelpMessage();
            return;
        }
        String xmlFile = _opt.getArgument(0);
        
        Reader xmlFileReader = new FileReader(xmlFile);
        XmlPullParser parser = PullParserUtil.newParser(xmlFileReader);
    
        ParseProcess parseProcess = new ParseProcess(parser);
        parseProcess.parse();
        
        for(String tag : parseProcess.tag2relatedTagNames.keySet())
        {
            System.out.print(tag + ":\t");
            for(String related : parseProcess.tag2relatedTagNames.get(tag))
            {
                System.out.print(related + " ");
            }
            System.out.println();
        }
        
        xmlFileReader.close();
    }
    
    class NodeRelation
    {
        
        
    }
    
    class ParseProcess 
    {
        XmlPullParser parser;
        SinglePath currentPath = new SinglePath(SinglePath.PathType.AbsolutePath);
        TreeMap<String, TreeSet<String>> tag2relatedTagNames = new TreeMap<String, TreeSet<String>>();
        int pathCount = 0;
        
        ParseProcess(XmlPullParser parser)
        {
            this.parser = parser; 
        }
        
        void parse() throws IOException, XMLException
        {

            int state;
            
            try
            {
                while((state = parser.next()) != END_DOCUMENT)
                {
                    switch(state)
                    {
                    case START_TAG:
                        String currentTag = parser.getName();
                        currentPath.addChild(currentTag);
                        
                        TreeSet<String> relatedTagSet = getRelatedTagSet(currentTag);
                        for(String t : currentPath)
                        {
                            if(!t.equals(currentTag))
                            {
                                relatedTagSet.add(t);
                                TreeSet<String> relatedTagSet2 = getRelatedTagSet(t);
                                relatedTagSet2.add(currentTag);
                            }
                        }
                        // TODO attributeÇÃèàóù
                        for(int i=0; i<parser.getAttributeCount(); i++)
                        {
                            
                        }
                        break;
                    case END_TAG:
                        currentPath.removeLastChild();
                        break;
                    case START_DOCUMENT:
                        break;
                    case TEXT:
                        break;
                    }
                }
            }
            catch (XmlPullParserException e)
            {
                throw new XMLException(e);
            }

        }
        
        private TreeSet<String> getRelatedTagSet(String tag)
        {
            TreeSet<String> s = tag2relatedTagNames.get(tag);
            if(s == null)
            {
                s = new TreeSet<String>();
                tag2relatedTagNames.put(tag, s);
            }
            return s;
        }

    }
    
    
    private void printHelpMessage()
    {
        System.out.println("usage: > java XMLNodeRelationAnalyzer.jar [option] xml_file");
    }

}





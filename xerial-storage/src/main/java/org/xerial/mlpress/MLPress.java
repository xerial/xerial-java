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
// XerialJ
//
// MLPress.java
// Since: 2005/07/18
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.util.io.NullOutputStream;
import org.xerial.util.opt.Argument;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.xml.index.DataGuide;
import org.xmlpull.v1.XmlPullParser;

public class MLPress
{

  enum Opt {
    HELP, VERBOSE
  }

  private OptionParser _opt        = new OptionParser(this);
  private OutputStream _log        = new PrintStream(new NullOutputStream());

  @Option(symbol = "h", longName = "help", description = "display help messages")
  private boolean      displayHelp = false;

  @Option(symbol = "v", longName = "verbose", description = "display verbose messages")
  private boolean      verbose     = false;

  @Argument
  private String       xmlFileName = null;

  /**
   * @param args
   *          command-line arguments
   */
  public static void main(String[] args) {
    try {
      MLPress instance = new MLPress();
      instance.run(args);
    }
    catch (XerialException e) {
      printExceptionMessage(e);
    }
    catch (IOException e) {
      printExceptionMessage(e);
    }
  }

  static private void printExceptionMessage(Exception e) {
    System.err.println(e.getMessage());
  }

  public void printHelpMessage() {
    System.out.println("> java -jar MLPress.jar [options] xmlfile");
    _opt.printUsage();
  }

  public void run(String[] args) throws XerialException, IOException {
    _opt.parse(args);

    if (displayHelp) {
      printHelpMessage();
      return;
    }
    if (verbose)
      _log = new PrintStream(System.out);

    if (xmlFileName == null)
      throw new XerialException(XerialErrorCode.MISSING_ARGUMENT, "no imput xml file is specified");

    BufferedReader xmlReader = new BufferedReader(new FileReader(xmlFileName));
    //XmlPullParser parser =PullParserUtil.newParser(xmlReader);

    //xparse(parser);
  }

  private TagDictionary       _tagDict          = new TagDictionary();
  private TagStructureEncoder _structureEncoder = new TagStructureEncoder(_tagDict);
  private DataGuide           _dataGuide        = new DataGuide();

  private void parse(XmlPullParser parser) {
    int state;
    /*
    try
    {

        while((state = parser.next()) != END_DOCUMENT)
        {
            switch(state)
            {
            case START_TAG:
                _dataGuide.startTag(parser);                    
                String tagName = parser.getName();
                
                
                for(int i=0; i<parser.getAttributeCount(); i++)
                {
                    String attributeName = parser.getAttributeName(i);
                      
                }
                break;      
            case TEXT:
                String text = parser.getText();
                break;
            case END_TAG:
                _dataGuide.endTag(parser);
                break;
            
            }
        }
        
      
    }
    catch (XmlPullParserException e)
    {
        // TODO Auto-generated catch block 
        e.printStackTrace();
    }
    catch(XMLException e)
    {
        e.printStackTrace();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
      */

  }

}

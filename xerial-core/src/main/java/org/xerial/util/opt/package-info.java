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
/**
 * Command-line argument parser.
 * 
 * 
 * <p>Usage:</p>
 * 
 * <pre>
 * <code>
 *    class MyOption
 *    {
 *     &#064;Option(symbol = "h", longName = "help", description = "display help message")
 *     private boolean      displayHelp;
 *  
 *     &#064;Argument(index = 0)
 *     private String       subCommand;
 *  
 *     &#064;Argument(name = "input_file", index = 1, required = false)
 *     private List<String> fileList;
 *   }
 *  
 *   public void main(String[] args)
 *   {
 *     MyOption myOption = new MyOption();
 *     OptionParser parser = new OptionParser(myOption);
 *  
 *     // parse the command line arguments e.g. "add -h 1.txt 2.txt"
 *     try
 *     {
 *        parser.parse(args);
 *        
 *        // myOption instance's field values are initialized with command line argument
 *        if(displayHelp)
 *        {
 *           parser.printUsage();   // display usage
 *           return;
 *        }
 *  
 *        // array argument is also initialized 
 *        for(String each : fileList)
 *        {
 *            System.out.println(String.format("input file: %s", each));
 *        }
 *     }
 *     catch(OptionParserException e)
 *     {
 *        System.err.println(e.getMessage()):
 *        parser.printUsage();  // display usage
 *     } 
 *  
 *   }
 * </code>
 * </pre>
 * 
 */
package org.xerial.util.opt;


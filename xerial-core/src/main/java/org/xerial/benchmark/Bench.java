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
// Bench.java
// Since: 2006/11/19 22:45:07
//
// $Date$
// $URL$
// $Author$
//--------------------------------------
package org.xerial.benchmark;

import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLGenerator;

public class Bench
{
    private double _sf = 1;    // scaling factor
    
    public Bench(double sf)
    {
        _sf = sf;
    }
    
    enum Opt {HELP, SCALINGFACTOR};
    public static void main(String[] args) throws OptionParserException, InvalidXMLException
    {
        OptionParser<Opt> opt = new OptionParser<Opt>();
        opt.addOption(Opt.HELP, "h", "help", "display help message");
        opt.addOptionWithArgument(Opt.SCALINGFACTOR, "f", "f", "FACTOR", "scaling factor (> 0) sf = 1 will generate almost 1MB data", "1");

        opt.parse(args);
        
        if(opt.isSet(Opt.HELP))
        {
            System.out.println(opt.helpMessage());
            return;
        }
        
        double scalingFactor = opt.getDoubleValue(Opt.SCALINGFACTOR);
        
        Bench b = new Bench(scalingFactor);
        b.generate();
    }
    
    public void generate() throws InvalidXMLException
    {
        XMLGenerator xout = new XMLGenerator(System.out);
        
        int logSize = 30;
        
        int estimatedFileSize = (int) (_sf * 1024 * 1024);  
        int numLog = estimatedFileSize / logSize;
        
        int numTeam = 30;
        int numPlayer = 50;
        int numLogForEachPlayer = numLog / numPlayer / numTeam;
        if(numLogForEachPlayer == 0)
            numLogForEachPlayer = 1;
                
        xout.startTag("mlb"); 
        xout.startTag("db");
        for(int team=0; team<numTeam; team++)
        {
            xout.startTag("team", new XMLAttribute("id", team));
            for(int player=0; player<numPlayer; player++)
            {
                xout.startTag("player", new XMLAttribute("id", player));
                for(int log=0; log<numLogForEachPlayer; log++)
                {
                    xout.startTag("log", new XMLAttribute("id", log));
                    xout.element("hits", Integer.toString(log));
                    xout.endTag();
                }
                xout.endTag(); // player
            }
            xout.endTag(); // team        
        }
        xout.endTag(); // base
        
        
        for(int r=0; r<10; r++)
        {
            xout.startTag("ranking");
            for(int team=0; team<numTeam; team++)
            {
                for(int player=0; player<numPlayer; player++)
                {
                    xout.startTag("player", new XMLAttribute("id", player));
                    xout.element("team", new XMLAttribute("id", team), "");
                    xout.element("rank", Integer.toString(team * numPlayer + player));
                    xout.endTag(); // player
                }
            }
            xout.endTag(); // ranking
        }
        
        xout.endTag(); // mlb
        xout.endDocument();
    }
    
}

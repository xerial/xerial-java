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
// XerialJ Project
//
// Option_optParserTest.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import junit.framework.TestCase;


/**
 * @author leo
 *
 */
public class OptionParserTest extends TestCase
{
    enum Opt {HELP, OUTDIR, VERBOSE, MODE, WINDOWSIZE, LOGLEVEL}       
    
    OptionParser<Opt> _optParser;

    protected void setUp() throws Exception
    {
        _optParser = new OptionParser<Opt>();
        _optParser.addOption(Opt.HELP, "h", "help", "display help message");
        
        _optParser.addOptionWithArgument(Opt.OUTDIR, "o", "output", "DIR", "secify output directory", ".");
        _optParser.addOptionWithArgument(Opt.MODE, "m", "mode", "MODE", "select mode (1-3)", "1");

        OptionGroup<Opt> cuiOptionGroup = new OptionGroup<Opt>("CUI", true);
        cuiOptionGroup.addOption(Opt.VERBOSE, "v", "verbose", "display verbose messages");
        _optParser.addOptionGroup(cuiOptionGroup);
        
        OptionGroup<Opt> guiOptionGroup = new OptionGroup<Opt>("GUI", true);
        guiOptionGroup.addOptionWithArgment(Opt.WINDOWSIZE, "", "windowsize", "SIZE", "set GUI window size", "100");
        _optParser.addOptionGroup(guiOptionGroup);        
    }
    
    public void testDeafaultValue() throws OptionParserException
    {
        _optParser.parse(new String[] {""});
        assertEquals(".", _optParser.getValue(Opt.OUTDIR));
        assertEquals(1, _optParser.getIntValue(Opt.MODE));
        assertEquals(100, _optParser.getIntValue(Opt.WINDOWSIZE));
    }
    
    public void testParse() throws OptionParserException
    {        
        _optParser.parse(new String[] {"-vh", "-o", "outdir", "inputfile.xml"});
        
        assertTrue(_optParser.isSet(Opt.HELP));
        assertTrue(_optParser.isSet(Opt.VERBOSE));
        assertTrue(_optParser.isSet(Opt.OUTDIR));
        assertFalse(_optParser.isSet(Opt.MODE));
        assertFalse(_optParser.isSet(Opt.WINDOWSIZE));
        assertEquals("outdir", _optParser.getValue(Opt.OUTDIR));
        assertEquals(1, _optParser.getArgumentLength());
        assertEquals("inputfile.xml", _optParser.getArgument(0));
    }
    

    public void testDupilicateOption()
    {
        try
        {
            // never allow duplicatte options
            _optParser.addOption(Opt.HELP, "h", "help2", "another help");
            fail("failed to detect duplicate options");
        }
        catch(IllegalArgumentException e)
        {
            // success
        }
    }

    public void testDupilicateOption2()
    {
        try
        {
            // Even if two options with the same ID belong to the different option groups, we do not allow duplicate option IDs.
            OptionGroup<Opt> tmpGroup = new OptionGroup<Opt>("tmp");
            tmpGroup.addOption(Opt.HELP, "h", "help2", "another help");
            _optParser.addOptionGroup(tmpGroup);
            fail("failed to detect duplicate option IDs");
        }
        catch(IllegalArgumentException e)
        {
            // success
        }
    }

    public void testLongOptionArgument() throws OptionParserException
    {
        String args[] = { "--mode=mixed"};
        _optParser.parse(args);
        assertTrue(_optParser.isSet(Opt.MODE));
        assertEquals("mixed", _optParser.getValue(Opt.MODE));
        assertEquals(0, _optParser.getArgumentLength());
    }
    
    public void testGroupCompatibility()
    {
        String args[] = { "-v", "--windowsize=200"};
        try
        {
            _optParser.parse(args);
            fail("OptionParser must recongnize that imcompatible options are set at the same time");
        }
        catch(OptionParserException e)
        {
            //System.err.println(e.getMessage());
        }
    }
    

    boolean helpflag = false;
    boolean logLevelFlag = false;
    String logLevel = null;
    
    public void testHandler() throws OptionParserException
    {
    	OptionParser<Opt> parser = new OptionParser<Opt>();
    	
    	parser.addOption(Opt.HELP, "h", "help", "set the helpflag", new OptionHandler<Opt>() {
            public void handle(OptionParser<Opt> parser) throws OptionParserException
            {
                helpflag = true;
            }
    	}
    	);
    	
    	parser.addOptionWithArgument(Opt.LOGLEVEL, "l", "loglevel", "LEVEL", "set loglevel", new OptionHandler<Opt>() {
    	    public void handle(OptionParser<Opt> parser) throws OptionParserException
    	    {
    	        logLevelFlag = true;
    	        logLevel = parser.getValue(Opt.LOGLEVEL, "INFO");
    	    }
    	});
    	
    	parser.parse(new String[] {"-h", "--loglevel=DEBUG"});
    	
    	assertTrue(helpflag);
    	assertTrue(logLevelFlag);
    	assertEquals("DEBUG", logLevel);
    }
    
    public void testGroupOptionHandler() throws OptionParserException
    {
        OptionParser<Opt> parser = new OptionParser<Opt>();

        OptionGroup<Opt> group = new OptionGroup<Opt>("group");
        group.addOption(Opt.HELP, "h", "help", "set the helpflag", new OptionHandler<Opt>() {
            public void handle(OptionParser<Opt> parser) throws OptionParserException
            {
                helpflag = true;
            }
        }
        );
        
        parser.addOptionGroup(group);
        
        parser.parse(new String[] {"-h"});

        assertTrue(helpflag);
    }
    
}





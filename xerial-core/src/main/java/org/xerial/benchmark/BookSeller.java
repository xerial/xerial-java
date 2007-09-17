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
// BookSeller.java
// Since: 2006/12/05 20:14:25
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
import org.xerial.util.xml.XMLGenerator.IndentType;

public class BookSeller {
    private double _sf = 1;    // scaling factor
    
    public BookSeller(double sf)
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
        
        BookSeller b = new BookSeller(scalingFactor);
        b.generate();
    }
    
    public void generate() throws InvalidXMLException
    {
        XMLGenerator xout = new XMLGenerator(System.out);
        xout.setIndentCharacter(IndentType.TAB, 0);
        
        int estimatedFileSize = (int) (_sf * 1024 * 1024);
        
        int treeSize = estimatedFileSize / 3;   
        
        int orderCount = 1;
        
        xout.startTag("seller"); 
        
        xout.startTag("booklist");
        int s = 0;
        int bookNum = 0;
        while(s < treeSize)
        {
        	int bookID = bookNum++;
        	xout.startTag("book", new XMLAttribute("isbn", "xx" + Integer.toString(bookNum)));
        	xout.element("title", "title" + Integer.toString(bookID));
        	xout.endTag();
        	s += 35;
        }
        xout.endTag(); // booklist

        xout.startTag("customerlist");
        s = 0;
        int numCustomer = 1;
        while(s < treeSize)
        {
        	int customerID = numCustomer++;
        	xout.startTag("customer", new XMLAttribute("id", Integer.toString(customerID)));
        	xout.element("name", "c" + Integer.toString(customerID));
        	
        	s += 35;
        	
        	String status = (numCustomer % 10 == 0)? "pending" : "shipped";
        	xout.startTag(status);
        	s += 10;
        	for(int j=0; j<100; j++)
        	{
        		int book = 1;
        		xout.startTag("order", new XMLAttribute("id", orderCount++));
        		xout.selfCloseTag("book",new XMLAttribute("isbn", book++));
        		xout.endTag(); // order
        		s += 40; 
        	}
    		xout.endTag();	// status
    		s += 10;
        	
        	xout.endTag(); // customer
        	s += 12;
        }
        xout.endTag(); // customerlist
        

        xout.startTag("orderlist");
        s = 0;
        numCustomer = 1;
        bookNum = 1;
        while(s < treeSize)
        {
        	xout.startTag("order", new XMLAttribute("id", Integer.toString(orderCount++)));
        	xout.selfCloseTag("customer", new XMLAttribute("id", "c" + Integer.toString(numCustomer++)));
        	xout.selfCloseTag("book",new XMLAttribute("isbn", bookNum++));
        	xout.endTag(); // order
        	s += 65;
        }
        xout.endTag(); // orderlist

        xout.endTag(); // seller
        xout.endDocument();
    }

}

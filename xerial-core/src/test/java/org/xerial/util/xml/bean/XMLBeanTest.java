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
// XMLBeanTest.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.bean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import junit.framework.TestCase;

import org.xerial.util.FileResource;
import org.xerial.util.XMLParserException;
import org.xerial.util.io.NullOutputStream;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * @author leo
 *
 */
public class XMLBeanTest extends TestCase
{
    Reader fin;
    InputStream fst;
        
    @Override
    protected void setUp() throws Exception
    {
        fin = null;
        fst = null;
    }

    @Override
    protected void tearDown() throws Exception
    {
        if(fin != null)
            fin.close();
        if(fst != null)
            fst.close();
    }

    public void validateBooklist(Booklist booklist)
    {
        Book[] book = booklist.getBook();
        assertEquals(2, book.length);
        assertEquals("Mining The Web", book[0].getTitle());
        assertEquals("Morgan Kaufmann", book[0].getPublisher());
        assertEquals(1, book[0].getAuthor().length);
        assertEquals("Soument Chakrabarti", book[0].getAuthor()[0]);
        assertEquals(2002, book[0].getYear());
        assertEquals("1558607544", book[0].getIsbn());
        
        assertEquals("Learning XML", book[1].getTitle());
        assertEquals(2, book[1].getAuthor().length);
        assertEquals("Erik T. Ray", book[1].getAuthor()[0]);
        assertEquals("Someone Who", book[1].getAuthor()[1]);
        assertEquals(2004, book[1].getYear());
    }
    
    public void testTagreading() throws XmlPullParserException, XMLBeanException, InvalidXMLException, IOException
    {
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        fin = FileResource.open(XMLBeanTest.class, "sample1.xml");
        parser.setInput(fin);
        Item_list itemlist = new Item_list();
        XMLBeanUtil.populate(itemlist, parser);
        assertNotNull(itemlist);
        assertEquals(2, itemlist.getItem().length);
        assertEquals(1, itemlist.getItem()[0]);
        assertEquals(2, itemlist.getItem()[1]);        
    }
    
    public void testIsPrimitive()
    {
        Class[] classes = {int.class, Integer.class, double.class, Double.class, String.class, String[].class };
        for(Class c : classes)
        {
            assertTrue(XMLBeanUtil.isPrimitive(c));
        }

    }
    
    public void testBindRuleGeneration() throws FileNotFoundException, IOException, XmlPullParserException, InvalidXMLException, XMLBeanException
    {
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        fin = FileResource.open(XMLBeanTest.class, "booklist.xml");
        parser.setInput(fin);
        Booklist booklist = new Booklist();
        if(PullParserUtil.parseUntil("booklist", parser))
        {
            XMLBeanUtil.populate(booklist, parser);
            validateBooklist(booklist);
        }
        else
            fail("invalid xml document: cannot find any booklist tag");        
    }
    
    public void testBind() 
    {
        Booklist booklist;
        try
        {
            fst = FileResource.find(XMLBeanTest.class, "booklist.xml").openStream();
            booklist = XMLBeanUtil.newInstance(Booklist.class, fst);
            validateBooklist(booklist);
        }
        catch (XMLParserException e)
        {
            // parser の生成に失敗したとき
            fail(e.getMessage());
        }
        catch (XMLBeanException e)
        {
            // XMLBeanの定義がinvalidのとき
            fail(e.getMessage());
        }
        catch (InvalidXMLException e)
        {
            // 入力のXMLがおかしい場合
            fail(e.getMessage());
        }
        catch (IOException e)
        {
            // ファイル読み込み中のエラー
            fail(e.getMessage());
        }
    }
    
    public void testXMLOut() throws XMLBeanException, InvalidXMLException 
    {
        Book book = new Book();
        book.setAuthor(new String[] {"author A", "author B"});
        book.setTitle("Zip-A-Dee-Doo-Dah");
        book.setIsbn("234098");
        book.setPublisher("Walt Disney");
        XMLBeanUtil.outputAsXML(book, new NullOutputStream());
    }
    public void testNestedBeanOutput() throws XMLBeanException, InvalidXMLException, XMLParserException, FileNotFoundException, IOException
    {
        fst = FileResource.find(XMLBeanTest.class, "booklist.xml").openStream();
        Booklist booklist = XMLBeanUtil.newInstance(Booklist.class, fst);
        XMLBeanUtil.outputAsXML(booklist, new NullOutputStream());
    }
    
    public void testRecursion() throws XMLParserException, XMLBeanException, InvalidXMLException, IOException 
    {
        fst = FileResource.find(XMLBeanTest.class, "recursion.xml").openStream();
        Grammar g = XMLBeanUtil.newInstance(Grammar.class, fst);
        
        assertNotNull(g.getGrammar());
        assertEquals(2, g.getGrammar().length);
        assertEquals("g0", g.getName());
        Grammar[] glist = g.getGrammar();
        assertEquals("g1", glist[0].getName());
        assertEquals("g2", glist[1].getName());
    }
}

class Booklist
{
    Book[] book;
    
    public Booklist()
    {
        
    }
    
    void setBook(Book[] book)
    {
        this.book = book;
    }
    public Book[] getBook()
    {
        return book;
    }
}

class Book
{
    String title;
    int year;
    String[] author;
    String publisher;
    String isbn;
    
    public Book()
    {
        
    }
    
    public String[] attributes()
    {
        return new String[] {"isbn", "publisher"};
    }
    
    void setYear(int year)
    {
        this.year = year; 
    }
    
    void setTitle(String title)
    {
        this.title = title;
    }
    
    void setAuthor(String[] author)
    {
        this.author = author; 
    }
    
    
    /**
     * @return Returns the author.
     */
    public String[] getAuthor()
    {
        return author;
    }
    /**
     * @return Returns the title.
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * @return Returns the year.
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * @return Returns the publisher.
     */
    public String getPublisher()
    {
        return publisher;
    }
    /**
     * @param publisher The publisher to set.
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    /**
     * @return Returns the isbn.
     */
    public String getIsbn()
    {
        return isbn;
    }
    /**
     * @param isbn The isbn to set.
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
}

class Item_list
{
    int[] item;
    
    public int[] getItem()
    {
        return item;
    }
    public void setItem(int[] item)
    {
        this.item = item;
    }
}

class Grammar
{
    String name;
    Grammar[] grammar;
    public Grammar() {}
    
    public Grammar[] getGrammar()
    {
        return grammar;
    }
    public void setGrammar(Grammar[] grammar)
    {
        this.grammar = grammar;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    
    

}


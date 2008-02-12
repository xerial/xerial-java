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
//-----------------------------------
// XerialJ Project
// 
// XMLGenerator.java 
// Since: 2005/01/16
//
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * well-formedなXML文書を生成するためのクラス
 * 
 * <library>[s1](1) 
 * [1]<book>[s1]
 *      <title>[s2]         </title>(2)
 *      <author>  [s3]</author>
 * [s4]</book>
 *    <name>   </name>
 * </library>
 * 
 * (1) newline before nested element
 * (2) newline after leaf element
 * [1] indent before element (indent string SPACE or TAB, indent character size = 2)
 *     
 * 
 * states:
 *   
 *   A (the previous output is starg tag)
 *   B (the previous output is text content)
 *   C (the previous output is end tag)
 * 
 * @author leo
 * TODO attribute対応
 * TODO Javadoc
 * TODO indent on/off
 */
public class XMLGenerator 
{
	public enum IndentType { SPACE, TAB };
	private int _currentLevel = 0;
	private String _indent = "  ";
	private PrintWriter _out;
	private LinkedList<String> _tagStack = new LinkedList<String>();
	
	public enum FormatStab { NewlineBeforeNestedElement, NewlineAfterElement, IndentBeforeElement};
	private HashMap<FormatStab, Boolean> _formatEnableFlag = new HashMap<FormatStab, Boolean>();
	
	private enum PreviousOutput { StartTag, TextContent, EndTag }
	private PreviousOutput _prevOut = PreviousOutput.EndTag;
	
	private boolean isEnable(FormatStab stabType)
	{
		Boolean b = _formatEnableFlag.get(stabType);
		return b == null? false : b;
	}
	
	
	public XMLGenerator text(String textContent)
	{
		_out.print(textContent);
		
		_prevOut = PreviousOutput.TextContent;
		
		return this;
	}
	
	public XMLGenerator startTag(String tagName)
	{
		
		return startTag(tagName, null);
	}
	
	public XMLGenerator startTag(String tagName, XMLAttribute attribute)
	{
		switch(_prevOut)
		{
		case StartTag:
			if(isEnable(FormatStab.NewlineBeforeNestedElement))
				newline();
		case EndTag:
			if(isEnable(FormatStab.IndentBeforeElement))
				indent(_currentLevel);
			break;
		}		
		_out.print("<");
		_out.print(tagName);
		
		if(attribute != null && attribute.length() > 0)
		{
			_out.print(" ");
			_out.print(attribute.toXMLString());
		}
		_out.print(">");
		
		_currentLevel++;
		_tagStack.add(tagName);
		_prevOut = PreviousOutput.StartTag;

		return this;
	}
	
	public XMLGenerator element(String tagName, String textContent) throws InvalidXMLException
	{
		startTag(tagName, null);
		text(textContent);
		endTag();
		return this;
	}
    public XMLGenerator element(String tagName, XMLAttribute attribute, String textContent) throws InvalidXMLException
    {
        startTag(tagName, attribute);
        text(textContent);
        endTag();
        return this;
    }
    public XMLGenerator selfCloseTag(String tagName, XMLAttribute attribute) throws InvalidXMLException
    {
    	startTag(tagName, attribute);
    	endTag();
    	return this;
    }
	
	public XMLGenerator endTag() throws InvalidXMLException
	{
		if(_currentLevel < 1)
			throw new InvalidXMLException("");

		switch(_prevOut)
		{
		case StartTag:
			if(isEnable(FormatStab.NewlineBeforeNestedElement))
				newline();
		case EndTag:
			if(isEnable(FormatStab.IndentBeforeElement))
				indent(_currentLevel-1);
			break;
		}
		
		String tagName = _tagStack.getLast();
		
		_out.print("</");
		_out.print(tagName);
		_out.print(">");
		if(isEnable(FormatStab.NewlineAfterElement))
			newline();
		
		_currentLevel--;
		_tagStack.removeLast();
		_prevOut = PreviousOutput.EndTag;
        
        return this;
	}
	
    public XMLGenerator flush() 
    {
        _out.flush();
        return this;
    }
    
	public void endDocument() throws InvalidXMLException
	{
		while(!_tagStack.isEmpty())
			endTag();
		_out.flush();
	}
	
	private void init()
	{
		_formatEnableFlag.put(FormatStab.NewlineBeforeNestedElement, true);
		_formatEnableFlag.put(FormatStab.NewlineAfterElement, true);
		_formatEnableFlag.put(FormatStab.IndentBeforeElement, true);
	}
	
	public XMLGenerator()
	{
		init();
		setOutputStream(System.out);
	}
	
	public XMLGenerator(OutputStream out)
	{
		init();
		setOutputStream(out);
	}
	public XMLGenerator(Writer out)
	{
		init();
		setOutputWriter(out);
	}
	
	public void setOutputStream(OutputStream out)
	{
		_out = new PrintWriter(out);
	}
	public void setOutputWriter(Writer writer)
	{
		_out = new PrintWriter(writer);
	}
	
	/**
	 * Indentの種類と１レベルあたりの長さを設定する
	 * @param indentType　SPACE or TAB
	 * @param length　1レベルあたりの長さ
	 */
	public void setIndentCharacter(IndentType indentType, int length)
	{
		assert length >= 0;
		
		StringBuffer indent = new StringBuffer();
		switch(indentType)
		{
		case SPACE:
			for(int i=0; i<length; i++)
				indent.append(" ");
			break;
		case TAB:
			for(int i=0; i<length; i++)
				indent.append("\t");
			break;
		}
		_indent = indent.toString();
	}
	
	
	protected void indent(int level)
	{
		for(int i=0; i<level; i++)
			_out.print(_indent);
	}
	protected void newline()
	{
		_out.println();
	}
	
}




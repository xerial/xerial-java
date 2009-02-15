/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
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
// SilkUtil.java
// Since: 2009/02/13 21:15:32
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;

import org.xerial.core.XerialError;
import org.xerial.core.XerialException;
import org.xerial.json.JSONWriter;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeVisitorBase;
import org.xerial.util.tree.TreeWalker;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLErrorCode;
import org.xerial.util.xml.XMLGenerator;

/**
 * Utilities for handling Silk file format.
 * 
 * @author leo
 * 
 */
public class SilkUtil
{
    public static String toXML(URL silkSource) throws IOException, XerialException
    {
        StringWriter buf = new StringWriter();
        toXML(silkSource, buf);
        return buf.toString();
    }

    /**
     * Convert the silk file into XML
     * 
     * @param silkSource
     * @param out
     * @throws IOException
     * @throws XerialException
     */
    public static void toXML(URL silkSource, Writer out) throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(silkSource);
        XMLBuilder builder = new XMLBuilder(out);
        walker.walk(builder);

    }

    /**
     * 
     * <pre>
     * 1:visit -&gt; 2:visit : pop(1), startTag(1, value=&quot;..&quot;), push(2:visit)
     * 1:visit -&gt; 2:text : pop(1), startTag(1, value=&quot;..&quot;), text(2:text) 
     * 1:visit -&gt; 2:leave : pop(1), selfCloseTag(1, value=&quot;..&quot;)
     * </pre>
     * 
     * @author leo
     * 
     */
    private static class XMLBuilder extends TreeVisitorBase
    {
        final XMLGenerator xout;
        final Deque<TreeEvent> eventQueue = new ArrayDeque<TreeEvent>();

        public XMLBuilder(Writer out)
        {
            xout = new XMLGenerator(out);
        }

        private void popQueue()
        {
            if (!eventQueue.isEmpty())
            {
                TreeEvent prev = eventQueue.removeLast();

                switch (prev.event)
                {
                case VISIT:
                    if (prev.nodeValue == null)
                        xout.startTag(prev.nodeName);
                    else
                        xout.startTag(prev.nodeName, new XMLAttribute("value", prev.nodeValue));
                    break;
                default:
                    throw new XerialError(XMLErrorCode.INVALID_XML_STRUCTURE);
                }
            }

        }

        @Override
        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
            popQueue();
            eventQueue.addLast(new TreeEvent(TreeEvent.EventType.VISIT, nodeName, immediateNodeValue));
        }

        @Override
        public void text(String textDataFragment, TreeWalker walker) throws XerialException
        {
            popQueue();
            xout.text(textDataFragment);
        }

        @Override
        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
            if (!eventQueue.isEmpty())
            {
                TreeEvent prev = eventQueue.removeLast();

                switch (prev.event)
                {
                case VISIT:
                    if (prev.nodeValue == null)
                        xout.selfCloseTag(prev.nodeName);
                    else
                        xout.element(prev.nodeName, prev.nodeValue);
                }
            }
            else
                xout.endTag();
        }

        @Override
        public void init(TreeWalker walker) throws XerialException
        {
            visitNode("silk", null, walker);
        }

        @Override
        public void finish(TreeWalker walker) throws XerialException
        {
            leaveNode("silk", walker);
            xout.endDocument();
        }
    }

    public static void toJSON(URL silkSource, Writer out) throws IOException, XerialException
    {
        SilkWalker walker = new SilkWalker(silkSource);
        JSONBuilder builder = new JSONBuilder(out);
        walker.walk(builder);
    }

    private static class JSONBuilder implements TreeVisitor
    {
        final JSONWriter jout;

        public JSONBuilder(Writer out)
        {
            jout = new JSONWriter(out);
        }

        public void finish(TreeWalker walker) throws XerialException
        {
            jout.endArray();

        }

        public void init(TreeWalker walker) throws XerialException
        {
            jout.startArray();

        }

        public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void text(String textDataFragment, TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

        public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
        {
        // TODO Auto-generated method stub

        }

    }

    /**
     * Forbid construction
     */
    protected SilkUtil()
    {}

}

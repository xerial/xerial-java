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
// PrePostOrderIndexer.java
// Since: 2005/06/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import java.io.OutputStream;
import java.io.PrintStream;

import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.Pair;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.AbstractSAXEventHandler;
import org.xmlpull.v1.XmlPullParser;

/**
 * pre-post order labeling
 * 
 * @author leo
 * 
 */
public class PrePostOrderIndexer extends AbstractSAXEventHandler
{
    private int _preOrder = 0;
    private int _postOrder = 0;
    private Deque<Pair<Integer, String>> _nodeStack;

    private final PrintStream out;

    /**
     * 
     */
    public PrePostOrderIndexer(OutputStream out)
    {
        this.out = new PrintStream(out);
    }

    @Override
    public void startDocument(XmlPullParser parser) throws XMLException
    {
        _nodeStack = new ArrayDeque<Pair<Integer, String>>();
        _preOrder = 0;
        _postOrder = 0;
        pushStack();
    }

    private void pushStack()
    {
        _nodeStack.add(new Pair<Integer, String>(_preOrder++, null));
    }

    private void popStack(String tagName)
    {
        Pair<Integer, String> node = _nodeStack.removeLast();
        int preOrder = node.getFirst();
        int postOrder = _postOrder++;
        // output node info
        out.println(preOrder + "\t" + postOrder + "\t" + tagName + "\t"
                + (node.getSecond() != null ? node.getSecond().trim() : ""));
    }

    @Override
    public void endDocument(XmlPullParser parser) throws XMLException
    {
        popStack("_root");
    }

    @Override
    public void startTag(XmlPullParser parser) throws XMLException
    {
        pushStack();
    }

    @Override
    public void endTag(XmlPullParser parser) throws XMLException
    {
        popStack(parser.getName());
    }

    @Override
    public void text(XmlPullParser parser) throws XMLException
    {
        Pair<Integer, String> currentNode = _nodeStack.removeLast();
        _nodeStack.addLast(new Pair<Integer, String>(currentNode.getFirst(), parser.getText()));
    }

}

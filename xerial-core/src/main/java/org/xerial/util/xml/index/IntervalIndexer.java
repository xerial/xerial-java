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
// IntervalIndexer.java
// Since: 2005/09/09 13:06:28
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml.index;

import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.Pair;
import org.xerial.util.StringUtil;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.pullparser.AbstractSAXEventHandler;
import org.xmlpull.v1.XmlPullParser;

/**
 * Label XML documents with start and end intervals
 * 
 * @author leo
 * 
 */
public class IntervalIndexer extends AbstractSAXEventHandler
{
    Deque<Pair<Integer, String>> _startOrderStack; // (start, text data) のスタック
    int _currentDepth = 0;
    int _startOrder = 0;
    LWIndexWriter _writer;

    int STARTORDER_INCREMENT = 1;
    int MINIMUM_INTERAVAL = 1;

    public class LWIndex implements XMLNode
    {
        int start;
        int end;
        int level;

        /**
         * @param end
         * @param level
         * @param start
         */
        public LWIndex(int start, int end, int level)
        {
            this.start = start;
            this.end = end;
            this.level = level;
        }

        public String outputAsTabDelimited()
        {
            return StringUtil.concatinateWithTab(start, end, level);
        }
    }

    public IntervalIndexer(LWIndexWriter writer)
    {
        _writer = writer;
    }

    @Override
    public void endDocument(XmlPullParser parser) throws XMLException
    {
        // tear down
        popStack(parser);
    }

    @Override
    public void endTag(XmlPullParser parser) throws XMLException
    {
        popStack(parser);
    }

    @Override
    public void startDocument(XmlPullParser parser) throws XMLException
    {
        // initialize 
        _startOrderStack = new ArrayDeque<Pair<Integer, String>>();
        _startOrder = 0;
        _currentDepth = 0;
        pushStack();
    }

    @Override
    public void startTag(XmlPullParser parser) throws XMLException
    {
        pushStack();
    }

    @Override
    public void text(XmlPullParser parser) throws XMLException
    {
        Pair<Integer, String> currentNode = _startOrderStack.removeLast();
        String text = parser.getText();
        _startOrderStack.addLast(new Pair<Integer, String>(currentNode.getFirst(),
                currentNode.getSecond() == null ? text : currentNode.getSecond() + text));
    }

    private void pushStack()
    {
        _startOrderStack.addLast(new Pair<Integer, String>(_startOrder, null));
        _startOrder += STARTORDER_INCREMENT;
        _currentDepth++;
    }

    private void popStack(XmlPullParser parser)
    {
        int endOrder = _startOrder + MINIMUM_INTERAVAL;

        Pair<Integer, String> currentNode = _startOrderStack.removeLast();
        // output node data
        _writer.write(new LWIndex(currentNode.getFirst(), endOrder, _currentDepth), parser.getName(), currentNode
                .getSecond());

        _startOrder = endOrder + STARTORDER_INCREMENT;
        _currentDepth--;
    }

}

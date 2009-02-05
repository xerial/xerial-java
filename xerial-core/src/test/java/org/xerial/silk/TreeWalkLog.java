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
// TreeWalkLog.java
// Since: Feb 5, 2009 2:00:05 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.xerial.core.XerialException;
import org.xerial.util.StringUtil;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * Collects tree visitor event
 * 
 * @author leo
 * 
 */
public class TreeWalkLog implements TreeVisitor
{
    private static Logger _logger = Logger.getLogger(TreeWalkLog.class);

    public static enum Event {
        INIT, FINISH, VISIT, LEAVE, TEXT
    }

    public static class EventLog
    {
        Event event;
        String nodeName = null;
        String value = null;

        public EventLog(Event event)
        {
            this.event = event;
        }

        public EventLog(Event event, String nodeName, String value)
        {
            this.event = event;
            this.nodeName = nodeName;
            this.value = value;
        }

        public static boolean strCmp(String a, String b)
        {
            if (a == null)
                return b == null;
            else
            {
                if (b == null)
                    return false;

                return a.equals(b);
            }
        }

        @Override
        public boolean equals(Object o)
        {
            EventLog other = (EventLog) o;
            if (event != other.event)
                return false;

            if (!strCmp(nodeName, other.nodeName))
                return false;

            return strCmp(value, other.value);
        }

        @Override
        public String toString()
        {
            if (nodeName != null)
            {
                if (value != null)
                    return String.format("%s:%s=%s", event, nodeName, value);
                else
                    return String.format("%s:%s", event, nodeName);
            }
            else
            {
                if (value != null)
                    return String.format("%s:%s", event, value);
                else
                    return String.format("%s", event);
            }
        }
    }

    private List<EventLog> log = new LinkedList<EventLog>();

    public void finish(TreeWalker walker) throws XerialException
    {
        log.add(new EventLog(Event.FINISH));
    }

    public void init(TreeWalker walker) throws XerialException
    {
        log.add(new EventLog(Event.INIT));
    }

    public void leaveNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
    {
        if (nodeName == null)
            return; // skip empty node leave (e.g. JSON Object root bracket)

        log.add(new EventLog(Event.LEAVE, nodeName, immediateNodeValue));
    }

    public void text(String textDataFragment) throws XerialException
    {
        log.add(new EventLog(Event.TEXT, null, textDataFragment));

    }

    public void visitNode(String nodeName, TreeWalker walker) throws XerialException
    {
        if (nodeName == null)
            return; // skip empty node visit (e.g. JSON Object root bracket)

        log.add(new EventLog(Event.VISIT, nodeName, null));
    }

    public List<EventLog> getLog()
    {
        return log;
    }

    @Override
    public String toString()
    {
        return StringUtil.join(log, "\n");
    }

    public static boolean compare(TreeWalkLog a, TreeWalkLog b)
    {
        List<EventLog> l1 = a.getLog();
        List<EventLog> l2 = b.getLog();

        Iterator<EventLog> i1 = l1.iterator();
        Iterator<EventLog> i2 = l2.iterator();

        boolean compareFlag = true;

        while (i1.hasNext() && i2.hasNext())
        {
            EventLog e1 = i1.next();
            EventLog e2 = i2.next();

            _logger.info(String.format("compare: %-20s %-20s", e1, e2));
            if (!e1.equals(e2) && compareFlag)
            {
                _logger.warn("not match");
                compareFlag = false;
            }
        }
        if (l1.size() != l2.size())
            compareFlag = false;
        return compareFlag;
    }

}

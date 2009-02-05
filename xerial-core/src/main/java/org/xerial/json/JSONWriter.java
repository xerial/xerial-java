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
//--------------------------------------
// XerialJ
//
// JSONWriter.java
// Since: Feb 1, 2008 10:22:07 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedList;
import java.util.ListIterator;

import org.xerial.core.XerialError;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUtil;

/**
 * A support class for generating JSON data
 * 
 * @author leo
 * 
 */
public class JSONWriter
{
    private final Writer writer;

    enum JSONState {
        InObject, InArray, InString, Root, Unknown
    }

    private final LinkedList<JSONState> stateStack = new LinkedList<JSONState>();
    private final LinkedList<Integer> elementCountStack = new LinkedList<Integer>();

    public JSONWriter(Writer writer)
    {
        this.writer = writer;
        stateStack.add(JSONState.Root);
        elementCountStack.add(0);
    }

    private void pushState(JSONState state)
    {
        stateStack.add(state);
        elementCountStack.add(0);
    }

    private void popState()
    {
        stateStack.removeLast();
        elementCountStack.removeLast();
    }

    private JSONState getCurrentState()
    {
        if (stateStack.isEmpty())
            return JSONState.Unknown;
        else
            return stateStack.getLast();
    }

    private int getPreviousElementCount()
    {
        return elementCountStack.isEmpty() ? 0 : elementCountStack.getLast();
    }

    private void incrementElementCount()
    {
        int count = elementCountStack.removeLast();
        elementCountStack.add(++count);
    }

    public void startObject() throws IOException
    {
        if (getCurrentState() == JSONState.InArray)
            putComma();
        writer.append("{");
        pushState(JSONState.InObject);
    }

    public void endObject() throws IOException
    {
        if (getCurrentState() != JSONState.InObject)
            throw new XerialError(JSONErrorCode.NotInAJSONObject, "cannot end the object outside of the JSON object");
        writer.append("}");
        popState();

        if (getCurrentState() == JSONState.InArray)
            incrementElementCount();
    }

    public void startArray() throws IOException
    {
        writer.append("[");
        pushState(JSONState.InArray);
    }

    public void endArray() throws IOException
    {
        if (getCurrentState() != JSONState.InArray)
            throw new XerialError(JSONErrorCode.NotInAJSONArray, "cannot end the arry outside of the JSON array");

        writer.append("]");
        popState();
    }

    public void startString() throws IOException
    {
        if (getCurrentState() == JSONState.InArray)
            throw new XerialError(JSONErrorCode.NotInAJSONArray,
                    "cannot start a new string value outside of the JSON array in this method");
        putComma();
        writer.append("\"");
        pushState(JSONState.InString);
    }

    public void startString(String key) throws IOException
    {
        outputKeyPart(key);
        writer.append("\"");
        pushState(JSONState.InString);
    }

    public void append(String stringFragment) throws IOException
    {
        if (getCurrentState() != JSONState.InString)
            throw new XerialError(JSONErrorCode.NotInAJSONString,
                    "cannot append any string before invoking startString() method");

        writer.append(stringFragment);
    }

    public void endString() throws IOException
    {
        if (getCurrentState() != JSONState.InString)
            throw new XerialError(JSONErrorCode.NotInAJSONString,
                    "cannot end the string not beginning from startString() method.");
        writer.append("\"");
        popState();
    }

    public void startArray(String key) throws IOException
    {
        if (getCurrentState() != JSONState.InObject)
            throw new XerialError(JSONErrorCode.NotInAJSONObject,
                    "cannot start a keyed array outside of the JSON object");

        if (getPreviousElementCount() > 0)
            writer.append(",");
        writer.append(doubleQuote(key));
        writer.append(":[");
        incrementElementCount();
        pushState(JSONState.InArray);
    }

    public void add(String value) throws IOException
    {
        addInternal(doubleQuote(value));
    }

    public void add(int value) throws IOException
    {
        addInternal(value);
    }

    public void add(long value) throws IOException
    {
        addInternal(value);
    }

    public void add(double value) throws IOException
    {
        addInternal(value);
    }

    public void add(float value) throws IOException
    {
        addInternal(value);
    }

    public void add(boolean bool) throws IOException
    {
        if (bool)
            addInternal("true");
        else
            addInternal("false");
    }

    public void addNull() throws IOException
    {
        addInternal("null");
    }

    public void addObject(Object bean) throws IOException
    {
        try
        {
            String jsonObject = BeanUtil.toJSON(bean);
            addInternal(jsonObject);
        }
        catch (BeanException e)
        {
            throw new XerialError(JSONErrorCode.InvalidBeanClass, "cannot generate a JSON data from the given object");
        }
    }

    private void addInternal(Object value) throws IOException
    {
        putComma();
        if (value != null)
            writer.append(value.toString());
        else
            writer.append("null");
        incrementElementCount();
    }

    private void putComma() throws IOException
    {
        if (getPreviousElementCount() > 0)
            writer.append(",");
    }

    public void put(String key, String value) throws IOException
    {
        putInternal(key, doubleQuote(value));
    }

    public void put(String key, int value) throws IOException
    {
        putInternal(key, value);
    }

    public void put(String key, float value) throws IOException
    {
        putInternal(key, value);
    }

    public void put(String key, double value) throws IOException
    {
        putInternal(key, value);
    }

    public void put(String key, long value) throws IOException
    {
        putInternal(key, value);
    }

    public void put(String key, boolean value) throws IOException
    {
        if (value)
            putInternal(key, "true");
        else
            putInternal(key, "false");
    }

    public void putNull(String key) throws IOException
    {
        putInternal(key, "null");
    }

    /**
     * Generate the key/value pair from the {@link Reader}
     * 
     * @param key
     * @param input
     * @throws IOException
     */
    public void putString(String key, Reader input) throws IOException
    {
        outputKeyPart(key);
        writer.append("\"");
        for (int ch; (ch = input.read()) != -1;)
        {
            writer.append((char) ch);
        }
        writer.append("\"");
    }

    private void putInternal(String key, Object value) throws IOException
    {
        outputKeyPart(key);
        writer.append(value.toString());
        incrementElementCount();
    }

    private void outputKeyPart(String key) throws IOException
    {
        if (getCurrentState() != JSONState.InObject)
            throw new XerialError(JSONErrorCode.NotInAJSONObject,
                    "cannot add key and value pair outside of the JSON object");
        if (getPreviousElementCount() > 0)
            writer.append(",");
        writer.append(doubleQuote(key));
        writer.append(":");
    }

    public void flush() throws IOException
    {
        writer.flush();
    }

    public void endJSON() throws IOException
    {
        for (ListIterator<JSONState> it = stateStack.listIterator(stateStack.size()); it.hasPrevious();)
        {
            JSONState state = it.previous();
            switch (state)
            {
            case InObject:
                writer.append("}");
                break;
            case InArray:
                writer.append("]");
                break;
            case InString:
                writer.append("\"");
            default:
                // do nothing
                break;
            }
        }
        flush();
    }

    private String doubleQuote(String value)
    {
        return "\"" + value + "\"";
    }

    public Writer getWriter()
    {
        return writer;
    }

}

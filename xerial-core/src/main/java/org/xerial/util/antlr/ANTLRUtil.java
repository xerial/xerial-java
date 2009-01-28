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
// ANTLRUtil.java
// Since: Nov 4, 2008 9:51:27 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.antlr;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.xerial.util.FileResource;
import org.xerial.util.StringUtil;

public class ANTLRUtil
{
    public static String toVisibleString(String text)
    {
        text = text.replaceAll("\n", "\\\\n");
        text = text.replaceAll("\r", "\\\\r");
        text = text.replaceAll("\t", "\\\\t");
        return '"' + text + '"';
    }

    public static String parseTree(Tree t, String[] parserTokenNames)
    {
        StringBuilder sb = new StringBuilder();
        parseTree(sb, t, 0, parserTokenNames);
        return sb.toString();
    }

    private static void parseTree(StringBuilder sb, Tree t, int depth, String[] parserTokenNames)
    {
        if (t == null)
            return;

        // input node itself
        for (int i = 0; i < depth; i++)
        {
            sb.append(" ");
        }
        String tokenName = parserTokenNames[t.getType()];
        sb.append("[");
        sb.append(tokenName);
        sb.append("]\t");
        if (t.getText() != null && !t.getText().equals(tokenName))
            sb.append(toVisibleString(t.getText()));
        sb.append(StringUtil.newline());

        // child nodes
        for (int i = 0; i < t.getChildCount(); i++)
        {
            parseTree(sb, t.getChild(i), depth + 1, parserTokenNames);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Integer, String> getTokenTable(Class< ? > packageBaseClass, String tokenFileName)
            throws IOException
    {
        Properties p = new Properties();
        TreeMap<Integer, String> tokenTable = new TreeMap<Integer, String>();

        URL wikiTokenFileURL = FileResource.find(packageBaseClass, tokenFileName);
        if (wikiTokenFileURL != null)
            p.load(wikiTokenFileURL.openStream());

        for (Iterator it = p.keySet().iterator(); it.hasNext();)
        {
            String tokenName = (String) it.next();
            int tokenType = Integer.parseInt(p.get(tokenName).toString());
            tokenTable.put(tokenType, tokenName);
        }

        return tokenTable;
    }

    @SuppressWarnings("unchecked")
    public static List<String> prettyPrintTokenList(List tokenList, Map<Integer, String> tokenTable)
    {
        ArrayList<String> result = new ArrayList<String>();
        for (Iterator it = tokenList.iterator(); it.hasNext();)
        {
            Token t = (Token) it.next();
            result.add(prettyPrint(t, tokenTable));
        }
        return result;
    }

    public static String prettyPrint(Token t, Map<Integer, String> tokenTable)
    {

        int charStart = t.getCharPositionInLine();
        int charEnd = charStart + t.getText().length();
        return String.format("[%3d(%4d-%4d)] %12s: %s", t.getLine(), charStart, charEnd, tokenTable.get(t.getType()),
                ANTLRUtil.toVisibleString(t.getText()));
    }

}

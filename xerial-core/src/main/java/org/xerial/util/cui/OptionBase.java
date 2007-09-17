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
// Phenome Commons Project
//
// OptionComposite.java
// Since: 2005/01/03
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.cui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * A base class for {@link Option} and {@link OptionGroup}
 * 
 * @author leo
 *
 */
abstract class OptionBase<OptionID extends Comparable> 
{
    abstract protected Option<OptionID> findByLongOptionName(String longOption);
    abstract protected Option<OptionID> findByShortOptionName(String shortOption);
    abstract protected Option<OptionID> findOption(OptionID optionID);
    abstract protected void collectOptionID(List<OptionID> optionIDList);
    abstract protected void collectOptionDescriptions(OptionDescriptionContainer container);
    
    protected OptionBase(OptionGroup<OptionID> parentGroup)
    {
        setParent(parentGroup);
    }
    
    protected void setParent(OptionGroup<OptionID> parentGroup)
    {
        _parentGroup = parentGroup;
    }
    protected OptionGroup<OptionID> getParent()
    {
        return _parentGroup;
    }
    
    protected void activateParentGroup()
    {
        OptionGroup<OptionID> parent = getParent();
        if(parent != null)
            parent.activate();
    }
    

    
    private OptionGroup<OptionID> _parentGroup = null;
}



/**
 * A container class that holds help messages
 * @author leo
 *
 */
class OptionDescriptionContainer
{

    public void addDescription(String shortOptionColumn, String longOptionColumn, String descriptionColumn)
    {
        String column[] = new String[3];
        column[0] = shortOptionColumn;
        column[1] = longOptionColumn;
        column[2] = descriptionColumn;
        _columnList.add(column);
    }
    public void addDescription(String groupName)
    {
        String singleColumn[] = new String[1];
        singleColumn[0] = groupName;
        _columnList.add(singleColumn);
    }

    public String toString()
    {
        // calculate necessary width for each column
        int width[] = { 0, 0, 0 };
        for (Iterator ci = _columnList.iterator(); ci.hasNext();)
        {
            String[] line = (String[]) ci.next();
            if (line.length != 3)
                continue; // single line 
            for (int i = 0; i < line.length; i++)
                width[i] = width[i] < line[i].length() ? line[i].length() : width[i];
        }
        for(int i=0; i<width.length; i++)
            width[i]++;
        // print each options
        StringWriter strWriter = new StringWriter();
        PrintWriter out = new PrintWriter(strWriter);
        for (Iterator ci = _columnList.iterator(); ci.hasNext();)
        {
            String[] line = (String[]) ci.next();
            if(line.length == 1)
                out.print(line[0]);  // group name
            else
            {
                out.print(" "); /// left margin
                for (int i = 0; i < line.length; i++)
                {
                    out.print(line[i]);
                    int numSpace = width[i] - line[i].length();
                    for (int j = 0; j < numSpace; j++)
                        out.print(" ");
                }   
            }
            out.println();
        }
        return strWriter.toString();
    }

    LinkedList<String[]> _columnList = new LinkedList<String[]>();
}




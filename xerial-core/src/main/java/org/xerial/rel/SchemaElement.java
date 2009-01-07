/*--------------------------------------------------------------------------
 *  Copyright 2008 utgenome.org
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
// utgb-core Project
//
// SchemaElement.java
// Since: Jan 6, 2009
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.rel;

/**
 * A base class of the {@link ObjectSchema} and {@link ObjectAttribute}
 * 
 * @author leo
 * 
 */
public abstract class SchemaElement
{

    protected static final String NULL_STR = null;
    private String name = NULL_STR;
    private Occurrence occurrence = Occurrence.ONE;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Occurrence getOccurrence()
    {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence)
    {
        this.occurrence = occurrence;
    }

    public abstract String getValue();

    public String getDataType()
    {
        throw new UnsupportedOperationException("getDataType()");
    }

    public abstract boolean hasValue();

    public abstract boolean isAttribute();

    public abstract boolean isObject();

    public abstract boolean isFollowedByStreamData();

}

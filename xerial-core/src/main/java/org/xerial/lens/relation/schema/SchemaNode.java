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
// SchemaNode.java
// Since: 2009/05/13 22:24:31
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.io.Serializable;

import org.xerial.lens.relation.DataType;
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.NodeBase;

/**
 * SchemaNode
 * 
 * @author leo
 * 
 */
public class SchemaNode extends NodeBase<SchemaNode> implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public final String name;
    public final DataType type;
    public final FD fd;

    public SchemaNode(String name)
    {
        this(name, DataType.STRING, FD.ONE_TO_ONE);
    }

    public SchemaNode(String name, DataType type)
    {
        this(name, type, FD.ONE_TO_ONE);
    }

    public SchemaNode(String name, DataType type, FD fd)
    {
        this.name = name;
        this.type = type;
        this.fd = fd;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s%s", name, type.name().toLowerCase(), fd);
    }

}

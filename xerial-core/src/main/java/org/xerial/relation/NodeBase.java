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
// NodeBase.java
// Since: 2009/05/13 22:28:04
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;

/**
 * 
 * Base implementation of the Node
 * 
 * @author leo
 * 
 * @param <NodeType>
 */
public abstract class NodeBase<NodeType> implements Cell<NodeType>
{
    protected NodeBase()
    {}

    public boolean isNode()
    {
        return true;
    }

    public boolean isTuple()
    {
        return false;
    }

    /**
     * Always return 1
     * 
     * @return
     */
    public int size()
    {
        return 1;
    }

    public Tuple<NodeType> getTuple()
    {
        throw new XerialError(XerialErrorCode.UNSUPPORTED);
    }

    public Cell<NodeType> get(TupleIndex index)
    {
        if (index.size() == 0 && index.get(0) == 0)
            return (Cell<NodeType>) this;
        else
            throw new XerialError(XerialErrorCode.INVALID_STATE);
    }

    @SuppressWarnings("unchecked")
    public NodeType getNode(TupleIndex index)
    {
        if (!(index.size() == 1 && index.get(0) == 0))
            throw new XerialError(XerialErrorCode.INVALID_STATE);
        else
            return (NodeType) this;
    }

    @SuppressWarnings("unchecked")
    public NodeType getNode()
    {
        return (NodeType) this;
    }

    @SuppressWarnings("unchecked")
    public void accept(CellVisitor<NodeType> visitor)
    {
        visitor.visitNode((NodeType) this);
    }

}
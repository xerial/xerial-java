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
// RelationalSchema.java
// Since: May 13, 2009 6:03:45 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.relation.schema;

import java.util.List;

import org.xerial.relation.FD;
import org.xerial.relation.TupleIndex;
import org.xerial.util.Functor;

/**
 * non-1NF relational schema
 * 
 * @author leo
 * 
 */
/**
 * The interface of relational schema
 * 
 * @author leo
 * 
 */
public interface Schema
{
    public String getName();

    public int size();

    public boolean isAtom();

    public boolean isNested();

    public boolean isOneToMany();

    public boolean isOneToOne();

    public FD getFD();

    public Schema get(TupleIndex index);

    public Schema get(int index);

    public Schema flatten();

    public List<String> getNodeNameList();

    public String selfLoopNode();

    public TupleIndex getNodeIndex(String nodeName);

    /**
     * Iterates over nested elements
     * 
     * @param <Output>
     * @param functor
     * @return
     */
    public void forEachNestedNodeName(Functor<String, ? > functor);

    public void accept(SchemaVisitor visitor);
}

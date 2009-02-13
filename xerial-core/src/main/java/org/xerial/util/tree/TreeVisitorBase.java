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
// TreeVisitorBase.java
// Since: Feb 9, 2009 6:57:14 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.tree;

import org.xerial.core.XerialException;

/**
 * Base implementation of {@link TreeVisitor} interface. Override methods in
 * this class.
 * 
 * @author leo
 * 
 */
public class TreeVisitorBase implements TreeVisitor
{

    public void finish(TreeWalker walker) throws XerialException
    {

    }

    public void init(TreeWalker walker) throws XerialException
    {

    }

    public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
    {

    }

    public void text(String textDataFragment) throws XerialException
    {

    }

    public void visitNode(String nodeName, String immediateNodeValue, TreeWalker walker) throws XerialException
    {

    }

}

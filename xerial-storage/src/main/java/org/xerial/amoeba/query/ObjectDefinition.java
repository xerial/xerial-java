/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// ObjectDefinition.java
// Since: Dec 11, 2007 3:02:16 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;
import org.xerial.amoeba.query.impl.AmoebaQueryParser;
import org.xerial.db.DBErrorCode;
import org.xerial.db.DBException;
import org.xerial.db.Relation;

/**
 * Object definition 
 * @author leo
 *
 */
public class ObjectDefinition
{
    private String objectName = "unknown";
    private ArrayList<String> sortTargetList = new ArrayList<String>();
    private Relation relation = new Relation();
    
    public ObjectDefinition(Tree t) throws DBException
    {
        if(t.getType() != AmoebaQueryParser.OBJECT_DEF)
            throw new DBException(DBErrorCode.InvalidToken, "invalid token type: " + AmoebaQueryParser.tokenNames[t.getType()]);
        parse(t);
    }
    
    private void parse(Tree t)
    {
        assert(t.getType() == AmoebaQueryParser.OBJECT_DEF);
        objectName = t.getText();
        
        // data type 
        for(Tree defNode : ANTLRUtil.getNodeList(t, AmoebaQueryParser.ATTRIBUTE_DEF))
        {
            String attributeName = defNode.getText();
            Tree dataTypeNode = ANTLRUtil.getFirstNode(defNode, AmoebaQueryParser.DataType);
            if(dataTypeNode == null)
                continue;

            String dataTypeName = dataTypeNode.getText();
            relation.add(Relation.getDataType(attributeName, dataTypeName));
        }
        
        
        Tree sortTarget = ANTLRUtil.getFirstNode(t, AmoebaQueryParser.SORT_TARGET);
        sortTargetList = ANTLRUtil.getValueList(sortTarget, AmoebaQueryParser.ATTRIBUTE);
 
    }
 
    
}

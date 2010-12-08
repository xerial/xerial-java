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
// AmoebaQueryToken.java
// Since: Dec 11, 2007 3:13:22 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import java.util.HashMap;

import org.xerial.amoeba.query.impl.AmoebaQueryParser;

public class AmoebaQueryToken
{
    private static HashMap<String, Integer> tokenTable = new HashMap<String, Integer>();
    
    static 
    {
        for(int i=0; i<AmoebaQueryParser.tokenNames.length; i++)
        {
            tokenTable.put(AmoebaQueryParser.tokenNames[i],i); 
        }
    }
    
    public static String getTokenName(int tokenType)
    {
        return AmoebaQueryParser.tokenNames[tokenType];
    }
    public static int getTokenType(String tokenName)
    {
        if(tokenTable.containsKey(tokenName))
            return tokenTable.get(tokenName);
        else
            return -1; // invalid token name
    }
    
}

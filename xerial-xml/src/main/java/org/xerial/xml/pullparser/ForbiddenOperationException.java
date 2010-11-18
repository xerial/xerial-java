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
// XerialJ
//
// ForbiddenOperationException.java
// Since: 2005/07/24 2:24:46
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.xml.pullparser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * 
 * @author leo
 * 
 */
public class ForbiddenOperationException extends XmlPullParserException {
    /**
     * 
     */
    private static final long serialVersionUID = 7635782318856182760L;

    public ForbiddenOperationException(String arg0) {
        super(arg0);
    }

    public ForbiddenOperationException(String arg0, XmlPullParser arg1, Throwable arg2) {
        super(arg0, arg1, arg2);
    }

}

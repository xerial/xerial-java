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
// XMLErrorCode.java
// Since: Dec 18, 2007 4:18:42 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.xml;

import org.xerial.core.ErrorCode;

/**
 * XML related errors
 * 
 * @author leo
 * 
 */
public enum XMLErrorCode implements ErrorCode {

    INVALID_XML_STRUCTURE, NO_MORE_TAG_TO_CLOSE, PARSE_ERROR, SAX_ERROR, INVALID_PARSER_CONFIGURATION, FAILED_TO_CREATE_XML_PARSER;

    private final String description;

    private XMLErrorCode() {
        this.description = EMPTY_DESCRIPTION;
    }

    private XMLErrorCode(String description) {
        this.description = description;
    }

    public String getCodeName() {
        return name();
    }

    public String getDescription() {
        return description;
    }

}

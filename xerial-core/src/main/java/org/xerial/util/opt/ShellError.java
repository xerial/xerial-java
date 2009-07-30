/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// ShellError.java
// Since: Oct 27, 2008 12:19:58 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import org.xerial.core.ErrorCode;

public enum ShellError implements ErrorCode {

    INACCESSIBLE_SETTER_METHOD(""), NO_OPTION_ANNOTATION_IS_FOUND

    ;

    private final String description;

    private ShellError() {
        this.description = "";
    }

    private ShellError(String description) {
        this.description = description;
    }

    public String getCodeName() {
        return name();
    }

    public String getDescription() {
        return description;
    }

    public Enum< ? > getCode() {
        return this;
    }

}

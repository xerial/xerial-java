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
// ErrorCode.java
// Since: Dec 18, 2007 3:23:09 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.core;

/**
 * A common interfarce for error codes
 * 
 * @author leo
 * 
 */
public interface ErrorCode
{
    static final String EMPTY_DESCRIPTION = "";

    public String getCodeName();

    public String getDescription();
}

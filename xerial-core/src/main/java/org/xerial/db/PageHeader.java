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
// PageHeader.java
// Since: Aug 31, 2007 9:44:17 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db;

/**
 * PageHeader interface
 * @author leo
 *
 */
public interface PageHeader
{
    /**
     * Gets the byte size of the header
     * @return the byte size of the header
     */
    int getHeaderSize();
}

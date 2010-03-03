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
// Xerial Raquel Project
//
// Attribute.java
// Since: Oct 6, 2008 2:58:41 PM
//
// $URL: http://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/expr/RelationAttribute.java $
// $Author: leo $
//--------------------------------------
package org.xerial.lens.relation.schema;

import org.xerial.lens.ObjectLens;
import org.xerial.lens.relation.FD;

/**
 * This class defines {@link RelationSchema} attributes.
 * 
 * @author leo
 * 
 */
public class RelationAttribute {
    private String name;
    private FD occurrence = FD.ONE_TO_ONE;

    public RelationAttribute() {

    }

    public RelationAttribute(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = ObjectLens.getCanonicalParameterName(name);
    }

    public String getName() {
        return name;
    }

    public FD getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(FD occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        if (occurrence == FD.ONE_TO_ONE)
            return name;
        else
            return String.format("%s %s", name, occurrence);
    }

}

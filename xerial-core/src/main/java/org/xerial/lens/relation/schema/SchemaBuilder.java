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
// SchemaBuilder.java
// Since: 2009/05/14 18:09:30
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation.schema;

import java.util.ArrayList;

import org.xerial.lens.relation.DataType;
import org.xerial.lens.relation.FD;

public class SchemaBuilder {
    Schema parent = null;
    ArrayList<Schema> element = new ArrayList<Schema>();
    FD occurrence = FD.ONE_TO_ONE;

    public SchemaBuilder() {

    }

    public SchemaBuilder(Schema parent) {
        setParent(parent);
    }

    public SchemaBuilder setParent(Schema parent) {
        this.parent = parent;
        return this;
    }

    public SchemaBuilder setFD(FD fd) {
        this.occurrence = fd;
        return this;
    }

    public SchemaBuilder add(Schema elem) {
        this.element.add(elem);
        return this;
    }

    public SchemaBuilder add(String attribute) {
        this.element.add(new SchemaAtom(attribute.toLowerCase()));
        return this;
    }

    public SchemaBuilder add(String attribute, FD fd) {
        this.element.add(new SchemaAtom(attribute.toLowerCase(), fd));
        return this;
    }

    public SchemaBuilder add(String attribute, DataType type, FD fd) {
        this.element.add(new SchemaAtom(attribute.toLowerCase(), type, fd));
        return this;
    }

    public SchemaArray build() {
        return new SchemaArray(parent, element, occurrence);
    }

}

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
// Coordinate.java
// Since: 2009/02/18 20:09:09
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

public class Coordinate {
    String group;
    String species;
    String revision;
    String name;

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("group=%s, species=%s, revision=%s, name=%s", group, species,
                revision, name);
    }

}

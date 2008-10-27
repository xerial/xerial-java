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
// Argument.java
// Since: Oct 27, 2008 11:37:08 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.shell;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command-line argument with no option prefix such as "-" or "--"
 * 
 * @author leo
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD, ElementType.METHOD })
public @interface Argument {
    /**
     * description of the argument
     */
    String description() default "";

    /**
     * This argument is required
     */
    boolean required() default false;

    /**
     * argument index (0-origin) among the arguments without option prefix, "-"
     * or "--". The default is 0
     */
    int index() default 0;

}

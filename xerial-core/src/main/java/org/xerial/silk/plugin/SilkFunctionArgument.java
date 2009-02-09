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
// SilkFunctionArgument.java
// Since: Feb 9, 2009 6:18:27 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Silk function argument.
 * 
 * Usage:
 * 
 * <pre>
 * &lt;code&gt;
 *  class YourFunction implements {@link SilkFunctionPlugin}
 *  {
 *      // Field value with this annotation is set from the user input before executing eval(..) method
 *      &#064;SilkFunctionArgument
 *      private String fileName = null; 
 * 
 *      public void eval(SilkEnv env) throws XerialException
 *      {
 *          // evaluate the function using the fileName field value...
 *      }
 *  }
 * &lt;/code&gt;
 * </pre>
 * 
 * @author leo
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD, ElementType.METHOD })
public @interface SilkFunctionArgument {

    static final String NO_VALUE = "";
    static final int UNORDERED = -1;

    /**
     * The key name of this function argument. If this value is not set, this
     * argument is taken from the unnamed user input.
     * 
     */
    String name() default NO_VALUE;

    /**
     * The ordinal of the argument. When the name value is specified, this
     * option will be ignored.
     * 
     */
    int ordinal() default UNORDERED;

    /**
     * Description of the function argument, used to generate a help message of
     * this function
     */
    String description() default "";

}

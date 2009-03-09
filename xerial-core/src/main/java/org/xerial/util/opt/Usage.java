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
// Usage.java
// Since: Oct 29, 2008 4:10:03 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describes the usage of a command attached as a class annotation
 * 
 * help-message template must have four variables: command, argumentList,
 * description and optionList, each of them is enclosed by $ mark. The following
 * is an example of help message template.
 * 
 * templatePath=org/xerial/util/opt/help-message.template
 * 
 * <pre>
 * 
 * usage: $COMMAND$ $ARGUMENT_LIST$
 *   $DESCRIPTION$
 * 
 * [options]
 * $OPTION_LIST$
 * </pre>
 * 
 * @author leo
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Usage {

    public static String DEFAULT_TEMPLATE = "org/xerial/util/opt/help-message.template";

    /**
     * command name
     */
    String command() default "";

    /**
     * description of the command
     */
    String description() default "";

    /**
     * path to the help message template
     */
    String templatePath() default DEFAULT_TEMPLATE;

}

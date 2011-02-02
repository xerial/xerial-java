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
// CUIOption.java
// Since: Oct 27, 2008 4:10:08 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.opt.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.xerial.core.XerialException;
import org.xerial.util.TypeInfo;
import org.xerial.util.opt.Option;
import org.xerial.util.opt.OptionParserException;

/**
 * OptionItem
 * 
 * @author leo
 * 
 */
public class OptionItem {
    private final Option optionDescriptor;
    private final OptionSetter optionSetter;

    public OptionItem(Method method) {
        Option option = method.getAnnotation(Option.class);
        if (option == null)
            throw new IllegalArgumentException(method + " is not an option item");

        this.optionDescriptor = option;
        this.optionSetter = new OptionSetterViaMethod(method);
    }

    public OptionItem(Field field) {
        Option option = field.getAnnotation(Option.class);
        if (option == null)
            throw new IllegalArgumentException(field + " is not an option item");

        this.optionDescriptor = option;
        this.optionSetter = new OptionSetterViaField(field);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OptionItem) {
            OptionItem other = (OptionItem) obj;
            return optionDescriptor.equals(other.optionDescriptor);
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return optionDescriptor.hashCode();
    }

    public boolean needsArgument() {
        return optionSetter.takesArgument();
    }

    public boolean hasSymbol() {
        return optionDescriptor.symbol() != null && optionDescriptor.symbol().length() > 0;
    }

    public boolean hasLongName() {
        return optionDescriptor.longName() != null && optionDescriptor.longName().length() > 0;
    }

    public Option getOption() {
        return optionDescriptor;
    }

    public boolean takesMultipleArguments() {
        return TypeInfo.isCollection(optionSetter.getOptionDataType());
    }

    public void setOption(Object bean, String value) throws XerialException {
        optionSetter.setOption(bean, value);

    }

    public void initialize(Object optionHolder) throws OptionParserException {
        optionSetter.initialize(optionHolder);
    }

    @Override
    public String toString() {
        return String.format("-%s, --%s :%s", optionDescriptor.symbol(), optionDescriptor
                .longName(), optionDescriptor.description());
    }
}

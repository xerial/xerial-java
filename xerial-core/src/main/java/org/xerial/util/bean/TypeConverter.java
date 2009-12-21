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
// TypeConverter.java
// Since: Oct 27, 2008 4:36:50 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;

/**
 * Data type converter
 * 
 * @author leo
 * 
 */
public class TypeConverter {
    // conversion to the Enum type is tested before the cast 
    @SuppressWarnings("unchecked")
    public static <T> T convertType(Class<T> targetType, Object value) throws XerialException {
        if (targetType.isAssignableFrom(value.getClass()) || targetType == Object.class)
            return (T) value;
        else
            return (T) convertToBasicType(targetType, value);
    }

    /**
     * Convert the input to the specified type
     * 
     * @param <T>
     * @param targetType
     * @param input
     * @return
     */
    public static <T extends Enum<T>> T convertToEnum(Class<T> targetType, Object input) {
        assert (targetType.isEnum());

        String value = input.toString();
        try {
            return Enum.valueOf(targetType, value);
        }
        catch (IllegalArgumentException e) {
            // try capitalized value
            return Enum.valueOf(targetType, value.toString().toUpperCase());
        }
    }

    /**
     * Convert the input to the basic type (int, double, String,... etc.)
     * 
     * @param targetType
     * @param input
     * @return
     * @throws XerialException
     */
    @SuppressWarnings("unchecked")
    public static Object convertToBasicType(Class< ? > targetType, Object input)
            throws XerialException {
        assert (TypeInfo.isBasicType(targetType));

        if (targetType.isEnum())
            return convertToEnum((Class<Enum>) targetType, input);

        try {
            String value = input.toString();

            if (targetType == String.class)
                return value;
            else if (targetType == int.class || targetType == Integer.class)
                return new Integer(value);
            else if (targetType == long.class || targetType == Long.class)
                return new Long(value);
            else if (targetType == double.class || targetType == Double.class)
                return new Double(value);
            else if (targetType == float.class || targetType == Float.class)
                return new Float(value);
            else if (targetType == short.class || targetType == Short.class)
                return new Short(value);
            else if (targetType == byte.class || targetType == Byte.class)
                return new Byte(value);
            else if (targetType == boolean.class || targetType == Boolean.class)
                return new Boolean(value);
            else if ((targetType == char.class || targetType == Character.class)
                    && value.length() == 1)
                return new Character(value.charAt(0));
            else if (targetType == Date.class) {
                return DateFormat.getDateTimeInstance().parse(value);
            }
            else if (targetType == File.class) {
                return new File(value);
            }
            throw new XerialException(XerialErrorCode.InvalidBeanClass, String.format(
                    "%s is not a basic type", targetType.getSimpleName()));
        }
        catch (NumberFormatException e) {
            throw new XerialException(XerialErrorCode.InvalidFormat, String.format("%s %s",
                    targetType.getName(), e.getMessage()));
        }
        catch (ParseException e) {
            throw new XerialException(XerialErrorCode.InvalidDateFormat, e);
        }
    }
}

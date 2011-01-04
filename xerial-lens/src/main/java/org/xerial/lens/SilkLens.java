/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// SilkLens.java
// Since: 2010/11/18 14:22:18
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import org.xerial.core.ErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkParser;
import org.xerial.silk.SilkUtil;
import org.xerial.silk.SilkWriter;
import org.xerial.util.ObjectHandler;
import org.xerial.util.TypeInfo;

/**
 * Utilities for mapping between Silk and Object
 * 
 * @author leo
 * 
 */
public class SilkLens
{

    public static String toSilk(Object obj) {
        return SilkUtil.toSilk(obj);
    }

    public static String toSilk(String nodeName, Object obj) {
        StringWriter buf = new StringWriter();
        SilkWriter writer = new SilkWriter(buf);
        writer.leafObject(nodeName, obj);
        writer.flush();
        return buf.toString();
    }

    /**
     * Translate the specified Silk file into an instance of the target object.
     * 
     * @param <Result>
     * @param silkFileResource
     *            resource path to the input Silk file
     * @param targetClass
     *            target class to which the input Silk format will be converted
     * 
     * @return translated object of the targetClass type
     * @throws IOException
     *             when failed to read resources
     * @throws XerialException
     *             when failed to parse the input Silk file
     */
    public static <Result> Result loadSilk(Class<Result> targetType, URL silkResource) throws IOException,
            XerialException {
        return loadSilk(TypeInfo.createInstance(targetType), silkResource);
    }

    public static <Result> Result loadSilk(Result target, String silk) throws IOException, XerialException {
        return loadSilk(target, new StringReader(silk));
    }

    public static <Result> Result loadSilk(Result result, URL silkResource) throws IOException, XerialException {
        if (silkResource == null)
            throw new NullPointerException("silk resouce is null");

        return loadSilk(result, new SilkParser(silkResource));
    }

    public static <Result> Result loadSilk(Result result, Reader silkReader) throws XerialException, IOException {
        return loadSilk(result, new SilkParser(silkReader));
    }

    public static <Result> Result loadSilk(Result result, SilkParser silkReader) throws XerialException, IOException {
        try {
            return Lens.load(result, silkReader);
        }
        catch (XerialException e) {
            ErrorCode code = e.getErrorCode();
            throw new XerialException(code, String.format("error when reading line %d: %s",
                    silkReader.getNumReadLine(), e.getMessage()));
        }
    }

    public static <Result> Result loadSilk(Class<Result> resultType, Reader silkReader) throws XerialException,
            IOException {
        return loadSilk(TypeInfo.createInstance(resultType), silkReader);
    }

    /**
     * Find the target nodes of the specified type from the input Silk data. The
     * given object handler will be used to report the found target objects.
     * 
     * @param <Result>
     * @param silkResource
     * @param targetNodeName
     * @param targetType
     * @param handler
     * @throws IOException
     * @throws XerialException
     */
    public static <Result> void findFromSilk(URL silkResource, String targetNodeName, Class<Result> targetType,
            ObjectHandler<Result> handler) throws IOException, XerialException {
        Lens.find(targetType, targetNodeName, handler, new SilkParser(silkResource));
    }

    public static <Result> void findFromSilk(Reader input, String targetNodeName, Class<Result> targetType,
            ObjectHandler<Result> handler) throws XerialException, IOException {
        Lens.find(targetType, targetNodeName, handler, new SilkParser(input));
    }

}

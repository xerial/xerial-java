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
// JSONLens.java
// Since: 2010/11/18 14:24:58
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.xerial.core.XerialException;
import org.xerial.lens.Lens;
import org.xerial.util.ObjectHandler;
import org.xerial.util.bean.TypeInfo;

/**
 * Utilities for mapping JSON and objects
 * 
 * @author leo
 * 
 */
public class JSONLens {

    public static String toJSON(Object obj) {
        return JSONUtil.toJSON(obj);
    }

    public static <Result> void findFromJSON(Reader input, String targetNodeName,
            Class<Result> targetType, ObjectHandler<Result> handler) throws XerialException,
            IOException {
        Lens.find(targetType, targetNodeName, handler, new JSONTreeParser(input));
    }

    public static <Result> void loadJSON(Class<Result> targetType, Reader jsonReader,
            ObjectHandler<Result> handler) throws XerialException, IOException {
        Lens.find(targetType, handler, new JSONTreeParser(jsonReader));
    }

    public static <Result> Result loadJSON(Class<Result> targetType, String json)
            throws XerialException, IOException {
        return loadJSON(targetType, new StringReader(json));
    }

    public static <Result> Result loadJSON(Class<Result> targetType, Reader jsonReader)
            throws XerialException, IOException {
        return loadJSON(TypeInfo.createInstance(targetType), jsonReader);
    }

    public static <Result> Result loadJSON(Result result, Reader jsonReader)
            throws XerialException, IOException {
        return Lens.load(result, new JSONTreeParser(jsonReader));
    }

    public static <Result> Result loadJSON(Result result, String json) throws XerialException,
            IOException {
        return Lens.load(result, new JSONTreeParser(new StringReader(json)));
    }

}

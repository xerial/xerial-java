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
// JDBCLens.java
// Since: Dec 21, 2009 3:45:09 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xerial.core.XerialException;
import org.xerial.lens.impl.ParameterSetter;
import org.xerial.util.bean.BeanHandler;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.log.Logger;

/**
 * Lens for JDBC ResultSet
 * 
 * @author leo
 * 
 */
public class JDBCLens<E> {

    private static Logger _logger = Logger.getLogger(JDBCLens.class);

    private final ObjectLens lens;
    private final Class<E> targetType;
    private final HashMap<String, Binder> paramName_binder = new HashMap<String, Binder>();

    private static class Binder {
        private ParameterSetter setter;

        public Binder(ParameterSetter setter) {
            this.setter = setter;
        }

        public void bind(Object obj, Object value) throws XerialException, SQLException {

            Class< ? > targetType = setter.getParameterType();
            Class< ? > valueType = value.getClass();
            if (targetType != valueType) {
                if (!TypeInfo.isArray(targetType) && TypeInfo.isBasicType(targetType)) {
                    setter.bind(obj, TypeConverter.convertToBasicType(targetType, value));
                    return;
                }
            }

            setter.bind(obj, value);
        }

    }

    public JDBCLens(Class<E> targetType) {
        this.targetType = targetType;

        // prepare object parameter setters
        lens = ObjectLens.getObjectLens(targetType);
        for (ParameterSetter each : lens.getSetterList()) {
            if (!TypeInfo.isBasicType(each.getParameterType()))
                continue;

            paramName_binder.put(each.getParameterName(), new Binder(each));
        }

    }

    class BeanContainer implements BeanHandler<E> {
        List<E> result = new ArrayList<E>();

        public void handle(E bean) throws Exception {
            result.add(bean);
        }

        public void handleException(Exception e) {
            _logger.error(e);
        }
    }

    public List<E> mapAll(ResultSet rs) throws Exception {
        BeanContainer c = new BeanContainer();
        mapAll(rs, c);
        return c.result;
    }

    public void mapAll(ResultSet rs, BeanHandler<E> handler) throws Exception {

        ResultSetMetaData m = rs.getMetaData();
        int colSize = m.getColumnCount();

        String[] columnName = new String[colSize];
        for (int i = 0; i < m.getColumnCount(); ++i) {
            columnName[i] = m.getColumnName(i + 1);
        }

        while (rs.next()) {

            E obj = TypeInfo.createInstance(targetType);

            for (int i = 0; i < colSize; i++) {
                Binder b = paramName_binder.get(columnName[i]);
                if (b == null) {
                    // try generic putter
                    lens.setProperty(obj, columnName[i], rs.getObject(i + 1));
                    continue;
                }

                b.bind(obj, rs.getObject(i + 1));
            }

            try {
                handler.handle(obj);
            }
            catch (Exception e) {
                handler.handleException(e);
            }
        }

    }

}

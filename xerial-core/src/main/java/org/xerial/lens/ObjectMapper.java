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
// ObjectMapper.java
// Since: May 19, 2009 1:29:23 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.impl.MapEntry;
import org.xerial.lens.impl.ParameterSetter;
import org.xerial.lens.impl.RelationSetter;
import org.xerial.lens.impl.ParameterSetter.MapEntryBinder;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.query.AmoebaJoinHandler;
import org.xerial.lens.relation.query.AmoebaJoinHandlerBase;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.lens.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInfo;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeParser;

/**
 * Object-Tree mapping processor
 * 
 * @author leo
 * 
 */
public class ObjectMapper {
    private static Logger _logger = Logger.getLogger(ObjectMapper.class);

    //-------------------------------------
    // dynamic parameters required for mapping tree-structured data to an object
    // id -> corresponding object instance
    //-------------------------------------
    private HashMap<Long, Object> objectHolder = new HashMap<Long, Object>();
    private Deque<Object> contextNodeStack = new ArrayDeque<Object>();

    private static QuerySet qs = null;
    // schema -> binder 
    private static HashMap<Schema, Binder> schema2binder = new HashMap<Schema, Binder>();

    /**
     * interface for invoking setters or field setters of the object
     * 
     * @author leo
     * 
     */
    private static interface Binder {
        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException;

        public void bindText(Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException;

    }

    /**
     * Binds a node pair to the context node object. e.g. addA_B(A a, B b)
     * 
     * @author leo
     * 
     */
    private class RelationBinder implements Binder {
        final ObjectLens lens;
        final RelationSetter setter;

        public RelationBinder(ObjectLens lens, RelationSetter setter) {
            this.lens = lens;
            this.setter = setter;
        }

        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException {
            Object coreNodeInstance = getNodeInstance(coreNode, setter.getCoreNodeType());
            Object attributeNodeInstance = getNodeInstance(attributeNode, setter
                    .getAttributeNodeType());

            Object contextNode = findContextNode(lens.getTargetType());
            if (contextNode == null)
                throw new XerialException(XerialErrorCode.INVALID_INPUT, "no context node for "
                        + setter);

            if (attributeNodeInstance != null) {
                setter.bind(contextNode, coreNodeInstance, attributeNodeInstance);
            }
        }

        public Object findContextNode(Class< ? > targetType) {
            for (Iterator<Object> it = contextNodeStack.descendingIterator(); it.hasNext();) {
                Object node = it.next();
                if (targetType.equals(node.getClass())) {
                    return node;
                }
            }
            return null;
        }

        public void bindText(Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {
            throw new XerialError(XerialErrorCode.UNSUPPORTED);
        }
    }

    /**
     * 
     * Bind an attribute object to the context node (core node)
     * 
     * @author leo
     * 
     */
    private class AttributeBinder implements Binder {
        final ParameterSetter setter;
        final Class< ? > coreNodeType;
        final Class< ? > attributeNodeType;

        public AttributeBinder(Class< ? > coreNodeType, ParameterSetter setter) {
            this.setter = setter;
            this.coreNodeType = coreNodeType;
            this.attributeNodeType = setter.getParameterType();

        }

        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException {
            Object coreNodeInstance = getNodeInstance(coreNode, coreNodeType);
            Object attributeNodeInstance = getNodeInstance(attributeNode, attributeNodeType);

            if (attributeNodeInstance != null)
                setter.bind(coreNodeInstance, attributeNodeInstance);
        }

        public void bindText(Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {
            Object coreNodeInstance = getNodeInstance(coreNode, coreNodeType);
            Object textNodeInstance = getNodeInstance(textNode, attributeNodeType);

            if (textValue != null && !TypeInfo.isBasicType(attributeNodeType))
                setTextValue(textNodeInstance, attributeNodeType, textValue);
            else
                setter.bind(coreNodeInstance, textValue);
        }
    }

    private QuerySet buildQuery(Class< ? > targetType) {
        QueryBuilder qb = new QueryBuilder();
        qb.build(targetType, "root");
        return qb.qsBuilder.build();
    }

    private class QueryBuilder {
        QuerySetBuilder qsBuilder = new QuerySetBuilder();
        private HashMap<String, Set<Class< ? >>> processedClassTable = new HashMap<String, Set<Class< ? >>>();

        //Set<Class< ? >> processedClasses = new HashSet<Class< ? >>();

        public QueryBuilder() {

        }

        public void build(Class< ? > targetType, String alias) {
            // TODO use context-based schema -> binder mapping

            if (TypeInfo.isBasicType(targetType) || targetType == MapEntry.class)
                return;

            Set<Class< ? >> processed = processedClassTable.get(alias);
            if (processed == null) {
                processed = new HashSet<Class< ? >>();
                processedClassTable.put(alias, processed);
            }

            if (processed.contains(targetType))
                return;
            else
                processed.add(targetType);

            //            if (processedClasses.contains(targetType))
            //                return;
            //
            //            processedClasses.add(targetType);

            ObjectLens lens = ObjectLens.getObjectLens(targetType);
            if (_logger.isTraceEnabled())
                _logger.trace(String.format("class %s: %s\n", targetType.getSimpleName(), lens));

            for (ParameterSetter each : lens.getSetterList()) {
                if (each.getClass() == MapEntryBinder.class) {
                    SchemaBuilder builder = new SchemaBuilder();
                    builder.add("entry");
                    builder.add(each.getParameterName());
                    Schema s = builder.build();
                    qsBuilder.addQueryTarget(s);
                    schema2binder.put(s, new AttributeBinder(MapEntry.class, each));
                    continue;
                }

                build(each.getParameterType(), each.getParameterName());

                SchemaBuilder builder = new SchemaBuilder();
                builder.add(alias);
                builder.add(each.getParameterName());

                Schema s = builder.build();
                qsBuilder.addQueryTarget(s);

                schema2binder.put(s, new AttributeBinder(lens.getTargetType(), each));
            }

            for (RelationSetter each : lens.getRelationSetterList()) {
                build(each.getCoreNodeType(), each.getCoreNodeName());
                build(each.getAttributeNodeType(), each.getAttributeNodeName());

                Schema s = new SchemaBuilder().add(each.getCoreNodeName()).add(
                        each.getAttributeNodeName()).build();
                qsBuilder.addQueryTarget(s);

                schema2binder.put(s, new RelationBinder(lens, each));

            }

        }

    }

    public <T> ObjectMapper(Class<T> targetType) throws XerialException {
        if (qs == null) {
            schema2binder.clear();
            qs = buildQuery(targetType);
        }
    }

    public static ObjectMapper getMapper(Class< ? > targetType) throws XerialException {
        return new ObjectMapper(targetType);
    }

    public <T> T map(Class<T> targetType, TreeParser parser) throws XerialException {

        T object = TypeInfo.createInstance(targetType);
        return map(object, parser);
    }

    public <T> T map(T object, TreeParser parser) throws XerialException {
        try {
            if (object == null)
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "null object");

            if (_logger.isTraceEnabled())
                _logger.trace("query set: " + qs);

            // set the root object
            objectHolder.put(0L, object);
            contextNodeStack.addLast(object);

            AmoebaJoinHandler mapper = new RelationExtracter();

            StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, mapper);
            aj.sweep(parser);
            return object;
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.INHERITED, e);
        }

    }

    public <T> void find(Class<T> targetType, TreeParser parser,
            String coreNodeNameOfTheTargetType, ObjectHandler<T> handler) throws XerialException {

        try {
            AmoebaJoinHandler mapper = new RelationExtracter();

            _logger.info(qs);

            StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, mapper);
            aj.sweep(parser);
        }
        catch (IOException e) {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }
        catch (Exception e) {
            throw new XerialException(XerialErrorCode.INHERITED, e);
        }

    }

    private Object getNodeInstance(Node node, Class< ? > nodeType) throws XerialException {
        Object instance = objectHolder.get(node.nodeID);
        if (instance != null)
            return instance;

        if (TypeInfo.isBasicType(nodeType)) {
            if (node.nodeValue == null)
                return null;
            else
                instance = TypeConverter.convertToBasicType(nodeType, node.nodeValue);
        }
        else {
            instance = TypeInfo.createInstance(nodeType);

            if (node.nodeValue != null) {
                setTextValue(instance, nodeType, node.nodeValue);
            }

        }
        objectHolder.put(node.nodeID, instance);
        return instance;
    }

    private void setTextValue(Object instance, Class< ? > textNodeType, String textValue)
            throws XerialException {
        // bind the node value to the instance
        ObjectLens lens = ObjectLens.getObjectLens(textNodeType);
        ParameterSetter valueSetter = lens.getValueSetter();
        if (valueSetter != null)
            valueSetter.bind(instance, TypeConverter.convertToBasicType(valueSetter
                    .getParameterType(), textValue));

    }

    private Object getTextNodeInstance(String nodeName, String nodeValue, Class< ? > nodeType)
            throws XerialException {
        Object instance = null;

        if (TypeInfo.isBasicType(nodeType)) {
            if (nodeValue == null)
                return null;
            else
                instance = TypeConverter.convertToBasicType(nodeType, nodeValue);
        }
        else {
            instance = TypeInfo.createInstance(nodeType);

            if (nodeValue != null) {
                // bind the node value to the instance
                ObjectLens lens = ObjectLens.getObjectLens(nodeType);
                ParameterSetter valueSetter = lens.getValueSetter();
                if (valueSetter != null)
                    valueSetter.bind(instance, TypeConverter.convertToBasicType(valueSetter
                            .getParameterType(), nodeValue));
            }

        }

        return instance;
    }

    /**
     * Tree -> Relation -> Object binding process body
     * 
     * @author leo
     * 
     */
    private class RelationExtracter extends AmoebaJoinHandlerBase {

        public void leaveNode(Schema schema, Node node) throws Exception {
            if (schema == null && node.nodeValue != null) {
                // if putter is defined, set (node.nodeName, node.nodeValue) as (key, value)
                if (_logger.isTraceEnabled())
                    _logger.trace("put: " + node);

                Object contextNode = contextNodeStack.getLast();
                ObjectLens lens = ObjectLens.getObjectLens(contextNode.getClass());
                lens.setProperty(contextNode, node.nodeName, node.nodeValue);
            }

            Object obj = objectHolder.remove(node.nodeID);

            if (_logger.isTraceEnabled())
                _logger.trace(String.format("leave: %s in %s. object = %s", node, schema, obj));

        }

        public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception {
            if (_logger.isTraceEnabled())
                _logger.trace(String.format("amoeba: (%s, %s) in %s", coreNode, attributeNode,
                        schema));

            Binder binder = schema2binder.get(schema);
            if (binder == null)
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no binder for schema "
                        + schema);

            try {
                binder.bind(schema, coreNode, attributeNode);
            }
            catch (XerialException e) {
                _logger.warn(String.format(
                        "failed to bind: core node=%s, attribute node=%s, schema=%s\n%s", coreNode,
                        attributeNode, schema, e));
            }

        }

        public void text(Schema schema, Node coreNode, Node textNode, String textFragment)
                throws Exception {
            if (_logger.isTraceEnabled())
                _logger.trace(String.format("text:   (%s, %s:%s) in %s", coreNode, textNode,
                        textFragment, schema));

            Binder binder = schema2binder.get(schema);
            if (binder == null)
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no binder for schema "
                        + schema);

            try {
                binder.bindText(schema, coreNode, textNode, textFragment);
            }
            catch (XerialException e) {
                _logger.warn(String.format(
                        "failed to bind text: core node=%s, attributeName=%s, text=%s\n%s",
                        coreNode, textNode, textFragment, e));
            }
        }

    }

}

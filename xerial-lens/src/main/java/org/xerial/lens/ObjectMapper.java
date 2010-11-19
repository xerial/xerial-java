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
import org.xerial.lens.relation.FD;
import org.xerial.lens.relation.Node;
import org.xerial.lens.relation.query.AmoebaJoinHandler;
import org.xerial.lens.relation.query.AmoebaJoinHandlerBase;
import org.xerial.lens.relation.query.QuerySet;
import org.xerial.lens.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.lens.relation.query.StreamAmoebaJoin;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.lens.relation.schema.SchemaBuilder;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.ObjectHandler;
import org.xerial.util.TypeConverter;
import org.xerial.util.TypeInfo;
import org.xerial.util.lens.ObjectLens;
import org.xerial.util.lens.impl.MapEntry;
import org.xerial.util.lens.impl.ParameterSetter;
import org.xerial.util.lens.impl.ParameterSetter.MapEntryBinder;
import org.xerial.util.lens.impl.RelationSetter;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeParser;

/**
 * Object-Tree mapping processor
 * 
 * @author leo
 * 
 */
public class ObjectMapper
{
    private static Logger                            _logger        = Logger.getLogger(ObjectMapper.class);

    // schema -> binder 
    private final HashMap<Schema, Binder>            schema2binder  = new HashMap<Schema, Binder>();

    final QuerySet                                   qs;
    //final ObjectHandler<?> handler;

    private static HashMap<Class< ? >, ObjectMapper> prebuiltMapper = new HashMap<Class< ? >, ObjectMapper>();

    public <T> ObjectMapper(Class<T> targetType) throws XerialException {
        qs = buildQuery(targetType);
    }

    public <T> ObjectMapper(Class<T> targetType, String targetNodeName) throws XerialException {
        qs = buildFindQuery(targetType, targetNodeName);
    }

    public static ObjectMapper getMapper(Class< ? > targetType) throws XerialException {
        if (prebuiltMapper.containsKey(targetType))
            return prebuiltMapper.get(targetType);
        else {
            ObjectMapper newInstance = new ObjectMapper(targetType);
            prebuiltMapper.put(targetType, newInstance);
            return newInstance;
        }
    }

    public <T> T map(Class<T> targetType, TreeParser parser) throws XerialException {

        T object = TypeInfo.createInstance(targetType);
        return map(object, parser);
    }

    public <T> T map(T object, TreeParser parser) throws XerialException {
        MappingProcess mp = new MappingProcess();
        return mp.execute(qs, object, parser);
    }

    public <T> void find(ObjectHandler<T> handler, String targetNodeName, TreeParser parser) throws XerialException {
        MappingProcess mp = new MappingProcess();
        mp.handler = handler;
        mp.execute(qs, "root", parser); // "root" is a dummy object
    }

    private QuerySet buildQuery(Class< ? > targetType) {
        QueryBuilder qb = new QueryBuilder();
        qb.build(targetType, "root");
        return qb.queryBuilder.build();
    }

    private <T> QuerySet buildFindQuery(Class< ? > targetType, String targetNodeName) {
        QueryBuilder qb = new QueryBuilder();
        qb.buildFindQuery(targetType, targetNodeName);
        return qb.queryBuilder.build();
    }

    /**
     * Build query components (schemas of two nodes) from the object lens
     * 
     * @author leo
     * 
     */
    private class QueryBuilder
    {
        QuerySetBuilder                                queryBuilder            = new QuerySetBuilder();
        Schema                                         rootAndTargetNodeSchema = null;
        private final HashMap<String, Set<Class< ? >>> processedClassTable     = new HashMap<String, Set<Class< ? >>>();

        //Set<Class< ? >> processedClasses = new HashSet<Class< ? >>();

        public QueryBuilder() {

        }

        public <T> void buildFindQuery(Class< ? > targetType, String targetNodeName) {
            SchemaBuilder b = new SchemaBuilder();
            b.add("root");
            b.add(targetNodeName, FD.ZERO_OR_MORE);
            rootAndTargetNodeSchema = b.build();
            queryBuilder.addQueryTarget(rootAndTargetNodeSchema);
            build(targetType, targetNodeName);
            schema2binder.put(rootAndTargetNodeSchema, new TargetNodeReporter<T>(targetType));
        }

        public void build(Class< ? > targetType, String alias) {
            // TODO context-based schema should be used. 
            // e.g. (book, name) and (person, name) share the same 'name' node

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

            ObjectLens lens = ObjectLens.getObjectLens(targetType);
            if (_logger.isTraceEnabled())
                _logger.trace(String.format("class %s: %s\n", targetType.getSimpleName(), lens));

            for (ParameterSetter each : lens.getSetterList()) {
                if (each.getClass() == MapEntryBinder.class) {
                    SchemaBuilder builder = new SchemaBuilder();
                    builder.add("entry");
                    builder.add(each.getCanonicalParameterName());
                    Schema s = builder.build();
                    queryBuilder.addQueryTarget(s);
                    schema2binder.put(s, new AttributeBinder(MapEntry.class, each));
                    continue;
                }

                if (TypeInfo.isMap(each.getParameterType())) {
                    // (param, *)
                    SchemaBuilder builder = new SchemaBuilder();
                    builder.add(each.getCanonicalParameterName());
                    builder.add("*");
                    Schema s = builder.build();
                    queryBuilder.addQueryTarget(s);
                    schema2binder.put(s, new PropertyBinder(ObjectLens.getObjectLens(each.getParameterType())));

                    // (alias, param)
                    Schema s2 = new SchemaBuilder().add(alias).add(each.getCanonicalParameterName()).build();
                    queryBuilder.addQueryTarget(s2);
                    schema2binder.put(s2, new AttributeBinder(lens.getTargetType(), each));

                    continue;
                }

                build(each.getParameterType(), each.getCanonicalParameterName());

                SchemaBuilder builder = new SchemaBuilder();
                builder.add(alias);
                builder.add(each.getCanonicalParameterName());

                Schema s = builder.build();
                queryBuilder.addQueryTarget(s);

                schema2binder.put(s, new AttributeBinder(lens.getTargetType(), each));
            }

            for (RelationSetter each : lens.getRelationSetterList()) {

                build(each.getCoreNodeType(), each.getCoreNodeName());
                build(each.getAttributeNodeType(), each.getAttributeNodeName());

                Schema s = new SchemaBuilder().add(each.getCoreNodeName()).add(each.getAttributeNodeName()).build();
                queryBuilder.addQueryTarget(s);

                schema2binder.put(s, new RelationBinder(lens, each));

            }

            if (lens.hasPropertySetter()) {
                // binding rule for the property setter
                SchemaBuilder builder = new SchemaBuilder();
                builder.add(alias);
                builder.add("*");

                // (alias, *) 
                Schema s = builder.build();
                queryBuilder.addQueryTarget(s);
                schema2binder.put(s, new PropertyBinder(lens));
            }
        }
    }

    /**
     * interface for invoking setters or field setters of the object
     * 
     * @author leo
     * 
     */
    private static interface Binder
    {
        public void bind(MappingProcess proc, Schema schema, Node coreNode, Node attributeNode) throws XerialException;

        public void bindText(MappingProcess proc, Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException;

    }

    private static class TargetNodeReporter<T> implements Binder
    {

        private final Class<T> targetNodeType;

        @SuppressWarnings("unchecked")
        public TargetNodeReporter(Class< ? > targetNodeType) {
            this.targetNodeType = (Class<T>) targetNodeType;
        }

        @SuppressWarnings("unchecked")
        public void bind(MappingProcess proc, Schema schema, Node rootNode, Node targetNode) throws XerialException {

            Object targetNodeInstance = proc.getNodeInstance(targetNode, targetNodeType);
            try {
                ((ObjectHandler<T>) proc.getObjectHandler()).handle(targetNodeType.cast(targetNodeInstance));
            }
            catch (Exception e) {
                throw XerialException.convert(e);
            }
        }

        public void bindText(MappingProcess proc, Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {

            // ignore the text event
        }

    }

    /**
     * Binds a node pair to the context node object. e.g. addA_B(A a, B b)
     * 
     * @author leo
     * 
     */
    private static class RelationBinder implements Binder
    {
        private final ObjectLens     lens;
        private final RelationSetter setter;

        public RelationBinder(ObjectLens lens, RelationSetter setter) {
            this.lens = lens;
            this.setter = setter;
        }

        public void bind(MappingProcess proc, Schema schema, Node coreNode, Node attributeNode) throws XerialException {
            Object coreNodeInstance = proc.getNodeInstance(coreNode, setter.getCoreNodeType());
            Object attributeNodeInstance = proc.getNodeInstance(attributeNode, setter.getAttributeNodeType());

            Object contextNode = findContextNode(proc, lens.getTargetType());
            if (contextNode == null)
                throw new XerialException(XerialErrorCode.INVALID_INPUT, "no context node for " + setter);

            if (attributeNodeInstance != null) {
                setter.bind(contextNode, coreNodeInstance, attributeNodeInstance);
            }
        }

        public Object findContextNode(MappingProcess proc, Class< ? > targetType) {
            for (Iterator<Object> it = proc.contextNodeStack.descendingIterator(); it.hasNext();) {
                Object node = it.next();
                if (targetType.equals(node.getClass())) {
                    return node;
                }
            }
            return null;
        }

        public void bindText(MappingProcess proc, Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {
            throw new XerialError(XerialErrorCode.UNSUPPORTED);
        }
    }

    private static class PropertyBinder implements Binder
    {

        private final ObjectLens lens;

        public PropertyBinder(ObjectLens lens) {
            this.lens = lens;
        }

        public void bind(MappingProcess proc, Schema schema, Node coreNode, Node attributeNode) throws XerialException {

            Object coreNodeInstance = proc.getNodeInstance(coreNode, lens.getTargetType());
            if (attributeNode.nodeValue != null)
                lens.setProperty(coreNodeInstance, attributeNode.nodeName, attributeNode.nodeValue);
        }

        public void bindText(MappingProcess proc, Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {

            Object coreNodeInstance = proc.getNodeInstance(coreNode, lens.getTargetType());
            Object prevValue = lens.getProperty(coreNodeInstance, textNode.nodeName);
            String value = (prevValue == null) ? textValue : prevValue.toString() + textValue;
            lens.setProperty(coreNodeInstance, textNode.nodeName, value);

        }

    }

    /**
     * 
     * Bind an attribute object to the context node (core node)
     * 
     * @author leo
     * 
     */
    private class AttributeBinder implements Binder
    {
        final ParameterSetter setter;
        final Class< ? >      coreNodeType;
        final Class< ? >      attributeNodeType;

        public AttributeBinder(Class< ? > coreNodeType, ParameterSetter setter) {
            this.setter = setter;
            this.coreNodeType = coreNodeType;
            this.attributeNodeType = setter.getParameterType();

        }

        public void bind(MappingProcess proc, Schema schema, Node coreNode, Node attributeNode) throws XerialException {
            Object coreNodeInstance = proc.getNodeInstance(coreNode, coreNodeType);
            Object attributeNodeInstance = proc.getNodeInstance(attributeNode, attributeNodeType);

            if (attributeNodeInstance != null)
                setter.bind(coreNodeInstance, attributeNodeInstance);
        }

        public void bindText(MappingProcess proc, Schema schema, Node coreNode, Node textNode, String textValue)
                throws XerialException {
            Object coreNodeInstance = proc.getNodeInstance(coreNode, coreNodeType);
            Object textNodeInstance = proc.getNodeInstance(textNode, attributeNodeType);

            if (textValue != null && !TypeInfo.isBasicType(attributeNodeType))
                proc.setTextValue(textNodeInstance, attributeNodeType, textValue);
            else
                setter.bind(coreNodeInstance, textValue);
        }
    }

    /**
     * MappingProcess performs mapping from tree event stream to objects.
     * 
     * 
     * @author leo
     * 
     */
    private class MappingProcess
    {
        // id -> corresponding object instance
        HashMap<Long, Object> objectHolder     = new HashMap<Long, Object>();
        Deque<Object>         contextNodeStack = new ArrayDeque<Object>();
        ObjectHandler< ? >    handler          = null;

        ObjectHandler< ? > getObjectHandler() {
            return handler;
        }

        Object getNodeInstance(Node node, Class< ? > nodeType) throws XerialException {
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

        public <T> T execute(QuerySet qs, T object, TreeParser parser) throws XerialException {

            if (object == null)
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "null object");

            if (_logger.isTraceEnabled())
                _logger.trace("query set: " + qs);

            // set the root object
            objectHolder.put(0L, object);
            contextNodeStack.addLast(object);

            try {
                AmoebaJoinHandler mapper = new RelationExtracter();

                StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, mapper);
                aj.sweep(parser);
                return object;
            }
            catch (IOException e) {
                throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
            }
            catch (Exception e) {
                throw XerialException.convert(e);
            }

        }

        void setTextValue(Object instance, Class< ? > textNodeType, String textValue) throws XerialException {
            // bind the node value to the instance
            ObjectLens lens = ObjectLens.getObjectLens(textNodeType);
            ParameterSetter valueSetter = lens.getValueSetter();
            if (valueSetter != null)
                valueSetter.bind(instance, TypeConverter.convertToBasicType(valueSetter.getParameterType(), textValue));

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
                        valueSetter.bind(instance,
                                TypeConverter.convertToBasicType(valueSetter.getParameterType(), nodeValue));
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
        private class RelationExtracter extends AmoebaJoinHandlerBase
        {

            @Override
            public void leaveNode(Schema schema, Node node) throws Exception {
                if (schema == null && node.nodeValue != null) {
                    // if putter is defined, set (node.nodeName, node.nodeValue) as (key, value)
                    if (_logger.isTraceEnabled())
                        _logger.trace("put: " + node);

                    Object contextNode = contextNodeStack.getLast();
                    ObjectLens lens = ObjectLens.getObjectLens(contextNode.getClass());
                    lens.setProperty(contextNode, node.getCanonicalNodeName(), node.nodeValue);
                }

                Object obj = objectHolder.remove(node.nodeID);

                if (_logger.isTraceEnabled())
                    _logger.trace(String.format("leave: %s in %s. object = %s", node, schema, obj));

            }

            @Override
            public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception {
                if (_logger.isTraceEnabled())
                    _logger.trace(String.format("amoeba: (%s, %s) in %s", coreNode, attributeNode, schema));

                Binder binder = schema2binder.get(schema);
                if (binder == null)
                    throw new XerialError(XerialErrorCode.INVALID_STATE, "no binder for schema " + schema);

                try {
                    binder.bind(MappingProcess.this, schema, coreNode, attributeNode);
                }
                catch (XerialException e) {
                    _logger.warn(String.format("failed to bind: core node=%s, attribute node=%s, schema=%s\n%s",
                            coreNode, attributeNode, schema, e));
                }

            }

            @Override
            public void text(Schema schema, Node coreNode, Node textNode, String textFragment) throws Exception {
                if (_logger.isTraceEnabled())
                    _logger.trace(String.format("text:   (%s, %s:%s) in %s", coreNode, textNode, textFragment, schema));

                Binder binder = schema2binder.get(schema);
                if (binder == null)
                    throw new XerialError(XerialErrorCode.INVALID_STATE, "no binder for schema " + schema);

                try {
                    binder.bindText(MappingProcess.this, schema, coreNode, textNode, textFragment);
                }
                catch (XerialException e) {
                    _logger.warn(String.format("failed to bind text: core node=%s, attributeName=%s, text=%s\n%s",
                            coreNode, textNode, textFragment, e));
                }
            }

        }

    }

}

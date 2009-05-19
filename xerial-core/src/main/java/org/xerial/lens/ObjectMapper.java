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
import java.util.Set;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.relation.Node;
import org.xerial.relation.query.AmoebaJoinHandler;
import org.xerial.relation.query.QuerySet;
import org.xerial.relation.query.StreamAmoebaJoin;
import org.xerial.relation.query.QuerySet.QuerySetBuilder;
import org.xerial.relation.schema.Schema;
import org.xerial.relation.schema.SchemaBuilder;
import org.xerial.util.Deque;
import org.xerial.util.HashedDeque;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeWalker;

/**
 * Object-Tree mapping processor
 * 
 * @author leo
 * 
 */
public class ObjectMapper
{
    private static Logger _logger = Logger.getLogger(ObjectMapper.class);
    private HashMap<Long, Object> objectHolder = new HashMap<Long, Object>();

    private HashMap<Schema, Class< ? >> schema2type = new HashMap<Schema, Class< ? >>();
    private HashMap<Schema, ObjectLens> schema2lens = new HashMap<Schema, ObjectLens>();
    private HashMap<Schema, Binder> schema2binder = new HashMap<Schema, Binder>();
    private HashSet<Schema> relationSchema = new HashSet<Schema>();

    private HashedDeque<Schema, Object> contextNodeStack = new HashedDeque<Schema, Object>();

    private static interface Binder
    {
        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException;

    }

    private class RelationBinder implements Binder
    {
        RelationSetter setter;

        public RelationBinder(Schema schema)
        {

        }

        public RelationBinder(String coreNodeName, String attributeNodeName, ObjectLens lens)
        {
            for (RelationSetter each : lens.getRelationSetterList())
            {
                if (coreNodeName.equals(each.getCoreNodeName())
                        && attributeNodeName.equals(each.getAttributeNodeName()))
                {
                    this.setter = each;
                    break;
                }

            }
        }

        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException
        {
            Object coreNodeInstance = getNodeInstance(coreNode, schema);
            Object attributeNodeInstance = getNodeInstance(attributeNode, schema);

            ObjectLens lens = schema2lens.get(schema);
            lens.getTargetType()
            
            Deque<Object> stack = contextNodeStack.get(schema);
            if (stack.isEmpty())
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no context node for the relation " + schema);
            Object contextNode = stack.getLast();

            setter.bind(contextNode, coreNodeInstance, attributeNodeInstance);
        }
    }

    private class AttributeBinder implements Binder
    {
        public AttributeBinder(Schema schema, String attributeName)
        {

        }

        public void bind(Schema schema, Node coreNode, Node attributeNode) throws XerialException
        {

        }
    }

    public ObjectMapper()
    {

    }

    public <T> T map(Class<T> targetType, TreeWalker walker) throws XerialException
    {
        T object = TypeInformation.createInstance(targetType);
        return map(object, walker);
    }

    public <T> T map(T object, TreeWalker walker) throws XerialException
    {
        try
        {
            if (object == null)
                throw new XerialError(XerialErrorCode.INVALID_INPUT, "null object");

            QuerySet qs = buildQuery(object.getClass());

            if (_logger.isDebugEnabled())
                _logger.debug("query set: " + qs);

            // set the root object
            objectHolder.put(0L, object);

            StreamAmoebaJoin aj = new StreamAmoebaJoin(qs, new RelationExtracter());
            aj.sweep(walker);
            return object;
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

    }

    private QuerySet buildQuery(Class< ? > targetType)
    {
        QueryBuilder qb = new QueryBuilder();
        qb.build(targetType, "root");
        return qb.qs.build();
    }

    private class QueryBuilder
    {
        QuerySetBuilder qs = new QuerySetBuilder();
        private Set<Class< ? >> processedClasses = new HashSet<Class< ? >>();

        public QueryBuilder()
        {

        }

        public void build(Class< ? > targetType, String alias)
        {
            if (TypeInformation.isBasicType(targetType))
                return;

            if (processedClasses.contains(targetType))
                return;

            processedClasses.add(targetType);

            ObjectLens lens = ObjectLens.getObjectLens(targetType);
            if (_logger.isDebugEnabled())
                _logger.debug(String.format("class %s\n%s", targetType.getSimpleName(), lens));

            if (!lens.getSetterList().isEmpty())
            {
                SchemaBuilder builder = new SchemaBuilder();
                builder.add(alias);
                for (ParameterSetter each : lens.getSetterList())
                {
                    build(each.getParameterType(), each.getParameterName());
                    builder.add(each.getParameterName());
                }
                Schema s = builder.build();
                qs.addQueryTarget(s);

                schema2type.put(s, targetType);
                schema2lens.put(s, lens);

            }

            for (RelationSetter each : lens.getRelationSetterList())
            {
                build(each.getCoreNodeType(), each.getCoreNodeName());
                build(each.getAttributeNodeType(), each.getAttributeNodeName());

                Schema s = new SchemaBuilder().add(each.getCoreNodeName()).add(each.getAttributeNodeName()).build();
                qs.addQueryTarget(s);

                schema2type.put(s, each.getCoreNodeType());
                schema2lens.put(s, lens);

                relationSchema.add(s);
            }

        }

    }

    private Object getNodeInstance(Node node, Schema schema) throws XerialException
    {
        Object instance = objectHolder.get(node.nodeID);
        if (instance != null)
            return instance;

        Class< ? > schemaType = schema2type.get(schema);
        if (schemaType == null)
        {
            throw new XerialException(XerialErrorCode.INVALID_STATE, String.format(
                    "no corresponding type for schema %s", schema));
        }

        Class< ? > nodeType = null;

        if (node.nodeName.equals(schema.getName()))
        {
            // core node
            nodeType = schemaType;
        }
        else
        {
            // attribute node
            ObjectLens lens = ObjectLens.getObjectLens(schemaType);
            for (ParameterSetter setter : lens.getSetterList())
            {
                if (node.nodeName.equals(setter.getParameterName()))
                {
                    nodeType = setter.getParameterType();
                    break;
                }
            }
        }

        if (nodeType == null)
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("unknown type for %s in %s", node,
                    schema));

        instance = TypeInformation.createInstance(nodeType);
        objectHolder.put(node.nodeID, instance);
        return instance;

    }

    private Binder getBinder(Schema schema, String attributeNodeName) throws XerialException
    {
        Binder binder = schema2binder.get(schema);
        if (binder != null)
            return binder;

        if (relationSchema.contains(schema))
        {
            binder = new RelationBinder(schema);
        }
        else
        {
            binder = new AttributeBinder(schema, attributeNodeName);
        }
        schema2binder.put(schema, binder);

        return binder;
    }

    private class RelationExtracter implements AmoebaJoinHandler
    {

        public void leaveNode(Schema schema, Node node) throws Exception
        {
            if (_logger.isDebugEnabled())
                _logger.debug(String.format("leave: %s in %s", node, schema));
            objectHolder.remove(node.nodeID);
        }

        public void newAmoeba(Schema schema, Node coreNode, Node attributeNode) throws Exception
        {
            if (_logger.isDebugEnabled())
                _logger.debug(String.format("amoeba: (%s, %s) in %s", coreNode, attributeNode, schema));

            Object coreNodeObject = getNodeInstance(coreNode, schema);

            Binder binder = getBinder(schema, attributeNode.nodeName);
            binder.bind(schema, coreNode, attributeNode);

        }

        public void text(Schema schema, Node coreNode, String nodeName, String text) throws Exception
        {
            if (_logger.isDebugEnabled())
                _logger.debug(String.format("text:   (%s, %s:%s) in %s", coreNode, nodeName, text, coreNode, schema));
        }

    }

}

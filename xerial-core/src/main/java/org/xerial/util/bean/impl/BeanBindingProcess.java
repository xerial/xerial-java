/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
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
// BeanBindingProcess.java
// Since: Dec 18, 2007 5:09:59 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import org.xerial.core.XerialException;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.Pair;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUpdatorType;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TypeConverter;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.log.Logger;
import org.xerial.util.tree.TreeVisitor;
import org.xerial.util.tree.TreeWalker;

/**
 * 
 * Tree-structured data to object binding process implementation
 * 
 * @author leo
 * 
 */
public class BeanBindingProcess implements TreeVisitor
{
    private static Logger _logger = Logger.getLogger(BeanBindingProcess.class);

    // private final ArrayList<Object> beanStack = new ArrayList<Object>();

    /*
     * <pre>
     * class A
     * {
     *    public void setB(C value);
     *    public void putD(E key, F value); 
     *    public void addG(H value);
     * }
     *
     * XML
     * 
     * <A>
     *  <B>c-value</B>
     *  <D><key>k1</key><value>v1</value></D>
     *  <D><key>k2</key><value>v2</value></D>
     *  <G>1</G>
     *  <G>2</G>
     * </A>
     * 
     * JSON
     * { "A" : { "B":"c-value", "D":[{"key":"k1", "value":"v1"}, {"key":"k2", "value":"v2"}], G:[1, 2] } }
     *
     *
     * level, event
     * [0] visit(A)
     *  [1] visit(B)
     *  [1] leave(B) 
     *  [1] visit(D) 
     *   [2] visit(key) "k1"
     *   [2] leave(key) 
     *  
     *   [2] visit(value) "v1"
     *   [2] leave(value) 
     *  [1] leave(D) A.putD(KeyValue("k1", "v1"))
     * 
     *  [1] visit(D)
     *   [2] visit(key) "k2"
     *   [2] leave(key) 
     *   [2] visit(value) "v2"
     *   [2] leave(value)
     *  [1] leave(D) A.putD(KeyValue("k2", "v2"))
     *  
     *  [1] visit(G) 1
     *  [1] leave(G) 
     *  [1] visit(G) 2
     *  [1] leave(G)
     * [0] leave(A)
     * 
     * 
     * bean stack
     * [0] new A() (given by constructor)
     * [1] new B()
     * [1] D (new KeyValuePair())
     * [2] key <- "k1"
     * [2] value <- "v1"  
     * [1] D (new KeyValuePair())
     * [2] key <- "k2"
     * [2] value  <- "v2"
     * [1] new G() <- 1  
     * [1] new G() <- 2
     * 
     * </pre>
     * 
     */

    /*
     * class T extends TreeMap<Integer, String> {}
     * 
     * 
     * <T>
     *  <elem><key>k1</key><value>v1</value></elem>
     *  <elem><key>k2</key><value>v2</value></elem>
     * </T>
     * 
     * {"elem":[{"key":"k1", "value":v2}, {"key":"k2", "value":"v2"}]}
     * 
     * 
     */

    private final TreeMap<Integer, Object> contextBeanOfEachLevel = new TreeMap<Integer, Object>();
    private final TreeMap<Integer, Map< ? , ? >> mapAssociatedWithBean = new TreeMap<Integer, Map< ? , ? >>();
    private final Deque<StringBuilder> textStack = new ArrayDeque<StringBuilder>();
    private final Deque<String> nodeStack = new ArrayDeque<String>();
    private final static String EMPTY_STRING = new String();
    private final static StringBuilder EMPTY_TEXT_BUILDER = new StringBuilder(0);

    private int currentLevel = 0;
    private BindRuleGenerator bindRuleGenerator = new BindRuleGeneratorImpl();

    class BindRuleGeneratorImpl implements BindRuleGenerator
    {
        public <T> BeanBinderSet getBeanBinderSet(Class<T> beanClass) throws BeanException
        {
            return BeanUtil.getBeanLoadRule(beanClass);
        }
    }

    public BeanBindingProcess(Class< ? > beanClass) throws BeanException
    {
        this(BeanUtil.createInstance(beanClass));
    }

    public BeanBindingProcess(Object bean)
    {
        setContextBean(0, bean);
    }

    public static BeanBindingProcess newBinderWithRootContext(Object rootNode)
    {
        BeanBindingProcess proc = new BeanBindingProcess(rootNode);
        proc.currentLevel = 1;
        return proc;
    }

    /**
     * 
     * 
     * @param bean
     * @param bindRuleGenerator
     *            set the context bean corresponding to the root node
     */
    public BeanBindingProcess(Object bean, BindRuleGenerator bindRuleGenerator)
    {
        setContextBean(0, bean);
        this.bindRuleGenerator = bindRuleGenerator;
    }

    public Object getResultBean()
    {
        return getContextBean(0);
    }

    public Object getContextBean(int level)
    {
        if (level < 0 || level >= contextBeanOfEachLevel.size())
            return null;
        else
            return contextBeanOfEachLevel.get(level);
    }

    private void setContextBean(int level, Object bean)
    {
        contextBeanOfEachLevel.put(level, bean);
    }

    private void removeContextBean(int level)
    {
        contextBeanOfEachLevel.remove(level);
    }

    public void finish(TreeWalker walker) throws XerialException
    {
    // do nothing
    }

    public void init(TreeWalker walker) throws XerialException
    {
    // do nothing
    }

    protected <T> BeanBinderSet getBindRuleSet(Class<T> beanClass) throws BeanException
    {
        return bindRuleGenerator.getBeanBinderSet(beanClass);
    }

    public void visitNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
    {
        nodeStack.addLast(nodeName != null ? nodeName : EMPTY_STRING);
        textStack.addLast(EMPTY_TEXT_BUILDER);

        int nodeLevel = currentLevel++;
        //_logger.trace("visit[" + nodeLevel + "] " + nodeName);

        Object parentBean = getContextBean(nodeLevel - 1);
        if (parentBean == null)
            return;

        // prepare the context bean for this depth
        Object nodeValueBean = getContextBean(nodeLevel);
        if (nodeValueBean == null)
        {
            assert (currentLevel > 0); // the bean cannot be null when level is 0

            BeanBinderSet bindRuleSet = getBindRuleSet(parentBean.getClass());
            BeanUpdator updator = getUpdator(bindRuleSet, nodeName);
            if (updator != null)
            {
                int targetArgIndex = 0;
                Method updateMethod = updator.getMethod();
                // We have to instantiate a bean class of the node name
                switch (updator.getType())
                {
                case SETTER:
                case COLLECTION_ADDER:
                case APPENDER:
                    Class< ? > elementType = updator.getInputType();
                    if (parentBean instanceof KeyValuePair)
                    {
                        // for map elment
                        KeyValuePair keyValuePair = KeyValuePair.class.cast(parentBean);
                        updateMethod = keyValuePair.putter();
                        if (nodeName.equalsIgnoreCase("key"))
                        {
                            elementType = keyValuePair.keyType();
                        }
                        else if (nodeName.equalsIgnoreCase("value"))
                        {
                            elementType = keyValuePair.valueType();
                            targetArgIndex = 1;
                        }
                    }

                    if (TypeInformation.isBasicType(elementType))
                    {
                        // this bean can be generated directly from the element text value, so
                        // there is no need to instantiate the object here.
                        bindValue(parentBean, nodeName, nodeValue, nodeLevel);
                        break;
                    }
                    else if (TypeInformation.isMap(elementType))
                    {
                        // when input of setter/ or K, V of putSomthing(K, V) is map
                        Pair<Class< ? >, Class< ? >> keyValueClassPair = BeanUtil.getGenericMapTypesOfMethodArgument(
                                updateMethod, targetArgIndex);

                        BeanBinderSet mapBindRuleSet = getBindRuleSet(elementType);
                        MapPutter putter = mapBindRuleSet.getStandardMapPutter();
                        if (keyValueClassPair != null)
                        {
                            setContextBean(nodeLevel, new KeyValuePair(putter, keyValueClassPair.getFirst(),
                                    keyValueClassPair.getSecond()));
                        }
                        else
                        {
                            // no need to put this sub tree since no putter is found
                            //walker.skipDescendants();
                            setContextBean(nodeLevel, new KeyValuePair(putter));

                        }
                    }
                    else if (elementType != Object.class)
                    {
                        Object newBean = BeanUtil.createInstance(elementType);
                        setContextBean(nodeLevel, newBean);
                    }
                    else
                        bindValue(parentBean, nodeName, nodeValue, nodeLevel);

                    break;
                case MAP_PUTTER:
                    MapPutter mapPutter = MapPutter.class.cast(updator);
                    // prepare the key and value pair instance
                    setContextBean(nodeLevel, new KeyValuePair(mapPutter));
                    break;
                default:
                    throw new BeanException(BeanErrorCode.UnknownBeanUpdator);
                }

            }
            else
            {
                // We can safely skip the descendants of this node, since there is
                // no descendant nodes to bind
                walker.skipDescendants();
            }

        }

    }

    private void bindValue(Object parentBean, String nodeName, String nodeValue, int nodeLevel) throws BeanException
    {
        if (parentBean == null)
            return;

        // bind immediate text value
        BeanBinderSet bindRuleSet = getBindRuleSet(parentBean.getClass());
        BeanUpdator updator = getUpdator(bindRuleSet, nodeName);
        if (updator != null)
        {
            Object valueBean = getContextBean(nodeLevel);
            if (valueBean == null)
            {
                if (nodeValue != null && nodeValue.length() > 0)
                {
                    valueBean = nodeValue;
                }
            }

            // no value to bind
            if (valueBean == null)
                return;

            switch (updator.getType())
            {
            case SETTER:
            case COLLECTION_ADDER:
            case APPENDER:
                try
                {
                    if (parentBean instanceof KeyValuePair)
                    {
                        KeyValuePair keyValuePair = KeyValuePair.class.cast(parentBean);
                        if (nodeName.equalsIgnoreCase("key"))
                            bindValue(parentBean, updator, keyValuePair.keyType(), valueBean);
                        else if (nodeName.equalsIgnoreCase("value"))
                            bindValue(parentBean, updator, keyValuePair.valueType(), valueBean);
                    }
                    else
                    {
                        bindValue(parentBean, updator, valueBean);
                    }

                }
                catch (BeanException e)
                {
                    _logger.error(e);
                }
                break;
            case MAP_PUTTER:
                // at key, value data depth
                try
                {
                    KeyValuePair keyValuePair = KeyValuePair.class.cast(valueBean);
                    if (keyValuePair.hasKeyAndValue())
                    {
                        bindMapElement(parentBean, MapPutter.class.cast(updator), keyValuePair);
                    }
                    mapAssociatedWithBean.remove(parentBean.hashCode());
                }
                catch (ClassCastException e)
                {
                    _logger.error(e);
                    // skip this element
                }
                break;
            default:
                throw new BeanException(BeanErrorCode.UnknownBeanUpdator);
            }
        }

    }

    public void text(String nodeValue, TreeWalker walker) throws XerialException
    {
        Object parentBean = getContextBean(currentLevel - 2);
        if (parentBean != null)
        {
            String nodeName = nodeStack.getLast();
            BeanBinderSet bindRuleSet = getBindRuleSet(parentBean.getClass());
            BeanUpdator updator = getUpdator(bindRuleSet, nodeName);
            if (updator != null && updator.getType() == BeanUpdatorType.APPENDER)
            {
                // use appender
                bindValue(parentBean, updator, nodeValue);
            }
            else
            {
                // use internal string buffer
                StringBuilder textBuffer = textStack.peekLast();
                if (textBuffer == EMPTY_TEXT_BUILDER)
                {
                    textStack.removeLast();
                    textBuffer = new StringBuilder();
                    textStack.addLast(textBuffer);
                }
                textBuffer.append(nodeValue);
            }

        }

    }

    public void leaveNode(String nodeName, TreeWalker walker) throws XerialException
    {
        nodeStack.removeLast();
        int nodeLevel = --currentLevel;
        //_logger.trace("leave[" + nodeLevel + "] " + nodeName + " value = " + nodeValue);

        StringBuilder textBuffer = textStack.removeLast();
        Object parentBean = getContextBean(nodeLevel - 1);
        if (parentBean == null)
            return;

        //  if (textBuffer != EMPTY_TEXT_BUILDER)
        bindValue(parentBean, nodeName, textBuffer.toString(), nodeLevel);

        // clear the bean stack
        removeContextBean(nodeLevel);

    }

    public static BeanUpdator getUpdator(BeanBinderSet bindRuleSet, String ruleName) throws BeanException
    {
        BeanBinder binder = bindRuleSet.findRule(ruleName);
        if (binder == null)
            return null;
        else
        {
            if (!BeanUpdator.class.isAssignableFrom(binder.getClass()))
            {
                _logger.warn(binder.getClass().getName() + " cannot be used to bind data");
                return null;
            }
            else
                return (BeanUpdator) binder;
        }
    }

    private void bindMapElement(Object bean, MapPutter mapPutter, KeyValuePair keyValuePair) throws BeanException
    {
        try
        {
            mapPutter.getMethod().invoke(bean, convertType(mapPutter.getKeyType(), keyValuePair.getKey()),
                    convertType(mapPutter.getValueType(), keyValuePair.getValue()));
        }
        catch (IllegalArgumentException e)
        {
            throw new BeanException(BeanErrorCode.IllegalArgument, e);
        }
        catch (IllegalAccessException e)
        {
            throw new BeanException(BeanErrorCode.IllegalAccess, e);
        }
        catch (InvocationTargetException e)
        {
            throw new BeanException(BeanErrorCode.InvocationTargetException, e);
        }
    }

    @SuppressWarnings("unchecked")
    private void bindValue(Object bean, BeanUpdator updator, Class targetType, Object value) throws BeanException
    {
        try
        {
            if (value.getClass() == KeyValuePair.class && TypeInformation.isMap(targetType))
            {
                Map map = null;
                if (mapAssociatedWithBean.containsKey(bean.hashCode()))
                {
                    map = mapAssociatedWithBean.get(bean.hashCode());
                }
                else
                {
                    map = Map.class.cast(BeanUtil.createInstance(targetType));
                    mapAssociatedWithBean.put(bean.hashCode(), map);
                }
                KeyValuePair keyValuePair = KeyValuePair.class.cast(value);
                map.put(keyValuePair.getKey(), keyValuePair.getValue());

                updator.getMethod().invoke(bean, map);
            }
            else
                updator.getMethod().invoke(bean, convertType(targetType, value));
        }
        catch (IllegalArgumentException e)
        {
            throw new BeanException(BeanErrorCode.IllegalArgument, e);
        }
        catch (IllegalAccessException e)
        {
            throw new BeanException(BeanErrorCode.IllegalAccess, e);
        }
        catch (InvocationTargetException e)
        {
            throw new BeanException(BeanErrorCode.InvocationTargetException, e);
        }

    }

    private void bindValue(Object bean, BeanUpdator updator, Object value) throws BeanException
    {
        bindValue(bean, updator, updator.getInputType(), value);
    }

    @SuppressWarnings("unchecked")
    public static Object convertType(Class targetType, Object value) throws BeanException
    {
        return TypeConverter.convertType(targetType, value);
    }

}

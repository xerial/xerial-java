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
import java.util.ArrayList;
import java.util.TreeMap;

import org.xerial.core.XerialException;
import org.xerial.util.bean.BeanBinder;
import org.xerial.util.bean.BeanBinderSet;
import org.xerial.util.bean.BeanErrorCode;
import org.xerial.util.bean.BeanException;
import org.xerial.util.bean.BeanUpdator;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.bean.TreeVisitor;
import org.xerial.util.bean.TreeWalker;
import org.xerial.util.bean.TypeInformation;
import org.xerial.util.log.Logger;

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

    private final ArrayList<Object> beanStack = new ArrayList<Object>();
    private final TreeMap<Integer, KeyValuePair> mapElementHolder = new TreeMap<Integer, KeyValuePair>();

    private int currentLevel = 0;
    private BindRuleGenerator bindRuleGenerator = new BindRuleGeneratorImpl();

    class BindRuleGeneratorImpl implements BindRuleGenerator
    {
        public <T> BeanBinderSet getBeanBinderSet(Class<T> beanClass) throws BeanException
        {
            return BeanUtil.getBeanLoadRule(beanClass);
        }
    }

    public BeanBindingProcess(Class beanClass) throws BeanException
    {
        this(BeanUtil.createInstance(beanClass));
    }

    public BeanBindingProcess(Object bean)
    {
        beanStack.add(bean);
    }

    public BeanBindingProcess(Object bean, BindRuleGenerator bindRuleGenerator)
    {
        beanStack.add(bean);
        this.bindRuleGenerator = bindRuleGenerator;
    }

    public Object getResultBean()
    {
        return beanStack.get(0);
    }

    public Object getBean(int level)
    {
        if (level < 0 || level >= beanStack.size())
            return null;
        else
            return beanStack.get(level);

    }

    private void setBean(int level, Object bean)
    {
        while (beanStack.size() <= level)
        {
            beanStack.add(null);
        }
        beanStack.set(level, bean);
    }

    public void finish(TreeWalker walker) throws XerialException
    {

    }

    public void init(TreeWalker walker) throws XerialException
    {
        currentLevel = 0;

    }

    protected <T> BeanBinderSet getBindRuleSet(Class<T> beanClass) throws BeanException
    {
        return bindRuleGenerator.getBeanBinderSet(beanClass);
    }

    public void leaveNode(String nodeName, String nodeValue, TreeWalker walker) throws XerialException
    {
        int nodeLevel = --currentLevel;
        // _logger.trace("leave: " + nodeName + " level = " + nodeLevel);
        Object parentBean = getBean(nodeLevel - 1);
        if (parentBean == null)
            return;

        BeanBinderSet bindRuleSet = getBindRuleSet(parentBean.getClass());
        BeanUpdator updator = getUpdator(bindRuleSet, nodeName);
        if (updator != null)
        {
            Object valueBean = getBean(nodeLevel);
            if (valueBean == null)
            {
                if (nodeValue != null && nodeValue.length() > 0)
                {
                    valueBean = nodeValue;
                }
            }

            switch (updator.getType())
            {
            case SETTER:
            case COLLECTION_ADDER:
            {
                if (valueBean == null)
                    return;
                try
                {
                    // _logger.trace("update: " + valueBean.toString());
                    bindValue(parentBean, updator, valueBean);
                }
                catch (BeanException e)
                {
                    _logger.error(e);
                }
                // clear the bean stack
                setBean(nodeLevel, null);
            }
            case MAP_PUTTER:
            {
                if (mapElementHolder.containsKey(nodeLevel - 1))
                {
                    // at key, value data depth
                    KeyValuePair keyValuePair = mapElementHolder.get(nodeLevel - 1);
                    keyValuePair.set(valueBean); // allows null valueBean

                    if (keyValuePair.isFilled())
                    {
                        // invoke putter
                        bindMapElement(parentBean, MapPutter.class.cast(updator), keyValuePair);
                        // prepare a new key and value pair for the next map
                        // element
                        // setBean(nodeLevel, new KeyValuePair());
                    }
                }
                else
                {
                    mapElementHolder.remove(nodeLevel - 1);
                }

            }
                break;
            default:
                throw new BeanException(BeanErrorCode.UnknownBeanUpdator);
            }
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

    public void visitNode(String nodeName, TreeWalker walker) throws XerialException
    {
        int nodeLevel = currentLevel++;
        // _logger.trace("visit: " + nodeName + " level = " + nodeLevel);
        Object bean = getBean(nodeLevel);
        if (bean == null)
        {
            assert (currentLevel > 0); // cannot be null when level is 0
            Object parentBean = getBean(nodeLevel - 1);

            // TODO impl
            if (parentBean instanceof KeyValuePair)
            {
                // map elements
                KeyValuePair new_name = (KeyValuePair) parentBean;

            }

            BeanBinderSet parentBeanBindRuleSet = getBindRuleSet(parentBean.getClass());
            BeanBinder binder = parentBeanBindRuleSet.findRule(nodeName);
            if (binder != null)
            {
                // We have to instantiate a bean class of the node name
                if (!BeanUpdator.class.isAssignableFrom(binder.getClass()))
                    throw new BeanException(BeanErrorCode.InvalidBeanClass, binder.getClass().getName()
                            + " cannot be used to bind data");
                BeanUpdator updator = (BeanUpdator) binder;

                switch (updator.getType())
                {
                case SETTER:
                case COLLECTION_ADDER:
                    Class elementType = updator.getInputType();
                    if (TypeInformation.isBasicType(elementType))
                    {
                        // this bean can be converted from an element text, so
                        // there
                        // is no need to instantiate the object here.
                        return;
                    }
                    else
                    {
                        Object newBean = BeanUtil.createInstance(elementType);
                        setBean(nodeLevel, newBean);
                    }
                    break;
                case MAP_PUTTER:
                {
                    MapPutter mapPutter = MapPutter.class.cast(updator);
                    // prepare the key and value pair instance

                    /*
                     * if ( { KeyValuePair mapElement =
                     * mapElementHolder.get(nodeLevel);
                     * 
                     * Class valueType; if (mapElement.hasKey()) { // prepare
                     * the value instance valueType = mapPutter.getValueType(); }
                     * else { // prepare the key instance valueType =
                     * mapPutter.getKeyType(); } if
                     * (!TypeInformation.isBasicType(valueType)) {
                     * setBean(nodeLevel, BeanUtil.createInstance(valueType)); } }
                     * else { setBean(nodeLevel, new KeyValuePair(parentBean)); }
                     */
                }
                    break;
                default:
                    throw new BeanException(BeanErrorCode.UnknownBeanUpdator);
                }
            }
            else
            {
                // We can safely skip descendants of this node, since there is
                // no descendant nodes to bind
                walker.skipDescendants();
                return;
            }
        }

    }

    public static BeanUpdator getUpdator(BeanBinderSet bindRuleSet, String ruleName) throws BeanException
    {
        BeanBinder binder = bindRuleSet.findRule(ruleName);
        if (binder == null)
            return null;
        else
        {
            if (!BeanUpdator.class.isAssignableFrom(binder.getClass()))
                throw new BeanException(BeanErrorCode.InvalidBeanClass, binder.getClass().getName()
                        + " cannot be used to bind data");
            return (BeanUpdator) binder;
        }
    }

    protected void bindValue(Object bean, BeanUpdator updator, Object value) throws BeanException
    {
        try
        {
            // _logger.trace("bind: " + updator.getMethod().toString() + "
            // value=" + value.toString());
            updator.getMethod().invoke(bean, convertType(updator.getInputType(), value));
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

    public static Object convertType(Class targetType, Object value) throws BeanException
    {
        if (targetType == value.getClass())
            return value;
        else
            return convertToBasicType(targetType, value);
    }

    public static Object convertToBasicType(Class targetType, Object input) throws BeanException
    {
        assert (TypeInformation.isBasicType(targetType));

        try
        {
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
            else if (targetType == boolean.class || targetType == Boolean.class)
                return new Boolean(value);
            throw new BeanException(BeanErrorCode.InvalidBeanClass, targetType.getName());
        }
        catch (NumberFormatException e)
        {
            throw new BeanException(BeanErrorCode.InvalidBeanClass, targetType.getName(), e.getMessage());
        }
    }

}

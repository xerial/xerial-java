/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// XMLBeanUtil.java
// Since: 2004/12/27
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util.xml.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.util.Algorithm;
import org.xerial.util.Tuple;
import org.xerial.util.bean.BeanUtil;
import org.xerial.util.xml.InvalidXMLException;
import org.xerial.util.xml.SinglePath;
import org.xerial.util.xml.XMLAttribute;
import org.xerial.util.xml.XMLException;
import org.xerial.util.xml.XMLGenerator;
import org.xerial.util.xml.index.DataGuide;
import org.xmlpull.v1.XmlPullParser;
import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_TAG;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * 
 * @deprecated {@link BeanUtil} is a replacement of XMLBeanUtil
 * XML�������N���X(XMLBean)�Ƀo�C���h�A���邢�͋t�ɁAXMLBean����XML�����𐶐����邽�߂̃c�[���B�ώG��SAX��DOM���g��Ȃ��Ă��AXML�f�[�^���N���X�ɓǂݏ����ł���悤�ɂȂ�B
 * 
 * <p>
 * <b>XMLBean�̗p�� </b>
 * </p>
 * <ul>
 * <li>populate���\�b�h���Ăяo�������ɂƂ��āAaccessible�ł�����������̃R���X�g���N�^�������Ă��邱�ƁB</li>
 * <li>
 * �q�v�f(���邢��attribute)�ɑΉ�����setter�������Ă��邱�ƁB�Ⴆ�΁Abook�Ƃ����^�O�̃f�[�^��ǂݍ��݂����Ȃ�AsetBook�Ƃ������\�b�h�����
 * XML��text�f�[�^�͈����̌^�ɉ����Ď����ŕϊ������B�����^�O���ŕ����̎q�v�f������ꍇ�́A�z��^��setter�̈����ɂ��邱�ƁB
 * �������Ȃ��ꍇ�A��ԍŌ�ɓǂݍ��܂ꂽbook�̃f�[�^�ŁA�O�̃f�[�^�͏㏑�������B</li>
 * <li>�K�w�����ꂽXMLBean�i�܂�AXMLBean�̒���XMLBean��setter�����j�𗘗p���邱�Ƃ��ł���B</li>
 * </ul>
 * <p>
 * Bean�̓��e��XML�Ƃ��ďo�͂��邽�߂ɂ�
 * </p>
 * <ul>
 * <li>public��getter(getSomething()�Ƃ������\�b�h�j��p�ӂ���B�Ԃ�l��String,
 * Integer����Premitive�̏ꍇ�͂��ꂪ���̂܂܃��\�b�h������get����菜�����^�O�������q�v�f�Ƃ��ďo�͂����B</li>
 * <li>public String[]
 * attributes()�Ƃ������\�b�h������΁A�����ɋL����Ă��閼�O�ɑΉ�����getter�ł̏o�͂́Aattribute�Ƃ��ďo�͂���� </li>
 * <li>null�l��getter�̕Ԃ�l�̏ꍇ�A���̗v�f�͏o�͂���Ȃ��B���������āAfiled��null�ŏ��������Ă������Ƃ𐄏����� </li>
 * <li></li>
 * </ul>
 * 
 * <p>
 * <b>���ӎ��� </b>
 * </p>
 * <ul>
 * <li>�e�L�X�g�݂̂̎q�v�f�ƁAattribute�͋�ʂ���Ȃ��B</li>
 * <li>���݂̂Ƃ���A�擪������Capitalize���ꂽtag���͈����Ȃ�</li>
 * </ul>
 * 
 * ���Ƃ��΁A�ȉ��̂悤��XML������ǂݍ��ނɂ́A
 * 
 * <pre>
 * 
 *  
 *       &lt;booklist&gt;
 *          &lt;book isbn=&quot;1558607544&quot;&gt;
 *            &lt;title&gt;Mining The Web&lt;/title&gt;
 *            &lt;author&gt;Soument Chakrabarti&lt;/author&gt;
 *            &lt;year&gt;2002&lt;/year&gt;
 *            &lt;publisher&gt;Morgan Kaufmann&lt;/publisher&gt;
 *          &lt;/book&gt;
 *          &lt;book&gt;
 *            &lt;title&gt;Learning XML&lt;/title&gt;
 *            &lt;year&gt;2004&lt;/year&gt;
 *            &lt;author&gt;Erik T. Ray&lt;/author&gt;
 *          &lt;/book&gt;
 *       &lt;/booklist&gt;
 *   
 *  
 * </pre>
 * 
 * ���L�̂悤�ȃN���X�������B
 * 
 * <pre>
 * class Booklist
 * {
 *     private Book[] book;
 * 
 *     public Booklist()
 *     {}
 * 
 *     public void setBook(Book[] book)
 *     {
 *         this.book = book;
 *     }
 * 
 *     public Book[] getBook()
 *     {
 *         return book;
 *     }
 * }
 * 
 * class Book
 * {
 *     private String title;
 * 
 *     private String isbn;
 * 
 *     private int year;
 * 
 *     private String[] author;
 * 
 *     private String publisher;
 * 
 *     public Book()
 *     {}
 * 
 *     public void setTitle(String title)
 *     {
 *         this.title = title;
 *     }
 * 
 *     public void setIsbn(String isbn)
 *     {
 *         this.isbn = isbn;
 *     }
 * 
 *     public void setYear(int year)
 *     {
 *         this.year = year;
 *     }
 * 
 *     public void setAuthor(String[] author)
 *     {
 *         this.author = author;
 *     }
 * 
 *     public void setPublisher(String publisher)
 *     {
 *         this.publisher = publisher;
 *     }
 * 
 *     public String getTitle()
 *     {
 *         return title;
 *     }
 * 
 *     public String getIsbn()
 *     {
 *         retutn isbn;
 *     }
 * 
 *     public int getYear()
 *     {
 *         return year;
 *     }
 * 
 *     public String getPublisher()
 *     {
 *         return publisher;
 *     }
 * 
 *     public String[] getAuthor()
 *     {
 *         return author;
 *     }
 * 
 *     public String[] attributes()
 *     {
 *         return new String[] { &quot;isbn&quot; };
 *     }
 * }
 * </pre>
 * 
 * XML��������Booklist�̃I�u�W�F�N�g�𐶐�����R�[�h�́A
 * 
 * <pre>
 * 
 *  
 *   Booklist booklist;
 *   try
 *   {
 *       FileInputStream fin = new FileInputStream(&quot;sample/booklist.xml&amp;quot));
 *       booklist = XMLBeanUtil.newInstance(Booklist.class, fin);
 *       fin.close();
 *   }
 *   catch (XMLException e)
 *   {
 *       // �f�[�^��bind����̂Ɏ��s�����ꍇ (���ڂ����������ƂɑΏ�����ɂ́AInvalidXMLException, XMLParserException, XMLBeanException��catch����j
 *   }
 *   catch (IOException e)
 *   {
 *       // XML�t�@�C����������Ȃ��A���邢�́A�X�g���[���̓��͂Ɏ��s�����Ƃ�  
 *   }
 *   
 *  
 * </pre>
 * 
 * Booklist�̃C���X�^���X����XML�𐶐�����ɂ�
 * 
 * <pre>
 * XMLBeanUtil.ouputAsXML(booklist, System.out);
 * </pre>
 * 
 * 
 * @author leo
 * 
 */
public final class XMLBeanUtil
{

    private XMLBeanUtil()
    {}

    /**
     * XML������stream����AXMLBean�̃N���X�̃C���X�^���X�𐶐�����BInputStream�́AEndTag�̎��̏�Ԃ܂Ői��
     * 
     * 
     * @param <E>
     *            XMLBean�̌^
     * @param xmlBeanClass
     *            ��������N���X
     * @param xmlStream
     *            XML�̓���
     * @return XML�̃f�[�^���o�C���h���ꂽXMLBean�̃C���X�^���X
     * @throws IOException
     *             XML�̓��̓G���[�Ő�����
     * @throws XMLParserException
     *             pull
     *             parser�̐����Ɏ��s�����Ƃ��BXmlPullParser��library��CLASSPATH�Ɋ܂܂�Ă��Ȃ��̂���Ȍ���
     * @throws XMLBeanException
     *             XMLBean�̐����Asetter�̌Ăяo���Ɏ��s�����Ƃ�
     * @throws InvalidXMLException
     *             XML�������K�؂ȃt�H�[�}�b�g�łȂ��ꍇ�Ȃ�
     */
    static public <E> E newInstance(Class<E> xmlBeanClass, InputStream xmlStream) throws IOException,
            XMLException, XMLBeanException, InvalidXMLException
    {
        XmlPullParser parser;
        try
        {
            parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xmlStream, null);
        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(e);
        }
        return newInstance(xmlBeanClass, parser);
    }

    /**
     * XML������pull parser����AXMLBean�̃N���X�̃C���X�^���X�𐶐�����Bpull parser��END_TAG���w������ԂŕԂ�
     * 
     * @param <E>
     *            XMLBean�̌^
     * @param xmlBeanClass
     *            ��������N���X
     * @param pullParser
     *            pull parser�̃C���X�^���X�B
     * @return XML�̃f�[�^���o�C���h���ꂽXMLBean�̃C���X�^���X
     * @throws IOException
     *             XML�̓��̓G���[�Ő�����
     * @throws XMLBeanException
     *             XMLBean�̐����Asetter�̌Ăяo���Ɏ��s�����Ƃ�
     * @throws InvalidXMLException
     *             XML�������K�؂ȃt�H�[�}�b�g�łȂ��ꍇ�Ȃ�
     */
    static public <E> E newInstance(Class<E> xmlBeanClass, XmlPullParser pullParser) throws IOException,
            XMLBeanException, InvalidXMLException
    {
        if (xmlBeanClass == null)
            throw new XMLBeanException("an invalid class is passed to the poplulate method");
        E obj;
        try
        {
            obj = xmlBeanClass.newInstance();
        }
        catch (InstantiationException e)
        {
            throw new XMLBeanException("cannot instantiate the class " + xmlBeanClass.getSimpleName());
        }
        catch (IllegalAccessException e)
        {
            throw new XMLBeanException("cannot instantiate the class " + xmlBeanClass.getSimpleName());
        }
        populate(obj, pullParser);
        return obj;
    }

    /**
     * pull parser����XML��element��ǂ�ŁAxmlBean�𖄂߂�B pull parser�́AEND_TAG���w������ԂŕԂ�
     * 
     * @param xmlBean
     *            XMLBean�̃C���X�^���X
     * @param pullParser
     *            pull parser�̃C���X�^���X
     * @throws IOException
     *             XML�̓��̓G���[�Ő�����
     * @throws XMLBeanException
     *             XMLBean�̐����Asetter�̌Ăяo���Ɏ��s�����Ƃ�
     * @throws InvalidXMLException
     *             XML�������K�؂ȃt�H�[�}�b�g�łȂ��ꍇ�Ȃ�
     */
    static public void populate(Object xmlBean, XmlPullParser pullParser) throws IOException, XMLBeanException,
            InvalidXMLException
    {
        if (xmlBean == null)
            throw new XMLBeanException("an invalid instance is passed to the poplulate method");
        BindRuleCreationProcess ruleGenerator = new BindRuleCreationProcess();
        ruleGenerator.createBindRule(xmlBean.getClass());
        ParseAndBindProcess parseProcess = new ParseAndBindProcess(pullParser, ruleGenerator.getBindRule(),
                ruleGenerator.getDataGuide());

        parseProcess.parse(xmlBean);

    }

    /**
     * pull parser����XML��element��ǂ�ŁAxmlBean�𖄂߂�B pull parser�́AEND_TAG���w������ԂŕԂ�
     * 
     * @param xmlBean
     *            XMLBean�̃C���X�^���X
     * @param xmlStream
     *            xml�����̓���
     * @throws IOException
     *             XML�̓��̓G���[�Ő�����
     * @throws XMLBeanException
     *             XMLBean�̐����Asetter�̌Ăяo���Ɏ��s�����Ƃ�
     * @throws InvalidXMLException
     *             XML�������K�؂ȃt�H�[�}�b�g�łȂ��ꍇ�Ȃ�
     * @throws XMLParserException
     *             PullParser�̐����Ɏ��s�����Ƃ��Bpullparser�̃��C�u������CLASSPATH�Ɋ܂܂�Ă��Ȃ����Ƃ���Ȍ���
     */
    static public void populate(Object xmlBean, InputStream xmlStream) throws XMLException, IOException,
            XMLBeanException, InvalidXMLException
    {
        XmlPullParser parser;
        try
        {
            parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(xmlStream, null);
            populate(xmlBean, parser);
        }
        catch (XmlPullParserException e)
        {
            throw new XMLException(e);
        }
    }

    /**
     * XML��parse���āA���ۂɃN���X��bind����N���X
     * 
     * @author leo
     * 
     */
    static private class ParseAndBindProcess
    {
        private XmlPullParser _parser;

        private TreeMap<Integer, BindRule> _bindRule;

        private DataGuide _dataGuide;

        int level = 0;

        /**
         * ���݌��Ă���^�O�̗�����ʂ���̂Ɏg���B�Ⴆ�΁A
         * 
         * <pre>
         * 
         *  
         *     &lt;booklist&gt;
         *       &lt;book&gt; ..&lt;/book&gt;
         *       &lt;book&gt; .. &lt;/book&gt;
         *     &lt;/booklist&gt;
         *   
         *  
         * </pre>
         * 
         * �Ƃ���XML����book�̃^�O�ɂ́A���ׂē���ParseContext�����蓖�Ă���
         * 
         * @author leo
         * 
         */
        class ParseContext implements Comparable<ParseContext>
        {
            int level = 0;

            String tagName;

            public ParseContext(int level, String tagName)
            {
                this.level = level;
                this.tagName = tagName;
            }

            public int compareTo(ParseContext o)
            {
                int levelDiff = level - o.level;
                return (levelDiff == 0) ? tagName.compareTo(o.tagName) : levelDiff;
            }
        }

        public ParseAndBindProcess(XmlPullParser pullParser, TreeMap<Integer, BindRule> bindRule, DataGuide dataGuide)
        {
            _parser = pullParser;
            _bindRule = bindRule;
            _dataGuide = dataGuide;
        }

        public void parse(Object currentObject) throws IOException, InvalidXMLException, XMLBeanException
        {
            try
            {
                // �ŏ��̃^�O�ɂ��ǂ蒅���܂�parse��i�߂�
                if (_parser.getEventType() != START_TAG)
                {
                    while (_parser.next() != START_TAG)
                    {}
                }
                parse(currentObject, new SinglePath());
            }
            catch (XmlPullParserException e)
            {
                throw new InvalidXMLException(e);
            }
            catch (NumberFormatException e)
            {
                throw new InvalidXMLException(e);
            }
            catch (IllegalArgumentException e)
            {
                throw new XMLBeanException(e);
            }
            catch (IllegalAccessException e)
            {
                throw new XMLBeanException(e);
            }
            catch (InvocationTargetException e)
            {
                throw new XMLBeanException(e);
            }
        }

        private void parse(Object currentObject, SinglePath currentPath) throws IOException, XmlPullParserException,
                XMLBeanException, NumberFormatException, IllegalArgumentException, IllegalAccessException,
                InvocationTargetException
        {
            _parser.require(START_TAG, null, null);

            TreeMap<ParseContext, Vector<String>> arrayObjectContainer = new TreeMap<ParseContext, Vector<String>>();
            TreeMap<ParseContext, Vector<Object>> beanArrayContainer = new TreeMap<ParseContext, Vector<Object>>();
            TreeMap<ParseContext, BindRule> bindRuleContainer = new TreeMap<ParseContext, BindRule>(); // array���o�C���h���郋�[�����i�[���Ă���

            // attribute elements
            for (int i = 0; i < _parser.getAttributeCount(); i++)
            {
                String attribName = _parser.getAttributeName(i);
                SinglePath attribPath = new SinglePath(currentPath, attribName);
                int dataGuideID = _dataGuide.getPathID(attribPath);
                BindRule rule = _bindRule.get(dataGuideID);
                if (rule != null && rule.canInvokeSetMethod())
                    rule.bind(currentObject, _parser.getAttributeValue(i));
            }

            // child elements
            while (_parser.next() != END_TAG)
            {
                int state = _parser.getEventType();
                switch (state)
                {
                case START_TAG:
                    level++;
                    String tagName = _parser.getName();
                    tagName = tagName.replace('-', '_'); // Java�ł́A-���N���X�A���\�b�h���Ɏg�p�ł��Ȃ��̂�
                    tagName = tagName.toLowerCase(); // �^�O���̑啶���A�������̈Ⴂ�𖳎�
                    SinglePath childPath = new SinglePath(currentPath, tagName);
                    int dataGuideID = _dataGuide.getPathID(childPath);
                    BindRule rule = _bindRule.get(dataGuideID);
                    if (rule == null)
                    {
                        while (_parser.next() != END_TAG)
                        {} // skip element
                        level--;
                        break;
                    }

                    switch (rule.getBindType())
                    {
                    case invokeMethod:
                        // TODO START_TAG, TEXT, END_TAG�Ƃ����g�ݍ��킹�łȂ��ꍇ�̑Ώ�
                        String textContent = _parser.nextText();
                        if (rule.isArrayType())
                        {
                            ParseContext parseContext = new ParseContext(level, tagName);
                            Vector<String> array = arrayObjectContainer.get(parseContext);
                            if (array == null)
                            {
                                array = new Vector<String>();
                                bindRuleContainer.put(parseContext, rule);
                            }
                            array.add(textContent);
                            arrayObjectContainer.put(parseContext, array);
                        }
                        else
                            rule.bind(currentObject, textContent);

                        level--;
                        break;
                    case nestedElement:
                        try
                        {
                            Object childObj = rule.getElementClass().newInstance();
                            parse(childObj, childPath);
                            if (rule.isArrayType())
                            {
                                ParseContext parseContext = new ParseContext(level, tagName);
                                Vector<Object> beanArray = beanArrayContainer.get(parseContext);
                                if (beanArray == null)
                                {
                                    beanArray = new Vector<Object>();
                                    bindRuleContainer.put(parseContext, rule);
                                }
                                beanArray.add(childObj);
                                beanArrayContainer.put(parseContext, beanArray);
                            }
                            else
                                rule.bindObject(currentObject, childObj);
                            level--;
                            break;
                        }
                        catch (InstantiationException e)
                        {
                            throw new XMLBeanException("cannot instantiate the class "
                                    + rule.getElementClass().getSimpleName());

                        }
                        catch (IllegalAccessException e)
                        {
                            throw new XMLBeanException("cannot instantiate the class "
                                    + rule.getElementClass().getSimpleName());
                        }
                    }

                }
            }

            // bind arrays
            for (ParseContext context : arrayObjectContainer.keySet())
            {
                BindRule rule = bindRuleContainer.get(context);
                assert rule != null;
                Vector<String> array = arrayObjectContainer.get(context);
                rule.bindArray(currentObject, array);
            }
            // bind bean arrays
            for (ParseContext context : beanArrayContainer.keySet())
            {
                BindRule rule = bindRuleContainer.get(context);
                assert rule != null;
                Vector<Object> beanArray = beanArrayContainer.get(context);
                rule.bindBeanArray(currentObject, beanArray);
            }

        }

    }

    private enum BindType {
        invokeMethod, nestedElement
    }

    private enum ArgType {
        p_int, p_double, p_float, p_boolean, String, Integer, Double, Float, Boolean
    }

    static String[] _primitiveClassNames = { "int", "double", "float", "boolean", "String", "Integer", "Double",
            "Float", "Boolean" };

    /**
     * XML�̗v�f���ǂ̂悤���ɏ������邩���`���邽�߂̃N���X
     * 
     * @author leo
     */
    static private class BindRule
    {
        static private TreeMap<String, ArgType> argMap = new TreeMap<String, ArgType>();

        private BindType bindType;

        private Method methodForBinding;

        private ArgType argType;

        private Class xmlBeanElementClass;

        private boolean isArrayType = false;

        /**
         * �q�v�f�����̂܂܃f�[�^�Ƃ��Ċi�[����ۂɎg��Rule
         * 
         * @param methodForBinding
         *            bind����ۂɌĂяo�����\�b�h
         * @param argType
         *            ���\�b�h�̈����̌^
         */
        public BindRule(Method methodForBinding, String argType)
        {
            bindType = BindType.invokeMethod;
            this.methodForBinding = methodForBinding;
            if (argType.endsWith("[]"))
            {
                // �z��̏ꍇ
                isArrayType = true;
                this.argType = argMap.get(argType.substring(0, argType.length() - 2));
            }
            else
                this.argType = argMap.get(argType);
        }

        /**
         * XMLBean�̒��ɁAXMLBean������Ƃ��Ɏg��Rule
         * 
         * @param methodForBinding
         * @param xmlBeanElementClass
         */
        public BindRule(Method methodForBinding, Class xmlBeanElementClass)
        {
            this.bindType = BindType.nestedElement;
            this.methodForBinding = methodForBinding;

            if (xmlBeanElementClass.isArray())
            {
                this.isArrayType = true;
                this.xmlBeanElementClass = xmlBeanElementClass.getComponentType();
            }
            else
                this.xmlBeanElementClass = xmlBeanElementClass;
        }

        public boolean isArrayType()
        {
            return isArrayType;
        }

        public Class getElementClass()
        {
            return xmlBeanElementClass;
        }

        public BindType getBindType()
        {
            return bindType;
        }

        public boolean canInvokeSetMethod()
        {
            return bindType == BindType.invokeMethod;
        }

        public boolean isForChildElement()
        {
            return bindType == BindType.nestedElement;
        }

        /**
         * @param currentObject
         * @param beanArray
         * @throws InvocationTargetException
         * @throws IllegalAccessException
         * @throws IllegalArgumentException
         */
        public void bindBeanArray(Object currentObject, Vector<Object> beanVector) throws IllegalArgumentException,
                IllegalAccessException, InvocationTargetException
        {
            Object[] beanArray = (Object[]) Array.newInstance(xmlBeanElementClass, beanVector.size());
            int i = 0;
            for (Object bean : beanVector)
            {
                beanArray[i++] = bean;
            }
            methodForBinding.invoke(currentObject, (Object) beanArray);
        }

        public void bindObject(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException,
                InvocationTargetException
        {
            if (bindType != BindType.nestedElement)
                return; // TODO throw
            // exception?

            methodForBinding.invoke(obj, value);
        }

        public void bindArray(Object obj, Vector<String> textContent) throws IllegalArgumentException,
                IllegalAccessException, InvocationTargetException
        {
            if (!isArrayType)
                return;

            int i = 0;
            switch (argType)
            {
            case p_int:
                int[] a = new int[textContent.size()];
                for (String s : textContent)
                    a[i++] = Integer.parseInt(s);
                methodForBinding.invoke(obj, (Object) a);
                break;
            case p_double:
                double[] d = new double[textContent.size()];
                for (String s : textContent)
                    d[i++] = Double.parseDouble(s);
                methodForBinding.invoke(obj, (Object) d);
                break;
            case p_float:
                float[] f = new float[textContent.size()];
                for (String s : textContent)
                    f[i++] = Float.parseFloat(s);
                methodForBinding.invoke(obj, (Object) f);
                break;
            case p_boolean:
                boolean[] b = new boolean[textContent.size()];
                for (String s : textContent)
                    b[i++] = Boolean.parseBoolean(s);
                methodForBinding.invoke(obj, (Object) b);
                break;
            case String:
                String[] sa = new String[textContent.size()];
                for (String s : textContent)
                    sa[i++] = s;
                methodForBinding.invoke(obj, (Object) sa);
                break;
            case Integer:
                Integer[] a2 = new Integer[textContent.size()];
                for (String s : textContent)
                    a2[i++] = Integer.parseInt(s);
                methodForBinding.invoke(obj, (Object) a2);
                break;
            case Double:
                Double[] d2 = new Double[textContent.size()];
                for (String s : textContent)
                    d2[i++] = Double.parseDouble(s);
                methodForBinding.invoke(obj, (Object) d2);
                break;
            case Float:
                Float[] f2 = new Float[textContent.size()];
                for (String s : textContent)
                    f2[i++] = Float.parseFloat(s);
                methodForBinding.invoke(obj, (Object) f2);
                break;
            case Boolean:
                Boolean[] b2 = new Boolean[textContent.size()];
                for (String s : textContent)
                    b2[i++] = Boolean.parseBoolean(s);
                methodForBinding.invoke(obj, (Object) b2);
                break;
            }

        }

        public void bind(Object obj, String value) throws NumberFormatException, IllegalArgumentException,
                IllegalAccessException, InvocationTargetException
        {
            if (bindType != BindType.invokeMethod)
                return; // TODO throw
            // exception?

            switch (argType)
            {
            case p_int:
                methodForBinding.invoke(obj, Integer.parseInt(value));
                break;
            case p_double:
                methodForBinding.invoke(obj, Double.parseDouble(value));
                break;
            case p_float:
                methodForBinding.invoke(obj, Float.parseFloat(value));
                break;
            case p_boolean:
                methodForBinding.invoke(obj, Boolean.parseBoolean(value));
                break;
            case String:
                methodForBinding.invoke(obj, value);
                break;
            case Integer:
                methodForBinding.invoke(obj, new Integer(value));
                break;
            case Double:
                methodForBinding.invoke(obj, new Double(value));
                break;
            case Float:
                methodForBinding.invoke(obj, new Float(value));
                break;
            case Boolean:
                methodForBinding.invoke(obj, new Boolean(value));
                break;
            }

        }

        static
        {
            for (ArgType t : ArgType.values())
            {
                argMap.put(_primitiveClassNames[t.ordinal()], t);
            }
        }

    }

    /**
     * XML��Path->�f�[�^�^ �Ƃ����`����bind rule �����N���X
     * 
     * @author leo
     * 
     */
    static private class BindRuleCreationProcess
    {

        /**
         * DataGuide�̃m�[�hID����BindRule�̃Z�b�g
         */
        private TreeMap<Integer, BindRule> _bindRule = new TreeMap<Integer, BindRule>();

        private DataGuide _dataGuide = new DataGuide();

        BindRuleCreationProcess()
        {}

        void createBindRule(Class c) throws XMLBeanException
        {
            createBindRule_internal(_dataGuide.getTagID(DataGuide.ROOT_TAG), c);
        }

        private void createBindRule_internal(int dataGuideNodeID, Class c) throws XMLBeanException
        {
            try
            {

                Method[] method = c.getDeclaredMethods();
                for (Method m : method)
                {
                    String methodName = m.getName();
                    if (!methodName.startsWith("set") || methodName.length() <= 3) // find a setter 
                        continue; 
                    Class[] parameterType = m.getParameterTypes();
                    if (parameterType.length != 1) // ������ȊO��setter�͎g���Ȃ�
                        continue;

                    String tagOrAttributeName = pickPropertyName(methodName, SetterOrGetter.set);
                    if (tagOrAttributeName == null)
                        continue;

                    int nextDataGuideNodeID = _dataGuide.newTag(tagOrAttributeName.toLowerCase());
                    Class argType = parameterType[0];
                    if (isPrimitive(argType))
                    {
                        // primitive type�̏ꍇ��element or attribute�𒼐�bind����
                        // TODO attribute �� tag element�̋�ʂ����邩�H
                        _bindRule.put(nextDataGuideNodeID, new BindRule(m, argType.getSimpleName()));
                    }
                    else
                    {
                        // primitive �łȂ��ꍇ
                        _bindRule.put(nextDataGuideNodeID, new BindRule(m, argType));
                        Class nextClass = argType.isArray() ? argType.getComponentType() : argType;
                        if (!nextClass.equals(c))
                            createBindRule_internal(nextDataGuideNodeID, nextClass);
                    }
                    _dataGuide.closeTag();
                }
            }
            catch (XMLException e)
            {
                throw new XMLBeanException(e);
            }
        }

        public TreeMap<Integer, BindRule> getBindRule()
        {
            return _bindRule;
        }

        public DataGuide getDataGuide()
        {
            return _dataGuide;
        }

    }

    static enum SetterOrGetter {
        set, get
    }

    /**
     * @param methodName
     *            setSomething, getSomething�Ȃǂ̃��\�b�h��
     * @param patternType
     *            set(ter) or get(ter)
     * @return ���\�b�h������擪��set/get����菜����������̐擪��lower case�ɕϊ�����String.
     *         �؂�o���Ȃ��ꍇ�́Anull ��Ԃ�/
     */
    static String pickPropertyName(String methodName, SetterOrGetter patternType)
    {
        Matcher m = null;
        switch (patternType)
        {
        case set:
            m = _setMethodPattern.matcher(methodName);
            break;
        case get:
            m = _getMethodPattern.matcher(methodName);
            break;
        default:
            return null;
        }
        if (!m.matches())
            return null;
        else
            return m.group(1).toLowerCase() + m.group(2);
    }

    static private Pattern _setMethodPattern = Pattern.compile("^set(\\S)(\\S*)");

    static private Pattern _getMethodPattern = Pattern.compile("^get(\\S)(\\S*)");

    /**
     * Class c ��primitive type(int(Integer), String, double(Double),
     * float(Float))���ǂ����A���邢�͂��̔z�񂩔���
     * 
     * @param c
     * @return primivtive ���ǂ���
     */
    static boolean isPrimitive(Class c)
    {
        String typeName = c.getSimpleName();
        if (typeName.endsWith("[]"))
            return _primitiveClassSet.contains(typeName.substring(0, typeName.length() - 2));
        else
            return _primitiveClassSet.contains(typeName);
    }

    static private HashSet<String> _primitiveClassSet = new HashSet<String>();
    static
    {
        for (String s : _primitiveClassNames)
            _primitiveClassSet.add(s);
    }

    /**
     * xmlBean�̓��e��XML�̗v�f�Ƃ��ďo�͂���B
     * 
     * @param xmlBean
     *            �o�͌�
     * @param out
     *            �o�͐�
     * @throws InvalidXMLException
     * @throws XMLBeanException
     */
    static public void outputAsXML(Object xmlBean, OutputStream out) throws XMLBeanException, InvalidXMLException
    {
        XMLOutputProcess outputProcess = new XMLOutputProcess(out);
        outputProcess.outputAsXML(xmlBean);
    }

}

enum OutputRuleType {
    outputAsPrimitive, iterateOverCollection, iterateOverPrimitiveArray, nestedBean, arrayBean
}

class OutputRule extends Tuple<OutputRuleType, Method, String>
{
    /**
     * @param first
     * @param second
     * @param third
     */
    public OutputRule(OutputRuleType first, Method second, String third)
    {
        super(first, second, third);
    }
}

class OutputRuleSet
{
    Class xmlBeanClass;

    Vector<OutputRule> _elementRule = new Vector<OutputRule>();

    Vector<OutputRule> _attributeRule = new Vector<OutputRule>();

    public OutputRuleSet(Class xmlBeanClass)
    {
        this.xmlBeanClass = xmlBeanClass;
    }

    public void addElementRule(OutputRuleType ruleType, Method getter, String elementName)
    {
        _elementRule.add(new OutputRule(ruleType, getter, elementName));
    }

    public void addAttributeRule(OutputRuleType ruleType, Method getter, String elementName)
    {
        _attributeRule.add(new OutputRule(ruleType, getter, elementName));
    }

    public Vector<OutputRule> getElementRules()
    {
        return _elementRule;
    }

    public Vector<OutputRule> getAttributeRules()
    {
        return _attributeRule;
    }
}

/**
 * XMLBean����XML�𐶐�����N���X
 * 
 * @author leo
 * 
 */
class XMLOutputProcess
{
    HashMap<Class, OutputRuleSet> _outputRuleOfEachClass = new HashMap<Class, OutputRuleSet>();

    XMLGenerator _xmlOut;

    public XMLOutputProcess(OutputStream out)
    {
        _xmlOut = new XMLGenerator(out);
    }

    public void outputAsXML(Object xmlBean) throws XMLBeanException, InvalidXMLException
    {
        if (xmlBean == null)
            return;

        inspectGettersInXMLBean(xmlBean);
        Class xmlBeanClass = xmlBean.getClass();
        OutputRuleSet outputRuleSet = _outputRuleOfEachClass.get(xmlBeanClass);
        if (outputRuleSet == null)
            throw new XMLBeanException("cannot create any output rule for the class " + xmlBeanClass.getName());

        String className = xmlBeanClass.getSimpleName();
        XMLAttribute attrib = new XMLAttribute();
        for (OutputRule attribRule : outputRuleSet.getAttributeRules())
        {
            Object value = null;
            try
            {
                value = attribRule.getSecond().invoke(xmlBean);
                if (value != null)
                    attrib.add(attribRule.getThird(), value.toString());
            }
            catch (IllegalArgumentException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        _xmlOut.startTag(className.substring(0, 1).toLowerCase() + className.substring(1), attrib);
        for (OutputRule rule : outputRuleSet.getElementRules())
        {
            OutputRuleType ruleType = rule.getFirst();
            Method getter = rule.getSecond();
            String elementName = rule.getThird();

            try
            {
                switch (ruleType)
                {
                case outputAsPrimitive:
                    String content;
                    Object contentObj = getter.invoke(xmlBean);
                    if (contentObj != null)
                        _xmlOut.element(elementName, contentObj.toString());
                    break;
                case iterateOverCollection:
                    Collection c = (Collection) getter.invoke(xmlBean);
                    for (Object obj : c)
                        outputAsXML(c);
                    break;
                case iterateOverPrimitiveArray:
                    Object[] array = (Object[]) getter.invoke(xmlBean);
                    for (Object obj : array)
                    {
                        if (obj != null)
                            _xmlOut.element(elementName, obj.toString());
                    }
                    break;
                case nestedBean:
                    Object nestedBean = getter.invoke(xmlBean);
                    outputAsXML(nestedBean);
                    break;
                case arrayBean:
                    Object[] arrayBean = (Object[]) getter.invoke(xmlBean);
                    for (Object obj : arrayBean)
                        outputAsXML(obj);
                    break;
                }
            }
            catch (IllegalArgumentException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        _xmlOut.endTag();
        _xmlOut.flush();
    }

    /**
     * Object getSomething()�Ƃ������\�b�h������ꍇ�A �Ԃ�l��Object�ɂ���ďꍇ�����B primitive type:
     * ���̂܂�XML element�Ƃ��ďo�� collection : �e�v�f�ɑ΂��A�ċA���� ����ȊO:
     * bean�Ƃ݂Ȃ��A�����e�v�f�Ƃ��āA�egetter�ɑ΂��ċA
     * 
     * @param beanClass
     */
    protected void inspectGettersInXMLBean(Object xmlBean)
    {
        Class beanClass = xmlBean.getClass();
        if (_outputRuleOfEachClass.containsKey(beanClass)) // ���łɒ��ׂ����Ƃ̂���N���X���H
            return;

        OutputRuleSet outputRuleSet = new OutputRuleSet(beanClass);
        _outputRuleOfEachClass.put(beanClass, outputRuleSet); // ���G���g����o�^���Ă���

        Set<String> attributeNameSet = inspectAttributeNames(xmlBean);

        Method[] method = beanClass.getMethods();
        for (Method m : method)
        {
            String methodName = m.getName();
            if (methodName.equals("getClass"))
                continue; // Object
            // class�̃��\�b�h�͖���

            if (!methodName.startsWith("get") || methodName.length() <= 3) // is
                // setter?
                continue;
            Class[] parameterType = m.getParameterTypes();
            if (parameterType.length != 0) // 0�����ȊO��getter�͎g���Ȃ�
                continue;
            String tagOrAttributeName = XMLBeanUtil.pickPropertyName(methodName, XMLBeanUtil.SetterOrGetter.get);
            if (tagOrAttributeName == null)
                continue;

            Class returnType = m.getReturnType();

            if (XMLBeanUtil.isPrimitive(returnType))
            {
                if (returnType.isArray())
                    outputRuleSet.addElementRule(OutputRuleType.iterateOverPrimitiveArray, m, tagOrAttributeName);
                else
                {
                    if (attributeNameSet.contains(tagOrAttributeName))
                        outputRuleSet.addAttributeRule(OutputRuleType.outputAsPrimitive, m, tagOrAttributeName);
                    else
                        outputRuleSet.addElementRule(OutputRuleType.outputAsPrimitive, m, tagOrAttributeName);
                }
                continue;
            }
            if (Collection.class.isAssignableFrom(returnType))
            {
                outputRuleSet.addElementRule(OutputRuleType.iterateOverCollection, m, tagOrAttributeName);
                continue;
            }
            if (returnType.isArray())
                outputRuleSet.addElementRule(OutputRuleType.arrayBean, m, tagOrAttributeName);
            else
            {
                if (attributeNameSet.contains(tagOrAttributeName))
                    outputRuleSet.addAttributeRule(OutputRuleType.outputAsPrimitive, m, tagOrAttributeName);
                else
                    outputRuleSet.addElementRule(OutputRuleType.nestedBean, m, tagOrAttributeName);
            }
        }
        _outputRuleOfEachClass.put(beanClass, outputRuleSet);
    }

    protected Set<String> inspectAttributeNames(Object xmlBean)
    {
        Class beanClass = xmlBean.getClass();
        TreeSet<String> attributeNameSet = new TreeSet<String>();
        try
        {
            Method attributeNameGetter = beanClass.getMethod("attributes");
            Object ret = attributeNameGetter.invoke(xmlBean);
            Class attributeNameArrayClass = ret.getClass();
            if (attributeNameArrayClass.isArray() && attributeNameArrayClass.getComponentType().equals(String.class))
            {
                Algorithm.add(attributeNameSet, (String[]) ret);
            }
        }
        catch (SecurityException e)
        {
            // do nothing
        }
        catch (NoSuchMethodException e)
        {
            // do nothing
        }
        catch (IllegalArgumentException e)
        {
            // do nothing
        }
        catch (IllegalAccessException e)
        {
            // do nothing
        }
        catch (InvocationTargetException e)
        {
            // do nothing
        }
        return attributeNameSet;
    }

}

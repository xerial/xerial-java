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
 * XML文書をクラス(XMLBean)にバインド、あるいは逆に、XMLBeanからXML文書を生成するためのツール。煩雑なSAXやDOMを使わなくても、XMLデータをクラスに読み書きできるようになる。
 * 
 * <p>
 * <b>XMLBeanの用件 </b>
 * </p>
 * <ul>
 * <li>populateメソッドを呼び出した側にとって、accessibleである引数無しのコンストラクタを持っていること。</li>
 * <li>
 * 子要素(あるいはattribute)に対応したsetterを持っていること。例えば、bookというタグのデータを読み込みたいなら、setBookというメソッドを作る
 * XMLのtextデータは引数の型に応じて自動で変換される。同じタグ名で複数の子要素がある場合は、配列型をsetterの引数にすること。
 * そうしない場合、一番最後に読み込まれたbookのデータで、前のデータは上書きされる。</li>
 * <li>階層化されたXMLBean（つまり、XMLBeanの中にXMLBeanのsetterを持つ）を利用することもできる。</li>
 * </ul>
 * <p>
 * Beanの内容をXMLとして出力するためには
 * </p>
 * <ul>
 * <li>publicなgetter(getSomething()というメソッド）を用意する。返り値がString,
 * Integer等のPremitiveの場合はそれがそのままメソッド名からgetを取り除いたタグ名を持つ子要素として出力される。</li>
 * <li>public String[]
 * attributes()というメソッドがあれば、そこに記されている名前に対応するgetterでの出力は、attributeとして出力される </li>
 * <li>null値がgetterの返り値の場合、その要素は出力されない。したがって、filedはnullで初期化しておくことを推奨する </li>
 * <li></li>
 * </ul>
 * 
 * <p>
 * <b>注意事項 </b>
 * </p>
 * <ul>
 * <li>テキストのみの子要素と、attributeは区別されない。</li>
 * <li>現在のところ、先頭文字がCapitalizeされたtag名は扱えない</li>
 * </ul>
 * 
 * たとえば、以下のようなXML文書を読み込むには、
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
 * 下記のようなクラスを書く。
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
 * XML文書からBooklistのオブジェクトを生成するコードは、
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
 *       // データをbindするのに失敗した場合 (より詳しい原因ごとに対処するには、InvalidXMLException, XMLParserException, XMLBeanExceptionをcatchする）
 *   }
 *   catch (IOException e)
 *   {
 *       // XMLファイルが見つからない、あるいは、ストリームの入力に失敗したとき  
 *   }
 *   
 *  
 * </pre>
 * 
 * BooklistのインスタンスからXMLを生成するには
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
     * XML文書のstreamから、XMLBeanのクラスのインスタンスを生成する。InputStreamは、EndTagの次の状態まで進む
     * 
     * 
     * @param <E>
     *            XMLBeanの型
     * @param xmlBeanClass
     *            生成するクラス
     * @param xmlStream
     *            XMLの入力
     * @return XMLのデータがバインドされたXMLBeanのインスタンス
     * @throws IOException
     *             XMLの入力エラーで生じる
     * @throws XMLParserException
     *             pull
     *             parserの生成に失敗したとき。XmlPullParserのlibraryがCLASSPATHに含まれていないのが主な原因
     * @throws XMLBeanException
     *             XMLBeanの生成、setterの呼び出しに失敗したとき
     * @throws InvalidXMLException
     *             XML文書が適切なフォーマットでない場合など
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
     * XML文書のpull parserから、XMLBeanのクラスのインスタンスを生成する。pull parserはEND_TAGを指した状態で返る
     * 
     * @param <E>
     *            XMLBeanの型
     * @param xmlBeanClass
     *            生成するクラス
     * @param pullParser
     *            pull parserのインスタンス。
     * @return XMLのデータがバインドされたXMLBeanのインスタンス
     * @throws IOException
     *             XMLの入力エラーで生じる
     * @throws XMLBeanException
     *             XMLBeanの生成、setterの呼び出しに失敗したとき
     * @throws InvalidXMLException
     *             XML文書が適切なフォーマットでない場合など
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
     * pull parserからXMLのelementを読んで、xmlBeanを埋める。 pull parserは、END_TAGを指した状態で返る
     * 
     * @param xmlBean
     *            XMLBeanのインスタンス
     * @param pullParser
     *            pull parserのインスタンス
     * @throws IOException
     *             XMLの入力エラーで生じる
     * @throws XMLBeanException
     *             XMLBeanの生成、setterの呼び出しに失敗したとき
     * @throws InvalidXMLException
     *             XML文書が適切なフォーマットでない場合など
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
     * pull parserからXMLのelementを読んで、xmlBeanを埋める。 pull parserは、END_TAGを指した状態で返る
     * 
     * @param xmlBean
     *            XMLBeanのインスタンス
     * @param xmlStream
     *            xml文書の入力
     * @throws IOException
     *             XMLの入力エラーで生じる
     * @throws XMLBeanException
     *             XMLBeanの生成、setterの呼び出しに失敗したとき
     * @throws InvalidXMLException
     *             XML文書が適切なフォーマットでない場合など
     * @throws XMLParserException
     *             PullParserの生成に失敗したとき。pullparserのライブラリがCLASSPATHに含まれていないことが主な原因
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
     * XMLをparseして、実際にクラスにbindするクラス
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
         * 現在見ているタグの列を識別するのに使う。例えば、
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
         * というXML中のbookのタグには、すべて同じParseContextが割り当てられる
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
                // 最初のタグにたどり着くまでparseを進める
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
            TreeMap<ParseContext, BindRule> bindRuleContainer = new TreeMap<ParseContext, BindRule>(); // arrayをバインドするルールを格納しておく

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
                    tagName = tagName.replace('-', '_'); // Javaでは、-をクラス、メソッド名に使用できないので
                    tagName = tagName.toLowerCase(); // タグ名の大文字、小文字の違いを無視
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
                        // TODO START_TAG, TEXT, END_TAGという組み合わせでない場合の対処
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
     * XMLの要素をどのよううに処理するかを定義するためのクラス
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
         * 子要素をそのままデータとして格納する際に使うRule
         * 
         * @param methodForBinding
         *            bindする際に呼び出すメソッド
         * @param argType
         *            メソッドの引数の型
         */
        public BindRule(Method methodForBinding, String argType)
        {
            bindType = BindType.invokeMethod;
            this.methodForBinding = methodForBinding;
            if (argType.endsWith("[]"))
            {
                // 配列の場合
                isArrayType = true;
                this.argType = argMap.get(argType.substring(0, argType.length() - 2));
            }
            else
                this.argType = argMap.get(argType);
        }

        /**
         * XMLBeanの中に、XMLBeanがあるときに使うRule
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
     * XMLのPath->データ型 という形式のbind rule を作るクラス
     * 
     * @author leo
     * 
     */
    static private class BindRuleCreationProcess
    {

        /**
         * DataGuideのノードIDからBindRuleのセット
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
                    if (parameterType.length != 1) // 一引数以外のsetterは使えない
                        continue;

                    String tagOrAttributeName = pickPropertyName(methodName, SetterOrGetter.set);
                    if (tagOrAttributeName == null)
                        continue;

                    int nextDataGuideNodeID = _dataGuide.newTag(tagOrAttributeName.toLowerCase());
                    Class argType = parameterType[0];
                    if (isPrimitive(argType))
                    {
                        // primitive typeの場合はelement or attributeを直接bindする
                        // TODO attribute と tag elementの区別をつけるか？
                        _bindRule.put(nextDataGuideNodeID, new BindRule(m, argType.getSimpleName()));
                    }
                    else
                    {
                        // primitive でない場合
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
     *            setSomething, getSomethingなどのメソッド名
     * @param patternType
     *            set(ter) or get(ter)
     * @return メソッド名から先頭のset/getを取り除いた文字列の先頭をlower caseに変換したString.
     *         切り出せない場合は、null を返す/
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
     * Class c がprimitive type(int(Integer), String, double(Double),
     * float(Float))かどうか、あるいはその配列か判定
     * 
     * @param c
     * @return primivtive かどうか
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
     * xmlBeanの内容をXMLの要素として出力する。
     * 
     * @param xmlBean
     *            出力元
     * @param out
     *            出力先
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
 * XMLBeanからXMLを生成するクラス
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
     * Object getSomething()というメソッドがある場合、 返り値のObjectによって場合分け。 primitive type:
     * そのままXML elementとして出力 collection : 各要素に対し、再帰操作 それ以外:
     * beanとみなし、これを親要素として、各getterに対し再帰
     * 
     * @param beanClass
     */
    protected void inspectGettersInXMLBean(Object xmlBean)
    {
        Class beanClass = xmlBean.getClass();
        if (_outputRuleOfEachClass.containsKey(beanClass)) // すでに調べたことのあるクラスか？
            return;

        OutputRuleSet outputRuleSet = new OutputRuleSet(beanClass);
        _outputRuleOfEachClass.put(beanClass, outputRuleSet); // 仮エントリを登録しておく

        Set<String> attributeNameSet = inspectAttributeNames(xmlBean);

        Method[] method = beanClass.getMethods();
        for (Method m : method)
        {
            String methodName = m.getName();
            if (methodName.equals("getClass"))
                continue; // Object
            // classのメソッドは無視

            if (!methodName.startsWith("get") || methodName.length() <= 3) // is
                // setter?
                continue;
            Class[] parameterType = m.getParameterTypes();
            if (parameterType.length != 0) // 0引数以外のgetterは使えない
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

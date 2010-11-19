/*--------------------------------------------------------------------------
 *  Copyright 2008 Taro L. Saito
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
// AquaWikiWalker.java
// Since: Apr 22, 2008 10:46:34 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.maven.doxia.aqua;

import java.io.Writer;
import java.lang.reflect.Method;
import java.util.LinkedList;

import org.apache.maven.doxia.sink.Sink;
import org.xerial.wiki.WikiException;
import org.xerial.wiki.WikiWriter;
import org.xerial.wiki.WikiWriterBase;

/**
 * Wiki writer for maven site generation
 * 
 * @author leo
 * 
 */
public class AquaWikiWriter extends WikiWriterBase
{
    private final Sink sink;
    private int currentListDepth = 0;
    private boolean isInSection = false;

    public AquaWikiWriter(final Sink sink)
    {
        this.sink = sink;
    }

    public void beginBody() throws WikiException
    {
        sink.body();
    }

    public void beginBold() throws WikiException
    {
        sink.bold();
    }

    public void beginItaric() throws WikiException
    {
        sink.italic();
    }

    public void beginItem(int level) throws WikiException
    {
        sink.listItem();
    }

    public void beginLink(String ref, String target) throws WikiException
    {
        sink.anchor(target);
        sink.link(ref);
    }

    public void beginSection(int level) throws WikiException
    {
        endSection();
        sink.section1();
        isInSection = true;
    }

    public void beginVerbatim() throws WikiException
    {
        sink.verbatim(false);
    }

    public void endBody() throws WikiException
    {
        sink.body_();
    }

    public void endBold() throws WikiException
    {
        sink.bold_();
    }

    public void endItaric() throws WikiException
    {
        sink.italic_();
    }

    public void endItem() throws WikiException
    {
        sink.listItem_();
    }

    public void endLink() throws WikiException
    {
        sink.anchor_();
    }

    public void invokeSinkMethod(String methodName)
    {
        try
        {
            Method m = Sink.class.getMethod(methodName, new Class[] {});
            m.invoke(sink, new Object[] {});
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("invoke sink." + methodName + " failed");
        }
    }

    public void endSection() throws WikiException
    {
        if (isInSection)
            sink.section1_();
        isInSection = false;
    }

    public void endVerbatim() throws WikiException
    {
        sink.verbatim_();
    }

    public void newLine() throws WikiException
    {
        sink.lineBreak();
    }

    public void render(Writer writer) throws WikiException
    {
        throw new UnsupportedOperationException("AquaWikiWriter#render");
    }

    public void setTitle(String title) throws WikiException
    {
        sink.head();
        sink.title();
        sink.text(title);
        sink.title_();
        sink.head_();
    }

    public void text(String text) throws WikiException
    {
        sink.text(text);
    }

    public void beginParagraph() throws WikiException
    {
        sink.paragraph();
    }

    public void endParagraph() throws WikiException
    {
        sink.paragraph_();
    }

    public void beginSectionTitle(int level) throws WikiException
    {
        invokeSinkMethod("sectionTitle" + level);
    }

    public void endSectionTitle(int level) throws WikiException
    {
        invokeSinkMethod("sectionTitle" + level + "_");
    }

    public void beginImage(String href, String label) throws WikiException
    {
        sink.figure();
        sink.figureCaption();
        sink.text(label);
        sink.figureCaption_();
        sink.figureGraphics(href);
    }

    public void endImage() throws WikiException
    {
        sink.figure_();

    }

    public void beginOrderedList() throws WikiException
    {
        sink.numberedList(1);
    }

    public void beginUnorderedList() throws WikiException
    {
        sink.list();
    }

    public void endOrderedList() throws WikiException
    {
        sink.numberedList_();
    }

    public void endUnorderedList() throws WikiException
    {
        sink.list_();

    }

    public void beginAnchor(String name) throws WikiException
    {
        sink.anchor(name);
    }

    public void endAnchor() throws WikiException
    {
        sink.anchor_();
    }

    public void rawText(String text) throws WikiException
    {
        sink.rawText(text);
    }
}

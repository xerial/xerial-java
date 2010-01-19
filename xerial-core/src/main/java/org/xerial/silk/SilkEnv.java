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
// SilkEnv.java
// Since: Feb 9, 2009 5:43:18 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk;

import java.io.File;
import java.net.MalformedURLException;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.silk.model.SilkFunction;
import org.xerial.silk.model.SilkNode;
import org.xerial.util.ArrayDeque;
import org.xerial.util.Deque;
import org.xerial.util.log.Logger;

/**
 * Environment variable holder for evaluating Silk functions.
 * 
 * @author leo
 * 
 */
public class SilkEnv {
    private static Logger _logger = Logger.getLogger(SilkEnv.class);

    private int indentationOffset = 0;
    private String resourceBasePath = null;
    private Deque<SilkContext> contextNodeStack = new ArrayDeque<SilkContext>();
    public int contextNodeAttributeCursor = 0;
    public boolean isAttributeOpen = false;

    private SilkEnv(SilkEnv parent, int indentationOffset) {
        this.indentationOffset = indentationOffset;
        this.resourceBasePath = parent.resourceBasePath;
        this.contextNodeStack = parent.contextNodeStack;
        this.contextNodeAttributeCursor = parent.contextNodeAttributeCursor;
        this.isAttributeOpen = parent.isAttributeOpen;
        //this.eventQueue = parent.eventQueue;

    }

    private SilkEnv(SilkEnv parent, String resourceBasePath) {
        this.indentationOffset = parent.indentationOffset;
        // use input resource base path
        this.resourceBasePath = resourceBasePath;
        this.contextNodeStack = parent.contextNodeStack;
        this.contextNodeAttributeCursor = parent.contextNodeAttributeCursor;
        this.isAttributeOpen = parent.isAttributeOpen;
        //this.eventQueue = parent.eventQueue;

    }

    private SilkEnv(String resourceBasePath) {
        this.resourceBasePath = resourceBasePath;
    }

    public static SilkEnv newEnv() {
        return newEnv(null);
    }

    public static SilkEnv newEnv(SilkEnv parent, String resourceBasePath) {
        return new SilkEnv(parent, resourceBasePath);
    }

    public static SilkEnv newEnv(String resourceBasePath) {
        if (resourceBasePath != null)
            return new SilkEnv(resourceBasePath);
        else {
            File base = new File(System.getProperty("user.dir", ""));
            try {
                return new SilkEnv(base.toURI().toURL().toExternalForm());
            }
            catch (MalformedURLException e) {
                throw new XerialError(XerialErrorCode.INVALID_STATE, e);
            }
        }
    }

    public SilkEnv newEnvFor(SilkFunction f) {
        int offset = indentationOffset;

        if (f.getIndentLevel() == SilkFunction.NO_INDENT) {
            SilkNode contextNode = getContextNode();
            if (contextNode != null)
                offset = contextNode.getIndentLevel();
        }
        else
            offset = f.getIndentLevel();

        return new SilkEnv(this, offset);
    }

    public Logger getLogger() {
        return _logger;
    }

    /**
     * Get the baseline indentation level
     * 
     * @return the baseline indentation
     */
    public int getIndentationOffset() {
        return indentationOffset;
    }

    /**
     * Get the base path for finding resources, e.g. import files.
     * 
     * @return the resource base path
     */
    public String getResourceBasePath() {
        return resourceBasePath;
    }

    Deque<SilkContext> getContextNodeStack() {
        return contextNodeStack;
    }

    public void pushContext(SilkContext context) {
        contextNodeStack.addLast(context);
    }

    public boolean isContextNodeStackEmpty() {
        return contextNodeStack.isEmpty();
    }

    public SilkContext peekLastContext() {
        return contextNodeStack.peekLast();
    }

    public SilkContext popLastContext() {
        return contextNodeStack.removeLast();
    }

    /**
     * Get the context node
     * 
     * @return
     */
    public SilkNode getContextNode() {
        if (contextNodeStack.isEmpty())
            return null;
        else
            return contextNodeStack.getLast().contextNode;
    }

}

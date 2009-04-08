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
// Import.java
// Since: Feb 9, 2009 3:40:27 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.silk.plugin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.silk.SilkEnv;
import org.xerial.silk.SilkStreamReader;
import org.xerial.util.FileType;
import org.xerial.util.io.Base64OutputStream;
import org.xerial.util.tree.TreeEvent;
import org.xerial.util.tree.TreeStreamReader;
import org.xerial.util.xml.impl.TreeEventQueue;

/**
 * <em>import</em> function
 * 
 * @author leo
 * 
 */
public class Import implements SilkFunctionPlugin
{

    @SilkFunctionArgument
    String filePath = null;

    private TreeStreamReader reader = null;
    private SilkEnv env;

    private static class EmptyReader implements TreeStreamReader
    {

        public TreeEvent next() throws XerialException
        {
            return null;
        }

        public TreeEvent peekNext() throws XerialException
        {
            return null;
        }

    }

    public void init(SilkEnv env) throws XerialException
    {
        this.env = env;

        if (filePath == null)
        {
            env.getLogger().warn("no file path is specified");
            reader = new EmptyReader();
            return;
        }

        try
        {
            String url = env.getResourceBasePath();
            if (!env.getResourceBasePath().endsWith("/"))
                url += "/";
            url += filePath;

            FileType f = FileType.getFileType(filePath);
            switch (f)
            {
            case SILK:
            case TAB:
            {
                reader = new SilkStreamReader(new URL(url), env);
                break;
            }
            case JPEG:
            case GIF:
            case BMP:
            case PDF:
            case PS:
            case TIFF:
            case WORD:
            case EXCEL:
            case POWER_POINT:
            case PNG:
            {
                reader = new BinaryReader(new URL(url), env);
            }
                break;
            default:
            {
                reader = new SilkStreamReader(new URL(url), env);
                break;
            }
            }
        }
        catch (IOException e)
        {
            throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
        }

    }

    private void validate()
    {
        if (env == null)
            throw new XerialError(XerialErrorCode.INVALID_STATE, "env is null");

        if (reader == null)
            throw new XerialError(XerialErrorCode.NOT_INITIALIZED);

    }

    public TreeEvent peekNext() throws XerialException
    {
        validate();
        return reader.peekNext();
    }

    public TreeEvent next() throws XerialException
    {
        validate();
        return reader.next();
    }

    private static class BinaryReader implements TreeStreamReader
    {
        private URL resourceURL;
        private SilkEnv env;
        private InputStream source;
        private BufferedInputStream in;
        private byte[] buffer = new byte[1024];

        private TreeEventQueue eventQueue = new TreeEventQueue();
        private boolean hasFinished = false;

        private BinaryReader(URL resourceURL, SilkEnv env)
        {
            if (resourceURL == null)
                throw new XerialError(XerialErrorCode.INVALID_INPUT);

            this.resourceURL = resourceURL;
            this.env = env;

            try
            {
                this.source = this.resourceURL.openStream();
                this.in = new BufferedInputStream(source);

            }
            catch (IOException e)
            {
                throw new XerialError(XerialErrorCode.IO_EXCEPTION, e);
            }
        }

        public TreeEvent peekNext() throws XerialException
        {
            if (eventQueue.isEmpty())
            {
                if (hasFinished)
                    return null;

                fillQueue();
                return peekNext();
            }
            else
            {
                return eventQueue.peekFirst();
            }
        }

        public TreeEvent next() throws XerialException
        {
            if (eventQueue.isEmpty())
            {
                if (hasFinished)
                    return null;

                fillQueue();
                return next();
            }
            else
            {
                return eventQueue.pop();
            }
        }

        public void fillQueue() throws XerialException
        {
            if (hasFinished)
                return;

            String nodeName = env.getContextNode().getName();

            try
            {
                int readBytes = 0;
                if ((readBytes = in.read(buffer, 0, buffer.length)) != -1)
                {
                    // encode buffer data with Base64
                    ByteArrayOutputStream base64buffer = new ByteArrayOutputStream(readBytes);
                    Base64OutputStream base64out = new Base64OutputStream(base64buffer);
                    base64out.write(buffer, 0, readBytes);
                    base64out.flush();

                    String[] fragment = new String(base64buffer.toByteArray()).split("\\r\\n");
                    if (fragment == null)
                        return;
                    for (String each : fragment)
                    {
                        eventQueue.push(TreeEvent.newTextEvent(nodeName, each));
                    }
                }

                if (readBytes == -1)
                    hasFinished = true;

            }
            catch (IOException e)
            {
                throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
            }

        }

    }

}

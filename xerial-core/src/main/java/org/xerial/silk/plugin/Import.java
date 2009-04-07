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

    private enum State {
        INIT, READY
    }

    private State currentState = State.INIT;
    private TreeStreamReader reader = null;

    public TreeEvent next(SilkEnv env) throws XerialException
    {
        switch (currentState)
        {
        case INIT:
        {
            if (filePath == null)
            {
                env.getLogger().warn("no file path is specified");
                return null;
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
                    currentState = State.READY;
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
                    currentState = State.READY;
                }
                    break;
                default:
                {
                    reader = new SilkStreamReader(new URL(url), env);
                    currentState = State.READY;
                    break;
                }
                }
                return next(env);
            }
            catch (IOException e)
            {
                throw new XerialException(XerialErrorCode.IO_EXCEPTION, e);
            }
        }
        case READY:
        default:
            if (reader == null)
                throw new XerialError(XerialErrorCode.NOT_INITIALIZED);

            return reader.next();
        }
    }

    private class BinaryReader implements TreeStreamReader
    {
        private URL resourceURL;
        private SilkEnv env;
        private InputStream source;
        private BufferedInputStream in;
        byte[] buffer = new byte[1024];
        int readBytes = 0;

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

        public TreeEvent next() throws XerialException
        {

            while ((readBytes = in.read(buffer, 0, buffer.length)) != -1)
            {
                ByteArrayOutputStream base64buffer = new ByteArrayOutputStream(readBytes);
                Base64OutputStream base64out = new Base64OutputStream(base64buffer);
                base64out.write(buffer, 0, readBytes);
                base64out.flush();
                String[] fragment = new String(base64buffer.toByteArray()).split("\\r\\n");
                for (String each : fragment)
                    env.getTreeVisitor().text(each, env.getTreeWalker());
            }
        }

    }

    public void loadBinary(URL path, SilkEnv env) throws IOException, XerialException
    {
        env.getLogger().debug("load binary: " + path);

    }

}

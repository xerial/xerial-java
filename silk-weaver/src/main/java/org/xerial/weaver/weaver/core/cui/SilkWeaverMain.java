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
// Xerial Silk Weaver Project 
//
// SilkWeaverMain.java
// Since: 2009/06/24 20:26:27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.weaver.core.cui;

import java.net.URL;

import org.xerial.core.ReturnCode;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;
import org.xerial.util.opt.Usage;
import org.xerial.xml.XMLLens;

/**
 * Command-line interface of the Silk Weaver
 * 
 * @author leo
 * 
 */
@Usage(command = "> weaver [option] ", description = "SilkWeaver: A Scalable Parallel DBMS for Structured Data")
public class SilkWeaverMain extends SilkWeaverModuleBase {
    private static Logger _logger = Logger.getLogger(SilkWeaverMain.class);

    /**
     * Entry point of the CUI interface. If you want to execute a SilkWeaver
     * command within a program, use {@link #execute(String[])} since this main
     * method invokes System.exit(returnCode) to pass the return code to the
     * JVM, then terminate the JVM.
     * 
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        int ret = execute(args);
        System.exit(ret);
    }

    /**
     * 
     * 
     * @param args
     * @return
     */
    public static int execute(String[] args) {

        SilkWeaverMain m = new SilkWeaverMain();

        OptionParser parser = new OptionParser(m);
        try {
            parser.setIgnoreUnknownOption(true);
            parser.parse(args);
            return m.execute(null, parser.getUnusedArguments());
        }
        catch (OptionParserException e) {
            _logger.error(e.getMessage());
            parser.printUsage();

            return ReturnCode.EINVAL.toInt();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ReturnCode.FAILURE.toInt();
        }
    }

    public SilkWeaverMain() {
        super(Package.getPackage("org.xerial.weaver.core.cui"));
    }

    public String getCommandName() {
        return null;
    }

    public String getOneLineDescription() {
        return "silk weaver";
    }

    public String getProgramInfo() {
        VersionInfo vi = getVersionInfo();
        return String.format("Silk Weaver: version %s", vi.version);
    }

    public static class VersionInfo {
        public String version = "(unknown)";

        public void addDependency_Version(String d, String v) {

        }

        public void addPlugin_Version(String p, String v) {

        }

        public void addParent_Version(String p, String v) {

        }
    }

    public static VersionInfo getVersionInfo() {
        URL pomFile = Thread.currentThread().getContextClassLoader()
                .getResource("META-INF/maven/org.xerial/xerial-core/pom.xml");

        VersionInfo vi = new VersionInfo();
        if (pomFile != null) {
            try {
                XMLLens.loadXML(vi, pomFile);
            }
            catch (Exception e) {
                _logger.error(e);
            }
        }

        return vi;

    }

}

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

import org.xerial.lens.Lens;
import org.xerial.util.log.Logger;
import org.xerial.util.opt.OptionParser;
import org.xerial.util.opt.OptionParserException;
import org.xerial.util.opt.Usage;
import org.xerial.weaver.bio.bisulfite.BisulfiteModule;

/**
 * Command-line interface of the Silk Weaver
 * 
 * @author leo
 * 
 */
@Usage(command = "> weaver [option] ", description = "SilkWeaver")
public class SilkWeaverMain extends SilkWeaverModuleBase {
    private static Logger _logger = Logger.getLogger(SilkWeaverMain.class);

    /**
     * Entry point of the CUI interface
     * 
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        SilkWeaverMain m = new SilkWeaverMain();
        m.addModule(new BisulfiteModule());

        OptionParser parser = new OptionParser(m);
        try {
            parser.setIgnoreUnknownOption(true);
            parser.parse(args);
            m.execute(null, parser.getUnusedArguments());
        }
        catch (OptionParserException e) {
            _logger.error(e.getMessage());
            parser.printUsage();
        }
        catch (Exception e) {
            e.printStackTrace();
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
        return String.format("Silk Weaver: version %s (%s)", vi.version, vi.revision);
    }

    public static class VersionInfo {
        public String version = "(unknown)";
        private String revision = "Revision: unknown";

        public void setRevision(String rev) {
            if (rev != null && rev.length() > 1)
                revision = rev.substring(1, rev.length() - 1).trim();
        }

        public String getRevision() {
            return revision;
        }

        public void addDependency_Version(String d, String v) {

        }

        public void addPlugin_Version(String p, String v) {

        }

        public void addParent_Version(String p, String v) {

        }
    }

    public static VersionInfo getVersionInfo() {
        URL pomFile = Thread.currentThread().getContextClassLoader().getResource(
                "META-INF/maven/org.xerial.weaver/silk-weaver/pom.xml");

        VersionInfo vi = new VersionInfo();
        if (pomFile != null) {
            try {
                Lens.loadXML(vi, pomFile);
            }
            catch (Exception e) {
                _logger.error(e);
            }
        }

        return vi;

    }

}

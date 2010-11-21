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
// ANTLRMojo.java
// Since: Sep 15, 2007 7:42:51 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.maven.plugin.antlr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.Tool;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * 
 * @phase generate-sources
 * @goal generate
 * @requiresDependencyResolution compile
 * @author leo
 * 
 */
public class ANTLRMojo extends AbstractMojo
{
    /**
     * The source directories containing the sources to be compiled.
     * 
     * @parameter expression="${basedir}/src/main/java"
     * @required
     */
    private String sourceDirectory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if (sourceDirectory == null)
            throw new MojoExecutionException("no source folder is specified");

        ArrayList<File> grammarFileList = new ArrayList<File>();

        getLog().info("source folder: " + sourceDirectory);
        findGrammarFiles(new File(sourceDirectory), grammarFileList);

        for (File grammarFile : grammarFileList) {
            getLog().debug("grammar file: " + grammarFile.getPath());
            String fileName = grammarFile.getName();
            File outputFolder = grammarFile.getParentFile();
            getLog().debug("output folder: " + outputFolder.getPath());

            int extPos = fileName.indexOf(".g");
            String tokenFileName = fileName.substring(0, extPos) + ".tokens";
            File tokenFile = new File(outputFolder, tokenFileName);
            getLog().debug("lexer file: " + tokenFile.getName());

            if (!tokenFile.exists() || (grammarFile.lastModified() > tokenFile.lastModified())) {
                getLog().info("run ANTLR: " + grammarFile.getName());

                // compile
                //                String[] args = new String[] { grammarFile.getPath(), "-lib", outputFolder.getPath() };
                //
                //                for (String arg : args)
                //                    getLog().debug("arg: " + arg);

                Tool antlrCompiler = new Tool();
                antlrCompiler.setInputDirectory(grammarFile.getParent());
                antlrCompiler.setOutputDirectory(outputFolder.getPath());
                antlrCompiler.setForceAllFilesToOutputDir(true);
                antlrCompiler.setForceRelativeOutput(true);
                antlrCompiler.addGrammarFile(grammarFile.getName());
                antlrCompiler.process();
            }
            else {
                getLog().debug(grammarFile.getName() + " is already processed.");
            }
        }

    }

    private void findGrammarFiles(File dir, List<File> foundFileList) {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                findGrammarFiles(f, foundFileList);
            else {
                String fileName = f.getName();
                if (fileName.endsWith(".g") && !fileName.endsWith("_.g")) {
                    foundFileList.add(f);
                }
            }
        }

    }

}

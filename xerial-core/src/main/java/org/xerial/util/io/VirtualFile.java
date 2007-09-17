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
// VirtualFile.java
// Since: Sep 14, 2007 9:07:59 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.io;

import java.net.URL;

/**
 * VirtualFile is a common interface to handle system files and file resources in JAR.
 * 
 * System file resources have an URL prefixed with "file:". 
 *   e.g., "file:/C:/Program Files/Software/classes/org/xerial/util/FileResource.java"
 * JAR file contents have an URL prefixed with "jar:file:
 *   e.g., "jar:file:/C:/Program Files/Software/something.jar!/org/xerial/util/FileResource.java"  
 * 
 * @author leo
 *
 */
public interface VirtualFile
{
    /**
     * Gets the logical path of the file.
     * For example, if this VirtualFile' URL is "file:/somewhere/org/xerial/util/FileResource.java", 
     * its logical name is org/xerial/util/FileResource.java, beginning from the root package.
     * @return
     */
    String getLogicalPath();
    
    /**
     * is directory? 
     * @return true when the file is a directory, otherwise false
     */
    boolean isDirectory();
    
    /**
     * Gets the URL of this file
     * @return
     */
    URL getURL();
    
}

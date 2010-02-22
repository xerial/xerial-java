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
// FileType.java
// Since: Feb 10, 2009 10:38:10 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File type notation
 * 
 * @author leo
 * 
 */
public enum FileType {

    UNKNOWN(""),

    // image formats
    JPEG("jpeg,jpg"), PNG("png"), GIF("gif"), BMP("bmp"), TIFF("tiff"),

    // text formats
    XML("xml"), JSON("json"), SILK("silk"), TAB("tab"), CSV("csv"), FASTA("fasta,fa,fs"), TEX("tex"), TEXT(
            "txt"),

    // HTML formats
    HTML("html,htm"),

    // binary format
    PDF("pdf"), PS("ps"), WORD("doc,docx"), EXCEL("xls,xlsx"), POWER_POINT("ppt,pptx"),

    // compressed format
    ZIP("zip"), GZIP("gz,gzip"), TAR("tar"), TAR_GZ("tar.gz"), BZIP2("bz2")

    ;

    private static HashMap<String, FileType> fileTypeTable = new HashMap<String, FileType>();
    static {
        for (FileType eachType : FileType.values()) {
            for (String eachExt : eachType.getFileExtList())
                fileTypeTable.put(eachExt, eachType);
        }
    }

    private ArrayList<String> fileExtList;

    private FileType() {
        fileExtList = new ArrayList<String>(0);
    }

    private FileType(String fileExtCSV) {
        String[] fileExt = fileExtCSV.split(",\\s*");
        assert (fileExt != null);
        fileExtList = new ArrayList<String>(fileExt.length);
        for (String each : fileExt) {
            fileExtList.add(each);
        }
    }

    public List<String> getFileExtList() {
        return fileExtList;
    }

    /**
     * Retrieve file type
     * 
     * @param fileExt
     * @return
     */
    public static FileType getFileTypeFromFileExt(String fileExt) {
        FileType f = fileTypeTable.get(fileExt.toLowerCase());
        if (f == null)
            return UNKNOWN;
        else
            return f;
    }

    public static FileType getFileType(String filePath) {
        if (filePath.endsWith("tar.gz"))
            return getFileTypeFromFileExt("tar.gz");

        int extPos = filePath.lastIndexOf(".");
        if (extPos <= 0)
            return UNKNOWN;
        else
            return getFileTypeFromFileExt(filePath.substring(extPos + 1));
    }

    public static String removeFileExt(String filePath) {

        if (filePath.endsWith("tar.gz"))
            return filePath.substring(0, filePath.length() - "tar.gz".length() - 1);

        int extPos = filePath.lastIndexOf(".");
        if (extPos <= 0)
            return filePath;
        else
            return filePath.substring(0, extPos);

    }

}

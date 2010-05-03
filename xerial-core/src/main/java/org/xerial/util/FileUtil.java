/*--------------------------------------------------------------------------
 *  Copyright 2010 Taro L. Saito
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
// FileUtil.java
// Since: May 3, 2010 12:01:12 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.xerial.util.io.VirtualFile;
import org.xerial.util.log.Logger;

/**
 * Utilities for managing files
 * 
 * @author leo
 * 
 */
public class FileUtil {

    private static Logger _logger = Logger.getLogger(FileUtil.class);

    public static class CopyConfig {
        public int BLOCK_SIZE = 64 * 1024; // use 64 KB block size  
    }

    /**
     * Create a temporary folder with the given prefix
     * 
     * @param dir
     *            target folder
     * @param prefix
     *            prefix of the directory name
     * @return path to the created folder
     */
    public static File createTempDir(File dir, String prefix) {
        File tmpDir = new File(dir, prefix);
        int suffixNum = 1;
        while (tmpDir.exists()) {
            tmpDir = new File(dir, prefix + suffixNum++);
        }
        tmpDir.mkdirs();
        return tmpDir;
    }

    public static File createTempFile(File dir, String prefix, String suffix) throws IOException {
        return File.createTempFile(prefix, suffix, dir);
    }

    public static void copyResourceDir(String inputResourcePath, String outputDir)
            throws IOException {
        if (_logger.isDebugEnabled())
            _logger.debug(String.format("copy from %s to %s", inputResourcePath, outputDir));

        // create the base folder for the scaffold
        File outputFolder = new File(outputDir);
        List<VirtualFile> scaffoldResourcesList = FileResource.listResources(inputResourcePath);
        // remove duplicates from resources
        ArrayList<VirtualFile> scaffoldResources = new ArrayList<VirtualFile>();
        {
            HashSet<String> observedPath = new HashSet<String>();
            for (VirtualFile vf : scaffoldResourcesList) {
                if (!observedPath.contains(vf.getLogicalPath())) {
                    observedPath.add(vf.getLogicalPath());
                    scaffoldResources.add(vf);
                }
            }
        }
        if (scaffoldResources.size() <= 0)
            throw new FileNotFoundException(inputResourcePath + " is not found");

        // sync scaffoldDir with the output folder
        for (VirtualFile vf : scaffoldResources) {
            String srcLogicalPath = vf.getLogicalPath();
            if (vf.isDirectory()) {
                mkdirs(new File(outputFolder, srcLogicalPath));
            }
            else {
                String outputFileName = srcLogicalPath;
                File targetFile = new File(outputFolder, outputFileName);
                File parentFolder = targetFile.getParentFile();
                mkdirs(parentFolder);

                // copy the file content
                InputStream reader = vf.getURL().openStream();
                _logger.debug("create a file: " + targetFile);
                copy(reader, targetFile);
            }
        }
    }

    public static void mkdirs(File path) {
        if (!path.exists()) {
            _logger.debug("create a dir: " + path);
            path.mkdirs();
        }
    }

    /**
     * remove directory and its contents
     * 
     * @param path
     */
    public static void rmdir(File path) {
        if (path.exists()) {
            for (File each : path.listFiles()) {
                if (each.isDirectory())
                    rmdir(each);
                else {
                    each.delete();
                }
            }
        }
        path.delete();
    }

    public static void copy(InputStream input, File dest) throws IOException {
        copy(input, dest, new CopyConfig());
    }

    public static void copy(InputStream input, File dest, CopyConfig config) throws IOException {

        ReadableByteChannel in = Channels.newChannel(input);
        WritableByteChannel out = Channels.newChannel(new FileOutputStream(dest));
        try {
            ByteBuffer buffer = ByteBuffer.allocate(config.BLOCK_SIZE);
            buffer.clear();
            while ((in.read(buffer)) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }
        finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }

    }

    public static void copy(File source, File dest) throws IOException {
        copy(source, dest, new CopyConfig());
    }

    public static void copy(File source, File dest, CopyConfig config) throws IOException {

        FileChannel in = null, out = null;
        try {
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(dest).getChannel();

            final long fileSize = in.size();
            long cursor = 0;

            while (cursor < fileSize) {
                long dataSizeToSend = (fileSize - cursor) < config.BLOCK_SIZE ? fileSize - cursor
                        : config.BLOCK_SIZE;
                long bytesTransferred = in.transferTo(cursor, dataSizeToSend, out);
                cursor += bytesTransferred;
            }

        }
        finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }

    }

    public static String sha1(File f) throws IOException {
        return toHexString(sha1hash(f));
    }

    public static String sha1(InputStream in) throws IOException {
        return toHexString(sha1hash(in));
    }

    private final static char[] HEX = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    private static String toHexString(byte[] value) {
        StringBuilder s = new StringBuilder(value.length);
        for (int i = 0; i < value.length; ++i) {
            byte v = value[i];
            s.append(HEX[(v >>> 4) & 0x0F]);
            s.append(HEX[v & 0x0F]);
        }
        return s.toString();
    }

    public static byte[] sha1hash(File f) throws IOException {
        return sha1hash(new BufferedInputStream(new FileInputStream(f)));
    }

    public static byte[] sha1hash(InputStream input) throws IOException {
        final int SHA1_LENGTH = 20;
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            DigestInputStream digestInputStream = new DigestInputStream(input, digest);
            for (; digestInputStream.read() >= 0;) {

            }
            ByteArrayOutputStream sha1out = new ByteArrayOutputStream(SHA1_LENGTH);
            sha1out.write(digest.digest());
            return sha1out.toByteArray();
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-1 algorithm is not available: " + e);
        }
    }

    public static String md5sum(File file) throws IOException {
        return md5sum(new BufferedInputStream(new FileInputStream(file)));
    }

    /**
     * Computes the MD5 value of the input stream
     * 
     * @param input
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String md5sum(InputStream in) throws IOException {

        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            DigestInputStream digestInputStream = new DigestInputStream(in, digest);
            for (; digestInputStream.read() >= 0;) {

            }
            ByteArrayOutputStream md5out = new ByteArrayOutputStream();
            md5out.write(digest.digest());
            return md5out.toString();
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm is not available: " + e);
        }
        finally {
            in.close();
        }
    }

}

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
// BlobImpl.java
// Since: Jun 26, 2008 4:27:12 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.sql.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * {@link Blob} implementation to set/get blob data in a bean classe via
 * setter/getter methods
 * 
 * @author leo
 * 
 */
public class BlobImpl implements Blob
{
    byte[] rawData;

    public BlobImpl(byte[] data)
    {
        this.rawData = data;
    }

    public void free() throws SQLException
    {
        rawData = null;
    }

    public InputStream getBinaryStream() throws SQLException
    {
        return new ByteArrayInputStream(rawData);
    }

    public InputStream getBinaryStream(long pos, long length) throws SQLException
    {
        return new ByteArrayInputStream(rawData, (int) pos, (int) length);
    }

    public byte[] getBytes(long pos, int length) throws SQLException
    {
        if (pos > Integer.MAX_VALUE)
            throw new SQLException("cannot read position more than " + Integer.MAX_VALUE);

        if (rawData == null)
            return new byte[0];

        if (pos == 0 && length == rawData.length)
            return rawData;

        byte[] result = new byte[length];
        int offset = (int) pos;
        int max = offset + length;
        if (max > rawData.length)
        {
            max = rawData.length;
        }
        for (int i = offset; i < max; i++)
        {
            result[i - offset] = rawData[i];
        }
        return result;
    }

    public long length() throws SQLException
    {
        if (rawData == null)
            return 0;
        else
            return rawData.length;
    }

    public long position(byte[] pattern, long start) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    public long position(Blob pattern, long start) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    public OutputStream setBinaryStream(long pos) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    public int setBytes(long pos, byte[] bytes) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    public int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    public void truncate(long len) throws SQLException
    {
        throw new UnsupportedOperationException();

    }

}

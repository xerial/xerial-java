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
// Xerial Raquel Project
//
// ContainerManager.java
// Since: 2009/03/14 23:59:01
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.lens.relation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

import org.xerial.core.XerialError;
import org.xerial.core.XerialErrorCode;
import org.xerial.core.XerialException;
import org.xerial.lens.relation.schema.Schema;
import org.xerial.util.io.Buffer;
import org.xerial.util.io.BufferReader;
import org.xerial.util.io.BufferWriter;
import org.xerial.util.io.DBFile;
import org.xerial.util.io.DiskFile;
import org.xerial.util.log.Logger;

/**
 * @author leo
 * 
 */
public class ContainerManager {
    private static Logger _logger = Logger.getLogger(ContainerManager.class);

    private final int cacheCapasity;
    private int cachedByteSize = 0;
    private final TreeMap<Integer, TupleContainer> cache = new TreeMap<Integer, TupleContainer>();
    private final TreeMap<Integer, PageAddress> pageMap = new TreeMap<Integer, PageAddress>();
    private int pageCount = 0;

    // page ID linked list
    private static class PageIDChain extends ArrayList<Integer> {
        private static final long serialVersionUID = 1L;
    }

    private final HashMap<Schema, PageIDChain> addressChainOfEachRelation = new HashMap<Schema, PageIDChain>();

    // LRU
    private final LinkedHashSet<Integer> lruOfPageID = new LinkedHashSet<Integer>();

    // disk
    private final DBFile disk;
    private final File tmpFile;
    private static final int pageSize = 1024 * 1024; // 1M
    private long wroteByteSize = 0;

    public ContainerManager() throws IOException {
        this(64 * pageSize); // 64M
    }

    public ContainerManager(int cacheCapacity) throws IOException {
        this.cacheCapasity = cacheCapacity;

        tmpFile = File.createTempFile("raquel-", ".rel");
        if (_logger.isTraceEnabled())
            _logger.trace("tmp file: " + tmpFile);
        disk = new DiskFile(tmpFile.getAbsolutePath());
    }

    public void dispose() {
        try {
            disk.close();
            tmpFile.delete();
        }
        catch (XerialException e) {
            throw new XerialError(XerialErrorCode.DISK_IO_ERROR, e);
        }
    }

    /**
     * @param newBuffer
     * @return page ID
     */
    private int storeInternal(TupleContainer container) {
        createCacheSpace(container.getByteSize());

        int newPageID = pageCount++;
        cache.put(newPageID, new TupleContainer(container));

        updateLRU(newPageID);
        return newPageID;
    }

    private void createCacheSpace(int byteSize) {
        if (hasEnoughRoomFor(byteSize))
            return;

        Iterator<Integer> lruPageIDIterator = lruOfPageID.iterator();
        List<Integer> removedPageIDList = new ArrayList<Integer>();
        while (!hasEnoughRoomFor(byteSize)) {
            if (!lruPageIDIterator.hasNext())
                throw new XerialError(XerialErrorCode.INVALID_STATE, "no more page to write back");

            int victimPageID = lruPageIDIterator.next();
            writeBack(victimPageID);
            removedPageIDList.add(victimPageID);
        }

        // remove victim page IDs from LRU list
        lruOfPageID.removeAll(removedPageIDList);
    }

    private void writeBack(int victimPageID) {
        TupleContainer victim = cache.get(victimPageID);

        if (!pageMap.containsKey(victimPageID)) {
            // write to buffer
            Buffer buf = new Buffer(victim.getByteSize());
            BufferWriter writer = new BufferWriter(buf);
            int writtenByteSize = victim.dump(writer);

            // write to disk
            long diskAddress = wroteByteSize;
            try {
                disk.seek(diskAddress);
                disk.write(buf.getBytes(), 0, writtenByteSize);
            }
            catch (XerialException e) {
                throw new XerialError(XerialErrorCode.DISK_IO_ERROR, e);
            }
            wroteByteSize += writtenByteSize;

            pageMap.put(victimPageID, new PageAddress(diskAddress, writtenByteSize));
        }

        // remove from the cache
        cachedByteSize -= victim.getByteSize();
        cache.remove(victimPageID);
    }

    private void updateLRU(int pageID) {
        if (lruOfPageID.contains(pageID)) {
            lruOfPageID.remove(pageID);
        }

        lruOfPageID.add(pageID);
    }

    public TupleContainer get(Schema schema, int pageID) {
        updateLRU(pageID);

        if (cache.containsKey(pageID)) {
            return cache.get(pageID);
        }

        // load the page from disk
        if (!pageMap.containsKey(pageID))
            throw new XerialError(XerialErrorCode.INVALID_STATE, String.format("page %d", pageID));

        PageAddress pageAddress = pageMap.get(pageID);
        createCacheSpace(pageAddress.pageSize);

        Buffer buf = new Buffer(pageAddress.pageSize);
        try {
            disk.seek(pageAddress.diskAddress);
            disk.read(buf.getBytes(), 0, pageAddress.pageSize);
        }
        catch (XerialException e) {
            throw new XerialError(XerialErrorCode.DISK_IO_ERROR, e);
        }

        BufferReader reader = new BufferReader(buf);
        TupleContainer newBuffer = new TupleContainer(schema);
        newBuffer.load(reader);

        storeInternal(newBuffer);
        cache.put(pageID, newBuffer);

        return newBuffer;
    }

    public boolean hasEnoughRoomFor(TupleContainer newBuffer) {
        return hasEnoughRoomFor(newBuffer.getByteSize());
    }

    public boolean hasEnoughRoomFor(int byteSize) {
        return cachedByteSize + byteSize < cacheCapasity;
    }

    private static class PageAddress {
        long diskAddress;
        int pageSize;

        public PageAddress(long diskAddress, int pageSize) {
            this.diskAddress = diskAddress;
            this.pageSize = pageSize;
        }

        @Override
        public String toString() {
            return String.format("disk address=%d, size=%d", diskAddress, pageSize);
        }

    }

    public int getPageSizeMax() {
        return pageSize;
    }

    private PageIDChain getPageIDChain(Schema rel) {
        if (addressChainOfEachRelation.containsKey(rel))
            return addressChainOfEachRelation.get(rel);
        else {
            PageIDChain newInstance = new PageIDChain();
            addressChainOfEachRelation.put(rel, newInstance);
            return newInstance;
        }
    }

    public int numChain(Schema rel) {
        return getPageIDChain(rel).size();
    }

    public TupleContainer load(Schema rel, int chainIndex) throws XerialException {
        PageIDChain addressChain = getPageIDChain(rel);
        if (chainIndex < 0 || chainIndex >= addressChain.size()) {
            throw new XerialError(XerialErrorCode.INVALID_CHAIN_INDEX, String.format("%d",
                    chainIndex));
        }

        int pageID = addressChain.get(chainIndex);
        return get(rel, pageID);
    }

    public void store(TupleContainer saveData) throws XerialException {
        int relationByteSize = saveData.getByteSize();
        if (relationByteSize > pageSize)
            throw new XerialError(XerialErrorCode.TOO_LARGE_RELATION, String.format(
                    "relation size = %d", relationByteSize));

        int newPageID = storeInternal(saveData);
        PageIDChain pageIDChain = getPageIDChain(saveData.getSchema());
        pageIDChain.add(newPageID);
        if (_logger.isDebugEnabled())
            _logger.debug("created a new page: " + newPageID);
    }

}

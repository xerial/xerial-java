/*--------------------------------------------------------------------------
 *  Copyright 2004 Taro L. Saito
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
// MemoryBlockManager.java
// Since: 2005/07/24 15:45:46
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.mlpress;

import java.util.LinkedList;


interface CacheObserver
{
    public void notifyCacheFull();
}

public class MemoryBlockManager
{
    private int _cacheSize;
    private int _numMemoryBlock = 0;
    private int _totalSizeOfAllocatedMemoryBlocks = 0;
    
    private LinkedList<MemoryBlock> _memoryBlockList = new LinkedList<MemoryBlock>();
    
    /**
     * @param cacheSize - byte size of cache memory
     */
    public MemoryBlockManager(int cacheSize)
    {
        assert cacheSize > 0;
        _cacheSize = cacheSize;
    }
    
    public MemoryBlock allocateMemoryBlock()
    {
        MemoryBlock memBlock = new MemoryBlock(++_numMemoryBlock, this);
        _memoryBlockList.add(memBlock);
        _totalSizeOfAllocatedMemoryBlocks += memBlock.size();
        return memBlock; 
    }

    void expandBlockSize(MemoryBlock memoryBlock, int newSize)
    {
        int oldSize = memoryBlock.size();
        assert oldSize <= newSize;
        int requiredSpace = newSize - oldSize;
        if(_totalSizeOfAllocatedMemoryBlocks + requiredSpace >= _cacheSize)
        {
            // TODO write some MemoryBlocks to the disk
        }
        _totalSizeOfAllocatedMemoryBlocks += requiredSpace;
        
    }
    
}

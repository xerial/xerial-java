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
// PageCacheServer.java
// Since: Aug 23, 2007 11:26:21 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.db.cache;

import java.util.ArrayList;
import java.util.Stack;


/**
 * {@link Buffer} holder
 * 
 * @author leo
 *
 */
public class PageCacheHolder {

    private int pageSize;
	private int numPageCacheMax;
	private ArrayList<Buffer> pageCacheList = new ArrayList<Buffer>();
	private Stack<Buffer> freePageCacheHolder = new Stack<Buffer>();
	

	public PageCacheHolder(int pageSize, int numPageCacheMax)
	{
		if(numPageCacheMax <= 0)
			throw new IllegalArgumentException("num page cache must be higher than 0: " + numPageCacheMax);
		if(pageSize <= 0)
		    throw new IllegalArgumentException("page size must be higher than 0: " + pageSize);
			
		this.numPageCacheMax = numPageCacheMax;
		
		preparePageCache();
		
	}
	
	private void preparePageCache()
	{
	    pageCacheList.clear();
	    freePageCacheHolder.clear();
	    
	    for(int i=0; i<numPageCacheMax; i++)
	    {
	        pageCacheList.add(new Buffer(pageSize));
	    }
	    for(Buffer pageCache : pageCacheList)
	    {
	        freePageCacheHolder.add(pageCache);
	    }
	}
	
	public Buffer getPageCache()
	{
	    if(freePageCacheHolder.empty())
	    {
	        
	        return null;	        
	    }
	    else
	    {
	        return freePageCacheHolder.pop();
	    }
	}
	
	
	
}




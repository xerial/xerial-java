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
// Algorithm.java
// Since: 2004/12/27
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/** プログラミングに便利なAlgorithm群を定義
 * @author leo
 *
 */
public class Algorithm
{
	private Algorithm(){};
    
	/**　２つの入力の大小のペアを計算する
     * @param <E> Comparable Interfaceを実装したクラス
     * @param e1　
     * @param e2
     * @return MinMax
     */
    static public <E extends Comparable<E>> MinMax<E> minmax(E e1, E e2)
    {
        int cmpResult = e1.compareTo(e2);
        if(cmpResult <= 0) // e1 is less than or equal to e2
            return new MinMax<E>(e1, e2);
        else
            return new MinMax<E>(e2, e1);
    }

    /** 辞書順に比較を行う。 
     * 
     * @param <E> compareToが実装されているクラス
     * @param f1 
     * @param f2
     * @return negative value : f1 < f2, 0 : f1 == f2, positive value : f1 > f2 
     */
    static public <E extends Comparable<E>>
    int lexicographicalCompare(Iterable<E> f1, Iterable<E> f2)
    {
        Iterator<E> i1 = f1.iterator();
        Iterator<E> i2 = f2.iterator();
        int cmp = 0;
        while(i1.hasNext() && i2.hasNext())
        {
            E e1 = i1.next();
            E e2 = i2.next();
            cmp = e1.compareTo(e2);
            if(cmp != 0)
                return cmp;
        }
        if(i1.hasNext())
            return 1;
        else
        {
            if(i2.hasNext())
                return -1;
            else
                return 0;
        }
    }
    
    /** boolean値を数値に変換
     * @param flag
     * @return true:1, false:0
     */
    static public int boolToInt(boolean flag)
    {
        return flag == true ? 1 : 0;
    }

    /** arrayのそれぞれの値を、逐次cに追加する。
     * @param <E> 任意の型
     * @param c 代入先のCollection
     * @param array 代入元配列
     */
    static public <E> void add(Collection<E> c, E[] array)
    {
    	for(E e : array)
    	{
    		c.add(e);
    	}
    }
    
    /**
     * inputのそれぞれの要素を、逐次containerに追加する
     * @param <E>
     * @param container
     * @param input
     */
    static public <E> void add(List<E> container, Collection<E> input)
    {
        for(E e : input)
        {
            container.add(e);
        }
    }
    
}





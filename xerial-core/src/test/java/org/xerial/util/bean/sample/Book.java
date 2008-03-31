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
// Book.java
// Since: Dec 19, 2007 6:28:09 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.bean.sample;

import java.util.ArrayList;

public class Book
{
    String title;
    ArrayList<String> authorList = new ArrayList<String>();

    public Book()
    {}

    public Book(String title, String[] authorList)
    {
        this.title = title;
        for (String author : authorList)
            addAuthor(author);
    }

    public ArrayList<String> getAuthor()
    {
        return authorList;
    }

    public void addAuthor(String author)
    {
        authorList.add(author);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}

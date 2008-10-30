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
// OptionHandler.java
// Since: Aug 27, 2007 9:05:52 AM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.util.cui;

/**
 * A handler called when an option is set.
 * 
 * @author leo
 * 
 * @see no longer supported. Use {@link org.xerial.util.opt.OptionParser}
 *      instead
 */
public interface OptionHandler<OptionID extends Comparable>
{
    /**
     * Called when the option is specified
     * 
     * @param parser
     *            the option parser
     * @throws OptionParserException
     *             when handling of this option is failed
     */
    public void handle(OptionParser<OptionID> parser) throws OptionParserException;
}

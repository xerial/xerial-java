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
// DTDToFDHandler.java
// Since: Jul 24, 2007 3:56:39 PM
//
// $URL$
// $Author$
//--------------------------------------
package org.xerial.amoeba;


import org.xerial.util.log.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.ext.LexicalHandler;

public class DTDToFDHandler extends DefaultHandler2  implements LexicalHandler
{
    private static Logger _logger = Logger.getLogger(DTDToFDHandler.class);


    @Override
    public void attributeDecl(String name, String name2, String type, String mode, String value) throws SAXException
    {
        _logger.trace("attribute decl: name=" + name + " name2=" + name2 + " type=" + type + " mode=" + mode + " value=" + value);
        
    }

    @Override
    public void elementDecl(String name, String model) throws SAXException
    {
        _logger.trace("elementDecl: name=" + name + " model=" + model);
    }


    @Override
    public void externalEntityDecl(String name, String publicId, String systemId) throws SAXException
    {
        // TODO Auto-generated method stub
        _logger.trace("external: name=" + name + " publicId=" + publicId + " systemId=" + systemId );
    }

    
    @Override
    public void internalEntityDecl(String name, String value) throws SAXException
    {
        _logger.trace("internal: name=" + name + " value=" + value);
        
    }

    
    @Override
    public void notationDecl(String name, String publicId, String systemId) throws SAXException
    {
        _logger.trace("notationDecl: name=" + name);
    }

    @Override
    public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
            throws SAXException
    {
        _logger.trace("unparsedEntityDecl: name=" + name);
    }

    @Override
    public void startDTD(String name, String publicId, String systemId) throws SAXException
    {
        _logger.trace("start DTD: name=" + name + " publicId=" + publicId + " systemID=" + systemId);
    }


    @Override
    public void processingInstruction(String target, String data) throws SAXException
    {
        _logger.trace("pi: target=" + target + " data=" + data);
    }


    @Override
    public void endDTD() throws SAXException
    {
        _logger.trace("end DTD");
    }



    
    
    
    
    


}

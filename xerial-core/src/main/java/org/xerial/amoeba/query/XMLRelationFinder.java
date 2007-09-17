//--------------------------------------
// XerialJ Project
//
// XMLRelationFinder.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.amoeba.query;

import static org.xmlpull.v1.XmlPullParser.END_TAG;
import static org.xmlpull.v1.XmlPullParser.START_TAG;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Stack;

import org.xerial.core.XerialException;
import org.xerial.util.XMLParserException;
import org.xerial.util.log.Logger;
import org.xerial.util.xml.pullparser.PullParserUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


class RelationPath implements Comparable<RelationPath>
{
	private String src;
	private String dest;
	
	/**
	 * @param src
	 * @param dest
	 */
	public RelationPath(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public int compareTo(RelationPath o) {
		int diff = src.compareTo(o.src);
		return diff != 0 ? diff : (dest.compareTo(o.dest));
	}
}



/**
 * @author leo
 *
 */
public class XMLRelationFinder 
{
	private static Logger _logger = Logger.getLogger(XMLRelationFinder.class); 
	
	@SuppressWarnings("serial")
	class ElementSet extends HashSet<String> {}
	
	Stack<ElementSet> _elementSetStack = new Stack<ElementSet>();
    /*
	DataModel _dataModel = new DataModel(); 
	
	
	public void process(Reader xmlInput) throws IOException, XerialException 
	{
		try {
			XmlPullParser parser = PullParserUtil.newParser(xmlInput);

			String contextElementName = "_root";
			_elementSetStack.push(new ElementSet());

			int state = parser.next();
			switch(state)
			{
			case START_TAG:
			{
				ElementSet elementSet = _elementSetStack.peek();
				String tagName = parser.getName();
				elementSet.add(tagName);
				if(!_dataModel.hasEdge(contextElementName, tagName))
				{
					_dataModel.connectNodes(contextElementName, tagName, Relationship.OneToOne);
				}
				else
				{
					Relationship rel = _dataModel.getRelationship(contextElementName, tagName);
					if(rel == Relationship.OneToOne)
						_dataModel.updateEdge(contextElementName, tagName, Relationship.OneToMany);
				}
				
				int attribCount = parser.getAttributeCount();
				
				break;	
			}
			case END_TAG:
				break;
			
			}

		} 
		catch (XMLParserException e) {
			_logger.error(e);
		}
		
	}
    */
	

}





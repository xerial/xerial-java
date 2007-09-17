//--------------------------------------
// XerialJ Project
//
// SQLExpression.java
// Since: May 8, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xerial.db.DBException;



/**
 * SQLExpression is a template that has several variables $1, $2, ... etc.
 * A user can assign arbitrary values into an SQLExpression.
 * 
 * 
 * <pre>
 * String assignedSQL = SQLExpression.assignTo("select * from $1", "t1");
 * // assignedSQL will be "select * from t1"
 * </pre>
 * @author leo
 *
 */
public class SQLExpression
{
    private String _sqlExpr;
    
    /**
     * 
     * @param sql sql expression template
     */
    public SQLExpression(String sql)
    {
        _sqlExpr = sql;
    }
    
    /**
     * assign values given as arguments to variables $1, $2, ... 
     * @param arguments string values to replace variables
     * @return  an SQL expression in which variables $1, $2, ... are replaced with arguments
     * @throws DBException 
     */
    public String assign(Object... arguments) throws DBException
    {
        String assignedSQL = _sqlExpr;
        for(int i=0; i<arguments.length; i++)
        {
            String pattern = "\\$" + (i+1);
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(assignedSQL);
            if(!m.find())
            	continue;
            
            int start = m.start();
            int end = m.end();
            
            Quote quoteType = withinWhatTypeOfQuote(assignedSQL, start, end);
            if(quoteType == Quote.INVALID)
            	throw new DBException("invalid quotation around $" + (i+1) + " in " + assignedSQL);
            
            String replacement = sanitize(arguments[i] != null ? arguments[i].toString() : "", quoteType);
            assignedSQL = assignedSQL.replaceAll(pattern, replacement);
        }
        return assignedSQL;
    }
    
    private Quote withinWhatTypeOfQuote(String sql, int targetBegin, int targetEnd)
    {
    	Quote forwardQuote = Quote.NONE;
    	for(int i = targetBegin-1; i>=0; i--)
    	{
    		if(sql.charAt(i) == '\'')
    		{
    			forwardQuote = Quote.SINGLE_QUOTE;
    			break;
    		}
    		else if(sql.charAt(i) == '"')
    		{
    			forwardQuote = Quote.DOUBLE_QUOTE;
    			break;
    		}
    	}
    	
    	Quote backwardQuote = Quote.NONE;
    	for(int i=targetEnd; i<sql.length(); i++)
    	{
    		if(sql.charAt(i) == '\'')
    		{
    			backwardQuote = Quote.SINGLE_QUOTE;
    			break;
    		} else if (sql.charAt(i) == '"')
    		{
    			backwardQuote = Quote.DOUBLE_QUOTE;
    			break;
    		}
    	}
    	
    	if(forwardQuote == backwardQuote)
    		return forwardQuote;
    	else
    		return Quote.INVALID; 
    }
    
    public enum Quote { SINGLE_QUOTE, DOUBLE_QUOTE, NONE, INVALID}
    
    /**
     * unquote the input value and remove any maricious statement  
     * to avoid SQL injection.
     * 
     * @param input
     * @param contextQuotation quotation type where input string is contained. 
     * @return 
     * @throws DBException when the input value has invalid quotation
     */
    private String sanitize(String input, Quote contextQuotation) throws DBException
    {
    	LinkedList<Quote> arrayDeque = new LinkedList<Quote>();
    	
    	int cursor = 0;
    	int bracketCount = 0;
    	while(cursor < input.length())
    	{
    		if(input.charAt(cursor) == '\'')
    		{
    			arrayDeque.addLast(Quote.SINGLE_QUOTE);
    			bracketCount++;
    		}
    		else if(input.charAt(cursor) == '"')
    		{
    			arrayDeque.addLast(Quote.DOUBLE_QUOTE);
    			bracketCount++;
    		}
    		cursor++;
    	}
    	
    	assert(contextQuotation != Quote.INVALID);
    	if(contextQuotation != Quote.NONE)
    	{
    		arrayDeque.addFirst(contextQuotation);
    		arrayDeque.addLast(contextQuotation);
    	}

    	
    	if(arrayDeque.size() % 2 != 0)	// there is no matching quotes in the input
    		throw new DBException("paren does not match: " + input);
    	
    	// consume corresponding quotes
    	Quote previousQuotation = Quote.NONE;
    	while(!arrayDeque.isEmpty())
    	{
    		if(arrayDeque.getFirst() == arrayDeque.getLast())
    		{
    			if(arrayDeque.getFirst() == previousQuotation)
    			{
    				// ALERT! duplicate quotation of the same quotation mark, e.g, ''; delete from table;''
    				throw new DBException("duplicate quotation: " + input);
    			}
    			previousQuotation = arrayDeque.getFirst();
    			arrayDeque.removeLast();
    			arrayDeque.removeFirst();
    		}
    		else
        		throw new DBException("paren does not match: " + input);
    	}
    	
		return input;
    }
    
    
    
    
    /**
     * assign values to the given SQL template
     * @param sqlTemplate SQL expression
     * @param arguments assign values
     * @return sql expression in which variables are replaced with values
     * @throws DBException when input values have invalid quotations
     */
    public static String fillTemplate(String sqlTemplate, Object... arguments) throws DBException
    {
        return new SQLExpression(sqlTemplate).assign(arguments);
    }

}


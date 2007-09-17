//--------------------------------------
// XerialJ Project
//
// SQLiteReader.java
// Since: May 31, 2007
//
// $URL: http://dev.utgenome.org/svn/utgb/trunk/common/src/org/utgenome/db/sql/sqlite/SQLiteReader.java $ 
// $Author: leo $
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;


import org.xerial.db.DBException;
import org.xerial.json.InvalidJSONDataException;
import org.xerial.json.JSONException;
import org.xerial.json.JSONObject;
import org.xerial.util.StringUtil;
import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;


public class SQLiteReader
{

	private enum Opt { HELP }
	

	public static void main(String[] args)
	{
		OptionParser<Opt> optionParser = new OptionParser<Opt>();
		try {
			optionParser.addOption(Opt.HELP, "h", "help", "display help messages");

			optionParser.parse(args);

			if(optionParser.isSet(Opt.HELP))
			{
				printUsage(optionParser);
				return;
			}
			
			if(optionParser.getArgumentLength() == 0)
				throw new OptionParserException("no query is given");
			
			String query = optionParser.getArgument(0);

			SQLiteReader reader = new SQLiteReader();
			reader.query(query, new OutputStreamWriter(System.out));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void printUsage(OptionParser opt)
	{
		System.out.println("> java -jar SQLiteReader.jar  (json query)");
		System.out.println(opt.helpMessage());
	}

	private String _dbFile;
	private SQLiteAccess _dbAccess;

	public SQLiteReader() 
	{
		
	}
	
	public void query(String query, OutputStream out) throws InvalidJSONDataException, JSONException, DBException, IOException
	{
		query(query, new OutputStreamWriter(out));
	}
	
	
	public void query(String query, Writer out) throws InvalidJSONDataException, JSONException, DBException, IOException {
		JSONObject jsonQuery = new JSONObject(query);
		String _dbFile = jsonQuery.getString("database");
		String sql = jsonQuery.getString("sql");
		
		_dbAccess = new SQLiteAccess(_dbFile);
		
		out.append("[");
		List<JSONObject> result = _dbAccess.jsonQuery(sql);
		out.append(StringUtil.join(result, ","));
		out.append("]\n");
		out.flush();
	}

	
}





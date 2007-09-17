//--------------------------------------
// XerialJ Project
//
// SQLiteServer.java
// Since: 2007/05/10
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.xerial.db.DBException;
import org.xerial.db.sql.ConnectionPool;
import org.xerial.db.sql.ConnectionPoolImpl;
import org.xerial.db.sql.DatabaseAccess;
import org.xerial.util.cui.OptionParser;
import org.xerial.util.cui.OptionParserException;
import org.xerial.util.log.LogLevel;
import org.xerial.util.log.Logger;
import org.xerial.util.thread.ThreadManager;


/**
 * SQLiteServer 
 * @author leo
 *
 */
public class SQLiteServer 
{
	private SQLiteAccess _query;
	private ConnectionPool _connectionPool;
	private int _port = 5555;
	private ThreadManager _threadManager = new ThreadManager(20, 1000);
	private ServerSocket _serverSocket;
	
	private boolean _continueListeningPort = false;
	
	private static Logger _logger = Logger.getLogger(SQLiteServer.class);
	
	
	public SQLiteServer(String databasePath) throws DBException
	{
		_connectionPool = new ConnectionPoolImpl(SQLite.driverName, SQLite.getDatabaseAddress(databasePath));
		_query = new SQLiteAccess(new DatabaseAccess(_connectionPool));
	}
	
	public void dispose() throws DBException
	{
		_connectionPool.closeAll();
		
	}
	
	public void startServer() throws DBException 
	{
		try {
			_serverSocket = new ServerSocket(_port);
		} catch (IOException e) {
			throw new DBException(e);
		}
		
		_continueListeningPort = true;
		try
		{
			try
			{
				while(continueListening())
				{
					Socket socket = _serverSocket.accept();
					_threadManager.addTask(new RecieverThread(this, socket));
				}
			}
			catch (InterruptedException e) {
				throw new DBException(e);
			}
			finally
			{
				if(!_serverSocket.isClosed())
					_serverSocket.close();
			}
		}
		catch(IOException e)
		{
			throw new DBException(e); 
		}
	}
	
	synchronized public void stopPortListening() throws IOException
	{
		_continueListeningPort = false;
		_serverSocket.close();
	}
	
	synchronized public boolean continueListening()
	{
		return _continueListeningPort;
	}
	
	enum Opt { HELP, VERBOSE, DBNAME, PORT }
	
	public static void main(String[] args)
	{
		OptionParser<Opt> optionParser = new OptionParser<Opt>();
		try {
			optionParser.addOption(Opt.HELP, "h", "help", "display help messages");
			optionParser.addOption(Opt.VERBOSE, "v", "verbose", "display verbose messages");
			optionParser.addOptionWithArgument(Opt.DBNAME, "d", "database", "SQLITE_DB_FILE", "specify sqlite3 database filename (default memory:)", "memory:");
			optionParser.addOptionWithArgument(Opt.PORT, "p", "_port", "PORT", "specify _port number (default 5555)");
		
			optionParser.parse(args);
			if(optionParser.isSet(Opt.HELP))
			{
				System.out.println(optionParser.helpMessage());
				return;
			}
			
			if(optionParser.isSet(Opt.VERBOSE))
				_logger.setLogLevel(LogLevel.DEBUG);
			else
				_logger.setLogLevel(LogLevel.INFO);
			
			String dbName = optionParser.getValue(Opt.DBNAME);
			SQLiteServer server = new SQLiteServer(dbName);
			if(optionParser.isSet(Opt.PORT))
				server.setPort(optionParser.getIntValue(Opt.PORT));
			
		}
		catch (OptionParserException e) {
			System.err.println(e);
		} catch (DBException e) {
			System.err.println(e);
		}
	}

	public void setPort(int port) {
		this._port = port;
	}
}


class RecieverThread implements Runnable 
{
	private SQLiteServer _server;
	private Socket _socket;
	private static Logger _logger = Logger.getLogger(RecieverThread.class);

	public RecieverThread(SQLiteServer _server, Socket _socket) {
		this._server = _server;
		this._socket = _socket;
	}

	public void run() {
		
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			 in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			 out = new PrintWriter(_socket.getOutputStream());
			 
			 String inputLine;
			 _logger.debug("connection established");
			 while((inputLine = in.readLine()) != null)
			 {
				 _logger.debug("recieved a message: " + inputLine);
				 if(inputLine.equals("finish"))
				 {
					 _server.stopPortListening();
					 break;
				 }
				 out.println(inputLine);
				 out.flush();
			 }
			 in.close();
			 out.close();
		} 
		catch (IOException e) {
			_logger.error(e);
		}
	}

}


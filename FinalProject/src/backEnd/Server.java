package backEnd;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	ExecutorService threadpool;
	FileHelper fileManager;
	DatabaseHelper [] dataBaseHelper;
	EmailHelper emailService;
	ServerSocket server;
	Socket socket;
	
	public Server (int portNumber)
	{
		try 
		{
			threadpool = Executors.newCachedThreadPool();
			server = new ServerSocket(portNumber);
			fileManager = new FileHelper ();
			dataBaseHelper = new DatabaseHelper [6];
			initDatabaseHelpers();
			
		}
	}
	public void initDatabaseHelpers ()
	{
		
	}
}

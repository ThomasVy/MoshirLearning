package backEnd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	ExecutorService threadpool;
	FileHelper fileManager;
	DatabaseHelper dataBaseHelper;
	EmailHelper emailService;
	ServerSocket server;
	Socket socket;
	
	public Server (int portNumber)
	{
		try {
			threadpool = Executors.newCachedThreadPool();
			server = new ServerSocket(portNumber);
			fileManager = new FileHelper ();
			emailService = new EmailHelper();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void communicate()
	{
		while(true)
		{
			
		}
	}
	public static void main(String [] args)
	{
		Server server = new Server(9890);
		server.communicate();
	}
}

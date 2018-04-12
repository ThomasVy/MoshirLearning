package backEnd;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The server for MoshirLearning
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class Server {
	/**
	 * The threadpool of the server
	 */
	private ExecutorService threadpool;
	/**
	 * the file manager of the server
	 */
	private FileHelper fileManager;
	/**
	 * The database manager of the server
	 */
	private DatabaseHelper dataBaseHelper;
	/**
	 * The email manager of the server
	 */
	private EmailHelper emailService;
	/**
	 * The server socket
	 */
	private ServerSocket server;
	/**
	 * The constructor of the server
	 * @param portNumber - the port number the server listens on
	 */
	public Server(int portNumber) {
		try {
			threadpool = Executors.newCachedThreadPool();
			server = new ServerSocket(portNumber);
			fileManager = new FileHelper(System.getProperty("user.dir"));
			emailService = new EmailHelper();
			dataBaseHelper = new DatabaseHelper();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server is running.");
	}
	/**
	 * communicates with clients of the server.
	 */
	public void communicate() {
		try {
			while (true) {
				Worker worker = new Worker(server.accept(), dataBaseHelper, emailService, fileManager);
				threadpool.execute(worker);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Starts up the server
	 * @param args - the arguments of the command line
	 */
	public static void main(String[] args) {
		Server server = new Server(9890);
		server.communicate();
	}
}

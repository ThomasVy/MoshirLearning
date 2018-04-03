package backEnd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ExecutorService threadpool;
	private FileHelper fileManager;
	private DatabaseHelper dataBaseHelper;
	private EmailHelper emailService;
	private ServerSocket server;
	private Socket socket;

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
	}

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

	public static void main(String[] args) {
		Server server = new Server(9890);
		server.communicate();
	}
}

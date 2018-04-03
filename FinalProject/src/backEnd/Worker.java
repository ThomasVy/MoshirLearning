package backEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import sharedElements.LoginInfo;

public class Worker implements Runnable {

	Socket socketClient;
	ObjectInputStream in;
	ObjectOutputStream out;
	DatabaseHelper dbHelper;
	EmailHelper emailService;
	FileHelper fileHelper;

	public Worker(Socket socketClient, DatabaseHelper dbHelper, EmailHelper emailService, FileHelper fileHelper) {
		this.dbHelper = dbHelper;
		this.emailService = emailService;
		this.fileHelper = fileHelper;
		this.socketClient = socketClient;
		try {
			out = new ObjectOutputStream(socketClient.getOutputStream());
			in = new ObjectInputStream(socketClient.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			LoginInfo fromClient = (LoginInfo) in.readObject();
			if (dbHelper.verifyUser(fromClient.getUsername(), fromClient.getPassword())) {
				out.writeObject("Verified");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

}


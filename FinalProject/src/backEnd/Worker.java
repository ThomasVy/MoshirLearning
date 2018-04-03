package backEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import sharedElements.*;

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
			LoginInfo login = (LoginInfo)in.readObject();
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


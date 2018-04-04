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
			while(true)
			{
				Object fromClient = in.readObject();
				String classFromClient = fromClient.getClass().getSimpleName();
				processRequest(classFromClient, fromClient);
				
				out.writeObject(null);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		//long SerializedID = ObjectStreamClass.lookup(fromClient.getClass()).getSerialVersionUID();
	}
	public void processRequest(String classFromClient, Object fromClient)
	{ 
		if(classFromClient.equals("LoginInfo"))
		{
			System.out.println("Login");
			LoginInfo translatedLoginInfo = (LoginInfo)fromClient;
			sendObject(dbHelper.verifyUser(translatedLoginInfo.getUsername(), translatedLoginInfo.getPassword()));
		}
		else if(classFromClient.equals("StudentEnrollment"))
		{
			sendObject(null);
		}
		else if(classFromClient.equals("Assignment"))
		{
			sendObject(null);
		}
		else if (classFromClient.equals("Course"))
		{
			sendObject(null);
		}
		else {
			System.out.println("I have no idea what you asked");
		}
	}
	private void sendObject (Object toSend)
	{
		try {
			out.writeObject(toSend);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


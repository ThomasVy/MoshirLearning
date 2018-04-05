package backEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import sharedElements.*;

public class Worker implements Runnable {

	Socket socketClient;
	ObjectOutputStream out;
	ObjectInputStream in;
	DatabaseHelper dbHelper;
	EmailHelper emailService;
	FileHelper fileHelper;
	User userLoggedIn;

	public Worker(Socket socketClient, DatabaseHelper dbHelper, EmailHelper emailService, FileHelper fileHelper) {
		this.socketClient = socketClient;
		this.dbHelper = dbHelper;
		this.emailService = emailService;
		this.fileHelper = fileHelper;
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
			while(true) {
				Object fromClient = in.readObject();
				processRequest(fromClient);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("User disconnected");
		}
	}

	public void processRequest(Object fromClient) { 
		String classFromClient = fromClient.getClass().getSimpleName();
		if(classFromClient.equals("LoginInfo")) { // Client sent in login info
			LoginInfo translatedLoginInfo = (LoginInfo) fromClient;
			userLoggedIn = dbHelper.verifyUser(translatedLoginInfo.getUsername(), translatedLoginInfo.getPassword());
			sendObject(userLoggedIn);
		}
		else if (fromClient.equals("GetCourses")) {
			ArrayList<Course> courses = dbHelper.getCourses(userLoggedIn);
			sendObject(courses);
		}
//		else if (classFromClient.equals("GetStudents")) {
//			ArrayList<Student> students = dbHelper.getStudents();
//		}
		else if (classFromClient.equals("Course"))  {
			Course newCourse = (Course) fromClient;
			boolean approved = dbHelper.addCourse(newCourse.getId(), newCourse.getProfId(), newCourse.getName(), newCourse.getActive());
			sendObject(approved);
		}
		else if(classFromClient.equals("Assignment"))  {
			sendObject(null);
		}
		else {
			System.out.println("I have no idea what you asked.");
		}
	}

	private void sendObject (Object toSend) {
		try {
			out.writeObject(toSend);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

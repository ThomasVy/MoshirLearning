package backEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import sharedElements.Assignment;
import sharedElements.Course;
import sharedElements.LoginInfo;
import sharedElements.StudentEnrollment;
import sharedElements.User;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class Worker implements Runnable {

	private Socket socketClient;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private DatabaseHelper dbHelper;
	private EmailHelper emailService;
	private FileHelper fileHelper;
	private User userLoggedIn;

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
			while (true) {
				processRequest(readRequest());
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("User disconnected");
		}
	}

	private Object readRequest() throws ClassNotFoundException, IOException {
		return in.readObject();
	}

	private void processRequest(Object fromClient) throws ClassNotFoundException, IOException {
		String classFromClient = fromClient.getClass().getSimpleName();
		Object objectToSend = null;
		if (classFromClient.equals("LoginInfo")) 
		{ // Client sent in login info
			LoginInfo translatedLoginInfo = (LoginInfo) fromClient;
			userLoggedIn = dbHelper.verifyUser(translatedLoginInfo.getUsername(), translatedLoginInfo.getPassword());
			objectToSend = userLoggedIn;
		} 
		else if (classFromClient.equals("Course")) // Creating a course
		{
			Course courseFromClient = (Course) fromClient;
			objectToSend = processCourseRequest(courseFromClient);
		} 
		else if (classFromClient.equals("StudentEnrollment")) // Enrolling or disenrolling a student
		{
			StudentEnrollment enrollment = (StudentEnrollment) fromClient;
			objectToSend = dbHelper.changeEnrollment(enrollment);
		} 
		else if (classFromClient.equals("Assignment")) {
			Assignment assignment = (Assignment) fromClient;
			objectToSend = processAssignmentRequest(assignment);
		}
		else if (fromClient.equals("GetCourses")) // Getting list of courses that the user is taking
		{
			objectToSend = dbHelper.getCourses(userLoggedIn);
		}
		sendObject(objectToSend);
	}

	private Object processAssignmentRequest(Assignment selectedAssignment) throws ClassNotFoundException, IOException {
		String typeOfRequest = (String) readRequest();
		Object toSend = null;
		if (typeOfRequest.equalsIgnoreCase("AddAssignment")) {
			byte[] file = (byte[]) readRequest();
			fileHelper.writeFileContent(selectedAssignment, file);
			toSend = dbHelper.addAssignment(selectedAssignment);
		} else if (typeOfRequest.equalsIgnoreCase("DeleteAssignment")) {
			toSend = dbHelper.deleteAssignment(selectedAssignment);
		} else if (typeOfRequest.equalsIgnoreCase("ChangeActiveState")) {
			dbHelper.changeStateOfAssignment(selectedAssignment);
		}
		else if(typeOfRequest.equalsIgnoreCase("DownloadAssignment"))
		{
			toSend = fileHelper.getFileContent(selectedAssignment.getPath());
		}
		return toSend;
	}

	private Object processCourseRequest(Course courseFromClient) throws ClassNotFoundException, IOException {
		String typeOfRequest = (String) readRequest(); // Waits for client to be more specific.
		Object toSend = null;
		if (typeOfRequest.equalsIgnoreCase("CreateNewCourse")) {
			toSend = dbHelper.addCourse(courseFromClient.getId(), courseFromClient.getProfId(), courseFromClient.getName(), courseFromClient.getActive());
		} else if (typeOfRequest.equalsIgnoreCase("ChangeActiveState")) {
			dbHelper.changeStateOfCourse(courseFromClient);
		} else if (typeOfRequest.equalsIgnoreCase("GetEnrollmentList")) {
			toSend = dbHelper.getEnrollmentList(courseFromClient);
		} else if (typeOfRequest.equalsIgnoreCase("GetAssignmentList")) {
			toSend = dbHelper.getAssignmentList(courseFromClient);
		} else if (typeOfRequest.equalsIgnoreCase("GetGrades")) {
			toSend = dbHelper.getGradeList(courseFromClient);
		} 
		else if (typeOfRequest.equalsIgnoreCase("GetSubmissions"))
		{
			
		}
		return toSend;
	}

	private void sendObject(Object toSend) {
		try {
			out.reset();
			out.writeObject(toSend);
			out.flush();
		} catch (IOException e) {
			System.out.println("Could not send to Client");
		}
	}

}

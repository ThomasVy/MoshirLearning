package backEnd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import sharedElements.*;


/**
 * The thread for each client for communication.
 * @author Rainer Lim & Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class Worker implements Runnable {
	/**
	 * The object output stream to write to client
	 */
	private ObjectOutputStream out;
	/**
	 * The object input stream to read from client
	 */
	private ObjectInputStream in;
	/**
	 * The database helper
	 */
	private DatabaseHelper dbHelper;
	/**
	 * The email helper of the server
	 */
	private EmailHelper emailService;
	/**
	 * The file helper of the server
	 */
	private FileHelper fileHelper;
	/**
	 * The user that is currently using the thread
	 */
	private User userLoggedIn;
	/**
	 * The constructor of the worker
	 * @param socketClient - the socket that is communicating with the client
	 * @param dbHelper - the database helper of the server
	 * @param emailService - the email helper of the server
	 * @param fileHelper - the file helper of the server
	 */
	public Worker(Socket socketClient, DatabaseHelper dbHelper, EmailHelper emailService, FileHelper fileHelper) {
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
	/**
	 * Runs the worker thread
	 */
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
	/**
	 * Reads the object from the client
	 * @return - the object that was recieved from client
	 * @throws ClassNotFoundException - Could not find class to convert
	 * @throws IOException - interruption occurred when reading the object
	 */
	private Object readRequest() throws ClassNotFoundException, IOException {
		return in.readObject();
	}
	/**
	 * Process the request from the client
	 * @param fromClient - the object send from client
	 * @throws ClassNotFoundException - Could not find class to convert
	 * @throws IOException - interruption occurred when reading the object
	 */
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
		else if (classFromClient.equals("Assignment")) { //Assignment request
			Assignment assignment = (Assignment) fromClient;
			objectToSend = processAssignmentRequest(assignment);
		}
		else if (classFromClient.equals("Submission")) { //Submission request
			Submission submission = (Submission) fromClient;
			objectToSend = processSubmissionRequest(submission);
		}
		else if (fromClient.equals("GetCourses")) // Getting list of courses that the user is taking
		{
			objectToSend = dbHelper.getCourses(userLoggedIn);
		}
		sendObject(objectToSend);
	}
	/**
	 * Processes the assignment request of the user.
	 * @param selectedAssignment - the assignment that was send to the server
	 * @return - the object to be send back to the client
	 * @throws ClassNotFoundException - Could not find class to convert
	 * @throws IOException - interruption occurred when reading the object
	 */
	private Object processAssignmentRequest(Assignment selectedAssignment) throws ClassNotFoundException, IOException {
		String typeOfRequest = (String) readRequest();
		Object toSend = null;
		if (typeOfRequest.equalsIgnoreCase("AddAssignment")) {
			byte[] file = (byte[]) readRequest();
			fileHelper.findUnqiuePath(selectedAssignment);
			toSend = dbHelper.addAssignment(selectedAssignment);
			if((boolean)toSend == true)
			{
				fileHelper.writeFileContent(selectedAssignment, file);
			}
		} else if (typeOfRequest.equalsIgnoreCase("DeleteAssignment")) {
			toSend = dbHelper.deleteAssignment(selectedAssignment);
		} else if (typeOfRequest.equalsIgnoreCase("ChangeActiveState")) {
			dbHelper.changeStateOfAssignment(selectedAssignment);
		}else if(typeOfRequest.equalsIgnoreCase("DownloadAssignment")){
			toSend = fileHelper.getFileContent(selectedAssignment.getPath());
		} else if (typeOfRequest.equalsIgnoreCase("GetSubmissionList")) {
			toSend = dbHelper.getSubmissionList(selectedAssignment, userLoggedIn);
		}
		return toSend;
	}
	
	private Object processSubmissionRequest(Submission selectedSubmission) throws ClassNotFoundException, IOException {
		String typeOfRequest = (String) readRequest();
		Object toSend = null;
		if (typeOfRequest.equalsIgnoreCase("AddSubmission")) { //Adds submission
			byte[] file = (byte[]) readRequest();
			Assignment a = (Assignment) readRequest();
			fileHelper.writeFileContent(selectedSubmission, file);
			toSend = dbHelper.addSubmission(selectedSubmission, a);
		} else if (typeOfRequest.equalsIgnoreCase("UpdateSubmission")) { //Updates submission
			Assignment a = (Assignment) readRequest();
			toSend = dbHelper.updateSubmission(selectedSubmission, a);
		} else if (typeOfRequest.equalsIgnoreCase("DownloadSubmission")) { //Download submission
			toSend = fileHelper.getFileContent(selectedSubmission.getPath());
		}
		return toSend;
	}
	/**
	 * Processes the course request from the client
	 * @param courseFromClient - the course sent from client
	 * @return - the object to send back to client 
	 * @throws ClassNotFoundException - Could not find class to convert
	 * @throws IOException - interruption occurred when reading the object
	 */
	private Object processCourseRequest(Course courseFromClient) throws ClassNotFoundException, IOException {
		String typeOfRequest = (String) readRequest(); // Waits for client to be more specific.
		Object toSend = null;
		if (typeOfRequest.equalsIgnoreCase("CreateNewCourse")) {
			toSend = dbHelper.addCourse(courseFromClient.getProfId(), courseFromClient.getName(), courseFromClient.getActive());
		} else if (typeOfRequest.equalsIgnoreCase("ChangeActiveState")) {
			dbHelper.changeStateOfCourse(courseFromClient);
		} else if (typeOfRequest.equalsIgnoreCase("GetEnrollmentList")) {
			toSend = dbHelper.getEnrollmentList(courseFromClient);
		} else if (typeOfRequest.equalsIgnoreCase("GetAssignmentList")) {
			toSend = dbHelper.getAssignmentList(courseFromClient, userLoggedIn);
		}else if (typeOfRequest.equalsIgnoreCase("GetGradeList")) {
			toSend = dbHelper.getGradeList(courseFromClient, userLoggedIn);
		}else if (typeOfRequest.equalsIgnoreCase("SendEmail"))
		{
			Email email =(Email)readRequest();
			if(userLoggedIn.getClass().getSimpleName().equals("Professor"))
			{
				email.setReceiver(dbHelper.getAllEmail(courseFromClient));
			}
			else if (userLoggedIn.getClass().getSimpleName().equals("Student")){
				email.setReceiver(dbHelper.getProfEmail(courseFromClient));
			}
			email.setSender(dbHelper.getUserEmail(userLoggedIn.getId()));
			toSend = emailService.sendEmail(email);

		} 
		return toSend;
	}
	/**
	 * Sends objects to client
	 * @param toSend - the object to be sent to the client
	 */
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

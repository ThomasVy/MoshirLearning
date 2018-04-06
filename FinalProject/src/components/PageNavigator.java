package components;

import java.util.ArrayList;

import javax.swing.*;

import frontEnd.*;
import pages.*;

public class PageNavigator extends JFrame {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Client client;

	protected HomePage homePage;
	
	protected ArrayList<Page> coursePages;
	protected ArrayList<Page> assignmentPages;
	protected ArrayList<Page> gradePages;
	protected ArrayList<Page> submissionPages;
	protected ArrayList<Page> enrollmentPages;

	public PageNavigator(Client client) {
		this.client = client;
	}

	public Object sendToClient(Object toSend) {
		return client.communicateWithServer(toSend);
	}

	public Object sendToClient(Object toSend, String typeOfRequest) {
		return client.communicateWithServer(toSend, typeOfRequest);
	}

	public Object sendToClient(Object toSend, String typeOfRequest, Object file) {
		return client.communicateWithServer(toSend, typeOfRequest, file);
	}

	public ArrayList<Page> getCoursePages() {
		return coursePages;
	}

}

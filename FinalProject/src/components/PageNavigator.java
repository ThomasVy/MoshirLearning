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

	public Client getClient() {
		return client;
	}

	public ArrayList<Page> getCoursePages() {
		return coursePages;
	}

}

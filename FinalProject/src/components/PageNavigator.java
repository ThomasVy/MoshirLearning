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

	public void showPage(String page) {
		
	}

	public void addPage(String page, String name) {
		
	}

	public void removePage(String name) {
		
	}

	public JPanel searchPage(String name) {
		return null;
	}

}

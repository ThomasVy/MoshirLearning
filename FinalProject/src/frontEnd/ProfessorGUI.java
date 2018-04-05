package frontEnd;

import java.util.ArrayList;

import components.*;
import pages.*;
import sharedElements.*;

public class ProfessorGUI extends PageNavigator {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Professor professor;
	private boolean isProfessor;

	private ArrayList<Course> courses;

	public ProfessorGUI(Client client, Professor professor, boolean isProfessor, ArrayList<Course> courses) {
		super(client);
		this.professor = professor;
		this.isProfessor = isProfessor;
		this.courses = courses;

		homePage = new HomePage(this, courses);
		homePage.setVisible(true);
		
		coursePages = new ArrayList<Page>();
		assignmentPages = new ArrayList<Page>();
		gradePages = new ArrayList<Page>();
		submissionPages = new ArrayList<Page>();
		enrollmentPages = new ArrayList<Page>();

		createAllPages();

		homePage.setUpHomeButtonListener(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
		addHomeButtonListenerToPage(coursePages);
		addHomeButtonListenerToPage(assignmentPages);
		addHomeButtonListenerToPage(gradePages);
		addHomeButtonListenerToPage(submissionPages);
		addHomeButtonListenerToPage(enrollmentPages);

		homePage.setUpComboBoxListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
		addComboBoxListenerToPage(coursePages);
		addComboBoxListenerToPage(assignmentPages);
		addComboBoxListenerToPage(gradePages);
		addComboBoxListenerToPage(submissionPages);
		addComboBoxListenerToPage(enrollmentPages);

		addPageListeners(coursePages);
		addPageListeners(assignmentPages);
		addPageListeners(gradePages);
		addPageListeners(submissionPages);
		addPageListeners(enrollmentPages);
	}

	public void createAllPages() {
		// Course Pages
		for (int i = 0; i < courses.size(); i++) {
			coursePages.add(new CoursePage(this, courses, courses.get(i).getName()));
		}
		
		// Assignment Pages
		for (int i = 0; i < courses.size(); i++) {
			assignmentPages.add(new AssignmentPage(this, courses, courses.get(i).getName()));
		}
		
		// Grade Pages
		for (int i = 0; i < courses.size(); i++) {
			gradePages.add(new GradePage(this, courses, courses.get(i).getName()));
		}
		
		// Submission Pages
		for (int i = 0; i < courses.size(); i++) {
			submissionPages.add(new SubmissionPage(this, courses, courses.get(i).getName()));
		}
		
		// Enrollment Pages
		for (int i = 0; i < courses.size(); i++) {
			enrollmentPages.add(new EnrollmentPage(this, courses, courses.get(i).getName()));
		}
	}

	public void addHomeButtonListenerToPage(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpHomeButtonListener(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
		}
	}

	public void addComboBoxListenerToPage(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpComboBoxListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
		}
	}

	public void addPageListeners(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpPageListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
		}
	}

}

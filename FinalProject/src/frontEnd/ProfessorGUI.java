package frontEnd;

import java.util.ArrayList;

import components.*;
import pages.*;
import sharedElements.*;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
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

		coursePages = new ArrayList<Page>();
		assignmentPages = new ArrayList<Page>();
		gradePages = new ArrayList<Page>();
		submissionPages = new ArrayList<Page>();
		enrollmentPages = new ArrayList<Page>();

		createAllPages();

		refreshPages();

		homePage.setVisible(true);
	}

	// Getters
	public Professor getProfessor() {
		return professor;
	}

	public boolean getIsProfessor() {
		return isProfessor;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	// Setters
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setIsProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

	public void createAllPages() {
		coursePages.clear();
		assignmentPages.clear();
		gradePages.clear();
		submissionPages.clear();
		enrollmentPages.clear();

		homePage = new HomePage(this, courses);

		// Course Pages
		for (int i = 0; i < courses.size(); i++) {
			coursePages.add(new CoursePage(this, courses, courses.get(i)));
		}

		// Assignment Pages
		for (int i = 0; i < courses.size(); i++) {
			assignmentPages.add(new AssignmentPage(this, courses, courses.get(i)));
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
			enrollmentPages.add(new EnrollmentPage(this, courses, courses.get(i)));
		}
	}

	public void refreshPages() {
		homePage.setUpHomeButtonListener(homePage, coursePages, assignmentPages, gradePages, submissionPages,
				enrollmentPages);
		addHomeButtonListenerToPage(coursePages);
		addHomeButtonListenerToPage(assignmentPages);
		addHomeButtonListenerToPage(gradePages);
		addHomeButtonListenerToPage(submissionPages);
		addHomeButtonListenerToPage(enrollmentPages);

		homePage.setUpComboBoxListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages,
				enrollmentPages);
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

	public void addHomeButtonListenerToPage(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpHomeButtonListener(homePage, coursePages, assignmentPages, gradePages, submissionPages,
					enrollmentPages);
		}
	}

	public void addComboBoxListenerToPage(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpComboBoxListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages,
					enrollmentPages);
		}
	}

	public void addPageListeners(ArrayList<Page> pages) {
		for (int i = 0; i < pages.size(); i++) {
			pages.get(i).setUpPageListeners(homePage, coursePages, assignmentPages, gradePages, submissionPages,
					enrollmentPages);
		}
	}

}

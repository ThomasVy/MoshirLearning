package frontEnd;

import java.util.ArrayList;

import components.PageNavigator;
import pages.CoursePage;
import pages.EnrollmentPage;
import pages.GradePage;
import pages.HomePage;
import pages.SubmissionPage;
import sharedElements.*;

public class ProfessorGUI extends PageNavigator {

	private Professor professor;
	private boolean isProfessor;
	private HomePage homepage;
	private CoursePage coursepage;
//	private AssignmentPage assignmentpage;
	private GradePage gradepage;
	private SubmissionPage submissionpage;
	private EnrollmentPage enrollmentpage;
	private ArrayList<Course> courses;
	
	public ProfessorGUI(Client client, Professor professor, boolean isProfessor, ArrayList<Course> courses) {
		super(client);
		this.professor = professor;
		this.isProfessor = isProfessor;
		this.courses = courses;
		homepage = new HomePage(this, courses);
		homepage.setVisible(true);
		coursepage = new CoursePage(this, courses, "Temporary");
		gradepage = new GradePage(this, courses);
		submissionpage = new SubmissionPage(this, courses);
		enrollmentpage = new EnrollmentPage(this, courses);
	}

	public void showPage(String page) {
		if (page.equalsIgnoreCase("Home Page")) {
			homepage.setVisible(true);
			coursepage.setVisible(false);
			gradepage.setVisible(false);
			submissionpage.setVisible(false);
			enrollmentpage.setVisible(false);
		}
		else {
			homepage.setVisible(false);
			coursepage.dispose();
			coursepage = new CoursePage(this, courses, page);
			coursepage.setVisible(true);
		}
	}

}

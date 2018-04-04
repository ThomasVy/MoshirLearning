package frontEnd;

import components.PageNavigator;
import pages.CoursePage;
import pages.EnrollmentPage;
import pages.GradePage;
import pages.HomePage;
import pages.SubmissionPage;
import sharedElements.Professor;

public class ProfessorGUI extends PageNavigator {

	private Professor professor;
	private boolean isProfessor;
	private HomePage homepage;
	private CoursePage coursepage;
//	private AssignmentPage assignmentpage;
	private GradePage gradepage;
	private SubmissionPage submissionpage;
	private EnrollmentPage enrollmentpage;

	public ProfessorGUI(/*Client client, Professor professor, boolean isProfessor*/) {
//		super(client);
//		this.professor = professor;
//		this.isProfessor = isProfessor;
		homepage = new HomePage(this);
		homepage.setVisible(true);
		coursepage = new CoursePage(this);
		gradepage = new GradePage(this);
		submissionpage = new SubmissionPage(this);
		enrollmentpage = new EnrollmentPage(this);
	}

	public void showPage(String page) {
		if (page.equalsIgnoreCase("Home Page")) {
			homepage.setVisible(true);
			coursepage.setVisible(false);
			gradepage.setVisible(false);
			submissionpage.setVisible(false);
			enrollmentpage.setVisible(false);
		}
		else if (page.equalsIgnoreCase("ENCM 369")) {
			homepage.setVisible(false);
			coursepage.setVisible(true);
		}
	}

}

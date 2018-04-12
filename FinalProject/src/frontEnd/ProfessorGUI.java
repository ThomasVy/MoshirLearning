package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.PageNavigator;
import pages.CreateCoursePage;
import pages.HomePage;
import sharedElements.Course;
import sharedElements.Professor;

/**
 * The professor controller of the pages
 * @author Rainer Lim & Thomas Vy
 *
 */
public class ProfessorGUI extends PageNavigator {
	/**
	 * the course home page
	 */
	private CreateCoursePage createCoursePage;
	/**
	 * constructor for the professor gui
	 * @param client - the client
	 * @param professor - the professor user
	 */
	public ProfessorGUI(Client client, Professor professor) {
		super(client, true,professor);
	}
	/**
	 * creates the homepage page with professor only buttons
	 */
	@Override
	public void createHomePage ()
	{
		courses = getCourses();
		homePage = new HomePage(courses, isProfessor);
		addComboBoxListener(homePage);
		addCreateACourseListener();
		addHomeButtonListener(homePage);
		addLogoutButtonListener(homePage);
		homePage.setVisible(true);
	}
	/**
	 * adds create a course button listener
	 */
	private void addCreateACourseListener()
	{
		homePage.addCreateACourseListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.dispose();
				bringUpCreateACoursePage();
			}
		});
	}
	/**
	 * brings up create a course page
	 */
	private void bringUpCreateACoursePage ()
	{
		createCoursePage = new CreateCoursePage(courses, isProfessor);
		setupCreateCourseListeners();
		createCoursePage.setVisible(true);
	}
	/**
	 * setups up create course page listeners
	 */
	private void setupCreateCourseListeners()
	{
		setupEnterListener();
		setupCancelListener();
		addComboBoxListener(createCoursePage);
		addLogoutButtonListener(createCoursePage);
		addHomeButtonListener(createCoursePage);
	}
	/**
	 * initializes cancel button listener
	 */
	public void setupCancelListener()
	{
		createCoursePage.setUpCancel(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCoursePage.dispose();
				createHomePage();
			}
		});
	}
	/**
	 * initializes enter button listener
	 */
	public void setupEnterListener()
	{
		createCoursePage.setUpEnter(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseName = createCoursePage.getCourseName();
				if (courseName.length() != 0) {
					Course newCourse = new Course(user.getId(), courseName, false);
					boolean approved = (boolean) client.communicateWithServer(newCourse, "CreateNewCourse");
					if (approved == false) {
						createCoursePage.showError("Invalid input for new course.");
					} else {
						createCoursePage.dispose();
						createHomePage();
					}
				} else {
					createCoursePage.showError("Please fill in the name of the course.");
				}
			}
		});
	}
}

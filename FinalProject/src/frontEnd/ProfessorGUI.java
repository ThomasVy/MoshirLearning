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
		createACourse();
	}
	/**
	 * creates the homepage page with professor only buttons
	 */
	@Override
	public void createHomePage ()
	{
		homePage = new HomePage(isProfessor);
		addCreateACourseListener();
		addHomeButtonListener(homePage);
		addLogoutButtonListener(homePage, this);
		addCard("Homepage", homePage);
	}
	/**
	 * adds create a course button listener
	 */
	private void addCreateACourseListener()
	{
		homePage.addCreateACourseListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCard("Create Course Page", createCoursePage);
			}
		});
	}
	/**
	 * brings up create a course page
	 */
	private void createACourse ()
	{
		createCoursePage = new CreateCoursePage(isProfessor);
		setupCreateCourseListeners();
		addCard("Create Course Page", createCoursePage);
	}
	/**
	 * setups up create course page listeners
	 */
	private void setupCreateCourseListeners()
	{
		setupEnterListener();
		setupCancelListener();
		addLogoutButtonListener(createCoursePage, this);
		addHomeButtonListener(createCoursePage);
	}
	/**
	 * initializes cancel button listener
	 */
	public void setupCancelListener()
	{
		createCoursePage.setUpCancel(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCard("Homepage", homePage);
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
						showCard("Homepage", homePage);
					}
				} else {
					createCoursePage.showError("Please fill in the name of the course.");
				}
			}
		});
	}
}

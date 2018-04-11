package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import components.*;
import pages.*;
import sharedElements.*;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class ProfessorGUI extends PageNavigator {
	private CreateCoursePage createCoursePage;
	
	public ProfessorGUI(Client client, Professor professor) {
		super(client, true,professor);
	}
	@Override
	public void createHomePage ()
	{
		courses = getCourses();
		homePage = new HomePage(courses, isProfessor);
		addComboBoxListener(homePage);
		addCreateACourseListener();
		addHomeButtonListener(homePage);
		homePage.setVisible(true);
	}
	public void addCreateACourseListener()
	{
		homePage.addCreateACourseListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.dispose();
				bringUpCreateACoursePage();
			}
		});
	}
	private void bringUpCreateACoursePage ()
	{
		createCoursePage = new CreateCoursePage(courses, isProfessor);
		setupCreateCourseListeners();
		createCoursePage.setVisible(true);
	}
	private void setupCreateCourseListeners()
	{
		setupEnterListener();
		setupCancelListener();
		addComboBoxListener(createCoursePage);
		setupHomePageListener();
	}
	public void setupHomePageListener()
	{
		createCoursePage.setUpHomeButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCoursePage.dispose();
				createHomePage();
			}
		});
	}
	public void setupCancelListener()
	{
		createCoursePage.setUpCancel(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCoursePage.dispose();
				createHomePage();
			}
		});
	}
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

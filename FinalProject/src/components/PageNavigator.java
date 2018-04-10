package components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import frontEnd.*;
import pages.*;
import sharedElements.*;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */

public class PageNavigator {
	protected Client client;
	protected boolean isProfessor;
	protected HomePage homePage;
	protected User user;
	protected ArrayList<Course> courses;
	
	public PageNavigator(Client client, boolean isProfessor, User user) {
		this.isProfessor =isProfessor;
		this.client = client;
		this.user = user;
		createHomePage();
	}
	public ArrayList<Course> getCourses()
	{
		return (ArrayList<Course>)(client.communicateWithServer("GetCourses"));
	}
	public void createHomePage ()
	{
		courses = getCourses();
		homePage = new HomePage(courses, isProfessor);
		addComboBoxListener(homePage);
		homePage.setVisible(true);
	}
	public void addComboBoxListener(Page page)
	{
		page.setUpComboBoxListeners(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
						if (page.getComboBox().getSelectedIndex()!= 0) {
							page.dispose();
							showCourse((Course)page.getComboBox().getSelectedItem());
						}
				}
			}
		});
		
	}
	public void showCourse(Course currentCourse)
	{
		CourseHandler courseHandler = new CourseHandler(this, currentCourse);
	}
	public Client getClient ()
	{
		return client;
	}
	public boolean getIsProfessor ()
	{
		return isProfessor;
	}
}


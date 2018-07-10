package components;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import frontEnd.*;
import pages.*;
import sharedElements.*;
/**
 * The page organizer of the client
 * @author Rainer Lim & Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */

public class PageNavigator extends JFrame{
	/**
	 * The client
	 */
	protected Client client;
	/**
	 * The variable to check if the user is a professor
	 */
	protected JPanel cards;
	protected CardLayout cardLayout;
	protected boolean isProfessor;
	/**
	 * the home page of the gui
	 */
	protected HomePage homePage;
	/**
	 * The user that is logged in
	 */
	protected User user;
	/**
	 * The constructor of the page navigator
	 * @param client - the client of the page navigator
	 * @param isProfessor - variable to see if it is professor or not
	 * @param user - the user that is logged in
	 */
	public PageNavigator(Client client, boolean isProfessor, User user) {
		super("MoshirLearning: "+ user.getFirstName()+ " " + user.getLastName());
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.isProfessor =isProfessor;
		this.client = client;
		this.user = user;
		cards = new JPanel(new CardLayout());
		this.add(cards);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		createHomePage();
		showCard("Homepage", homePage);
	}
	/**
	 * gets the courses of the user
	 * @return - the courses the user has
	 */
	public ArrayList<Course> getCourses()
	{
		return (ArrayList<Course>)(client.communicateWithServer("GetCourses"));
	}
	/**
	 * creates the home page of the gui
	 */
	public void createHomePage ()
	{
		homePage = new HomePage(isProfessor);
		addHomeButtonListener(homePage);
		addLogoutButtonListener(homePage, this);
		addCard("Homepage", homePage);
	}
	/**
	 * sets the combo listener on the page indicated
	 * @param page the page to set the combo listener for.
	 */
	public void addComboBoxListener(Page page)
	{
		page.setUpComboBoxListeners(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
						if (page.getComboBox().getSelectedIndex()!= 0) {
							showCourse((Course)page.getComboBox().getSelectedItem());
						}
				}
			}
		});
		
	}
	/**
	 * Adds the logout button listener for a page
	 * @param page - the page to set the logout button listener for
	 */
	public void addLogoutButtonListener(Page page, JFrame main)
	{
		page.logoutButton(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.dispose();
				Client client = new Client("localhost", 9890);
				LoginWindow login = new LoginWindow("Login Window");
				LoginWindowController loginWindowController = new LoginWindowController(login, client);
			}
			
		});
	}
	/**
	 * Sets the home button listener for the page
	 * @param page - the page to set the home button listener for
	 */
	public void addHomeButtonListener(Page page)
	{
		page.setUpHomeButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.setUpComboBox(getCourses());
				addComboBoxListener(homePage);
				showCard("Homepage", page);
			}
		});
	}
	public void showCard (String name, Page page)
	{
		page.setUpComboBox(getCourses());
		addComboBoxListener(page);
		cardLayout = (CardLayout)cards.getLayout();
		cardLayout.show(cards, name);
	}
	public void addCard (String name, Page page)
	{
		cards.add(page, name);
	}
	/**
	 * shows the course page for course selected
	 * @param currentCourse - the course of the course page to be shown
	 */
	private void showCourse(Course currentCourse)
	{
		CourseHandler courseHandler = new CourseHandler(this, currentCourse);
	}
	/**
	 * Gets the client 
	 * @return - the client 
	 */
	public Client getClient ()
	{
		return client;
	}
	/**
	 * gets isProfessor variable
	 * @return - the variable to tell if the user is a professor
	 */
	public boolean getIsProfessor ()
	{
		return isProfessor;
	}
}


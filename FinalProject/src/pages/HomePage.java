package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sharedElements.Course;

/**
 * Provides the fields and methods required to create a HomePage object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class HomePage extends Page {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -3545705796373525988L;

	/**
	 * Constructs a HomePage object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 */
	public HomePage(ArrayList<Course> courses, boolean isProfessor) {
		super(courses, isProfessor);
		if (isProfessor == true) {
			createNewCourseButton = new JButton("Create New Course");
			createNewCourseButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			createNewCourseButton.setForeground(Color.WHITE);
			createNewCourseButton.setBackground(new Color(135, 206, 235));
			bottomPanel.add(createNewCourseButton);
		}

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel homePageTitlePanel = new JPanel();
		contentPanel.add(homePageTitlePanel);

		JLabel homePageTitle = new JLabel("Home Page");
		homePageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		homePageTitlePanel.add(homePageTitle);

		JPanel helloEverybodyPanel = new JPanel();
		contentPanel.add(helloEverybodyPanel);

		JLabel helloEverybody = new JLabel("Hello Everybody");
		helloEverybody.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		helloEverybodyPanel.add(helloEverybody);

		JPanel homePageBottomPanel = new JPanel();
		contentPanel.add(homePageBottomPanel);
	}

	// Listeners:

	/**
	 * Adds a listener to the create new course button.
	 * @param e - the action listener to be added
	 */
	public void addCreateACourseListener(ActionListener e) {
		createNewCourseButton.addActionListener(e);
	}

}

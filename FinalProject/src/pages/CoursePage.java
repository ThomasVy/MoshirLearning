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
 * Provides the fields and methods required to create a CoursePage.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class CoursePage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -5422193522154528362L;
	/**
	 * The change course activity button of the CoursePage.
	 */
	private JButton changeCourseActivityButton;
	/**
	 * The send email button CoursePage.
	 */
	private JButton sendEmailButton;

	/**
	 * Constructs a CoursePage.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param courseOfThePage - the current course
	 */
	public CoursePage(ArrayList<Course> courses, boolean isProfessor, Course courseOfThePage) {
		super(courses, isProfessor, courseOfThePage);

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel coursePageTitlePanel = new JPanel();
		contentPanel.add(coursePageTitlePanel);

		JLabel coursePageTitle = new JLabel("Course Page");
		coursePageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		coursePageTitlePanel.add(coursePageTitle);

		JPanel sendEmailPanel = new JPanel();
		contentPanel.add(sendEmailPanel);
		String emailLabel = "Send Email to Course Professor";
		if (isProfessor == true) {
			emailLabel = "Send Email to All Students";
		}
		JLabel sendEmailLabel = new JLabel(emailLabel);
		sendEmailLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		sendEmailPanel.add(sendEmailLabel);

		sendEmailButton = new JButton("Email");
		sendEmailButton.setForeground(Color.WHITE);
		sendEmailButton.setBackground(new Color(135, 206, 235));
		sendEmailButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		sendEmailPanel.add(sendEmailButton);
		JPanel changeCourseActivityPanel = new JPanel();
		contentPanel.add(changeCourseActivityPanel);

		if (isProfessor == true) {
			JLabel changeCourseActivityLabel = new JLabel("Click to Change Course Activity");
			changeCourseActivityLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			changeCourseActivityButton = new JButton();
			changeCourseActivityPanel.add(changeCourseActivityLabel);
			String active;
			if (courseOfThePage.getActive() == true) {
				changeCourseActivityButton.setBackground(new Color(60, 179, 113));
				active = "Course Active";
			} else {
				changeCourseActivityButton.setBackground(new Color(250, 128, 114));
				active = "Course Inactive";
			}
			changeCourseActivityButton.setText(active);
			changeCourseActivityButton.setForeground(Color.WHITE);
			changeCourseActivityButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			changeCourseActivityPanel.add(changeCourseActivityButton);
		}
	}

	// Setters:

	/**
	 * Sets the colour and text of the change course activity button when clicked.
	 * @param toSet - the text to which it will set
	 * @param colour - the colour to which it will set
	 */
	public void setActiveButton(String toSet, Color colour) {
		changeCourseActivityButton.setText(toSet);
		changeCourseActivityButton.setBackground(colour);
	}

	// Listeners:

	/**
	 * Sets up the send email button.
	 * @param e - the action listener to be added
	 */
	public void setupSendEmail(ActionListener e) {
		sendEmailButton.addActionListener(e);
	}

	/**
	 * Sets up the change course activity button.
	 * @param e - the action listener to be added
	 */
	public void setupCourseActiveButton(ActionListener e) {
		changeCourseActivityButton.addActionListener(e);
	}

}

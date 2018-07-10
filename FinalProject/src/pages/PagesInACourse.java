package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import sharedElements.Course;

/**
 * Provides the fields and methods required to create a PagesInACourse object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class PagesInACourse extends Page {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -9189685996244057300L;

	/**
	 * The course of the page.
	 */
	protected Course courseOfThePage;

	/**
	 * Constructs a PagesInACourse object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param courseOfThePage - the course of the page
	 */
	public PagesInACourse(boolean isProfessor, Course courseOfThePage) {
		super(isProfessor);
		this.courseOfThePage = courseOfThePage;

		assignmentsButton = new JButton("Assignments");
		assignmentsButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		assignmentsButton.setForeground(Color.WHITE);
		assignmentsButton.setBackground(new Color(135, 206, 235));
		bottomPanel.add(assignmentsButton);

		if (!isProfessor) {
			gradesButton = new JButton("Grades");
			gradesButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			gradesButton.setForeground(Color.WHITE);
			gradesButton.setBackground(new Color(135, 206, 235));
			bottomPanel.add(gradesButton);
		}

		submissionsButton = new JButton("Submissions");
		submissionsButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		submissionsButton.setForeground(Color.WHITE);
		submissionsButton.setBackground(new Color(135, 206, 235));
		bottomPanel.add(submissionsButton);

		courseTitle = new JLabel(courseOfThePage.getName());
		courseTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		courseTitlePanel.add(courseTitle);

		enrollmentButton = new JButton("Enrollment");
		enrollmentButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		enrollmentButton.setForeground(Color.WHITE);
		enrollmentButton.setBackground(new Color(135, 206, 235));
		bottomPanel.add(enrollmentButton);

	}

	// Listeners:

	/**
	 * Adds action listener to the assignments button.
	 * @param e - the action listener to be added
	 */
	public void addAssignmentsButtonListener(ActionListener e) {
		assignmentsButton.addActionListener(e);
	}

	/**
	 * Adds action listener to the grades button.
	 * @param e - the action listener to be added
	 */
	public void addGradesButtonListener(ActionListener e) {
		if (!isProfessor) {
			gradesButton.addActionListener(e);
		}
	}

	/**
	 * Adds action listener to the submissions button.
	 * @param e - the action listener to be added
	 */
	public void addSubmissionsButtonListener(ActionListener e) {
		submissionsButton.addActionListener(e);
	}

	/**
	 * Adds action listener to the enrollment button.
	 * @param e - the action listener to be added
	 */
	public void addEnrollmentButtonListener(ActionListener e) {
		enrollmentButton.addActionListener(e);
	}

}

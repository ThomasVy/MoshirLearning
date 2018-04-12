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
import javax.swing.JTextField;
import sharedElements.Course;

/**
 * Provides the fields and methods required to create a CreateCoursePage.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class CreateCoursePage extends Page {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 5505662382195321247L;
	/**
	 * The name of the course field of the CreateCoursePage.
	 */
	private JTextField nameOfCourseField;
	/**
	 * The enter button of the CreateCoursePage.
	 */
	private JButton enter;
	/**
	 * The cancel button of the CreateCoursePage.
	 */
	private JButton cancel;

	/**
	 * Constructs a CreateCoursePage.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 */
	public CreateCoursePage(ArrayList<Course> courses, boolean isProfessor) {
		super(courses, isProfessor);
		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel createCoursePageTitlePanel = new JPanel();
		contentPanel.add(createCoursePageTitlePanel);

		JLabel createCoursePageTitle = new JLabel("Create Course Page");
		createCoursePageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		createCoursePageTitlePanel.add(createCoursePageTitle);

		JPanel nameOfCoursePanel = new JPanel();
		contentPanel.add(nameOfCoursePanel);

		JLabel nameOfCourseLabel = new JLabel("Name of Course");
		nameOfCourseLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		nameOfCoursePanel.add(nameOfCourseLabel);

		nameOfCourseField = new JTextField();
		nameOfCourseField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		nameOfCoursePanel.add(nameOfCourseField);
		nameOfCourseField.setColumns(10);

		enter = new JButton("Enter");
		enter.setForeground(Color.WHITE);
		enter.setBackground(new Color(135, 206, 235));
		enter.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		nameOfCoursePanel.add(enter);

		JPanel createCoursePageBottomPanel = new JPanel();
		contentPanel.add(createCoursePageBottomPanel);
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(new Color(135, 206, 235));
		bottomPanel.add(cancel);
	}

	// Getters:


	/**
	 * Gets the name of the new course.
	 * @return the name of the new course
	 */
	public String getCourseName() {
		return nameOfCourseField.getText();
	}

	// Setters:

	/**
	 * Sets up the enter button.
	 * @param e - the action listener to be added
	 */
	public void setUpEnter(ActionListener e) {
		enter.addActionListener(e);
	}

	/**
	 * Sets up the cancel button.
	 * @param e - the action listener to be added
	 */
	public void setUpCancel(ActionListener e) {
		cancel.addActionListener(e);
	}

}

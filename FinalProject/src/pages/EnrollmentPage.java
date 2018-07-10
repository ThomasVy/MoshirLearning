package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import sharedElements.Course;
import sharedElements.Student;


/**
 * Provides the fields and methods required to create an EnrollmentPage object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class EnrollmentPage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 3731092531537036971L;
	/**
	 * The search field of the EnrollmentPage.
	 */
	private JTextField searchField;
	/**
	 * The student id field of the EnrollmentPage.
	 */
	private JTextField studentIdField;
	/**
	 * The model of the EnrollmentPage.
	 */
	private DefaultListModel<Student> model;
	/**
	 * The enrollment list of the EnrollmentPage.
	 */
	private JList<Student> enrollmentList;
	/**
	 * The enrollment list scroll pane of the EnrollmentPage.
	 */
	private JScrollPane enrollmentListScrollPane;
	/**
	 * The enroll button of the EnrollmentPage.
	 */
	private JButton enroll;
	/**
	 * The unenroll button of the EnrollmentPage.
	 */
	private JButton unenroll;
	/**
	 * The search button of the EnrollmentPage.
	 */
	private JButton search;
	/**
	 * The id radio button of the EnrollmentPage.
	 */
	private JRadioButton idRadioButton;
	/**
	 * The last name radio button of the EnrollmentPage.
	 */
	private JRadioButton lastNameRadioButton;

	/**
	 * Constructs an EnrollmentPage object.
	 */
	public EnrollmentPage(ArrayList<Course> courses, boolean isProfessor, Course courseOfThisPage) {
		super(isProfessor, courseOfThisPage);

		JPanel contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		contentPanel.add(titlePanel);

		JLabel enrollmentTitle = new JLabel("Enrollment Page");
		enrollmentTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		titlePanel.add(enrollmentTitle);

		JPanel listLabelsPanel = new JPanel();
		contentPanel.add(listLabelsPanel);
		listLabelsPanel.setLayout(new BoxLayout(listLabelsPanel, BoxLayout.X_AXIS));

		JLabel listLabels = new JLabel(
				"Student ID  First Name  Last Name                                                                                                   ");
		listLabels.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		listLabelsPanel.add(listLabels);

		JPanel listPanel = new JPanel();
		contentPanel.add(listPanel);

		model = new DefaultListModel<Student>();
		enrollmentList = new JList<Student>(model);
		enrollmentListScrollPane = new JScrollPane(enrollmentList);
		enrollmentList.setFixedCellWidth(500);
		enrollmentList.setFixedCellHeight(25);
		enrollmentList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		listPanel.add(enrollmentListScrollPane);
		JPanel bottomPanel = new JPanel();
		contentPanel.add(bottomPanel);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

		JPanel bottomSearchPanel = new JPanel();
		bottomPanel.add(bottomSearchPanel);
		bottomSearchPanel.setLayout(new BoxLayout(bottomSearchPanel, BoxLayout.Y_AXIS));

		JPanel searchTitlePanel = new JPanel();
		bottomSearchPanel.add(searchTitlePanel);

		JLabel searchTitle = new JLabel("Search for Student:");
		searchTitle.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		searchTitlePanel.add(searchTitle);

		JPanel searchPanel = new JPanel();
		bottomSearchPanel.add(searchPanel);

		JLabel nameOfStudent = new JLabel("Search Field");
		nameOfStudent.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		searchPanel.add(nameOfStudent);

		searchField = new JTextField();
		searchField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		searchPanel.add(searchField);
		searchField.setColumns(10);

		idRadioButton = new JRadioButton("ID");
		idRadioButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		lastNameRadioButton = new JRadioButton("Last Name");
		lastNameRadioButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		search = new JButton("Search");
		JPanel searchOptionsPanel = new JPanel();
		searchPanel.add(searchOptionsPanel);
		searchOptionsPanel.setLayout(new BoxLayout(searchOptionsPanel, BoxLayout.Y_AXIS));

		searchOptionsPanel.add(idRadioButton);
		searchOptionsPanel.add(lastNameRadioButton);

		search.setBackground(new Color(135, 206, 235));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		searchPanel.add(search);

		ButtonGroup bg = new ButtonGroup();
		bg.add(idRadioButton);
		bg.add(lastNameRadioButton);
		if (isProfessor == true) {
			JPanel bottomAddStudentPanel = new JPanel();
			bottomPanel.add(bottomAddStudentPanel);
			bottomAddStudentPanel.setLayout(new BoxLayout(bottomAddStudentPanel, BoxLayout.Y_AXIS));

			JPanel addStudentPanel = new JPanel();
			bottomAddStudentPanel.add(addStudentPanel);
			addStudentPanel.setLayout(new BoxLayout(addStudentPanel, BoxLayout.Y_AXIS));

			JPanel addStudentTitlePanel = new JPanel();
			addStudentPanel.add(addStudentTitlePanel);

			JLabel addStudentTitle = new JLabel("Add New Student:");
			addStudentTitle.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
			addStudentTitlePanel.add(addStudentTitle);

			JPanel studentIdPanel = new JPanel();
			addStudentPanel.add(studentIdPanel);

			JLabel studentId = new JLabel("Student's ID");
			studentId.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			studentIdPanel.add(studentId);

			studentIdField = new JTextField();
			studentIdField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			studentIdPanel.add(studentIdField);
			studentIdField.setColumns(10);

			JPanel addStudentButtonsPanel = new JPanel();
			bottomAddStudentPanel.add(addStudentButtonsPanel);

			enroll = new JButton("Enroll");
			enroll.setForeground(Color.WHITE);
			enroll.setBackground(new Color(135, 206, 235));
			enroll.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			addStudentButtonsPanel.add(enroll);

			unenroll = new JButton("Unenroll");
			unenroll.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			unenroll.setForeground(Color.WHITE);
			unenroll.setBackground(new Color(135, 206, 235));
			addStudentButtonsPanel.add(unenroll);
		}
	}

	// Getters:

	/**
	 * Gets the search field text.
	 * @return the search field text.
	 */
	public String getSearchField() {
		return searchField.getText();
	}

	/**
	 * Gets the student id text.
	 * @return the student id text
	 */
	public String getId() {
		return studentIdField.getText();
	}

	/**
	 * Gets the list of the EnrollmentPage.
	 * @return enrollmentList - the list of the EnrollmentPage
	 */
	public JList<Student> getList() {
		return enrollmentList;
	}


	/**
	 * Gets the selected radio button.
	 * @return 'I' if id radio button is selected, 'L' is last name radio button is selected, '0' otherwise
	 */
	public char selectedRadioButton() {
		if (idRadioButton.isSelected()) {
			return 'I';
		} else if (lastNameRadioButton.isSelected()) {
			return 'L';
		}
		return '0';
	}

	// Setters:

	/**
	 * Sets the list of the EnrollmentPage.
	 * @param students - the list to which it will set
	 */
	public void setEnrollList(ArrayList<Student> students) {
		model.clear();
		for (int i = 0; i < students.size(); i++) {
			model.addElement(students.get(i));
		}
	}

	// Listeners:

	/**
	 * Sets up the enroll button.
	 * @param e - the action listener to be added
	 */
	public void setupEnrollButton(ActionListener e) {
		enroll.addActionListener(e);
	}

	/**
	 * Sets up the unenroll button.
	 * @param e - the action listener to be added
	 */
	public void setupUnenrollButton(ActionListener e) {
		unenroll.addActionListener(e);
	}

	/**
	 * Sets up the search button.
	 * @param e - the action listener to be added
	 */
	public void setupSearch(ActionListener e) {
		search.addActionListener(e);
	}

}

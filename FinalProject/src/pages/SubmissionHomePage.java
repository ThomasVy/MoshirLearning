package pages;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import sharedElements.Assignment;
import sharedElements.Course;

/**
 * Provides the fields and methods required to create a SubmissionHomePage object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class SubmissionHomePage extends PagesInACourse {

	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 8989212118136792803L;
	/**
	 * The model of the SubmissionHomePage.
	 */
	private DefaultListModel<Assignment> model;
	/**
	 * The list of the SubmissionHomePage.
	 */
	private JList<Assignment> dropboxList;
	/**
	 * The scroll pane of the SubmissionHomePage.
	 */
	private JScrollPane dropboxListScrollPane;

	/**
	 * Constructs a SubmisisonHomePage object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param selectedCourse - the current course
	 */
	public SubmissionHomePage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses, isProfessor, selectedCourse);

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1);

		JLabel submissionHomePageTitle = new JLabel("Submissions Page");
		submissionHomePageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(submissionHomePageTitle);

		JPanel listLabelsPanel = new JPanel();
		contentPanel.add(listLabelsPanel);
		listLabelsPanel.setLayout(new BoxLayout(listLabelsPanel, BoxLayout.X_AXIS));

		JLabel listLabels = new JLabel("Title              Due Date         State                                                                                       ");
		listLabels.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		listLabelsPanel.add(listLabels);

		JPanel listPanel = new JPanel();
		contentPanel.add(listPanel);
		model = new DefaultListModel<Assignment>();
		dropboxList = new JList<Assignment>(model);
		dropboxListScrollPane = new JScrollPane(dropboxList);
		dropboxList.setFixedCellWidth(500);
		dropboxList.setFixedCellHeight(25);
		dropboxList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		listPanel.add(dropboxListScrollPane);
		JPanel bottomPanel = new JPanel();
		contentPanel.add(bottomPanel);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

		JPanel bottomBottomPanel = new JPanel();
		bottomPanel.add(bottomBottomPanel);
	}

	// Getters:

	/**
	 * Gets the list of the SubmissionHomePage.
	 * @return dropboxList - the list of the SubmissionHomePage
	 */
	public JList<Assignment> getList() {
		return dropboxList;
	}

	// Setters:

	/**
	 * Sets the list of the SubmissionHomePage.
	 * @param assignmentList - the list to which it will set
	 */
	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		model.clear();
		for (int i = 0; i < assignmentList.size(); i++) {
			model.addElement(assignmentList.get(i));
		}
	}

	// Listeners:

	/**
	 * Sets up the dropbox list.
	 * @param e - the list selection listener to be added
	 */
	public void setupListListener(ListSelectionListener e) {
		dropboxList.addListSelectionListener(e);
	}

}

package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import sharedElements.Assignment;
import sharedElements.Course;


/**
 * Provides the fields and methods required to create an AssignmentPage object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class AssignmentPage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 3796826414520152234L;
	private DefaultListModel<Assignment> model;
	private JList<Assignment> assignmentsList;
	private JScrollPane assignmentsListScrollPane;
	private JTextField titleField;
	private JTextField dueDateField;
	private JButton assignmentUpload;
	private JButton assignmentDelete;
	private JButton assignmentChangeState;
	private JButton assignmentDownload;

	/**
	 * Constructs an AssignmentPage object.
	 */
	public AssignmentPage(ArrayList<Course> courses, boolean isProfessor, Course courseOfThisPage) {
		super(isProfessor, courseOfThisPage);

		JPanel contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel assignmentsPageTitlePanel = new JPanel();
		contentPanel.add(assignmentsPageTitlePanel);

		JLabel assignmentsPageTitle = new JLabel("Assignments Page");
		assignmentsPageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		assignmentsPageTitlePanel.add(assignmentsPageTitle);

		JPanel listLabelsPanel = new JPanel();
		contentPanel.add(listLabelsPanel);
		listLabelsPanel.setLayout(new BoxLayout(listLabelsPanel, BoxLayout.X_AXIS));

		JLabel listLabels = new JLabel(
				"Title              Due Date         State                                                                                       ");
		listLabels.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		listLabelsPanel.add(listLabels);

		JPanel assignmentsListPanel = new JPanel();
		contentPanel.add(assignmentsListPanel);
		model = new DefaultListModel<Assignment>();
		assignmentsList = new JList<Assignment>(model);
		assignmentsListScrollPane = new JScrollPane(assignmentsList);
		assignmentsList.setFixedCellWidth(500);
		assignmentsList.setFixedCellHeight(25);
		assignmentsList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		assignmentsListPanel.add(assignmentsListScrollPane);
		JPanel assignmentOptionsPanel = new JPanel();
		contentPanel.add(assignmentOptionsPanel);
		assignmentOptionsPanel.setLayout(new BoxLayout(assignmentOptionsPanel, BoxLayout.Y_AXIS));

		JPanel assignmentOptionsTitlePanel = new JPanel();
		assignmentOptionsPanel.add(assignmentOptionsTitlePanel);
		assignmentOptionsTitlePanel.setLayout(new BoxLayout(assignmentOptionsTitlePanel, BoxLayout.X_AXIS));

		JLabel assignmentOptionsTitle = new JLabel("Assignment Options:");
		assignmentOptionsTitle.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		assignmentOptionsTitlePanel.add(assignmentOptionsTitle);

		JPanel assignmentOptionsFields = new JPanel();
		assignmentOptionsPanel.add(assignmentOptionsFields);
		if (isProfessor == true) {
			JLabel assignmentTitleLabel = new JLabel("Title");
			assignmentTitleLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentOptionsFields.add(assignmentTitleLabel);
			titleField = new JTextField();
			titleField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentOptionsFields.add(titleField);
			titleField.setColumns(10);

			JLabel assignmentDueDateLabel = new JLabel("Due Date");
			assignmentDueDateLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentOptionsFields.add(assignmentDueDateLabel);

			dueDateField = new JTextField();
			dueDateField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentOptionsFields.add(dueDateField);
			dueDateField.setColumns(10);

			JPanel assignmentButtonsPanel = new JPanel();
			assignmentOptionsPanel.add(assignmentButtonsPanel);
			assignmentUpload = new JButton("Upload");
			assignmentUpload.setForeground(Color.WHITE);
			assignmentUpload.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentUpload.setBackground(new Color(135, 206, 235));
			assignmentButtonsPanel.add(assignmentUpload);

			assignmentDelete = new JButton("Delete");
			assignmentDelete.setForeground(Color.WHITE);
			assignmentDelete.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentDelete.setBackground(new Color(135, 206, 235));
			assignmentButtonsPanel.add(assignmentDelete);
			assignmentChangeState = new JButton("Change Active State");
			assignmentChangeState.setForeground(Color.WHITE);
			assignmentChangeState.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentChangeState.setBackground(Color.DARK_GRAY);
			assignmentButtonsPanel.add(assignmentChangeState);
		} else {
			JPanel assignmentBottomPanel = new JPanel();
			assignmentOptionsPanel.add(assignmentBottomPanel);
			assignmentDownload = new JButton("Download");
			assignmentDownload.setForeground(Color.WHITE);
			assignmentDownload.setBackground(new Color(135, 206, 235));
			assignmentDownload.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assignmentOptionsFields.add(assignmentDownload);
		}
	}

	// Getters:

	/**
	 * Gets the assignments list.
	 * @return the assignments list
	 */
	public JList<Assignment> getList() {
		return assignmentsList;
	}

	/**
	 * Gets the assignment title.
	 * @return the assignment title
	 */
	public String getAssignmentTitle() {
		return titleField.getText();
	}

	/**
	 * Gets the assignment due date.
	 * @return the assignment due date
	 */
	public String getAssignmentDueDate() {
		return dueDateField.getText();
	}

	// Setters:

	/**
	 * Sets the assignment list of the AssignmentPage.
	 * @param assignmentList - the assignment list to which it will set
	 */
	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		model.clear();
		for (int i = 0; i < assignmentList.size(); i++) {
			model.addElement(assignmentList.get(i));
		}
	}

	// Listeners:

	/**
	 * Sets up the upload button.
	 * @param e - the action listener to be added
	 */
	public void setupUploadButton(ActionListener e) {
		assignmentUpload.addActionListener(e);
	}

	/**
	 * Sets up the delete button.
	 * @param e - the action listener to be added
	 */
	public void setupDeleteButton(ActionListener e) {
		assignmentDelete.addActionListener(e);
	}

	/**
	 * Sets up the change state button.
	 * @param e - the action listener to be added
	 */
	public void setupChangeActionButton(ActionListener e) {
		assignmentChangeState.addActionListener(e);
	}

	/**
	 * Sets up the download button.
	 * @param e - the action listener to be added
	 */
	public void setupDownloadButton(ActionListener e) {
		assignmentDownload.addActionListener(e);
	}

}

package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import sharedElements.Submission;

/**
 * Provides the fields and methods required to create SubmissionPage object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class SubmissionPage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -4888755843845796203L;
	/**
	 * The model of the SubmissionPage.
	 */
	private DefaultListModel<Submission> model;
	/**
	 * The list of the SubmissionPage.
	 */
	private JList<Submission> submissionList;
	/**
	 * The scroll pane of the SubmissionPage.
	 */
	private JScrollPane submissionListScrollPane;
	/**
	 * The title field of the SubmissionPage.
	 */
	private JTextField titleField;
	/**
	 * The upload button of the SubmissionPage.
	 */
	private JButton uploadButton;
	/**
	 * The download button of the SubmissionPage.
	 */
	private JButton downloadButton;
	/**
	 * The assess button of the SubmissionPage.
	 */
	private JButton assessButton;
	/**
	 * The assignment of the SubmissionPage.
	 */
	private Assignment assignment;

	/**
	 * Constructs a SubmissionPage object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param selectedCourse - the current course
	 * @param a - the assignment of the SubmissionPage
	 */
	public SubmissionPage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse, Assignment a) {
		super(courses, isProfessor, selectedCourse);
		this.assignment = a;

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		contentPanel.add(titlePanel);

		JLabel dropBoxTitle = new JLabel(assignment.getTitle());
		dropBoxTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		titlePanel.add(dropBoxTitle);

		JPanel listLabelsPanel = new JPanel();
		contentPanel.add(listLabelsPanel);
		listLabelsPanel.setLayout(new BoxLayout(listLabelsPanel, BoxLayout.X_AXIS));

		JLabel listLabels = new JLabel("Title     Student ID    Timestamp  Grade  Comments                                                                              ");
		listLabels.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		listLabelsPanel.add(listLabels);

		JPanel listPanel = new JPanel();
		contentPanel.add(listPanel);
		model = new DefaultListModel<Submission>();
		submissionList = new JList<Submission>(model);
		submissionListScrollPane = new JScrollPane(submissionList);
		submissionList.setFixedCellWidth(500);
		submissionList.setFixedCellHeight(25);
		submissionList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		listPanel.add(submissionListScrollPane);
		JPanel bottomPanel = new JPanel();
		contentPanel.add(bottomPanel);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

		JPanel submissionOptionsPanel = new JPanel();
		bottomPanel.add(submissionOptionsPanel);
		submissionOptionsPanel.setLayout(new BoxLayout(submissionOptionsPanel, BoxLayout.Y_AXIS));

		JLabel submissionOptions = new JLabel("Submission Options:");
		submissionOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
		submissionOptions.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		submissionOptionsPanel.add(submissionOptions);

		JPanel submissionOptionsButtonsPanel = new JPanel();
		submissionOptionsPanel.add(submissionOptionsButtonsPanel);

		if (isProfessor) {
			downloadButton = new JButton("Download");
			downloadButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			downloadButton.setForeground(Color.WHITE);
			downloadButton.setBackground(new Color(135, 206, 235));
			submissionOptionsButtonsPanel.add(downloadButton);

			assessButton = new JButton("Assess");
			assessButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			assessButton.setForeground(Color.WHITE);
			assessButton.setBackground(new Color(135, 206, 235));
			submissionOptionsButtonsPanel.add(assessButton);
		}

		JPanel submissionOptionsBottomPanel = new JPanel();
		bottomPanel.add(submissionOptionsBottomPanel);
		if (isProfessor == false) {
			JLabel lblSubmissionTitle = new JLabel("Title");
			lblSubmissionTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			submissionOptionsBottomPanel.add(lblSubmissionTitle);
			titleField = new JTextField();
			titleField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			submissionOptionsBottomPanel.add(titleField);
			titleField.setColumns(10);

			JPanel panel_5 = new JPanel();
			bottomPanel.add(panel_5);
			uploadButton = new JButton("Upload");
			uploadButton.setForeground(Color.WHITE);
			uploadButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			uploadButton.setBackground(new Color(135, 206, 235));
			panel_5.add(uploadButton);
		}
	}

	// Getters:

	/**
	 * Gets the list of the SubmissionPage.
	 * @return submissionList - the list of the SubmissionPage
	 */
	public JList<Submission> getList() {
		return submissionList;
	}

	/**
	 * Gets the title field of the SubmissionPage.
	 * @return the title field of the SubmissionPage
	 */
	public String getSubmissionTitle() {
		return titleField.getText();
	}

	/**
	 * Gets the assignment of the SubmissionPage.
	 * @return assignment - the assignment of the SubmissionPage
	 */
	public Assignment getAssignment() {
		return assignment;
	}

	// Setters:

	/**
	 * Sets the list of the SubmissionPage.
	 * @param submissionList - the list to which it will set
	 */
	public void setSubmissionList(ArrayList<Submission> submissionList) {
		model.clear();
		for (int i = 0; i < submissionList.size(); i++) {
			model.addElement(submissionList.get(i));
		}
	}

	// Listeners:

	/**
	 * Sets up the upload button.
	 * @param e - the action listener to be added
	 */
	public void setupUploadButton(ActionListener e) {
		uploadButton.addActionListener(e);
	}

	/**
	 * Sets up the download button.
	 * @param e - the action listener to be added
	 */
	public void setupDownloadButton(ActionListener e) {
		downloadButton.addActionListener(e);
	}

	/**
	 * Sets up the assess button.
	 * @param e - the action listener to be added
	 */
	public void setupAssessButton(ActionListener e) {
		assessButton.addActionListener(e);
	}

}

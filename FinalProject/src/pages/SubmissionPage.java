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
import sharedElements.Submission;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class SubmissionPage extends PagesInACourse {

	private static final long serialVersionUID = 1L; // The serial version UID
	private DefaultListModel<Submission> model;
	private JList<Submission> list;
	private JScrollPane scrollPane;
	private JTextField titleField;
	private JTextField assignmentIdField;
	private JButton uploadButton;
	private JButton deleteButton;

	public SubmissionPage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses, isProfessor, selectedCourse);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblSubmissionsPage = new JLabel("Submissions Page");
		lblSubmissionsPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblSubmissionsPage);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		model = new DefaultListModel<Submission>();
		list = new JList<Submission>(model);
		scrollPane = new JScrollPane(list);
		list.setFixedCellWidth(500);
		list.setFixedCellHeight(25);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		panel_2.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblNewLabel = new JLabel("Submission Options:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		panel_4.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		if(isProfessor == false)
		{
			JLabel lblSubmissionTitle = new JLabel("Title");
			lblSubmissionTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(lblSubmissionTitle);
			titleField = new JTextField();
			titleField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(titleField);
			titleField.setColumns(10);
			
			JLabel lblAssignmentId = new JLabel("Assignment ID");
			lblAssignmentId.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(lblAssignmentId);

			assignmentIdField = new JTextField();
			assignmentIdField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(assignmentIdField);
			assignmentIdField.setColumns(10);
			
			JPanel panel_5 = new JPanel();
			panel_3.add(panel_5);
			uploadButton = new JButton("Upload");
			uploadButton.setForeground(Color.WHITE);
			uploadButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			uploadButton.setBackground(new Color(135, 206, 235));
			panel_5.add(uploadButton);
			
			deleteButton = new JButton("Delete");
			deleteButton.setForeground(Color.WHITE);
			deleteButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			deleteButton.setBackground(new Color(135, 206, 235));
			panel_5.add(deleteButton);	
		}
	}
	public void setupUploadButton (ActionListener e)
	{
		uploadButton.addActionListener(e);
	}
	public void setupDeleteButton (ActionListener e)
	{
		deleteButton.addActionListener(e);
	}
	public void setSubmissionList (ArrayList<Submission> submissionList)
	{
		model.clear();
		for (int i = 0; i < submissionList.size(); i++) {
			model.addElement(submissionList.get(i));
		}
	}
	public String getSubmissionTitle ()
	{
		return titleField.getText();
	}
	public String getSubmissionAssignmentId() {
		return assignmentIdField.getText();
	}
	public JList<Submission> getList ()
	{
		return list;
	}

}

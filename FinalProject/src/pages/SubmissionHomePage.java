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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class SubmissionHomePage extends PagesInACourse {

	private static final long serialVersionUID = 1L; // The serial version UID
	private DefaultListModel<Assignment> model;
	private JList<Assignment> list;
	private JScrollPane scrollPane;
	private JTextField titleField;
	private JTextField assignmentIdField;
	private JButton createButton;
	private JButton deleteButton;

	public SubmissionHomePage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
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
		model = new DefaultListModel<Assignment>();
		list = new JList<Assignment>(model);
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
	}

	public void setupListListener(ListSelectionListener e) {
		list.addListSelectionListener(e);
	}

	public void setAssignmentList(ArrayList<Assignment> assignmentList)
	{
		model.clear();
		for (int i = 0; i < assignmentList.size(); i++) {
			model.addElement(assignmentList.get(i));
		}
	}

	public DefaultListModel<Assignment> getModel() {
		return model;
	}
	public JList<Assignment> getList ()
	{
		return list;
	}
}

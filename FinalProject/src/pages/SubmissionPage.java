package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class SubmissionPage extends PagesInACourse {

	private static final long serialVersionUID = 1L; // The serial version UID
	/**
	 * Create the frame.
	 */
	public SubmissionPage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses,isProfessor, selectedCourse);

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
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

}

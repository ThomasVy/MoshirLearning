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

public class GradePage extends PagesInACourse {

	/**
	 * Create the frame.
	 */
	public GradePage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses, isProfessor, selectedCourse);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Grades Page");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

}

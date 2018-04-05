package pages;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import frontEnd.ProfessorGUI;
import sharedElements.Course;

public class CoursePage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursePage frame = new CoursePage(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoursePage(ProfessorGUI professorGUI,  ArrayList<Course> courses, String selectedCourse){
		super(professorGUI, courses);

		btnNewButton_2 = new JButton("Assignments");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Grades");
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("Submissions");
		btnNewButton_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_4);

		lbl = new JLabel(selectedCourse);
		lbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lbl);

		btnNewButton_5 = new JButton("Enrollment");
		btnNewButton_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_5);
		
		JLabel lbl_1 = new JLabel("Course Page");
		lbl_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_8.add(lbl_1);

		JLabel lbl_2 = new JLabel("Click to Change Course Activity");
		lbl_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_10.add(lbl_2);

		JButton btnNewButton_6 = new JButton("Course Inactive");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_6.getText().equalsIgnoreCase("Course Inactive")) {
					btnNewButton_6.setText("Course Active");
					btnNewButton_6.setBackground(SystemColor.desktop);
				} else {
					btnNewButton_6.setText("Course Inactive");
					btnNewButton_6.setBackground(Color.DARK_GRAY);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		panel_10.add(btnNewButton_6);
	}

}

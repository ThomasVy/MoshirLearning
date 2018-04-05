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
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class CoursePage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Course courseOfThePage;

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
	public CoursePage(ProfessorGUI professorGUI,  ArrayList<Course> courses, Course selectedCourse){
		super(professorGUI, courses);
		this.courseOfThePage = selectedCourse;
		
		btnNewButton_2 = new JButton("Assignments");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Grades");
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("Submissions");
		btnNewButton_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_4);
		
		lbl = new JLabel(courseOfThePage.getName());
		lbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lbl);

		btnNewButton_5 = new JButton("Enrollment");
		btnNewButton_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_5);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Course Page");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

//		JLabel lbl_2 = new JLabel("Click to Change Course Activity");
//		lbl_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
//		panel_10.add(lbl_2);
//		String active;
//		JButton btnNewButton_6 = new JButton();
//		if(courseOfThePage.getActive() == true) {
//			btnNewButton_6.setBackground(new Color(135, 206, 235));
//			active = "Course Active";
//		}
//		else {
//			btnNewButton_6.setBackground(Color.DARK_GRAY);
//			active = "Course Inactive";
//		}
//		btnNewButton_6.setText(active);
//		btnNewButton_6.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (btnNewButton_6.getText().equalsIgnoreCase("Course Inactive")) //Makes it active
//				{
//					btnNewButton_6.setText("Course Active");
//					btnNewButton_6.setBackground(new Color(135, 206, 235));
//					courseOfThePage.setActive(true);
//				} 
//				else //deactivates the course 
//				{
//					btnNewButton_6.setText("Course Inactive");
//					btnNewButton_6.setBackground(Color.DARK_GRAY);
//					courseOfThePage.setActive(false);
//				}
//				professorGUI.sendToClient(courseOfThePage, "ChangeActiveState");
//			}
//		});
//		btnNewButton_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
//		btnNewButton_6.setForeground(Color.WHITE);
//		panel_10.add(btnNewButton_6);
	}

}

package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frontEnd.ProfessorGUI;
import sharedElements.Course;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
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
	public CoursePage(ProfessorGUI professorGUI, ArrayList<Course> courses, Course courseOfThePage) {
		super(professorGUI, courses);
		this.courseOfThePage = courseOfThePage;

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

		JLabel lblNewLabel_1 = new JLabel("Click to Change Course Activity");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_1);
		String active;
		JButton btnActivity = new JButton();
		if (courseOfThePage.getActive() == true) {
			btnActivity.setBackground(new Color(60, 179, 113));
			active = "Course Active";
		} else {
			btnActivity.setBackground(new Color(250, 128, 114));
			active = "Course Inactive";
		}
		btnActivity.setText(active);
		btnActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnActivity.getText().equalsIgnoreCase("Course Inactive")) // Makes it active
				{
					btnActivity.setText("Course Active");
					btnActivity.setBackground(new Color(60, 179, 113));
					courseOfThePage.setActive(true);
				} else // deactivates the course
				{
					btnActivity.setText("Course Inactive");
					btnActivity.setBackground(new Color(250, 128, 114));
					courseOfThePage.setActive(false);
				}
				professorGUI.sendToClient(courseOfThePage, "ChangeActiveState");
			}
		});
		btnActivity.setForeground(Color.WHITE);
		btnActivity.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_2.add(btnActivity);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

}

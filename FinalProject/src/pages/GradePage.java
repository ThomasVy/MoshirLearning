package pages;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sharedElements.Course;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
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

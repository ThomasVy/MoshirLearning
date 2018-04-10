package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sharedElements.Course;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class CoursePage extends PagesInACourse {
	private JButton btnActivity;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5422193522154528362L;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CoursePage(ArrayList<Course> courses, boolean isProfessor, Course courseOfThePage) {
		super(courses, isProfessor,courseOfThePage);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("Course Page");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
				
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		String emailLabel = "Send Email to Course Professor";
		if(isProfessor == true)
		{
			emailLabel = "Send Email to All Students";
		}
		JLabel lblSendEmailTo = new JLabel(emailLabel);
		lblSendEmailTo.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_4.add(lblSendEmailTo);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setForeground(Color.WHITE);
		btnEmail.setBackground(new Color(135, 206, 235));
		btnEmail.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_4.add(btnEmail);
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
				
		if(isProfessor == true)
		{
			
			JLabel lblNewLabel_1 = new JLabel("Click to Change Course Activity");
			lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			btnActivity = new JButton();
			panel_2.add(lblNewLabel_1);
			String active;
			if (courseOfThePage.getActive() == true) {
				btnActivity.setBackground(new Color(60, 179, 113));
				active = "Course Active";
			} else {
				btnActivity.setBackground(new Color(250, 128, 114));
				active = "Course Inactive";
			}
			btnActivity.setText(active);
			btnActivity.setForeground(Color.WHITE);
			btnActivity.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_2.add(btnActivity);
		}
	}
	public void setupCourseActiveButton(ActionListener e)
	{
		btnActivity.addActionListener(e);
	}
	public void setActiveButton(String toSet, Color colour)
	{
		btnActivity.setText(toSet);
		btnActivity.setBackground(colour);
	}

}

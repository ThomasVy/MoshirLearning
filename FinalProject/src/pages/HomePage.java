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
import javax.swing.SwingConstants;

import sharedElements.Course;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class HomePage extends Page {

	public HomePage(ArrayList<Course> courses, boolean isProfessor) {
		super(courses, isProfessor);
		if(isProfessor == true)
		{
			btnNewButton_6 = new JButton("Create New Course");
			btnNewButton_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			btnNewButton_6.setForeground(Color.WHITE);
			btnNewButton_6.setBackground(new Color(135, 206, 235));
			panel_1.add(btnNewButton_6);
		}

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblHello = new JLabel("Hello Everybody");
		lblHello.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		panel_2.add(lblHello);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public void addCreateACourseListener(ActionListener e)
	{
		btnNewButton_6.addActionListener(e);
	}
}

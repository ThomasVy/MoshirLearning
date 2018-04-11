package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import components.PageNavigator;
import frontEnd.ProfessorGUI;
import sharedElements.Course;

public class PagesInACourse extends Page{
	
	private static final long serialVersionUID = -9189685996244057300L;
	protected Course courseOfThePage;
	
	public PagesInACourse(ArrayList<Course> courses, boolean isProfessor, Course courseOfThePage) {
		super(courses, isProfessor);
		this.courseOfThePage = courseOfThePage;
	
		btnNewButton_2 = new JButton("Assignments");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_2);
	
		if (!isProfessor) {
			btnNewButton_3 = new JButton("Grades");
			btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			btnNewButton_3.setForeground(Color.WHITE);
			btnNewButton_3.setBackground(new Color(135, 206, 235));
			panel_1.add(btnNewButton_3);
		}
	
		btnNewButton_4 = new JButton("Submissions");
		btnNewButton_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_4);
	
//		lbl = new JLabel(courseOfThePage.getName());
//		lbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
//		panel_4.add(lbl);
	
		btnNewButton_5 = new JButton("Enrollment");
		btnNewButton_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(135, 206, 235));
		panel_1.add(btnNewButton_5);
		
	}
	public void addAssignmentButtonListener(ActionListener e)
	{
		btnNewButton_2.addActionListener(e);
	}
	public void addGradesButtonListener(ActionListener e)
	{
		if (!isProfessor) {
			btnNewButton_3.addActionListener(e);
		}
	}
	public void addSubmissionsButtonListener(ActionListener e)
	{
		btnNewButton_4.addActionListener(e);
	}
	public void addEnrollmentButtonListener(ActionListener e)
	{
		btnNewButton_5.addActionListener(e);
	}
}

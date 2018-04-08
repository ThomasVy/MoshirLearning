package pages;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import java.awt.BorderLayout;

public class CreateCoursePage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private JTextField nameOfCourseField;
	private JButton enter;
	private JButton cancel;
	/**
	 * Launch the application.
	 */

	public CreateCoursePage(ArrayList<Course> courses, boolean isProfessor) {
		super(courses, isProfessor);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel createCoursePagePanel_1 = new JPanel();
		panel.add(createCoursePagePanel_1);
		
		JLabel lblCreateCoursePage = new JLabel("Create Course Page");
		lblCreateCoursePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		createCoursePagePanel_1.add(lblCreateCoursePage);
		
		JPanel createCoursePagePanel_2 = new JPanel();
		panel.add(createCoursePagePanel_2);
		
		JLabel lblNewLabel = new JLabel("Name of Course");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		createCoursePagePanel_2.add(lblNewLabel);
		
		nameOfCourseField = new JTextField();
		nameOfCourseField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		createCoursePagePanel_2.add(nameOfCourseField);
		nameOfCourseField.setColumns(10);
		
		enter = new JButton("Enter");
		enter.setForeground(Color.WHITE);
		enter.setBackground(new Color(135, 206, 235));
		enter.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		createCoursePagePanel_2.add(enter);
		
		JPanel createCoursePagePanel_3 = new JPanel();
		panel.add(createCoursePagePanel_3);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(new Color(135, 206, 235));
		panel_1.add(cancel);
	}
	public void setUpEnter(ActionListener e)
	{
		enter.addActionListener(e);
	}
	public void setUpCancel(ActionListener e)
	{
		cancel.addActionListener(e);
	}
	public String getCourseName() {
		return nameOfCourseField.getText();
	}

}

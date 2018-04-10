package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import frontEnd.ProfessorGUI;
import sharedElements.*;
import javax.swing.JTextField;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class AssignmentPage extends PagesInACourse {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<Assignment> model;
	private JList<Assignment> list;
	private JScrollPane scrollPane;
	private JTextField titleField;
	private JTextField dueDateField;
	private JButton uploadButton;
	private JButton deleteButton;
	private JButton changeStateButton;

	public AssignmentPage(ArrayList<Course> courses, boolean isProfessor,  Course courseOfThisPage) {
		super(courses, isProfessor, courseOfThisPage);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblAssignmentsPage = new JLabel("Assignments Page");
		lblAssignmentsPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblAssignmentsPage);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		model = new DefaultListModel<Assignment>();
		list = new JList<Assignment>(model);
		scrollPane = new JScrollPane(list);
		list.setFixedCellWidth(500);
		list.setFixedCellHeight(25);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		panel_2.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblNewLabel = new JLabel("Assignment Options:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		panel_4.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		if(isProfessor == true)
		{
			JLabel lblAssignmentTitle = new JLabel("Title");
			lblAssignmentTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(lblAssignmentTitle);
			titleField = new JTextField();
			titleField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(titleField);
			titleField.setColumns(10);
			
			JLabel lblDueDate = new JLabel("Due Date");
			lblDueDate.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(lblDueDate);
			
			dueDateField = new JTextField();
			dueDateField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_6.add(dueDateField);
			dueDateField.setColumns(10);
			
			JPanel panel_5 = new JPanel();
			panel_3.add(panel_5);
			uploadButton = new JButton("Upload");
			uploadButton.setForeground(Color.WHITE);
			uploadButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			uploadButton.setBackground(new Color(135, 206, 235));
			panel_5.add(uploadButton);
			
			deleteButton = new JButton("Delete");
			deleteButton.setForeground(Color.WHITE);
			deleteButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			deleteButton.setBackground(new Color(135, 206, 235));
			panel_5.add(deleteButton);	
			changeStateButton = new JButton("Change Active State");
			changeStateButton.setForeground(Color.WHITE);
			changeStateButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			changeStateButton.setBackground(Color.DARK_GRAY);
			panel_5.add(changeStateButton);
		}
	}
	public void setupUploadButton (ActionListener e)
	{
		uploadButton.addActionListener(e);
	}
	public void setupDeleteButton (ActionListener e)
	{
		deleteButton.addActionListener(e);
	}
	public void setupChangeActionButton (ActionListener e)
	{
		changeStateButton.addActionListener(e);
	}
	public void setAssignmentList (ArrayList<Assignment> assignmentList)
	{
		model.clear();
		for (int i = 0; i < assignmentList.size(); i++) {
			model.addElement(assignmentList.get(i));
		}
	}
	public String getAssignmentTitle ()
	{
		return titleField.getText();
	}
	public String getAssignmentDueDate()
	{
		return dueDateField.getText();
	}
	public JList<Assignment> getList ()
	{
		return list;
	}
}

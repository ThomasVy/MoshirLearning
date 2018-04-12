package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import sharedElements.Course;
import sharedElements.Student;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class EnrollmentPage extends PagesInACourse {

	private static final long serialVersionUID = 1L; // The serial version UID
	private JTextField searchField;
	private JTextField studentIDField;
	private DefaultListModel<Student> model;
	private JList<Student> list;
	private JScrollPane scrollPane;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnSearch;
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnLastName;
	/**
	 * Create the frame.
	 */
	public EnrollmentPage(ArrayList<Course> courses, boolean isProfessor, Course courseOfThisPage) {
		super(courses, isProfessor, courseOfThisPage);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblEnrollmentPage = new JLabel("Enrollment Page");
		lblEnrollmentPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblEnrollmentPage);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Student ID  First Name  Last Name                                                                                                   ");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_13.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);


		model = new DefaultListModel<Student>();
		list = new JList<Student>(model);
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
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);

		JLabel lblSearchForStudents = new JLabel("Search for Student:");
		lblSearchForStudents.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		panel_12.add(lblSearchForStudents);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);

		JLabel lblNameOfStudent = new JLabel("Name of Student");
		lblNameOfStudent.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(lblNameOfStudent);

		searchField = new JTextField();
		searchField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(searchField);
		searchField.setColumns(10);

		rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		btnSearch = new JButton("Search");
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		panel_6.add(rdbtnId);
		panel_6.add(rdbtnLastName);

		btnSearch.setBackground(new Color(135, 206, 235));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(btnSearch);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnId);
		bg.add(rdbtnLastName);
		if(isProfessor ==true)
		{
			JPanel panel_5 = new JPanel();
			panel_3.add(panel_5);
			panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
	
			JPanel panel_8 = new JPanel();
			panel_5.add(panel_8);
			panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
	
			JPanel panel_10 = new JPanel();
			panel_8.add(panel_10);
	
			JLabel lblAddNewStudent = new JLabel("Add New Student:");
			lblAddNewStudent.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
			panel_10.add(lblAddNewStudent);
	
			JPanel panel_11 = new JPanel();
			panel_8.add(panel_11);
	
			JLabel lblNameOfStudent_1 = new JLabel("Student's ID");
			lblNameOfStudent_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_11.add(lblNameOfStudent_1);
	
			studentIDField = new JTextField();
			studentIDField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_11.add(studentIDField);
			studentIDField.setColumns(10);
			
			JPanel panel_9 = new JPanel();
			panel_5.add(panel_9);
		
			btnNewButton_8 = new JButton("Enroll");
			btnNewButton_8.setForeground(Color.WHITE);
			btnNewButton_8.setBackground(new Color(135, 206, 235));
			btnNewButton_8.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			panel_9.add(btnNewButton_8);
			
			btnNewButton_7 = new JButton("Unenroll");
			btnNewButton_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
			btnNewButton_7.setForeground(Color.WHITE);
			btnNewButton_7.setBackground(new Color(135, 206, 235));
			panel_9.add(btnNewButton_7);
		}
	}
	public void setupEnrollButton(ActionListener e)
	{
		btnNewButton_8.addActionListener(e);
	}
	public void setupUnenrollButton(ActionListener e)
	{
		btnNewButton_7.addActionListener(e);
	}
	public void setupSearch(ActionListener e)
	{
		btnSearch.addActionListener(e);
	}
	public void setEnrollList (ArrayList<Student> students)
	{
		model.clear();
		for (int i = 0; i < students.size(); i++) {
			model.addElement(students.get(i));
		}
	}
	public String getSearchField ()
	{
		return searchField.getText();
	}
	public char selectedRadioButton ()
	{
		if (rdbtnId.isSelected()) {
			return 'I';
		} 
		else if (rdbtnLastName.isSelected()) 
		{
			return 'L';
		}
		return '0';
	}
	public String getId()
	{
		return studentIDField.getText();
	}
	public JList<Student> getList()
	{
		return list;
	}
}

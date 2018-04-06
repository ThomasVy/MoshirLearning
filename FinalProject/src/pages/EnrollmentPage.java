package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import sharedElements.Student;
import sharedElements.StudentEnrollment;

public class EnrollmentPage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Course courseOfThisPage;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<Student> studentEnrollment;
	private DefaultListModel<String> model;
	private JList<String> list;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollmentPage frame = new EnrollmentPage(null, null, null);
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
	public EnrollmentPage(ProfessorGUI professorGUI, ArrayList<Course> courses, Course courseOfThisPage) {
		super(professorGUI, courses);
		this.courseOfThisPage = courseOfThisPage;

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

		lbl = new JLabel(courseOfThisPage.getName());
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

		JLabel lblEnrollmentPage = new JLabel("Enrollment Page");
		lblEnrollmentPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblEnrollmentPage);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		studentEnrollment = (ArrayList<Student>) professorGUI.sendToClient(courseOfThisPage, "GetEnrollmentList");
		model = new DefaultListModel<String>();
		for (int i = 0; i < studentEnrollment.size(); i++) {
			model.addElement(studentEnrollment.get(i).toString());
		}
		list = new JList<String>(model);
		scrollPane = new JScrollPane(list);
		list.setFixedCellWidth(500);
		list.setFixedCellHeight(25);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (list.getSelectedIndex() == -1) {
						return;
					} else {
						String student = model.elementAt(list.getSelectedIndex());
						String[] temp = student.split(" ");
						textField_1.setText(temp[0]);
					}

				}
			}
		});
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

		textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		JRadioButton rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				if (rdbtnId.isSelected()) {
					for (int i = 0; i < studentEnrollment.size(); i++) {
						if (String.valueOf(studentEnrollment.get(i).getId()).contains(textField.getText())) {
							model.addElement(studentEnrollment.get(i).toString());
						}
					}
				} else if (rdbtnLastName.isSelected()) {
					for (int i = 0; i < studentEnrollment.size(); i++) {
						if (studentEnrollment.get(i).getLastName().toLowerCase().contains(textField.getText().toLowerCase())) {
							model.addElement(studentEnrollment.get(i).toString());
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select either ID or Last Name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_11.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		
		JButton btnNewButton = new JButton("Enroll");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length() != 0) {
					Random random = new Random();
					int newId = 10000000 + random.nextInt(90000000); // Need to fix id generator
					StudentEnrollment enrollStudent = new StudentEnrollment(newId, Integer.parseInt(textField_1.getText()), courseOfThisPage.getId(), true);
					boolean enrolled = (boolean) professorGUI.sendToClient(enrollStudent);
					if (enrolled == true) {
						studentEnrollment = (ArrayList<Student>) professorGUI.sendToClient(courseOfThisPage, "GetEnrollmentList");
						model.clear();
						for (int i = 0; i < studentEnrollment.size(); i++) {
							model.addElement(studentEnrollment.get(i).toString());
						}
						JOptionPane.showMessageDialog(null, "Enrollment successful.", "Valid Input", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Student does not exist or ID already taken.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_9.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unenroll");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length() != 0) {
					StudentEnrollment unenrollStudent = new StudentEnrollment(-1, Integer.parseInt(textField_1.getText()), courseOfThisPage.getId(), false);
					boolean unEnrolled = (boolean) professorGUI.sendToClient(unenrollStudent);
					if (unEnrolled = true) {
						studentEnrollment = (ArrayList<Student>) professorGUI.sendToClient(courseOfThisPage, "GetEnrollmentList");
						model.clear();
						for (int i = 0; i < studentEnrollment.size(); i++) {
							model.addElement(studentEnrollment.get(i).toString());
						}
						JOptionPane.showMessageDialog(null, "Unenrollment successful.", "Valid Input", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Student does not exist.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		panel_9.add(btnNewButton_1);
	}

}

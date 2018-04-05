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
	private JTextField textField;
	private HomePage homePage;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCoursePage frame = new CreateCoursePage(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateCoursePage(ProfessorGUI professorGUI, ArrayList<Course> courses, HomePage homePage) {
		super(professorGUI, courses);
		this.homePage = homePage;
		
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
		
		textField_1 = new JTextField();
		createCoursePagePanel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton enter = new JButton("Enter");
		enter.setForeground(Color.WHITE);
		enter.setBackground(SystemColor.desktop);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length() != 0) {
					Random random = new Random();
					int newId = 10000000 + random.nextInt(90000000); // Need to fix id generator

					Course newCourse = new Course(newId, professorGUI.getProfessor().getId(), textField.getText(), false);

					boolean approved = (boolean) professorGUI.sendToClient(newCourse, "CreateNewCourse");
					if (approved == false) {
						JOptionPane.showMessageDialog(null, "Invalid input for new course.", "Failed to Create New Course", JOptionPane.ERROR_MESSAGE);
					} else {
						professorGUI.getCourses().add(newCourse);
						professorGUI.createAllPages();
						professorGUI.refreshPages();
						CreateCoursePage.this.setVisible(false);
						professorGUI.getCoursePages().get(professorGUI.getCourses().size() - 1).setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid name.", "Failed to Create New Course", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		enter.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		createCoursePagePanel_2.add(enter);
		
		JPanel createCoursePagePanel_3 = new JPanel();
		panel.add(createCoursePagePanel_3);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCoursePage.this.setVisible(false);
				textField_1.setText("");
				homePage.setVisible(true);
			}
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCoursePage.this.setVisible(false);
				textField_1.setText("");
				homePage.setVisible(true);
			}
		});
		cancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(SystemColor.desktop);
		panel_1.add(cancel);

//		JButton btnEnter = new JButton("Enter");
//		btnEnter.setForeground(Color.WHITE);
//		btnEnter.setBackground(SystemColor.desktop);
//		btnEnter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (textField.getText().length() != 0) {
//					Random random = new Random();
//					int newId = 10000000 + random.nextInt(90000000); // Need to fix id generator
//					Course newCourse = new Course(newId, professorGUI.getProfessor().getId(), textField.getText(), false);
//					boolean approved = (boolean) professorGUI.sendToClient(newCourse, "CreateNewCourse");
//					if (approved == false) {
//						JOptionPane.showMessageDialog(null, "Invalid input for new course.", "Failed to Create New Course", JOptionPane.ERROR_MESSAGE);
//					} else {
//						professorGUI.getCourses().add(newCourse);
//						professorGUI.createAllPages();
//						professorGUI.refreshPages();
//						CreateCoursePage.this.setVisible(false);
//						professorGUI.getCoursePages().get(professorGUI.getCourses().size() - 1).setVisible(true);
//					}
//				} else {
//					JOptionPane.showMessageDialog(null, "Invalid name.", "Failed to Create New Course", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
//		btnEnter.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
//		panel.add(btnEnter);
	}

	public String getCourseName() {
		return textField.getText();
	}

}

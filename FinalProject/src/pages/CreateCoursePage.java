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

public class CreateCoursePage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private JTextField textField;
	private HomePage homePage;

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

		JLabel lblCoursePage = new JLabel("Create New Course Page");
		lblCoursePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblCoursePage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblCoursePage);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));

		btnNewButton_6 = new JButton("Cancel");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCoursePage.this.setVisible(false);
				textField.setText("");
				homePage.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_6);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(180);
		panel_8.add(panel);
		
		JLabel lblNewLabel = new JLabel("Name of New Course");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setBackground(SystemColor.desktop);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() != 0) {
					Random random = new Random();
					int newId = 10000000 + random.nextInt(90000000); // Need to fix id generator
					Course newCourse = new Course(newId, professorGUI.getProfessor().getId(), textField.getText(), false);
					boolean approved = (boolean) professorGUI.getClient().communicateWithServer(newCourse);
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
		btnEnter.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel.add(btnEnter);
	}

	public String getCourseName() {
		return textField.getText();
	}

}

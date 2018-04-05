package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import javax.swing.BoxLayout;

public class HomePage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage(null, null);
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
	public HomePage(ProfessorGUI professorGUI, ArrayList<Course> courses) {
		super(professorGUI, courses);
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane, BorderLayout.CENTER);
//		JPanel panel_9 = new JPanel();
//		scrollPane.setViewportView(panel_9);

		btnNewButton_6 = new JButton("Create New Course");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateCoursePage createCoursePage = new CreateCoursePage(professorGUI, courses, HomePage.this);
				HomePage.this.setVisible(false);
				createCoursePage.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_6);
		
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
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
	}

}

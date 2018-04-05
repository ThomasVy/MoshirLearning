package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.PageNavigator;
import sharedElements.Course;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CoursePage extends Page{
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CoursePage frame = new CoursePage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CoursePage(PageNavigator pageNavigator,  ArrayList<Course> courses, String selectedCourse){
		super(pageNavigator, courses);
		
		JButton btnContent = new JButton("Assignments");
		btnContent.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnContent.setForeground(Color.WHITE);
		btnContent.setBackground(SystemColor.desktop);
		panel_1.add(btnContent);
		
		JButton btnNewButton = new JButton("Grades");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submissions");
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_1);
		
		JLabel lblEncm = new JLabel(selectedCourse);
		lblEncm.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lblEncm);
		
		JButton btnNewButton_2 = new JButton("Enrollment");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblCoursePage = new JLabel("Course Page");
		lblCoursePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblCoursePage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblCoursePage);
	}

}

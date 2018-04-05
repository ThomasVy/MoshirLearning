package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

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
	public HomePage(PageNavigator pageNavigator, ArrayList<Course> courses) {
		super(pageNavigator, courses);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JPanel panel_9 = new JPanel();
		scrollPane.setViewportView(panel_9);

		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblHomePage);

		JLabel lblWelcomeProfessor = new JLabel("Welcome, professor!");
		panel_9.add(lblWelcomeProfessor);
	}

}

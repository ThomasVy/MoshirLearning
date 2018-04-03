package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shared.Course;
import shared.Student;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EnrollmentPage extends JFrame {

	private JPanel contentPane;
	private ArrayList<Student> enrolledStudentList;
	private Course course;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollmentPage frame = new EnrollmentPage();
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
	public EnrollmentPage() {

		// Test
		enrolledStudentList = new ArrayList<Student>();
		enrolledStudentList.add(new Student(1, "Rainer", "Lim"));
		enrolledStudentList.add(new Student(2, "Thomas", "Vy"));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("ID Student");
		for (int i = 0; i < 30; i++) {
		listModel.addElement(enrolledStudentList.get(0).toString());
		listModel.addElement(enrolledStudentList.get(1).toString());
		}
		// Test

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMoshirlearning = new JLabel("MoshirLearning");
		lblMoshirlearning.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		panel.add(lblMoshirlearning);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblEnrollmentPage = new JLabel("Enrollment Page");
		lblEnrollmentPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnrollmentPage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblEnrollmentPage);
		
		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
//		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ENROLL");
			}
		});
		panel_1.add(btnEnroll);
		
		JButton btnUnenroll = new JButton("Unenroll");
		btnUnenroll.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnUnenroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("UNENROLL");
			}
		});
		panel_1.add(btnUnenroll);
	}

}

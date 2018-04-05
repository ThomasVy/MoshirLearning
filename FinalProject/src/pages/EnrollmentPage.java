package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import sharedElements.StudentEnrollment;

public class EnrollmentPage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Course courseOfThisPage;

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
		btnNewButton_2.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Grades");
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("Submissions");
		btnNewButton_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_4);

		lbl = new JLabel(courseOfThisPage.getName());
		lbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lbl);

		btnNewButton_5 = new JButton("Enrollment");
		btnNewButton_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(SystemColor.desktop);
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
		
		ArrayList<Student> studentEnrollment = (ArrayList<StudentEnrollment>) professorGUI.sendToClient(courseOfThisPage, "GetEnrollmentList");
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < studentEnrollment.size(); i++) {
			model.addElement
		}
		JList<String> list = new JList<String>(model);
		JScrollPane scrollPane = new JScrollPane(list);
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
						System.out.println(student);
					}
					
				}
			}
		});
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

}

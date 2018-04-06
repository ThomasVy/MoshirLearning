package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import frontEnd.ProfessorGUI;
import sharedElements.Course;
import sharedElements.Student;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Component;

public class AssignmentPage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Course courseOfThisPage;
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
					AssignmentPage frame = new AssignmentPage(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AssignmentPage(ProfessorGUI professorGUI, ArrayList<Course> courses, Course courseOfThisPage) {
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
		
		JLabel lblAssignmentsPage = new JLabel("Assignments Page");
		lblAssignmentsPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblAssignmentsPage);
		
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
//		list.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if (!e.getValueIsAdjusting()) {
//					if (list.getSelectedIndex() == -1) {
//						return;
//					} else {
//						String student = model.elementAt(list.getSelectedIndex());
//						
//					}
//
//				}
//			}
//		});
		panel_2.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Assignment Options:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(135, 206, 235));
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Inactive");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		panel_5.add(btnNewButton_2);
	}

}

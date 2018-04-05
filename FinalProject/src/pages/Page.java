package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import frontEnd.ProfessorGUI;
import sharedElements.Course;

public abstract class Page extends JFrame {

	private static final long serialVersionUID = 1L; // The serial version UID
	protected ProfessorGUI professorGUI;
	protected ArrayList<Course> courses;
	protected JPanel contentPane;
	protected JPanel panel;
	protected JPanel panel_1;
	protected JPanel panel_2;
	protected JPanel panel_3;
	protected JPanel panel_4;
	protected JPanel panel_5;
	protected JScrollPane scrollPane;
	protected boolean isProfessor;
	protected String [] dropCourses;
	protected JPanel panel_6;
	protected JPanel panel_7;
	protected JButton btnNewButton;
	protected JComboBox<String> comboBox;
	protected JButton btnNewButton_1;
	
	protected JButton btnNewButton_2;
	protected JButton btnNewButton_3;
	protected JButton btnNewButton_4;
	protected JButton btnNewButton_5;
	protected JButton btnNewButton_6;
	protected JLabel lbl;
	
	protected JPanel panel_8;
	protected JPanel panel_10;

	public Page (ProfessorGUI professorGUI,  ArrayList<Course> courses) {
		this.professorGUI = professorGUI;
		this.courses = courses;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_6.setBackground(Color.DARK_GRAY);
		panel_3.add(panel_6);

		btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.DARK_GRAY);
		panel_6.add(btnNewButton);

		comboBox = new JComboBox<String>();
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		comboBox.setBackground(Color.DARK_GRAY);
		panel_6.add(comboBox);

		panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_7);

		btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		panel_7.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JPanel panel_9 = new JPanel();
		scrollPane.setViewportView(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		panel_8 = new JPanel();
		panel_9.add(panel_8);
		
		panel_10 = new JPanel();
		panel_9.add(panel_10);

		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4);

		panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5);

		JLabel lblMoshirlearning = new JLabel("MoshirLearning");
		lblMoshirlearning.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_5.add(lblMoshirlearning);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel.add(panel_1);

		setLocationRelativeTo(null);

		setUpComboBox();
	}

	public void setUpHomeButtonListener(HomePage homePage, ArrayList<Page> coursePages, ArrayList<Page> assignmentPages, ArrayList<Page> gradePages, ArrayList<Page> submissionPages, ArrayList<Page> enrollmentPages) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
				homePage.comboBox.setEnabled(false);
				homePage.comboBox.setEnabled(true);
				homePage.comboBox.setSelectedIndex(0);
				homePage.setVisible(true);
			}
		});
	}

	public void setUpComboBox() {
		try {
			Iterator<Course> it = courses.iterator();
			dropCourses = new String [courses.size() + 1];
			dropCourses[0] = "Select a course...";
			int i = 1;
			while(it.hasNext()) {
				dropCourses[i++] = it.next().getName();
			}
			comboBox.setModel(new DefaultComboBoxModel<String>(dropCourses));
		} catch (NullPointerException e) {
			System.out.println("Testing individual pages.");
		}
	}

	public void setUpComboBoxListeners(HomePage homePage, ArrayList<Page> coursePages, ArrayList<Page> assignmentPages, ArrayList<Page> gradePages, ArrayList<Page> submissionPages, ArrayList<Page> enrollmentPages) {
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					for (int i = 0; i < courses.size(); i++) {
						if (comboBox.getSelectedIndex() == i + 1) {
							closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
							coursePages.get(i).comboBox.setEnabled(false);
							coursePages.get(i).comboBox.setEnabled(true);
							coursePages.get(i).comboBox.setSelectedIndex(i + 1);
							coursePages.get(i).setVisible(true);
						}
					}
				}
			}
		});
	}

	public void setUpPageListeners(HomePage homePage, ArrayList<Page> coursePages, ArrayList<Page> assignmentPages, ArrayList<Page> gradePages, ArrayList<Page> submissionPages, ArrayList<Page> enrollmentPages) {
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i < coursePages.size()) {
					if (Page.this.lbl.getText().equalsIgnoreCase(coursePages.get(i).lbl.getText())) {
						break;
					}
					i++;
				}
				closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
				assignmentPages.get(i).setVisible(true);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i < coursePages.size()) {
					if (Page.this.lbl.getText().equalsIgnoreCase(coursePages.get(i).lbl.getText())) {
						break;
					}
					i++;
				}
				closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
				gradePages.get(i).setVisible(true);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i < coursePages.size()) {
					if (Page.this.lbl.getText().equalsIgnoreCase(coursePages.get(i).lbl.getText())) {
						break;
					}
					i++;
				}
				closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
				submissionPages.get(i).setVisible(true);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i < coursePages.size()) {
					if (Page.this.lbl.getText().equalsIgnoreCase(coursePages.get(i).lbl.getText())) {
						break;
					}
					i++;
				}
				closeAllWindows(homePage, coursePages, assignmentPages, gradePages, submissionPages, enrollmentPages);
				enrollmentPages.get(i).setVisible(true);
			}
		});
	}

	public void closeAllWindows(HomePage homePage, ArrayList<Page> coursePages, ArrayList<Page> assignmentPages, ArrayList<Page> gradePages, ArrayList<Page> submissionPages, ArrayList<Page> enrollmentPages) {
		homePage.setVisible(false);
		for (int i = 0; i < courses.size(); i++) {
			coursePages.get(i).setVisible(false);
			assignmentPages.get(i).setVisible(false);
			gradePages.get(i).setVisible(false);
			submissionPages.get(i).setVisible(false);
			enrollmentPages.get(i).setVisible(false);
		}
	}

}

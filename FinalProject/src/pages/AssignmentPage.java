package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import frontEnd.ProfessorGUI;
import sharedElements.Assignment;
import sharedElements.Course;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class AssignmentPage extends Page {

	private static final long serialVersionUID = 1L; // The serial version UID
	private Course courseOfThisPage;
	private ArrayList<Assignment> assignmentList;
	private DefaultListModel<Assignment> model;
	private JList<Assignment> list;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;

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

		model = new DefaultListModel<Assignment>();
		refreshList();

		list = new JList<Assignment>(model);
		scrollPane = new JScrollPane(list);
		list.setFixedCellWidth(500);
		list.setFixedCellHeight(25);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		panel_2.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblNewLabel = new JLabel("Assignment Options:");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		panel_4.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);

		JLabel lblAssignmentTitle = new JLabel("Title");
		lblAssignmentTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_6.add(lblAssignmentTitle);

		textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_6.add(textField);
		textField.setColumns(10);

		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_6.add(lblDueDate);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_6.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);

		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser();
				refreshList();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(135, 206, 235));
		panel_5.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		panel_5.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assignment currentSelected = list.getSelectedValue();
				if (currentSelected != null) {
					professorGUI.sendToClient(currentSelected, "DeleteAssignment");
					refreshList();
				} else
					JOptionPane.showMessageDialog(null, "Please click on an assignment to delete.", "Failed to Delete",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		JButton btnNewButton_2 = new JButton("Change Active State");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		panel_5.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assignment currentSelected = list.getSelectedValue();
				if (currentSelected != null) {
					currentSelected.setActiveToOpposite();
					professorGUI.sendToClient(currentSelected, "ChangeActiveState");
					refreshList();
				} else
					JOptionPane.showMessageDialog(null, "Please click on an assignment to change state.",
							"Failed to change state", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	public void openFileBrowser() {
		JFileChooser fileBrowser = new JFileChooser();
		if (fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileBrowser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			Random random = new Random();
			int newId = 10000000 + random.nextInt(90000000);
			if (textField.getText().length() == 0 || textField_1.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Please fill in all data fields.", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Assignment assignment = new Assignment(newId, courseOfThisPage.getId(), textField.getText(), path,
						false, textField_1.getText());
				byte[] fileInBytes = turnFileIntoBytes(selectedFile);
				professorGUI.sendToClient(assignment, "AddAssignment", fileInBytes);
			}
		}
	}

	private byte[] turnFileIntoBytes(File selectedFile) {
		long length = selectedFile.length();
		byte[] content = new byte[(int) length]; // Converting Long to Int
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bos = new BufferedInputStream(fis);
			bos.read(content, 0, (int) length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	private void refreshList() {
		model.clear();
		assignmentList = (ArrayList<Assignment>) professorGUI.sendToClient(courseOfThisPage, "GetAssignmentList");
		for (int i = 0; i < assignmentList.size(); i++) {
			model.addElement(assignmentList.get(i));
		}
	}
}

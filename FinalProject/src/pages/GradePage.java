package pages;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sharedElements.Course;
import sharedElements.Grade;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class GradePage extends PagesInACourse {

	private static final long serialVersionUID = 1L; // The serial version UID
	private DefaultListModel<Grade> model;
	private JList<Grade> list;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public GradePage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses, isProfessor, selectedCourse);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("Grades Page");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		model = new DefaultListModel<Grade>();
		list = new JList<Grade>(model);
		scrollPane = new JScrollPane(list);
		list.setFixedCellWidth(500);
		list.setFixedCellHeight(25);
		list.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		panel_1.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
	}

	public void setGradeList(ArrayList<Grade> gradeList) {
		model.clear();
		for (int i = 0; i < gradeList.size(); i++) {
			model.addElement(gradeList.get(i));
		}
	}

	public DefaultListModel<Grade> getModel() {
		return model;
	}

	public JList<Grade> getList() {
		return list;
	}

}

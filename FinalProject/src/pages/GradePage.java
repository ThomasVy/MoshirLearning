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
 * Provides the fields and methods required to create a GradePage object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class GradePage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -7461390897918978773L;
	/**
	 * The model of the GradePage.
	 */
	private DefaultListModel<Grade> model;
	/**
	 * The list of the GradePage.
	 */
	private JList<Grade> gradesList;
	/**
	 * The scroll pane of the GradePage.
	 */
	private JScrollPane gradesListScrollPane;

	/**
	 * Constructs a GradePage object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param selectedCourse - the current course
	 */
	public GradePage(ArrayList<Course> courses, boolean isProfessor, Course selectedCourse) {
		super(courses, isProfessor, selectedCourse);

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel gradesPageTitlePanel = new JPanel();
		contentPanel.add(gradesPageTitlePanel);

		JLabel gradesPageTitle = new JLabel("Grades Page");
		gradesPageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		gradesPageTitlePanel.add(gradesPageTitle);

		JPanel listLabelsPanel = new JPanel();
		contentPanel.add(listLabelsPanel);
		listLabelsPanel.setLayout(new BoxLayout(listLabelsPanel, BoxLayout.X_AXIS));

		JLabel listLabels = new JLabel(
				"Title           Student ID   Grade                                                                                             ");
		listLabels.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		listLabelsPanel.add(listLabels);

		JPanel gradesListPanel = new JPanel();
		contentPanel.add(gradesListPanel);
		model = new DefaultListModel<Grade>();
		gradesList = new JList<Grade>(model);
		gradesListScrollPane = new JScrollPane(gradesList);
		gradesList.setFixedCellWidth(500);
		gradesList.setFixedCellHeight(25);
		gradesList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		gradesListPanel.add(gradesListScrollPane);
		JPanel gradesPageBottomPanel = new JPanel();
		contentPanel.add(gradesPageBottomPanel);
	}

	// Getters:

	/**
	 * Gets the model of the GradePage.
	 * @return model - the model of the GradePage
	 */
	public DefaultListModel<Grade> getModel() {
		return model;
	}

	/**
	 * Gets the list of the GradePage.
	 * @return gradesList - the list of the GradePage
	 */
	public JList<Grade> getList() {
		return gradesList;
	}

	// Setters:

	/**
	 * Sets the list of the GradePage.
	 * @param gradesList - the list to which it will set
	 */
	public void setGradesList(ArrayList<Grade> gradesList) {
		model.clear();
		for (int i = 0; i < gradesList.size(); i++) {
			model.addElement(gradesList.get(i));
		}
	}

}

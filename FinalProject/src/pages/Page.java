package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import sharedElements.Course;

/**
 * Provides the fields and methods required to create a Page object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public abstract class Page extends JPanel{

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1336062890486477283L;
	/**
	 * True if user is a professor, false otherwise.
	 */
	protected boolean isProfessor;
	/**
	 * The header panel of the Page.
	 */
	protected JPanel headerPanel;
	/**
	 * The bottom panel of the Page.
	 */
	protected JPanel bottomPanel;
	/**
	 * The middle panel of the Page.
	 */
	protected JPanel middlePanel;
	/**
	 * The top panel of the Page.
	 */
	protected JPanel topPanel;
	/**
	 * The course title panel of the Page.
	 */
	protected JPanel courseTitlePanel;
	/**
	 * The program title panel of the Page.
	 */
	protected JPanel moshirLearningPanel;
	/**
	 * The scroll pane of the Page.
	 */
	protected JScrollPane scrollPane;
	/**
	 * The array which contains all of the courses of a user.
	 */
	protected Course[] dropCourses;
	/**
	 * The user options panel of the Page.
	 */
	protected JPanel userOptionsPanel;
	/**
	 * The logout panel of the Page.
	 */
	protected JPanel logoutPanel;
	/**
	 * The course list of the Page.
	 */
	protected JComboBox<Course> courseList;
	/**
	 * The home button of the Page.
	 */
	protected JButton home;
	/**
	 * The logout button of the Page.
	 */
	protected JButton logout;
	/**
	 * The assignments button of the Page.
	 */
	protected JButton assignmentsButton;
	/**
	 * The grades button of the Page.
	 */
	protected JButton gradesButton;
	/**
	 * The submissions button of the Page.
	 */
	protected JButton submissionsButton;
	/**
	 * The enrollment button of the Page.
	 */
	protected JButton enrollmentButton;
	/**
	 * The create new course button of the Page.
	 */
	protected JButton createNewCourseButton;
	/**
	 * The course title of the Page.
	 */
	protected JLabel courseTitle;
	/**
	 * The add student panel of the Page.
	 */
	protected JPanel addStudentPanel;
	/**
	 * The add student title panel of the Page.
	 */
	protected JPanel addStudentTitlePanel;

	/**
	 * Constructs a Page object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 */
	public Page(boolean isProfessor) {
		this.isProfessor = isProfessor;
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		headerPanel = new JPanel();
		add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

		topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		headerPanel.add(topPanel);
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

		userOptionsPanel = new JPanel();
		FlowLayout fl_userOptionsPanel = (FlowLayout) userOptionsPanel.getLayout();
		fl_userOptionsPanel.setAlignment(FlowLayout.LEFT);
		userOptionsPanel.setBackground(Color.DARK_GRAY);
		topPanel.add(userOptionsPanel);

		home = new JButton("Home");
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		home.setBackground(Color.DARK_GRAY);
		userOptionsPanel.add(home);

		courseList = new JComboBox<Course>();
		courseList.setForeground(Color.WHITE);
		courseList.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		courseList.setBackground(Color.DARK_GRAY);
		userOptionsPanel.add(courseList);

		logoutPanel = new JPanel();
		logoutPanel.setBackground(Color.DARK_GRAY);
		FlowLayout fl_logoutPanel = (FlowLayout) logoutPanel.getLayout();
		fl_logoutPanel.setAlignment(FlowLayout.RIGHT);
		topPanel.add(logoutPanel);

		logout = new JButton("Logout");
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		logout.setBackground(Color.DARK_GRAY);
		logoutPanel.add(logout);

		middlePanel = new JPanel();
		headerPanel.add(middlePanel);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));

		courseTitlePanel = new JPanel();
		FlowLayout fl_courseTitlePanel = (FlowLayout) courseTitlePanel.getLayout();
		fl_courseTitlePanel.setAlignment(FlowLayout.LEFT);
		middlePanel.add(courseTitlePanel);

		moshirLearningPanel = new JPanel();
		FlowLayout fl_moshirLearningPanel = (FlowLayout) moshirLearningPanel.getLayout();
		fl_moshirLearningPanel.setAlignment(FlowLayout.RIGHT);
		middlePanel.add(moshirLearningPanel);

		JLabel moshirLearning = new JLabel("MoshirLearning");
		moshirLearning.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		moshirLearningPanel.add(moshirLearning);

		bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(135, 206, 235));
		headerPanel.add(bottomPanel);

		//setLocationRelativeTo(null);
		setLocation(0,500);
	}

	// Getters:

	/**
	 * Gets the course list of the Page.
	 * @return courseList - the course list of the Page
	 */
	public JComboBox<Course> getComboBox() {
		return courseList;
	}

	// Setters:

	/**
	 * Sets up the combo box of the Page.
	 */
	public void setUpComboBox(ArrayList<Course> courses) {
		try {
			Iterator<Course> it = courses.iterator();
			dropCourses = new Course[courses.size() + 1];
			dropCourses[0] = new Course(-1, "Select a course...", false);
			int i = 1;
			while (it.hasNext()) {
				dropCourses[i++] = it.next();
			}
			courseList.setModel(new DefaultComboBoxModel<Course>(dropCourses));
		} catch (NullPointerException e) {
			System.out.println("Testing individual pages.");
		}
	}

	// Listeners:

	/**
	 * Sets up combo box listener.
	 * @param e - the item listener to be added
	 */
	public void setUpComboBoxListeners(ItemListener e) {
		courseList.addItemListener(e);
	}

	/**
	 * Sets up the home button.
	 * @param e - the action listener to be added
	 */
	public void setUpHomeButtonListener(ActionListener e) {
		home.addActionListener(e);
	}

	/**
	 * Sets up the logout button.
	 * @param e - the action listener to be added
	 */
	public void logoutButton(ActionListener e) {
		logout.addActionListener(e);
	}

	// Messages:

	/**
	 * Shows success message to user.
	 * @param succ - success message
	 */
	public void showSuccess(String succ) {
		JOptionPane.showMessageDialog(null, succ, "Successful", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Shows error message to user.
	 * @param error - error message
	 */
	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error, "Failed", JOptionPane.ERROR_MESSAGE);
	}

}

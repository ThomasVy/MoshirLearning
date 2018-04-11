package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public abstract class Page extends JFrame {

	private static final long serialVersionUID = 1L; // The serial version UID
	protected ArrayList<Course> courses;
	protected boolean isProfessor;
	
	protected JPanel contentPane;
	protected JPanel panel;
	protected JPanel panel_1;
	protected JPanel panel_2;
	protected JPanel panel_3;
	protected JPanel panel_4;
	protected JPanel panel_5;
	protected JScrollPane scrollPane;
	protected Course[] dropCourses;
	protected JPanel panel_6;
	protected JPanel panel_7;
	protected JButton btnNewButton;
	protected JComboBox<Course> comboBox;
	protected JButton btnNewButton_1;

	protected JButton btnNewButton_2;
	protected JButton btnNewButton_3;
	protected JButton btnNewButton_4;
	protected JButton btnNewButton_5;
	protected JButton btnNewButton_6;
	protected JLabel lbl;

	protected JPanel panel_8;
	protected JPanel panel_10;

	public Page (ArrayList<Course> courses, boolean isProfessor) {
		this.courses = courses;
		this.isProfessor = isProfessor;
		
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

		comboBox = new JComboBox<Course>();
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
		panel_1.setBackground(new Color(135, 206, 235));
		panel.add(panel_1);

		setLocationRelativeTo(null);

		setUpComboBox();
	}
	public JComboBox<Course> getComboBox()
	{
		return comboBox;
	}
	public void setUpHomeButtonListener(ActionListener e) {
		btnNewButton.addActionListener(e);
	}
	public void setUpComboBox() {
		try {
			Iterator<Course> it = courses.iterator();
			dropCourses = new Course [courses.size() + 1];
			dropCourses[0] = new Course(-1, "Select a course...", false);
			int i = 1;
			while(it.hasNext()) {
				dropCourses[i++] = it.next();
			}
			comboBox.setModel(new DefaultComboBoxModel<Course>(dropCourses));
		} catch (NullPointerException e) {
			System.out.println("Testing individual pages.");
		}
	}
	public void showSuccess (String succ)
	{
		JOptionPane.showMessageDialog(null, succ , "Successful", JOptionPane.INFORMATION_MESSAGE);
	}
	public void showError (String error)
	{
		JOptionPane.showMessageDialog(null, error , "Failed", JOptionPane.ERROR_MESSAGE);
	}
	public void setUpComboBoxListeners(ItemListener e) {
		comboBox.addItemListener(e);
	}

}

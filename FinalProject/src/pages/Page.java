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

import components.PageNavigator;
import sharedElements.Course;

public abstract class Page extends JFrame{
	protected PageNavigator pageNavigator;
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
	
	public Page (PageNavigator pageNavigator,  ArrayList<Course> courses)
	{
		this.pageNavigator = pageNavigator;
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
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnHome) {
					pageNavigator.showPage("Home Page");
				}
			}
		});
		
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_3.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(dropCoursesToArray()));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String result = (String) comboBox.getSelectedItem();
//					if (result.equalsIgnoreCase("ENCM 369")) {
//						comboBox.setSelectedItem(0);
//						pageNavigator.showPage("ENCM 369");
//					}
					comboBox.setSelectedItem(0);
					pageNavigator.showPage(result);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					
				}
			}
		});
		panel_3.add(comboBox);
		
		
//		JPanel panel_8 = new JPanel();
//		panel_8.setBackground(Color.DARK_GRAY);
//		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
//		flowLayout_1.setAlignment(FlowLayout.RIGHT);
//		panel.add(panel_8);
//		JButton btnNewButton = new JButton("Logout");
//		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
//		btnNewButton.setForeground(Color.WHITE);
//		btnNewButton.setBackground(Color.DARK_GRAY);
//		panel_8.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JPanel panel_9 = new JPanel();
		scrollPane.setViewportView(panel_9);
		
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
	}
	public String [] dropCoursesToArray ()
	{
		Iterator<Course> it = courses.iterator();
		dropCourses = new String [courses.size()+1];
		dropCourses[0] = "Select a course...";
		int i =1;
		while(it.hasNext())
		{
			dropCourses[i++] = it.next().getName();
		}
		return dropCourses;
		
	}
}


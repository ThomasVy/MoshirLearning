package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.PageNavigator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursePage extends JFrame {

	private JPanel contentPane;
	private PageNavigator pageNavigator;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CoursePage frame = new CoursePage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CoursePage(PageNavigator pageNavigator) {
		this.pageNavigator = pageNavigator;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a course...", "ENCM 369", "CPSC 319", "ENEL 327", "ENSF 409"}));
		panel_3.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4);
		
		JLabel lblEncm = new JLabel("ENCM 369 - Computer Organization");
		lblEncm.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lblEncm);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5);
		
		JLabel lblMoshirlearning = new JLabel("MoshirLearning");
		lblMoshirlearning.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_5.add(lblMoshirlearning);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel.add(panel_1);
		
		JButton btnContent = new JButton("Assignments");
		btnContent.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnContent.setForeground(Color.WHITE);
		btnContent.setBackground(SystemColor.desktop);
		panel_1.add(btnContent);
		
		JButton btnNewButton = new JButton("Grades");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submissions");
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Enrollment");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblCoursePage = new JLabel("Course Page");
		lblCoursePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblCoursePage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblCoursePage);
		setLocationRelativeTo(null);
	}

}

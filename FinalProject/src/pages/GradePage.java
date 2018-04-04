package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.PageNavigator;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class GradePage extends JFrame {

	private JPanel contentPane;
	private PageNavigator pageNavigator;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GradePage frame = new GradePage();
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
	public GradePage(PageNavigator pageNavigator) {
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
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		panel_3.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a course...", "ENCM 369", "CPSC 319", "ENEL 327", "ENSF 409"}));
		panel_3.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_5);
		
		JLabel lblEncm = new JLabel("ENCM 369 - Computer Organization");
		lblEncm.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_5.add(lblEncm);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4);
		
		JLabel lblMoshirlearning = new JLabel("MoshirLearning");
		lblMoshirlearning.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_4.add(lblMoshirlearning);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Assignments");
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Grades");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Submissions");
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.desktop);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Enrollment");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.desktop);
		btnNewButton_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_1.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Grade Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
	}

}

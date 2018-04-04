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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private PageNavigator pageNavigator;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage frame = new HomePage();
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
	public HomePage(PageNavigator pageNavigator) {
		this.pageNavigator = pageNavigator;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_7);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String result = (String) comboBox.getSelectedItem();
					if (result.equalsIgnoreCase("ENCM 369")) {
						pageNavigator.showPage("ENCM 369");
					}
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					
				}
			}
		});
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a course...", "ENCM 369"}));
		panel_7.add(comboBox);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_6.add(panel_8);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		panel_8.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("MoshirLearning");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		panel_5.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblHomePage);
		
		JPanel panel_9 = new JPanel();
		scrollPane.setViewportView(panel_9);
		
		JLabel lblWelcomeProfessor = new JLabel("Welcome, professor!");
		panel_9.add(lblWelcomeProfessor);
		setLocationRelativeTo(null);
	}

}

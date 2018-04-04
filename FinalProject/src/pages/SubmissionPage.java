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

public class SubmissionPage extends JFrame {

	private JPanel contentPane;
	private PageNavigator pageNavigator;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SubmissionPage frame = new SubmissionPage();
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
	public SubmissionPage(PageNavigator pageNavigator) {
		this.pageNavigator = pageNavigator;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMoshirlearning = new JLabel("MoshirLearning");
		panel.add(lblMoshirlearning);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblSubmissionPage = new JLabel("Submission Page");
		lblSubmissionPage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblSubmissionPage);
	}

}

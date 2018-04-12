package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L; // The serial version UID
	private JButton submitButton;
	private JButton clearButton;
	private JButton exitButton;

	private JTextField usernameText;
	private JPasswordField passwordText;

	public LoginWindow(String s) {
		super(s);
		this.setSize(600, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(createSouthPanel(), BorderLayout.SOUTH);
		Image img = new ImageIcon(this.getClass().getResource("/LittleMaster.png")).getImage();
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblWelcomeToMoshirlearning = new JLabel("Welcome to MoshirLearning!");
		lblWelcomeToMoshirlearning.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_1.add(lblWelcomeToMoshirlearning);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JPanel createSouthPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		southPanel.add(usernameLayout());
		southPanel.add(passwordLayout());
		southPanel.add(createButtonPanel());
		return southPanel;
	}

	public JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel(new FlowLayout());
		submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(135, 206, 235));
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		clearButton = new JButton("Clear");
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		clearButton.setBackground(new Color(135, 206, 235));
		exitButton = new JButton("Exit");
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		exitButton.setBackground(new Color(135, 206, 235));
		buttonPanel.add(submitButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(exitButton);
		buttonPanel.setBorder(new EmptyBorder(0, 10, 20, 0));
		return buttonPanel;
	}

	public JPanel usernameLayout() {
		JPanel usernamePanel = new JPanel(new FlowLayout());
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		usernameText = new JTextField(10);
		usernameText.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameText);
		return usernamePanel;
	}

	public JPanel passwordLayout() {
		JPanel passwordPanel = new JPanel(new FlowLayout());
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		passwordText = new JPasswordField(10);
		passwordText.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordText);
		return passwordPanel;
	}

	public void clearTextFields() {
		usernameText.setText("");
		passwordText.setText("");
	}

	public void addSubmitListener(ActionListener submitListener) {
		submitButton.addActionListener(submitListener);
	}

	public void addClearListener(ActionListener clearListener) {
		clearButton.addActionListener(clearListener);
	}

	public void addExitListener(ActionListener exitListener) {
		exitButton.addActionListener(exitListener);
	}

	public String getUsername() {
		return usernameText.getText();
	}

	public String getPassword() {
		return new String(passwordText.getPassword());
	}

	// public static void main(String [] args) {
	// LoginWindow l = new LoginWindow("Login Window");
	// LoginWindowController c = new LoginWindowController(l);
	// }

}

package frontEnd;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton submitButton;
	private JButton clearButton;
	private JButton exitButton;
	
	private JTextField usernameText;
	private JTextField passwordText;
	
	public LoginWindow(String s)
	{
		super(s);
		JLabel loginLabel = new JLabel("Welcome to MoshirLearning", JLabel.CENTER);
		this.setSize(600, 300);
		setLayout(new BorderLayout());
		loginLabel.setFont(loginLabel.getFont().deriveFont(18.0f));
		this.add(loginLabel, BorderLayout.CENTER);
		this.add(createSouthPanel(), BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public JPanel createSouthPanel()
	{
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		southPanel.add(usernameLayout());
		southPanel.add(passwordLayout());
		southPanel.add(createButtonPanel());
		return southPanel;
	}
	public JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel(new FlowLayout());
		submitButton = new JButton("Submit");
		clearButton = new JButton("Clear");
		exitButton = new JButton("Exit");
		buttonPanel.add(submitButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(exitButton);
		buttonPanel.setBorder(new EmptyBorder(0,10,20,0));
		return buttonPanel;
	}
	public JPanel usernameLayout()
	{
		JPanel usernamePanel = new JPanel(new FlowLayout());
		JLabel usernameLabel = new JLabel("Username");
		usernameText = new JTextField(10);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameText);
		return usernamePanel;
	}
	public JPanel passwordLayout()
	{
		JPanel passwordPanel = new JPanel(new FlowLayout());
		JLabel passwordLabel = new JLabel("Password");
		passwordText = new JTextField(10);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordText);
		return passwordPanel;
	}
	public void clearTextFields ()
	{
		usernameText.setText("");
		passwordText.setText("");
	}
	public void addSubmitListener(ActionListener submitListener)
	{
		submitButton.addActionListener(submitListener);
	}
	public void addClearListener(ActionListener clearListener)
	{
		clearButton.addActionListener(clearListener);
	}
	public void addExitListener(ActionListener exitListener)
	{
		exitButton.addActionListener(exitListener);
	}
	public String getUsername ()
	{
		return usernameText.getText();
	}
	public String getPassword ()
	{
		return passwordText.getText();
	}
//	public static void main(String [] args)
//	{
//		LoginWindow l = new LoginWindow("Login Window");
//		LoginWindowController c = new LoginWindowController(l);
//	}
}

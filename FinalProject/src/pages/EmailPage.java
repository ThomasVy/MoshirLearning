package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sharedElements.Course;

/**
 * Provides the fields and methods required to create an EmailPage object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class EmailPage extends PagesInACourse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -3199561687234789383L;
	private JTextField subjectTextField;
	private JTextArea messageTextArea;
	private JButton send;
	private JButton cancel;

	/**
	 * Constructs an EmailPage object.
	 * @param courses - the courses of the user
	 * @param isProfessor - true if user is a professor, false otherwise
	 * @param course - the current course
	 */
	public EmailPage(ArrayList<Course> courses, boolean isProfessor, Course course) {
		super(courses, isProfessor, course);

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		JPanel emailpageTitlePanel = new JPanel();
		contentPanel.add(emailpageTitlePanel);
		emailpageTitlePanel.setLayout(new BoxLayout(emailpageTitlePanel, BoxLayout.Y_AXIS));

		JLabel emailPageTitle = new JLabel("Email Page");
		emailPageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		emailPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		emailPageTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		emailpageTitlePanel.add(emailPageTitle);

		JPanel spacingPanel = new JPanel();
		contentPanel.add(spacingPanel);

		JPanel emailWriterPanel = new JPanel();
		contentPanel.add(emailWriterPanel);
		emailWriterPanel.setLayout(new BoxLayout(emailWriterPanel, BoxLayout.Y_AXIS));

		JPanel subjectPanel = new JPanel();
		emailWriterPanel.add(subjectPanel);

		JLabel subjectLabel = new JLabel("Subject:");
		subjectPanel.add(subjectLabel);
		subjectLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));

		subjectTextField = new JTextField();
		subjectTextField.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		subjectPanel.add(subjectTextField);
		subjectTextField.setColumns(10);

		JPanel messagePanel = new JPanel();
		emailWriterPanel.add(messagePanel);

		messageTextArea = new JTextArea();
		messageTextArea.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		messagePanel.add(messageTextArea);
		messageTextArea.setColumns(50);
		messageTextArea.setRows(10);
		messageTextArea.setLineWrap(true);

		JPanel buttonsPanel = new JPanel();
		contentPanel.add(buttonsPanel);

		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(135, 206, 235));
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		buttonsPanel.add(cancel);

		send = new JButton("Send");
		send.setBackground(new Color(135, 206, 235));
		send.setForeground(Color.WHITE);
		send.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		buttonsPanel.add(send);

	}

	// Getters:
	
	/**
	 * Gets the subject text.
	 * @return the subject text
	 */
	public String getSubject() {
		return subjectTextField.getText();
	}

	/**
	 * Gets the message text.
	 * @return the message text
	 */
	public String getMessage() {
		return messageTextArea.getText();
	}

	// Listeners:

	/**
	 * Sets up the send button.
	 * @param e - the action listener to be added
	 */
	public void setupSendButtonListener(ActionListener e) {
		send.addActionListener(e);
	}

	/**
	 * Sets up the cancel button.
	 * @param e - the action listener to be added
	 */
	public void setupCancelButtonListener(ActionListener e) {
		cancel.addActionListener(e);
	}

}

package pages;

import java.util.ArrayList;

import sharedElements.Assignment;
import sharedElements.Course;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class EmailPage extends PagesInACourse{
	private JTextArea textArea;
	private JTextField textField_2;
	private JButton btnSend;
	private JButton  btnCancel;

	public EmailPage(ArrayList<Course> courses, boolean isProfessor, Course course) {
		super(courses, isProfessor, course);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JLabel lblEmailPage = new JLabel("Email Page");
		lblEmailPage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEmailPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		panel_2.add(lblEmailPage);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JLabel lblSubject = new JLabel("Subject:");
		panel_7.add(lblSubject);
		lblSubject.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_7.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_8.add(textArea);
		textArea.setColumns(50);
		textArea.setRows(10);
		textArea.setLineWrap(true);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(135, 206, 235));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_5.add(btnCancel);
		
		btnSend = new JButton("Send");
		btnSend.setBackground(new Color(135, 206, 235));
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		panel_5.add(btnSend);
		
		
	}
	public String getSubject ()
	{
		return textField_2.getText();
	}
	public String getMessage()
	{
		return textArea.getText();
	}
	public void setupSendButtonListener(ActionListener e)
	{
		btnSend.addActionListener(e);
	}
	public void setupCancelButtonListener(ActionListener e)
	{
		btnCancel.addActionListener(e);
	}

}

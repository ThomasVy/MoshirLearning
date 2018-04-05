package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import pages.HomePage;
import sharedElements.*;

public class LoginWindowController {
	private LoginWindow view;
	private Client client;
	public LoginWindowController(LoginWindow view, Client cl)
	{
		client = cl;
		this.view = view;
		addButtonListeners();
	}
	public void addButtonListeners()
	{
		view.addClearListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent clearButtonClick) {
				view.clearTextFields();
			}
			
		});
		view.addSubmitListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent submitButtonClick) {
				login();
			}
			
		});
		view.addExitListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent exitButtonClick) {
				view.dispose();
				System.exit(0);
				
			}
			
		});
	}
	public void login ()
	{
			String username = view.getUsername();
			String password = view.getPassword();
			LoginInfo userLoginInfo = new LoginInfo(username, password);
			User userLoggedIn = (User)client.communicateWithServer(userLoginInfo);

			if(userLoggedIn== null)
			{
				JOptionPane.showMessageDialog(null, "Invalid username/password", "Failed submission", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				System.out.println("It is correct!");
				ArrayList<Course> courses = (ArrayList<Course>) client.communicateWithServer("GetCourses");
				view.dispose();
				
				ProfessorGUI pgui = new ProfessorGUI(client, (Professor)userLoggedIn, true, courses);
			}
	}
}

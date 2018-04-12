package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import sharedElements.*;

/**
 * The Login Window controller.
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class LoginWindowController {
	/**
	 * The gui of the loginwindow
	 */
	private LoginWindow view;
	/**
	 * the client
	 */
	private Client client;
	/**
	 * Login Window Controller constructor
	 * @param view - the login window gui
	 * @param cl - the client
	 */
	public LoginWindowController(LoginWindow view, Client cl) {
		client = cl;
		this.view = view;
		addButtonListeners();
	}
	/**
	 * Adds the button listeners for the buttons on the login window gui
	 */
	public void addButtonListeners() {
		view.addClearListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent clearButtonClick) {
				view.clearTextFields();
			}
		});
		view.addSubmitListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent submitButtonClick) {
				login();
			}
		});
		view.addExitListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent exitButtonClick) {
				view.dispose();
				System.exit(0);
			}
		});
	}
	/**
	 * verifies the login and if valid sends control to page navigator
	 */
	public void login() {
		String username = view.getUsername();
		String password = view.getPassword();
		LoginInfo userLoginInfo = new LoginInfo(username, password);
		User userLoggedIn = (User) client.communicateWithServer(userLoginInfo);
		if (userLoggedIn == null) {
			JOptionPane.showMessageDialog(null, "Invalid username/password.", "Failed Login",
					JOptionPane.ERROR_MESSAGE);
		} else if (userLoggedIn.getClass().getSimpleName().equals("Professor")){
			view.dispose();
			ProfessorGUI pgui = new ProfessorGUI(client,(Professor) userLoggedIn);
		}
		else if(userLoggedIn.getClass().getSimpleName().equals("Student")) {
			view.dispose();
			StudentGUI sgui = new StudentGUI(client,(Student)userLoggedIn);
		}
	}

}

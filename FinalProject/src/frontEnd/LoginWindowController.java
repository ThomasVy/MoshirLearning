package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import sharedElements.LoginInfo;

public class LoginWindowController {
	private LoginWindow view;
	
	public LoginWindowController(LoginWindow view)
	{
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
	}
}

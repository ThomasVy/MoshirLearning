package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				System.out.println("Submit isn't implemented yet.");
				
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
}

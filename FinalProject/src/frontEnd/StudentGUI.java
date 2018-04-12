package frontEnd;

import components.*;
import sharedElements.*;

/**
 * Setups up student page handler
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class StudentGUI extends PageNavigator{
	/**
	 * Constructor of the student page handler
	 * @param client - the client
	 * @param student - the student user 
	 */
	public StudentGUI(Client client, Student student)
	{
		super(client, false, student);
	}
}

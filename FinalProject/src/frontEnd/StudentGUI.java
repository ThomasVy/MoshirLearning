package frontEnd;

import components.*;
import sharedElements.*;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class StudentGUI extends PageNavigator{
	
	public StudentGUI(Client client, Student student)
	{
		super(client, false, student);
	}
}

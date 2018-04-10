package sharedElements;

/**
 * Provides the fields and methods required to create a Professor object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 3, 2018
 *
 */
public class Professor extends User {

	/**
	 * Constructs a Professor object.
	 * @param id - the professor's id
	 * @param firstName - the professor's first name
	 * @param lastName - the professor's last name
	 */
	public Professor(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}

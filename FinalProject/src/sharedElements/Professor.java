package sharedElements;

/**
 * Provides the fields and methods required to create a Professor object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Professor extends User {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 7027308180295955221L;

	/**
	 * Constructs a Professor object.
	 * @param id - the id of the Professor
	 * @param firstName - the first name of the Professor
	 * @param lastName - the last name of the Professor
	 */
	public Professor(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}

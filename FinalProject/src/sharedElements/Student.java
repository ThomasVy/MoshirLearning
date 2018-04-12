package sharedElements;

/**
 * Provides the fields and methods required to create a Student object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Student extends User {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -5739774802464915157L;

	/**
	 * Constructs a Student object.
	 * @param id - the id of the Student
	 * @param firstName - the first name of the Student
	 * @param lastName - the last name of the Student
	 */
	public Student(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}

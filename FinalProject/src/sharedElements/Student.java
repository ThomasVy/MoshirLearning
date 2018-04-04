package sharedElements;

/**
 * Provides the fields and methods required to create a Student object.
 * @author R. Lim
 * @version 1.0
 * @since April 3, 2018
 *
 */
public class Student extends User {

	/**
	 * Constructs a Student object.
	 * @param id - the student's id
	 * @param firstName - the student's first name
	 * @param lastName - the student's last name
	 */
	public Student(int id, String firstName, String lastName, char type) {
		super(id, firstName, lastName, type);
	}

}

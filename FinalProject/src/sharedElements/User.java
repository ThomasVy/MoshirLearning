package sharedElements;

/**
 * Provides the fields and methods required to create a User object.
 * @author R. Lim
 * @version 1.0
 * @since April 3, 2018
 *
 */
public class User {

	private int id; // The user's id
	private String firstName; // The user's first name
	private String lastName; // The user's last name

	/**
	 * Constructs a User object.
	 * @param id - the user's id
	 * @param firstName - the user's first name
	 * @param lastName - the user's last name
	 */
	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters:
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	// Setters:
	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return id + "   " + firstName + " " + lastName;
	}

}

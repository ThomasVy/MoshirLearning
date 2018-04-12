package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a User object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class User implements Serializable, Comparable<User> {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 2596726305835743469L;
	/**
	 * The id of the User.
	 */
	protected int id;
	/**
	 * The first name of the User
	 */
	protected String firstName;
	/**
	 * The last name of the User
	 */
	protected String lastName;

	/**
	 * Constructs a User object.
	 * @param id - the id of the User
	 * @param firstName - the first name of the User
	 * @param lastName - the last name of the User
	 */
	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters:

	/**
	 * Gets the id of the User.
	 * @return id - the id of the User.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the first name of the User.
	 * @return firstName - the first name of the User.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name of the User.
	 * @return lastName - the last name of the User.
	 */
	public String getLastName() {
		return lastName;
	}

	// Setters:

	/**
	 * Sets the id of the User.
	 * @param id - the id to which it will set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the first name of the User.
	 * @param firstName - the first name to which it will set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the last name of the User.
	 * @param lastName the last name to which it will set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Converts fields into a String.
	 */
	@Override
	public String toString() {
		return id + "    " + firstName + "    " + lastName;
	}

	/**
	 * Compares Users using last names.
	 */
	@Override
	public int compareTo(User otherUser) {
		return this.lastName.compareTo(((User) otherUser).lastName);
	}

}

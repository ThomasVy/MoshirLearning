package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a LoginInfo object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class LoginInfo implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -2608042435372031532L;
	/**
	 * The username of the LoginInfo.
	 */
	private String username;
	/**
	 * The password of the LoginInfo.
	 */
	private String password;

	/**
	 * Constructs a LoginInfo object.
	 * @param username - the username of the LoginInfo
	 * @param password - the password of the LoginInfo
	 */
	public LoginInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Getters:

	/**
	 * Gets the username of the LoginInfo.
	 * @return username - the username of the LoginInfo
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password of the LoginInfo.
	 * @return password - the password of the LoginInfo
	 */
	public String getPassword() {
		return password;
	}

	// Setters:

	/**
	 * Sets the username of the LoginInfo.
	 * @param username - the username to which it will set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the password of the LoginInfo.
	 * @param password - the password to which it will set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

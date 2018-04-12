package sharedElements;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Provides the fields and methods required to create an Email object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Email implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 2009816020947673580L;
	/**
	 * The email address of the sender.
	 */
	private String from;
	/**
	 * The email addresses of the receivers.
	 */
	private ArrayList<String> to;
	/**
	 * The subject of the Email.
	 */
	private String subject;
	/**
	 * The content of the Email.
	 */
	private String content;
	/**
	 * The password of the sender.
	 */
	private String password;

	/**
	 * Constructs an Email object.
	 * @param subject - the subject of the Email.
	 * @param content - the content of the Email.
	 */
	public Email(String subject, String content) {
		this.subject = subject;
		this.content = content;
	}

	// Getters:

	/**
	 * Gets the email address of the sender.
	 * @return from - the email address of the sender
	 */
	public String getSender() {
		return from;
	}

	/**
	 * Gets the email address of the receivers.
	 * @return to - the email addresses of the receivers
	 */
	public ArrayList<String> getReceiver() {
		return to;
	}

	/**
	 * Gets the subject of the Email.
	 * @return subject - the subject of the Email
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Gets the content of the Email.
	 * @return content - the content of the Email
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Gets the password of the sender.
	 * @return password - the password of the sender
	 */
	public String getPassword() {
		return password;
	}

	// Setters:

	/**
	 * Sets the email address of the sender.
	 * @param sender - the email address to which it will set
	 */
	public void setSender(String from) {
		this.from = from;
	}

	/**
	 * Sets the email addresses of the receivers.
	 * @param to - the email addresses to which it will set
	 */
	public void setReceiver(ArrayList<String> to) {
		this.to = to;
	}

	/**
	 * Sets the password of the sender.
	 * @param password - the password to which it will set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create an Assignment object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Assignment implements Serializable, Comparable<Assignment> {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -6842316136708639845L;
	/**
	 * The id of the Assignment.
	 */
	private int id;
	/**
	 * The course id of the Assignment.
	 */
	private int course_id;
	/**
	 * The title of the Assignment.
	 */
	private String title;
	/**
	 * The path of the file of the Assignment.
	 */
	private String path;
	/**
	 * The state of the Assignment.
	 */
	private boolean active;
	/**
	 * The due date of the Assignment.
	 */
	private String due_date;

	/**
	 * Constructs an Assignment object.
	 * @param course_id - the course id of the Assignment
	 * @param title - the title of the Assignment
	 * @param path - the path of the file of the Assignment
	 * @param active - the state of the Assignment
	 * @param due_date - the due date of the Assignment
	 */
	public Assignment(int course_id, String title, String path, boolean active, String due_date) {
		this.course_id = course_id;
		this.title = title;
		this.path = path;
		this.active = active;
		this.due_date = due_date;
	}

	// Getters:

	/**
	 * Gets the id of the Assignment.
	 * @return id - the id of the Assignment
	 */
	public int getID() {
		return id;
	}

	/**
	 * Gets the course id of the Assignment.
	 * @return course_id - the course id of the Assignment
	 */
	public int getCourseID() {
		return course_id;
	}

	/**
	 * Gets the title of the Assignment.
	 * @return title - the title of the Assignment
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the path of the file of the Assignment.
	 * @return path - the path of the file of the Assignment
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the state of the Assignment.
	 * @return active - the state of the Assignment
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * Gets the due date of the Assignment.
	 * @return due_date - the due date of the Assignment
	 */
	public String getDueDate() {
		return due_date;
	}

	// Setters:

	/**
	 * Sets the id of the Assignment.
	 * @param id - the id to which it will set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Sets the path of the file of the Assignment.
	 * @param path - the path to which it will set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the state of the Assignment to opposite.
	 */
	public void setActiveToOpposite() {
		if (active == false) {
			active = true;
		} else {
			active = false;
		}
	}

	/**
	 * Converts fields into a String.
	 */
	@Override
	public String toString() {
		String state = "Active";
		if (active == false) {
			state = "Inactive";
		}
		return title + "    " + due_date + "    " + state;
	}

	/**
	 * Compares Assignments using titles.
	 */
	@Override
	public int compareTo(Assignment otherAssignment) {
		return this.title.compareTo(otherAssignment.title);
	}

}

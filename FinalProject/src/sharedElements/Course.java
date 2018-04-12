package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a Course object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Course implements Serializable, Comparable<Course> {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 846224407198565526L;
	/**
	 * The id of the Course.
	 */
	private int id;
	/**
	 * The id of the professor of the Course.
	 */
	private int profId;
	/**
	 * The name of the Course.
	 */
	private String name;
	/**
	 * The state of the Course.
	 */
	private boolean active;

	/**
	 * Constructs a Course object.
	 * @param profId - the id of the professor of the Course
	 * @param name - the name of the Course
	 * @param active - the state of the Course
	 */
	public Course(int profId, String name, boolean active) {
		this.profId = profId;
		this.name = name;
		this.active = active;
	}

	// Getters:

	/**
	 * Gets the id of the Course.
	 * @return id - the id of the Course
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the id of the professor of the Course.
	 * @return profId - the id of the professor of the Course
	 */
	public int getProfId() {
		return profId;
	}

	/**
	 * Gets the name of the Course.
	 * @return name - the name of the Course
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the state of the Course.
	 * @return active - the state of the Course.
	 */
	public boolean getActive() {
		return active;
	}

	// Setters:

	/**
	 * Sets the id of the Course.
	 * @param id - the id to which it will set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the id of the professor of the Course.
	 * @param profId - the id of the professor to which it will set
	 */
	public void setProfId(int profId) {
		this.profId = profId;
	}

	/**
	 * Sets the name of the Course.
	 * @param name - the name to which it will set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the state of the Course.
	 * @param active - the state to which it will set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Converts fields into a String.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Compares Courses using names.
	 */
	@Override
	public int compareTo(Course otherCourse) {
		return this.name.compareTo(otherCourse.name);
	}

}

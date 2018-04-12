package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a Course object.
 * 
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 3, 2018
 *
 */
public class Course implements Serializable, Comparable {

	private static final long serialVersionUID = 2392870314013198178L;
	private int id; // The course id
	private int profId; // The course prof's id
	private String name; // The course name
	private boolean active; // The course activity

	/**
	 * Constructs a Course object.
	 * 
	 * @param id
	 *            - the course id
	 * @param profId
	 *            - the course prof's id
	 * @param name
	 *            - the course name
	 * @param active
	 *            - the course activity
	 */
	public Course(int profId, String name, boolean active) {
		this.profId = profId;
		this.name = name;
		this.active = active;
	}

	// Getters:
	public int getId() {
		return id;
	}

	public int getProfId() {
		return profId;
	}

	public String getName() {
		return name;
	}

	public boolean getActive() {
		return active;
	}

	// Setters:
	public void setId(int id) {
		this.id = id;
	}

	public void setProfId(int profId) {
		this.profId = profId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Object otherCourse) {
		return this.name.compareTo(((Course) otherCourse).name);
	}

}

package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a StudentEnrollment object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class StudentEnrollment implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 8352624937220571581L;
	/**
	 * The id of the StudentEnrollment.
	 */
	private int id;
	/**
	 * The student id of the StudentEnrollment.
	 */
	private int student_id;
	/**
	 * The course id of the StudentEnrollment.
	 */
	private int course_id;
	/**
	 * True if student is enrolling, false otherwise.
	 */
	private boolean enrolling;

	/**
	 * Constructs a StudentEnrollment object.
	 * @param student_id - the student id of the StudentEnrollment
	 * @param course_id - the course id of the StudentEnrollment
	 * @param enrolling - true if student is enrolling, false otherwise
	 */
	public StudentEnrollment(int student_id, int course_id, boolean enrolling) {
		this.student_id = student_id;
		this.course_id = course_id;
		this.enrolling = enrolling;
	}

	// Getters:

	/**
	 * Gets the id of the StudentEnrollment.
	 * @return id - the id of the StudentEnrollment.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the student id of the StudentEnrollment.
	 * @return student_id - the student id of the StudentEnrollment.
	 */
	public int getStudentId() {
		return student_id;
	}

	/**
	 * Gets the course id of the StudentEnrollment.
	 * @return course_id - the course id of the StudentEnrollment
	 */
	public int getCourseId() {
		return course_id;
	}

	/**
	 * Gets the enrolling of the StudentEnrollment.
	 * @return enrolling - true if student is enrolling, false otherwise
	 */
	public boolean getEnrolling() {
		return enrolling;
	}

	// Setters:

	/**
	 * Sets the id of the StudentEnrollment.
	 * @param id - the id to which it will set
	 */
	public void setId(int id) {
		this.id = id;
	}

}

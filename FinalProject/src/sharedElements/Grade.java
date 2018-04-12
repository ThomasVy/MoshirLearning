package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a Grade object.
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Grade implements Serializable, Comparable<Grade> {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -8350991464896696524L;
	/**
	 * The id of the Grade.
	 */
	private int id;
	/**
	 * The assignment id of the Grade.
	 */
	private int assign_id;
	/**
	 * The assignment title of the Grade.
	 */
	private String assign_title;
	/**
	 * The student id of the Grade.
	 */
	private int student_id;
	/**
	 * The course id of the Grade.
	 */
	private int course_id;
	/**
	 * The assignment grade of the Grade.
	 */
	private int assignment_grade;

	/**
	 * Constructs a Grade object.
	 * @param assign_id - the assignment id of the Grade
	 * @param assign_title - the assignment title of the Grade
	 * @param student_id - the student id of the Grade
	 * @param course_id - the course id of the Grade
	 * @param assignment_grade - the assignment grade of the Grade
	 */
	public Grade (int assign_id, String assign_title, int student_id, int course_id, int assignment_grade) {
		this.assign_id = assign_id;
		this.assign_title = assign_title;
		this.student_id = student_id;
		this.course_id = course_id;
		this.assignment_grade = assignment_grade;
	}

	// Getters:

	/**
	 * Gets the id of the Grade.
	 * @return id - the id of the Grade
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the assignment id of the Grade
	 * @return - the assignment id of the Grade
	 */
	public int getAssignId() {
		return assign_id;
	}

	/**
	 * Gets the student id of the Grade
	 * @return student_id - the student id of the Grade
	 */
	public int getStudentId() {
		return student_id;
	}

	/**
	 * Gets the course id of the Grade.
	 * @return - the course id of the Grade
	 */
	public int getCourseId() {
		return course_id;
	}

	/**
	 * Gets the assignment grade of the Grade.
	 * @return - assignment_grade - the assignment grade of the Grade
	 */
	public int getAssignmentGrade() {
		return assignment_grade;
	}

	// Setters:

	/**
	 * Sets the id of the Grade.
	 * @param id - the id to which it will set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the assignment id of the Grade.
	 * @param assign_id - the assignment id to which it will set
	 */
	public void setAssignId(int assign_id) {
		this.assign_id = assign_id;
	}

	/**
	 * Sets the student id of the Grade.
	 * @param student_id - the student id to which it will set
	 */
	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}

	/**
	 * Sets the course id of the Grade.
	 * @param course_id - the course id to which it will set
	 */
	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	/**
	 * Sets the assignment grade of the Grade.
	 * @param assignment_grade - the assignment grade to which it will set
	 */
	public void setAssignmentGrade(int assignment_grade) {
		this.assignment_grade = assignment_grade;
	}

	@Override
	public String toString() {
		return assign_title + "    " + student_id + "    " + assignment_grade + "%";
	}

	@Override
	public int compareTo(Grade otherGrade) {
		int otherGradeAssignId = otherGrade.assign_id;
		return this.assign_id - otherGradeAssignId;
	}

}

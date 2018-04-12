package sharedElements;

import java.io.Serializable;

/**
 * Provides the fields and methods required to create a Submission object.
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 12, 2018
 */
public class Submission implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = -1092554612797390885L;
	/**
	 * The id of the Submission.
	 */
	private int id;
	/**
	 * The course id of the Submission.
	 */
	private int course_id;
	/**
	 * The assignment id of the Submission.
	 */
	private int assign_id;
	/**
	 * The student id of the Submission.
	 */
	private int student_id;
	/**
	 * The path of the file of the Submission.
	 */
	private String path;
	/**
	 * The title of the Submission.
	 */
	private String title;
	/**
	 * The grade of the Submission.
	 */
	private int grade;
	/**
	 * The comments of the Submission.
	 */
	private String comments;
	/**
	 * The time at which the Submission was submitted.
	 */
	private String timestamp;

	/**
	 * Constructs a Submission object.
	 * @param course_id - the course id of the Submission
	 * @param assign_id - the assignment id of the Submission
	 * @param student_id - the student id of the Submission
	 * @param path - the path of the file of the Submission
	 * @param title - the title of the Submission
	 */
	public Submission(int course_id, int assign_id, int student_id, String path, String title) {
		this.course_id = course_id;
		this.assign_id = assign_id;
		this.student_id = student_id;
		this.path = path;
		this.title = title;
		this.grade = -1;
		this.comments = "N/A";
		this.timestamp = "N/A";
	}

	// Getters:

	/**
	 * Gets the id of the Submission.
	 * @return id - the id of the Submission
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the course id of the Submission.
	 * @return course_id - the course id of the Submission
	 */
	public int getCourseId() {
		return course_id;
	}

	/**
	 * Gets the assignment id of the Submission.
	 * @return assign_id - the assignment id of the Submission
	 */
	public int getAssignId() {
		return assign_id;
	}

	/**
	 * Gets the student id of the Submission.
	 * @return student_id - the student id of the Submission
	 */
	public int getStudentId() {
		return student_id;
	}

	/**
	 * Gets the path of the file of the Submission.
	 * @return path - the path of the file of the Submission
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the title of the Submission.
	 * @return title - the title of the Submission
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the grade of the Submission.
	 * @return grade - the grade of the Submission
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Gets the comments of the Submission.
	 * @return comments - the comments of the Submission
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Gets the time at which the Submission was submitted.
	 * @return timestamp - the time at which the Submission was submitted
	 */
	public String getTimestamp() {
		return timestamp;
	}

	// Setters:

	/**
	 * Sets the id of the Submission.
	 * @param id - the id to which it will set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the course id of the Submission.
	 * @param course_id - the course id to which it will set
	 */
	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	/**
	 * Sets the assignment id of the Submission.
	 * @param assign_id - the assignment id to which it will set
	 */
	public void setAssignId(int assign_id) {
		this.assign_id = assign_id;
	}

	/**
	 * Sets the student id of the Submission.
	 * @param student_id - the student id to which it will set
	 */
	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}

	/**
	 * Sets the path of the file of the Submission.
	 * @param path - the path to which it will set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the title of the Submission.
	 * @param title - the title to which it will set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the grade of the Submission
	 * @param grade - the grade to which it will set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * Sets the comments of the Submission
	 * @param comments - the comments to which it will set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Sets the timestamp of the Submission
	 * @param timestamp - the timestamp to which it will set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Converts fields into a String.
	 */
	@Override
	public String toString() {
		return title +  "    " + student_id + "    " + timestamp + "    " + grade + "%    " + comments;
	}

}

package sharedElements;

import java.io.Serializable;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class Submission implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int course_id;
	private int assign_id;
	private int student_id;
	private String path;
	private String title;
	private int grade;
	private String comments;
	private String timestamp;

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

	// GETTERS
	public int getId() {
		return id;
	}

	public int getCourseId() {
		return course_id;
	}

	public int getAssignId() {
		return assign_id;
	}

	public int getStudentId() {
		return student_id;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

	public int getGrade() {
		return grade;
	}

	public String getComments() {
		return comments;
	}

	public String getTimestamp() {
		return timestamp;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	public void setAssignId(int assign_id) {
		this.assign_id = assign_id;
	}

	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return title +  "    " + student_id + "    " + timestamp + "    " + grade + "    " + comments;
	}

}

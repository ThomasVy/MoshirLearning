package sharedElements;

import java.io.Serializable;

public class Grade implements Serializable, Comparable {

	private static final long serialVersionUID = 2033804042346144390L;
	private int id;
	private int assign_id;
	private String assign_title;
	private int student_id;
	private int course_id;
	private int assignment_grade;

	public Grade (int assign_id, String assign_title, int student_id, int course_id, int assignment_grade) {
		this.assign_id = assign_id;
		this.assign_title = assign_title;
		this.student_id = student_id;
		this.course_id = course_id;
		this.assignment_grade = assignment_grade;
	}

	// GETTERS
	public int getId() {
		return id;
	}

	public int getAssignId() {
		return assign_id;
	}

	public int getStudentId() {
		return student_id;
	}

	public int getCourseId() {
		return course_id;
	}

	public int getAssignmentGrade() {
		return assignment_grade;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setAssignId(int assign_id) {
		this.assign_id = assign_id;
	}

	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	public void setAssignmentGrade(int assignment_grade) {
		this.assignment_grade = assignment_grade;
	}

	@Override
	public String toString() {
		return assign_title + "    " + student_id + "    " + assignment_grade + "%";
	}

	@Override
	public int compareTo(Object otherGrade) {
		int otherGradeAssignId = ((Grade) otherGrade).assign_id;
		return this.assign_id - otherGradeAssignId;
	}

}

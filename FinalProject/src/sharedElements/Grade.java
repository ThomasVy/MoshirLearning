package sharedElements;

import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = 2033804042346144390L;
	private int id;
	private int assign_id;
	private int student_id;
	private int course_id;
	private int assignment_grade;
	
	public Grade (int assign_id, int student_id, int course_id, int assignment_grade)
	{
		this.assign_id = assign_id;
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

	public int courseId() {
		return course_id;
	}

	public int assignmentGrade() {
		return assignment_grade;
	}

	// SETTERS
	public void setId(int id) {
		
	}

	public void setAssignId() {
		
	}

	public void setStudentId() {
		
	}

	public void setCourseId() {
		
	}

	public void setAssignmentGrade() {
		
	}

}

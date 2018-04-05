package sharedElements;

import java.io.Serializable;

public class StudentEnrollment implements Serializable {

	private static final long serialVersionUID = 7889018319659988650L;
	private int id;
	private int student_id;
	private int course_id;
	private boolean enrolling;
	
	public StudentEnrollment(int id, int student_id, int course_id, boolean enrolling)
	{
		this.id =id;
		this.student_id = student_id;
		this.course_id =course_id;
		this.enrolling = enrolling;
	}
	public int getID ()
	{
		return id;
	}
	public int getStudentID()
	{
		return student_id;
	}
	public int getCourseID()
	{
		return course_id;
	}
	public boolean getEnrolling ()
	{
		return enrolling;
	}
}

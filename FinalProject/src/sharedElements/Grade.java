package sharedElements;

import java.io.Serializable;

public class Grade implements Serializable{
	private static final long serialVersionUID = 2033804042346144390L;
	private int student_id;
	private int grade;
	private String student_name;
	private String assign_name;
	
	public Grade (int student_id, int grade, String student_name, String assign_name)
	{
		this.student_id=student_id;
		this.grade =grade;
		this.student_name =student_name;
		this.assign_name =assign_name;
	}
	public int getStudentID ()
	{
		return student_id;
		
	}
	public int getGrade ()
	{
		return grade;
	}
	public String getStudentName ()
	{
		return student_name;
	}
	public String getAssignName ()
	{
		return assign_name;
	}
}

package sharedElements;

import java.io.Serializable;

public class StudentEnrollment implements Serializable {

	private static final long serialVersionUID = 7889018319659988650L;
	private int id;
	private int student_id;
	private int course_id;
	private boolean enrolling;
	
	public StudentEnrollment()
	{
		
	}

}

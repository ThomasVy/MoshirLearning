package sharedElements;

import java.io.Serializable;

public class Submission implements Serializable{

	private static final long serialVersionUID = 1290171084621310056L;
	private int id;
	private int assign_id;
	private int student_id;
	private String path;
	private int grade;
	private String comment;
	private String title;
	private String timestamp;
	
	public Submission()
	{
		
	}
	public void setPath (String path)
	{
		this.path = path;
	}
	public String getPath ()
	{
		return path;
	}
}

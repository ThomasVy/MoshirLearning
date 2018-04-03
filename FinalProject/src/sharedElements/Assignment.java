package sharedElements;

import java.io.Serializable;

public class Assignment implements Serializable {

	private static final long serialVersionUID = -7463971612832731497L;
	private int id;
	private int course_id; 
	private String title;
	private String path;
	private boolean active;
	private String due_date;
	
	public Assignment ()
	{
		
	}
	public String getPath ()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	
}

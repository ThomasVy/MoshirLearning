package sharedElements;

import java.io.Serializable;

public class Assignment implements Serializable {

	private static final long serialVersionUID = -7463971612832731497L;
	private int id;
	private int course_id; 
	private String title;
	private String fileExtension;
	private String path = "//ServerSide//Assignments";
	private boolean active;
	private String due_date;
	
	public Assignment (int id, int course_id, String title, String fileExtension, boolean active, String due_date)
	{
		this.id = id;
		this.course_id =course_id;
		this.title = title;
		this.fileExtension = fileExtension;
		this.active= active;
		this.fileExtension = fileExtension;
		this.due_date =due_date;
	}
	public String getFileExtension ()
	{
		return fileExtension;
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

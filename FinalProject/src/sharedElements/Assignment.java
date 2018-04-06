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

	public Assignment(int id, int course_id, String title, String path, boolean active, String due_date) {
		this.id = id;
		this.course_id = course_id;
		this.title = title;
		this.path = path; // path will include the file name and file extension.
		this.active = active;
		this.due_date = due_date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCourseID() {
		return course_id;
	}

	public boolean getActive() {
		return active;
	}

	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDueDate() {
		return due_date;
	}

}

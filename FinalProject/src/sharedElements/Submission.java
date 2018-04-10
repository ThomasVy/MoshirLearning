package sharedElements;

import java.io.Serializable;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class Submission implements Serializable {

	private static final long serialVersionUID = 1290171084621310056L;
	private int id;
	private int assign_id;
	private int student_id;
	private String path;
	private int grade;
	private String comment;
	private String title;
	private String timestamp;
	private String fileExtension;

	public Submission() {
		path = "//ServerSide//Submissions";
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}

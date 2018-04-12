package backEnd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import sharedElements.Assignment;
import sharedElements.Submission;

/**
 * The file manager of the server.
 * @author Rainer Lim & Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 *
 */
public class FileHelper {
	/**
	 * The path of the current directory
	 */
	private String absPath;
	/**
	 * The constructor of the file manager
	 * @param absPath - the path for the current directory
	 */
	public FileHelper(String absPath) {
		this.absPath = absPath;
	}
	/**
	 * sets the path for the current directory
	 * @param path - the path of the current directory to be set
	 */
	public void setPath(String path) {
		absPath = path;
	}
	/**
	 * Gets the file content from the path
	 * @param path - the path of the file to be converted
	 * @return - the file converted into bytes
	 */
	public byte[] getFileContent(String path) { 
		File selectedFile = new File(path);
		long length = selectedFile.length();
		byte[] content = new byte[(int) length];
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bos = new BufferedInputStream(fis);
			bos.read(content, 0, (int)length);
			bos.close();
			fis.close();
		} catch (Exception e)
		{
			
		}
		return content;
	}

	// Assignments will be stored in "absPath"/Assignment/"File name with extension"
	/**
	 * Finds a unique name for the assignment
	 * @param a - the assignment to be added into the server data base
	 */
	synchronized public void findUnqiuePath (Assignment a) {
			int j = 0;
			while (true) {
				String extension = "";
				int i = a.getPath().lastIndexOf('.');
				if (i > 0) {
					extension = a.getPath().substring(i);
				}
				extension = a.getTitle().replaceAll(" ", "_")+"_"+ j + extension;
				Path filePath = Paths.get(absPath, "Assignments", extension); // A folder titled "Assignments" must exist in project directory
				File newFile = new File(filePath.toString());
				if (!newFile.exists()) {
					a.setPath(filePath.toString());
					break;
				}
				j++;
			}
			
	}
	/**
	 * Writes the file content of the assignment to the server hard drive.
	 * @param a - the assignment to be placed on hard drive
	 * @param content - the file of the assignment in bytes
	 */
	public void writeFileContent(Assignment a, byte[] content) {
		try {
				File newFile = new File(a.getPath());
				newFile.createNewFile();
				FileOutputStream writer = new FileOutputStream(newFile);
				BufferedOutputStream bos = new BufferedOutputStream(writer);
				bos.write(content);
				writer.close();
				bos.close();
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * Finds a unique name for the submission and writes it to the server hard drive 
	 * @param s - the submission to be added to the server harddrive
	 * @param content - the submission file to be save in the server's hard drive in bytes
	 */
	synchronized public void writeFileContent(Submission s, byte[] content) {
		try {
			int j = 0;
			while (true) {
				String extension = "";
				int i = s.getPath().lastIndexOf('.');
				if (i > 0) {
					extension = s.getPath().substring(i);
				}
				extension = s.getTitle().replaceAll(" ", "_")+"_"+ j + extension;
				Path filePath = Paths.get(absPath, "Submissions", extension);
				s.setPath(filePath.toString());
				File newFile = new File(filePath.toString());
				if (!newFile.exists()) {
					newFile.createNewFile();
					FileOutputStream writer = new FileOutputStream(newFile);
					BufferedOutputStream bos = new BufferedOutputStream(writer);
					bos.write(content);
					bos.close();
					break;
				}
				j++;
			}
		} catch (Exception e)
		{
			return;
		}
	}

}

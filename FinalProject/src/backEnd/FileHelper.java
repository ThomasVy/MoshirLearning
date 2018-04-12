package backEnd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import sharedElements.Assignment;
import sharedElements.Submission;

/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class FileHelper {

	private String absPath; // The current directory

	public FileHelper(String absPath) {
		this.absPath = absPath;
	}

	public void setPath(String path) {
		absPath = path;
	}

	public byte[] getFileContent(String path) { // Remember to put the file extension
		File selectedFile = new File(path);
		long length = selectedFile.length();
		byte[] content = new byte[(int) length]; // Converting long to int
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
		// for writing to socket
	}

	// Assignments will be stored in "absPath"/Assignment/"File name with extension"
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

	// SUBMISSION
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

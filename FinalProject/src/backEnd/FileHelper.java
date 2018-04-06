package backEnd;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import sharedElements.Assignment;

public class FileHelper {
	private String absPath; // the current directory

	public FileHelper(String absPath) {
		this.absPath = absPath;
	}

	public void setPath(String path) {
		absPath = path;
	}
	// Assignment path is "absPath"/Assignment/"File name with extension"
	// public byte[] getFileContent (String path) //Remember to put the file
	// extension
	// {
	// File selectedFile = new File(path);
	// long length = selectedFile.length();
	// byte[] content = new byte[(int) length]; // Converting Long to Int
	// try {
	// FileInputStream fis = new FileInputStream(selectedFile);
	// BufferedInputStream bos = new BufferedInputStream(fis);
	// bos.read(content, 0, (int)length);
	// bos.close();
	// fis.close();
	// }
	// catch (FileNotFoundException e)
	// {
	// e.printStackTrace();
	// }
	// catch(IOException e)
	// {
	// e.printStackTrace();
	// }
	// return content;
	// //for writing to socket
	// }

	// Assignments will be stored in "absPath"/Assignment/"File name with extension"
	public void writeFileContent(Assignment a, byte[] content) {
		try {
			int j = 0;
			while (true) {
				String extension = "";
				int i = a.getPath().lastIndexOf('.');
				if (i > 0) {
					extension = a.getPath().substring(i);
				}
				extension = a.getTitle() + j + extension;
				Path filePath = Paths.get(absPath, "Assignments", extension);
				System.out.println(filePath.toString());
				a.setPath(filePath.toString());
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		// writing to assignments
	}
	// public void writeFileContent(Submission s, byte [] content)
	// {
	// File newFile = new File(absPath + s.getPath());
	// try{
	// if(! newFile.exists())
	// newFile.createNewFile();
	// FileOutputStream writer = new FileOutputStream(newFile);
	// BufferedOutputStream bos = new BufferedOutputStream(writer);
	// bos.write(content);
	// bos.close();
	// }
	// catch(IOException e)
	// {
	// e.printStackTrace();
	// }
	// //writing to submissions
	// //then call set path
	// }
}

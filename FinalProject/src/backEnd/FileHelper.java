package backEnd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileHelper {
	private String absPath;

	public FileHelper(String path) {
		this.absPath = path;
	}

	public byte[] getFileContent(String relativePath) {
		String path = absPath + relativePath; // do error checking of the path
		File selectedFile = new File(path);
		JFileChooser fileBrowser = new JFileChooser();
		if (fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			selectedFile = fileBrowser.getSelectedFile();
		long length = selectedFile.length();
		byte[] content = new byte[(int) length]; // Converting Long to Int
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bos = new BufferedInputStream(fis);
			bos.read(content, 0, (int) length);
			try {
				bos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
		// for writing to socket
	}

	public void writeFileContent(Assignment a, byte[] content) {
		File newFile = new File(absPath + a.getPath() + FILE_EXTENSION);
		try {
			if (!newFile.exists())
				newFile.createNewFile();
			FileOutputStream writer = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(writer);
			bos.write(content);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// writing to assignments
		// then call set path
	}

	public void writeFileContent(Submission s, byte[] content) {
		File newFile = new File(STORAGE_PATH + FILE_NAME + FILE_EXTENSION);
		try {
			if (!newFile.exists())
				newFile.createNewFile();
			FileOutputStream writer = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(writer);
			bos.write(content);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// writing to submissions
		// then call set path
	}

	public void setFilePath(Assignment a) {
		// sets the path for the assignment
	}

	public void setFilePath(Submission s) {
		// sets the path for the assignment
	}
}

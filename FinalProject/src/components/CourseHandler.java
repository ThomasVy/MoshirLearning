package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pages.*;
import sharedElements.*;
/**
 * Handles the pages that are related to a course
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 */
public class CourseHandler {
	/**
	 * the course of the pages
	 */
	private Course currentCourse;
	/**
	 * The page navigator of the pages
	 */
	private PageNavigator pageNavigator;
	/**
	 * The enrollment page of the course
	 */
	private EnrollmentPage enrollmentPage;
	/**
	 * The course home page of the course
	 */
	private CoursePage courseHomePage;
	/**
	 * grade page of the course
	 */
	private GradePage gradePage;
	/**
	 * The submission home page of the course
	 */
	private SubmissionHomePage submissionHomePage;
	/**
	 * The submission page of a assignment of the course
	 */
	private SubmissionPage submissionPage;
	/**
	 * The assignment page of the course
	 */
	private AssignmentPage assignmentPage;
	/**
	 * the email page of the course page
	 */
	private EmailPage emailPage;
	/**
	 * the courses of the user
	 */
	private ArrayList<Course> courses;
	/**
	 * The constructor of the course handler.
	 * @param pageNavigator - the page navigator for the course handler
	 * @param course - the course of the course handler
	 */
	public CourseHandler (PageNavigator pageNavigator, Course course)
	{
		this.pageNavigator = pageNavigator;
		this.currentCourse = course;
		createCourseHomePage();
	}
	/**
	 * creates the course home page of the course
	 */
	private void createCourseHomePage ()
	{
		courses = pageNavigator.getCourses();
		courseHomePage = new CoursePage(courses, pageNavigator.getIsProfessor(), currentCourse); //start off with home page at first
		pageNavigator.addComboBoxListener(courseHomePage);
		pageNavigator.addHomeButtonListener(courseHomePage);
		pageNavigator.addLogoutButtonListener(courseHomePage);
		addPageListeners(courseHomePage);
		addCourseHomePageListener();
		courseHomePage.setVisible(true);
	}
	/**
	 * creates the assignment page of the course
	 */
	private void createAssignmentPage ()
	{
		courses = pageNavigator.getCourses();
		assignmentPage = new AssignmentPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
		pageNavigator.addComboBoxListener(assignmentPage);
		pageNavigator.addHomeButtonListener(assignmentPage);
		pageNavigator.addLogoutButtonListener(assignmentPage);
		addPageListeners(assignmentPage);
		addAssignmentButtonListeners();
		assignmentPage.setVisible(true);
	}
	/**
	 * create the submission home page of the course
	 */
	private void createSubmissionHomePage() {
		courses = pageNavigator.getCourses();
		submissionHomePage = new SubmissionHomePage(courses, pageNavigator.getIsProfessor(), currentCourse);
		submissionHomePage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
		pageNavigator.addComboBoxListener(submissionHomePage);
		pageNavigator.addHomeButtonListener(submissionHomePage);
		pageNavigator.addLogoutButtonListener(submissionHomePage);
		addPageListeners(submissionHomePage);
		addSubmissionHomeListListener();
		submissionHomePage.setVisible(true);
	}
	/**
	 * creates the submission page of a assignment
	 * @param a - the assignment that the submission is linked to
	 */
	private void createSubmissionPage(Assignment a) {
		courses = pageNavigator.getCourses();
		submissionPage = new SubmissionPage(courses, pageNavigator.getIsProfessor(), currentCourse, a);
		submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList"));
		pageNavigator.addComboBoxListener(submissionPage);
		pageNavigator.addHomeButtonListener(submissionPage);
		pageNavigator.addLogoutButtonListener(submissionPage);
		addPageListeners(submissionPage);
		addSubmissionButtonListeners();
		submissionPage.setVisible(true);
	}
	/**
	 * creates the enrollment page of the course
	 */
	private void createEnrollmentPage ()
	{
		courses = pageNavigator.getCourses();
		enrollmentPage = new EnrollmentPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		enrollmentPage.setEnrollList((ArrayList<Student>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetEnrollmentList"));
		pageNavigator.addComboBoxListener(enrollmentPage);
		pageNavigator.addHomeButtonListener(enrollmentPage);
		pageNavigator.addLogoutButtonListener(enrollmentPage);
		addPageListeners(enrollmentPage);
		addEnrollmentButtonListeners();
		enrollmentPage.setVisible(true);
	}
	/**
	 * create the grades page of the course
	 */
	public void createGradesPage()
	{
		courses = pageNavigator.getCourses();
		gradePage = new GradePage(courses, pageNavigator.getIsProfessor(), currentCourse);
		gradePage.setGradesList((ArrayList<Grade>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetGradeList"));
		pageNavigator.addComboBoxListener(gradePage);
		pageNavigator.addHomeButtonListener(gradePage);
		pageNavigator.addLogoutButtonListener(gradePage);
		addPageListeners(gradePage);
		gradePage.setVisible(true);
	}
	/**
	 * creates the email page of the course
	 */
	public void createEmailPage()
	{
		courses = pageNavigator.getCourses();
		emailPage = new EmailPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		pageNavigator.addComboBoxListener(emailPage);
		pageNavigator.addHomeButtonListener(emailPage);
		pageNavigator.addLogoutButtonListener(emailPage);
		addPageListeners(emailPage);
		addEmailPageButtonListeners();
		emailPage.setVisible(true);
	}
	/**
	 * creates the page button listeners 
	 * @param page - the page to assign the button listeners
	 */
	private void addPageListeners(PagesInACourse page)
	{
		page.addAssignmentsButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.dispose();
				createAssignmentPage();
			}
		});
		page.addGradesButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.dispose();
				createGradesPage();
			}
		});
		page.addSubmissionsButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.dispose();
				createSubmissionHomePage();
			}
		});
		page.addEnrollmentButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.dispose();
				createEnrollmentPage();
			}
		});
	}
	/**
	 * adds button listeners for the course home page 
	 */
	private void addCourseHomePageListener()
	{
		if(pageNavigator.getIsProfessor()==true)
		{
			courseHomePage.setupCourseActiveButton(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (currentCourse.getActive()== false) // Makes it active
					{
						String text = "Course Active";
						Color colour = new Color(60, 179, 113);
						courseHomePage.setActiveButton(text, colour);
						currentCourse.setActive(true);
					} else // deactivates the course
					{
						String text = "Course Inactive";
						Color colour = new Color(250, 128, 114);
						courseHomePage.setActiveButton(text, colour);
						currentCourse.setActive(false);
					}
					pageNavigator.getClient().communicateWithServer(currentCourse, "ChangeActiveState");
				}
			});
		}
		courseHomePage.setupSendEmail(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseHomePage.dispose();
				createEmailPage();
			}

		});
	}
	/**
	 * adds button listeners for the email page	
	 */
	private void addEmailPageButtonListeners()
	{
		emailPage.setupSendButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String password = JOptionPane.showInputDialog("Please input your password for your email");
				if(password != null)
				{
					Email email = new Email(emailPage.getSubject(), emailPage.getMessage());
					email.setPassword(password);
					boolean state = (boolean)pageNavigator.getClient().communicateWithServer(currentCourse, "SendEmail", email);
					if(state == true)
					{
						emailPage.showSuccess("Successfully sent email");
					}
					else
						emailPage.showError("Could not send email.");
				}
			}
			
		});
		emailPage.setupCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1)
			{
				int result = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to go back to the course home page?", "Go Back to Course Home Page", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					emailPage.dispose();
					createCourseHomePage();
				}
			}
		});
	}
	/**
	 * adds button listeners for assignment page
	 */
	private void addAssignmentButtonListeners()
	{
		if(pageNavigator.getIsProfessor()==true)
		{
			initUploadAssignmentButton();
			initDeleteAssignmentButton();
			initChangeStateButton();
		}
		else {
			initDownloadAssignmentButton();
		}
	}
	/**
	 * adds button listeners for enrollment page 
	 */
	private void addEnrollmentButtonListeners()
	{
		initSearchEnrollmentButton();
		if(pageNavigator.getIsProfessor()==true)
		{
			initEnrollButton();
			initUnenrollButton();
		}
	}
	/**
	 * Adds button listeners for submission page
	 */
	private void addSubmissionButtonListeners() {
		if (pageNavigator.getIsProfessor() == false) {
			initUploadSubmissionButton();
		} else {
			initAssessSubmissionButton();
			initDownloadSubmissionButton();
		}
	}
	/**
	 * initializes the download assignment button on the assignment page
	 */
	private void initDownloadAssignmentButton()
	{
		assignmentPage.setupDownloadButton(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JList<Assignment> assignmentList = assignmentPage.getList();
				if(assignmentList.getSelectedIndex() != -1)
				{
					Assignment currentlySelected = assignmentList.getSelectedValue();
					byte[] fileInBytes =(byte [])pageNavigator.getClient().communicateWithServer(currentlySelected, "DownloadAssignment");
					writeToSystem(currentlySelected, fileInBytes);
				}
				else 
				{
					assignmentPage.showError("Please select an assignment to download");
				}
					
			}
			
		});
	}
	/**
	 * initializes the search enrollment button on the enrollment page
	 */
	private void initSearchEnrollmentButton()
	{
		enrollmentPage.setupSearch(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> studentEnrollment =(ArrayList<Student>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetEnrollmentList");
				ArrayList<Student> searched = new ArrayList<Student>();
				char selectedSearch = enrollmentPage.selectedRadioButton();
				if (selectedSearch == 'I') {
					for (int i = 0; i < studentEnrollment.size(); i++) {
						if (String.valueOf(studentEnrollment.get(i).getId()).contains(enrollmentPage.getSearchField())) {
							searched.add(studentEnrollment.get(i));
						}
					}
					enrollmentPage.setEnrollList(searched);
				} 
				else if (selectedSearch == 'L') 
				{
					for (int i = 0; i < studentEnrollment.size(); i++) {
						if (studentEnrollment.get(i).getLastName().toLowerCase().contains(enrollmentPage.getSearchField().toLowerCase())) {
							searched.add(studentEnrollment.get(i));
						}
					}
					enrollmentPage.setEnrollList(searched);
				} 
				else {
					enrollmentPage.showError("Please select either ID or Last Name.");
				}
			}
		});
	}
	/**
	 * initializes the enrollment buttons for the enrollment page
	 */
	private void initEnrollButton()
	{
		enrollmentPage.setupEnrollButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (enrollmentPage.getId().length() != 0) {
						StudentEnrollment enrollStudent = new StudentEnrollment(Integer.parseInt(enrollmentPage.getId()), currentCourse.getId(), true);
						boolean enrolled = (boolean) pageNavigator.getClient().communicateWithServer(enrollStudent);
						if (enrolled == true)
						{
							enrollmentPage.setEnrollList((ArrayList<Student>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetEnrollmentList"));
							enrollmentPage.showSuccess("Enrollment successful.");
						}
						else {
							enrollmentPage.showError("Student does not exist or ID already taken.");
						}
					}
					else 
					{
						enrollmentPage.showError("Please fill out id field");
					}
				}
				catch(NumberFormatException t)
				{
					enrollmentPage.showError("Not a valid ID number");
				}
			}
		});
	}
	/**
	 * initializes the unenroll button on the enrollment page
	 */
	private void initUnenrollButton()
	{
		enrollmentPage.setupUnenrollButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JList<Student> list = enrollmentPage.getList();
				if(list.getSelectedIndex() != -1) {
					StudentEnrollment unenrollStudent = new StudentEnrollment(list.getSelectedValue().getId(), currentCourse.getId(), false);
					boolean unenrolled = (boolean)pageNavigator.getClient().communicateWithServer(unenrollStudent);
					if (unenrolled = true) {
						enrollmentPage.setEnrollList((ArrayList<Student>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetEnrollmentList"));
						enrollmentPage.showSuccess("Sucessfully unenrolled student");
					} else {
						enrollmentPage.showError("Unable to enroll student");
					}
				}
				else {
					enrollmentPage.showError("Please select a student to unenroll.");
				}
			}
		});
	}
	/**
	 * initializes the upload assignment button on the assignment page
	 */
	private void initUploadAssignmentButton()
	{
		assignmentPage.setupUploadButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser("AssignmentFile");
				assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
			}
		});
		
	}
	/**
	 * initializes the delete assignment button on the assignment page
	 */
	private void initDeleteAssignmentButton()
	{
		assignmentPage.setupDeleteButton(new ActionListener () {
			public void actionPerformed(ActionEvent e)
			{
				JList<Assignment> list = assignmentPage.getList();
				if(list.getSelectedIndex() != -1) {
					pageNavigator.getClient().communicateWithServer(list.getSelectedValue(), "DeleteAssignment");
					assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
				}
				else
					assignmentPage.showError("Please click on an assignment to delete.");
			}
		});
	}
	/**
	 * initializes the change active state button on the assignment page
	 */
	private void initChangeStateButton()
	{
		assignmentPage.setupChangeActionButton(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JList<Assignment> list = assignmentPage.getList();
				if(list.getSelectedIndex() != -1) {
					list.getSelectedValue().setActiveToOpposite();
					pageNavigator.getClient().communicateWithServer(list.getSelectedValue(), "ChangeActiveState");
					assignmentPage.setAssignmentList((ArrayList<Assignment>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
				}
				else
					assignmentPage.showError("Please click on an assignment to change state.");
			}
		});
	}
	/**
	 * adds submission home page list listener
	 */
	private void addSubmissionHomeListListener() {
		submissionHomePage.setupListListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (submissionHomePage.getList().getSelectedIndex() == -1) {
						return;
					}
					Assignment assignment = submissionHomePage.getList().getSelectedValue();
					submissionHomePage.dispose();
					createSubmissionPage(assignment);
				}
			}
		});
	}
	/**
	 * initializes the download submission button on the submission page
	 */
	private void initDownloadSubmissionButton() {
		submissionPage.setupDownloadButton(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JList<Submission> submissionList = submissionPage.getList();
				if(submissionList.getSelectedIndex() != -1)
				{
					Submission currentlySelected = submissionList.getSelectedValue();
					byte[] fileInBytes =(byte [])pageNavigator.getClient().communicateWithServer(currentlySelected, "DownloadSubmission");
					writeToSystem(currentlySelected, fileInBytes);
				}
				else 
				{
					assignmentPage.showError("Please select an assignment to download");
				}
					
			}
			
		});
	}
	/**
	 * initializes the upload submission button on the submission page
	 */
	private void initUploadSubmissionButton() {
		submissionPage.setupUploadButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser("SubmissionFile");
				Assignment a = submissionPage.getAssignment();
				submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList"));
			}
		});
	}
	/**
	 * initializes the assess submission button for an assignment on submission page
	 */
	private void initAssessSubmissionButton() {
		submissionPage.setupAssessButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (submissionPage.getList().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an assignment", "Invalid Selection",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					String comments = JOptionPane.showInputDialog(null, "Comments:", "Comments", JOptionPane.PLAIN_MESSAGE);
					if(comments == null)
						return;
					int grade = -1;
					while (true) {
						String gradeString = JOptionPane.showInputDialog(null, "Grade:", "Grade", JOptionPane.PLAIN_MESSAGE);
						if(gradeString == null)
							return;
						grade = Integer.parseInt(gradeString);
						if (grade < 0 || grade > 100) {
							JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						} else {
							break;
						}
					}
					Submission temp = submissionPage.getList().getSelectedValue();
					Assignment a = submissionPage.getAssignment();
					temp.setComments(comments);
					temp.setGrade(grade);
					pageNavigator.getClient().communicateWithServer(temp, "UpdateSubmission", a);
					submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList"));
				} catch (Exception ex) {
					submissionPage.showError("Please Enter a Number for Grade");
				}
			}
		});
	}
	/**
	 * opens the file browser to select a file to upload
	 * @param specifier - the type of file to upload 
	 */
	private void openFileBrowser(String specifier) {
		JFileChooser fileBrowser = new JFileChooser();
		if (fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileBrowser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			if (specifier.equalsIgnoreCase("AssignmentFile")) {
				String assignmentTitle = assignmentPage.getAssignmentTitle();
				String assignmentDueDate = assignmentPage.getAssignmentDueDate();
				if (assignmentTitle.length() == 0 || assignmentDueDate.length() == 0) {
					assignmentPage.showError("Please fill in all data fields.");
				} else {
					Assignment assignment = new Assignment(currentCourse.getId(), assignmentTitle, path, false, assignmentDueDate);
					byte [] fileInBytes = turnFileIntoBytes(selectedFile);
					pageNavigator.getClient().communicateWithServer(assignment, "AddAssignment", fileInBytes);
				}
			} else if (specifier.equalsIgnoreCase("SubmissionFile")) {
				String submissionTitle = submissionPage.getSubmissionTitle();
				if (submissionTitle.length() == 0) {
					submissionPage.showError("Please fill in all data fields.");
				} else {
					Assignment a = submissionPage.getAssignment();
					Submission submission = new Submission(currentCourse.getId(), a.getID(), pageNavigator.user.getId(), path, submissionTitle);
					byte [] fileInBytes = turnFileIntoBytes(selectedFile);
					pageNavigator.getClient().communicateWithServer(submission, "AddSubmission", fileInBytes, a);
				}
			}
		}
	}
	/**
	 * turns a file into bytes
	 * @param selectedFile the file to be turned into bytes
	 * @return - the file in bytes
	 */
	private byte [] turnFileIntoBytes (File selectedFile)
	{
		long length = selectedFile.length();
		byte[] content = new byte[(int) length]; // Converting Long to Int
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bos = new BufferedInputStream(fis);
			bos.read(content, 0, (int)length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		return content;
	}
	/**
	 * writes a assignment file into the system
	 * @param a - the assignment to be written to the client's computer
	 * @param fileInBytes - the file to be writte in bytes
	 */
	private void writeToSystem (Assignment a, byte [] fileInBytes)
	{
		try {
			int j = 0;
			while (true) {
				String extension = "";
				int i = a.getPath().lastIndexOf('.');
				if (i > 0) {
					extension = a.getPath().substring(i);
				}
				extension = a.getTitle().replaceAll(" ", "_") +"_"+ j + extension;
				Path path = Paths.get(System.getProperty("user.dir"), extension);
				File newFile = new File(path.toString());
				if (!newFile.exists()) {
					newFile.createNewFile();
					FileOutputStream writer = new FileOutputStream(newFile);
					BufferedOutputStream bos = new BufferedOutputStream(writer);
					bos.write(fileInBytes);
					bos.close();
					break;
				}
				j++;
			}
			assignmentPage.showSuccess("Successfully downloaded item");
		}  catch (Exception e) {
			assignmentPage.showError("Could not download item");
		}
	}
	/**
	 * writes submission file onto client computer
	 * @param s - submission to be written to the client's computer
	 * @param fileInBytes - the file to be written in bytes
	 */
	private void writeToSystem (Submission s, byte [] fileInBytes)
	{
		try {
			int j = 0;
			while (true) {
				String extension = "";
				int i = s.getPath().lastIndexOf('.');
				if (i > 0) {
					extension = s.getPath().substring(i);
				}
				extension = s.getTitle().replaceAll(" ", "_") +"_"+ j + extension;
				Path path = Paths.get(System.getProperty("user.dir"), extension);
				File newFile = new File(path.toString());
				if (!newFile.exists()) {
					newFile.createNewFile();
					FileOutputStream writer = new FileOutputStream(newFile);
					BufferedOutputStream bos = new BufferedOutputStream(writer);
					bos.write(fileInBytes);
					bos.close();
					break;
				}
				j++;
			}
			submissionPage.showSuccess("Successfully downloaded item");
		}  catch (Exception e) {
			submissionPage.showError("Could not download item");
		}
	}

}

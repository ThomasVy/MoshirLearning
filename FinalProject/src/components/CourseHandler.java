package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JList;


import frontEnd.ProfessorGUI;
import pages.*;
import sharedElements.*;

public class CourseHandler {
	private Course currentCourse;
	private PageNavigator pageNavigator;
	
	private EnrollmentPage enrollmentPage;
	private CoursePage courseHomePage;
	private GradePage gradePage;
	private SubmissionPage submissionPage;
	private AssignmentPage assignmentPage;
	
	private ArrayList<Course> courses;
	public CourseHandler (PageNavigator pageNavigator, Course course)
	{
		this.pageNavigator = pageNavigator;
		this.currentCourse =course;
		createCourseHomePage();
	}
	private void createCourseHomePage ()
	{
		courses = pageNavigator.getCourses();
		courseHomePage = new CoursePage(courses, pageNavigator.getIsProfessor(), currentCourse); //start off with home page at first
		pageNavigator.addComboBoxListener(courseHomePage);
		pageNavigator.addHomeButtonListener(courseHomePage);
		addPageListeners(courseHomePage);
		addCourseHomePageListener();
		courseHomePage.setVisible(true);
	}
	private void createAssignmentPage ()
	{
		courses = pageNavigator.getCourses();
		assignmentPage = new AssignmentPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
		pageNavigator.addComboBoxListener(assignmentPage);
		pageNavigator.addHomeButtonListener(assignmentPage);
		addPageListeners(assignmentPage);
		addAssignmentButtonListeners();
		assignmentPage.setVisible(true);
	}
	private void createSubmissionPage ()
	{
		courses = pageNavigator.getCourses();
		submissionPage = new SubmissionPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		pageNavigator.addComboBoxListener(submissionPage);
		pageNavigator.addHomeButtonListener(submissionPage);
		addPageListeners(submissionPage);
		addSubmissionButtonListeners();
		submissionPage.setVisible(true);
	}
	private void createEnrollmentPage ()
	{
		courses = pageNavigator.getCourses();
		enrollmentPage = new EnrollmentPage(courses, pageNavigator.getIsProfessor(), currentCourse);
		enrollmentPage.setEnrollList((ArrayList<Student>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetEnrollmentList"));
		pageNavigator.addComboBoxListener(enrollmentPage);
		pageNavigator.addHomeButtonListener(enrollmentPage);
		addPageListeners(enrollmentPage);
		addEnrollmentButtonListeners();
		enrollmentPage.setVisible(true);
	}
	public void createGradesPage()
	{
		courses = pageNavigator.getCourses();
		gradePage = new GradePage(courses, pageNavigator.getIsProfessor(), currentCourse);
		pageNavigator.addComboBoxListener(gradePage);
		pageNavigator.addHomeButtonListener(gradePage);
		addPageListeners(gradePage);
		addGradeButtonListeners();
		gradePage.setVisible(true);	
	}
	private void addPageListeners(PagesInACourse page)
	{
		page.addAssignmentButtonListener(new ActionListener() {
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
				createSubmissionPage();
			}
		});
		page.addEnrollmentButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page.dispose();
				createEnrollmentPage();
			}
		});
	}
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
	}
	private void addAssignmentButtonListeners()
	{
		if(pageNavigator.getIsProfessor()==true)
		{
			initUploadAssignmentButton();
			initDeleteAssignmentButton();
			initChangeStateButton();
		}
	}
	private void addSubmissionButtonListeners()
	{
		
	}
	private void addGradeButtonListeners()
	{
		
	}
	private void addEnrollmentButtonListeners()
	{
		initSearchEnrollmentButton();
		if(pageNavigator.getIsProfessor()==true)
		{
			initEnrollButton();
			initUnenrollButton();
		}
	}
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
	private void initEnrollButton()
	{
		enrollmentPage.setupEnrollButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (enrollmentPage.getId().length() != 0) {
						int newId = randomIntGenerator();
						StudentEnrollment enrollStudent = new StudentEnrollment(newId, Integer.parseInt(enrollmentPage.getId()), currentCourse.getId(), true);
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
	private void initUnenrollButton()
	{
		enrollmentPage.setupUnenrollButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JList<Student> list = enrollmentPage.getList();
				if(list.getSelectedIndex() != -1) {
					StudentEnrollment unenrollStudent = new StudentEnrollment(-1, list.getSelectedValue().getId(), currentCourse.getId(), false);
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
	private void initUploadAssignmentButton()
	{
		assignmentPage.setupUploadButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser();
				assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
			}
		});
		
	}
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
	private void initChangeStateButton()
	{
		assignmentPage.setupChangeActionButton(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JList<Assignment> list = assignmentPage.getList();
				if(list.getSelectedIndex() != -1) {
					list.getSelectedValue().setActiveToOpposite();
					pageNavigator.getClient().communicateWithServer(list.getSelectedValue(), "ChangeActiveState");
					assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList"));
				}
				else
					assignmentPage.showError("Please click on an assignment to change state.");
			}
		});
	}
	private void openFileBrowser() {
		JFileChooser fileBrowser = new JFileChooser();
		if (fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileBrowser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			int newId = randomIntGenerator();
			String assignmentTitle = assignmentPage.getAssignmentTitle();
			String assignmentDueDate = assignmentPage.getAssignmentDueDate();
			if (assignmentTitle.length() == 0 || assignmentDueDate.length() == 0) {
				assignmentPage.showError("Please fill in all data fields.");
			} else {
				Assignment assignment = new Assignment(newId, currentCourse.getId(), assignmentTitle,path, false, assignmentDueDate);
				byte [] fileInBytes = turnFileIntoBytes(selectedFile);
				pageNavigator.getClient().communicateWithServer(assignment, "AddAssignment", fileInBytes);
			}
		}
	}
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
	public int randomIntGenerator ()
	{
		Random random = new Random();
		return 10000000 + random.nextInt(90000000);
	}

}

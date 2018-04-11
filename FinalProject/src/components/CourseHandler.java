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

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pages.AssignmentPage;
import pages.CoursePage;
import pages.EnrollmentPage;
import pages.GradePage;
import pages.PagesInACourse;
import pages.SubmissionHomePage;
import pages.SubmissionPage;
import sharedElements.Assignment;
import sharedElements.Course;
import sharedElements.Grade;
import sharedElements.Student;
import sharedElements.StudentEnrollment;
import sharedElements.Submission;

public class CourseHandler {
	private Course currentCourse;
	private PageNavigator pageNavigator;
	
	private EnrollmentPage enrollmentPage;
	private CoursePage courseHomePage;
	private GradePage gradePage;
	private SubmissionHomePage submissionHomePage;
	private SubmissionPage submissionPage;
	private AssignmentPage assignmentPage;
	
	private ArrayList<Course> courses;
	public CourseHandler (PageNavigator pageNavigator, Course course)
	{
		this.pageNavigator = pageNavigator;
		this.currentCourse = course;
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
		assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList", pageNavigator.user));
		pageNavigator.addComboBoxListener(assignmentPage);
		pageNavigator.addHomeButtonListener(assignmentPage);
		addPageListeners(assignmentPage);
		addAssignmentButtonListeners();
		assignmentPage.setVisible(true);
	}

	private void createSubmissionHomePage() {
		courses = pageNavigator.getCourses();
		submissionHomePage = new SubmissionHomePage(courses, pageNavigator.getIsProfessor(), currentCourse);
		submissionHomePage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList", pageNavigator.user));
		pageNavigator.addComboBoxListener(submissionHomePage);
		pageNavigator.addHomeButtonListener(submissionHomePage);
		addPageListeners(submissionHomePage);
		addSubmissionHomeListListener();
		submissionHomePage.setVisible(true);
	}

	private void createSubmissionPage(Assignment a) {
		courses = pageNavigator.getCourses();
		submissionPage = new SubmissionPage(courses, pageNavigator.getIsProfessor(), currentCourse, a);
		submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList", pageNavigator.user));
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
		gradePage.setGradeList((ArrayList<Grade>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetGradeList", pageNavigator.user));
		pageNavigator.addComboBoxListener(gradePage);
		pageNavigator.addHomeButtonListener(gradePage);
		addPageListeners(gradePage);
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

	private void addSubmissionButtonListeners() {
		if (pageNavigator.getIsProfessor() == false) {
			initUploadSubmissionButton();
			initDeleteSubmissionButton();
		} else {
			initAssessSubmissionButton();
		}
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
	private void initUploadAssignmentButton()
	{
		assignmentPage.setupUploadButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser("AssignmentFile");
				assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList", pageNavigator.user));
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
					assignmentPage.setAssignmentList((ArrayList<Assignment>)pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList", pageNavigator.user));
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
					assignmentPage.setAssignmentList((ArrayList<Assignment>) pageNavigator.getClient().communicateWithServer(currentCourse, "GetAssignmentList", pageNavigator.user));
				}
				else
					assignmentPage.showError("Please click on an assignment to change state.");
			}
		});
	}

	private void addSubmissionHomeListListener() {
		submissionHomePage.setupListListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (submissionHomePage.getList().getSelectedIndex() == -1) {
						return;
					}
					Assignment assignment = submissionHomePage.getModel().get(submissionHomePage.getList().getSelectedIndex());
					submissionHomePage.dispose();
					createSubmissionPage(assignment);
				}
			}
		});
	}

	private void initUploadSubmissionButton() {
		submissionPage.setupUploadButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileBrowser("SubmissionFile");
				Assignment a = submissionHomePage.getModel().get(submissionHomePage.getList().getSelectedIndex());
				submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList", pageNavigator.user));
			}
		});
	}

	private void initDeleteSubmissionButton() {
		submissionPage.setupDeleteButton(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JList<Submission> list = submissionPage.getList();
				if(list.getSelectedIndex() != -1) {
					pageNavigator.getClient().communicateWithServer(list.getSelectedValue(), "DeleteSubmission");
					Assignment a = submissionHomePage.getModel().get(submissionHomePage.getList().getSelectedIndex());
					submissionPage.setSubmissionList((ArrayList<Submission>) pageNavigator.getClient().communicateWithServer(a, "GetSubmissionList", pageNavigator.user));
				}
				else
					submissionPage.showError("Please click on a submission to delete.");
			}
		});
	}

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
					int grade = -1;
					while (true) {
						grade = Integer.parseInt(JOptionPane.showInputDialog(null, "Grade:", "Grade", JOptionPane.PLAIN_MESSAGE));
						if (grade < 0 || grade > 100) {
							JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
						} else {
							break;
						}
					}
					Submission temp = submissionPage.getList().getSelectedValue();
					Assignment a = submissionHomePage.getModel().get(submissionHomePage.getList().getSelectedIndex());
					temp.setComments(comments);
					temp.setGrade(grade);
					pageNavigator.getClient().communicateWithServer(temp, "UpdateSubmission", a);
					System.out.println("HELLO");
				} catch (Exception ex) {
					return;
				}
			}
		});
	}

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
					Assignment a = submissionHomePage.getModel().get(submissionHomePage.getList().getSelectedIndex());
					Submission submission = new Submission(currentCourse.getId(), a.getID(), pageNavigator.user.getId(), path, submissionTitle, 0, "N/A", "N/A");
					byte [] fileInBytes = turnFileIntoBytes(selectedFile);
					pageNavigator.getClient().communicateWithServer(submission, "AddSubmission", fileInBytes, a);
				}
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

}

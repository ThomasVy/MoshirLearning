package backEnd;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import sharedElements.*;

/**
 * Provides the fields and methods required to create a DatabaseHelper object.
 * 
 * @author Rainer Lim & Thomas Vy
 * @version 1.0
 * @since April 5, 2018
 *
 */
public class DatabaseHelper implements ConnectionConstants {

	private Connection connection; // The connection
	private Statement statement; // The statement
	private ResultSet resultSet; // The result set

	/**
	 * Constructs a DatabaseHelper.
	 */
	public DatabaseHelper() {
		System.out.println("Please enter your username for MySQL: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Please enter your password for MySQL: ");
		String password = scanner.nextLine();
		scanner.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionInfo, username, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the database.
	 */
	public void createDB() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE " + databaseName);
			System.out.println("Created database " + databaseName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the User table.
	 */
	public void createUserTable() {
		String sql = "CREATE TABLE " + "UserTable" + " (id INT(8) NOT NULL,"
												   + " username VARCHAR(20) NOT NULL,"
												   + " password VARCHAR(20) NOT NULL,"
												   + " email VARCHAR(50) NOT NULL,"
												   + " firstname VARCHAR(30) NOT NULL,"
												   + " lastname VARCHAR(30) NOT NULL,"
												   + " type CHAR(1) NOT NULL,"
												   + " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "UserTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the Course table.
	 */
	public void createCourseTable() {
		String sql = "CREATE TABLE " + "CourseTable" + " (id INT(8) NOT NULL,"
													 + " prof_id INT(8) NOT NULL,"
													 + " name VARCHAR(50) NOT NULL,"
													 + " active BIT(1) NOT NULL,"
													 + " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "CourseTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the StudentEnrollment table.
	 */
	public void createEnrollmentTable() {
		String sql = "CREATE TABLE " + "EnrollmentTable" + " (id INT(8) NOT NULL,"
														 + " student_id INT(8) NOT NULL,"
														 + " course_id INT(8) NOT NULL,"
														 + " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "EnrollmentTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the Assignment table.
	 */
	public void createAssignmentTable() {
		String sql = "CREATE TABLE " + "AssignmentTable" + " (id INT(8) NOT NULL,"
														 + " course_id INT(8) NOT NULL,"
														 + " title VARCHAR(50) NOT NULL,"
														 + " path VARCHAR(100) NOT NULL,"
														 + " active BIT(1) NOT NULL,"
														 + " due_date CHAR(16) NOT NULL,"
														 + " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "AssignmentTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the Submission table.
	 */
	public void createSubmissionTable() {
		String sql = "CREATE TABLE " + "SubmissionTable" + " (id INT(8) NOT NULL,"
														 + " course_id INT(8) NOT NULL,"
														 + " assign_id INT(8) NOT NULL,"
														 + " student_id INT(8) NOT NULL,"
														 + " path VARCHAR(100) NOT NULL,"
														 + " title VARCHAR(50) NOT NULL,"
														 + " submission_grade INT(3) NOT NULL,"
														 + " comments VARCHAR(140) NOT NULL,"
														 + " timestamp CHAR(16) NOT NULL,"
														 + " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "SubmissionTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the Grade table.
	 */
	public void createGradeTable() {
		String sql = "CREATE TABLE " + "GradeTable" + " (id INT(8) NOT NULL,"
													+ " assign_id INT(8) NOT NULL,"
													+ " student_id INT(8) NOT NULL,"
													+ " course_id INT(8) NOT NULL,"
													+ " assignment_grade INT(3) NOT NULL,"
													+ " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "GradeTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes the specified table.
	 * @param tableName - the table's name
	 */
	public void removeTable(String tableName) {
		String sql = "DROP TABLE " + tableName;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Removed table " + tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates all tables.
	 */
	public void createAllTables() {
		createUserTable();
		createCourseTable();
		createEnrollmentTable();
		createAssignmentTable();
		createSubmissionTable();
		createGradeTable();
	}

	/**
	 * Removes all tables.
	 */
	public void removeAllTables() {
		String[] tables = { "UserTable", "CourseTable", "EnrollmentTable", "AssignmentTable", "SubmissionTable",
				"GradeTable" };
		for (int i = 0; i < tables.length; i++) {
			removeTable(tables[i]);
		}
	}

	/**
	 * Verifies that the user logging in exists in the database.
	 * @param username - the user's username
	 * @param password - the user's password
	 * @return - the user
	 */
	public User verifyUser(String username, String password) {
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM " + "UserTable" + " WHERE username = " + "'" + username + "'" + " and password = " + "'" + password + "'";
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				if (resultSet.getString("type").charAt(0) == 'S') {
					Student student = new Student(resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
					return student;
				} else if (resultSet.getString("type").charAt(0) == 'P') {
					Professor professor = new Professor(resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
					return professor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the courses from the database.
	 * @param user - the user
	 * @return - the user's courses
	 */
	public ArrayList<Course> getCourses(User user) {
		int id = user.getId();
		String typeOfUser = user.getClass().getSimpleName();
		ArrayList<Course> courses = new ArrayList<Course>();
		if(typeOfUser.equals("Student"))
		{
			courses= selectStudentCoursesFromDB(id);
		}
		else if(typeOfUser.equals("Professor")){
			courses = selectProfCoursesFromDB(id);
		}
		return courses;
	}

	/**
	 * A helper method used by the getCourses method.
	 * @param id - the prof's id
	 * @param table - the table's name
	 * @return - the prof's courses
	 */
	private ArrayList<Course> selectProfCoursesFromDB(int prof_id) {
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM CourseTable WHERE prof_id = " + "'" + prof_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
					Course temp = new Course(resultSet.getInt("prof_id"), resultSet.getString("name"),
							resultSet.getInt("active") == 1);
					temp.setId(resultSet.getInt("id"));
					courses.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	private ArrayList<Course> selectStudentCoursesFromDB(int student_id)
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM EnrollmentTable WHERE student_id = " + "'" + student_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Statement secondStatement = connection.createStatement();
				sql = "SELECT * FROM CourseTable WHERE id = " + "'" + resultSet.getInt("course_id") + "'";
				ResultSet secondResultSet = secondStatement.executeQuery(sql);
				while (secondResultSet.next()) {
					if(secondResultSet.getInt("active") == 1)
					{
						Course temp = new Course(secondResultSet.getInt("prof_id"), secondResultSet.getString("name"), secondResultSet.getInt("active") == 1);
						temp.setId(secondResultSet.getInt("id"));
						courses.add(temp);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	/**
	 * Adds a course into the database.
	 * @param id - the course id
	 * @param prof_id - the prof's id
	 * @param name - the course name
	 * @param active - the course activity
	 * @return - true if course is added, false otherwise
	 */
	public boolean addCourse(int prof_id, String name, boolean active) {
		boolean result = false;
		int id = 0;
		while (true) {
			try {
				statement = connection.createStatement();
				String sql = "SELECT * FROM " + "CourseTable" + " WHERE name = " + "'" + name + "'";
				resultSet = statement.executeQuery(sql);
				if (!resultSet.next()) {
					String bit = "";
					if (active == true) {
						bit = "b'1'";
					} else {
						bit = "b'0'";
					}
					sql = "INSERT INTO " + "CourseTable" + " VALUES (" + id + ", " + prof_id + ", '" + name + "', " + bit
							+ ");";
					statement.executeUpdate(sql);
					result = true;
				}
				break;
			} catch (SQLIntegrityConstraintViolationException e) {
				id++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Changes the state of a course.
	 * @param courseToChange - the course to be changed
	 */
	public void changeStateOfCourse(Course courseToChange) {
		try {
			statement = connection.createStatement();
			boolean active = courseToChange.getActive();
			String bit = "";
			if (active == true) {
				bit = "b'1'";
			} else {
				bit = "b'0'";
			}
			String sql = "UPDATE CourseTable SET active = " + bit + " WHERE id = " + "'" + courseToChange.getId() + "'";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the students enrolled in a course from the database.
	 * @param courseFromClient - the course
	 * @return - the array list of students
	 */
	public ArrayList<Student> getEnrollmentList(Course courseFromClient) {
		ArrayList<Student> listOfStudent = new ArrayList<Student>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM EnrollmentTable WHERE course_id = " + courseFromClient.getId();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				listOfStudent.add(getStudent(resultSet.getInt("student_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfStudent;
	}

	/**
	 * A helper method used by the getEnrollmentList method.
	 * @param id - the student's id
	 * @return - the student
	 */
	private Student getStudent(int id) {
		Student student = null;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM UserTable WHERE id = " + id;
			ResultSet temp = statement.executeQuery(sql);
			if (temp.next())
				student = new Student(id, temp.getString("firstname"), temp.getString("lastname"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	/**
	 * Changes the enrollment of a student in a course.
	 * @param enrollment - the student enrollment to be changed
	 * @return - true if change is successful, false otherwise
	 */
	public boolean changeEnrollment(StudentEnrollment enrollment) {
		boolean enrollmentStatus = false;
		boolean enroll = enrollment.getEnrolling();
		if(getStudent(enrollment.getStudentID()) == null) //Student does not exist
		{
			return false;
		}
		if (enroll == true) // Enroll the student
		{
			int id = 0;
			while (true) {
				try {
					statement = connection.createStatement();
					String sql = "SELECT * FROM " + "EnrollmentTable" + " WHERE student_id = " + +enrollment.getStudentID() + " and course_id = " + enrollment.getCourseID();
					resultSet = statement.executeQuery(sql);
					if (!resultSet.next()) {
						sql = "INSERT INTO " + "EnrollmentTable" + " VALUES (" + id + ", " + enrollment.getStudentID() + ", " + enrollment.getCourseID() + ");";
						statement.executeUpdate(sql);
						enrollmentStatus = true;
					}
					break;
				} catch (SQLIntegrityConstraintViolationException e) {
					id++;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else { // Unenroll student
			try {
				statement = connection.createStatement();
				String sql = "SELECT * FROM " + "EnrollmentTable" + " WHERE student_id = " + +enrollment.getStudentID() + " and course_id = " + enrollment.getCourseID();
				resultSet = statement.executeQuery(sql);
				if (resultSet.next()) {
					statement = connection.createStatement();
					sql = "DELETE FROM EnrollmentTable WHERE student_id = " + enrollment.getStudentID();
					statement.executeUpdate(sql);
					enrollmentStatus = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return enrollmentStatus;
	}

	/**
	 * Gets the assignments from the database.
	 * @param selectedCourse - the course
	 * @return - the array list of assignments
	 */
	public ArrayList<Assignment> getAssignmentList(Course selectedCourse, User user) {
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM AssignmentTable WHERE course_id = " + selectedCourse.getId();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String path = resultSet.getString("path").replaceAll(";", "\\\\");
				Assignment fetchedAssignment = new Assignment(resultSet.getInt("course_id"),
						resultSet.getString("title"), path, resultSet.getInt("active") == 1,
						resultSet.getString("due_date"));
				fetchedAssignment.setID(resultSet.getInt("id"));
				assignments.add(fetchedAssignment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user.getClass().getSimpleName().equalsIgnoreCase("Student")) {
			assignments = removeInactiveAssignments(assignments);
		}
		return assignments;
	}

	private ArrayList<Assignment> removeInactiveAssignments(ArrayList<Assignment> a) {
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getActive() == true) {
				assignments.add(a.get(i));
			}
		}
		return assignments;
	}

	/**
	 * Changes the state of an assignment.
	 * @param currentAssignment - the assignment to be changed
	 */
	public void changeStateOfAssignment(Assignment currentAssignment) {
		try {
			statement = connection.createStatement();
			boolean active = currentAssignment.getActive();
			String bit = "";
			if (active == true) {
				bit = "b'1'";
			} else {
				bit = "b'0'";
			}
			String sql = "UPDATE AssignmentTable SET active = " + bit + " WHERE id = " + currentAssignment.getID();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds an assignment to the database.
	 * @param currentAssignment - the assignment to be added
	 * @return - true if addition is successful, false otherwise
	 */
	public boolean addAssignment(Assignment currentAssignment) {
		boolean result = false;
		int id = 0;
		while (true) {
	 		try {
				statement = connection.createStatement();
				String sql = "SELECT * FROM " + "AssignmentTable" + " WHERE course_id = " + currentAssignment.getCourseID()
						+ " and title = '" + currentAssignment.getTitle() + "'";
				resultSet = statement.executeQuery(sql);
				if (!resultSet.next()) {
					String path = currentAssignment.getPath().replaceAll("\\\\", ";");
					String bit = "";
					if (currentAssignment.getActive() == true) {
						bit = "b'1'";
					} else {
						bit = "b'0'";
					}
					sql = "INSERT INTO " + "AssignmentTable" + " VALUES (" + id + ", "
							+ currentAssignment.getCourseID() + ", '" + currentAssignment.getTitle() + "', '"
							+ path + "', " + bit + ", '" + currentAssignment.getDueDate() + "');";
					statement.executeUpdate(sql);
					result = true;
				}
				break;
			} catch (SQLIntegrityConstraintViolationException e) {
				id++;
			} catch (SQLException e) {
				return false;
			}
		}
		return result;
	}

	/**
	 * Deletes an assignment from the database.
	 * @param currentAssignment - the assignment to be deleted
	 * @return - true if deletion is successful, false otherwise
	 */

	public boolean deleteAssignment(Assignment currentAssignment) {
		boolean result = false;
		try {
			statement = connection.createStatement();
			String delete = "DELETE FROM AssignmentTable WHERE course_id = " + currentAssignment.getCourseID()
					+ " and id = " + currentAssignment.getID();
			statement.executeUpdate(delete);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Assignment getAssignment (int assignment_id)
	{
		Assignment assignment = null;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM AssignmentTable WHERE id = " + assignment_id;
			ResultSet temp = statement.executeQuery(sql);
			if (temp.next())
			{
				String path = resultSet.getString("path").replaceAll(";", "\\\\");
				assignment = new Assignment(temp.getInt("course_id"),
											temp.getString("title"),
											temp.getString("path"),
											temp.getInt("active")==1,
											temp.getString("due_date"));
				assignment.setID(assignment_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignment;
	}
	public ArrayList<Grade> getGradeList (Course course)
	{
		ArrayList<Grade> grades = new ArrayList<Grade>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM GradeTable WHERE course_id = " + course.getId();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Student fetchedStudent = getStudent(resultSet.getInt("student_id"));
				Grade fetchedgrade = new Grade(resultSet.getInt("student_id"),
											   resultSet.getInt("assignment_grade"),
											   fetchedStudent.getFirstName()+" "+fetchedStudent.getLastName(),
											   getAssignment(resultSet.getInt("assign_id")).getTitle());

				grades.add(fetchedgrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grades;
	}
	public String getUserEmail(int id)
	{
		String email = null;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM UserTable WHERE id = " + id;
			ResultSet temp = statement.executeQuery(sql);
			if (temp.next())
				email = temp.getString("email");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}
	public ArrayList<String> getProfEmail(Course course) {
		ArrayList<String> email = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM CourseTable WHERE id = " + "'" + course.getId() + "'";
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
					email.add(getUserEmail(resultSet.getInt("prof_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}
	public ArrayList<String> getAllEmail (Course course)
	{
		ArrayList<String> emails = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM EnrollmentTable WHERE course_id = " + course.getId();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				emails.add(getUserEmail(resultSet.getInt("student_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}

	// SUBMISSION METHODS
	public ArrayList<Submission> getSubmissionList(Assignment selectedAssignment, User user) {
		ArrayList<Submission> submissions = new ArrayList<Submission>();
		try {
			statement = connection.createStatement();
			String sql = "";
			if (user.getClass().getSimpleName().equalsIgnoreCase("Professor")) {
				sql = "SELECT * FROM SubmissionTable WHERE assign_id = " + selectedAssignment.getID();
			} else {
				sql = "SELECT * FROM SubmissionTable WHERE assign_id = " + selectedAssignment.getID() + " and student_id = " + user.getId();
			}
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Submission fetchedSubmission = new Submission(resultSet.getInt("course_id"), resultSet.getInt("assign_id"), resultSet.getInt("student_id"), resultSet.getString("path"), resultSet.getString("title"), resultSet.getInt("submission_grade"), resultSet.getString("comments"), resultSet.getString("timestamp"));
				fetchedSubmission.setId(resultSet.getInt("id"));
				submissions.add(fetchedSubmission);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return submissions;
	}

	public boolean addSubmission(Submission currentSubmission, Assignment a) {
		boolean result = false;
		int id = 0;
		while (true) {
			try {
				statement = connection.createStatement();
				String sql = "SELECT * FROM " + "SubmissionTable" + " WHERE course_id = " + currentSubmission.getCourseId() + " and title = '" + currentSubmission.getTitle() + "'";
				resultSet = statement.executeQuery(sql);
				if (!resultSet.next()) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					sql = "INSERT INTO " + "SubmissionTable" + " VALUES (" + id + ", " + currentSubmission.getCourseId() + ", "+ a.getID() + ", " + currentSubmission.getStudentId() + ", '" + currentSubmission.getPath() + "', '" + currentSubmission.getTitle() + "', " + currentSubmission.getGrade() + ", '" + currentSubmission.getComments() + "', '" + sdf.format(cal.getTime()) + "');";
					statement.executeUpdate(sql);
					result = true;
				}
				break;
			} catch (SQLIntegrityConstraintViolationException e) {
				id++;
			} catch (SQLException e) {
				return false;
			}
		}
		return result;
	}

	public boolean deleteSubmission(Submission currentSubmission) {
		boolean result = false;
		try {
			statement = connection.createStatement();
			String delete = "DELETE FROM SubmissionTable WHERE course_id = " + currentSubmission.getCourseId() + " and id = " + currentSubmission.getId();
			statement.executeUpdate(delete);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Submission getSubmission(int submission_id) {
		Submission submission = null;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM SubmissionTable WHERE id = " + submission_id;
			ResultSet temp = statement.executeQuery(sql);
			if (temp.next()) {
				submission = new Submission(temp.getInt("course_id"), temp.getInt("assign_id"), temp.getInt("student_id"), temp.getString("path"), temp.getString("title"), temp.getInt("submission_grade"), temp.getString("comments"), temp.getString("timestamp"));
				submission.setId(submission_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return submission;
	}
//	/**
//	 * Sets up the database.
//	 * @param args - command-line arguments
//	 */
//	public static void main(String[] args) {
//		DatabaseHelper dbh = new DatabaseHelper();
//		dbh.createDB();
//		dbh.createAllTables();
//		dbh.removeAllTables();
//	}

}

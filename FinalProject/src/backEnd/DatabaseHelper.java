package backEnd;

import java.sql.*;

public class DatabaseHelper implements ConnectionConstants {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DatabaseHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionInfo, "root", "30017106mysql");
			System.out.println("Connected to: " + connectionInfo + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	public void createUserTable() {
		String sql = "CREATE TABLE " + "UserTable" + " (id INT(8) NOT NULL," +
													 " username VARCHAR(20) NOT NULL," +
													 " password VARCHAR(20) NOT NULL," +
													 " email VARCHAR(50) NOT NULL," +
													 " firstname VARCHAR(30) NOT NULL," +
													 " lastname VARCHAR(30) NOT NULL," +
													 " type CHAR(1) NOT NULL," +
													 " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "UserTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCourseTable() {
		String sql = "CREATE TABLE " + "CourseTable" + " (id INT(8) NOT NULL," +
													   " prof_id INT(8) NOT NULL," +
													   " name VARCHAR(50) NOT NULL," +
													   " active BIT(1) NOT NULL," +
													   " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "CourseTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createEnrollmentTable() {
		String sql = "CREATE TABLE " + "EnrollmentTable" + " (id INT(8) NOT NULL," +
				   										   " student_id INT(8) NOT NULL," +
				   										   " course_id INT(8) NOT NULL," +
				   										   " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "EnrollmentTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createAssignmentTable() {
		String sql = "CREATE TABLE " + "AssignmentTable" + " (id INT(8) NOT NULL," +
				   										   " course_id INT(8) NOT NULL," +
				   										   " title VARCHAR(50) NOT NULL," +
				   										   " path VARCHAR(100) NOT NULL," +
				   										   " active BIT(1) NOT NULL," +
				   										   " due_date CHAR(16) NOT NULL," +
				   										   " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "AssignmentTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createSubmissionTable() {
		String sql = "CREATE TABLE " + "SubmissionTable" + " (id INT(8) NOT NULL," +
				   										   " assign_id INT(8) NOT NULL," +
				   										   " student_id INT(8) NOT NULL," +
				   										   " path VARCHAR(100) NOT NULL," +
				   										   " title VARCHAR(50) NOT NULL," +
				   										   " submission_grade INT(3) NOT NULL," +
				   										   " comments VARCHAR(140) NOT NULL," +
				   										   " timestamp CHAR(16) NOT NULL," +
				   										   " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "SubmissionTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createGradeTable() {
		String sql = "CREATE TABLE " + "GradeTable" + " (id INT(8) NOT NULL," +
				   									  " assign_id INT(8) NOT NULL," +
				   									  " student_id INT(8) NOT NULL," +
				   									  " course_id INT(8) NOT NULL," +
				   									  " assignment_grade INT(3) NOT NULL," +
				   									  " PRIMARY KEY (id))";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created table " + "GradeTable");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	public void createAllTables() {
		createUserTable();
		createCourseTable();
		createEnrollmentTable();
		createAssignmentTable();
		createSubmissionTable();
		createGradeTable();
	}

	public void removeAllTables() {
		String[] tables = { "UserTable", "CourseTable", "EnrollmentTable", "AssignmentTable", "SubmissionTable", "GradeTable" };
		for (int i = 0; i < tables.length; i++) {
			removeTable(tables[i]);
		}
	}

	public static void main(String[] args) {
		DatabaseHelper dbh = new DatabaseHelper();
		// dbh.createDB();
		// dbh.createAllTables();
		// dbh.removeAllTables();
	}

}

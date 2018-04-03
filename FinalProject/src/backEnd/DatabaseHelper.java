package backEnd;

import java.sql.*;

import sharedElements.*;

public class DatabaseHelper implements ConnectionConstant {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String tableName;
	private LoginInfo loginInformation;
	
//	protected abstract void insert(Object e);
//
//	protected abstract void delete(Object e);
//
//	protected abstract void select(Object e);
//	
	protected DatabaseHelper (LoginInfo login)
	{
		try {
			loginInformation = login;
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(connectionInfo, login.getUsername(), login.getPassword());
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	public void createDB ()
	{
		try {
			statement = connection.createStatement();
			String query = "CREATE DATABASE " + databaseName;
			statement.executeUpdate(query);
			System.out.println("Created Database " + databaseName);
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	public void createUserTable()
	{
		String sql = "CREATE TABLE " + tableName + "(" +
			     "ID INT(4) NOT NULL, " +
			     "TOOLNAME VARCHAR(20) NOT NULL, " + 
			     "QUANTITY INT(4) NOT NULL, " + s
			     "PRICE DOUBLE(5,2) NOT NULL, " + 
			     "SUPPLIERID INT(4) NOT NULL, " + 
			     "PRIMARY KEY ( id ))";
		try{
		statement = jdbc_connection.prepareStatement(sql);
		statement.executeUpdate();
		System.out.println("Created Table " + tableName);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	public void createCourseTable()
	{
		
	}
	public void createEnrollmentTable()
	{
		
	}
	public void createAssignmentTable()
	{
		
	}
	public void createSubmissionTable()
	{
		
	}
	public void createGradeTable()
	{
		
	}
}
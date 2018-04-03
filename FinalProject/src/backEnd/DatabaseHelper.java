package backEnd;

import java.sql.*;

import sharedElements.LoginInfo;

public abstract class DatabaseHelper implements ConnectionConstant {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String tableName;
	private LoginInfo loginInformation;
	
	protected abstract void insert(Object e);

	protected abstract void delete(Object e);

	protected abstract void select(Object e);
	
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
}
package sharedElements;

import java.io.Serializable;

public class LoginInfo implements Serializable {
	private static final long serialVersionUID = 5803285845307421959L;
	private String username;
	private String password;
	
	public LoginInfo (String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username)
	{
		this.username= username;
	}
	public void setPassword (String password)
	{
		this.password = password;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
}
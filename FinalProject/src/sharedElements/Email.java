package sharedElements;

import java.io.Serializable;
import java.util.ArrayList;

public class Email implements Serializable {
	private static final long serialVersionUID = 9195987129315419416L;
	private String from;
	private ArrayList<String> to;
	private String subject;
	private String content;
	private String password;
	
	public Email (String subject, String content)
	{
		this.subject =subject;
		this.content = content;
	}
	public String getSender ()
	{
		return from;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password =password;
	}
	public ArrayList<String> getReceiver ()
	{
		return to;
	}
	public void setReceiver(ArrayList<String> to)
	{
		this.to =to;
	}
	public void setSender (String sender)
	{
		this.from = sender;
	}
	public String getSubject ()
	{
		return subject;
	}
	public String getContent ()
	{
		return content;
	}
}

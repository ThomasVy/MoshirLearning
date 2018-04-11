package backEnd;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import sharedElements.Email;
/**
 * 
 * @author Rainer Lim & Thomas Vy
 *
 */
public class EmailHelper {
	public boolean sendEmail(Email email, String password)
	{
		boolean state = false;
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true"); // Using TLS
		properties.put("mail.smtp.auth", "true"); // Authenticate
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Using Gmail Account
		properties.put("mail.smtp.port", "587"); // TLS uses port 587
		Session session = Session.getInstance(properties,
				new Authenticator(){
				 protected PasswordAuthentication getPasswordAuthentication() {
				 return new PasswordAuthentication(email.getSender(), password);
				 }
		});

		try 
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getSender()));
			Iterator <String> it = email.getReceiver().iterator();
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(it.next()));
			while(it.hasNext())
			{
				message.addRecipient(Message.RecipientType.BCC, new InternetAddress(it.next()));
			}
			message.setSubject(email.getSubject());
			message.setText(email.getContent());
			Transport.send(message); // Send the Email Message
			state = true;
		} 
		catch (MessagingException e) 
		{
			state =false;
		}
		return state;

	}
}

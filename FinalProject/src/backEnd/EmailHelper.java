package backEnd;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import sharedElements.Email;
/**
 * The email helper for the server
 * @author Rainer Lim and Thomas Vy
 * @since April 12, 2018
 * @version 1.0
 */
public class EmailHelper {
	/**
	 * Sends the email to the recipients
	 * @param email - the email to be sent
	 * @return - true if the email was successfully sent, false otherwise
	 */
	public boolean sendEmail(Email email)
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
				 return new PasswordAuthentication(email.getSender(), email.getPassword());
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

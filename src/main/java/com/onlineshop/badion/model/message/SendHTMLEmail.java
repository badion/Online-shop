package com.onlineshop.badion.model.message;


import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.service.CustomerServiceImpl;


public class SendHTMLEmail {
	public static final Logger LOG = Logger.getLogger(SendHTMLEmail.class);
	public static boolean send(Customer customer, String serverUrl)
			throws AddressException, MessagingException {

		LOG.info("SendHTMLEmail for user "+customer.getId());
		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "badion926@gmail.com";
		String password = "ghbdtnrfrltkf";

		// outgoing message information
		String mailTo = customer.getEmail();
		String subject = "Підтвердження надсилання заявки";

		// message contains HTML markups
		String href = serverUrl.substring(0,serverUrl.length()-12)+"/confirm"
				+ "?id="
				+ customer.getId();
		System.out.println(href);
		
		String message ="Вітаємo! Ви створюєте заявку на безкоштовну консультацію" + "<br>" + "Вашt ім'я : " + customer.getLogin()
				+ "<br>" + "для підтвердження насилання перейдіть по даному посиланню  "+" <a href='"
				+ href + "'>"+" підтвердження надсилання заявки "+"</a>"+ "<br>" + "Приємної роботи " + "<br>" + "Команда розробників.";
		sendHtmlEmail(host, port, mailFrom, password, mailTo, subject, message);
		return true;
	}

	private static void sendHtmlEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);
		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setContent(message, "text/html; charset=UTF-8;");
		Transport.send(msg);
	}
}

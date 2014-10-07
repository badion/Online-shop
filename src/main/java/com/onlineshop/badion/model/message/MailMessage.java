package com.onlineshop.badion.model.message;

public class MailMessage {
	
	private String message;
	private String subject;

	public MailMessage(String subject, String message) {
		super();
		this.subject = subject;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getSubject() {
		return subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

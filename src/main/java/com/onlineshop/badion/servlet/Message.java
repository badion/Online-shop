package com.onlineshop.badion.servlet;

public class Message {
	public Message(String type, String main, String context) {
		super();
		this.type = type;// success || info || warning || danger
		this.main = main;
		this.context = context;
	}

	private String type;// success || info || warning || danger
	private String main;
	private String context;

	@Override
	public String toString() {
		return "Message: [" + type + "]: " + main + "(" + context + ")";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}

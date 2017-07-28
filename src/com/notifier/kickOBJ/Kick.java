package com.notifier.kickOBJ;

public class Kick {
	String target;
	String sender;
	
	public Kick(String target , String sender) {
		this.target = target;
		this.sender = sender;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
}

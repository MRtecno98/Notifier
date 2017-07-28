package com.notifier.banOBJ;

public class Ban {
	private String sender;
	private String target;
	
	public Ban(String sender , String target) {
		this.sender = sender;
		this.target = target;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}

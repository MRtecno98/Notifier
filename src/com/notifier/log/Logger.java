package com.notifier.log;

import org.bukkit.Server;

import com.notifier.main.Main;

public class Logger {
	Main plugin;
	boolean activated;
	
	public Logger(boolean activated , Main instance) {
		plugin = instance;
		this.activated = activated;
	}
	
	public void setActive(boolean activated) {
		this.activated = activated;
	}
	
	public void Log(String txt) {
		plugin.getServer().getConsoleSender().sendMessage(txt);
	}
}

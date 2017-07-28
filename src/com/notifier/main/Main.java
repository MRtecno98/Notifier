package com.notifier.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.notifier.executors.StartCommand;
import com.notifier.listeners.KickListener;
import com.notifier.log.Logger;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	public boolean notify = false;
	public String server = "localhost:8080";
	public Logger logger = new Logger(true , this);
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new KickListener(this),this);
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + getDescription().getName() + " - " + getDescription().getVersion() + " " + ChatColor.GREEN + "ACTIVATED!");
		getCommand("start").setExecutor(new StartCommand(this));
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + getDescription().getName() + " - " + getDescription().getVersion() + " " + ChatColor.DARK_RED + "DEACTIVATED!");
	}
	
}

package com.notifier.executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.notifier.events.PlayerSenderKickEvent;
import com.notifier.main.Main;

public class KickCommand implements CommandExecutor {
	 
    Main plugin;
    public KickCommand(Main instance) {
    	plugin = instance;
    }
 
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(label.equalsIgnoreCase("kick") && args.length > 0) {
    		PlayerSenderKickEvent event = new PlayerSenderKickEvent(sender , plugin.getServer().getPlayer(args[0]));
    		Bukkit.getPluginManager().callEvent(event);
    		return true;
		}
    	
    	if(label.equalsIgnoreCase("ban") && args.length > 0) {
    		PlayerSenderKickEvent event = new PlayerSenderKickEvent(sender , plugin.getServer().getPlayer(args[0]));
    		Bukkit.getPluginManager().callEvent(event);
    		return true;
    	}
        return false;
    }
 
}

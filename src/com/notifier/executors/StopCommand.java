package com.notifier.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.notifier.main.Main;

import net.md_5.bungee.api.ChatColor;

public class StopCommand implements CommandExecutor {
	 
    Main plugin;
    public StopCommand(Main instance) {
    	plugin = instance;
    }
 
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(label.equalsIgnoreCase("stop")) {
			plugin.notify = false;
			if(sender instanceof Player) {
				sender = (Player)sender;
				sender.sendMessage("Start Notifing");
			}
			plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Start Notifing");
			return true;
		}
        return false;
    }
 
}
package com.notifier.listeners;

import java.io.IOException;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.notifier.banOBJ.Ban;
import com.notifier.events.PlayerSenderKickEvent;
import com.notifier.json.Json;
import com.notifier.kickOBJ.Kick;
import com.notifier.main.Main;
import com.notifier.telegram.ServerRequester;

public class KickListener implements Listener {
	
	Main plugin;
    public KickListener(Main instance) {
    	plugin = instance;
    }
	
	@EventHandler
	public void onKick(PlayerSenderKickEvent e) {
		String banTarget;
		String banSender;
		
		String kickTarget;
		String kickSender;
		
		Player pTarget = e.getTarget();
		banTarget = pTarget.getName();
		
		Player pSender;
		CommandSender cmdSender = e.getSender();
		if(cmdSender instanceof Player) {
			pSender = (Player)cmdSender;
			banSender = pSender.getName();
		}else{
			banSender = "CONSOLE";
		}
		
		kickTarget = banTarget;
		kickSender = banSender;
		
		if(pTarget.isBanned()) {
			Ban ban = new Ban(banTarget , banSender);
			
			String json;
			try {
				json = Json.banToJSON(ban);
			}catch(IOException exc){
				plugin.getServer().getConsoleSender().sendMessage(exc.getStackTrace().toString());
				return;
			}
			
			ServerRequester requester = new ServerRequester();
			String response;
			try {
				response = requester.requestJSON(json , plugin.server);
			}catch(IOException exc){
				plugin.getServer().getConsoleSender().sendMessage(exc.getStackTrace().toString());
				return;
			}
			
			plugin.getServer().getConsoleSender().sendMessage("Ban succesfully sended, response are: " + response);
		}else{
			Kick kick = new Kick(kickTarget , kickSender);
			
			String json;
			try {
				json = Json.kickToJSON(kick);
			}catch(IOException exc){
				plugin.getServer().getConsoleSender().sendMessage(exc.getStackTrace().toString());
				return;
			}
			
			ServerRequester requester = new ServerRequester();
			String response;
			try {
				response = requester.requestJSON(json , plugin.server);
			}catch(IOException exc){
				plugin.getServer().getConsoleSender().sendMessage(exc.getStackTrace().toString());
				return;
			}
			
			plugin.getServer().getConsoleSender().sendMessage("Ban succesfully sended, response are: " + response);
		}
	}
}

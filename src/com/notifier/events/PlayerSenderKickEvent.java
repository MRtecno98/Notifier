package com.notifier.events;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerSenderKickEvent extends Event {
	private static final HandlerList HANDLERS = new HandlerList();
	Player target;
	CommandSender sender;
	
	public PlayerSenderKickEvent(CommandSender sender , Player target) {
		this.sender = sender;
		this.target = target;
	}
	
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	public CommandSender getSender() {
		return sender;
	}

	public void setSender(CommandSender sender) {
		this.sender = sender;
	}

	public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

package com.creatorfromhell.core.bukkit.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerKickListener implements Listener {

  @EventHandler
  public void onPlayerKick(PlayerKickEvent event) {
    com.creatorfromhell.core.uapi.event.player.PlayerKickEvent kickEvent = new com.creatorfromhell.core.uapi.event.player.PlayerKickEvent(
        event.getPlayer().getUniqueId(), event.getLeaveMessage(), event.getReason());
    UEventFactory.getInstance().callEvent(kickEvent);
  }
}
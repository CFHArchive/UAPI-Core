package com.creatorfromhell.core.bukkit.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent leaveEvent = new com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent(
        event.getPlayer().getUniqueId(), event.getQuitMessage());
    UEventFactory.getInstance().callEvent(leaveEvent);
  }
}
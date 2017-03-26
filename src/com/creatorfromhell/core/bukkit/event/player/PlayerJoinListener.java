package com.creatorfromhell.core.bukkit.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    System.out.println("[UAPI]Player joined: "
            + event.getPlayer().getDisplayName());
    com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent joinEvent = new com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent(
            event.getPlayer().getUniqueId(), event.getJoinMessage());
    UEventFactory.getInstance().callEvent(joinEvent);
  }
}
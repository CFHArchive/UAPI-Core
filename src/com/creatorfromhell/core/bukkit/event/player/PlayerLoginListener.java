package com.creatorfromhell.core.bukkit.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {

  @EventHandler
  public void onPlayerLogin(PlayerLoginEvent event) {
    com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent connectEvent = new com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent(
        event.getPlayer().getUniqueId(), event.getAddress(), event.getKickMessage());
    UEventFactory.getInstance().callEvent(connectEvent);
  }
}
package com.creatorfromhell.core.canary.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;

public class ConnectionListener implements PluginListener {

  @HookHandler
  public void onConnection(ConnectionHook hook) {
    PlayerJoinEvent joinEvent = new PlayerJoinEvent(hook.getPlayer().getUUID(), hook.getMessage());
    UEventFactory.getInstance().callEvent(joinEvent);
  }
}
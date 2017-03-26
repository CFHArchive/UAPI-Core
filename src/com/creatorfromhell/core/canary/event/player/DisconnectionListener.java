package com.creatorfromhell.core.canary.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.plugin.PluginListener;

public class DisconnectionListener implements PluginListener {

  @HookHandler
  public void onDisconnect(DisconnectionHook hook) {

    PlayerLeaveEvent leaveEvent = new PlayerLeaveEvent(hook.getPlayer().getUUID(),
            hook.getLeaveMessage());
    UEventFactory.getInstance().callEvent(leaveEvent);
  }
}

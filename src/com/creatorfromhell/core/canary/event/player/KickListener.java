package com.creatorfromhell.core.canary.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import com.creatorfromhell.core.uapi.event.player.PlayerKickEvent;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.KickHook;
import net.canarymod.plugin.PluginListener;

public class KickListener implements PluginListener {

  @HookHandler
  public void onKick(KickHook hook) {

    PlayerKickEvent kickEvent = new PlayerKickEvent(hook.getKickedPlayer().getUUID(),
            "Not supported by CanaryLib", hook.getReason());
    UEventFactory.getInstance().callEvent(kickEvent);
  }
}
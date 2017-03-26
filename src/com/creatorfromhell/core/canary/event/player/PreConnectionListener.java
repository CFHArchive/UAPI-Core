package com.creatorfromhell.core.canary.event.player;

import com.creatorfromhell.core.uapi.event.UEventFactory;
import com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.PreConnectionHook;
import net.canarymod.plugin.PluginListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PreConnectionListener implements PluginListener {

  @HookHandler
  public void onPreConnection(PreConnectionHook hook) {
    InetAddress address = null;
    try {
      address = InetAddress.getByName(hook.getIp());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    PlayerConnectEvent connectEvent = new PlayerConnectEvent(hook.getUUID(), address,
            hook.getKickReason());

    UEventFactory.getInstance().callEvent(connectEvent);
  }
}
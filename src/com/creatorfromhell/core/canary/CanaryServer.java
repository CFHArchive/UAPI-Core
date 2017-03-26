package com.creatorfromhell.core.canary;

import com.creatorfromhell.core.canary.event.player.ConnectionListener;
import com.creatorfromhell.core.canary.event.player.DisconnectionListener;
import com.creatorfromhell.core.canary.event.player.KickListener;
import com.creatorfromhell.core.canary.event.player.PreConnectionListener;
import com.creatorfromhell.core.uapi.ServerType;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.UServer;
import com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerKickEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent;
import net.canarymod.Canary;
import net.canarymod.plugin.PluginListener;

import java.util.HashMap;
import java.util.Map;

public class CanaryServer extends UServer {

  Map<String, PluginListener> supported = new HashMap<String, PluginListener>();

  public CanaryServer(UPluginLoader loader) {
    super(loader);
    supported.put(PlayerConnectEvent.class.getSimpleName(),
                  new PreConnectionListener());
    supported.put(PlayerJoinEvent.class.getSimpleName(),
                  new ConnectionListener());
    supported.put(PlayerKickEvent.class.getSimpleName(), new KickListener());
    supported.put(PlayerLeaveEvent.class.getSimpleName(),
                  new DisconnectionListener());
  }

  public boolean isSupported(String event) {
    return supported.containsKey(event);
  }

  @Override
  public ServerType getServerType() {
    return ServerType.SERVER_CANARY;
  }

  @Override
  public void registerListener(String event) {
    if (isSupported(event)) {
      Canary.hooks().registerListener(supported.get(event),
              (CanaryPluginLoader) loader);
    }
  }
}
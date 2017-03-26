package com.creatorfromhell.core.sponge;

import com.creatorfromhell.core.sponge.event.player.PlayerJoinListener;
import com.creatorfromhell.core.sponge.event.player.PlayerKickListener;
import com.creatorfromhell.core.sponge.event.player.PlayerLoginListener;
import com.creatorfromhell.core.sponge.event.player.PlayerQuitListener;
import com.creatorfromhell.core.uapi.ServerType;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.UServer;
import com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerKickEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent;
import org.spongepowered.api.Sponge;

import java.util.HashMap;
import java.util.Map;

public class SpongeServer extends UServer {

  Map<String, Object> supported = new HashMap<String, Object>();

  public SpongeServer(UPluginLoader loader) {
    super(loader);
    supported.put(PlayerJoinEvent.class.getSimpleName(),
            new PlayerJoinListener());
    supported.put(PlayerLeaveEvent.class.getSimpleName(),
            new PlayerQuitListener());
    supported.put(PlayerKickEvent.class.getSimpleName(),
            new PlayerKickListener());
    supported.put(PlayerConnectEvent.class.getSimpleName(),
            new PlayerLoginListener());
  }

  public boolean isSupported(String event) {
    return supported.containsKey(event);
  }

  @Override
  public ServerType getServerType() {
    return ServerType.SERVER_SPONGE;
  }

  @Override
  public void registerListener(String event) {
    if (isSupported(event)) {
      Sponge.getGame()
              .getEventManager()
              .registerListeners((SpongePluginLoader) loader,
                      supported.get(event));
    }
  }

}
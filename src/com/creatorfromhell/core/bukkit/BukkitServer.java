package com.creatorfromhell.core.bukkit;

import com.creatorfromhell.core.bukkit.event.player.PlayerJoinListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerKickListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerLoginListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerQuitListener;
import com.creatorfromhell.core.uapi.ServerType;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.UServer;
import com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerKickEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class BukkitServer extends UServer {

  Map<String, Listener> supported = new HashMap<>();

  public BukkitServer(UPluginLoader loader) {
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
    return ServerType.SERVER_BUKKIT;
  }

  @Override
  public void registerListener(String event) {
    if (isSupported(event)) {
      Bukkit.getServer()
              .getPluginManager()
              .registerEvents(supported.get(event), (BukkitPluginLoader) loader);
    }
  }
}
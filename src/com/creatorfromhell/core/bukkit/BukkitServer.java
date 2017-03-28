package com.creatorfromhell.core.bukkit;

import com.creatorfromhell.core.bukkit.event.player.PlayerJoinListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerKickListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerLoginListener;
import com.creatorfromhell.core.bukkit.event.player.PlayerQuitListener;
import com.creatorfromhell.core.uapi.ServerType;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.UServer;
import com.creatorfromhell.core.uapi.entity.Player;
import com.creatorfromhell.core.uapi.event.player.PlayerConnectEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerJoinEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerKickEvent;
import com.creatorfromhell.core.uapi.event.player.PlayerLeaveEvent;
import com.creatorfromhell.core.uapi.world.World;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

  @Override
  public Player getPlayer(String name) {
    return null;
  }

  @Override
  public Player getPlayer(UUID uuid) {
    return null;
  }

  @Override
  public void broadcast(String s) {

  }

  @Override
  public void broadcast(String s, String s1) {

  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getIP() {
    return null;
  }

  @Override
  public String getVersion() {
    return null;
  }

  @Override
  public int getMaxPlayers() {
    return 0;
  }

  @Override
  public World getDefaultWorld() {
    return null;
  }

  @Override
  public List<World> getWorlds() {
    return null;
  }
}
package com.creatorfromhell.core.bukkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.plugin.java.JavaPlugin;

import com.creatorfromhell.core.uapi.UPlugin;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.event.UEventFactory;

public class BukkitPluginLoader extends JavaPlugin implements UPluginLoader {

  UPlugin instance;
  UEventFactory eventFactory;

  @Override
  public void onEnable() {
    System.out.println("[UAPI]BukkitLoader started.");
    BukkitServer server = new BukkitServer(this);
    eventFactory = new UEventFactory(server);

    InputStream in = getClass().getResourceAsStream("/main.ini");
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    try {
      String entry = reader.readLine().split("=")[1].trim();
      Class<?> main = Class.forName(entry);
      if (UPlugin.class.isAssignableFrom(main)) {
        instance = (UPlugin) main.newInstance();
        instance.onEnable(server);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onDisable() {
    instance.onDisable();
  }

  @Override
  public UPlugin getPluginInstance() {
    return instance;
  }

  @Override
  public UEventFactory getEventFactory() {
    return eventFactory;
  }
}
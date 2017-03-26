package com.creatorfromhell.core.canary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.canarymod.plugin.Plugin;

import com.creatorfromhell.core.uapi.UPlugin;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.event.UEventFactory;

public class CanaryPluginLoader extends Plugin implements UPluginLoader {

  UPlugin instance;
  UEventFactory eventFactory;

  @Override
  public void onEnable() {
    System.out.println("[UAPI]CanaryLoader Started");
    CanaryServer server = new CanaryServer(this);
    eventFactory = new UEventFactory(server);

    InputStream in = getClass().getResourceAsStream("/main.ini");
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    try {
      String entry = reader.readLine().split("=")[0].trim();
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
  public void disable() {
    onDisable();
  }

  @Override
  public boolean enable() {
    onEnable();
    return true;
  }

  @Override
  public UEventFactory getEventFactory() {
    return eventFactory;
  }

}
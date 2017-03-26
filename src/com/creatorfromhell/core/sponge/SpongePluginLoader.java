package com.creatorfromhell.core.sponge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.spongepowered.api.Game;
import org.spongepowered.api.plugin.Plugin;

import com.creatorfromhell.core.uapi.UPlugin;
import com.creatorfromhell.core.uapi.UPluginLoader;
import com.creatorfromhell.core.uapi.event.UEventFactory;
import com.google.inject.Inject;

@Plugin(
        id = "universal_api",
        name = "UAPI",
        version = "0.0.0.1",
        description = "An API created to allow plugin authors to write once, support all.",
        url = "https://creatorfromhell.com", authors = { "creatorfromhell" })
public class SpongePluginLoader implements UPluginLoader {

  private UPlugin instance;
  private UEventFactory eventFactory;
  @Inject
  private Game game;

  @Override
  public void onEnable() {
    System.out.println("[UAPI]SpongeLoaderStarted");
    SpongeServer server = new SpongeServer(this);
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

  }

  public Game getGame() {
    return game;
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
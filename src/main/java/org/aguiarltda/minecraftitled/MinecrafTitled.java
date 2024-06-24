package org.aguiarltda.minecraftitled;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecrafTitled extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    Bukkit.getConsoleSender().sendMessage("Hello! The plugin is loaded");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    Bukkit.getConsoleSender().sendMessage("Hello! The plugin is unloaded");
  }
}

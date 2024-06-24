package org.aguiarltda.minecraftitled;

import org.aguiarltda.minecraftitled.events.BlockBreak;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecrafTitled extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    Bukkit.getConsoleSender().sendMessage("[MINECRAFTITLED]: Plugin successfully loaded");

    Bukkit.getPluginManager().registerEvents(new BlockBreak(this), this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    Bukkit.getConsoleSender().sendMessage("Hello! The plugin is unloaded");
  }
}

package org.aguiarltda.minecraftitled.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class BlockBreak implements Listener {
  private final String AWARD_BLOCK;
  private final Plugin plugin;

  public BlockBreak(Plugin plugin) {
    this.plugin = plugin;
    this.AWARD_BLOCK = "SHORT_GRASS";
  }

  @EventHandler
  public void onBlockBreakEvent(BlockBreakEvent event) {
    Player whoBroke = event.getPlayer();
    Block whatsBroken = event.getBlock();

    if (whatsBroken.getType().name().equalsIgnoreCase(this.AWARD_BLOCK)) {
      if (whoBroke.getGameMode().equals(GameMode.CREATIVE)) {
        String warningMessage = String.format("%s[WAIT] %s%sWait until your creative effect pass to get the award again", ChatColor.YELLOW, ChatColor.BOLD, ChatColor.DARK_AQUA);
        whoBroke.sendMessage(warningMessage);
        return;
      }

      this.announceAward(whoBroke);
      this.givePlayerAward(whoBroke);
    }
  }

  private void announceAward(Player player) {
    String eventMessage = String.format("%s %s %s broke the awarded block", ChatColor.DARK_PURPLE, player.getName(), ChatColor.DARK_BLUE);
    Bukkit.broadcastMessage(eventMessage);
  }

  private void givePlayerAward(Player player) {
    int xpQuantity = (int) Math.round(Math.random() * 30);

    if (xpQuantity == 0) {
      xpQuantity = 1;
    }

    player.giveExpLevels(xpQuantity);

    String xpMessage = String.format("%s [CONGRATULATIONS] %sYou gained %d xp points and 5s of creative mode", ChatColor.GOLD, ChatColor.GREEN, xpQuantity);
    player.sendMessage(xpMessage);

    player.setGameMode(GameMode.CREATIVE);
    Bukkit.getScheduler().runTaskLater(this.plugin, () -> player.setGameMode(GameMode.SURVIVAL), 100L);
  }
}

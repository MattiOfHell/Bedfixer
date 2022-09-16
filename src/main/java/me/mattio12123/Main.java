package me.mattio12123;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener, CommandExecutor {
    private static Main singleton;

    public Main() {
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        singleton = this;
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6● &aEnabled &c&lBed&4&lFixer &av1.1"));
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Plugin by MattiOfHell"));
    }

    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6● &cDisabled &c&lBed&4&lFixer &av1.1"));
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Plugin by MattiOfHell"));
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6● &7Running &c&lBed&4&lFixer &av1.1"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Plugin by MattiOfHell"));
            return true;
        } else {
            this.getLogger().info("You need to be a player to do this.");
            return true;
        }
    }

    @EventHandler
    public void itemDrop(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType().name().contains("BED")) {
            event.setDropItems(false);
        }

    }
}

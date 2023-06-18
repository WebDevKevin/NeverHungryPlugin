package me.tauntaunchewie.neverhungry;

import me.tauntaunchewie.neverhungry.utils.NeverHungryUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Make sure a player is calling this
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Check if player has permission
            if (player.hasPermission("neverhungryplugin.set")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("on")) {
                        NeverHungryUtils.setEnabled(true);
                        for(Player p: Bukkit.getOnlinePlayers()) {
                            p.setFoodLevel(NeverHungryUtils.getMaxFoodLevel());
                            p.sendMessage(ChatColor.DARK_AQUA + "The almighty food goat has made you hungry no more!" + ChatColor.BOLD);
                        }
                        player.sendMessage("Never Hungry Plugin enabled.");
                    } else if (args[0].equalsIgnoreCase("off")) {
                        NeverHungryUtils.setEnabled(false);
                        for(Player p: Bukkit.getOnlinePlayers()) {
                            p.sendMessage(ChatColor.RED + "The almighty food goat is mad and you will be hungry!" + ChatColor.BOLD);
                        }
                        player.sendMessage("Never Hungry Plugin disabled.");
                    } else if (args[0].equalsIgnoreCase("status")) {
                        player.sendMessage("Never Hungry Plugin is currently: " + (NeverHungryUtils.isEnabled() ? "ON" : "OFF"));
                    } else {
                        player.sendMessage("Invalid argument.  Only on/off/status allowed");
                        player.sendMessage("Example: /neverhungry on");
                    }
                }
                else {
                    player.sendMessage("Usage: /neverhungry on/off/status");
                    player.sendMessage("Example: /neverhungry on");
                }
            } else {
                player.sendMessage("You do not have permission to execute this command.");
            }

            return true;

        } else {
            // Only allow players to invoke
            return false;
        }
    }
}
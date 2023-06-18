package me.tauntaunchewie.neverhungry;

import me.tauntaunchewie.neverhungry.utils.NeverHungryUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class WelcomeListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (NeverHungryUtils.isEnabled()) {
            player.sendMessage(ChatColor.DARK_AQUA + "Good thing you ate breakfast!  You are never hungry here. " + ChatColor.BOLD + ChatColor.YELLOW + player.getDisplayName() + "!");

            // Set food level to max on join
            player.setFoodLevel(NeverHungryUtils.getMaxFoodLevel());
        }
    }

    /**
     * Disables the food depletion mechanic so players do not get hungry and sets the player's hunger level to max
     * @param event
     */
    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent event) {
        if (NeverHungryUtils.isEnabled()) {
            HumanEntity player = event.getEntity();

            event.setCancelled(true);
            player.setFoodLevel(NeverHungryUtils.getMaxFoodLevel());
        }
    }
}
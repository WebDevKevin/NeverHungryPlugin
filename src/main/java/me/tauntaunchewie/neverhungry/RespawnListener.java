package me.tauntaunchewie.neverhungry;

import me.tauntaunchewie.neverhungry.utils.NeverHungryUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        // Reset food level to max
        player.setFoodLevel(NeverHungryUtils.getMaxFoodLevel());
    }
}


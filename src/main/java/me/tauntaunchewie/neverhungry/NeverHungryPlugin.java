package me.tauntaunchewie.neverhungry;

import me.tauntaunchewie.neverhungry.utils.NeverHungryUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class NeverHungryPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        //getLogger().info("onEnable is called!");

        // Populate configs
        NeverHungryUtils.loadDefaults(this);

        getServer().getPluginManager().registerEvents(new WelcomeListener(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(), this);
        this.getCommand("neverhungry").setExecutor(new Commander());
    }

    @Override
    public void onDisable() {
        //getLogger().info("onDisable is called!");
    }
}


package me.tauntaunchewie.neverhungry.utils;

import me.tauntaunchewie.neverhungry.NeverHungryPlugin;

public class NeverHungryUtils {
    private static NeverHungryPlugin plugin;
    private static boolean pluginEnabled = false;
    // Max hunger level in minecraft
    private static int maxFoodLevel = 20;

    /**
     * Return status of plugin enabled/disabled
     * @return
     */
    public static boolean isEnabled() {
        return pluginEnabled;
    }

    /**
     * Returns the max food level set by the plugin
     * Note: Minecraft default is 20
     * @return
     */
    public static int getMaxFoodLevel() {
        return maxFoodLevel;
    }

    /**
     * Enable or disable the plugin.
     * @param enabled
     */
    public static void setEnabled(boolean enabled) {
        pluginEnabled = enabled;
        plugin.getConfig().set("enabled", enabled);
        plugin.saveConfig();
    }

    /**
     * Create reference to plugin and retrieve enabled status
     * @param instance
     */
    public static void loadDefaults(NeverHungryPlugin instance) {
        plugin = instance;
        setEnabled(plugin.getConfig().getBoolean("enabled"));
    }
}
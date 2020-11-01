package me.devdav.insultplayers.listeners;


import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerManager {

    private JavaPlugin plugin;
    private Listener[] listeners;

    public ListenerManager(JavaPlugin plugin, Listener[] listeners) {
        this.plugin = plugin;
        this.listeners = listeners;

        PluginManager pluginManager = plugin.getServer().getPluginManager();

        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, plugin);
        }
    }

}

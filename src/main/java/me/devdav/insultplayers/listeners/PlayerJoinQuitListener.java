package me.devdav.insultplayers.listeners;

import me.devdav.insultplayers.helpers.InsultGenerator;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    InsultGenerator insultGenerator = InsultGenerator.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String playerName = e.getPlayer().getName();
        e.setJoinMessage(ChatColor.YELLOW + playerName + " " + insultGenerator.getRandomInsult() + " a rejoint le serveur");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        String playerName = e.getPlayer().getName();
        e.setQuitMessage(ChatColor.YELLOW + playerName + " " + insultGenerator.getRandomInsult() + " a quitté le serveur");
    }
}

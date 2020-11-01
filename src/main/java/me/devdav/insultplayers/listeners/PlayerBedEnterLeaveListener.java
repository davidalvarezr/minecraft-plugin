package me.devdav.insultplayers.listeners;

import me.devdav.insultplayers.helpers.InsultGenerator;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerBedEnterLeaveListener implements Listener {

    InsultGenerator insultGenerator = InsultGenerator.getInstance();

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.DARK_BLUE + "Bonne nuit " + insultGenerator.getRandomInsultWithoutArticle());
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.DARK_AQUA + "J'espère que tu as bien dormi " + insultGenerator.getRandomInsultWithoutArticle());
    }
}

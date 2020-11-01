package me.devdav.insultplayers.listeners;

import me.devdav.insultplayers.location.Corner;
import me.devdav.insultplayers.location.Place;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class PlayerMoveListener implements Listener {

    private final Place[] places = new Place[]{
            new Place(
                    "Bienvenue au Maroc",
                    "Allah veille sur vous",
                    new Corner(-227, -623),
                    new Corner(-222, -623),
                    new Corner(-222, -619),
                    new Corner(-227, -619)

            ),
            new Place(
                    "Bienvenue dans la maison principale",
                    "On espère vous revoir bientôt dans la maison principale",
                    new Corner(-386, 45),
                    new Corner(-371, 45),
                    new Corner(-371, 66),
                    new Corner(-386, 66)
            )
    };

    private final HashMap<String, Long> lastPlayerMessages = new HashMap<String, Long>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getName();

        if (hadAMessageInXLastSeconds(playerName, 10)) return;

        Location from = e.getFrom();
        Location to = e.getTo();

        if (to == null) return;
        if (from.getBlockX() == to.getBlockX() && from.getBlockZ() == to.getBlockZ()) return;

//        player.sendMessage(String.format("From: %s/%s/%s", from.getX(), from.getY(), from.getZ()));
//        player.sendMessage(String.format("To: %s/%s/%s", to.getX(), to.getY(), to.getZ()));

        for (Place place : places) {
            if (!place.hasInside(from) && place.hasInside(to)) {
                player.sendMessage(ChatColor.DARK_GREEN + place.messageEnter);
            } else if (place.hasInside(from) && !place.hasInside(to)) {
                player.sendMessage(ChatColor.DARK_RED + place.messageLeave);
            } else {
                continue;
            }
            lastPlayerMessages.put(playerName, System.currentTimeMillis());
        }
    }

    private boolean hadAMessageInXLastSeconds(String username, int seconds) {
        long lastMessageToPlayerTimstamp = lastPlayerMessages.getOrDefault(username, -1L);
        if (lastMessageToPlayerTimstamp == -1L) return false;
        return System.currentTimeMillis() - lastMessageToPlayerTimstamp < seconds * 1000;
    }
}

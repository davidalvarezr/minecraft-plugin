package me.devdav.insultplayers;

import me.devdav.insultplayers.location.Corner;
import me.devdav.insultplayers.location.Place;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class InsultPlayers extends JavaPlugin implements Listener {

    public static String[] insults = new String[]{
            "le FDP",
            "l'enculé de sa mère",
            "l'enculé de ses morts",
            "le fils de pute",
            "la petite pute",
            "le bâtard",
            "le fils de chien",
            "le gros branleur",
            "le lâche",
            "le disciple préféré d'Hitler",
            "le nazi",
            "le SS",
    };

    public static Place[] places = new Place[]{
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


    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String playerName = e.getPlayer().getName();
        e.setJoinMessage(ChatColor.YELLOW + playerName + " " + getRandomInsult() + " a rejoint le serveur");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        String playerName = e.getPlayer().getName();
        e.setQuitMessage(ChatColor.YELLOW + playerName + " " + getRandomInsult() + " a quitté le serveur");
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Bonne nuit " + removeArticle(getRandomInsult()));
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("J'espère que tu as bien dormi " + removeArticle(getRandomInsult()));
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Location from = e.getFrom();
        Location to = e.getTo();
        Player player = e.getPlayer();

        if (to == null) return;
        if (from.getBlockX() == to.getBlockX() && from.getBlockZ() == to.getBlockZ()) return;

//        player.sendMessage(String.format("From: %s/%s/%s", from.getX(), from.getY(), from.getZ()));
//        player.sendMessage(String.format("To: %s/%s/%s", to.getX(), to.getY(), to.getZ()));

        for (Place place : places) {
            if (!place.hasInside(from) && place.hasInside(to)) {
                player.sendMessage(place.messageEnter);
            } else if (place.hasInside(from) && !place.hasInside(to)) {
                player.sendMessage(place.messageLeave);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Command validations
        if (!command.getName().equals("fdp")) return false;
        if (!(sender instanceof Player)) {
            System.out.println("An entity is required to run this command here");
            return false;
        }

        // Command behaviour
        Player player = (Player) sender;
        player.sendMessage("Je suis un FDP");
        Bukkit.broadcastMessage(player.getDisplayName() + " aimerait que vous sachiez que c'est un gros FDP");

        return false;
    }

    private static String removeArticle(String insultWithArticle) {
        return insultWithArticle.replaceFirst("^(l'|le( )+|la( )+)", "");
    }

    private static String getRandomInsult() {
        return insults[new Random().nextInt(insults.length)];
    }
}

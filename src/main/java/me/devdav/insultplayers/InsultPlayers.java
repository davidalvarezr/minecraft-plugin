package me.devdav.insultplayers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class InsultPlayers extends JavaPlugin implements Listener {

    String[] insults = new String[]{
            "le FDP",
            "l'enculé de sa mère",
            "l'enculé de ses morts",
            "le fils de pute",
            "la petite pute",
            "le bâtard",
            "le fils de chien",
            "le gros branleur"
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
    public void onPlayerConnect(PlayerJoinEvent e) {
        String playerName = e.getPlayer().getName();
        String insult = insults[new Random().nextInt(insults.length)];
        e.setJoinMessage(ChatColor.YELLOW + playerName + " " + insult + " a rejoint le serveur");
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

        return false;
    }
}

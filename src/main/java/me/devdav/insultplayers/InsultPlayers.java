package me.devdav.insultplayers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class InsultPlayers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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

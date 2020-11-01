package me.devdav.insultplayers;

import me.devdav.insultplayers.listeners.ListenerManager;
import me.devdav.insultplayers.listeners.PlayerBedEnterLeaveListener;
import me.devdav.insultplayers.listeners.PlayerJoinQuitListener;
import me.devdav.insultplayers.listeners.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class InsultPlayers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ListenerManager(
                this,
                new Listener[]{
                        new PlayerJoinQuitListener(),
                        new PlayerBedEnterLeaveListener(),
                        new PlayerMoveListener()
                }
        );
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
        Bukkit.broadcastMessage(player.getDisplayName() + " aimerait que vous sachiez que c'est un gros FDP");

        return false;
    }


}

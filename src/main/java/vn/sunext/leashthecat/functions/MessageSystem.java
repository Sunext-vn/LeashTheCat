package vn.sunext.leashthecat.functions;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.PathManager;

public class MessageSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final ColorSystem colorSystem = plugin.getColorSystem();

    public void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(colorSystem.color(message));
    }

    public void sendPrefixMessage(CommandSender sender, String message) {
        sender.sendMessage(colorSystem.color(PathManager.PREFIX + message));
    }

    public void broadcastMessage(String message) {
        Bukkit.broadcastMessage(colorSystem.color(PathManager.PREFIX + message));
    }

}

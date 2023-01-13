package vn.sunext.leashthecat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.functions.ColorSystem;
import vn.sunext.leashthecat.functions.MessageSystem;
import vn.sunext.leashthecat.functions.PermissionSystem;
import vn.sunext.leashthecat.managers.PathManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommand implements TabExecutor {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final MessageSystem messageSystem = plugin.getMessageSystem();
    private final PermissionSystem permissionSystem = plugin.getPermissionSystem();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (args.length) {
            case 0:
                messageSystem.sendMessage(sender, "&cLeashTheCat &fv&e" + plugin.getDescription().getVersion() + " &fby &bSunext Team");
                messageSystem.sendMessage(sender, "  &7Using '&a/leashthecat help&7' for more information");
                break;
            case 1:
                switch (args[0]) {
                    case "help":
                        messageSystem.sendMessage(sender, "");
                        messageSystem.sendMessage(sender, " &f/&cleashthecat help &7- Show these help messages");
                        messageSystem.sendMessage(sender, " &f/&cleashthecat reload &7- Reload the plugin");
                        messageSystem.sendMessage(sender, "");
                        break;
                    case "reload":
                        if (permissionSystem.isHavePermission(sender, PathManager.RELOAD_PERMISSION)) {
                            plugin.getPathManager().register();

                            messageSystem.sendPrefixMessage(sender, PathManager.RELOAD_MESSAGE);
                        }
                        break;
                }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> result = new ArrayList<>();

        List<String> subCommands = Arrays.asList("help", "reload");

        switch (args.length) {
            case 1:
                subCommands.forEach(s -> {
                    if (s.startsWith(args[0].toLowerCase()))
                        result.add(s);
                });
        }

        if (!result.isEmpty())
            return result;

        return null;
    }

}

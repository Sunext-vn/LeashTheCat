package vn.sunext.leashthecat.functions;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vn.sunext.leashthecat.managers.PathManager;

public class PermissionSystem {

    public Boolean isHavePermission(CommandSender sender, String permission) {
        if (!(sender instanceof Player)) return true;

        if (sender.hasPermission(PathManager.ADMIN_PERMISSION)) return true;

        if (PathManager.ALLOW_OP)
            if (sender.isOp()) return true;

        return sender.hasPermission(permission);
    }

}

package vn.sunext.leashthecat.hooks;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.functions.PointSystem;
import vn.sunext.leashthecat.managers.PathManager;
import vn.sunext.leashthecat.managers.TopManager;

public class PlaceholderAPI extends PlaceholderExpansion {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    @Override
    public @NotNull String getIdentifier() {
        return "leashthecat";
    }

    @Override
    public @NotNull String getAuthor() {
        return "adselvn";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (identifier.equals("me")) {
            return plugin.getDataSystem().getValueTempData(player.getName()).toString();
        }

        int increaseForExactForLoop = PathManager.TOP_AMOUNT + 1;

        for (int i = 1; i < increaseForExactForLoop; ++i) {
            if (identifier.equals("top_" + i + "_name")) {
                int decreaseForExactIndex = i - 1;

                try {
                    plugin.getTopManager().getTopList().get(decreaseForExactIndex);
                } catch (IndexOutOfBoundsException ignored) {
                    return "Unknown";
                }


                return plugin.getTopManager().getTopList().get(decreaseForExactIndex).getPlayerName();
            }

            if (identifier.equals("top_" + i + "_points")) {
                int decreaseForExactIndex = i - 1;

                try {
                    plugin.getTopManager().getTopList().get(decreaseForExactIndex);
                } catch (IndexOutOfBoundsException ignored) {
                    return "Unknown";
                }

                return plugin.getTopManager().getTopList().get(decreaseForExactIndex).getPoints().toString();
            }
        }

        return null;
    }

}

package vn.sunext.leashthecat.schedulers;

import org.bukkit.Bukkit;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.PathManager;

public class TimerTask {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void refreshTop() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {

            plugin.getDataSystem().saveAllTempData(false);

            plugin.getTopManager().loadTop();

        }, PathManager.TOP_REFRESH_INTERVAL * 20L, PathManager.TOP_REFRESH_INTERVAL * 20L);
    }

}

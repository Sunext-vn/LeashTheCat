package vn.sunext.leashthecat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class QuitEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        plugin.getDataSystem().removeTempDataOnQuit(event);
    }

}

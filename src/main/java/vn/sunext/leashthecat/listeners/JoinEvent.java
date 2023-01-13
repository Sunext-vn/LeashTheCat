package vn.sunext.leashthecat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class JoinEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        plugin.getPointSystem().setZeroPointOnFirstJoin(event.getPlayer());
    }

}

package vn.sunext.leashthecat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class LeashEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    @EventHandler
    public void onLeashEntity(PlayerInteractAtEntityEvent event) {
        plugin.getLeashSystem().onLeashCat(event);
    }

    @EventHandler
    public void onLeashEntity(PlayerLeashEntityEvent event) {
        plugin.getLeashSystem().onLeashCat(event);
    }

}

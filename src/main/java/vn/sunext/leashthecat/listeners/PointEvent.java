package vn.sunext.leashthecat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.events.AddPointEvent;
import vn.sunext.leashthecat.functions.MessageSystem;
import vn.sunext.leashthecat.managers.PathManager;
import vn.sunext.leashthecat.managers.TopManager;

public class PointEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final TopManager topManager = plugin.getTopManager();
    private final MessageSystem messageSystem = plugin.getMessageSystem();

    @EventHandler
    public void onPointEvent(AddPointEvent event) {
        if (topManager.getTopList().isEmpty()) {
            messageSystem.broadcastMessage(PathManager.FIRST_TOP_ONE_MESSAGE.replace("{new-1st-name}", event.getPlayer().getName()));
        }
    }

}

package vn.sunext.leashthecat.functions;

import org.bukkit.entity.Player;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.events.AddPointEvent;

public class PointSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void addPoint(Player player, Integer amount) {
        String playerName = player.getName();
        Integer currentPoint = plugin.getDataSystem().getValueTempData(playerName);
        Integer nextPoint = currentPoint + amount;

        AddPointEvent addPointEvent = new AddPointEvent(player, currentPoint, nextPoint);
        plugin.callEvent(addPointEvent);
    }

}

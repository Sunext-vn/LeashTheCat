package vn.sunext.leashthecat.functions;

import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.PathManager;

public class LeashSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final InventorySystem inventorySystem = plugin.getInventorySystem();
    private final PointSystem pointSystem = plugin.getPointSystem();
    private final MessageSystem messageSystem = plugin.getMessageSystem();

    public void onLeashCat(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Ocelot) {
            if (inventorySystem.isHoldLeashItem(player)) {
                inventorySystem.removeLeashItem(player);

                pointSystem.addPoint(player, 1);
            }
        }
    }

    public void onLeashCat(PlayerLeashEntityEvent event) {
        Player player = event.getPlayer();

        if (inventorySystem.isHoldLeashItem(player)) {

            event.setCancelled(true);

            if (!(event.getEntity() instanceof Ocelot))
                messageSystem.sendPrefixMessage(player, PathManager.NOT_AN_OCELOT);

        }
    }

}

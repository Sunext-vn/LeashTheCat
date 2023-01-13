package vn.sunext.leashthecat.functions;

import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class LeashSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final InventorySystem inventorySystem = plugin.getInventorySystem();
    private final PointSystem pointSystem = plugin.getPointSystem();

    public void onLeashCat(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Ocelot) {
            if (inventorySystem.isHoldLeashItem(player, event.getHand())) {
                inventorySystem.removeLeashItem(player, event.getHand());

                pointSystem.addPoint(player, 1);
            }
        }
    }

}

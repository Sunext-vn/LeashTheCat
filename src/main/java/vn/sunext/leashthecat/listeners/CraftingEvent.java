package vn.sunext.leashthecat.listeners;

import org.bukkit.event.*;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.ItemManager;

public class CraftingEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final ItemManager itemManager = plugin.getItemManager();

    @EventHandler
    public void onPlayerCraftItem(PrepareItemCraftEvent event) {
        if (event.getInventory().getMatrix().length < 9)
            return;

        ItemStack[] matrix = event.getInventory().getMatrix();

        for (int i = 0; i < 9; i++) {
            if (matrix[i] == null || !matrix[i].isSimilar(itemManager.getLeashMaterial()))
                return;
        }

        event.getInventory().setResult(itemManager.getLeashCat());
    }

}
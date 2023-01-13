package vn.sunext.leashthecat.functions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.ItemManager;

public class InventorySystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final ItemManager itemManager = plugin.getItemManager();

    public Boolean isHoldLeashItem(Player player) {
        PlayerInventory inventory = player.getInventory();

        if (inventory.getItemInMainHand().isSimilar(itemManager.getLeashCat()))
            return true;

        return inventory.getItemInOffHand().isSimilar(itemManager.getLeashCat());
    }

    public void removeLeashItem(Player player) {
        PlayerInventory inventory = player.getInventory();

        ItemStack mainHand = inventory.getItemInMainHand();
        ItemStack offHand = inventory.getItemInOffHand();

        if (inventory.getItemInMainHand().isSimilar(itemManager.getLeashCat())) {
            mainHand.setAmount(mainHand.getAmount() - 1);
        } else {
            if (inventory.getItemInOffHand().isSimilar(itemManager.getLeashCat())) {
                offHand.setAmount(mainHand.getAmount() - 1);
            }
        }

        player.updateInventory();
    }

}

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

    public Boolean isHoldLeashItem(Player player, EquipmentSlot equipmentSlot) {
        PlayerInventory inventory = player.getInventory();

        if (equipmentSlot == EquipmentSlot.HAND) {
            return inventory.getItemInMainHand().equals(itemManager.getLeashCat());
        } else {
            return inventory.getItemInOffHand().equals(itemManager.getLeashCat());
        }
    }

    public void removeLeashItem(Player player, EquipmentSlot equipmentSlot) {
        PlayerInventory inventory = player.getInventory();

        ItemStack mainHand = inventory.getItemInMainHand();
        ItemStack offHand = inventory.getItemInOffHand();

        if (equipmentSlot == EquipmentSlot.HAND) {
            mainHand.setAmount(mainHand.getAmount() - 1);
        } else {
            offHand.setAmount(offHand.getAmount() - 1);
        }

        player.updateInventory();
    }

}

package vn.sunext.leashthecat.managers;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.functions.ColorSystem;

import java.util.List;

@Getter
public class ItemManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final ColorSystem colorSystem = plugin.getColorSystem();

    private ItemStack leashCat = null;
    private ItemStack leashMaterial = null;

    public void register() {
        leashCat = loadItem(PathManager.ITEM_LEASH_CAT_NAME, PathManager.ITEM_LEASH_CAT_MATERIAL,
                PathManager.ITEM_LEASH_CAT_GLOW, PathManager.ITEM_LEASH_CAT_LORE);

        leashMaterial = loadItem(PathManager.ITEM_LEASH_MATERIAL_NAME, PathManager.ITEM_LEASH_MATERIAL_MATERIAL,
                PathManager.ITEM_LEASH_MATERIAL_GLOW, PathManager.ITEM_LEASH_MATERIAL_LORE);
    }

    private ItemStack loadItem(String name, String material, Boolean glow, List<String> lore) {
        String resultName = colorSystem.color(name);
        Material resultMaterial = Material.matchMaterial(material);
        List<String> resultLore = colorSystem.color(lore);

        assert resultMaterial != null;
        ItemStack resultItemStack = new ItemStack(resultMaterial);
        ItemMeta itemMeta = resultItemStack.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(resultName);
        itemMeta.setLore(resultLore);

        if (glow) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);

            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        resultItemStack.setItemMeta(itemMeta);

        return resultItemStack;
    }

}

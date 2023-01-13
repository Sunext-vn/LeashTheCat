package vn.sunext.leashthecat.managers;

import org.bukkit.inventory.ItemStack;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.modules.ShapedRegister;

public class RecipeManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final ItemManager itemManager = plugin.getItemManager();

    public void register() {
        createNewRecipe(itemManager.getLeashCat(), itemManager.getLeashMaterial());
    }

    private void createNewRecipe(ItemStack resultItem, ItemStack ingredient) {
        ShapedRegister recipe = new ShapedRegister(resultItem);

        recipe.shape("MMM", "MMM", "MMM");

        recipe.setIngredient('M', ingredient);

        recipe.register();
    }

}

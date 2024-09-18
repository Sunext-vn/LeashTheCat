package vn.sunext.leashthecat.modules;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.SneakyThrows;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ShapedRegister {

    private final NamespacedKey key;
    private final ItemStack output;
    private String[] rows;
    private Map<Character, ItemStack> ingredients = new HashMap<>();

    /**
     * Create a shaped recipe to craft the specified ItemStack. The
     * constructor merely determines the result and type; to set the actual
     * recipe, you'll need to call the appropriate methods.
     *
     * @param result
     *            The item you want the recipe to create.
     * @see ShapedRecipe#shape(String...)
     * @see ShapedRecipe#setIngredient(char, Material)
     */
    public ShapedRegister(NamespacedKey key, ItemStack result) {
        this.key = key;
        this.output = new ItemStack(result);
    }

    /**
     * Set the shape of this recipe to the specified rows. Each character
     * represents a different ingredient; exactly what each character
     * represents is set separately. The first row supplied corresponds with
     * the upper most part of the recipe on the workbench e.g. if all three
     * rows are supplies the first string represents the top row on the
     * workbench.
     *
     * @param shape
     *            The rows of the recipe (up to 3 rows).
     * @return The changed recipe, so you can chain calls.
     */
    public ShapedRegister shape(String... shape) {

        this.rows = new String[shape.length];
        for (int i = 0; i < shape.length; i++) {
            this.rows[i] = shape[i];
        }

        Map<Character, ItemStack> newIng = new HashMap<>();
        for(String row : shape)
            for (char c : row.toCharArray())
                newIng.put(c, ingredients.get(c));
        ingredients = newIng;

        rows = shape;

        return this;
    }

    /**
     * Sets the Material that a character in the recipe shape refers to.
     *
     * @param key
     *            The character that represents the ingredient in the shape.
     * @return The changed recipe, so you can chain calls.
     */
    public ShapedRegister setIngredient(char key, Material mat) {
        return setIngredient(key, new ItemStack(mat, 1));
    }

    /**
     * Sets the ItemStack that a character in the recipe shape refers to.
     *
     * @param key
     *            The character that represents the ingredient in the shape.
     * @return The changed recipe, so you can chain calls.
     */
    public ShapedRegister setIngredient(char key, ItemStack item) {
        ingredients.put(key, item);
        return this;
    }

    /**
     * Registers the Recipe in the server.
     */
    @SneakyThrows
    public void register() {
        ShapedRecipe sr = new ShapedRecipe(key, output);
        sr.shape(rows);

        Field f = sr.getClass().getDeclaredField("ingredients");
        f.setAccessible(true);
        f.set(sr, ingredients);
        Bukkit.addRecipe(sr);
    }

}
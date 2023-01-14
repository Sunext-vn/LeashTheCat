package vn.sunext.leashthecat.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.leashthecat.LeashTheCat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public static String PREFIX = "";

    public static String RELOAD_PERMISSION = "";
    public static String REFRESH_PERMISSION = "";
    public static String ADMIN_PERMISSION = "";

    public static Boolean MUST_BE_PLAYER_KILL = false;
    public static Boolean ALLOW_OP = false;

    public static Integer TOP_REFRESH_INTERVAL = 0;
    public static Integer TOP_AMOUNT = 0;

    public static Integer LEASH_CAT_DROP_PERCENT = 0;
    public static Integer LEASH_MATERIAL_DROP_PERCENT = 0;

    public static String ITEM_LEASH_CAT_NAME = "";
    public static String ITEM_LEASH_CAT_MATERIAL = "";
    public static Boolean ITEM_LEASH_CAT_GLOW = false;
    public static List<String> ITEM_LEASH_CAT_LORE = new ArrayList<>();

    public static String ITEM_LEASH_MATERIAL_NAME = "";
    public static String ITEM_LEASH_MATERIAL_MATERIAL = "";
    public static Boolean ITEM_LEASH_MATERIAL_GLOW = false;
    public static List<String> ITEM_LEASH_MATERIAL_LORE = new ArrayList<>();

    public static String NO_PERMISSION = "";
    public static String RELOAD_MESSAGE = "";
    public static String REFRESH_MESSAGE = "";
    public static String RECEIVED_POINT_MESSAGE = "";
    public static String FIRST_TOP_ONE_MESSAGE = "";
    public static String NEW_TOP_ONE_MESSAGE = "";

    public void register() {
        File config_file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);

        ITEM_LEASH_CAT_LORE.clear();
        ITEM_LEASH_MATERIAL_LORE.clear();

        PREFIX = config.getString("prefix");

        RELOAD_PERMISSION = config.getString("permissions.reload");
        REFRESH_PERMISSION = config.getString("permissions.  refresh");
        ADMIN_PERMISSION = config.getString("permissions.admin");

        MUST_BE_PLAYER_KILL = config.getBoolean("options.must-be-player-kill");

        ALLOW_OP = config.getBoolean("options.allow-op");

        LEASH_CAT_DROP_PERCENT = config.getInt("drop-percent.leash-cat");
        LEASH_MATERIAL_DROP_PERCENT = config.getInt("drop-percent.leash-material");

        TOP_REFRESH_INTERVAL = config.getInt("options.top-refresh-interval");
        TOP_AMOUNT = config.getInt("options.top-amount");

        ITEM_LEASH_CAT_NAME = config.getString("items.leash-cat.name");
        ITEM_LEASH_CAT_MATERIAL = config.getString("items.leash-cat.material");
        ITEM_LEASH_CAT_GLOW = config.getBoolean("items.leash-cat.glow");
        ITEM_LEASH_CAT_LORE = config.getStringList("items.leash-cat.lore");

        ITEM_LEASH_MATERIAL_NAME = config.getString("items.leash-material.name");
        ITEM_LEASH_MATERIAL_MATERIAL = config.getString("items.leash-material.material");
        ITEM_LEASH_MATERIAL_GLOW = config.getBoolean("items.leash-material.glow");
        ITEM_LEASH_MATERIAL_LORE = config.getStringList("items.leash-material.lore");

        NO_PERMISSION = config.getString("messages.no-permission");
        RELOAD_MESSAGE = config.getString("messages.reloaded");
        REFRESH_MESSAGE = config.getString("messages.refresh");
        RECEIVED_POINT_MESSAGE = config.getString("messages.received-point");
        FIRST_TOP_ONE_MESSAGE = config.getString("messages.first-top-one");
        NEW_TOP_ONE_MESSAGE = config.getString("messages.new-top-one");
    }

}

package vn.sunext.leashthecat;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vn.sunext.leashthecat.commands.MainCommand;
import vn.sunext.leashthecat.events.AddPointEvent;
import vn.sunext.leashthecat.functions.*;
import vn.sunext.leashthecat.hooks.PlaceholderAPI;
import vn.sunext.leashthecat.listeners.JoinEvent;
import vn.sunext.leashthecat.listeners.LeashEvent;
import vn.sunext.leashthecat.listeners.MonsterKillEvent;
import vn.sunext.leashthecat.listeners.PointEvent;
import vn.sunext.leashthecat.managers.*;

import java.util.Objects;

@Getter
public final class LeashTheCat extends JavaPlugin {

    private static LeashTheCat plugin;

    private PathManager pathManager;
    private ItemManager itemManager;
    private RecipeManager recipeManager;
    private FileManager fileManager;
    private TopManager topManager;

    private ColorSystem colorSystem;
    private DropSystem dropSystem;
    private MonsterSystem monsterSystem;
    private InventorySystem inventorySystem;
    private LeashSystem leashSystem;
    private PointSystem pointSystem;
    private MessageSystem messageSystem;
    private PermissionSystem permissionSystem;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        colorSystem = new ColorSystem();

        pathManager = new PathManager();
        pathManager.register();

        itemManager = new ItemManager();
        itemManager.register();

        recipeManager = new RecipeManager();
        recipeManager.register();

        fileManager = new FileManager();
        fileManager.register();

        dropSystem = new DropSystem();
        monsterSystem = new MonsterSystem();
        inventorySystem = new InventorySystem();
        pointSystem = new PointSystem();
        leashSystem = new LeashSystem();
        messageSystem = new MessageSystem();
        permissionSystem = new PermissionSystem();

        topManager = new TopManager();
        topManager.register();

        new PlaceholderAPI().register();

        registerEvents();

        Objects.requireNonNull(getCommand("leashthecat")).setExecutor(new MainCommand());
    }

    private void registerEvents() {
        shortRegEvent(new MonsterKillEvent());
        shortRegEvent(new LeashEvent());
        shortRegEvent(new JoinEvent());
        shortRegEvent(new PointEvent());
    }

    private void shortRegEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, plugin);
    }

    public void callEvent(Event event) {
        getServer().getPluginManager().callEvent(event);
    }

    public static LeashTheCat getInstance() {
        return plugin;
    }
}

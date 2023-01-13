package vn.sunext.leashthecat.managers;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.leashthecat.LeashTheCat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void register() {
        loadFile("database.yml");
    }

    @SneakyThrows
    private void loadFile(String fileName) {
        File database_file = new File(plugin.getDataFolder(), fileName);

        if (!database_file.exists())
            database_file.createNewFile();
    }

    public void setDataInDatabase(String fileName, String key, Object value) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            File database_file = new File(plugin.getDataFolder(), fileName);
            YamlConfiguration database = YamlConfiguration.loadConfiguration(database_file);

            database.set(key, value);

            try {
                database.save(database_file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    @SneakyThrows
    public Object getDataInDatabase(String fileName, String key) {
        File database_file = new File(plugin.getDataFolder(), fileName);
        YamlConfiguration database = YamlConfiguration.loadConfiguration(database_file);

        return database.get(key);
    }

    public List<Object> getListDataInDatabase(String fileName, String key) {
        File database_file = new File(plugin.getDataFolder(), fileName);
        YamlConfiguration database = YamlConfiguration.loadConfiguration(database_file);

        return Collections.singletonList(database.getConfigurationSection(key).getKeys(false));
    }

}

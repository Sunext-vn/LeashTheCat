package vn.sunext.leashthecat.managers;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.leashthecat.LeashTheCat;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class FileManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void register() {
        loadFile("database.yml");
    }

    @SneakyThrows
    private void loadFile(String fileName) {
        File file = new File(plugin.getDataFolder(), fileName);

        if (!file.exists())
            file.createNewFile();
    }

    public void setDataInFile(String fileName, String key, Object value) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            File file = new File(plugin.getDataFolder(), fileName);
            YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

            yaml.set(key, value);

            try {
                yaml.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    @SneakyThrows
    public Object getDataInFile(String fileName, String key) {
        File file = new File(plugin.getDataFolder(), fileName);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        return yaml.get(key);
    }

    public Set<String> getListDataInFile(String fileName, String key) {
        File file = new File(plugin.getDataFolder(), fileName);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        return Objects.requireNonNull(yaml.getConfigurationSection(key)).getKeys(false);
    }

    public Boolean isDataInFileExist(String fileName, String key) {
        return getDataInFile(fileName, key) != null;
    }

}

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

    /*
    * @saveSaving when it true, null value will not be saved.
    */
    @SneakyThrows
    public void setDataInFile(String fileName, String key, Object value, Boolean safeSaving) {
        File file = new File(plugin.getDataFolder(), fileName);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        if (safeSaving)
            if (value == null)
                return;

        yaml.set(key, value);

        yaml.save(file);
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

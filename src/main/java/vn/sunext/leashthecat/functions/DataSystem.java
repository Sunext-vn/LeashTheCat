package vn.sunext.leashthecat.functions;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.FileManager;

import java.util.HashMap;
import java.util.Map;

public class DataSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final Map<String, Integer> tempPlayerData = new HashMap<>();

    public void addTempDataOnJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

        addTempData(playerName);
    }

    private void addTempData(String playerName) {
        FileManager fileManager = plugin.getFileManager();

        if (!hasData(playerName))
            addNewData(playerName);

        if (tempPlayerData.containsKey(playerName))
            return;

        Integer points = (Integer) fileManager.getDataInFile("database.yml", "list." + playerName);

        tempPlayerData.put(playerName, points);
    }

    public void removeTempDataOnQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();

        saveTempData(playerName);
    }

    public void setValueTempData(String playerName, Integer value) {
        if (!tempPlayerData.containsKey(playerName))
            addTempData(playerName);

        tempPlayerData.put(playerName, value);
    }

    public Integer getValueTempData(String playerName) {
        if (!tempPlayerData.containsKey(playerName))
            addTempData(playerName);

        return tempPlayerData.get(playerName);
    }

    public void saveAllTempData(Boolean clearTemp) {
        if (!tempPlayerData.isEmpty())
            tempPlayerData.keySet().forEach(this::saveTempData);

        if (clearTemp)
            tempPlayerData.clear();
    }

    private void saveTempData(String playerName) {
        FileManager fileManager = plugin.getFileManager();

        fileManager.setDataInFile("database.yml", "list." + playerName, tempPlayerData.get(playerName), true);
    }

    private void addNewData(String playerName) {
        FileManager fileManager = plugin.getFileManager();

        fileManager.setDataInFile("database.yml", "list." + playerName, 0, false);
    }

    private Boolean hasData(String playerName) {
        FileManager fileManager = plugin.getFileManager();

        return fileManager.isDataInFileExist("database.yml", "list." + playerName);
    }

}

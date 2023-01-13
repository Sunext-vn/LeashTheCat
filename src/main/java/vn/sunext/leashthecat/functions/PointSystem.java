package vn.sunext.leashthecat.functions;

import org.bukkit.entity.Player;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.events.AddPointEvent;
import vn.sunext.leashthecat.managers.FileManager;

public class PointSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final FileManager fileManager = plugin.getFileManager();

    public void addPoint(Player player, Integer amount) {
        String playerName = player.getName();
        Integer currentPoint = (Integer) fileManager.getDataInFile("database.yml", "list." + playerName);
        Integer nextPoint = currentPoint + amount;

        AddPointEvent addPointEvent = new AddPointEvent(player, currentPoint, nextPoint);
        plugin.callEvent(addPointEvent);

        fileManager.setDataInFile("database.yml", "list." + playerName, nextPoint);
    }

    public Integer getCurrentPoint(String playerName) {
        return (Integer) fileManager.getDataInFile("database.yml", "list." + playerName);
    }

    public void setZeroPointOnFirstJoin(Player player) {
        String playerName = player.getName();

        if (fileManager.isDataInFileExist("database.yml", "list." + playerName)) return;

        fileManager.setDataInFile("database.yml", "list." + playerName, 0);
    }

}
